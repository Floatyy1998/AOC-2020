
  
def memory(nums, turns):
    num_dict = {num: counter + 1 for counter, num in enumerate(nums[:-1])}
    last = nums[-1]
    for i in range(len(nums), turns):
        if last in num_dict:
            new = i - num_dict[last]
        else:
            new = 0
        num_dict[last] = i
        last = new
    return last



nums = [9,12,1,4,17,0,18]
import timeit
print(memory(nums, 2020))
print(timeit.timeit("memory(nums, 30000000)", number=1, globals=locals()))
print(memory(nums, 30000000))