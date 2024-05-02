/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtBCImpl.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration.PortSOMasterDataMgtDBDAO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PortSOMasterDataMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of UI_PSO-0203EventResponse,PortSOMasterDataMgtBC 
 * @since J2EE 1.4
 */

public class PortSOMasterDataMgtBCImpl extends BasicCommandSupport implements PortSOMasterDataMgtBC {

	// Database Access Object
	private transient PortSOMasterDataMgtDBDAO dbDao = null;

	/**
	 * Creating object PortSOMasterDataMgtBCImpl <br>
	 * Creating PortSOMasterDataMgtDBDAO<br>
	 */
	public PortSOMasterDataMgtBCImpl() {
		dbDao = new PortSOMasterDataMgtDBDAO();
	}

	/**
	 * Retrieve BankInfo of vendor by using vendor_seq
	 * @param String vndrSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorInfo(String vndrSeq) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchVendorInfo(vndrSeq);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Banks"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Banks"}).getMessage(), ex);
		}
	}

	
	/**
	 * Retrieve BankInfo of vendor by using vendor_seq
	 * @param int vndrSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchAgentBankInfo(int vndrSeq) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchAgentBankInfo(vndrSeq);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Banks"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Banks"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieve vessel info
	 * @param String fromDate
	 * @param String toDate
	 * @param String srhCnd
	 * @return List<AuditDataCheckListVO>
	 * @exception EventException
	 */
	public List<AuditDataCheckListVO> searchAuditDataCheckList(String fromDate, String toDate, String srhCnd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchAuditDataCheckList(fromDate, toDate, srhCnd );
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Vessel"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Vessel"}).getMessage(), ex);
		}
	}

