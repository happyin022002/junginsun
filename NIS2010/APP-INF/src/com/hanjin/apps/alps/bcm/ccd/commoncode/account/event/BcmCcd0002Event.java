/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0002Event.java
*@FileTitle : Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.18 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.ChargeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
 

/**
 * BCM_CCD_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Charge Code */
	private String chgCd = "";
	
	/** Account Code */
	private String acctCd = "";
	
	/** Tax Country Code */
	private String taxCntCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeVO chgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeVO[] chgVOs = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0002Event(){}

	public void setChargeVO(ChargeVO chgVO){
		this. chgVO = chgVO;
	}
	
	public void setChargeVOS(ChargeVO[] chgVOs){
		if(chgVOs != null){
			ChargeVO[] tmpVOs = java.util.Arrays.copyOf(chgVOs, chgVOs.length);
			this.chgVOs = tmpVOs;
		}
	}

	public ChargeVO getChargeVO(){
		return chgVO;
	}

	public ChargeVO[] getChargeVOS(){
		ChargeVO[] rtnVOs = null;
		if (this.chgVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(chgVOs, chgVOs.length);
		}
		return rtnVOs;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	public String getChgCd() {
		return chgCd;
	}
	
	public String getAcctCd() {
		return acctCd;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}

	public String getTaxCntCd() {
		return taxCntCd;
	}

	public void setTaxCntCd(String taxCntCd) {
		this.taxCntCd = taxCntCd;
	}

}