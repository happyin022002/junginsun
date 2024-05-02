/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg036101Event.java
 *@FileTitle : Export/Import Information(USA)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.06.09 최도순
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0361_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0361_01HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see ESM_BKG_0361_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg036101Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private XptImpLicVO    	  xptImpLicVO      = null;
    private XptImpLicVO[]     xptImpLicVOs     = null;
    private String            bkgNo            = null;
    private String            ioBndCd          = null;
    private String            polCd            = null;
    private String            podCd            = null;
    private String            pkgQty           = null;
    private String            pkgTp            = null;
    private String            wgtQty           = null;
    private String            wgtTp            = null;
    private String            goCntCd          = null;
    private String            cntCd            = null;
    private String            popUpTpCd        = null;
    private String            xterSndrId       = null;
    private String            xterRqstNo       = null;
    private String            xterRqstSeq      = null;


	/**
	 * @return the popUpTpCd
	 */
	public String getPopUpTpCd() {
		return popUpTpCd;
	}

	/**
	 * @param popUpTpCd the popUpTpCd to set
	 */
	public void setPopUpTpCd(String popUpTpCd) {
		this.popUpTpCd = popUpTpCd;
	}

	/**
	 * @return the xterSndrId
	 */
	public String getXterSndrId() {
		return xterSndrId;
	}

	/**
	 * @param xterSndrId the xterSndrId to set
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}

	/**
	 * @return the xterRqstNo
	 */
	public String getXterRqstNo() {
		return xterRqstNo;
	}

	/**
	 * @param xterRqstNo the xterRqstNo to set
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}

	/**
	 * @return the xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return xterRqstSeq;
	}

	/**
	 * @param xterRqstSeq the xterRqstSeq to set
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}

	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}

	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the goCntCd
	 */
	public String getGoCntCd() {
		return goCntCd;
	}

	/**
	 * @param goCntCd the goCntCd to set
	 */
	public void setGoCntCd(String goCntCd) {
		this.goCntCd = goCntCd;
	}

	/**
	 * @return the pkgQty
	 */
	public String getPkgQty() {
		return pkgQty;
	}

	/**
	 * @param pkgQty the pkgQty to set
	 */
	public void setPkgQty(String pkgQty) {
		this.pkgQty = pkgQty;
	}

	/**
	 * @return the pkgTp
	 */
	public String getPkgTp() {
		return pkgTp;
	}

	/**
	 * @param pkgTp the pkgTp to set
	 */
	public void setPkgTp(String pkgTp) {
		this.pkgTp = pkgTp;
	}

	/**
	 * @return the wgtQty
	 */
	public String getWgtQty() {
		return wgtQty;
	}

	/**
	 * @param wgtQty the wgtQty to set
	 */
	public void setWgtQty(String wgtQty) {
		this.wgtQty = wgtQty;
	}

	/**
	 * @return the wgtTp
	 */
	public String getWgtTp() {
		return wgtTp;
	}

	/**
	 * @param wgtTp the wgtTp to set
	 */
	public void setWgtTp(String wgtTp) {
		this.wgtTp = wgtTp;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public EsmBkg036101Event() {}

    public void setXptImpLicVO(XptImpLicVO xptImpLicVO) {
        this.xptImpLicVO = xptImpLicVO;
    }

    public void setXptImpLicVOs(XptImpLicVO[] xptImpLicVOs) {
        this.xptImpLicVOs = xptImpLicVOs;
    }

    public XptImpLicVO getXptImpLicVO() {
        return xptImpLicVO;
    }

    public XptImpLicVO[] getXptImpLicVOs() {
        return xptImpLicVOs;
    }

    public String getBkgNo() {
        return bkgNo;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }


    public String getIoBndCd() {
        return ioBndCd;
    }

    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }


}