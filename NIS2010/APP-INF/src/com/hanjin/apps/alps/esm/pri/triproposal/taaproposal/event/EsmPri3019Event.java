/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : EsmPri3019Event.java
 *@FileTitle : TAA Creation & Amendment View
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.08
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2011.08.08 서미진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event;

import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.PriTaaListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_3019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_3019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3019Event extends EventSupport {

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

	public EsmPri3019Event(){}

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
        return rsltTaaTriListVOs;
    }

    /**
     * @param rsltTaaTriListVOs the rsltTaaTriListVOs to set
     */
    public void setRsltTaaTriListVOs (RsltTaaTriListVO[] rsltTaaTriListVOs) {
        this.rsltTaaTriListVOs = rsltTaaTriListVOs;
    }

    /**
     * @return the rsltTaaMnVOs
     */
    public RsltTaaMnVO[] getRsltTaaMnVOs () {
        return rsltTaaMnVOs;
    }

    /**
     * @param rsltTaaMnVOs the rsltTaaMnVOs to set
     */
    public void setRsltTaaMnVOs (RsltTaaMnVO[] rsltTaaMnVOs) {
        this.rsltTaaMnVOs = rsltTaaMnVOs;
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