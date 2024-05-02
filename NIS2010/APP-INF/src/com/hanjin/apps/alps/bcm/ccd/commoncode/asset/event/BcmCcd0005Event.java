/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0005Event.java
*@FileTitle : ContainerType
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.24 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;


/**
 * BCM_CCD_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Container Type */
	private String cntrTpCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerTypeVO containerTypeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ContainerTypeVO[] containerTypeVOs = null;

	public BcmCcd0005Event(){}

	public void setContainerTypeVO(ContainerTypeVO containerTypeVO){
		this. containerTypeVO = containerTypeVO;
	}
	
	public void setContainerTypeVOS(ContainerTypeVO[] containerTypeVOs){
		if(containerTypeVOs != null){
			ContainerTypeVO[] tmpVOs = java.util.Arrays.copyOf(containerTypeVOs, containerTypeVOs.length);
			this.containerTypeVOs = tmpVOs;
		}
	}

	public ContainerTypeVO getContainerTypeVO(){
		return containerTypeVO;
	}

	public ContainerTypeVO[] getContainerTypeVOS(){
		ContainerTypeVO[] rtnVOs = null;
		if (this.containerTypeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(containerTypeVOs, containerTypeVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	public String getCntrTpCd() {
		return cntrTpCd;
	}
}