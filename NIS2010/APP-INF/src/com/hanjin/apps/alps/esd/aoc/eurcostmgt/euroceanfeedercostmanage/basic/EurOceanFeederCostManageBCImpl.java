/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageBCImpl.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*
* History
* 2015.02.03 CHM-201533794 전지예 [AOC] 45' Cost 추가
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration.EurOceanFeederCostManageDBDAO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
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
public class EurOceanFeederCostManageBCImpl extends BasicCommandSupport implements EurOceanFeederCostManageBC {
	
	// Database Access Object
	private transient EurOceanFeederCostManageDBDAO dbDao = null;

	/**
	 * OceanFeederCostManageBCImpl 객체 생성<br>
	 * OceanFeederCostManageDBDAO를 생성한다.<br>
	 */
	public EurOceanFeederCostManageBCImpl() {
		dbDao = new EurOceanFeederCostManageDBDAO();
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostVO> searchFeederCost(EurFeederMgtCondVO inputVO) throws EventException {
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
	public List<EurFeederDgCostVO> searchFeederDgCost(EurFeederMgtCondVO inputVO) throws EventException {
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
	public List<EurFeederReeferCostVO> searchFeederRfCost(EurFeederMgtCondVO inputVO) throws EventException {
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
	public List<EurFeederCostTariffNoVO> searchFeederCostTariffNo(EurFeederMgtCondVO inputVO) throws EventException {
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
	public EurFeederCostTariffInfoVO searchFeederCostTariffInfo(EurFeederMgtCondVO inputVO) throws EventException {
		try {
			EurFeederCostTariffInfoVO eurFeederCostTariffInfoVO = dbDao.searchFeederCostTariffInfo(inputVO);
			return eurFeederCostTariffInfoVO;			
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
	public void multiFeederCost(EurFeederCostVO[] feederCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<EurFeederCostVO> updateVoList = new ArrayList<EurFeederCostVO>();

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
	public void multiFeederDgCost(EurFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<EurFeederDgCostVO> updateVoList = new ArrayList<EurFeederDgCostVO>();

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
	public void multiFeederRfCost(EurFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<EurFeederReeferCostVO> updateVoList = new ArrayList<EurFeederReeferCostVO>();

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
	public void removeFdrTrfDtl(EurFeederCostVO[] inputVOs, SignOnUserAccount account) throws EventException {

		try {
			List<EurFeederCostVO> deleteVoList = new ArrayList<EurFeederCostVO>();

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
	public void multiFeederCostHdr(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
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
	public String verifyFeederCostConfirm(EurFeederMgtCondVO inputVO) throws EventException {
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
	public void confirmFeederCostPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
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
	public void confirmFeederCost(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
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
	public String searchFeederCostGuidelineExist(EurFeederMgtCondVO inputVO) throws EventException {
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
	public void modifyFeederCostMgtCfmCxl(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
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
	public void modifyFeederCostMgtCfmCxlPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException {
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
	public List<EurFeederCostAccountVO> searchOceanFeederCostAccount(EurFeederCostAccountVO inputVo) throws EventException {
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
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostInquiryVO> searchFeederCostInquiry(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostInquiry(eurFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostDGVO> searchFeederCostDG(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostDG(eurFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<EurFeederCostInquiryVO> searchFeederCostRF(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostRF(eurFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param eurFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			eurFeederCostCondVO.setDateFlg(eurFeederCostCondVO.getExcelDateFlg());
			eurFeederCostCondVO.setFromDt(eurFeederCostCondVO.getExcelFromDt());
			eurFeederCostCondVO.setToDt(eurFeederCostCondVO.getExcelToDt());
			eurFeederCostCondVO.setEffToDt(eurFeederCostCondVO.getExcelEffToDt());
			eurFeederCostCondVO.setCostTrfNo(eurFeederCostCondVO.getExcelCostTrfNo());
			eurFeederCostCondVO.setPctlIoBndCd(eurFeederCostCondVO.getExcelPctlIoBndCd());
			eurFeederCostCondVO.setFromNodCd(eurFeederCostCondVO.getExcelFromNodCd());
			eurFeederCostCondVO.setToNodCd(eurFeederCostCondVO.getExcelToNodCd());
			eurFeederCostCondVO.setCostFactorCd(eurFeederCostCondVO.getExcelCostFactorCd());
			eurFeederCostCondVO.setSysSrcCd(eurFeederCostCondVO.getExcelSysSrcCd());
			eurFeederCostCondVO.setAdjustmentCd(eurFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostInquiryExcel(eurFeederCostCondVO);
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
		String[] titleField = new String[62];

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
		String[] title = new String[65];
		
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
			title[j++] = "Total Cost";	// 45' Cost 추가
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";
			title[j++] = "M/B Ratio";	// 45' Cost 추가
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
			// 45' Cost 추가
			title[j++] = "Trans Cost 45'";
			title[j++] = "Trans Cost 45'";
			title[j++] = "Trans Cost 45'";
			title[j++] = "Trans Cost 45'";
			title[j++] = "Trans Cost 45'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 20'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			title[j++] = "Empty Cost 40'";
			// 45' Cost 추가
			title[j++] = "Empty Cost 45'";
			title[j++] = "Empty Cost 45'";
			title[j++] = "Empty Cost 45'";
			title[j++] = "Empty Cost 45'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 20'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			title[j++] = "Terminal Cost 40'";
			// 45' Cost 추가
			title[j++] = "Terminal Cost 45'";
			title[j++] = "Terminal Cost 45'";
			title[j++] = "Terminal Cost 45'";
			title[j++] = "Terminal Cost 45'";
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
			title[j++] = "45'";	// 45' Cost 추가
			title[j++] = "SCC";
			title[j++] = "20'";
			title[j++] = "40'";
			title[j++] = "45'";	// 45' Cost 추가
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
			// 45' Cost 추가
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
			// 45' Cost 추가
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
			// 45' Cost 추가
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
     * @param eurFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDGRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			eurFeederCostCondVO.setDateFlg(eurFeederCostCondVO.getExcelDateFlg());
			eurFeederCostCondVO.setFromDt(eurFeederCostCondVO.getExcelFromDt());
			eurFeederCostCondVO.setToDt(eurFeederCostCondVO.getExcelToDt());
			eurFeederCostCondVO.setEffToDt(eurFeederCostCondVO.getExcelEffToDt());
			eurFeederCostCondVO.setCostTrfNo(eurFeederCostCondVO.getExcelCostTrfNo());
			eurFeederCostCondVO.setPctlIoBndCd(eurFeederCostCondVO.getExcelPctlIoBndCd());
			eurFeederCostCondVO.setFromNodCd(eurFeederCostCondVO.getExcelFromNodCd());
			eurFeederCostCondVO.setToNodCd(eurFeederCostCondVO.getExcelToNodCd());
			eurFeederCostCondVO.setCostFactorCd(eurFeederCostCondVO.getExcelCostFactorCd());
			eurFeederCostCondVO.setSysSrcCd(eurFeederCostCondVO.getExcelSysSrcCd());
			eurFeederCostCondVO.setAdjustmentCd(eurFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostDGExcel(eurFeederCostCondVO);
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
     * @param eurFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getRFRowSet(EurFeederCostCondVO eurFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			eurFeederCostCondVO.setDateFlg(eurFeederCostCondVO.getExcelDateFlg());
			eurFeederCostCondVO.setFromDt(eurFeederCostCondVO.getExcelFromDt());
			eurFeederCostCondVO.setToDt(eurFeederCostCondVO.getExcelToDt());
			eurFeederCostCondVO.setEffToDt(eurFeederCostCondVO.getExcelEffToDt());
			eurFeederCostCondVO.setCostTrfNo(eurFeederCostCondVO.getExcelCostTrfNo());
			eurFeederCostCondVO.setPctlIoBndCd(eurFeederCostCondVO.getExcelPctlIoBndCd());
			eurFeederCostCondVO.setFromNodCd(eurFeederCostCondVO.getExcelFromNodCd());
			eurFeederCostCondVO.setToNodCd(eurFeederCostCondVO.getExcelToNodCd());
			eurFeederCostCondVO.setCostFactorCd(eurFeederCostCondVO.getExcelCostFactorCd());
			eurFeederCostCondVO.setSysSrcCd(eurFeederCostCondVO.getExcelSysSrcCd());
			eurFeederCostCondVO.setAdjustmentCd(eurFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostRFExcel(eurFeederCostCondVO);
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