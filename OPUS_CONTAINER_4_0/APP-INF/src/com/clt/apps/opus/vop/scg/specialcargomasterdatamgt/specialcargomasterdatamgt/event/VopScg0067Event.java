/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0067Event.java
*@FileTitle : Excepted Quantities (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.08 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;


/**
 * VMS_SCG-0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0067HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgExptQtyVO scgImdgExptQtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgExptQtyVO[] scgImdgExptQtyVOs = null;

	public VopScg0067Event(){}
	
	public void setScgImdgExptQtyVO(ScgImdgExptQtyVO scgImdgExptQtyVO){
		this. scgImdgExptQtyVO = scgImdgExptQtyVO;
	}

	public void setScgImdgExptQtyVOS(ScgImdgExptQtyVO[] scgImdgExptQtyVOs){
		if(scgImdgExptQtyVOs != null){
			ScgImdgExptQtyVO[] tmpVOs = Arrays.copyOf(scgImdgExptQtyVOs, scgImdgExptQtyVOs.length);
			this.scgImdgExptQtyVOs = tmpVOs;
		}
	}

	public ScgImdgExptQtyVO getScgImdgExptQtyVO(){
		return scgImdgExptQtyVO;
	}

	public ScgImdgExptQtyVO[] getScgImdgExptQtyVOS(){
		ScgImdgExptQtyVO[] rtnVOs = null;
		if (this.scgImdgExptQtyVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgExptQtyVOs, scgImdgExptQtyVOs.length);
		}
		return rtnVOs;
	}

}