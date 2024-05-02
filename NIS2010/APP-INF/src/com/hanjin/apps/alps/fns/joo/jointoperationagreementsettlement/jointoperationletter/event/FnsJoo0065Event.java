/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0065Event.java
*@FileTitle : MCS & Invoice Letter Fax/E-mail Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;


/**
 * FNS_JOO_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0065HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	private String ofccd = "";
	private String userid = "";
	private String fmdt = "";
	private String todt = "";
    /**
     * @return the ofccd
     */
    public String getOfccd() {
        return ofccd;
    }
    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }
    /**
     * @return the fmdt
     */
    public String getFmdt() {
        return fmdt;
    }
    /**
     * @return the todt
     */
    public String getTodt() {
        return todt;
    }
    /**
     * @param ofccd the ofccd to set
     */
    public void setOfccd(String ofccd) {
        this.ofccd = ofccd;
    }
    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    /**
     * @param fmdt the fmdt to set
     */
    public void setFmdt(String fmdt) {
        this.fmdt = fmdt;
    }
    /**
     * @param todt the todt to set
     */
    public void setTodt(String todt) {
        this.todt = todt;
    }

}