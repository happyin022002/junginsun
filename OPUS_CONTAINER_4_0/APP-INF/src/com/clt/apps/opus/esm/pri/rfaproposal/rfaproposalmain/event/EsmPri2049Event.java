/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2049Event.java
*@FileTitle : RFA Proposal Creation - Request Received and Sent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.05 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpAproRqstRefVO;


/**
 * ESM_PRI_2049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAproRqstRefVO priRpAproRqstRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAproRqstRefVO[] priRpAproRqstRefVOs = null;
	
    /** Custom Value Object 조회 조건 및 단건 처리  */
    private RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO = null;
    
    /** Custom Value Object Multi Data 처리 */
    private RsltRfaAproRqstRefVO[] rsltRfaAproRqstRefVOs = null;
	

	public EsmPri2049Event(){}
	
	public void setPriRpAproRqstRefVO(PriRpAproRqstRefVO priRpAproRqstRefVO){
		this. priRpAproRqstRefVO = priRpAproRqstRefVO;
	}

	public void setPriRpAproRqstRefVOS(PriRpAproRqstRefVO[] priRpAproRqstRefVOs){
		if (priRpAproRqstRefVOs != null) {
			PriRpAproRqstRefVO[] tmpVOs = new PriRpAproRqstRefVO[priRpAproRqstRefVOs.length];
			System.arraycopy(priRpAproRqstRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAproRqstRefVOs = tmpVOs;
		}
	}

	public PriRpAproRqstRefVO getPriRpAproRqstRefVO(){
		return priRpAproRqstRefVO;
	}

	public PriRpAproRqstRefVO[] getPriRpAproRqstRefVOS(){
		PriRpAproRqstRefVO[] tmpVOs = null;
		if (this.priRpAproRqstRefVOs != null) {
			tmpVOs = new PriRpAproRqstRefVO[priRpAproRqstRefVOs.length];
			System.arraycopy(priRpAproRqstRefVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @return the rsltRfaAproRqstRefVO
     */
    public RsltRfaAproRqstRefVO getRsltRfaAproRqstRefVO () {
        return rsltRfaAproRqstRefVO;
    }

    /**
     * @param rsltRfaAproRqstRefVO the rsltRfaAproRqstRefVO to set
     */
    public void setRsltRfaAproRqstRefVO (RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) {
        this.rsltRfaAproRqstRefVO = rsltRfaAproRqstRefVO;
    }

    /**
     * @return the rsltRfaAproRqstRefVOs
     */
    public RsltRfaAproRqstRefVO[] getRsltRfaAproRqstRefVOs () {
    	RsltRfaAproRqstRefVO[] tmpVOs = null;
		if (this.rsltRfaAproRqstRefVOs != null) {
			tmpVOs = new RsltRfaAproRqstRefVO[rsltRfaAproRqstRefVOs.length];
			System.arraycopy(rsltRfaAproRqstRefVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
     * @param rsltRfaAproRqstRefVOs the rsltRfaAproRqstRefVOs to set
     */
    public void setRsltRfaAproRqstRefVOs (RsltRfaAproRqstRefVO[] rsltRfaAproRqstRefVOs) {
    	if (rsltRfaAproRqstRefVOs != null) {
    		RsltRfaAproRqstRefVO[] tmpVOs = new RsltRfaAproRqstRefVO[rsltRfaAproRqstRefVOs.length];
			System.arraycopy(rsltRfaAproRqstRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaAproRqstRefVOs = tmpVOs;
		}
    }

}