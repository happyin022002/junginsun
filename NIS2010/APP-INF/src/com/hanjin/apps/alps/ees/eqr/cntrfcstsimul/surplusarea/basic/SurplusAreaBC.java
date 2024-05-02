/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurplusAreaBC.java
*@FileTitle : Inventory Simulation - Surplus Area 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MTYWeeklySimulation Business Logic Command Interface<br>
 * - ALPS-MTYWeeklySimulation 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author la sang bo
 * @see Ees_cim_5010EventResponse 참조
 * @since J2EE 1.6
 */

public interface SurplusAreaBC {

//	/**
//	 * LOC Code 유효성 조회<br>
//	 * 
//	 * @param String loc_grp_cd
//	 * @param String loc_cd
//	 * @return String
//	 * @exception EventException
//	 */	
//	public String checkLocCodeIs(String loc_grp_cd, String loc_cd) throws EventException;	
	
	/**
	 *  Surplus Area 의 시트 헤더 타이틀 조회<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchSurplusAreaTitleBasic(SurplusAreaConditionVO surplusAreaConditionVO) throws EventException;
	
	/**
	 *  Surplus Area - History Report 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException;

	/**
	 *  현재시각 기준으로 기본 주차 ( 과거 3주 ~ 미래 3주 , 총 7주차 )가져오기<br>
	 * 
	 * @return String
	 * @throws EventException
	 */
	 public String searchCurrSevenWeeksBasic() throws EventException;

	/**
	 * 로그인 유저의 수정 권한 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkYardSurplusAreaAuthBasic(SignOnUserAccount account) throws EventException;	 

	 /**
	 * LOC Code 유효성 조회 (RCC_CD 반환)<br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return String
	 * @exception EventException
	 */	
	public String checkRccCodeIs(String loc_grp_cd, String loc_cd) throws EventException;	
	
	/**
	 *  Surplus Area - Yard 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchYardSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException;
	
	/**
	 * Surplus Area - Yard 의 manual 데이터를 입력/수정/삭제<br>
	 * 
	 * @param SurplusAreaVO[] surplusAreaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageYardSurplusAreaBasic(SurplusAreaVO[] surplusAreaVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Surplus Area - Yard 의 BKG for OP Ref 팝업 데이터를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 public CommonRsVO searchBkgSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException;	

	/**
	 * 로그인 유저의 수정 권한 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkPortSurplusAreaAuthBasic(SignOnUserAccount account) throws EventException;	 
	 
	/**
	 *  Surplus Area - Port 시트를 조회한다.<br>
	 * 
	 * @param PortSurplusAreaConditionVO portSurplusAreaConditionVO
	 * @param String rptTtl
	 * @return List<CommonRsVO>
	 * @throws EventException
	 */
	public List<CommonRsVO> searchPortSurplusAreaBasic(PortSurplusAreaConditionVO portSurplusAreaConditionVO, String rptTtl) throws EventException;
	
	/**
	 * Surplus Area - Port 의 manual 데이터를 입력/수정/삭제<br>
	 * 
	 * @param SurplusAreaVO[] surplusAreaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortSurplusAreaBasic(SurplusAreaVO[] surplusAreaVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * Sub-Conti 콤보 리스트 조회<br>	
	 * @param portSurplusAreaConditionVO
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchSubcontiListBasic(PortSurplusAreaConditionVO portSurplusAreaConditionVO) throws EventException;
	
	/**
	 * (Port & Yard Simulation용) User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfcLvl(String ofcCd) throws EventException;
}