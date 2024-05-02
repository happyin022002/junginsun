/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGCalcBCImpl.java
*@FileTitle : Brokerage Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-22 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.EsmAgt0013Event;
import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.integration.BRKGCalcDBDAO;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBCImpl;
import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-agt Business Logic Basic Command implementation<br>
 * - OPUS-agt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hwang GyeongNam
 * @see ESM_AGT_008_02EventResponse,BRKGCalcBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class BRKGCalcBCImpl extends BasicCommandSupport implements BRKGCalcBC {

	// Database Access Object
	private transient BRKGCalcDBDAO dbDao=null;

	/**
	 * BRKGCalcBCImpl 객체 생성<br>
	 * AGTCalcDBDAO를 생성한다.<br>
	 */
	public BRKGCalcBCImpl(){
		dbDao = new BRKGCalcDBDAO();
	}

	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createAgentComm(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		int retUptCnt = 0;
//		String bkg_cre_dt = "";
//		String bkg_sts_cd = "";
		String fac_err_msg = "";
		String brog_err_msg = "";
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		//log.info("\n ============ START CreateAgentComm ============================================================================="
		//       + "\n ============ BKG_NO       : "+ bkg_no);

		try {
			
			FACCalcBC facCal = new FACCalcBCImpl();
			AGTCalcBC agtCal = new AGTCalcBCImpl();
			
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== START AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBookingInfoforComm(bkgMap);
			//log.info("Booking :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return -1;
			}

			// S/A Date를 구한다.
			bkgMap = dbDao.searchAGTSADate(bkgMap);
			//log.info("S/A Date :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = dbDao.searchAGTContractInfo(bkgMap);
			//log.info("SC NO, RFA NO,... :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			//log.info("Booking QTY :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = dbDao.searchRevLanebndInfo(bkgMap);
			//log.info("Revenue Lane과 Revenue VVD :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Brokerage 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.createBKGMasterInfo(bkgMap);
			//log.info("bkgMap :"+bkgMap);
			
			// 추가
			//dbDao.processProcedure(bkg_no);
			
			HashMap brkMap = new HashMap();	// Brokerage HashMap 생성
			brkMap.putAll(bkgMap);
			HashMap facMap = new HashMap();	// Fac HashMap 생성
			facMap.putAll(bkgMap);
			HashMap agtMap = new HashMap();	// AGT HashMap 생성
			agtMap.putAll(bkgMap);			
			
			CommonBC commCal = new CommonBCImpl();
			
			// Fac비 계산
			fac_err_msg = facCal.createActualFACComm(facMap);
			// 2008.02.13 FAC 계산시 Exception 시 AGT_ERR_LOG 테이블에 CUD
			HashMap facLogMap = new HashMap();
			facLogMap.put("BKG_NO", bkg_no);
			facLogMap.put("ERR_LOG_FLG", "F");			// 'F' FAC 구분자
			if(!(dbDao.checkNull(fac_err_msg).equals(""))){
				facLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(facLogMap);
			}else{
				facLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(facLogMap);
			}	
			// Brokerage비 계산 
			brog_err_msg = createActualBRKGComm(brkMap);
			// 2008.02.13 Brokerage 계산시 Exception 시 AGT_ERR_LOG 테이블에 CUD
			HashMap brogLogMap = new HashMap();
			brogLogMap.put("BKG_NO", bkg_no);
			brogLogMap.put("ERR_LOG_FLG", "B");			// 'B' Brokerage Commission 구분자
			if(!(dbDao.checkNull(brog_err_msg).equals(""))){
				brogLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(brogLogMap);
			}else{
				brogLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(brogLogMap);
			}	
			// AGT_ERR_LOG 에 Insert 및 Delete용 logMap			
			HashMap logMap = new HashMap();
			
			
			// Agt비 계산
//			if(Integer.parseInt(bkg_cre_dt) >= 20070507){
//				// 1. EAI 연동
//				
//				Thread.sleep(10000);
//				logMap = agtCal.searchRouteInfoforAGT(bkg_no, bkg_no_split);
//				logMap.put("BKG_NO", bkg_no);
//				logMap.put("BKG_NO_SPLIT", bkg_no_split);
//				logMap.put("ERR_LOG_FLG", "R"); 	// 'R' Charge 구분자
//				
//				if(!(dbDao.checkNull((String)logMap.get("ERR_LOG_RMK"))).equals("")){
//					logMap.put("DEL_FLG", "N");		// 에러시 AGT_ERR_LOG 에 Insert				
//					commCal.processAgtErrLog(logMap);
//				}else{
//					logMap.put("DEL_FLG", "Y");		// 정상시 AGT_ERR_LOG 에 Delete
//					commCal.processAgtErrLog(logMap);
//				}
//				logMap.remove("ERR_LOG_RMK");
//			}
			// 2. AGT 계산
			logMap = agtCal.createAcutalAGTComm(agtMap);
			logMap.put("BKG_NO", bkg_no);
			logMap.put("ERR_LOG_FLG", "A");			// 'A' Agent Commission 구분자
			if(!(dbDao.checkNull((String)logMap.get("ERR_LOG_RMK"))).equals("")){
				logMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(logMap);
			}else{
				logMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(logMap);
			}
			
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== END   AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return retUptCnt;
	}
	
	/**
	 * Brokerage Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return Object
	 * @exception EventException
	 */
	public Object createBRKGComm(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		String bkg_cre_dt = "";
		String bkg_sts_cd = "";
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
		bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBookingInfoforComm(bkgMap);
			bkg_cre_dt = dbDao.checkNull((String)bkgMap.get("BKG_CRE_DT"));
			bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						this.processBrokerageCancel(bkg_no, "COMMISSION");
					}
					else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						this.processBrokerageCancel(bkg_no, "COMMISSION");
					}
				return null;
			}
			
