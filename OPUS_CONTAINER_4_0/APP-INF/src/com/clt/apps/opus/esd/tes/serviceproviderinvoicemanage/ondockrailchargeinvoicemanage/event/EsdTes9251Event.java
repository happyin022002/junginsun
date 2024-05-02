/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes9251Event.java
*@FileTitle : 3rd Party Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-09-28
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-09-28 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * ESD_TES_9251 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9251HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9251Event extends EventSupport {
	
	private TesN3rdPtyIfVO tesN3rdPtyIfVO = null;

	public EsdTes9251Event(){}

	
	public String getEventName() {
		return "EsdTes9251Event";
	}

	public String toString() {
		return "EsdTes9251Event";
	}


	/**
	 * @return the tesN3rdPtyIfVO
	 */
	public TesN3rdPtyIfVO getTesN3rdPtyIfVO() {
		return tesN3rdPtyIfVO;
	}


	/**
	 * @param tesN3rdPtyIfVO the tesN3rdPtyIfVO to set
	 */
	public void setTesN3rdPtyIfVO(TesN3rdPtyIfVO tesN3rdPtyIfVO) {
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
	}
	
	/** tes_n3rd_pty_if Table  Value Object */
//	private TES_N3RD_PTY_IF tes_n3rd_pty_if = null;

	/** tes_n3rd_pty_ifs Multi Action을 위한 Collection */
//	private Collection tes_n3rd_pty_ifs = null;

/*
	public EsdTes9251Event(TES_N3RD_PTY_IF tes_n3rd_pty_if) {
		this.tes_n3rd_pty_if = tes_n3rd_pty_if;
    }

	public EsdTes9251Event(TES_N3RD_PTY_IF tes_n3rd_pty_if, Collection tes_n3rd_pty_ifs) {
		this.tes_n3rd_pty_if = tes_n3rd_pty_if;
		this.tes_n3rd_pty_ifs = tes_n3rd_pty_ifs;
    }

	public TES_N3RD_PTY_IF getTES_N3RD_PTY_IF(){
		return tes_n3rd_pty_if;
	}

	public Collection getTES_N3RD_PTY_IFS(){
		return tes_n3rd_pty_ifs;
	}
*/


}
