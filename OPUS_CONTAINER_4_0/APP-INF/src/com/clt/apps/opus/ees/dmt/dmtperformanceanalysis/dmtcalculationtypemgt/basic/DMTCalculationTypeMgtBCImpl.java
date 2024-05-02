/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtBCImpl.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration.DMTCalculationTypeMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtCmbSetVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtSkpLocVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.WeekendVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * DMTPerformanceAnalysis Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see EES_DMT_7001EventResponse,DMTCalculationTypeMgtBC DAO class reference
 * @since J2EE 1.4
 */
public class DMTCalculationTypeMgtBCImpl extends BasicCommandSupport implements DMTCalculationTypeMgtBC {

	// Database Access Object
	private transient DMTCalculationTypeMgtDBDAO dbDao = null;

	/**
	 * DMTCalculationTypeMgtBCImpl Create object<br>
	 * DMTCalculationTypeMgtDBDAO Create.<br>
	 */
	public DMTCalculationTypeMgtBCImpl() {
		dbDao = new DMTCalculationTypeMgtDBDAO();
	}
	
	/**
	 * Search Tariff Type List information.
	 * 
	 * @param DmtTrfTpVO dmtTrfTpVO
	 * @return List<DmtTrfTpVO>
	 * @exception EventException
	 */
	public List<DmtTrfTpVO> searchTariffTypeList(DmtTrfTpVO dmtTrfTpVO) throws EventException {
		try {
			return dbDao.searchTariffTypeList(dmtTrfTpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search WeekendList information .
	 * 
	 * @param weekendVO WeekendVO
	 * @return List<DmtTrfTpVO>
	 * @exception EventException
	 */
	public List<WeekendVO> searchWeekendList(WeekendVO weekendVO) throws EventException {
		try {
			return dbDao.searchWeekendList(weekendVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *Create, Modify and  Delete Weekend information. <br>
	 * 
	 * @param WeekendVO[] weekendVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWeekend(WeekendVO[] weekendVOs, SignOnUserAccount account) throws EventException {
		
		try {			
			List<WeekendVO> insertVoList = new ArrayList<WeekendVO>();
			List<WeekendVO> updateVoList = new ArrayList<WeekendVO>();
			List<WeekendVO> deleteVoList = new ArrayList<WeekendVO>();
			
			if (weekendVOs != null) {
				for ( int i = 0 ; i < weekendVOs.length ; i++ ) {
					if (weekendVOs[i].getIbflag().equals("I")){
						weekendVOs[i].setCreUsrId(account.getUsr_id());
						weekendVOs[i].setCreOfcCd(account.getOfc_cd());
						insertVoList.add(weekendVOs[i]);
					} else if (weekendVOs[i].getIbflag().equals("U")){
						weekendVOs[i].setUpdUsrId(account.getUsr_id());
						weekendVOs[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(weekendVOs[i]);
					} else if (weekendVOs[i].getIbflag().equals("D")){
						weekendVOs[i].setUpdUsrId(account.getUsr_id());
						weekendVOs[i].setUpdOfcCd(account.getOfc_cd());					
						deleteVoList.add(weekendVOs[i]);
					}
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addWeekend(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyWeekend(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeWeekend(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		}
	}
	
	
	/**
	 * Search Calculation Type List information.
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return List<CalculationTypeParmVO>
	 * @exception EventException
	 */
	public List<CalculationTypeParmVO> searchCalculationTypeList(CalculationTypeParmVO calculationTypeParmVO) throws EventException {
		try {
			return dbDao.searchCalculationTypeList(calculationTypeParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Modify Tariff Type Setup information.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO, SignOnUserAccount account)
			throws EventException {
		try {
			dmtOfcUsrTrfOptVO.setOfcCd(account.getOfc_cd());
			dmtOfcUsrTrfOptVO.setUsrId(account.getUsr_id());
			String isExist = dbDao.searchTariffTypeSetup(dmtOfcUsrTrfOptVO);
			
			if(isExist.equals("N")) {
				dbDao.addTariffTypeSetup(dmtOfcUsrTrfOptVO);
			} else {
				dbDao.modifyTariffTypeSetup(dmtOfcUsrTrfOptVO);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Modifying Calculation Type Entry. <br>
	 * 
	 * @param CalculationTypeParmVO[] CalculationTypeParmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCalculationTypeEntry(CalculationTypeParmVO[] CalculationTypeParmVOs, SignOnUserAccount account) throws EventException{
		
		try {
			
			List<CalculationTypeParmVO> insertVoList = new ArrayList<CalculationTypeParmVO>();
			List<CalculationTypeParmVO> updateVoList = new ArrayList<CalculationTypeParmVO>();
			List<CalculationTypeParmVO> deleteVoList = new ArrayList<CalculationTypeParmVO>();
			
			if (CalculationTypeParmVOs != null) {
				for ( int i = 0 ; i < CalculationTypeParmVOs.length ; i++ ) {
					if (CalculationTypeParmVOs[i].getIbflag().equals("I")){
						CalculationTypeParmVOs[i].setCreUsrId(account.getUsr_id());
						CalculationTypeParmVOs[i].setCreOfcCd(account.getOfc_cd());
						insertVoList.add(CalculationTypeParmVOs[i]);
					} else if (CalculationTypeParmVOs[i].getIbflag().equals("U")){
						CalculationTypeParmVOs[i].setUpdUsrId(account.getUsr_id());
						CalculationTypeParmVOs[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(CalculationTypeParmVOs[i]);
					} else if (CalculationTypeParmVOs[i].getIbflag().equals("D")){
						CalculationTypeParmVOs[i].setUpdUsrId(account.getUsr_id());
						CalculationTypeParmVOs[i].setUpdOfcCd(account.getOfc_cd());					
						deleteVoList.add(CalculationTypeParmVOs[i]);
					}
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCalculationTypeEntry(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCalculationTypeEntry(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCalculationTypeEntry(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		}
	}
	
	/**
	 * Checking The Duplicate Calculation Type Entry.<br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return CalculationTypeParmVO
	 * @exception EventException
	 */
	public CalculationTypeParmVO checkDuplicateCalculationTypeEntry(CalculationTypeParmVO calculationTypeParmVO) throws EventException {
		try {
			return dbDao.checkDuplicateCalculationTypeEntry(calculationTypeParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		}
	}
	
	/**
	 * Retrieving Combination Set Information
	 * 
	 * @return List<DmtCmbSetVO>
	 * @exception EventException
	 */
	public List<DmtCmbSetVO> searchCombinationSet() throws EventException {
		try {
			return dbDao.searchCombinationSet();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Modifying Combination Set Information<br>
	 * 
	 * @param DmtCmbSetVO[] dmtCmbSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCombinationSet(DmtCmbSetVO[] dmtCmbSetVOs, SignOnUserAccount account) throws EventException{
		
		try {
			List<DmtCmbSetVO> insertVoList = new ArrayList<DmtCmbSetVO>();
			List<DmtCmbSetVO> deleteVoList = new ArrayList<DmtCmbSetVO>();
			
			if (dmtCmbSetVOs != null) {
				for ( int i = 0 ; i < dmtCmbSetVOs.length ; i++ ) {
					if (dmtCmbSetVOs[i].getIbflag().equals("I")){
						dmtCmbSetVOs[i].setCreUsrId(account.getUsr_id());
						dmtCmbSetVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(dmtCmbSetVOs[i]);
					} else if (dmtCmbSetVOs[i].getIbflag().equals("D")){
						dmtCmbSetVOs[i].setUpdUsrId(account.getUsr_id());
						dmtCmbSetVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(dmtCmbSetVOs[i]);
					}
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCombinationSet(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteCombinationSet(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("DMT00003").getMessage(), ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("DMT00003").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Skip Location Set Information
	 * 
	 * @return List<DmtSkpLocVO>
	 * @exception EventException
	 */
	public List<DmtSkpLocVO> searchSkipLocation() throws EventException {
		try {
			return dbDao.searchSkipLocation();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Modifying Skip Location Set Information<br>
	 * 
	 * @param DmtSkpLocVO[] dmtSkcLocVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSkipLocation(DmtSkpLocVO[] dmtSkcLocVOs, SignOnUserAccount account) throws EventException{
		
		try {
			List<DmtSkpLocVO> insertVoList = new ArrayList<DmtSkpLocVO>();
			//List<DmtSkpLocVO> updateVoList = new ArrayList<DmtSkpLocVO>();
			List<DmtSkpLocVO> deleteVoList = new ArrayList<DmtSkpLocVO>();
			
			if (dmtSkcLocVOs != null) {
				for ( int i = 0 ; i < dmtSkcLocVOs.length ; i++ ) {
					if (dmtSkcLocVOs[i].getIbflag().equals("I")){
						dmtSkcLocVOs[i].setCreUsrId(account.getUsr_id());
						dmtSkcLocVOs[i].setUpdUsrId(account.getUsr_id());
						dmtSkcLocVOs[i].setCreOfcCd(account.getOfc_cd());
						dmtSkcLocVOs[i].setUpdOfcCd(account.getOfc_cd());
						insertVoList.add(dmtSkcLocVOs[i]);
					} else if (dmtSkcLocVOs[i].getIbflag().equals("D")){
						dmtSkcLocVOs[i].setUpdUsrId(account.getUsr_id());
						dmtSkcLocVOs[i].setUpdUsrId(account.getUsr_id());
						dmtSkcLocVOs[i].setCreOfcCd(account.getOfc_cd());
						dmtSkcLocVOs[i].setUpdOfcCd(account.getOfc_cd());
						deleteVoList.add(dmtSkcLocVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSkipLocation(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteSkipLocation(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		}
	}
	
	/**
	 * Modifying Tariff Type Information<br>
	 * 
	 * @param DmtTrfTpVO[] dmtTrfTpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffType(DmtTrfTpVO[] dmtTrfTpVOs, SignOnUserAccount account) throws EventException{
		
		try {
			List<DmtTrfTpVO> insertVoList = new ArrayList<DmtTrfTpVO>();
			List<DmtTrfTpVO> updateVoList = new ArrayList<DmtTrfTpVO>();
			List<DmtTrfTpVO> deleteVoList = new ArrayList<DmtTrfTpVO>();
			
			if (dmtTrfTpVOs != null) {
				for ( int i = 0 ; i < dmtTrfTpVOs.length ; i++ ) {
					if (dmtTrfTpVOs[i].getIbflag().equals("I")){
						dmtTrfTpVOs[i].setCreUsrId(account.getUsr_id());
						dmtTrfTpVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(dmtTrfTpVOs[i]);
					} else if (dmtTrfTpVOs[i].getIbflag().equals("U")){
						dmtTrfTpVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(dmtTrfTpVOs[i]);
					} else if (dmtTrfTpVOs[i].getIbflag().equals("D")){
						deleteVoList.add(dmtTrfTpVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addTariffType(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTariffType(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteTariffType(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		}
	}
}
