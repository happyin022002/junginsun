/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : DashboardBCImpl.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2009.06.01 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocTurnTimeInVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0066HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg1201Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	String bkg_ofc_cd;
    String sc_no;
	String bkg_no;
	String vvd;
	String pol_nod_cd;
	String pod_nod_cd;
	String rhq_cd;

	public EsmBkg1201Event() {
	}

	   public String getBkg_ofc_cd() {
	        return bkg_ofc_cd;
	    }

	    public void setBkg_ofc_cd(String bkg_ofc_cd) {
	        this.bkg_ofc_cd = bkg_ofc_cd;
	    }

	    public String getSc_no() {
	        return sc_no;
	    }

	    public void setSc_no(String sc_no) {
	        this.sc_no = sc_no;
	    }

	    public String getVvd() {
	        return vvd;
	    }

	    public void setVvd(String vvd) {
	        this.vvd = vvd;
	    }

	    public String getPol_nod_cd() {
	        return pol_nod_cd;
	    }

	    public void setPol_nod_cd(String pol_nod_cd) {
	        this.pol_nod_cd = pol_nod_cd;
	    }

	    public String getPod_nod_cd() {
	        return pod_nod_cd;
	    }

	    public void setPod_nod_cd(String pod_nod_cd) {
	        this.pod_nod_cd = pod_nod_cd;
	    }

	    public String getRhq_cd() {
	        return rhq_cd;
	    }

	    public void setRhq_cd(String rhq_cd) {
	        this.rhq_cd = rhq_cd;
	    }
	
	    /**
	     * Event's putValue
	     * @param key
	     * @param value void
	     */
	    public void putValue(String key, Object value){
	      
	        if(key==null) return;
	        this.setAttribute(key, value);
	    }
}