/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0027Event.java
*@FileTitle : revenue lane
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.event;
 
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.RLaneGroupVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RLaneGroupVO rLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RLaneGroupVO[] rLaneVOs = null;
	
	private String rLaneCd = null;
	
	private String ofcCd = null;
	
	private String slanCd = null;
	
	private String trdCd = null;
	
	private String strdCd = null;
	
	private String rqstNo = null;
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0027Event(){}
	
	public void setRLaneGroupVO(RLaneGroupVO rLaneVO){
		this. rLaneVO = rLaneVO;
	}

	public void setRLaneGroupVOS(RLaneGroupVO[] rLaneVOs){
		if(rLaneVOs != null){
			RLaneGroupVO[] tmpVOs = java.util.Arrays.copyOf(rLaneVOs, rLaneVOs.length);
			this.rLaneVOs = tmpVOs;
		}
	}
	
	public void setRLaneCd(String rLaneCd){
		this. rLaneCd = rLaneCd;
	}
	
	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}
	
	public void setSlanCd(String slanCd){
		this. slanCd = slanCd;
	}
	
	public void setTrdCd(String trdCd){
		this. trdCd = trdCd;
	}
	
	public void setStrdCd(String strdCd){
		this. strdCd = strdCd;
	}

	public String getStrdCd(){
		return strdCd;
	}

	public String getTrdCd(){
		return trdCd;
	}

	public String getSlanCd(){
		return slanCd;
	}

	public String getOfcCd(){
		return ofcCd;
	}

	public String getRLaneCd(){
		return rLaneCd;
	}

	public RLaneGroupVO getRLaneGroupVO(){
		return rLaneVO;
	}

	public RLaneGroupVO[] getRLaneGroupVOS(){
		RLaneGroupVO[] rtnVOs = null;
		if (this.rLaneVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(rLaneVOs, rLaneVOs.length);
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