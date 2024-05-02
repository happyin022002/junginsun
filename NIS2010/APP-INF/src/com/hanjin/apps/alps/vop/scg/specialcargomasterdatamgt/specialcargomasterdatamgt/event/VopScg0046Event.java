/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0046Event.java
*@FileTitle : No. & Symbols in SEG Table/Mixed STWG (Creation)
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
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;


/**
 * VMS_SCG-0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0046HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSegrSymVO scgImdgSegrSymVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSegrSymVO[] scgImdgSegrSymVOs = null;

	public VopScg0046Event(){}
	
	public void setScgImdgSegrSymVO(ScgImdgSegrSymVO scgImdgSegrSymVO){
		this. scgImdgSegrSymVO = scgImdgSegrSymVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgSegrSymVOS(ScgImdgSegrSymVO[] scgImdgSegrSymVOs){
		if (scgImdgSegrSymVOs != null) {
			ScgImdgSegrSymVO[] tmpVOs = new ScgImdgSegrSymVO[scgImdgSegrSymVOs.length];
			System.arraycopy(scgImdgSegrSymVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgSegrSymVOs = tmpVOs;
		}
	}

	public ScgImdgSegrSymVO getScgImdgSegrSymVO(){
		return scgImdgSegrSymVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgSegrSymVO[] getScgImdgSegrSymVOS(){
		ScgImdgSegrSymVO[] rtnVOs = null;
		if (this.scgImdgSegrSymVOs != null) {
			rtnVOs = new ScgImdgSegrSymVO[scgImdgSegrSymVOs.length];
			System.arraycopy(scgImdgSegrSymVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}