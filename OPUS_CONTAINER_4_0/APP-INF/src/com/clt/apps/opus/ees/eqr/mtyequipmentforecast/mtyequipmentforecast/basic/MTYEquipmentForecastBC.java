/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBC.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Mtyequipmentforecast Business Logic Command Interface<br>

 *
 * @author 
 * @see Ees_cim_5001EventResponse 
 * @since J2EE 1.6
 */

public interface MTYEquipmentForecastBC {

	/**
	 *  retrieving for  MTY Balance Data <<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;

	/**
	 *  retrieving for MTY Balance reference Data<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceReferenceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceReferenceListVO> searchMtyBalanceReferenceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;

	/**
	 * saving MTY Balace data<br>
	 * 
	 * @param MtyBalanceListVO[] mtyBalanceListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyBalance(MtyBalanceListVO[] mtyBalanceListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 *  retrieving for EQ Demand & Supply<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @exception EventException
	 */
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;
	
	/**
	 * retrieving for yard in the ECC<br>
	 * 
	 * @param eccCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String eccCd ) throws EventException;

	/**
	 * retrieving for the date by week<br>
	 * 
	 * @param yearWeek
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchDateListByWeek( String yearWeek ) throws EventException;

	/**
	 * saving for EQ Demand & Supply<br>
	 * 
	 * @param MtyBalRptOtrVO[] mtyBalanceListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceOther(MtyBalRptOtrVO[] mtyBalanceListVOs,SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for MTY balace plan<br>
	 * 
	 * @param MtyBalanceOptionVO	mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException;

	/**
	 *  retrieving for In&Out Bound FCST Data by week<br>
	 * 
	 * @param ForecastAccuracyOptionVO	forecastAccuracyOptionVO
	 * @return List<ForecastAccuracyListVO>
	 * @exception EventException
	 */
	public List<ForecastAccuracyListVO> searcForecastAccuracyList(ForecastAccuracyOptionVO forecastAccuracyOptionVO) throws EventException;

}