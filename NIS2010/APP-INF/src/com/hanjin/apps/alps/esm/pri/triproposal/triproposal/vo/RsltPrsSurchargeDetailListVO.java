/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltPrsSurchargeDetailListVO.java
 *@FileTitle : RsltPrsSurchargeDetailListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.06
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2009.07.06 송민석
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 송민석
 * @since J2EE 1.5
 */

public class RsltPrsSurchargeDetailListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltPrsSurchargeDetailVO> rsltPrsSurchargeDetailVO = null;
	private List<RsltPrsSurchargeDetailApplicableRouteVO> rsltPrsSurchargeDetailApplicableRouteVO = null;

	public List<RsltPrsSurchargeDetailVO> getRsltPrsSurchargeDetailVOS() {
		return rsltPrsSurchargeDetailVO;
	}

	public void setRsltPrsSurchargeDetailVOS(List<RsltPrsSurchargeDetailVO> rsltPrsSurchargeDetailVO) {
		this.rsltPrsSurchargeDetailVO = rsltPrsSurchargeDetailVO;
	}

	public List<RsltPrsSurchargeDetailApplicableRouteVO> getRsltPrsSurchargeDetailApplicableRouteVOS() {
		return rsltPrsSurchargeDetailApplicableRouteVO;
	}

	public void setRsltPrsSurchargeDetailApplicableRouteVOS(List<RsltPrsSurchargeDetailApplicableRouteVO> rsltPrsSurchargeDetailApplicableRouteVO) {
		this.rsltPrsSurchargeDetailApplicableRouteVO = rsltPrsSurchargeDetailApplicableRouteVO;
	}

}
