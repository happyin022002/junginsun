/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0042Event.java
*@FileTitle : Packing Instructions/Provisions (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.25 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgPckInstrVO scgImdgPckInstrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgPckInstrVO[] scgImdgPckInstrVOs = null;
	
	private List<String> keys = null;

	public VopScg0042Event(){}

	public void setScgImdgPckInstrVO(ScgImdgPckInstrVO scgImdgPckInstrVO){
		this. scgImdgPckInstrVO = scgImdgPckInstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgPckInstrVOS(ScgImdgPckInstrVO[] scgImdgPckInstrVOs){
		if (scgImdgPckInstrVOs != null) {
			ScgImdgPckInstrVO[] tmpVOs = new ScgImdgPckInstrVO[scgImdgPckInstrVOs.length];
			System.arraycopy(scgImdgPckInstrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgPckInstrVOs = tmpVOs;
		}
	}

	public ScgImdgPckInstrVO getScgImdgPckInstrVO(){
		return scgImdgPckInstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgPckInstrVO[] getScgImdgPckInstrVOS(){
		ScgImdgPckInstrVO[] rtnVOs = null;
		if (this.scgImdgPckInstrVOs != null) {
			rtnVOs = new ScgImdgPckInstrVO[scgImdgPckInstrVOs.length];
			System.arraycopy(scgImdgPckInstrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

}