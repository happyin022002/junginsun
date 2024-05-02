/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0216Event.java
*@FileTitle : M&R Guideline & Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.08 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event;

import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0216 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0216HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE JU HYUN
 * @see EES_MNR_0216HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0216Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private GuidelineGRPVO guidelineGRPVO = null;

	/**
	 * @return the guidelineGRPVO
	 */
	public GuidelineGRPVO getGuidelineGRPVO() {
		return guidelineGRPVO;
	}

	/**
	 * @param guidelineGRPVO the guidelineGRPVO to set
	 */
	public void setGuidelineGRPVO(GuidelineGRPVO guidelineGRPVO) {
		this.guidelineGRPVO = guidelineGRPVO;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
}