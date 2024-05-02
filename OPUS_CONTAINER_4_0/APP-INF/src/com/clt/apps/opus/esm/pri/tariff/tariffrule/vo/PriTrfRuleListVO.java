/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriTrfRuleListVO.java
*@FileTitle : PriTrfRuleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.11.01 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.tariffrule.vo;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.PriTrfRuleVO;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PriTrfRuleListVO {

	/** Table Value Object Multi Data 처리 */
	private PriTrfRuleVO[] priTrfRuleVOs = null;
	
	private String trfRuleCtnt = null;

	
	public PriTrfRuleVO[] getPriTrfRuleVOs() {
		return priTrfRuleVOs;
	}

	public void setPriTrfRuleVOs(PriTrfRuleVO[] priTrfRuleVOs) {
		this.priTrfRuleVOs = priTrfRuleVOs;
	}

	public String getTrfRuleCtnt() {
		return trfRuleCtnt;
	}

	public void setTrfRuleCtnt(String trfRuleCtnt) {
		this.trfRuleCtnt = trfRuleCtnt;
	}	
	
	
}
