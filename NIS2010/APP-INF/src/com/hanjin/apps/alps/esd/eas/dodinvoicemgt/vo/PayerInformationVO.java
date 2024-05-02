/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayerInformationVO.java
*@FileTitle : Payer정보를 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.11  KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PayerInformationVO {
	
	private EasPayrInfoVO easPayrInfoVO = null;
	
	
	private List<EasPayrCntcPntVO> easPayrCntcPntVOs = null;

	public EasPayrInfoVO getEasPayrInfoVO() {
		return easPayrInfoVO;
	}

	public List<EasPayrCntcPntVO> getEasPayrCntcPntVOs() {
		return easPayrCntcPntVOs;
	}

	public void setEasPayrInfoVO(EasPayrInfoVO easPayrInfoVO) {
		this.easPayrInfoVO = easPayrInfoVO;
	}

	public void setEasPayrCntcPntVOs(EasPayrCntcPntVO[] easPayrCntcPntVOList) {
		if(easPayrCntcPntVOList != null && easPayrCntcPntVOList.length > 0) {
			easPayrCntcPntVOs = new ArrayList<EasPayrCntcPntVO>();
			for(int i = 0 ; i < easPayrCntcPntVOList.length ; i++ ) {
				easPayrCntcPntVOs.add(easPayrCntcPntVOList[i]);
			}
		}
	}
	
	public void setEasPayrCntcPntVOList(List<EasPayrCntcPntVO> easPayrCntcPntVOList) {
		this.easPayrCntcPntVOs = easPayrCntcPntVOList;
	}
	
}
