/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0045Event.java
*@FileTitle : DG Abbreviation (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.08 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgAbbrVO;


/**
 * VMS_SCG-0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0045HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgAbbrVO scgImdgAbbrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgAbbrVO[] scgImdgAbbrVOs = null;

	public VopScg0045Event(){}
	
	public void setScgImdgAbbrVO(ScgImdgAbbrVO scgImdgAbbrVO){
		this. scgImdgAbbrVO = scgImdgAbbrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgAbbrVOS(ScgImdgAbbrVO[] scgImdgAbbrVOs){
		if (scgImdgAbbrVOs != null) {
			ScgImdgAbbrVO[] tmpVOs = new ScgImdgAbbrVO[scgImdgAbbrVOs.length];
			System.arraycopy(scgImdgAbbrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgAbbrVOs = tmpVOs;
		}
	}

	public ScgImdgAbbrVO getScgImdgAbbrVO(){
		return scgImdgAbbrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgAbbrVO[] getScgImdgAbbrVOS(){
		ScgImdgAbbrVO[] rtnVOs = null;
		if (this.scgImdgAbbrVOs != null) {
			rtnVOs = new ScgImdgAbbrVO[scgImdgAbbrVOs.length];
			System.arraycopy(scgImdgAbbrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}