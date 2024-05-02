/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_010Event.java
*@FileTitle : Agent Commission Maintenance & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-01 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnCommVO;

/**
 * ESM_AGT_010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0010Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	 /** Agt_Agn_Comm_Dtl Table Value Object 조회 조건 및 단건 처리  */
	private AgtCommListVO agtCommListVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;
	
	/** Agt_Agn_Comm_Dtl Table Value Object Multi Data 처리 */
	private AgtCommListVO[] agtCommListVOs = null;
	
	public EsmAgt0010Event(){}
	
	public void setAgtAgnCommVO(AgtAgnCommVO agtAgnCommVO){
		this. agtAgnCommVO = agtAgnCommVO;
	}

	public void setAgtAgnCommVOS(AgtAgnCommVO[] agtAgnCommVOs){
		this. agtAgnCommVOs = agtAgnCommVOs;
	}

	public AgtAgnCommVO getAgtAgnCommVO(){
		return agtAgnCommVO;
	}

	public AgtAgnCommVO[] getAgtAgnCommVOS(){
		return agtAgnCommVOs;
	}
	
	
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
