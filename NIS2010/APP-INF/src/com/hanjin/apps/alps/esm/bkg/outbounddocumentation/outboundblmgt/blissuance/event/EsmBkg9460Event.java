/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9460Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.N3ptyBlRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9460 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9460HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong-ho
 * @see ESM_BKG_9460HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9460Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private N3ptyBlRqstVO n3ptyBlRqstVO = null;
    /** Table Value Object Multi Data 처리 */
    private N3ptyBlRqstVO[] n3ptyBlRqstVOs = null;
	private String bkgNo = null;

    
    
    
    public EsmBkg9460Event() {}

    /**
	 * @return BlIssRqstVO
	 */
    public N3ptyBlRqstVO getN3ptyBlRqstVO() {
        return n3ptyBlRqstVO;
    }

	/**
	 * @param BlIssRqstVO blIssRqstVO
	 */
    public void setN3ptyBlRqstVO(N3ptyBlRqstVO n3ptyBlRqstVO) {
        this.n3ptyBlRqstVO = n3ptyBlRqstVO;
    }

	/**
	 * @return N3ptyBlRqstVO[]
	 */
    public N3ptyBlRqstVO[] getN3ptyBlRqstVOs() {
        return n3ptyBlRqstVOs;
    }

	/**
	 * @param N3ptyBlRqstVO[] n3ptyBlRqstVOs
	 */
    public void setN3ptyBlRqstVOs(N3ptyBlRqstVO[] n3ptyBlRqstVOs) {
        this.n3ptyBlRqstVOs = n3ptyBlRqstVOs; 
    }

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


    
    
    
}