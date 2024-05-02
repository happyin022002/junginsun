/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTOfficeAgreementInfoBCImpl.java
 *@FileTitle : Agent Agreement Rate Creation 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration.AGTOfficeAgreementInfoDBDAO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtAgnAgmtMstVO;
import com.clt.syscommon.common.table.AgtAgnAgmtRtVO;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;
import com.clt.syscommon.common.table.AgtAgnChgRefVO;
import com.clt.syscommon.common.table.AgtAgnCtrtRefVO;
import com.clt.syscommon.common.table.AgtAgnOtrRefVO;
import com.clt.syscommon.common.table.AgtAgnRoutRefVO;


/**
 * OPUS-AGTAgreement Business Logic Basic Command implementation<br>
 * - OPUS-AGTAgreement handling Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see EsmAgt0003EventResponse,AGTOfficeAgreementInfoBC DAO class
 * @since J2EE 1.6
 */
public class AGTOfficeAgreementInfoBCImpl extends BasicCommandSupport implements
		AGTOfficeAgreementInfoBC {

	// Database Access Object
	private transient AGTOfficeAgreementInfoDBDAO dbDao = null;

	/**
	 * AGTOfficeAgreementInfoBCImpl object creation<br>
	 * AGTOfficeAgreementInfoDBDAO creation<br>
	 */
	public AGTOfficeAgreementInfoBCImpl() {
		dbDao = new AGTOfficeAgreementInfoDBDAO();
	}

	/**
	 * (EsmAgt0001 retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentInfoForAgreementbyCountry(
			AgtAgnAgmtVO agtAgnAgmtVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchAgentInfoForAgreementbyCountry(agtAgnAgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * (EsmAgt0001 creation event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVOS,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < agtAgnAgmtVOS.length; i++) {
				if (agtAgnAgmtVOS[i].getIbflag().equals("U")) {
					agtAgnAgmtVOS[i].setUpdUsrId(account.getUsr_id());
					agtAgnAgmtVOS[i].setCreUsrId(account.getUsr_id());
					dbDao.createAgentInfoForAgreement(agtAgnAgmtVOS[i]);
					break;
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * (EsmAgt0001 remove event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVOS,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < agtAgnAgmtVOS.length; i++) {
				if (agtAgnAgmtVOS[i].getIbflag().equals("U")) {
					agtAgnAgmtVOS[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeAgentInfoForAgreement(agtAgnAgmtVOS[i]);
					dbDao.removeAgentInfoForAgreementMaster(agtAgnAgmtVOS[i]);
					break;
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * (EsmAgt0001 copy event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOS
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createOldAgreementNoVendortoNew(AgtAgnAgmtVO[] agtAgnAgmtVOS,
			AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account)
			throws EventException {
		try {
			AgtAgnAgmtVO paramAgtAgnAgmtVO = new AgtAgnAgmtVO();
			for (int i = 0; i < agtAgnAgmtVOS.length; i++) {
				if (agtAgnAgmtVOS[i].getIbflag().equals("U")) {
					agtAgnAgmtVOS[i].setAgmtOfcCtyCdValue(agtAgnAgmtVO 
							.getAgreementNo().substring(0, 3));
					agtAgnAgmtVOS[i].setAgnAgmtSeqValue(agtAgnAgmtVO
							.getAgreementNo().substring(3));
					agtAgnAgmtVOS[i].setAgmtOfcCtyCd(agtAgnAgmtVOS[i].getAgmtOfcCd().substring(0, 3));
					agtAgnAgmtVOS[i].setUpdUsrId(account.getUsr_id());
					agtAgnAgmtVOS[i].setCreUsrId(account.getUsr_id());
					paramAgtAgnAgmtVO = dbDao
							.createOldAgreementNoVendortoNewSelect(agtAgnAgmtVOS[i]);
					if (null == paramAgtAgnAgmtVO) {
						
						dbDao.createAgentInfoForAgreement(agtAgnAgmtVOS[i]);
					} else {
						//paramAgtAgnAgmtVO.setAgmtOfcCtyCdValue(agtAgnAgmtVO.getAgreementNo().substring(0, 3));
						//paramAgtAgnAgmtVO.setAgnAgmtSeqValue(agtAgnAgmtVO.getAgreementNo().substring(3));
						paramAgtAgnAgmtVO.setAgmtOfcCd(agtAgnAgmtVO.getAgmtOfcCd());
						paramAgtAgnAgmtVO.setAgmtOfcCtyCd(agtAgnAgmtVO.getAgmtOfcCd().substring(0, 3));
						paramAgtAgnAgmtVO.setVndrCntCd(agtAgnAgmtVO.getVndrCntCd());
						paramAgtAgnAgmtVO.setVndrSeq(agtAgnAgmtVO.getVndrSeq());
						paramAgtAgnAgmtVO.setCreUsrId(account.getUsr_id());
						paramAgtAgnAgmtVO.setUpdUsrId(account.getUsr_id());
						//paramAgtAgnAgmtVO.setVndrSeqValue(agtAgnAgmtVO.getVndrSeqValue());
						
						dbDao.createOldAgreementNoVendortoNewAgmtMst(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewAgmt(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewAgmtRt(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewRoutRef(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewChgRef(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewCtrtRef(paramAgtAgnAgmtVO);
						dbDao.createOldAgreementNoVendortoNewOtrRef(paramAgtAgnAgmtVO);
					}
					break;
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * (ESM_AGT_0003) AgentRateInfo retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtMstVO agtAgnAgmtMstVO
	 * @return List<AgtAgnAgmtMstVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtMstVO> searchAgentRateInfoList(
			AgtAgnAgmtMstVO agtAgnAgmtMstVO) throws EventException {
		try {
			return dbDao.searchAgentRateInfoList(agtAgnAgmtMstVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * (ESM_AGT_0003) AgentRateInfo retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentRateInfoList2(AgtAgnAgmtVO agtAgnAgmtVO)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchAgentRateInfoList2(agtAgnAgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * (ESM_AGT_003) AgentRateDetailInfo retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtRtVO> searchAgentRateDetailInfoList(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws EventException {

		try {
			AgtAgnOtrRefVO agtAgnOtrRefVO = null;
			AgtAgnChgRefVO agtAgnChgRefVO = null;
			AgtAgnCtrtRefVO agtAgnCtrtRefVO = null;
			AgtAgnRoutRefVO agtAgnRoutRefVO = null;

			List<AgtAgnOtrRefVO> selectListOtr = null;
			List<AgtAgnChgRefVO> selectListChg = null;
			List<AgtAgnCtrtRefVO> selectListCtrt = null;
			List<AgtAgnRoutRefVO> selectListRout = null;

			List<AgtAgnAgmtRtVO> selectList = new ArrayList<AgtAgnAgmtRtVO>();
			selectList = dbDao.searchAgentRateDetailInfoList(agtAgnAgmtRtVO);
			if(selectList.size() > 0){
			for (int i = 0; i < selectList.size(); i++) {
				agtAgnOtrRefVO = new AgtAgnOtrRefVO();
				agtAgnChgRefVO = new AgtAgnChgRefVO();
				agtAgnCtrtRefVO = new AgtAgnCtrtRefVO();
				agtAgnRoutRefVO = new AgtAgnRoutRefVO();

				agtAgnAgmtRtVO = selectList.get(i);

				String agmt_ofc_cd = agtAgnAgmtRtVO.getAgmtOfcCd();
				String agn_agmt_seq = agtAgnAgmtRtVO.getAgnAgmtSeq();
				String vndr_cnt_cd = agtAgnAgmtRtVO.getVndrCntCd();
				String vndr_seq = agtAgnAgmtRtVO.getVndrSeq();
				String agn_agmt_ver_seq = agtAgnAgmtRtVO.getAgnAgmtVerSeq();
				String io_bnd_cd = agtAgnAgmtRtVO.getIoBndCd();
				String ac_tp_cd = agtAgnAgmtRtVO.getAcTpCd();
				String agn_seq = agtAgnAgmtRtVO.getAgnSeq();

				agtAgnOtrRefVO.setAgmtOfcCd(agmt_ofc_cd);
				agtAgnOtrRefVO.setAgnAgmtSeq(agn_agmt_seq);
				agtAgnOtrRefVO.setVndrCntCd(vndr_cnt_cd);
				agtAgnOtrRefVO.setVndrSeq(vndr_seq);
				agtAgnOtrRefVO.setAgnAgmtVerSeq(agn_agmt_ver_seq);
				agtAgnOtrRefVO.setIoBndCd(io_bnd_cd);
				agtAgnOtrRefVO.setAcTpCd(ac_tp_cd);
				agtAgnOtrRefVO.setAgnSeq(agn_seq);
				// TP/SZ
				if (agtAgnAgmtRtVO.getCntrInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchCntrInpTermcd(agtAgnAgmtRtVO);
					log.info("\n selectListOtr.size="+selectListOtr.size());
					if(selectListOtr.size() > 0){
						agtAgnOtrRefVO = selectListOtr.get(0);
						agtAgnAgmtRtVO.setCntrInpTermCd(agtAgnOtrRefVO.getOtrInfoNo());
					}
					
				}
				// Deduct for Net Charge
				if (agtAgnAgmtRtVO.getChgDdctInpCd().equals("S")) {
					selectListChg = dbDao.setsearchChgDdctInpCd(agtAgnAgmtRtVO);
					String chg_grp_tp_chg_cd = "";
					String getVal = "";
					if(selectListChg.size() > 0){
						for (int j = 0; j < selectListChg.size(); j++) {
							agtAgnChgRefVO = selectListChg.get(j);
							String chg_grp_tp_cd = agtAgnChgRefVO.getChgGrpTpCd();
							String chg_cd = agtAgnChgRefVO.getChgCd();
							getVal = chg_grp_tp_cd + "-" + chg_cd;
							chg_grp_tp_chg_cd = chg_grp_tp_chg_cd + getVal + ",";
						}
						chg_grp_tp_chg_cd = chg_grp_tp_chg_cd.substring(0,(chg_grp_tp_chg_cd.length() - 1));
					}else{
						chg_grp_tp_chg_cd = "";
					}
					agtAgnAgmtRtVO.setChgDdctInpCd(chg_grp_tp_chg_cd);
				}
				// Customer
				if (agtAgnAgmtRtVO.getCustInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchCustInpTermCd(agtAgnAgmtRtVO);
					agtAgnOtrRefVO = selectListOtr.get(0);
					agtAgnAgmtRtVO.setCustInpTermCd(agtAgnOtrRefVO.getOtrInfoNo());
				}
				// S/C##
				if (agtAgnAgmtRtVO.getScInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchScInpTermCd(agtAgnAgmtRtVO);
					agtAgnOtrRefVO = selectListOtr.get(0);
					agtAgnAgmtRtVO.setScInpTermCd(agtAgnOtrRefVO.getOtrInfoNo());
				}
				// RFA##
				if (agtAgnAgmtRtVO.getRfaInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchRfaInpTermCd(agtAgnAgmtRtVO);
					agtAgnOtrRefVO = selectListOtr.get(0);
					agtAgnAgmtRtVO.setRfaInpTermCd(agtAgnOtrRefVO
							.getOtrInfoNo());
				}
				// S/C OFC
				if (agtAgnAgmtRtVO.getScOfcInpCd().equals("S")) {
					selectListCtrt = dbDao.setsearchScOfcInpCd(agtAgnAgmtRtVO);
					agtAgnCtrtRefVO = selectListCtrt.get(0);
					agtAgnAgmtRtVO.setScOfcInpCd(agtAgnCtrtRefVO.getAgnCtrtOfcCd());
				}
				// RFA OFC
				if (agtAgnAgmtRtVO.getRfaOfcInpCd().equals("S")) {
					selectListCtrt = dbDao.setsearchRfaOfcInpCd(agtAgnAgmtRtVO);
					agtAgnCtrtRefVO = selectListCtrt.get(0);
					agtAgnAgmtRtVO.setRfaOfcInpCd(agtAgnCtrtRefVO.getAgnCtrtOfcCd());
				}
				// BKG OFC
				if (agtAgnAgmtRtVO.getBkgOfcInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgOfcInpTermCd(agtAgnAgmtRtVO);
					agtAgnRoutRefVO = selectListRout.get(0);
					agtAgnAgmtRtVO.setBkgOfcInpTermCd(agtAgnRoutRefVO.getRoutInfoCd());
				}
				// Sales OFC
				if (agtAgnAgmtRtVO.getSlsOfcInpTermCd().equals("S")) {
					selectListRout = dbDao
							.setsearchSlsOfcInpTermCd(agtAgnAgmtRtVO);
					agtAgnRoutRefVO = selectListRout.get(0);
					agtAgnAgmtRtVO.setSlsOfcInpTermCd(agtAgnRoutRefVO.getRoutInfoCd());
				}
				// POR
				if (agtAgnAgmtRtVO.getBkgPorInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgPorInpTermCd(agtAgnAgmtRtVO);
					log.info("\n selectListRout.size()="+ selectListRout.size());
					String rout_lvl_info_cd = "";
					String getVal = "";
					if(selectListRout.size() > 0){
						for (int j = 0; j < selectListRout.size(); j++) {
							agtAgnRoutRefVO = selectListRout.get(j);
							String rout_info_cd = agtAgnRoutRefVO.getRoutInfoCd();
							String rout_lvl_cd = agtAgnRoutRefVO.getRoutLvlCd();
							getVal = rout_lvl_cd + "-" + rout_info_cd;
							rout_lvl_info_cd = rout_lvl_info_cd + getVal + ",";
						}
						rout_lvl_info_cd = rout_lvl_info_cd.substring(0,(rout_lvl_info_cd.length() - 1));
					}else{
						rout_lvl_info_cd = "";
					}
					agtAgnAgmtRtVO.setBkgPorInpTermCd(rout_lvl_info_cd);
				}
				// POL
				if (agtAgnAgmtRtVO.getBkgPolInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgPolInpTermCd(agtAgnAgmtRtVO);
					log.info("\n selectListRout.size()="+ selectListRout.size());
					String rout_lvl_info_cd = "";
					String getVal = "";
					if(selectListRout.size() > 0){
						for (int j = 0; j < selectListRout.size(); j++) {
							agtAgnRoutRefVO = selectListRout.get(j);
							String rout_info_cd = agtAgnRoutRefVO.getRoutInfoCd();
							String rout_lvl_cd = agtAgnRoutRefVO.getRoutLvlCd();
							getVal = rout_lvl_cd + "-" + rout_info_cd;
							rout_lvl_info_cd = rout_lvl_info_cd + getVal + ",";
						}
						rout_lvl_info_cd = rout_lvl_info_cd.substring(0,(rout_lvl_info_cd.length() - 1));
					}else{
						rout_lvl_info_cd = "";
					}
					agtAgnAgmtRtVO.setBkgPolInpTermCd(rout_lvl_info_cd);
				}
				// POD
				if (agtAgnAgmtRtVO.getBkgPodInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgPodInpTermCd(agtAgnAgmtRtVO);
					log.info("\n selectListRout.size()="+ selectListRout.size());
					String rout_lvl_info_cd = "";
					String getVal = "";
					if(selectListRout.size() > 0){
						for (int j = 0; j < selectListRout.size(); j++) {
							agtAgnRoutRefVO = selectListRout.get(j);
							String rout_info_cd = agtAgnRoutRefVO.getRoutInfoCd();
							String rout_lvl_cd = agtAgnRoutRefVO.getRoutLvlCd();
							getVal = rout_lvl_cd + "-" + rout_info_cd;
							rout_lvl_info_cd = rout_lvl_info_cd + getVal + ",";
						}
						rout_lvl_info_cd = rout_lvl_info_cd.substring(0,(rout_lvl_info_cd.length() - 1));
					}else{
						rout_lvl_info_cd = "";
					}
					agtAgnAgmtRtVO.setBkgPodInpTermCd(rout_lvl_info_cd);
				}
				// DEL
				if (agtAgnAgmtRtVO.getBkgDelInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgDelInpTermCd(agtAgnAgmtRtVO);
					String rout_lvl_info_cd = "";
					String getVal = "";
					if(selectListRout.size() > 0){
						for (int j = 0; j < selectListRout.size(); j++) {
							agtAgnRoutRefVO = selectListRout.get(j);
							String rout_info_cd = agtAgnRoutRefVO.getRoutInfoCd();
							String rout_lvl_cd = agtAgnRoutRefVO.getRoutLvlCd();
							getVal = rout_lvl_cd + "-" + rout_info_cd;
							rout_lvl_info_cd = rout_lvl_info_cd + getVal + ",";
						}
						rout_lvl_info_cd = rout_lvl_info_cd.substring(0,(rout_lvl_info_cd.length() - 1));
					}else{
						rout_lvl_info_cd = "";
					}
					agtAgnAgmtRtVO.setBkgDelInpTermCd(rout_lvl_info_cd);
				}
				// PPD
				if (agtAgnAgmtRtVO.getBkgPpdInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgPpdInpTermCd(agtAgnAgmtRtVO);
					agtAgnRoutRefVO = selectListRout.get(0);
					agtAgnAgmtRtVO.setBkgPpdInpTermCd(agtAgnRoutRefVO.getRoutInfoCd());
				}
				// CCT
				if (agtAgnAgmtRtVO.getBkgCltInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgCltInpTermCd(agtAgnAgmtRtVO);
					agtAgnRoutRefVO = selectListRout.get(0);
					agtAgnAgmtRtVO.setBkgCltInpTermCd(agtAgnRoutRefVO.getRoutInfoCd());
				}
				// 3rd Party at
				if (agtAgnAgmtRtVO.getBkgN3rdInpTermCd().equals("S")) {
					selectListRout = dbDao.setsearchBkgN3rdInpTermCd(agtAgnAgmtRtVO);
					agtAgnRoutRefVO = selectListRout.get(0);
					agtAgnAgmtRtVO.setBkgN3rdInpTermCd(agtAgnRoutRefVO.getRoutInfoCd());
				}
				// lane
				if (agtAgnAgmtRtVO.getLaneInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchLaneInpTermCd(agtAgnAgmtRtVO);
					agtAgnOtrRefVO = selectListOtr.get(0);
					agtAgnAgmtRtVO.setLaneInpTermCd(agtAgnOtrRefVO.getOtrInfoNo());
				}
				// vsl_inp_term_cd
				if (agtAgnAgmtRtVO.getVslInpTermCd().equals("S")) {
					selectListOtr = dbDao.setsearchVslInpTermCd(agtAgnAgmtRtVO);
					agtAgnOtrRefVO = selectListOtr.get(0);
					agtAgnAgmtRtVO.setVslInpTermCd(agtAgnOtrRefVO.getOtrInfoNo());
				}
			}
			}
			return selectList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * (ESM_AGT_003) AgentRateInfo CUD implementing<br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multiAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVO,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < agtAgnAgmtVO.length; i++) {
				log.info("\n agtAgnAgmtVO["+i+"].getIbflag()="+agtAgnAgmtVO[i].getIbflag());
				if (agtAgnAgmtVO[i].getIbflag().equals("I")) {
					agtAgnAgmtVO[i].setCreUsrId(account.getUsr_id());
					agtAgnAgmtVO[i].setUpdUsrId(account.getUsr_id());
					agtAgnAgmtVO[i].setAgmtOfcCd(agtAgnAgmtVO[0].getAgmtOfcCd());
					agtAgnAgmtVO[i].setAgmtOfcCtyCd(agtAgnAgmtVO[0].getAgmtOfcCtyCd());
					agtAgnAgmtVO[i].setAgnAgmtSeq(agtAgnAgmtVO[0].getAgnAgmtSeq());
					agtAgnAgmtVO[i].setVndrCntCd(agtAgnAgmtVO[0].getVndrCntCd());
					agtAgnAgmtVO[i].setVndrSeq(agtAgnAgmtVO[0].getVndrSeq());

					dbDao.addmultiAgentRateInfo(agtAgnAgmtVO[i]);
				} else if (agtAgnAgmtVO[i].getIbflag().equals("U")) {
					agtAgnAgmtVO[i].setUpdUsrId(account.getUsr_id());
					agtAgnAgmtVO[i].setAgmtOfcCd(agtAgnAgmtVO[0].getAgmtOfcCd());
					agtAgnAgmtVO[i].setAgmtOfcCtyCd(agtAgnAgmtVO[0].getAgmtOfcCtyCd());
					agtAgnAgmtVO[i].setAgnAgmtSeq(agtAgnAgmtVO[0].getAgnAgmtSeq());
					agtAgnAgmtVO[i].setVndrCntCd(agtAgnAgmtVO[0].getVndrCntCd());
					agtAgnAgmtVO[i].setVndrSeq(agtAgnAgmtVO[0].getVndrSeq());

					dbDao.modifymultiAgentRateInfo(agtAgnAgmtVO[i]);
				} else if (agtAgnAgmtVO[i].getIbflag().equals("D")) {
					agtAgnAgmtVO[i].setUpdUsrId(account.getUsr_id());
					agtAgnAgmtVO[i].setAgmtOfcCd(agtAgnAgmtVO[0].getAgmtOfcCd());
					agtAgnAgmtVO[i].setAgmtOfcCtyCd(agtAgnAgmtVO[0].getAgmtOfcCtyCd());
					agtAgnAgmtVO[i].setAgnAgmtSeq(agtAgnAgmtVO[0].getAgnAgmtSeq());
					agtAgnAgmtVO[i].setVndrCntCd(agtAgnAgmtVO[0].getVndrCntCd());
					agtAgnAgmtVO[i].setVndrSeq(agtAgnAgmtVO[0].getVndrSeq());

					dbDao.deletemultiAgentRateInfo(agtAgnAgmtVO[i]);
				}
			}
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * (ESM_AGT_003) Agreement information Copy event process<br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOs
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multicopyAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVOs, AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			AgtAgnAgmtVO paramAgtAgnAgmtVO = new AgtAgnAgmtVO();
//			List<AgtAgnAgmtVO> insertVoList = new ArrayList<AgtAgnAgmtVO>();
			for (int i = 0; i < agtAgnAgmtVOs.length; i++) {
				log.info(agtAgnAgmtVOs[i].getIbflag());
				if (agtAgnAgmtVOs[i].getIbflag().equals("I")) {
					paramAgtAgnAgmtVO = dbDao.searchAgentRateInfoAgnAgmtVerSeq(agtAgnAgmtVOs[i]);
					log.info("\n paramAgtAgnAgmtVO.getAgnAgmtVerSeq = "+paramAgtAgnAgmtVO.getAgnAgmtVerSeq());
					agtAgnAgmtVOs[i].setAgnAgmtVerSeq(paramAgtAgnAgmtVO.getAgnAgmtVerSeq());
					agtAgnAgmtVOs[i].setCreUsrId(account.getUsr_id());
					agtAgnAgmtVOs[i].setUpdUsrId(account.getUsr_id());
					log.info("\n current="+agtAgnAgmtVOs[i].getCurrent());
					
					if(paramAgtAgnAgmtVO != null){
						dbDao.copyAgentRateInfoAgtAgnAgmt(agtAgnAgmtVOs[i]);
						dbDao.copyAgentRateInfoAgtAgnAgmtRt(agtAgnAgmtVOs[i]);
						dbDao.copyAgentRateInfoAgtAgnRoutRef(agtAgnAgmtVOs[i]);
						dbDao.copyAgentRateInfoAgtAgnChgRef(agtAgnAgmtVOs[i]);
						dbDao.copyAgentRateInfoAgtAgnCtrtRef(agtAgnAgmtVOs[i]);
						dbDao.copyAgentRateInfoAgtAgnOtrRef(agtAgnAgmtVOs[i]);
					}
					break;
				}
			}
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_AGT_0003) Agent Agreement Rate Creation information SAVE(C, U, D) event process<br>
	 * @param AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void multiAgentRateDetailInfo(AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS, AgtAgnAgmtRtVO agtAgnAgmtRtVO, SignOnUserAccount account) throws EventException {
	    // TODO Auto-generated method stub
		try{
			AgtAgnAgmtRtVO paramAgtAgnAgmtRtVO = null;
			AgtAgnChgRefVO paramAgtAgnChgRefVO = null;
			AgtAgnOtrRefVO paramAgtAgnOtrRefVO = null;
			AgtAgnCtrtRefVO paramAgtAgnCtrtRefVO = null;
			AgtAgnRoutRefVO paramagAgtAgnRoutRefVO = null;

			log.info("\n agtAgnAgmtRtVOS.length="+agtAgnAgmtRtVOS.length);
			for(int i=0;i<agtAgnAgmtRtVOS.length; i++ ){
				//agmt_ofc_cd, agmt_ofc_cty_cd, agn_agmt_seq, vndr_cnt_cd, vndr_seq, agn_agmt_ver_seq
				agtAgnAgmtRtVOS[i].setAgmtOfcCd(agtAgnAgmtRtVOS[0].getAgmtOfcCd());
				agtAgnAgmtRtVOS[i].setAgmtOfcCtyCd(agtAgnAgmtRtVOS[0].getAgmtOfcCtyCd());
				agtAgnAgmtRtVOS[i].setAgnAgmtSeq(agtAgnAgmtRtVOS[0].getAgnAgmtSeq());
				agtAgnAgmtRtVOS[i].setVndrCntCd(agtAgnAgmtRtVOS[0].getVndrCntCd());
				agtAgnAgmtRtVOS[i].setVndrSeq(agtAgnAgmtRtVOS[0].getVndrSeq());
				agtAgnAgmtRtVOS[i].setAgnAgmtVerSeq(agtAgnAgmtRtVOS[0].getAgnAgmtVerSeq());
				log.info("\n agtAgnAgmtRtVOS["+i+"]="+agtAgnAgmtRtVOS[i].getAgmtOfcCd());
				
				paramAgtAgnAgmtRtVO = new AgtAgnAgmtRtVO();
				paramAgtAgnChgRefVO = new AgtAgnChgRefVO();
				paramAgtAgnOtrRefVO = new AgtAgnOtrRefVO();
				paramAgtAgnCtrtRefVO = new AgtAgnCtrtRefVO();
				paramagAgtAgnRoutRefVO = new AgtAgnRoutRefVO();
				
				agtAgnAgmtRtVOS[i].setUpdUsrId(account.getUsr_id());
				agtAgnAgmtRtVOS[i].setCreUsrId(account.getUsr_id());

				if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("K")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512641");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("G")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512621");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("H")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512661");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("R")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512631");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("S")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512631");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("D")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512691");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("O")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512661");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("O") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("C")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512621");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("I") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("G")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512611");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("I") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("H")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512661");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("I") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("R")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512631");
				}else if(agtAgnAgmtRtVOS[i].getIoBndCd().equals("I") && agtAgnAgmtRtVOS[i].getAcTpCd().equals("S")){
					agtAgnAgmtRtVOS[i].setCommStndCostCd("512631");
				}else{
					agtAgnAgmtRtVOS[i].setCommStndCostCd("");
				}
				//if(fx_comm_amt[j].equals("")){insertPs01.setDouble(i++, 0);}else{insertPs01.setDouble(i++,Double.parseDouble(fx_comm_amt[j]));}
				//if(agtAgnAgmtRtVOS[i].getFxCommAmt().equals("") || agtAgnAgmtRtVOS[i].getFxCommAmt() == null){agtAgnAgmtRtVOS[i].setFxCommAmt("0");}
            	//if(bkg_comm_rt[j].equals("")){insertPs01.setDouble(i++, 0);}else{insertPs01.setDouble(i++,Double.parseDouble(bkg_comm_rt[j]));}
				//if(agtAgnAgmtRtVOS[i].getBkgCommRt().equals("") || agtAgnAgmtRtVOS[i].getBkgCommRt() == null){agtAgnAgmtRtVOS[i].setBkgCommRt("0");}
				
				if(agtAgnAgmtRtVOS[i].getIbflag().equals("I")){
					paramAgtAgnAgmtRtVO = dbDao.searchAgtAgnAgmtRtAgnSeq(agtAgnAgmtRtVOS[i]);
					agtAgnAgmtRtVOS[i].setAgnSeq(paramAgtAgnAgmtRtVO.getAgnSeq());
					if(paramAgtAgnAgmtRtVO != null){
						dbDao.addmultiRowCopySaveAgtAgnAgmtRt(agtAgnAgmtRtVOS[i]);
						if(!agtAgnAgmtRtVOS[i].getCntrInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getCntrInpTermCd().equals("*")){
							StringTokenizer cntrInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getCntrInpTermCd(), ",");
							String hasToString = null;
							while(cntrInpTermCdStoken01.hasMoreTokens()){
								hasToString = cntrInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("TPSZ");
								paramAgtAgnOtrRefVO.setOtrLvlCd("1");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}
						}
	//					insert Charge value into agt_agn_chg_ref table - 2
						if(!agtAgnAgmtRtVOS[i].getChgDdctInpCd().equals("") || !agtAgnAgmtRtVOS[i].getChgDdctInpCd().equals("*")){
							StringTokenizer chgDdctInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getChgDdctInpCd(), ",");
							String hasToString = null;
							while(chgDdctInpCdStoken01.hasMoreTokens()){
								hasToString = chgDdctInpCdStoken01.nextToken();
								paramAgtAgnChgRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnChgRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnChgRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnChgRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnChgRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnChgRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnChgRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnChgRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnChgRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnChgRefVO.setDdctRefDivCd("SCHG");
								paramAgtAgnChgRefVO.setDdctLvlCd("1");
								paramAgtAgnChgRefVO.setChgGrpTpCd(hasToString.substring(0, 1));
								paramAgtAgnChgRefVO.setChgCd(hasToString.substring(2, hasToString.length()));
								paramAgtAgnChgRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnChgRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnChgRef(paramAgtAgnChgRefVO);
							}
						}
//						insert Customer value into agt_agn_otr_ref table - 3
						if(!agtAgnAgmtRtVOS[i].getCustInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getCustInpTermCd().equals("*")){
							StringTokenizer custInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getCustInpTermCd(), ",");
							String hasToString = null;
							while(custInpTermCdStoken01.hasMoreTokens()){
								hasToString = custInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("CUST");
								paramAgtAgnOtrRefVO.setOtrLvlCd("2");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}
						}
//						insert S/C NO value into agt_agn_otr_ref table(sc_inp_term_cd) - 4
						if(!agtAgnAgmtRtVOS[i].getScInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getScInpTermCd().equals("*")){
							StringTokenizer  scInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getScInpTermCd(), ",");
							String hasToString = null;
							while(scInpTermCdStoken01.hasMoreTokens()){
								hasToString = scInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("SCNO");
								paramAgtAgnOtrRefVO.setOtrLvlCd("3");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}
						}
//						insert RFA NO value into agt_agn_otr_ref table(rfa_inp_term_cd) - 5
						if(!agtAgnAgmtRtVOS[i].getRfaInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getRfaInpTermCd().equals("*")){
							StringTokenizer  rfaInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getRfaInpTermCd(), ",");
							String hasToString = null;
							while(rfaInpTermCdStoken01.hasMoreTokens()){
								hasToString = rfaInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("RFAN");
								paramAgtAgnOtrRefVO.setOtrLvlCd("4");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}
						}
//						insert S/C OFC value into agt_agn_ctrt_ref table(sc_ofc_inp_cd) - 6
						if(!agtAgnAgmtRtVOS[i].getScOfcInpCd().equals("") || !agtAgnAgmtRtVOS[i].getScOfcInpCd().equals("*")){
							StringTokenizer  scOfcInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getScOfcInpCd(), ",");
							String hasToString = null;
							while(scOfcInpCdStoken01.hasMoreTokens()){
								hasToString = scOfcInpCdStoken01.nextToken();
								paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnCtrtRefVO.setScRfaFlg("Y");
								paramAgtAgnCtrtRefVO.setCtrtRefDivCd("SCOF");
								paramAgtAgnCtrtRefVO.setCtrtLvlCd("1");
								paramAgtAgnCtrtRefVO.setAgnCtrtOfcCd(hasToString);
								paramAgtAgnCtrtRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnCtrtRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
							}
						}
//						insert RFA OFC value into agt_agn_ctrt_ref table(rfa_ofc_inp_cd) - 7
						if(!agtAgnAgmtRtVOS[i].getRfaOfcInpCd().equals("") || !agtAgnAgmtRtVOS[i].getRfaOfcInpCd().equals("*")){
							StringTokenizer  rfaOfcInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getRfaOfcInpCd(), ",");
							String hasToString = null;
							while(rfaOfcInpCdStoken01.hasMoreTokens()){
								hasToString = rfaOfcInpCdStoken01.nextToken();
								paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnCtrtRefVO.setScRfaFlg("N");
								paramAgtAgnCtrtRefVO.setCtrtRefDivCd("RFAO");
								paramAgtAgnCtrtRefVO.setCtrtLvlCd("2");
								paramAgtAgnCtrtRefVO.setAgnCtrtOfcCd(hasToString);
								paramAgtAgnCtrtRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnCtrtRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
							}
						}
//						insert BKG OFC value into agt_agn_rout_ref table(bkg_ofc_inp_term_cd) - 8
						if(!agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd().equals("*")){
							StringTokenizer  bkgOfcInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd(), ",");
							String hasToString = null;
							while(bkgOfcInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgOfcInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("BKOF");
								paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert Sales OFC value into agt_agn_rout_ref table(sls_ofc_inp_term_cd) - 9
						if(!agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd().equals("*")){
							StringTokenizer  slsOfcInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd(), ",");
							String hasToString = null;
							while(slsOfcInpTermCdStoken01.hasMoreTokens()){
								hasToString = slsOfcInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("SAOF");
								paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert POR value into agt_agn_rout_ref table(bkg_por_inp_term_cd) - 10
						if(!agtAgnAgmtRtVOS[i].getBkgPorInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPorInpTermCd().equals("*")){
							StringTokenizer  bkgPorInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPorInpTermCd(), ",");
							String hasToString = null;
							while(bkgPorInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgPorInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("PORL");
								paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//					 	insert POL value into agt_agn_rout_ref table(bkg_pol_inp_term_cd) - 11
						if(!agtAgnAgmtRtVOS[i].getBkgPolInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPolInpTermCd().equals("*")){
							StringTokenizer  bkgPolInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPolInpTermCd(), ",");
							String hasToString = null;
							while(bkgPolInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgPolInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("POLL");
								paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert POD value into agt_agn_rout_ref table(bkg_pod_inp_term_cd) - 12
						if(!agtAgnAgmtRtVOS[i].getBkgPodInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPodInpTermCd().equals("*")){
							StringTokenizer  bkgPodInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPodInpTermCd(), ",");
							String hasToString = null;
							while(bkgPodInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgPodInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("PODL");
								paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
						log.info("\n 20");
						log.info("\n PODL2");
//						insert DEL value into agt_agn_rout_ref table(bkg_del_inp_term_cd) - 13
						if(!agtAgnAgmtRtVOS[i].getBkgDelInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgDelInpTermCd().equals("*")){
							StringTokenizer  bkgDelInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgDelInpTermCd(), ",");
							String hasToString = null;
							while(bkgDelInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgDelInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("DELL");
								paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert PPD value into agt_agn_rout_ref table(bkg_ppd_inp_term_cd) - 14
						if(!agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd().equals("*")){
							StringTokenizer  bkgPpdInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd(), ",");
							String hasToString = null;
							while(bkgPpdInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgPpdInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("PPDO");
								paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert CCT value into agt_agn_rout_ref table(bkg_clt_inp_term_cd) - 15
						if(!agtAgnAgmtRtVOS[i].getBkgCltInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgCltInpTermCd().equals("*")){
							StringTokenizer  bkgCltInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgCltInpTermCd(), ",");
							String hasToString = null;
							while(bkgCltInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgCltInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("CCTO");
								paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}							
						}
//						insert 3rd Party value into agt_agn_rout_ref table(bkg_n3rd_inp_term_cd) - 16
						if(!agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd().equals("*")){
							StringTokenizer  bkgN3rdInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd(), ",");
							String hasToString = null;
							while(bkgN3rdInpTermCdStoken01.hasMoreTokens()){
								hasToString = bkgN3rdInpTermCdStoken01.nextToken();
								paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramagAgtAgnRoutRefVO.setRoutRefDivCd("THRD");
								paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
								paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
								paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
							}
						}
//						insert Lane value into agt_agn_otr_ref table(lane_inp_term_cd) - 17
						if(!agtAgnAgmtRtVOS[i].getLaneInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getLaneInpTermCd().equals("S")){
							StringTokenizer  laneInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getLaneInpTermCd(), ",");
							String hasToString = null;
							while(laneInpTermCdStoken01.hasMoreTokens()){
								hasToString = laneInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("LANE");
								paramAgtAgnOtrRefVO.setOtrLvlCd("5");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}
						}
//						insert Vessel value into agt_agn_otr_ref table(vsl_inp_term_cd) - 18
						if(!agtAgnAgmtRtVOS[i].getVslInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getVslInpTermCd().equals("S")){
							StringTokenizer  vslInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getVslInpTermCd(), ",");
							String hasToString = null;
							while(vslInpTermCdStoken01.hasMoreTokens()){
								hasToString = vslInpTermCdStoken01.nextToken();
								paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
								paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
								paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
								paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
								paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
								paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
								paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
								paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
								paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
								paramAgtAgnOtrRefVO.setOtrRefDivCd("VSSL");
								paramAgtAgnOtrRefVO.setOtrLvlCd("6");
								paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
								paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
								paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
								dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
							}							
						}
					}
				}//End Insert
				
				if(agtAgnAgmtRtVOS[i].getIbflag().equals("U")){
//					deleting data of agt_agn_otr_ref table 
					paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					log.info("\n paramAgtAgnOtrRefVO="+paramAgtAgnOtrRefVO);
					dbDao.deletemultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
//					deleting data of agt_agn_ctrt_ref table
					paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					log.info("\n paramAgtAgnCtrtRefVO="+paramAgtAgnCtrtRefVO);
					dbDao.deletemultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
//					deleting data of agt_agn_chg_ref table
					paramAgtAgnChgRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnChgRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnChgRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnChgRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnChgRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnChgRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnChgRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnChgRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnChgRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					log.info("\n paramAgtAgnChgRefVO="+paramAgtAgnChgRefVO);
					dbDao.deletemultiRowCopySaveAgtAgnChgRef(paramAgtAgnChgRefVO);
//					deleting data of agt_agn_rout_ref table
					paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					log.info("\n paramagAgtAgnRoutRefVO="+paramagAgtAgnRoutRefVO.getAcTpCd());
					dbDao.deletemultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
					
//					updating data to agt_agn_agmt_rt table
					dbDao.modifymultiRowCopySaveAgtAgnAgmtRt(agtAgnAgmtRtVOS[i]);	
//					insert TP/SZ value into agt_agn_otr_ref table - 1
					if(!agtAgnAgmtRtVOS[i].getCntrInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getCntrInpTermCd().equals("*")){
						StringTokenizer cntrInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getCntrInpTermCd(), ",");
						String hasToString = null;
						while(cntrInpTermCdStoken01.hasMoreTokens()){
							hasToString = cntrInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("TPSZ");
							paramAgtAgnOtrRefVO.setOtrLvlCd("1");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}
					}
//					insert Charge value into agt_agn_chg_ref table - 2
					if(!agtAgnAgmtRtVOS[i].getChgDdctInpCd().equals("") || !agtAgnAgmtRtVOS[i].getChgDdctInpCd().equals("*")){
						StringTokenizer chgDdctInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getChgDdctInpCd(), ",");
						log.info("\n chgDdctInpCdStoken01="+chgDdctInpCdStoken01.toString());
						log.info("chgDdctInpCdStoken01.hasMoreTokens() = "+chgDdctInpCdStoken01.hasMoreTokens());
						String hasToString = null;
						while(chgDdctInpCdStoken01.hasMoreTokens()){
							hasToString = chgDdctInpCdStoken01.nextToken();
							log.info("\n hasToString="+hasToString);
							paramAgtAgnChgRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnChgRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnChgRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnChgRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnChgRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnChgRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnChgRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnChgRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnChgRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnChgRefVO.setDdctRefDivCd("SCHG");
							paramAgtAgnChgRefVO.setDdctLvlCd("1");
							paramAgtAgnChgRefVO.setChgGrpTpCd(hasToString.substring(0, 1));
							paramAgtAgnChgRefVO.setChgCd(hasToString.substring(2, hasToString.length()));
							paramAgtAgnChgRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnChgRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnChgRef(paramAgtAgnChgRefVO);
						}
					}
//					insert Customer value into agt_agn_otr_ref table - 3
					if(!agtAgnAgmtRtVOS[i].getCustInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getCustInpTermCd().equals("*")){
						StringTokenizer custInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getCustInpTermCd(), ",");
						String hasToString = null;
						while(custInpTermCdStoken01.hasMoreTokens()){
							hasToString = custInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("CUST");
							paramAgtAgnOtrRefVO.setOtrLvlCd("2");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}
					}
//					insert S/C NO value into agt_agn_otr_ref table(sc_inp_term_cd) - 4
					if(!agtAgnAgmtRtVOS[i].getScInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getScInpTermCd().equals("*")){
						StringTokenizer  scInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getScInpTermCd(), ",");
						String hasToString = null;
						while(scInpTermCdStoken01.hasMoreTokens()){
							hasToString = scInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("SCNO");
							paramAgtAgnOtrRefVO.setOtrLvlCd("3");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}
					}
//					insert RFA NO value into agt_agn_otr_ref table(rfa_inp_term_cd) - 5
					if(!agtAgnAgmtRtVOS[i].getRfaInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getRfaInpTermCd().equals("*")){
						StringTokenizer  rfaInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getRfaInpTermCd(), ",");
						String hasToString = null;
						while(rfaInpTermCdStoken01.hasMoreTokens()){
							hasToString = rfaInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("RFAN");
							paramAgtAgnOtrRefVO.setOtrLvlCd("4");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}
					}
//					insert S/C OFC value into agt_agn_ctrt_ref table(sc_ofc_inp_cd) - 6
					if(!agtAgnAgmtRtVOS[i].getScOfcInpCd().equals("") || !agtAgnAgmtRtVOS[i].getScOfcInpCd().equals("*")){
						StringTokenizer  scOfcInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getScOfcInpCd(), ",");
						String hasToString = null;
						while(scOfcInpCdStoken01.hasMoreTokens()){
							hasToString = scOfcInpCdStoken01.nextToken();
							paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnCtrtRefVO.setScRfaFlg("Y");
							paramAgtAgnCtrtRefVO.setCtrtRefDivCd("SCOF");
							paramAgtAgnCtrtRefVO.setCtrtLvlCd("1");
							paramAgtAgnCtrtRefVO.setAgnCtrtOfcCd(hasToString);
							paramAgtAgnCtrtRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnCtrtRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
						}
					}
//					insert RFA OFC value into agt_agn_ctrt_ref table(rfa_ofc_inp_cd) - 7
					if(!agtAgnAgmtRtVOS[i].getRfaOfcInpCd().equals("") || !agtAgnAgmtRtVOS[i].getRfaOfcInpCd().equals("*")){
						StringTokenizer  rfaOfcInpCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getRfaOfcInpCd(), ",");
						String hasToString = null;
						while(rfaOfcInpCdStoken01.hasMoreTokens()){
							hasToString = rfaOfcInpCdStoken01.nextToken();
							paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnCtrtRefVO.setScRfaFlg("N");
							paramAgtAgnCtrtRefVO.setCtrtRefDivCd("RFAO");
							paramAgtAgnCtrtRefVO.setCtrtLvlCd("2");
							paramAgtAgnCtrtRefVO.setAgnCtrtOfcCd(hasToString);
							paramAgtAgnCtrtRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnCtrtRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
						}
					}
//					insert BKG OFC value into agt_agn_rout_ref table(bkg_ofc_inp_term_cd) - 8
					if(!agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd().equals("*")){
						StringTokenizer  bkgOfcInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgOfcInpTermCd(), ",");
						String hasToString = null;
						while(bkgOfcInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgOfcInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("BKOF");
							paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert Sales OFC value into agt_agn_rout_ref table(sls_ofc_inp_term_cd) - 9
					if(!agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd().equals("*")){
						StringTokenizer  slsOfcInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getSlsOfcInpTermCd(), ",");
						String hasToString = null;
						while(slsOfcInpTermCdStoken01.hasMoreTokens()){
							hasToString = slsOfcInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("SAOF");
							paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert POR value into agt_agn_rout_ref table(bkg_por_inp_term_cd) - 10
					if(!agtAgnAgmtRtVOS[i].getBkgPorInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPorInpTermCd().equals("*")){
						StringTokenizer  bkgPorInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPorInpTermCd(), ",");
						String hasToString = null;
						while(bkgPorInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgPorInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("PORL");
							paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//				 	insert POL value into agt_agn_rout_ref table(bkg_pol_inp_term_cd) - 11
					if(!agtAgnAgmtRtVOS[i].getBkgPolInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPolInpTermCd().equals("*")){
						StringTokenizer  bkgPolInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPolInpTermCd(), ",");
						String hasToString = null;
						while(bkgPolInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgPolInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("POLL");
							paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert POD value into agt_agn_rout_ref table(bkg_pod_inp_term_cd) - 12
					if(!agtAgnAgmtRtVOS[i].getBkgPodInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPodInpTermCd().equals("*")){
						StringTokenizer  bkgPodInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPodInpTermCd(), ",");
						String hasToString = null;
						while(bkgPodInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgPodInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("PODL");
							paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert DEL value into agt_agn_rout_ref table(bkg_del_inp_term_cd) - 13
					if(!agtAgnAgmtRtVOS[i].getBkgDelInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgDelInpTermCd().equals("*")){
						StringTokenizer  bkgDelInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgDelInpTermCd(), ",");
						String hasToString = null;
						while(bkgDelInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgDelInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("DELL");
							paramagAgtAgnRoutRefVO.setRoutLvlCd(hasToString.substring(0, 1));
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString.substring(2, hasToString.length()));
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert PPD value into agt_agn_rout_ref table(bkg_ppd_inp_term_cd) - 14
					if(!agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd().equals("*")){
						StringTokenizer  bkgPpdInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgPpdInpTermCd(), ",");
						String hasToString = null;
						while(bkgPpdInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgPpdInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("PPDO");
							paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert CCT value into agt_agn_rout_ref table(bkg_clt_inp_term_cd) - 15
					if(!agtAgnAgmtRtVOS[i].getBkgCltInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgCltInpTermCd().equals("*")){
						StringTokenizer  bkgCltInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgCltInpTermCd(), ",");
						String hasToString = null;
						while(bkgCltInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgCltInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("CCTO");
							paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}							
					}
//					insert 3rd Party value into agt_agn_rout_ref table(bkg_n3rd_inp_term_cd) - 16
					if(!agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd().equals("*")){
						StringTokenizer  bkgN3rdInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getBkgN3rdInpTermCd(), ",");
						String hasToString = null;
						while(bkgN3rdInpTermCdStoken01.hasMoreTokens()){
							hasToString = bkgN3rdInpTermCdStoken01.nextToken();
							paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramagAgtAgnRoutRefVO.setRoutRefDivCd("THRD");
							paramagAgtAgnRoutRefVO.setRoutLvlCd("7");
							paramagAgtAgnRoutRefVO.setRoutInfoCd(hasToString);
							paramagAgtAgnRoutRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramagAgtAgnRoutRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
						}
					}
//					insert Lane value into agt_agn_otr_ref table(lane_inp_term_cd) - 17
					if(!agtAgnAgmtRtVOS[i].getLaneInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getLaneInpTermCd().equals("S")){
						StringTokenizer  laneInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getLaneInpTermCd(), ",");
						String hasToString = null;
						while(laneInpTermCdStoken01.hasMoreTokens()){
							hasToString = laneInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("LANE");
							paramAgtAgnOtrRefVO.setOtrLvlCd("5");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}
					}
//					insert Vessel value into agt_agn_otr_ref table(vsl_inp_term_cd) - 18
					if(!agtAgnAgmtRtVOS[i].getVslInpTermCd().equals("") || !agtAgnAgmtRtVOS[i].getVslInpTermCd().equals("S")){
						StringTokenizer  vslInpTermCdStoken01 = new StringTokenizer(agtAgnAgmtRtVOS[i].getVslInpTermCd(), ",");
						String hasToString = null;
						while(vslInpTermCdStoken01.hasMoreTokens()){
							hasToString = vslInpTermCdStoken01.nextToken();
							paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
							paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
							paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
							paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
							paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
							paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
							paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
							paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
							paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
							paramAgtAgnOtrRefVO.setOtrRefDivCd("VSSL");
							paramAgtAgnOtrRefVO.setOtrLvlCd("6");
							paramAgtAgnOtrRefVO.setOtrInfoNo(hasToString);
							paramAgtAgnOtrRefVO.setCreUsrId(agtAgnAgmtRtVOS[i].getCreUsrId());
							paramAgtAgnOtrRefVO.setUpdUsrId(agtAgnAgmtRtVOS[i].getUpdUsrId());
							dbDao.addmultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
						}							
					}
				}//End Update
				if(agtAgnAgmtRtVOS[i].getIbflag().equals("D")){
//					deleting data of agt_agn_otr_ref table
					paramAgtAgnOtrRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnOtrRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnOtrRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnOtrRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnOtrRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnOtrRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnOtrRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnOtrRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnOtrRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					dbDao.deletemultiRowCopySaveAgtAgnOtrRef(paramAgtAgnOtrRefVO);
//					deleting data of agt_agn_ctrt_ref table
					paramAgtAgnCtrtRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnCtrtRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnCtrtRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnCtrtRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnCtrtRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnCtrtRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnCtrtRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnCtrtRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnCtrtRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					dbDao.deletemultiRowCopySaveAgtAgnCtrtRef(paramAgtAgnCtrtRefVO);
//					deleting data of agt_agn_chg_ref table
					paramAgtAgnChgRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramAgtAgnChgRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramAgtAgnChgRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramAgtAgnChgRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramAgtAgnChgRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramAgtAgnChgRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramAgtAgnChgRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramAgtAgnChgRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramAgtAgnChgRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					dbDao.deletemultiRowCopySaveAgtAgnChgRef(paramAgtAgnChgRefVO);
//					deleting data of agt_agn_rout_ref table
					paramagAgtAgnRoutRefVO.setAgmtOfcCd(agtAgnAgmtRtVOS[i].getAgmtOfcCd());
					paramagAgtAgnRoutRefVO.setAgmtOfcCtyCd(agtAgnAgmtRtVOS[i].getAgmtOfcCtyCd());
					paramagAgtAgnRoutRefVO.setAgnAgmtSeq(agtAgnAgmtRtVOS[i].getAgnAgmtSeq());
					paramagAgtAgnRoutRefVO.setVndrCntCd(agtAgnAgmtRtVOS[i].getVndrCntCd());
					paramagAgtAgnRoutRefVO.setVndrSeq(agtAgnAgmtRtVOS[i].getVndrSeq());
					paramagAgtAgnRoutRefVO.setAgnAgmtVerSeq(agtAgnAgmtRtVOS[i].getAgnAgmtVerSeq());
					paramagAgtAgnRoutRefVO.setIoBndCd(agtAgnAgmtRtVOS[i].getIoBndCd());
					paramagAgtAgnRoutRefVO.setAcTpCd(agtAgnAgmtRtVOS[i].getAcTpCd());
					paramagAgtAgnRoutRefVO.setAgnSeq(agtAgnAgmtRtVOS[i].getAgnSeq());
					dbDao.deletemultiRowCopySaveAgtAgnRoutRef(paramagAgtAgnRoutRefVO);
//					deleting data of agt_agn_agmt_rt table
					dbDao.deletemultiRowCopySaveAgtAgnAgmtRt(agtAgnAgmtRtVOS[i]);
				}
			}						
		}catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
    }

	/**
	 * ESM_AGT_004 retrieve event process<br>
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List[]
	 * @exception EventException
	 */
	public List[] searchOtherInfoList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException {
		List[] voList = new ArrayList[3];
		try {
			voList[0] = dbDao.searchOtherInfoListRepSize(agtCntrTypeSizeVO);
			voList[1] = dbDao.searchOtherInfoListRepType(agtCntrTypeSizeVO);
			voList[2] = dbDao.searchOtherInfoListTypeSize(agtCntrTypeSizeVO);
			return voList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * ESM_AGT_004 retrieve event process<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchOtherInfoSearchList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException {
		try {
			return dbDao.searchOtherInfoSearchList(agtCntrTypeSizeVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESM_AGT_0005 retrieve event process<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List[]
	 * @exception EventException
	 */
	public List[] searchDeductionInfoList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException {
		List[] voList = new ArrayList[2];
		try {
			voList[0] = dbDao.searchDeductionInfoList(agtChargeDeductionVO);
			voList[1] = dbDao.searchDeductionInfoDetailList(agtChargeDeductionVO);
			return voList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * ESM_AGT_0005 retrieve event process<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @exception EventException
	 */
	public List<AgtChargeDeductionVO> searchDeductionInfoChkDetailChkList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException {
		try {
			return dbDao.searchDeductionInfoChkDetailChkList(agtChargeDeductionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException {
		try {
			return dbDao.searchGeogOfcInfoContiList(agtGeogOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoSubContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException {
		try {
			return dbDao.searchGeogOfcInfoSubContiList(agtGeogOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoCntryList(AgtGeogOfcVO agtGeogOfcVO) throws EventException {
		try {
			return dbDao.searchGeogOfcInfoCntryList(agtGeogOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoLocList(AgtGeogOfcVO agtGeogOfcVO) throws EventException {
		try {
			return dbDao.searchGeogOfcInfoLocList(agtGeogOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoOfcList(AgtGeogOfcVO agtGeogOfcVO) throws EventException {
		try {
			return dbDao.searchGeogOfcInfoOfcList(agtGeogOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0006 retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> checkAgreementOffice(AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException {
		try {
			List<AgtAgnAgmtVO> selectList = new ArrayList<AgtAgnAgmtVO>();
			agtAgnAgmtVO.setUsrOfcCd(account.getOfc_cd());
			selectList = dbDao.checkAgreementOffice(agtAgnAgmtVO, account);
			if(selectList.size() <= 0){
				// AGT00078 : You are out of authority for this Office.
            	throw new DAOException(new ErrorHandler("AGT00078").getUserMessage());
			}			
			return selectList;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	/**
	 * ESM_AGT_0037 agt_agn_otr_ref retrieve event process<br>
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @param int gbn
	 * @return List<AgtAgnOtrRefVO>
	 * @exception EventException
	 */
	public List<AgtAgnOtrRefVO> searchOtherInfoListInput(AgtAgnOtrRefVO agtAgnOtrRefVO, int gbn)
			throws EventException {
		try{
			agtAgnOtrRefVO.setGubunValue(Integer.toString(gbn));
			return dbDao.searchOtherInfoListInputAgtAgnOtrRef(agtAgnOtrRefVO);
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * ESM_AGT_0037 agt_agn_cntr_ref retrieve event process<br>
	 * @param AgtAgnCtrtRefVO agtAgnCtrtRefVO
	 * @param int gbn
	 * @return List<AgtAgnCtrtRefVO>
	 * @exception EventException
	 */
    public List<AgtAgnCtrtRefVO> searchOtherInfoListInput2(AgtAgnCtrtRefVO agtAgnCtrtRefVO, int gbn) throws EventException {
		try{
			agtAgnCtrtRefVO.setGubunValue(Integer.toString(gbn));
			return dbDao.searchOtherInfoListInputAgtAgnCtrtRef(agtAgnCtrtRefVO);
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    
	/**
	 * ESM_AGT_0101 retrieve event process<br>
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List[]
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchRepCntrList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException {
		List[] voList = new ArrayList[3];
		try {
			return	dbDao.searchOtherInfoListRepType(agtCntrTypeSizeVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

}