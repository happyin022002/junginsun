/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg100301Event.java
*@FileTitle : Numbers &amp; symbols in segregation table between various Classes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.28 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;


/**
 * VOP_SCG-1003-01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-1003-01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-1003-01HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg100301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSegrSymVO scgImdgSegrSymVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSegrSymVO[] scgImdgSegrSymVOs = null;

	public VopScg100301Event(){}
	
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