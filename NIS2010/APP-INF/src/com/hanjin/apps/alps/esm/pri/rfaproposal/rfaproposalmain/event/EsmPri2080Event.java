/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2080Event.java
*@FileTitle : RFA Proposal Creation [G/L Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.09 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;


/**
 * ESM_PRI_2080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpMnVO priRpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpMnVO[] priRpScpMnVOs = null;

    /** Customer Value Object 조회 조건 및 단건 처리  */
    private RpScpGlineCopyVO rpScpGlineCopyVO = null;

	/** Customer Value Object Multi Data 처리 */
	private RpScpGlineCopyVO[] rpScpGlineCopyVOs = null;

	public EsmPri2080Event(){}
	
	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO){
		this. priRpScpMnVO = priRpScpMnVO;
	}

	public void setPriRpScpMnVOS(PriRpScpMnVO[] priRpScpMnVOs){
		if(priRpScpMnVOs != null){
			PriRpScpMnVO[] tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpMnVOs = tmpVOs;
		}
	}

	public PriRpScpMnVO getPriRpScpMnVO(){
		return priRpScpMnVO;
	}

	public PriRpScpMnVO[] getPriRpScpMnVOS(){
		PriRpScpMnVO[] rtnVOs = null;
		if (this.priRpScpMnVOs != null) {
			rtnVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the rpScpGlineCopyVO
     */
    public RpScpGlineCopyVO getRpScpGlineCopyVO () {
        return rpScpGlineCopyVO;
    }

    /**
     * @param rpScpGlineCopyVO the rpScpGlineCopyVO to set
     */
    public void setRpScpGlineCopyVO (RpScpGlineCopyVO rpScpGlineCopyVO) {
        this.rpScpGlineCopyVO = rpScpGlineCopyVO;
    }

    /**
     * @return the rpScpGlineCopyVOs
     */
    public RpScpGlineCopyVO[] getRpScpGlineCopyVOS() {
		RpScpGlineCopyVO[] rtnVOs = null;
		if (this.rpScpGlineCopyVOs != null) {
			rtnVOs = new RpScpGlineCopyVO[rpScpGlineCopyVOs.length];
			System.arraycopy(rpScpGlineCopyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rpScpGlineCopyVOs the rpScpGlineCopyVOs to set
     */
    public void setRpScpGlineCopyVOS(RpScpGlineCopyVO[] rpScpGlineCopyVOs){
		if(rpScpGlineCopyVOs != null){
			RpScpGlineCopyVO[] tmpVOs = new RpScpGlineCopyVO[rpScpGlineCopyVOs.length];
			System.arraycopy(rpScpGlineCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rpScpGlineCopyVOs = tmpVOs;
		}
    }

}