/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0579Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.29 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgPsaEdoAckSchVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;

/**
 * esm_bkg_0579 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0579HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_0579HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0579Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String blNo           = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgPsaEdoAckSchVO[] bkgPsaEdoAckSchVOs = null;
    

    public EsmBkg0579Event(){}

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

	public BkgPsaEdoAckSchVO getBkgPsaEdoAckSchVO() {
		return bkgPsaEdoAckSchVO;
	}

    /**
     * @param blNo the blNo to set
     */
	public void setBkgPsaEdoAckSchVO(BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO) {
		this.bkgPsaEdoAckSchVO = bkgPsaEdoAckSchVO;
	}

	public BkgPsaEdoAckSchVO[] getBkgPsaEdoAckSchVOs() {
		return bkgPsaEdoAckSchVOs;
	}

	public void setBkgPsaEdoAckSchVOs(BkgPsaEdoAckSchVO[] bkgPsaEdoAckSchVOs) {
		this.bkgPsaEdoAckSchVOs = bkgPsaEdoAckSchVOs;
	}    
    
}