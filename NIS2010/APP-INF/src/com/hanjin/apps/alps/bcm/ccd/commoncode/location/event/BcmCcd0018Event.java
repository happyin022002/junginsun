/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0018Event.java
*@FileTitle : state
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
  
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0018Event(){}
	
	private String steCd = null;

	private String cntCd = null;
	
	private StateVO stateVO = null;

	public String getSteCd() {
		return steCd;
	}

	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

}