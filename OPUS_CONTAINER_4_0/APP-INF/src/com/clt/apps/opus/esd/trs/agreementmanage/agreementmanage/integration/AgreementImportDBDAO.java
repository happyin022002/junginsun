/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementImportDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김종호
*@LastVersion : 1.2
* 2010-03-26 jong hyek choi
* 1.0 최초 생성
* 1.1 2010.11.23 이재위 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
* 1.2 2011.02.24 김종호 : ALPS 고도화 작업
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchTrsAgmtTmpVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration.WorkOrderIssueDBDAOsearchCurrCdRSQL;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration.WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TrsAgmtAplyVndrVO;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 * History
 * 2010.09.13 최종혁 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
 */
public class AgreementImportDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
     * Agreement Header 정보를 조회
     * 
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet searchAgmtHdr(EsdTrs0220Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("fm_agmtno", event.getFm_agmtno());
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtHdrRSQL(), param,param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }
    
    /**
     * Agreement Child S/P정보 조회
     * 
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet searchAgmtChdVndr(EsdTrs0220Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("fm_agmtno", event.getFm_agmtno());
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtChdVndrRSQL(), param,param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }

    /**
     * Agreement S/P명 조회<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet searchVenderName(EsdTrs0220Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vndr_prmry_seq", event.getFm_vndr_prmry_seq());

        /* AGREEMENT KEY 존재여부 체크 로직 */
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchVenderNameRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 

        return dRs;
    }
    
    /**
     * Agreement S/P명 조회<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet searchContractOffice(EsdTrs0220Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ctrt_ofc_cd", event.getFmCtrtOfcCd());

        /* AGREEMENT KEY 존재여부 체크 로직 */
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchContractOfficeRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 

        return dRs;
    }
    
    /**
     * Agreement 중복여부 조회<br>
     *
     * @param model
     * @return
     * @throws DAOException
     */
    public DBRowSet searchAgmtDupChk(SearchAgmtHdrVO model) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, String> paramVo = model.getColumnValues();
        param.putAll(paramVo);

        /* AGREEMENT KEY 존재여부 체크 로직 */
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtDupChkRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 

        return dRs;
    }
    
    /**
     * Agreement Header 정보를 저장
     * 
     * @param model
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public String multiAgmtHdr(SearchAgmtHdrVO model) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        int insCnt  = 0;
        DBRowSet dRs = null;
        String rtn_agmt_no = "";
        try {
            Map<String, String> paramVo = model.getColumnValues();
            param.putAll(paramVo);

            dRs  = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiAgmtHdrCreateSeqNoRSQL(), param, param);
            if(dRs.next()){    
                String seq = dRs.getString("seq");
                param.put("trsp_agmt_seq", Integer.parseInt(seq, 10)); 
                rtn_agmt_no = param.get("trsp_agmt_ofc_cty_cd") + dRs.getString("seq");
            }

            insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrCSQL(), param, param);
            if(insCnt == Statement.EXECUTE_FAILED){
                throw new DAOException("Fail to insert SQL");
            }
            
            //PRIMARY S/P CODE 등록
            insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrVndrRSQL(), param, param);
            if(insCnt == Statement.EXECUTE_FAILED){
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        }
        return rtn_agmt_no;
    }
    
    /**
     * Agreement Header 정보를 업데이트
     * 
     * @param event
     * @throws DAOException
     * @throws Exception
     */
    public void multiAgmtHdrRmk(EsdTrs0220Event event) throws DAOException,Exception {
        Map<String,Object> param = new HashMap<String,Object>();
        int insCnt  = 0;
        try {
            SearchAgmtHdrVO[] model = event.getSearchAgmtHdrVOs();
            Map<String, String> paramVo = model[0].getColumnValues();
            param.putAll(paramVo);
    
            String fm_account_ofc_cd = event.getFm_account_ofc_cd();
            String fm_account_usr_id = event.getFm_account_usr_id();
            param.put("fm_account_ofc_cd",     fm_account_ofc_cd);
            param.put("fm_account_usr_id",     fm_account_usr_id);        
            
            insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrRmkUSQL(), param, param);
            if(insCnt == Statement.EXECUTE_FAILED){
                throw new DAOException("Fail to insert SQL");
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        }
    }

    /**
     * TrsAgmtAplyVndrVO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     *
     * @param event
     * @throws DAOException
     */
    public void multiAgmtHdrVndr(EsdTrs0220Event event) throws DAOException {
        try {
            int insCnt[] = null;
            SQLExecuter sqlExe = new SQLExecuter("");
            TrsAgmtAplyVndrVO[] model = event.getTrsAgmtAplyVndrVOs();
            Map<String,Object> param = new HashMap<String,Object>();

            Collection<TrsAgmtAplyVndrVO> insertVoList = new ArrayList<TrsAgmtAplyVndrVO>();
            Collection<TrsAgmtAplyVndrVO> deleteVoList = new ArrayList<TrsAgmtAplyVndrVO>();

            //String fm_account_ofc_cd = event.getFm_account_ofc_cd();
            String fm_account_ofc_cd = event.getFmCtrtOfcCd();

            String fm_account_usr_id = event.getFm_account_usr_id();
            param.put("fm_account_ofc_cd",     fm_account_ofc_cd);
            param.put("fm_account_usr_id",     fm_account_usr_id);
            
            for ( int i=0; i<model.length; i++ ) {
                if ( model[i].getIbflag().equals("I")){
                    insertVoList.add(model[i]);
                } else if ( model[i].getIbflag().equals("D")){
                    deleteVoList.add(model[i]);
                } 
            }
            
            //1. Insert
            if(insertVoList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementImportDBDAOMultiAgmtHdrVndrCSQL(), insertVoList, param, param);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

            //2. Delete
            if(deleteVoList.size() > 0){    
                insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementImportDBDAOMultiAgmtHdrVndrUSQL(), deleteVoList, param, param);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }
            }
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * Verify시 필요한 Sequence를 조회한다.<br>
     *
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet createNewAgmtTmpSeq() throws DAOException {
        DBRowSet dRs = null;
        try {
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL(), null, null);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }
    
    /**
     * setting vo
     * 
     * @param from_vo
     * @param to_vo
     */
    public void setVos(DummyAgmtRateVO from_vo, DummyAgmtRateVO to_vo) {
        to_vo.setEqKndCd(from_vo.getEqKndCd());
        to_vo.setAgmtTrspTpCd(from_vo.getAgmtTrspTpCd());
        // 2015.03.12    Chanwoo Park
        to_vo.setTrspBndCd(from_vo.getTrspBndCd());
        to_vo.setCgoTpCd(from_vo.getCgoTpCd());
        // 2015.03.12    Chanwoo Park
        to_vo.setSpclCgoCntrTpCd(from_vo.getSpclCgoCntrTpCd());
        to_vo.setTrspCostModCd(from_vo.getTrspCostModCd());
        to_vo.setCustCd(from_vo.getCustCd());
        to_vo.setCmdtGrpCd(from_vo.getCmdtGrpCd());
        to_vo.setRailSvcTpCd(from_vo.getRailSvcTpCd());
        to_vo.setFmNodCd(from_vo.getFmNodCd());
        to_vo.setViaNodCd(from_vo.getViaNodCd());
        to_vo.setDorNodCd(from_vo.getDorNodCd());
        to_vo.setToNodCd(from_vo.getToNodCd());
        to_vo.setFmNodYd(from_vo.getFmNodYd());
        to_vo.setViaNodYd(from_vo.getViaNodYd());
        to_vo.setDorNodYd(from_vo.getDorNodYd());
        to_vo.setToNodYd(from_vo.getToNodYd());
        to_vo.setEffFmDt(from_vo.getEffFmDt());
        to_vo.setEffToDt(from_vo.getEffToDt());
        // 2016.03.09 S.W. Kim
        to_vo.setToWgt(from_vo.getToWgt()==null?null:from_vo.getToWgt().toUpperCase());
        log.debug("TO_WGT BEFORE : " + from_vo.getToWgt() + " => TO_WGT AFTER : " + to_vo.getToWgt());
        to_vo.setCurrCd(from_vo.getCurrCd());
        to_vo.setTrspOneWyRt(from_vo.getTrspOneWyRt());
        to_vo.setTrspRndRt(from_vo.getTrspRndRt());
        to_vo.setTrspAgmtRtTpCd(from_vo.getTrspAgmtRtTpCd());
        to_vo.setWgtMeasUtCd(from_vo.getWgtMeasUtCd());
        to_vo.setTrspAgmtBdlQty(from_vo.getTrspAgmtBdlQty());
        to_vo.setWtrRcvTermCd(from_vo.getWtrRcvTermCd());
        to_vo.setWtrDeTermCd(from_vo.getWtrDeTermCd());
        to_vo.setTrspAgmtDist(from_vo.getTrspAgmtDist());
        to_vo.setDistMeasUtCd(from_vo.getDistMeasUtCd());
        to_vo.setTrspDistTpCd(from_vo.getTrspDistTpCd());
        to_vo.setTrspScgCd(from_vo.getTrspScgCd());
        to_vo.setAgmtRoutAllFlg((from_vo.getAgmtRoutAllFlg()));
        to_vo.setIbflag(from_vo.getIbflag());
        to_vo.setAgmtScgRtDivCd(from_vo.getAgmtScgRtDivCd());
        to_vo.setTrspRvsAplyFlg(from_vo.getTrspRvsAplyFlg());
        to_vo.setRowno(from_vo.getUiSeqno());
        to_vo.setUsrDefRmk(from_vo.getUsrDefRmk());
        to_vo.setAftUsrDefRmk(from_vo.getAftUsrDefRmk());
        to_vo.setTrspAgmtRtSeq(from_vo.getTrspAgmtRtSeq());
        to_vo.setTrspAgmtRtTpSerNo(from_vo.getTrspAgmtRtTpSerNo());
        to_vo.setTrspAgmtNodSeq(from_vo.getTrspAgmtNodSeq());
        to_vo.setAgmtCostFlg(from_vo.getAgmtCostFlg()); // COA case div code
    }
    
    /**
     * Pair Type AgreementFileImport 의 Verify 수행<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public EsdTrs0221Event insertAgreementVerifyData(EsdTrs0221Event event) throws DAOException {
        DummyAgmtRateVO[] model = event.getDummyAgmtRateVOs();
        Collection<DummyAgmtRateVO> insModels = new ArrayList<DummyAgmtRateVO>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("trsp_tmp_seq",          event.getTrspAgmtTmpSeq());
        param.put("fm_agmtno",             event.getFm_agmtno());
        param.put("fm_trsp_agmt_rt_tp_cd", event.getFm_trsp_agmt_rt_tp_cd());
        param.put("fm_eq_knd_cd",          event.getFm_eq_knd_cd());
        String fm_eq_knd_cd = event.getFm_eq_knd_cd();
        int chk_row = 0;

        try {
            //DummyAgmtRateVO dummy = new DummyAgmtRateVO(); //Equipment가 없을 경우엔 java오류가 발생하므로 오류발생을 방지하기 위해서 추가된 코드
            //insModels.add(dummy);

            for(int i=0;i<model.length;i++) {
                chk_row = 0;

                //if (model[i].getComScgAplyFlg().equals("1") && model[i].getWoAplyFlg().equals("0"))
                if (model[i].getComScgAplyFlg().equals("1")) {
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspCostModCd(model[i].getTrspCostModCd());
                    model_sub.setAgmtTrspTpCd(model[i].getAgmtTrspTpCd());
                    model_sub.setTrspBndCd(model[i].getTrspBndCd());
                    model_sub.setCgoTpCd(model[i].getCgoTpCd());
                    model_sub.setSpclCgoCntrTpCd(model[i].getSpclCgoCntrTpCd());
                    model_sub.setCustCd(model[i].getCustCd());
                    model_sub.setCmdtGrpCd(model[i].getCmdtGrpCd());
                    model_sub.setRailSvcTpCd(model[i].getRailSvcTpCd());
                    model_sub.setTrspAgmtEqTpCd("XX");
                    model_sub.setTrspAgmtEqSzCd("XX");
                    model_sub.setEffFmDt(model[i].getEffFmDt()==null?"19000101":model[i].getEffFmDt());
                    model_sub.setEffToDt(model[i].getEffToDt()==null?"99991231":model[i].getEffToDt());
                    model_sub.setTrspScgCd(model[i].getTrspScgCd());
                    model_sub.setDeltFlg("N"); 
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    // eq_tp_sz_cd is ALAL or XXXX in case of Common-Apply
                    if(model[i].getEqAlalRtSeq()!=null && model[i].getEqAlalRtSeq().length() > 0) {
                    	model_sub.setTrspAgmtRtSeq(model[i].getEqAlalRtSeq());
                    } else if(model[i].getEqXxxxRtSeq()!=null && model[i].getEqXxxxRtSeq().length() > 0) {
                    	model_sub.setTrspAgmtRtSeq(model[i].getEqXxxxRtSeq());
                    }
                    insModels.add(model_sub);
                }

                if (model[i].getEqD2().equals("1")) { //D2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD3().equals("1")) { //D3
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("3");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD3RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD4().equals("1")) { //D4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD5().equals("1")) { //D5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD7().equals("1")) { //D7
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("7");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD7RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD8().equals("1")) { //D8
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("8");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD8RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqD9().equals("1")) { //D9
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("9");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqD9RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqDw().equals("1")) { //DW
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("W");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqDwRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqDx().equals("1")) { //DX
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("X");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqDxRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqR2().equals("1")) { //R2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("R");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqR2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqR4().equals("1")) { //R4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("R");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqR4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqR5().equals("1")) { //R5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("R");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqR5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqR7().equals("1")) { //R7
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("R");
                    model_sub.setTrspAgmtEqSzCd("7");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqR7RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqA2().equals("1")) { //A2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("A");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqA2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqA4().equals("1")) { //A4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("A");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqA4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqF2().equals("1")) { //F2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("F");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqF2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqF4().equals("1")) { //F4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("F");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqF4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqF5().equals("1")) { //F5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("F");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqF5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqT2().equals("1")) { //T2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("T");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqT2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqT4().equals("1")) { //T4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("T");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqT4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqS2().equals("1")) { //S2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("S");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqS2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqS4().equals("1")) { //S4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("S");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqS4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqO2().equals("1")) { //O2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("O");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqO2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqO4().equals("1")) { //O4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("O");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqO4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqP2().equals("1")) { //P2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("P");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqP2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqP4().equals("1")) { //P4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("P");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqP4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSf2().equals("1")) { //SF2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("SF");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSf2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSf4().equals("1")) { //SF4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("SF");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSf4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSl2().equals("1")) { //SL2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("SL");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSl2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqTa2().equals("1")) { //TA2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("TA");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqTa2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqGn4().equals("1")) { //GN4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("GN");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqGn4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqGn5().equals("1")) { //GN5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("GN");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqGn5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqEg5().equals("1")) { //EG5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("EG");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqEg5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqEg8().equals("1")) { //EG8
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("EG");
                    model_sub.setTrspAgmtEqSzCd("8");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqEg8RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqZt4().equals("1")) { //ZT4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("ZT");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqZt4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqCb4().equals("1")) { //CB4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("CB");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqCb4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqCg().equals("1")) { //CG
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("CG");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqCgRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqUg().equals("1")) { //UG
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("UG");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqUgRtSeq());
                    insModels.add(model_sub);
                }
                
                if (model[i].getEqAlal().equals("1")) { //ALAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    log.debug("getTrspAgmtRtTpSerNo : " + model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAlalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqDal().equals("1")) { //DAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("D");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqDalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqRal().equals("1")) { //RAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("R");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqRalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAal().equals("1")) { //AAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("A");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqFal().equals("1")) { //FAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("F");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqFalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqTal().equals("1")) { //TAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("T");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqTalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSal().equals("1")) { //SAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("S");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqOal().equals("1")) { //OAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("O");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqOalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqPal().equals("1")) { //PAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("P");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqPalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl2().equals("1")) { //AL2
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("2");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl2RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl4().equals("1")) { //AL4
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("4");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl4RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl5().equals("1")) { //AL5
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("5");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl5RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl7().equals("1")) { //AL7
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("7");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl7RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl8().equals("1")) { //AL8
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("8");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl8RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqAl9().equals("1")) { //AL9
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("AL");
                    model_sub.setTrspAgmtEqSzCd("9");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqAl9RtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSfal().equals("1")) { //SFAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("SF");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSfalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqSlal().equals("1")) { //SLAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("SL");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqSlalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqTaal().equals("1")) { //TAAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("TA");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqTaalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqGnal().equals("1")) { //GNAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("GN");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqGnalRtSeq());
                    insModels.add(model_sub);
                }
                if (model[i].getEqEgal().equals("1")) { //EGAL
                    DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                    setVos(model[i], model_sub);
                    model_sub.setTrspAgmtEqTpCd("EG");
                    model_sub.setTrspAgmtEqSzCd("AL");
                    model_sub.setDeltFlg("N");
                    model_sub.setComScgAplyFlg(model[i].getComScgAplyFlg());
                    model_sub.setWoAplyFlg(model[i].getWoAplyFlg());
                    model_sub.setChkRowno((chk_row++)+"");
                    model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                    model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                    model_sub.setTrspAgmtRtSeq(model[i].getEqEgalRtSeq());
                    insModels.add(model_sub);
                }

                //삭제 데이타 저장
                if (model[i].getOrgRtSeq().length() > 0) {
                    //List<String> arr_orgEqno = new ArrayList();
                    List<String> arr_orgRtSeq = new ArrayList();
                    //arr_orgEqno = this.seperationParameter(model[i].getOrgEqtype(), ","); // SAMPLE : model[i].getOrgEqtype() => R2,D4,AL7
                    arr_orgRtSeq = this.seperationParameter(model[i].getOrgRtSeq().toUpperCase(), ","); // SAMPLE : model[i].getOrgRtSeq()  => 0,0,d4_3928493,0,0,r2_3029486,al7_5738375
                    //log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1 " + model[i].getOrgEqtype() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2 " + model[i].getOrgRtSeq() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    for(int j=0;j<arr_orgRtSeq.size();j++){
                    	// skip data is 0
                    	if(arr_orgRtSeq.get(j).equals("0")) {
                    		continue;
                    	}
                    	
                    	// split EqType and EqSeq
                    	String[] eqTpAndEqSeq = arr_orgRtSeq.get(j).split("_");
                    	
                        if(fm_eq_knd_cd.equals("U")) {
                            DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                            setVos(model[i], model_sub);
                            if (eqTpAndEqSeq[0].length() == 2) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 1));
                                model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(1, 2));
                            }else if (eqTpAndEqSeq[0].length() == 3) {
                                if (eqTpAndEqSeq[0].substring(0,2).equals("AL")) {
                                    model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 2));
                                    model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(2, 3));
                                }else{
                                    model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 1));
                                    model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(1, 3));
                                }
                            }else if (eqTpAndEqSeq[0].length() == 4) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 2));
                                model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(2, 4));
                            }
                            
                            model_sub.setChkRowno((chk_row++)+"");
                            model_sub.setDeltFlg("Y");
                            model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                            model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                            // TRSP_AGMT_RT_SEQ
//                            for(int jj=0; jj<arr_orgRtSeq.size(); jj++){
//                            	if(arr_orgRtSeq.get(jj).indexOf(eqTpAndEqSeq[0].toLowerCase()) > -1) {
                            		model_sub.setTrspAgmtRtSeq(eqTpAndEqSeq[1]);
//                            	}
//                            }
                            insModels.add(model_sub);
                        }else if(fm_eq_knd_cd.equals("Z")) {
                            DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                            setVos(model[i], model_sub);
                            if (eqTpAndEqSeq[0].length() == 3 ) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 2));
                                model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(2, 3));
                            }else if (eqTpAndEqSeq[0].length() == 4 ) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 2));
                                model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(2, 4));
                            }
                            
                            model_sub.setChkRowno((chk_row++)+"");
                            model_sub.setDeltFlg("Y");
                            model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                            model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                            // TRSP_AGMT_RT_SEQ
//                            for(int jj=0; jj<arr_orgRtSeq.size(); jj++){
//                            	if(arr_orgRtSeq.get(jj).indexOf(eqTpAndEqSeq[0].toLowerCase()) > -1) {
                            		model_sub.setTrspAgmtRtSeq(eqTpAndEqSeq[1]);
//                            	}
//                            }
                            insModels.add(model_sub);
                        }else{
                            DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
                            setVos(model[i], model_sub);
                            if (eqTpAndEqSeq[0].length() == 2 ) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0]);
                            }else if (eqTpAndEqSeq[0].length() == 4 ) {
                                model_sub.setTrspAgmtEqTpCd(eqTpAndEqSeq[0].substring(0, 2));
                                model_sub.setTrspAgmtEqSzCd(eqTpAndEqSeq[0].substring(2, 4));
                            }
                            
                            model_sub.setChkRowno((chk_row++)+"");
                            model_sub.setDeltFlg("Y");
                            model_sub.setTrspAgmtRtTpSerNo(model[i].getTrspAgmtRtTpSerNo());
                            model_sub.setTrspAgmtNodSeq(StringUtils.defaultIfEmpty(model[i].getTrspAgmtNodSeq(), model[i].getTrspAgmtScgNodSeq()));
                            // TRSP_AGMT_RT_SEQ
//                            for(int jj=0; jj<arr_orgRtSeq.size(); jj++){
//                            	if(arr_orgRtSeq.get(jj).indexOf(eqTpAndEqSeq[0].toLowerCase()) > -1) {
                            		model_sub.setTrspAgmtRtSeq(eqTpAndEqSeq[1]);
//                            	}
//                            }
                            insModels.add(model_sub);
                        } 
                    }
                }
            }

            new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOInsertAgreementVerifyDataCSQL(),insModels, param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return event;
    }
    
    /**
     * Pair Type AgreementFileImport 의 Verify 수행<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet verifyAgmtPair(EsdTrs0221Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtPairRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }
    
    /**
     * Pair Type AgreementFileImport 의 Verify 수행<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    /* distance type 미사용으로 인한 제거
    public DBRowSet verifyAgmtDistance(EsdTrs0221Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtDistanceRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }*/
    
    /**
     * Pair Type AgreementFileImport 의 Verify 수행<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public EsdTrs0221Event deleteAgmtVerifyData(EsdTrs0221Event event) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            param.put("trsp_tmp_seq", event.getTrspAgmtTmpSeq());
            new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteAgmtVerifyDataDSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return event;
    }

    /**
     * Agreement Surcharge 의 Verify 수행<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public DBRowSet verifyAgmtSurcharge(EsdTrs0221Event event) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtSurchargeRSQL(), param, param);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
    }
    
    /**
     * @param event
     * @return
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DBRowSet searchSubOfcCd(EsdTrs0221Event event) throws DAOException {
        DBRowSet dRs = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            String ctrt_office = event.getFm_ctrt_ofc_cd();
            List<String> arr_office = new ArrayList();
            arr_office = this.seperationParameter(ctrt_office, ","); 
            param.put("arr_office", arr_office);
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchSubOfcCdRSQL(), param,param);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dRs;
    }
    
    /**
     * Agreement Rate정보 삭제 처리
     * 
     * @param event
     * @throws DAOException
     */
    public void deleteCorrRateAgmt(EsdTrs0221Event event) throws DAOException {
        DBRowSet rs_Rate     = null;
        List<Map<String, String>> modelsDelete = new ArrayList<Map<String, String>>();
        List<Map<String, String>> modelsHistory = new ArrayList<Map<String, String>>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
        param.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
        param.put("fm_account_usr_id", event.getFm_account_usr_id());
        try{
            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAODeleteCorrRateAgmtRSQL(), param, param);

            while(rs_Rate.next()) {
                Map<String,String> param_ = new HashMap<String,String>();
                param_.put("trsp_tmp_seq",           event.getTrspAgmtTmpSeq());
                param_.put("fm_account_ofc_cd",      event.getFm_account_ofc_cd());
                param_.put("fm_account_usr_id",      event.getFm_account_usr_id());
                param_.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
                param_.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
                param_.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
                param_.put("trsp_agmt_nod_seq",      rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
                param_.put("trsp_agmt_rt_seq",       rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
            
                //데이타를 삭제하기 전에 History 테이블에 기록한다.
                modelsHistory.add(param_);
                modelsDelete.add(param_);
            }
            
    		int insCnt[] = null;
			if(modelsHistory.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAODeleteCorrRateAgmtHisCSQL(), modelsHistory, param);
				log.debug("<<<<< HISTORY COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert history No"+ j + " SQL");
				}
			}
			if(modelsDelete.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAODeleteCorrRateAgmtDSQL(), modelsDelete, param);
				log.debug("<<<<< DELETE COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ j + " SQL");
				}
			}
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
    }
    
    /**
     * Agreement Rate 저장
     * 
     * @param event
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public EsdTrs0221Event multiCorrRateAgmt(EsdTrs0221Event event) throws DAOException,Exception {
//        DBRowSet rs_RateType = null;
//        DBRowSet rs_Node     = null;
        DBRowSet rs_Seq      = null;
        DBRowSet rs_Rate     = null;
//        String sDupChk = "";
        String sEqSeq  = "";
        String sToWgt  = "";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
        param.put("fm_agmtno",         event.getFm_agmtno());
        param.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
        param.put("fm_account_usr_id", event.getFm_account_usr_id());

        try {
            // 1. Rate Type Check
//            rs_RateType = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeRSQL(), param, param);
//            while(rs_RateType.next()) {
//                sDupChk = rs_RateType.getString("TRSP_AGMT_RT_TP_SER_NO");

//                param.put("trsp_agmt_ofc_cty_cd",   rs_RateType.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param.put("trsp_agmt_seq",          rs_RateType.getString("TRSP_AGMT_SEQ"));
//                param.put("trsp_agmt_rt_tp_cd",     rs_RateType.getString("TRSP_AGMT_RT_TP_CD"));
//                param.put("trsp_bnd_cd",            rs_RateType.getString("TRSP_BND_CD"));
//                param.put("cgo_tp_cd",              rs_RateType.getString("CGO_TP_CD"));
//                param.put("spcl_cgo_cntr_tp_cd",    rs_RateType.getString("SPCL_CGO_CNTR_TP_CD"));
//                param.put("cust_nomi_trkr_flg",     rs_RateType.getString("CUST_NOMI_TRKR_FLG"));
//                param.put("cust_cnt_cd",            rs_RateType.getString("CUST_CNT_CD"));
//                param.put("cust_seq",               rs_RateType.getString("CUST_SEQ"));
//                param.put("trsp_cost_mod_cd",       rs_RateType.getString("TRSP_COST_MOD_CD"));
//                param.put("agmt_trsp_tp_cd",        rs_RateType.getString("AGMT_TRSP_TP_CD"));
//                param.put("cmdt_grp_cd",            rs_RateType.getString("CMDT_GRP_CD"));
//                param.put("rail_svc_tp_cd",         rs_RateType.getString("RAIL_SVC_TP_CD"));
//                param.put("trsp_agmt_rt_tp_ser_no", rs_RateType.getString("TRSP_AGMT_RT_TP_SER_NO"));

                // Rate Type exists
                // TODO remove UPDATE
//                if (sDupChk.length() > 0) {
//                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL(), param, param);
//                } else {
                    // 1.1 Rate Type Creation
                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL(), param, param);
                    // 1.1 Rate Type Update
                    param.put("rt_gbn", "BZC");
                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL(), param, param);
//                }
//            }

            // 2. Node Check
//            rs_Node = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL(), param, param);
//            while(rs_Node.next()) {
//                sDupChk = rs_Node.getString("TRSP_AGMT_NOD_SEQ");
//                param.put("trsp_agmt_ofc_cty_cd",   rs_Node.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param.put("trsp_agmt_seq",          rs_Node.getString("TRSP_AGMT_SEQ"));
//                param.put("fm_nod_cd",              rs_Node.getString("FM_NOD_CD"));
//                param.put("via_nod_cd",             rs_Node.getString("VIA_NOD_CD"));
//                param.put("dor_nod_cd",             rs_Node.getString("DOR_NOD_CD"));
//                param.put("to_nod_cd",              rs_Node.getString("TO_NOD_CD"));
//                param.put("trsp_agmt_dist",         rs_Node.getString("TRSP_AGMT_DIST"));
//                param.put("dist_meas_ut_cd",        rs_Node.getString("DIST_MEAS_UT_CD"));
//                param.put("trsp_dist_tp_cd",        rs_Node.getString("TRSP_DIST_TP_CD"));
//                param.put("trsp_agmt_rt_tp_ser_no", rs_Node.getString("TRSP_AGMT_RT_TP_SER_NO"));
//                param.put("trsp_agmt_nod_seq",      rs_Node.getString("TRSP_AGMT_NOD_SEQ"));

                // Node exists
                // TODO remove UPDATE
//                if (sDupChk.length() > 0) {
//                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtNodeUSQL(), param, param);
//                } else {
                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtNodeCSQL(), param, param);
//                }
//            }

            // 3. Delete unchecked Data before INSERT or UPDATE
//            param.put("chk_delt", "Y");
//            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL(), param, param);
//            while(rs_Rate.next()) {
//                sDupChk = rs_Rate.getString("TRSP_AGMT_RT_SEQ");
//                param.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
//                param.put("eff_fm_dt",              rs_Rate.getString("EFF_FM_DT"));
//                param.put("eff_to_dt",              rs_Rate.getString("EFF_TO_DT"));
//                param.put("curr_cd",                rs_Rate.getString("CURR_CD"));
//                param.put("trsp_one_wy_rt",         rs_Rate.getString("TRSP_ONE_WY_RT"));
//                param.put("trsp_rnd_rt",            rs_Rate.getString("TRSP_RND_RT"));
//                param.put("wtr_rcv_term_cd",        rs_Rate.getString("WTR_RCV_TERM_CD"));
//                param.put("wtr_de_term_cd",         rs_Rate.getString("WTR_DE_TERM_CD"));
//                param.put("trsp_agmt_bdl_qty",      rs_Rate.getString("TRSP_AGMT_BDL_QTY"));
//                param.put("to_wgt",                 rs_Rate.getString("TO_WGT"));
//                param.put("wgt_meas_ut_cd",         rs_Rate.getString("WGT_MEAS_UT_CD"));
//                param.put("trsp_rvs_aply_flg",      rs_Rate.getString("TRSP_RVS_APLY_FLG"));
//                param.put("trsp_agmt_eq_tp_sz_cd",  rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
//                param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
//                param.put("trsp_agmt_nod_seq",      rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
//                param.put("trsp_agmt_rt_seq",       rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
//                param.put("eq_knd_cd",              rs_Rate.getString("EQ_KND_CD"));
//                param.put("delt_flg",               rs_Rate.getString("DELT_FLG"));

                // write History when Rate exists 
//                if (sDupChk.length() > 0) {
                    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForDeleteCSQL(), param, param);
//                }

                new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateDSQL(), param, param);
//            }

            // 4. INSERT, UPDATE
//            List<Map<String, String>> modelsUpdate = new ArrayList<Map<String, String>>();
            List<Map<String, String>> modelsCreate = new ArrayList<Map<String, String>>();
//            List<Map<String, String>> modelsHistory = new ArrayList<Map<String, String>>();
            Map<String,String> param2 = new HashMap<String,String>();
            param2.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
            param2.put("chk_delt", "N");
            
            // TODO 조회 DBRowSet을 사용하지 않고, INSERT, UPDATE, HISTORY 쿼리에서 TEMP 테이블을 직접 JOIN하여 질의수행하는 방법으로 변경
            // 4.1. INSERT
            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateNewRSQL(), param2, param2);
        	log.debug("RowCount   >>>>>>> " + String.valueOf(rs_Rate.getRowCount()));
        	if(rs_Rate.getRowCount() > 0) {
                Map<String,String> param_seq = new HashMap<String,String>();
                param_seq.put("new_agmt_cnt",        String.valueOf(rs_Rate.getRowCount()));
        		rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param_seq, param_seq);
        	}
            
            int logCnt = 0;
            while(rs_Rate.next()) {
                Map<String,String> param_ = new HashMap<String,String>();
                param_.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
                param_.put("fm_agmtno",         event.getFm_agmtno());
                param_.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
                param_.put("fm_account_usr_id", event.getFm_account_usr_id());
                param_.put("chk_delt", "N");
                
                param_.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
                param_.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
                param_.put("eff_fm_dt",              rs_Rate.getString("EFF_FM_DT"));
                param_.put("eff_to_dt",              rs_Rate.getString("EFF_TO_DT"));
                param_.put("curr_cd",                rs_Rate.getString("CURR_CD"));
                param_.put("trsp_one_wy_rt",         rs_Rate.getString("TRSP_ONE_WY_RT"));
                param_.put("trsp_rnd_rt",            rs_Rate.getString("TRSP_RND_RT"));
                param_.put("wtr_rcv_term_cd",        rs_Rate.getString("WTR_RCV_TERM_CD"));
                param_.put("wtr_de_term_cd",         rs_Rate.getString("WTR_DE_TERM_CD"));
                param_.put("trsp_agmt_bdl_qty",      rs_Rate.getString("TRSP_AGMT_BDL_QTY"));
                param_.put("to_wgt",                 rs_Rate.getString("TO_WGT"));
                param_.put("wgt_meas_ut_cd",         rs_Rate.getString("WGT_MEAS_UT_CD"));
                param_.put("trsp_rvs_aply_flg",      rs_Rate.getString("TRSP_RVS_APLY_FLG"));
                param_.put("trsp_agmt_eq_tp_sz_cd",  rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
                param_.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
                param_.put("trsp_agmt_nod_seq",      rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
                param_.put("trsp_agmt_rt_seq",       rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
                param_.put("eq_knd_cd",              rs_Rate.getString("EQ_KND_CD"));
                param_.put("delt_flg",               rs_Rate.getString("DELT_FLG"));
                param_.put("usr_def_rmk",            rs_Rate.getString("USR_DEF_RMK"));
                param_.put("aft_usr_def_rmk",        rs_Rate.getString("AFT_USR_DEF_RMK"));
                param_.put("agmt_cost_flg",          rs_Rate.getString("AGMT_COST_FLG"));
                
            	logCnt ++;
            	log.debug(">>>>>>> " + logCnt);
                if (rs_Seq != null && rs_Seq.next()) {
                    sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
                }
                param_.put("trsp_agmt_rt_seq", sEqSeq);
                sToWgt = rs_Rate.getString("TO_WGT");
                if (sToWgt.equals("999999.99") || sToWgt.equals("0")) {
                    param_.put("wgt_meas_ut_cd", "XXX");
                }
                modelsCreate.add(param_);
            }

    		int insCnt[] = null;
			if(modelsCreate.size() > 0){
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOMultiCorrRateAgmtEqRateCSQL(), modelsCreate, param);
				log.debug("<<<<< INSERT COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
				
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOMultiCorrRateAgmtEqRateHisCSQL(), modelsCreate, param);
				log.debug("<<<<< HISTORY COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert history No"+ j + " SQL");
				}
			}
            
            // 4.2. UPDATE
//            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateNewRSQL(), param2, param2);
//            while(rs_Rate.next()) {
                Map<String,String> param_ = new HashMap<String,String>();
                param_.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
                param_.put("fm_agmtno",         event.getFm_agmtno());
                param_.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
                param_.put("fm_account_usr_id", event.getFm_account_usr_id());
                param_.put("chk_delt", "N");
//                
//                sDupChk = rs_Rate.getString("TRSP_AGMT_RT_SEQ");
//                param_.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param_.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
//                param_.put("eff_fm_dt",              rs_Rate.getString("EFF_FM_DT"));
//                param_.put("eff_to_dt",              rs_Rate.getString("EFF_TO_DT"));
//                param_.put("curr_cd",                rs_Rate.getString("CURR_CD"));
//                param_.put("trsp_one_wy_rt",         rs_Rate.getString("TRSP_ONE_WY_RT"));
//                param_.put("trsp_rnd_rt",            rs_Rate.getString("TRSP_RND_RT"));
//                param_.put("wtr_rcv_term_cd",        rs_Rate.getString("WTR_RCV_TERM_CD"));
//                param_.put("wtr_de_term_cd",         rs_Rate.getString("WTR_DE_TERM_CD"));
//                param_.put("trsp_agmt_bdl_qty",      rs_Rate.getString("TRSP_AGMT_BDL_QTY"));
//                param_.put("to_wgt",                 rs_Rate.getString("TO_WGT"));
//                param_.put("wgt_meas_ut_cd",         rs_Rate.getString("WGT_MEAS_UT_CD"));
//                param_.put("trsp_rvs_aply_flg",      rs_Rate.getString("TRSP_RVS_APLY_FLG"));
//                param_.put("trsp_agmt_eq_tp_sz_cd",  rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
//                param_.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
//                param_.put("trsp_agmt_nod_seq",      rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
//                param_.put("trsp_agmt_rt_seq",       rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
//                param_.put("eq_knd_cd",              rs_Rate.getString("EQ_KND_CD"));
//                param_.put("delt_flg",               rs_Rate.getString("DELT_FLG"));
//                param_.put("usr_def_rmk",            rs_Rate.getString("USR_DEF_RMK"));
//                param_.put("aft_usr_def_rmk",        rs_Rate.getString("AFT_USR_DEF_RMK"));
//
//                // Rate exists
//                if (sDupChk.length() > 0) {
//                    param_.put("trsp_agmt_rt_seq", rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
//                    modelsUpdate.add(param_);
//                } else {
//                	logCnt ++;
//                	log.debug(">>>>>>> " + logCnt);
//                    rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param_, param_);
//                    if (rs_Seq.next()) {
//                        sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
//                    }
//                    param_.put("trsp_agmt_rt_seq", sEqSeq);
//                    sToWgt = rs_Rate.getString("TO_WGT");
//                    if (sToWgt.equals("999999.99") || sToWgt.equals("0"))
//                    {
//                        param_.put("wgt_meas_ut_cd", "XXX");
//                    }
//                    modelsCreate.add(param_);
//                }

                // write History
//                modelsHistory.add(param_);
//            }

            int insCnt2 = 0;
//			if(modelsUpdate.size() > 0){
				insCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL(), param, param);
				log.debug("<<<<< UPDATE COUNT >>>>> " + insCnt2);
//				if(insCnt2 == 0) {
//					throw new DAOException("Fail to update Basic AGMT");
//				}
//			}
//			if(modelsHistory.size() > 0){
				insCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateHisForUpdateCSQL(), param, param);
				log.debug("<<<<< HISTORY COUNT >>>>> " + insCnt2);
//				if(insCnt2 == 0) {
//					throw new DAOException("Fail to insert history of Basic AGMT");
//				}
//			}
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return event;
    }

    /**
     * Agreement Surcharge Rate 저장
     * 
     * @param event
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public EsdTrs0221Event multiCorrScgAgmt(EsdTrs0221Event event) throws DAOException,Exception {
//        DBRowSet rs_Node = null;
        DBRowSet rs_Seq  = null;
        DBRowSet rs_Rate = null;
//        String sDupChk = "";
        String sEqSeq  = "";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("trsp_tmp_seq",              event.getTrspAgmtTmpSeq());
        param.put("fm_agmtno",                 event.getFm_agmtno());
        param.put("fm_account_ofc_cd",         event.getFm_account_ofc_cd());
        param.put("fm_account_usr_id",         event.getFm_account_usr_id());

        try {
        	int cnt = 0;
        	boolean modified = false;
            // 1. Node Check
//            rs_Node = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL(), param, param);
//            
//            while(rs_Node.next()) {
//                sDupChk = rs_Node.getString("TRSP_AGMT_SCG_NOD_SEQ");
//                param.put("trsp_agmt_ofc_cty_cd",   rs_Node.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param.put("trsp_agmt_seq",          rs_Node.getString("TRSP_AGMT_SEQ"));
//                param.put("trsp_scg_cd",            rs_Node.getString("TRSP_SCG_CD"));
//                param.put("agmt_rout_all_flg",      rs_Node.getString("AGMT_ROUT_ALL_FLG"));
//                param.put("fm_nod_cd",              rs_Node.getString("FM_NOD_CD"));
//                param.put("via_nod_cd",             rs_Node.getString("VIA_NOD_CD"));
//                param.put("dor_nod_cd",             rs_Node.getString("DOR_NOD_CD"));
//                param.put("to_nod_cd",              rs_Node.getString("TO_NOD_CD"));
//                param.put("trsp_agmt_rt_tp_ser_no", rs_Node.getString("TRSP_AGMT_RT_TP_SER_NO"));
//                param.put("trsp_agmt_scg_nod_seq",  rs_Node.getString("TRSP_AGMT_SCG_NOD_SEQ"));
//
//            	int uptCnt = 0;
//                if (sDupChk.length() > 0) { // Node exists
//                	uptCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeUSQL(), param, param);
//					if(uptCnt == Statement.EXECUTE_FAILED) {
//						throw new DAOException("This surcharge rate's Rate Type is not same basic rate's Rate Type at your file.\nPlease check your file.");
//					}
//                } else {
                    cnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeCSQL(), param, param);
                    if(cnt>0)
                    	modified = true;
//                    uptCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeUSQL(), param, param);
//					if(uptCnt == Statement.EXECUTE_FAILED) {
//						throw new DAOException("This surcharge rate's Rate Type is not same basic rate's Rate Type at your file.\nPlease check your file.");
//					}
//                }
//            	}

            // 2. DELETE unchecked EQ type/size
//            param.put("chk_delt", "Y");
//            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL(), param, param);
//            
//            while(rs_Rate.next()) {
//                sDupChk = rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ");
//                param.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
//                param.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
//                param.put("eff_fm_dt",              rs_Rate.getString("EFF_FM_DT"));
//                param.put("eff_to_dt",              rs_Rate.getString("EFF_TO_DT"));
//                param.put("to_wgt",                 rs_Rate.getString("TO_WGT"));
//                param.put("wgt_meas_ut_cd",         rs_Rate.getString("WGT_MEAS_UT_CD"));
//                param.put("curr_cd",                rs_Rate.getString("CURR_CD"));
//                param.put("trsp_one_wy_rt",         rs_Rate.getString("TRSP_ONE_WY_RT"));
//                param.put("trsp_rnd_rt",            rs_Rate.getString("TRSP_RND_RT"));
//                param.put("trsp_agmt_eq_tp_sz_cd",  rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
//                param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
//                param.put("trsp_agmt_scg_nod_seq",  rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ2"));
//                param.put("trsp_agmt_scg_rt_seq",   rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
//                param.put("eq_knd_cd",              rs_Rate.getString("EQ_KND_CD"));
//                param.put("delt_flg",               rs_Rate.getString("DELT_FLG"));
//                param.put("agmt_scg_rt_div_cd",     rs_Rate.getString("AGMT_SCG_RT_DIV_CD"));
//                param.put("com_scg_aply_flg",       rs_Rate.getString("COM_SCG_APLY_FLG"));
//                param.put("wo_aply_flg",            rs_Rate.getString("WO_APLY_FLG"));

//                  if (sDupChk.length() > 0) { // INSERT History if Rate exists
                      new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisForDeleteCSQL(), param, param);
//                  }

                // Correction 에서 체크박스를 해제 했을 경우 (Duplication 이 아니라도 체크후 바로 해제했을 경우에도 삭제되상이 된다.)
                cnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL(), param, param);
                if(cnt>0)
                	modified = true;
//            }

            // 3. INSERT, checked EQ type/size
//            List<Map<String, String>> modelsUpdate = new ArrayList<Map<String, String>>();
            List<Map<String, String>> modelsCreate = new ArrayList<Map<String, String>>();
//            List<Map<String, String>> modelsHistory = new ArrayList<Map<String, String>>();
            Map<String,String> param2 = new HashMap<String,String>();
            param2.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
            param2.put("chk_delt", "N");
            
            rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL(), param2, param2);
        	log.debug("RowCount   >>>>>>> " + String.valueOf(rs_Rate.getRowCount()));
        	if(rs_Rate.getRowCount() > 0) {
                Map<String,String> param_seq = new HashMap<String,String>();
                param_seq.put("new_agmt_cnt",        String.valueOf(rs_Rate.getRowCount()));
                rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param_seq, param_seq);
        	}
            
            int logCnt = 0;
            while(rs_Rate.next()) {
                Map<String,String> param_ = new HashMap<String,String>();
                param_.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
                param_.put("fm_agmtno",         event.getFm_agmtno());
                param_.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
                param_.put("fm_account_usr_id", event.getFm_account_usr_id());
                param_.put("chk_delt", "N");
                
                rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ");
                param_.put("trsp_agmt_ofc_cty_cd",   rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
                param_.put("trsp_agmt_seq",          rs_Rate.getString("TRSP_AGMT_SEQ"));
                param_.put("eff_fm_dt",              rs_Rate.getString("EFF_FM_DT"));
                param_.put("eff_to_dt",              rs_Rate.getString("EFF_TO_DT"));
                param_.put("to_wgt",                 rs_Rate.getString("TO_WGT"));
                param_.put("wgt_meas_ut_cd",         rs_Rate.getString("WGT_MEAS_UT_CD"));
                param_.put("curr_cd",                rs_Rate.getString("CURR_CD"));
                param_.put("trsp_one_wy_rt",         rs_Rate.getString("TRSP_ONE_WY_RT"));
                param_.put("trsp_rnd_rt",            rs_Rate.getString("TRSP_RND_RT"));
                param_.put("trsp_agmt_eq_tp_sz_cd",  rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
                param_.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
                param_.put("trsp_agmt_scg_nod_seq",  rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ"));
                param_.put("trsp_agmt_scg_rt_seq",   rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
                param_.put("eq_knd_cd",              rs_Rate.getString("EQ_KND_CD"));
                param_.put("delt_flg",               rs_Rate.getString("DELT_FLG"));
                param_.put("agmt_scg_rt_div_cd",     rs_Rate.getString("AGMT_SCG_RT_DIV_CD"));
                param_.put("com_scg_aply_flg",       rs_Rate.getString("COM_SCG_APLY_FLG"));
                param_.put("wo_aply_flg",            rs_Rate.getString("WO_APLY_FLG"));
                param_.put("usr_def_rmk",            rs_Rate.getString("USR_DEF_RMK"));
                param_.put("aft_usr_def_rmk",        rs_Rate.getString("AFT_USR_DEF_RMK"));
                param_.put("agmt_cost_flg",          rs_Rate.getString("AGMT_COST_FLG"));

//                if (sDupChk.length() > 0) { // Rate exists
//                	param_.put("trsp_agmt_scg_nod_seq",  rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ2"));
//                	param_.put("trsp_agmt_scg_rt_seq", rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
//                    modelsUpdate.add(param_);
//                    //new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL(), param_, param_);
//                } else {
                	logCnt ++;
                	log.debug(">>>>>>> " + logCnt);
                    if (rs_Seq != null && rs_Seq.next()) {
                    	sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
                    }
                    param_.put("trsp_agmt_scg_rt_seq", sEqSeq);
                    modelsCreate.add(param_);
                    //new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateCSQL(), param_, param_);
//                }

                // INSERT History
//                modelsHistory.add(param_);
                //new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisCSQL(), param_, param_);
            }

    		int insCnt[] = null;
			if(modelsCreate.size() > 0){
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOMultiCorrScgAgmtScgRateCSQL(), modelsCreate, param);
				log.debug("<<<<< INSERT COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
				
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisCSQL(), modelsCreate, param);
				log.debug("<<<<< HISTORY COUNT >>>>> " + insCnt.length);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert history No"+ j + " SQL");
				}
				
				modified = true;
			}
			
			// 4. UPDATE checked EQ type/size
            int insCnt2 = 0;
			insCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL(), param, param);
			log.debug("<<<<< UPDATE COUNT >>>>> " + insCnt2);
			
			insCnt2 = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisForUpdateCSQL(), param, param);
			log.debug("<<<<< HISTORY COUNT >>>>> " + insCnt2);

            if(insCnt2>0)
            	modified = true;
//			if(modelsUpdate.size() > 0){
//				insCnt = new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL(), modelsUpdate, param);
//				log.debug("<<<<< UPDATE COUNT >>>>> " + insCnt.length);
//				for(int j = 0; j < insCnt.length; j++){
//					if(insCnt[j]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to update No"+ j + " SQL");
//				}
//			}
			

            // 5. Rate Type Update
            if(modified) {
            	log.debug("<<<<< CHECK >>>>> TRUE");
            	param.put("rt_gbn", "SCG");
            	new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL(), param, param);
            }else {
            	log.debug("<<<<< CHECK >>>>> FALSE");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        }
        return event;
    }
    
    /**
     * Agreement Surcharge Rate Update : CALL TRS_AGMT_RATE_CC_PKG.GET_TRS_All_RATE_PRC (Only for "Auto Apply" checked)
     * 2014.11.20    Hyungwook Choi
     * @param event
     * @return
     * @throws DAOException
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
    public EsdTrs0221Event multiCorrScgAgmtForAutoApply(EsdTrs0221Event event) throws DAOException,Exception
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        Map outProc = null;
        DBRowSet dRs = null;
        DBRowSet rs2 = null;

        Map<String,Object> param = new HashMap<String,Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        ArrayList returnList = new ArrayList();
        List<SearchTrsAgmtTmpVO> list = null;

        String bilCurrCd = null;

        param.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
        param.put("fm_agmtno",         event.getFm_agmtno());
        param.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
        param.put("fm_account_usr_id", event.getFm_account_usr_id());
        param.put("fm_vndr_prmry_seq", event.getFmVndrPrmrySeq());
        param.put("fm_agmt_ref_no",    event.getFmAgmtRefNo());

        velParam.put("trsp_tmp_seq",      event.getTrspAgmtTmpSeq());
        velParam.put("fm_agmtno",         event.getFm_agmtno());
        velParam.put("fm_account_ofc_cd", event.getFm_account_ofc_cd());
        velParam.put("fm_account_usr_id", event.getFm_account_usr_id());
        velParam.put("fm_vndr_prmry_seq", event.getFmVndrPrmrySeq());
        velParam.put("fm_agmt_ref_no",    event.getFmAgmtRefNo());

        try
        {
            param.put("OFC_CD", event.getFm_account_ofc_cd());
            
            rs2 = new SQLExecuter().executeQuery(new WorkOrderIssueDBDAOsearchCurrCdRSQL(), param, param);
            if( rs2 != null ) {
                while( rs2.next() ) {
                    bilCurrCd = JSPUtil.getNull(rs2.getString("BIL_CURR_CD"));
                }
            }

            if (bilCurrCd != null) {
            	param.put("BIL_CURR_CD", bilCurrCd);            	
            }

            dRs = new SQLExecuter().executeQuery(new AgreementImportDBDAOSearchTrsAgmtTmpRSQL(), param, param);

            List<SearchTrsAgmtTmpVO> woModel = (List)RowSetUtil.rowSetToVOs(dRs, SearchTrsAgmtTmpVO.class);

            for(int m=0; woModel != null && m<woModel.size(); m++)
            {
                param.clear();

                SearchTrsAgmtTmpVO woModel2 = woModel.get(m);

                param.put("CRE_OFC_CD",              event.getFm_account_ofc_cd());
                velParam.put("CRE_OFC_CD",           event.getFm_account_ofc_cd());

                param.put("VNDR_CD",                 event.getFmVndrPrmrySeq());
                velParam.put("VNDR_CD",              event.getFmVndrPrmrySeq());

                param.put("CRE_DT",                  woModel2.getCreDt().substring(0, 8));
                velParam.put("CRE_DT",               woModel2.getCreDt().substring(0, 8));

                // ONE WAY / ROUND TRIP
                param.put("WY_TP_CD",                "");
                velParam.put("WY_TP_CD",             "");

                param.put("EQ_KND_CD",               woModel2.getEqKndCd());
                velParam.put("EQ_KND_CD",            woModel2.getEqKndCd());

                param.put("EQ_TPSZ_CD",              woModel2.getEqTpszCd());
                velParam.put("EQ_TPSZ_CD",           woModel2.getEqTpszCd());

                param.put("TRSP_SO_CMB_TP_CD",       "");
                velParam.put("TRSP_SO_CMB_TP_CD",    "");

                param.put("CGO_TP_CD",               woModel2.getCgoTpCd());
                velParam.put("CGO_TP_CD",            woModel2.getCgoTpCd());

                param.put("TRSP_BND_CD",             "");
                velParam.put("TRSP_BND_CD",          "");

                param.put("TRSP_CRR_MOD_CD",         woModel2.getAgmtTrspTpCd());
                velParam.put("TRSP_CRR_MOD_CD",      woModel2.getAgmtTrspTpCd());

                param.put("TRSP_COST_DTL_MOD_CD",    woModel2.getTrspCostModCd());
                velParam.put("TRSP_COST_DTL_MOD_CD", woModel2.getTrspCostModCd());

                param.put("CUST_NOMI_TRKR_FLG",      woModel2.getCustNomiTrkrFlg());
                velParam.put("CUST_NOMI_TRKR_FLG",   woModel2.getCustNomiTrkrFlg());

                param.put("CUST_CNT_CD",             woModel2.getCustCntCd());
                velParam.put("CUST_CNT_CD",          woModel2.getCustCntCd());

                param.put("CUST_SEQ",                woModel2.getCustSeq());
                velParam.put("CUST_SEQ",             woModel2.getCustSeq());

                param.put("RAIL_SSVC_TP_CD",         woModel2.getRailSvcTpCd());
                velParam.put("RAIL_SSVC_TP_CD",      woModel2.getRailSvcTpCd());

                param.put("CMDT_CD",                 woModel2.getCmdtGrpCd());
                velParam.put("CMDT_CD",              woModel2.getCmdtGrpCd());

                param.put("FM_NOD_CD",               woModel2.getFmNodCd());
                velParam.put("FM_NOD_CD",            woModel2.getFmNodCd());

                param.put("VIA_NOD_CD",              woModel2.getViaNodCd());
                velParam.put("VIA_NOD_CD",           woModel2.getViaNodCd());

                param.put("DOR_NOD_CD",              woModel2.getDorNodCd());
                velParam.put("DOR_NOD_CD",           woModel2.getDorNodCd());

                param.put("TO_NOD_CD",               woModel2.getToNodCd());
                velParam.put("TO_NOD_CD",            woModel2.getToNodCd());

                param.put("BUNDLING_NO",             "");
                velParam.put("BUNDLING_NO",          "");

                param.put("WGT_MEAS_UT_CD",          woModel2.getWgtMeasUtCd());
                velParam.put("WGT_MEAS_UT_CD",       woModel2.getWgtMeasUtCd());

                param.put("CNTR_WGT",                woModel2.getToWgt());
                velParam.put("CNTR_WGT",             woModel2.getToWgt());

                param.put("WTR_RCV_TERM",            "");
                velParam.put("WTR_RCV_TERM",         "");

                param.put("WTR_DE_TERM",             woModel2.getWtrDeTermCd());
                velParam.put("WTR_DE_TERM",          woModel2.getWtrDeTermCd());

                param.put("SPCL_CGO_CNTR_TP_CD",     "");
                velParam.put("SPCL_CGO_CNTR_TP_CD",  "");
                
                outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new WorkOrderIssueDBDAOsearchWorkOrderIssueListProcRSQL(), param, param);
/*
                woModel2.setPoTrspAgmtOfcCtyCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_ofc_cty_cd")));
                woModel2.setPoTrspAgmtSeq(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_seq")));
                woModel2.setPoTrspAgmtRtTpCd(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_cd")));
                woModel2.setPoWayType(JSPUtil.getNull((String) outProc.get("po_way_type")));
                woModel2.setPoTrspAgmtRtTpNm(JSPUtil.getNull((String) outProc.get("po_trsp_agmt_rt_tp_nm")));
                woModel2.setPoSpType(JSPUtil.getNull((String) outProc.get("po_sp_type")));
                woModel2.setPoCustNomiTrkrFlg(JSPUtil.getNull((String) outProc.get("po_cust_nomi_trkr_flg")));
                woModel2.setPoCustCntCd(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd")));
                woModel2.setPoCustSeq(JSPUtil.getNull((String) outProc.get("po_cust_seq")));
                woModel2.setPoCustCntCdSeq(JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd_seq")));
//                woModel2.setPoLocalCurrCd(JSPUtil.getNull((String) outProc.get("po_local_curr_cd")));  -- curr_cd 빈칸으로 조회되어 수정함. 09/11/30
                defalutCurrStr = JSPUtil.getNull((String) outProc.get("po_local_curr_cd"));
                if(defalutCurrStr == null || "".equals(defalutCurrStr)){
                    defalutCurrStr = JSPUtil.getNull((String) woModel2.getCurrCd());
                }
                woModel2.setPoLocalCurrCd(defalutCurrStr);
                woModel2.setPoBasicRt(JSPUtil.getNull((String) outProc.get("po_basic_rt")));
                woModel2.setPoFuelScgRt(JSPUtil.getNull((String) outProc.get("po_fuel_scg_rt")));
                woModel2.setPoOverWgtScgRt(JSPUtil.getNull((String) outProc.get("po_over_wgt_scg_rt")));
                woModel2.setPoLocalCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_local_curr_tot_amt")));
                woModel2.setPoUsdCurrTotAmt(JSPUtil.getNull((String) outProc.get("po_usd_curr_tot_amt")));
                woModel2.setPoRtnCd(JSPUtil.getNull((String) outProc.get("po_rtn_cd")));
                woModel2.setPoRtnMsg(JSPUtil.getNull((String) outProc.get("po_rtn_msg")));
*/
                woModel.set(m, woModel2);
                returnList.add(woModel);
            }

            if(list == null)
                list = woModel;
            else
                list.addAll(woModel);    
            
            eventResponse.setRsVoList(list);

        }
        catch (SQLException se)
        {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch (Exception ee)
        {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        }
        return event;
    }

    /**
     * Agreement Rate정보 삭제 처리
     * 
     * @param dummyAgmtRateVO
     * @param account
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public int deleteCorrScgAgmt(DummyAgmtRateVO dummyAgmtRateVO, SignOnUserAccount account) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try {
            Map<String, String> mapVO = dummyAgmtRateVO.getColumnValues();

            param.put("fm_account_usr_id", account.getUsr_id());
            velParam.put("fm_account_usr_id", account.getUsr_id());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            // History 기록
            new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrScgAgmtHisCSQL(), param, velParam);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AgreementImportDBDAODeleteCorrScgAgmtDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to DeleteTrsAgmtScgRt SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * TRS_AGMT_TMP Delete<br>
     *
     * @param event
     * @return
     * @throws DAOException
     */
    public EsdTrs0221Event deleteTrsAgmtTmp(EsdTrs0221Event event) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteTrsAgmtTmpDSQL(), param, velParam);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return event;
    }

    /**
     * 여러개의 parameter를 나누어주는 메소드
     * Detail Inquity Popup<br>
     * 
     * @param sparameter
     * @param sSeperate
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList seperationParameter(String sparameter, String sSeperate)
    {
        ArrayList arrlist = null;
        StringTokenizer st  = null;
        int j = 0;
        if( !sparameter.equals("") )
        {
            arrlist = new ArrayList();
            st = new StringTokenizer(sparameter, sSeperate);
            while( st.hasMoreTokens() )
            {
                arrlist.add(j++, st.nextToken());
            }
        }
        return arrlist;
    }

    /**
     * @param sparameter
     * @param sSeperate
     * @return
     */
    @SuppressWarnings("null")
    public String[] seperationParameterStr(String sparameter, String sSeperate)
    {
        String[] arreq = null;
        StringTokenizer st  = null;
        int j = 0;
        if( !sparameter.equals("") )
        {
            st = new StringTokenizer(sparameter, sSeperate);
            while( st.hasMoreTokens() )
            {
                arreq[j++] = st.nextToken();
            }
        }
        return arreq;
    }
}
