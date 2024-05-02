/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0039Event.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RptParaVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpHdrVO;


/**
 * ESM_PRI_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RptParaVO rptParaVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RptParaVO[] rptParaVOs = null;

	/** Table Value Object Multi Data 처리 */
	private PriSpHdrVO[] priSpHdrVOs = null;
	
	public EsmPri0039Event(){}
	
	public void setRptParaVO(RptParaVO rptParaVO){
		this. rptParaVO = rptParaVO;
	}
	
	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO){
		this. priSpHdrVO = priSpHdrVO;
	}

	public void setRptParaVOS(RptParaVO[] rptParaVOs){
		if (rptParaVOs != null) {
			RptParaVO[] tmpVOs = new RptParaVO[rptParaVOs.length];
			System.arraycopy(rptParaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rptParaVOs = tmpVOs;
		}
	}

	public void setPriSpHdrVOS(PriSpHdrVO[] priSpHdrVOs){
		if (priSpHdrVOs != null) {
			PriSpHdrVO[] tmpVOs = new PriSpHdrVO[priSpHdrVOs.length];
			System.arraycopy(priSpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpHdrVOs = tmpVOs;
		}
	}
	
	public RptParaVO getRptParaVO(){
		return rptParaVO;
	}
	
	public PriSpHdrVO getPriSpHdrVO(){
		return priSpHdrVO;
	}

	public RptParaVO[] getRptParaVOS(){
		RptParaVO[] tmpVOs = null;
		if (this.rptParaVOs != null) {
			tmpVOs = new RptParaVO[rptParaVOs.length];
			System.arraycopy(rptParaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpHdrVO[] getPriSpHdrVOS(){
		PriSpHdrVO[] tmpVOs = null;
		if (this.priSpHdrVOs != null) {
			tmpVOs = new PriSpHdrVO[priSpHdrVOs.length];
			System.arraycopy(priSpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}