/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0032Event.java
*@FileTitle : On-Time Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.04 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0032에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0032-1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ResultOnTimeRatioVO resultOnTimeRatioVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ResultOnTimeRatioVO[] resultOnTimeRatioVOs = null;

	public VopVsk0032Event(){}
	
	public void setResultOnTimeRatioVO(ResultOnTimeRatioVO resultOnTimeRatioVO){
		this.resultOnTimeRatioVO = resultOnTimeRatioVO;
	}

	public void setResultOnTimeRatioVOS(ResultOnTimeRatioVO[] resultOnTimeRatioVOs){
		if(resultOnTimeRatioVOs != null){
			ResultOnTimeRatioVO[] tmpVOs = new ResultOnTimeRatioVO[resultOnTimeRatioVOs.length];
			System.arraycopy(resultOnTimeRatioVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.resultOnTimeRatioVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.resultOnTimeRatioVOs = resultOnTimeRatioVOs;
	}

	public ResultOnTimeRatioVO getResultOnTimeRatioVO(){
		return resultOnTimeRatioVO;
	}

	public ResultOnTimeRatioVO[] getResultOnTimeRatioVOS(){
		ResultOnTimeRatioVO[] rtnVOs =  null;
		if(this.resultOnTimeRatioVOs != null){
			rtnVOs = new ResultOnTimeRatioVO[resultOnTimeRatioVOs.length];
			System.arraycopy(resultOnTimeRatioVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return resultOnTimeRatioVOs;
	}

}