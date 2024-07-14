class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m = {}
        start = 0 
        end = 0 
        ans  = 0
        for i in range(len(s)):
            if s[i] in m:
               start = max(start, m[s[i]] + 1)
            m[s[i]] = i
            end = i
            leng = end-start + 1
            ans = max(leng, ans)
        return ans