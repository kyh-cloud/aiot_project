# IoT센서와 인공지능을 이용한 이상징후 차단 보안관리 시스템 <br> <br>Security Management System for Abnormal Signs Using IoT Sensors and Artificial Intelligence

### 작품명: 시켜줘! 명예보안관

​	최신 기술이자 화두인 IoT와 인공지능을 융합하여 개발한 차단 보안 관리 시스템. 각종 센서를 통해 화재 징후를 포착하고 이미지 센싱을 통하여 영상을 받아와 데이터 압축률을 높여 장시간 영상 습득, 장기간 보관을 목표로 함.

![image](https://user-images.githubusercontent.com/77868828/114572459-78384f00-9cb2-11eb-820e-78366b1fe138.png)

![image](https://user-images.githubusercontent.com/77868828/114572267-4c1cce00-9cb2-11eb-801c-09b30cf40a62.png)



#### 서비스 흐름도

![image-20210527233100514](C:\Users\go23m\AppData\Roaming\Typora\typora-user-images\image-20210527233100514.png)



#### 기능 처리 흐름도

![image-20210527231732089](C:\Users\go23m\AppData\Roaming\Typora\typora-user-images\image-20210527231732089.png)

1.  **데이터 수집**

   카메라 및 센서를 통해 데이터를 수집

   

2. **데이터 정렬**

   수집된 데이터를 카테고리(온도, 습도, 일산화탄소 농도)별로 정렬

   

3. **데이터 분석**

   데이터의 변화를 분석하여 이상변화를 감지

   

   <img src="C:\Users\go23m\Documents\Hanium\최종폴더\한이음_최종자료\한이음_AIoT\한이음 AIoT 이미지\KakaoTalk_20201026_183042461_02.jpg" alt="KakaoTalk_20201026_183042461_02" style="zoom: 33%;" />

   

   <img src="C:\Users\go23m\Documents\Hanium\최종폴더\한이음_최종자료\한이음_AIoT\한이음 AIoT 이미지\이상징후사진.jpg" alt="이상징후사진" style="zoom:33%;" />

   <이상 징후가 발견되면 LED에 불이 들어오고 부저가 울리면서 창문이 열림(화재대응)>

   

4. **데이터 처리**

   찾아낸 이상변화를 이용하여 어떤 카테고리 및 구역에서 문제가 발생했는지 데이터를 처리

   

5. **실시간 전송**

   데이터 처리가 끝난 후 관리자에게 이상징후 내용 전송

   

6. **반복**

   특정시간 동안 시스템반복(예시: 00시 ~ 06시)



#### H/W 기능 실사 사진

![image-20210527231224133](C:\Users\go23m\AppData\Roaming\Typora\typora-user-images\image-20210527231224133.png) 

<동작중인 스마트홈>



![image-20210527231417847](C:\Users\go23m\AppData\Roaming\Typora\typora-user-images\image-20210527231417847.png) 

<화재알람 부저>



![image-20210527231453163](C:\Users\go23m\AppData\Roaming\Typora\typora-user-images\image-20210527231453163.png) 

<티비근처에 부착된 웹캠>



