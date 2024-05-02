/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0892Event.java
*@FileTitle : Container No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.24 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_BKG-0892 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0892HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see UI_BKG-0892HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0892Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0892Event(){}

	String bkgVvd    = null;
	String bkgOfcCd  = null;
	String bkgPol    = null;
	String bkgPod    = null;
	String cfmFlg    = null;

    /**
     *
     * @return
     */
    public String getBkgVvd() {
        return bkgVvd;
    }

    /**
     *
     * @param bkgVvd
     */
    public void setBkgVvd(String bkgVvd) {
        this.bkgVvd = bkgVvd;
    }

    /**
     *
     * @return
     */
    public String getBkgOfcCd() {
        return bkgOfcCd;
    }

    /**
     *
     * @param bkgOfcCd
     */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    /**
     *
     * @return
     */
    public String getBkgPol() {
        return bkgPol;
    }

    /**
     *
     * @param bkgPol
     */
    public void setBkgPol(String bkgPol) {
        this.bkgPol = bkgPol;
    }

    /**
     *
     * @return
     */
    public String getBkgPod() {
        return bkgPod;
    }

    /**
     *
     * @param bkgPod
     */
    public void setBkgPod(String bkgPod) {
        this.bkgPod = bkgPod;
    }

    /**
     *
     * @return
     */
    public String getCfmFlg() {
        return cfmFlg;
    }

    /**
     *
     * @param cfmFlg
     */
    public void setCfmFlg(String cfmFlg) {
        this.cfmFlg = cfmFlg;
    }

}