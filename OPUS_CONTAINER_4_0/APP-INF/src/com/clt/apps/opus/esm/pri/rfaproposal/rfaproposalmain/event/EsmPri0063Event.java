/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0063Event.java
*@FileTitle : TPW Group Commodity Guideline Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.22 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;


/**
 * ESM_PRI_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtVO priSgGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgGrpCmdtVO[] priSgGrpCmdtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpCmdtVO priSpScpGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMnVO priSpScpMnVO = null;	

	   /** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO = null;
    
	public EsmPri0063Event(){}
	
	public void setPriSgGrpCmdtVO(PriSgGrpCmdtVO priSgGrpCmdtVO){
		this. priSgGrpCmdtVO = priSgGrpCmdtVO;
	}

	public void setPriSgGrpCmdtVOS(PriSgGrpCmdtVO[] priSgGrpCmdtVOs){
		if (priSgGrpCmdtVOs != null) {
			PriSgGrpCmdtVO[] tmpVOs = new PriSgGrpCmdtVO[priSgGrpCmdtVOs.length];
			System.arraycopy(priSgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGrpCmdtVOs = tmpVOs;
		}

	}

	public void setPriSpScpGrpCmdtDtlVO(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO){
		this. priSpScpGrpCmdtDtlVO = priSpScpGrpCmdtDtlVO;
	}

	public void setPriSpScpGrpCmdtVO(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO){
		this. priSpScpGrpCmdtVO = priSpScpGrpCmdtVO;
	}
	
	public void setPriSpScpGrpCmdtDtlVOS(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs){
		if (priSpScpGrpCmdtDtlVOs != null) {
			PriSpScpGrpCmdtDtlVO[] tmpVOs = new PriSpScpGrpCmdtDtlVO[priSpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priSpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGrpCmdtDtlVOs = tmpVOs;
		}

	}

	public void setPriSgGrpCmdtDtlVO(PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public void setPriSgGrpCmdtDtlVOS(PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs){
		if (priSgGrpCmdtDtlVOs != null) {
			PriSgGrpCmdtDtlVO[] tmpVOs = new PriSgGrpCmdtDtlVO[priSgGrpCmdtDtlVOs.length];
			System.arraycopy(priSgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGrpCmdtDtlVOs = tmpVOs;
		}
	}

	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}
	
	public PriSgGrpCmdtVO getPriSgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}

	public PriSgGrpCmdtVO[] getPriSgGrpCmdtVOS(){
		PriSgGrpCmdtVO[] tmpVOs = null;
		if (this.priSgGrpCmdtVOs != null) {
			tmpVOs = new PriSgGrpCmdtVO[priSgGrpCmdtVOs.length];
			System.arraycopy(priSgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpGrpCmdtDtlVO getPriSpScpGrpCmdtDtlVO(){
		return priSpScpGrpCmdtDtlVO;
	}

	public PriSpScpGrpCmdtVO getPriSpScpGrpCmdtVO(){
		return priSpScpGrpCmdtVO;
	}
	
	public PriSpScpGrpCmdtDtlVO[] getPriSpScpGrpCmdtDtlVOS(){
		PriSpScpGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priSpScpGrpCmdtDtlVOs != null) {
			tmpVOs = new PriSpScpGrpCmdtDtlVO[priSpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priSpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSgGrpCmdtDtlVO getPriSgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}

	public PriSgGrpCmdtDtlVO[] getPriSgGrpCmdtDtlVOS(){
		PriSgGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priSgGrpCmdtDtlVOs != null) {
			tmpVOs = new PriSgGrpCmdtDtlVO[priSgGrpCmdtDtlVOs.length];
			System.arraycopy(priSgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpMnVO getPriSpScpMnVO(){
		return priSpScpMnVO;
	}

    /**
     * @return the rsltPriSgGrpCmdtVO
     */
    public RsltPriSgGrpCmdtVO getRsltPriSgGrpCmdtVO () {
        return rsltPriSgGrpCmdtVO;
    }

    /**
     * @param rsltPriSgGrpCmdtVO the rsltPriSgGrpCmdtVO to set
     */
    public void setRsltPriSgGrpCmdtVO (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) {
        this.rsltPriSgGrpCmdtVO = rsltPriSgGrpCmdtVO;
    }
}