/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCalcBCImpl.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2007-01-18 SangJun Kwon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic;

import java.util.HashMap;

import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.integration.AGTCalcDBDAO;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-agt Business Logic Basic Command implementation<br>
 * - eNIS-agt에 대한 Agent Commission 값을 계산한다.<br>
 * 
 * @author SangJun Kwon
 * @see AGTCalcBC
 * @since J2EE 1.4
 */
public class AGTCalcBCImpl extends BasicCommandSupport implements AGTCalcBC {

	// Database Access Object
	private transient AGTCalcDBDAO dbDao=null;
	private transient BRKGCalcBC brkgBC=null;

	/**
	 * AGTCalcBCImpl 객체 생성<br>
	 * AGTCalcDBDAO를 생성한다.<br>
	 */
	public AGTCalcBCImpl(){
		dbDao = new AGTCalcDBDAO();
		brkgBC = new BRKGCalcBCImpl();
	}

	/**
	 * Agent Commission ReCalculate 대한 처리<br>
	 * 
	 * @param bkg_no Booking Number
	 * @return String
	 * @exception EventException
	 */
	public String createAGTComm(String bkg_no) throws EventException
	{
		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		
		// 2007.05.16 추가 (Commission 재계산시 Tran 비용을 배치와 다른 메소드 호출하기 위한 FLAG 추가)
		// 재계산시 COA_BKG_COST_SRC_DTL에서 TRS비용 가져오도록 수정
		bkgMap.put("RECAL_TRANS_FLG", "Y");

		try 
		{
			// Booking 정보를 조회한다.
			bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
			//log.info("1.bkgMap searchBookingInfoforComm: "+ bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return null;
			}

			// S/A Date를 구한다.
			bkgMap = brkgBC.searchAGTSADate(bkgMap);
			//log.info("2.bkgMap searchAGTSADate: "+ bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return null;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
			//log.info("3.bkgMap searchAGTContractInfo: "+ bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return null;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = brkgBC.searchBKGQTYInfo(bkgMap);
			//log.info("4.bkgMap searchBKGQTYInfo: "+ bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return null;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
			//log.info("5.bkgMap searchRevLanebndInfo: "+ bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if (checkError( bkgMap ))
			{
				return null;
			}
			
			// Agent Commission 계산전에 Booking Commission 정보 테이블에 저장한다.
			brkgBC.createBKGMasterInfo(bkgMap);
			
			// AGT_BKG_REV_VVD_PRC Procedure 호출
			//brkgBC.callProcedure(bkg_no);
			
			// 2007.05.10 연동추가
			//this.searchRouteInfoforAGT(bkg_no, bkg_no_split);
			
			// Agent Commission 계산
			this.createAcutalAGTComm(bkgMap);
			
		}
		catch (Exception e)
		{
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return null;
	}


	/**
	 * 배치 처리<br>
	 * Agent Commission 계산 <br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 */
	public HashMap createAcutalAGTComm(HashMap bkgMap) throws EventException
	{
		int updateCnt = 0;
		int rgnbaFlag = 0;
		HashMap agtMap = new HashMap();	// AGT HashMap 생성
		agtMap.putAll(bkgMap);
		
		String bkg_no = (String)agtMap.get("BKG_NO");
//		String reCalFlag = dbDao.checkNull((String)agtMap.get("RECAL_TRANS_FLG"));
		// Agent HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		agtMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
		agtMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
		
		try
		{
			
			// 2007.11.23 POR_AR_OFC_CD = RGNBA일 경우 Flag 지정(cre_usr_id 가 RGNBA인 것이 있으면 BKG_AR_OFC_CD = RGNBA로 강제로 바꾼다.
			if((dbDao.checkNull((String)agtMap.get("POR_AR_OFC_CD"))).equals("RGNBA")){
				rgnbaFlag = dbDao.getRgnbaOutBoundCheck(bkg_no);
				if(rgnbaFlag > 0){
					agtMap.put("CHECK_RGNBA", "Y");
				}
			}
			
			agtMap = dbDao.searchAGTCHNAROFCInfo(agtMap); //CHU: 'CE'상태의 데이터를 찾아서 삭제
			//log.info("AGTMAP searchAGTCHNAROFCInfo: " + agtMap);
			
			agtMap = dbDao.searchAGTAGMTMasterInfo(agtMap);
			//2012.03.07 log.info -> 주석처리
			//log.info("\n @@@ AGREEMENT MASTER: agtMap: " + agtMap); // (kevin) Finc Office별 루프를 돌면서 Agreement 조회
			
			agtMap = dbDao.searchAGTFinanceAccountInfo(agtMap); //CHU: fincOfcList로 LOOPING하면서 COMMISSION계산
			//log.info("\n>>>>>>>>>> agtMap : " + agtMap); // (kevin) COMM_REV_DIR_CD가 확정됨
			
			updateCnt = dbDao.createAGTActualCommToCOA(bkg_no);
			//log.info("updateCnt createAGTActualCommToCOA: " + updateCnt);
			
			// 2007.08.21 추가 (Re-Calculation 시 COA 1분 배치 돌수 있도록 sce_bkg_if 테이블에 Update
			// 권상준 : SCE_BKG_IF에 Update하여 Live 소스로 재계산하게 함.
//			if(reCalFlag.equals("Y")){
//				log.info("\n ----------------------------------------> createAcutalAGTComm() : SCE_BKG_IF에 Update ..");
//				reCalculateBatchToCOA(bkg_no);
			//	dbDao.updateSceBkgIf(bkg_no);
//			}
//			CMAGTCalcBC cmdCMAGTCalc = new CMAGTCalcBCImpl();

//				cmdCMAGTCalc.createCMComm("PHXY71700313103");
			
		}
		catch (DAOException de)
		{
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
			HashMap logMap = new HashMap();
			logMap.put("ERR_LOG_RMK", de.toString());
			return logMap;
		}
		return bkgMap;
	}


