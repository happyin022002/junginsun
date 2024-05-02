/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInvoiceCommonBC.java
*@FileTitle : TES Invoice Common Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author byungheeyoo
 * @see TESInvoiceCommonBC
 * @since J2EE 1.4
 */
public interface TESInvoiceCommonBC  {

	/**
	 * Retrieve event process
	 * TESInvoiceCommon Retrieve event process
	 * 
	 * @param e TESInvoiceCommonEvent
	 * @return EventResponse 
	 * @exception EventException
	 */
	
	final static String INV_STS_RC = "RC";	//R
	final static String INV_STS_CF = "CF";	//C
	final static String INV_STS_AR 	= "AR"; //A
	final static String INV_STS_AP 	= "AP"; //P
	final static String INV_STS_CSR = "CSR"; //A,P
	final static String INV_STS_PD = "PD"; //D
	
	/**
	 * Get Withholding tax mode
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getWHTmode(Event e) throws EventException;
	
	/**
	 * Get agreement currency code
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtCurrCD(Event e) throws EventException;

	/**
	 * Get agreement status
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtSts(Event e) throws EventException;
	
	/**
	 * Get COST CODE N3PTY_BIL_CS_CD
	 * 
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getN3ptyBilCSCD(Event e) throws EventException;
	
	/**
	 * Get ERR_INV_NO
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse isValidErrInvNo(Event e) throws EventException;

	/** selectYdNm
	 * 
	 * @param model
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse selectYdNm(TesTmlSoHdrVO model) throws EventException;
	
	/** selectVndrNm
	 * 
	 * @param model
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse selectVndrNm(TesTmlSoHdrVO model) throws EventException;
	
	/** selectCostCdFtrRmk
	 * 
	 * @param model
	 * @return String
	 * @throws EventException
	 */
	public String selectCostCdFtrRmk(TesTmlSoHdrVO model) throws EventException;
	
	/**
	 * Check invoice Status
	 * 
	 * @param model
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO model, String mode) throws EventException;

	/**
	 * Check invoice Status
	 * 
	 * @param models
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO[] models, String mode) throws EventException;

	/**
	 * Check invoice Status
	 * 
	 * @param csr_no
	 * @param mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(String csr_no, String mode) throws EventException;

	/**
	 * Check TBP I/F DATA
	 * 
	 * @param tesTmlSoHdrVO
	 * @exception EventException
	 */
	public void checkDetailTpb(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	
	/**
	 * 2010-11-11: [CHM-201006940-01] INV AUTO CALC CHECK 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getMgstNos(Event e) throws EventException;
	
	/**
	 * checkInvCalcCostCD
	 * @param tesTmlSoHdrVO TesTmlSoHdrVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse checkInvCalcCostCD(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInv(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException; 
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @param apPayInvVO
	 * @return ApPayInvDtlVO[] 
	 * @throws EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(TesTmlSoHdrVO tesTmlSoHdrVO, ApPayInvVO apPayInvVO) throws EventException;
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @param apPayInvVO
	 * @throws EventException
	 */
	public void cancelApPayInvAll(TesTmlSoHdrVO tesTmlSoHdrVO, ApPayInvVO apPayInvVO) throws EventException;
	
	
}