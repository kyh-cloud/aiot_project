# IoT센서와 인공지능을 이용한 이상징후 차단<br> 보안관리 시스템 <br> Security Management System for Abnormal Signs<br> Using IoT Sensors and Artificial Intelligence

## 작품명: 시켜줘! 명예보안관

​	최신 기술이자 화두인 IoT와 인공지능을 융합하여 개발한 차단 보안 관리 시스템. 각종 센서를 통해 화재 징후를 포착하고 이미지 센싱을 통하여 영상을 받아와 데이터 압축률을 높여 장시간 영상 습득, 장기간 보관을 목표로 함.

![image](https://user-images.githubusercontent.com/77868828/114572459-78384f00-9cb2-11eb-820e-78366b1fe138.png)

![image](https://user-images.githubusercontent.com/77868828/114572267-4c1cce00-9cb2-11eb-801c-09b30cf40a62.png)







------

## 서비스 흐름도

![image](https://user-images.githubusercontent.com/77868828/119845390-2c7cf480-bf44-11eb-9813-8a8535c9585c.png)







------

## 기능 처리 흐름도

![image](https://user-images.githubusercontent.com/77868828/119845470-3ef72e00-bf44-11eb-8401-3d5ac6b2925f.png)







------

## H/W 기능 실사 사진


![image](https://user-images.githubusercontent.com/77868828/119847326-d9a43c80-bf45-11eb-8664-a539403521a6.png) 

> 동작중인 스마트홈

<br>

![image](https://user-images.githubusercontent.com/77868828/119847677-24be4f80-bf46-11eb-8f94-e87c59a8c0e7.png) 

> 화재알람 부저

<br>

![image](https://user-images.githubusercontent.com/77868828/119847221-c3967c00-bf45-11eb-9fd6-26bdd009140a.png) 

> 티비근처에 부착된 웹캠

<br>

![image](https://user-images.githubusercontent.com/77868828/119957921-7bc33380-bfdd-11eb-833a-be913a2b40ad.png)

> 이상 징후가 발견되면 LED에 불이 들어오고 부저가 울리면서 창문이 열림(화재대응)

<br>





------

## S/W 기능 실사 사진

![image](https://user-images.githubusercontent.com/77868828/119925316-2de40680-bfb0-11eb-8c59-8f09e212fe36.png)

> 통신 데이터 확인시 사용하는 안드로이드 애플리케이션

<br>



------

## 핵심기술

### Edge Detection

> **Edge**는 경계선, 윤곽선을 의미함. 영상에서의 edge란 <u>영상의 밝기가 낮은 값에서 높은 값으로, 또는 이와 반대로 변하는 지점에 존재하는 부분</u>을 가리킴.

<br>

<img src="https://user-images.githubusercontent.com/77868828/119958113-af05c280-bfdd-11eb-8ee1-929ecc6f22b6.png" alt="image" style="zoom:50%;" />

> 회색조 사진과 edge 검출된 사진	

<br>

​	영상에 edge 검출 영상처리 기술을 적용함으로써 침입자가 발생하는 시간 외에는 물체끼리 비교할 수 있을 정도로의 화질로 영상을 저장함. Edge 검출 과정은 우선 영상을 위 그림과 같이 회색조(gray scale)로 처리함으로써 흑백 이미지로 바뀌기 때문에, 영상에 쓰이는 화소 하나에 소모되는 데이터 용량을 1/3로 줄일 수 있으며, 추후 edge 검출 기술을 적용함에 있어서 간단해짐. 회색조 이후, edge 검출을 이용하면 기존 이미지의 데이터 양 대비 90%를 감소시킬 수 있다.
![image](https://user-images.githubusercontent.com/77868828/119967263-1ffda800-bfe7-11eb-8c89-bd28ef32f1c8.png)


------

## 참고 자료

[![img](https://i.ytimg.com/vi/y4LqNpQbxbw/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDHUW2RGRINR3dTIt5sT1Ii6WRG6A)](https://youtu.be/y4LqNpQbxbw)

> 시연 영상

<br>

[![img](https://i.ytimg.com/vi/Yr7IuwVMAO8/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBsZxYDN1EV8PYESmjVOkEOtZnq1g)](https://youtu.be/Yr7IuwVMAO8)

> PPT 발표 영상

