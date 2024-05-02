/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0109Event.java
*@FileTitle :  HJS Chemical Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemicalHistoryVO;


/**
 * VOP_SCG_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_SCG_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgChemicalHistoryVO scgChemicalHistoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgChemicalHistoryVO[] scgChemicalHistoryVOs = null;

	public VopScg0109Event(){}
	
	public void setScgChemicalHistoryVO(ScgChemicalHistoryVO scgChemicalHistoryVO){
		this. scgChemicalHistoryVO = scgChemicalHistoryVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgChemicalHistoryVOS(ScgChemicalHistoryVO[] scgChemicalHistoryVOs){
		if (scgChemicalHistoryVOs != null) {
			ScgChemicalHistoryVO[] tmpVOs = new ScgChemicalHistoryVO[scgChemicalHistoryVOs.length];
			System.arraycopy(scgChemicalHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgChemicalHistoryVOs = tmpVOs;
		}
	}

	public ScgChemicalHistoryVO getScgChemicalHistoryVO(){
		return scgChemicalHistoryVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgChemicalHistoryVO[] getScgChemicalHistoryVOS(){
		ScgChemicalHistoryVO[] rtnVOs = null;
		if (this.scgChemicalHistoryVOs != null) {
			rtnVOs = new ScgChemicalHistoryVO[scgChemicalHistoryVOs.length];
			System.arraycopy(scgChemicalHistoryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}