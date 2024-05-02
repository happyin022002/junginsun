/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineBC.java
*@FileTitle : TrendLine
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
* 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.TrndLineSimulationVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.FcmVslPortStndFuelOilVO;

/**
 * ALPS-Simulation Business Logic Command Interface<br>
 * - ALPS-Simulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface SimulationBC {
	
	/**
	 * 등록된 Proforma SKD 정보를 조회한다.<br>
	 * 
	 * @param SmlPfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<SmlPfSkdVO> searchPfSkd(SmlPfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * simulation no의 max 값을 조회한다.<br>
	 * 
	 * @param FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFcmBnkCsm(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * simulation no의 max 값을 조회한다.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String addSimNo() throws EventException;
	
	/**
	 * Bunker Consumption Simulation 결과를 생성한다.<br>
	 * 
	 * @param FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addFcmBnkCsmPfSim(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO,SignOnUserAccount account) throws EventException;

	/**
	 * 지정된 VVD에 대해 Bunker Request Simulation을 한다.<br>
	 * 
	 * @param SmlPfSkdVO pfSkdVO
	 * @param String vsl_clss_cd
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<FcmBnkCsmPfDtlSimVO> searchFcmBnkCsmPfDtlSimSmlPfSkd(SmlPfSkdVO pfSkdVO,String vsl_clss_cd) throws EventException;
	
	/**
	 * Simulation에 필요한 Vessel Registration 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return FcmVslCntrRgstVO
	 * @exception EventException
	 */
	public FcmVslCntrRgstVO searchVslRgstInfo(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * 해당 Vessel으로 생성된 Trnd Line이 존재하는지 check<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws EventException
	 */
	public String checkVslCdOfTrndLine(String vslCd) throws EventException;
	
	/**
	 * 조건에 맞는 Trnd Line(1,3,6)을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @throws EventException
	 */
	public List<FcmTrndLineVO> searchTrndLineForFOC(FcmTrndLineVO fcmTrndLineVO) throws EventException;

	/**
	 * Trnd Line이 생성되어 있는 vsl의 direction을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchTrndLineDirCd(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trnd Line이 생성되어 있는 Class, Sub Class, lane code를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<String[]>
	 * @throws EventException
	 */
	public List<String[]> searchCapaLaneOfTrndLine(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Search target VVD and SKD information.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return List<BnkReqSimVO>
	 * @exception EventException
	 */
	public List<BnkReqSimVO> searchVvd(BnkReqSimVO bnkReqSimVO) throws EventException;
	
	/**
	 * Search trend line to simulate bunker request.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return FcmTrndLineVO
	 * @exception EventException
	 */
	public FcmTrndLineVO searchTrendLineForBnkReqSim(BnkReqSimVO bnkReqSimVO) throws EventException;
	
	/**
	 * Save the simulation data, and get the simulation number.
	 * 
	 * @param BnkReqSimVO[] bnkReqSimVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageBunkerRequestSimulation(BnkReqSimVO[] bnkReqSimVOs) throws EventException;
	
	/**
	 * 0055. 이미 선택된 조건들로 target 정보를 조회한다.
	 * 
	 * @param TrndLineSimulationVO trndLineSimulationVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTrndLineItmList(TrndLineSimulationVO trndLineSimulationVO) throws EventException;
	
	/**
	 * Standard FOC 화면을 조회한다.
	 * 
	 * @param StandardFocVO standardFocVO
	 * @return List<StandardFocVO>
	 * @exception EventException
	 */
	public List<StandardFocVO> searchStandardFoc(StandardFocVO standardFocVO) throws EventException;
	
	/**
	 * Standard FOC 정보를 저장한다.
	 * 
	 * @param FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStandardFoc(FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs, SignOnUserAccount account) throws EventException;
}
