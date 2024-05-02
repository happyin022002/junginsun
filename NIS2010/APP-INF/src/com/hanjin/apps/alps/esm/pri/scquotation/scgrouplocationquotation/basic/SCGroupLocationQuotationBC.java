/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationQuotationBC.java
*@FileTitle : S/C Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.GroupLocationQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqGrpLocVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;

/**
 * ALPS-Scquotation Business Logic Command Interface<br>
 * - ALPS-Scquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6005_1EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCGroupLocationQuotationBC {

	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpLocDtlVO> searchGroupLocationDetailList(PriSqGrpLocVO priSqGrpLocVO) throws EventException;
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpLocVO> searchScGroupLocationQuotationList(PriSqGrpLocVO priSqGrpLocVO) throws EventException;
	
	
	
	
	/**
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param GroupLocationQuotationVO groupLocationQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageScGroupLocationQuotation(GroupLocationQuotationVO groupLocationQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	
	/**
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriSqMnVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScGroupLocationQuotation(RsltPriSqMnVO priSqHdrVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScGroupLocationQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * REMOVE PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL BY QTTN NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeScGroupLocationQuotation(PriSqHdrVO priSqHdrVO) throws EventException;
	
	/**
	 * Rate에서 사용하는 Location 코드가 있는지 조회한다.
	 * @param GroupLocationQuotationVO groupLocationQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(GroupLocationQuotationVO groupLocationQuotationVO) throws EventException;
}