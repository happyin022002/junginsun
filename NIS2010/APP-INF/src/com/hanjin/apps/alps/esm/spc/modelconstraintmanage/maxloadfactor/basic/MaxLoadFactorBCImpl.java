/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MaxLoadFactorBCImpl.java
*@FileTitle : Maximum L/F Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.12 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.integration.MaxLoadFactorDBDAO; 
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.vo.SearchMaxLoadFactorListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMaxLodFctrVO;

/**
 * ALPS-ModelConstraintManage Business Logic Basic Command implementation<br>
 * - ALPS-ModelConstraintManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0019EventResponse,MaxLoadFactorBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MaxLoadFactorBCImpl extends BasicCommandSupport implements MaxLoadFactorBC {

	// Database Access Object
	private transient MaxLoadFactorDBDAO dbDao = null;

	/**
	 * MaxLoadFactorBCImpl 객체 생성<br>
	 * MaxLoadFactorDBDAO를 생성한다.<br>
	 */
	public MaxLoadFactorBCImpl() {
		dbDao = new MaxLoadFactorDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchMaxLoadFactorListVO>
	 * @exception EventException
	 */
	public List<SearchMaxLoadFactorListVO> searchMaxLoadFactorList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchMaxLoadFactorList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcMaxLodFctrVO[] spcMaxLodFctrVO
	 * @param String bse_yr
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMaxLoadFactor(SpcMaxLodFctrVO[] spcMaxLodFctrVO, String bse_yr, SignOnUserAccount account) throws EventException{
		try {
			List<SpcMaxLodFctrVO> insertVoList = new ArrayList<SpcMaxLodFctrVO>();
			List<SpcMaxLodFctrVO> updateVoList = new ArrayList<SpcMaxLodFctrVO>();
			List<SpcMaxLodFctrVO> deleteVoList = new ArrayList<SpcMaxLodFctrVO>();
			List<SpcMaxLodFctrVO> deleteVoList2 = new ArrayList<SpcMaxLodFctrVO>();
			for ( int i=0; i<spcMaxLodFctrVO .length; i++ ) {
				if ( spcMaxLodFctrVO[i].getIbflag().equals("I")){
					spcMaxLodFctrVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(spcMaxLodFctrVO[i]);
				} else if ( spcMaxLodFctrVO[i].getIbflag().equals("U")){
					spcMaxLodFctrVO[i].setBseYr(bse_yr);
					spcMaxLodFctrVO[i].setCreUsrId(account.getUsr_id());
					spcMaxLodFctrVO[i].setUpdUsrId(account.getUsr_id());
					//updateVoList.add(spcMaxLodFctrVO[i]);
					deleteVoList2.add(spcMaxLodFctrVO[i]);					
					insertVoList.add(spcMaxLodFctrVO[i]);
				} else if ( spcMaxLodFctrVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcMaxLodFctrVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiMaxLoadFactorS(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiMaxLoadFactorS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiMaxLoadFactorS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiMaxLoadFactorS(deleteVoList);
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