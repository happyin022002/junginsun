/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri2017Event.java
*@FileTitle : Basic RFA Auto Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpAmendVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;

/**
 * ESM_PRI_2017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_PRI_2017HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri2017Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	private String mstRfaNo = null;
    
	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpHdrVO priRpHdrVO = null;
	
	/** Customer Value Object 조회 조건 및 단건 처리  */
	private RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO = null;
	
	/** Customer Value Object 조회 조건 및 단건 처리  */
	private CstPriRpAmendVO cstPriRpAmendVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null; 

    /** Customer Value Object Multi Data 처리 */
    private RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs = null;
	
    private PriRpMnVO priRpMnVO = null;
  
    private RsltRfaPropCopyVO rsltRfaPropCopyVO = null;
    
    
    
    
    public RsltRfaPropCopyVO getRsltRfaPropCopyVO() {
        return rsltRfaPropCopyVO;
    }

    public void setRsltRfaPropCopyVO(RsltRfaPropCopyVO rsltRfaPropCopyVO) {
        this.rsltRfaPropCopyVO = rsltRfaPropCopyVO;
    }

    public PriRpMnVO getPriRpMnVO() {
        return priRpMnVO;
    }

    public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
        this.priRpMnVO = priRpMnVO;
    }

    /**
	 * @return the mstRfaNo
	 */
	public String getMstRfaNo() {
		return mstRfaNo;
	}

	/**
	 * @param mstRfaNo the mstRfaNo to set
	 */
	public void setMstRfaNo(String mstRfaNo) {
		this.mstRfaNo = mstRfaNo;
	}
	
	/**
	 * @return the rsltRoutHdrSmryListVO
	 */
	public RsltRoutHdrSmryListVO getRsltRoutHdrSmryListVO() {
		return rsltRoutHdrSmryListVO;
	}

	/**
	 * @param rsltRoutHdrSmryListVO the rsltRoutHdrSmryListVO to set
	 */
	public void setRsltRoutHdrSmryListVO(RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO) {
		this.rsltRoutHdrSmryListVO = rsltRoutHdrSmryListVO;
	}

	/**
	 * @return the cstPriRpAmendVO
	 */
	public CstPriRpAmendVO getCstPriRpAmendVO() {
		return cstPriRpAmendVO;
	}

	/**
	 * @param cstPriRpAmendVO the cstPriRpAmendVO to set
	 */
	public void setCstPriRpAmendVO(CstPriRpAmendVO cstPriRpAmendVO) {
		this.cstPriRpAmendVO = cstPriRpAmendVO;
	}

	/**
	 * @return the priRpScpRtCmdtRoutVO
	 */
	public PriRpScpRtCmdtRoutVO getPriRpScpRtCmdtRoutVO() {
		return priRpScpRtCmdtRoutVO;
	}
	
	/**
	 * @return the priRpHdrVO
	 */
	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}
	
	/**
	 * @param priRpHdrVO the priRpHdrVO to set
	 */
	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}
	
	/**
	 * @param priRpScpRtCmdtRoutVO the priRpScpRtCmdtRoutVO to set
	 */
	public void setPriRpScpRtCmdtRoutVO(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) {
		this.priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutVO;
	}

	/**
     * @return the rsltRoutHdrSmryListVOs
     */
    public RsltRoutHdrSmryListVO[] getRsltRoutHdrSmryListVOs() {
		RsltRoutHdrSmryListVO[] rtnVOs = null;
		if (this.rsltRoutHdrSmryListVOs != null) {
			rtnVOs = new RsltRoutHdrSmryListVO[rsltRoutHdrSmryListVOs.length];
			System.arraycopy(rsltRoutHdrSmryListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rsltRoutHdrSmryListVOs the rsltRoutHdrSmryListVOs to set
     */
    public void setRsltRoutHdrSmryListVOs(RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs){
		if(rsltRoutHdrSmryListVOs != null){
			RsltRoutHdrSmryListVO[] tmpVOs = new RsltRoutHdrSmryListVO[rsltRoutHdrSmryListVOs.length];
			System.arraycopy(rsltRoutHdrSmryListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRoutHdrSmryListVOs = tmpVOs;
		}
    }
	
}
