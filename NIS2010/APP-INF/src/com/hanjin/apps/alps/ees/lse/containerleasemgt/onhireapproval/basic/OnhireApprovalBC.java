/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalBC.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.04 진준성
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseOnhAproVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
/**
 * NIS2010-Containerleasemgt Business Logic Command Interface<br>
 * - NIS2010-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0031EventResponse 참조
 * @since J2EE 1.6
 */

public interface OnhireApprovalBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 * Onhire 될 장비의 Approval number 내용을 조회<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumberBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;
	
	/**
	 * Auth No 조회 이벤트 처리<br>
	 * OnhireApproval화면에 대한  Auth No조회 이벤트 처리<br>
	 * 
	 * @param  String pOnhLocCd
	 * @param  String pLstmCd
	 * @param  String periodStdt
	 * @param  String periodEddt
	 * @return List<LseOnhAproVO>
	 * @exception EventException
	 */
	public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyBasic(String pOnhLocCd , String pLstmCd , String periodStdt , String periodEddt ) throws EventException;
	
	/**
	 *  저장 이벤트 처리<br>
	 *  임차 컨테이너(장기.단기,OF) 임차 계약 후, 상세한 pick-up 승인 저장<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  SignOnUserAccount account
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException
	 */
	public String createOnhireApprovalNumberBasic( OnhireApprovalVO onhireApprovalVO ,  OnhireApprovalVO[] onhireApprovalVOs , SignOnUserAccount account, List<MdmCntrTpSzVO> cntrList) throws EventException;
	
	/**
	 * 수정조회 이벤트 처리<br>
	 * 임차 컨테이너 상세한 pick-up 승인 저장내용을 수정한다.<br>
	 * 
	 * @param  String authNo
	 * @param  String tysz
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Basic(String authNo , String tysz) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * 임차 컨테이너 상세한 pick-up 승인에 대한 취소처리<br>
	 * 
	 * @param  String authNo
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelOnhireApprovalNumberBasic(String authNo , String agmtCtyCd ,String agmtSeq , SignOnUserAccount account) throws EventException;

	/**
	 * save 이벤트 처리<br>
	 * 장/단기 컨테이너 임차 계약 후, 상세한 pick-up 승인에 대하여 변경 상황 발생시 up-date <br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  SignOnUserAccount account
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException
	 */
	public String modifyOnhireApprovalNumberBasic( OnhireApprovalVO onhireApprovalVO , SignOnUserAccount account,  OnhireApprovalVO[] onhireApprovalVOs, List<MdmCntrTpSzVO> cntrList) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 자가컨테이너 pick up 한 장비를 auth no를 부여하기위하여 내용을 조회 <br>
	 * 
	 * @param  String locCd
	 * @param  String locTp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnListBasic(String locCd ,String locTp ) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 *  OnhireApproval화면에 대한 자가장비 Sum 조회 이벤트 처리 <br>
	 *
	 * Sum List hidden 시트조회
	 * @param String locCd
	 * @param String locTp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnSumListBasic(String locCd ,String locTp ) throws EventException;

	/**
	 * 자가컨테이너 pick up 장비 조회 이벤트 처리<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 조회<br>
	 * 
	 * Sum List hidden 시트조회
	 * @param  SearchApprovalVO searchApprovalVO
	 * @return SearchApprovalVO
	 * @exception EventException
	 */
	public SearchApprovalVO searchPickupStatusSummaryBasic(SearchApprovalVO searchApprovalVO ) throws EventException;
		
	/**
	 * 조회 이벤트 처리<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 상세조회<br>
	 * 
	 * Sum List hidden 시트조회
	 * @param  SearchApprovalDetailVO searchApprovalDetailVO
	 * @return List<SearchApprovalDetailVO>
	 * @exception EventException
	 */
	public List<SearchApprovalDetailVO> searchPickupStatusDetailBasic(SearchApprovalDetailVO searchApprovalDetailVO ) throws EventException;
	
	/**
	 * 수정조회 이벤트 처리<br>
	 * Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalLiftOnChargeBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Req List 화면의 타이틀 만들기 위한 내용을 조회하는 이벤트 처리<br>
	 * 
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String searchReqListTietleCodeService()throws EventException;
	
	/**
	 * 수정조회 이벤트 처리<br>
	 * Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리<br>
	 * 
	 * @param  SearchRequestListVO searchRequestListVO
	 * @return List<SearchRequestListVO>
	 * @exception EventException
	 */
	public List<SearchRequestListVO> searchEqrReqListService(SearchRequestListVO searchRequestListVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * DOL List를 조회<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalDolListBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ECC List를 조회<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalEccListBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;
		
}