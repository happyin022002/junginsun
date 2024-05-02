/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InitialSpaceAllocationRatioBCImpl.java
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration.InitialSpaceAllocationRatioDBDAO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcInitAlocRtoVO;

/**
 * ALPS-BasicDataManage Business Logic Basic Command implementation<br>
 * - ALPS-BasicDataManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0004EventResponse,InitialSpaceAllocationRatioBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InitialSpaceAllocationRatioBCImpl extends BasicCommandSupport implements InitialSpaceAllocationRatioBC {

	// Database Access Object
	private transient InitialSpaceAllocationRatioDBDAO dbDao = null;

	/**
	 * InitialSpaceAllocationRatioBCImpl 객체 생성<br>
	 * InitialSpaceAllocationRatioDBDAO를 생성한다.<br>
	 */
	public InitialSpaceAllocationRatioBCImpl() {
		dbDao = new InitialSpaceAllocationRatioDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO
	 * @return List<SearchInitialSpaceAllocationRatioListVO>
	 * @exception EventException
	 */
	public List<SearchInitialSpaceAllocationRatioListVO> searchInitialSpaceAllocationRatioList(SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO) throws EventException {
		try {
			return dbDao.searchInitialSpaceAllocationRatioList(searchInitialSpaceAllocationRatioListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcInitAlocRtoVO[] spcInitAlocRtoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiInitialSpaceAllocationRatio(SpcInitAlocRtoVO[] spcInitAlocRtoVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcInitAlocRtoVO> insertVoList = new ArrayList<SpcInitAlocRtoVO>();
			List<SpcInitAlocRtoVO> updateVoList = new ArrayList<SpcInitAlocRtoVO>();
			List<SpcInitAlocRtoVO> deleteVoList = new ArrayList<SpcInitAlocRtoVO>();
			List<SpcInitAlocRtoVO> deleteVoList2 = new ArrayList<SpcInitAlocRtoVO>();
			
			for ( int i=0; i<spcInitAlocRtoVO .length; i++ ) {
				
				if ( spcInitAlocRtoVO[i].getIbflag().equals("I")){
					spcInitAlocRtoVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(spcInitAlocRtoVO[i]);
				} else if ( spcInitAlocRtoVO[i].getIbflag().equals("U")){
					spcInitAlocRtoVO[i].setUpdUsrId(account.getUsr_id());
					spcInitAlocRtoVO[i].setCreUsrId(account.getUsr_id());
					deleteVoList2.add(spcInitAlocRtoVO[i]);
					insertVoList.add(spcInitAlocRtoVO[i]);
				} else if ( spcInitAlocRtoVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcInitAlocRtoVO[i]);
				}
			}
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiInitialSpaceAllocationRatioS(deleteVoList2);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiInitialSpaceAllocationRatioS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiInitialSpaceAllocationRatioS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiInitialSpaceAllocationRatioS(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
}