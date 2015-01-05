#!/usr/bin/perl
#
# Evaluate KillQuickX.pl
#
#	./KillQuickX.pl n | xargs ./QuickX.pl
#	./random.awk n | xargs ./QuickX.pl
#
#	Original Java program
#		http://algs4.cs.princeton.edu/23quicksort/QuickX.java
#
use strict;
use warnings;
$#ARGV < 0 && die "Usage : $0 data\n";
our $TRACE = 1;
@_ = &qsort(@ARGV);
print "@_\n";
my $j = 0;
foreach my $i (@_) {
	$i >= $j || die "Not sorted!\n";
	$j = $i;
}

sub qsort() {
	if ($#_ < 1) {return @_}
#	print "\nqsort(@_)\n";
	my ($pivot, $v);
	my $N = $#_ + 1;
	my $mid = int($#_ / 2);
	if ($N <= 8) {
	$TRACE && print "insertion sort (@_)\n";
		return sort(@_);
	} elsif ($N <= 40) {
		$pivot = &med3(0, $mid, $#_, @_);
		$v = $_[$pivot];
	$TRACE && print "pivot $v is at $pivot in ($_[0],..,$_[$mid],..,$_[$#_]) N = $N\n";
	} else {
		my $eps = int($N / 8);
#	print "N = $N\teps = $eps\n";
		my $m1 = &med3(0, $eps, $eps + $eps, @_);
		my $m2 = &med3($mid - $eps, $mid, $mid + $eps, @_);
		my $m3 = &med3($#_ - $eps - $eps, $#_ - $eps, $#_, @_);
		$pivot = &med3($m1, $m2, $m3, @_);
		$v = $_[$pivot];
	$TRACE && print "pivot $v is at $pivot in ($_[0],..,$_[$eps],......,$_[$#_-$eps],..,$_[$#_-3],$_[$#_-2],$_[$#_-1],$_[$#_]) N = $N\n";
	}
	@_ = &exch(0, $pivot, @_);
	# Bentley-McIlroy 3-way partitioning
	my $i = my $p = 0; my $j = my $q = $#_ + 1;
	while (1) {
		while ($_[++$i] < $v) {last if $i >= $#_}
		while ($_[--$j] > $v) {last if $j == 0}
		$i == $j && $_[$i] == $v && (@_ = &exch(++$p, $i, @_));
		last if $i >= $j;
		@_ = &exch($i, $j, @_);
		$_[$i] == $v && (@_ = &exch(++$p, $i, @_));
		$_[$j] == $v && (@_ = &exch(--$q, $j, @_));
	}
	$i = $j + 1;
	for (my $k = 0  ; $k <= $p; $k++) {@_ = exch($k, $j--, @_)};
	for (my $k = $#_; $k >= $q; $k--) {@_ = exch($k, $i++, @_)};
	$j++;
#	print "list = (@_)\n";
	my @eq = splice(@_, $j, $i - $j);
	my @lt = splice(@_, 0, $j);
#	print "\@lt = (@lt)\n";
#	print "\@eq = (@eq)\n";
#	print "\@gt = (@_)\n";
	return (&qsort(@lt), @eq, &qsort(@_));
}

sub med3() {
	my ($lo, $mid, $hi, @list) = @_;
	return ($list[$lo] < $list[$mid]) ?
		($list[$mid] < $list[$hi] ? $mid : ($list[$lo] < $list[$hi] ? $hi : $lo)):
		($list[$hi] < $list[$mid] ? $mid : ($list[$hi] < $list[$lo] ? $hi : $lo));
}

sub exch() {
	(my $i, my $j, my @list) = @_;
#	print "exch($i, $j, \@_)";
	my $hi = $list[$j];
	my @lo = splice(@list, $i, 1, $hi);
	splice(@list, $j, 1, @lo);
#	print "  @lo <--> $hi\n";
	return	@list;
}
