/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_915Event.java
*@FileTitle : Off-dock CY Invoice의 ByPool fileupload 및 verify
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-24 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_9152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9152Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Day or Month
	String mode = null;
	private TesTmlSoHdrVO  tesTmlSoHdrVO = null;
	private TesFileImpTmpVO[] tesFileImpTmpVOs = null;
	private com.hanjin.framework.component.rowset.DBRowSet rowSet = null;
	
	public EsdTes9152Event(){}
		
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	public TesFileImpTmpVO[] getTesFileImpTmpVOs() {
		return tesFileImpTmpVOs;
	}
	public void setTesFileImpTmpVOs(TesFileImpTmpVO[] tesFileImpTmpVOs) {
		this.tesFileImpTmpVOs = tesFileImpTmpVOs;
	}
	public com.hanjin.framework.component.rowset.DBRowSet getRowSet() {
		return rowSet;
	}
	public void setRowSet(com.hanjin.framework.component.rowset.DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

}
