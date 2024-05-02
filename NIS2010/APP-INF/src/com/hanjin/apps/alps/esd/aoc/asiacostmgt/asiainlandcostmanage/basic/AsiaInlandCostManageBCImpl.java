/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageBCImpl.java
*@FileTitle : Inland Cost Manage(SHA/SIN)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*=========================================================
* History
* 2014.03.07 서미진 [CHM-201429273] Confirmed cost만 보도록 수정 (Date 조건 삭제, Incl. Unconfirmed Cost 조건 삭제)
* 2014.03.17 서미진 [CHM-201429382] 1. DG, Overweight adjust한 data만 update 한다. 
									2. Confirm시 adjust 하지 않는 DG, Overweight transmode를 삭제한다.
									3. Confirm cancel시 삭제된 DG, Overweight transmode를 넣어준다.
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration.AsiaInlandCostManageDBDAO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaStatusMonitorVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-CostManage Business Logic Basic Command implementation<br>
 * - ALPS-CostManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EventResponse,CostManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AsiaInlandCostManageBCImpl extends BasicCommandSupport implements AsiaInlandCostManageBC {
	
	// Database Access Object
	private transient AsiaInlandCostManageDBDAO dbDao = null;

	/**
	 * CostManageBCImpl 객체 생성<br>
	 * InlandCostManageDBDAO를 생성한다.<br>
	 */
	public AsiaInlandCostManageBCImpl() {
		dbDao = new AsiaInlandCostManageDBDAO();
	}

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostVO> searchInlandCost(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCost(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Inland Cost Management tab DG - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCostSpecialCargo(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostVO> searchInlandCostReefer(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCostReefer(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException {
		try {
			return dbDao.searchInlandCostTariffNo(inCntCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public AsiaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException {
		try {
			//return dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			AsiaInlandCostTariffInfoVO asiaInlandCostTariffInfoVO = dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			return asiaInlandCostTariffInfoVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCost(AsiaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaInlandCostVO> updateVoList = new ArrayList<AsiaInlandCostVO>();

			for ( int i=0; i<inlandCostVOs .length; i++ ) {
				if ( inlandCostVOs[i].getIbflag().equals("U")){
					inlandCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(inlandCostVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiInlandCost(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostHdr(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.multiInlandCostHdr(inlandCostConditionVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param inlandCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostReefer(AsiaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AsiaInlandCostVO> insVoList = new ArrayList<AsiaInlandCostVO>();
			List<AsiaInlandCostVO> updVoList = new ArrayList<AsiaInlandCostVO>();
			List<AsiaInlandCostVO> delVoList = new ArrayList<AsiaInlandCostVO>();

			for ( int i=0; i<inlandCostVOs .length; i++ ) {
				inlandCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if( inlandCostVOs[i].getIbflag().equals("I") ){
					insVoList.add(inlandCostVOs[i]);
				} else if( inlandCostVOs[i].getIbflag().equals("U") ){
					updVoList.add(inlandCostVOs[i]);
				} else if( inlandCostVOs[i].getIbflag().equals("D") ){
					delVoList.add(inlandCostVOs[i]);
				}
			}
 
			if ( insVoList.size() > 0 ) {
				dbDao.addInlandCostReefer(insVoList);
			}
			if ( updVoList.size() > 0 ) {
				dbDao.modifyInlandCostReefer(updVoList);
			}
			if ( delVoList.size() > 0 ) {
				dbDao.removeInlandCostReefer(delVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Inland Cost Management - Country Code 확인<br>
	 * 
	 * @param String inCntCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCountryCode(String inCntCd) throws EventException {
		try {
			String cnt = dbDao.verifyCountryCode(inCntCd);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	
	/**
	 * Inland Cost Management - verifyInlandCostConfirm<br>
	 * 
	 * @param String inCostTrfNo
	 * @return String 
	 * @exception EventException
	 */
	public String verifyInlandCostConfirm(String inCostTrfNo) throws EventException {
		try {
			String cnt = dbDao.verifyInlandCostConfirm(inCostTrfNo);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management - Location Group 에 대한 Verify <br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyInlandCostLocGrpCnt(String inCostTrfNo) throws EventException {
		try {
			String cnt = dbDao.verifyInlandCostLocGrpCnt(inCostTrfNo);
			return cnt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management - confirmInlandCostPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCostPreVer(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmInlandCostPreVer(inlandCostConditionVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCost(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmInlandCost(inlandCostConditionVO, account);
			// Delete Special cargo not adjust 
			dbDao.removeInlandCostSpecialCargoS(inlandCostConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management - searchInlandCostGuidelineExist<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostGuidelineExist(String inCostTrfNo) throws EventException {
		try {
			String existFlg = dbDao.searchInlandCostGuidelineExist(inCostTrfNo);
			return existFlg;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}

	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxl<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxl(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyInlandCostMgtCfmCxl(inlandCostConditionVO, account);
			// add Special cargo
			dbDao.addInlandCostSpecialCargoS(inlandCostConditionVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyInlandCostMgtCfmCxlPreVer(inlandCostConditionVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param inlandCostSpecialCargoVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostSpecialCargo(AsiaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AsiaInlandCostSpecialCargoVO> updateVoList = new ArrayList<AsiaInlandCostSpecialCargoVO>();
			
			for ( int i=0; i<inlandCostSpecialCargoVOs .length; i++ ) {
				if (inlandCostSpecialCargoVOs[i].getIbflag().equals("U")){
					inlandCostSpecialCargoVOs[i].setCreUsrId(account.getUsr_id());
					inlandCostSpecialCargoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(inlandCostSpecialCargoVOs[i]);
				}				
			} 

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInlandCostSpecialCargoS(updateVoList);
			}			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostDetailVO> searchInlandCostDetail(AsiaInlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCostDetail(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}

	/**
	 * Inland Cost Management – Route Detail - Apply Select<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailSelect(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaInlandCostDetailVO> updateVoList = new ArrayList<AsiaInlandCostDetailVO>();
			List<AsiaInlandCostVO> delRfVoList = new ArrayList<AsiaInlandCostVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				if ( inlandCostDetailVOs[i].getIbflag().equals("U")){
					inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
					if ( inlandCostDetailVOs[i].getCostSelRoutFlg().equals("0")){
						inlandCostDetailVOs[i].setCostSelRoutFlg("N");
						
						AsiaInlandCostVO inlandCostVO = new AsiaInlandCostVO();
						inlandCostVO.setCostTrfNo(inlandCostDetailVOs[i].getCostTrfNo());
						inlandCostVO.setCostTrfRoutSeq(inlandCostDetailVOs[i].getCostTrfRoutSeq());
						inlandCostVO.setUpdUsrId(inlandCostDetailVOs[i].getUpdUsrId());
						delRfVoList.add(inlandCostVO);
					}else{
						inlandCostDetailVOs[i].setCostSelRoutFlg("Y");
					}
					updateVoList.add(inlandCostDetailVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiInlandCostDetailSelect(updateVoList);
			}
			
			if( delRfVoList.size() > 0 ){
				dbDao.removeInlandCostReefer(delRfVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCostDetailDeleteCheck(AsiaInlandCostDetailVO[] inlandCostDetailVOs) throws EventException {
		try {
			String cnt = "";
			List<AsiaInlandCostDetailVO> updateVoList = new ArrayList<AsiaInlandCostDetailVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				updateVoList.add(inlandCostDetailVOs[i]);
			}
 
			if ( updateVoList.size() > 0 ) {
				cnt = dbDao.searchInlandCostDetailDeleteCheck(updateVoList);
			}
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}

	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailDelete(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaInlandCostDetailVO> updateVoList = new ArrayList<AsiaInlandCostDetailVO>();
			List<AsiaInlandCostVO> delRfVoList = new ArrayList<AsiaInlandCostVO>();

			for( int i=0; i<inlandCostDetailVOs .length; i++ ){
				inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(inlandCostDetailVOs[i]);
				
				AsiaInlandCostVO inlandCostVO = new AsiaInlandCostVO();
				inlandCostVO.setCostTrfNo(inlandCostDetailVOs[i].getCostTrfNo());
				inlandCostVO.setCostTrfRoutSeq(inlandCostDetailVOs[i].getCostTrfRoutSeq());
				inlandCostVO.setUpdUsrId(inlandCostDetailVOs[i].getUpdUsrId());
				delRfVoList.add(inlandCostVO);
			}
 
			if( updateVoList.size() > 0 ){
				dbDao.multiInlandCostDetailDelete(updateVoList);
				dbDao.multiInlandCostDetail1stSelect(updateVoList);
			}
			
			if( delRfVoList.size() > 0 ){
				dbDao.removeInlandCostReefer(delRfVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Inland Cost Management – Route Detail - Apply Rest<br>
	 * 
	 * @param inlandCostDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandCostDetailRest(AsiaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaInlandCostDetailVO> updateVoList = new ArrayList<AsiaInlandCostDetailVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				if ( inlandCostDetailVOs[i].getIbflag().equals("U")){
					inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(inlandCostDetailVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiInlandCostDetailRest(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlandCostAccountVO> searchInlandCostAccount(AsiaInlandCostAccountVO inputVo) throws EventException {
		try {
			return dbDao.searchInlandCostAccount(inputVo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}

	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<AsiaStatusMonitorVO> searchStatusMonitor(AsiaStatusMonitorVO inputVo) throws EventException {
		String[] rhqCdArr = null;
		String[] stsCdArr = null;
		String[] cntCdArr = null;
		String[] costTrfNoArr = null;
		String[] ihcTrfNoArr = null;
		String rhqCd = "";
		String stsCd = "";
		String cntCd = "";
		String costTrfNo = "";
		String ihcTrfNo = "";
		
		try {
			//RHQ Office
			rhqCdArr = inputVo.getComboRhq().split(",");
			for( int idx=0; idx<rhqCdArr.length; idx++ ){
				if( idx == 0 && !rhqCdArr[idx].equals("") ){
					rhqCd = "'" + rhqCdArr[idx] + "'";
				} else if( idx > 0 ){
					rhqCd = rhqCd + ",'" + rhqCdArr[idx] + "'";
				}
			}
			inputVo.setComboRhq(rhqCd);
			
			//Status
			stsCdArr = inputVo.getComboSts().split(",");
			for( int idx=0; idx<stsCdArr.length; idx++ ){
				if( idx == 0 && !stsCdArr[idx].equals("") ){
					stsCd = "'" + stsCdArr[idx] + "'";
				} else if( idx > 0 ){
					stsCd = stsCd + ",'" + stsCdArr[idx] + "'";
				}
			}
			inputVo.setComboSts(stsCd);
			
			//Country Code
			cntCdArr = inputVo.getCntCd().split(",");
			for( int idx=0; idx<cntCdArr.length; idx++ ){
				if( idx == 0 && !cntCdArr[idx].equals("") ){
					cntCd = "'" + cntCdArr[idx] + "'";
				} else if( idx > 0 ){
					cntCd = cntCd + ",'" + cntCdArr[idx] + "'";
				}
			}
			inputVo.setCntCd(cntCd);
			
			//Cost Tariff No
			costTrfNoArr = inputVo.getCostTrfNo().split(",");
			for( int idx=0; idx<costTrfNoArr.length; idx++ ){
				if( idx == 0 && !costTrfNoArr[idx].equals("") ){
					costTrfNo = "'" + costTrfNoArr[idx] + "'";
				} else if( idx > 0 ){
					costTrfNo = costTrfNo + ",'" + costTrfNoArr[idx] + "'";
				}
			}
			inputVo.setCostTrfNo(costTrfNo);
			
			//Guideline Tariff No
			ihcTrfNoArr = inputVo.getIhcTrfNo().split(",");
			for( int idx=0; idx<ihcTrfNoArr.length; idx++ ){
				if( idx == 0 && !ihcTrfNoArr[idx].equals("") ){
					ihcTrfNo = "'" + ihcTrfNoArr[idx] + "'";
				} else if( idx > 0 ){
					ihcTrfNo = ihcTrfNo + ",'" + ihcTrfNoArr[idx] + "'";
				}
			}
			inputVo.setIhcTrfNo(ihcTrfNo);
			
			return dbDao.searchStatusMonitor(inputVo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * SHQ Office 판단 조회<br>
	 * 
	 * @param usrOfcCd
	 * @return
	 * @throws EventException
	 */
	public String searchShqOfcFlg(String usrOfcCd) throws EventException {
		try {
			String cnt = dbDao.searchShqOfcFlg(usrOfcCd);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param asiaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlnadCostInquiryVO> searchInlnadCostInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostInquiry(asiaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Reefer - Retrieve<br>
	 * 
	 * @param asiaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlnadCostInquiryVO> searchInlnadCostRefInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostRefInquiry(asiaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param asiaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostSpeInquiry(asiaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param asiaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaInlandCostConditionVO.setTrspCrrModCd(asiaInlandCostConditionVO.getExcelTrspCrrModCd());
			asiaInlandCostConditionVO.setIoBndCd(asiaInlandCostConditionVO.getExcelIoBndCd());
			asiaInlandCostConditionVO.setRcvDeTermCd(asiaInlandCostConditionVO.getExcelRcvDeTermCd());
			asiaInlandCostConditionVO.setCostFactorCd(asiaInlandCostConditionVO.getExcelCostFactorCd());
			asiaInlandCostConditionVO.setSysSrcCd(asiaInlandCostConditionVO.getExcelSysSrcCd());
			asiaInlandCostConditionVO.setAdjustmentCd(asiaInlandCostConditionVO.getExcelAdjustmentCd());
			asiaInlandCostConditionVO.setEffToDt(asiaInlandCostConditionVO.getExcelEffToDt());
			asiaInlandCostConditionVO.setLocNodCd(asiaInlandCostConditionVO.getExcelLocNodCd());
			asiaInlandCostConditionVO.setHubNodCd(asiaInlandCostConditionVO.getExcelHubNodCd());
			asiaInlandCostConditionVO.setPortNodCd(asiaInlandCostConditionVO.getExcelPortNodCd());
			asiaInlandCostConditionVO.setCostTrfNo(asiaInlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostInquiryExcel(asiaInlandCostConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**
	 * @return
	 */
	public String[] getDryColumns() {
		String[] titleField = new String[62];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	public String[] getDryTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[63];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "R/D Term";
			title[j++] = "C";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "Total Cost";
			title[j++] = "Total Cost";
			title[j++] = "LOC Group";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 20'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Full Trans Cost 40'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "1st Link";
			title[j++] = "1st Link";
			title[j++] = "Com-bined";
			title[j++] = "2nd Link";
			title[j++] = "2nd Link";
			title[j++] = "OLD AGMT";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "R/D Term";
			title[j++] = "C";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "LOC Group";
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS2";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS4";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_MTY2";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_MTY4";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TMNL2";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TMNL4";
			title[j++] = "Total";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "Com-bined";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "OLD AGMT";
			title[j++] = "Time";
			title[j++] = "User";
			title[j++] = "Office";
			title[j++] = "Time";
			title[j++] = "User";
			title[j++] = "Office";
		}
		
		return title;
	}
	
	/**
	 * Inland Cost Inquiry tab Reefer - Down Excel without Displaying<br>
	 * 
     * @param asiaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getRefRowSet(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaInlandCostConditionVO.setTrspCrrModCd(asiaInlandCostConditionVO.getExcelTrspCrrModCd());
			asiaInlandCostConditionVO.setIoBndCd(asiaInlandCostConditionVO.getExcelIoBndCd());
			asiaInlandCostConditionVO.setRcvDeTermCd(asiaInlandCostConditionVO.getExcelRcvDeTermCd());
			asiaInlandCostConditionVO.setCostFactorCd(asiaInlandCostConditionVO.getExcelCostFactorCd());
			asiaInlandCostConditionVO.setSysSrcCd(asiaInlandCostConditionVO.getExcelSysSrcCd());
			asiaInlandCostConditionVO.setAdjustmentCd(asiaInlandCostConditionVO.getExcelAdjustmentCd());
			asiaInlandCostConditionVO.setEffToDt(asiaInlandCostConditionVO.getExcelEffToDt());
			asiaInlandCostConditionVO.setLocNodCd(asiaInlandCostConditionVO.getExcelLocNodCd());
			asiaInlandCostConditionVO.setHubNodCd(asiaInlandCostConditionVO.getExcelHubNodCd());
			asiaInlandCostConditionVO.setPortNodCd(asiaInlandCostConditionVO.getExcelPortNodCd());
			asiaInlandCostConditionVO.setCostTrfNo(asiaInlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostRefInquiryExcel(asiaInlandCostConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**
	 * @return
	 */
	public String[] getRefColumns() {
		String[] titleField = new String[15];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	public String[] getRefTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[15];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "R/D Term";
			title[j++] = "C";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "RF total cost";
			title[j++] = "RF total cost";
		}else if(headCnt == 2){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "R/D Term";
			title[j++] = "C";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
		}
		
		return title;
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying<br>
	 * 
     * @param asiaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getSpeRowSet(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaInlandCostConditionVO.setTrspCrrModCd(asiaInlandCostConditionVO.getExcelTrspCrrModCd());
			asiaInlandCostConditionVO.setIoBndCd(asiaInlandCostConditionVO.getExcelIoBndCd());
			asiaInlandCostConditionVO.setRcvDeTermCd(asiaInlandCostConditionVO.getExcelRcvDeTermCd());
			asiaInlandCostConditionVO.setCostFactorCd(asiaInlandCostConditionVO.getExcelCostFactorCd());
			asiaInlandCostConditionVO.setSysSrcCd(asiaInlandCostConditionVO.getExcelSysSrcCd());
			asiaInlandCostConditionVO.setAdjustmentCd(asiaInlandCostConditionVO.getExcelAdjustmentCd());
			asiaInlandCostConditionVO.setEffToDt(asiaInlandCostConditionVO.getExcelEffToDt());
			asiaInlandCostConditionVO.setLocNodCd(asiaInlandCostConditionVO.getExcelLocNodCd());
			asiaInlandCostConditionVO.setHubNodCd(asiaInlandCostConditionVO.getExcelHubNodCd());
			asiaInlandCostConditionVO.setPortNodCd(asiaInlandCostConditionVO.getExcelPortNodCd());
			asiaInlandCostConditionVO.setCostTrfNo(asiaInlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostSpeInquiryExcel(asiaInlandCostConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**
	 * @return
	 */
	public String[] getSpeColumns() {
		String[] titleField = new String[21];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	public String[] getSpeTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[25];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "EQ Size";
			title[j++] = "Reefer";
			title[j++] = "Reefer";
			title[j++] = "Reefer";
			title[j++] = "DG";
			title[j++] = "DG";
			title[j++] = "DG";
			title[j++] = "Overweight (Ton)";
			title[j++] = "Overweight (Ton)";
			title[j++] = "Overweight (Ton)";
			title[j++] = "Overweight (Ton)";
			title[j++] = "Overweight (Ton)";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Trans Mode";
			title[j++] = "CURR";
			title[j++] = "EQ Size";
			title[j++] = "SVC";
			title[j++] = "Fixed";
			title[j++] = "%";
			title[j++] = "SVC";
			title[j++] = "Fixed";
			title[j++] = "%";
			title[j++] = "SVC";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Fixed";
			title[j++] = "%";
			title[j++] = "Time";
			title[j++] = "User";
			title[j++] = "Office";
			title[j++] = "Time";
			title[j++] = "User";
			title[j++] = "Office";
		}
		
		return title;
	}
	
	/**
	 * @param trfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyInlndCostTrfNo(String trfNo) throws EventException{
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyInlndCostTrfNo(trfNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;
	}
}