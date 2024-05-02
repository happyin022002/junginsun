/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmPri2019Event.java
*@FileTitle : RFA Proposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.08.05 이관샨
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;


/**
 * ESM_PRI_2020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Kuan Sian
 * @see ESM_PRI_2020HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//CstShRInqVO

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpMnVO priRpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO[] priRpMnVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs = null;	

	public PriRpScpAmdtSmryVO getPriRpScpAmdtSmryVO() {
		return priRpScpAmdtSmryVO;
	}

	public void setPriRpScpAmdtSmryVO(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) {
		this.priRpScpAmdtSmryVO = priRpScpAmdtSmryVO;
	}

	public PriRpScpAmdtSmryVO[] getPriRpScpAmdtSmryVOs() {
		PriRpScpAmdtSmryVO[] rtnVOs = null;
		if (this.priRpScpAmdtSmryVOs != null) {
			rtnVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpScpAmdtSmryVOs(PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs){
		if(priRpScpAmdtSmryVOs != null){
			PriRpScpAmdtSmryVO[] tmpVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpAmdtSmryVOs = tmpVOs;
		}
	}

	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
	}

	public PriRpMnVO[] getPriRpMnVOs() {
		PriRpMnVO[] rtnVOs = null;
		if (this.priRpMnVOs != null) {
			rtnVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpMnVOs(PriRpMnVO[] priRpMnVOs){
		if(priRpMnVOs != null){
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}

	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}

	public PriRpHdrVO[] getPriRpHdrVOs() {
		PriRpHdrVO[] rtnVOs = null;
		if (this.priRpHdrVOs != null) {
			rtnVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpHdrVOs(PriRpHdrVO[] priRpHdrVOs){
		if(priRpHdrVOs != null){
			PriRpHdrVO[] tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpHdrVOs = tmpVOs;
		}
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpHdrVO priRpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpHdrVO[] priRpHdrVOs = null;

	

}