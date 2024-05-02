/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg1035Event.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.06.25
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009.05.12 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * ESM_BKG_1035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_1035HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1035Event extends EventSupport {

	/**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String bkgNo     = "";
    private String vnCgoDeCd = "";

    private BkgDoVO bkgDoVo = null;

	public EsmBkg1035Event(){}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public BkgDoVO getBkgDoVo() {
		return bkgDoVo;
	}

	public void setBkgDoVo(BkgDoVO bkgDoVo) {
		this.bkgDoVo = bkgDoVo;
	}

	public String getVnCgoDeCd() {
		return vnCgoDeCd;
	}

	public void setVnCgoDeCd(String vnCgoDeCd) {
		this.vnCgoDeCd = vnCgoDeCd;
	}
}