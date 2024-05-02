/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageBC.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;

/**
 * ALPS-GuaranteeManage Business Logic Command Interface<br>
 * - ALPS-GuaranteeManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC 참조
 * @since J2EE 1.6
 */
public interface GuaranteeManageBC {

	/**
	 * [Guarantee Header Info]를 조회합니다.<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @return List<SearchUSGuaranteeHdrVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeHdrVO> searchUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws EventException;

	/**
	 * [Guarantee Header Info]을 [Insert] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String addUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;


	/**
	 * [Guarantee Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Irregular Header Save 할때 Guarantee Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee Header Info ]을 [Delete] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void deleteUSGuarantee(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee Container List]을 [Select] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @return List<SearchUSGuaranteeCntrListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeCntrListVO> searchUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO) throws EventException;

	/**
	 * [Guarantee Container List]를 [Insert/Update/Delete] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee List] 정보를 [Select]합니다.<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeListVO> searchUSGuaranteeList(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * ESD_TES_2003 Guarantee RD Mail  Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendEmail(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_TES_2003 Guarantee RD FAX  Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendFax(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException;

}