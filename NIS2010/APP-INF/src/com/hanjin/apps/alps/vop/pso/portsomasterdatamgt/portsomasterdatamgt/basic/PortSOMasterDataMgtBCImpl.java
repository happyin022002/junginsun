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
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration.PortSOMasterDataMgtDBDAO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PortSOMasterDataMgtVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PortSOMasterDataMgt Business Logic Basic Command implementation<br>
 * - ALPS-PortSOMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0203EventResponse,PortSOMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class PortSOMasterDataMgtBCImpl extends BasicCommandSupport implements PortSOMasterDataMgtBC {

	// Database Access Object
	private transient PortSOMasterDataMgtDBDAO dbDao = null;

	/**
	 * PortSOMasterDataMgtBCImpl 객체 생성<br>
	 * PortSOMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public PortSOMasterDataMgtBCImpl() {
		dbDao = new PortSOMasterDataMgtDBDAO();
	}

	/**
	 * vendor seq를 기준으로 Vendor의 Bank정보를 조회한다.
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
	 * vendor seq를 기준으로 Vendor의 Bank정보를 조회한다.
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
	 * 선박  Vessel 정보를 조회한다.
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
//	 * 선박  Default Setting 정보를 조회한다.
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
	 * yard 정보를 조회한다.
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
	 * cost 정보를 조회한다.
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
	 * Vendor 정보를 조회한다.
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
	 * yard 정보를 조회한다.
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
	 * yard 정보를 조회한다.
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
	 * Yard/Vendor/Cost를 저장합니다. (In화면)<br>
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
					}
				}
			}
			
			//Vendor
			if (defaultVendorVO != null && defaultVendorVO.length > 0) {
				for ( int i=0; i<defaultVendorVO.length; i++ ) {
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
					} 
				}
			}
			
			//Cost
			if (defaultCostVO != null && defaultCostVO.length > 0) {
				for ( int i=0; i<defaultCostVO.length; i++ ) {
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
					} 
				}
			}

			//Create 'deleteYdVoList' to delete Yard Data
			//테이블의 데이터를 전부 삭제후 Insert
			PsoInvOfcYdVO delYard = new PsoInvOfcYdVO();
			delYard.setOfcCd(account.getOfc_cd());
			deleteYdVoList.add(delYard);	
			dbDao.removeOfficeYards(deleteYdVoList);
			if ( insertYdVoList.size() > 0 ) {
				dbDao.addOfficeYards(insertYdVoList);
			}

			//Create 'delVendor' to delete Vendor Data
			//테이블의 데이터를 전부 삭제후 Insert
			DefaultVendorVO delVendor = new DefaultVendorVO();
			delVendor.setOfcCd(account.getOfc_cd());
			deleteVendorVoList.add(delVendor);
			dbDao.removeOfficeVendors(deleteVendorVoList);
			if ( insertVendorVoList.size() > 0 ) {
				dbDao.addOfficeVendors(insertVendorVoList);
			}

			//Create 'delCost' to delete Cost Data
			//테이블의 데이터를 전부 삭제후 Insert
			DefaultCostVO delCost = new DefaultCostVO();
			delCost.setOfcCd(account.getOfc_cd());
			delCost.setChargeType(chargeType);
			deleteCostVoList.add(delCost);
			dbDao.removeOfficeCosts(deleteCostVoList);
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
	 * 로긴 유저의 관련 CostCode리스트를 조회한다.
	 * @param String ofcCd
     * @param String chargeType
     * @return List<DefaultCostVO>
	 * @exception EventException
	 */
	public List<DefaultCostVO> searchOfficeCosts(String ofcCd,
			String chargeType) throws  EventException {
		try {
			return dbDao.searchOfficeCosts(ofcCd,chargeType);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{"Cost"}).getMessage(), ex);
		}
	}

	/**
	 * 로긴 유저의 office Yard 를 조회 한다.
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO> 
	 * @throws EventException
	 */
	public List<PsoInvOfcYdVO> searchOfficeYards(String ofcCd)
			throws EventException {
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
	 * Currency 정보를 조회한다. 
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
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd 
	 * @return List<DefaultVendorVO>
	 * @throws EventException
	 */
	public List<DefaultVendorVO> searchOfficeVendors(String ofcCd)
			throws EventException {
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