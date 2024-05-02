/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0028Event.java
*@FileTitle : vessel service lane
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.event;
 
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.SLaneGroupVO;


/**
 * BCM_CCD_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SLaneGroupVO sLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SLaneGroupVO[] sLaneVOs = null;
	
	private String slaneCd = null;
	
	private String rqstNo = null;
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0028Event(){}
	
	public void setSLaneGroupVO(SLaneGroupVO sLaneVO){
		this. sLaneVO = sLaneVO;
	}

	public void setSLaneGroupVOS(SLaneGroupVO[] sLaneVOs){
		if(sLaneVOs != null){
			SLaneGroupVO[] tmpVOs = java.util.Arrays.copyOf(sLaneVOs, sLaneVOs.length);
			this.sLaneVOs = tmpVOs;
		}
	}
	
	public void setSlaneCd(String slaneCd){
		this. slaneCd = slaneCd;
	}
	
	public String getSlaneCd(){
		return slaneCd;
	}
	
	public SLaneGroupVO getSLaneGroupVO(){
		return sLaneVO;
	}

	public SLaneGroupVO[] getSLaneGroupVOS(){
		SLaneGroupVO[] rtnVOs = null;
		if (this.sLaneVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(sLaneVOs, sLaneVOs.length);
		}
		return rtnVOs;
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