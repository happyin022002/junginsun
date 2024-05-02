/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDmt6013Event.java
*@FileTitle : Unissued Invoice by Aging – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.11 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.UnissuedInvoiceByAgingParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_6013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kitae Kim
 * @see EES_DMT_6013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UnissuedInvoiceByAgingParmVO[] unissuedInvoiceByAgingParmVOs = null;

	
	public EesDmt6013Event(){}
	
	public void setUnissuedInvoiceByAgingParmVO(UnissuedInvoiceByAgingParmVO unissuedInvoiceByAgingParmVO){
		this. unissuedInvoiceByAgingParmVO = unissuedInvoiceByAgingParmVO;
	}
	public void setUnissuedInvoiceByAgingParmVOS(UnissuedInvoiceByAgingParmVO[] unissuedInvoiceByAgingParmVOs){
		if (unissuedInvoiceByAgingParmVOs != null) {
			this.unissuedInvoiceByAgingParmVOs = new UnissuedInvoiceByAgingParmVO[unissuedInvoiceByAgingParmVOs.length];
			
			for (int i=0; i<unissuedInvoiceByAgingParmVOs.length; i++) {
				this.unissuedInvoiceByAgingParmVOs[i] = unissuedInvoiceByAgingParmVOs[i];
			}
		}
	}
	public UnissuedInvoiceByAgingParmVO getUnissuedInvoiceByAgingParmVO(){
		return unissuedInvoiceByAgingParmVO;
	}
	public UnissuedInvoiceByAgingParmVO[] getUnissuedInvoiceByAgingParmVOS(){
		UnissuedInvoiceByAgingParmVO[] ret = null;
		
		if (this.unissuedInvoiceByAgingParmVOs != null) {
			ret = new UnissuedInvoiceByAgingParmVO[unissuedInvoiceByAgingParmVOs.length];
			
			for (int i=0; i<unissuedInvoiceByAgingParmVOs.length; i++) {
				ret[i] = this.unissuedInvoiceByAgingParmVOs[i];
			}
		}
		return ret;		
	}
}