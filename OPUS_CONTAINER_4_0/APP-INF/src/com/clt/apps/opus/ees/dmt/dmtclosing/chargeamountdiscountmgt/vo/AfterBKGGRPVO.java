/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGGRPVO.java
*@FileTitle : AfterBKGGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterBKGGRPVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AfterProgressVO afterProgressVO = null;
	
	private List<AfterBKGRequestVO> afterBKGRequestVOS = null;
	
	private List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOS = null;

	public void setAfterProgressVO(AfterProgressVO afterProgressVO) {
		this.afterProgressVO = afterProgressVO;
	}
	
	public void setAfterBKGRequestVOS(AfterBKGRequestVO[] afterBKGRequestVOS) {
		if (afterBKGRequestVOS != null && afterBKGRequestVOS.length > 0) {
			this.afterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			for (int i = 0 ; i < afterBKGRequestVOS.length ; i++) {
				this.afterBKGRequestVOS.add(afterBKGRequestVOS[i]);
			}
		}
	}
	
	public void setAfterBKGCNTRRequestVOS(AfterBKGCNTRRequestVO[] afterBKGCNTRRequestVOS) {
		if (afterBKGCNTRRequestVOS != null && afterBKGCNTRRequestVOS.length > 0) {
			this.afterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			for (int i = 0 ; i < afterBKGCNTRRequestVOS.length ; i++) {
				this.afterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVOS[i]);
			}
		}
	}
	
	public AfterProgressVO getAfterProgressVO() {
		return afterProgressVO;
	}
	
	public List<AfterBKGRequestVO> getAfterBKGRequestVOS() {
		return afterBKGRequestVOS;
	}

	public List<AfterBKGCNTRRequestVO> getAfterBKGCNTRRequestVOS() {
		return afterBKGCNTRRequestVOS;
	}
}