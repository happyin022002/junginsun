/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDownloadBCImpl.java
*@FileTitle : Korea Manifest List Download BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.05.25 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischCYCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischCYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischLocCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.EntryTpCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.EntryTpVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.MrnCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.MrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.WareHouseCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.WareHouseVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0329EventResponse,KorManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface KorCustomsReportBC {

	/**
	 * 한국세관에 다운로드된 내역을 조회
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return List<BkgCstmsKrDlHisVO>
	 * @exception EventException
	 */
	public List<BkgCstmsKrDlHisVO> searchDownLoadHist (BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws EventException;

	/**
	 * Discharging CY Code List 조회
	 * @param DischLocCondVO dischLocCondVO
	 * @return DischLocVO[]
	 * @exception EventException
	 */
	public DischLocVO[] searchDischCYCodeList(DischLocCondVO dischLocCondVO) throws EventException;

	/**
	 * Discharging CY Code List 처리 (추가/수정/삭제)
	 * @param DischLocCondVO[] dischLocCondVOs
	 * @exception EventException
	 */
	public void manageDiscCYCodeList(DischLocCondVO[] dischLocCondVOs) throws EventException;

	/**
	 * 세관 Transmit History조회
	 * @param ReportHistCondVO reportHistContainer
	 * @return ReportHistDetailVO
	 * @exception EventException
	 */
	public ReportHistDetailVO searchTransmitHist(ReportHistCondVO reportHistContainer) throws EventException;

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry
	 *
	 * @param EntryTpCondVO entryTpCondVO
	 * @return EntryTpVO[]
	 * @exception EventException
	 */
	public EntryTpVO[] searchCstmEntryTpList(EntryTpCondVO entryTpCondVO) throws EventException;

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code 추가/수정/삭제
	 * @param EntryTpCondVO[] entryTpCondVOs
	 * @exception EventException
	 */
	public void manageCstmEntryTpList(EntryTpCondVO[] entryTpCondVOs) throws EventException;

	/**
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회
	 * @param DischCYCondVO dischCYCondVO
	 * @return DischCYVO[]
	 * @exception EventException
	 */
	public DischCYVO[] searchDischCYList(DischCYCondVO dischCYCondVO) throws EventException;

	/**
	 * Korea에서 입/출항 선박 신고 적하목록 전송 문서의 상세내역 조회
	 * @param TransmitHistDtlCondVO transmitHistDtlCondVO
	 * @return TransmitHistDtlVO[]
	 * @exception EventException
	 */ 
	public TransmitHistDtlVO[] searchTransmitHistDtl(TransmitHistDtlCondVO transmitHistDtlCondVO) throws EventException;

	/**
	 * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse (Bonded Area) Detail을 조회
	 * @param WareHouseCondVO warehouseCondVO
	 * @return WareHouseVO[]
	 * @exception EventException
	 */
	public WareHouseVO[] searchWareHouseInfo(WareHouseCondVO warehouseCondVO) throws EventException;

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param MrnCondVO mrnCondVO
	 * @return MrnVO[]
	 * @exception EventException
	 */
	public MrnVO[] searchMRNNoList(MrnCondVO mrnCondVO) throws EventException;

	/**
	 * 하선 신고서 RD 인쇄를 위한 데이터 조회
	 * @param DischPrintCondVO[] dischPrintCondVOs
	 * @return DischPrintListVO[]
	 * @exception EventException
	 */
	public DischPrintListVO[] searchDischPrintList(DischPrintCondVO[] dischPrintCondVOs) throws EventException;

	/**
	 * 적하목록 RD 인쇄를 위한 데이터 조회
	 * @param ImpPrintCondVO[] impPrintCondVOs
	 * @return ImpPrintListVO[]
	 * @exception EventException
	 */
	public ImpPrintListVO[] searchImpCgoManiPrtList(ImpPrintCondVO[] impPrintCondVOs) throws EventException;

	/**
	 * 관세청에서 수신된 응답문서 조회
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return RcvHistVO[]
	 * @exception EventException
	 */
	public RcvHistVO[] searchReceiveAckHist(RcvHistCondVO rcvHistCondVO) throws EventException;

}