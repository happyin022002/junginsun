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
 * 2008-07-11 박칠서 : CSR NO.N200807010014 
 * 2008-07-11 전윤주 : CSR NO.N200807027739 ABC/STP REV 적용 위해 mas_bkg_rev_dtl_prc call 하는 순서 바꿈
 *                    assign_cop_prc call 하고 난 이후에 바로 rev_dtl_prc call
 *                    
 * 2008-09-08 전윤주 : CSR No.N200807290002 MAS_BKG_EXPN_DTL_PRC  call 하는 부분 추가
 * 2009.02.19 임옥영,전윤주  N200902160090, N200902160095 TRS 에서 SO Cancel시 일배치 테이블에 정상적으로 IF
 * 2009.09.25 임옥영 ALPS BKG시스템과의 IFMethod(modifyMasCommoninterface()) 추가 
 * 2009.10.12 임옥영 callOther 삭제(사용하지 않는 메소드) 
 * 2010.01.07 박은주 MAS_BKG_COM_IF_HIS 테이블에 BKG정보 입력하도록 
 *                  modifyMasCommonInterface 메소드 수정
 * 2010.02.05 임옥영 소스품질검토 결과 반영 createCostAssignPrdSub의 throws 삭제 (catch 구문의 throw 문장 사용을 점검한다.)
 * 2010.02.18 박은주 modifyMasCommonInterface 메소드 변경     
 * 2010.08.19 이윤정 [CHM-201005008-01] BKG cancel 시 MAS에서 AGT 재계산 method 호출 요청
 * 2010.09.07 박은주 OPMS 산출물 작업
 * 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
 *                  createMasCostPrcCopAbc => createMasCostPrcCopAbcStp
 *                  createMasCostPrcPrdAbc => createMasCostPrcPrdAbcStp
 * 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경) Ticket ID : ITM-201003077
 *                  createCostAssignCopLoop level 인자추가
 *                  createCostAssignCop level 인자추가
 * 2011.03.17 박은주 BPM에 정보 제공을 위해서 소스 수정(BKG의 비용정보를 제공함)
 * 2011.05.04 박은주 [CHM-201110492-01]BPM POC 작업 종료에 따른 소스 제거 요청
 * 2011.08.31 전윤주 [CHM-201113180-01] MAS 쪽 Customer 정보, ALPS 변경분 I/F 요청
 *                  modifyMasDailyInterface 추가
 * 2012.05.21 전윤주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 *                  Cost table 생성 후 mas_com_cost_para 테이블 삭제를 위해 별도로 method 생성
 *                  removeMasComCostPara 추가
 * 2012.08.03 전윤주 [CHM-201216347] [MAS] ACM 프로젝트 연동 변경 작업
 *                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함                  
 * 2013.01.16 성미영 [CHM-201322341] [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
 *                 기존 createCostAssignPrd 를 overloading 해서 aocBatSeq 를 추가
 * 2016.02.17 최덕우 [CHM-201639877] 남미서안 Compensation 로직 개발 요청 : Special Compensation 비용 계산 로직 추가                
 * =========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctomas.basic.AGTCalcToMasBC;
//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctomas.basic.AGTCalcToMasBCImpl;
import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.MasBatchParameterVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration.CostAssignDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MasBkgCostCalcVO;
import com.hanjin.syscommon.common.table.MasComCostParaVO;

/**
 * eNIS-MAS Business Logic Basic Command implementation<br>
 * - eNIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESM_MAS_AssignEventResponse,CostAssignBC 각 DAO 클래스 참조
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
	 * @return List<MasComCostParaVO>
	 * @exception EventException
	 */
	public List<MasComCostParaVO> searchPctlNoList(String start_pctl_no,
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

			// mas 단가 처리시 에러나면 prd 에 예외처리 안올리고 0를 넘겨준다.
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
	 * CHM-201534179 : [SPC-BKG 연동 BKG 통제 프로젝트] COST 산출 요청 ( EMU CREDIT + AGENT COMMISSION)
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignBkg(String startPctlNo, String endPctlNo,
			String userId) throws EventException {
		int result = 0;
		String strRslt = "";
		try {
			strRslt = this.createCostAssignBkgSub(startPctlNo, endPctlNo,userId);

			// mas 단가 처리시 에러나면 prd 에 예외처리 안올리고 0를 넘겨준다.
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
	 * SPC CMPB 재계산 로직 변경에 따른 신규 추가부분 [CHM-201539244] - 2015.12.10
	 * 
	 * @param String bkgNo
	 * @param String startPctlNo
	 * @param String endPctlNo
	 * @param String userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignBkg2(String bkgNo, String startPctlNo, String endPctlNo, String userId) throws EventException {
		int result = 0;
		long timeTotal = 0;
		long timeSub = 0;
		DateFormat dateFormat = new SimpleDateFormat("mm:ss.S");
		String strStep = "";
		try {
			timeTotal = System.currentTimeMillis();
			log.debug("\n BCImpl createCostAssignCop(String bkgNo, String userId, String delPara) bkgNo = "+ bkgNo);
			
			/*
			 * 배치용 VO MasBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			MasBatchParameterVO vo = new MasBatchParameterVO(bkgNo, null, null, null, userId, null, null, null, null);

			strStep = "MAS - COST_ASSIGN_COP ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.debug("\n### MAS - COST_ASSIGN_COP");
			dbDao.createMasCostPrcAssignCop(vo);// dbDao.createMasCostPrcAssignCop(sendStr);
			log.info("\n### Time MAS - COST_ASSIGN_COP: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
		

			// -------------------------------------------
			// Pctl_no를 조회한다 
			// -------------------------------------------
			DBRowSet dbRsCopHdr = dbDao.searchPctlNoStartEnd(bkgNo);
			// COP no 가져오기
			if (!dbRsCopHdr.next() || dbRsCopHdr.getString("start_pctl_no").trim().equals("")) {
				
				result = this.createCostAssignBkg(startPctlNo, endPctlNo,userId);
				
			//	throw new EventException("\n ### BKG_NO : " + bkgNo + "\n ### NOT FOUND PCTL_NO");
				
				// pctl no 가 없을 경우 기존 로직 태울것.
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
				
				vo.setStartPctlNo(dbRsCopHdr.getString("start_pctl_no"));
				vo.setEndPctlNo(dbRsCopHdr.getString("end_pctl_no"));
				
				strStep = "MAS - BZC_COST_YRMON ";
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

				strStep = "TRS ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.debug("\n### TRS");
				// eaiDao.sendTrsAgmtApplyToMas(sendStr);
				dbDao.createTrsAgmtApplyToMas(vo);// dbDao.createTrsAgmtApplyToMas(sendStr);
				log.info("\n### Time TRS: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

				strStep = "TES ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.debug("\n### TES");
				dbDao.createTesMasRate(vo);// dbDao.createTesMasRate(sendStr);
				log.info("\n### Time TES: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

				strStep = "MAS - COP_AVG ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.debug("\n### MAS - COP_AVG");
				dbDao.createMasCostPkgMainCopAvg2(vo);// dbDao.createMasCostPkgMainCopAvg(sendStr);
				log.info("\n### Time MAS - COP_AVG: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

				strStep = "MAS - AGT PCTL NO ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.debug("\n### AGT");
				/*
				 * ALPS변경으로 ESM_MAS_AssignEventResponse로 받아서 꺼내지 않고 직접 DBRowSet을
				 * 받는것으로 수정 원본은 아래코드 ESM_MAS_AssignEventResponse rp =
				 * (ESM_MAS_AssignEventResponse) this.searchCopNoList(bkgNo);
				 * DBRowSet dbRs = rp.getRs();
				 */
					

		        // ACM에 BKG 번호 존재하면 수행
		        DBRowSet dbRs4 = dbDao.searchAcmBkg(bkgNo);
		        
				if (dbRs4.next()) {
					strStep = "AGT ACT ";
					log.debug("\n### AGT");
					
					dbDao.createAcmAplyCommToMas(bkgNo,userId );	
				} else {
					strStep = "AGT CM ";
					String pctl_no = "";	
					
					DBRowSet dbRs = this.searchCopNoList(bkgNo);
					log.debug("### dbRs: " + dbRs.getRowCount());
					
					while (dbRs.next()) {
						pctl_no = dbRs.getString("pctl_no");							
						dbDao.createAcmAplyOtrCommToSpc2(bkgNo, pctl_no, userId, bzc_cost_yrmon);
					}
					log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
					// -------------------------------------------                         
		        }
				//result = agtCalcToMasBC.createAgentComm(bkgNo);
				log.debug("### AGT result :" + result);
				log.info("\n### Time AGT: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

				strStep = "MAS - TTL ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.debug("\n### MAS - TTL");
				dbDao.createMasCostPkgMainComTtl(vo);// dbDao.createMasCostPkgMainComTtl(sendStr);
				log.info("\n### Time MAS - TTL: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

			
				strStep = "MAS - PRD_MST_2 ";
				// -------------------------------------------
				timeSub = System.currentTimeMillis();
				log.info("\n### MAS - PRD_MST2");
				dbDao.createMasCostPkgMainPrdMst3(vo);// dbDao.createMasCostPkgMainPrdMst(sendStr);
				log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
				// -------------------------------------------

						
			}//if start_pctl_no = ""
		

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
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @param aocBatSeq	  
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignPrd(String startPctlNo, String endPctlNo,
			String userId, String aocBatSeq) throws EventException {
		int result = 0;
		String strRslt = "";
		try {
			strRslt = this.createCostAssignPrdSub(startPctlNo, endPctlNo,userId, aocBatSeq);

			// mas 단가 처리시 에러나면 prd 에 예외처리 안올리고 0를 넘겨준다.
			log.info("\n### PRD 처리 결과 strRslt: " + strRslt);
			if (strRslt != null && !strRslt.equals("")) {
				log.info("\n### PRD 에러 발생 ");
				dbDao.modifyProductCatalogueMaster(startPctlNo, endPctlNo);
				dbDao.createLog(strRslt + " startPctlNo:" + startPctlNo
						+ "endPctlNo:" + endPctlNo );
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
			 * 배치용 VO MasBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			MasBatchParameterVO vo = new MasBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, null, null, null, null);

			strStep = "MAS - COST_ASSIGN_PRD ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COST_ASSIGN");
			dbDao.createMasCostPrcAssignPrd(vo);// dbDao.createMasCostPrcAssignPrd(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TRS ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TRS");
			dbDao.createTrsAgmtApplyToMas(vo);// dbDao.createTrsAgmtApplyToMas(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TES ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TES");
			dbDao.createTesMasRate(vo);// dbDao.createTesMasRate(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - RPD_AVG ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - RPD_AVG");
			dbDao.createMasCostPkgMainPrdAvg(vo);// dbDao.createMasCostPkgMainPrdAvg(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - COM_TTL ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COM_TTL");
			dbDao.createMasCostPkgMainComTtl(vo);// dbDao.createMasCostPkgMainComTtl(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - PRD_MST ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - PRD_MST");
			dbDao.createMasCostPkgMainPrdMst(vo);// dbDao.createMasCostPkgMainPrdMst(sendStr);
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
	 * CHM-201534179 : [SPC-BKG 연동 BKG 통제 프로젝트] COST 산출 요청 ( EMU CREDIT + AGENT COMMISSION)
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	private String createCostAssignBkgSub(String startPctlNo, String endPctlNo,String userId) {
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
						
			//SPC-BKG연동 시 장비비 비용 계산을 위한 EQ Day 추출			
			DBRowSet dbRs4 = dbDao.searchMtDys(startPctlNo);
			String cntr_mt_dys = "";
			if (dbRs4.next()) {
				cntr_mt_dys = dbRs4.getString("cntr_mt_dys");
			}

			/*
			 * 배치용 VO MasBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			MasBatchParameterVO vo = new MasBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, null, null, null, cntr_mt_dys);
//			MasBatchParameterVO vo = new MasBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, null, null, null, null);

			
			strStep = "MAS - COST_ASSIGN_PRD ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COST_ASSIGN");
			dbDao.createMasCostPrcAssignPrd(vo);// dbDao.createMasCostPrcAssignPrd(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TRS ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TRS");
			dbDao.createTrsAgmtApplyToMas(vo);// dbDao.createTrsAgmtApplyToMas(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TES ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TES");
			dbDao.createTesMasRate(vo);// dbDao.createTesMasRate(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

// 변경			
			strStep = "MAS - Bkg_AVG ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - RPD_AVG");
			dbDao.createMasCostPkgMainBkgAvg(vo);// dbDao.createMasCostPkgMainPrdAvg(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - COM_TTL ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COM_TTL");
			dbDao.createMasCostPkgMainComTtl(vo);// dbDao.createMasCostPkgMainComTtl(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------
// 변경
			strStep = "MAS - PRD_MST_2 ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - PRD_MST2");
			dbDao.createMasCostPkgMainPrdMst2(vo);// dbDao.createMasCostPkgMainPrdMst(sendStr);
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
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @param aocBatSeq	  
	 * @return int
	 * @throws EventException
	 */
	private String createCostAssignPrdSub(String startPctlNo, String endPctlNo,String userId, String aocBatSeq) {
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
			sendStr = sendStr + "aoc_bat_seq" + ":" + aocBatSeq + "|";			

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
					+ bzc_cost_yrmon + "\n### user_id: " + userId
					+ "\n### aoc_bat_seq: " + aocBatSeq);
			// ------------------------------------------------

			/*
			 * 배치용 VO MasBatchParameterVO(String bkgNo, String startPctlNo,
			 * String endPctlNo, String costYrmon, String usrId, String aocBatSeq, String delPara,
			 * String outParaVarchar, String outParaNumber)
			 */
			//MasBatchParameterVO vo = new MasBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, aocBatSeq, null, null, null);
			MasBatchParameterVO vo = new MasBatchParameterVO(null, startPctlNo,endPctlNo, bzc_cost_yrmon, userId, aocBatSeq, null, null, null, null);
			strStep = "MAS - COST_ASSIGN_PRD ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COST_ASSIGN");
			dbDao.createMasCostPrcAssignPrd(vo);// dbDao.createMasCostPrcAssignPrd(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TRS ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TRS");
			dbDao.createTrsAgmtApplyToMas(vo);// dbDao.createTrsAgmtApplyToMas(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "PRD_TES ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### PRD_TES");
			dbDao.createTesMasRate(vo);// dbDao.createTesMasRate(sendStr);
			log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - RPD_AVG ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - RPD_AVG");
			dbDao.createMasCostPkgMainPrdAvg(vo);// dbDao.createMasCostPkgMainPrdAvg(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - COM_TTL ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - COM_TTL");
			dbDao.createMasCostPkgMainComTtl(vo);// dbDao.createMasCostPkgMainComTtl(sendStr);
			log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
			// -------------------------------------------

			strStep = "MAS - PRD_MST ";
			// -------------------------------------------
			timeSub = System.currentTimeMillis();
			log.info("\n### MAS - PRD_MST");
			dbDao.createMasCostPkgMainPrdMst(vo);// dbDao.createMasCostPkgMainPrdMst(sendStr);
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
			
			// 2014년 이전 BKG이면 재계산 하지 않는 로직 추가 (2015.06.19) - EsmMasB001, EsmMasB002 에도 추가
			String bkg_yr = dbDao.searchBkgYr(bkgNo);
			
			if (Integer.parseInt(bkg_yr) < 2015) {	// BKG YR이 2014년 이전이면 재계산 안함
//				dbDao.deleteBkgCostCalc(bkgNo);	// 분배치 테이블(MAS_BKG_COST_CALC)의 BKG번호 삭제
//				dbDao.deleteBkgIfMgmt(bkgNo);		// 일배치 테이블(MAS_COP_IF_MGMT)의 BKG번호 삭제
				log.debug("\n Befor 2014 BKG is not calculation. bkgNo = "+ bkgNo);
			} else {		//BKG YR이 2015 이상만 재계산
				/*
				 * 배치용 VO MasBatchParameterVO(String bkgNo, String startPctlNo,
				 * String endPctlNo, String costYrmon, String usrId, String delPara,
				 * String outParaVarchar, String outParaNumber)
				 */
				MasBatchParameterVO vo = new MasBatchParameterVO(bkgNo, null, null, null, userId, delPara, null, null, null);
	
				strStep = "MAS - BKG_STS ";
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
					
					// 1단계 : MAS_COM_PARA에 계정을 생성한다.
					if (Integer.parseInt(level) >= 1) {
						strStep = "MAS - COST_ASSIGN_COP ";
						// MAS - COST_ASSIGN_COP
						// -------------------------------------------
						timeSub = System.currentTimeMillis();
						log.debug("\n### MAS - COST_ASSIGN_COP");
						dbDao.createMasCostPrcAssignCop(vo);// dbDao.createMasCostPrcAssignCop(sendStr);
						log.info("\n### Time MAS - COST_ASSIGN_COP: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
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
						
						strStep = "MAS - BZC_COST_YRMON ";
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
		
							// ABC REV 적용하기 위해서 REV_DTL_PRC call 하는 위치 바꿈 - 2008.06.30 (CSR
							// NO.N200807027739)
							strStep = "MAS - BKG_REV_DTL ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - BKG_REV_DTL");
							dbDao.createMasBkgRevDtl(vo);// dbDao.createMasBkgRevDtl(sendStr);
							log.info("\n### Time MAS - BKG_REV_DTL: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "TRS ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### TRS");
							// eaiDao.sendTrsAgmtApplyToMas(sendStr);
							dbDao.createTrsAgmtApplyToMas(vo);// dbDao.createTrsAgmtApplyToMas(sendStr);
							log.info("\n### Time TRS: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "TES ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### TES");
							dbDao.createTesMasRate(vo);// dbDao.createTesMasRate(sendStr);
							log.info("\n### Time TES: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "MAS - COP_AVG ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - COP_AVG");
							dbDao.createMasCostPkgMainCopAvg(vo);// dbDao.createMasCostPkgMainCopAvg(sendStr);
							log.info("\n### Time MAS - COP_AVG: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "MAS - COP_ABC_STP ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - COP_ABC_STP");
							dbDao.createMasCostPrcCopAbcStp(vo);// dbDao.createMasCostPrcCopAbc(sendStr);
							log.info("\n### Time MAS - COP_ABC_STP: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "MAS - AGT PCTL NO ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### AGT");
							/*
							 * ALPS변경으로 ESM_MAS_AssignEventResponse로 받아서 꺼내지 않고 직접 DBRowSet을
							 * 받는것으로 수정 원본은 아래코드 ESM_MAS_AssignEventResponse rp =
							 * (ESM_MAS_AssignEventResponse) this.searchCopNoList(bkgNo);
							 * DBRowSet dbRs = rp.getRs();
							 */
							DBRowSet dbRs = this.searchCopNoList(bkgNo);
							log.debug("### dbRs: " + dbRs.getRowCount());
			
							strStep = "AGT CM ";
							String pctl_no = "";						
							//AGTCalcToMasBC agtCalcToMasBC = new AGTCalcToMasBCImpl();
							while (dbRs.next()) {
								pctl_no = dbRs.getString("pctl_no");							
								dbDao.createAcmAplyOtrCommToMas(pctl_no,userId);	// ACM 평균비용 적용				
								//agtCalcToMasBC.createCMComm(cop_no);
							}
							log.info("\n### Time: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "AGT ACT ";
							// -------------------------------------------
							log.debug("\n### AGT");
							//agtCalcToMasBC = new AGTCalcToMasBCImpl();
							
							//[CHM-201639877] 남미 Special Compensation 비용 적용 추가(BKG 생성시점에도 계산되도록) - 2016.02
					        // ACM에 BKG 번호 존재여부 확인
					        DBRowSet dbRsAcm = dbDao.searchAcmBkg(bkgNo);
					        
							if (dbRsAcm.next()) {
								//ACM 테이블에 BKG정보 존재하면(Rating 생성되면) Actual 비용 적용
								dbDao.createAcmAplyCommToMas(bkgNo,userId );	
							} else {       
								//ACM 테이블에 BKG정보 존재하지 않으면 Special 비용만 적용
								dbDao.createAcmAplySpclCommToMas(bkgNo,userId );	
					        }
							
							
							//ACM 테이블에 BKG정보 존재하면(Rating 생성되면) Actual 비용 적용
							dbDao.createAcmAplyCommToMas(bkgNo,userId );	
							
							//result = agtCalcToMasBC.createAgentComm(bkgNo);
							log.debug("### AGT result :" + result);
							log.info("\n### Time AGT: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
			
							strStep = "MAS - TTL ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - TTL");
							dbDao.createMasCostPkgMainComTtl(vo);// dbDao.createMasCostPkgMainComTtl(sendStr);
							log.info("\n### Time MAS - TTL: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
						}// if Integer.parseInt(level) >= 2
						// 3단계 : 비용집계(MAS_BKG_COST_SRC_DTL)
						if(Integer.parseInt(level) >= 3){
							strStep = "MAS - BKG_INFO_INST ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - BKG_INFO_INST");
							dbDao.createMasBkgInfoInst(vo);// dbDao.createMasBkgInfoInst(sendStr);
							log.info("\n### Time MAS - BKG_INFO_INST: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
						}
						// 4단계 : 비용집계(MAS_BKG_COST_SMRY)
						if(Integer.parseInt(level) >= 4){
							strStep = "MAS - BKG_COST_SMRY ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - BKG_COST_SMRY");
							dbDao.createMasBkgCostSmry(vo);// dbDao.createMasBkgCostSmry(sendStr);
							log.info("\n### Time MAS - BKG_COST_SMRY: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
						}
						// 5단계 : 비용집계(MAS_CNTR_REPO_IDX_ITM)
						if(Integer.parseInt(level) >= 5){
							strStep = "MAS - CNTR_REPO_IDX_ITM_INST ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - CNTR_REPO_IDX_ITM_INST");
							dbDao.createMasCostPrcCntrRepo(vo);// dbDao.createMasCostPrcCntrRepo(sendStr);
							log.info("\n### Time MAS - CNTR_REPO_IDX_ITM_INST: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
						}
						// 6단계 : 비용집계(MAS_BKG_EXPN_DTL)
						if(Integer.parseInt(level) >= 6){
							strStep = "MAS - BKG_EXPN_DTL_PRC ";
							// -------------------------------------------
							timeSub = System.currentTimeMillis();
							log.debug("\n### MAS - BKG_EXPN_DTL_PRC");
							dbDao.createMasBkgExpnDtl(vo);// dbDao.createMasBkgExpnDtl(sendStr);
							log.info("\n### Time MAS - BKG_EXPN_DTL_PRC: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeSub)));
							// -------------------------------------------
						}
						
					}//if start_pctl_no = ""
				}//bkg_sts_cd = X
	
				log.error("\n ### Time Total: "+ dateFormat.format(new Date(System.currentTimeMillis()- timeTotal)));
				log.error("\n ### -------------- [ End COP ] ----------------"+ "\n ### bkg_no: " + bkgNo + "");
			}

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
			dbDao.updateMasRgstBkg(bkgNo);
			dbDao.updateMasBkgExpnDtl(bkgNo);
			dbDao.updateMasBkgExpnDtlWk(bkgNo);
			dbDao.updateLeaEstmCostIf(bkgNo);
					
			log.debug("\n### AGT");
			dbDao.createAcmAplyCommToMas(bkgNo, userId);
			//AGTCalcToMasBCImpl agtCalcToMasBC = new AGTCalcToMasBCImpl();
			//result = agtCalcToMasBC.createAgentComm(bkgNo);		
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
	 * @param masBatCd
	 * @return List<MasBkgCostCalcVO>
	 * @exception EventException
	 */
	public List<MasBkgCostCalcVO> searchListAssign(String masBatCd)
			throws EventException {
		try {
			return dbDao.searchListAssign(masBatCd);
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
	public int updateBkgIfTrs2MasSoCancel(String bkgNo) throws EventException {
		int result = 0;
		try {
			result = dbDao.updateBkgIfTrs2MasSoCancel(bkgNo);
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
	 * @param masBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int modifyMasCommonInterface(MasBkgComIfVO masBkgComIfVo) throws EventException {
		int result = 0;

		try {
			
//			// 1. 일배치 요건에 대해서 일배치 테이블에 입력[MAS_COP_IF_MGMT]
//			if(masBkgComIfVo.getIfRmk().substring(0, 3).equals("")){
//				result = dbDao.multiMasCopIfMgmg(masBkgComIfVo);
//				
//			// 2. 분배치 요건에 대해서 분배치 테이블에 입력[MAS_BKG_COM_IF]
//			}else if(masBkgComIfVo.getIfRmk().substring(0, 3).equals("")){
				result = dbDao.modifyMasCommonInterface(masBkgComIfVo);
//			}
			// 3. I/F History 에 정보 입력
			result = dbDao.multiMasBkgComIfHis(masBkgComIfVo);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}
	
	/**
	 * BKG시스템의 변경사항을 일배치작업으로 수행하기위해 IF
	 * 
	 * @param masBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int modifyMasDailyInterface(MasBkgComIfVO masBkgComIfVo) throws EventException {
		int result = 0;

		try {
			
			// 1. 일배치 요건에 대해서 일배치 테이블에 입력[MAS_COP_IF_MGMT]			
				result = dbDao.multiMasCopIfMgmg(masBkgComIfVo);				

		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * MAS_COM_COST_PARA 테이블의 data를 삭제한다.
	 * Cost table 생성 시 process 가 끝난 후 mas_com_cost_para data 삭제
	 * 
	 * @param start_pctl_no
	 * @param end_pctl_no
	 * @return int
	 * @throws EventException
	 */
	public int removeMasComCostPara(String start_pctl_no, String end_pctl_no) throws EventException {
		int result = 0;

		try {
			
			// MAS_COM_COST_PARA 삭제			
			result = dbDao.removeMasComCostPara(start_pctl_no, end_pctl_no);				

		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return result;
	}
	
//	/**
//	 * BPM에 제공하는 정보를 조회한다.
//	 * 
//	 * @param bkg_no
//	 * @return
//	 * @throws EventException
//	 */
//	public List<SearchBpmInfoVO> searchBpmInfo(String bkg_no) throws EventException {
//		try{
//			return dbDao.searchBpmInfo(bkg_no);
//		}catch(Exception e){
//			log.error("err " + e.toString(), e);
//			throw new EventException(e.getMessage());
//		}
//	}
}