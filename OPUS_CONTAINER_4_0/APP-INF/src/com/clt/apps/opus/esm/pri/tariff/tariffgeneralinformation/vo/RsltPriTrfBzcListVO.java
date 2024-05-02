/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriTrfBzcRoutPntVO.java
*@FileTitle : RsltPriTrfBzcRoutPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo;

import java.io.Serializable;
import java.util.List;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriTrfBzcListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<RsltPriTrfBzcVO> rsltPriTrfBzcVOs = null;
	private List<RsltPriTrfBzcRoutPntVO> rsltPriTrfBzcRoutPntVOs = null;
	private List<RsltPriTrfBzcRoutPntVO> rsltPriTrfBzcRoutPntVOs2 = null;
	
	public List<RsltPriTrfBzcVO> getRsltPriTrfBzcVOs() {
		return rsltPriTrfBzcVOs;
	}
	public List<RsltPriTrfBzcRoutPntVO> getRsltPriTrfBzcRoutPntVOs() {
		return rsltPriTrfBzcRoutPntVOs;
	}
	public List<RsltPriTrfBzcRoutPntVO> getRsltPriTrfBzcRoutPntVOs2() {
		return rsltPriTrfBzcRoutPntVOs2;
	}
	public void setRsltPriTrfBzcVOs(List<RsltPriTrfBzcVO> rsltPriTrfBzcVOs) {
		this.rsltPriTrfBzcVOs = rsltPriTrfBzcVOs;
	}
	public void setRsltPriTrfBzcRoutPntVOs(
			List<RsltPriTrfBzcRoutPntVO> rsltPriTrfBzcRoutPntVOs) {
		this.rsltPriTrfBzcRoutPntVOs = rsltPriTrfBzcRoutPntVOs;
	}
	public void setRsltPriTrfBzcRoutPntVOs2(
			List<RsltPriTrfBzcRoutPntVO> rsltPriTrfBzcRoutPntVOs2) {
		this.rsltPriTrfBzcRoutPntVOs2 = rsltPriTrfBzcRoutPntVOs2;
	}
}
