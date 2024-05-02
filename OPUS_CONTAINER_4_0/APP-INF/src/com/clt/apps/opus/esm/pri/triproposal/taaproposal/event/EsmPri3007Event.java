/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3007Event.java
*@FileTitle : TAA Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.18 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.PriTaaListVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_3007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_3007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3007Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private PriSpCtrtPtyVO priSpCtrtPtyVO = null;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private PriAuthorizationVO priAuthorizationVO = null;

	/** Custom Value Object 조회 조건 및 단건 처리 */
    private RsltTaaMnVO rsltTaaMnVO = null;

    /** Custom Value Object Multi Data 처리 */
    private RsltTaaMnVO[] rsltTaaMnVOs = null;
    
    /** Custom Value Object Multi Data 처리 */
    private RsltTaaTriListVO[] rsltTaaTriListVOs = null;

    /** Custom Value Object 조회 조건 및 단건 처리 */
    private PriTaaListVO priTaaListVO = null;

	public EsmPri3007Event(){}

    /**
     * @return the rsltTaaMnVO
     */
    public RsltTaaMnVO getRsltTaaMnVO () {
        return rsltTaaMnVO;
    }

    /**
     * @param rsltTaaMnVO the rsltTaaMnVO to set
     */
    public void setRsltTaaMnVO (RsltTaaMnVO rsltTaaMnVO) {
        this.rsltTaaMnVO = rsltTaaMnVO;
    }

    /**
     * @return the rsltTaaTriListVOs
     */
    public RsltTaaTriListVO[] getRsltTaaTriListVOs () {
    	RsltTaaTriListVO[] tmpVOs = null;
		if (this.rsltTaaTriListVOs != null) {
			tmpVOs = new RsltTaaTriListVO[rsltTaaTriListVOs.length];
			System.arraycopy(rsltTaaTriListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @param rsltTaaTriListVOs the rsltTaaTriListVOs to set
     */
    public void setRsltTaaTriListVOs (RsltTaaTriListVO[] rsltTaaTriListVOs) {
		if (rsltTaaTriListVOs != null) {
			RsltTaaTriListVO[] tmpVOs = new RsltTaaTriListVO[rsltTaaTriListVOs.length];
			System.arraycopy(rsltTaaTriListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltTaaTriListVOs = tmpVOs;
		}
	}

    /**
     * @return the rsltTaaMnVOs
     */
    public RsltTaaMnVO[] getRsltTaaMnVOs () {
    	RsltTaaMnVO[] tmpVOs = null;
		if (this.rsltTaaMnVOs != null) {
			tmpVOs = new RsltTaaMnVO[rsltTaaMnVOs.length];
			System.arraycopy(rsltTaaMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @param rsltTaaMnVOs the rsltTaaMnVOs to set
     */
    public void setRsltTaaMnVOs (RsltTaaMnVO[] rsltTaaMnVOs) {
		if (rsltTaaMnVOs != null) {
			RsltTaaMnVO[] tmpVOs = new RsltTaaMnVO[rsltTaaMnVOs.length];
			System.arraycopy(rsltTaaMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltTaaMnVOs = tmpVOs;
		}
	}

    /**
     * @return the priTaaListVO
     */
    public PriTaaListVO getPriTaaListVO () {
        return priTaaListVO;
    }

    /**
     * @param priTaaListVO the priTaaListVO to set
     */
    public void setPriTaaListVO (PriTaaListVO priTaaListVO) {
        this.priTaaListVO = priTaaListVO;
    }

    /**
     * @return the priSpCtrtPtyVO
     */
    public PriSpCtrtPtyVO getPriSpCtrtPtyVO () {
        return priSpCtrtPtyVO;
    }

    /**
     * @param priSpCtrtPtyVO the priSpCtrtPtyVO to set
     */
    public void setPriSpCtrtPtyVO (PriSpCtrtPtyVO priSpCtrtPtyVO) {
        this.priSpCtrtPtyVO = priSpCtrtPtyVO;
    }

    /**
     * @return the priAuthorizationVO
     */
    public PriAuthorizationVO getPriAuthorizationVO() {
        return priAuthorizationVO;
    }

    /**
     * @param priAuthorizationVO the priAuthorizationVO to set
     */
    public void setPriAuthorizationVO(PriAuthorizationVO priAuthorizationVO) {
        this.priAuthorizationVO = priAuthorizationVO;
    }

}