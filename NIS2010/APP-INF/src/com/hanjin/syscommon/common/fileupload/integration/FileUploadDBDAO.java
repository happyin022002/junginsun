/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FileUploadDBDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Apr 23, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.common.fileupload.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.attachment.file.support.FileUploadDAOComUpldFileRSQL;
import com.hanjin.framework.component.databasedata.FileDatabaseData;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.table.ComUpldFileVO;

/**
 * It's FileUploadDBDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Apr 23, 2009
 */
public class FileUploadDBDAO extends DBDAOSupport{

	/**
	 * This method updates a File Meta Data. 
	 * @author Jeong-Hoon, KIM
	 * @param fileMetaData
	 * @param target
	 * @throws DAOException
	 */
	public void updateFileMetadata(FileDatabaseData fileMetaData, String target) throws DAOException {
		Map<String,String> mapParam = new HashMap<String,String>();
		
		try {
			mapParam.put("pgm_sub_sys_cd", target);
			mapParam.put("file_path_url", fileMetaData.getParentDirectoryPath()+"/"+target);
			mapParam.put("file_sav_id", fileMetaData.getFileSavId());
			new SQLExecuter("SysComDB").executeUpdate(new FileUploadDAOModulePathUSQL(), mapParam, null);
		} catch (SQLException e) {
			this.log.error("[SQLException]"+e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (DAOException e) {
			this.log.error("[DAOException]"+e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			this.log.error("[Exception]"+e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * 
	 * @param fileKey
	 * @return
	 * @throws DAOException
	 */
	public ComUpldFileVO selectComUpldFile(String fileKey)throws DAOException{
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("file_sav_id", fileKey);
		List<ComUpldFileVO> list = null;
		try {
			DBRowSet dbRowSet = new SQLExecuter().executeQuery(new FileUploadDAOComUpldFileRSQL(), mapParam, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, ComUpldFileVO.class);	
			if(list != null) return list.get(0);
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw new DAOException(e);
		} catch (IndexOutOfBoundsException e) {
			throw new DAOException(e);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return null;
	}
}
