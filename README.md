# 3-programming
This repository collects implementation of various programming questions

## Print Pyramid
This program is about printing some characters in a pyramid form.

Ex 1: input : abc 10 1
<pre>
         a
        acb
       bcabc
      acbacba
     bcabcabca
    cbacbacbacb
   abcabcabcabca
  acbacbacbacbacb
 bcabcabcabcabcabc
acbacbacbacbacbacba
</pre>

Explanation :
The first argument is what needs to be printed. In each iteration the characters are printed once in forward direction in next in reverse direction. If the characters are completed, it should start from beginning.
The second argument is how many rows to be printed
The third argument is about the direction where 1 indicates the pyramid should be printed upright and -1 indicates pyramid is to be printed downside.

Ex 2: xyz 10 -1
<pre>
xyzxyzxyzxyzxyzxyzx
 zyxzyxzyxzyxzyxzy
  xyzxyzxyzxyzxyz
   xzyxzyxzyxzyx
    yzxyzxyzxyz
     zyxzyxzyx
      xyzxyzx
       zyxzy
        xyz
         x
</pre>
