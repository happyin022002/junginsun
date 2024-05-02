/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtBCImpl.java
*@FileTitle : DWC,Insurance 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.16 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration.FileMgtDBDAO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileDwcInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileInsuranceListVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 *  CNI 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  CNI 파일 첨부 관련 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon, Seyeong
 * @see FileMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FileMgtBCImpl extends BasicCommandSupport implements FileMgtBC {

	// Database Access Object
	private transient FileMgtDBDAO dbDao = null;

	/**
	 * FileMgtBCImpl 객체 생성<br>
	 * FileMgtDBDAO를 생성한다.<br>
	 */
	public FileMgtBCImpl() {
		dbDao = new FileMgtDBDAO();
	}
	/**
	 * Dry Wet Claim & Insurance File를 생성 및 변경한다.<br>
	 * 
	 * @param CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs
	 * @param List<String> keys
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageFileDwcInsurance(CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs, List<String> keys, String usrId) throws EventException{
		try {
			List<CustomFileDwcInsuranceVO> insertVoList = new ArrayList<CustomFileDwcInsuranceVO>();
			List<CustomFileDwcInsuranceVO> updateVoList = new ArrayList<CustomFileDwcInsuranceVO>();
			List<CustomFileDwcInsuranceVO> deleteVoList = new ArrayList<CustomFileDwcInsuranceVO>();
			
			int sizeKeys = 0;
			if (keys != null) sizeKeys = keys.size() - 1;
			
			for ( int i=0; i<customFileDwcInsuranceVOs .length; i++ ) {
				if ( customFileDwcInsuranceVOs[i].getIbflag().equals("I")){

					customFileDwcInsuranceVOs[i].setFileSavId(keys.get(sizeKeys));
					customFileDwcInsuranceVOs[i].setCreUsrId(usrId);
					insertVoList.add(customFileDwcInsuranceVOs[i]);
					sizeKeys--;
				} else if ( customFileDwcInsuranceVOs[i].getIbflag().equals("U")){
					customFileDwcInsuranceVOs[i].setUpdUsrId(usrId);
					updateVoList.add(customFileDwcInsuranceVOs[i]);
				} else if ( customFileDwcInsuranceVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customFileDwcInsuranceVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addFileDwcInsurances(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyFileDwcInsurances(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFileDwcInsurances(deleteVoList);
				for (int i=0; i<deleteVoList.size(); i++) {
					UpdateFileMetaInfo.delete(deleteVoList.get(i).getFileSavId());
				}
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09008",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09008",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Dry & Wet Claim의 File을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return List<SearchFileDwcInsuranceListVO>
	 * @exception EventException
	 */
	public List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceList(String dwClmNo) throws EventException {
	
		try {
			
			return dbDao.searchFileDwcInsuranceList(dwClmNo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category manageFileUpload 
	 * @param CniAtchFileVO[] cniAtchFileVOs
	 * @exception EventException
	 */
	public void manageFileUpload(CniAtchFileVO[] cniAtchFileVOs) throws EventException {

		try {		
			if (cniAtchFileVOs != null && cniAtchFileVOs.length > 0) {
				String userId = cniAtchFileVOs[0].getUpdUsrId();
				for (int i = 0; i < cniAtchFileVOs.length; i++) {
					CniAtchFileVO cniAtchFileVO = cniAtchFileVOs[i];
					cniAtchFileVO.setUpdUsrId(userId);
					cniAtchFileVO.setCreUsrId(userId);
					
					//카고클레임 "C"
					cniAtchFileVO.setClmBztpCd("C");					
					
					String ibflag = cniAtchFileVO.getIbflag();					
					if ("I".equals(ibflag)) {	
						dbDao.addFileUpload(cniAtchFileVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeFileUpload(cniAtchFileVO);
					}  else if ("U".equals(ibflag)) {
						dbDao.modifyFileUpload(cniAtchFileVO);
					}
				}				
			} 			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param FileUploadCondVO fileUploadCondVO
	 * @return List<FileUploadVO> 
	 * @exception EventException
	 */
	public List<FileUploadVO> searchFileUploadList(FileUploadCondVO fileUploadCondVO) throws EventException {
	
		try {			
			return dbDao.searchFileUploadList(fileUploadCondVO);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Insurance의 File을 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @param String clmFileTpCd
	 * @return List<SearchFileInsuranceListVO>
	 * @exception EventException
	 */
	public List<SearchFileInsuranceListVO> searchFileInsuranceList(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd, String clmFileTpCd) throws EventException {
	
		try {
			
			return dbDao.searchFileInsuranceList(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd, clmFileTpCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Insurance File을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception EventException
	 */
	public void removeInsuranceFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException {
	
		try {
			
			dbDao.removeInsuranceFile(insurTpCd, insurPlcyYr, insurClmPtyNo);
			dbDao.removePremiumFile(insurTpCd, insurPlcyYr, insurClmPtyNo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09060",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09060",new String[]{}).getMessage(), ex);
		}
		
	}	
	
	/**
	 * Insurance Premium File을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception EventException
	 */
	public void removePremiumFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException {
	
		try {
			
			dbDao.removePremiumTypeFile(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09061",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09061",new String[]{}).getMessage(), ex);
		}
		
	}	
	
}