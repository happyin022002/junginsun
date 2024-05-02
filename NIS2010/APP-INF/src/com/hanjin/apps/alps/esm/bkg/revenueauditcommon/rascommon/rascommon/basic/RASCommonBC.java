/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonBC.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.16 박성수
* 1.0 Creation
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * NIS2010-Pricommon Business Logic Command Interface<br>
 * - NIS2010-Pricommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Sungsoo
 * @see PricommonEventResponse 참조
 * @since J2EE 1.4
 */

public interface RASCommonBC {
	/**
	 * Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList (RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 *  ComCodeDescList 조회 이벤트 처리<br>
	 *  공통 코드,명칭 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException;
	

	/**
	 *  ComCodeList 조회 이벤트 처리<br>
	 *  공통 코드,명칭 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	 public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 *  RasOrganizationList 조회 이벤트 처리<br>
	 *  조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 *  RasContiList 조회 이벤트 처리<br>
	 *  조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltContiListVO rsltcontilistvo
	 * @return List<RsltContiListVO>
	 * @exception EventException
	 */
	public List<RsltContiListVO> seacrhRasContiList(RsltContiListVO rsltcontilistvo) throws EventException;
	
	/**
	 *  UsExangeAmount 조회 이벤트 처리<br>
	 *  해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * BkgRevUmchTpList 조회 이벤트 처리<br>
	 * BKG_REV_UMCH_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * BkgRevUmchSubTpList 조회 이벤트 처리<br>
	 * BKG_REV_UMCH_SUB_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * BKG_REV_UMCH_MNL_STL_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchManualSettleTypeCode(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRatingUnitCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchContainerTypeSizeList(RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
     * charge 리스트를 조회합니다.<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException;

	/**
	 * COD Request Reason Code 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCodRequestResonCodeList (RsltCdListVO rsltcdlistvo) throws EventException;
	


	/**
	 * Note Conversion Type List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConversionTypeCodeList (RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Note Conversion Rule List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConversionRuleCodeList (RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 * Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCodeList (RsltCdListVO rsltcdlistvo) throws EventException;
	
    /**
     * VVD 존재여부 판단하는 함수 <br>
     * 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String validateVVD(String input_text)throws EventException;
    
    /**
     * Invoice Number 존재여부 판단하는 함수 <br>
     * 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String validateInvoiceNumber(String input_text)throws EventException;
}