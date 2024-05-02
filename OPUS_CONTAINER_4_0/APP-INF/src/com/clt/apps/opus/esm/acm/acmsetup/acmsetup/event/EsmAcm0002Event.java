/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0002Event.java
*@FileTitle : Container TP/SZ Grouping
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.16 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.CntrTpSzGrpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrTpSzGrpVO cntrTpSzGrpVO = null;

	/** Table Value Object Multi Data 처리 */
	private CntrTpSzGrpVO[] cntrTpSzGrpVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs = null;

	public EsmAcm0002Event() {}

	public CntrTpSzGrpVO getCntrTpSzGrpVO() {
		return cntrTpSzGrpVO;
	}

	public void setCntrTpSzGrpVO(CntrTpSzGrpVO cntrTpSzGrpVO) {
		this.cntrTpSzGrpVO = cntrTpSzGrpVO;
	}

	public CntrTpSzGrpVO[] getCntrTpSzGrpVOs() {
		CntrTpSzGrpVO[] rtnVOs = null;
		if (this.cntrTpSzGrpVOs != null) {
			rtnVOs = Arrays.copyOf(cntrTpSzGrpVOs, cntrTpSzGrpVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrTpSzGrpVOs(CntrTpSzGrpVO[] cntrTpSzGrpVOs) {
		if(cntrTpSzGrpVOs != null){
			CntrTpSzGrpVO[] tmpVOs = Arrays.copyOf(cntrTpSzGrpVOs, cntrTpSzGrpVOs.length);
			this.cntrTpSzGrpVOs  = tmpVOs;
		}
	}

	public CntrTpSzGrpVO[] getCntrTpSzGrpCodeSlctVOs() {
		CntrTpSzGrpVO[] rtnVOs = null;
		if (this.cntrTpSzGrpCodeSlctVOs != null) {
			rtnVOs = Arrays.copyOf(cntrTpSzGrpCodeSlctVOs, cntrTpSzGrpCodeSlctVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrTpSzGrpCodeSlctVOs(CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs) {
		if(cntrTpSzGrpCodeSlctVOs != null){
			CntrTpSzGrpVO[] tmpVOs = Arrays.copyOf(cntrTpSzGrpCodeSlctVOs, cntrTpSzGrpCodeSlctVOs.length);
			this.cntrTpSzGrpCodeSlctVOs  = tmpVOs;
		}
	}

}