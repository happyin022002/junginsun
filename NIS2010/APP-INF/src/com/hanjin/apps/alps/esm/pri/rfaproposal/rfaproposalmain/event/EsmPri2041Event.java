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
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;


/**
 * ESM_PRI_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = null;
	
	
	public PriRpScpAmdtSmryVO getPriRpScpAmdtSmryVO() {
		return priRpScpAmdtSmryVO;
	}

	public void setPriRpScpAmdtSmryVO(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) {
		this.priRpScpAmdtSmryVO = priRpScpAmdtSmryVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpMnVO priRpMnVO = null;
	
	
	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
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
	private PriRpHdrVO priRpHdrVO = null;

	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}
	
	


}