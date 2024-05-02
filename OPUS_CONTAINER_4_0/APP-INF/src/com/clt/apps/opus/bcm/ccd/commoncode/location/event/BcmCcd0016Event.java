/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0016Event.java
*@FileTitle : country
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
import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.CountryVO;

/**
 * BCM_CCD_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0016Event(){}
	
	private String cntCd = null;
	
	private String scontiCd = null;
	
	private String currCd = null;
	
	private CountryVO countryVO = null;

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public CountryVO getCountryVO() {
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}

	public String getScontiCd() {
		return scontiCd;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	
}