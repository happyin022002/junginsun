/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfacedCancelBCImpl.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.integration.InterfacedCancelDBDAO;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -CandidateManage Business Logic Basic Command implementation<br>
 * - -CandidateManage Business Logic Interface<br>
 *
 * @author 
 * @see ESD_TPB_0133EventResponse,InterfacedCancelBC DAO class reference
 * @since J2EE 1.6
 */
public class InterfacedCancelBCImpl extends BasicCommandSupport implements InterfacedCancelBC {

	// Database Access Object
	private transient InterfacedCancelDBDAO dbDao = null;

	/**
	 * InterfacedCancelBCImpl object creation<br>
	 * InterfacedCancelDBDAO creation<br>
	 */
	public InterfacedCancelBCImpl() {
		dbDao = new InterfacedCancelDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchInterfacedCancelListVO searchInterfacedCancelListVO
	 * @return List<SearchInterfacedCancelListVO>
	 * @exception EventException
	 */
	public List<SearchInterfacedCancelListVO> searchCanceledTPB(SearchInterfacedCancelListVO searchInterfacedCancelListVO) throws EventException {
		try {
			return dbDao.searchCanceledTPB(searchInterfacedCancelListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchInterfacedCancelListVO[] SearchInterfacedCancelListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void interfacedTPBCancel(SearchInterfacedCancelListVO[] searchInterfacedCancelListVO, SignOnUserAccount account) throws EventException{
		SearchInterfacedCancelListVO fIcVO = searchInterfacedCancelListVO[0];
		
		if(searchInterfacedCancelListVO.length > 1){
			
			//ibFlag,ifAmt,eqTpCd,eqNo,eqTpszCd;
			for (int i = 1; i < searchInterfacedCancelListVO.length; i++) {
				SearchInterfacedCancelListVO dIcVO = searchInterfacedCancelListVO[i];
				
				searchInterfacedCancelListVO[i].setSUsrOfcCd(fIcVO.getSUsrOfcCd());
				searchInterfacedCancelListVO[i].setOfcCd(dIcVO.getOfcCd());
				searchInterfacedCancelListVO[i].setCxlSeq(dIcVO.getCxlSeq());
				searchInterfacedCancelListVO[i].setOrgSeq(dIcVO.getOrgSeq());
				searchInterfacedCancelListVO[i].setSIsNoticeOnly(fIcVO.getSIsNoticeOnly());
			}
		}
		
		try {
			List<SearchInterfacedCancelListVO> insertVoList = new ArrayList<SearchInterfacedCancelListVO>();
			List<SearchInterfacedCancelListVO> updateVoList = new ArrayList<SearchInterfacedCancelListVO>();
			List<SearchInterfacedCancelListVO> deleteVoList = new ArrayList<SearchInterfacedCancelListVO>();
			
			for ( int i=0; i<searchInterfacedCancelListVO .length; i++ ) {
				if ( searchInterfacedCancelListVO[i].getIbflag().equals("I")){
					insertVoList.add(searchInterfacedCancelListVO[i]);
				} else if ( searchInterfacedCancelListVO[i].getIbflag().equals("U")){
					searchInterfacedCancelListVO[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(searchInterfacedCancelListVO[i]);
				} else if ( searchInterfacedCancelListVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchInterfacedCancelListVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.removeInterfacedTPBCancel(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
}