//			FACCalcBC facCal = new FACCalcBCImpl();
//			AGTCalcBC agtCal = new AGTCalcBCImpl();
			
			// 2007.05.07 추가 (BKG_CRE_DT 가 2007.05.07 이전인 Booking 은 FAC만 돌린다. 단 AGN_DIV_FLG 가 'N'-지점인 경우만 계산한다.)
			if(Integer.parseInt(bkg_cre_dt) < 20070507){
				bkgMap.put("FLG0507", "COST");
			}else{
				bkgMap.put("FLG0507", "COMMISSION");
			}
			String fLG0507 = (String)bkgMap.get("FLG0507");
			// 2007.06.28 bkg_sts_cd 상태가 Cancel 일때 AGT, BROG, FAC 바로 Cancel 처리
			if(bkg_sts_cd.equals("X")){
				this.processBrokerageCancel(bkg_no, fLG0507);
//				agtCal.processAgtCommissionCancel(bkg_no, bkg_no_split, FLG0507);
//				facCal.processFacCancel(bkg_no, bkg_no_split, FLG0507);
			}
			
			// S/A Date를 구한다.
			bkgMap = dbDao.searchAGTSADate(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return null;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = dbDao.searchAGTContractInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return null;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return null;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = dbDao.searchRevLanebndInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return null;
			}
			
			// Brokerage 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.createBKGMasterInfo(bkgMap);

			// 추가
			//dbDao.processProcedure(bkg_no);
			
			// Brokerage비 계산
			createActualBRKGComm(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return null;
	}

	/**
	 * Brokerage비 계산 배치 처리<br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualBRKGComm(HashMap bkgMap) throws EventException{

		log.debug("\n\n BCImpl에서 createActualBRKGComm 메소드 시작");
		
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";

		int ff_cust_seq = 0;
		int ff_cust_seq_tmp = 999999;
		
		ArrayList brogRtList = null;
		HashMap brogMap = new HashMap();	// Brokerage HashMap 생성

		try {
			// cancel 여부 체크
			bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));
			
			// FAC Agrement 요율 정보를 조회하기 위한 변수
			ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
			sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));

			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				ff_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
				sFf_cust_seq = "000000";
			}
			if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
				sShpr_cust_seq = "000000";
			}

			// Brokerage HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
			brogMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));				// booking no를 셋팅한다.
			brogMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
			brogMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
			brogMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));	// Trunk의 출항일자를 셋팅한다.(Error Message 저장시 사용)
			brogMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
			brogMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ (Error Message 저장시 사용)
			brogMap.put("FLG0507", (String)bkgMap.get("FLG0507"));				// 2007.05.07 이전 부킹인지 구분
			
			bkgMap.put("brogMap", brogMap);					// 생성한 Brokerage HashMap을 Booking Map에 넣는다.
			bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);		// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);	// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			
			// Brokerage 체크
			if(!dbDao.createActualBRKGComm( bkgMap )) {
				return null;
			}
			
			// Brokerage Sequence를 구한다.
			bkgMap = dbDao.searchBRKGRateSequenceInfo( bkgMap );

			if("X".equals(bkg_sts_cd)) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구해온다.

				// Cancel amt를 구해온다.
				bkgMap = dbDao.searchBRKGBKGCancelInfo(bkgMap);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}

			} else {

				// Vendor에 matching 되는 Freight Forwarder Code를 구한 후 MDM Vendor에 존재하는지 체크한다.
				bkgMap = dbDao.searchBRKGCustVndrMatchInfo(bkgMap);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}

				// Brokerage Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
				bkgMap = dbDao.searchBRKGCustShprInterestInfo(bkgMap);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}

				// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다.
				// BL no가 있으면 MEMO BL를 check한다.
				bkgMap = dbDao.checkBRKGOtherInfo(bkgMap);
	
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}

				// Brokerage Agrement 요율 정보를 조회하기 위한 변수
				ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
				sFf_cust_seq =  dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
				
				if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
					ff_cust_seq = Integer.parseInt(sFf_cust_seq);
				}

				// Brokerage Agrement 요율 정보를 조회한다.
				bkgMap = dbDao.searchBRKGAGMTRateInfo( bkgMap, ff_cnt_cd, ff_cust_seq );
				log.info("=========$$$$$$$$$$$$$$$$$$$$$$$$$======= bkgMap = "+ bkgMap);
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}
				// 조회한 Brokerage Agrement 요율 정보를 Booking Map 에서 꺼내온다. 
				brogRtList = (ArrayList)bkgMap.get("brogRtList");
				// Brokerage Agrement 요율 정보가 존재하지 않을 경우 brog_cust_seq=999999로 다시 조회한다.
				if(brogRtList == null || (brogRtList != null && brogRtList.size() <= 0)) {
					bkgMap = dbDao.searchBRKGAGMTRateInfo( bkgMap, ff_cnt_cd, ff_cust_seq_tmp );
				}

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}
				
				// Contaner type/size에 따라서 Brokerage Commission을 계산한다.
				bkgMap = dbDao.calcBRKGCommInfo(bkgMap);
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}
				
				// Brokerage Commission을 저장한다.
				bkgMap = dbDao.createBRKGCommInfo(bkgMap);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkBrogError( bkgMap )) {
					return null;
				}
			}

			// Brokerage Commission Detail을 저장한다.
			bkgMap = dbDao.createBRKGTPSZCommInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkBrogError( bkgMap )) {
				return null;
			}
			
			// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
//			bkgMap = dbDao.createBRKGTPSZSummation(bkgMap);
			
			// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
			dbDao.checkBRKGCustName(bkgMap);
			
			return null;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
			return de.toString();
		}
	}

	/**
	 * Brokerage Commission ReCalculate 대한 처리<br>
	 * 
	 * @param  Event ev
	 * @exception EventException
	 */
	public void reCalcBRKGComm(Event ev) throws EventException{
		
		//EsmAgt0013Event event = (EsmAgt0013Event)ev;

		String sCheck = "";
		String bkg_no = "";
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";

		int ff_cust_seq = 0;
		int ff_cust_seq_tmp = 999999;
		
		String bkg_cre_dt = "";

		String[] sBkg_no 		= null;//event.getObject("bkg_no");
		String[] check 			= null;//event.getObject("check");

		try {

			if(check != null){

				// Loop를 돌면서 처리한다.
				for (int j=0; j<check.length; j++) {
	
					sCheck = check[j]==null?"":check[j];
	
					if ( sCheck.equals("1") ) {
						
						HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
						HashMap brogMap = new HashMap(); // Brokerage HashMap 생성
						ArrayList brogRtList = null; // Brokerage Rate를 담아 두는 ArrayList
						
						bkg_sts_cd = ""; // 초기화
						ff_cnt_cd = ""; // 초기화
						sFf_cust_seq = ""; // 초기화
						sShpr_cust_seq = ""; // 초기화
						ff_cust_seq = 0; // 초기화

						bkg_no = sBkg_no[j];
						// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
						bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
						bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.
						
						// Booking 정보를 조회한다.
						bkgMap = dbDao.searchBookingInfoforComm(bkgMap);
						bkg_cre_dt = dbDao.checkNull((String)bkgMap.get("BKG_CRE_DT"));
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									this.processBrokerageCancel(bkg_no, "COMMISSION");
								}
								else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									this.processBrokerageCancel(bkg_no, "COMMISSION");
								}
							continue;
						}
						
//						FACCalcBC facCal = new FACCalcBCImpl();
//						AGTCalcBC agtCal = new AGTCalcBCImpl();
						
						// 2007.05.07 추가 (BKG_CRE_DT 가 2007.05.07 이전인 Booking 은 FAC만 돌린다. 단 AGN_DIV_FLG 가 'N'-지점인 경우만 계산한다.)
						if(Integer.parseInt(bkg_cre_dt) < 20070507){
							bkgMap.put("FLG0507", "COST");
						}else{
							bkgMap.put("FLG0507", "COMMISSION");
						}
						String fLG0507 = (String)bkgMap.get("FLG0507");
						// 2007.06.28 bkg_sts_cd 상태가 Cancel 일때 AGT, BROG, FAC 바로 Cancel 처리
						if(bkg_sts_cd.equals("X")){
							this.processBrokerageCancel(bkg_no, fLG0507);
//							agtCal.processAgtCommissionCancel(bkg_no, bkg_no_split, FLG0507);
//							facCal.processFacCancel(bkg_no, bkg_no_split, FLG0507);
						}
						
						// S/A Date를 구한다.
						bkgMap = dbDao.searchAGTSADate(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}

						// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
						bkgMap = dbDao.searchAGTContractInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Booking QTY물량을 구한다.	
						bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Revenue Lane과 Revenue VVD를 구한다.	
						bkgMap = dbDao.searchRevLanebndInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}
						
						// Brokerage 계산전에 Booking Commission 정보 테이블에 저장한다.
						dbDao.createBKGMasterInfo(bkgMap);

						// 추가
						//dbDao.processProcedure(bkg_no);
						
						// Brokerage비 계산 ----------------start----------------
						// cancel 여부 체크하기 위하여 Booking의 Status를 가져온다.
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));
						
						// FAC Agrement 요율 정보를 조회하기 위한 변수
						ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
						sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
						sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));

						if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
							ff_cust_seq = Integer.parseInt(sFf_cust_seq);
						}
						if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
							sFf_cust_seq = "000000";
						}
						if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
							sShpr_cust_seq = "000000";
						}

						// Brokerage HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						brogMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));				// booking no를 셋팅한다.
						brogMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
						brogMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
						brogMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));	// Trunk의 출항일자를 셋팅한다.(Error Message 저장시 사용)
						brogMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
						brogMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ (Error Message 저장시 사용)
						brogMap.put("FLG0507", (String)bkgMap.get("FLG0507"));				// 2007.05.07 이전 부킹인지 구분
						
						bkgMap.put("brogMap", brogMap);					// 생성한 Brokerage HashMap을 Booking Map에 넣는다.
						bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);		// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);	// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						
						// Brokerage 체크
						if(!dbDao.createActualBRKGComm( bkgMap )) {
							continue;
						}
						
						// Brokerage Sequence를 구한다.
						bkgMap = dbDao.searchBRKGRateSequenceInfo( bkgMap );

						if("X".equals(bkg_sts_cd)) {	// Interface 했는데 status가 cancel 경우 Brokerage비 계산

							// Brokerage amt를 구해온다.
							bkgMap = dbDao.searchBRKGBKGCancelInfo(bkgMap);

							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}

						} else {

							// Vendor에 matching 되는 Freight Forwarder Code를 구한 후 MDM Vendor에 존재하는지 체크한다.
							bkgMap = dbDao.searchBRKGCustVndrMatchInfo(bkgMap);

							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}

							// Brokerage Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
							bkgMap = dbDao.searchBRKGCustShprInterestInfo(bkgMap);

							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}

							// 미국인 경우 Shipper와 Freight Forwarder가 동일하면 주지 않는다.
							// BL no가 있으면 MEMO BL를 check한다.
							bkgMap = dbDao.checkBRKGOtherInfo(bkgMap);
				
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}

							// Brokerage Agrement 요율 정보를 조회하기 위한 변수
							ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
							sFf_cust_seq =  dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
							
							if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
								ff_cust_seq = Integer.parseInt(sFf_cust_seq);
							}

							// Brokerage Agrement 요율 정보를 조회한다.
							bkgMap = dbDao.searchBRKGAGMTRateInfo( bkgMap, ff_cnt_cd, ff_cust_seq );
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}
							
							// 조회한 Brokerage Agrement 요율 정보를 Booking Map 에서 꺼내온다. 
							brogRtList = (ArrayList)bkgMap.get("brogRtList");

							// Brokerage Agrement 요율 정보가 존재하지 않을 경우 brog_cust_seq=999999로 다시 조회한다.
							if(brogRtList == null || (brogRtList != null && brogRtList.size() <= 0)) {
								bkgMap = dbDao.searchBRKGAGMTRateInfo( bkgMap, ff_cnt_cd, ff_cust_seq_tmp );
							}

							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}
							
							// Contaner type/size에 따라서 Brokerage Commission을 계산한다.
							bkgMap = dbDao.calcBRKGCommInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}
							
							// Brokerage Commission을 저장한다.
							bkgMap = dbDao.createBRKGCommInfo(bkgMap);

							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkBrogError( bkgMap )) {
								continue;
							}
						}

						// Brokerage Commission Detail을 저장한다.
						bkgMap = dbDao.createBRKGTPSZCommInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkBrogError( bkgMap )) {
							continue;
						}
						
						// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
