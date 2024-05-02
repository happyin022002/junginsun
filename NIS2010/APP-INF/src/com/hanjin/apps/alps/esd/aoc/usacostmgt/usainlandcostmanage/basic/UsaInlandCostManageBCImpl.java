/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageBCImpl.java
*@FileTitle : Inland Cost Manage(NYC)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2013.09.24 서미진 [CHM-201326830] Batch RF tab 관련 화면로직 보완
* 2014.01.16 서미진 [CHM-201428500] 미주지역 Cost Table 생성시 SCTLAL 추가건
* 2014.03.03 서미진 [CHM-201429137] Toll Fee 금액이 Truck total cost에 합산되도록 계산 로직 변경
* 2014.03.07 서미진 [CHM-201429273] Confirmed cost만 보도록 수정 (Date 조건 삭제, Incl. Unconfirmed Cost 조건 삭제)
* 2014.03.17 서미진 [CHM-201429382] 1. DG, Overweight adjust한 data만 update 한다. 
									2. Confirm시 adjust 하지 않는 DG, Overweight transmode를 삭제한다.
									3. Confirm cancel시 삭제된 DG, Overweight transmode를 넣어준다.
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration.UsaInlandCostManageDBDAO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaIpiPortVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaStatusMonitorVO;
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
public class UsaInlandCostManageBCImpl extends BasicCommandSupport implements UsaInlandCostManageBC {
	
	// Database Access Object
	private transient UsaInlandCostManageDBDAO dbDao = null;

