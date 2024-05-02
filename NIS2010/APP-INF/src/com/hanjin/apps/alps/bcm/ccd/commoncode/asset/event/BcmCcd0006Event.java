/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0006Event.java
*@FileTitle : Container Size
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
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;


/**
 * BCM_CCD_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Container Size */
	private String cntrSzCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerSizeVO containerSizeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ContainerSizeVO[] containerSizeVOs = null;

	public BcmCcd0006Event(){}

	public void setContainerSizeVO(ContainerSizeVO containerSizeVO){
		this. containerSizeVO = containerSizeVO;
	}
	
	public void setContainerSizeVOS(ContainerSizeVO[] containerSizeVOs){
		if(containerSizeVOs != null){
			ContainerSizeVO[] tmpVOs = java.util.Arrays.copyOf(containerSizeVOs, containerSizeVOs.length);
			this.containerSizeVOs = tmpVOs;
		}
	}

	public ContainerSizeVO getContainerSizeVO(){
		return containerSizeVO;
	}

	public ContainerSizeVO[] getContainerSizeVOS(){
		ContainerSizeVO[] rtnVOs = null;
		if (this.containerSizeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(containerSizeVOs, containerSizeVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	public String getCntrSzCd() {
		return cntrSzCd;
	}
}