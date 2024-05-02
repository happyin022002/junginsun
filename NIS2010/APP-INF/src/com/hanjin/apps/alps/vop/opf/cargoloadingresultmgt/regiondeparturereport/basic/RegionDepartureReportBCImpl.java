/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportBCImpl.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
* ---------------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리 
* 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
* 2011.09.02 김민아 [CHM-201113284-01] [OPF-RDR] RDR CREATION 화면 HC/RT ADD SLOT 저장로직보완 : 저장 시 RDR Utilize 에 누락된 데이터를 생성하는 로직을 추가
* 2013.11.25 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration.RegionDepartureReportDBDAO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;

/**
 * ALPS-CargoLoadingResultMgt Business Logic Basic Command implementation<br>
 * - ALPS-CargoLoadingResultMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SunyoungLee
 * @see VOP_OPF_0045EventResponse,RegionDepartureReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RegionDepartureReportBCImpl extends BasicCommandSupport implements RegionDepartureReportBC {

	// Database Access Object
	private transient RegionDepartureReportDBDAO dbDao = null;

	/**
	 * RegionDepartureReportBCImpl 객체 생성<br>
	 * RegionDepartureReportDBDAO를 생성한다.<br>
	 */
	public RegionDepartureReportBCImpl() {
		dbDao = new RegionDepartureReportDBDAO();
	}
	
	/**
	 * [Common Code]을 [조회] 합니다.<br>
	 * 
	 * @param String code
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String code) throws EventException {
		try {
			return dbDao.searchComCodeList(code);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Region"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Region"}).getMessage(), ex);
		}
	}
	
	/**
	 * [Operator]을 [조회] 합니다.<br>
	 * 
	 * @param rdrListOptionVO RDRListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchCarrierList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchCarrierList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Operator"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Operator"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR VESSAL MOVE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRVslMvmtVO> searchRDRVSLMvmtList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRVSLMvmtList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr VSL MOVE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr VSL MOVE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR NEXT PORT]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<RDRNextPortVO> searchRDRNextPortList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRNextPortList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr NEXT PORT"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr NEXT PORT"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR SLOT HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRAddSlotHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRAddSlotHeaderList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr SLOT HEADER"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr SLOT HEADER"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR ADD SLOT]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAddSlotVO>
	 * @exception EventException
	 */
	public List<RDRAddSlotVO> searchRDRAddSlotList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRAddSlotList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr ADD SLOT"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr ADD SLOT"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR SLOT UTILIZE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotUtilVO>
	 * @exception EventException
	 */
	public List<RDRSlotUtilVO> searchRDRSlotUtilList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRSlotUtilList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SLOT UTILIZE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SLOT UTILIZE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR AKWARD]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAkVO>
	 * @exception EventException
	 */
	public List<RDRAkVO> searchRDRAKList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRAKList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR AKWARD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR AKWARD"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR BREAK BULK]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRBbVO>
	 * @exception EventException
	 */
	public List<RDRBbVO> searchRDRBBList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRBBList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR BREAK BULK"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR BREAK BULK"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR Hc]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRHcVO>
	 * @exception EventException
	 */
	public List<RDRHcVO> searchRDRHCList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRHCList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR REFER MAIN TRADE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfMainTradeVO>
	 * @exception EventException
	 */
	public List<RDRRfMainTradeVO> searchRDRRfMainTradeList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRRfMainTradeList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REFER MAIN TRADE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REFER MAIN TRADE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR REFER INTER TRADE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfInterPortVO>
	 * @exception EventException
	 */
	public List<RDRRfInterPortVO> searchRDRRfInterPortList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRRfInterPortList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REFER INTER TRADE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REFER INTER TRADE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR DANGER CNTR]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRDgVO>
	 * @exception EventException
	 */
	public List<RDRDgVO> searchRDRDGList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRDGList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR DANGER"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR DANGER"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR VESSEL ALLOCATION]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslAllocVO>
	 * @exception EventException
	 */
	public List<RDRVslAllocVO> searchRDRVSLAllocList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRVSLAllocList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VESSEL ALLOCATION"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VESSEL ALLOCATION"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR SLOT RELEASE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotReleaseVO>
	 * @exception EventException
	 */
	public List<RDRSlotReleaseVO> searchRDRSlotReleaseList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRSlotReleaseList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR SLOT RELEASE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR SLOT RELEASE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR SLOT SWAP]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotSwapVO>
	 * @exception EventException
	 */
	public List<RDRSlotSwapVO> searchRDRSlotSwapList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRSlotSwapList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR SLOT SWAP"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR SLOT SWAP"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR LOAD HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRLoadHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRLoadHeaderList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR LOAD HEADER"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR LOAD HEADER"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR LOAD]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRLoadVO>
	 * @exception EventException
	 */
	public List<RDRLoadVO> searchRDRLoadList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRLoadList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR LOAD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR LOAD"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR IPC OVERUSED]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDROverUsedVO>
	 * @exception EventException
	 */
	public List<RDROverUsedVO> searchRDROverList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDROverList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR IPC OVERUSED"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR IPC OVERUSED"}).getMessage(), ex);
		}
	}
	
	/**
	 * [RDR REMARK]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRemarkVO>
	 * @exception EventException
	 */
	public List<RDRRemarkVO> searchRDRRemarkList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRRemarkList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REMARK"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR REMARK"}).getMessage(), ex);
		}
	}
    /**
     * RDR Creation Move List를 조회 합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RDRVslMvmtVO>
     * @exception EventException
     */
    public List<RDRVslMvmtVO> searchRDRCrtVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchRDRCrtVSLMvmtList(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        }
    }
    /**
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchRDRImpVSLMvmtList(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        }
    }
    /**
     * 
     * RDR Vessel Movement의 수정내용을 저장 합니다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @throws EventException
     */
    public void manageRDRVSLMvmt(RDRCrtListOptionVO rdrCrtListOptionVO,RdrCreatInfoVO[] rdrCreatInfoVOs,
            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
 
            
            dbDao.removeRdrMoveAll(rdrCrtListOptionVO);
            for( int i=0;i< rdrCreatInfoVOs.length;i++){
                
                rdrCreatInfoVOs[i].setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                rdrCreatInfoVOs[i].setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                rdrCreatInfoVOs[i].setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                rdrCreatInfoVOs[i].setRegion    (   rdrCrtListOptionVO.getRegion()   );
                rdrCreatInfoVOs[i].setUpdateUser(   signOnUserAccount.getUsr_id()    );
                rdrCreatInfoVOs[i].setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//조회옵션의 Port Cd가 Header Port Code
 
 
                rdrCreatInfoVOs[i].setEta      (   rdrCrtListOptionVO.getEta()     .replaceAll( "[^0-9]", "")     );
                rdrCreatInfoVOs[i].setEtaCanal (   rdrCrtListOptionVO.getEtaCanal().replaceAll( "[^0-9]", "")     );
                rdrCreatInfoVOs[i].setNextPort (   rdrCrtListOptionVO.getNextPort()                               );
                rdrCreatInfoVOs[i].setNextCanal(   rdrCrtListOptionVO.getNextCanal()                              );
                
                if ( !rdrCreatInfoVOs[i].getIbflag().equals("D")){
                    insertVoList.add ( rdrCreatInfoVOs[i]  );
                }
            }
 
            if ( insertVoList.size() > 0 ) {

                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****다른 Port Code로 등록되어 있는지 Region Code까지 조회 체크 ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//중복된자료 존재.
                     }
                     dbDao.addRdrHeader( rdrCrtListOptionVO );
                 }
                 dbDao.addRdrMove  (insertVoList);
            }
 
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Report Header"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Report Header"}).getMessage(), ex);
        }
    }
    /**
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrHeader(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchRdrHeader(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR MOVE"}).getMessage(), ex);
        }
    }
 

   /**
    * RDR Header, RDR Move 정보를 삭제한다. <br>
    * 
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
    * @throws EventException
    */
    public void removeRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{  
        try {
 
            dbDao.removeRdrMoveAll(rDRCrtListOptionVO);//RDR MOVE 삭제 
           // dbDao.removeRdrHeader( rDRCrtListOptionVO );//RDR HEADER 삭제.
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt Delete"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt Delete"}).getMessage(), ex);
        }
    }
 
    /**
     * RDR Slot/WGT Util 정보를  조회한다.<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{
        try {
            return dbDao.searchRdrSltWgtUtil(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
        }
    }

    /**
     * 
     * RDR Slot/WGT Util 의 수정내용을 저장 합니다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @throws EventException
     * 
     */
    public void manageRdrSltWgtUtil(RDRCrtListOptionVO rdrCrtListOptionVO,RdrCreatInfoVO[] rdrCreatInfoVOs,
            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> updateVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> deleteVoList = new ArrayList<RdrCreatInfoVO>(); 
 
            for( int i=0;i< rdrCreatInfoVOs.length;i++){

                
                String sOption =  "F,E,A,3,H,L";//F : FULL, E :Empty, A:AKBB 
                String[] aType = sOption.split(",");
                for(int j=0;j<aType.length;j++){
                    String sType    = aType[j];    
                    String sSlotQty  = "0";
 
                    RdrCreatInfoVO saveRdrCreatInfoVO = new RdrCreatInfoVO();
                    saveRdrCreatInfoVO = (RdrCreatInfoVO)rdrCreatInfoVOs[i].clone();
                    
                    saveRdrCreatInfoVO.setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                    saveRdrCreatInfoVO.setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                    saveRdrCreatInfoVO.setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                    saveRdrCreatInfoVO.setRegion    (   rdrCrtListOptionVO.getRegion()   );
                    saveRdrCreatInfoVO.setUpdateUser(   signOnUserAccount.getUsr_id()    );
                    saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//조회옵션의 Port Cd가 Header Port Code
                    
                    sType    = aType[j];
                    if(sType.equals("F")){//FULL, WEIGHT 항목은 Type Full 에만 넣는다.
                        sSlotQty  = saveRdrCreatInfoVO.getFull();          
                    }else{// WEIGHT 항목은 Type Full 에만 넣는다.
                        saveRdrCreatInfoVO.setTotalWgt("");    
                    }
                    if(sType.equals("E")){//EMPTY
                        sSlotQty = saveRdrCreatInfoVO.getEmpty();
                    }
                    if(sType.equals("A")){//AKBB
                        sSlotQty = saveRdrCreatInfoVO.getAkbb();
                    }
 
                    saveRdrCreatInfoVO.setType(sType);
                    saveRdrCreatInfoVO.setSlotQty( sSlotQty);
                    
                    if ( saveRdrCreatInfoVO.getIbflag().equals("I")){
                        if( dbDao.searchRdrUtilize(saveRdrCreatInfoVO).size() ==  0){
                            insertVoList.add ( saveRdrCreatInfoVO  );
                        }else{
                            updateVoList.add ( saveRdrCreatInfoVO );
                        }
                    }
                    if ( saveRdrCreatInfoVO.getIbflag().equals("U")){
                        updateVoList.add ( saveRdrCreatInfoVO );
                    }
                    if ( saveRdrCreatInfoVO.getIbflag().equals("D")){
                        deleteVoList.add ( saveRdrCreatInfoVO  );
                    }
                }
            }
 
            if ( insertVoList.size() > 0 ) {
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****다른 Port Code로 등록되어 있는지 Region Code까지 조회 체크 ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//중복된자료 존재.
                     }
                     dbDao.addRdrHeader( rdrCrtListOptionVO );
                 }
                 dbDao.addRdrSlotWgtUtil( insertVoList);
            }
            if ( updateVoList.size() > 0 ) {
                 dbDao.modifyRdrSlotWgtUtil(updateVoList);
            }
  
            if ( deleteVoList.size() > 0 ) {
                 dbDao.removeRdrSlotWgtUtil(deleteVoList);
            }
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
        }
    }
    /**
     * RDR Utilize 정보를 삭제한다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
     * @throws EventException
     */
     public void removeRdrSltWgtUtilAll(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{  
         try {
             dbDao.removeRdrSltWgtUtilAll(rDRCrtListOptionVO); 
         } catch (DAOException ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt"}).getMessage(), ex);
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt"}).getMessage(), ex);
         }
     }
     /**
      * RDR HC/45 정보를  조회한다.<br>
      * 
      * @param RDRCrtListOptionVO rDRCrtListOptionVO
      * @return List<RdrCreatInfoVO>
      * @throws EventException
      */
     public List<RdrCreatInfoVO> searchRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{
         try {
             return dbDao.searchRdrHC45(rDRCrtListOptionVO);
         } catch (DAOException ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
         }
     }

     /**
      * 
      * RDR HC45 의 수정내용을 저장 합니다. <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
      * @param  SignOnUserAccount  signOnUserAccount
      * @throws EventException
      * 
      */
    public void manageRdrHC45(RDRCrtListOptionVO rdrCrtListOptionVO,
            RdrCreatInfoVO[] rdrCreatInfoVOs,
            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> updateVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> deleteVoList = new ArrayList<RdrCreatInfoVO>(); 
 
            for( int i=0;i< rdrCreatInfoVOs.length;i++){

                RdrCreatInfoVO saveRdrCreatInfoVO = new RdrCreatInfoVO();
                saveRdrCreatInfoVO = (RdrCreatInfoVO)rdrCreatInfoVOs[i].clone();
                
                saveRdrCreatInfoVO.setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                saveRdrCreatInfoVO.setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                saveRdrCreatInfoVO.setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                saveRdrCreatInfoVO.setRegion    (   rdrCrtListOptionVO.getRegion()   );
                saveRdrCreatInfoVO.setUpdateUser(   signOnUserAccount.getUsr_id()    );
                saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//조회옵션의 Port Cd가 Header Port Code
 
                if ( saveRdrCreatInfoVO.getIbflag().equals("I") || saveRdrCreatInfoVO.getIbflag().equals("U")){
                    List<RdrCreatInfoVO> rdrBsa = dbDao.searchRdrBsa( saveRdrCreatInfoVO );
                    if( rdrBsa.size() == 0){
                        insertVoList.add ( saveRdrCreatInfoVO  );
                    }else{
                        updateVoList.add ( saveRdrCreatInfoVO );
                    }
                }
 
                if ( saveRdrCreatInfoVO.getIbflag().equals("D")){
                    deleteVoList.add ( saveRdrCreatInfoVO  );
                }
            }
            
            if ( insertVoList.size() > 0 ) {
                /************* RDR_HEADER 정보 조회하여 없으면 생성한다. *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****다른 Port Code로 등록되어 있는지 Region Code까지 조회 체크 ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//중복된자료 존재.
                     }
                     dbDao.addRdrHeader( rdrCrtListOptionVO );
                 }

            }
            if ( insertVoList.size() > 0 ) {
                dbDao.addRdrHC45ForBSA(insertVoList);
 
                for(int i=0;i<insertVoList.size();i++){
                    RdrCreatInfoVO chkRdrCreatInfoVO = insertVoList.get(i);
                    List<RdrCreatInfoVO> utilRdrCreatInfoVO = dbDao.searchRdrUtilize(chkRdrCreatInfoVO);
                    if(  utilRdrCreatInfoVO.size() == 0 ){
                        this.addRdrUtilize(chkRdrCreatInfoVO);//"F,E,A,3,H,L" 건씩 생성..
                    }else  if(  utilRdrCreatInfoVO.size() > 0 ){
                        this.modifyUtilizeForHC45( insertVoList );
                    }
                }
            }
            
            
            
            if ( updateVoList.size() > 0 ) {
            	
            	/*RDR Utilize 에 Update 하려는  Type이 존재하지 않는 경우 생성 */
            	List<RdrCreatInfoVO> mtyRdrUtilize = dbDao.searchMtyRdrUtilize( updateVoList, rdrCrtListOptionVO );
            	if(mtyRdrUtilize.size() > 0){
            		dbDao.addRdrSlotWgtUtil(mtyRdrUtilize);
            	}
            	
                 this.modifyUtilizeForHC45( updateVoList );
                 dbDao.modifyRdrHC45ForBSA( updateVoList );
            }
 
            if ( deleteVoList.size() > 0 ) {
                 dbDao.removeRdrUtilizeLoad(deleteVoList);
                 dbDao.removeRdrUtilizeHC(deleteVoList);
                 
                 dbDao.removeRdrHC45ForBSA(deleteVoList);
            }
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
        }
        
    }
    
 
    /**
     *  RDR HC/45에서 수정시, TYPE별 로직을 사용하여 수정한다.<br>
     * 
     * @param  RdrCreatInfoVO rdrCreatInfoVO
     * @throws DAOException
     */
     private void modifyUtilizeForHC45(List<RdrCreatInfoVO> voList) throws Exception{
         String[] aType = "F,3,H,L".split(",");
         for(int i=0;i<voList.size();i++){
             RdrCreatInfoVO rdrGridCreatInfoVO =  voList.get(i);
             
             /*********************그리드 건당 Empty를 제외한,  F, 3, H, L,  수정.********************/
             for(int j=0;j<aType.length;j++  ){
 
                 if( aType[j].equals("3")) {
                     rdrGridCreatInfoVO.setSlotQty  ( rdrGridCreatInfoVO.getAdd20() );
                 }
                 if( aType[j].equals("H")) {
                     rdrGridCreatInfoVO.setSlotQty(   rdrGridCreatInfoVO.getAdd40() );
                 }
                 if( aType[j].equals("L")) {
                     rdrGridCreatInfoVO.setSlotQty(   rdrGridCreatInfoVO.getAdd45() );
                 }
                 rdrGridCreatInfoVO.setType( aType[j] );
                 dbDao.modifyUtilizeForHC45(rdrGridCreatInfoVO);
             }
         }
         
     }
    
    /**
     * 
     *  Load HC/45 저장한다..
     *  F,E,A,H 4건씩 생성한다.
     *  <br>
     *
     * @param RdrCreatInfoVO RdrCreatInfoVO
     * @throws EventException
     * @author jang kang cheol
     */
    private void addRdrUtilize(RdrCreatInfoVO rdrCreatInfoVO)  throws  Exception {
        String sOption = "F,E,A,3,H,L";//F : FULL, E :Empty, A:AKBB, 3:20 High Cubic, H : 40 High Cubic, L : 45 
        String[] aOption = sOption.split(",");
        List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
        try{
 
                for(int j=0;j<aOption.length;j++){
                    String sType    = aOption[j];    

                    RdrCreatInfoVO saveRdrCreatInfoVO =  (RdrCreatInfoVO) rdrCreatInfoVO.clone();
                    saveRdrCreatInfoVO.setType( sType );
                    /******************HC45의 Load값은 Utilize의 Type = F 에만 입력한다.**********************/
                    if( sType.equals("F")) {
                    saveRdrCreatInfoVO.setSlotHc20( saveRdrCreatInfoVO.getLoad20() );
                    saveRdrCreatInfoVO.setSlotHc(   saveRdrCreatInfoVO.getLoad40() );
                    saveRdrCreatInfoVO.setSlot45(   saveRdrCreatInfoVO.getLoad45() );
                    }
                    if( sType.equals("3")) {
                        saveRdrCreatInfoVO.setSlotQty  ( saveRdrCreatInfoVO.getAdd20() );
                    }
                    if( sType.equals("H")) {
                        saveRdrCreatInfoVO.setSlotQty(   saveRdrCreatInfoVO.getAdd40() );
                    }
                    if( sType.equals("L")) {
                        saveRdrCreatInfoVO.setSlotQty(   saveRdrCreatInfoVO.getAdd45() );
                    }
                    insertVoList.add(  saveRdrCreatInfoVO  );
                }
      
            dbDao.addRdrSlotWgtUtil(insertVoList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        }
    }
    /**
     * RDR HC/45 정보를  삭제 한다.<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
     * @throws EventException
     */
    public void removeRdrHC45(RDRCrtListOptionVO rdrCrtListOptionVO ) throws EventException {
        try {
            dbDao.removeRdrHC45ForBsaAll(rdrCrtListOptionVO);
            dbDao.removeRdrUtilizeAll(rdrCrtListOptionVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VslMvmt"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VslMvmt"}).getMessage(), ex);
        }
        
    }
    /**
     * RDR HC/45 Import Sub Allocation 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{
        try {
            return dbDao.searchRDRImpHC45(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45 Sub Allocatioin"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45 Sub Allocatioin"}).getMessage(), ex);
        }
    }
 
    /**
     * RDR RF의 Main Trade 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListMainTrade(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{
        try {
            return dbDao.searchRdrRfListMainTrade(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        }
    }
    /**
     * RDR RF의 Main Trade 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListInterPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{
        try {
            return dbDao.searchRdrRfListInterPort(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        }
    }

    /**
     * 
     * RDR RF 의 수정내용을 저장 합니다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoMainTradeVOs
     * @param  RdrCreatInfoVO[]   rdrCreatInfoInterPortVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @throws EventException
     * 
     */
    public void manageRdrRf(RDRCrtListOptionVO rdrCrtListOptionVO, 
                            RdrCreatInfoVO[] rdrCreatInfoMainTradeVOs,
                            RdrCreatInfoVO[] rdrCreatInfoInterPortVOs,
                            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> updateVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> deleteVoList = new ArrayList<RdrCreatInfoVO>(); 
 
            int idx = 0;
            int mainLengh = 0;
            int interLengh = 0;
            if(rdrCreatInfoMainTradeVOs != null){  mainLengh = rdrCreatInfoMainTradeVOs.length; }
            if(rdrCreatInfoInterPortVOs != null){  interLengh = rdrCreatInfoInterPortVOs.length; }
            idx = mainLengh+interLengh;
            RdrCreatInfoVO[] rdrCreatInfoVO = new RdrCreatInfoVO[ idx ];
 
            /************************하나의 VO로 통합**********************************************/
 
            for(int k=0; k<mainLengh; k++){
 
                rdrCreatInfoVO[k] = rdrCreatInfoMainTradeVOs[k];//cntr_type
                rdrCreatInfoVO[k].setCntrType("T");
            }
 
 
            for(int k=0; k < interLengh; k++){
 
                rdrCreatInfoVO[ k+mainLengh ] = rdrCreatInfoInterPortVOs[k];
                rdrCreatInfoVO[ k+mainLengh ].setCntrType("I");
            }
 
             
            for( int i=0;i< rdrCreatInfoVO.length;i++){
                
                String   sQtyType = "2,4";//2: 20Qty, 4 : 40Qty
                String[] aQtyType = sQtyType.split(",");
                
                for(int j=0; j<aQtyType.length; j++){// QtyType별로 레코드 생성, 20, 40 이므로 , Grid Row당, 최대 2건씩 생성.
                    RdrCreatInfoVO saveRdrCreatInfoVO = new RdrCreatInfoVO();
                    saveRdrCreatInfoVO = (RdrCreatInfoVO)rdrCreatInfoVO[i].clone();
                    
                    saveRdrCreatInfoVO.setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                    saveRdrCreatInfoVO.setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                    saveRdrCreatInfoVO.setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                    saveRdrCreatInfoVO.setRegion    (   rdrCrtListOptionVO.getRegion()   );
                    saveRdrCreatInfoVO.setUpdateUser(   signOnUserAccount.getUsr_id()    );
                    saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//조회옵션의 Port Cd가 Header Port Code
     
                    String sCntrSize =  aQtyType[j];
                    String sQty      = "";
 
                    if(aQtyType[j].equals("2")){
                        sQty    =  saveRdrCreatInfoVO.getQty20()==null?"0": saveRdrCreatInfoVO.getQty20();
                    }else if(aQtyType[j].equals("4")){
                        sQty    =  saveRdrCreatInfoVO.getQty40()==null?"0": saveRdrCreatInfoVO.getQty40();
                    }
                    saveRdrCreatInfoVO.setCntrSize(      sCntrSize  );
                    saveRdrCreatInfoVO.setQty     (      sQty       );
                    
                    if ( saveRdrCreatInfoVO.getIbflag().equals("I")){
                        insertVoList.add ( saveRdrCreatInfoVO  );
                    }
                    if ( saveRdrCreatInfoVO.getIbflag().equals("U")){
                        updateVoList.add ( saveRdrCreatInfoVO );
                    }
                    if ( saveRdrCreatInfoVO.getIbflag().equals("D")){
                        deleteVoList.add ( saveRdrCreatInfoVO  );
                    }
                }
            }
 
            
            
            if ( insertVoList.size() > 0 ) {
                /************* RDR_HEADER 정보 조회하여 없으면 생성한다. *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****다른 Port Code로 등록되어 있는지 Region Code까지 조회 체크 ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//중복된자료 존재.
                     }
                     dbDao.addRdrHeader( rdrCrtListOptionVO );
                 }
            }
            if ( insertVoList.size() > 0 ) {
                dbDao.addRdrRf(insertVoList);
            }

            if ( updateVoList.size() > 0 ) {
                dbDao.modifyRdrRf(updateVoList);
            }
 
            if ( deleteVoList.size() > 0 ) {
                dbDao.removeRdrRf(deleteVoList);
            }
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        }
    }
    /**
     * RDR REPORT RF 를 전제(VVD, REGION 별) 삭제  합니다.<br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO 
     * @throws EventException
     */
    public void removeRdrRfAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException {
        try {
 
            dbDao.removeRdrRfAll(rdrCrtListOptionVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VslMvmt"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VslMvmt"}).getMessage(), ex);
        }
    }


    /**
     * 
     * RDR VSL Alloc 정보를  조회한다.<br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
     * @author jang kang cheol
     */
    public List<RdrCreatInfoVO> searchRdrVSLAlloc(
            RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException {
 
        try {
            return dbDao.searchRdrVSLAlloc(rdrCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Import RDR VSL Allocation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Import RDR VSL Allocation"}).getMessage(), ex);
        }
    }
 
    /**
     * 
     * Import RDR VSL Alloc 정보를  조회한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
     * @author jang kang cheol
     */
    public List<RdrCreatInfoVO> searchImpRdrVSLAlloc(
            RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchImpRdrVSLAlloc(rdrCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
        }
    }
    
    /**
     * 
     * RDR Vsl Allocation 정보를  저장 한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[] rdrCreatInfoVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @author jang kang cheol
     */
    public void manageRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO,
            RdrCreatInfoVO[] rdrCreatInfoVOs,
            SignOnUserAccount signOnUserAccount) throws EventException {
 
        try{
            List<RdrCreatInfoVO> insertVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> updateVoList = new ArrayList<RdrCreatInfoVO>();
            List<RdrCreatInfoVO> deleteVoList = new ArrayList<RdrCreatInfoVO>(); 
 
            for( int i=0;i< rdrCreatInfoVOs.length;i++){

                RdrCreatInfoVO saveRdrCreatInfoVO = new RdrCreatInfoVO();
                saveRdrCreatInfoVO = (RdrCreatInfoVO)rdrCreatInfoVOs[i].clone();
                
                saveRdrCreatInfoVO.setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                saveRdrCreatInfoVO.setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                saveRdrCreatInfoVO.setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                saveRdrCreatInfoVO.setRegion    (   rdrCrtListOptionVO.getRegion()   );
                saveRdrCreatInfoVO.setUpdateUser(   signOnUserAccount.getUsr_id()    );
                saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//조회옵션의 Port Cd가 Header Port Code
                saveRdrCreatInfoVO.setSegment(      rdrCrtListOptionVO.getSegment()  );
                
                if ( saveRdrCreatInfoVO.getIbflag().equals("I")){
                    if( dbDao.searchRdrAllocation(saveRdrCreatInfoVO).size() == 0){
                        insertVoList.add ( saveRdrCreatInfoVO  );
                    }else{
                        updateVoList.add ( saveRdrCreatInfoVO );
                    }
                }
                if ( saveRdrCreatInfoVO.getIbflag().equals("U")){
                    updateVoList.add ( saveRdrCreatInfoVO );
                }
                if ( saveRdrCreatInfoVO.getIbflag().equals("D")){
                    deleteVoList.add ( saveRdrCreatInfoVO  );
                }
            }
            
            if ( insertVoList.size() > 0 ) {
                /************* RDR_HEADER 정보 조회하여 없으면 생성한다. *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****다른 Port Code로 등록되어 있는지 Region Code까지 조회 체크 ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//중복된자료 존재.
                     }
                     dbDao.addRdrHeader( rdrCrtListOptionVO );
                 }
            }
 
            if ( insertVoList.size() > 0 ) {
                dbDao.addRdrAllocation(insertVoList);
            }
            if ( updateVoList.size() > 0 ) {
                 dbDao.modifyRdrAllocation(updateVoList);
            }
 
            if ( deleteVoList.size() > 0 ) {
                 dbDao.removeRdrAllocation(deleteVoList);
            }
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR ALLOCATION"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR ALLOCATION"}).getMessage(), ex);
        }
    }

    /**
     * 
     * RDR VSL Allocation 정보를  삭제 한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void removeRdrVSLAllocAll(RDRCrtListOptionVO rdrCrtListOptionVO)
            throws EventException {
        try {
            
            dbDao.removeRdrAllocationAll(rdrCrtListOptionVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
        }
        
    }

    /**
     * 
     * RDR Header의 Remark 정보를  저장 한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void modifyRdrHeaderForRemark(RDRCrtListOptionVO rdrCrtListOptionVO ) throws EventException {
        try {
 
            dbDao.modifyRdrHeaderForRemark(rdrCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Remakr"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Remark"}).getMessage(), ex);
        }
    }

    /**
     * 
     * Import RDR VSL Alloc 정보를  조회한다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
     * @author jang kang cheol
     */
    public List<RdrCreatInfoVO> searchRdrHeaderRemark(
            RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchRdrHeaderRemark(rdrCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Remark"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Remark"}).getMessage(), ex);
        }
    }

    /**
     * [RDR NEXT PORT]을 [조회] 합니다.<br>
     * 
     * @param RDRCrtListOptionVO rdrCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @exception EventException
     */
    public List<RdrCreatInfoVO> searchRDRCreNextPortList( RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException {
        try {
            return dbDao.searchRDRCreNextPortList(rdrCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr NEXT PORT"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr NEXT PORT"}).getMessage(), ex);
        }
    }

    /**
     * VOP_OPF_0046  : Delete <br>
     * RDR  모든 정보를  삭제 한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void removeRdrData(RDRCrtListOptionVO rdrCrtListOptionVO)
            throws EventException {
        try {
            dbDao.removeRdrMoveAll(rdrCrtListOptionVO);// VSL Mvmt
            dbDao.removeRdrUtilize(rdrCrtListOptionVO);//// Slot/UTil , T:RDR_UTILIZE
            dbDao.removeRdrHC45ForBsaAll(rdrCrtListOptionVO);//T:RDR_BSA
            dbDao.removeRdrRfAll(rdrCrtListOptionVO);//T:RDR_SUMMARY
            dbDao.removeRdrAllocationAll(rdrCrtListOptionVO);//T:RDR_ALLOCATION
            dbDao.removeRdrHeader(rdrCrtListOptionVO);;//T:RDR_HEADER
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Data Remove"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Data Remove"}).getMessage(), ex);
        }
    }
    
	/**
	 * [RDR Creation 화면 VVD 별 Last Port ] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRCrtListOptionVO rDRCrtListOptionVO
	 * @return List<RDRSearchRegionLastPortVO>
	 * @exception EventException
	 */
	public List<RDRSearchRegionLastPortVO> searchRegionLastPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException {
		try {
			return dbDao.searchRegionLastPort(rDRCrtListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr VSL MOVE"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr VSL MOVE"}).getMessage(), ex);
		}
	}
	
	/**
	 * [Region Code]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchRDRRegionList(RDRListOptionVO rdrListOptionVO) throws EventException {
		try {
			return dbDao.searchRDRRegionList(rdrListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Region"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rdr Region"}).getMessage(), ex);
		}
	}
	
	
    /**
     * [RDR Summary]을 [조회] 합니다.<br>
     * 
     * @param  RDRSummaryVO rDRSummaryVO
     * @return List<RDRSummaryVO>
     * @exception EventException
     */
    public List<RDRSummaryVO> searchRDRSummaryList(RDRSummaryVO rDRSummaryVO) throws EventException {
        try {

        	rDRSummaryVO.setFrWeekNo(rDRSummaryVO.getFrWeekNo().replaceAll("-", ""));
        	rDRSummaryVO.setToWeekNo(rDRSummaryVO.getToWeekNo().replaceAll("-", ""));
            return dbDao.searchRDRSummaryList(rDRSummaryVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Summary"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Summary"}).getMessage(), ex);
        }
    }
 
}