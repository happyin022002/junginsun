/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg1119Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.12.01 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgBlIssRqstMailSndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1119HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong-ho
 * @see ESM_BKG_1119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1119Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BlIssRqstVO blIssRqstVO = null;
    /** Table Value Object Multi Data 처리 */
    private BlIssRqstVO[] blIssRqstVOs = null;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO = null;
    /** Table Value Object Multi Data 처리 */
    private BkgBlIssRqstMailSndVO[] bkgBlIssRqstMailSndVOs = null;
    
    
    
    public EsmBkg1119Event() {}

    /**
	 * @return BlIssRqstVO
	 */
    public BlIssRqstVO getBlIssRqstVO() {
        return blIssRqstVO;
    }

	/**
	 * @param BlIssRqstVO blIssRqstVO
	 */
    public void setBlIssRqstVO(BlIssRqstVO blIssRqstVO) {
        this.blIssRqstVO = blIssRqstVO;
    }

	/**
	 * @return BlIssRqstVO[]
	 */
    public BlIssRqstVO[] getBlIssRqstVOs() {
        return blIssRqstVOs;
    }

	/**
	 * @param BlIssRqstVO[] blIssRqstVOs
	 */
    public void setBlIssRqstVOs(BlIssRqstVO[] blIssRqstVOs) {
        this.blIssRqstVOs = blIssRqstVOs; 
    }

	/**
	 * @return the bkgBlIssRqstMailSndVO
	 */
	public BkgBlIssRqstMailSndVO getBkgBlIssRqstMailSndVO() {
		return bkgBlIssRqstMailSndVO;
	}

	/**
	 * @param bkgBlIssRqstMailSndVO the bkgBlIssRqstMailSndVO to set
	 */
	public void setBkgBlIssRqstMailSndVO(BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO) {
		this.bkgBlIssRqstMailSndVO = bkgBlIssRqstMailSndVO;
	}

	/**
	 * @return the bkgBlIssRqstMailSndVOs
	 */
	public BkgBlIssRqstMailSndVO[] getBkgBlIssRqstMailSndVOs() {
		return bkgBlIssRqstMailSndVOs;
	}

	/**
	 * @param bkgBlIssRqstMailSndVOs the bkgBlIssRqstMailSndVOs to set
	 */
	public void setBkgBlIssRqstMailSndVOs(
			BkgBlIssRqstMailSndVO[] bkgBlIssRqstMailSndVOs) {
		this.bkgBlIssRqstMailSndVOs = bkgBlIssRqstMailSndVOs;
	}
    
    
    
}