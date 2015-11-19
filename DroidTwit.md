
# Introduction #

DroidTwit Twitter Reference Implementation Explained

This is an Implement of Android Twitter client. This is a reference implementation showcasing how to use all the components of Android to create a Twitter client.

[Rohit Ghatol](http://www.linkedin.com/in/rohitghatol) and [Saurabh Gangarde](http://www.linkedin.com/in/saurabhgangarde) are the lead developers of this project. Both of them work for [QuickOffice](http://quickoffice.com) and [Synerzip Softech](http://www.synerzip.com).

This Reference Implementation is build to train developers in Pune for one of the [TechNext](http://meetup.com/TechNext) Technical Talks.


# Features #
The Android Client uses

  * Alarm Manager to repeatedly fetch tweets from Twitter
  * There is a back ground service for fetching twits and storing it in database
  * There is use of OAuth for authentication
  * Notification Manager is used for notifying users about newer twits
  * Battery Drain is monitored and Twitter Service is closed to help save battery, and when battery is charged then again Twitter Service is started. (Yet to be implemented- Coming soon)
  * In UI side we use shapes and drawable states for background and button images

# Download Demo APK #

**Disclaimer:** Since the application is under development and not gone through entire QA cycle, there could be some crashes in the application. We are striving hard to get you a stable version soon. Meanwhile please focus on the application architecture.

Please Download our apk from http://droidtwit.googlecode.com/files/DroidTwit.apk and try it.


# Demo Video #
<a href='http://www.youtube.com/watch?feature=player_embedded&v=XhCZpxWDtx0' target='_blank'><img src='http://img.youtube.com/vi/XhCZpxWDtx0/0.jpg' width='425' height=344 /></a>

# Screenshots #
![http://droidtwit.googlecode.com/files/Screenshot-1.png](http://droidtwit.googlecode.com/files/Screenshot-1.png)
![http://droidtwit.googlecode.com/files/Screenshot-2.png](http://droidtwit.googlecode.com/files/Screenshot-2.png)
![http://droidtwit.googlecode.com/files/Screenshot-3.png](http://droidtwit.googlecode.com/files/Screenshot-3.png)
![http://droidtwit.googlecode.com/files/Screenshot-4.png](http://droidtwit.googlecode.com/files/Screenshot-4.png)
![http://droidtwit.googlecode.com/files/Screenshot-5.png](http://droidtwit.googlecode.com/files/Screenshot-5.png)
![http://droidtwit.googlecode.com/files/Screenshot-6.png](http://droidtwit.googlecode.com/files/Screenshot-6.png)
![http://droidtwit.googlecode.com/files/Screenshot-7.png](http://droidtwit.googlecode.com/files/Screenshot-7.png)
![http://droidtwit.googlecode.com/files/Screenshot-8.png](http://droidtwit.googlecode.com/files/Screenshot-8.png)
![http://droidtwit.googlecode.com/files/Screenshot-9.png](http://droidtwit.googlecode.com/files/Screenshot-9.png)


# Architectural Diagrams #

**Proposed Architecture**

---

## Screen Flow ##
![http://droidtwit.googlecode.com/files/Slide2.png](http://droidtwit.googlecode.com/files/Slide2.png)


---

## Overall Architecture ##
Note Phone Boot Receiver, Low Battery Receiver and Alarm Receiver are all Android BroadCast Receiver.
![http://droidtwit.googlecode.com/files/Slide3.png](http://droidtwit.googlecode.com/files/Slide3.png)


---

## OAuth Authentication ##
![http://droidtwit.googlecode.com/files/Slide4.png](http://droidtwit.googlecode.com/files/Slide4.png)


---

## First Time Launch ##
![http://droidtwit.googlecode.com/files/Slide5.png](http://droidtwit.googlecode.com/files/Slide5.png)


---

## Activity Asking Service to fetch tweets ##
![http://droidtwit.googlecode.com/files/Slide6.png](http://droidtwit.googlecode.com/files/Slide6.png)


---


## Alarm Manager Triggering Service every n minutes ##

![http://droidtwit.googlecode.com/files/Slide7.png](http://droidtwit.googlecode.com/files/Slide7.png)

---


## When Phone Boots, Broadcast Receiver registers Alarm Manager and Battery Broad Cast Receiver ##
![http://droidtwit.googlecode.com/files/Slide8.png](http://droidtwit.googlecode.com/files/Slide8.png)

---


## Battery Broad Cast Receiver controls Alarm Manager ##
![http://droidtwit.googlecode.com/files/Slide9.png](http://droidtwit.googlecode.com/files/Slide9.png)


---
