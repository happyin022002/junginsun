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

import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupMappingVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 *
 * @author YoungHeon Lee
 * @see ESD_SCE_3301HTMLAction reference
 * @since J2EE 1.6
 */
public class EsdSce3303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ActivityGroupMappingVO activityGroupMappingVO = null;
	
	private ActivityGroupMappingVO[] activityGroupMappingVOs = null;
	
	public ActivityGroupMappingVO getActivityGroupMappingVO() {
		return activityGroupMappingVO;
	}

	public void setActivityGroupMappingVO(ActivityGroupMappingVO activityGroupMappingVO) {
		this.activityGroupMappingVO = activityGroupMappingVO;
	}

	public ActivityGroupMappingVO[] getActivityGroupMappingVOs() {
		ActivityGroupMappingVO[] rtnVOs = null;
		if (this.activityGroupMappingVOs != null) {
			rtnVOs = Arrays.copyOf(activityGroupMappingVOs, activityGroupMappingVOs.length);
		}
		return rtnVOs;
	}

	public void setActivityGroupMappingVOs(ActivityGroupMappingVO[] activityGroupMappingVOs) {
		if(activityGroupMappingVOs != null){
			ActivityGroupMappingVO[] tmpVOs = Arrays.copyOf(activityGroupMappingVOs, activityGroupMappingVOs.length);
			this.activityGroupMappingVOs = tmpVOs;
		}
	}

}