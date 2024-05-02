/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0025Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ActivityVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActivityVO activityVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActivityVO[] activityVOs = null;
	
	private String actCd = null;

	public BcmCcd0025Event(){}
	
	public void setActivityVO(ActivityVO activityVO){
		this. activityVO = activityVO;
	}

	public void setActivityVOS(ActivityVO[] activityVOs){
		if(activityVOs != null){
			ActivityVO[] tmpVOs = java.util.Arrays.copyOf(activityVOs, activityVOs.length);
			this.activityVOs = tmpVOs;
		}
	}
	
	public void setActCd(String actCd){
		this. actCd = actCd;
	}

	public ActivityVO getActivityVO(){
		return activityVO;
	}

	public ActivityVO[] getActivityVOS(){
		ActivityVO[] rtnVOs = null;
		if (this.activityVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(activityVOs, activityVOs.length);
		}
		return rtnVOs;
	}
	
	public String getActCd(){
		return actCd;
	}

}