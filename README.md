# Hi

##Runtime Assessment

  When the pivot is the midpoint and the array is already sorted: nlogn

  When the pivot is random and the array is random: nlogn

  When the pivot is the first element and the array is sorted in reverse order: n^2
  
##Pivot Selection
![alt text](https://github.com/MrEricL/Hi/blob/master/Screen%20Shot%202017-03-09%20at%2010.45.43%20PM.png "Tries")

The random pivot finished substatially quicker than finding a median, or picking the first element of the array as the pivot.


##Methodology

  The class QuickSortTester runs quicksort against arrays of 1000, 5000, 10000, 50000, and 100000 elements. Trials are timed; the program runs the sort 100 times on each array size before averaging the times for each array. This data is collected and recorded before being graphed. The graph is then compared to the standard Big O graphs to figure out its efficiency.

##Statistics

[Statistics] (https://docs.google.com/spreadsheets/d/1e8wGCLjfmtRjAAXwRROXX8_vA4Enn-scRpGk7p2-61c/edit?usp=sharing).

##Analysis

  Based off of the graphs that we constructed, it appears as thought the best and average case scenarios were as we predicted, which was an nlogn runtime. These graphs closely resemble the graph of nlogn runtime. Our results for the worst case scenario, as we weren't able to get measurements for the same data points as we were for the best and average cases. However, the graph does still somewhat resemble an n^2 runtime, and might even be greater than that.
