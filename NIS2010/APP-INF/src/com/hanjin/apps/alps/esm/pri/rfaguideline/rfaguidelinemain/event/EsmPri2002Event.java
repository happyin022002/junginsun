/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2002Event.java
*@FileTitle : Guideline Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.09 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.event;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRgMnVO;


/**
 * ESM_PRI_2002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2002HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri2002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgMnVO priRgMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgMnVO[] priRgMnVOs = null;

    /** Custom Value Object 조회 조건 및 단건 처리  */
    private RsltRfaGlineCopyVO rsltRfaGlineCopyVO = null;

    /** Custom Value Object Multi Data 처리  */
    private RsltRfaGlineCopyVO[] rsltRfaGlineCopyVOs = null;

	public EsmPri2002Event(){}
	
	public void setPriRgMnVO(PriRgMnVO priRgMnVO){
		this. priRgMnVO = priRgMnVO;
	}

	public void setPriRgMnVOS(PriRgMnVO[] priRgMnVOs){
		if(priRgMnVOs != null){
			PriRgMnVO[] tmpVOs = new PriRgMnVO[priRgMnVOs.length];
			System.arraycopy(priRgMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgMnVOs = tmpVOs;
		}
	}

	public PriRgMnVO getPriRgMnVO(){
		return priRgMnVO;
	}

	public PriRgMnVO[] getPriRgMnVOS(){
		PriRgMnVO[] rtnVOs = null;
		if (this.priRgMnVOs != null) {
			rtnVOs = new PriRgMnVO[priRgMnVOs.length];
			System.arraycopy(priRgMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the rsltRfaGlineCopyVO
     */
    public RsltRfaGlineCopyVO getRsltRfaGlineCopyVO () {
        return rsltRfaGlineCopyVO;
    }

    /**
     * @param rsltRfaGlineCopyVO the rsltRfaGlineCopyVO to set
     */
    public void setRsltRfaGlineCopyVO (RsltRfaGlineCopyVO rsltRfaGlineCopyVO) {
        this.rsltRfaGlineCopyVO = rsltRfaGlineCopyVO;
    }

    /**
     * @return the rsltRfaGlineCopyVOs
     */
    public RsltRfaGlineCopyVO[] getRsltRfaGlineCopyVOs(){
		RsltRfaGlineCopyVO[] rtnVOs = null;
		if (this.rsltRfaGlineCopyVOs != null) {
			rtnVOs = new RsltRfaGlineCopyVO[rsltRfaGlineCopyVOs.length];
			System.arraycopy(rsltRfaGlineCopyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rsltRfaGlineCopyVOs the rsltRfaGlineCopyVOs to set
     */
    public void setRsltRfaGlineCopyVOs(RsltRfaGlineCopyVO[] rsltRfaGlineCopyVOs){
		if(rsltRfaGlineCopyVOs != null){
			RsltRfaGlineCopyVO[] tmpVOs = new RsltRfaGlineCopyVO[rsltRfaGlineCopyVOs.length];
			System.arraycopy(rsltRfaGlineCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaGlineCopyVOs = tmpVOs;
		}
    }

}