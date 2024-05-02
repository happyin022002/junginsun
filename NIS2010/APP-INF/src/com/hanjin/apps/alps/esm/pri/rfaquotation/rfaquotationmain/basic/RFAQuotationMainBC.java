/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAQuotationMainBC.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RFAQutationMainVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtCmdtRoutSetVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;

/**
 * ALPS-Rfaquotation Business Logic Command Interface<br>
 * - ALPS-Rfaquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAQuotationMainBC {

	/**
	 * Max Qttn No를 조회한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRfaQuotationHeaderMaxQttnNo(PriRqHdrVO priRqHdrVO) throws EventException;
	
	
	/**
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnVO> searchRfaQuotationMainList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * Quotation 에 calculate를 수행 했는지 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnChkNeedCalcVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnChkNeedCalcVO> searchRfaQuotationMainChkNeedCalcList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * RFA Quotation Main Inquiry(ESM_PRI_6015).<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnVO> searchRfaQuotationMainReportList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * GLINE 존재여부 체크.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @exception EventException
	 */
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * 텝별 건수 조회.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @exception EventException
	 */
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * Copy 할 Gline seq를 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * Copy to Proposal 전 calculate 했는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkCalculate(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkExistRate(RsltPriRqMnVO rsltPriRqMnVO) throws EventException;
	
	
	/**
	 * PRI_RQ_HDR, PRI_RQ_MN 테이블 정보를 저장한다.<br>
	 * 
	 * @param RFAQutationMainVO qutationMainVO
	 * @param account SignOnUserAccount
	 * @return RsltPriRqMnVO
	 * @exception EventException
	 */
	public RsltPriRqMnVO manageRfaQuotationMain(RFAQutationMainVO qutationMainVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 상태코드 cancel 저장<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelStatusRfaQuotationMain(PriRqHdrVO priRqHdrVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * copyToProposal 시 prop_no 저장<br>
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRFAQuotationMainPropNo(PriRqMnVO priRqMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Proposal 삭제 시 해당하는 Quotation Main 의 Prop No 를 공백으로 업데이트 합니다.<br>
     * 
     * @param PriRqMnVO priRqMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyRFAQuotationMainPropNoDel(PriRqMnVO priRqMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * COPY TO QUOTATION PRI_RQ_HDR, PRI_RQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaQuotaionMainReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	/**
	 * REMOVE PRI_RQ_HDR, PRI_RQ_MN BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaQuotationMain(PriRqHdrVO priRqHdrVO) throws EventException;
	
	/**
	 * CM/OP View 의 CM 값을 갱신처리 합니다.<BR>
	 * 
	 * @param  PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPriRqMnCm(PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO, SignOnUserAccount account)	throws EventException; 
			
}