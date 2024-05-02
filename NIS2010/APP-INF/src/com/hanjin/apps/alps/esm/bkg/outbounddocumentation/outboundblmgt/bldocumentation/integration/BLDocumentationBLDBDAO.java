/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationBLDAO.java
 *@FileTitle : Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.15
 *@LastModifier : 최 선
 *@LastVersion : 1.3
 * 2009.04.23 김영출
 * 1.0 Creation
 * -----------------------------------------------------------
 * History
 * 2010.11.23 최도순 1.1 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
 * 2010.12.08 김영철 1.2 [] R4J 주석수정 ( addMndByCust )
 * 2010.12.15 최 선     1.3 [CHM-201007417] PO & Other No (General) Incoterms Column Add, Validation 
 * 2010.12.21 김영철 1.4 [] R4J 주석수정 ( searchPoMdtItm, searchBkgRefTpCd )
 * 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.10.10 김기택 [CHM-201220360-01] POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용 제외
=========================================================*/
 
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOSearchPoMdtItmRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlAppWordVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlStatusVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MfNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrCycVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrStsVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.WgtPkgMeasVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmInfoValidationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlDocVO;
import com.hanjin.syscommon.common.table.BkgBlMkDescVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgHblCustVO;
import com.hanjin.syscommon.common.table.BkgHblVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfVO;

/**
 * NIS2010 BLDocumentationBLDAO <br>
 * - NIS2010-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BLDocumentationBLBCImpl 참조
 * @since J2EE 1.4
 */
