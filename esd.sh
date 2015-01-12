#!/bin/sh
for N in 2000000 4000000 8000000; do
     ./random.awk $N > tmp$$
     for i in `seq 1 10`; do
        java -cp :../sort/princeton/:. $1 < tmp$$ | awk 'NF>1 {print $NF}'
     done | xargs ./esd.awk
 done
