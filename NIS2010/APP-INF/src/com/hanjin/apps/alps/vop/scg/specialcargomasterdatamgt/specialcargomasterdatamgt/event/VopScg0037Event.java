/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0037Event.java
*@FileTitle : Definition of Class (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.04 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;


/**
 * VMS_SCG-0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0037HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgClssCdVO scgImdgClssCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgClssCdVO[] scgImdgClssCdVOs = null;

	public VopScg0037Event(){}
	
	public void setScgImdgClssCdVO(ScgImdgClssCdVO scgImdgClssCdVO){
		this. scgImdgClssCdVO = scgImdgClssCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgClssCdVOS(ScgImdgClssCdVO[] scgImdgClssCdVOs){
		if (scgImdgClssCdVOs != null) {
			ScgImdgClssCdVO[] tmpVOs = new ScgImdgClssCdVO[scgImdgClssCdVOs.length];
			System.arraycopy(scgImdgClssCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgClssCdVOs = tmpVOs;
		}
	}

	public ScgImdgClssCdVO getScgImdgClssCdVO(){
		return scgImdgClssCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgClssCdVO[] getScgImdgClssCdVOS(){
		ScgImdgClssCdVO[] rtnVOs = null;
		if (this.scgImdgClssCdVOs != null) {
			rtnVOs = new ScgImdgClssCdVO[scgImdgClssCdVOs.length];
			System.arraycopy(scgImdgClssCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}