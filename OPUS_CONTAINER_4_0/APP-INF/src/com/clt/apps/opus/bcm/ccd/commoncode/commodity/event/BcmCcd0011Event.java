/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0011Event.java
*@FileTitle : Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.04 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.event;
 
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Commodity Code */
	private String cmdtCd = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CommodityVO cmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CommodityVO[] cmdtVOs = null;
	
	private String rqstNo = null;
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0011Event(){}

	public void setCommodityVO(CommodityVO cmdtVO){
		this. cmdtVO = cmdtVO;
	}
	
	public void setCommodityVOS(CommodityVO[] cmdtVOs){
		if(cmdtVOs != null){
			CommodityVO[] tmpVOs = java.util.Arrays.copyOf(cmdtVOs, cmdtVOs.length);
			this.cmdtVOs = tmpVOs;
		}
	}

	public CommodityVO getCommodityVO(){
		return cmdtVO;
	}

	public CommodityVO[] getCommodityVOS(){
		CommodityVO[] rtnVOs = null;
		if (this.cmdtVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cmdtVOs, cmdtVOs.length);
		}
		return rtnVOs;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	public String getCmdtCd() {
		return cmdtCd;
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