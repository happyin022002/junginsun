/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0002Event.java
*@FileTitle : Container Type/Size Update/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.05 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	/** Table Value Object 조회 조건 및 단건 처리 */
	private ContainerTypeSizeCodeVO containerTypeSizeCodeVO = null;

	/** Table Value Object Multi Data 처리 */
	private ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs = null;
	
		
	public EesMst0002Event(){}	
	
	public void setContainerTypeSizeCodeVOS(ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs){		       
		  if (containerTypeSizeCodeVOs != null) {
			  ContainerTypeSizeCodeVO[] tmpVOs = new ContainerTypeSizeCodeVO[containerTypeSizeCodeVOs.length];
			   System.arraycopy(containerTypeSizeCodeVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.containerTypeSizeCodeVOs = tmpVOs;
			  }

	}
	
	public ContainerTypeSizeCodeVO getContainerTypeSizeCodeVO() {
		return containerTypeSizeCodeVO;
	}	
	
	public ContainerTypeSizeCodeVO[] getContainerTypeSizeCodeVOS(){
		ContainerTypeSizeCodeVO[] tmpVOs = null;
		  if (this.containerTypeSizeCodeVOs != null) {
		   tmpVOs = new ContainerTypeSizeCodeVO[containerTypeSizeCodeVOs.length];
		   System.arraycopy(containerTypeSizeCodeVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}	
	
	
}