/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0030Event.java
*@FileTitle : trade
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeVO;


/**
 * BCM_CCD_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String trdCd = null;
	
	private String ofcCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TradeVO trdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TradeVO[] trdVOs = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0030Event(){}
	
	public void setTradeCd(String trdCd){
		this. trdCd = trdCd;
	}
	
	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}
	
	public void setTradeVO(TradeVO trdVO){
		this. trdVO = trdVO;
	}

	public void setTradeVOS(TradeVO[] trdVOs){
		if(trdVOs != null){
			TradeVO[] tmpVOs = java.util.Arrays.copyOf(trdVOs, trdVOs.length);
			this.trdVOs = tmpVOs;
		}
	}

	public TradeVO getTradeVO(){
		return trdVO;
	}

	public TradeVO[] getTradeVOS(){
		TradeVO[] rtnVOs = null;
		if (this.trdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(trdVOs, trdVOs.length);
		}
		return rtnVOs;
	}
	
	public String getTradeCd(){
		return trdCd;
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