/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0017Event.java
*@FileTitle : region
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.RegionVO;


/**
 * BCM_CCD_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0017Event(){}
	
	private String rgnCd = null;
	
	private String cntCd = null;
	
	private RegionVO regionVO = null;

	public String getRgnCd() {
		return rgnCd;
	}

	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}

	public RegionVO getRegionVO() {
		return regionVO;
	}

	public void setRegionVO(RegionVO regionVO) {
		this.regionVO = regionVO;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

}