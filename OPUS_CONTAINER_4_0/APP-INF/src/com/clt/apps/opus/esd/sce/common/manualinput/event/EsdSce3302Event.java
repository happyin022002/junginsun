/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdSce3003Event.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 *
 * @author YoungHeon Lee
 * @see ESD_SCE_3301HTMLAction reference
 * @since J2EE 1.6
 */
public class EsdSce3302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ActivityGroupVO activityGroupVO = null;
	
	private ActivityGroupVO[] activityGroupVOs = null;
	
	public ActivityGroupVO getActivityGroupVO() {
		return activityGroupVO;
	}

	public void setActivityGroupVO(ActivityGroupVO activityGroupVO) {
		this.activityGroupVO = activityGroupVO;
	}

	public ActivityGroupVO[] getActivityGroupVOs() {
		ActivityGroupVO[] rtnVOs = null;
		if (this.activityGroupVOs != null) {
			rtnVOs = Arrays.copyOf(activityGroupVOs, activityGroupVOs.length);
		}
		return rtnVOs;
	}

	public void setActivityGroupVOs(ActivityGroupVO[] activityGroupVOs) {
		if(activityGroupVOs != null){
			ActivityGroupVO[] tmpVOs = Arrays.copyOf(activityGroupVOs, activityGroupVOs.length);
			this.activityGroupVOs = tmpVOs;
		}
	}

}