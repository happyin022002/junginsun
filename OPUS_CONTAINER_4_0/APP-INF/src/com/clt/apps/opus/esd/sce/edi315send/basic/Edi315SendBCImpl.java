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
   					  ESD084-0001 interface 를 통해 (ENT) 에서 받은 Ship ID 및 Partner No 를 flat file 에 add 하여 준다.
   2009-05-27:yjlee: IRG_INFO 부분의 Logic보완 N200905200080 
   					  과거엔 MVMT에 있던 대로 ATB시간을 기반으로 추정 했지만
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
* 2015.01.05 김인규 NYK ITEM 추가 및 보완
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.basic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.clt.apps.opus.esd.sce.edi315send.integration.Edi315SendDBDAO;
import com.clt.apps.opus.esd.sce.edi315send.integration.Edi315SendEAIDAO;
import com.clt.apps.opus.esd.sce.edi315send.vo.AddSceEdiSndRsltVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.AddSceFltFileNoGenVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.CurrEventDtYdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.CurrVvdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315CurrInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315DetailVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315MasterVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixBkgVvdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixIrgInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainBkgCustInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.GetRailTermVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.RlyPortVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchBoundRoutSeqVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchCntrWeightInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchCredataMetInformationVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchTIExistInformationVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchVvdTimeInformationVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.SceCopDtlVO;
import com.clt.syscommon.common.table.SceFltFileMsgDtlVslVO;
import com.clt.syscommon.common.table.SceFltFileMsgVO;
/**
 * SCE Business Logic ServiceCommand<br>
 * - SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
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
	 * CALL : esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/basic/UsCgoRlseBackEndJob.java
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
		
		try {
			log.debug("\n ------ edi315Send 시작 -------------- sendVo.toString() : \n"+sendVo.toString());

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
			
			List<Edi315SendVO> list = new ArrayList<Edi315SendVO>();
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
			 * WO발행시마다 아래 Method 항상 call.
			 * DOOR운송이고 Truck 운송이 포함된 경우에 EDI 발송.(TD/TR모드 등 ..)
			 * WO Issue 시 발송 하는 경우는 COP NO 만으로 EDI Call 된다. 그에 따른 BKG NO, CNTR NO등을 Setting 한다.
			 **/			
			if ("TRS".equals(sendVo.getCopCallModule())) {
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
				if(baseNos.get("BKG_STS_CD").equalsIgnoreCase("A")) {
					String edi_rmk = "AdvancedBookingSkip";
					modifySceEdiHisEdiRmk(edi_rmk,sendVo);
					return FAIL;
				}
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
					sendVo.setEdiStatus(oa_value);
				}
					sendVo.setManFlg("D");					
			}

			
			
			
			
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
					addSceEdiHisDtl(dvos);
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

					List<String> locList = new ArrayList<String>();
					locList.add("USSAV");
					locList.add("USNYC");
					locList.add("USLAX");
					locList.add("USLGB");
					locList.add("USTIW");
					locList.add("USSEA");
					
					for (int i = 0; i < dvos.size(); i++) { // 1건씩 발송 시도.
						Edi315DetailVO detailVo = dvos.get(i);
						ObjectCloner.build(mstVo,detailVo);
						log.debug("\n ObjectCloner 후 detailVo.toString() : \n"+detailVo.toString());
						

						
						
						
//-----2-1.currVo EventDt/Node------------------------------------------------------------------------------------------------------						
						
						
						Edi315CurrInfoVO currVo = new Edi315CurrInfoVO();

						CurrEventDtYdVO    currEventDtYdVo = null;//Curr Event YD/DT
						CurrVvdVO currVvdVo = null; 
						String org_sts = detailVo.getOrgEdiSts();
						String edi_sts = detailVo.getEdiSts();
						String r_flag   = "";
						String r_remark = "";
						
						//org_sts != edi_sts <- 동시 발송 케이스만 Event Date, Event Yard를 변경 함
						if((!org_sts.equals(edi_sts)&& !"Y".equals(sendVo.getManFlg())) || "Y".equals(sendVo.getManFlg())){
							
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
//							} else if(("H100000001".equals(detailVo.getEdiGrpCd()) || "P500000001".equals(detailVo.getEdiGrpCd())) && "AV".equals(detailVo.getCustEdiStsCd()) && 
//									StringUtils.isNotEmpty(detailVo.getPodCd()) && detailVo.getPodCd().equals(detailVo.getDelCd()) && 
//									locList.contains((String)detailVo.getPodCd())) {
//								// do nothing
//								log.debug("\n do not change CurrentVO");
							} else if("610".equals(detailVo.getEdiCgoRmk())) { // AV Event
								log.debug("\n edi315Send's AV Event, "+detailVo.getEdiSts()+" status KKKKKKKK");
								if(detailVo.getEdiSts().matches("A([CFOV]){1}L") && !detailVo.getPodNodCd().equalsIgnoreCase(detailVo.getDelNodCd())) { // ACL, AFL, AOL, AVL
									// AV인 경우 POD(SCE_COP_HDR.POD_NOD_CD)와 SCE_COP_DTL에서 ACT_CD가 FI%DO 인 마지막 NOD_CD 앞 다섯자리가 다르면 AVL이벤트가 발송되어야 함.
									Edi315CurrInfoVO info = dbDao.getAVEventPodCheck(detailVo.getCopNo());
									if(info != null && info.getCurrEventYard() != null && info.getCurrEventYard().equalsIgnoreCase(detailVo.getPodNodCd().substring(0, 5))) { 
										// do nothing
										log.debug("\n edi315Send's AV Event, "+detailVo.getEdiSts()+" status, AV인 경우 POD(SCE_COP_HDR.POD_NOD_CD)와 SCE_COP_DTL에서 ACT_CD가 FI%DO 인 마지막 NOD_CD 앞 다섯자리가 다르면 비록 POD와 DEL이 다르다 하더라도 AVL이벤트가 발송되어야 함.\n");	
									} else {
										log.debug("\n edi315Send's rslt_flag : F => AV Event, "+detailVo.getEdiSts()+" status, AV대상  POD와 DEL이 다름 Return\n");	
										modifySceEdiHisDtl("F", "AV Event, AV대상  POD와 DEL이 다름 Return", detailVo);
										continue;
									}
								} else if(detailVo.getEdiSts().matches("A([CFOV]){1}N") && detailVo.getPodNodCd().equalsIgnoreCase(detailVo.getDelNodCd())) { // ACN, AFN, AON, AVN
									log.debug("\n edi315Send's rslt_flag : F => AV Event, "+detailVo.getEdiSts()+" status, AV대상  POD와 DEL이 동일함 Return\n");						
									modifySceEdiHisDtl("F", "AV Event, AV대상  POD와 DEL이 동일함 Return", detailVo);
									continue;
								}
								// retrieve AV event date/yard info
								Edi315CurrInfoVO vo = dbDao.getAVEventDtYard(org_sts,sendVo.getEventYard(), sendVo.getEventDt(), sendVo.getBkgNo(), detailVo.getCopNo(), detailVo.getEdiSts());
								if(vo != null) {
									if(!"Y".equals(sendVo.getManFlg())) { // skip when manual
										// 1. if org_sts_cd = CU & edi_sts = ARN then 
										// 1.1.    check send_result with ARN/curr_event_yard
										//
										// 2. if org_sts_cd = ARN & edi_sts = CU then
										// 2.1.    check org_event_yard is curr_event_yard
										// 2.2.    check send_result with CU/none
										log.debug("******************************************************************************");
										log.debug("************* org_sts               : " + org_sts);
										log.debug("************* detailVo.getEdiSts()  : " + detailVo.getEdiSts());
										log.debug("************* sendVo.getEventYard() : " + sendVo.getEventYard());
										log.debug("************* vo.getCurrEventYard() : " + vo.getCurrEventYard());
										log.debug("******************************************************************************");
										if((org_sts.equalsIgnoreCase("CU") || org_sts.equalsIgnoreCase("CR"))
												&& !detailVo.getEdiSts().equalsIgnoreCase(org_sts) 
												&& dbDao.getPreSendRsltCountByNod(org_sts, sendVo.getBkgNo(), sendVo.getCntrNo(), vo.getCurrEventYard()) < 1) {
											log.debug("\n edi315Send's rslt_flag : F => AV Event, AV & CU Error Return\n");						
											modifySceEdiHisDtl("F", "AV Event, AV & CU Error Return", detailVo);
											continue;
										}else if(!(org_sts.equalsIgnoreCase("CU") || org_sts.equalsIgnoreCase("CR")) 
												&& sendVo.getEventYard().substring(0, 5).equalsIgnoreCase(vo.getCurrEventYard().substring(0, 5)) 
												&& dbDao.getPreSendRsltCountByNod(org_sts, sendVo.getBkgNo(), sendVo.getCntrNo(), null) < 1) {
											log.debug("\n edi315Send's rslt_flag : F => AV Event, AV none CU Error Return\n");						
											modifySceEdiHisDtl("F", "AV none CU Error Return", detailVo);
											continue;
										}else if(!(org_sts.equalsIgnoreCase("CU") || org_sts.equalsIgnoreCase("CR"))
												&& !sendVo.getEventYard().substring(0, 5).equalsIgnoreCase(vo.getCurrEventYard().substring(0, 5))) {
											log.debug("\n edi315Send's rslt_flag : F => AV Event, AV none CU different Node Error Return\n");						
											modifySceEdiHisDtl("F", "AV Event, AV none CU different Node Error Return", detailVo);
											continue;
										}
									}
									
									log.debug("\n edi315Send's rslt_flag : S => AV Event, AV대상 eventYard가 존재\n");
									currVo = vo;
								} else { 
									log.debug("\n edi315Send's rslt_flag : F => AV Event, AV대상 eventYard가 미존재 Return\n");						
									modifySceEdiHisDtl("F", "AV Event, AV대상 eventYard가 미존재 Return", detailVo);
									continue;
								}
							} else if("640".equals(detailVo.getEdiCgoRmk())) { // AG Event
								// retrieve AG event date/yard info
								Edi315CurrInfoVO vo = dbDao.getAGEventDtYard(detailVo.getCopNo());
								
								if(vo != null) {
									currVo = vo;
								} else {
									log.debug("\n edi315Send's rslt_flag : F => AG Event, AG대상 eventYard가 미존재 Return\n");						
									modifySceEdiHisDtl("F", "AG Event, AG대상 eventYard가 미존재 Return", detailVo);
									continue;
								}
							} else {
								//VE-> VDL,VDT 의 발송 케이스가 아닌 경우.
								//SCE_EDI_MNG_STS, SCE_EDI_MNG_AMS_STS 테이블 참고.
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
								log.debug("\n currVo 입력 \n org_sts != edi_sts 케이스 : org_sts : ("+org_sts+") edi_sts : (" +edi_sts+")"+
										  "\n currVo.toString() : "+currVo.toString());
							}
						}else{
							//org_sts = edi_sts 인 경우.
							currVo.setCurrEventDt  (sendVo.getEventDt());
							currVo.setCurrEventYard(sendVo.getEventYard());
							currVo.setCurrCopDtlSeq(sendVo.getCopDtlSeq());
							if ("AMS".equals(sendVo.getCallFrom())) {
								currVo.setCurrVvd(detailVo.getTrunkVvd());
							}
							log.debug("\n currVo 입력\n org_sts = edi_sts 케이스 : org_sts : ("+org_sts+") edi_sts : (" +edi_sts+")"+
									  "\n currVo.toString() : "+currVo.toString());
						}
						
						//2010-03-16 오현경 추가. UVD 발생시 VAD 발생 안한 경우 EDI 전송하는 케이스 있는데 currEventDt가 null 임
						if(currVo.getCurrEventDt() == null || currVo.getCurrEventDt().length() < 12){
							currVo.setCurrEventDt(sendVo.getEventDt());
						}
						//2016-05-18 최초 이벤트의 발생 시각과 비교하여 최근 시각을 적용
						log.debug("\n EVENT DATE SETTING : " + currVo.getCurrEventDt());
						if(currVo.getCurrEventDt() != null && sendVo.getEventDt().compareTo(currVo.getCurrEventDt()) > 0) {
							currVo.setCurrEventDt(sendVo.getEventDt());
							log.debug("\n EVENT DATE SETTING : NEW DATE " + currVo.getCurrEventDt());
						}
	
						
						
						
						
						
						
				
