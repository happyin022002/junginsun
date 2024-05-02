/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : locationsBCImpl.java
*@FileTitle : contient
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.basic;
   
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBC;
import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBCImpl;
import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.integration.CcdCommonEAIDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration.LocationDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.EqOrgChartVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.RegionVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.SubContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * common code Business Logic Command Interface<br>
 * An interface to the business logic for common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class LocationBCImpl extends BasicCommandSupport implements LocationBC {

	// Database Access Object
	private transient LocationDBDAO dbDao = null;
	private transient CcdCommonEAIDAO eaiDao = null;
	
	/**
	 * locationsBCImpl object creation<br>
	 * Generate locationsDBDAO.<br>
	 */
	public LocationBCImpl() {
		dbDao = new LocationDBDAO();
		eaiDao = new CcdCommonEAIDAO();
	}
	
	/**
	 * Continent retrieve.<br>
	 * 
	 * @param String contiCd
	 * @return ContinentVO
	 * @exception EventException
	 */
	public ContinentVO searchContiCode(String contiCd) throws EventException {
		try {
			return dbDao.searchContiCode(contiCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Continent save.<br>
	 * 
	 * @param ContinentVO continentVO
	 * @exception EventException
	 */
	public void manageContiCode(ContinentVO continentVO) throws EventException {
		try {
			if(continentVO != null ){
				if("I".equals(continentVO.getIbflag())){
					dbDao.addContiCode(continentVO);
				}else if("U".equals(continentVO.getIbflag())){
					dbDao.modifyContiCode(continentVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Sub Continent retrieve.<br>
	 * 
	 * @param String scontiCd
	 * @return SubContinentVO
	 * @exception EventException
	 */
	public SubContinentVO searchSubContiCode(String scontiCd) throws EventException {
		try {
			return dbDao.searchSubContiCode(scontiCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Sub Continent save.<br>
	 * 
	 * @param SubContinentVO subContinentVO
	 * @exception EventException
	 */
	public void manageSubContiCode(SubContinentVO subContinentVO) throws EventException {
		try {
			if(subContinentVO != null ){
				if("I".equals(subContinentVO.getIbflag())){
					dbDao.addSubContiCode(subContinentVO);
				}else if("U".equals(subContinentVO.getIbflag())){
					dbDao.modifySubContiCode(subContinentVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Country retrieve.<br>
	 * 
	 * @param String cntCd
	 * @return CountryVO
	 * @exception EventException
	 */
	public CountryVO searchCountryCode(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryCode(cntCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Country save.<br>
	 * 
	 * @param CountryVO countryVO
	 * @exception EventException
	 */
	public void manageCountryCode(CountryVO countryVO) throws EventException {
		try {
			if(countryVO != null ){
				if("I".equals(countryVO.getIbflag())){
					dbDao.addCountryCode(countryVO);
				}else if("U".equals(countryVO.getIbflag())){
					dbDao.modifyCountryCode(countryVO);
				}

				//manageCountryIf(countryVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Region retrieve.<br>
	 * 
	 * @param String rgnCd
	 * @return RegionVO
	 * @exception EventException
	 */
	public RegionVO searchRegionCode(String rgnCd) throws EventException {
		try {
			return dbDao.searchRegionCode(rgnCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Region save.<br>
	 * 
	 * @param RegionVO rgnVO
	 * @exception EventException
	 */
	public void manageRegionCode(RegionVO rgnVO) throws EventException {
		try {
			if(rgnVO != null ){
				if("I".equals(rgnVO.getIbflag())){
					dbDao.addRegionCode(rgnVO);
				}else if("U".equals(rgnVO.getIbflag())){
					dbDao.modifyRegionCode(rgnVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * State retrieve.<br>
	 * 
	 * @param String steCd
	 * @param String cntCd
	 * @return StateVO
	 * @exception EventException
	 */
	public StateVO searchStateCode(String steCd, String cntCd) throws EventException {
		try {
			return dbDao.searchStateCode(steCd, cntCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * State save.<br>
	 * 
	 * @param StateVO steVO
	 * @exception EventException
	 */
	public void manageStateCode(StateVO steVO) throws EventException {
		try {
			if(steVO != null ){
				if("I".equals(steVO.getIbflag())){
					dbDao.addStateCode(steVO);
				}else if("U".equals(steVO.getIbflag())){
					dbDao.modifyStateCode(steVO);
				}

				//manageStateIf(steVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Location retrieve.<br>
	 * 
	 * @param String locCd
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchLocCode(String locCd) throws EventException {
		try {
			return dbDao.searchLocCode(locCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Location retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchLocCodeRqst(String rqstNo) throws EventException {
		try {
			return dbDao.searchLocCodeRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Location save.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception EventException
	 */
	public void manageLocCode(LocationVO locVO) throws EventException {
		try {
			if(locVO != null ){
				if(locVO.getCallPortFlg()==""){
					locVO.setCallPortFlg("N");
				}
				if("I".equals(locVO.getIbflag())){
					dbDao.addLocCode(locVO);
				}else if("U".equals(locVO.getIbflag())){
					dbDao.modifyLocCode(locVO);
				}
				sendLocToEai(locVO.getLocCd(), locVO.getUsrId(), locVO.getIbflag());
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Location save.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception EventException
	 */
	public void manageLocCodeRqst(LocationVO locVO) throws EventException {
		try {
			if(locVO != null ){
				if(locVO.getCallPortFlg()==""){
					locVO.setCallPortFlg("N");
				}
				if("I".equals(locVO.getIbflag())){
					dbDao.addLocCodeRqst(locVO);
				}else if("U".equals(locVO.getIbflag())){
					dbDao.modifyLocCodeRqst(locVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Yard retrieve.<br>
	 * 
	 * @param String ydCd
	 * @return YardVO
	 * @exception EventException
	 */
	public YardVO searchYardCode(String ydCd) throws EventException {
		try {
			return dbDao.searchYardCode(ydCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Yard retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return YardVO
	 * @exception EventException
	 */
	public YardVO searchYardRqst(String rqstNo) throws EventException {
		try {
			return dbDao.searchYardRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Yard save.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception EventException
	 */
	public void manageYardCode(YardVO ydVO) throws EventException {
		try {
			if(ydVO != null ){
				ydVO.setGateOpnHrmnt(ydVO.getGateOpnHrmnt().replace(":", ""));
				ydVO.setGateClzHrmnt(ydVO.getGateClzHrmnt().replace(":", ""));
				ydVO.setSatGateOpnHrmnt(ydVO.getSatGateOpnHrmnt().replace(":", ""));
				ydVO.setSatGateClzHrmnt(ydVO.getSatGateClzHrmnt().replace(":", ""));
				ydVO.setSunGateOpnHrmnt(ydVO.getSunGateOpnHrmnt().replace(":", ""));
				ydVO.setSunGateClzHrmnt(ydVO.getSunGateClzHrmnt().replace(":", ""));
				ydVO.setHolGateOpnHrmnt(ydVO.getHolGateOpnHrmnt().replace(":", ""));
				ydVO.setHolGateClzHrmnt(ydVO.getHolGateClzHrmnt().replace(":", ""));
				if("I".equals(ydVO.getIbflag())){
					dbDao.addYardCode(ydVO);
					dbDao.addYardToPrdNode(ydVO);
				}else if("U".equals(ydVO.getIbflag())){
					dbDao.modifyYardCode(ydVO);
					dbDao.modifyYardToPrdNode(ydVO);
				}
				sendYardToEai(ydVO.getYdCd(), ydVO.getUsrId(), ydVO.getIbflag());
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Yard save.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception EventException
	 */
	public void manageYardRqst(YardVO ydVO) throws EventException {
		try {
			if(ydVO != null ){
				ydVO.setGateOpnHrmnt(ydVO.getGateOpnHrmnt().replace(":", ""));
				ydVO.setGateClzHrmnt(ydVO.getGateClzHrmnt().replace(":", ""));
				ydVO.setSatGateOpnHrmnt(ydVO.getSatGateOpnHrmnt().replace(":", ""));
				ydVO.setSatGateClzHrmnt(ydVO.getSatGateClzHrmnt().replace(":", ""));
				ydVO.setSunGateOpnHrmnt(ydVO.getSunGateOpnHrmnt().replace(":", ""));
				ydVO.setSunGateClzHrmnt(ydVO.getSunGateClzHrmnt().replace(":", ""));
				ydVO.setHolGateOpnHrmnt(ydVO.getHolGateOpnHrmnt().replace(":", ""));
				ydVO.setHolGateClzHrmnt(ydVO.getHolGateClzHrmnt().replace(":", ""));
				if("I".equals(ydVO.getIbflag())){
					dbDao.addYardRqst(ydVO);
				}else if("U".equals(ydVO.getIbflag())){
					dbDao.modifyYardRqst(ydVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Equipment ORG Chart retrieve.<br>
	 * 
	 * @param String locType
	 * @param String location
	 * @param String deltFlg
	 * @return List<EqOrgChartVO>
	 * @exception EventException
	 */
	public List<EqOrgChartVO> searchEqOrgChtList(String locType, String location, String deltFlg) throws EventException {
		try {
			return dbDao.searchEqOrgChtList(locType, location, deltFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EQ ORZ CHT Del Validation
	 * @param String sccCd
	 * @return String
	 * @exception EventException
	 */
	public String checkDelValidation(String sccCd) throws EventException {
		DBRowSet rowSet = null;
		String result = "";
		
		try {
			//1. MDM_EQ_ORZ_CHT Check
			rowSet = dbDao.checkSccCdMdmEqOrzCht(sccCd);
			if(rowSet != null) {
				while(rowSet.next()){
					result = "CCD00016";
					return result;
				}
			}
			//2. MDM_LOCATION Check
			rowSet = dbDao.checkSccCdMdmLocation(sccCd);
			if(rowSet != null) {
				while(rowSet.next()){
					result = "CCD00017";
					return result;
				}
			}

			//3. MDM_YARD Check
/*			rowSet = dbDao.checkSccCdMdmYard(sccCd);
			if(rowSet != null) {
				while(rowSet.next()){
					result = "CCD00018";
					return result;
				}
			}*/
			
			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * LOCATION & EQ SCC Validation<br>
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocSccValidation(String locCd) throws EventException {
		DBRowSet rowSet = null;
		String result = "";
		
		try {
			// check location & location's eq scc exists
			rowSet = dbDao.checkLocSccValidation(locCd);
			if(rowSet != null) {
				while(rowSet.next()){
					if(rowSet.getString(1) == null || rowSet.getString(1).length() < 1) {
						result = "CCD00042"; // eq scc of location not exists
						return result;
					}
				}
			} else {
				result = "CCD00013"; // location not exists
			}
			
			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Equipment ORG Chart save.<br>
	 * 
	 * @param EqOrgChartVO[] eqOrgChartVOs
	 * @param SignOnUserAccount account
	 * @return List<EqOrgChartVO>
	 * @exception EventException
	 */
	public List<EqOrgChartVO> manageEqOrgCht(EqOrgChartVO[] eqOrgChartVOs, SignOnUserAccount account) throws EventException {
		List<EqOrgChartVO> list = null;
		String rtnVal = "";
		int updCnt = 0;
		int dupCnt = 0;
		try {
			if(eqOrgChartVOs != null ){
				for(int i = 0 ; i < eqOrgChartVOs.length ; i++) {
					if("I".equals(eqOrgChartVOs[i].getIbflag())){
						
						// Key Validation
						String rtnSccCd = dbDao.checkEqOrgChtKey(eqOrgChartVOs[i].getSccCd());
						if(!"".equals(rtnSccCd)) {
							eqOrgChartVOs[i].setSccCd("");
							eqOrgChartVOs[i].setUpdDt("SCC is duplicated");
							eqOrgChartVOs[i].setEtcFlg("F");
							dupCnt++;
						}else {
							// Loc Validation
							// 1. Comparison of RCC based on LCC
							rtnVal = dbDao.checkLocValidation("RL", eqOrgChartVOs[i]);
							if(!"".equals(rtnVal)) {
								eqOrgChartVOs[i].setUpdDt("RCC is duplicated for LCC");
								eqOrgChartVOs[i].setEtcFlg("F");
							}else {
								// 2. Comparison of LCC based on ECC
								rtnVal = dbDao.checkLocValidation("LE", eqOrgChartVOs[i]);
								if(!"".equals(rtnVal)) {
									eqOrgChartVOs[i].setUpdDt("LCC is duplicated for ECC");
									eqOrgChartVOs[i].setEtcFlg("F");
								}else {
									// 3. Comparison of RCC based on ECC
									rtnVal = dbDao.checkLocValidation("RE", eqOrgChartVOs[i]);
									if(!"".equals(rtnVal)) {
										eqOrgChartVOs[i].setUpdDt("RCC is duplicated for ECC");
										eqOrgChartVOs[i].setEtcFlg("F");
									}else {
										eqOrgChartVOs[i].setUsrId(account.getUsr_id());
										eqOrgChartVOs[i].setUpdUsrId(account.getUsr_id());
										dbDao.addEqOrgCht(eqOrgChartVOs[i]);
										List<EqOrgChartVO> vo = dbDao.searchEqOrgChtList("S", eqOrgChartVOs[i].getSccCd(), "");
										if(vo != null && vo.size() > 0) {
											eqOrgChartVOs[i].setUpdDt(vo.get(0).getUpdDt());
											eqOrgChartVOs[i].setUpdUsrId(vo.get(0).getUpdUsrId());
											eqOrgChartVOs[i].setDeltFlg(vo.get(0).getDeltFlg());
										}
										eqOrgChartVOs[i].setIbflag("R");
										updCnt++;
									}
								}
							}
						}
					}else if("U".equals(eqOrgChartVOs[i].getIbflag())){
						// Loc Validation
						// 1. Comparison of RCC based on LCC
						rtnVal = dbDao.checkLocValidation("RL", eqOrgChartVOs[i]);
						if(!"".equals(rtnVal)) {
							eqOrgChartVOs[i].setUpdDt("RCC is duplicated for LCC");
							eqOrgChartVOs[i].setEtcFlg("F");
						}else {
							// 2. Comparison of LCC based on ECC
							rtnVal = dbDao.checkLocValidation("LE", eqOrgChartVOs[i]);
							if(!"".equals(rtnVal)) {
								eqOrgChartVOs[i].setUpdDt("LCC is duplicated for ECC");
								eqOrgChartVOs[i].setEtcFlg("F");
							}else {
								// 3. Comparison of RCC based on ECC
								rtnVal = dbDao.checkLocValidation("RE", eqOrgChartVOs[i]);
								if(!"".equals(rtnVal)) {
									eqOrgChartVOs[i].setUpdDt("RCC is duplicated for ECC");
									eqOrgChartVOs[i].setEtcFlg("F");
								}else {
									eqOrgChartVOs[i].setUsrId(account.getUsr_id());
									eqOrgChartVOs[i].setUpdUsrId(account.getUsr_id());
									dbDao.modifyEqOrgCht(eqOrgChartVOs[i]);
									List<EqOrgChartVO> vo = dbDao.searchEqOrgChtList("S", eqOrgChartVOs[i].getSccCd(), "");
									if(vo != null && vo.size() > 0) {
										eqOrgChartVOs[i].setUpdDt(vo.get(0).getUpdDt());
										eqOrgChartVOs[i].setUpdUsrId(vo.get(0).getUpdUsrId());
										eqOrgChartVOs[i].setDeltFlg(vo.get(0).getDeltFlg());
									}
									eqOrgChartVOs[i].setIbflag("R");
									updCnt++;
								}
							}
						}
					}
					if(i == eqOrgChartVOs.length-1) {
						String result = "";
						if(updCnt > 0) {
							if(dupCnt > 0) {
								result = "P";//Partial Success
							}else {
								result = "S";//Success
							}
						}else {
							if(dupCnt > 0) {
								result = "F";//Fail
							}
						}
						eqOrgChartVOs[0].setEtcStr(result);
					}
				}
				list = Arrays.asList(eqOrgChartVOs);
			}
			
			//dbDao.addEqrCreLocLvlPrc(account.getUsr_id());
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Leasing Company Yard retrieve.<br>
	 * 
	 * @param String lseCoYdCd
	 * @return LseComYardVO
	 * @exception EventException
	 */
	public LseComYardVO searchLseCoYd(String lseCoYdCd) throws EventException {
		try {
			return dbDao.searchLseCoYd(lseCoYdCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Leasing Company Yard save.<br>
	 * 
	 * @param LseComYardVO lseCoYdVO
	 * @exception EventException
	 */
	public void manageLseCoYd(LseComYardVO lseCoYdVO, SignOnUserAccount account) throws EventException {
		CcdCommonBC ccdCommonBC = new CcdCommonBCImpl();
		try {
			lseCoYdVO.setOnfHirYdFlg("Y");
			if(lseCoYdVO != null ){
				if("I".equals(lseCoYdVO.getIbflag())){
					dbDao.addLseCoYd(lseCoYdVO);
					ccdCommonBC.sendLseCoYdToMdm(lseCoYdVO.getLseCoYdCd(), account.getUsr_id(), "C");
				}else if("U".equals(lseCoYdVO.getIbflag())){
					dbDao.modifyLseCoYd(lseCoYdVO);
					ccdCommonBC.sendLseCoYdToMdm(lseCoYdVO.getLseCoYdCd(), account.getUsr_id(), "U");
				}

			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * DayLight Saving Time retrieve.<br>
	 * 
	 * @param String dstId
	 * @return DaySavingTimeVO
	 * @exception EventException
	 */
	public DaySavingTimeVO searchDyLgtSavTm(String dstId) throws EventException {
		try {
			return dbDao.searchDyLgtSavTm(dstId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * DayLight Saving Time save.<br>
	 * 
	 * @param DaySavingTimeVO dystVO
	 * @exception EventException
	 */
	public void manageDyLgtSavTm(DaySavingTimeVO dystVO, SignOnUserAccount account) throws EventException {
		CcdCommonBC ccdCommonBC = new CcdCommonBCImpl();
		try {
			if(dystVO != null ){
				dystVO.setStDstDt(dystVO.getStDstDt().replace("-", ""));
				dystVO.setEndDstDt(dystVO.getEndDstDt().replace("-", ""));
				dystVO.setStDstHrmnt(dystVO.getStDstHrmnt().replace(":", ""));
				dystVO.setEndDstHrmnt(dystVO.getEndDstHrmnt().replace(":", ""));
				
				if("I".equals(dystVO.getIbflag())){
					dbDao.addDyLgtSavTm(dystVO);
					ccdCommonBC.sendDyLgtSavTmToMdm(dystVO.getDstId(), account.getUsr_id(), "C");
				}else if("U".equals(dystVO.getIbflag())){
					dbDao.modifyDyLgtSavTm(dystVO);
					ccdCommonBC.sendDyLgtSavTmToMdm(dystVO.getDstId(), account.getUsr_id(), "U");
				}
				
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Zone retrieve.<br>
	 * 
	 * @param String znCd
	 * @return ZoneGroupVO
	 * @exception EventException
	 */
	public ZoneGroupVO searchZoneCode(String znCd) throws EventException {
		try {
			ZoneGroupVO zoneGroupVO = new ZoneGroupVO();
			ZoneVO zoneVO = new ZoneVO();
			String znSeq = "";
			String lseYdNm = "";
			List<ZoneDtlVO> zoneDtlVOs = new ArrayList<ZoneDtlVO>();
			
			zoneVO = dbDao.searchZoneCode(znCd);
			zoneDtlVOs = dbDao.searchZoneDtlCode(znCd, znSeq);
			zoneGroupVO.setNodCd(dbDao.searchPrdNod(znCd));
			if(dbDao.searchLseCoYd(znCd) != null) {
				lseYdNm = "1";
			}
			zoneGroupVO.setLseYdNm(lseYdNm);
			zoneGroupVO.setZoneVO(zoneVO);
			zoneGroupVO.setZoneDtlVOS(zoneDtlVOs);
			
			return zoneGroupVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Zone retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return ZoneGroupVO
	 * @exception EventException
	 */
	public ZoneGroupVO searchZoneRqst(String rqstNo) throws EventException {
		try {
			ZoneGroupVO zoneGroupVO = new ZoneGroupVO();
			ZoneVO zoneVO = new ZoneVO();
			List<ZoneDtlVO> zoneDtlVOs = new ArrayList<ZoneDtlVO>();
			
			zoneVO = dbDao.searchZoneRqst(rqstNo);
			zoneDtlVOs = dbDao.searchZoneDtlRqst(rqstNo);
			
			zoneGroupVO.setZoneVO(zoneVO);
			zoneGroupVO.setZoneDtlVOS(zoneDtlVOs);
			
			return zoneGroupVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @exception EventException
	 */
	public void manageZoneCode(ZoneGroupVO zoneGroupVO) throws EventException{
		try {
			ZoneVO zoneVO = zoneGroupVO.getZoneVO();
			ZoneDtlVO[] zoneDtlVOs = zoneGroupVO.getZoneDtlVOs();
//			zoneVO.setTztmHrs(zoneVO.getTztmHrs().replace(",", ""));
			
			List<ZoneDtlVO> createDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> updateDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> deleteDtlVoList = new ArrayList<ZoneDtlVO>();
			zoneVO.setUsrId(zoneGroupVO.getUsrId());
			
			if ("U".equals(zoneVO.getIbflag())){
				dbDao.modifyZoneCode(zoneVO);
				dbDao.modifyZoneToPrdNode(zoneVO);
			}else if ("I".equals(zoneVO.getIbflag())){
				dbDao.addZoneCode(zoneVO);
				dbDao.addZoneToPrdNode(zoneVO);
			}

			if(zoneDtlVOs != null){
				for ( int i=0; i<zoneDtlVOs.length; i++ ) {
					zoneDtlVOs[i].setUsrId(zoneGroupVO.getUsrId());
					if ("U".equals(zoneDtlVOs[i].getIbflag())){
						updateDtlVoList.add(zoneDtlVOs[i]);
					}else if ("I".equals(zoneDtlVOs[i].getIbflag())){
						createDtlVoList.add(zoneDtlVOs[i]);
					}else if ("D".equals(zoneDtlVOs[i].getIbflag())){
						deleteDtlVoList.add(zoneDtlVOs[i]);
					}
				}
			}
			
			if ( createDtlVoList.size() > 0 ) {
				String znDtlSeq = null;
				znDtlSeq = dbDao.searchZoneDtlSeq(createDtlVoList.get(0).getZnCd());
				for ( int i=0; i<createDtlVoList.size(); i++ ) {
					 ZoneDtlVO  dtlVO = null;
					 dtlVO = createDtlVoList.get(i);
				     dbDao.addZoneDtlCode(dtlVO);
				     createDtlVoList.get(i).setZnSeq(String.valueOf(Integer.parseInt(znDtlSeq) + i));
				}
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyZoneDtlCode(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeZoneDtlCode(deleteDtlVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageZoneRqst(ZoneGroupVO zoneGroupVO, String rqstNo) throws EventException{
		try {
			ZoneVO zoneVO = zoneGroupVO.getZoneVO();
			ZoneDtlVO[] zoneDtlVOs = zoneGroupVO.getZoneDtlVOs();
//			zoneVO.setTztmHrs(zoneVO.getTztmHrs().replace(",", ""));
			
			List<ZoneDtlVO> createDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> updateDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> deleteDtlVoList = new ArrayList<ZoneDtlVO>();
			zoneVO.setUsrId(zoneGroupVO.getUsrId());
			zoneVO.setRqstNo(rqstNo);
			
			if ("U".equals(zoneVO.getIbflag())){
				dbDao.modifyZoneRqst(zoneVO);
			}else if ("I".equals(zoneVO.getIbflag())){
				dbDao.addZoneRqst(zoneVO);
			}
			if(zoneDtlVOs != null){
				for ( int i=0; i<zoneDtlVOs.length; i++ ) {
					zoneDtlVOs[i].setRqstNo(rqstNo);
					zoneDtlVOs[i].setUsrId(zoneGroupVO.getUsrId());
					if ("U".equals(zoneDtlVOs[i].getIbflag())){
						updateDtlVoList.add(zoneDtlVOs[i]);
					}else if ("I".equals(zoneDtlVOs[i].getIbflag())){
						createDtlVoList.add(zoneDtlVOs[i]);
					}else if ("D".equals(zoneDtlVOs[i].getIbflag())){
						deleteDtlVoList.add(zoneDtlVOs[i]);
					}
				}
			}
			
			if ( createDtlVoList.size() > 0 ) {
				for ( int i=0; i<createDtlVoList.size(); i++ ) {
					 ZoneDtlVO  dtlVO = null;
					 dtlVO = createDtlVoList.get(i);
				     dbDao.addZoneDtlRqst(dtlVO);
				}
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyZoneDtlRqst(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeZoneDtlRqst(deleteDtlVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @exception EventException
	 */
	public void manageZoneRqst(ZoneGroupVO zoneGroupVO) throws EventException{
		try {
			ZoneVO zoneVO = zoneGroupVO.getZoneVO();
			ZoneDtlVO[] zoneDtlVOs = zoneGroupVO.getZoneDtlVOs();
//			zoneVO.setTztmHrs(zoneVO.getTztmHrs().replace(",", ""));
			
			List<ZoneDtlVO> createDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> updateDtlVoList = new ArrayList<ZoneDtlVO>();
			List<ZoneDtlVO> deleteDtlVoList = new ArrayList<ZoneDtlVO>();
			zoneVO.setUsrId(zoneGroupVO.getUsrId());
			
			if ("U".equals(zoneVO.getIbflag())){
				dbDao.modifyZoneCode(zoneVO);
			}else if ("I".equals(zoneVO.getIbflag())){
				dbDao.addZoneCode(zoneVO);
			}
			if(zoneDtlVOs != null){
				for ( int i=0; i<zoneDtlVOs.length; i++ ) {
					zoneDtlVOs[i].setUsrId(zoneGroupVO.getUsrId());
					if ("U".equals(zoneDtlVOs[i].getIbflag())){
						updateDtlVoList.add(zoneDtlVOs[i]);
					}else if ("I".equals(zoneDtlVOs[i].getIbflag())){
						createDtlVoList.add(zoneDtlVOs[i]);
					}else if ("D".equals(zoneDtlVOs[i].getIbflag())){
						deleteDtlVoList.add(zoneDtlVOs[i]);
					}
				}
			}
			
			if ( createDtlVoList.size() > 0 ) {
				for ( int i=0; i<createDtlVoList.size(); i++ ) {
					 ZoneDtlVO  dtlVO = null;
					 dtlVO = createDtlVoList.get(i);
				     dbDao.addZoneDtlCode(dtlVO);
				}
			
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyZoneDtlCode(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeZoneDtlCode(deleteDtlVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Country Info retrieve.<br>
	 * 
	 * @param String rgnCd
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchCountryInfo(String rgnCd) throws EventException {
		try {
			return dbDao.searchCountryInfo(rgnCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Call EQR_CREATE_LOC_LVL_PRC Procedure.<br>
	 * 
	 * @param String usrId
	 * @exception EventException
	 */
	public void callEqrLocLvl(String usrId) throws EventException {
		try {
			dbDao.callEqrLocLvl(usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Modify/save/delete event process<br>
	 * Location (BCM_CCD_0019.do) For EAI I/F process<br>
	 * 
	 * @param LocationVO locVO
	 * @exception EventException
	 */
	public void manageLocIf(LocationVO locVO) throws EventException {		
		try {		
			LocationIfVO locationifVO = new LocationIfVO();
			String loc_if_seq = "";
			
			//CUST_PERF_GRP_IF_SEQ 채번
			loc_if_seq = searchLocIfSeq();
			locationifVO.setLocIfSeq(loc_if_seq);

			locationifVO.setLocCd(locVO.getLocCd());
			locationifVO.setSccCd(locVO.getSccCd());
			locationifVO.setLocNm(locVO.getLocNm());
			locationifVO.setRgnCd(locVO.getRgnCd());
			locationifVO.setCntCd(locVO.getCntCd());
			locationifVO.setSteCd(locVO.getSteCd());
			locationifVO.setContiCd(locVO.getContiCd());
			locationifVO.setPortInlndFlg(locVO.getPortInlndFlg());
			locationifVO.setLocChrCd(locVO.getLocChrCd());
			locationifVO.setHubLocCd(locVO.getHubLocCd());
			locationifVO.setSlsOfcCd(locVO.getSlsOfcCd());
			locationifVO.setGmtHrs(locVO.getGmtHrs());
			locationifVO.setCallPortFlg(locVO.getCallPortFlg());
			locationifVO.setLocAmsPortCd(locVO.getLocAmsPortCd());
			locationifVO.setFincCtrlOfcCd(locVO.getFincCtrlOfcCd());
			locationifVO.setEqCtrlOfcCd(locVO.getEqCtrlOfcCd());
			locationifVO.setMtyPkupYdCd(locVO.getMtyPkupYdCd());
			locationifVO.setEqRtnYdCd(locVO.getEqRtnYdCd());
			locationifVO.setUnLocIndCd(locVO.getUnLocIndCd());
			locationifVO.setUnLocCd(locVO.getUnLocCd());
			locationifVO.setCmlZnFlg(locVO.getCmlZnFlg());
			locationifVO.setCstmsCd(locVO.getCstmsCd());
			locationifVO.setLocTpCd(locVO.getLocTpCd());
			locationifVO.setRepZnCd(locVO.getRepZnCd());
			locationifVO.setZipCd(locVO.getZipCd());
			locationifVO.setScontiCd(locVO.getScontiCd());
			locationifVO.setLocLoclLangNm(locVO.getLocLoclLangNm());
			locationifVO.setLocLat(locVO.getLocLat());
			locationifVO.setLatUtCd(locVO.getLatUtCd());
			locationifVO.setLocLon(locVO.getLocLon());
			locationifVO.setLonUtCd(locVO.getLonUtCd());
			
			locationifVO.setCreUsrId(locVO.getUsrId());
			locationifVO.setUpdUsrId(locVO.getUsrId());
			locationifVO.setDeltFlg(locVO.getDeltFlg());
			locationifVO.setModiLocCd(locVO.getModiLocCd());

			locationifVO.setNewLocLat(locVO.getNewLocLat());
			locationifVO.setNewLocLon(locVO.getNewLocLon());
			
			locationifVO.setEcomInsfId("OPECOM08");
			locationifVO.setOcediInsfId("OCEDI06");
			if(!"N".equals(locVO.getEdiIfFlg())||"Y".equals(locVO.getDeltFlg())){
				locationifVO.setOpediInsfId("OPEDI03");
				locationifVO.setOpediInsfDvCd(locVO.getEdiIfFlg());
			}else{
				locationifVO.setOpediInsfId("");
			}
			
			

			if(locVO.getIbflag().equals("I")){
				locationifVO.setEcomInsfDvCd("I");
				locationifVO.setOcediInsfDvCd("I");
				
			}else if(locVO.getIbflag().equals("U")){
				if(locVO.getDeltFlg().equals("Y")){
					locationifVO.setEcomInsfDvCd("D");
					locationifVO.setOcediInsfDvCd("D");
					locationifVO.setOpediInsfDvCd("D");
				}else {
					locationifVO.setEcomInsfDvCd("U");
					locationifVO.setOcediInsfDvCd("U");
					
				}
			}

			dbDao.addLocIf(locationifVO);
			dbDao.addLocIbisIf(locationifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * Location EAI I/F 의 테이블(MDM_LOCATION_IF)의 LOC_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0019)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchLocIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String loc_if_seq = "";
        
        try {
            rowSet=dbDao.searchLocIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		loc_if_seq = rowSet.getString(1);
            	}
            }
            return loc_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Modify/save/delete event process<br>
	 * Yard (BCM_CCD_0020.do) For EAI I/F process<br>
	 * 
	 * @param YardVO yardVO
	 * @exception EventException
	 */
	public void manageYardIf(YardVO yardVO) throws EventException {		
		try {		
			YardIfVO yardifVO = new YardIfVO();
			String yd_if_seq = "";
			
			//CUST_PERF_GRP_IF_SEQ 채번
			yd_if_seq = searchYardIfSeq();
			yardifVO.setYdIfSeq(yd_if_seq);

			yardifVO.setYdCd(yardVO.getYdCd());
			yardifVO.setYdNm(yardVO.getYdNm());
			yardifVO.setEqSccCd(yardVO.getEqSccCd());
			yardifVO.setN1stVndrSeq(yardVO.getN1stVndrSeq());
			yardifVO.setOfcCd(yardVO.getOfcCd());
			yardifVO.setYdChrCd(yardVO.getYdChrCd());
			yardifVO.setYdFctyTpMrnTmlFlg(yardVO.getYdFctyTpMrnTmlFlg());
			yardifVO.setYdFctyTpCyFlg(yardVO.getYdFctyTpCyFlg());
			yardifVO.setYdFctyTpCfsFlg(yardVO.getYdFctyTpCfsFlg());
			yardifVO.setYdFctyTpRailRmpFlg(yardVO.getYdFctyTpRailRmpFlg());
			yardifVO.setYdOshpCd(yardVO.getYdOshpCd());
			yardifVO.setBdYdFlg(yardVO.getBdYdFlg());
			yardifVO.setRepZnCd(yardVO.getRepZnCd());
			yardifVO.setYdAddr(yardVO.getYdAddr());
			yardifVO.setZipCd(yardVO.getZipCd());
			yardifVO.setIntlPhnNo(yardVO.getIntlPhnNo());
			yardifVO.setPhnNo(yardVO.getPhnNo());
			yardifVO.setFaxNo(yardVO.getFaxNo());
			yardifVO.setYdPicNm(yardVO.getYdPicNm());
			yardifVO.setYdCeoNm(yardVO.getYdCeoNm());
			yardifVO.setGateOpnHrmnt(yardVO.getGateOpnHrmnt());
			yardifVO.setGateClzHrmnt(yardVO.getGateClzHrmnt());
			yardifVO.setHolGateOpnHrmnt(yardVO.getHolGateOpnHrmnt());
			yardifVO.setHolGateClzHrmnt(yardVO.getHolGateClzHrmnt());
			yardifVO.setSunGateOpnHrmnt(yardVO.getSunGateOpnHrmnt());
			yardifVO.setSunGateClzHrmnt(yardVO.getSunGateClzHrmnt());
			yardifVO.setSatGateOpnHrmnt(yardVO.getSatGateOpnHrmnt());
			yardifVO.setSatGateClzHrmnt(yardVO.getSatGateClzHrmnt());
			yardifVO.setYdCgoClzHrmntMsg(yardVO.getYdCgoClzHrmntMsg());
			yardifVO.setYdRmk(yardVO.getYdRmk());
			yardifVO.setBrthNo(yardVO.getBrthNo());
			yardifVO.setYdBrthLen(yardVO.getYdBrthLen());
			yardifVO.setYdBrthDpthChnlKnt(yardVO.getYdBrthDpthChnlKnt());
			yardifVO.setYdTtlSpc(yardVO.getYdTtlSpc());
			yardifVO.setYdActSpc(yardVO.getYdActSpc());
			yardifVO.setYdHndlCapa(yardVO.getYdHndlCapa());
			yardifVO.setYdRfRcpt440vKnt(yardVO.getYdRfRcpt440vKnt());
			yardifVO.setYdRfRcpt220vKnt(yardVO.getYdRfRcpt220vKnt());
			yardifVO.setYdRfRcptDulKnt(yardVO.getYdRfRcptDulKnt());
			yardifVO.setYdOpSysCd(yardVO.getYdOpSysCd());
			yardifVO.setYdInrlFlg(yardVO.getYdInrlFlg());
			yardifVO.setYdCfsSpc(yardVO.getYdCfsSpc());
			yardifVO.setMnrShopFlg(yardVO.getMnrShopFlg());
			yardifVO.setYdHndlYr(yardVO.getYdHndlYr());
			yardifVO.setYdTtlVolTeuKnt(yardVO.getYdTtlVolTeuKnt());
			yardifVO.setYdTtlVolBxKnt(yardVO.getYdTtlVolBxKnt());
			yardifVO.setYdCoVolTeuKnt(yardVO.getYdCoVolTeuKnt());
			yardifVO.setYdCoVolBxKnt(yardVO.getYdCoVolBxKnt());
			yardifVO.setYdPstPgcKnt(yardVO.getYdPstPgcKnt());
			yardifVO.setYdPgcKnt(yardVO.getYdPgcKnt());
			yardifVO.setTrstrKnt(yardVO.getTrstrKnt());
			yardifVO.setFrkKnt(yardVO.getFrkKnt());
			yardifVO.setYdStrdlCrrKnt(yardVO.getYdStrdlCrrKnt());
			yardifVO.setYdTrctKnt(yardVO.getYdTrctKnt());
			yardifVO.setYdTopLftKnt(yardVO.getYdTopLftKnt());
			yardifVO.setTmlChssKnt(yardVO.getTmlChssKnt());
			yardifVO.setEirSvcFlg(yardVO.getEirSvcFlg());
			yardifVO.setTmlProdKnt(yardVO.getTmlProdKnt());
			yardifVO.setYdCstmsNo(yardVO.getYdCstmsNo());
			yardifVO.setYdFctyTpPsdoYdFlg(yardVO.getYdFctyTpPsdoYdFlg());
			yardifVO.setYdEml(yardVO.getYdEml());
			yardifVO.setDemIbCltFlg(yardVO.getDemIbCltFlg());
			yardifVO.setDemObCltFlg(yardVO.getDemObCltFlg());
			yardifVO.setBkgPodYdFlg(yardVO.getBkgPodYdFlg());
			yardifVO.setN2ndVndrSeq(yardVO.getN2ndVndrSeq());
			yardifVO.setN3rdVndrSeq(yardVO.getN3rdVndrSeq());
			yardifVO.setDmdtOfcCd(yardVO.getDmdtOfcCd());
			yardifVO.setRepYdTpCd(yardVO.getYdChrCd());
			yardifVO.setHubYdFlg(yardVO.getHubYdFlg());
			yardifVO.setYdLoclLangNm(yardVO.getYdLoclLangNm());
			yardifVO.setYdLoclLangAddr(yardVO.getYdLoclLangAddr());
			
			yardifVO.setCreUsrId(yardVO.getUsrId());
			yardifVO.setUpdUsrId(yardVO.getUsrId());
			yardifVO.setDeltFlg(yardVO.getDeltFlg());
			
			yardifVO.setYdLat(yardVO.getYdLat());
			yardifVO.setYdLon(yardVO.getYdLon());
			yardifVO.setEcomInsfId("OPECOM07");
			yardifVO.setOcediInsfId("OCEDI05");
			if("Y".equals(yardVO.getEdiIfFlg())||"Y".equals(yardVO.getDeltFlg())){
				yardifVO.setOpediInsfId("OPEDI01");
			}else{
				yardifVO.setOpediInsfId("");
			}
			
			yardifVO.setModiYdCd(yardVO.getModiYdCd());

			if(yardVO.getIbflag().equals("I")){
				yardifVO.setEcomInsfDvCd("I");
				yardifVO.setOcediInsfDvCd("I");
				yardifVO.setOpediInsfDvCd("I");
			}else if(yardVO.getIbflag().equals("U")){
				if(yardVO.getDeltFlg().equals("Y")){
					yardifVO.setEcomInsfDvCd("D");
					yardifVO.setOcediInsfDvCd("D");
					yardifVO.setOpediInsfDvCd("D");
				}else {
					yardifVO.setEcomInsfDvCd("U");
					yardifVO.setOcediInsfDvCd("U");
					yardifVO.setOpediInsfDvCd("U");
				}
			}

			dbDao.addYardIf(yardifVO);
			dbDao.addYardIbisIf(yardifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * YardVO EAI I/F 의 테이블(MDM_YARD_IF)의 YD_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0020)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchYardIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String yd_if_seq = "";
        
        try {
            rowSet=dbDao.searchYardIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		yd_if_seq = rowSet.getString(1);
            	}
            }
            return yd_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Modify/save/delete event process<br>
	 * Country (BCM_CCD_0016.do) For EAI I/F process<br>
	 * 
	 * @param CountryVO countryVO
	 * @exception EventException
	 */
	public void manageCountryIf(CountryVO countryVO) throws EventException {		
		try {		
			CountryIfVO countryifVO = new CountryIfVO();
			String cnt_if_seq = "";
			
			//CNT_IF_SEQ 채번
			cnt_if_seq = searchCountryIfSeq();
			countryifVO.setCntIfSeq(cnt_if_seq);

			countryifVO.setCntCd(countryVO.getCntCd());
			countryifVO.setCntNm(countryVO.getCntNm());
			countryifVO.setScontiCd(countryVO.getScontiCd());
			countryifVO.setCurrCd(countryVO.getCurrCd());
			countryifVO.setCntIsoCd(countryVO.getCntIsoCd());
			
			countryifVO.setCreUsrId(countryVO.getUsrId());
			countryifVO.setUpdUsrId(countryVO.getUsrId());
			countryifVO.setDeltFlg(countryVO.getDeltFlg());
			
			countryifVO.setEuCntFlg(countryVO.getEuCntFlg());

			countryifVO.setEcomInsfId("OPECOM09");
			countryifVO.setOcediInsfId("OCEDI07");

			if(countryVO.getIbflag().equals("I")){
				countryifVO.setEcomInsfDvCd("I");
				countryifVO.setOcediInsfDvCd("I");
			}else if(countryVO.getIbflag().equals("U")){
				if(countryVO.getDeltFlg().equals("Y")){
					countryifVO.setEcomInsfDvCd("D");
					countryifVO.setOcediInsfDvCd("D");
				}else {
					countryifVO.setEcomInsfDvCd("U");
					countryifVO.setOcediInsfDvCd("U");
				}
			}

			dbDao.addCountryIf(countryifVO);
			dbDao.addCountryIbisIf(countryifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * Country EAI I/F 의 테이블(MDM_COUNTRY_IF)의 CNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0016)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String cnt_if_seq = "";
        
        try {
            rowSet=dbDao.searchCountryIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		cnt_if_seq = rowSet.getString(1);
            	}
            }
            return cnt_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Modify/save/delete event process<br>
	 * State (BCM_CCD_0018.do) For EAI I/F process<br>
	 * 
	 * @param StateVO stateVO
	 * @exception EventException
	 */
	public void manageStateIf(StateVO stateVO) throws EventException {		
		try {		
			StateIfVO stateifVO = new StateIfVO();
			String ste_if_seq = "";
			
			//STE_IF_SEQ 채번
			ste_if_seq = searchStateIfSeq();
			stateifVO.setSteIfSeq(ste_if_seq);

			stateifVO.setCntCd(stateVO.getCntCd());
			stateifVO.setSteCd(stateVO.getSteCd());
			stateifVO.setSteNm(stateVO.getSteNm());
			stateifVO.setModiSteCd(stateVO.getModiSteCd());
			
			stateifVO.setCreUsrId(stateVO.getUsrId());
			stateifVO.setUpdUsrId(stateVO.getUsrId());
			stateifVO.setDeltFlg(stateVO.getDeltFlg());

			stateifVO.setEcomInsfId("OPECOM10");
			stateifVO.setOcediInsfId("OCEDI08");

			if(stateVO.getIbflag().equals("I")){
				stateifVO.setEcomInsfDvCd("I");
				stateifVO.setOcediInsfDvCd("I");
			}else if(stateVO.getIbflag().equals("U")){
				if(stateVO.getDeltFlg().equals("Y")){
					stateifVO.setEcomInsfDvCd("D");
					stateifVO.setOcediInsfDvCd("D");
				}else {
					stateifVO.setEcomInsfDvCd("U");
					stateifVO.setOcediInsfDvCd("U");
				}
			}

			dbDao.addStateIf(stateifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * State EAI I/F 의 테이블(MDM_STATE_IF)의 STE_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0018)<br>
	 * State Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchStateIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String ste_if_seq = "";
        
        try {
            rowSet=dbDao.searchStateIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ste_if_seq = rowSet.getString(1);
            	}
            }
            return ste_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * DayLight Saving Time save.<br>
	 * 160304 추가 , 엑셀저장  - only insert만 되게 
	 * @param DaySavingTimeVO dystVO
	 * @exception EventException
	 */
	public void manageExcelDyLgtSavTm(DaySavingTimeVO dystVO) throws EventException {
		String[] error = new String[1];
		try {
			if(dystVO != null ){
				dystVO.setStDstDt(dystVO.getStDstDt().replace("-", ""));
				dystVO.setEndDstDt(dystVO.getEndDstDt().replace("-", ""));
				dystVO.setStDstHrmnt(dystVO.getStDstHrmnt().replace(":", ""));
				dystVO.setEndDstHrmnt(dystVO.getEndDstHrmnt().replace(":", ""));
				error[0] = dystVO.getDstId();
				//dbDao.excelAddDyLgtSavTm(dystVO);
				dbDao.addDyLgtSavTm(dystVO);
				
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12226", error).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12226", error).getMessage(),ex);
		}
	}
	
	/**
	 * Transfer Location Info To EAI 
	 * 
	 * @param String locCd
	 * @param String usrId
	 * @param String creFlag
	 * @throws EventException	 
	 */
	public void sendLocToEai(String locCd, String usrId, String cudFlg) throws EventException {
		try {
			LocationMainIfVO locMainIfVO = dbDao.searchLocToEai(locCd);
			locMainIfVO.setUsrId(usrId);
			if(cudFlg.equals("I")) {
				locMainIfVO.setCudFlg("C");
			} else if(cudFlg.equals("U")) {
				locMainIfVO.setCudFlg("U");
			}
			log.debug("Location EAI Start : ");
			eaiDao.sendLocToEai(locMainIfVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Transfer Yard Info To EAI
	 * 
	 * @param String ydCd
	 * @param String usrId
	 * @param String creFlag
	 * @throws EventException
	 */
	public void sendYardToEai(String ydCd, String usrId, String cudFlg) throws EventException {
		try {
			YardMainIfVO ydMainIfVO = dbDao.searchYdToEai(ydCd);
			ydMainIfVO.setUsrId(usrId);
			if(cudFlg.equals("I")) {
				ydMainIfVO.setCudFlg("C");
			} else if(cudFlg.equals("U")) {
				ydMainIfVO.setCudFlg("U");
			}
			log.debug("Yard EAI Start : ");
			eaiDao.sendYardToEai(ydMainIfVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchNewDstCode(String fnDstId, String dstNotAplySteCd) throws EventException{
		DBRowSet rowSet = null;
        String dstId = "";
        
        try {
            rowSet=dbDao.searchNewDstCode(fnDstId, dstNotAplySteCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		dstId = rowSet.getString(1);
            	}
            }
            return dstId;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	* Prd Node 중복체크<br>
	* 
	* @param String z nCd
	* @return ZoneGroupVO
	* @exception EventException
	*/
	public String searchPrdNod(String nodCd) throws EventException {
		try {
			return dbDao.searchPrdNod(nodCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}