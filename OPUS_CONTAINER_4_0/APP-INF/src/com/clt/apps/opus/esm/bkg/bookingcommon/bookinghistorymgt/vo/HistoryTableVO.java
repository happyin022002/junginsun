/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgHistoryVO.java
*@FileTitle : BkgHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.12 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.syscommon.common.table.BkgAwkCgoVO;
import com.clt.syscommon.common.table.BkgAwkDimVO;
import com.clt.syscommon.common.table.BkgBbCgoVO;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgBlMkDescVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgChgRtVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.BkgDocIssRdemVO;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;
import com.clt.syscommon.common.table.BkgEurTroDtlVO;
import com.clt.syscommon.common.table.BkgEurTroVO;
import com.clt.syscommon.common.table.BkgHblCustVO;
import com.clt.syscommon.common.table.BkgHblVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRateVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRfCgoVO;
import com.clt.syscommon.common.table.BkgStwgCgoVO;
import com.clt.syscommon.common.table.BkgTroDtlVO;
import com.clt.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.BkgXptImpLicVO;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이남경
 * @since  J2EE 1.6
 * @see ..
 */

public class HistoryTableVO {
	/** Table Value Object 조회 조건 및 List 처리  */
	private List<TableListVO>         tableListVOs         = new ArrayList<TableListVO>();
	private List<BkgBookingVO>        bkgBookingVOs        = new ArrayList<BkgBookingVO>();
	private List<BkgCustomerVO>       bkgCustomerVOs       = new ArrayList<BkgCustomerVO>();
	private List<BkgVvdVO>            bkgVvdVOs            = new ArrayList<BkgVvdVO>();
	private List<BkgQuantityVO>       bkgQuantityVOs       = new ArrayList<BkgQuantityVO>();
	private List<BkgQtyDtlVO>         bkgQtyDtlVOs         = new ArrayList<BkgQtyDtlVO>();
	private List<BkgCntcPsonVO>       bkgCntcPsonVOs       = new ArrayList<BkgCntcPsonVO>();
	private List<BkgReferenceVO>      bkgReferenceVOs      = new ArrayList<BkgReferenceVO>();
	private List<BkgRefDtlVO>         bkgRefDtlVOs         = new ArrayList<BkgRefDtlVO>();
	private List<BkgContainerVO>      bkgContainerVOs      = new ArrayList<BkgContainerVO>();
	private List<BkgCntrSealNoVO>     bkgCntrSealNoVOs     = new ArrayList<BkgCntrSealNoVO>();
	private List<BkgCntrMfDescVO>     bkgCntrMfDescVOs     = new ArrayList<BkgCntrMfDescVO>();
	private List<BkgClzTmVO>          bkgClzTmVOs          = new ArrayList<BkgClzTmVO>();
	private List<BkgBlDocVO>          bkgBlDocVOs          = new ArrayList<BkgBlDocVO>();
	private List<BkgBlMkDescVO>       bkgBlMkDescVOs       = new ArrayList<BkgBlMkDescVO>();
	private List<BkgHblVO>            bkgHblVOs            = new ArrayList<BkgHblVO>();
	private List<BkgHblCustVO>        bkgHblCustVOs        = new ArrayList<BkgHblCustVO>();
	private List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVOs = new ArrayList<BkgUsaCstmsFileNoVO>();	
	private List<BkgXptImpLicVO>      bkgXptImpLicVOs      = new ArrayList<BkgXptImpLicVO>();
	private List<BkgDgCgoVO>          bkgDgCgoVOs          = new ArrayList<BkgDgCgoVO>();
	private List<BkgRfCgoVO>          bkgRfCgoVOs          = new ArrayList<BkgRfCgoVO>();
	private List<BkgAwkCgoVO>         bkgAwkCgoVOs         = new ArrayList<BkgAwkCgoVO>();
	private List<BkgAwkDimVO>         bkgAwkDimVOs         = new ArrayList<BkgAwkDimVO>();
	private List<BkgBbCgoVO>          bkgBbCgoVOs          = new ArrayList<BkgBbCgoVO>();	
	private List<BkgTroVO>            bkgTroVOs            = new ArrayList<BkgTroVO>();
	private List<BkgTroDtlVO>         bkgTroDtlVOs         = new ArrayList<BkgTroDtlVO>();
	private List<BkgTroSpclCgoSeqVO>  bkgTroSpclCgoSeqVOs  = new ArrayList<BkgTroSpclCgoSeqVO>();
	private List<BkgEurTroVO>         bkgEurTroVOs         = new ArrayList<BkgEurTroVO>();
	private List<BkgEurTroDtlVO>      bkgEurTroDtlVOs      = new ArrayList<BkgEurTroDtlVO>();
	private List<BkgEurTroDgSeqVO>    bkgEurTroDgSeqVOs    = new ArrayList<BkgEurTroDgSeqVO>();	
	private List<BkgRateVO>           bkgRateVOs           = new ArrayList<BkgRateVO>();
	private List<BkgChgRtVO>          bkgChgRtVOs          = new ArrayList<BkgChgRtVO>();
	private List<BkgBlIssVO>          bkgBlIssVOs          = new ArrayList<BkgBlIssVO>();	
	private List<BkgDocIssRdemVO>     bkgDocIssRdemVOs     = new ArrayList<BkgDocIssRdemVO>();	
	private List<BkgStwgCgoVO>        bkgStwgCgoVOs         = new ArrayList<BkgStwgCgoVO>();
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO           bkgBlNoVO           = null;
	private TableListVO         tableListVO         = null;
	private BkgBookingVO        bkgBookingVO        = null;
	private BkgCustomerVO       bkgCustomerVO       = null;
	private BkgVvdVO            bkgVvdVO            = null;
	private BkgQuantityVO       bkgQuantityVO       = null;
	private BkgQtyDtlVO         bkgQtyDtlVO         = null;
	private BkgCntcPsonVO       bkgCntcPsonVO       = null;
	private BkgReferenceVO      bkgReferenceVO      = null;
	private BkgRefDtlVO         bkgRefDtlVO         = null;
	private BkgContainerVO      bkgContainerVO      = null;
	private BkgCntrSealNoVO     bkgCntrSealNoVO     = null;
	private BkgCntrMfDescVO     bkgCntrMfDescVO     = null;
	private BkgClzTmVO          bkgClzTmVO          = null;
	private BkgBlDocVO          bkgBlDocVO          = null;
	private BkgBlMkDescVO       bkgBlMkDescVO       = null;
	private BkgHblVO            bkgHblVO            = null;
	private BkgHblCustVO        bkgHblCustVO        = null;
	private BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO = null;	
	private BkgXptImpLicVO      bkgXptImpLicVO      = null;
	private BkgDgCgoVO          bkgDgCgoVO          = null;
	private BkgRfCgoVO          bkgRfCgoVO          = null;
	private BkgAwkCgoVO         bkgAwkCgoVO         = null;
	private BkgAwkDimVO         bkgAwkDimVO         = null;
	private BkgBbCgoVO          bkgBbCgoVO          = null;	
	private BkgTroVO            bkgTroVO            = null;
	private BkgTroDtlVO         bkgTroDtlVO         = null;
	private BkgTroSpclCgoSeqVO  bkgTroSpclCgoSeqVO  = null;
	private BkgEurTroVO         bkgEurTroVO         = null;
	private BkgEurTroDtlVO      bkgEurTroDtlVO      = null;
	private BkgEurTroDgSeqVO    bkgEurTroDgSeqVO    = null;	
	private BkgRateVO           bkgRateVO           = null;
	private BkgChgRtVO          bkgChgRtVO          = null;
	private BkgBlIssVO          bkgBlIssVO          = null;
	private BkgDocIssRdemVO     bkgDocIssRdemVO     = null;
	private BkgStwgCgoVO        bkgStwgCgoVO         = null;
	
	
	/** Table Value Object Multi Data 처리 *///<- 미사용
//	private BkgBookingVO[]        arrBkgBookingVO        = null;
//	private BkgCustomerVO[]       arrBkgCustomerVO       = null;
//	private BkgVvdVO[]            arrBkgVvdVO            = null;
//	private BkgQuantityVO[]       arrBkgQuantityVO       = null;
//	private BkgQtyDtlVO[]         arrBkgQtyDtlVO         = null;
//	private BkgCntcPsonVO[]       arrBkgCntcPsonVO       = null;
//	private BkgReferenceVO[]      arrBkgReferenceVO      = null;
//	private BkgRefDtlVO[]         arrBkgRefDtlVO         = null;
//	private BkgContainerVO[]      arrBkgContainerVO      = null;
//	private BkgCntrSealNoVO[]     arrBkgCntrSealNoVO     = null;
//	private BkgCntrMfDescVO[]     arrBkgCntrMfDescVO     = null;
//	private BkgClzTmVO[]          arrBkgClzTmVO          = null;
//	private BkgBlDocVO[]          arrBkgBlDocVO          = null;
//	private BkgBlMkDescVO[]       arrBkgBlMkDescVO       = null;
//	private BkgHblVO[]            arrBkgHblVO            = null;
//	private BkgHblCustVO[]        arrBkgHblCustVO        = null;
//	private BkgUsaCstmsFileNoVO[] arrBkgUsaCstmsFileNoVO = null;	
//	private BkgXptImpLicVO[]      arrBkgXptImpLicVO      = null;
//	private BkgDgCgoVO[]          arrBkgDgCgoVO          = null;
//	private BkgRfCgoVO[]          arrBkgRfCgoVO          = null;
//	private BkgAwkCgoVO[]         arrBkgAwkCgoVO         = null;
//	private BkgAwkDimVO[]         arrBkgAwkDimVO         = null;
//	private BkgBbCgoVO[]          arrBkgBbCgoVO          = null;
//	private BkgTroVO[]            arrBkgTroVO            = null;
//	private BkgTroDtlVO[]         arrBkgTroDtlVO         = null;
//	private BkgTroSpclCgoSeqVO[]  arrBkgTroSpclCgoSeqVO  = null;
//	private BkgEurTroVO[]         arrBkgEurTroVO         = null;
//	private BkgEurTroDtlVO[]      arrBkgEurTroDtlVO      = null;
//	private BkgEurTroDgSeqVO[]    arrBkgEurTroDgSeqVO    = null;	
//	private BkgRateVO[]           arrBkgRateVO           = null;
//	private BkgChgRtVO[]          arrBkgChgRtVO          = null;
//	private BkgBlIssVO[]          arrBkgBlIssVO          = null;
//	private BkgDocIssRdemVO[]     arrBkgDocIssRdemVO     = null;
	
	
	/**
	 * @return the bkgBookingVOs
	 */
	public List<BkgBookingVO> getBkgBookingVOs() {
		return bkgBookingVOs;
	}
	/**
	 * @param bkgBookingVOs the bkgBookingVOs to set
	 */
	public void setBkgBookingVOs(List<BkgBookingVO> bkgBookingVOs) {
		this.bkgBookingVOs = bkgBookingVOs;
	}
	/**
	 * @return the bkgCustomerVOs
	 */
	public List<BkgCustomerVO> getBkgCustomerVOs() {
		return bkgCustomerVOs;
	}
	/**
	 * @param bkgCustomerVOs the bkgCustomerVOs to set
	 */
	public void setBkgCustomerVOs(List<BkgCustomerVO> bkgCustomerVOs) {
		this.bkgCustomerVOs = bkgCustomerVOs;
	}
	/**
	 * @return the bkgVvdVOs
	 */
	public List<BkgVvdVO> getBkgVvdVOs() {
		return bkgVvdVOs;
	}
	/**
	 * @param bkgVvdVOs the bkgVvdVOs to set
	 */
	public void setBkgVvdVOs(List<BkgVvdVO> bkgVvdVOs) {
		this.bkgVvdVOs = bkgVvdVOs;
	}
	/**
	 * @return the bkgQuantityVOs
	 */
	public List<BkgQuantityVO> getBkgQuantityVOs() {
		return bkgQuantityVOs;
	}
	/**
	 * @param bkgQuantityVOs the bkgQuantityVOs to set
	 */
	public void setBkgQuantityVOs(List<BkgQuantityVO> bkgQuantityVOs) {
		this.bkgQuantityVOs = bkgQuantityVOs;
	}
	/**
	 * @return the bkgQtyDtlVOs
	 */
	public List<BkgQtyDtlVO> getBkgQtyDtlVOs() {
		return bkgQtyDtlVOs;
	}
	/**
	 * @param bkgQtyDtlVOs the bkgQtyDtlVOs to set
	 */
	public void setBkgQtyDtlVOs(List<BkgQtyDtlVO> bkgQtyDtlVOs) {
		this.bkgQtyDtlVOs = bkgQtyDtlVOs;
	}
	/**
	 * @return the bkgCntcPsonVOs
	 */
	public List<BkgCntcPsonVO> getBkgCntcPsonVOs() {
		return bkgCntcPsonVOs;
	}
	/**
	 * @param bkgCntcPsonVOs the bkgCntcPsonVOs to set
	 */
	public void setBkgCntcPsonVOs(List<BkgCntcPsonVO> bkgCntcPsonVOs) {
		this.bkgCntcPsonVOs = bkgCntcPsonVOs;
	}
	/**
	 * @return the bkgReferenceVOs
	 */
	public List<BkgReferenceVO> getBkgReferenceVOs() {
		return bkgReferenceVOs;
	}
	/**
	 * @param bkgReferenceVOs the bkgReferenceVOs to set
	 */
	public void setBkgReferenceVOs(List<BkgReferenceVO> bkgReferenceVOs) {
		this.bkgReferenceVOs = bkgReferenceVOs;
	}
	/**
	 * @return the bkgRefDtlVOs
	 */
	public List<BkgRefDtlVO> getBkgRefDtlVOs() {
		return bkgRefDtlVOs;
	}
	/**
	 * @param bkgRefDtlVOs the bkgRefDtlVOs to set
	 */
	public void setBkgRefDtlVOs(List<BkgRefDtlVO> bkgRefDtlVOs) {
		this.bkgRefDtlVOs = bkgRefDtlVOs;
	}
	/**
	 * @return the bkgContainerVOs
	 */
	public List<BkgContainerVO> getBkgContainerVOs() {
		return bkgContainerVOs;
	}
	/**
	 * @param bkgContainerVOs the bkgContainerVOs to set
	 */
	public void setBkgContainerVOs(List<BkgContainerVO> bkgContainerVOs) {
		this.bkgContainerVOs = bkgContainerVOs;
	}
	/**
	 * @return the bkgCntrSealNoVOs
	 */
	public List<BkgCntrSealNoVO> getBkgCntrSealNoVOs() {
		return bkgCntrSealNoVOs;
	}
	/**
	 * @param bkgCntrSealNoVOs the bkgCntrSealNoVOs to set
	 */
	public void setBkgCntrSealNoVOs(List<BkgCntrSealNoVO> bkgCntrSealNoVOs) {
		this.bkgCntrSealNoVOs = bkgCntrSealNoVOs;
	}
	/**
	 * @return the bkgCntrMfDescVOs
	 */
	public List<BkgCntrMfDescVO> getBkgCntrMfDescVOs() {
		return bkgCntrMfDescVOs;
	}
	/**
	 * @param bkgCntrMfDescVOs the bkgCntrMfDescVOs to set
	 */
	public void setBkgCntrMfDescVOs(List<BkgCntrMfDescVO> bkgCntrMfDescVOs) {
		this.bkgCntrMfDescVOs = bkgCntrMfDescVOs;
	}
	/**
	 * @return the bkgClzTmVOs
	 */
	public List<BkgClzTmVO> getBkgClzTmVOs() {
		return bkgClzTmVOs;
	}
	/**
	 * @param bkgClzTmVOs the bkgClzTmVOs to set
	 */
	public void setBkgClzTmVOs(List<BkgClzTmVO> bkgClzTmVOs) {
		this.bkgClzTmVOs = bkgClzTmVOs;
	}
	/**
	 * @return the bkgBlDocVOs
	 */
	public List<BkgBlDocVO> getBkgBlDocVOs() {
		return bkgBlDocVOs;
	}
	/**
	 * @param bkgBlDocVOs the bkgBlDocVOs to set
	 */
	public void setBkgBlDocVOs(List<BkgBlDocVO> bkgBlDocVOs) {
		this.bkgBlDocVOs = bkgBlDocVOs;
	}
	/**
	 * @return the bkgBlMkDescVOs
	 */
	public List<BkgBlMkDescVO> getBkgBlMkDescVOs() {
		return bkgBlMkDescVOs;
	}
	/**
	 * @param bkgBlMkDescVOs the bkgBlMkDescVOs to set
	 */
	public void setBkgBlMkDescVOs(List<BkgBlMkDescVO> bkgBlMkDescVOs) {
		this.bkgBlMkDescVOs = bkgBlMkDescVOs;
	}
	/**
	 * @return the bkgHblVOs
	 */
	public List<BkgHblVO> getBkgHblVOs() {
		return bkgHblVOs;
	}
	/**
	 * @param bkgHblVOs the bkgHblVOs to set
	 */
	public void setBkgHblVOs(List<BkgHblVO> bkgHblVOs) {
		this.bkgHblVOs = bkgHblVOs;
	}
	/**
	 * @return the bkgHblCustVOs
	 */
	public List<BkgHblCustVO> getBkgHblCustVOs() {
		return bkgHblCustVOs;
	}
	/**
	 * @param bkgHblCustVOs the bkgHblCustVOs to set
	 */
	public void setBkgHblCustVOs(List<BkgHblCustVO> bkgHblCustVOs) {
		this.bkgHblCustVOs = bkgHblCustVOs;
	}
	/**
	 * @return the bkgUsaCstmsFileNoVOs
	 */
	public List<BkgUsaCstmsFileNoVO> getBkgUsaCstmsFileNoVOs() {
		return bkgUsaCstmsFileNoVOs;
	}
	/**
	 * @param bkgUsaCstmsFileNoVOs the bkgUsaCstmsFileNoVOs to set
	 */
	public void setBkgUsaCstmsFileNoVOs(
			List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVOs) {
		this.bkgUsaCstmsFileNoVOs = bkgUsaCstmsFileNoVOs;
	}
	/**
	 * @return the bkgXptImpLicVOs
	 */
	public List<BkgXptImpLicVO> getBkgXptImpLicVOs() {
		return bkgXptImpLicVOs;
	}
	/**
	 * @param bkgXptImpLicVOs the bkgXptImpLicVOs to set
	 */
	public void setBkgXptImpLicVOs(List<BkgXptImpLicVO> bkgXptImpLicVOs) {
		this.bkgXptImpLicVOs = bkgXptImpLicVOs;
	}
	/**
	 * @return the bkgDgCgoVOs
	 */
	public List<BkgDgCgoVO> getBkgDgCgoVOs() {
		return bkgDgCgoVOs;
	}
	/**
	 * @param bkgDgCgoVOs the bkgDgCgoVOs to set
	 */
	public void setBkgDgCgoVOs(List<BkgDgCgoVO> bkgDgCgoVOs) {
		this.bkgDgCgoVOs = bkgDgCgoVOs;
	}
	/**
	 * @return the bkgRfCgoVOs
	 */
	public List<BkgRfCgoVO> getBkgRfCgoVOs() {
		return bkgRfCgoVOs;
	}
	/**
	 * @param bkgRfCgoVOs the bkgRfCgoVOs to set
	 */
	public void setBkgRfCgoVOs(List<BkgRfCgoVO> bkgRfCgoVOs) {
		this.bkgRfCgoVOs = bkgRfCgoVOs;
	}
	/**
	 * @return the bkgAwkCgoVOs
	 */
	public List<BkgAwkCgoVO> getBkgAwkCgoVOs() {
		return bkgAwkCgoVOs;
	}
	/**
	 * @param bkgAwkCgoVOs the bkgAwkCgoVOs to set
	 */
	public void setBkgAwkCgoVOs(List<BkgAwkCgoVO> bkgAwkCgoVOs) {
		this.bkgAwkCgoVOs = bkgAwkCgoVOs;
	}
	/**
	 * @return the bkgAwkDimVOs
	 */
	public List<BkgAwkDimVO> getBkgAwkDimVOs() {
		return bkgAwkDimVOs;
	}
	/**
	 * @param bkgAwkDimVOs the bkgAwkDimVOs to set
	 */
	public void setBkgAwkDimVOs(List<BkgAwkDimVO> bkgAwkDimVOs) {
		this.bkgAwkDimVOs = bkgAwkDimVOs;
	}
	/**
	 * @return the bkgBbCgoVOs
	 */
	public List<BkgBbCgoVO> getBkgBbCgoVOs() {
		return bkgBbCgoVOs;
	}
	/**
	 * @param bkgBbCgoVOs the bkgBbCgoVOs to set
	 */
	public void setBkgBbCgoVOs(List<BkgBbCgoVO> bkgBbCgoVOs) {
		this.bkgBbCgoVOs = bkgBbCgoVOs;
	}
	/**
	 * @return the bkgTroVOs
	 */
	public List<BkgTroVO> getBkgTroVOs() {
		return bkgTroVOs;
	}
	/**
	 * @param bkgTroVOs the bkgTroVOs to set
	 */
	public void setBkgTroVOs(List<BkgTroVO> bkgTroVOs) {
		this.bkgTroVOs = bkgTroVOs;
	}
	/**
	 * @return the bkgTroDtlVOs
	 */
	public List<BkgTroDtlVO> getBkgTroDtlVOs() {
		return bkgTroDtlVOs;
	}
	/**
	 * @param bkgTroDtlVOs the bkgTroDtlVOs to set
	 */
	public void setBkgTroDtlVOs(List<BkgTroDtlVO> bkgTroDtlVOs) {
		this.bkgTroDtlVOs = bkgTroDtlVOs;
	}
	/**
	 * @return the bkgTroSpclCgoSeqVOs
	 */
	public List<BkgTroSpclCgoSeqVO> getBkgTroSpclCgoSeqVOs() {
		return bkgTroSpclCgoSeqVOs;
	}
	/**
	 * @param bkgTroSpclCgoSeqVOs the bkgTroSpclCgoSeqVOs to set
	 */
	public void setBkgTroSpclCgoSeqVOs(List<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs) {
		this.bkgTroSpclCgoSeqVOs = bkgTroSpclCgoSeqVOs;
	}
	/**
	 * @return the bkgEurTroVOs
	 */
	public List<BkgEurTroVO> getBkgEurTroVOs() {
		return bkgEurTroVOs;
	}
	/**
	 * @param bkgEurTroVOs the bkgEurTroVOs to set
	 */
	public void setBkgEurTroVOs(List<BkgEurTroVO> bkgEurTroVOs) {
		this.bkgEurTroVOs = bkgEurTroVOs;
	}
	/**
	 * @return the bkgEurTroDtlVOs
	 */
	public List<BkgEurTroDtlVO> getBkgEurTroDtlVOs() {
		return bkgEurTroDtlVOs;
	}
	/**
	 * @param bkgEurTroDtlVOs the bkgEurTroDtlVOs to set
	 */
	public void setBkgEurTroDtlVOs(List<BkgEurTroDtlVO> bkgEurTroDtlVOs) {
		this.bkgEurTroDtlVOs = bkgEurTroDtlVOs;
	}
	/**
	 * @return the bkgEurTroDgSeqVOs
	 */
	public List<BkgEurTroDgSeqVO> getBkgEurTroDgSeqVOs() {
		return bkgEurTroDgSeqVOs;
	}
	/**
	 * @param bkgEurTroDgSeqVOs the bkgEurTroDgSeqVOs to set
	 */
	public void setBkgEurTroDgSeqVOs(List<BkgEurTroDgSeqVO> bkgEurTroDgSeqVOs) {
		this.bkgEurTroDgSeqVOs = bkgEurTroDgSeqVOs;
	}
	/**
	 * @return the bkgRateVOs
	 */
	public List<BkgRateVO> getBkgRateVOs() {
		return bkgRateVOs;
	}
	/**
	 * @param bkgRateVOs the bkgRateVOs to set
	 */
	public void setBkgRateVOs(List<BkgRateVO> bkgRateVOs) {
		this.bkgRateVOs = bkgRateVOs;
	}
	/**
	 * @return the bkgChgRtVOs
	 */
	public List<BkgChgRtVO> getBkgChgRtVOs() {
		return bkgChgRtVOs;
	}
	/**
	 * @param bkgChgRtVOs the bkgChgRtVOs to set
	 */
	public void setBkgChgRtVOs(List<BkgChgRtVO> bkgChgRtVOs) {
		this.bkgChgRtVOs = bkgChgRtVOs;
	}
	/**
	 * @return the bkgBlIssVOs
	 */
	public List<BkgBlIssVO> getBkgBlIssVOs() {
		return bkgBlIssVOs;
	}
	/**
	 * @param bkgBlIssVOs the bkgBlIssVOs to set
	 */
	public void setBkgBlIssVOs(List<BkgBlIssVO> bkgBlIssVOs) {
		this.bkgBlIssVOs = bkgBlIssVOs;
	}
	/**
	 * @return the bkgStwgCgoVOs
	 */
	public List<BkgStwgCgoVO> getBkgStwgCgoVOs() {
		return bkgStwgCgoVOs;
	}
	/**
	 * @param bkgStwgCgoVOs the bkgStwgCgoVOs to set
	 */
	public void setBkgStwgCgoVOs(List<BkgStwgCgoVO> bkgStwgCgoVOs) {
		this.bkgStwgCgoVOs = bkgStwgCgoVOs;
	}
	/**
	 * @return the bkgBookingVO
	 */
	public BkgBookingVO getBkgBookingVO() {
		return bkgBookingVO;
	}
	/**
	 * @param bkgBookingVO the bkgBookingVO to set
	 */
	public void setBkgBookingVO(BkgBookingVO bkgBookingVO) {
		this.bkgBookingVO = bkgBookingVO;
	}
	/**
	 * @return the bkgCustomerVO
	 */
	public BkgCustomerVO getBkgCustomerVO() {
		return bkgCustomerVO;
	}
	/**
	 * @param bkgCustomerVO the bkgCustomerVO to set
	 */
	public void setBkgCustomerVO(BkgCustomerVO bkgCustomerVO) {
		this.bkgCustomerVO = bkgCustomerVO;
	}
	/**
	 * @return the bkgVvdVO
	 */
	public BkgVvdVO getBkgVvdVO() {
		return bkgVvdVO;
	}
	/**
	 * @param bkgVvdVO the bkgVvdVO to set
	 */
	public void setBkgVvdVO(BkgVvdVO bkgVvdVO) {
		this.bkgVvdVO = bkgVvdVO;
	}
	/**
	 * @return the bkgQuantityVO
	 */
	public BkgQuantityVO getBkgQuantityVO() {
		return bkgQuantityVO;
	}
	/**
	 * @param bkgQuantityVO the bkgQuantityVO to set
	 */
	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO) {
		this.bkgQuantityVO = bkgQuantityVO;
	}
	/**
	 * @return the bkgQtyDtlVO
	 */
	public BkgQtyDtlVO getBkgQtyDtlVO() {
		return bkgQtyDtlVO;
	}
	/**
	 * @param bkgQtyDtlVO the bkgQtyDtlVO to set
	 */
	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO) {
		this.bkgQtyDtlVO = bkgQtyDtlVO;
	}
	/**
	 * @return the bkgCntcPsonVO
	 */
	public BkgCntcPsonVO getBkgCntcPsonVO() {
		return bkgCntcPsonVO;
	}
	/**
	 * @param bkgCntcPsonVO the bkgCntcPsonVO to set
	 */
	public void setBkgCntcPsonVO(BkgCntcPsonVO bkgCntcPsonVO) {
		this.bkgCntcPsonVO = bkgCntcPsonVO;
	}
	/**
	 * @return the bkgReferenceVO
	 */
	public BkgReferenceVO getBkgReferenceVO() {
		return bkgReferenceVO;
	}
	/**
	 * @param bkgReferenceVO the bkgReferenceVO to set
	 */
	public void setBkgReferenceVO(BkgReferenceVO bkgReferenceVO) {
		this.bkgReferenceVO = bkgReferenceVO;
	}
	/**
	 * @return the bkgRefDtlVO
	 */
	public BkgRefDtlVO getBkgRefDtlVO() {
		return bkgRefDtlVO;
	}
	/**
	 * @param bkgRefDtlVO the bkgRefDtlVO to set
	 */
	public void setBkgRefDtlVO(BkgRefDtlVO bkgRefDtlVO) {
		this.bkgRefDtlVO = bkgRefDtlVO;
	}
	/**
	 * @return the bkgContainerVO
	 */
	public BkgContainerVO getBkgContainerVO() {
		return bkgContainerVO;
	}
	/**
	 * @param bkgContainerVO the bkgContainerVO to set
	 */
	public void setBkgContainerVO(BkgContainerVO bkgContainerVO) {
		this.bkgContainerVO = bkgContainerVO;
	}
	/**
	 * @return the bkgCntrSealNoVO
	 */
	public BkgCntrSealNoVO getBkgCntrSealNoVO() {
		return bkgCntrSealNoVO;
	}
	/**
	 * @param bkgCntrSealNoVO the bkgCntrSealNoVO to set
	 */
	public void setBkgCntrSealNoVO(BkgCntrSealNoVO bkgCntrSealNoVO) {
		this.bkgCntrSealNoVO = bkgCntrSealNoVO;
	}
	/**
	 * @return the bkgCntrMfDescVO
	 */
	public BkgCntrMfDescVO getBkgCntrMfDescVO() {
		return bkgCntrMfDescVO;
	}
	/**
	 * @param bkgCntrMfDescVO the bkgCntrMfDescVO to set
	 */
	public void setBkgCntrMfDescVO(BkgCntrMfDescVO bkgCntrMfDescVO) {
		this.bkgCntrMfDescVO = bkgCntrMfDescVO;
	}
	/**
	 * @return the bkgClzTmVO
	 */
	public BkgClzTmVO getBkgClzTmVO() {
		return bkgClzTmVO;
	}
	/**
	 * @param bkgClzTmVO the bkgClzTmVO to set
	 */
	public void setBkgClzTmVO(BkgClzTmVO bkgClzTmVO) {
		this.bkgClzTmVO = bkgClzTmVO;
	}
	/**
	 * @return the bkgBlDocVO
	 */
	public BkgBlDocVO getBkgBlDocVO() {
		return bkgBlDocVO;
	}
	/**
	 * @param bkgBlDocVO the bkgBlDocVO to set
	 */
	public void setBkgBlDocVO(BkgBlDocVO bkgBlDocVO) {
		this.bkgBlDocVO = bkgBlDocVO;
	}
	/**
	 * @return the bkgBlMkDescVO
	 */
	public BkgBlMkDescVO getBkgBlMkDescVO() {
		return bkgBlMkDescVO;
	}
	/**
	 * @param bkgBlMkDescVO the bkgBlMkDescVO to set
	 */
	public void setBkgBlMkDescVO(BkgBlMkDescVO bkgBlMkDescVO) {
		this.bkgBlMkDescVO = bkgBlMkDescVO;
	}
	/**
	 * @return the bkgHblVO
	 */
	public BkgHblVO getBkgHblVO() {
		return bkgHblVO;
	}
	/**
	 * @param bkgHblVO the bkgHblVO to set
	 */
	public void setBkgHblVO(BkgHblVO bkgHblVO) {
		this.bkgHblVO = bkgHblVO;
	}
	/**
	 * @return the bkgHblCustVO
	 */
	public BkgHblCustVO getBkgHblCustVO() {
		return bkgHblCustVO;
	}
	/**
	 * @param bkgHblCustVO the bkgHblCustVO to set
	 */
	public void setBkgHblCustVO(BkgHblCustVO bkgHblCustVO) {
		this.bkgHblCustVO = bkgHblCustVO;
	}
	/**
	 * @return the bkgUsaCstmsFileNoVO
	 */
	public BkgUsaCstmsFileNoVO getBkgUsaCstmsFileNoVO() {
		return bkgUsaCstmsFileNoVO;
	}
	/**
	 * @param bkgUsaCstmsFileNoVO the bkgUsaCstmsFileNoVO to set
	 */
	public void setBkgUsaCstmsFileNoVO(BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO) {
		this.bkgUsaCstmsFileNoVO = bkgUsaCstmsFileNoVO;
	}
	/**
	 * @return the bkgXptImpLicVO
	 */
	public BkgXptImpLicVO getBkgXptImpLicVO() {
		return bkgXptImpLicVO;
	}
	/**
	 * @param bkgXptImpLicVO the bkgXptImpLicVO to set
	 */
	public void setBkgXptImpLicVO(BkgXptImpLicVO bkgXptImpLicVO) {
		this.bkgXptImpLicVO = bkgXptImpLicVO;
	}
	/**
	 * @return the bkgDgCgoVO
	 */
	public BkgDgCgoVO getBkgDgCgoVO() {
		return bkgDgCgoVO;
	}
	/**
	 * @param bkgDgCgoVO the bkgDgCgoVO to set
	 */
	public void setBkgDgCgoVO(BkgDgCgoVO bkgDgCgoVO) {
		this.bkgDgCgoVO = bkgDgCgoVO;
	}
	/**
	 * @return the bkgRfCgoVO
	 */
	public BkgRfCgoVO getBkgRfCgoVO() {
		return bkgRfCgoVO;
	}
	/**
	 * @param bkgRfCgoVO the bkgRfCgoVO to set
	 */
	public void setBkgRfCgoVO(BkgRfCgoVO bkgRfCgoVO) {
		this.bkgRfCgoVO = bkgRfCgoVO;
	}
	/**
	 * @return the bkgAwkCgoVO
	 */
	public BkgAwkCgoVO getBkgAwkCgoVO() {
		return bkgAwkCgoVO;
	}
	/**
	 * @param bkgAwkCgoVO the bkgAwkCgoVO to set
	 */
	public void setBkgAwkCgoVO(BkgAwkCgoVO bkgAwkCgoVO) {
		this.bkgAwkCgoVO = bkgAwkCgoVO;
	}
	/**
	 * @return the bkgAwkDimVO
	 */
	public BkgAwkDimVO getBkgAwkDimVO() {
		return bkgAwkDimVO;
	}
	/**
	 * @param bkgAwkDimVO the bkgAwkDimVO to set
	 */
	public void setBkgAwkDimVO(BkgAwkDimVO bkgAwkDimVO) {
		this.bkgAwkDimVO = bkgAwkDimVO;
	}
	/**
	 * @return the bkgBbCgoVO
	 */
	public BkgBbCgoVO getBkgBbCgoVO() {
		return bkgBbCgoVO;
	}
	/**
	 * @param bkgBbCgoVO the bkgBbCgoVO to set
	 */
	public void setBkgBbCgoVO(BkgBbCgoVO bkgBbCgoVO) {
		this.bkgBbCgoVO = bkgBbCgoVO;
	}
	/**
	 * @return the bkgTroVO
	 */
	public BkgTroVO getBkgTroVO() {
		return bkgTroVO;
	}
	/**
	 * @param bkgTroVO the bkgTroVO to set
	 */
	public void setBkgTroVO(BkgTroVO bkgTroVO) {
		this.bkgTroVO = bkgTroVO;
	}
	/**
	 * @return the bkgTroDtlVO
	 */
	public BkgTroDtlVO getBkgTroDtlVO() {
		return bkgTroDtlVO;
	}
	/**
	 * @param bkgTroDtlVO the bkgTroDtlVO to set
	 */
	public void setBkgTroDtlVO(BkgTroDtlVO bkgTroDtlVO) {
		this.bkgTroDtlVO = bkgTroDtlVO;
	}
	/**
	 * @return the bkgTroSpclCgoSeqVO
	 */
	public BkgTroSpclCgoSeqVO getBkgTroSpclCgoSeqVO() {
		return bkgTroSpclCgoSeqVO;
	}
	/**
	 * @param bkgTroSpclCgoSeqVO the bkgTroSpclCgoSeqVO to set
	 */
	public void setBkgTroSpclCgoSeqVO(BkgTroSpclCgoSeqVO bkgTroSpclCgoSeqVO) {
		this.bkgTroSpclCgoSeqVO = bkgTroSpclCgoSeqVO;
	}
	/**
	 * @return the bkgEurTroVO
	 */
	public BkgEurTroVO getBkgEurTroVO() {
		return bkgEurTroVO;
	}
	/**
	 * @param bkgEurTroVO the bkgEurTroVO to set
	 */
	public void setBkgEurTroVO(BkgEurTroVO bkgEurTroVO) {
		this.bkgEurTroVO = bkgEurTroVO;
	}
	/**
	 * @return the bkgEurTroDtlVO
	 */
	public BkgEurTroDtlVO getBkgEurTroDtlVO() {
		return bkgEurTroDtlVO;
	}
	/**
	 * @param bkgEurTroDtlVO the bkgEurTroDtlVO to set
	 */
	public void setBkgEurTroDtlVO(BkgEurTroDtlVO bkgEurTroDtlVO) {
		this.bkgEurTroDtlVO = bkgEurTroDtlVO;
	}
	/**
	 * @return the bkgEurTroDgSeqVO
	 */
	public BkgEurTroDgSeqVO getBkgEurTroDgSeqVO() {
		return bkgEurTroDgSeqVO;
	}
	/**
	 * @param bkgEurTroDgSeqVO the bkgEurTroDgSeqVO to set
	 */
	public void setBkgEurTroDgSeqVO(BkgEurTroDgSeqVO bkgEurTroDgSeqVO) {
		this.bkgEurTroDgSeqVO = bkgEurTroDgSeqVO;
	}
	/**
	 * @return the bkgRateVO
	 */
	public BkgRateVO getBkgRateVO() {
		return bkgRateVO;
	}
	/**
	 * @param bkgRateVO the bkgRateVO to set
	 */
	public void setBkgRateVO(BkgRateVO bkgRateVO) {
		this.bkgRateVO = bkgRateVO;
	}
	/**
	 * @return the bkgChgRtVO
	 */
	public BkgChgRtVO getBkgChgRtVO() {
		return bkgChgRtVO;
	}
	/**
	 * @param bkgChgRtVO the bkgChgRtVO to set
	 */
	public void setBkgChgRtVO(BkgChgRtVO bkgChgRtVO) {
		this.bkgChgRtVO = bkgChgRtVO;
	}
	/**
	 * @return the bkgBlIssVO
	 */
	public BkgBlIssVO getBkgBlIssVO() {
		return bkgBlIssVO;
	}
	/**
	 * @param bkgBlIssVO the bkgBlIssVO to set
	 */
	public void setBkgBlIssVO(BkgBlIssVO bkgBlIssVO) {
		this.bkgBlIssVO = bkgBlIssVO;
	}
	//<- 미사용