//-----2-2.currVo VVD------------------------------------------------------------------------------------------------------						
						
						
						
						
						
						
						currVvdVo = getCurrVvdInfo(currVo.getCurrEventYard(), detailVo);
						if (currVvdVo != null) {
							log.debug("\n currVvdVo.toString()------ \n"+currVvdVo.toString());
							currVo.setCurrVvd(currVvdVo.getCurrVvd());
							currVo.setCurrBound(currVvdVo.getBound());
							currVo.setLloydCd(currVvdVo.getLloydCd());
							currVo.setVslCntCd(currVvdVo.getVslCntCd());
							currVo.setVslNm(currVvdVo.getVslNm());
							
							if(currVo.getCurrCopDtlSeq()==null || "".equals(currVo.getCurrCopDtlSeq())){
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
						
//-----3-1.Skip edi_grp_cd------------------------------------------------------------------------------------------------------
						/* 화주 별 Validation 확인. */
						boolean chain_result2 = checkEdiGroupValidation(sendVo, detailVo, currVo);
						if (!chain_result2) {
							continue;
						}
						
//-----4.FF 생성------------------------------------------------------------------------------------------------------						

						String rslt_flag="C";
						String rslt_remark = "";
						//1. 원래 화면에서 Save 된 경우[sendVo.getLogFlg()]
						//2. SCE_EDI_MNG_STS 테이블에서 발송시 Save Flag 확인[detailVo.getLogFlg()]
						if (!"Y".equals(sendVo.getLogFlg()) 
								&& "N".equals(detailVo.getLogFlg())) {
								
							/* 1. Flat File 생성, 2. 발송, 3. Logging */
							rslt_flag = createFlatFile(sendVo, detailVo, currVo);
							
							log.debug("\n createFlatFile's rslt_flag : "+rslt_flag+"\n");						
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
							
							log.debug("\n save 케이스 : currVo.toString() : \n"+currVo.toString());
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
		}  catch (DAOException e) {
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
			HashMap<String, String> valuesOfNoInfo = searchNodInformation((String) nvl(currVo.getCurrEventYard())); //NYK ITEM 추가 LOC_NM, CNT_CD, STE_CD (igkim 20141127)
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
			//String bl_nbr = (String) nvl(dtlVo.getBlNo()) + (String) nvl(dtlVo.getBlTpCd()); // Added By Kim Jin-seung In 2010.10.13.
			String bl_nbr = (String) nvl(dtlVo.getBlNo()); // Modified In 2016.04.29.
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
			
			// GLOVIS 315
			if("GV00000001".equals(dtlVo.getEdiGrpCd())) {
				HashMap<String,String> hmap = searchGlovisBlNo(dtlVo.getBkgNo().trim());
				if(hmap != null) {
					bl_nbr = (String)hmap.get("FM_BKG_NO");
				}
			}


			// 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에  BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 추가
			String bl_crt_dt = null;// Added By Kim Jin-seung In 2010.10.13.
			String bkg_crt_dt = null; // Added By Kim Jin-seung In 2010.10.13.
			String bkg_cfm_dt = null; // Added By Kim Jin-seung In 2010.10.13.

//*2014.12.10 00460 NYK 확정후 조건 후 추가 변경 가능 IGKIM 			
//*			if("00460".equals(dtlVo.getEdiGrpCd())
//*					|| "60".equals(dtlVo.getEdiGrpCd())
//*					|| "COM02029".equals(dtlVo.getEdiGrpCd())
//*					){  
	
				HashMap<String,String> hashMap2 = searchAdidasBlBkgDate(dtlVo.getBkgNo().trim());
				if ( hashMap2 !=null ){
					bl_crt_dt = (String)hashMap2.get("BL_CRT_DT");
					bkg_crt_dt = (String)hashMap2.get("BKG_CRT_DT");
					bkg_cfm_dt = (String)hashMap2.get("BKG_CFM_DT");
					hashMap2 = null;
				}
//*			}
			
			
			
			String manFlag = sendVo.getManFlg();
			String event_dt = currVo.getCurrEventDt();
			String rslt_flag = "Y";


			String refCustCode = "  000000".equals(dtlVo.getCustNo()) ? (String) nvl(dtlVo.getScNo())  : (String) nvl(dtlVo.getCustNo());
			String selNbr = valuesOfPoSealInfo.get("CNMV_SEAL_NO");

			//String wallmart_count = "";

			String custEdate = getCustEDate(dtlVo.getEdiGrpCd(),dtlVo.getCopRailChkCd(), dtlVo.getCopNo(),dtlVo.getPodCd());

			String itNbr = "";
//*2014.12.10 00460 NYK 확정후 조건 후 추가 변경 가능 IGKIM 			
//*			if((  "USA00132".equals(dtlVo.getEdiGrpCd())
//*				||"USA00196".equals(dtlVo.getEdiGrpCd())
//*				||"USA00130".equals(dtlVo.getEdiGrpCd())//<-- 2010.05.07 [CHM-201003677] 반영 완료
//*				)	&& "UVD".equals(dtlVo.getEdiSts())){
				itNbr = getItNoTemp(dtlVo.getBlNo(),currVo.getCurrEventYard());
//*			}
			String custAdate =     (String) nvl(getCustAdateNewVersion(currVo.getCurrEventYard(), dtlVo.getBlNo()).get("CUST_ADATE"));
			String custAdateGmt = (String) nvl(getCustAdateNewVersion(currVo.getCurrEventYard(), dtlVo.getBlNo()).get("CUST_ADATE_GMT"));

			// 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout
			String itNbrDt = "";
			String inbondNbr = "";
			String inbondNbrDt = "";
			
			//2015.01.05 item add
			String cnbondNbr = "";
			String cnrailbillNbr = "";
			
			String firmsCode = "";
			
			String[] result = getInbondNbrDtItNbrDt(dtlVo.getBkgNo());
			
			//2015.01.05 item add (CNBOND_NBR,CN_RAILBILL_NBR)
			String[] cnResult = getCNRailInbondAndBillNbr(dtlVo.getBkgNo(),dtlVo.getCntrNo());
			
			String pkup_Firms = getPickUpFirmsCode(dtlVo.getBkgNo());
			inbondNbr	= result[0];
			inbondNbrDt	= result[1];
			itNbrDt		= result[2];
			//firmsCode	= result[0];
			
			cnbondNbr   = cnResult[0];
			cnrailbillNbr = cnResult[1];
			
			firmsCode	= pkup_Firms;

			String pickUpNbr = getPickUpNo(dtlVo.getEdiGrpCd(),dtlVo.getEdiSts(), dtlVo.getCntrNo(),dtlVo.getBkgNo(), currVo.getCurrEventDt());
			currVo.setPickUpNo((String) nvl((pickUpNbr),""));

			RlyPortVO rlyPortVo = new RlyPortVO();
			rlyPortVo = getRlyPortInfo(dtlVo,currVo);
			
			/*******************************************************************/
			/* USA00132 - HobbyLobby에 대하여 NFR전송시  */ 
			/* event date - 1day, 시간은23:59로 fix. */
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM 	
//*			if ("USA00132".equals(dtlVo.getEdiGrpCd()) && "NFR".equals(dtlVo.getEdiSts())&& !"Y".equals(sendVo.getManFlg())) {
//*				String temp_evnt_dt = getHobbyLobbyDateTime(substr(event_dt, 0, 8),"235900");//
//*				event_dt = temp_evnt_dt;
//*				currVo.setCurrEventDt(temp_evnt_dt);
//*				// currVo.setCurrEventDt(v_temp_evnt_dt);
//*			}

			/*
			 * interval에 값이 있을 경우 예약을 해야 하기 때문에 하기 로직 수행 전송하지 않고 전송 시간이 되기 전까지
			 * 예약해 놓는다.(이후 로직에서 실행) Manual로 전송 하는 sts에 대해서는 적용 제외 20080211 -
			 * ihjang
			 */
			String edi_snd_itval_hr = dtlVo.getEdiSndItvalHrmnt();
			if (!"0".equals(edi_snd_itval_hr) && !"".equals(edi_snd_itval_hr) &&!"Y".equals(manFlag)) {
				log.debug("\n Reserved Case !! edi_snd_itval_hr : "+edi_snd_itval_hr+"\n currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
				rslt_flag = "R";
				dtlVo.setEdiSndItvalHrmnt(edi_snd_itval_hr);
				currVo.setCurrEventDt(getReservedEventDt(event_dt,edi_snd_itval_hr));
				log.debug("\n 2nd currVo.getCurrEventDt() : "+currVo.getCurrEventDt());
			} 
			dtlVo.setRsltFlg(rslt_flag);
			
			/*
			* NYK EDI ITEM 추가 
			* TRANS_MODE 구하기 edi 추가 20141127 igkim
			*/			
			String trans_mode = "";
			//2015.05.28 Modify
			ArrayList<String> tList = new ArrayList<String>();
			tList.add("EE");			tList.add("OAO");			tList.add("FOTYDO");			tList.add("FOTSDO");			tList.add("FOTRDO");
			tList.add("FOTMDO");		tList.add("IO");			tList.add("FOTYAD");			tList.add("FOTMAD");			tList.add("IN");
			tList.add("FITSAD");		tList.add("OAN");			tList.add("FITMDO");			tList.add("FITYDO");			tList.add("FITRDO");
			tList.add("D");				tList.add("MT");
			
			ArrayList<String> rList = new ArrayList<String>();
			rList.add("ALO");			rList.add("RLO");			rList.add("ARO");			rList.add("URO");			rList.add("FOTRAD");
			rList.add("FITRAD");		rList.add("ALN");			rList.add("RLN");			rList.add("ARN");			rList.add("URN");
			
			ArrayList<String> vList = new ArrayList<String>();
			vList.add("AEL");			vList.add("VDE");			vList.add("VDL");			vList.add("VE");			vList.add("VETS");
			vList.add("VAT");			vList.add("VBT");			vList.add("UVT");			vList.add("AET");			vList.add("VET");
			vList.add("VDT");			vList.add("VAD");			vList.add("VBD");			vList.add("UVD");
			
			if(tList.contains(msgid)){
				trans_mode = "T";
			}
			if(rList.contains(msgid)){
				trans_mode = "R";
			}
			if(vList.contains(msgid)){
				trans_mode = "V";
			}
			
			//2015.07.21 NYK Parent TRANS_MODE 구하기
			trans_mode = this.getTransModeByActivityInd(dtlVo.getBkgNo(), dtlVo.getEdiGrpCd(), dtlVo.getCntrNo(), dtlVo.getOrgEdiSts(), dtlVo.getCopNo(), currVo.getCurrEventYard());
			log.debug("\n### getTransModeByActivityInd trans_mode ["+trans_mode+"]");
			/*
			if ( "EE".equals(msgid) 
			    || "OA".equals(msgid)
			    || "I".equals(msgid)
			    || "D".equals(msgid)
			    || "MT".equals(msgid)){
			    	trans_mode = "T";
			} else if ("EE".equals(msgid) 
			    || "AE".equals(msgid)
			    || "VD".equals(msgid)
			    || "VA".equals(msgid)
			    || "VE".equals(msgid)
			    || "UV".equals(msgid)){
			    	trans_mode = "V";
			} else if ("EE".equals(msgid) 
			    || "AL".equals(msgid)
			    || "RL".equals(msgid)
			    || "AR".equals(msgid)			    
			    || "UR".equals(msgid)){
					trans_mode = "R";
			}
			*/
			// 2014.11.27 NYK EDI ITEM 추가 IGKIM (VSK_VSL_PORT_SKD.OB_CSSM_VOY_NO, VSK_VSL_PORT_SKD.IB_CSSM_VOY_NO)
			//String ob_cssm_voy_no = "";
			String ib_cssm_voy_no = "";
			//[2015.05.29]
			//HashMap<String,String> hashMap3 = searchCssmVoyNo( dtlVo.getToVsl(), dtlVo.getToDir() , dtlVo.getToVoyage() , currVo.getCurrEventYard());
			String currToVsl = StringUtils.substring(currVo.getCurrVvd(), 0, 4);
			String currToDir = StringUtils.substring(currVo.getCurrVvd(), 4, 8);
			String currToVoyage = StringUtils.substring(currVo.getCurrVvd(), 8, 9);
			
			log.debug("\n searchCssmVoyNo Call  currVO.getCurrVvd : ["+currVo.getCurrVvd()+"]");
			log.debug("\n searchCssmVoyNo Call  currToVsl : ["+currToVsl+"]");
			log.debug("\n searchCssmVoyNo Call  currToDir : ["+currToDir+"]");
			log.debug("\n searchCssmVoyNo Call  currToVoyage : ["+currToVoyage+"]");
			
			HashMap<String,String> hashMap3 = searchCssmVoyNo( currToVsl, currToVoyage, currToDir ,  currVo.getCurrEventYard());
			if ( hashMap3 !=null ){
				//ob_cssm_voy_no = (String)hashMap3.get("OB_CSSM_VOY_NO");
				ib_cssm_voy_no = (String)hashMap3.get("IB_CSSM_VOY_NO");
				hashMap3 = null;
			}
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM 						
/*			String main0 = 
	                "SNDID : "              + host_tp_id                                      + CHR10
	            +   "RCVID : "              + rcvid                                           + CHR10
	            +   "322ID : "              + id322                                           + CHR10
	            +   "MSGID : "              + msgid                                           + CHR10
	            +   "TRANS_MODE : "         + trans_mode                                      + CHR10
	            +   "VIP_GRP_ID : "         + vip_grp_id                                      + CHR10
	            +   "BL NBR : "             + bl_nbr                                          + CHR10
	            +   "BKG NBR : "            + bkg_nbr                                         + CHR10
	            +   "TO VSL CODE : "        + dtlVo.getToVsl()                       + CHR10
	            +   "TO VOYAGE : "          + dtlVo.getToVoyage()                    + CHR10
	            +   "TO_CONSORT_VOY_NO : "  + ob_cssm_voy_no                         + CHR10
	            +   "TO DIR : "             + dtlVo.getToDir()                       + CHR10
	            +   "VSL NAME : "           + vsl_name                                        + CHR10
	            +   "VSL CNTR CODE : "      + vsl_cntr_code                                   + CHR10;
			*/
			// Added By Kim Jin-seung In 2010.10.13.
//*2014.12.10 00460 NYK 확정후 조건 후 추가 변경 가능 IGKIM 			
//*			if("00460".equals(dtlVo.getEdiGrpCd())
//*					|| "60".equals(dtlVo.getEdiGrpCd())
//*					|| "COM02029".equals(dtlVo.getEdiGrpCd())
//*					){  
//2015.05.21 	ob_cssm_voy_no > ib_cssm_voy_no 변경.		
			StringBuilder main0 = new StringBuilder().append( 
	                	        "SNDID : "              ).append( host_tp_id                                      ).append( CHR10
		            ).append(   "RCVID : "              ).append( rcvid                                           ).append( CHR10
		            ).append(   "322ID : "              ).append( id322                                           ).append( CHR10
		            ).append(   "MSGID : "              ).append( msgid                                           ).append( CHR10
		            ).append(   "SUP_RMK : "            ).append( dtlVo.getEdiCgoRmk()                            ).append( CHR10
		            ).append(   "TRANS_MODE : "         ).append( trans_mode                                      ).append( CHR10
		            ).append(   "VIP_GRP_ID : "         ).append( vip_grp_id                                      ).append( CHR10
		            ).append(   "BL_NBR : "             ).append( bl_nbr                                          ).append( CHR10
		            ).append(   "BL_CRT_DT : "          ).append( bl_crt_dt                                       ).append( CHR10
		            ).append(   "BKG_NBR : "            ).append( bkg_nbr                                         ).append( CHR10
		            ).append(   "BKG_CRT_DT : "         ).append( bkg_crt_dt                                      ).append( CHR10
		            ).append(   "BKG_CFM_DT : "         ).append( bkg_cfm_dt                                      ).append( CHR10
		            ).append(   "TO_VSL_CODE : "        ).append( dtlVo.getToVsl()                       		  ).append( CHR10
		            ).append(   "TO_VOYAGE : "          ).append( dtlVo.getToVoyage()                    		  ).append( CHR10
		            ).append(   "TO_CONSORT_VOY_NO : "  ).append( ib_cssm_voy_no                         		  ).append( CHR10
		            ).append(   "TO_DIR : "             ).append( dtlVo.getToDir()                       		  ).append( CHR10
		            ).append(   "VSL_NAME : "           ).append( vsl_name                                        ).append( CHR10
		            ).append(   "VSL_CNTR_CODE : "      ).append( vsl_cntr_code                                   ).append( CHR10);
				
//*			}
			
			
			
			Edi315PrefixMainCOPInfoVO           listm1 = searchCOPInfo(edi315SOpts);
			
            /* CHM-201002317 화주 USA00204  UV이후 ATA actual mapping 이루어지지 않았으면 podata 정보 공백으로 처리
             * searchCopInfo를 여러번 호출하므로 값을 edi315SOpts에 정의함(주석처리)
             * */
//*2014.12.10 00460 NYK 확정후 조건 후 추가 변경 가능 IGKIM 			
//*			if("USA00204".equals(dtlVo.getEdiGrpCd())){
			
//*				SceCopDtlVO dtlVO = getVADActualMappingInfo(dtlVo.getCopNo());
//*				if(dtlVO != null && currVo.getCurrCopDtlSeq() != null && currVo.getCurrCopDtlSeq().length() ==4  && "0".equals(dtlVO.getActDt())
//*							&& Integer.parseInt(currVo.getCurrCopDtlSeq()) >= Integer.parseInt(dtlVO.getCopDtlSeq())){
//*					listm1.setPodAta("");
//*					listm1.setPodAtaGmt("");					
//*				}
//*			}			
			
			/********************************************************************************/
			/* CHM-201002970 판토스 CT EDI 전송 누락 관련 보완 로직 추가 요청 판토스  2010-03-11 ohk */
			/* CUST GRP ID : ASA00120 */
			/* 화주 ASA00120에 대해 POD=BEANR, DEL=BEANR, NLRTM에서 T/S되고 2ND VVD가 없는 것은 IC 발생시 VAD로 EDI 전송 */
			/* VAD 이후 발생 event에서 PODATA정보를 IC 발생시의 EVENT_DT 정보로  넣어줌 */
			/********************************************************************************/
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM 
//*			if("ASA00120".equals(dtlVo.getEdiGrpCd()) && currVo.getIsPodAtaReplace() != null && "Y".equals(currVo.getIsPodAtaReplace())){
//*				listm1.setPodAta(currVo.getPodAtaEventDt()!= null && currVo.getPodAtaEventDt().length() > 12 ? currVo.getPodAtaEventDt().substring(0,12) : currVo.getPodAtaEventDt());
//*				listm1.setPodAtaGmt(currVo.getPodAtaEventDtGmt()!= null && currVo.getPodAtaEventDtGmt().length() > 12 ? currVo.getPodAtaEventDtGmt().substring(0,12) : currVo.getPodAtaEventDtGmt());		
//*			}			
			
			if(sendVo.getVdlByCntrAttach() != null && "Y".equals(sendVo.getVdlByCntrAttach())){
				listm1.setPolAtd   (currVo.getCurrEventDt().substring(0, 12));
				
				String currEventDtGmt = getGmtDt(currVo.getCurrEventDt(),currVo.getCurrEventYard());
				listm1.setPolAtdGmt(currEventDtGmt.substring(0, 12));
			}
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM			
//*			if("COM01382".equals(dtlVo.getEdiGrpCd()) &&
//*			    "UVD".equals(dtlVo.getOrgEdiSts()) && 
//*			    "VAD".equals(dtlVo.getEdiSts())){
//*				currVo.setCurrEventDt(listm1.getPodEta());
//*			}
			
//*			if("COM01382".equals(dtlVo.getEdiGrpCd()) &&
//*				"VDL".equals(dtlVo.getOrgEdiSts()) &&
//*				"AEL".equals(dtlVo.getEdiSts())){
//*				
//*				GetEvntDtVO evntDtVo = getEvntDt(dtlVo);
//*				currVo.setCurrEventDt(evntDtVo.getEstmDt());
			
//*			}
			
			
			listm1.setYdNm(dbDao.getYdNm(dtlVo));
			
			
			if( listm1.getPorCode()==null || "".equals(listm1.getPorCode()) ||
				listm1.getPolCode()==null || "".equals(listm1.getPolCode()) ||
				listm1.getPodCode()==null || "".equals(listm1.getPodCode()) ||
				listm1.getDelCode()==null || "".equals(listm1.getDelCode())){
				dtlVo.setSndSkipFlg("Y");//Send Skip 
				dtlVo.setRsltFlg("S");   //Send Skip 
			}
			
			StringBuilder strCopInfo = new StringBuilder().append( 
					"POR_NAME : "           ).append( listm1.getPorName()			).append("\n").append(
			        "POR_CODE : "           ).append( listm1.getPorCode()			).append("\n").append(
			        "POR_AMSQUAL : "        ).append( listm1.getPorAmsqual()		).append("\n").append(
			        "POR_AMSPORT : "        ).append( listm1.getPorAmsport()		).append("\n").append(
			        "PORETD : "             ).append( listm1.getPorEtd()			).append("\n").append(
			        "PORETD_GMT : "         ).append( listm1.getPorEtdGmt()			).append("\n").append(
			        "PORATD : "             ).append( listm1.getPorAtd()			).append("\n").append(
			        "PORATD_GMT : "         ).append( listm1.getPorAtdGmt()			).append("\n").append(
			        "POL_NAME : "           ).append( listm1.getPolName()			).append("\n").append(
			        "POL_CODE : "           ).append( listm1.getPolCode()			).append("\n").append(
			        "POL_AMSQUAL : "        ).append( listm1.getPolAmsqual()		).append("\n").append(
			        "POL_AMSPORT : "        ).append( listm1.getPolAmsport()		).append("\n").append(
			        "POLETA : "             ).append( listm1.getPolEta()			).append("\n").append(
			        "POLETA_GMT : "         ).append( listm1.getPolEtaGmt()			).append("\n").append(
			        "POLATA : "             ).append( listm1.getPolAta()			).append("\n").append(
			        "POLATA_GMT : "         ).append( listm1.getPolAtaGmt()			).append("\n").append(
			        "POLETD : "             ).append( listm1.getPolEtd()			).append("\n").append(
			        "POLETD_GMT : "         ).append( listm1.getPolEtdGmt()			).append("\n").append(
			        "POLATD : "             ).append( listm1.getPolAtd()			).append("\n").append(
			        "POLATD_GMT : "         ).append( listm1.getPolAtdGmt()			).append("\n").append(
			        "POD_NAME : "           ).append( listm1.getPodName()			).append("\n").append(
			        "POD_CODE : "           ).append( listm1.getPodCode()			).append("\n").append(

			//2012.07.09 박찬민 [CHM-201218837] F/F 상에 Terminal Name		
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM				
//*			if("COM02364".equals(dtlVo.getEdiGrpCd())&& ("VA".equals(dtlVo.getCustEdiStsCd())|| "VD".equals(dtlVo.getCustEdiStsCd())|| "AG".equals(dtlVo.getCustEdiStsCd()))){
//*				strCopInfo = strCopInfo +			        
					"POD_TML_CODE : "		).append( dtlVo.getPodNodCd()			).append("\n").append(
					"POD_TML_NAME : "       ).append( listm1.getYdNm()				).append("\n").append(
//*			}        
			        "POD_AMSQUAL : "        ).append( listm1.getPodAmsqual()		).append("\n").append(
			        "POD_AMSPORT : "        ).append( listm1.getPodAmsport()		).append("\n").append(
			        "PODETA : "             ).append( listm1.getPodEta()			).append("\n").append(
			        "PODETA_GMT : "         ).append( listm1.getPodEtaGmt()			).append("\n").append(
			        "PODATA : "             ).append( listm1.getPodAta()			).append("\n").append(
			        "PODATA_GMT : "         ).append( listm1.getPodAtaGmt()			).append("\n").append(
			        "PODETD : "             ).append( listm1.getPodEtd()			).append("\n").append(
			        "PODETD_GMT : "         ).append( listm1.getPodEtdGmt()			).append("\n").append(
			        "PODATD : "             ).append( listm1.getPodAtd()			).append("\n").append(
			        "PODATD_GMT : "         ).append( listm1.getPodAtdGmt()			).append("\n");

				// 2011.08.25 이경원 [CHM-201112880] 삼성전자 315 Event 코드 추가 및 정의변경
				// 그룹코드가 삼성전자(Group ID: ASA00130)와 계열사 Green Logistics (Group ID: ASA00419)
				// 일때 Flat File PODETB, PODETB_GMT, PODATB, PODATB_GMT 필드 추가
				// 2011.10.12 이경원 [CHM-201113828] [삼성SDS] 신규 TP ID (Tracking) 셋업 요청
				// 그룹코드 삼성SDS(Group ID: 
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM					
//*			    if ("ASA00130".equals(dtlVo.getEdiGrpCd())
//*				 || "ASA00419".equals(dtlVo.getEdiGrpCd())
//*				 || "ASA00471".equals(dtlVo.getEdiGrpCd())) {			        
					Edi315PrefixMainCOPInfoVO vo1 = searchPodEtbAtbDate(edi315SOpts);		
					if (vo1 == null) {
						strCopInfo.append(
						"PODETB : "														).append("\n").append(
					    "PODETB_GMT : "													).append("\n").append(
						"PODATB : "														).append("\n").append(
						"PODATB_GMT : "													).append("\n");
					} else {
						strCopInfo.append(
						"PODETB : "				).append(  vo1.getPodEtb()				).append("\n").append(
						"PODETB_GMT : "			).append(  vo1.getPodEtbGmt()			).append("\n").append(
						"PODATB : "				).append(  vo1.getPodAtb()				).append("\n").append(
						"PODATB_GMT : "			).append(  vo1.getPodAtbGmt()			).append("\n");
					}
//*			    }
					strCopInfo.append(
			        "DEL_NAME : "           ).append( listm1.getDelName()			).append("\n").append(
			        "DEL_CODE : "           ).append( listm1.getDelCode()			).append("\n").append(
			        "DEL_AMSQUAL : "        ).append( listm1.getDelAmsqual()		).append("\n").append(
			        "DEL_AMSPORT : "        ).append( listm1.getDelAmsport()		).append("\n").append(
			        "DELETA : "             ).append( listm1.getDelEta()			).append("\n").append(
			        "DELETA_GMT : "         ).append( listm1.getDelEtaGmt()			).append("\n").append(
			        "DELATA : "             ).append( listm1.getDelAta()			).append("\n").append(
			        "DELATA_GMT : "         ).append( listm1.getDelAtaGmt()			).append("\n");
			    
			
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

			StringBuilder mainMiddle0 = new StringBuilder().append(
		                    "FRD_NAME : "           ).append( valuesOfFrdInfo.get("FRD_NAME")        		).append( CHR10
		        ).append(   "FRD_CODE : "           ).append( valuesOfFrdInfo.get("FRD_CODE")        		).append( CHR10
		        ).append(   "FRDETA : "             ).append( valuesOfFrdInfo.get("FRDETA")          		).append( CHR10
		        ).append(   "FRDETA_GMT : "         ).append( valuesOfFrdInfo.get("FRDETA_GMT")      		).append( CHR10
		        ).append(   "RLY_NAME : "           ).append( nvl(rlyPortVo.getRlyName()			, "")   ).append( CHR10
		        ).append(   "RLY_CODE : "           ).append( nvl(rlyPortVo.getRlyPort()			, "")   ).append( CHR10
		        ).append(   "RLY_AMSQUAL : "        ).append( nvl(rlyPortVo.getRlyAmsqual()			, "")   ).append( CHR10
		        ).append(   "RLY_AMSPORT : "        ).append( nvl(rlyPortVo.getRlyAmsport()			, "")   ).append( CHR10
		        ).append(   "W_UNIT : "             ).append( nvl(valuesOfBkgQtyInfo.get("W_UNIT")	, "")   ).append( CHR10
		        ).append(   "WEIGHT : "             ).append( nvl(valuesOfBkgQtyInfo.get("WEIGHT")	, "")   ).append( CHR10
		        ).append(   "MEA_UNIT : "           ).append( nvl(valuesOfBkgQtyInfo.get("MEA_UNIT"), "")   ).append( CHR10
		        ).append(   "MEA_QTY : "            ).append( nvl(valuesOfBkgQtyInfo.get("MEA_QTY")	, "")   ).append( CHR10
		        ).append(   "P_UNIT : "             ).append( nvl(valuesOfBkgQtyInfo.get("P_UNIT")	, "")   ).append( CHR10
		        ).append(   "PACKAGE : "            ).append( nvl(valuesOfBkgQtyInfo.get("PACKAGE")	, "")	).append( CHR10);
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM			
//*			if("ASA00435".equals(dtlVo.getEdiGrpCd())){
			if(searchCntrWeightInfoVO != null) {
				mainMiddle0.append(
				        	"CNTR_W_UNIT : "		).append( nvl(searchCntrWeightInfoVO.getWgtUtCd()	, "")).append(CHR10
                ).append(	"CNTR_WEIGHT : "		).append( nvl(searchCntrWeightInfoVO.getCntrWgt()	, "")).append(CHR10
                ).append(	"CNTR_MEA_UNIT : "		).append( nvl(searchCntrWeightInfoVO.getMeasUtCd()	, "")).append(CHR10
                ).append(	"CNTR_MEA_QTY : "		).append( nvl(searchCntrWeightInfoVO.getMeasQty()	, "")).append(CHR10
                ).append(	"CNTR_P_UNIT : "		).append( nvl(searchCntrWeightInfoVO.getPckTpCd()	, "")).append(CHR10
                ).append(	"CNTR_PACKAGE : "		).append( nvl(searchCntrWeightInfoVO.getPckQty()	, "")).append(CHR10);
			} else {
				mainMiddle0.append(
							"CNTR_W_UNIT : "		).append(CHR10
                ).append(	"CNTR_WEIGHT : "		).append(CHR10
                ).append(	"CNTR_MEA_UNIT : "		).append(CHR10
                ).append(	"CNTR_MEA_QTY : "		).append(CHR10
                ).append(	"CNTR_P_UNIT : "		).append(CHR10
                ).append(	"CNTR_PACKAGE : "		).append(CHR10);
			}
//*			}
				

			StringBuilder mainMiddle1 = new StringBuilder().append( 
         		            "CNTR_NBR : "           ).append( dtlVo.getCntrNo()                        	).append( CHR10
		        ).append(   "CNTR_TYPE : "          ).append( dtlVo.getCntrTpszCd()                  	).append( CHR10);
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM			        
//*		    if("TRADIANT".equals(dtlVo.getCustTpId())){
//*					mainMiddle1 = mainMiddle1     
			if(searchCntrWeightInfoVO != null) {
				mainMiddle1.append(
							"RD_FLAG : "	        ).append(  searchCntrWeightInfoVO.getRdCgoFlg()	 	).append( CHR10);
			} else {
				mainMiddle1.append(
							"RD_FLAG : "	        													 ).append( CHR10);
			}
//*		    }
			mainMiddle1.append(
							"F/M_IND : "            ).append( dbDao.getCopDtlActCd(dtlVo.getCopNo(), dtlVo.getEdiSts(), sendVo.getEventYard()).substring(0, 1) ).append( CHR10);
			
			//2015.07.21 NYK Add
			//정책1. EDI GRP ID : H100000001, 322ID : UVD 일때 'AV' Message 추가 전송 및 해당 파일 생성시 아래 로직 추가
			//정책2. DEL과 POD의 LOCATION CODE(POD_CODE, DEL_CODE)가 동일 해야 함.
			//정책3. 6개의 LOCATION CODE(“USSAV” or “USNYC” or “USLAX” or “USLGB” or “USTIW” or “USSEA”) 중 하나인 경우
			//'AV' 이벤트로 전송될 때 F/F의 Event Time을 기존 데이터에서 1분 추가 하는 로직이 
			//2015.08.25 NYK Add 
			//EDI GRP ID : P500000001  추가.
			List<String> locList = new ArrayList<String>();
			locList.add("USSAV");
			locList.add("USNYC");
			locList.add("USLAX");
			locList.add("USLGB");
			locList.add("USTIW");
			locList.add("USSEA");
			
			log.debug("\n### EVENT_DATE Check ###"
					+ "\n getEdiGrpCd ["+dtlVo.getEdiGrpCd()+"]"
					+ "\n msgid ["+msgid+"]"
					+ "\n getCustEdiStsCd ["+dtlVo.getCustEdiStsCd()+"]"
					+ "\n getEdiSts ["+dtlVo.getEdiSts()+"]"
					+ "\n getPodCode ["+listm1.getPodCode()+"]"
					+ "\n getDelCode ["+listm1.getDelCode()+"]"
					+ "\n getCurrEventDt ["+currVo.getCurrEventDt()+"]");
			
			// 2016.03.10 specify AV,AG Event process
			// 1. 'AV' 관련 로직 추가
			// POD(POD_NOD_CD.SCE_COP_HDR)와 SCE_COP_DTL에서 ACT_CD가 FIRRAD,FIWMAD 인 NOD_CD 앞 다섯자리가 다르면 가 FIRRAD,FIWMAD의 Event 정보 사용.
			// 2. 'AG'
			// DLV Term 이 'Y' 이면 MAX(FI%%DO) 직전 Sequence의 Event location, Event Date 적용
			// DLV Term 이 'D' 이면 MAX(FI%%DO)  Sequence의 Event location, Event Date 적용
			// DLV Term은 BKG_BOOKING의 DE_TERM_CD 으로 비교.

			StringBuilder eventDateInfo = new StringBuilder().append(
					                            "EVENT_DATE : "         ).append( currVo.getCurrEventDt().substring(0, 12) 	            ).append( CHR10
									).append(   "EVENT_DATE_GMT : "     ).append( getEventDtGmt(sendVo)                                 ).append( CHR10);
			
			StringBuilder eventLocInfo = new StringBuilder().append(
					                            "EVENT_LOC : "          ).append( nvl(currVo.getCurrEventYard()					, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_NAME : "     ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_NAME")   	, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_AMSQUAL : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSQUAL")	, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_AMSPORT : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSPORT") 	, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_CITY_NM : "  ).append( nvl(valuesOfNoInfo.get("LOC_NM") 				, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_CNT_CD : "   ).append( nvl(valuesOfNoInfo.get("CNT_CD") 				, "")   ).append( CHR10
							        ).append(   "EVENT_LOC_STAT_CD : "  ).append( nvl(valuesOfNoInfo.get("STE_CD") 				, "")   ).append( CHR10);
			
			if(("H100000001".equals(dtlVo.getEdiGrpCd()) || "P500000001".equals(dtlVo.getEdiGrpCd())) && "AV".equals(id322) && 
					StringUtils.isNotEmpty(listm1.getPodCode()) && listm1.getPodCode().equals(listm1.getDelCode()) && 
					locList.contains((String)listm1.getPodCode())) {
				String parsePattern = "yyyyMMddHHmmss";
				String eventDate = "";
				String eventDateGmt = "";
				
				if(StringUtils.isNotEmpty(currVo.getCurrEventDt())) {
					Date date = this.parseDate(currVo.getCurrEventDt(), parsePattern);
					log.debug("\n### parseDate 11 ["+DateFormatUtils.format(date, parsePattern)+"]");
					
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(12, 1); // 1분을 더한다.
					date = c.getTime();
					
					log.debug("\n### parseDate 22 ["+DateFormatUtils.format(date, parsePattern)+"]");
					eventDate = DateFormatUtils.format(date, parsePattern);
					
					Edi315SendVO sendVo2 = new Edi315SendVO();
					sendVo2.setEventYard(sendVo.getEventYard());
					sendVo2.setEventDt(eventDate);
					
					eventDateGmt = getEventDtGmt(sendVo2);
					currVo.setCurrEventDt(eventDate);
				}
				
				log.debug("### EVENT_DATE [H100000001][AV] Pod/Del["+listm1.getPodCode()+"]/["+listm1.getDelCode()+"] \nEVENT_DATE ["+eventDate.substring(0, 12)+"] \nEVENT_DATE_GMT ["+eventDateGmt+"]");
				eventDateInfo = new StringBuilder().append(   "EVENT_DATE : "         ).append( eventDate.substring(0, 12) 	  		).append( CHR10)
					                               .append(   "EVENT_DATE_GMT : "     ).append( eventDateGmt			            ).append( CHR10);
				
			} else if("AV".equals(id322)) {
//				HashMap<String, String> nodInfoMap = null;
//				Edi315SendVO sVo = null;
//				// retrieve AV event date/yard info
//				Edi315CurrInfoVO vo = dbDao.getAVEventDtYard(dtlVo.getCopNo());
//				
//				if(vo != null) {
//					if(!currVo.getCurrEventYard().substring(0,5).equalsIgnoreCase(vo.getCurrEventYard().substring(0,5))) {
//						log.debug("\n createFlatFile's rslt_flag : F => AV Event, currentEventYard와 AV대상 eventYard가 불일치 Return\n");						
//						modifySceEdiHisDtl("F", "AV Event, currentEventYard와 AV대상 eventYard가 불일치 Return", dtlVo);
//						return "F";
//					}
//					currVo = vo;
//					// retrieve event yard info
//					nodInfoMap = searchNodInformation((String) nvl(vo.getCurrEventYard()));
//					// convert event date to GMT date
//					sVo = new Edi315SendVO();
//					sVo.setEventDt(vo.getCurrEventDt());
//					sVo.setEventYard(vo.getCurrEventYard());
//				} else {
//					vo = currVo;
//					nodInfoMap = valuesOfNoInfo;
//					sVo = sendVo;
//				}
				
				eventDateInfo = new StringBuilder().append(   "EVENT_DATE : "        ).append( currVo.getCurrEventDt().substring(0, 12) 	  		).append( CHR10)
						                           .append(   "EVENT_DATE_GMT : "    ).append( getEventDtGmt(sendVo)                     			).append( CHR10);
				
				eventLocInfo = new StringBuilder().append(   "EVENT_LOC : "          ).append( nvl(currVo.getCurrEventYard()				, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_NAME : "     ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_NAME")   	, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_AMSQUAL : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSQUAL")	, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_AMSPORT : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSPORT") 	, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_CITY_NM : "  ).append( nvl(valuesOfNoInfo.get("LOC_NM") 			, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_CNT_CD : "   ).append( nvl(valuesOfNoInfo.get("CNT_CD") 			, "")   ).append( CHR10
												 ).append(   "EVENT_LOC_STAT_CD : "  ).append( nvl(valuesOfNoInfo.get("STE_CD") 			, "")   ).append( CHR10);
				
			} else if("AG".equals(msgid)) {
//				HashMap<String, String> nodInfoMap = null;
//				Edi315SendVO sVo = null;
//				// retrieve AG event date/yard info
//				Edi315CurrInfoVO vo = dbDao.getAGEventDtYard(dtlVo.getCopNo());
//				
//				if(vo != null) {
//					currVo = vo;
//					// retrieve event yard info
//					nodInfoMap = searchNodInformation((String) nvl(vo.getCurrEventYard()));
//					// convert event date to GMT date
//					sVo = new Edi315SendVO();
//					sVo.setEventDt(vo.getCurrEventDt());
//					sVo.setEventYard(vo.getCurrEventYard());
//				} else {
//					vo = currVo;
//					nodInfoMap = valuesOfNoInfo;
//					sVo = sendVo;
//				}
				
				eventDateInfo = new StringBuilder().append(   "EVENT_DATE : "         ).append( currVo.getCurrEventDt().substring(0, 12) 	  		).append( CHR10
					        					  ).append(   "EVENT_DATE_GMT : "     ).append( getEventDtGmt(sendVo)                     			).append( CHR10);
				
				eventLocInfo = new StringBuilder().append(   "EVENT_LOC : "          ).append( nvl(currVo.getCurrEventYard()				, "")   ).append( CHR10
												).append(   "EVENT_LOC_NAME : "     ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_NAME")   	, "")   ).append( CHR10
												).append(   "EVENT_LOC_AMSQUAL : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSQUAL")	, "")   ).append( CHR10
												).append(   "EVENT_LOC_AMSPORT : "  ).append( nvl(valuesOfNoInfo.get("EVENT_LOC_AMSPORT") 	, "")   ).append( CHR10
												).append(   "EVENT_LOC_CITY_NM : "  ).append( nvl(valuesOfNoInfo.get("LOC_NM") 				, "")   ).append( CHR10
												).append(   "EVENT_LOC_CNT_CD : "   ).append( nvl(valuesOfNoInfo.get("CNT_CD") 				, "")   ).append( CHR10
												).append(   "EVENT_LOC_STAT_CD : "  ).append( nvl(valuesOfNoInfo.get("STE_CD") 				, "")   ).append( CHR10);
			}
			
			
			mainMiddle1.append(eventDateInfo	        
			          ).append(   "CUST_REF_NO : "        ).append( getCustRefNoCtnt(dtlVo.getBkgNo(), "EBRF")           	).append( CHR10
			          ).append(   "LLOYD_CODE : "         ).append( nvl(valuesOfVessleInfo.get("VSL_LLOYD_NO")		, "")   ).append( CHR10	
			          ).append(eventLocInfo
			          ).append(   "PO_NBR : "             ).append( nvl(getBkgPoNo(dtlVo.getBkgNo())				, "  ") ).append( CHR10
			          ).append(   "BL_PO_NBR : "          ).append( nvl(getBkgPoNo(dtlVo.getBkgNo())				, "  ") ).append( CHR10);
			
			
			
			Edi315PrefixMainBkgCustInfoVO       listm2 = searchBkgCustInfo(edi315SOpts);
			StringBuilder strBkgCustInfo = new StringBuilder().append(
                        	"SHPRCODE : "           ).append( listm2.getShprcode()		).append("\n"
	            ).append(	"SHPR1 : "              ).append( listm2.getShpr1()			).append("\n"
	            ).append(	"SHPR2 : "              ).append( listm2.getShpr2()			).append("\n"
	            ).append(	"SHPR3 : "              ).append( listm2.getShpr3()			).append("\n"
	            ).append(	"SHPR4 : "              ).append( listm2.getShpr4()			).append("\n"
	            ).append(	"SHPR5 : "              ).append( listm2.getShpr5()			).append("\n"
	            ).append(	"SHPR_CITY_NM : "       ).append( listm2.getShprCityNm()	).append("\n"
	            ).append(	"SHPR_STAT_CD : "       ).append( listm2.getShprStatCd()	).append("\n"
	            ).append(	"SHPR_ZIP_CD : "        ).append( listm2.getShprZipCd()		).append("\n"
	            ).append(	"SHPR_CNT_CD : "        ).append( listm2.getShprCntCd()		).append("\n"
	            ).append(	"CNEECODE : "           ).append( listm2.getCneecode()		).append("\n"
	            ).append(	"CNEE1 : "              ).append( listm2.getCnee1()			).append("\n"
	            ).append(	"CNEE2 : "              ).append( listm2.getCnee2()			).append("\n"
	            ).append(	"CNEE3 : "              ).append( listm2.getCnee3()			).append("\n"
	            ).append(	"CNEE4 : "              ).append( listm2.getCnee4()			).append("\n"
	            ).append(	"CNEE5 : "              ).append( listm2.getCnee5()			).append("\n"
	            ).append(	"CNEE_CITY_NM : "       ).append( listm2.getCneeCityNm()	).append("\n"
	            ).append(	"CNEE_STAT_CD : "       ).append( listm2.getCneeStatCd()	).append("\n"
	            ).append(	"CNEE_ZIP_CD : "        ).append( listm2.getCneeZipCd()		).append("\n"
	            ).append(	"CNEE_CNT_CD : "        ).append( listm2.getCneeCntCd()		).append("\n"
	            ).append(	"NTFYCODE : "           ).append( listm2.getNtfycode()		).append("\n"
	            ).append(	"NTFY1 : "              ).append( listm2.getNtfy1()			).append("\n"
	            ).append(	"NTFY2 : "              ).append( listm2.getNtfy2()			).append("\n"
	            ).append(	"NTFY3 : "              ).append( listm2.getNtfy3()			).append("\n"
	            ).append(	"NTFY4 : "              ).append( listm2.getNtfy4()			).append("\n"
	            ).append(	"NTFY5 : "              ).append( listm2.getNtfy5()			).append("\n"
	            ).append(	"NTFY_CITY_NM : "       ).append( listm2.getNtfyCityNm()	).append("\n"
	            ).append(	"NTFY_STAT_CD : "       ).append( listm2.getNtfyStatCd()	).append("\n"
	            ).append(	"NTFY_ZIP_CD : "        ).append( listm2.getNtfyZipCd()		).append("\n"
	            ).append(	"NTFY_CNT_CD : "        ).append( listm2.getNtfyCntCd()		).append("\n");
            
			
			
			
			
			StringBuilder mainEnd = new StringBuilder().append(
        		            "REF_CUSTCODE : "       	).append( refCustCode                                   ).append( CHR10
		        ).append(   "INV_NBR : "            	).append( getSonyInvNo(dtlVo.getBkgNo())           		).append( CHR10
		        ).append(   "RD_TERM : "            	).append( valuesOfBkgTerm.get("RD_TERM")                ).append( CHR10
		        ).append(   "CUST_EDATE : "         	).append( custEdate                                     ).append( CHR10
		        ).append(   "CUST_EDATE_GMT : "     	).append( ""                                            ).append( CHR10
		        ).append(   "CUST_ADATE : "         	).append( custAdate                                     ).append( CHR10
		        ).append(   "CUST_ADATE_GMT : "     	).append( custAdateGmt                                  ).append( CHR10
		        ).append(   "CURRENT_VVD : "        	).append( nvl(currVo.getCurrVvd(), "")          		).append( CHR10
		        ).append(   "CURRENT_CONSORT_VOY_NO : " ).append( ib_cssm_voy_no                    			).append( CHR10
		        ).append(   "CURRENT_VSL_NM : "     	).append( nvl(currVo.getVslNm(), "")            		).append( CHR10
		        ).append(   "CURRENT_VSL_CNT_CD : " 	).append( nvl(currVo.getVslCntCd(), "")         		).append( CHR10
		        ).append(   "CURRENT_LLOYD_CD : "   	).append( nvl(currVo.getLloydCd(), "")          		).append( CHR10
		        ).append(   "SEL_NBR : "            	).append( (String) nvl(selNbr)                          ).append( CHR10
		        ).append(   "LANE : "               	).append( valuesOfBkgTerm.get("SLAN_CD")                ).append( CHR10
		        ).append(   "LANE_DESC : "          	).append( valuesOfBkgTerm.get("VSL_SLAN_NM")            ).append( CHR10
		        ).append(   "SC_NBR : "             	).append( valuesOfBkgTerm.get("SC_NO")                  ).append( CHR10
		        ).append(   "IT_NBR : "             	).append( itNbr                                         ).append( CHR10
//*		        // 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout -------------
		        ).append(   "IT_NBR_DT : "				).append( itNbrDt										).append( CHR10
		        ).append(   "INBOND_NBR : "				).append( inbondNbr										).append( CHR10
		        ).append(   "INBOND_NBR_DT : "			).append( inbondNbrDt									).append( CHR10
		        
		        //2015.01.05 CN BOND NBR , CN RAILBILL NBR
		        ).append(   "CNBOND_NBR : "		    	).append( cnbondNbr										).append( CHR10
		        ).append(   "CN_RAILBILL_NBR : "		).append( cnrailbillNbr									).append( CHR10
		        
		        ).append(   "PICKUP_NBR : "         	).append( pickUpNbr                                     ).append( CHR10
		        
//*		        // 2011.06.01 [CHM-201110581-01] Item Addition On 315 FFLayout -------------
		        ).append(   "FIRMS_CODE : "         	).append( firmsCode										).append( CHR10
		        
		        ).append(   "SH_REF_NBR : "         	).append( getCustRefNoCtnt(dtlVo.getBkgNo(), "EBSH")	).append( CHR10
		        ).append(   "FW_REF_NBR : "         	).append( getCustRefNoCtnt(dtlVo.getBkgNo(), "EBFF")    ).append( CHR10
		        ).append(   "CN_REF_NBR : "         	).append( getCustRefNoCtnt(dtlVo.getBkgNo(), "EBRF")    ).append( CHR10
		        ).append(   "CP_REF_NBR : "         	).append( getCustRefNoCtnt(dtlVo.getBkgNo(), "ESRF")    ).append( CHR10
//*				//2010-06-22 : YJLEE : [CHM-201004143] HP 화주(USA00051) 에 대해 DG IND : prefix 를 추가 하여 DG 화물은 Y, 그 외는 N으로 생성. 
//*		        if("USA00051".equals(dtlVo.getEdiGrpCd())){		        
		        ).append(   "DG_IND : "             	).append(  nvl(dtlVo.getDcgoFlg(), "") 					).append( CHR10) ;
