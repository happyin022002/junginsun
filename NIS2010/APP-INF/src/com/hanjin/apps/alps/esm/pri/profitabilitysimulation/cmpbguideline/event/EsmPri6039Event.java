/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6039Event.java
*@FileTitle : CMPB Guideline- SVC Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.07 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;


/**
 * ESM_PRI_6039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCmpbGlineBseVO priCmpbGlineBseVO = null;

	/**
	 * @return the priCmpbGlineBseVO
	 */
	public PriCmpbGlineBseVO getPriCmpbGlineBseVO() {
		return priCmpbGlineBseVO;
	}

	/**
	 * @param priCmpbGlineBseVO the priCmpbGlineBseVO to set
	 */
	public void setPriCmpbGlineBseVO(PriCmpbGlineBseVO priCmpbGlineBseVO) {
		this.priCmpbGlineBseVO = priCmpbGlineBseVO;
	}

	
	
}