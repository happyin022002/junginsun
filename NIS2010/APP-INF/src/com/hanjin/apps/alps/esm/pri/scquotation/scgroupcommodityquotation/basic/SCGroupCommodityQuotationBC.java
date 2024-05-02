/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityQuotationBC.java
*@FileTitle : S/C Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.GroupCommodityQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;

/**
 * ALPS-Scquotation Business Logic Command Interface<br>
 * - ALPS-Scquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6005_02EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCGroupCommodityQuotationBC {

	/**
	 * PRI_SQ_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpCmdtVO priSqGrpCmdtVO
	 * @return List<RsltPriSqGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpCmdtDtlVO> searchGroupCommodityDetailList(PriSqGrpCmdtVO priSqGrpCmdtVO) throws EventException;
	
	/**
	 * PRI_SQ_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpCmdtVO priSqGrpCmdtVO
	 * @return List<RsltPriSqGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpCmdtVO> searchScGroupCommodityQuotationList(PriSqGrpCmdtVO priSqGrpCmdtVO) throws EventException;
	
	
	/**
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param GroupCommodityQuotationVO groupCommodityQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageScGroupCommodityQuotation(GroupCommodityQuotationVO groupCommodityQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriSqMnVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScGroupCommodityQuotation(RsltPriSqMnVO priSqHdrVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
     * Guideline TPW Commodity Group 을 Copy 합니다.<br>
     * 
     * @param vo RsltSearchGlineExistVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (RsltSearchGlineExistVO vo, SignOnUserAccount account) throws EventException;
    
    
    
    /**
	 * COPY TO QUOTATION PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScGroupCommodityQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * REMOVE PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL BY QTTN NO, QTTN VER NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeManageScGroupCommodityQuotation(PriSqHdrVO priSqHdrVO) 
		throws EventException;
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param GroupCommodityQuotationVO groupCommodityQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(GroupCommodityQuotationVO groupCommodityQuotationVO) throws EventException;
}