	/**
	 * 배치 처리<br>
	 * 모든 Commission 계산 후 COA에 UPDATE <br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventException
	 */
	public int createAGTActualCommToCOA(String bkg_no) throws EventException
	{
		int result_cnt = 0;
		
		try
		{			
//			CostAssignBC command = new CostAssignBCImpl();
//			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();

			 

//			//아래 5개의 컬럼 필수 입력

//			coaBkgComIfVo.setBkgNo(bkg_no);//Booking Number
//			coaBkgComIfVo.setCostSrcSysCd("AGT");//TRS, TES, SCE, BKG, AGT 등 SUB SYSTEM CODE
//			coaBkgComIfVo.setIfRmk("AGT RECALC");//IF Remark 변경됬을시 통보 요청
//			coaBkgComIfVo.setCreUsrId("AGT SYSTEM");//로그인 유저 아이디
//			coaBkgComIfVo.setUpdUsrId("AGT SYSTEM");//로그인 유저 아이디

			//result_cnt가 0보다 작으면 수행 시 에러가 난 경우임

//			result_cnt = command .modifyCoaCommonInterface(coaBkgComIfVo);

			result_cnt = dbDao.createAGTActualCommToCOA(bkg_no);
			//log.info("updateCnt createAGTActualCommToCOA: " + result_cnt);
			
		}
		catch (DAOException de)
		{
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return result_cnt;
	}
			
	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTCalc업무 시나리오 종료시 관련 내부객체 해제<br>
	 */	
	public void doEnd()
	{
		dbDao = null;
	}
	
	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkError( HashMap map )
	{

		String error_msg = map.get("COMM_PROC_RSLT_RSN")==null?"":(String)map.get("COMM_PROC_RSLT_RSN");
		
		if (error_msg.length() > 0)
		{
			return true;
		}
		return false;
	}


	/**
	 * AGT Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param HashMap map 
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkAgtError( HashMap map )
	{
		String error_msg = map.get("COMM_PROC_STS_RSN")==null?"":(String)map.get("COMM_PROC_STS_RSN");
		
		if (error_msg.length() > 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 배치 처리를 재실행한다.<br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventException
	 */
	public int reCalculateBatchToCOA(String bkg_no) throws EventException{
		int result_cnt = 0;
		
		try
		{
//			CostAssignBC command = new CostAssignBCImpl();
//			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//
//			//아래 5개의 컬럼 필수 입력
//
//			coaBkgComIfVo.setBkgNo(bkg_no);//Booking Number
//			coaBkgComIfVo.setCostSrcSysCd("AGT");//TRS, TES, SCE, BKG, AGT 등 SUB SYSTEM CODE
//			coaBkgComIfVo.setIfRmk("AGT RECALC");//IF Remark 변경됬을시 통보 요청
//			coaBkgComIfVo.setCreUsrId("AGT SYSTEM");//로그인 유저 아이디
//			coaBkgComIfVo.setUpdUsrId("AGT SYSTEM");//로그인 유저 아이디
//
//			//result_cnt가 0보다 작으면 수행 시 에러가 난 경우임
//
//			result_cnt = command .modifyCoaCommonInterface(coaBkgComIfVo);
//
////			updateCnt = dbDao.createAGTActualCommToCOA(bkg_no);
////			log.info("updateCnt createAGTActualCommToCOA: " + updateCnt);
			
		}
		catch (Exception de)
		{
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return result_cnt;
	}
}