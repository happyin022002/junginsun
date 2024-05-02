/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0018Event.java
*@FileTitle : S/C Proposal Creation - G/L Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.19 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpMnVO;


/**
 * ESM_PRI_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMnVO priSpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMnVO[] priSpScpMnVOs = null;

    /** Customer Value Object 조회 조건 및 단건 처리  */
    private SpScpGlineCopyVO spScpGlineCopyVO = null;

	/** Customer Value Object Multi Data 처리 */
	private SpScpGlineCopyVO[] spScpGlineCopyVOs = null;

	public EsmPri0018Event(){}
	
	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}

	public void setPriSpScpMnVOS(PriSpScpMnVO[] priSpScpMnVOs){
		if (priSpScpMnVOs != null) {
			PriSpScpMnVO[] tmpVOs = new PriSpScpMnVO[priSpScpMnVOs.length];
			System.arraycopy(priSpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpMnVOs = tmpVOs;
		}
	}

	public PriSpScpMnVO getPriSpScpMnVO(){
		return priSpScpMnVO;
	}

	public PriSpScpMnVO[] getPriSpScpMnVOS(){
		PriSpScpMnVO[] tmpVOs = null;
		if (this.priSpScpMnVOs != null) {
			tmpVOs = new PriSpScpMnVO[priSpScpMnVOs.length];
			System.arraycopy(priSpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @return the spScpGlineCopyVO
     */
    public SpScpGlineCopyVO getSpScpGlineCopyVO () {
        return spScpGlineCopyVO;
    }

    /**
     * @param spScpGlineCopyVO the spScpGlineCopyVO to set
     */
    public void setSpScpGlineCopyVO (SpScpGlineCopyVO spScpGlineCopyVO) {
        this.spScpGlineCopyVO = spScpGlineCopyVO;
    }

    /**
     * @return the spScpGlineCopyVOs
     */
    public SpScpGlineCopyVO[] getSpScpGlineCopyVOS () {
    	SpScpGlineCopyVO[] tmpVOs = null;
		if (this.spScpGlineCopyVOs != null) {
			tmpVOs = new SpScpGlineCopyVO[spScpGlineCopyVOs.length];
			System.arraycopy(spScpGlineCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
    
    

    /**
     * @param spScpGlineCopyVOs the spScpGlineCopyVOs to set
     */
    public void setSpScpGlineCopyVOS (SpScpGlineCopyVO[] spScpGlineCopyVOs) {
    	if (spScpGlineCopyVOs != null) {
    		SpScpGlineCopyVO[] tmpVOs = new SpScpGlineCopyVO[spScpGlineCopyVOs.length];
			System.arraycopy(spScpGlineCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spScpGlineCopyVOs = tmpVOs;
		}
	}

}