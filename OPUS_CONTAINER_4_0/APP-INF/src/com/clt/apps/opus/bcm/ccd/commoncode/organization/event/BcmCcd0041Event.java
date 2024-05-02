/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0041Event.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.19
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.19
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.organization.event;

import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfcAccGrpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0041Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfcAccGrpVO ofcAccGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfcAccGrpVO[] ofcAccGrpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfcAccGrpMapVO ofcAccGrpMapVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfcAccGrpMapVO[] ofcAccGrpMapVOs = null;   
	
	public OfcAccGrpMapVO getOfcAccGrpMapVO() {
		return ofcAccGrpMapVO;
	}

	public void setOfcAccGrpMapVO(OfcAccGrpMapVO ofcAccGrpMapVO) {
		this.ofcAccGrpMapVO = ofcAccGrpMapVO;
	}

	public OfcAccGrpMapVO[] getOfcAccGrpMapVOs() {
		OfcAccGrpMapVO[] rtnVOs = null;
		if (this.ofcAccGrpMapVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(ofcAccGrpMapVOs, ofcAccGrpMapVOs.length);
		}
		return rtnVOs;
	}

	public void setOfcAccGrpMapVOs(OfcAccGrpMapVO[] ofcAccGrpMapVOs){
		if(ofcAccGrpMapVOs != null){
			OfcAccGrpMapVO[] tmpVOs = java.util.Arrays.copyOf(ofcAccGrpMapVOs, ofcAccGrpMapVOs.length);
			this.ofcAccGrpMapVOs = tmpVOs;
		}
	}

	private String sybSysCd = null;
	
	private String accGrpId = null;
	
	
	
	public OfcAccGrpVO getOfcAccGrpVO() {
		return ofcAccGrpVO;
	}

	public void setOfcAccGrpVO(OfcAccGrpVO ofcAccGrpVO) {
		this.ofcAccGrpVO = ofcAccGrpVO;
	}

	public OfcAccGrpVO[] getOfcAccGrpVOs() {
		OfcAccGrpVO[] rtnVOs = null;
		if (this.ofcAccGrpVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(ofcAccGrpVOs, ofcAccGrpVOs.length);
		}
		return rtnVOs;
	}

	public void setOfcAccGrpVOs(OfcAccGrpVO[] ofcAccGrpVOs){
		if(ofcAccGrpVOs != null){
			OfcAccGrpVO[] tmpVOs = java.util.Arrays.copyOf(ofcAccGrpVOs, ofcAccGrpVOs.length);
			this.ofcAccGrpVOs = tmpVOs;
		}
	}



	public String getSybSysCd() {
		return sybSysCd;
	}

	public void setSybSysCd(String sybSysCd) {
		this.sybSysCd = sybSysCd;
	}

	public String getAccGrpId() {
		return accGrpId;
	}

	public void setAccGrpId(String accGrpId) {
		this.accGrpId = accGrpId;
	}

}