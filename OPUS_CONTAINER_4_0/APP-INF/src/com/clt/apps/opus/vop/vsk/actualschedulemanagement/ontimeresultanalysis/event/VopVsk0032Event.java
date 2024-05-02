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
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.clt.framework.support.layer.event.EventSupport;


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
			ResultOnTimeRatioVO[] tmpVOs = Arrays.copyOf(resultOnTimeRatioVOs, resultOnTimeRatioVOs.length);
			this.resultOnTimeRatioVOs = tmpVOs;
		}
	}

	public ResultOnTimeRatioVO getResultOnTimeRatioVO(){
		return resultOnTimeRatioVO;
	}

	public ResultOnTimeRatioVO[] getResultOnTimeRatioVOS(){
		ResultOnTimeRatioVO[] rtnVOs = null;
		if (this.resultOnTimeRatioVOs != null) {
			rtnVOs = Arrays.copyOf(resultOnTimeRatioVOs, resultOnTimeRatioVOs.length);
		}
		return rtnVOs;
	}

}