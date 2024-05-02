/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDet3rdBC.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see 
 * @since J2EE 1.6
 */

public interface DemDet3rdBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<DemDet3rdVO>
	 * @exception EventException
	 */
	public List<DemDet3rdVO> searchDEMDET3RDList(SearchConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param DemDet3rdVO[] demDet3rdVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDEMDET3RD(DemDet3rdVO[] demDet3rdVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}