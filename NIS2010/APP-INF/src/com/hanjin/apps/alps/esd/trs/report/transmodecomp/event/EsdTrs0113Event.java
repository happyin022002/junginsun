/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0113Event.java
*@FileTitle : Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.transmodecomp.event;

import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompCondVO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see ESD_TRS_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0113Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrnsModCompVO TrnsModCompVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrnsModCompVO[] TrnsModCompVOs = null;
	private TrnsModCompCondVO TrnsModCompCondVO = null;
	
	public EsdTrs0113Event(){}
	
	/* TrnsModCompVO - start */
	public void setTrnsModCompVO(TrnsModCompVO TrnsModCompVO){
		this. TrnsModCompVO = TrnsModCompVO;
	}

	public void setTrnsModCompVOS(TrnsModCompVO[] TrnsModCompVOs){
		this. TrnsModCompVOs = TrnsModCompVOs;
	}

	public TrnsModCompVO getTrnsModCompVO(){
		return TrnsModCompVO;
	}

	public TrnsModCompVO[] getTrnsModCompVOS(){
		return TrnsModCompVOs;
	}
	/* TrnsModCompVO - end */

	public void setTrnsModCompCondVO(TrnsModCompCondVO TrnsModCompCondVO) {
		this.TrnsModCompCondVO = TrnsModCompCondVO;
	}
	
	public TrnsModCompCondVO getTrnsModCompCondVO() {
		return TrnsModCompCondVO;
	}	
}
