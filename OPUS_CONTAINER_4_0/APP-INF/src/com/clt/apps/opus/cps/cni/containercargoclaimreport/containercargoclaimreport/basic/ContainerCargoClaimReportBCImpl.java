/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerCargoClaimReportBCImpl.java
 *@FileTitle : Container Cargo Claim Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.05
 *@LastModifier : 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 *@LastVersion : 1.0
 * 2009.11.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration.ContainerCargoClaimReportDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByAreaVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByCargoVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByHofcVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByClaimantVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 * Container Cargo Claim 에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 
 * @see ContainerCargoClaimReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ContainerCargoClaimReportBCImpl extends BasicCommandSupport implements ContainerCargoClaimReportBC
{

    // Database Access Object
    private transient ContainerCargoClaimReportDBDAO dbDao = null;

    /**
     * ContainerCargoClaimReportBCImpl 객체 생성<br>
     * ContainerCargoClaimReportDBDAO 생성한다.<br>
     */
    public ContainerCargoClaimReportBCImpl()
    {
        dbDao = new ContainerCargoClaimReportDBDAO();
    }


    // ===========================================================================
    // 진윤오
    // ===========================================================================

    // ===========================================================================
    // 양정란
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0020] Report-Settlement Analysis
	// ---------------------------------------------------------------------------      
	/**
	 * Report-Settlement Analysis 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category searchSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws EventException
     */
	public List<SettlementAnalysisVO> searchSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws EventException {

		try {
			
			List<SettlementAnalysisVO> returnList = new ArrayList<SettlementAnalysisVO>();
			
			returnList = dbDao.searchSettlementAnalysisList(settlementAnalysisCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				SettlementAnalysisVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}	
	/**
	 * Report-Settlement Analysis Print<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category printSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws EventException
     */
	public List<SettlementAnalysisVO> printSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws EventException {

		try {
			
			List<SettlementAnalysisVO> returnList = new ArrayList<SettlementAnalysisVO>();
			
			returnList = dbDao.printSettlementAnalysisList(settlementAnalysisCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				SettlementAnalysisVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	// ===========================================================================
    // 정행룡
    // ===========================================================================
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0018] Status
    // ---------------------------------------------------------------------------	

    /**
	 * Status 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category searchStatusList 
	 * @param StatusCondVO statusCondVO
     * @return  List<StatusVO>
     * @throws EventException
     */
	public List<StatusVO> searchStatusList(StatusCondVO statusCondVO) throws EventException {

		try {
			
			List<StatusVO> returnList = new ArrayList<StatusVO>();
			
			returnList = dbDao.searchStatusList(statusCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				StatusVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Claim Main Report 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoClaimReport
	 * @param String cgoClmNo
	 * @param String usrId
     * @return CargoClaimReportVO 
     * @throws EventException
     */
	public CargoClaimReportVO printCargoClaimReport(String cgoClmNo, String usrId) throws EventException {
    	try {
			return dbDao.printCargoClaimReport(cgoClmNo, usrId);
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
    	
    }
	
	/**
	 * Claim Main Report 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoLitigationReport
	 * @param String cgoClmNo
     * @param String usrId
     * @return CargoLitigationReportVO
     * @throws EventException
     */
	public CargoLitigationReportVO printCargoLitigationReport(String cgoClmNo, String usrId) throws EventException {
    	try {
			return dbDao.printCargoLitigationReport(cgoClmNo, usrId);
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
    	
    }
	
	
    // ===========================================================================
    // 박제성
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by Area
	// ---------------------------------------------------------------------------      
    /**
	 * Occurrence Analysis by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByAreaVO> searchOccurrenceAnalysisByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<OccurrenceAnalysisByAreaVO> returnList = new ArrayList<OccurrenceAnalysisByAreaVO>();
			
			returnList = dbDao.searchOccurrenceAnalysisByAreaList(occurrenceAnalysisCondVO);
			
	
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by HOFC
	// ---------------------------------------------------------------------------      
    /**
	 * Occurrence Analysis by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByHofcVO> searchOccurrenceAnalysisByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<OccurrenceAnalysisByHofcVO> returnList = new ArrayList<OccurrenceAnalysisByHofcVO>();
			
			returnList = dbDao.searchOccurrenceAnalysisByHofcList(occurrenceAnalysisCondVO);
			
	
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by Cargo
	// ---------------------------------------------------------------------------      
    /**
	 * Occurrence Analysis by Cargo 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByCargoList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByCargoVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByCargoVO> searchOccurrenceAnalysisByCargoList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<OccurrenceAnalysisByCargoVO> returnList = new ArrayList<OccurrenceAnalysisByCargoVO>();
			
			returnList = dbDao.searchOccurrenceAnalysisByCargoList(occurrenceAnalysisCondVO);
			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by Area
	// ---------------------------------------------------------------------------      
    /**
	 * Total Occurrence by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByAreaVO> searchTotalOccurrenceByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<OccurrenceAnalysisByAreaVO> returnList = new ArrayList<OccurrenceAnalysisByAreaVO>();
			
			returnList = dbDao.searchTotalOccurrenceByAreaList(occurrenceAnalysisCondVO);
			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by HOFC
	// ---------------------------------------------------------------------------      
    /**
	 * Total Occurrence by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByHofcVO> searchTotalOccurrenceByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<OccurrenceAnalysisByHofcVO> returnList = new ArrayList<OccurrenceAnalysisByHofcVO>();
			
			returnList = dbDao.searchTotalOccurrenceByHofcList(occurrenceAnalysisCondVO);
			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by VVD
	// ---------------------------------------------------------------------------      
    /**
	 * Total Occurrence by VVD 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByVvdList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByVvdVO>
     * @throws EventException
     */
	public List<TotalOccurrenceByVvdVO> searchTotalOccurrenceByVvdList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<TotalOccurrenceByVvdVO> returnList = new ArrayList<TotalOccurrenceByVvdVO>();
			
			returnList = dbDao.searchTotalOccurrenceByVvdList(occurrenceAnalysisCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				TotalOccurrenceByVvdVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by Claimant
	// ---------------------------------------------------------------------------      
    /**
	 * Total Occurrence by Claimant 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByClaimantList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByClaimantVO>
     * @throws EventException
     */
	public List<TotalOccurrenceByClaimantVO> searchTotalOccurrenceByClaimantList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException {

		try {
			
			List<TotalOccurrenceByClaimantVO> returnList = new ArrayList<TotalOccurrenceByClaimantVO>();
			
			returnList = dbDao.searchTotalOccurrenceByClaimantList(occurrenceAnalysisCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				TotalOccurrenceByClaimantVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	


	
}