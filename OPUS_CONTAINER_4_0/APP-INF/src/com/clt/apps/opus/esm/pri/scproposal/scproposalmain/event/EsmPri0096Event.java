/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0096Event.java
*@FileTitle : TPW Group Commodity Guideline Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.04 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpScpCpVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSpMnSCCpVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Baek Jin
 * @see ESM_PRI_0096HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0096Event extends EventSupport {
//RsltPriSpMnSCCpVO
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
//	private RsltPriSpMnSCCpVO rsltPriSpMnSCCpVO = null;	

    /** Table Value Object Multi Data 처리 */
    private RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs = null;
    
    /** Table Value Object Multi Data 처리 */
    private CstPriSpScpCpVO[] cstPriSpScpCpVOs = null;  

	/** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltPropCopyVO rsltPropCopyVO = null; 

    /** Customer Value Object 조회 조건 및 단건 처리  */
    private RsltPropCopyVO rsltPropCpBlplAfilVO = null; 
    
    /** Customer Value Object Multi Data 처리 */
    private RsltPropCopyVO[] rsltPropCopyVOs = null;

    /** Customer Value Object Multi Data 처리 */
    private RsltPropCopyVO[] rsltPropCpBlplAfilListVOs = null;

	public CstPriSpScpCpVO[] getCstPriSpScpCpVOs() {
		CstPriSpScpCpVO[] tmpVOs = null;
		if (this.cstPriSpScpCpVOs != null) {
			tmpVOs = new CstPriSpScpCpVO[cstPriSpScpCpVOs.length];
			System.arraycopy(cstPriSpScpCpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCstPriSpScpCpVOs(CstPriSpScpCpVO[] cstPriSpScpCpVOs) {
		if (cstPriSpScpCpVOs != null) {
			CstPriSpScpCpVO[] tmpVOs = new CstPriSpScpCpVO[cstPriSpScpCpVOs.length];
			System.arraycopy(cstPriSpScpCpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriSpScpCpVOs = tmpVOs;
		}
	}

	public RsltPriSpMnSCCpVO[] getRsltPriSpMnSCCpVOs() {
		RsltPriSpMnSCCpVO[] tmpVOs = null;
		if (this.rsltPriSpMnSCCpVOs != null) {
			tmpVOs = new RsltPriSpMnSCCpVO[rsltPriSpMnSCCpVOs.length];
			System.arraycopy(rsltPriSpMnSCCpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltPriSpMnSCCpVOs(RsltPriSpMnSCCpVO[] rsltPriSpMnSCCpVOs) {
		if (rsltPriSpMnSCCpVOs != null) {
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

	public EsmPri0096Event(){}

    /**
     * @return the rsltPropCopyVO
     */
    public RsltPropCopyVO getRsltPropCopyVO () {
        return rsltPropCopyVO;
    }

    /**
     * @param rsltPropCopyVO the rsltPropCopyVO to set
     */
    public void setRsltPropCopyVO (RsltPropCopyVO rsltPropCopyVO) {
        this.rsltPropCopyVO = rsltPropCopyVO;
    }

    /**
     * @return the rsltPropCopyVOs
     */
    public RsltPropCopyVO[] getRsltPropCopyVOs () {
    	RsltPropCopyVO[] tmpVOs = null;
		if (this.rsltPropCopyVOs != null) {
			tmpVOs = new RsltPropCopyVO[rsltPropCopyVOs.length];
			System.arraycopy(rsltPropCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @param rsltPropCopyVOs the rsltPropCopyVOs to set
     */
    public void setRsltPropCopyVOs (RsltPropCopyVO[] rsltPropCopyVOs) {
    	if (rsltPropCopyVOs != null) {
    		RsltPropCopyVO[] tmpVOs = new RsltPropCopyVO[rsltPropCopyVOs.length];
			System.arraycopy(rsltPropCopyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPropCopyVOs = tmpVOs;
		}
	}

    /**
     * @return the rsltPropCpBlplAfilListVOs
     */
    public RsltPropCopyVO[] getRsltPropCpBlplAfilListVOs () {
    	RsltPropCopyVO[] tmpVOs = null;
		if (this.rsltPropCpBlplAfilListVOs != null) {
			tmpVOs = new RsltPropCopyVO[rsltPropCpBlplAfilListVOs.length];
			System.arraycopy(rsltPropCpBlplAfilListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @param rsltPropCpBlplAfilListVOs the rsltPropCpBlplAfilListVOs to set
     */
    public void setRsltPropCpBlplAfilListVOs (RsltPropCopyVO[] rsltPropCpBlplAfilListVOs) {
    	if (rsltPropCpBlplAfilListVOs != null) {
    		RsltPropCopyVO[] tmpVOs = new RsltPropCopyVO[rsltPropCpBlplAfilListVOs.length];
			System.arraycopy(rsltPropCpBlplAfilListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPropCpBlplAfilListVOs = tmpVOs;
		}
	}

    /**
     * @return the rsltPropCpBlplAfilVO
     */
    public RsltPropCopyVO getRsltPropCpBlplAfilVO () {
        return rsltPropCpBlplAfilVO;
    }

    /**
     * @param rsltPropCpBlplAfilVO the rsltPropCpBlplAfilVO to set
     */
    public void setRsltPropCpBlplAfilVO (RsltPropCopyVO rsltPropCpBlplAfilVO) {
        this.rsltPropCpBlplAfilVO = rsltPropCpBlplAfilVO;
    }
	
}