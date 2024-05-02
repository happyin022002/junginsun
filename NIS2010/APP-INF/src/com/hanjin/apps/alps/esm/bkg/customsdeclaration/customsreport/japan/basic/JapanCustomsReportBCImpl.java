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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic.CustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration.JapanCustomsReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListRcvLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListSndLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanRcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462EventResponse,JapanManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanCustomsReportBCImpl extends CustomsReportBCImpl {

	// Database Access Object
	private transient JapanCustomsReportDBDAO dbDao = null;

	/**
	 * PanamaCustomsReportBCImpl 객체 생성<br>
	 * PanamaManifestListDownloadDBDAO 생성한다.<br>
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
		JapanTransmitHistCondVO japanTransmitHistCondVO = (JapanTransmitHistCondVO) transmitHistCondVO;
		List<JapanManifestListTransmitHistDetailVO> japanManifestListTransmitHistDetailVOs = null;
		List<ManifestListDetailVO> manifestListDetailVOs = null;
		try {
			japanTransmitHistCondVO.setStartSndDt(japanTransmitHistCondVO.getStartSndDt() + " "
					+ japanTransmitHistCondVO.getStartSndDt2());
			japanTransmitHistCondVO.setEndSndDt(japanTransmitHistCondVO.getEndSndDt() + " "
					+ japanTransmitHistCondVO.getEndSndDt2());
			japanManifestListTransmitHistDetailVOs = dbDao.searchJpcusSendList(japanTransmitHistCondVO);

			manifestListDetailVOs = (List<ManifestListDetailVO>) (Object) japanManifestListTransmitHistDetailVOs;
			return manifestListDetailVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
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
		JapanRcvHistCondVO japanRcvHistCondVO = (JapanRcvHistCondVO) rcvHistCondVO;
		List<JapanManifestListReceiveHistDetailVO> japanManifestListReceiveHistDetailVOs = null;
		List<RcvHistDetailVO> rcvHistDetailVOs = null;
		try {
			japanRcvHistCondVO.setStartRcvDt(japanRcvHistCondVO.getStartRcvDt() + " " + japanRcvHistCondVO.getStartRcvDt2());
			japanRcvHistCondVO.setEndRcvDt(japanRcvHistCondVO.getEndRcvDt() + " " + japanRcvHistCondVO.getEndRcvDt2());

			if ("E".equals(japanRcvHistCondVO.getErrorCheck()) && "MFR".equals(japanRcvHistCondVO.getJpMsgTpCd())) {
				japanManifestListReceiveHistDetailVOs = dbDao.searchJpcusMfrErrList(japanRcvHistCondVO);
			} else if ("JP24".equals(japanRcvHistCondVO.getJp24Check())) {
				japanManifestListReceiveHistDetailVOs = dbDao.searchJp24ReceiveList(japanRcvHistCondVO);
			} else {
				japanManifestListReceiveHistDetailVOs = dbDao.searchJpcusReceiveList(japanRcvHistCondVO);
			}

			rcvHistDetailVOs = (List<RcvHistDetailVO>) (Object) japanManifestListReceiveHistDetailVOs;
			return rcvHistDetailVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 * 
	 * @param sendLogCondVO SendLogCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked" })
	public List<SendLogDetailVO> searchSendLog(SendLogCondVO sendLogCondVO) throws EventException {
		JapanSendLogCondVO japanSendLogCondVO = (JapanSendLogCondVO) sendLogCondVO;
		List<JapanManifestListSndLogDetailVO> japanManifestListSndLogDetailVOs = null;
		List<JapanManifestListSndLogDetailVO> japanManifestListSndLogDetailVOs2 = null;
		List<SendLogDetailVO> sendLogDetailVOs = null;
		try {

			if ( japanSendLogCondVO.getJpSndLogId().equals("DOR") )
			{
				japanManifestListSndLogDetailVOs2 = dbDao.searchJpcusSendLog(japanSendLogCondVO);
				if (japanManifestListSndLogDetailVOs2.size() > 0 )
				{
					
					StringTokenizer token = new StringTokenizer(japanManifestListSndLogDetailVOs2.get(0).getEdiSndMsg(), "\r\n");
					ArrayList tmpArray = new ArrayList();
					while (token.hasMoreTokens()) {
						tmpArray.add(token.nextToken());
					}

					int index = 0;
					for (int i = 0; i < tmpArray.size(); i++) {
						if ( i != 0 )
						{
							JapanManifestListSndLogDetailVO japanManifestListSndLogDetailVO = new JapanManifestListSndLogDetailVO();
							japanManifestListSndLogDetailVO.setSubSeq(i+2+"");
							japanManifestListSndLogDetailVO.setEdiSndMsg(tmpArray.get(i).toString());
							japanManifestListSndLogDetailVO.setTotal(tmpArray.size()-1+"");
							
							if ( index == 0 )
								japanManifestListSndLogDetailVOs2.set(index++, japanManifestListSndLogDetailVO);
							else
								japanManifestListSndLogDetailVOs2.add(index++, japanManifestListSndLogDetailVO);
						}
					}
					
					japanManifestListSndLogDetailVOs = japanManifestListSndLogDetailVOs2;
				}
			} else {
				japanManifestListSndLogDetailVOs = dbDao.searchJpcusSendLog(japanSendLogCondVO);
			}
			

			sendLogDetailVOs = (List<SendLogDetailVO>) (Object) japanManifestListSndLogDetailVOs;
			return sendLogDetailVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 * 
	 * @param ReceiveLogCondVO receiveLogCondVO
	 * @return List<ReceiveLogDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceiveLogDetailVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException {
		JapanReceiveLogCondVO japanReceiveLogCondVO = (JapanReceiveLogCondVO) receiveLogCondVO;
		List<JapanManifestListRcvLogDetailVO> japanManifestListRcvLogDetailVOs = null;
		List<ReceiveLogDetailVO> receiveLogDetailVOs = null;
		try {

			japanManifestListRcvLogDetailVOs = dbDao.searchJpcusReceiveLog(japanReceiveLogCondVO);

			receiveLogDetailVOs = (List<ReceiveLogDetailVO>) (Object) japanManifestListRcvLogDetailVOs;
			return receiveLogDetailVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}