	/**
	 * CostManageBCImpl 객체 생성<br>
	 * InlandCostManageDBDAO를 생성한다.<br>
	 */
	public UsaInlandCostManageBCImpl() {
		dbDao = new UsaInlandCostManageDBDAO();
	}

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlandCostVO> searchInlandCost(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException {
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
	public List<UsaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException {
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
	public List<UsaInlandCostVO> searchInlandCostReefer(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException {
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
	public List<UsaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException {
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
	public UsaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException {
		try {
			//return dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			UsaInlandCostTariffInfoVO usaInlandCostTariffInfoVO = dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			return usaInlandCostTariffInfoVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<UsaIpiPortVO> searchUsaIpiPort(String inCostTrfNo) throws EventException {
		try {
			return dbDao.searchUsaIpiPort(inCostTrfNo);
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
	public void multiInlandCost(UsaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<UsaInlandCostVO> updateVoList = new ArrayList<UsaInlandCostVO>();

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
	public void multiInlandCostHdr(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void multiInlandCostReefer(UsaInlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException {
		try {
			List<UsaInlandCostVO> insVoList = new ArrayList<UsaInlandCostVO>();
			List<UsaInlandCostVO> updVoList = new ArrayList<UsaInlandCostVO>();
			List<UsaInlandCostVO> delVoList = new ArrayList<UsaInlandCostVO>();

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
	 * Inland Cost Management - confirmInlandCostPreVer<br>
	 * 
	 * @param inlandCostConditionVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmInlandCostPreVer(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void confirmInlandCost(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void modifyInlandCostMgtCfmCxl(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void modifyInlandCostMgtCfmCxlPreVer(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void multiInlandCostSpecialCargo(UsaInlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<UsaInlandCostSpecialCargoVO> updateVoList = new ArrayList<UsaInlandCostSpecialCargoVO>();
			
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
	public List<UsaInlandCostDetailVO> searchInlandCostDetail(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException {
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
	public void multiInlandCostDetailSelect(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<UsaInlandCostDetailVO> updateVoList = new ArrayList<UsaInlandCostDetailVO>();
			List<UsaInlandCostVO> delRfVoList = new ArrayList<UsaInlandCostVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				if ( inlandCostDetailVOs[i].getIbflag().equals("U")){
					inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
					if ( inlandCostDetailVOs[i].getCostSelRoutFlg().equals("0")){
						inlandCostDetailVOs[i].setCostSelRoutFlg("N");
						
						UsaInlandCostVO inlandCostVO = new UsaInlandCostVO();
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
	public String searchInlandCostDetailDeleteCheck(UsaInlandCostDetailVO[] inlandCostDetailVOs) throws EventException {
		try {
			String cnt = "";
			List<UsaInlandCostDetailVO> updateVoList = new ArrayList<UsaInlandCostDetailVO>();

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
	public void multiInlandCostDetailDelete(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<UsaInlandCostDetailVO> updateVoList = new ArrayList<UsaInlandCostDetailVO>();
			List<UsaInlandCostVO> delRfVoList = new ArrayList<UsaInlandCostVO>();

			for( int i=0; i<inlandCostDetailVOs .length; i++ ){
				inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(inlandCostDetailVOs[i]);
				
				UsaInlandCostVO inlandCostVO = new UsaInlandCostVO();
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
	public void multiInlandCostDetailRest(UsaInlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<UsaInlandCostDetailVO> updateVoList = new ArrayList<UsaInlandCostDetailVO>();

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
	public List<UsaInlandCostAccountVO> searchInlandCostAccount(UsaInlandCostAccountVO inputVo) throws EventException {
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
	public List<UsaStatusMonitorVO> searchStatusMonitor(UsaStatusMonitorVO inputVo) throws EventException {
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
	 * @param usaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlnadCostInquiryVO> searchInlnadCostInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostInquiry(usaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Reefer - Retrieve<br>
	 * 
	 * @param usaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlnadCostInquiryVO> searchInlnadCostRefInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostRefInquiry(usaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param usaInlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<UsaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostSpeInquiry(usaInlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param usaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			usaInlandCostConditionVO.setTrspCrrModCd(usaInlandCostConditionVO.getExcelTrspCrrModCd());
			usaInlandCostConditionVO.setIoBndCd(usaInlandCostConditionVO.getExcelIoBndCd());
			usaInlandCostConditionVO.setRcvDeTermCd(usaInlandCostConditionVO.getExcelRcvDeTermCd());
			usaInlandCostConditionVO.setCostFactorCd(usaInlandCostConditionVO.getExcelCostFactorCd());
			usaInlandCostConditionVO.setSysSrcCd(usaInlandCostConditionVO.getExcelSysSrcCd());
			usaInlandCostConditionVO.setAdjustmentCd(usaInlandCostConditionVO.getExcelAdjustmentCd());
			usaInlandCostConditionVO.setEffToDt(usaInlandCostConditionVO.getExcelEffToDt());
			usaInlandCostConditionVO.setLocNodCd(usaInlandCostConditionVO.getExcelLocNodCd());
			usaInlandCostConditionVO.setHubNodCd(usaInlandCostConditionVO.getExcelHubNodCd());
			usaInlandCostConditionVO.setPortNodCd(usaInlandCostConditionVO.getExcelPortNodCd());
			usaInlandCostConditionVO.setCostTrfNo(usaInlandCostConditionVO.getExcelCostTrfNo());
			usaInlandCostConditionVO.setSvcModCd(usaInlandCostConditionVO.getExcelSvcModCd());
			
			return rowSet=dbDao.searchInlnadCostInquiryExcel(usaInlandCostConditionVO);
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
		String[] titleField = new String[114];

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
		String[] title = new String[116];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Empty PU/RTN";
			title[j++] = "R/D Term";
			title[j++] = "Trans Mode";
			title[j++] = "Local IPI";
			title[j++] = "CURR";
			title[j++] = "Total Cost";
			title[j++] = "Total Cost";
			title[j++] = "Rail Cost";
			title[j++] = "Rail Cost";
			title[j++] = "Truck Cost";
			title[j++] = "Truck Cost";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck Toll Fee 20'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck Toll Fee 40'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
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
			title[j++] = "Com-bined";
			title[j++] = "3rd Link";
			title[j++] = "3rd Link";
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
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Empty PU/RTN";
			title[j++] = "R/D Term";
			title[j++] = "Trans Mode";
			title[j++] = "Local IPI";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Amount";			
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Amount";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "Com-bined";
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
     * @param usaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getRefRowSet(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			usaInlandCostConditionVO.setTrspCrrModCd(usaInlandCostConditionVO.getExcelTrspCrrModCd());
			usaInlandCostConditionVO.setIoBndCd(usaInlandCostConditionVO.getExcelIoBndCd());
			usaInlandCostConditionVO.setRcvDeTermCd(usaInlandCostConditionVO.getExcelRcvDeTermCd());
			usaInlandCostConditionVO.setCostFactorCd(usaInlandCostConditionVO.getExcelCostFactorCd());
			usaInlandCostConditionVO.setSysSrcCd(usaInlandCostConditionVO.getExcelSysSrcCd());
			usaInlandCostConditionVO.setAdjustmentCd(usaInlandCostConditionVO.getExcelAdjustmentCd());
			usaInlandCostConditionVO.setEffToDt(usaInlandCostConditionVO.getExcelEffToDt());
			usaInlandCostConditionVO.setLocNodCd(usaInlandCostConditionVO.getExcelLocNodCd());
			usaInlandCostConditionVO.setHubNodCd(usaInlandCostConditionVO.getExcelHubNodCd());
			usaInlandCostConditionVO.setPortNodCd(usaInlandCostConditionVO.getExcelPortNodCd());
			usaInlandCostConditionVO.setCostTrfNo(usaInlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostRefInquiryExcel(usaInlandCostConditionVO);
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
		String[] titleField = new String[114];

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
		String[] title = new String[116];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Empty PU/RTN";
			title[j++] = "R/D Term";
			title[j++] = "Trans Mode";
			title[j++] = "Local IPI";
			title[j++] = "CURR";
			title[j++] = "Total Cost(Reefer)";
			title[j++] = "Total Cost(Reefer)";
			title[j++] = "Total Cost";
			title[j++] = "Total Cost";
			title[j++] = "Rail Cost";
			title[j++] = "Rail Cost";
			title[j++] = "Truck Cost";
			title[j++] = "Truck Cost";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail Basic Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail FSC Cost 20'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail Basic Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Rail FSC Cost 40'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck Basic Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck FSC Cost 20'";
			title[j++] = "Full Truck Toll Fee 20'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck Basic Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck FSC Cost 40'";
			title[j++] = "Full Truck Toll Fee 40'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 20'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
			title[j++] = "Domestic Cost 40'";
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
			title[j++] = "Com-bined";
			title[j++] = "3rd Link";
			title[j++] = "3rd Link";
			title[j++] = "OLD AGMT";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Port-LOC";
			title[j++] = "Port";
			title[j++] = "Hub";
			title[j++] = "LOC";
			title[j++] = "Empty PU/RTN";
			title[j++] = "R/D Term";
			title[j++] = "Trans Mode";
			title[j++] = "Local IPI";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Amount";			
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "MTY YD(AGMT)";
			title[j++] = "MTY Diff";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Rate Type";
			title[j++] = "System Amount";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "Adjustment";
			title[j++] = "Total";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "Com-bined";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "Com-bined";
			title[j++] = "S/P Code";
			title[j++] = "S/P Name";
			title[j++] = "OLD AGMT";
			title[j++] = "Time";
			title[j++] = "User";
			title[j++] = "Time";
			title[j++] = "User";
		}
		
		return title;
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying<br>
	 * 
     * @param usaInlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getSpeRowSet(UsaInlandCostConditionVO usaInlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			usaInlandCostConditionVO.setTrspCrrModCd(usaInlandCostConditionVO.getExcelTrspCrrModCd());
			usaInlandCostConditionVO.setIoBndCd(usaInlandCostConditionVO.getExcelIoBndCd());
			usaInlandCostConditionVO.setRcvDeTermCd(usaInlandCostConditionVO.getExcelRcvDeTermCd());
			usaInlandCostConditionVO.setCostFactorCd(usaInlandCostConditionVO.getExcelCostFactorCd());
			usaInlandCostConditionVO.setSysSrcCd(usaInlandCostConditionVO.getExcelSysSrcCd());
			usaInlandCostConditionVO.setAdjustmentCd(usaInlandCostConditionVO.getExcelAdjustmentCd());
			usaInlandCostConditionVO.setEffToDt(usaInlandCostConditionVO.getExcelEffToDt());
			usaInlandCostConditionVO.setLocNodCd(usaInlandCostConditionVO.getExcelLocNodCd());
			usaInlandCostConditionVO.setHubNodCd(usaInlandCostConditionVO.getExcelHubNodCd());
			usaInlandCostConditionVO.setPortNodCd(usaInlandCostConditionVO.getExcelPortNodCd());
			usaInlandCostConditionVO.setCostTrfNo(usaInlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostSpeInquiryExcel(usaInlandCostConditionVO);
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
		String[] titleField = new String[22];

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
		String[] title = new String[22];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Trans Mode";
			title[j++] = "EQ Size";
			title[j++] = "CURR";
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
			title[j++] = "EQ Size";
			title[j++] = "CURR";
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
	
	/**
	 * ESD_AOC_3302 : Confirm
	 * Confirm : verify service mode (0 or minus value)<br>
	 * 
	 * @param UsaInlandCostConditionVO inlandCostConditionVO
	 * @return String verify_dry
	 * @throws EventException
	 */
	public String verifyServiceMode(UsaInlandCostConditionVO inlandCostConditionVO) throws EventException{
		String verify_dry = "";
		List<UsaInlandCostVO> list = null;
		try {
			list = dbDao.verifyServiceMode(inlandCostConditionVO);		
			if(list.size() > 0){
				for(int i=0; i< list.size(); i++){
					verify_dry = verify_dry.concat(list.get(i).getLoclIpiSvcModNm());	
					if(i != list.size()-1){
						verify_dry = verify_dry.concat(",");
					}
				}
			}			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return verify_dry;
	}
}