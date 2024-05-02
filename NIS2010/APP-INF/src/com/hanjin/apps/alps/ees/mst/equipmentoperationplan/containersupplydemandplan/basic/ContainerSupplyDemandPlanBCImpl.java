/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanBCImpl.java
*@FileTitle : Container Purchasing Trend by Year & input & update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration.ContainerSupplyDemandPlanDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPurSubListVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.ProcurementDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EquipmentOperationPlan Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentOperationPlan에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0034EventResponse,ContainerSupplyDemandPlanBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ContainerSupplyDemandPlanBCImpl extends BasicCommandSupport implements ContainerSupplyDemandPlanBC {

	// Database Access Object
	private transient ContainerSupplyDemandPlanDBDAO dbDao = null;

	/**
	 * ContainerSupplyDemandPlanBCImpl 객체 생성<br>
	 * ContainerSupplyDemandPlanDBDAO를 생성한다.<br>
	 */
	public ContainerSupplyDemandPlanBCImpl() {
		dbDao = new ContainerSupplyDemandPlanDBDAO();
	}
	
	/** EES_MST_0034 : retrieve<br>
	 * Year/Month와 EQ Type으로 해당되는 값을 검색한다<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0034_1
	 * @category searchEqPriceListBasic    
	 * @param EqPriceOptionVO   eqPriceOptionVO
	 * @return List<EqPriceDetailVO>
	 * @exception EventException
	 */		
	public List<EqPriceDetailVO> searchEqPriceListBasic(EqPriceOptionVO eqPriceOptionVO) throws EventException {
		try {
			return dbDao.searchEqPriceListData(eqPriceOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year & input & update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year & input & update"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0034 : save<br>
	 * Manufacturer, Delivery Location, TP/SZ, QTY, Price등을 포함한 데이타를 추가/삭제/수정 한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0034_2
	 * @category manageEqPriceBasic     
	 * @param EqPriceDetailVO[] eqPriceDetailVOs
	 * @param SignOnUserAccount account
	 * @return List<EqPriceDetailVO>	 
	 * @exception EventException
	 */
	public List<EqPriceDetailVO> manageEqPriceBasic(EqPriceDetailVO[] eqPriceDetailVOs, SignOnUserAccount account) throws EventException{
		List<EqPriceDetailVO> retVoList = new ArrayList<EqPriceDetailVO>();	
		try {
	
			EqPriceDetailVO tmpPriceDetailVO = new EqPriceDetailVO();
			
			for ( int i=0; i<eqPriceDetailVOs .length; i++ ) {
				if ( eqPriceDetailVOs[i].getIbflag().equals("I")){
					eqPriceDetailVOs[i].setCreUsrId(account.getUsr_id());
					eqPriceDetailVOs[i].setUpdUsrId(account.getUsr_id());
					tmpPriceDetailVO = eqPriceDetailVOs[i];

					//  DAO단에 있던 로직을 BC단으로 구현함 - Start						
//					tmpPriceDetailVO = dbDao.validationEqPriceData(eqPriceDetailVOs[i]);
					//CODE데이타를 검색한 조건
					List<EqPriceDetailVO> l1 = dbDao.searchManufacturerListData(tmpPriceDetailVO);
					List<EqPriceDetailVO> l3 = dbDao.searchManufacturePlaceListData(tmpPriceDetailVO);
					
					//등록된 코드 데이타가 에러인지를 확인하여 에러코드값을 setting한다.
					if (l1.size()== 0){
						tmpPriceDetailVO.setStl1("B");
					} else {
						tmpPriceDetailVO.setStl1("");
					}
					
					if (l3.size()== 0) {
						tmpPriceDetailVO.setStl3("B");
					} else {
						tmpPriceDetailVO.setStl3("");
					}
					
					tmpPriceDetailVO.setStl2("");
					//  DAO단에 있던 로직을 BC단으로 구현함 - End	
					//입력 Data validation 체크시 True일때
					boolean chkData =  dbDao.validationEqPriceData(eqPriceDetailVOs[i]);
					if (chkData) tmpPriceDetailVO.setInsflg("E");
					
					if (!tmpPriceDetailVO.getStl1().equals("B") && 
						!tmpPriceDetailVO.getStl2().equals("B") &&
						!tmpPriceDetailVO.getStl3().equals("B") &&
						!tmpPriceDetailVO.getInsflg().equals("E")){
						//2010.08.04 중복 try 문 제거 Start
						int result= dbDao.addEqPriceData(tmpPriceDetailVO);
						
						if (result!=1)	tmpPriceDetailVO.setInsflg("E");
						//2010.08.04 중복 try 문 제거 end
					}
					retVoList.add(tmpPriceDetailVO);
				} else if (eqPriceDetailVOs[i].getIbflag().equals("U")){
					eqPriceDetailVOs[i].setUpdUsrId(account.getUsr_id());
					tmpPriceDetailVO = eqPriceDetailVOs[i];
					//2010.08.04 중복 try 문 제거 Start
					int result= dbDao.modifyEqPriceData(tmpPriceDetailVO);
					
					if (result!=1) tmpPriceDetailVO.setUpdflg("E");
					//2010.08.04 중복 try 문 제거 end
					retVoList.add(tmpPriceDetailVO);
				} else if (eqPriceDetailVOs[i].getIbflag().equals("D")){
					tmpPriceDetailVO = eqPriceDetailVOs[i];
					//2010.08.04 중복 try 문 제거 Start
					int result= dbDao.removeEqPriceData(tmpPriceDetailVO);
					
					if (result!=1) tmpPriceDetailVO.setUpdflg("E");
					//2010.08.04 중복 try 문 제거 end
					retVoList.add(tmpPriceDetailVO);
				} else {
					retVoList.add(tmpPriceDetailVO);
				}	
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year & input & update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year & input & update"}).getMessage(),ex);
		}
		return retVoList;
	}
	
	/**
	 * EES_MST_0039 : retrieve<br>
	 *  ContainerSupplyDemandPlan화면에 대한 검색을 한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_1
	 * @category searchEqPriceReportBasic       
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @param List<EqPurSubListVO> eqPurSubListVOs
	 * @return List<EqPurSubListVO>
	 * @exception EventException
	 */
	public List<EqPurSubListVO> searchEqPriceReportBasic(EqPriceOptionVO eqPriceOptionVO, List<EqPurSubListVO> eqPurSubListVOs) throws EventException {
		try {
			return dbDao.searchEqPriceReportData(eqPriceOptionVO, eqPurSubListVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year inquiry"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year inquiry"}).getMessage(),ex);		
		}
	}
	
	/**
	 * EES_MST_0039 : retrieve <br> 
	 * Purchasing List Data조회 이벤트 처리<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_2
	 * @category searchEqPriceReportLocListBasic     
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @return List<EqPurSubListVO>
	 * @exception EventException
	 */	
	public List<EqPurSubListVO> searchEqPriceReportLocListBasic(EqPriceOptionVO eqPriceOptionVO) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchEqPriceReportLocListData(eqPriceOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year inquiry"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Purchasing Trend by Year inquiry"}).getMessage(),ex);
		}
	}

	/**
	 * 연도별 Equipment Procurement를 조회한다.<br>
	 *  
	 * @author J.H.Min
	 * @category EES_MST_0033
	 * @category searchProcurementPlanResultReportBasic  
	 *  
	 * @param ProcurementDetailVO procurementDetailVO
	 * @return List<ProcurementDetailVO>
	 * @exception EventException
	 */
	public List<ProcurementDetailVO> searchProcurementPlanResultReportBasic(ProcurementDetailVO procurementDetailVO) throws EventException {
		try {
			return dbDao.searchProcurementPlanResultReportData(procurementDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Equipment Procurement Search"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Equipment Procurement Search"}).getMessage(),ex);			
		}		
	}			
	
	/** EES_MST_0040 : retrieve<br>
	 * 연말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 조회한다.<br>
	 *  
	 * @param ProcurementDetailVO procurementDetailVO 
	 * @return List<ProcurementDetailVO>
	 * @exception EventException
	 */		
	public List<ProcurementDetailVO> searchProcurementPlanListBasic(ProcurementDetailVO procurementDetailVO) throws EventException {
		try {
			return dbDao.searchProcurementPlanListData(procurementDetailVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}	
	
	/**
	 * 연말 추정 재고를 기초로 작성한 월별/장비 TY-SZ별 차년도 장비 확보 계획을 생성,수정한다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0040
	 * @category manageProcurementPlanBasic 
	 * 
	 * @param ProcurementDetailVO[] procurementDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProcurementPlanBasic(ProcurementDetailVO[] procurementDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ProcurementDetailVO> insertVoList = new ArrayList<ProcurementDetailVO>();
			List<ProcurementDetailVO> updateVoList = new ArrayList<ProcurementDetailVO>();			
			
			for ( int i=0; i<procurementDetailVOs.length; i++ ) {
				if ( procurementDetailVOs[i].getIbflag().equals("U") ||
					 procurementDetailVOs[i].getIbflag().equals("D") ||
					 procurementDetailVOs[i].getIbflag().equals("I")
					){		
					procurementDetailVOs[i].setCreUsrId(account.getUsr_id());					
					procurementDetailVOs[i].setUpdUsrId(account.getUsr_id());	
										
					procurementDetailVOs[i].setInputPlnYr(procurementDetailVOs[0].getInputPlnYr());
					procurementDetailVOs[i].setInputBseYrmon(procurementDetailVOs[0].getInputBseYrmon());
					procurementDetailVOs[i].setInputSw("S");					
					if(dbDao.searchProcurementPlanListData(procurementDetailVOs[i]).size() > 0){						
						updateVoList.add(procurementDetailVOs[i]);						
					}else{						
						insertVoList.add(procurementDetailVOs[i]);						
					}							
				} 
			}		
			
			if ( updateVoList.size() > 0) {
				dbDao.modifyProcurementPlanData(updateVoList);
			}			
			if ( insertVoList.size() > 0) {
				dbDao.addProcurementPlanData(insertVoList);
			}						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Procurement Plan Save"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Procurement Plan Save"}).getMessage(),ex);			
		}	
	}		
	
}