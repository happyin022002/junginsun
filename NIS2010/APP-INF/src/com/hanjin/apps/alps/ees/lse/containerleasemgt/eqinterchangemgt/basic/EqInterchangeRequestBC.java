/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeRequestBC.java
*@FileTitle : EQ Interchange Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.05.21 길정권
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchOfferInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeSummaryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeong-Kwon KIL
 * @see Ees_lse_0107EventResponse 참조
 * @since J2EE 1.6
 */
public interface EqInterchangeRequestBC {


	/**
	 * EQ Interchange Request 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeReqVO> searchEqInterchangeRequestBasic(EqInterchangeReqVO eqInterchangeReqVO) throws EventException;
	
	/**
	 * EQ Interchange Request를 저장 처리함<br>
	 *
	 * @param EqInterchangeReqVO[] eqInterchangeReqVOS
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String modifyEqInterchangeRequestBasic(EqInterchangeReqVO[] eqInterchangeReqVOS, SignOnUserAccount userAccount ) throws EventException ;
	
	/**
	 * EQ Interchange Request 처리에 대한 Req No을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeReqVO> searchEqInterchangeReqNumberService(EqInterchangeReqVO eqInterchangeReqVO) throws EventException;

	
	/**
	 * EQ Interchange Request 처리에 대한 EMU cost을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return EqInterchangeReqVO
	 * @exception EventException
	 */
	public EqInterchangeReqVO searchEqInterchangeEMUCostService(EqInterchangeReqVO eqInterchangeReqVO) throws EventException;
	
	
	/**
	 * EQ Interchange Approval 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeReqVO> searchEqInterchangeApprovalBasic(EqInterchangeReqVO eqInterchangeReqVO) throws EventException ;

	/**
	 * EQ Interchange Approval을 Creation 처리함<br>
	 *
	 * @param EqInterchangeReqVO[] eqInterchangeReqVOS
	 * @param SignOnUserAccount userAccount
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public String modifyEqInterchangeApprovalBasic(EqInterchangeReqVO[] eqInterchangeReqVOS, SignOnUserAccount userAccount ) throws EventException ;
	
	/**
	 * EQ Interchange Update 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return List<EqInterchangeVO>
	 * @exception EventException
	 */
	public List<EqInterchangeVO> searchEqInterchangeUpdateBasic(EqInterchangeVO eqInterchangeVO) throws EventException;
	
	/**
	 * EQ Interchange Update 처리에 대한 Auth No을  조회<br>
	 *
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return List<EqInterchangeVO>
	 * @exception EventException
	 */
	public List<EqInterchangeVO> searchEqInterchangeAuthNumberDataService(EqInterchangeVO eqInterchangeVO) throws EventException;

	/**
	 * EQ Interchange Update를 저장 처리함<br>
	 *
	 * @param EqInterchangeVO[] eqInterchangeVOS
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyEqInterchangeUpdateService(EqInterchangeVO[] eqInterchangeVOS, SignOnUserAccount userAccount ) throws EventException ;
	
	/**
	 * EQ Interchange Update를 Cancel를 저장 처리함<br>
	 *
	 * @param EqInterchangeVO[] eqInterchangeVOS
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyEqInterchangeUpdateCancelService(EqInterchangeVO[] eqInterchangeVOS, SignOnUserAccount userAccount ) throws EventException ;
	
	/**
	 * EQ Interchange offer inquiry을  조회<br>
	 *
	 * @param  SearchOfferInquiryVO searchOfferInquiryVO
	 * @return List<EqInterchangeVO>
	 * @exception EventException
	 */
	public List<SearchOfferInquiryVO> searchOfferInquiryService(SearchOfferInquiryVO searchOfferInquiryVO) throws EventException;

	/**
	 * EQ interchange pick-up/off-hire 현황목록을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<EqInterchangeSummaryVO>
	 * @throws EventException
	 */
	public List<EqInterchangeSummaryVO> searchEqInterchangeSummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * EQ interchange pick-up/off-hire 장비의 상세내역을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<EqInterchangeDetailVO>
	 * @throws EventException
	 */
	public List<EqInterchangeDetailVO> searchEqInterchangeContainerDetailBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * Available Oneway Inventory 조회<br>
	 * 
	 * @param String locFmTp
	 * @param String locFm
	 * @param String dpsl
	 * @param String orgCntrTpszCd
	 * @param String trd
	 * @param String locTp
	 * @param String locTo
	 * @param String sts
	 * @param String stay
	 * @param String dys
	 * @param String agmtSeq
	 * @param String vndrSeq
	 * @return List<AvailableOnewayInventoryVO>
	 * @exception EventException
	 */
	public List<AvailableOnewayInventoryVO> searchAvailableOnewaySummaryBasic(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws EventException;

	/**
	 * Available Oneway Inventory 조회<br>
	 * 
	 * @param String locFmTp
	 * @param String locFm
	 * @param String dpsl
	 * @param String orgCntrTpszCd
	 * @param String trd
	 * @param String locTp
	 * @param String locTo
	 * @param String sts
	 * @param String stay
	 * @param String dys
	 * @param String agmtSeq
	 * @param String vndrSeq
	 * @return List<AvailableOnewayInventoryVO>
	 * @exception EventException
	 */
	public List<AvailableOnewayInventoryVO> searchAvailableOnewayListBasic(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws EventException;

	/**
	 * Oneway Loading PFMC 조회<br>
	 * 
     * @param String period
     * @param String froms
     * @param String dpsl
     * @param String orgCntrTpszCd
     * @param String trd
     * @param String locTp
     * @param String locTo
     * @param String tos
     * @param String delDol
     * @param String porDol
     * @param String ifFlg
     * @param String mvmt
	 * @return List<AvailableOnewayInventoryVO>
	 * @exception EventException
	 */
	public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCSummaryBasic(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws EventException;

	/**
	 * Oneway Loading PFMC 조회<br>
	 * 
     * @param String period
     * @param String froms
     * @param String dpsl
     * @param String orgCntrTpszCd
     * @param String trd
     * @param String locTp
     * @param String locTo
     * @param String tos
     * @param String delDol
     * @param String porDol
     * @param String ifFlg
     * @param String mvmt
	 * @return List<AvailableOnewayInventoryVO>
	 * @exception EventException
	 */
	public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCListBasic(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws EventException;

	/** EES_MST_0113 : save<br>
	 * LeaseTermCode 등록, 수정, 삭제 데이타 처리합니다.<br> 
	 * @author Doo Ki Min
	 * @category EES_MST_0113
	 * @category manageOnewayLoadingPFMCBasic    
	 * @param AvailableOnewayInventoryVO[] availableOnewayInventoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageOnewayLoadingPFMCBasic(AvailableOnewayInventoryVO[] availableOnewayInventoryVOs,SignOnUserAccount account) throws EventException;

}
