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

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriSpMnSCCpVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;
 

/**
 * ESM_PRI_2044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_2044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2044Event extends EventSupport {
//RsltPriSpMnSCCpVO
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
//	private RsltPriSpMnSCCpVO rsltPriSpMnSCCpVO = null;	

    /** Table Value Object Multi Data 처리 */
    private RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs = null;
    
    /** Table Value Object Multi Data 처리 */
//    private CstPriSpScpCpVO[] cstPriSpScpCpVOs = null;  

	/** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltRfaPropCopyVO rsltRfaPropCopyVO = null; 

    /** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltRfaPropCopyVO rsltPropCpBlplAfilVO = null; 
    
    /** Customer Value Object Multi Data 처리 */
    private RsltRfaPropCopyVO[] rsltRfaPropCopyVOs = null;

    /** Customer Value Object Multi Data 처리 */
    private RsltRfaPropCopyVO[] rsltPropCpBlplAfilListVOs = null;

//	public CstPriSpScpCpVO[] getCstPriSpScpCpVOs() {
//		return cstPriSpScpCpVOs;
//	}

//	public void setCstPriSpScpCpVOs(CstPriSpScpCpVO[] cstPriSpScpCpVOs) {
//		this.cstPriSpScpCpVOs = cstPriSpScpCpVOs;
//	}

	public RsltPriSpMnSCCpVO[] getRsltPriSpMnSCCpVOs() {
		RsltPriSpMnSCCpVO[] rtnVOs = null;
		if (this.rsltPriSpMnSCCpVOs != null) {
			rtnVOs = new RsltPriSpMnSCCpVO[rsltPriSpMnSCCpVOs.length];
			System.arraycopy(rsltPriSpMnSCCpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltPriSpMnSCCpVOs(RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs){
		if(rsltPriSpMnSCCpVOs != null){
			RsltPriSpMnSCCpVO[] tmpVOs = new RsltPriSpMnSCCpVO[rsltPriSpMnSCCpVOs.length];
			System.arraycopy(rsltPriSpMnSCCpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriSpMnSCCpVOs = tmpVOs;
		}
	}

	public PriSpMnVO getPriSpMnVO() {
		return priSpMnVO;
	}

	public void setPriSpMnVO(PriSpMnVO priSpMnVO) {
		this.priSpMnVO = priSpMnVO;
	}

	public EsmPri2044Event(){}

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
     * @return the rsltRfaPropCopyVOs
     */
    public RsltRfaPropCopyVO[] getRsltRfaPropCopyVOs() {
		RsltRfaPropCopyVO[] rtnVOs = null;
		if (this.rsltRfaPropCopyVOs != null) {
			rtnVOs = new RsltRfaPropCopyVO[rsltRfaPropCopyVOs.length];
			System.arraycopy(rsltRfaPropCopyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rsltRfaPropCopyVOs the rsltRfaPropCopyVOs to set
     */
    public void setRsltRfaPropCopyVOs(RsltRfaPropCopyVO[] rsltRfaPropCopyVOs){
		if(rsltRfaPropCopyVOs != null){
			RsltRfaPropCopyVO[] tmpVOs = new RsltRfaPropCopyVO[rsltRfaPropCopyVOs.length];
			System.arraycopy(rsltRfaPropCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaPropCopyVOs = tmpVOs;
		}
    }

    /**
     * @return the rsltPropCpBlplAfilListVOs
     */
    public RsltRfaPropCopyVO[] getRsltPropCpBlplAfilListVOs() {
		RsltRfaPropCopyVO[] rtnVOs = null;
		if (this.rsltPropCpBlplAfilListVOs != null) {
			rtnVOs = new RsltRfaPropCopyVO[rsltPropCpBlplAfilListVOs.length];
			System.arraycopy(rsltPropCpBlplAfilListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param rsltPropCpBlplAfilListVOs the rsltPropCpBlplAfilListVOs to set
     */
    public void setRsltPropCpBlplAfilListVOs(RsltRfaPropCopyVO[] rsltPropCpBlplAfilListVOs){
		if(rsltPropCpBlplAfilListVOs != null){
			RsltRfaPropCopyVO[] tmpVOs = new RsltRfaPropCopyVO[rsltPropCpBlplAfilListVOs.length];
			System.arraycopy(rsltPropCpBlplAfilListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPropCpBlplAfilListVOs = tmpVOs;
		}
    }

    /**
     * @return the rsltPropCpBlplAfilVO
     */
    public RsltRfaPropCopyVO getRsltPropCpBlplAfilVO () {
        return rsltPropCpBlplAfilVO;
    }

    /**
     * @param rsltPropCpBlplAfilVO the rsltPropCpBlplAfilVO to set
     */
    public void setRsltPropCpBlplAfilVO (RsltRfaPropCopyVO rsltPropCpBlplAfilVO) {
        this.rsltPropCpBlplAfilVO = rsltPropCpBlplAfilVO;
    }
	
}