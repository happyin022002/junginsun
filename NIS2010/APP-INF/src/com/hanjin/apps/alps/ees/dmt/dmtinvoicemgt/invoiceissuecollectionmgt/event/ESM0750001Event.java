/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiFms0072Event.java
*@FileTitle : Manhour Item Registration & Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.05.12 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsPayRcvVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM075-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see
 * @since J2EE 1.4
 */

public class ESM0750001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public OtsPayRcvVO otsPayRcvVO = null;

	/**
	 * @param string
	 */
	public ESM0750001Event(String string) {
		// TODO Auto-generated constructor stub
	}

	public OtsPayRcvVO getOtsPayRcvVO() {
		return otsPayRcvVO;
	}

	public void setOtsPayRcvVO(OtsPayRcvVO otsPayRcvVO) {
		this.otsPayRcvVO = otsPayRcvVO;
	}
}