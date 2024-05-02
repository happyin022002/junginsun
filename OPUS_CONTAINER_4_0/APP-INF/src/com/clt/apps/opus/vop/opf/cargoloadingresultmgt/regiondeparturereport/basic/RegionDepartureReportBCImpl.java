/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportBCImpl.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration.RegionDepartureReportDBDAO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * OPUS-CargoLoadingResultMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VOP_OPF_0045EventResponse,RegionDepartureReportBC
 * @since J2EE 1.6
 */
public class RegionDepartureReportBCImpl extends BasicCommandSupport implements RegionDepartureReportBC {

	// Database Access Object
	private transient RegionDepartureReportDBDAO dbDao = null;

	/**
	 * Creating object RegionDepartureReportBCImpl <br>
	 * Creating RegionDepartureReportDBDAO<br>
	 */
	public RegionDepartureReportBCImpl() {
		dbDao = new RegionDepartureReportDBDAO();
	}
	
	/**
	 * Retrieve[Region Code]<br>
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
	 * Retrieve[Operator]<br>
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
	 * Retrieve[RDR VESSAL MOVE]<br>
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
	 * Retrieve[RDR NEXT PORT]<br>
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
	 * Retrieve[RDR SLOT HEADER]<br>
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
	 * Retrieve[RDR ADD SLOT]<br>
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
	 * Retrieve[RDR SLOT UTILIZE]<br>
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
	 * Retrieve[RDR AKWARD]<br>
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
	 * Retrieve[RDR BREAK BULK]<br>
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
	 * Retrieve[RDR Hc]<br>
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
	 * Retrieve[RDR REFER MAIN TRADE]<br>
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
	 * Retrieve[RDR REFER INTER TRADE]<br>
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
	 * Retrieve[RDR DANGER CNTR]<br>
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
	 * Retrieve[RDR VESSEL ALLOCATION]<br>
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
	 * Retrieve[RDR SLOT RELEASE]<br>
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
	 * Retrieve[RDR SLOT SWAP]<br>
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
	 * Retrieve[RDR LOAD HEADER]<br>
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
	 * Retrieve[RDR LOAD]<br>
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
	 * Retrieve[RDR IPC OVERUSED]<br>
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
	 * Retrieve[RDR REMARK]<br>
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
     * Retrieve Move List of RDR Creation<br>
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
     * Retrieve to Import Vessel Movement Info<br>
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
     * Save modification of RDR Vessel Movement <br>
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
                rdrCreatInfoVOs[i].setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//Port Cd is Header Port Code in retrieve condition
 
 
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
                     /****Checking retrieve Region Code if it is registered with other Port Code ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//exist duplication.
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
     * Retrieve to Import Vessel Movement Info<br>
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
    * Delete RDR Header, RDR Move Info <br>
    * 
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
    * @throws EventException
    */
    public void removeRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException{  
        try {
 
            dbDao.removeRdrMoveAll(rDRCrtListOptionVO);//Delete RDR MOVE  
           // dbDao.removeRdrHeader( rDRCrtListOptionVO );//Delete RDR HEADER 
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt Delete"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VslMvmt Delete"}).getMessage(), ex);
        }
    }
 
    /**
     * Retrieve RDR Slot/WGT Util Info<br>
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
     * Save modification of RDR Slot/WGT Util <br>
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
                    saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//Port Cd is Header Port Code in retrieve condition
                    
                    sType    = aType[j];
                    if(sType.equals("F")){//Input FULL, WEIGHT item to only Type Full 
                        sSlotQty  = saveRdrCreatInfoVO.getFull();          
                    }else{// Input WEIGHT item to only Type Full
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
                     /****Checking retrieve Region Code if it is registered with other Port Code ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//exist duplication..
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
     * Delete RDR Utilize Info <br>
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
      * Retrieve RDR HC/45 Info<br>
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
      * Save modification of RDR HC45 <br>
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
                saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//Port Cd is Header Port Code in retrieve condition
 
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
                /************* After retrieve RDR_HEADER Info, if not exist, create  *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****Checking retrieve Region Code if it is registered with other Port Code ***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//exist duplication.
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
                        this.addRdrUtilize(chkRdrCreatInfoVO);//Create "F,E,A,3,H,L" 
                    }else  if(  utilRdrCreatInfoVO.size() > 0 ){
                        this.modifyUtilizeForHC45( insertVoList );
                    }
                }
            }
            
            
            
            if ( updateVoList.size() > 0 ) {
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
     *  In case of modifying in RDR HC/45, modify by using logic of TYPE<br>
     * 
     * @param  RdrCreatInfoVO rdrCreatInfoVO
     * @throws DAOException
     */
     private void modifyUtilizeForHC45(List<RdrCreatInfoVO> voList) throws Exception{
         String[] aType = "F,3,H,L".split(",");
         for(int i=0;i<voList.size();i++){
             RdrCreatInfoVO rdrGridCreatInfoVO =  voList.get(i);
             
             /*********************Modify F, 2, H, L except Empty by one Grid ********************/
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
     *  Save Load HC/45
     *  Creating 4 by F,E,A,H 
     *  <br>
     *
     * @param RdrCreatInfoVO RdrCreatInfoVO
     * @throws EventException
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
                    /******************Input Load value of HC45 to only Type = F of Utilize**********************/
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
     * Delete RDR HC45 Info<br>
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
     * Retrieve RDR HC/45 Import Sub Alloction Info<br>
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
     *  Retrieve Main Trade Info of RDR RF<br>
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
     * Retrieve Main Trade Info of RDR RF<br>
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
     * Save modification of RDR RF <br>
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
 
            /************************Integrating one VO**********************************************/
 
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
                
                for(int j=0; j<aQtyType.length; j++){// Creating Record by QtyTyp. As Type is 20, 40, Creating max 2 by Grid Row.
                    RdrCreatInfoVO saveRdrCreatInfoVO = new RdrCreatInfoVO();
                    saveRdrCreatInfoVO = (RdrCreatInfoVO)rdrCreatInfoVO[i].clone();
                    
                    saveRdrCreatInfoVO.setVslCd     (   rdrCrtListOptionVO.getVslCd()    );
                    saveRdrCreatInfoVO.setVoyNo     (   rdrCrtListOptionVO.getVoyNo()    );
                    saveRdrCreatInfoVO.setDirCd     (   rdrCrtListOptionVO.getDirCd()    );
                    saveRdrCreatInfoVO.setRegion    (   rdrCrtListOptionVO.getRegion()   );
                    saveRdrCreatInfoVO.setUpdateUser(   signOnUserAccount.getUsr_id()    );
                    saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//Port Cd is Header Port Code in retrieve condition
     
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
                /************* After retrieve RDR_HEADER Info, if not exist, create  *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****Checking retrieve Region Code if it is registered with other Port Code***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());
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
     * Delete all RDR REPORT RF by VVD, REGION <br>
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
     * Retrieve RDR VSL Alloc Info<br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
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
     * Retrieve Import RDR VSL Alloc Info <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
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
     * Save RDR Vsl Allocation Info <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[] rdrCreatInfoVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
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
                saveRdrCreatInfoVO.setHeadPortCd(   rdrCrtListOptionVO.getPortCd()   );//Port Cd is Header Port Code in retrieve condition
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
                /************* After retrieve RDR_HEADER Info, if not exist, create . *****************/
                 List<RdrCreatInfoVO> rdrHeader = dbDao.searchRdrHeader( rdrCrtListOptionVO );
                 if(rdrHeader.size() == 0){
                     /****Checking retrieve Region Code if it is registered with other Port Code***/
                     if( dbDao.searchRdrHeaderCheck(rdrCrtListOptionVO).size() > 0 ){
                         throw new EventException(new ErrorHandler("OPF00007",  new String[] {}).getMessage());//exist duplication.
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
     * Delete RDR VSL Allocation Info <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
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
     * Save Remark Info of RDR Header  <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
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
     * Retrieve Import RDR VSL Alloc Info <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @return List<RdrCreatInfoVO>
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
     * Retrieve [RDR NEXT PORT]<br>
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
     * Delete all RDR Info  <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @author
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
}