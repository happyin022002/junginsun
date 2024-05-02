/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0005Event.java
*@FileTitle : Sales Rep List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.06.15 이관샨
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.SamCustSRepVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEEKUANSIAN
 * @see ESM_SAM_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamCustSRepVO samCustSRepVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamCustSRepVO[] samCustSRepVOs = null;
	
	private String hiddenOfcCd = null;

	public String getHiddenOfcCd() {
		return hiddenOfcCd;
	}

	public void setHiddenOfcCd(String hiddenOfcCd) {
		this.hiddenOfcCd = hiddenOfcCd;
	}

	public EsmSam0005Event(){}
	
	public SamCustSRepVO getSamCustSRepVO() {
		return samCustSRepVO;
	}

	public void setSamCustSRepVO(SamCustSRepVO samCustSRepVO) {
		this.samCustSRepVO = samCustSRepVO;
	}

	public SamCustSRepVO[] getSamCustSRepVOs() {
		SamCustSRepVO[] rtnVOs = null;
		if (this.samCustSRepVOs != null) {
			rtnVOs = Arrays.copyOf(samCustSRepVOs, samCustSRepVOs.length);
		}
		return rtnVOs;
	}

	public void setSamCustSRepVOs(SamCustSRepVO[] samCustSRepVOs) {
		if(samCustSRepVOs != null){
			SamCustSRepVO[] tmpVOs = Arrays.copyOf(samCustSRepVOs, samCustSRepVOs.length);
			this.samCustSRepVOs = tmpVOs;
		}
	}

}