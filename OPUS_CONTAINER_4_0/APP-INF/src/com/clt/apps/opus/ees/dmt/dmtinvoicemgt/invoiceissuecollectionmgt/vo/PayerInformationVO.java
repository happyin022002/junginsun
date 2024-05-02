/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayerInformationVO.java
*@FileTitle : Payer정보를 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10. 16.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10. 16. 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PayerInformationVO {
	
	private DmtPayrInfoVO dmtPayrInfoVO = null;
	
	
	private List<DmtPayrCntcPntVO> dmtPayrCntcPntVOs = null;

	public DmtPayrInfoVO getDmtPayrInfoVO() {
		return dmtPayrInfoVO;
	}

	public List<DmtPayrCntcPntVO> getDmtPayrCntcPntVOs() {
		return dmtPayrCntcPntVOs;
	}

	public void setDmtPayrInfoVO(DmtPayrInfoVO dmtPayrInfoVO) {
		this.dmtPayrInfoVO = dmtPayrInfoVO;
	}

	public void setDmtPayrCntcPntVOs(DmtPayrCntcPntVO[] dmtPayrCntcPntVOList) {
		if(dmtPayrCntcPntVOList != null && dmtPayrCntcPntVOList.length > 0) {
			dmtPayrCntcPntVOs = new ArrayList<DmtPayrCntcPntVO>();
			for(int i = 0 ; i < dmtPayrCntcPntVOList.length ; i++ ) {
				dmtPayrCntcPntVOs.add(dmtPayrCntcPntVOList[i]);
			}
		}
	}
	
	public void setDmtPayrCntcPntVOList(List<DmtPayrCntcPntVO> dmtPayrCntcPntVOList) {
		this.dmtPayrCntcPntVOs = dmtPayrCntcPntVOList;
	}
	
}
