/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0042Event.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.19
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.19
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfcAccGrpMapVO ofcAccGrpMapVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfcAccGrpMapVO[] ofcAccGrpMapVOs = null;   

	private String sybSysCd = null;
	
	private String ofcGrpId = null;
	
	private String hiddenOfcCd = null;
	
	public BcmCcd0042Event(){}
	
	
	
	

	public String getHiddenOfcCd() {
		return hiddenOfcCd;
	}

	public void setHiddenOfcCd(String hiddenOfcCd) {
		this.hiddenOfcCd = hiddenOfcCd;
	}

	public String getOfcGrpId() {
		return ofcGrpId;
	}

	public void setOfcGrpId(String ofcGrpId) {
		this.ofcGrpId = ofcGrpId;
	}	
	
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
	
	public String getSybSysCd() {
		return sybSysCd;
	}

	public void setSybSysCd(String sybSysCd) {
		this.sybSysCd = sybSysCd;
	}

}