//	/**
//	 * @return the arrBkgBookingVO
//	 */
//	public BkgBookingVO[] getArrBkgBookingVO() {
//		return arrBkgBookingVO;
//	}
//	/**
//	 * @param arrBkgBookingVO the arrBkgBookingVO to set
//	 */
//	public void setArrBkgBookingVO(BkgBookingVO[] arrBkgBookingVO) {
//		this.arrBkgBookingVO = arrBkgBookingVO;
//	}
//	/**
//	 * @return the arrBkgCustomerVO
//	 */
//	public BkgCustomerVO[] getArrBkgCustomerVO() {
//		return arrBkgCustomerVO;
//	}
//	/**
//	 * @param arrBkgCustomerVO the arrBkgCustomerVO to set
//	 */
//	public void setArrBkgCustomerVO(BkgCustomerVO[] arrBkgCustomerVO) {
//		this.arrBkgCustomerVO = arrBkgCustomerVO;
//	}
//	/**
//	 * @return the arrBkgVvdVO
//	 */
//	public BkgVvdVO[] getArrBkgVvdVO() {
//		return arrBkgVvdVO;
//	}
//	/**
//	 * @param arrBkgVvdVO the arrBkgVvdVO to set
//	 */
//	public void setArrBkgVvdVO(BkgVvdVO[] arrBkgVvdVO) {
//		this.arrBkgVvdVO = arrBkgVvdVO;
//	}
//	/**
//	 * @return the arrBkgQuantityVO
//	 */
//	public BkgQuantityVO[] getArrBkgQuantityVO() {
//		return arrBkgQuantityVO;
//	}
//	/**
//	 * @param arrBkgQuantityVO the arrBkgQuantityVO to set
//	 */
//	public void setArrBkgQuantityVO(BkgQuantityVO[] arrBkgQuantityVO) {
//		this.arrBkgQuantityVO = arrBkgQuantityVO;
//	}
//	/**
//	 * @return the arrBkgQtyDtlVO
//	 */
//	public BkgQtyDtlVO[] getArrBkgQtyDtlVO() {
//		return arrBkgQtyDtlVO;
//	}
//	/**
//	 * @param arrBkgQtyDtlVO the arrBkgQtyDtlVO to set
//	 */
//	public void setArrBkgQtyDtlVO(BkgQtyDtlVO[] arrBkgQtyDtlVO) {
//		this.arrBkgQtyDtlVO = arrBkgQtyDtlVO;
//	}
//	/**
//	 * @return the arrBkgCntcPsonVO
//	 */
//	public BkgCntcPsonVO[] getArrBkgCntcPsonVO() {
//		return arrBkgCntcPsonVO;
//	}
//	/**
//	 * @param arrBkgCntcPsonVO the arrBkgCntcPsonVO to set
//	 */
//	public void setArrBkgCntcPsonVO(BkgCntcPsonVO[] arrBkgCntcPsonVO) {
//		this.arrBkgCntcPsonVO = arrBkgCntcPsonVO;
//	}
//	/**
//	 * @return the arrBkgReferenceVO
//	 */
//	public BkgReferenceVO[] getArrBkgReferenceVO() {
//		return arrBkgReferenceVO;
//	}
//	/**
//	 * @param arrBkgReferenceVO the arrBkgReferenceVO to set
//	 */
//	public void setArrBkgReferenceVO(BkgReferenceVO[] arrBkgReferenceVO) {
//		this.arrBkgReferenceVO = arrBkgReferenceVO;
//	}
//	/**
//	 * @return the arrBkgRefDtlVO
//	 */
//	public BkgRefDtlVO[] getArrBkgRefDtlVO() {
//		return arrBkgRefDtlVO;
//	}
//	/**
//	 * @param arrBkgRefDtlVO the arrBkgRefDtlVO to set
//	 */
//	public void setArrBkgRefDtlVO(BkgRefDtlVO[] arrBkgRefDtlVO) {
//		this.arrBkgRefDtlVO = arrBkgRefDtlVO;
//	}
//	/**
//	 * @return the arrBkgContainerVO
//	 */
//	public BkgContainerVO[] getArrBkgContainerVO() {
//		return arrBkgContainerVO;
//	}
//	/**
//	 * @param arrBkgContainerVO the arrBkgContainerVO to set
//	 */
//	public void setArrBkgContainerVO(BkgContainerVO[] arrBkgContainerVO) {
//		this.arrBkgContainerVO = arrBkgContainerVO;
//	}
//	/**
//	 * @return the arrBkgCntrSealNoVO
//	 */
//	public BkgCntrSealNoVO[] getArrBkgCntrSealNoVO() {
//		return arrBkgCntrSealNoVO;
//	}
//	/**
//	 * @param arrBkgCntrSealNoVO the arrBkgCntrSealNoVO to set
//	 */
//	public void setArrBkgCntrSealNoVO(BkgCntrSealNoVO[] arrBkgCntrSealNoVO) {
//		this.arrBkgCntrSealNoVO = arrBkgCntrSealNoVO;
//	}
//	/**
//	 * @return the arrBkgCntrMfDescVO
//	 */
//	public BkgCntrMfDescVO[] getArrBkgCntrMfDescVO() {
//		return arrBkgCntrMfDescVO;
//	}
//	/**
//	 * @param arrBkgCntrMfDescVO the arrBkgCntrMfDescVO to set
//	 */
//	public void setArrBkgCntrMfDescVO(BkgCntrMfDescVO[] arrBkgCntrMfDescVO) {
//		this.arrBkgCntrMfDescVO = arrBkgCntrMfDescVO;
//	}
//	/**
//	 * @return the arrBkgClzTmVO
//	 */
//	public BkgClzTmVO[] getArrBkgClzTmVO() {
//		return arrBkgClzTmVO;
//	}
//	/**
//	 * @param arrBkgClzTmVO the arrBkgClzTmVO to set
//	 */
//	public void setArrBkgClzTmVO(BkgClzTmVO[] arrBkgClzTmVO) {
//		this.arrBkgClzTmVO = arrBkgClzTmVO;
//	}
//	/**
//	 * @return the arrBkgBlDocVO
//	 */
//	public BkgBlDocVO[] getArrBkgBlDocVO() {
//		return arrBkgBlDocVO;
//	}
//	/**
//	 * @param arrBkgBlDocVO the arrBkgBlDocVO to set
//	 */
//	public void setArrBkgBlDocVO(BkgBlDocVO[] arrBkgBlDocVO) {
//		this.arrBkgBlDocVO = arrBkgBlDocVO;
//	}
//	/**
//	 * @return the arrBkgBlMkDescVO
//	 */
//	public BkgBlMkDescVO[] getArrBkgBlMkDescVO() {
//		return arrBkgBlMkDescVO;
//	}
//	/**
//	 * @param arrBkgBlMkDescVO the arrBkgBlMkDescVO to set
//	 */
//	public void setArrBkgBlMkDescVO(BkgBlMkDescVO[] arrBkgBlMkDescVO) {
//		this.arrBkgBlMkDescVO = arrBkgBlMkDescVO;
//	}
//	/**
//	 * @return the arrBkgHblVO
//	 */
//	public BkgHblVO[] getArrBkgHblVO() {
//		return arrBkgHblVO;
//	}
//	/**
//	 * @param arrBkgHblVO the arrBkgHblVO to set
//	 */
//	public void setArrBkgHblVO(BkgHblVO[] arrBkgHblVO) {
//		this.arrBkgHblVO = arrBkgHblVO;
//	}
//	/**
//	 * @return the arrBkgHblCustVO
//	 */
//	public BkgHblCustVO[] getArrBkgHblCustVO() {
//		return arrBkgHblCustVO;
//	}
//	/**
//	 * @param arrBkgHblCustVO the arrBkgHblCustVO to set
//	 */
//	public void setArrBkgHblCustVO(BkgHblCustVO[] arrBkgHblCustVO) {
//		this.arrBkgHblCustVO = arrBkgHblCustVO;
//	}
//	/**
//	 * @return the arrBkgUsaCstmsFileNoVO
//	 */
//	public BkgUsaCstmsFileNoVO[] getArrBkgUsaCstmsFileNoVO() {
//		return arrBkgUsaCstmsFileNoVO;
//	}
//	/**
//	 * @param arrBkgUsaCstmsFileNoVO the arrBkgUsaCstmsFileNoVO to set
//	 */
//	public void setArrBkgUsaCstmsFileNoVO(
//			BkgUsaCstmsFileNoVO[] arrBkgUsaCstmsFileNoVO) {
//		this.arrBkgUsaCstmsFileNoVO = arrBkgUsaCstmsFileNoVO;
//	}
//	/**
//	 * @return the arrBkgXptImpLicVO
//	 */
//	public BkgXptImpLicVO[] getArrBkgXptImpLicVO() {
//		return arrBkgXptImpLicVO;
//	}
//	/**
//	 * @param arrBkgXptImpLicVO the arrBkgXptImpLicVO to set
//	 */
//	public void setArrBkgXptImpLicVO(BkgXptImpLicVO[] arrBkgXptImpLicVO) {
//		this.arrBkgXptImpLicVO = arrBkgXptImpLicVO;
//	}
//	/**
//	 * @return the arrBkgDgCgoVO
//	 */
//	public BkgDgCgoVO[] getArrBkgDgCgoVO() {
//		return arrBkgDgCgoVO;
//	}
//	/**
//	 * @param arrBkgDgCgoVO the arrBkgDgCgoVO to set
//	 */
//	public void setArrBkgDgCgoVO(BkgDgCgoVO[] arrBkgDgCgoVO) {
//		this.arrBkgDgCgoVO = arrBkgDgCgoVO;
//	}
//	/**
//	 * @return the arrBkgRfCgoVO
//	 */
//	public BkgRfCgoVO[] getArrBkgRfCgoVO() {
//		return arrBkgRfCgoVO;
//	}
//	/**
//	 * @param arrBkgRfCgoVO the arrBkgRfCgoVO to set
//	 */
//	public void setArrBkgRfCgoVO(BkgRfCgoVO[] arrBkgRfCgoVO) {
//		this.arrBkgRfCgoVO = arrBkgRfCgoVO;
//	}
//	/**
//	 * @return the arrBkgAwkCgoVO
//	 */
//	public BkgAwkCgoVO[] getArrBkgAwkCgoVO() {
//		return arrBkgAwkCgoVO;
//	}
//	/**
//	 * @param arrBkgAwkCgoVO the arrBkgAwkCgoVO to set
//	 */
//	public void setArrBkgAwkCgoVO(BkgAwkCgoVO[] arrBkgAwkCgoVO) {
//		this.arrBkgAwkCgoVO = arrBkgAwkCgoVO;
//	}
//	/**
//	 * @return the arrBkgAwkDimVO
//	 */
//	public BkgAwkDimVO[] getArrBkgAwkDimVO() {
//		return arrBkgAwkDimVO;
//	}
//	/**
//	 * @param arrBkgAwkDimVO the arrBkgAwkDimVO to set
//	 */
//	public void setArrBkgAwkDimVO(BkgAwkDimVO[] arrBkgAwkDimVO) {
//		this.arrBkgAwkDimVO = arrBkgAwkDimVO;
//	}
//	/**
//	 * @return the arrBkgBbCgoVO
//	 */
//	public BkgBbCgoVO[] getArrBkgBbCgoVO() {
//		return arrBkgBbCgoVO;
//	}
//	/**
//	 * @param arrBkgBbCgoVO the arrBkgBbCgoVO to set
//	 */
//	public void setArrBkgBbCgoVO(BkgBbCgoVO[] arrBkgBbCgoVO) {
//		this.arrBkgBbCgoVO = arrBkgBbCgoVO;
//	}
//	/**
//	 * @return the arrBkgTroVO
//	 */
//	public BkgTroVO[] getArrBkgTroVO() {
//		return arrBkgTroVO;
//	}
//	/**
//	 * @param arrBkgTroVO the arrBkgTroVO to set
//	 */
//	public void setArrBkgTroVO(BkgTroVO[] arrBkgTroVO) {
//		this.arrBkgTroVO = arrBkgTroVO;
//	}
//	/**
//	 * @return the arrBkgTroDtlVO
//	 */
//	public BkgTroDtlVO[] getArrBkgTroDtlVO() {
//		return arrBkgTroDtlVO;
//	}
//	/**
//	 * @param arrBkgTroDtlVO the arrBkgTroDtlVO to set
//	 */
//	public void setArrBkgTroDtlVO(BkgTroDtlVO[] arrBkgTroDtlVO) {
//		this.arrBkgTroDtlVO = arrBkgTroDtlVO;
//	}
//	/**
//	 * @return the arrBkgTroSpclCgoSeqVO
//	 */
//	public BkgTroSpclCgoSeqVO[] getArrBkgTroSpclCgoSeqVO() {
//		return arrBkgTroSpclCgoSeqVO;
//	}
//	/**
//	 * @param arrBkgTroSpclCgoSeqVO the arrBkgTroSpclCgoSeqVO to set
//	 */
//	public void setArrBkgTroSpclCgoSeqVO(BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO) {
//		this.arrBkgTroSpclCgoSeqVO = arrBkgTroSpclCgoSeqVO;
//	}
//	/**
//	 * @return the arrBkgEurTroVO
//	 */
//	public BkgEurTroVO[] getArrBkgEurTroVO() {
//		return arrBkgEurTroVO;
//	}
//	/**
//	 * @param arrBkgEurTroVO the arrBkgEurTroVO to set
//	 */
//	public void setArrBkgEurTroVO(BkgEurTroVO[] arrBkgEurTroVO) {
//		this.arrBkgEurTroVO = arrBkgEurTroVO;
//	}
//	/**
//	 * @return the arrBkgEurTroDtlVO
//	 */
//	public BkgEurTroDtlVO[] getArrBkgEurTroDtlVO() {
//		return arrBkgEurTroDtlVO;
//	}
//	/**
//	 * @param arrBkgEurTroDtlVO the arrBkgEurTroDtlVO to set
//	 */
//	public void setArrBkgEurTroDtlVO(BkgEurTroDtlVO[] arrBkgEurTroDtlVO) {
//		this.arrBkgEurTroDtlVO = arrBkgEurTroDtlVO;
//	}
//	/**
//	 * @return the arrBkgEurTroDgSeqVO
//	 */
//	public BkgEurTroDgSeqVO[] getArrBkgEurTroDgSeqVO() {
//		return arrBkgEurTroDgSeqVO;
//	}
//	/**
//	 * @param arrBkgEurTroDgSeqVO the arrBkgEurTroDgSeqVO to set
//	 */
//	public void setArrBkgEurTroDgSeqVO(BkgEurTroDgSeqVO[] arrBkgEurTroDgSeqVO) {
//		this.arrBkgEurTroDgSeqVO = arrBkgEurTroDgSeqVO;
//	}
//	/**
//	 * @return the arrBkgRateVO
//	 */
//	public BkgRateVO[] getArrBkgRateVO() {
//		return arrBkgRateVO;
//	}
//	/**
//	 * @param arrBkgRateVO the arrBkgRateVO to set
//	 */
//	public void setArrBkgRateVO(BkgRateVO[] arrBkgRateVO) {
//		this.arrBkgRateVO = arrBkgRateVO;
//	}
//	/**
//	 * @return the arrBkgChgRtVO
//	 */
//	public BkgChgRtVO[] getArrBkgChgRtVO() {
//		return arrBkgChgRtVO;
//	}
//	/**
//	 * @param arrBkgChgRtVO the arrBkgChgRtVO to set
//	 */
//	public void setArrBkgChgRtVO(BkgChgRtVO[] arrBkgChgRtVO) {
//		this.arrBkgChgRtVO = arrBkgChgRtVO;
//	}
//	
//	/**
//	 * @return the arrBkgDocIssRdemVO
//	 */
//	public BkgDocIssRdemVO[] getArrBkgDocIssRdemVO() {
//		return arrBkgDocIssRdemVO;
//	}
//	/**
//	 * @param arrBkgDocIssRdemVO the arrBkgDocIssRdemVO to set
//	 */
//	public void setArrBkgDocIssRdemVO(BkgDocIssRdemVO[] arrBkgDocIssRdemVO) {
//		this.arrBkgDocIssRdemVO = arrBkgDocIssRdemVO;
//	}
//	
//	/**
//	 * @return the arrBkgBlIssVO
//	 */
//	public BkgBlIssVO[] getArrBkgBlIssVO() {
//		return arrBkgBlIssVO;
//	}
//	/**
//	 * @param arrBkgBlIssVO the arrBkgBlIssVO to set
//	 */
//	public void setArrBkgBlIssVO(BkgBlIssVO[] arrBkgBlIssVO) {
//		this.arrBkgBlIssVO = arrBkgBlIssVO;
//	}

	/**
	 * @return the bkgDocIssRdemVO
	 */
	public BkgDocIssRdemVO getBkgDocIssRdemVO() {
		return bkgDocIssRdemVO;
	}	
	/**
	 * @param bkgDocIssRdemVO the bkgDocIssRdemVO to set
	 */
	public void setBkgDocIssRdemVO(BkgDocIssRdemVO bkgDocIssRdemVO) {
		this.bkgDocIssRdemVO = bkgDocIssRdemVO;
	}
	/**
	 * @return the bkgDocIssRdemVOs
	 */
	public List<BkgDocIssRdemVO> getBkgDocIssRdemVOs() {
		return bkgDocIssRdemVOs;
	}
	/**
	 * @param bkgDocIssRdemVOs the bkgDocIssRdemVOs to set
	 */
	public void setBkgDocIssRdemVOs(List<BkgDocIssRdemVO> bkgDocIssRdemVOs) {
		this.bkgDocIssRdemVOs = bkgDocIssRdemVOs;
	}
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	/**
	 * @return the tableListVOs
	 */
	public List<TableListVO> getTableListVOs() {
		return tableListVOs;
	}
	/**
	 * @param tableListVOs the tableListVOs to set
	 */
	public void setTableListVOs(List<TableListVO> tableListVOs) {
		this.tableListVOs = tableListVOs;
	}
	/**
	 * @return the tableListVO
	 */
	public TableListVO getTableListVO() {
		return tableListVO;
	}
	/**
	 * @param tableListVO the tableListVO to set
	 */
	public void setTableListVO(TableListVO tableListVO) {
		this.tableListVO = tableListVO;
	}
	/**
	 * @return the bkgStwgCgoVO
	 */
	public BkgStwgCgoVO getBkgStwgCgoVO() {
		return bkgStwgCgoVO;
	}
	/**
	 * @param bkgStwgCgoVO the bkgStwgCgoVO to set
	 */
	public void setBkgStwgCgoVO(BkgStwgCgoVO bkgStwgCgoVO) {
		this.bkgStwgCgoVO = bkgStwgCgoVO;
	}
}
