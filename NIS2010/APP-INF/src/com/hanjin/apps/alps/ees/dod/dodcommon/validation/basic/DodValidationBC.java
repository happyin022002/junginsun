/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DropOffInquiryBC.java
*@FileTitle : Drop Off Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.basic;

import com.hanjin.apps.alps.ees.dod.dodcommon.validation.vo.DodValidationINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * DropOffInquiryBC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface DodValidationBC {
	
	/**
	 * OFC_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkOfficeCode(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * CUST_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCustomer(DodValidationINVO dodValidationINVO) throws EventException;

	/**
	 * BKG_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkBkgNo(DodValidationINVO dodValidationINVO) throws EventException;

	/**
	 * CNTR_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCntrNo(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * RFA_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkRfaNo(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * SC_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkScNo(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * TP/SZ 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkTpSz(DodValidationINVO dodValidationINVO) throws EventException;

	/**
	 * LOC_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkLocCd(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * YD_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkYdCd(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * AREA_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkAreaCd(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * CNT_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCntCd(DodValidationINVO dodValidationINVO) throws EventException;
	
	/**
	 * Login한 사용자의 AR Invoice Issue화면 접근권한 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkIssueUser(DodValidationINVO dodValidationINVO) throws EventException;
}
