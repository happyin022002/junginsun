/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_039Event.java
*@FileTitle : Agent Commission Maintenance & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-21
*@LastModifier : JungHyung,Kim
*@LastVersion : 1.0
* 2007-02-21 JungHyung,Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtAgnCommVO;

/**
 * ESM_AGT_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0039Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	 /** Agt_Agn_Comm_Dtl Table Value Object 조회 조건 및 단건 처리  */
	private AgtCommListVO agtCommListVO = null;
	
	/** Agt_Agn_Comm_Dtl Table Value Object Multi Data 처리 */
	private AgtCommListVO[] agtCommListVOs = null;
	
	public EsmAgt0039Event(){}
	
	public void setAgtCommListVO(AgtCommListVO agtCommListVO){
		this. agtCommListVO = agtCommListVO;
	}

	public void setAgtCommListVOS(AgtCommListVO[] agtCommListVOs){
		this. agtCommListVOs = agtCommListVOs;
	}

	public AgtCommListVO getAgtCommListVO(){
		return agtCommListVO;
	}

	public AgtCommListVO[] getAgtCommListVOS(){
		return agtCommListVOs;
	}
}
