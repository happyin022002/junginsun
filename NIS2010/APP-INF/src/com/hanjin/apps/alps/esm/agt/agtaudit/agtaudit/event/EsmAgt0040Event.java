/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0040Event.java
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.20 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtCommBkgInfoVO;
import com.hanjin.syscommon.common.table.AgtRptItmInfoDtlVO;


/**
 * ESM_AGT_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtCommBkgInfoVO agtCommBkgInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtCommBkgInfoVO[] agtCommBkgInfoVOs = null;

	public EsmAgt0040Event(){}
	
	public void setAgtCommBkgInfoVO(AgtCommBkgInfoVO agtCommBkgInfoVO){
		this. agtCommBkgInfoVO = agtCommBkgInfoVO;
	}

	public void setAgtCommBkgInfoVOS(AgtCommBkgInfoVO[] agtCommBkgInfoVOs){
		this. agtCommBkgInfoVOs = agtCommBkgInfoVOs;
	}

	public AgtCommBkgInfoVO getAgtCommBkgInfoVO(){
		return agtCommBkgInfoVO;
	}

	public AgtCommBkgInfoVO[] getAgtCommBkgInfoVOS(){
		return agtCommBkgInfoVOs;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtRptItmInfoDtlVO agtRptItmInfoDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtRptItmInfoDtlVO[] agtRptItmInfoDtlVOs = null;

	public void setAgtRptItmInfoDtlVO(AgtRptItmInfoDtlVO agtRptItmInfoDtlVO){
		this. agtRptItmInfoDtlVO = agtRptItmInfoDtlVO;
	}

	public void setAgtRptItmInfoDtlVOS(AgtRptItmInfoDtlVO[] agtRptItmInfoDtlVOs){
		this. agtRptItmInfoDtlVOs = agtRptItmInfoDtlVOs;
	}

	public AgtRptItmInfoDtlVO getAgtRptItmInfoDtlVO(){
		return agtRptItmInfoDtlVO;
	}

	public AgtRptItmInfoDtlVO[] getAgtRptItmInfoDtlVOS(){
		return agtRptItmInfoDtlVOs;
	}

}