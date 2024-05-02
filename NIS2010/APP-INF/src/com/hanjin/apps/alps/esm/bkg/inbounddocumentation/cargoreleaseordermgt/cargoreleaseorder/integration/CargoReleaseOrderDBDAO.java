/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderDBDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.09
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.07.09 임진영
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
* 2010-09-10 최도순 [CLT-100910046] 인도지역 D/O Extension(2)
* 2010.10.26 김영철 [] 메소드 주석 기술 ( R4J 수정 )
* 2011.07.05 김봉균 [CHM-201111821] Split 04-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011.07.28 김봉균 [CHM-201112484-01] Japan Cargo Release 의 DOR I/F  기능 개선 요청
* 2011.08.02 김봉균 [CHM-201112547-01] India Cargo Release 기능 보완 요청
* 2011.10.13 김봉균 [CHM-201113640-01] E-DO Free Time 관련 기능 추가(KT-NET)
* 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
* 2012.08.06 김보배 [CHM-201219299] [BKG] KOREA E-D/O 조회 기능 보완 요청
* 2012.11.22 조정민 [CHM-201221094] POD DE일 경우 EU Full CNTR Release 에서 Email 전송시 전송내역 추가 요청
* 2012.12.03 조정민 [CHM-201221434] [EU Full CNTR RLS화면] 필수값 변경 (P/up date, Rls expiry date)  
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
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
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSummaryVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoEventVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoVtyDtUpdHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdiYardInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseCntrEmlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseYdInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseInfoForCopyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoWeeklyReportVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.PsaDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.SearchEdoCntrPtyTrspVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFocVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcSceVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration.CsScreenDBDAOsearchBkgCgoTpRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
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

/* ************************************************************************************** */
/* Author :Lim JinYoung Start                                                             */
/* ************************************************************************************** */
 
/**
 * alps CargoReleaseOrderDBDAO <br>
 * -alps-cargoreleaseordermgt Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lim JinYoung
 * @see CargoReleaseOrderBCImpl 참조
 * @since J2EE 1.4
 */
public class CargoReleaseOrderDBDAO extends DBDAOSupport {

    //private DBRowSet dbRowset; //2011.07.05 중복된 변수 주석 처리


