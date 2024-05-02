/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0034Event.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;
 
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CarrierVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * BCM_CCD_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CarrierVO carrierVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CarrierVO[] carrierVOs = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0034Event(){}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public void setCarrierVO(CarrierVO carrierVO){
		this. carrierVO = carrierVO;
	}

	public void setCarrierVOS(CarrierVO[] carrierVOs){
		if(carrierVOs != null){
			CarrierVO[] tmpVOs = java.util.Arrays.copyOf(carrierVOs, carrierVOs.length);
			this.carrierVOs = tmpVOs;
		}
	}

	public CarrierVO getCarrierVO(){
		return carrierVO;
	}

	public CarrierVO[] getCarrierVOS(){
		CarrierVO[] rtnVOs = null;
		if (this.carrierVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(carrierVOs, carrierVOs.length);
		}
		return rtnVOs;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}

}