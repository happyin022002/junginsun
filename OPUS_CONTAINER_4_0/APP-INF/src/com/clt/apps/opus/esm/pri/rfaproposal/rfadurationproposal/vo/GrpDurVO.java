package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo;

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
public class GrpDurVO {

	//private PriSgGrpCmdtVO[] priSgGrpCmdtVOS = null;
	//private PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOS = null;
	/* Column Info */
	private List<RsltPriRpDurVO> rsltPriRpDurVOS = null;
	/* Column Info */
	private List<RsltAuthorityVO> rsltAuthorityVOS = null;
	
	public List<RsltPriRpDurVO> getRsltPriRpDurVOS() {
		return rsltPriRpDurVOS;
	}
	public void setRsltPriRpDurVOS(List<RsltPriRpDurVO> rsltPriRpDurVOS) {
		this.rsltPriRpDurVOS = rsltPriRpDurVOS;
	}
	public List<RsltAuthorityVO> getRsltAuthorityVOS() {
		return rsltAuthorityVOS;
	}
	public void setRsltAuthorityVOS(List<RsltAuthorityVO> rsltAuthorityVOS) {
		this.rsltAuthorityVOS = rsltAuthorityVOS;
	}		
	


	
}