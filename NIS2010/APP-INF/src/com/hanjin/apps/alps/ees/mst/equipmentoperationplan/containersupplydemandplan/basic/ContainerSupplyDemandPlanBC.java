/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanBC.java
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

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPurSubListVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.ProcurementDetailVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Equipmentoperationplan Business Logic Command Interface<br>
 * - ALPS-Equipmentoperationplan에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Sun
 * @see Ees_mst_0034EventResponse 참조
 * @since J2EE 1.6
 */

public interface ContainerSupplyDemandPlanBC {
	/** EES_MST_0034 : retrieve <br>
	 * Year/Month와 EQ Type으로 해당되는 값을 검색한다<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0034_1
	 * @category searchEqPriceListBasic    
	 * @param EqPriceOptionVO   eqPriceOptionVO
	 * @return List<EqPriceDetailVO>
	 * @exception EventException
	 */	
	public List<EqPriceDetailVO> searchEqPriceListBasic(EqPriceOptionVO eqPriceOptionVO) throws EventException;
	
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
	public List<EqPriceDetailVO> manageEqPriceBasic(EqPriceDetailVO[] eqPriceDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_MST_0039 : retrieve<br>
	 * ContainerSupplyDemandPlan화면에 대한 검색을 한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_1
	 * @category searchEqPriceReportBasic       
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @param List<EqPurSubListVO> eqPurSubListVOs
	 * @return List<EqPurSubListVO>
	 * @exception EventException
	 */
	public List<EqPurSubListVO> searchEqPriceReportBasic(EqPriceOptionVO eqPriceOptionVO, List<EqPurSubListVO> eqPurSubListVOs) throws EventException;
	
	/**
	 * EES_MST_0039 : retrieve<br>
	 * Location Code를 검색한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_2
	 * @category searchEqPriceReportLocListBasic     
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @return List<EqPurSubListVO>
	 * @exception EventException
	 */	
	public List<EqPurSubListVO> searchEqPriceReportLocListBasic(EqPriceOptionVO eqPriceOptionVO) throws EventException;	
	
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
	public List<ProcurementDetailVO> searchProcurementPlanResultReportBasic(ProcurementDetailVO procurementDetailVO) throws EventException;	

	/**
	 * 년말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 조회한다.<br>
	 * 
	 * @param ProcurementDetailVO procurementDetailVO
	 * @return List<ProcurementDetailVO>
	 * @exception EventException
	 */			
	public List<ProcurementDetailVO> searchProcurementPlanListBasic(ProcurementDetailVO procurementDetailVO) throws EventException;	
		
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
	public void manageProcurementPlanBasic(ProcurementDetailVO[] procurementDetailVOs, SignOnUserAccount account) throws EventException;
	
}