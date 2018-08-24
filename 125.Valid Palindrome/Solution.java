//125.Valid Palindrome
class Solution {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int left = 0, right = s.length() - 1;
		s = s.toLowerCase();

		while (left <= right) {
			if (!isAlphaNumeric(s.charAt(left))) {
				left++;
				continue;
			}

			if (!isAlphaNumeric(s.charAt(right))) {
				right--;
				continue;
			}

			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	private boolean isAlphaNumeric(char c) {
		return Character.isDigit(c) || Character.isLetter(c);
	}
}