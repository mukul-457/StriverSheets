import heapq
class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @param C : integer
    # @return a list of integers
    def solve(self, A, B, C):
        A.sort(reverse=True)
        B.sort(reverse=True)
        n = len(A)
        ans = []
        heap = [((A[0]+B[0])*-1  , 0, 0)]
        done = set()
        done.add((0,0))
        while C :
            next_ele = heapq.heappop(heap)
            ans.append(next_ele[0]*-1)
            i = next_ele[1]
            j = next_ele[2]
            if i+1< n and j+1< n and (i+1,j+1) not in done:
                heapq.heappush(heap ,((A[i+1]+B[j+1])*-1, i+1, j+1))
                done.add((i+1,j+1))
            if i+1 < n and (i+1, j) not in done : 
                heapq.heappush(heap ,((A[i+1] + B[j])*-1, i+1, j ))
                done.add((i+1, j))
            if j+1 < n and (i,j+1) not in done:
                heapq.heappush(heap, ((A[i]+B[j+1])*-1, i, j+1))
                done.add((i,j+1))
            C -= 1
        return ans

s = Solution()
ans =s.solve([ 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83 ], 
            [ 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83 ], 10)
#ans = s.solve([4,3,2,1], [100,4,3,2],4)
print(ans)