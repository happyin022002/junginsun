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
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCostByCgoRoutVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCmdtListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkRqstVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchOceanRouteYDListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Specialcargoquotation Business Logic Command Interface<br>
 * - ALPS-Specialcargoquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @since J2EE 1.6
 */

public interface ScqAwkwardBC {

	/**
	 * Awkward Quotation 의 Cargo 정보를 조회 한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCgoVO> searchPriScqAwkCgo(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException;
	
	/**
	 * Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception EventException
	 */
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRoute(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException;

	/**
	 * Awkward Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkMnVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqAwkHdr(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Awkward Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkMnVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqAwkVerNo(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException;
	
	/**
	 * Commodity Input Popup List 조회. <br>
	 * 
	 * @param PriScqAwkCmdtListVO priScqAwkCmdtListVO
	 * @return List<PriScqAwkCmdtListVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCmdtListVO> searchCommodityList(PriScqAwkCmdtListVO priScqAwkCmdtListVO) throws EventException;

	/**
	 *  - Awkward Quotation 화면의 Cargo 정보 중 Container Typesize Combo 를 위한 조회.<br>
	 * 
	 * @param PriScqAwkCntrTpszVO priScqAwkCntrTpszVO
	 * @return List<PriScqAwkCntrTpszVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCntrTpszVO> searchPriScqAwkCntrTpsz(PriScqAwkCntrTpszVO priScqAwkCntrTpszVO) throws EventException;


	/**
	 * Product Catalog 상의 Ocean Route 리스트 조회
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchOceanRouteYDListVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteYDListVO> searchOceanRouteYDList(SearchConditionVO vo) throws EventException;

	/**
	 * Awkward Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkMnVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqSvcScp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException;
	
	/**
	 * Awkward Cargo Quotation 정보 저장.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVO
	 * @param account SignOnUserAccount
	 * @return PriScqAwkHdrVO
	 * @exception EventException
	 */
	public PriScqAwkHdrVO multiPriScqAwkRqst(PriScqAwkRqstVO priScqAwkRqstVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  - Awkward Quotation 의 Cargo 정보를 조회 한다.
     *  - Temporary Calculation 에 적용하기 위해 본 테이블 ( PRI_SCQ_AWK_CGO ) 이 아닌 Temporary 테이블 ( PRI_SCQ_AWK_CGO_TMP ) 에 
     *    변경한 데이터를 저장하고 이를 대상으로 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCgoVO> searchPriScqAwkCgoTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException ;

	/**
	 *  - Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회 
     *  - Calculation 의 결과로 생성된 TMP 테이블에서 가져온다.<br>
	 * 
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception EventException
	 */
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRouteTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException ;

	/**
     * - Awkward 의 Cargo 와 Route 정보를 TES, TRS 에서 관리하는 테이터에 대조하여 
     *   각각의 비용을 계산한다.
     * - Temporary 하게 계산을 해 볼수 있도록 하기 위해 본 데이터를 TMP Table Set 로 Copy 하여 계산 결과를 저장한다..<br>
	 * 
	 * @param PriScqAwkCgoVO[] priScqAwkCgoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO calcPriScqAwkTmp(PriScqAwkRqstVO priScqAwkRqstVO, SignOnUserAccount account) throws EventException;

	/**
	 * TMP Table Set 에 생성된 계산 결과를 Transaction Table 로 옮겨서 저장한다..<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO copySave(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Counter Offer Cancel 처리..<br>
	 * C/Offer 로 생성된 새로운 Version No 의 Data Set ( Temporary Data Set 포함 ) 을 삭제하고 
     * 이전 상태 ( 이전 Version 의 Reject or Approved 상태 ) 로 복귀 
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO cancelCounterOffer(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Approval Cancel 처리..<br>
	 * 
	 * Approval 이전 상태로 복귀 
	 * 1.PRI_SCQ_PROG 상의 마지막 Approval 기록 데이터 부분 지우기
	 * 2.지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_AWK_MN.PROG_STS_CD 변경 하기
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO cancelApproval(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Calculate 를 위해 생성한 Temporary Table 상의 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @paran int mnDelFlg
	 * @exception EventException
	 */
	public void removeTemporary(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account, int mnDelFlg ) throws EventException;

	/**
	 * Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception EventException
	 */
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRout(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException ;

	/**
	 *  - Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회
     *  - Calculation 의 결과로 생성된 TMP 테이블에서 가져온다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception EventException
	 */
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRoutTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException ;

	/**
	 * Office Hierarchy List 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO	priScqAwkHdrVO
	 * @return List<OrganizationVO>
	 * @exception EventException
	 */
	public List<OrganizationVO> searchOfficeHierarchyList(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException;
}