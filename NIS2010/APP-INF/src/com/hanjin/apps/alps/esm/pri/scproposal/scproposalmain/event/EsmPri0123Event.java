/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri0123Event.java
*@FileTitle : S/C Filed Cancel History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 이석준
*@LastVersion : 1.0

* 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SUK JOON LEE
 * @see ESM_PRI_0123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	private PriSpFiledCancelSearchVO priSpFiledCancelSearchVO    = null;
	private PriSpFiledCancelSearchVO[] priSpFiledCancelSearchVOs = null;
	public PriSpFiledCancelSearchVO getPriSpFiledCancelSearchVO() {
		return priSpFiledCancelSearchVO;
	}
	public void setPriSpFiledCancelSearchVO(
			PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) {
		this.priSpFiledCancelSearchVO = priSpFiledCancelSearchVO;
	}
	public PriSpFiledCancelSearchVO[] getPriSpFiledCancelSearchVOs() {
		return priSpFiledCancelSearchVOs;
	}
	public void setPriSpFiledCancelSearchVOs(
			PriSpFiledCancelSearchVO[] priSpFiledCancelSearchVOs) {
		this.priSpFiledCancelSearchVOs = priSpFiledCancelSearchVOs;
	}
 
	
}