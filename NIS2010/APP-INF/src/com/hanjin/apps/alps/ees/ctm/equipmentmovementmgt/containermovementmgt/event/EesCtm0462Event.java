/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCtm0462Event.java
*@FileTitle : Auto-created Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0462 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0462HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_CTM_0462HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0462Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AutoCreStsListVO autoCreStsListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AutoCreStsListVO[] autoCreStsListVOs = null;

	public EesCtm0462Event(){}
	
	public void setAutoCreStsListVO(AutoCreStsListVO autoCreStsListVO){
		this. autoCreStsListVO = autoCreStsListVO;
	}

	public void setAutoCreStsListVOS(AutoCreStsListVO[] autoCreStsListVOs){
		this. autoCreStsListVOs = autoCreStsListVOs;
	}

	public AutoCreStsListVO getAutoCreStsListVO(){
		return autoCreStsListVO;
	}

	public AutoCreStsListVO[] getAutoCreStsListVOS(){
		return autoCreStsListVOs;
	}

}