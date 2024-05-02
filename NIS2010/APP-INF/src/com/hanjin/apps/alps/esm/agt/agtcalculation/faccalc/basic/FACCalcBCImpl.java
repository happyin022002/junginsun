/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACCalcBCImpl.java
*@FileTitle : FAC Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-01-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-01-15 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.basic.FACAuditBC;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.integration.FACCalcDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-agt Business Logic Basic Command implementation<br>
 * - eNIS-agt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hwang GyeongNam
 * @see ESM_AGT_008_03EventResponse,FACCalcBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class FACCalcBCImpl extends BasicCommandSupport implements FACCalcBC {

	// Database Access Object
	private transient FACCalcDBDAO dbDao=null;
	private transient BRKGCalcBC brkgBC=null;
	//private transient FACAuditBC facAuditBC=null;

	/**
	 * FACCalcBCImpl 객체 생성<br>
	 * FACCalcDBDAO를 생성한다.<br>
	 */
	public FACCalcBCImpl(){
		dbDao = new FACCalcDBDAO();
		brkgBC = new BRKGCalcBCImpl();
	}

	/**
	 * FAC Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventException
	 */
	public int createFACCommInv(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		
		int cnt = -1;
		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
		bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.
		bkgMap.put("reCalcYN", "N");				// reCalculation 여부
		
		try {

			// Booking 정보를 조회한다.
			bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}
					else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}

				return 0;
			}
			
			// S/A Date를 구한다.
			bkgMap = brkgBC.searchAGTSADate(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
			brkgBC.createBKGMasterInfo(bkgMap);

			// AGT_BKG_REV_VVD_PRC Procedure 호출
			//brkgBC.callProcedure(bkg_no);
			
			// FAC비 계산
			createActualFACComm(bkgMap);
			cnt = 1;
			
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return cnt;
	}

	
	/**
	 * FAC Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return Object 배치처리 결과
	 * @exception EventException
	 */
	public Object createFACComm(String bkg_no) throws EventException{

		HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
		

		
		// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
		bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
		bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
		bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
		bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.
		bkgMap.put("reCalcYN", "N");				// reCalculation 여부
		
		try {

			// Booking 정보를 조회한다.
			bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}
					else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
					{
						processFacCancel(bkg_no, "COMMISSION");
					}

				return 0;
			}
			
			// S/A Date를 구한다.
			bkgMap = brkgBC.searchAGTSADate(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Booking QTY물량을 구한다.	
			bkgMap = dbDao.searchBKGQTYInfo(bkgMap);
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( bkgMap )) {
				return 0;
			}
			
			// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
			brkgBC.createBKGMasterInfo(bkgMap);

			// AGT_BKG_REV_VVD_PRC Procedure 호출
			//brkgBC.callProcedure(bkg_no);
			
			// FAC비 계산
			createActualFACComm(bkgMap);
			
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return 0;
	}

	
	
	/**
	 * FAC비 계산 배치 처리<br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualFACComm(HashMap bkgMap) throws EventException{

		log.debug("\n\n BCImpl에서 createActualFACComm 메소드 시작");

		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";

		int ff_cust_seq = 0;
		int ff_cust_seq_tmp = 999999;

		HashMap facMap = new HashMap();	// FAC HashMap 생성
		HashMap facCalcRtMap = new HashMap();	// FAC Rate HashMap 생성		

		try {
			// cancel 여부 체크
			bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

			// FAC Agrement 요율 정보를 조회하기 위한 변수
			fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD")); // 먼저 PPD_OFC_CD로 요율정보를 조회한다.
			ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
			sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));

			// 2007.05.14 일 수정(HYKIM)
//			if( fac_ofc_cd.length() <= 0 ) {
//				bkgMap.put("PPD_OFC_CD", (String)bkgMap.get("BKG_SLS_OFC_CD"));
//				fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
//			}
			
			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				ff_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
				sFf_cust_seq = "000000";
			}
			if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
				sShpr_cust_seq = "000000";
			}
			
			// FAC HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
			facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no를 셋팅한다.
			facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
			facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
			facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// Trunk의 출항일자를 셋팅한다.(Error Message 저장시 사용)
			facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD를 SLS_OFC_CD로 셋팅한다.(Error Message 저장시 사용)
			facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
			facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ (Error Message 저장시 사용)
			bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta 유무 확인

			bkgMap.put("facMap", facMap);										// 생성한 FAC HashMap을 Booking Map에 넣는다.
			bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
			bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)

			// FAC 체크
			if(!dbDao.createActualFACComm( bkgMap )) {
				return null;
			}

			// FAC Sequence를 구한다.
			bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

			if("X".equals(bkg_sts_cd)) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구해온다.
				
				// Cancel amt를 구해온다.
				bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}

			} else {

				// 2007.12.24 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
				bkgMap = dbDao.checkPpdOfcCd(bkgMap);
				
				//Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				
				// FAC Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
				bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				// BL no가 있으면 MEMO BL를 check한다.
				bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
				// 2007.05.07 추가 (BKG_CRE_DT 가 2007.05.07 이전인 Booking 은 FAC만 돌린다. 단 AGN_DIV_FLG 가 'N'-지점인 경우만 계산한다.)
				//log.info("AGN_DIV_FLG 가 'N'-지점인 경우만 계산한다. :"+dbDao.checkNull((String)bkgMap.get("CAL_AGN_DIV_FLG")));
//				if(dbDao.checkNull((String)bkgMap.get("CAL_AGN_DIV_FLG")).equals("Y")){
//					return null;
//				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}
				
				// Freight Forwarder를 다시 가지고 온다.
				ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
				sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
				
				if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
					ff_cust_seq = Integer.parseInt(sFf_cust_seq);
				}
				
				facMap = (HashMap)bkgMap.get("facMap");
				facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
				facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ (Error Message 저장시 사용)
				bkgMap.put("facMap", facMap);

				// 먼저 PPD_OFC_CD로 요율정보를 조회한다.
				// FAC Agrement 요율 정보를 조회한다. 1번째
				bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
				//log.info("1번째 :"+bkgMap);
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}

				// Rete 존재 유무를 가지고온다.
				facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));
				//log.info("Rete 존재 유무 1:"+facRtBreakYN);
				if( "N".equals(facRtBreakYN) ) { // Rate가 존재하지 않을 경우
					
					// FAC Agrement 요율 정보가 존재하지 않을 경우 ff_cust_seq=999999로 다시 조회한다. 2번째
					bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq_tmp, false );
					//log.info("2번째 :"+bkgMap);
					// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
					if(checkFacError( bkgMap )) {
						return null;
					}

					// Rete 존재 유무를 가지고온다.
					facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));
					//log.info("Rete 존재 유무 2:"+facRtBreakYN);
					// PPD_OFC_CD로 요율 정보가 존재하지 않을 경우 AR_OFC_CD로 조회한다.
					if( "N".equals(facRtBreakYN) ) { // Rate가 존재하지 않을 경우

						facMap = (HashMap)bkgMap.get("facMap");		
						fac_ofc_cd = dbDao.checkNull((String)facMap.get("AR_OFC_CD"));
						
						// FAC Agrement 요율 정보를 조회한다. 3번째
						bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
						//log.info("3번째 :"+bkgMap);
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkFacError( bkgMap )) {
							return null;
						}

						// Rete 존재 유무를 가지고온다.
						facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));				
						//log.info("Rete 존재 유무 3:"+facRtBreakYN);
						if( "N".equals(facRtBreakYN) ) { // Rate가 존재하지 않을 경우
							
							// FAC Agrement 요율 정보가 존재하지 않을 경우 AR_OFC_CD와 ff_cust_seq=999999로 다시 조회한다. 4번째
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq_tmp, false );
							//log.info("4번째 :"+bkgMap);
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}
						}
					}
				}

				facMap = (HashMap)bkgMap.get("facMap");
				facMap.put("FAC_RT_OFC_CD", fac_ofc_cd);
				
				// Contaner type/size에 따라서 FAC Commission을 계산한다.
				bkgMap = dbDao.calcFACCommInfo(bkgMap);
				//log.info("BKGMAP : "+bkgMap);
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}

				//log.info("\n $$ -----------------------------------------------------------------");			
				//log.info("\n bkgMap : " + bkgMap);			
				//log.info("\n facMap : " + facMap);			


				// FAC Commission을 저장한다.
				bkgMap = dbDao.createFACCommInfo(bkgMap);
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFacError( bkgMap )) {
					return null;
				}
			}
			
			// FAC Commission Detail을 저장한다.
			bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkFacError( bkgMap )) {
				return null;
			}
			
			// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
			bkgMap = dbDao.createFACTPSZSummation(bkgMap);
			
			// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
			//dbDao.checkFACCustName(bkgMap);
			
			return null;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
			
			return de.toString();
		}
	}

	
	
	
	
	
	
	/**
	 * FAC Commission ReCalculate 대한 처리<br>
	 * 
	 * @param  Event ev
	 * @return Object 배치처리 결과
	 * @exception EventException
	 */
	public Object reCalcFACComm(Event ev) throws EventException{

		EsmAgt0033Event event=(EsmAgt0033Event)ev;
		FACCommVO[] facCommVOs = event.getFACCommVOS();
		SignOnUserAccount account = event.getSignOnUserAccount();
//		ArrayList arrayList = new ArrayList();

		String usrId = "";
		//String sCheck = "";
		String bkg_no = "";
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";
		
//		int cnt = 0;
		int ff_cust_seq = 0;
//		int ff_cust_seq_tmp = 999999;

//		String[] sBkg_no 		= null;//event.getObject("bkg_no");
//		String[] check 			= null;//event.getObject("check");

//		String[][] array = null;
		
//		int arraySize = 0; // 연동 데이타 사이즈
		
		try {
			
//			if(check != null){
				
				usrId = account.getUsr_id();
				log.debug("\nLoginID: " + usrId + "\n\n");
				
				// Loop를 돌면서 처리한다.
//				for (int j=0; j<check.length; j++) {
	
//					sCheck = check[j]==null?"":check[j];

//					if ( sCheck.equals("1") ) {
				
				
				log.debug("\n\n\n====================>"+facCommVOs.length+"\n");
				for(int i=0; i<facCommVOs.length; i++)
				{
					if ( facCommVOs[i].getIbflag().equals("U"))
					{
						HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
						HashMap facMap = new HashMap();	// FAC HashMap 생성
						HashMap facCalcRtMap = new HashMap(); // FAC HashMap 생성

						bkg_sts_cd = ""; // 초기화
						ff_cnt_cd = ""; // 초기화
						sFf_cust_seq = ""; // 초기화
						sShpr_cust_seq = ""; // 초기화
						fac_ofc_cd = ""; // 초기화
						facRtBreakYN = "N"; // 초기화
						ff_cust_seq = 0; // 초기화

						bkg_no = facCommVOs[i].getBkgNo();
						log.debug("\nBkgNo: " + bkg_no + "\n\n");

						// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
						bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
						bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.
						bkgMap.put("USRID", usrId);					// reCalculation시 UserID
						bkgMap.put("reCalcYN", "Y");				// reCalculation 여부
						
						// Booking 정보를 조회한다.
						bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
								else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}

							continue;
						}
						
						// S/A Date를 구한다.
						bkgMap = brkgBC.searchAGTSADate(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}

						// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
						bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
						
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
						bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							continue;
						}
						
						// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
						brkgBC.createBKGMasterInfo(bkgMap);

						// AGT_BKG_REV_VVD_PRC Procedure 호출
						//brkgBC.callProcedure(bkg_no);
						
						// FAC비 계산---------------start---------------
						// cancel 여부 체크하기 위하여 Booking의 Status를 가져온다.
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

						// FAC Agrement 요율 정보를 조회하기 위한 변수
						fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
						ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
						sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
						sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
						
						// 2007.05.14 일 수정(HYKIM)
//						if( fac_ofc_cd.length() <= 0 ) {
//							bkgMap.put("PPD_OFC_CD", (String)bkgMap.get("BKG_SLS_OFC_CD"));
//							fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
//						}
						
						if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
							ff_cust_seq = Integer.parseInt(sFf_cust_seq);
						}
						if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
							sFf_cust_seq = "000000";
						}
						if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
							sShpr_cust_seq = "000000";
						}
						
						// FAC HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no를 셋팅한다.
						facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
						facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
						facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// Trunk의 출항일자를 셋팅한다.(Error Message 저장시 사용)
						facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD를 SLS_OFC_CD로 셋팅한다.(Error Message 저장시 사용)
						facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
						facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ (Error Message 저장시 사용)
						bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta 유무 확인

						bkgMap.put("facMap", facMap);										// 생성한 FAC HashMap을 Booking Map에 넣는다.
						bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
						bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						
						// FAC 체크
						if(!dbDao.createActualFACComm( bkgMap )) {
							continue;
						}
						
						// FAC Sequence를 구한다.
						bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

						if("X".equals(bkg_sts_cd)) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구한다.
							
							// Cancel amt를 구해온다.
							bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}			

						} else {
							
							// 2007.12.24 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
							bkgMap = dbDao.checkPpdOfcCd(bkgMap);
							
							//Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}

							// FAC Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
							bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}
							
							// BL no가 있으면 MEMO BL를 check한다.
							bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}

							// Freight Forwarder를 다시 가지고 온다.
							ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
							sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
							
							if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
								ff_cust_seq = Integer.parseInt(sFf_cust_seq);
							}
							
							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
							facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ (Error Message 저장시 사용)
							bkgMap.put("facMap", facMap);

							// 먼저 PPD_OFC_CD로 요율정보를 조회한다.
							// PPD_OFC_CD로 요율 정보가 존재하지 않을 경우 AR_OFC_CD로 조회한다.
							// FAC Agrement 요율 정보를 조회한다. 1번째
							// FAC Agrement 요율 정보가 존재하지 않을 경우 ff_cust_seq=999999로 다시 조회한다.
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}

							// Rete 존재 유무를 가지고온다.
							facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));


							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FAC_RT_OFC_CD", fac_ofc_cd); // 계산시 실제로 적용된 Office를 FAC HashMap에 담아 둔다.

							// Contaner type/size에 따라서 FAC Commission을 계산한다.
							bkgMap = dbDao.calcFACCommInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}
							
							// FAC Commission을 저장한다.
							bkgMap = dbDao.createFACCommInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								continue;
							}
						}
						
						// FAC Commission Detail을 저장한다.
						bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkFacError( bkgMap )) {
							continue;
						}
						
						// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
						bkgMap = dbDao.createFACTPSZSummation(bkgMap);
						
						// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
						//dbDao.checkFACCustName(bkgMap);
						// FAC비 계산---------------end---------------
					} // end if
				} // end for
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	/**
	 * FAC Commission ReCalculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return Object 배치처리 결과
	 * @exception EventException
	 */
	public Object recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException{

//		ArrayList arrayList = new ArrayList();

		String usrId = "";
		String bkg_sts_cd = "";
		String ff_cnt_cd = "";
		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		String fac_ofc_cd = "";
		String facRtBreakYN = "N";
		
//		int cnt = 0;
		int ff_cust_seq = 0;
//		int ff_cust_seq_tmp = 999999;

//		String[] sBkg_no 		= null;//event.getObject("bkg_no");
//		String[] check 			= null;//event.getObject("check");

//		String[][] array = null;
		
//		int arraySize = 0; // 연동 데이타 사이즈
		
		try {
			
//			if(check != null){
				
				usrId = account.getUsr_id();
				log.debug("\nLoginID: " + usrId + "\n\n");
				
				// Loop를 돌면서 처리한다.
//				for (int j=0; j<check.length; j++) {
	
//					sCheck = check[j]==null?"":check[j];

//					if ( sCheck.equals("1") ) {
				
				
						HashMap bkgMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Booking Map.
						HashMap facMap = new HashMap();	// FAC HashMap 생성
						HashMap facCalcRtMap = new HashMap(); // FAC HashMap 생성

						bkg_sts_cd = ""; // 초기화
						ff_cnt_cd = ""; // 초기화
						sFf_cust_seq = ""; // 초기화
						sShpr_cust_seq = ""; // 초기화
						fac_ofc_cd = ""; // 초기화
						facRtBreakYN = "N"; // 초기화
						ff_cust_seq = 0; // 초기화

						log.debug("\nBkgNo: " + bkg_no + "\n\n");

						// Booking Map에 booking no와 booking no split등 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						bkgMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
						bkgMap.put("FF_CNT_CD", "");				// booking ff_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("FF_CUST_SEQ", "");				// booking ff_cust_seq을 공백으로 셋팅한다.
						bkgMap.put("SHPR_CNT_CD", "");				// booking shpr_cnt_cd를 공백으로 셋팅한다.
						bkgMap.put("SHPR_CUST_SEQ", "");			// booking shpr_cust_seq을 공백으로 셋팅한다.
						bkgMap.put("USRID", usrId);					// reCalculation시 UserID
						bkgMap.put("reCalcYN", "Y");				// reCalculation 여부
						
						// Booking 정보를 조회한다.
						bkgMap = brkgBC.searchBookingInfoforComm(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							 if ("B".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
								else if ("C".equals((String)bkgMap.get("COVERED_CHECK")))
								{
									processFacCancel(bkg_no, "COMMISSION");
								}
							 return null;
						}
						
						// S/A Date를 구한다.
						bkgMap = brkgBC.searchAGTSADate(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							return null;
						}

						// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
						bkgMap = brkgBC.searchAGTContractInfo(bkgMap);
						
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
						bkgMap = brkgBC.searchRevLanebndInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkError( bkgMap )) {
							return null;
						}
						
						// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
						brkgBC.createBKGMasterInfo(bkgMap);

						// AGT_BKG_REV_VVD_PRC Procedure 호출
						//brkgBC.callProcedure(bkg_no);
						
						// FAC비 계산---------------start---------------
						// cancel 여부 체크하기 위하여 Booking의 Status를 가져온다.
						bkg_sts_cd = dbDao.checkNull((String)bkgMap.get("BKG_STS_CD"));

						// FAC Agrement 요율 정보를 조회하기 위한 변수
						fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
						ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
						sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
						sShpr_cust_seq =  dbDao.checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
						
						// 2007.05.14 일 수정(HYKIM)
//						if( fac_ofc_cd.length() <= 0 ) {
//							bkgMap.put("PPD_OFC_CD", (String)bkgMap.get("BKG_SLS_OFC_CD"));
//							fac_ofc_cd = dbDao.checkNull((String)bkgMap.get("PPD_OFC_CD"));
//						}
						
						if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
							ff_cust_seq = Integer.parseInt(sFf_cust_seq);
						}
						if(sFf_cust_seq.length() == 0 || "*".equals(sFf_cust_seq)) {
							sFf_cust_seq = "000000";
						}
						if(sShpr_cust_seq.length() == 0 || "*".equals(sShpr_cust_seq)) {
							sShpr_cust_seq = "000000";
						}
						
						// FAC HashMap에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
						facMap.put("BKG_NO", (String)bkgMap.get("BKG_NO"));					// booking no를 셋팅한다.
						facMap.put("COMM_PROC_STS_CD", "CE");								// comm_proc_sts_cd를 "CE"로 셋팅한다.
						facMap.put("COMM_PROC_RSLT_RSN", "");								// comm_proc_rslt_rsn을 공백으로 셋팅한다.
						facMap.put("TRUNK_ETD_DT", (String)bkgMap.get("TRUNK_ETD_DT"));		// Trunk의 출항일자를 셋팅한다.(Error Message 저장시 사용)
						facMap.put("SLS_OFC_CD", fac_ofc_cd);								// PPD_OFC_CD를 SLS_OFC_CD로 셋팅한다.(Error Message 저장시 사용)
						facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);							// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
						facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));			// FRT_FWRD_SEQ (Error Message 저장시 사용)
						bkgMap.put("facRtBreakYN", facRtBreakYN); 							// FAC Reta 유무 확인

						bkgMap.put("facMap", facMap);										// 생성한 FAC HashMap을 Booking Map에 넣는다.
						bkgMap.put("facCalcRtMap", facCalcRtMap);							// FAC Rate HashMap
						bkgMap.put("FF_CUST_SEQ", sFf_cust_seq);							// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						bkgMap.put("SHPR_CUST_SEQ", sShpr_cust_seq);						// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
						
						// FAC 체크
						if(!dbDao.createActualFACComm( bkgMap )) {
							return null;
						}
						
						// FAC Sequence를 구한다.
						bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );	

						if("X".equals(bkg_sts_cd)) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구한다.
							
							// Cancel amt를 구해온다.
							bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}			

						} else {
							
							// 2007.12.24 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
							bkgMap = dbDao.checkPpdOfcCd(bkgMap);
							
							//Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}

							// FAC Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
							bkgMap = dbDao.searchFACCustShprInterestInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}
							
							// BL no가 있으면 MEMO BL를 check한다.
							bkgMap = dbDao.checkFACOtherInfo(bkgMap);
				
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}

							// Freight Forwarder를 다시 가지고 온다.
							ff_cnt_cd = dbDao.checkNull((String)bkgMap.get("FF_CNT_CD"));
							sFf_cust_seq = dbDao.checkNull((String)bkgMap.get("FF_CUST_SEQ"));
							
							if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
								ff_cust_seq = Integer.parseInt(sFf_cust_seq);
							}
							
							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FRT_FWRD_CNT_CD", ff_cnt_cd);					// FRT_FWRD_CNT_CD (Error Message 저장시 사용)
							facMap.put("FRT_FWRD_SEQ", String.valueOf(ff_cust_seq));	// FRT_FWRD_SEQ (Error Message 저장시 사용)
							bkgMap.put("facMap", facMap);

							// 먼저 PPD_OFC_CD로 요율정보를 조회한다.
							// PPD_OFC_CD로 요율 정보가 존재하지 않을 경우 AR_OFC_CD로 조회한다.
							// FAC Agrement 요율 정보를 조회한다. 1번째
							// FAC Agrement 요율 정보가 존재하지 않을 경우 ff_cust_seq=999999로 다시 조회한다.
							bkgMap = dbDao.searchFACAGMTRateInfo( bkgMap, fac_ofc_cd, ff_cnt_cd, ff_cust_seq, false );
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}

							// Rete 존재 유무를 가지고온다.
							facRtBreakYN = dbDao.checkNull((String)bkgMap.get("facRtBreakYN"));


							facMap = (HashMap)bkgMap.get("facMap");
							facMap.put("FAC_RT_OFC_CD", fac_ofc_cd); // 계산시 실제로 적용된 Office를 FAC HashMap에 담아 둔다.

							// Contaner type/size에 따라서 FAC Commission을 계산한다.
							bkgMap = dbDao.calcFACCommInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}
							
							// FAC Commission을 저장한다.
							bkgMap = dbDao.createFACCommInfo(bkgMap);
							
							// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
							if(checkFacError( bkgMap )) {
								return null;
							}
						}
						
						// FAC Commission Detail을 저장한다.
						bkgMap = dbDao.createFACTPSZCommInfo(bkgMap);
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkFacError( bkgMap )) {
							return null;
						}
						
						// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
						bkgMap = dbDao.createFACTPSZSummation(bkgMap);
						
						// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
						//dbDao.checkFACCustName(bkgMap);
						// FAC비 계산---------------end---------------
return null;
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
	 * FAC Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param HashMap map
	 * @return boolean Error 유무
	 * @exception EventException
	 */
	public boolean checkFacError( HashMap map ) {

		HashMap fMap = (HashMap)map.get("facMap");
		String error_msg = dbDao.checkNull((String)fMap.get("COMM_PROC_RSLT_RSN"));
		
		if(error_msg.length() > 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processFacCancel(String bkg_no, String FLG0507) throws EventException{

		HashMap bkgMap = new HashMap();
		HashMap facMap = new HashMap();
		
		String errMsg = "";
		
		try {
			facMap.put("BKG_NO", bkg_no);				// booking no를 셋팅한다.
			bkgMap.put("facMap", facMap);
			
			bkgMap.put("BKG_NO", bkg_no);
			bkgMap.put("FLG0507", FLG0507);
			
			// FAC Sequence를 구한다.
			bkgMap = dbDao.searchFACRateSequenceInfo( bkgMap );
			errMsg = dbDao.checkNull((String)bkgMap.get("CANCEL_FAC"));
			if(!errMsg.equals("")){
				return;
			}
			//Cancel amt를 구해온다.
			bkgMap = bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
		}
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
	

}