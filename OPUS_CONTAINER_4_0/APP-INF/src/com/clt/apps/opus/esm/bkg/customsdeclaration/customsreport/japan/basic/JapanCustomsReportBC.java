/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanManifestListDownloadBCImpl.java
 *@FileTitle : ESM_BKG-0462
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.05.18 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanCustomsReportBCImpl 참조
 * @since J2EE 1.6
 */
public interface JapanCustomsReportBC {

	/**
	 * 세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param TransmitHistCondVO transmitHistCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchTransmitHist(TransmitHistCondVO transmitHistCondVO) throws EventException;

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return List<RcvHistDetailVO>
	 * @exception EventException
	 */
	public List<RcvHistDetailVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException;

	/**
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 *
	 * @param JapanSendLogCondVO japanSendLogCondVO
	 * @return List<BkgCstmsJpSndLogVO>
	 * @exception EventException
	 */
	public List<BkgCstmsJpSndLogVO> searchSendLog(JapanSendLogCondVO japanSendLogCondVO) throws EventException;

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param JapanReceiveLogCondVO japanReceiveLogCondVO
	 * @return List<BkgCstmsJpRcvLogVO>
	 * @exception EventException
	 */
	public List<BkgCstmsJpRcvLogVO> searchReceiveLog(JapanReceiveLogCondVO japanReceiveLogCondVO) throws EventException;

}
