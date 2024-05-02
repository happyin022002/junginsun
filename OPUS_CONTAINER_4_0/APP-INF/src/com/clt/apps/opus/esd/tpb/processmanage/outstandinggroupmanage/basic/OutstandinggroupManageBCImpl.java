/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutstandinggroupManageBCImpl.java
*@FileTitle : OutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.integration.OutstandinggroupManageDBDAO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBModificationVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -OutstandinggroupManage Business Logic Basic Command implementation<br>
 * - -OutstandinggroupManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse,OutstandinggroupManageBC DAO class reference
 * @since J2EE 1.6
 */
public class OutstandinggroupManageBCImpl extends BasicCommandSupport implements OutstandinggroupManageBC {

	// Database Access Object
	private transient OutstandinggroupManageDBDAO dbDao = null;

	/**
	 * OutstandinggroupManageBCImpl object creation<br>
	 * OutstandinggroupManageDBDAO creation<br>
	 */
	public OutstandinggroupManageBCImpl() {
		dbDao = new OutstandinggroupManageDBDAO();
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupRemakingVO searchTPBGroupRemakingVO
	 * @return List<SearchTPBGroupRemakingVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupRemakingVO> searchTPBGroupRemaking(SearchTPBGroupRemakingVO searchTPBGroupRemakingVO) throws EventException {
		try {
//			SearchTPBGroupRemakingVO sTrVO = searchTPBGroupRemakingVO;

//			String candidate_yn = sTrVO.getCandidateYn();
//			log.debug("candidate_yn=====> " + candidate_yn);
			return dbDao.searchTPBGroupRemaking(searchTPBGroupRemakingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 
	 * @param SearchTPBModificationVO searchTPBModificationVO
	 * @return List<SearchTPBModificationVO>
	 * @exception EventException
	 */
	public List<SearchTPBModificationVO> searchTPBModification(SearchTPBModificationVO searchTPBModificationVO) throws EventException {
		try {			
			return dbDao.searchTPBModification(searchTPBModificationVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBGroupRemaking(ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO, SignOnUserAccount account) throws EventException{
		try {
			List<ModifyTPBGroupRemakingVO> insertVoList = new ArrayList<ModifyTPBGroupRemakingVO>();
			List<ModifyTPBGroupRemakingVO> updateVoList = new ArrayList<ModifyTPBGroupRemakingVO>();
			List<ModifyTPBGroupRemakingVO> deleteVoList = new ArrayList<ModifyTPBGroupRemakingVO>();
//			ModifyTPBGroupRemakingVO mTrVO = modifyTPBGroupRemakingVO[0];
//			String s_ib_flag = mTrVO.getIbflag();
//			String s_n3pty_no_org = mTrVO.getN3ptyNoOrg();
//			String s_ots_dtl_seq = mTrVO.getOtsDtlSeq();
//			String s_user_id = mTrVO.getSUserId();
//			String s_user_ofc_cd = mTrVO.getSUserOfcCd();
//			
//			log.debug("s_ib_flag=========> " + s_ib_flag);
//			log.debug("s_n3pty_no========> " + s_n3pty_no_org);
//			log.debug("s_ots_dtl_seq=====> " + s_ots_dtl_seq);
//			log.debug("s_user_id=========> " + s_user_id);
//			log.debug("s_user_ofc_cd=====> " + s_user_ofc_cd);
			
			for ( int i=0; i<modifyTPBGroupRemakingVO .length; i++ ) {
				if ( modifyTPBGroupRemakingVO[i].getIbflag().equals("I")){
					modifyTPBGroupRemakingVO[i].setSUserId(account.getUsr_id());
					insertVoList.add(modifyTPBGroupRemakingVO[i]);
				} else if ( modifyTPBGroupRemakingVO[i].getIbflag().equals("U")){
					modifyTPBGroupRemakingVO[i].setSUserId(account.getUsr_id());
					updateVoList.add(modifyTPBGroupRemakingVO[i]);
				} else if ( modifyTPBGroupRemakingVO[i].getIbflag().equals("D")){
					deleteVoList.add(modifyTPBGroupRemakingVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addTPBGroupRemaking(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTPBGroupRemaking(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTPBGroupRemaking(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param ModifyTPBModificationVO[] modifyTPBModificationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBModification(ModifyTPBModificationVO[] modifyTPBModificationVO, SignOnUserAccount account) throws EventException{
		try {
			List<ModifyTPBModificationVO> insertVoList = new ArrayList<ModifyTPBModificationVO>();
			List<ModifyTPBModificationVO> updateVoList = new ArrayList<ModifyTPBModificationVO>();
			List<ModifyTPBModificationVO> deleteVoList = new ArrayList<ModifyTPBModificationVO>();
//			ModifyTPBModificationVO mTmVO = modifyTPBModificationVO[0];
//			String ots_dtl_seq = mTmVO.getOtsDtlSeq();
//			String n3pty_no = mTmVO.getN3ptyNo();
//			String n3pty_no_dp_seq = mTmVO.getN3ptyNoDpSeq();
//			String s_user_ofc_cd = mTmVO.getSUserOfcCd();
//			String s_user_id = mTmVO.getSUserId();
//			String eq_no = mTmVO.getEqNo();
//			String bkg_no_all = mTmVO.getBkgNoAll();
//			String bl_no_all = mTmVO.getBlNoAll();
//			String vsl_cd = mTmVO.getVslCd();
//			String skd_voy_no = mTmVO.getSkdVoyNo();
//			String finc_dir_cd = mTmVO.getFincDirCd();
//			String vvd_cd = mTmVO.getVvdCd();
//			String vndr_cust_div_cd = mTmVO.getVndrCustDivCd();
//			String vndr_seq = mTmVO.getVndrSeq();
//			String cust_cnt_cd = mTmVO.getCustCntCd();
//			String cust_seq = mTmVO.getCustSeq();
//			String n3pty_ofc_cd = mTmVO.getN3ptyOfcCd();
//
//			log.debug("ots_dtl_seq=========> " + ots_dtl_seq);
//			log.debug("n3pty_no============> " + n3pty_no);
//			log.debug("n3pty_no_dp_seq=====> " + n3pty_no_dp_seq);
//			log.debug("s_user_ofc_cd=======> " + s_user_ofc_cd);
//			log.debug("s_user_id===========> " + s_user_id);
//			log.debug("eq_no===============> " + eq_no);
//			log.debug("bkg_no_all==========> " + bkg_no_all);
//			log.debug("bl_no_all===========> " + bl_no_all);
//			log.debug("vsl_cd==============> " + vsl_cd);
//			log.debug("skd_voy_no==========> " + skd_voy_no);
//			log.debug("finc_dir_cd=========> " + finc_dir_cd);
//			log.debug("vvd_cd==============> " + vvd_cd);
//			log.debug("vndr_cust_div_cd====> " + vndr_cust_div_cd);
//			log.debug("vndr_seq============> " + vndr_seq);
//			log.debug("cust_cnt_cd=========> " + cust_cnt_cd);
//			log.debug("cust_seq============> " + cust_seq);
//			log.debug("n3pty_ofc_cd========> " + n3pty_ofc_cd);

			for ( int i=0; i<modifyTPBModificationVO .length; i++ ) {
				if ( modifyTPBModificationVO[i].getIbflag().equals("I")){
					modifyTPBModificationVO[i].setSUserId(account.getUsr_id());
					insertVoList.add(modifyTPBModificationVO[i]);
				} else if ( modifyTPBModificationVO[i].getIbflag().equals("U")){
					modifyTPBModificationVO[i].setSUserId(account.getUsr_id());
					updateVoList.add(modifyTPBModificationVO[i]);
				} else if ( modifyTPBModificationVO[i].getIbflag().equals("D")){
					deleteVoList.add(modifyTPBModificationVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addTPBModification(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTPBModification(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTPBModification(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}