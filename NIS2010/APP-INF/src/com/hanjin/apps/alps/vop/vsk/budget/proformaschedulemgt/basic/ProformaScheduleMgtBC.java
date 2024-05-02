/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBC.java
*@FileTitle : P/F SKD Type Help(Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
 
/**
 * NIS2010-Scheduleplanningoperation Business Logic Command Interface<br>
 * - NIS2010-Scheduleplanningoperation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Ui_vsk-0241EventResponse 참조
 * @since J2EE 1.4
 */

public interface ProformaScheduleMgtBC {

	/**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @throws EventException
	 */
	public List<PfSkdVO> searchPfSkd(PfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * P/F SKD Settlement ,Creation의 M/Simulation의 정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdManual(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * P/F SKD Settlement의 Settlement을 저장한다.<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmSimScnr(PfSkdGRPVO pfSkdGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * P/F SKD Creation AutoSimulation 이벤트 처리<br>
	 * ProformaScheduleMgt의 event에 대한 AutoSimulation 이벤트 처리<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdAuto(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param List<PfSkdVO> pfSkdVOs
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPortInfo(List<PfSkdVO> pfSkdVOs) throws EventException;
	
	/**
	 * P/F SKD Settlement의 PF_SKD을 삭제한다.<br>
	 *  ProformaScheduleMgt화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePfSkd(VskPfSkdVO vskPfSkdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * P/F SKD Creation Row Delete 이벤트 처리<br>
	 * ProformaScheduleMgt의 선택한 로우(들)을 삭제하고 존재하는 포트에 대한 정보를 재 조합한다.<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception EventException
	 */
	public List<VskPfSkdDtlVO> calRowDelete(PfSkdGRPVO pfSkdGRPVO) throws EventException;

	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception EventException
	 */
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws EventException;
	
	/**
	 * Estimate VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws EventException;
}