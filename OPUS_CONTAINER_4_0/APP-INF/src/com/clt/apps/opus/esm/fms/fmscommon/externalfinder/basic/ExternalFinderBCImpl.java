/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalFinderBCImpl.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration.ExternalFinderDBDAO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.OtherCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-FMSCommon Business Logic Basic Command implementation<br>
 * - Handling business logic of OPUS-FMSCommon<br>
 *
 * @author 
 * @see Esm_Fms-0022EventResponse,ExternalfinderBC refer to each DAO class
 * @since J2EE 1.5
 */

public class ExternalFinderBCImpl extends BasicCommandSupport implements ExternalFinderBC {

	// Database Access Object
	private transient ExternalFinderDBDAO dbDao = null;

	/**
	 * Generating ExternalFinderBCImpl Object<br>
	 * Generating ExternalFinderDBDAO<br>
	 */
	public ExternalFinderBCImpl() {
		dbDao = new ExternalFinderDBDAO();
	}
	
	/**
	 *  Handling retrieving event of Externalfinder <br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeList(SearchVesselVO searchVesselVO) throws EventException {
		try {
			return dbDao.searchVesselCodeList(searchVesselVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01329",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01329",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Owner Code of Owner Ship/Charter In/Hire Out<br>
	 * Getting Vessel Name information on Vessel Code at FMS UI<br>
	 * 
	 * @param vslCd String
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeName(String vslCd) throws EventException {
		
		try {
			return dbDao.searchVesselCodeName(vslCd);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01554",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01554",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Location Name information on Location Code<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchLocCdName(String locCd) throws EventException {
		
		try {
			return dbDao.searchLocCdName(locCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Name information relevant to Flag Code<br>
	 * 
	 * @param vslCntCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchFlag(String vslCntCd) throws EventException {
		
		try {
			return dbDao.searchFlag(vslCntCd);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Account Code<br>
	 * Generate Account Code Popup at FMS UI<br>
	 * 
	 * @param acctCd String
	 * @param acctGb String
	 * @return List<SearchMdmAccountCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMdmAccountCodeListVO> searchMdmAccountCodeList(String acctCd,String acctGb) throws EventException {
		
		try {
			return dbDao.searchMdmAccountCodeList(acctCd,acctGb);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01318",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01318",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Handling retrieving event in case inputting Location Code at D/Dock Schedule Input <br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException {
		try {
			return dbDao.searchCheckLocCode(locCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01019",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01019",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event in case inputting Lane Code at D/Dock Schedule Review-Graph<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLaneCode(String laneCd) throws EventException {
		try {
			return dbDao.searchCheckLaneCode(laneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01562",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01562",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling retrieving event in case inputting VVD <br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkMdmVvdCode(String vvdCd) throws EventException {
		try {
			return dbDao.searchCheckMdmVvdCode(vvdCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Carrier Code Selection - Window at FMS UI <br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCarrierCodeListVO> searchCarrierCodeList(String carrNm) throws EventException {
		
		try {
			return dbDao.searchCarrierCodeList(carrNm);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01014",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01014",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Lane Code Search - Window at FMS UI<br>
	 * 
	 * @param searchLaneCodeListVO SearchLaneCodeListVO
	 * @return List<SearchLaneCodeList>
	 * @exception EventException
	 */
	public List<SearchLaneCodeListVO> searchLaneCodeList(SearchLaneCodeListVO searchLaneCodeListVO) throws EventException {
		
		try {
			return dbDao.searchLaneCodeList(searchLaneCodeListVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01555",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01555",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Handling event in case inputting Revenue Lane Code<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkRevenueLaneCode(String laneCd) throws EventException {
		try {
			return dbDao.searchCheckRevenueLaneCode(laneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01563",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01563",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Carrier Code<br>
	 * 
	 * @param crrCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckCarrierCode(String crrCd) throws EventException {
		
		try {
			return dbDao.searchCheckCarrierCode(crrCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01564",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01564",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Effective Date<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @param csrType String
	 * @return SearchDefaultDateVO
	 * @exception EventException
	 */
	public SearchDefaultDateVO checkEffectiveDate(String slpOfcCd, String effDt, String csrType) throws EventException {
		
		try {
			return dbDao.searchCheckEffectiveDate(slpOfcCd, effDt, csrType);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Center Code / City Code<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @exception EventException
	 */
	public List<SearchCenterCodeVO> searchCenterCode(String slpOfcCd) throws EventException {
		try {
			return dbDao.searchCenterCode(slpOfcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01566",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01566",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Office Code / Officd Name <br>
	 * 
	 * @return List<searchPaymenetOfficeCodeList>
	 * @exception EventException
	 */
	public List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeList() throws EventException {
		try {
			return dbDao.searchPaymenetOfficeCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01408",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01408",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving Currency rate<br>
	 * 
	 * @param acctXchRtYrmon String
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(String acctXchRtYrmon) throws EventException {
		
		try {
			return dbDao.searchExchangeRate(acctXchRtYrmon.substring(0,6));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Level Check for each Account<br>
	 * Handling retrieving voyage level event on UI in case inputing VVD code<br>
	 * 
	 * @param acctCd String
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkAcctCdVvdLevel(String acctCd, String vvdCd) throws EventException {
		try {
			return dbDao.searchCheckAcctCdVvdLevel(acctCd, vvdCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01474",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01474",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Save Other Code (insert / modify / remove)<br>
	 * 
	 * @param otherCodeListVOs OtherCodeListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOtherCode(OtherCodeListVO[] otherCodeListVOs, String usrId) throws EventException {
		try {
			List<OtherCodeListVO> addVoList = new ArrayList<OtherCodeListVO>();
			List<OtherCodeListVO> modifyVoList = new ArrayList<OtherCodeListVO>();
			List<OtherCodeListVO> removeVoList = new ArrayList<OtherCodeListVO>();
			
			for ( int i=0; i<otherCodeListVOs.length; i++ ) {
				if ( otherCodeListVOs[i].getIbflag().equals("I")){
					otherCodeListVOs[i].setCreUsrId(usrId);
					addVoList.add(otherCodeListVOs[i]);
				} else if ( otherCodeListVOs[i].getIbflag().equals("U")){
					otherCodeListVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(otherCodeListVOs[i]);
				} else if ( otherCodeListVOs[i].getIbflag().equals("D")){
					otherCodeListVOs[i].setUpdUsrId(usrId);
					removeVoList.add(otherCodeListVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addOtherCode(addVoList);
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyOtherCode(modifyVoList);
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.removeOtherCode(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Other Code List <br>
	 * 
	 * @param  String codeTp
	 * @return List<OtherCodeListVO>
	 * @exception EventException
	 */
	public List<OtherCodeListVO> searchOtherCodeList(String codeTp) throws EventException {
		try {
			return dbDao.searchOtherCodeList(codeTp);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * Default Eff Date <br>
	 * 
	 * @param vo SearchDefaultDateVO
	 * @return List<SearchDefaultDateVO>
	 * @exception EventException
	 */
	public List<SearchDefaultDateVO> searchDefaultDateInfo(SearchDefaultDateVO vo) throws EventException {
		try {
			return dbDao.searchDefaultDateInfo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * Contract No Search <br>
	 * 
	 * @param vo
	 * @return List<SearchContractNoVO>
	 * @throws EventException
	 */
	public List<SearchContractNoVO> searchContractNoInfo(SearchContractNoVO vo) throws EventException {
		try {
			return dbDao.searchContractNoInfo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * FMS Contract Info Search <br>
	 * 
	 * @param vo
	 * @return List<SearchContractInfoVO>
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchContractInfo(SearchContractInfoVO vo) throws EventException {
		try {
			return dbDao.searchContractInfo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Search FMS Vendor By Contract no.<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchVendorByContractNo(SearchContractInfoVO vo) throws EventException {
		try {
			return dbDao.searchVendorByContractNo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Custmer By Vendor.<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchCustomerListByVendor(SearchContractInfoVO vo) throws EventException {
		try {
			return dbDao.searchCustomerListByVendor(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Tax Type<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<FmsCodeInfoVO> searchTaxTypeList(FmsCodeParamVO vo) throws EventException {
		try {
			return dbDao.searchTaxTypeList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TI/TO 공통에 땨란 VVD 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFmsVvdByFletCtrtNo(FmsCommonVO fmsCommonVO) throws EventException {
		
		try {
			return dbDao.searchFmsVvdByFletCtrtNo(fmsCommonVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * AR_FIN_DIR_CONV 에 존재 여부.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchArFincDirConvUsedFlag(FmsCommonVO fmsCommonVO) throws EventException {
		
		try {
			return dbDao.searchArFincDirConvUsedFlag(fmsCommonVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceLaneDirection(FmsCommonVO fmsCommonVO) throws EventException {
		
		try {
			return dbDao.searchServiceLaneDirection(fmsCommonVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Fin direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFinDirection(FmsCommonVO fmsCommonVO) throws EventException {
		
		try {
			return dbDao.searchFinDirection(fmsCommonVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}

}