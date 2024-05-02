/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadBCImpl.java
*@FileTitle : DOD File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration.DodFileUploadDBDAO;
import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-FileUpload Business Logic Command Interface<br>
 * - ALPS-FileUpload에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6
 */
public class DodFileUploadBCImpl extends BasicCommandSupport implements DodFileUploadBC {

	// Database Access Object
	private transient DodFileUploadDBDAO dbDao = null;

	/**
	 * DodFileUploadBCImpl 객체 생성<br>
	 * DodFileUploadDBDAO를 생성한다.<br>
	 */
	public DodFileUploadBCImpl() {
		dbDao = new DodFileUploadDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String drpOffChgSeq
	 * @param String drpOffChgTrfSeq
	 * @param String caller
	 * @param String atchFileLnkId
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchDodFileUploadList(String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller, String atchFileLnkId) throws EventException {
		try {
			return dbDao.searchDodFileUploadList(bkgNo, cntrNo, drpOffChgSeq, drpOffChgTrfSeq, caller, atchFileLnkId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String drpOffChgSeq
	 * @param String drpOffChgTrfSeq
	 * @param String caller
	 * @param String preAtchFileLnkId
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public String manageDodFileUpload(FileUploadListVO[] fileUploadListVOs, String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller, String preAtchFileLnkId, SignOnUserAccount account) throws EventException{
		try {
			log.debug("\rcaller : " + caller);
			String atchFileLnkId = dbDao.searchAtchFileLnkId(bkgNo, cntrNo, drpOffChgSeq, drpOffChgTrfSeq, caller);
			
			if("".equals(atchFileLnkId)) { // DOD Charge 테이블에 데이터가 없을때 생성한다.
				if("".equals(preAtchFileLnkId)) { // 이전 첨부된 파일의 링크 아이디가 없으면
					atchFileLnkId = dbDao.createAtchFileLnkId();										
				}else{
					atchFileLnkId = preAtchFileLnkId;
				}
			}
			log.debug("\ratchFileLnkId : " + atchFileLnkId + " | fileUploadListVOs.length : " + fileUploadListVOs.length);
			
			for ( int i = 0; i < fileUploadListVOs.length; i ++ ) {
				FileUploadListVO fileUploadListVO = fileUploadListVOs[i];
				fileUploadListVO.setBkgNo(bkgNo);
				fileUploadListVO.setCntrNo(cntrNo);
				fileUploadListVO.setDrpOffChgSeq(drpOffChgSeq);
				fileUploadListVO.setDrpOffChgTrfSeq(drpOffChgTrfSeq);
				fileUploadListVO.setUpdUsrId(account.getUsr_id());
				fileUploadListVO.setAtchFileLnkId(atchFileLnkId);
				
				String ibflag = fileUploadListVO.getIbflag();

				if ("I".equals(ibflag)){
					dbDao.addFileUpload(fileUploadListVO);
					
					if("CHG".equals(caller)) { // Charge
						if(!"".equals(drpOffChgSeq) && drpOffChgSeq != null) {
							dbDao.updateDodDrpOffChg(fileUploadListVO);	
						}
					}else{ // Tariff
						dbDao.updateDodDrpOffChgTrf(fileUploadListVO);
					}
					
				} else if ("U".equals(ibflag)){
					dbDao.modifyFileUpload(fileUploadListVO);
					
				} else if ("D".equals(ibflag)){
					dbDao.removeFileUpload(fileUploadListVO);
					
				}
					
			}
			return atchFileLnkId;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}