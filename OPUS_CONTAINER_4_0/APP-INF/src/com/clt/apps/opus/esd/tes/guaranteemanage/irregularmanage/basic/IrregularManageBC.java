/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageBC.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchGuaranteeIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesIrrHdrVO;

/**
 * IrregularManage Business Logic Command Interface<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC
 * @since J2EE 1.6
 */
public interface IrregularManageBC {
	
	/**
	 * [Irregular Header Info]retrieve<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException;


	/**
	 * [Irregular Header Info] [Insert] <br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String addIrregularHdr(TesIrrHdrVO tesIrrHdrVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [Irregular Header Info] [Update] <br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void modifyIrregularHdr(TesIrrHdrVO tesIrrHdrVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Header Info ] [Delete] <br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void deleteIrregular(TesIrrHdrVO tesIrrHdrVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Container List] [Inquiry] <br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularCntrListVO> searchIrregularCntrList(TesIrrHdrVO tesIrrHdrVO) throws EventException;


	/**
	 * [Irregular Container List] [Insert/Update/Delete] <br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void multiIrregularCntrList(TesIrrHdrVO tesIrrHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Irregular Header Info]retrieve<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchGuaranteeIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException;

	
	/**
	 * [Guarantee Irregular Container List] Info [Select] <br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeIrregularCntrListVO> searchGuaranteeIrregularCntrList(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	
	/**
	 * [Irregular] Info [Select]<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchIrregularListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularListVO> searchIrregularList(TesIrrHdrVO tesIrrHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	
}