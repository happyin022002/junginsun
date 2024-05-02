/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6041Event.java
*@FileTitle : CMPB Guideline Creation - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.GroupCommodityCmpbGuidelineVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO = new GroupCommodityCmpbGuidelineVO();
	
	/**
	 * @return the groupCommodityCmpbGuidelineVO
	 */
	public GroupCommodityCmpbGuidelineVO getGroupCommodityCmpbGuidelineVO() {
		return groupCommodityCmpbGuidelineVO;
	}

	/**
	 * @param groupCommodityCmpbGuidelineVO the groupCommodityCmpbGuidelineVO to set
	 */
	public void setGroupCommodityCmpbGuidelineVO(
			GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO) {
		this.groupCommodityCmpbGuidelineVO = groupCommodityCmpbGuidelineVO;
	}
	
	

}