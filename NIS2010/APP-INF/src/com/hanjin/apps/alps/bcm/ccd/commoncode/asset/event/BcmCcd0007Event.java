/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0007Event.java
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
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;


/**
 * BCM_CCD_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Container Size */
	private String cntrTpSzCd = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerTypeSizeVO containerTypeSizeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ContainerTypeSizeVO[] containerTypeSizeVOs = null;

	public BcmCcd0007Event(){}

	public void setContainerTypeSizeVO(ContainerTypeSizeVO containerTypeSizeVO){
		this. containerTypeSizeVO = containerTypeSizeVO;
	}
	
	public void setContainerTypeSizeVOS(ContainerTypeSizeVO[] containerTypeSizeVOs){
		if(containerTypeSizeVOs != null){
			ContainerTypeSizeVO[] tmpVOs = java.util.Arrays.copyOf(containerTypeSizeVOs, containerTypeSizeVOs.length);
			this.containerTypeSizeVOs = tmpVOs;
		}
	}

	public ContainerTypeSizeVO getContainerTypeSizeVO(){
		return containerTypeSizeVO;
	}

	public ContainerTypeSizeVO[] getContainerTypeSizeVOS(){
		ContainerTypeSizeVO[] rtnVOs = null;
		if (this.containerTypeSizeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(containerTypeSizeVOs, containerTypeSizeVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrTpSzCd(String cntrTpSzCd) {
		this.cntrTpSzCd = cntrTpSzCd;
	}
	
	public String getCntrTpSzCd() {
		return cntrTpSzCd;
	}

}