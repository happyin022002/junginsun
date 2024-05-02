/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : organizationDBDAO.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.basic.OrganizationBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeIfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS organizationDBDAO <br>
 * - OPUS-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see OrganizationBCImpl 참조
 * @since J2EE 1.6
 */
public class OrganizationDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * BCM_CCD_0041 : Retrieve <br>
	 * 입력한 Office Access Group Creation 정보를 조회한다.<br>
	 * 
	 * @param String sybSysCd
	 * @param String accGrpId
	 * @return List<OfcAccGrpVO>
	 * @exception DAOException
	 */
	public List<OfcAccGrpVO> searchOfcAccGrp(String sybSysCd, String accGrpId) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfcAccGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			if(sybSysCd != null && accGrpId != null){			
				param.put("ofc_grp_id",accGrpId);
				param.put("sub_sys_cd",sybSysCd);
				
				velParam.put("ofc_grp_id",accGrpId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchOfcAccGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcAccGrpVO.class);
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
	 * BCM_CCD_0041 : Save <br>
	 * 입력 및 조회된 Office Access Group Creation 정보를 추가한다.<br>
	 * 
	 * @param OfcAccGrpVO ofcAccGrpVO
	 * @exception DAOException
	 */
	public void addOfcAccGrp(OfcAccGrpVO ofcAccGrpVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (ofcAccGrpVO != null) {
				Map<String, String> mapVO = ofcAccGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new OrganizationDBDAOAddOfcAccGrpCSQL(), param, velParam);	
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert OrganizationDBDAOAddOfcAccGrpCSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
	
	/**
	 * BCM_CCD_0041 : Save <br>
	 * 입력 및 조회된 Office Access Group Creation 정보를 수정한다.<br>
	 * 
	 * @param List<OfcAccGrpVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyOfcAccGrp(List<OfcAccGrpVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OrganizationDBDAOModifyOfcAccGrpUSQL(), updateSheetVoList,null);
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
	 * BCM_CCD_0041 : Row Delete <br>
	 * BCM_CCD_0042 : Row Delete <br>
	 * Office Access Group Mapping 정보를 삭제한다.<br>
	 * 
	 * @param List<OfcAccGrpMapVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeOfcAccGrpMap(List<OfcAccGrpMapVO> deleteSheetVoList) throws DAOException {
		try {
            //velocity parameter
            Map<String, Object> velParams = null;

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteSheetVoList.size() > 0){
                velParams = new HashMap<String, Object>();
                Map<String, String> mapVO = deleteSheetVoList.get(0).getColumnValues();
                velParams.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OrganizationDBDAORemoveOfcAccGrpMapDSQL(), deleteSheetVoList, velParams);
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
	 * BCM_CCD_0041 : Row Delete <br>
	 * 입력 및 조회된 Office Access Group Creation 정보를 추가한다.<br>
	 * 
	 * @param List<OfcAccGrpVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeOfcAccGrp(List<OfcAccGrpVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OrganizationDBDAORemoveOfcAccGrpDSQL(), deleteSheetVoList, null);
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
	 * BCM_CCD_0042 : Retrieve <br>
	 * 입력한 Office Access Group Mapping(Pop-up) 정보를 조회한다.<br>
	 * 
	 * @param String sybSysCd
	 * @param String ofcGrpId
	 * @return List<OfcAccGrpMapVO>
	 * @exception DAOException
	 */
	public List<OfcAccGrpMapVO> searchOfcAccGrpMap(String sybSysCd, String ofcGrpId) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfcAccGrpMapVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{			
			if(sybSysCd != null && ofcGrpId != null){			
				param.put("ofc_grp_id",ofcGrpId);
				param.put("sub_sys_cd",sybSysCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchOfcAccGrpMapRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcAccGrpMapVO.class);
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
	 * BCM_CCD_0042 : Save <br>
	 * 입력 및 조회된 Office Access Group Creation 정보를 추가한다.<br>
	 * 
	 * @param List<OfcAccGrpMapVO> insertSheetVoList
	 * @exception DAOException
	 */
	public void addOfcAccGrpMap(List<OfcAccGrpMapVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OrganizationDBDAOAddOfcAccGrpMapCSQL(), insertSheetVoList,null);
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
	 * BCM_CCD_0042 : Save <br>
	 * 입력 및 조회된 Office Access Group Creation 정보를 수정한다.<br>
	 * 
	 * @param List<OfcAccGrpMapVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyOfcAccGrpMap(List<OfcAccGrpMapVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateSheetVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OrganizationDBDAOModifyOfcAccGrpMapUSQL(), updateSheetVoList,null);
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
	 * BCM_CCD_0032 : Retrieve<br>
	 * Office Code 정보를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return OfcAccGrpVO
	 * @exception DAOException
	 */
	public List<OfficeVO> searchOfcCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{			
			if(ofcCd != null){			
				param.put("ofc_cd",ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchOfcCodeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeVO.class);
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
	 * BCM_CCD_0032 : Save <br>
	 * 입력 및 조회된 Organization 정보를 추가한다.<br>
	 * 
	 * @param OfficeVO ofcVO
	 * @exception DAOException
	 */
	public void addOfcCode(OfficeVO ofcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(ofcVO != null){
				Map<String, String> mapVO = ofcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OrganizationDBDAOAddOfcCodeCSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
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
	 * BCM_CCD_0032 : Save <br>
	 * 입력 및 조회된 Organization 정보를 추가한다.<br>
	 * 
	 * @param OfficeVO ofcVO
	 * @return int
	 * @exception DAOException
	 */
	public int isInvPrefixUnique(OfficeVO ofcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		int result = 0;
		try{
			param.put("ofc_cd", ofcVO.getOfcCd());
			param.put("inv_pfx_cd", ofcVO.getInvPfxCd());
			velParam.put("ofc_cd", ofcVO.getOfcCd());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchIsInvPrefixUniqueRSQL(), param, velParam);			

			if (dbRowset.next()){
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
	 * BCM_CCD_0032 : Save <br>
	 * 입력 및 조회된 Organization 정보를 수정한다.<br>
	 * 
	 * @param OfficeVO ofcVO
	 * @exception DAOException
	 */
	public void modifyOfcCode(OfficeVO ofcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(ofcVO != null){
				Map<String, String> mapVO = ofcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OrganizationDBDAOModifyOfcCodeUSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
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
	 * BCM_CCD_0032 : Save <br>
	 * 입력 및 조회된 Organization 정보를 수정한다.<br>
	 * 
	 * @param String vndrSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchVnderCntCd(String vndrSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String result = null;
		try{
			 param.put("vndr_seq", vndrSeq);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchVndrCntCDUSQL(), param, null);
				
			 if (dbRowset.next()){
				 result = 			 dbRowset.getString(1);
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
	 * Organization EAI I/F 정보를 생성한다.(BCM_CCD_0032) For EAI I/F process<br>
	 *  
	 * @param OfficeIfVO officeifVO
	 * @exception DAOException
	 */

	public void addOfcIf(OfficeIfVO officeifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(officeifVO != null){
				Map<String, String> mapVO = officeifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OrganizationDBDAOAddOfcIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Organization IBIS I/F 정보를 생성한다.(BCM_CCD_0032) For EAI I/F process<br>
	 *  
	 * @param OfficeIfVO officeifVO
	 * @exception DAOException
	 */

	public void addOfcIbisIf(OfficeIfVO officeifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(officeifVO != null){
				Map<String, String> mapVO = officeifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OrganizationDBDAOAddOfcIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Organization EAI I/F 의 테이블(MDM_ORGANIZATION_IF)의 OFC_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0032)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchOfcIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOSearchOfcIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}