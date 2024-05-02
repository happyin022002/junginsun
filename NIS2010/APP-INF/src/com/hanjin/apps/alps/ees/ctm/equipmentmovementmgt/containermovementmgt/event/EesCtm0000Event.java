/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm00000Event.java
*@FileTitle : [GATENEW Test용]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_CTM_0000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CTM_0000HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see EES_CTM_0000HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0000Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String inputRadio = null;

	public void setInputRadio(String inputRadio) {
		this.inputRadio = inputRadio;
	}

	public String getInputRadio() {
		return inputRadio;
	}


	/** Table Value Object 단건 처리  */
	private FlatFileForGateNewVO flatFileVo = null;

	/** Table Value Object Multi Data 처리 */
	private FlatFileForGateNewVO[] flatFileVOs = null;

	public EesCtm0000Event(){}

	public void setFlatFileVO(FlatFileForGateNewVO flatFileVo){
		this.flatFileVo = flatFileVo;
	}

	public void setFlatFileVOS(FlatFileForGateNewVO[] flatFileVOs){
		this.flatFileVOs = flatFileVOs;
	}

	public FlatFileForGateNewVO getFlatFileVO(){
		return flatFileVo;
	}

	public FlatFileForGateNewVO[] getFlatFileVOS(){
		return flatFileVOs;
	}


	public String flatFileText = null;

	public void setFlatFileText(String flatFileText) {
		this.flatFileText = flatFileText;
	}

	public String getFlatFileText() {
		return flatFileText;
	}

}