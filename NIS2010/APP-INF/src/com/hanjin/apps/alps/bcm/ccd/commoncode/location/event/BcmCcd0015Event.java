/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0015Event.java
*@FileTitle : sub contient
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
  
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.SubContinentVO;


/**
 * BCM_CCD_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0015Event(){}
	
	private String scontiCd = null;

	private SubContinentVO subContinentVO = null;

	public String getScontiCd() {
		return scontiCd;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}

	public SubContinentVO getSubContinentVO() {
		return subContinentVO;
	}

	public void setSubContinentVO(SubContinentVO subContinentVO) {
		this.subContinentVO = subContinentVO;
	}
	
	

}