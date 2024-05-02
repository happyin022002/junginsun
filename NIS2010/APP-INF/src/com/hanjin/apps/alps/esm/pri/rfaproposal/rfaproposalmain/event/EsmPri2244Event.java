/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2044Event.java
*@FileTitle : RFA Proposal Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.28 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
 

/**
 * ESM_PRI_2044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2244Event extends EventSupport {
//RsltPriSpMnSCCpVO
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO = null;

	/** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltRfaPropCopyVO rsltRfaPropCopyVO = null; 
    
    /** Customer Value Object Multi Data 처리 */
    private RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpMnVO priRpScpMnVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstPriRpScpDurVO cstPriRpScpDurVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpMnVO priRpMnVO = null;
	
	public EsmPri2244Event(){}
	
	private String rfaType = "";

    /**
     * @return the rsltRoutHdrSmryListVO
     */

	public RsltRoutHdrSmryListVO getRsltRoutHdrSmryListVO() {
		return rsltRoutHdrSmryListVO;
	}

	 /**
     * @param rsltPropCpBlplAfilVO the rsltRoutHdrSmryListVO
     */
	public void setRsltRoutHdrSmryListVO(RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO) {
		this.rsltRoutHdrSmryListVO = rsltRoutHdrSmryListVO;
	}

    /**
     * @return the rsltRfaPropCopyVO
     */
    public RsltRfaPropCopyVO getRsltRfaPropCopyVO () {
        return rsltRfaPropCopyVO;
    }

    /**
     * @param rsltRfaPropCopyVO the rsltRfaPropCopyVO to set
     */
    public void setRsltRfaPropCopyVO (RsltRfaPropCopyVO rsltRfaPropCopyVO) {
        this.rsltRfaPropCopyVO = rsltRfaPropCopyVO;
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

	/**
	 * @return the priRpScpMnVO
	 */
	public PriRpScpMnVO getPriRpScpMnVO() {
		return priRpScpMnVO;
	}

	/**
	 * @param priRpScpMnVO the priRpScpMnVO to set
	 */
	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO) {
		this.priRpScpMnVO = priRpScpMnVO;
	}

	/**
	 * @return the cstPriRpScpDurVO
	 */
	public CstPriRpScpDurVO getCstPriRpScpDurVO() {
		return cstPriRpScpDurVO;
	}

	/**
	 * @param cstPriRpScpDurVO the cstPriRpScpDurVO to set
	 */
	public void setCstPriRpScpDurVO(CstPriRpScpDurVO cstPriRpScpDurVO) {
		this.cstPriRpScpDurVO = cstPriRpScpDurVO;
	}

	/**
	 * @return the priRpMnVO
	 */
	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	/**
	 * @param priRpMnVO the priRpMnVO to set
	 */
	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
	}

	/**
	 * @return the rfaType
	 */
	public String getRfaType() {
		return rfaType;
	}

	/**
	 * @param rfaType the rfaType to set
	 */
	public void setRfaType(String rfaType) {
		this.rfaType = rfaType;
	}
    
}