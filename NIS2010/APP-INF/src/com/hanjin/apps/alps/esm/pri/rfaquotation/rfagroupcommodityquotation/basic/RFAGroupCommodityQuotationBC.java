/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityQuotationBC.java
*@FileTitle : RFA Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RFAGroupCommodityQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;

/**
 * ALPS-Rfaquotation Business Logic Command Interface<br>
 * - ALPS-Rfaquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014_02EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAGroupCommodityQuotationBC {

	/**
	 * Group Commodity detail search.<br>
	 * 
	 * @param PriRqGrpCmdtVO priRqGrpCmdtVO 
	 * @return List<RsltPriRqGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpCmdtDtlVO> searchGroupCommodityDetailList(PriRqGrpCmdtVO priRqGrpCmdtVO) throws EventException;
	
	/**
	 * Group Commodity search.<br>
	 * 
	 * @param PriRqGrpCmdtVO priRqGrpCmdtVO 
	 * @return List<RsltPriRqGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpCmdtVO> searchRfaGroupCommodityQuotationList(PriRqGrpCmdtVO priRqGrpCmdtVO) throws EventException;
	
	
	/**
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param RFAGroupCommodityQuotationVO groupCommodityQuotationVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRfaGroupCommodityQuotation(RFAGroupCommodityQuotationVO groupCommodityQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO priRqHdrVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyRfaGroupCommodityQuotation(RsltPriRqMnVO priRqHdrVO, SignOnUserAccount account) 
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
	 * COPY TO QUOTATION Group commodity<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaGroupCommodityQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * REMOVE Group Commodity BY QTTN NO, QTTN VER NO<br>
	 * 
	 * @param priRqHdrVO PriRqHdrVO
	 * @exception EventException
	 */
	public void removeManageRfaGroupCommodityQuotation(PriRqHdrVO priRqHdrVO) throws EventException;
	
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param RFAGroupCommodityQuotationVO groupCommodityQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(RFAGroupCommodityQuotationVO groupCommodityQuotationVO) throws EventException;
}