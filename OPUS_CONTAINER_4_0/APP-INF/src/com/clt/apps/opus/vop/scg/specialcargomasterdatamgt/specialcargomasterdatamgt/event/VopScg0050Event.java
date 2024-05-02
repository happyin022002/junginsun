/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0050Event.java
*@FileTitle : SPCL CGO RSO (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgCrrRstrVO;


/**
 * VOP_SCG_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCrrRstrVO scgImdgCrrRstrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs = null;

	public VopScg0050Event(){}
	
	public void setScgImdgCrrRstrVO(ScgImdgCrrRstrVO scgImdgCrrRstrVO){
		this. scgImdgCrrRstrVO = scgImdgCrrRstrVO;
	}

	public void setScgImdgCrrRstrVOS(ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs){
		if(scgImdgCrrRstrVOs != null){
			ScgImdgCrrRstrVO[] tmpVOs = Arrays.copyOf(scgImdgCrrRstrVOs, scgImdgCrrRstrVOs.length);
			this.scgImdgCrrRstrVOs = tmpVOs;
		}
	}

	public ScgImdgCrrRstrVO getScgImdgCrrRstrVO(){
		return scgImdgCrrRstrVO;
	}

	public ScgImdgCrrRstrVO[] getScgImdgCrrRstrVOS(){
		ScgImdgCrrRstrVO[] rtnVOs = null;
		if (this.scgImdgCrrRstrVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgCrrRstrVOs, scgImdgCrrRstrVOs.length);
		}
		return rtnVOs;
	}

}