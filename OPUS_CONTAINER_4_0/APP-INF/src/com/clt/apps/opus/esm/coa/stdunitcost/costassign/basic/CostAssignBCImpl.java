/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CostAssignBC.java
 *@FileTitle : Batch Test Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.25
 *@LastModifier : 임옥영
 *@LastVersion : 1.0
 * 2009.09.25 임옥영
 * 1.0 Creation
 * ------------------------------------------------------------------------------------------------
 * History
  * =========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.CoaBatchParameterVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration.CostAssignDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.CoaBkgCostCalcVO;
import com.clt.syscommon.common.table.CoaComCostParaVO;

/**
 * COA Business Logic Basic Command implementation<br>
 * COA에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESM_COA_AssignEventResponse,CostAssignBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CostAssignBCImpl extends BasicCommandSupport implements
		CostAssignBC {

	// Database Access Object
	private transient CostAssignDBDAO dbDao = null;

	/**
	 * CostAssignBCImpl 객체 생성<br>
	 * CostAssignDBDAO를 생성한다.<br>
	 */
	public CostAssignBCImpl() {
		dbDao = new CostAssignDBDAO();
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param start_pctl_no
	 * @param end_pctl_no
	 * @return List<CoaComCostParaVO>
	 * @exception EventException
	 */
	public List<CoaComCostParaVO> searchPctlNoList(String start_pctl_no,
			String end_pctl_no) throws EventException {
		try {
			return dbDao.searchPctlNoList(start_pctl_no, end_pctl_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param bkg_no
	 * @return DBRowSet
	 * @exception EventException
	 */
	private DBRowSet searchCopNoList(String bkg_no) throws EventException {
		try {
			return dbDao.searchCopNoList(bkg_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}

	}


	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignPrd(String startPctlNo, String endPctlNo,
			String userId) throws EventException {
		int result = 0;
		String strRslt = "";
		try {
			strRslt = this.createCostAssignPrdSub(startPctlNo, endPctlNo,userId);

			// coa 단가 처리시 에러나면 prd 에 예외처리 안올리고 0를 넘겨준다.
			log.info("\n### PRD 처리 결과 strRslt: " + strRslt);
			if (strRslt != null && !strRslt.equals("")) {
				log.info("\n### PRD 에러 발생 ");
				dbDao.modifyProductCatalogueMaster(startPctlNo, endPctlNo);
				dbDao.createLog(strRslt + " startPctlNo:" + startPctlNo
						+ "endPctlNo:" + endPctlNo);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}

	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	private String createCostAssignPrdSub(String startPctlNo, String endPctlNo,String userId) {
		long timeTotal = 0;
		long timeSub = 0;
		// 2007.09.19 소스품질에 걸려서 주석처리함
		// DateFormat dateFormatYYYYMM = new SimpleDateFormat("yyyyMM");
		DateFormat dateFormat = new SimpleDateFormat("mm:ss.S");
		String strRslt = "";
		String strStep = "";

		try {
			timeTotal = System.currentTimeMillis();
			// 보낼 데이터
			// ------------------------------------------------
			String sendStr = "";
			sendStr = sendStr + "bkg_no" + ":|";
			sendStr = sendStr + "start_pctl_no" + ":" + startPctlNo + "|";
			sendStr = sendStr + "end_pctl_no" + ":" + endPctlNo + "|";
			sendStr = sendStr + "user_id" + ":" + userId + "|";

			// 기준 년월 가져오기
			// -------------------------------------------------------------------------------------------
			DBRowSet dbRs3 = dbDao.searchBzcCostYrmon("");
			String bzc_cost_yrmon = "";
			if (dbRs3.next()) {
				bzc_cost_yrmon = dbRs3.getString("bzc_cost_yrmon");
			}
			sendStr = sendStr + "cost_yrmon" + ":" + bzc_cost_yrmon;

			log.info("\n### -------------- [ Start PRD ] ----------------"
					+ "\n### start_pctl_no: " + startPctlNo
					+ "\n### end_pctl_no: " + endPctlNo + "\n### cost_yrmon: "
					+ bzc_cost_yrmon + "\n### user_id: " + userId);
			// ------------------------------------------------

			/*
			 * 배치용 VO CoaBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			CoaBatchParameterVO vo = new CoaBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, null, null, null);

			strStep = "COA - COST_ASSIGN_PRD ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### COA - COST_ASSIGN");
			dbDao.createCoaCostPrcAssignPrd(vo);// dbDao.createCoaCostPrcAssignPrd(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TRS ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TRS");
			dbDao.createTrsAgmtApplyToCoa(vo);// dbDao.createTrsAgmtApplyToCoa(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TES ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TES");
			dbDao.createTesCoaRate(vo);// dbDao.createTesCoaRate(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "COA - RPD_AVG ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### COA - RPD_AVG");
			dbDao.createCoaCostPkgMainPrdAvg(vo);// dbDao.createCoaCostPkgMainPrdAvg(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "COA - COM_TTL ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### COA - COM_TTL");
			dbDao.createCoaCostPkgMainComTtl(vo);// dbDao.createCoaCostPkgMainComTtl(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "COA - PRD_MST ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### COA - PRD_MST");
			dbDao.createCoaCostPkgMainPrdMst(vo);// dbDao.createCoaCostPkgMainPrdMst(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			log.error("\n ### Time Total: " + dateFormat.format(new Date(System.currentTimeMillis() - timeTotal)));

		} catch (DAOException de) {
			log.error("err " + strStep + ">>" + de.toString(), de);
			strRslt = strStep + ">>" + de.toString();
		} catch (Exception e) {
			log.error("err " + strStep + e.toString(), e);
			strRslt = strStep + ">>" + e.toString();
		}
		// 에러 발생시 위로 예외처리를 안올리고 prd에 0를 넘기기 위해
		return strRslt;
	}

	/**
	 * 
	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
	 * 
	 * @param msg String - JMS Queue로부터 얻은 메세지
	 * @throws EventException
	 */
	public void receiveCostAssignCop(String msg) throws EventException {
		log.debug("### receiveCostAssignCop :" + msg);
		HashMap hm = Utils.createMap(msg);
		try {
			this.createCostAssignCop((String) hm.get("f_bkg_no"), (String) hm.get("f_user_id"),"", ""); // [전윤주]
		} catch (Exception ee) {
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
	}

	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param String bkgNo
	 * @param String userId
	 * @param String delPara
	 * @param String level
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignCop(String bkgNo, String userId, String delPara, String level) throws EventException {
		int result = 0;
		long timeTotal = 0;
		long timeSub = 0;
		DateFormat dateFormat = new SimpleDateFormat("mm:ss.S");
		String strStep = "";
		try {
			timeTotal = System.currentTimeMillis();
			log.debug("\n BCImpl createCostAssignCop(String bkgNo, String userId, String delPara) bkgNo = "+ bkgNo);
			

			/*
			 * 배치용 VO CoaBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			CoaBatchParameterVO vo = new CoaBatchParameterVO(bkgNo, null, null, null, userId, delPara, null, null);

			strStep = "COA - BKG_STS ";
			DBRowSet dbRs2 = dbDao.searchBkgInfo(bkgNo);
			dbRs2.next();
			if (dbRs2.getString("bkg_sts_cd").trim().equals("X")) {
				// 삭제된 부킹은 단가를 안붙인다.
				log.error("\n ### bkg_sts_cd : "+ dbRs2.getString("bkg_sts_cd"));

				strStep = "AGT ACT ";
				// -------------------------------------------
				log.debug("\n### AGT ");
				modifyBkgStsAgt(bkgNo, userId, delPara);
				// -------------------------------------------
			} else {
				log.info("CostAssign Level : "+ level);
				if(level.equals(""))level = "6"; // 입력되지 않으면 6단계로 세팅
				
				// 1단계 : COA_COM_PARA에 계정을 생성한다.
				if (Integer.parseInt(level) >= 1) {
					strStep = "COA - COST_ASSIGN_COP ";
					// COA - COST_ASSIGN_COP
					// -------------------------------------------
					timeSub = System.currentTimeMillis();
					log.debug("\n### COA - COST_ASSIGN_COP");
					dbDao.createCoaCostPrcAssignCop(vo);// dbDao.createCoaCostPrcAssignCop(sendStr);
					log.info("\n### Time COA - COST_ASSIGN_COP: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				}

				// -------------------------------------------
				// Pctl_no를 조회한다 
				// -------------------------------------------
				DBRowSet dbRsCopHdr = dbDao.searchPctlNoStartEnd(bkgNo);
				// COP no 가져오기
				if (!dbRsCopHdr.next() || dbRsCopHdr.getString("start_pctl_no").trim().equals("")) {
					result = 1;//error
					log.error("\n ### BKG_NO : " + bkgNo + "\n ### NOT FOUND PCTL_NO");
					throw new EventException("\n ### BKG_NO : " + bkgNo + "\n ### NOT FOUND PCTL_NO");
				} else {
	
					// 기준데이터
					// ------------------------------------------------
					String sendStr = "";
					sendStr = sendStr + "bkg_no" + ":" + bkgNo + "|";
					sendStr = sendStr + "start_pctl_no" + ":"
							+ dbRsCopHdr.getString("start_pctl_no") + "|";
					sendStr = sendStr + "end_pctl_no" + ":"
							+ dbRsCopHdr.getString("end_pctl_no") + "|";
					sendStr = sendStr + "user_id" + ":" + userId + "|";
					sendStr = sendStr + "del_para" + ":" + delPara + "|";
					
					vo.setStartPctlNo(dbRsCopHdr.getString("start_pctl_no"));
					vo.setEndPctlNo(dbRsCopHdr.getString("end_pctl_no"));
					
					strStep = "COA - BZC_COST_YRMON ";
					// 기준 년월 가져오기
					// -------------------------------------------------------------------------------------------
					DBRowSet dbRs3 = dbDao.searchBzcCostYrmon(bkgNo);
					String bzc_cost_yrmon = "";
					if (dbRs3.next()) {
						bzc_cost_yrmon = dbRs3.getString("bzc_cost_yrmon");
					}
					sendStr = sendStr + "cost_yrmon" + ":" + bzc_cost_yrmon;
					log.info("\n ### -------------- [ Start COP ] ----------------"
							+ "\n ### bkg_no: " + bkgNo + "\n ### start_cop_no: "
							+ dbRsCopHdr.getString("start_pctl_no")
							+ "\n ### end_cop_no: "
							+ dbRsCopHdr.getString("end_pctl_no")
							+ "\n ### cost_yrmon: " + bzc_cost_yrmon
							+ "\n ### user_id: " + userId);
					// ------------------------------------------------
					// -------------------------------------------------------------------------------------------
		
					vo.setCostYrmon(bzc_cost_yrmon);
	
	
					// 2단계 : 비용생성
					if (Integer.parseInt(level) >= 2) {
	
						// ABC REV 적용하기 위해서 REV_DTL_PRC call 하는 위치 바꿈
						strStep = "COA - BKG_REV_DTL ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - BKG_REV_DTL");
						dbDao.createCoaBkgRevDtl(vo);// dbDao.createCoaBkgRevDtl(sendStr);
						log.info("\n### Time COA - BKG_REV_DTL: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "TRS ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### TRS");
						// eaiDao.sendTrsAgmtApplyToCoa(sendStr);
						dbDao.createTrsAgmtApplyToCoa(vo);// dbDao.createTrsAgmtApplyToCoa(sendStr);
						log.info("\n### Time TRS: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "TES ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### TES");
						dbDao.createTesCoaRate(vo);// dbDao.createTesCoaRate(sendStr);
						log.info("\n### Time TES: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "COA - COP_AVG ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - COP_AVG");
						dbDao.createCoaCostPkgMainCopAvg(vo);// dbDao.createCoaCostPkgMainCopAvg(sendStr);
						log.info("\n### Time COA - COP_AVG: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "COA - AGT PCTL NO ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### AGT");
						/*
						 * opus변경으로 ESM_COA_AssignEventResponse로 받아서 꺼내지 않고 직접 DBRowSet을
						 * 받는것으로 수정 원본은 아래코드 ESM_COA_AssignEventResponse rp =
						 * (ESM_COA_AssignEventResponse) this.searchCopNoList(bkgNo);
						 * DBRowSet dbRs = rp.getRs();
						 */
						DBRowSet dbRs = this.searchCopNoList(bkgNo);
						log.debug("### dbRs: " + dbRs.getRowCount());
		
						strStep = "AGT CM ";
						String cop_no = "";
						//AGTCalcToCoaBC agtCalcToCoaBC = new AGTCalcToCoaBCImpl();
						while (dbRs.next()) {
							cop_no = dbRs.getString("cop_no");
							dbDao.createAcmAplyOtrCommToCoa(cop_no,userId);
							//agtCalcToCoaBC.createCMComm(cop_no);
						}
						log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "AGT ACT ";
						// -------------------------------------------
						log.debug("\n### AGT");
						//agtCalcToCoaBC = new AGTCalcToCoaBCImpl();
						dbDao.createAcmAplyCommToCoa(bkgNo,userId );
						
						//result = agtCalcToCoaBC.createAgentComm(bkgNo);
						log.debug("### AGT result :" + result);
						log.info("\n### Time AGT: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
		
						strStep = "COA - TTL ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - TTL");
						dbDao.createCoaCostPkgMainComTtl(vo);// dbDao.createCoaCostPkgMainComTtl(sendStr);
						log.info("\n### Time COA - TTL: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
					}// if Integer.parseInt(level) >= 2
					// 3단계 : 비용집계(COA_BKG_COST_SRC_DTL)
					if(Integer.parseInt(level) >= 3){
						strStep = "COA - BKG_INFO_INST ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - BKG_INFO_INST");
						dbDao.createCoaBkgInfoInst(vo);// dbDao.createCoaBkgInfoInst(sendStr);
						log.info("\n### Time COA - BKG_INFO_INST: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
					}
					// 4단계 : 비용집계(COA_BKG_COST_SMRY)
					if(Integer.parseInt(level) >= 4){
						strStep = "COA - BKG_COST_SMRY ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - BKG_COST_SMRY");
						dbDao.createCoaBkgCostSmry(vo);// dbDao.createCoaBkgCostSmry(sendStr);
						log.info("\n### Time COA - BKG_COST_SMRY: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
					}					
					
					// 6단계 : 비용집계(COA_BKG_EXPN_DTL)
					if(Integer.parseInt(level) >= 6){
						strStep = "COA - BKG_EXPN_DTL_PRC ";
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### COA - BKG_EXPN_DTL_PRC");
						dbDao.createCoaBkgExpnDtl(vo);// dbDao.createCoaBkgExpnDtl(sendStr);
						log.info("\n### Time COA - BKG_EXPN_DTL_PRC: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
						// -------------------------------------------
					}
					
				}//if start_pctl_no = ""
			}//bkg_sts_cd = X

			log.error("\n ### Time Total: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeTotal)));
			log.error("\n ### -------------- [ End COP ] ----------------"+ "\n ### bkg_no: " + bkgNo + "");
			

		} catch (SQLException e) {
			log.error("err " + strStep + e.toString(), e);
			throw new EventException(strStep + e.getMessage());
		} catch (DAOException de) {
			log.error("err " + strStep + de.toString(), de);
			throw new EventException(strStep + de.getMessage());
		} catch (Exception e) {
			log.error("err " + strStep + e.toString(), e);
			throw new EventException(strStep + e.getMessage());
		}
		return result;
	}


	/**
	 * 
	 * 2010.08.03 이윤정 [CHM-201005008-01] 
	 * 					Cancel Booking 시 관련 Table Cancel Status Update 로직 및 ATG 재계산 Method 호출
	 * @param String bkgNo
	 * @param String userId
	 * @param String delPara
	 * @return int
	 * @throws EventException
	 */
	public int modifyBkgStsAgt(String bkgNo, String userId, String delPara) throws EventException {
		int result = 0;
		try {
			dbDao.updateCoaRgstBkg(bkgNo);
			dbDao.updateCoaBkgExpnDtl(bkgNo);
			dbDao.updateCoaBkgExpnDtlWk(bkgNo);
//			dbDao.updateLeaEstmCostIf(bkgNo);
			
			log.debug("\n### AGT");
			dbDao.createAcmAplyCommToCoa(bkgNo, userId);
			//AGTCalcToCoaBCImpl agtCalcToCoaBC = new AGTCalcToCoaBCImpl();
			//result = agtCalcToCoaBC.createAgentComm(bkgNo);
			log.debug("### AGT result :" + result);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param BkgNo
	 * @param DelPara
	 * @param level
	 * @param userid
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignCopLoop(String BkgNo, String DelPara, String level, String userid) throws EventException {
		try {
			DBRowSet dbRs1 = dbDao.searchBkgNoList(BkgNo);
			while (dbRs1.next()) {
				this.createCostAssignCop(dbRs1.getString("bkg_no"), userid, DelPara, level);
			}
		} catch (SQLException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return 0;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * costAssign 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param coaBatCd
	 * @return List<CoaBkgCostCalcVO>
	 * @exception EventException
	 */
	public List<CoaBkgCostCalcVO> searchListAssign(String coaBatCd)
			throws EventException {
		try {
			return dbDao.searchListAssign(coaBatCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * TRS에서 SO CANCEL발생했을때 배치작업 수행을 위해 IF
	 * 
	 * @param BkgNo
	 * @return int
	 * @throws EventException
	 */
	public int updateBkgIfTrs2CoaSoCancel(String bkgNo) throws EventException {
		int result = 0;
		try {
			result = dbDao.updateBkgIfTrs2CoaSoCancel(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}

	/**
	 * BKG시스템의 변경사항을 배치작업 수행하기위해 IF
	 * 
	 * @param coaBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int modifyCoaCommonInterface(CoaBkgComIfVO coaBkgComIfVo) throws EventException {
		int result = 0;

		try {
			
//			// 1. 일배치 요건에 대해서 일배치 테이블에 입력[COA_COP_IF_MGMT]
//			if(coaBkgComIfVo.getIfRmk().substring(0, 3).equals("")){
//				result = dbDao.multiCoaCopIfMgmg(coaBkgComIfVo);
//				
//			// 2. 분배치 요건에 대해서 분배치 테이블에 입력[COA_BKG_COM_IF]
//			}else if(coaBkgComIfVo.getIfRmk().substring(0, 3).equals("")){
				result = dbDao.modifyCoaCommonInterface(coaBkgComIfVo);
//			}
			// 3. I/F History 에 정보 입력
			result = dbDao.multiCoaBkgComIfHis(coaBkgComIfVo);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}
}