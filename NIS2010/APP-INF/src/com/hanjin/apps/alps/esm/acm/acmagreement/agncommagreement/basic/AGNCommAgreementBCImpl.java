/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementBCImpl.java
*@FileTitle : AGNCommAgreementBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration.AGNCommAgreementDBDAO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentMinimumCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailSubVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.GrpAgentVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBC;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

  
/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0001Event, AGNCommAgreementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommAgreementBCImpl extends BasicCommandSupport implements AGNCommAgreementBC {

	// Database Access Object
	private transient AGNCommAgreementDBDAO dbDao = null;

	/**
	 * AGNCommAgreementBCImpl 객체 생성<br>
	 * AGNCommAgreementDBDAO를 생성한다.<br>
	 */
	public AGNCommAgreementBCImpl() {
		dbDao = new AGNCommAgreementDBDAO();
	}

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> searchAgentRateMaster(AgentRateMasterVO agentRateMasterVO) throws EventException {
		try {
			return dbDao.searchAgentRateMaster(agentRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0001-01]
	 * [Master]탭 목록을 저장<br>
	 *
	 * @param AgentRateMasterVO[] agentRateMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgentRateMaster(AgentRateMasterVO[] agentRateMasterVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AgentRateMasterVO> insertVoList = new ArrayList<AgentRateMasterVO>();
			List<AgentRateMasterVO> updateVoList = new ArrayList<AgentRateMasterVO>();
			List<AgentRateMasterVO> historyVoList = new ArrayList<AgentRateMasterVO>();
			String agnAgmtHisSeq = "";

			for (int i=0; i<agentRateMasterVOs.length; i++) {
				// ACM_AGN_AGMT_MST 테이블에서 AGN_FM_DT, AGN_TO_DT로 중복 체크 - DATE_ERR_CHK에 Y가 나오면 Err
				if ("Y".equals(dbDao.getDupDataFromAcmAgmAgmtMstInfo(agentRateMasterVOs[i]).get(0).getDateErrChk())) {
					// [ACM00004] - $s is duplicated. Please check $s again!
					throw new EventException(new ErrorHandler("ACM00004", new String[]{"Effective date of  [" + agentRateMasterVOs[i].getAgnCd() + "]", "effective date or office information"}).getMessage());
				}

				agentRateMasterVOs[i].setUsrId(account.getUsr_id());
				if (agentRateMasterVOs[i].getIbflag().equals("I")) {
					insertVoList.add(agentRateMasterVOs[i]);
				} else {
					updateVoList.add(agentRateMasterVOs[i]);
				}
				agnAgmtHisSeq = dbDao.getAgnAgmtHisSeq();
				agentRateMasterVOs[i].setAgmtHisNo(agnAgmtHisSeq);
				historyVoList.add(agentRateMasterVOs[i]);
			}

			if (insertVoList.size() > 0) {
				dbDao.addAgentRateMaster(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyAgentRateMaster(updateVoList);
			}
			if (historyVoList.size() > 0) {
				dbDao.addAgentRateMasterHis(historyVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateDetailVO>
	 * @exception EventException
	 */
	public List<AgentRateDetailVO> searchAgentRateDetail(AgentRateMasterVO agentRateMasterVO) throws EventException {
		try {
			return dbDao.searchAgentRateDetail(agentRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master의 한 Row 에 해당하는 Minimum Commission 목록을 조회<br>
	 *
	 * @param AgentMinimumCommissionVO agentMinimumCommissionVO
	 * @return List<AgentMinimumCommissionVO>
	 * @exception EventException
	 */
	public List<AgentMinimumCommissionVO> searchAgentRateMinComm(AgentMinimumCommissionVO agentMinimumCommissionVO) throws EventException {
		try {
			return dbDao.searchAgentRateMinComm(agentMinimumCommissionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 저장<br>
	 *
	 * @param AgentRateDetailVO[] agentRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAgentRateDetail(AgentRateDetailVO[] agentRateDetailVOs, AgentMinimumCommissionVO[] agentMinimumCommissionVOs,SignOnUserAccount account) throws EventException {
		try {
			List<AgentRateDetailVO> insertVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> updateVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> deleteVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> historyVoList = new ArrayList<AgentRateDetailVO>();

			List<AgentRateDetailSubVO> subDeleteVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertCntrVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertRoutVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertChgVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertChgCommVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentMinimumCommissionVO> subInsertMinCommVoList = new ArrayList<AgentMinimumCommissionVO>();
			
			for (int i=0; i<agentRateDetailVOs.length; i++) {
				
				//History 시퀀스 생성
				String agnAgmtHisSeq = dbDao.getAgnAgmtHisSeq();
				agentRateDetailVOs[i].setAgmtHisNo(agnAgmtHisSeq);
				historyVoList.add(agentRateDetailVOs[i]);

				// DETAIL용 VO setting
				agentRateDetailVOs[i].setUsrId(account.getUsr_id());
				if(("P").equals(agentRateDetailVOs[i].getAcTpCd())) {		// 2017.08.18 Charge Commission 추가
					agentRateDetailVOs[i].setCommPayTermCd("");
					agentRateDetailVOs[i].setRevDivCd("");
					agentRateDetailVOs[i].setCommRt("");
					agentRateDetailVOs[i].setCntrTpszCd("");
					agentRateDetailVOs[i].setFullMtyCd("");
					agentRateDetailVOs[i].setCurrCd("");
					agentRateDetailVOs[i].setCommFxAmt("");
					agentRateDetailVOs[i].setRepChgCd("");
					agentRateDetailVOs[i].setChgCd("");
					agentRateDetailVOs[i].setHlgDdctOrgFlg("");
					agentRateDetailVOs[i].setHlgDdctDestFlg("");
					agentRateDetailVOs[i].setFdrgDdctOrgFlg("");
					agentRateDetailVOs[i].setFdrgDdctDestFlg("");
					if(("R").equals(agentRateDetailVOs[i].getChgCommRateDiv())){
						agentRateDetailVOs[i].setChgCommOtrAmt("");
						agentRateDetailVOs[i].setChgCommCurrCd("");
					} else {
						agentRateDetailVOs[i].setChgCommRt("");
					}
				} else {
					if ("F".equals(agentRateDetailVOs[i].getRateDiv())) {
						agentRateDetailVOs[i].setCommPayTermCd("");
						agentRateDetailVOs[i].setRevDivCd("");
						agentRateDetailVOs[i].setCommRt("");
					} else {
						agentRateDetailVOs[i].setCntrTpszCd("");
						agentRateDetailVOs[i].setFullMtyCd("");
						agentRateDetailVOs[i].setCurrCd("");
						agentRateDetailVOs[i].setCommFxAmt("");
					}
					agentRateDetailVOs[i].setCommChgCd("");
					agentRateDetailVOs[i].setChgCommDivCd("");
					agentRateDetailVOs[i].setChgCommRt("");
					agentRateDetailVOs[i].setChgCommOtrAmt("");
					agentRateDetailVOs[i].setChgCommCurrCd("");
					agentRateDetailVOs[i].setChgCommPayTermCd("");
				}
				
				if ("I".equals(agentRateDetailVOs[i].getIbflag())) {
					// 현재 insert는 한row만 허용하므로 가능
					String agnAgmtSeq = dbDao.getAgnAgmtSeqInfo(agentRateDetailVOs[i]).get(0).getAgnAgmtSeq();
					agentRateDetailVOs[i].setAgnAgmtSeq(agnAgmtSeq);
					insertVoList.add(agentRateDetailVOs[i]);
				} else if ("U".equals(agentRateDetailVOs[i].getIbflag())) {
						updateVoList.add(agentRateDetailVOs[i]);
				} else if ("D".equals(agentRateDetailVOs[i].getIbflag())) {
					deleteVoList.add(agentRateDetailVOs[i]);
				}
				// CNTR_TPSZ_CD, ROUTE, REP_CHG_CD, CHG_CD 각 해당 테이블용 VO setting
				// (Insert, Update일 경우도 각 해당 테이블에 delete후 insert로 진행)
				AgentRateDetailSubVO agentRateDetailSubVO = new AgentRateDetailSubVO();
				agentRateDetailSubVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
				agentRateDetailSubVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
				agentRateDetailSubVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
				agentRateDetailSubVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
				agentRateDetailSubVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
				agentRateDetailSubVO.setUsrId(account.getUsr_id());
				subDeleteVoList.add(agentRateDetailSubVO);

				if ("I".equals(agentRateDetailVOs[i].getIbflag()) || "U".equals(agentRateDetailVOs[i].getIbflag())) {
					// CNTR_TPSZ_CD insertVoList setting
					if (!"".equals(agentRateDetailVOs[i].getCntrTpszCd())) {
						String[] cntrTpszCdArr = agentRateDetailVOs[i].getCntrTpszCd().split(",");
						for (int k=0; k<cntrTpszCdArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailCntrVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailCntrVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailCntrVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailCntrVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailCntrVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailCntrVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailCntrVO.setAgnAgmtCntrSeq(Integer.toString(k + 1));
							agentRateDetailCntrVO.setCntrTpszCd(cntrTpszCdArr[k]);
							agentRateDetailCntrVO.setUsrId(account.getUsr_id());
							agentRateDetailCntrVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertCntrVoList.add(agentRateDetailCntrVO);
						}
					}

					// ROUTE insertVoList setting
					int routSeq = 0;
					// por_1
					if (!"".equals(agentRateDetailVOs[i].getPor1())) {
						String[] por1Arr = agentRateDetailVOs[i].getPor1().split(",");
						for (int k=0; k<por1Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPorVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPorVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPorVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPorVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPorVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPorVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPorVO.setRoutRefDivCd("PORV");
							agentRateDetailPorVO.setRoutLvlCd("1");
							agentRateDetailPorVO.setRoutInfoCd(por1Arr[k]);
							agentRateDetailPorVO.setUsrId(account.getUsr_id());
							agentRateDetailPorVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPorVO);
						}
					}
					// por_2
					if (!"".equals(agentRateDetailVOs[i].getPor2())) {
						String[] por2Arr = agentRateDetailVOs[i].getPor2().split(",");
						for (int k=0; k<por2Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPorVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPorVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPorVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPorVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPorVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPorVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPorVO.setRoutRefDivCd("PORV");
							agentRateDetailPorVO.setRoutLvlCd("2");
							agentRateDetailPorVO.setRoutInfoCd(por2Arr[k]);
							agentRateDetailPorVO.setUsrId(account.getUsr_id());
							agentRateDetailPorVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPorVO);
						}
					}
					// por_3
					if (!"".equals(agentRateDetailVOs[i].getPor3())) {
						String[] por3Arr = agentRateDetailVOs[i].getPor3().split(",");
						for (int k=0; k<por3Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPorVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPorVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPorVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPorVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPorVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPorVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPorVO.setRoutRefDivCd("PORV");
							agentRateDetailPorVO.setRoutLvlCd("3");
							agentRateDetailPorVO.setRoutInfoCd(por3Arr[k]);
							agentRateDetailPorVO.setUsrId(account.getUsr_id());
							agentRateDetailPorVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPorVO);
						}
					}
					// por_4
					if (!"".equals(agentRateDetailVOs[i].getPor4())) {
						String[] por4Arr = agentRateDetailVOs[i].getPor4().split(",");
						for (int k=0; k<por4Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPorVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPorVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPorVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPorVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPorVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPorVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPorVO.setRoutRefDivCd("PORV");
							agentRateDetailPorVO.setRoutLvlCd("4");
							agentRateDetailPorVO.setRoutInfoCd(por4Arr[k]);
							agentRateDetailPorVO.setUsrId(account.getUsr_id());
							agentRateDetailPorVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPorVO);
						}
					}
					// POR
					if (!"".equals(agentRateDetailVOs[i].getPor())) {
						String[] porArr = agentRateDetailVOs[i].getPor().split(",");
						for (int k=0; k<porArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPorVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPorVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPorVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPorVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPorVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPorVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPorVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPorVO.setRoutRefDivCd("POR");
							agentRateDetailPorVO.setRoutLvlCd(agentRateDetailVOs[i].getPorLvlCd());
							agentRateDetailPorVO.setRoutInfoCd(porArr[k]);
							agentRateDetailPorVO.setUsrId(account.getUsr_id());
							agentRateDetailPorVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPorVO);
						}
					}
					// pol_1
					if (!"".equals(agentRateDetailVOs[i].getPol1())) {
						String[] pol1Arr = agentRateDetailVOs[i].getPol1().split(",");
						for (int k=0; k<pol1Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPolVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPolVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPolVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPolVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPolVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPolVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPolVO.setRoutRefDivCd("POLV");
							agentRateDetailPolVO.setRoutLvlCd("1");
							agentRateDetailPolVO.setRoutInfoCd(pol1Arr[k]);
							agentRateDetailPolVO.setUsrId(account.getUsr_id());
							agentRateDetailPolVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPolVO);
						}
					}
					// pol_2
					if (!"".equals(agentRateDetailVOs[i].getPol2())) {
						String[] pol2Arr = agentRateDetailVOs[i].getPol2().split(",");
						for (int k=0; k<pol2Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPolVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPolVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPolVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPolVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPolVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPolVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPolVO.setRoutRefDivCd("POLV");
							agentRateDetailPolVO.setRoutLvlCd("2");
							agentRateDetailPolVO.setRoutInfoCd(pol2Arr[k]);
							agentRateDetailPolVO.setUsrId(account.getUsr_id());
							agentRateDetailPolVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPolVO);
						}
					}
					// pol_3
					if (!"".equals(agentRateDetailVOs[i].getPol3())) {
						String[] pol3Arr = agentRateDetailVOs[i].getPol3().split(",");
						for (int k=0; k<pol3Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPolVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPolVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPolVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPolVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPolVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPolVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPolVO.setRoutRefDivCd("POLV");
							agentRateDetailPolVO.setRoutLvlCd("3");
							agentRateDetailPolVO.setRoutInfoCd(pol3Arr[k]);
							agentRateDetailPolVO.setUsrId(account.getUsr_id());
							agentRateDetailPolVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPolVO);
						}
					}
					// pol_4
					if (!"".equals(agentRateDetailVOs[i].getPol4())) {
						String[] pol4Arr = agentRateDetailVOs[i].getPol4().split(",");
						for (int k=0; k<pol4Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPolVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPolVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPolVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPolVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPolVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPolVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPolVO.setRoutRefDivCd("POLV");
							agentRateDetailPolVO.setRoutLvlCd("4");
							agentRateDetailPolVO.setRoutInfoCd(pol4Arr[k]);
							agentRateDetailPolVO.setUsrId(account.getUsr_id());
							agentRateDetailPolVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPolVO);
						}
					}
					// POL
					if (!"".equals(agentRateDetailVOs[i].getPol())) {
						String[] polArr = agentRateDetailVOs[i].getPol().split(",");
						for (int k=0; k<polArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPolVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPolVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPolVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPolVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPolVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPolVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPolVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPolVO.setRoutRefDivCd("POL");
							agentRateDetailPolVO.setRoutLvlCd(agentRateDetailVOs[i].getPolLvlCd());
							agentRateDetailPolVO.setRoutInfoCd(polArr[k]);
							agentRateDetailPolVO.setUsrId(account.getUsr_id());
							agentRateDetailPolVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPolVO);
						}
					}
					// pod_1
					if (!"".equals(agentRateDetailVOs[i].getPod1())) {
						String[] pod1Arr = agentRateDetailVOs[i].getPod1().split(",");
						for (int k=0; k<pod1Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPodVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPodVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPodVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPodVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPodVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPodVO.setRoutRefDivCd("PODV");
							agentRateDetailPodVO.setRoutLvlCd("1");
							agentRateDetailPodVO.setRoutInfoCd(pod1Arr[k]);
							agentRateDetailPodVO.setUsrId(account.getUsr_id());
							agentRateDetailPodVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPodVO);
						}
					}
					// pod_2
					if (!"".equals(agentRateDetailVOs[i].getPod2())) {
						String[] pod2Arr = agentRateDetailVOs[i].getPod2().split(",");
						for (int k=0; k<pod2Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPodVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPodVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPodVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPodVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPodVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPodVO.setRoutRefDivCd("PODV");
							agentRateDetailPodVO.setRoutLvlCd("2");
							agentRateDetailPodVO.setRoutInfoCd(pod2Arr[k]);
							agentRateDetailPodVO.setUsrId(account.getUsr_id());
							agentRateDetailPodVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPodVO);
						}
					}
					// pod_3
					if (!"".equals(agentRateDetailVOs[i].getPod3())) {
						String[] pod3Arr = agentRateDetailVOs[i].getPod3().split(",");
						for (int k=0; k<pod3Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPodVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPodVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPodVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPodVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPodVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPodVO.setRoutRefDivCd("PODV");
							agentRateDetailPodVO.setRoutLvlCd("3");
							agentRateDetailPodVO.setRoutInfoCd(pod3Arr[k]);
							agentRateDetailPodVO.setUsrId(account.getUsr_id());
							agentRateDetailPodVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPodVO);
						}
					}
					// pod_4
					if (!"".equals(agentRateDetailVOs[i].getPod4())) {
						String[] pod4Arr = agentRateDetailVOs[i].getPod4().split(",");
						for (int k=0; k<pod4Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPodVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPodVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPodVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPodVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPodVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPodVO.setRoutRefDivCd("PODV");
							agentRateDetailPodVO.setRoutLvlCd("4");
							agentRateDetailPodVO.setRoutInfoCd(pod4Arr[k]);
							agentRateDetailPodVO.setUsrId(account.getUsr_id());
							agentRateDetailPodVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPodVO);
						}
					}
					// POD
					if (!"".equals(agentRateDetailVOs[i].getPod())) {
						String[] podArr = agentRateDetailVOs[i].getPod().split(",");
						for (int k=0; k<podArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailPodVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailPodVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailPodVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailPodVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailPodVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailPodVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailPodVO.setRoutRefDivCd("POD");
							agentRateDetailPodVO.setRoutLvlCd(agentRateDetailVOs[i].getPodLvlCd());
							agentRateDetailPodVO.setRoutInfoCd(podArr[k]);
							agentRateDetailPodVO.setUsrId(account.getUsr_id());
							agentRateDetailPodVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailPodVO);
						}
					}
					// del_1
					if (!"".equals(agentRateDetailVOs[i].getDel1())) {
						String[] del1Arr = agentRateDetailVOs[i].getDel1().split(",");
						for (int k=0; k<del1Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailDelVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailDelVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailDelVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailDelVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailDelVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailDelVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailDelVO.setRoutRefDivCd("DELV");
							agentRateDetailDelVO.setRoutLvlCd("1");
							agentRateDetailDelVO.setRoutInfoCd(del1Arr[k]);
							agentRateDetailDelVO.setUsrId(account.getUsr_id());
							agentRateDetailDelVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailDelVO);
						}
					}
					// del_2
					if (!"".equals(agentRateDetailVOs[i].getDel2())) {
						String[] del2Arr = agentRateDetailVOs[i].getDel2().split(",");
						for (int k=0; k<del2Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailDelVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailDelVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailDelVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailDelVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailDelVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailDelVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailDelVO.setRoutRefDivCd("DELV");
							agentRateDetailDelVO.setRoutLvlCd("2");
							agentRateDetailDelVO.setRoutInfoCd(del2Arr[k]);
							agentRateDetailDelVO.setUsrId(account.getUsr_id());
							agentRateDetailDelVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailDelVO);
						}
					}
					// del_3
					if (!"".equals(agentRateDetailVOs[i].getDel3())) {
						String[] del3Arr = agentRateDetailVOs[i].getDel3().split(",");
						for (int k=0; k<del3Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailDelVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailDelVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailDelVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailDelVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailDelVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailDelVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailDelVO.setRoutRefDivCd("DELV");
							agentRateDetailDelVO.setRoutLvlCd("3");
							agentRateDetailDelVO.setRoutInfoCd(del3Arr[k]);
							agentRateDetailDelVO.setUsrId(account.getUsr_id());
							agentRateDetailDelVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailDelVO);
						}
					}
					// del_4
					if (!"".equals(agentRateDetailVOs[i].getDel4())) {
						String[] del4Arr = agentRateDetailVOs[i].getDel4().split(",");
						for (int k=0; k<del4Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailDelVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailDelVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailDelVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailDelVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailDelVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailDelVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailDelVO.setRoutRefDivCd("DELV");
							agentRateDetailDelVO.setRoutLvlCd("4");
							agentRateDetailDelVO.setRoutInfoCd(del4Arr[k]);
							agentRateDetailDelVO.setUsrId(account.getUsr_id());
							agentRateDetailDelVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailDelVO);
						}
					}
					// DEL
					if (!"".equals(agentRateDetailVOs[i].getDel())) {
						String[] delArr = agentRateDetailVOs[i].getDel().split(",");
						for (int k=0; k<delArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailDelVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailDelVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailDelVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailDelVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailDelVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailDelVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailDelVO.setAgnAgmtRoutSeq(Integer.toString(routSeq++));
							agentRateDetailDelVO.setRoutRefDivCd("DEL");
							agentRateDetailDelVO.setRoutLvlCd(agentRateDetailVOs[i].getDelLvlCd());
							agentRateDetailDelVO.setRoutInfoCd(delArr[k]);
							agentRateDetailDelVO.setUsrId(account.getUsr_id());
							agentRateDetailDelVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertRoutVoList.add(agentRateDetailDelVO);
						}
					}

					// REP_CHG_CD, CHG_CD insertVoList setting
					int chgSeq = 0;
					if (!"".equals(agentRateDetailVOs[i].getRepChgCd())) {
						String[] repChgCdArr = agentRateDetailVOs[i].getRepChgCd().split(",");
						for (int k=0; k<repChgCdArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailRegChgVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailRegChgVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailRegChgVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailRegChgVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailRegChgVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailRegChgVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailRegChgVO.setAgnAgmtChgSeq(Integer.toString(chgSeq++));
							agentRateDetailRegChgVO.setChgDivCd("R");
							agentRateDetailRegChgVO.setChgCd(repChgCdArr[k]);
							agentRateDetailRegChgVO.setUsrId(account.getUsr_id());
							agentRateDetailRegChgVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertChgVoList.add(agentRateDetailRegChgVO);
						}
					}
					if (!"".equals(agentRateDetailVOs[i].getChgCd())) {
						String[] chgCdArr = agentRateDetailVOs[i].getChgCd().split(",");
						for (int k=0; k<chgCdArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailChgVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailChgVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailChgVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailChgVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailChgVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailChgVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailChgVO.setUsrId(account.getUsr_id());
							agentRateDetailChgVO.setAgnAgmtChgSeq(Integer.toString(chgSeq++));
							agentRateDetailChgVO.setChgDivCd("C");
							agentRateDetailChgVO.setChgCd(chgCdArr[k]);
							agentRateDetailChgVO.setUsrId(account.getUsr_id());
							agentRateDetailChgVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertChgVoList.add(agentRateDetailChgVO);
						}
					}
					// 2017.08.18 Charge Commission 추가
					// CHG_CD insertVoList setting
					if (!"".equals(agentRateDetailVOs[i].getCommChgCd())) {
						String[] commChgCdArr = agentRateDetailVOs[i].getCommChgCd().split(",");
						for (int k=0; k<commChgCdArr.length; k++) {
							AgentRateDetailSubVO agentRateDetailChgCommVO = new AgentRateDetailSubVO();
							// 반드시 컬럼 하나씩 복사(agentRateDetailSubVO를 그대로 복사하지 말것)
							agentRateDetailChgCommVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailChgCommVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailChgCommVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailChgCommVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailChgCommVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailChgCommVO.setAgnAgmtChgSeq(Integer.toString(k + 1));
							agentRateDetailChgCommVO.setChgCd(commChgCdArr[k]);
							agentRateDetailChgCommVO.setUsrId(account.getUsr_id());
							agentRateDetailChgCommVO.setAgmtHisNo(agnAgmtHisSeq);
							subInsertChgCommVoList.add(agentRateDetailChgCommVO);
						}
					}
					
					// 2018.03.22 Minimum Commission 추가
					// MinCommDivCd insertVoList setting
					if (!"".equals(agentRateDetailVOs[i].getMinCommDivCd())) {
						String[] minCommDivCdArr = agentRateDetailVOs[i].getMinCommDivCd().split(",");
						String[] minCommRtArr = agentRateDetailVOs[i].getMinCommRt().split(",");
						String[] minCommCurrCdArr = agentRateDetailVOs[i].getMinCommCurrCd().split(",");
						String[] minCommPerCdArr = agentRateDetailVOs[i].getMinCommPerCd().split(",");
						String[] minCommNetRevAmtCdArr = agentRateDetailVOs[i].getMinCommNetRevAmt().split(",");
						String[] minCommNetRevCurrCdArr = agentRateDetailVOs[i].getMinCommNetRevCurrCd().split(",");
						
						for (int k=0; k<minCommDivCdArr.length; k++) {
							AgentMinimumCommissionVO agentRateDetailChgCommVO = new AgentMinimumCommissionVO();
							
							agentRateDetailChgCommVO.setAgnCd(agentRateDetailVOs[i].getAgnCd());
							agentRateDetailChgCommVO.setAgnAgmtNo(agentRateDetailVOs[i].getAgnAgmtNo());
							agentRateDetailChgCommVO.setIoBndCd(agentRateDetailVOs[i].getIoBndCd());
							agentRateDetailChgCommVO.setAcTpCd(agentRateDetailVOs[i].getAcTpCd());
							agentRateDetailChgCommVO.setAgnAgmtSeq(agentRateDetailVOs[i].getAgnAgmtSeq());
							agentRateDetailChgCommVO.setAgnAgmtMinCommSeq(Integer.toString(k + 1));
							agentRateDetailChgCommVO.setMinCommDivCd(minCommDivCdArr[k]);
							agentRateDetailChgCommVO.setMinCommRt(minCommRtArr[k]);
							agentRateDetailChgCommVO.setMinCommCurrCd(minCommCurrCdArr[k]);
							agentRateDetailChgCommVO.setMinCommPerCd(minCommPerCdArr[k]);
							agentRateDetailChgCommVO.setMinCommNetRevAmt(minCommNetRevAmtCdArr[k]);
							agentRateDetailChgCommVO.setMinCommNetRevCurrCd(minCommNetRevCurrCdArr[k]);
							agentRateDetailChgCommVO.setCreUsrId(account.getUsr_id());
							agentRateDetailChgCommVO.setUpdUsrId(account.getUsr_id());
							agentRateDetailChgCommVO.setAgmtDtlHisNo(agnAgmtHisSeq);
							
							subInsertMinCommVoList.add(agentRateDetailChgCommVO);
						}
					}
					
				}
			}

			if (subDeleteVoList.size() > 0) {
				// CNTR_TPSZ_CD, ROUTE, REP_CHG_CD, CHG_CD의 delete는 일괄처리
				dbDao.removeAgentRateDetailCntr(subDeleteVoList);
				dbDao.removeAgentRateDetailRout(subDeleteVoList);
				dbDao.removeAgentRateDetailChg(subDeleteVoList);
				dbDao.removeAgentRateCommChg(subDeleteVoList);		// 2017.08.18 Charge Commission 추가
				dbDao.removeAgentRateMinComm(subDeleteVoList);		// 2018.03.22 Minimum Commission 추가
				
			}
			if (subInsertCntrVoList.size() > 0) {
				dbDao.addAgentRateDetailCntr(subInsertCntrVoList);
				//History
				dbDao.addAgentRateDetailCntrHis(subInsertCntrVoList);
			}
			if (subInsertRoutVoList.size() > 0) {
				dbDao.addAgentRateDetailRout(subInsertRoutVoList);
				//History
				dbDao.addAgentRateDetailRoutHis(subInsertRoutVoList);
			}
			if (subInsertChgVoList.size() > 0) {
				dbDao.addAgentRateDetailChg(subInsertChgVoList);
				//History
				dbDao.addAgentRateDetailChgHis(subInsertChgVoList);
			}
			// 2017.08.18 Charge Commission 추가
			if (subInsertChgCommVoList.size() > 0) {
				dbDao.addAgentRateCommChg(subInsertChgCommVoList);
				//History
				dbDao.addAgentRateCommChgHis(subInsertChgCommVoList);
			}
			
			// 2017.03.22 Minimum Commission 추가
			if (subInsertMinCommVoList.size() > 0) {
				dbDao.addAgentRateMinComm(subInsertMinCommVoList);
				//History
				dbDao.addAgentRateMinCommHis(subInsertMinCommVoList);
			}
			

			if (deleteVoList.size() > 0) {
				dbDao.removeAgentRateDetail(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyAgentRateDetail(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addAgentRateDetail(insertVoList);
			}
			//History
			if (historyVoList.size() > 0) {
				dbDao.addAgentRateDetailHis(historyVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0001-01]
	 * New Agreement No. 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> getNewAgreementNo(AgentRateMasterVO agentRateMasterVO) throws EventException {
		try {
			return dbDao.getNewAgreementNo(agentRateMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0101]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @exception EventException
	 */
	public void getAgreementNoInfo(AgentRateMasterVO agentRateMasterVO) throws EventException {
		try {
			if (dbDao.getAgreementNoInfo(agentRateMasterVO).size() < 1) {
				// [ACM00005] - $s does not exist!
				throw new EventException(new ErrorHandler("ACM00005", new String[]{"Agreement No. [" + agentRateMasterVO.getAgnAgmtNo() + "]"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Master와 Detail, TP/SZ, Route, Charge 목록을 New Ageement No.로 저장<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgmtCopy(AgentRateMasterVO agentRateMasterVO, SignOnUserAccount account) throws EventException {
		try {
			List<AgentRateMasterVO> agentRateMasterVOList = new ArrayList<AgentRateMasterVO>();
			if (agentRateMasterVO != null) {
				agentRateMasterVO.setUsrId(account.getUsr_id());
				// New Agreement No. 조회 후 setting
				String newAgmtNo = dbDao.getNewAgreementNo(agentRateMasterVO).get(0).getNewAgmtNo();
				agentRateMasterVO.setNewAgmtNo(newAgmtNo);

				//History 시퀀스 생성
				String agnAgmtHisSeq = dbDao.getAgnAgmtHisSeq();
				agentRateMasterVO.setAgmtHisNo(agnAgmtHisSeq);
				agentRateMasterVOList.add(agentRateMasterVO);

				// New Agreement No.로 저장된 데이터가 있다면 삭제
				dbDao.removeAgmtCopyMaster(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetail(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailCntr(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailRout(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailChg(agentRateMasterVOList);
				dbDao.removeAgmtCopyChgComm(agentRateMasterVOList);		// 2017.08.22 Charge Commission 추가
				dbDao.removeAgmtCopyMinComm(agentRateMasterVOList);		// 2018.04.19 Minimum Commission 추가

				// New Agreement No.로 기존 데이터 Copy
				dbDao.addAgmtCopyMaster(agentRateMasterVOList);
				dbDao.addAgmtCopyDetail(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailCntr(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailRout(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailChg(agentRateMasterVOList);
				dbDao.addAgmtCopyChgComm(agentRateMasterVOList);		// 2017.08.22 Charge Commission 추가
				dbDao.addAgmtCopyMinComm(agentRateMasterVOList);		// 2018.04.19 Minimum Commission 추가

				// History저장
				dbDao.addAgmtCopyMasterHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailCntrHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailRoutHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailChgHis(agentRateMasterVOList);
				dbDao.addAgmtCopyChgCommHis(agentRateMasterVOList);		// 2017.08.22 Charge Commission 추가
				dbDao.addAgmtCopyMinCommHis(agentRateMasterVOList);		// 2018.04.19 Minimum Commission 추가
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * [ESM_ACM_0001]
	 * 선택된 Agreement No.가 존재 하는지 확인<br>
	 *
	 * @param String agmt_no
	 * @return String
	 * @exception EventException
	 */
	public String searchAcmAgmtNoData(String agmt_no) throws EventException {
		try {
			String newAgmtNo = "";
			// New Agreement No. 조회 후 setting
			newAgmtNo = dbDao.searchAcmAgnAgmtNoData(agmt_no);
			if("".equalsIgnoreCase(newAgmtNo)){
				newAgmtNo = dbDao.searchAcmFfAgmtNoData(agmt_no);
			}
			return newAgmtNo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0009]
	 * GW에 EAI전송하기위한 ACM 계약서 정보 가져오기@@<br>
	 * @param AGNCommApprovalMasterVO
	 * @return AgentRateMasterVO
	 * @exception DAOException
	 */
	public List<AgentRateMasterVO> getAgmtDocInfo(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws EventException {
		try {
			return dbDao.getAgmtDocInfo(agnCommApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0009]
	 * Agent GW에 EAI전송하기위한 ACM 계약서 정보 가져오기@@<br>
	 * @param String csrNo
	 * @return AgentRateMasterVO
	 * @exception DAOException
	 */
	public GrpAgentVO manageAgentApplication(String csrNo) throws EventException {
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl(); 
		//AGNCommAgreementBC docCommand = new AGNCommAgreementBCImpl();
		//공통 CSR전표용 VO > MASTER VO, DETAIL
//		HdrVO hdrVO = new HdrVO();
//		DtrbListVO dtrbListVO = new DtrbListVO();
		GrpAgentVO grpVO = new GrpAgentVO();
		ComCsrRequestHeaderVO headerVo 	  = new ComCsrRequestHeaderVO();
		List<ComCsrRequestBodyVO> bodyVos = new ArrayList<ComCsrRequestBodyVO>();
		//List<ComCsrRequestAgmtVO> agmtVos = new ArrayList<ComCsrRequestAgmtVO>();
//		List<ComCsrRequestFileVO> fileVos = null;
		
		//1. ACM용 CSR 전표 INFO > MASTER, DETAIL
		//2. MASTER VO맵핑 ACM VO -> 공통 CSR VO
		//3. DETAIL VO맵핑 ACM VO -> 공통 CSR VO
		//4. ACM LINK INFO
		try {
			AGNCommInfoPrintMasterVO printMasterVO = new AGNCommInfoPrintMasterVO(); 
			AGNCommInfoPrintDetailVO printDetailVO = new AGNCommInfoPrintDetailVO();
			printMasterVO.setHCsrNo(csrNo);
			printDetailVO.setHCsrNo(csrNo);
			//1
			List<AGNCommInfoPrintMasterVO> printMasterList = command.searchGWACMCommInfoPrintMaster(printMasterVO);
			List<AGNCommInfoPrintDetailVO> printDetailList = command.searchGWACMCommInfoPrintDetail(printDetailVO);
			//2
			//for(int i=0;i < printMasterList.size();i++){
			AGNCommInfoPrintMasterVO acmMasterVO = printMasterList.get(0);
			headerVo = acmToComMaster(acmMasterVO, headerVo);
			//}
			//3
			for(int i=0;i < printDetailList.size();i++){
				ComCsrRequestBodyVO bodyVO = new ComCsrRequestBodyVO();
				AGNCommInfoPrintDetailVO acmDetailVO = printDetailList.get(i);
				bodyVos.add(acmToComDetail(acmDetailVO, bodyVO));
			}
			//4 - 
			/*AGNCommApprovalMasterVO approvalMasterVO = new AGNCommApprovalMasterVO();
			approvalMasterVO.setHCsrno(csrNo);
			List<AgentRateMasterVO> docList = getAgmtDocInfo(approvalMasterVO);
			for(int i=0; i < docList.size(); i++){
				ComCsrRequestAgmtVO docVO = new ComCsrRequestAgmtVO();
				AgentRateMasterVO rateMasterVO = docList.get(i);
				agmtVos.add(acmToComAgmt(rateMasterVO, docVO));
			}*/
			
			grpVO.setHeaderVo(headerVo);
			grpVO.setBodyVos(bodyVos);
			//grpVO.setAgmtVos(agmtVos);
			return grpVO;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * CSR I/F 화면서 호출<br>
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo2(csrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * AGNCommInfoPrintMasterVO 에서 HdrVO로 변환<br>
	 * @author 함대성
	 * @category ESM_ACM_0009
	 * @param AGNCommInfoPrintMasterVO acmMasterVO
	 * @param ComCsrRequestHeaderVO hdrVO
	 * @return ComCsrRequestHeaderVO
	 * @exception 
	 */
	public ComCsrRequestHeaderVO acmToComMaster(AGNCommInfoPrintMasterVO acmMasterVO, ComCsrRequestHeaderVO hdrVO){
		
		hdrVO.setCsrNo			(acmMasterVO.getHdrCsrNo   ());
		hdrVO.setOffice			(acmMasterVO.getHdrOffice  ());
		hdrVO.setPrpdBy			(acmMasterVO.getHdrPrpdBy  ());
		hdrVO.setPayTo			(acmMasterVO.getHdrPayTo   ());
		hdrVO.setCsrType		(acmMasterVO.getHdrCsrType ());
		hdrVO.setDescription	(acmMasterVO.getHdrDesc    ());
		hdrVO.setPayGroup		(acmMasterVO.getHdrPayGrp  ());
		hdrVO.setEvidence		(acmMasterVO.getHdrEviTp   ());
		hdrVO.setDueDate		(acmMasterVO.getHdrDueDt   ());
		hdrVO.setCurrency		(acmMasterVO.getHdrCurrCd  ());
		hdrVO.setAmount			(acmMasterVO.getHdrAmt     ());
		hdrVO.setInvoiceDate	(acmMasterVO.getHdrInvDt   ());
		hdrVO.setAsaNo			(acmMasterVO.getHdrAsaNo   ());
		hdrVO.setPymtAmt		(acmMasterVO.getHdrAmt     ());
		
		hdrVO.setQty        	(acmMasterVO.getQty             ());
		hdrVO.setSubject    	(acmMasterVO.getSubject         ());
		hdrVO.setVatregistno	(acmMasterVO.getVatRegistNo     ());
		hdrVO.setArOffsetNo 	(acmMasterVO.getArOffsetNo      ());
		hdrVO.setAprLine    	(acmMasterVO.getAprLine         ());
		hdrVO.setCsrdate    	(acmMasterVO.getCsrDate         ());
		
		//공백
		hdrVO.setBudget			("");
		hdrVO.setPerformance	("");
		hdrVO.setRatio          ("");
		
		return hdrVO;
	}
	
	/**
	 * AGNCommInfoPrintDetailVO 에서 DtrbListVO 변환<br>
	 * @author 함대성
	 * @category ESM_ACM_0009
	 * @param AGNCommInfoPrintDetailVO acmDetailVO
	 * @param ComCsrRequestBodyVO dtrbListVO
	 * @return ComCsrRequestBodyVO
	 * @exception 
	 */
	public ComCsrRequestBodyVO acmToComDetail(AGNCommInfoPrintDetailVO acmDetailVO, ComCsrRequestBodyVO dtrbListVO){
		//dtrbListVO.set		(acmDetailVO.getDtlChtAcct());
		dtrbListVO.setLSeq    	   	   (acmDetailVO.getDtlSeq());
		dtrbListVO.setLCoa    	   	   (acmDetailVO.getDtlChtAcct());
		dtrbListVO.setLAccountName	   (acmDetailVO.getDtlAcctNm());
		dtrbListVO.setLGlDate		   (acmDetailVO.getDtlGlDt   ());
		dtrbListVO.setLCity		   	   (acmDetailVO.getDtlCity   ());
		dtrbListVO.setLVendorInvNo	   (acmDetailVO.getDtlInvNo  ());
		dtrbListVO.setLDescription	   (acmDetailVO.getDtlDesc   ());
		dtrbListVO.setLDebitAmt		   (acmDetailVO.getDtlDebit  ());
		dtrbListVO.setLCreditAmt	   (acmDetailVO.getDtlCredit ());
		
		return dtrbListVO;
	}
	
	/**
	 * AGNCommInfoPrintDetailVO 에서 DtrbListVO 변환<br>
	 * @author 함대성
	 * @category ESM_ACM_0009
	 * @param AgentRateMasterVO acmAgmtVO
	 * @param ComCsrRequestAgmtVO docVO
	 * @return ComCsrRequestBodyVO
	 * @exception 
	 */
	public ComCsrRequestAgmtVO acmToComAgmt(AgentRateMasterVO acmAgmtVO, ComCsrRequestAgmtVO docVO){
		docVO.setLAssetcd	   	(acmAgmtVO.getAgmtDocNo	 ());
		docVO.setLDocumentTitle	(acmAgmtVO.getAgmtDocDesc());
		
		return docVO;
	}
	
	/**
	 * Charge Code 목록을 조회<br>
	 *
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception EventException
	 */
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws EventException {
		try {
			return dbDao.searchChargeCode(codeDescVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Surcharge count 조회<br>
	 *
	 * @param String chgCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeCnt(String chgCd) throws EventException {
		try {
			return dbDao.searchSurchargeCnt(chgCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}