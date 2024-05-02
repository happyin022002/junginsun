/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreAllocationBCImpl.java
*@FileTitle : Pre-Allocation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration.PreAllocationDBDAO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.vo.SearchPreAllocation0068List01VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqPreAlocVO;

/**
 * ALPS-ModelConstraintManage Business Logic Command Interface<br>
 * - ALPS-ModelConstraintManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0067EventResponse, PreAllocationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PreAllocationBCImpl extends BasicCommandSupport implements PreAllocationBC {

	// Database Access Object
	private transient PreAllocationDBDAO dbDao = null;

	/**
	 * PreAllocationBCImpl 객체 생성<br>
	 * PreAllocationDBDAO를 생성한다.<br>
	 */
	public PreAllocationBCImpl() {
		dbDao = new PreAllocationDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ConditionVO>
	 * @exception EventException
	 */
	public List<SearchPreAllocation0068List01VO> searchPreAllocation0068List01(ConditionVO conditionVO) throws EventException {
		try {
			
			return dbDao.searchPreAllocation0068List01(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqPreAlocVO[] saqPreAlocVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	
	public void multiSaqPreAloc0067(SaqPreAlocVO[] saqPreAlocVO, SignOnUserAccount account) throws EventException{
		try {
			List<SaqPreAlocVO> insertVoList = new ArrayList<SaqPreAlocVO>();
			List<SaqPreAlocVO> updateVoList = new ArrayList<SaqPreAlocVO>();
			List<SaqPreAlocVO> deleteVoList = new ArrayList<SaqPreAlocVO>();
			for ( int i=0; i<saqPreAlocVO .length; i++ ) {
				if ( saqPreAlocVO[i].getIbflag().equals("I")){
					saqPreAlocVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqPreAlocVO[i]);
				} else if ( saqPreAlocVO[i].getIbflag().equals("U")){
					saqPreAlocVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqPreAlocVO[i]);
				} else if ( saqPreAlocVO[i].getIbflag().equals("D")){
					deleteVoList.add(saqPreAlocVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSaqPreAloc0067S(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSaqPreAloc0067S(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSaqPreAloc0067S(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}