	/**
     * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
     *
     * @param String usrNm
     * @param String usrRegNo
     * @return List<KorDoAttorneyVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<KorDoAttorneyVO> searchKorDoCustList(String usrNm, String usrRegNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<KorDoAttorneyVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("atty_cust_nm", usrNm);
            mapVO.put("atty_biz_no", usrRegNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorDoCustListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDoAttorneyVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * New Cargo Release Order에서 Update 수정되는 정보를 시간순으로 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<DoHisVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<DoHisVO> searchDoHistory(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<DoHisVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoHistoryRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, DoHisVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Cargo Release시 한국 지역에 한하여 사업자명(위임자 또는 수입자) 과 그 사업자등록번호를 최초 등록한다.<br>
     *
     * @param List<KorDoAttorneyVO> attorney
     * @return int 입력 개 수
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int addKorDoCust(List<KorDoAttorneyVO> attorney) throws DAOException {
        int rtnVal = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(attorney.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOAddKorDoCustCSQL(), attorney,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            //Duplicate Error 가 나면
            if (se.getErrorCode() == 1){
                rtnVal = se.getErrorCode();
            }else{
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            }
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }

    /**
     * Cargo Release시 한국 지역에 한하여 사업자(위임자 또는 수입자) 정보를 수정한다.<br>
     *
     * @param List<KorDoAttorneyVO> attorney
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyKorDoCust(List<KorDoAttorneyVO> attorney) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(attorney.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOModifyKorDoCustUSQL(), attorney,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Cargo Release시 한국 지역에 한하여 사업자명(위임자 또는 수입자) 과 그 사업자등록번호를 삭제한다.<br>
     *
     * @param List<KorDoAttorneyVO> attorney
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void removeKorDoCust(List<KorDoAttorneyVO> attorney) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(attorney.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAORemoveKorDoCustDSQL(), attorney,null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
     *
     * @param String custType
     * @param String custNm
     * @param String custBizNo
     * @return List<KorDoAttorneyDtlVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<KorDoAttorneyDtlVO> searchKorDoAttorneyList(String custType, String custNm, String custBizNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<KorDoAttorneyDtlVO> attorneyDtls = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("cust_type"   , custType);
            mapVO.put("cust_name"   , custNm);
            mapVO.put("cust_biz_no" , custBizNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorDoAttorneyListRSQL(), param, velParam);
            attorneyDtls = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDoAttorneyDtlVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return attorneyDtls;
    }
    
    
    /**
     * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
     *
     * @param String fmAttyBizNo
     * @param String toAttyBizNo
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchKorDoAttorneyValChk(String fmAttyBizNo,String toAttyBizNo ) throws DAOException {       
    	
    	String chkRst            = null;
    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("fm_atty_biz_no"   , fmAttyBizNo);
            mapVO.put("to_atty_biz_no"   , toAttyBizNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchKorDoAttorneyValChkRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	chkRst = dbRowset.getString(1);
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkRst;
    }

    /**
     * Cargo Release시 한국 지역에 한하여 위임자를 조회하고 기등록된 사업자들을 위임자와 수임자로 각각 정의및 Mapping 작업을 수행한다.<br>
     *
     * @param List<KorDoAttorneyDtlVO> attorneyDtl
     * @return int 입력 개 수
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int addKorDoAttorney(List<KorDoAttorneyDtlVO> attorneyDtl) throws DAOException {
        int rtnVal = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(attorneyDtl.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOAddKorDoAttorneyCSQL(), attorneyDtl,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            //Duplicate Error 가 나면
            if (se.getErrorCode() == 1){
                rtnVal = se.getErrorCode();
            }else{
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            }
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }

    /**
     * Cargo Release시 한국 지역에 한하여 위임자를 조회하고 기등록된 사업자들을 위임자와 수임자로 각각 정의및 Mapping 작업을 수행한다.<br>
     *
     * @param List<KorDoAttorneyDtlVO> attorneyDtl
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyKorDoAttorney(List<KorDoAttorneyDtlVO> attorneyDtl) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(attorneyDtl.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOModifyKorDoAttorneyUSQL(), attorneyDtl,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 사업자명(위임자 또는 수임자) 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<KorDoAttorneyDtlVO> attorneyDtl
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void removeKorDoAttorney(List<KorDoAttorneyDtlVO> attorneyDtl) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(attorneyDtl.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAORemoveKorDoAttorneyDSQL(), attorneyDtl,null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 위임자 및 수임자 정보등록전 Validation 처리를 위해 기 등록 여부 정보를 조회한다.<br>
     *
     * @param String fmAttyBizNo
     * @param String toAttyBizNo
     * @return String dupcnt
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchKorDoAttorneyDtl(String fmAttyBizNo, String toAttyBizNo) throws DAOException {
        DBRowSet dbRowset = null;
        String dupcnt  = "0";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("fm_atty_biz_no" , fmAttyBizNo);
            mapVO.put("to_atty_biz_no" , toAttyBizNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorDoAttorneyDtlRSQL(), param, velParam);

            if (dbRowset.next()) {
                dupcnt = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dupcnt;
    }

    /**
     * Booking의 Actual Staus 를 조회한다.<br>
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @return String bkgStsCd
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchBkgStatus(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;

        String bkgStsCd = ""; //F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgStatusRSQL(), param, velParam);

            if (dbRowset.next()) {
                bkgStsCd = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgStsCd;
    }

    /**
     * D/O Release를 위한 기본 Reference 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return DoBlInfoVO blInfo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public DoBlInfoVO searchDoBlInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        DoBlInfoVO blInfo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"   , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoBlInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() == 1){
                blInfo = (DoBlInfoVO)RowSetUtil.rowSetToVOs(dbRowset, DoBlInfoVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blInfo;
    }

    /**
     * D/O Release를 위한 기본 Reference 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return BkgDoRefVO doRef
     * @exception DAOException
     * @author Lim JinYoung
     */
    public BkgDoRefVO searchDoRefInfo(String bkgNo, SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        BkgDoRefVO doRef = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no"   , bkgNo);
            mapVO.put("cnt_cd", account.getCnt_cd());
            mapVO.put("ofc_cd", account.getOfc_cd());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoRefInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() == 1){
                doRef = (BkgDoRefVO)RowSetUtil.rowSetToVOs(dbRowset, BkgDoRefVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRef;
    }

    /**
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<DoRlseStsVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<DoRlseStsVO> searchDoRlseSts(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<DoRlseStsVO> doRlseSts = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{       	
             Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoRlseStsRSQL(), param, velParam);
            doRlseSts = (List)RowSetUtil.rowSetToVOs(dbRowset, DoRlseStsVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRlseSts;
    }

    /**
     * 한국세관 신고를 위한 B/L INFO(Discharging CY, MRN, MSN, Entry Type, Warehouse)를 조회한다.<br>
     *
     * @param String bkgNo
     * @return KorCstmsVO korCstm
     * @exception DAOException
     * @author Lim JinYoung
     */
    public KorCstmsVO searchKorCstmsInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        KorCstmsVO korCstm = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorCstmsInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                korCstm = (KorCstmsVO)RowSetUtil.rowSetToVOs(dbRowset, KorCstmsVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return korCstm;
    }

    /**
     * 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return BlIssVO blIss
     * @exception DAOException
     * @author Lim JinYoung
     */
    public BlIssVO searchOBLSts(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BlIssVO blIss = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchOBLStsRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                blIss = (BlIssVO)RowSetUtil.rowSetToVOs(dbRowset, BlIssVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blIss;
    }

    /**
     * Report Design 출력폼을 조회한다.<br>
     *
     * @param String ofcCd
     * @return String mrdId
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchDoMrdId(String ofcCd) throws DAOException {

        DBRowSet dbRowset = null;

        String mrdId =""; //출력폼 ID

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("ofc_cd", ofcCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoMrdIdRSQL(), param, velParam);

            if (dbRowset.next()) {
                mrdId = dbRowset.getString(1);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mrdId;
    }

    /**
     * D/O 정보를 수정한다.( Korea_Cargo Release Order Creation ).<br>
     *
     * @param BkgDoVO bkgDo
     * @return int result
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int modifyDo(BkgDoVO bkgDo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyDoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Korea D/O Release Reference 정보를 수정한다.<br>
     *
     * @param BkgDoRefVO bkgDoRef
     * @return int result
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int mergeDoRef(BkgDoRefVO bkgDoRef) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoRef.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("bkg_no"          , bkgDoRef.getBkgNo());
            mapVO.put("cstms_ref_nm"    , bkgDoRef.getCstmsRefNm());
            mapVO.put("cstms_ref_ctnt"  , bkgDoRef.getCstmsRefCtnt());
            mapVO.put("cstms_asgn_nm"   , bkgDoRef.getCstmsAsgnNm());
            mapVO.put("cstms_asgn_ctnt" , bkgDoRef.getCstmsAsgnCtnt());
            mapVO.put("inter_rmk"       , bkgDoRef.getInterRmk());
            mapVO.put("do_hld_flg"      , bkgDoRef.getDoHldFlg());
            mapVO.put("cre_usr_id"      , bkgDoRef.getCreUsrId());
            mapVO.put("upd_usr_id"      , bkgDoRef.getUpdUsrId());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOMergeDoRefCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * D/O 정보를 저장한다.( Korea_Cargo Release Order Creation ).<br>
     *
     * @param BkgDoVO bkgDo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addDo(BkgDoVO bkgDo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddDoCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.<br>
     *
     * @param BkgDoHisVO bkgDoHis
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addDoHistory(BkgDoHisVO bkgDoHis) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoHis.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddDoHistoryCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * F.O.C Event 발생 시  U.S. Inbound CARGO RELEASE 정보 저장 Table (CT, CR 정보저장).<br>
     *
     * @param FocVO bkgFocVO
     * @return int result
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public int modifyCgoRlseByFOCEvent(FocVO bkgFocVO) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//            Map<String, String> mapVO = bkgFocVO.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyCgoRlseByFOCEventUSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                    throw new DAOException("Fail to Update SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return result;
//    }

    /**
     * F.O.C Event 발생 시  U.S. Inbound CARGO RELEASE 정보 저장 Table (CT, CR 정보저장).<br>
     *
     * @param FocVO bkgFocVO
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public void addCgoRlseByFocEvent(FocVO bkgFocVO) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//            Map<String, String> mapVO = bkgFocVO.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddCgoRlseByFocEventCSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                    throw new DAOException("Fail to insert SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * F.O.C Event 발생 시  U.S. Inbound CARGO RELEASE History 정보를 생성한다.<br>
     *
     * @param String blNo
     * @param String focStatus
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public void addCgoRlseHisByFocEvent(String blNo, String focStatus, SignOnUserAccount account) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            mapVO.put("bl_No"      , blNo);
//            mapVO.put("foc_status" , focStatus);
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddCgoRlseHisByFocEventCSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                    throw new DAOException("Fail to insert SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * 조회된 B/L No에 연계된 Container의 General Info.를 조회한다.<br>
     *
     * @param String bkgNo
     * @return String[] cntrs
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchDemDetCntrList(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        String[] cntrs = null;
        int idx = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDemDetCntrListRSQL(), param, velParam);
            cntrs = new String[dbRowset.getRowCount()];
            while (dbRowset.next()) {
                cntrs[idx++] = dbRowset.getString("CNTR_NO");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntrs;
    }

    /**
     * 해당 B/L의 OBL Release 여부를 체크한다.<br>
     *
     * @param String bkgNo
     * @return String oblRdemFlg
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String checkOBLRlse(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;

        String oblRdemFlg ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOCheckOBLRlseRSQL(), param, velParam);

            if (dbRowset.next()) {
                oblRdemFlg = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return oblRdemFlg;
    }

    /**
     * D/O의 Hold 여부를 조회한다.<br>
     *
     * @param String bkgNo
     * @return boolean isHld
     * @exception DAOException
     * @author Lim JinYoung
     */
    public boolean checkHold(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        boolean isHld = false;
        String doHldFlg = "";
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOCheckHoldRSQL(), param, velParam);

            if (dbRowset.next()) {
                doHldFlg = dbRowset.getString(1);
            }

            if("Y".equals(doHldFlg)){
                isHld = true;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isHld;
    }

    /**
     * 현 시점의 Current한 D/O Status 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @return DoRlseStsVO doStss
     * @exception DAOException
     * @author Lim JinYoung
     */
    public DoRlseStsVO searchDoSts(String bkgNo, String rlseSeq) throws DAOException {
        DBRowSet dbRowset = null;
        DoRlseStsVO doStss = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);
            mapVO.put("rlse_seq", rlseSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoStsRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                  doStss = (DoRlseStsVO)RowSetUtil.rowSetToVOs(dbRowset, DoRlseStsVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doStss;
    }

    /**
     * DO No를 초기화 한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void resetDoNo(String bkgNo, String rlseSeq ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);
            mapVO.put("rlse_seq", rlseSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOResetDoNoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 해당 BKG_NO, RLSE_SEQ를  기준으로 가장 최근에 Status 정보를 삭제한다.<br>
     *
     * @param DoCancelVO doCancel
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public void removeDoStsByCancel(DoCancelVO doCancel) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doCancel.getColumnValues();

            param.putAll(mapVO); velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoStsByCancelDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    */

    /**
     * 해당 BKG_NO, RLSE_SEQ의 Cancel Status 정보를 삭제한다.<br>
     *
     * @param BkgDoDtlVO doDtl
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void removeDoCancel(BkgDoDtlVO doDtl) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doDtl.getColumnValues();

            param.putAll(mapVO); velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoCancelDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * D/O 상세 정보를 저장한다.(DO Staus 변환시마다 정보를 저장한다).<br>
     *
     * @param BkgDoDtlVO bkgDoDtl
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addDoDtlSts(BkgDoDtlVO bkgDoDtl) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoDtl.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddDoDtlStsCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * DO 대상 B/L 단위로  HOLD를 셋팅한다.<br>
     *
     * @param DoHoldVO doHold
     * @return int
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int modifyDoRefByHold(DoHoldVO doHold) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doHold.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyDoRefByHoldUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
            return result;
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * DO 대상 B/L 단위로  HOLD를 Revmove한다.<br>
     *
     * @param DoHoldVO doHold
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void holdRlseDo(DoHoldVO doHold) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doHold.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOHoldRlseDoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 해당 BKG_NO, RLSE_SEQ를  기준으로 Cancel 상태 정보를 삭제한다.<br>
     *
     * @param DoEventVO doEvent
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void removeDoDtl(DoEventVO doEvent) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doEvent.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoDtlDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 해당 B/L이 LCL일 경우 관련 B/L들에 대한 전체 O/BL Staus를 확인 한다.<br>
     *
     * @param String bkgNo
     * @return boolean isRcv
     * @exception DAOException
     * @exception EventExceptin
     * @author Lim JinYoung
     */
    public boolean checkOBLRlseByLcl(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        int yetCollectCnt  = 0;
        boolean isRcv = false;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckOBLRlseByLclRSQL(), param, velParam);

            if (dbRowset.next()) {
                yetCollectCnt = dbRowset.getInt(1);
            }

            //OBL 미 회수 메세지 전달 :
            if(yetCollectCnt > 0){
                isRcv = true;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isRcv;
    }

    /**
     * EDI 전송용 Flat File 생성을 위한 E-DO 정보를 조회 한다.<br>
     *
     * @param String rqstNo
     * @param String edoTpCd
     * @param String edoAckCd
     * @param String rejRmk
     * @return String flatFile
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public String searchEdoMstFlatFile(String rqstNo, String edoTpCd, String edoAckCd, String rejRmk) throws DAOException {
        DBRowSet dbRowset = null;
        String flatFile  = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("rqst_no"      , rqstNo);
            mapVO.put("edo_tp_cd"    , edoTpCd);
            mapVO.put("edo_ack_cd"   , edoAckCd);
            mapVO.put("edo_rjct_rsn" , JSPUtil.getNull(rejRmk));

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            //자가운송 요청 동의서 승인 시
            if("5JK".equals(edoTpCd) && "A".equals(edoAckCd)){
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoMstFlatFile01RSQL(), param, velParam);
            }else{
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoMstFlatFile02RSQL(), param, velParam);
            }

            if (dbRowset.next()) {
                flatFile = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flatFile;
    }
    */

    /**
     * EDI 전송용 Flat File 생성을 위한 수하주 정보를 조회 한다.<br>
     *
     * @param String rqstNo
     * @param String edoTpCd
     * @param String edoPtyCd
     * @param String edoAckCd
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public String[] searchEdoPtyTrspFlatFile(String rqstNo, String edoTpCd, String edoPtyCd, String edoAckCd) throws DAOException {
//        DBRowSet dbRowset = null;
//        String[] shipper = null;
//        int idx = 0;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            mapVO.put("rqst_no"    , rqstNo);
//            mapVO.put("edo_tp_cd"  , edoTpCd);
//            mapVO.put("edo_pty_cd" , edoPtyCd);
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            if("5JK".equals(edoTpCd) && "A".equals(edoAckCd)){
//                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile01RSQL(), param, velParam);
//            }else{
//                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile02RSQL(), param, velParam);
//            }
//
//            shipper = new String[dbRowset.getRowCount()];
//            while (dbRowset.next()) {
//                shipper[idx++] = dbRowset.getString(1);
//            }
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return shipper;
//    }

    /**
     * EDO 요청으로접수된 CONTAINER 정보를 조회한다.<br>
     *
     * @param String rqstNo
     * @param String edoTpCd
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public String[] searchEdoCntrFlatFile(String rqstNo, String edoTpCd) throws DAOException {
        DBRowSet dbRowset = null;
        String[] cntrs = null;
        int idx = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("rqst_no" , rqstNo);
            mapVO.put("edo_Tp_Cd" , edoTpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL(), param, velParam);
            cntrs = new String[dbRowset.getRowCount()];
            while (dbRowset.next()) {
                cntrs[idx++] = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntrs;
    }
    */

    /**
     * EDI 전송용 Flat File 생성을 위한 보세운송 요청 정보를 가져온다.<br>
     *
     * @param String rqstNo
     * @param String edoTpCd
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public String[] searchEdoIbdTrspFlatFile(String rqstNo, String edoTpCd) throws DAOException {
        DBRowSet dbRowset = null;
        String[] bonds = null;
        int idx = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("rqst_no" , rqstNo);
            mapVO.put("edo_Tp_Cd" , edoTpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL(), param, velParam);
            bonds = new String[dbRowset.getRowCount()];
            while (dbRowset.next()) {
                bonds[idx++] = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bonds;
    }
    */

    /**
     * EDI로 DO 발급신청 승인정보를 전송 한 후  관련 정보를 Update 한다.<br>
     *
     * @param String rqstNo
     * @param String edoTpCd
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public void modifyEdoDoByIssue(String rqstNo, String edoTpCd, SignOnUserAccount account) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            //사용자의 세션정보를 세팅한다.
//            mapVO.put("rqst_no", rqstNo);
//            mapVO.put("edo_tp_cd", edoTpCd);
//            mapVO.put("edo_iss_ofc_cd", account.getOfc_cd());
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDoByIssueUSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                    throw new DAOException("Fail to insert SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * EDI로  e-DO Transmit을 수행한 후 관련 정보를 Update 한다.<br>
     *
     * @param BkgEdoMstVO edoMst
     * @param String edoTpCd
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public void modifyEdoMstByTrans(BkgEdoMstVO edoMst, String edoTpCd, SignOnUserAccount account) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            //사용자의 세션정보를 세팅한다.
//            mapVO.put("edo_ack_cd"     , edoMst.getEdoAckCd());
//            mapVO.put("edo_ack_usr_id" , account.getUsr_id());
//            mapVO.put("edo_ack_ofc_cd" , account.getOfc_cd());
//            mapVO.put("edo_rjct_rsn"   , edoMst.getEdoRjctRsn());
//            mapVO.put("rqst_no"        , edoMst.getEdoRqstNo());
//            mapVO.put("edo_tp_cd"      , edoTpCd);
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoMstByTransUSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                    throw new DAOException("Fail to insert SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * EDI 전송용 Flat File 생성을 위한 Booking Container 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @param String rqstNo
     * @return YardInfoVO ydInfo
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public YardInfoVO searchYdInfoByEdoTrans(String bkgNo, String rqstNo) throws DAOException {
//        DBRowSet dbRowset = null;
//        YardInfoVO ydInfo = null;
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try {
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            mapVO.put("bkg_no", bkgNo);
//            mapVO.put("mf_ref_no", rqstNo);
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchYdInfoByEdoTransRSQLRSQL(), param, velParam);
//
//            if(dbRowset.getRowCount() > 0){
//                ydInfo = (YardInfoVO)RowSetUtil.rowSetToVOs(dbRowset, YardInfoVO.class ).get(0);
//            }
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return ydInfo;
//    }

    /**
     * EDI 전송용 Flat File 생성을 위한 Edo Trans 파일을 검색한다.<br>
     *
     * @param String bkgNo
     * @return EdoTransVO edoTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public EdoTransVO searchBkgInfoByEdoTrans(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        EdoTransVO edoTrans = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgInfoByEdoTransRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                edoTrans = (EdoTransVO)RowSetUtil.rowSetToVOs(dbRowset, EdoTransVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return edoTrans;
    }
    */

    /**
     * Booking Container Count 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return int cnt
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int searchBkgCntrCnt(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        int cnt  = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgCntrCntRSQL(), param, velParam);

            if (dbRowset.next()) {
                cnt = dbRowset.getInt(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }

    /**
     * Booking Container 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<EdoTransCntrInfoVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    /*
    public List<EdoTransCntrInfoVO> searchBkgCntrInfoByEdoTrans(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<EdoTransCntrInfoVO> edoTransCntrInfos = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL(), param, velParam);
            edoTransCntrInfos = (List)RowSetUtil.rowSetToVOs(dbRowset, EdoTransCntrInfoVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return edoTransCntrInfos;
    }
    */

    /**
     * EDI로 E-DO Transmit을 수행한 후 관련 정보를 Update 한다.<br>
     *
     * @param String rqstNo
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
//    public void modifyEdoDoByTrans(String rqstNo, SignOnUserAccount account) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result =0;
//        try {
//            Map<String, String> mapVO = new HashMap<String, String>();
//
//            //사용자의 세션정보를 세팅한다.
//            mapVO.put("edo_trsm_usr_id " , account.getUsr_id());
//            mapVO.put("rqst_no"          , rqstNo);
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("");
//            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDoByTransUSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED)
//                throw new DAOException("Fail to insert SQL");
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * EDO 승인 요청에 대한 접수처리 후 KT-NET EDI 전송에 대한 Ack 정보를 업데이트 한다.<br>
     *
     * @param String rqstNo 수신받은 EDO 요청 번호
     * @param String ackInd 외부 파트너로부터 전송받은 DO 상태코드 (A:정상, D:무시, E:error, L:재 전송)
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyEdoDoByAck(String rqstNo, String ackInd) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("rqst_no", rqstNo);
            mapVO.put("edo_xter_prnr_ack_cd" , ackInd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDoByAckUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 해당 선화 증권 번호에 해당하는 POD(화물을 양하할 Port)코드를 조회 합니다.<br>
     *
     * @param String blNo 선화증권 번호
     * @return String edoRqstSeq
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchPodCd(String blNo) throws DAOException {

        DBRowSet dbRowset = null;

        String podCd =""; //Port Of Discharge

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bl_no", blNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchPodCdRSQL(), param, velParam);

            if (dbRowset.next()) {
                podCd = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return podCd;
    }

    /**
     * 해당 EDO 요청 번호에 해당하는 Max SEQUENCE를 채번한다.<br>
     *
     * @param String rqstNo EDO 요청 번호
     * @return String podCd
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdoMaxRqstSeq(String rqstNo) throws DAOException {

        DBRowSet dbRowset = null;

        String edoRqstSeq = ""; //EDO 요청 번호에 DO 발행에 따른 전송 SEQUENCE

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("edo_rqst_seq", rqstNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoMaxRqstSeqRSQL(), param, velParam);

            if (dbRowset.next()) {
                edoRqstSeq = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return edoRqstSeq;
    }

    /**
     * EDI 수신 메인 정보를 입력한다.<br>
     *
     * @param BkgEdoMstVO edoMst
     * @param String edoRqstSeq
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoMst(BkgEdoMstVO edoMst, String edoRqstSeq, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoMst.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("cre_usr_id"   , "ESM_BKG_B024");
            mapVO.put("upd_usr_id"   , "ESM_BKG_B024");
            mapVO.put("edo_rqst_seq" , edoRqstSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoMstCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * DO 발급요청 정보 입력<br>
     *
     * @param BkgEdoDoVO edoDo
     * @param String edoRqstSeq
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoDo(BkgEdoDoVO edoDo, String edoRqstSeq, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoDo.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("cre_usr_id"   , "ESM_BKG_B024");
            mapVO.put("upd_usr_id"   , "ESM_BKG_B024");
            mapVO.put("edo_rqst_seq" , edoRqstSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoDoCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 보세운송 동의요청 입력.<br>
     *
     * @param BkgEdoIbdTrspVO edoIbdTrsp
     * @param String rqstSeq
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoIbdTrsp(BkgEdoIbdTrspVO edoIbdTrsp, String rqstSeq, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoIbdTrsp.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("cre_usr_id"   , "ESM_BKG_B024");
            mapVO.put("upd_usr_id"   , "ESM_BKG_B024");
            mapVO.put("edo_rqst_seq" , rqstSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoIbdTrspCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 자가운송 신청 입력.<br>
     *
     * @param BkgEdoSelfTrspVO edoSelfTrsp
     * @param String edoRqstSeq
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoSelfTrsp(BkgEdoSelfTrspVO edoSelfTrsp, String edoRqstSeq, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoSelfTrsp.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("cre_usr_id"   , "ESM_BKG_B024");
            mapVO.put("upd_usr_id"   , "ESM_BKG_B024");
            mapVO.put("edo_rqst_seq" , edoRqstSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoSelfTrspCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 입력한다.<br>
     *
     * @param List<BkgEdoPtyTrspVO> edoPtyTrsp
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoPtyTrsp(List<BkgEdoPtyTrspVO> edoPtyTrsp) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(edoPtyTrsp.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoPtyTrspCSQL(), edoPtyTrsp,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 컨테이너 정보를 입력한다.<br>
     *
     * @param List<BkgEdoCntrVO> edoCntr
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoCntr(List<BkgEdoCntrVO> edoCntr) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(edoCntr.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoCntrCSQL(), edoCntr,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * EDO로그 입력.<br>
     *
     * @param BkgEdoLogVO edoLog
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addEdoLog(BkgEdoLogVO edoLog) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoLog.getColumnValues();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("cre_usr_id"   , "ESM_BKG_B023");
            mapVO.put("upd_usr_id"   , "ESM_BKG_B023");

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdoLogCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG_DO 테이블에  SELF_TRNS_FLG를 Y 혹은 N으로 세팅.<br>
     *
     * @param String bkgNo    : 선적예약 요청 번호
     * @param String selfTrnsFlg  : Self Trans To TMNL 체크 여부
     * @param String userId   : 로그인 사용자 Id
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyKorDoSelfTransFlg(String bkgNo, String selfTrnsFlg, String userId) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"        , bkgNo);
            mapVO.put("self_trns_flg" , selfTrnsFlg);
            mapVO.put("upd_usr_id"    , userId);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyKorDoSelfTransFlgUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * EDI로 DO 발급신청 승인정보를 전송 한 후 관련 정보(사업자 등록 번호 갱신)를 Update 한다.<br>
     *
     * @param String bkgNo
     * @exception DAOException
     * @author YHYUN
     */
    public void modifyKorDoRcvrBizNo(String bkgNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
        	  Map<String, String> mapVO = new HashMap<String, String>();
        	  mapVO.put("bkg_no" , bkgNo);
        	  
              param.putAll(mapVO);
              velParam.putAll(mapVO);

              SQLExecuter sqlExe = new SQLExecuter("");
              result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyKorDoRcvrBizNoUSQL(), param, velParam);
              if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * EDI ID 조회한다.<br>
     *
     * @param String discLocCd
     * @return BkgHrdCdgCtntVO hrdCDdgCtnt
     * @exception DAOException
     * @author Lim JinYoung
     */
    public BkgHrdCdgCtntVO searchKorDoEdiId(String discLocCd) throws DAOException {
        DBRowSet dbRowset = null;
        BkgHrdCdgCtntVO hrdCDdgCtnt = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("disc_loc_cd" , discLocCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorDoEdiIdRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                hrdCDdgCtnt = (BkgHrdCdgCtntVO)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return hrdCDdgCtnt;
    }

    /**
     * Do Reference 정보 조회.<br>
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @param String doType
     * @return String doBlInfo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiKorDoBlInfo(String bkgNo, String doType) throws DAOException {
        String doBlInfo ="";
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"  , bkgNo);
            mapVO.put("do_type" , doType);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiKorDoBlInfoRSQL(), param, velParam);

            if (dbRowset.next()) {
                doBlInfo = dbRowset.getString(1);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doBlInfo;
    }

    /**
     * Booking Container 정보를 조회한다.<br>
     *
     * @param String bkgNo 선적예약 요청 번호
     * @param String doType
     * @return String[] cntr
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiKorDoCntrInfo(String bkgNo, String doType) throws DAOException {
        DBRowSet dbRowset = null;
        String[] cntr = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"  , bkgNo);
            mapVO.put("do_type" , doType);

            param.putAll(mapVO);

            velParam.putAll(mapVO);

            //dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL(), param, velParam);
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiKorDoCntrInfoRSQL(), param, velParam);

            int cnt = dbRowset.getRowCount();
            cntr = new String[cnt];
            int idx = 0;
            while(dbRowset.next()){
                cntr[idx] = dbRowset.getString(1);
                idx++;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntr;
    }

    /**
     * 이전에 생성된 D/O No를 조회한다.<br>
     *
     * @param String bkgNo 선적예약 요청 번호
     * @return String doNo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchDoNo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;

        String doNo ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoNoRSQL(), param, velParam);

            if (dbRowset.next()) {
                doNo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doNo;
    }

    /**
     * 일본세관 신고를 위한 B/L INFO를 조회한다.<br>
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @return JapCstmsVO japCstms
     * @exception DAOException
     * @author Lim JinYoung
     */
    public JapCstmsVO searchJapCstmsInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        JapCstmsVO japCstms = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapCstmsInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                japCstms = (JapCstmsVO)RowSetUtil.rowSetToVOs(dbRowset, JapCstmsVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return japCstms;
    }

    /**
     * Dor Interface 발행 실적 및 상태정보를 조회한다.
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @param String rlseSeq : D/O 단위의 Sequenc
     * @return JapDorStatusVO
     * @exception DAOException
     * @author Lim JinYoung
     */
    public JapDorStatusVO searchJapDorStatus(String bkgNo, String rlseSeq) throws DAOException {
        DBRowSet dbRowset = null;

        JapDorStatusVO japDorStatus = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);
            mapVO.put("rlse_seq", rlseSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapDorStatusRSQL(), param, velParam);

             if(dbRowset.getRowCount() > 0){
                japDorStatus = (JapDorStatusVO)RowSetUtil.rowSetToVOs(dbRowset, JapDorStatusVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return japDorStatus;
    }

    /**
     * DOR I/F된 DOR들 중 DOR Transmit이 되지 않은 B/L의 개수.<br>
     * Japan D/O은 10개 단위로 묶어서  일괄 전송하므로 Temp에 쌓여있는 전송 대상을 Count한다.
     * @return Integer
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int searchJapDorStowageCnt() throws DAOException {
        DBRowSet dbRowset = null;
        int cnt  = 0;

        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapDorStowageCntRSQL(), null, null);

            if (dbRowset.next()) {
                cnt = dbRowset.getInt(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }

    /**
     * D/O Release Reference 정보를 수정한다.
     *
     * @param BkgDoRefVO bkgDoRef 데이터객체
     * @return int
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int modifyDoRef(BkgDoRefVO bkgDoRef) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoRef.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyDoRefUSQL(), param, velParam);

            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * D/O Release Reference 정보를 생성 한다.
     *
     * @param BkgDoRefVO bkgDoRef 데이터객체
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addDoRef(BkgDoRefVO bkgDoRef) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoRef.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
     
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddDoRefCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 전송될 대상으로 JPCUS_SLOG Table에 Insert 한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans 데이터객체
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addJapDorTmp(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddJapDorTmpCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 전송 대상 항목으로 상태로 변경한다. (Locking)
     *
     * @param JapDorEdiTransVO japDorEdiTrans 데이터객체
     * @return int
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int modifyJapDorStsByReqest(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyJapDorStsByReqestUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Japan D/O를 10개 단위로 묶어서  일괄 전송 할 그룹번호를 채번한다.
     * @return String grpNo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchJapDorNextGrpNo() throws DAOException {
        DBRowSet dbRowset = null;
        String grpNo = "";

        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapDorNextGrpNoRSQL(), null, null);

            if (dbRowset.next()) {
                grpNo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return grpNo;
    }

    /**
     * 전송 대상 항목으로 상태로 변경한다. (Locking)
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyJapDorTmpStsByTrans(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyJapDorTmpStsByTransUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Japan EDI전송을 위한 해더 정보를 조회한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiSeanaccsHeader(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;

        String header ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsHeaderRSQL(), param, velParam);

            if (dbRowset.next()) {
                 header = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return  header;
    }

    /**
     * Japan EDI전송을 정보를 조회한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiSeanaccsCommon(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;

        String common ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        //사용하지 않는 변수일 경우 주석처리 필수.
        //  String usr_id = "1ASA2001";
        //  String usr_pwd = "NACCSTST";
          String usr_id = "1ASLDC0A";
          String usr_pwd = "2FHJERGN";        

        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            mapVO.put("usr_id", usr_id);
            mapVO.put("usr_pwd", usr_pwd);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonRSQL(), param, velParam);

            if (dbRowset.next()) {
                 common = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return common;
    }

    /**
     * Japan EDI전송을 정보를 조회한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiSeanaccsBlInfoByTrans(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;

        String[] blInfo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByTransRSQL(), param, velParam);
            int cnt = dbRowset.getRowCount();
            blInfo = new String[cnt];
            int idx = 0;
            while(dbRowset.next()){
                blInfo[idx] = dbRowset.getString(1);
                idx++;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blInfo;
    }

    /**
     * 전송 대상 항목으로 상태로 변경한다. ( Locking )
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyJapDorStsByTrans(JapDorEdiTransVO japDorEdiTrans) throws DAOException {

        //전송 요청일 경우 ( DOR I/F ) : Status = 'R' -- 전송 결과에 따라 피드백 방안 필요.
        //취소 요청일 경우 ( DOR I/F ) : Ststus = 'C' -- 실제 완료 되면 Null 로 변경
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyJapDorStsByTransUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans 데이터객체
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addJapDorHistoryByTrans(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddJapDorHistoryByTransCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Japan EDI History 조회
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return List<BkgNtcHisVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<BkgNtcHisVO> searchJapDorEdiHistoryByTrans(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgNtcHisVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByTransRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Japan EDI전송을 위한 해더 정보를 조회한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiSeanaccsCommonByCancel(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;

        String header ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        //사용하지 않는 변수일 경우 주석처리 필수.
     //     String usr_id = "1ASA2001";
     //     String usr_pwd = "NACCSTST";
          String usr_id = "1ASLDC0A";
          String usr_pwd = "2FHJERGN";       

        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();
            
            mapVO.put("usr_id", usr_id);
            mapVO.put("usr_pwd", usr_pwd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonByCancelRSQL(), param, velParam);

            if (dbRowset.next()) {
                 header = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return  header;
    }
    
    /**
     * Japan EDI전송을 정보를 조회한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiSeanaccsBlInfoByCancel(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;

        String[] blInfo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByCancelRSQL(), param, velParam);
            int cnt = dbRowset.getRowCount();
            blInfo = new String[cnt];
            int idx = 0;
            while(dbRowset.next()){
                blInfo[idx] = dbRowset.getString(1);
                idx++;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blInfo;
    }

    /**
     * 해당 BKG_NO, RLSE_SEQ를  기준으로 가장 최근에 Status 정보를 삭제한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @param String rlseStsCd
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void removeDoDtlByCancel(String bkgNo, String rlseSeq, String rlseStsCd) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);
            mapVO.put("rlse_seq", rlseSeq);
            mapVO.put("rlse_sts_cd", rlseStsCd);

            param.putAll(mapVO); velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoDtlByCancelDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 해당 DO No에 해당하는 Bkg No 정보를 조회한다.
     *
     * @param String doNo
     * @return BkgDoVO Korea D/O Reference 정보
     * @exception DAOException
     * @author Lim JinYoung
     */
    public BkgDoVO searchDoInfo(String doNo) throws DAOException {
        DBRowSet dbRowset = null;
        BkgDoVO doInfo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("do_no", doNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() == 1){
                doInfo = (BkgDoVO)RowSetUtil.rowSetToVOs(dbRowset, BkgDoVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doInfo;
    }

    /**
     * Japan Do Id 정보를 Update 한다.<br>
     *
     * @param JapDorStatusVO japDorStatus 데이터객체 배열
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyJapDoId(JapDorStatusVO japDorStatus) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorStatus.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyJapDoIdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * EDI로 전송을 요청한 상태 코드를 CANCEL(X) 상태로 변경한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans 데이터객체 배열
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyJapDorCancel(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyJapDorCancelUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Japan Edi History 저장 by cancel
     * @param JapDorEdiTransVO japDorEdiTrans
     * @return List<BkgBkgNtcHisVONtcHisVO>
     * @exception DAOException
     * @author Lim JinYoung
     */
    public List<BkgNtcHisVO> searchJapDorEdiHistoryByCancel(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgNtcHisVO> bkgNtcHis = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByCancelRSQL(), param, velParam);

            //if(dbRowset.getRowCount() == 1){
            //    bkgNtcHis = (BkgNtcHisVO)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class ).get(0);
            //}
            bkgNtcHis = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgNtcHis;
    }

    /**
     * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.
     *
     * @param JapDorEdiTransVO japDorEdiTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void addJapDorHistoryByRequest(JapDorEdiTransVO japDorEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = japDorEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddJapDorHistoryByRequestCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Japan D/O EDI 전송 시 이벤트 코드를 구해온다.<br>
     *
     * @param String evntCd : 이벤트코드
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiSeanaccsEventType(String evntCd) throws DAOException {
        DBRowSet dbRowset = null;
        String result  = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("evnt_cd" , evntCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiSeanaccsEventTypeRSQL(), param, velParam);

            if (dbRowset.next()) {
                result = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Kor D/O EDI 이력을 저장하기 위한 정보를 조회한다.<br>
     *
     * @param KorDoEdiTransVO korDoEdiTrans
     * @return BkgNtcHisVO
     * @exception DAOException
     * @author Lim JinYoung
     */
    public BkgNtcHisVO searchKorEdiHistory(KorDoEdiTransVO korDoEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        BkgNtcHisVO bkgNtcHis = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = korDoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchKorEdiHistoryRSQL(), param, velParam);

            if(dbRowset.getRowCount() == 1){
                bkgNtcHis = (BkgNtcHisVO)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgNtcHis;
    }

    /**
     * EDO 전송을 위한 헤더 정보를 조회한다.<br>
     * @return String ediGenresHeader
     * @exception DAOException
     */
    public String searchEdiEdoGenresHeader() throws DAOException {

        DBRowSet dbRowset = null;
        String ediGenresHeader  = "";

        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoGenresHeaderRSQL(), null, null);

            if (dbRowset.next()) {
                ediGenresHeader = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediGenresHeader;
    }

    /**
     * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 조회한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @return String ediGenresHeader
     * @exception DAOException
     */
    public String searchEdiEdoGenresMst(EdoEdiTransVO edoEdiTrans) throws DAOException {

        DBRowSet dbRowset = null;
        String ediGenresMst  = "";

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoGenresMstRSQL(), param, velParam);

            if (dbRowset.next()) {
                ediGenresMst = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediGenresMst;
    }

    /**
     * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 조회한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @return String ediGenresPtyTrsp
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiEdoGenresPtyTrsp(EdoEdiTransVO edoEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        String ediGenresPtyTrsp  = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoGenresPtyTrspRSQL(), param, velParam);

            if (dbRowset.next()) {
                ediGenresPtyTrsp = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediGenresPtyTrsp;
    }

    /**
     * EDI로  DO 발급신청 승인정보를 전송 한 후  관련 정보(Issue Office 정보)를 Update 한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyEdoDoByGenresEdiTrans(EdoEdiTransVO edoEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            mapVO.put("edo_ack_usr_id", edoEdiTrans.getAcount().getUsr_id());
            mapVO.put("edo_iss_ofc_cd", edoEdiTrans.getAcount().getOfc_cd());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDoByGenresEdiTransUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
   

    /**
     * DO 발급신청서 관리 Main table국내에서  주로 사용되는 Table로 화물이 도착후 화주에게 인도 직전 KL_Net을 통해 화주는 보세운관련사항 중 Booking No를 관리한 EDI로  DO 발급신청 승인정보를 전송 한 후  관련 ACK 정보를 Update 한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyEdoMstByGenresEdiTrans(EdoEdiTransVO edoEdiTrans) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            mapVO.put("edo_ack_ofc_cd", edoEdiTrans.getAcount().getOfc_cd());
            mapVO.put("edo_ack_usr_id", edoEdiTrans.getAcount().getUsr_id());
            mapVO.put("edo_rjct_rsn"  , edoEdiTrans.getRejRmk());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoMstByGenresEdiTransUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * DO 발급신청서  Main 정보를 조회한다.searchEdiEdoCusagdEdoPtyTrsp
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @return String ediCusagdMst
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiEdoCusagdEdoMst(EdoEdiTransVO edoEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        String ediCusagdMst  = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoMstRSQL(), param, velParam);

            if (dbRowset.next()) {
                ediCusagdMst = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediCusagdMst;
    }

    /**
     * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 조회한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @return String ediCusagdMst
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiEdoCusagdEdoPtyTrsp(EdoEdiTransVO edoEdiTrans) throws DAOException {
        DBRowSet dbRowset         = null;
        String[] ediCusagdPtyTrsp = null;
        int idx = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoPtyTrspRSQL(), param, velParam);
            
            ediCusagdPtyTrsp = new String[dbRowset.getRowCount()];
            
            while (dbRowset.next()) {            
                ediCusagdPtyTrsp[idx++] = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediCusagdPtyTrsp;
    }

    /**
     * EDO 요청으로접수된 CONTAINER 정보를 조회한다.<br>
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @return String[]
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiEdoCusagdEdoCntr(EdoEdiTransVO edoEdiTrans) throws DAOException {
        DBRowSet dbRowset = null;
        String[] ediCusagdCntr = null;
        int idx = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoCntrRSQL(), param, velParam);
            ediCusagdCntr = new String[dbRowset.getRowCount()];
            while (dbRowset.next()) {
                ediCusagdCntr[idx++] = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediCusagdCntr;
    }

    /**
     * DO 발급신청서  Main 정보를 조회한다.searchEdiEdoCusagdEdoPtyTrsp
     *
     * @param String bkgNo
     * @param String callModule
     * @return String ediEdoCusagdDoMst
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchEdiEdoCusagdDoMst(String bkgNo, String callModule) throws DAOException {
        DBRowSet dbRowset = null;
        String ediEdoCusagdDoMst  = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);
            mapVO.put("call_module", callModule);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoMstRSQL(), param, velParam);

            if (dbRowset.next()) {
                ediEdoCusagdDoMst = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediEdoCusagdDoMst;
    }

    /**
     * Booking Container 정보를 조회한다.
     *
     * @param String bkgNo
     * @return String ediCusagdMst
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String[] searchEdiEdoCusagdDoCntr(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        String[] ediEdoCusagdDoCntr  = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL(), param, velParam);

            int idx = 0;
            ediEdoCusagdDoCntr = new String[dbRowset.getRowCount()];
            
            while(dbRowset.next()){
            	ediEdoCusagdDoCntr[idx++] = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediEdoCusagdDoCntr;
    }

    /**
     * EDI로  e-DO Transmit을 수행한 후 관련 정보를 Update 한다.
     *
     * @param EdoEdiTransVO edoEdiTrans
     * @param String callModule
     * @exception DAOException
     * @author Lim JinYoung
     */
    public void modifyEdoDoByCusagdDoEdiTrans(EdoEdiTransVO edoEdiTrans, String callModule) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
            
        try {
            Map<String, String> mapVO = edoEdiTrans.getColumnValues();
    
            mapVO.put("edo_trsm_usr_id", "DEMDET".equals(callModule)?"EES_DMT_B001":edoEdiTrans.getAcount().getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDoByCusagdDoEdiTransUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
/* ************************************************************************************** */
/* Author :Lim JinYoung End                                                               */
/* ************************************************************************************** */

/* ************************************************************************************** */
/* Author :Park SungHo Start                                                              */
/* ************************************************************************************** */
    /**
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void receiveOtsLog(String modName, String applInfo, String logDesc) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
    		Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("mod_name",  modName);
			mapVO.put("appl_info", applInfo);
			mapVO.put("log_desc",  logDesc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeSP((ISQLTemplate)new CargoReleaseOrderDBDAOReceiveOtsLogCSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
    /**
     * [FNS071]VVD별 EDI연동 Master 수정
     * @param BkgOutstandingVO ots
     * @return int
     * @exception DAOException
     */
    public int mergeOts(BkgOutstandingVO ots) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = ots.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOMergeOtsUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
        //	se.printStackTrace();
          log.error("mergeOts "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
          log.error("mergeOts "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * VVD별 EDI연동 Detail 저장<br>
     * @param BkgOtsDtlVO otsDtlVO
     * @return int
     * @exception DAOException
     */
    public int mergeOtsDtl(BkgOtsDtlVO otsDtlVO) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = otsDtlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOMergeOtsDtlUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
            log.error("mergeOtsDtl "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
             log.error("mergeOtsDtl "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
   
    /**
     * OTS Us Cgo 검색
     * @param BkgOutstandingVO ots
     * @return FrtCltLstVO
     * @exception DAOException
     */
    public FrtCltLstVO searchBkbcOtsUsCgo(BkgOutstandingVO ots) throws DAOException {
        DBRowSet dbRowset = null;
        List<FrtCltLstVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = ots.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            //log.debug("-------- "+searchvo.getBlNo());

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcOtsUsCgoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, FrtCltLstVO.class);
            //2010.01.05 값이 없을경우  빈VO 생성
            if(listVOs.size() < 1){
            	listVOs.add(new FrtCltLstVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * [0909] 조회 Master
     * @param UsCgoRlseSearchVO cgoRlseSearch
     * @return List<UsCgoRlseListVO>
     * @exception DAOException
     */
    public List<UsCgoRlseListVO> searchUsCgoRlseList(UsCgoRlseSearchVO cgoRlseSearch) throws DAOException {
        DBRowSet dbRowset = null;
        List<UsCgoRlseListVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = cgoRlseSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            //log.debug("-------- "+searchvo.getBlNo());
            if(cgoRlseSearch.getBlNo().trim().length() > 0){
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchUsCgoRlseList1RSQL(), param, velParam);
            }else {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL(), param, velParam);
            }



            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseListVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }

    /**
     * [0909] 조회 Detail
     * @param String bkgNo
     * @return List<BkgContainerVO>
     * @exception DAOException
     */
    public List<BkgContainerVO> searchUsCgoRlseFoc(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgContainerVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();
            mapVO.put("bkg_no",bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchUsCgoRlseFocRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    /**
     * [0909] save 수정
     * @param DoRefVO cgoRlseManageRmk
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyHoldRmkDoRef (DoRefVO cgoRlseManageRmk,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageRmk.getColumnValues();

            mapVO.put("cre_usr_id", account.getUsr_id());
            mapVO.put("upd_usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyHoldRmkDoRefUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * [0909] save 추가
     * @param DoRefVO cgoRlseManageRmk
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addHoldRmkDoRef (DoRefVO cgoRlseManageRmk,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageRmk.getColumnValues();

            mapVO.put("cre_usr_id", account.getUsr_id());
            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddHoldRmkDoRefCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * Hold 관련 B/L 조회
     * @param String blNo
     * @return List<DoRefVO>
     * @exception DAOException
     */
    public List<DoRefVO> searchHoldFlgPrtBl(String blNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<DoRefVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();
            mapVO.put("bl_no",blNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchHoldFlgPrtBlRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DoRefVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }

    /**
     * [0909] hold 수정
     * @param DoRefVO doRefVo
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyHoldFlgDoRef (DoRefVO doRefVo,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doRefVo.getColumnValues();

            mapVO.put("cre_usr_id", account.getUsr_id());
            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyHoldFlgDoRefUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * [0909] hold추가
     * @param DoRefVO cgoRlseManageRmk
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addHoldFlgDoRef (DoRefVO cgoRlseManageRmk,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageRmk.getColumnValues();

            mapVO.put("cre_usr_id", account.getUsr_id());
            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddHoldFlgDoRefCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * [0909] BKG_CGO_RLSE UPDATE.
     * @param BkgCgoRlseVO cgoRlseManageEdi
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyUsCgoRlseEdi(BkgCgoRlseVO cgoRlseManageEdi,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageEdi.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("usr_ofc_cd", account.getOfc_cd());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyUsCgoRlseEdiUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * [0909]BKG_CGO_RLSE UPDATE SUCCESS이면, BKG_CGO_RLSE_HIS UPDATE.
     * @param BkgCgoRlseVO cgoRlseManageEdi
     * @param SignOnUserAccount account
     * @param String eventId 
     * @param String eventNm
     * @return int
     * @exception DAOException
     */
    public int addUsCgoRlseHisEdi(BkgCgoRlseVO cgoRlseManageEdi,SignOnUserAccount account,String eventId, String eventNm) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageEdi.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("ofc_cd", account.getOfc_cd());
            mapVO.put("event_id", eventId);
            mapVO.put("event_nm", eventNm);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddUsCgoRlseHisEdiCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 1
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchBLInfo(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBLInfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 2
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchLocalIpiStatus(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();


            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 3
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
//    public UsCgoRlseBkbcBlVO searchYardInfo(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
//        DBRowSet dbRowset = null;
//        List<UsCgoRlseBkbcBlVO> listVOs = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchYardInfoRSQL(), param, velParam);
//            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
//            if(listVOs.size() < 1){
//                listVOs.add(new UsCgoRlseBkbcBlVO());
//            }
//
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return listVOs.get(0);
//
//    }

    /**
     * US Cargo Release
     * BackEndBc Model No. 4
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchYdTmlnfo(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 5
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbcBlVo
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchCstmsDpCd(UsCgoRlseBkbcBlVO usCgoRlseBkbcBlVo) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcBlVo.getColumnValues();


            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCstmsDpCdRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 6
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchCrEdiResult (UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCrEdiResultRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);

            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }


        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 7
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcBlVO searchPrtlBl(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchPrtlBlRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 8
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcBlVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public UsCgoRlseBkbcBlVO searchOldNewFocFlg(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchOldNewFocFlgRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 19
     * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
     * @return UsCgoRlseBkbcSceVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public UsCgoRlseBkbcSceVO searchSceMsgIdCnt(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcSceVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchSceMsgIdCntRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcSceVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcSceVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);

    }
    /**
     * US Cargo Release
     * BackEndBc Model No. 29
     * @param UsCgoRlseBkbcFocVO vo
     * @param SignOnUserAccount account
     * @return int
     */
    public int addUsCgoRlsLogSceRslt(UsCgoRlseBkbcFocVO vo,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            mapVO.put("usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddUsCgoRlsLogSceRsltCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * US Cargo Release
     * BackEndBc Model No. 30
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFocVo
     * @param SignOnUserAccount account
     * @return int
     */
    public int modifyUsCgoRlsHisSceRslt(UsCgoRlseBkbcFocVO usCgoRlseBkbcFocVo,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = usCgoRlseBkbcFocVo.getColumnValues();

            mapVO.put("usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyUsCgoRlsHisSceRsltUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }


    /**
     * US Cargo Release_Event1
     * Event_1 Model No. 2
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public UsCgoRlseBkbcFocVO searchEdiRcvSndIdCr (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiRcvSndIdCrRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * US Cargo Release_Event1
     * CT Case Event_1 Model No. 2
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public UsCgoRlseBkbcFocVO searchEdiRcvSndIdCt (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 3
     * searchEdiRcvSndIdCa ( [in] blNo : String , [in] ediKnd : String ) : String
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchEdiRcvSndIdCa (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiRcvSndIdCaRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 4
     * searchEdiRcvSndIdHld ( [in] blNo : String , [in] ediKnd : String ) : String
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public UsCgoRlseBkbcFocVO searchEdiRcvSndIdHld (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiRcvSndIdHldRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 5
     * searchCustCode ( [in] ediRcvId , [in] ediSndId ) : String
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchCustCode (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCustCodeRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }

    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 6
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchIbdBkgInfo(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchIbdBkgInfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }

    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 7
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchVskInfo (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = new ArrayList<UsCgoRlseBkbcFocVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchVskInfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }

    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 9
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchOldNewFocFlg(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchOldNewFocFlgRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }

    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 12
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return UsCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public UsCgoRlseBkbcFocVO searchPoLocSlan(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();
            mapVO.put("ofc_cd",account.getOfc_cd());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchPoLocSlanRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new UsCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 14
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return List<UsCgoRlseBkbcFlatFileVO>
     * @exception DAOException
     *
     */
    public List<UsCgoRlseBkbcFlatFileVO> searchCstmsMkFile(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFlatFileVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCstmsMkFileRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFlatFileVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 15
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return List<UsCgoRlseBkbcFlatFileVO>
     * @exception DAOException
     *
     */
    public List<UsCgoRlseBkbcFlatFileVO> searchVvdMkFile(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFlatFileVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchVvdMkFileRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFlatFileVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }

    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 21
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @return List<UsCgoRlseBkbcFlatFileVO>
     * @exception DAOException
     *
     */
    public List<UsCgoRlseBkbcFlatFileVO> searchBkgMkFile(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<UsCgoRlseBkbcFlatFileVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkgMkFileRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBkbcFlatFileVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 27
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int addUsCgoRlsLogRslt (UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            mapVO.put("usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddUsCgoRlsLogRsltCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 30
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int modifyUsCgoRlsHisRslt(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyUsCgoRlsHisRsltUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * US Cargo Release_Event1
     * BackEndBC Model No. 31
     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int modifyUsCgoRlsRslt(UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = usCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyUsCgoRlsRsltUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }
    //------------------------------
    // FOC 에서 호출되는 메소드들.
    //-------------------------------
    /**
     * FOC처리(Customs)
     * @param CstmsClrVO cstmsClr
     * @return CstmsClrVO
     * @exception DAOException
     */
    public CstmsClrVO searchBkbcCstms(CstmsClrVO cstmsClr) throws DAOException{
        DBRowSet dbRowset = null;
        List<CstmsClrVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = cstmsClr.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcCstmsRSQL(), param, velParam, true);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsClrVO.class);

            if(listVOs.size() < 1){
                listVOs.add(cstmsClr);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     *
     * @param CstmsClrVO cstmsClr
     * @return int
     * @exception DAOException
     */
    public int addBkbcCstmsUsCgoRlse (CstmsClrVO cstmsClr) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = cstmsClr.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }

    /**
     *
     * @param CstmsClrVO cstmsClr
     * @return int
     * @exception DAOException
     */
    public int modifyBkbcCstmsUsCgo(CstmsClrVO cstmsClr) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = cstmsClr.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyBkbcCstmsUsCgoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }

    /**
     *
     *  @param CstmsClrVO cstmsClr
     *  @return int
     *  @exception DAOException
     */
    public int addBkbcCstmsUsCgoRlseHis (CstmsClrVO cstmsClr) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = cstmsClr.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     *
     * @param CstmsClrVO cstmsClr
     * @return CstmsClrVO
     * @exception DAOException
     */
//    public CstmsClrVO searchBkbcMaxHisSeq(CstmsClrVO cstmsClr) throws DAOException{
//        DBRowSet dbRowset = null;
//        List<CstmsClrVO> listVOs = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = cstmsClr.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcMaxHisSeqRSQL(), param, velParam);
//            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsClrVO.class);
//
//            if(listVOs.size() < 1){
//                listVOs.add(cstmsClr);
//            }
//
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return listVOs.get(0);
//    }
    /**
     * FOC처리(Freight)
     * @param FrtCltLstVO frtCltLst
     * @return FrtCltLstVO
     * @exception DAOException
     */
    public FrtCltLstVO searchBkbcFrt(FrtCltLstVO frtCltLst) throws DAOException{
        DBRowSet dbRowset = null;
        List<FrtCltLstVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = frtCltLst.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcFrtRSQL(), param, velParam, true);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, FrtCltLstVO.class);

            if(listVOs.size() < 1){
                listVOs.add(frtCltLst);
            }
        } catch(NullPointerException se){
        	log.error("searchBkbcFrt null err " + se.toString(), se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(SQLException se){
            log.error("searchBkbcFrt "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("searchBkbcFrt "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
     * Cgo Rlse 정보를 입력한다.
     * @param FrtCltLstVO frtCltLst
     * @return int
     * @exception DAOException
     */
    public int addBkbcFrtUsCgoRlse (FrtCltLstVO frtCltLst) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = frtCltLst.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcFrtUsCgoRlseCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("addBkbcFrtUsCgoRlse"+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("addBkbcFrtUsCgoRlse"+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * Frt 정보를 수정한다.
     * @param FrtCltLstVO frtCltLst
     * @return int
     * @exception DAOException
     */
    public int modifyBkbcFrtUsCgo(FrtCltLstVO frtCltLst) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = frtCltLst.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyBkbcFrtUsCgoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("modifyBkbcFrtUsCgo "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("modifyBkbcFrtUsCgo "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * History 를 남긴다.
     * @param FrtCltLstVO frtCltLst
     * @return int
     * @exception DAOException
     */
    public int addBkbcFrtUsCgoRlseHis (FrtCltLstVO frtCltLst) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = frtCltLst.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcFrtUsCgoRlseHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("addBkbcFrtUsCgoRlseHis "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("addBkbcFrtUsCgoRlseHis "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * History 중 Max 값을 구한다.
     * @param FrtCltLstVO frtCltLst
     * @return FrtCltLstVO
     * @exception DAOException
     */
//    public FrtCltLstVO searchBkbcMaxHisSeq(FrtCltLstVO frtCltLst) throws DAOException{
//        DBRowSet dbRowset = null;
//        List<FrtCltLstVO> listVOs = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = frtCltLst.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcMaxHisSeqRSQL(), param, velParam);
//            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, FrtCltLstVO.class);
//
//            if(listVOs.size() < 1){
//                listVOs.add(frtCltLst);
//            }
//
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return listVOs.get(0);
//    }
    /**
     * FOC처리(OBL)
     * @param OblRdemVO oblRdem
     * @return OblRdemVO
     */
    public OblRdemVO searchBkbcObl(OblRdemVO oblRdem) throws DAOException{
        DBRowSet dbRowset = null;
        List<OblRdemVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = oblRdem.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcOblRSQL(), param, velParam,true);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, OblRdemVO.class);

            if(listVOs.size() < 1){
                listVOs.add(oblRdem);
            }

        }catch(NullPointerException se){
            log.error("##searchBkbcObl null##:"+oblRdem.getBlNo(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(SQLException se){
            log.error("searchBkbcObl "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("searchBkbcObl "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * CA FOC처리(OBL) 
     * @param OblRdemVO oblRdem
     * @return OblRdemVO
     */
    public OblRdemVO searchBkbCacObl(OblRdemVO oblRdem) throws DAOException{
        DBRowSet dbRowset = null;
        List<OblRdemVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = oblRdem.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcCaOblRSQL(), param, velParam,true);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, OblRdemVO.class);

            if(listVOs.size() < 1){
                listVOs.add(oblRdem);
            }

        }catch(NullPointerException se){
            log.error("##searchBkbcObl null##:"+oblRdem.getBlNo(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(SQLException se){
            log.error("searchBkbcObl "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("searchBkbcObl "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }    
    /**
     * O/B 에서 Event 발생시 Us Cgo Rlse 로 데이터 전송
     * @param FrtCltLstVO cltLstVO
     * @return int
     * @exception DAOException
     */
    public int addBkbcOblUsCgoRlse(FrtCltLstVO cltLstVO) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = cltLstVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("addBkbcOblUsCgoRlse "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("addBkbcOblUsCgoRlse "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
    /**
     * O/B 에서 Event 발생시 Us Cgo Rlse 로 데이터 전송
     * @param FrtCltLstVO cltLstVO
     * @return int
     * @exception DAOException
     */
    public int modifyBkbcOblUsCgo(FrtCltLstVO cltLstVO) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = cltLstVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyBkbcOblUsCgoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("modifyBkbcOblUsCgo "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("modifyBkbcOblUsCgo "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }
    /**
     * Cgo Rlse History를 기록한다.
     * @param FrtCltLstVO frtCltLst
     * @return int
     * @exception DAOException
     */
    public int addBkbcOblUsCgoRlseHis (FrtCltLstVO frtCltLst) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = frtCltLst.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddBkbcOblUsCgoRlseHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error("addBkbcOblUsCgoRlseHis "+se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error("addBkbcOblUsCgoRlseHis "+ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;

    }
//    /**
//     *
//     * @param OblRdemVO vo
//     * @return OblRdemVO
//     * @exception DAOException
//     */
//    public OblRdemVO searchBkbcMaxHisSeq(OblRdemVO oblRdem) throws DAOException{
//        DBRowSet dbRowset = null;
//        List<OblRdemVO> listVOs = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = oblRdem.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcMaxHisSeqRSQL(), param, velParam);
//            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, OblRdemVO.class);
//
//            if(listVOs.size() < 1){
//                listVOs.add(oblRdem);
//            }
//
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return listVOs.get(0);
//    }
    /**
     *
     * @param String blNo
     * @return FrtCltLstVO
     * @exception DAOException
     */
    public FrtCltLstVO searchBkbcFrtByObl(String blNo) throws DAOException{
        DBRowSet dbRowset = null;
        List<FrtCltLstVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bl_no",blNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBkbcFrtByOblRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, FrtCltLstVO.class);

            if(listVOs.size() < 1){
                listVOs.add(new FrtCltLstVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    /**
    * Original Bill of Lading Status 조회
    * @param String bkgNo
    * @param SignOnUserAccount account
    * @return UsCgoRlseBlStatusVO
    * @exception DAOException
    */
   public List<UsCgoRlseBlStatusVO> searchUsCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws DAOException{
       DBRowSet dbRowset = null;
       List<UsCgoRlseBlStatusVO> listVOs = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
           Map<String, String> mapVO = new HashMap<String, String>();
           mapVO.put("bkg_no",bkgNo);
           mapVO.put("usr_id",account.getUsr_id());
           param.putAll(mapVO);
           velParam.putAll(mapVO);

           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchUsCgoRlseBlStatusRSQL(), param, velParam);
           listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseBlStatusVO.class);

       }catch(SQLException se){
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage(), se);
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return listVOs;
   }

  

    /**
     * KT-NET을 통해 들어온 E-DO 승인 요청 정보에 대한 Ststus를 조회한다.<br>
     *
     * @param String bkgNo
     * @return EdoRqstStsVO
     * @exception DAOException
     */
    public EdoRqstStsVO searchEdoRqstSts(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        EdoRqstStsVO edoRqstSts = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdoRqstStsRSQL(), param, velParam);
          
            if(dbRowset.getRowCount() == 1){
                edoRqstSts = (EdoRqstStsVO)RowSetUtil.rowSetToVOs(dbRowset, EdoRqstStsVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return edoRqstSts;
    }

    /**
     * Cargo Release Order_E-D/O inquiry _Main 데이타 모델에 해당되는 값을 불러온다.<br>
     *
     * @param EdoSearchVO edoSearch 데이타 모델
     * @return List<EdoRqstsVO>
     * @exception DAOException
     */
    public List<EdoRqstsVO> searchEdoRqstList(EdoSearchVO edoSearch) throws DAOException {

        DBRowSet dbRowset = null;
        List<EdoRqstsVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(edoSearch != null){
                Map<String, String> mapVO = edoSearch.getColumnValues();

                mapVO.put("edo_pty_cd" , "MS");
                mapVO.put("mf_cfm_flg" , "Y");
                mapVO.put("mrn_bl_ts_cd" , "I");
                mapVO.put("cnt_cd" , "KR");             
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoRqstListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdoRqstsVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Cargo Release Order_E-D/O inquiry _Main 데이터를 단건으로 삭제한다.<br>
     *
     * @param List<EdoRqstsVO> edoRqstsVos 데이터객체 배열
     * @exception DAOException
     */
    public void removeEdoErrData(List<EdoRqstsVO> edoRqstsVos) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(edoRqstsVos.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOModifyEdoDelFlgUSQL(), edoRqstsVos,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG_EDO_MST 테이블을 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return BkgEdoMstVO
     * @exception DAOException
     */
    public BkgEdoMstVO searchEdoMst(String rqstNo, String tpCd) throws DAOException {
        DBRowSet dbRowset = null;
        BkgEdoMstVO bkgEdoMstVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rqstNo" , rqstNo);
            mapVO.put("tpCd" , tpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoMstRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                bkgEdoMstVO = (BkgEdoMstVO)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoMstVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgEdoMstVO;
    }

    /**
     * BKG_EDO_DO 테이블을 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return BkgEdoDoVO
     * @exception DAOException
     */
    public BkgEdoDoVO searchEdoDo(String rqstNo, String tpCd) throws DAOException {
        DBRowSet dbRowset = null;
        BkgEdoDoVO bkgEdoDoVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rqstNo" , rqstNo);
            mapVO.put("tpCd" , tpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoDoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                bkgEdoDoVO = (BkgEdoDoVO)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoDoVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgEdoDoVO;
    }

    /**
     * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return List<BkgEdoPtyTrspVO>
     * @exception DAOException
     */
    public List<BkgEdoPtyTrspVO> searchEdoPtyTrsp(String rqstNo, String tpCd ) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgEdoPtyTrspVO> bkgEdoPtyTrsps = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rqstNo" , rqstNo);
            mapVO.put("tpCd" , tpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoPtyTrspRSQL(), param, velParam);
            bkgEdoPtyTrsps = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoPtyTrspVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgEdoPtyTrsps;
    }
    /**
     * (주)한진으로 부터 EDI 수신된, 컨테이너별 자가운송 Party(업체정보)를 조회한다.<br>
     *
     * @param String rqstNo
     * @return List<SearchEdoCntrPtyTrspVO>
     * @exception DAOException
     */
    public List<SearchEdoCntrPtyTrspVO> searchEdoCntrPtyTrsp(String rqstNo) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<SearchEdoCntrPtyTrspVO> bkgEdoPtyTrsps = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try{
    		Map<String, String> mapVO = new HashMap();
    		
    		mapVO.put("rqstNo" , rqstNo);
    		
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoCntrPtyTrspRSQL(), param, velParam);
    		bkgEdoPtyTrsps = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEdoCntrPtyTrspVO.class);
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    	return bkgEdoPtyTrsps;
    }

    /**
     * BKG_EDO_LOG 테이블을 조회한다.<br>
     *
     * @param String rcvToDt
     * @param String rcvFmDt
     * @param String blNo
     * @return List<BkgEdoLogVO>
     * @exception DAOException
     */
    public List<BkgEdoLogVO> searchEdoTransLog(String rcvToDt, String rcvFmDt, String blNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgEdoLogVO> bkgEdoLogs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rcv_to_dt" , rcvToDt);
            mapVO.put("rcv_fm_dt" , rcvFmDt);
            mapVO.put("bl_no" , blNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoTransLogRSQL(), param, velParam);
            bkgEdoLogs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoLogVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgEdoLogs;
    }

    /**
     * BKG_EDO_IBD_TRSP 테이블을 조회한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @return BkgEdoIbdTrspVO
     * @exception DAOException
     */
    public BkgEdoIbdTrspVO searchEdoIbdTrsp(String rqstNo, String tpCd) throws DAOException {
        DBRowSet dbRowset = null;
        BkgEdoIbdTrspVO bkgEdoIbdTrsp = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rqstNo" , rqstNo);
            mapVO.put("tpCd" , tpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoIbdTrspRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                bkgEdoIbdTrsp = (BkgEdoIbdTrspVO)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoIbdTrspVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgEdoIbdTrsp;
    }

     /**
      * BKG_EDO_SELF_TRSP 테이블을 조회한다.<br>
      *
      * @param String rqstNo
      * @param String tpCd
      * @return BkgEdoSelfTrspVO
      * @exception DAOException
      */
     public BkgEdoSelfTrspVO searchEdoSelfTrsp(String rqstNo, String tpCd) throws DAOException {
         DBRowSet dbRowset = null;
         BkgEdoSelfTrspVO bkgEdoSelfTrsp = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap();

             mapVO.put("rqstNo" , rqstNo);
             mapVO.put("tpCd" , tpCd);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoSelfTrspRSQL(), param, velParam);

             if(dbRowset.getRowCount() > 0){
                 bkgEdoSelfTrsp = (BkgEdoSelfTrspVO)RowSetUtil.rowSetToVOs(dbRowset, BkgEdoSelfTrspVO.class ).get(0);
             }
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return bkgEdoSelfTrsp;
     }

    /**
     * BKG_DO_FOM 테이블을 조회한다.<br>
     *
     * @param String office
     * @return List<BkgDoFomVO>
     * @exception DAOException
     */
    public List<BkgDoFomVO> searchDoForm(String office) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgDoFomVO> bkgDoFoms = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("office" , office);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDoFormRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
               bkgDoFoms = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDoFomVO.class);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgDoFoms;
    }

     /**
      * BKG_DO_FOM 데이터를 단건으로 삭제한다.<br>
      *
      * @param String office
      * @param SignOnUserAccount account
      * @exception DAOException
      */
     public void removeDoForm(String office, SignOnUserAccount account) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         int result =0;
         try {
             Map<String, String> mapVO = new HashMap<String, String>();

             mapVO.put("ofc_cd", office);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoFormDSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to DELETE SQL");
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }

    /**
     * BKG_DO_FOM 데이터를 단건으로 수정한다.<br>
     *
     * @param BkgDoFomVO[] bkgDoFomVOs
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoFomVOs[0].getColumnValues();

            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOModifyDoFormUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }

    /**
     * BKG_DO_FOM 데이터를 단건으로 입력한다.<br>
     *
     * @param BkgDoFomVO[] bkgDoFomVOs
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoFomVOs[0].getColumnValues();
            mapVO.put("ins_usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddDoFormCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to Insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    //DO발급요청서  자가운송신청서  보세운송 요청 동의서 관련 Party(업체정보)

    /**
     * UI-BKG-0937 D/O Receiver Setting and Sending&Release<br>
     * EU DO에 대한 연락처 정보를 조회한다.
     * @param String doNo
     * @param String doNoSplit
     * @return BkgDoVO
     * @exception DAOException
     */
    public BkgDoVO searchEuDoRcvrInfo (String doNo, String doNoSplit) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        BkgDoVO bkgDoVO = null;
        List<BkgDoVO> list = null;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("do_no", doNo);
            mapVO.put("do_no_split", doNoSplit);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuDoRcvrInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDoVO .class);
            if (list.size() >0) {
                bkgDoVO = list.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgDoVO;
    }


    /**
     * EU_Cargo Release Order의 D/O Receiver 저장한다.<br>
     *
     * @param BkgDoVO[] bkgDoVO
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyEuDoRcvrInfo(BkgDoVO[] bkgDoVO, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = bkgDoVO[0].getColumnValues();

            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyEuDoRcvrInfoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }

    /**
     * 조회된 Do No에 연계된 Container의 Container No를 조회한다.<br>
     *
     * @param String doNo
     * @param String doNoSplit
     * @return List<DoCntrVO> 컨테이너번호 목록
     * @exception DAOException
     * @author An Jineung
     */
    public List<DoCntrVO> searchDoCntrInfo(String doNo, String doNoSplit) throws DAOException {

         DBRowSet dbRowset = null;
         List<DoCntrVO> doCntrVos = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap();

             mapVO.put("do_no" , doNo);
             mapVO.put("do_no_split" , doNoSplit);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoCntrInfoRSQL(), param, velParam);

             doCntrVos = (List)RowSetUtil.rowSetToVOs(dbRowset, DoCntrVO.class);

         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
        return doCntrVos;
    }

    /**
     * 조회된 Do No에 연계된 Container의 Container No를 조회한다.<br>
     *
     * @param String doNo
     * @param String doNoSplit
     * @return List<BkgDoCntrVO> 컨테이너번호 목록
     * @exception DAOException
     * @author An Jineung
     */
    public List<BkgDoCntrVO> searchEuDoTruckerInfo(String doNo, String doNoSplit) throws DAOException {

        DBRowSet dbRowset = null;
        List<BkgDoCntrVO> bkgDoCntrVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("do_no" , doNo);
            mapVO.put("do_no_split" , doNoSplit);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuDoTruckerInfoRSQL(), param, velParam);

            bkgDoCntrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDoCntrVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgDoCntrVOs;
    }

    /**
     * EU_Cargo Release Order의 Trucker 저장한다.<br>
     *
     * @param List<BkgDoCntrVO> bkgDoCntrVOs
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyEuDoTruckerInfo(List<BkgDoCntrVO> bkgDoCntrVOs, SignOnUserAccount account) throws DAOException {
        int result =0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(bkgDoCntrVOs.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyEuDoTruckerInfoUSQL(), bkgDoCntrVOs,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED) {
                        throw new DAOException("Fail to update No"+ i + " SQL");
                    } else {
                        result = result + 1;
                    }
                }
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }

    /**
     * Booking Status를 체크한다.<br>
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @return String bkgStsCd
     * @exception DAOException
     */
    public String searchBkgCgoTp(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String bkgStsCd = null;
        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBkgCgoTpRSQL(), param, velParam);

            if (dbRowset.next()) {
                bkgStsCd = dbRowset.getString(1);
            } else {
                bkgStsCd = "XX";
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgStsCd;
    }

    /**
     * EU세관 신고를 위한 B/L INFO를 조회한다.<br>
     *
     * @param String bkgNo : 선적예약 요청 번호
     * @return EuCstmsVO
     * @exception DAOException
     * @author An Jineung
     */
    public EuCstmsVO searchEuCstmsInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        EuCstmsVO euCstms = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuCstmsInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
                euCstms = (EuCstmsVO)RowSetUtil.rowSetToVOs(dbRowset, EuCstmsVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return euCstms;
    }

    /**
     * EU Do의 Split Flg를 조회한다.<br>
     *
     * @param String bkgNo
     * @return String
     * @exception DAOException
     */
    public String searchDoSplitFlg(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String splitFlg = "";
        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoSplitFlgRSQL(), param, velParam);

            if (dbRowset.next()) {
                splitFlg = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return splitFlg;
    }

    /**
     * D/O No가 Split Assign되지 않은 Container의 수량 조회<br>
     *
     * @param String bkgNo
     * @return int
     * @exception DAOException
     */
    public int searchDoRemainCntrCnt(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result =0;
        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoRemainCntrCntRSQL(), param, velParam);

            if (dbRowset.next()) {
                result = dbRowset.getInt(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }


    /**
     * Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<EuDoCntrRlseStsVO>
     * @exception DAOException
     * @author An Jineung
     */
    public List<EuDoCntrRlseStsVO> searchEuDoRlseStsByCntr(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap();

             mapVO.put("bkg_no" , bkgNo);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuDoRlseStsByCntrRSQL(), param, velParam);

             euDoCntrRlseStsVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, EuDoCntrRlseStsVO.class);

         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
        return euDoCntrRlseStsVOs;
    }

    /**
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<EuDoRlseStsVO>
     * @exception DAOException
     * @author An Jineung
     */
    public List<EuDoRlseStsVO> searchEuDoRlseStsByBl(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<EuDoRlseStsVO> euDoRlseSts = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuDoRlseStsByBlRSQL(), param, velParam);
            euDoRlseSts = (List)RowSetUtil.rowSetToVOs(dbRowset, EuDoRlseStsVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return euDoRlseSts;
    }

    /**
     * EU Do의 DO NO SPLIT을 조회한다.<br>
     *
     * @param String bkgNo
     * @param String doNo
     * @return String
     * @exception DAOException
     */
    public String searchDoSplitNo(String bkgNo, String doNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String splitNo = "";
        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("do_no", doNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoSplitNoRSQL(), param, velParam);

            if (dbRowset.next()) {
               splitNo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return splitNo;
    }


    /**
     * D/O No가 RLSE SEQ를 조회<br>
     *
     * @param String bkgNo
     * @return int
     * @exception DAOException
     */
    public int searchDoRlseSeq(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result =0;
        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoRlseSeqRSQL(), param, velParam);

            if (dbRowset.next()) {
                result = dbRowset.getInt(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Container별 D/O의 Release정보를 저장한다.<br>
     *
     * @param DoCntrVO doCntr 데이터객체
     * @exception DAOException
     * @author An Jineung
     */
    public void addDoRlseByCntr(DoCntrVO doCntr) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = doCntr.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddDoRlseByCntrCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container별 D/O의 Release정보를 저장한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @param String usrId
     * @exception DAOException
     * @author An Jineung
     */
    public void addDoRlseByBl(String bkgNo, String rlseSeq, String usrId) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("rlse_seq" , rlseSeq);
            mapVO.put("cre_usr_id" , usrId);
            mapVO.put("upd_usr_id" , usrId);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddDoRlseByBlCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<BkgDoVO>
     * @exception DAOException
     * @author An Jineung
     */
    public BkgDoVO searchVetnamPrnCd(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        BkgDoVO  bkgDoVo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            List<BkgDoVO> bkgDoVOs = null;

            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("rlse_seq" , "1");

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchVetnamPrnCdRSQL(), param, velParam);

            bkgDoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDoVO.class);

            if (bkgDoVOs.size() >0) {
                bkgDoVo = bkgDoVOs.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgDoVo;
    }

    /**
     * EU_Cargo Release Order의 Trucker 저장한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @param String vnCgoDeCd
     * @param String updUsrId
     * @return int
     * @exception DAOException
     */
    public int modifyVetnamPrnCd(String bkgNo, String rlseSeq, String vnCgoDeCd, String updUsrId) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("rlse_seq" , "1");
            mapVO.put("vn_cgo_de_cd" , vnCgoDeCd);
            mapVO.put("upd_usr_id" , updUsrId);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyVetnamPrnCdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }

    /**
     * 해당 BKG_NO, RLSE_SEQ의 DO 정보를 삭제한다.<br>
     *
     * @param String bkgNo
     * @param String rlseSeq
     * @exception DAOException
     * @author An JinEung
     */
    public void removeDoCntr(String bkgNo, String rlseSeq) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("rlse_seq" , rlseSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOremoveDoCntrDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 조회된 Do No에 연계된 Container의 Container No를 조회한다.<br>
     *
     * @param EuDoNtcSendVO euDoNtcSend
     * @return List<BkgNtcHisVO> cntrs 컨테이너번호 목록
     * @exception DAOException
     * @author An Jineung
     */
    public List<BkgNtcHisVO> searchEuDoNtcSndHistory(EuDoNtcSendVO euDoNtcSend) throws DAOException {

         DBRowSet dbRowset = null;
         List<BkgNtcHisVO> bkgNtcHisVOs = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = euDoNtcSend.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEuDoNtcSndHistoryRSQL(), param, velParam);

             bkgNtcHisVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class);

         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
        return bkgNtcHisVOs;
    }

    /**
     * Report Design 출력폼을 조회한다.<br>
     *
     * @param String bkgNo
     * @return String
     * @exception DAOException
     * @author An JinEung
     */
    public String searchBlNo(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;

        String blNo =""; //출력폼 ID

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchBlNoRSQL(), param, velParam);

            if (dbRowset.next()) {
                blNo = dbRowset.getString(1);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blNo;
    }

    /**
     * Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<EuDoCntrRlseStsVO>
     * @exception DAOException
     * @author An Jineung
     */
    public List<DoCntrRlseStsVO> searchDoRlseStsByCntr(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        List<DoCntrRlseStsVO> doCntrRlseStsVOs = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap();

             mapVO.put("bkg_no" , bkgNo);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoRlseStsByCntrRSQL(), param, velParam);

             doCntrRlseStsVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DoCntrRlseStsVO.class);

         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
        return doCntrRlseStsVOs;
    }

    /**
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.<br>
     *
     * @param String bkgNo
     * @return List<EuDoRlseStsVO>
     * @exception DAOException
     * @author An Jineung
     */
    public List<DoRlseStsVO> searchDoRlseStsByBl(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<DoRlseStsVO> doRlseSts = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoRlseStsByBlRSQL(), param, velParam);
            doRlseSts = (List)RowSetUtil.rowSetToVOs(dbRowset, DoRlseStsVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRlseSts;
    }


    /**
     * EU Cargo Release에서 국가코드에 해당하는 Discharge Location을 검사한다.
     *
     * @param String cntCd
     * @return String
     * @exception DAOException
     * @author Park Mangeon
     */
    public String checkEuDoDischLoc(String cntCd) throws DAOException {
        DBRowSet dbRowset = null;
        String isDishLoc = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("cnt_cd", cntCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOCheckEuDoDischLocRSQL(), param, velParam);
            dbRowset.next(); // 무조건 1건 있다.
            isDishLoc = dbRowset.getString(1);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isDishLoc;

    }

    /**
     * EU Cargo Release에서 국가코드에 해당하는 Discharge Location을 검사한다.
     *
     * @param String cntCd
     * @return String
     * @exception DAOException
     * @author An JinEung
     */
    public String checkGenDoDischLoc(String cntCd) throws DAOException {
        DBRowSet dbRowset = null;
        String isDishLoc = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("cnt_cd", cntCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckGenDoDischLocRSQL(), param, velParam);
            dbRowset.next(); // 무조건 1건 있다.
            isDishLoc = dbRowset.getString(1);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isDishLoc;

    }

/* ************************************************************************************** */
/* Author :An JinEung End                                                                 */
/* ************************************************************************************** */


/* ************************************************************************************** */
/* Author :Park Mangeon Start                                                             */
/* ************************************************************************************** */

    /**
     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 조회한다.<br>
     * @param String doNo
     * @param String doNoSplit
     * @return DoRcvrVO
     * @exception DAOException
     * @author Park Mangeon
     */
    public DoRcvrVO searchIdaDoRcvrInfo (String doNo, String doNoSplit) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        DoRcvrVO doRcvrVO = null;
        List<DoRcvrVO> list = null;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("do_no", doNo);
            mapVO.put("do_no_split", doNoSplit);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchIdaDoRcvrInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, DoRcvrVO .class);
            if (list.size() >0) {
                doRcvrVO = list.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRcvrVO;
    }

    /**
     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 수정한다.<br>
     * @param DoRcvrVO doRcvr
     * @param SignOnUserAccount account
     * @exception DAOException
     * @author Park Mangeon
     */
    public void setupIdaDoRcvrInfo (DoRcvrVO doRcvr, SignOnUserAccount account) throws DAOException {
        //query parameter 
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try {
            Map<String, String> mapVO = doRcvr.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyIdaDoRcvInfoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to Insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * UI-BKG-0694 DO LIST CHECK REPORT(JAPAN) <br>
     * japan do check list조회를 수행한다.<br>
     * @param JapDoHisSearchVO japDoHisSearch
     * @return List<JapDoHisListVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<JapDoHisListVO> searchJapDoHistory(JapDoHisSearchVO japDoHisSearch) throws DAOException {
        List<JapDoHisListVO> japDoHisLists = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = japDoHisSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchJapDoHistoryRSQL(), param, velParam);
            japDoHisLists =(List)RowSetUtil.rowSetToVOs(dbRowset, JapDoHisListVO .class);
            if (japDoHisLists != null && japDoHisLists.size() > 0 ) {
                JapDoHisListVO japDoHisListVO = japDoHisLists.get(0);
                japDoHisListVO.setMaxRows(Integer.parseInt(japDoHisListVO.getRowCount()));
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return japDoHisLists;
    }

    /**
     * UI-BKG-0131 Cargo Release Order List Check Report<br>
     * do check list조회를 수행한다.<br>
     * @param DoCheckListSearchVO checkListSearch
     * @return List<DoCheckListVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<DoCheckListVO> searchDoCheckReport (DoCheckListSearchVO checkListSearch) throws DAOException {
        List<DoCheckListVO> chkLists = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = checkListSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoCheckReportRSQL(), param, velParam);
            chkLists =(List)RowSetUtil.rowSetToVOs(dbRowset, DoCheckListVO .class);
            if (chkLists != null && chkLists.size() > 0 ) {
                DoCheckListVO doCheckListVO = chkLists.get(0);
                doCheckListVO.setMaxRows(Integer.parseInt(doCheckListVO.getRowCount()));
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkLists;
    }
    
    /**
     * UI-BKG-0131 Cargo Release Order List Check Report<br>
     * do check list조회를 수행한다.<br>
     * @param DoCheckListSearchVO checkListSearch
     * @return List<DoCheckListVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public DoCheckListSummaryVO searchDoCheckReportSummary (DoCheckListSearchVO checkListSearch) throws DAOException {
    	DoCheckListSummaryVO doCheckListSummaryVo = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	Map<String, String> mapVO = checkListSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoCheckReportSummaryRSQL(), param, velParam);
            if(dbRowset.getRowCount() > 0){
            	doCheckListSummaryVo = (DoCheckListSummaryVO)RowSetUtil.rowSetToVOs(dbRowset, DoCheckListSummaryVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doCheckListSummaryVo;
    }

    /**
     * UI-BKG-0939 India Cargo Release Order list Inquery<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 Weekly별로 조회한다.<br>
     * @param IdaDoRlseSearchVO idaDoRlseSearch
     * @return List<IdaDoWeeklyReportVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<IdaDoWeeklyReportVO> searchIdaDoRlseWeeklyReport (IdaDoRlseSearchVO idaDoRlseSearch) throws DAOException {
        List<IdaDoWeeklyReportVO> list = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = idaDoRlseSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchIdaDoRlseWeeklyReportRSQL(), param, velParam);
            list =(List)RowSetUtil.rowSetToVOs(dbRowset, IdaDoWeeklyReportVO .class);
            // 여기에서는 page처리가 없다.
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * UI-BKG-0939 India Cargo Release Order list Inquery<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 조회한다.<br>
     * @param IdaDoRlseSearchVO idaDoRlseSearch
     * @return List<DoCheckListVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<IdaDoRlseListVO> searchIdaDoRlseList (IdaDoRlseSearchVO idaDoRlseSearch) throws DAOException {
        List<IdaDoRlseListVO> list = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = idaDoRlseSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchIdaDoRlseListRSQL(), param, velParam);
            list =(List)RowSetUtil.rowSetToVOs(dbRowset, IdaDoRlseListVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * UI-BKG-0680 India Cargo Release Order<br>
     * Booking에서 India Customs에 대한 정보를 조회한다.<br>
     * @param String bkgNo - booking number
     * @return IdaCstmsVO - 인도 세관 정보
     * @exception DAOException
     * @author Park Mangeon
     */
    public IdaCstmsVO searchIdaCstmsInfo (String bkgNo) throws DAOException {
        IdaCstmsVO idaCstm = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchIdaCstmsInfoRSQL(), param, velParam);
            if(dbRowset.getRowCount() > 0){
                idaCstm = (IdaCstmsVO)RowSetUtil.rowSetToVOs(dbRowset, IdaCstmsVO.class ).get(0);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return idaCstm;
    }


    /**
     * UI-BKG-0680 India Cargo Release Order<br>
     * 컨테이너별 Release상태를 조회한다.<br>
     * @param String bkgNo - booking number
     * @return List<IdaDoCntrRlseStsVO> Container Release Status
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<IdaDoCntrRlseStsVO> searchIdaDoRlseStsByCntr (String bkgNo) throws DAOException {
        List<IdaDoCntrRlseStsVO> list = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchIdaDoRlseStsByCntrRSQL(), param, velParam);
            list =(List)RowSetUtil.rowSetToVOs(dbRowset, IdaDoCntrRlseStsVO .class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * UI-BKG-0680 India Cargo Release Order<br>
     * BL별 Release상태를 조회한다.<br>
     * @param String bkgNo booking number
     * @return List<IdaDoRlseStsVO> Cargo Release Status per BL
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<IdaDoRlseStsVO> searchIdaDoRlseStsByBl (String bkgNo) throws DAOException {
        List<IdaDoRlseStsVO> list = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchIdaDoRlseStsByBlRSQL(), param, velParam);
            list =(List)RowSetUtil.rowSetToVOs(dbRowset, IdaDoRlseStsVO .class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * UI_BKG_0923  Inbound Cargo Release for POD Office_Popup History<br>
     * 미주 Inboud Cargo Release B/L에 대한 History 조회<br>
     * @param String blNo
     * @return List<UsCgoRlseHisVO>
     * @exception DAOException
     * @author Park Mangeon
     */
    public List<UsCgoRlseHisVO> searchUsCgoRlseHis(String blNo) throws DAOException {
        List<UsCgoRlseHisVO> cgoRlseHiss = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bl_no" , blNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchUsCgoRlseHisRSQL(), param, velParam);
            cgoRlseHiss =(List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseHisVO .class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cgoRlseHiss;

    }

/* ************************************************************************************** */
/* Author :Park Mangeon End                                                               */
/* ************************************************************************************** */

/* ************************************************************************************** */
/* Author : Son Yun Seuk Start                                                            */
/* ************************************************************************************** */

    /**
     * [1018] 조회
     * @param String doNo
     * @param SignOnUserAccount account
     * @return DoPrnRmkVO
     * @exception DAOException
     * @since 2009.07.13
     * @author Son YunSeuk
     */
    public List<DoPrnRmkVO> searchDoPrnRmk(String doNo, SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset       = null;
//      DoPrnRmkVO returnNode   = null;
        List <DoPrnRmkVO> list  = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();

        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("do_no", doNo);
            mapVO.put("ofc_cd", account.getOfc_cd());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchDoPrnRmkRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DoPrnRmkVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * [1018] DO Prn Remark 수정
     * @param DoPrnRmkVO doPrnRmk
     * @param SignOnUserAccount account
     * @exception DAOException
     * @since 2009.07.13
     * @author Son YunSeuk
     */
    public void modifyDoPrnRmk(DoPrnRmkVO doPrnRmk, SignOnUserAccount account) throws DAOException{
        try{
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = doPrnRmk.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyDoPrnRmkUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modify SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * [0272] Full Container Rlse Order 리스트 조회
     * @param FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch
     * @return List<FullCntrRlseOrdVO>
     * @exception DAOException
     * @since 2009.07.14
     * @author Son YunSeuk
     */
    public List<FullCntrRlseOrdVO> searchFullCntrRlseOrderList(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch) throws DAOException{
        DBRowSet dbRowset       = null;
        List <FullCntrRlseOrdVO> list     = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = fullCntrRlseOrderSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, FullCntrRlseOrdVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * [0272] Email, Edi 전송 History Insert
     * @param List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos
     * @exception DAOException
     * @since 2009.07.15
     */
    public void addFullCntrRlseOrder( List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos) throws DAOException{
        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            int insCnt[] = null;
            insCnt = sqlExe.executeBatch((ISQLTemplate)new CargoReleaseOrderDBDAOaddFullCntrRlseOrderCSQL(), bkgFullCgoRlseOrdVos,null);

            for(int i = 0; i < insCnt.length; i++){
                if(insCnt[i]== Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert No"+ i + " SQL");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * [0272] Mail전송기중 Yard 유효성 체크
     * @param String ydCd
     * @return String
     * 2009.07.15
     * @exception DAOException
     * @author Son YunSeuk
     */
    public String checkYardValid(String ydCd) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String isYd= null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("yd_cd", ydCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOCheckYardValidRSQL(), param, velParam);
            if(dbRowset.next()){
                isYd = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isYd;
    }

    /**
     * [0272] EDI전송기준 Yard 유효성 체크
     * @param String ydCd
     * @return String
     * @exception DAOException
     * @author Son YunSeuk
     * @since 2009.07.15
     */
    public String checkEdiYardValid(String ydCd) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ydcd = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("yd_cd", ydCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOcheckEdiYardValidRSQL(), param, velParam);
            if(dbRowset.next()){
                ydcd = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ydcd;
    }

    /**
     * [1052] : [0272]화면에서 띄운 팝업(1052)에서 Remark저장
     * @param BkgFullCntrRemarkVO bkgFullCntrRemarkVO
     * @param SignOnUserAccount account
     * @return int updateCount
     * @exception DAOException
     * @since 2009.08.10
     * @author Son YunSeuk
     */
    public int modifyFullCntrRlseRmk(BkgFullCntrRemarkVO bkgFullCntrRemarkVO, SignOnUserAccount account) throws DAOException{
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        int updateCount = 0;

        try{
            Map<String, String> mapVO = bkgFullCntrRemarkVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            updateCount = sqlExe.executeUpdate((ISQLTemplate) new CargoReleaseOrderDBDAOmodifyFullCntrRlseRmkUSQL(), param, velParam);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updateCount;
    }

    /**
     * [0272] EDI전송을 위한 데이타 조회(FullCntrRlseOrderEdiYdVO)
     * @param String ydCd
     * @return FullCntrRlseOrderEdiYdVO
     * @exception DAOException
     * @since 2009.08.24
     * @author Son YunSeuk
     */
    public FullCntrRlseOrderEdiYdVO searchEdiFullCntrRlseOrderYardCd(String ydCd) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        FullCntrRlseOrderEdiYdVO rtnValue = null;
        List<FullCntrRlseOrderEdiYdVO> list = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("yd_cd", ydCd);
        //    mapVO.put("full_rlse_edi_cd", "4");
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderYardCdRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, FullCntrRlseOrderEdiYdVO.class);
            if(list != null && list.size() > 0){
                rtnValue = list.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnValue;
    }

    /**
     * Full Container Release Order EDI 전송을 위한 헤더 정보를 조회한다.<br>
     * @param String sndrId
     * @param String rcvId
     * @param String msgId
     * @return String ediHeader
     * @exception DAOException
     */
    public String searchEdiFullCntrRlseOrderHeader(String sndrId,
                                                   String rcvId,
                                                   String msgId) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediHeader  = "";

        try{
             HashMap<String, Object> mapVO = new HashMap<String, Object>();
             mapVO.put("sndr_id", sndrId);
             mapVO.put("rcv_id", rcvId);
             mapVO.put("msg_id", msgId);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderHeaderRSQL(), param, velParam);

            if (dbRowset.next()) {
                ediHeader = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediHeader;
    }
    /**
     * [0272] EDI전송을 위한 데이타 조회(BlInfo)
     * @param FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend
     * @return String
     * @exception DAOException
     * @since 2009.08.24
     */
    public String searchEdiFullCntrRlseOrderBlInfo(FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediBlInfo = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", fullCntrRlseOrderEdiSend.getBkgNo());
            mapVO.put("cntr_no", fullCntrRlseOrderEdiSend.getCntrNo());
            mapVO.put("cxl_flg", fullCntrRlseOrderEdiSend.getCxlFlg());
            mapVO.put("diff_rmk", fullCntrRlseOrderEdiSend.getDiffRmk());
            mapVO.put("cust_nm", fullCntrRlseOrderEdiSend.getCustNm());
            mapVO.put("cgo_pkup_dt", fullCntrRlseOrderEdiSend.getCgoPkupDt());

            // Binding 변수 처리
            mapVO.put("sh_cust_tp_cd", "S");      // Shipper
            mapVO.put("fw_cust_tp_cd", "F");      // Freight Forwarder
            mapVO.put("ebrf_ref_tp_cd", "EBRF");  // BKG Ref # (ext bkg rqst)
            mapVO.put("psan_ref_tp_cd", "PSAN");  // PSA NUMBER
            mapVO.put("bkg_cntc_pson_tp_cd", "BK");

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlInfoRSQL(), param, velParam);
            if(dbRowset.next()){
                ediBlInfo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediBlInfo;
    }

    /**
     * [0272] EDI전송을 위한 데이타 조회(CntrInfo)
     * @param FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend
     * @param String ofcCd
     * @return String
     * @exception DAOException
     * @since 2009.08.24
     */
    public String searchEdiFullCntrRlseOrderCntrInfo(FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend, String ofcCd) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediCntrInfo = null;
        try{
            Map<String, String> mapVO = fullCntrRlseOrderEdiSend.getColumnValues();
            mapVO.put("lgn_ofc_cd", ofcCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrInfoRSQL(), param, velParam);
            if(dbRowset.next()){
                ediCntrInfo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediCntrInfo;
    }

    /**
     * [0272] EDI전송을 위한 데이타 조회(EurDtlInfo)
     * @param FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend
     * @return String
     * @exception DAOException
     * @since 2010.11.29
     */
    public String searchEdiFullCntRlseOrderEurDtlInfo(FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediCntrInfo = null;
        try{
            Map<String, String> mapVO = fullCntrRlseOrderEdiSend.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderEurDtlInfoRSQL(), param, velParam);
            if(dbRowset.next()){
                ediCntrInfo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediCntrInfo;
    }
    
    /**
     * [0272] EDI전송을 위한 데이타 조회(DgInfo)
     * @param String bkgNo
     * @param String cntrNo
     * @return String
     * @exception DAOException
     * @since 2009.08.24
     */
    public String searchEdiFullCntrRlseOrderDgInfo(String bkgNo, String cntrNo) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediDgInfo = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderDgInfoRSQL(), param, velParam);
            if(dbRowset.next()){
                ediDgInfo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediDgInfo;
    }

    /**
     * [0272] EDI전송을 위한 데이타 조회(BlCntr)
     * @param String bkgNo
     * @param String cntrNo
     * @param String transMode
     * @return String
     * @exception DAOException
     * @since 2009.08.24
     * @author Son YunSeuk
     */
    public String searchEdiFullCntrRlseOrderBlCntr(String bkgNo, String cntrNo, String transMode) throws DAOException{
        DBRowSet dbRowset               = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        String ediBlCntr = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("dest_trns_mod_cd", transMode);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlCntrRSQL(), param, velParam);
            //int cnt = dbRowset.getRowCount();

            while(dbRowset.next()){
                ediBlCntr = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediBlCntr;
    }

    /**
     * [0273] : [0272]화면에서의 Full Container Release Order 의 History조회
     * @param FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO
     * @param String ofcCd
     * @return List<FullCntrRlseOrderHisVO>
     * @exception DAOException
     * @since 2009.08.11
     * @author Son YunSeuk
     */
    public List<FullCntrRlseOrderHisVO> searchFullCntrRlseOrderHis(FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO, String ofcCd) throws DAOException{
        DBRowSet dbRowset       = null;
        List <FullCntrRlseOrderHisVO> list     = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = fullCntrRlseOrderHisSearchVO.getColumnValues();
            mapVO.put("lgn_ofc_cd", ofcCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchFullCntrRlseOrderHisRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, FullCntrRlseOrderHisVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * [0272] : Full Contaier Release Order 정송 유무 조회
     * @param FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSendVo
     * @return String
     * @exception DAOException
     * @author Son YunSeuk
     * @since 2009.08.17
     */
    public String searchEdiFullCntrRlseOrdBrac(FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSendVo ) throws DAOException {
        DBRowSet dbRowset = null;
        String brac = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
           if(fullCntrRlseOrderEdiSendVo != null){
                Map<String, String> mapVO = fullCntrRlseOrderEdiSendVo.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrdBracRSQL(), param, velParam);
                while (dbRowset.next()) {
                    brac = dbRowset.getString(1);
                }
           }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return brac;

    }

    /**
     * [0130] : Receiver Info 조회
     * @param doNo
     * @return DoRcvrInfoVO
     * @exception DAOException
     * @author Son YunSeuk
     * @since 2009.08.17
     */
    public DoRcvrInfoVO searchDoRcvrInfo(String doNo) throws DAOException{
        DBRowSet dbRowset       = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        DoRcvrInfoVO doRcvrInfoVO = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("do_no", doNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchDoRcvrInfoRSQL(), param, velParam);
            if(dbRowset.getRowCount() >= 1 ){
                doRcvrInfoVO = (DoRcvrInfoVO)RowSetUtil.rowSetToVOs(dbRowset, DoRcvrInfoVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRcvrInfoVO;
    }

    /**
     * [0130] : Receiver Info 저장
     * @param DoRcvrInfoVO doRcvrInfoVO
     * @param SignOnUserAccount account
     * @return Update Count
     * @exception DAOException
     * @author Son YunSeuk
     * @since 2009.08.17
     */
    public int modifyDoRcvrInfo(DoRcvrInfoVO doRcvrInfoVO, SignOnUserAccount account) throws DAOException{
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        int updateCount = 0;

        try{
            Map<String, String> mapVO = doRcvrInfoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            mapVO.put("upd_usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            updateCount = sqlExe.executeUpdate((ISQLTemplate) new CargoReleaseOrderDBDAOmodifyDoRcvrInfoUSQL(), param, velParam);

            log.debug("=======================================");
            log.debug("########  UPDATE COUNT : " +updateCount);
            log.debug("=======================================");


        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updateCount;
    }
    /**
     * 두바이건 요청.<br>
     *
     * @param DubaiCstmsVO dubaiCstms
     * @exception DAOException
     * @author 박성호
     * @since 2010.03.09
     */
    public void modifyDubaiCstmsRefNo(DubaiCstmsVO dubaiCstms ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = dubaiCstms.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyDubaiCstmsRefNoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
    }
    
    /**
     * D/O EDI전송을 위한 해더 정보를 조회한다.
     *
     * @param String sndrId
     * @param String rcvId
     * @param String msgId
     * @return String
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchDoEdiHeader(String sndrId, 
    		                        String rcvId, 
    		                        String msgId ) throws DAOException {
    	  DBRowSet dbRowset = null;
          Map<String, Object> param       = new HashMap<String, Object>();
          Map<String, Object> velParam    = new HashMap<String, Object>();
          String ediHeader  = "";

          try{
               HashMap<String, Object> mapVO = new HashMap<String, Object>();
               mapVO.put("sndr_id", sndrId);
               mapVO.put("rcv_id", rcvId);
               mapVO.put("msg_id", msgId);

               param.putAll(mapVO);
               velParam.putAll(mapVO);

               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchDoEdiHeaderRSQL(), param, velParam);

              if (dbRowset.next()) {
                  ediHeader = dbRowset.getString(1);
              }
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage(), se);
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
          }
          return ediHeader;
    }
    
    /**
     * Korea D/O Release Reference 정보를 수정한다.<br>
     *
     * @param String bkg_no
     * @param String self_trns_flg
     * @param String usr_id
     * @return int result
     * @exception DAOException
     * @author Lim JinYoung
     */
    public int mergeKorDoSelfTransFlg( String bkg_no,
    		                           String self_trns_flg,
    		                           String usr_id) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
        	HashMap<String, Object> mapVO = new HashMap<String, Object>();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("bkg_no"          , bkg_no);
            mapVO.put("self_trns_flg"   , self_trns_flg);         
            mapVO.put("cre_usr_id"      , usr_id);
            mapVO.put("upd_usr_id"      , usr_id);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOMergeKorDoSelfTransFlgUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * [ESM072] : ERP ORS 수신시 순차성 여부 체크
     * @param BkgOutstandingVO ots
     * @return String
     * @exception DAOException
     * @author YHYUN
     * @since 2010.03.25
     */
    public String checkOtsLstUptValid(BkgOutstandingVO ots ) throws DAOException {
        DBRowSet dbRowset = null;
        String chk = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
              Map<String, String> mapVO = ots.getColumnValues();
              param.putAll(mapVO);
              velParam.putAll(mapVO);

              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckOtsLstUptValidRSQL(), param, velParam);
              while (dbRowset.next()) {
            	  chk = dbRowset.getString(1);
              }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chk;

    }
    
    /**
     * [0326] : Japan DOR I/F 전 MFR 기 전송 여부 체크
     * @param String blNo
     * @return String
     * @exception DAOException
     * @author YHYUN
     * @since 2010.03.25
     */
    public boolean checkJapMfrTransmit(String blNo ) throws DAOException {
        DBRowSet dbRowset = null;
       
        boolean isTrans = false;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	HashMap<String, Object> mapVO = new HashMap<String, Object>();

            //사용자의 세션정보를 세팅한다.
            mapVO.put("bl_no"          , blNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckJapMfrTransmitRSQL(), param, velParam);
            
            String transFlg = "N";
            while (dbRowset.next()) {
            	transFlg = dbRowset.getString(1);
            }
           if("Y".equals(transFlg)){
            	isTrans = true;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isTrans;

    }
    
    /**
     * [0272] : Yard Info 조회
     * @param ydCd
     * @return FullCntrRlseYdInfoVO
     * @exception DAOException
     * @author An JinEung
     * @since 2010.04.09
     */
    public FullCntrRlseYdInfoVO searchFullCntrRlseYdInfo(String ydCd) throws DAOException{
        DBRowSet dbRowset       = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        FullCntrRlseYdInfoVO ydInfoVO = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("yd_cd", ydCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchFullCntrRlseYdInfoRSQL(), param, velParam);
            if(dbRowset.getRowCount() >= 1 ){
            	ydInfoVO = (FullCntrRlseYdInfoVO)RowSetUtil.rowSetToVOs(dbRowset, FullCntrRlseYdInfoVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ydInfoVO;
    }   
    
    /**
     * D/O EDI 전송 로그 정보를 저장한다.<br>
     *
     * @param BkgIbEdiSndLogVO ibEdiSndLog
     * @exception DAOException
     * @author Hna Yoon
     */
    public void addIbEdiSndLog(BkgIbEdiSndLogVO ibEdiSndLog) throws DAOException {    	
    	  // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = ibEdiSndLog.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CargoReleaseOrderDBDAOAddEdiSndLogCSQL template = new CargoReleaseOrderDBDAOAddEdiSndLogCSQL();
            result = sqlExe.executeUpdate(template, param, velParam);            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }     
        
    }
    
    /**
     * Japan SENACS DOR 승인 EDI 전송 로그 정보를 저장한다.<br>
     *
     * @param BkgIbEdiSndLogVO bkgIbEdiSndLog
     * @param String grpNo
     * @exception DAOException
     * @author Hna Yoon
     */
    public void addIbEdiSndLogByJapDor(BkgIbEdiSndLogVO bkgIbEdiSndLog, String grpNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
        	 Map<String, String> mapVO = bkgIbEdiSndLog.getColumnValues();
             mapVO.put("grp_no", grpNo);
            
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddEdiSndLogByJapDorCSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Japan SENACS DOR 승인 EDI 전송 로그 정보를 저장한다.<br>
     * Japan Cargo Release 화면 DOR I/F시에 로그인(Event)User& Office 저장용<br>
     *
     * @param BkgIbEdiSndLogVO bkgIbEdiSndLog
     * @param String grpNo
     * @exception DAOException
     * @author Hna Yoon
     */
    public void addIbEdiSndLogByJapDorEvnt(BkgIbEdiSndLogVO bkgIbEdiSndLog, String grpNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
        	 Map<String, String> mapVO = bkgIbEdiSndLog.getColumnValues();
             mapVO.put("grp_no", grpNo);
            
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddEdiSndLogByJapDorEvntCSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    
    
    /**
     * Cargo Release Order_E-D/O inquiry _Main 자가운송 데이타 모델에 해당되는 값을 불러온다.<br>
     *
     * @param EdoSearchVO edoSearch 데이타 모델
     * @return List<EdoRqstsVO>
     * @exception DAOException
     */
    public List<EdoCntrRqstsVO> searchEdoCntrRqstList(EdoSearchVO edoSearch) throws DAOException {

        DBRowSet dbRowset = null;
        List<EdoCntrRqstsVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(edoSearch != null){
                Map<String, String> mapVO = edoSearch.getColumnValues();

                mapVO.put("edo_pty_cd" , "MS");
                mapVO.put("mf_cfm_flg" , "Y");
                mapVO.put("mrn_bl_ts_cd" , "I");
                mapVO.put("cnt_cd" , "KR");             
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdoCntrRqstListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdoCntrRqstsVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * Delievery Order Container Release 정보를 삭제 처리한다.<br>
     *
     * @param String bkgNo
     * @exception DAOException
     * @author Kim Gyoung Sub
     */
    public void removeDoCntrInfo(String bkgNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"        , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoCntrInfoDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to DELETE SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    } 
    
    /**
     * Delievery Order Release Detail 정보를 삭제 처리한다.<br>
     *
     * @param String bkgNo
     * @exception DAOException
     * @author Kim Gyoung Sub
     */
    public void removeDoDtlInfo(String bkgNo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	int result =0;
    	try {
    		Map<String, String> mapVO = new HashMap<String, String>();
    		
    		mapVO.put("bkg_no"        , bkgNo);
    		
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		
    		SQLExecuter sqlExe = new SQLExecuter("");
    		result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoDtlInfoDSQL(), param, velParam);
    		if(result == Statement.EXECUTE_FAILED)
    			throw new DAOException("Fail to DELETE SQL");
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    } 
    
    /**
     * Delievery Order Reference 정보를 삭제 처리한다.<br>
     *
     * @param String bkgNo
     * @exception DAOException
     * @author Kim Gyoung Sub
     */
    public void removeDoRefInfo(String bkgNo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	int result =0;
    	try {
    		Map<String, String> mapVO = new HashMap<String, String>();
    		
    		mapVO.put("bkg_no"        , bkgNo);
    		
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		
    		SQLExecuter sqlExe = new SQLExecuter("");
    		result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoRefInfoDSQL(), param, velParam);
    		if(result == Statement.EXECUTE_FAILED)
    			throw new DAOException("Fail to DELETE SQL");
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    } 
    
    /**
     * Delievery Order 정보를 삭제 처리한다.<br>
     *
     * @param String bkgNo
     * @exception DAOException
     * @author Kim Gyoung Sub
     */
    public void removeDoInfo(String bkgNo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	int result =0;
    	try {
    		Map<String, String> mapVO = new HashMap<String, String>();
    		
    		mapVO.put("bkg_no"        , bkgNo);
    		
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		
    		SQLExecuter sqlExe = new SQLExecuter("");
    		result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAORemoveDoInfoDSQL(), param, velParam);
    		if(result == Statement.EXECUTE_FAILED)
    			throw new DAOException("Fail to DELETE SQL");
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    } 
    /**
     * 이전 Release시 입력한 Receiver Info 정보를 복사한다.<br>
     *
     * @param String bkgNo
     * @return DoRcvrVO
     * @exception DAOException
     * @author Kim Gyoung Sub
     */
/*    
    public DoRcvrVO searchIdaDoRcvInfoForCopy(String bkgNo) throws DAOException {
		DBRowSet dbRowset       = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        DoRcvrVO doRcvrVO = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", bkgNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchIdaDoRcvInfoForCopyRSQL(), param, velParam);
            if(dbRowset.getRowCount() >= 1 ){
            	doRcvrVO = (DoRcvrVO)RowSetUtil.rowSetToVOs(dbRowset, DoRcvrVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doRcvrVO;
	}     
 */   
    /**
     * 이전 Release시 입력한 Receiver Info 정보를 복사한다.<br>
     *
     * @param String bkgNo
     * @return IdaDoRlseInfoForCopyVO
     * @exception DAOException
     */
    public IdaDoRlseInfoForCopyVO searchIdaDoRlseInfoForCopy(String bkgNo) throws DAOException {
		DBRowSet dbRowset       = null;
        Map<String, Object> param       = new HashMap<String, Object>();
        Map<String, Object> velParam    = new HashMap<String, Object>();
        IdaDoRlseInfoForCopyVO idaDoRlseInfoForCopyVo = null;
        try{
            HashMap<String, Object> mapVO = new HashMap<String, Object>();
            mapVO.put("bkg_no", bkgNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchIdaDoRlseInfoForCopyRSQL(), param, velParam);
            if(dbRowset.getRowCount() >= 1 ){
            	idaDoRlseInfoForCopyVo = (IdaDoRlseInfoForCopyVO)RowSetUtil.rowSetToVOs(dbRowset, IdaDoRlseInfoForCopyVO.class ).get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return idaDoRlseInfoForCopyVo;
	}    
    
 
/**
 * EDI 전송전에 미주 세관 신고 여부를 체크 .<br>
 *
 * @param String blNo 
 * @return String
 * @exception DAOException
 * @author Lee Ji Young   
 */

public String checkCstmsEvnt(String blNo) throws DAOException {
	DBRowSet dbRowset = null; //2011.07.05 전역변수 삭제에 따른 추가
	String cFlg = null;

    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
        HashMap<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("bl_no", blNo);
        param.putAll(mapVO);
        velParam.putAll(mapVO);
    

          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCstmsEvntFlgRSQL(), param, velParam);
          while (dbRowset.next()) {
        	  cFlg = dbRowset.getString(1);
          }
    }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage(), se);
    }catch(Exception ex){
        log.error(ex.getMessage(),ex);
        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    }
    return cFlg;

}
/**
 * [ESM072] : ERP OTS 수신 후 2차 Valaidation 체크 로직으로 미주 Cargo Release 호출전 체크
 * @param BkgOutstandingVO ots
 * @return String
 * @exception DAOException
 * @author YHYUN
 * @since 2010.03.25
 */
public String checkScndOtsLstUptValid(BkgOutstandingVO ots ) throws DAOException {
    DBRowSet dbRowset = null;
    String chk = null;

    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
          Map<String, String> mapVO = ots.getColumnValues();
          param.putAll(mapVO);
          velParam.putAll(mapVO);

          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckScndOtsLstUptValidRSQL(), param, velParam);
          while (dbRowset.next()) {
        	  chk = dbRowset.getString(1);
          }
    }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage(), se);
    }catch(Exception ex){
        log.error(ex.getMessage(),ex);
        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    }
    return chk;

}

	/**
	 * Japan D/O 에서 Assign/Issue가 수행 됐는지 여부를 체크한다.<br>
	 *
	 * @param String bkgNo
	 * @return boolean isRlse
	 * @exception DAOException
	 */
	public boolean checkJapDoIssue(String bkgNo) throws DAOException {
	    DBRowSet dbRowset = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    boolean isRlse = false;
	    String doRlseFlg = "";
	    try {
	        Map<String, String> mapVO = new HashMap<String, String>();
	
	        mapVO.put("bkg_no", bkgNo);
	
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckJapDoIssueRSQL(), param, velParam);
	
	        if (dbRowset.next()) {
	        	doRlseFlg = dbRowset.getString(1);
	        }
	
	        if("Y".equals(doRlseFlg)){
	        	isRlse = true;
	        }
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return isRlse;
	}
	
    /**
     * Japan D/O 에서 DOR I/F가 수행 됐는지 여부를 체크한다.<br>
     *
     * @param String bkgNo
     * @return boolean isDorIf
     * @exception DAOException
     */
    public boolean checkJapDor(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        boolean isDorIf = false;
        String dorIfFlg = "";
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckJapDorRSQL(), param, velParam);

            if (dbRowset.next()) {
            	dorIfFlg = dbRowset.getString(1);
            }

            if("Y".equals(dorIfFlg)){
            	isDorIf = true;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isDorIf;
    }
    
    /**
     * PSA EDI전송을 위한 해더 정보를 조회한다.
     *
     * @param String sndrId
     * @param String rcvId
     * @param String msgId
     * @return String
     * @exception DAOException
     * @author Lee InYoung
     */
    public String searchEdiPsaEdoHeader(String sndrId, 
    		                        String rcvId, 
    		                        String msgId ) throws DAOException {
    	  DBRowSet dbRowset = null;
          Map<String, Object> param       = new HashMap<String, Object>();
          Map<String, Object> velParam    = new HashMap<String, Object>();
          String ediHeader  = "";

          try{
               HashMap<String, Object> mapVO = new HashMap<String, Object>();
               mapVO.put("sndr_id", sndrId);
               mapVO.put("rcv_id", rcvId);
               mapVO.put("msg_id", msgId);

               param.putAll(mapVO);
               velParam.putAll(mapVO);

               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiPsaEdoHeaderRSQL(), param, velParam);

              if (dbRowset.next()) {
                  ediHeader = dbRowset.getString(1);
              }
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage(), se);
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
          }
          return ediHeader;
    }
    
    /**
     * PSA D/O Release Order EDI  전송 Record type and Fuction 값을 조회한다.
     *
     * @param String bkgNo
     * @param String eventTp
     * @return String
     * @exception DAOException
     * @author Lee InYoung
     */
    public String searchEdiPsaEdoRecTp(String bkgNo, String eventTp) throws DAOException {
    	  DBRowSet dbRowset = null;
          Map<String, Object> param       = new HashMap<String, Object>();
          Map<String, Object> velParam    = new HashMap<String, Object>();
          String ediHeader  = "";

          try{
               HashMap<String, Object> mapVO = new HashMap<String, Object>();
               mapVO.put("bkg_no", bkgNo);
               mapVO.put("event_tp", eventTp);

               param.putAll(mapVO);
               velParam.putAll(mapVO);

               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CargoReleaseOrderDBDAOsearchEdiPsaEdoRecTpRSQL(), param, velParam);

              if (dbRowset.next()) {
                  ediHeader = dbRowset.getString(1);
              }
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage(), se);
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
          }
          return ediHeader;
    }
    
    /**
     * PSA 정보 조회.<br>
     *
     * @param PsaDoEdiTransVO psaDoEdiTransVO
     * @param String recTp
     * @return String[] cntr
     * @exception DAOException
     * @author Lee In Young
     */
    public String[] searchEdiPsaEdoCtnt(PsaDoEdiTransVO psaDoEdiTransVO, String recTp) throws DAOException {
        String[] cntr = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = psaDoEdiTransVO.getColumnValues();
            param.putAll(mapVO);
            param.put("recTp", recTp);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiPsaEdoCtntRSQL(), param, velParam);

            int cnt = dbRowset.getRowCount();
            cntr = new String[cnt];
            int idx = 0;
            while(dbRowset.next()){
                cntr[idx] = dbRowset.getString(1);
                idx++;
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntr;
    }
    
    /**
     * PSA 터미널 EDI 전송 후 수신 받은 Ack 정보를 조회한다.
     * 
     * @param bkgPsaEdoAckSchVO
     * @return
     * @throws DAOException
     */
    public List<BkgPsaEdoAckSchVO> searchPsaEdoAckLog(BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgPsaEdoAckSchVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(bkgPsaEdoAckSchVO != null){
                Map<String, String> mapVO = bkgPsaEdoAckSchVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchPsaEdoAckLogRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgPsaEdoAckSchVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * PSA EDO 승인 요청에 대한 처리 후 전송 결과(Ack)정보를 기록한다.<br>
     *
     * @param BkgPsaEdoRcvLogVO bkgPsaEdoRcvLogVO
     * @return result
     * @exception DAOException
     * @author Lee In Young
     */
    public int addPsaEdoAck(BkgPsaEdoRcvLogVO bkgPsaEdoRcvLogVO) throws DAOException {
        int result =0;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if(bkgPsaEdoRcvLogVO != null){
                Map<String, String> mapVO = bkgPsaEdoRcvLogVO.getColumnValues();

                param.putAll(mapVO);
                param.put("cre_usr_id", "BKG_0001");
                param.put("upd_usr_id", "BKG_0001");

                velParam.putAll(mapVO);
            }
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOAddPsaEdoAckCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * DMIF_END_DT History 정보를 관리한다.<br>
     *
     * @param BkgCntrEtcVO vo
     * @exception DAOException
     */
    public void addEdiEdoDmtFtimeHis(BkgCntrEtcVO vo) throws DAOException {
        int result =0;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no" , vo.getBkgNo());
            mapVO.put("cntr_no" , vo.getCntrNo());
            mapVO.put("ft_end_dt" , vo.getFtEndDt());
            mapVO.put("cre_usr_id" , vo.getCreUsrId());
            mapVO.put("upd_usr_id" , vo.getUpdUsrId());

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddEdiEdoDmtFtimeHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
	/**
     * India Cargo Release조회화면의 COMBO 값 조회 : UI_BKG_0680<br>
     *
     * @return List<BkgComboVO>
     * @exception DAOException
     */
    public List<BkgComboVO> searchIdaDoDiscTmnlYdList() throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgComboVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchIdaDoDiscTmnlYdListRSQL(), param, velParam);

            list = new ArrayList<BkgComboVO>();
            BkgComboVO generalBkgVo = new BkgComboVO();
            generalBkgVo.setVal(" ");
            generalBkgVo.setName(" ");
            generalBkgVo.setDesc("General");
            list.add(0, generalBkgVo);
            while (dbRowset.next()) {
            	BkgComboVO bkgVo = new BkgComboVO();
            	
            	bkgVo.setVal(dbRowset.getString("IDA_DO_YD_CD"));
            	bkgVo.setName(dbRowset.getString("IDA_DO_YD_NM"));
            	bkgVo.setDesc(dbRowset.getString("IDA_DO_YD_CD"));
            	list.add(bkgVo);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
	/**
     * DemDet의 Free Time End Date 값을 조회한다.<br>
     *
     *@param String bkgNo
     * @return List<BkgCntrEtcVO>
     * @exception DAOException
     */
    public List<BkgCntrEtcVO> searchDemDetFreetimeEndDt(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgCntrEtcVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        param.put("bkg_no", bkgNo);

        try{
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchDemDetFreetimeEndDtRSQL(), param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrEtcVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * E-DO 요청 내역이 자가운송의 승인인 경우 냉동 화물 유무를 체크<br>
     *
     * @param String bkgNo
     * @return EdoTransBlInfoVO
     * @exception DAOException
     */
    public EdoTransBlInfoVO searchEdoTrasnBlInfo(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        EdoTransBlInfoVO edoTransBlInfoVO = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            List<EdoTransBlInfoVO> edoTransBlInfoVOs = null;
            Map<String, String> mapVO = new HashMap();
            mapVO.put("bkg_no" , bkgNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckEdoTransBlInfoRSQL(), param, velParam);
            edoTransBlInfoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, EdoTransBlInfoVO.class);
            if (edoTransBlInfoVOs.size() >0) {
            	edoTransBlInfoVO = edoTransBlInfoVOs.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return edoTransBlInfoVO;
    }
    
    
    
    /**
     * BKG_EDO_MST 테이블이 조회 될 때 Review flag 를 업데이트 한다.<br>
     *
     * @param String rqstNo
     * @param String tpCd
     * @param String usrId
     * @throws DAOException
     */
    public void modifyEdoReviewFlag(String rqstNo, String tpCd, String usrId) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("rqstNo" , rqstNo);
            mapVO.put("tpCd" , tpCd);
            mapVO.put("usr_id" , usrId);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyEdoReviewFlagUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * EU_Cargo Release Order의 email 발송 시 컨테이너 정보를 조회한다.<br>
     * @param String bkgNo
     * @param String cntrNo
     * @return List<FullCntrRlseCntrEmlVO>
     * @throws DAOException
     */
    public List<FullCntrRlseCntrEmlVO> searchFullCgoEmlCntrInfo(String bkgNo, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<FullCntrRlseCntrEmlVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);
            mapVO.put("cntr_no" , cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchFullCgoEmlCntrInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, FullCntrRlseCntrEmlVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * Pickup Date 및 Release Expire Date 항목 체크
     * @param String bkgNo
     * @param String chkItm
     * @return String
     * @throws DAOException
     */
    public String checkEuFullRlseTransmitValid( String bkgNo, String chkItm ) throws DAOException {       
    	
    	String chkFlg            = null;
    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no"   , bkgNo);
            mapVO.put("chk_itm"   , chkItm);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckEuFullRlseTransmitValidRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	chkFlg = dbRowset.getString(1);
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkFlg;
    }
    
    /**
     * ESM_BKG_1167 조회
     * @param CaCgoRlseSearchVO cgoRlseSearch
     * @return List<CaCgoRlseListVO>
     * @exception DAOException
     */
    public List<CaCgoRlseListVO> searchCaCgoRlseList(CaCgoRlseSearchVO cgoRlseSearch) throws DAOException {
        DBRowSet dbRowset = null;
        List<CaCgoRlseListVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = cgoRlseSearch.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            if(cgoRlseSearch.getBlNo().trim().length() > 0){
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoRlseList1RSQL(), param, velParam);
            }else {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoRlseList2RSQL(), param, velParam);
            }

            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseListVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    
    /**
     * ESM_BKG_1167 조회 Detail
     * @param String bkgNo
     * @return List<BkgContainerVO>
     * @exception DAOException
     */
    public List<BkgContainerVO> searchCaCgoRlseFoc(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgContainerVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();
            mapVO.put("bkg_no",bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoRlseFocRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    
    /**
     * ESM_BKG_1167 Original Bill of Lading Status 조회
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return CaCgoRlseBlStatusVO
     * @exception DAOException
     */
    public List<CaCgoRlseBlStatusVO> searchCaCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBlStatusVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no",bkgNo);
            mapVO.put("usr_id",account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBlStatusVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    
    /**
     * Canada Cargo Release Partial B/L 을 조회 한다.
     * @param CaCgoRlseBkbcBlVO caCgoRlseBkbc
     * @return CaCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public CaCgoRlseBkbcBlVO searchCaPrtlBl(CaCgoRlseBkbcBlVO caCgoRlseBkbc) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaPrtlBlRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * Canada Cargo Release EDI Snd id 조회
     * @param CaCgoRlseSearchVO caCgoRlseSearchVO
     * @return CaCgoRlseSndIdVO
     * @exception DAOException
     */
    public CaCgoRlseSndIdVO searchCaCgoSndId(CaCgoRlseSearchVO caCgoRlseSearchVO) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseSndIdVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseSearchVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseSndIdVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseSndIdVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
//    /**
//     * Ca Cargo Release
//     * BackEndBC Model No. 21
//     * @param UsCgoRlseBkbcFocVO usCgoRlseBkbcFoc
//     * @return List<UsCgoRlseBkbcFlatFileVO>
//     * @exception DAOException
//     *
//     */
//    public List<CaCgoRlseBkbcFlatFileVO> searchCaCgoMkFile(CaCgoRlseListVO caCgoRlseListVO) throws DAOException{
//        DBRowSet dbRowset = null;
//        List<CaCgoRlseBkbcFlatFileVO> listVOs = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            Map<String, String> mapVO = caCgoRlseListVO.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL(), param, velParam);
//            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFlatFileVO.class);
//
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//        return listVOs;
//    }
    
    /**
     * Ca Cargo Release Flat File 을 조회 한다.
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO
     * @return List<CaCgoRlseBkbcFlatFileVO>
     * @exception DAOException
     *
     */
    public List<CaCgoRlseBkbcFlatFileVO> searchCaCgoMkFile(CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcFlatFileVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFocVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFlatFileVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    
    /**
     * Ca Cargo Release VVD Flat File 을 조회한다.
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @return List<CaCgoRlseBkbcFlatFileVO>
     * @exception DAOException
     *
     */
    public List<CaCgoRlseBkbcFlatFileVO> searchCaCgoVvdMkFile(CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcFlatFileVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoVvdMkFileRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFlatFileVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs;
    }
    
    /**
     * Canada Cargo Release EDI Sent 내역을 저장
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int addCaCgoRlsLogRslt (CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();

            mapVO.put("usr_id", account.getUsr_id());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddCaCgoRlsLogRsltCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }
    
    /**
     * Canada Cargo Release 전송 내역을 저장
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int modifyCaCgoRlsHisRslt(CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        return result;
    }
    
    /**
     * Canada Cargo Release History 저장
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     *
     */
    public int modifyCaCgoRlsRslt(CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyCaCgoRlsRsltUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }
    
    /**
     * ESM_BKG_1167 BKG_CGO_RLSE UPDATE.
     * @param BkgCgoRlseVO cgoRlseManageEdi
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyCaCgoRlseEdi(BkgCgoRlseVO cgoRlseManageEdi,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageEdi.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("usr_ofc_cd", account.getOfc_cd());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * ESM_BKG_1167 BKG_CGO_RLSE UPDATE SUCCESS이면, BKG_CGO_RLSE_HIS UPDATE.
     * @param BkgCgoRlseVO cgoRlseManageEdi
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addCaCgoRlseHisEdi(BkgCgoRlseVO cgoRlseManageEdi,SignOnUserAccount account) throws DAOException{
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = cgoRlseManageEdi.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("ofc_cd", account.getOfc_cd());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddCaCgoRlseHisEdiCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * Ca Cargo Release Booking 정보를 조회 한다.
     * @param CaCgoRlseListVO caCgoRlseListVO
     * @return CaCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public CaCgoRlseBkbcFocVO searchCaCgoBkgInfo(CaCgoRlseListVO caCgoRlseListVO) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoBkgInfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * Ca Cargo Release VSK 내역을 조회 한다.
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @return CaCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public CaCgoRlseBkbcFocVO searchCaCgoVskInfo(CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcFocVO> listVOs = new ArrayList<CaCgoRlseBkbcFocVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoVskInfoRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * Ca Cargo Release Lane 정보를 조회 한다.
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc
     * @param SignOnUserAccount account
     * @return CaCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public CaCgoRlseBkbcFocVO searchCaCgoPoLocSlan(CaCgoRlseBkbcFocVO caCgoRlseBkbcFoc,SignOnUserAccount account) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcFocVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFoc.getColumnValues();
            mapVO.put("ofc_cd",account.getOfc_cd());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcFocVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcFocVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * Ca Cargo Release
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO
     * @return CaCgoRlseBkbcBlVO
     * @exception DAOException
     */
    public CaCgoRlseBkbcBlVO searchCaCrEdiResult(CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFocVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaCrEdiResultRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcBlVO.class);

            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcBlVO());
            }


        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * Canada Cargo Release FO 정보를 조회한다.
     * @param CaCgoRlseSearchVO caCgoRlseSearchVO
     * @return CaCgoRlseBkbcBlVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CaCgoRlseBkbcBlVO searchCaFocFlg(CaCgoRlseSearchVO caCgoRlseSearchVO) throws DAOException{
        DBRowSet dbRowset = null;
        List<CaCgoRlseBkbcBlVO> listVOs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseSearchVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCaFocFlgRSQL(), param, velParam);
            listVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCgoRlseBkbcBlVO.class);
            if(listVOs.size() < 1){
                listVOs.add(new CaCgoRlseBkbcBlVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVOs.get(0);
    }
    
    /**
     * CA Cargo searchCaCgoBlCntrInd
     * @param CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO
     * @return CaCgoRlseBkbcFocVO
     * @exception DAOException
     */
    public String searchCaCgoBlCntrInd(CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO) throws DAOException{
        String ediBlCntrInd = null;
    	DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = caCgoRlseBkbcFocVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchCustCodeRSQL(), param, velParam);
            if (dbRowset.next()) {
        	  ediBlCntrInd = dbRowset.getString("EDI_BL_CNTR_IND");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return ediBlCntrInd;
    }
    
	/**
	 * D/O 에서 Assign/Issue가 수행 됐는지 여부를 체크한다.<br>
	 *
	 * @param String bkgNo
	 * @return boolean isRlse
	 * @exception DAOException
	 */
	public boolean checkDupDoIssue(String bkgNo) throws DAOException {
	    DBRowSet dbRowset = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    boolean isRlse = false;
	    String doRlseFlg = "";
	    try {
	        Map<String, String> mapVO = new HashMap<String, String>();
	
	        mapVO.put("bkg_no", bkgNo);
	
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckDoReleaseRSQL(), param, velParam);
	
	        if (dbRowset.next()) {
	        	doRlseFlg = dbRowset.getString(1);
	        }
	
	        if("Y".equals(doRlseFlg)){
	        	isRlse = true;
	        }
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return isRlse;
	}
	
	/**
	 * D/O 에서 Assign/Issue가 수행 됐는지 여부를 체크한다.<br>
	 *
	 * @param String bkgNo
	 * @return boolean isRlse
	 * @exception DAOException
	 */
	public boolean checkDupDoAssign(String bkgNo) throws DAOException {
	    DBRowSet dbRowset = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    boolean isRlse = false;
	    String doRlseFlg = "";
	    try {
	        Map<String, String> mapVO = new HashMap<String, String>();
	
	        mapVO.put("bkg_no", bkgNo);
	
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOcheckDoAssignRSQL(), param, velParam);
	
	        if (dbRowset.next()) {
	        	doRlseFlg = dbRowset.getString(1);
	        }
	
	        if("Y".equals(doRlseFlg)){
	        	isRlse = true;
	        }
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return isRlse;
	}
	
    /**
     * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
     *
     * @param String ofcCd
     * @return String
     * @exception DAOException
     * @author 
     */
    public String searchOfcFullCntrRlseOrdBracUpdFlg(String ofcCd) throws DAOException {       
    	
    	String chkFlg            = null;
    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("ofc_cd", ofcCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchOfcFullCntrRlseOrdBracUpdFlgRSQL(), param, velParam);
            //dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchOfcFullCntrRlseOrdBracUpdFlgRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	chkFlg = dbRowset.getString(1);
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkFlg;
    }
    
    
    /**
	 * 1177   DO validity upto history 조회
	 * @param String bkgNo
	 * @return List<DoVtyDtUpdHisVO>
	 * @exception DAOException
	 * @author wonjoo cho
	 */
	public List<DoVtyDtUpdHisVO> searchDoVtyUptoDthis(String bkgNo) throws DAOException
	{
		//DoVtyDtUpdHisVO doVtyDtUpdHisVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<DoVtyDtUpdHisVO> list = null;
		
		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("bkg_no",bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoVtyUptoDTHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DoVtyDtUpdHisVO .class);                                                
			if(list == null) return null;
//			if(list.size() > 0)
//			{
//				doVtyDtUpdHisVO = list.get(0);
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 0128 BKG DO Validity upto date History 저장
	 * 생성
	 * @param BkgAeDoVtyDtHisVO bkgAeDoVtyDtHisVO
	 * @return int
	 * @exception DAOException
	 * @author Kwak youndBeom
	 */
	public int addAEDoVTYDtHis(BkgAeDoVtyDtHisVO bkgAeDoVtyDtHisVO) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = bkgAeDoVtyDtHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOaddAEDoVTYDtHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	 /**
     * [0156] COD Application POD 변경시 CgoRlse Check
     * @param String blNo
     * @return List<UsCgoRlseListVO>
     * @exception DAOException
     */
    public List<UsCgoRlseListVO>  searchUsCgoRlseViewRSQL(String blNo) throws DAOException {

    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        List<UsCgoRlseListVO> list = null;
        
        try{

			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("bl_no",blNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchUsCgoRlseViewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseListVO .class);                                                
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;

       
    }
        
    /**
     * [1515] EDI Setup 저장
     * @param EdiYardInfoVO vos
     * @return int
     * @exception DAOException
     *
     */
    public int manageEdiSetup(EdiYardInfoVO vos) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            
            Map<String, String> mapVO = vos.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmanageEdiSetupCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }    
    
    /**
     * [1516] EDI Setup History 저장
     * @param EdiYardInfoVO vos
     * @return int
     * @exception DAOException
     *
     */
    public int manageEdiSetupHistory(EdiYardInfoVO vos) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            
            Map<String, String> mapVO = vos.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOmanageEdiSetupHistoryCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }    
    
    
	 /**
     * [1515] EDI Setup 조회
     * @param EdiYardInfoVO searchVo
     * @return List<EdiYardInfoVO>
     * @exception DAOException
     */
    public List<EdiYardInfoVO>  searchEdiSetpList(EdiYardInfoVO searchVo) throws DAOException {

    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        List<EdiYardInfoVO> list = null;
        
        try{

			Map<String, String> mapVO = searchVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiSetpListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiYardInfoVO .class);                                                
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
       
    }
    

	 /**
     * [1516] EDI Setup History 조회
     * @param EdiYardInfoVO searchVo
     * @return List<EdiYardInfoVO>
     * @exception DAOException
     */
    public List<EdiYardInfoVO>  searchEdiSetupHistoryList(EdiYardInfoVO searchVo) throws DAOException {

    	DBRowSet dbRowset         = null;
    	Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        List<EdiYardInfoVO> list = null;
        
        try{

			Map<String, String> mapVO = searchVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchEdiSetupHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiYardInfoVO .class);                                                
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
       
    }
    
    /**
     * [0909] WEB B/L Printed : Serial Number 조회
     * @param String bkgNo
     * @return UsCgoRlseListVO
     * @exception DAOException
     */
    public UsCgoRlseListVO searchOblInterSerNoCheckInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<UsCgoRlseListVO> listVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();
            mapVO.put("bkg_no",bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchOblInterSerNoCheckInfoRSQL(), param, velParam);
            listVO = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCgoRlseListVO.class);

            if(listVO.size() < 1){
            	listVO.add(new UsCgoRlseListVO());
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return listVO.get(0);
    }
    
    /**
     * [0909] WEB B/L Printed : Serial Number 저장
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyOblInterSerNoCheckInfo(String bkgNo,SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
        	Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no", bkgNo);            
            mapVO.put("usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CargoReleaseOrderDBDAOMergeOblInterSerNoCheckUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }    
   
    /**
     * Indonesia Surabaya Do Reference 정보 조회.<br>
     *
     * @param String bkgNo 
     * @param String eventTp
     * @return String doBlInfo
     * @exception DAOException
     * @author Ha Daesung
     */
    public String searchEdiIdDoBlInfo(String bkgNo, String eventTp) throws DAOException {
        String doBlInfo ="";
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no"  , bkgNo);
            mapVO.put("event_tp", eventTp);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiIdDoBlInfoRSQL(), param, velParam);

            if (dbRowset.next()) {
                doBlInfo = dbRowset.getString(1);
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doBlInfo;
    }

    /**
     * Indonesia Surabaya Container 정보 조회<br>
     *
     * @param String bkgNo 선적예약 요청 번호
     * @return String[] cntr
     * @exception DAOException
     * @author Ha Daesung
     */
    public String[] searchEdiIdDoCntrInfo(String doNo) throws DAOException {
        DBRowSet dbRowset = null;
        String[] cntr = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("do_no"  , doNo);

            param.putAll(mapVO);

            velParam.putAll(mapVO);

            //dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL(), param, velParam);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchEdiIdDoCntrInfoRSQL(), param, velParam);

            int cnt = dbRowset.getRowCount();
            cntr = new String[cnt];
            int idx = 0;
            while(dbRowset.next()){
                cntr[idx] = dbRowset.getString(1);
                idx++;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntr;
    }
    
    /**
     * Do Pin No 조회<br>
     *
     * @return String doPinNo
     * @exception DAOException
     * @author Ha Daesung
     */    
    public String searchDoPinNo() throws DAOException {
    	DBRowSet dbRowset = null;
    	String doPinNo = null;
        //query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    	try {
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOsearchDoPinNoRSQL(), param, velParam);
    		while(dbRowset.next()) {
    			doPinNo = dbRowset.getString(1);
    		}
    	} catch(SQLException se) {
    		log.error(se.getMessage(), se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex) {
    		log.error(ex.getMessage(), ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    	return doPinNo;
    }
    
    /**
     * Indonesia D/O No를 조회한다.<br>
     *
     * @param String bkgNo 선적예약 요청 번호
     * @return String doNo
     * @exception DAOException
     * @author Lim JinYoung
     */
    public String searchIdDoNo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;

        String doNo ="";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CargoReleaseOrderDBDAOSearchIdDoNoRSQL(), param, velParam);

            if (dbRowset.next()) {
                doNo = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return doNo;
    }
}

