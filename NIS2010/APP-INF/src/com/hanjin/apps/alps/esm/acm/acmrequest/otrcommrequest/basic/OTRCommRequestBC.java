/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestBC.java
*@FileTitle : OTRCommRequestBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.vo.OTRCommRequestVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0014EventResponse 참조
 * @since J2EE 1.6
 */

public interface OTRCommRequestBC {

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Creation & Request 목록을 조회<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchOTRCommRequest(OTRCommRequestVO otrCommRequestVO) throws EventException;

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 office 및 vendor 정보를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */	
	public List<OTRCommRequestVO> searchOfficeVendorInfo(OTRCommRequestVO otrCommRequestVO) throws EventException;
	
	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 , xchRt를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */	
	public List<OTRCommRequestVO> searchCurrXchRt(OTRCommRequestVO otrCommRequestVO) throws EventException;

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Add Row 시  PatmentAmt, UsdAmt를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */	
	public List<OTRCommRequestVO> searchPatmentUsdAmt(OTRCommRequestVO otrCommRequestVO) throws EventException;
	
	/**
	 * [ESM_ACM_0014]
	 * Other Commission Creation & Request 목록을 추가,수정, 삭제한다.<br>
	 *
	 * @param OTRCommRequestVO[] otrCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageOTRCommRequest(OTRCommRequestVO[] otrCommRequestVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_ACM_0014]
	 * Other Commission Creation & Request 목록을 추가한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void otherCommissionRequestManageOTRCommRequest(OTRCommRequestVO otrCommRequestVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 Request 한다.<br>
	 *
	 * @param OTRCommRequestVO[] otrCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestOTRCommRequest(OTRCommRequestVO[] otrCommRequestVOs, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */	
	public List<OTRCommRequestVO> searchFxCurrRt(OTRCommRequestVO otrCommRequestVO) throws EventException;

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */	
	public List<OTRCommRequestVO> searchPatmentFxCurrUsdAmt(OTRCommRequestVO otrCommRequestVO) throws EventException;
	
}