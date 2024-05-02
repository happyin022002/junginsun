/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilBC.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
* 2011.12.15 김민아 [CHM-201115274-01] [VOP-OPF] Weight Group code 일괄 Update 요청
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.MdmVslCntrInfoVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-Opfcommon Business Logic Command Interface<br>
 * - NIS2010-Opfcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Suk Hyun
 * @see OpfutilEventResponse 참조
 * @since J2EE 1.4
 */

public interface OpfUtilBC {
	/**
	 * [OPF Combo]을 [조회] 합니다.<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCombo(String comCode) throws EventException; 
	
	/**
	 * [I-Stowge Code]을 [조회] 합니다.<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchComboGeneral(String comCode) throws EventException;
	
	/**
	 * [Lane Code]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * [Lane Code]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * [Carrier Code]을 [조회] 합니다.<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkCarrier(VskCarrierVO vskCarrierVO) throws EventException;
	
	/**
	 * [VVD의 Yard]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVvdYard(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;
	
	/**
	 * [VVD 여부]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException;
	
	/**
	 * [Container 여부]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchContainer(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortLoadVolList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * [Container Type/Size]을 [조회] 합니다.<br>
	 * 
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCntrTpSzList() throws EventException;
	
    /**
     * VVD코드의 Port를 조회 합니다. <br>
     * 
     * @param OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfUtilSearchOptVO>
     * @exception EventException
     */
    public List<OpfUtilSearchOptVO> searchVvdPort(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;
    
    /**
     * Port정보 조회한다. <br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfComboVO> 
     * @throws DAOException
     */
     public List<OpfComboVO> searchPortInfo(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;

     /**
      * MST_CONTAINER에서 Container No의 Validation을 체크한다.
      * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
      * @return List<OpfComboVO>
      * @throws EventException
      */
 	public List<OpfComboVO> searchCntrNoValid(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * OFC_CD로 RHQ_OFC_CD를 구한다.
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCd(String ofcCd) throws EventException;
	
	/**
	 * Stevedore Damage 화면에 대한 Vessel Category Code 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<MdmVslCntrInfoVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrInfoVO> searchMdmVslCntrInfoList(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	
    /**
     * VVD코드의 Port 및 ETA를 조회 합니다. <br>
     * 
     * @param OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfComboVO>
     * @exception EventException
     */
    public List<OpfComboVO> searchVskVslPortEtaList(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;
    
    /**
     * 공통코드를 조회 합니다. <br>
     * 
     * @param ComComboVO comComboVO
     * @return List<ComComboVO>
     * @exception EventException
     */
    public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException;
}