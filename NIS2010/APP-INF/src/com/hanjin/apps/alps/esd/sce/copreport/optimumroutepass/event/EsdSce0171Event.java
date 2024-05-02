/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0171Event.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.event;

import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SCE_0171 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_0171HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_SCE_0171HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0171Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OptmRoutPassDtlVO optmRoutPassDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OptmRoutPassDtlVO[] optmRoutPassDtlVOs = null;
	private OptmRoutPassCondVO optmRoutPassCondVO = null;
	
	public EsdSce0171Event(){}
	
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
