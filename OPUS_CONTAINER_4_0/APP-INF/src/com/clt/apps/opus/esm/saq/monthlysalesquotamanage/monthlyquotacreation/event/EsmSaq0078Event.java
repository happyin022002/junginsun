/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmSaq0077Event.java
 *@FileTitle : Model Result
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.04
 *@LastModifier : 김종호
 *@LastVersion : 1.1
 * 2006-12-21 byyoo
 * 1.0 최초 생성
 * 2009.08.31 김종호
 * 1.1 Creation (new F/W 전환작업)   
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_SAQ_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SAQ_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BaseDataInterfaceVO baseDataInterfaceVO = null;

	/** Table Value Object Multi Data 처리 */
	private BaseDataInterfaceVO[] baseDataInterfaceVOS = null;

	public EsmSaq0078Event() {
	}

	public BaseDataInterfaceVO getBaseDataInterfaceVO() {
		return baseDataInterfaceVO;
	}

	public void setBaseDataInterfaceVO(BaseDataInterfaceVO baseDataInterfaceVO) {
		this.baseDataInterfaceVO = baseDataInterfaceVO;
	}

	public BaseDataInterfaceVO[] getBaseDataInterfaceVOS() {
		BaseDataInterfaceVO[] rtnVOs = null;
		if (this.baseDataInterfaceVOS != null) {
			rtnVOs = Arrays.copyOf(baseDataInterfaceVOS, baseDataInterfaceVOS.length);
		}
		return rtnVOs;
	}

	public void setBaseDataInterfaceVOS(BaseDataInterfaceVO[] baseDataInterfaceVOS) {
		if(baseDataInterfaceVOS != null){
			BaseDataInterfaceVO[] tmpVOs = Arrays.copyOf(baseDataInterfaceVOS, baseDataInterfaceVOS.length);
			this.baseDataInterfaceVOS  = tmpVOs;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}