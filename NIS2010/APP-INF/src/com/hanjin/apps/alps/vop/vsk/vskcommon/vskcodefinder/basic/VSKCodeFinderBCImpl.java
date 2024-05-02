/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBCImpl.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
*
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. 조회 조건 Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 / ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
* 2011.10.11 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LaneDirVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VslSvcLaneforBudgetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * NIS2010-VSKCommon Business Logic Basic Command implementation<br>
 * - NIS2010-VSKCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEO CHANG YUL
 * @see UI_VSK-0202EventResponse,VSKCodeFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class VSKCodeFinderBCImpl extends BasicCommandSupport implements VSKCodeFinderBC {

	// Database Access Object
	private transient VSKCodeFinderDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl 객체 생성<br>
	 * VSKCodeFinderDBDAO를 생성한다.<br>
	 */
	public VSKCodeFinderBCImpl() {
		dbDao = new VSKCodeFinderDBDAO();
	}
	
	/**
	 * Service Lane 리스트를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchSvcLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchSvcLaneList(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	/**
	 * Service Lane (for BUDGET) 리스트를 조회합니다.
	 * 
	 * @param VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO
	 * @return List<VslSvcLaneforBudgetVO>
	 * @exception EventException
	 */
	public List<VslSvcLaneforBudgetVO> searchSvcLaneforBudgetList(VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO) throws EventException {
		try {
			
			return dbDao.searchSvcLaneforBudgetList(vslSvcLaneforBudgetVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}	
	
	/**
	 * Service Lane Code를 검증합니다. 
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkSvcLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			List<MdmVslSvcLaneVO> list = dbDao.checkSvcLane(mdmVslSvcLaneVO);
			/*
			if(list==null || list.size()==0){
				// Service Lane Code가 등록되여 있지 않을 경우에 표시
				//throw new EventException(new ErrorHandler("VSK10019").getUserMessage());
				throw new EventException(new ErrorHandler("VSK10019").getUserMessage());
			}
			*/
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 등록된 LANE CODE, DIRECTION이 있는지 확인합니다.
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return int
	 * @exception EventException
	 */
	public int checkSvcLaneDir(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException{
		try {
			return dbDao.checkSvcLaneDir(mdmVslSvcLaneDirVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}

	/**
	 * Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException {
		try {
			return dbDao.searchPortList(locationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryList(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryList(cntCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 지역본부(RHQ) 정보를 조회합니다.
	 * 
	 * @return List<OfficeVO>
	 * @exception EventException
	 */
	public List<OfficeVO> searchRhqList() throws EventException {
		try {
			return dbDao.searchRhqList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * RHQ산하에 있는 Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchControlOfficeList(String rhqCd) throws EventException {
		try {
			return dbDao.searchControlOfficeList(rhqCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * RHQ산하에 있는 Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchSlsOfficeList(String rhqCd) throws EventException {
		try {
			return dbDao.searchSlsOfficeList(rhqCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Estimate VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws EventException {
		try {
			return dbDao.searchEstVvdList(vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 정시성 VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchRsltVvdList(String vslCd) throws EventException {
		try {
			return dbDao.searchRsltVvdList(vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Carrier 정보를 조회합니다.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierList(CarrierVO carrierVO) throws EventException {
		try { 
			return dbDao.searchCarrierList(carrierVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Carrier 정보를 검증합니다.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> checkCarrier(CarrierVO carrierVO) throws EventException {
		try { 
			return dbDao.checkCarrier(carrierVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Vessel 리스트 정보를 조회합니다.
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVslList(VesselVO vesselVO) throws EventException {
		try {
			return dbDao.searchVslList(vesselVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeVO
	 * @return List<PfLaneTypeVO>
	 * @exception EventException
	 */
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws EventException {
		try {
			return dbDao.searchPfLaneTypeList(pfLaneTypeVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Port에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByPort(YardVO yardVO) throws EventException {
		try {
			return dbDao.searchYardListByPort(yardVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 국가에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByCountry(YardVO yardVO) throws EventException {
		try {
			return dbDao.searchYardListByCountry(yardVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Location 정보를 조회합니다.
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchLocationList(LocationVO locationVO) throws EventException {
		try {
			return dbDao.searchLocationList(locationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 입력한 Service Provider에 대한 정보를 조회합니다.
	 * 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchVendorList(VendorVO vendorVO) throws EventException {
		try {
			return dbDao.searchVendorList(vendorVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Phase In/Out 사유 정보를 조회합니다.
	 * 
	 * @return List<PhaseInOutReasonVO>
	 * @exception EventException
	 */
	public List<PhaseInOutReasonVO> searchPhsInOutRsnList() throws EventException {
		try {
			return dbDao.searchPhsInOutRsnList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * VVD를 검증합니다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception EventException
	 */
	public List<VvdVO> checkVvd(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkVvd(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code 가 존재하는지 여부를 조회합니다.
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String locCd) throws EventException {
		try {
			return dbDao.checkPort(locCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Simulation No 정보를 조회합니다.
	 * 
	 * @param RqstSimNoVO rqstSimNoVO
	 * @return List<RqstSimNoVO>
	 * @exception EventException
	 */
	public List<RqstSimNoVO> searchSimNoList(RqstSimNoVO rqstSimNoVO) throws EventException {
		try {
			
			List<RqstSimNoVO>  returnVO = null;
//			String vslSlanCd = rqstSimNoVO.getVslSlanCd();
			String uiFlg = rqstSimNoVO.getUiflg();
			
			//COA SIMULATION INFORMATION Table를 조회한다
			if("A".equals(uiFlg)){
				returnVO = dbDao.searchSimNoListByPfSkd(rqstSimNoVO);
			//VSK_SWAP_CST_SIM 테이블에서 입력 받은 Service Lane Code에 해당하는 Coastal Schedule Simulation 정보를 조회한다.	
			}else if("B".equals(uiFlg)){
				returnVO = dbDao.searchSimNoListByCstSkd(rqstSimNoVO);
			//VSK_SWAP_CST_SIM 테이블에서 입력 받은 Service Lane Code에 해당하는 Coastal Schedule Simulation 정보를 조회한다.
			}else{
				returnVO = dbDao.searchSimNoListByLrskd(rqstSimNoVO);
			}
			
			return returnVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 코드 타입, 코드명에 따른 코드 정보 리스트를 조회합니다.
	 * 
	 * @param  CodeInfoVO codeInfoVO
	 * @return List<CodeInfoVO>
	 * @exception EventException
	 */
	public List<CodeInfoVO> searchCodeInfoList(CodeInfoVO codeInfoVO) throws EventException {
		try {
			return dbDao.searchCodeInfoList(codeInfoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane Direction 정보를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return List<MdmVslSvcLaneDirVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneDirVO> searchSvcLaneDirList(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException {
		try {
			return dbDao.searchSvcLaneDirList(mdmVslSvcLaneDirVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Yard Code가 입력되였을 경우로써 Yard Code, Description를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardList(YardVO yardVO) throws EventException {
		try {
			return dbDao.searchYardList(yardVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}

	/**
	 * VOSI의 공통코드를 검색한다.
	 * 
	 * @param  String comCode
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchCombo(String comCode) throws EventException {
		try {
			return dbDao.searchCombo(comCode);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
		
	/**
	 * MDM Lane 정보를 조회합니다.
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
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * MDM Lane 정보를 검증합니다.
     * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchLane(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Delay Reason 을 조회합니다.
	 * 
	 * @return List<DelayReasonVO>
	 * @exception EventException
	 */
	public List<DelayReasonVO> searchDlayRsnList() throws EventException {
		try {
			return dbDao.searchDlayRsnList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Vsl Class를 조회한다.
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVslClsList() throws EventException {
		try {
			return dbDao.searchVslClsList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Vsl Class와 VSL_DZND_CAPA를 조회한다.
	 * 
	 * @return CodeInfoGRPVO
	 * @exception EventException
	 */
	public CodeInfoGRPVO searchVslClsDznCapaList() throws EventException {
		try {
			CodeInfoGRPVO grpVO = new CodeInfoGRPVO();
			
			List<MdmVslCntrVO> vslClsList =  dbDao.searchVslClsList();
			List<MdmVslCntrVO> vslDznList =  dbDao.searchVslDznCapaList();
			
			
			grpVO.setVslClsCapaVOs(vslClsList);
			grpVO.setVslDzndCapaVOs(vslDznList);
			return grpVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane Direction 리스트를 조회합니다.
	 * 
	 * @param LaneDirVO laneDirVO
	 * @return List<LaneDirVO>
	 * @exception EventException
	 */
	public List<LaneDirVO> searchLaneDirList(LaneDirVO laneDirVO) throws EventException {
		try {
			laneDirVO.setFmDt(laneDirVO.getFmDt().replaceAll("-", ""));
			laneDirVO.setToDt(laneDirVO.getToDt().replaceAll("-", ""));
			return dbDao.searchLaneDirList(laneDirVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	/**
	 * VVD가 지나는 Port 리스트를 조회합니다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPort(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.searchPort(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	/**
	 * Lane Code Inquiry 화면의 기본정보인 Trade, Sub Trade, Service Type 정보를 조회한다.
	 * 
	 * @return List<String[]>
	 * @exception EventException
	 */
	public List<String[]> searchLaneBasic() throws EventException {
		try {
			
			String[] arrTrd =  dbDao.searchTradeList();
			String[] arrSubTrd =  dbDao.searchSubTradeList();
			
			List<String[]> list = new ArrayList<String[]>();
			list.add(arrTrd);
			list.add(arrSubTrd);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code Inquiry 화면의 기본정보인 Conti Cd, Sconti Cd 정보를 조회한다.
	 * 
	 * @return List<String[]>
	 * @exception EventException
	 */
	public List<String[]> searchPortBasic() throws EventException {
		try {
			
			String[] arrConti =  dbDao.searchContiList();
			String[] arrSconti =  dbDao.searchScontiList("");
			
			List<String[]> list = new ArrayList<String[]>();
			list.add(arrConti);
			list.add(arrSconti);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Port Code Inquiry 에서의 Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchPortInfoList(LocationVO locationVO) throws EventException {
		try {
			return dbDao.searchPortInfoList(locationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Conti Cd에 해당하는 Sconti Cd 정보를 조회한다.
	 * 
	 * @param String contiCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchScontiList(String contiCd) throws EventException {
		try {
			return dbDao.searchScontiList(contiCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Vessel 리스트 정보를 조회합니다.(0044 vessel code inquiry)
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVesselListByCode(VesselVO vesselVO) throws EventException {
		try {
			return dbDao.searchVesselListByCode(vesselVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 날짜 정보를 조회합니다.
	 * 
	 * @param SearchDateVO dateVO
	 * @return List<SearchDateVO>
	 * @exception EventException
	 */
	public List<SearchDateVO> searchDate(SearchDateVO dateVO) throws EventException {
		try {
			return dbDao.searchDate(dateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}

	/**
	 * RHQ산하에 있는 Yard Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchYardCtrlOfficeList(String rhqCd) throws EventException {
		try {
			return dbDao.searchYardCtrlOfficeList(rhqCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 특정 Location Local Time을 변경대상 Location Local time으로 변환된 값을 추출한다.
	 * @param String sFmLocCd
	 * @param String sToLocCd
	 * @param String sDateFormat
	 * @return String
	 * @exception EventException
	 */
    public String getTimeConvFmLocToLoc(String sFmLocCd, String sToLocCd, String sDateFormat) throws EventException {
    	String sRtnValue	= null;
    	
    	/************************** 
    	 * DATE FORMAT
    	 * ------------------------
    	 * YYYYMMDD
    	 * YYYYMMDD HH24
    	 * YYYYMMDD HH24:MI
    	 * YYYYMMDD HH24:MI:SS
    	 * YYYYMMDDHH24MISS
    	 * YYYYMMDDHH24MI
    	 * YYYYMMDDHH24
    	 **************************/
    	try{
    		
	        if (sFmLocCd == null || sToLocCd == null || sDateFormat == null) {
	        	sRtnValue	= null;
	        } else if	(	!"YYYYMMDD".equals(sDateFormat) && !"YYYYMMDD HH24".equals(sDateFormat) && !"YYYYMMDD HH24:MI".equals(sDateFormat) && !"YYYYMMDD HH24:MI:SS".equals(sDateFormat)
	        			&& 	!"YYYYMMDDHH24MISS".equals(sDateFormat) && 	!"YYYYMMDDHH24MI".equals(sDateFormat) && 	!"YYYYMMDDHH24".equals(sDateFormat)
	        			){
	        	sRtnValue	= null;
	        } else if(sFmLocCd.length() == 5 && sToLocCd.length() == 5) {
	        	sRtnValue	= dbDao.getTimeConvFmLocToLoc(sFmLocCd, sToLocCd, sDateFormat);
	        }
	        
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
		return sRtnValue;
    }
	
    
	/**
	 * 특정 Vessel Service Lane의 Proforma 데이터중 direction+port 조합으로 데이터 추출한다.
	 * 
	 * @param String sVslSlanCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchSkdDirPortCdforProformaList(String sVslSlanCd) throws EventException {
		try {
			return dbDao.searchSkdDirPortCdforProformaList(sVslSlanCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
}