/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk00291Event.java
*@FileTitle : SKD Status (Delay Status)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.10 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0029-1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0029-1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0029-1HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ResultChangeStatusVO resultChangeStatusVO = null;
	private ResultSkipStatusVO resultSkipStatusVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private ResultChangeStatusVO[] resultChangeStatusVOs = null;
	private ResultSkipStatusVO[] resultSkipStatusVOs = null;

	public VopVsk0029Event(){}
	
	public void setResultChangeStatusVO(ResultChangeStatusVO resultChangeStatusVO){
		this.resultChangeStatusVO = resultChangeStatusVO;
	}
	
	public void setResultSkipStatusVO(ResultSkipStatusVO resultSkipStatusVO){
		this.resultSkipStatusVO = resultSkipStatusVO;
	}

	public void setResultChangeStatusVOS(ResultChangeStatusVO[] resultChangeStatusVOs){
		if(resultChangeStatusVOs != null){
			ResultChangeStatusVO[] tmpVOs = new ResultChangeStatusVO[resultChangeStatusVOs.length];
			System.arraycopy(resultChangeStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.resultChangeStatusVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. resultChangeStatusVOs = resultChangeStatusVOs;
	}
	
	public void setResultSkipStatusVOS(ResultSkipStatusVO[] resultSkipStatusVOs){
		if(resultSkipStatusVOs != null){
			ResultSkipStatusVO[] tmpVOs = new ResultSkipStatusVO[resultSkipStatusVOs.length];
			System.arraycopy(resultSkipStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.resultSkipStatusVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. resultSkipStatusVOs = resultSkipStatusVOs;
	}

	public ResultChangeStatusVO getResultChangeStatusVO(){
		return resultChangeStatusVO;
	}
	
	public ResultSkipStatusVO getResultSkipStatusVO(){
		return resultSkipStatusVO;
	}

	public ResultChangeStatusVO[] getResultChangeStatusVOS(){
		ResultChangeStatusVO[] rtnVOs =  null;
		if(this.resultChangeStatusVOs != null){
			rtnVOs = new ResultChangeStatusVO[resultChangeStatusVOs.length];
			System.arraycopy(resultChangeStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return resultChangeStatusVOs;
	}
	
	public ResultSkipStatusVO[] getResultSkipStatusVOS(){
		ResultSkipStatusVO[] rtnVOs =  null;
		if(this.resultSkipStatusVOs != null){
			rtnVOs = new ResultSkipStatusVO[resultSkipStatusVOs.length];
			System.arraycopy(resultSkipStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return resultSkipStatusVOs;
	}

}