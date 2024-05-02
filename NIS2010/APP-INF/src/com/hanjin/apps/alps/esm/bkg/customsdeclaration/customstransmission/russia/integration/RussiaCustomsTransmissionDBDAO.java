/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAO.java
*@FileTitle : CustomsTransmission
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.30
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2015.12.30 신규정
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCMCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCargoTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusCntrCargoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusDangerCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiatransmitBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS RussiaCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyu Jeong Shin
 * @see RussiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6 
 */

public class RussiaCustomsTransmissionDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 3447327723043443513L;
	
	
	/**
     * flatFile 생성을 위한 VSL 정보 조회<br>
     * 
	 * @param TransKeyVO transKeyVO
	 * @return RussiaVslInfoVO searchVslInfo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RussiaVslInfoVO searchVslInfo(TransKeyVO transKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaVslInfoVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = transKeyVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchVslInfoRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaVslInfoVO.class);

			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
     * flatFile 생성을 위한 VVD 정보 조회<br>
     * 
	 * @param TransKeyVO transKeyVO 
	 * @return RussiaCncusVvdVO searchCncusVvd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RussiaCncusVvdVO searchCncusVvd(TransKeyVO transKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCncusVvdVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
            Map<String, String> mapVO = transKeyVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
            velParam.put("mode_type", transKeyVO.getModeType());
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCncusVvdRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCncusVvdVO.class);

			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
     * flatFile 생성을 위한 VVD 정보 조회<br>
     * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param TransKeyVO transKeyVO
	 * @return List<RussiatransmitBlListVO> searchRussiaBl
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiatransmitBlListVO> searchRussiaBl(List<TransKeyVO> transKeyVOs, TransKeyVO transKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiatransmitBlListVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
//            param.put("bl_no", transKeyVOs.get(0).getBlNo());
//            param.put("pol", pol);
//            param.put("trans_mode", transKeyVOs.get(0).getTransMode());
//            velParam.put("trans_mode", transKeyVOs.get(0).getTransMode());
            
            param.put("pol_cd", transKeyVO.getPolCd());
            param.put("pod_cd", transKeyVO.getPodCd());
            param.put("mode_type", transKeyVO.getModeType());
            param.put("vvd_cd", transKeyVO.getVvdCd());
            
            String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 
			 for (int i=0; i<transKeyVOs.size(); i++) {	
				 strBlNo = transKeyVOs.get(i).getBkgNo();
				 arrString.add(strBlNo);
			 }
//			 for (int i=0; i<russiaManifestListDetailVOs.length; i++) {	
//				 strBlNo = russiaManifestListDetailVOs[i].getBkgNo();
//				 arrString.add(strBlNo);
//			 }
			 velParam.put("field_list", arrString);
			 velParam.put("mode_type", transKeyVO.getModeType());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCncusBlRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiatransmitBlListVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
     * flatFile 생성을 위한 Danger Cargo 정보 조회<br>
     * 
	 * @param String blNo 
	 * @return List<RussiaCncusDangerCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiaCncusDangerCntrVO> searchCncusDangerCntr(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCncusDangerCntrVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {  
            param.put("bl_no", blNo);
             
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCncusDangerCntrVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
     * flatFile 생성을 위한 Container 정보 조회<br>
     * 
	 * @param String blNo 
	 * @return List<RussiaCncusCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiaCncusCntrVO> searchCncusCntr(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCncusCntrVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {  
            param.put("bl_no", blNo);
        
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCncusCntrRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCncusCntrVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
     * flatFile 생성을 위한 Container 정보 조회<br>
     * 
	 * @param String blNo 
	 * @return List<RussiaCMCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiaCMCntrVO> searchCMCntr(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCMCntrVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {  
            param.put("bkg_no", blNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCMCntrRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCMCntrVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * flatFile 생성을 위한 Container 정보 조회<br>
     * 
	 * @param String blNo 
	 * @return List<RussiaCncusCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiaCncusCntrCargoVO> searchCncusCntrCargo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCncusCntrCargoVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {  
            param.put("bl_no", blNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCncusCntrCargoRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCncusCntrCargoVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
     * flatFile 생성을 위한 VVD 정보 조회<br>
     * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param TransKeyVO transKeyVO
	 * @return List<RussiatransmitBlListVO> searchRussiaBl
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RussiaCargoTotalVO> searchCargoTotal(List<TransKeyVO> transKeyVOs, TransKeyVO transKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RussiaCargoTotalVO> list = null;
				
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
           
            param.put("pol_cd", transKeyVO.getPolCd());
            param.put("pod_cd", transKeyVO.getPodCd());
            param.put("mode_type", transKeyVO.getModeType());
            param.put("vvd_cd", transKeyVO.getVvdCd());
            
            String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 
			 for (int i=0; i<transKeyVOs.size(); i++) {	
				 strBlNo = transKeyVOs.get(i).getBkgNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaCustomsTransmissionDBDAOsearchCargoTotalRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RussiaCargoTotalVO.class);

			return list;
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
}
