/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0110Event.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event;

import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassBkgDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see ESD_TRS_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0110Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OptmRoutPassBkgDtlVO optmRoutPassBkgDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OptmRoutPassBkgDtlVO[] optmRoutPassBkgDtlVOs = null;
	private OptmRoutPassCondVO optmRoutPassCondVO = null;
	
	public EsdTrs0110Event(){}
	
	/* OptmRoutPassBkgDtlVO - start */
	public void setOptmRoutPassBkgDtlVO(OptmRoutPassBkgDtlVO optmRoutPassBkgDtlVO){
		this. optmRoutPassBkgDtlVO = optmRoutPassBkgDtlVO;
	}

	public void setOptmRoutPassBkgDtlVOS(OptmRoutPassBkgDtlVO[] optmRoutPassBkgDtlVOs){
		this. optmRoutPassBkgDtlVOs = optmRoutPassBkgDtlVOs;
	}

	public OptmRoutPassBkgDtlVO getOptmRoutPassBkgDtlVO(){
		return optmRoutPassBkgDtlVO;
	}

	public OptmRoutPassBkgDtlVO[] getOptmRoutPassBkgDtlVOS(){
		return optmRoutPassBkgDtlVOs;
	}
	/* OptmRoutPassBkgDtlVO - end */

	public void setOptmRoutPassCondVO(OptmRoutPassCondVO optmRoutPassCondVO) {
		this.optmRoutPassCondVO = optmRoutPassCondVO;
	}
	
	public OptmRoutPassCondVO getOptmRoutPassCondVO() {
		return optmRoutPassCondVO;
	}	
}
