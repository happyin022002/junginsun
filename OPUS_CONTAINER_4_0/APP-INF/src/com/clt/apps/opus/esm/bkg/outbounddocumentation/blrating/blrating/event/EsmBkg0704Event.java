/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0704Event.java
*@FileTitle : DOC Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2015.11.06 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0704 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0704HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see ESM_BKG_0704HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0704Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RateMainInfoVO rateMainInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private RateMainInfoVO[] rateMainInfoVOs = null;
	
	private String caFlg = null;

	public EsmBkg0704Event(){}

	public void setRateMainInfoVO(RateMainInfoVO rateMainInfoVO){
		this. rateMainInfoVO = rateMainInfoVO;
	}

	public void setRateMainInfoVOS(RateMainInfoVO[] rateMainInfoVOs){
		if(rateMainInfoVOs != null){
			RateMainInfoVO[] tmpVOs = Arrays.copyOf(rateMainInfoVOs, rateMainInfoVOs.length);
			this.rateMainInfoVOs = tmpVOs;
		}
	}

	public RateMainInfoVO getRateMainInfoVO(){
		return rateMainInfoVO;
	}

	public RateMainInfoVO[] getRateMainInfoVOS(){
		RateMainInfoVO[] rtnVOs = null;
		if(this.rateMainInfoVOs != null){
			rtnVOs = Arrays.copyOf(rateMainInfoVOs, rateMainInfoVOs.length);
		}
		return rtnVOs;
	}

	public String getCaFlg() {
		return caFlg;
	}

	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	

}