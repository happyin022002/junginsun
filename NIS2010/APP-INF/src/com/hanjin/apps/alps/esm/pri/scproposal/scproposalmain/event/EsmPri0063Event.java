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
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;


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
		this. priSgGrpCmdtVOs = priSgGrpCmdtVOs;
	}

	public void setPriSpScpGrpCmdtDtlVO(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO){
		this. priSpScpGrpCmdtDtlVO = priSpScpGrpCmdtDtlVO;
	}

	public void setPriSpScpGrpCmdtVO(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO){
		this. priSpScpGrpCmdtVO = priSpScpGrpCmdtVO;
	}
	
	public void setPriSpScpGrpCmdtDtlVOS(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs){
		this. priSpScpGrpCmdtDtlVOs = priSpScpGrpCmdtDtlVOs;
	}

	public void setPriSgGrpCmdtDtlVO(PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public void setPriSgGrpCmdtDtlVOS(PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs){
		this. priSgGrpCmdtDtlVOs = priSgGrpCmdtDtlVOs;
	}

	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}
	
	public PriSgGrpCmdtVO getPriSgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}

	public PriSgGrpCmdtVO[] getPriSgGrpCmdtVOS(){
		return priSgGrpCmdtVOs;
	}

	public PriSpScpGrpCmdtDtlVO getPriSpScpGrpCmdtDtlVO(){
		return priSpScpGrpCmdtDtlVO;
	}

	public PriSpScpGrpCmdtVO getPriSpScpGrpCmdtVO(){
		return priSpScpGrpCmdtVO;
	}
	
	public PriSpScpGrpCmdtDtlVO[] getPriSpScpGrpCmdtDtlVOS(){
		return priSpScpGrpCmdtDtlVOs;
	}

	public PriSgGrpCmdtDtlVO getPriSgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}

	public PriSgGrpCmdtDtlVO[] getPriSgGrpCmdtDtlVOS(){
		return priSgGrpCmdtDtlVOs;
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