/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtForGateNewBC.java
*@FileTitle : GATENEW Business Logic Command Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.06 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmVrfdGrsMassEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;


/**
 * ALPS-Equipmentmovementmgt Business Logic Command Interface<br>
 * - ALPS-Equipmentmovementmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang Soo
 * @see Ees_ctm_0000EventResponse(테스트 화면) 참조
 * @see UbizhjsAlpsCtmEqmvmt EventResponse(MQ메세지 INBOUND) 참조
 * @since J2EE 1.4
 */
public interface ContainerMovementMgtForGateNewBC {

	/**
	 * GATE NEW <br>
	 *  Container Movement EDI Batch<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileVOForGateNew
	 * @exception EventException
	 */
	public FlatFileForGateNewVO gateNew( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException;

	/**
	 * ACIAC_DIV_CD 체크
	 * GateNew의 checkNassignData / EES_CTM_0404의 manageEDIMovement에서 공통사용<br>
	 *
	 * @param String cntrNumber
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException,Exception
	 */
	public String[] checkAciacDivCd(String cntrNumber, String bkgNumber) throws DAOException,Exception;

	/**
	 * resultUpdb for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO resultUpdb( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

	/**
	 * assignCommonVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param int bkgKnt
	 * @return CusCtmMovementVO[]
	 * @exception EventException
	 **/
	public CusCtmMovementVO[] assignCommonVO( FlatFileForGateNewVO flatFileForGateNewVO, int bkgKnt ) throws EventException;

	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @return FlatFileVOForGateNew[]
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO[] assignFlatFileVO( String flatFile ) throws EventException;

	/**
	 * 영문자여부 체크<BR>
	 *
	 * @param String str
	 * @return Boolean
	 */
	public Boolean isAlpha( String str );

	/**
	 * assignEdiUiVO2FlatFileVO for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignEdiUiVO2FlatFileVO( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

	/**
	 * assignFlatFileVO2EdiUiVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO assignFlatFileVO2EdiUiVO( FlatFileForGateNewVO flatFileForGateNewVO, SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

	/**
	 * 이전 상태 값이 'CP'일 경우이고 현재 booking no.가 invalid할 경우, Domestic booking으로 판단하는 처리
	 * @param cntrNo
	 * @param eventDt
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String checkDomesticBooking(String cntrNo, String eventDt, String bkgNo) throws EventException;

	/**
	 * VERMAS EDI data parsing 처리.
	 * @param flatFile
	 * @return CtmVrfdGrsMassEdiMsgVO[]
	 * @throws EventException
	 */
	public CtmVrfdGrsMassEdiMsgVO[] assignVermasFlatFileVO(String flatFile) throws EventException;

	/**
	 * VERMAS EDI data 저장.
	 * @param ctmVrfdGrsMassEdiMsgVOs
	 * @throws EventException
	 */
	public void addCtmVrfdGrsMassEdiMsg(CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVOs[]) throws EventException;
}