/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBCImpl.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.30
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.04.30 임진영
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
* 2010.09.10 최도순 [CLT-100910046] 인도지역 D/O Extension(2)
* 2010.09.29 이지영 [CHM-201006089-01] [MDM]Location 평택(KRPYT->KRPTK) 정제 관련 작업 요청
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.07.28 김봉균 [CHM-201112484-01] Japan Cargo Release 의 DOR I/F  기능 개선 요청
* 2011.09.22 김봉균 [CHM-201113344-01] Cargo Release 용 터미널 EDI 전송 기능 분리
* 2011.10.13 김봉균 [CHM-201113640-01] E-DO Free Time관련 기능 추가(KT-NET)
* 2012.02.20 김보배 [CHM-201216109] [BKG] Japan Cargo Release 의 History 기능 개선 요청
* 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
* 2012.08.06 김보배 [CHM-201219299] [BKG] KOREA E-D/O 조회 기능 보완 요청
* 2012.10.23 조정민 [CHM-201220661] EU full CNTR release 화면상 ATB# 추가 요청
* 2012.11.13 조정민 [CHM-201221007] [EUR Cargo Release] P/up Date 시간변경 (0000->2400)
* 2012.11.22 조정민 [CHM-201221094] POD DE일 경우 EU Full CNTR Release 에서 Email 전송시 전송내역 추가 요청
* 2012.12.03 조정민 [CHM-201221434] [EU Full CNTR RLS화면] 필수값 변경 (P/up date, Rls expiry date)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgAeDoVtyDtHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgCntrEtcVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgPsaEdoAckSchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcFocVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSndIdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPfmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoVtyDtUpdHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdiYardInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseCntrEmlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseYdInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.GenDoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseInfoForCopyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IndiaDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.PsaDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.SearchEdoCntrPtyTrspVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgDoCntrVO;
import com.hanjin.syscommon.common.table.BkgDoDtlVO;
import com.hanjin.syscommon.common.table.BkgDoFomVO;
import com.hanjin.syscommon.common.table.BkgDoHisVO;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;
import com.hanjin.syscommon.common.table.BkgEdoCntrVO;
import com.hanjin.syscommon.common.table.BkgEdoDoVO;
import com.hanjin.syscommon.common.table.BkgEdoIbdTrspVO;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;
import com.hanjin.syscommon.common.table.BkgEdoMstVO;
import com.hanjin.syscommon.common.table.BkgEdoPtyTrspVO;
import com.hanjin.syscommon.common.table.BkgEdoSelfTrspVO;
import com.hanjin.syscommon.common.table.BkgFullCgoRlseOrdVO;
import com.hanjin.syscommon.common.table.BkgFullCntrRemarkVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgIbEdiSndLogVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgOtsDtlVO;
import com.hanjin.syscommon.common.table.BkgOutstandingVO;
import com.hanjin.syscommon.common.table.BkgPsaEdoRcvLogVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
 
/**
 * ALPS-CargoReleaseOrderMgt Business Logic Basic Command implementation<br>
 * - ALPS-CargoReleaseOrderMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_1001EventResponse,FullReleaseOrderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CargoReleaseOrderBCImpl extends BasicCommandSupport implements CargoReleaseOrderBC {

    // Database Access Object
    transient CargoReleaseOrderDBDAO dbDao = null;
    
    // Database Access Object
    transient CargoReleaseOrderEAIDAO eaiDbDao = null;

    transient GeneralBookingReceiptDBDAO gbrDbDao = null;
    /**
     * FullReleaseOrderBCImpl 객체 생성<br>
     * FullReleaseOrderDBDAO를 생성한다.<br>
     */
    public CargoReleaseOrderBCImpl() {
        dbDao    = new CargoReleaseOrderDBDAO();
        eaiDbDao = new CargoReleaseOrderEAIDAO();
        gbrDbDao = new GeneralBookingReceiptDBDAO();
    }

