/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropInqListVO.java
*@FileTitle : RsltPropInqListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.14 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class RsltPropInqListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<RsltPropMnInqVO> RsltPropMnInqVOs = null;
	private List<RsltPropMnScpInqListVO> RsltPropMnScpInqListVOs = null;
	public List<RsltPropMnInqVO> getRsltPropMnInqVOs() {
		return RsltPropMnInqVOs;
	}
	public void setRsltPropMnInqVOs(List<RsltPropMnInqVO> rsltPropMnInqVOs) {
		RsltPropMnInqVOs = rsltPropMnInqVOs;
	}
	public List<RsltPropMnScpInqListVO> getRsltPropMnScpInqListVOs() {
		return RsltPropMnScpInqListVOs;
	}
	public void setRsltPropMnScpInqListVOs(
			List<RsltPropMnScpInqListVO> rsltPropMnScpInqListVOs) {
		RsltPropMnScpInqListVOs = rsltPropMnScpInqListVOs;
	}	
	


	

	
	
}
