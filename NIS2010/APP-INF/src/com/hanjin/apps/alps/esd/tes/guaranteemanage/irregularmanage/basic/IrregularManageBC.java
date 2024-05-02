/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageBC.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.28 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchGuaranteeIrregularCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesIrrHdrVO;

/**
 * ALPS-IrregularManage Business Logic Command Interface<br>
 * - ALPS-IrregularManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC 참조
 * @since J2EE 1.6
 */
public interface IrregularManageBC {
	
	/**
	 * [Irregular Header Info]를 조회합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException;


	/**
	 * [Irregular Header Info]을 [Insert] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String addIrregularHdr(TesIrrHdrVO tesIrrHdrVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [Irregular Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyIrregularHdr(TesIrrHdrVO tesIrrHdrVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Header Info ]을 [Delete] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void deleteIrregular(TesIrrHdrVO tesIrrHdrVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Container List]을 [Inquiry] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularCntrListVO> searchIrregularCntrList(TesIrrHdrVO tesIrrHdrVO) throws EventException;


	/**
	 * [Irregular Container List]를 [Insert/Update/Delete] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiIrregularCntrList(TesIrrHdrVO tesIrrHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Header Info]를 조회합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchGuaranteeIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException;

	
	/**
	 * [Guarantee 에서 Irregular 등록할 Container List] 정보를 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeIrregularCntrListVO> searchGuaranteeIrregularCntrList(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	
	/**
	 * [Irregular] 정보를 [조회]합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchIrregularListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularListVO> searchIrregularList(TesIrrHdrVO tesIrrHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	
}