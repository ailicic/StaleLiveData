# StaleLiveData
An example project to demonstrate conditions under which LiveData emissions are stale.

<b>Example 1</b>
- Press OBSERVE
- Press UNOBSERVE
- Press ADD
- Press OBSERVE

See in the log that two emissions are fired: One for the stale empty list and a second for the correct list with one element

<b>Example 2</b>
- Press OBSERVE
- Press ADD
- Press UNOBSERVE
- Press DELETE
- Press OBSERVE

See in the log that two emissions are fired: One for the stale list containing one element and a second for the correct empty list
