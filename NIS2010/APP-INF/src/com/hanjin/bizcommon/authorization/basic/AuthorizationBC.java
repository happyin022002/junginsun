/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015-07-08 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.basic;

import com.hanjin.bizcommon.authorization.vo.AuthorizationCommonVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationRouteVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;


/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SSY
 * @see ComApr0T1EventResponse 참조
 * @since J2EE 1.4
 */
public interface AuthorizationBC  {
	
	/**
	 * Authorization Apro Rqst 항목 생성 
	 * @param AuthorizationRouteVO[] authorizationRouteVOs
	 * @param AuthorizationCommonVO authorizationCommonVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String saveAuthorizationRoute(AuthorizationRouteVO[] authorizationRouteVOs, AuthorizationCommonVO authorizationCommonVO, SignOnUserAccount account) throws EventException;


	
	/**
	 * COM_APR_0T1
	 * Self 결재자 인지 Check 하는 로직<br>
	 * 
	 * @param AuthorizationRouteVO authorizationRouteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthSelfApprovalCheck(AuthorizationRouteVO authorizationRouteVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Authorization Approval Default Line 조회
	 * COM_APR_0T1
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return List<SearchAuthAproVO>
	 * @throws EventException
	 */
	public List<SearchAuthAproVO> searchAuthAproDflt(SearchAuthAproVO searchAuthAproVO) throws EventException;
	
	/**
	 * Authorization 설정 정보 조회
	 * COM_APR_0T1
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws EventException
	 */
	public List<AuthorizationProgramInfoVO> searchAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException;
	
	
	/**
	 * Excel Download 승인 대상 화면인지 확인
	 * COM_APR_0T1
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthChkXlsBtnPrmt(SearchAuthAproVO searchAuthAproVO) throws EventException;
	
	/**
	 * 결재자 E-mail 유/무 확인
	 * COM_APR_0T1
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchNoEmlAddr(String authAproRqstNo) throws EventException;
	
	/**
	 * 결재자 E-mail 유/무 확인 사유 update
	 * COM_APR_0T1
	 * @param String authAproRqstNo
	 * @param String noEmlApro
	 * @throws EventException
	 */
	public void updateNoEmlAddrRmk(String authAproRqstNo, String noEmlApro) throws EventException;
	
	/**
	 * Authorization 전체 설정 정보 조회
	 * COM_APR_0S1
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws EventException
	 */
	public List<AuthorizationProgramInfoVO> searchAllAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException;
	
	
	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse getComboData(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException;
	

	/**
	 * 0S2 팝업 Program Name 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse getPgmNm(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException;
	
	

	/**
	 * 0S2 팝업 Data 조회
	 * 
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @exception EventException
	 */
	public AuthorizationProgramInfoVO searchPgmDetail(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException;
	
	
	/**
	 * 0S2 팝업 데이터 저장
	 * 
	 * @param AuthorizationProgramInfoVO[] authorizationProgramInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void savePgmAuth(AuthorizationProgramInfoVO[] authorizationProgramInfoVOs, SignOnUserAccount account) throws EventException;
	

	
}