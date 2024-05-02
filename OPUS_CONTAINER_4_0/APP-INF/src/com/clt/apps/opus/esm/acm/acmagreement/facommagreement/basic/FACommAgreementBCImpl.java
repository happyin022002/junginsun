/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementBCImpl.java
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.02 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration.FACommAgreementDBDAO;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration.FACommAgreementEAIDAO;
import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 * - OPUS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Bong-Gyoon
 * @see Esm_Acm_0024Event,FACommAgreementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FACommAgreementBCImpl extends BasicCommandSupport implements FACommAgreementBC {

	// Database Access Object
	private transient FACommAgreementDBDAO dbDao = null;
	// EAI Database Access Object
	private transient FACommAgreementEAIDAO eaiDao=null;

	/**
	 * FACommAgreementBCImpl 객체 생성<br>
	 * FACommAgreementDBDAO를 생성한다.<br>
	 */
	public FACommAgreementBCImpl() {
		dbDao = new FACommAgreementDBDAO();
		eaiDao = new FACommAgreementEAIDAO();
	}

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록을 조회<br>
	 *
	 * @param FACAgreementVO facAgreementVO
	 * @return List<FACAgreementVO>
	 * @exception EventException
	 */
	public List<FACAgreementVO> searchFACAgreement(FACAgreementVO facAgreementVO) throws EventException {
		try {
			return dbDao.searchFACAgreement(facAgreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 중복 조회<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @return List<FACAgreementVO>
	 * @exception EventException
	 */
	public List<FACAgreementVO> searchFACAgreementDup(FACAgreementVO[] facAgreementVOs) throws EventException {
		
		List<FACAgreementVO> dupVOs = new ArrayList<FACAgreementVO>();
			
			String frt_cnt_seq 			= "";
			String fac_agmt_seq			= "";
			String shpr_cnt_seq 		= "";
			String por_grp_tp_cd		= "";
			String por_rout_cd			= "";
			String pol_grp_tp_cd		= "";
			String pol_rout_cd			= "";
			String pod_grp_tp_cd		= "";
			String pod_rout_cd			= "";
			String del_grp_tp_cd		= "";
			String del_rout_cd			= "";
			String fm_eff_dt			= "";
			String to_eff_dt			= "";
			String svc_scp_cd			= "";
			String sc_no				= "";
			String rfa_no				= "";
			String cmdt_tp_cd			= "";
			String cmdt_cd				= "";
			String fac_div_cd			= "";
			String fac_ofc_cd			= "";
			String fac_sts_cd			= "";

			try{
				log.info("\n facAgreementVOs.length = "+facAgreementVOs.length);
				log.info("\n facAgreementVOs = "+facAgreementVOs);
				for(int i=0; i<facAgreementVOs.length; i++) {
					
					fac_ofc_cd = facAgreementVOs[i].getFacOfcCd();
					frt_cnt_seq = facAgreementVOs[i].getFrtCntSeq();
					fac_agmt_seq = facAgreementVOs[i].getFacAgmtSeq();
					shpr_cnt_seq = facAgreementVOs[i].getShprCntSeq();

					por_grp_tp_cd = facAgreementVOs[i].getPorGrpTpCd();
					pol_grp_tp_cd = facAgreementVOs[i].getPolGrpTpCd();
					pod_grp_tp_cd = facAgreementVOs[i].getPodGrpTpCd();
					del_grp_tp_cd = facAgreementVOs[i].getDelGrpTpCd();
					fm_eff_dt = facAgreementVOs[i].getFmEffDt();
					if(fm_eff_dt.length() <= 0) {
						fm_eff_dt = "20000101";
					}
					to_eff_dt = facAgreementVOs[i].getToEffDt();
					if(to_eff_dt.length() <= 0) {
						to_eff_dt = "29991231";
					}
					svc_scp_cd = facAgreementVOs[i].getSvcScpCd();
					if(svc_scp_cd.length() <= 0) {
						svc_scp_cd = "*";
					}
					sc_no = facAgreementVOs[i].getScNo();
					if(sc_no.length() <= 0) {
						sc_no = "*";
					}
					rfa_no = facAgreementVOs[i].getRfaNo();
					if(rfa_no.length() <= 0) {
						rfa_no = "*";
					}
					por_rout_cd = facAgreementVOs[i].getPorRoutCd();
					if(por_rout_cd.length() <= 0) {
						por_rout_cd = "*";
					}
					pol_rout_cd = facAgreementVOs[i].getPolRoutCd();
					if(pol_rout_cd.length() <= 0) {
						pol_rout_cd = "*";
					}
					pod_rout_cd = facAgreementVOs[i].getPodRoutCd();
					if(pod_rout_cd.length() <= 0) {
						pod_rout_cd = "*";
					}
					del_rout_cd = facAgreementVOs[i].getDelRoutCd();
					if(del_rout_cd.length() <= 0) {
						del_rout_cd = "*";
					}
					cmdt_tp_cd = facAgreementVOs[i].getCmdtTpCd();
					if(cmdt_tp_cd.length() <= 0 || "*".equals(cmdt_tp_cd)) {
						cmdt_tp_cd = "*";
						cmdt_cd = "*";
					}
					cmdt_cd = facAgreementVOs[i].getCmdtCd();
					if(cmdt_cd.length() <= 0) {
						cmdt_cd = "*";
					}
					fac_div_cd = facAgreementVOs[i].getFacDivCd();
					fac_sts_cd = facAgreementVOs[i].getFacStsCd();
					if(fac_sts_cd.length() <= 0) {
						fac_sts_cd = "RS";
					}

					facAgreementVOs[i].setFacOfcCd(fac_ofc_cd);
					facAgreementVOs[i].setFfCntCd(frt_cnt_seq.substring(0, 2));
					facAgreementVOs[i].setFfSeq(frt_cnt_seq.substring(2));

					if(facAgreementVOs[i].getIbflag().equals("I")) {
						fac_sts_cd = "RS"; // New
						if(shpr_cnt_seq.length() > 2) {
							facAgreementVOs[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
							facAgreementVOs[i].setShprSeq(shpr_cnt_seq.substring(2));
						}
						facAgreementVOs[i].setPorGrpTpCd(por_grp_tp_cd);
						facAgreementVOs[i].setPorRoutCd(por_rout_cd);
						facAgreementVOs[i].setPolGrpTpCd(pol_grp_tp_cd);
						facAgreementVOs[i].setPolRoutCd(pol_rout_cd);
						facAgreementVOs[i].setPodGrpTpCd(pod_grp_tp_cd);
						facAgreementVOs[i].setPodRoutCd(pod_rout_cd);
						facAgreementVOs[i].setDelGrpTpCd(del_grp_tp_cd);
						facAgreementVOs[i].setDelRoutCd(del_rout_cd);
						facAgreementVOs[i].setSvcScpCd(svc_scp_cd);
						facAgreementVOs[i].setFmEffDt(fm_eff_dt);
						facAgreementVOs[i].setToEffDt(to_eff_dt);
						facAgreementVOs[i].setScNo(sc_no);
						facAgreementVOs[i].setRfaNo(rfa_no);
						facAgreementVOs[i].setCmdtTpCd(cmdt_tp_cd);
						facAgreementVOs[i].setCmdtCd(cmdt_cd);
						facAgreementVOs[i].setFacDivCd(fac_div_cd);
						facAgreementVOs[i].setFacStsCd(fac_sts_cd);

						List<FACAgreementVO> dupList = dbDao.searchFACAgreementDup(facAgreementVOs[i]);
						if (dupList.size() > 0) {
							dupVOs.add(facAgreementVOs[i]);
						}
					}
				}
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
			return dupVOs;
	}

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록을 저장<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
    public void manageFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException {
//		List<FACAgreementVO> insertVoList = new ArrayList<FACAgreementVO>();
		List<FACAgreementVO> updateVoList2 = new ArrayList<FACAgreementVO>();
		List<FACAgreementVO> deleteVoList = new ArrayList<FACAgreementVO>();
		String frt_cnt_seq 			= "";
		String fac_agmt_seq			= "";
		String shpr_cnt_seq 		= "";
		String por_grp_tp_cd		= "";
		String por_rout_cd			= "";
		String pol_grp_tp_cd		= "";
		String pol_rout_cd			= "";
		String pod_grp_tp_cd		= "";
		String pod_rout_cd			= "";
		String del_grp_tp_cd		= "";
		String del_rout_cd			= "";
		String fm_eff_dt			= "";
		String to_eff_dt			= "";
		String svc_scp_cd			= "";
		String sc_no				= "";
		String rfa_no				= "";
		String cmdt_tp_cd			= "";
		String cmdt_cd				= "";
		String fac_div_cd			= "";
		String fac_ofc_cd			= "";
		String fac_sts_cd			= "";

		try{
			log.info("\n facAgreementVOs.length = "+facAgreementVOs.length);
			log.info("\n facAgreementVOs = "+facAgreementVOs);
			for(int i=0; i<facAgreementVOs.length; i++) {
				fac_ofc_cd = facAgreementVOs[i].getFacOfcCd();
				frt_cnt_seq = facAgreementVOs[i].getFrtCntSeq();
				fac_agmt_seq = facAgreementVOs[i].getFacAgmtSeq();
				shpr_cnt_seq = facAgreementVOs[i].getShprCntSeq();

				por_grp_tp_cd = facAgreementVOs[i].getPorGrpTpCd();
				pol_grp_tp_cd = facAgreementVOs[i].getPolGrpTpCd();
				pod_grp_tp_cd = facAgreementVOs[i].getPodGrpTpCd();
				del_grp_tp_cd = facAgreementVOs[i].getDelGrpTpCd();
				fm_eff_dt = facAgreementVOs[i].getFmEffDt();
				if(fm_eff_dt.length() <= 0) {
					fm_eff_dt = "20000101";
				}
				to_eff_dt = facAgreementVOs[i].getToEffDt();
				if(to_eff_dt.length() <= 0) {
					to_eff_dt = "29991231";
				}
				svc_scp_cd = facAgreementVOs[i].getSvcScpCd();
				if(svc_scp_cd.length() <= 0) {
					svc_scp_cd = "*";
				}
				sc_no = facAgreementVOs[i].getScNo();
				if(sc_no.length() <= 0) {
					sc_no = "*";
				}
				rfa_no = facAgreementVOs[i].getRfaNo();
				if(rfa_no.length() <= 0) {
					rfa_no = "*";
				}
				por_rout_cd = facAgreementVOs[i].getPorRoutCd();
				if(por_rout_cd.length() <= 0) {
					por_rout_cd = "*";
				}
				pol_rout_cd = facAgreementVOs[i].getPolRoutCd();
				if(pol_rout_cd.length() <= 0) {
					pol_rout_cd = "*";
				}
				pod_rout_cd = facAgreementVOs[i].getPodRoutCd();
				if(pod_rout_cd.length() <= 0) {
					pod_rout_cd = "*";
				}
				del_rout_cd = facAgreementVOs[i].getDelRoutCd();
				if(del_rout_cd.length() <= 0) {
					del_rout_cd = "*";
				}
				cmdt_tp_cd = facAgreementVOs[i].getCmdtTpCd();
				if(cmdt_tp_cd.length() <= 0 || "*".equals(cmdt_tp_cd)) {
					cmdt_tp_cd = "*";
					cmdt_cd = "*";
				}
				cmdt_cd = facAgreementVOs[i].getCmdtCd();
				if(cmdt_cd.length() <= 0) {
					cmdt_cd = "*";
				}
				fac_div_cd = facAgreementVOs[i].getFacDivCd();
				fac_sts_cd = facAgreementVOs[i].getFacStsCd();
				if(fac_sts_cd.length() <= 0) {
					fac_sts_cd = "RS";
				}

				facAgreementVOs[i].setFacOfcCd(fac_ofc_cd);
				facAgreementVOs[i].setFfCntCd(frt_cnt_seq.substring(0, 2));
				facAgreementVOs[i].setFfSeq(frt_cnt_seq.substring(2));

				if(facAgreementVOs[i].getIbflag().equals("I")) {
					fac_sts_cd = "RS"; // New
					if(shpr_cnt_seq.length() > 2) {
						facAgreementVOs[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						facAgreementVOs[i].setShprSeq(shpr_cnt_seq.substring(2));
					}
//					facAgreementVOs[i].setFacAgmtSeq(fac_agmt_seq);
					facAgreementVOs[i].setPorGrpTpCd(por_grp_tp_cd);
					facAgreementVOs[i].setPorRoutCd(por_rout_cd);
					facAgreementVOs[i].setPolGrpTpCd(pol_grp_tp_cd);
					facAgreementVOs[i].setPolRoutCd(pol_rout_cd);
					facAgreementVOs[i].setPodGrpTpCd(pod_grp_tp_cd);
					facAgreementVOs[i].setPodRoutCd(pod_rout_cd);
					facAgreementVOs[i].setDelGrpTpCd(del_grp_tp_cd);
					facAgreementVOs[i].setDelRoutCd(del_rout_cd);
					facAgreementVOs[i].setSvcScpCd(svc_scp_cd);
					facAgreementVOs[i].setFmEffDt(fm_eff_dt);
					facAgreementVOs[i].setToEffDt(to_eff_dt);
					facAgreementVOs[i].setScNo(sc_no);
					facAgreementVOs[i].setRfaNo(rfa_no);
					facAgreementVOs[i].setCmdtTpCd(cmdt_tp_cd);
					facAgreementVOs[i].setCmdtCd(cmdt_cd);
					facAgreementVOs[i].setFacDivCd(fac_div_cd);
					facAgreementVOs[i].setFacStsCd(fac_sts_cd);
					facAgreementVOs[i].setCreUsrId(account.getUsr_id());
					facAgreementVOs[i].setUpdUsrId(account.getUsr_id());

					//insertVoList.add(facAgreementVOs[i]);
					dbDao.addFACAgreement(facAgreementVOs[i]);
				} else if(facAgreementVOs[i].getIbflag().equals("U") && (fac_sts_cd.equals("RS") || fac_sts_cd.equals("RR"))) {
					if(shpr_cnt_seq.length() > 2) {
						facAgreementVOs[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						facAgreementVOs[i].setShprSeq(shpr_cnt_seq.substring(2));
					}
					facAgreementVOs[i].setFacAgmtSeq(fac_agmt_seq);
					facAgreementVOs[i].setPorGrpTpCd(por_grp_tp_cd);
					facAgreementVOs[i].setPorRoutCd(por_rout_cd);
					facAgreementVOs[i].setPolGrpTpCd(pol_grp_tp_cd);
					facAgreementVOs[i].setPolRoutCd(pol_rout_cd);
					facAgreementVOs[i].setPodGrpTpCd(pod_grp_tp_cd);
					facAgreementVOs[i].setPodRoutCd(pod_rout_cd);
					facAgreementVOs[i].setDelGrpTpCd(del_grp_tp_cd);
					facAgreementVOs[i].setDelRoutCd(del_rout_cd);
					facAgreementVOs[i].setSvcScpCd(svc_scp_cd);
					facAgreementVOs[i].setFmEffDt(fm_eff_dt);
					facAgreementVOs[i].setToEffDt(to_eff_dt);
					facAgreementVOs[i].setScNo(sc_no);
					facAgreementVOs[i].setRfaNo(rfa_no);
					facAgreementVOs[i].setCmdtTpCd(cmdt_tp_cd);
					facAgreementVOs[i].setCmdtCd(cmdt_cd);
					facAgreementVOs[i].setFacDivCd(fac_div_cd);
					facAgreementVOs[i].setFacStsCd(fac_sts_cd);
					facAgreementVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyFACAgreement(facAgreementVOs[i]);
				} else if(facAgreementVOs[i].getIbflag().equals("U") && !(fac_sts_cd.equals("RS") || fac_sts_cd.equals("RR"))) {
					facAgreementVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList2.add(facAgreementVOs[i]);
				} else if(facAgreementVOs[i].getIbflag().equals("D") && fac_sts_cd.equals("RS")) {
					deleteVoList.add(facAgreementVOs[i]);
				}
			}
//			if (insertVoList.size() > 0) {
//				dbDao.addFACAgreement(insertVoList);
//			}
			if (updateVoList2.size() > 0) {
				dbDao.modifyFACAgreement2(updateVoList2);
			}
			if (deleteVoList.size() > 0) {
				dbDao.deleteFACAgreement(deleteVoList);
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * [ESM_ACM_0024] Request<br>
	 * Request 버튼 클릭 이벤트 처리<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException {
		List<FACAgreementVO> requestVOList = new ArrayList<FACAgreementVO>();
		try{
			String sts = "RS";
			String subject = "Approval Request - FAC Agreement";
			String htmlTmpl = "ESM_ACM_FACommAgreementMailTemplate.htmlmail";

			String locDt = null;

			log.info("\n facAgreementVOs.length = "+facAgreementVOs.length);
			if(facAgreementVOs.length > 0) {
				for(int i=0; i<facAgreementVOs.length; i++){
					// Request 정보 업데이트
					facAgreementVOs[i].setFacRqstUsrId(account.getUsr_id());
					facAgreementVOs[i].setFacRqstUsrEml(account.getUsr_eml());
					facAgreementVOs[i].setFfCntCd(facAgreementVOs[i].getFrtCntSeq().substring(0, 2));
					facAgreementVOs[i].setFfSeq(facAgreementVOs[i].getFrtCntSeq().substring(2));
					log.info("\n facAgreementVOs="+facAgreementVOs[i].getFfCntCd());
					log.info("\n facAgreementVOs="+facAgreementVOs[i].getFfSeq());
					requestVOList.add(facAgreementVOs[i]);
				}
				dbDao.requestFACAgreement(requestVOList);
				//지역 현재 날짜 가져오기
				locDt = dbDao.getTemplateMailLocalDate(facAgreementVOs[0].getFacOfcCd());
				eaiDao.sendACMTemplateMail(sts, subject, htmlTmpl, facAgreementVOs, account, locDt);
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0024] Approve<br>
	 * Approve 버튼 클릭 이벤트 처리<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException {
		List<FACAgreementVO> approveVOList = new ArrayList<FACAgreementVO>();
		try{
			for(int i=0; i<facAgreementVOs.length; i++){
				facAgreementVOs[i].setFfCntCd(facAgreementVOs[i].getFrtCntSeq().substring(0,2));
				facAgreementVOs[i].setFfSeq(facAgreementVOs[i].getFrtCntSeq().substring(2));
				facAgreementVOs[i].setFacAproUsrId(account.getUsr_id());
				facAgreementVOs[i].setFacAproUsrEml(account.getUsr_eml());
				approveVOList.add(facAgreementVOs[i]);
			}
			dbDao.approveFACAgreement(approveVOList);
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0024] Reject<br>
	 * Reject 버튼 클릭 이벤트 처리<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException {
		List<FACAgreementVO> rejectVOList = new ArrayList<FACAgreementVO>();
		try {
			for(int i=0; i<facAgreementVOs.length; i++){
				facAgreementVOs[i].setFfCntCd(facAgreementVOs[i].getFrtCntSeq().substring(0,2));
				facAgreementVOs[i].setFfSeq(facAgreementVOs[i].getFrtCntSeq().substring(2));
				facAgreementVOs[i].setFacAproUsrId(account.getUsr_id());
				facAgreementVOs[i].setFacAproUsrEml(account.getUsr_eml());
				rejectVOList.add(facAgreementVOs[i]);
			}
			dbDao.rejectFACAgreement(rejectVOList);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0024] State<br>
	 * State 버튼 클릭 이벤트 처리<br>
	 *
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void stateFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException {
		List<FACAgreementVO> requestVOList = new ArrayList<FACAgreementVO>();
		try {
			for(int i=0; i<facAgreementVOs.length; i++){
				facAgreementVOs[i].setFfCntCd(facAgreementVOs[i].getFrtCntSeq().substring(0,2));
				facAgreementVOs[i].setFfSeq(facAgreementVOs[i].getFrtCntSeq().substring(2));
				facAgreementVOs[i].setFacRqstUsrId(account.getUsr_id());
				facAgreementVOs[i].setFacRqstUsrEml(account.getUsr_eml());
				requestVOList.add(facAgreementVOs[i]);
			}
			dbDao.stateFACAgreement(requestVOList);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}