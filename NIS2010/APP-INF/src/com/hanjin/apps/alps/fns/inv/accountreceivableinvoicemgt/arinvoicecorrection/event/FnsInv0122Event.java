/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0122Event.java
*@FileTitle :  Marking "Reverse Charge" by I/F No 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.27 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0122HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MarkingReverseChargeVO markingReverseChargeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MarkingReverseChargeVO[] markingReverseChargeVOs = null;
	
	private String arOfcCd = null;
	private String blSrcNo = null;
	
	public FnsInv0122Event(){}

	/**
	 * @return the markingReverseChargeVO
	 */
	public MarkingReverseChargeVO getMarkingReverseChargeVO() {
		return markingReverseChargeVO;
	}

	/**
	 * @param markingReverseChargeVO the markingReverseChargeVO to set
	 */
	public void setMarkingReverseChargeVO(
			MarkingReverseChargeVO markingReverseChargeVO) {
		this.markingReverseChargeVO = markingReverseChargeVO;
	}

	/**
	 * @return the markingReverseChargeVOs
	 */
	public MarkingReverseChargeVO[] getMarkingReverseChargeVOs() {
		return markingReverseChargeVOs;
	}

	/**
	 * @param markingReverseChargeVOs the markingReverseChargeVOs to set
	 */
	public void setMarkingReverseChargeVOs(
			MarkingReverseChargeVO[] markingReverseChargeVOs) {
		this.markingReverseChargeVOs = markingReverseChargeVOs;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	

}