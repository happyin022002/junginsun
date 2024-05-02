/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0083Event.java
*@FileTitle : Port Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.02.01 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;


/**
 * VOP_AOM_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0083HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgNonDgCgoKwVO scgNonDgCgoKwVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgNonDgCgoKwVO[] scgNonDgCgoKwVOs = null;

	public VopScg0083Event(){}
	
	public void setScgNonDgCgoKwVO(ScgNonDgCgoKwVO scgNonDgCgoKwVO){
		this. scgNonDgCgoKwVO = scgNonDgCgoKwVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgNonDgCgoKwVOS(ScgNonDgCgoKwVO[] scgNonDgCgoKwVOs){
		if (scgNonDgCgoKwVOs != null) {
			ScgNonDgCgoKwVO[] tmpVOs = new ScgNonDgCgoKwVO[scgNonDgCgoKwVOs.length];
			System.arraycopy(scgNonDgCgoKwVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgNonDgCgoKwVOs = tmpVOs;
		}
	}

	public ScgNonDgCgoKwVO getScgNonDgCgoKwVO(){
		return scgNonDgCgoKwVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgNonDgCgoKwVO[] getScgNonDgCgoKwVOS(){
		ScgNonDgCgoKwVO[] rtnVOs = null;
		if (this.scgNonDgCgoKwVOs != null) {
			rtnVOs = new ScgNonDgCgoKwVO[scgNonDgCgoKwVOs.length];
			System.arraycopy(scgNonDgCgoKwVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}