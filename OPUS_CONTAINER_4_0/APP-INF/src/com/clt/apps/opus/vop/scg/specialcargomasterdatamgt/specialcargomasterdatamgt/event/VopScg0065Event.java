/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0065Event.java
*@FileTitle : Compatibility Groups of Class 1 (Inquiry)
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
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;


/**
 * VOP_SCG_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0065HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCompGrpVO scgImdgCompGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgCompGrpVO[] scgImdgCompGrpVOs = null;

	public VopScg0065Event(){}
	
	public void setScgImdgCompGrpVO(ScgImdgCompGrpVO scgImdgCompGrpVO){
		this. scgImdgCompGrpVO = scgImdgCompGrpVO;
	}

	public void setScgImdgCompGrpVOS(ScgImdgCompGrpVO[] scgImdgCompGrpVOs){
		if(scgImdgCompGrpVOs != null){
			ScgImdgCompGrpVO[] tmpVOs = Arrays.copyOf(scgImdgCompGrpVOs, scgImdgCompGrpVOs.length);
			this.scgImdgCompGrpVOs = tmpVOs;
		}
	}

	public ScgImdgCompGrpVO getScgImdgCompGrpVO(){
		return scgImdgCompGrpVO;
	}

	public ScgImdgCompGrpVO[] getScgImdgCompGrpVOS(){
		ScgImdgCompGrpVO[] rtnVOs = null;
		if (this.scgImdgCompGrpVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgCompGrpVOs, scgImdgCompGrpVOs.length);
		}
		return rtnVOs;
	}

}