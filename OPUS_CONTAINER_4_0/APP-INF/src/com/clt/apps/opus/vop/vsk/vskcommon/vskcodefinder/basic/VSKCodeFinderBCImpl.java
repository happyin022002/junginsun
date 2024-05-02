/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBCImpl.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DateTimeConvVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.EffectiveVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * VSKCommon Business Logic Basic Command implementation<br>
 * - Handling business logic of VSKCommon<br>
 *
 * @author 
 * @see UI_VSK-0202EventResponse,VSKCodeFinderBC, DAO
 * @since J2EE 1.4
 */

public class VSKCodeFinderBCImpl extends BasicCommandSupport implements VSKCodeFinderBC {

	// Database Access Object
	private transient VSKCodeFinderDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl object creation<br>
	 * Creating VSKCodeFinderDBDAO<br>
	 */
	public VSKCodeFinderBCImpl() {
		dbDao = new VSKCodeFinderDBDAO();
	}
	
	/**
	 * Retrieving Service Lane
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
	 * Checking Service Lane Code 
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkSvcLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			List<MdmVslSvcLaneVO> list = dbDao.checkSvcLane(mdmVslSvcLaneVO);
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
	 * Checking applied LANE CODE, DIRECTION are exist
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
	 * Retrieving Port
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
	 * Retrieving Country
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
	 * Retrieving RHQ
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
	 * Retrieving Control Office Code of RHQ
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
	 * Retrieving Estimate VVD
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
	 * Retrieving on time VVD
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
	 * Retrieving Carrier
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
	 * Checking Carrier
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
	 * Retrieving Vessel
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
	 * Retrieving Proforma Type
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
	 * Retrieving Yard of Port
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
	 * Retrieving Yard of Country
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
	 * Retrieving Location
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchLocation(LocationVO locationVO) throws EventException {
		try {
			return dbDao.searchLocation(locationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Location
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
	 * Retrieving information about inputed Service Provider
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
	 * Retrieving Phase In/Out Reason
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
	 * Checking VVD
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
	 * Retrieving Port Code is exist
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
	 * Retrieving Simulation No
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
			
			//Retrieving COA SIMULATION INFORMATION Table
			if("A".equals(uiFlg)){
				returnVO = dbDao.searchSimNoListByPfSkd(rqstSimNoVO);
			}else if("B".equals(uiFlg)){
				returnVO = dbDao.searchSimNoListByCstSkd(rqstSimNoVO);
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
	 * Retrieving Code Information List by Code Type or Code Name
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
	 * Retrieving Service Lane Direction
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
	 * Retrieving Yard Code, Description in case Yard Code input
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
	 * Retrieving Common Code of VOSI
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
	 * Retrieving MDM Lane
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
	 * Checking MDM Lane
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
	 * Retrieving Delay Reason
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
	 * Retrieving Vsl Class
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
	 * Retrieving Vsl Class and VSL_DZND_CAPA
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
	
	//::FOR.NYK.START::by TOP:2014-09-10:://
	/**
	 * VVD媛 吏?섎뒗 Port 由ъ뒪?몃? 議고쉶?⑸땲??
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
	//::FOR.NYK.FINISH::by TOP:2014-09-10:://
	
	/**
	 * ACTUAL SKD ?낅젰??GMT 湲곗??쇰줈 ?댁쟾?ы듃??ETD? ?낅젰?ы듃 ATA??쟾愿怨?泥댄겕<br>
	 * 
	 * @param DateTimeConvVO dateTimeConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchActPreDateEqual(DateTimeConvVO  dateTimeConvVO)
				throws EventException {
		try{
			return dbDao.searchActPreDateEqual(dateTimeConvVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}
	}
	
	/**
	 * vsl_cd 由ъ뒪?몃? 議고쉶?⑸땲??
	 * 
	 * @param VesselVO vslVo
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVslCd(VesselVO vslVo) throws EventException {
		try {
			return dbDao.searchVslCd(vslVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	//::FOR.NYK.START::by KJH:2014-11-24:://
	/**
	 * Send RevenueVVD I/F 
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void  sendRevenueVVD(List<VvdVO> vvdVOs) throws EventException{
		try {
			for(VvdVO vvdVO : vvdVOs){
				dbDao.sendRevenueVVD(vvdVO);
			}			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	//::FOR.NYK.FINISH::by KJH:2014-11-24:://

	
	/**
	 * Retrieving on time VVD
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchPortList(Map<String, String> mapVO) throws EventException {
		try {
			return dbDao.searchPortList(mapVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	

	/**
	 * Select proper VVD in candidate
	 * 
	 * @param EffectiveVvdVO effectiveVvdVO
	 * @param String sPurposeCode
	 * @return EffectiveVvdVO
	 * @exception EventException
	 */
	public EffectiveVvdVO searchProperVVDinCandidate(EffectiveVvdVO effectiveVvdVO, String sPurposeCode) throws EventException {
		
		EffectiveVvdVO			rtnVO		= new EffectiveVvdVO();
		List<EffectiveVvdVO>	tmpVslCdVOs	= null;
		
		int						iPurDigit	= 0;
		
		try {
			
			if("ACT_SKD".equals(sPurposeCode)){
				iPurDigit	= 1;
			}else if("DG_EDI".equals(sPurposeCode)){
				iPurDigit	= 2;
			}
			
			switch(iPurDigit){
			
				/****************** <<ACT SKD (IFTSAI)>> *********************/
				case	1:
				
				
					break;
				
				
				/****************** <<DG EDI (IFTMBF I/B)>> ******************/
				case	2:	
				
					tmpVslCdVOs		= dbDao.searchProperVVDinCandidate			(effectiveVvdVO);
					
					if(tmpVslCdVOs.size() == 1){							/** SUCCESS **/
						rtnVO.setVslSlanCd	(tmpVslCdVOs.get(0).getVslSlanCd());
						rtnVO.setVslCd		(tmpVslCdVOs.get(0).getVslCd	());	
						rtnVO.setSkdVoyNo	(tmpVslCdVOs.get(0).getSkdVoyNo	());	
						rtnVO.setSkdDirCd	(tmpVslCdVOs.get(0).getSkdDirCd	());	
						
						rtnVO.setEffectiveVvdChkRsltCd	("S");
						rtnVO.setEffectiveVvdChkRsltRmk	("Matched successfully");
					}else if(tmpVslCdVOs.size() == 0){
						rtnVO.setEffectiveVvdChkRsltCd	("F");
						rtnVO.setEffectiveVvdChkRsltRmk	("There is no VVD information in vessel schedule");
					}else if(tmpVslCdVOs.size() > 1){
						
						//===============================================================================//
						tmpVslCdVOs	= dbDao.searchProperVVDinPortCandidate		(effectiveVvdVO);
//						if(tmpVslCdVOs.size() == 1){
//							
//						}else 
							if(tmpVslCdVOs.size() > 1){
							
							//---------------------------------------------------------------------------//
							tmpVslCdVOs	= dbDao.searchProperVVDinPolPodCandidate(effectiveVvdVO);
//							if(tmpVslCdVOs.size() == 1){
								
//							}else if(tmpVslCdVOs.size() > 1){
//								
//								
//							}else{
//								
//							}
							//---------------------------------------------------------------------------//							
							
//						}else{
							
						}
						//===============================================================================//
						
						//rtnVO.setEffectiveVvdChkRsltCd	("F");
						//rtnVO.setEffectiveVvdChkRsltRmk	("There are VVD information more than one");
					}else{
						rtnVO.setEffectiveVvdChkRsltCd	("F");
						rtnVO.setEffectiveVvdChkRsltRmk	("There is unexpected result");
					}
					
					rtnVO.setMatchedVvdCount		(String.valueOf(tmpVslCdVOs.size()));
					
					break;
			}
					
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
		
		return	rtnVO;
	}
	
}