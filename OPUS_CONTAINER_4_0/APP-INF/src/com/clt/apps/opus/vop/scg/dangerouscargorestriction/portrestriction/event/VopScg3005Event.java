/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg3005Event.java
*@FileTitle : UN No. Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.06 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgPortRstrVO;


/**
 * VOP_SCG_3005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_3005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_3005HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg3005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgPortRstrVO scgImdgPortRstrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgPortRstrVO[] scgImdgPortRstrVOs = null;

	public VopScg3005Event(){}
	
	public void setScgImdgPortRstrVO(ScgImdgPortRstrVO scgImdgPortRstrVO){
		this. scgImdgPortRstrVO = scgImdgPortRstrVO;
	}

	public void setScgImdgPortRstrVOS(ScgImdgPortRstrVO[] scgImdgPortRstrVOs){
		if(scgImdgPortRstrVOs != null){
			ScgImdgPortRstrVO[] tmpVOs = Arrays.copyOf(scgImdgPortRstrVOs, scgImdgPortRstrVOs.length);
			this.scgImdgPortRstrVOs = tmpVOs;
		}
	}

	public ScgImdgPortRstrVO getScgImdgPortRstrVO(){
		return scgImdgPortRstrVO;
	}

	public ScgImdgPortRstrVO[] getScgImdgPortRstrVOS(){
		ScgImdgPortRstrVO[] rtnVOs = null;
		if (this.scgImdgPortRstrVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgPortRstrVOs, scgImdgPortRstrVOs.length);
		}
		return rtnVOs;
	}

}