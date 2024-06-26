/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0011Event.java
*@FileTitle : Operational Lease Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.09 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LseOpLseVO;


/**
 * EES_LSE_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String vndrSeq = "";
	private String bilFmDt = "";
	private String bilToDt = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOpLseVO lseOpLseVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public LseOpLseVO[] lseOpLseVOs = null;

	private PayableRentalCostVO payableRentalCostVO = null;

	public EesLse0011Event(){}
	
	public void setLseOpLseVO(LseOpLseVO lseOpLseVO){
		this. lseOpLseVO = lseOpLseVO;
	}

	public void setLseOpLseVOS(LseOpLseVO[] lseOpLseVOs){
		this. lseOpLseVOs = lseOpLseVOs;
	}

	public LseOpLseVO getLseOpLseVO(){
		return lseOpLseVO;
	}

	public LseOpLseVO[] getLseOpLseVOS(){
		return lseOpLseVOs;
	}

	public void setPayableRentalCostVO(PayableRentalCostVO payableRentalCostVO) {
		this.payableRentalCostVO = payableRentalCostVO;
	}

	public PayableRentalCostVO getPayableRentalCostVO() {
		return payableRentalCostVO;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setBilFmDt(String bilFmDt) {
		this.bilFmDt = bilFmDt;
	}

	public String getBilFmDt() {
		return bilFmDt;
	}

	public void setBilToDt(String bilToDt) {
		this.bilToDt = bilToDt;
	}

	public String getBilToDt() {
		return bilToDt;
	}
}