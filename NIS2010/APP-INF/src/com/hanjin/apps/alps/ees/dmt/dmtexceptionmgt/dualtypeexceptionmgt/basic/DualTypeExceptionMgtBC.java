/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtBC.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Dmtexceptionmgt Business Logic Command Interface<br>
 * - NIS2010-Dmtexceptionmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2014EventResponse 참조
 * @since J2EE 1.6
 */
public interface DualTypeExceptionMgtBC {
	/**
	 * Dual Type Exception 에 기등록된 Customer 정보를 조회 합니다. <br>
	 * 
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomerList() throws EventException;
	
	
	/**
	 * Dual Type Exception을 조회 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return List<DualTypeCustomerVO>
	 * @exception EventException
	 */
	public List<DualTypeCustomerVO> searchDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Dual Type Exception을 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO[] dualTypeCustomerVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDualTypeCustomer(DualTypeCustomerVO[] dualTypeCustomerVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Dual Type Exception Coverage의 Dual Type 여부를 조회 합니다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualCoverage(CoverageVO coverageVO) throws EventException;
	
	
	/**
	 * Dual Type Exception이 삭제가능 여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDelDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Dual Type Exception Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDualTypeExpireDate(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;	
	
	
	/**
	 * Dual Type Exception의 중복여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return DualTypeCustomerVO
	 * @exception EventException
	 */
	public DualTypeCustomerVO checkDuplicateDualTypeException(DualTypeCustomerVO dualTypeCustomerVO) throws EventException;
	
	
	/**
	 * Dual Type Exception Applied를 조회하는 함수<br>
	 * 
	 * @param SCOrDARListInputVO sCOrDARListInputVO
	 * @return List<SCOrDARListVO>
	 * @exception EventException
	 */
	public List<SCOrDARListVO> searchSCorDARListByCustomer(SCOrDARListInputVO sCOrDARListInputVO) throws EventException;		
}