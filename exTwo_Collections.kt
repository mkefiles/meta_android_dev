/*
* LESSON:
* -> Working with collections
* 
* SCENARIO:
* -> You have a 'forum' for coders where a user can create a post and there can be comments.
* -> In this example there is one post that has comments on it.
* -> IF a user is a 'blocked' user, then their comment does not show.
* -> IF a user is not 'blocked' and they have a relationship show the relationship and comment.
* -> IF a user is not 'blocked' and they don't have a relationship show the comment
*
*/

// a simple 'data' class to build the Comment object
data class Comment(var userId: Int, var message: String)

// examples comments with user id and the comment itself
var comments: List<Comment> = listOf<Comment>(
    Comment(5241, "Nice code"),
    Comment(6624, "Like it"),
    Comment(5224, "What's going on?"),
    Comment(9001, "Check out my website"),
    Comment(8818, "Hello everyone, :)")
)

// blocked users listed by user id
var blockedUserIds: Set<Int> = setOf<Int>(5224, 9001)

// relationship of users by id
var userIdToRelation: Map<Int, String> = mapOf<Int, String>(
    5241 to "Friend",
    6624 to "Work Colleague"
)

fun main() {
    // iterate over the comments
    for (comment in comments) {
    	// if the user is not in the blocked collection then...
        if (comment.userId !in blockedUserIds) {
        	// check their relationship and output appropriate message
            if (comment.userId in userIdToRelation) {
                println("${userIdToRelation[comment.userId]} said, ${comment.message}")
            } else {
                println("Guest said, ${comment.message}")
            }
        }
    }
}