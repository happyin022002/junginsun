/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TmpStd0001Event.java
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

import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 *
 * @author YoungHeon Lee
 * @see ESD_SCE_3301HTMLAction reference
 * @since J2EE 1.6
 */
public class EsdSce3301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ActualActivityMappingVO actualActivityMappingVO = null;
	
	private ActualActivityMappingVO[] actualActivityMappingVOs = null;
	
	public ActualActivityMappingVO getActualActivityMappingVO() {
		return actualActivityMappingVO;
	}

	public void setActualActivityMappingVO(ActualActivityMappingVO actualActivityMappingVO) {
		this.actualActivityMappingVO = actualActivityMappingVO;
	}

	public ActualActivityMappingVO[] getActualActivityMappingVOs() {
		ActualActivityMappingVO[] rtnVOs = null;
		if (this.actualActivityMappingVOs != null) {
			rtnVOs = Arrays.copyOf(actualActivityMappingVOs, actualActivityMappingVOs.length);
		}
		return rtnVOs;
	}

	public void setActualActivityMappingVOs(ActualActivityMappingVO[] actualActivityMappingVOs) {
		if(actualActivityMappingVOs != null){
			ActualActivityMappingVO[] tmpVOs = Arrays.copyOf(actualActivityMappingVOs, actualActivityMappingVOs.length);
			this.actualActivityMappingVOs = tmpVOs;
		}
	}

}