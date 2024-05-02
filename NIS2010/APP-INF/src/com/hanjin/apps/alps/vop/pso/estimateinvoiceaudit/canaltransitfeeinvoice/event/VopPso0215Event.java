/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0215Event.java
*@FileTitle : File Download
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.05 진마리아
* 1.0 Creation
* 
* History
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0215HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AtchFileVO atchFileVO = null;
	
	public VopPso0215Event(){}

	public AtchFileVO getAtchFileVO() {
		return atchFileVO;
	}

	public void setAtchFileVO(AtchFileVO atchFileVO) {
		this.atchFileVO = atchFileVO;
	}
}