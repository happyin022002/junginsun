/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0112Event.java
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.scgreport.event;

import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgCondVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see ESD_TRS_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0112Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgDtlVO ScgDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgDtlVO[] ScgDtlVOs = null;
	private ScgCondVO ScgCondVO = null;
	
	public EsdTrs0112Event(){}
	
	/* ScgDtlVO - start */
	public void setScgDtlVO(ScgDtlVO ScgDtlVO){
		this. ScgDtlVO = ScgDtlVO;
	}

	public void setScgDtlVOS(ScgDtlVO[] ScgDtlVOs){
		this. ScgDtlVOs = ScgDtlVOs;
	}

	public ScgDtlVO getScgDtlVO(){
		return ScgDtlVO;
	}

	public ScgDtlVO[] getScgDtlVOS(){
		return ScgDtlVOs;
	}
	/* ScgDtlVO - end */

	public void setScgCondVO(ScgCondVO ScgCondVO) {
		this.ScgCondVO = ScgCondVO;
	}
	
	public ScgCondVO getScgCondVO() {
		return ScgCondVO;
	}	
}
