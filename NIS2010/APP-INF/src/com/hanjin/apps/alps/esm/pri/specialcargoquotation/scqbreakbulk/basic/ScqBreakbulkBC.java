/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardBC.java
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRqstVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Specialcargoquotation Business Logic Command Interface<br>
 * - ALPS-Specialcargoquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @since J2EE 1.6
 */

public interface ScqBreakbulkBC {

	/**
	 * Break Bulk Quotation 의 Cargo 정보 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return List<PriScqBbCgoVO>
	 * @exception EventException
	 */
	public List<PriScqBbCgoVO> searchPriScqBbCgo(PriScqBbCgoVO PriScqBbCgoVO) throws EventException;
	
	/**
	 * Break Bulk Quotation 의 Container 정보 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return List<PriScqBbCgoVO>
	 * @exception EventException
	 */
	public List<PriScqBbCntrVO> searchPriScqBbCntr(PriScqBbCntrVO PriScqBbCntrVO) throws EventException;
	
	/**
	 * Break Bulk Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbMnVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbHdr(PriScqBbHdrVO PriScqBbHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Break Bulk Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbMnVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbVerNo(PriScqBbHdrVO PriScqBbHdrVO) throws EventException;
	
	/**
	 * Break Bulk Quotation 화면의 Container 정보 중 Container Typesize Combo 를 위한 조회. <br>
	 * 
	 * @param PriScqBbCntrTpszVO PriScqBbCntrTpszVO
	 * @return List<PriScqBbCntrTpszVO>
	 * @exception EventException
	 */
	public List<PriScqBbCntrTpszVO> searchPriScqBbCntrTpsz(PriScqBbCntrTpszVO PriScqBbCntrTpszVO) throws EventException;

	/**
	 * Break Bulk Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbMnVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbSvcScp(PriScqBbHdrVO PriScqBbHdrVO) throws EventException;
	
	/**
	 * Break Bulk Cargo Quotation 의 Request 진행.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVO
	 * @param account SignOnUserAccount
	 * @return PriScqBbHdrVO
	 * @exception EventException
	 */
	public PriScqBbHdrVO multiPriScqBbRqst(PriScqBbRqstVO PriScqBbRqstVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Counter Offer Cancel 처리..<br>
	 * C/Offer 로 생성된 새로운 Version No 의 Data Set 을 삭제하고 
     * 이전 상태 ( 이전 Version 의 Reject or Approved 상태 ) 로 복귀 
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqBbHdrVO cancelCounterOffer(PriScqBbHdrVO priScqBbHdrVO, SignOnUserAccount account) throws EventException;

	/**
	 * Approval Cancel 처리..<br>
	 * 
	 * Approval 이전 상태로 복귀 
	 * 1.PRI_SCQ_PROG 상의 마지막 Approval 기록 데이터 부분 지우기
	 * 2.지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_BB_MN.PROG_STS_CD 변경 하기
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqBbHdrVO cancelApproval(PriScqBbHdrVO priScqBbHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Break Bulk Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * 
	 * @param PriScqBbRoutCostVO priScqBbRoutCostVO
	 * @return List<PriScqBbRoutCostVO>
	 * @exception EventException
	 */
	public List<PriScqBbRoutCostVO> searchPriScqBbRoutCost(PriScqBbRoutCostVO priScqBbRoutCostVO) throws EventException;

	/**
	 * Break Bulk Cargo Quotation 정보 저장.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVO
	 * @param account SignOnUserAccount
	 * @return PriScqBbHdrVO
	 * @exception EventException
	 */
	public void multiPriScqBbRoutCost(PriScqBbRoutCostVO[] priScqBbRoutCostVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Break Bulk Cargo Quotation Container 정보 저장.<br>
	 * 
	 * @param PriScqBbRqstVO priScqBbRqstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void addPriScqBbCntrNewVerNo(PriScqBbRqstVO priScqBbRqstVO, SignOnUserAccount account) throws EventException;


	/**
	 * 지정된 Lane - POL 에 대한 VVD - ETA List 를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO hdrVO)
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVVDETAList(PriScqBbHdrVO hdrVO) throws EventException ;
}