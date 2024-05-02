/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0057Event.java
*@FileTitle : Amendment History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.01 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;


/**
 * ESM_PRI_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = null;
	
	
	public PriSpScpAmdtSmryVO getPriSpScpAmdtSmryVO() {
		return priSpScpAmdtSmryVO;
	}

	public void setPriSpScpAmdtSmryVO(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) {
		this.priSpScpAmdtSmryVO = priSpScpAmdtSmryVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	
	public PriSpMnVO getPriSpMnVO() {
		return priSpMnVO;
	}

	public void setPriSpMnVO(PriSpMnVO priSpMnVO) {
		this.priSpMnVO = priSpMnVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstShHistVO cstShHistVO = null;
	
	public CstShHistVO getCstShHistVO() {
		return cstShHistVO;
	}

	public void setCstShHistVO(CstShHistVO cstShHistVO) {
		this.cstShHistVO = cstShHistVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;

	public PriSpHdrVO getPriSpHdrVO() {
		return priSpHdrVO;
	}

	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO) {
		this.priSpHdrVO = priSpHdrVO;
	}
	
	


}