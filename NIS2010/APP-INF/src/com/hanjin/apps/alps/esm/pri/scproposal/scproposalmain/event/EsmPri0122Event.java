/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : EsmPri0122Event.java
 *@FileTitle : S/C Filed Cancel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.15
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
 * 2013.01.15 이은섭[CHM-201322418-01] SC fling cancel 기능 관련 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpFileCxlHisVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;

/**
 * ESM_PRI_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author SUK JOON LEE
 * @see ESM_PRI_0122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpFiledCancelSearchVO priSpFiledCancelSearchVO = null;
	private PriSpFiledCancelSearchVO[] priSpFiledCancelSearchVOs = null;
	private PriSpFileCxlHisVO priSpFileCxlHisVO = null;
	private PriSpFileCxlHisVO[] priSpFileCxlHisVOs = null;
	private PriSpProgVO priSpProgVO = null;

	public PriSpFiledCancelSearchVO getPriSpFiledCancelSearchVO() {
		return priSpFiledCancelSearchVO;
	}

	public void setPriSpFiledCancelSearchVO(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) {
		this.priSpFiledCancelSearchVO = priSpFiledCancelSearchVO;
	}

	public PriSpFiledCancelSearchVO[] getPriSpFiledCancelSearchVOs() {
		return priSpFiledCancelSearchVOs;
	}

	public void setPriSpFiledCancelSearchVOs(PriSpFiledCancelSearchVO[] priSpFiledCancelSearchVOs) {
		this.priSpFiledCancelSearchVOs = priSpFiledCancelSearchVOs;
	}

	public PriSpFileCxlHisVO getPriSpFileCxlHisVO() {
		return priSpFileCxlHisVO;
	}

	public void setPriSpFileCxlHisVO(PriSpFileCxlHisVO priSpFileCxlHisVO) {
		this.priSpFileCxlHisVO = priSpFileCxlHisVO;
	}

	public PriSpFileCxlHisVO[] getPriSpFileCxlHisVOs() {
		return priSpFileCxlHisVOs;
	}

	public void setPriSpFileCxlHisVOs(PriSpFileCxlHisVO[] priSpFileCxlHisVOs) {
		this.priSpFileCxlHisVOs = priSpFileCxlHisVOs;
	}

	public PriSpProgVO getPriSpProgVO() {
		return priSpProgVO;
	}

	public void setPriSpProgVO(PriSpProgVO priSpProgVO) {
		this.priSpProgVO = priSpProgVO;
	}
}