/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRExternalFinderBC.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.10.15 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic;

import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.vo.SpCsrVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;


/**
 * NIS2010-Scgcommon Business Logic Command Interface<br>
 * - NIS2010-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Scg_com_EventResponse 참조
 * @since J2EE 1.4
 */

public interface CSRExternalFinderBC {

	/**
	 * CSR_0001 : 공통<br>
	 * vendor체크 조회 처리<br>
	 * @param String vndrSeq
	 * @return SpCsrVO
	 * @exception EventException
	 */
	public SpCsrVO checkVendor(String vndrSeq) throws EventException;
	
	/**
	 * CSR_0008 : 공통<br>
	 * 권한 로케이션 날짜 조회 처리<br>
	 * @param String ofcCd
	 * @return SpCsrVO
	 * @exception EventException
	 */
	public SpCsrVO getDBdate(String ofcCd) throws EventException;
	
	/**
	 * CSR_0002 : 공통<br>
	 * getMDMCntCd 조회 처리<br>
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String getMDMCntCd(String ofcCd) throws EventException;
	
	/**
	 * AP연계 인터페이스 : 공통
	 * AP_PAY_INV 및 AP_PAY_INV_DTL 목록 저장<br>
	 * @param ApPayInvVO apPayInvVO
	 * @param ApPayInvDtlVO[] apPayInvDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createApPayInvInfo(ApPayInvVO apPayInvVO, ApPayInvDtlVO[] apPayInvDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;

 
}