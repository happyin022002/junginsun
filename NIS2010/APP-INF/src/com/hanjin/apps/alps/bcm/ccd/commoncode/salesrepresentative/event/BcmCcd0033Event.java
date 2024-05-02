/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BcmCcd0033Event.java
*@FileTitle : sales rep.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;


/**
 * BCM_CCD_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SalesRepVO salesRepVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SalesRepVO[] salesRepVOs = null;
	
	private String srepCd = null;
	
	private String cntCd = null;
	
	private String ofcCd = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0033Event(){}
	
	public void setSalesRepVO(SalesRepVO salesRepVO){
		this. salesRepVO = salesRepVO;
	}

	public void setSalesRepVOS(SalesRepVO[] salesRepVOs){
		if(salesRepVOs != null){
			SalesRepVO[] tmpVOs = java.util.Arrays.copyOf(salesRepVOs, salesRepVOs.length);
			this.salesRepVOs = tmpVOs;
		}
	}
	
	public void setSrepCd(String srepCd){
		this. srepCd = srepCd;
	}
	
	public void setCntCd(String cntCd){
		this. cntCd = cntCd;
	}
	
	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}

	public SalesRepVO getSalesRepVO(){
		return salesRepVO;
	}

	public SalesRepVO[] getSalesRepVOS(){
		SalesRepVO[] rtnVOs = null;
		if (this.salesRepVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(salesRepVOs, salesRepVOs.length);
		}
		return rtnVOs;
	}
	
	public String getSrepCd(){
		return srepCd;
	}
	
	public String getCntCd(){
		return cntCd;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}

}