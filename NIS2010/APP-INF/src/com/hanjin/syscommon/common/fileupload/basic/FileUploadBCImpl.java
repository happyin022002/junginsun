/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FileUploadBCImpl.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Apr 22, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.common.fileupload.basic;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;

import com.hanjin.framework.component.attachment.file.upload.FileUploadSaver;
import com.hanjin.framework.component.databasedata.FileDatabaseData;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.file.FileTools;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.table.ComUpldFileVO;
import com.hanjin.syscommon.common.fileupload.integration.FileUploadDBDAO;

/**
 * It's FileUploadBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Apr 22, 2009
 */
public class FileUploadBCImpl extends BasicCommandSupport implements FileUploadBC {
	
	private FileUploadDBDAO dbDao = null;
	
	public FileUploadBCImpl(){
		dbDao = new FileUploadDBDAO();
	}
	
	/**
	 * File Upload 시 File을 이동시키는 Method<br>
	 * @author Jeong-Hoon, KIM
	 * @param keys
	 * @param target
	 * @throws EventException
	 */
	public void moveUploadFile(List<String> keys, String target) throws EventException {
		for(String key:keys){
			
			FileDatabaseData fileMetaData;
			try {
				fileMetaData = new FileDatabaseData(key);
				FileTools.move(fileMetaData.getRealFileFullPath(), fileMetaData.getParentDirectoryPath()+"/"+target+"/"+fileMetaData.getFileSavId());
				FileUploadDBDAO fileUploadDBDAO = new FileUploadDBDAO();
				fileUploadDBDAO.updateFileMetadata(fileMetaData, target);
			} catch (IOException e) {
				this.log.error("[IOException]" + e);
				throw new EventException("[IOException]" + e);
			} catch (SQLException e) {
				this.log.error("[SQLException]" + e);
				throw new EventException("[SQLException]" + e);
			} catch (DAOException e) {
				this.log.error("[DAOException]" + e);
				throw new EventException("[DAOException]" + e);
			} catch (Exception e) {
				this.log.error("[Exception]" + e);
				throw new EventException("[Exception]" + e);
			}
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws EventException
	 */
	public String copyUploadFile(String key) throws EventException {
		List<String> keys = new ArrayList<String>();
		keys.add(key);
		try{
			List<String> newkeys = copyUploadFile(keys);
			if(newkeys != null) return newkeys.get(0);
		}catch(Exception e){
			this.log.error("[copyUploadFile File does not exist ]" + e);
		}
		return "";
	}
	
	/**
	 * 
	 * @param keys
	 * @return
	 * @throws EventException
	 */
	public List<String> copyUploadFile(List<String> keys) throws EventException {
		List<String> newkeys = new ArrayList<String>();
		for (int i = 0; i < keys.size(); i++) {
			ComUpldFileVO fileVo;
			try {
				fileVo = dbDao.selectComUpldFile(keys.get(i));
				if(fileVo != null){
					String ext = FilenameUtils.getExtension(fileVo.getFileUpldNm());
					String fileSavId = DateTime.getFormatString("yyyyMMdd") + RandomStringUtils.randomAlphanumeric(16) + "." + ext;
					File source = new File(fileVo.getFilePathUrl() + "/" + fileVo.getFileSavId());
					File destination = new File(fileVo.getFilePathUrl() + "/" + fileSavId);
					FileUtils.copyFile(source, destination);
					fileVo.setFileSavId(fileSavId);
					new FileUploadSaver(fileVo);
					newkeys.add(fileSavId);
				}
			} catch (IOException e) { 
				this.log.error("[IOException]" + e);
				throw new EventException("[IOException]" + e);
			} catch (DAOException e) {
				this.log.error("[DAOException]" + e);
				throw new EventException("[DAOException]" + e);
			} catch (Exception e) {
				this.log.error("[Exception]" + e);
				throw new EventException("[Exception]" + e);
			}
		}
		return newkeys;
	}
	
	/**
	 * 파일 존재 유무
	 * @param key
	 * @return
	 * @throws EventException
	 */
	public boolean fileDeleteCheck(String key)throws EventException {
		ComUpldFileVO fileVo;
		try {
			fileVo = dbDao.selectComUpldFile(key);
			if(fileVo != null){
				File source = new File(fileVo.getFilePathUrl() + "/" + fileVo.getFileSavId());
				if(source.isFile()) return true;
			}
		} catch (DAOException e) {
			this.log.error("[DAOException]" + e);
			throw new EventException("[DAOException]" + e);
		} catch (Exception e) {
			this.log.error("[Exception]" + e);
			throw new EventException("[Exception]" + e);
		}
		return false;
	}

}
