/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongTxContainerMovementFinderBC.java
*@FileTitle : LongTxContainerMovementFinderBC
*Open Issues :
*Change history : 2009.08.27 (우경민) - EES_CTM_0418 관련업무 최초생성
*                 2009.08.28 (김상수) - EES_CTM_0417 관련업무 추가
*@LastModifyDate : 2009.08.28
*@LastModifier : 김상수
*@LastVersion : 1.1
* 2009.08.27 우경민
* 1.0 Creation
* 2009.08.28 김상수
* 1.1 Modification
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Equipmentmovementmgt Business Logic Command Interface<br>
 * - ALPS-Equipmentmovementmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see Ees_ctm_0440EventResponse 참조
 * @since J2EE 1.6
 */

public interface LongTxContainerMovementFinderBC {

	/**
	 * EES_CTM_0418
	 * 화면 로딩시  RCC Combo List를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getRccList(String ofcCd) throws EventException;

	/**
	 * EES_CTM_0418
	 * RCC Combo List 변경시 LCC 를 조회<br>
	 *
	 * @param String rccCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getLccList(String rccCd) throws EventException;

	/**
	 * EES_CTM_0418 : 0418의 BackEnd Job를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param MovementEDIReportVO movementEDIReportVO
	 * @return String
	 */
	public String doBackEndJob(SignOnUserAccount account, MovementEDIReportVO movementEDIReportVO);

	/**
	 * EES_CTM_0418 Movement Update 시차에 대한 상세정보를 조회<br>
	 *
	 * @param UpdateRatioDetailVO updateRatioDetailVO
	 * @return List<UpdateRatioDetailVO>
	 * @exception EventException
	 */
	public List<UpdateRatioDetailVO> getUpdateRatioDetail(UpdateRatioDetailVO updateRatioDetailVO) throws EventException ;

	/**
	 * EES_CTM_0417 : 0420의 BackEndJob를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobEDIErrList(SignOnUserAccount account, SearchEDIErrorVO searchEDIErrorVO);

	/**
	 * EES_CTM_0417 : BackEndJob 결과<br>
	 * EDI Error List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<SearchEDIErrorVO>
	 * @exception EventException
	 */
	public List<SearchEDIErrorVO> searchEDIErrorList(String key) throws EventException;

	/**
	 * EES_CTM_0417 : EDI error율, row data 및 엑셀 다운용 EDI error 상세 데이터를 조회<br>
	 *
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIErrorVO> searchEDIErrorDetailExcel(SearchEDIErrorVO searchEDIErrorVO) throws EventException;

	/**
	 * EES_CTM_0420 : 0420의 BackEnd Job를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return String
	 */
	public String doBackEndJobEDIRst(SignOnUserAccount account, SearchEDIResultVO searchEDIResultVO);

	/**
	 * EES_CTM_0420 : BackEndJob 결과<br>
	 * EDI Result List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<SearchEDIResultVO>
	 * @exception EventException
	 */
	public List<SearchEDIResultVO> searchEDIResultList(String key) throws EventException;

	/**
	 * EES_CTM_0420 : 엑셀 다운용 EDI result 상세 데이터를 조회합니다.<br>
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIResultVO> searchEDIResultDetailExcel(SearchEDIResultVO searchEDIResultVO) throws EventException;

	/**
	 * EES_CTM_0460 : 0460의 BackEndJob를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param VLVDUpdateStatusVO vlvdUpdateStatusVO
	 * @return String
	 */
	public String doBackEndJobVLVDStatus(SignOnUserAccount account, VLVDUpdateStatusVO vlvdUpdateStatusVO);

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException ;

	/**
	 * 자동 생성된 Movement 리스트를 조회.<br>
	 *
	 * @param AutoCreStsListVO	autoCreStsListVO
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> getAutoCreSts(AutoCreStsListVO autoCreStsListVO) throws EventException ;

	/**
	 * EES_CTM_0462 : 0462의 BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param AutoCreStsListVO autoCreStsListVO
	 * @return String
	 */
	public String doBackEndJobAutoCreStatus(SignOnUserAccount account, AutoCreStsListVO autoCreStsListVO);

	/**
	 * EES_CTM_0418 : BackEndJob 결과<br>
	 * MVMT Timely Update Ratio Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<MovementEDIReportVO>
	 * @exception EventException
	 */
	public List<MovementEDIReportVO> searchEDIOnTimeDetailList(String key) throws EventException;

	/**
	 * EES_CTM_0462 : BackEndJob 결과<br>
	 * Auto Creation Status List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> searchAutoCreStatus(String key) throws EventException;

}