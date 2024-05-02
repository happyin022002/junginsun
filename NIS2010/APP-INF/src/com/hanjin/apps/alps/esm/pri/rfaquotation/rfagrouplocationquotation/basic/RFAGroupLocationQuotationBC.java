/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationQuotationBC.java
*@FileTitle : RFA Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RFAGroupLocationQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqGrpLocVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;

/**
 * ALPS-Rfaquotation Business Logic Command Interface<br>
 * - ALPS-Rfaquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014_01EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAGroupLocationQuotationBC {

	/**
	 * Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param PriRqGrpLocVO priRqGrpLocVO
	 * @return List<RsltPriRqGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpLocDtlVO> searchGroupLocationDetailList(PriRqGrpLocVO priRqGrpLocVO) throws EventException;
	
	/**
	 * Group Location 정보를 조회한다.<br>
	 * 
	 * @param PriRqGrpLocVO priRqGrpLocVO
	 * @return List<RsltPriRqGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpLocVO> searchRfaGroupLocationQuotationList(PriRqGrpLocVO priRqGrpLocVO) throws EventException;
	
	
	
	
	/**
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param RFAGroupLocationQuotationVO groupLocationQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRfaGroupLocationQuotation(RFAGroupLocationQuotationVO groupLocationQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	
	/**
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO priRqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyRfaGroupLocationQuotation(RsltPriRqMnVO priRqHdrVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * COPY TO QUOTATION<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaGroupLocationQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * Group Location REMOVE BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaGroupLocationQuotation(PriRqHdrVO priRqHdrVO) throws EventException;
	
	
	/**
	 * Rate에서 사용하는 Location 코드가 있는지 조회한다.
	 * @param RFAGroupLocationQuotationVO groupLocationQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(RFAGroupLocationQuotationVO groupLocationQuotationVO) throws EventException;
}