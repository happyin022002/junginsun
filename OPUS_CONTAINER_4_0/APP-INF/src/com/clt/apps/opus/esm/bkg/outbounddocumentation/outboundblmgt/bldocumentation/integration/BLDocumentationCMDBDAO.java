/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationCMDAO.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.24 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMoveOpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMstInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrPkgWgtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrTpszQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MaxCycleBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.PreConfirmBkgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMvmtRtnVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.MstContainerVO;

/**
 * OPUS BLDocumentationCMDAO <br>
 * - OPUS-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Youngchul
 * @see BLDocumentationCMBCImpl 참조
 * @since J2EE 1.4
 */
public class BLDocumentationCMDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -14401432242711342L;

	/**
     *  CmCopyVO 모델에 해당하는 데이타 조회.
     *  
     * @param String vvd
     * @param String ofcCd
     * @param String pol
     * @param String pod
     * @param String cfmYn
     * @return  List<CmCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CmCopyVO> searchCntrListByVvd(String vvd, String ofcCd, String pol, String pod, String cfmYn)
            throws DAOException {
        DBRowSet dbRowset = null;
        List<CmCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
            String vvd_vsl = vvd.substring(0, 4);
            String vvd_voy = vvd.substring(4, 8);
            String vvd_dir = vvd.substring(8);

            log.debug("\n++++++++++++++++++++++++++++++++++++++++++");
            log.debug("* bkg_vvd    : " + vvd);
            log.debug("* vvd_vsl    : " + vvd_vsl);
            log.debug("* vvd_voy    : " + vvd_voy);
            log.debug("* vvd_dir    : " + vvd_dir);
            log.debug("* bkg_ofc_cd : " + ofcCd);
            log.debug("* bkg_pol    : " + pol);
            log.debug("* bkg_pod    : " + pod);
            log.debug("* cfm_flg    : " + cfmYn);
            log.debug("\n++++++++++++++++++++++++++++++++++++++++++");

            Map<String, String> mapVO = new HashMap();
            mapVO.put("vvd_vsl", vvd_vsl);
            mapVO.put("vvd_voy", vvd_voy);
            mapVO.put("vvd_dir", vvd_dir);
            mapVO.put("bkg_ofc_cd", ofcCd);
            mapVO.put("bkg_pol", pol);
            mapVO.put("bkg_pod", pod);
            mapVO.put("cfm_flg", cfmYn);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCmCopyVORSQL template = new BLDocumentationCMDBDAOCmCopyVORSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmCopyVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * EdiNotUpdCntrVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<EdiNotUpdCntrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<EdiNotUpdCntrVO> searchNotUpdCntr(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<EdiNotUpdCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOEdiNotUpdCntrRSQL template = new BLDocumentationCMDBDAOEdiNotUpdCntrRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, EdiNotUpdCntrVO.class);
        } catch(SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * ContainerVO 모델에 해당하는 데이타 조회.
     *  
     * @param String bkgNo
     * @param String caFlg 
     * @return List<ContainerVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ContainerVO> searchContainer(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<ContainerVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOContainerRSQL template = new BLDocumentationCMDBDAOContainerRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
    }

    /**
     * CntrDetailInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param String cntrNo
     * @return CntrDetailInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrDetailInfoVO searchCntrDtlInfo(String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        CntrDetailInfoVO rsVO = null;
        String likeFlg = "N";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(cntrNo.length() >= 10) {
        		likeFlg = "Y";
        	} else {
        		likeFlg = "N";
        	}
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("like_flg", likeFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrDetailRSQL template = new BLDocumentationCMDBDAOCntrDetailRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<CntrDetailInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrDetailInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }
    

    /**
     * Partial Confirm Container 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return String
     * @exception DAOException
     */
    public String searchPartialConfirm(String bkgNo, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rs  = "N";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            //mapVO.put("ca_flg", "N");
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOPtlCfrmBkgRSQL template = new BLDocumentationCMDBDAOPtlCfrmBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                rs = "Y";
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rs;
    }
    

    /**
     * CntrEtcInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return CntrEtcInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrEtcInfoVO searchEtcInfoForCntr(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        CntrEtcInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrEtcInfoRSQL template = new BLDocumentationCMDBDAOCntrEtcInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<CntrEtcInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrEtcInfoVO.class);
            if(list==null || list.size()==0){
                rsVO = new CntrEtcInfoVO();
            }else{
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * CntrPkgWgtVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @param String caFlg 
     * @return CntrPkgWgtVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrPkgWgtVO searchPkgForCntr(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        CntrPkgWgtVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOPkgForCntrRSQL template = new BLDocumentationCMDBDAOPkgForCntrRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<CntrPkgWgtVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrPkgWgtVO.class);
            if(list==null || list.size()==0){
                rsVO = new CntrPkgWgtVO();
            }else{
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * CntrTpszQtyVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @param String caFlg 
     * @return List<CntrTpszQtyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrTpszQtyVO> searchQtyForCntrByTpsz(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrTpszQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOQtyForCntrRSQL template = new BLDocumentationCMDBDAOQtyForCntrRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrTpszQtyVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
    }

    /**
     * BkgCntrSealNoVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @return List<BkgCntrSealNoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgCntrSealNoVO> searchSealNo(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgCntrSealNoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrSealNoRSQL template = new BLDocumentationCMDBDAOCntrSealNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCntrSealNoVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
    }

    /**
     * Special Cargo를 위해 등록된 Container의 존재 유무 검사.
     * 
     * @param ContainerVO containerVO
     * @return boolean
     * @exception DAOException
     */
    public boolean checkCntrNoAsgnForSpcl(ContainerVO containerVO) throws DAOException {
        DBRowSet dbRowset = null;
        boolean flag = false;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = containerVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSpclCgoRSQL template = new BLDocumentationCMDBDAOSpclCgoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                flag = true;
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return flag;
    }

    /**
     * 중복된 Container 조회.
     * 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param String cntrNo
     * @return String
     * @exception DAOException
     */
    public String searchCntrDup(CntrEtcInfoVO bkgEtcInfoVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String tgtBkgNo = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgEtcInfoVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            //log.debug("********** bkgEtcInfoVO :\n" + mapVO);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrDupRSQL template = new BLDocumentationCMDBDAOCntrDupRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                tgtBkgNo = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return tgtBkgNo;
    }
    

    /**
     * 동일한 Route를 사용하는지 여부 체크.
     * 
     * @param String src_bkgNo
     * @param String tgt_bkgNo
     * @return boolean
     * @exception DAOException
     */
    public boolean checkRouteForMoveCntr(String src_bkgNo, String tgt_bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        boolean flag = false;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("src_bkg_no", src_bkgNo);
            mapVO.put("tgt_bkg_no", tgt_bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckCntrForMoveRSQL template = new BLDocumentationCMDBDAOCheckCntrForMoveRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                flag = true;
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return flag;
    }

    /**
     * Dangerous Cargo에 대한 Image 등록 여부 체크.
     * 
     * @param ContainerVO containerVO
     * @return String
     * @exception DAOException
     */
    public String checkCntrNoAsgnForImage(ContainerVO containerVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "0";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", containerVO.getBkgNo());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrAsgnImgRSQL template = new BLDocumentationCMDBDAOCntrAsgnImgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }

    /**
     * CntrTpszQtyVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<CntrTpszQtyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrTpszQtyVO> searchSpclQty(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrTpszQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSpclCgoQtyRSQL template = new BLDocumentationCMDBDAOSpclCgoQtyRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrTpszQtyVO.class);
        } catch(SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * manage Container By Xter
     * 
     * @author Jun Yong Jin
     * @param List<ContainerVO> updModels
     * @exception DAOException
     */
    public void manageContainerByXterS(List<ContainerVO> updModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0){
                BLDocumentationCMDBDAOContainerByXterMSQL template = new BLDocumentationCMDBDAOContainerByXterMSQL();
                updCnt = sqlExe.executeBatch(template, updModels, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

//    /**
//     * Container Seal No. 삭제.
//     * 
//     * @param delModels
//     * @param caFlg
//     * @exception DAOException
//     */
//    public void removeCntrSealNos(List<BkgCntrSealNoVO> delModels, String caFlg) throws DAOException {
//        try {
//            SQLExecuter sqlExe = new SQLExecuter("");
//            int delCnt[] = null;
//            if(delModels.size() > 0){
//                
//                Map<String, Object> velParam = new HashMap<String, Object>();
//                velParam.put("ca_flg", caFlg);
//
//                BLDocumentationCMDBDAOCntrSealNoDSQL template = new BLDocumentationCMDBDAOCntrSealNoDSQL();
//                delCnt = sqlExe.executeBatch(template, delModels, velParam);
//                for(int i = 0; i < delCnt.length; i++){
//                    if(delCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                }
//            }
//        } catch (SQLException ex) {
//            //log.error(ex.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }catch(Exception ex){
//            //log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }


    /**
     * CmBkgInfoVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return CmBkgInfoVO
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public CmBkgInfoVO searchCmBkgInfo(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        CmBkgInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCmBkgInfoRSQL template = new BLDocumentationCMDBDAOCmBkgInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<CmBkgInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CmBkgInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new CmBkgInfoVO();
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

     /**
      * Search HTS Flag by Bkg
      * 
      * @param String bkgNo
      * @param String caFlg
      * @return String
      */
     public String searchHTSFlag(String bkgNo, String caFlg) throws DAOException {
         DBRowSet dbRowset = null;
         String rsStr = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap<String, String>();
             mapVO.put("bkg_no", bkgNo);
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
             BLDocumentationCMDBDAOCmBkgHTSFlagRSQL template = new BLDocumentationCMDBDAOCmBkgHTSFlagRSQL();
             dbRowset = sqlExe.executeQuery(template, param, velParam);
             if(dbRowset.next()){
                 rsStr = dbRowset.getString(1);
             }else{
                 rsStr = "N";
             }
         }catch(SQLException ex){
             //log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return rsStr;
     }

    /**
     * CmCntrInfoVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return List<CmCntrInfoVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<CmCntrInfoVO> searchCmCntrInfo(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<CmCntrInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCmCntrInfoRSQL template = new BLDocumentationCMDBDAOCmCntrInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CmCntrInfoVO.class);
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

     /**
      * BkgCntrMfDescVO 모델에 대한 데이타 조회.
      * 
      * @param String bkgNo
      * @param String caFlg
      * @return List<BkgCntrMfDescVO>
      * @exception DAOException
      */
     @SuppressWarnings("unchecked")
    public List<BkgCntrMfDescVO> searchCmDetailInfo(String bkgNo, String caFlg) throws DAOException {
         DBRowSet dbRowset = null;
         List<BkgCntrMfDescVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             Map<String, String> mapVO = new HashMap<String, String>();
             mapVO.put("bkg_no", bkgNo);
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
             BLDocumentationCMDBDAOCmVORSQL template = new BLDocumentationCMDBDAOCmVORSQL();
             dbRowset = sqlExe.executeQuery(template, param, velParam);

             list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrMfDescVO.class);
         }catch(SQLException ex){
             //log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return list;
     }

     /**
      * Container Manifest 생성.
      * 
      * @param BkgCntrMfDescVO vo
      * @param String caFlg
      * @exception DAOException
      * @exception Exception
      */
     public void addCm(BkgCntrMfDescVO vo, String caFlg) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         int result = 0;
         try {
             Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             BLDocumentationCMDBDAOCmVOCSQL template = new BLDocumentationCMDBDAOCmVOCSQL();
             result = sqlExe.executeUpdate(template, param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException ex) {
             //log.error(se.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }

     /**
      * Container Manifest 수정.
      * 
      * @param BkgCntrMfDescVO vo
      * @param String caFlg
      * @return int
      * @exception DAOException
      * @exception Exception
      */
     public int modifyCm(BkgCntrMfDescVO vo, String caFlg) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         int result = 0;
         try {
             Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             BLDocumentationCMDBDAOCmVOUSQL template = new BLDocumentationCMDBDAOCmVOUSQL();
             result = sqlExe.executeUpdate(template, param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException ex) {
             //log.error(se.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return result;
     }

     /**
      * Container Manifest 삭제.
      * @param BkgCntrMfDescVO vo
      * @param String caFlg
      * @return int
      * @exception DAOException
      * @exception Exception
      */
     public int removeCm(BkgCntrMfDescVO vo, String caFlg) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         int result = 0;
         try {
             Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             BLDocumentationCMDBDAOCmVODSQL template = new BLDocumentationCMDBDAOCmVODSQL();
             result = sqlExe.executeUpdate(template, param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException ex) {
             //log.error(se.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return result;
     }

     /**
      * Container Manifest 삭제.
      * @param HblDtlInfoVO vo
      * @param String caFlg
      * @return int
      * @exception DAOException
      * @exception Exception
      */
     public int removeCntrMfNo(HblDtlInfoVO vo, String caFlg) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         int result = 0;
         try {
             Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             BLDocumentationCMDBDAORemoveCntrMfNoUSQL template = new BLDocumentationCMDBDAORemoveCntrMfNoUSQL();
             result = sqlExe.executeUpdate(template, param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException ex) {
             //log.error(se.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return result;
     }

     /**
     * BkgQuantityVO 모델에 대한 데이타 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return BkgQuantityVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public BkgQuantityVO searchBkgQty(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        BkgQuantityVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOBkgQtyRSQL template = new BLDocumentationCMDBDAOBkgQtyRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<BkgQuantityVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new BkgQuantityVO();
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * BkgQtyDtlVO 모델에 대한 데이타 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgQtyDtlVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgQtyDtlVO> searchBkgQtyDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgQtyDtlVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOBkgQtyRSQL template = new BLDocumentationCMDBDAOBkgQtyRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO.class);
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * MstContainerVO 모델에 대한 데이타 조회.
     * 
     * @param String cntrNo
     * @return MstContainerVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrMstInfoVO searchMstContainer(String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        CntrMstInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMstContainerRSQL template = new BLDocumentationCMDBDAOMstContainerRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<CntrMstInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMstInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new CntrMstInfoVO();
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }


    /**
     * BKG의 ECC를 조회함
     * 
     * @param String bkgNo
     * @return String
     * @exception DAOException 
     */
    public String searchLocByBkgPor(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        String locCd = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOLocByBkgRSQL template = new BLDocumentationCMDBDAOLocByBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                locCd = dbRowset.getString(1);
            }else{
                locCd = "";
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return locCd;
    }   
    

    /**
     * Container의 직전 Movement Status를 조회함
     * 
     * @param ContainerVO containerVO
     * @return String
     * @exception DAOException 
     */
    public String searchPreMvmtSts(ContainerVO containerVO) throws DAOException {
        DBRowSet dbRowset = null;
        String mvmtSts = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", containerVO.getCntrNo());

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOPreMvmtStsRSQL template = new BLDocumentationCMDBDAOPreMvmtStsRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                mvmtSts = dbRowset.getString(1);
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mvmtSts;
    }


    /**
     * Cycle이 가장 큰 BKG의 정보를 조회함
     * 
     * @param String cntrNo
     * @return MaxCycleBkgInfoVO
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public MaxCycleBkgInfoVO searchMaxCycleBkgBySameEcc(String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        MaxCycleBkgInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL template = new BLDocumentationCMDBDAOMaxCycleBkgBySameEccRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<MaxCycleBkgInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxCycleBkgInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new MaxCycleBkgInfoVO();
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * @param String cntrNo
     * @return MaxCycleBkgInfoVO
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public MaxCycleBkgInfoVO searchMaxCycleBkgByDiffEcc(String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        MaxCycleBkgInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL template = new BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<MaxCycleBkgInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxCycleBkgInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new MaxCycleBkgInfoVO();
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * Container Manifest Number 조회.
     * 
     * @param String bkgNo
     * @param String cntrMfNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String searchCntrMfNo(String bkgNo, String cntrMfNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String hblNo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_mf_no", cntrMfNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckCntrMfNoRSQL template = new BLDocumentationCMDBDAOCheckCntrMfNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                hblNo = dbRowset.getString(1);
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return hblNo;
    }

    /**
     * Container 수정.
     * 
     * @param List<CmCntrInfoVO> updModels
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyCntrByCm(List<CmCntrInfoVO> updModels, String caFlg) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0){
                
                Map<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("ca_flg", caFlg);
                
                BLDocumentationCMDBDAOCmCntrInfoUSQL template = new BLDocumentationCMDBDAOCmCntrInfoUSQL();
                updCnt = sqlExe.executeBatch(template, updModels, velParam);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * B/L 수정.
     * 
     * @param CmBkgInfoVO vo1
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyBlByCm(CmBkgInfoVO vo1, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            String sPckQty = vo1.getBkgPckQty();
            String sPckTpCd = vo1.getBkgPckUnit();
            String sActWgt = vo1.getBkgWgtQty();
            String sMeasQty = vo1.getBkgMeasQty();
            
            if (sPckQty == null || "".equals(sPckQty.trim())) {
                sPckQty = "0";
            }
            if (sPckTpCd == null || "".equals(sPckTpCd.trim())) {
                sPckTpCd = "";
            }
            if (sActWgt == null || "".equals(sActWgt.trim())) {
            	sActWgt = "0";
            }
            if (sMeasQty == null || "".equals(sMeasQty.trim())) {
            	sMeasQty = "0";
            }
                        
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", vo1.getBkgNo());
            mapVO.put("pck_qty", sPckQty);
            mapVO.put("pck_tp_cd", sPckTpCd);
            mapVO.put("act_wgt", sActWgt);
            mapVO.put("meas_qty", sMeasQty);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOModifyBlByCmUSQL template = new BLDocumentationCMDBDAOModifyBlByCmUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

	/**
	 *  Container의 Term을 Bkg에 맞춰서 변경한다..(ESM_BKG_0079_01) -> modifyBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgContainerVO bkgContainerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void modifyCntrRDTerm(BkgContainerVO bkgContainerVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgContainerVO != null){
				Map<String, String> mapVO = bkgContainerVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyCntrRDTermUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException ex){
			//log.error(se.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * Container Seal Number 생성.
     * 
     * @param BkgCntrSealNoVO sealNoVO
     * @param String caFlg
     * @exception DAOException
     */
    public void insertCntrSealNo(BkgCntrSealNoVO sealNoVO, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = sealNoVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrSealNoCSQL template = new BLDocumentationCMDBDAOCntrSealNoCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }

    /**
     * Container Seal Number 수정.
     * 
     * @param BkgCntrSealNoVO vo
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int updateCntrSealNo(BkgCntrSealNoVO vo, String caFlg) throws DAOException {
        int updCnt = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(vo != null){
                Map<String, String> mapVO = vo.getColumnValues();
                mapVO.put("ca_flg", caFlg);
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrSealNoUSQL template = new BLDocumentationCMDBDAOCntrSealNoUSQL();
            updCnt = sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

    /**
     * Container Seal Number 삭제.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntr_seal_seq
     * @param String caFlg
     * @exception DAOException
     */
    public void removeCntrSealNo(String bkgNo, String cntrNo, String cntr_seal_seq, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_seal_seq", cntr_seal_seq);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrSealNoDSQL template = new BLDocumentationCMDBDAOCntrSealNoDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Seal Number 삭제.<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception DAOException
     */
    public void removeCmByCntr(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);   

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrMfDescDSQL template = new BLDocumentationCMDBDAOCntrMfDescDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * Container Maifest Description 바꿈.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntrNoOld
     * @param String caFlg
     * @exception DAOException
     */
    public void changeCntrMfDesc(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_no_old", cntrNoOld);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);


            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrMfDescUSQL template = new BLDocumentationCMDBDAOCntrMfDescUSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Container 생성.
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @exception DAOException
     */
    public void insertContainer(ContainerVO containerVO, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(containerVO != null){
                Map<String, String> mapVO = containerVO.getColumnValues();
                mapVO.put("ca_flg", caFlg);
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOContainerCSQL template = new BLDocumentationCMDBDAOContainerCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container 수정.
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int updateContainer(ContainerVO containerVO, String caFlg) throws DAOException {
        int updCnt = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(containerVO != null){
                Map<String, String> mapVO = containerVO.getColumnValues();
                mapVO.put("ca_flg", caFlg);

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOContainerUSQL template = new BLDocumentationCMDBDAOContainerUSQL();
            updCnt = sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

    /**
     * Container Confirm 정보수정.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param String cfmFlg
     * @return int
     * @exception DAOException
     */
    public int modifyCntrCfmFlg(BkgBlNoVO bkgBlNoVO, String cfmFlg) throws DAOException {
        int updCnt = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            mapVO.put("cfm_flg", cfmFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOContainerUSQL template = new BLDocumentationCMDBDAOContainerUSQL();
            updCnt = sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
    
    /**
     * Container 삭제.<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @return Map<String,Object>
     * @exception DAOException
     */
    public Map<String,Object> removeContainer(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        Map<String,Object> retMap = null;
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);  


            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOContainerDSQL template = new BLDocumentationCMDBDAOContainerDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
            if (0<updCnt) {
                retMap = new HashMap<String,Object>();
	            retMap.put("bkgNo",bkgNo);
	            retMap.put("cntrNo",cntrNo);
	            retMap.put("caFlg",caFlg);
            }
        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return retMap;
    }


	/**
	 *  act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String actWgt
	 * @param 		String wgtUtCd 
	 * @param 		SignOnUserAccount account 
	 * @exception 	DAOException
	 */
	public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("act_wgt", actWgt);
			param.put("wgt_ut_cd", wgtUtCd);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("vsl_update", "Y"); 
			velParam.put("vsl_update", "Y");
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyBlActWgtUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException ex){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String actWgt
	 * @param 		String wgtUtCd 
	 * @param 		SignOnUserAccount account 
	 * @param 		String vslUpdate 
	 * @exception 	DAOException
	 */
	public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, SignOnUserAccount account, String vslUpdate) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("act_wgt", actWgt);
			param.put("wgt_ut_cd", wgtUtCd);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("vsl_update", vslUpdate);
			velParam.put("vsl_update", vslUpdate);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyBlActWgtUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException ex){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 *  Container를 Cancel한다.(ESM_BKG_0079_01) -> modifyBooking<br>
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void cancelBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BLDocumentationCMDBDAOCancelBkgCntrUSQL template = new BLDocumentationCMDBDAOCancelBkgCntrUSQL();
			int updCnt = sqlExe.executeUpdate(template, param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException ex){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * sourceBkg의 bkg_container를 targetBkg으로 복사한다.<br>
	 * cntr_cfm_flg는 복사하지 않는다.<br>
	 * 
	 * @param BkgBlNoVO toBkg
	 * @param BkgBlNoVO fromBkg
	 * @param SelectCntrVO selectCntrVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgCntrByBkg(BkgBlNoVO toBkg,BkgBlNoVO fromBkg, SelectCntrVO selectCntrVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("from_bkg",fromBkg.getBkgNo());
            mapVO.put("advShtgCd",selectCntrVO.getAdv_shtg_cd());
            mapVO.put("cntr_no",selectCntrVO.getCntr_no());
            mapVO.put("usr_id",account.getUsr_id());
            mapVO.put("to_bkg",toBkg.getBkgNo());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);


			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOcopyBkgCntrByBkgCSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
     * sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다.<br>
     * cntr_mf_no는 복사하지 않는다.<br>
	 * 
	 * @param BkgBlNoVO toBkg
	 * @param BkgBlNoVO fromBkg
	 * @param String copyModeCd
	 * @param SelectCntrVO selectCntrVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyCmByBkg(BkgBlNoVO toBkg,BkgBlNoVO fromBkg, String copyModeCd, SelectCntrVO selectCntrVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("from_bkg",fromBkg.getBkgNo());
            mapVO.put("cntr_no",selectCntrVO.getCntr_no());
            mapVO.put("usr_id",account.getUsr_id());
            mapVO.put("to_bkg",toBkg.getBkgNo());
            
            param.putAll(mapVO);
            velParam.put("copy_mode_cd", copyModeCd);
            velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOcopyCmByBkgCSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
    /**
     * Contailer Volumn 수정.
     * 
     * @param CntrCopyVO vo
     * @exception DAOException
     */
    public void modifyCntrVolByCntr(CntrCopyVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrVolByCntrUSQL template = new BLDocumentationCMDBDAOCntrVolByCntrUSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container 생성.
     * 
     * @param CntrCopyVO vo
     * @param String caFlg
     * @exception DAOException
     */
    public void copyBkgCntrByCntr(CntrCopyVO vo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCopyCntrByCntrCSQL template = new BLDocumentationCMDBDAOCopyCntrByCntrCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Seal No. 복사.
     * 
     * @param CntrCopyVO vo
     * @param String caFlg
     * @exception DAOException
     */
    public void copyBkgCntrSealByCntr(CntrCopyVO vo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCopySealNoByCntrCSQL template = new BLDocumentationCMDBDAOCopySealNoByCntrCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Manifest 복사.
     * 
     * @param CntrCopyVO vo
     * @param String caFlg
     * @exception DAOException
     */
    public void copyCmByCntr(CntrCopyVO vo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCopyCmByCntrCSQL template = new BLDocumentationCMDBDAOCopyCmByCntrCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	/**
	 * sourceBkg의 bkg_cntr_seal_no를 targetBkg으로 복사한다.<br>
	 * 
	 * @param BkgBlNoVO toBkg
	 * @param BkgBlNoVO fromBkg
	 * @param SelectCntrVO selectCntrVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgCntrSealByBKG(BkgBlNoVO toBkg,BkgBlNoVO fromBkg, SelectCntrVO selectCntrVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("from_bkg",fromBkg.getBkgNo());
            mapVO.put("cntr_no",selectCntrVO.getCntr_no());
            mapVO.put("usr_id",account.getUsr_id());
            mapVO.put("to_bkg",toBkg.getBkgNo());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOcopyBkgCntrSealByBKGCSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 전달받은 cntr No로 bkg_cntr_seal_no 에서 삭제한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SelectCntrVO selectCntrVO
	 * @exception DAOException
	 */
	public void removeCntrSealNoAfterSplit(BkgBlNoVO bkgBlNoVO,SelectCntrVO selectCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no",selectCntrVO.getCntr_no());
            mapVO.put("bkg_no",bkgBlNoVO.getBkgNo());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);  

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOremoveCntrSealNoAfterSplitDSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
     * Contailer Flag 수정.
     * 
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String cntrNo
     * @param String caFlg
     * @return	int
	 * @exception DAOException
	 */
    public int modifyCntrFlgBySpcl(String bkgNo, String spclTp, String cntrNo, String caFlg) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("spcl_tp", spclTp);
            mapVO.put("cntr_no", cntrNo);
            velParam.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyCntrFlgBySpclUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
    
    /**
     * Contailer Flag 수정.
     * 
     * @param String bkgNo
     * @param String spclTp
     * @param String cntrNo
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyCntrFlgBySpcl2(String bkgNo, String spclTp, String cntrNo, String caFlg) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("spcl_tp", spclTp);
            mapVO.put("cntr_no", cntrNo);
            velParam.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyCntrFlgBySpcl2USQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
    }
    
    /**
     * Contailer Flag 수정.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyCntrFlgBySpcl3(String bkgNo, String caFlg) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo); 
            velParam.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyCntrFlgBySpcl3USQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
    }

    /**
     * CntrCmEtcInfoVO 모델에 대한 데이타 조회.
     * 
     * @param String cntrNo
     * @param String vvd
     * @return CntrCmEtcInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrCmEtcInfoVO searchCmEtcInfoByCntr(String cntrNo, String vvd) throws DAOException {
        DBRowSet dbRowset = null;
        CntrCmEtcInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("vvd", vvd);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);


            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrCmEtcInfoRSQL template = new BLDocumentationCMDBDAOCntrCmEtcInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<CntrCmEtcInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrCmEtcInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new CntrCmEtcInfoVO();
            }
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * CntrCmBkgInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param String cntrNo
     * @param String vvd
     * @return List<CntrCmBkgInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrCmBkgInfoVO> searchCmBkgInfoByCntr(String cntrNo, String vvd) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrCmBkgInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("vvd", vvd);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrCmBkgInfoRSQL template = new BLDocumentationCMDBDAOCntrCmBkgInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrCmBkgInfoVO.class);

        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * CntrCmDescInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param String cntrNo
     * @param String vvd
     * @return List<CntrCmDescInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrCmDescInfoVO> searchCmDescInfoByCntr(String cntrNo, String vvd) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrCmDescInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("vvd", vvd);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrCmDescInfoRSQL template = new BLDocumentationCMDBDAOCntrCmDescInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrCmDescInfoVO.class);

        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * targetBkg의 BKG_CONTAINER POR, POL정보를 sourceBkg의 값으로 변경한다.(ESM_BKG_0076)<br>
     * 
     * @author Jun Yong Jin
     * @param BkgBlNoVO mstBkg
     * @param BkgBlNoVO combineBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyCntrPorPol(BkgBlNoVO mstBkg, BkgBlNoVO combineBkg, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	Map<String, String> mapVO = mstBkg.getColumnValues();

        	param.putAll(mapVO);
        	velParam.putAll(mapVO);
        	param.put("mst_bkg", mstBkg.getBkgNo());
    		param.put("combine_bkg", combineBkg.getBkgNo());
    		param.put("usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOmodifyCntrPorPolUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
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
     * targetBkg와 sourceBkg의 Container가 동일할 때(Dup인 경우)(ESM_BKG_0076)<br>
     * targetBkg의 BKG_CONTAINER PCK_QTY, MEAS_QTY, CNTR_WGT정보를 sourceBkg의 값으로 변경한다.<br>
     * 
     * @author Jun Yong Jin
     * @param String cntrNo
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyBkgCntrPkcMeasWgt(String cntrNo, BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        String mstBkgNo = "";
        try {
        	if ( sourceBkg != null ) {
        		Map<String, String> mapVO = targetBkg.getColumnValues();

        		param.putAll(mapVO);
        		velParam.putAll(mapVO);
        		
        		mstBkgNo = sourceBkg.getBkgNo();
        	}
    		param.put("mst_bkg_no", mstBkgNo);
    		param.put("cntr_no", cntrNo);
    		param.put("usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOmodifyBkgCntrPkcMeasWgtUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }

    /**
     * Container 중복사용 검사.
     * 
     * @param CntrCopyVO vo
     * @return String
     * @exception DAOException
     */
    public String searchCntrDupByCntr(CntrCopyVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String result_val = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrDupByCntrRSQL template = new BLDocumentationCMDBDAOCntrDupByCntrRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result_val = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result_val;
    }

    /**
     * Container Copy 시 Volumn 수정<br>
     * Copy는 CA 상태에서는 불가능 하므로.. CA Flag는 고려하지 않는다.
     * 
     * @param String bkgNo
     * @param String cngrNo
     * @param String cntrVol
     * @exception DAOException
     */
    public void modifyCntrVolByCopy(String bkgNo, String cngrNo, String cntrVol) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cngrNo);
            mapVO.put("cntr_vol", cntrVol);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrVolByCntrUSQL template = new BLDocumentationCMDBDAOCntrVolByCntrUSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Confirm Flag 수정.
     * 
     * @param String bkgNo
     * @param String cfmFlg
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyCntrCfmFlgByBkg(String bkgNo, String cfmFlg, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_cfm_flg", cfmFlg);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrCfmFlgByBkgUSQL template = new BLDocumentationCMDBDAOCntrCfmFlgByBkgUSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }

    /**
     * Doc. Process 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String searchDocProcessByCntr(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String result_val = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAODocProcTpByBkgRSQL template = new BLDocumentationCMDBDAODocProcTpByBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result_val = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result_val;
    }

    /**
     * BL Issue Flag 조회
     *
     * @author KimYoungchul
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String searchBlIssFlg(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String blIssFlg = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOBlIssFlgRSQL template = new BLDocumentationCMDBDAOBlIssFlgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                blIssFlg = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return blIssFlg;
    }   
    
    /**
     * B/L 수정.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyBlByFinalCfm(String bkgNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOBlByFnlCfmUSQL template = new BLDocumentationCMDBDAOBlByFnlCfmUSQL();
            // update 후 갱신여부는 중요치 않음.
            sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }

    /**
     * CntrAdjVolVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return List<CntrAdjVolVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<CntrAdjVolVO> searchCntrAdjVol(String bkgNo, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrAdjVolVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrAdjVolVORSQL template = new BLDocumentationCMDBDAOCntrAdjVolVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrAdjVolVO.class);

        }catch(SQLException ex){
            //log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

     /**
      * Search Container Count.
      *
      * @author KimYoungchul
      * @param String bkgNo
      * @param String caFlg
      * @return String
      * @exception DAOException
      */
     public String searchCntrKnt(String bkgNo, String caFlg) throws DAOException {
         DBRowSet dbRowset = null;
         String result = null;
         // query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         // velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try {
             // set parameters
             Map<String, String> mapVO = new HashMap<String, String>();
             mapVO.put("bkg_no", bkgNo);
             mapVO.put("ca_flg", caFlg);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
             BLDocumentationCMDBDAOCntrKntRSQL template = new BLDocumentationCMDBDAOCntrKntRSQL();
             dbRowset = sqlExe.executeQuery(template, param, velParam);
             if(dbRowset.next()){
                 result = dbRowset.getString(1);
             }
         } catch(SQLException ex) {
             throw new DAOException(ex.getMessage(), ex);
         } catch(Exception ex) {
             throw new DAOException(ex.getMessage(), ex);
         }
         return result;
     }
     
     /**
      * RataBkgQtyVO 모델에 해당하는 데이타 조회.
      * 
      * @param String bkgNo
      * @param String caFlg
      * @return List<RataBkgQtyVO>
      * @exception DAOException
      */
    @SuppressWarnings("unchecked")
    public List<RataBkgQtyVO> searchBkgCntrVol(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<RataBkgQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAORataBkgQtyRSQL template = new BLDocumentationCMDBDAORataBkgQtyRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RataBkgQtyVO.class);

        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Container Volumn 수정.
     * 
     * @param CntrAdjVolVO cntrAdjVolVO
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyCntrVol(CntrAdjVolVO cntrAdjVolVO, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = cntrAdjVolVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            BLDocumentationCMDBDAOCntrVolUSQL template = new BLDocumentationCMDBDAOCntrVolUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
     * sourceBkg의 bkg_bl_doc을 targetBkg로 복사한다.
     * 
     * @author      KimByungKyu
	 * @param String trnkVslCd
	 * @param String preVslCd
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgBlDoc( String trnkVslCd , String preVslCd , BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			param.put   ("pre_vsl_cd", preVslCd);
			param.put   ("trunk_vsl_cd", trnkVslCd);
			param.put   ("target_bkg_no", targetBkg.getBkgNo());
			param.put   ("source_bkg_no", sourceBkg.getBkgNo());
			param.put   ("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOCopyBkgBlDocCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

    /**
     * BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
     * 
     * @author 		KimByungKyu
     * @param 		String bkgNo
     * @param 		String blMvTpNm
     * @param	    String fnlDestNm
     * @param 		String actWgt
     * @param 		String wgtUtCd
     * @param 		String userId
     * @exception DAOException
     */
    public void addBkgBlDoc(String bkgNo, String blMvTpNm, String fnlDestNm, String actWgt, String wgtUtCd, String userId) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgNo);
            param.put("bl_mv_tp_nm", blMvTpNm);
            param.put("fnl_dest_nm", fnlDestNm);
            param.put("act_wgt", actWgt);
            param.put("wgt_ut_cd", wgtUtCd);            
            param.put("cre_usr_id", userId);
            param.put("upd_usr_id", userId);
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOAddBkgBlDocCSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * bkg에 assign되있으면 partial로 판단하고 partial flag를 update한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String cntrNo
     * @param int partialCount
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyBkgCntrPartialFlg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String cntrNo, int partialCount, SignOnUserAccount account) throws DAOException{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	String srcBkg = "";
			if(sourceBkg != null){
				Map<String, String> mapVO = sourceBkg .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				srcBkg = sourceBkg.getBkgNo();
			}
            param.put("source_bkg", srcBkg);
            param.put("target_bkg", targetBkg.getBkgNo());
            param.put("cntr_no", cntrNo);
            param.put("partial_count", partialCount);
			param.put("usr_id", account.getUsr_id());
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOmodifyBkgCntrPartialFlgUSQL(), param,
                    velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

    /**
     * Movement에서 MT Repo. Booking의 경우 VL 상태일 때 Contanier를 삭제하면 Movement Cycle을 9999로 업데이트 한다..
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String cnmvCycNo
     * @param String cnmvDtTm
     * @exception DAOException 
     */
    public void modifyCycleByCtm(String bkgNo, String cntrNo, String cnmvCycNo, String cnmvDtTm) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cnmv_cyc_no", cnmvCycNo);
            mapVO.put("cnmv_evnt_dt", cnmvDtTm);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCycleByCtmUSQL template = new BLDocumentationCMDBDAOCycleByCtmUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED) 
                throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }    
    }

    /**
     * CTM_MVMT_IRR 에 데이타 입력.<br>
     * 
     * @param CusCtmMovementVO ctmVO
     * @param boolean findBkgCntr
     * @throws DAOException
     */
    public void modifyCntrOp(CusCtmMovementVO ctmVO, boolean findBkgCntr) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO =  ctmVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            if (findBkgCntr)
                velParam.put("fnd_bkg", "1");
            else 
                velParam.put("fnd_bkg", "0");
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMstBkgCntrOcUSQL template = new BLDocumentationCMDBDAOMstBkgCntrOcUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Cargo Receive Date Update<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @throws DAOException
     */
    public void modifyCrd(String bkgNo, String cntrNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {            
        	param.put("bkg_no", bkgNo);
        	param.put("cntr_no", cntrNo);
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOModifyCrdUSQL template = new BLDocumentationCMDBDAOModifyCrdUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modify SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
	/**
     * History Update의 BKG Update. 부킹에 넘겨주기 위한 테스트 용.<br> 
	 * 
	 * @param CusCtmMovementVO vo
     * @param String delFlg 
	 * @exception DAOException
	 */
   @SuppressWarnings("unchecked")
   public void modifyCntrHistoryUpdate(CusCtmMovementVO vo, String delFlg) throws DAOException {
       Map param = new HashMap();
       try {
           Map<String, String> mapVO = vo.getColumnValues();
           mapVO.put("del_flg", delFlg);
           
           param.putAll(mapVO);
           
           SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
           BLDocumentationCMDBDAOCntrHistoryUpdateUSQL template = new BLDocumentationCMDBDAOCntrHistoryUpdateUSQL();
           sqlExe.executeUpdate(template, param, param);
       } catch(SQLException ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch(Exception ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
   }
  
	/**
	 * bkg에 assign되있으면 partial로 판단하고 partial flag를 update한다.<br>
	 * 
	 * @param String sourceBkgNo
	 * @param String targetBkgNo
	 * @param String cntrNo
	 * @param int partialCount
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgCntrPartialFlg(String sourceBkgNo, String targetBkgNo, String cntrNo, int partialCount, SignOnUserAccount account) throws DAOException{
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
	    	param.put("source_bkg", sourceBkgNo);
	    	param.put("target_bkg", targetBkgNo);
	        param.put("cntr_no", cntrNo);
	        param.put("partial_count", partialCount);
			param.put("usr_id", account.getUsr_id());
	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	        int result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOmodifyBkgCntrPartialFlgUSQL(), param,
	                velParam);
	        if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	
	    }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * bkg_container 테이블에 한국 WHF CNTR별 Exception 정보를  update한다.<br>
	 * 
	 * @param List<CntrKrWhfExptVO> cntrKrWhfExptVOs
	 * @exception DAOException
	 */
	public void modifyCntrKrWhfExpt(List<CntrKrWhfExptVO> cntrKrWhfExptVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(cntrKrWhfExptVOs.size() > 0){

                updCnt = sqlExe.executeBatch(new BLDocumentationCMDBDAOModifyCntrKrWhfExptUSQL(), cntrKrWhfExptVOs, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

    /**
     * MstContainer정보 조회
     * 
     * @author KimByungKyu
     * @param String cntrNo
     * @return MstContainerVO
     * @exception DAOException
     */
   @SuppressWarnings("unchecked")
   public MstContainerVO searchMstCntrForMst(String cntrNo) throws DAOException {
       DBRowSet dbRowset = null;
       List<MstContainerVO> list = null;
       MstContainerVO mstContainerVO = null;
       // query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try {
       	param.put("cntr_no", cntrNo);
       	dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchMstCntrForMstRSQL(), param, velParam);
       	
           list = (List) RowSetUtil.rowSetToVOs(dbRowset, MstContainerVO.class);
           if(list != null && list.size() > 0){
        	   mstContainerVO = list.get(0);
           }
       } catch(SQLException ex) {
           // log.error(se.getMessage(), ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch(Exception ex) {
           // log.error(ex.getMessage(), ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return mstContainerVO;
   }

    /**
     * Update C/M by container wgt./meas. unit
     * 
     * @author KimYoungchul
     * @param String bkgNo
     * @param String bkgWgtUtCd
     * @param String bkgMeasUtCd
     * @param String usrId
     * @param String caFlg
     * @exception DAOException
     */
    public void modiftyCmUnitByCntr(String bkgNo, String bkgWgtUtCd, String bkgMeasUtCd, String usrId, String caFlg) throws DAOException{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("wgt_ut_cd", bkgWgtUtCd);
            mapVO.put("meas_ut_cd", bkgMeasUtCd);
            mapVO.put("usr_id", usrId);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCntrCmUtCdUSQL template = new BLDocumentationCMDBDAOCntrCmUtCdUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED) 
                throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }

    /**
     * Partial BKG 조회
     *
     * @author KimYoungchul
     * @param ContainerVO containerVO
     * @return String
     * @exception DAOException
     */
    public String searchPartialBkg(ContainerVO containerVO) throws DAOException {
        DBRowSet dbRowset = null;
        StringBuffer sbuf = new StringBuffer();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = containerVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOPartialBkgRSQL template = new BLDocumentationCMDBDAOPartialBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            int delimIdx = 0;
            float ttlVol = 0F;
            while(dbRowset.next()){
                if(delimIdx > 0){                    
                    if(delimIdx%2 == 0){
                        sbuf.append("\n     ");
                    } else {
                    	sbuf.append(" / ");
                    }
                }
                sbuf.append(dbRowset.getString("RSTR"));
                ttlVol += dbRowset.getFloat("CNTR_VOL_QTY");
                delimIdx++;
            }
            
            if(sbuf.toString().length()>0) {
            	sbuf.append("\n     TOTAL : " + ttlVol);
            }
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        //return (sbuf.length() > 1) ? sbuf.substring(1) : null;
        return sbuf.toString();
    }

     /**
      * Container Manifest 수정.
      * 
      * @param BkgCntrMfDescVO vo
      * @param String caFlg
      * @return int
      * @exception DAOException
      * @exception Exception
      */
     public int modifyCmByXter(BkgCntrMfDescVO vo, String caFlg) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         int result = 0;
         try {
             Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             BLDocumentationCMDBDAOCmVOUSQL template = new BLDocumentationCMDBDAOCmVOUSQL();
             result = sqlExe.executeUpdate(template, param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException ex) {
             //log.error(se.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }catch(Exception ex){
             //log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
         return result;
     }
     
 	/**
      * bkg의 route name을 update한다.
      * 
      * @param BkgBlNoVO bkgBlNoVO
      * @param BkgBookingInfoVO bkgBookingInfoVO 
      * @param SignOnUserAccount account
      * @exception EventException
      */
	public void modifyBkgRouteNm(BkgBlNoVO bkgBlNoVO, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try {
            Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("ca_flg", bkgBlNoVO.getCaFlg());
            param.put("usr_id", account.getUsr_id());
            velParam.put("ca_flg", bkgBlNoVO.getCaFlg());

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(new BLDocumentationCMDBDAOModifyBkgRouteNmUSQL(), param, velParam);            
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");            
        } catch (SQLException ex) {
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }		
	}
	
	/**
     * split 후 cntr별 special cargo flag를 재 계산한다.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCntrSpclFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(new BLDocumentationCMDBDAOmodifyCntrSpclFlagUSQL(), param, velParam);            
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");            
        } catch (SQLException ex) {
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }				
	}
	

    /**
     * 이전 cycle의 Container 상태를 조회하여 confirm 여부 결정
     *
     * @author Jeon Sung Jin
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @return PreConfirmBkgVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public PreConfirmBkgVO searchConfirmOthBkg(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
//        String preCycleConfirmFlg = "";
        PreConfirmBkgVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL template = new BLDocumentationCMDBDAOSearchConfirmOthBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<PreConfirmBkgVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, PreConfirmBkgVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }
    
    /**
     * Movement 에서 EDI 로 전송 되는 CNTR 중 OP Status 조회
     *
     * @author kim tae kyoung
     * @param CusCtmMovementVO vo
     * @return List<CntrMoveOpInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrMoveOpInfoVO> searchPreCycleCntrInfo(CusCtmMovementVO vo) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<CntrMoveOpInfoVO> list = null;
    	 // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
        	 Map<String, String> mapVO = vo.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO);
             SQLExecuter exec = new SQLExecuter("DEFAULT");
             BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL template = new BLDocumentationCMDBDAOSearchPreCycleCntrInfoRSQL();
             dbRowset = exec.executeQuery(template, param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrMoveOpInfoVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * Container CRD DT 수정.
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyCrdDt(ContainerVO containerVO, String caFlg, SignOnUserAccount account) throws DAOException {
        int updCnt = 0;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(containerVO != null){
                Map<String, String> mapVO = containerVO.getColumnValues();
                mapVO.put("ca_flg", caFlg);
                mapVO.put("upd_usr_id", account.getUsr_id());

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOModifyCrdDtUSQL template = new BLDocumentationCMDBDAOModifyCrdDtUSQL();
            updCnt = sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

    /**
     * Container 존재여부 조회.<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @return boolean
     * @exception DAOException
     */
    public boolean searchExistContainer(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        boolean flag = false;
    	DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);  

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchExistContainerRSQL template = new BLDocumentationCMDBDAOSearchExistContainerRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if (dbRowset.next()) {
                flag = true;
            }
        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flag;
    }
    
    
    /**
     * BkgDgCgoVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<BkgDgCgoVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<BkgDgCgoVO> searchBkgDgCgo( String bkgNo ) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgDgCgoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchBkgDgCgoRSQL template = new BLDocumentationCMDBDAOSearchBkgDgCgoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDgCgoVO.class);
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
     /**
      * 컨테이너 무브먼트 히스토리 저장
      * 
      * @param CusCtmMovementVO ctmVO
      * @param String findBkgCntr
      * @exception DAOException
      */
     public void addCntrMvmtHis(CusCtmMovementVO ctmVO, String findBkgCntr) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         Map<String, Object> velParam = new HashMap<String, Object>();
         Map<String, String> mapVO = null;
         try {
             mapVO = new HashMap<String, String>();
             mapVO = ctmVO.getColumnValues();
             mapVO.put("fnd_bkg", findBkgCntr);
             param.putAll(mapVO);
             velParam.putAll(mapVO);
             int insCnt = (new SQLExecuter("DEFAULT")).executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOAddCntrMvmtHisCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
         } catch(SQLException ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }
  	/**
  	 * modifyCntrFlgByRfCgo<br>
  	 *  
  	 * @param RfCgoApplVO rfCgoApplVO
  	 * @param String caFlg
  	 * @exception EventException
  	 */
  	public void modifyCntrFlgByRfCgo(RfCgoApplVO rfCgoApplVO, String caFlg) throws DAOException{
  		Map<String, Object> param = null;
  		Map<String, Object> velParam = null;
  		int result = 0;
  	    try {
  			param = new HashMap<String, Object>();
  			velParam = new HashMap<String, Object>();
  			param.put("bkg_no", rfCgoApplVO.getBkgNo());
  			param.put("ca_flg", caFlg);
  			velParam.put("bkg_no", rfCgoApplVO.getBkgNo());
  			velParam.put("ca_flg", caFlg);
  			SQLExecuter sqlExe = new SQLExecuter("");
  			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL(), param, velParam);
  			if (result == Statement.EXECUTE_FAILED)
  				throw new DAOException("Fail to update SQL");
  	    } catch (SQLException se) {
  	        log.error(se.getMessage(),se);
  	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
  	    } catch(Exception ex) {
  	        log.error(ex.getMessage(),ex);
  	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
  	    }		
  	}
  	
  	/**
     * Searching Restuffing Container .
     * 
     * @param String cntrNo
     * @param String oldCntrNo
     * @param String BkgNo
     * @return CntrMstInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrMstInfoVO searchRstfCntr(String cntrNo, String oldCntrNo, String BkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        CntrMstInfoVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("old_cntR_no", oldCntrNo);
            mapVO.put("bkg_no", BkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchRstfCntrRSQL template = new BLDocumentationCMDBDAOSearchRstfCntrRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<CntrMstInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMstInfoVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }
    

 	/**
 	 * cntrNo를 기준으로 Partial bkg들을 조회한다 
 	 * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param String cntrNo
     * @return List<BkgBlNoVO>
     * @exception DAOException
     */
	public List<BkgBlNoVO> searchPartialBkgByCntr(BkgBlNoVO bkgBlNoVO,
			String cntrNo) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<BkgBlNoVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 				
 			Map<String, String> mapVO = bkgBlNoVO.getColumnValues(); 			
 			param.putAll(mapVO);
 			param.put("cntr_no", cntrNo);
 			velParam.putAll(mapVO);
 			velParam.put("cntr_no", cntrNo);
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchPartialBkgByCntrRSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO .class);
 		} catch(SQLException se) {
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
 		} catch(Exception ex) {
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
 		}
 		return list;
	}    
	
 	/**
 	 * split시 나눠지는 volume과 weight를 조회한다 
 	 * 
     * @param BkgBlNoVO sourceBkg
     * @param String cntrNo
     * @return BkgContainerVO
     * @exception DAOException
     */
	public BkgContainerVO searchPartialVol(BkgBlNoVO sourceBkg, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgContainerVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("source_bkg", sourceBkg.getBkgNo());
            mapVO.put("cntr_no", cntrNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchPartialVolRSQL template = new BLDocumentationCMDBDAOSearchPartialVolRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<BkgContainerVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);
            if(list != null && list.size() > 0){
                rsVO = list.get(0);
            }
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
	}	
	
	/**
     * bkg에 assign되있으면 partial로 판단하고 partial flag를 update한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO bkgBlNoVO
     * @param BkgContainerVO bkgContainerVO
     * @param int partialCount
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyBkgCntrPartialFlgMulti(BkgBlNoVO sourceBkg, BkgBlNoVO bkgBlNoVO, 
			BkgContainerVO bkgContainerVO, int partialCount, SignOnUserAccount account) throws DAOException{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            param.put("source_bkg", sourceBkg.getBkgNo());
            param.put("cntr_no", bkgContainerVO.getCntrNo());
            param.put("cntr_vol_qty", bkgContainerVO.getCntrVolQty());
            param.put("cntr_wgt", bkgContainerVO.getCntrWgt());
            param.put("partial_count", partialCount);
			param.put("usr_id", account.getUsr_id());
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOmodifyBkgCntrPartialFlgMulTiUSQL(), param,
                    velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
     * source bkg의 volume, weight를 update한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgContainerVO bkgContainerVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyBkgCntrPartialMstVol(BkgBlNoVO sourceBkg, BkgContainerVO bkgContainerVO, 
			SignOnUserAccount account) throws DAOException{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	String srcBkg = "";
			if(sourceBkg != null){
				Map<String, String> mapVO = sourceBkg.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				srcBkg = sourceBkg.getBkgNo();
			}
            param.put("source_bkg", srcBkg);
            param.put("cntr_no", bkgContainerVO.getCntrNo());
            param.put("cntr_vol_qty", bkgContainerVO.getCntrVolQty());
            param.put("cntr_wgt", bkgContainerVO.getCntrWgt());
			param.put("usr_id", account.getUsr_id());
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOmodifyBkgCntrPartialMstVolUSQL(), param,
                    velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

      
	/**
     * 중복된 Container 조회.
     * 
     * @param CusCtmMovementVO ctmVO
     * @param boolean findBkgCntr
     * @return CntrMvmtRtnVO
     * @exception DAOException
     */
    public CntrMvmtRtnVO searchBkgCntrMvmtRtn(CusCtmMovementVO ctmVO, boolean findBkgCntr) throws DAOException {
        DBRowSet dbRowset = null;
        CntrMvmtRtnVO cntrMvmtRtnVO = null;
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();
      try {
          Map<String, String> mapVO =  ctmVO.getColumnValues();

          param.putAll(mapVO);
          velParam.putAll(mapVO);
          if (findBkgCntr)
              velParam.put("fnd_bkg", "1");
          else 
              velParam.put("fnd_bkg", "0");
          
        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        BLDocumentationCMDBDAOSearchBkgCtrMvmtRtnRSQL template = new BLDocumentationCMDBDAOSearchBkgCtrMvmtRtnRSQL();
        dbRowset = sqlExe.executeQuery(template, param, velParam);
        
          List<CntrMvmtRtnVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvmtRtnVO.class);
          if(list != null && list.size() > 0){
              cntrMvmtRtnVO = list.get(0);
          }
 			
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return cntrMvmtRtnVO;
    }
    
	/**
	 * Reactivate Container(ESM_BKG_0000_1) -> reactivateBooking
	 * @author 		KYOUNGIL MOON
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void activateBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BLDocumentationCMDBDAOActivateBkgCntrUSQL template = new BLDocumentationCMDBDAOActivateBkgCntrUSQL();
			int updCnt = sqlExe.executeUpdate(template, param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException ex){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     * modify booking shipment detail update
     * 
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyShpFlg(String bkgNo, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	param.put("bkg_no", bkgNo);
        	param.put("usr_id", account.getUsr_id());
        	velParam.put("bkg_no", bkgNo);
        	velParam.put("usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOModifyBookingContainerShipmentUSQL template = new BLDocumentationCMDBDAOModifyBookingContainerShipmentUSQL();
            sqlExe.executeUpdate(template, param,velParam);
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
  /**
   * 
   * @param account
   * @param bkgNo
   * @param bkgCntrShpVO
   * @throws DAOException
   */
    public void manageCmBkgCntrShp(SignOnUserAccount account, String bkgNo, BkgCntrShpVO bkgCntrShpVO) throws DAOException{
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if(bkgCntrShpVO != null){
				Map<String, String> mapVO = bkgCntrShpVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("usr_id", account.getUsr_id());
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
        	
        	int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new BLDocumentationCMDBDAOBookingContainerShipmentCSQL(), param, velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
  /**
   * 
   * @param bkgNo
   * @throws DAOException
   */
    public void deleteCmBkgCntrShp(String bkgNo) throws DAOException{
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try{
        	param.put("bkg_no", bkgNo);
        	int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new BLDocumentationCMDBDAOBookingContainerShipmentDSQL(), param, null);
            if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ContainerVO 모델에 해당하는 데이타 조회.
     *  
     * @param String bkgNo 
     * @param int cnt 
     * @return List<ContainerVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ContainerVO> searchBbContainer(String bkgNo, int cnt) throws DAOException {
        DBRowSet dbRowset = null;
        List<ContainerVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            param.put("bkg_no", bkgNo);
            param.put("cnt", cnt);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOsearchBbContainerRSQL template = new BLDocumentationCMDBDAOsearchBbContainerRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerVO.class);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
    }
    
    /**
     * bkg��vgm ��update�쒕떎.
     * 
     * @param BkgVgmWgtVO bkgVgmWgtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyBkgCntrVgmWgt(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws DAOException,Exception {
       Map<String, Object> param = new HashMap<String, Object>();
       Map<String, Object> velParam = new HashMap<String, Object>();
       int result = 0;
       try {
           Map<String, String> mapVO = bkgVgmWgtVO.getColumnValues();
           
           param.putAll(mapVO);
//           param.put("ca_flg", bkgBlNoVO.getCaFlg());
//           param.put("usr_id", account.getUsr_id());
//           velParam.put("ca_flg", bkgBlNoVO.getCaFlg());

           SQLExecuter sqlExe = new SQLExecuter("");
           result = sqlExe.executeUpdate(new BLDocumentationCMDBDAOModifyBkgVgmWgtUSQL(), param, velParam);            
           if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");            
       } catch (SQLException ex) {
           //log.error(se.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }catch(Exception ex){
           //log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }		
	}
	
    /**
     * BkgCntrSealNoVO 모델에 해당하는 데이타 조회.
     * 
     * @param CusCtmMovementVO vo
     * @return String
     * @exception DAOException
     */
    public String searchLastSealNo(CusCtmMovementVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
       	 Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchLastCntrSealNoRSQL template = new BLDocumentationCMDBDAOSearchLastCntrSealNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
          dbRowset = sqlExe.executeQuery(template, param, velParam);
          if(dbRowset.next()){
              result = dbRowset.getString(1);
          }
      } catch(SQLException ex) {
          // log.error(ex.getMessage(),ex);
          throw new DAOException(ex.getMessage(), ex);
      } catch(Exception ex) {
          // log.error(ex.getMessage(),ex);
          throw new DAOException(ex.getMessage(), ex);
      }
      return result;
    }
    
    /**
     * BkgCntrSealNoVO 모델에 해당하는 데이타 조회.
     * 
     * @param CusCtmMovementVO vo
     * @return String
     * @exception DAOException
     */
    public String searchDupSealNo(CusCtmMovementVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "N";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
       	 Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchDupCntrSealNoRSQL template = new BLDocumentationCMDBDAOSearchDupCntrSealNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
          dbRowset = sqlExe.executeQuery(template, param, velParam);
          if(dbRowset.next()){
              result = dbRowset.getString(1);
          }
      } catch(SQLException ex) {
          // log.error(ex.getMessage(),ex);
          throw new DAOException(ex.getMessage(), ex);
      } catch(Exception ex) {
          // log.error(ex.getMessage(),ex);
          throw new DAOException(ex.getMessage(), ex);
      }
      return result;
    }
    
    
    /**
     * Container Seal Number 삭제.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception DAOException
     */
    public void removeMvmtCntrSealNo(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMvmtCntrSealNoDSQL template = new BLDocumentationCMDBDAOMvmtCntrSealNoDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");
        }catch(SQLException ex){
            //log.error(se.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Contailer Manifest Flag 수정.
     * 
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String cntrNo
     * @param String caFlg
     * @return	int
	 * @exception DAOException
	 */
    public int modifyCmFlgBySpcl(String bkgNo, String spclTp, String cntrNo, String caFlg) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("spcl_tp", spclTp);
            mapVO.put("cntr_no", cntrNo);
            velParam.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOmodifyCmFlgBySpclUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
	/**
     * Contailer Manifest Flag 수정.
     * 
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String cntrNo
     * @param String caFlg
     * @return	int
	 * @exception DAOException
	 */
    public int modifyCmFlgBySpcl2(String bkgNo, String spclTp, String cntrNo, String caFlg) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("spcl_tp", spclTp);
            mapVO.put("cntr_no", cntrNo);
            velParam.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOmodifyCmFlgBySpcl2USQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
    
	/**
     * Contailer Manifest Flag 수정.
     * 
	 * @param String bkgNo
	 * @param String rcvTermCd
	 * @param String deTermCd
     * @param String usrId
	 * @exception DAOException
	 */
    public int modifyMoveTypeByBkg(String bkgNo, String rcvTermCd, String deTermCd, String usrId) throws DAOException {
        
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("rcv_term_cd", rcvTermCd);
            mapVO.put("de_term_cd", deTermCd);
            mapVO.put("usr_id", deTermCd);
            velParam.put("usr_id", usrId);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        	
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOmodifyMoveTypeByBkgUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");		
        } catch(SQLException ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
}

