/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtBC.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dmtexceptionmgt Business Logic Command Interface<br>
 * @author 
 * @see EES_DMT_2014EventResponse reference
 * @since J2EE 1.6
 */
public interface DualTypeExceptionMgtBC {
	/**
	 * Search Customer information in Dual Type Exception. <br>
	 * 
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomerList() throws EventException;
	
	
	/**
	 * Search Dual Type Exception. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Create, Modify and Delete Dual Type Exception. <br>
	 * 
	 * @param DualTypeCustomerVO[] dualTypeCustomerVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDualTypeCustomer(DualTypeCustomerVO[] dualTypeCustomerVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Check Dual Type of Dual Type Exception Coverage.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualCoverage(CoverageVO coverageVO) throws EventException;
	
	
	/**
	 * Check it is Deletable Dual Type Exception.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDelDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Check Validation Dual Type Exception Expire Date.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDualTypeExpireDate(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;	
	
	
	/**
	 * Check Duplication Dual Type Exception.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return DualTypeCustomerVO
	 * @exception EventException
	 */
	public DualTypeCustomerVO checkDuplicateDualTypeException(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Search Applied Dual Type Exception<br>
	 * 
	 * @param SCOrDARListInputVO sCOrDARListInputVO
	 * @return List<SCOrDARListVO>
	 * @exception EventException
	 */
	public List<SCOrDARListVO> searchSCorDARListByCustomer(SCOrDARListInputVO sCOrDARListInputVO) throws EventException;		
}