from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        final = []
        for i in range(n):
            if (i >0 and nums[i] == nums[i-1]):
                continue
            for j in range(i+1, n):
                if (j != i+1 and nums[j]== nums[j-1]):
                    continue
                k = j+1
                l = n-1
                while k < l :
                    sum = nums[i] + nums[j] + nums[k] + nums[l]
                    if sum < target:
                        k += 1
                    elif sum > target:
                        l -=1                    
                    else:
                        final.append([nums[i], nums[j] , nums[k], nums[l]])
                        while (k < l and nums[k+1] == nums[k]):
                            k+=1
                        k+=1
                        while (k < l  and nums[l-1] == nums[l]):
                            l-=1
                        l-=1
        return final    

s = Solution()
print(s.fourSum([-3,-2,-1,0,0,1,2,3], 0))

