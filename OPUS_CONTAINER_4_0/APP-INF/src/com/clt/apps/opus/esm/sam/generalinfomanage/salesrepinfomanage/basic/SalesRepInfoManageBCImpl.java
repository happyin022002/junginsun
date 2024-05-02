/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesRepInfoManageBCImpl.java
*@FileTitle : Sales Rep List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.basic;

import java.util.List;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration.SalesRepInfoManageDBDAO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.SamCustSRepVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * - ALPS-GeneralInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEECHANGWON
 * @see SalesRepInfoManageBCImpl
 * @since J2EE 1.6
 */
public class SalesRepInfoManageBCImpl extends BasicCommandSupport implements SalesRepInfoManageBC {

	// Database Access Object
	private transient SalesRepInfoManageDBDAO dbDao = null;

	/**
	 * SalesRepInfoManageBCImpl 객체 생성<br>
	 * SalesRepInfoManageDBDAO를 생성한다.<br>
	 */
	public SalesRepInfoManageBCImpl() {
		dbDao = new SalesRepInfoManageDBDAO();
	}
	
	/**
	 * ESM_SAM_0005 : Retrieve<br>
	 * Sales Rep 정보 조회<br>
	 * 
	 * @param SamCustSRepVO samCustSRepVO
	 * @return List<SamCustSRepVO>
	 * @exception EventException
	 */
	public List<SamCustSRepVO> searchSRepList(SamCustSRepVO samCustSRepVO) throws EventException {
		try {
				return dbDao.searchSRepList(samCustSRepVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SAM_0006 
	 * Customer List by Sales Rep 정보 조회<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception EventException
	 */
	public List<SearchCustomerVO> searchCustomerBySalesRep(SearchCustomerVO searchCustomerVO) throws EventException {
		try {
			return dbDao.searchCustomerBySalesRep(searchCustomerVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
		
	/**
	 * ESM_SAM_0900
	 * [ON_CHANGE] SREP_CD
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception EventException
	 */
	public String searchSRepName(SearchCustomerVO searchCustomerVO) throws EventException {

		try {
			return dbDao.searchSRepName(searchCustomerVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SAM_0006 
	 * Loadpage SREP_CD SELECT
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchSRepNameByUser(SignOnUserAccount account) throws EventException {

		try {
			return dbDao.searchSRepNameByUser(account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * ESM_SAM_0900 : SAVE<br>
	 * Primay 변경<br>
	 * 
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account
	 * @param String key
	 * @exception EventException
	 */
	public void manageCustSRep(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account, String key) throws EventException {
			
		try {

			if( key.equals("")){
				if(customsCustomerVO.getSrepPrmryFlg().equals("Y")){
				dbDao.modifyOrgPrmryFlg(customsCustomerVO, account);
				}
				dbDao.addPrmychange(customsCustomerVO,account);
			}else if( key.equals("N")){
				dbDao.modifyOrgPrmryFlg(customsCustomerVO, account);
				dbDao.modifyPrmychange(customsCustomerVO, account);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * ESM_SAM_0900 : load<br>
	 * Primay 조회<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @returnSearchCustomerVO
	 * @exception EventException
	 */
	public SearchCustomerVO searchPrmyKey(SearchCustomerVO searchCustomerVO)throws EventException {
		try {
			return dbDao.searchPrmyKey(searchCustomerVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/** ESM_SAM_0001 <br>
	 * Sales Office의 소속된 Sales Rep Code정보를 combo로 조회한다.<br>
	 *
	 * @param String sls_ofc_cd
	 * @return List<SamCustSRepVO>
	 * @exception EventException
	 * 
	 */
	public List<SamCustSRepVO> searchSalesRepBySalesOffice(String sls_ofc_cd) throws EventException{
	
		try {
			return dbDao.searchSalesRepBySalesOffice(sls_ofc_cd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}