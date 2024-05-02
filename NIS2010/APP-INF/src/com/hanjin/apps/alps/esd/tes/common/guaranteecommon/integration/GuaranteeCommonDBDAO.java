/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonDBDAO.java
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.vo.SearchRefNoListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;


/**
 * ALPS GuaranteeCommonDBDAO <br>
 * - ALPS-GuaranteeCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see GuaranteeCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class GuaranteeCommonDBDAO extends DBDAOSupport {
	
	/**
	 * [Guarantee Non TPB 여부]을 [Check] 합니다.<br>
	 * 
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<TPBInterfaceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TesGnteCntrListVO> checkNonTPB(TesGnteCntrListVO tesGnteCntrListVO) throws DAOException {
		DBRowSet				dbRowset	= null;
		List<TesGnteCntrListVO>	list		= null;
		
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		try{
			if(tesGnteCntrListVO != null){
				Map<String, String> mapVO = tesGnteCntrListVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOCheckNonTPBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesGnteCntrListVO .class);
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
	 * [Reference No(Guarantee No. Or Irregular No.)]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchRefNoListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchRefNoListVO> searchRefNoList(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRefNoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(guaranteeCommonVO != null){
				Map<String, String> mapVO = guaranteeCommonVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchRefNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRefNoListVO .class);
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
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUSGuaranteeCntrInfo(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if ( !"".equals( guaranteeCommonVO.getCntrNoTmp() ) ) {
				param	.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
			}

			if ( !"".equals( guaranteeCommonVO.getBkgNoTmp() ) ) {
				param	.put("bkg_no", guaranteeCommonVO.getBkgNoTmp() );
				velParam.put("bkg_no", guaranteeCommonVO.getBkgNoTmp() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Guarantee Creation Grid에 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUSGuaranteeCntrDupChk(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("ppppp : " + guaranteeCommonVO .getColumnValues());
		try{
			if ( !"".equals( guaranteeCommonVO.getGnteCustCdTmp() ) ) {
				param	.put("gnte_cust_cd", guaranteeCommonVO.getGnteCustCdTmp() );
				velParam.put("gnte_cust_cd", guaranteeCommonVO.getGnteCustCdTmp() );
			}

			if ( !"".equals( guaranteeCommonVO.getVndrSeqTmp() ) ) {
				param	.put("vndr_seq", guaranteeCommonVO.getVndrSeqTmp() );
				velParam.put("vndr_seq", guaranteeCommonVO.getVndrSeqTmp() );
			}
			
			//2012.07.23 US Guarantee 중복 입력 check에 비용 Type 포함 
			if ( !"".equals( guaranteeCommonVO.getGnteTpCdTmp() ) ) {
				param	.put("gnte_tp_cd", guaranteeCommonVO.getGnteTpCdTmp() );
				velParam.put("gnte_tp_cd", guaranteeCommonVO.getGnteTpCdTmp() );
			}
			
			if ( !"".equals( guaranteeCommonVO.getCntrNoTmp() ) ) {
				param	.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
			}

			if ( !"".equals( guaranteeCommonVO.getBkgNoTmp() ) ) {
				param	.put("bkg_no", guaranteeCommonVO.getBkgNoTmp() );
				velParam.put("bkg_no", guaranteeCommonVO.getBkgNoTmp() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChkRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Guarantee Creation Save 시 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUSGuaranteeCntrDupChk2(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dupChk = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//		String retVal = "";
		try{
			
			String all_tmp =  guaranteeCommonVO.getAllTmp();
			String[] cntrBkg = all_tmp.split(":");
			
			ArrayList tempArrL = new ArrayList();
			for (int i=0; cntrBkg!=null && i<cntrBkg.length; i++){
				if ( !"".equals( guaranteeCommonVO.getGnteCustCdTmp() ) ) {
					param	.put("gnte_cust_cd", guaranteeCommonVO.getGnteCustCdTmp() );
					velParam.put("gnte_cust_cd", guaranteeCommonVO.getGnteCustCdTmp() );
				}
				if ( !"".equals( guaranteeCommonVO.getVndrSeqTmp() ) ) {
					param	.put("vndr_seq", guaranteeCommonVO.getVndrSeqTmp() );
					velParam.put("vndr_seq", guaranteeCommonVO.getVndrSeqTmp() );
				}
				//2012.07.23 US Guarantee 중복 입력 check에 비용 Type 포함 
				if ( !"".equals( guaranteeCommonVO.getGnteTpCdTmp() ) ) {
					param	.put("gnte_tp_cd", guaranteeCommonVO.getGnteTpCdTmp() );
					velParam.put("gnte_tp_cd", guaranteeCommonVO.getGnteTpCdTmp() );
				}
				tempArrL.add(cntrBkg[i]);
				
				if(tempArrL.size()>0){
					velParam.put("cntr_bkg", tempArrL);   
				}
			}
			dupChk = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChk2RSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dupChk;
	}
	
	/**
	 * [Master Container 에 CNTR 존재여부]를 조회합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMstCntrExist(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if ( !"".equals( guaranteeCommonVO.getCntrNoTmp() ) ) {
				param	.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
			}
			log.debug("dao.searchMstCntrExist :"+guaranteeCommonVO.getCntrNoTmp());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchMstCntrExistRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrBkgNo(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			if ( !"".equals( guaranteeCommonVO.getCntrNoTmp() ) ) {
				param	.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp() );
			}
			
			if ( !"".equals( guaranteeCommonVO.getCreFlg() ) ) {
				param	.put("cre_flg", guaranteeCommonVO.getCreFlg() );
				velParam.put("cre_flg", guaranteeCommonVO.getCreFlg() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchCntrBkgNoRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
			
		 
	/**
	 * validate Customer Code
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCustomerCode(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		log.debug("\n[GuaranteeCommonDBDAO][validateCustomerCode] \n");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			
			if ( !"".equals( guaranteeCommonVO.getGnteCustCd() ) && guaranteeCommonVO.getGnteCustCd().length() == 8 ) {
				param	.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2) );
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2) );
				
				param	.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8) );
				velParam.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8) );
			} else {
				param	.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd() );
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd() );
				
				param	.put("cust_seq", "" );
				velParam.put("cust_seq", "" );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOValidateCustomerCodeRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	
		return dbRowset;
	}
	
	
	
	/**
	 * Container No. Duplication Check.<br>
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkDupCntr(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		log.debug("\n[GuaranteeCommonDBDAO][checkDupCntr] \n");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		boolean		isSuccess	= false;
		
		try {
			
			if(guaranteeCommonVO != null){
				Map<String, String> mapVO = guaranteeCommonVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOCheckDupCntrRSQL(), param, velParam);
			
			while ( dbRowset.next() ) {
				if ( dbRowset.getInt("CNT") < 1 ) {
					isSuccess	= true;
				} else {
					isSuccess	= false;
					throw new DAOException(new ErrorHandler("TES00071", new String[]{ guaranteeCommonVO.getCntrNo() }).getMessage());
//					throw new DAOException("\n [Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccess;
	}
	
	/**
	 * Guarantee Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchValidChkForPrint(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param	.put("gnte_no_hidden", guaranteeCommonVO.getGnteNoHidden() );
				velParam.put("gnte_no_hidden", guaranteeCommonVO.getGnteNoHidden() );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchValidChkForPrintRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Irregular Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchIrrPrintChk(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param	.put("irr_no_hidden", guaranteeCommonVO.getIrrNoHidden() );
				velParam.put("irr_no_hidden", guaranteeCommonVO.getIrrNoHidden() );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeCommonDBDAOSearchIrrPrintChkRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

}