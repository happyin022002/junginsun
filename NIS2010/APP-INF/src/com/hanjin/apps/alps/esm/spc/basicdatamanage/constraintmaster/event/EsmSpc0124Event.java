/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0124Event.java
*@FileTitle : Container Type/Size
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ESM_SPC_0124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yang Dong Hun
 * @see ESM_SPC_0124HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0124Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EsmSpc0124Event(){}
	private ConditionVO conditionVO = null;
	
	private GetCodeSelectVO getCodeSelectVO = null;
	private String bkgNo = null;
	
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public GetCodeSelectVO getGetCodeSelectVO() {
		return getCodeSelectVO;
	}
	public void setGetCodeSelectVO(GetCodeSelectVO getCodeSelectVO) {
		this.getCodeSelectVO = getCodeSelectVO;
	}
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
}
