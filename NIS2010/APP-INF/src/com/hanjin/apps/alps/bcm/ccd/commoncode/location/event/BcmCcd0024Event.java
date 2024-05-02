/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0024Event.java
*@FileTitle : daylight saving time
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;

import java.util.Arrays;

import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public BcmCcd0024Event(){}
	
	private String dstId = null;
	
	private String dstCntCd = null;
	
	private String dstNotAplySteCd = null;
	
	private DaySavingTimeVO dystVO = null;
	private DaySavingTimeVO[] dystVOS = null;

	public DaySavingTimeVO[] getDystVOS() {
		 
		DaySavingTimeVO[] rtnVOs = null;
		if(this.dystVOS != null){
			rtnVOs= Arrays.copyOf(dystVOS, dystVOS.length);
		}
		return rtnVOs;
		
	}

	public void setDystVOS(DaySavingTimeVO[] dystVOS) {
		if(dystVOS != null){
			DaySavingTimeVO[] tmpVOs = Arrays.copyOf(dystVOS, dystVOS.length);
			this.dystVOS = tmpVOs;
		}
	}

	public String getDstId() {
		return dstId;
	}

	public void setDstId(String dstId) {
		this.dstId = dstId;
	}

	public String getDstCntCd() {
		return dstCntCd;
	}

	public void setDstCntCd(String dstCntCd) {
		this.dstCntCd = dstCntCd;
	}

	public String getDstNotAplySteCd() {
		return dstNotAplySteCd;
	}

	public void setDstNotAplySteCd(String dstNotAplySteCd) {
		this.dstNotAplySteCd = dstNotAplySteCd;
	}

	public DaySavingTimeVO getDystVO() {
		return dystVO;
	}

	public void setDystVO(DaySavingTimeVO dystVO) {
		this.dystVO = dystVO;
	}
	
}