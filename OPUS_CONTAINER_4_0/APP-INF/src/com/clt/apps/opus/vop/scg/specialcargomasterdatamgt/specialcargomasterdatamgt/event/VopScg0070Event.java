/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0070Event.java
*@FileTitle : Segregation Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.19 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;


/**
 * VOP_SCG_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0070HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSegrGrpVO scgImdgSegrGrpVO = null;
	private ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSegrGrpVO[] scgImdgSegrGrpVOs = null;
	private ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtlVOs = null;

	public VopScg0070Event(){}
	
	public void setScgImdgSegrGrpVO(ScgImdgSegrGrpVO scgImdgSegrGrpVO){
		this. scgImdgSegrGrpVO = scgImdgSegrGrpVO;
	}
	
	public void setScgImdgSegrGrpDtlVO(ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO){
		this. scgImdgSegrGrpDtlVO = scgImdgSegrGrpDtlVO;
	}

	public void setScgImdgSegrGrpVOS(ScgImdgSegrGrpVO[] scgImdgSegrGrpVOs){
		if(scgImdgSegrGrpVOs != null){
			ScgImdgSegrGrpVO[] tmpVOs = Arrays.copyOf(scgImdgSegrGrpVOs, scgImdgSegrGrpVOs.length);
			this.scgImdgSegrGrpVOs = tmpVOs;
		}
	}
	
	public void setScgImdgSegrGrpDtlVOS(ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtlVOs){
		if(scgImdgSegrGrpDtlVOs != null){
			ScgImdgSegrGrpDtlVO[] tmpVOs = Arrays.copyOf(scgImdgSegrGrpDtlVOs, scgImdgSegrGrpDtlVOs.length);
			this.scgImdgSegrGrpDtlVOs = tmpVOs;
		}
	}

	public ScgImdgSegrGrpVO getScgImdgSegrGrpVO(){
		return scgImdgSegrGrpVO;
	}
	
	public ScgImdgSegrGrpDtlVO getScgImdgSegrGrpDtlVO(){
		return scgImdgSegrGrpDtlVO;
	}

	public ScgImdgSegrGrpVO[] getScgImdgSegrGrpVOS(){
		ScgImdgSegrGrpVO[] rtnVOs = null;
		if (this.scgImdgSegrGrpVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgSegrGrpVOs, scgImdgSegrGrpVOs.length);
		}
		return rtnVOs;
	}
	
	public ScgImdgSegrGrpDtlVO[] getScgImdgSegrGrpDtlVOS(){
		ScgImdgSegrGrpDtlVO[] rtnVOs = null;
		if (this.scgImdgSegrGrpDtlVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgSegrGrpDtlVOs, scgImdgSegrGrpDtlVOs.length);
		}
		return rtnVOs;
	}

}