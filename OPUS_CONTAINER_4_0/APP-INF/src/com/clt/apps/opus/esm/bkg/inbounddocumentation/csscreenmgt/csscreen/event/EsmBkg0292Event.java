/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0292Event.java
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgDoRefVO;

/**
 * esm_bkg_0292 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0292HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0292HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0292Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String bkgNo        = "";
    private String blNo         = "";
    private String cntrNo       = "";
    private String poNo         = "";
    private String customsRefNo = "";
    private String demurType    = "";
    private String expDelDt     = "";
    /**
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;
    /**
	 * @return the customsRefNo
	 */
	public String getCustomsRefNo() {
		return customsRefNo;
	}

	/**
	 * @param customsRefNo the customsRefNo to set
	 */
	public void setCustomsRefNo(String customsRefNo) {
		this.customsRefNo = customsRefNo;
	}

	public EsmBkg0292Event(){}

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
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}

	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getDemurType() {
		return demurType;
	}

	public void setDemurType(String demurType) {
		this.demurType = demurType;
	}

	public String getExpDelDt() {
		return expDelDt;
	}

	public void setExpDelDt(String expDelDt) {
		this.expDelDt = expDelDt;
	}

	public BkgDoRefVO[] getRefInfos() {
		BkgDoRefVO[] tmpVOs = null;
		if (this.refInfos != null) {
			tmpVOs = new BkgDoRefVO[refInfos.length];
			System.arraycopy(refInfos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;	
	}

	public void setRefInfos(BkgDoRefVO[] refInfos) {
		if (refInfos != null) {
			BkgDoRefVO[] tmpVOs = new BkgDoRefVO[refInfos.length];
			System.arraycopy(refInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.refInfos = tmpVOs;
		}
	}
    
    
}