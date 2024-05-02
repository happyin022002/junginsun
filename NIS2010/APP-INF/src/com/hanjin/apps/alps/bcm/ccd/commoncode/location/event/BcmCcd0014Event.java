/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0014Event.java
*@FileTitle : contient
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
  
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ContinentVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0014Event(){}
	
	private String contiCd = null;

	private ContinentVO continentVO = null;
	
	public String getContiCd() {
		return contiCd;
	}

	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	public ContinentVO getContinentVO() {
		return continentVO;
	}

	public void setContinentVO(ContinentVO continentVO) {
		this.continentVO = continentVO;
	}

}