/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OceanFeederCostManageBCImpl.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration.OceanFeederCostManageDBDAO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostDGVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.OceanFeederCostCondVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchOceanFeederCostAccountVO;
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
 * @author Kim Jong Ock
 * @see ESD_TRS_3001EventResponse,OceanFeederCostManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OceanFeederCostManageBCImpl extends BasicCommandSupport implements OceanFeederCostManageBC {
	
	// Database Access Object
	private transient OceanFeederCostManageDBDAO dbDao = null;

	/**
	 * OceanFeederCostManageBCImpl 객체 생성<br>
	 * OceanFeederCostManageDBDAO를 생성한다.<br>
	 */
	public OceanFeederCostManageBCImpl() {
		dbDao = new OceanFeederCostManageDBDAO();
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostVO> searchFeederCost(String inCostTrfNo) throws EventException {
		try {
			return dbDao.searchFeederCost(inCostTrfNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchFeederDgCostVO> searchFeederDgCost(String inCostTrfNo) throws EventException {
		try {
			return dbDao.searchFeederDgCost(inCostTrfNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchFeederReeferCostVO> searchFeederRfCost(String inCostTrfNo) throws EventException {
		try {
			return dbDao.searchFeederRfCost(inCostTrfNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inOfcCd
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostTariffNoVO> searchFeederCostTariffNo(String inOfcCd) throws EventException {
		try {
			return dbDao.searchFeederCostTariffNo(inOfcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inCostTrfNo
	 * @param inOfcCd
	 * @return
	 * @throws EventException
	 */
	public FeederCostTariffInfoVO searchFeederCostTariffInfo(String inCostTrfNo, String inOfcCd) throws EventException {
		try {
			FeederCostTariffInfoVO feederCostTariffInfoVO = dbDao.searchFeederCostTariffInfo(inCostTrfNo, inOfcCd);
			return feederCostTariffInfoVO;			
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
	public void multiFeederCost(FeederCostVO[] feederCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<FeederCostVO> updateVoList = new ArrayList<FeederCostVO>();

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
	public void multiFeederDgCost(SearchFeederDgCostVO[] searchFeederDgCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<SearchFeederDgCostVO> updateVoList = new ArrayList<SearchFeederDgCostVO>();

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
	public void multiFeederRfCost(SearchFeederReeferCostVO[] searchFeederReeferCostVOs, SignOnUserAccount account) throws EventException {

		try {
			List<SearchFeederReeferCostVO> updateVoList = new ArrayList<SearchFeederReeferCostVO>();

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
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void multiFeederCostHdr(String inCostTrfNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.multiFeederCostHdr(inCostTrfNo, account);
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
	 * @param inCostTrfNo
	 * @return
	 * @throws EventException
	 */
	public String verifyFeederCostConfirm(String inCostTrfNo) throws EventException {
		try {
			String cnt = dbDao.verifyFeederCostConfirm(inCostTrfNo);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCostPreVer(String inCostTrfNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmFeederCostPreVer(inCostTrfNo, account);
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
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void confirmFeederCost(String inCostTrfNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.confirmFeederCost(inCostTrfNo, account);
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
	 * @param inCostTrfNo
	 * @param inRhqCd
	 * @return
	 * @throws EventException
	 */
	public String searchFeederCostGuidelineExist(String inCostTrfNo, String inRhqCd) throws EventException {
		try {
			String cnt = dbDao.searchFeederCostGuidelineExist(inCostTrfNo, inRhqCd);
			return cnt;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inCostTrfNo
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxl(String inCostTrfNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyFeederCostMgtCfmCxl(inCostTrfNo, account);
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
	 * @param inCostTrfNo
	 * @param inRhqCd
	 * @param account
	 * @throws EventException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(String inCostTrfNo, String inRhqCd, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyFeederCostMgtCfmCxlPreVer(inCostTrfNo, inRhqCd, account);
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
	public List<SearchOceanFeederCostAccountVO> searchOceanFeederCostAccount(SearchOceanFeederCostAccountVO inputVo) throws EventException {
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
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostInquiryVO> searchFeederCostInquiry(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostInquiry(oceanFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Ocean Feeder Cost DG - Retrieve<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostDGVO> searchFeederCostDG(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostDG(oceanFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost RF - Retrieve<br>
	 * 
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws EventException
	 */
	public List<FeederCostInquiryVO> searchFeederCostRF(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		try {
			return dbDao.searchFeederCostRF(oceanFeederCostCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
     * @param oceanFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDryRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			oceanFeederCostCondVO.setDateFlg(oceanFeederCostCondVO.getExcelDateFlg());
			oceanFeederCostCondVO.setFromDt(oceanFeederCostCondVO.getExcelFromDt());
			oceanFeederCostCondVO.setToDt(oceanFeederCostCondVO.getExcelToDt());
			oceanFeederCostCondVO.setEffToDt(oceanFeederCostCondVO.getExcelEffToDt());
			oceanFeederCostCondVO.setCostTrfNo(oceanFeederCostCondVO.getExcelCostTrfNo());
			oceanFeederCostCondVO.setPctlIoBndCd(oceanFeederCostCondVO.getExcelPctlIoBndCd());
			oceanFeederCostCondVO.setFromNodCd(oceanFeederCostCondVO.getExcelFromNodCd());
			oceanFeederCostCondVO.setToNodCd(oceanFeederCostCondVO.getExcelToNodCd());
			oceanFeederCostCondVO.setCostFactorCd(oceanFeederCostCondVO.getExcelCostFactorCd());
			oceanFeederCostCondVO.setSysSrcCd(oceanFeederCostCondVO.getExcelSysSrcCd());
			oceanFeederCostCondVO.setAdjustmentCd(oceanFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostInquiryExcel(oceanFeederCostCondVO);
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
		String[] title = new String[49];
		
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
     * @param oceanFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getDGRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			oceanFeederCostCondVO.setDateFlg(oceanFeederCostCondVO.getExcelDateFlg());
			oceanFeederCostCondVO.setFromDt(oceanFeederCostCondVO.getExcelFromDt());
			oceanFeederCostCondVO.setToDt(oceanFeederCostCondVO.getExcelToDt());
			oceanFeederCostCondVO.setEffToDt(oceanFeederCostCondVO.getExcelEffToDt());
			oceanFeederCostCondVO.setCostTrfNo(oceanFeederCostCondVO.getExcelCostTrfNo());
			oceanFeederCostCondVO.setPctlIoBndCd(oceanFeederCostCondVO.getExcelPctlIoBndCd());
			oceanFeederCostCondVO.setFromNodCd(oceanFeederCostCondVO.getExcelFromNodCd());
			oceanFeederCostCondVO.setToNodCd(oceanFeederCostCondVO.getExcelToNodCd());
			oceanFeederCostCondVO.setCostFactorCd(oceanFeederCostCondVO.getExcelCostFactorCd());
			oceanFeederCostCondVO.setSysSrcCd(oceanFeederCostCondVO.getExcelSysSrcCd());
			oceanFeederCostCondVO.setAdjustmentCd(oceanFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostDGExcel(oceanFeederCostCondVO);
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
		String[] title = new String[56];
		
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
     * @param oceanFeederCostCondVO
     * @return
     * @throws EventException
     */
    @SuppressWarnings("unused")
	public DBRowSet getRFRowSet(OceanFeederCostCondVO oceanFeederCostCondVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			oceanFeederCostCondVO.setDateFlg(oceanFeederCostCondVO.getExcelDateFlg());
			oceanFeederCostCondVO.setFromDt(oceanFeederCostCondVO.getExcelFromDt());
			oceanFeederCostCondVO.setToDt(oceanFeederCostCondVO.getExcelToDt());
			oceanFeederCostCondVO.setEffToDt(oceanFeederCostCondVO.getExcelEffToDt());
			oceanFeederCostCondVO.setCostTrfNo(oceanFeederCostCondVO.getExcelCostTrfNo());
			oceanFeederCostCondVO.setPctlIoBndCd(oceanFeederCostCondVO.getExcelPctlIoBndCd());
			oceanFeederCostCondVO.setFromNodCd(oceanFeederCostCondVO.getExcelFromNodCd());
			oceanFeederCostCondVO.setToNodCd(oceanFeederCostCondVO.getExcelToNodCd());
			oceanFeederCostCondVO.setCostFactorCd(oceanFeederCostCondVO.getExcelCostFactorCd());
			oceanFeederCostCondVO.setSysSrcCd(oceanFeederCostCondVO.getExcelSysSrcCd());
			oceanFeederCostCondVO.setAdjustmentCd(oceanFeederCostCondVO.getExcelAdjustmentCd());
			
			return rowSet=dbDao.searchFeederCostRFExcel(oceanFeederCostCondVO);
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
		String[] title = new String[47];
		
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