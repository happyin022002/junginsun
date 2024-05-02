/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilBCImpl.java
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
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.MdmVslCntrInfoVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-OpfCommon Business Logic Basic Command implementation<br>
 * - NIS2010-OpfCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Suk Hyun
 * @see OpfUtilEventResponse,OpfUtilBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OpfUtilBCImpl extends BasicCommandSupport implements OpfUtilBC {

	// Database Access Object
	private transient OpfUtilDBDAO dbDao = null;

	/**
	 * OpfUtilBCImpl 객체 생성<br>
	 * OpfUtilDBDAO를 생성한다.<br>
	 */
	public OpfUtilBCImpl() {
		dbDao = new OpfUtilDBDAO();
	}
	/**
	 * [OPF Combo]을 [조회] 합니다.<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCombo(String comCode) throws EventException {
		try {
			return dbDao.searchCombo(comCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com Code Value"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com Code Value"}).getMessage(), ex);
		}
	}
	
	/**
	 * [I-Stowge Code]을 [조회] 합니다.<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchComboGeneral(String comCode) throws EventException {
		try {
			return dbDao.searchComboGeneral(comCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com General Value"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com General Value"}).getMessage(), ex);
		}
	}

	/**
	 * [Lane Code]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchLane(mdmVslSvcLaneVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * [Lane Code]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.checkLane(mdmVslSvcLaneVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Check"}).getMessage(), ex);
		}
	}

	/**
	 * [Carrier Code]을 [조회] 합니다.<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkCarrier(VskCarrierVO vskCarrierVO) throws EventException {
		try {
			return dbDao.checkCarrier(vskCarrierVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Check"}).getMessage(), ex);
		}
	}
	
	/**
	 * [VVD의 Yard]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVvdYard(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			return dbDao.searchVvdYard(vskVslPortSkdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Yard"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Yard"}).getMessage(), ex);
		}
	}
	
	/**
	 * [VVD 여부]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException {
		try {
			return dbDao.searchVVD(vskVslSkdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Search"}).getMessage(), ex);
		}
	}
		
	/**
	 * [Container 여부]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchContainer(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchContainer(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
		}
	}

	/**
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchVskVslPortList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
		}
	}

	/**
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortLoadVolList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchVskVslPortLoadVolList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port Load"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port Load"}).getMessage(), ex);
		}
	}

	/**
	 * [Container Type/Size]을 [조회] 합니다.<br>
	 * 
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCntrTpSzList() throws EventException {
		try {
			return dbDao.searchCntrTpSzList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Type Size"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Type Size"}).getMessage(), ex);
		}
	}
 
    /**
     * [VVD의 Port]을 [조회] 합니다.<br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfUtilSearchOptVO>
     * @exception EventException
     */
    public List<OpfUtilSearchOptVO> searchVvdPort(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException {
        try {
            return dbDao.searchVvdPort(opfUtilSearchOptVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        }
    }
    /**
     * Port정보 조회한다. <br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfComboVO> 
     * @throws DAOException
     */
    public List<OpfComboVO> searchPortInfo(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException{
        try {
            return dbDao.searchPortInfo(opfUtilSearchOptVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        }
    } 

    /**
     * MST_CONTAINER에서 Container No의 Validation을 체크한다.
     * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @return List<OpfComboVO>
     * @throws EventException
     */
	public List<OpfComboVO> searchCntrNoValid(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchCntrNoValid(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
		}
	}

	/**
	 * OFC_CD로 RHQ_OFC_CD를 구한다.
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchRhqOfcCd(ofcCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<MdmVslCntrInfoVO>
	 * @throws EventException
	 */
	public List<MdmVslCntrInfoVO> searchMdmVslCntrInfoList(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
		try {
			return dbDao.searchMdmVslCntrInfoList(opfStvDmgCreateVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Category Code Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Category Code Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * [VVD의 Port 및 ETA]를 [조회] 합니다.<br>
	 * 
	 * @param OpfUtilSearchOptVO opfUtilSearchOptVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortEtaList(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException {
		try {
			return dbDao.searchVskVslPortEtaList(opfUtilSearchOptVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
		}
	}

	/**
	 * 공통코드를 조회 합니다. <br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @exception EventException
	 */
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException {
		try {
			return dbDao.searchComComboList(comComboVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
		}
	}
	
}