//						bkgMap = dbDao.createBRKGTPSZSummation(bkgMap);
						
						// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
						dbDao.checkBRKGCustName(bkgMap);
						// Brokerage비 계산 ----------------end----------------
					} // end if
				} // end for
			} // end if
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTCalc업무 시나리오 종료시 관련 내부객체 해제<br>
	 */	
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkError( HashMap map ) {

		String error_msg = dbDao.checkNull((String)map.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * Brokerage Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkBrogError( HashMap map ) {

		HashMap bMap = (HashMap)map.get("brogMap");
		String error_msg = dbDao.checkNull((String)bMap.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Booking 정보를 조회한다.<br>
	 * 
	 * @param bkgMap HashMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBookingInfoforComm(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBookingInfoforComm(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	
	/**
	 * S/A Date를 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchAGTSADate(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchAGTSADate(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	
	/**
	 * SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchAGTContractInfo(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchAGTContractInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	
	/**
	 * Booking QTY물량을 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	
	/**
	 * Revenue Lane과 Revenue VVD를 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchRevLanebndInfo(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchRevLanebndInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return bkgMap;
	}
	
	/**
	 * 대리점/Brokerage/FAC 계산전에 Booking Commission 정보 테이블에 저장한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @exception EventException
	 */
	public void createBKGMasterInfo(HashMap bkgMap) throws EventException{

		try {

			// Booking 정보를 조회한다.
			dbDao.createBKGMasterInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 수동 Batch용 Agent, Brog, Fac Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @param String interFlag
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int agtCalculationOne(String bkg_no, String interFlag) throws EventException{
		
		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		int retUptCnt = 0;
//		String bkg_cre_dt = "";
//		String bkg_sts_cd = "";
		String fac_err_msg = "";
		String brog_err_msg = "";
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		//log.info(" ============ START CreateAgentComm ================================================================================");
		//log.info(" ============ BKG_NO : "+ bkg_no);

		try {
			
			FACCalcBC facCal = new FACCalcBCImpl();
			AGTCalcBC agtCal = new AGTCalcBCImpl();
			
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== START AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBookingInfoforComm(bkgMap);
			//log.info("Booking :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return -1;
			}
			
			// S/A Date를 구한다.
			bkgMap = dbDao.searchAGTSADate(bkgMap);
			//log.info("S/A Date :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = dbDao.searchAGTContractInfo(bkgMap);
			//log.info("SC NO, RFA NO,... :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			//log.info("Booking QTY :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = dbDao.searchRevLanebndInfo(bkgMap);
			//log.info("Revenue Lane과 Revenue VVD :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return -1;
			}
			
			// Brokerage 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.createBKGMasterInfo(bkgMap);
			//log.info("bkgMap :"+bkgMap);
			
			// 추가
			//dbDao.processProcedure(bkg_no);
			
			HashMap brkMap = new HashMap();	// Brokerage HashMap 생성
			brkMap.putAll(bkgMap);
			HashMap facMap = new HashMap();	// Fac HashMap 생성
			facMap.putAll(bkgMap);
			HashMap agtMap = new HashMap();	// AGT HashMap 생성
			agtMap.putAll(bkgMap);
			
			CommonBC commCal = new CommonBCImpl();
			
			// Fac비 계산
			fac_err_msg = facCal.createActualFACComm(facMap);
			// 2008.02.13 FAC 계산시 Exception 시 AGT_ERR_LOG 테이블에 CUD
			HashMap facLogMap = new HashMap();
			facLogMap.put("BKG_NO", bkg_no);
			facLogMap.put("ERR_LOG_FLG", "F");			// 'F' FAC 구분자
			if(!(dbDao.checkNull(fac_err_msg).equals(""))){
				facLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(facLogMap);
			}else{
				facLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(facLogMap);
			}	
			// Brokerage비 계산 
			brog_err_msg = createActualBRKGComm(brkMap);
			// 2008.02.13 Brokerage 계산시 Exception 시 AGT_ERR_LOG 테이블에 CUD
			HashMap brogLogMap = new HashMap();
			brogLogMap.put("BKG_NO", bkg_no);
			brogLogMap.put("ERR_LOG_FLG", "B");			// 'B' Brokerage Commission 구분자
			if(!(dbDao.checkNull(brog_err_msg).equals(""))){
				brogLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(brogLogMap);
			}else{
				brogLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(brogLogMap);
			}
			
			// AGT_ERR_LOG 에 Insert 및 Delete용 logMap			
			HashMap logMap = new HashMap();
							
			// Agt비 계산
			if(interFlag.equals("on")){
				interFlag = "on";
//				if(Integer.parseInt(bkg_cre_dt) >= 20070507){
//					// 1. EAI 연동
//					
//					Thread.sleep(10000);
//					logMap = agtCal.searchRouteInfoforAGT(bkg_no, bkg_no_split);
//					logMap.put("BKG_NO", bkg_no);
//					logMap.put("BKG_NO_SPLIT", bkg_no_split);
//					logMap.put("ERR_LOG_FLG", "R");
//					
//					if(!(dbDao.checkNull((String)logMap.get("ERR_LOG_RMK"))).equals("")){
//						logMap.put("DEL_FLG", "N");					
//						commCal.processAgtErrLog(logMap);
//					}else{
//						logMap.put("DEL_FLG", "Y");
//						commCal.processAgtErrLog(logMap);
//					}
//					logMap.remove("ERR_LOG_RMK");
//				}
			}
			// 2007.06.18 추가 (Commission 재계산시 Tran 비용을 배치와 다른 메소드 호출하기 위한 FLAG 추가)
			agtMap.put("RECAL_TRANS_FLG", "N");
			
			// 2. AGT 계산
			logMap = agtCal.createAcutalAGTComm(agtMap);
			logMap.put("BKG_NO", bkg_no);
			logMap.put("ERR_LOG_FLG", "A");
			
			if(!(dbDao.checkNull((String)logMap.get("ERR_LOG_RMK"))).equals("")){ 
				logMap.put("DEL_FLG", "N");					
				commCal.processAgtErrLog(logMap);
			}else{
				logMap.put("DEL_FLG", "Y");
				commCal.processAgtErrLog(logMap);
			}
					
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== END   AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
			int errNo = -2;
			return errNo;
		}
		
		return retUptCnt;
	}
	

	
	
	/**
	 * Brokerage Cancel 처리한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processBrokerageCancel(String bkg_no, String FLG0507) throws EventException{

		HashMap bkgMap = new HashMap();
		HashMap brogMap = new HashMap();
		String errMsg = "";
		
		try {
			brogMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
			bkgMap.put("brogMap", brogMap);
			
			bkgMap.put("BKG_NO", bkg_no);
			bkgMap.put("FLG0507", FLG0507);
			// Brokerage Sequence를 구한다.
			bkgMap = dbDao.searchBRKGRateSequenceInfo( bkgMap );
			errMsg = dbDao.checkNull((String)bkgMap.get("CANCEL_BRO"));
			if(!errMsg.equals("")){
				return;
			}
			//Cancel amt를 구해온다.
			bkgMap = dbDao.searchBRKGBKGCancelInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
		}
	}
	
}

///**
// * test 호출<br>
// * @param String cost_yrmon
// * @return DBRowSet
// * @exception EventException
// */
//public DBRowSet testAgentComm(String cost_yrmon) throws EventException{
//	DBRowSet dRs = null;
//
//	try {
//
//		// Booking 정보를 조회한다.
//		dRs = dbDao.testProgessAgentComm(cost_yrmon);
//					
//	} catch (DAOException de) {
//		log.error("err "+de.toString(),de);
//		throw new EventException(de.getMessage());
//	}
//	return dRs;
//}
///**
// * AGT_BKG_REV_VVD_PRC Procedure 호출<br>
// * 
// * @param String bkg_no
// * @exception EventException
// */
//public void callProcedure(String bkg_no) throws EventException{
//
//	try {
//		// AGT_BKG_REV_VVD_PRC Procedure 호출
//		dbDao.processProcedure(bkg_no);						
//	} catch (DAOException de) {
//		log.error("err "+de.toString(),de);
//		throw new EventException(de.getMessage());
//	}
//}
