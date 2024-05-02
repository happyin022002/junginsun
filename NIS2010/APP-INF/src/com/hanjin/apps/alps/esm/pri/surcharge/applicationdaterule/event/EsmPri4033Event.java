/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4033Event.java
*@FileTitle : Application Date Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.07.07 김민아
* 1.0 Creation
=========================================================
* History
* 2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScgAplyDtRuleVO;


/**
 * ESM_PRI_4003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgAplyDtRuleVO priScgAplyDtRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs = null;
	
	private RsltCdListVO rsltCdListVO = null;
	
	public EsmPri4033Event(){}

	public PriScgAplyDtRuleVO getPriScgAplyDtRuleVO() {
		return priScgAplyDtRuleVO;
	}

	public PriScgAplyDtRuleVO[] getPriScgAplyDtRuleVOs() {
		PriScgAplyDtRuleVO[] rtnVOs = null;
		if (this.priScgAplyDtRuleVOs != null) {
			rtnVOs = new PriScgAplyDtRuleVO[priScgAplyDtRuleVOs.length];
			System.arraycopy(priScgAplyDtRuleVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	public void setPriScgAplyDtRuleVO(PriScgAplyDtRuleVO priScgAplyDtRuleVO) {
		this.priScgAplyDtRuleVO = priScgAplyDtRuleVO;
	}

	public void setPriScgAplyDtRuleVOs(PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs) {
		if(priScgAplyDtRuleVOs != null){
			PriScgAplyDtRuleVO[] tmpVOs = new PriScgAplyDtRuleVO[priScgAplyDtRuleVOs.length];
			System.arraycopy(priScgAplyDtRuleVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgAplyDtRuleVOs = tmpVOs;
		}
//		PriScgAplyDtRuleVOs = priScgAplyDtRuleVOs;
	}
	
	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}
}