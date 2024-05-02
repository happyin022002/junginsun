package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
/**
 * Container  Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class GrpMqcVO {


	/* Column Info */
	private List<RsltPriSpScpMqcVO> rsltPriSpScpMqcVOS = null;
	public List<RsltPriSpScpMqcVO> getRsltPriSpScpMqcVOS() {
		return rsltPriSpScpMqcVOS;
	}
	public void setRsltPriSpScpMqcVOS(List<RsltPriSpScpMqcVO> rsltPriSpScpMqcVOS) {
		this.rsltPriSpScpMqcVOS = rsltPriSpScpMqcVOS;
	}
	/* Column Info */
	private List<RsltMqcAuthorityVO> rsltMqcAuthorityVOS = null;
	public List<RsltMqcAuthorityVO> getRsltMqcAuthorityVOS() {
		return rsltMqcAuthorityVOS;
	}
	public void setRsltMqcAuthorityVOS(List<RsltMqcAuthorityVO> rsltMqcAuthorityVOS) {
		this.rsltMqcAuthorityVOS = rsltMqcAuthorityVOS;
	}

	
	
	


	
}