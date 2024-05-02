/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0704Event.java
*@FileTitle : Port Canal Tier Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : Lee Hye Min
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event;

import java.util.Arrays;

import com.clt.syscommon.common.table.VskPortCnlTrScgVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0704 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0704HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Hye Min
 * @see VOP_VSK_0704HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0704Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortCnlTrScgVO vskPortCnlTrScgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPortCnlTrScgVO[] vskPortCnlTrScgVOs = null;
	
	public VopVsk0704Event(){}
	
	
	public VskPortCnlTrScgVO getVskPortCnlTrScgVO(){
		return vskPortCnlTrScgVO;
	}
	
	public void setVskPortCnlTrScgVO(VskPortCnlTrScgVO vskPortCnlTrScgVO){
		this. vskPortCnlTrScgVO = vskPortCnlTrScgVO;
	}

	public VskPortCnlTrScgVO[] getVskPortCnlTrScgVOS(){
		VskPortCnlTrScgVO[] rtnVOs = null;
		if (this.vskPortCnlTrScgVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortCnlTrScgVOs, vskPortCnlTrScgVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVskPortCnlTrScgVOS(VskPortCnlTrScgVO[] vskPortCnlTrScgVOs){
		if(vskPortCnlTrScgVOs != null){
			VskPortCnlTrScgVO[] tmpVOs = Arrays.copyOf(vskPortCnlTrScgVOs, vskPortCnlTrScgVOs.length);
			this.vskPortCnlTrScgVOs = tmpVOs;
		}
	}
	
}