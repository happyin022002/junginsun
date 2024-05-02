/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9464Event.java
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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9464 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9464HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_BKG_9464HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9464Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BlCertiRqstVO blCertiRqstVO = null;
    /** Table Value Object Multi Data 처리 */
    private BlCertiRqstVO[] blCertiRqstVOs = null;
	private String bkgNo = null;
	private String ofcCd = null;

    
    
    
    public EsmBkg9464Event() {}

    /**
	 * @return blCertiRqstVO
	 */
    public BlCertiRqstVO getBlCertiRqstVO() {
        return blCertiRqstVO;
    }

	/**
	 * @param BlIssRqstVO blIssRqstVO
	 */
    public void setBlCertiRqstVO(BlCertiRqstVO blCertiRqstVO) {
        this.blCertiRqstVO = blCertiRqstVO;
    }

	/**
	 * @return blCertiRqstVO[]
	 */
    public BlCertiRqstVO[] getBlCertiRqstVOs() {
		BlCertiRqstVO[] rtnVOs = null;
		if (this.blCertiRqstVOs != null) {
			rtnVOs = new BlCertiRqstVO[blCertiRqstVOs.length];
			System.arraycopy(blCertiRqstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

	/**
	 * @param BlCertiRqstVO[] blCertiRqstVOs
	 */
    public void setBlCertiRqstVOs(BlCertiRqstVO[] blCertiRqstVOs){
		if(blCertiRqstVOs != null){
			BlCertiRqstVO[] tmpVOs = new BlCertiRqstVO[blCertiRqstVOs.length];
			System.arraycopy(blCertiRqstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blCertiRqstVOs = tmpVOs;
		}
    }

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}


    
    
    
}