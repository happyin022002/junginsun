/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateConfirmBCImpl.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration.CandidateConfirmDBDAO;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -CandidateManage Business Logic Basic Command implementation<br>
 * - CandidateManage business logic interface<br>
 *
 * @author
 * @see ESD_TPB_1050EventResponse,CandidateConfirmBC DAO class reference
 * @since J2EE 1.6
 */
public class CandidateConfirmBCImpl extends BasicCommandSupport implements CandidateConfirmBC {

	// Database Access Object
	private transient CandidateConfirmDBDAO dbDao = null;

	/**
	 * CandidateConfirmBCImpl object creation<br>
	 * CandidateConfirmDBDAO creation<br>
	 */
	public CandidateConfirmBCImpl() {
		dbDao = new CandidateConfirmDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchCandidateListVO searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> searchCandidateList(SearchCandidateListVO searchCandidateListVO) throws EventException {
		try {
			return dbDao.searchCandidateList(searchCandidateListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchCandidateListVO searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> searchUpdatedList(SearchCandidateListVO searchCandidateListVO) throws EventException {
		try {
			return dbDao.searchUpdatedList(searchCandidateListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 
	 * @param SearchCandidateListVO[] multiCandidateListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> multiCandidateConfirm(SearchCandidateListVO[] multiCandidateListVO, SignOnUserAccount account) throws EventException{

		try {
			//checking Third Party
			String validYn = null;
			String cfmI = null;
			String cfmG = null;
			for ( int idx=0; idx<multiCandidateListVO.length; idx++ )
			{
				validYn = dbDao.chkTrdPartyVal(multiCandidateListVO[idx]);
				cfmI = multiCandidateListVO[idx].getCfmI();
				cfmG = multiCandidateListVO[idx].getCfmG();
				
				if ( !validYn.equals("Y") && ( cfmI.equals("1") || cfmG.equals("1") ) )
				{
					throw new EventException(new ErrorHandler("TPB00051").getMessage());
				}
			}
			
			
			String otsDtlSeqTmp = "";
			String cfm = "";
			StringBuffer otsDtlSeqTmpBuf = new StringBuffer();
			
			if(multiCandidateListVO.length>0){
//				otsDtlSeqTmp = "'";
				otsDtlSeqTmpBuf.append("'");
				for ( int i=0; i<multiCandidateListVO.length - 1; i++ ) {
//					otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[i].getOtsDtlSeq()+"','";
					otsDtlSeqTmpBuf.append(multiCandidateListVO[i].getOtsDtlSeq()).append("','");
				}
//				otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[multiCandidateListVO.length-1].getOtsDtlSeq()+"'";
				otsDtlSeqTmpBuf.append(multiCandidateListVO[multiCandidateListVO.length-1].getOtsDtlSeq()).append("'");
			}
			otsDtlSeqTmp = otsDtlSeqTmpBuf.toString();
			multiCandidateListVO[0].setInOtsDtlSeq(otsDtlSeqTmp);
			int j = 0;
			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				
				multiCandidateListVO[i].setUserId(account.getUsr_id());
				multiCandidateListVO[i].setUserOfcCd(account.getOfc_cd());
				multiCandidateListVO[i].setUserEmail(account.getUsr_eml());
				multiCandidateListVO[i].setUserName(account.getUsr_nm());
				
				if(multiCandidateListVO[i].getCfmI().equals("1")){
					cfm = "I";
				}else if(multiCandidateListVO[i].getCfmG().equals("1")){
					cfm = "G";
					multiCandidateListVO[i].setCurrN3ptyNo(Integer.toString(j++));
				}else if(multiCandidateListVO[i].getCfmN().equals("1")){
					cfm = "N";
				}else if(multiCandidateListVO[i].getCfmR().equals("1")){
					cfm = "R";
				}else if(multiCandidateListVO[i].getCfmD().equals("1")){
					cfm = "D";
				}else if(multiCandidateListVO[i].getCfmC().equals("1")){
					cfm = "C";
				}	
				multiCandidateListVO[i].setCfm(cfm);
			}
			
			List<SearchCandidateListVO> updateVoList = new ArrayList<SearchCandidateListVO>();
			List<SearchCandidateListVO> gUpdateVoList = new ArrayList<SearchCandidateListVO>();
			List<SearchCandidateListVO> cUpdateVoList = new ArrayList<SearchCandidateListVO>();

			//Group Confirm target in the collecting gUpdateVoList. adding logic after sorting and put on VO
			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				if ( multiCandidateListVO[i].getIbflag().equals("U") && !multiCandidateListVO[i].getCfm().equals("G")&& !multiCandidateListVO[i].getCfm().equals("C")){
					updateVoList.add(multiCandidateListVO[i]);
				} else if ( multiCandidateListVO[i].getIbflag().equals("U") && multiCandidateListVO[i].getCfm().equals("G")){
					gUpdateVoList.add(multiCandidateListVO[i]);
				} else if ( multiCandidateListVO[i].getIbflag().equals("U") && multiCandidateListVO[i].getCfm().equals("C")){
					cUpdateVoList.add(multiCandidateListVO[i]);
				}
			}
			
			for ( int i=0; i<gUpdateVoList.size(); i++ ) {
				updateVoList.add(gUpdateVoList.get(i));
			}
			
			boolean rtv = false;
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCandidateList(updateVoList);
				rtv = true;
			}
			
			if ( cUpdateVoList.size() > 0){
				dbDao.modifyCandidateCancelList(cUpdateVoList);
				rtv = true;
			}
			
			if(rtv)
				return this.dbDao.searchUpdatedList(multiCandidateListVO[0]);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	
	}
	
}