//*		        }
	        String cutOffTime = searchCutOffTime(dtlVo.getBkgNo().trim());
	        mainEnd.append(   "CUTOFF_TM : "          ).append(  nvl(cutOffTime, "") ).append( CHR10 
   		          ).append(   "PARTNER_OFFICE : "     ).append(  dtlVo.getEdiGrpCd() ).append( CHR10) ;
			
			// 2010.10.26 김진승 [CHM-NotSet] Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에  Multi Booking No., BL No. 추가처리
			// // 2010.10.26 김진승  cust_trd_prnr_id = ‘6111470101’ => edi group code = 'USA00094' 뿐
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM			
//*			 if ("USA00094".equals(dtlVo.getEdiGrpCd()) ){
				
				String[][] multiResultArray = null; // Added By Kim Jin-seung In 2010.10.26
				String[] multiResult = null; // Added By igkim 20141127
				String[][] multiResultArraySealNo = null; // Added By igkim 20141127
				
				multiResultArray = searchPrtlBkgsForEdiGrp(dtlVo.getBkgNo().trim(), dtlVo.getCntrNo());

				StringBuilder tempmainEnd = new StringBuilder("");
				if (multiResultArray!=null && multiResultArray.length>0){
					for(int i=0; i<multiResultArray.length; i++){
						tempmainEnd.append("{MULTI_BKG_NBR"									).append(CHR10);
						tempmainEnd.append("MULTI_BKG_NBR : ").append(multiResultArray[i][0]).append(CHR10);
						tempmainEnd.append("}MULTI_BKG_NBR"									).append(CHR10);
					}
					for(int i=0; i<multiResultArray.length; i++){
						tempmainEnd.append("{MULTI_BL_NBR"									).append(CHR10);
						tempmainEnd.append("MULTI_BL_NBR : ").append(multiResultArray[i][1] ).append(CHR10);
						multiResult = searchBkgHblNo(dtlVo.getBkgNo().trim());  //added by igkim 20141127
						if (multiResult != null && multiResult.length>0) {
							tempmainEnd.append("{MULTI_HBL_NBR"									).append(CHR10);						
							for(int j=0; j <multiResult.length; j++) {
								tempmainEnd.append("MULTI_HBL_NBR : ").append(multiResultArray[i]).append(CHR10);
							}
							tempmainEnd.append("}MULTI_HBL_NBR"									).append(CHR10);
						}
						tempmainEnd.append("}MULTI_BL_NBR"									).append(CHR10);
					}
					// add by igkim 20141127 seal number
					multiResultArraySealNo = searchCntrSealNo(dtlVo.getBkgNo().trim(), dtlVo.getCntrNo());
					if (multiResultArraySealNo!=null && multiResultArraySealNo.length>0){
						for(int i=0; i<multiResultArraySealNo.length; i++){
							tempmainEnd.append("{MULTI_SEL_NBR"										).append(CHR10);
							tempmainEnd.append("SEL_NBR : ").append(multiResultArraySealNo[i][0]	).append(CHR10);
							tempmainEnd.append("SEL_NBR_TP : ").append(multiResultArraySealNo[i][1] ).append(CHR10);
							tempmainEnd.append("}MULTI_SEL_NBR"										).append(CHR10);
						}
					}
					mainEnd.append(tempmainEnd);
					//tempmainEnd = null;
				}				
