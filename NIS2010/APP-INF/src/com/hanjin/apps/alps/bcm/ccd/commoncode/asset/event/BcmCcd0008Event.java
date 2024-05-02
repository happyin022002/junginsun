/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0008Event.java
*@FileTitle : Container Type Size
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.25 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event;
  
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;


/**
 * BCM_CCD_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Vessel Code */
	private String vslCd = "";
	
	/** Carrier Code */
	private String crrCd = "";
	
	/** Country Code */
	private String vslRgstCntCd = "";
	
	/** Port Code */
	private String rgstPortCd = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerVesselVO containerVesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ContainerVesselVO[] containerVesselVOs = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public BcmCcd0008Event(){}

	public void setContainerVesselVO(ContainerVesselVO containerVesselVO){
		this. containerVesselVO = containerVesselVO;
	}
	
	public void setContainerVesselVOS(ContainerVesselVO[] containerVesselVOs){
		if(containerVesselVOs != null){
			ContainerVesselVO[] tmpVOs = java.util.Arrays.copyOf(containerVesselVOs, containerVesselVOs.length);
			this.containerVesselVOs = tmpVOs;
		}
	}

	public ContainerVesselVO getContainerVesselVO(){
		return containerVesselVO;
	}

	public ContainerVesselVO[] getContainerVesselVOS(){
		ContainerVesselVO[] rtnVOs = null;
		if (this.containerVesselVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(containerVesselVOs, containerVesselVOs.length);
		}
		return rtnVOs;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	public String getCrrCd() {
		return crrCd;
	}
	
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	public String getVslRgstCntCd() {
		return vslRgstCntCd;
	}
	
	public void setRgstPortCd(String rgstPortCd) {
		this.rgstPortCd = rgstPortCd;
	}
	
	public String getRgstPortCd() {
		return rgstPortCd;
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