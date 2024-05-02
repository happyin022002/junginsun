/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NotePropVO.java
*@FileTitle : NotePropVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.11.01 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.inlandrates.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.PriTrfInlndRtVO;
import com.clt.syscommon.common.table.PriTrfInlndVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PriTrfInlndListVO {
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndRtVO[] priTrfInlndRtVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndVO[] priTrfInlndVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndParamVO priTrfInlndParamVO = null;
	
	/** File Upload Key */
	private List<String> keys = null;

	public PriTrfInlndRtVO[] getPriTrfInlndRtVOs() {
		return priTrfInlndRtVOs;
	}

	public void setPriTrfInlndRtVOs(PriTrfInlndRtVO[] priTrfInlndRtVOs) {
		this.priTrfInlndRtVOs = priTrfInlndRtVOs;
	}

	public PriTrfInlndVO[] getPriTrfInlndVOs() {
		return priTrfInlndVOs;
	}

	public void setPriTrfInlndVOs(PriTrfInlndVO[] priTrfInlndVOs) {
		this.priTrfInlndVOs = priTrfInlndVOs;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public PriTrfInlndParamVO getPriTrfInlndParamVO() {
		return priTrfInlndParamVO;
	}

	public void setPriTrfInlndParamVO(PriTrfInlndParamVO priTrfInlndParamVO) {
		this.priTrfInlndParamVO = priTrfInlndParamVO;
	}


}
