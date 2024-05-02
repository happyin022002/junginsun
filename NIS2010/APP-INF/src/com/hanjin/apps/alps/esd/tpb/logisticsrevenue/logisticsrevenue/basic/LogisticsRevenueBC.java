/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmBC.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.LogisticsRevenueInvoiceVO;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.TaxInfoVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-JOCaseManage Business Logic Command Interface<br>
 * - ALPS-JOCaseManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Geon Byeon
 * @see ESD_TPB_0105EventResponse 참조
 * @since J2EE 1.6
 */

public interface LogisticsRevenueBC {	
	/**
	 * 해당 Office 의  TPB_INV_SH_SET.vat_xch_rt 값을 구함 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkInvVatXchRate(String ofcCd) throws EventException;
	
	/**
	 * SAVE 오퍼레이션 수행 Return 값으로 TPB no를 받는다. <br>
	 * 
	 * @param logisticsRevenueInvoiceVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] createSingleInvoice(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO) throws EventException;
	
	/**
	 * Third Party Value 의 존재 유무 Check <br>
	 * 
	 * @param String trdPartyVal
	 * @return String
	 * @exception EventException
	 */
	public String checkTrdPartyVal(String trdPartyVal) throws EventException;
	
	
	/**
	 * SAVE 오퍼레이션 수행 Return 값으로 HJS S/P No.를 받는다. <br>
	 * 
	 * @param logisticsRevenueInvoiceVO
	 * @return String[] 
	 * @exception EventException
	 */
	public String[] createMultiInvoice(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO) throws EventException;
	
	/** 
	 * Office Code List 조회.
	 * 
	 * @param ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchTPBCostOfcList(String ofcCd) throws EventException;
	
	/**
	 * India Tax rate 정보 <br>
	 * 
	 * @param String ofcCd
	 * @return List<TaxInfoVO>
	 * @exception EventException
	 */
	public List<TaxInfoVO> searchTaxInfo(String ofcCd) throws EventException;

	
}