//*			} 
			
		


			
			//2010-06-22 : [CHM-201004143] HP 화주(USA00051) 에 대해 DG IND : prefix 를 추가 하여 DG 화물은 Y, 그 외는 N으로 생성. 
			//2014-11-28 : NYK ADD VSL_CONSORT_VOY_NO, VSL_CNT_CD, POL_AMSQUAL1, POL_AMSPORT1, POD_AMSQUAL1, POD_AMSPORT1 . 
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM	1171 line 이동			
//*	        if("USA00051".equals(dtlVo.getEdiGrpCd())){
//*	        	mainEnd = mainEnd + "DG IND : " +  nvl(dtlVo.getDcgoFlg(), "") + CHR10 ;
//*	        }

			String[] keyBkgVvdInfoArray = new String[] {
			        "BVVD1 : "                ,
			        "VSL_CONSORT_VOY_NO : "   ,
			        "VSL_CALLSIGN1 : "        ,
			        "VSL_LLOYDCODE1 : "       ,
			        "VSL_FULLNAME1 : "        ,
			        "VSL_CNT_CD : "           ,
			        "BLPOL1 : "               ,
			        "POL_AMSQUAL1 : "         ,
			        "POL_AMSPORT1 : "         ,
			        "POL_FULLNAME1 : "        ,
			        "BLPOD1 : "               ,
			        "POD_AMSQUAL1 : "         ,
			        "POD_AMSPORT1 : "         ,
			        "POD_FULLNAME1 : "        ,
			        "POLETA1 : "              ,
			        "POLETA1_GMT : "          ,
			        "POLATA1 : "              ,
			        "POLATA1_GMT : "          ,
			        "POLETD1 : "              ,
			        "POLETD1_GMT : "          ,
			        "POLATD1 : "              ,
			        "POLATD1_GMT : "          ,
			        "PODETA1 : "              ,
			        "PODETA1_GMT : "          ,
			        "PODATA1 : "              ,
			        "PODATA1_GMT : "          ,
			        "PODETD1 : "              ,
			        "PODETD1_GMT : "          ,
			        "PODATD1 : "              ,
			        "PODATD1_GMT : "          			   
			        };
			String strBkgVvdInfoHeader = "{BKGVVD" + CHR10;
			String strBkgVvdInfoFooter = "}BKGVVD" + CHR10;
			String[] keyIrgInfoArray = new String[] {
			        "MODE : "                ,
			        "VENDOR : "              ,
			        "FROM_LOC : "            ,
			        "FROM_ARV_DT : "         ,
			        "FROM_ARV_DT_GMT : "     ,
			        "FROM_DPT_DT : "         ,
			        "FROM_DPT_DT_GMT : "     ,
			        "TO_LOC : "              ,
			        "TO_ARV_DT : "           ,
			        "TO_ARV_DT_GMT : "       
			        };
			String strIrgInfoHeader = "{IRG_INFO" + CHR10;
			String strIrgInfoFooter = "}IRG_INFO" + CHR10;

			String prefixV 			= makingPreFix(mergeIntoBkgVvdInfo     (edi315SOpts, dtlVo), strBkgVvdInfoHeader, strBkgVvdInfoFooter, keyBkgVvdInfoArray);
			String prefixI 			= makingPreFix(mergeIntoInLandRouteInfo(edi315SOpts), strIrgInfoHeader   , strIrgInfoFooter   , keyIrgInfoArray);
//			String main_ff = (main0 + strCopInfo + mainMiddle0 + mainMiddle1); // main_ff 와 post_ff 사이에 화주에 따라 prefix 가 달라져서 나눔.
//			String post_ff =  strBkgCustInfo + mainEnd + prefixV + prefixI;
			
			SceFltFileMsgVO ffMsgVo = new SceFltFileMsgVO();
			StringBuilder ediString = new StringBuilder();
			String flt_file_ref_no = "";
			String send_result_flag = "A";
			

			/* Not in case of Walmart */
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM walmart 구분 일단 삭제		
//*			if (!"925485US00".equals(dtlVo.getCustTpId())	|| "Y".equals(wallmart_count)) {
				// !!!!! !!"#In the case of Non-Wall-Mart - case No:0");
				String cntr_po_nbr = valuesOfPoSealInfo.get("CNTR_PO_NBR");
				String bl_store_nbr = valuesOfBkgQtyInfo.get("BL_STORE_NBR");
//				ediString = main_ff 
//								+ "CNTR_PO_NBR : "  + nvl(cntr_po_nbr ,"") + CHR10
//								+ "BL_STORE_NBR : " + nvl(bl_store_nbr,"") + CHR10;
//				
//				ediString = ediString + post_ff;
				ediString.append(main0).append(strCopInfo).append(mainMiddle0).append(mainMiddle1)
						 .append("CNTR_PO_NBR : " ).append(nvl(cntr_po_nbr ,"")		).append(CHR10)
						 .append("BL_STORE_NBR : ").append(nvl(bl_store_nbr,"")		).append(CHR10)
						 .append(strBkgCustInfo).append(mainEnd).append(prefixV).append(prefixI);
				
				//StringBuffer hpSb = new StringBuffer();//2015.04.17 소스 품질 Modify
				//hpSb.append(ediString);//2015.04.17 소스 품질 Modify
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM 			
//*				if ("USA00051".equals(dtlVo.getEdiGrpCd())) {
					//{HPSWA_INFO start
					List<String> hp_refs = getBkgEDIHPRef(dtlVo.getBkgNo());
					if (hp_refs != null) {
						for (int i = 0; i < hp_refs.size(); i++) {
							ediString.append(hp_refs.get(i));
							ediString.append(CHR10);
							//ediString = ediString + hp_refs.get(i) + CHR10;
						}
					}
//*				}
				//ediString = hpSb.toString(); //2015.04.17 소스 품질 Modify
					
				//ediString 에 신규 edi message 를 붙인다.
				//igkim 20141201 CUST_INFO add
				
				//StringBuffer custSb = new StringBuffer();//2015.04.17 소스 품질 Modify
				//custSb.append(ediString);//2015.04.17 소스 품질 Modify
				List<String> cust_info = getBkgEDICustInfo(dtlVo.getBkgNo());
				if (cust_info != null) {
					for (int i = 0; i < cust_info.size(); i++) {
						ediString.append(cust_info.get(i));
						//ediString = ediString + cust_info.get(i);
					}
				}
				//ediString = custSb.toString(); //2015.04.17 소스 품질 Modify
				
				//igkim 20141208 trans_info add
				//String transInfo = searchTransInfo(dtlVo.getBkgNo(),dtlVo.getEdiGrpCd(), dtlVo.getCntrNo(), dtlVo.getCustEdiStsCd(), dtlVo.getCopNo());
				//2015.07.14 NYK Trans Dynamic 처리.
				String transInfo = searchDynamicTransInfo(dtlVo.getBkgNo(),dtlVo.getEdiGrpCd(), dtlVo.getCntrNo(), dtlVo.getCustEdiStsCd(), dtlVo.getOrgEdiSts(), dtlVo.getCopNo(), currVo.getCurrEventYard());
				
				if (transInfo != null){					
					ediString.append(transInfo);
				}
				
				//igkim 20141201 BKG_INFO add
				List<String> bkg_info = getBkgEDIBkgInfo(dtlVo.getBkgNo());
				//2015.04.17 소스 품질 Modify
				//StringBuffer bkgSb = new StringBuffer();
				//bkgSb.append(ediString);
				if (bkg_info != null) {
					for (int i = 0; i < bkg_info.size(); i++) {
						ediString.append(bkg_info.get(i));
						//ediString = ediString + bkg_info.get(i);
					}
				}
				//ediString = bkgSb.toString(); //2015.04.17 소스 품질 Modify
						
				HashMap<String, String> valuesOfFFKey = getSNDSEQ();
				/*String ff_ymmdd  = valuesOfFFKey.get("FF_YMMDD");
				String ff_seq    = valuesOfFFKey.get("FF_SEQ");
				
				flt_file_ref_no = "";
				flt_file_ref_no = "SCM" + ff_ymmdd + lpad(ff_seq, 6, "0");*/
				String ff_referencenumber    = valuesOfFFKey.get("FF_REFERENCENUMBER");
				flt_file_ref_no = "";
				flt_file_ref_no = ff_referencenumber;
				
				send_result_flag = sendProcess( ediString, "", flt_file_ref_no, sendVo, dtlVo, currVo);
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
				log.error("\n VIP315FFNO='"+flt_file_ref_no+"'\n");
				
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
//*			}
			/* In case of Wallmart */
