/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0032Event.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.organization.event;

import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfficeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0032Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeVO officeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfficeVO[] officeVOs = null;
	
	private String hiddenOfcCd = null;
	
	
	
	
	public String getHiddenOfcCd() {
		return hiddenOfcCd;
	}

	public void setHiddenOfcCd(String hiddenOfcCd) {
		this.hiddenOfcCd = hiddenOfcCd;
	}

	public OfficeVO getOfficeVO() {
		return officeVO;
	}

	public void setOfficeVO(OfficeVO officeVO) {
		this.officeVO = officeVO;
	}

	public OfficeVO[] getOfficeVOs() {
		OfficeVO[] rtnVOs = null;
		if (this.officeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(officeVOs, officeVOs.length);
		}
		return rtnVOs;
	}

	public void setOfficeVOs(OfficeVO[] officeVOs){
		if(officeVOs != null){
			OfficeVO[] tmpVOs = java.util.Arrays.copyOf(officeVOs, officeVOs.length);
			this.officeVOs = tmpVOs;
		}
	}
}