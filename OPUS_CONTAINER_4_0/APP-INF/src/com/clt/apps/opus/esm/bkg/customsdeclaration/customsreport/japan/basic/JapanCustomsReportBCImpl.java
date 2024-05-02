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

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration.JapanCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462EventResponse, JapanManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanCustomsReportBCImpl extends BasicCommandSupport implements JapanCustomsReportBC {

	// Database Access Object
	private transient JapanCustomsReportDBDAO dbDao = null;

	/**
	 * JapanCustomsReportBCImpl 객체 생성<br>
	 * JapanManifestListDownloadDBDAO 생성한다.<br>
	 */
	public JapanCustomsReportBCImpl() {
		dbDao = new JapanCustomsReportDBDAO();
	}



	/**
	 * 세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param TransmitHistCondVO transmitHistCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchTransmitHist(TransmitHistCondVO transmitHistCondVO) throws EventException {
		JapanTransmitHistCondVO japanTransmitHistCondVO =(JapanTransmitHistCondVO) transmitHistCondVO;
		List<JapanManifestListTransmitHistDetailVO> japanManifestListTransmitHistDetailVOs = null;
		List<ManifestListDetailVO> manifestListDetailVOs = null;

		try {
			japanTransmitHistCondVO.setStartSndDt(japanTransmitHistCondVO.getStartSndDt() + " " + japanTransmitHistCondVO.getStartSndDt2());
			japanTransmitHistCondVO.setEndSndDt(japanTransmitHistCondVO.getEndSndDt() + " " + japanTransmitHistCondVO.getEndSndDt2());
			japanManifestListTransmitHistDetailVOs = dbDao.searchJpcusSendList(japanTransmitHistCondVO);

			manifestListDetailVOs =(List<ManifestListDetailVO>) (Object) japanManifestListTransmitHistDetailVOs;
			return manifestListDetailVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return List<RcvHistDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RcvHistDetailVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException {
		JapanRcvHistCondVO japanRcvHistCondVO =(JapanRcvHistCondVO) rcvHistCondVO;
		List<JapanManifestListReceiveHistDetailVO> japanManifestListReceiveHistDetailVOs = null;
		List<RcvHistDetailVO> rcvHistDetailVOs = null;

		try {
			japanRcvHistCondVO.setStartRcvDt(japanRcvHistCondVO.getStartRcvDt() + " " + japanRcvHistCondVO.getStartRcvDt2());
			japanRcvHistCondVO.setEndRcvDt(japanRcvHistCondVO.getEndRcvDt() + " " + japanRcvHistCondVO.getEndRcvDt2());

			if ("JP24".equals(japanRcvHistCondVO.getJp24Check())) {
				japanManifestListReceiveHistDetailVOs = dbDao.searchJp24ReceiveList(japanRcvHistCondVO);
			} else {
				if ("E".equals(japanRcvHistCondVO.getErrorCheck())) {
					japanManifestListReceiveHistDetailVOs = dbDao.searchJpcusMfrErrList(japanRcvHistCondVO);
				} else {
					japanManifestListReceiveHistDetailVOs = dbDao.searchJpcusReceiveList(japanRcvHistCondVO);
				}
			}

			rcvHistDetailVOs =(List<RcvHistDetailVO>) (Object) japanManifestListReceiveHistDetailVOs;
			return rcvHistDetailVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 *
	 * @param JapanSendLogCondVO japanSendLogCondVO
	 * @return List<BkgCstmsJpSndLogVO>
	 * @exception EventException
	 */
	public List<BkgCstmsJpSndLogVO> searchSendLog(JapanSendLogCondVO japanSendLogCondVO) throws EventException {
		List<BkgCstmsJpSndLogVO> returnBkgCstmsJpSndLogVOList = new ArrayList<BkgCstmsJpSndLogVO>();
		BkgCstmsJpSndLogVO returnBkgCstmsJpSndLogVO = null;

		try {
			String ediSndMsg = dbDao.searchJpcusSendLog(japanSendLogCondVO);
			if (!"".equals(ediSndMsg.trim())) {
				String[] ediSndMsgCtntRowArray = ediSndMsg.split("\n");
				for(int i=0; i<ediSndMsgCtntRowArray.length; i++) {
					returnBkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
					returnBkgCstmsJpSndLogVO.setLogSeq(Integer.toString(i+1));
					returnBkgCstmsJpSndLogVO.setEdiSndMsgCtnt(ediSndMsgCtntRowArray[i]);
					returnBkgCstmsJpSndLogVOList.add(returnBkgCstmsJpSndLogVO);
				}
			}
			return returnBkgCstmsJpSndLogVOList;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param JapanReceiveLogCondVO japanReceiveLogCondVO
	 * @return List<BkgCstmsJpRcvLogVO>
	 * @exception EventException
	 */
	public List<BkgCstmsJpRcvLogVO> searchReceiveLog(JapanReceiveLogCondVO japanReceiveLogCondVO) throws EventException {
		List<BkgCstmsJpRcvLogVO> returnBkgCstmsJpRcvLogVOList = new ArrayList<BkgCstmsJpRcvLogVO>();
		BkgCstmsJpRcvLogVO returnBkgCstmsJpSndLogVO = null;

		try {
			String ediSndMsg = dbDao.searchJpcusReceiveLog(japanReceiveLogCondVO);
			if (!"".equals(ediSndMsg.trim())) {
				String[] ediSndMsgCtntRowArray = ediSndMsg.split("\n");
				for(int i=0; i<ediSndMsgCtntRowArray.length; i++) {
					returnBkgCstmsJpSndLogVO = new BkgCstmsJpRcvLogVO();
					returnBkgCstmsJpSndLogVO.setRcvSeq(Integer.toString(i+1));
					returnBkgCstmsJpSndLogVO.setEdiRcvMsgCtnt(ediSndMsgCtntRowArray[i]);
					returnBkgCstmsJpRcvLogVOList.add(returnBkgCstmsJpSndLogVO);
				}
			}
			return returnBkgCstmsJpRcvLogVOList;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}
