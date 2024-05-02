/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9462Event.java
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
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9462 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9462HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong-ho
 * @see ESM_BKG_9462HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9462Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BkgMdtItmVO bkgMdtItmVO = null;
    /** Table Value Object Multi Data 처리 */
    private BkgMdtItmVO[] bkgMdtItmVOs = null;
	private String bkgNo = null;

    
    
    
    public EsmBkg9462Event() {}

    /**
	 * @return bkgMdtItmVO
	 */
    public BkgMdtItmVO getBkgMdtItmVO() {
        return bkgMdtItmVO;
    }

	/**
	 * @param BkgMdtItmVO bkgMdtItmVO
	 */
    public void setBkgMdtItmVO(BkgMdtItmVO bkgMdtItmVO) {
        this.bkgMdtItmVO = bkgMdtItmVO;
    }

	/**
	 * @return BkgMdtItmVO[]
	 */
    public BkgMdtItmVO[] getBkgMdtItmVOs() {
        return bkgMdtItmVOs;
    }

	/**
	 * @param BkgMdtItmVO[] bkgMdtItmVOs
	 */
    public void setBkgMdtItmVOs(BkgMdtItmVO[] bkgMdtItmVOs) {
        this.bkgMdtItmVOs = bkgMdtItmVOs; 
    }

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


    
    
    
}