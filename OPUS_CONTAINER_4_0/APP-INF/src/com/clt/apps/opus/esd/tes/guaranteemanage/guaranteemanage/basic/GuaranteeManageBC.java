/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageBC.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeHdrVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;

/**
 * GuaranteeManage Business Logic Command Interface<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC
 * @since J2EE 1.6
 */
public interface GuaranteeManageBC {

	/**
	 * [Guarantee Header Info] [Retrieve]<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @return List<SearchUSGuaranteeHdrVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeHdrVO> searchUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws EventException;

	/**
	 * [Guarantee Header Info] [Insert]<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account 
	 * @return String
	 * @exception EventException
	 */
	public String addUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;


	/**
	 * [Guarantee Header Info] [Update]<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account 
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Irregular Header Save Guarantee Header Info] [Update] <br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee Header Info ] [Delete]<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void deleteUSGuarantee(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee Container List][Select]<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @return List<SearchUSGuaranteeCntrListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeCntrListVO> searchUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO) throws EventException;

	/**
	 * [Guarantee Container List] [Insert/Update/Delete]<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account 
	 * @exception EventException
	 */
	public void multiUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [Guarantee List] [Select]<br>
	 * 
	 * @param TesGnteHdrVO	tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeListVO> searchUSGuaranteeList(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * ESD_TES_2003 Guarantee RD Mail Send.<br>
	 * 
	 * @param commonVO 
	 * @param account  
	 * @exception EventException
	 */
	public void sendEmail(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_TES_2003 Guarantee RD FAX Send.<br>
	 * 
	 * @param commonVO 
	 * @param account  
	 * @exception EventException
	 */
	public void sendFax(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException;

}