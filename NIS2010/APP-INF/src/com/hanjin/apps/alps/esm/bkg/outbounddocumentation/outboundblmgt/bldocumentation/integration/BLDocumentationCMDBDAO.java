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
===============================================================================
 History
 * 2010.09.14 이일민 [CHM-201005186] searchExistContainer 추가(금호타이어 edi err)
 * 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
 * 2011.01.25 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가
 * 2011.05.16 이일민 [CHM-201110332] ALPS Transshipment 메뉴 오류 수정요청
 * 2012.07.09 전성진 [] booking re-activate 기능 보완, Container cancel 원복처리 추가
 * 2012.09.20 변종건 [CHM-201219868-01] Split 01-Brazil Customs에 대한 Multi NCM Code 전송 Test를 위한 Flat File 생성 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgBlActWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForGeneralTmlVermasEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMoveOpInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMstInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrPkgWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrTpszQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CreateBkgBlDocBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MaxCycleBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.PreConfirmBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ValidateContainerWgtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescDtlVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.MstContainerVO;

/**
 * NIS2010 BLDocumentationCMDAO <br>
 * - NIS2010-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
      * Container Manifest 생성.
      * 
      * @param BkgCntrMfDescDtlVO vo
      * @param String caFlg
      * @exception DAOException
      * @exception Exception
      */
     public void addCmDtl(BkgCntrMfDescDtlVO vo, String caFlg) throws DAOException,Exception {
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
             BLDocumentationCMDBDAOAddCmDtlCSQL template = new BLDocumentationCMDBDAOAddCmDtlCSQL();
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
     * @param vo
     * @param caFlg
     * @return
     * @throws DAOException
     */
     public String searchCntrMfSeq(BkgCntrMfDescVO vo, String caFlg) throws DAOException {
    	 DBRowSet dbRowset = null;
    	 String cntrMfSeq = "";

    	 //query parameter
    	 Map<String, Object> param = new HashMap<String, Object>();
    	 //velocity parameter
    	 Map<String, Object> velParam = new HashMap<String, Object>();

    	 try{
    		 Map<String, String> mapVO = vo.getColumnValues();
             mapVO.put("ca_flg", caFlg);
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

    		 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchCntrMfSeqRSQL(), param, velParam);
    		 if(dbRowset.next()){
    			 cntrMfSeq = dbRowset.getString("CNTR_MF_SEQ");
    		 }
    	 } catch (SQLException ex) {
    		 //log.error(se.getMessage(),ex);
    		 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	 }catch(Exception ex){
    		 //log.error(ex.getMessage(),ex);
    		 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	 }
    	 
    	 return cntrMfSeq;
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
      * @param BkgCntrMfDescVO vo
      * @param String caFlg
      * @exception DAOException
      * @exception Exception
      */
     public void removeBrCm(BkgCntrMfDescVO vo, String caFlg) throws DAOException,Exception {
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

             SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
             BLDocumentationCMDBDAORemoveBrCmDSQL template = new BLDocumentationCMDBDAORemoveBrCmDSQL();
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
     * Container 생성. --ESM_BKG_0229_03
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @exception DAOException
     */
    public void insertCntrByXter(ContainerVO containerVO, String caFlg) throws DAOException {
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
            BLDocumentationCMDBDAOContainerByXterCSQL template = new BLDocumentationCMDBDAOContainerByXterCSQL();
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
     * Container 수정. --ESM_BKG_0229_03
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int updateCntrByXter(ContainerVO containerVO, String caFlg) throws DAOException {
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
            BLDocumentationCMDBDAOContainerByXterUSQL template = new BLDocumentationCMDBDAOContainerByXterUSQL();
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


//	/**
//	 *  act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
//	 *  
//	 * @author 		KimByungKyu
//	 * @param 		BkgBlNoVO bkgBlNoVO
//	 * @param 		String actWgt
//	 * @param 		String wgtUtCd 
//	 * @param 		String oldPodNodCd
//	 * @param 		String oldDelNodCd 
//	 * @param 		SignOnUserAccount account 
//	 * @exception 	DAOException
//	 */
//	public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, String oldPodNodCd, String oldDelNodCd, SignOnUserAccount account) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			if(bkgBlNoVO != null){
//				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
//
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			param.put("act_wgt", actWgt);
//			param.put("wgt_ut_cd", wgtUtCd);
//			param.put("old_pod_nod_cd", oldPodNodCd);
//			param.put("old_del_nod_cd", oldDelNodCd);
//			param.put("upd_usr_id", account.getUsr_id());
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationCMDBDAOModifyBlActWgtUSQL(), param,velParam);
//			if(updCnt == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to modify SQL");
//
//		}catch(SQLException ex){
//			//log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	/**
	 *  act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
	 *  
	 * @author 		WonJooCho
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		BkgBlActWgtVO bkgBlActWgtVO
	 * @param 		SignOnUserAccount account 
	 * @exception 	DAOException
	 */
	public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, BkgBlActWgtVO bkgBlActWgtVO, SignOnUserAccount account) throws DAOException {
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
			param.put("act_wgt", bkgBlActWgtVO.getActWgt());
			param.put("wgt_ut_cd", bkgBlActWgtVO.getWgtUtCd());
			param.put("old_pod_nod_cd", bkgBlActWgtVO.getOldPodNodCd());
			param.put("old_del_nod_cd", bkgBlActWgtVO.getOldDelNodCd());
			param.put("upd_usr_id", account.getUsr_id());
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
	 *  Container를 Activate 한다.(ESM_BKG_0000_1) -> reactivateBooking<br>
	 * @author 		Jeon Sung Jin
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
        try {
        	if ( sourceBkg != null ) {
        		Map<String, String> mapVO = targetBkg.getColumnValues();

        		param.putAll(mapVO);
        		param.put("mst_bkg_no", sourceBkg.getBkgNo());
        		param.put("cntr_no", cntrNo);
        		param.put("usr_id", account.getUsr_id());
        		velParam.putAll(mapVO);
        	}


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
     * B/L 수정.
     * 
     * @param CreateBkgBlDocBkgVO createBkgBlDocBkgVO
     * @param String caFlg
     * @exception DAOException
     */
//    public void modifyBlByFinalCfm(CreateBkgBlDocBkgVO createBkgBlDocBkgVO, String caFlg) throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        try{
//            // set parameters
//            Map<String, String> mapVO = new HashMap<String, String>();
//            mapVO.put("bkg_no", createBkgBlDocBkgVO.getBkgNo());
//            mapVO.put("ca_flg", caFlg);
//            
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            BLDocumentationCMDBDAOBlByFnlCfmUSQL template = new BLDocumentationCMDBDAOBlByFnlCfmUSQL();
//            // update 후 갱신여부는 중요치 않음.
//            sqlExe.executeUpdate(template, param,velParam);
//        }catch(SQLException ex){
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }catch(Exception ex){
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        } 
//    }

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
//    public void addBkgBlDoc(String bkgNo, String blMvTpNm, String fnlDestNm, String actWgt, String wgtUtCd, String userId) throws DAOException {
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        try {
//            param.put("bkg_no", bkgNo);
//            param.put("bl_mv_tp_nm", blMvTpNm);
//            param.put("fnl_dest_nm", fnlDestNm);
//            param.put("act_wgt", actWgt);
//            param.put("wgt_ut_cd", wgtUtCd);            
//            param.put("cre_usr_id", userId);
//            param.put("upd_usr_id", userId);
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOAddBkgBlDocCSQL(), param,
//                    velParam);
//            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
//
//        } catch(SQLException ex) {
//            // log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        } catch(Exception ex) {
//            // log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }
    
    /**
     * BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
     * 
     * @author 		KimByungKyu
     * @param 		CreateBkgBlDocBkgVO createBkgBlDocBkgVO
     * @param 		String userId
     * @exception DAOException
     */
    public void addBkgBlDoc(CreateBkgBlDocBkgVO createBkgBlDocBkgVO,  String userId) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", createBkgBlDocBkgVO.getBkgNo());
            param.put("bl_mv_tp_nm", createBkgBlDocBkgVO.getBlMvTpNm());
            param.put("fnl_dest_nm", createBkgBlDocBkgVO.getFnlDestNm());
            param.put("act_wgt", createBkgBlDocBkgVO.getActWgt());
            param.put("wgt_ut_cd", createBkgBlDocBkgVO.getWgtUtCd());            
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
			if(sourceBkg != null){
				Map<String, String> mapVO = sourceBkg .getColumnValues();

				param.putAll(mapVO);
	            param.put("source_bkg", sourceBkg.getBkgNo());
	            param.put("target_bkg", targetBkg.getBkgNo());
	            param.put("cntr_no", cntrNo);
	            param.put("partial_count", partialCount);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}

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
					if(sourceBkg != null){
						Map<String, String> mapVO = sourceBkg.getColumnValues();

						param.putAll(mapVO);
						param.put("source_bkg", sourceBkg.getBkgNo());
						velParam.putAll(mapVO);
					}
		            
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
     * CTM_MVMT_IRR 에 데이타 입력.<br>
     * 
     * @param CusCtmMovementVO ctmVO
     * @param boolean findBkgCntr
     * @param String vgmUpdateFlg
     * @param String vgmInsertFlg
     * @throws DAOException
     */
    public void modifyCntrOp2(CusCtmMovementVO ctmVO, boolean findBkgCntr, String vgmUpdateFlg, String vgmInsertFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO =  ctmVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put("vgm_upd_flg", vgmUpdateFlg);
			velParam.put("vgm_upd_flg", vgmUpdateFlg);
			param.put("vgm_ins_flg", vgmInsertFlg);
			velParam.put("vgm_ins_flg", vgmInsertFlg);
			
            if (findBkgCntr)
                velParam.put("fnd_bkg", "1");
            else 
                velParam.put("fnd_bkg", "0");
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOMstBkgCntrOc2USQL template = new BLDocumentationCMDBDAOMstBkgCntrOc2USQL();
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
             velParam.put("from_ebkg", "Y");
             
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
     * Container SealNo 수정해도 되는지 여부 조회.<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @return boolean
     * @exception DAOException
     */
    public boolean searchCntrSealNoModithCheck(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        boolean flag = true;
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
            BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL template = new BLDocumentationCMDBDAOCntrSealNoModithCheckRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if (dbRowset.next()) {
                flag = false;
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
     * Bangladesh Shipment Detail 에 대한 데이타 조회.
     * 
     * @param BkgCustShpRqstVO bkgCustShpRqstVO
     * @return List<BkgCustShpRqstVO>
     * @exception DAOException
     */
	 @SuppressWarnings("unchecked")
	public List<BkgCustShpRqstVO> searchBkgCustShpRqstList(BkgCustShpRqstVO bkgCustShpRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustShpRqstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCustShpRqstVO != null){
				
				Map<String, String> mapVO = bkgCustShpRqstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchBkgCustShpRqstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustShpRqstVO .class);
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
      * 방글라데시 ODCY로부터의 파일을 일정 형식으로 저장 
      * 
      * @param BkgCustShpRqstVO bkgCustShpRqstVO
      * @param SignOnUserAccount account
      * @exception DAOException
      */
     public void addBkgCustShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO,SignOnUserAccount account) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         Map<String, Object> velParam = new HashMap<String, Object>();
         Map<String, String> mapVO = null;
         try {
        	 if(bkgCustShpRqstVO != null){
             mapVO = new HashMap<String, String>();
             mapVO = bkgCustShpRqstVO.getColumnValues();
            // mapVO.put("fnd_bkg", findBkgCntr);
             param.putAll(mapVO);
             velParam.putAll(mapVO);
        	 }
        	 
             
 			param.put("upd_usr_id", account.getUsr_id());
 			param.put("cre_usr_id", account.getUsr_id());
             int insCnt = (new SQLExecuter("DEFAULT")).executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOAddBkgCustShpRqstCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
         } catch(SQLException ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }
     
     /**
      * 방글라데시 ODCY로부터의 파일을 일정 형식으로 수정 
      * 
      * @param BkgCustShpRqstVO bkgCustShpRqstVO
      * @param SignOnUserAccount account
      * @exception DAOException
      */
     public void modifyBkgCustShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO,SignOnUserAccount account) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         Map<String, Object> velParam = new HashMap<String, Object>();
         Map<String, String> mapVO = null;
         
         try {
        	 
        	 if(bkgCustShpRqstVO != null){
             mapVO = new HashMap<String, String>();
             mapVO = bkgCustShpRqstVO.getColumnValues();
            // mapVO.put("fnd_bkg", findBkgCntr);
             param.putAll(mapVO);
             velParam.putAll(mapVO);
        	 }
        	 
             
 			param.put("upd_usr_id", account.getUsr_id());
 			param.put("cre_usr_id", account.getUsr_id());
             int insCnt = (new SQLExecuter("DEFAULT")).executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOModifyBkgCustShpRqstUSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
         } catch(SQLException ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }
     
     /**
      * 방글라데시 ODCY로부터의 파일을 일정 형식으로 삭제
      * 
      * @param BkgCustShpRqstVO bkgCustShpRqstVO
      * @param SignOnUserAccount account
      * @exception DAOException
      */
     public void removeBkgCustShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO,SignOnUserAccount account) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         Map<String, Object> velParam = new HashMap<String, Object>();
         Map<String, String> mapVO = null;
         
         try {
        	 
        	 if(bkgCustShpRqstVO != null){
             mapVO = new HashMap<String, String>();
             mapVO = bkgCustShpRqstVO.getColumnValues();
           
             param.putAll(mapVO);
             velParam.putAll(mapVO);
        	 }
      
             int insCnt = (new SQLExecuter("DEFAULT")).executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAORemoveBkgCustShpRqstDSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
             
             
         } catch(SQLException ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }
     /**
      * Bangladesh Shipment Detail 에 대한 데이타 조회.
      * 
      * @param BkgCustShpRqstVO bkgCustShpRqstVO
      * @return List<BkgCustShpRqstVO>
      * @exception DAOException
      */
 	 @SuppressWarnings("unchecked")
 	public List<BkgCustShpRqstVO> searchBkgCntrShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<BkgCustShpRqstVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 			if(bkgCustShpRqstVO != null){
 				
 				Map<String, String> mapVO = bkgCustShpRqstVO .getColumnValues();
 			
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchBkgCntrShpRqstRSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustShpRqstVO .class);
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
      * Restuffing Container 데이타 조회.
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
 	 * 적화목록 신고번호 조회
 	 * 
     * @param BkgCntrMfDescVO inputVO
     * @return String
     * @exception DAOException
     */
 	public String searchBkgHblByRqstNo(BkgCntrMfDescVO inputVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		String cntrMfNo = "";
 		
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 			if(inputVO != null){
 				
 				Map<String, String> mapVO = inputVO .getColumnValues();
 			
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 			}
 			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
 			BLDocumentationCMDBDAOSearchBkgHblByRqstNoRSQL template = new BLDocumentationCMDBDAOSearchBkgHblByRqstNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if ( dbRowset!=null && dbRowset.next() ){
 				cntrMfNo = dbRowset.getString(1);
			}
 		} catch(SQLException se) {
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
 		} catch(Exception ex) {
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
 		}
 		return cntrMfNo;
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
	 * BKG No.로 BDR이 걸렸는지 check
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBdrFlgForNewRoute(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchBdrFlgForNewRouteRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("FLG");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	
    /**
     * BKG_CNTR_MF_DESC_DTL테이블 삭제
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @throws DAOException
     */
    public void removeCmDtlByCntr(String bkgNo, String cntrNo, String caFlg) throws DAOException {
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
            BLDocumentationCMDBDAOCntrMfDescDtlDSQL template = new BLDocumentationCMDBDAOCntrMfDescDtlDSQL();
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
	 * Container Seal 별 cntr no를 변경한다.
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
	 * @param caFlg
     * @exception DAOException
     */
    public void changeCntrSealNo(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws DAOException {
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
            BLDocumentationCMDBDAOChangeCntrSealNoUSQL template = new BLDocumentationCMDBDAOChangeCntrSealNoUSQL();
            int delCnt = sqlExe.executeUpdate(template, param,velParam);
            if(delCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to remove SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
 	 * Container Weight Maximum Payload 내 입력 유도 및 오입력 방지 ESM_BKG_0079_04 
 	 * 
     * @param String cntrNo
     * @param String cntrTpszCd
     * @return ValidateContainerWgtVO
     * @exception DAOException
     */
	public ValidateContainerWgtVO validateContainerWgt(String cntrNo, String cntrTpszCd) throws DAOException {
		DBRowSet dbRowset = null;
		ValidateContainerWgtVO rsVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_tpsz_cd", cntrTpszCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOValidateContainerWgtRSQL template = new BLDocumentationCMDBDAOValidateContainerWgtRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);

            List<ValidateContainerWgtVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ValidateContainerWgtVO.class);
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
     * @param String bkgNo
     * @param String cntrNo
     * @return List<BkgBlNoVO>
     * @exception DAOException
     */
	public List<BkgBlNoVO> searchPartialBkgCntr(String bkgNo,
			String cntrNo) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<BkgBlNoVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 				
 			param.put("bkg_no", bkgNo);
 			velParam.put("bkg_no", bkgNo);
 			param.put("cntr_no", cntrNo);
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
 	 * Booking에 기 Attach된 혹은 Attached 될 대상 Container에 대한 마지막 Movement 정보를 조회한다. 
 	 * 
     * @param String bkgNo
     * @param String cntrNo
     * @return BkgContainerVO
     * @exception DAOException
     */
	public BkgContainerVO searchCntrLstMvntInfo(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgContainerVO rsVO = null;
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
            BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL template = new BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL();
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
     * Movement 정보를 업데이트 한다. 현재는 Cycle No번 적용되었고 향후 추가 가능하다.
     * 
     * @param BkgContainerVO mvntCntrVo
     * @param String caFlg
     * @exception DAOException 
     */
    public void modifyCntrMvntSts(BkgContainerVO mvntCntrVo, String caFlg) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", mvntCntrVo.getBkgNo());
            mapVO.put("cntr_no", mvntCntrVo.getCntrNo());
            mapVO.put("cnmv_cyc_no", mvntCntrVo.getCnmvCycNo());
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOmodifyCntrMvntInfoUSQL template = new BLDocumentationCMDBDAOmodifyCntrMvntInfoUSQL();
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
 	 * Container Master Risk Flg Container Risk 해당 하는 장비이면 Validation 처리 한다.  
 	 * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @param String rcFlg
     * @return boolean
     * @exception DAOException
     */
	public boolean validateCntrRsk(String bkgNo, String cntrNo, String caFlg, String rcFlg) throws DAOException {
		boolean isCount = false;
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
            mapVO.put("rc_flg", rcFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOValidateCntrRskFlgRSQL template = new BLDocumentationCMDBDAOValidateCntrRskFlgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isCount = true;
				}
			}
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isCount;
	}
	
    /**
     * Partial BKG 조회
     *
     * @author Kim tae kyoung
     * @param String bkgNo
     * @param String cntrNo
     * @return String
     * @exception DAOException
     */
    public String searchDupCntrAttach(String bkgNo, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        StringBuffer sbuf = new StringBuffer();
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
            BLDocumentationCMDBDAOSearchDupCntrAttachRSQL template = new BLDocumentationCMDBDAOSearchDupCntrAttachRSQL();
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
        return sbuf.toString();
    }

	/**
	 * bkg_container 테이블에 한국 WHF BKG별 Exception 정보를  update한다.<br>
	 * 
	 * @param CntrKrWhfExptVO cntrKrWhfExptVO
	 * @exception DAOException
	 */
	public void modifyBkgKrWhfExpt(CntrKrWhfExptVO cntrKrWhfExptVO) throws DAOException {
       
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
            
			Map<String, String> mapVO = cntrKrWhfExptVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(new BLDocumentationCMDBDAOModifyBkgKrWhfExptUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)  throw new DAOException("Fail to update SQL - BKG CNTR_WFG_EXPT_FLG ");
            
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	
    /**
     * BL body에 찍힐 WPM관련 문구를 생성합다.
     * @param BkgBlNoVO bkgBlNoVO
     * @param String xterFlg
     * @return String
     * @throws DAOException
     */
    public String searchWpmDescForBl(BkgBlNoVO bkgBlNoVO, String xterFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            mapVO.put("xter_flg", xterFlg);
            velParam.put("xter_flg", xterFlg);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchWpmDescForBlRSQL template = new BLDocumentationCMDBDAOSearchWpmDescForBlRSQL();
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
     * 파셜된 컨테이너에 attach된 bkg를 검색
     * @param String bkgNo
     * @param String cntrNo
     * @return String[]
     * @throws DAOException
     */
    public String[] searchPartialCntrBkg(String bkgNo, String cntrNo) throws DAOException {
        String[] bkgArr = null;
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	Map<String, String> mapVO = new HashMap<String, String>();
        	
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL template = new BLDocumentationCMDBDAOSearchPartialCntrBkgRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            bkgArr = new String[dbRowset.getRowCount()];
			int i = 0;
			while (dbRowset.next()) {
				bkgArr[i] = dbRowset.getString("BKG_NO");
				i++;
			}	
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgArr;
    }
    
    /**
     * VGM Min, Max check
     * @param String vgmWgtQty
     * @param String cntrTpSz
     * @param String vgmWgtUtCd
     * @return String
     * @throws DAOException
     */
    public String checkVGMMinMax(String vgmWgtQty, String cntrTpSz, String vgmWgtUtCd) throws DAOException {
        String flg = null;
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	Map<String, String> mapVO = new HashMap<String, String>();
        	
        	mapVO.put("vgm_wgt_qty", vgmWgtQty);
            mapVO.put("cntr_tp_sz", cntrTpSz);
            mapVO.put("vgm_wgt_ut_cd", vgmWgtUtCd);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOcheckVGMMinMaxRSQL template = new BLDocumentationCMDBDAOcheckVGMMinMaxRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            if(dbRowset.next()){
            	flg = dbRowset.getString("FLG");
			}	
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    }
    
    /**
     * MVMT로 받은 VGM의 업데이트 조건 검사를 위한 쿼리
     * @param String partialBkgNo
     * @param CusCtmMovementVO ctmVO
     * @return String
     * @throws DAOException
     */
    public String searchConditionForVGM(String partialBkgNo, CusCtmMovementVO ctmVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO =  ctmVO.getColumnValues();
        	
        	mapVO.put("partial_bkg_no", partialBkgNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOSearchConditionForVGMRSQL template = new BLDocumentationCMDBDAOSearchConditionForVGMRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
            	result = "N";
            }
        } catch(SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }
    
    /**
     * CNTR Wgt와 VGM Wgt 값 비교
     * @param String bkgNo
     * @param String cntrNo
     * @param String vgmWgt
     * @return String
     * @throws DAOException
     */
    public String checkCntrWgtWithVgmWgt(String bkgNo, String cntrNo, String vgmWgt) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO =  new HashMap<String, String>();
        	
        	mapVO.put("bkg_no", bkgNo);
        	mapVO.put("cntr_no", cntrNo);
        	mapVO.put("vgm_wgt", vgmWgt);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL template = new BLDocumentationCMDBDAOCheckCntrWgtWithVgmWgtRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
            	result = "N";
            }
        } catch(SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }
    
    /**
     * VGM update from MVMT only<br>
     * 
     * @param CrossItemVO item
     * @return int
     * @throws DAOException
     */
    public int updateVGMForOnlyMVMT(CrossItemVO item) throws DAOException {
    	int updCnt = 0;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {            
        	// set parameters
        	Map<String, String> mapVO =  new HashMap<String, String>();
        	
            
            mapVO.put("bkg_no", item.getCusCtmMovementVO().getBkgNo());
        	mapVO.put("cntr_no", item.getCusCtmMovementVO().getCntrNo());
        	mapVO.put("vgm_wgt_qty", item.getCusCtmMovementVO().getVgmWgtQty());
        	mapVO.put("vgm_wgt_ut_cd", item.getCusCtmMovementVO().getVgmWgtUtCd());
        	mapVO.put("vgm_sig_ctnt", item.getCusCtmMovementVO().getVgmSigCtnt());
        	mapVO.put("vgm_mzd_tp_cd", item.getCusCtmMovementVO().getVgmMzdTpCd());
        	mapVO.put("upd_usr_id", item.getCusCtmMovementVO().getUpdUsrId());
        	
        	param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL template = new BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modify SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
    
    /**
     * VGM update from TRS only<br>
     * 
     * @param ContainerVO containerVO
     * @return int
     * @throws DAOException
     */
    public int updateVGMFromTrs(ContainerVO containerVO) throws DAOException {
    	int updCnt = 0;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {            
        	// set parameters
        	Map<String, String> mapVO =  new HashMap<String, String>();
        	
        	mapVO.put("bkg_no", containerVO.getBkgNo());
         	mapVO.put("cntr_no", containerVO.getCntrNo());
         	mapVO.put("vgm_wgt", containerVO.getVgmWgt());
         	mapVO.put("vgm_wgt_ut_cd", containerVO.getVgmWgtUtCd());
         	mapVO.put("upd_usr_id", containerVO.getUpdUsrId());
        	
        	param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL template = new BLDocumentationCMDBDAOUpdateVGMFromTRSUSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modify SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }
    
    /**
     * BKG CNTR에 VGM값 있는지 체크
     * @param ContainerVO containerVO
     * @return String
     * @throws DAOException
     */
    public String checkBkgVgmExist(ContainerVO containerVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO =  containerVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckBkgVgmExistRSQL template = new BLDocumentationCMDBDAOCheckBkgVgmExistRSQL();
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
     * BKG CNTR loadable max 체크
     * @param String cntrWgt
     * @param String cntrTpSz
     * @param String wgtUtCd
     * @return String
     * @throws DAOException
     */
    public String checkLoadableMax(String cntrWgt, String cntrTpSz, String wgtUtCd) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO =  new HashMap<String, String>();
        	
            
            mapVO.put("cntr_wgt", cntrWgt);
        	mapVO.put("cntr_tp_sz", cntrTpSz);
        	mapVO.put("wgt_ut_cd", wgtUtCd);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckLoadableMaxRSQL template = new BLDocumentationCMDBDAOCheckLoadableMaxRSQL();
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
     * BKG CNTR가 SOC인지 체크
     * @param String cntrNo
     * @return String
     * @throws DAOException
     */
    public String checkSocCntr(String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            // set parameters
        	Map<String, String> mapVO =  new HashMap<String, String>();
        	mapVO.put("cntr_no", cntrNo);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationCMDBDAOCheckSocCntrRSQL template = new BLDocumentationCMDBDAOCheckSocCntrRSQL();
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
     * 같은 Partial Container 를 가진 Booking 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return List<BkgContainerVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgContainerVO> searchPtlCntrBkg(String bkgNo, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgContainerVO> list = null;
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

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchPtlCntrBkgRSQL(),  param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);
            
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
	 * 같은 Partial Container 를 가진 Booking 의 VGM 정보를 update 한다.<br>
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String targetBkgNo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPtlCntrVgmCopy(String bkgNo, String cntrNo, String targetBkgNo, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("target_bkg_no", targetBkgNo);
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationCMDBDAOModifyPtlCntrVgmCopyUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			// log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			// log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	
	/**
	 * VGM을 변경한 이력이 있는지 확인
	 * @param BkgContainerVO bkgContainerVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVgmChgHis(BkgContainerVO bkgContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cntrNo = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchVgmChgHisRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()){
				cntrNo = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrNo;
	}
	
	/**
	 * VGM outbound를 위한 Flat File Rcv ID 조회<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<TmnlRcvIdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchVGMOutboundRcvIdForMVMT(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TmnlRcvIdVO> list = null;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				mapVO.put("brac_cd", "9");
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOsearchVGMOutboundRcvIdForMVMTRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO .class);
						
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	 /**
	 * VERMAS 멀티 전송을 위한 리스트 조회 (ESM_BKG_1187)<br>
	 *
	 * @author 
	 * @param BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO
	 * @return List<BkgListForGeneralTmlVermasEdiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListForGeneralTmlVermasEdiVO> searchBkgListForGeneralTmlVermasEdi(BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForGeneralTmlVermasEdiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgListForTmlVermasEdiInputVO != null){
				Map<String, String> mapVO = bkgListForTmlVermasEdiInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForGeneralTmlVermasEdiVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
}
