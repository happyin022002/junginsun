/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendBCImpl.java
*@FileTitle : Edi315SendBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-10-01 전병석
* 1.0 최초 생성
* SCE_EDI_SEND_PRC Revision History    
    2006-10-01:장인호 - 최초생성.    
    2007-03-05:장인호 - EDI STS로 전송 하던 사항을 COP Activity가 추가 되어서 한번더 전송 로직을 호출 해야 한다.   
    2007-08-08:장인호 - 'VDL'이나 'VDT'전송시 동시에 전송 하는 'VED', 'VET' 전송시  해당 Activity를 찾아서 Estimate date를 전송 한다.   
    2007-09-04:장인호 - Actual Interface에서 직접 전송 받은 Actual에 대하여 Cop Detatil에  관계없이 EDI 전송은 한다.   
					  Call_from  : DIR-ID-20070904-seq format으로 전달 받는다.   
    2007-09-17:장인호 - Manual 전송시 단순 Save를 처리하기 위하여 call from에 'LOG' 추가   
    2007-11-07:장인호 - ACL, AVL은 local, ACN, AVN은 rail만 전송   
    2007-11-15:장인호 - AOL(UV+OB) local에서만, AON(NT+OB) rail에서만 전송   
    2007-11-20:장인호 - VDL, VDT전송시 VE정보는 전부 VE로 전송    
    2007-12-04:장인호 - cop header 정보 조회시 por, del conti 조회 후 전송        
    2007-12-06:장인호 - 변수(v_org_edi_sts)추가로  java에서 중복 전송을 막기 위해서 구분자로 쓰기 위해서 사용   
    2007-12-11:장인호 - UVT/UVD 발생시 앞선 VAT/VAD가 전송 되었는지 확인하여 미발생인 경우 전송 한다.   
    2007-12-14:장인호 - AFL(UVD+CR), AFN(NT+CR) 추가   
    2007-12-17:장인호 - NT 전송시 COP 최종 ARN(최종 FIRRAD) location과 동일한 경우만 발생   
    2007-12-26:장인호 - dtl_seq 자리수 증가 3 -> 5   
    2008-02-13:장인호 - VE 전송시 VD 전송   
    2008-03-13:장인호 - AMS Manual 전송 시 입력 받은 container 만 전송   
    2008-12-08:김인수 - UVT/UVD 발생시 앞선 VAT/VAD 가 전송 되지만 Water 구간이 아닐 경우 전송되지 않는다.   
    2009.05.21:yjlee- MT mvmt 이외의 COP Close경우에 'CX' Status EDI 전송      
    2009.06.24:yjlee- 삼성전자의 경우 T/S 후 Rail/Truck으로 DEL 까지 운송 되는 경우가 있는데,(현장에서 C/A를 끊는것을 지양함)   
					    이경우 VD MVMT가 미 존재 하게 되어 POD지역에 들어온 IC를 VD로 대체 전송.  N200906150140   
    2009.07.02:yjlee- 2009.06.24 일 반영 로직을 타야 하는 화주 추가. N200906250050   
    2009-07-31:JSAN - N200906230045 Split 05-Customer EDI Setup - RFA No 추가       
    2009-10-26:hkoh - CHM-200901401 Electrolux(COM01579)에게 315 전송 시 Container의 Movement가 Event 발생 순서대로 전송되지 않는 문제 발생시
                         2009.06.26 VDL 발생시 AEL 미발생이면 EDI 전송
                                    UVD 발생시 VAD 미발생이면 EDI 전송

*SCE_EDI_COMMON_PRCRevision History   
    2006-10-01:신용천:최초생성.   
    2007-03-05:신용천:LOG 및 FLAT 파일 생성 error 처리후 윗단계로 넘어가는 로직 추가.   
    2007-03-05:장인호:cop activity 추가, 즉 edi sts와 cop activity 둘다 전송 할 수 있음   
    2007-09-05:장인호:DIR로 interface 받은 data에 대하여 처음과 마지막 구분아혀 전송하는 로직 보완   
    2007-09-17:장인호:in_act_rcv_if_key값에 'LOG'로 interface 받은 data에 대하여 단순 logging data로 처리   
    2007-11-05:장인호:Manual로 전송되는 sts에 대하여 custormer sts까지 조건에 반영하여 한가지만 전송   
    2007-11-19:장인호:화주별 전송 logic 추가(NIKE, TOYS R US)   
    2007-11-22:장인호:화주별 전송 logic 추가(PHILIPS)   
    2007-11-27:edi 전송 sts별 current vvd를 선별해서 전송   
    2007-11-30:Manual로 전송 하는 sts에 대해서는 db상에 단순 저장으로 등록되어 있어도 무시하고 LOG즉 save버튼으로   구분해서 전송여부를 결정 한다.    
    2007-12-04:장인호 - conti를 전송 받아 logic에 적용   
    2007-12-05:장인호 - customer, bkg_no, cntr_no, stnd_sts_cd, cust_sts_cd, node, event_dt가 동일할 경우 전송 불가 .Manual 전송 제외   
    2007-12-11:장인호 - 가짜로 만들어내 VA?에 대하여 중복 checking 을 한다.   
    2007-12-14:장인호 - AFL(UVD+CR), AFN(NT+CR) 추가   
    2007-12-17:장인호 - NIKE(USA00069) EDI_STS = 'D' : Manual 전송   
    2007-12-17:장인호 - Status "OAN" : 최종 OAN (Last OAN) 인식시 로직 수정    
                        => COP 상의 최종 Out-gate activity 와 일치 OR MVMT Status 가 "ID" 인 경우    OAN (Not last) 로직    
                        => COP 상의 최종 Out-gate activity가 아님 AND MVMT Status 가 "ID" 가 아님    
    2007-12-20:장인호 - 11/19일 nike, toys r us 추가 로직 삭제   
    2007-12-20:장인호 - 삼성전자 ITTS 예외 사항 추가   
                        1. GRP ID : ASA00130   
                           UVD=CP012 : POD=DEL  일때만 UVD=CP012 적용   
                           OAN=CP012 : POD<>DEL 일때만 OAN=CP012 적용   
                        2. GRP ID : ASA00409   
                           VAD=CP012 : POD=DEL 일때만 VAD=CP012 적용   
                           OAN=CP012, POD<>DEL 일때만 OAN=CP012 적용   
    2008-01-11:장인호 - VE전송시 VDL을 확인하여 있으면 전송.   
    2008-01-14:장인호 - edi_grp_cust에서 del_mk와 cargo관련 전송 여부 확인 추가   
    2008-01-18:장인호 - manual 전송이라 하더라도 edi_snd_flg에 의존 하여 edi 전송   
    2008-02-11:장인호 - manual 전송에 대하여 interval time 적용 제외   
    2008-02-15:장인호 - 중복 전송 logic 수정(1.SKIP, 2.VE checking)   
    2008-02-25:장인호 - 더불어 자동되는 sts에 대한 전송 여부를 checking 한다.(v_auto_snd_flg)   
    2008-05-02:장인호 - Rly-port vessel 정보 제 정의   
                        1. VDL              -> 바로 다음 port   
                        2. VAT,UVT,AET,VDT  -> Event Loc   
                        3. VAD,UVD          -> 바로 전 portLast VSL Port   
                        4. VE               -> 무조건 Last VSL Port   
    2008-05-20:장인호 - USA00069 / NIKE (USA I/B)와 USA00214 / NIKE (CANADA I/B)에 대하여 
    				  RLN발생시 앞서 ALN이 발생하지 않았을 경우에만 전송    
	 				    만일 ALN 이 발생한 경우 RLN 이 발생하더라도 전송하지 않음    
    2008-06-25:김상현 - EUR00188, EUR00189, EUR00190, EUR00191 해당 화주에 OAN Status 전송시 bkg_bkg_misc(tab) 에 sony_inv_desc 값이 'N' 일경우 315 전송 SKIP   
                       => sony_inv_desc 값이 'Y'일때만 전송하고 나머지는 SKIP   (2008-07-18 김상현)   
    2008-08-07:김상현 - group_Id : USA00285 일 경우 로직 추가   
                      a> Status = 'VAD' Customer Status = 'X1'는  Local shipment 경우만 전송   
                      b> Status = 'ARN' Customer Status = 'X1'는  Rail shipment  경우만 전송                              
    2008-11-20:신범철 - Event SEQ = 1 ('First')인 경우, COP상의 첫번째 Status라도 기전송여부를 Check하여 기전송시 SKIP   
    2008-11-20:신범철 - Group_Id : USA00303 일 경우 로직 추가   
                       OAN 발생시 이전 RLN 발생여부를 Check, RLN 전송기록이 있을 경우 OAN 은 전송하지 않는다.   
                       RLN 발생시 이전 OAN 발생여부를 check, OAN 전송기록이 있을 경우 RLN 은 전송하지 않는다.   
    2009-03-02:yjlee  - 315 전송시 Receiver ID 가 CARGOSMART 일 때 BKG VIA 혹은 SI VIA 가 'C' 가 아닌 shipment 에 대해서는 315 전송 Blocking.   
                      - Group ID USA00269, USA00085, USA00248, USA00179 는 제외    
                      - Manual 전송일 경우는 제외   
    2009-04-13:yjlee  - nike ('USA00069','USA00133','USA00214') 화주의 경우    
                      - 이전 전송 되었던 AG 가 없거나, 매 Status 전송 시마다 이전 AG를 비교하여 24시간 이상 차이 나면 AG 재 전송.   
    2009.06.24:yjlee  - 삼성전자의 경우 T/S 후 Rail/Truck으로 DEL 까지 운송 되는 경우가 있는데,(현장에서 C/A를 끊는것을 지양함)   
	 					이경우 VD MVMT가 미 존재 하게 되어 POD지역에 들어온 IC를 VD로 대체 전송.     
						이 PRC엔 삼성과 삼성아닌 화주 존재 시 대체 전송 하는 화주와 IC->IC로 전송 하는 화주를 구분 하는 로직 존재. - N200906150140                
    2009.07.02:yjlee  - 2009.06.24 일 반영 로직을 타야 하는 화주 추가. N200906250050   
    2009.07.31:jsan   - N200906230045 Split 05-Customer EDI Setup - RFA No 추가       
    2009.08.28:hkoh   - NIKEnike ('USA00069','USA00214') 화주의 경우 delivery term이 CY , Trunk VVD, US 인경우 VAD만 전송   
    2009.10.20:hkoh   - 315 전송시 Receiver ID 가 CARGOSMART 일 때  Group ID USA00292 일때 315 자동전송
    2009-10-26:hkoh   - CHM-200901401
                        Electrolux(COM01382)에게 315 전송 시 Container의 Movement가 Event 발생 순서대로 전송되지 않는 문제 발생시
                        2009.06.26 VDL 발생시 AEL 미발생이면 EDI 전송
                                   UVD 발생시 VAD 미발생이면 EDI 전송
    2009.11.10:hkoh   - CHM-200901529 Cargosmart- Gibson 315 하드코딩
                        315 전송시 Receiver ID 가 CARGOSMART 일 때  Group ID COM01824 일때 315 자동전송    
    2009.11.18:hkoh   - CHM-200901586 Cargosmart- Top Ocean Consolidation Service Limited 315 하드코딩     
                        315 전송시 Receiver ID 가 CARGOSMART 일 때  Group ID ASA00444 일때 315 자동전송   
    2009.11.30:hkoh   - CHM-200901666  Target 315 수정
                        USA00094 화주  Rail 운송구간이 존재하는 Booking 에한정하여 마지막 OAN(last out-gate)만 전송하고 그 외의 경우는 모든 OAN 전송    
                        POD가 US, CA인 지역으로 제한  
    2010.01.22:hkoh   - CHM-201002309 CARGOSMART 315 전송예외 화주 추가요청
                        'USA00298', 'USA00313'
                        2010.01.26 Live 반영   

* SCE_EDI_SEND_FLAT_PRC Revision History
   2006-12-01:신용천:최초생성.
   2007-02-23:장인호:변수 size변경 및 소스 정리
   2007-05-13:장인호:log_2 호출 procedure 변수 변경
   2007-05-23:장인호:bkg_nbr에 bkg_no_split 추가
   2007-09-11:장인호:ACT_RCV_IF에 EDI sending 여부를 update 하기 위해 수정
   2007-09-13:장인호:PO_NO별로 전송하는 Wall Mart에 대하여 동일 po_no는 전송하지 않는다.
   2007-11-27:장인호:current vvd 생성 logic 수정
   2007-11-29:장인호:pre, post rly port 생성 logic 수정
   2007-12-06:장인호:doc procdure에서 cre_id대신 org_edi_sts_cd를 사용해서 전송 구분자로 활용한다
   2007-12-13:장인호:current vvd 관련 prefix추가
   2007-12-27:장인호:POR ETD구하는 logic에서 location check하는 부분 삭제
   2008-01-03:장인호:삼성전자(ASA00130, ASA00409) POD ETA 값을 UV ETA 값으로 변경
   2008-01-08:장인호:AMS의 key 저장
   2008-01-08:장인호:current vvd가 없을 경우 Trunk VVD를 사용 한다.
   2008-02-01:장인호:LLOYD_NO가 'T.B.N.'일 경우 'TBN'로 전송
   2008-02-01:장인호:USA00226 - P/Up # 추가
					USA00196 - IT # 추가
   2008-02-11:장인호:manual 전송에 대하여 interval time 적용 제외
   2008-02-19:장인호:input parameter중 nod - > org_yard_cd 변경
   2008-03-13:장인호:Lowes에 대하여 Final Rail Ramp Arrival 정보 전송
   2008-05-02:장인호:Rly-port vessel 정보 제 정의
					1. VDL              -> 바로 다음 port
					2. VAT,UVT,AET,VDT  -> Event Loc
					3. VAD,UVD          -> 바로 전 portLast VSL Port
					4. VE               -> 무조건 Last VSL Port
   2008-05-26:장인호:Pantos 315 / ASA00120
					Booking No 에 2자리 split digit 이 포함되어 있는 경우
					B/L No를 2자리 split digit을 뺀 최초 Booking의 B/L No로 Flatfile 생성 　
   2008-06-09:김상현: ATD,ATA 값 설정 해서 FlatFile 추가
   2008-06-12:김상현: MEA_UNIT, MEA_QTY, SH_REF_NBR,FW_REF_NBR 값 FlatFile 추가
   2008-06-26:김상현: FlatFile 중에 e_cust_no 가 null 일 경우 SC_NO 를 뿌려주는 로직 추가
   2008-08-07:김상현: 'USA00285'이 화주 일 경우
                      a> Local shipment 경우 'CUST_EDATE' 항목에 Local_shipment_POD||POD ETA(FUWMAD, FUVMAD) 값 입력
                      b> Rail shipment 경우 'CUST_EDATE' 항목에 Rail shipment_Location||Final Rail ETA(FIRRAD) 값 입력
   2008-09-11:김상현: 'ASA00120' 화주 일 경우 Booking이 Split되었고 Split된 Booking의 Creation Date가
					  On Board Date 이후인 경우에만 Split 이전의 Original Booking의 BL No를 사용.
   2008-12-11:김인수: 'USA00051' edi group (Customer Trade Partner ID : 003897733 .. HP (US I/B 315) ) 에 대해, 
   					  ESD084-0001 interface 를 통해 NIS (ENT) 에서 받은 Ship ID 및 Partner No 를 flat file 에 add 하여 준다.
   2009-05-27:yjlee: IRG_INFO 부분의 Logic보완 N200905200080 
   					  과거엔 NIS MVMT에 있던 대로 ATB시간을 기반으로 추정 했지만
					  이젠 SCEM DATA를 이용하여 I/B Inland구간의 ORG Arrival, Departure DEST의 Arrival 시간을 Flatfile에 내린다.
   2009-08-20:yjlee: getPODDtInfo의 POD 의 Arrival, Departure Date산출 로직 변경. CHM-200900502
   2009-09-08:hkoh : 'ASA00435'화주인 경우 container 별 weight, unit 정보 추가한다.
   2009-11-04:hkoh : 'VAD' 발송시 PODATA, PODATD 누락되는 경우 발생.
                     VESSEL인 경우 ATB DATA 없는 경우 VAD의 ACT_dT 사용. getPODDtInfo 변경
   2010-01-22:hkoh : CHM-201002317
                     USA204 (ACER) - UV부터 이후 sts 발생시 actual 정보가 없는경우 Estimated date/time을 조회하여 EDI F/F 생성하지말고 139 qualifier 를 써서 Estimate으로 표기
                     2010.02.04 LIVE 반영

* SCE_EDI_DOCUMENT_PRCRevision History  
   2006-12-01 : 신용천 : 최초생성.  
   2007-03-05 : 장인호 : COP Activity 추가로 인한 보완 
   2007-09-11 : 장인호 : Direct로 받은 Actual에 대하여 Actual RCV IF Table에 EDI SEND MARK = 'Y'처리 
   2008-01-16 : 장인호 : VE STS일 경우 COP Detail을 update하지 않는다. 

 
* SCE_EDI_LOG_1_PRC Revision History 
   2006-12-01 : 신용천 : 최초생성. 
   2007-05-13 : 장인호 : Max SEQ => Sequence를 통한 채번
   2007-05-13 : 장인호 : act_rcv_dt primary key 추가

 
* SCE_EDI_LOG_2_PRC Revision History 
   2006-12-01 : 신용천 : 최초생성. 
   2007-02-28 : 장인호 : result table에 vvd 추가
   2007-03-05 : 신용천 : log에 table name 추가
   2007-05-13 : 장인호 : act_rcv_dt primary key 추가
   2007-11-23 : 장인호 : send result table에 vvd 추가
   2007-11-30 : 장인호 : send result table에 LOCAL 전송 시간 추가
   2008-01-15 : 장인호 : 진행중 bkg의 vvd가 변경되는 경우 기존에 변경 전으로 입력된 vvd를 변경 후의 vvd로 update 한다.


* SCE_EDI_LOG_3_PRC Revision History 
   2006-12-01 : 신용천 : 최초생성.
* 
* 
* 
* 
* 
* 
* 
* 
* 2010-05-07 : YJLEE : [CHM-201003677] QVC-FTP/USA00130 에 대해 IT NO 내리는 hard-coding 추가
* 2010-06-22 : YJLEE : [CHM-201004143] HP 화주(USA00051) 에 대해 prefix DG IND : 를 추가 하여 DG 화물은 Y, 그 외는 N으로 생성.
* 2010-07-08 @CHM-201004567-01 Batch VIP315 발송 - ASA00120의 Splict Booking Case에 대해 Pantos BL No.사용 안함 By Kim Jin-seung
* 2010.09.07 김진승 [CHM-201005667-01] Memo BL 315 전송 로직 변경 요청
* 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완 
	1. 전송 시도하는 BKG/ CNTR, 동일 edi_grp_cd 로 AVN / AVM 이 기 발생된 내역이 존재하고
	2. BKG_NO, CNTR_NO 에 해당하는 COP 가 이미 COP_STS_CD = 'F' 일 경우 또는 BKG_NO, CNTR_NO 로 BKG_CONTAINER 를 조회하여 CNMV_STS_CD = ID or MT 일 경우
	위 두 요건을 만족할 때 로그 남기고 발송 skip
* 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에  BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 추가
* 2010.10.26 김진승 [CHM-NotSet] Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에  Multi Booking No., BL No. 추가처리
* 2010.10.29 김진승 [소스품질 보완] checkPartialSndRslt 메서드 주석 생성 
* 2010.11.02 김진승 [CHM-201006673-01] Missing Event for Safeway (APLL) 확인 요청  처리
* 2011.03.22 김진승 [CHM-201109254-01] USA00214 (NIKE)의 경우 AON에 대해  OAN의 EVENT DATE 적용 요청 처리 ;
* 2011.04.08 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리
* 2011.04.15~19 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리.. 수정
* 2011.04.22_25 황효근 [CHM-201110046-01] [HP](USA00462) 315 단계 로직 추가 
* 2011.05.23 황효근 [CHM-201110822-01] (CargoSmart)315 로직보완요청 - 원복처리
* 2011.05.30 채창호 [CHM-201111195-01] (Target) AG 로직 보완(USA00094 에 대하여  VDL 일때 VE 자동발송 되는 로직 미발송처리.)
* 2011.05.30 채창호 [CHM-201110991-01] : GAP 315 logic 보완 및 오류 사항 확인 요청
* 2011.06.01 황효근 [CHM-201110581-01] Item Addition On 315 FFLayout
* 2011.06.16 채창호 [CHM-201111121-01] : (BASF) VE 로직 보완 요청
* 2011.06.30 채창호 [CHM-201111915-01] : [HP] 315 Event GMT 계산 오류 수정
* 2011.07.11 채창호 [CHM-201112043-01] : (Target) AG 로직 보완 20110628
* 2011.08.19 이경원 [CHM-201112879-01][SCE] (BASF) OAN값 로직 보완요청
* 2011.08.25 이경원 [CHM-201112880-01] 삼성전자 315 Event 코드 추가 및 정의변경 FLAT FILE에 PODETB, PODETB_GMT, PODATB, PODATB_GMT 항목 추가
* 2011.10.05 이경원 [CHM-201113697-01] MITSUI-SOKO 315 EDI 셋업 관련 F/F 상 Cut Off Time 항목 추가 요청
* 2011.10.13 이경원 [CHM-201113828-01] [삼성SDS] 신규 TP ID (Tracking) 셋업 요청
* 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
* 2011.10.27 이경원 [] PKUP_FIRMS 가져오기
* 2011.12.26 채창호 [CHM-201115248] IKEA ETD 맵핑 오류 수정 요청 -- Feeder의 VVD가 지정되지 않았을때 잘못된 Feeder의 잘못된 ETA, ETD를 가져와서 수정
* 2012.02.20 박찬민 [SRM-201224145]  NIKE AD status 자동전송 방지 로직 추가 
* 2012.03.05 박찬민 [CHM-201216510] GAP OA event 누락 사유 확인 요청
* 2012.03.26 채창호[CHM-201216947]: APL/Emerson 315 OA status 설정요청
* 2012.03.12 박찬민 [CHM-201216603] : 개발-GAP FA status 전송주체 추가 요청
* 2012.05.09 박찬민 []Gap Distribution Center 변경(USCPM 삭제)
* 2012.05.11 박찬민 []GAP EDI Group ID별 Logic 복사요청  - COM02200=COM02353, COM02201=COM02354
* 2012.05.24 박찬민 [CHM-201217945] F/F 수정 - RD FLAG 추가
* 2012.06.22 채창호 [CHM-201218500]  Customer EDI Monitoring screen 에서 315 EDI재전송시 Relay port 정보 missing
* 2012.06.29 박찬민 [CHM-201218754] BASF 315 최초 VE status 전송 지연 요청 
* 2012.07.09 박찬민 [CHM-201218837] F/F 상에 Terminal Name	
* 2012.07.10 박찬민 [CHM-201218913] GT Nexus - VF Cargo Tracking 전송 Logic 
* 2012.08.02 박찬민 [CHM-201219300] Customer 315 FF 의 "PICKUP NUMBER" 항목 추가
* 2012.08.09 박찬민 [CHM-201219484] Del MOnte(GT Nexus) Cargo Tracking 로직 수정
* 2012.08.27 박찬민 [CHM-201219880] Del Monte 315 발송 Logic 변경 요청 (POR : THLKG인 경우)
* 2012.08.29 채창호 [CHM-201219954] GTN 315 Microsoft 관련 S/C No. 대상 EDI, F/F 맵핑 수정 요청 
* 2012.09.03 박찬민 [CHM-201219925] Sears D status 전송 로직 변경 요청
* 2012.09.04 채창호 [CHM-201219890]  Missing Container PO No (CNTR_PO_NBR) in 315 flat file
* 2012.09.27 박찬민 [CHM-201220495] Del Monte => 315 Cargo Tracking (IO) 송부 로직 변경 요청
* 2012.10.16 권상준 [CHM-201220786] COM02357/ CEVA- Microsoft/ TRADIANT 에 대해서도 Manual 'D','AD' 만 전송되도록 수정(단, 메뉴얼도 AD 만 발송시 전송
* 2012.12.21 박찬민 [CHM-201222099] [SCE]Home Depot CR 전송 로직 변경 요청 
* 2013.01.22 박찬민 [CHM-201322468] Ashely Furniture (Group ID: COM00781, USA00004, USA00281) 315  VDL Block 요청 (AEL 미 발생시)
* 2013-01.30 권상준 [CHM-201222195] [GTN] COM 02357 Ceva-Microsoft : AD event 자동 전송 로직 적용 (AV 발생 72시간 이후)
* 2013.03.28 손영일 [CHM-201323515] APLL Emerson OAN(D) status location code 변경 요청
* 2013.03.28 권상준 [CHM-201323601] IKEA 315 로직 추가 요청 Vessel 관련 EDI 전송시 Day 변경이 없는 건은 전송 제외
* 2013.04.08 권상준 [CHM-201323944] [GTN 315] Ceva- Microsoft AD 발송 시점 변경 요청(AV 발생 시 AD도 발송, (단, Event Date는 AV + 72시간으로 기존 유지))
* 2013.07.05 최덕우 [CHM-201325106] [SCEM] Pseudo Yard EDI 발송 로직 변경 개발 요청
* 2013.08.12 권상준 [CHM-201325134] Lowes EDI 315 AV event 로직 보완
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.basic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.basic.FreeTimeBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.basic.FreeTimeBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.integration.Edi315SendDBDAO;
import com.hanjin.apps.alps.esd.sce.edi315send.integration.Edi315SendEAIDAO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.AddSceEdiSndRsltVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.AddSceFltFileNoGenVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.CurrEventDtYdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.CurrVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315CurrInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315DetailVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315MasterVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixBkgVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixIrgInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainBkgCustInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315XterRqstNoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.GetEvntDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.GetRailTermVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.RlyPortVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchBoundRoutSeqVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchCntrWeightInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchCredataMetInformationVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchTIExistInformationVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchVvdTimeInformationVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.SceCopDtlVO;
import com.hanjin.syscommon.common.table.SceFltFileMsgDtlVslVO;
import com.hanjin.syscommon.common.table.SceFltFileMsgVO;



 

/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBC 참조
 * @since J2EE 1.4
 */
public class Edi315SendBCImpl extends BasicCommandSupport implements Edi315SendBC{
	private transient Edi315SendDBDAO dbDao = null;
	/**
	 * Edi315SendBCImpl 생성자<br>
	 * 
	 * @param 
	 * @return Edi315SendDBDAO 
	 * @exception
	 */
	public Edi315SendBCImpl() { 
		dbDao = new Edi315SendDBDAO();
	}
	

	
	/**
	 * CALL : alps/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/basic/UsCgoRlseBackEndJob.java
	 * Insert SCE_EDI_AMS_IF (배치 실행한 배치 테이블)
	 * BL 단위로 받아서 COP NO 단위로 쪼개서 edi315Send Call.
	 * @param Edi315AmsDataVO amsVo
	 * @return String
	 * @exception EventException
	*/
    public String addSceEdiAmsIf(Edi315AmsDataVO amsVo) throws EventException {

		String flag = "O";

		try {
			flag = dbDao.addSceEdiAmsIf(amsVo);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
		return flag;
	}
    /**
	 * Insert SCE_EDI_LOG 
	 * Event Date, Event Yard 등이 없는 이상 케이스 시 로깅 하고 발송 하지 않는다.
	 * @param Edi315SendVO sndVo
	 * @param String rmk
	 * @return String
	 * @exception EventException 
    */
    private String addSceEdiLog(Edi315SendVO sndVo, String rmk) throws EventException {

		String flag = "O";

		try {
			flag = dbDao.addSceEdiLog(sndVo, rmk);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
		return flag; 
	} 
 
	/**
	 * Edi315Send - VIP 315 발송 Method.
	 * 
     * @param sendVo Edi315SendVO
     * @return String  
     * @throws EventException ... 
     */

    public String edi315Send(Edi315SendVO sendVo) throws EventException {

		boolean succesFlagIf = false;
		boolean succesFlagIfDlt = false;
		
		try {
			log.info("\n ------ edi315Send 시작 -------------- sendVo.toString() : \n"+sendVo.toString());
		

			/* MANUAL 발송 시엔 CALL_FROM = MAN으로 Set 되므로 Status 에 따라 분기. */
			if("Y".equals(sendVo.getManFlg())){
				String v_edi_sts = sendVo.getEdiStatus();
				if("NT".equals(v_edi_sts)){
					sendVo.setCallFrom("322");
				}else if("CT".equals(v_edi_sts)||"CR".equals(v_edi_sts)||
						 "CU".equals(v_edi_sts)||"CC".equals(v_edi_sts)||
						 "PA".equals(v_edi_sts)||"PQ".equals(v_edi_sts)||
						 "OB".equals(v_edi_sts)||"AW".equals(v_edi_sts)){
					sendVo.setCallFrom("AMS");
				}else{
					sendVo.setCallFrom("COP");
				}
				
			}
			
			List<Edi315SendVO> list = new ArrayList();
			//modifySceEdiHisCustRmk 에서 필요 하여 따로 조회 함.
			HashMap<String, String> keyMap = searchKeysForAddSceEdiHis();
			if (keyMap != null) {
				String rcvDt  = keyMap.get("RCV_DT");
				String rcvSeq = keyMap.get("RCV_SEQ");
				sendVo.setRcvDt(rcvDt);
				sendVo.setRcvSeq(rcvSeq);
			}
			list.add(sendVo);
			
			/* EDI Call History Insert*/
			succesFlagIf = addSceEdiHis(list);
			/* 현 시점의 sc no, rfa no, cust cd 를 토대로 발송 화주를 가져 온다.*/
			String cust_rmk = searchEdiGrpCd(sendVo.getBkgNo());
			
			/* 현 시점에서 EDI 발송 대상 화주를 모두 Update. 현업에서 미 발송 원인 파악 요청 오는 주요 이유.*/
			modifySceEdiHisCustRmk(cust_rmk,sendVo);
			//SCE_EDI_HIS 테이블을 업데이트 하기 위한 TEMP변수
			String tmp_rcv_dt  = sendVo.getRcvDt();
			String tmp_rcv_seq = sendVo.getRcvSeq();			
 
			
			
			/**
			 * WO발행시마다(ALPS/ETS) 아래 Method 항상 call.
			 * DOOR운송이고 Truck 운송이 포함된 경우에 EDI 발송.(TD/TR모드 등 ..)
			 * WO Issue 시 발송 하는 경우는 COP NO 만으로 EDI Call 된다. 그에 따른 BKG NO, CNTR NO등을 Setting 한다.
			 **/			
			if ("WO".equals(sendVo.getEdiStatus())) {
				sendVo = checkCallTRS(sendVo);
				if (sendVo == null) {
					Edi315SendVO sendTmpVo= new Edi315SendVO();
					sendTmpVo.setRcvDt(tmp_rcv_dt);
					sendTmpVo.setRcvSeq(tmp_rcv_seq);
					String edi_rmk = "NoIBDoorTruckWorkOrder";
					modifySceEdiHisEdiRmk(edi_rmk,sendTmpVo);
					return FAIL;
				}
			}

			HashMap<String, String> baseNos = getBaseNos(sendVo);
			if (baseNos != null) {
				sendVo.setBlNo   (baseNos.get("BL_NO"));
				sendVo.setBkgNo  (baseNos.get("BKG_NO"));
				sendVo.setCopNo  (baseNos.get("COP_NO"));
				sendVo.setCntrNo (baseNos.get("CNTR_NO"));
			}
			
			/* ActualMapping시 Node 를 찾지 못한경우에 CallFrom이 DIR로넘어옴.
			 * 이때는 OAN/OAO 구분 없이 넘어 오기 때문에 Status를 확정 하는 작업을 한다. 
			 * */
			if ("DIR".equals(sendVo.getCallFrom())){
				if ("OA".equals(sendVo.getEdiStatus().substring(0, 2))) {
					String oa_value = getOA_value(sendVo.getCopNo());
					// [CHM-201325773] [COP/Visibility] VD시 OP/OC/VL 재매핑 로직상 Cycle -1 로직추가(보완)
					log.info("CrtByOPFnd : "+sendVo.getCreId());
					// VD시에 OP/OC/VL을 재매핑하면서 기존 OAO, OAN 로직에러발생 OAO가 아니라 OAN이 잘못 발송 보완
					if ( "CrtByOPFnd".equals(sendVo.getCreId())){
						sendVo.setEdiStatus("OAO");
					}
					else{
						sendVo.setEdiStatus(oa_value);
					}
				}
					sendVo.setManFlg("D");					
			}
			log.info("EdiStatus : "+sendVo.getEdiStatus());
			
			
			
			
//			이상한 EVENT CALL은 프로 세스 못 타도록  Return FAIL !!
//			추후 sendVo 확인 Method 분리
			if(sendVo.getEventDt()==null || "".equals(sendVo.getEventDt())){
				String rmk_dt = "No Event Dt "+"SCE_EDI_HIS.EDI_RCV_DT:"+sendVo.getRcvDt()+" ,EDI_RCV_SEQ:"+sendVo.getRcvSeq();
				addSceEdiLog(sendVo,rmk_dt);
				return FAIL;
			}else if(sendVo.getEventYard()==null || "".equals(sendVo.getEventYard())){
				String rmk_yd = "No Event Yard "+"SCE_EDI_HIS.EDI_RCV_DT:"+sendVo.getRcvDt()+" ,EDI_RCV_SEQ:"+sendVo.getRcvSeq();
				addSceEdiLog(sendVo,rmk_yd);
				return FAIL;
			}
			
			
//-----1.detailVo 생성------------------------------------------------------------------------------------------------------
		
			
			if (succesFlagIf) {
				/* 주로 bkg_booking 테이블 정보.*/
				List<Edi315MasterVO> mvos = search315MasterList(sendVo.getCopNo());
				/* 발송 대상 조회 */
				List<Edi315DetailVO> dvos = search315DetailList(sendVo);
				
				
				if (dvos != null && dvos.size() > 0) {
					for (int m = 0; m < dvos.size(); m++) {
						dvos.get(m).setRcvDt    (sendVo.getRcvDt());
						dvos.get(m).setRcvSeq   (sendVo.getRcvSeq());
						dvos.get(m).setBkgNo    (sendVo.getBkgNo());
						dvos.get(m).setBlNo     (sendVo.getBlNo());
						dvos.get(m).setCopNo    (sendVo.getCopNo());
						dvos.get(m).setCntrNo   (sendVo.getCntrNo());
						dvos.get(m).setCreUsrId (sendVo.getCreId());
						dvos.get(m).setUpdUsrId (sendVo.getUpdId());
					}
					succesFlagIfDlt = addSceEdiHisDtl(dvos);
				}else{

					String edi_rmk = "NoDataSCE_EDI_HIS_DTL";
					modifySceEdiHisEdiRmk(edi_rmk,sendVo);
				
					return "A";
				}
				



				Edi315MasterVO mstVo = null;
				if (mvos != null && mvos.size() > 0) {
					mstVo = mvos.get(0);
				}
				
				if (dvos != null && dvos.size() > 0) {
					for (int i = 0; i < dvos.size(); i++) { // 1건씩 발송 시도.
						Edi315DetailVO detailVo = dvos.get(i);
						ObjectCloner.build(mstVo,detailVo);
						log.info("\n ObjectCloner 후 detailVo.toString() : \n"+detailVo.toString());
																	
						// 2010.11.02 김진승 [CHM-201006673-01] Missing Event for Safeway (APLL) 확인 요청  처리
						if (sendVo != null 
								&& sendVo.getFmBtchFlg()!=null
								&& sendVo.getFmBtchFlg().equals("Y")
								&& sendVo.getIfRmk() != null
								&& !sendVo.getIfRmk().trim().equals("")) {
							// 전송 대상을 잡는다.
							// sendVo 의 if_rmk 에 값이 없을 경우에는 그대로 진행하고 
							// 값 존재 시에만 "," 을 seperator 로 하여 가져온 edi_grp_cd 가 현재 발송 시도하는 edi_grp_cd 를 포함하고 있을 경우에는
							// 전송 시도하고
							// 그렇지 않을 경우에는 "Batch 처리 시 전송 대상 skip" log 를 남기고 (sce_edi_log 의 edi_rmk) 전송 skip
							if ( sendVo.getIfRmk().indexOf(detailVo.getEdiGrpCd()) < 0 ){
								modifySceEdiHisDtl("F", "Batch 처리 시 전송 대상 skip", detailVo);
								continue;
							}
						}
						
						
						
						
//-----2-1.currVo EventDt/Node------------------------------------------------------------------------------------------------------						
						
						
						Edi315CurrInfoVO currVo = new Edi315CurrInfoVO();

						CurrEventDtYdVO    currEventDtYdVo = null;
						CurrVvdVO currVvdVo = null; 
						String org_sts = detailVo.getOrgEdiSts();
						String edi_sts = detailVo.getEdiSts();
						String cust_edi_sts = detailVo.getCustEdiStsCd();
						String r_flag   = "";
						String r_remark = "";
						boolean manFlg = "Y".equals(sendVo.getManFlg());
						
						//org_sts != edi_sts <- 동시 발송 케이스(SCE_EDI_MNG_STS에 SETUP이 되있는경우)만 Event Date, Event Yard를 변경 함
						if(!org_sts.equals(edi_sts)){
							if(!manFlg){
								//VE 발송시 edi_grp_cgo.EDI_AUTO_SND_FLG = Y 인 경우 SCE_COP_DTL 에서 Current Info 를 가져옴.
								if("VE".equals(org_sts)&&"VD".equals(edi_sts.substring(0, 2))){
									currEventDtYdVo = getAutoVdSend(detailVo.getCopNo());
									if (currEventDtYdVo != null && edi_sts.equals(currEventDtYdVo.getCurrSts())) {
										detailVo.setEdiSts(currEventDtYdVo.getCurrSts());
										currVo.setCurrEventDt(currEventDtYdVo.getCurrEventDt());
										currVo.setCurrEventYard(currEventDtYdVo.getCurrEventYard());
										currVo.setCurrCopDtlSeq(currEventDtYdVo.getCurrCopDtlSeq());
									}else if(currEventDtYdVo != null && !edi_sts.equals(currEventDtYdVo.getCurrSts())){
										//VE 자동 발송으로 VDL,VDT로 발송 설정 된 경우 발송 안해야 하는 대상인 경우임.
										r_flag = "F";
										r_remark = "EDI_STS와 COP의 VDL,VDT 불일치";
										modifySceEdiHisDtl(r_flag, r_remark, detailVo);
										continue;
									}else if(currEventDtYdVo == null){
										//sce_cop_dtl.EDI_ACT_SND_DT 가 null 인 경우엔 발송 안함.
										r_flag = "F";
										r_remark = "VDL,VDT 발송 History 없음(SCE_COP_DTL.edi_act_snd_dt)";
										modifySceEdiHisDtl(r_flag, r_remark, detailVo);
										continue;
									}else{
										continue;
									}
	 							// * 2011.04.08 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리 
								}else if("OAN".equals(org_sts) && "VAD".equals(edi_sts) && "USA00094".equals(detailVo.getEdiGrpCd())){
									HashMap hashMap = edi315SendForUSA00094VAMissed(sendVo, detailVo, currVo);
									if ( hashMap!= null ){
										currVo.setCurrEventDt((String)hashMap.get("EVENT_DT_VAD"));
										currVo.setCurrEventYard((String)hashMap.get("EVENT_YARD"));
										currVo.setCurrCopDtlSeq((String)hashMap.get("EVENT_COP_DTL_SEQ"));
									}
	
								}else if("COM02879".equals(detailVo.getEdiGrpCd())&&
										 ("OTP".equals(detailVo.getEdiSts())
										  ||"TAF".equals(detailVo.getEdiSts())
										  ||"OCT".equals(detailVo.getEdiSts())
										  ||("AG".equals(detailVo.getEdiSts()) && "OAN".equals(org_sts)))){
									currVo.setCurrEventYard(sendVo.getEventYard());
									currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
									if("OTP".equals(detailVo.getEdiSts())){
										if("CNDMN".equals(detailVo.getPorCd())){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"-1"));
										}else if("CNYIT".equals(detailVo.getPorCd())||"CNSHU".equals(detailVo.getPorCd())){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"-3"));
										}else{
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"-2"));
										}
									}else if("TAF".equals(detailVo.getEdiSts())){
										if("CNDMN".equals(detailVo.getPorCd())){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"1"));
										}else if("CNYIT".equals(detailVo.getPorCd())||"CNSHU".equals(detailVo.getPorCd())){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"3"));
										}else{
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"2"));
										}
									}else if("OCT".equals(detailVo.getEdiSts())){
										currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"-24"));
									}else if("AG".equals(detailVo.getEdiSts()) && "OAN".equals(org_sts)){
										if("USUFI".equals(sendVo.getEventYard().substring(0,5))){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"5"));
										}else if("USMIK".equals(sendVo.getEventYard().substring(0,5))){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"3"));
										}else if("USMEM".equals(sendVo.getEventYard().substring(0,5))){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"1"));
										}else if("GBDVY".equals(sendVo.getEventYard().substring(0,5))){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"3"));
										}else if("NLVNR".equals(sendVo.getEventYard().substring(0,5))){
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"3"));
										}else{
											currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"3"));
										}
									}
								//VE-> VDL,VDT 의 발송 케이스가 아닌 경우.
								//SCE_EDI_MNG_STS, SCE_EDI_MNG_AMS_STS 테이블 참고.
								// 2013-01.30 CHM-201222195 [GTN] COM 02357 Ceva-Microsoft : AD event 자동 전송 로직 적용 (AV 발생 72시간 이후)
								// 2013.04.08 [CHM-201323944] [GTN 315] Ceva- Microsoft AD 발송 시점 변경 요청(AV 발생 시 AD도 발송, (단, Event Date는 AV + 72시간으로 기존 유지))
								// 2014.05.14 [CHM-201430160] [CEVA  Microsoft] COM02677 그룹코드 추가
								}else if(("COM02357".equals(detailVo.getEdiGrpCd()) || "COM02677".equals(detailVo.getEdiGrpCd()) || "COM02879".equals(detailVo.getEdiGrpCd())) && "AD".equals(detailVo.getEdiSts())){
									currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"72"));
									currVo.setCurrEventYard(sendVo.getEventYard());
									currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
								}else{		
	
									currEventDtYdVo = getCurrInfoVoWithIsCurrCopDtl(sendVo.getEventYard(), detailVo);
									if (currEventDtYdVo != null) {
										currVo.setCurrEventDt  (currEventDtYdVo.getCurrEventDt());
										currVo.setCurrEventYard(currEventDtYdVo.getCurrEventYard());
										currVo.setCurrCopDtlSeq(currEventDtYdVo.getCurrCopDtlSeq());
									}else{
										//sendVo.getCallFrom() <> 'COP' 일 경우엔 currEventDtYdVo == null 이 나온다. 									
										currVo.setCurrEventDt  (sendVo.getEventDt());
										currVo.setCurrEventYard(sendVo.getEventYard());
										currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
									}
									
								}
							}else{ // 테스트 중
								currEventDtYdVo = getCurrInfoVoWithIsCurrCopDtl(sendVo.getEventYard(), detailVo);
								if (currEventDtYdVo != null) {
									currVo.setCurrEventDt  (currEventDtYdVo.getCurrEventDt());
									currVo.setCurrEventYard(currEventDtYdVo.getCurrEventYard());
									currVo.setCurrCopDtlSeq(currEventDtYdVo.getCurrCopDtlSeq());
								}else{
									//sendVo.getCallFrom() <> 'COP' 일 경우엔 currEventDtYdVo == null 이 나온다. 									
									currVo.setCurrEventDt  (sendVo.getEventDt());
									currVo.setCurrEventYard(sendVo.getEventYard());
									currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
								}
							}
							
							//Manual과 상관 없이 적용되야하는 로직
							if("COM02879".equals(detailVo.getEdiGrpCd())){
								if(("UVD".equals(org_sts) || "RLN".equals(org_sts) || "ARN".equals(org_sts)
										|| "AEL".equals(org_sts) || "VDT".equals(org_sts))
										&& "AG".equals(detailVo.getEdiSts()) && "AB".equals(cust_edi_sts)){
									r_flag = "F";
									r_remark = "COM02879는 UVD, RLN, ARN에 의한 AB는 발송 제외";
									modifySceEdiHisDtl(r_flag, r_remark, detailVo);
									continue;
								}
							}

						}else if(!org_sts.equals(edi_sts)&& manFlg && ("USA00094".equals(detailVo.getEdiGrpCd()))){
							currEventDtYdVo = getCurrInfoVoWithIsCurrCopDtl(sendVo.getEventYard(), detailVo);
							if (currEventDtYdVo != null) {
								currVo.setCurrEventDt  (currEventDtYdVo.getCurrEventDt());
								currVo.setCurrEventYard(currEventDtYdVo.getCurrEventYard());
								currVo.setCurrCopDtlSeq(currEventDtYdVo.getCurrCopDtlSeq());
							}else{
								//sendVo.getCallFrom() <> 'COP' 일 경우엔 currEventDtYdVo == null 이 나온다. 									
								currVo.setCurrEventDt  (sendVo.getEventDt());
								currVo.setCurrEventYard(sendVo.getEventYard());
								currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
							}
							
						}else{
							
							//org_sts = edi_sts 인 경우.
							currVo.setCurrEventDt  (sendVo.getEventDt());
							currVo.setCurrEventYard(sendVo.getEventYard());
							currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
							if ("AMS".equals(sendVo.getCallFrom())) {
								currVo.setCurrVvd(detailVo.getTrunkVvd());
							}
							log.info("\n currVo 입력\n org_sts = edi_sts 케이스 : org_sts : ("+org_sts+") edi_sts : (" +edi_sts+")"+
									  "\n currVo.toString() : "+currVo.toString());
							
							// 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
							// edi_sts 가 MT일때 sendVo.getEventYard()가 2번째~5번째가 XXX이면 메소드 호출 값을 가져와서 conti_cd가 E면 NOD_CD
							// 를 가져와서 currVo.setCurrEventYard(sendVo.getEventYard());
																					
							/*  CHM-201325106 :  Pseudo Yard EDI 발송 로직 변경  ----------------------------------->> */
							/* 
								MT - MITYAD - Pseudo yard 이면 'OAN' Yard Code 로 대체 
								EE - MOTYDO - Pseudo yard 이면 'IO'  Yard Code 로 대체
							*/

							if ( ( "MT".equals(edi_sts) || "EE".equals(edi_sts) ) && "XXX".equals(sendVo.getEventYard().substring(2, 5)) )
							{
								String[] resultArray = null;

								resultArray = searchEventYardForReUse( sendVo.getBkgNo(), sendVo.getCntrNo(), sendVo.getEventYard(), edi_sts, sendVo.getCopDtlSeq() );
								
								if ( "E".equals(resultArray[0])){
									currVo.setCurrEventYard(resultArray[1]);
								}
							}
							
							/*  <<----------------------------------CHM-201325106 :  Pseudo Yard EDI 발송 로직 변경 */
						}
						
						//2010-03-16 오현경 추가. UVD 발생시 VAD 발생 안한 경우 EDI 전송하는 케이스 있는데 currEventDt가 null 임
						if(currVo.getCurrEventDt() == null || currVo.getCurrEventDt().length() < 12){
							currVo.setCurrEventDt(sendVo.getEventDt());
						}
	
						String event_loc = null; 
					    //2012.03.26 채창호[CHM-201216947]: APL/Emerson 315 OA status 설정요청
						//2013.03.28 손영일[CHM-201323515]: APLL Emerson OAN(D) status location code 변경 요청
						//2013.05.06 권상준[CHM-201324505]: APLL (Newell Rubbermaid) D 전송시 DEL location 코드 전송 요청
						if ("USA00547".equals(detailVo.getEdiGrpCd()) && "OAN".equals(detailVo.getOrgEdiSts()) && "OAN".equals(detailVo.getEdiSts()) && "D".equals(detailVo.getCustEdiStsCd())) { 
					      	event_loc = getSearchDelCd(detailVo.getCopNo());
					      	currVo.setCurrEventYard(event_loc);
					    }else if("USA00451".equals(detailVo.getEdiGrpCd()) && "OAN".equals(detailVo.getOrgEdiSts()) && "OAN".equals(detailVo.getEdiSts())){
					    	event_loc = getSearchDelCd(detailVo.getCopNo());
					      	currVo.setCurrEventYard(event_loc);
					    }
			
						 //2012.07.10 박찬민 [CHM-201218913] GT Nexus - VF Cargo Tracking 전송 Logic 
						 if("COM02347".equals(detailVo.getEdiGrpCd())){
							 if((detailVo.getPodCd().equals(detailVo.getDelCd())) && "OAN".equals(detailVo.getOrgEdiSts()) && "D".equals(detailVo.getEdiSts())){	 
								 String edi_tp = "OAN";
								 String delay_t = "6";
								 String edi_sub_sts_cd = "OA";
								 currVo.setCurrEventDt(getEventDtForTRT(delay_t, detailVo.getEdiGrpCd(), edi_tp, edi_sub_sts_cd, detailVo.getCntrNo(), detailVo.getBkgNo()));
						 	}else if((!detailVo.getPodCd().equals(detailVo.getDelCd())) && "RLN".equals(detailVo.getOrgEdiSts()) && "OAN".equals(detailVo.getEdiSts())){
						 		String edi_tp = "RLN";
						 		String delay_t = "3";
						 		String edi_sub_sts_cd = "RL";
						 		currVo.setCurrEventDt(getEventDtForTRT(delay_t, detailVo.getEdiGrpCd(), edi_tp, edi_sub_sts_cd, detailVo.getCntrNo(), detailVo.getBkgNo()));
						 	} 
						 }
						 
						 //2012.08.09 [CHM-201219484] Del MOnte(GT Nexus) Cargo Tracking 로직 수정
						 if("COM01125".equals(detailVo.getEdiGrpCd())){
							 if((!detailVo.getPodCd().equals(detailVo.getDelCd())) && "RLN".equals(detailVo.getOrgEdiSts()) && "OAN".equals(detailVo.getEdiSts())){
								 String edi_tp = "RLN";
								 String delay_t = "3";
								 String edi_sub_sts_cd = "RL";
					 			currVo.setCurrEventDt(getEventDtForTRT(delay_t, detailVo.getEdiGrpCd(), edi_tp, edi_sub_sts_cd, detailVo.getCntrNo(), detailVo.getBkgNo()));
							 }
						 }
						 
						 // 2013.10.22 CHM-201327178 DEL Delivery Time 변경 시 자동 전송 로직 추가 요청(Live 미반영으로 주석처리)
						 // EOAN은 COP Detail상의 MITYAD(MT)가 아닌 마지막 Arrival에 해당(Activity Code 5자리가 A인) Activity의 Estimated Date를 가져온다.
						 if("EOAN".equals(detailVo.getEdiSts())){
							 currEventDtYdVo = getEoanEstimatedDate(detailVo.getCopNo());

							 currVo.setCurrEventDt(currEventDtYdVo.getCurrEventDt());
							 currVo.setCurrEventYard(currEventDtYdVo.getCurrEventYard());
							 currVo.setCurrCopDtlSeq(currEventDtYdVo.getCurrCopDtlSeq());
						 }
						 
						// 2014.03.17 [CHM-201429064] "D" event 자동 발송 로직 적용 요청
						// 1. 해당 Customer ID : EDI Group USA00462 : Spective (HP) 
						// 2. 조건 : Delivery Term : Door Term, DEL country : US 
						// 3. 요청 Event : "D" 
						//	- "OA" event time + 1 시간 으로 적용 
						//	- "OA" event 발송 시 같이 발송
						if("USA00462".equals(detailVo.getEdiGrpCd()) && detailVo.getDelCd() != null){
							if("OAN".equals(detailVo.getOrgEdiSts()) && "D".equals(detailVo.getEdiSts()) && "D".equals(detailVo.getDeTermCd()) && "US".equals(detailVo.getDelCd().substring(0,2))){
							// "OA" event time + 1 시간 으로 적용 
							currVo.setCurrEventDt(getReservedEventDt(sendVo.getEventDt(),"1"));
							}
						}						 							 
//-----2-2.currVo VVD------------------------------------------------------------------------------------------------------						
						currVvdVo = getCurrVvdInfo(currVo.getCurrEventYard(), detailVo);
						if (currVvdVo != null) {
							log.info("\n currVvdVo.toString()------ \n"+currVvdVo.toString());
							currVo.setCurrVvd(currVvdVo.getCurrVvd());
							currVo.setCurrBound(currVvdVo.getBound());
							currVo.setLloydCd(currVvdVo.getLloydCd());
							currVo.setVslCntCd(currVvdVo.getVslCntCd());
							currVo.setVslNm(currVvdVo.getVslNm());
							
							if("".equals(currVo.getCurrCopDtlSeq()) || currVo.getCurrCopDtlSeq()== null){
								String ediRmk1 = "getCurrCopDtlSeqIsNull";
								modifySceEdiHisDtlEdiRmk1(ediRmk1,detailVo);
								currVo.setCurrCopDtlSeq(currVvdVo.getCurrDtlSeq());
							}
						}		

						if(currVo.getCurrVvd() == null || currVo.getCurrVvd().length()<9){
							currVo.setCurrVvd(detailVo.getTrunkVvd());
							currVo.setLloydCd(detailVo.getLloydCd());
							currVo.setVslCntCd(detailVo.getVslCntCd());
							currVo.setVslNm(detailVo.getVslNm());
						}						
//-----3-1.Skip edi_grp_cgo------------------------------------------------------------------------------------------------------						
						
						/* edi_grp_cgo 테이블의 Validation 확인 */
						boolean chain_result1 = checkEdiSetup(sendVo, detailVo, currVo);
						if (!chain_result1) {
							continue;
						}
						
						/* MNG Table 테이블의 Validation 확인 */
						boolean mngResult =	checkMngSetup(sendVo, detailVo, currVo);
						if (!mngResult) {
							continue;
						}
						
//-----3-1.Skip edi_grp_cd------------------------------------------------------------------------------------------------------
						/* 화주 별 Validation 확인. */
						boolean chain_result2 = checkEdiGroupValidation(sendVo, detailVo, currVo);
						if (!chain_result2) {
							continue;
						}
						
//-----3-2.Target 일 경우 cntr 가 partial 로 다른 bkg 에 엮여 있고 bkg, cntr, edi_grp_cd 로 현재 status 를 전송한 기록이 있을 경우 skip 
//						 이지영 과장 messenger 요청으로 multi_BKG_NO 적용에 따라 하기 block logic 을 적용하지 않음. 20101103 적용
						// USA00094 (Target)
//						if (detailVo.getEdiGrpCd() != null && detailVo.getEdiGrpCd().equals("USA00094")) {//edi_grp_desc = TARGET, Cust_trd_prnr_id = 6111470101
//							boolean chain_result3 = checkPartialSndRslt(sendVo, detailVo);
//							if (chain_result3) {
//								continue;
//							}
//						}
//-----4.FF 생성------------------------------------------------------------------------------------------------------						

						String rslt_flag="C";
						String rslt_remark = "";
						//1. 원래 화면에서 Save 된 경우[sendVo.getLogFlg()]
						//2. SCE_EDI_MNG_STS 테이블에서 발송시 Save Flag 확인[detailVo.getLogFlg()]
						if (!"Y".equals(sendVo.getLogFlg()) 
								&& "N".equals(detailVo.getLogFlg())) {
								
							/* 1. Flat File 생성, 2. 발송, 3. Logging */
							rslt_flag = createFlatFile(sendVo, detailVo, currVo);
							
							log.info("\n createFlatFile's rslt_flag : "+rslt_flag+"\n");						
							modifySceEdiHisDtl(rslt_flag, rslt_remark, detailVo);

							if(("COP".equals(sendVo.getCallFrom())||"DIR".equals(sendVo.getCallFrom())) && sendVo.getActRcvIfKeyDt() != null && sendVo.getActRcvIfKeyNo() != null ){
								modifySceActRcvIf(rslt_flag,sendVo);
							}
							if("COP".equals(sendVo.getCallFrom()) && sendVo.getCopDtlSeq() != null && sendVo.getCopDtlSeq().length()== 4
									&& ("Y".equalsIgnoreCase(rslt_flag)||"Success".equalsIgnoreCase(rslt_flag))){
								modifySceCopDtl(
										 detailVo.getEdiSts()
										,currVo.getCurrEventDt()
										,detailVo.getCopNo()
										,sendVo.getCopDtlSeq()
								);
							}

						} else {
							rslt_flag="L";
							detailVo.setRsltFlg("L");
							
							log.info("\n save 케이스 : currVo.toString() : \n"+currVo.toString());
							addSceEdiSndRslt(
									"", //ff_yymmdd
									"", //ff_seq
									"", //flt_file_ref_no
									"", //po_nbr
									sendVo, 
									detailVo,
									currVo);
							modifySceEdiHisDtl(rslt_flag, rslt_remark, detailVo);
						}
					}
				}
			}
			
			return SUCCESS; // <-- must be changed in to argument with logic
		} catch (EventException e) {
			throw new EventException(e.getMessage(), e);
		} 
	}//edi315Send Method 끝 !!
    

    /**
     * creatFlatFile 해당 조건에 기한 전문을 만들어 기록및 전송함.
     * 즉, Flat File 전문 생성.
     * @param Edi315SendVO     sendVo
     * @param Edi315DetailVO   dtlVo
     * @param Edi315CurrInfoVO currVo
     * @return String
     * @throws EventException
     */
    private String createFlatFile(  Edi315SendVO     sendVo, 
				                   Edi315DetailVO   dtlVo,
				                   Edi315CurrInfoVO currVo
			                  ) throws EventException {
		if (sendVo == null || dtlVo == null || currVo == null) {
			return null;
		}
       

		try {
			/* The keys of CopInfo Part */
//			Edi315PrefixMainVO edi315SendMainVo = new Edi315PrefixMainVO();
			Edi315SendOptionsVO edi315SOpts = new Edi315SendOptionsVO();
			SearchCntrWeightInfoVO searchCntrWeightInfoVO = new SearchCntrWeightInfoVO();
			/* Mapping Options */
			edi315SOpts.setEPorLoc(dtlVo.getPorCd());
			edi315SOpts.setEPolLoc(dtlVo.getPolCd());
			edi315SOpts.setEPodLoc(dtlVo.getPodCd());
			edi315SOpts.setEDelLoc(dtlVo.getDelCd());
			edi315SOpts.setECopNo(dtlVo.getCopNo());
			edi315SOpts.setEBkgNo(dtlVo.getBkgNo());
			edi315SOpts.setBkgNo(dtlVo.getBkgNo());
			edi315SOpts.setCopNo(dtlVo.getCopNo());
			
			HashMap<String, String> valuesOfVessleInfo = searchVesslenInformation(substr((String) nvl(dtlVo.getTrunkVvd()), 0, 4));
			HashMap<String, String> valuesOfNoInfo = searchNodInformation((String) nvl(currVo.getCurrEventYard()));
			HashMap<String, String> valuesOfNoInfo2 = searchNodInformation2((String) nvl(currVo.getCurrEventYard()));
			HashMap<String, String> valuesOfBkgTerm = getBkgTerm(dtlVo.getBkgNo());
			HashMap<String, String> valuesOfFrdInfo = searchCnmv322RailInfo(dtlVo.getCopNo(), dtlVo.getEdiGrpCd());
			HashMap<String, String> valuesOfBkgQtyInfo = searchBkgqtyInformation(dtlVo.getBkgNo());
			HashMap<String, String> valuesOfPoSealInfo = searchPonsealInformation(dtlVo.getBkgNo(), dtlVo.getCntrNo());

			searchCntrWeightInfoVO = searchCntrWeightInfo(dtlVo.getBkgNo(), dtlVo.getCntrNo());
			
			
			String host_tp_id = (String) nvl(dtlVo.getHostTpId());
			String rcvid = (String) nvl(dtlVo.getCustTpId());
			String id322 = (String) nvl(dtlVo.getCustEdiStsCd());
			String msgid = (String) nvl(dtlVo.getEdiSts());
			String vip_grp_id = (String) nvl(dtlVo.getEdiGrpCd());
			String bl_nbr = (String) nvl(dtlVo.getBlNo()) + (String) nvl(dtlVo.getBlTpCd()); // Added By Kim Jin-seung In 2010.10.13.
			String bkg_nbr = (String) nvl(dtlVo.getBkgNo().trim());
			String vsl_name = (String) nvl(valuesOfVessleInfo.get("VSL_NAME"));
			String vsl_cntr_code = (String) nvl(valuesOfVessleInfo.get("VSL_CNTR_CODE"));

			// 2010.09.07 김진승 [CHM-201005667-01] Memo BL 315 전송 로직 변경 요청
			HashMap<String,String> hashMap1 = searchOriginBookingInformation(dtlVo.getBkgNo().trim());
			if ( hashMap1 !=null ){
				bkg_nbr = (String)hashMap1.get("BKG_NO");
				bl_nbr = (String)hashMap1.get("BL_NO") + (String)hashMap1.get("BL_TP_CD");
				hashMap1 = null;
			}


			// 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에  BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 추가
			String bl_crt_dt = null;// Added By Kim Jin-seung In 2010.10.13.
			String bkg_crt_dt = null; // Added By Kim Jin-seung In 2010.10.13.
			String bkg_cfm_dt = null; // Added By Kim Jin-seung In 2010.10.13.

			if("00460".equals(dtlVo.getEdiGrpCd())
					|| "60".equals(dtlVo.getEdiGrpCd())
					|| "COM02029".equals(dtlVo.getEdiGrpCd())
					){  
	
				HashMap<String,String> hashMap2 = searchAdidasBlBkgDate(dtlVo.getBkgNo().trim());
				if ( hashMap2 !=null ){
					bl_crt_dt = (String)hashMap2.get("BL_CRT_DT");
					bkg_crt_dt = (String)hashMap2.get("BKG_CRT_DT");
					bkg_cfm_dt = (String)hashMap2.get("BKG_CFM_DT");
					hashMap2 = null;
				}
			}
			
//			@CHM-201004567-01 Batch VIP315 발송 - 수정 By Kim Jin-seung In 2010-07-08
//			/* 2008-09-11 : 김상현
//			 * 화주 'ASA00120' 일 경우 Booking이 Split되었고 Split된 Booking의 Creation Date가
//			 * On Board Date 이후인 경우에만 Split 이전의 Original Booking의 BL No를 사용.
//			 */
//			if("ASA00120".equals(dtlVo.getEdiGrpCd()) && "S".equals(dtlVo.getBkgCreTpCd())){
//				String splitBkgPantosCase = getSplitBkgPantosCase(dtlVo.getBkgNo());
//				if("Y".equals(splitBkgPantosCase)){
//					String Pantos_bl_no = null;
//					Pantos_bl_no = getSplitBkgPantosBlNo(dtlVo.getBkgNo());
//					if (Pantos_bl_no != null || !"".equals(Pantos_bl_no)){
//						bl_nbr = Pantos_bl_no;
//					}
//				}
//			}
			
			
			String manFlag = sendVo.getManFlg();
			String event_dt = currVo.getCurrEventDt();
			String rslt_flag = "Y";
//		 /* 2012.08.29 채창호 [CHM-201219954] GTN 315 Microsoft 관련 S/C No. 대상 EDI, F/F 맵핑 수정 요청
//		  *  Customer TP id 가 GTN ( TRADIANT ) 인경우는 Customer Code 가 없을때 SC No로 대체하지 않고 Null 을 Assign 함
//		  */
			String refCustCode = "";
//	        String refCustCode = "  000000".equals(dtlVo.getCustNo()) ? (String) nvl(dtlVo.getScNo())  : (String) nvl(dtlVo.getCustNo());
			if ( "TRADIANT".equals(dtlVo.getCustTpId()) ){
				 refCustCode =  "  000000".equals(dtlVo.getCustNo()) ?  "" : (String) nvl(dtlVo.getCustNo());
			}else {
				 refCustCode =  "  000000".equals(dtlVo.getCustNo()) ? (String) nvl(dtlVo.getScNo())  : (String) nvl(dtlVo.getCustNo());
				
			}

			String selNbr = valuesOfPoSealInfo.get("CNMV_SEAL_NO");
			
			//CHM-201325052 SPP Seal# 참조로직 추가 요청(BKG의 Seal No가 없을시에 VL 중에 BKG POL(첫배의 POL) 과 일치하는 MVMT의 Seal No 참조
			log.info("CNMV_SEAL_NO : "+selNbr);
			if(" ".equals(selNbr) || "".equals(selNbr) || selNbr == null){
				selNbr = searchMvmtSealNo(dtlVo.getBkgNo(), dtlVo.getCntrNo());
			}
			//CHM-201325052 End
			
			String wallmart_count = "";

			String custEdate = getCustEDate(dtlVo.getEdiGrpCd(),dtlVo.getCopRailChkCd(), dtlVo.getCopNo(),dtlVo.getPodCd());

			String itNbr = "";
			if(((  "USA00132".equals(dtlVo.getEdiGrpCd())
				||"USA00196".equals(dtlVo.getEdiGrpCd())
				||"USA00130".equals(dtlVo.getEdiGrpCd())//<-- 2010.05.07 [CHM-201003677] 반영 완료
				)	&& "UVD".equals(dtlVo.getEdiSts())) 
				|| "USA00656".equals(dtlVo.getEdiGrpCd())
				|| "COM03084".equals(dtlVo.getEdiGrpCd()) // 2017.07.13 이소연 과장 추가 요청
				){ // -- Talbots (USA00656 전체 이벤트 추가)
				itNbr = getItNoTemp(dtlVo.getBlNo(),currVo.getCurrEventYard());
			}
			String custAdate =     (String) nvl(getCustAdateNewVersion(currVo.getCurrEventYard(), dtlVo.getBlNo()).get("CUST_ADATE"));
			String custAdateGmt = (String) nvl(getCustAdateNewVersion(currVo.getCurrEventYard(), dtlVo.getBlNo()).get("CUST_ADATE_GMT"));


			// 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout
			String itNbrDt = "";
			String inbondNbr = "";
			String inbondNbrDt = "";
			String firmsCode = "";
			
			String[] result = getInbondNbrDtItNbrDt(dtlVo.getBkgNo());
			
			String pkup_Firms = getPickUpFirmsCode(dtlVo.getBkgNo());
			inbondNbr	= result[0];
			inbondNbrDt	= result[1];
			itNbrDt		= result[2];
			//firmsCode	= result[0];
			firmsCode	= pkup_Firms;
			
			
			String pickUpNbr = getPickUpNo(dtlVo.getEdiGrpCd(),dtlVo.getEdiSts(), dtlVo.getCntrNo(),dtlVo.getBkgNo(), currVo.getCurrEventDt());
			currVo.setPickUpNo((String) nvl((pickUpNbr),""));

			RlyPortVO rlyPortVo = new RlyPortVO();
			rlyPortVo = getRlyPortInfo(dtlVo,currVo);
			
			/*******************************************************************/
			/* USA00132 - HobbyLobby에 대하여 NFR전송시  */ 
			/* event date - 1day, 시간은23:59로 fix. */
			if ("USA00132".equals(dtlVo.getEdiGrpCd()) && "NFR".equals(dtlVo.getEdiSts())&& !"Y".equals(sendVo.getManFlg())) {
				String temp_evnt_dt = getHobbyLobbyDateTime(substr(event_dt, 0, 8),"235900");//
				event_dt = temp_evnt_dt;
				currVo.setCurrEventDt(temp_evnt_dt);
				// currVo.setCurrEventDt(v_temp_evnt_dt);
			}

			/*
			 * interval에 값이 있을 경우 예약을 해야 하기 때문에 하기 로직 수행 전송하지 않고 전송 시간이 되기 전까지
			 * 예약해 놓는다.(이후 로직에서 실행) Manual로 전송 하는 sts에 대해서는 적용 제외 20080211 -
			 * ihjang
			 */
			String edi_snd_itval_hr = dtlVo.getEdiSndItvalHrmnt();
			
			// 2012.06.29 박찬민 [CHM-201218754] BASF 315 최초 VE status 전송 지연 요청 
			if(!"0".equals(edi_snd_itval_hr) && !"".equals(edi_snd_itval_hr) &&!"Y".equals(manFlag)){
				if (("EUR00189".equals(dtlVo.getEdiGrpCd()) || "EUR00190".equals(dtlVo.getEdiGrpCd())) && "VE".equals(dtlVo.getEdiSts())){
						int sendRsltCount = dbDao.isdirfirstView(dtlVo.getEdiGrpCd(), dtlVo.getEdiSts(), dtlVo.getCustEdiStsCd(), dtlVo.getCntrNo(), dtlVo.getBkgNo());
							if(sendRsltCount == 0){
								log.info("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
								rslt_flag = "R";
								dtlVo.setEdiSndItvalHrmnt(getReservedSendDt(edi_snd_itval_hr));
								currVo.setCurrEventDt(event_dt);
								log.info("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
							}else if(sendRsltCount > 0){
								int rsvDtIndicator = dbDao.getRsvDtIndicator(dtlVo.getEdiGrpCd(), dtlVo.getEdiSts(), dtlVo.getCustEdiStsCd(), dtlVo.getCntrNo(), dtlVo.getBkgNo());
									if(rsvDtIndicator == 0 || rsvDtIndicator == 1){
										log.info("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
										rslt_flag = "R";
										dtlVo.setEdiSndItvalHrmnt(getReservedSendDtForVe(dtlVo.getEdiGrpCd(), dtlVo.getEdiSts(), dtlVo.getCustEdiStsCd(), dtlVo.getCntrNo(), dtlVo.getBkgNo()));
										currVo.setCurrEventDt(event_dt);
										log.info("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
									}
							}
				// 2013.08.12 [CHM-201325134] Lowes EDI 315 AV event 로직 보완
				}else if(("COM02218".equals(dtlVo.getEdiGrpCd()) || "COM01760".equals(dtlVo.getEdiGrpCd())) && "UVD".equals(dtlVo.getOrgEdiSts()) && "CR".equals(dtlVo.getEdiSts()) &&"AV".equals(dtlVo.getCustEdiStsCd())){
						log.info("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
						rslt_flag = "R";
						dtlVo.setEdiSndItvalHrmnt(getReservedSendDtMin(edi_snd_itval_hr));
						currVo.setCurrEventDt(getReservedEventDtMin(event_dt,edi_snd_itval_hr));
						log.info("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
				// 2013.12.26 [CHM-201328209] Lowes 315 로직 추가 요청	
				// 2014.01.15 [CHM-201428533] [HANESBRANDS] 315 로직 추가 요청
				}else if(("USA00061".equals(dtlVo.getEdiGrpCd()) || "USA00438".equals(dtlVo.getEdiGrpCd())) && "UVD".equals(dtlVo.getOrgEdiSts()) && "CR".equals(dtlVo.getEdiSts()) &&"AV".equals(dtlVo.getCustEdiStsCd())){
					if(dtlVo.getDelCd() != null){
						if("CA".equals(dtlVo.getDelCd().substring(0,2))){
							log.info("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
							rslt_flag = "R";
							dtlVo.setEdiSndItvalHrmnt(getReservedSendDtMin(edi_snd_itval_hr));
							currVo.setCurrEventDt(getReservedEventDtMin(event_dt,edi_snd_itval_hr));
							log.info("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
						}
					}					
				}else{
						log.info("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
						rslt_flag = "R";
						dtlVo.setEdiSndItvalHrmnt(getReservedSendDt(edi_snd_itval_hr));
						currVo.setCurrEventDt(getReservedEventDt(event_dt,edi_snd_itval_hr));
						log.info("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
				}
			}
			
			if("COM02879".equals(dtlVo.getEdiGrpCd())){
				String intervalHr = "0";
				if("TAF".equals(dtlVo.getEdiSts()) && !"Y".equalsIgnoreCase(sendVo.getTmcFlg()) && !"Y".equals(sendVo.getManFlg())){
					if("CNDMN".equals(dtlVo.getPorCd())){
						intervalHr = "1";
					}else if("CNYIT".equals(dtlVo.getPorCd())||"CNSHU".equals(dtlVo.getPorCd())){
						intervalHr = "3";
					}else{
						intervalHr = "2";
					}
				}

				if(!"0".equals(intervalHr)){
					rslt_flag = "R";
					dtlVo.setEdiSndItvalHrmnt(getReservedSendDt(intervalHr));
				}
			}
			
			// 2013.11.28 CHM-201325962 [SCEM] event time 이후 315 데이터 전송 요청
            // SCEM 315 event trigger 시에 GMT 시간으로 계산해서 event time 이 현재 시간보다 나중이라면 event time 까지 기다렸다가 전송처리
            // 2015.03.16 CHM-201534500 [SCEM] FEDEX EDI GROUP : 시스템 로직 추가 요청 COM00878 - 'VAD', 'VAT' 예약전송 추가
            if(
                ("COM02218".equals(dtlVo.getEdiGrpCd()) && ("VDL".equals(dtlVo.getEdiSts()) || "VAD".equals(dtlVo.getEdiSts())))
                || ("COM00878".equals(dtlVo.getEdiGrpCd()) && ("VAD".equals(dtlVo.getEdiSts()) || "VAT".equals(dtlVo.getEdiSts())))             
              ){
				
				String reserved_dt = "N";
				String event_node = currVo.getCurrEventYard();
				
				reserved_dt = getReservedSetDt(event_dt, event_node);
				
				if(!"N".equals(reserved_dt)){
					rslt_flag = "R";
					dtlVo.setEdiSndItvalHrmnt(reserved_dt);
					currVo.setCurrEventDt(event_dt);
				}
			}
			
			// 2014.06.03 CHM-201430405 [CEVA] Vessel Arrival date (POD) 전송 관련 추가 로직 구현 요청
			// 2014.08.19 CHM-201431621 [Visibility] VAD 예약전송 요청(COM00874/ DHL/DANZAS/ TRADIANT 추가)
			if(("COM00874".equals(dtlVo.getEdiGrpCd())) && "VAD".equals(dtlVo.getEdiSts())){
				
				String cv_reserved_dt = "N";
				String cv_event_node = currVo.getCurrEventYard();
				
				cv_reserved_dt = getReservedSetDt(event_dt, cv_event_node);
				
				if(!"N".equals(cv_reserved_dt)){
					rslt_flag = "R";
					dtlVo.setEdiSndItvalHrmnt(cv_reserved_dt);
					currVo.setCurrEventDt(event_dt);
				}
			}
			
			// 2015.07.28 CHM- [CEVA-Microsoft] ALL EVENTS 예약전송 요청(COM02357/COM02677/TRADIANT) 
			if((("COM02357".equals(dtlVo.getEdiGrpCd()) || "COM02677".equals(dtlVo.getEdiGrpCd())) && !"AD".equals(dtlVo.getEdiSts()))
					|| (("COM02879".equals(dtlVo.getEdiGrpCd())) && "AD".equals(dtlVo.getEdiSts())) ){
				
				String cv_reserved_dt = "N";
				String cv_event_node = currVo.getCurrEventYard();
				
				cv_reserved_dt = getReservedSetDt(event_dt, cv_event_node);
				
				if(!"N".equals(cv_reserved_dt)){
					rslt_flag = "R";
					dtlVo.setEdiSndItvalHrmnt(cv_reserved_dt);
					currVo.setCurrEventDt(event_dt);
				}
			}
			
			
			
			dtlVo.setRsltFlg(rslt_flag);
			

						
			String main0 = 
	                "SNDID : "              + host_tp_id                                      + CHR10
	            +   "RCVID : "              + rcvid                                           + CHR10
	            +   "322ID : "              + id322                                           + CHR10
	            +   "MSGID : "              + msgid                                           + CHR10
	            +   "VIP_GRP_ID : "         + vip_grp_id                                      + CHR10
	            +   "BL NBR : "             + bl_nbr                                          + CHR10
	            +   "BKG NBR : "            + bkg_nbr                                         + CHR10
	            +   "TO VSL CODE : "        + dtlVo.getToVsl()                       + CHR10
	            +   "TO VOYAGE : "          + dtlVo.getToVoyage()                    + CHR10
	            +   "TO DIR : "             + dtlVo.getToDir()                       + CHR10
	            +   "VSL NAME : "           + vsl_name                                        + CHR10
	            +   "VSL CNTR CODE : "      + vsl_cntr_code                                   + CHR10;
			
			// Added By Kim Jin-seung In 2010.10.13.
			if("00460".equals(dtlVo.getEdiGrpCd())
					|| "60".equals(dtlVo.getEdiGrpCd())
					|| "COM02029".equals(dtlVo.getEdiGrpCd())
					){  
				main0 = 
	                	"SNDID : "              + host_tp_id                                      + CHR10
		            +   "RCVID : "              + rcvid                                           + CHR10
		            +   "322ID : "              + id322                                           + CHR10
		            +   "MSGID : "              + msgid                                           + CHR10
		            +   "VIP_GRP_ID : "         + vip_grp_id                                      + CHR10
		            +   "BL NBR : "             + bl_nbr                                          + CHR10
		            +   "BL CRT DT : "          + bl_crt_dt                                       + CHR10
		            +   "BKG NBR : "            + bkg_nbr                                         + CHR10
		            +   "BKG CRT DT : "         + bkg_crt_dt                                      + CHR10
		            +   "BKG CFM DT : "         + bkg_cfm_dt                                      + CHR10
		            +   "TO VSL CODE : "        + dtlVo.getToVsl()                       + CHR10
		            +   "TO VOYAGE : "          + dtlVo.getToVoyage()                    + CHR10
		            +   "TO DIR : "             + dtlVo.getToDir()                       + CHR10
		            +   "VSL NAME : "           + vsl_name                                        + CHR10
		            +   "VSL CNTR CODE : "      + vsl_cntr_code                                   + CHR10;
				
			}
			
			
			
			Edi315PrefixMainCOPInfoVO           listm1 = searchCOPInfo(edi315SOpts);
			
            /* CHM-201002317 화주 USA00204  UV이후 ATA actual mapping 이루어지지 않았으면 podata 정보 공백으로 처리
             * searchCopInfo를 여러번 호출하므로 값을 edi315SOpts에 정의함(주석처리)
             * */
			if("USA00204".equals(dtlVo.getEdiGrpCd())){
			
				SceCopDtlVO dtlVO = getVADActualMappingInfo(dtlVo.getCopNo());
				if(dtlVO != null && currVo.getCurrCopDtlSeq() != null && currVo.getCurrCopDtlSeq().length() ==4  && "0".equals(dtlVO.getActDt())
							&& Integer.parseInt(currVo.getCurrCopDtlSeq()) >= Integer.parseInt(dtlVO.getCopDtlSeq())){
					listm1.setPodAta("");
					listm1.setPodAtaGmt("");					
				}
			}			
			
			/********************************************************************************/
			/* CHM-201002970 판토스 CT EDI 전송 누락 관련 보완 로직 추가 요청 판토스  2010-03-11 ohk */
			/* CUST GRP ID : ASA00120 */
			/* 화주 ASA00120에 대해 POD=BEANR, DEL=BEANR, NLRTM에서 T/S되고 2ND VVD가 없는 것은 IC 발생시 VAD로 EDI 전송 */
			/* VAD 이후 발생 event에서 PODATA정보를 IC 발생시의 EVENT_DT 정보로  넣어줌 */
			/********************************************************************************/

			if("ASA00120".equals(dtlVo.getEdiGrpCd()) && currVo.getIsPodAtaReplace() != null && "Y".equals(currVo.getIsPodAtaReplace())){
				listm1.setPodAta(currVo.getPodAtaEventDt()!= null && currVo.getPodAtaEventDt().length() > 12 ? currVo.getPodAtaEventDt().substring(0,12) : currVo.getPodAtaEventDt());
				listm1.setPodAtaGmt(currVo.getPodAtaEventDtGmt()!= null && currVo.getPodAtaEventDtGmt().length() > 12 ? currVo.getPodAtaEventDtGmt().substring(0,12) : currVo.getPodAtaEventDtGmt());		
			}			
			
			if(sendVo.getVdlByCntrAttach() != null && "Y".equals(sendVo.getVdlByCntrAttach())){
				listm1.setPolAtd   (currVo.getCurrEventDt().substring(0, 12));
				
				String currEventDtGmt = getGmtDt(currVo.getCurrEventDt(),currVo.getCurrEventYard());
				listm1.setPolAtdGmt(currEventDtGmt.substring(0, 12));
			}
			
			if("COM01382".equals(dtlVo.getEdiGrpCd()) &&
			    "UVD".equals(dtlVo.getOrgEdiSts()) && 
			    "VAD".equals(dtlVo.getEdiSts())){
				currVo.setCurrEventDt(listm1.getPodEta());
			}
			
			if("COM01382".equals(dtlVo.getEdiGrpCd()) &&
				"VDL".equals(dtlVo.getOrgEdiSts()) &&
				"AEL".equals(dtlVo.getEdiSts())){
				
				GetEvntDtVO evntDtVo = getEvntDt(dtlVo);
				currVo.setCurrEventDt(evntDtVo.getEstmDt());
			
			}
			
			//2012.07.09 박찬민 [CHM-201218837] F/F 상에 Terminal Name 
			if("COM02364".equals(dtlVo.getEdiGrpCd())){
				
				listm1.setYdNm(dbDao.getYdNm(dtlVo));
				
			}
			
			//2012.09.27 박찬민 [CHM-201220495] Del Monte => 315 Cargo Tracking (IO) 송부 로직 변경 요청
			if("COM01125".equals(dtlVo.getEdiGrpCd()) && "THLKG".equals(dtlVo.getPorCd()) && "THLCH".equals(dtlVo.getPolCd()) && "IO".equals(dtlVo.getEdiSts())){
				listm1.setPolName(listm1.getPorName());
				listm1.setPolCode(listm1.getPorCode());
			}
			
			if( listm1.getPorCode()==null || "".equals(listm1.getPorCode()) ||
				listm1.getPolCode()==null || "".equals(listm1.getPolCode()) ||
				listm1.getPodCode()==null || "".equals(listm1.getPodCode()) ||
				listm1.getDelCode()==null || "".equals(listm1.getDelCode())){
				dtlVo.setSndSkipFlg("Y");//Send Skip 
				dtlVo.setRsltFlg("S");   //Send Skip 
			}
			
			HashMap<String, String> valuesOfPorFrmsCdInfo = searchFrmsCdInformation(dtlVo.getBkgNo(), dtlVo.getPorNodCd());
			HashMap<String, String> valuesOfPolFrmsCdInfo = searchFrmsCdInformation(dtlVo.getBkgNo(), dtlVo.getPolNodCd());
			HashMap<String, String> valuesOfPodFrmsCdInfo = searchFrmsCdInformation(dtlVo.getBkgNo(), dtlVo.getPodNodCd());
			HashMap<String, String> valuesOfDelFrmsCdInfo = searchFrmsCdInformation(dtlVo.getBkgNo(), dtlVo.getDelNodCd());

			String strCopInfo = 
					"POR NAME : "           + listm1.getPorName()			+"\n"+
			        "POR CODE : "           + listm1.getPorCode()			+"\n";
			
			if("USA00684".equals(dtlVo.getEdiGrpCd())){								
				strCopInfo = strCopInfo +
					"POR_FIRMS_CODE : "			+ nvl(valuesOfPorFrmsCdInfo.get("FIRMS_CODE"), "")	+"\n";
			}
			
			strCopInfo = strCopInfo +
			        "POR AMSQUAL : "        + listm1.getPorAmsqual()		+"\n"+
			        "POR AMSPORT : "        + listm1.getPorAmsport()		+"\n"+
			        "PORETD : "             + listm1.getPorEtd()			+"\n"+
			        "PORETD_GMT : "         + listm1.getPorEtdGmt()			+"\n"+
			        "PORATD : "             + listm1.getPorAtd()			+"\n"+
			        "PORATD_GMT : "         + listm1.getPorAtdGmt()			+"\n"+
			        "POL NAME : "           + listm1.getPolName()			+"\n"+
			        "POL CODE : "           + listm1.getPolCode()			+"\n";
			        
			if("USA00684".equals(dtlVo.getEdiGrpCd())){								
				strCopInfo = strCopInfo +
					"POL_FIRMS_CODE : "			+ nvl(valuesOfPolFrmsCdInfo.get("FIRMS_CODE"), "")	+"\n";
			}
			
			strCopInfo = strCopInfo +			        
			        "POL AMSQUAL : "        + listm1.getPolAmsqual()		+"\n"+
			        "POL AMSPORT : "        + listm1.getPolAmsport()		+"\n"+
			        "POLETA : "             + listm1.getPolEta()			+"\n"+
			        "POLETA_GMT : "         + listm1.getPolEtaGmt()			+"\n"+
			        "POLATA : "             + listm1.getPolAta()			+"\n"+
			        "POLATA_GMT : "         + listm1.getPolAtaGmt()			+"\n"+
			        "POLETD : "             + listm1.getPolEtd()			+"\n"+
			        "POLETD_GMT : "         + listm1.getPolEtdGmt()			+"\n"+
			        "POLATD : "             + listm1.getPolAtd()			+"\n"+
			        "POLATD_GMT : "         + listm1.getPolAtdGmt()			+"\n"+
			        "POD NAME : "           + listm1.getPodName()			+"\n"+
			        "POD CODE : "           + listm1.getPodCode()			+"\n";
			
			if("USA00684".equals(dtlVo.getEdiGrpCd())){								
				strCopInfo = strCopInfo +
					"POD_FIRMS_CODE : "			+ nvl(valuesOfPodFrmsCdInfo.get("FIRMS_CODE"), "")	+"\n";
			}
			
			//2012.07.09 박찬민 [CHM-201218837] F/F 상에 Terminal Name			
			if("COM02364".equals(dtlVo.getEdiGrpCd())&& ("VA".equals(dtlVo.getCustEdiStsCd())|| "VD".equals(dtlVo.getCustEdiStsCd())|| "AG".equals(dtlVo.getCustEdiStsCd()))){
				strCopInfo = strCopInfo +
					"POD TML CODE : "			+ dtlVo.getPodNodCd()		+"\n"+
					"POD TML NAME : "           + listm1.getYdNm()			+"\n";
			}
			
			strCopInfo = strCopInfo +
			        "POD AMSQUAL : "        + listm1.getPodAmsqual()		+"\n"+
			        "POD AMSPORT : "        + listm1.getPodAmsport()		+"\n"+
			        "PODETA : "             + listm1.getPodEta()			+"\n"+
			        "PODETA_GMT : "         + listm1.getPodEtaGmt()			+"\n"+
			        "PODATA : "             + listm1.getPodAta()			+"\n"+
			        "PODATA_GMT : "         + listm1.getPodAtaGmt()			+"\n"+
			        "PODETD : "             + listm1.getPodEtd()			+"\n"+
			        "PODETD_GMT : "         + listm1.getPodEtdGmt()			+"\n"+
			        "PODATD : "             + listm1.getPodAtd()			+"\n"+
			        "PODATD_GMT : "         + listm1.getPodAtdGmt()			+"\n";
				
				// 2011.08.25 이경원 [CHM-201112880] 삼성전자 315 Event 코드 추가 및 정의변경
				// 그룹코드가 삼성전자(Group ID: ASA00130)와 계열사 Green Logistics (Group ID: ASA00419)
				// 일때 Flat File PODETB, PODETB_GMT, PODATB, PODATB_GMT 필드 추가
				// 2011.10.12 이경원 [CHM-201113828] [삼성SDS] 신규 TP ID (Tracking) 셋업 요청
				// 그룹코드 삼성SDS(Group ID: 
			    // 2015.03.03 김민정 [CHM-201534483] Anchored Vessel 관련 ETB, ATB 수신 화주 추가 (Group ID: COM02218, USA00438, USA00607)
				// 2015.04.13 김민정 [CHM-201535262] PANTOS 315 전송 시 VBD 전송 (Group ID: ASA00120)
			    if ("ASA00130".equals(dtlVo.getEdiGrpCd())
				 || "ASA00419".equals(dtlVo.getEdiGrpCd())
				 || "ASA00471".equals(dtlVo.getEdiGrpCd())
				 || "COM02218".equals(dtlVo.getEdiGrpCd())
				 || "USA00438".equals(dtlVo.getEdiGrpCd())
				 || "USA00607".equals(dtlVo.getEdiGrpCd())
				 || "ASA00120".equals(dtlVo.getEdiGrpCd())) {
			    		Edi315PrefixMainCOPInfoVO vo1 = searchPodEtbAtbDate(edi315SOpts);
				    	if (vo1 == null) {
							strCopInfo = strCopInfo +
						    "PODETB : "				+  ""				+"\n"+
						    "PODETB_GMT : "			+  ""			+"\n"+
							"PODATB : "				+  ""				+"\n"+
							"PODATB_GMT : "			+  ""			+"\n";
				    	} else {
							strCopInfo = strCopInfo +
						    "PODETB : "				+  vo1.getPodEtb()				+"\n"+
						    "PODETB_GMT : "			+  vo1.getPodEtbGmt()			+"\n"+
							"PODATB : "				+  vo1.getPodAtb()				+"\n"+
							"PODATB_GMT : "			+  vo1.getPodAtbGmt()			+"\n";
				    	}
			    	}
			    
			        strCopInfo = strCopInfo +
			        "DEL NAME : "           + listm1.getDelName()			+"\n"+
			        "DEL CODE : "           + listm1.getDelCode()			+"\n";
			        
			if("USA00684".equals(dtlVo.getEdiGrpCd())){								
				strCopInfo = strCopInfo +
					"DEL_FIRMS_CODE : "			+ nvl(valuesOfDelFrmsCdInfo.get("FIRMS_CODE"), "")	+"\n";
			}
			
			strCopInfo = strCopInfo +
			        "DEL AMSQUAL : "        + listm1.getDelAmsqual()		+"\n"+
			        "DEL AMSPORT : "        + listm1.getDelAmsport()		+"\n";
			        // 2013.05.15 CHM-201324594 APLL Emerson D 전송시 ATA 값 flat file 생성요청
			        if("USA00451".equals(dtlVo.getEdiGrpCd()) && "OAN".equals(dtlVo.getOrgEdiSts()) && "OAN".equals(dtlVo.getEdiSts()) && "D".equals(dtlVo.getCustEdiStsCd())){
			        	strCopInfo = strCopInfo +
			        	"DELETA : "             + listm1.getDelAta()			+"\n"+
				        "DELETA_GMT : "         + listm1.getDelAtaGmt()			+"\n";
			        }else{
			        	strCopInfo = strCopInfo +
			        	"DELETA : "             + listm1.getDelEta()			+"\n"+
				        "DELETA_GMT : "         + listm1.getDelEtaGmt()			+"\n";
			        }
			        
			        strCopInfo = strCopInfo +
			        "DELATA : "             + listm1.getDelAta()			+"\n"+
			        "DELATA_GMT : "         + listm1.getDelAtaGmt()			+"\n";
			
			//OEC의 경우 AV 발송시 Demurrage Freetime end date를 포함한다.
	        if("COM03084".equals(dtlVo.getEdiGrpCd()) && ("AVL".equals(dtlVo.getEdiSts()) || "AVN".equals(dtlVo.getEdiSts())) ){
	        	FreeTimeBC demCommond = new FreeTimeBCImpl();
	        	IfFtCondVO demInCond = new IfFtCondVO();
	        	demInCond.setBkgNo(bkg_nbr);
	        	demInCond.setCntrNo(dtlVo.getCntrNo());
	        	
	        	// Inland 운송이 있을 경우(AVN)에만 FLG = 'Y'로 설정 해 준다.
	        	if ("AVN".equals(dtlVo.getEdiSts())) {
	        		demInCond.setInlndFlg("Y");
	        	}
	        	
	        	log.info("\n DEM BKG NO ===================== " + bkg_nbr);
	        	log.info("\n DEM CNTR NO ===================== " + dtlVo.getCntrNo());
	        	
	        	IfFtVO demVo = demCommond.searchFtOfIbDm(demInCond);
	        	String demEndFt = "";
	        	if (demVo != null) {
	        		demEndFt = demVo.getFtEndDt();
	        		log.info("\n DEM END DATE ===================== " + demEndFt);
	        	}
	        	strCopInfo = strCopInfo +
	        	"DEM_FT_END_DT : "			+ demEndFt	+"\n";		
	        }
			
//			String[] KeyCopInfoArray = new String[] {
//			        "POR NAME : "           ,
//			        "POR CODE : "           ,
//			        "POR AMSQUAL : "        ,
//			        "POR AMSPORT : "        ,
//			        "PORETD : "             ,
//			        "PORETD_GMT : "         ,
//			        "PORATD : "             ,
//			        "PORATD_GMT : "         ,
//			        "POL NAME : "           ,
//			        "POL CODE : "           ,
//			        "POL AMSQUAL : "        ,
//			        "POL AMSPORT : "        ,
//			        "POLETA : "             ,
//			        "POLETA_GMT : "         ,
//			        "POLATA : "             ,
//			        "POLATA_GMT : "         ,
//			        "POLETD : "             ,
//			        "POLETD_GMT : "         ,
//			        "POLATD : "             ,
//			        "POLATD_GMT : "         ,
//			        "POD NAME : "           ,
//			        "POD CODE : "           ,
//			        "POD AMSQUAL : "        ,
//			        "POD AMSPORT : "        ,
//			        "PODETA : "             ,
//			        "PODETA_GMT : "         ,
//			        "PODATA : "             ,
//			        "PODATA_GMT : "         ,
//			        "PODETD : "             ,
//			        "PODETD_GMT : "         ,
//			        "PODATD : "             ,
//			        "PODATD_GMT : "         ,
//			        "DEL NAME : "           ,
//			        "DEL CODE : "           ,
//			        "DEL AMSQUAL : "        ,
//			        "DEL AMSPORT : "        ,
//			        "DELETA : "             ,
//			        "DELETA_GMT : "         ,
//			        "DELATA : "             ,
//			        "DELATA_GMT : "         
//					};

			String mainMiddle0 = 
		            "FRD NAME : "           + valuesOfFrdInfo.get("FRD_NAME")        + CHR10
		        +   "FRD CODE : "           + valuesOfFrdInfo.get("FRD_CODE")        + CHR10
		        +   "FRDETA : "             + valuesOfFrdInfo.get("FRDETA")          + CHR10
		        +   "FRDETA_GMT : "         + valuesOfFrdInfo.get("FRDETA_GMT")      + CHR10
		        +   "RLY NAME : "           + nvl(rlyPortVo.getRlyName(), "")          + CHR10
		        +   "RLY CODE : "           + nvl(rlyPortVo.getRlyPort(), "")          + CHR10
		        +   "RLY AMSQUAL : "        + nvl(rlyPortVo.getRlyAmsqual(), "")       + CHR10
		        +   "RLY AMSPORT : "        + nvl(rlyPortVo.getRlyAmsport(), "")       + CHR10
		        +   "W_UNIT : "             + nvl(valuesOfBkgQtyInfo.get("W_UNIT"), "")               + CHR10
		        +   "WEIGHT : "             + nvl(valuesOfBkgQtyInfo.get("WEIGHT"), "")              + CHR10
		        +   "MEA_UNIT : "           + nvl(valuesOfBkgQtyInfo.get("MEA_UNIT"), "")             + CHR10
		        +   "MEA_QTY : "            + nvl(valuesOfBkgQtyInfo.get("MEA_QTY"), "")             + CHR10
		        +   "P_UNIT : "             + nvl(valuesOfBkgQtyInfo.get("P_UNIT"), "")             + CHR10
		        +   "PACKAGE : "            + nvl(valuesOfBkgQtyInfo.get("PACKAGE"), "")             + CHR10;
			
			if("ASA00435".equals(dtlVo.getEdiGrpCd())){
				mainMiddle0 = mainMiddle0 
				+	"CNTR_W_UNIT : "			+ nvl(searchCntrWeightInfoVO.getWgtUtCd(), "")+CHR10                                                                                                                                                                                                                                                                             
                +	"CNTR_WEIGHT : "			+ nvl(searchCntrWeightInfoVO.getCntrWgt(), "")+CHR10                                                                                                                                                                                                                                                                              
                +	"CNTR_MEA_UNIT : "		+ nvl(searchCntrWeightInfoVO.getMeasUtCd(), "")+CHR10                                                                                                                                                                                                                                                                          
                +	"CNTR_MEA_QTY : "		+ nvl(searchCntrWeightInfoVO.getMeasQty(), "")+CHR10                                                                                                                                                                                                                                                                            
                +	"CNTR_P_UNIT : "			+ nvl(searchCntrWeightInfoVO.getPckTpCd(), "")+CHR10                                                                                                                                                                                                                                                                             
                +	"CNTR_PACKAGE : "		+ nvl(searchCntrWeightInfoVO.getPckQty(), "")+CHR10  ;              
				
			}
			
			if("USA00684".equals(dtlVo.getEdiGrpCd())){
				mainMiddle0 = mainMiddle0 
				+	"CNTR_W_UNIT : "			+ nvl(searchCntrWeightInfoVO.getWgtUtCd(), "")+CHR10                                                                                                                                                                                                                                                                             
                +	"CNTR_WEIGHT : "			+ nvl(searchCntrWeightInfoVO.getCntrWgt(), "")+CHR10                                                                                                                                                                                                                                                                              
                +	"CNTR_MEA_UNIT : "		+ nvl(searchCntrWeightInfoVO.getMeasUtCd(), "")+CHR10                                                                                                                                                                                                                                                                          
                +	"CNTR_MEA_QTY : "		+ nvl(searchCntrWeightInfoVO.getMeasQty(), "")+CHR10
                +	"CNTR_TW_UNIT : "		+ 				"KGS"						+CHR10
                +	"CNTR_TWEIGHT : "		+ getCntrTareWeight(dtlVo.getCntrNo())  +  CHR10;              
				
			}
			
			//2011.06.30 채창호 [CHM-201111915-01]: [HP] 315 Event GMT 계산 오류 수정
            //현재시점 기준으로 EVENT DATE_GMT 데이터를 구하기 위해  변수에 데이터값을 따로 저장을 한다.
		    sendVo.setReEventDt(currVo.getCurrEventDt().substring(0, 12));
		    //2012.05.24 박찬민 [CHM-201217945] F/F 수정 - RD FLAG 추가
			String mainMiddle1 = 
						"CNTR NBR : "           + dtlVo.getCntrNo()                        	+ CHR10
					+   "CNTR TYPE : "          + dtlVo.getCntrTpszCd()                  	+ CHR10	;

			if("TRADIANT".equals(dtlVo.getCustTpId())){
				mainMiddle1 = mainMiddle1 
					+	"RD_FLAG : "	+  searchCntrWeightInfoVO.getRdCgoFlg()	 + CHR10	;
			}
			
			if("TRADIANT".equals(dtlVo.getCustTpId()) && 
					("EE".equals(dtlVo.getEdiSts()) || "MT".equals(dtlVo.getEdiSts()))){
				mainMiddle1 = mainMiddle1
							+   "F/M IND : "            + "M"       + CHR10;
			}else{
				mainMiddle1 = mainMiddle1
							+   "F/M IND : "            + "F"       + CHR10;
			}
			mainMiddle1 = mainMiddle1					
							+   "EVENT DATE : "         + currVo.getCurrEventDt().substring(0, 12) 	  + CHR10
							+   "EVENT DATE_GMT : "     + getEventDtGmt(sendVo)                     + CHR10
							+   "CUST_REF_NO : "        + getCustRefNo(dtlVo.getBkgNo())           + CHR10
							+   "LLOYD_CODE : "         + valuesOfVessleInfo.get("VSL_LLOYD_NO")          + CHR10
							+   "EVENT_LOC : "          + currVo.getCurrEventYard()                     + CHR10
							+   "EVENT_LOC_NAME : "     + nvl(valuesOfNoInfo.get("EVENT_LOC_NAME")   , "")         + CHR10;
					
	        if ("USA00035".equals(dtlVo.getEdiGrpCd())){
				mainMiddle1 = mainMiddle1
						+   "EVENT_YD_NAME : "     + nvl(valuesOfNoInfo2.get("EVENT_YD_NAME")   , "")         + CHR10;	
	        }
			
			mainMiddle1 = mainMiddle1	
							+   "EVENT_LOC_AMSQUAL : "  + nvl(valuesOfNoInfo.get("EVENT_LOC_AMSQUAL"), "")         + CHR10
							+   "EVENT_LOC_AMSPORT : "  + nvl(valuesOfNoInfo.get("EVENT_LOC_AMSPORT") , "")        + CHR10
							+   "PO NBR : "             + nvl(getBkgPoNo(dtlVo.getBkgNo()), "  ")  + CHR10
							+   "BL_PO_NBR : "          + nvl(getBkgPoNo(dtlVo.getBkgNo()), "  ")  + CHR10;
			
			log.info("\n EVENT DATE  === " + currVo.getCurrEventDt().substring(0, 12));
			log.info("\n EVENT DATE_GMT === " + getEventDtGmt(sendVo));
			
			Edi315PrefixMainBkgCustInfoVO       listm2 = searchBkgCustInfo(edi315SOpts);
			String strBkgCustInfo = 
	             	"SHPRCODE : "           + listm2.getShprcode()		+"\n"
	            +	"SHPR1 : "              + listm2.getShpr1()			+"\n"
	            +	"SHPR2 : "              + listm2.getShpr2()			+"\n"
	            +	"SHPR3 : "              + listm2.getShpr3()			+"\n"
	            +	"SHPR4 : "              + listm2.getShpr4()			+"\n"
	            +	"SHPR5 : "              + listm2.getShpr5()			+"\n"
	            +	"SHPR_CITY_NM : "       + listm2.getShprCityNm()	+"\n"
	            +	"SHPR_STAT_CD : "       + listm2.getShprStatCd()	+"\n"
	            +	"SHPR_ZIP_CD : "        + listm2.getShprZipCd()		+"\n"
	            +	"SHPR_CNT_CD : "        + listm2.getShprCntCd()		+"\n"
	            +	"CNEECODE : "           + listm2.getCneecode()		+"\n"
	            +	"CNEE1 : "              + listm2.getCnee1()			+"\n"
	            +	"CNEE2 : "              + listm2.getCnee2()			+"\n"
	            +	"CNEE3 : "              + listm2.getCnee3()			+"\n"
	            +	"CNEE4 : "              + listm2.getCnee4()			+"\n"
	            +	"CNEE5 : "              + listm2.getCnee5()			+"\n"
	            +	"CNEE_CITY_NM : "       + listm2.getCneeCityNm()	+"\n"
	            +	"CNEE_STAT_CD : "       + listm2.getCneeStatCd()	+"\n"
	            +	"CNEE_ZIP_CD : "        + listm2.getCneeZipCd()		+"\n"
	            +	"CNEE_CNT_CD : "        + listm2.getCneeCntCd()		+"\n"
	            +	"NTFYCODE : "           + listm2.getNtfycode()		+"\n"
	            +	"NTFY1 : "              + listm2.getNtfy1()			+"\n"
	            +	"NTFY2 : "              + listm2.getNtfy2()			+"\n"
	            +	"NTFY3 : "              + listm2.getNtfy3()			+"\n"
	            +	"NTFY4 : "              + listm2.getNtfy4()			+"\n"
	            +	"NTFY5 : "              + listm2.getNtfy5()			+"\n"
	            +	"NTFY_CITY_NM : "       + listm2.getNtfyCityNm()	+"\n"
	            +	"NTFY_STAT_CD : "       + listm2.getNtfyStatCd()	+"\n"
	            +	"NTFY_ZIP_CD : "        + listm2.getNtfyZipCd()		+"\n"
	            +	"NTFY_CNT_CD : "        + listm2.getNtfyCntCd()		+"\n";
            
			if("TRADIANT".equals(dtlVo.getCustTpId())){
				strBkgCustInfo = strBkgCustInfo 
					+	"ANTFYCODE : "	+  listm2.getAntfycode()	 + "\n";
			}
			
			
			
			
			
//			String[] KeyBkgCustInfoArray = new String[] {
//
//                    "SHPRCODE : "           ,
//                    "SHPR1 : "              ,
//                    "SHPR2 : "              ,
//                    "SHPR3 : "              ,
//                    "SHPR4 : "              ,
//                    "SHPR5 : "              ,
//                    "SHPR_CITY_NM : "       ,
//                    "SHPR_STAT_CD : "       ,
//                    "SHPR_ZIP_CD : "        ,
//                    "SHPR_CNT_CD : "        ,
//                    "CNEECODE : "           ,
//                    "CNEE1 : "              ,
//                    "CNEE2 : "              ,
//                    "CNEE3 : "              ,
//                    "CNEE4 : "              ,
//                    "CNEE5 : "              ,
//                    "CNEE_CITY_NM : "       ,
//                    "CNEE_STAT_CD : "       ,
//                    "CNEE_ZIP_CD : "        ,
//                    "CNEE_CNT_CD : "        ,
//                    "NTFYCODE : "           ,
//                    "NTFY1 : "              ,
//                    "NTFY2 : "              ,
//                    "NTFY3 : "              ,
//                    "NTFY4 : "              ,
//                    "NTFY5 : "              ,
//                    "NTFY_CITY_NM : "       ,
//                    "NTFY_STAT_CD : "       ,
//                    "NTFY_ZIP_CD : "        ,
//                    "NTFY_CNT_CD : "        
//					};
			
			String mainEnd = 
		            "REF_CUSTCODE : "       + refCustCode                                    + CHR10
		        +   "INV_NBR : "            + getSonyInvNo(dtlVo.getBkgNo())           		  + CHR10
		        +   "RD_TERM : "            + valuesOfBkgTerm.get("RD_TERM")                  + CHR10
		        +   "CUST_EDATE : "         + custEdate                                      + CHR10
		        +   "CUST_EDATE_GMT : "     + ""                                              + CHR10
		        +   "CUST_ADATE : "         + custAdate                                      + CHR10
		        +   "CUST_ADATE_GMT : "     + custAdateGmt                                  + CHR10
		        +   "CURRENT_VVD : "        + nvl(currVo.getCurrVvd(), "")          + CHR10
		        +   "CURRENT_VSL_NM : "     + nvl(currVo.getVslNm(), "")            + CHR10
		        +   "CURRENT_VSL_CNT_CD : " + nvl(currVo.getVslCntCd(), "")         + CHR10
		        +   "CURRENT_LLOYD_CD : "   + nvl(currVo.getLloydCd(), "")          + CHR10
		        +   "SEL NBR : "            + (String) nvl(selNbr)                           + CHR10
		        +   "LANE : "               + valuesOfBkgTerm.get("SLAN_CD")                  + CHR10
		        +   "LANE_DESC : "          + valuesOfBkgTerm.get("VSL_SLAN_NM")              + CHR10
		        +   "SC NBR : "             + valuesOfBkgTerm.get("SC_NO")                    + CHR10
		        +   "IT NBR : "             + itNbr                                          + CHR10
		        
		        // 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout -------------
		        +   "IT NBR DT : "			+ itNbrDt								+ CHR10
		        +   "INBOND NBR : "			+ inbondNbr								+ CHR10
		        +   "INBOND NBR DT : "		+ inbondNbrDt							+ CHR10
		        
		        +   "PICKUP NBR : "         + pickUpNbr								+ CHR10
		        
		        // 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout -------------
		        +   "FIRMS CODE : "         + firmsCode								+ CHR10;
		        // 2014.05.14 [CHM-201430096] [GTNDiageo] 315로직관련 긴급 수정 요청
		        // Diageo / EDI GROUP ID (COM 2557)일때 BKG_REFERENCE 에서 가져오기
		        if ("COM02557".equals(dtlVo.getEdiGrpCd())){
		        	mainEnd =  mainEnd 
		        	+   "SH REF NBR : "         + getBkgRefNo(dtlVo.getBkgNo(),"EBSH")		+ CHR10
			        +   "FW REF NBR : "         + getBkgRefNo(dtlVo.getBkgNo(),"EBFF")		+ CHR10
			        +   "SI SH REF NBR : "      + getBkgRefNo(dtlVo.getBkgNo(),"ESSH")		+ CHR10
			        +   "SI FF REF NBR : "      + getBkgRefNo(dtlVo.getBkgNo(),"ESFF")		+ CHR10;
		        }else{
		        	mainEnd =  mainEnd 
		        	+   "SH REF NBR : "         + getShipperRefno(dtlVo.getBkgNo())		+ CHR10
			        +   "FW REF NBR : "         + getForwardRefno(dtlVo.getBkgNo())		+ CHR10;
		        }
		        
			
			// 2010.10.26 김진승 [CHM-NotSet] Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에  Multi Booking No., BL No. 추가처리
			// // 2010.10.26 김진승  cust_trd_prnr_id = ‘6111470101’ => edi group code = 'USA00094' 뿐
			 if ("USA00094".equals(dtlVo.getEdiGrpCd()) ){
				
				String[][] multiResultArray = null; // Added By Kim Jin-seung In 2010.10.26

				ArrayList custTrdPrnrIdArryList = new ArrayList(); 
				custTrdPrnrIdArryList.add("6111470101"); // custTrdPrnrId
				
				multiResultArray = searchPrtlBkgsForEdiGrp(dtlVo.getBkgNo().trim(), dtlVo.getCntrNo(), custTrdPrnrIdArryList);

				StringBuffer tempmainEnd = new StringBuffer("");
				if (multiResultArray!=null && multiResultArray.length>0){
					for(int i=0; i<multiResultArray.length; i++){
						tempmainEnd.append("{MULTI_BKG_NBR" + CHR10);
						tempmainEnd.append("MULTI BKG NBR : " + multiResultArray[i][0]+ CHR10);
						tempmainEnd.append("}MULTI_BKG_NBR" + CHR10);
					}
					for(int i=0; i<multiResultArray.length; i++){
						tempmainEnd.append("{MULTI_BL_NBR" + CHR10);
						tempmainEnd.append("MULTI BL NBR : " + multiResultArray[i][1]+ CHR10);
						tempmainEnd.append("}MULTI_BL_NBR" + CHR10);
					}
					mainEnd = mainEnd + tempmainEnd.toString();
					tempmainEnd = null;
				}
			} 
			
		


			
			//2010-06-22 : YJLEE : [CHM-201004143] HP 화주(USA00051) 에 대해 DG IND : prefix 를 추가 하여 DG 화물은 Y, 그 외는 N으로 생성. 
	        if("USA00051".equals(dtlVo.getEdiGrpCd())){
	        	mainEnd = mainEnd + "DG IND : " +  nvl(dtlVo.getDcgoFlg(), "") + CHR10 ;
	        }
	       
	      //2010-10-07 : KYLEE : CHM-201113697 MITSUI-SOKO 315 EDI 셋업 관련 F/F 상 Cut Off Time 항목 추가 요청
	        //2012-02-14 : 박찬민 : [CHM-선반영] JC Penney CCT F/F 항목 추가 요청
	        if("COM02299".equals(dtlVo.getEdiGrpCd()) || "USA00053".equals(dtlVo.getEdiGrpCd())){

	        	String cutOffTime = searchCutOffTime(dtlVo.getBkgNo().trim());
	        	//dtlVo.setCutoffTm(cutOffTime);
	        	
	        	mainEnd = mainEnd + "CUTOFF_TM : " +  nvl(cutOffTime, "") + CHR10 ;
	        }
	        
	        //2016-02-02 : PY CHO, MJ KIM : [CHM-201639643] Microsoft TMC Dwell Reason 항목 추가
	        if("COM02879".equals(dtlVo.getEdiGrpCd())){
	        	String msDwllRsnCd = "";
	        	String msDwllRmk = "";
	        	if("SD".equals(dtlVo.getEdiSts())){ // TMC의 모든 이벤트들에는 EXPT_CD, EXPT_RMK Flat File 항목이 포함되어야 함
	        	msDwllRsnCd = searchMsDwllRsnCd(dtlVo.getCopNo().trim());
	        	msDwllRmk = searchMsDwllRmk(dtlVo.getCopNo().trim());
	        	}
	        	mainEnd = mainEnd + "EXPT_CD : " +  nvl(msDwllRsnCd, "") + CHR10 ;
	        	mainEnd = mainEnd + "EXPT_RMK : " +  nvl(msDwllRmk, "") + CHR10 ;
	        }
	        
			String[] keyBkgVvdInfoArray = new String[] {
			        "BVVD1:"                ,
			        "VSL_CALLSIGN1:"        ,
			        "VSL_LLOYDCODE1:"       ,
			        "VSL_FULLNAME1:"        ,
			        "BLPOL1:"               ,
			        "POL_FULLNAME1:"        ,
			        "BLPOD1:"               ,
			        "POD_FULLNAME1:"        ,
			        "POLETA1:"              ,
			        "POLETA1_GMT:"          ,
			        "POLATA1:"              ,
			        "POLATA1_GMT:"          ,
			        "POLETD1:"              ,
			        "POLETD1_GMT:"          ,
			        "POLATD1:"              ,
			        "POLATD1_GMT:"          ,
			        "PODETA1:"              ,
			        "PODETA1_GMT:"          ,
			        "PODATA1:"              ,
			        "PODATA1_GMT:"          ,
			        "PODETD1:"              ,
			        "PODETD1_GMT:"          ,
			        "PODATD1:"              ,
			        "PODATD1_GMT:"          			   
			        };
			String strBkgVvdInfoHeader = "{BKGVVD" + CHR10;
			String strBkgVvdInfoFooter = "}BKGVVD" + CHR10;
			String[] keyIrgInfoArray = new String[] {
			        "MODE: "                ,
			        "VENDOR: "              ,
			        "FROM_LOC: "            ,
			        "FROM_ARV_DT: "         ,
			        "FROM_ARV_DT_GMT: "     ,
			        "FROM_DPT_DT: "         ,
			        "FROM_DPT_DT_GMT: "     ,
			        "TO_LOC: "              ,
			        "TO_ARV_DT: "           ,
			        "TO_ARV_DT_GMT: "       
			        };
			String strIrgInfoHeader = "{IRG_INFO" + CHR10;
			String strIrgInfoFooter = "}IRG_INFO" + CHR10;


			  
//			String strCopInfo 		= makingPreFix(mergeIntoMain(edi315SendMainVo,edi315SOpts) , null, null, KeyCopInfoArray);
//			String ff_flg = "T";//temp 추후 table 관리 예정
//			modifySceEdiHisDtl(ff_flg, strCopInfo, dtlVo);
//			String strBkgCustInfo 	= makingPreFix(mergeIntoMain(edi315SendMainVo, edi315SOpts), null, null, KeyBkgCustInfoArray);
		
			String prefixV 			= makingPreFix(mergeIntoBkgVvdInfo     (edi315SOpts, dtlVo), strBkgVvdInfoHeader, strBkgVvdInfoFooter, keyBkgVvdInfoArray);
			String prefixI 			= makingPreFix(mergeIntoInLandRouteInfo(edi315SOpts), strIrgInfoHeader   , strIrgInfoFooter   , keyIrgInfoArray);
			String main_ff = (main0 + strCopInfo + mainMiddle0 + mainMiddle1); // main_ff 와 post_ff 사이에 화주에 따라 prefix 가 달라져서 나눔.
			String post_ff =  strBkgCustInfo + mainEnd + prefixV + prefixI;
			
			SceFltFileMsgVO ffMsgVo = new SceFltFileMsgVO();
			StringBuffer ediStringBuffer = new StringBuffer();
			String flt_file_ref_no = "";
			String send_result_flag = "A";
			

			/* Not in case of Walmart */
			if (!"925485US00".equals(dtlVo.getCustTpId())	|| "Y".equals(wallmart_count)) {
				// !!!!! !!"#In the case of Non-Wall-Mart - case No:0");
				// 2012.09.04 채창호 [CHM-201219890]  Missing Container PO No (CNTR_PO_NBR) in 315 flat file
				String cntr_po_nbr = searchCntrPoNbr(dtlVo.getBkgNo(), dtlVo.getCntrNo());   // valuesOfPoSealInfo.get("CNTR_PO_NBR");
				String bl_store_nbr = valuesOfBkgQtyInfo.get("BL_STORE_NBR");
//				ediString = main_ff 
//								+ "CNTR_PO_NBR : "  + nvl(cntr_po_nbr ,"") + CHR10
//								+ "BL_STORE_NBR : " + nvl(bl_store_nbr,"") + CHR10;
				ediStringBuffer.append(main_ff);
				ediStringBuffer.append("CNTR_PO_NBR : ");
				ediStringBuffer.append(nvl(cntr_po_nbr ,""));
				ediStringBuffer.append(CHR10);
				
				// 2016.03.29 [CHM-201640744] [긴급 Microsoft] TMC 315 EDI 자동 발송 배치 요청  
				// LOAD_ID 추가
				if ("COM02879".equals(dtlVo.getEdiGrpCd())){	
					String load_id = searchLoadId(dtlVo.getBkgNo(), dtlVo.getCntrNo()); 
					ediStringBuffer.append("LOAD_ID : ");
					ediStringBuffer.append(nvl(load_id ,""));
					ediStringBuffer.append(CHR10);
				}
				
				// 2015.07.03 김민정 [CHM-201536549-01] 아마존 flat file에 multiple P.O. NO. 표기 요청  
				// AMAZON ('USA00630','USA00631') - MULTIPLE ITEM PO NBR 추가
				if ("USA00630".equals(dtlVo.getEdiGrpCd()) || "USA00631".equals(dtlVo.getEdiGrpCd())){
					
					String[] resultArray = null;			
					resultArray = getItemPoNo(dtlVo.getBkgNo(), dtlVo.getCntrNo());

					if (resultArray!=null && resultArray.length>0){
						for(int i=0; i<resultArray.length; i++){
							ediStringBuffer.append("{ITEM_PO" + CHR10);
							ediStringBuffer.append("ITEM_PO_NBR : " + resultArray[i]+ CHR10);
							ediStringBuffer.append("}ITEM_PO" + CHR10);
						}
					}
				} 
								
				ediStringBuffer.append("BL_STORE_NBR : ");
				ediStringBuffer.append(nvl(bl_store_nbr,""));
				ediStringBuffer.append(CHR10);
				ediStringBuffer.append(post_ff);
				
				if ("USA00051".equals(dtlVo.getEdiGrpCd())) {
					
					List<String> hp_refs = getBkgEDIHPRef(dtlVo.getBkgNo());
					if (hp_refs != null) {
						for (int i = 0; i < hp_refs.size(); i++) {
							ediStringBuffer.append(hp_refs.get(i));
							ediStringBuffer.append(CHR10);
							
						}
					}
				}
				
				// [CHM-201324075] 315 FF 확장 요청(ASA00284/ IKEA/ IKEA.EBCCNS1 일 경우만 추가)
				if ("ASA00284".equals(dtlVo.getEdiGrpCd())) {
					Edi315XterRqstNoVO xterRqstNoVO = dbDao.searchCust315XterInfo(dtlVo.getBkgNo());

					if ( xterRqstNoVO != null ) {
						String ediXterInfo = JSPUtil.getNull(dbDao.searchCust315XterInfo(xterRqstNoVO));
						ediStringBuffer.append(ediXterInfo);
						ediStringBuffer.append(CHR10);
					}
						
				}
				
				HashMap<String, String> valuesOfFFKey = getSNDSEQ();
				String ff_ymmdd  = valuesOfFFKey.get("FF_YMMDD");
				String ff_seq    = valuesOfFFKey.get("FF_SEQ");
				
				flt_file_ref_no = "";
				flt_file_ref_no = "SCM" + ff_ymmdd + lpad(ff_seq, 6, "0");
				
				send_result_flag = sendProcess( ediStringBuffer.toString(), "", flt_file_ref_no, sendVo, dtlVo, currVo);
				ffMsgVo.setEdiEvntDt(currVo.getCurrEventDt());
				ffMsgVo.setEdiEvntNodCd(currVo.getCurrEventYard());

				
				// SCE_FLG_FILE_MSG 테이블에 컬럼과 데이타 일치하지 않는것 수정 2010.05.04 BY OHK
				ffMsgVo.setProvTrdPrnrId(dtlVo.getHostTpId());
				ffMsgVo.setCustTrdPrnrId(dtlVo.getCustTpId());
				ffMsgVo.setBlNo(dtlVo.getBlNo());
					
				ffMsgVo.setEdiRcvSeq(dtlVo.getRcvSeq());
				ffMsgVo.setEdiRcvDtlSeq(dtlVo.getRcvDtlSeq());
				
				ffMsgVo.setCrntVslCd((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(0,4) : "" ));	
				ffMsgVo.setCrntSkdVoyNo((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(4,8) : "" ));
				ffMsgVo.setCrntSkdDirCd((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(8,9) : "" ));				
				
				ffMsgVo.setTrnkVslCd(dtlVo.getTrunkVvd().substring(0,4));
				ffMsgVo.setTrnkSkdVoyNo(dtlVo.getTrunkVvd().substring(4,8));
				ffMsgVo.setTrnkSkdDirCd(dtlVo.getTrunkVvd().substring(8,9));
				ffMsgVo.setCallVslCd((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(0,4) : "" ));
				ffMsgVo.setCallSkdVoyNo((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(4,8) : "" ));
				ffMsgVo.setCallSkdDirCd((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(8,9) : "" ));

				
				//ffMsgVo.setUpdUsrId(sendVo.getCurrVvd());
				ffMsgVo.setUpdUsrId(sendVo.getUpdId());
				ffMsgVo.setCreUsrId(sendVo.getCreId());
				ffMsgVo.setIbdTrspNo(itNbr);
				log.info("\n VIP315FFNO='"+flt_file_ref_no+"'\n");
				
				//sce_flt_file_msg 테이블 pk 정보 set
				SceFltFileMsgVO ffMsgPKVo = searchEdi315FlatFileKey();
				ffMsgVo.setEdiSndDt(ffMsgPKVo.getEdiSndDt());
				ffMsgVo.setEdiSndHr(ffMsgPKVo.getEdiSndHr());
				ffMsgVo.setEdiSndSeq(ffMsgPKVo.getEdiSndSeq());

				
	
				addSceFltFileMsg(flt_file_ref_no
								, listm1 //Edi315PrefixMainCOPInfoVO
								, dtlVo
								, ffMsgVo
								);
				
				//sce_flt_file_msg_dtl_vsl 테이블에 pk 정보 set 2010.05.04 BY OHK
				List<SceFltFileMsgDtlVslVO> vslInfo = dtlVo.getVslInfo();
				if(vslInfo != null && vslInfo.size() >0){
					for(int i=0; i<vslInfo.size(); i++){
						SceFltFileMsgDtlVslVO vslVo = vslInfo.get(i);
						vslVo.setEdiSndDt(ffMsgPKVo.getEdiSndDt());
						vslVo.setEdiSndHr(ffMsgPKVo.getEdiSndHr());
						vslVo.setEdiSndSeq(ffMsgPKVo.getEdiSndSeq());	
						vslVo.setFltFileRefNo(flt_file_ref_no);
						vslVo.setVvdSeq(Integer.toString(i+1));
						vslVo.setCreUsrId(ffMsgVo.getCreUsrId());
						vslVo.setUpdUsrId(ffMsgVo.getUpdUsrId());						
						addSceFltFileMsgDtl(vslVo);
					}
				}				
			}
			/* In case of Wallmart */
			
			if ("925485US00".equals(dtlVo.getCustTpId())) {
//				int wal_po_cnt = 0;
				String bl_store_nbr = valuesOfBkgQtyInfo.get("BL_STORE_NBR");
				List wallPoNbrs = getWallPoNbr(dtlVo.getBkgNo(),	dtlVo.getCntrNo());
				
				int wallPoNbrRowCnt = 0;
				if (wallPoNbrs != null) {
					wallPoNbrRowCnt = wallPoNbrs.size();
					log.info("\n wallPoNbrRowCnt:'"+wallPoNbrRowCnt+"'");
				}

				for (int n = 0; n < wallPoNbrRowCnt; n++) {

					wallmart_count = "N";
					String wallPoNbr = "";
					wallPoNbr = wallPoNbrs.get(n).toString();
					
					ediStringBuffer = new StringBuffer();
//					ediString = main_ff 
//									+ "CNTR_PO_NBR : "  + nvl(wallPoNbr, "")   + CHR10
//									+ "BL_STORE_NBR : " + nvl(bl_store_nbr, "") + CHR10 ;
//					ediString = ediString + post_ff;
					ediStringBuffer.append(main_ff);
					ediStringBuffer.append("CNTR_PO_NBR : ");
					ediStringBuffer.append(nvl(wallPoNbr, ""));
					ediStringBuffer.append(CHR10);
					ediStringBuffer.append("BL_STORE_NBR : ");
					ediStringBuffer.append(nvl(bl_store_nbr, ""));
					ediStringBuffer.append(CHR10);
					
					String send_result_flag_wall_case = "N";
					HashMap<String, String> valuesOfFFKey = getSNDSEQ();
//					String ff_yymmdd = valuesOfFFKey.get("FF_YYMMDD");
					String ff_ymmdd  = valuesOfFFKey.get("FF_YMMDD");
					String ff_seq    = valuesOfFFKey.get("FF_SEQ");
					
					flt_file_ref_no = "";
					flt_file_ref_no = "SCM" + ff_ymmdd + lpad(ff_seq, 6, "0");

					

					send_result_flag_wall_case = sendProcess(ediStringBuffer.toString(), wallPoNbr,flt_file_ref_no,
							sendVo,  
			                dtlVo,
			                currVo);
					
					if(!send_result_flag.equalsIgnoreCase("N")){
						send_result_flag = send_result_flag_wall_case ;
					}
					ffMsgVo.setEdiEvntDt(currVo.getCurrEventDt());
					ffMsgVo.setEdiEvntNodCd(currVo.getCurrEventYard());
					

					// SCE_FLG_FILE_MSG 테이블에 컬럼과 데이타 일치하지 않는것 수정 2010.05.04 BY OHK
					ffMsgVo.setProvTrdPrnrId(dtlVo.getHostTpId());
					ffMsgVo.setCustTrdPrnrId(dtlVo.getCustTpId());
					ffMsgVo.setBlNo(dtlVo.getBlNo());
					
					ffMsgVo.setEdiRcvSeq(dtlVo.getRcvSeq());
					ffMsgVo.setEdiRcvDtlSeq(dtlVo.getRcvDtlSeq());
					ffMsgVo.setCrntVslCd((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(0,4) : "" ));				
					ffMsgVo.setCrntSkdVoyNo((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(4,8) : "" ));
					ffMsgVo.setCrntSkdDirCd((currVo.getCurrVvd() != null && currVo.getCurrVvd().length()==9 ? currVo.getCurrVvd().substring(8,9) : "" ));				
					
					
					ffMsgVo.setTrnkVslCd(dtlVo.getTrunkVvd().substring(0,4));
					ffMsgVo.setTrnkSkdVoyNo(dtlVo.getTrunkVvd().substring(4,8));
					ffMsgVo.setTrnkSkdDirCd(dtlVo.getTrunkVvd().substring(8,9));
					ffMsgVo.setCallVslCd((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(0,4) : "" ));
					ffMsgVo.setCallSkdVoyNo((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(4,8) : "" ));
					ffMsgVo.setCallSkdDirCd((sendVo.getCurrVvd() != null && sendVo.getCurrVvd().length()==9 ? sendVo.getCurrVvd().substring(8,9) : "" ));

					//ffMsgVo.setUpdUsrId(sendVo.getCurrVvd());
					ffMsgVo.setUpdUsrId(sendVo.getUpdId());
					ffMsgVo.setCreUsrId(sendVo.getCreId());
					ffMsgVo.setIbdTrspNo(itNbr);
									
					//sce_flt_file_msg 테이블 pk 정보 set
					SceFltFileMsgVO ffMsgPKVo = searchEdi315FlatFileKey();
					ffMsgVo.setEdiSndDt(ffMsgPKVo.getEdiSndDt());
					ffMsgVo.setEdiSndHr(ffMsgPKVo.getEdiSndHr());
					ffMsgVo.setEdiSndSeq(ffMsgPKVo.getEdiSndSeq());
										
					
					log.info("\n VIP315FFNO(wallmart)='"+flt_file_ref_no+"'\n");
					addSceFltFileMsg(flt_file_ref_no
									, listm1 //Edi315PrefixMainCOPInfoVO
									, dtlVo
									, ffMsgVo
									);
					//sce_flt_file_msg_dtl_vsl 테이블에 pk 정보 set 2010.05.04 BY OHK
					List<SceFltFileMsgDtlVslVO> vslInfo = dtlVo.getVslInfo();
					if(vslInfo != null && vslInfo.size() >0){
						for(int i=0; i<vslInfo.size(); i++){
							SceFltFileMsgDtlVslVO vslVo = vslInfo.get(i);
							vslVo.setEdiSndDt(ffMsgPKVo.getEdiSndDt());
							vslVo.setEdiSndHr(ffMsgPKVo.getEdiSndHr());
							vslVo.setEdiSndSeq(ffMsgPKVo.getEdiSndSeq());	
							vslVo.setFltFileRefNo(flt_file_ref_no);
							vslVo.setVvdSeq(Integer.toString(i+1));
							vslVo.setCreUsrId(ffMsgVo.getCreUsrId());
							vslVo.setUpdUsrId(ffMsgVo.getUpdUsrId());						
							addSceFltFileMsgDtl(vslVo);
						}
					}
				}
			}
			
			



			return send_result_flag;
		} catch (EventException ex) {
			log.info(ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			log.info(e);
			throw new EventException(e.getMessage(), e);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}
	}
	
	

    /**
	 * sendProcess 
	 * MQ발송과 Logging Process.
	 * 
	 * @param String ediString
	 * @param String po_nbr
	 * @param String flt_file_ref_no
	 * @param Edi315SendVO sendVo
	 * @param Edi315DetailVO dtlVo
	 * @param Edi315CurrInfoVO currVo
	 * @return String
	 * @exception EventException
	 */
    private String sendProcess(	String ediString, 
								String po_nbr, 
								String flt_file_ref_no, 
								Edi315SendVO sendVo,
				                Edi315DetailVO dtlVo,
				                Edi315CurrInfoVO currVo) throws EventException {
		
		boolean insert_noGen_row = false;
		boolean insert_sndRslt_row = false;
//		String reString = "";
		String r_flg = "N";
		try {
			
			String ff_yymmdd = "1"+flt_file_ref_no.substring(3, 8);
			String ff_seq    = flt_file_ref_no.substring(8, 14);
			

			String headerStr = "$$$MSGSTART:"
					+ rpad(dtlVo.getHostTpId(), 20, "  ")
					+ rpad(dtlVo.getCustTpId(), 20, "  ")
					+ rpad("315", 10, "  ") + flt_file_ref_no + CHR10
					+ "MUID : " + sysDate() + CHR10;
			ediString = headerStr + ediString;
			
			
			insert_noGen_row = addSceFltFileNoGen(
					ff_yymmdd, 
					ff_seq, 
					ediString,
					sendVo, 
					dtlVo);
			
			
//			if(ediString.length()>3800){
//				String subEdiString = "!"+ediString.substring(0, 3800);
//				modifySceEdiHisDtlEdiRmk2(subEdiString, dtlVo);
//				
//			}else{
//				modifySceEdiHisDtlEdiRmk2(ediString, dtlVo);
//			}
			log.info("\n sendEDIMQ dtlVo.getRsltFlg() : "+dtlVo.getRsltFlg()+"\n");
			if( !"R".equals(dtlVo.getRsltFlg()) &&
				!"Y".equals(dtlVo.getSndSkipFlg())){
				r_flg = sendEDIMQ(ediString);
			}else{
				r_flg = dtlVo.getRsltFlg();
			}

			if(!"Y".equals(dtlVo.getSndSkipFlg())){
				insert_sndRslt_row = addSceEdiSndRslt(
						ff_yymmdd, 
						ff_seq,
						flt_file_ref_no,
						po_nbr,
						sendVo, dtlVo, currVo);
				
			}
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return r_flg;
	}
	
//	@CHM-201004567-01 Batch VIP315 발송 - 수정 By Kim Jin-seung In 2010-07-08
//    /**
//	 * getSplitBkgPantosCase 
//	 * 
//	 * @param String bkg_no
//	 * @return String
//	 * @exception EventException
//	 */
//    public String getSplitBkgPantosCase(String bkg_no) throws EventException{
//        try {
//	           String splitBkgPantosCase = dbDao.getSplitBkgPantosCase(bkg_no);
//			   return splitBkgPantosCase;
//		   } catch (DAOException e) {
//				throw new EventException(e.getMessage(),e);
//		   } 
//    }

//	@CHM-201004567-01 Batch VIP315 발송 - 수정 By Kim Jin-seung In 2010-07-08
//    /**
//	 * getSplitBkgPantosBlNo 
//	 * 
//	 * @param String bkg_no
//	 * @return String
//	 * @exception EventException
//	 */
//    public String getSplitBkgPantosBlNo(String bkg_no) throws EventException{
//        try {
//	           String pantos_bl_no = dbDao.getSplitBkgPantosBlNo(bkg_no);
//			   return pantos_bl_no ;
//		   } catch (DAOException e) {
//				throw new EventException(e.getMessage(),e);
//		   } 
//    }

    /**
	 * getHobbyLobbyDateTime 
	 * day-1, 23:59 으로 Date 변경 하여 Flat File 생성 한다. 
	 * @param String bkg_no
	 * @param String postfix
	 * @return String
	 * @exception EventException
	 */
    private String getHobbyLobbyDateTime(String event_dt,String postfix) throws EventException {
    	try {
    		return dbDao.getHobbyLobbyDateTime(substr(event_dt, 0, 8),postfix);
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
    }
    /**
	 * getGmtDt 
	 * 오라클의 GLOBALDATE_PKG.TIME_CONV_FNC(,,) 기능 구현
	 * @param String event_dt
	 * @param String nod_cd
	 * @return String
	 * @exception EventException
	 */
    private String getGmtDt(String event_dt, String nod_cd) throws EventException {
    	try {
    		return dbDao.getGmtDt(event_dt,nod_cd);
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
    }
    

	

    /**
	 * getEvntDt 
	 * 
	 * @param Edi315DetailVO dtlVo
	 * @return GetEvntDtVO
	 * @exception EventException
	 */
    private GetEvntDtVO getEvntDt(Edi315DetailVO dtlVo) throws EventException {
    	List<GetEvntDtVO> list = null;
    	try {
    		list = dbDao.getEvntDt(dtlVo);
    		
    		return list.get(0);
    		 
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
    }
    /**
     * getCurrInfoVoWithIsCurrCopDtl
	 * 발송 Status에 해당 하는 Event Date, Event Yard, sce_dtl_seq 등을 조회.
	 * @param String event_yard
	 * @param Edi315DetailVO dtlVo
	 * @return CurrEventDtYdVO
	 * @exception EventException
	 */
    private CurrEventDtYdVO getCurrInfoVoWithIsCurrCopDtl(String event_yard, Edi315DetailVO dtlVo) throws EventException {
		CurrEventDtYdVO currEventDtYdVO = null ;
		String edi_rmk1 = "";
		String rcv_dt      = dtlVo.getRcvDt();
		String rcv_seq     = dtlVo.getRcvSeq();
		String rcv_dtl_seq = dtlVo.getRcvDtlSeq();
		try {
			
			currEventDtYdVO =  dbDao.getCurrInfoVoWithIsCurrCopDtl(event_yard, dtlVo.getCopNo(), dtlVo.getEdiSts() ,dtlVo.getOrgEdiSts() ,dtlVo.getEdiGrpCd());
			
			if(currEventDtYdVO == null){
				edi_rmk1 = "CurrCopDtlNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}else if("".equals(currEventDtYdVO.getCurrCopDtlSeq())){
				edi_rmk1 = "CurrCopDtlSeqNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}else if("".equals(currEventDtYdVO.getCurrEventDt())){
				edi_rmk1 = "CurrCopDtlDtNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}else if("".equals(currEventDtYdVO.getCurrEventYard())){
				edi_rmk1 = "CurrCopDtlYdNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}
			
			return currEventDtYdVO;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	/**
	 * getAutoVdSend
	 * VE -> VDL,VDT인 경우 COP_DTL_SEQ, EVENT YARD, EVENT DT 등을 조회.
	 * @param String cop_no
	 * @return CurrEventDtYdVO
	 * @exception EventException
	 */	
    private CurrEventDtYdVO getAutoVdSend(String cop_no) throws EventException {
		CurrEventDtYdVO currEventDtYdVO = null ;

		try {
			currEventDtYdVO =  dbDao.getAutoVdSend(cop_no);
			return currEventDtYdVO;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	
	
	/**
	 * getCurrVvdInfo
	 * 발송 Status 에 해당 하는 Current VVD 정보를 가져옴.
	 * 
	 * @param String curr_event_yard
	 * @param Edi315DetailVO detailVo
	 * @return CurrVvdVO
	 * @exception EventException
	 */	
    private CurrVvdVO getCurrVvdInfo(String curr_event_yard, Edi315DetailVO detailVo) throws EventException {
		CurrVvdVO currVvdVo = null ;
		String edi_rmk1 = "";
		String rcv_dt      = detailVo.getRcvDt();
		String rcv_seq     = detailVo.getRcvSeq();
		String rcv_dtl_seq = detailVo.getRcvDtlSeq();
		try {
			
			currVvdVo =  dbDao.getCurrVvdInfo(curr_event_yard, detailVo.getCopNo(), detailVo.getEdiSts());
			
			if(currVvdVo == null){
				edi_rmk1 = "CurrVvdRSQLNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}else if("".equals(currVvdVo.getCurrVvd())){
				edi_rmk1 = "getCurrVvdNull";
				dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, rcv_dt, rcv_seq, rcv_dtl_seq);
			}
			
			return currVvdVo;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	
    
	
    /**
     * search315MasterList
	 * 발송시 필요한 기본 컬럼 값들 조회. BKG_BOOKING, SCE_COP_HDR 등의 정보.
	 * @param String cop_no
	 * @return List<Edi315MasterVO> 
	 * @exception EventException
	 */
    private List<Edi315MasterVO> search315MasterList(String cop_no) throws EventException{
		try {
			return dbDao.search315MasterList(cop_no);
		} catch (DAOException e) {
		// TODO Auto-generated catch block
		throw new EventException(e.getMessage(),e);
		}
	}
    
	/**
	 * search315DetailList
	 * 발송 대상이 되는 모든 화주/Status를 조회 하는 중요 쿼리.
	 * @param Edi315SendVO edi315Vo
	 * @return List<Edi315DetailVO>
	 * @exception EventException
	 */	
    private List<Edi315DetailVO> search315DetailList(Edi315SendVO edi315Vo) throws EventException{
		try  {
		      List<Edi315DetailVO> list = dbDao.search315DetailList(edi315Vo);
		      return list;
	    } catch (DAOException e) {
		  throw new EventException(e.getMessage(),e);
	    }
		
		
	}
//	/**
//	 * 결과를 해당 VO를 받은 List 에 저장<br>
//	 * 
//	 * @param Edi315SendOptionsVO edi315SOpts
//	 * @return List<Edi315PrefixMainCOPInfoVO> 
//	 * @exception EventException
//	 */
//	public List<Edi315PrefixMainCOPInfoVO> searchCOPInfoT(Edi315SendOptionsVO edi315SOpts)throws EventException{
//		try {
//			  List<Edi315PrefixMainCOPInfoVO> list = dbDao.searchCOPInfo(edi315SOpts);
//		      if(list != null && list.size() > 0){        
//		    	   Edi315PrefixMainCOPInfoVO mvo = list.get(0);
//		    	   }
//			  return list;
//		} catch (DAOException e) {
//			  throw new EventException(e.getMessage(),e);
//		}
//	}
//as-is searchCOPInfo
//	public Edi315PrefixMainCOPInfoVO searchCOPInfo(Edi315SendOptionsVO edi315SOpts)throws EventException{
//		Edi315PrefixMainCOPInfoVO mvo = new Edi315PrefixMainCOPInfoVO();
//		try {
//			List<Edi315PrefixMainCOPInfoVO> list = dbDao.searchCOPInfo(edi315SOpts);
//			if (list != null && list.size() > 0) {
//				mvo = list.get(0);
//			}
//			return mvo;
//		} catch (DAOException e) {
//			  throw new EventException(e.getMessage(),e);
//		}
//	}
	//ObjectCloner.build(mstVo,detailVo);
	/**
	 * searchCOPInfo
	 * 
	 * @param Edi315SendOptionsVO edi315SOpts
	 * @return Edi315PrefixMainCOPInfoVO
	 * @exception EventException
	 */
    private Edi315PrefixMainCOPInfoVO searchCOPInfo(Edi315SendOptionsVO edi315SOpts)throws EventException{
		Edi315PrefixMainCOPInfoVO mvo = new Edi315PrefixMainCOPInfoVO();
		try {
			List<Edi315PrefixMainCOPInfoPorVO> por = dbDao.searchCOPInfoPor(edi315SOpts);
			List<Edi315PrefixMainCOPInfoPolVO> pol = dbDao.searchCOPInfoPol(edi315SOpts);
			List<Edi315PrefixMainCOPInfoPodVO> pod = dbDao.searchCOPInfoPod(edi315SOpts);
			List<Edi315PrefixMainCOPInfoDelVO> del = dbDao.searchCOPInfoDel(edi315SOpts);
			List<Edi315PrefixMainCOPInfoPorDtVO> porDt = dbDao.searchCOPInfoPorDt(edi315SOpts);
			List<Edi315PrefixMainCOPInfoPolDtVO> polDt = dbDao.searchCOPInfoPolDt(edi315SOpts);
			List<Edi315PrefixMainCOPInfoPodDtVO> podDt = dbDao.searchCOPInfoPodDt(edi315SOpts);
			List<Edi315PrefixMainCOPInfoDelDtVO> delDt = dbDao.searchCOPInfoDelDt(edi315SOpts);
			log.info("\n searchCOPInfo delDt : "+delDt.toString()+", delDt.size() : "+delDt.size());
			if(delDt == null || delDt.size()==0){
				int uvd_cnt = dbDao.getUvdCnt(edi315SOpts.getCopNo());
				
				log.info("\n searchCOPInfo uvd_cd : "+uvd_cnt);
				
				if(uvd_cnt>=2){
					
					delDt   = dbDao.searchCOPInfoDelDtIywd(edi315SOpts);
					log.info("\n searchCOPInfo delDt(uvd_cnt>=2) : "+delDt.toString()+", delDt.size() : "+delDt.size());
					
				}
			}
			
			
			
			if(por != null && por.size()>0 ){
				ObjectCloner.build(por.get(0),mvo);
				if(por.size()>1){
					log.info("\n 315SendError : por.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPorCode("");
				mvo.setPorName("");
				mvo.setPorAmsport("");
				mvo.setPorAmsqual("");
				log.info("\n 315SendError : por.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}
			
			
			if(pol != null && pol.size()>0 ){
				ObjectCloner.build(pol.get(0),mvo);
				if(pol.size()>1){
					log.info("\n 315SendError : pol.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPolCode(edi315SOpts.getEPolLoc());
				mvo.setPolName("");
				mvo.setPolAmsport("");
				mvo.setPolAmsqual("");
				log.info("\n 315SendError : pol.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(pod != null && pod.size()>0 ){
				ObjectCloner.build(pod.get(0),mvo);
				if(pod.size()>1){
					log.info("\n 315SendError : pod.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPodCode(edi315SOpts.getEPodLoc());
				mvo.setPodName("");
				mvo.setPodAmsport("");
				mvo.setPodAmsqual("");
				log.info("\n 315SendError : pod.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}
			
			
			if(del != null && del.size()==1 ){
				ObjectCloner.build(del.get(0),mvo);
				if(del.size()>1){
					log.info("\n 315SendError : del.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setDelCode("");
				mvo.setDelName("");
				mvo.setDelAmsport("");
				mvo.setDelAmsqual("");
				log.info("\n 315SendError : del.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			
			
			
			
			
			
			
			if(porDt != null && porDt.size()>0 ){
				ObjectCloner.build(porDt.get(0),mvo);
				if(porDt.size()>1){
					log.info("\n 315SendError : porDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPorEtd("");
				mvo.setPorAtd("");
				mvo.setPorEtdGmt("");
				mvo.setPorAtdGmt("");
				log.info("\n 315SendError : porDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(polDt != null && polDt.size()>0 ){
				ObjectCloner.build(polDt.get(0),mvo);
				if(polDt.size()>1){
					log.info("\n 315SendError : polDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPolEta("");
				mvo.setPolAta("");
				mvo.setPolAtd("");
				mvo.setPolEtd("");
				mvo.setPolEtaGmt("");
				mvo.setPolAtaGmt("");
				mvo.setPolEtdGmt("");
				mvo.setPolAtdGmt("");
				log.info("\n 315SendError : polDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(podDt != null && podDt.size()>0 ){
				ObjectCloner.build(podDt.get(0),mvo);
				if(podDt.size()>1){
					log.info("\n 315SendError : podDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPodEta("");
				mvo.setPodAta("");
				mvo.setPodAtd("");
				mvo.setPodEtd("");
				mvo.setPodEtaGmt("");
				mvo.setPodAtaGmt("");
				mvo.setPodEtdGmt("");
				mvo.setPodAtdGmt("");
				log.info("\n 315SendError : podDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}	
			
			
			if(delDt != null && delDt.size()>0 ){
				ObjectCloner.build(delDt.get(0),mvo);
				if(delDt.size()>1){
					log.info("\n 315SendError : delDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setDelEta("");
				mvo.setDelAta("");
				mvo.setDelEtaGmt("");
				mvo.setDelAtaGmt("");
				log.info("\n 315SendError : delDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}

			
			
			
			
			
			
			
			
			
			log.info("\n searchCOPInfo mvo.toString() : \n"+mvo.toString());
			
			
			return mvo;
		} catch (DAOException e) {
			  throw new EventException(e.getMessage(),e);
		}
	}
	
	
	/**
	 * searchBkgCustInfo
	 * BKG_CUSTOMER 테이블에서 Customer 정보를 가져온다.
	 * @param Edi315SendOptionsVO edi315SOpts
	 * @return Edi315PrefixMainBkgCustInfoVO 
	 * @exception EventException
	 */	
    private Edi315PrefixMainBkgCustInfoVO searchBkgCustInfo(Edi315SendOptionsVO edi315SOpts)throws EventException{
		Edi315PrefixMainBkgCustInfoVO mvo = new Edi315PrefixMainBkgCustInfoVO();
		try {
			List<Edi315PrefixMainBkgCustInfoVO> list = dbDao.searchBkgCustInfo(edi315SOpts);
			if(list != null && list.size() > 0){
				mvo = list.get(0);
			}
			return mvo;
		} catch (DAOException e) {
			  throw new EventException(e.getMessage(),e);
		}
	}	

//	/**
//	 * searchBkgCustInfoT
//	 * BKG_CUSTOMER 테이블에서 Customer 정보를 가져온다. - 예전 방식
//	 * 
//	 * @param Edi315SendOptionsVO edi315SOpts
//	 * @return List<Edi315PrefixMainBkgCustInfoVO> 
//	 * @exception EventException
//	 */	
//	public List<Edi315PrefixMainBkgCustInfoVO> searchBkgCustInfoT(Edi315SendOptionsVO edi315SOpts)throws EventException{
//		try {
//			  return dbDao.searchBkgCustInfo(edi315SOpts);
//		} catch (DAOException e) {
//			  throw new EventException(e.getMessage(),e);
//		}
//	}
	
	
	/**
	 * searchVvdTimeInformation
	 * 결과를 해당 VO를 받은 List 에 저장
	 * 
	 * @param Edi315SendOptionsVO edi315SOpts
	 * @return List<SearchVvdTimeInformationVO>
	 * @exception EventException
	 */	
//    private List<SearchVvdTimeInformationVO> searchVvdTimeInformation(Edi315SendOptionsVO edi315SOpts) throws EventException {
//		try {
//			return dbDao.searchVvdTimeInformation(edi315SOpts);
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			throw new EventException(e.getMessage(), e);
//		}
//	}
	
	

	/**
	 * mergeIntoInLandRouteInfo
     * 해당 VO 에 InLandRouteInfo 의 값을 세팅하여 가지고 옮
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<AbstractValueObject>
     * @exception EventException
     */
    private List<AbstractValueObject> mergeIntoInLandRouteInfo(Edi315SendOptionsVO edi315SOpts) throws EventException{
		List<AbstractValueObject>  listVobj = null; 
		List<Edi315PrefixIrgInfoVO> list = null;
        try {
	      	  log.info("mergeIntoInLandRouteInfo is running... in Edi315SendSC");
	      	  log.info("Cop_NO:" + edi315SOpts.getECopNo());
	      	  list = searchInlandRouteInfro(edi315SOpts);
	      	  if(list != null && list.size() >0){
		      		 listVobj = new ArrayList();
		      		 for(int i =0;i<list.size();i++)//Converting Specific List into general List 
		      		     listVobj.add((AbstractValueObject)list.get(i));		      		 
		      	  }	      	  
        }catch(EventException ex){
        	throw new EventException(ex.getMessage(), ex);
	  	}catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}	
		return listVobj;
	}    
//	/**
//     * mergeIntoMain 
//     * 
//     * @param Edi315PrefixMainVO edi315SendMainVo
//     * @param Edi315SendOptionsVO edi315SOpts
//     * @return List<AbstractValueObject>
//     * @exception EventException
//     */
//	public List<AbstractValueObject> mergeIntoMain(Edi315PrefixMainVO edi315SendMainVo,Edi315SendOptionsVO edi315SOpts)throws EventException{
//        List<AbstractValueObject>  listVobj = null;
//	        try {
//				  List<Edi315PrefixMainVO> list = null;
//				     list = mergeIntoMainWithLogic(edi315SendMainVo,edi315SOpts);
//				  if(list != null && list.size() > 0){        
//				       Edi315PrefixMainVO mvo = list.get(0);
//				       HashMap main_map = mvo.getColumnValues();
//				       Set keyset = main_map.keySet();
//				       Object[] keys = (keyset.toArray());
//				 }
//				  
//		      	if(list != null && list.size() >0){
//			      		 listVobj = new ArrayList();
//			      		 for(int i =0;i<list.size();i++)
//			      		     listVobj.add((AbstractValueObject)list.get(i));		      		 
//			     }
//				 return listVobj;
//	  	}catch(EventException ex){
//	  		throw new EventException(ex.getMessage(), ex);
//	  	}catch(Exception ex){
//	  		throw new EventException(ex.getMessage(), ex);
//	  	}	
//	}    

//	/**
//	 * 결과를 해당 VO를 받은 List 에 저장<br>
//	 * 
//	 * @param Edi315PrefixMainVO edi315Main
//	 * @param Edi315SendOptionsVO edi315SOpts
//	 * @return List<Edi315PrefixMainVO> 
//	 * @exception EventException
//	 */
//	public List<Edi315PrefixMainVO> mergeIntoMainWithLogic(Edi315PrefixMainVO edi315Main,Edi315SendOptionsVO edi315SOpts)throws EventException{
//		try {
//				List<Edi315PrefixMainCOPInfoVO>            listm1 = searchCOPInfoT(edi315SOpts);
//				List<Edi315PrefixMainBkgCustInfoVO>        listm2 = searchBkgCustInfoT(edi315SOpts);
//				List<Edi315PrefixMainVO>                   mainList = new ArrayList<Edi315PrefixMainVO>();
//				
//				GeneralEventResponse eventResponse = new GeneralEventResponse();
//				if(listm1 != null && listm1.size() >0){			
//				 ObjectCloner.build(listm1.get(0), edi315Main);
//				}
//				if(listm2 != null && listm2.size() >0){		
//				 ObjectCloner.build(listm2.get(0), edi315Main);
//				}
//
//			mainList.add(edi315Main);
//		   return mainList;
//		} catch (Exception e) {
//			  throw new EventException(e.getMessage(),e);
//		}
//	}	
	
	/**
     * 해당 VVD의 SKD를 FLAT FILE에 생성 한다. 
     * @param Edi315SendOptionsVO edi315SOpts
     * @param Edi315DetailVO   dtlVo
     * @return List<AbstractValueObject>
     * @exception EventException
     */
    private List<AbstractValueObject> mergeIntoBkgVvdInfo(Edi315SendOptionsVO edi315SOpts, Edi315DetailVO   dtlVo) throws EventException{
		List<AbstractValueObject>  listVobj = null; 
		List<Edi315PrefixBkgVvdVO> list = null;
        try {
	      	  log.info("sceEdiSendFlatPrc is running... in Edi315SendSC");
	      	  list = mergeIntoBkgVvdInfoWithLogic(edi315SOpts);
	      	  List<SceFltFileMsgDtlVslVO> vslInfo = new ArrayList();
	      	  
	      	  if(list != null && list.size() >0){
	      		 listVobj = new ArrayList();
	      		 for(int i =0;i<list.size();i++){ 
		     		Edi315PrefixBkgVvdVO vvdVo = list.get(i);
	      			
	      			//vvd 정보 set
		      		SceFltFileMsgDtlVslVO vslVo = new SceFltFileMsgDtlVslVO();	 
		      		vslVo.setVslCd((vvdVo.getBvvd1() != null && vvdVo.getBvvd1().length()>=4 ? vvdVo.getBvvd1().substring(0,4) : ""));
		      		vslVo.setSkdVoyNo((vvdVo.getBvvd1() != null && vvdVo.getBvvd1().length()>=8 ? vvdVo.getBvvd1().substring(4,8) : ""));		      		
		      		vslVo.setSkdDirCd((vvdVo.getBvvd1() != null && vvdVo.getBvvd1().length()>=9 ? vvdVo.getBvvd1().substring(8,9) : ""));
		      		vslVo.setOrgNodCd(vvdVo.getBlpol1());
		      		vslVo.setDestNodCd(vvdVo.getBlpod1());
		      		vslVo.setOrgEstmArrDt(vvdVo.getPoleta1());
		      		vslVo.setOrgEstmDepDt(vvdVo.getPoletd1());	
		      		vslVo.setDestEstmArrDt(vvdVo.getPodeta1());
		      		vslVo.setDestEstmDepDt(vvdVo.getPodetd1());	
		      		
		      		vslVo.setOrgActArrDt(vvdVo.getPolata1());
		      		vslVo.setOrgActDepDt(vvdVo.getPolatd1());	
		      		vslVo.setDestActArrDt(vvdVo.getPodata1());
		      		vslVo.setDestActDepDt(vvdVo.getPodatd1());
		      		
		      		vslInfo.add(vslVo);
		      		
		      		
	      		     listVobj.add((AbstractValueObject)vvdVo);

	      		 }
	      		dtlVo.setVslInfo(vslInfo);	      		     
 
	      	  }
	      	  
        }catch(EventException ex){
        	throw new EventException(ex.getMessage(), ex);
	  	}catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}	
	  	
		return listVobj;
	}	
	
    /**
     * BkgVvdInfo 프로시져의 컨버팅, 그결과를 List 담아옴 <br>
     * 해당 VVD의 SKD를 FLAT FILE에 생성 한다. 
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixBkgVvdVO>
     * @throws EventException
     */	
    private List<Edi315PrefixBkgVvdVO> mergeIntoBkgVvdInfoWithLogic(Edi315SendOptionsVO edi315SOpts) throws EventException{
        List<Edi315PrefixBkgVvdVO> bkgList = null;
	    /*Initiating Arguments*/	
	    String bvvd1                     = "";        
	    String vsl_callsign1 			 = "";
	    String vsl_lloydcode1			 = "";
	    String vsl_fullname1 	         = "";
	    String blpol1       			 = "";
	    String pol_fullname1 			 = "";
	    String blpod1    				 = ""; 
	    String pod_fullname1			 = ""; 
	    String poleta1     			     = ""; 
	    String poleta1_gmt 			     = ""; 
	    String polata1    				 = ""; 
	    String polata1_gmt   			 = ""; 
	    String poletd1       			 = ""; 
	    String poletd1_gmt   			 = ""; 
	    String polatd1       			 = ""; 
	    String polatd1_gmt 		         = ""; 
	    String podeta1    				 = ""; 
	    String podeta1_gmt   			 = ""; 
	    String podata1     			     = ""; 
	    String podata1_gmt   			 = ""; 
	    String podetd1      			 = ""; 
	    String podetd1_gmt   			 = ""; 
	    String podatd1      			 = ""; 
	    String podatd1_gmt   			 = ""; 
	    String bv_lane      			 = ""; 
	    
	    String poleta1_tmp		         = ""; 
	    String poleta1_gmt_tmp	         = ""; 
	    String poletd1_tmp		         = ""; 
	    String poletd1_gmt_tmp	         = ""; 
	    String podeta1_tmp		         = ""; 
	    String podeta1_gmt_tmp	         = ""; 
	    String podetd1_tmp		         = ""; 
	    String podetd1_gmt_tmp	         = ""; 
	    
	    int search_vvd_time_info = 0;
	    try {
    	  log.info("####sceEdiSendFlatPrc in Edi315BCImpl########");
		  List<SearchVvdTimeInformationVO> list = dbDao.searchVvdTimeInformation(edi315SOpts);
		  if(list != null){
			  search_vvd_time_info = list.size();
			  log.info("INFO:size of search_vvd_time_info - " + search_vvd_time_info);
		  }
		  
		  bkgList = new ArrayList<Edi315PrefixBkgVvdVO>();
		  /*For Statement in main Procedure*/
		  for(int n=0;n<search_vvd_time_info;n++){
			  log.info("\n vvd cnt:"+n);
			  bvvd1                      = "";
			  vsl_callsign1 			 = "";
			  vsl_lloydcode1			 = "";
			  vsl_fullname1 	         = ""; 
			  blpol1       			     = "";     
			  pol_fullname1 			 = "";     
			  blpod1    				 = "";       
			  pod_fullname1			     = "";     
			  poleta1     			     = "";   
			  poleta1_gmt 			     = "";   
			  polata1    				 = "";     
			  polata1_gmt   			 = "";     
			  poletd1       			 = "";     
			  poletd1_gmt   			 = "";     
			  polatd1       			 = "";     
			  polatd1_gmt 		         = ""; 
			  podeta1    				 = "";     
			  podeta1_gmt   			 = "";     
			  podata1     			     = "";   
			  podata1_gmt   			 = "";     
			  podetd1      			     = "";     
			  podetd1_gmt   			 = "";     
			  podatd1      			     = "";     
			  podatd1_gmt   			 = "";     
			  bv_lane      			     = "";     
			  
			  SearchVvdTimeInformationVO tempVo = list.get(n);
			  HashMap<String,String> valueMap = tempVo.getColumnValues();

//			  Set keyset = valueMap.keySet();
//			  Iterator itr = keyset.iterator();

			  //IF length(bvvd1) = 9 THEN 
			  bvvd1             = valueMap.get("bvvd1"         );
			  vsl_callsign1 	= valueMap.get("vsl_callsign1" );
			  vsl_lloydcode1	= valueMap.get("vsl_lloydcode1");
			  vsl_fullname1 	= valueMap.get("vsl_fullname1" );
			  blpol1       		= valueMap.get("blpol1"        );
			  pol_fullname1 	= valueMap.get("pol_fullname1" );
			  blpod1    		= valueMap.get("blpod1"    	   );
			  pod_fullname1		= valueMap.get("pod_fullname1" );
			  poleta1     		= valueMap.get("poleta1"       );
			  poleta1_gmt 		= valueMap.get("poleta1_gmt"   );
			  polata1    		= valueMap.get("polata1"       );
			  polata1_gmt   	= valueMap.get("polata1_gmt"   );
			  poletd1       	= valueMap.get("poletd1"       );
			  poletd1_gmt   	= valueMap.get("poletd1_gmt"   );
			  polatd1       	= valueMap.get("polatd1"       );
			  polatd1_gmt 		= valueMap.get("polatd1_gmt"   );
			  podeta1    		= valueMap.get("podeta1"       );
			  podeta1_gmt   	= valueMap.get("podeta1_gmt"   );
			  podata1     		= valueMap.get("podata1"       );
			  podata1_gmt   	= valueMap.get("podata1_gmt"   );
			  podetd1      		= valueMap.get("podetd1"       );
			  podetd1_gmt   	= valueMap.get("podetd1_gmt"   );
			  podatd1      		= valueMap.get("podatd1"       );
			  podatd1_gmt   	= valueMap.get("podatd1_gmt"   );
			  bv_lane      		= valueMap.get("bv_lane"       );

			  //TEST Code//
			  //bvvd1 = "HNBN00";
			  if(bvvd1 != null && bvvd1.length() == 9){
			  log.info("************* Logic in sceEdiSendFlatPrc : bvvd1 length is greater than 9 ***************");
			    //ELSIF length(bvvd1) < 9 THEN   
				poleta1_tmp      =  poleta1;
				poleta1_gmt_tmp  =  poleta1_gmt;
				poletd1_tmp      =  poletd1;
				poletd1_gmt_tmp  =  poletd1_gmt;			
				podeta1_tmp      =  podeta1;
				log.info("\n podeta1 : "+podeta1+"\n podeta1_tmp : "+podeta1_tmp);
				podeta1_gmt_tmp  =  podeta1_gmt;
				podetd1_tmp      =  podetd1;
				podetd1_gmt_tmp  =  podetd1_gmt;
			  }else if(bvvd1 == null || bvvd1.length() < 9){
				log.info("************* Logic in sceEdiSendFlatPrc : bvvd1 length is less than 9 ***************");
				// 2011.12.26 [CHM-201115248] IKEA ETD 맵핑 오류 수정 요청 -- Feeder의 VVD가 지정되지 않았을때 잘못된 Feeder의 잘못된 ETA, ETD를 가져와서 수정				
				//poleta1          =  poleta1_tmp;
				//poleta1_gmt      =  poleta1_gmt_tmp;	
				poleta1          =  podeta1_tmp;
				poleta1_gmt      =  podeta1_gmt_tmp;		
				poletd1          =  podetd1_tmp;
				poletd1_gmt      =  podetd1_gmt_tmp;
				log.info("\n podeta1 : "+podeta1+"\n podeta1_tmp : "+podeta1_tmp);
					
					
		            if(bv_lane != null && bv_lane.length() == 3){
			            //IF poleta1 <> '' and poleta1_gmt <> '' THEN
		            	if((poleta1 != null && !"".equals(poleta1) && !" ".equals(poleta1)) && (poleta1_gmt != null && !"".equals(poleta1_gmt) && !" ".equals(poleta1_gmt))){
		            		log.info("\n bv_lane.length() == 3 \n poleta1='"+poleta1+"'");
		            		List<SearchCredataMetInformationVO> list1 = dbDao.searchCredataMetInformation(poleta1, poleta1_gmt, blpol1, blpod1, bv_lane);
		            		if(list1 != null && list1.size() >0){
		            			SearchCredataMetInformationVO vo1 = list1.get(0);
		            			podeta1		= vo1.getPodeta1(); 
		            			podeta1_gmt	= vo1.getPodeta1Gmt();
		            			podetd1		= vo1.getPodetd1(); 
		            			podetd1_gmt	= vo1.getPodetd1Gmt();
		            		}
		            	}
		            }else{
		            	//IF poleta1 <> '' and poleta1_gmt <> '' THEN 
						if((poleta1 != null && !"".equals(poleta1) && !" ".equals(poleta1)) &&(poleta1_gmt != null && !"".equals(poleta1_gmt) && !" ".equals(poleta1_gmt))){
							List<SearchTIExistInformationVO> list2 = dbDao.searchTIExistInformation(blpol1, blpod1, poleta1, poleta1_gmt);
							if(list2 != null && list2.size() >0){
								SearchTIExistInformationVO vo2 = list2.get(0);
								podeta1     = vo2.getPodeta1();
								podeta1_gmt = vo2.getPodeta1Gmt(); 
								podetd1     = vo2.getPodetd1();
								podetd1_gmt = vo2.getPodetd1Gmt();												 
							}
						}
		            }
				poleta1_tmp     = ""; 
	            poleta1_gmt_tmp = ""; 
	            poletd1_tmp     = ""; 
	            poletd1_gmt_tmp = "";  
	            
	            podeta1_tmp     = ""; 
	            podeta1_gmt_tmp = ""; 
	            podetd1_tmp     = ""; 
	            podetd1_gmt_tmp = ""; 
	            
	            poleta1_tmp      = poleta1;
	            poleta1_gmt_tmp  = poleta1_gmt;
	            poletd1_tmp      = poletd1;
	            poletd1_gmt_tmp  = poletd1_gmt;
	            
	            podeta1_tmp      = podeta1;
	            podeta1_gmt_tmp  = podeta1_gmt;
	            podetd1_tmp      = podetd1;
	            podetd1_gmt_tmp  = podetd1_gmt;    
			  }

			   log.info("\n Maching arguments >>> cnt:("+n+")" 
				+"\n   bvvd1 : "+bvvd1+ ":" 
				+"\n   vsl_callsign1 : "+vsl_callsign1+ ":" 
				+"\n   vsl_lloydcode1 : "+vsl_lloydcode1 + ":" 
				+"\n   vsl_fullname1 : "+vsl_fullname1 + ":" 
				+"\n   blpol1 : "+blpol1+ ":" 
				+"\n   pol_fullname1 : "+pol_fullname1 + ":" 
				+"\n   blpod1 : "+blpod1+ ":" 
				+"\n   pod_fullname1 : "+pod_fullname1+ ":" 
				+"\n   poleta1 : "+poleta1 + ":" 
				+"\n   poleta1_gmt : "+poleta1_gmt+ ":" 
				+"\n   polata1 : "+polata1+ ":" 
				+"\n   poletd1 : "+poletd1+ ":" 
				+"\n   poletd1_gmt : "+poletd1_gmt + ":" 
				+"\n   polatd1 : "+polatd1+ ":" 
				+"\n   polatd1_gmt : "+polatd1_gmt+ ":" 
				+"\n   podeta1 : "+podeta1 + ":" 
				+"\n   podeta1_gmt : "+podeta1_gmt + ":" 
				+"\n   podata1 : "+podata1+ ":" 
				+"\n   podata1_gmt : "+podata1_gmt + ":" 
				+"\n   podetd1 : "+podetd1+ ":" 
			    +"\n   podetd1_gmt : "+podetd1_gmt+ ":" 
			    +"\n   podatd1 : "+podatd1 + ":" 
			    +"\n   podatd1_gmt : "+podatd1_gmt+ ":" 						   
			   );
			   
				List<Edi315PrefixBkgVvdVO> lists 
				= dbDao.searchStrInformation(
					       bvvd1        , vsl_callsign1, vsl_lloydcode1,
			               vsl_fullname1, blpol1       , pol_fullname1 , 
			               blpod1       , pod_fullname1, poleta1       ,
			               poleta1_gmt  , polata1      , poletd1       ,       
			               poletd1_gmt  , polatd1      , polatd1_gmt   ,   
			               podeta1      , podeta1_gmt  , podata1       ,       
			               podata1_gmt  , podetd1      , podetd1_gmt   ,   
			               podatd1      , podatd1_gmt				
				);		
				if(lists != null && lists.size() >0) {
					bkgList.add(lists.get(0));
				}
			  
		  }
	} catch (DAOException e) {
			log.info("\n mergeIntoBkgVvdInfoWithLogic, cop_no:"+edi315SOpts.getCopNo());
			throw new EventException(e.getMessage(),e);
	}	
		return bkgList;
	}

    /**
     * I/B 구간의 IRG 정보를 가져온다. 
     * 
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixIrgInfoVO>
     * @throws EventException
     */	
    private List<Edi315PrefixIrgInfoVO> searchInlandRouteInfro(Edi315SendOptionsVO edi315SOpts)throws EventException{
		List<Edi315PrefixIrgInfoVO> list = null;
		try {
			   String cop_no = edi315SOpts.getECopNo();
			   String irg_rout_org = "";
			   String irg_rout_dest = "";
			   List<SearchBoundRoutSeqVO> list1 = dbDao.searchBoundRoutSeq(cop_no);
			   SearchBoundRoutSeqVO tempVo = null;
			   int irg_rout_seq =0;
			   String  irg_rout_seq_str = "";
			   if(list1 != null && list1.size() >0) {
				   tempVo = list1.get(0);
				   
			       irg_rout_seq  = Integer.parseInt(tempVo.getRoutSeq());
			       irg_rout_seq_str = String.valueOf(irg_rout_seq);

			       irg_rout_org  = tempVo.getRoutOrgNodCd();
			       irg_rout_dest = tempVo.getRoutDestNodCd();
			       			       
				   list = dbDao.searchIrgTimeInformation
			          (
			           irg_rout_seq_str,
					   irg_rout_org,
					   irg_rout_dest,
					   cop_no
					   );
			       			       
			   }
			   		 	   
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	    
		return list;
	}
    /**
     * 오라클데이터베이스로 부터 특정 시퀀스넘버를 받아옴 <br>
     * 
     * @return HashMap<String,String>
     * @throws EventException
     */		
    private HashMap<String,String> getSNDSEQ() throws EventException{
		try {
			HashMap<String,String> keys_values = new HashMap<String,String>();
			DBRowSet rowset = dbDao.getSndSeq();
			if (rowset != null && rowset.next()) {
				keys_values.put("FF_YYMMDD", rowset.getString("FF_YYMMDD"));
				keys_values.put("FF_YMMDD" , rowset.getString("FF_YMMDD" ));
				keys_values.put("FF_SEQ"   , rowset.getString("FF_SEQ"   ));
			}else{
				log.info("\n VIP315Error : Edi315SendDBDAOGetSndSeqRSQL IS NULL <-- FF No Creation Method");
			}
			   return keys_values;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**searchVesslenInformation -  searchVesslenInformation 의 래퍼 함수
     * @param    String trunk_vvd_splited
     * @return   HashMap<String,String> 
     * @throws   EventException
     */       
    private HashMap<String,String> searchVesslenInformation(String trunk_vvd_splited) throws EventException{
		try {
			  DBRowSet rowset = dbDao.searchVesslenInformation(trunk_vvd_splited);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("VSL_NAME"     ,rowset.getString("VSL_NAME"     ));
				  keys_values.put("VSL_CNTR_CODE",rowset.getString("VSL_CNTR_CODE"));
				  keys_values.put("VSL_LLOYD_NO" ,rowset.getString("VSL_LLOYD_NO" ));				  
			  }
			  return keys_values;
		 } catch (DAOException e) {
			 throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
	    	 throw new EventException(new ErrorHandler(ex).getMessage());
		 }
	 }
    /**searchFrmsCdInformation - searchFrmsCdInformation 의 래퍼 함수
     * @param    String bkg_no
     * @param    String nod_cd
     * @return   HashMap<String,String> 
     * @throws   EventException
     */       
    private HashMap<String,String> searchFrmsCdInformation(String bkg_no, String nod_cd) throws EventException{
		try {
			  DBRowSet rowset = dbDao.searchFrmsCdInformation(bkg_no, nod_cd);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("FIRMS_CODE"     ,rowset.getString("FIRMS_CODE" ));				  
			  }
			  return keys_values;
		 } catch (DAOException e) {
			 throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
	    	 throw new EventException(new ErrorHandler(ex).getMessage());
		 }
	 } 
	/**
	 * searchCntrWeightInfo
     * @param    String bkg_no
     * @param    String cntr_no
     * @return   SearchCntrWeightInfoVO
     * @throws   EventException
     */ 
    private SearchCntrWeightInfoVO searchCntrWeightInfo(String bkg_no, String cntr_no) throws EventException{
		try {
			SearchCntrWeightInfoVO searchCntrWeightInfoVO = new SearchCntrWeightInfoVO();
			searchCntrWeightInfoVO = dbDao.searchCntrWeightInfo(bkg_no,cntr_no);

			return searchCntrWeightInfoVO;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } 
	 } 
    
   
	
	
 
	/**
	 * getConvInToUVDFlg
	 * 
	 * 삼성전자의 경우 T/S 후 Rail/Truck으로 DEL 까지 운송 되는 경우가 있는데,   
	 * (현장에서 C/A를 끊는것을 지양하기 때문에 대체전송 필요 하다고 함.)   
	 * 이경우 VD MVMT가 미 존재 하게 되어 POD지역에 들어온 IC를 VD로 대체 전송.      
	 * 1. 대상 화주가 Conversion 대상이고(현재 삼성)   
	 * 2. POD 에 VVD가 Assign되지 않았고, (VVD 있으면 추후 VD가 들어올 것이므로)   
	 * 3. 기존 VD 전송 내역 없음.   
	 * 위 조건 세가지를 충 족 할 경우 MVMT IC -> VD로 대체 전송 한다. ( EDI Code : IN -> UVD )   
	 *  
	 * COMMON PRC에도 로직 대상 화주와 아닌 화주를 구분하여 대체 여부를 확인 하여 전송 함. CSR# : N200906150140
     * @param    Edi315DetailVO dtlVo
     * @return   String
     * @throws   EventException
     */ 
    private String getConvInToUVDFlg(Edi315DetailVO dtlVo) throws EventException {
    	try {
    		
    		String cnvtFlg  = dbDao.getConvInToUVDFlg(
    				  dtlVo.getEdiGrpCd()
    				, dtlVo.getBkgNo()
    				, dtlVo.getCntrNo()
    				, dtlVo.getCopNo());
    		
    		return cnvtFlg;
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    }
	/**
	 * getPreSentCnt
	 * 기 발송 된 Status가 있는지 확인 한다. 
     * @param    Edi315DetailVO dtlVo
     * @return   int
     * @throws   EventException
     */ 
    private int getPreSentCnt(Edi315DetailVO dtlVo) throws EventException {
    	try {
    		return dbDao.getPreSentCnt(dtlVo);
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    }
	/**
	 * getRlyPortInfo
	 * T/S 하는 Port 정보를 Falt File에 생성 한다. 
     * @param    Edi315DetailVO dtlVo
     * @param    Edi315CurrInfoVO currVo
     * @return   RlyPortVO
     * @throws   EventException
     */ 
    private RlyPortVO getRlyPortInfo(Edi315DetailVO   dtlVo
    							  , Edi315CurrInfoVO currVo) throws EventException{
		try {
		
			
			RlyPortVO rlyPortVo = new RlyPortVO();
			log.info("\n getRlyPortInfo ---"+
					"\n dtlVo.getEdiSts() : "+dtlVo.getEdiSts()+
					"\n currVo.getCurrBound() : "+currVo.getCurrBound());

			
			if(!"".equals(dtlVo.getPreRly())||!"".equals(dtlVo.getPostRly())){
				if(dtlVo.getPreRly()==null||dtlVo.getPostRly()==null){
					String edi_rmk1 = "rlyPortIsNull";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}
				if ("OB".equals(currVo.getCurrBound())
					||"AEL".equals(dtlVo.getEdiSts())){
					rlyPortVo = dbDao.getObRlyPortInfo(dtlVo.getBkgNo());
					log.info("\n getCurrBound : OB "+"\n dtlVo.getBkgNo() : "+dtlVo.getBkgNo()
							 +"\n rlyPortVo.toString()"+rlyPortVo.toString());
				}else if ("IB".equals(currVo.getCurrBound())|| 
						"UVD".equals(dtlVo.getEdiSts())||
						"VAD".equals(dtlVo.getEdiSts())){
					rlyPortVo = dbDao.getIbRlyPortInfo(dtlVo.getBkgNo());
					log.info("\n getCurrBound : IB "+"\n dtlVo.getBkgNo() : "+dtlVo.getBkgNo()
							 +"\n rlyPortVo.toString()"+rlyPortVo.toString());
				}else if ("OC".equals(currVo.getCurrBound())){
					String edi_sts   = dtlVo.getEdiSts();
					String cop_no    = dtlVo.getCopNo();
					String dtl_seq   = currVo.getCurrCopDtlSeq();
					String org_yd_cd = currVo.getCurrEventYard();
					rlyPortVo = dbDao.getOcRlyPortInfo(edi_sts,cop_no,dtl_seq,org_yd_cd);
					log.info("\n getCurrBound : OC "
							 +"\n dtlVo.getEdiSts() : "+dtlVo.getEdiSts()
							 +"\n dtlVo.getCopNo() : "+dtlVo.getCopNo()
							 +"\n currVo.getCurrCopDtlSeq() : "+currVo.getCurrCopDtlSeq()
							 +"\n currVo.getCurrEventYard() : "+currVo.getCurrEventYard()
							 +"\n rlyPortVo.toString()"+rlyPortVo.toString());
				}
			}else{
				
//				String edi_rmk1 = "dtlVo rlyPort=''" +
//					"dtlVo.getPreRly():" +dtlVo.getPreRly()+
//					"dtlVo.getPostRly():"+dtlVo.getPostRly();
//				modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
			
				rlyPortVo.setRlyAmsport("");
				rlyPortVo.setRlyAmsqual("");
				rlyPortVo.setRlyName("");
				rlyPortVo.setRlyPort("");
			}
	
			  return rlyPortVo;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } 
	 } 
    
	/**
	 * sendEDIMQ
	 * Edi315SendEAIDAO 를 통해서 MQ 발송을 한다. 
     * @param     String ediString
     * @return    String
     * @exception EventException
     */     
    public String sendEDIMQ(String ediString)throws EventException{
    	Edi315SendEAIDAO edi315SendEaiDao = null;
    	
    	String r_flg = "B";
    	try {
    		
	    	edi315SendEaiDao = new Edi315SendEAIDAO();
	    	
			String rsltFlg = edi315SendEaiDao.sendEDIMQ(ediString);
			
			if(rsltFlg.equalsIgnoreCase("SUCCESS")){
				r_flg = "Y";
			}else{
				r_flg = "N";
			}
			log.info("\n sendEDIMQ's r_flg : "+r_flg);
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    	return r_flg;
    }
    
	
	
	

	/**
	 * TRS에서 콜한 'WO' Status의 경우 COP_NO 만 넘어오므로 기본 BKG_NO, CNTR_NO등의 정보 조회.
     * @param     Edi315SendVO sendVo
     * @return    Edi315SendVO
     * @exception EventException
     */     
    private Edi315SendVO checkCallTRS(Edi315SendVO sendVo)throws EventException{
		try {
			  return dbDao.checkCallTRS(sendVo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(),e);
		}
    }
	
    /**
	 * Partial 건의 전송 기록 존재여부 조회
     * @param sendVo
     * @param dtlVo
     * @return
     * @throws EventException
     */
//    private boolean checkPartialSndRslt(Edi315SendVO sendVo, Edi315DetailVO dtlVo) throws EventException {
//    	boolean rtnVal = false;
//    	
//    	try {
//    		 rtnVal = dbDao.checkPartialSndRslt (dtlVo);
//    		 
//    		 if (rtnVal) {
//				String rslt_remark = "Partial 건의 전송 기록 존재로 skip";
//				String rslt_flag = "F";
//				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//				modifySceEdiHisEdiRmk(rslt_remark, sendVo);
//     		 }
//    	} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			throw new EventException(e.getMessage(),e);
//		}
//    	return rtnVal;
//    	
//	}

    
    private boolean checkMngSetup(Edi315SendVO sendVo,Edi315DetailVO dtlVo,Edi315CurrInfoVO currVo) throws EventException {
    	boolean returnFlg = true;
    	int count = 0;
    	log.info(dtlVo.getEdiGrpCd()+"/"+dtlVo.getOrgEdiSts()+"/"+dtlVo.getEdiSts());
    	try{
	    	if ("COM02879".equals(dtlVo.getEdiGrpCd()) && "OAN".equals(dtlVo.getOrgEdiSts()) && "AG".equals(dtlVo.getEdiSts())){
	    		count = dbDao.isMngLastSeq(dtlVo.getEdiSts(), dtlVo.getEdiGrpCd(), dtlVo.getCopNo(), sendVo.getCopDtlSeq());
	    		log.info("count="+count);
	    		if(count > 0){
	    			String remark = dtlVo.getEdiGrpCd()+": AG는 LAST OAN이 아닌경우 SKIP";
	    			modifySceEdiHisDtl("F", remark, dtlVo);
	    			returnFlg = false;
	    		}
	    	}
    	} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(),e);
		}
    	return returnFlg;
    }
	/**
     * EDI_GRP_CGO 에 있는 Setting 사항 확인 하여 발송 여부 판단.
     * @param Edi315SendVO sendVo
     * @param Edi315DetailVO dtlVo
     * @param Edi315CurrInfoVO currVo
     * @return boolean
     * @exception EventException
     */	
    private boolean checkEdiSetup(Edi315SendVO     sendVo,
			                     Edi315DetailVO   dtlVo,
			                     Edi315CurrInfoVO currVo
	                         ) throws EventException {

		if (sendVo == null || dtlVo == null || currVo == null) {
			return false;
		}
		
		String call_from = sendVo.getCallFrom();
		String mvmt_sts  = sendVo.getMvmtSts();

		String edi_sts       = dtlVo.getEdiSts();
		String cust_edi_sts  = dtlVo.getCustEdiStsCd();
		String bkg_no        = dtlVo.getBkgNo();
		String cntr_no       = dtlVo.getCntrNo();
		String cop_no        = dtlVo.getCopNo();

		String edi_event_cd  = dtlVo.getEdiEvntCd();
		String edi_vsl_tp_cd = dtlVo.getEdiVslTpCd();
		String edi_group_cd  = dtlVo.getEdiGrpCd();
		String trunk_vvd     = dtlVo.getTrunkVvd();

		String curr_vvd      = currVo.getCurrVvd(); 
		String nod           = currVo.getCurrEventYard();
		String cop_dtl_seq   = currVo.getCurrCopDtlSeq();

		String rslt_remark = null;
		String rslt_flag   = null;
		String v_dir_nod   = null;

		int isCount = -1;
		boolean result_boolean = true;

		log.info("\n\n\n ##### Checking Parameters #######" + "\n"
				+ "[call_from]:"	+ call_from		+ "\n"
				+ "[edi_sts]:"		+ edi_sts		+ "\n"
				+ "[bkg_no]:"		+ bkg_no		+ "\n"
				+ "[cntr_no]:"		+ cntr_no		+ "\n"
				+ "[cop_no]:"		+ cop_no		+ "\n"
				+ "[cop_dtl_seq]:"	+ cop_dtl_seq	+ "\n"
				+ "[mvmt_sts]:"		+ mvmt_sts		+ "\n"
				+ "[nod]:"			+ nod			+ "\n"
				+ "[edi_group_cd]:"	+ edi_group_cd	+ "\n"
				+ "[edi_event_cd]:"	+ edi_event_cd	+ "\n"
				+ "[edi_vsl_tp_cd]:"+ edi_vsl_tp_cd	+ "\n"
				+ "[trunk_vvd]:"	+ trunk_vvd		+ "\n"
				+ "[curr_vvd]:" 	+ curr_vvd 		+ "\n");

		/*
		 * in case this function returns true, the previous logic is suggested to continue
		 */
		try {

			// monitoring logging
			if (cop_dtl_seq == null || cop_dtl_seq.equals("")
					|| trunk_vvd == null || trunk_vvd.equals("")
					|| curr_vvd == null || curr_vvd.equals("")

			) {
				if (cop_dtl_seq == null || cop_dtl_seq.equals("")) {
					String edi_rmk1 = "ErrorNull(cop_dtl_seq)";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}
				if (trunk_vvd == null || trunk_vvd.equals("")) {
					String edi_rmk1 = "ErrorNull(trunk_vvd)";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}
				if (curr_vvd == null || curr_vvd.equals("")) {
					String edi_rmk1 = "curr_vvd";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}

			}

			log.info("\n dtlVo.getOrgConti() : "  + dtlVo.getOrgConti()
					+ "\n dtlVo.getDestConti() : " + dtlVo.getDestConti()
					+ "\n dtlVo.getPorCd().substring(0, 2)) : " + dtlVo.getPorCd().substring(0, 2)
					+ "\n dtlVo.getDelCd().substring(0, 2)) : " + dtlVo.getDelCd().substring(0, 2)
					+ "\n\n dtlVo.getOrgContiDesc() : " + dtlVo.getOrgContiDesc()
					+ "\n dtlVo.getDestContiDesc() : "  + dtlVo.getDestContiDesc()
					+ "\n dtlVo.getOrgDestCntDesc() : " + dtlVo.getOrgDestCntDesc()
					+ "\n dtlVo.getDestCntDesc() : "    + dtlVo.getDestCntDesc());

			
			
			
			if (dtlVo.getOrgContiDesc() == null || "".equals(dtlVo.getOrgContiDesc())) {
				log.info("cgo 테이블의 POR conti와 null");
			} else if (dtlVo.getOrgContiDesc().contains(dtlVo.getOrgConti())) {
				log.info("cgo 테이블의 POR conti와 일치");
			} else {
				log.info("cgo 테이블의 POR conti Return");
				rslt_remark = "CGO 테이블 POR Conti 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}

			if (dtlVo.getDestContiDesc() == null || "".equals(dtlVo.getDestContiDesc())) {
				log.info("cgo 테이블의 DEL conti null");
			} else if (dtlVo.getDestContiDesc().contains(dtlVo.getDestConti())) {
				log.info("cgo 테이블의 DEL conti와 일치");
			} else {
				log.info("cgo 테이블의 DEL conti Return");
				rslt_remark = "CGO 테이블 DEL Conti 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}

			if (dtlVo.getOrgDestCntDesc() == null || "".equals(dtlVo.getOrgDestCntDesc())) {
				log.info("cgo 테이블의 POR null");
			} else if (dtlVo.getOrgDestCntDesc().contains(dtlVo.getPorCd().substring(0, 2))) {
				log.info("cgo 테이블의 POR 국가와 일치");
			} else {
				log.info("cgo 테이블의 POR Return");
				rslt_remark = "CGO 테이블 POR 국가 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}

			if (dtlVo.getDestCntDesc() == null || "".equals(dtlVo.getDestCntDesc())) {
				log.info("cgo 테이블의 DEL 쪽 null");
			} else if (dtlVo.getDestCntDesc().contains(dtlVo.getDelCd().substring(0, 2))) {
				log.info("cgo 테이블의 DEL 국가와 일치");
			} else {
				log.info("cgo 테이블의 DEL Return");
				rslt_remark = "CGO 테이블 DEL 국가 코드 불일치 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}

			
			
			// 2014.10.16 [CHM-201432324] Customer EDI Monitoring 화면에서  Manually 전송시에는 Event SEQ 값에 상관없이 전송.
			if(!"Y".equals(sendVo.getManFlg())){
				/**
				 * VVD 가 trunk 인지 아닌지 확인 1: trunk VVD만 발송, 2: not trunk (Feeder VVD
				 * 만 발송), 3: all (모두 발송)
				 */
				if ("COP".equals(call_from) || "DIR".equals(call_from)) {
					if (edi_vsl_tp_cd != null && !"3".equals(edi_vsl_tp_cd)) {
						if ("1".equals(edi_vsl_tp_cd)
								&& ((trunk_vvd != null && !trunk_vvd.equals(curr_vvd)))) {
							rslt_remark = "[C03] EdiVslTpCd = 1 Not Trunk VVD ["+ curr_vvd +"]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;

						} else if ("2".equals(edi_vsl_tp_cd) && trunk_vvd != null
								&& trunk_vvd.equals(curr_vvd)) {
							rslt_remark = "[C04] EdiVslTpCd = 2 Trunk VVD [" + curr_vvd +"]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}

				/**
				 * customer 가 원하는 status 별 sequence 를 선별 하기 위해서 하기 로직 수행 
				 * 1:first 만 발송, 2:not first 만 발송, 3:last 만 발송, 4:not Last 만 발송, 5:all 모두 발송
				 */
				if ((!"5".equals(edi_event_cd) && edi_event_cd != null)
						&& ("COP".equals(call_from) || "DIR".equals(call_from))) {
					// 1:first 만 발송
					if ("1".equals(edi_event_cd)) {
						if ("COP".equals(call_from)) {
							isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, edi_sts);
							if (isCount == 0) {
								isCount = dbDao.isdirfirstView(edi_group_cd, edi_sts, cust_edi_sts, cntr_no, bkg_no);
							}

						} else if ("DIR".equals(call_from)) {
							if ("OAN".equals(edi_sts) 
									|| "IO".equals(edi_sts)
									|| "IN".equals(edi_sts)
									|| "OAO".equals(edi_sts)) {
								isCount = dbDao.isdirfirstView(edi_group_cd, edi_sts, cust_edi_sts, cntr_no, bkg_no);
							}
						}

						if (isCount > 0) {
							rslt_remark = "[C05] First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					} else if ("2".equals(edi_event_cd) && "COP".equals(call_from)) {
						// 2:not first 만 발송
						isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, edi_sts);
						if (isCount == 0) {
							rslt_remark = "[C06] Not First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}

					} else if ("3".equals(edi_event_cd)) {
						// 3:last 만 발송
						if ("COP".equals(call_from)) {
							if ("OAN".equals(edi_sts) && "ID".equals(mvmt_sts)) {
								//COP와 관계없이 마지막으로 인식 
								isCount = 0;
							} else {
								isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, edi_sts);
							}
						} else if ("DIR".equals(call_from)) {

							if ("OAN".equals(edi_sts) && "ID".equals(mvmt_sts)) {
								//COP와 관계없이 마지막으로 인식 
								isCount = 0;
							} else {
								isCount = 1;
							}

							if ("OAO".equals(edi_sts) 
									|| "IO".equals(edi_sts)
									|| "IN".equals(edi_sts)) {
								v_dir_nod = dbDao.isdirlastView(cop_no, edi_sts);
								if (v_dir_nod != null && v_dir_nod.equals(nod.substring(0, 5))) {
									isCount = 0;
								} else {
									isCount = 1;
								}
							}
						}

						if (isCount > 0) {
							rslt_remark = "[C07] last Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][" + call_from + "]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}

					} else if ("4".equals(edi_event_cd) && "COP".equals(call_from)) {
						// 4:not Last 만 발송
						isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, edi_sts);
						if (isCount > 0) {
							if ("OAN".equals(edi_sts) && "ID".equals(mvmt_sts)) {
								isCount = 0;
							}
						}

						if (isCount == 0) {
							rslt_remark = "[C08] Not last Error [" + edi_group_cd+ "][" + edi_sts + "][" + cop_dtl_seq + "]";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
				
				// CHM-201324128 315 D status 관련 Logic 변경 요청
				// 공통 기능 추가하여 EDI 사이트에 Auto Type을 추가하여 공통 적용(1:ALL, 2:Auto만 전송, 3:Manual만 전송)
	            if("2".equals(dtlVo.getStsSndTpCd())){
					if("Y".equals(sendVo.getManFlg())){
						rslt_remark = "Auto Send Only";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}else if("3".equals(dtlVo.getStsSndTpCd())){
					if(!"Y".equals(sendVo.getManFlg())){
						rslt_remark = "Manual Send Only";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}		
			
			return true;
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}
	}//checkEdiSetup End !!
	
	
	/**
	 * checkEdiGroupValidation <br>
	 * edi group code 별로 발송 여부를 결정 하는 Validation 함수.
	 * @param Edi315SendVO sendVo
	 * @param Edi315DetailVO dtlVo
	 * @param Edi315CurrInfoVO currVo
	 * @return boolean
	 * @exception EventException
	 */
    private boolean checkEdiGroupValidation(	Edi315SendVO sendVo,
											Edi315DetailVO dtlVo, 
											Edi315CurrInfoVO currVo)
			throws EventException {
		if (sendVo == null || dtlVo == null || currVo == null) {
			return false;
		}

		String call_from 		= sendVo.getCallFrom();
		String bkg_no 			= dtlVo.getBkgNo();
		String cntr_no 			= dtlVo.getCntrNo();
		
		String edi_grp_cd 		= dtlVo.getEdiGrpCd();
		String edi_sts_cd 		= dtlVo.getEdiSts();
		String org_edi_sts_cd 	= dtlVo.getOrgEdiSts();
		String cust_edi_sts_cd 	= dtlVo.getCustEdiStsCd();
		String pod_cd 			= dtlVo.getPodCd();
		String del_cd 			= dtlVo.getDelCd();
		String cop_rail_chk_cd 	= dtlVo.getCopRailChkCd();
		String edi_auto_snd_flg = dtlVo.getEdiAutoSndFlg();

		String event_yard 		= currVo.getCurrEventYard();
		String event_dt 		= currVo.getCurrEventDt();


		String rslt_remark 		= "";
		String rslt_flag 		= "";
//		String inv_nbr 			= "";
		String chk_sts 			= null;
		String aaa 				= null;
		String edi_snd_max_dt	= null;


		int uvd_conved_cnt 	= -1;
		int i_aln_oan	 	= -1;
		int i_dup_cnt 		= -1;
		int i_de_term_cnt 	= -1;
//		int i_oan_rln 		= -1; 
		
		int i_pod_oan_cnt   = -1;

		
		boolean result_boolean = true;


		try {
			
			// 2013.12.09 [CHM-201327733] Double calling 시 315 EDI 전송 로직 보완 요청
			if(!"".equals(dtlVo.getEdiSts()) || !"".equals(sendVo.getCurrVvd()) || !"".equals(sendVo.getClptIndSeq())){
				if("V".equals(dtlVo.getEdiSts().substring(0, 1)) && !"Y".equals(sendVo.getManFlg())){
					if(!"".equals(sendVo.getCurrVvd()) && !"".equals(sendVo.getClptIndSeq())){
						log.info("searchVesselClptIndSeq START ");
						int chkCnt = searchVesselClptIndSeq(sendVo);
						log.info("searchVesselClptIndSeq END" );
						
						if(chkCnt<1){
							rslt_remark = "Unmatch COP VVD, PORT, Calling Seq";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
			}
			
			/* [CHM-201323196] COP FInish 이후 315 전송방지____________________________>*/ 
			if( "F".equals(dtlVo.getCopStsCd()) && !"Y".equals(sendVo.getManFlg()) ){
			   if( "VAD".equals(dtlVo.getEdiSts()) || "VAT".equals(dtlVo.getEdiSts()) ||
			       "VBD".equals(dtlVo.getEdiSts()) || "VBT".equals(dtlVo.getEdiSts()) ||
			       "VDL".equals(dtlVo.getEdiSts()) || "VDT".equals(dtlVo.getEdiSts()) 
			      )
			   {
			     rslt_remark = "COP Already Finished ! (ATA/B/D)";
			     rslt_flag = "F";
			     modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
			     modifySceEdiHisEdiRmk(rslt_remark, sendVo);
			     return result_boolean = false;
			   }else{
				   aaa="";
			   }
			}	
			   /* <__________________________ [CHM-201323196] COP FInish 이후 315 전송방지 */			
			
			if("AD".equals(dtlVo.getEdiSts())){
				// 2013-01.30 CHM-201222195 [GTN] COM 02357 Ceva-Microsoft : AD event 자동 전송 로직 적용 (AV 발생 72시간 이후)
				// 2014.05.14 [CHM-201430160] [CEVA  Microsoft] COM02677 그룹코드 추가
				if(("COM02357".equals(edi_grp_cd) || "COM02677".equals(edi_grp_cd)) && "OAN".equals(dtlVo.getOrgEdiSts())){
					rslt_remark = "AD Send Only AV Event";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}else if(!("COM02357".equals(edi_grp_cd) || "COM02677".equals(edi_grp_cd))){
					if("D".equals(dtlVo.getDeTermCd()) && "OAN".equals(dtlVo.getOrgEdiSts())
							&& sendVo.getMvmtSts() != null && "ID".equals(sendVo.getMvmtSts())){
						aaa="";
					}else if("D".equals(dtlVo.getDeTermCd()) && "Y".equals(sendVo.getManFlg())){
						aaa="";
					}else{
						rslt_remark = "AD Send Only Door Term at DEL and ID MVMT";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						modifySceEdiHisEdiRmk(rslt_remark, sendVo);
						return result_boolean = false;
					}
				}
				
			}
			
			if("AG".equals(dtlVo.getEdiSts()) && !"D".equals(dtlVo.getDeTermCd()) && !"COM02879".equals(edi_grp_cd)){
				rslt_remark = "AG Send Only Door Term";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				modifySceEdiHisEdiRmk(rslt_remark, sendVo);
				return result_boolean = false;
			}
			
			
			
			

			
			//IF (v_call_from = '322' and edi_sts_tmp = 'NT') THEN  
			//IF (v_cop_sts_cd <> 'F' and v_call_from <> 'MAN') or (v_call_from = 'MAN') THEN   
			if("322".equals(sendVo.getCallFrom()) && "NT".equals(dtlVo.getEdiSts())){
				if("Y".equals(sendVo.getManFlg())||
						(!"F".equals(dtlVo.getCopStsCd()) && !"Y".equals(sendVo.getManFlg()))){
					aaa="";
				}else{
					//Already Finished COP
					rslt_remark = "Already Finished COP";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}

			if("NT".equals(dtlVo.getEdiSts())){
				String nt_loc_cd = getCnmv322Rail(dtlVo.getCopNo());
				if(nt_loc_cd == null || !currVo.getCurrEventYard().substring(0, 5).equals(nt_loc_cd)){
					rslt_remark = "NT 전송시 COP 최종 ARN(최종 FIRRAD) location과 동일한 경우만 발생";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}
			
			/********************************************************************/
			/* VE 자체 변경(COP Replan, VSK EST 변경)에 따른 VE 전송 관련 */
			/* 사전 VDL(logging 포함)이 전송 되었는지 확인 후 전송 */
			/* 2008.01.11 ihjang */
			if ("VE".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd)) {
				chk_sts = "VD";
				i_aln_oan = dbDao.getCopVeVd(edi_grp_cd, bkg_no, cntr_no, chk_sts);
				if (i_aln_oan < 1) {
					//VDT,VDL 발송 이후에 VE발송 한다. 
					rslt_remark = "Not Yet VE(VDT,VDL 발송 이후에 VE발송)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}
			
			/* TARGET ONLY: 사전 VDL(logging 포함)이 전송 되었는지 확인 후 VBE 전송 [CHM-201640682] */			
			if ("USA00094".equals(edi_grp_cd) && "VBE".equals(org_edi_sts_cd) && "VBE".equals(edi_sts_cd)) {
				chk_sts = "VD";
				i_aln_oan = dbDao.getCopVeVd(edi_grp_cd, bkg_no, cntr_no, chk_sts);
				if (i_aln_oan < 1) {
					//VDT,VDL 발송 이후에 VE발송 한다. 
					rslt_remark = "Not Yet VBE(VDT,VDL 발송 이후에 VBE발송)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}

			if ("VE".equals(org_edi_sts_cd) && "VD".equals(edi_sts_cd.substring(0, 2)) ) {
				if ("N".equals(edi_auto_snd_flg)) {
					rslt_remark = "No Auto Send VD !!!";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}

			if(("COM02218".equals(edi_grp_cd) || "USA00607".equals(edi_grp_cd)) && !"Y".equals(sendVo.getManFlg()) &&
			   (("VE".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd)) || ("VBE".equals(org_edi_sts_cd) && "VBE".equals(edi_sts_cd)))) {
				int chkSndCnt = dbDao.getVEVBEValidationCount(dtlVo, edi_sts_cd); // 1이면 skip, 0이면 send
				if(chkSndCnt > 0){
					rslt_remark = "VAD(VBD) 기 전송 내역 존재로 return";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo); 
					return result_boolean = false;
				}
			}

			
			/* 동일 data 중복 전송 방지 2007.12.05 										*/
			/* VE 로 인해 Logging 되는 VDT,VDL = 'S' : 로직 skip 						*/
			/* dtlVo.getLogFlg() = 'Y' : 비교 구문에서 event date 제외 	-- Logging 시	*/
			/* dtlVo.getLogFlg() = 'N' : 정상적인 중복 처리        			-- 2008-02-15	*/
			
			
			if ("VE".equals(org_edi_sts_cd)	&& "VD".equals(edi_sts_cd.substring(0, 2)) ) {
				//VE 로 인해 Logging 되는 VDT,VDL 는 중복 전송 체크 안함.
				aaa="";
				
				// CHM-201325112 Home Depot VD 로직 추가 요청(최초에 생성된 VD만 전송하고 이후 신규로 발생되는 VD에 대한Block 처리)
				// 로직은 즉시 적용하지 않겠으나, 향후 적용을 요청드릴 수 있으니 반영만 보류(2013.8.21일 반영)
				if("COM02218".equals(edi_grp_cd) && "VDL".equals(edi_sts_cd) && "VD".equals(cust_edi_sts_cd)){
					int chkSndCnt = dbDao.isdirfirstView(edi_grp_cd, edi_sts_cd, cust_edi_sts_cd, cntr_no, bkg_no);
					if(chkSndCnt > 0){
						rslt_remark = "COM02218(Home Depot (via Lognet)) Not First Error";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
				
				
			}else{
				log.info("\n DUP RETURN");
				//manual 전송이 아닌 경우에 중복 체크 .
				if (!"Y".equalsIgnoreCase(sendVo.getManFlg()) && !"Y".equalsIgnoreCase(sendVo.getTmcFlg())) {
					log.info("\n DUP RETURN sendVo.getManFlg():"+sendVo.getManFlg());
					edi_snd_max_dt = dbDao.isDupSndEdi(edi_grp_cd, edi_sts_cd, cust_edi_sts_cd, bkg_no, 
													   cntr_no, event_yard, event_dt, dtlVo.getLogFlg());
					if (edi_snd_max_dt != null) {
						i_dup_cnt = 1;
					}

					if (i_dup_cnt > 0) {
						if ("VE".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd) || "VBE".equals(org_edi_sts_cd) && "VBE".equals(edi_sts_cd)) {
							//2015.03.04 김민정 [CHM-201534483] Anchored Vessel 관련 ETB, ATB 수신 화주 추가 (Group ID: COM02218, USA00438, USA00607) - VBE 중복 전송 방지
							//VE 발송 시엔 날짜까지 달라야만 발송.
							if (substr(event_dt, 0, 8).equals(substr(edi_snd_max_dt, 0, 8))) {
								rslt_remark = "DUP RETURN(VE)!!!!(VE 발송 시엔 YYYYMMDD 가 달라야 발송)";
								rslt_flag 	= "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						//2011.06.16 채창호 CHM-201111121-01: (BASF) VE 로직 보완 요청 로직 추가 	
						}else if ("VAT".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd) && "EUR00190".equals(edi_grp_cd)){
							aaa="";
						//2011.07.11 채창호 [CHM-201112043-01] : (Target) AG 로직 보완 20110628
						}else if (("VDL".equals(org_edi_sts_cd) || "VDT".equals(org_edi_sts_cd)) && "VE".equals(edi_sts_cd) && "USA00094".equals(edi_grp_cd)){
							aaa="";
						//2013.03.28 권상준 [CHM-201323601]:IKEA 315 로직 추가 요청 Vessel 관련 EDI 전송시 Day 변경이 없는 건은 전송 제외
						}else if ("ASA00284".equals(edi_grp_cd) && "OC".equals(currVo.getCurrBound())){
							//log.info("CurrBound = "+currVo.getCurrBound());
							if (substr(event_dt, 0, 8).equals(substr(edi_snd_max_dt, 0, 8))) {
								rslt_remark = "DUP RETURN(IKEA)!!!!(IKEA Ocean구간  발송 시엔 YYYYMMDD 가 달라야 발송)";
								rslt_flag 	= "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}else {
							// 2013.10.30 [Canon] TP ID 690549662의 AG 자동전송 로직 변경
							if("ASA00091".equals(edi_grp_cd) && "VE".equals(edi_sts_cd)){
								aaa="";
							}else{
								rslt_remark = "DUP RETURN!!!!";
								rslt_flag 	= "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
					}
					// CHM-201325112 Home Depot VD 로직 추가 요청(최초에 생성된 VD만 전송하고 이후 신규로 발생되는 VD에 대한Block 처리)
					// 로직은 즉시 적용하지 않겠으나, 향후 적용을 요청드릴 수 있으니 반영만 보류(2013.8.21일 반영)
				    if("COM02218".equals(edi_grp_cd) && "VDL".equals(edi_sts_cd) && "VD".equals(cust_edi_sts_cd)){
						int chkSndCnt = dbDao.isdirfirstView(edi_grp_cd, edi_sts_cd, cust_edi_sts_cd, cntr_no, bkg_no);
						if(chkSndCnt > 0){
							log.info("\n COM02218(Home Depot (via Lognet)) Not First Error");
							rslt_remark = "COM02218(Home Depot (via Lognet)) Not First Error";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
			
			}

//			
//			if (!"S".equals(dup_date_chk)) {
//
//				//manual 전송이 아닌 경우에 중복 체크 .
//				if (sendVo.getManFlg() == null || !"Y".equalsIgnoreCase(sendVo.getManFlg())) {
//					i_dup_cnt = 0;
//
//					edi_snd_max_dt = dbDao.isDupSndEdi(edi_grp_cd, edi_sts_cd,
//							cust_edi_sts_cd, bkg_no, cntr_no, event_yard, event_dt, dtlVo.getLogFlg());
//					if (edi_snd_max_dt != null) {
//						i_dup_cnt = 1;
//					}
//
//					if (i_dup_cnt > 0) {
//						if ("VE".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd)) {
//							if (substr(event_dt, 0, 8).equals(substr(edi_snd_max_dt, 0, 8))) {
//								rslt_remark = "DUP RETURN(VE)!!!! : ";
//								rslt_flag = "F";
//								modifySceEdiHisDtl(rslt_flag, rslt_remark,dtlVo);
//								return result_boolean = false;
//							}
//						} else {
//							rslt_remark = "DUP RETURN!!!! : ";
//							rslt_flag = "F";
//							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//							return result_boolean = false;
//						}
//					}
//				}
//			} 
			
			//2012.08.27 박찬민 [CHM-201219880] Del Monte 315 발송 Logic 변경 요청 (POR : THLKG인 경우)
			if("COM01125".equals(edi_grp_cd)){
				if("THLKG".equals(dtlVo.getPorCd()) && "THLCH".equals(dtlVo.getPolCd())){
					if("ALO".equals(edi_sts_cd) || "RLO".equals(edi_sts_cd) || "ARO".equals(edi_sts_cd) || "URO".equals(edi_sts_cd) ){
						rslt_remark = "Del Monte, POR : THLKG, POL : THLCH, EDI STS : ALO, RLO, ARO, URO ";	//skip remark?
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			//2012.12.21 박찬민 [CHM-201222099] [SCE]Home Depot CR 전송 로직 변경 요청
			//2013.08.12 [CHM-201325134] Lowes EDI 315 AV event 로직 보완
			if("COM02218".equals(edi_grp_cd) || "COM01760".equals(edi_grp_cd)){
				if(("UVD").equals(org_edi_sts_cd) && ("CR").equals(edi_sts_cd) && "CR".equals(cust_edi_sts_cd)){
					rslt_remark = "Original: UVD, Status: CR 일때 CR 발송 안함";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}else if(("CR").equals(org_edi_sts_cd) && ("CR").equals(edi_sts_cd) && "AV".equals(cust_edi_sts_cd)){
					rslt_remark = "Original: CR, Status: CR 일때 AV 발송 안함";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}
			
			// 2013.12.26 [CHM-201328209] Lowes 315 로직 추가 요청
			// 2014.01.15 [CHM-201428533] [HANESBRANDS] 315 로직 추가 요청
			if("USA00061".equals(dtlVo.getEdiGrpCd()) || "USA00438".equals(dtlVo.getEdiGrpCd())){
				if(dtlVo.getDelCd() != null){
				log.info("dtlVo.getDelCd().substring(0,2) === "+dtlVo.getDelCd().substring(0,2));
					if(!"CA".equals(dtlVo.getDelCd().substring(0,2)) && ("UVD").equals(org_edi_sts_cd) && ("CR").equals(edi_sts_cd)){
						rslt_remark = "DEL <> CA, Original: UVD, Status: CR(CR), CR(AV) 발송 안함";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
				
				if(("CR").equals(org_edi_sts_cd) && ("CR").equals(edi_sts_cd) && "AV".equals(cust_edi_sts_cd)){
					rslt_remark = "Original: CR, Status: CR 일때 AV 발송 안함";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}		
			}

			/******************************************************************/
			/* IN 반송 - Booking POD, DEL이 다른 경우 */
			/* ASA00113 LOGIPIA - 2007/04/05 */
			/* ASA00127 SAMSUNG SDI (OLD) - 2007/04/05 */
			/* ASA00128 SAMSUNG SDI (OLD) - 2007/04/05 */
			/* ASA00129 SAMSUNG SDI (OLD) - 2007/04/05 */
			if (("ASA00113".equals(edi_grp_cd) || 
				 "ASA00127".equals(edi_grp_cd) || 
				 "ASA00128".equals(edi_grp_cd) || 
				 "ASA00129".equals(edi_grp_cd))
					&& "IN".equals(edi_sts_cd)
					&& (pod_cd != null && !pod_cd.equals(del_cd))) {
				rslt_remark = "Skip - IO: " + edi_grp_cd;
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}

			/*******************************************************************/
			/* UVD 반송 - Inbound Rail일 타는 경우 */
			/* ASA00283 - KUMHO TIRE - 20070406 */
			if ("UVD".equals(edi_sts_cd)) {
				if ("ASA00283".equals(edi_grp_cd)) {
					if ("I".equals(substr(cop_rail_chk_cd, 1, 2))) {
						rslt_remark = "Skip(UVD) - Rail: ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}

				if ("ASA00036".equals(edi_grp_cd)) {
					if ("CA".equals(substr(pod_cd, 0, 2))) {
						rslt_remark = "Skip(UVD) - Canada : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}

			/*
			 * USA00128 - BOMBAY COMP에 대하여 AVN과 AVL이 일반적인 조합과 다르기 때문에 하기 처럼
			 * send에서 fake를 사용하여 구분 한다.
			 */
			if ("USA00128".equals(edi_grp_cd)) {
				if (("AVN".equals(edi_sts_cd) || "AVL".equals(edi_sts_cd))
						&& "CU".equals(org_edi_sts_cd)) {
					rslt_remark = "Skip_Normal AVN, AVL with CU (USA00128) ";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}

			} else {
				if (("AVN".equals(edi_sts_cd) || "AVL".equals(edi_sts_cd))
						&& "CR".equals(org_edi_sts_cd)) {
					rslt_remark = "skip_Special AVN, AVL with CR (USA00128외)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}

			}

			
			
			
			
			
			/* 2008-06-25 STATUS 값이 'OAN' 이고 INV_NBR값이 'N'이면 SKIP */
			/* 2011-08-16 CHM-201112879 아래 로직 삭제 요청 */
//			if (("EUR00188".equals(edi_grp_cd)|| 
//				 "EUR00189".equals(edi_grp_cd) || 
//				 "EUR00190".equals(edi_grp_cd) || 
//				 "EUR00191".equals(edi_grp_cd))
//				   && "OAN".equals(edi_sts_cd)) {
//
//				inv_nbr = dbDao.isInvNbrValue(bkg_no);
//				if (!"Y".equals(nvl(inv_nbr, " "))) {
//					rslt_remark = "SONY_CVY_REF_NO : STATUS 값이 OAN이고 INV_NBR값이 N이면 SKIP";
//					rslt_flag = "F";
//
//					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//					return result_boolean = false;
//				}
//			}
			
			/********************************************************************************/
			/* PHILIPS - 화주별 전송 logic 보완 : 2007/11/22 									*/
			/* CUST GRP ID : USA00080 														*/
			/* EDI STS : NFR, FTR 로직 : DEL CNTRY가 US or CA 이며 Rail shipment 인 경우 			*/
			/* EDI STS : NFD, FTD 로직 : 상기 로직에 해당하지 않는 모든 Shipment 인 경우 				*/
			/* 						DEL CNTRY가 US or CA 이지만 Local shipment 인 경우			*/
			/* 						DEL CNTR 가 US, CA 가 아닌 경우 								*/
			log.info("\n cop_rail_chk_cd : "+cop_rail_chk_cd);
			log.info("\n edi_sts_cd : "+edi_sts_cd);
			log.info("\n del_cd : "+del_cd);
			if ("USA00080".equals(edi_grp_cd)) {
				if ("NFR".equals(edi_sts_cd) || "FTR".equals(edi_sts_cd)) {
					if (("US".equals(substr(del_cd, 0, 2)) || "CA".equals(substr(del_cd, 0, 2)))
							&& "I".equals(nvl(substr(cop_rail_chk_cd, 1, 2),""))) {
						aaa = "";//process진행.
					} else {
						rslt_remark = "NFR, FTR(US, CA) - skip : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("NFD".equals(edi_sts_cd) || "FTD".equals(edi_sts_cd)) {
					if ((("US".equals(substr(del_cd, 0, 2)) || "CA".equals(substr(del_cd, 0, 2)))
							&& "X".equals(nvl(substr(cop_rail_chk_cd, 1, 2),"")))
							|| (!"US".equals(substr(cop_rail_chk_cd, 1, 2)) 
									&& !"CA".equals(substr(cop_rail_chk_cd, 1, 2)))) {
						aaa = "";
					} else {
						rslt_remark = "NFD, FTD - skip : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			
			

			/* MVMT Code IC 를 VD로 Conversion 하는 케이스인지 확인. */
			// if("IN".equals(dtlVo.getEdiSts())){
			// String cnvtFlg = "";
			// cnvtFlg = getConvInToUVDFlg(dtlVo);
			// if("Y".equals(cnvtFlg)){
			// dtlVo.setEdiSts("UVD");
			// }
			// }

			/*
			 * 변환 전송에 해당 하는 IN 발생 시 삼성은 UVD, 그 밖의 화주는 IN으로 발송 해야 하므로 아래 로직에서
			 * UVD, IN 케이스 분기. org_edi_sts_cd 와 edi_sts_cd 의 비교를 통해 전송 여부 결정. CSR#
			 * : N200906150140
			 */
			if ("IN".equals(org_edi_sts_cd)) {
				if ("ASA00127".equals(edi_grp_cd)
						|| "ASA00128".equals(edi_grp_cd)
						|| "ASA00129".equals(edi_grp_cd)
						|| "USA00036".equals(edi_grp_cd)
						|| "USA00037".equals(edi_grp_cd)
						|| "ASA00130".equals(edi_grp_cd)
						|| "ASA00419".equals(edi_grp_cd)
						|| "ASA00471".equals(edi_grp_cd)) {

					if ("IN".equals(edi_sts_cd)) {
						uvd_conved_cnt = 0;
						uvd_conved_cnt = dbDao.uvdConvEdiSndRslt(event_yard, bkg_no, cntr_no, edi_grp_cd, cust_edi_sts_cd);
						if (uvd_conved_cnt > 0) {
							rslt_remark = "이미 IN → UVD 로 발송. IN발송은 SKIP.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					} else if ("UVD".equals(edi_sts_cd)) {
						if("ASA00130".equals(edi_grp_cd) || "ASA00419".equals(edi_grp_cd)|| "ASA00471".equals(edi_grp_cd)){
							rslt_remark = "IN 일때 UVD 자동발송안함.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}else{
							String cnvtFlg = "";
							cnvtFlg = getConvInToUVDFlg(dtlVo);//<- IN -> UVD 케이스가 맞으면 Return Y.
							if ("N".equals(cnvtFlg)) {
								rslt_remark = "IN → UVD 이고, 삼성 이지만 UVD 변환대상 아님.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
						
					}

				} else {
					if ("UVD".equals(edi_sts_cd)) {
						rslt_remark = "IN → UVD 이고 화주가 삼성이 아님. (UVD발송 안하는 케이스)";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			if ("ASA00130".equals(edi_grp_cd) && "OAN".equals(edi_sts_cd)){
				if((!dtlVo.getPodCd().equals(sendVo.getEventYard().substring(0,5)))){
					rslt_remark = "OAN이 Port Gateout이 아님.(NOT POD Gateout)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
				if("RLN".equals(org_edi_sts_cd) && 
						(!sendVo.getEventYard().substring(0,2).equals("US") && !sendVo.getEventYard().substring(0,2).equals("CA"))){
					rslt_remark = "RLN - OAN 발송은 US, CA에 한정";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}

			/********************************************************************/
			/* NIKE 관련 특화된 전송 logic 보완 - 2007.11.19 */
			/* USA00069, USA00214, USA00133 */
			if ("USA00069".equals(edi_grp_cd) || 
				"USA00214".equals(edi_grp_cd) ||
				"USA00133".equals(edi_grp_cd)) {

				
				/* ALN 발생시 동시에 발생하는 OA에 대하여 전송 여부 확인. 이미 전송한 OAN이 있는지 확인 */
				if("USA00133".equals(edi_grp_cd)){
					if ("ALN".equals(edi_sts_cd) && "OA".equals(cust_edi_sts_cd)) {
						chk_sts = "OAN";
						i_aln_oan = dbDao.getCopAlnOan(edi_grp_cd, bkg_no, cntr_no, event_yard, chk_sts);

						if (i_aln_oan > 0) {
							rslt_remark = "Skip_NIKE - ALN_OAN : ALN 발생시 이미 전송한 OAN이 있는지 확인";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
								
				// 2013.09.11 CHM-201326305 NIKE OA 로직 보완 요청
				// NIKE US315, CA315에 대해 Rail Loading OA가 발송된 경우 Gate out OA가 발송 되지 않도록 로직 보완
				// Cust EDI Code가 OA이가 있으면 전송하지 않는다.
				if("USA00069".equals(edi_grp_cd) || "USA00214".equals(edi_grp_cd)){
					if ("OA".equals(cust_edi_sts_cd)) {
						String cust_edi_cd = "OA";
						i_aln_oan = dbDao.searchCustEdiCdSndRult(edi_grp_cd, bkg_no, cntr_no, cust_edi_cd);

						if (i_aln_oan > 0) {
							rslt_remark = "Skip_NIKE - ALN(OA), RLN(OA), OAN(OA) 이미 전송한 OAN이 있는지 확인";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
				
				
				/* RLN은 앞서 ALN 이 발생하지 않았을 경우에만 전송 2008.05.20 IHJANG */
				/* CHM-201002817 USA00069 의 RLN 은 뒤에서 다시 체크하므로 제거  2010.02.23 hkoh */
				/* 황과장님과 nike 테스트시 주석 변경해야함.
				if (("USA00069".equals(edi_grp_cd) || "USA00214".equals(edi_grp_cd)) : 주석처리
				if (( "USA00214".equals(edi_grp_cd)) 주석 제거*/
				//if (("USA00069".equals(edi_grp_cd) || "USA00214".equals(edi_grp_cd))
				//		&& "RLN".equals(edi_sts_cd)) {
				if (( "USA00214".equals(edi_grp_cd))
						&& "RLN".equals(edi_sts_cd)) {
					chk_sts = "ALN";
					i_aln_oan = dbDao.getCopAlnOan(edi_grp_cd, bkg_no, cntr_no, event_yard, chk_sts);
					if (i_aln_oan > 0) {
						rslt_remark = "Skip_NIKE - ALN_RLN : RLN은 앞서 ALN 이 발생하지 않았을 경우에만 전송";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
				
				
				
				/* CHM-201002817  NIKE(USA00069) OA 전송로직 추가  2010.02.23 hkoh */
				/* POD 에서 EN/TN 발생시 OAN 발송  */
				/* POD에서 OAN 발송 없을 경우 RRN시 OAN 발송  
				 * 황과장님과 nike 테스트시 주석제거해야함  */
				 
				if ("".equals(edi_grp_cd) && ("OAN".equals(edi_sts_cd) || "RLN".equals(edi_sts_cd))){
					chk_sts = "OAN";
					String sub_sts_cd = "OA";
					if("OAN".equals(edi_sts_cd) ){
						i_pod_oan_cnt = dbDao.searchPodOanCnt(edi_grp_cd, bkg_no, cntr_no, chk_sts, sub_sts_cd);

						if(i_pod_oan_cnt > 0){
							rslt_remark = "POD에서 OAN 발송건 존재하므로 SKIP";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;					
						}					
					}
					if("RLN".equals(edi_sts_cd) ){
						i_aln_oan = dbDao.getCopAlnOan(edi_grp_cd, bkg_no, cntr_no, event_yard, chk_sts);
						if (i_aln_oan > 0) {
							rslt_remark = "RLN은 앞서 ALN 이 발생하지 않았을 경우에만 전송";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}					
					}
				}
//log.info("\n  --# log by ohk   i_pod_oan_cnd:"+i_pod_oan_cnt+"  i_oan_send_cnt:"+i_oan_send_cnt);				
					
				
				
				/* 아래는 원래 막혀 있었음.*/
//				if ("USA00069".equals(edi_grp_cd)) {
//					if ((sendVo.getManFlg() == null || !"Y".equals(sendVo.getManFlg()) && "MT".equals(edi_sts_cd)) || 
//						(sendVo.getManFlg() == null || !"Y".equals(sendVo.getManFlg()) && "FTD".equals(edi_sts_cd))|| 
//						(sendVo.getManFlg() == null || !"Y".equals(sendVo.getManFlg()) && "D".equals(edi_sts_cd))) {
//						log.info("\n !!@!@!@ Skip_MT, FTD and D - Manual Send!! : ");
//						rslt_remark = "Skip_MT, FTD and D - Manual Send!! : ";
//						rslt_flag = "F";
//						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//						return result_boolean = false;
//					}
//				}
				//3개 Status 는 Manual 로만 발송
//				if ("USA00069".equals(edi_grp_cd)) {
//					
//					log.info("\n 'USA00069'.equals(edi_grp_cd) sendVo.getManFlg() : "+sendVo.getManFlg());
//				
//					if ("Y".equals(sendVo.getManFlg()) && 
//						   ( "D".equals(edi_sts_cd)||
//							"MT".equals(edi_sts_cd)||
//							"FTD".equals(edi_sts_cd))){
//						aaa="";
//					}else{
//						log.info("\n !!@!@!@ Skip_MT, FTD and D - Manual Send!! : ");
//						rslt_remark = "Skip_MT, FTD and D - Manual Send!! : ";
//						rslt_flag = "F";
//						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//						return result_boolean = false;
//					}
//							
//				}
				
				/* SRM-201224145  NIKE AD status 자동전송 방지 로직 추가 */
				/* "USA00069" 기존 방식에 "AD" 추가*/
				/* "USA00214" "AD" 추가*/
				if ("USA00069".equals(edi_grp_cd)|| "USA00214".equals(edi_grp_cd)) {
					
					log.info("\n 'USA00069'||'USA00214'.equals(edi_grp_cd) sendVo.getManFlg() : "+sendVo.getManFlg());
					if("USA00069".equals(edi_grp_cd)){
						if(  "D".equals(edi_sts_cd)||
							"MT".equals(edi_sts_cd)||
						   "FTD".equals(edi_sts_cd)||
							"AD".equals(edi_sts_cd)){
							if("Y".equals(sendVo.getManFlg())){
								aaa="";//프로세스 진행
							}else{
								log.info("\n !!@!@!@ Skip_MT, FTD and D, AD - Manual Send!! : ");
								rslt_remark = "Skip_MT, FTD and D, AD - Manual Send!! : ";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
					}

					if("USA00214".equals(edi_grp_cd)){
						if("AD".equals(edi_sts_cd)){
							if("Y".equals(sendVo.getManFlg())){
								aaa="";//프로세스 진행
							}else{
								log.info("\n !!@!@!@ Skip_AD - Manual Send!! : ");
								rslt_remark = "Skip_AD - Manual Send!! : ";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
					}
				}
				
				
				
				/********************************************************************/
				/* NIKE 관련 특화된 전송 logic 보완 -2009-08-19 */
				/*
				 * Delivery Term 이 Y인 경우 POD가 US이고  VAD인 경우만 전송
				 * 2009-08-19 오현경 추가
				 */
				if ("USA00069".equals(edi_grp_cd) || "USA00214".equals(edi_grp_cd)) {
					//Y Term 이고 POD가 US인 Count
					i_de_term_cnt = dbDao.getCopVadChk(bkg_no, cntr_no, "US");
				/*
				 	SELECT COUNT(H.BKG_NO) AS CHECK_CNT
					FROM SCE_COP_HDR H, BKG_BOOKING B
					WHERE H.BKG_NO    = @[bkg_no]
					AND H.CNTR_NO     = @[cntr_no]
					AND H.BKG_NO      = B.BKG_NO
					AND B.DE_TERM_CD  = 'Y'
					AND H.POD_NOD_CD  LIKE @[pod_cd] ||'%'
				 */
					
					if (i_de_term_cnt > 0 && !"VAD".equals(edi_sts_cd)) {//<-- Y Term 이고 POD가 US가 아니면...
						rslt_remark = "[NIKE] D Term is not Y or POD is not 'US' !!";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			/* 2012.09.03 박찬민 [CHM-201219925] Sears D status 전송 로직 변경 요청 */
			/* 2012.10.11 권상준 [긴급반영요청] COM00946/ KMART/ TRADIANT 에 대해서도 Manual 'D' 만 전송되도록 수정 */
			/* 2012.11.08 권상준 [긴급반영요청] COM01075/ UPS/ TRADIANT 에 대해서도 Manual 'D' 만 전송되도록 수정 */
			
			if("COM02028".equals(edi_grp_cd) || "COM00946".equals(edi_grp_cd) || "COM01075".equals(edi_grp_cd)){
				if("D".equals(edi_sts_cd)){
					if("Y".equals(sendVo.getManFlg())){
						aaa="";//프로세스 진행
					}else{
						log.info("\n !!@!@!@ Skip_D - Manual Send!! : ");
						rslt_remark = "Skip_D - Manual Send!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			/* 2012.10.16 권상준 [CHM-201220786] COM02357/ CEVA- Microsoft/ TRADIANT 에 대해서도 Manual 'D','AD' 만 전송되도록 수정(단, 메뉴얼도 AD 만 발송시 전송 */
			// 2014.05.14 [CHM-201430160] [CEVA  Microsoft] COM02677 그룹코드 추가
			if("COM02357".equals(edi_grp_cd) || "COM02677".equals(edi_grp_cd) || "COM00874".equals(edi_grp_cd)){
//				if("AD".equals(edi_sts_cd) && "COM02357".equals(edi_grp_cd)){
//					if("Y".equals(sendVo.getManFlg()) && "AD".equals(org_edi_sts_cd)){
//						aaa="";//프로세스 진행
//					}else{
//						log.info("\n !!@!@!@ Skip_AD - Manual Send!! : ");
//						rslt_remark = "Skip AD - Manual Send!! : ";
//						rslt_flag = "F";
//						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//						return result_boolean = false;
//					}
//				}
				
				if("D".equals(edi_sts_cd)){
					if("Y".equals(sendVo.getManFlg())){
						aaa="";//프로세스 진행
					}else{
						log.info("\n !!@!@!@ Skip_D - Manual Send!! : ");
						rslt_remark = "Skip D - Manual Send!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}
			
			// 2016.08.05 [CHM-201642835] AG (Yard Term) Sending - Exclude Manual Sending
			if("COM02879".equals(edi_grp_cd) && "Y".equals(dtlVo.getDeTermCd()) && "AG".equals(edi_sts_cd)){
				if("Y".equals(sendVo.getManFlg())){
					log.info("\n !!@!@!@ Skip_AG_Yard - Manual Send!! : ");
					rslt_remark = "Skip_AG_Yard - Manual Send!! : ";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
				
			}
			

			/*******************************************************************************/
			/*
			 * 20071220. 삼성 ITTS 
			 * 1. GRP ID : ASA00130 
			 * 				UVD=CP012 : POD=DEL  일때만 UVD=CP012 적용 
			 * 				OAN=CP012 : POD<>DEL 일때만 OAN=CP012 적용 
			 * 2. GRP ID : ASA00409 
			 * 				VAD=CP012 : POD=DEL  일때만 VAD=CP012 적용 
			 * 				OAN=CP012 : POD<>DEL 일때만 OAN=CP012 적용
			 */
			/*******************************************************************************/
			
			if ("ASA00130".equals(edi_grp_cd) || "ASA00419".equals(edi_grp_cd) || "ASA00471".equals(edi_grp_cd)) {
				String actCd = getCopActCd(sendVo.getCopNo(), sendVo.getCopDtlSeq());
				log.info("\n actCd : "+actCd);
				String transMode = (actCd==null?"":actCd.substring(2, 3));
				log.info("ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ cop_rail_chk_cd : "+cop_rail_chk_cd);
				if ("UVD".equals(edi_sts_cd) && "CP211".equals(cust_edi_sts_cd)) {
					String cnvtFlg = "Y"; // 무조건 발송하도록 수정.
//					cnvtFlg = getConvInToUVDFlg(dtlVo);
					if ("N".equals(cnvtFlg)) {
						rslt_remark = "UVD 발송대상 아님.";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("OAN".equals(edi_sts_cd) && "CP204".equals(cust_edi_sts_cd)) {
					if (pod_cd != null && !pod_cd.equals(del_cd)){
						if(!"T".equals(transMode)) {
							rslt_remark = "Skip_OAN_CP204 Samsung ASA00130 ITTS!!! : ";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}else{
						rslt_remark = "Skip_OAN_CP204 Samsung ASA00130 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("FITRDO".equals(edi_sts_cd) && "CP010".equals(cust_edi_sts_cd)) {
					if (pod_cd != null && !pod_cd.equals(del_cd)){
						if(!"XI".equals(cop_rail_chk_cd)) {
							rslt_remark = "Skip_FITRDO_CP010 Samsung ASA00130 ITTS!!! : ";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}else{
						rslt_remark = "Skip_FITRDO_CP010 Samsung ASA00130 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			} else if ("ASA00409".equals(edi_grp_cd)) {
				if ("VAD".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (pod_cd != null && !pod_cd.equals(del_cd)) {
						rslt_remark = "Skip_VAD_CP012 Samsung ASA00409 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("OAN".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (pod_cd != null && pod_cd.equals(del_cd)) {
						rslt_remark = "Skip_OAN_CP012 Samsung ASA00409 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}

			/*******************************************************************************/
			/*
			 * 2008-08-07 Group_Id = 'USA00285' 
			 * 		a> Status = 'VAD' Customer Status = 'X1'는 Local shipment 경우만 전송
			 * 		b> Status = 'ARN' Customer Status = 'X1'는 Rail shipment  경우만 전송
			 */
			/*******************************************************************************/

			if ("USA00285".equals(edi_grp_cd)) {
				if ("VAD".equals(edi_sts_cd) && "X1".equals(cust_edi_sts_cd)) {
					if ("X".equals(nvl(substr(cop_rail_chk_cd, 1, 2), " "))) {
						aaa = "";
					} else {
						rslt_remark = " Local shipment 경우만 전송";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("ARN".equals(edi_sts_cd)&& "X1".equals(cust_edi_sts_cd)) {
					if ("I".equals(nvl(substr(cop_rail_chk_cd, 1, 2), " "))) {
						aaa = "";
					} else {
						rslt_remark = " Rail shipment  경우만 전송 ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}

			}

			/******* AMSDATA***************************************************************************
			 * 변경전 : NIS 	- container별 : container별로 각각 전송 
			 * 				- B/L별 :대표로 한번만 전송, eNIS에서 대표로 한나만 전송한고 나머지는 단순 update 
			 * 변경후 : NIS - 무조건 한번만 전송 
			 * 		  eNIS - CNTR, B/L별인지 판단하여 각각 보낼지 대표로 보낼지 구분하여 전송
			 ******************************************************************************************/
			if ("AMS".equals(call_from)) {
				if (!"C".equals(dtlVo.getEdiCntrSndTpCd())){
					if("AVL".equals(edi_sts_cd) || "ACL".equals(edi_sts_cd)
					|| "AVN".equals(edi_sts_cd) || "ACN".equals(edi_sts_cd)) {
						aaa="";
					} else {
						if("1".equals(sendVo.getCntrCallCnt())){
							aaa="";
						}else{
							rslt_remark = "AMS BL별 전송 ";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
				}
			}

			
			/***************************************************************************************/



			/*
			 * 2008-11-20 : USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP
			 * 2014-12-08 : Logic 제거 요청 FROM NXG
			 */
//			log.info("\n USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP ");
//			if ("USA00303".equals(edi_grp_cd)) {
//				if ("OAN".equals(edi_sts_cd)) {
//					chk_sts = "RLN";
//					i_oan_rln = dbDao.getCopOanRln(edi_grp_cd, bkg_no, cntr_no, chk_sts);
//					if (i_oan_rln > 0) {
//						rslt_remark = "USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP";
//						rslt_flag = "F";
//						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//						return result_boolean = false;
//					}
//				}
//
//				if ("RLN".equals(edi_sts_cd)) {
//					chk_sts = "OAN";
//					i_oan_rln = dbDao.getCopOanRln(edi_grp_cd, bkg_no, cntr_no, chk_sts);
//					if (i_oan_rln > 0) {
//						rslt_remark = "USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP";
//						rslt_flag = "F";
//						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//						return result_boolean = false;
//					}
//				}
//			} 
		

			/*****************************************************************************************************************/
			/* 315 전송 BLOCKING - Receiver ID 가 CARGOSMART 일 때 */
			/* BKG VIA 혹은 SI VIA 가 'C' 가 아닌 shipment 에 대해서는 315 전송 Blocking */
			/*
			 * (EDI_GRP_CD USA00269, USA00085, USA00248, USA00179 는 제외.Manual
			 * 전송일 경우는 제외.)
			 */

			// CX 이며 manual 전송이 아닐 경우에는 해당 group id 와 container, bkg_no,
			// bkg_no_split 으로
			// SCE_EDI_SND_RSLT (EDI 전송기록) 을 조회하여 전송 값이 있다면 logic skip;
			/* 2011.05.23 [CHM-201110822-01] (CargoSmart)315 로직보완요청 - 원복처리
			String v_blocked = "";
			if (!"Y".equals(sendVo.getManFlg())) {
				v_blocked = searchIsCargoSmart(dtlVo.getEdiGrpCd(), sendVo.getBkgNo());
				// v_blocked = 'Y' : edi 전송 Blocking 해야 하는 case.
				if ("Y".equals(v_blocked)) {
					rslt_remark = "[CARGOSMART][BLOCKED:bkg_booking.XTER_SI_CD && XTER_BKG_RQST_CD <> 'CSM']";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}
			*/

			// CX 이며 manual 전송이 아닐 경우에는 해당 group id 와 container, bkg_no 으로
			// SCE_EDI_SND_RSLT (EDI 전송기록) 을 조회하여 전송 값이 있다면 logic skip;

			String cx_mt_cnt = "";
			if (!"Y".equals(sendVo.getManFlg()) && "CX".equals(edi_sts_cd)) {
				cx_mt_cnt = searchFindMtEdiSndRslt(dtlVo.getEdiGrpCd(), sendVo.getBkgNo(), sendVo.getCntrNo());
				if (Integer.parseInt(cx_mt_cnt) > 0) {
					rslt_remark = "MT exists [CX skip]";
					rslt_flag = "F";

					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}

			/********************************************************************************/
			/* CHM-200901666 Target 315 : 2009.11.30 */
			/* CUST GRP ID : USA00094 */
			/* INBOUND에 RAIL 구간이 존재하면 마지막 OAN 만 전송 */
			/********************************************************************************/
			if ("USA00094".equals(dtlVo.getEdiGrpCd()) && "OAN".equals(dtlVo.getEdiSts())) {
				GetRailTermVO getRailTermVO = new GetRailTermVO();
				int rail_cnt = 0;
				String oan_term_seq = "";

				getRailTermVO = dbDao.getRailTerm(dtlVo.getCopNo());
				rail_cnt = Integer.parseInt(getRailTermVO.getRailCnt());
				oan_term_seq = getRailTermVO.getOanTermSeq();

				if (rail_cnt > 0 && !oan_term_seq.equals(sendVo.getCopDtlSeq())) {
					rslt_remark = "I/B 구간의 마지막 OAN이 아님. ";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}
			
			/********************************************************************************/
			/* CHM-200901666 Target 315 : 2010.11.18 */
			/* CUST GRP ID : USA00094 */
			/* OAN 이후에 발생가능한 STATUS인 D,MT를 제외한 나머지 STATUS는 전송제외, 동일 CNTR에 여러 BKG가 물린
			 * PARTIAL건 BKG에 대해서 모두 제외    */
			/********************************************************************************/
			// 2011-10-06 (Target) OA 전송 이후 메뉴얼 건 로직 보완 요청 - 메뉴얼 재전송시 OAN이후에는 발송불가능(M,DT제외) 로직을 타지 않도록 수정
			if (!"Y".equals(sendVo.getManFlg())) {
				if ("USA00094".equals(dtlVo.getEdiGrpCd()) && !("D").equals(dtlVo.getEdiSts()) && !("MT").equals(dtlVo.getEdiSts())){
					
					int resultCnt = dbDao.searchEdiStsForPrtlBkg(dtlVo);
					if (resultCnt > 0) {
						rslt_remark = "USA00094인경우 OAN이후에는 발송불가능(M,DT제외)";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}

			}
			
			log.info("    --#  log by ohk  checkEdiGroupValidation step1 edi_grp_cd:"+edi_grp_cd+" org_edi_sts_cd:"+org_edi_sts_cd+"  edi_sts_cd:"+edi_sts_cd+"  mvmtSts:"+sendVo.getMvmtSts());			
			/********************************************************************************/
			/* CHM-201002970 판토스 CT EDI 전송 누락 관련 보완 로직 추가 요청 판토스  2010-03-11 ohk */
			/* CUST GRP ID : ASA00120 */
			/* 화주 ASA00120에 대해 POD=BEANR, DEL=BEANR, NLRTM에서 T/S되고 2ND VVD가 없는 것은 IC 발생시 VAD로 EDI 전송 */
			/********************************************************************************/
			if ( "ASA00120".equals(edi_grp_cd) && sendVo.getMvmtSts() != null &&  "IC".equals(sendVo.getMvmtSts()) && "IN".equals(org_edi_sts_cd)   ) {
				if("VAD".equals(edi_sts_cd)){
					Edi315SendOptionsVO optVo = new Edi315SendOptionsVO();
					optVo.setCopNo(dtlVo.getCopNo());
					optVo.setBkgNo(bkg_no);					
					optVo.setEdiGroupCd("ASA00120");
					optVo.setChkPortCd("NLRTM");
					optVo.setEPodLoc("BEANR");
					optVo.setEDelLoc("BEANR");
					SceCopDtlVO  chkDtlVo = searchICtoVADsendValidation(optVo);
					
					if(chkDtlVo == null ||( chkDtlVo.getActDt() != null && chkDtlVo.getActDt().length() > 0)){
						if(chkDtlVo == null){
							rslt_remark = "ASA00120 화주 IN 발송 대상이 아님. TS<> NLRTM, POD<>BEANR, DEL<>BEANR, VVD갯수<>1";						
						}else{
							rslt_remark = "ASA00120 화주 IN 발송 대상이 아님. VAD actual 정보 입력됨 ";						
						}
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;					
					}else{
						currVo.setCurrEventDt(sendVo.getEventDt());
						currVo.setCurrEventYard(chkDtlVo.getNodCd());
						currVo.setCurrCopDtlSeq(chkDtlVo.getCopDtlSeq());
						//sce_cop_dtl update 금지 시키기 위한 flag
						//IC 발생시 VAD로 EDI 전송 하는 경우 sce_cop_dtl의 VAD 정보를 update 하면 안됨.
						currVo.setDtlUpdateSkipFlag("Y");//sce_cop_dtl update 금지
						//currVo.setCurrVvd(chkDtlVo.getVslCd()+chkDtlVo.getSkdVoyNo()+chkDtlVo.get)
						currVo.setIsPodAtaReplace("Y");
						currVo.setPodAtaEventDt(sendVo.getEventDt());
						currVo.setPodAtaEventDtGmt(getGmtDt(sendVo.getEventDt(),chkDtlVo.getNodCd()) );						
						//currVo.setPodAtaYard(chkDtlVo.getNodCd());

					}
					
				}
				//ASA00120 화주 IN 발생시 EDI 전송 하도록 아래부분 주석처리
//				else{
//					rslt_remark = "ASA00120 화주 org_edi_sts_cd:IN/edi_sts_cd:"+edi_sts_cd+" 발송 대상이 아님. ";					
//					rslt_flag = "F";
//					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//					return result_boolean = false;						
//				}
				log.info("    --#  log by ohk  checkEdiGroupValidation step2  result_boolean:"+result_boolean);
			}
			/********************************************************************************/
			/* CHM-201002970 판토스 CT EDI 전송 누락 관련 보완 로직 추가 요청 판토스  2010-03-11 ohk */
			/* CUST GRP ID : ASA00120 */
			/* 화주 ASA00120에 대해 POD=BEANR, DEL=BEANR, NLRTM에서 T/S되고 2ND VVD가 없는 것은 IC 발생시 VAD로 EDI 전송 
			 * VAD 발송 이후 event 에 대해 IC 발생시의  Event Dt를 PODATA 정보로 넣어준다*/
			/********************************************************************************/			
			if("ASA00120".equals(edi_grp_cd) && currVo.getCurrCopDtlSeq() != null &&
						currVo.getCurrCopDtlSeq().length()==4 && Integer.parseInt(currVo.getCurrCopDtlSeq()) > 6000){
				
				Edi315SendOptionsVO optVo = new Edi315SendOptionsVO();
				optVo.setCopNo(dtlVo.getCopNo());
				optVo.setBkgNo(bkg_no);					
				optVo.setEdiGroupCd("ASA00120");
				optVo.setChkPortCd("NLRTM");
				optVo.setEPodLoc("BEANR");
				optVo.setEDelLoc("BEANR");
				SceCopDtlVO  chkDtlVo = searchICtoVADsendValidation(optVo);	
				if(chkDtlVo != null && ( chkDtlVo.getActDt() == null || chkDtlVo.getActDt().length() == 0) 
						&& chkDtlVo.getCopDtlSeq() != null && chkDtlVo.getCopDtlSeq().length() > 0){
					
					currVo.setIsPodAtaReplace("Y");	
					currVo.setPodAtaEventDt(chkDtlVo.getEstmDt());
					currVo.setPodAtaEventDtGmt(getGmtDt(sendVo.getEventDt(),chkDtlVo.getNodCd()) );					
					//currVo.setPodAtaYard(chkDtlVo.getNodCd());					
				}
			}	

			/********************************************************************************/
			/* 1.POD와 HUB가 같은 경우 UV를 A로 전송
			/* 2.GAP(NON-U.S.A.) COM02200 인경우 
			/*   가. POD와 DEL이 같은 경우 UV를 A로 전송
			/*   나. POD와 DEL이 다른 경우 
   			/*	     A. POD와 DEL의 SCC가 같은 경우 UV를 A로 전송
   			/*		 B. POD와 DEL의 SCC가 다른 경우 추후 통보
            /*   다. R/D Term이 D인 경우만 RL 전송
			/* 3.POD와 HUB가 일치하지 않는 경우 
			/*   가.Rail의 경우 UR을 A로 전송
			/*   나.Truck으로 DEL로 이송되는 경우 ID를 A로 전송
			/* 4.OAN - R/D Term이 D이고 DEL이 Gap Distribution Center 일 때만 전송 
			/* 5.Uk향 화물의 경우 CR Data를 AV로 처리하여 전송
			/*
			/* [CHM-201112548-01] : Gap EDI 관련 수정요청 2011-08-18
			/* [CHM-201216603] : 개발-GAP FA status 전송주체 추가 요청
			/* []Gap Distribution Center 변경(USCPM 삭제)
			/* []GAP EDI Group ID별 Logic 복사요청  - COM02200=COM02353, COM02201=COM02354
			/*
			/********************************************************************************/

			// 2011.08.18 권상준 [CHM-201112548-01] : Gap EDI 관련 수정요청
			// SCE_EDI_MNG_STS 테이블에 URN-AVL, CU-AVL, OAN-AVL 를  COM02202 일때 AVL 발송여부를 정하여 발송.
			// 메뉴얼 발송일때는 GAP 로직 상관없이 발송되도록 
			if("COM02200".equals(edi_grp_cd) || "COM02201".equals(edi_grp_cd)){
				String bkgPoNo = getBkgPoNo(dtlVo.getBkgNo());
				if(!bkgPoNo.equals(" ")){
					StringBuffer sb = new StringBuffer();
					for(int i = 0; i < bkgPoNo.length(); i++){
				  		if( Character.isDigit( bkgPoNo.charAt(i) ) ) {
				  			sb.append( bkgPoNo.charAt(i) );
				  		}
				  	}
					if(sb.length()== bkgPoNo.length()){
						rslt_remark = "COM02200,COM02201: BkgPoNo 가 숫자로만 되어 있으면 발송 대상 아님";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false; 
					}
				}
		    }
			if (!"Y".equals(sendVo.getManFlg())) {
				int sndRsltCount = 0;
		        String snd_rslt_edi_sts = "";
		        String snd_rslt_cust_edi_sts = "";
				if("COM02200".equals(edi_grp_cd) || "COM02353".equals(edi_grp_cd) || "COM02201".equals(edi_grp_cd) || "COM02354".equals(edi_grp_cd) || "COM02215".equals(edi_grp_cd)){ // [CHM-201216603] : 개발-GAP FA status 전송주체 추가 요청-COM2202, COM2286 삭제
					
					//if("CT".equals(edi_sts_cd)){
						
						String[] rccCdresult = new String[2];
						String hubLocCd = getCgoRlsHubLoc(dtlVo.getBlNo(), sendVo.getEventYard());
						String podCd = (dtlVo.getPodCd()==null?"":dtlVo.getPodCd());
						//String orgEdiSts = dtlVo.getOrgEdiSts();
						String delCd = (dtlVo.getDelCd()==null?"":dtlVo.getDelCd());
						String bkg_No = (dtlVo.getBkgNo()==null?"":dtlVo.getBkgNo()); //bkg_no를 가져온다.
						rccCdresult = searchPrtlBkgsForEdiGrp(bkg_No);
						String podCdScc = rccCdresult[0].toString();
						String delCdScc = rccCdresult[1].toString();
						log.info("\n ERRORERROR");
						String actCd = getCopActCd(sendVo.getCopNo(), sendVo.getCopDtlSeq());
						log.info("\n actCd : "+actCd);
						String transMode = (actCd==null?"":actCd.substring(2, 3));
						int sendAstatus = dbDao.searchGapEdiSndRult(edi_grp_cd ,sendVo.getCntrNo(),bkg_No); //A status로 발송된 내역이 있는지 확인값을 가져옴
						log.info("\n hubLocCd : "+hubLocCd);
						log.info("\n podCd : "+podCd);
						log.info("\n delCd : "+delCd);
						log.info("\n bkg_No : "+bkg_No);
						log.info("\n podCdScc : "+podCdScc);
						log.info("\n delCdScc : "+delCdScc);
						log.info("\n actCd : "+actCd);
						log.info("\n transMode : "+transMode);
						log.info("\n sendAstatus : "+sendAstatus); 
						/*
						 * 2011.05.30 채창호 [CHM-201110991-01] : GAP 315 logic 보완 및 오류 사항 확인 요청
						 * 2011.08.18 권상준 [CHM-201112548-01] : Gap EDI 관련 수정요청
						 */
//						if(("COM02215".equals(edi_grp_cd) || "COM02201".equals(edi_grp_cd))){
						// COM02202 조건 삭제(COM02202에 UVD, URN, OAN 발송안함으로 설정하여 SCE_EDI_SND_RLT 에 Saved 로 저장한뒤 AV(AVL, AOL, AON) 전송할때 참조한다. 
						if(("COM02215".equals(edi_grp_cd) || "COM02201".equals(edi_grp_cd) || "COM02354".equals(edi_grp_cd))){ 
							log.info("\n GAP-1 ");
							if("URN".equals(edi_sts_cd)){
								if(sendAstatus == 0){
									if (!podCd.equals(hubLocCd)){
										if (!"R".equals(transMode)){
											log.info("\n GAP-1-1 ");
											rslt_remark = "COM02201,COM02354,COM02215는 A 발송 대상이 아님.(POD = HUB LOC 이고 Rail일 경우만 발송) POD="+podCd+"/HUB_LOC="+hubLocCd;
											rslt_flag = "F";
											modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
											return result_boolean = false;
										}
									}else{
										log.info("\n GAP-1-1 ");
										rslt_remark = "COM02201,COM02354,COM02215는 A 발송 대상이 아님.(POD = HUB LOC 인경우만 발송) POD="+podCd+"/HUB_LOC="+hubLocCd;
										rslt_flag = "F";
										modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
										return result_boolean = false; 
									}
								}else{  
									log.info("\n GAP-1-1 ");
									rslt_remark = "COM02201,COM02354,COM02215는 기존에 URN(A), OAN(A)가 발송된 경우 URN(A) 발송 대상이 아님.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false; 
								}
							}
							
							
							/*2011.05.30 채창호 [CHM-201110991-01] : GAP 315 logic 보완 및 오류 사항 확인 요청
							 *GAP(NON-U.S.A.):COM02200 경우의 인 경우
							 *가. POD와 DEL이 같은 경우 UV를 A로 전송
							 *나. POD와 DEL이 다른 경우 
				   			 *	     A. POD와 DEL의 SCC가 같은 경우 UV를 A로 전송
				   			 *		 B. POD와 DEL의 SCC가 다른 경우 추후 통보
				   			 */
							
							if("UVD".equals(edi_sts_cd)){
								if(!podCd.equals(hubLocCd)){
									log.info("\n GAP-1-2 ");
									rslt_remark = "COM02201,COM02354,COM02215는 A 발송 대상이 아님.(POD = HUB LOC 인경우만 발송) POD="+podCd+"/HUB_LOC="+hubLocCd;
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}else{
									snd_rslt_edi_sts = "UVD";
						            snd_rslt_cust_edi_sts = "A";

						            sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						            if (sndRsltCount > 0) {
						            	this.log.info("\n GAP-4-2 ");
						            	rslt_remark = "기존 UVD(A) 가  있으면 발송 대상이 아님.";
						            	rslt_flag = "F";
						            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						            	return result_boolean = false;
						            }
								}								
							}
						
//							rslt_remark = "COM02215는 CT 발송 대상이 아님. (POD = HUB LOC 인경우만 발송) POD="+podCd+"/HUB_LOC="+hubLocCd;
//							rslt_flag = "F";
//							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//							return result_boolean = false;
							
							 // GAP(U.S.A.):COM02201인 조건
							 // POD와 HUB가 일치 하지 않는 경우
							 // Truck으로 DEL로 이송되는 경우 OAN를 A로 전송
							
							if("OAN".equals(edi_sts_cd) && "A".equals(cust_edi_sts_cd)){
								log.info("\n GAP-3 ");
								log.info("\n transMode : "+transMode);
								if(sendAstatus == 0){
									if (!podCd.equals(hubLocCd)){
										if(!"T".equals(transMode)){
											log.info("\n GAP-3-1 ");
											rslt_remark = "COM02201,COM02354,COM02215는 OAN 발송 대상이 아님. ORG_EDI_STS=OAN 인경우 POD != HUB_LOC_CD이고 TRUCK의 경우만 발송 ";
											rslt_flag = "F";
											modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
											return result_boolean = false;
										}
									}else{
										log.info("\n GAP-3-2 ");
										rslt_remark = "COM02201,COM02354,COM02215는 OAN 발송 대상이 아님. ORG_EDI_STS=OAN 인경우 POD != HUB_LOC_CD의 경우만 발송 ";
										rslt_flag = "F";
										modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
										return result_boolean = false;
									}
								}else{
									log.info("\n GAP-3-2 ");
									rslt_remark = "COM02201,COM02354,COM02215는 기존에 URN(A), OAN(A)가 발송된 경우 OAN(A) 발송 대상이 아님.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}
							}
							
						}else if ("COM02200".equals(edi_grp_cd) || "COM02353".equals(edi_grp_cd)) {
							if (("UVD".equals(edi_sts_cd)) && (!podCd.equals(delCd))) {
					              this.log.info("\n GAP-2 ");
					              if (!podCdScc.equals(delCdScc)) {
					                this.log.info("\n GAP-2-1 ");
					                rslt_remark = "COM02200, COM02353는 CT 발송 대상이 아님. (Rail 의 경우 발송) POD=" + podCd + "/delCd=" + delCd;
					                rslt_flag = "F";
					                modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					                return result_boolean = false;
					              }
					              snd_rslt_edi_sts = "UVD";
					              snd_rslt_cust_edi_sts = "A";

					              sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
					              if (sndRsltCount > 0) {
					                this.log.info("\n GAP-4-2 ");
					                rslt_remark = "기존 UVD(A) 가  있으면 발송 대상이 아님.";
					                rslt_flag = "F";
					                modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					                return result_boolean = false;
					              }

					        }

					        if (("URN".equals(edi_sts_cd)) && (sendAstatus > 0)) {
					            this.log.info("\n GAP-1-1 ");
					            rslt_remark = "COM02200, COM02353 는 기존에 URN(A) 가 발송된 경우 URN(A) 발송 대상이 아님.";
					            rslt_flag = "F";
					            modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					            return result_boolean = false;
					        }

					    }
						
						/*
						 * 2011.05.30 채창호 [CHM-201110991-01] : GAP 315 logic 보완 및 오류 사항 확인 요청
						 * R/D Term이 D인 경우만 RL 전송
						 */
						if(("RLN".equals(edi_sts_cd))){

							log.info("\n GAP-4 ");
							log.info("\n DeTermCd : "+dtlVo.getDeTermCd());
								if(!("D".equals(dtlVo.getDeTermCd()))){
									log.info("\n GAP-4-1 ");
									rslt_remark = "RL 발송 대상이 아님. (R/D Term=D 만 발송)";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}else{
									snd_rslt_edi_sts = "RLN";
									snd_rslt_cust_edi_sts = "RL";
									// RLN이 발송되어 있는지 확인하여 발송내역이 없으면 RLN을 발송한다.
									sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
									if(sndRsltCount >0){
										log.info("\n GAP-4-2 ");
										rslt_remark = "기존 RLN이 있으면 발송 대상이 아님. (R/D Term=D 만 발송)";
										rslt_flag = "F";
										modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
										return result_boolean = false;
									}
								}
						}
						
						// OAN - R/D Term이 D이고 DEL이 Gap Distribution Center 일 때만 전송 
						if("OAN".equals(edi_sts_cd) && "OA".equals(cust_edi_sts_cd)){
							log.info("\n GAP-5 ");
							log.info("\n DeTermCd : "+dtlVo.getDeTermCd());
							log.info("\n DelNodCd : "+dtlVo.getDelNodCd().substring(0,5));
							if("D".equals(dtlVo.getDeTermCd()) &&
								("USFSH".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USHBN".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USGVP".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USFAT".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USAED".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USPHX".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"GBRUG".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"CABPE".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"CABJN".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"JPHIJ".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"CNSHA".equals(dtlVo.getDelNodCd().substring(0,5)) ||
								"USCPM".equals(dtlVo.getDelNodCd().substring(0,5)) ||	//2013.12.16 [CHM-201328142] Gap Distribution Center Add (USCPM,CAVAN)
								"CAVAN".equals(dtlVo.getDelNodCd().substring(0,5))))	//2012.05.09 []Gap Distribution Center 변경(USCPM 삭제) //CHM-201216510 개발-GAP OA event 누락 사유 확인 요청 
							{
								//CHM-201113997 GAP EDI 중복전송 방지 Logic 적용 요청 (VA, OA, D에 대해 중복전송이 되지 않도록)
								snd_rslt_edi_sts = "OAN";
								snd_rslt_cust_edi_sts = "OA";
								// OAN(OA) 발송되어 있는지 확인하여 발송내역이 없으면 OAN(OA)을 발송한다.
								sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
								if(sndRsltCount >0){
									rslt_remark = "기존 OAN(OA)이 있으면 발송 대상이 아님.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}
							}else{
								rslt_remark = "COM02200,COM02353, COM02201,COM02354,COM02215는 OA 발송 대상이 아님. (R/D Term=D && Gap Distribution Center만 발송)";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
						
						//CHM-201113997 GAP EDI 중복전송 방지 Logic 적용 요청 (VA, OA, D에 대해 중복전송이 되지 않도록)
						if("VAD".equals(edi_sts_cd) && "VA".equals(cust_edi_sts_cd)){
							snd_rslt_edi_sts = "VAD";
							snd_rslt_cust_edi_sts = "VA";
							// VAD(VA) 발송되어 있는지 확인하여 발송내역이 없으면 VAD(VA)을 발송한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount >0){
								rslt_remark = "기존 VAD(VA)이 있으면 발송 대상이 아님.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
						
						if("D".equals(edi_sts_cd) && "D".equals(cust_edi_sts_cd)){
							snd_rslt_edi_sts = "D";
							snd_rslt_cust_edi_sts = "D";
							// D(D) 발송되어 있는지 확인하여 발송내역이 없으면 D(D)을 발송한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount >0){
								rslt_remark = "기존 D(D)이 있으면 발송 대상이 아님.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}
					}
		        if(edi_grp_cd.equals("COM02201") || edi_grp_cd.equals("COM02354")){  // 2012.03.12 박찬민 [CHM-201216603] : 개발-GAP FA status 전송주체 추가 요청 (COM02202 -> COM02201로 변경 edi_grp_cd, log.info, rslt_remark)
					if((org_edi_sts_cd.equals("URN") && edi_sts_cd.equals("AVL")) ||
						(org_edi_sts_cd.equals("OAN") && cust_edi_sts_cd.equals("AV") && edi_sts_cd.equals("AVL")))
					{
						if(org_edi_sts_cd.equals("URN") && edi_sts_cd.equals("AVL")){
							snd_rslt_edi_sts = "URN";
							snd_rslt_cust_edi_sts = "A";
							// URN일때 URN이 SCE_EDI_SND_RSLT 에 있는지 확인한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						}else if (org_edi_sts_cd.equals("OAN") && cust_edi_sts_cd.equals("AV") && edi_sts_cd.equals("AVL")){
							snd_rslt_edi_sts = "OAN";
							snd_rslt_cust_edi_sts = "A";
							// OAN 일때 OAN 이 SCE_EDI_SND_RSLT 에 있는지 확인한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						}
						
						if(sndRsltCount > 0){
							snd_rslt_edi_sts = "CU";
							snd_rslt_cust_edi_sts = "AV";
							// URN, OAN 일때 CU가 SCE_EDI_SND_RSLT 에 있는지 확인하여 있으면 AVL을 발송한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount > 0){
								snd_rslt_edi_sts = "AVL";
								snd_rslt_cust_edi_sts = "AV";
								// AVL이 발송되어 있는지 확인하여 발송내역이 없으면 AVL을 발송한다.
								sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
								if(sndRsltCount == 0){
									currVo.setCurrEventDt(dbDao.searchGapAvEventDt(sendVo.getEventDt()));
									//sendVo.setEventDt(SELECT sysdate , sysdate+(1/24/60) FROM DUAL;);
									//currVo.setCurrEventDt(SELECT sysdate , sysdate+(1/24/60) FROM DUAL;);
								}else{
									log.info("\n COM02201,COM02354(Expeditors(GAP)) 의  AVL 일때 AVL이 발송 되었으면 AVL 발송안함.");
									rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의  AVL 일때 AVL이 발송 되었으면 AVL 발송안함.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}						
							}else {
								log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.");
								rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
						}else {
							log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 (URN,OAN)+CU 가 발송이 안되었으면 AVL 발송안함.");
							rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 (URN,OAN)+CU 가 발송이 안되었으면 AVL 발송안함.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
						
						
						
					}
					
					if(org_edi_sts_cd.equals("CU") && edi_sts_cd.equals("AVL")){
						snd_rslt_edi_sts = "CU";
						snd_rslt_cust_edi_sts = "AV";
						// CU 일때 CU 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.
						sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						if(sndRsltCount > 0){
							snd_rslt_edi_sts = "UVD";
							snd_rslt_cust_edi_sts = "A";
							// CU 일때 UVD 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.(CU+UVD = AVL일때)
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount == 0){
								// CU 일때 URN 과 OAN이 SCE_EDI_SND_RSLT 에 있는지 확인하여 있으면 AVL을 발송한다.
								sndRsltCount = dbDao.searchGapEdiSndRult(edi_grp_cd ,cntr_no, bkg_no);
								if(sndRsltCount == 0){
									log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 CU 일때 URN, OAN 가 발송이 안되었으면 AVL 발송안함.");
									rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 CU 일때 URN, OAN 가 발송이 안되었으면 AVL 발송안함.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}else{
									snd_rslt_edi_sts = "AVL";
									snd_rslt_cust_edi_sts = "AV";
									// AVL이 발송되어 있는지 확인하여 발송내역이 없으면 AVL을 발송한다.
									sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
									if(sndRsltCount > 0){
										log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.");
										rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.";
										rslt_flag = "F";
										modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
										return result_boolean = false;
									}
								}
							}else{
								snd_rslt_edi_sts = "AVL";
								snd_rslt_cust_edi_sts = "AV";
								// AVL이 발송되어 있는지 확인하여 발송내역이 없으면 AVL을 발송한다.
								sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
								if(sndRsltCount > 0){
									log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.");
									rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.";
									rslt_flag = "F";
									modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
									return result_boolean = false;
								}
							}
							
						}else{
							log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 CU 일때 CU+(URN,OAN) 가 발송이 안되었으면 AVL 발송안함.");
							rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 CU 일때 CU+(URN,OAN) 가 발송이 안되었으면 AVL 발송안함.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
						
						
					}
					
					if(org_edi_sts_cd.equals("UVD") && edi_sts_cd.equals("AVL")){
						snd_rslt_edi_sts = "UVD";
						snd_rslt_cust_edi_sts = "A";
						// UVD 일때UVD 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.
						sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						if(sndRsltCount > 0){
							snd_rslt_edi_sts = "AVL";
							snd_rslt_cust_edi_sts = "AV";
							// AVL이 발송되어 있는지 확인하여 발송내역이 없으면 AVL을 발송한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount > 0){
								log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.");
								rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 URN, OAN 일때 CU 가 발송이 안되었으면 AVL 발송안함.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}else{
								// UVD 일때 AVL 발송시 Event Date를 + 1분으로 발송한다.
								currVo.setCurrEventDt(dbDao.searchGapAvEventDt(sendVo.getEventDt()));
								//sendVo.setEventDt(SELECT sysdate , sysdate+(1/24/60) FROM DUAL;);
								//currVo.setCurrEventDt(SELECT sysdate , sysdate+(1/24/60) FROM DUAL;);
							}
						}else{
							log.info("\n COM02201,COM02354(Expeditors(GAP)) 의 UVD 일때 UVD+CU 가 발송이 안되었으면 AVL 발송안함.");
							rslt_remark = "COM02201,COM02354(Expeditors(GAP)) 의 CU 일때 UVD+CU 가 발송이 안되었으면 AVL 발송안함.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
						
						
					}
				}else if (edi_grp_cd.equals("COM02200") || edi_grp_cd.equals("COM02353")){ // 2012.03.12 박찬민 [CHM-201216603] : 개발-GAP FA status 전송주체 추가 요청 (COM02286 -> COM02200 edi_grp_cd, log.info, rslt_remark)
					if ((org_edi_sts_cd.equals("URN")) && (edi_sts_cd.equals("AOL")))
			        {
						snd_rslt_edi_sts = "URN";
						snd_rslt_cust_edi_sts = "A";
						// URN 일때 URN 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.
						sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						if(sndRsltCount > 0){
							snd_rslt_edi_sts = "OB";
				            snd_rslt_cust_edi_sts = "AV";
				            sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
				            if (sndRsltCount > 0) {
				            	snd_rslt_edi_sts = "AOL";
				            	snd_rslt_cust_edi_sts = "AV";
				            	sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
				            	if (sndRsltCount == 0) {
					                currVo.setCurrEventDt(this.dbDao.searchGapAvEventDt(sendVo.getEventDt()));
					            }else{
					                this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 AOL 일때 AOL 가 발송이 안되었으면 AOL 발송안함.");
					                rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 AOL 일때 AOL 가 발송이 안되었으면 AOL 발송안함.";
					                rslt_flag = "F";
					                modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					                return result_boolean = false;
					            }
				            } else {
				            	this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.");
				            	rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.";
				            	rslt_flag = "F";
				            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				            	return result_boolean = false;
				            }
						}else{
							log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 URN+OB 가 발송이 안되었으면 AVL 발송안함.");
							rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 URN+OB 가 발송이 안되었으면 AVL 발송안함.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
						
						

			        }

			          if ((org_edi_sts_cd.equals("OB")) && (edi_sts_cd.equals("AOL")))
			          {
			        	  	snd_rslt_edi_sts = "OB";
							snd_rslt_cust_edi_sts = "AV";
							// OB 일때 OB 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount > 0){
								snd_rslt_edi_sts = "UVD";
								snd_rslt_cust_edi_sts = "A";
								// OB 일때 UVD 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.(OB+UVD = AVL일때)
								sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
								if(sndRsltCount == 0){
									sndRsltCount = this.dbDao.searchGapEdiSndRult(edi_grp_cd, cntr_no, bkg_no);
						            if (sndRsltCount == 0) {
						            	this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의  OB 일때 URN 가 발송이 안되었으면 AOL 발송안함.");
						            	rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의  OB 일때 URN 가 발송이 안되었으면 AOL 발송안함.";
						            	rslt_flag = "F";
						            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						            	return result_boolean = false;
						            }
						            snd_rslt_edi_sts = "AOL";
						            snd_rslt_cust_edi_sts = "AV";

						            sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						            if (sndRsltCount > 0) {
						            	this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.");
						            	rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.";
						            	rslt_flag = "F";
						            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						            	return result_boolean = false;
						            }
								}else{
									snd_rslt_edi_sts = "AOL";
						            snd_rslt_cust_edi_sts = "AV";

						            sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
						            if (sndRsltCount > 0) {
						            	this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.");
						            	rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 URN 일때 OB 가 발송이 안되었으면 AOL 발송안함.";
						            	rslt_flag = "F";
						            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						            	return result_boolean = false;
						            }
								}
								
							}else{
								log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 OB 일때 URN+OB 가 발송이 안되었으면 AVL 발송안함.");
								rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 OB 일때 URN+OB 가 발송이 안되었으면 AVL 발송안함.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
			            

			          }

			          if ((org_edi_sts_cd.equals("UVD")) && (edi_sts_cd.equals("AOL"))) {
			        	  snd_rslt_edi_sts = "UVD";
							snd_rslt_cust_edi_sts = "A";
							// UVD 일때 UVD 가 SCE_EDI_SND_RSLT 에 있는지 확인한다.
							sndRsltCount = dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
							if(sndRsltCount > 0){
								snd_rslt_edi_sts = "AOL";
					            snd_rslt_cust_edi_sts = "AV";

					            sndRsltCount = this.dbDao.isdirfirstView(edi_grp_cd, snd_rslt_edi_sts, snd_rslt_cust_edi_sts, cntr_no, bkg_no);
					            if (sndRsltCount > 0) {
					            	this.log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 UVD 일때 AOL 가 발송이 안되었으면 AOL 발송안함.");
					            	rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 UVD 일때 AOL 가 발송이 안되었으면 AOL 발송안함.";
					            	rslt_flag = "F";
					            	modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					            	return result_boolean = false;
					            }else{
					            	currVo.setCurrEventDt(this.dbDao.searchGapAvEventDt(sendVo.getEventDt()));
					            }				            
							}else{
								log.info("\n COM02200, COM02353(Expeditors(GAP)/Non USA) 의 UVD 일때 UVD+OB 가 발송이 안되었으면 AVL 발송안함.");
								rslt_remark = "COM02200, COM02353(Expeditors(GAP)/Non USA) 의 OB 일때 UVD+OB 가 발송이 안되었으면 AVL 발송안함.";
								rslt_flag = "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
			          }

			     }
			}
		        
			
			
			if(!"Y".equalsIgnoreCase(sendVo.getManFlg()) && (
				"AVN".equals(edi_sts_cd)||
				"AON".equals(edi_sts_cd)||
				"AFN".equals(edi_sts_cd)||
				"ACN".equals(edi_sts_cd)||
				
				"AVL".equals(edi_sts_cd)||
				"AOL".equals(edi_sts_cd)||
				"AFL".equals(edi_sts_cd)||
				"ACL".equals(edi_sts_cd))){
				
				int chk_ams = 0;
				// 2011.03.22 김진승 [CHM-201109254-01] USA00214 (NIKE)의 경우 AON에 대해  OAN의 EVENT DATE 적용 요청 처리 ;
				// 2013.10.30 권상준 [CHM-201327177] Nike Canada EDI event 관련 로직 보완 요청 (OAN, VAD 관련)
				
				if ( ("AOL".equals(edi_sts_cd) && "USA00214".equals(edi_grp_cd)) || ("AVL".equals(edi_sts_cd) && "COM02201".equals(edi_grp_cd)) || ("AVL".equals(edi_sts_cd) && "COM02354".equals(edi_grp_cd)) || ("AOL".equals(edi_sts_cd) && "COM02200".equals(edi_grp_cd))|| ("AOL".equals(edi_sts_cd) && "COM02353".equals(edi_grp_cd)) ) { 
					log.info("USA00214 EdiGrpCd & AON EdiStsCd Case ... ");
					log.info("cop_rail_chk_cd =================> "+cop_rail_chk_cd);
					log.info("substr(cop_rail_chk_cd, 1, 2) =================> "+substr(cop_rail_chk_cd, 1, 2));
					
					if("AOL".equals(edi_sts_cd) && "USA00214".equals(edi_grp_cd) && "X".equals(nvl(substr(cop_rail_chk_cd, 1, 2),""))){
											
						chk_ams = getIbTruckSoCnt(sendVo.getCopNo());
						
						if(chk_ams<1){
							rslt_remark = "Nike Canada Not I/B Truck S/O";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}else if ("AOL".equals(edi_sts_cd) && "USA00214".equals(edi_grp_cd) && "I".equals(nvl(substr(cop_rail_chk_cd, 1, 2),""))){
						rslt_remark = "Nike Canada I/B Rail S/O";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
					
				} else {					
					
					chk_ams = getPreSentCnt(dtlVo);
					
					if(chk_ams<1){
						rslt_remark = "SCE_EDI_MNG_AMS_STS 조건 불 일치";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
					
					// * 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완 
					// 1. 전송 시도하는 BKG/ CNTR, 동일 edi_grp_cd 로 AVN / AVM 이 기 발생된 내역이 존재하고
					// 2. BKG_NO, CNTR_NO 에 해당하는 COP 가 이미 COP_STS_CD = 'F' 일 경우 또는 BKG_NO, CNTR_NO 로 BKG_CONTAINER 를 조회하여 CNMV_STS_CD = ID or MT 일 경우
					// 위 두 요건을 만족할 때 로그 남기고 발송 skip
					if ( "AVN".equals(edi_sts_cd) ){
						int chk_avn = getAVNValidationCount(dtlVo); // 1 이면 skip, 0이면 send
						if(chk_avn>0){
							rslt_remark = "기 전송 내역 존재로 return";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					} 
				}
			}
			
			// 2013.10.30 권상준 [CHM-201327177] Nike Canada EDI event 관련 로직 보완 요청 (OAN, VAD 관련)(Manual 전송일때로 로직 적용)
			if("Y".equalsIgnoreCase(sendVo.getManFlg())){
				if("AOL".equals(edi_sts_cd) && "USA00214".equals(edi_grp_cd) && "X".equals(nvl(substr(cop_rail_chk_cd, 1, 2),""))){
					
					int chk_aol = 0;
					chk_aol = getIbTruckSoCnt(sendVo.getCopNo());
					
					if(chk_aol<1){
						rslt_remark = "Nike Canada Not I/B Truck S/O";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}else if ("AOL".equals(edi_sts_cd) && "USA00214".equals(edi_grp_cd) && "I".equals(nvl(substr(cop_rail_chk_cd, 1, 2),""))){
					rslt_remark = "Nike Canada I/B Rail S/O";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}
			
			// 2013.04.09 [CHM-201323944] [GTN 315] Ceva- Microsoft AD 발송 시점 변경 요청(AV 발생 시 AD도 발송, (단, Event Date는 AV + 72시간으로 기존 유지))
			// AV가 전송이 된 경우에만 AD가 발송이 되도록 체크한다.
			// 2014.05.14 [CHM-201430160] [CEVA  Microsoft] COM02677 그룹코드 추가
			if("AD".equals(edi_sts_cd) && ("COM02357".equals(dtlVo.getEdiGrpCd()) || "COM02677".equals(dtlVo.getEdiGrpCd())) && !"Y".equals(sendVo.getManFlg())){
				
				int chk_av = 0;				
				chk_av = getPreSentAvCnt(dtlVo);				
				if(chk_av<1){
					rslt_remark = "AV 미발송으로 인해 AD 발송안함.";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}
				
			
			// 2011.04.15~19 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리.. 수정
			if("VAD".equals(edi_sts_cd) && "USA00094".equals(dtlVo.getEdiGrpCd())){
				
				/// check logic 
				HashMap hashMap = edi315SendForUSA00094VAMissed(sendVo, dtlVo, currVo);
				if ( hashMap==null){
					result_boolean = false;
					rslt_remark = "기 전송 내역 존재로 return";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				}
				hashMap = null;
				return result_boolean;
			}
			
			/*
			 * 2011.04.22 황효근 [CHM-201110046-01] [HP]315 단계 로직 추가
			 * 1) 기존 "OAN"은 Delivery Term이 "Y"인 경우, 고객코드 "OA"로 송신 
			 * 2) 신규 추가하는 "OAN"은 Delivery Term이 "D"인 경우, 고객코드 "AF"로 송신
			 */
			if("USA00462".equals(edi_grp_cd) && "OAN".equals(edi_sts_cd)) {
				if("Y".equals(dtlVo.getDeTermCd()) && !"OA".equals(cust_edi_sts_cd)) {
					result_boolean = false;
					rslt_remark = "USA00462 화주 OAN 발송 대상이 아님.(Delivery Term='Y'인 경우 CUST_EDI_STS_CD='OA'로 발송)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}
				
				/* 2011.04.25 황효근 [CHM-201110046-01] [HP]315 단계 로직 추가 - 수정
				 * Delivery Term "D"인 경우, "OAN" (고객코드: OA) 및 "OAN" (고객코드: AF) 전송 – 동일 데이터임.
				if("D".equals(dtlVo.getDeTermCd()) && !"AF".equals(cust_edi_sts_cd)) {
					result_boolean = false;
					rslt_remark = "USA00462 화주 OAN 발송 대상이 아님.(Delivery Term='D'인 경우 CUST_EDI_STS_CD='AF'로 발송)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}*/
			}
			
			/*
			 * 2011.05.30 채창호 [CHM-201111195-01] (Target) AG 로직 보완
			 * 1) USA00094 에 대하여  VDL 일때 VE 자동발송 되는 로직 미발송처리.
			 * 2) Manual 전송시에만 1)번 로직 처리할 수 있도록 수정.
			 */
			if("Y".equals(sendVo.getManFlg())){
				if("USA00094".equals(edi_grp_cd) && "VDL".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd) && "AG".equals(cust_edi_sts_cd)) {
					result_boolean = false;
					rslt_remark = "USA00094 에 대하여  VDL 일때 VE 자동발송 되는 로직 미발송 처리";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}
			}
			
			/*
			 * 2015.06.11 김민정 [CHM-201536193-01] VDL 발생시  VBE 자동 발송 개발 요청
			 * - Manual 전송 시에 COM02218 에 대하여  VDL 일때 VBE 자동발송 되는 로직 미발송처리.
			 */
			if("Y".equals(sendVo.getManFlg())){
				if("COM02218".equals(edi_grp_cd) && "VDL".equals(org_edi_sts_cd) && "VBE".equals(edi_sts_cd) && "AG".equals(cust_edi_sts_cd)) {
					result_boolean = false;
					rslt_remark = "COM02218 에 대하여  VDL 일때 VBE 자동발송 되는 로직 미발송 처리";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}
			}
			
			/*
			 * 2012.03.26 채창호[CHM-201216947]: APL/Emerson 315 OA status 설정요청
			 * USA00451 에 대하여 RLN 일때 OAN 자동발생일때  cust_edi_sts_cd가 D인경우  자동발송 되는 로직 미발송 처리
			 */
		
			if ("USA00451".equals(edi_grp_cd) && "UVD".equals(org_edi_sts_cd) && "OAN".equals(edi_sts_cd) && "D".equals(cust_edi_sts_cd) ) {
				result_boolean = false;
				rslt_remark = "USA00451 에 대하여 UVD 일때 OAN 자동발생일때  cust_edi_sts_cd가 D인경우  자동발송 되는 로직 미발송 처리";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean;
			}
			
				/* [CHM-201221208] ______________________________________________________________
	
				1. 대상 :  Customer  Group ID : USA00051, USA00462 
				2. 조건:  Delivery Term : D (Door) , DEL Country code : US, CA, MX
				3. 내용 Event : D status
				- 발송 시점 : ID Event 발생시 동일한 데이터를 D Status로 반영하여 전송함
			__________________________________________________________________________________ */
	
			if ( ("USA00051".equals(edi_grp_cd) || "USA00462".equals(edi_grp_cd)) && "OAN".equals(org_edi_sts_cd) && "D".equals(edi_sts_cd) )
			{	
				if	( 
						"D".equals(dtlVo.getDeTermCd()) 
						&& 
						!"USIND".equals(del_cd) // [CHM-201537747] 2015-09-09 DEL이 USIND일 경우에는 "D"자동 발송하는 로직 제거 
						&&
						( "US".equals(substr(del_cd, 0, 2)) || "CA".equals(substr(del_cd, 0, 2)) || "MX".equals(substr(del_cd, 0, 2)) )
						&&
						( sendVo.getMvmtSts() != null && "ID".equals(sendVo.getMvmtSts()) )
					)
				{
					aaa="";	
				}
				else
				{
					result_boolean = false;
					rslt_remark = "USA00051 에 대하여 OAN 일때 D 자동발생일때, Door Term && ID && DEL Country code : US, CA, MX 만 발송 ";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}
			}
			
			/*
			 * 2012.12.04  By SBKIM
			 *		1.대상 :  Customer  Group ID : USA00061 (LOWES) ,
			 *		2.조건: VE “ESTIMATED VESSEL ARRIVAL AT POD”  
			 *		3. 내용 Event : VE status 전송 안함
             *		- 발송 시점 : 메뉴얼 VDL 전송 시 VE가 자동전송 되지 않도록 수정
			*/
			
			if( "USA00061".equals(edi_grp_cd) && "VDL".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd) ) {
				result_boolean	=	false;
				rslt_remark		=	"USA00061 에 대하여  VDL 일때 VE 자동발송 되는 로직 미발송 처리";
				rslt_flag		=	"F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean;
			}
			
			// 2013.06.10 CHM-201324991 IKEA 315 로직 변경 요청(IKEA에 한해 VD 전송 시 VE 자동 전송 Logic Block 처리)
			if ("ASA00284".equals(edi_grp_cd) && "VE".equals(edi_sts_cd) && "VD".equals(org_edi_sts_cd.substring(0, 2)) ) {
				rslt_remark = "No Auto Send VE !!!";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return result_boolean = false;
			}
			
			// 2013.08.20 CHM-201325963 IKEA VE 전송 로직 보완 요청(COP Planned Time과 비교하여 날짜차이가 존재하지 않는 경우 전송이 되지 않도록 처리한다.)
			if ("ASA00284".equals(edi_grp_cd) && "VE".equals(edi_sts_cd) && "VE".equals(org_edi_sts_cd) ) {
				String stndEdiStsCd = "VAD";
				String vePlnDt = dbDao.searchCopPlanDate(bkg_no, cntr_no, stndEdiStsCd);
				if (substr(event_dt, 0, 8).equals(substr(vePlnDt, 0, 8))) {
					rslt_remark = "IKEA VE 발송 시엔 Plan Date의 YYYYMMDD 가 달라야 발송)";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}				
			}
			
			/*
			 * 2013.01.22  박찬민 [CHM-201322468] Ashely Furniture (Group ID: COM00781, USA00004, USA00281) 315  VDL Block 요청 (AEL 미 발생시)
			 *		1.대상 :  Customer  Group ID : USA00281
			 *		2.조건: VDL 발송시 AEL 미 발송  
			 *		3. 내용 Event : VDL status 전송 안함
			*/
			if(!"Y".equals(sendVo.getManFlg())&& "USA00281".equals(edi_grp_cd) && ("VDL".equals(edi_sts_cd)||"VDT".equals(edi_sts_cd))){
				if("VDL".equals(edi_sts_cd)){
					int sendRsltCount = dbDao.isdirfirstView(dtlVo.getEdiGrpCd(), "AEL", "AE", dtlVo.getCntrNo(), dtlVo.getBkgNo());
					if(sendRsltCount==0){
						result_boolean	=	false;
						rslt_remark		=	"USA00281 에 대하여  VDL 일때 AEL 미발송 되었을 경우 자동발송 되는 로직 미발송 처리";
						rslt_flag		=	"F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean;
					}
				}else if("VDT".equals(edi_sts_cd)){
						int sendRsltCount1 = dbDao.isdirfirstView(dtlVo.getEdiGrpCd(), "AET", "AE", dtlVo.getCntrNo(), dtlVo.getBkgNo());
						if(sendRsltCount1==0){
							result_boolean	=	false;
							rslt_remark		=	"USA00281 에 대하여  VDT 일때 AET 미발송 되었을 경우 자동발송 되는 로직 미발송 처리";
							rslt_flag		=	"F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean;
						}
				}
			}
			
			// 2014.03.17 [CHM-201429064] "D" event 자동 발송 로직 적용 요청
			// 1. 해당 Customer ID : EDI Group USA00462 : Spective (HP) 
			// 2. 조건 : Delivery Term : Door Term, DEL country : US 
			// 3. 요청 Event : "D" 
			//	- "OA" event time + 1 시간 으로 적용 
			//	- "OA" event 발송 시 같이 발송
			// USA00462 에 대하여  OAN 일때 D 전송시 Delivery Term : Door Term, DEL country : US 이 아니면 미발송 처리
			if("USA00462".equals(edi_grp_cd) && dtlVo.getDelCd() != null){
				if("OAN".equals(org_edi_sts_cd) && "D".equals(edi_sts_cd) && (!"D".equals(dtlVo.getDeTermCd()) || !"US".equals(dtlVo.getDelCd().substring(0,2)))){
					// USA00462 에 대하여  OAN 일때 D 전송시 Delivery Term : Door Term, DEL country : US 이 아니면 미발송 처리
					result_boolean	=	false;
					rslt_remark		=	"USA00462 에 대하여  OAN 일때 D 전송시 Delivery Term : Door Term, DEL country : US 이 아니면 미발송 처리";
					rslt_flag		=	"F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean;
				}
			}
			
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
		return true;
	}

	
	/**makingPreFix - key 로 prefix 를 전달하면 해당  list vo 에서 그에 맞는 값을 리턴함   
     * @param  List<AbstractValueObject> list
     * @param  String header
	 * @param  String footer  
	 * @param  String[] keyArray
     * @return String 
     */   	
    public String makingPreFix(List<AbstractValueObject> list,
    		                                           String header,
    		                                           String footer,
    		                                           String[] keyArray
    		                                           ){
    	AbstractValueObject mVo = null;
    	String mainStr = "";
		String strHeader = header;
		String strFooter = footer;
		String str = null;
		String[] keyArrayOriginal = null;
		
		if(header == null) strHeader = "";
		if(footer == null) strFooter = "";
		
		if(keyArray != null && keyArray.length >0){
			keyArrayOriginal = new String[keyArray.length];
            for(int n=0;n<keyArray.length;n++){
            	keyArrayOriginal[n] = keyArray[n];
            }
		}
    	if(list != null && list.size() >0) 
    	{
    		for(int j=0;j<list.size();j++){
		                //Initiating Arguments   		
		                for(int n=0;keyArray != null && n<keyArray.length;n++){
		                	keyArray[n] = keyArrayOriginal[n];
		                } 	
                mVo = (AbstractValueObject)(list.get(j));
            	HashMap<String,String> valueMap = mVo.getColumnValues();
    			if(str == null){
    				 str = machingPrefixWithVo(keyArray,valueMap);
    			     mainStr = strHeader + str + strFooter;
    			}else{
    				 mainStr = mainStr + strHeader + machingPrefixWithVo(keyArray,valueMap) + strFooter;
    			}
    		}
    	
    	}
    	
		return mainStr;
    } 
	/**machingPrefixWithVo - 주요목적은 첫번째 vo상에 필드명을 변경하여 스트링배열에 같은 값이 있으면 반환
	 *                     
     * @param String[] keyArray
     * @param HashMap valueMap
     * @return String 
     */     
    private String machingPrefixWithVo(String[] keyArray,HashMap valueMap){

    	  /*Creating New Map with New Key*/
		  HashMap<String,String> newMap = new HashMap<String,String>();
		  Set keyset = valueMap.keySet();
		  Iterator itr = keyset.iterator();
		  while(itr.hasNext()){
			  String key = (String)itr.next();
			  String newKey ="";
			  newKey = key.replace("_", "");
			  newMap.put(newKey, (String)valueMap.get(key));

		  }

    	StringBuffer tempStrBuff = new StringBuffer();
    	int alen = keyArray.length;
    	String[] keyArrayOriginal = new String[alen]; 
    	         keyArrayOriginal = keyArray.clone();
    	for(int i=0;i<keyArray.length;i++){
      	  if(keyArray[i] != null && !keyArray[i].equals("")){
   		   int n = keyArray[i].indexOf(":");/*removing : Note you should remove the first : in the key text 
   		                                      because value text may obtain the same character.
   		                                    */
	   		        if(" ".equals(keyArray[i].substring(n-1,n)))//The Case of prefix with " " in Main
	   		           keyArray[i] = keyArray[i].substring(0,n-1);
	   		        else                                        //The Case of prefix without " " in BkgVvd
	   		           keyArray[i] = keyArray[i].substring(0,n);
	   		  if(keyArray[i].indexOf(" ") >=0){ //removing white space
	   			 keyArray[i] = keyArray[i].replaceAll(" ","");// removing white space
	   		  }
	   		     keyArray[i] = keyArray[i].replace("_", ""); //removing _
   	     }
      	   keyArray[i] = keyArray[i].toLowerCase();

      	   tempStrBuff.append(keyArrayOriginal[i] + nvl(newMap.get(keyArray[i])) + CHR10);
    	}
    	return tempStrBuff.toString();
    }    


	/**sysDate - 오라클의 sysdate 함수와 똑같은 역활을 하는 함수 
     * @return String
     */     
    public String sysDate() {
		Date now = new Date();
		SimpleDateFormat dates = new SimpleDateFormat("yyyyMMddHHmmss");
		return dates.format(now);
	}
    /**sysDate - 현재의 날짜를 구하는 함수 오라클의 함수와 비슷 인자로 포멧을 결정 가능.
	 * @param  String dFormat
     * @return String
     */ 
    public String sysDate(String dFormat){
        Date now = new Date();
        SimpleDateFormat dates = new SimpleDateFormat(dFormat); 
        return dates.format(now);
    }
    
	/**nvl - 오라클의  NVL 함수와 비슷한 역활을 하는 함수
	 *                  
     * @param  Object arg
     * @return Object
     */        
    private Object nvl(Object arg){
    	if(arg != null) return arg;
    	else return "";
    } 
	/**nvl - 오라클의  NVL 함수와 비슷한 역활이지만 널 일 경우 인자로 준 값으로 반환
	 *       Simply, this function is substitute for Oracle function of NVL.              
     * @param  Object arg
     * @param  Object padding
     * @return Object
     * @throws 
     */     
    private Object nvl(Object arg,Object padding){
    	if(arg != null) {
    		return arg;
    	}else{
    		return padding;
    	}
    }
	/**rpad -  오라클의 함수 rpad 와 비슷한 역활을 하는 함수  
     * @param  String oStr
     * @param  int len
     * @param  String padding
     * @return String
     */       
    private String rpad(String oStr,int len,String padding){
    	StringBuffer strBuff = null;
    	if(oStr != null){
    		if(oStr.length() > len){
    			        return oStr; 
    		}else{
		    			
		    			for(int i=0;i<len;i++){
		    				strBuff = new StringBuffer(oStr);
		    				strBuff.append(padding);
		    				oStr = strBuff.toString();
		    				if(oStr.length() == len) break;
		    				else if(oStr.length() > len) oStr = oStr.substring(0, len);
		    				else continue;
		    			}
		    			return oStr;
    		}
    	}
    	return "";
    }  
	/**rpad -  오라클의 함수 lpad 와 비슷한 역활을 하는 함수  
     * @param  String oStr
     * @param  int len
     * @param  String padding
     * @return String
     */ 
    private String lpad(String oStr,int len,String padding){
    	StringBuffer strBuff = null;
        if(oStr != null){
        	if(oStr.length() == len){
        		return oStr;
        	}else if(oStr.length() > len){
        		return oStr.substring(0,len);
        	}else{
        		  int diff = len - oStr.length();
        		  strBuff = new StringBuffer();
        		  for(int m=0;m<diff;m++){
        			  strBuff.append(padding);
        		  }
        		  strBuff.append(oStr);
        		  return strBuff.toString();
        	}
        }
    	return "";
    }      
	
	/**SUBSTR -  이 함수의 역활은 오라클의  SUBSTR 처리와 같은 기능을 한다. 
     * @param    String str
     * @param    int start
     * @param    int end
     * @return   String
     */        
    private String substr(String str,int start, int end){
		if(str != null && str.length() >= (end - start)){
			return str.substring(start,end);
		}else{
			return "";
		}
	}  
	
	/**searchNodInformation -  searchNodInformation 의 래퍼함수
     * @param    String event_yard
     * @return   HashMap<String,String>
     * @throws   EventException
     */      
    private HashMap<String,String> searchNodInformation(String event_yard)throws EventException{
		try {
			  DBRowSet rowset = dbDao.searchNodInformation(event_yard);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  //EVENT_LOC_NAME  EVENT_LOC_AMSQUAL  EVENT_LOC_AMSPORT  REG_CD
				  keys_values.put("EVENT_LOC_NAME"     ,rowset.getString("EVENT_LOC_NAME"     ));
				  keys_values.put("EVENT_LOC_AMSQUAL",rowset.getString("EVENT_LOC_AMSQUAL"));
				  keys_values.put("EVENT_LOC_AMSPORT" ,rowset.getString("EVENT_LOC_AMSPORT" ));				  
				  keys_values.put("REG_CD" ,rowset.getString("REG_CD" ));				  
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }
	  }
    
	/**searchNodInformation2 -  searchNodInformation2 의 래퍼함수
     * @param    String event_yard
     * @return   HashMap<String,String>
     * @throws   EventException
     */      
    private HashMap<String,String> searchNodInformation2(String event_yard)throws EventException{
		try {
			  DBRowSet rowset = dbDao.searchNodInformation2(event_yard);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("EVENT_YD_NAME"     ,rowset.getString("EVENT_YD_NAME"     ));			  
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }
	  }
     
     /**searchPonsealInformation -  searchPonsealInformation 함수의 래퍼함수
      * @param    String bkg_no
      * @param    String cntr_no
      * @return   HashMap<String,String>
      * @throws   EventException
      */       
    private HashMap<String,String> searchPonsealInformation(String bkg_no, String cntr_no) throws EventException{
 		try {
			  DBRowSet rowset = dbDao.searchPonsealInformation(bkg_no,cntr_no);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  //CNTR_PO_NBR  CNMV_SEAL_NO
				  keys_values.put("CNTR_PO_NBR" ,rowset.getString("CNTR_PO_NBR" ));
				  keys_values.put("CNMV_SEAL_NO",rowset.getString("CNMV_SEAL_NO"));
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }   	  
     }
     /**getBkgTerm 
      * Booking Term 정보를 가져온다. 
      * @param    String bkg_no
      * @return   HashMap<String,String>
      * @throws   EventException
      */            
    private HashMap<String,String> getBkgTerm(String bkg_no) throws EventException{
  		try {
			  DBRowSet rowset = dbDao.getBkgTerm(bkg_no);
		      HashMap<String,String> keys_values = new HashMap<String,String>();
		      if(rowset != null && rowset.next()){
				  keys_values.put("RD_TERM"     ,rowset.getString("RD_TERM"     ));
				  keys_values.put("SC_NO"       ,rowset.getString("SC_NO"       ));
				  keys_values.put("SLAN_CD"     ,rowset.getString("SLAN_CD"     ));
				  keys_values.put("VSL_SLAN_NM" ,rowset.getString("VSL_SLAN_NM" ));	
				  keys_values.put("PANTO_CRE_DT",rowset.getString("PANTO_CRE_DT"));	  
			   }
				  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     } 
      }
     	
     	/**getCustRefNo
       * @param    String bkg_no
       * @return   String
       * @throws   EventException
       */       
    private String getCustRefNo(String bkg_no)throws EventException{
       try {
 			   String custRefNoCtnt = dbDao.getCustRefNo(bkg_no);
 			   return custRefNoCtnt;
 		} catch (DAOException e) {
 				throw new EventException(e.getMessage(),e);
 	     }     	  
      }
      

  	/**
  	 * getCnmv322Rail
  	 * NT Status에 해당 하는 node Code. (sce_cop_dtl.act_cd = FIRRAD )
  	 * @param String cop_no
  	 * @return String
  	 * @throws EventException
  	 */
    private String getCnmv322Rail(String cop_no)throws EventException{
          try {
    			   String nt_loc_cd = dbDao.getCnmv322Rail(cop_no);
    			   return nt_loc_cd;
    		} catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    	     }     	  
         }
	/**
	 * getEventDtGmt
	 * 
	 * @param Edi315SendVO sendVo
	 * @return String
	 * @throws EventException
	 */
    private String getEventDtGmt(Edi315SendVO sendVo) throws EventException {
		try {
			String eventDtGmt = dbDao.getEventDtGmt(sendVo);
			return eventDtGmt;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
   	  /**getShipperRefno
       * @param    String bkg_no
       * @return   String
       * @throws   EventException
       */       
    private String getShipperRefno(String bkg_no)throws EventException{
  	     try {
			   String shRefNbr = dbDao.getShipperRefno(bkg_no);
			   return shRefNbr;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     }     	  
      }
   	  /**getForwardRefno
       * @param    String bkg_no
       * @return   String
       * @throws   EventException
       */ 
    private String getForwardRefno(String bkg_no)throws EventException{
        try {
  			     String fwRefNbr = dbDao.getForwardRefno(bkg_no);
  			     return fwRefNbr;
  		 } catch (DAOException e) {
  				throw new EventException(e.getMessage(),e);
  	     }     	  
      }

   	  /**getLocPodEta
       * @param    String cop_no
       * @return   String
       * @throws   EventException
       */          
    private String getLocPodEta(String cop_no)throws EventException{
          try {
    			     String temp = dbDao.getLocPodEta(cop_no);
    			     return temp;
    		 } catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    	     }     	  
        }
   	  /**getCustEDate
   	   * 
   	   * 'USA00285'이 화주 일 경우
       *   a> Local shipment 경우 'CUST_EDATE' 항목에 Local_shipment_POD||POD ETA(FUWMAD, FUVMAD) 값 입력
       *   b> Rail shipment  경우 'CUST_EDATE' 항목에 Rail shipment_Location||Final Rail ETA(FIRRAD) 값 입력
       * @param    String edi_grp_cd        
       * @param    String cop_rail_chk_cd  
       * @param    String cop_no           
       * @param    String pod_cd           
       * @return   String
       * @throws   EventException
       */       
    private String getCustEDate(String edi_grp_cd,
    		                     String cop_rail_chk_cd,
    		                     String cop_no,
    		                     String pod_cd) throws EventException{
       String cust_edate = "";
   	   if("USA00285".equals(edi_grp_cd)){
   		   if("X".equals((String)nvl(substr(cop_rail_chk_cd, 1, 2)," "))){
   			        String localPodEta = getLocPodEta(cop_no);
   			               cust_edate  = pod_cd + "/" + localPodEta;
   		   }else if("I".equals((String)nvl(substr(cop_rail_chk_cd, 1, 2)," "))){
   			   //railFinalEta, finalCd
   			   List<String> values = getRailPodEta(cop_no);
   			   String railFinalEta = values.get(0);
   			   String finalCd      = values.get(1);
   			          cust_edate   = finalCd + "/" + railFinalEta;
   		   }
   	   }
   	   return cust_edate;   
      }
   	  /**getRailPodEta
       * @param    String cop_no 
       * @return   List<String>
       * @throws   EventException
       */        
    private List<String> getRailPodEta(String cop_no) throws EventException{
          try {
        	   DBRowSet rowset = dbDao.getRailPodEta(cop_no);
			   List<String> values = new ArrayList<String>();
			   if(rowset != null && rowset.next()){
				  //custAdate  custAdateGmt  IT_NO_TEMP
				  values.add(rowset.getString(1));
				  values.add(rowset.getString(2));	
				  
			   }
			  return values;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	       } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	       }
      }

   	  /**getRsltPickNoInfo
       * @param    String edi_grp_cd 
       * @param    String cntr_no    
       * @param    String bkg_no     
       * @return   String
       * @throws   EventException
       */         
    private String getRsltPickNoInfo(String edi_grp_cd, 
    		                          String cntr_no,
    		                          String bkg_no
    		                          ) throws EventException{
          try {
       	       String pkupEdi322No = dbDao.getRsltPickNoInfo(edi_grp_cd,cntr_no,bkg_no);
			   return pkupEdi322No;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   }    	  
      } 
   	  /**searchPickupNumInformation
       * @param    String cntr_no    
       * @param    String bkg_no     
       * @return   String
       * @throws   EventException
       */       
    private String searchPickupNumInformation(String cntr_no,
    		                                   String bkg_no 
    		                                   ) throws EventException{
          try {
      	       String pkupNo = dbDao.searchPickupNumInformation(cntr_no,bkg_no);
			   return pkupNo;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   }      
      }
   	  /**get322PickNoInfo
   	   * edi_322_msg.pkupEdi322No 를 가져 온다.
       * @param    String cntr_no   
       * @param    String event_dt  
       * @return   String
       * @throws   EventException
       */       
    private String get322PickNoInfo(String cntr_no ,
    		                         String event_dt) throws EventException{
          try {
     	       String pickNo = dbDao.get322PickNoInfo(cntr_no,event_dt);
			   return pickNo;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   }          	  
      }
   	  /**searchCuSts
   	   * CU Status가 발송 되었는지 확인 한다. 
       * @param  String edi_grp_cd 
       * @param  String cntr_no    
       * @param  String bkg_no     
       * @return   String
       * @throws   EventException
       */       
    private String searchCuSts(String edi_grp_cd , 
    		                    String cntr_no,
    		                    String bkg_no) throws EventException{
          try {
    	       String temp = dbDao.searchCuSts(edi_grp_cd,cntr_no,bkg_no);
			   return temp;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   }  
    	  
      }


   	  /**getPickUpNo
       * @param  String edi_grp_cd 
       * @param  String edi_sts    
       * @param  String cntr_no    
       * @param  String bkg_no     
       * @param  String event_dt   
       * @return String
       * @throws EventException
       */      

    private String getPickUpNo(String edi_grp_cd, 
    		                    String edi_sts,
    		                    String cntr_no,
    		                    String bkg_no,
    		                    String event_dt
    		                    ) throws EventException{
		  String pickup_no    = "";
		  String cu_snd_chk   = "";
//    	  String[] astr = new String[]{
//    	          "USA00132", "USA00134", "USA00219",
//                  "USA00220", "USA00221", "USA00222",
//                  "USA00231", "USA00232", "USA00233",
//                  "USA00234", "USA00235", "USA00236",
//                  "USA00237", "USA00238", "USA00239",
//                  "USA00240", "USA00241", "USA00242",
//                  "USA00243", "USA00244", "USA00245",
//                  "USA00246", "COM01122", "USA00226"
//    	  };

/* 아래 화주 별 max(CRE_DT) SC_EFF_ST_DT SC_EFF_END_DT
 * USA00135	2009/05/30 00:52:17 20080610	20090630
 * USA00136	2008/06/07 00:13:04 20070501	20080430
 * USA00180	2009/06/15 21:36:17 null		null
 * */

    	  if( //(inEquation(edi_grp_cd,astr) && "AVN".equals(edi_sts))
    			  (("USA00135".equals(edi_grp_cd)||
    			    "USA00136".equals(edi_grp_cd)||
    			    "USA00180".equals(edi_grp_cd)) && "AVL".equals(edi_sts))
    		||
    			  (("USA00132".equals(edi_grp_cd)||"USA00134".equals(edi_grp_cd)||
    			    "USA00219".equals(edi_grp_cd)||"USA00220".equals(edi_grp_cd)||
    			    "USA00221".equals(edi_grp_cd)||"USA00222".equals(edi_grp_cd)||
    			    "USA00231".equals(edi_grp_cd)||"USA00232".equals(edi_grp_cd)||
    			    "USA00233".equals(edi_grp_cd)||"USA00234".equals(edi_grp_cd)||
    			    "USA00235".equals(edi_grp_cd)||"USA00236".equals(edi_grp_cd)||
    			    "USA00237".equals(edi_grp_cd)||"USA00238".equals(edi_grp_cd)||
    			    "USA00239".equals(edi_grp_cd)||"USA00240".equals(edi_grp_cd)||
    			    "USA00241".equals(edi_grp_cd)||"USA00242".equals(edi_grp_cd)||
    			    "USA00243".equals(edi_grp_cd)||"USA00244".equals(edi_grp_cd)||
    			    "USA00245".equals(edi_grp_cd)||"USA00246".equals(edi_grp_cd)||
    			    "COM01122".equals(edi_grp_cd)||
    			    "USA00226".equals(edi_grp_cd)||"USA00130".equals(edi_grp_cd)||
    			    "COM03084".equals(edi_grp_cd)
    			    ) && "AVN".equals(edi_sts))){
    		  //sce_edi_snd_rslt.pkupEdi322No
    		  pickup_no = getRsltPickNoInfo(edi_grp_cd, cntr_no, bkg_no);
    		  if (pickup_no == null || "".equals(pickup_no)) {
    			  // trs_trsp_so_pkup_cntr.pkupNo
    			  pickup_no = searchPickupNumInformation(cntr_no, bkg_no);
    		  }
		}
    	  
    	  if(("ALN".equals(edi_sts)||
    		  "RLN".equals(edi_sts)||
    		  "ARN".equals(edi_sts)||
    		  "NT".equals(edi_sts))&&"USA00060".equals(edi_grp_cd)){
    		  
    		  //edi_322_msg.pkupEdi322No
    		  pickup_no = get322PickNoInfo(cntr_no, event_dt);

    		  if(pickup_no == null || "".equals(pickup_no)) {
    			  log.info("\n trs_trsp_so_pkup_cntr.pkupNo");
    			  //trs_trsp_so_pkup_cntr.pkupNo
    			  pickup_no = searchPickupNumInformation(cntr_no,bkg_no);
    		  }    			  
		  }
    	  log.info("\n trs_trsp_so_pkup_cntr.pkupNo pickup_no : "+pickup_no);
    	  if (("ALN".equals(edi_sts)||
        	   "ARN".equals(edi_sts)||
        	   "FITRDO".equals(edi_sts))&&"USA00226".equals(edi_grp_cd)) {
    		    //33. standard sts 'CU'가 전송 되었는지 확인 
				cu_snd_chk = searchCuSts(edi_grp_cd, cntr_no, bkg_no);

				if ("Y".equals(cu_snd_chk)) {
					//edi_322_msg.pkupEdi322No
					pickup_no = get322PickNoInfo(cntr_no, event_dt);

					if (pickup_no == null || "".equals(pickup_no)) {
						//trs_trsp_so_pkup_cntr.pkupNo
						pickup_no = searchPickupNumInformation(cntr_no,bkg_no);
					}
					
				}
			}
    	  

    	  return pickup_no;
      }
   	  /**inEquation - 이 함수의 목적은 오라클 함수의 IN 의 구문과 비슷하다. 해당 배열에 해당 문자열이 하나라도 있다면 True 리턴 
       * @param  String str
       * @param  String[] astr
       * @return boolean
       */        
//    private boolean inEquation(String str, String[] astr){
//    	  for(int i=0;i<astr.length;i++){
//    		  if(str != null && str.equals(astr[i])) return true;
//    	  }
//    	  return false;
//      }
  	  /**searchCnmv322RailInfo
       * @param  String cop_no 
       * @param  String edi_grp_cd 
       * @return HashMap<String,String>
       * @throws EventException
       */       
    private HashMap<String,String> searchCnmv322RailInfo(String cop_no,String edi_grp_cd) throws EventException{
          try {
        	  log.info("\n searchCnmv322RailInfo : " + cop_no + edi_grp_cd);
        	  
        	  HashMap<String,String> keys_values = new HashMap<String,String>();
        	  if("USA00061".equals(edi_grp_cd)){
        		  DBRowSet rowset = dbDao.searchCnmv322RailInfo(cop_no,edi_grp_cd);
				  
				  if(rowset != null && rowset.next()){
					  //W_UNIT WEIGHT MEA_UNIT MEA_QTY P_UNIT PACKAGE BL_STORE_NBR 
					  keys_values.put("FRD_NAME"      ,rowset.getString("FRD_NAME"  ));
					  keys_values.put("FRD_CODE"      ,rowset.getString("FRD_CODE"  ));
					  keys_values.put("FRDETA"        ,rowset.getString("FRDETA"    ));
					  keys_values.put("FRDETA_GMT"    ,rowset.getString("FRDETA_GMT"));
				  }else{
					  keys_values.put("FRD_NAME"      ,"");
					  keys_values.put("FRD_CODE"      ,"");
					  keys_values.put("FRDETA"        ,"");
					  keys_values.put("FRDETA_GMT"    ,"");
				  }
        	  }else{
        		  keys_values.put("FRD_NAME"      ,"");
				  keys_values.put("FRD_CODE"      ,"");
				  keys_values.put("FRDETA"        ,"");
				  keys_values.put("FRDETA_GMT"    ,"");	        	 
        	  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }
      }
      
      
   	  /**
	 * searchBkgqtyInformation - 주어진 인자를 가지고 BkgQty Information에 해당하는 값을 리턴
	 * 
	 * @param  String bkg_no
	 * @return HashMap<String,String>
	 * @throws EventException
	 */       
    private HashMap<String,String> searchBkgqtyInformation(String bkg_no) throws EventException{
          try {
        	  log.info("BKG_NO : " + bkg_no);
        	  DBRowSet rowset = dbDao.searchBkgqtyInformation(bkg_no);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  //W_UNIT WEIGHT MEA_UNIT MEA_QTY P_UNIT PACKAGE BL_STORE_NBR 
				  keys_values.put("W_UNIT"      ,rowset.getString("W_UNIT"      ));
				  keys_values.put("WEIGHT"      ,rowset.getString("WEIGHT"      ));
				  keys_values.put("MEA_UNIT"    ,rowset.getString("MEA_UNIT"    ));
				  keys_values.put("MEA_QTY"     ,rowset.getString("MEA_QTY"     ));
				  keys_values.put("P_UNIT"      ,rowset.getString("P_UNIT"      ));
				  keys_values.put("PACKAGE"     ,rowset.getString("PACKAGE"     ));
				  keys_values.put("BL_STORE_NBR",rowset.getString("BL_STORE_NBR"));
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }
      }
   	  /**getBkgPoNo
   	   * bkg_reference.custRefNoCtnt
   	   *    
       * @param  String bkg_no 
       * @return String
       * @throws EventException
       */         
    private String getBkgPoNo(String bkg_no) throws EventException {
		try {
			String custRefNoCtnt = dbDao.getBkgPoNo(bkg_no);
			return custRefNoCtnt;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
 	  /**getItemPoNo
 	   * bkg_ref_dtl.po_no
 	   *    
     * @param  String bkg_no 
     * @return String
     * @throws EventException
     */         
    private String[] getItemPoNo(String bkg_no, String cntr_no) throws EventException {
		try {
			String[] itemPoNo = dbDao.getItemPoNo(bkg_no, cntr_no);
			return itemPoNo;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
   	  /**
   	   * Reserved 경우에 Event Date를 조정 한다. 
       * @param  String event_dt
       * @param  String edi_snd_itval_hr
       * @return String
       * @throws EventException
       */ 
    private String getReservedEventDt(String event_dt, String edi_snd_itval_hr) throws EventException{
          try {
			   return dbDao.getReservedEventDt(event_dt,edi_snd_itval_hr);
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
      }
    
 	  /**
 	   * Reserved 경우에 Event Date를 조정 한다. 
     * @param  String event_dt
     * @param  String edi_snd_itval_hr
     * @return String
     * @throws EventException
     */ 
  private String getReservedEventDtMin(String event_dt, String edi_snd_itval_hr) throws EventException{
        try {
			   return dbDao.getReservedEventDtMin(event_dt,edi_snd_itval_hr);
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
    }
    
 	  /**
 	   * 
     * @param  String cntr_no
     * @param  String bkg_no
     * @param  String edi_tp
     * @return String
     * @throws EventException
     */ 
  private String getEventDtForTRT(String delay_t, String edi_grp_cd, String edi_tp, String edi_sub_sts_cd, String cntr_no, String bkg_no) throws EventException{
	  		try{
			   return dbDao.getEventDtForTRT(delay_t, edi_grp_cd, edi_tp, edi_sub_sts_cd, cntr_no, bkg_no);
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
    }
    
 	  /**
 	   * Reserved 경우에 Send Date를 조정 한다. 
     * @param  String edi_snd_itval_hr
     * @return String
     * @throws EventException
     */ 
  private String getReservedSendDt(String edi_snd_itval_hr) throws EventException{
        try {
			   return dbDao.getReservedSendDt(edi_snd_itval_hr);
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
    }
  
		  /**
		   * Reserved 경우에 Send Date를 조정 한다. 
	 * @param  String edi_snd_itval_hr
	 * @return String
	 * @throws EventException
	 */ 
	private String getReservedSendDtMin(String edi_snd_itval_hr) throws EventException{
	    try {
			   return dbDao.getReservedSendDtMin(edi_snd_itval_hr);
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
	}
  
/**
 * Reserved 경우에 Event Date를 조정 한다. VE Case 
 * @param   String edi_group_cd 
 * @param   String edi_sts 
 * @param   String cust_edi_sts
 * @param   String cntr_no 
 * @param   String bkg_no 
 * @return String
 * @throws EventException
 */ 
private String getReservedSendDtForVe(String edi_group_cd, String edi_sts, String cust_edi_sts, String cntr_no, String bkg_no) throws EventException{
    try {
		   return dbDao.getReservedSendDtForVE(edi_group_cd, edi_sts, cust_edi_sts, cntr_no, bkg_no);
	   } catch (DAOException e) {
			throw new EventException(e.getMessage(),e);
	   } 
}

   	  /**getSonyInvNo
       * @param  String bkg_no 
       * @return String
       * @throws EventException
       */        
    private String getSonyInvNo(String bkg_no) throws EventException{
          try {
   	           String custRefNoCtnt = dbDao.getSonyInvNo(bkg_no);
			   return custRefNoCtnt;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
      }
    
 	  /**getCntrTareWeight
       * @param  String cntr_no 
       * @return String
       * @throws EventException
       */        
    private String getCntrTareWeight(String cntr_no) throws EventException{
        try {
 	           String custRefNoCtnt = dbDao.getCntrTareWeight(cntr_no);
			   return custRefNoCtnt;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
    }
//   	  /**getOnBoardDt
//       * @param  String bkg_no 
//       * @return String
//       * @throws EventException
//       */      
//      public String getOnBoardDt(String bkg_no) throws EventException{
//          try {
//  	           String pantosBlObrdDt = dbDao.getOnBoardDt(bkg_no);
//			   return pantosBlObrdDt;
//		   } catch (DAOException e) {
//				throw new EventException(e.getMessage(),e);
//		   } 
//      }
   	  /**getWallPoNbr
       * @param  String bkg_no 
       * @param  String cntr_no 
       * @return List<String>
       * @throws EventException
       */       
    private List<String> getWallPoNbr(String bkg_no,String cntr_no) throws EventException{
          try {
 	            List   wal_po_nbrs  = dbDao.getWallPoNbr(bkg_no,cntr_no);
			    return wal_po_nbrs;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
      }

    /**GetCgoRlsHubLoc
 	 * US AMS:B/L Inquiry의 HUB Loc CD를 조회한다.
     * @param  String bl_no
     * @return List<String>
     * @throws EventException
     */       
  private String getCgoRlsHubLoc(String bl_no, String event_yard) throws EventException{
        try {
			DBRowSet rowset = dbDao.getCgoRlsHubLoc(bl_no, event_yard);
			String hubLocCd = null;
			
			if(rowset != null && rowset.next()){
				hubLocCd = rowset.getString("HUB_LOC_CD");
		    }
			return hubLocCd;
		} catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
  
  /**GetCopActCd
   * US AMS:B/L Inquiry의 HUB Loc CD를 조회한다.
   * @param  String bl_no
   * @return List<String>
   * @throws EventException
   */       
  private String getCopActCd(String cop_no, String cop_dtl_seq) throws EventException{
      try {
			DBRowSet rowset = dbDao.getCopActCd(cop_no, cop_dtl_seq);
			String actCd = null;
			
			if(rowset != null && rowset.next()){
				actCd = rowset.getString("ACT_CD");
		    }
			return actCd;
		} catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
		}
  }
    
   	  /**getBkgEDIHPRef
   	   * HP 화주의 경우 SHIPPER ID 부분포함 하여 Flat File 생성 한다. 
       * @param  String bkg_no
       * @return List<String>
       * @throws EventException
       */       
    private List<String> getBkgEDIHPRef(String bkg_no) throws EventException{
          try {
			DBRowSet rowset = dbDao.getBkgEDIHPRef(bkg_no);
			List<String> values = new ArrayList<String>();
			
			while (rowset != null && rowset.next()) {
				values.add(rowset.getString("HP_REF"));
			}
			return values;
		} catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
		}
      }
   	  /**getCustAdateNewVersion   
   	   * 미주의 경우에만 BKG_CGO_RLSE.CSTMS_CLR_LST_DT 정보를 내려 준다.
   	   * 
   	   * as-is Logic : DECODE(EDI_USA_IB_CGO_RLSE.AMS_UPD_DT, NULL, EDI_USA_IB_CGO_RLSE.AMS_INS_DT, EDI_USA_IB_CGO_RLSE.AMS_UPD_DT) 
       * @param  String event_yard   
       * @param  String bl_no               
       * @return HashMap<String,String> 
       * @throws EventException
       */             
    private HashMap<String,String> getCustAdateNewVersion(String event_yard,String bl_no) throws EventException{
          try {
        	  DBRowSet rowset = dbDao.getCustAdateNewVersion(event_yard,bl_no);
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("CUST_ADATE"      ,rowset.getString("CUST_ADATE"    ));
				  keys_values.put("CUST_ADATE_GMT"  ,rowset.getString("CUST_ADATE_GMT"));
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     } 
      }
    
	/**
	   * getItNoTemp
	   * @param  String bl_no 
	   * @param  String curr_evnet_yd 
	   * @return String
	   * @throws EventException
	   */       
    private String getItNoTemp(String bl_no, String curr_evnet_yd) throws EventException{
          try {
 	           String itNoTemp = dbDao.getItNoTemp(bl_no, curr_evnet_yd);
			   return itNoTemp;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
      }
    
	/**
     * Get INBOND_NBR & INBOND_NBR_DT & IT_NBR_DT
     * @param  String bkg_no 
     * @return String[]
     * @throws EventException
     */       
	private String[] getInbondNbrDtItNbrDt(String bkg_no) throws EventException{
        try {
	           String[] result = dbDao.getInbondNbrDtItNbrDt(bkg_no);
			   return result;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
    }
    
   	  /**getFlagWithComparision - 주어진 인자 값으로 데이터베이스에서 특정 식의 결과를 추출하는 함수
       * @param  String argument1 
       * @param  String equation  
       * @param  String argument2        
       * @return String
       * @throws EventException
       */        
//    private String getFlagWithComparision(String argument1,String equation,String argument2) throws EventException{
//          try {
//	           String flag = dbDao.getFlagWithComparision(argument1,argument2,equation);
//			   return flag;
//		   } catch (DAOException e) {
//				throw new EventException(e.getMessage(),e);
//		   } 
//      }

   	 
   	  /**searchBkgLoc
       * @param  String bl_no 
       * @return HashMap<String,String>
       * @throws EventException
       */  
//    private HashMap<String,String> searchBkgLoc(String bl_no)throws EventException{
//          try {
//        	   DBRowSet rowset = dbDao.searchBkgLoc(bl_no);
//			   HashMap<String,String> keys_values = new HashMap<String,String>();
//			   if(rowset != null && rowset.next()){
//				  keys_values.put("EVENT_YD",rowset.getString("EVENT_YD"));
//				  keys_values.put("EVENT_DT",rowset.getString("EVENT_DT"));
//			   }
//			   log.info("\n searchBkgLoc \n"+keys_values);
//			   return keys_values;
//		   } catch (DAOException e) {
//				throw new EventException(e.getMessage(),e);
//	       } catch (Exception ex) {
//				throw new EventException(new ErrorHandler(ex).getMessage());
//	       }
//      }
      
      
      
      
      
      
      
      
   	  /**
   	   * SCE_EDI_HIS 테이블의 Key Return.
       * @return HashMap<String,String>
       * @throws EventException
       */       
    private HashMap<String,String> searchKeysForAddSceEdiHis() throws EventException{
          try {
       	       DBRowSet rowset = dbDao.searchKeysForAddSceEdiHis();
			   HashMap<String,String> keys_values = new HashMap<String,String>();
			   if(rowset != null && rowset.next()){ 
				  keys_values.put("RCV_DT" ,rowset.getString("RCV_DT"));
				  keys_values.put("RCV_SEQ",String.valueOf(rowset.getInt("RCV_SEQ")));
			   }
			   return keys_values;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	       } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	       }
      }
   
      
      


   	  /**get322PickupNo - 322PickupNo을 가지고 오는 함수의 래퍼함수
       * @param  String curr_event_dt
       * @param  String cntr_no
       * @return String
       * @throws EventException
       */  
    private String get322PickupNo(String curr_event_dt, String cntr_no) throws EventException {
		try {
			String seq = dbDao.get322PickupNo(curr_event_dt, cntr_no);
			return seq;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	} 
   	  /**getVipSndCount - VipSndCount 의 갯수를 가지고 오는 함수의 래퍼함수
       * @param  String edi_grp_cd
       * @param  String edi_sts
       * @param  String cust_edi_sts_cd
       * @param  String bkg_no
       * @param  String cntr_no
       * @param  String po_nbr
       * @return int
       * @throws EventException
       */        
    private String getVipSndCount(    
				    		    String edi_grp_cd,
				    		    String edi_sts,
				    		    String cust_edi_sts_cd,
				    		    String bkg_no,
				    		    String cntr_no,
				    		    String po_nbr
    		    ) throws EventException{
    		try {
    			String cnt = dbDao.getVipSndCount(edi_grp_cd,edi_sts,cust_edi_sts_cd,bkg_no,cntr_no,po_nbr);
 			   return cnt;
 		} catch (DAOException e) {
 			  throw new EventException(e.getMessage(),e);
 		}
      }


      
   	  /**searchIsCargoSmart - searchIsCargoSmart DBDAO 상 의 레퍼함수
       * @param  String edi_grp_cd 			              
       * @param  String bkg_no		              
       * @return String
       * @throws EventException
       */
      /* 2011.05.23 [CHM-201110822-01] (CargoSmart)315 로직보완요청 - 원복처리로 인한 미사용 메소드 제거
      private String searchIsCargoSmart(String edi_grp_cd,String bkg_no) throws EventException{
		  try {
					 return  dbDao.searchIsCargoSmart(edi_grp_cd,bkg_no);
	      } catch (DAOException e) {
				     throw new EventException(e.getMessage(),e);
	      }    	  
      }
      */
      
   	  /**searchFindMtEdiSndRslt - searchFindMtEdiSndRslt DBDAO 상 의 레퍼함수
       * @param  String eid_grp_cd		              
       * @param  String bkg_no		              
       * @param  String cntr_no			              
       * @return String
       * @throws EventException
       */      
      private String searchFindMtEdiSndRslt(String eid_grp_cd,
    		                               String bkg_no,
    		                               String cntr_no
    		                               ) throws EventException{
		  try {
					 return  dbDao.searchFindMtEdiSndRslt(eid_grp_cd,bkg_no,cntr_no);
	      } catch (DAOException e) {
				     throw new EventException(e.getMessage(),e);
	      }    	  
      }  
   	  /**getBaseNos - BKG_NO BL_NO CNTR_NO COP_NO 를 가지고 오는 함수
       * @param  Edi315SendVO     sendVo			              
       * @return HashMap<String,String>
       * @throws EventException
       */ 
      private HashMap<String,String> getBaseNos(Edi315SendVO     sendVo) throws EventException{
		try {
			  DBRowSet rowset = dbDao.getBaseNos(sendVo.getBkgNo()
					                            ,sendVo.getCntrNo()
					                            ,sendVo.getBlNo()
					                            ,sendVo.getCopNo());
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("BKG_NO" ,rowset.getString("BKG_NO" ));
				  keys_values.put("BL_NO"  ,rowset.getString("BL_NO"  ));
				  keys_values.put("CNTR_NO",rowset.getString("CNTR_NO"));	
				  keys_values.put("COP_NO" ,rowset.getString("COP_NO" ));
			  }
			  return keys_values;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	     }
      }
      /**getOA_Value - call_from DIR 일때는 Status 가 OA 로만 들어 오는 데 이 때의 OAN, OAO 판단 로직
       * @param  String cop_no
       * @return String
       * @throws EventException
       */   
      private String getOA_value(String cop_no) throws EventException {
		try {
			String oa_status = dbDao.getOA_value(cop_no);
			return oa_status;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
      } 
      
      /**
       * VAD에 대한  actual mapping 정보 조회     
       * @param String cop_no
       * @return  SceCopDtlVO
       * @throws EventException
       */
      private SceCopDtlVO getVADActualMappingInfo(String cop_no) throws EventException {
  		try {
  			SceCopDtlVO vo = dbDao.getVADActualMappingInfo(cop_no);
  			return vo;
  		} catch (DAOException e) {
  			throw new EventException(e.getMessage(), e);
  		}
      }     
      
      

   	  /**removeSymbolInString - 특정문자열에서 인자로 주어진 해당 심볼을 제거 하는 함수 
       * @param  String org
       * @param  String[] sym              
       * @return String
       */   
//      private String removeSymbolInString(String org,String[] sym){
//    	  if(org != null && sym != null){
//    		  for(int i=0;i<sym.length;i++){
//    			  String o = sym[i];
//    			  log.info("Org -" + org);
//    			  log.info("SYM -" + o);
//    			  org = org.replace(o, "");
//    		  }
//    	 
//    	  }
//    	  
//    	  return org;
//      }
      /**
       * Booking 의 315 발송 대상 화주 조회.
       * @param String bkg_no 
       * @return String
       * @throws EventException
       */   
      private String searchEdiGrpCd(String bkg_no) throws EventException {
		try {
			return dbDao.searchEdiGrpCd(bkg_no);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
      }
      
      
      /**
       * addSceEdiHis
       * 모든 발송 History 는 sce_edi_his 테이블에 Insert 된다.
       * 이 테이블에 없으면 edi Call 이 안됐다는 의미로 봐도 무방 하다.
       * @param List<Edi315SendVO> list
       * @return boolean
       * @throws EventException
       */	
  	private boolean addSceEdiHis(List<Edi315SendVO> list)throws EventException{
  		try {   
  		     return dbDao.addSceEdiHis(list);
  		} catch (DAOException e) {
  		// TODO Auto-generated catch block
  		throw new EventException(e.getMessage(),e);
  		}
      }
  	/**
  	 * addSceEdiHisDtl
  	 * 발송 대상과 발송 Staus 를 insert 한다. 
  	 * @param List<Edi315DetailVO> list
  	 * @return boolean
  	 * @exception EventException
  	 */	
  	private boolean addSceEdiHisDtl(List<Edi315DetailVO> list)throws EventException{
  		try {
  		     return dbDao.addSceEdiHisDtl(list);
  		} catch (DAOException e) {
  		// TODO Auto-generated catch block
  		throw new EventException(e.getMessage(),e);
  		}
      }	
  	/**
  	 * addSceFltFileMsg
  	 * 발송된 Flat File의 주요 정보를 테이블에 담아 놓는다.
  	 * @param String flt_file_ref_no
  	 * @param Edi315PrefixMainCOPInfoVO mVo
  	 * @param Edi315DetailVO dtlVo
  	 * @param SceFltFileMsgVO ffMsgVo
  	 * @return String
  	 * @exception EventException
  	 */	
  	private String addSceFltFileMsg(String flt_file_ref_no
  			, Edi315PrefixMainCOPInfoVO mVo, Edi315DetailVO dtlVo, SceFltFileMsgVO ffMsgVo)throws EventException{
		try  {
			  
			return dbDao.addSceFltFileMsg(flt_file_ref_no, mVo, dtlVo, ffMsgVo);
		     
	    } catch (DAOException e) {
		  throw new EventException(e.getMessage(),e);
	    }
		
	}

  	/**
  	 * addSceFltFileNoGen
  	 * 생성된 Flat File을 포함 하여 Insert 한다.
  	 * @param String ff_yymmdd
  	 * @param String ff_seq
  	 * @param String ediString
  	 * @param Edi315SendVO sendVo
  	 * @param Edi315DetailVO dtlVo
  	 * @return String
  	 * @exception EventException
  	 */	
  	private boolean addSceFltFileNoGen(
							String ff_yymmdd, 
							String ff_seq,
							String ediString, 
							Edi315SendVO sendVo,
							Edi315DetailVO dtlVo) throws EventException {
		try {
			
	        AddSceFltFileNoGenVO valueVo = new AddSceFltFileNoGenVO();
	        valueVo.setEdiSndYrmondy(ff_yymmdd);
	        valueVo.setEdiSndSeq(ff_seq);
	        valueVo.setEdiSndDesc(ediString);
	        valueVo.setBkgNo(dtlVo.getBkgNo());
	        valueVo.setBlNo(dtlVo.getBlNo());
	        valueVo.setCreUsrId(sendVo.getCreId());
	        valueVo.setUpdUsrId(sendVo.getUpdId());
	        valueVo.setRsltFlg(dtlVo.getRsltFlg());
	        valueVo.setEdiStsCd(dtlVo.getEdiSts());
	        
	        List<AddSceFltFileNoGenVO> list = new ArrayList<AddSceFltFileNoGenVO>();
	        list.add(valueVo);
	        
	        return dbDao.addSceFltFileNoGen(list);
						
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}
	}
  	/**
  	 * addSceEdiSndRslt
  	 * Logging History, Sent History 테이블.
  	 * @param String ff_yymmdd
  	 * @param String ff_seq
  	 * @param String flt_file_ref_no
  	 * @param String po_nbr
  	 * @param Edi315SendVO sendVo
  	 * @param Edi315DetailVO dtlVo
  	 * @param Edi315CurrInfoVO currVo
  	 * @return String
  	 * @exception EventException
  	 */	
  	private boolean addSceEdiSndRslt(
			String ff_yymmdd, 
			String ff_seq,
			String flt_file_ref_no, 
			String po_nbr,
			Edi315SendVO sendVo,
            Edi315DetailVO dtlVo,
            Edi315CurrInfoVO currVo) throws EventException {
		try {
			String edi_snd_knt = "";
			String pick_no_322 = "";

			pick_no_322 = currVo.getPickUpNo();
			if("NT".equals(dtlVo.getEdiSts())){
				pick_no_322 = get322PickupNo(currVo.getCurrEventDt(),sendVo.getCntrNo());
			}
			 


			 edi_snd_knt = getVipSndCount(
					 dtlVo.getEdiGrpCd(),
					 dtlVo.getEdiSts(),
					 dtlVo.getCustEdiStsCd(),
					 sendVo.getBkgNo(),
					 sendVo.getCntrNo(),
					 po_nbr
			 );
			 
			 
			 log.info("\n edi_snd_knt"+edi_snd_knt);
			 
			 /* 2008-01-15 : 장인호 : 진행중 bkg 의 vvd 가 변경되는 경우 기존에 변경 전으로 입력된 vvd 를 변경 후의 vvd 로 update 한다.*/
			 if(Integer.parseInt(edi_snd_knt)>1){
				 
				 if(!dtlVo.getEdiSts().equals("VAD") &&
					!dtlVo.getEdiSts().equals("VAT") &&
					!dtlVo.getEdiSts().equals("VBD") &&
					!dtlVo.getEdiSts().equals("VBT") &&
					!dtlVo.getEdiSts().equals("VDL") &&
					!dtlVo.getEdiSts().equals("VDT") &&
					!dtlVo.getEdiSts().equals("VET") &&
					!dtlVo.getEdiSts().equals("VDE") &&
					!dtlVo.getEdiSts().equals("VE") 
				 ){
					 modifySceEdiSndRslt(dtlVo);
				 }
			 }
			List<AddSceEdiSndRsltVO> list = new ArrayList<AddSceEdiSndRsltVO>();
			AddSceEdiSndRsltVO addSceEdiSndRsltVo = new AddSceEdiSndRsltVO();
			
			addSceEdiSndRsltVo.setEdiSndYrmondy	(ff_yymmdd);
			addSceEdiSndRsltVo.setEdiSndSeq		(ff_seq);			
			addSceEdiSndRsltVo.setFltFileRefNo	(flt_file_ref_no);
			addSceEdiSndRsltVo.setBkgNo			(sendVo.getBkgNo());
			addSceEdiSndRsltVo.setBlNo			(sendVo.getBlNo());
			addSceEdiSndRsltVo.setCntrNo		(sendVo.getCntrNo());
			addSceEdiSndRsltVo.setManFlg		(sendVo.getManFlg());
			addSceEdiSndRsltVo.setCreUsrId		(sendVo.getCreId());
			addSceEdiSndRsltVo.setUpdUsrId		(sendVo.getUpdId());
			addSceEdiSndRsltVo.setTrunkVvd		(dtlVo.getTrunkVvd());
			addSceEdiSndRsltVo.setEdiGrpCd		(dtlVo.getEdiGrpCd());
			addSceEdiSndRsltVo.setEdiStsCd		(dtlVo.getEdiSts());
			addSceEdiSndRsltVo.setEdiSubStsCd	(dtlVo.getCustEdiStsCd());
			addSceEdiSndRsltVo.setEdiSndItvalHr	(dtlVo.getEdiSndItvalHrmnt());
			addSceEdiSndRsltVo.setRsltFlag		(dtlVo.getRsltFlg());
			addSceEdiSndRsltVo.setActDt			(currVo.getCurrEventDt());
			addSceEdiSndRsltVo.setNodCd			(currVo.getCurrEventYard());
			addSceEdiSndRsltVo.setPoNo			(po_nbr);
			addSceEdiSndRsltVo.setEdiSndKnt		(edi_snd_knt);
			addSceEdiSndRsltVo.setPkupEdi322No	(pick_no_322);
			addSceEdiSndRsltVo.setCopNo			(sendVo.getCopNo());
			
			list.add(addSceEdiSndRsltVo);
			
					
			return dbDao.addSceEdiSndRslt(list);
				
		} catch (DAOException e) {
		// TODO Auto-generated catch block
		throw new EventException(e.getMessage(), e);
		}
	}

	
	
	
	/**
	 * modifySceEdiHisCustRmk
     * searchEdiGrpCd 조회 결과(315발송대상화주) Update.
     * @param String cust_rmk
     * @param Edi315SendVO sendVo
     * @return boolean
     * @exception EventException
     */
  	private boolean  modifySceEdiHisCustRmk(String cust_rmk, Edi315SendVO sendVo) throws EventException {
		try {
			String e_rcv_dt = sendVo.getRcvDt();
			String e_rcv_seq = sendVo.getRcvSeq();

			return dbDao.modifySceEdiHisCustRmk(cust_rmk, e_rcv_dt,e_rcv_seq);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	
    
	/**
     * modifySceEdiHisEdiRmk - SCE_EDI_HIS.EDI_RMK 컬럼을 수정하는 함수
     * @param String edi_rmk
     * @param Edi315SendVO sendVo
     * @return boolean
     * @exception EventException
     */
  	private boolean  modifySceEdiHisEdiRmk(String edi_rmk, Edi315SendVO sendVo) throws EventException {
		try {
			String e_rcv_dt = sendVo.getRcvDt();
			String e_rcv_seq = sendVo.getRcvSeq();

			return dbDao.modifySceEdiHisEdiRmk(edi_rmk, e_rcv_dt,e_rcv_seq);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	

	/**
     * modifySceEdiHisDtl - SCE_EDI_HIS_DTL table 를 수정하는 함수
     * @param String e_rslt_flag
	 * @param String e_rslt_remark
     * @param Edi315DetailVO   dtlVo
     * @return boolean
     * @exception EventException
     */		
	
  	private boolean modifySceEdiHisDtl(
								String e_rslt_flag, 
								String e_rslt_remark,
								Edi315DetailVO   dtlVo)throws EventException {

		try {

			if (e_rslt_flag.equalsIgnoreCase("Y") || e_rslt_flag.equalsIgnoreCase("Success")) {
				e_rslt_flag = "Y";
			}
//			else if("R".equals(e_rslt_flag)){
//				e_rslt_flag = "R";
//			}else {
//				e_rslt_flag = "N";
//			}
			String e_rcv_dt 		= dtlVo.getRcvDt();
			String e_rcv_seq 		= dtlVo.getRcvSeq();
			String e_rcv_dtl_seq 	= dtlVo.getRcvDtlSeq();
			
			return dbDao.modifySceEdiHisDtl(
								e_rslt_flag, 
								e_rslt_remark,
								e_rcv_dt, 
								e_rcv_seq, 
								e_rcv_dtl_seq);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}

	}
	/**
     * modifySceEdiSndRslt
     * @param Edi315DetailVO   dtlVo 
     * @return boolean
     * @exception EventException
     */		
	
  	private boolean modifySceEdiSndRslt(Edi315DetailVO   dtlVo)throws EventException {

		try {
			return dbDao.modifySceEdiSndRslt(dtlVo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}

	}
	/**
     * modifySceEdiHisDtlEdiRmk1 - SCE_EDI_HIS_DTL.EDI_RMK1 컬럼을 수정하는 함수
     * @param String edi_rmk1
     * @param Edi315DetailVO dtlVo
     * @return boolean
     * @exception EventException
     */
  	private boolean  modifySceEdiHisDtlEdiRmk1(String edi_rmk1, Edi315DetailVO dtlVo) throws EventException {

		try {

			String e_rcv_dt = dtlVo.getRcvDt();
			String e_rcv_seq = dtlVo.getRcvSeq();
			String e_rcv_dtl_seq = dtlVo.getRcvDtlSeq();

			return dbDao.modifySceEdiHisDtlEdiRmk1(edi_rmk1, e_rcv_dt,e_rcv_seq, e_rcv_dtl_seq);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}

	}
	/**
     * modifySceEdiHisDtlEdiRmk2 -  SCE_EDI_HIS_DTL.EDI_RMK2 컬럼을 수정하는 함수
     * @param String edi_string
     * @param Edi315DetailVO dtlVo
     * @return boolean
     * @exception EventException
     */
//  	private boolean modifySceEdiHisDtlEdiRmk2(
//								String edi_string, 
//								Edi315DetailVO   dtlVo)throws EventException {
//
//		try {
//
//
//			if (edi_string.length()>=4000){
//				edi_string =edi_string.substring(0, 4000);
//			}
//			
//			String e_rcv_dt 		= dtlVo.getRcvDt();
//			String e_rcv_seq 		= dtlVo.getRcvSeq();
//			String e_rcv_dtl_seq 	= dtlVo.getRcvDtlSeq();
//			
//			return dbDao.modifySceEdiHisDtlEdiRmk2( edi_string, e_rcv_dt, e_rcv_seq, e_rcv_dtl_seq);
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			throw new EventException(e.getMessage(), e);
//		}
//
//	}

	

	/**
     * modifySceActRcvIf - SCE_ACT_RCV_IF table 를 수정하는 함수
     * @param String rslt_flg
	 * @param Edi315SendVO sendVo
     * @return boolean
     * @exception EventException
     */		
	
  	private boolean modifySceActRcvIf(String rslt_flg, Edi315SendVO sendVo) throws EventException {
			String e_rslt_flg = "A";
		try {

			if (rslt_flg.equalsIgnoreCase("Y")
					|| rslt_flg.equalsIgnoreCase("Success")) {
				e_rslt_flg = "Y";
			} else {
				e_rslt_flg = "N";
			}
			String e_rcv_if_dt = sendVo.getActRcvIfKeyDt();
			String e_rcv_if_no = sendVo.getActRcvIfKeyNo();
			

			return dbDao.modifySceActRcvIf(e_rslt_flg, e_rcv_if_dt, e_rcv_if_no);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new EventException(e.getMessage(), e);
		}

	}	

    /**
     * 해당 VO 를 통하여 SCE_COP_DTL 테이블에 값을 저장한다.
     * @param String stnd_edi_sts_cd 
     * @param String event_dt
	 * @param String cop_no
	 * @param String cop_dtl_seq
     * @return boolean
     * @throws EventException
     */	
  	private boolean modifySceCopDtl (
            String stnd_edi_sts_cd,
            String event_dt,
            String cop_no,
            String cop_dtl_seq
           )throws EventException{
	     try {
	          return dbDao.modifySceCopDtl(
								stnd_edi_sts_cd,
								event_dt,
								cop_no,
								cop_dtl_seq
			
	                            );
	    } catch (DAOException e) {
	    // TODO Auto-generated catch block
	    throw new EventException(e.getMessage(),e);
	    }
    }	
	
    /**
     * searchICtoVADsendValidation
     * POD, DEL, T/S되는 PORT, 2ND VVD가 없는 건인지 확인     
     * @param Edi315SendOptionsVO optVo
     * @return SceCopDtlVO
     * @throws EventException
     */
  	private  SceCopDtlVO searchICtoVADsendValidation(Edi315SendOptionsVO optVo) throws EventException {
		try {
			SceCopDtlVO vo = dbDao.searchICtoVADsendValidation(optVo);
			return vo;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    } 	
    
	/**
	 * searchEdi315FlatFileKey 
	 * SCE_FLT_FILE_MSG 테이블의 PK 조회
	 * 
	 * @return SceFltFileMsgVO
	 * @throws EventException
	 */
    private  SceFltFileMsgVO searchEdi315FlatFileKey() throws EventException {
		try {
			SceFltFileMsgVO vo = dbDao.searchEdi315FlatFileKey();
			return vo;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    } 	
    /**
     * sce_flt_file_msg_dtl_vsl 테이블에 vessel정보 등록   
     * 발송된 Flat File의 vessel정보를 테이블에 담아 놓는다.
     * @param SceFltFileMsgDtlVslVO ffMsgVo
     * @return String
     * @throws EventException
     */
  	private String addSceFltFileMsgDtl( SceFltFileMsgDtlVslVO ffMsgVo)throws EventException{
		try  {
			  
			return dbDao.addSceFltFileMsgDtl(ffMsgVo);
		     
	    } catch (DAOException e) {
		  throw new EventException(e.getMessage(),e);
	    }
		
	}  	

    /**
	 * Booking이 Memo Split인지, Origin Booking 정보가 무엇인지 조회
	 * 
	 * @return HashMap<String,String>
	 * @throws EventException
	 */       
    private HashMap<String,String> searchOriginBookingInformation(String bkgNo) throws EventException{
        try {
			DBRowSet rowset = dbDao.searchOriginBookingInformation(bkgNo);
			HashMap<String,String> hashMap = null; ;
			
			if(rowset != null && rowset.next()){ 
				
				hashMap = new HashMap<String,String>();
				hashMap.put("BKG_NO", rowset.getString("BKG_NO"));
				hashMap.put("BL_NO", rowset.getString("BL_NO"));
				hashMap.put("BL_TP_CD", rowset.getString("BL_TP_CD"));
				
//				hashMap.put("BL_CRT_DT", rowset.getString("BL_CRT_DT"));
//				hashMap.put("BKG_CRT_DT", rowset.getString("BKG_CRT_DT"));
//				hashMap.put("BKG_CFM_DT", rowset.getString("BKG_CFM_DT"));
			}

			return hashMap;
			
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	       } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	       }
    }

	/**
	 * getAVNValidationCount
	 * AVN이 발송 유효한 상태인지 확인한다. 
     * @param    Edi315DetailVO dtlVo
     * @return   int
     * @throws   EventException
     */ 
    private int getAVNValidationCount(Edi315DetailVO dtlVo) throws EventException {
    	try {
    		return dbDao.getAVNValidationCount(dtlVo);
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    }

    /**
	 * Adidas 관련 FLAT FILE에 BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 조회
	 * 
	 * @return HashMap<String,String>
	 * @throws EventException
	 * @since 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에  BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 추가
	 */       
    private HashMap<String,String> searchAdidasBlBkgDate(String bkgNo) throws EventException{
        try {
			DBRowSet rowset = dbDao.searchAdidasBlBkgDate(bkgNo);
			HashMap<String,String> hashMap = null; ;
			
			if(rowset != null && rowset.next()){ 
				
				hashMap = new HashMap<String,String>();
				hashMap.put("BL_CRT_DT", rowset.getString("BL_CRT_DT"));
				hashMap.put("BKG_CRT_DT", rowset.getString("BKG_CRT_DT"));
				hashMap.put("BKG_CFM_DT", rowset.getString("BKG_CFM_DT"));
			}

			return hashMap;
			
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	       } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	       }
    }

    /**
     * Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에 처리할 Multi Booking No., BL No. 조회  
     * @param trim
     * @param cntrNo
     * @return
     * @since 2010.10.26 
     */
    private String[][] searchPrtlBkgsForEdiGrp(String bkgNo, String cntrNo, ArrayList custTrdPrnrIdArryList)  throws EventException{

		String[][] multiResultArray = null; ;

    	try {
			DBRowSet rowset = dbDao.searchPrtlBkgsForEdiGrp(bkgNo, cntrNo, custTrdPrnrIdArryList);
			if (rowset != null) {
				multiResultArray = new String[rowset.getRowCount()][2];
				int i = 0;
				while (rowset.next()) {
					multiResultArray[i][0] = rowset.getString(1);
					multiResultArray[i][1] = rowset.getString(2);
					i++;
				}
			}
			rowset = null;

		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return multiResultArray;
	}

    /**
     * 2011.04.08 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리  
     * @param sendVo
     * @param detailVo
     * @param currVo
     * @return HashMap 
     * @since 2011.04.08 
     */
    private HashMap edi315SendForUSA00094VAMissed(Edi315SendVO sendVo, Edi315DetailVO detailVo, Edi315CurrInfoVO currVo) throws EventException { 

    	HashMap hashMap = null; 

    	try { 
	    	int vaCount = 1; 
	    	
			/// VA 데이터가 있는지 체크  ///
			DBRowSet rowset = dbDao.searchUSA00094VAMissed(sendVo.getBkgNo(), detailVo.getCntrNo());
			if(rowset != null && rowset.next()){ 
				hashMap = new HashMap();
				vaCount = rowset.getInt("CNT");
				hashMap.put("EVENT_DT_VAD", rowset.getString("EVENT_DT_VAD"));
				hashMap.put("EVENT_YARD", rowset.getString("EVENT_YARD"));
				hashMap.put("EVENT_COP_DTL_SEQ", rowset.getString("EVENT_COP_DTL_SEQ"));
			}
	
	    	if ( vaCount > 0 ){
	    		hashMap = null; // becase aleady it was sent... 
	    	}
	
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return hashMap; 
   	}
    
    /**
     * BKG_NO로 POL ,DEL의 SCC를 가져온다.
     * @param bkgNo
     * @return
     * @since 2011.05.30 
     */
    private String[] searchPrtlBkgsForEdiGrp(String bkgNo)  throws EventException{

		String[] resultArray = new String[2]; ;
		DBRowSet rowset = null;
    	try {
			rowset = dbDao.getBkgRouteSccCd(bkgNo);
			while (rowset.next()){
				    resultArray[0] = rowset.getString("POD_SCC_CD");
				    resultArray[1] = rowset.getString("DEL_SCC_CD");
				}
			rowset = null;

		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return resultArray;
	}
    
    /**
     * 2011.08.25 이경원 [CHM-201112880-01] 삼성전자 315 Event 코드 추가 및 정의변경 FLAT FILE에 PODETB, PODETB_GMT, PODATB, PODATB_GMT 항목 추가
     * searchPodEtbAtbDate
     * PODETB, PODETB_GMT, PODATB, PODATB_GMT를 가져옴 
     * @param Edi315SendOptionsVO optVo
     * @return Edi315PrefixMainCOPInfoVO
     * @throws EventException
     */
    	private  Edi315PrefixMainCOPInfoVO searchPodEtbAtbDate(Edi315SendOptionsVO optVo) throws EventException {
    	try {
    		Edi315PrefixMainCOPInfoVO vo = dbDao.searchPodEtbAtbDate(optVo);
    		return vo;
    	} catch (DAOException e) {
    		throw new EventException(e.getMessage(), e);
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
    	}
    }
    	/**
         * 2011.10.05 이경원 
         * searchCutOffTime
         * CUTOFF_TM을 가져옴 
         * @param String bkgNo
         * @return String
         * @throws EventException
         */

        private String searchCutOffTime(String bkgNo) throws EventException {
        	try {
        		return dbDao.searchCutOffTime(bkgNo.trim());
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch(Exception ex){
    	  		throw new EventException(ex.getMessage(), ex);
    	  	}
        }
        
    	/**
         * 2015.10.23 조풍연 김민정 
         * searchMsDwllRsnCd
         * EXPT_CD 가져옴 
         * @param String copNo
         * @return String
         * @throws EventException
         */

        private String searchMsDwllRsnCd(String copNo) throws EventException {
        	try {
        		return dbDao.searchMsDwllRsnCd(copNo.trim());
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch(Exception ex){
    	  		throw new EventException(ex.getMessage(), ex);
    	  	}
        }
        
        /**
         * 2015.10.23 조풍연 김민정 
         * searchMsDwllRmk
         * EXPT_RMK 가져옴 
         * @param String copNo
         * @return String
         * @throws EventException
         */

        private String searchMsDwllRmk(String copNo) throws EventException {
        	try {
        		return dbDao.searchMsDwllRmk(copNo.trim());
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch(Exception ex){
    	  		throw new EventException(ex.getMessage(), ex);
    	  	}
        }
        
        /**
         * 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
         * searchEventYardForReUse
         * Evend_Yard와 Nod_CD를 가져옴 
         * @param String bkgNo
         * @param String cntr_no
         * @param String event_yard
         * @param String edi_sts
         * @param String cop_dtl_seq
         * @return String
         * @throws EventException
         */

        private String[] searchEventYardForReUse(String bkg_no, String cntr_no, String event_yard, String edi_sts, String cop_dtl_seq) throws EventException {
        	String[] resultArray = new String[2];
        	DBRowSet rowset = null;
        	try {
        		rowset = dbDao.searchEventYardForReUse(bkg_no, cntr_no, event_yard, edi_sts, cop_dtl_seq);
    			while (rowset.next()){
    				    resultArray[0] = rowset.getString("CONTI_CD");
    				    resultArray[1] = rowset.getString("NOD_CD");
    			}
    		    rowset = null;
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch(Exception ex){
    	  		throw new EventException(ex.getMessage(), ex);
    	  	}
    		
    		return resultArray;
        }
        
        /**
         * 2011.10.27 이경원 [] EDI 312 Arrival Notice Message
         * getPickUpFirmsCode
         * Get PKUP_FIRMS
         * @param  String bkg_no 
         * @return String
         * @throws EventException
         */       
    	private String getPickUpFirmsCode(String bkg_no) throws EventException{
            try {
    	           String result = dbDao.getPickUpFirmsCode(bkg_no);
    			   return result;
    		   } catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		   } 
        }
    	
    	/** @param  String cop_no 
         * @return String
         * @throws EventException
         */       
    	private String getSearchDelCd(String cop_no) throws EventException{
    		 String result = null;
    		 	try {
    	            result = dbDao.searchDelCd(cop_no);
    			  
    		 	} catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		 	}catch(Exception ex){
       	  			throw new EventException(ex.getMessage(), ex);
       	  		} 
    		   return result;
        }
    	
      	/** @param  String bkg_no
    	 * @param  String cntr_no 
         * @return String
         * @throws EventException
         */       
    	private String searchCntrPoNbr(String bkg_no, String cntr_no) throws EventException{
    		 String result = null;
    		 	try {
    	            result = dbDao.searchCntrPoNbr(bkg_no, cntr_no);;
    			  
    		 	} catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		 	}catch(Exception ex){
       	  			throw new EventException(ex.getMessage(), ex);
       	  		} 
    		   return result;
        }
    	
    	/** @param  String bkg_no
    	 * @param  String cntr_no 
         * @return String
         * @throws EventException
         */       
    	private String searchLoadId(String bkg_no, String cntr_no) throws EventException{
    		 String result = null;
    		 	try {
    	            result = dbDao.searchLoadId(bkg_no, cntr_no);;
    			  
    		 	} catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		 	}catch(Exception ex){
       	  			throw new EventException(ex.getMessage(), ex);
       	  		} 
    		   return result;
        }
    	
    	/**
    	 * getPreSentAvCnt
    	 * 기 발송 된 Status가 있는지 확인 한다. 
         * @param    Edi315DetailVO dtlVo
         * @return   int
         * @throws   EventException
         */ 
        private int getPreSentAvCnt(Edi315DetailVO dtlVo) throws EventException {
        	try {
        		return dbDao.getPreSentAvCnt(dtlVo);
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		}
        }
        
        /** @param  String bkg_no
    	 * @param  String cntr_no 
         * @return String
         * @throws EventException
         */       
    	private String searchMvmtSealNo(String bkg_no, String cntr_no) throws EventException{
    		 String result = null;
    		 	try {
    	            result = dbDao.searchMvmtSealNo(bkg_no, cntr_no);;
    			  
    		 	} catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		 	}catch(Exception ex){
       	  			throw new EventException(ex.getMessage(), ex);
       	  		} 
    		   return result;
        }
    	
    	// 2013.10.22 CHM-201327178 DEL Delivery Time 변경 시 자동 전송 로직 추가 요청(Live 미반영으로 주석처리)
    	/**
    	 * getEoanEstimatedDate
    	 * 신규 Event EOAN(Estimated Time of I/B Ingate)을 가져온다.
    	 * @param String cop_no
    	 * @return CurrEventDtYdVO
    	 * @exception EventException
    	 */	
        private CurrEventDtYdVO getEoanEstimatedDate(String cop_no) throws EventException {
    		CurrEventDtYdVO currEventDtYdVO = null ;

    		try {
    			currEventDtYdVO =  dbDao.getEoanEstimatedDate(cop_no);
    			return currEventDtYdVO;
    		} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		}
    	}
    	
    	/**
    	 * getIbTruckSoCnt
    	 * Nike Canada Event AOL 일때 I/B Truck 운송이 있는지 여부를 체크한다.
    	 * @param String cop_no
    	 * @return int
    	 * @exception EventException
    	 */	
        private int getIbTruckSoCnt(String cop_no) throws EventException {
    		int chkCnt = 0 ;

    		try {
    			chkCnt =  dbDao.getIbTruckSoCnt(cop_no);
    			return chkCnt;
    		} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		}
    	}
        
   	  /**
   	   * Reserved 경우에 Send Date를 조정 한다. 
       * @param  String event_dt
       * @param  String event_node
       * @return String
       * @throws EventException
       */ 
	    private String getReservedSetDt(String event_dt, String event_node) throws EventException{
	          try {
	  			   return dbDao.getReservedSetDt(event_dt, event_node);
	  		   } catch (DAOException e) {
	  				throw new EventException(e.getMessage(),e);
	  		   } 
	    }
        
        /**
    	 * searchVesselClptIndSeq
    	 * 해당 COP의 VVD, Port, Calling Port Seq가 같은지 확인한다. 
         * @param    Edi315SendVO sendVo
         * @return   int
         * @throws   EventException
         */ 
        private int searchVesselClptIndSeq(Edi315SendVO sendVo) throws EventException {
        	try {
        		return dbDao.searchVesselClptIndSeq(sendVo);
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		}
        }
        
        /**getBkgRefNo
         * @param    String bkg_no
         * @param    String bkg_ref_tp
         * @return   String
         * @throws   EventException
         */       
      private String getBkgRefNo(String bkg_no, String bkg_ref_tp)throws EventException{
    	     try {
  			   String refNo = dbDao.getBkgRefNo(bkg_no,bkg_ref_tp);
  			   return refNo;
  		 } catch (DAOException e) {
  				throw new EventException(e.getMessage(),e);
  	     }     	  
      }
}