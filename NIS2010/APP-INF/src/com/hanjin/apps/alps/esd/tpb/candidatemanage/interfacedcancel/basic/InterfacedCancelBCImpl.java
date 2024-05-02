/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfacedCancelBCImpl.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009-04-01 O Wan-Ki 			1.0	최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.integration.InterfacedCancelDBDAO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CandidateManage Business Logic Basic Command implementation<br>
 * - ALPS-CandidateManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0133EventResponse,InterfacedCancelBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InterfacedCancelBCImpl extends BasicCommandSupport implements InterfacedCancelBC {

	// Database Access Object
	private transient InterfacedCancelDBDAO dbDao = null;

	/**
	 * InterfacedCancelBCImpl 객체 생성<br>
	 * InterfacedCancelDBDAO를 생성한다.<br>
	 */
	public InterfacedCancelBCImpl() {
		dbDao = new InterfacedCancelDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInterfacedCancelListVO[] SearchInterfacedCancelListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void interfacedTPBCancel(SearchInterfacedCancelListVO[] searchInterfacedCancelListVO, SignOnUserAccount account) throws EventException{
		SearchInterfacedCancelListVO fIcVO = searchInterfacedCancelListVO[0];
		
		if(searchInterfacedCancelListVO.length > 1){
			
			//ibFlag,ifAmt,eqTpCd,eqNo,eqTpszCd; // 제외
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