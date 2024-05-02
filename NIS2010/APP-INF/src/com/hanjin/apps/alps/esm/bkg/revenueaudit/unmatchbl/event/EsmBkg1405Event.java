/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmBkg1405Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;

/**
 * esm_bkg_1405 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1405HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_1405HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1405Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String fmDt;
    private String toDt;
	public String getFmDt() {
		return fmDt;
	}
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	public String getToDt() {
		return toDt;
	}
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
    

}