/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0064Event.java
*@FileTitle : No. & Symbols in SEG Table/Mixed STWG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgCrrRstrVO;


/**
 * VOP_SCG_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0064HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCrrRstrVO scgImdgCrrRstrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs = null;

	public VopScg0064Event(){}
	
	public void setScgImdgCrrRstrVO(ScgImdgCrrRstrVO scgImdgCrrRstrVO){
		this. scgImdgCrrRstrVO = scgImdgCrrRstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgCrrRstrVOS(ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs){
		if (scgImdgCrrRstrVOs != null) {
			ScgImdgCrrRstrVO[] tmpVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgCrrRstrVOs = tmpVOs;
		}
	}

	public ScgImdgCrrRstrVO getScgImdgCrrRstrVO(){
		return scgImdgCrrRstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgCrrRstrVO[] getScgImdgCrrRstrVOS(){
		ScgImdgCrrRstrVO[] rtnVOs = null;
		if (this.scgImdgCrrRstrVOs != null) {
			rtnVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}