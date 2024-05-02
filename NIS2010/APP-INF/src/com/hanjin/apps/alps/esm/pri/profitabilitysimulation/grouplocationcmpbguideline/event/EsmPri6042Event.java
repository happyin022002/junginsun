/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6042Event.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.GroupLocationCmpbGuidelineVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO = new GroupLocationCmpbGuidelineVO();

	/**
	 * @return the groupLocationCmpbGuidelineVO
	 */
	public GroupLocationCmpbGuidelineVO getGroupLocationCmpbGuidelineVO() {
		return groupLocationCmpbGuidelineVO;
	}

	/**
	 * @param groupLocationCmpbGuidelineVO the groupLocationCmpbGuidelineVO to set
	 */
	public void setGroupLocationCmpbGuidelineVO(
			GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO) {
		this.groupLocationCmpbGuidelineVO = groupLocationCmpbGuidelineVO;
	}


}