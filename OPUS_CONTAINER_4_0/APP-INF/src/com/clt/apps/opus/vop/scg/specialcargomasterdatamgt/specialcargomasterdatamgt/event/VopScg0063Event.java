/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0063Event.java
*@FileTitle : DG Abbreviation (Inquiry)
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
import com.clt.syscommon.common.table.ScgImdgAbbrVO;


/**
 * VMS_SCG-0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0063HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgAbbrVO scgImdgAbbrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgAbbrVO[] scgImdgAbbrVOs = null;

	public VopScg0063Event(){}
	
	public void setScgImdgAbbrVO(ScgImdgAbbrVO scgImdgAbbrVO){
		this. scgImdgAbbrVO = scgImdgAbbrVO;
	}

	public void setScgImdgAbbrVOS(ScgImdgAbbrVO[] scgImdgAbbrVOs){
		if(scgImdgAbbrVOs != null){
			ScgImdgAbbrVO[] tmpVOs = Arrays.copyOf(scgImdgAbbrVOs, scgImdgAbbrVOs.length);
			this.scgImdgAbbrVOs = tmpVOs;
		}
	}

	public ScgImdgAbbrVO getScgImdgAbbrVO(){
		return scgImdgAbbrVO;
	}

	public ScgImdgAbbrVO[] getScgImdgAbbrVOS(){
		ScgImdgAbbrVO[] rtnVOs = null;
		if (this.scgImdgAbbrVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgAbbrVOs, scgImdgAbbrVOs.length);
		}
		return rtnVOs;
	}

}