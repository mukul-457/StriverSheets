from typing import List
import sys
sys.setrecursionlimit(100000)

class LC:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = {m:1 for m in nums}
        max_len = 0
        for n in nums:
            leng= s[n]
            if leng != 1 :
                continue
            leng = self.find_len(n , s)
            max_len = max(leng, max_len)
        return max_len

    def find_len(self, n, s):
        if n not in s:
            return 0
        if s[n] >  1:
            return s[n]
        s[n]  = 1 + self.find_len(n+1,s)
        return s[n]
