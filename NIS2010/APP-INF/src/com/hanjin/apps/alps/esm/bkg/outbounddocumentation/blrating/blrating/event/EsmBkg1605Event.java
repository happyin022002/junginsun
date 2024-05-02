/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1605Event.java
*@FileTitle : Group & Multi B/L Rating
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.GroupRatingVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1605 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1605HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1605HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1605Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GroupRatingVO groupRatingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private GroupRatingVO[] groupRatingVOs = null;

	
	public void setGroupRatingVO(GroupRatingVO groupRatingVO){
		this. groupRatingVO = groupRatingVO;
	}

	public GroupRatingVO getGroupRatingVO(){
		return groupRatingVO;
	}

	/**
	 * @return the GroupRatingVOs
	 */
	public GroupRatingVO[] getGroupRatingVOs() {
		GroupRatingVO[] rtnVOs = null;
		if (this.groupRatingVOs != null) {
			rtnVOs = Arrays.copyOf(groupRatingVOs, groupRatingVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param @param GroupRatingVOs the GroupRatingVOs to set
	 */
	public void setGroupRatingVOs(GroupRatingVO[] groupRatingVOs){
		if(groupRatingVOs != null){
			GroupRatingVO[] tmpVOs = Arrays.copyOf(groupRatingVOs, groupRatingVOs.length);
			this.groupRatingVOs = tmpVOs;
		}
	}
	
}