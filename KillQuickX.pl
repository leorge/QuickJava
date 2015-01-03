#!/usr/bin/perl
#
# generate a bad data for QuickX.java
#
use strict;
use warnings;
$#ARGV < 0 && die "Usage : $0 count\n";
my $n = shift(@ARGV);	# count
my $fmt = sprintf "%%0%dd\n", log($n) / log(10) + 1;
my @insert = (7, 6, 5, 4, 3, 2, 1);	# bad data for insertion sort
my @list;
if ($n <= $#insert + 1) {@list = splice(@insert, 0, $n)}
elsif ($n <= 40) {@list = ($n, @insert, 8..$n-1)}	# median-of-3 killer
else {
	my $N = 40;
	@list = ($N, @insert,8..$N-1);
	do {
		$N += 4;	# add 4 elements
		my $eps = int($N / 8);
		my @x = splice(@list, 0, 1, $N - 2);
		my @z = splice(@list, $eps, 1, $N - 1);
		my @y = splice(@list, $N - $eps - 1, 1, $N);
		push(@list, (@x, @y, @z, $N - 3));
	} while ($#list + 1 < $n)
}
foreach my $i (@list) {printf $fmt, $i;}
