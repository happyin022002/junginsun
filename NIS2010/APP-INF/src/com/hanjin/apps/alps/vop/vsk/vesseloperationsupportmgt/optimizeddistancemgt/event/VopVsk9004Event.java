
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf1052Event.java
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;


/**
 * VOP_OPF_1052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_1052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_1052HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk9004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OptimizedDistanceVO optimizedDistanceVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private OptimizedDistanceVO[] optimizedDistanceVOs = null;


	public VopVsk9004Event(){}
	

	public OptimizedDistanceVO getOptimizedDistanceVO() {
		return optimizedDistanceVO;
	}

	public void setOptimizedDistanceVO(OptimizedDistanceVO optimizedDistanceVO) {
		this.optimizedDistanceVO = optimizedDistanceVO;
	}

	public OptimizedDistanceVO[] getOptimizedDistanceVOs() {
		OptimizedDistanceVO[] rtnVOs =  null;
		if(this.optimizedDistanceVOs != null){
			rtnVOs = new OptimizedDistanceVO[optimizedDistanceVOs.length];
			System.arraycopy(optimizedDistanceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return optimizedDistanceVOs;
	}

	public void setOptimizedDistanceVOs(OptimizedDistanceVO[] optimizedDistanceVOs) {
		if(optimizedDistanceVOs != null){
			OptimizedDistanceVO[] tmpVOs = new OptimizedDistanceVO[optimizedDistanceVOs.length];
			System.arraycopy(optimizedDistanceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.optimizedDistanceVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.optimizedDistanceVOs = optimizedDistanceVOs;
	}
}