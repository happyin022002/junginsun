/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1022Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.12 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_1022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1022Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String doNo      = "";
    private String doNoSplit      = "";
	
    public EsmBkg1022Event(){}

	public String getDoNo() {
		return doNo;
	}

	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}

	public String getDoNoSplit() {
		return doNoSplit;
	}

	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}
}