/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerSpaceGuaranteeBCImpl.java
*@FileTitle : TP/SZ Volume Calculation Terms
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration.CustomerSpaceGuaranteeDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvLaneListVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvLaneVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvListVO;

/**
 * ALPS-ModelConstraintManage Business Logic Command Interface<br>
 * - ALPS-ModelConstraintManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0062EventResponse, CustomerSpaceGuaranteeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CustomerSpaceGuaranteeBCImpl extends BasicCommandSupport implements CustomerSpaceGuaranteeBC {

	// Database Access Object
	private transient CustomerSpaceGuaranteeDBDAO dbDao = null;

	/**
	 * CustomerSpaceGuaranteeBCImpl 객체 생성<br>
	 * CustomerSpaceGuaranteeDBDAO를 생성한다.<br>
	 */
	public CustomerSpaceGuaranteeBCImpl() {
		dbDao = new CustomerSpaceGuaranteeDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvLaneListVO>
	 * @exception EventException
	 */
	public List<SearchCustomerSpaceGuaranteeConvLaneListVO> searchCustomerSpaceGuaranteeConvLaneList(SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO) throws EventException {
		try {
			return dbDao.searchCustomerSpaceGuaranteeConvLaneList(searchCustomerSpaceGuaranteeConvLaneListVO);
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
	 * @param SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvListVO>
	 * @exception EventException
	 */
	public List<SearchCustomerSpaceGuaranteeConvListVO> searchCustomerSpaceGuaranteeConvList(SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO) throws EventException {
		try {
			return dbDao.searchCustomerSpaceGuaranteeConvList(searchCustomerSpaceGuaranteeConvListVO);
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
	 * @param SaqCntrSzConvVO[] saqCntrSzConvVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCustomerSpaceGuarantee1(SaqCntrSzConvVO[] saqCntrSzConvVO, SignOnUserAccount account) throws EventException{
		try {
			List<SaqCntrSzConvVO> insertVoList = new ArrayList<SaqCntrSzConvVO>();
			List<SaqCntrSzConvVO> updateVoList = new ArrayList<SaqCntrSzConvVO>();
			List<SaqCntrSzConvVO> deleteVoList = new ArrayList<SaqCntrSzConvVO>();
			for ( int i=0; i<saqCntrSzConvVO .length; i++ ) {
				if ( saqCntrSzConvVO[i].getVslOwnIndCd().equals("SML")){
					saqCntrSzConvVO[i].setVslOwnIndCd("O");
				} else {
					saqCntrSzConvVO[i].setVslOwnIndCd("C");
				}
				
				if ( saqCntrSzConvVO[i].getIbflag().equals("I")){
					saqCntrSzConvVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqCntrSzConvVO[i]);
				} else if ( saqCntrSzConvVO[i].getIbflag().equals("U")){
					saqCntrSzConvVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqCntrSzConvVO[i]);
				} else if ( saqCntrSzConvVO[i].getIbflag().equals("D")){
					deleteVoList.add(saqCntrSzConvVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiCustomerSpaceGuarantee1S(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiCustomerSpaceGuarantee1S(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiCustomerSpaceGuarantee1S(deleteVoList);
			}
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
	 * @param SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCustomerSpaceGuarantee2(SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVO, SignOnUserAccount account) throws EventException{
		try {
			List<SaqCntrSzConvLaneVO> insertVoList = new ArrayList<SaqCntrSzConvLaneVO>();
			List<SaqCntrSzConvLaneVO> updateVoList = new ArrayList<SaqCntrSzConvLaneVO>();
			List<SaqCntrSzConvLaneVO> deleteVoList = new ArrayList<SaqCntrSzConvLaneVO>();
			for ( int i=0; i<saqCntrSzConvLaneVO .length; i++ ) {
				if ( saqCntrSzConvLaneVO[i].getIbflag().equals("I")){
					saqCntrSzConvLaneVO[i].setCreUsrId(account.getUsr_id());
					saqCntrSzConvLaneVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(saqCntrSzConvLaneVO[i]);
				} else if ( saqCntrSzConvLaneVO[i].getIbflag().equals("U")){
					saqCntrSzConvLaneVO[i].setCreUsrId(account.getUsr_id());
					saqCntrSzConvLaneVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqCntrSzConvLaneVO[i]);
				} else if ( saqCntrSzConvLaneVO[i].getIbflag().equals("D")){
					deleteVoList.add(saqCntrSzConvLaneVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiCustomerSpaceGuarantee2S(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiCustomerSpaceGuarantee2S(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiCustomerSpaceGuarantee2S(deleteVoList);
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