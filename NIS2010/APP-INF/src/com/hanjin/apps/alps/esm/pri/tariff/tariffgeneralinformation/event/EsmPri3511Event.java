/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3511Event.java
*@FileTitle : Tariff General Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.06 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;


/**
 * ESM_PRI_3511 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3511HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM MINAH
 * @see ESM_PRI_3511HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3511Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcVO priTrfBzcVO = null;

	public EsmPri3511Event(){}

	public PriTrfBzcVO getPriTrfBzcVO() {
		return priTrfBzcVO;
	}

	public void setPriTrfBzcVO(PriTrfBzcVO priTrfBzcVO) {
		this.priTrfBzcVO = priTrfBzcVO;
	}
	
	
}