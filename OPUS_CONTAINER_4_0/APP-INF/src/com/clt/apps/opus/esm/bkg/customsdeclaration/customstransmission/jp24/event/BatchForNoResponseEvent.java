/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BatchForNoResponseEvent.java
*@FileTitle : BatchForNoResponseEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier :
*@LastVersion : 1.0
* 2014.11.26
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpReceiveLogVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * receiving from EDI<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class BatchForNoResponseEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdvJpReceiveLogVO advJpReceiveLogVO = null;

	public BatchForNoResponseEvent() {}

	public AdvJpReceiveLogVO getAdvJpReceiveLogVO() {
		return this.advJpReceiveLogVO;
	}

	public void setAdvJpReceiveLogVO(AdvJpReceiveLogVO advJpReceiveLogVO) {
		this.advJpReceiveLogVO = advJpReceiveLogVO;
	}
}
