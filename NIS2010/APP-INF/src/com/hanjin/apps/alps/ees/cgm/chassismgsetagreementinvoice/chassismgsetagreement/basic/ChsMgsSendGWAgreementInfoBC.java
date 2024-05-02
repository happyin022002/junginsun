/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChsMgsSendGWAgreementInfoBC.java
*@FileTitle : G/W 전송 xmlData Agreement Info
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.19 Chang Young Kim
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS ChsMgsSendGWAgreementInfoBC <br>
 * - NIS2010 - G/W 전송 xmlData Agreement Info의 Business Logic에 대한 인터페이스<br>
 * 
 * @author Chang Young Kim
 * @see ComCsrApprovalBCImpl 참조
 * @since J2EE 1.4
 */
public interface ChsMgsSendGWAgreementInfoBC {

	
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
}