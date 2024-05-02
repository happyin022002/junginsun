/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementBCImpl.java
*@FileTitle : AGNCommAgreementBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration.AGNCommAgreementDBDAO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailSubVO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0001Event, AGNCommAgreementBC DAO Class
 * @since J2EE 1.6
 */
public class AGNCommAgreementBCImpl extends BasicCommandSupport implements AGNCommAgreementBC {

	// Database Access Object
	private transient AGNCommAgreementDBDAO dbDao = null;

	/**
	 * AGNCommAgreementBCImpl object creation<br>
	 * AGNCommAgreementDBDAO creation<br>
	 */
	public AGNCommAgreementBCImpl() {
		dbDao = new AGNCommAgreementDBDAO();
	}

	/**
	 * [ESM_ACM_0001-01] Retrieve<br>
	 * [Master] tab / [Summary] tab - Master Agreement List retrieve<br>
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
	 * [Master]tab list save<br>
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
	 * [Detail]tab - Compensation Master / [Summary]tab - Detail list retrieve<br>
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
	 * [Detail]tab - Compensation Master list save<br>
	 *
	 * @param AgentRateDetailVO[] agentRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAgentRateDetail(AgentRateDetailVO[] agentRateDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AgentRateDetailVO> insertVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> updateVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> deleteVoList = new ArrayList<AgentRateDetailVO>();
			List<AgentRateDetailVO> historyVoList = new ArrayList<AgentRateDetailVO>();

			List<AgentRateDetailSubVO> subDeleteVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertCntrVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertRoutVoList = new ArrayList<AgentRateDetailSubVO>();
			List<AgentRateDetailSubVO> subInsertChgVoList = new ArrayList<AgentRateDetailSubVO>();

			for (int i=0; i<agentRateDetailVOs.length; i++) {
				//History sequence creation
				String agnAgmtHisSeq = dbDao.getAgnAgmtHisSeq();
				agentRateDetailVOs[i].setAgmtHisNo(agnAgmtHisSeq);
				historyVoList.add(agentRateDetailVOs[i]);

				// DETAIL VO setting
				agentRateDetailVOs[i].setUsrId(account.getUsr_id());
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

				if ("I".equals(agentRateDetailVOs[i].getIbflag())) {

					String agnAgmtSeq = dbDao.getAgnAgmtSeqInfo(agentRateDetailVOs[i]).get(0).getAgnAgmtSeq();
					agentRateDetailVOs[i].setAgnAgmtSeq(agnAgmtSeq);
					insertVoList.add(agentRateDetailVOs[i]);
				} else if ("U".equals(agentRateDetailVOs[i].getIbflag())) {
						updateVoList.add(agentRateDetailVOs[i]);
				} else if ("D".equals(agentRateDetailVOs[i].getIbflag())) {
					deleteVoList.add(agentRateDetailVOs[i]);
				}

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
					if (!"".equals(agentRateDetailVOs[i].getPod())) {
						String[] pod1Arr = agentRateDetailVOs[i].getPod1().split(",");
						for (int k=0; k<pod1Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							
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
					if (!"".equals(agentRateDetailVOs[i].getPod())) {
						String[] pod2Arr = agentRateDetailVOs[i].getPod2().split(",");
						for (int k=0; k<pod2Arr.length; k++) {
							AgentRateDetailSubVO agentRateDetailPodVO = new AgentRateDetailSubVO();
							
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
				}
			}

			if (subDeleteVoList.size() > 0) {
				// CNTR_TPSZ_CD, ROUTE, REP_CHG_CD, CHG_CD delete
				dbDao.removeAgentRateDetailCntr(subDeleteVoList);
				dbDao.removeAgentRateDetailRout(subDeleteVoList);
				dbDao.removeAgentRateDetailChg(subDeleteVoList);
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
	 * New Agreement No. retrieve<br>
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
	 * Validation of new agreement No. <br>
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
	 * Agreement number copy<br>
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
				// New Agreement No setting
				String newAgmtNo = dbDao.getNewAgreementNo(agentRateMasterVO).get(0).getNewAgmtNo();
				agentRateMasterVO.setNewAgmtNo(newAgmtNo);

				//History sequence creation 
				String agnAgmtHisSeq = dbDao.getAgnAgmtHisSeq();
				agentRateMasterVO.setAgmtHisNo(agnAgmtHisSeq);
				agentRateMasterVOList.add(agentRateMasterVO);


				dbDao.removeAgmtCopyMaster(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetail(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailCntr(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailRout(agentRateMasterVOList);
				dbDao.removeAgmtCopyDetailChg(agentRateMasterVOList);


				dbDao.addAgmtCopyMaster(agentRateMasterVOList);
				dbDao.addAgmtCopyDetail(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailCntr(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailRout(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailChg(agentRateMasterVOList);

				// History save
				dbDao.addAgmtCopyMasterHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailCntrHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailRoutHis(agentRateMasterVOList);
				dbDao.addAgmtCopyDetailChgHis(agentRateMasterVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}