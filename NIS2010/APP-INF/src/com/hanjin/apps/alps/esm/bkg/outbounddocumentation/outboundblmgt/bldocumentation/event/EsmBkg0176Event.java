/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0176Event.java
*@FileTitle : Copy C/M by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0176 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0176HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0176HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0176Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cntrNo = null;
	private String cntrTpszCd = null;

	public EsmBkg0176Event(){}

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
     * @return the cntrTpszCd
     */
    public String getCntrTpszCd() {
        return cntrTpszCd;
    }

    /**
     * @param cntrTpszCd the cntrTpszCd to set
     */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }


}