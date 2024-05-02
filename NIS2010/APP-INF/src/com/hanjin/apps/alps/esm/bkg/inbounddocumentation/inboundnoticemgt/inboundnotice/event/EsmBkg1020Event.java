/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1020Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.17
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.17 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgArrNtcWdVO;

/**
 * esm_bkg_1020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son Yun Seuk
 * @see ESM_BKG_1020HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1020Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgArrNtcWdVO arrNtcWdVO = null;
	private BkgArrNtcWdVO[] arrNtcWdVOs = null;


	public BkgArrNtcWdVO[] getArrNtcWdVOs() {
		return arrNtcWdVOs;
	}


	public void setArrNtcWdVOs(BkgArrNtcWdVO[] arrNtcWdVOs) {
		this.arrNtcWdVOs = arrNtcWdVOs;
	}


	public EsmBkg1020Event() {
	}


	/**
	 * @return the arrNtcWdVO
	 */
	public BkgArrNtcWdVO getArrNtcWdVO() {
		return arrNtcWdVO;
	}


	/**
	 * @param arrNtcWdVO the arrNtcWdVO to set
	 */
	public void setArrNtcWdVO(BkgArrNtcWdVO arrNtcWdVO) {
		this.arrNtcWdVO = arrNtcWdVO;
	}
}