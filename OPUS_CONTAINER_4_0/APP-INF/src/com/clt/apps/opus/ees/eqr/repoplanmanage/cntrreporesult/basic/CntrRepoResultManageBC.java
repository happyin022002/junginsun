/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoResultManageBC.java
*@FileTitle : CntrRepoResultManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.basic;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * -CntrForecastPrecisionManage Business Logic Command Interface<br>
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