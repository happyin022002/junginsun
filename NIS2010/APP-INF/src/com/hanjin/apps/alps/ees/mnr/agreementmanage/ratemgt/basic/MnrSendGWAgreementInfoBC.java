/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrSendGWAgreementInfoBC.java
*@FileTitle : G/W 전송 xmlData Agreement, AttachFile Info
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.19 Chang Young Kim
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic;
	
import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.framework.core.layer.event.EventException; 
 
/**  
 * G/W as Agreement, AttachFile Info Logic Command Interface<br>
 *
 * @author 	Chang Young Kim 
 * @see 	ComCsrApprovalBCImpl, MnrSendGWAgreementInfoBCImpl 참조
 * @since 	J2EE 1.4  
 */  
 	
public interface MnrSendGWAgreementInfoBC { 
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List (CSR No. + VNDR Seq. + Inv No. 추가)
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement File Info
	 * 
	 * @param csrNo
	 * * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException;
}