public class BLDocumentationBLDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 4183510456193600872L;

	/**
	 * BKG_CHG_RT에서 BkgBlDoc Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 수정]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String mcflag
	 * @param String caflag
	 * @return int
	 * @exception DAOException
	 */
	public int modifyChgRateBkgBlDocMasterCovered(RateMainInfoVO rateMainInfoVO, String mcflag ,String caflag) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = rateMainInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.put("caflag", caflag);
			velParam.put("mcflag", mcflag);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOModifyChgRateBkgBlDocMasterCoveredUSQL(), param, velParam);
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
	 * EsmBkg0771 데이터를 갱신처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다.<br>
	 * BL_CVRD_TP_CD 도 Null로 업데이트 한다.<br>
	 * //[결함관리지침에 따른 수정]
	 * @author Lee Jin Seo
	 * @param List<CoveredBlListVO> listVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public int modifyCoveredBl(List<CoveredBlListVO> listVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int size = listVO.size();
		int insCnt = 0;

		try {

			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					CoveredBlListVO coveredBlListVO = (CoveredBlListVO) list.next();
					Map<String, String> mapVO = coveredBlListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOModifyCoveredBlUSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * BKG_CHG_RT에서 BkgBlDoc Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 수정]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @return int
	 * @exception DAOException
	 */
	public int modifyChgRateBkgBlDoc(RateMainInfoVO rateMainInfoVO, String caflag) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = rateMainInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.put("caflag", caflag);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOModifyChgRateBkgBlDocUSQL(), param, velParam);
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
	 * Issue Type 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmanageBlIssueFlgUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    /**
     * B/L Issue 관련 B/L Doc 정보를 변경한다. -- UI_BKG-0079-09, BKG B/L ISSUE.
     * 
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception DAOException
     */
	public void modifyBlIssInfoForBlDoc(BlIssInfoVO blIssInfoVO) throws DAOException {
		int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blIssInfoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBlIssInfoForBlDocUSQL(), param, velParam);
			
            if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }
	
    /**
     * MndVO 데이타 모델에 해당되는 값을 불러온다.
     * 
     * @param bkgBlNoVO BkgBlNoVO
     * @return MndVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public MndVO searchMnd(BkgBlNoVO bkgBlNoVO) throws DAOException {
        MndVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            mapVO.put("usr_id", (bkgBlNoVO.getIbflag()==null ? "" : bkgBlNoVO.getIbflag()));

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter executer = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOMndRSQL template = new BLDocumentationBLDBDAOMndRSQL();
            DBRowSet dbRowset = executer.executeQuery(template, param, velParam);
            List<MndVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, MndVO.class);
            if(list != null && list.size() > 0) {
                rsVO = list.get(0);
            }else{
                rsVO = new MndVO();
            }
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

	/**
	 * PO No.의 Mandatory Item을 조회한다.
	 * POB : P/O No (by BKG)
	 * POC : P/O Nl ( by CNTR)
	 * POM : P/O No (by ITEM)
	 * INV : Invoice No.
	 * DPT : Department No
	 * LCN : L/C No
	 * SHP : Ship ID
	 * PRT : Part No
     * INC : Incoterms
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPoMdtItm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rPoOtherMdtItm = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoMdtItmRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()){
				rPoOtherMdtItm = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rPoOtherMdtItm;
	}
	
	/**
	 * PO No.의 Mandatory Item을 조회한다.
	 * BKPO : POB : P/O No (by BKG)
	 * CTPO : POC : P/O Nl ( by CNTR)
	 * CMPO : POM : P/O No (by ITEM)
	 * HINV : INV : Invoice No.
	 * HPDP : DPT : Department No
	 * LCNO : LCN : L/C No
	 * HPSH : SHP : Ship ID
	 * HPPN : PRT : Part No
     * INCO : INC : Incoterms
	 *
	 * @param String rPoOtherMdtItm
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBkgRefTpCd(String rPoOtherMdtItm, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgRefTpCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
//		StringTokenizer strRPoOtherMdtItm = null;
		String tempRPoOtherMdtItm = ""; 
		
		try{
			if(rPoOtherMdtItm != null){
				param.put("bkg_no", bkgNo);
				
				int lenRPoOtherMdtItm = rPoOtherMdtItm.length();
				
				//s_n3pty_no_strs_link 넣는 부분
				if(!rPoOtherMdtItm.equals("")){
					rPoOtherMdtItm = rPoOtherMdtItm.substring(0,lenRPoOtherMdtItm);
					StringTokenizer strRPoOtherMdtItm = new StringTokenizer(rPoOtherMdtItm, ",");
					tempRPoOtherMdtItm = strRPoOtherMdtItm.nextToken();
					tempArrL.add(tempRPoOtherMdtItm);

					while(strRPoOtherMdtItm.hasMoreTokens()){
						tempRPoOtherMdtItm = strRPoOtherMdtItm.nextToken();
						tempArrL.add(tempRPoOtherMdtItm);
					}
				}
				if(tempArrL.size()>0){
					velParam.put("r_po_other_mdt_itm", tempArrL);
				}
			}
			

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOBkgRefTpCdRSQL(), param, velParam);
			
			if(dbRowset != null && dbRowset.next()){
//				log.debug("bkgRefTpCd>>>>>>>>>"+dbRowset.getString(1));
				bkgRefTpCd = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgRefTpCd;
	}
	
    /**
     *  Mark And Description 입력.
     *  
     * @param BkgBlMkDescVO blMkDescVO
     * @param String caFlg
     * @exception DAOException
     */
    public void addMnd(BkgBlMkDescVO blMkDescVO, String caFlg) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put("mk_desc", blMkDescVO.getCrLfTabOffMkDesc());
            param.put("cmdt_desc", blMkDescVO.getCrLfTabOffCmdtDesc());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOBkgBlMndCSQL template = new BLDocumentationBLDBDAOBkgBlMndCSQL();
            sqlExe.executeUpdate(template, param, velParam);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }   
    
    /**
     * Mark And Description 수정.
     * 
     * @param BkgBlMkDescVO blMkDescVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int modifyMnd(BkgBlMkDescVO blMkDescVO, String caFlg) throws DAOException {
        int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put("mk_desc", blMkDescVO.getCrLfTabOffMkDesc());
            param.put("cmdt_desc", blMkDescVO.getCrLfTabOffCmdtDesc());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOBkgBlMndUSQL template = new BLDocumentationBLDBDAOBkgBlMndUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
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
     * Dangerous Cargo 조회.
     * 
     * @param String bkgNo
     * @return List<DGCargoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<DGCargoVO> searchDG(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<DGCargoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

            Map<String, String> mapVO = new HashMap();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAODGCargoRSQL template = new BLDocumentationBLDBDAODGCargoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DGCargoVO.class);
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
     * B/L 수정.
     * 
     * @param BkgBlDocVO bkgBlDocVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int modifyBl(BkgBlDocVO bkgBlDocVO, String caFlg) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = bkgBlDocVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOBkgBlUSQL template = new BLDocumentationBLDBDAOBkgBlUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }

//    /**
//     * 
//     * @param blMkDescVO
//     * @return int
//     * @exception DAOException
//     */
//    public int manageMnd(BkgBlMkDescVO blMkDescVO) throws DAOException {
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        int result = 0;
//        try {
//            Map<String, String> mapVO = blMkDescVO.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            BLDocumentationBLDBDAOModifyBlMndUSQL template = new BLDocumentationBLDBDAOModifyBlMndUSQL();
//            result = sqlExe.executeUpdate(template, param, velParam);
//            // log.debug("** executeUpdate : " + result);
//            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
//        } catch(SQLException ex) {
//            // log.error(ex.getMessage(),ex);
//            throw new DAOException(ex.getMessage(), ex);
//        } catch(Exception ex) {
//            // log.error(ex.getMessage(),ex);
//            throw new DAOException(ex.getMessage(), ex);
//        }
//        return result;
//    }

    /**
     * Export / Import Information 국가별 조회 처리 (ESM_BKG_0361_01~06)<br>
     * 
     * @author Choi Do Soon
     * @param XptImpLicInVO xptImpLicIn
     * @param String caFlg
     * @return List<XptImpLicVO> list
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<XptImpLicVO> searchExportImportNumber(XptImpLicInVO xptImpLicIn, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<XptImpLicVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO =  xptImpLicIn.getColumnValues();
        	
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);	   
        	velParam.put("ca_flg", caFlg);       
            
            SQLExecuter exec = new SQLExecuter("DEFAULT");

            BLDocumentationBLDBDAOXptImpLicRSQL template = new BLDocumentationBLDBDAOXptImpLicRSQL();

            dbRowset = exec.executeQuery(template, param, velParam);

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, XptImpLicVO.class);
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
     * Export / Import Information 국가별 입력 처리 (ESM_BKG_0361_01~06)<br>
     * 
     * @author Choi Do Soon
     * @param List<XptImpLicVO> insModels
     * @param String cntCd
     * @param String caFlg
     * @return int[]
     * @exception DAOException
     */
    public int[] createExportImportNumber(List<XptImpLicVO> insModels, String cntCd, String caFlg) throws DAOException {
        int[] insCnt = null;
        int cnt = 0;
        int idx = 0;
        Map<String, Object> param = null;
        Map<String, Object> velParam = null;
        Map<String, String> mapVO = null;
        SQLExecuter sqlExe = null;
        ISQLTemplate template = null;
        try {
	            sqlExe = new SQLExecuter("DEFAULT");
	            template = (ISQLTemplate)new BLDocumentationBLDBDAOXptImpLicCSQL();
	            if (0 < insModels.size()) {
	            	insCnt = new int[insModels.size()];
	            	for (XptImpLicVO vo : insModels) {
		            	param = new HashMap<String, Object>();
		            	velParam = new HashMap<String, Object>();
		            	mapVO = vo.getColumnValues();
		            	param.putAll(mapVO);
		            	velParam.putAll(mapVO);
		            	velParam.put("cnt_cd", cntCd);
		            	velParam.put("ca_flg", caFlg);
		            	cnt = sqlExe.executeUpdate(template, param, velParam);
		            	insCnt[idx] = cnt;
		            	if(cnt == Statement.EXECUTE_FAILED) {
		            		throw new DAOException("Fail to insert No" + ++idx + " SQL");
		            	}
	            	}
	            }
        } catch(SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return insCnt;
    }


    /**
     * Export / Import Information 국가별 수정 처리 (ESM_BKG_0361_01~06)<br>
     * 
     * @author Choi Do Soon
     * @param List<XptImpLicVO> updModels
     * @param String cntCd
     * @param String caFlg
     * @return int[]
     * @throws DAOException
     */
    public int[] modifyExportImportNumber(List<XptImpLicVO> updModels, String cntCd, String caFlg) throws DAOException {
        int updCnt[] = null;
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	velParam.put("cnt_cd", cntCd);
        	velParam.put("ca_flg", caFlg);
        	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(updModels.size() > 0) {
                BLDocumentationBLDBDAOXptImpLicUSQL template = new BLDocumentationBLDBDAOXptImpLicUSQL();
                
                updCnt = sqlExe.executeBatch(template, updModels, velParam);

                for(int i = 0; i < updCnt.length; i++) {
                    if(updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
                }
            }

        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return updCnt;
    }

    /**
     * Export / Import Information 국가별 삭제 처리 (ESM_BKG_0361_01~06)<br>
     * 
     * @author Choi Do Soon
     * @param List<XptImpLicVO> delModels
     * @param String caFlg
     * @return  int[]
     * @exception DAOException
     */
    public int[] removeExportImportNumber(List<XptImpLicVO> delModels, String caFlg) throws DAOException {
        int delCnt[] = null;
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        	velParam.put("ca_flg", caFlg);

            if(delModels.size() > 0) {
                BLDocumentationBLDBDAOXptImpLicDSQL template = new BLDocumentationBLDBDAOXptImpLicDSQL();
                delCnt = sqlExe.executeBatch(template, delModels, velParam);
                for(int i = 0; i < delCnt.length; i++) {
                    if(delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No" + i + " SQL");
                }
            }

        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return delCnt;
    }

    /**
     * bkg_bl_doc 테이블을 복사하되 weight, package, measure 관련속성은 splitBlInfoVO의 값으로 바꾼다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SplitBlInfoVO splitBlInfoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgBlDocByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        Map<String, String> mapVO = splitBlInfoVO.getColumnValues();
        try {
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put("targetBkg", targetBkg.getBkgNo());
            param.put("usr_id", account.getUsr_id());
            param.put("bkg_no", sourceBkg.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOcopyBkgBlDocByBkgCSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * bkg_bl_mk_desc 테이블을 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyMndByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {

            param.put("targetBkg", targetBkg.getBkgNo());
            param.put("usr_id", account.getUsr_id());
            param.put("bkg_no", sourceBkg.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOcopyMndByBkgCSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * bkg_xpt_imp_lic 테이블을 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyExportImportNumberByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account)
            throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {

            param.put("targetBkg", targetBkg.getBkgNo());
            param.put("usr_id", account.getUsr_id());
            param.put("bkg_no", sourceBkg.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate(
                    (ISQLTemplate) new BLDocumentationBLDBDAOcopyExportImportNumberByBkgCSQL(), param, velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * bkg_bl_doc에 전달받은 weight, packge, meas 정보를 update한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param SplitBlInfoVO splitBlInfoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyBkgBlDocAfterSplit(BkgBlNoVO sourceBkg, SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account)
            throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {

            param.put("pck_qty", splitBlInfoVO.getPckQty());
            param.put("pck_tp_cd", splitBlInfoVO.getPckTpCd());
            param.put("meas_qty", splitBlInfoVO.getMeasQty());
            param.put("meas_ut_cd", splitBlInfoVO.getMeasUtCd());
            param.put("act_wgt", splitBlInfoVO.getActWgt());
            param.put("wgt_ut_cd", splitBlInfoVO.getWgtUtCd());
            param.put("usr_id", account.getUsr_id());
            param.put("bkg_no", sourceBkg.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBkgBlDocAfterSplitUSQL(),
                    param, velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * bkg_hbl 테이블을 sourceBkg -> targetBkg로 복사한다 (ESM_BKG_0099) cntr_mf_no는 ORG_CNTR_MF_NO로 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyHblByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			param.put("targetBkg", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());
			param.put("bkg_no", sourceBkg.getBkgNo());
			velParam.put("copy_mode_cd", copyModeCd);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOcopyHblByBkgCSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * bkg_hbl_cust 테이블을 sourceBkg -> targetBkg로 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyHblCustByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, 
            SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {

            
			param.put("targetBkg", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());
			param.put("bkg_no", sourceBkg.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOcopyHblCustByBkgCSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * 전달받은 cntrNo로 bkg_container에서 cntr_mf_no를 조회하여 hbl에서 cntr_mf_no가 같은 row를 삭제한다. (ESM_BKG_0099)
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @exception DAOException
     */
    public void removeBkgHblByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgBlNoVO.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOremoveBkgHblByBkgDSQL(), param,
                    velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");

        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 전달받은 cntrNo로 bkg_hbl_cus에서 조회하여 hbl에서 같은 row를 삭제한다
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @exception DAOException
     */
    public void removeBkgHblCustByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgBlNoVO.getBkgNo());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOremoveBkgHblCustByBkgDSQL(),
                    param, velParam);
            if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");

        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     *  CmGoodsDescVO 모델에 해당하는 데이타 조회.
     *  
     * @param String bkgNo
     * @return CmGoodsDescVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CmGoodsDescVO searchGoodsDescByCm(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        CmGoodsDescVO rsVo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOCmGoodsDescRSQL template = new BLDocumentationBLDBDAOCmGoodsDescRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<CmGoodsDescVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmGoodsDescVO.class);
            if(list.size() > 0) {
                rsVo = list.get(0);
            } else {
                rsVo = new CmGoodsDescVO();
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVo;
    }

    /**
     * B/L Onboard Date 수정.
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @exception DAOException
     */
    public void modifyBlObrdDt(GrpBlDtListVO grpBlDtListVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = grpBlDtListVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOBlObrdDtUSQL template = new BLDocumentationBLDBDAOBlObrdDtUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * HblForMndVO 모델에 해당하는 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<HblForMndVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HblForMndVO> searchHblForMnd(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<HblForMndVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblForMndRSQL template = new BLDocumentationBLDBDAOHblForMndRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, HblForMndVO.class);
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
     * BkgNvoccProfVO 모델에 해당하는 데이타 조회.
     * 
     * @param String shprNm
     * @param String cneeNm
     * @param String ofcCd
     * @return List<BkgNvoccProfVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgNvoccProfVO> searchHblCustTmplt(String shprNm, String cneeNm, String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgNvoccProfVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("ofc_cd", ofcCd);
            param.put("act_shpr_nm", shprNm);
            param.put("ulti_cnee_nm", cneeNm);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCustTmpltRSQL template = new BLDocumentationBLDBDAOHblCustTmpltRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgNvoccProfVO.class);
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
     * BkgNvoccProfCntrMfVO 모델에 해당하는 데이타 조회.
     * 
     * @param String shprNm
     * @param String cneeNm
     * @param String ofcCd
     * @return List<BkgNvoccProfCntrMfVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgNvoccProfCntrMfVO> searchHblCmTmplt(String shprNm, String cneeNm, String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgNvoccProfCntrMfVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("ofc_cd", ofcCd);
            param.put("act_shpr_nm", shprNm);
            param.put("ulti_cnee_nm", cneeNm);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCmTmpltRSQL template = new BLDocumentationBLDBDAOHblCmTmpltRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgNvoccProfCntrMfVO.class);
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
     * House B/L의 고객의 템블릿 생성.
     * 
     * @param BkgNvoccProfVO vo
     * @exception DAOException
     */
    public void createHblCustTmplt(BkgNvoccProfVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCustTmpltCSQL template = new BLDocumentationBLDBDAOHblCustTmpltCSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * House B/L의 고객의 템블릿 수정.
     * 
     * @param BkgNvoccProfVO vo
     * @exception DAOException
     */
    public void modifyHblCustTmplt(BkgNvoccProfVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCustTmpltUSQL template = new BLDocumentationBLDBDAOHblCustTmpltUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * House B/L의 고객의 템블릿 삭제.
     * 
     * @param List<BkgNvoccProfVO> deleteProfList
     * @exception DAOException
     */
    public void removeHblCustTmplt(List<BkgNvoccProfVO> deleteProfList) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int delCnt[] = null;
            if(deleteProfList.size() > 0){
                BLDocumentationBLDBDAOHblCustTmpltDSQL template = new BLDocumentationBLDBDAOHblCustTmpltDSQL();
                delCnt = sqlExe.executeBatch(template, deleteProfList, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     * House B/L의 CM 템블릿 생성.
     * 
     * @param BkgNvoccProfCntrMfVO vo
     * @exception DAOException
     */
    public void createHblCmTmplt(BkgNvoccProfCntrMfVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCmTmpltCSQL template = new BLDocumentationBLDBDAOHblCmTmpltCSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * House B/L의 CM 템블릿 수정.
     * 
     * @param BkgNvoccProfCntrMfVO vo
     * @exception DAOException
     */
    public void modifyHblCmTmplt(BkgNvoccProfCntrMfVO vo) throws DAOException {
      //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCmTmpltUSQL template = new BLDocumentationBLDBDAOHblCmTmpltUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * House B/L의 CM 템블릿 삭제.
     * 
     * @param List<BkgNvoccProfCntrMfVO> deleteProfCmList
     * @exception DAOException
     */
    public void removeHblCmTmplt(List<BkgNvoccProfCntrMfVO> deleteProfCmList) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            int delCnt[] = null;
            if(deleteProfCmList.size() > 0){
                BLDocumentationBLDBDAOHblCmTmpltDSQL template = new BLDocumentationBLDBDAOHblCmTmpltDSQL();
                delCnt = sqlExe.executeBatch(template, deleteProfCmList, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Empty Repo Booking의 containe 정보, B/L 정보를 insert update한다<br>
	 * 
     * @author		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
    public void addMtyBkgBlDoc(String bkgNo, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			param.put("bkg_no", bkgNo);
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOAddMtyBkgBlDocCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    


    /**
     * Empty Booking의 BL Desc를 조회한다.
     * 
     * @author 		KimByungKyu
     * @param  		BkgBlNoVO bkgBlNoVO
     * @return 		String[] 
     * @exception 	DAOException
     */
	public String[] searchMtyBlDesc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String[] strArray = null;		 
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

			 dbRowset = new SQLExecuter("DEFAULT").executeQuery(new BLDocumentationBLDBDAOSearchMtyBlDescRSQL(), param, velParam);

			 strArray = new String[dbRowset.getRowCount()];
			 int i = 0;
			while (dbRowset.next()) {
				strArray[i] = dbRowset.getString("MTY_BL_DESC");
				
				i++;
			}		

		 }catch(SQLException ex){
			 //log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }catch(Exception ex){
			 //log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }		 
		 return strArray;
	 }		    

    /**
     * Cntr가 Shipper's Own인지 확인
     * @author 		KimByungKyu
     * @param  		String cntrNo
     * @return 		boolean
     * @exception 	DAOException
     */
	public boolean searchMtySocCntrCheck(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isReturn = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchMtySocCntrCheckRSQL(), param, velParam);
			if(dbRowset.next()){
				if("Y".equals(dbRowset.getString("MTY_SOC_CNTR_CHECK"))){
					isReturn = true;
				}
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isReturn;
	}

    /**
     * Cntr가 이미 다른 Booking에 예약중인지 확인
     * @author 		KimByungKyu
     * @param  		String cntrNo
     * @param  		String bkgNo
     * @param  		String polCd
     * @param  		String vvd
     * @return 		String
     * @exception 	DAOException
     */
	public String searchMtyCntrReserve(String cntrNo, String bkgNo, String polCd, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			param.put("pol_cd", polCd);
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchMtyCntrReserveRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("BKG_NO");
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
     * Cntr의 상태를 확인
     * @author 		KimByungKyu
     * @param  		String cntrNo
     * @param       String bkgNo
     * @return 		MtyCntrStsVO
     * @exception 	DAOException
     */
    @SuppressWarnings("unchecked")
    public MtyCntrStsVO searchMtyCntrSts(String cntrNo, String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<MtyCntrStsVO> list = null;
        MtyCntrStsVO mtyCntrStsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("cntr_no", cntrNo);
        	param.put("bkg_no", bkgNo);
        	dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchMtyCntrStsRSQL(), param, velParam);
        	
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyCntrStsVO.class);
            if(list != null && list.size() > 0){
            	mtyCntrStsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mtyCntrStsVO;
    }	


	/**
	 * Empty Repo Booking의 containe 정보, B/L 정보를 insert update한다<br>
     * @author		KimByungKyu
	 * @param 		BkgContainerVO bkgContainerVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
    public void addMtyBkgContainer(BkgContainerVO bkgContainerVO, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {			
        	
			if(bkgContainerVO != null){
				Map<String, String> mapVO = bkgContainerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd", account.getOfc_cd());
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOAddMtyBkgContainerCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     


	/**
	 * Empty Repo Booking의 containe 정보를 update한다<br>
     * @author		KimByungKyu
	 * @param 		BkgContainerVO bkgContainerVO
	 * @exception 	DAOException
	 */
    public void modifyMtyBkgContainer(BkgContainerVO bkgContainerVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {			
        	
			if(bkgContainerVO != null){
				Map<String, String> mapVO = bkgContainerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyMtyBkgContainerUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }         
    
    /**
     * HblBkgInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return HblBkgInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public HblBkgInfoVO searchBkgInfoForHbl(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        HblBkgInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblBkgInfoRSQL template = new BLDocumentationBLDBDAOHblBkgInfoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<HblBkgInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, HblBkgInfoVO.class);
            if(list.size()>0){
                rsVO = list.get(0);
            }else{
                rsVO = new HblBkgInfoVO();
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * Canada 경유 유무에 대한 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @exception DAOException
     */
    public String searchCanadaFlob(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        String canFlg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOCanadaFlagRSQL template = new BLDocumentationBLDBDAOCanadaFlagRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                canFlg = "Y";
            }else{
                canFlg = "N";
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return canFlg;
    }

    /**
     * HblDtlInfoVO 모델에 대한 데이타 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<HblDtlInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HblDtlInfoVO> searchHblDtlInfoVOs(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<HblDtlInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            mapVO.put("usr_id", (bkgBlNoVO.getIbflag()==null ? "" : bkgBlNoVO.getIbflag()));
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblDtlInfoRSQL template = new BLDocumentationBLDBDAOHblDtlInfoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, HblDtlInfoVO.class);
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
     *  HblCntrVO 모델에 대한 데이타 조회.
     *  
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<HblCntrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HblCntrVO> searchHblCntrVOs(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<HblCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCntrRSQL template = new BLDocumentationBLDBDAOHblCntrRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, HblCntrVO.class);
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
     * BkgCntrMfDescVO 모델에 대한 데이타 조회.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgCntrMfDescVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgCntrMfDescVO> searchBkgCntrMfDescVOs(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgCntrMfDescVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCntrMfDescRSQL template = new BLDocumentationBLDBDAOHblCntrMfDescRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCntrMfDescVO.class);
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
     * House B/L 수정.
     * 
     * @param BkgHblVO bkgHblVO
     * @param String caFlg 
     * @exception DAOException
     */
    public void manageHbl(BkgHblVO bkgHblVO, String caFlg) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = bkgHblVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO); 

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblUSQL template = new BLDocumentationBLDBDAOHblUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    /**
     * House B/L 삭제.
     * 
     * @param List<BkgHblVO> voList
     * @param String caFlg 
     * @exception DAOException
     */
    public void removeHbls(List<BkgHblVO> voList, String caFlg) throws DAOException {
        int rsCnt[] = null;
        try {
            
            Map<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("ca_flg", caFlg);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BLDocumentationBLDBDAOHblDtlInfoDSQL template = new BLDocumentationBLDBDAOHblDtlInfoDSQL();
                rsCnt = sqlExe.executeBatch(template, voList, velParam);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Manifest 입력.
     * 
     * @param List<BkgCntrMfDescVO> voList
     * @exception DAOException
     */
    public void addCms(List<BkgCntrMfDescVO> voList) throws DAOException {
        int rsCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BLDocumentationCMDBDAOCmVOCSQL template = new BLDocumentationCMDBDAOCmVOCSQL();
                rsCnt = sqlExe.executeBatch(template, voList, null);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * Container Manifest 수정.
     * 
     * @param List<BkgCntrMfDescVO> voList
     * @exception DAOException
     */
    public void modifyCms(List<BkgCntrMfDescVO> voList) throws DAOException {
        int rsCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BLDocumentationCMDBDAOCmVOUSQL template = new BLDocumentationCMDBDAOCmVOUSQL();
                rsCnt = sqlExe.executeBatch(template, voList, null);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container Manifest 삭제.
     * 
     * @param List<BkgCntrMfDescVO> voList
     * @exception DAOException
     */
    public void removeCms(List<BkgCntrMfDescVO> voList) throws DAOException {
        int rsCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BLDocumentationCMDBDAOCmVODSQL template = new BLDocumentationCMDBDAOCmVODSQL();
                rsCnt = sqlExe.executeBatch(template, voList, null);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * House B/L의 고객 수정.
     * 
     * @param BkgHblCustVO bkgHblCustVO
     * @param String caFlg 
     * @exception DAOException
     */
    public void manageHblCust(BkgHblCustVO bkgHblCustVO, String caFlg)  throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = bkgHblCustVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCustUSQL template = new BLDocumentationBLDBDAOHblCustUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * House B/L의 고객 삭제.
     * 
     * @param List<BkgHblCustVO> voList
     * @param String caFlg 
     * @exception DAOException
     */
    public void removeHblCusts(List<BkgHblCustVO> voList, String caFlg) throws DAOException {
        int rsCnt[] = null;
        try {
            
            Map<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("ca_flg", caFlg);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BLDocumentationBLDBDAOHblCustDSQL template = new BLDocumentationBLDBDAOHblCustDSQL();
                rsCnt = sqlExe.executeBatch(template, voList, velParam);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * AMS Ref. Number의 유효성 검사.
     * 
     * @param HblDtlInfoVO hblDtlInfoVO
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String validateCntrMfNo(HblDtlInfoVO hblDtlInfoVO, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String mfNo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = hblDtlInfoVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblMfNoRSQL template = new BLDocumentationBLDBDAOHblMfNoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                mfNo = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mfNo;
    }

	/**
	 * bkg_bl_doc에 ORG_CNT_NM column을 update한다<br>
	 * 
     * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String orgCntNm
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
    public void modifyBkgBlDocByCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}        	
			param.put("org_cnt_nm", orgCntNm);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyBkgBlDocByCustUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * MfNoVO 모델에 해당하는 유효성 검사.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return MfNoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public MfNoVO validateMfNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        MfNoVO rsVo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOMfNoRSQL template = new BLDocumentationBLDBDAOMfNoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<MfNoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, MfNoVO.class);
            if(list.size() > 0) {
                rsVo = list.get(0);
            } else {
                rsVo = new MfNoVO();
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVo; 
    }
    
    /**
     * MndTsSyFlg 조회.
     * 
     * @param String bkgNo
     * @return String
     * @exception DAOException
     */
    public String searchMndTsSyFlg(String bkgNo) throws DAOException {
    	// input_text
		//String output_text = null;
   
        String syFlg = null;
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
			BLDocumentationBLDBDAOSearchMndTsSyFlgRSQL template = new BLDocumentationBLDBDAOSearchMndTsSyFlgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				syFlg = dbRowset.getString("OUTPUT_TEXT");
			} else {
				syFlg = "";
			}
		
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return syFlg;
    } 

    /**
     * MF Number 최대값 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String searchMaxMfNo(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        String mfNo = null;
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

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblMaxMfNoRSQL template = new BLDocumentationBLDBDAOHblMaxMfNoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                mfNo = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mfNo;
    } 
    
    /**
     * MF Number 최대값 검증.
     * 
     * @param String mfNo
     * @return String
     * @exception DAOException
     */
    public String checkMfNoDup(String mfNo) throws DAOException {
        DBRowSet dbRowset = null;
        String mfDupYn = "N";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("mf_no", mfNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOCheckMfNoDupRSQL template = new BLDocumentationBLDBDAOCheckMfNoDupRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
            	mfDupYn = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return mfDupYn;
    }
    
    /**
     * Nvocc File Number 수정.
     * 
     * @param String bkgNo
     * @param String hblSeq
     * @param String nvoccFileNo
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyNvoccFileNo(String bkgNo, String hblSeq, String nvoccFileNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("hbl_seq", hblSeq);
            mapVO.put("cntr_mf_no", nvoccFileNo);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAONvoccFileNoUSQL template = new BLDocumentationBLDBDAONvoccFileNoUSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
	/**
	 * HBL Count를 수정한다.<br>
	 * 
	 * @param int hblCount
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
    public void modifyHblCount(int hblCount, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}        	
			param.put("hbl_count", hblCount);
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyHblCountUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * BlCopyOutVO 를 조회한다.<br>
     * @param String bkgNo
     * @return BlCopyOutVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public BlCopyOutVO searchForCopyBl(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BlCopyOutVO rsVo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOSearchForCopyBlRSQL template = new BLDocumentationBLDBDAOSearchForCopyBlRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<BlCopyOutVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlCopyOutVO.class);
            if(null!=list && 0<list.size()) {
                rsVo = list.get(0);
            } else {
            	rsVo = new BlCopyOutVO();
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVo;
    }

    /**
     * shprCd 를 조회한다.<br>
     * @param String bkgNo
     * @return String
     * @exception DAOException
     */
	public String searchShprCd(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        String shprCd = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgNo);
            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOSearchShprCdRSQL template = new BLDocumentationBLDBDAOSearchShprCdRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if (dbRowset.next()) {
            	shprCd = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return shprCd;
	}

	/**
	 * BKG_BL_DOC의 PCK_CMDT_DESC, CNTR_CMDT_DESC or ORG_CNT_NM 의 정보를 UPDATE한다.<br>
	 * @param 		BlCopyInVO blCopyInVo
	 * @param       SignOnUserAccount account
	 * @return		int
	 * @exception 	DAOException
	 */
    public int modifyBlDocByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyBlDocByBlCopyUSQL(), param, velParam);
			//if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

	/**
	 * BKG_BL_MK_DESC의 MK_DESC or CMDT_DESC 의 정보를 UPDATE한다.<br>
	 * @param 		BlCopyInVO blCopyInVo
	 * @param       SignOnUserAccount account
	 * @return		int
	 * @exception 	DAOException
	 */
    public int modifyMndByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int updCnt = 0;
        try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyMndByBlCopyUSQL(), param, velParam);
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

	/**
	 * BKG_BL_MK_DESC의 MK_DESC or CMDT_DESC 의 정보를 INSERT한다.<br>
	 * @param 		BlCopyInVO blCopyInVo
	 * @param       SignOnUserAccount account
	 * @return		int
	 * @exception 	DAOException
	 */
    public int addMndByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int insCnt = 0;
        try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOAddMndByBlCopyCSQL(), param, velParam);
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return insCnt;
    }

    /**
     * BKG의 Issue/Release 상태등을 조회한다.<br>
     * @param String bkgNo
     * @return BlStatusVO
     * @exception DAOException
     */
	public BlStatusVO searchBlSts(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BlStatusVO blStatusVO = null;
        String oblIssFlg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgNo);
            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOSearchBlStsRSQL template = new BLDocumentationBLDBDAOSearchBlStsRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if (dbRowset.next()) {
            	oblIssFlg = dbRowset.getString(1);
            	blStatusVO = new BlStatusVO();
            	blStatusVO.setOblIssFlg(oblIssFlg);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return blStatusVO;
	}

	/**
	 * BKG_BL_DOC의 Qty값들을 Sum하여 조회한다.(ESM_BKG_0076)<br>
	 * 
	 * @author 	Jun Yong Jin
	 * @param 	BkgBlNoVO[] sourceBkg 
	 * @param 	BkgBlNoVO targetBkg 
	 * @return 	WgtPkgMeasVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public WgtPkgMeasVO searchPckMeasWgtSi(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg) throws DAOException {
		DBRowSet dbRowset = null;
		List<WgtPkgMeasVO> list = null;
		WgtPkgMeasVO wgtPkgMeasVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> bkgNoString = new ArrayList();

		try{
			if(sourceBkg != null){
				for(int i=0;i<sourceBkg.length;i++) {
					bkgNoString.add(sourceBkg[i].getBkgNo());
				}
				bkgNoString.add(targetBkg.getBkgNo());
			}
			velParam.put("bkg_no_list", bkgNoString);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOsearchPkcMeasWgtSiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, WgtPkgMeasVO .class);
			if(list != null && list.size() > 0){
				wgtPkgMeasVO = list.get(0);
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return wgtPkgMeasVO;
	}	

	/**
     * targetBkg의 BKG_BL_DOC Qty값들을 sourceBkg의 값과 합한다.(ESM_BKG_0076)<br>
     * @author Jun Yong Jin
	 * @param WgtPkgMeasVO wgtPkgMeasVO
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
    public void modifyPkcMeasWgt(WgtPkgMeasVO wgtPkgMeasVO, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			if(wgtPkgMeasVO != null){
				Map<String, String> mapVO = wgtPkgMeasVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("bkg_no", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOmodifyPkcMeasWgtUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * bkg_bl_doc의 CA 시작 정보(C/A No, C/A User, office, date)를 수정함<br>
     *
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyCaStart(BkgBlNoVO vo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			velParam.putAll(mapVO);
			velParam.put("usr_id", account.getUsr_id());
			velParam.put("ofc_cd", account.getOfc_cd());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyCaStartUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * copyTypeCd 에 따라, BKG_BL_DOC/BKG_BL_DOC_HIS 에 copy함
	 * 
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createBlDocCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateBlDocCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
     * BKG_BL_DOC_HIS를 BKG_BL_DOC 에 update함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void modifyBlDocCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyBlDocCAUSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * copyTypeCd에 따라, BKG_BL_MK_DESC/BKG_BL_MK_DESC_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeMkDescCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveMkDescCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd에 따라, BKG_HBL_CUST/BKG_HBL_CUST_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeHblCustCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveHblCustCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
     * copyTypeCd에 따라, BKG_HBL/BKG_HBL_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeHblCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveHblCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
     * copyTypeCd에 따라, BKG_XPT_IMP_LIC/BKG_XPT_IMP_LIC_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeLicCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveLicCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd에 따라, BKG_CNTR_SEAL_NO/BKG_CNTR_SEAL_NO_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeCntrSealCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveCntrSealCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd에 따라, BKG_CNTR_MF_DESC/BKG_CNTR_MF_DESC_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeCmCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveCmCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd에 따라, BKG_CONTAINER/BKG_CNTR_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeCntrCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveCntrCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd에 따라, BKG_BL_DOC/BKG_BL_DOC_HIS 를 delete함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeBlDocCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveBlDocCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
     * copyTypeCd 에 따라, BKG_BL_MK_DESC/BKG_BL_MK_DESC_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createMkDescCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateMkDescCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_HBL/BKG_HBL_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createHblCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateHblCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * copyTypeCd 에 따라, BKG_HBL_CUST/BKG_HBL_CUST_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createHblCustCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateHblCustCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * copyTypeCd 에 따라, BKG_XPT_IMP_LIC/BKG_XPT_IMP_LIC_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createLicCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateLicCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * copyTypeCd 에 따라, BKG_CONTAINER/BKG_CNTR_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createCntrCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateCntrCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * copyTypeCd 에 따라, BKG_CNTR_MF_DESC/BKG_CNTR_MF_DESC_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createCmCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateCmCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * copyTypeCd 에 따라, BKG_CNTR_SEAL_NO/BKG_CNTR_SEAL_NO_HIS 에 copy함
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createCntrSealCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateCntrSealCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * BKG_BL_DOC을 update함
     * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception DAOException
	 */
	public void modifyCaComplete(BkgBlNoVO vo) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyCaCompleteUSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Container Cycle 정보를 조회한다.<br>
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		String cntrNo
	 * @return 		MtyCntrCycVO
	 * @exception 	DAOException
	 */
    @SuppressWarnings("unchecked")
    public MtyCntrCycVO searchMtyCntrCyc(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyCntrCycVO> list = null;
		MtyCntrCycVO mtyCntrCycVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchMtyCntrCycRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyCntrCycVO .class);
			if(list != null && list.size() > 0){
				mtyCntrCycVO = list.get(0);
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mtyCntrCycVO;
    }


	/**
	 *  Empty Container 삭제.<br>
	 * @author 		KimByungKyu
	 * @param String cntrNo
	 * @param BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void removeMtyCntr(String cntrNo, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("cntr_no", cntrNo);
		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveMtyCntrDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 *  Mnd 삭제.<br>
	 * @author 	KimByungKyu
	 * @param String bkgNo
	 * @exception 	DAOException
	 */
	public void removeMnd(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveMndDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	
	/**
	 *  Empty Container 삭제.<br>
	 * @author 		KimByungKyu
	 * @param 		String splitBkgNo
	 * @param 		String cntrNo
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void copyMtyCntrToMst(String splitBkgNo, String cntrNo, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("cntr_no", cntrNo);
			param.put("split_bkg_no", splitBkgNo);
			param.put("usr_id", account.getUsr_id());
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCopyMtyCntrToMstCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_bl_doc 테이블 수정<br>
	 * 
	 * @param BkgCoffTmVO bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgCoffTm(BkgCoffTmVO bkgCoffTmVO,SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCoffTmVO != null) {
				Map<String, String> mapVO = bkgCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBkgCloseUSQL(), param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BL DOC 정보 수정
	 * 
	 * @param BkgBlDocVO bkgBlDocVO
	 * @throws DAOException
	 */
	public void modifyBlDoc(BkgBlDocVO bkgBlDocVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgBlDocVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBlDocUSQL(), param, velParam);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	  *  Booking Close Change Flag 변경.(ESM_BKG_0079_01)<br>
	  *  
	  * @author   KimByungKyu
	  * @param   BkgBlNoVO bkgBlNoVO
	  * @param   SignOnUserAccount account
	  * @exception  DAOException
	  */
	 public void modifyBkgCloseChange(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		  //query parameter
		  Map<String, Object> param = new HashMap<String, Object>();
		  //velocity parameter
		  Map<String, Object> velParam = new HashMap<String, Object>();
		  try{
			  if(bkgBlNoVO != null){
				  Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
				  param.putAll(mapVO);
				  velParam.putAll(mapVO);
			  }
			  param.put("upd_usr_id", account.getUsr_id());
			  SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			  int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyBkgCloseChangeUSQL(), param,velParam);
			  if(updCnt == Statement.EXECUTE_FAILED)
				  throw new DAOException("Fail to modify SQL");
			
		  }catch(SQLException se){
			  log.error(se.getMessage(),se);
			  throw new DAOException(new ErrorHandler(se).getMessage(), se);
		  }catch(Exception ex){
			  log.error(ex.getMessage(),ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		  }
	 }
		/**
		 * Booking Close 여부 판단. (ESM_BKG_0079_01) -> createBooking<br>
		 * 
		 * @author		KimByungKyu
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		String
		 * @exception 	DAOException
		 */
		public String searchBkgClose(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnString = "";
			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchBkgCloseRSQL(), param, velParam);
				if(dbRowset.next()){
					rtnString = dbRowset.getString("BKG_CLZ_FLG");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return rtnString;
		}
		
		/**
		 * 신규 입력된 인도네시아 세관 전송대상 Manifest 정보를 저장한다.<br>
		 * 
		 * @param IndonesiaManifestModificationVO indonesiaManifestModificationVO
		 * @throws DAOException
		 */
		public void addManifest(IndonesiaManifestModificationVO indonesiaManifestModificationVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = indonesiaManifestModificationVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOaddManifestCSQL(), param, velParam);
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
		 * 수정된 인도네시아 세관 전송대상 Manifest 정보를 저장한다.<br>
		 * 
		 * @param IndonesiaManifestModificationVO indonesiaManifestModificationVO
		 * @param SignOnUserAccount account
		 * @return int
		 * @throws DAOException
		 */
		public int modifyManifest(IndonesiaManifestModificationVO indonesiaManifestModificationVO, SignOnUserAccount account) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = indonesiaManifestModificationVO.getColumnValues();
				
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);	
				log.info("####################");
				log.info(param);
				log.info("####################");
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOmodifyManifestUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}	
		
		/**
		 * 인도네시아 세관 전송대상에서 제외할 Manifest 정보를 삭제한다.<br>
		 * 
		 * @param IndonesiaManifestModificationVO indonesiaManifestModificationVO
		 * @throws DAOException
		 */
		public void removeManifest(IndonesiaManifestModificationVO indonesiaManifestModificationVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = indonesiaManifestModificationVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOremoveManifestDSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

	     /**
	      * Search HTS Flag by Bkg
	      * 
	      * @param BkgBlNoVO bkgBlNoVO
	      * @return String
	      */
	     public String searchHTSFlag(BkgBlNoVO bkgBlNoVO) throws DAOException {
	         DBRowSet dbRowset = null;
	         String rsStr = null;
	         //query parameter
	         Map<String, Object> param = new HashMap<String, Object>();
	         //velocity parameter
	         Map<String, Object> velParam = new HashMap<String, Object>();

	         try{
	             Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
	             
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
	 	 * BKG_CONTAINER   : Vessesl Schedule B/L Data Release Log를 갱신한다.(ESM_BKG_0596)<br>
	 	 * @param String bkgNo
	 	 * @param String flag
	 	 * @param String usrId
	 	 * @return int
	 	 * @throws DAOException
	 	 */
	 	public int modifyCntrCFM(String bkgNo, String flag, String usrId) throws DAOException, Exception {
	 		// query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		// velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 		int result = 0;
	 		try {
	 			param.put("bkg_no",bkgNo);
				param.put("ibflag", flag);
				param.put("upd_usr_id", usrId);
				
	 			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	 			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyCntrCFMUSQL(), param, velParam);
	 			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
	 		} catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(),se);
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	 		}
	 		return result;
	 	}

	 	/**
	 	 * BKG_BL_DOC  : Vessesl Schedule B/L Data Release Log를 갱신한다.(ESM_BKG_0596)<br>
	 	 * @param String bkgNo
	 	 * @param String flag
	 	 * @param String hisFlg
	 	 * @param String usrId
	 	 * @return int
	 	 * @throws DAOException
	 	 */
	 	public int modifyBKGBDR(String bkgNo, String flag, String hisFlg, String usrId) throws DAOException, Exception {
	 		// query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		// velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 		int result = 0;
	 		try {
	 			param.put("bkg_no",bkgNo);
				param.put("ibflag", flag);
				param.put("hisFlg", hisFlg);
				param.put("upd_usr_id", usrId);
				velParam.put("bkg_no",bkgNo);
				velParam.put("ibflag", flag);
				velParam.put("hisFlg", hisFlg);
				velParam.put("upd_usr_id", usrId);
				
	 			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	 			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBKGBDRUSQL(), param, velParam);

	 			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
	 		} catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(),se);
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	 		}
	 		return result;
	 	}
	 	
	 	/**
	 	 * BKG_BL_DOC  : Vessesl Schedule B/L Data Release Log를 갱신한다.(ESM_BKG_0596_01)<br>
	 	 * @param String bkgNo
	 	 * @param String flag
	 	 * @param String hisFlg
	 	 * @param String usrId
	 	 * @return int
	 	 * @throws DAOException
	 	 */
	 	public int modifyBKGBDRRHQ(String bkgNo, String flag, String hisFlg, String usrId, String bdrRsnCd, String bdrRsnRmk) throws DAOException, Exception {
	 		// query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		// velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 		int result = 0;
	 		try {
	 			param.put("bkg_no",bkgNo);
				param.put("ibflag", flag);
				param.put("hisFlg", hisFlg);
				param.put("upd_usr_id", usrId);
				param.put("bdr_rsn_cd",bdrRsnCd);
				param.put("bdr_rsn_rmk",bdrRsnRmk);
				velParam.put("bkg_no",bkgNo);
				velParam.put("ibflag", flag);
				velParam.put("hisFlg", hisFlg);
				velParam.put("upd_usr_id", usrId);
				velParam.put("bdr_rsn_cd",bdrRsnCd);
				velParam.put("bdr_rsn_rmk",bdrRsnRmk);
				
	 			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	 			result = sqlExe.executeUpdate((ISQLTemplate) new BLDocumentationBLDBDAOmodifyBKGBDRRHQUSQL(), param, velParam);

	 			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
	 		} catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(),se);
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	 		}
	 		return result;
	 	}
	 	
    /**
     * eBkg에서 House B/L 수정.
     * 
     * @param BkgHblVO bkgHblVO
     * @param String caFlg 
     * @exception DAOException
     */
	public void manageHblByXter(BkgHblVO bkgHblVO, String caFlg) throws DAOException {
		   // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = bkgHblVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO); 

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblByXterUSQL template = new BLDocumentationBLDBDAOHblByXterUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }		
	}

    /**
     * eBkg에서 House B/L의 고객 수정.
     * 
     * @param BkgHblCustVO bkgHblCustVO
     * @param String caFlg 
     * @exception DAOException
     */
    public void manageHblCustByXter(BkgHblCustVO bkgHblCustVO, String caFlg)  throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = bkgHblCustVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOHblCustByXterUSQL template = new BLDocumentationBLDBDAOHblCustByXterUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
            // log.debug("** executeUpdate : " + result);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    /**
     * eBkg에서 Export Licens Number(US, CA, MX, KR)를 삭제한다.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @exception DAOException
     */
	public void removeXptLicNoByXter(BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveXptLicNoByXterDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
    /**
     * eBkg에서 Export Licens Number(US, CA, MX, KR)를 저장한다.
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param AlpsXptImpLicListVO alpsXptImpLicListVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void addXptLicNoByXter(BkgBlNoVO bkgBlNoVO, AlpsXptImpLicListVO alpsXptImpLicListVO, SignOnUserAccount account) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			Map<String, String> mapVO = alpsXptImpLicListVO.getColumnValues();			
			param.putAll(mapVO);
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("ca_flg", bkgBlNoVO.getCaFlg());
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOAddXptLicNoByXterCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }		
	}
	
	/**
     * Mark And Description 수정.
     * 
     * @param BkgBlMkDescVO blMkDescVO
     * @param String oldActCustCd
     * @param String newActCustCd
     * @param String oldActCustNm
     * @param String newActCustNm
     * @return int
     * @exception DAOException
     */
    public int modifyMndByCust(BkgBlMkDescVO blMkDescVO, String oldActCustCd, String newActCustCd, String oldActCustNm, String newActCustNm) throws DAOException {
        int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            mapVO.put("old_act_cust_cd", oldActCustCd);
            mapVO.put("new_act_cust_cd", newActCustCd);
            mapVO.put("old_act_cust_nm", oldActCustNm);
            mapVO.put("new_act_cust_nm", newActCustNm);
            mapVO.put("ca_flg", blMkDescVO.getBkgNoSplit());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOModifyMndByCustUSQL template = new BLDocumentationBLDBDAOModifyMndByCustUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
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
     *  Mark And Description 입력.
     *  
     * @param BkgBlMkDescVO blMkDescVO
     * @exception DAOException
     */
    public void addMndByCust(BkgBlMkDescVO blMkDescVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOAddMndByCustCSQL template = new BLDocumentationBLDBDAOAddMndByCustCSQL();
            sqlExe.executeUpdate(template, param, velParam);
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }
	/**
	 * BL rider 를 저장 한다.
	 * @param List<BlRiderVO> insertVoList
	 * @param String use_id
	 * @param String ofc_cd
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void addBlRider(List<BlRiderVO> insertVoList, String use_id, String ofc_cd, String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = insertVoList.size();
        int insCnt = 0;
        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BlRiderVO> list = insertVoList.iterator();
				param.put("bkg_no", bkgNo);
				param.put("ofc_cd", ofc_cd);
				param.put("usr_id", use_id);
	        	while(list.hasNext()){
	        		BlRiderVO blRiderVO = (BlRiderVO)list.next();
					Map<String, String> mapVO = blRiderVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOManageBlRiderCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
    /**
     * shprCd 를 조회한다.<br>
     * @param String bkgNo
     * @return String
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public BlAppWordVO searchBlAppWord(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BlAppWordVO rsVo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgNo);
            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOSearchBlAppWordRSQL template = new BLDocumentationBLDBDAOSearchBlAppWordRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<BlAppWordVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlAppWordVO.class);
            if(null!=list && 0<list.size()) {
                rsVo = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVo;
	}
    /**
     * SOC(SHIPPER’S OWN CONTAINER) Flag 조회.
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String searchSocFlg(String bkgNo, String caFlg) throws DAOException {
   
        String SocFlg = null;
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
			BLDocumentationBLDBDAOSearchSocFlgRSQL template = new BLDocumentationBLDBDAOSearchSocFlgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			if (dbRowset.next()) {
				SocFlg = dbRowset.getString("SOC_FLG");
			} else {
				SocFlg = "";
			}
			
        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return SocFlg;
    } 

	/**
     * copyTypeCd에 따라, BKG_CNTR_MF_DESC_DTL/BKG_CNTR_MF_DESC_DTL_HIS 를 delete함
     * @author Ryu Dae Young
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void removeCmDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAORemoveCmDtlCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd 에 따라, BKG_CNTR_MF_DESC_DTL/BKG_CNTR_MF_DESC_DTL_HIS 에 copy함
     * @author Ryu Dae young
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createCmDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOCreateCmDtlCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
    /**
     * Mark And Description 수정.
     * 
     * 
     * @param BkgBlMkDescVO blMkDescVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int modifyMndCmdtDesc(BkgBlMkDescVO blMkDescVO, String caFlg) throws DAOException {
        int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            //param.put("mk_desc", blMkDescVO.getCrLfTabOffMkDesc());
            param.put("cmdt_desc", blMkDescVO.getCmdtDesc());

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOModifyCmdtDescKHPNHUSQL template = new BLDocumentationBLDBDAOModifyCmdtDescKHPNHUSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
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
     * Mark And Description 수정.
     * Last VVD POL이 VNSGN Y2 이고 POD 가 KHPNH Y4 인 모든 Booking 에 문구 삽입
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public BkgBlMkDescVO searchMndCmdtDesc(String bkgNo, String caFlg) throws DAOException {
    	BkgBlMkDescVO blMkDescOutVO = null;
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
            BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL template = new BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL();
            DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			List<BkgBlMkDescVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlMkDescVO.class);
	            if(list.size() > 0) {
	            	blMkDescOutVO = list.get(0);
	            }    
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return blMkDescOutVO;
    }
    
    
    /**
     * Mark And Description 수정.
     * 
     * 
     * @param BkgBlMkDescVO blMkDescVO
     * @param String caFlg
     * @return int
     * @exception DAOException
     */
    public int addMndCmdtDesc(BkgBlMkDescVO blMkDescVO, String caFlg) throws DAOException {
        int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = blMkDescVO.getColumnValues();
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLDocumentationBLDBDAOAddCmdtDescKHPNHCSQL template = new BLDocumentationBLDBDAOAddCmdtDescKHPNHCSQL();
            result = sqlExe.executeUpdate(template, param, velParam);
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
	 * Booking Vvd 정보를 조회한다.(ESM_BKG_0079_06)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param       String caFlg
	 * @return 		List<VslSkdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslSkdVO> searchVvdSkdForTsRouteKNPNH(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
//			if(bkgBlNoVO != null){
			   Map<String, String> mapVO = new HashMap<String, String>();
			
            	mapVO.put("ca_flg", caFlg);
            	mapVO.put("bkg_no", bkgNo);
            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
//			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchRouteKNPNHRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);
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
	     * RVIS_CNTR_CUST_TP_CD 조회.
	     * 
	     * @param String bkgNo
	     * @param String caFlg
	     * @return String
	     * @exception DAOException
	     */
	    public String searchRvisCntrCustTpCd(String bkgNo, String caFlg) throws DAOException {
	   
	        String custFlg = null;
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
				BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL template = new BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					custFlg = dbRowset.getString("RVIS_CNTR_CUST_TP_CD");
				} else {
					custFlg = "N";
				}
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return custFlg;
	    } 

	 /**
	     * BKG Interface Management 조회한다. 
	     * 
	     * @param BkgIfManageInVO bkgIfManageInVO
	     * @return List<BkgIfManageListVO>
	     * @exception DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<BkgIfManageListVO> searchBkgIfList(BkgIfManageInVO bkgIfManageInVO) throws DAOException {
	    	List<BkgIfManageListVO> bkgIfManageListVOs = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = bkgIfManageInVO.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter executer = new SQLExecuter("DEFAULT");
	            BLDocumentationBLDBDAOSearchBkgIfListRSQL template = new BLDocumentationBLDBDAOSearchBkgIfListRSQL();
	            DBRowSet dbRowset = executer.executeQuery(template, param, velParam);
	            bkgIfManageListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgIfManageListVO.class);
	        } catch(SQLException ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return bkgIfManageListVOs;
	    }
	    
	    /**
		 * 301, 310 EDI를 전송할 Booking 리스트를 조회한다.(ESM_BKG_0702)<br>
		 *
		 * @author 
		 * @param BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO
		 * @param String msgTypeCd
		 * @return List<BkgIfManagerEdiVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgIfManagerEdiVO> searchBkgIfList01(BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO, String msgTypeCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgIfManagerEdiVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgIfManagerEdiInputVO != null){
					if (!JSPUtil.getNull(bkgIfManagerEdiInputVO.getBkgNo()).equals("")) {
						bkgIfManagerEdiInputVO.setBkgNo("'" + bkgIfManagerEdiInputVO.getBkgNo().replaceAll(",", "','") + "'");
					}
					Map<String, String> mapVO = bkgIfManagerEdiInputVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				velParam.put("msg_type_cd", msgTypeCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchBkgIfList01RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgIfManagerEdiVO .class);
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
	     * P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회
	     * @param String bkgNo
	     * @return String
	     * @throws DAOException
	     */
	    public String searchPoExist(String bkgNo) throws DAOException {
	   
	        String poNm = null;
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
				BLDocumentationBLDBDAOSearchPoExistRSQL template = new BLDocumentationBLDBDAOSearchPoExistRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				if (dbRowset.next()) {
					poNm = dbRowset.getString("PATH_ITEM");
				} else {
					poNm = "";
				}
			
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return poNm;
	    }

	    
	    /**
	     * DZ인지역의 CNTR타입을 구분한다.
	     * @param String bkgNo
	     * @param String caFlg
	     * @return String
	     * @throws DAOException
	     */
	    public String searchCntrTpForDZ(String bkgNo, String caFlg) throws DAOException {
	    	   
	        String cntrTp = null;
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
				BLDocumentationBLDBDAOSearchCntrTpForDZRSQL template = new BLDocumentationBLDBDAOSearchCntrTpForDZRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					cntrTp = dbRowset.getString("CNTR_TP");
				} else {
					cntrTp = "";
				}
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return cntrTp;
	    } 
	    
	    
	    /**
	     * auto-clause의 effective date를 구분한다.
	     * @param String bkgNo
	     * @param String div
	     * @param String caFlg
	     * @return String
	     * @throws DAOException
	     */
	    public String searchEffDtDiv(String bkgNo, String div, String caFlg) throws DAOException {
	    	   
	        String effDtDiv = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = new HashMap<String, String>();
	            mapVO.put("bkg_no", bkgNo);
	            mapVO.put("div", div);
	            mapVO.put("ca_flg", caFlg);
				
	            param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				BLDocumentationBLDBDAOSearchEffDtDivRSQL template = new BLDocumentationBLDBDAOSearchEffDtDivRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					effDtDiv = dbRowset.getString("DIV_FLG");
				} else {
					effDtDiv = "N";
				}
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return effDtDiv;
	    } 

		
	    /**
	     * 위험화물 문구가 포함된 BKG의 문구중 가장 등급이 높은 문구를 조회한다.
	     * @param BkgDescVO bkgDescVO
	     * @return String[]
	     * @throws DAOException
	     */
	    public String[] searchkeywordByBkg(BkgDescVO bkgDescVO) throws DAOException {
	        String[] keyword = null;
	        DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = bkgDescVO.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
	            if(bkgDescVO !=null && bkgDescVO.getCmdtDesc().length()>3999){
	            	dbRowset = new SQLExecuter("DEFAULT").executeQuery(new BLDocumentationBLDBDAOsearchkeywordByBkg2RSQL(), param, velParam);
	            }else{
	            	dbRowset = new SQLExecuter("DEFAULT").executeQuery(new BLDocumentationBLDBDAOsearchkeywordByBkgRSQL(), param, velParam);
	            }
	            keyword = new String[dbRowset.getRowCount()];
				 int i = 0;
				while (dbRowset.next()) {
					keyword[i] = dbRowset.getString("NON_DCGO_KW_SEQ");
					i++;
				}	
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return keyword;
	    } 
	    /**
	     * POL이 나이지리아일 경우 EXS 데이터 존재여부
	     * POD가 나이지리아일 경우 ENS 데이터 존재여부
	     * 
	     * @param String bkgNo
	     * @return String
	     * @exception DAOException
	     */
	    public String []chkNgExsEnsNo(String bkgNo) throws DAOException {
	        DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        String arrData [];
	        try {
//	            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
//	            
//	            param.putAll(mapVO);
	        	param.put("bkg_no", bkgNo);
//	        	param.put("io_bnd_cd",iOBndCd);
	            velParam.put("bkg_no",bkgNo);
//	            velParam.put("io_bnd_cd",iOBndCd);

	            SQLExecuter exec = new SQLExecuter("DEFAULT");
	            BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL template = new BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL();
	            dbRowset = exec.executeQuery(template, param, velParam);
	            arrData = new String[5];
				while (dbRowset.next()) {
					arrData[0] = dbRowset.getString(dbRowset.getMetaData().getColumnName(1));	
					arrData[1] = dbRowset.getString(dbRowset.getMetaData().getColumnName(2));	
					arrData[2] = dbRowset.getString(dbRowset.getMetaData().getColumnName(3));	
					arrData[3] = dbRowset.getString(dbRowset.getMetaData().getColumnName(4));
					arrData[4] = dbRowset.getString(dbRowset.getMetaData().getColumnName(5));
				}		
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return arrData;
	    }
	    
	    /**
	     * POL이 토고일 경우 ECTN 데이터 존재여부
	     * POD가 토고일 경우 ECTN 데이터 존재여부
	     * 
	     * @param String bkgNo
	     * @return String
	     * @exception DAOException
	     */
	    public String []chkTgEctnNo(String bkgNo) throws DAOException {
	        DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        String arrData [];
	        try {
//	            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
//	            
//	            param.putAll(mapVO);
	        	param.put("bkg_no", bkgNo);
//	        	param.put("io_bnd_cd",iOBndCd);
	            velParam.put("bkg_no",bkgNo);
//	            velParam.put("io_bnd_cd",iOBndCd);

	            SQLExecuter exec = new SQLExecuter("DEFAULT");
	            BLDocumentationBLDBDAOSearchTgEctnNoRSQL template = new BLDocumentationBLDBDAOSearchTgEctnNoRSQL();
	            dbRowset = exec.executeQuery(template, param, velParam);
	            arrData = new String[5];
				while (dbRowset.next()) {
					arrData[0] = dbRowset.getString(dbRowset.getMetaData().getColumnName(1));	
					arrData[1] = dbRowset.getString(dbRowset.getMetaData().getColumnName(2));	
					arrData[2] = dbRowset.getString(dbRowset.getMetaData().getColumnName(3));	
					arrData[3] = dbRowset.getString(dbRowset.getMetaData().getColumnName(4));
					arrData[4] = dbRowset.getString(dbRowset.getMetaData().getColumnName(5));
				}		
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return arrData;
	    }
	    

	 	/**
	 	 * BL body에 찍힐 WPM관련 문구를 생성한다.
	 	 * @param BkgBlMkDescVO blMkDescVO
	 	 * @param String caFlg
	 	 * @return int
	 	 * @throws DAOException
	 	 */
	 	public int modifyBlDescByWpm(BkgBlMkDescVO blMkDescVO, String caFlg) throws DAOException {
	 		// query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		// velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 		int result = 0;
	 		try {
	            // set parameters
	        	Map<String, String> mapVO = blMkDescVO.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
	            
	            mapVO.put("ca_flg", caFlg);
	            velParam.put("ca_flg", caFlg);

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            BLDocumentationBLDBDAOModifyBlDescByWpmForBlUSQL template = new BLDocumentationBLDBDAOModifyBlDescByWpmForBlUSQL();
	            result = sqlExe.executeUpdate(template, param, velParam);
	 		} catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(),se);
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	 		}
	 		return result;
	 	}
	 	
	 	/**
		 * Export/Import 인도 페이지의 컨테이너 콤보 쿼리.<br>
		 *
		 * @param String bkgNo
		 * @return List<CntrComboVO> list
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
	    public List<CntrComboVO> searchCntrList(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<CntrComboVO> list = null;
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
	            BLDocumentationBLDBDAOsearchCntrRSQL template = new BLDocumentationBLDBDAOsearchCntrRSQL();

	            dbRowset = sqlExe.executeQuery(template, param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrComboVO.class);
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
	     * US filer가 01이면서 C/M 탭에 Self가 찍혀있다면 
	     * BKG Creation의 화면에 저장된 BKG,SI Contact 이메일로 notification을 보낸다
	     * @param String bkgNo
	     * @param String caFlg
	     * @return String[]
	     * @throws DAOException
	     */
	    public String[] checkSelfFilingCM(String bkgNo, String caFlg) throws DAOException {
	        DBRowSet dbRowset = null;
	        String result[] = new String[2];
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
	            
	            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
	            BLDocumentationBLDBDAOCheckSelfFilingCMRSQL template = new BLDocumentationBLDBDAOCheckSelfFilingCMRSQL();
	            dbRowset = sqlExec.executeQuery(template, param, velParam);
//	            if(dbRowset.next()){
//	                result[0] = dbRowset.getString("CNTC_PSON_EML").length() > 0 ? dbRowset.getString(dbRowset.getMetaData().getColumnName(0)) : "";
//	                result[1] = dbRowset.getString("CNTC_PSON_EML").length() > 0 ? dbRowset.getString(dbRowset.getMetaData().getColumnName(1)) : "";
//	            }
	            result = new String[dbRowset.getRowCount()];
				int i = 0;
				while (dbRowset.next()) {
					result[i] = dbRowset.getString("CNTC_PSON_EML");
					i++;
				}	
	        } catch (SQLException ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch (Exception ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return result;
	    }
	    
	    /**
	     * Self auto notification 내용 검색
	     * @param String bkgNo
	     * @param String caFlg
	     * @return CmSelfMailVO
	     * @exception DAOException
	     */
	    public CmSelfMailVO searchContentsForSelfMail(String bkgNo,String caFlg) throws DAOException {
	    	CmSelfMailVO cmSelfMailVO = null;
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
	            BLDocumentationBLDBDAOSearchContentsForSelfMailRSQL template = new BLDocumentationBLDBDAOSearchContentsForSelfMailRSQL();
	            DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				List<CmSelfMailVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmSelfMailVO.class);
		            if(list.size() > 0) {
		            	cmSelfMailVO = list.get(0);
		            }    
	        } catch(SQLException ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        }
	        return cmSelfMailVO;
	    }
	    
	    /**
	     * CM에서 Self로 인해 auto email이 나갔었는지 여부 체크
	     * @param String bkgNo
	     * @return String
	     * @throws DAOException
	     */
	    public String chkCsEmailHisoty(String bkgNo) throws DAOException {
	    	   
	        String flg = null;
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
				BLDocumentationBLDBDAOChkCsEmailHisotyRSQL template = new BLDocumentationBLDBDAOChkCsEmailHisotyRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					flg = dbRowset.getString(1);
				} else {
					flg = "N";
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
	     * CM에서 Self로 인해 auto email이 나갔었는지 여부 체크
	     * @param String bkgNo
	     * @param String caFlg
	     * @return String
	     * @throws DAOException
	     */
	    public String chkSelfFlgCM(String bkgNo, String caFlg) throws DAOException {
	    	   
	        String flg = null;
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
				BLDocumentationBLDBDAOchkSelfFlgCMRSQL template = new BLDocumentationBLDBDAOchkSelfFlgCMRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					flg = dbRowset.getString(1);
				} else {
					flg = "N";
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
		 * XTER VGM Request List 정보를 조회 한다.<br>
		 *
		 * @param XterVgmRqstListInputVO searchXterVgmInputVO
		 * @return List<XterVgmRqstListVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<XterVgmRqstListVO> searchXterVgmList(XterVgmRqstListInputVO searchXterVgmInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<XterVgmRqstListVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchXterVgmInputVO != null){
				if (!JSPUtil.getNull(searchXterVgmInputVO.getBkgNo()).equals("")) {
					searchXterVgmInputVO.setBkgNo("'" + searchXterVgmInputVO.getBkgNo().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(searchXterVgmInputVO.getCntrNo()).equals("")) {
					searchXterVgmInputVO.setCntrNo("'" + searchXterVgmInputVO.getCntrNo().replaceAll(",", "','") + "'");
				}
				Map<String, String> mapVO = searchXterVgmInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOsearchXterVgmRqstListRSQL(),  param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterVgmRqstListVO.class);

			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * XTER VGM 정보 Upload 전 Validation 체크 한다.<br>
		 *
		 * @param XterVgmRqstListVO xterVgmRqstListVO
		 * @return XterVgmInfoValidationVO
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public XterVgmInfoValidationVO searchXterVgmInfoValidation(XterVgmRqstListVO xterVgmRqstListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<XterVgmInfoValidationVO> list = null;
			XterVgmInfoValidationVO xterVgmInfoValidationVO = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterVgmRqstListVO != null){
				Map<String, String> mapVO = xterVgmRqstListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLDocumentationBLDBDAOSearchXterVgmInfoValidationRSQL(),  param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterVgmInfoValidationVO.class);

				if(list != null && list.size() > 0){
					xterVgmInfoValidationVO = list.get(0);
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return xterVgmInfoValidationVO;
		}
		
		/**
		 * XTER VGM 정보를 Update 한다.<br>
		 * 
	     * @author		
		 * @param 		XterVgmRqstListVO xterVgmRqstListVO
		 * @param 		SignOnUserAccount account
		 * @return      int
		 * @exception 	DAOException
		 */
	    public int uploadXterVgmInfo(XterVgmRqstListVO xterVgmRqstListVO, SignOnUserAccount account) throws DAOException {
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        int updCnt = 0;
	        try {
				if(xterVgmRqstListVO != null){
					Map<String, String> mapVO = xterVgmRqstListVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
				}        	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOUploadXterVgmInfoUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
	        } catch (SQLException ex) {
	            //log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }catch(Exception ex){
	            //log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return updCnt;
	    }
	    
		/**
		 * XTER VGM 정보 Upload 결과를 Update 한다.<br>
		 * 
	     * @author		
		 * @param 		XterVgmRqstListVO xterVgmRqstListVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
	    public void modifyXterVgmUploadRslt(XterVgmRqstListVO xterVgmRqstListVO, SignOnUserAccount account) throws DAOException {
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
				if(xterVgmRqstListVO != null){
					Map<String, String> mapVO = xterVgmRqstListVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
				}        	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BLDocumentationBLDBDAOModifyXterVgmUploadRsltUSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
	        } catch (SQLException ex) {
	            //log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }catch(Exception ex){
	            //log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }
	    
	    /**
	     * Export Import 인바운드가 터키인 BKG의 Consignee, Notify tax id 데이터 유무 판단
	     * @param String bkgNo
	     * @param String caFlg
	     * @return String
	     * @throws DAOException
	     */
	    public String checkTurkeyTaxId(String bkgNo, String caFlg) throws DAOException {
	    	   
	        String flg = null;
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
				BLDocumentationBLDBDAOCheckTurkeyTaxIdRSQL template = new BLDocumentationBLDBDAOCheckTurkeyTaxIdRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					flg = dbRowset.getString(1);
				} else {
					flg = "N";
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
}
