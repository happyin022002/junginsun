/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTCalcToCoaBCImpl.java
 *@FileTitle : Agent Monthly Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 추경원
 *@LastVersion : 1.0
 * 2009.09.16 추경원
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.agtcalctocoa.basic;

import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.integration.BRKGCalcDBDAO;
import com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBCImpl;
import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-AGTCalculation Business Logic Basic Command implementation<br>
 * - OPUS-AGTCalculation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyung-won Chu
 * @see EsmAgt0019EventResponse,AGTClosingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGTCalcToCoaBCImpl extends BasicCommandSupport implements AGTCalcToCoaBC {
	// Database Access Object
	private transient BRKGCalcDBDAO dbDao=null;
	/**
	 * Agent Commission Calculation 처리<br>
	 */
	public AGTCalcToCoaBCImpl() {
		dbDao = new BRKGCalcDBDAO();
	}
	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param bkg_no String
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createAgentComm(String bkg_no) throws EventException
	{
		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		int retUptCnt = 0;
		String fac_err_msg = "";
		String brog_err_msg = "";
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		log.info("\n ============ START CreateAgentComm ============================================================================="
		       + "\n ============ BKG_NO       : "+ bkg_no);

		try {
			
			FACCalcBC facCal = new FACCalcBCImpl();
			AGTCalcBC agtCal = new AGTCalcBCImpl();
			BRKGCalcBC brkgCal = new BRKGCalcBCImpl();
			
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== START AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
			// Booking 정보를 조회한다.
			bkgMap = dbDao.searchBookingInfoforComm(bkgMap);
			
			log.info("Booking :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return 0;
			}
			
			// S/A Date를 구한다.
			bkgMap = dbDao.searchAGTSADate(bkgMap);
			//log.info("S/A Date :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return 0;
			}
			
			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = dbDao.searchAGTContractInfo(bkgMap);
			//log.info("SC NO, RFA NO,... :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return 0;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			//log.info("Booking QTY :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return 0;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = dbDao.searchRevLanebndInfo(bkgMap);
			//log.info("Revenue Lane과 Revenue VVD :"+bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return 0;
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
			HashMap<String, String> facLogMap = new HashMap<String, String>();
			facLogMap.put("BKG_NO", bkg_no);
			facLogMap.put("ERR_LOG_FLG", "F");			// 'F' FAC 구분자
			if (!(dbDao.checkNull(fac_err_msg).equals("")))
			{
				facLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert
				commCal.processAgtErrLog(facLogMap);
			}
			else
			{
				facLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(facLogMap);
			}	
			// Brokerage비 계산 
			brog_err_msg = brkgCal.createActualBRKGComm(brkMap);
			// 2008.02.13 Brokerage 계산시 Exception 시 AGT_ERR_LOG 테이블에 CUD
			HashMap<String, String> brogLogMap = new HashMap<String, String>();
			brogLogMap.put("BKG_NO", bkg_no);
			brogLogMap.put("ERR_LOG_FLG", "B");			// 'B' Brokerage Commission 구분자
			if (!(dbDao.checkNull(brog_err_msg).equals("")))
			{
				brogLogMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(brogLogMap);
			}
			else
			{
				brogLogMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(brogLogMap);
			}	
			// AGT_ERR_LOG 에 Insert 및 Delete용 logMap			
			HashMap<String, String> logMap = new HashMap<String, String>();

			// 2. AGT 계산
			logMap = agtCal.createAcutalAGTComm(agtMap);
			logMap.put("BKG_NO", bkg_no);
			logMap.put("ERR_LOG_FLG", "A");			// 'A' Agent Commission 구분자
			if (!(dbDao.checkNull((String)logMap.get("ERR_LOG_RMK"))).equals(""))
			{
				logMap.put("DEL_FLG", "N");			// 에러시 AGT_ERR_LOG 에 Insert						
				commCal.processAgtErrLog(logMap);
			}
			else
			{
				logMap.put("DEL_FLG", "Y");			// 정상시 AGT_ERR_LOG 에 Delete
				commCal.processAgtErrLog(logMap);
			}
			
			// DB 로그 테이블에 저장한다.
			//dbDao.createLog("===== END   AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split);
			
		}
		catch (Exception de)
		{
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return retUptCnt;

	}

	/**
	 * Agent Commission CM Calculation 처리<br>
	 * createAgentComm()에서 계산된 커미션금액에 대한 평균단가를 COA_COM_COST_PARA 테이블에 update 한다.
	 * @param receive_cd String
	 * @return int(0 : 정상처리, -1 : 에러)
	 * @exception EventException
	 */
	public int createCMComm(String receive_cd) throws EventException
	{
		int returnNo = 0;
		try
		{
			CMAGTCalcBC command = new CMAGTCalcBCImpl();
			returnNo = command.createCMComm(receive_cd);
		}
		catch (Exception de)
		{
			return 0;
		}
		return returnNo;
	}


	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 Map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	private boolean checkError( HashMap map ) {

		String error_msg = dbDao.checkNull((String)map.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}
}