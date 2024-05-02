/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCQuotationMainBC.java
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.QutationMainVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.PriSqRtCmdtRoutSetVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;

/**
 * ALPS-Scquotation Business Logic Command Interface<br>
 * - ALPS-Scquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6005EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCQuotationMainBC {
	
	/**
	 * Max Qttn No select<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchScQuotationHeaderMaxQttnNo(PriSqHdrVO priSqHdrVO) throws EventException;
	
	
	/**
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnVO> searchScQuotationMainList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	
	/**
	 * Quotation 에 calculate를 수행 했는지 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnChkNeedCalcVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnChkNeedCalcVO> searchScQuotationMainChkNeedCalcList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	/**
	 * GLINE 존재여부 체크.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @exception EventException
	 */
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	
	/**
	 * 텝별 건수 조회.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @exception EventException
	 */
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	
	/**
	 * Copy 할 Gline seq를 조회한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
 
	/**
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkExistRate(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	
	/**
	 * PRI_SQ_HDR, PRI_SQ_MN 정보를 저장한다.<br>
	 * 
	 * @param QutationMainVO qutationMainVO
	 * @param account SignOnUserAccount
	 * @return RsltPriSqMnVO
	 * @exception EventException
	 */
	public RsltPriSqMnVO manageScQuotationMain(QutationMainVO qutationMainVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * PRI_SQ_HDR 테이블 상태코드 cancel 저장<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelStatusScQuotationMain(PriSqHdrVO priSqHdrVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_HDR,PRI_SQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScQuotaionMainReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * REMOVE PRI_SQ_MN BY QTTN NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeScQuotationMain(PriSqHdrVO priSqHdrVO) throws EventException;
	
	/**
	 * SC QUOTATION INQUIRY MAIN SEARCH<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnVO> searchScQuotationReportList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException;
	
	
	/**
	 * copyToProposal 시 PRI_SQ_MN 테이블 prop_no 저장<br>
	 * 
	 * @param PriSqMnVO priSqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyScQuotationMainPropNo(PriSqMnVO priSqMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  S/C Quotation Rate Main Table에 변경된 Load값을 이용해서 CM 값을 재 계산해서 갱신한다.<br>
	 * 
	 * @param priSqRtCmdtRoutSetVO PriSqRtCmdtRoutSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsPriSqMnCm(PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException ;

    /**
     * Proposal 삭제 시 해당하는 Quotation Main 의 Prop No 를 공백으로 업데이트 합니다.<br>
     * 
     * @param PriSqMnVO priSqMnVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void modifyScQuotationMainPropNoDel(PriSqMnVO priSqMnVO, SignOnUserAccount account) throws EventException;
}