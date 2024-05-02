/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0044Event.java
*@FileTitle : IMO Type Portable Tanks (Creation)
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
import com.hanjin.syscommon.common.table.ScgImdgTnkTpVO;


/**
 * VMS_SCG-0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0044HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgTnkTpVO scgImdgTnkTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgTnkTpVO[] scgImdgTnkTpVOs = null;

	public VopScg0044Event(){}
	
	public void setScgImdgTnkTpVO(ScgImdgTnkTpVO scgImdgTnkTpVO){
		this. scgImdgTnkTpVO = scgImdgTnkTpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgTnkTpVOS(ScgImdgTnkTpVO[] scgImdgTnkTpVOs){
		if (scgImdgTnkTpVOs != null) {
			ScgImdgTnkTpVO[] tmpVOs = new ScgImdgTnkTpVO[scgImdgTnkTpVOs.length];
			System.arraycopy(scgImdgTnkTpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgTnkTpVOs = tmpVOs;
		}
	}

	public ScgImdgTnkTpVO getScgImdgTnkTpVO(){
		return scgImdgTnkTpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgTnkTpVO[] getScgImdgTnkTpVOS(){
		ScgImdgTnkTpVO[] rtnVOs = null;
		if (this.scgImdgTnkTpVOs != null) {
			rtnVOs = new ScgImdgTnkTpVO[scgImdgTnkTpVOs.length];
			System.arraycopy(scgImdgTnkTpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}