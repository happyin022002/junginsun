/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConstraintItemBCImpl.java
*@FileTitle : Constraints List Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.30 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration.ConstraintItemDBDAO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItem063LoadableListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItemListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqMdlCnstVO;

/**
 * ALPS-ModelConstraintManage Business Logic Basic Command implementation<br>
 * - ALPS-ModelConstraintManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0011EventResponse,ConstraintItemBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ConstraintItemBCImpl extends BasicCommandSupport implements ConstraintItemBC {

	// Database Access Object
	private transient ConstraintItemDBDAO dbDao = null;

	/**
	 * ConstraintItemBCImpl 객체 생성<br>
	 * ConstraintItemDBDAO를 생성한다.<br>
	 */
	public ConstraintItemBCImpl() {
		dbDao = new ConstraintItemDBDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConstraintItemListVO searchConstraintItemListVO
	 * @return List<SearchConstraintItemListVO>
	 * @exception EventException
	 */
	public List<SearchConstraintItemListVO> searchConstraintItemList(SearchConstraintItemListVO searchConstraintItemListVO) throws EventException {
		try {
			return dbDao.searchConstraintItemList(searchConstraintItemListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchConstraintItem063LoadableListVO>
	 * @exception EventException
	 */
	public List<SearchConstraintItem063LoadableListVO> searchConstraintItem063LoadableList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchConstraintItem063LoadableList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqMdlCnstVO[] saqMdlCnstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiConstraintItem(SaqMdlCnstVO[] saqMdlCnstVO, SignOnUserAccount account) throws EventException{
		try {
			List<SaqMdlCnstVO> insertVoList = new ArrayList<SaqMdlCnstVO>();
			List<SaqMdlCnstVO> updateVoList = new ArrayList<SaqMdlCnstVO>();
			List<SaqMdlCnstVO> deleteVoList = new ArrayList<SaqMdlCnstVO>();
			for ( int i=0; i<saqMdlCnstVO .length; i++ ) {
				if ( saqMdlCnstVO[i].getIbflag().equals("I")){
					saqMdlCnstVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqMdlCnstVO[i]);
				} else if ( saqMdlCnstVO[i].getIbflag().equals("U")){
					saqMdlCnstVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqMdlCnstVO[i]);
				} else if ( saqMdlCnstVO[i].getIbflag().equals("D")){
					deleteVoList.add(saqMdlCnstVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiConstraintItemS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiConstraintItemS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiConstraintItemS(deleteVoList);
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