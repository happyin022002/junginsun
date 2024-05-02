/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoResultManageBC.java
*@FileTitle : CntrRepoResultManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_0144 화면 신규 개발
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.basic;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-CntrForecastPrecisionManage Business Logic Command Interface<br>
 * - ALPS-CntrForecastPrecisionManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Bong-jun,Yang
 * @see EventException 참조
 * @since J2EE 1.6
 */
public interface CntrRepoResultManageBC {

	/**
	 * [ EES_EQR_0144 : Empty Repo Result ]<br>
	 * 
	 * @param EmptyRepoResultOptionVO emptyRepoResultOptionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchEmptyRepoResult(EmptyRepoResultOptionVO emptyRepoResultOptionVO) throws EventException;

}