/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005710Event.java
*@FileTitle : Amendment History Inquiry - Loding Agent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo.RsltSvcScpCdCntVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpLodgAgnVO;


/**
 * ESM_PRI_0057_10 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_10HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0057_10HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005710Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltLodgAgnListVO rsltLodgAgnListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltLodgAgnListVO[] rsltLodgAgnListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpLodgAgnVO priSpScpLodgAgnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpLodgAgnVO[] priSpScpLodgAgnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSvcScpCdCntVO rsltSvcScpCdCntVO = null;

	public EsmPri005710Event(){}
	
	public void setPriSpScpLodgAgnVO(PriSpScpLodgAgnVO priSpScpLodgAgnVO){
		this. priSpScpLodgAgnVO = priSpScpLodgAgnVO;
	}

	public void setPriSpScpLodgAgnVOS(PriSpScpLodgAgnVO[] priSpScpLodgAgnVOs){
		if (priSpScpLodgAgnVOs != null) {
			PriSpScpLodgAgnVO[] tmpVOs = new PriSpScpLodgAgnVO[priSpScpLodgAgnVOs.length];
			System.arraycopy(priSpScpLodgAgnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpLodgAgnVOs = tmpVOs;
		}
	}

	public PriSpScpLodgAgnVO getPriSpScpLodgAgnVO(){
		return priSpScpLodgAgnVO;
	}

	public PriSpScpLodgAgnVO[] getPriSpScpLodgAgnVOS(){
		PriSpScpLodgAgnVO[] tmpVOs = null;
		if (this.priSpScpLodgAgnVOs != null) {
			tmpVOs = new PriSpScpLodgAgnVO[priSpScpLodgAgnVOs.length];
			System.arraycopy(priSpScpLodgAgnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltLodgAgnListVO getRsltLodgAgnListVO() {
		return rsltLodgAgnListVO;
	}

	public RsltLodgAgnListVO[] getRsltLodgAgnListVOs() {
		RsltLodgAgnListVO[] tmpVOs = null;
		if (this.rsltLodgAgnListVOs != null) {
			tmpVOs = new RsltLodgAgnListVO[rsltLodgAgnListVOs.length];
			System.arraycopy(rsltLodgAgnListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltLodgAgnListVO(RsltLodgAgnListVO rsltLodgAgnListVO) {
		this.rsltLodgAgnListVO = rsltLodgAgnListVO;
	}

	public void setRsltLodgAgnListVOs(RsltLodgAgnListVO[] rsltLodgAgnListVOs) {
		if (rsltLodgAgnListVOs != null) {
			RsltLodgAgnListVO[] tmpVOs = new RsltLodgAgnListVO[rsltLodgAgnListVOs.length];
			System.arraycopy(rsltLodgAgnListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltLodgAgnListVOs = tmpVOs;
		}
	}

	public RsltSvcScpCdCntVO getRsltSvcScpCdCntVO() {
		return rsltSvcScpCdCntVO;
	}

	public void setRsltSvcScpCdCntVO(RsltSvcScpCdCntVO rsltSvcScpCdCntVO) {
		this.rsltSvcScpCdCntVO = rsltSvcScpCdCntVO;
	}



}