//*2014.12.10 NYK 확정후 조건 후 추가 변경 가능 IGKIM wallmart 구분 삭제 일반사항으로 일단 통합			
/*			
			if ("925485US00".equals(dtlVo.getCustTpId())) {
//				int wal_po_cnt = 0;
				String bl_store_nbr = valuesOfBkgQtyInfo.get("BL_STORE_NBR");
				List wallPoNbrs = getWallPoNbr(dtlVo.getBkgNo(),	dtlVo.getCntrNo());
				
				int wallPoNbrRowCnt = 0;
				if (wallPoNbrs != null) {
					wallPoNbrRowCnt = wallPoNbrs.size();
					log.debug("\n wallPoNbrRowCnt:'"+wallPoNbrRowCnt+"'");
				}

				for (int n = 0; n < wallPoNbrRowCnt; n++) {

					wallmart_count = "N";
					String wallPoNbr = "";
					wallPoNbr = wallPoNbrs.get(n).toString();
					
					ediString = "";
					ediString = main_ff 
									+ "CNTR_PO_NBR : "  + nvl(wallPoNbr, "")   + CHR10
									+ "BL_STORE_NBR : " + nvl(bl_store_nbr, "") + CHR10 ;
					ediString = ediString + post_ff;
					
					//ediString 에 신규 edi message 를 붙인다.
					//igkim 20141201 CUST_INFO add
					List<String> cust_info = getBkgEDICustInfo(dtlVo.getBkgNo());
					if (cust_info != null) {
						for (int i = 0; i < cust_info.size(); i++) {
							ediString = ediString + cust_info.get(i);
						}
					}
					
					//igkim 20141208 trans_info add 
					String transInfo = searchTransInfo(dtlVo.getBkgNo(),dtlVo.getEdiGrpCd(), dtlVo.getCntrNo(), dtlVo.getCustEdiStsCd(), dtlVo.getCopNo());
					if (transInfo != null){
						ediString = ediString + transInfo;
					}
					
					//igkim 20141201 BKG_INFO add
					List<String> bkg_info = getBkgEDIBkgInfo(dtlVo.getBkgNo());
					if (cust_info != null) {
						for (int i = 0; i < cust_info.size(); i++) {
							ediString = ediString + bkg_info.get(i);
						}
					}
					
					String send_result_flag_wall_case = "N";
					HashMap<String, String> valuesOfFFKey = getSNDSEQ();
//					String ff_yymmdd = valuesOfFFKey.get("FF_YYMMDD");
					
					//REFERENCE NUMBER 변경 IGKIM 20141203
					String ff_ymmdd  = valuesOfFFKey.get("FF_YMMDD");
					String ff_seq    = valuesOfFFKey.get("FF_SEQ");
					String ff_referencenumber = valuesOfFFKey.get("FF_REFERENCENUMBER");
					flt_file_ref_no = "";					
					//flt_file_ref_no = "SCM" + ff_ymmdd + lpad(ff_seq, 6, "0");
					flt_file_ref_no = ff_referencenumber;
					

					send_result_flag_wall_case = sendProcess(ediString, wallPoNbr,flt_file_ref_no,
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
										
					
					log.error("\n VIP315FFNO(wallmart)='"+flt_file_ref_no+"'\n");
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
			
*/			



			return send_result_flag;
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (NumberFormatException e) {
			throw new EventException(e.getMessage(), e);
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
	}
	
	

    /**
	 * sendProcess 
	 * MQ발송과 Logging Process.
	 * 
	 * @param StringBuilder ediString
	 * @param String po_nbr
	 * @param String flt_file_ref_no
	 * @param Edi315SendVO sendVo
	 * @param Edi315DetailVO dtlVo
	 * @param Edi315CurrInfoVO currVo
	 * @return String
	 * @exception EventException
	 */
    private String sendProcess(	StringBuilder ediString, 
								String po_nbr, 
								String flt_file_ref_no, 
								Edi315SendVO sendVo,
				                Edi315DetailVO dtlVo,
				                Edi315CurrInfoVO currVo) throws EventException {
		
		//boolean insert_noGen_row = false;
		//boolean insert_sndRslt_row = false;
//		String reString = "";
		String r_flg = "N";
		try {			
			String ff_yymmdd = "1"+flt_file_ref_no.substring(3, 8);
			String ff_seq    = flt_file_ref_no.substring(9, 15);

			String headerStr = "$$$MSGSTART:"
					+ rpad(dtlVo.getHostTpId(), 20, "  ")
					+ rpad(dtlVo.getCustTpId(), 20, "  ")
					+ rpad("315", 10, "  ") + flt_file_ref_no + CHR10
					+ "MUID : " + sysDate() + CHR10;
//			ediString = headerStr + ediString;
			ediString.insert(0, headerStr);
			
			addSceFltFileNoGen(ff_yymmdd, ff_seq, ediString.toString(), sendVo, dtlVo);
			
//			if(ediString.length()>3800){
//				String subEdiString = "!"+ediString.substring(0, 3800);
//				modifySceEdiHisDtlEdiRmk2(subEdiString, dtlVo);
//				
//			}else{
//				modifySceEdiHisDtlEdiRmk2(ediString, dtlVo);
//			}
			log.debug("\n sendEDIMQ dtlVo.getRsltFlg() : "+dtlVo.getRsltFlg()+"\n");
			if( !"R".equals(dtlVo.getRsltFlg()) &&
				!"Y".equals(dtlVo.getSndSkipFlg())){
				r_flg = sendEDIMQ(ediString.toString());
			}else{
				r_flg = dtlVo.getRsltFlg();
			}

			if(!"Y".equals(dtlVo.getSndSkipFlg())){
				addSceEdiSndRslt(ff_yymmdd, ff_seq, flt_file_ref_no, po_nbr, sendVo, dtlVo, currVo);
			}
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return r_flg;
	}
	
    /**
	 * getHobbyLobbyDateTime 
	 * day-1, 23:59 으로 Date 변경 하여 Flat File 생성 한다. 
	 * @param String bkg_no
	 * @param String postfix
	 * @return String
	 * @exception EventException
	 */
    /*private String getHobbyLobbyDateTime(String event_dt,String postfix) throws EventException {
    	try {
    		return dbDao.getHobbyLobbyDateTime(substr(event_dt, 0, 8),postfix);
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
    }*/
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
    /*private GetEvntDtVO getEvntDt(Edi315DetailVO dtlVo) throws EventException {
    	List<GetEvntDtVO> list = null;
    	try {
    		list = dbDao.getEvntDt(dtlVo);
    		
    		return list.get(0);
    		 
    	} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch(Exception ex){
	  		throw new EventException(ex.getMessage(), ex);
	  	}
    }*/
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
			
			currEventDtYdVO =  dbDao.getCurrInfoVoWithIsCurrCopDtl(event_yard, dtlVo.getCopNo(), dtlVo.getEdiSts());
			
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
			log.debug("\n searchCOPInfo delDt : "+delDt.toString()+", delDt.size() : "+delDt.size());
			if(delDt == null || delDt.size()==0){
				int uvd_cnt = dbDao.getUvdCnt(edi315SOpts.getCopNo());
				
				log.debug("\n searchCOPInfo uvd_cd : "+uvd_cnt);
				
				if(uvd_cnt>=2){
					
					delDt   = dbDao.searchCOPInfoDelDtIywd(edi315SOpts);
					log.debug("\n searchCOPInfo delDt(uvd_cnt>=2) : "+delDt.toString()+", delDt.size() : "+delDt.size());
					
				}
			}
			
			
			
			if(por != null && por.size()>0 ){
				ObjectCloner.build(por.get(0),mvo);
				if(por.size()>1){
					log.error("\n 315SendError : por.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPorCode("");
				mvo.setPorName("");
				mvo.setPorAmsport("");
				mvo.setPorAmsqual("");
				log.error("\n 315SendError : por.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}
			
			
			if(pol != null && pol.size()>0 ){
				ObjectCloner.build(pol.get(0),mvo);
				if(pol.size()>1){
					log.error("\n 315SendError : pol.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPolCode(edi315SOpts.getEPolLoc());
				mvo.setPolName("");
				mvo.setPolAmsport("");
				mvo.setPolAmsqual("");
				log.error("\n 315SendError : pol.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(pod != null && pod.size()>0 ){
				ObjectCloner.build(pod.get(0),mvo);
				if(pod.size()>1){
					log.error("\n 315SendError : pod.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPodCode(edi315SOpts.getEPodLoc());
				mvo.setPodName("");
				mvo.setPodAmsport("");
				mvo.setPodAmsqual("");
				log.error("\n 315SendError : pod.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}
			
			
			if(del != null && del.size()==1 ){
				ObjectCloner.build(del.get(0),mvo);
				if(del.size()>1){
					log.error("\n 315SendError : del.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setDelCode("");
				mvo.setDelName("");
				mvo.setDelAmsport("");
				mvo.setDelAmsqual("");
				log.error("\n 315SendError : del.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			
			
			
			
			
			
			
			if(porDt != null && porDt.size()>0 ){
				ObjectCloner.build(porDt.get(0),mvo);
				if(porDt.size()>1){
					log.error("\n 315SendError : porDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setPorEtd("");
				mvo.setPorAtd("");
				mvo.setPorEtdGmt("");
				mvo.setPorAtdGmt("");
				log.error("\n 315SendError : porDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(polDt != null && polDt.size()>0 ){
				ObjectCloner.build(polDt.get(0),mvo);
				if(polDt.size()>1){
					log.error("\n 315SendError : polDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
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
				log.error("\n 315SendError : polDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}
			
			
			if(podDt != null && podDt.size()>0 ){
				ObjectCloner.build(podDt.get(0),mvo);
				if(podDt.size()>1){
					log.error("\n 315SendError : podDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
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
				log.error("\n 315SendError : podDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
			}	
			
			
			if(delDt != null && delDt.size()>0 ){
				ObjectCloner.build(delDt.get(0),mvo);
				if(delDt.size()>1){
					log.error("\n 315SendError : delDt.size()>1 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				}
			}else{
				mvo.setDelEta("");
				mvo.setDelAta("");
				mvo.setDelEtaGmt("");
				mvo.setDelAtaGmt("");
				log.error("\n 315SendError : delDt.size()=0 : bkg_no = "+edi315SOpts.getBkgNo()+", cntr_no = "+edi315SOpts.getCntrNo());
				
			}

			
			
			
			
			
			
			
			
			
			log.debug("\n searchCOPInfo mvo.toString() : \n"+mvo.toString());
			
			
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


	/**
	 * mergeIntoInLandRouteInfo
     * 해당 VO 에 InLandRouteInfo 의 값을 세팅하여 가지고 옮
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<AbstractValueObject>
     * @exception EventException
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
    private List<AbstractValueObject> mergeIntoInLandRouteInfo(Edi315SendOptionsVO edi315SOpts) throws EventException{
		List<AbstractValueObject>  listVobj = null; 
		List<Edi315PrefixIrgInfoVO> list = null;
        try {
	      	  log.debug("mergeIntoInLandRouteInfo is running... in Edi315SendSC");
	      	  log.debug("Cop_NO:" + edi315SOpts.getECopNo());
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
	
	/**
     * 해당 VVD의 SKD를 FLAT FILE에 생성 한다. 
     * @param Edi315SendOptionsVO edi315SOpts
     * @param Edi315DetailVO   dtlVo
     * @return List<AbstractValueObject>
     * @exception EventException
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
    private List<AbstractValueObject> mergeIntoBkgVvdInfo(Edi315SendOptionsVO edi315SOpts, Edi315DetailVO   dtlVo) throws EventException{
		List<AbstractValueObject>  listVobj = null; 
		List<Edi315PrefixBkgVvdVO> list = null;
        try {
	      	  log.debug("sceEdiSendFlatPrc is running... in Edi315SendSC");
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
	    String vsl_consort_voy_no        = "";  //NEW VSL_CONSORT_VOY_NO
	    String vsl_callsign1 			 = "";
	    String vsl_lloydcode1			 = "";
	    String vsl_fullname1 	         = "";
	    String vsl_cnt_cd    	         = "";  //NEW VSL_CNT_CD
	    String blpol1       			 = "";
	    String pol_amsqual1    			 = "";  //NEW POL_AMSQUAL1
	    String pol_amsport1    			 = "";  //NEW POL_AMSPORT1
	    String pol_fullname1 			 = "";
	    String blpod1    				 = ""; 
	    String pod_amsqual1    			 = "";  //NEW POD_AMSQUAL1
	    String pod_amsport1    			 = "";  //NEW POD_AMSPORT1
	    String pod_fullname1			 = ""; 
	    String poleta1     			     = ""; 
	    String poleta1_gmt 			     = ""; 
	    String polata1    				 = ""; 
	    //String polata1_gmt   			 = ""; 
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
	    //String poletd1_tmp		         = ""; 
	    //String poletd1_gmt_tmp	         = ""; 
	    //String podeta1_tmp		         = ""; 
	    //String podeta1_gmt_tmp	         = ""; 
	    String podetd1_tmp		         = ""; 
	    String podetd1_gmt_tmp	         = ""; 
	    
	    int search_vvd_time_info = 0;
	    try {
    	  log.debug("####sceEdiSendFlatPrc in Edi315BCImpl########");
		  List<SearchVvdTimeInformationVO> list = dbDao.searchVvdTimeInformation(edi315SOpts);
		  if(list != null){
			  search_vvd_time_info = list.size();
			  log.debug("INFO:size of search_vvd_time_info - " + search_vvd_time_info);
		  }
		  
		  bkgList = new ArrayList<Edi315PrefixBkgVvdVO>();
		  /*For Statement in main Procedure*/
		  for(int n=0;n<search_vvd_time_info;n++){
			  log.debug("\n vvd cnt:"+n);
			  bvvd1                      = "";
			  vsl_consort_voy_no         = "";  //NEW 
			  vsl_callsign1 			 = "";
			  vsl_lloydcode1			 = "";
			  vsl_fullname1 	         = "";
			  vsl_cnt_cd    	         = "";  //NEW
			  blpol1       			     = "";
			  pol_amsqual1    			 = "";  //NEW POL_AMSQUAL1
			  pol_amsport1    			 = "";  //NEW POL_AMSPORT1
			  pol_fullname1 			 = "";     
			  blpod1    				 = "";
			  pod_amsqual1    			 = "";  //NEW POD_AMSQUAL1
			  pod_amsport1    			 = "";  //NEW POD_AMSPORT1
			  pod_fullname1			     = "";     
			  poleta1     			     = "";   
			  poleta1_gmt 			     = "";   
			  polata1    				 = "";     
			  //polata1_gmt   			 = "";     
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

			  //IF length(bvvd1) = 9 THEN 
			  bvvd1             = valueMap.get("bvvd1"         );
			  vsl_consort_voy_no= valueMap.get("vsl_consort_voy_no");  //NEW
			  vsl_callsign1 	= valueMap.get("vsl_callsign1" );
			  vsl_lloydcode1	= valueMap.get("vsl_lloydcode1");
			  vsl_fullname1 	= valueMap.get("vsl_fullname1" );
			  vsl_cnt_cd    	= valueMap.get("vsl_cnt_cd"    );  //NEW
			  blpol1       		= valueMap.get("blpol1"        );
			  pol_amsqual1 		= valueMap.get("pol_amsqual1"  );  //NEW
			  pol_amsport1 		= valueMap.get("pol_amsport1"  );  //NEW
			  pol_fullname1 	= valueMap.get("pol_fullname1" );
			  blpod1    		= valueMap.get("blpod1"    	   );
			  pod_amsqual1 		= valueMap.get("pod_amsqual1"  );  //NEW
			  pod_amsport1 		= valueMap.get("pod_amsport1"  );  //NEW
			  pod_fullname1		= valueMap.get("pod_fullname1" );
			  poleta1     		= valueMap.get("poleta1"       );
			  poleta1_gmt 		= valueMap.get("poleta1_gmt"   );
			  polata1    		= valueMap.get("polata1"       );
			  //polata1_gmt   	= valueMap.get("polata1_gmt"   );
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
			  log.debug("************* Logic in sceEdiSendFlatPrc : bvvd1 length is greater than 9 ***************");
			    //ELSIF length(bvvd1) < 9 THEN   
				poleta1_tmp      =  poleta1;
				poleta1_gmt_tmp  =  poleta1_gmt;
				//poletd1_tmp      =  poletd1;
				//poletd1_gmt_tmp  =  poletd1_gmt;			
				//podeta1_tmp      =  podeta1;
				//podeta1_gmt_tmp  =  podeta1_gmt;
				podetd1_tmp      =  podetd1;
				podetd1_gmt_tmp  =  podetd1_gmt;
			  }else if(bvvd1 == null || bvvd1.length() < 9){
				log.debug("************* Logic in sceEdiSendFlatPrc : bvvd1 length is less than 9 ***************");
				poleta1          =  poleta1_tmp;
				poleta1_gmt      =  poleta1_gmt_tmp;		
				poletd1          =  podetd1_tmp;
				poletd1_gmt      =  podetd1_gmt_tmp;	
					
					
		            if(bv_lane != null && bv_lane.length() == 3){
			            //IF poleta1 <> '' and poleta1_gmt <> '' THEN
		            	if((poleta1 != null && !"".equals(poleta1) && !" ".equals(poleta1)) && (poleta1_gmt != null && !"".equals(poleta1_gmt) && !" ".equals(poleta1_gmt))){
		            		log.debug("\n bv_lane.length() == 3 \n poleta1='"+poleta1+"'");
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
	            //poletd1_tmp     = ""; 
	            //poletd1_gmt_tmp = "";  
	            
	            //podeta1_tmp     = ""; 
	            //podeta1_gmt_tmp = ""; 
	            podetd1_tmp     = ""; 
	            podetd1_gmt_tmp = ""; 
	            
	            poleta1_tmp      = poleta1;
	            poleta1_gmt_tmp  = poleta1_gmt;
	            //poletd1_tmp      = poletd1;
	            //poletd1_gmt_tmp  = poletd1_gmt;
	            
	            //podeta1_tmp      = podeta1;
	            //podeta1_gmt_tmp  = podeta1_gmt;
	            podetd1_tmp      = podetd1;
	            podetd1_gmt_tmp  = podetd1_gmt;    
			  }

			   log.debug("\n Maching arguments >>> cnt:("+n+")" 
				+"\n   bvvd1 : "+bvvd1+ ":"
				+"\n   vsl_consort_voy_no : "+vsl_consort_voy_no+ ":" 
				+"\n   vsl_callsign1 : "+vsl_callsign1+ ":" 
				+"\n   vsl_lloydcode1 : "+vsl_lloydcode1 + ":" 
				+"\n   vsl_fullname1 : "+vsl_fullname1 + ":" 
				+"\n   vsl_cnt_cd : "+vsl_cnt_cd + ":" 
				+"\n   blpol1 : "+blpol1+ ":" 
				+"\n   pol_amsqual1 : "+pol_amsqual1+ ":" 
				+"\n   pol_amsport1 : "+pol_amsport1+ ":" 
				+"\n   pol_fullname1 : "+pol_fullname1 + ":" 
				+"\n   blpod1 : "+blpod1+ ":" 
				+"\n   pod_amsqual1 : "+pod_amsqual1+ ":" 
				+"\n   pod_amsport1 : "+pod_amsport1+ ":" 
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
			               podatd1      , podatd1_gmt  , vsl_consort_voy_no,
			               vsl_cnt_cd   , pol_amsqual1 , pol_amsport1  ,
			               pod_amsqual1 , pod_amsport1
				);		
				if(lists != null && lists.size() >0) {
					bkgList.add(lists.get(0));
				}
			  
		  }
	} catch (DAOException e) {
			log.error("\n mergeIntoBkgVvdInfoWithLogic, cop_no:"+edi315SOpts.getCopNo());
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
			throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
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
			/*DBRowSet rowset = dbDao.getSndSeq();
			if (rowset != null && rowset.next()) {
				keys_values.put("FF_YYMMDD", rowset.getString("FF_YYMMDD"));
				keys_values.put("FF_YMMDD" , rowset.getString("FF_YMMDD" ));
				keys_values.put("FF_SEQ"   , rowset.getString("FF_SEQ"   ));
			}else{
				log.error("\n VIP315Error : Edi315SendDBDAOGetSndSeqRSQL IS NULL <-- FF No Creation Method");
			}*/
			//REFERENCE NUMBER 변경 IGKIM 20141203 
			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("SCE","SCE_FLT_FILE_NO_GEN_SEQ1");
			keys_values.put("FF_REFERENCENUMBER"   , referenceNumber);
			log.debug("================referenceNumber===================> "+referenceNumber);
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
    /* NOT USED
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
    */
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
			log.debug("\n getRlyPortInfo ---"+
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
					log.debug("\n getCurrBound : OB "+"\n dtlVo.getBkgNo() : "+dtlVo.getBkgNo()
							 +"\n rlyPortVo.toString()"+rlyPortVo.toString());
				}else if ("IB".equals(currVo.getCurrBound())|| 
						"UVD".equals(dtlVo.getEdiSts())||
						"VAD".equals(dtlVo.getEdiSts())){
					rlyPortVo = dbDao.getIbRlyPortInfo(dtlVo.getBkgNo());
					log.debug("\n getCurrBound : IB "+"\n dtlVo.getBkgNo() : "+dtlVo.getBkgNo()
							 +"\n rlyPortVo.toString()"+rlyPortVo.toString());
				}else if ("OC".equals(currVo.getCurrBound())){
					String edi_sts   = dtlVo.getEdiSts();
					String cop_no    = dtlVo.getCopNo();
					String dtl_seq   = currVo.getCurrCopDtlSeq();
					String org_yd_cd = currVo.getCurrEventYard();
					rlyPortVo = dbDao.getOcRlyPortInfo(edi_sts,cop_no,dtl_seq,org_yd_cd);
					log.debug("\n getCurrBound : OC "
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
			log.debug("\n sendEDIMQ's r_flg : "+r_flg);
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
			throw new EventException(e.getMessage(),e);
		}
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
		String man_flg       = sendVo.getManFlg();
		
		String rslt_remark = null;
		String rslt_flag   = null;
		String v_dir_nod   = null;

		int isCount = -1;
		//boolean result_boolean = true;

		log.debug("\n\n\n ##### Checking Parameters #######" + "\n"
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
					log.debug("\n error null");
					String edi_rmk1 = "ErrorNull(cop_dtl_seq)";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}
				if (trunk_vvd == null || trunk_vvd.equals("")) {
					log.debug("\n error null");
					String edi_rmk1 = "ErrorNull(trunk_vvd)";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}
				if (curr_vvd == null || curr_vvd.equals("")) {
					log.debug("\n error null");
					String edi_rmk1 = "curr_vvd";
					modifySceEdiHisDtlEdiRmk1(edi_rmk1, dtlVo);
				}

			}

			log.debug("\n dtlVo.getOrgConti() : "  + dtlVo.getOrgConti()
					+ "\n dtlVo.getDestConti() : " + dtlVo.getDestConti()
					+ "\n dtlVo.getPorCd().substring(0, 2)) : " + dtlVo.getPorCd().substring(0, 2)
					+ "\n dtlVo.getDelCd().substring(0, 2)) : " + dtlVo.getDelCd().substring(0, 2)
					+ "\n\n dtlVo.getOrgContiDesc() : " + dtlVo.getOrgContiDesc()
					+ "\n dtlVo.getDestContiDesc() : "  + dtlVo.getDestContiDesc()
					+ "\n dtlVo.getOrgDestCntDesc() : " + dtlVo.getOrgDestCntDesc()
					+ "\n dtlVo.getDestCntDesc() : "    + dtlVo.getDestCntDesc());

			
			
			
			if (dtlVo.getOrgContiDesc() == null || "".equals(dtlVo.getOrgContiDesc())) {
				log.debug("cgo 테이블의 POR conti와 null");
			} else if (dtlVo.getOrgContiDesc().contains(dtlVo.getOrgConti())) {
				log.debug("cgo 테이블의 POR conti와 일치");
			} else {
				log.debug("cgo 테이블의 POR conti Return");
				rslt_remark = "CGO 테이블 POR Conti 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return false;
			}

			if (dtlVo.getDestContiDesc() == null || "".equals(dtlVo.getDestContiDesc())) {
				log.debug("cgo 테이블의 DEL conti null");
			} else if (dtlVo.getDestContiDesc().contains(dtlVo.getDestConti())) {
				log.debug("cgo 테이블의 DEL conti와 일치");
			} else {
				log.debug("cgo 테이블의 DEL conti Return");
				rslt_remark = "CGO 테이블 DEL Conti 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return false;
			}

			if (dtlVo.getOrgDestCntDesc() == null || "".equals(dtlVo.getOrgDestCntDesc())) {
				log.debug("cgo 테이블의 POR null");
			} else if (dtlVo.getOrgDestCntDesc().contains(dtlVo.getPorCd().substring(0, 2))) {
				log.debug("cgo 테이블의 POR 국가와 일치");
			} else {
				log.debug("cgo 테이블의 POR Return");
				rslt_remark = "CGO 테이블 POR 국가 코드 미 포함으로 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return false;
			}

			if (dtlVo.getDestCntDesc() == null || "".equals(dtlVo.getDestCntDesc())) {
				log.debug("cgo 테이블의 DEL 쪽 null");
			} else if (dtlVo.getDestCntDesc().contains(dtlVo.getDelCd().substring(0, 2))) {
				log.debug("cgo 테이블의 DEL 국가와 일치");
			} else {
				log.debug("cgo 테이블의 DEL Return");
				rslt_remark = "CGO 테이블 DEL 국가 코드 불일치 Return";
				rslt_flag = "F";
				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
				return false;
			}

			
			
			
			
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
						return false;

					} else if ("2".equals(edi_vsl_tp_cd) && trunk_vvd != null
							&& trunk_vvd.equals(curr_vvd)) {
						rslt_remark = "[C04] EdiVslTpCd = 2 Trunk VVD [" + curr_vvd +"]";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return false;
					}
				}
			}

			cop_dtl_seq = dbDao.getCopDtlSeq(cop_no, edi_sts, nod);
			log.debug("\n\n\n ##### Checking Modified Parameters #######" + "\n"
					+ "[cop_dtl_seq]:"	+ cop_dtl_seq	+ "\n"); 
			
			//////////////////////////////////////////////////////////////////////////////
			// 2015.12.11 KSW
			int result_cnt = 0;
			dtlVo.setActCd(dbDao.getCopDtlActCd(cop_no, dtlVo.getEdiSts(), sendVo.getEventYard()));
			log.debug("\n\n\n ##### Checking Parameters #######" + "\n"
					+ "[act_cd]:"	+ dtlVo.getActCd()	+ "\n");
			if("20".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 20 :: Full container received by carrier at origin
				if(dtlVo.getActCd().matches("FO([A-Z]){2}AD|FLWMAD")) { // OPUS ACTIVITY CODE :: FO__AD, FLWMAD
					// check smaller COP_DTL_SEQ exists
					isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N01] First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][EDI_CGO_RMK(MILESTONE CODE) = 20][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
					// check sending history exists
					result_cnt = searchFindEdiSndRslt(edi_group_cd, edi_sts, cust_edi_sts, bkg_no, cntr_no, man_flg);
					if (result_cnt > 0) {
						rslt_remark = "[N02]Send Result exists [Already Sended skip][EDI_CGO_RMK(MILESTONE CODE) = 20][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 20][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("50".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 50 :: Departed from first facility
				if(dtlVo.getActCd().matches("FO([A-Z]){2}DO|FL([VW]){1}MDO")) { // OPUS ACTIVITY CODE :: FO__DO, FLVMDO, FLWMDO
					// check smaller COP_DTL_SEQ exists
					isCount = dbDao.isVvdViewExceptZone(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N01] First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][EDI_CGO_RMK(MILESTONE CODE) = 50][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
					// check sending history exists
					result_cnt = searchFindEdiSndRslt(edi_group_cd, edi_sts, cust_edi_sts, bkg_no, cntr_no, man_flg);
					if (result_cnt > 0) {
						rslt_remark = "[N02]Send Result exists [Already Sended skip][EDI_CGO_RMK(MILESTONE CODE) = 50][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 50][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("60".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 60 :: Arrived at first port of load
				if(dtlVo.getActCd().matches("FOTMAD|FORRAD|FLWMAD")) { // // OPUS ACTIVITY CODE :: FOTMAD, FORRAD, FLWMAD
					// check larger COP_DTL_SEQ exists
					isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N03] Last Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][" + call_from + "][EDI_CGO_RMK(MILESTONE CODE) = 60][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
					// check sending history exists
					result_cnt = searchFindEdiSndRslt(edi_group_cd, edi_sts, cust_edi_sts, bkg_no, cntr_no, man_flg);
					if (result_cnt > 0) {
						rslt_remark = "[N02]Send Result exists [Already Sended skip][EDI_CGO_RMK(MILESTONE CODE) = 60][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 60][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("110".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 110 :: Departed from last port of discharge
				if(dtlVo.getActCd().matches("FIRRDO|FITMDO|FUWMDO")) { // OPUS ACTIVITY CODE :: FIRRDO, FITMDO, FUWMDO
					// check smaller COP_DTL_SEQ exists
					isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N01] First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][EDI_CGO_RMK(MILESTONE CODE) = 110][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
					// check sending history exists
					result_cnt = searchFindEdiSndRslt(edi_group_cd, edi_sts, cust_edi_sts, bkg_no, cntr_no, man_flg);
					if (result_cnt > 0) {
						rslt_remark = "[N02]Send Result exists [Already Sended skip][EDI_CGO_RMK(MILESTONE CODE) = 110][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 110][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("120".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 120 :: Arrived at last facility
				if(dtlVo.getActCd().matches("FIT[^Z]AD|FI[^T]([A-Z]){1}AD")) { // OPUS ACTIVITY CODE :: FI__AD, <> FITZAD
					// check larger COP_DTL_SEQ exists
					isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N03] Last Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][" + call_from + "][EDI_CGO_RMK(MILESTONE CODE) = 120][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 120][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("130".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 130 :: Picked up for delivery at destination
				if(dtlVo.getActCd().matches("FIT([MRY]){1}DO|FIRRDO|FIWMDO|FUWMDO")) { // OPUS ACTIVITY CODE :: FITMDO, FITRDO, FITYDO, FIRRDO, FIWMDO, FUWMDO
					// check larger COP_DTL_SEQ exists
					isCount = dbDao.isVvdView2ExcepZone(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						rslt_remark = "[N03] Last Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][" + call_from + "][EDI_CGO_RMK(MILESTONE CODE) = 130][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 130][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
					modifySceEdiHisDtl("F", rslt_remark, dtlVo);
					return false;
				}
			} else if("470".equals(dtlVo.getEdiCgoRmk())) { // EDI_CGO_RMK(MILESTONE CODE) = 470 :: Arrived at Customs Port of Entry
				if(!dtlVo.getPodNodCd().equals(dtlVo.getDelNodCd())) {
					if(dtlVo.getActCd().matches("FIT([MRYS]){1}AD|FIRRAD|FU([VW]){1}MAD|FIWMAD")) { // OPUS ACTIVITY CODE :: FITMAD, FITRAD, FITYAD, FITSAD, FIRRAD, FUVMAD, FUWMAD, FIWMAD
						// check larger COP_DTL_SEQ exists
						isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
						if (isCount > 0) {
							rslt_remark = "[N03] Last Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "][" + call_from + "][EDI_CGO_RMK(MILESTONE CODE) = 470][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
							modifySceEdiHisDtl("F", rslt_remark, dtlVo);
							return false;
						}
						// check detail NODE is current Event NODE
						String dtl_nod = dbDao.searchCopDtlNod(cop_no, edi_sts, cop_dtl_seq);
						if (dtl_nod == null || !dtl_nod.equals(nod.substring(0, 5))) {
							rslt_remark = "[N04] Event Node Error [Not Equal Event Node][EDI_CGO_RMK(MILESTONE CODE) = 470][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
							modifySceEdiHisDtl("F", rslt_remark, dtlVo);
							return false;
						}
					} else {
						rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 470][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				} else {
					if(dtlVo.getActCd().matches("FIT([MRYS]){1}AD|FIRRAD|FU([VW]){1}MAD|FIWMAD")) { // OPUS ACTIVITY CODE :: FITMAD, FITRAD, FITYAD, FITSAD, FIRRAD, FUVMAD, FUWMAD, FIWMAD
						// check detail NODE is current Event NODE
						String dtl_nod = dbDao.searchCopDtlNod(cop_no, edi_sts, cop_dtl_seq);
						if (dtl_nod == null || !dtl_nod.equals(nod.substring(0, 5))) {
							rslt_remark = "[N04] Event Node Error [Not Equal Event Node][EDI_CGO_RMK(MILESTONE CODE) = 470][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
							modifySceEdiHisDtl("F", rslt_remark, dtlVo);
							return false;
						}
					} else {
						rslt_remark = "[N99]Activity Code Error [Not matched Activity Code][EDI_CGO_RMK(MILESTONE CODE) = 470][OPUS ACTIVITY CODE = "+dtlVo.getActCd()+"]";
						modifySceEdiHisDtl("F", rslt_remark, dtlVo);
						return false;
					}
				}
			}
			//////////////////////////////////////////////////////////////////////////////
			
			/**
			 * customer 가 원하는 status 별 sequence 를 선별 하기 위해서 하기 로직 수행 
			 * 1:first 만 발송, 2:not first 만 발송, 3:last 만 발송, 4:not Last 만 발송, 5:all 모두 발송
			 */
			if ((!"5".equals(edi_event_cd) && edi_event_cd != null)
					&& ("COP".equals(call_from) || "DIR".equals(call_from))) {
				// 1:first 만 발송
				if ("1".equals(edi_event_cd)) {
					if(!"Y".equals(sendVo.getManFlg())){
						if ("COP".equals(call_from)) {
							isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
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
							return false;
						}
					}
				} else if ("2".equals(edi_event_cd) && "COP".equals(call_from)) {
					// 2:not first 만 발송
					isCount = dbDao.isVvdView(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount == 0) {
						rslt_remark = "[C06] Not First Error [" + edi_group_cd+ "][" + edi_sts + "][" +cop_dtl_seq + "]";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return false;
					}

				} else if ("3".equals(edi_event_cd)) {
					// 3:last 만 발송
					if ("COP".equals(call_from)) {
						if ("OAN".equals(edi_sts) && "ID".equals(mvmt_sts)) {
							//COP와 관계없이 마지막으로 인식 
							isCount = 0;
						} else {
							isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
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
						return false;
					}

				} else if ("4".equals(edi_event_cd) && "COP".equals(call_from)) {
					// 4:not Last 만 발송
					isCount = dbDao.isVvdView2(cop_no, cop_dtl_seq, dtlVo.getEdiCgoRmk(), dtlVo.getEdiGrpCd());
					if (isCount > 0) {
						if ("OAN".equals(edi_sts) && "ID".equals(mvmt_sts)) {
							isCount = 0;
						}
					}

					if (isCount == 0) {
						rslt_remark = "[C08] Not last Error [" + edi_group_cd+ "][" + edi_sts + "][" + cop_dtl_seq + "]";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return false;
					}
				}
			}
			return true;
		} catch (DAOException e) {
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
    private boolean checkEdiGroupValidation(Edi315SendVO sendVo, Edi315DetailVO dtlVo, Edi315CurrInfoVO currVo) throws EventException {
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
		String chk_sts 			= null;
		String aaa 				= null;
		String edi_snd_max_dt	= null;


		int i_aln_oan	 	= -1;
		int i_dup_cnt 		= -1;
		int i_de_term_cnt 	= -1;
		int i_oan_rln 		= -1;
		
		int i_pod_oan_cnt   = -1;
		
		boolean result_boolean = true;

		try {	
			log.debug("\n sendVo.getMvmtSts():'"+sendVo.getMvmtSts()+"'");			
			
			if("AD".equals(dtlVo.getEdiSts())){
				if("D".equals(dtlVo.getDeTermCd()) && "OAN".equals(dtlVo.getOrgEdiSts())
						&& sendVo.getMvmtSts() != null && "ID".equals(sendVo.getMvmtSts())){
					aaa="";
				}else if("D".equals(dtlVo.getDeTermCd()) && "Y".equals(sendVo.getManFlg())){
					aaa="";
				}else{
					log.debug("\n AD Send Only ID MVMT ");
					rslt_remark = "AD Send Only Door Term at DEL and ID MVMT";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
					return result_boolean = false;
				}
			}
			
				
//			if("AG".equals(dtlVo.getEdiSts())&& !"D".equals(dtlVo.getDeTermCd())){
//				log.debug("\n AD Send Only ID MVMT ");
//				rslt_remark = "AG Send Only Door Term";
//				rslt_flag = "F";
//				modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//				modifySceEdiHisEdiRmk(rslt_remark, sendVo);
//				return result_boolean = false;
//			}
			
			
			//IF (v_call_from = '322' and edi_sts_tmp = 'NT') THEN  
			//IF (v_cop_sts_cd <> 'F' and v_call_from <> 'MAN') or (v_call_from = 'MAN') THEN   
			if("322".equals(sendVo.getCallFrom()) && "NT".equals(dtlVo.getEdiSts())){
				log.debug("\n 322 : "
						+"\n sendVo.getManFlg() : "+sendVo.getManFlg()
						+"\n dtlVo.getCopStsCd() : "+dtlVo.getCopStsCd()
						);
				if("Y".equals(sendVo.getManFlg())||
						(!"F".equals(dtlVo.getCopStsCd()) && !"Y".equals(sendVo.getManFlg()))){
					log.debug("\n 322 if : ");
					aaa="";
				}else{
					log.debug("\n 322 else : ");
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

			if ("VE".equals(org_edi_sts_cd) && "VD".equals(edi_sts_cd.substring(0, 2)) ) {
				if ("N".equals(edi_auto_snd_flg)) {
					rslt_remark = "No Auto Send VD !!!";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					modifySceEdiHisEdiRmk(rslt_remark, sendVo);
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
			}else{
				log.debug("\n DUP RETURN : " + sendVo.getManFlg());
				//manual 전송이 아닌 경우에 중복 체크 .
				if (sendVo.getManFlg() == null || !"Y".equalsIgnoreCase(sendVo.getManFlg())) {
					log.debug("\n DUP RETURN sendVo.getManFlg():"+sendVo.getManFlg());
					edi_snd_max_dt = dbDao.isDupSndEdi(edi_grp_cd, edi_sts_cd, cust_edi_sts_cd, bkg_no, 
													   cntr_no, event_yard, event_dt, dtlVo.getLogFlg());
					if (edi_snd_max_dt != null) {
						i_dup_cnt = 1;
					}

					if (i_dup_cnt > 0) {
						if ("VE".equals(org_edi_sts_cd) && "VE".equals(edi_sts_cd)) {
							
							//VE 발송 시엔 날짜까지 달라야만 발송.
							if (substr(event_dt, 0, 8).equals(substr(edi_snd_max_dt, 0, 8))) {
								rslt_remark = "DUP RETURN(VE)!!!!(VE 발송 시엔 YYYYMMDD 가 달라야 발송)";
								rslt_flag 	= "F";
								modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
								return result_boolean = false;
							}
							
						} else {
							rslt_remark = "DUP RETURN!!!!";
							rslt_flag 	= "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
						}
					}
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
					&& (StringUtils.isNotEmpty(pod_cd) && !pod_cd.equals(del_cd))) {
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
			/*if ("USA00128".equals(edi_grp_cd)) {
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

			}*/
			
			
			/* 2008-06-25 STATUS 값이 'OAN' 이고 INV_NBR값이 'N'이면 SKIP */
			/*if (("EUR00188".equals(edi_grp_cd)|| 
				 "EUR00189".equals(edi_grp_cd) || 
				 "EUR00190".equals(edi_grp_cd) || 
				 "EUR00191".equals(edi_grp_cd))
				   && "OAN".equals(edi_sts_cd)) {

				inv_nbr = dbDao.isInvNbrValue(bkg_no);
				if (!"Y".equals(nvl(inv_nbr, " "))) {
					rslt_remark = "SONY_CVY_REF_NO : STATUS 값이 OAN이고 INV_NBR값이 N이면 SKIP";
					rslt_flag = "F";

					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
				}
			}*/
			
			/********************************************************************************/
			/* PHILIPS - 화주별 전송 logic 보완 : 2007/11/22 									*/
			/* CUST GRP ID : USA00080 														*/
			/* EDI STS : NFR, FTR 로직 : DEL CNTRY가 US or CA 이며 Rail shipment 인 경우 			*/
			/* EDI STS : NFD, FTD 로직 : 상기 로직에 해당하지 않는 모든 Shipment 인 경우 				*/
			/* 						DEL CNTRY가 US or CA 이지만 Local shipment 인 경우			*/
			/* 						DEL CNTR 가 US, CA 가 아닌 경우 								*/
			log.debug("\n cop_rail_chk_cd : "+cop_rail_chk_cd);
			log.debug("\n edi_sts_cd : "+edi_sts_cd);
			log.debug("\n del_cd : "+del_cd);
			//if ("USA00080".equals(edi_grp_cd)) {
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
			//}
			
			


			/*
			 * 변환 전송에 해당 하는 IN 발생 시 삼성은 UVD, 그 밖의 화주는 IN으로 발송 해야 하므로 아래 로직에서
			 * UVD, IN 케이스 분기. org_edi_sts_cd 와 edi_sts_cd 의 비교를 통해 전송 여부 결정. CSR#
			 * : N200906150140
			 */
			/*if ("IN".equals(org_edi_sts_cd)) {
				if ("ASA00127".equals(edi_grp_cd)
						|| "ASA00128".equals(edi_grp_cd)
						|| "ASA00129".equals(edi_grp_cd)
						|| "USA00036".equals(edi_grp_cd)
						|| "USA00037".equals(edi_grp_cd)
						|| "ASA00130".equals(edi_grp_cd)
						|| "ASA00419".equals(edi_grp_cd)) {

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
						String cnvtFlg = "";
						cnvtFlg = getConvInToUVDFlg(dtlVo);//<- IN -> UVD 케이스가 맞으면 Return Y.
						if ("N".equals(cnvtFlg)) {
							rslt_remark = "IN → UVD 이고, 삼성 이지만 UVD 변환대상 아님.";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
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
			}*/

			/********************************************************************/
			/* NIKE 관련 특화된 전송 logic 보완 - 2007.11.19 */
			/* USA00069, USA00214, USA00133 */
			if ("USA00069".equals(edi_grp_cd) || 
				"USA00214".equals(edi_grp_cd) ||
				"USA00133".equals(edi_grp_cd)) {				
				/* ALN 발생시 동시에 발생하는 OA에 대하여 전송 여부 확인. 이미 전송한 OAN이 있는지 확인 */
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
				
				
				/* RLN은 앞서 ALN 이 발생하지 않았을 경우에만 전송 2008.05.20 IHJANG */
				/* CHM-201002817 USA00069 의 RLN 은 뒤에서 다시 체크하므로 제거  2010.02.23 hkoh */
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
				 
				if ("USA00069".equals(edi_grp_cd) && ("OAN".equals(edi_sts_cd) || "RLN".equals(edi_sts_cd))){
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
				
		

				if ("USA00069".equals(edi_grp_cd)) {
					log.debug("\n 'USA00069'.equals(edi_grp_cd) sendVo.getManFlg() : "+sendVo.getManFlg());
					
					if(  "D".equals(edi_sts_cd)||
						"MT".equals(edi_sts_cd)||
						"FTD".equals(edi_sts_cd)){
						if("Y".equals(sendVo.getManFlg())){
							aaa="";//프로세스 진행
						}else{
							log.debug("\n !!@!@!@ Skip_MT, FTD and D - Manual Send!! : ");
							rslt_remark = "Skip_MT, FTD and D - Manual Send!! : ";
							rslt_flag = "F";
							modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
							return result_boolean = false;
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

			if ("ASA00130".equals(edi_grp_cd)) {
				if ("UVD".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (!pod_cd.equals(del_cd)) {
						rslt_remark = "Skip_UVD_CP012 Samsung ASA00130 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("OAN".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (pod_cd.equals(del_cd)) {
						rslt_remark = "Skip_OAN_CP012 Samsung ASA00130 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			} else if ("ASA00409".equals(edi_grp_cd)) {
				if ("VAD".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (!pod_cd.equals(del_cd)) {
						rslt_remark = "Skip_VAD_CP012 Samsung ASA00409 ITTS!!! : ";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				} else if ("OAN".equals(edi_sts_cd) && "CP012".equals(cust_edi_sts_cd)) {
					if (pod_cd.equals(del_cd)) {
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
			 * 변경전 : - container별 : container별로 각각 전송 
			 * 		   - B/L별 :대표로 한번만 전송, 대표로 한나만 전송한고 나머지는 단순 update 
			 * 변경후 : - 무조건 한번만 전송 
			 * 		   - CNTR, B/L별인지 판단하여 각각 보낼지 대표로 보낼지 구분하여 전송
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
			 */
			log.debug("\n USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP ");
			if ("USA00303".equals(edi_grp_cd)) {
				if ("OAN".equals(edi_sts_cd)) {
					chk_sts = "RLN";
					i_oan_rln = dbDao.getCopOanRln(edi_grp_cd, bkg_no, cntr_no, chk_sts);
					if (i_oan_rln > 0) {
						rslt_remark = "USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}

				if ("RLN".equals(edi_sts_cd)) {
					chk_sts = "OAN";
					i_oan_rln = dbDao.getCopOanRln(edi_grp_cd, bkg_no, cntr_no, chk_sts);
					if (i_oan_rln > 0) {
						rslt_remark = "USA00303 - OAN발생시 RLN, RLN발생시 OAN 전송여부 Check하여 기전송시 SKIP";
						rslt_flag = "F";
						modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
						return result_boolean = false;
					}
				}
			}

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
			
// 2016.10.07 : 김성욱 : 해당 비지니스 없음으로 삭제
//			String v_blocked = "";
//			if (!"Y".equals(sendVo.getManFlg())) {
//				v_blocked = searchIsCargoSmart(dtlVo.getEdiGrpCd(), sendVo.getBkgNo());
//				// v_blocked = 'Y' : edi 전송 Blocking 해야 하는 case.
//				if ("Y".equals(v_blocked)) {
//					rslt_remark = "[CARGOSMART][BLOCKED:bkg_booking.XTER_SI_CD && XTER_BKG_RQST_CD <> 'CSM']";
//					rslt_flag = "F";
//					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
//					return result_boolean = false;
//				}
//			}

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
			if ("USA00094".equals(dtlVo.getEdiGrpCd()) && !("D").equals(dtlVo.getEdiSts()) && !("MT").equals(dtlVo.getEdiSts())){
				
				int resultCnt = dbDao.searchEdiStsForPrtlBkg(dtlVo);
				if (resultCnt > 0) {
					rslt_remark = "USA00094인경우 OAN이후에는 발송불가능(M,DT제외)";
					rslt_flag = "F";
					modifySceEdiHisDtl(rslt_flag, rslt_remark, dtlVo);
					return result_boolean = false;
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
				log.debug("    --#  log by ohk  checkEdiGroupValidation step2  result_boolean:"+result_boolean);
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
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		}
    	
    	log.debug(aaa);
    	
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
		
    	if(list != null && list.size() >0) {
    		for(int j=0;j<list.size();j++) {
		            //Initiating Arguments   	
    				if(null != keyArray) {
		                for(int n=0;n<keyArray.length;n++) {
		                	keyArray[n] = keyArrayOriginal[n];
		                } 	
    				}
                mVo = (AbstractValueObject)(list.get(j));
            	HashMap<String,String> valueMap = mVo.getColumnValues();
    			if(str == null) {
    				if(null != keyArray) { 
    					str = machingPrefixWithVo(keyArray,valueMap);
    					mainStr = strHeader + str + strFooter;
    				}
    			} else {
    				if(null != keyArray) { 
    					mainStr = mainStr + strHeader + machingPrefixWithVo(keyArray,valueMap) + strFooter;
    				}
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
	@SuppressWarnings({ "rawtypes" })
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
    
    /**
     * String > Date 변환.
     * @param d
     * @param pattern
     * @return
     */
	private Date parseDate(String d, String pattern){
		try {
			return DateUtils.parseDate(d, new String[]{pattern});
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**rpad -  오라클의 함수 rpad 와 비슷한 역활을 하는 함수  
     * @param  String oStr
     * @param  int len
     * @param  String padding
     * @return String
     */       
    private String rpad(String oStr,int len,String padding) {
    	StringBuffer strBuff = null;
    	if(oStr != null) {
    		if(oStr.length() > len) {
		        return oStr; 
    		} else {
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
    /*private String lpad(String oStr,int len,String padding){
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
    }*/      
	
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
				  keys_values.put("LOC_NM" ,rowset.getString("LOC_NM" ));	
				  keys_values.put("CNT_CD" ,rowset.getString("CNT_CD" ));	
				  keys_values.put("STE_CD" ,rowset.getString("STE_CD" ));	
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
    private HashMap<String,String> searchPonsealInformation(String bkg_no, String cntr_no) throws EventException {
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
    private HashMap<String,String> getBkgTerm(String bkg_no) throws EventException {
    	try {
    		DBRowSet rowset = dbDao.getBkgTerm(bkg_no);
    		HashMap<String,String> keys_values = new HashMap<String,String>();
    		if(rowset != null && rowset.next()) {
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
    /*
    private String getCustRefNo(String bkg_no)throws EventException{
       try {
 			   String custRefNoCtnt = dbDao.getCustRefNo(bkg_no);
 			   return custRefNoCtnt;
 		} catch (DAOException e) {
 				throw new EventException(e.getMessage(),e);
 	     }     	  
      }
      */
      
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
    /* NOT USED
    private String getShipperRefno(String bkg_no)throws EventException{
  	     try {
			   String shRefNbr = dbDao.getShipperRefno(bkg_no);
			   return shRefNbr;
		 } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	     }     	  
      }
      */
   	  /**getForwardRefno
       * @param    String bkg_no
       * @return   String
       * @throws   EventException
       */ 
    /* NOT USED
    private String getForwardRefno(String bkg_no)throws EventException{
        try {
  			     String fwRefNbr = dbDao.getForwardRefno(bkg_no);
  			     return fwRefNbr;
  		 } catch (DAOException e) {
  				throw new EventException(e.getMessage(),e);
  	     }     	  
      }
      */


    /**getLocPodEta
     * @param    String cop_no
     * @return   String
     * @throws   EventException
     */          
    private String getLocPodEta(String cop_no)throws EventException {
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
    		                     String pod_cd) throws EventException {
    	String cust_edate = "";
    	if("USA00285".equals(edi_grp_cd)) {
    		if("X".equals((String)nvl(substr(cop_rail_chk_cd, 1, 2)," "))) {
    			String localPodEta = getLocPodEta(cop_no);
    			cust_edate  = pod_cd + "/" + localPodEta;
    		} else if("I".equals((String)nvl(substr(cop_rail_chk_cd, 1, 2)," "))) {
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
    private List<String> getRailPodEta(String cop_no) throws EventException {
    	try {
    		DBRowSet rowset = dbDao.getRailPodEta(cop_no);
    		List<String> values = new ArrayList<String>();
    		
    		if(rowset != null && rowset.next()) {
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
    private String getRsltPickNoInfo(String edi_grp_cd, String cntr_no, String bkg_no) throws EventException {
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
    private String searchPickupNumInformation(String cntr_no, String bkg_no) throws EventException {
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
    private String get322PickNoInfo(String cntr_no, String event_dt) throws EventException {
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
    private String searchCuSts(String edi_grp_cd, String cntr_no, String bkg_no) throws EventException {
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

/* 아래 화주 별 max(CRE_DT) SC_EFF_ST_DT SC_EFF_END_DT
 * USA00135	2009/05/30 00:52:17 20080610	20090630
 * USA00136	2008/06/07 00:13:04 20070501	20080430
 * USA00180	2009/06/15 21:36:17 null		null
 * */

    	  /*if( //(inEquation(edi_grp_cd,astr) && "AVN".equals(edi_sts))
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
    			    "USA00226".equals(edi_grp_cd)) && "AVN".equals(edi_sts))){*/
    		  //sce_edi_snd_rslt.pkupEdi322No
    		  pickup_no = getRsltPickNoInfo(edi_grp_cd, cntr_no, bkg_no);
    		  if (pickup_no == null || "".equals(pickup_no)) {
    			  // trs_trsp_so_pkup_cntr.pkupNo
    			  pickup_no = searchPickupNumInformation(cntr_no, bkg_no);
    		  }
		//}
    	  
    	  if(("ALN".equals(edi_sts)||
    		  "RLN".equals(edi_sts)||
    		  "ARN".equals(edi_sts)||
    		  "NT".equals(edi_sts))){ //&&"USA00060".equals(edi_grp_cd)){
    		  
    		  //edi_322_msg.pkupEdi322No
    		  pickup_no = get322PickNoInfo(cntr_no, event_dt);

    		  if(pickup_no == null || "".equals(pickup_no)) {
    			  log.debug("\n trs_trsp_so_pkup_cntr.pkupNo");
    			  //trs_trsp_so_pkup_cntr.pkupNo
    			  pickup_no = searchPickupNumInformation(cntr_no,bkg_no);
    		  }    			  
		  }
    	  log.debug("\n trs_trsp_so_pkup_cntr.pkupNo pickup_no : "+pickup_no);
    	  if (("ALN".equals(edi_sts)||
        	   "ARN".equals(edi_sts)||
        	   "FITRDO".equals(edi_sts))){ //&&"USA00226".equals(edi_grp_cd)) {
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

    /**searchCnmv322RailInfo
     * @param  String cop_no 
     * @param  String edi_grp_cd 
     * @return HashMap<String,String>
     * @throws EventException
     */       
    private HashMap<String,String> searchCnmv322RailInfo(String cop_no,String edi_grp_cd) throws EventException{
    	try {
    		log.debug("\n searchCnmv322RailInfo : " + cop_no + edi_grp_cd);
        	  
    		HashMap<String,String> keys_values = new HashMap<String,String>();
        	  //if("USA00061".equals(edi_grp_cd)){
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
        	  /*}else{
        		  keys_values.put("FRD_NAME"      ,"");
				  keys_values.put("FRD_CODE"      ,"");
				  keys_values.put("FRDETA"        ,"");
				  keys_values.put("FRDETA_GMT"    ,"");	        	 
        	  }*/
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
    		log.debug("BKG_NO : " + bkg_no);
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

   	  /**getWallPoNbr
       * @param  String bkg_no 
       * @param  String cntr_no 
       * @return List<String>
       * @throws EventException
       */       
    /*private List<String> getWallPoNbr(String bkg_no,String cntr_no) throws EventException{
          try {
 	            List   wal_po_nbrs  = dbDao.getWallPoNbr(bkg_no,cntr_no);
			    return wal_po_nbrs;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		   } 
      }*/

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

    /** getCustAdateNewVersion
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

    /**getItNoTemp
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
    		    				) throws EventException {
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
//      private String searchIsCargoSmart(String edi_grp_cd,String bkg_no) throws EventException{
//		  try {
//			  return  dbDao.searchIsCargoSmart(edi_grp_cd,bkg_no);
//	      } catch (DAOException e) {
//	    	  throw new EventException(e.getMessage(),e);
//	      }    	  
//      }

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
      
   	  /**searchFindEdiSndRslt - searchFindEdiSndRslt DBDAO 상 의 레퍼함수
       * @param  String eid_grp_cd
       * @param  String eid_sts_cd
       * @param  String eid_sub_sts_cd
       * @param  String bkg_no
       * @param  String cntr_no
       * @param  String man_flg
       * @return int
       * @throws EventException
       */      
      private int searchFindEdiSndRslt(String eid_grp_cd, String eid_sts_cd, String eid_sub_sts_cd, String bkg_no, String cntr_no, String man_flg) throws EventException {
    	  try {
    		  if(man_flg != null && man_flg.equals("Y")) { // if manual then not check send result
    			  return 0;
    		  }
    		  return  dbDao.searchFindEdiSndRslt(eid_grp_cd, eid_sts_cd, eid_sub_sts_cd, bkg_no, cntr_no);
	      } catch (DAOException e) {
			  throw new EventException(e.getMessage(),e);
	      }    	  
      }
      
   	  /**getBaseNos - BKG_NO BL_NO CNTR_NO COP_NO 를 가지고 오는 함수
       * @param  Edi315SendVO     sendVo			              
       * @return HashMap<String,String>
       * @throws EventException
       */ 
      private HashMap<String,String> getBaseNos(Edi315SendVO sendVo) throws EventException{
		try {
			  DBRowSet rowset = dbDao.getBaseNos(sendVo.getBkgNo()
					                            ,sendVo.getCntrNo()
					                            ,sendVo.getBlNo()
					                            ,sendVo.getCopNo());
			  HashMap<String,String> keys_values = new HashMap<String,String>();
			  if(rowset != null && rowset.next()){
				  keys_values.put("BKG_NO"     ,rowset.getString("BKG_NO" ));
				  keys_values.put("BL_NO"      ,rowset.getString("BL_NO"  ));
				  keys_values.put("CNTR_NO"    ,rowset.getString("CNTR_NO"));
				  keys_values.put("COP_NO"     ,rowset.getString("COP_NO" ));	
				  keys_values.put("BKG_STS_CD" ,rowset.getString("BKG_STS_CD" ));
				  return keys_values;
			  }
			  return null;
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
      /*private SceCopDtlVO getVADActualMappingInfo(String cop_no) throws EventException {
  		try {
  			SceCopDtlVO vo = dbDao.getVADActualMappingInfo(cop_no);
  			return vo;
  		} catch (DAOException e) {
  			throw new EventException(e.getMessage(), e);
  		}
      }*/     
      
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
  	private String addSceFltFileMsg(String flt_file_ref_no, Edi315PrefixMainCOPInfoVO mVo, Edi315DetailVO dtlVo, SceFltFileMsgVO ffMsgVo)throws EventException{
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
  	private boolean addSceFltFileNoGen( String ff_yymmdd, 
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
  	private boolean addSceEdiSndRslt(	String ff_yymmdd, 
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

			 edi_snd_knt = getVipSndCount(dtlVo.getEdiGrpCd(),
					 						dtlVo.getEdiSts(),
					 						dtlVo.getCustEdiStsCd(),
					 						sendVo.getBkgNo(),
					 						sendVo.getCntrNo(),
					 						po_nbr
					 					);
			 
			 log.debug("\n edi_snd_knt"+edi_snd_knt);
			 
			 //2015.08.04 Add TRSP_LEG_NM
			 log.debug("\n addSceEdiSndRslt getTrspLegNm param "
			 		+ "\n getBkgNo         ["+dtlVo.getBkgNo()+"]"
					+ "\n getEdiGrpCd      ["+dtlVo.getEdiGrpCd()+"]"
					+ "\n getCntrNo        ["+dtlVo.getCntrNo()+"]"
					+ "\n getOrgEdiSts     ["+dtlVo.getOrgEdiSts()+"]"
					+ "\n getCopNo         ["+dtlVo.getCopNo()+"]"
					+ "\n getCurrEventYard ["+currVo.getCurrEventYard()+"]");
			 
			 String trspLegNm = this.getTrspLegNm(dtlVo.getBkgNo(), dtlVo.getEdiGrpCd(), dtlVo.getCntrNo(), dtlVo.getOrgEdiSts(), dtlVo.getCopNo(), currVo.getCurrEventYard());
			 log.debug("\n addSceEdiSndRslt trspLegNm ["+trspLegNm+"]");
			 trspLegNm = StringUtils.isNotEmpty(trspLegNm) ? trspLegNm : "";
			 
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
				 ) {
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
			addSceEdiSndRsltVo.setTrspLegNm     (trspLegNm);//2015.08.04 Add.
			
			list.add(addSceEdiSndRsltVo);
					
			return dbDao.addSceEdiSndRslt(list);
		} catch (DAOException e) {
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
 	private boolean modifySceEdiHisDtl(String e_rslt_flag, String e_rslt_remark, Edi315DetailVO dtlVo) throws EventException {
		try {
			if (e_rslt_flag.equalsIgnoreCase("Y") || e_rslt_flag.equalsIgnoreCase("Success")) {
				e_rslt_flag = "Y";
			}
			String e_rcv_dt 		= dtlVo.getRcvDt();
			String e_rcv_seq 		= dtlVo.getRcvSeq();
			String e_rcv_dtl_seq 	= dtlVo.getRcvDtlSeq();
			
			return dbDao.modifySceEdiHisDtl(e_rslt_flag, e_rslt_remark, e_rcv_dt, e_rcv_seq, e_rcv_dtl_seq);
		} catch (DAOException e) {
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
			throw new EventException(e.getMessage(), e);
		}
	}

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
			if (rslt_flg.equalsIgnoreCase("Y") || rslt_flg.equalsIgnoreCase("Success")) {
				e_rslt_flg = "Y";
			} else {
				e_rslt_flg = "N";
			}
			String e_rcv_if_dt = sendVo.getActRcvIfKeyDt();
			String e_rcv_if_no = sendVo.getActRcvIfKeyNo();
			
			return dbDao.modifySceActRcvIf(e_rslt_flg, e_rcv_if_dt, e_rcv_if_no);
		} catch (DAOException e) {
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
  	private boolean modifySceCopDtl (String stnd_edi_sts_cd, String event_dt, String cop_no, String cop_dtl_seq) throws EventException {
  		try {
  			return dbDao.modifySceCopDtl(stnd_edi_sts_cd, event_dt, cop_no, cop_dtl_seq);
	    } catch (DAOException e) {
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
  	private String addSceFltFileMsgDtl( SceFltFileMsgDtlVslVO ffMsgVo)throws EventException {
		try {
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
    private HashMap<String,String> searchOriginBookingInformation(String bkgNo) throws EventException {
        try {
			DBRowSet rowset = dbDao.searchOriginBookingInformation(bkgNo);
			HashMap<String,String> hashMap = null; ;
			
			if(rowset != null && rowset.next()) {
				hashMap = new HashMap<String,String>();
				hashMap.put("BKG_NO", rowset.getString("BKG_NO"));
				hashMap.put("BL_NO", rowset.getString("BL_NO"));
				hashMap.put("BL_TP_CD", rowset.getString("BL_TP_CD"));
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
     * @param String bkgNo
     * @param String cntrNo
     * @return
     * @since 2010.10.26 
     */
    private String[][] searchPrtlBkgsForEdiGrp(String bkgNo, String cntrNo)  throws EventException{
		String[][] multiResultArray = null; ;

    	try {
			DBRowSet rowset = dbDao.searchPrtlBkgsForEdiGrp(bkgNo, cntrNo);
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
	 * OB_CSSM_VOY_NO, IB_CSSM_VOY_NO 정보가 무엇인지 조회
	 * 
	 * @return HashMap<String,String>
	 * @throws EventException
	 * @since 2014.11.27 igkim NYK item add
	 */       
   private HashMap<String,String> searchCssmVoyNo(String vsl_cd ,String skd_dir_cd ,String skd_voy_no ,String vps_port_cd) throws EventException {
       try {
    	   DBRowSet rowset = dbDao.searchCssmVoyNo(vsl_cd ,skd_dir_cd ,skd_voy_no ,vps_port_cd);
    	   HashMap<String,String> hashMap = null; ;
			
    	   if(rowset != null && rowset.next()) {
    		   hashMap = new HashMap<String,String>();
    		   hashMap.put("OB_CSSM_VOY_NO", rowset.getString("OB_CSSM_VOY_NO"));
    		   hashMap.put("IB_CSSM_VOY_NO", rowset.getString("IB_CSSM_VOY_NO"));
    	   }

    	   return hashMap;
		   } catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
	       } catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
	       }
   }  
   
	 /**getCustRefNoCtnt
	  * @param    String bkg_no
	  * @param    String bgk_ref_tp_cd
	  * @return   String
	  * @throws   EventException
	  * @since    2014.11.27 igkim NYK item add
      */       
	private String getCustRefNoCtnt(String bkg_no, String bkg_ref_tp_cd)throws EventException{
		try {
			String custRefNoCtnt = dbDao.getCustRefNoCtnt(bkg_no, bkg_ref_tp_cd);
			return custRefNoCtnt;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(),e);
		}     	  
	 }   
	
    /**
     * BKG HBL NO NEW ITEM MULTI 조회
     * @param bkgNo
     * @return
     * @since 2014.11.27 
     */
    private String[] searchBkgHblNo(String bkgNo)  throws EventException{
		String[] multiResultArray = null; ;

    	try {
			DBRowSet rowset = dbDao.searchBkgHblNo(bkgNo);
			if (rowset != null) {
				multiResultArray = new String[rowset.getRowCount()];
				int i = 0;
				while (rowset.next()) {
					multiResultArray[i] = rowset.getString(1);
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
     * Multi  CNTR_SEAL_NO, SEAL_PTY_TP_CD  조회   
     * @param bkgNo
     * @param cntrNo
     * @return
 	 * @since 2014.11.28 igkim
     */
    private String[][] searchCntrSealNo(String bkgNo, String cntrNo)  throws EventException{
		String[][] multiResultArray = null; ;

    	try {
			DBRowSet rowset = dbDao.searchCntrSealNo(bkgNo, cntrNo);
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
    
 	 /**getBkgEDICustInfo
 	 * HP 화주의 경우 SHIPPER ID 부분포함 하여 Flat File 생성 한다. 
     * @param  String bkg_no
     * @return List<String>
     * @throws EventException
     */       
  private List<String> getBkgEDICustInfo(String bkg_no) throws EventException{
        try {
			DBRowSet rowset = dbDao.getBkgEDICustInfo(bkg_no);
			List<String> values = new ArrayList<String>();
			
			while (rowset != null && rowset.next()) {
				values.add(rowset.getString("CUST_INFO"));
			}
			return values;
		} catch (DAOException e) {
				throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }    
  
	  /**getBkgEDIBkgInfo
	  * @param  String bkg_no
	  * @return List<String>
	  * @throws EventException
	  */       
	private List<String> getBkgEDIBkgInfo(String bkg_no) throws EventException{
	     try {
				DBRowSet rowset = dbDao.getBkgEDIBkgInfo(bkg_no);
				List<String> values = new ArrayList<String>();
				
				while (rowset != null && rowset.next()) {
					values.add(rowset.getString("I_BKG_INFO"));
				}
				return values;
			} catch (DAOException e) {
					throw new EventException(e.getMessage(),e);
			} catch (Exception ex) {
					throw new EventException(new ErrorHandler(ex).getMessage());
			}
	 }
	
    /**
     * Multi  trans info  조회    : 2015.07.15 주석처리함.
     * @param bkgNo
     * @param cntrNo
     * @return
 	 * @since 2014.12.09 igkim
     */
//    private String searchTransInfo(String bkgNo, String ediGrpCd, String cntrNo, String ediStsCd, String copNo)  throws EventException{
//
//		String ediTransInfo = null; ;
//		StringBuffer temtransinfo = new StringBuffer("");
//		
//
//		String[] arrTransTpCd = new String[]{ "OBSTRT","OBIMD","TRNKPC","TRNKMC","TRNKOC","TRNKTT","IBIMD","IBEND"};
//		
//		String[][] arrLocTpCd = new String[][]{ {"FRCTY","EP","OBDR","FR"},
//												 {"START","END"},
//												 {"LPDP"}, //{"LP","DP"},
//												 {"LPDP"}, //{"LP","DP"},
//												 {"LPDP"}, //{"LP","DP"},
//												 {"START","END"},
//												 {"START","END"},
//												 {"LIBH","IBDR","ER","TOCTY"}
//												};
//		
//		String[] arrLpDpTpCd = new String[]{"LP","DP"};
//		
//		String[][][] arrDateTpCd = new String[][][]{ {{""},{"ATD"},{"ETA","ATD"},{"CO","ATD"}},
//													 {{"ATD"},{"ATA"}},
//													 {{"ETD","ATD","LD"},{"ETA","ATA","DD"}},
//													 {{"ETD","ATD","LD"},{"ETA","ATA","DD"}},
//													 {{"ETD","ATD","LD"},{"ETA","ATA","DD"}},
//													 {{"ATA"},{"ATD"}},
//													 {{"ATD"},{"ATA"}},
//													 {{"EAV","ATA"},{"ETA","ATA"},{"ATA"},{""}}
//												};
//		
//		log.debug("\n searchTransInfo bkgNo : "+bkgNo+"\n");
//		log.debug("\n searchTransInfo ediGrpCd : "+ediGrpCd+"\n");
//		log.debug("\n searchTransInfo cntrNo : "+cntrNo+"\n");
//		log.debug("\n searchTransInfo ediStsCd : "+ediStsCd+"\n");
//		log.debug("\n searchTransInfo copNo : "+copNo+"\n");
//		
//    	try {
//    		DBRowSet rowset = null;
//    		DBRowSet rowset2= null;
//    		DBRowSet rowset3 = null;
//    		int xx = 1;	
//    		//String tmpActivityInd = "";//2015.05.15 Modify
//    		for(int l = 0 ; l < arrTransTpCd.length ; l++){
//        		rowset = dbDao.searchTransInfo(bkgNo, cntrNo,copNo,arrTransTpCd[l]);	
//        		
//        		if (rowset != null) {
//        			
//        			while (rowset.next()) { // TransPort Data 
//	        			if(!"".equals(rowset.getString("ACTIVITY_IND")) && rowset.getString("ACTIVITY_IND") != null){
//							temtransinfo.append("{TRANS_INFO" + CHR10);
//							temtransinfo.append("TRANS_SEQ : " + xx + CHR10);
//							temtransinfo.append("TRANS_TP_CD : " + arrTransTpCd[l]+ CHR10);
//							temtransinfo.append("ACTIVITY_IND : " + rowset.getString("ACTIVITY_IND") + CHR10);
//							temtransinfo.append("TRANS_MODE : " + rowset.getString("TRANS_MODE")+ CHR10);
//							
//							temtransinfo.append("{VSL_INFO" + CHR10);
//							temtransinfo.append("VSL_TP : " + rowset.getString("VSL_TP")+ CHR10);
//							temtransinfo.append("VSL_CONSORTIUM_VOY_NO : " + rowset.getString("OB_CSSM_VOY_NO")+ CHR10);
//							temtransinfo.append("VSL_CD : " + rowset.getString("VSL_CD")+ CHR10);
//							temtransinfo.append("VSL_VOY_NO : " + rowset.getString("VSL_VOY_NO")+ CHR10);
//							temtransinfo.append("VSL_DIR_CD : " + rowset.getString("VSL_DIR_CD")+ CHR10);
//							temtransinfo.append("VSL_LLOYD_CD : " + rowset.getString("VSL_LLOYD_CD")+ CHR10);
//							temtransinfo.append("VSL_NM : " + rowset.getString("VSL_NM")+ CHR10);
//							temtransinfo.append("VSL_CNT_CD : " + rowset.getString("VSL_CNT_CD")+ CHR10);
//							temtransinfo.append("}VSL_INFO" + CHR10);
//	    			
//							int ii = 1;	
//							for(int j = 0 ; j < arrLocTpCd[l].length ; j++){ 
//								
//								rowset2 = null;
//								if("LPDP".equals(arrLocTpCd[l][j])){ //if("LP".equals(arrLocTpCd[l][j]) || "DP".equals(arrLocTpCd[l][j])){
//									log.debug("\nstart====================================================================================");
//									//LP, DP 순차적으로 1쌍으로 데이타를 생성해야 한다.
//									String strPolYdCd = rowset.getString("POL_YD_CD");
//									String strPodYdCd = rowset.getString("POD_YD_CD");
//									String strLocYdCd = "";
//									for(int y = 0 ; y < arrLpDpTpCd.length ; y++){ 
//										strLocYdCd = "LP".equals(arrLpDpTpCd[y]) ? strPolYdCd: strPodYdCd;
//										if(dbDao.getVslPrePstCd(bkgNo, copNo,arrTransTpCd[l],arrLpDpTpCd[y])){
//					    					//ㅁ조건 1건의 Row 조회 되도록 함.
//											rowset2 = dbDao.searchLocationInfo(bkgNo, copNo,arrTransTpCd[l],arrLpDpTpCd[y], strLocYdCd);	// Location Data
//					    				}
//										
//										if(rowset2 != null){
//
//											while (rowset2.next()) { // Location Data Row Count
//												String strNodCd = rowset2.getString("NOD_CD");
//						    					temtransinfo.append("{LOC_INFO" + CHR10);
//												temtransinfo.append("LOC_SEQ : " + ii+ CHR10);
//												temtransinfo.append("LOC_TP_CD : " + arrLpDpTpCd[y]+ CHR10);
//												temtransinfo.append("LOC_YD_CD : " + strNodCd+ CHR10);
//												temtransinfo.append("LOC_SPLC_CD : " + rowset2.getString("SPLC_CD")+ CHR10);
//												temtransinfo.append("LOC_DK_CD : " + rowset2.getString("LOC_DK_CD")+ CHR10);
//												temtransinfo.append("LOC_NM : " + rowset2.getString("LOC_NM")+ CHR10);
//												temtransinfo.append("LOC_CITY_NM : " + rowset2.getString("LOC_CITY_NM")+ CHR10);
//												temtransinfo.append("LOC_STAT_CD : " + rowset2.getString("LOC_STAT_CD")+ CHR10);
//												temtransinfo.append("LOC_CNT_CD : " + rowset2.getString("LOC_CNT_CD")+ CHR10);
//												temtransinfo.append("LOC_TRANS_MODE : " + rowset2.getString("LOC_TRANS_MODE")+ CHR10);
//												temtransinfo.append("LOC_FAC_TP : " + rowset2.getString("LOC_FAC_TP")+ CHR10); //2015.07.08 NYK Add.
//												
//												
//							    				for(int k = 0 ; k < arrDateTpCd[l][(j+y)].length ; k++){
//								    				
//							    					rowset3 = dbDao.searchDateTpCdInfo(bkgNo, arrDateTpCd[l][(j+y)][k],copNo,arrTransTpCd[l],arrLpDpTpCd[y], strLocYdCd);
//							    					
//							    					if(rowset3 != null){ // Date Info
//							    						while (rowset3.next()) { // Date Info
//															temtransinfo.append("{DATE_INFO" + CHR10);
//															temtransinfo.append("DATE_TP_CD : " + rowset3.getString("DATE_TP_CD")+ CHR10);
//															temtransinfo.append("DATE : " + rowset3.getString("DATE_INFO")+ CHR10);
//															temtransinfo.append("}DATE_INFO" + CHR10);
//							    							
//							    						}
//							    					} // Date Info End
//							    					rowset3 = null;
//							    				}
//						
//							    				temtransinfo.append("}LOC_INFO" + CHR10);	   
//							    				ii++;
//											}
//										}
//									}
//									/*if(dbDao.getVslPrePstCd(bkgNo, copNo,arrTransTpCd[l],arrLocTpCd[l][j])){
//				    					rowset2 = dbDao.searchLocationInfo(bkgNo, copNo,arrTransTpCd[l],arrLocTpCd[l][j]);	// Location Data
//				    				}*/
//									log.debug("\nend====================================================================================");
//								}
//								else{
//									rowset2 = dbDao.searchLocationInfo(bkgNo, copNo,arrTransTpCd[l],arrLocTpCd[l][j], "");	// Location Data
//									
//									if(rowset2 != null){
//										String strLocYdCd = "";
//										while (rowset2.next()) { // Location Data Row Count
//											strLocYdCd = rowset2.getString("NOD_CD");
//					    					temtransinfo.append("{LOC_INFO" + CHR10);
//											temtransinfo.append("LOC_SEQ : " + ii+ CHR10);
//											temtransinfo.append("LOC_TP_CD : " + arrLocTpCd[l][j]+ CHR10);
//											temtransinfo.append("LOC_YD_CD : " + strLocYdCd+ CHR10);
//											temtransinfo.append("LOC_SPLC_CD : " + rowset2.getString("SPLC_CD")+ CHR10);
//											temtransinfo.append("LOC_DK_CD : " + rowset2.getString("LOC_DK_CD")+ CHR10);
//											temtransinfo.append("LOC_NM : " + rowset2.getString("LOC_NM")+ CHR10);
//											temtransinfo.append("LOC_CITY_NM : " + rowset2.getString("LOC_CITY_NM")+ CHR10);
//											temtransinfo.append("LOC_STAT_CD : " + rowset2.getString("LOC_STAT_CD")+ CHR10);
//											temtransinfo.append("LOC_CNT_CD : " + rowset2.getString("LOC_CNT_CD")+ CHR10);
//											temtransinfo.append("LOC_TRANS_MODE : " + rowset2.getString("LOC_TRANS_MODE")+ CHR10);
//											temtransinfo.append("LOC_FAC_TP : " + rowset2.getString("LOC_FAC_TP")+ CHR10); //2015.07.08 NYK Add.
//											
//											
//						    				for(int k = 0 ; k < arrDateTpCd[l][j].length ; k++){
//							    				
//						    					rowset3 = dbDao.searchDateTpCdInfo(bkgNo, arrDateTpCd[l][j][k],copNo,arrTransTpCd[l],arrLocTpCd[l][j], strLocYdCd);
//						    					
//						    					if(rowset3 != null){ // Date Info
//						    						while (rowset3.next()) { // Date Info
//														temtransinfo.append("{DATE_INFO" + CHR10);
//														temtransinfo.append("DATE_TP_CD : " + rowset3.getString("DATE_TP_CD")+ CHR10);
//														temtransinfo.append("DATE : " + rowset3.getString("DATE_INFO")+ CHR10);
//														temtransinfo.append("}DATE_INFO" + CHR10);
//						    							
//						    						}
//						    					} // Date Info End
//						    					rowset3 = null;
//						    				}
//					
//						    				temtransinfo.append("}LOC_INFO" + CHR10);	   
//						    				ii++;
//										}
//										
//									}
//								}
//								
//								
//								
//								rowset2 = null;
//							}
//	    			
//							temtransinfo.append("}TRANS_INFO" + CHR10);
//							xx++;
//							
//							//ACTIVITY_IND = 'Y' 일때 값을 넣어 준다.
//							/*String tmpRowSetActivityInd = rowset.getString("ACTIVITY_IND");
//							if(!StringUtils.isEmpty(tmpRowSetActivityInd) && "Y".equals(tmpRowSetActivityInd)){ 
//								tmpActivityInd = rowset.getString("TRANS_MODE");
//							}*/
//        				}
//        			}
//        			
//    			}    		
//  
//				ediTransInfo = temtransinfo.toString();				
//				log.debug("\n searchTransInfo ediTransInfo : "+ediTransInfo+"\n");
//				rowset = null;
//			}
//			
//    		/*if(!StringUtils.isEmpty(ediTransInfo) && !StringUtils.isEmpty(tmpActivityInd)){
//				ediTransInfo = ediTransInfo +"@@"+ tmpActivityInd;
//				log.debug("##### searchTransInfo ediTransInfo tmpActivityInd : ["+tmpActivityInd+"]");
//			}*/
//		} catch (DAOException e) {
//			throw new EventException(e.getMessage(), e);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//
//		return ediTransInfo;
//	}

	
    /**
     * Multi  trans info  조회   
     * @param bkgNo
     * @param ediGrpCd
     * @param cntrNo
     * @param ediStsCd
     * @param orgEdiStsCd
     * @param copNo
     * @param eventYardCd
     * @return
 	 * @since 2015.07.14 jyLee
     */
    private String searchDynamicTransInfo(String bkgNo, String ediGrpCd, String cntrNo, String ediStsCd, String orgEdiStsCd, String copNo, String eventYardCd)  throws EventException{
		String ediTransInfo = null; ;
		StringBuffer temtransinfo = new StringBuffer("");
		
		log.debug("\n searchDynamicTransInfo bkgNo 		: "+bkgNo+"\n");
		log.debug("\n searchDynamicTransInfo ediGrpCd 	: "+ediGrpCd+"\n");
		log.debug("\n searchDynamicTransInfo cntrNo 	: "+cntrNo+"\n");
		log.debug("\n searchDynamicTransInfo ediStsCd 	: "+ediStsCd+"\n");
		log.debug("\n searchDynamicTransInfo orgEdiStsCd: "+orgEdiStsCd+"\n");
		log.debug("\n searchDynamicTransInfo copNo 		: "+copNo+"\n");
		log.debug("\n searchDynamicTransInfo eventYardCd: "+eventYardCd+"\n");
		
    	try {
    		List<String> arrTransTpCd = new LinkedList<String>();
    		HashMap<String,String[]> mapTransTpCdVvd = new HashMap<String,String[]>();
    		arrTransTpCd.add("OBSTRT");
    		//arrTransTpCd.add("OBIMD"); //2015.08.11 동적으로 변경.
    		
    		//가변적으로 변화는 부분임. DB에서 조회 해서 Add 시켜야 함.
    		DBRowSet rowset0 = null;
    		rowset0 = dbDao.searchDynamicTransInfo(copNo);
    		if (rowset0 != null) {
				while (rowset0.next()) {
					arrTransTpCd.add(rowset0.getString("TRANS_TP_CD"));
					
					String tmpTransTpKey 	= StringUtils.isEmpty(rowset0.getString("TRANS_TP_KEY")) ? "" : rowset0.getString("TRANS_TP_KEY"); //TRNKPC2 부터 시작...뒤 수치값은 Loop Count
					
					String tmpVvd 			= StringUtils.isEmpty(rowset0.getString("VVD")) ? "" : rowset0.getString("VVD");
					String tmpNodCd 		= StringUtils.isEmpty(rowset0.getString("NOD_CD")) ? "" : rowset0.getString("NOD_CD");
					String tmpCopDtlSeq 	= StringUtils.isEmpty(rowset0.getString("COP_DTL_SEQ")) ? "" : rowset0.getString("COP_DTL_SEQ");
					
					log.debug("\n tmpVvd ["+tmpVvd+"] tmpNodCd ["+tmpNodCd+"]  tmpCopDtlSeq ["+tmpCopDtlSeq+"]");
					
					mapTransTpCdVvd.put(tmpTransTpKey, new String[]{tmpVvd,tmpNodCd,tmpCopDtlSeq});
				}
    		}
    		rowset0 = null;
    		//arrTransTpCd.add("TRNKPC");
    		//arrTransTpCd.add("TRNKMC");
    		//arrTransTpCd.add("TRNKOC");
    		//arrTransTpCd.add("TRNKTT");
    		
    		
    		//arrTransTpCd.add("IBIMD"); //2015.08.11 동적으로 변경.
    		arrTransTpCd.add("IBEND");
    		
    		HashMap<String,String[]> mapLocTpCd = new HashMap<String,String[]>();
    		
    		mapLocTpCd.put("OBSTRT"	, new String[]{"FRCTY","EP","OBDR","FR"});
    		mapLocTpCd.put("OBIMD"	, new String[]{"START","END"});
    		mapLocTpCd.put("TRNKPC"	, new String[]{"LPDP"});
    		mapLocTpCd.put("TRNKMC"	, new String[]{"LPDP"});
    		mapLocTpCd.put("TRNKOC"	, new String[]{"LPDP"});
    		mapLocTpCd.put("TRNKTT"	, new String[]{"START","END"});
    		mapLocTpCd.put("IBIMD"	, new String[]{"START","END"});
    		mapLocTpCd.put("IBEND"	, new String[]{"LIBH","IBDR","ER","TOCTY"});
    				
    		HashMap<String,String[]> mapDateTpCd = new HashMap<String,String[]>();
    		mapDateTpCd.put("OBSTRT|FRCTY"	, new String[]{""});
    		mapDateTpCd.put("OBSTRT|EP"		, new String[]{"ATD"});
    		mapDateTpCd.put("OBSTRT|OBDR"	, new String[]{"ETA","ATA","ATD"}); //20160128
    		mapDateTpCd.put("OBSTRT|FR"		, new String[]{"CO","ATA","ATD"}); //20160128
    		mapDateTpCd.put("OBIMD|START"	, new String[]{"ATA","ATD"}); //20160128
    		mapDateTpCd.put("OBIMD|END"		, new String[]{"ATA","ATD"}); //20160128
    		mapDateTpCd.put("TRNKPC|LP"		, new String[]{"ETA","ETD","ATA","ATD","LD"}); //20151216
    		mapDateTpCd.put("TRNKPC|DP"		, new String[]{"ETA","ETD","ATA","ATD","DD"}); //20151216
    		mapDateTpCd.put("TRNKMC|LP"		, new String[]{"ETA","ETD","ATA","ATD","LD"}); //20151216
    		mapDateTpCd.put("TRNKMC|DP"		, new String[]{"ETA","ETD","ATA","ATD","DD"}); //20151216
    		mapDateTpCd.put("TRNKOC|LP"		, new String[]{"ETA","ETD","ATA","ATD","LD"}); //20151216
    		mapDateTpCd.put("TRNKOC|DP"		, new String[]{"ETA","ETD","ATA","ATD","DD"}); //20151216
    		mapDateTpCd.put("TRNKTT|START"	, new String[]{"ATA"});
    		mapDateTpCd.put("TRNKTT|END"	, new String[]{"ATD"});
    		mapDateTpCd.put("IBIMD|START"	, new String[]{"ATA","ATD"}); //20160128
    		mapDateTpCd.put("IBIMD|END"		, new String[]{"ATA","ATD"}); //20160128
    		mapDateTpCd.put("IBEND|LIBH"	, new String[]{"EAV","ATA","ATD","AAV"}); //20160128
    		mapDateTpCd.put("IBEND|IBDR"	, new String[]{"ETA","ATA","ATD"}); //20160128
    		mapDateTpCd.put("IBEND|ER"		, new String[]{"ATA"});
    		mapDateTpCd.put("IBEND|TOCTY"	, new String[]{""});
    		
    		String[] arrLpDpTpCd = new String[]{"LP","DP"};  
    		
    		DBRowSet rowset = null;
    		DBRowSet rowset2= null;
    		DBRowSet rowset3 = null;
    		int iTransSeq = 1;	
    		int iLoopCnt = 1;
    		for(String strTransTpCd : arrTransTpCd){

        		String tmpVvd 	= "";
        		String tmpNodCd = "";
        		String tmpCopDtlSeq = "";
    			String tmpKey = strTransTpCd+String.valueOf(iLoopCnt);
    			
    			String[] tmpArrTransTpVvd =  mapTransTpCdVvd.get(tmpKey);
    			if(tmpArrTransTpVvd != null){
	    			tmpVvd 	= StringUtils.isEmpty(tmpArrTransTpVvd[0]) ? "" : tmpArrTransTpVvd[0];
	    			tmpNodCd = StringUtils.isEmpty(tmpArrTransTpVvd[1]) ? "" : tmpArrTransTpVvd[1];
	    			tmpCopDtlSeq = StringUtils.isEmpty(tmpArrTransTpVvd[2]) ? "" : tmpArrTransTpVvd[2];
    			}
    			
    			rowset = dbDao.searchTransInfo(bkgNo, cntrNo,copNo, strTransTpCd, orgEdiStsCd, eventYardCd, tmpVvd, tmpNodCd, tmpCopDtlSeq);
    			
    			if (rowset != null) {
    				while (rowset.next()) { // TransPort Data
    					if(!"".equals(rowset.getString("ACTIVITY_IND")) && rowset.getString("ACTIVITY_IND") != null){
    						temtransinfo.append("{TRANS_INFO" 															).append(CHR10);
							temtransinfo.append("TRANS_SEQ : " 				).append(iTransSeq 							).append(CHR10);
							temtransinfo.append("TRANS_TP_CD : " 			).append(strTransTpCd 						).append(CHR10);
							temtransinfo.append("ACTIVITY_IND : " 			).append(rowset.getString("ACTIVITY_IND") 	).append(CHR10);
							temtransinfo.append("TRANS_MODE : " 			).append(rowset.getString("TRANS_MODE")		).append(CHR10);
							
							temtransinfo.append("{VSL_INFO" 															).append(CHR10);
							temtransinfo.append("VSL_TP : " 				).append(rowset.getString("VSL_TP")			).append(CHR10);
							temtransinfo.append("VSL_CONSORTIUM_VOY_NO : " 	).append(rowset.getString("OB_CSSM_VOY_NO")	).append(CHR10);
							temtransinfo.append("VSL_CD : " 				).append(rowset.getString("VSL_CD")			).append(CHR10);
							temtransinfo.append("VSL_VOY_NO : " 			).append(rowset.getString("VSL_VOY_NO")		).append(CHR10);
							temtransinfo.append("VSL_DIR_CD : " 			).append(rowset.getString("VSL_DIR_CD")		).append(CHR10);
							temtransinfo.append("VSL_LLOYD_CD : " 			).append(rowset.getString("VSL_LLOYD_CD")	).append(CHR10);
							temtransinfo.append("VSL_NM : " 				).append(rowset.getString("VSL_NM")			).append(CHR10);
							temtransinfo.append("VSL_CNT_CD : " 			).append(rowset.getString("VSL_CNT_CD")		).append(CHR10);
							temtransinfo.append("}VSL_INFO" 															).append(CHR10);
							
							int iLocSeq = 1;
							
							String[] arrLocTpCd = mapLocTpCd.get(strTransTpCd);
							
							for(String strLocTpCd : arrLocTpCd){
								rowset2 = null;
								if("LPDP".equals(strLocTpCd)){
									log.debug("\nstart LPDP in ====================================================================================");
									//LP, DP 순차적으로 1쌍으로 데이타를 생성해야 한다.
									String strPolYdCd = rowset.getString("POL_YD_CD");
									String strPodYdCd = rowset.getString("POD_YD_CD");
									String strLocYdCd = "";
									
									for(String strLpDpTpCd : arrLpDpTpCd){
										strLocYdCd = "LP".equals(strLpDpTpCd) ? strPolYdCd: strPodYdCd;
										
										if(dbDao.getVslPrePstCd(bkgNo, copNo, strTransTpCd, strLpDpTpCd)){
					    					//ㅁ조건 1건의 Row 조회 되도록 함.
											rowset2 = dbDao.searchLocationInfo(bkgNo, copNo, strTransTpCd, strLpDpTpCd, strLocYdCd, tmpCopDtlSeq);	// Location Data
					    				}
										
										if(rowset2 != null){
											while (rowset2.next()) { // Location Data Row Count
												String strNodCd = rowset2.getString("NOD_CD");
						    					temtransinfo.append("{LOC_INFO" 														).append(CHR10);
												temtransinfo.append("LOC_SEQ : " 		).append(iLocSeq								).append(CHR10);
												temtransinfo.append("LOC_TP_CD : " 		).append(strLpDpTpCd							).append(CHR10);
												temtransinfo.append("LOC_YD_CD : " 		).append(strNodCd								).append(CHR10);
												temtransinfo.append("LOC_SPLC_CD : " 	).append(rowset2.getString("SPLC_CD")			).append(CHR10);
												temtransinfo.append("LOC_DK_CD : " 		).append(rowset2.getString("LOC_DK_CD")			).append(CHR10);
												temtransinfo.append("LOC_NM : " 		).append(rowset2.getString("LOC_NM")			).append(CHR10);
												temtransinfo.append("LOC_CITY_NM : " 	).append(rowset2.getString("LOC_CITY_NM")		).append(CHR10);
												temtransinfo.append("LOC_STAT_CD : " 	).append(rowset2.getString("LOC_STAT_CD")		).append(CHR10);
												temtransinfo.append("LOC_CNT_CD : " 	).append(rowset2.getString("LOC_CNT_CD")		).append(CHR10);
												temtransinfo.append("LOC_TRANS_MODE : " ).append(rowset2.getString("LOC_TRANS_MODE")	).append(CHR10);
												temtransinfo.append("LOC_FAC_TP : " 	).append(rowset2.getString("LOC_FAC_TP")		).append(CHR10); //2015.07.08 NYK Add.
												
												String tmpDateKey = strTransTpCd+"|"+strLpDpTpCd;
					    						String[] arrDateTpCd = mapDateTpCd.get(tmpDateKey);
					    						
					    						for(String strDateTpCd : arrDateTpCd){
					    							rowset3 = dbDao.searchDateTpCdInfo(bkgNo, strDateTpCd,copNo, strTransTpCd, strLpDpTpCd, strLocYdCd, tmpCopDtlSeq);
							    					
							    					if(rowset3 != null){ // Date Info
							    						while (rowset3.next()) { // Date Info
															temtransinfo.append("{DATE_INFO" 												).append(CHR10);
															temtransinfo.append("DATE_TP_CD : " ).append(rowset3.getString("DATE_TP_CD")	).append(CHR10);
															temtransinfo.append("DATE : " 		).append(rowset3.getString("DATE_INFO")		).append(CHR10);
															temtransinfo.append("}DATE_INFO" 												).append(CHR10);
							    						}
							    					} // Date Info End
							    					rowset3 = null;
					    						}
						
							    				temtransinfo.append("}LOC_INFO" + CHR10);	   
							    				iLocSeq++;
											}//while (rowset2.next()) end
										}//if(rowset2 != null end
									} //for(String strLpDpTpCd : arrLpDpTpCd) end
									log.debug("\ne n d LPDP in ====================================================================================");
								
								}else{
									log.debug("\nstart LPDP Not ====================================================================================");
									
									rowset2 = dbDao.searchLocationInfo(bkgNo, copNo, strTransTpCd, strLocTpCd, "", tmpCopDtlSeq);	// Location Data
									
									if(rowset2 != null){
										String strLocYdCd = "";
										while (rowset2.next()) { // Location Data Row Count
											strLocYdCd = rowset2.getString("NOD_CD");
					    					temtransinfo.append("{LOC_INFO" 														).append(CHR10);
											temtransinfo.append("LOC_SEQ : " 		).append(iLocSeq								).append(CHR10);
											temtransinfo.append("LOC_TP_CD : " 		).append(strLocTpCd								).append(CHR10);
											temtransinfo.append("LOC_YD_CD : " 		).append(strLocYdCd								).append(CHR10);
											temtransinfo.append("LOC_SPLC_CD : " 	).append(rowset2.getString("SPLC_CD")			).append(CHR10);
											temtransinfo.append("LOC_DK_CD : " 		).append(rowset2.getString("LOC_DK_CD")			).append(CHR10);
											temtransinfo.append("LOC_NM : " 		).append(rowset2.getString("LOC_NM")			).append(CHR10);
											temtransinfo.append("LOC_CITY_NM : " 	).append(rowset2.getString("LOC_CITY_NM")		).append(CHR10);
											temtransinfo.append("LOC_STAT_CD : " 	).append(rowset2.getString("LOC_STAT_CD")		).append(CHR10);
											temtransinfo.append("LOC_CNT_CD : " 	).append(rowset2.getString("LOC_CNT_CD")		).append(CHR10);
											temtransinfo.append("LOC_TRANS_MODE : " ).append(rowset2.getString("LOC_TRANS_MODE")	).append(CHR10);
											temtransinfo.append("LOC_FAC_TP : " 	).append(rowset2.getString("LOC_FAC_TP")		).append(CHR10); //2015.07.08 NYK Add.
											
											String tmpDateKey = strTransTpCd+"|"+strLocTpCd;
				    						String[] arrDateTpCd = mapDateTpCd.get(tmpDateKey);
				    						
				    						for(String strDateTpCd : arrDateTpCd){
							    				
						    					rowset3 = dbDao.searchDateTpCdInfo(bkgNo, strDateTpCd, copNo, strTransTpCd, strLocTpCd, strLocYdCd, tmpCopDtlSeq);
						    					
						    					if(rowset3 != null){ // Date Info
						    						while (rowset3.next()) { // Date Info
														temtransinfo.append("{DATE_INFO" 												).append(CHR10);
														temtransinfo.append("DATE_TP_CD : " ).append(rowset3.getString("DATE_TP_CD")	).append(CHR10);
														temtransinfo.append("DATE : " 		).append(rowset3.getString("DATE_INFO")		).append(CHR10);
														temtransinfo.append("}DATE_INFO" 												).append(CHR10);
						    						}
						    					} // Date Info End
						    					rowset3 = null;
						    				}
					
						    				temtransinfo.append("}LOC_INFO" ).append(CHR10);	   
						    				iLocSeq++;
										}//while (rowset2.next()) end
										
									} //if(rowset2 != null) end
									
									log.debug("\ne n d LPDP Not ====================================================================================");
								}
								
								rowset2 = null;
								
							} //for(String strLocTpCd : arrLocTpCd) end
							
							temtransinfo.append("}TRANS_INFO" ).append(CHR10);
							iTransSeq++;
    					}
    				}//while end.

    			} // rowset != null end.
    			
    			ediTransInfo = temtransinfo.toString();				
				log.debug("\n searchDynamicTransInfo ediTransInfo : "+ediTransInfo+"\n");
				rowset = null; 
				iLoopCnt++;
    		}
    					
    		/*if(!StringUtils.isEmpty(ediTransInfo) && !StringUtils.isEmpty(tmpActivityInd)){
				ediTransInfo = ediTransInfo +"@@"+ tmpActivityInd;
				log.debug("##### searchTransInfo ediTransInfo tmpActivityInd : ["+tmpActivityInd+"]");
			}*/
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return ediTransInfo;
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
         * Get CANADIAN NATIONAL RAILROAD INBOND NBR & CANADIAN NATIONAL RAILROAD RAIL BILL NBR
         * @param  String bkg_no 
         * @param  String cntr_no 
         * @return String[]
         * @throws EventException
         */       
    	private String[] getCNRailInbondAndBillNbr(String bkg_no, String cntr_no) throws EventException{
            try {
    	           String[] result = dbDao.getCNRailInbondAndBillNbr(bkg_no, cntr_no);
    			   return result;
    		   } catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    		   } 
        }   
    	
    	/**
    	 * 
    	 * @param param
    	 * @return
    	 * @throws EventException
    	 */
    	public int updateSceCopDtlActualDateByTrs(HashMap<String, Object> param) throws EventException {
        	try {
        		return dbDao.updateSceCopDtlActualDateByTrs(param);
        	} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch(Exception ex){
    	  		throw new EventException(ex.getMessage(), ex);
    	  	}
        } 

        /**
         * Multi  trans info  조회   
         * @param bkgNo
         * @param ediGrpCd
         * @param cntrNo
         * @param orgEdiStsCd
         * @param copNo
         * @param eventYardCd
         * @return
     	 * @since 2015.07.14 jyLee
         */
        private String getTransModeByActivityInd(String bkgNo, String ediGrpCd, String cntrNo, String orgEdiStsCd, String copNo, String eventYardCd)  throws EventException{
    		String transMode = "";
        	try {
        		//가변적으로 변화는 부분임. DB에서 조회 해서 Add 시켜야 함.
        		DBRowSet rowset = null;
        		rowset = dbDao.searchTransModeInfo(bkgNo, cntrNo, copNo, orgEdiStsCd, eventYardCd);
        		if (rowset != null) {
    				if (rowset.next()) {
    					transMode = rowset.getString("TRANS_MODE");
    				}
        		}
        		rowset = null;
    		} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch (Exception ex) {
    			throw new EventException(new ErrorHandler(ex).getMessage());
    		}

    		return transMode;
    	} 
        
        /**
         * Multi  trans info  조회   
         * @param bkgNo
         * @param ediGrpCd
         * @param cntrNo
         * @param orgEdiStsCd
         * @param copNo
         * @param eventYardCd
         * @return
     	 * @since 2015.08.04 jyLee
         */
        private String getTrspLegNm(String bkgNo, String ediGrpCd, String cntrNo, String orgEdiStsCd, String copNo, String eventYardCd)  throws EventException{
    		StringBuffer transMode = new StringBuffer();
        	try {
        		//가변적으로 변화는 부분임. DB에서 조회 해서 Add 시켜야 함.
        		DBRowSet rowset = null;
        		rowset = dbDao.searchTransModeInfo(bkgNo, cntrNo, copNo, orgEdiStsCd, eventYardCd);
        		if (rowset != null) {
    				if (rowset.next()) {
    					transMode.append(rowset.getString("SEQ"));
    					transMode.append(rowset.getString("ACTIVITY_IND"));
    					transMode.append(rowset.getString("TRANS_MODE"));
    				}
        		}
        		rowset = null;
    		} catch (DAOException e) {
    			throw new EventException(e.getMessage(), e);
    		} catch (Exception ex) {
    			throw new EventException(new ErrorHandler(ex).getMessage());
    		}

    		return transMode.toString();
    	}

        /**
         * GRP ID가 GV00000001 일때  BL_NBR 조회
    	 * 
    	 * @return HashMap<String,String>
    	 * @throws EventException
    	 */       
        private HashMap<String,String> searchGlovisBlNo(String bkgNo) throws EventException {
            try {
    			DBRowSet rowset = dbDao.searchGlovisBlNo(bkgNo);
    			HashMap<String,String> hashMap = null; ;
    			
    			if(rowset != null && rowset.next()) {
    				hashMap = new HashMap<String,String>();
    				hashMap.put("BKG_NO", rowset.getString("BKG_NO"));
    				hashMap.put("FM_BKG_NO", rowset.getString("FM_BKG_NO"));
    			}

    			return hashMap;
    		   } catch (DAOException e) {
    				throw new EventException(e.getMessage(),e);
    	       } catch (Exception ex) {
    				throw new EventException(new ErrorHandler(ex).getMessage());
    	       }
        }
}
