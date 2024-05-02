/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_9515Event.java
*@FileTitle : Yard Group (Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_9515 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_9515HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Un
 * @see VOP_VSK_9515HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk9515Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private YardGroupVO yardGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private YardGroupVO[] yardGroupVOs = null;

	public VopVsk9515Event(){}

	public YardGroupVO getYardGroupVO() {
		return yardGroupVO;
	}

	public void setYardGroupVO(YardGroupVO yardGroupVO) {
		this.yardGroupVO = yardGroupVO;
	}

	public YardGroupVO[] getYardGroupVOs() {
		YardGroupVO[] rtnVOs =  null;
		if(this.yardGroupVOs != null){
			rtnVOs = new YardGroupVO[yardGroupVOs.length];
			System.arraycopy(yardGroupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return yardGroupVOs;
	}

	public void setYardGroupVOs(YardGroupVO[] yardGroupVOs) {
		if(yardGroupVOs != null){
			YardGroupVO[] tmpVOs = new YardGroupVO[yardGroupVOs.length];
			System.arraycopy(yardGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardGroupVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.yardGroupVOs = yardGroupVOs;
	}
	
}