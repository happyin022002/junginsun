/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListBC.java
*@FileTitle : Awkward and Break Bulk Cargo Quotation List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkBbVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkMnVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Specialcargoquotation Business Logic Command Interface<br>
 * - ALPS-Specialcargoquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @since J2EE 1.6
 */

public interface ScqListBC {

	/**
	 * Awkward & Break Bulk Quotation List 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkBbCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Awkward & Break Bulk Quotation List 에서 Awkward Case 의 Cargo Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Awkward & Break Bulk Quotation List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public PriScqAwkBbVO searchBbDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Awkward & Break Bulk Approval List 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkBbCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Awkward & Break Bulk Approval List 에서 Awkward Case 의 Cargo Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Awkward & Break Bulk Approval List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO	priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public PriScqAwkBbVO searchBbDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException;
	
	/**
	 * Attachment File 조회.<br>
	 * 
	 * @param RestrictCmdtFileVO vo
	 * @return List<BkgImpImgStoVO>
	 * @exception EventException
	 */
	public List<PriScqAtchFileVO> searchPriScqAtchFile(PriScqAtchFileVO vo) throws EventException;
	
	/**
	 * 특수화물 Quotation 에서 Awkward, Break Bulk 양쪽에서 사용되는 Attachment File 관리 <br>
	 * 
	 * @param RestrictCmdtFileVO restrictCmdtFileVO
	 * @exception EventException
	 */
	public void managePriScqAtchFile(PriScqAtchFileVO[] priScqAtchFileVOs, String[] saveIds, SignOnUserAccount account) throws EventException;	

	/**
	 * Customer Input Popup List 조회. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException;
}