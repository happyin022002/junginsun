/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonBC.java
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.vo.SearchRefNoListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;

/**
 * ALPS-GuaranteeCommon Business Logic Command Interface<br>
 * - ALPS-GuaranteeCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuaranteeCommonHTMLAction 참조
 * @since J2EE 1.6
 */
public interface GuaranteeCommonBC {
	
	/**
	 * [Reference No(Guarantee No. Or Irregular No.)]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchRefNoListVO>
	 * @exception EventException
	 */
	public List<SearchRefNoListVO> searchRefNoList(GuaranteeCommonVO guaranteeCommonVO) throws EventException;


	/**
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchUSGuaranteeCntrInfo( GuaranteeCommonVO guaranteeCommonVO ) throws EventException;

	/**
	 * Guarantee Creation Grid에 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrDupChkVO>
	 * @exception EventException
	 */
	public DBRowSet searchUSGuaranteeCntrDupChk( GuaranteeCommonVO guaranteeCommonVO ) throws EventException;
	
	/**
	 * Guarantee Creation Save 시 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrDupChkVO>
	 * @exception EventException
	 */
	public DBRowSet searchUSGuaranteeCntrDupChk2( GuaranteeCommonVO guaranteeCommonVO ) throws EventException;
	
	/**
	 * [Master Container 에 CNTR 존재여부]를 조회합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<searchMstCntrExist>
	 * @exception EventException
	 */
	public DBRowSet searchMstCntrExist( GuaranteeCommonVO guaranteeCommonVO ) throws EventException;

	
	/**
	 * [Customer Code ]을 [유효성 검증] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<ValidateCustomerCodeVO>
	 * @exception EventException 
	 */
	public DBRowSet validateCustomerCode(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	/**
	 * [TPB I/F된 대상 Delete 여부 Flag ]을 [Select] 합니다.<br>
	 * 
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<TesGnteCntrListVO>
	 * @exception EventException
	 */
	public List<TesGnteCntrListVO> checkNonTPB(TesGnteCntrListVO tesGnteCntrListVO) throws EventException;


	/**
	 * [Container No. Duplication]을 [Check] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDupCntr(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	
	/**
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchCntrBkgNo(GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * Guarantee Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchValidChkForPrint(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
		
	/**
	 * Irregular Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchIrrPrintChk(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
}