/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SplitQtyVO.java
*@FileTitle : SplitQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.07 
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2012.02.27 정선용 [CHM-201215886-01] Split 기능 보완(eq tp,qty 추가)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

public class SplitQtyVO {
	private String cntrTpszCd = null;
	private String opCntrQty = null;
	private String splitNo = null;
	private String eqSubstCntrTpszCd = null;
	private String eqSubstCgoQty = null;
	private String rdCgoFlag = null;
	
	public String getEqSubstCntrTpszCd() {
		return eqSubstCntrTpszCd;
	}
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
	}
	public String getEqSubstCgoQty() {
		return eqSubstCgoQty;
	}
	public void setEqSubstCgoQty(String eqSubstCgoQty) {
		this.eqSubstCgoQty = eqSubstCgoQty;
	}
	public String getRdCgoFlag() {
		return rdCgoFlag;
	}
	public void setRdCgoFlag(String rdCgoFlag) {
		this.rdCgoFlag = rdCgoFlag;
	}
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	public String getOpCntrQty() {
		return opCntrQty;
	}
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	public String getSplitNo() {
		return splitNo;
	}
	public void setSplitNo(String splitNo) {
		this.splitNo = splitNo;
	}
	
}
