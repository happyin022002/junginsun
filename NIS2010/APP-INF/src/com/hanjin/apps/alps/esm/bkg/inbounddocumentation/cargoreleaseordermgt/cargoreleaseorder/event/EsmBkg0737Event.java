/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0737Event.java
*@FileTitle      : Attorney Search Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-07-17
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-07-17 임진영
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoVO;


/**
 * ESM_BKG_0737 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0737HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_0737HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0737Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 2954119069493312059L;
    
    private String bkgNo = "";

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

    /** Table Value Object 조회 조건 및 단건 처리  */
    private EdoTransVO edoTransVO = null;

    /** Table Value Object Multi Data 처리 */
    private EdoTransVO[] edoTransVOs = null;

    /** Table Value Object Multi Data 처리 */
    private  EdoEdiTransVO[] edoEdiTrans = null;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private  EdoTransBlInfoVO edoTransBlInfoVO  = null;

    /**
     * @param edoTrans the edoTrans to set
     */
    public void setEdoTransVO(EdoTransVO edoTransVO) {
        this.edoTransVO = edoTransVO;
    }

    /**
     * @return the edoTrans
     */
    public EdoTransVO getEdoTransVO() {
        return edoTransVO;
    }

    /**
     * @param edoTransVOs the edoTransVOs to set
     */
    public void setEdoTransVOs(EdoTransVO[] edoTransVOs) {
        this.edoTransVOs = edoTransVOs;
    }

    /**
     * @return the edoTransVOs
     */
    public EdoTransVO[] getEdoTransVOs() {
        return edoTransVOs;
    }

	/**
	 * @return the edoEdiTrans
	 */
	public EdoEdiTransVO[] getEdoEdiTrans() {
		return edoEdiTrans;
	}

	/**
	 * @param edoEdiTrans the edoEdiTrans to set
	 */
	public void setEdoEdiTrans(EdoEdiTransVO[] edoEdiTrans) {
		this.edoEdiTrans = edoEdiTrans;
	}

	public EdoTransBlInfoVO getEdoTransBlInfoVO() {
		return edoTransBlInfoVO;
	}

	public void setEdoTransBlInfoVO(EdoTransBlInfoVO edoTransBlInfoVO) {
		this.edoTransBlInfoVO = edoTransBlInfoVO;
	}
}