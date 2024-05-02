/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBCImpl.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-21
*@LastModifier : 장영석
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.integration.AgencyCommissionDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaOtrCommVO;


/**
 * opus-STDUnitCost Business Logic Command Interface<br>
 * - opus-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AgencyCommissionBCImpl extends BasicCommandSupport implements AgencyCommissionBC {

	// Database Access Object
	private transient AgencyCommissionDBDAO dbDao = null;

	/**
	 * AgencyCommissionBCImpl 객체 생성<br>
	 * AgencyCommissionDBDAO를 생성한다.<br>
	 */
	public AgencyCommissionBCImpl() {
		dbDao = new AgencyCommissionDBDAO();
	}
	/**
	 * Agent Commission 단가를 조회<br>
	 * 
	 * @param SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAgnOtrCommCostListVO>
	 * @exception EventException
	 */
	public List<SearchAgnOtrCommCostListVO> searchAgnOtrCommCostList(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO, SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchAgnOtrCommCostList(searchAgnOtrCommCostListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [Agent Commission 단가를 입력,수정,삭제<br>
	 * 
	 * @param CoaOtrCommVO[] coaOtrCommVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAgnOtrCommCost(CoaOtrCommVO[] coaOtrCommVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaOtrCommVO> insertVoList = new ArrayList<CoaOtrCommVO>();
			List<CoaOtrCommVO> updateVoList = new ArrayList<CoaOtrCommVO>();
			List<CoaOtrCommVO> deleteVoList = new ArrayList<CoaOtrCommVO>();
			for ( int i=0; i<coaOtrCommVO .length; i++ ) {
				if ( coaOtrCommVO[i].getIbflag().equals("I")){
					coaOtrCommVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(coaOtrCommVO[i]);
				} else if ( coaOtrCommVO[i].getIbflag().equals("U")){
					coaOtrCommVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaOtrCommVO[i]);
				} else if ( coaOtrCommVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaOtrCommVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiAgnOtrCommCost(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiAgnOtrCommCost(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiAgnOtrCommCost(deleteVoList);
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