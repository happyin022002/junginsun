/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookmarkManagementDBDAO.java
*@FileTitle : BookMark Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.01.09
*@LastModifier : 이승
*@LastVersion : 1.0
* 2009.01.09 이승
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.bookmark.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComBookmarkVO;
import com.hanjin.syscommon.management.alps.bookmark.basic.BookmarkManagementBCImpl;
import com.hanjin.syscommon.management.alps.bookmark.vo.BookmarkListVO;
 



/**
 * NIS2010 ManagementDAO <br>
 * - NIS2010-Bookmark system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung_InSun
 * @see BookmarkManagementBCImpl 참조
 * @since J2EE 1.4
 */
public class BookmarkManagementDBDAO extends DBDAOSupport {

	/**
	 * 사용자의 즐겨찾기 정보를 불러온다.<br>
	 * 
	 * @param String usrId 사용자ID
	 * @return List<BookmarkListVO>	즐겨찾기 메뉴정
	 * @Exception DAOException
	 */
	public List<BookmarkListVO> searchBookmark(String usrId) throws DAOException {
		List<BookmarkListVO> searchComUsrRoleVOs = null;
		try{
 
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			
			searchComUsrRoleVOs = (List) new SQLExecuter("SysComDB").executeQuery(new BookmarkManagementDAOcomBookmarkRSQL(), mapParam,null,BookmarkListVO.class);
			
//			String sql = "INSERT INTO COM_BOOKMARK(USR_ID, PGM_NO, DP_SEQ, DP_NM,CRE_DT) VALUES ('NIS2010','TEST3',9,'"; 
//			sql +="DFDFD[]S%;;;;;;',',',', 가나 ]&,,','','',,SSS".replaceAll("\\'","\\''"); 
//			sql += "', SYSDATE)" ;
//			sql  = StringUtils.replace(sql, "]", "\\]");
//			mapParam.put("SQL", sql);
//			new SQLExecuter().executeUpdate(new DaoNameDAOtestvelocityCSQL(), null,mapParam);
//			DBRowSet rowset =  new SQLExecuter().executeQuery(new DaoNameDAOtestclobRSQL(), mapParam,null);
//			while(rowset.next()){
//				log.debug(rowset.getString("MK_DESC"));
//			}

//			List<TestCLOBVO> volist1= (List) new SQLExecuter().executeQuery(new DaoNameDAOtestclobRSQL(), mapParam,null, TestCLOBVO.class);
//			for(int i=0;i<volist1.size();i++){
//				log.debug("volist1.get(i).getMkDesc()=" + volist1.get(i).getMkDesc());
//			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchComUsrRoleVOs;
	}


	/**
	 * 사용자의 즐겨찾기 폴더 정보를 불러온다.<br>
	 * 
	 * @param String usrId 사용자ID
	 * @return List<BookmarkListVO>	즐겨찾기 폴더리스트 
	 * @Exception DAOException
	 */
	public List<BookmarkListVO> searchBookmarkFolderList(String usrId) throws DAOException {
//		DBRowSet dbRowset = null;
		List<BookmarkListVO> voList = null;
		try{

			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			
			voList = (List)new SQLExecuter("SysComDB").executeQuery(new BookmarkManagementDAOSearchBookmarkFolderRSQL(), mapParam,null,BookmarkListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return voList;
	}

	/**
	 * 즐겨찾기 정보를 추가한다.<br>
	 * 
	 * @param String usrId 사용자ID
	 * @param String pgmNo
	 * @param String dpNm
	 * @param String prntPgmNo
	 * @Exception DAOException
	 */
	public void addBookmark(String usrId, String pgmNo, String dpNm, String prntPgmNo) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			mapParam.put("pgm_no", pgmNo);
			mapParam.put("dp_nm", dpNm);
			if(!prntPgmNo.equals("")) {
				mapParam.put("prnt_pgm_no", prntPgmNo);
			}else{
				mapParam.put("prnt_pgm_no", "");
			}


			Map<String,Object> velParam = new HashMap<String,Object>();
//			if(!pgmNo.equals("")){
//				velParam.put("prnt_pgm_no", "1");
//			}else{
//				velParam.put("prnt_pgm_no", "");
//			}
			velParam.put("pgm_no", pgmNo);
			sqlExe.executeUpdate(new BookmarkManagementDAOComBookmarkCSQL(), mapParam, velParam); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기본 즐겨찾기 폴더인 DEFAULT를 추가한다.<br>
	 * 
	 * @param String usrId 사용자ID
	 * @param String pgmNo
	 * @param String dpNm
	 * @Exception DAOException
	 */
	public void addDefaultFolder(String usrId,String pgmNo,String dpNm) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			mapParam.put("pgm_no", pgmNo);
			mapParam.put("dp_nm", dpNm);
			mapParam.put("prnt_pgm_no", "");
			
			Map<String,Object> velParam = new HashMap<String,Object>();
			velParam.put("prnt_pgm_no","");
			sqlExe.executeUpdate(new BookmarkManagementDAOComBookmarkCSQL(), mapParam, velParam); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 즐겨찾기 정보를 삭제한다)<br>
	 * 
	 * @param String usrId 사용자ID
	 * @param String pgmNo Program No
	 * @Exception DAOException
	 */
	public void removeBookmark(String usrId, String pgmNo) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");

			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			mapParam.put("pgm_no", pgmNo);
			
			sqlExe.executeUpdate(new BookmarkManagementDAOComBookmarkDSQL(), mapParam, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 즐겨찾기 정보를 추가한다.)<br>
	 * 
	 * @param ComBookmarkVO comBookmarkVO 즐겨찾기 정보 
	 * @Exception DAOException
	 */	
	public void addBookmarks(ComBookmarkVO comBookmarkVO) throws DAOException {
		try {
			int insCnt ;
			Map<String,Object> velParam = new HashMap<String,Object>();
			Map<String,Object> mapParam = new HashMap<String, Object>();

			Map<String, String> mapVO = comBookmarkVO .getColumnValues();
				
			mapParam.putAll(mapVO);
			velParam.put("prnt_pgm_no","");
			
			insCnt = new SQLExecuter("SysComDB").executeUpdate(new BookmarkManagementDAOComBookmarkCSQL(), mapParam,velParam);
				if(insCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No SQL");
	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 즐겨찾기 정보를 수정한다.)<br>
	 * 
	 * @param Collection<ComBookmarkVO> comBookmarkVOs 즐겨찾기 정보 
	 * @Exception DAOException
	 */	
	public void modifyBookmarks(Collection<ComBookmarkVO> comBookmarkVOs) throws DAOException {
		try {
			int[] updCnt = null;
			Map<String,Object> velParam = new HashMap<String,Object>();
			
			velParam.put("prnt_pgm_no","");
			
			updCnt = new SQLExecuter("SysComDB").executeBatch(new BookmarkManagementDAOComBookmarkUSQL(), comBookmarkVOs,velParam);
			for(int i=0;i<updCnt.length;i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * 즐겨찾기 정보를 삭제한다.)<br>
	 * 
	 * @param Collection<ComBookmarkVO> comBookmarkVOs 즐겨찾기 정보 
	 * @Exception DAOException
	 */	
	public void removeBookmarks(Collection<ComBookmarkVO> comBookmarkVOs) throws DAOException {
		try {
			int[] delCnt = null;
			Map<String,Object> velParam = new HashMap<String,Object>();
			
			velParam.put("prnt_pgm_no","");
			
			delCnt = new SQLExecuter("SysComDB").executeBatch(new BookmarkManagementDAOComBookmarkDSQL(), comBookmarkVOs,velParam);
			for(int i=0;i<delCnt.length;i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * 북마크에 프로그램이 사용권한이 있는지 체크
	 * @param usrId
	 * @param pgmNo
	 * @return
	 * @throws DAOException
	 */
	public String searchPgmNoAuthority(String usrId, String pgmNo) throws DAOException {
		DBRowSet dbRowset = null;
		try{
 
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("usr_id", usrId);
			mapParam.put("pgm_no", pgmNo);
			
			dbRowset = new SQLExecuter("SysComDB").executeQuery(new BookmarkManagementDAOcomBookmarkRoleCheckRSQL(), mapParam, null);
			while (dbRowset.next()) {
				return dbRowset.getString("FLG");
			}	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return "N";
	}
}
