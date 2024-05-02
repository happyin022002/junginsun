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
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;


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

	public void setScgImdgSegrSymVOS(ScgImdgSegrSymVO[] scgImdgSegrSymVOs){
		if(scgImdgSegrSymVOs != null){
			ScgImdgSegrSymVO[] tmpVOs = Arrays.copyOf(scgImdgSegrSymVOs, scgImdgSegrSymVOs.length);
			this.scgImdgSegrSymVOs = tmpVOs;
		}
	}

	public ScgImdgSegrSymVO getScgImdgSegrSymVO(){
		return scgImdgSegrSymVO;
	}

	public ScgImdgSegrSymVO[] getScgImdgSegrSymVOS(){
		ScgImdgSegrSymVO[] rtnVOs = null;
		if (this.scgImdgSegrSymVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgSegrSymVOs, scgImdgSegrSymVOs.length);
		}
		return rtnVOs;
	}

}