/******************************************************************************************
* Author : Lim JinYoung Start
******************************************************************************************/

    /**
     * 조회 이벤트 처리<br>
     * FullReleaseOrder의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param String usrNm
     * @param String usrRegNo
     * @return response EventResponse
     * @exception EventException
     */
    public List<KorDoAttorneyVO> searchKorDoCustList(String usrNm, String usrRegNo) throws EventException {
        try {
            return dbDao.searchKorDoCustList(usrNm, usrRegNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * Cargo Release Order History의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param String bkgNo
     * @return response EventResponse
     * @exception EventException
     */
    public List<DoHisVO> searchDoHistory(String bkgNo) throws EventException {
        try {
            return dbDao.searchDoHistory(bkgNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 멀티 이벤트 처리<br>
     * Cargo Release Order History의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param KorDoAttorneyVO[] attorneys
     * @param SignOnUserAccount account
     * @return response EventResponse
     * @exception EventException
     */
    public int manageKorDoCust(KorDoAttorneyVO[] attorneys, SignOnUserAccount account) throws EventException {
        int rtnVal = 0;
        try {
            List<KorDoAttorneyVO> insertVoList = new ArrayList<KorDoAttorneyVO>();
            List<KorDoAttorneyVO> updateVoList = new ArrayList<KorDoAttorneyVO>();
            List<KorDoAttorneyVO> deleteVoList = new ArrayList<KorDoAttorneyVO>();

            if(null != attorneys){
                for ( int i=0; i<attorneys .length; i++ ) {
                    if ( attorneys[i].getIbflag().equals("I")){
                        attorneys[i].setRgstUsrId(account.getUsr_id());
                        attorneys[i].setCreUsrId(account.getUsr_id());
                        attorneys[i].setUpdUsrId(account.getUsr_id());
                        attorneys[i].setRgstOfcCd(account.getOfc_cd());
                        attorneys[i].setUpdOfcCd(account.getOfc_cd());
                        insertVoList.add(attorneys[i]);
                    } else if ( attorneys[i].getIbflag().equals("U")){
                        attorneys[i].setUpdUsrId(account.getUsr_id());
                        attorneys[i].setUpdOfcCd(account.getOfc_cd());
                        updateVoList.add(attorneys[i]);
                    } else if ( attorneys[i].getIbflag().equals("D")){
                        deleteVoList.add(attorneys[i]);
                    }
                }
            }
            if ( insertVoList.size() > 0 ) {
                for(int i=0; i < insertVoList.size() ; i ++)
                {
                	if( dbDao.searchKorDoCustList( null,insertVoList.get(i).getAttyBizNo()).size() > 0 )
                	{
                 		 throw new EventException((String)new ErrorHandler("BKG03064",new String[]{insertVoList.get(i).getAttyBizNo()}).getMessage());
                	}
                }

                rtnVal = dbDao.addKorDoCust(insertVoList);
                if(rtnVal ==1){
                    throw new EventException(new ErrorHandler("BKG43045").getMessage());
                }
            }

            if ( updateVoList.size() > 0 ) {
                dbDao.modifyKorDoCust(updateVoList);
            }

            if ( deleteVoList.size() > 0 ) {
                dbDao.removeKorDoCust(deleteVoList);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return rtnVal;
    }

    /**
     * 조회 이벤트 처리<br>
     * Cargo Release 시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
     *
     * @param String custType
     * @param String custNm
     * @param String custBizNo
     * @return KorDoAttorneyDtlVO
     * @exception EventException
     */
    public List<KorDoAttorneyDtlVO> searchKorDoAttorneyList(String custType, String custNm, String custBizNo) throws EventException {
        try {
            return dbDao.searchKorDoAttorneyList(custType, custNm, custBizNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 멀티 이벤트 처리<br>
     * Attorney Register Pop-up 화면에 대한 멀티 이벤트 처리<br>
     *
     * @param KorDoAttorneyDtlVO[] attorneyDtls
     * @param SignOnUserAccount account
     * @return int ; 수정 개수
     * @exception EventException
     */
    public int manageKorDoAttorney(KorDoAttorneyDtlVO[] attorneyDtls, SignOnUserAccount account) throws EventException {
        int rtnVal = 0;
        try {
            List<KorDoAttorneyDtlVO> insertVoList = new ArrayList<KorDoAttorneyDtlVO>();
            List<KorDoAttorneyDtlVO> updateVoList = new ArrayList<KorDoAttorneyDtlVO>();
            List<KorDoAttorneyDtlVO> deleteVoList = new ArrayList<KorDoAttorneyDtlVO>();

            if(null != attorneyDtls){
                for ( int i=0; i<attorneyDtls .length; i++ ) {
                    if ( attorneyDtls[i].getIbflag().equals("I")){
                        attorneyDtls[i].setRgstUsrId(account.getUsr_id());
                        attorneyDtls[i].setCreUsrId(account.getUsr_id());
                        attorneyDtls[i].setUpdUsrId(account.getUsr_id());
                        attorneyDtls[i].setRgstOfcCd(account.getOfc_cd());
                        attorneyDtls[i].setUpdOfcCd(account.getOfc_cd());
                        insertVoList.add(attorneyDtls[i]);
                    } else if ( attorneyDtls[i].getIbflag().equals("U")){
                        attorneyDtls[i].setUpdUsrId(account.getUsr_id());
                        attorneyDtls[i].setUpdOfcCd(account.getOfc_cd());
                        updateVoList.add(attorneyDtls[i]);
                    } else if ( attorneyDtls[i].getIbflag().equals("D")){
                        deleteVoList.add(attorneyDtls[i]);
                    }
                }
            }

            if ( insertVoList.size() > 0 ) {
                rtnVal = dbDao.addKorDoAttorney(insertVoList);
                if(rtnVal ==1){
                    throw new EventException(new ErrorHandler("BKG00764").getMessage());
                }
            }

            if ( updateVoList.size() > 0 ) {
                dbDao.modifyKorDoAttorney(updateVoList);
            }

            if ( deleteVoList.size() > 0 ) {
                dbDao.removeKorDoAttorney(deleteVoList);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return rtnVal;
    }

    /**
     * 조회 이벤트 처리<br>
     * Attorney Create Pop-up 화면 수임자 위임자 사업자 번호에 대한 중복 여부 조회 이벤트 처리<br>
     *
     * @param String fmAttyBizNo
     * @param String toAttyBizNo
     * @return EventResponse EsmBkg0999EventResponse
     * @exception EventException
     */
    public String searchKorDoAttorneyDtl(String fmAttyBizNo, String toAttyBizNo) throws EventException {
        try {
            return dbDao.searchKorDoAttorneyDtl(fmAttyBizNo, toAttyBizNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Korea D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param String bkgNo  : 선적예약 요청 번호
     * @param SignOnUserAccount account
     * @return KorDoMstVO korDoMst
     * @exception EventException
     */
 public KorDoMstVO searchKorDo(String bkgNo, SignOnUserAccount account) throws EventException {

        KorDoMstVO korDoMst = new KorDoMstVO();
        KorDoBlInfoVO korDoBlInfo = new KorDoBlInfoVO();


        try {

            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * Korea D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            //korDoMst.setBlInfo(blInfo);

            if(blInfo != null){
                ObjectCloner.build(blInfo, korDoBlInfo);
            }

            if(blInfo != null){
                // sequence 12 added delivery code를 기준으로 국가코드가 KR이 아닌경우 Exception BKG40091 발생
                if(!blInfo.getDelCd().substring(0,2).equals("KR")) {  // 12
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                    //You can't handle this B/L Because the Port of Discharging is [$s]
                }

                /**
                 * D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                if(doRef != null){
                    ObjectCloner.build(doRef, korDoBlInfo);
                }

                /**
                 * 한국세관 신고를 위한 B/L INFO를 조회한다.
                 */
                KorCstmsVO korCstms = dbDao.searchKorCstmsInfo(bkgNo);
                //korDoMst.setKorCstms(korCstms);
                if(korCstms != null){
                    ObjectCloner.build(korCstms, korDoBlInfo);
                }

                /**
                 * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                 */
                List<DoRlseStsVO> doRlseSts = dbDao.searchDoRlseSts(bkgNo);
                korDoMst.setDoRlseSts(doRlseSts);

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                //korDoMst.setBlIss(blIss);

                if(blIss != null){
                    ObjectCloner.build(blIss, korDoBlInfo);
                }

                /**
                 * KT-NET을 통해 들어온 E-DO 승인 요청 정보에 대한 Ststus를 조회한다.
                 */
                EdoRqstStsVO edoRqstSts = dbDao.searchEdoRqstSts(bkgNo);

                if(edoRqstSts != null){
                    ObjectCloner.build(edoRqstSts, korDoBlInfo);
                }

                String attorneyValChk = "Y";   // 수임자및 위임자 체크
                /*
                if("".equals(edoRqstSts.getPrPtyRgstNo()) || edoRqstSts.getPrPtyRgstNo() == null){
                	attorneyValChk = "N";   // 수임자 정보가 없는 경우
                }*/


                if(edoRqstSts != null ){
                	if(edoRqstSts.getPrPtyRgstNo() != null) {
                        if(!edoRqstSts.getPrPtyRgstNo().equals( edoRqstSts.getMsPtyRgstNo())){
	                 	    attorneyValChk = dbDao.searchKorDoAttorneyValChk(edoRqstSts.getMsPtyRgstNo(), edoRqstSts.getPrPtyRgstNo());
	                    }
                	}
               }

                korDoBlInfo.setAttorneyValChk(attorneyValChk);
                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfo = new OtsRcvInfoVO();

                //try{
                	// by sungho 2010.03.04
            	    //otsRcvInfo = eaiDbDao.searchOtsInfo(blInfo.getBlNo());
                	otsRcvInfo = this.searchErpOtsInfo(blInfo.getBlNo());
                //} catch(Exception exe){
            	   // ERP 연동 오류
            	//   otsRcvInfo = null;
                //}

                if(otsRcvInfo != null){
                    ObjectCloner.build(otsRcvInfo, korDoBlInfo);
                }

                //Mini Super Vo를 Container Vo에 담는다.
                korDoMst.setKorDoBlInfo(korDoBlInfo);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());

                // mrdID를 &^^& 로 Split 한다.(안진응)
                korDoMst.setMrdId(mrdId);
                
                /**
                 * Total Vol. 조회(2018.03.16 추가- 하대성)
                 */
                BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
                bkgBlNoVO.setBkgNo(bkgNo);
                List<BkgQuantityVO> bkgQuantity = gbrDbDao.searchBkgQuantity(bkgBlNoVO);
                korDoMst.setBkgQuantity(bkgQuantity);
            }
            return korDoMst;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Booking Status를 체크한다.
     * @param String bkgNo : 선적예약 요청 번호
     * @exception EventException
     */
    private void validateBkgSts(String bkgNo) throws EventException {
        try {
            String bkgStsCd = dbDao.searchBkgStatus(bkgNo);

            if("X".equals(bkgStsCd)){
                throw new EventException(new ErrorHandler("BKG00879").getMessage());
                //This booking already canceled, You can not update booking data
                //This booking already canceled or Advanced
         //   }else if("W".equals(bkgStsCd)){
         //       throw new EventException(new ErrorHandler("BKG04004").getMessage());
                //Booking in waiting status
            }else if("".equals(bkgStsCd)){
                throw new EventException(new ErrorHandler("BKG40033", new String[]{bkgNo}).getMessage());

                //Booking No.(Value) doesn't exist
            }else {
                bkgStsCd = dbDao.searchBkgCgoTp(bkgNo);

                if (bkgStsCd.equals("P")) {
                    throw new EventException(new ErrorHandler("BKG40030").getMessage());
                }
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     *
     * @param KorDoSaveVO korDoSave
     * @exception EventException
     */
    public void manageKorDo(KorDoSaveVO korDoSave) throws EventException {
        try {
            int resultCnt =0;

            BkgDoHisVO doHis = new BkgDoHisVO();

            /**
             * do_cng_evnt_cd
             * RB : Received O. B/L
             * RO : Received Other Doc
             * RI : Received In bond Doc
             * CR : Cancelled O/BL Received

             * do_cng_evnt_cd 가 RB 일 경우
             * pre_ctnt  : old_obl_rdem_knt
             * crnt_ctnt : new_obl_rdem_knt

             * do_cng_evnt_cd 가 RO 일 경우
             * pre_ctnt  : 'N'
             * crnt_ctnt : 'Y'

             * do_cng_evnt_cd 가 RI 일 경우
             * pre_ctnt  : 'N'
             * crnt_ctnt : 'Y'

             * do_cng_evnt_cd 가 CR 일 경우
             * pre_ctnt  : 'N'
             * crnt_ctnt : 'Y'
             */

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(korDoSave.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }

            if("Y".equals(korDoSave.getOblCngFlg())){

                doHis.setBkgNo(korDoSave.getBkgNo());
                doHis.setCreUsrId(korDoSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(korDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd(korDoSave.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(korDoSave.getAcount().getUsr_id());
                doHis.setEvntOfcCd(korDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO refInfos = new BkgDoRefVO();

            refInfos.setBkgNo(korDoSave.getBkgNo());
            refInfos.setCstmsRefNm(korDoSave.getCstmsRefNm());
            refInfos.setCstmsRefCtnt(korDoSave.getCstmsRefCtnt());
            refInfos.setCstmsAsgnNm(korDoSave.getCstmsAsgnNm());
            refInfos.setCstmsAsgnCtnt(korDoSave.getCstmsAsgnCtnt());
            refInfos.setInterRmk(korDoSave.getInterRmk());
            refInfos.setDoHldFlg(korDoSave.getDoHldFlg());
            refInfos.setCreUsrId(korDoSave.getAcount().getUsr_id());
            refInfos.setUpdUsrId(korDoSave.getAcount().getUsr_id());
            refInfos.setInfoCgoFlg(korDoSave.getInfoCgoFlg());
            refInfos.setDoSplitFlg(korDoSave.getDoSplitFlg());
            refInfos.setCyOpCd(korDoSave.getCyOpCd());

            resultCnt = dbDao.modifyDoRef(refInfos);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                dbDao.addDoRef(refInfos);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O No를 Assign 한다.<br>
     * @param DoAsignVO doAsign
     * @return String doNo
     * @exception EventException
     */
    public String assignDo(DoAsignVO doAsign) throws EventException {
        try {
            //DO Assign이 가능한지 확인한다
            validateDoAssign(doAsign.getBkgNo());

            //DO No를 채번 한다.
            String doNo = this.makeDoNo(doAsign.getAcount().getOfc_cd(), doAsign.getAcount().getUsr_id());
            String doSplitNo = "00";

            //Value Object 선언
            BkgDoVO bkgDo       = new BkgDoVO();
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            BkgDoDtlVO doDtl    = new BkgDoDtlVO();
            BkgDoHisVO doHis    = new BkgDoHisVO();

            bkgDo.setBkgNo(doAsign.getBkgNo());
            bkgDo.setDoNo(doNo);
            bkgDo.setRlseSeq("1");
            bkgDo.setDoNoSplit(doSplitNo);
            bkgDo.setCreUsrId(doAsign.getAcount().getUsr_id());
            bkgDo.setUpdUsrId(doAsign.getAcount().getUsr_id());

//            bkgDoRef.setBkgNo(doAsign.getBkgNo());


//            log.debug("InterRmk : " + doAsign.getInterRmk());

//            if(null != doAsign.getRefInfo()){
//
//            	log.debug("doAsign.getRefInfo() Null이 아님");
//
//                bkgDoRef.setCyOpCd(doAsign.getRefInfo().getCyOpCd());
//                bkgDoRef.setCstmsRefNm(doAsign.getRefInfo().getCstmsRefNm());
//                bkgDoRef.setCstmsRefCtnt(doAsign.getRefInfo().getCstmsRefCtnt());
//                bkgDoRef.setCstmsAsgnNm(doAsign.getRefInfo().getCstmsAsgnNm());
//                bkgDoRef.setCstmsAsgnCtnt(doAsign.getRefInfo().getCstmsAsgnCtnt());
//                bkgDoRef.setInterRmk(doAsign.getRefInfo().getInterRmk());
//                bkgDoRef.setDoHldFlg(JSPUtil.getNull(doAsign.getRefInfo().getDoHldFlg(),"N"));
//                bkgDoRef.setInfoCgoFlg(doAsign.getRefInfo().getInfoCgoFlg());
//                bkgDoRef.setDoSplitFlg(JSPUtil.getNull(doAsign.getRefInfo().getDoSplitFlg(),"N"));
//            }else{
//            	log.debug("doAsign.getRefInfo() Null임");
//
//            	bkgDoRef.setDoHldFlg("N");
//                bkgDoRef.setDoSplitFlg("N");
//            }
//            bkgDoRef.setCreUsrId(doAsign.getAcount().getUsr_id());
//            bkgDoRef.setUpdUsrId(doAsign.getAcount().getUsr_id());

            /*****************************************
                DO RELEASE STATUS CODE
            ******************************************
            AS  Assigned
            CR  Cancelled O/BL Received
            DC  DOR Cancel
            DF  DOR I/F
            DT  DOR Transmit
            HC  Cancelled Cargo Hold
            PD  Printed D/O
            RB  Received O. B/L
            RE  Released
            RI  Received In bond Doc
            RO  Received Other Doc
            RR  Remark for Release
            SF  Sent Fax/E-Mail
            XX  Canceled

            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            doDtl.setBkgNo(doAsign.getBkgNo());
            doDtl.setRlseSeq("1");
            doDtl.setRlseStsCd("A"); //ASSIGN
            doDtl.setEvntUsrId(doAsign.getAcount().getUsr_id());
            doDtl.setEvntOfcCd(doAsign.getAcount().getOfc_cd());
            doDtl.setCreUsrId(doAsign.getAcount().getUsr_id());
            doDtl.setUpdUsrId(doAsign.getAcount().getUsr_id());

            doHis.setBkgNo(doAsign.getBkgNo());
            doHis.setCreUsrId(doAsign.getAcount().getUsr_id());
            doHis.setUpdUsrId(doAsign.getAcount().getUsr_id());
            doHis.setDoCngEvntCd("AS"); //AI  ASSIGN & ISSUE

            doHis.setPreCtnt("");
            doHis.setCrntCtnt(doNo + doSplitNo);

            doHis.setEvntUsrId(doAsign.getAcount().getUsr_id());
            doHis.setEvntOfcCd(doAsign.getAcount().getOfc_cd());

            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

            dbDao.modifyKorDoRcvrBizNo(doAsign.getBkgNo()); //사업자 등록 번호 갱신

            return doNo;
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DO Assign이 가능한지 확인한다.<br>
     * @param bkgNo : 선적예약 요청 번호
     * @exception EventException
     */
    private void validateDoAssign(String bkgNo)throws EventException {
        try {
            //HOLD 여부 체크
            if(dbDao.checkHold(bkgNo)){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG00649").getMessage());
            }


            //중복 D/O no 체크 해당 D/O가 이미 Assign/Issue가 수행 됐는지 체크한다.
              if(dbDao.checkDupDoAssign(bkgNo)){
                  //Assign/Issue 수행 된 경우, 작업 중단
                  throw new EventException(new ErrorHandler("BKG00434").getMessage());
              }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O를 Cancel 한다.<br>
     *
     * @param KorDoCancelVO korDoCancel
     * @exception EventException
     * @author Lim JinYoung
     */
    public void cancelKorDo(KorDoCancelVO korDoCancel) throws EventException {
    	try {
            DoCancelVO doCancel = new DoCancelVO();
            //Value Object Copy 대상, 타겟
            ObjectCloner.build(korDoCancel, doCancel);

            doCancel.setResetFlg("N");
            doCancel.setRlseStsCd("'A','R','C'");

            this.cancelDo(doCancel);

            KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();
            //Value Object Copy 대상, 타겟
            ObjectCloner.build(korDoCancel, korDoEdiTrans);

            korDoEdiTrans.setDoType("KDC");
            korDoEdiTrans.setSelfTrnsFlg("N");

            // 자가운송 취소
         //   dbDao.modifyKorDoSelfTransFlg(korDoEdiTrans.getBkgNo(),"N",korDoEdiTrans.getAcount().getUpd_usr_id());

            this.transmitEdiByKorDo(korDoEdiTrans);

        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O를 Cancel 한다.<br>
     *
     * @param DoCancelVO doCancel
     * @exception EventException
     * @author Lim JinYoung
     */
    public void cancelDo(DoCancelVO doCancel) throws EventException {
        try {
            BkgDoVO doInfo = dbDao.searchDoInfo(doCancel.getDoNo());

            doCancel.setBkgNo(doInfo.getBkgNo());
            doCancel.setRlseSeq(doInfo.getRlseSeq());

            validateDoCancel(doCancel);

            /************************************************************************************
            //현 시점의  Current D/O Status 정보  조회
            log.debug("=============================================");
            log.debug("현 시점의  Current D/O Status 정보  조회한다.");
            log.debug("=============================================");

            DoRlseStsVO doStsVO = dbDao.searchDoSts(doCancel.getBkgNo(), doCancel.getRlseSeq());

            log.debug("===================================================");
            log.debug("화면에서 전달 된 파라메터 : "+doCancel.getRlseStsCd());
            log.debug("Current D/O Status    : "+doStsVO.getRlseStsCd());
            log.debug("===================================================");

            //화면에서 넘어온 파라메터와 현재 DB 상태값이 다르면 변경 메세지 전달 : 이미 다른 사람에 의해 취소 완료
            if(! doStsVO.getRlseStsCd().equals(doCancel.getRlseStsCd())){
                throw new EventException(new ErrorHandler("BKG00384").getMessage());
            }
            *************************************************************************************/

            //String rlseStsCd = doCancel.getRlseStsCd();

            //D/O의 최종 상태에 따른 로직 구현 A : KOR DO의 ASSIGN I: Japan D/O의 ASSIGN & ISSUE
            //if ("A".equals(rlseStsCd)|| "I".equals(rlseStsCd) || "Y".equals(doCancel.getResetFlg())) {
            if ("Y".equals(doCancel.getResetFlg())) {
                log.debug("==============");
                log.debug("D/O번호 초기화");
                log.debug("==============");
                dbDao.resetDoNo(doCancel.getBkgNo(), doCancel.getRlseSeq());
            }

            // 해당 BKG_NO, RLSE_SEQ를  기준으로 가장  최근  Status 정보를 삭제 (취소 직전 상태값을 삭제)
            //dbDao.removeDoStsByCancel(doCancel);
            dbDao.removeDoDtlByCancel(doCancel.getBkgNo(), doCancel.getRlseSeq(), doCancel.getRlseStsCd());

            if (!"Y".equals(doCancel.getSplitFlg())) {
                BkgDoDtlVO bkgDoDtl = new BkgDoDtlVO();

                bkgDoDtl.setBkgNo(doCancel.getBkgNo());
                bkgDoDtl.setRlseSeq(doCancel.getRlseSeq());
                bkgDoDtl.setRlseStsCd("C");
                bkgDoDtl.setEvntUsrId(doCancel.getCreUsrId());
                bkgDoDtl.setEvntOfcCd(doCancel.getEvntOfcCd());
                bkgDoDtl.setUpdUsrId(doCancel.getUpdUsrId());
                bkgDoDtl.setCreUsrId(doCancel.getCreUsrId());

                dbDao.addDoDtlSts(bkgDoDtl);
            }

            /*****************************************
                DO RELEASE STATUS CODE
            ******************************************
            AS  Assigned
            CR  Cancelled O/BL Received
            DC  DOR Cancel
            DF  DOR I/F
            DT  DOR Transmit
            HC  Cancelled Cargo Hold
            PD  Printed D/O
            RB  Received O. B/L
            RE  Released
            RI  Received In bond Doc
            RO  Received Other Doc
            RR  Remark for Release
            SF  Sent Fax/E-Mail
            XX  Canceled
            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            //D/O HISTORY 생성 XX
            log.debug("================");
            log.debug("D/O HISTORY 생성");
            log.debug("================");

            doCancel.setDoCngEvntCd("XX");
            doCancel.setCrntCtnt("X");
            doCancel.setPreCtnt(doCancel.getDoNo());

            BkgDoHisVO bkgDoHis = new BkgDoHisVO();

            bkgDoHis.setBkgNo(doCancel.getBkgNo());
            bkgDoHis.setDoCngEvntCd(doCancel.getDoCngEvntCd());
            bkgDoHis.setPreCtnt(doCancel.getPreCtnt());
            bkgDoHis.setCrntCtnt(doCancel.getCrntCtnt());
            bkgDoHis.setEvntUsrId(doCancel.getCreUsrId());
            bkgDoHis.setEvntOfcCd(doCancel.getEvntOfcCd());
            bkgDoHis.setCreUsrId(doCancel.getCreUsrId());
            bkgDoHis.setUpdUsrId(doCancel.getUpdUsrId());

            dbDao.addDoHistory(bkgDoHis);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DO Cancel이 가능한지 확인한다.<br>
     *
     * @param DoCancelVO doCancel
     * @exception EventException
     */
    private void validateDoCancel(DoCancelVO doCancel)throws EventException {

        try {
            //HOLD 여부 체크
            log.debug("================================");
            log.debug("해당 D/O의 Hold 여부를 조회한다.");
            log.debug("================================");

            //HOLD 여부 체크
            if(dbDao.checkHold(doCancel.getBkgNo())){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG00649").getMessage());
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.<br>
     *
     * @param BkgDoHisVO bkgDoHis
     * @exception EventException
     */
    public void createDoHistory(BkgDoHisVO bkgDoHis) throws EventException {
        try {
            dbDao.addDoHistory(bkgDoHis);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param DoRlseVO doRlse
     * @exception EventException
     * @author Lim JinYoung
     */
    private void releaseDo(DoRlseVO doRlse) throws EventException {

        log.debug("===================================================");
        log.debug("화면에서 전달 된 파라메터 : "+doRlse.getRlseStsCd());
        log.debug("===================================================");

        if(!"A".equals(doRlse.getRlseStsCd())){
            DoAsignVO doAsign = new DoAsignVO();
            //대상 / 타겟
            ObjectCloner.build(doRlse, doAsign);

            String doNo = this.assignDo(doAsign);
            doRlse.setDoNo(doNo);
        }

        validateDoRelease(doRlse.getBkgNo());

        //Value Object 선언
        BkgDoVO bkgDo       = new BkgDoVO();
        BkgDoRefVO bkgDoRef = new BkgDoRefVO();
        BkgDoDtlVO doDtl    = new BkgDoDtlVO();
        BkgDoHisVO doHis    = new BkgDoHisVO();

        bkgDo.setBkgNo(doRlse.getBkgNo());
        bkgDo.setDoNo(doRlse.getDoNo());
        bkgDo.setRlseSeq("1");
        bkgDo.setDoNoSplit("00");
        bkgDo.setCgorRmk(doRlse.getCgorRmk());
        bkgDo.setCreUsrId(doRlse.getAcount().getUsr_id());
        bkgDo.setUpdUsrId(doRlse.getAcount().getUsr_id());

        bkgDoRef.setBkgNo(doRlse.getBkgNo());

        bkgDoRef.setCyOpCd(doRlse.getDoRef().getCyOpCd());
        bkgDoRef.setCstmsRefNm(doRlse.getDoRef().getCstmsRefNm());
        bkgDoRef.setCstmsRefCtnt(doRlse.getDoRef().getCstmsRefCtnt());
        bkgDoRef.setCstmsAsgnNm(doRlse.getDoRef().getCstmsAsgnNm());
        bkgDoRef.setCstmsAsgnCtnt(doRlse.getDoRef().getCstmsAsgnCtnt());
        bkgDoRef.setInterRmk(doRlse.getDoRef().getInterRmk());
        bkgDoRef.setDoHldFlg(JSPUtil.getNull(doRlse.getDoRef().getDoHldFlg(),"N"));
        bkgDoRef.setInfoCgoFlg(doRlse.getDoRef().getInfoCgoFlg());
        bkgDoRef.setDoSplitFlg(JSPUtil.getNull(doRlse.getDoRef().getDoSplitFlg(),"N"));

        bkgDoRef.setCreUsrId(doRlse.getAcount().getUsr_id());
        bkgDoRef.setUpdUsrId(doRlse.getAcount().getUsr_id());

        /*****************************************
            DO RELEASE STATUS CODE
        ******************************************
        AS  Assigned
        CR  Cancelled O/BL Received
        DC  DOR Cancel
        DF  DOR I/F
        DT  DOR Transmit
        HC  Cancelled Cargo Hold
        PD  Printed D/O
        RB  Received O. B/L
        RE  Released
        RI  Received In bond Doc
        RO  Received Other Doc
        RR  Remark for Release
        SF  Sent Fax/E-Mail
        XX  Canceled

        /*****************************************
            RELEASE STATUS CODE
        ******************************************
        A ASSIGN
        R RELEASE
        D DOR I/F
        I ASSIGN & ISSUE
        C CANCEL
        ******************************************/

        doDtl.setBkgNo(doRlse.getBkgNo());
        doDtl.setRlseSeq("1");
        doDtl.setRlseStsCd("R"); //RELEASE
        doDtl.setEvntUsrId(doRlse.getAcount().getUsr_id());
        doDtl.setEvntOfcCd(doRlse.getAcount().getOfc_cd());
        doDtl.setCreUsrId(doRlse.getAcount().getUsr_id());
        doDtl.setUpdUsrId(doRlse.getAcount().getUsr_id());

        doHis.setBkgNo(doRlse.getBkgNo());
        doHis.setCreUsrId(doRlse.getAcount().getUsr_id());
        doHis.setUpdUsrId(doRlse.getAcount().getUsr_id());
        doHis.setDoCngEvntCd("RE"); // Released
        //doHis.setPreCtnt("X");
        //doHis.setCrntCtnt("RE");
        doHis.setPreCtnt("");

       // if( doRlse.getDoNo().length() == 10?doRlse.getDoNo()+ "00":doRlse.getDoNo() ){
      //  	doRlse.setDoNo(doRlse.getDoNo() + "00");
      //  }
        doHis.setCrntCtnt(doRlse.getDoNo().length() == 10?doRlse.getDoNo()+ "00":doRlse.getDoNo());
        doHis.setEvntUsrId(doRlse.getAcount().getUsr_id());
        doHis.setEvntOfcCd(doRlse.getAcount().getOfc_cd());


        //DO No 뒤에 붙어있는 두자리 DoNoSplit을 잘라낸다.
        bkgDo.setDoNo(bkgDo.getDoNo().substring(0,10));
        this.manageDo(bkgDo, bkgDoRef, doDtl, doHis);
    }

    /**
     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param KorDoRlseVO korDoRlse
     * @exception EventException
     * @author Lim JinYoung
     */
    public void releaseKorDo(KorDoRlseVO korDoRlse) throws EventException {

        DoRlseVO doRlse = new DoRlseVO();
         //대상 / 타겟
        ObjectCloner.build(korDoRlse, doRlse);

        this.releaseDo(doRlse);

        //POD CD가 KRPUS,KRKAN,KRPTK,KRPYT,KRINC,KRUSN 이면 수행
        // 평택(KRPYT->KRPTK)로 정제
        if( JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPUS") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRKAN") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPTK") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPYT") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRUSN") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRINC") ||
            JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRGIN") ){

            KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();

            korDoEdiTrans.setDoType("KDS");
            korDoEdiTrans.setBkgNo(korDoRlse.getBkgNo());
            korDoEdiTrans.setRlseSeq(korDoRlse.getRlseSeq());
            korDoEdiTrans.setSelfTrnsFlg(korDoRlse.getSelfTrnsFlg());
            korDoEdiTrans.setDiscLocCd(korDoRlse.getDiscLocCd());
            korDoEdiTrans.setAcount(korDoRlse.getAcount());

            this.transmitEdiByKorDo(korDoEdiTrans);
        }
    }

    /**
     * DO Cancel이 가능한지 확인한다.<br>
     *
     * @param String bkgNo
     * @exception EventException
     */
    private void validateDoRelease(String bkgNo)throws EventException {

        try {
            //HOLD 여부 체크
            log.debug("================================");
            log.debug("해당 D/O의 Hold 여부를 조회한다.");
            log.debug("================================");

            //HOLD 여부 체크
            if(dbDao.checkHold(bkgNo)){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG00649").getMessage());
            }


          //중복 D/O no 체크
            log.debug("================================");
            log.debug("해당 D/O가 이미 Assign/Issue가 수행 됐는지 체크한다.");
            log.debug("================================");
            if(dbDao.checkDupDoIssue(bkgNo)){
                //Assign/Issue 수행 된 경우, 작업 중단
                throw new EventException(new ErrorHandler("BKG00434").getMessage());
            }


            log.debug("========================================================");
            log.debug("LCL일 경우 관련 B/L들에 대한 O/BL 회수 여부를 CHECK한다.");
            log.debug("========================================================");

            //OBL 미 회수 메세지 전달 (2010.03.09 안진응 주석 처리)
//            if(dbDao.checkOBLRlseByLcl(bkgNo)){  // getUserMessage
//                throw new EventException(new ErrorHandler("BKG00667").getMessage());
//            }

        }  catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        }catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DO 대상 B/L 단위로  HOLD 한다.<br>
     * @param DoHoldVO doHold
     * @exception EventException
     */
    public void holdDo(DoHoldVO doHold) throws EventException {
        try {
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            String doCngEvntCd = "";
            //Hold
            if ("H".equals(doHold.getEvntFlag())) {
                doCngEvntCd = "HC";
                log.debug("HOLD : FLG : N ==> Y");
                int modifyCnt = dbDao.modifyDoRefByHold(doHold);

                //수정 건수가 없다면 신규생성 한다.
                if(modifyCnt == 0){
                    bkgDoRef.setBkgNo(doHold.getBkgNo());
                    bkgDoRef.setDoHldFlg("Y");
                    bkgDoRef.setDoSplitFlg("N");
                    bkgDoRef.setCreUsrId(doHold.getCreUsrId());
                    bkgDoRef.setUpdUsrId(doHold.getUpdUsrId());
                    dbDao.addDoRef(bkgDoRef);
                }
            //Put
            }else if ("R".equals(doHold.getEvntFlag())){
                doCngEvntCd = "CH";
                log.debug("UN-HOLD FLG : Y ==> N");
                dbDao.holdRlseDo(doHold);
            }
            //D/O HISTORY 생성
            BkgDoHisVO doHis = new BkgDoHisVO();

            log.debug("D/O HISTORY 생성");
            doHis.setBkgNo(doHold.getBkgNo());
            doHis.setCreUsrId(doHold.getAcount().getUsr_id());
            doHis.setUpdUsrId(doHold.getAcount().getUsr_id());
            doHis.setDoCngEvntCd(doCngEvntCd);
            doHis.setPreCtnt("NO");
            doHis.setCrntCtnt("YES");
            doHis.setEvntUsrId(doHold.getAcount().getUsr_id());
            doHis.setEvntOfcCd(doHold.getAcount().getOfc_cd());

            dbDao.addDoHistory(doHis);

            //Hold에 대한 값은 BKG_DO에 입력하면 끝? BKG_DO_DTL에 Hold Code가 없음 윤윤환 수석과 협의 일단 주석처리
            //dbDao.addDoHistory(doEvnt, account);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoEdiTransVO[] edoEdiTrans
     * @param String callModule
     * @exception EventException
     */
    public void transmitEdiByEdo(EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException {
    	try {
            for(int idx=0; idx<edoEdiTrans.length; idx++){

                log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoTpCd());
                log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoAckCd());

                //D/O 발급 신청서
                if("5JN".equals(edoEdiTrans[idx].getEdoTpCd())){
                    log.debug("D/O 발급 신청서");
                    if(!"DEMDET".equals(callModule)) {  // DEM/DET 배치 호출이 아닌 BKG D/O UI에서 호출 될 경우만 호출
                    	this.transmitEdoBy5JN(edoEdiTrans[idx]);
                    }

                    if("A".equals(edoEdiTrans[idx].getEdoAckCd())){

                    	List<BkgCntrEtcVO> list = dbDao.searchDemDetFreetimeEndDt(edoEdiTrans[idx].getBkgNo());
                    	for(int i=0; i<list.size(); i++){

                    		BkgCntrEtcVO vo = (BkgCntrEtcVO)list.get(i);
                            vo.setCreUsrId( "DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans[idx].getAcount().getUsr_id());
                            vo.setUpdUsrId( "DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans[idx].getAcount().getUsr_id());

	                    	//KT-NET EDI 전송 시 DMIF_END_DT History 정보를 관리
	                    	dbDao.addEdiEdoDmtFtimeHis(vo);
                    	}

	                    	String ediEdoCusagdDoMst  = dbDao.searchEdiEdoCusagdDoMst(edoEdiTrans[idx].getBkgNo(), callModule);
	                        String[] ediEdoCusagdDoCntr = dbDao.searchEdiEdoCusagdDoCntr(edoEdiTrans[idx].getBkgNo());


	                        StringBuffer sb = new StringBuffer();

	                        sb.append( ediEdoCusagdDoMst );

	                        for(int i=0; i< ediEdoCusagdDoCntr.length; i++){
	                            sb.append(ediEdoCusagdDoCntr[i]);
	                        }

	                        /*
	                         * EDI 연동.
	                         */
	                        SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
	                        sendFlatFileVO.setFlatFile(sb.toString());

	                        //QueueNm 세팅
	                        sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EDO.IBMMQ.QUEUE"));
	                        BookingUtil command = new BookingUtil();

	                        FlatFileAckVO flatFileAckVO = new FlatFileAckVO();

	                        log.debug("========================================");
	                        log.debug("transmitEdiByEdo 로그 호출");
	                        log.debug(sendFlatFileVO.toString());
	                        log.debug("========================================");

	                        flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

	                        //EDI ERROR 발생 시
	                        if ( flatFileAckVO.getAckStsCd().equals("E")){
	                            throw new EventException(new ErrorHandler("BKG00205").getMessage());
	                        }
	                        dbDao.modifyEdoDoByCusagdDoEdiTrans(edoEdiTrans[idx], callModule);

	                        // EDI 전송 로그 기록
	                        BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

	                        ibEdiSndLog.setBkgNo(edoEdiTrans[idx].getBkgNo());
	                        ibEdiSndLog.setFltFileRefNo(ediEdoCusagdDoMst.substring(62,76));
	                        ibEdiSndLog.setDoEdiTpCd(edoEdiTrans[idx].getEdoTpCd());
	                        ibEdiSndLog.setMsgTpNm("CUSAGD");
	                        ibEdiSndLog.setMsgTpId("KTNMFCSDO");
	                        ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
	                        ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans[idx].getAcount().getOfc_cd());
	                        /*
	                        ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans[idx].getAcount().getUsr_id());
	                        ibEdiSndLog.setCreUsrId(edoEdiTrans[idx].getAcount().getUsr_id());
	                        ibEdiSndLog.setUpdUsrId(edoEdiTrans[idx].getAcount().getUsr_id());
	                         */

	                        ibEdiSndLog.setEdiEvntUsrId("DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans[idx].getAcount().getUsr_id());
	                        ibEdiSndLog.setCreUsrId( "DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans[idx].getAcount().getUsr_id());
	                        ibEdiSndLog.setUpdUsrId( "DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans[idx].getAcount().getUsr_id());


	                        dbDao.addIbEdiSndLog(ibEdiSndLog);
                    }
                //자가운송 요청 동의서
                }else if("5JM".equals(edoEdiTrans[idx].getEdoTpCd())){
                    log.debug("\n자가운송 요청 동의서");
                    log.debug("\n==========>>>>>>>>>>>>>>>>"+edoEdiTrans[idx].getEdoAckCd());
                    this.transmitEdoBy5JM(edoEdiTrans[idx]);
                //보세운송 요청 동의서
                }else if("5JK".equals(edoEdiTrans[idx].getEdoTpCd())){
                    log.debug("보세운송 요청 동의서");
                    this.transmitEdoBy5JK(edoEdiTrans[idx]);
                }
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DEM/DET에서의 E-DO관련 요청에 대하여 전송여부를 체크하고 전송메소드를 호출한다.<br>
     *
     * @param EdoEdiTransVO[] edoEdiTrans
     * @exception EventException
     */
    public void transmitEdiByEdoDmt(EdoEdiTransVO[] edoEdiTrans) throws EventException {
    	List<EdoEdiTransVO> edoArray = new ArrayList<EdoEdiTransVO>();

    	try {
   	        for(int idx=0; idx<edoEdiTrans.length; idx++){
            	// KT-NET을 통해 들어온 E-DO 승인 요청 정보에 대한 Ststus를 조회한다.
            	EdoRqstStsVO edoRqstSts = dbDao.searchEdoRqstSts(edoEdiTrans[idx].getBkgNo());

            	if( edoRqstSts != null){       // 기존 E-DO 처리 결과 존재시만
 	            	if("A".equals(edoRqstSts.getDoEdoAckCd())){  // 승인 처리시만
	            		edoArray.add(edoEdiTrans[idx]);
	            	}
            	}
            }

            //EDO 승인 EDI (5JN)가 전송된 건에 한해서 transmitEdiByEdo 호출
            int arrLength = edoArray.size();

            if(arrLength>0){
            	EdoEdiTransVO[] edoDmtTrans = new EdoEdiTransVO[arrLength];
                for(int i=0; i<arrLength; i++){
                	edoDmtTrans[i] = edoArray.get(i);
                }
                this.transmitEdiByEdo(edoDmtTrans,"DEMDET");
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * KT-NET을 통해 들어온 E-DO 요청(D/O 발급 신청서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoTransVO edoTrans
     * @exception EventException
     */
    private void transmitEdiByEdoGenres(EdoEdiTransVO edoEdiTrans) throws EventException {
        try {
            String ediGenresHeader  = dbDao.searchEdiEdoGenresHeader();
            String ediGenresMst     = dbDao.searchEdiEdoGenresMst(edoEdiTrans);
            String ediGenresPtyTrsp = dbDao.searchEdiEdoGenresPtyTrsp(edoEdiTrans);

            /*
             * EDI 연동.
             */
            SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
            sendFlatFileVO.setFlatFile(ediGenresHeader+ediGenresMst+ediGenresPtyTrsp);

            log.debug("\n========================================");
            log.debug("\n"+"transmitEdiByEdoGenres 로그 호출");
            log.debug(sendFlatFileVO.toString());
            log.debug("\n========================================");

            //QueueNm 세팅
            sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EDO.IBMMQ.QUEUE"));
            BookingUtil command = new BookingUtil();

            FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
            flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

            //EDI ERROR 발생 시
            if ( flatFileAckVO.getAckStsCd().equals("E")){
                edoEdiTrans.setEdoAckCd(flatFileAckVO.getAckStsCd());
                throw new EventException(new ErrorHandler("BKG00205").getMessage());
            }

            // EDI 전송 로그 기록
            BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

            ibEdiSndLog.setBkgNo(edoEdiTrans.getBkgNo());
            ibEdiSndLog.setFltFileRefNo(ediGenresHeader.substring(62,76));
            ibEdiSndLog.setDoEdiTpCd(edoEdiTrans.getEdoTpCd());
            ibEdiSndLog.setMsgTpNm("GENRES");
            ibEdiSndLog.setMsgTpId("KTNMFCSDO");
            ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
            ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans.getAcount().getOfc_cd());
            ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans.getAcount().getUsr_id());
            ibEdiSndLog.setCreUsrId(edoEdiTrans.getAcount().getUsr_id());
            ibEdiSndLog.setUpdUsrId(edoEdiTrans.getAcount().getUsr_id());

            dbDao.addIbEdiSndLog(ibEdiSndLog);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * KT-NET을 통해 들어온 E-DO 요청(D/O 발급 신청서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoTransVO edoTrans
     * @exception EventException
     */
    private void transmitEdoBy5JN(EdoEdiTransVO edoEdiTrans) throws EventException {

        try {
        	 if(! "N".equals(edoEdiTrans.getEdoAckCd())){
                 dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
             }
            //승인, 기각 시
            if("A".equals(edoEdiTrans.getEdoAckCd()) || "R".equals(edoEdiTrans.getEdoAckCd())){
                this.transmitEdiByEdoGenres(edoEdiTrans);

                //EDI로  DO 발급신청 승인정보를 전송 한 후  관련 정보를 Update 한다.
                dbDao.modifyEdoDoByGenresEdiTrans(edoEdiTrans);       //Issue Office 정보
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * KT-NET을 통해 들어온 E-DO 요청(자가운송 요청 동의서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoTransVO edoTrans
     * @exception EventException
     */
    private void transmitEdoBy5JM(EdoEdiTransVO edoEdiTrans) throws EventException {
    	String selfTransFlg = "N";
        try {
        	if(! "N".equals(edoEdiTrans.getEdoAckCd())){
                  dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
            }
            //승인, 기각 시
            if("A".equals(edoEdiTrans.getEdoAckCd()) || "R".equals(edoEdiTrans.getEdoAckCd())){
                this.transmitEdiByEdoGenres(edoEdiTrans);
                if("A".equals(edoEdiTrans.getEdoAckCd())){
                	selfTransFlg = "Y";

                     /*##################################################*/
                    KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();

                    korDoEdiTrans.setDoType("KDS");
                    korDoEdiTrans.setBkgNo(edoEdiTrans.getBkgNo());
                    korDoEdiTrans.setRlseSeq("1");
                    korDoEdiTrans.setSelfTrnsFlg(selfTransFlg);
                    korDoEdiTrans.setAcount(edoEdiTrans.getAcount());

                    this.transmitEdiByKorDo(korDoEdiTrans);
                }

            }


        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * KT-NET을 통해 들어온 E-DO 요청(보세운송 요청 동의서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoTransVO edoTrans
     * @exception EventException
     */
    private void transmitEdoBy5JK(EdoEdiTransVO edoEdiTrans) throws EventException {
        try {
        	if(! "N".equals(edoEdiTrans.getEdoAckCd())){
                  dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
            }
            //기각 시
            if("R".equals(edoEdiTrans.getEdoAckCd())){
                this.transmitEdiByEdoGenres(edoEdiTrans);
            }//승인 시
            else if("A".equals(edoEdiTrans.getEdoAckCd())){

                String ediCusagdMst       = dbDao.searchEdiEdoCusagdEdoMst(edoEdiTrans);
                String[] ediCusagdPtyTrsp = dbDao.searchEdiEdoCusagdEdoPtyTrsp(edoEdiTrans);
                String[] ediCusagdCntr    = dbDao.searchEdiEdoCusagdEdoCntr(edoEdiTrans);

                StringBuffer sb = new StringBuffer();

                sb.append( ediCusagdMst );

                for(int idx=0; idx< ediCusagdPtyTrsp.length; idx++){
                    sb.append(ediCusagdPtyTrsp[idx]);
                }

                for(int idx=0; idx< ediCusagdCntr.length; idx++){
                    sb.append(ediCusagdCntr[idx]);
                }

                /*
                 * EDI 연동.
                 */
                SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
               // sendFlatFileVO.setFlatFile(ediCusagdMst+ediCusagdPtyTrsp+sb.toString());
                sendFlatFileVO.setFlatFile( sb.toString() );

                log.debug("\n========================================");
                log.debug("\n"+"transmitEdoBy5JK 로그 호출");
                log.debug(sendFlatFileVO.toString());
                log.debug("\n========================================");

                //QueueNm 세팅
                sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EDO.IBMMQ.QUEUE"));
                BookingUtil command = new BookingUtil();

                FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
                flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

                //EDI ERROR 발생 시
                if ( flatFileAckVO.getAckStsCd().equals("E")){
                    edoEdiTrans.setEdoTpCd(flatFileAckVO.getAckStsCd());
                    throw new EventException(new ErrorHandler("BKG00205").getMessage());
                }


               // EDI 전송 로그 기록
                BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

                ibEdiSndLog.setBkgNo(edoEdiTrans.getBkgNo());
                ibEdiSndLog.setFltFileRefNo(ediCusagdMst.substring(62,76));
                ibEdiSndLog.setDoEdiTpCd(edoEdiTrans.getEdoTpCd());
                ibEdiSndLog.setMsgTpNm("CUSAGD");
                ibEdiSndLog.setMsgTpId("KTNMFCSDO_BTC");
                ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
                ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans.getAcount().getOfc_cd());
                ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans.getAcount().getUsr_id());
                ibEdiSndLog.setCreUsrId(edoEdiTrans.getAcount().getUsr_id());
                ibEdiSndLog.setUpdUsrId(edoEdiTrans.getAcount().getUsr_id());

                dbDao.addIbEdiSndLog(ibEdiSndLog);
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0682 : EDI 수신 <br>
     * EDO 승인 요청에 대한 처리 후 전송 결과(Ack)정보를 기록한다.<br>
     *
     * @param String rqstNo
     * @param String ackInd
     * @exception EventException
     */
    public void receiptEdoRqstAck(String rqstNo, String ackInd) throws EventException {
        try {
            dbDao.modifyEdoDoByAck(rqstNo, ackInd);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0682 : EDI 수신 <br>
     * KT-NET으로 부터 수신 받은 정보를 기록한다.<br>
     *
     * @param EdoRqstVO edoRqst
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void receiptEdo(EdoRqstVO edoRqst, SignOnUserAccount account) throws EventException {
        try {
            String edoTpCd = edoRqst.getBkgEdoMstVO().getEdoTpCd(); //EDO로 수신한 문서 종류 (5JN : D/O발급요청서 5JM : 자가운송신청서 5JK : 보세운송요청동의서)
            String podCd   = ""; // POD(화물을 양하할 Port)코드

            log.debug("==============================");
            log.debug("EDO로 수신한 문서 종류 : "+edoTpCd);
            log.debug("요청번호 : "+edoRqst.getBkgEdoMstVO().getEdoRqstNo());
            log.debug("==============================");

            //해당 선화 증권 번호(BL NO)에 해당하는 POD(화물을 양하할 Port)코드를 조회한다.
            podCd = dbDao.searchPodCd(edoRqst.getBkgEdoMstVO().getBlNo());

            //조회한 Pod를 세팅한다.
            edoRqst.getBkgEdoMstVO().setPodCd(podCd);

            //해당 EDO 요청 번호에 해당하는 Max SEQUENCE를 채번한다.
            String edoRqstSeq = dbDao.searchEdoMaxRqstSeq(edoRqst.getBkgEdoMstVO().getEdoRqstNo());

            //EDI 수신 메인 정보를 입력한다.
            dbDao.addEdoMst(edoRqst.getBkgEdoMstVO(), edoRqstSeq, account);

            //DO 발급요청 정보 입력
            if("5JN".equals(edoTpCd)){
                dbDao.addEdoDo(edoRqst.getBkgEdoDoVO(), edoRqstSeq, account);
            //자가운송 신청 입력
            }else if("5JM".equals(edoTpCd)){
                dbDao.addEdoSelfTrsp(edoRqst.getBkgEdoSelfTrspVO(), edoRqstSeq, account);
            //보세운송 동의요청 입력
            }else if("5JK".equals(edoTpCd)){
                dbDao.addEdoIbdTrsp(edoRqst.getBkgEdoIbdTrspVO(), edoRqstSeq, account);
            }

            //수화주 정보 멀티 건 등록
            List<BkgEdoPtyTrspVO> ptyTrspVoList = new ArrayList<BkgEdoPtyTrspVO>();
            Iterator<BkgEdoPtyTrspVO> itr = edoRqst.getBkgEdoPtyTrspVOs().iterator();

            while (itr.hasNext()){

                BkgEdoPtyTrspVO ptyTrspVo = (BkgEdoPtyTrspVO) itr.next();
                ptyTrspVo.setEdoRqstNo(edoRqst.getBkgEdoMstVO().getEdoRqstNo());
                ptyTrspVo.setEdoRqstSeq(edoRqstSeq);
                ptyTrspVo.setCreUsrId("ESM_BKG_B024");
                ptyTrspVo.setUpdUsrId("ESM_BKG_B024");
                ptyTrspVoList.add(ptyTrspVo);
            }

            if ( ptyTrspVoList.size() > 0 ) {
                dbDao.addEdoPtyTrsp(ptyTrspVoList);
            }

            //컨테이너 정보 멀티 건 저장
            List<BkgEdoCntrVO> cnntrVoList = new ArrayList<BkgEdoCntrVO>();
            Iterator<BkgEdoCntrVO> iterator = edoRqst.getBkgEdoCntrVOs().iterator();

            while (iterator.hasNext()) {
                BkgEdoCntrVO cntrVO = (BkgEdoCntrVO) iterator.next();
                cntrVO.setEdoRqstNo(edoRqst.getBkgEdoMstVO().getEdoRqstNo());
                cntrVO.setEdoRqstSeq(edoRqstSeq);
                //cntrVO.setCntrTpszCd(edoRqst.getBkgEdoMstVO());
                cntrVO.setCreUsrId("ESM_BKG_B024");
                cntrVO.setUpdUsrId("ESM_BKG_B024");
                cnntrVoList.add(cntrVO);
            }

            if ( cnntrVoList.size() > 0 ) {
                dbDao.addEdoCntr(cnntrVoList);
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0682 : EDI 수신 <br>
     * EDO Log 정보를 기록한다.<br>
     *
     * @param BkgEdoLogVO edoLog
     * @exception EventException
     */
    public void receiptEdoLog(BkgEdoLogVO edoLog) throws EventException {
        try {
            dbDao.addEdoLog(edoLog);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  Japan D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param bkgNo : 선적예약 요청 번호
     * @param SignOnUserAccount account
     * @return JapDoMstVO japDoMst
     * @exception EventException
     */
    public JapDoMstVO searchJapDo(String bkgNo, SignOnUserAccount account)throws EventException {

        JapDoMstVO japDoMst = new JapDoMstVO();

        try {
            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * Japan D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            japDoMst.setBlInfo(blInfo);

            if(blInfo != null){
            	log.debug("==============================");
                log.debug("searchDoBlInfo");
                log.debug("==============================");

            	// sequence 12 added delivery code를 기준으로 국가코드가 KR이 아닌경우 Exception BKG40091 발생 (20091106) Park Mangeon
                if(!blInfo.getDelCd().substring(0,2).equals("JP")) {  // 12
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                }

                /**
                 * D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                //doRef 널 값일 경우 Bkg No를 세팅한다. Save 시  PK값 사용
                if(doRef == null){
                    doRef = new BkgDoRefVO();
                    doRef.setBkgNo(blInfo.getBkgNo());
                }

                japDoMst.setDoRef(doRef);

                /**
                 * Japan세관 신고를 위한 B/L INFO를 조회한다.
                 */
                JapCstmsVO japCstms = dbDao.searchJapCstmsInfo(bkgNo);
                japDoMst.setJapCstms(japCstms);

                /**
                 * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                 */
                List<DoRlseStsVO> doRlseSts= dbDao.searchDoRlseSts(bkgNo);

                japDoMst.setDoRlseSts(doRlseSts);

                if(doRlseSts.size() > 0 ){
                    //Dor Interface 발행 실적 및 상태정보를 조회한다.
                    JapDorStatusVO japDorStatus = dbDao.searchJapDorStatus(bkgNo, doRlseSts.get(0).getRlseSeq());
                    //Jap DO ID Save 시 시트 정보에 BKG NO 필요함 BKG NO 세팅
                    japDorStatus.setBkgNo(bkgNo);
                    japDoMst.setJapDorStatus(japDorStatus);

                    //DOR I/F된 DOR들 중 DOR Transmit이 되지 않은 B/L의 개수
                    int dorStowage = dbDao.searchJapDorStowageCnt();
                    japDoMst.setDorStowage(String.valueOf(dorStowage));
                }

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                japDoMst.setBlIss(blIss);

                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(japDoMst.getBlInfo().getBlNo());
                otsRcvInfoVO = this.searchErpOtsInfo(japDoMst.getBlInfo().getBlNo());
                japDoMst.setOtsRcvInfoVO(otsRcvInfoVO);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
                japDoMst.setMrdId(mrdId);
            } else {
            	log.debug("==============================");
                log.debug("searchDoBlInfo 데이터 없음");
                log.debug("==============================");

            }
            return japDoMst;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     *
     * @param JapDoSaveVO japDoSave
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageJapDo(JapDoSaveVO japDoSave, SignOnUserAccount account) throws EventException {
        try {
            int resultCnt =0;

            BkgDoHisVO doHis = new BkgDoHisVO();

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(japDoSave.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }

            if("Y".equals(japDoSave.getOblCngFlg())){

                doHis.setBkgNo(japDoSave.getBkgNo());
                doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd(japDoSave.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO refInfo = dbDao.searchDoRefInfo(japDoSave.getBkgNo(), account);
            if(refInfo == null || !japDoSave.getInterRmk().equals(refInfo.getInterRmk())){

            	doHis = new BkgDoHisVO();

                doHis.setBkgNo(japDoSave.getBkgNo());
                doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
            	doHis.setDoCngEvntCd("IR");
            	if(refInfo == null){
            		doHis.setPreCtnt(null);
            	} else {
            		doHis.setPreCtnt(refInfo.getInterRmk());
            	}
            	doHis.setCrntCtnt(japDoSave.getInterRmk());
            	doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

            	dbDao.addDoHistory(doHis);
        	}

            if(refInfo == null || !japDoSave.getCyOpCd().equals(refInfo.getCyOpCd())){

            	doHis = new BkgDoHisVO();
            	doHis.setBkgNo(japDoSave.getBkgNo());
            	doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
            	doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd("CC");
                if(refInfo == null){
                          doHis.setPreCtnt(null);
                } else {
                          doHis.setPreCtnt(refInfo.getCyOpCd());
                }
                doHis.setCrntCtnt(japDoSave.getCyOpCd());
                doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            if(refInfo == null || !japDoSave.getInfoCgoFlg().equals(refInfo.getInfoCgoFlg())){

            	doHis = new BkgDoHisVO();
            	doHis.setBkgNo(japDoSave.getBkgNo());
            	doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
            	doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd("IC");
                if(refInfo == null){
                          doHis.setPreCtnt(null);
                } else {
                          doHis.setPreCtnt(refInfo.getInfoCgoFlg());
                }
                doHis.setCrntCtnt(japDoSave.getInfoCgoFlg());
                doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            if(!japDoSave.getBlissIbdDocRcvFlg().equals(japDoSave.getBlissOldIbdDocRcvFlg())){

            	doHis = new BkgDoHisVO();
            	doHis.setBkgNo(japDoSave.getBkgNo());
            	doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
            	doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd("BC");
				doHis.setPreCtnt(japDoSave.getBlissOldIbdDocRcvFlg());
				doHis.setCrntCtnt(japDoSave.getBlissIbdDocRcvFlg());
                doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            //[CHM-201640789] 2016.04.08 Charge Collection History
            if(refInfo == null || !japDoSave.getAttrCtnt1().equals(refInfo.getAttrCtnt1())){

            	doHis = new BkgDoHisVO();
            	doHis.setBkgNo(japDoSave.getBkgNo());
            	doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
            	doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd("CG");
                if(refInfo == null){
                          doHis.setPreCtnt(null);
                } else {
                          doHis.setPreCtnt(refInfo.getAttrCtnt1());
                }
                doHis.setCrntCtnt(japDoSave.getAttrCtnt1());
                doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO refInfos = new BkgDoRefVO();

            refInfos.setBkgNo(japDoSave.getBkgNo());
            refInfos.setCstmsRefNm(japDoSave.getCstmsRefNm());
            refInfos.setCstmsRefCtnt(japDoSave.getCstmsRefCtnt());
            refInfos.setCstmsAsgnNm(japDoSave.getCstmsAsgnNm());
            refInfos.setCstmsAsgnCtnt(japDoSave.getCstmsAsgnCtnt());
            refInfos.setInterRmk(japDoSave.getInterRmk());
            refInfos.setDoHldFlg(japDoSave.getDoHldFlg());
            refInfos.setCreUsrId(japDoSave.getAcount().getUsr_id());
            refInfos.setUpdUsrId(japDoSave.getAcount().getUsr_id());
            refInfos.setInfoCgoFlg(japDoSave.getInfoCgoFlg());
            refInfos.setDoSplitFlg(japDoSave.getDoSplitFlg());
            refInfos.setCyOpCd(japDoSave.getCyOpCd());
            refInfos.setAttrCtnt1(japDoSave.getAttrCtnt1());		//[CHM-201640789] 2016.04.08 Charge Collection 매핑 (BKG_DO_REF 테이블)

            resultCnt = dbDao.modifyDoRef(refInfos);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                dbDao.addDoRef(refInfos);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Japan D/O 대상 B/L에 대해 D/O Assign & Issue작업을 수행한다.
     *
     * @param JapDoIssueVO japDoIssue
     * @exception EventException
     */
    public void issueJapDo(JapDoIssueVO japDoIssue) throws EventException {
        try {
            //DO Assign / Issue 가능한지 확인한다.
            validateJapDoIssue(japDoIssue.getBkgNo());

            //DO No를 채번 한다.
            String doNo = makeDoNo(japDoIssue.getAcount().getOfc_cd(), japDoIssue.getAcount().getUsr_id());

            //Value Object 선언
            BkgDoVO bkgDo       = new BkgDoVO();
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            BkgDoDtlVO doDtl    = new BkgDoDtlVO();

            bkgDo.setBkgNo(japDoIssue.getBkgNo());
            bkgDo.setDoNo(doNo);
            bkgDo.setRlseSeq("1");
            bkgDo.setDoNoSplit("00");
            bkgDo.setCgorRmk(japDoIssue.getCgorRmk());
            bkgDo.setCreUsrId(japDoIssue.getAcount().getUsr_id());
            bkgDo.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

            bkgDoRef.setBkgNo(japDoIssue.getBkgNo());

            if(null != japDoIssue.getRefInfo()){

                bkgDoRef.setCyOpCd(japDoIssue.getRefInfo().getCyOpCd());
                bkgDoRef.setCstmsRefNm(japDoIssue.getRefInfo().getCstmsRefNm());
                bkgDoRef.setCstmsRefCtnt(japDoIssue.getRefInfo().getCstmsRefCtnt());
                bkgDoRef.setCstmsAsgnNm(japDoIssue.getRefInfo().getCstmsAsgnNm());
                bkgDoRef.setCstmsAsgnCtnt(japDoIssue.getRefInfo().getCstmsAsgnCtnt());
                bkgDoRef.setInterRmk(japDoIssue.getRefInfo().getInterRmk());
                bkgDoRef.setDoHldFlg(JSPUtil.getNull(japDoIssue.getRefInfo().getDoHldFlg(),"N"));
                bkgDoRef.setInfoCgoFlg(japDoIssue.getRefInfo().getInfoCgoFlg());
                bkgDoRef.setDoSplitFlg(JSPUtil.getNull(japDoIssue.getRefInfo().getDoSplitFlg(),"N"));
                bkgDoRef.setAttrCtnt1(japDoIssue.getRefInfo().getAttrCtnt1());		//[CHM-201640789] 2016.04.08 Charge Collection 매핑 (BKG_DO_REF 테이블)
            }else{
                bkgDoRef.setDoHldFlg("N");
                bkgDoRef.setDoSplitFlg("N");
            }
            bkgDoRef.setCreUsrId(japDoIssue.getAcount().getUsr_id());
            bkgDoRef.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            doDtl.setBkgNo(japDoIssue.getBkgNo());
            doDtl.setRlseSeq("1");
            doDtl.setRlseStsCd("I");
            doDtl.setEvntUsrId(japDoIssue.getAcount().getUsr_id());
            doDtl.setEvntOfcCd(japDoIssue.getAcount().getOfc_cd());
            doDtl.setCreUsrId(japDoIssue.getAcount().getUsr_id());
            doDtl.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

            BkgDoHisVO doHis = new BkgDoHisVO();

            doHis.setBkgNo(japDoIssue.getBkgNo());
            doHis.setCreUsrId(japDoIssue.getAcount().getUsr_id());
            doHis.setUpdUsrId(japDoIssue.getAcount().getUsr_id());
            doHis.setDoCngEvntCd("AI"); //AI  ASSIGN & ISSUE
            //doHis.setPreCtnt("");
            //doHis.setCrntCtnt("AI");
            doHis.setPreCtnt("");
            doHis.setCrntCtnt(doNo);

            doHis.setEvntUsrId(japDoIssue.getAcount().getUsr_id());
            doHis.setEvntOfcCd(japDoIssue.getAcount().getOfc_cd());

            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DO Assign / Issue 가능한지 확인한다.<br>
     * @param String bkgNo : 선적예약 요청 번호
     * @exception EventException
     */
    private void validateJapDoIssue(String bkgNo)throws EventException {
        try {
            //HOLD 여부 체크
            if(dbDao.checkHold(bkgNo)){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG00649").getMessage());
            }
            //Japan D/O 에서 Assign/Issue가 수행 됐는지 여부를 체크한다. 2011.07.28
            if(dbDao.checkJapDoIssue(bkgNo)){
                //Assign/Issue 수행 된 경우, 작업 중단
                throw new EventException(new ErrorHandler("BKG00434").getMessage());
            }
            //OBL 미 회수 메세지 전달
            /*
            if(dbDao.checkOBLRlseByLcl(bkgNo)){
                throw new EventException(new ErrorHandler("BKG00667").getMessage());
            }
            */
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * DO No를 채번한다.<br>
     * @param String ofcCd
     * @param String userId
     * @return String doNo
     * @exception EventException
     */
    private String makeDoNo(String ofcCd, String userId) throws EventException {

        BookingUtil command = new BookingUtil();
        BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = new BkgReferenceNoGenerationVO(); //채번할 D/O

        //D/O No 채번
        bkgReferenceNoGenerationVO = command.manageBkgReferenceNumberGeneration ( "D/O" , ofcCd, userId);
        return bkgReferenceNoGenerationVO.getDnoNo();
    }

    /**
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     * @param bkgDo
     * @param bkgDoRef
     * @param doDtl
     * @param doHis
     * @exception EventException
     */
    private void manageDo(BkgDoVO bkgDo, BkgDoRefVO bkgDoRef, BkgDoDtlVO doDtl, BkgDoHisVO doHis) throws EventException {
        try {
            int resultCnt = 0; // 업데이트 수행 결과 갯수

            if(bkgDo.getLginCntCd() != null) {
            	if(bkgDo.getLginCntCd().equals("ID")) {
                    String doPinNo = dbDao.searchDoPinNo();
                    bkgDo.setDoPinNo(doPinNo);
            	}
            }
            
            resultCnt = dbDao.modifyDo(bkgDo);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                dbDao.addDo(bkgDo);
            }

            if (null != bkgDoRef.getBkgNo()) {
	            //D/O Reference 정보 수정
	            resultCnt = dbDao.modifyDoRef(bkgDoRef);

	            //수정 건수가 없다면 신규생성 한다.
	            if ( resultCnt == 0 ) {
	                dbDao.addDoRef(bkgDoRef);
	            }
            }

            //Cancel Status 정보를 삭제한다
            dbDao.removeDoCancel(doDtl);

            //D/O 상세 정보를 저장한다
            dbDao.addDoDtlSts(doDtl);

            //D/O History정보를 생성한다.
            dbDao.addDoHistory(doHis);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * KL-NET을 통해 자가 운송 요청에 대한 취소 요청을 EDI로 전송 후 관련 데이타를 Cancel 처리한다.<br>
     *
     * @param KorDoEdiTransVO korDoEdiTrans
     * @exception EventException
     */
    public void transmitEdiByKorDo(KorDoEdiTransVO korDoEdiTrans) throws EventException {

        BkgIbEdiSndLogVO ibEdiSndLog = null;

        try {
            //* Default 값
            //1.Sender ID     : SMLMM010
            //2.Receiver ID   : KLDOCHKS
            //3.MsgId         : COREOR

            String senderId   = "SMLMM010";
            String receiverId = "KLDOCHKS";
            String msgId      = "COREOR";
            String queueNm    = "BKG.ALPSBKG_UBIZHJS_DO.IBMMQ.QUEUE"; //2011.09.22

            String doType = korDoEdiTrans.getDoType(); //DO TYPE

            BkgHrdCdgCtntVO hrdCDdgCtnt = new  BkgHrdCdgCtntVO();

            //
            if("KDL".equals(doType)){
            	queueNm = "DMT.ALPSDMT_UBIZHJS_DO.IBMMQ.QUEUE"; //2011.09.22
            }

            if(!"KDL".equals(doType)){
            	dbDao.mergeKorDoSelfTransFlg(korDoEdiTrans.getBkgNo(), korDoEdiTrans.getSelfTrnsFlg(), korDoEdiTrans.getAcount().getUsr_id());
            }
            //
            if("KDS".equals(doType)){
                if( "".equals( korDoEdiTrans.getDiscLocCd()) ){
                	korDoEdiTrans.setDiscLocCd(null);
                }

                if( korDoEdiTrans.getDiscLocCd() != null ){
                	hrdCDdgCtnt = dbDao.searchKorDoEdiId(korDoEdiTrans.getDiscLocCd());
                    if(hrdCDdgCtnt != null) {
                       senderId   = hrdCDdgCtnt.getAttrCtnt2();
                       receiverId = hrdCDdgCtnt.getAttrCtnt3();
                    }
                }

              // senderId   = JSPUtil.getNull(hrdCDdgCtnt.getAttrCtnt2(), senderId);
              // receiverId = JSPUtil.getNull(hrdCDdgCtnt.getAttrCtnt3(), receiverId);
            }

            String header   = dbDao.searchDoEdiHeader(senderId, receiverId, msgId);
            String doBlInfo = dbDao.searchEdiKorDoBlInfo(korDoEdiTrans.getBkgNo(), doType);

            if ( "".equals(doBlInfo) || doBlInfo == null) {
                throw new EventException(new ErrorHandler("BKG00205").getMessage());
            }

            //Booking Container 정보를 조회한다.
            String[] cntrInfo   = dbDao.searchEdiKorDoCntrInfo(korDoEdiTrans.getBkgNo(), doType);

            /*****************************************************************************
             * Flat File 생성
             * MQName : NISENT_UBIZHJS_DO   => ALPSBKG_UBIZHJS_DO
             * Sender ID : SMLMM010 ( Default Value )
             * Receiver ID : KLDOCHKS ( Default Value )
            *****************************************************************************/

            /**
             * EDI 연동.
             */
            StringBuffer flatFile = new StringBuffer();

            flatFile.append(header);
            flatFile.append(doBlInfo);

            for(int i=0 ; i < cntrInfo.length ; i++) {
               flatFile.append(cntrInfo[i]);
            }


            log.debug("\n========================================");
            log.debug("\n"+"KL-NET 호출");
            log.debug(flatFile.toString());
            log.debug("\n========================================");

            SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
            sendFlatFileVO.setFlatFile(flatFile.toString());

            //QueueNm 세팅
            //sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_DO.IBMMQ.QUEUE"));
            sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueNm)); //2011.09.22
            BookingUtil command = new BookingUtil();

            FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
            flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

            log.debug("\n========================================");
            log.debug("\n"+"KL-NET 호출");
            log.debug("doType: " + doType);
            log.debug("\n========================================");
            log.debug("doType: " + doType);



            //EDI ERROR 발생 시
            if ( flatFileAckVO.getAckStsCd().equals("E"))
                throw new EventException(new ErrorHandler("BKG00205").getMessage());


            ibEdiSndLog = new BkgIbEdiSndLogVO();

            ibEdiSndLog.setBkgNo(korDoEdiTrans.getBkgNo());
            ibEdiSndLog.setFltFileRefNo(header.substring(62,76));
            ibEdiSndLog.setDoEdiTpCd(doType); 
            ibEdiSndLog.setMsgTpId("KLDOCHKS");
            ibEdiSndLog.setMsgTpNm("COREOR");
            ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
            ibEdiSndLog.setEdiEvntOfcCd(korDoEdiTrans.getAcount().getOfc_cd());
            ibEdiSndLog.setEdiEvntUsrId(korDoEdiTrans.getAcount().getUsr_id());
            ibEdiSndLog.setCreUsrId(korDoEdiTrans.getAcount().getUsr_id());
            ibEdiSndLog.setUpdUsrId(korDoEdiTrans.getAcount().getUsr_id());

            dbDao.addIbEdiSndLog(ibEdiSndLog);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  D/O ID및 그 Detail정보를 EDI로 전송 한다. 일본은 EDI 송신 비용관계로 B/L별로 EDI 전송하지 않고 전송 대상을 10개 단위로 임시 보관 후 일괄 전송처리한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @exception EventException
     */
    public void transmitEdiByJapDor(JapDorEdiTransVO japDorEdiTrans) throws EventException {

    	BkgIbEdiSndLogVO ibEdiSndLog = null;
    	try {

            //HOLD 여부 체크
            if(dbDao.checkHold(japDorEdiTrans.getBkgNo())){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG00649").getMessage());
            }

            //MFR 전송 여부 체크 ( DOR 전송은 반드시 MFR 전송이 전제 조건으로 선행 되어야 함)
            if(!dbDao.checkJapMfrTransmit(japDorEdiTrans.getBlNo())){
                //HOLD 메세지 전달 : Hold로 인해  작업 중단
                throw new EventException(new ErrorHandler("BKG43038",new String[]{japDorEdiTrans.getBlNo()}).getMessage());
            }

            int cnt = 0; //DOR Transmit이 되지 않은 B/L의 개수

            //Japan D/O 에서 DOR 버튼 클릭시 
            //  C: 세관호출,D:D/O화면 호출
            if("D".equals(japDorEdiTrans.getSvcCd())){
                // Japan D/O 에서 DOR I/F가 수행 됐는지 여부를 체크한다. 2011.07.28
                if(dbDao.checkJapDor(japDorEdiTrans.getBkgNo())){
                	//해당 BkgNo에 대해 DOR I/F가 수행 된 경우, 작업 중단
                    throw new EventException(new ErrorHandler("BKG43046").getMessage());
                }

                //Tmp에 대상 목록을 추가한다.
                dbDao.addJapDorTmp(japDorEdiTrans);

                //D/O HISTORY 생성
                japDorEdiTrans.setDoCngEvntCd("DF");
                japDorEdiTrans.setCrntCtnt("DF");

                BkgDoHisVO bkgDoHis = new BkgDoHisVO();

                bkgDoHis.setBkgNo(japDorEdiTrans.getBkgNo());
                bkgDoHis.setDoCngEvntCd(japDorEdiTrans.getDoCngEvntCd());

                bkgDoHis.setPreCtnt("");
                bkgDoHis.setCrntCtnt(japDorEdiTrans.getDoNo());
 
                bkgDoHis.setEvntUsrId(japDorEdiTrans.getCreUsrId());
                bkgDoHis.setEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
                bkgDoHis.setCreUsrId(japDorEdiTrans.getCreUsrId());
                bkgDoHis.setUpdUsrId(japDorEdiTrans.getUpdUsrId());

                dbDao.addDoHistory(bkgDoHis);

                dbDao.modifyJapDorStsByReqest(japDorEdiTrans);

                //DOR I/F된 DOR들 중 DOR Transmit이 되지 않은 B/L의 개수
                cnt = dbDao.searchJapDorStowageCnt();

                BkgDoDtlVO bkgDoDtl = new BkgDoDtlVO();

                bkgDoDtl.setBkgNo(japDorEdiTrans.getBkgNo());
                bkgDoDtl.setRlseSeq(japDorEdiTrans.getRlseSeq());
                bkgDoDtl.setRlseStsCd("D");
                bkgDoDtl.setEvntUsrId(japDorEdiTrans.getCreUsrId());
                bkgDoDtl.setEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
                bkgDoDtl.setUpdUsrId(japDorEdiTrans.getUpdUsrId());
                bkgDoDtl.setCreUsrId(japDorEdiTrans.getCreUsrId());

                dbDao.addDoDtlSts(bkgDoDtl);
            }

           // if(cnt >0 ||"C".equals(japDorEdiTrans.getSvcCd())){
            if(cnt >9 ||"C".equals(japDorEdiTrans.getSvcCd())){

                //Japan D/O를 10개 단위로 묶어서  일괄 전송 할 그룹번호를 채번한다.
                String grpNo = dbDao.searchJapDorNextGrpNo();
                japDorEdiTrans.setGrpNo(grpNo);

                // 일본 D/O 고정값
                japDorEdiTrans.setRlseSeq("1");

                //최초 요청시 'R' -> 10개가 모여 전송이  완료되면 GROUP NUMBER가 부여되면서  'T' 로 변경됨
                dbDao.modifyJapDorTmpStsByTrans(japDorEdiTrans);

                String header   = dbDao.searchEdiSeanaccsHeader(japDorEdiTrans);
                String common   = dbDao.searchEdiSeanaccsCommon(japDorEdiTrans);
                String eventCd  = dbDao.searchEdiSeanaccsEventType(japDorEdiTrans.getEvntCd());
                String[] blInfo = dbDao.searchEdiSeanaccsBlInfoByTrans(japDorEdiTrans);

                StringBuffer blInfo_tmp = new StringBuffer();

                for(int idx =0; idx <blInfo.length; idx++){
                   blInfo_tmp.append(blInfo[idx]);
                }


                /*
                 * EDI 연동.
                 */
                StringBuffer flatFile = new StringBuffer();

                flatFile.append(header);
                flatFile.append(common);
                flatFile.append(eventCd);
                flatFile.append(blInfo_tmp.toString());

                SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
                sendFlatFileVO.setFlatFile(flatFile.toString());

                log.debug("\n========================================");
                log.debug("\n"+"transmitEdiByJapDor 로그 호출" + "\n");
                log.debug(flatFile.toString());
                log.debug("\n========================================");

                //QueueNm 세팅
                sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
                BookingUtil command = new BookingUtil();

                FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
                flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
              //  flatFileAckVO.setAckStsCd("A");

                //EDI ERROR 발생 시
                if ( flatFileAckVO.getAckStsCd().equals("E"))
                    throw new EventException(new ErrorHandler("BKG00205").getMessage());

                dbDao.modifyJapDorStsByTrans(japDorEdiTrans);

                dbDao.addJapDorHistoryByTrans(japDorEdiTrans);

                ibEdiSndLog = new BkgIbEdiSndLogVO();

                ibEdiSndLog.setFltFileRefNo("DOR");
                ibEdiSndLog.setDoEdiTpCd("JDF");  //  JDF  : JAPAN D/O DOR I/F
                ibEdiSndLog.setMsgTpId("JPNCUS");
                ibEdiSndLog.setMsgTpNm("MANIFEST");
                ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());


                ibEdiSndLog.setEdiEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
                ibEdiSndLog.setEdiEvntUsrId(japDorEdiTrans.getCreUsrId());
                ibEdiSndLog.setCreUsrId(japDorEdiTrans.getCreUsrId());
                ibEdiSndLog.setUpdUsrId(japDorEdiTrans.getCreUsrId());

                dbDao.addIbEdiSndLogByJapDorEvnt(ibEdiSndLog,grpNo);




            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Japan Dor I/F를 취소한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @exception EventException
     */
    public void transmitEdiByJapDorCancel(JapDorEdiTransVO japDorEdiTrans) throws EventException {
    	BkgIbEdiSndLogVO ibEdiSndLog = null;
        try {

            //전송 대상 항목으로 상태로 변경한다.
            dbDao.modifyJapDorStsByReqest(japDorEdiTrans);

            String header   = dbDao.searchEdiSeanaccsHeader(japDorEdiTrans);
            String common   = dbDao.searchEdiSeanaccsCommonByCancel(japDorEdiTrans);
            String eventCd  = dbDao.searchEdiSeanaccsEventType(japDorEdiTrans.getEvntCd());
            String[] blInfo = dbDao.searchEdiSeanaccsBlInfoByCancel(japDorEdiTrans);

            StringBuffer blInfo_tmp = new StringBuffer();

            for(int idx =0; idx <blInfo.length; idx++){
               blInfo_tmp.append(blInfo[idx]);
            }

            /*
             * EDI 연동.
             */
            StringBuffer flatFile = new StringBuffer();

            flatFile.append(header);
            flatFile.append(common);
            flatFile.append(eventCd);
            flatFile.append(blInfo_tmp.toString());

            SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
            sendFlatFileVO.setFlatFile(flatFile.toString());

            //QueueNm 세팅
            sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
            BookingUtil command = new BookingUtil();

            FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
            flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

            //EDI ERROR 발생 시
            if ( flatFileAckVO.getAckStsCd().equals("E"))
                throw new EventException(new ErrorHandler("BKG00205").getMessage());

            dbDao.removeDoDtlByCancel(japDorEdiTrans.getBkgNo(), japDorEdiTrans.getRlseSeq(),"'D','C'");

            //EDI로 전송을 요청한 상태 코드를 CANCEL(X) 상태로 변경한다.
            dbDao.modifyJapDorCancel(japDorEdiTrans);

            //History
            japDorEdiTrans.setDoCngEvntCd("DC"); //Dor Cancel
            japDorEdiTrans.setPreCtnt(japDorEdiTrans.getDoNo());
            japDorEdiTrans.setCrntCtnt("NO");

            dbDao.addJapDorHistoryByRequest(japDorEdiTrans);

            ibEdiSndLog = new BkgIbEdiSndLogVO();

            ibEdiSndLog.setBkgNo(japDorEdiTrans.getBkgNo());
            ibEdiSndLog.setFltFileRefNo("DOR");
            ibEdiSndLog.setDoEdiTpCd("JDC");  //  JDC : JAPAN D/O DOR Cancel
            ibEdiSndLog.setMsgTpId("JPNCUS");
            ibEdiSndLog.setMsgTpNm("MANIFEST");
            ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
            ibEdiSndLog.setEdiEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
            ibEdiSndLog.setEdiEvntUsrId(japDorEdiTrans.getCreUsrId());
            ibEdiSndLog.setCreUsrId(japDorEdiTrans.getCreUsrId());
            ibEdiSndLog.setUpdUsrId(japDorEdiTrans.getCreUsrId());

            dbDao.addIbEdiSndLog(ibEdiSndLog);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Japan Do Id 정보를 Update 한다.<br>
     *
     * @param JapDorStatusVO japDorStatus
     * @exception EventException
     * @author Lim JinYoung
     */
    public void modifyJapDoId(JapDorStatusVO japDorStatus)throws EventException {
        try {
            dbDao.modifyJapDoId(japDorStatus);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
/******************************************************************************************
* Author : Lim JinYoung End
******************************************************************************************/

/******************************************************************************************
* Author : Park SungHo Start
******************************************************************************************/


    /**
     * VVD별 ERP OutStanding 정보를 EAI I/F로 실시간 제공을 받는다.<br>
     *
     * @param BkgOutstandingVO ots
     * @return String chkFlg
     * @exception EventException
     */
    public String receiveOtsMst(BkgOutstandingVO ots) throws EventException {
    	String chkFlg = "N";
    	try {

    		 if("I".equals(ots.getOtsBndTpCd())) {
   			     dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(),  "1:" +  ots.getOtsTjSeq() + ":" + ots.getLstCltOfcCd() + ":" + ots.getCrFlg() + ":" + ots.getOtsStlFlg());
   		     }

    		 chkFlg = dbDao.checkOtsLstUptValid(ots);

        	 if("Y".equals(chkFlg)){
    		     dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(), "2:" +   ots.getOtsTjSeq() + ":" + ots.getLstCltOfcCd() + ":" + ots.getCrFlg() + ":" + ots.getOtsStlFlg());
   	            dbDao.mergeOts(ots);
        	 }
     		dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(),  chkFlg+":"+ots.getOtsBndTpCd()+"==>"+ ots.getOtsTjSeq() + ":" + ots.getOfcCd() + ":" + ots.getInvNo());
        } catch (DAOException de) {
        	log.error("receiveOtsMst err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), de);
        } catch (Exception ex) {
        	log.error("receiveOtsMst err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return chkFlg;

    }


    /**
     * VVD별 ERP OutStanding 정보를 EAI I/F로 실시간 제공을 받는다.<br>
     *
     * @param BkgOtsDtlVO otsDtls
     * @exception EventException
     */
    public void receiveOtsDtl(BkgOtsDtlVO otsDtls) throws EventException {

        try {
	         	dbDao.mergeOtsDtl(otsDtls);
        } catch (DAOException de) {
        	log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), de);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }

    }

    /**
     * VVD별 쪽에서 데이터를 받음.
     *
     * @param BkgOutstandingVO ots
     * @exception Exception
     */
    public void searchOtsUsCgo(BkgOutstandingVO ots) throws Exception {
        try {
               // Coollection 회수 정보가 있고 발생 이벤트중 마지막 이벤트에대해서만 작업 수행
	             String frtCltFlg = "N";
	             if( "Y".equals( ots.getOtsStlFlg() )){
	                 frtCltFlg = "Y";
	             }
       	  		 dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(), "searchOtsUsCgo frtCltFlg:"+frtCltFlg);

		         FrtCltLstVO frtCltLst = new FrtCltLstVO(); //dbDao.searchBkbcOtsUsCgo(ots);

		         frtCltLst.setBlNo(ots.getCltBlNo());
		         frtCltLst.setEvntOfcCd(ots.getLstCltOfcCd());
		         frtCltLst.setEvntUsrId("ERP");
		         frtCltLst.setEvntDt(ots.getUpdDt());
		         frtCltLst.setCgorTeamCd("F");
		         frtCltLst.setCgoEvntNm("ERP_FINANCE");
		         frtCltLst.setFrtCltFlg(frtCltFlg);

		         if("Y".equals(dbDao.checkScndOtsLstUptValid(ots))){ // 유효성 체크
		        	dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(), "searchOtsUsCgo:checkScndOtsLstUptValid=Y");
		            this.setupFocByFreight(frtCltLst);
		       	 }

               } catch(EventException ex){
            	   log.error("searchOtsUsCgo err " + ex.toString(), ex);
                  throw ex;
               }catch (Exception ex) {
                   log.error("searchOtsUsCgo err " + ex.toString(), ex);
                  throw new EventException(new ErrorHandler("COM12240")
                           .getMessage(), ex);
               }

    }

    /**
     * [0909] 미주 Inbound Cargo Release에 대한 List를 Item별로 조회한다.
     *
     * @param UsCgoRlseSearchVO searchvo
     * @return List<UsCgoRlseListVO>
     * @exception EventException
     */
    public List<UsCgoRlseListVO> searchUsCgoRlseList(UsCgoRlseSearchVO searchvo) throws EventException {
        List<UsCgoRlseListVO> listVO = null;

        try {
            listVO = dbDao.searchUsCgoRlseList(searchvo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return listVO;
    }



    /**
     * [0909] B/L별 컨테이너 번호를 조회한다.
     *
     * @param String bkgNo
     * @return List<BkgContainerVO>
     * @exception EventException
     */
    public List<BkgContainerVO> searchUsCgoRlseFoc(String bkgNo) throws EventException {
        List<BkgContainerVO> listVO = null;

        try {
            listVO = dbDao.searchUsCgoRlseFoc(bkgNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return listVO;
    }

    /**
     * [0909] save버튼 저장 backendjob 수행안함
     *
     * @param BkgCgoRlseVO bkgCgoRlseVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUsCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException {

        try {
            /***************************
             * 1. BKG_CGO_RLSE UPDATE.
             ****************************/
            if (bkgCgoRlseVo != null) {

               int modRowsByMaster = dbDao.modifyUsCgoRlseEdi(bkgCgoRlseVo, account);

               if (modRowsByMaster > 0) {// SUCCESS 이면
                   dbDao.addUsCgoRlseHisEdi(bkgCgoRlseVo, account, "M","MANUAL");
               }

              /***************************
	           * 2. FOC 관리 시작(EDI 전송)
	           ****************************/
	            // 세관 신고 여부를 체크한다.
	           if( !"X".equals(dbDao.checkCstmsEvnt(bkgCgoRlseVo.getBlNo()))){
	               UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao,account,bkgCgoRlseVo.getBlNo());
                   backEnd.doStart();
               }else{
                  log.debug("------------------ backendjob is not executed!!!!");
               }
            }
        } catch (EventException ex) {
            if(ex.getMessage().indexOf("BKG40085") > -1  ){
            	log.debug("");
            }else{
                log.error("err " + ex.toString(), ex);
	        }

        	throw ex;

        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * [0156] COD Application POD 변경시 CgoRlse<br>
     *
     * @param BkgCgoRlseVO bkgCgoRlseVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUsCgoRlseChangePod(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException {

        try {
            if (bkgCgoRlseVo != null) {

              /***************************
	           * 2. FOC 관리 시작(EDI 전송)
	           ****************************/
	            // 세관 신고 여부를 체크한다.
	           if( !"X".equals(dbDao.checkCstmsEvnt(bkgCgoRlseVo.getBlNo()))){
	        	   UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao,account,bkgCgoRlseVo);
                   backEnd.doStart();
               }else{
                  log.debug("------------------ backendjob is not executed!!!!");
               }

            }
        } catch (EventException ex) {
            if(ex.getMessage().indexOf("BKG40085") > -1  ){
            	log.debug("");
            }else{
                log.error("err " + ex.toString(), ex);
	        }

        	throw ex;

        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * [0909] Hold 작업을 수행한다.
     *
     * @param DoRefVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUsCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException {

        try {
            String blNo = "";
            DoRefVO vo = new DoRefVO();


            //D/O HISTORY 생성
            BkgDoHisVO doHis = new BkgDoHisVO();
            log.debug("------------vo.getDoHldFlg() "+vo.getDoHldFlg());

            // 1번만 실행됨.
            for (int i = 0; i < vos.length; i++) {
                vo = vos[i];
                int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
                if (modRowsByMaster == 0) {
                    dbDao.addHoldFlgDoRef(vo, account);
                }
                blNo = vo.getBlNo();


                //History
                log.debug("------------D/O HISTORY 생성11");
                log.debug("------------ vo "+vo.getColumnValues());
                //doHis.setBkgNo(vo.getBkgNo());//필요시 vo 만변경
                doHis.setCreUsrId(account.getUsr_id());
                doHis.setUpdUsrId(account.getUsr_id());
                if(vo.getDoHldFlg().equals("Y")){
                	doHis.setDoCngEvntCd("HC");
                }else if(vo.getDoHldFlg().equals("N")){
                	doHis.setDoCngEvntCd("CH");
                }
                doHis.setPreCtnt("NO");
                doHis.setCrntCtnt("YES");
                doHis.setEvntUsrId(account.getUsr_id());
                doHis.setEvntOfcCd(account.getOfc_cd());
                doHis.setBkgNo(vo.getBkgNo());
                dbDao.addDoHistory(doHis);

                // Hold Removal 일 경우 UsCgoRlseBackEndJob 실행
                try{
                	if("N".equals(vo.getDoHldFlg())){
	    	            UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao,account,vo.getBlNo());
	    	            backEnd.doStart();
                	}
                } catch(EventException ex) {

                    if(ex.getMessage().indexOf("BKG40085") > -1 || ex.getMessage().indexOf("BKG40086") > -1 || ex.getMessage().indexOf("BKG40087") > -1 || ex.getMessage().indexOf("BKG40108") > -1){
                    	break;
                    }else{
                        throw ex;
                    }
                }

                break;

            }
            // 여러개의 B/L 에 대해 Hold
            List<DoRefVO> blList = dbDao.searchHoldFlgPrtBl(blNo);
            for (int j = 0; j < blList.size(); j++) {
                vo.setBlNo(blList.get(j).getBlNo());
                BookingUtilDBDAO buDao = new BookingUtilDBDAO();
                vo.setBkgNo(buDao.searchBkgNoByBlNo(vo.getBlNo()));
                log.debug("--------------- 여러개 Hold " + j + " vo.getBlNo() "  + vo.getBlNo());
                log.debug("--------------- 여러개 Hold " + j + " vo.getBkgNo() " + vo.getBkgNo());
                int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
                if (modRowsByMaster == 0) {
                    dbDao.addHoldFlgDoRef(vo, account);
                }
                //History
                doHis.setBkgNo(vo.getBkgNo());
                dbDao.addDoHistory(doHis);

                // Hold Removal 일 경우 UsCgoRlseBackEndJob 실행
                try {
	                if("N".equals(vo.getDoHldFlg())){
	    	            UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao,account,vo.getBlNo());
	    	            backEnd.doStart();
	                }
                } catch(EventException ex) {

                    if(ex.getMessage().indexOf("BKG40085") > -1 || ex.getMessage().indexOf("BKG40086") > -1 || ex.getMessage().indexOf("BKG40087") > -1 || ex.getMessage().indexOf("BKG40108") > -1){
                    	continue;
                    }else{
                        throw ex;
                    }
                }
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * [0909]세관쪽에서 호출되는 Cargo Release를 처리한다.
     * @param CstmsClrVO cstmsClr
     * @exception Exception
     */
    public void setupFocByCstms(CstmsClrVO cstmsClr) throws Exception {

		dbDao.receiveOtsLog("BKG_US_CGO_SWB", cstmsClr.getBlNo(), "21.Call Cstms");

        try {
        	 log.debug("--------------------- setupFocByCstms method 실행 ");

             CstmsClrVO retVO = dbDao.searchBkbcCstms(cstmsClr);
             String orgBlNo = cstmsClr.getBlNo();

             dbDao.receiveOtsLog("BKG_US_CGO_SWB", cstmsClr.getBlNo(), "22.Call Cstms UsChk:" + retVO.getUsChk() + ", CntCd:"+retVO.getCntCd());
             if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {// US경우만
                // 실행

                if (Integer.parseInt(retVO.getCstmsChkCnt()) == 0) {
                    dbDao.addBkbcCstmsUsCgoRlse(cstmsClr);
                } else if (Integer.parseInt(retVO.getCstmsChkCnt()) > 0) {
                    dbDao.modifyBkbcCstmsUsCgo(cstmsClr);
                }

                dbDao.addBkbcCstmsUsCgoRlseHis(cstmsClr);
                // retVO = dbDao.searchBkbcMaxHisSeq(cstmsClr);


                SignOnUserAccount account = new SignOnUserAccount(cstmsClr
                        .getEvntUsrId(), "2", "3", "4", "5", "6", "7", "8",
                        "9", "10", "11", "12", cstmsClr.getEvntOfcCd(), "14",
                        "15", "16", "17", "18", "19", "20", "21", "22");
                log.debug("~~~~~~~~~~    account.getUsr_id()    "
                        + account.getUsr_id());
                log.debug("~~~~~~~~~~    account.getOfc_cd()    "
                        + account.getOfc_cd());

                //-----------------------------------------------
                //관련 bl 을 구하여 처리한다.
                //-----------------------------------------------
                log.debug("-------- 관련 bl 을 구하여 처리한다.");

                if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
            		dbDao.receiveOtsLog("BKG_US_CGO_SWB", cstmsClr.getBlNo(), "23.Call Cstms doStart");
                    UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao, account, orgBlNo);
                    backEnd.doStart();
                }
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw de;
        } catch (Exception ex) {
            if(ex.getMessage().indexOf("BKG40085") > -1  ){
            	log.debug("");
            }else{
                log.error("err " + ex.toString(), ex);
            }

            throw ex;
        }
    }

    /**
     * [0909]ERP에서 호출되는 Cargo Release 를 처리한다.
     *
     * @param FrtCltLstVO frtCltLst
     * @exception Exception
     */
    public void setupFocByFreight(FrtCltLstVO frtCltLst) throws Exception {

		dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "21.Call Freight");
        try {
        	 log.error("setupFocByFreight searchBkbcFrt start");
             FrtCltLstVO retVO = dbDao.searchBkbcFrt(frtCltLst);
             String orgBlNo = frtCltLst.getBlNo();
             log.error("setupFocByFreight searchBkbcFrt end"+frtCltLst.getBlNo());

            dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "22.Call Freight UsChk:" + retVO.getUsChk() + ", CntCd:"+retVO.getCntCd() + ",  CaChk:"+ retVO.getCaChk());
            if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {// US경우만(POD가 US,CANAD,MEXICO가 포함된다.)

                // 실행
                if (Integer.parseInt(retVO.getFrtChkCnt()) == 0) {
                    dbDao.addBkbcFrtUsCgoRlse(frtCltLst);
                } else if (Integer.parseInt(retVO.getFrtChkCnt()) > 0) {
                    dbDao.modifyBkbcFrtUsCgo(frtCltLst);
                }

                dbDao.addBkbcFrtUsCgoRlseHis(frtCltLst);
                // retVO = dbDao.searchBkbcMaxHisSeq(frtCltLst);

                SignOnUserAccount account = new SignOnUserAccount(frtCltLst
                        .getEvntUsrId(), "2", "3", "4", "5", "6", "7", "8",
                        "9", "10", "11", "12", frtCltLst.getEvntOfcCd(), "14",
                        "15", "16", "17", "18", "19", "20", "21", "22");
                log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
                log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());


                //-----------------------------------------------
                //관련 bl 을 구하여 처리한다.
                //-----------------------------------------------
                log.debug("-------- 관련 bl 을 구하여 처리한다.");


                if(retVO.getCntCd()!=null && retVO.getCaChk().equals("CA")){
            		dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "23.Freight CA doStart");
                	this.caCgoRlse(orgBlNo, account);
                }
                else if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
                	if( !"X".equals(dbDao.checkCstmsEvnt(orgBlNo))){ // 세관 신고 여부 체크
                		dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "23.Freight US doStart");
                		UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao,account, orgBlNo);
                		backEnd.doStart();
                	}
                }
            }
        } catch(NullPointerException se){
        	 log.error("setupFocByFreight null err " + se.toString(), se);
        	 throw se;
        } catch (DAOException de) {
            log.error("setupFocByFreight DAO err " + de.toString(), de);
            throw de;
        }	catch (Exception ex) {
            if(ex.getMessage().indexOf("BKG40085") > -1  ){
            	log.debug("");
            }else{
                log.error("setupFocByFreight Except err " + ex.toString(), ex);
            }

            throw ex;
        }
    }

    /**
     * [0909]O/B 쪽에서 호출되는 Cargo Release 를 처리한다.
     *
     * @param OblRdemVO oblRdem
     * @exception Exception
     */
    public void setupFocByObl(OblRdemVO oblRdem) throws Exception {

	        try {
	        	if(oblRdem != null){
	        		dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "21-1.Call Obl CgoTeamCd:"+oblRdem.getCgorTeamCd()+" ,RdemFlg:"+oblRdem.getOblRdemFlg()+" ,CgorTeamCd:"+oblRdem.getCgorTeamCd()  );

		        	 if(!oblRdem.getCgorTeamCd().equals("C") && !oblRdem.getCgorTeamCd().equals("B")){
		    	        log.debug("--------------------- setupFocByObl method 실행 ");
		    	        OblRdemVO retVO = dbDao.searchBkbcObl(oblRdem);
		    	        String orgBlNo = oblRdem.getBlNo();

		                dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "21-2.Call Obl CntCd:"+retVO.getCntCd()+", UsChk:"+retVO.getUsChk()+", CaChk:"+retVO.getCaChk());

  		    	        // US경우
				        if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {

			                dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "22.US Call Obl CntCd:"+retVO.getCntCd()+", UsChk:"+retVO.getUsChk()+", CaChk:"+retVO.getCaChk());

				                // Model No. 8
				                // retVO = dbDao.searchBkbcMaxHisSeq(oblRdem);

				                //FrtCltLstVO cltLstVO = dbDao.searchBkbcFrtByObl(oblRdem.getBlNo());
				            	FrtCltLstVO cltLstVO = new FrtCltLstVO();

				                cltLstVO.setBlNo(oblRdem.getBlNo());
				                cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
				                cltLstVO.setEvntDt(oblRdem.getEvntDt());
				                cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
				                cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
				                cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());

				                if(oblRdem.getCgorTeamCd().equals("S") ){
				                	cltLstVO.setOblRdemFlg(oblRdem.getOblRdemFlg());
				                }else {
				                	cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());
				                }

				                // 실행
				                if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
				                    dbDao.addBkbcOblUsCgoRlse(cltLstVO);
				                } else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {
				                    dbDao.modifyBkbcOblUsCgo(cltLstVO);
				                }

				                //cltLstVO.setFrtCltFlg(frtCltFlg);

				                // Model No. 7
				                dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

				                SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
				                        , "2", "3", "4", "5", "6", "7", "8",
				                        "9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
				                        "15", "16", "17", "18", "19", "20", "21", "22");
				                log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
				                log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());

				                //-----------------------------------------------
				                //관련 bl 을 구하여 처리한다.
				                //-----------------------------------------------
				                log.debug("-------- 관련 bl 을 구하여 처리한다.");

		        				if(retVO.getCntCd()!= null && retVO.getCaChk().equals("CA")){
		                    		dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "23.US.CA Obl doStart");
		        					this.caCgoRlse(orgBlNo, account);
		        				}else if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
				                    UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao, account, orgBlNo);
				                    dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "23.US.US Obl doStart");
				                    backEnd.doStart();
				                }
				         } else{

				    	        retVO = dbDao.searchBkbCacObl(oblRdem);
				    	        orgBlNo = oblRdem.getBlNo();

				        		 // CA 경우

				                dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "31.CA CHECK cntCd:"+retVO.getCntCd()+",fobCaChk:"+retVO.getFobCaChk()+", podCaChk:"+retVO.getPodCaChk());

				    	        if ( retVO.getFobCaChk() != null && retVO.getFobCaChk().equals("Y")
				    	        		&& retVO.getCntCd()!=null && retVO.getCntCd().equals("CA")
				    	        		&& retVO.getPodCaChk()!=null && retVO.getPodCaChk().equals("CA") ){

					            	FrtCltLstVO cltLstVO = new FrtCltLstVO();

					                cltLstVO.setBlNo(oblRdem.getBlNo());
					                cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
					                cltLstVO.setEvntDt(oblRdem.getEvntDt());
					                cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
					                cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
					                cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());

					                if(oblRdem.getCgorTeamCd().equals("S") ){
					                	cltLstVO.setOblRdemFlg(oblRdem.getOblRdemFlg());
					                }else {
					                	cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());
					                }

					                // 실행
					                if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
					                    dbDao.addBkbcOblUsCgoRlse(cltLstVO);
					                } else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {
					                    dbDao.modifyBkbcOblUsCgo(cltLstVO);
					                }

					                // Model No. 7
					                dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

					                SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
					                        , "2", "3", "4", "5", "6", "7", "8",
					                        "9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
					                        "15", "16", "17", "18", "19", "20", "21", "22");

					                dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "32.CA Obl doStart");
		        					this.caCgoRlse(orgBlNo, account);
				    	        }
					         }

			        	 }
		        	}//if(oblRdem != null){
		        } catch (DAOException de) {
		            log.error("setupFocByObl DAOException err" + de.toString(), de);
		            throw de;
		        } catch (Exception ex) {

		            if(ex.getMessage().indexOf("BKG40085") > -1  ){
		            	log.debug("");
		            }else{
			            log.error("setupFocByObl Exception err" + ex.toString(), ex);
			        }

		            throw ex;
		        }
	    }


    /**
     * [0909]O/B 쪽에서 호출되는 배열을 Cargo Release 를 처리한다.
     * @param OblRdemVO[] oblRdems
     * @throws Exception
     */
    public void setupFocByOblAutoBdr(OblRdemVO[] oblRdems) throws Exception {

    	try {
            	   for(int i=0;i<oblRdems.length;i++){
                       OblRdemVO oblRdem = oblRdems[i];

                       OblRdemVO retVO = dbDao.searchBkbcObl(oblRdem);
                       String orgBlNo = oblRdem.getBlNo();

		                if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {// US경우만

		                    // Model No. 8
		                    // retVO = dbDao.searchBkbcMaxHisSeq(oblRdem);

		                    //FrtCltLstVO cltLstVO = dbDao.searchBkbcFrtByObl(oblRdem.getBlNo());
		                	FrtCltLstVO cltLstVO = new FrtCltLstVO();

		                    cltLstVO.setBlNo(oblRdem.getBlNo());
		                    cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
		                    cltLstVO.setEvntDt(oblRdem.getEvntDt());
		                    cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
		                    cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
		                    cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());
		                    cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());

		                    // 실행
		                    if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
		                        dbDao.addBkbcOblUsCgoRlse(cltLstVO);
		                    } else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {

		                        dbDao.modifyBkbcOblUsCgo(cltLstVO);
		                    }

		                    //cltLstVO.setFrtCltFlg(frtCltFlg);
		                    // Model No. 7
		                    dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

		                    SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
		                            , "2", "3", "4", "5", "6", "7", "8",
		                            "9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
		                            "15", "16", "17", "18", "19", "20", "21", "22");
		                    log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
		                    log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());

		                    //-----------------------------------------------
		                    //관련 bl 을 구하여 처리한다.
		                    //-----------------------------------------------
		                    log.debug("-------- 관련 bl 을 구하여 처리한다.");

		                    if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
		                        UsCgoRlseBackEndJob backEnd = new UsCgoRlseBackEndJob(dbDao, account, orgBlNo);
		                        //backEnd.doStart();
		                        BackEndJobManager backEndJobManager = new BackEndJobManager();
		                        backEndJobManager.execute(backEnd, account.getUsr_id(), "ESM_BKG_0909 Us Cargo Release Order");
		                    }

		                }
            	   }
            } catch (DAOException de) {
                log.error("err " + de.toString(), de);
                throw de;
            } catch (Exception ex) {
                log.error("err " + ex.toString(), ex);
                throw ex;
            }
    }

    /**
     * [0909]ERP I/F를 위한 EAIDAO 호출
     *
     * @param String blNo
     * @return OtsRcvInfoVO
     * @exception EventException
     */
    public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException {
        OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
        try {
            log.debug("ERP I/F를 위한 EAIDAO 호출");
            otsRcvInfoVO = eaiDbDao.searchOtsInfo(blNo);
            //otsRcvInfoVO.setTotOtsCurrCd1("XXX");
            //otsRcvInfoVO.setTotOtsAmt1("10000");
            log.debug("------------------- otsRcvInfoVO " + otsRcvInfoVO.getColumnValues());
            //if(otsRcvInfoVO.getTotOtsCurrCd1() == null || otsRcvInfoVO.getTotOtsCurrCd1().trim().equals("")){
            if(otsRcvInfoVO.getTotOtsAmt1() == null
            		|| otsRcvInfoVO.getTotOtsAmt1().trim().equals("")
            		|| otsRcvInfoVO.getTotOtsStsCd() == null
            		|| otsRcvInfoVO.getTotOtsStsCd().trim().equals("")
            		){
            	otsRcvInfoVO.setTotOtsStsCd("");
                otsRcvInfoVO.setTotOtsAmt1("N/A");
            }
            //if(true){
            //	throw new EventException(new ErrorHandler("COM12240").getMessage());
            //}
        } catch (DAOException de) {
        	//중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (ERP 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다.)
            //log.error("err " + de.toString(), de);
            otsRcvInfoVO.setTotOtsStsCd("");
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            log.error(de.getMessage()); // 2011.07.15
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
        	//중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (ERP 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다.)
            //log.error("err " + ex.toString(), ex);
            otsRcvInfoVO.setTotOtsStsCd("");
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            log.error(ex.getMessage()); // 2011.07.15
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return otsRcvInfoVO;
    }

    /**
     * 부킹번호에 해당하는 컨테이너 목록을 조회한다.
     *
     * @param String bkgNo Booking번호     *
     * @return String[] Container No List
     * @exception EventException
     */
    public String[] searchDemDetCntrList(String bkgNo) throws EventException {
        String[] arrRet;
        try {
            arrRet = dbDao.searchDemDetCntrList(bkgNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return arrRet;
    }
    /**
     * [0909] Original Bill of Lading Status 조회
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return List<UsCgoRlseBlStatusVO>
     * @throws EventException
     */
    public List<UsCgoRlseBlStatusVO>  searchUsCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException{
        List<UsCgoRlseBlStatusVO> usCgoRlseBlStatus = null;

        try {
            usCgoRlseBlStatus = (List<UsCgoRlseBlStatusVO>) dbDao.searchUsCgoRlseBlStatus(bkgNo, account);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return usCgoRlseBlStatus;
    }

    /**
     * [0909] Partial 정보가져오기
     *
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception EventException
     */
    public UsCgoRlseBkbcBlVO searchPrtlBl(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws EventException {

        UsCgoRlseBkbcBlVO uscgoRlseBkbcBL = new UsCgoRlseBkbcBlVO();

        try {
            uscgoRlseBkbcBL = (UsCgoRlseBkbcBlVO) dbDao.searchPrtlBl(usCgoRlseBkbc);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return uscgoRlseBkbcBL;
    }



    /**
     * 두바이 세관 정보 저장 처리<br>
     * 두바이 Manfest 신고정보를 등록한다.<br>
     *
     * @param DubaiCstmsVO[] dubaiCstms
     * @exception EventException
     */

    public void modifyDubaiCstmsRefNo(DubaiCstmsVO[] dubaiCstms ) throws EventException {
    	try {
    		for(int i=0;i<dubaiCstms.length;i++){
    			dbDao.modifyDubaiCstmsRefNo(dubaiCstms[i]);
    		}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

/******************************************************************************************
* Author : Park SungHo End
******************************************************************************************/

/******************************************************************************************
* Author : An JinEung Start
******************************************************************************************/

    /**
     * 삭제 이벤트 처리<br>
     * Cargo Release Order의 Office Default From Setup 삭제 처리<br>
     *
     * @param String office
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeDoForm(String office, SignOnUserAccount account) throws EventException {
        try {
            dbDao.removeDoForm(office, account);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 삭제 이벤트 처리<br>
     * Cargo Release Order_E-D/O inquiry _Main 삭제 처리<br>
     *
     * @param EdoRqstsVO[] edoRqstsVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeEdoErrData(EdoRqstsVO[] edoRqstsVO, SignOnUserAccount account) throws EventException {
        try {
            List<EdoRqstsVO> updateVoList = new ArrayList<EdoRqstsVO>();

            if(null != edoRqstsVO){
                for ( int i=0; i<edoRqstsVO .length; i++ ) {
                    edoRqstsVO[i].setUpdUsrId(account.getUsr_id());
                    updateVoList.add(edoRqstsVO[i]);
                }
            }

            if ( updateVoList.size() > 0 ) {
                dbDao.removeEdoErrData(updateVoList);
            }

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * Cargo Release Order의 Office Default From Setup 정보를 조회한다.<br>
     *
     * @param String office
     * @return List<BkgDoFomVO>
     * @exception EventException
     */
    public List<BkgDoFomVO> searchDoForm(String office) throws EventException {
        try {
            log.debug("BCImpl ==> searchDoForm 호출");
            return dbDao.searchDoForm(office);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * KT-Net으로 들어온 EDI로 들어온 E-DO Application 정보를 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return EdoRqstVO edoRqstVO
     * @exception EventException
     */
    public EdoRqstVO searchEdoByDoRqst(String rqstNo, String tpCd) throws EventException {
        try {
            // 기본 정보를 조회한다.
            EdoRqstVO edoRqstVO = new EdoRqstVO();
            log.debug("===================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("===================================");

            BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
            edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

            if(bkgEdoMstVO != null){
                // BKG_EDO_DO 를 조회한다
                log.debug("========================================================");
                log.debug("    BKG_EDO_DO 를 조회한다.                             ");
                log.debug("========================================================");

                BkgEdoDoVO bkgEdoDoVO = dbDao.searchEdoDo(rqstNo, tpCd);
                edoRqstVO.setBkgEdoDoVO(bkgEdoDoVO);

                // BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)
                log.debug("=================================================");
                log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)    ");
                log.debug("=================================================");

                List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
                edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

            }
            return edoRqstVO;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * KT-Net으로 들어온 EDI로 들어온 In-bond Transportation Application 정보를 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return EdoRqstVO edoRqstVO
     * @exception EventException
     */
    public EdoRqstVO searchEdoByIbdTrspRqst(String rqstNo, String tpCd) throws EventException {
        try {
            // 기본 정보를 조회한다.
            EdoRqstVO edoRqstVO = new EdoRqstVO();
            log.debug("===================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("===================================");

            BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
            edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

            if(bkgEdoMstVO != null){
                // BKG_EDO_DO 를 조회한다
                log.debug("========================================================");
                log.debug("    BKG_EDO_DO 를 조회한다.                             ");
                log.debug("========================================================");

                BkgEdoIbdTrspVO bkgEdoIbdTrspVO = dbDao.searchEdoIbdTrsp(rqstNo, tpCd);
                edoRqstVO.setBkgEdoIbdTrspVO(bkgEdoIbdTrspVO);

                // BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)
                log.debug("=================================================");
                log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)    ");
                log.debug("=================================================");

                List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
                edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

            }
            return edoRqstVO;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * KT-Net으로 들어온 EDI로 들어온 Merchant Haulage Application 정보를 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return EdoRqstVO edoRqstVO
     * @exception EventException
     */
    public EdoRqstVO searchEdoBySelfTrspRqst(String rqstNo, String tpCd) throws EventException {
        try {
            // 기본 정보를 조회한다.
            EdoRqstVO edoRqstVO = new EdoRqstVO();
            log.debug("===================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("===================================");

            BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
            edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

            if(bkgEdoMstVO != null){
                // BKG_EDO_DO 를 조회한다
                log.debug("===============================================================");
                log.debug("    BKG_EDO_SELF_TRSP 를 조회한다.                             ");
                log.debug("===============================================================");

                BkgEdoSelfTrspVO bkgEdoSelfTrspVO = dbDao.searchEdoSelfTrsp(rqstNo, tpCd);
                edoRqstVO.setBkgEdoSelfTrspVO(bkgEdoSelfTrspVO);

                // BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)
                log.debug("=================================================");
                log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)     ");
                log.debug("=================================================");

                List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
                edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

            }

            /*
             * @ CHM-201537319 (주) 한진 전송 운송 정보 표기 요청 -- 남기황  2015.07.28 ~ 2015.09.18
             * 5JM 수신이 안된 데이타가, klnet에서  자가운송으로 변경했을 경우,
             * 컨테이너별 자가운송이 수신 되는데,5JM이 수신 되지않아 자가 운송 정보를 볼 수 없어,
             * 5JM수신 여부와 상관 없이 자가운송 정보 팝업 허용
             * */
            // BKG_EDO_CNTR_PTY_TRSP 를 조회한다.(컨테이너별 자가운송 업체를 조회한다.)
            log.debug("=================================================");
            log.debug("    BKG_EDO_CNTR_PTY_TRSP 를 조회한다.");
            log.debug("=================================================");

            List<SearchEdoCntrPtyTrspVO> bkgEdoCntrPtyTrspVOs = dbDao.searchEdoCntrPtyTrsp(rqstNo);
            edoRqstVO.setBkgEdoCntrPtyTrspVOs(bkgEdoCntrPtyTrspVOs);

            return edoRqstVO;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * (주)한진으로 부터 EDI 수신된, 컨테이너별 자가운송 Party(업체정보)를 조회한다.<br>
     *
     * @param String rqstNo
     * @return List<SearchEdoCntrPtyTrspVO>
     * @exception EventException
     */
    public List<SearchEdoCntrPtyTrspVO> searchEdoCntrPtyTrsp(String rqstNo) throws EventException {
        try {

            /*
             * @ CHM-201537319 (주) 한진 전송 운송 정보 표기 요청 -- 남기황  2015.07.28 ~ 2015.09.18
             * 5JM 수신이 안된 데이타가, klnet에서  자가운송으로 변경했을 경우,
             * 컨테이너별 자가운송이 수신 되는데,5JM이 수신 되지않아 자가 운송 정보를 볼 수 없어,
             * 5JM수신 여부와 상관 없이 자가운송 정보 팝업 허용
             * */

            List<SearchEdoCntrPtyTrspVO> bkgEdoCntrPtyTrspVOs = dbDao.searchEdoCntrPtyTrsp(rqstNo);

            return bkgEdoCntrPtyTrspVOs;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * Cargo Release Order_E-D/O inquiry _Main 화면에 대한 조회 이벤트 처리<br>
     *
     * @param EdoSearchVO edoSearch
     * @return List<EdoRqstsVO>
     * @exception EventException
     */
    public List<EdoRqstsVO> searchEdoRqstList(EdoSearchVO edoSearch) throws EventException {
        try {
            return dbDao.searchEdoRqstList(edoSearch);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * D/O EDI Transmit Log List Inquiry 화면에 대한 조회 이벤트 처리<br>
     *
     * @param String rcvToDt
     * @param String rcvFmDt
     * @param String blNo
     * @return List<BkgEdoLogVO>
     * @exception EventException
     */
    public List<BkgEdoLogVO> searchEdoTransLog(String rcvToDt, String rcvFmDt, String blNo) throws EventException {
        try {
            return dbDao.searchEdoTransLog(rcvToDt, rcvFmDt, blNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 저장 이벤트 처리<br>
     * Cargo Release Order의 Office Default From Setup 저장(입력 또는 수정) 처리<br>
     *
     * @param BkgDoFomVO[] bkgDoFomVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void setupDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account) throws EventException {
        try {
            int resultCnt =0;
            log.debug("=======================================");
            log.debug("    Office Default From Setup 저장시   ");
            log.debug("=======================================");

            resultCnt = dbDao.modifyDoForm(bkgDoFomVOs, account);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    수정된 건수가 없음 신규 생성       ");
                log.debug("=======================================");
                dbDao.addDoForm(bkgDoFomVOs, account);
            }

            log.debug("================================================================================");
            log.debug("    Office Default From Setup Insert 처리를 한다.                               ");
            log.debug("================================================================================");

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 및 Send와 Release를 할 수 있는 Pop-up화면을 조회한다.<br>
     *
     * @param String doNo
     * @param String doNoSplit
     * @return EuDoRcvrVO euDoRcvrVO
     * @exception EventException
     */
    public EuDoRcvrVO searchEuDoRcvrInfo(String doNo, String doNoSplit) throws EventException {
        try {
            // 기본 정보를 조회한다.
            EuDoRcvrVO euDoRcvrVO = new EuDoRcvrVO();

            log.debug("===============================================================");
            log.debug("    Multi Container를 조회한다.                                ");
            log.debug("===============================================================");
            List<DoCntrVO> doCntrVOs = dbDao.searchDoCntrInfo(doNo, doNoSplit);
            euDoRcvrVO.setDoCntrVos(doCntrVOs);

            // BKG_DO 를 조회한다
            log.debug("===============================================================");
            log.debug("    BKG_DO 를 조회한다                                         ");
            log.debug("===============================================================");

            BkgDoVO bkgDoVO = dbDao.searchEuDoRcvrInfo(doNo, doNoSplit);
            euDoRcvrVO.setBkgDoVO(bkgDoVO);

            // BKG_DO 를 조회한다
            log.debug("===============================================================");
            log.debug("    BKG_DO_CNTR을 조회한다                                     ");
            log.debug("===============================================================");

            List<BkgDoCntrVO> bkgDoCntrVOs = dbDao.searchEuDoTruckerInfo(doNo, doNoSplit);
            euDoRcvrVO.setBkgDoCntrVOs(bkgDoCntrVOs);

            return euDoRcvrVO;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 저장 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 저장(입력 또는 수정) 처리<br>
     *
     * @param BkgDoVO[] bkgDoVO
     * @param SignOnUserAccount account
     * @return EventResponse EsmBkg0937EventResponse
     * @exception EventException
     */
    public void setupEuDoRcvrInfo(BkgDoVO[] bkgDoVO, SignOnUserAccount account) throws EventException {
        try {
            int resultCnt =0;
            log.debug("=======================================");
            log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
            log.debug("=======================================");

            resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDoVO, account);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    D/O Receiver 수정된 건수가 없음                ");
                log.debug("=======================================");
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 저장 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 저장(입력 또는 수정) 처리<br>
     *
     * @param BkgDoCntrVO[] bkgDoCntrVOs
     * @param SignOnUserAccount account
     * @return EventResponse EsmBkg0937EventResponse
     * @exception EventException
     */
    public void setupEuDoTruckerInfo(BkgDoCntrVO[] bkgDoCntrVOs, SignOnUserAccount account) throws EventException {
        try {
            int resultCnt =0;

            log.debug("=======================================");
            log.debug("    EU_Cargo Release Order의 Trucker 저장시   ");
            log.debug("=======================================");

            List<BkgDoCntrVO> updateVoList = new ArrayList<BkgDoCntrVO>();

            if(null != bkgDoCntrVOs){
                for ( int i=0; i<bkgDoCntrVOs.length; i++ ) {
                    log.debug("getIbflag : " + bkgDoCntrVOs[i].getIbflag());
                    if ( bkgDoCntrVOs[i].getIbflag().equals("U")){
                        log.debug("getCntrNo : " + bkgDoCntrVOs[i].getCntrNo());

                        bkgDoCntrVOs[i].setUpdUsrId(account.getUsr_id());
                        updateVoList.add(bkgDoCntrVOs[i]);
                    }
                }
            } else {
                log.debug("bkgDoCntrVOs 데이터  Null");
            }

            resultCnt = dbDao.modifyEuDoTruckerInfo(updateVoList, account);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    Trucker 수정된 건수가 없음                             ");
                log.debug("=======================================");
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 메일 전송 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 저장 후 메일 전송 처리<br>
     *
     * @param BkgDoVO[] bkgDo
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO> bkgNtcHisVOs
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendEuDoByEmail(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException {

        CargoReleaseOrderEAIDAO eai = new CargoReleaseOrderEAIDAO();

        try {
            int resultCnt =0;
            log.debug("===================================================");
            log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
            log.debug("===================================================");

            resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDo, account);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    D/O Receiver 수정된 건수가 없음    ");
                log.debug("=======================================");
            }

            log.debug("=======================================");
            log.debug("    searchDoMrdId 조회 Start           ");
            log.debug("=======================================");
            String bl_no  = dbDao.searchBlNo(bkgDo[0].getBkgNo());
            String mrd_id = dbDao.searchDoMrdId(account.getOfc_cd());

            log.debug("    searchDoMrdId 결과 : " + mrd_id );

            log.debug("=======================================");
            log.debug("    sendEuDoByEmail 메일 전송 Start.   ");
            log.debug("=======================================");

            if ("".equals(mrd_id) || mrd_id.isEmpty()) {

                log.debug("=======================================");
                log.debug("    mrd_id의 값이 존재하지 않음        ");
                log.debug("=======================================");

                throw new EventException(new ErrorHandler("BKG40080").getMessage());
            }
            EuDoNtcSendVO euDoNtcSend = new EuDoNtcSendVO();
            euDoNtcSend.setBkgNo(bkgDo[0].getBkgNo());
            euDoNtcSend.setBlNo(bl_no);
            euDoNtcSend.setDoNo(bkgDo[0].getDoNo());
            euDoNtcSend.setDoNoSplit(bkgDo[0].getDoNoSplit());
            euDoNtcSend.setMrdId(mrd_id);
            euDoNtcSend.setNtcEml(bkgDo[0].getRcvrEml());
            euDoNtcSend.setNtcFaxNo(bkgDo[0].getRcvrFaxNo());
            euDoNtcSend.setUsrEml(account.getUsr_eml());
            euDoNtcSend.setUsrId(account.getUsr_id());
            euDoNtcSend.setUsrNm(account.getUsr_nm());
            euDoNtcSend.setOfcCd(account.getOfc_cd());
            euDoNtcSend.setNtcViaCd("E");
            euDoNtcSend.setCreUsrId(account.getUsr_id());
            euDoNtcSend.setUpdUsrId(account.getUsr_id());
            euDoNtcSend.setCustNm(bkgDo[0].getRcvrCneeNm());

            euDoNtcSend.setSndId(eai.sendEuDoByEmail(euDoNtcSend));

            List<BkgNtcHisVO> bkgNtcHisVOs = dbDao.searchEuDoNtcSndHistory(euDoNtcSend);

            // 메일 Copy 정보 조회
			String copyEml = new BookingUtil().searchCcEmailAddrRSQL("EU", account.getUsr_id());

			// 발송인에게 해당  B/L에 대해 메일 Copy 본을 송신함
            if( !StringUtils.isBlank(copyEml) ){
            	euDoNtcSend.setNtcEml(copyEml);
				eai.sendEuDoByEmail(euDoNtcSend);
			}

            return bkgNtcHisVOs;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
    }

    /**
     * FAX 전송 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 저장 후 Fax 전송 처리<br>
     *
     * @param BkgDoVO[] bkgDo
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO> bkgNtcHisVOs
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendEuDoByFax(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException {

        CargoReleaseOrderEAIDAO eai = new CargoReleaseOrderEAIDAO();
		ComUserVO comUserVO = null;

        try {
            int resultCnt =0;
            log.debug("===================================================");
            log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
            log.debug("===================================================");

            resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDo, account);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    D/O Receiver 수정된 건수가 없음    ");
                log.debug("=======================================");
            }

            log.debug("=======================================");
            log.debug("    searchDoMrdId 조회 Start           ");
            log.debug("=======================================");
            String mrd_id = dbDao.searchDoMrdId(account.getOfc_cd());

            log.debug("    searchDoMrdId 결과 : " + mrd_id );

            log.debug("=======================================");
            log.debug("    sendEuDoByFax Fax 전송 Start.      ");
            log.debug("=======================================");

            if ("".equals(mrd_id) || mrd_id.isEmpty()) {
                log.debug("=======================================");
                log.debug("    mrd_id의 값이 존재하지 않음        ");
                log.debug("=======================================");

                throw new EventException(new ErrorHandler("BKG40080").getMessage());
            }
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();

            EuDoNtcSendVO euDoNtcSend = new EuDoNtcSendVO();
            euDoNtcSend.setBkgNo(bkgDo[0].getBkgNo());
            euDoNtcSend.setDoNo(bkgDo[0].getDoNo());
            euDoNtcSend.setDoNoSplit(bkgDo[0].getDoNoSplit());
            euDoNtcSend.setMrdId(mrd_id);
            euDoNtcSend.setNtcEml(bkgDo[0].getRcvrEml());
            euDoNtcSend.setNtcFaxNo(bkgDo[0].getRcvrFaxNo());
//            euDoNtcSend.setUsrEml(account.getUsr_eml());
            euDoNtcSend.setUsrEml(sUsrEml);
            euDoNtcSend.setUsrId(account.getUsr_id());
            euDoNtcSend.setUsrNm(account.getUsr_nm());
            euDoNtcSend.setOfcCd(account.getOfc_cd());
            euDoNtcSend.setNtcViaCd("F");
            euDoNtcSend.setCreUsrId(account.getUsr_id());
            euDoNtcSend.setUpdUsrId(account.getUsr_id());

            euDoNtcSend.setSndId(eai.sendEuDoByFax(euDoNtcSend));

            List<BkgNtcHisVO> bkgNtcHisVOs = dbDao.searchEuDoNtcSndHistory(euDoNtcSend);

            return bkgNtcHisVOs;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00242").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
        }
    }

    /**
     * 0938 조회 이벤트 처리<br>
     * EU D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return EuDoMstVO euDoMst
     * @exception EventException
     */
    public EuDoMstVO searchEuDo(String bkgNo, SignOnUserAccount account)throws EventException {

        EuDoMstVO euDoMst = new EuDoMstVO();

        try {

            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * EU D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            euDoMst.setBlInfo(blInfo);

            if(blInfo != null){

                // EU Cargo 는 POD국가코드를 비교하여, 적합하지 않은 DO 조회조건 발생시 오류를 발생시킨다.
            	//POD RUVVO인 경우 CARGO RELEASE 조회토록 로직 수정 (EU Cargo release menu 조회 불가) - 2015.12.14
                if ("RUVVO".equals(blInfo.getPodCd()) || dbDao.checkEuDoDischLoc(blInfo.getPodCd().substring(0,2)).equals("N")) {
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                }

                /**
                 * EU D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                //doRef 널 값일 경우 Bkg No를 세팅한다. Save 시  PK값 사용
                if(doRef == null){
                    doRef = new BkgDoRefVO();
                    doRef.setBkgNo(blInfo.getBkgNo());
                    euDoMst.setSplitFlg("N");
                }else{
                    euDoMst.setSplitFlg(doRef.getDoSplitFlg());
                }

                euDoMst.setBkgDoRefVO(doRef);

                /**
                 * EU 세관 신고를 위한 B/L INFO를 조회한다.
                 */
                EuCstmsVO euCstms = dbDao.searchEuCstmsInfo(bkgNo);
                euDoMst.setEuCstms(euCstms);

                /**
                 * Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                 */
                List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs = dbDao.searchEuDoRlseStsByCntr(bkgNo);
                euDoMst.setEuDoCntrRlseStsVOs(euDoCntrRlseStsVOs);

                /**
                 * D/O No가 Split Assign되지 않은 Container의 수량을  조회한다.
                 */
                int cntrCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
                euDoMst.setCntrCnt(cntrCnt);

                /**
                 * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 조회
                 */
                List<EuDoRlseStsVO> euDoRlseStss= dbDao.searchEuDoRlseStsByBl(bkgNo);
                euDoMst.setEuDoRlseStsVOs(euDoRlseStss);

                /**
                 * DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회
                 */
                String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);
                if(cntrNo != null){
                    euDoMst.setCntrNo(cntrNo);
                }

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                euDoMst.setBlIss(blIss);

                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(euDoMst.getBlInfo().getBlNo());
                otsRcvInfoVO = this.searchErpOtsInfo(euDoMst.getBlInfo().getBlNo());
                euDoMst.setOtsRcvInfoVO(otsRcvInfoVO);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
                euDoMst.setMrdId(mrdId);
            }
            return euDoMst;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     *
     * @param EuDoSaveVO euDoSave
     * @exception EventException
     */
    public void manageEuDo(EuDoSaveVO euDoSave) throws EventException {
        try {
            int resultCnt =0;

            BkgDoHisVO doHis = new BkgDoHisVO();

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(euDoSave.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }
            if("Y".equals(euDoSave.getOblCngFlg())){

                doHis.setBkgNo(euDoSave.getBkgNo());
                doHis.setCreUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd(euDoSave.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setEvntOfcCd(euDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO bkgDoRef = new BkgDoRefVO();

            bkgDoRef.setBkgNo(euDoSave.getBkgNo());
            //bkgDoRef.setCyOpCd(euDoSave.getCyOpCd());
            //bkgDoRef.setInfoCgoFlg(euDoSave.getInfoCgoFlg());
            bkgDoRef.setInterRmk(euDoSave.getInterRmk());
            bkgDoRef.setCreUsrId(euDoSave.getUserId());
            bkgDoRef.setUpdUsrId(euDoSave.getUserId());
            bkgDoRef.setDoSplitFlg(euDoSave.getDoSplitFlg());
            bkgDoRef.setCstmsRefNm(euDoSave.getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(euDoSave.getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(euDoSave.getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(euDoSave.getCstmsAsgnCtnt());
            bkgDoRef.setDoHldFlg(JSPUtil.getNull(euDoSave.getDoHldFlg(),"N"));

            log.debug("getCstmsRefNm : " + bkgDoRef.getCstmsRefNm());

            resultCnt = dbDao.modifyDoRef(bkgDoRef);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                log.debug("============================");
                log.debug("수정된 건수가 없음 신규 생성");
                log.debug("============================");

                dbDao.addDoRef(bkgDoRef);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param EuDoRlseVO euDoRlse
     * @param DoCntrVO[] doCntrs
     * @exception EventException
     */
    public void releaseEuDo(EuDoRlseVO euDoRlse, DoCntrVO[] doCntrs) throws EventException {
        try {

            //validateDoRelease 호출
            validateDoRelease(euDoRlse.getBkgNo());


            //DO No 채번
            String doNo = null;
            if (euDoRlse.getDoSplitFlg().equals("Y")) {
                doNo = dbDao.searchDoNo(euDoRlse.getBkgNo());
            }

            if (doNo == null || doNo.equals("")) {
                doNo = makeDoNo(euDoRlse.getUsrOfcCd(), euDoRlse.getUsrId());
            }
            euDoRlse.setDoNo(doNo);

            //Split Flg == 'Y'인 경우
            String doNoSplit = "";
            int rlseSeq      = 0;

            //Split 일 경우 체크
            if ("Y".equals(euDoRlse.getDoSplitFlg())) {
                //Bkg No에 해당하는 DO NO SPLIT을 조회한다.
                log.debug("==================================");
                log.debug("searchDoSplitNo - doNoSplit을 채번");
                log.debug("==================================");

                doNoSplit = dbDao.searchDoSplitNo(euDoRlse.getBkgNo(), euDoRlse.getDoNo()); // DO Number를 제공해야 합니다. mgpark

                log.debug("==================================");
                log.debug("searchDoRlseSeq - rlseSeq를 채번");
                log.debug("==================================");
                rlseSeq = dbDao.searchDoRlseSeq(euDoRlse.getBkgNo());

            } else {
                doNoSplit = "00";
                rlseSeq = 1;
            }

            //Value Object 선언
            BkgDoVO bkgDo       = new BkgDoVO();
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            BkgDoDtlVO doDtl    = new BkgDoDtlVO();
            BkgDoHisVO doHis    = new BkgDoHisVO();

            bkgDo.setBkgNo(euDoRlse.getBkgNo());
            bkgDo.setDoNo(doNo);
            bkgDo.setRlseSeq(Integer.toString(rlseSeq));
            bkgDo.setDoNoSplit(doNoSplit);
            bkgDo.setJpDoId("");
            bkgDo.setCgorRmk(euDoRlse.getCgorRmk());
            bkgDo.setCreUsrId(euDoRlse.getUsrId());
            bkgDo.setUpdUsrId(euDoRlse.getUsrId());
            bkgDo.setCustPrnFlg("N");
            bkgDo.setSelfTrnsFlg("N");

            bkgDoRef.setBkgNo(euDoRlse.getBkgNo());

            bkgDoRef.setCstmsRefNm(euDoRlse.getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(euDoRlse.getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(euDoRlse.getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(euDoRlse.getCstmsAsgnCtnt());
            bkgDoRef.setInterRmk(euDoRlse.getInterRmk());
            bkgDoRef.setDoHldFlg(euDoRlse.getDoHldFlg());

            bkgDoRef.setCreUsrId(euDoRlse.getUsrId());
            bkgDoRef.setUpdUsrId(euDoRlse.getUsrId());
            bkgDoRef.setDoSplitFlg(euDoRlse.getDoSplitFlg());

            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            doDtl.setBkgNo(euDoRlse.getBkgNo());
            doDtl.setRlseSeq(Integer.toString(rlseSeq));
            doDtl.setRlseStsCd("R");
            doDtl.setEvntUsrId(euDoRlse.getUsrId());
            doDtl.setEvntOfcCd(euDoRlse.getUsrOfcCd());
            doDtl.setCreUsrId(euDoRlse.getUsrId());
            doDtl.setUpdUsrId(euDoRlse.getUsrId());

            doHis.setBkgNo(euDoRlse.getBkgNo());
            doHis.setCreUsrId(euDoRlse.getUsrId());
            doHis.setUpdUsrId(euDoRlse.getUsrId());
            doHis.setDoCngEvntCd("RE"); //Release
            doHis.setPreCtnt("");
            doHis.setCrntCtnt(euDoRlse.getDoNo());
            doHis.setEvntUsrId(euDoRlse.getUsrId());
            doHis.setEvntOfcCd(euDoRlse.getUsrOfcCd());

            //manageDo 호출
            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

            //Split 일 경우 체크
            if ("Y".equals(euDoRlse.getDoSplitFlg())) {

                log.debug("=======================================");
                log.debug(""+doCntrs.length+"건 만큼 For Loop 실행");
                log.debug("=======================================");

                for(int i=0;i<doCntrs.length;i++){
                    log.debug("==================================");
                    log.debug("addDoRlseByCntr 호출 " + i + "건");
                    log.debug("==================================");

                    doCntrs[i].setRlseSeq(Integer.toString(rlseSeq));
                    doCntrs[i].setCreUsrId(euDoRlse.getUsrId());
                    doCntrs[i].setUpdUsrId(euDoRlse.getUsrId());

                    dbDao.addDoRlseByCntr(doCntrs[i]);
                }
            } else {
                log.debug("==================================");
                log.debug("addDoRlseByBl 호출 : " + Integer.toString(rlseSeq));
                log.debug("==================================");

                dbDao.addDoRlseByBl(euDoRlse.getBkgNo(), Integer.toString(rlseSeq), euDoRlse.getUsrId());
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0938 EU D/O를 Cancel 한다.<br>
     *
     * @param DoCancelVO doCancel
     * @exception EventException
     * @author An Jineung
     */
    public void cancelEuDo(DoCancelVO doCancel) throws EventException {
        try {
            this.cancelDo(doCancel);
            dbDao.removeDoCntr(doCancel.getBkgNo(), doCancel.getRlseSeq());

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 1035 CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 조회한다.<br>
     *
     * @param String bkgNo
     * @return BkgDoVO
     * @exception EventException
     * @author An Jineung
     */
    public BkgDoVO searchVetnamPrnCd(String bkgNo) throws EventException {
        try {
            return dbDao.searchVetnamPrnCd(bkgNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 저장 이벤트 처리<br>
     * CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 저장한다.<br>
     *
     * @param String doNo
     * @param String doNoSplit
     * @param String vnCgoDeCd
     * @param SignOnUserAccount account
     * @return EventResponse EsmBkg1035EventResponse
     * @exception EventException
     */
    public void setupVetnamPrnCd(String bkgNo, String rlseSeq, String vnCgoDeCd, String usrId) throws EventException {
        try {
            int resultCnt =0;

            resultCnt = dbDao.modifyVetnamPrnCd(bkgNo, rlseSeq, vnCgoDeCd, usrId);

            if ( resultCnt == 0 ) {
                log.debug("=======================================");
                log.debug("    수정된 건수가 없음                ");
                log.debug("=======================================");
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * 0128 조회 이벤트 처리<br>
     * D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param bkgNo
     * @param SignOnUserAccount account
     * @return DoMstVO doMst
     * @exception EventException
     */
    public DoMstVO searchGenDo(String bkgNo, SignOnUserAccount account)throws EventException {

        DoMstVO doMst = new DoMstVO();

        try {
            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            doMst.setBlInfo(blInfo);

            /* GenDoBlInfoVO 관련 사항(2010.02.08) */
            GenDoBlInfoVO genBlInfo = new GenDoBlInfoVO();

            if(blInfo != null){

            	// Gen Cargo 는 POD국가코드를 비교하여, 적합하지 않은 DO 조회조건 발생시 오류를 발생시킨다.
            	//POD RUVVO인 경우 CARGO RELEASE 조회토록 로직 수정 (EU Cargo release menu 조회 불가) - 2015.12.14
                if (!"RUVVO".equals(blInfo.getPodCd()) && dbDao.checkGenDoDischLoc(blInfo.getPodCd().substring(0,2)).equals("N")) {
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                }

                /**
                 * D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                //doRef 널 값일 경우 Bkg No를 세팅한다. Save 시  PK값 사용
                if(doRef == null){
                    doRef = new BkgDoRefVO();
                    doRef.setBkgNo(blInfo.getBkgNo());

                	if("SG".equals(account.getCnt_cd())) {
                    doRef.setCstmsRefNm("UEN  No.");
                               doRef.setCstmsAsgnNm("CR No.");
                    } else {
                               doRef.setCstmsRefNm("Customs Ref. No.");
                               doRef.setCstmsAsgnNm("Customs Ref. No.");

                    }
                }

                doMst.setBkgDoRefVO(doRef);

                /**
                 * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                 */
                List<DoRlseStsVO> doRlseStsVOs = dbDao.searchDoRlseSts(bkgNo);
                doMst.setDoRlseStsVOs(doRlseStsVOs);

                /**
                 * DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회
                 */
                String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);
                if(cntrNo != null){
                    doMst.setCntrNo(cntrNo);
                }

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                doMst.setBlIss(blIss);


                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(doMst.getBlInfo().getBlNo());
                otsRcvInfoVO = this.searchErpOtsInfo(doMst.getBlInfo().getBlNo());

                doMst.setOtsRcvInfoVO(otsRcvInfoVO);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
                // mrdID를 &^^& 로 Split 한다.(안진응)
                doMst.setMrdId(mrdId);


                // 성능이슈 관련(2010.02.08)
                // blInfo 데이터를 genBlInfo에 Merge한다. (2010.02.08)
            	ObjectCloner.build(blInfo, genBlInfo);
                // doRef 데이터를 genBlInfo에 Merge한다. (2010.02.08)
            	ObjectCloner.build(doRef, genBlInfo);
                if(blIss != null){
                    // blIss 데이터를 genBlInfo에 Merge한다. (2010.02.08)
                	ObjectCloner.build(blIss, genBlInfo);
                }
                if(otsRcvInfoVO != null){
                    // otsRcvInfoVO 데이터를 genBlInfo에 Merge한다. (2010.02.08)
                	ObjectCloner.build(otsRcvInfoVO, genBlInfo);
                }

            	doMst.setGenBlInfo(genBlInfo);
            }
            return doMst;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0128 D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     *
     * @param DoSaveVO doSave
     * @exception EventException
     */
    public void manageGenDo(DoSaveVO doSave) throws EventException {
        try {
            int resultCnt =0;

            BkgDoHisVO doHis = new BkgDoHisVO();

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(doSave.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }

            if("Y".equals(doSave.getOblCngFlg())){

                doHis.setBkgNo(doSave.getBkgNo());
                doHis.setCreUsrId(doSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(doSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd(doSave.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(doSave.getAcount().getUsr_id());
                doHis.setEvntOfcCd(doSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO bkgDoRef = new BkgDoRefVO();

            bkgDoRef.setBkgNo(doSave.getBkgNo());
            bkgDoRef.setInterRmk(doSave.getInterRmk());
            bkgDoRef.setCreUsrId(doSave.getUserId());
            bkgDoRef.setUpdUsrId(doSave.getUserId());
            bkgDoRef.setDoSplitFlg(doSave.getDoSplitFlg());
            bkgDoRef.setCstmsRefNm(doSave.getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(doSave.getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(doSave.getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(doSave.getCstmsAsgnCtnt());
            bkgDoRef.setDoHldFlg(JSPUtil.getNull(doSave.getDoHldFlg(),"N"));
            bkgDoRef.setDoVtyDt(doSave.getDoVtyDt());

            //BKG_DO_REF 테이블 신규컬럼
            bkgDoRef.setAttrCtnt1(doSave.getAttrCtnt1());
            bkgDoRef.setAttrCtnt2(doSave.getAttrCtnt2());
            bkgDoRef.setAttrCtnt3(doSave.getAttrCtnt3());
            bkgDoRef.setAttrCtnt4(doSave.getAttrCtnt4());
            bkgDoRef.setAttrCtnt5(doSave.getAttrCtnt5());
            bkgDoRef.setAttrCtnt6(doSave.getAttrCtnt6());

            log.debug("getCstmsRefNm : " + bkgDoRef.getCstmsRefNm());

           BkgAeDoVtyDtHisVO bkgAeDoVtyDtHisVO = new BkgAeDoVtyDtHisVO();

            //do validity upto 칼럼이 바뀔때만 History 저장된다.
          if("Y".equals(doSave.getVtyCngFlg())){
              bkgAeDoVtyDtHisVO.setBkgNo(doSave.getBkgNo());
              bkgAeDoVtyDtHisVO.setDoVtyDt(doSave.getDoVtyDt());
              bkgAeDoVtyDtHisVO.setCreUsrId(doSave.getUserId());
              bkgAeDoVtyDtHisVO.setUpdUsrId(doSave.getUserId());

  			dbDao.addAEDoVTYDtHis(bkgAeDoVtyDtHisVO);
            }

            resultCnt = dbDao.modifyDoRef(bkgDoRef);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                dbDao.addDoRef(bkgDoRef);
            }

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0292 조회 이벤트 처리<br>
     * D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return DoMstVO doMst
     * @exception EventException
     */
    public DoMstVO searchDo(String bkgNo, SignOnUserAccount account)throws EventException {

        DoMstVO doMst = new DoMstVO();

        try {
            log.debug("===================================");
            log.debug("8. Booking의 Actual Staus 를 조회한다. (9, 10번 포함)");
            log.debug("===================================");
            //F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
            validateBkgSts(bkgNo);

            // EU D/O Release를 위한 기본 정보를 조회한다.
            log.debug("=======================================");
            log.debug("12. D/O Release를 위한 기본 정보 조회");
            log.debug("=======================================");

            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            doMst.setBlInfo(blInfo);

            /* GenDoBlInfoVO 관련 사항(2010.02.11) */
            GenDoBlInfoVO genBlInfo = new GenDoBlInfoVO();

            if(blInfo != null){

                // EU D/O Release를 위한 기본 Reference정보를 조회한다.
                log.debug("=================================================");
                log.debug("13. D/O Release를 위한 기본 Reference 정보 조회");
                log.debug("=================================================");

                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);
                doMst.setBkgDoRefVO(doRef);


                //16. splitFlg == "Y"인지 체크한다.
                if(null != doRef){
                    doMst.setSplitFlg(doRef.getDoSplitFlg());
                } else {
                    doMst.setSplitFlg("N");
                }

                // B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                log.debug("===========================================================");
                log.debug("20. B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 조회");
                log.debug("===========================================================");

                List<DoRlseStsVO> doRlseStss= dbDao.searchDoRlseStsByBl(bkgNo);
                doMst.setDoRlseStsVOs(doRlseStss);

                log.debug("==================================");
                log.debug("17. Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.");
                log.debug("==================================");

                List<DoCntrRlseStsVO> doCntrRlseStsVOs = dbDao.searchDoRlseStsByCntr(bkgNo);
                doMst.setDoCntrRlseStsVOs(doCntrRlseStsVOs);

                log.debug("================================================================");
                log.debug("21. DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회");
                log.debug("================================================================");
                String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);

                if(cntrNo != null){
                    doMst.setCntrNo(cntrNo);
                }

                log.debug("=================================================================================");
                log.debug("22. 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail정보를 조회한다.");
                log.debug("=================================================================================");
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                doMst.setBlIss(blIss);

                log.debug("=================================================================");
                log.debug("11. 운임 결재 여부와 Outstanding Amounts 조회를 위한 Office 정보 조회");
                log.debug("=================================================================");

                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                log.debug("ERP I/F를 위한 EAIDAO 호출");
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(doMst.getBlInfo().getBlNo());
                otsRcvInfoVO = this.searchErpOtsInfo(doMst.getBlInfo().getBlNo());
                doMst.setOtsRcvInfoVO(otsRcvInfoVO);

                // 2010.02.11 CargoRelease 성능 이슈 관련
                // blInfo 데이터를 genBlInfo에 Merge한다. (2010.02.08)
            	ObjectCloner.build(blInfo, genBlInfo);

                // doRef 데이터를 genBlInfo에 Merge한다. (2010.02.08)
            	if(doRef != null){
            		ObjectCloner.build(doRef, genBlInfo);
            	}
                if(blIss != null){
                    // blIss 데이터를 genBlInfo에 Merge한다. (2010.02.08)
                	ObjectCloner.build(blIss, genBlInfo);
                }
                if(otsRcvInfoVO != null){
                    // otsRcvInfoVO 데이터를 genBlInfo에 Merge한다. (2010.02.08)
                	ObjectCloner.build(otsRcvInfoVO, genBlInfo);
                }

            	doMst.setGenBlInfo(genBlInfo);
            }
            return doMst;
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0292 Cargo Release Remark 저장 이벤트 처리<br>
     * D/O No  D/O Print & Receipt Print Preview시 Remark정보를 Setting한다.<br>
     *
     * @param BkgDoRefVO bkgDoRef
     * @exception EventException
     */
    public void manageDoHldRmk(BkgDoRefVO bkgDoRef) throws EventException {
        try {
            int resultCnt =0;

            resultCnt = dbDao.mergeDoRef(bkgDoRef);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                log.debug("============================");
                log.debug("처리된 건수가 없음");
                log.debug("============================");
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param DoRlseVO  doRlse
     * @exception EventException
     */
    public void releaseGenDo(DoRlseVO doRlse) throws EventException {
        try {
            validateDoRelease(doRlse.getBkgNo());

            // DO No를 채번 한다.
            log.debug("==================================");
            log.debug("makeDoNo - DO No를 채번 한다.");
            log.debug("==================================");
            String doNo = dbDao.searchDoNo(doRlse.getBkgNo());

            if (doNo == null || doNo.equals("")) {
                doNo = makeDoNo(doRlse.getAcount().getOfc_cd(), doRlse.getAcount().getUsr_id());
            }
            doRlse.setDoNo(doNo);

            // Split Flg == 'Y'인 경우
            String doNoSplit = "";
            int rlseSeq = 0;
            doNoSplit = "00";
            rlseSeq = 1;

            // Value Object 선언
            BkgDoVO bkgDo = new BkgDoVO();
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            BkgDoDtlVO doDtl = new BkgDoDtlVO();
            BkgDoHisVO doHis = new BkgDoHisVO();

            bkgDo.setBkgNo(doRlse.getBkgNo());
            bkgDo.setDoNo(doNo);
            bkgDo.setRlseSeq(Integer.toString(rlseSeq));
            bkgDo.setDoNoSplit(doNoSplit);
            bkgDo.setCgorRmk(doRlse.getCgorRmk());
            bkgDo.setCreUsrId(doRlse.getAcount().getUsr_id());
            bkgDo.setUpdUsrId(doRlse.getAcount().getUsr_id());
            bkgDo.setCustPrnFlg("N");
            bkgDo.setSelfTrnsFlg("N");
            bkgDo.setLginCntCd(doRlse.getAcount().getCnt_cd());

            bkgDoRef.setBkgNo(doRlse.getGenBlInfos().getBkgNo());
            bkgDoRef.setCstmsRefNm(doRlse.getGenBlInfos().getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(doRlse.getGenBlInfos().getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(doRlse.getGenBlInfos().getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(doRlse.getGenBlInfos().getCstmsAsgnCtnt());
            bkgDoRef.setInterRmk(doRlse.getGenBlInfos().getInterRmk());
            bkgDoRef.setDoHldFlg(doRlse.getGenBlInfos().getDoHldFlg());
            bkgDoRef.setCreUsrId(doRlse.getAcount().getUsr_id());
            bkgDoRef.setUpdUsrId(doRlse.getAcount().getUsr_id());
            bkgDoRef.setDoSplitFlg(JSPUtil.getNull(doRlse.getGenBlInfos().getDoSplitFlg(),"N"));


            /*****************************************
                DO RELEASE STATUS CODE
            ******************************************
            AS  Assigned
            CR  Cancelled O/BL Received
            DC  DOR Cancel
            DF  DOR I/F
            DT  DOR Transmit
            HC  Cancelled Cargo Hold
            PD  Printed D/O
            RB  Received O. B/L
            RE  Released
            RI  Received In bond Doc
            RO  Received Other Doc
            RR  Remark for Release
            SF  Sent Fax/E-Mail
            XX  Canceled

            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            doDtl.setBkgNo(doRlse.getBkgNo());
            doDtl.setRlseSeq(Integer.toString(rlseSeq));
            doDtl.setRlseStsCd("R");
            doDtl.setEvntUsrId(doRlse.getAcount().getUsr_id());
            doDtl.setEvntOfcCd(doRlse.getAcount().getOfc_cd());
            doDtl.setCreUsrId(doRlse.getAcount().getUsr_id());
            doDtl.setUpdUsrId(doRlse.getAcount().getUsr_id());

            doHis.setBkgNo(doRlse.getBkgNo());
            doHis.setCreUsrId(doRlse.getAcount().getUsr_id());
            doHis.setUpdUsrId(doRlse.getAcount().getUsr_id());
            doHis.setDoCngEvntCd("RE"); // Release
            doHis.setPreCtnt("");
            doHis.setCrntCtnt(doRlse.getDoNo());
            doHis.setEvntUsrId(doRlse.getAcount().getUsr_id());
            doHis.setEvntOfcCd(doRlse.getAcount().getOfc_cd());

            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

/******************************************************************************************
* Author : Park Mangeon Start
******************************************************************************************/
    /**
     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 조회한다.<br>
     * @param String doNo
     * @param String doNoSplit
     * @return DoRcvrVO
     * @exception EventException
     * @author Park Mangeon
     */
    public DoRcvrVO searchIdaDoRcvrInfo(String doNo, String doNoSplit) throws EventException {
        try {
            return dbDao.searchIdaDoRcvrInfo(doNo, doNoSplit);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 수정한다.<br>
     * @param DoRcvrVO doRcvr
     * @param SignOnUserAccount account
     * @exception EventException
     * @author Park Mangeon
     */
    public void setupIdaDoRcvrInfo(DoRcvrVO doRcvr, SignOnUserAccount account) throws EventException {
        try {
            dbDao.setupIdaDoRcvrInfo(doRcvr, account);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0694 - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
     * Japan Cargo Release Report를 조회한다.<br>
     * @param JapDoHisSearchVO japDoHisSearch
     * @return List<JapDoHisListVO>
     * @exception EventException
     * @author Park Mangeon
     */
    public List<JapDoHisListVO> searchJapDoHistory(JapDoHisSearchVO japDoHisSearch) throws EventException {
        try {
            return dbDao.searchJapDoHistory(japDoHisSearch);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0131 Cargo Release Order List Check Report<br>
     * do check list조회를 수행한다.<br>
     * @param DoCheckListSearchVO checkListSearch
     * @return DoPfmsVO
     * @exception EventException
     * @author Park Mangeon
     */
    public DoPfmsVO searchDoCheckReport (DoCheckListSearchVO checkListSearch) throws EventException{
    	DoPfmsVO doPfmsVO = null;
    	try {
    		doPfmsVO = new DoPfmsVO();
           // return dbDao.searchDoCheckReport(checkListSearch);
    		doPfmsVO.setDoCheckListVOs(dbDao.searchDoCheckReport(checkListSearch));
    		doPfmsVO.setDoCheckListSummaryVO(dbDao.searchDoCheckReportSummary(checkListSearch));

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    	return doPfmsVO;
    }

    /**
     * UI-BKG-0939 India Cargo Release Order list Inquery<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 Weekly별로 조회한다.<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 조회한다.<br>
     * @param IdaDoRlseSearchVO idaDoRlseSearch
     * @return IdaDoRlseReportVO
     * @exception EventException
     * @author Park Mangeon
     */
    public IdaDoRlseReportVO searchIdaDoRlseReport (IdaDoRlseSearchVO idaDoRlseSearch) throws EventException {
        IdaDoRlseReportVO idaDoRlseReport = new IdaDoRlseReportVO();
        try {
            idaDoRlseReport.setIdaDoWeeklyReportVO(dbDao.searchIdaDoRlseWeeklyReport(idaDoRlseSearch));
            idaDoRlseReport.setIdaDoRlseListVO(dbDao.searchIdaDoRlseList(idaDoRlseSearch));
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return idaDoRlseReport;
    }

    /**
     * 조회 이벤트 처리<br>
     * India D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     * @param String bkgNo  선적예약 요청 번호
     * @param SignOnUserAccount account
     * @return IdaDoMstVO
     * @exception EventException
     * @author Park Mangeon
     */
    public IdaDoMstVO searchIdaDo(String bkgNo, SignOnUserAccount account) throws EventException {

        IdaDoMstVO doMst = new IdaDoMstVO();

        try {

            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * India D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);   // 11
            doMst.setDoBlInfoVO(blInfo);

            if(blInfo != null){
                // sequence 12 added delivery code를 기준으로 국가코드가 IN이 아닌경우 Exception BKG40091 발생
                if(!blInfo.getDelCd().substring(0,2).equals("IN")) {  // 12
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                }

                /**
                 * Container 기반으로 DO Release정보를 조회
                 */
                List<IdaDoCntrRlseStsVO> idaDoCntrRlseStsVOList = dbDao.searchIdaDoRlseStsByCntr(bkgNo);
                doMst.setIdaDoCntrRlseStsVOList(idaDoCntrRlseStsVOList);

                int remainCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
                doMst.setRemainCnt(remainCnt);

                /**
                 * BL 기반으로 DO Release정보를 조회
                 */
                List<IdaDoRlseStsVO> idaDoRlseStsVOList = dbDao.searchIdaDoRlseStsByBl(bkgNo);
                doMst.setIdaDoRlseStsVOList(idaDoRlseStsVOList);

                /**
                 * 인도세관 신고를 위한 B/L INFO 조회한다.
                 */
                IdaCstmsVO idaCstmsVO = dbDao.searchIdaCstmsInfo(bkgNo);  // 15
                doMst.setIdaCstmsVO(idaCstmsVO);

                /**
                 * D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                // IGM, Line번호는 인도세관 정보 조회시 검사한 정보를 우선으로 사용한다.
                // 따라서, doRef가 없을 경우에는 하나 생성하여 데이터를 등록한다.
                if (doRef == null) {
                    doRef = new BkgDoRefVO();
                    doRef.setBkgNo(bkgNo);
                    doRef.setDoSplitFlg("N");
                    doRef.setDoHldFlg("N");
                }
                doRef.setIdaImpGenMfNo(idaCstmsVO.getIdaImpGenMfNo());
                doRef.setIdaCgorOrdYr(idaCstmsVO.getIdaCgorOrdYr());
                doRef.setIdaCstmsAsgnLineNo(idaCstmsVO.getIdaCstmsAsgnLineNo());

                doMst.setBkgDoRefVO(doRef);

                /**
                 * DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회
                 */
                String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);  // 19
                doMst.setCntrNoList(cntrNo);

                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(doMst.getDoBlInfoVO().getBlNo());  // 13
                otsRcvInfoVO = this.searchErpOtsInfo(doMst.getDoBlInfoVO().getBlNo());  // 13
                doMst.setOtsRcvInfoVO(otsRcvInfoVO);

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                doMst.setBkgBlIssVO(blIss);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());  // 21
                // mrdID를 &^^& 로 Split 한다.(안진응)
                doMst.setMrdId(mrdId);
            }
            return doMst;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0680 India Cargo Releass<br>
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
     * @param IdaDoSaveVO idaDoSaveVO
     * @exception EventException
     * @author Park Mangeon
     */
    public void manageIdaDo(IdaDoSaveVO idaDoSaveVO) throws EventException {
        try {

            BkgDoHisVO doHis = new BkgDoHisVO();

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(idaDoSaveVO.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }
            if("Y".equals(idaDoSaveVO.getOblCngFlg())){

                doHis.setBkgNo(idaDoSaveVO.getBkgNo());
                doHis.setCreUsrId(idaDoSaveVO.getUsrId());
                doHis.setUpdUsrId(idaDoSaveVO.getUsrId());
                doHis.setDoCngEvntCd(idaDoSaveVO.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(idaDoSaveVO.getUsrId());
                doHis.setEvntOfcCd(idaDoSaveVO.getOfcCd());

                dbDao.addDoHistory(doHis);
            }

            int resultCnt =0;

            BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();
            ObjectCloner.build(idaDoSaveVO, bkgDoRefVO);
            bkgDoRefVO.setUpdUsrId(idaDoSaveVO.getUsrId());
            bkgDoRefVO.setDoSplitFlg(idaDoSaveVO.getDoSplitFlg());
            resultCnt = dbDao.modifyDoRef(bkgDoRefVO);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                bkgDoRefVO.setCreUsrId(idaDoSaveVO.getUsrId());
                dbDao.addDoRef(bkgDoRefVO);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0680 DO Release 이벤트 처리<br>
     * India D/O 발행 을 처리한다.<br>
     * @param IdaDoRlseVO idaDoRlse
     * @param DoCntrVO[] doCntrs
     * @param SignOnUserAccount account
     * @exception EventException
     * @author Park Mangeon
     */
    public void releaseIdaDo(IdaDoRlseVO idaDoRlse, DoCntrVO[] doCntrs, SignOnUserAccount account) throws EventException{
        try {
            validateDoRelease(idaDoRlse.getBkgNo());

            String doNo = null;
            if (idaDoRlse.getDoSplitFlg().equals("Y")) {
                doNo = dbDao.searchDoNo(idaDoRlse.getBkgNo());
            }

            if (doNo == null || doNo.equals("")) {
                doNo = makeDoNo(account.getOfc_cd(), account.getUsr_id());
            }

            idaDoRlse.setDoNo(doNo);

            // 4. split_flg == Y
            // 4.1. searchDoSplitNo(bkgNo)
            if (idaDoRlse.getDoSplitFlg().equals("Y")) {
                String doNoSplit = dbDao.searchDoSplitNo(idaDoRlse.getBkgNo(), idaDoRlse.getDoNo()); // doNo
                idaDoRlse.setDoNoSplit(doNoSplit);
            } else {
                idaDoRlse.setDoNoSplit("00");
            }

            // 5. searchDoRlseSeq()
            String rlseSeq = Integer.toString(dbDao.searchDoRlseSeq(idaDoRlse.getBkgNo()));
            idaDoRlse.setRlseSeq(rlseSeq);

            //6.1 searchIdaDoRcvInfoForCopy (bkgNo)


            //6. manageDo(bkgDo, bkgDoRef, doDtl, doHis)
            BkgDoVO bkgDo = new BkgDoVO();
            ObjectCloner.build(idaDoRlse, bkgDo);

            //6.1 searchIdaDoRcvInfoForCopy (bkgNo)
/*
            DoRcvrVO doRcvr = dbDao.searchIdaDoRcvInfoForCopy(idaDoRlse.getBkgNo());

            if(doRcvr != null) {
	            bkgDo.setHblNo(doRcvr.getHblNo());
	            bkgDo.setRcvrCneeNm(doRcvr.getRcvrCneeNm());
	            bkgDo.setRcvrCoNm(doRcvr.getRcvrCoNm());
	            bkgDo.setRcvrPhnNo(doRcvr.getRcvrPhnNo());
	            bkgDo.setPicNm(doRcvr.getPicNm());
	            bkgDo.setRcvrEml(doRcvr.getRcvrEml());
	            bkgDo.setRcvrFaxNo(doRcvr.getRcvrFaxNo());

            }
*/

            //2010-09-10 최도순 [CLT-100910046] 인도지역 D/O Extension(2)
            IdaDoRlseInfoForCopyVO idaDoRlseInfoForCopyVo = dbDao.searchIdaDoRlseInfoForCopy(idaDoRlse.getBkgNo());

            if(idaDoRlseInfoForCopyVo != null) {
                bkgDo.setHblNo(idaDoRlseInfoForCopyVo .getHblNo());
                bkgDo.setRcvrCneeNm(idaDoRlseInfoForCopyVo .getRcvrCneeNm());
                bkgDo.setRcvrCoNm(idaDoRlseInfoForCopyVo .getRcvrCoNm());
                bkgDo.setRcvrPhnNo(idaDoRlseInfoForCopyVo .getRcvrPhnNo());
                bkgDo.setPicNm(idaDoRlseInfoForCopyVo .getPicNm());
                bkgDo.setRcvrEml(idaDoRlseInfoForCopyVo .getRcvrEml());
                bkgDo.setCfsEml(idaDoRlseInfoForCopyVo  .getCfsEml());
                bkgDo.setMtyYdEml(idaDoRlseInfoForCopyVo .getMtyYdEml());
                bkgDo.setRcvrFaxNo(idaDoRlseInfoForCopyVo .getRcvrFaxNo());
                bkgDo.setDoPrnRmk(idaDoRlseInfoForCopyVo .getDoPrnRmk());
            }

            bkgDo.setCustPrnFlg("N");  // default NN이라 입력
            bkgDo.setSelfTrnsFlg("N"); // default NN이라 입력


            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            ObjectCloner.build(idaDoRlse, bkgDoRef);

            BkgDoDtlVO doDtl = new BkgDoDtlVO();
            ObjectCloner.build(idaDoRlse, doDtl);
            doDtl.setEvntUsrId(idaDoRlse.getUpdUsrId());
            doDtl.setRlseStsCd("R"); // Release
            doDtl.setRlseStsSeq("1");

            BkgDoHisVO doHis = new BkgDoHisVO();
            ObjectCloner.build(idaDoRlse, doHis);

            //2009-11-23 윤윤한 수석 CrntCtnt에 Do No 세팅
            doHis.setPreCtnt("");
            if (idaDoRlse.getDoNoSplit() != null && Integer.parseInt(idaDoRlse.getDoNoSplit()) > 0) {
                // 20091125 mgpark Split일 경우 Split 번호를 포함하여 history를 생성한다.
                doHis.setCrntCtnt((new StringBuffer()).append(idaDoRlse.getDoNo()).append(idaDoRlse.getDoNoSplit()).toString());
            } else {
                doHis.setCrntCtnt(idaDoRlse.getDoNo());
            }

            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

            // 7. if (split_flg==Y)
            // 7.1. for [doCntr]
            // 7.1.1. addDoRlseByCntr(doCntr)
            // 7. else (split_flg==N)
            // 7.2. addDoRlseByBl
            if (idaDoRlse.getDoSplitFlg().equals("Y")) {
                for (int idx = 0; idx < doCntrs.length; idx ++ ){
                    doCntrs[idx].setRlseSeq(rlseSeq);
                    doCntrs[idx].setCreUsrId(account.getUsr_id());
                    doCntrs[idx].setUpdUsrId(account.getUsr_id());
                    dbDao.addDoRlseByCntr(doCntrs[idx]);
                }
            } else {
                dbDao.addDoRlseByBl(idaDoRlse.getBkgNo(), idaDoRlse.getRlseSeq(), idaDoRlse.getCreUsrId());
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0923 Inbound Cargo Release for POD Office_Popup History
     * 미주 Inboud Cargo Release B/L에 대한 History 조회
     * @param String blNo
     * @return List<UsCgoRlseHisVO>
     * @exception EventException
     * @author Park Mangeon
     */
    public List<UsCgoRlseHisVO> searchUsCgoRlseHis(String blNo) throws EventException{
        try {
            return dbDao.searchUsCgoRlseHis(blNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
/******************************************************************************************
* Author : Park Mangeon End
******************************************************************************************/

/******************************************************************************************
* Author : Son YunSeuk Start
******************************************************************************************/
    /**
     * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
     * @param String doNo
     * @param SignOnUserAccount account
     * @return DoPrnRmkVO
     * @exception EventException
     * @author Son YunSeuk
     */
    public List<DoPrnRmkVO> searchDoPrnRmk(String doNo, SignOnUserAccount account) throws EventException{
        List<DoPrnRmkVO> doPrnRmkVOs = null;
        try{
        	doPrnRmkVOs = dbDao.searchDoPrnRmk(doNo, account);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return doPrnRmkVOs;
    }

    /**
     * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
     * @param DoPrnRmkVO doPrnRmkVO
     * @param SignOnUserAccount account
     * @exception EventException
     * @author Son YunSeuk
     */
    public void modifyDoPrnRmk(DoPrnRmkVO doPrnRmkVO, SignOnUserAccount account) throws EventException{
        try{
            dbDao.modifyDoPrnRmk(doPrnRmkVO, account);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0272 Full CNTR Release Order<br>
     * @param FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch
     * @return List<FullCntrRlseOrdVO>
     * @exception EventException
     * @author Son YunSeuk
     */
    public List<FullCntrRlseOrdVO> searchFullCntrRlseOrderList(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch) throws EventException{
        List<FullCntrRlseOrdVO> list = null;
        try{
            list = dbDao.searchFullCntrRlseOrderList(fullCntrRlseOrderSearch);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return list;
    }

    /**
     * SendEmail<br>
     * Full Container Order 화면에서 메일을 발송한다<br>
     * @param FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs
     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVOs
     * @param SignOnUserAccount account
     * @param String diffStr
     * @exception EventException
     */
    public void sendEmailFullCntrRlseOrder(FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs, FullCntrRlseOrdVO[] fullCntrRlseOrdVOs, SignOnUserAccount account, String diffStr ) throws EventException{

    	List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos = null;
    	BkgFullCgoRlseOrdVO       bkgFullCgoRlseOrdVo  = null;
    	try{
        	/*   Validation Logic 체크 제거 요청( Help Desk)
            isYd =  dbDao.checkYardValid(fullCntrRlseOrderMailSend.getYdCd());

            if("N".equals(isYd)){
                throw new EventException(new ErrorHandler("BKG04015",new String[]{fullCntrRlseOrderMailSend.getYdCd(),"Email"}).getMessage());
            }
             */
            // SEND EMAIL

    		String emlSndId = null;

    		// 메일 Copy 정보 조회
			String copyEml = new BookingUtil().searchCcEmailAddrRSQL("FR", account.getUsr_id());

    		for(int i=0;i<fullCntrRlseOrderMailSendVOs.length;i++){
    			String[] rcvAddr = StringUtils.split(fullCntrRlseOrderMailSendVOs[i].getRecipient(), ";");

                for(int j=0; j < rcvAddr.length ; j ++) {
					if(rcvAddr[j] == null) {
					    throw new EventException(new ErrorHandler("BKG00366").getMessage());
					}

	            	fullCntrRlseOrderMailSendVOs[i].setRecipient(rcvAddr[j]);
	                String tempStr = fullCntrRlseOrderMailSendVOs[i].getContent();
		            fullCntrRlseOrderMailSendVOs[i].setContent(tempStr.replaceAll("\r\n", "<br>").replaceAll(" ", "&nbsp;"));
		            emlSndId = eaiDbDao.sendEmailByFullCntrReleaseOrder(fullCntrRlseOrderMailSendVOs[i], account);

		            // 전송 ID 저장
		            fullCntrRlseOrderMailSendVOs[i].setNtcSndId(emlSndId);

	            }
                // 발송인에게 해당  B/L에 대해 메일 Copy 본을 송신함
	            if( !StringUtils.isBlank(copyEml) ){
					fullCntrRlseOrderMailSendVOs[i].setRecipient(copyEml);
					eaiDbDao.sendEmailByFullCntrReleaseOrder(fullCntrRlseOrderMailSendVOs[i], account);
				}
    		}

    		bkgFullCgoRlseOrdVos = new ArrayList<BkgFullCgoRlseOrdVO>();

    		for(int i=0;i<fullCntrRlseOrdVOs.length;i++){
    			 FullCntrRlseOrdVO fullCntrRlseOrdVo = (FullCntrRlseOrdVO)fullCntrRlseOrdVOs[i];

    			 for(int j=0;j<fullCntrRlseOrderMailSendVOs.length;j++){

    				 if( fullCntrRlseOrdVo.getBlNo().equals(fullCntrRlseOrderMailSendVOs[j].getBlNo()) &&
    					 fullCntrRlseOrdVo.getYdCd().equals(fullCntrRlseOrderMailSendVOs[j].getYdCd()) )  {

    					 fullCntrRlseOrdVo.setYdEml(fullCntrRlseOrderMailSendVOs[j].getYdEml());
    					 fullCntrRlseOrdVo.setNtcSndId(fullCntrRlseOrderMailSendVOs[j].getNtcSndId());
    				 }
    			 }
    			 bkgFullCgoRlseOrdVo  = new BkgFullCgoRlseOrdVO();
    	         ObjectCloner.build(fullCntrRlseOrdVo, bkgFullCgoRlseOrdVo);

    	         bkgFullCgoRlseOrdVo.setCgorMzdCd("M");
    	         bkgFullCgoRlseOrdVo.setBkgTrspModCd(fullCntrRlseOrdVo.getBkgTrspModCd());
    	         if("CUST".equals(diffStr)){
    	        	 bkgFullCgoRlseOrdVo.setRlseNtcEml(fullCntrRlseOrdVo.getCustEml());
    	         }else{
    	        	 bkgFullCgoRlseOrdVo.setRlseNtcEml(fullCntrRlseOrdVo.getYdEml());
    	         }
    	         bkgFullCgoRlseOrdVo.setRlseExpDt(fullCntrRlseOrdVo.getRlseExpDt());
    	         bkgFullCgoRlseOrdVo.setPinNo(fullCntrRlseOrdVo.getPinNo());
    	         bkgFullCgoRlseOrdVo.setEmlSndId(fullCntrRlseOrdVo.getNtcSndId());
    	         bkgFullCgoRlseOrdVo.setRlseUsrId(account.getUsr_id());
    	         bkgFullCgoRlseOrdVo.setRlseOfcCd(account.getOfc_cd());
    	         bkgFullCgoRlseOrdVo.setCreUsrId(account.getUsr_id());
    	         bkgFullCgoRlseOrdVo.setUpdUsrId(account.getUsr_id());

    	         bkgFullCgoRlseOrdVos.add(bkgFullCgoRlseOrdVo);

    		}
    		dbDao.addFullCntrRlseOrder(bkgFullCgoRlseOrdVos );

        } catch(EventException ee) {
             log.error("err " + ee.toString(), ee);
             throw ee;
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
    }

    /**
     * Full Cargo Release Order EDI전송
     * MQ Name
     *  -Test : ALPSBKG_T_UDEVHJS_VENDOR
     *  -Live : ALPSBKG_UBIZHJS_VENDOR
     * [ESM_BKG_0272]
     * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs  UI화면에서 사용자가 멀티 셀렉트한 상태일 경우 여러건일 수 있다.
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transmitEdiFullCntrRlseOrder ( FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs, SignOnUserAccount account) throws EventException{
        try{
            if(fullCntrRlseOrderEdiSendVOs != null){

               //모두 Yard Check가 이상없을 경우 다시 한번 반복문을 돌면서 차례차레 절차를 밟는다.
                FullCntrRlseOrderEdiYdVO   fullCntrRlseOrderEdiYdVo = null;
                FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend = null;
                BookingUtil                bookingUtil              = null;
                SendFlatFileVO             sendFlatFileVO           = null;
                FlatFileAckVO              flatFileAckVO            = null;
                List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos      = new ArrayList<BkgFullCgoRlseOrdVO>();

                for(int i=0;i<fullCntrRlseOrderEdiSendVOs.length;i++){

                    fullCntrRlseOrderEdiYdVo = dbDao.searchEdiFullCntrRlseOrderYardCd(fullCntrRlseOrderEdiSendVOs[i].getYdCd());
                    if(fullCntrRlseOrderEdiYdVo == null){
                        //Invalid EDI Yard Code
                        throw new EventException(new ErrorHandler("BKG04015",new String[]{fullCntrRlseOrderEdiSendVOs[i].getYdCd(),"EDI"}).getMessage());
                    }

                    bookingUtil =  new BookingUtil();
                    fullCntrRlseOrderEdiSend = new FullCntrRlseOrderEdiSendVO();

                    fullCntrRlseOrderEdiSend.setBkgNo(fullCntrRlseOrderEdiSendVOs[i].getBkgNo());
                    fullCntrRlseOrderEdiSend.setCntrNo(fullCntrRlseOrderEdiSendVOs[i].getCntrNo());
                    fullCntrRlseOrderEdiSend.setCxlFlg(fullCntrRlseOrderEdiSendVOs[i].getCxlFlg());
                    fullCntrRlseOrderEdiSend.setBlNo(fullCntrRlseOrderEdiSendVOs[i].getBlNo());
                    fullCntrRlseOrderEdiSend.setVvd(fullCntrRlseOrderEdiSendVOs[i].getVvd());
                    fullCntrRlseOrderEdiSend.setDiffRmk(fullCntrRlseOrderEdiSendVOs[i].getDiffRmk());
                    fullCntrRlseOrderEdiSend.setCustNm(fullCntrRlseOrderEdiSendVOs[i].getCustNm());
                    fullCntrRlseOrderEdiSend.setCgoPkupDt(fullCntrRlseOrderEdiSendVOs[i].getCgoPkupDt());
                    fullCntrRlseOrderEdiSend.setYdCd(fullCntrRlseOrderEdiSendVOs[i].getYdCd());
                    fullCntrRlseOrderEdiSend.setCoBdgId(fullCntrRlseOrderEdiSendVOs[i].getCoBdgId());
                    fullCntrRlseOrderEdiSend.setCgoCrrId(fullCntrRlseOrderEdiSendVOs[i].getCgoCrrId());
                    fullCntrRlseOrderEdiSend.setRlseOfcCd(account.getOfc_cd());
                    fullCntrRlseOrderEdiSend.setRlseExpDt(fullCntrRlseOrderEdiSendVOs[i].getRlseExpDt());
                    fullCntrRlseOrderEdiSend.setPinNo(fullCntrRlseOrderEdiSendVOs[i].getPinNo());
                    fullCntrRlseOrderEdiSend.setVehRgstId(fullCntrRlseOrderEdiSendVOs[i].getVehRgstId());
                    fullCntrRlseOrderEdiSend.setRoadHlgId(fullCntrRlseOrderEdiSendVOs[i].getRoadHlgId());
                    fullCntrRlseOrderEdiSend.setUqVslIdNo(fullCntrRlseOrderEdiSendVOs[i].getUqVslIdNo());
                    fullCntrRlseOrderEdiSend.setCstmsVoyNo(fullCntrRlseOrderEdiSendVOs[i].getCstmsVoyNo());

                    // 기존 EDI 전송 여부를 조회한다.
                    String header = dbDao.searchDoEdiHeader(fullCntrRlseOrderEdiYdVo.getSendId()
                                                           ,fullCntrRlseOrderEdiYdVo.getReceiverId()
                                                           ,"COREOR");

                    String brac     = dbDao.searchEdiFullCntrRlseOrdBrac(fullCntrRlseOrderEdiSend);
                    fullCntrRlseOrderEdiSend.setCxlFlg(brac);

                    String blInfo   = dbDao.searchEdiFullCntrRlseOrderBlInfo(fullCntrRlseOrderEdiSend);
                    String cntrInfo = dbDao.searchEdiFullCntrRlseOrderCntrInfo(fullCntrRlseOrderEdiSend, account.getOfc_cd());

                    String eurInfo = dbDao.searchEdiFullCntRlseOrderEurDtlInfo(fullCntrRlseOrderEdiSend);

                    String dgInfo   = dbDao.searchEdiFullCntrRlseOrderDgInfo(fullCntrRlseOrderEdiSendVOs[i].getBkgNo()
                                                                            ,fullCntrRlseOrderEdiSendVOs[i].getCntrNo());

                    String blCntr   = dbDao.searchEdiFullCntrRlseOrderBlCntr(fullCntrRlseOrderEdiSendVOs[i].getBkgNo()
                                                                            ,fullCntrRlseOrderEdiSendVOs[i].getCntrNo()
                                                                            ,fullCntrRlseOrderEdiSendVOs[i].getBkgTrspModCd());


                    // Flat File 생성
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(header);
                    buffer.append(blInfo);
                    buffer.append(cntrInfo);
                    buffer.append(eurInfo);
                    buffer.append(dgInfo);
                    buffer.append(blCntr);

                    sendFlatFileVO = new SendFlatFileVO();
                    sendFlatFileVO.setFlatFile(buffer.toString());

                    //QueueNm 세팅
                    //"ALPSBKG_T_UDEVHJS_VENDOR"
                    bookingUtil = new BookingUtil();

                    sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR.IBMMQ.QUEUE"));

                    flatFileAckVO = new FlatFileAckVO();

                    flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
                        //EDI ERROR 발생 시

                    if( flatFileAckVO.getAckStsCd().equals("E")) {
                        throw new EventException(new ErrorHandler("BKG40110",new String[]{fullCntrRlseOrderEdiYdVo.getReceiverId()}).getMessage());
                    }

                    BkgFullCgoRlseOrdVO bkgFullCgoRlseOrdVo = new BkgFullCgoRlseOrdVO();
                    ObjectCloner.build(fullCntrRlseOrderEdiSendVOs[i], bkgFullCgoRlseOrdVo);
                    // EDI 전송
                    bkgFullCgoRlseOrdVo.setCgorMzdCd("E");

                    bkgFullCgoRlseOrdVo.setRlseUsrId(account.getUsr_id());
                    bkgFullCgoRlseOrdVo.setRlseOfcCd(account.getOfc_cd());
                    bkgFullCgoRlseOrdVo.setCreUsrId(account.getUsr_id());
                    bkgFullCgoRlseOrdVo.setUpdUsrId(account.getUsr_id());

                    bkgFullCgoRlseOrdVos.add(bkgFullCgoRlseOrdVo);

                }// Loop Of For(i)

                dbDao.addFullCntrRlseOrder(bkgFullCgoRlseOrdVos);
            }
        } catch(EventException ee) {
            log.error("err " + ee.toString(), ee);
            throw ee;
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 1052 - Remark Save<br>
     * Remark Pupup화면에서 해당 Remark를 저장한다.<br>
     * @param BkgFullCntrRemarkVO bkgFullCntrRemarkVO
     * @param SignOnUserAccount account
     * @return int updateCount
     * @exception EventException
     */
    public int modifyFullCntrRlseRmk(BkgFullCntrRemarkVO bkgFullCntrRemarkVO, SignOnUserAccount account) throws EventException{
        int updateCount = 0;
        try{
            updateCount = dbDao.modifyFullCntrRlseRmk(bkgFullCntrRemarkVO, account);
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return updateCount;
    }

    /**
     * Full Continer Release Order History<br>
     * [ESM_BKG_0273]
     * @param FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO
     * @param SignOnUserAccount account
     * @return List<FullCntrRlseOrderHisVO>
     * @exception EventException
     */
    public List<FullCntrRlseOrderHisVO> searchFullCntrRlseOrderHis(FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO ,  SignOnUserAccount account) throws EventException{
        List<FullCntrRlseOrderHisVO> list = null;
        try{
            String fromDate = fullCntrRlseOrderHisSearchVO.getInCreDtFrom().replaceAll("-", "");
            String toDate = fullCntrRlseOrderHisSearchVO.getInCreDtTo().replaceAll("-", "");
            fullCntrRlseOrderHisSearchVO.setInCreDtFrom(fromDate);
            fullCntrRlseOrderHisSearchVO.setInCreDtTo(toDate);

            list = dbDao.searchFullCntrRlseOrderHis(fullCntrRlseOrderHisSearchVO, account.getOfc_cd());
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return list;
    }

    /**
     * [0130] : Receiver Info 조회<br>
     * [ESM_BKG_0130]
     * @param String doNo
     * @return DoRcvrInfoVO
     * @exception EventException
     */
    public DoRcvrInfoVO searchDoRcvrInfo(String doNo) throws EventException{
        DoRcvrInfoVO doRcvrInfoVO = null;
        try{
            doRcvrInfoVO = dbDao.searchDoRcvrInfo(doNo);
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return doRcvrInfoVO;
    }

    /**
     * [0130] : Receiver Info 저장<br>
     * [ESM_BKG_0130]
     * @param DoRcvrInfoVO doRcvrInfoVO
     * @param SignOnUserAccount account
     * @return int Update Count
     * @exception EventException
     */
    public int setupDoRcvrInfo(DoRcvrInfoVO doRcvrInfoVO, SignOnUserAccount account) throws EventException{
        int updCount = 0;
        try{
            updCount = dbDao.modifyDoRcvrInfo(doRcvrInfoVO, account);
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return updCount;
    }


    /**
     * Yard 정보를 조회한다.<br>
     * @param String ydCd  : Yard Cord
     * @return FullCntrRlseYdInfoVO ydInfoVO
     * @exception EventException
     * @author An Jineung
     */
    public FullCntrRlseYdInfoVO searchFullCntrRlseYdInfo(String ydCd) throws EventException{
    	FullCntrRlseYdInfoVO ydInfoVO = null;
        try{
        	ydInfoVO = dbDao.searchFullCntrRlseYdInfo(ydCd);
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return ydInfoVO;
    }



    /**
     * Full Container Order 이메일 본문 생성.<br>
     * @param FullCntrRlseOrdVO fullCntrRlseOrdVo
     * @param SignOnUserAccount account
     * @param String sortStr
     * @return String emlCtnt
     * @exception EventException
     * @author An Jineung
     */
private String makeFullCntrRlseEmlHdr(FullCntrRlseOrdVO fullCntrRlseOrdVo,SignOnUserAccount account, String sortStr) throws EventException{

    	StringBuffer sb = new StringBuffer();

    	try{

             sb.append("<Full Container Release Order>").append("\r\n").append("\r\n");

             String temp = fullCntrRlseOrdVo.getSendDate();

             sb.append("Date : " + temp.replaceAll("/", " / ")).append("\r\n");

             // 화주에게 보내는 경우는 Yard 정보를 제외시킨다.
             if(!"custEml".equals(sortStr)) {
            	 sb.append("To : " + fullCntrRlseOrdVo.getYdNm()).append("\r\n");
                 sb.append("Tel : " + fullCntrRlseOrdVo.getPhnNo()).append("\r\n");
                 sb.append("Fax : " + fullCntrRlseOrdVo.getFaxNo()).append("\r\n").append("\r\n");
             }

             BookingUtil bookingUtilBC = new BookingUtil();
             MdmOrganizationVO mvo =  bookingUtilBC.searchMdmOrzByOfcCd(account.getOfc_cd());
             sb.append("From : ").append(account.getUsr_nm()).append(" ").append(account.getOfc_eng_nm()).append("\r\n");

             if(mvo == null){
            	 mvo = new MdmOrganizationVO();
             }

             String telNo = mvo.getOfcPhnNo();

             if(CheckUtils.isNullAndNullString(telNo)){
            	 telNo = "      ";//둘다 없으면 공백 띄움
             }

             //@ 국제 전화번호가 있으면 표시함
        	 if(!CheckUtils.isNullAndNullString(mvo.getIntlPhnNo())){
        		 sb.append("  Tel : (").append(mvo.getIntlPhnNo()).append("-").append(telNo).append(")");
        	 }else{
        		 sb.append("  Tel : (").append(telNo).append(")");
        	 }
             sb.append("\r\n").append("\r\n").append("\r\n");//3줄 띄움


         } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return sb.toString();
    }
    /**
     * Full Container Order 이메일 본문 생성.<br>
     * @param FullCntrRlseOrdVO fullCntrRlseOrdVo
     * @param String flag
     * @return String
     * @throws EventException
     */
    private String makeFullCntrRlseEmlCtnt(FullCntrRlseOrdVO fullCntrRlseOrdVo,SignOnUserAccount account, String flag) throws EventException{

    	StringBuffer sb = new StringBuffer();

    	try{
             sb.append("B/L No.(REF No) : " + fullCntrRlseOrdVo.getBlNo()).append("\r\n");
             sb.append("Container No : " + fullCntrRlseOrdVo.getCntrNo()).append("\r\n");
        	 sb.append("Pin No : " + fullCntrRlseOrdVo.getPinNo()).append("\r\n");

        	 sb.append("Yard Name : " + fullCntrRlseOrdVo.getYdNm()).append("\r\n");
             sb.append("Pick-up Date : " + fullCntrRlseOrdVo.getCgoPkupDt()).append("\r\n");
             sb.append("Release Expiry Date : " + fullCntrRlseOrdVo.getRlseExpDt()).append("\r\n");
             sb.append("Vessel Name : " + fullCntrRlseOrdVo.getVslNm()).append("\r\n");
             String vvd = fullCntrRlseOrdVo.getVvd();
             sb.append("VoyageNo : " + vvd.substring(4)).append("\r\n");
             sb.append("Port Of Loading : " + fullCntrRlseOrdVo.getLocNm()).append("\r\n");
             sb.append("Consignee Or Release To : " + fullCntrRlseOrdVo.getCustNm()).append("\r\n");

             String pkupMode = fullCntrRlseOrdVo.getBkgTrspModCd();


             if("T".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Truck").append("\r\n");
             else if("R".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Rail").append("\r\n");
             else if("F".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Feeder").append("\r\n");
             else if("B".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Barge").append("\r\n");
             else sb.append("Trans(Pick-Up)Mode : ").append("\r\n");

             sb.append("Remark : " + fullCntrRlseOrdVo.getDiffRmk()).append("\r\n").append("\r\n");

        	 if("CUST".equals(flag)){

        		 if("DE".equals(fullCntrRlseOrdVo.getPodCd().substring(0, 2))){
	        		 List<FullCntrRlseCntrEmlVO> fullCntrRlseCntrEmlVOs = dbDao.searchFullCgoEmlCntrInfo(fullCntrRlseOrdVo.getBkgNo(),fullCntrRlseOrdVo.getCntrNo());
	        		 sb.append("ATB# : " + fullCntrRlseOrdVo.getMsgAcptRefNo()).append("\r\n");
	                 sb.append("--------------------------------------------------------------------------------------------------------------").append("\r\n");
	                 sb.append("Seq   ").append("Package                 ").append("Weight                  ").append("Measure                 ").append("HS Code").append("\n");
	                 sb.append("       ").append("Marks                                           ").append("Description").append("\r\n");
	                 sb.append("--------------------------------------------------------------------------------------------------------------").append("\r\n");
	                 for(int i = 0; i < fullCntrRlseCntrEmlVOs.size(); i++){
	                     sb.append(fullCntrRlseCntrEmlVOs.get(i).getCntrMfSeq()+ "       ").append(fullCntrRlseCntrEmlVOs.get(i).getPckQty()).append(fullCntrRlseCntrEmlVOs.get(i).getPckTpCd()+"                   ");
	                     sb.append(fullCntrRlseCntrEmlVOs.get(i).getCntrMfWgt()).append(fullCntrRlseCntrEmlVOs.get(i).getWgtUtCd()).append("              ");
	                     sb.append(fullCntrRlseCntrEmlVOs.get(i).getMeasQty()).append(fullCntrRlseCntrEmlVOs.get(i).getMeasUtCd()).append("                 ");
	                     sb.append(fullCntrRlseCntrEmlVOs.get(i).getCmdtHsCd()).append("\n");
	                     if(!"".equals(fullCntrRlseCntrEmlVOs.get(i).getCntrMfMkDesc()))
	                    	 sb.append("        ").append(fullCntrRlseCntrEmlVOs.get(i).getCntrMfMkDesc()).append("                                            ");
	                     else
	                    	 sb.append("                                                          ");
	                     if(!"".equals(fullCntrRlseCntrEmlVOs.get(i).getCntrMfGdsDesc()))
	                    	 sb.append("| " + fullCntrRlseCntrEmlVOs.get(i).getCntrMfGdsDesc());
	                     sb.append("\r\n").append("\r\n");
	                 }

	          	 }

        	}
         } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return sb.toString();
    }

    /**
     * Full Container Order 이메일 Signature 생성.<br>
     * @return String
     * @exception EventException
     * @author An Jineung
     */
    private String makeFullCntrRlseEmlSign(SignOnUserAccount account,String flag) throws EventException{

    	StringBuffer sb = new StringBuffer();

    	try{
    		/*
    		 * 2015.08.03 한진그룹 코드 표준화
    		 *  HAMBB > HAMSC
				DUSBS > DUSSO
				FRABS > FRASO
				MUCBS > MUCSO
				BREBS > BRESO
    		 */
    		 if("CUST".equals(flag)){
    			 if( "HAMSC".equals( account.getOfc_cd()) || "DUSSO".equals( account.getOfc_cd()) ||
    					 "FRASO".equals( account.getOfc_cd()) || "MUCSO".equals( account.getOfc_cd()) ||
    					 "BRESO".equals( account.getOfc_cd()) ){
    				 StringBuffer eml_add = new StringBuffer();
    				 eml_add.append("ACHTUNG : Bitte weisen Sie Ihre Fahrer darauf hin, vor Abnahme des Containers zwingend die Terminalhomepage zu überprufen.\r\n");
    				 eml_add.append("Desweiteren ist sowohl an den deutschen Terminals ( Interchange ), als auch auf www.smlines.com / local page eine Notfallnummer für Customer Service Import hinterlegt, die bei Freistellungsproblemen nach den Bürozeiten genutzt werden soll !\r\n");
    				 eml_add.append("SM Line übernimmt keine Kosten für Wartezeiten oder Fehlfuhren, wenn der Container auf der Terminalhomepage gesperrt, oder nicht übernahmebereit ist.\r\n");
    				 eml_add.append("SM Line übernimmt ferner keine Kosten für Wartezeiten oder Fehlfuhren, wenn bei Freistellungsproblemen nach Bürozeiten kein Gebrauch von der Notfallnummer gemacht wurde.\r\n");
    				 eml_add.append("\r\n");
    				 eml_add.append("ATTENTION : please instruct your trucker to check the terminal homepage mandatorily before truck is sent to terminal.\r\n");
    				 eml_add.append("Moreover we have relayed an emergency number at the Interchanges of the german terminals, and you can also find customer service Import emergency number on our homepage www.smlines.com / local page . Please use this number after office hours in case of problems with the release of the container.\r\n");
    				 eml_add.append("SM Line won\"t cover any costs for waiting time or wasted journey , if the container is blocked or not given free on terminal homepage.\r\n");
    				 eml_add.append("SM Line also won't cover any costs for waiting time or wasted journey, if the emergency number wasn't used in case of release problems !\r\n");
    				 eml_add.append("\r\n");
    				 sb.append("---------------------------------------------------------------------------------------------------------------").append("\r\n");

    				 sb.append(eml_add.toString());
    			 }
    		 }

             sb.append("END OF E-MAIL").append("\r\n").append("\r\n");
             sb.append("Best Regards").append("\r\n");
             sb.append("SM Line").append("\r\n");

         } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return sb.toString();
    }

    /**
     * Full Container Order 이메일 생성.<br>
     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
     * @param SignOnUserAccount account
     * @return FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo
     * @exception EventException
     * @author An Jineung
     */
    public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtntForTmnl(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account) throws EventException{

    	List<FullCntrRlseOrdVO> fullCntrRlseOrdVoSortList = new ArrayList<FullCntrRlseOrdVO>();

    	List<FullCntrRlseOrdVO> fullCntrRlseOrdVoHisList = new ArrayList<FullCntrRlseOrdVO>();
    	List<FullCntrRlseOrderMailSendVO> fullCntrRlseOrderMailSendVoList = new ArrayList<FullCntrRlseOrderMailSendVO>();
    	FullCntrRlseOrderMailSendVO fullCntrRlseOrderMailSendVo = null; //new FullCntrRlseOrderMailSendVO();

    	FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = new FullCntrRlseOrderMailVO();

    	try{
     		/*
			 *  BL & YD 기준으로 정렬 - BL & YD 기준으로 한건만 출력 위해
			 */
			List<Object> sortLists = sortArray(fullCntrRlseOrdVos, "blNo", "ydCd");

			FullCntrRlseOrdVO fullCntrRlseOrdVo = new FullCntrRlseOrdVO();
			FullCntrRlseYdInfoVO fullCntrRlseYdInfoVo = new FullCntrRlseYdInfoVO();

			for (int i=0; i<sortLists.size(); i++) {


				fullCntrRlseOrdVoSortList = (List<FullCntrRlseOrdVO>) sortLists.get(i);

				StringBuffer emlTxt = new StringBuffer();
				StringBuffer emlCtnt = new StringBuffer();

				for (int j=0; j<fullCntrRlseOrdVoSortList.size(); j++) {
					fullCntrRlseOrdVo = fullCntrRlseOrdVoSortList.get(j);


	                    if("".equals(fullCntrRlseOrdVo.getCgoPkupDt())) {
	                        String chkFlg= dbDao.checkEuFullRlseTransmitValid(fullCntrRlseOrdVo.getBkgNo(),"P");
	                        if("Y".equals(chkFlg)) {
	                        	throw new EventException(new ErrorHandler("BKG95059",new String[]{fullCntrRlseOrdVo.getCntrNo()}).getMessage());
	                    	}
	                   }

	                   if("".equals(fullCntrRlseOrdVo.getRlseExpDt())) {
	                        String chkFlg= dbDao.checkEuFullRlseTransmitValid ( fullCntrRlseOrdVo.getBkgNo(), "R" );

		                   if("Y".equals(chkFlg)) {
		                	   throw new EventException(new ErrorHandler("BKG95058",new String[]{fullCntrRlseOrdVo.getCntrNo()}).getMessage());
		                   }
	                   }


					fullCntrRlseYdInfoVo = searchFullCntrRlseYdInfo(fullCntrRlseOrdVo.getYdCd());

					 if (fullCntrRlseYdInfoVo != null) {
						fullCntrRlseOrdVo.setYdEml(fullCntrRlseYdInfoVo.getYdEml());
		                fullCntrRlseOrdVo.setYdNm(fullCntrRlseYdInfoVo.getYdNm());
		                fullCntrRlseOrdVo.setPhnNo(fullCntrRlseYdInfoVo.getPhnNo());
		                fullCntrRlseOrdVo.setFaxNo(fullCntrRlseYdInfoVo.getFaxNo());
		             }

					 // 중복되는 이메일 본문 생성
				     emlCtnt.append(this.makeFullCntrRlseEmlCtnt(fullCntrRlseOrdVo ,account, "TMNL"));

				     fullCntrRlseOrdVoHisList.add(fullCntrRlseOrdVo);

				}
				 // 이메일 헤더 생성
				emlTxt.append(this.makeFullCntrRlseEmlHdr(fullCntrRlseOrdVo, account, "ydCd"));
                 // 이메일 본문 생성
				emlTxt.append(emlCtnt.toString());
				// 이메일 Signature 생성
				emlTxt.append(this.makeFullCntrRlseEmlSign(account, "TMNL"));


				fullCntrRlseOrderMailSendVo =  new FullCntrRlseOrderMailSendVO();

				if(fullCntrRlseOrdVo != null){
					ObjectCloner.build(fullCntrRlseOrdVo, fullCntrRlseOrderMailSendVo);
					fullCntrRlseOrderMailSendVo.setSubject("Full Container Release Order( " + fullCntrRlseOrdVo.getVslNm() + " " + fullCntrRlseOrdVo.getVvd().substring(4, 9) + " )");
				}else{
					fullCntrRlseOrderMailSendVo.setSubject("Full Container Release Order(  )");
				}


				fullCntrRlseOrderMailSendVo.setContent(emlTxt.toString());
				fullCntrRlseOrderMailSendVoList.add(fullCntrRlseOrderMailSendVo);

			}

			fullCntrRlseOrderMailVo.setFullCntrRlseOrdVos(fullCntrRlseOrdVoHisList);
			fullCntrRlseOrderMailVo.setFullCntrRlseOrderMailSendVos(fullCntrRlseOrderMailSendVoList);

        } catch(EventException ee) {
            log.error("err " + ee.toString(), ee);
            throw ee;
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return fullCntrRlseOrderMailVo;
    }

    /**
     * Full Container Order 이메일 생성.<br>
     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
     * @param SignOnUserAccount account
     * @return FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo
     * @exception EventException
     * @author An Jineung
     */
    public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtntForCust(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account) throws EventException{

    	List<FullCntrRlseOrdVO> fullCntrRlseOrdVoSortList = new ArrayList<FullCntrRlseOrdVO>();

    	List<FullCntrRlseOrdVO> fullCntrRlseOrdVoHisList = new ArrayList<FullCntrRlseOrdVO>();
    	List<FullCntrRlseOrderMailSendVO> fullCntrRlseOrderMailSendVoList = new ArrayList<FullCntrRlseOrderMailSendVO>();
    	FullCntrRlseOrderMailSendVO fullCntrRlseOrderMailSendVo = null; //new FullCntrRlseOrderMailSendVO();

    	FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = new FullCntrRlseOrderMailVO();

    	try{
     		/*
			 *  BL & 화주 Email 기준으로 정렬 - BL & Email 기준으로 한건만 출력 위해
			 */
			List<Object> sortLists = sortArray(fullCntrRlseOrdVos, "custEml", "custEml");

			FullCntrRlseOrdVO fullCntrRlseOrdVo = new FullCntrRlseOrdVO();
			FullCntrRlseYdInfoVO fullCntrRlseYdInfoVo = null;

			for (int i=0; i<sortLists.size(); i++) {


				fullCntrRlseOrdVoSortList = (List<FullCntrRlseOrdVO>) sortLists.get(i);

				StringBuffer emlTxt = new StringBuffer();
				StringBuffer emlCtnt = new StringBuffer();

				for (int j=0; j<fullCntrRlseOrdVoSortList.size(); j++) {
					fullCntrRlseOrdVo = fullCntrRlseOrdVoSortList.get(j);


                   if("".equals(fullCntrRlseOrdVo.getCgoPkupDt())) {
                        String chkFlg= dbDao.checkEuFullRlseTransmitValid(fullCntrRlseOrdVo.getBkgNo(),"P");
                        if("Y".equals(chkFlg)) {
                        	throw new EventException(new ErrorHandler("BKG95059", new String[]{fullCntrRlseOrdVo.getCntrNo()}).getMessage());
                        }
                   }

                   if("".equals(fullCntrRlseOrdVo.getRlseExpDt())) {
                        String chkFlg= dbDao.checkEuFullRlseTransmitValid ( fullCntrRlseOrdVo.getBkgNo(), "R" );

	                   if("Y".equals(chkFlg)) {
	                	   throw new EventException(new ErrorHandler("BKG95058",new String[]{fullCntrRlseOrdVo.getCntrNo()}).getMessage());
	                   }
                   }


					fullCntrRlseYdInfoVo = searchFullCntrRlseYdInfo(fullCntrRlseOrdVo.getYdCd());
					fullCntrRlseOrdVo.setYdEml(fullCntrRlseOrdVo.getCustEml());
					 if (fullCntrRlseYdInfoVo != null) {
						 // 화주 Email

		                fullCntrRlseOrdVo.setYdNm(fullCntrRlseYdInfoVo.getYdNm());
		                fullCntrRlseOrdVo.setPhnNo(fullCntrRlseYdInfoVo.getPhnNo());
		                fullCntrRlseOrdVo.setFaxNo(fullCntrRlseYdInfoVo.getFaxNo());
		             }


					 // 중복되는 이메일 본문 생성
				     emlCtnt.append(this.makeFullCntrRlseEmlCtnt(fullCntrRlseOrdVo,account, "CUST"));

				     fullCntrRlseOrdVoHisList.add(fullCntrRlseOrdVo);

				}
				 // 이메일 헤더 생성
				emlTxt.append(this.makeFullCntrRlseEmlHdr(fullCntrRlseOrdVo, account, "custEml"));
                 // 이메일 본문 생성
				emlTxt.append(emlCtnt.toString());
				// 이메일 Signature 생성
				emlTxt.append(this.makeFullCntrRlseEmlSign(account,"CUST" ));


				fullCntrRlseOrderMailSendVo =  new FullCntrRlseOrderMailSendVO();

				if(fullCntrRlseOrdVo != null){
					ObjectCloner.build(fullCntrRlseOrdVo, fullCntrRlseOrderMailSendVo);
					fullCntrRlseOrderMailSendVo.setSubject("Full Container Release Order( " + fullCntrRlseOrdVo.getVslNm() + " " + fullCntrRlseOrdVo.getVvd().substring(4, 9) + " )");
				}else{
					fullCntrRlseOrderMailSendVo.setSubject("Full Container Release Order(  )");
				}
				fullCntrRlseOrderMailSendVo.setContent(emlTxt.toString());
				fullCntrRlseOrderMailSendVoList.add(fullCntrRlseOrderMailSendVo);

			}

			fullCntrRlseOrderMailVo.setFullCntrRlseOrdVos(fullCntrRlseOrdVoHisList);
			fullCntrRlseOrderMailVo.setFullCntrRlseOrderMailSendVos(fullCntrRlseOrderMailSendVoList);

        } catch(EventException ee) {
            log.error("err " + ee.toString(), ee);
            throw ee;
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return fullCntrRlseOrderMailVo;
    }


    /**
	 * Array를 정렬조건(compareName)를 기준으로 재정렬한다.<br>
	 * <br>
	 * 예) <br>
	 * FullCntrRlseOrdVO[] fullCntrRlseOrd = new FullCntrRlseOrdVO[];<br>
	 * sortArray(fullCntrRlseOrd, "ntcEml");<br>
	 *
	 * @param Object[] objects 정렬 대상
	 * @param String compareName1 정렬 조건명
	 * @param String compareName2 정렬 조건명
	 * @return List<Object>
	 * @throws Exception
	 */
	private List<Object> sortArray(Object[] objects, String compareName1, String compareName2) throws Exception {

		List<Object> results = new ArrayList<Object>();

		Object temp = null; // 비교대상을 담는 임시 Object
		List<Object> temps = null; // 비교값이 동일한 Object 모음
		String str11, str12, str21, str22;
		int i, j, cnt = 0;
		String funcName1 = "";
		String funcName2 = "";


		// 널인 경우
		if (objects == null || objects.length == 0) return null;
		if (compareName1 == null || compareName1.length() == 0) return null;


		if (compareName1.length() > 1) funcName1 = "get" + compareName1.substring(0,1).toUpperCase() + compareName1.substring(1);
		else funcName1 = "get" + compareName1.toUpperCase();

		if (compareName2.length() > 1) funcName2 = "get" + compareName2.substring(0,1).toUpperCase() + compareName2.substring(1);
		else funcName2 = "get" + compareName2.toUpperCase();


		Method meth1 = objects[0].getClass().getMethod(funcName1);
		Method meth2 = objects[0].getClass().getMethod(funcName2);


		for (i=0; i<objects.length; i++)
		{
			str11 = "";
			str12 = "";
			str21 = "";
			str22 = "";
			temps = new ArrayList<Object>();

			for(cnt=0, j=i; j<objects.length; j++)
			{
				if (j == i) {
					str11 = (String) meth1.invoke(objects[i]);
					str12 = (String) meth2.invoke(objects[i]);

					// 시작 Object
					temps.add(objects[j]);
				} else {
					str21 = (String) meth1.invoke(objects[j]);
					str22 = (String) meth2.invoke(objects[j]);

				    if (str11.compareTo(str21) == 0 && str12.compareTo(str22) == 0)
				    {
					    // 동일값을 갖는 Object 추가
					    temps.add(objects[j]);

				    	cnt++;

					    // 배열 위치 이동(재비교하지 않기 위해)
					    temp = objects[i+cnt];
					    objects[i+cnt] = objects[j];
					    objects[j] = temp;
				    }
				}
			}

			// 비교값이 동일한 Object 들을 추가
			results.add(temps);

			// 동일 Object 만큼 Skip
			i = i + cnt;
		}

		return results;
    }

    /**
     * 조회 이벤트 처리<br>
     * Cargo Release Order_E-D/O inquiry _Main 화면의 자가운송에 대한 조회 이벤트 처리<br>
     *
     * @param EdoSearchVO edoSearch
     * @return List<EdoRqstsVO>
     * @exception EventException
     */
    public List<EdoCntrRqstsVO> searchEdoCntrRqstList(EdoSearchVO edoSearch) throws EventException {
        try {
            return dbDao.searchEdoCntrRqstList(edoSearch);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
/******************************************************************************************
* Author : Son YunSeuk End
******************************************************************************************/


    /**
     * IDA D/O Release 내역을 삭제 처리한다.
     *
     * @param IdaDoCancelVO idaDoCancelVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelIdaDo(IdaDoCancelVO  idaDoCancelVo, SignOnUserAccount account) throws EventException {
    	if(JSPUtil.getNull(idaDoCancelVo.getBkgNo()).equals("") )return;

    	 try{
             dbDao.removeDoCntrInfo(idaDoCancelVo.getBkgNo());
             dbDao.removeDoDtlInfo(idaDoCancelVo.getBkgNo());
             dbDao.removeDoRefInfo(idaDoCancelVo.getBkgNo());
             dbDao.removeDoInfo(idaDoCancelVo.getBkgNo());

             BkgDoHisVO doHis = new BkgDoHisVO();

             doHis.setBkgNo(idaDoCancelVo.getBkgNo());
             doHis.setDoCngEvntCd("XX");
             doHis.setCrntCtnt("X");
             doHis.setPreCtnt("YES");
             doHis.setCreUsrId(account.getUsr_id());
             doHis.setUpdUsrId(account.getUsr_id());
             doHis.setEvntUsrId(account.getUsr_id());
             doHis.setEvntOfcCd(account.getOfc_cd());
             dbDao.addDoHistory(doHis);

         } catch(DAOException de) {
             log.error("err " + de.toString(), de);
             throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
         } catch(Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }



    }

    /**
     * PSA EDI Transmit 처리
     *
     * @param psaDoEdiTransVO
     * @throws EventException
     */
    public void transmitEdiPsaEdo(PsaDoEdiTransVO psaDoEdiTransVO) throws EventException{

    	BkgIbEdiSndLogVO ibEdiSndLog = null;

    	try {
            String eventTp = psaDoEdiTransVO.getEventTp(); //Event Type

	        //* Default 값
	        //1.Sender ID     : SMLINE
	        //2.Receiver ID   : PSA
	        //3.MsgId         : PSAEDO

	        String senderId   = "SMLINE";
	        String receiverId = "PSA";
	        String msgId      = "PSAEDO";

            // EDI Header, Body 생성
            String header   = null;
            String recTp    = dbDao.searchEdiPsaEdoRecTp(psaDoEdiTransVO.getBkgNo(), eventTp);
            String[] cntr = dbDao.searchEdiPsaEdoCtnt(psaDoEdiTransVO, recTp);

            if ( cntr == null || cntr.length == 0 ) {
                throw new EventException(new ErrorHandler("BKG00205").getMessage());
            }

            /*****************************************************************************
             * Flat File 생성
             * MQName : BKG.ALPSBKG_UBIZHJS_EDO.IBMMQ.QUEUE
             * Sender ID : SMLINE ( Default Value )
             * Receiver ID : PSA ( Default Value )
            *****************************************************************************/

            // Container 개수만큼 EDI를 전송한다.
            for(int i=0; i<cntr.length; i++) {
	            /**
	             * EDI 연동.
	             */
	            StringBuffer flatFile = new StringBuffer();

	            header =  dbDao.searchEdiPsaEdoHeader(senderId, receiverId, msgId);
	            flatFile.append(header);
	            flatFile.append(cntr[i]);

	            log.debug("\n========================================");
	            log.debug("\n"+"transmitEdiPsaEdo Start" + "\n");
	            log.debug(flatFile.toString());
	            log.debug("\n========================================");

	            SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
	            sendFlatFileVO.setFlatFile(flatFile.toString());

	            //QueueNm 세팅
	            sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EDO.IBMMQ.QUEUE"));
	            BookingUtil command = new BookingUtil();

	            FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
	            flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

	            log.debug("\n========================================");
	            log.debug("\n"+"transmitEdiPsaEdo End" + "\n");
	            log.debug("전송 결과: " + flatFileAckVO.getAckStsCd());
	            log.debug("\n========================================");

	            //EDI ERROR 발생 시
	            if ( flatFileAckVO.getAckStsCd().equals("E"))
	                throw new EventException(new ErrorHandler("BKG00205").getMessage());

	            // EDI 전송 결과 History
	            ibEdiSndLog = new BkgIbEdiSndLogVO();

	            ibEdiSndLog.setBkgNo(psaDoEdiTransVO.getBkgNo());
	            ibEdiSndLog.setFltFileRefNo(header.substring(62,76));
	            ibEdiSndLog.setDoEdiTpCd(recTp);
	            ibEdiSndLog.setMsgTpId(msgId);
	            ibEdiSndLog.setMsgTpNm("PSAEDO");
	            ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
	            ibEdiSndLog.setEdiEvntOfcCd(psaDoEdiTransVO.getAcount().getOfc_cd());

	            ibEdiSndLog.setEdiEvntUsrId(psaDoEdiTransVO.getAcount().getUsr_id());
	            ibEdiSndLog.setCreUsrId(psaDoEdiTransVO.getAcount().getCre_usr_id());
	            ibEdiSndLog.setUpdUsrId(psaDoEdiTransVO.getAcount().getUsr_id());

	            dbDao.addIbEdiSndLog(ibEdiSndLog);
            }

            // History
            BkgDoHisVO doHis = new BkgDoHisVO();

            doHis.setBkgNo(psaDoEdiTransVO.getBkgNo());
            doHis.setCreUsrId(psaDoEdiTransVO.getCreUsrId());
            doHis.setUpdUsrId(psaDoEdiTransVO.getUpdUsrId());
            doHis.setDoCngEvntCd(recTp);
            doHis.setPreCtnt("");
            doHis.setCrntCtnt("");
            doHis.setEvntUsrId(psaDoEdiTransVO.getAcount().getUsr_id());
            doHis.setEvntOfcCd(psaDoEdiTransVO.getAcount().getOfc_cd());

           dbDao.addDoHistory(doHis);

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * PSA 터미널 EDI 전송 후 수신 받은 Ack 정보를 조회
     *
     * @param BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO
     * @return List<BkgPsaEdoAckSchVO>
     * @throws EventException
     */
    public List<BkgPsaEdoAckSchVO> searchPsaEdoAckLog(BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO) throws EventException {
        try {
            return dbDao.searchPsaEdoAckLog(bkgPsaEdoAckSchVO);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * PSA EDI 전송 후 수신 내용을 저장
     *
     * @param bkgPsaEdoRcvLogVO
     * @throws EventException
     */
    public void receiptPsaEdoAck(BkgPsaEdoRcvLogVO bkgPsaEdoRcvLogVO) throws EventException {
    	try{
    		dbDao.addPsaEdoAck(bkgPsaEdoRcvLogVO);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * India Cargo Release조회화면의 COMBO 값 조회 : UI_BKG_0680<br>
     *
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchIdaDoDiscTmnlYdList() throws EventException {
        try {
            return dbDao.searchIdaDoDiscTmnlYdList();
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * E-DO 요청 내역이 자가운송의 승인인 경우 냉동 화물 유무 체크<br>
     *
     * @param String bkgNo
     * @return EdoTransBlInfoVO
     * @throws EventException
     */
    public EdoTransBlInfoVO searchEdoTrasnBlInfo(String bkgNo) throws EventException {
        try {
            return dbDao.searchEdoTrasnBlInfo(bkgNo);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * BKG_EDO_MST 테이블이 조회 될 때 Review flag 를 업데이트 한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @param String usrId
     * @throws EventException
     */
    public void modifyEdoReviewFlag(String rqstNo, String tpCd, String usrId) throws EventException {
        try {
        	dbDao.modifyEdoReviewFlag(rqstNo, tpCd, usrId);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }



    /**
     * Pickup Date 및 Release Expire Date 항목 체크
     * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs
     * @throws EventException
     */
    public void checkEuFullRlseTransmitValid (FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs) throws EventException{
        try{
            if(fullCntrRlseOrderEdiSendVOs != null){

                for(int i=0;i<fullCntrRlseOrderEdiSendVOs.length;i++){

                    if("".equals(fullCntrRlseOrderEdiSendVOs[i].getCgoPkupDt())) {
                        String chkFlg= dbDao.checkEuFullRlseTransmitValid(fullCntrRlseOrderEdiSendVOs[i].getBkgNo(),"P");
                        if("Y".equals(chkFlg)) {
                        	throw new EventException((String)new ErrorHandler("BKG95059",new String[]{fullCntrRlseOrderEdiSendVOs[i].getCntrNo()}).getMessage());
                    	}
                   }

                   if("".equals(fullCntrRlseOrderEdiSendVOs[i].getRlseExpDt())) {
                        String chkFlg= dbDao.checkEuFullRlseTransmitValid ( fullCntrRlseOrderEdiSendVOs[i].getBkgNo(), "R" );

	                   if("Y".equals(chkFlg)) {
	                	   throw new EventException((String)new ErrorHandler("BKG95058",new String[]{fullCntrRlseOrderEdiSendVOs[i].getCntrNo()}).getMessage());
	                   }
                   }
                }
            }
        } catch(EventException ee) {
            log.error("err " + ee.toString(), ee);
            throw ee;
        }catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoEdiTransVO[] edoEdiTrans
     * @param String callModule
     * @exception EventException
     */
    public void transmitEdiBySelfTransEdo (EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException {
    	try {

    		for(int idx=0; idx<edoEdiTrans.length; idx++){


                //자가운송 요청 동의서
               if("5JM".equals(edoEdiTrans[idx].getEdoTpCd())){
                    log.debug("\n자가운송 요청 동의서");
                    log.debug("\n==========>>>>>>>>>>>>>>>>"+edoEdiTrans[idx].getEdoAckCd());
                    edoEdiTrans[idx].setEdoAckCd("A");
                    edoEdiTrans[idx].setRqstNo(edoEdiTrans[idx].getRqstNo());

                    this.transmitEdoBy5JM(edoEdiTrans[idx]);
                }
            }
        } catch(EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }


    /**
     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
     *
     * @param EdoEdiTransVO[] edoEdiTrans
     * @param String callModule
     * @exception EventException
     */
    public void transmitEdiByInbondTransEdo (EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException {
    	try {
            for(int idx=0; idx<edoEdiTrans.length; idx++){

                log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoTpCd());
                log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoAckCd());

                if("5JK".equals(edoEdiTrans[idx].getEdoTpCd())){
                    log.debug("Bosebose보세운송 요청 동의서");
                    edoEdiTrans[idx].setEdoAckCd("A");
                    edoEdiTrans[idx].setRqstNo(edoEdiTrans[idx].getRqstNo());
                    this.transmitEdoBy5JK(edoEdiTrans[idx]);
                }
            }
        } catch(EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_1167 Canada Cargo Release에 대한 List를 Item별로 조회한다.
     *
     * @param CaCgoRlseSearchVO searchvo
     * @return List<CaCgoRlseListVO>
     * @exception EventException
     */
    public List<CaCgoRlseListVO> searchCaCgoRlseList(CaCgoRlseSearchVO searchvo) throws EventException {
        List<CaCgoRlseListVO> listVO = null;

        try {
            listVO = dbDao.searchCaCgoRlseList(searchvo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return listVO;
    }

    /**
     * ESM_BKG_1167 B/L별 컨테이너 번호를 조회한다.
     *
     * @param String bkgNo
     * @return List<BkgContainerVO>
     * @exception EventException
     */
    public List<BkgContainerVO> searchCaCgoRlseFoc(String bkgNo) throws EventException {
        List<BkgContainerVO> listVO = null;

        try {
            listVO = dbDao.searchCaCgoRlseFoc(bkgNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return listVO;
    }

    /**
     * ESM_BKG_1167 Original Bill of Lading Status 조회
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return List<CaCgoRlseBlStatusVO>
     * @throws EventException
     */
    public List<CaCgoRlseBlStatusVO>  searchCaCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException{
        List<CaCgoRlseBlStatusVO> caCgoRlseBlStatus = null;

        try {
            caCgoRlseBlStatus = (List<CaCgoRlseBlStatusVO>) dbDao.searchCaCgoRlseBlStatus(bkgNo, account);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return caCgoRlseBlStatus;
    }

    /**
     * ESM_BKG_1167 Partial 정보가져오기
     *
     * @param CaCgoRlseBkbcBlVO caCgoRlseBkbc
     * @return CaCgoRlseBkbcBlVO
     * @exception EventException
     */
    public CaCgoRlseBkbcBlVO searchCaPrtlBl(CaCgoRlseBkbcBlVO caCgoRlseBkbc) throws EventException {

        CaCgoRlseBkbcBlVO cacgoRlseBkbcBL = new CaCgoRlseBkbcBlVO();

        try {
            cacgoRlseBkbcBL = (CaCgoRlseBkbcBlVO) dbDao.searchCaPrtlBl(caCgoRlseBkbc);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return cacgoRlseBkbcBL;
    }

    /**
     * ESM_BKG_1167 Partial 정보가져오기
     *
     * @param String blNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void caCgoRlse(String blNo,SignOnUserAccount account) throws EventException {

    	CaCgoRlseSearchVO searchVo = new CaCgoRlseSearchVO();
    	CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO = new CaCgoRlseBkbcFocVO();
    	CaCgoRlseBkbcFocVO tmpCaCgoRlseBkbcFocVO = new CaCgoRlseBkbcFocVO();
    	CaCgoRlseBkbcFocVO tmpCaCgoPoLocSlanVO = new CaCgoRlseBkbcFocVO();
    	CaCgoRlseBkbcBlVO caCgoFocBlVO = new CaCgoRlseBkbcBlVO();
    	List<CaCgoRlseBkbcFlatFileVO> flatFileVOs = new ArrayList<CaCgoRlseBkbcFlatFileVO>();
		List<CaCgoRlseBkbcFlatFileVO> flatFileVvdVO;
	   	searchVo.setBlNo(blNo);
    	try {
			List<CaCgoRlseListVO> list = dbDao.searchCaCgoRlseList(searchVo);

			if(list == null || list.size() == 0){
		   		//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
		   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}

			CaCgoRlseListVO caCgoRlseListVO = (CaCgoRlseListVO)list.get(0);
	   		// 1건만 비교한다.
	   		if("Y".equals(caCgoRlseListVO.getDoHldFlg())){
		   		//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
		   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
	   		}

			CaCgoRlseSndIdVO caCgoRlseSndIdVO = new CaCgoRlseSndIdVO();

			caCgoRlseSndIdVO = dbDao.searchCaCgoSndId(searchVo);

			// Send ID, Receive ID의 값이 둘다 있어야지 실행됨.
			if(caCgoRlseSndIdVO.getEdiSndId() == null || "".equals(caCgoRlseSndIdVO.getEdiSndId())||
			   caCgoRlseSndIdVO.getEdiRcvId() == null || "".equals(caCgoRlseSndIdVO.getEdiRcvId())||
			   caCgoRlseSndIdVO.getMsgTp() == null || "".equals(caCgoRlseSndIdVO.getMsgTp())|| "0".equals(caCgoRlseSndIdVO.getMsgTp())){
			   // 전송 대상이 아닐경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
			   throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}


//			caCgoRlseSndIdVO 에서 MSG_TP 에 에 따라 미주, 캐나다 I/B Cargo release 를 진행 한다.
//			0:Blank
//			1:FO
//			2:FOC
//			3:FOCD
//			9:Others"	"F:freight (운임징수 확인: Y)
//			O:OBL(OBL 회수  확인: Y)
//			C:Customs (통관절차 확인:Y)
//			D:Demmurgae(DEM 징수 확인:Y)
			//F/O 확인
			caCgoFocBlVO = dbDao.searchCaFocFlg(searchVo);

			if(("Y".equals(caCgoFocBlVO.getNewFrtCltFlg()) && "Y".equals(caCgoFocBlVO.getNewOblRdemFlg())) && "1".equals(caCgoRlseSndIdVO.getMsgTp())||"2".equals(caCgoRlseSndIdVO.getMsgTp())||"3".equals(caCgoRlseSndIdVO.getMsgTp())){
				// CaCgoRlseBkbcFlatFileVO 에 대한 Set up
				caCgoRlseBkbcFocVO = dbDao.searchCaCgoBkgInfo(caCgoRlseListVO);
				caCgoRlseBkbcFocVO.setEdiSndId(caCgoRlseSndIdVO.getEdiSndId());
				caCgoRlseBkbcFocVO.setEdiRcvId(caCgoRlseSndIdVO.getEdiRcvId());
				caCgoRlseBkbcFocVO.setYdCd(caCgoRlseSndIdVO.getEdiYard()); //Yard Setting

				tmpCaCgoRlseBkbcFocVO = dbDao.searchCaCgoVskInfo(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setVpsEtdDt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDt());
				caCgoRlseBkbcFocVO.setVpsEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDtGmt());
				caCgoRlseBkbcFocVO.setInitEtdDt(tmpCaCgoRlseBkbcFocVO.getInitEtdDt());
				caCgoRlseBkbcFocVO.setInitEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtdDtGmt());
				caCgoRlseBkbcFocVO.setVpsEtaDt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDt());
				caCgoRlseBkbcFocVO.setVpsEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDtGmt());
				caCgoRlseBkbcFocVO.setInitEtaDt(tmpCaCgoRlseBkbcFocVO.getInitEtaDt());
				caCgoRlseBkbcFocVO.setInitEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtaDtGmt());
				caCgoRlseBkbcFocVO.setFinalEtaDt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDt());
				caCgoRlseBkbcFocVO.setFinalEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDtGmt());
				//EDI Kind 를 CR 로 셋팅
				caCgoRlseBkbcFocVO.setEdiKnd("CR");

				tmpCaCgoPoLocSlanVO = dbDao.searchCaCgoPoLocSlan(caCgoRlseBkbcFocVO, account);

				caCgoRlseBkbcFocVO.setPoNo(tmpCaCgoPoLocSlanVO.getPoNo());
				caCgoRlseBkbcFocVO.setLocCd(tmpCaCgoPoLocSlanVO.getLocCd());
				caCgoRlseBkbcFocVO.setVslSlanNm(tmpCaCgoPoLocSlanVO.getVslSlanNm());
				caCgoRlseBkbcFocVO.setBlNo(blNo);
				CaCgoRlseBkbcBlVO caCgoRlseBkbcBlVO = new CaCgoRlseBkbcBlVO();
				caCgoRlseBkbcBlVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setHisSeq(caCgoRlseBkbcBlVO.getHisSeq());

				String BlCntrInd = "";
				BlCntrInd = dbDao.searchCaCgoBlCntrInd(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setEdiBlCntrInd(BlCntrInd);

				// search Canada Flat File
				flatFileVOs = dbDao.searchCaCgoMkFile(caCgoRlseBkbcFocVO);//parm : yd_cd로 변경

				flatFileVvdVO = dbDao.searchCaCgoVvdMkFile(caCgoRlseBkbcFocVO);
				String retVvd = "";

				for(int i=0;i<flatFileVvdVO.size();i++){
        			StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVvdVO.get(i).getFlatFileVvd());
        			retVvd = tmpBuffer.toString();
				}

				StringBuffer flatFile = new StringBuffer();
				String ediSnpRtnVal = "";



				BookingUtil command = new BookingUtil();


				for(int i=0;i<flatFileVOs.size();i++){
					CaCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
					flatFileVO.getSnpFileHeader();
					flatFile.append(flatFileVO.getFlatFileHeader());
					flatFile.append(flatFileVO.getFlatFileBody());
					flatFile.append(retVvd);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if ( flatFileAckVO.getAckStsCd().equals("E")){
			            throw new EventException(new ErrorHandler("BKG40087").getMessage());
			        }
					if(null != flatFileAckVO.getAckStsCd()){
						ediSnpRtnVal = flatFileAckVO.getAckStsCd();
					}
					caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
					//Canada Cargo Release EDI Sent 내역을 저장
			    	dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
			    	ediSnpRtnVal = "";
					if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
						flatFile = new StringBuffer();

						flatFile.append(flatFileVO.getDupFlatFileHeader());
						flatFile.append(flatFileVO.getFlatFileBody());
						flatFile.append(retVvd);

						SendFlatFileVO dupSendFlatFileVO = new SendFlatFileVO();
						dupSendFlatFileVO.setFlatFile(flatFile.toString());
						dupSendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"));

						FlatFileAckVO dupflatFileAckVO = command.sendFlatFile(dupSendFlatFileVO);

						if ( dupflatFileAckVO.getAckStsCd().equals("E")){
				            throw new EventException(new ErrorHandler("BKG40087").getMessage());
				        }
						if(null != dupflatFileAckVO.getAckStsCd()){
							ediSnpRtnVal = dupflatFileAckVO.getAckStsCd();
						}
						caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
						//Canada Cargo Release EDI Sent 내역을 저장
				    	dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					}
				}
				//Canada Cargo Release History 내역을 저장
				dbDao.modifyCaCgoRlsHisRslt(caCgoRlseBkbcFocVO,account);
				//Canada Cargo Release 내역을 저장
				dbDao.modifyCaCgoRlsRslt(caCgoRlseBkbcFocVO,account);
			}

			CaCgoRlseBkbcBlVO caCgoRlseSndFlgVO = new CaCgoRlseBkbcBlVO();
			caCgoRlseBkbcFocVO.setBlNo(blNo);
			caCgoRlseSndFlgVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);

			if((null != caCgoRlseSndFlgVO.getCgorEdiSndCd() && "R".equals(caCgoRlseSndFlgVO.getCgorEdiSndCd())) && (!"Y".equals(caCgoFocBlVO.getNewFrtCltFlg()) || !"Y".equals(caCgoFocBlVO.getNewOblRdemFlg()))){
				// CaCgoRlseBkbcFlatFileVO 에 대한 Set up
				caCgoRlseBkbcFocVO = dbDao.searchCaCgoBkgInfo(caCgoRlseListVO);
				caCgoRlseBkbcFocVO.setEdiSndId(caCgoRlseSndIdVO.getEdiSndId());
				caCgoRlseBkbcFocVO.setEdiRcvId(caCgoRlseSndIdVO.getEdiRcvId());
				caCgoRlseBkbcFocVO.setYdCd(caCgoRlseSndIdVO.getEdiYard()); //Yard Setting

				tmpCaCgoRlseBkbcFocVO = dbDao.searchCaCgoVskInfo(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setVpsEtdDt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDt());
				caCgoRlseBkbcFocVO.setVpsEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDtGmt());
				caCgoRlseBkbcFocVO.setInitEtdDt(tmpCaCgoRlseBkbcFocVO.getInitEtdDt());
				caCgoRlseBkbcFocVO.setInitEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtdDtGmt());
				caCgoRlseBkbcFocVO.setVpsEtaDt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDt());
				caCgoRlseBkbcFocVO.setVpsEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDtGmt());
				caCgoRlseBkbcFocVO.setInitEtaDt(tmpCaCgoRlseBkbcFocVO.getInitEtaDt());
				caCgoRlseBkbcFocVO.setInitEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtaDtGmt());
				caCgoRlseBkbcFocVO.setFinalEtaDt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDt());
				caCgoRlseBkbcFocVO.setFinalEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDtGmt());
				//EDI Kind 를 CR 로 셋팅
				caCgoRlseBkbcFocVO.setEdiKnd("CA");

				tmpCaCgoPoLocSlanVO = dbDao.searchCaCgoPoLocSlan(caCgoRlseBkbcFocVO, account);

				caCgoRlseBkbcFocVO.setPoNo(tmpCaCgoPoLocSlanVO.getPoNo());
				caCgoRlseBkbcFocVO.setLocCd(tmpCaCgoPoLocSlanVO.getLocCd());
				caCgoRlseBkbcFocVO.setVslSlanNm(tmpCaCgoPoLocSlanVO.getVslSlanNm());
				caCgoRlseBkbcFocVO.setBlNo(blNo);
				CaCgoRlseBkbcBlVO caCgoRlseBkbcBlVO = new CaCgoRlseBkbcBlVO();
				caCgoRlseBkbcBlVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setHisSeq(caCgoRlseBkbcBlVO.getHisSeq());

				String BlCntrInd = "";
				BlCntrInd = dbDao.searchCaCgoBlCntrInd(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setEdiBlCntrInd(BlCntrInd);

				// search Canada Flat File
				flatFileVOs = dbDao.searchCaCgoMkFile(caCgoRlseBkbcFocVO);//parm : yd_cd로 변경

				flatFileVvdVO = dbDao.searchCaCgoVvdMkFile(caCgoRlseBkbcFocVO);
//				String flatFileVvd = this.searchMkVvdFile(focVO);
				String retVvd = "";

				for(int i=0;i<flatFileVvdVO.size();i++){
					StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVvdVO.get(i).getFlatFileVvd());
        			retVvd = tmpBuffer.toString();
				}

				StringBuffer flatFile = new StringBuffer();
				String ediSnpRtnVal = "";

				BookingUtil command = new BookingUtil();

				for(int i=0;i<flatFileVOs.size();i++){
					CaCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
					flatFileVO.getSnpFileHeader();
					flatFile.append(flatFileVO.getFlatFileHeader());
					flatFile.append(flatFileVO.getFlatFileBody());
					flatFile.append(retVvd);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if ( flatFileAckVO.getAckStsCd().equals("E")){
			            throw new EventException(new ErrorHandler("BKG40087").getMessage());
			        }
					if(null != flatFileAckVO.getAckStsCd()){
						ediSnpRtnVal = flatFileAckVO.getAckStsCd();
					}
					caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
					//Canada Cargo Release EDI Sent 내역을 저장
			    	dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
			    	ediSnpRtnVal = "";
					if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
						flatFile = new StringBuffer();

						flatFile.append(flatFileVO.getDupFlatFileHeader());
						flatFile.append(flatFileVO.getFlatFileBody());
						flatFile.append(retVvd);

						SendFlatFileVO dupSendFlatFileVO = new SendFlatFileVO();
						dupSendFlatFileVO.setFlatFile(flatFile.toString());
						dupSendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"));

						FlatFileAckVO dupflatFileAckVO = command.sendFlatFile(dupSendFlatFileVO);

						if ( dupflatFileAckVO.getAckStsCd().equals("E")){
				            throw new EventException(new ErrorHandler("BKG40087").getMessage());
				        }
						if(null != dupflatFileAckVO.getAckStsCd()){
							ediSnpRtnVal = dupflatFileAckVO.getAckStsCd();
						}
						caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
						//Canada Cargo Release EDI Sent 내역을 저장
				    	dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					}
				}
				//Canada Cargo Release History 내역을 저장
				dbDao.modifyCaCgoRlsHisRslt(caCgoRlseBkbcFocVO,account);
				//Canada Cargo Release 내역을 저장
				dbDao.modifyCaCgoRlsRslt(caCgoRlseBkbcFocVO,account);

			}
    	 } catch (DAOException de) {
             throw new EventException(new ErrorHandler(de).getMessage());
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage(), ex);
         }
    }

    /**
     * ESM_BKG_1167 save버튼 저장
     *
     * @param BkgCgoRlseVO bkgCgoRlseVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCaCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException {

        try {
            /***************************
             * 1. BKG_CGO_RLSE UPDATE.
             ****************************/
            if (bkgCgoRlseVo != null) {

               int modRowsByMaster = dbDao.modifyCaCgoRlseEdi(bkgCgoRlseVo, account);

               if (modRowsByMaster > 0) {// SUCCESS 이면
                   dbDao.addCaCgoRlseHisEdi(bkgCgoRlseVo, account);
               }

              /***************************
	           * 2. FOC 관리 시작(EDI 전송)
	           ****************************/
	        	   this.caCgoRlse(bkgCgoRlseVo.getBlNo(), account);
            }
        } catch (EventException ex) {
            if(ex.getMessage().indexOf("BKG40085") > -1  ){
            	log.debug("");
            }else{
                log.error("err " + ex.toString(), ex);
	        }

        	throw ex;

        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_1167 Hold 작업을 수행한다.
     *
     * @param DoRefVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCaCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException {

        try {
            DoRefVO vo = new DoRefVO();


            //D/O HISTORY 생성
            BkgDoHisVO doHis = new BkgDoHisVO();
            log.debug("------------vo.getDoHldFlg() "+vo.getDoHldFlg());

            // 1번만 실행됨.
            for (int i = 0; i < vos.length; i++) {
                vo = vos[i];
                int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
                if (modRowsByMaster == 0) {
                    dbDao.addHoldFlgDoRef(vo, account);
                }

                //History
                doHis.setCreUsrId(account.getUsr_id());
                doHis.setUpdUsrId(account.getUsr_id());
                if(vo.getDoHldFlg().equals("Y")){
                	doHis.setDoCngEvntCd("HC");
                }else if(vo.getDoHldFlg().equals("N")){
                	doHis.setDoCngEvntCd("CH");
                }
                doHis.setPreCtnt("NO");
                doHis.setCrntCtnt("YES");
                doHis.setEvntUsrId(account.getUsr_id());
                doHis.setEvntOfcCd(account.getOfc_cd());
                doHis.setBkgNo(vo.getBkgNo());
                dbDao.addDoHistory(doHis);

                break;
            }
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * release notes 칼럼에 Update 항목이 보여야하는 오피스를 가져온다. ESM_BKG_0272<br>
     *
     * @param String ofcCd
     * @return String chkFlg
     * @exception EventException
     */
    public String searchOfcFullCntrRlseOrdBracUpdFlg(String ofcCd) throws EventException {
    	String chkFlg = "N";
    	try {
    		 chkFlg = dbDao.searchOfcFullCntrRlseOrdBracUpdFlg(ofcCd);
        } catch (DAOException de) {
          //  log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), de);
        } catch (Exception ex) {
          //  log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return chkFlg;

    }

    /**
	 * 1177   DO validity upto history 조회
	 * @param String bkgNo
	 * @return List<DoVtyDtUpdHisVO>
	 * @exception EventException
	 * @author Kwak youndBeom
	 */
	public List<DoVtyDtUpdHisVO> searchDoVtyUptoDthis(String bkgNo) throws EventException
	{
		List<DoVtyDtUpdHisVO> list = null;
		try
		{
			list = dbDao.searchDoVtyUptoDthis(bkgNo);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return list;
	}

    /**
     * [0156] COP Application : POD 변경시 조건으로 CR 전송여부 체크
     *
     * @param String blNo
     * @return List<UsCgoRlseListVO>
     * @exception EventException
     */
    public List<UsCgoRlseListVO> searchUsCgoRlseView(String blNo) throws EventException {
        List<UsCgoRlseListVO> listVO = null;

        try {
        	listVO  = dbDao.searchUsCgoRlseViewRSQL(blNo);

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return listVO;
    }


    /**
     * ESM_BKG_1515 EDI Setup 등록
     *
     * @param EdiYardInfoVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEdiSetup(EdiYardInfoVO[] vos, SignOnUserAccount account) throws EventException {

        try {
        	EdiYardInfoVO vo = new EdiYardInfoVO();

            for (int i = 0; i < vos.length; i++) {
                vo = vos[i];

                vo.setCreUsrId(account.getUsr_id());
                dbDao.manageEdiSetup(vo);

                //History
                dbDao.manageEdiSetupHistory(vo);

            }
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

    }


    /**
     * ESM_BKG_1515 EDI Setup 조회
     *
     * @param EdiYardInfoVO searchVo
     * @return List<EdiYardInfoVO>
     * @exception EventException
     */
    public List<EdiYardInfoVO> searchEdiSetupList(EdiYardInfoVO searchVo) throws EventException {
        List<EdiYardInfoVO> listVO = null;

        try {
        	listVO  = dbDao.searchEdiSetpList(searchVo);

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return listVO;
    }

    /**
     * ESM_BKG_1515 EDI Setup History 조회
     *
     * @param EdiYardInfoVO searchVo
     * @return List<EdiYardInfoVO>
     * @exception EventException
     */
    public List<EdiYardInfoVO> searchEdiSetupHistoryList(EdiYardInfoVO searchVo) throws EventException {
        List<EdiYardInfoVO> listVO = null;

        try {
        	listVO  = dbDao.searchEdiSetupHistoryList(searchVo);

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240")
                    .getMessage(), ex);
        }
        return listVO;
    }

    /**
     * 메일 전송 이벤트 처리<br>
     * India_Cargo Release Order의 D/O Receiver Setting 저장 후 메일 전송 처리<br>
     *
     * @param IndiaDoNtcSendVO paramVO
     * @param SignOnUserAccount account
     * @return IndiaDoNtcSendVO indiaDoNtcSendVO
     * @exception EventException
     */
    public IndiaDoNtcSendVO sendIndiaDoByEmail(IndiaDoNtcSendVO paramVO, SignOnUserAccount account) throws EventException {

        CargoReleaseOrderEAIDAO eai = new CargoReleaseOrderEAIDAO();

        try {
            log.debug("=======================================");
            log.debug("    searchDoMrdId 조회 Start           ");
            log.debug("=======================================");
            String bl_no  = dbDao.searchBlNo(paramVO.getBkgNo());
            String mrd_id = dbDao.searchDoMrdId(account.getOfc_cd());

            log.debug("    searchDoMrdId 결과 : " + mrd_id );

            log.debug("=======================================");
            log.debug("    sendIndiaDoByEmail 메일 전송 Start.   ");
            log.debug("=======================================");

            if ("".equals(mrd_id) || mrd_id.isEmpty()) {

                log.debug("=======================================");
                log.debug("    mrd_id의 값이 존재하지 않음        ");
                log.debug("=======================================");

                throw new EventException(new ErrorHandler("BKG40080").getMessage());
            }
            IndiaDoNtcSendVO indiaDoNtcSend = new IndiaDoNtcSendVO();
            indiaDoNtcSend.setBkgNo(paramVO.getBkgNo());
            indiaDoNtcSend.setBlNo(bl_no);
            indiaDoNtcSend.setDoNo(paramVO.getDoNo());
            indiaDoNtcSend.setDoNoSplit(paramVO.getDoNoSplit());
            indiaDoNtcSend.setMrdId(mrd_id);
            indiaDoNtcSend.setNtcEml(paramVO.getNtcEml());
            indiaDoNtcSend.setUsrEml(account.getUsr_eml());
            indiaDoNtcSend.setUsrId(account.getUsr_id());
            indiaDoNtcSend.setUsrNm(account.getUsr_nm());
            indiaDoNtcSend.setOfcCd(account.getOfc_cd());
            indiaDoNtcSend.setNtcViaCd("M");
            indiaDoNtcSend.setCreUsrId(account.getUsr_id());
            indiaDoNtcSend.setUpdUsrId(account.getUsr_id());
            indiaDoNtcSend.setInDoOdcyAddrCd(paramVO.getInDoOdcyAddrCd());
            indiaDoNtcSend.setEvntDt(paramVO.getEvntDt());
            indiaDoNtcSend.setAtchSveyLtrFlg(paramVO.getAtchSveyLtrFlg());
            indiaDoNtcSend.setRcvrCd(paramVO.getRcvrCd());

            indiaDoNtcSend.setSndId(eai.sendIndiaDoByEmail(indiaDoNtcSend));

            return indiaDoNtcSend;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
    }

    /**
     * [0909] 조회 WEB B/L Printed : Serial Number
     *
     * @param String bkgNo
     * @return UsCgoRlseListVO
     * @exception EventException
     */
    public UsCgoRlseListVO searchOblInterSerNoCheckInfo(String bkgNo) throws EventException {
        UsCgoRlseListVO listVO = null;

        try {
            listVO = dbDao.searchOblInterSerNoCheckInfo(bkgNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return listVO;
    }


    /**
     * 저장 이벤트 처리<br>
     * Cargo Release Order의 Office Default From Setup 저장(입력 또는 수정) 처리<br>
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageOblInterSerNoCheck(String bkgNo, SignOnUserAccount account) throws EventException {
        try {
        	dbDao.modifyOblInterSerNoCheckInfo(bkgNo, account);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0684 조회 이벤트 처리<br>
     * BD D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return EuDoMstVO euDoMst
     * @exception EventException
     */
    public EuDoMstVO searchBdDo(String bkgNo, SignOnUserAccount account)throws EventException {

        EuDoMstVO euDoMst = new EuDoMstVO();

        try {

            /**
             * Booking의 Actual Staus 를 조회한다.
             * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
             */
            validateBkgSts(bkgNo);

            /**
             * EU D/O Release를 위한 기본 정보를 조회한다.
             */
            DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
            euDoMst.setBlInfo(blInfo);

            if(blInfo != null){

            	//2016.05.13 방글라데시 관련 bl만 조회
            	if(!blInfo.getDelCd().substring(0,2).equals("BD")) {
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
                }

                /**
                 * EU D/O Release를 위한 기본 Reference 정보를 조회한다.
                 */
                BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo, account);

                //doRef 널 값일 경우 Bkg No를 세팅한다. Save 시  PK값 사용
                if(doRef == null){
                    doRef = new BkgDoRefVO();
                    doRef.setBkgNo(blInfo.getBkgNo());
                    euDoMst.setSplitFlg("N");
                }else{
                    euDoMst.setSplitFlg(doRef.getDoSplitFlg());
                }

                euDoMst.setBkgDoRefVO(doRef);

                /**
                 * EU 세관 신고를 위한 B/L INFO를 조회한다.
                 */
                EuCstmsVO euCstms = dbDao.searchEuCstmsInfo(bkgNo);
                euDoMst.setEuCstms(euCstms);

                /**
                 * Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
                 */
                List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs = dbDao.searchEuDoRlseStsByCntr(bkgNo);
                euDoMst.setEuDoCntrRlseStsVOs(euDoCntrRlseStsVOs);

                /**
                 * D/O No가 Split Assign되지 않은 Container의 수량을  조회한다.
                 */
                int cntrCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
                euDoMst.setCntrCnt(cntrCnt);

                /**
                 * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 조회
                 */
                List<EuDoRlseStsVO> euDoRlseStss= dbDao.searchEuDoRlseStsByBl(bkgNo);
                euDoMst.setEuDoRlseStsVOs(euDoRlseStss);

                /**
                 * DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회
                 */
                String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);
                if(cntrNo != null){
                    euDoMst.setCntrNo(cntrNo);
                }

                /**
                 * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail 정보를 조회한다.
                 */
                BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
                euDoMst.setBlIss(blIss);

                /**
                 * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.
                 */
                OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
                //by sungho 2010.03.04
                //otsRcvInfoVO = eaiDbDao.searchOtsInfo(euDoMst.getBlInfo().getBlNo());
                otsRcvInfoVO = this.searchErpOtsInfo(euDoMst.getBlInfo().getBlNo());
                euDoMst.setOtsRcvInfoVO(otsRcvInfoVO);

                /**
                 * 출력 FORM의 종류를 조회한다.
                 */
                String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
                euDoMst.setMrdId(mrdId);
            }
            return euDoMst;

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
     *
     * @param EuDoSaveVO euDoSave
     * @exception EventException
     */
    public void manageBdDo(EuDoSaveVO euDoSave) throws EventException {
        try {
            int resultCnt =0;

            BkgDoHisVO doHis = new BkgDoHisVO();

            String preCtnt  = "N";
            String crntCtnt = "Y";

            if("CR".equals(euDoSave.getDoCngEvntCd())){
                preCtnt  = "Y";
                crntCtnt = "N";
            }
            if("Y".equals(euDoSave.getOblCngFlg())){

                doHis.setBkgNo(euDoSave.getBkgNo());
                doHis.setCreUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setUpdUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setDoCngEvntCd(euDoSave.getDoCngEvntCd());
                doHis.setPreCtnt(preCtnt);
                doHis.setCrntCtnt(crntCtnt);
                doHis.setEvntUsrId(euDoSave.getAcount().getUsr_id());
                doHis.setEvntOfcCd(euDoSave.getAcount().getOfc_cd());

                dbDao.addDoHistory(doHis);
            }

            BkgDoRefVO bkgDoRef = new BkgDoRefVO();

            bkgDoRef.setBkgNo(euDoSave.getBkgNo());
            //bkgDoRef.setCyOpCd(euDoSave.getCyOpCd());
            //bkgDoRef.setInfoCgoFlg(euDoSave.getInfoCgoFlg());
            bkgDoRef.setInterRmk(euDoSave.getInterRmk());
            bkgDoRef.setCreUsrId(euDoSave.getUserId());
            bkgDoRef.setUpdUsrId(euDoSave.getUserId());
            bkgDoRef.setDoSplitFlg(euDoSave.getDoSplitFlg());
            bkgDoRef.setCstmsRefNm(euDoSave.getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(euDoSave.getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(euDoSave.getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(euDoSave.getCstmsAsgnCtnt());
            bkgDoRef.setDoHldFlg(JSPUtil.getNull(euDoSave.getDoHldFlg(),"N"));

            bkgDoRef.setAttrCtnt1(euDoSave.getAttrCtnt1());
            bkgDoRef.setAttrCtnt2(euDoSave.getAttrCtnt2());
            bkgDoRef.setAttrCtnt3(euDoSave.getAttrCtnt3());
            bkgDoRef.setAttrCtnt4(euDoSave.getAttrCtnt4());
            bkgDoRef.setAttrCtnt5(euDoSave.getAttrCtnt5());
            bkgDoRef.setAttrCtnt6(euDoSave.getAttrCtnt6());

            log.debug("getCstmsRefNm : " + bkgDoRef.getCstmsRefNm());

            resultCnt = dbDao.modifyDoRef(bkgDoRef);

            //수정 건수가 없다면 신규생성 한다.
            if ( resultCnt == 0 ) {
                log.debug("============================");
                log.debug("수정된 건수가 없음 신규 생성");
                log.debug("============================");

                dbDao.addDoRef(bkgDoRef);
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param EuDoRlseVO euDoRlse
     * @param DoCntrVO[] doCntrs
     * @exception EventException
     */
    public void releaseBdDo(EuDoRlseVO euDoRlse, DoCntrVO[] doCntrs) throws EventException {
        try {

            //validateDoRelease 호출
            validateDoRelease(euDoRlse.getBkgNo());


            //DO No 채번
            String doNo = null;
            if (euDoRlse.getDoSplitFlg().equals("Y")) {
                doNo = dbDao.searchDoNo(euDoRlse.getBkgNo());
            }

            if (doNo == null || doNo.equals("")) {
                doNo = makeDoNo(euDoRlse.getUsrOfcCd(), euDoRlse.getUsrId());
            }
            euDoRlse.setDoNo(doNo);

            //Split Flg == 'Y'인 경우
            String doNoSplit = "";
            int rlseSeq      = 0;

            //Split 일 경우 체크
            if ("Y".equals(euDoRlse.getDoSplitFlg())) {
                //Bkg No에 해당하는 DO NO SPLIT을 조회한다.
                log.debug("==================================");
                log.debug("searchDoSplitNo - doNoSplit을 채번");
                log.debug("==================================");

                doNoSplit = dbDao.searchDoSplitNo(euDoRlse.getBkgNo(), euDoRlse.getDoNo()); // DO Number를 제공해야 합니다. mgpark

                log.debug("==================================");
                log.debug("searchDoRlseSeq - rlseSeq를 채번");
                log.debug("==================================");
                rlseSeq = dbDao.searchDoRlseSeq(euDoRlse.getBkgNo());

            } else {
                doNoSplit = "00";
                rlseSeq = 1;
            }

            //Value Object 선언
            BkgDoVO bkgDo       = new BkgDoVO();
            BkgDoRefVO bkgDoRef = new BkgDoRefVO();
            BkgDoDtlVO doDtl    = new BkgDoDtlVO();
            BkgDoHisVO doHis    = new BkgDoHisVO();

            bkgDo.setBkgNo(euDoRlse.getBkgNo());
            bkgDo.setDoNo(doNo);
            bkgDo.setRlseSeq(Integer.toString(rlseSeq));
            bkgDo.setDoNoSplit(doNoSplit);
            bkgDo.setJpDoId("");
            bkgDo.setCgorRmk(euDoRlse.getCgorRmk());
            bkgDo.setCreUsrId(euDoRlse.getUsrId());
            bkgDo.setUpdUsrId(euDoRlse.getUsrId());
            bkgDo.setCustPrnFlg("N");
            bkgDo.setSelfTrnsFlg("N");

            bkgDoRef.setBkgNo(euDoRlse.getBkgNo());

            bkgDoRef.setCstmsRefNm(euDoRlse.getCstmsRefNm());
            bkgDoRef.setCstmsRefCtnt(euDoRlse.getCstmsRefCtnt());
            bkgDoRef.setCstmsAsgnNm(euDoRlse.getCstmsAsgnNm());
            bkgDoRef.setCstmsAsgnCtnt(euDoRlse.getCstmsAsgnCtnt());
            bkgDoRef.setInterRmk(euDoRlse.getInterRmk());
            bkgDoRef.setDoHldFlg(euDoRlse.getDoHldFlg());

            bkgDoRef.setCreUsrId(euDoRlse.getUsrId());
            bkgDoRef.setUpdUsrId(euDoRlse.getUsrId());
            bkgDoRef.setDoSplitFlg(euDoRlse.getDoSplitFlg());

            bkgDoRef.setAttrCtnt1(euDoRlse.getAttrCtnt1());
            bkgDoRef.setAttrCtnt2(euDoRlse.getAttrCtnt2());
            bkgDoRef.setAttrCtnt3(euDoRlse.getAttrCtnt3());
            bkgDoRef.setAttrCtnt4(euDoRlse.getAttrCtnt4());
            bkgDoRef.setAttrCtnt5(euDoRlse.getAttrCtnt5());
            bkgDoRef.setAttrCtnt6(euDoRlse.getAttrCtnt6());

            /*****************************************
                RELEASE STATUS CODE
            ******************************************
            A ASSIGN
            R RELEASE
            D DOR I/F
            I ASSIGN & ISSUE
            C CANCEL
            ******************************************/

            doDtl.setBkgNo(euDoRlse.getBkgNo());
            doDtl.setRlseSeq(Integer.toString(rlseSeq));
            doDtl.setRlseStsCd("R");
            doDtl.setEvntUsrId(euDoRlse.getUsrId());
            doDtl.setEvntOfcCd(euDoRlse.getUsrOfcCd());
            doDtl.setCreUsrId(euDoRlse.getUsrId());
            doDtl.setUpdUsrId(euDoRlse.getUsrId());

            doHis.setBkgNo(euDoRlse.getBkgNo());
            doHis.setCreUsrId(euDoRlse.getUsrId());
            doHis.setUpdUsrId(euDoRlse.getUsrId());
            doHis.setDoCngEvntCd("RE"); //Release
            doHis.setPreCtnt("");
            doHis.setCrntCtnt(euDoRlse.getDoNo());
            doHis.setEvntUsrId(euDoRlse.getUsrId());
            doHis.setEvntOfcCd(euDoRlse.getUsrOfcCd());

            //manageDo 호출
            manageDo(bkgDo, bkgDoRef, doDtl, doHis);

            //Split 일 경우 체크
            if ("Y".equals(euDoRlse.getDoSplitFlg())) {

                log.debug("=======================================");
                log.debug(""+doCntrs.length+"건 만큼 For Loop 실행");
                log.debug("=======================================");

                for(int i=0;i<doCntrs.length;i++){
                    log.debug("==================================");
                    log.debug("addDoRlseByCntr 호출 " + i + "건");
                    log.debug("==================================");

                    doCntrs[i].setRlseSeq(Integer.toString(rlseSeq));
                    doCntrs[i].setCreUsrId(euDoRlse.getUsrId());
                    doCntrs[i].setUpdUsrId(euDoRlse.getUsrId());

                    dbDao.addDoRlseByCntr(doCntrs[i]);
                }
            } else {
                log.debug("==================================");
                log.debug("addDoRlseByBl 호출 : " + Integer.toString(rlseSeq));
                log.debug("==================================");

                dbDao.addDoRlseByBl(euDoRlse.getBkgNo(), Integer.toString(rlseSeq), euDoRlse.getUsrId());
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(EventException ee) {
            throw ee;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 0684 EU D/O를 Cancel 한다.<br>
     *
     * @param DoCancelVO doCancel
     * @exception EventException
     * @author An Jineung
     */
    public void cancelBdDo(DoCancelVO doCancel, SignOnUserAccount account) throws EventException {
        try {
            this.cancelDo(doCancel);
            //dbDao.modifySplitFlg(doCancel.getBkgNo(), account);
            dbDao.removeDoCntr(doCancel.getBkgNo(), doCancel.getRlseSeq());

        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Indonesia(Surabaya) EDI Transmit 처리
     *
     * @param psaDoEdiTransVO
     * @throws EventException
     */
    public void transmitEdiIdEdo(IdDoEdiTransVO idDoEdiTransVO) throws EventException {

        BkgIbEdiSndLogVO ibEdiSndLog = null;
        
        try {
	        //* Default 값
	        //1.Sender ID     : SML
	        //2.Receiver ID   : TPS
	        //3.MsgId         : COREOR
	
	        String senderId   = "SML";
	        String receiverId = "TPS";
	        String msgId      = "COREOR";
	        String queueNm    = "BKG.ALPSBKG_UBIZHJS_DO.IBMMQ.QUEUE"; //2011.09.22
	
	        String header   = dbDao.searchDoEdiHeader(senderId, receiverId, msgId);
	        String doBlInfo = dbDao.searchEdiIdDoBlInfo(idDoEdiTransVO.getBkgNo(), idDoEdiTransVO.getEventTp());
	
	        if ( "".equals(doBlInfo) || doBlInfo == null) {
	            throw new EventException(new ErrorHandler("BKG00205").getMessage());
	        }
	        //DO No Search
	        String doNo = dbDao.searchIdDoNo(idDoEdiTransVO.getBkgNo());
	        
	        //Booking Container 정보를 조회한다.
	        String[] cntrInfo   = dbDao.searchEdiIdDoCntrInfo(doNo);
	
	        /*****************************************************************************
	         * Flat File 생성
	         * MQName : NISENT_UBIZHJS_DO   => ALPSBKG_UBIZHJS_DO
	         * Sender ID : SML ( Default Value )
	         * Receiver ID : TPS ( Default Value )
	        *****************************************************************************/
	
	        /**
	         * EDI 연동.
	         */
	        StringBuffer flatFile = new StringBuffer();
	
	        flatFile.append(header);
	        flatFile.append(doBlInfo);
	
	        for(int i=0 ; i < cntrInfo.length ; i++) {
	           flatFile.append(cntrInfo[i]);
	        }
	
	
	        log.debug("\n========================================");
	        log.debug("\n"+"transmitEdiIdEdo Start" + "\n");
	        log.debug(flatFile.toString());
	        log.debug("\n========================================");
	
	        SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
	        sendFlatFileVO.setFlatFile(flatFile.toString());
	
	        //QueueNm 세팅
	        //sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_DO.IBMMQ.QUEUE"));
	        sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueNm)); //2011.09.22
	        BookingUtil command = new BookingUtil();
	
	        FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
	        flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
	
            log.debug("\n========================================");
            log.debug("\n"+"transmitEdiIdEdo End" + "\n");
            log.debug("전송 결과: " + flatFileAckVO.getAckStsCd());
            log.debug("\n========================================");
	
	        //EDI ERROR 발생 시
	        if ( flatFileAckVO.getAckStsCd().equals("E")) {
	        	throw new EventException(new ErrorHandler("BKG00205").getMessage());
	        }
	
	        ibEdiSndLog = new BkgIbEdiSndLogVO();
	
	        ibEdiSndLog.setBkgNo(idDoEdiTransVO.getBkgNo());
	        ibEdiSndLog.setFltFileRefNo(header.substring(62,76));
	        ibEdiSndLog.setMsgTpId("TPS");
	        ibEdiSndLog.setMsgTpNm("COREOR");
	        ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
	        ibEdiSndLog.setEdiEvntOfcCd(idDoEdiTransVO.getAcount().getOfc_cd());
	        ibEdiSndLog.setEdiEvntUsrId(idDoEdiTransVO.getAcount().getUsr_id());
	        ibEdiSndLog.setCreUsrId(idDoEdiTransVO.getAcount().getUsr_id());
	        ibEdiSndLog.setUpdUsrId(idDoEdiTransVO.getAcount().getUsr_id());
	
	        dbDao.addIbEdiSndLog(ibEdiSndLog);
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }                
    }
}