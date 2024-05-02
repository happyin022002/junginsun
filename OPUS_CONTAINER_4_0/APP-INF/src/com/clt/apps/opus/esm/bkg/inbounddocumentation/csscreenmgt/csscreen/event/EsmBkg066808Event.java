/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg066808Event.java
*@FileTitle : 
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

/**
 * esm_bkg_0292 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0292HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0292HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg066808Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String bkgNo        = "";
    private String blNo         = "";
    private String cntrNo       = "";
    private String poNo         = "";
    private String hblNo        = "";
    
	public EsmBkg066808Event(){}

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

	public String getHblNo() {
		return hblNo;
	}

	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
    
    
}