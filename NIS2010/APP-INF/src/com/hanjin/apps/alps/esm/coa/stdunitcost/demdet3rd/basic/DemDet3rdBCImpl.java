/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDet3rdBCImpl.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.integration.DemDet3rdDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;

/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see DemDet3rdBC 참조
 * @since J2EE 1.6
 */
public class DemDet3rdBCImpl extends BasicCommandSupport implements DemDet3rdBC {

	// Database Access Object
	private transient DemDet3rdDBDAO dbDao = null;

	/**
	 * DemDet3rdBCImpl 객체 생성<br>
	 * DemDet3rdDBDAO를 생성한다.<br>
	 */
	public DemDet3rdBCImpl() {
		dbDao = new DemDet3rdDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<DemDet3rdVO>
	 * @exception EventException
	 */
	public List<DemDet3rdVO> searchDEMDET3RDList(SearchConditionVO conditionVO) throws EventException {
		
		conditionVO.unDataFormat();

		try {
			return dbDao.searchDEMDET3RDList(conditionVO);
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
	 * @param DemDet3rdVO[] demDet3rdVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDEMDET3RD(DemDet3rdVO[] demDet3rdVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<DemDet3rdVO> updateVoList = new ArrayList<DemDet3rdVO>();
			
			for ( int i=0; i<demDet3rdVO .length; i++ ) {
				 if ( demDet3rdVO[i].getIbflag().equals("U")){
					demDet3rdVO[i].setUpdUsrId(account.getUsr_id());
					demDet3rdVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					updateVoList.add(demDet3rdVO[i]);
				}
			}			
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDEMDET3RD(updateVoList);
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