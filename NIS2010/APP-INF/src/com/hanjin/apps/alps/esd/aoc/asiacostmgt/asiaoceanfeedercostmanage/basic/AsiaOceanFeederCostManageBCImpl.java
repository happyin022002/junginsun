/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageBCImpl.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration.AsiaOceanFeederCostManageDBDAO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederReeferCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-OceanFeederCostManage Business Logic Basic Command implementation<br>
 * - ALPS-OceanFeederCostManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EventResponse,OceanFeederCostManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AsiaOceanFeederCostManageBCImpl extends BasicCommandSupport implements AsiaOceanFeederCostManageBC {
	
	// Database Access Object
	private transient AsiaOceanFeederCostManageDBDAO dbDao = null;

	/**
	 * OceanFeederCostManageBCImpl 객체 생성<br>
	 * OceanFeederCostManageDBDAO를 생성한다.<br>
	 */
	public AsiaOceanFeederCostManageBCImpl() {
		dbDao = new AsiaOceanFeederCostManageDBDAO();
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostVO> searchFeederCost(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			return dbDao.searchFeederCost(inputVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederDgCostVO> searchFeederDgCost(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			return dbDao.searchFeederDgCost(inputVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederReeferCostVO> searchFeederRfCost(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			return dbDao.searchFeederRfCost(inputVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostTariffNoVO> searchFeederCostTariffNo(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			return dbDao.searchFeederCostTariffNo(inputVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public AsiaFeederCostTariffInfoVO searchFeederCostTariffInfo(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			AsiaFeederCostTariffInfoVO asiaFeederCostTariffInfoVO = dbDao.searchFeederCostTariffInfo(inputVO);
			return asiaFeederCostTariffInfoVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param feederCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCost(AsiaFeederCostVO[] feederCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaFeederCostVO> updateVoList = new ArrayList<AsiaFeederCostVO>();

			for ( int i=0; i<feederCostVOs .length; i++ ) {
				if ( feederCostVOs[i].getIbflag().equals("U")){
					feederCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(feederCostVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiFeederCost(updateVoList);
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
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param searchFeederDgCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederDgCost(AsiaFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaFeederDgCostVO> updateVoList = new ArrayList<AsiaFeederDgCostVO>();

			for ( int i=0; i<searchFeederDgCostVOs .length; i++ ) {
				if ( searchFeederDgCostVOs[i].getIbflag().equals("U")){
					searchFeederDgCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchFeederDgCostVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiFeederDgCost(updateVoList);
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
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param searchFeederReeferCostVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederRfCost(AsiaFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaFeederReeferCostVO> updateVoList = new ArrayList<AsiaFeederReeferCostVO>();

			for ( int i=0; i<searchFeederReeferCostVOs .length; i++ ) {
				if ( searchFeederReeferCostVOs[i].getIbflag().equals("U")){
					searchFeederReeferCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchFeederReeferCostVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.multiFeederRfCost(updateVoList);
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
	 * Ocean Feeder Cost Detail - Delete<br>
	 * 
	 * @param inputVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeFdrTrfDtl(AsiaFeederCostVO[] inputVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AsiaFeederCostVO> deleteVoList = new ArrayList<AsiaFeederCostVO>();

			for ( int i=0; i<inputVOs .length; i++ ) {
				if ( inputVOs[i].getIbflag().equals("U")){
					inputVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(inputVOs[i]);
				}
			}
 
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFdrTrfDtl(deleteVoList);
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
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCostHdr(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.multiFeederCostHdr(inputVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostConfirm(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			String cnt = dbDao.verifyFeederCostConfirm(inputVO);
			return cnt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCostPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmFeederCostPreVer(inputVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCost<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCost(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmFeederCost(inputVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Ocean Feeder Cost Management - searchFeederCostGuidelineExist<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String searchFeederCostGuidelineExist(AsiaFeederMgtCondVO inputVO) throws EventException {
		try {
			String cnt = dbDao.searchFeederCostGuidelineExist(inputVO);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxl(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyFeederCostMgtCfmCxl(inputVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyFeederCostMgtCfmCxlPreVer(inputVO, account);
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
	public List<AsiaFeederCostAccountVO> searchOceanFeederCostAccount(AsiaFeederCostAccountVO inputVo) throws EventException {
		try {
			return dbDao.searchOceanFeederCostAccount(inputVo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostInquiryVO> searchFeederCostInquiry(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostInquiry(asiaFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostDGVO> searchFeederCostDG(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostDG(asiaFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AsiaFeederCostInquiryVO> searchFeederCostRF(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostRF(asiaFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param asiaFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaFeederCostCondVO.setDateFlg(asiaFeederCostCondVO.getExcelDateFlg());
			asiaFeederCostCondVO.setFromDt(asiaFeederCostCondVO.getExcelFromDt());
			asiaFeederCostCondVO.setToDt(asiaFeederCostCondVO.getExcelToDt());
			asiaFeederCostCondVO.setEffToDt(asiaFeederCostCondVO.getExcelEffToDt());
			asiaFeederCostCondVO.setCostTrfNo(asiaFeederCostCondVO.getExcelCostTrfNo());
			asiaFeederCostCondVO.setPctlIoBndCd(asiaFeederCostCondVO.getExcelPctlIoBndCd());
			asiaFeederCostCondVO.setFromNodCd(asiaFeederCostCondVO.getExcelFromNodCd());
			asiaFeederCostCondVO.setToNodCd(asiaFeederCostCondVO.getExcelToNodCd());
			asiaFeederCostCondVO.setCostFactorCd(asiaFeederCostCondVO.getExcelCostFactorCd());
			asiaFeederCostCondVO.setSysSrcCd(asiaFeederCostCondVO.getExcelSysSrcCd());
			asiaFeederCostCondVO.setAdjustmentCd(asiaFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostInquiryExcel(asiaFeederCostCondVO);
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
	@Override
	public String[] getDryColumns() {
		String[] titleField = new String[47];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	@Override
	public String[] getDryTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[50];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Pre/Post";
			title[j++] = "DIR";
			title[j++] = "Feeder Term";
			title[j++] = "Feeder Term";
			title[j++] = "CURR";
			title[j++] = "Total Cost";
			title[j++] = "Total Cost";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
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
			title[j++] = "Service Provider";
			title[j++] = "Service Provider";
			title[j++] = "OLD AGMT";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Pre/Post";
			title[j++] = "DIR";
			title[j++] = "RCV";
			title[j++] = "DEL";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS2";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS4";
			title[j++] = "Weight(AGMT)";
			title[j++] = "Total";
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
			title[j++] = "Code";
			title[j++] = "Name";
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
     * Ocean Feeder Cost Inquiry tab Special - Down Excel without Displaying<br>
     * 
     * @param asiaFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDGRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaFeederCostCondVO.setDateFlg(asiaFeederCostCondVO.getExcelDateFlg());
			asiaFeederCostCondVO.setFromDt(asiaFeederCostCondVO.getExcelFromDt());
			asiaFeederCostCondVO.setToDt(asiaFeederCostCondVO.getExcelToDt());
			asiaFeederCostCondVO.setEffToDt(asiaFeederCostCondVO.getExcelEffToDt());
			asiaFeederCostCondVO.setCostTrfNo(asiaFeederCostCondVO.getExcelCostTrfNo());
			asiaFeederCostCondVO.setPctlIoBndCd(asiaFeederCostCondVO.getExcelPctlIoBndCd());
			asiaFeederCostCondVO.setFromNodCd(asiaFeederCostCondVO.getExcelFromNodCd());
			asiaFeederCostCondVO.setToNodCd(asiaFeederCostCondVO.getExcelToNodCd());
			asiaFeederCostCondVO.setCostFactorCd(asiaFeederCostCondVO.getExcelCostFactorCd());
			asiaFeederCostCondVO.setSysSrcCd(asiaFeederCostCondVO.getExcelSysSrcCd());
			asiaFeederCostCondVO.setAdjustmentCd(asiaFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostDGExcel(asiaFeederCostCondVO);
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
	@Override
	public String[] getDGColumns() {
		String[] titleField = new String[56];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	@Override
	public String[] getDGTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[57];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Bnd";
			title[j++] = "DIR";
			title[j++] = "Feeder Term";
			title[j++] = "Feeder Term";
			title[j++] = "CURR";
			title[j++] = "Service Provider";
			title[j++] = "Service Provider";
			title[j++] = "OLD AGMT";
			title[j++] = "Dry Cost";
			title[j++] = "Dry Cost";
			title[j++] = "IMDG Class1";
			title[j++] = "IMDG Class1";
			title[j++] = "IMDG Class1";
			title[j++] = "IMDG Class1";
			title[j++] = "IMDG Class2";
			title[j++] = "IMDG Class2";
			title[j++] = "IMDG Class2";
			title[j++] = "IMDG Class2";
			title[j++] = "IMDG Class3";
			title[j++] = "IMDG Class3";
			title[j++] = "IMDG Class3";
			title[j++] = "IMDG Class3";
			title[j++] = "IMDG Class4";
			title[j++] = "IMDG Class4";
			title[j++] = "IMDG Class4";
			title[j++] = "IMDG Class4";
			title[j++] = "IMDG Class5";
			title[j++] = "IMDG Class5";
			title[j++] = "IMDG Class5";
			title[j++] = "IMDG Class5";
			title[j++] = "IMDG Class6";
			title[j++] = "IMDG Class6";
			title[j++] = "IMDG Class6";
			title[j++] = "IMDG Class6";
			title[j++] = "IMDG Class7";
			title[j++] = "IMDG Class7";
			title[j++] = "IMDG Class7";
			title[j++] = "IMDG Class7";
			title[j++] = "IMDG Class8";
			title[j++] = "IMDG Class8";
			title[j++] = "IMDG Class8";
			title[j++] = "IMDG Class8";
			title[j++] = "IMDG Class9";
			title[j++] = "IMDG Class9";
			title[j++] = "IMDG Class9";
			title[j++] = "IMDG Class9";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Bnd";
			title[j++] = "DIR";
			title[j++] = "RCV";
			title[j++] = "DEL";
			title[j++] = "CURR";
			title[j++] = "Code";
			title[j++] = "Name";
			title[j++] = "OLD AGMT";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "SVC_1";
			title[j++] = "SCHG_1";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_2";
			title[j++] = "SCHG_2";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_3";
			title[j++] = "SCHG_3";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_4";
			title[j++] = "SCHG_4";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_5";
			title[j++] = "SCHG_5";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_6";
			title[j++] = "SCHG_6";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_7";
			title[j++] = "SCHG_7";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_8";
			title[j++] = "SCHG_8";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
			title[j++] = "SVC_9";
			title[j++] = "SCHG_9";
			title[j++] = "20' TTL";
			title[j++] = "40' TTL";
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
	 * Ocean Feeder Cost Inquiry tab Special - Down Excel without Displaying<br>
	 * 
     * @param asiaFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getRFRowSet(AsiaFeederCostCondVO asiaFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			asiaFeederCostCondVO.setDateFlg(asiaFeederCostCondVO.getExcelDateFlg());
			asiaFeederCostCondVO.setFromDt(asiaFeederCostCondVO.getExcelFromDt());
			asiaFeederCostCondVO.setToDt(asiaFeederCostCondVO.getExcelToDt());
			asiaFeederCostCondVO.setEffToDt(asiaFeederCostCondVO.getExcelEffToDt());
			asiaFeederCostCondVO.setCostTrfNo(asiaFeederCostCondVO.getExcelCostTrfNo());
			asiaFeederCostCondVO.setPctlIoBndCd(asiaFeederCostCondVO.getExcelPctlIoBndCd());
			asiaFeederCostCondVO.setFromNodCd(asiaFeederCostCondVO.getExcelFromNodCd());
			asiaFeederCostCondVO.setToNodCd(asiaFeederCostCondVO.getExcelToNodCd());
			asiaFeederCostCondVO.setCostFactorCd(asiaFeederCostCondVO.getExcelCostFactorCd());
			asiaFeederCostCondVO.setSysSrcCd(asiaFeederCostCondVO.getExcelSysSrcCd());
			asiaFeederCostCondVO.setAdjustmentCd(asiaFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostRFExcel(asiaFeederCostCondVO);
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
	@Override
	public String[] getRFColumns() {
		String[] titleField = new String[47];

		int i = 0;
		titleField[i++] = " "                	  ;

		return titleField;
	}
    
	/**
	 * @param headCnt
	 * @return
	 */
	@Override
	public String[] getRFTitle(int headCnt) {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] title = new String[48];
		
		int j = 0;
		if(headCnt == 1){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Pre/Post";
			title[j++] = "DIR";
			title[j++] = "Feeder Term";
			title[j++] = "Feeder Term";
			title[j++] = "CURR";
			title[j++] = "Total Cost";
			title[j++] = "Total Cost";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 20'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
			title[j++] = "Trans Cost 40'";
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
			title[j++] = "Service Provider";
			title[j++] = "Service Provider";
			title[j++] = "OLD AGMT";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Creation";
			title[j++] = "Update";
			title[j++] = "Update";
			title[j++] = "Update";
		}else if(headCnt == 2){
			title[j++] = "Tariff No";
			title[j++] = "Status";
			title[j++] = "Effective From";
			title[j++] = "From";
			title[j++] = "To";
			title[j++] = "Pre/Post";
			title[j++] = "DIR";
			title[j++] = "RCV";
			title[j++] = "DEL";
			title[j++] = "CURR";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS2";
			title[j++] = "Total";
			title[j++] = "System Source";
			title[j++] = "System Amount";
			title[j++] = "ADJ_TRS4";
			title[j++] = "Total";
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
			title[j++] = "Code";
			title[j++] = "Name";
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
	 * @param trfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostTrfNo(String trfNo) throws EventException{
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyFeederCostTrfNo(trfNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;
	}
}