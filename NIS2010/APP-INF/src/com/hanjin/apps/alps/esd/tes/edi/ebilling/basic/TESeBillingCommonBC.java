/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBC.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see TESInterfaceEventResponse 참조
 * @since J2EE 1.4
 */
public interface TESeBillingCommonBC  {

	static final String FLT_FILE_MSG_ID		= "FLT_FILE_MSG_ID";
	static final String TML_INV_EDI_SEQ     = "TML_INV_EDI_SEQ";
	static final String EDI_SNDR_ID         = "EDI_SNDR_ID";
	static final String EDI_RULE_MAIN       = "EDI_RULE_MAIN";
	static final String EDI_RULE_DTL        = "EDI_RULE_DTL";
	static final String EDI_INIT_VO         = "EDI_INIT_VO";
	
	static final String FLT_FILE   			= "FLT_FILE"; // 하나의 invoice 단위만
	static final String INV_HDR             = "TES_EDI_SO_HDR";
	static final String INV_CNTRS           = "TES_EDI_SO_CNTR_LIST";
	static final String INV_DTLS            = "TES_EDI_SO_DTL";
	static final String INV_MNLCNTRS        = "TES_EDI_SO_MNL_CNTR_LIST";
	static final String INV_AUTOFPS         = "TES_EDI_SO_AUTO_FREE_POOL";

	static final String FF_VNDR_SEQ_NM      = "VNDR_SEQ";
	static final int FF_VNDR_SEQ_LENGTH     = 6;
	

	/**
	 * 유효한 eBilling EDI VNDR 여부를 확인한다..
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String checkValidEdiVndrSeq(Event e) throws EventException;

	
	/**
	 * EDI Main Rule 조회
	 * @param tesEdiInitVO
	 * @throws EventException
	 */
	public ComTesEdiRcvRuleMnVO getEdiMainRule(TesEdiSoHdrVO tesEdiInitVO) throws EventException;
	
	/**
	 * EDI VNDR Rule 조회
	 * @param tesEdiInitVO
	 * @param tesEdiRuleMainVO
	 * @throws EventException
	 */
	public void getSetEdiVndrRules(TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) throws EventException;

	/**
	 * F/F별 수신시 SESSION KEY가 되는 TML_INV_EDI_SEQ를 구함
	 * @return String
	 * @throws EventException
	 */
	public String createTmlInvEdiSeq()throws EventException;
	
	/**
	 *  EDI 저장된 INVOICE목록 가져오기(처리 중인 F/F 전체 단위로)
	 * @param eventResponse
	 * @return List<TesEdiSoHdrVO>
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getEDIInvoiceList(EventResponse eventResponse)throws EventException;

	/**
	 * EDI Invoice를 정규 Invoice로 변환한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(Event e) throws EventException;
	
	
	/**
	 * EDI VNDR Rule 조회
	 * @param tesEdiErrLogVO
	 * @throws EventException
	 */
	public void logEDIErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) throws EventException;

}