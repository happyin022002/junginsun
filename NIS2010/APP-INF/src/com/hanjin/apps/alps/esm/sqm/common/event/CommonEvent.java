/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonEvent.java
*@FileTitle      : CommonEvent
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.10
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.10 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Common 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see COMMON_HTMLAction 참조
 * @since J2EE 1.6
 */
public class CommonEvent extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CommonVO commonVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CommonVO[] commonVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public CommonEvent() {}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public CommonVO getCommonVO() {
		return commonVO;
	}
	
	public void setCommonVO(CommonVO commonVO) {
		this.commonVO = commonVO;
	}
	
	public CommonVO[] getCommonVOs() {
		return commonVOs;
	}
	
	public void setCommonVOs(CommonVO[] commonVOs) {
		this.commonVOs = commonVOs;
	}
}