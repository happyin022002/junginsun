/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see Ui_pri_0001EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCSalesGuidelineBC {
	/**
	 * Sales Guideline을 조회합니다. <br>
	 * 
	 * @param PriSgSlsRefVO priSgSlsRefVO
	 * @return List<PriSgSlsRefVO>
	 * @exception EventException
	 */
	public List<PriSgSlsRefVO> searchSalesGuidelineList(PriSgSlsRefVO priSgSlsRefVO) throws EventException;

	/**
	 * Sales Guideline 데이터의 CUD 멀티 이벤트를 처리합니다. <br>
	 * 
	 * @param PriSgSlsRefVO[] priSgSlsRefVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesGuideline(PriSgSlsRefVO[] priSgSlsRefVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

}