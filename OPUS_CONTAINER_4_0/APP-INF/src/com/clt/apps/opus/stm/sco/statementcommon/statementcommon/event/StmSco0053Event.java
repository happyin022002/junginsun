/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSco0053Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CenterListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0053Event 참조
 * @since J2EE 1.4
 */

public class StmSco0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리  */
	private CenterListVO centerListVO = null;

	public StmSco0053Event() {}

	public CenterListVO getCenterListVO() {
		return centerListVO;
	}

	public void setCenterListVO(CenterListVO centerListVO) {
		this.centerListVO = centerListVO;
	}

}