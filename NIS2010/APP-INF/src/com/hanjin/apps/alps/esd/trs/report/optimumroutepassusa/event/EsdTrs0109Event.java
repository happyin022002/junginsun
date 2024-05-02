/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0109Event.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event;

import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see ESD_TRS_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0109Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OptmRoutPassDtlVO optmRoutPassDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OptmRoutPassDtlVO[] optmRoutPassDtlVOs = null;
	private OptmRoutPassCondVO optmRoutPassCondVO = null;
	
	public EsdTrs0109Event(){}
	
	/* OptmRoutPassDtlVO - start */
	public void setOptmRoutPassDtlVO(OptmRoutPassDtlVO optmRoutPassDtlVO){
		this. optmRoutPassDtlVO = optmRoutPassDtlVO;
	}

	public void setOptmRoutPassDtlVOS(OptmRoutPassDtlVO[] optmRoutPassDtlVOs){
		this. optmRoutPassDtlVOs = optmRoutPassDtlVOs;
	}

	public OptmRoutPassDtlVO getOptmRoutPassDtlVO(){
		return optmRoutPassDtlVO;
	}

	public OptmRoutPassDtlVO[] getOptmRoutPassDtlVOS(){
		return optmRoutPassDtlVOs;
	}
	/* OptmRoutPassDtlVO - end */

	public void setOptmRoutPassCondVO(OptmRoutPassCondVO optmRoutPassCondVO) {
		this.optmRoutPassCondVO = optmRoutPassCondVO;
	}
	
	public OptmRoutPassCondVO getOptmRoutPassCondVO() {
		return optmRoutPassCondVO;
	}	
}
