/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InitialSpaceAllocationRatioBC.java
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcInitAlocRtoVO;

/**
 * ALPS-Basicdatamanage Business Logic Command Interface<br>
 * - ALPS-Basicdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see Esm_spc_0004EventResponse 참조
 * @since J2EE 1.6
 */


public interface InitialSpaceAllocationRatioBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInitialSpaceAllocationRatioListVO	searchInitialSpaceAllocationRatioListVO
	 * @return List<SearchInitialSpaceAllocationRatioListVO>
	 * @exception EventException
	 */
	public List<SearchInitialSpaceAllocationRatioListVO> searchInitialSpaceAllocationRatioList(SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcInitAlocRtoVO[] spcInitAlocRtoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiInitialSpaceAllocationRatio(SpcInitAlocRtoVO[] spcInitAlocRtoVO,SignOnUserAccount account) throws EventException;
	

}