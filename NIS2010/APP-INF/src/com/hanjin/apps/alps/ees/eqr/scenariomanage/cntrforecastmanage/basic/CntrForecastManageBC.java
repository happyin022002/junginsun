/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageBC.java
*@FileTitle : Holiday Effect
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0114ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0126ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.SearchEqrHolidayListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrIbBkgFcastVO;
import com.hanjin.syscommon.common.table.EqrObFcastVO;
import com.hanjin.syscommon.common.table.EqrScnrEccTurnTmVO;

/**
 * ALPS-CntrForecastManage Business Logic Command Interface<br>
 * - ALPS-CntrForecastManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0114EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrForecastManageBC {

	/**
	 * [ EES_EQR_0114 : Holiday Effect - Detail PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO	EesEqr0114ConditionVO
	 * @param io_bnd_cd String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchHolidayEffectDetailInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO, String io_bnd_cd) throws EventException;

	/**
	 * [ EES_EQR_0114 : Holiday Effect PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO	EesEqr0114ConditionVO
	 * @return List<SearchEqrHolidayListVO>
	 * @exception EventException
	 */
	public List<SearchEqrHolidayListVO> searchHolidayEffectInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO) throws EventException;
	
	/**
	 * 컨테이너 수요 예측(O/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0025ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrForecastInfo(EesEqr0025ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수요 예측(O/B) 멀티 이벤트 처리<br>
	 * 
	 * @param eqrObFcastVOS EqrObFcastVO[]
	 * @param scnr_id String
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrForecastInfo(EqrObFcastVO[] eqrObFcastVOS, String scnr_id, SignOnUserAccount account) throws EventException;
	
	/**
	 * 컨테이너 수요 예측(I/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0079ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrGeneration(EesEqr0079ConditionVO conditionVO) throws EventException;
	
	/**
	 *  컨테이너 수요 예측(I/B) 멀티 이벤트 처리<br>
	 * 
	 * @param eqrIbBkgFcastVOS EqrIbBkgFcastVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrGeneration(EqrIbBkgFcastVO[] eqrIbBkgFcastVOS, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_126화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO  EesEqr0126ConditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchCntrTurnTimeInfo(EesEqr0126ConditionVO conditionVO) throws EventException;
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_126화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrEccTurnTmVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrTurnTimeInfo(EqrScnrEccTurnTmVO[] vos , SignOnUserAccount account ) throws EventException;
	

}