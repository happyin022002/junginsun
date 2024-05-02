/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2049Event.java
*@FileTitle : RFA Proposal Creation - Request Received and Sent
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.01.08 최성환 
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefByOfcVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefVO;


/**
 * ESM_PRI_2054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2054HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAproRqstRefVO priRpAproRqstRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAproRqstRefVO[] priRpAproRqstRefVOs = null;
	
    /** Custom Value Object 조회 조건 및 단건 처리  */
    private RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO = null;
    
    /** Custom Value Object Multi Data 처리 */
    private RsltRfaAproRqstRefByOfcVO[] rsltRfaAproRqstRefByOfcVOs = null;
	

	public EsmPri2054Event(){}
	
	public void setPriRpAproRqstRefVO(PriRpAproRqstRefVO priRpAproRqstRefVO){
		this. priRpAproRqstRefVO = priRpAproRqstRefVO;
	}

	public void setPriRpAproRqstRefVOS(PriRpAproRqstRefVO[] priRpAproRqstRefVOs){
		if(priRpAproRqstRefVOs != null){
			PriRpAproRqstRefVO[] tmpVOs = new PriRpAproRqstRefVO[priRpAproRqstRefVOs.length];
			System.arraycopy(priRpAproRqstRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAproRqstRefVOs = tmpVOs;
		}
	}

	public PriRpAproRqstRefVO getPriRpAproRqstRefVO(){
		return priRpAproRqstRefVO;
	}

	public PriRpAproRqstRefVO[] getPriRpAproRqstRefVOS(){
		PriRpAproRqstRefVO[] rtnVOs = null;
		if (this.priRpAproRqstRefVOs != null) {
			rtnVOs = new PriRpAproRqstRefVO[priRpAproRqstRefVOs.length];
			System.arraycopy(priRpAproRqstRefVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the RsltRfaAproRqstRefByOfcVO
     */
    public RsltRfaAproRqstRefByOfcVO getRsltRfaAproRqstRefByOfcVO () {
        return rsltRfaAproRqstRefByOfcVO;
    }

    /**
     * @param rsltRfaAproRqstRefByOfcVO the RsltRfaAproRqstRefByOfcVO to set
     */
    public void setRsltRfaAproRqstRefByOfcVO (RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO) {
        this.rsltRfaAproRqstRefByOfcVO = rsltRfaAproRqstRefByOfcVO;
    }

    /**
     * @return the rsltRfaAproRqstRefByOfcVOs
     */
    public RsltRfaAproRqstRefByOfcVO[] getRsltRfaAproRqstRefByOfcVOs() {
		RsltRfaAproRqstRefByOfcVO[] rtnVOs = null;
		if (this.rsltRfaAproRqstRefByOfcVOs != null) {
			rtnVOs = new RsltRfaAproRqstRefByOfcVO[rsltRfaAproRqstRefByOfcVOs.length];
			System.arraycopy(rsltRfaAproRqstRefByOfcVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rsltRfaAproRqstRefByOfcVOs the RsltRfaAproRqstRefByOfcVOs to set
     */
    public void setRsltRfaAproRqstRefByOfcVOs(RsltRfaAproRqstRefByOfcVO[] rsltRfaAproRqstRefByOfcVOs){
		if(rsltRfaAproRqstRefByOfcVOs != null){
			RsltRfaAproRqstRefByOfcVO[] tmpVOs = new RsltRfaAproRqstRefByOfcVO[rsltRfaAproRqstRefByOfcVOs.length];
			System.arraycopy(rsltRfaAproRqstRefByOfcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaAproRqstRefByOfcVOs = tmpVOs;
		}
    }

}