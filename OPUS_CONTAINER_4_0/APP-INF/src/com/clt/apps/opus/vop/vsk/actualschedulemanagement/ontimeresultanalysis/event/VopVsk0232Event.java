/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0232Event.java
*@FileTitle : Target VVD & Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.26 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0232 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0232HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0232HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0232Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ResultRemarkVO resultRemarkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ResultRemarkVO[] resultRemarkVOs = null;

	public VopVsk0232Event(){}

	/**
	 * @return the resultRemarkVO
	 */
	public ResultRemarkVO getResultRemarkVO() {
		return resultRemarkVO;
	}

	/**
	 * @param resultRemarkVO the resultRemarkVO to set
	 */
	public void setResultRemarkVO(ResultRemarkVO resultRemarkVO) {
		this.resultRemarkVO = resultRemarkVO;
	}

	/**
	 * @return the resultRemarkVOs
	 */
	public ResultRemarkVO[] getResultRemarkVOs() {
		ResultRemarkVO[] rtnVOs = null;
		if (this.resultRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(resultRemarkVOs, resultRemarkVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param resultRemarkVOs the resultRemarkVOs to set
	 */
	public void setResultRemarkVOs(ResultRemarkVO[] resultRemarkVOs) {
		if(resultRemarkVOs != null){
			ResultRemarkVO[] tmpVOs = Arrays.copyOf(resultRemarkVOs, resultRemarkVOs.length);
			this.resultRemarkVOs = tmpVOs;
		}
	}

}