//	/**
//	 * Retrieve Vessel Default Setting Info
//	 * @param PortSOMasterDataConditionVO portSOMasterDataConditionVO
//	 * @return List<SearchAuditDataCheckListVO
//	 * @exception EventException
//	 */
//	public PortSOMasterDataMgtVO searchUserDefault (String ofcCd, String charge_type ) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			PortSOMasterDataMgtVO portSOMasterDataMgtVO = new PortSOMasterDataMgtVO();
//			List<PsoInvOfcYdVO> psoInvOfcYdVO = dbDao.searchYardListByUserOffice(ofcCd);
//			portSOMasterDataMgtVO.setPsoInvOfcYdVO(psoInvOfcYdVO);
//			List<DefaultCostVO> defaultCostVO = dbDao.searchCostListByUserOffice(ofcCd, charge_type );
//			portSOMasterDataMgtVO.setDefaultCostVO(defaultCostVO);
//			List<DefaultVendorVO> defaultVendorVO = dbDao.searchVendorListByUserOffice(ofcCd);
//			portSOMasterDataMgtVO.setDefaultVendorVO(defaultVendorVO);
//			return portSOMasterDataMgtVO;
//		} catch (DAOException ex) {
//			ex.printStackTrace();
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}


	/**
	 * Retrieve yard Info
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO>
	 * @exception EventException
	 */
	public List<PsoInvOfcYdVO> searchYardListByUserOffice (String ofcCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchYardListByUserOffice(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		}
	}


	
	/**
	 * Retrieve cost Info
	 * @param String ofcCd
	 * @param String chargeType
	 * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public List<DefaultCostVO> searchCostListByUserOffice(String ofcCd, String chargeType ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCostListByUserOffice(ofcCd,chargeType);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		}
	}
	

	
	/**
	 * Retrieve Vendor Info
	 * @param String ofcCd
	 * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public List<DefaultVendorVO> searchVendorListByUserOffice(String ofcCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchVendorListByUserOffice(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Vendor"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Vendor"}).getMessage(), ex);
		}
	}

	
	/**
	 * Retrieve cost Info
	 * @param String ofcCd
     * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchYardList (String ofcCd, String ydCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchYardList(ofcCd,ydCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		}
	}


	/**
	 * Retrieve cost Info
	 * @param String ofcCd 
	 * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @exception EventException
	 */
	public List<SearchYardsVO> searchPsoYardList (String ofcCd, String ydCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchPsoYardList(ofcCd,ydCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Yard"}).getMessage(), ex);
		}
	}

	/**
	 * save Yard/Vendor/Cost
	 * @param PortSOMasterDataMgtVO portSOMasterDataMgtVO
	 * @param String chargeType
	 * @exception EventException
	 */
	public void manageUserDefault( PortSOMasterDataMgtVO portSOMasterDataMgtVO, String chargeType ) throws EventException{
		try {
			PsoInvOfcYdVO[] psoInvOfcYdVO 		= portSOMasterDataMgtVO.getPsoInvOfcYdVO();
			DefaultCostVO[] defaultCostVO 		= portSOMasterDataMgtVO.getDefaultCostVO();
			DefaultVendorVO[] defaultVendorVO 	= portSOMasterDataMgtVO.getDefaultVendorVO();
			SignOnUserAccount account			= portSOMasterDataMgtVO.getAccount();
			
			List<PsoInvOfcYdVO> insertYdVoList = new ArrayList<PsoInvOfcYdVO>();
			List<PsoInvOfcYdVO> deleteYdVoList = new ArrayList<PsoInvOfcYdVO>();

			List<DefaultCostVO> insertCostVoList = new ArrayList<DefaultCostVO>();
			List<DefaultCostVO> deleteCostVoList = new ArrayList<DefaultCostVO>();

			List<DefaultVendorVO> insertVendorVoList = new ArrayList<DefaultVendorVO>();
			List<DefaultVendorVO> deleteVendorVoList = new ArrayList<DefaultVendorVO>();

			//Yard	
			if (psoInvOfcYdVO != null && psoInvOfcYdVO.length > 0) {
				for ( int i=0; i<psoInvOfcYdVO.length; i++ ) {
					
					if ( psoInvOfcYdVO[i].getIbflag().equals("D")){
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						deleteYdVoList.add(psoInvOfcYdVO[i]);
					} else {
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						
						//존재 하지 않을때만 Insert
						String existYn = dbDao.searchExistOfficeYard(psoInvOfcYdVO[i]);
						
						if(existYn.equals("N")){
							insertYdVoList.add(psoInvOfcYdVO[i]);
						}						
					}
					
					/*					
					if ( psoInvOfcYdVO[i].getIbflag().equals("R") ){
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						insertYdVoList.add(psoInvOfcYdVO[i]);
					} else if ( psoInvOfcYdVO[i].getIbflag().equals("I") ){
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						insertYdVoList.add(psoInvOfcYdVO[i]);
					} else if ( psoInvOfcYdVO[i].getIbflag().equals("U")){
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						insertYdVoList.add(psoInvOfcYdVO[i]);
					} else if ( psoInvOfcYdVO[i].getIbflag().equals("D")){
						psoInvOfcYdVO[i].setCreUsrId(account.getUsr_id());
						psoInvOfcYdVO[i].setOfcCd(account.getOfc_cd());
						deleteYdVoList.add(psoInvOfcYdVO[i]);
					} */
				}
			}
			
			//Vendor
			if (defaultVendorVO != null && defaultVendorVO.length > 0) {
				for ( int i=0; i<defaultVendorVO.length; i++ ) {
					if ( defaultVendorVO[i].getIbflag().equals("D")){
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						deleteVendorVoList.add(defaultVendorVO[i]);
					} else {
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						
						//존재 하지 않으면 Insert.
						String existYn = dbDao.searchExistOfficeVendor(defaultVendorVO[i]);
						
						if(existYn.equals("N")){
							insertVendorVoList.add(defaultVendorVO[i]);
						}
					}
					/*
					if ( defaultVendorVO[i].getIbflag().equals("R") ){
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						insertVendorVoList.add(defaultVendorVO[i]);
					} else if ( defaultVendorVO[i].getIbflag().equals("I") ){
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						insertVendorVoList.add(defaultVendorVO[i]);
					} else if ( defaultVendorVO[i].getIbflag().equals("U")){
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						insertVendorVoList.add(defaultVendorVO[i]);
					} else if ( defaultVendorVO[i].getIbflag().equals("D")){
						defaultVendorVO[i].setCreUsrId(account.getUsr_id());
						defaultVendorVO[i].setOfcCd(account.getOfc_cd());
						deleteVendorVoList.add(defaultVendorVO[i]);
					}*/
				}
			}
			
			//Cost
			if (defaultCostVO != null && defaultCostVO.length > 0) {
				for ( int i=0; i<defaultCostVO.length; i++ ) {
					if (defaultCostVO[i].getChk().equals("1")){
						defaultCostVO[i].setCreUsrId(account.getUsr_id());
						defaultCostVO[i].setOfcCd(account.getOfc_cd());
						
						//존재 하지 않을때 Insert
						String existYn = dbDao.searchExistOfficeCost(defaultCostVO[i]);
						
						if(existYn.equals("N")){
							insertCostVoList.add(defaultCostVO[i]);
						}
						
					} else {
						defaultCostVO[i].setCreUsrId(account.getUsr_id());
						defaultCostVO[i].setOfcCd(account.getOfc_cd());
						
						String existYn = dbDao.searchExistOfficeCost(defaultCostVO[i]);
						
						if(existYn.equals("Y")){
							deleteCostVoList.add(defaultCostVO[i]);
						}
					}
					
					/*
					if ( defaultCostVO[i].getIbflag().equals("R") && defaultCostVO[i].getChk().equals("1")){
						defaultCostVO[i].setCreUsrId(account.getUsr_id());
						defaultCostVO[i].setOfcCd(account.getOfc_cd());
						insertCostVoList.add(defaultCostVO[i]);
					} else if ( defaultCostVO[i].getIbflag().equals("I") && defaultCostVO[i].getChk().equals("1")){
						defaultCostVO[i].setCreUsrId(account.getUsr_id());
						defaultCostVO[i].setOfcCd(account.getOfc_cd());
						insertCostVoList.add(defaultCostVO[i]);
					} else if ( defaultCostVO[i].getIbflag().equals("U") && defaultCostVO[i].getChk().equals("1") ){
						defaultCostVO[i].setCreUsrId(account.getUsr_id());
						defaultCostVO[i].setOfcCd(account.getOfc_cd());
						insertCostVoList.add(defaultCostVO[i]);
					}*/ 
				}
			}

			//Create 'deleteYdVoList' to delete Yard Data
			/*
			PsoInvOfcYdVO delYard = new PsoInvOfcYdVO();
			delYard.setOfcCd(account.getOfc_cd());
			deleteYdVoList.add(delYard);
			*/
			if( deleteYdVoList.size() > 0 ){
				dbDao.removeOfficeYards(deleteYdVoList);
			}
			if ( insertYdVoList.size() > 0 ) {
				dbDao.addOfficeYards(insertYdVoList);
			}

			//Create 'delVendor' to delete Vendor Data
			/*
			DefaultVendorVO delVendor = new DefaultVendorVO();
			delVendor.setOfcCd(account.getOfc_cd());
			deleteVendorVoList.add(delVendor);
			*/
			if( deleteVendorVoList.size() > 0 ){
				dbDao.removeOfficeVendors(deleteVendorVoList);
			}
			if ( insertVendorVoList.size() > 0 ) {
				dbDao.addOfficeVendors(insertVendorVoList);
			}

			//Create 'delCost' to delete Cost Data
			/*
			DefaultCostVO delCost = new DefaultCostVO();
			delCost.setOfcCd(account.getOfc_cd());
			delCost.setChargeType(chargeType);
			deleteCostVoList.add(delCost);
			*/
			if( deleteCostVoList.size() > 0 ){
				dbDao.removeOfficeCosts(deleteCostVoList);
			}
			if ( insertCostVoList.size() > 0 ) {
				dbDao.addOfficeCosts(insertCostVoList);
			}
			
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Yard/Vendor/Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Yard/Vendor/Cost"}).getMessage(), ex);
		}
		
	}

	/**
	 * retrieve CostCode list related login user 
	 * @param String ofcCd
     * @param String chargeType
     * @param String cnlAgnFlg
     * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public List<DefaultCostVO> searchOfficeCosts(String ofcCd, String chargeType, String cnlAgnFlg) throws  EventException {
		try {
			return dbDao.searchOfficeCosts(ofcCd,chargeType,cnlAgnFlg);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		}
	}

	/**
	 * retrieve ExchageRate Flag 
	 * @param String currCd
     * @param String issDt
     * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public String searchExistExchageRate(String currCd, String issDt) throws  EventException {
		try {
			return dbDao.searchExistExchageRate(currCd, issDt);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve  office Yard of login user 
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO> 
	 * @throws EventException
	 */
	public List<PsoInvOfcYdVO> searchOfficeYards(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfficeYards(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Office Yard"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Office Yard"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Currency Info
	 * @return List<CurrencyVO>
	 * @throws EventException
	 */
	public List<CurrencyVO> searchCurrency() throws EventException {
		try {
			return dbDao.searchCurrency();
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Currency"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_PSO_0014 : Window Open <br/>
	 * initial data query of Invoice Creation & Audit page
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd 
	 * @return List<DefaultVendorVO>
	 * @throws EventException
	 */
	public List<DefaultVendorVO> searchOfficeVendors(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfficeVendors(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Office Vendors"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Office Vendors"}).getMessage(), ex);
		}
	}
	
}