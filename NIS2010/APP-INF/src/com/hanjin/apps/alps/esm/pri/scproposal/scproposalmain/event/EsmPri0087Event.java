/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmPri0087Event.java
*@FileTitle : S/C Proposal & Amendment View
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.08.09 김민아
* 1.0 Creation
===========================================================
* History
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
===========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;


/**
 * ESM_PRI_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0087HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	
	
	public EsmPri0087Event(){}
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}
	
	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO) {
		this.priSpHdrVO = priSpHdrVO;
	}
	
	public void setPriSpScpAmdtSmryVO(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) {
		this.priSpScpAmdtSmryVO = priSpScpAmdtSmryVO;
	}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}

	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}
	
	public PriSpHdrVO getPriSpHdrVO() {
		return priSpHdrVO;
	}

	public PriSpScpAmdtSmryVO getPriSpScpAmdtSmryVO() {
		return priSpScpAmdtSmryVO;
	}

	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}
}