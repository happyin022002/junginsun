/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : GuaranteeCommonBC.java
 * @FileTitle : GuaranteeCommon
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.esd.tes.common.guaranteecommon.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.event.GuaranteeCommonHTMLAction;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.vo.SearchRefNoListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;

/**
 * GuaranteeCommon Business Logic Command Interface<br>
 * Coding business logic for GuaranteeCommonBCImpl<br>
 *
 * @author yOng hO lEE
 * @see GuaranteeCommonHTMLAction
 * @since J2EE 1.6
 */
public interface GuaranteeCommonBC {

	/**
	 * Searching Reference No(Guarantee No. Or Irregular No.).<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchRefNoListVO>
	 * @exception EventException
	 */
	public List<SearchRefNoListVO> searchRefNoList(GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * Searching Guarantee Container Bkg No & Bl No & VVD Info.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchUSGuaranteeCntrInfo(GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * Validating Customer Code.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<ValidateCustomerCodeVO>
	 * @exception EventException
	 */
	public DBRowSet validateCustomerCode(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	/** validateCustomerCode2
	 * 
	 * @param guaranteeCommonVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse validateCustomerCode2(GuaranteeCommonVO guaranteeCommonVO) throws EventException; 
	/**
	 * Searching that delete flag.<br>
	 * 
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<TesGnteCntrListVO>
	 * @exception EventException
	 */
	public List<TesGnteCntrListVO> checkNonTPB(TesGnteCntrListVO tesGnteCntrListVO) throws EventException;

	/**
	 * Checking Container No. Duplication.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDupCntr(GuaranteeCommonVO guaranteeCommonVO) throws EventException;

	/**
	 * Searching Guarantee Container Bkg No & Bl No & VVD Info.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchCntrBkgNo(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	/** validateCustomerCode2
	 * 
	 * @param tesGnteHdrVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse validateOfficeCode(TesGnteHdrVO tesGnteHdrVO) throws EventException; 
}
