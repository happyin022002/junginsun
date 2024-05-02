/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenDAO.java
*@FileTitle : Break Bulk Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.04.28 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAOAddDoHistoryCSQL;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic.CsScreenBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcCneeInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcNtfyInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrBySealNoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntDtlsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntMstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrPkupNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CstmsClearInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcCneeInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcNtfyInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TpszQtyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoDtlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCstmsRefInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsFreigtInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgAwkCgoVO;
import com.hanjin.syscommon.common.table.BkgBbCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRsltVO;
import com.hanjin.syscommon.common.table.BkgDoHisVO;



/**
 * ALPS CsScreenDAO <br>
 * - ALPS-CsScreenMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Mi Ok
 * @see CsScreenBCImpl 참조
 * @since J2EE 1.4
 */
public class CsScreenDBDAO extends DBDAOSupport {

	/**
	 * DG Cargo Detail 리스트를 조회한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<DgCgoVO>
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<DgCgoVO> searchDgCargoList(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DgCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				Map<String, String> mapVO = new HashMap();
				
				mapVO.put("bkg_no", bkgNo);
				mapVO.put("cntr_no", cntrNo);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchDgCargoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgCgoVO .class);
			
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
	 * Break Bulk Detail 리스트를 조회한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return List<BkgBbCgoVO>
	 * @exception DAOException
	 */	 
	@SuppressWarnings("unchecked")
	public List<BkgBbCgoVO> searchBbCargoList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBbCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBbCargoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBbCgoVO .class);
			
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
	  * Awkward Dimension Detail 리스트를 조회한다.<br>
	  * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<BkgAwkCgoVO> AWKWARD CARGO DETAIL DATA
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgAwkCgoVO> searchAwkCargoList(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgAwkCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
            Map<String, String> mapVO = new HashMap();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
		
			param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchAwkCargoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgAwkCgoVO.class);
			
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
     * Inbound C/S Screen화면의 B/L Info를 조회한다.<br>
     *
     * @param String bkgNo Booking No. 
     * @return BlInfosVO
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public BlInfosVO searchBlInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BlInfosVO blInfos = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBlInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
            	blInfos = (BlInfosVO)RowSetUtil.rowSetToVOs(dbRowset, BlInfosVO.class ).get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return blInfos;
    }	
	
	
    /**
     * Inbound C/S Screen화면의 B/L Info를 조회한다.<br>
     *
     * @param String bkgNo Booking No. 
     * @return BkgInfoVO
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public BkgInfoVO searchBkgInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        BkgInfoVO bkgInfo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBkgInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
            	bkgInfo = (BkgInfoVO)RowSetUtil.rowSetToVOs(dbRowset, BkgInfoVO.class ).get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return bkgInfo;
    }	
     
     /**
      * Customs Ref No를 조회한다.<br>
      *
      * @param String blNo BL No.
      * @param SignOnUserAccount account
      * @return String
      * @exception DAOException
      */
      @SuppressWarnings("unchecked")
     public String searchCstmsRefNo(String blNo, SignOnUserAccount account) throws DAOException {
         DBRowSet dbRowset = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         String customsRefNo = null;
         try{
             Map<String, String> mapVO = new HashMap();
             
             mapVO.put("bl_no" , blNo);

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCstmsRefNoRSQL(), param, velParam);
             
             if (dbRowset.next()) {
            	 customsRefNo = dbRowset.getString(1);
             }
 		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
         return customsRefNo;
     }	 
      
 	 /**
 	  * Inbound C/S Screen 화면의 TP/SZ 리스트를 조회한다.<br>
 	  * 
 	 * @param String bkgNo Booking No.
 	 * @return List<TpszQtyVO>
 	 * @exception DAOException
 	 */
 	@SuppressWarnings("unchecked")
 	public List<TpszQtyVO> searchQtyForCntrByTpsz(String bkgNo) throws DAOException {

        DBRowSet dbRowset = null;
        List<TpszQtyVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	Map<String, String> mapVO = new HashMap();
 			
 			mapVO.put("bkg_no", bkgNo);
 		
 			param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchQtyForCntrByTpszRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpszQtyVO.class);

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
     * Inbound C/S Screen 화면의 Cntr Info 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @param bkgCgoTpCd bkgCgoTpCd
	 * @param bbCgoFlg bbCgoFlg
	 * @return List<CntrInfoVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrInfoVO> searchCntrInfo(String bkgNo, String bkgCgoTpCd, String bbCgoFlg) throws DAOException {

       DBRowSet dbRowset = null;
       List<CntrInfoVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
       	Map<String, String> mapVO = new HashMap();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_cgo_tp_cd", bkgCgoTpCd);
			mapVO.put("bb_cgo_flg", bbCgoFlg);
		
		    param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrInfoVO.class);

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
	  * Inbound C/S Screen 화면의 Cntr Info 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<CntrBySealNoVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrBySealNoVO> searchCntrBySealNo(String bkgNo) throws DAOException {

      DBRowSet dbRowset = null;
      List<CntrBySealNoVO> list = null;
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();

      try{
      	Map<String, String> mapVO = new HashMap();
			
			mapVO.put("bkg_no", bkgNo);
		
		    param.putAll(mapVO);
           velParam.putAll(mapVO);

           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrBySealNoRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrBySealNoVO.class);

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
	  * Inbound C/S Screen 화면의 Movement의 Detail 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<CntrMvntDtlsVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrMvntDtlsVO> searchCntrMvntDtlInfo(String bkgNo) throws DAOException {

    DBRowSet dbRowset = null;
    List<CntrMvntDtlsVO> list = null;
    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
    	 Map<String, String> mapVO = new HashMap();
			
		 mapVO.put("bkg_no", bkgNo);
		
		 param.putAll(mapVO);
         velParam.putAll(mapVO);

         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrMvntDtlInfoRSQL(), param, velParam);
         list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvntDtlsVO.class);

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
	  * Inbound C/S Screen 화면의 S/O Info 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<CntrSoVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSoVO> searchCntrSoInfo(String bkgNo) throws DAOException {

    DBRowSet dbRowset = null;
    List<CntrSoVO> list = null;
    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
    	Map<String, String> mapVO = new HashMap();
			
		  mapVO.put("bkg_no", bkgNo);
		
		  param.putAll(mapVO);
         velParam.putAll(mapVO);

         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrSoInfoRSQL(), param, velParam);
         list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSoVO.class);

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
	  * Inbound C/S Screen 화면의 S/O Info의 Detail 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<CntrSoDtlVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSoDtlVO> searchCntrSoDtlInfo(String bkgNo) throws DAOException {

   DBRowSet dbRowset = null;
   List<CntrSoDtlVO> list = null;
   //query parameter
   Map<String, Object> param = new HashMap<String, Object>();
   //velocity parameter
   Map<String, Object> velParam = new HashMap<String, Object>();

   try{
   	 Map<String, String> mapVO = new HashMap();
			
		 mapVO.put("bkg_no", bkgNo);
		
		 param.putAll(mapVO);
        velParam.putAll(mapVO);

        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrSoDtlInfoRSQL(), param, velParam);
        list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSoDtlVO.class);

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
     * Booking Status를 체크한다.<br>
     *
     * @param String bkgNo Booking No.
     * @return String
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public String searchBkgStatus(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String bkgStsCd = "";
        try{
            Map<String, String> mapVO = new HashMap();
            
            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBkgStatusRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	bkgStsCd = dbRowset.getString(1);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return bkgStsCd;
    }	 

     /**
      * Booking Status를 체크한다.<br>
      *
      * @param String bkgNo Booking No.
      * @return String
      * @exception DAOException
      */
      @SuppressWarnings("unchecked")
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
 		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
         return bkgStsCd;
     }	 
     
     
 	/**
	  * US I/B CS Screen에서 US Customs Clearance Result 정보 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return UsCstmsRefInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsCstmsRefInfoVO searchUsCstmsRefInfo(String bkgNo) throws DAOException {

	   DBRowSet dbRowset = null;

	   UsCstmsRefInfoVO usCstmsRefVO = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
           Map<String, String> mapVO = new HashMap();

           mapVO.put("bkg_no" , bkgNo);

           param.putAll(mapVO);
           velParam.putAll(mapVO);

           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCstmsRefInfoRSQL(), param, velParam);

           if(dbRowset.getRowCount() > 0){
        	   usCstmsRefVO = (UsCstmsRefInfoVO)RowSetUtil.rowSetToVOs(dbRowset, UsCstmsRefInfoVO.class ).get(0);
           }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       return usCstmsRefVO;
	}
	
 	/**
	  * US I/B CS Screen에서 US Customs  정보 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return CstmsClearInfoVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstmsClearInfoVO searchCstmsClearInfo(String bkgNo) throws DAOException {

	   DBRowSet dbRowset = null;

	   CstmsClearInfoVO cstmsClearInfoVO = null;
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();

      try{
          Map<String, String> mapVO = new HashMap();

          mapVO.put("bkg_no" , bkgNo);

          param.putAll(mapVO);
          velParam.putAll(mapVO);

          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCstmsClearInfoRSQL(), param, velParam);

          if(dbRowset.getRowCount() > 0){
        	  cstmsClearInfoVO = (CstmsClearInfoVO)RowSetUtil.rowSetToVOs(dbRowset, CstmsClearInfoVO.class ).get(0);
          }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
      return cstmsClearInfoVO;
	}
	
	
	/**
	  * 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다.<br>
	 * @param String bkgNo
	 * @param String ofc_cd
	 * @param String retCntrNo
	 * @param String retPartialYn	  
	 * @return List<CntrPkupNtcInfoVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrPkupNtcInfoVO> searchUsCntrInfo(String bkgNo, String ofc_cd, String retCntrNo, String retPartialYn ) throws DAOException {

		  DBRowSet dbRowset = null;
		  List<CntrPkupNtcInfoVO> list = null;
		  //query parameter
		  Map<String, Object> param = new HashMap<String, Object>();
		  //velocity parameter
		  Map<String, Object> velParam = new HashMap<String, Object>();
		
		  try{
		  	 Map<String, String> mapVO = new HashMap();
					
			   mapVO.put("login_ofc_cd", ofc_cd);
			   mapVO.put("bkg_no", bkgNo);
			   mapVO.put("cntr_no", retCntrNo);
			   mapVO.put("partial_yn", retPartialYn);
			   
			   param.putAll(mapVO);
		       velParam.putAll(mapVO);
		
		       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCntrInfoRSQL(), param, velParam);
		       list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrPkupNtcInfoVO.class);
		
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
	 * [ESM_BKG_0668_5]
	 * 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Customs Result를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<BkgCstmsAdvRsltVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvRsltVO> searchUsCstmsRstInfo(String bkgNo) throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<BkgCstmsAdvRsltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cnt_cd", "US");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCstmsRstInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvRsltVO.class);
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
	  * Inbound C/S Screen US 화면의 Movement 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<CntrMvntMstsVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrMvntMstsVO> searchCntrMvntMstInfo(String bkgNo) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<CntrMvntMstsVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
	     	 Map<String, String> mapVO = new HashMap();
				
			 mapVO.put("bkg_no", bkgNo);
			
			 param.putAll(mapVO);
	         velParam.putAll(mapVO);
	
	         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrActMvntInfoRSQL(), param, velParam);
	         list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvntMstsVO.class);
	
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
     * Inbound C/S Screen US 화면의 Movement의 CLM Detail 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @param cntrNo Container No.
	 * @return List<CntrClmInfosVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrClmInfosVO> searchCntrClmInfo(String bkgNo, String cntrNo) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<CntrClmInfosVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
	   	    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
			
			param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchCntrClmInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrClmInfosVO.class);
	
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
	  * Inbound C/S Screen US 화면의 S/O Info의 Detail 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<UsCntrSoDtlInfosVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsCntrSoDtlInfosVO> searchUsCntrSoDtlInfo(String bkgNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<UsCntrSoDtlInfosVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCntrSoDtlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCntrSoDtlInfosVO.class);
	
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
	 *  Container No로 조회시 연계된 B/L이 LCL인 경우,관련 B/L List를 조회하고 <br>
	 *  LCL이 아닌 경우,단건의 B/L 정보를 조회한다.<br>
	 * @param String cntrNo Container No.
	 * @return List<BkgBlInfosVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBlInfosVO> searchBlListByCntrNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlInfosVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			 Map<String, String> mapVO = new HashMap();

	         mapVO.put("cntr_no" , cntrNo);
	         
	         mapVO.put("cust_to_ord_flg" , "Y");

	         param.putAll(mapVO);
	         velParam.putAll(mapVO);      
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CsScreenDBDAOsearchBlListByCntrNoRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlInfosVO.class);

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
	 * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다. <br>
	 * @param String poNo P/O No.
	 * @return List<BkgBlInfosVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBlInfosVO> searchBlListByPoNo (String poNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlInfosVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("po_no", poNo);
			velParam.put("po_no", poNo);;
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CsScreenDBDAOsearchBlListByPoNoRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlInfosVO.class);

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
	 * HB/L No로 BKG NO 조회. <br>
	 * @param String hbl_no H/BL No.
	 * @return List<BkgBlInfosVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBlInfosVO> searchBlListByHblNo (String hbl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlInfosVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("hbl_no", hbl_no);
			velParam.put("hbl_no", hbl_no);;
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CsScreenDBDAOsearchBlListByHblNoRSQL(), param,
					velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlInfosVO.class);

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
	 * BKG NO로 SPLIT된 BL NO 조회. <br>
	 * @param String bkg_no Booking No.
	 * @return List<BkgBlInfosVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBlInfosVO> searchBlListByBkgSplit (String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlInfosVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			velParam.put("bkg_no", bkg_no);;
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CsScreenDBDAOsearchBlListByBkgSplitRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlInfosVO.class);

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
	 * Inbound C/S Screen US 화면의 S/O Info 리스트를 조회한다.<br>
	 * @param bkgNo Booking No.
	 * @return List<UsCntrSoInfosVO> 
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<UsCntrSoInfosVO> searchUsCntrSoInfo(String bkgNo) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<UsCntrSoInfosVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
		    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
		
		    param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCntrSoInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCntrSoInfosVO.class);
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	   return list;
		
	}      	
	
// 	/**
//	  * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
//	 * @param bkgNo Booking No.
//	 * @return ArrNtcBlCopyBkgInfoVO
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public ArrNtcBlCopyBkgInfoVO searchArrNtcBlCopyBkgInfo(String bkgNo) throws DAOException {
//
//	   DBRowSet dbRowset = null;
//
//	   ArrNtcBlCopyBkgInfoVO arrNtcBlCopyBkgInfoVO = null;
//       //query parameter
//       Map<String, Object> param = new HashMap<String, Object>();
//       //velocity parameter
//       Map<String, Object> velParam = new HashMap<String, Object>();
//
//	    try{
//	         Map<String, String> mapVO = new HashMap();
//	
//	         mapVO.put("bkg_no" , bkgNo);
//	
//	         param.putAll(mapVO);
//	         velParam.putAll(mapVO);
//	
//	         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchArrNtcBlCopyBkgInfoRSQL(), param, velParam);
//	
//	         if(dbRowset.getRowCount() > 0){
//	        	 arrNtcBlCopyBkgInfoVO = (ArrNtcBlCopyBkgInfoVO)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcBlCopyBkgInfoVO.class ).get(0);
//	         }
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		
//		return arrNtcBlCopyBkgInfoVO;
//	}	
	
//	/**
//	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
//	 * @param bkgNo Booking No.
//     * @param SignOnUserAccount account 
//	 * @return List<ArrNtcBlCopyFaxInfoVO> 
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<ArrNtcBlCopyFaxInfoVO> searchArrNtcBlCopyFaxInfo(String bkgNo, SignOnUserAccount account) throws DAOException {
//
//	    DBRowSet dbRowset = null;
//	    List<ArrNtcBlCopyFaxInfoVO> list = null;
//	    //query parameter
//	    Map<String, Object> param = new HashMap<String, Object>();
//	    //velocity parameter
//	    Map<String, Object> velParam = new HashMap<String, Object>();
//	
//	    try{
//		    Map<String, String> mapVO = new HashMap();
//				
//			mapVO.put("bkg_no", bkgNo);
//			mapVO.put("usr_id", account.getUsr_id());
//		
//		    param.putAll(mapVO);
//	        velParam.putAll(mapVO);
//	
//	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchArrNtcBlCopyFaxInfoRSQL(), param, velParam);
//	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcBlCopyFaxInfoVO.class);
//	
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	   return list;
//		
//	}  	

//	/**
//	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
//	 * @param bkgNo Booking No.
//     * @param SignOnUserAccount account 
//	 * @return List<ArrNtcBlCopyMailInfoVO> 
//	 * @exception DAOException
//	*/
//	@SuppressWarnings("unchecked")
//	public List<ArrNtcBlCopyMailInfoVO> searchArrNtcBlCopyMailInfo(String bkgNo, SignOnUserAccount account) throws DAOException {
//
//	    DBRowSet dbRowset = null;
//	    List<ArrNtcBlCopyMailInfoVO> list = null;
//	    //query parameter
//	    Map<String, Object> param = new HashMap<String, Object>();
//	    //velocity parameter
//	    Map<String, Object> velParam = new HashMap<String, Object>();
//	
//	    try{
//		    Map<String, String> mapVO = new HashMap();
//				
//			mapVO.put("bkg_no", bkgNo);
//			mapVO.put("usr_id", account.getUsr_id());
//		
//		    param.putAll(mapVO);
//	        velParam.putAll(mapVO);
//	
//	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchArrNtcBlCopyMailInfoRSQL(), param, velParam);
//	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcBlCopyMailInfoVO.class);
//	
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	    return list;		
//	}  	

 	/**
	  * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param bkgNo Booking No.
	 * @return PkupNtcBkgInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PkupNtcBkgInfoVO searchPkupNtcBkgInfo(String bkgNo) throws DAOException {

	   DBRowSet dbRowset = null;

	   PkupNtcBkgInfoVO list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	        Map<String, String> mapVO = new HashMap();
	
	        mapVO.put("bkg_no" , bkgNo);
	
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchPkupNtcBkgInfoRSQL(), param, velParam);
	
	        if(dbRowset.getRowCount() > 0){
	        	list = (PkupNtcBkgInfoVO)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcBkgInfoVO.class ).get(0);
	        }
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
	 * B/L 단위로 Email 로 P/N를 송부한다. <br>
	 * @param bkgNo Booking No.
	 * @param ofcCd Login Office Code
	 * @return List<PkupNtcCneeInfoVO> 
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<PkupNtcCneeInfoVO> searchPkupNtcCneeInfo(String bkgNo, String ofcCd) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<PkupNtcCneeInfoVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
		    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("bkg_cust_tp_cd", "C");
		
		    param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchPkupNtcCneeInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcCneeInfoVO.class);
	
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
	 * B/L 단위로 Email 로 P/N를 송부한다. <br>
	 * @param bkgNo Booking No.
	 * @param ofcCd Login Office Code
	 * @return List<PkupNtcNtfyInfoVO> 
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<PkupNtcNtfyInfoVO> searchPkupNtcNtfyInfo(String bkgNo, String ofcCd) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<PkupNtcNtfyInfoVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
		    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("bkg_cust_tp_cd", "N");
		
		    param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchPkupNtcNtfyInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcNtfyInfoVO.class);
	
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
     * Inbound C/S Screen화면의 B/L Info를 조회한다.<br>
     *
     * @param String bkgNo Booking No. 
     * @return TopBlInfoVO
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public TopBlInfoVO searchTopBlInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        TopBlInfoVO blInfos = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchTopBlInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
            	blInfos = (TopBlInfoVO)RowSetUtil.rowSetToVOs(dbRowset, TopBlInfoVO.class ).get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return blInfos;
    }		
     
  	/**
	  * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param bkgNo Booking No.
	 * @return BlCustInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BlCustInfoVO> searchBlCustInfo(String bkgNo) throws DAOException {

	   DBRowSet dbRowset = null;

	   List<BlCustInfoVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	         Map<String, String> mapVO = new HashMap();
	
	         mapVO.put("bkg_no" , bkgNo);
	
	         param.putAll(mapVO);
	         velParam.putAll(mapVO);
	
	         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchBlCustInfoRSQL(), param, velParam);
	
	         if(dbRowset.getRowCount() > 0){
	 	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCustInfoVO.class);
	         }
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
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param bkgNo Booking No.
     * @param SignOnUserAccount account 
	 * @return List<ArrNtcCneeInfoVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ArrNtcCneeInfoVO> searchArrNtcCneeInfo(String bkgNo, SignOnUserAccount account) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<ArrNtcCneeInfoVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
		    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("usr_id", account.getUsr_id());
		
		    param.putAll(mapVO);
	        velParam.putAll(mapVO); 
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchArrNtcCneeInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcCneeInfoVO.class);
	
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
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param bkgNo Booking No.
     * @param SignOnUserAccount account 
	 * @return List<ArrNtcNtfyInfoVO> 
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<ArrNtcNtfyInfoVO> searchArrNtcNtfyInfo(String bkgNo, SignOnUserAccount account) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<ArrNtcNtfyInfoVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try{
		    Map<String, String> mapVO = new HashMap();
				
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("usr_id", account.getUsr_id());
		
		    param.putAll(mapVO);
	        velParam.putAll(mapVO);
	
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchArrNtcNtfyInfoRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcNtfyInfoVO.class);
	
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
     * Inbound C/S Screen USA 화면의 searchUsFrgightInfo를 조회한다.<br>
     *
     * @param String bkgNo Booking No. 
     * @return UsFreigtInfoVO
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public UsFreigtInfoVO searchUsFrgightInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        UsFreigtInfoVO usFreigtInfoVO = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap();

            mapVO.put("bkg_no" , bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsFrgightInfoRSQL(), param, velParam);

            if(dbRowset.getRowCount() > 0){
            	usFreigtInfoVO = (UsFreigtInfoVO)RowSetUtil.rowSetToVOs(dbRowset, UsFreigtInfoVO.class ).get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return usFreigtInfoVO;
    }		
	
 	/**
 	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 조회한다. [1093]<br>
 	 * 
 	 * @param String bkgNo Booking No.
 	 * @return List<UsCustSvcInstrsVO>
 	 * @exception DAOException
 	 */	
 	 @SuppressWarnings("unchecked")
 	public List<UsCustSvcInstrsVO> searchUsCustSvcInstr(String bkgNo) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<UsCustSvcInstrsVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try {
 				Map<String, String> mapVO = new HashMap();
 				
 				mapVO.put("bkg_no", bkgNo);
 			
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);

 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CsScreenDBDAOsearchUsCustSvcInstrRSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsCustSvcInstrsVO .class);
 			
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
     * Inbound C/S_USA SCREEN에서 저장된 Remark를 등록한다. [1093]<br>
     *
     * @param UsCustSvcInstrsVO usCustSvcInstrs
     * @exception DAOException
     * @author 
     */
    public void addUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = usCustSvcInstrs.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CsScreenDBDAOaddUsCustSvcInstrCSQL(), param, velParam);
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
     * Inbound C/S_USA SCREEN에서 저장된 Remark를 삭제한다. [1093]<br>
     *
     * @param UsCustSvcInstrsVO usCustSvcInstrs
     * @exception DAOException
     * @author 
     */
    public void removeUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = usCustSvcInstrs.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CsScreenDBDAOremoveUsCustSvcInstrUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    } 	

}
