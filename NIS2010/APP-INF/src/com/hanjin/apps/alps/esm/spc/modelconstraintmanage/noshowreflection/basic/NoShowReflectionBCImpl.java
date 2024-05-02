/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoShowReflectionBCImpl.java
*@FileTitle : No-Show Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration.NoShowReflectionDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcNshwRfltVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.vo.SearchNoShowReflectionListVO;

/**
 * ALPS-ModelConstraintManage Business Logic Command Interface<br>
 * - ALPS-ModelConstraintManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0015EventResponse, NoShowReflectionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class NoShowReflectionBCImpl extends BasicCommandSupport implements NoShowReflectionBC {

	// Database Access Object
	private transient NoShowReflectionDBDAO dbDao = null;

	/**
	 * NoShowReflectionBCImpl 객체 생성<br>
	 * NoShowReflectionDBDAO를 생성한다.<br>
	 */
	public NoShowReflectionBCImpl() {
		dbDao = new NoShowReflectionDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNoShowReflectionListVO searchNoShowReflectionListVO
	 * @return List<SearchNoShowReflectionListVO>
	 * @exception EventException
	 */
	public List<SearchNoShowReflectionListVO> searchNoShowReflectionList(SearchNoShowReflectionListVO searchNoShowReflectionListVO) throws EventException {
		try {
			return dbDao.searchNoShowReflectionList(searchNoShowReflectionListVO);
		} catch(DAOException ex) {
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
	 * @param SpcNshwRfltVO[] spcNshwRfltVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowReflection(SpcNshwRfltVO[] spcNshwRfltVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcNshwRfltVO> insertVoList = new ArrayList<SpcNshwRfltVO>();
			List<SpcNshwRfltVO> updateVoList = new ArrayList<SpcNshwRfltVO>();
			List<SpcNshwRfltVO> deleteVoList = new ArrayList<SpcNshwRfltVO>();
			for ( int i=0; i<spcNshwRfltVO .length; i++ ) {
				if ( spcNshwRfltVO[i].getIbflag().equals("I")){
					spcNshwRfltVO[i].setCreUsrId(account.getUsr_id());
					spcNshwRfltVO[i].setUpdUsrId(account.getUsr_id());
					spcNshwRfltVO[i].setAlocDdctModCd("2");
					insertVoList.add(spcNshwRfltVO[i]);
				} else if ( spcNshwRfltVO[i].getIbflag().equals("U")){
					spcNshwRfltVO[i].setUpdUsrId(account.getUsr_id());
					spcNshwRfltVO[i].setAlocDdctModCd("2");
					updateVoList.add(spcNshwRfltVO[i]);
				} else if ( spcNshwRfltVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcNshwRfltVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiNoShowReflectionS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiNoShowReflectionS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiNoShowReflectionS(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}