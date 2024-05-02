/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmBCImpl.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.integration.JOCandidateConfirmDBDAO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JOCaseManage Business Logic Basic Command implementation<br>
 * - ALPS-JOCaseManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jong-Geon Byeon
 * @see ESD_TPB_0105EventResponse,JOCandidateConfirmBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JOCandidateConfirmBCImpl extends BasicCommandSupport implements JOCandidateConfirmBC {

	// Database Access Object
	private transient JOCandidateConfirmDBDAO dbDao = null;

	/**
	 * JOCandidateConfirmBCImpl 객체 생성<br>
	 * JOCandidateConfirmDBDAO를 생성한다.<br>
	 */
	public JOCandidateConfirmBCImpl() {
		dbDao = new JOCandidateConfirmDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOCandidateConfirmListVO SearchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> searchCandidateList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws EventException {
		try {
			return dbDao.searchCandidateList(searchJOCandidateConfirmListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOCandidateConfirmListVO[] multiCandidateListVO
	 * @param account SignOnUserAccount
	 * @return 
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> multiCandidateConfirm(SearchJOCandidateConfirmListVO[] multiCandidateListVO, SignOnUserAccount account) throws EventException{
		try {
			//Third Party 유효성 체크
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
			if(multiCandidateListVO.length>0){
				otsDtlSeqTmp = "'";
				for ( int i=0; i<multiCandidateListVO.length - 1; i++ ) {
					otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[i].getOtsDtlSeq()+"','";
				}
				otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[multiCandidateListVO.length-1].getOtsDtlSeq()+"'";
			}
			multiCandidateListVO[0].setInOtsDtlSeq(otsDtlSeqTmp);
			int j = 0;
			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				
				multiCandidateListVO[i].setUserId(account.getUsr_id());
				multiCandidateListVO[i].setUserOfcCd(account.getOfc_cd());
				//multiCandidateListVO[i].setUserEmail(account.getUsr_eml());
				//multiCandidateListVO[i].setUserName(account.getUsr_nm());
				
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
				}	
				multiCandidateListVO[i].setCfm(cfm);
			}
			
			List<SearchJOCandidateConfirmListVO> updateVoList = new ArrayList<SearchJOCandidateConfirmListVO>();
			List<SearchJOCandidateConfirmListVO> gUpdateVoList = new ArrayList<SearchJOCandidateConfirmListVO>();

			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				if ( multiCandidateListVO[i].getIbflag().equals("U") && !multiCandidateListVO[i].getCfm().equals("G")){
					updateVoList.add(multiCandidateListVO[i]);
				} else if ( multiCandidateListVO[i].getIbflag().equals("U") && multiCandidateListVO[i].getCfm().equals("G")){
					gUpdateVoList.add(multiCandidateListVO[i]);
				}
			}
			
			for ( int i=0; i<gUpdateVoList.size(); i++ ) {
				updateVoList.add(gUpdateVoList.get(i));
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCandidateConfirm(updateVoList);
				return this.dbDao.searchUpdatedList(multiCandidateListVO[0]);
			}
			
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