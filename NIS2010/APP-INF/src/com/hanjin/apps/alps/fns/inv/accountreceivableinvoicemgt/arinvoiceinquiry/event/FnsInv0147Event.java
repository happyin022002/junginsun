/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0147Event.java
*@FileTitle : PCF Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.20
*@LastModifier : 박성용
*@LastVersion : 1.0
* 2018.06.20 박성용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * FNS_INV_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0147Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PCFStatusInfoInputVO pcfStatusInfoInputVO = null;
	
	public FnsInv0147Event(){}
	
	public PCFStatusInfoInputVO getPCFStatusInfoInputVO() {
		return pcfStatusInfoInputVO;
	}

	public void setPCFStatusInfoInputVO(PCFStatusInfoInputVO pcfStatusInfoInputVO) {
		this.pcfStatusInfoInputVO = pcfStatusInfoInputVO;
	}
	
}