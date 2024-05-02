/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0031Event.java
 *@FileTitle : Invoice Inquiry by Good Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author KIM HYUN HWA
 * @see FNS_INV_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ErpErrorInputVO erpErrorInputVO = null;

	/** Table Value Object Multi Data 처리 */
	private ErpErrorVO[] erpErrorVOs = null;
	


	public FnsInv0115Event() {
	}

	public void setErpErrorVOS(ErpErrorVO[] erpErrorVOs) {
		this.erpErrorVOs = erpErrorVOs;
	}

	public ErpErrorInputVO getErpErrorInputVO() {
		return erpErrorInputVO;
	}

	public void setErpErrorInputVO(ErpErrorInputVO erpErrorInputVO) {
		this.erpErrorInputVO = erpErrorInputVO;
	}

	
}