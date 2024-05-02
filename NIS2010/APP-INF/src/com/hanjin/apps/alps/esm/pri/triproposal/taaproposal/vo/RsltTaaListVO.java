/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropVO.java
*@FileTitle : RsltPropVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.04.16 변영주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo;

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

public class RsltTaaListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<RsltTaaMnVO> rsltTaaMnVOs = null;
	private List<RsltTaaTriListVO> rsltTaaTriListVOs = null;

	public List<RsltTaaMnVO> getRsltTaaMnVOs() {
		return rsltTaaMnVOs;
	}
	public void setRsltTaaMnVOs(List<RsltTaaMnVO> rsltTaaMnVOs) {
		this.rsltTaaMnVOs = rsltTaaMnVOs;
	}
	public List<RsltTaaTriListVO> getRsltTaaTriListVOs() {
		return rsltTaaTriListVOs;
	}
	public void setRsltTaaTriListVOs(List<RsltTaaTriListVO> rsltTaaTriListVOs) {
		this.rsltTaaTriListVOs = rsltTaaTriListVOs;
	}
}
