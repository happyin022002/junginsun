/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0005Event.java
*@FileTitle : I/B China Agent Information for Lane / Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.13 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaInfoForLaneVO chinaInfoForLaneVO = null;

	/** Table Value Object Multi Data 처리 */
	private ChinaInfoForLaneVO[] chinaInfoForLaneVOs = null;

	public EsmAcm0005Event() {}

	public ChinaInfoForLaneVO getChinaInfoForLaneVO() {
		return chinaInfoForLaneVO;
	}

	public void setChinaInfoForLaneVO(ChinaInfoForLaneVO chinaInfoForLaneVO) {
		this.chinaInfoForLaneVO = chinaInfoForLaneVO;
	}

	public ChinaInfoForLaneVO[] getChinaInfoForLaneVOs() {
		ChinaInfoForLaneVO[] rtnVOs = null;
		if (this.chinaInfoForLaneVOs != null) {
			rtnVOs = Arrays.copyOf(chinaInfoForLaneVOs, chinaInfoForLaneVOs.length);
		}
		return rtnVOs;
	}

	public void setChinaInfoForLaneVOs(ChinaInfoForLaneVO[] chinaInfoForLaneVOs) {
		if(chinaInfoForLaneVOs != null){
			ChinaInfoForLaneVO[] tmpVOs = Arrays.copyOf(chinaInfoForLaneVOs, chinaInfoForLaneVOs.length);
			this.chinaInfoForLaneVOs  = tmpVOs;
		}
	}


}