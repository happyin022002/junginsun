/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineBC.java
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGohChgVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Ui_pri_0001_005EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGOHChargeGuidelineBC {
	/**
	 * S/C Guideline GOH Charge 정보를 조회합니다.<br>
	 * 
	 * @param PriSgGohChgVO priSgGohChgVO
	 * @return List<RsltPriSgGohChgVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGohChgVO> searchGOHChargeGuidelineList(PriSgGohChgVO priSgGohChgVO) throws EventException;
	/**
	 * GOHChargeGuideline을 저장합니다.<br>
	 * 
	 * @param PriSgGohChgVO[] priSgGohChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHChargeGuideline(PriSgGohChgVO[] priSgGohChgVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * GOHChargeGuideline을 삭제합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;		
	
	/**
	 * GOH Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}