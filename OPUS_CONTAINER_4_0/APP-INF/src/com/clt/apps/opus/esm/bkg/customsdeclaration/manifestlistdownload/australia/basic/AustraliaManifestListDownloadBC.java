/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AustraliaManifestListDownloadBC.java
*@FileTitle : AustraliaManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultSeacrSumVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.ErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-AustraliaManifestListDownload Business Logic Command Interface<br>
 * - OPUS-AustraliaManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see AustraliaManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface AustraliaManifestListDownloadBC {

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * Australia Customs Cargo 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception EventException
	 */
	public List<AusResultCuscarVO> searchAusCarlstUbmreq(AusSearchCuscarVO searchCuscarVO) throws EventException;

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - SEACR Summary 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultSeacrSumVO>
	 * @exception EventException
	 */
	public List<AusResultSeacrSumVO> searchAusSeacrSum(AusSearchCuscarVO searchCuscarVO) throws EventException;

	/**
	 * [ESM_BKG_1516]
	 * Australia Sea Cargo Report - B/L 목록 조회<br>
	 *
	 * @param AusSearchCuscarVO searchCuscarVO
	 * @return List<AusResultCuscarVO>
	 * @exception EventException
	 */
	public List<AusResultCuscarVO> searchAusSeacrBl(AusSearchCuscarVO searchCuscarVO) throws EventException;

	/**
	 * [ESM_BKG_1515]
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException;

	/**
	 *  수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
	 *
	 * @param  AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO>
	 * @throws EventException
	 */
	public List<AusDgListDetailVO> searchAusDgManifestList(AusDgListCondVO ausDgListCondVO) throws EventException;

	/**
	 * 위험물 Sent결과를 조회해 온다.<br>
	 *
	 * @param  AusSendHistoryCondVO ausSendHistoryCondVO
	 * @return List<AusSendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<AusSendHistoryDetailVO> searchAusSendHistory(AusSendHistoryCondVO ausSendHistoryCondVO) throws EventException;


}
