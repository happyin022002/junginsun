/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostManageBCImpl.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.bluecast.util.DuplicateKeyException;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration.InlandCostManageDBDAO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostDetailVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.RHQComboVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchInlandCostAccountVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchStatusMonitorVO;
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
 * @author Kim Jong Ock
 * @see ESD_TRS_3001EventResponse,CostManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InlandCostManageBCImpl extends BasicCommandSupport implements InlandCostManageBC {
	
	// Database Access Object
	private transient InlandCostManageDBDAO dbDao = null;

	/**
	 * CostManageBCImpl 객체 생성<br>
	 * InlandCostManageDBDAO를 생성한다.<br>
	 */
	public InlandCostManageBCImpl() {
		dbDao = new InlandCostManageDBDAO();
	}

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostVO> searchInlandCost(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCost(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostSpecialCargoVO> searchInlandCostSpecialCargo(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlandCostSpecialCargo(inlandCostConditionVO);
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
	public List<InlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws EventException {
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
	public InlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws EventException {
		try {
			//return dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			InlandCostTariffInfoVO inlandCostTariffInfoVO = dbDao.searchInlandCostTariffInfo(inCostTrfNo);
			return inlandCostTariffInfoVO;			
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
	public void multiInlandCost(InlandCostVO[] inlandCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<InlandCostVO> updateVoList = new ArrayList<InlandCostVO>();

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
	public void multiInlandCostHdr(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void confirmInlandCostPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void confirmInlandCost(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmInlandCost(inlandCostConditionVO, account);
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
	public void modifyInlandCostMgtCfmCxl(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyInlandCostMgtCfmCxl(inlandCostConditionVO, account);
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
	public void modifyInlandCostMgtCfmCxlPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException {
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
	public void multiInlandCostSpecialCargo(InlandCostSpecialCargoVO[] inlandCostSpecialCargoVOs, SignOnUserAccount account) throws EventException {

		try {
			List<InlandCostSpecialCargoVO> insertVoList = new ArrayList<InlandCostSpecialCargoVO>();
			List<InlandCostSpecialCargoVO> deleteVoList = new ArrayList<InlandCostSpecialCargoVO>();
			
			for ( int i=0; i<inlandCostSpecialCargoVOs .length; i++ ) {

				if ( !inlandCostSpecialCargoVOs[i].getIbflag().equals("D")){
					inlandCostSpecialCargoVOs[i].setCreUsrId(account.getUsr_id());
					inlandCostSpecialCargoVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(inlandCostSpecialCargoVOs[i]);
				}
				
				deleteVoList.add(inlandCostSpecialCargoVOs[i]);
			} 

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeInlandCostSpecialCargoS(deleteVoList);
			}			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInlandCostSpecialCargoS(insertVoList);
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
	public List<InlandCostDetailVO> searchInlandCostDetail(InlandCostConditionVO inlandCostConditionVO) throws EventException {
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
	public void multiInlandCostDetailSelect(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<InlandCostDetailVO> updateVoList = new ArrayList<InlandCostDetailVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				if ( inlandCostDetailVOs[i].getIbflag().equals("U")){
					inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
					if ( inlandCostDetailVOs[i].getCostSelRoutFlg().equals("0")){
						inlandCostDetailVOs[i].setCostSelRoutFlg("N"); 
					}else{
						inlandCostDetailVOs[i].setCostSelRoutFlg("Y");
					}
					updateVoList.add(inlandCostDetailVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiInlandCostDetailSelect(updateVoList);
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
	public String searchInlandCostDetailDeleteCheck(InlandCostDetailVO[] inlandCostDetailVOs) throws EventException {
		try {
			String cnt = "";
			List<InlandCostDetailVO> updateVoList = new ArrayList<InlandCostDetailVO>();

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
	public void multiInlandCostDetailDelete(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<InlandCostDetailVO> updateVoList = new ArrayList<InlandCostDetailVO>();

			for ( int i=0; i<inlandCostDetailVOs .length; i++ ) {
				inlandCostDetailVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(inlandCostDetailVOs[i]);
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiInlandCostDetailDelete(updateVoList);
				dbDao.multiInlandCostDetail1stSelect(updateVoList);
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
	public void multiInlandCostDetailRest(InlandCostDetailVO[] inlandCostDetailVOs, SignOnUserAccount account) throws EventException {

		try {
			List<InlandCostDetailVO> updateVoList = new ArrayList<InlandCostDetailVO>();

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
	public List<SearchInlandCostAccountVO> searchInlandCostAccount(SearchInlandCostAccountVO inputVo) throws EventException {
		try {
			return dbDao.searchInlandCostAccount(inputVo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<RHQComboVO> searchRHQCombo() throws EventException {
		try {
			return dbDao.searchRHQCombo();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<CntDefaultCurrVO> searchCntDefaultCurr(InlandCostConditionVO inlandCostConditionVO) throws EventException {

		String[] rhqCdArr = null;	
		String[] cntCdArr = null;
		String[] currCdArr = null;
		String rhqCd = "";
		String cntCd = "";
		String currCd = "";

		try {

			rhqCdArr = inlandCostConditionVO.getRhqCd().split(",");
			for( int idx=0; idx<rhqCdArr.length; idx++ ){
				if( idx == 0 && !rhqCdArr[idx].equals("") ){
					rhqCd = "'" + rhqCdArr[idx] + "'";
				} else if( idx > 0 ){
					rhqCd = rhqCd + ",'" + rhqCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setRhqCd(rhqCd);

			cntCdArr = inlandCostConditionVO.getCntCd().split(",");
			for( int idx=0; idx<cntCdArr.length; idx++ ){
				if( idx == 0 && !cntCdArr[idx].equals("") ){
					cntCd = "'" + cntCdArr[idx] + "'";
				} else if( idx > 0 ){
					cntCd = cntCd + ",'" + cntCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setCntCd(cntCd);
			
			currCdArr = inlandCostConditionVO.getCurrCd().split(",");
			for( int idx=0; idx<currCdArr.length; idx++ ){
				if( idx == 0 && !currCdArr[idx].equals("") ){
					currCd = "'" + currCdArr[idx] + "'";
				} else if( idx > 0 ){
					currCd = currCd + ",'" + currCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setCurrCd(currCd);
			
			return dbDao.searchCntDefaultCurr(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public CntInfoVO searchCntInfo(String cntCd) throws EventException {
		try {
			CntInfoVO cntInfoVO = dbDao.searchCntInfo(cntCd);
			return cntInfoVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Currency Name<br>
	 * 
	 * @param currCd
	 * @return
	 * @throws EventException
	 */
	public String searchCurrNm(String currCd) throws EventException {
		try {
			String curr_nm = dbDao.searchCurrNm(currCd);
			return curr_nm;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Save<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException {
		String errFlg = "";
		String dupFlg = "";
		
		try {
			List<CntDefaultCurrVO> insertVoList = new ArrayList<CntDefaultCurrVO>();
			List<CntDefaultCurrVO> updateVoList = new ArrayList<CntDefaultCurrVO>();
			List<CntDefaultCurrVO> deleteVoList = new ArrayList<CntDefaultCurrVO>();

			for ( int i=0; i<cntDefaultCurrVOs .length; i++ ) {
				if ( cntDefaultCurrVOs[i].getIbflag().equals("I")){
					cntDefaultCurrVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cntDefaultCurrVOs[i]);
				} else if ( cntDefaultCurrVOs[i].getIbflag().equals("U")){
					cntDefaultCurrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cntDefaultCurrVOs[i]);
				} else if ( cntDefaultCurrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cntDefaultCurrVOs[i]);
				}				
			} 

			if ( insertVoList.size() > 0 ) {
				//Checking Duplication
				for( int idx=0; idx<insertVoList.size(); idx++ ){
					dupFlg = dbDao.searchDupChkCostTrfCurr(insertVoList.get(idx));
					if( "Y".equals(dupFlg) ){
						errFlg = "Y";
					}
				}
				if( !"Y".equals(errFlg) ){
					dbDao.addCntDefaultCurrS(insertVoList);
				} else{
					throw new DuplicateKeyException(new ErrorHandler("COM12115",new String[]{"Country Code"}).getMessage());
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntDefaultCurrS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntDefaultCurrS(deleteVoList);
			}
			
		} catch(DuplicateKeyException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12115",new String[]{"Country Code"}).getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException {

		try {
			List<CntDefaultCurrVO> deleteVoList = new ArrayList<CntDefaultCurrVO>();

			for ( int i=0; i<cntDefaultCurrVOs .length; i++ ) {
				if ( cntDefaultCurrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cntDefaultCurrVOs[i]);
				}				
			} 
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntDefaultCurrS(deleteVoList);
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
	 * Default Currency Creation - Currency Code 확인<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCurrencyCode(String currCd) throws EventException {
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyCurrencyCode(currCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;		
	}
	
	/**
	 * @param inputVo
	 * @return
	 * @throws EventException
	 */
	public List<SearchStatusMonitorVO> searchStatusMonitor(SearchStatusMonitorVO inputVo) throws EventException {
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
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlnadCostInquiryVO> searchInlnadCostInquiry(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostInquiry(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		try {
			return dbDao.searchInlnadCostSpeInquiry(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param inlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			inlandCostConditionVO.setDateFlg(inlandCostConditionVO.getExcelDateFlg());
			inlandCostConditionVO.setTrspCrrModCd(inlandCostConditionVO.getExcelTrspCrrModCd());
			inlandCostConditionVO.setIoBndCd(inlandCostConditionVO.getExcelIoBndCd());
			inlandCostConditionVO.setRcvDeTermCd(inlandCostConditionVO.getExcelRcvDeTermCd());
			inlandCostConditionVO.setCostFactorCd(inlandCostConditionVO.getExcelCostFactorCd());
			inlandCostConditionVO.setSysSrcCd(inlandCostConditionVO.getExcelSysSrcCd());
			inlandCostConditionVO.setAdjustmentCd(inlandCostConditionVO.getExcelAdjustmentCd());
			inlandCostConditionVO.setFromDt(inlandCostConditionVO.getExcelFromDt());
			inlandCostConditionVO.setToDt(inlandCostConditionVO.getExcelToDt());
			inlandCostConditionVO.setEffToDt(inlandCostConditionVO.getExcelEffToDt());
			inlandCostConditionVO.setLocNodCd(inlandCostConditionVO.getExcelLocNodCd());
			inlandCostConditionVO.setHubNodCd(inlandCostConditionVO.getExcelHubNodCd());
			inlandCostConditionVO.setPortNodCd(inlandCostConditionVO.getExcelPortNodCd());
			inlandCostConditionVO.setCostTrfNo(inlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostInquiryExcel(inlandCostConditionVO);
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
		String[] title = new String[62];
		
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
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying<br>
	 * 
     * @param inlandCostConditionVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getSpeRowSet(InlandCostConditionVO inlandCostConditionVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			inlandCostConditionVO.setDateFlg(inlandCostConditionVO.getExcelDateFlg());
			inlandCostConditionVO.setTrspCrrModCd(inlandCostConditionVO.getExcelTrspCrrModCd());
			inlandCostConditionVO.setIoBndCd(inlandCostConditionVO.getExcelIoBndCd());
			inlandCostConditionVO.setRcvDeTermCd(inlandCostConditionVO.getExcelRcvDeTermCd());
			inlandCostConditionVO.setCostFactorCd(inlandCostConditionVO.getExcelCostFactorCd());
			inlandCostConditionVO.setSysSrcCd(inlandCostConditionVO.getExcelSysSrcCd());
			inlandCostConditionVO.setAdjustmentCd(inlandCostConditionVO.getExcelAdjustmentCd());
			inlandCostConditionVO.setFromDt(inlandCostConditionVO.getExcelFromDt());
			inlandCostConditionVO.setToDt(inlandCostConditionVO.getExcelToDt());
			inlandCostConditionVO.setEffToDt(inlandCostConditionVO.getExcelEffToDt());
			inlandCostConditionVO.setLocNodCd(inlandCostConditionVO.getExcelLocNodCd());
			inlandCostConditionVO.setHubNodCd(inlandCostConditionVO.getExcelHubNodCd());
			inlandCostConditionVO.setPortNodCd(inlandCostConditionVO.getExcelPortNodCd());
			inlandCostConditionVO.setCostTrfNo(inlandCostConditionVO.getExcelCostTrfNo());
			
			return rowSet=dbDao.searchInlnadCostSpeInquiryExcel(inlandCostConditionVO);
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
		String[] title = new String[24];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Country";
			title[j++] = "BND";
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "Trans Mode";
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