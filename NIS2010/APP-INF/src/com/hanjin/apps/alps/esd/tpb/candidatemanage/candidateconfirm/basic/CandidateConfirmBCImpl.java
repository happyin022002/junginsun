/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateConfirmBCImpl.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.11 변종건 [CHM-201006390-01] [TPB] Candidate Confirmation Grouping 기능 보완
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.integration.CandidateConfirmDBDAO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchNonTPBDescVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CandidateManage Business Logic Basic Command implementation<br>
 * - ALPS-CandidateManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_1050EventResponse,CandidateConfirmBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CandidateConfirmBCImpl extends BasicCommandSupport implements CandidateConfirmBC {

	// Database Access Object
	private transient CandidateConfirmDBDAO dbDao = null;

	/**
	 * CandidateConfirmBCImpl 객체 생성<br>
	 * CandidateConfirmDBDAO를 생성한다.<br>
	 */
	public CandidateConfirmBCImpl() {
		dbDao = new CandidateConfirmDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO[] multiCandidateListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> multiCandidateConfirm(SearchCandidateListVO[] multiCandidateListVO, SignOnUserAccount account) throws EventException{

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
			
			
			//String otsDtlSeqTmp = "";
			StringBuffer otsDtlSeqTmp = new StringBuffer();
			String cfm = "";
			if(multiCandidateListVO.length>0){
				//otsDtlSeqTmp = "'";
				otsDtlSeqTmp.append("'");
				for ( int i=0; i<multiCandidateListVO.length - 1; i++ ) {
					//otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[i].getOtsDtlSeq()+"','";
					otsDtlSeqTmp.append(multiCandidateListVO[i].getOtsDtlSeq());
					otsDtlSeqTmp.append("','");
				}
				//otsDtlSeqTmp = otsDtlSeqTmp + multiCandidateListVO[multiCandidateListVO.length-1].getOtsDtlSeq()+"'";
				otsDtlSeqTmp.append(multiCandidateListVO[multiCandidateListVO.length-1].getOtsDtlSeq());
				otsDtlSeqTmp.append("'");
			}
			multiCandidateListVO[0].setInOtsDtlSeq(otsDtlSeqTmp.toString());
			int j = 0;
			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				
				multiCandidateListVO[i].setUserId(account.getUsr_id());
//				multiCandidateListVO[i].setUserOfcCd(account.getOfc_cd());
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
				}	
				multiCandidateListVO[i].setCfm(cfm);
			}
			
			List<SearchCandidateListVO> updateVoList = new ArrayList<SearchCandidateListVO>();
			List<SearchCandidateListVO> gUpdateVoList = new ArrayList<SearchCandidateListVO>(); //2010.10.11 변종건 [CHM-201006390-01] [TPB] Candidate Confirmation Grouping 기능 보완

			//Group Confirm 건은 gUpdateVoList에 모아서 정렬 후 다시 VO에 담는 로직 추가(MIX 버그 보완)
			for ( int i=0; i<multiCandidateListVO .length; i++ ) {
				if ( multiCandidateListVO[i].getIbflag().equals("U") && !multiCandidateListVO[i].getCfm().equals("G")){
					updateVoList.add(multiCandidateListVO[i]);
				} else if ( multiCandidateListVO[i].getIbflag().equals("U") && multiCandidateListVO[i].getCfm().equals("G")){
					gUpdateVoList.add(multiCandidateListVO[i]);
				}
			}
			
			//2010.10.11 변종건 [CHM-201006390-01] [TPB] Candidate Confirmation Grouping 기능 보완
			for ( int i=0; i<gUpdateVoList.size(); i++ ) {
				updateVoList.add(gUpdateVoList.get(i));
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCandidateList(updateVoList);
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
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO[] multiCandidateListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNonTPBCfmDt(SearchCandidateListVO[] multiCandidateListVO, SignOnUserAccount account) throws EventException{
		try{
			List<SearchCandidateListVO> updateVoList = new ArrayList<SearchCandidateListVO>();
			
			for(int i=0; i<multiCandidateListVO.length; i++){
				if(multiCandidateListVO[i].getCfmN().equals("1") && !multiCandidateListVO[i].getN3ptyNonCfmRsnCd().equals("") && multiCandidateListVO[i].getNonCfmRsnFlg().equals("Y")){
					multiCandidateListVO[i].setUserId(account.getUsr_id());
					updateVoList.add(multiCandidateListVO[i]);
				}
			}
			
			if(updateVoList.size() > 0){
				dbDao.updateNonTPBDCfmDt(updateVoList);
		}
					
	}
	catch(DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    }

	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNonTPBDescVO searchNonTPBDescVO
	 * @return List<SearchNonTPBDescVO>
	 * @exception EventException
	 */
	public List<SearchNonTPBDescVO> searchNonTPBDesc(SearchNonTPBDescVO searchNonTPBDescVO) throws EventException {
		try {
			// 2011.11.15 박찬민 [CHM-201114303] [TPB] Non-TPB Candidate Remark 란 추가 요청
			return dbDao.searchNonTPBDesc(searchNonTPBDescVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNonTPBDescVO[] searchNonTPBDescVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNonTPBDesc(SearchNonTPBDescVO[] searchNonTPBDescVOS, SignOnUserAccount account) throws EventException {
		try{
			// 2011.11.15 박찬민 [CHM-201114303] [TPB] Non-TPB Candidate Remark 란 추가 요청
			List<SearchNonTPBDescVO> insertVoList = new ArrayList<SearchNonTPBDescVO>();
			
			for(int i=0; i<searchNonTPBDescVOS.length; i++){
				if(searchNonTPBDescVOS[i].getIbflag().equals("I")){
					searchNonTPBDescVOS[i].setUserId(account.getUsr_id());
					insertVoList.add(searchNonTPBDescVOS[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addNonTPBDesc(insertVoList);
		}
					
	}
	catch(DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    }
}
	
}