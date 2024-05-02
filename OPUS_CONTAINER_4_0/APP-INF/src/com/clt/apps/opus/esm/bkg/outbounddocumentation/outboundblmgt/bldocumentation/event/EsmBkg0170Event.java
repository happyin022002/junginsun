/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0170Event.java
*@FileTitle : Container Copy And Move
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0170 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0170HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0170HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0170Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
    private String bkgNo = null;
    private String blNo = null;
    private String cntrNo = null;
    private String cntrVol = null;
    
    private CntrCopyVO cntrCopyVO = null;
    private CntrCopyVO[] cntrCopyVOs = null;

	public EsmBkg0170Event(){}

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }


    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }


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


    /**
     * @return the cntrNo
     */
    public String getCntrNo() {
        return cntrNo;
    }


    /**
     * @param cntrNo the cntrNo to set
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }


    /**
     * @param cntrVol the cntrVol to set
     */
    public void setCntrVol(String cntrVol) {
        this.cntrVol = cntrVol;
    }


    /**
     * @return the cntrVol
     */
    public String getCntrVol() {
        return cntrVol;
    }

    
    /**
     * @return the cntrCopyVO
     */
    public CntrCopyVO getCntrCopyVO() {
        return cntrCopyVO;
    }

    
    /**
     * @param cntrCopyVO the cntrCopyVO to set
     */
    public void setCntrCopyVO(CntrCopyVO cntrCopyVO) {
        this.cntrCopyVO = cntrCopyVO;
    }

	public CntrCopyVO[] getCntrCopyVOs() {
		CntrCopyVO[] rtnVOs = null;
		if (this.cntrCopyVOs != null) {
			rtnVOs = Arrays.copyOf(cntrCopyVOs, cntrCopyVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrCopyVOs(CntrCopyVO[] cntrCopyVOs) {
		if (cntrCopyVOs != null) {
			CntrCopyVO[] tmpVOs = Arrays.copyOf(cntrCopyVOs, cntrCopyVOs.length);
			this.cntrCopyVOs = tmpVOs;
		}
	}



}