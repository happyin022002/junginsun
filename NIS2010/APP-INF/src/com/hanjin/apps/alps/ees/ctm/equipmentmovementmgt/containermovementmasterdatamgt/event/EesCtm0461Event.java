/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCtm0461Event.java
*@FileTitle : US AMS Location
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0461 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0461HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_CTM_0461HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0461Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsAmsLocationListVO usLmsLocationListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsAmsLocationListVO[] usLmsLocationListVOs = null;

	public EesCtm0461Event(){}
	
	public void setUsLmsLocationListVO(UsAmsLocationListVO usLmsLocationListVO){
		this. usLmsLocationListVO = usLmsLocationListVO;
	}

	public void setUsLmsLocationListVOS(UsAmsLocationListVO[] usLmsLocationListVOs){
		this. usLmsLocationListVOs = usLmsLocationListVOs;
	}

	public UsAmsLocationListVO getUsLmsLocationListVO(){
		return usLmsLocationListVO;
	}

	public UsAmsLocationListVO[] getUsLmsLocationListVOS(){
		return usLmsLocationListVOs;
	}

}