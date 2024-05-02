/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmSaq0178Event.java
*@FileTitle : Model Result
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : Da-eun, Park
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataFromCoaListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAQ_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0178Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	public BaseDataFromCoaListVO getBaseDataFromCoaListVO() {
		return baseDataFromCoaListVO;
	}

	public void setBaseDataFromCoaListVO(BaseDataFromCoaListVO baseDataFromCoaListVO) {
		this.baseDataFromCoaListVO = baseDataFromCoaListVO;
	}

	public BaseDataFromCoaListVO[] getBaseDataFromCoaListVOS() {
		BaseDataFromCoaListVO[] rtnVOs = null;
		if (this.baseDataFromCoaListVOS != null) {
			rtnVOs = Arrays.copyOf(baseDataFromCoaListVOS, baseDataFromCoaListVOS.length);
		}
		return rtnVOs;
	}

	public void setBaseDataFromCoaListVOS(	BaseDataFromCoaListVO[] baseDataFromCoaListVOS) {
		if(baseDataFromCoaListVOS != null){
			BaseDataFromCoaListVO[] tmpVOs = Arrays.copyOf(baseDataFromCoaListVOS, baseDataFromCoaListVOS.length);
			this.baseDataFromCoaListVOS  = tmpVOs;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BaseDataFromCoaListVO baseDataFromCoaListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BaseDataFromCoaListVO[] baseDataFromCoaListVOS = null;	

	public EsmSaq0178Event(){}

}