/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtBC.java
*@FileTitle : DWC,Insurance 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.16 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.FileUploadCondVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.SearchFileDwcInsuranceListVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.SearchFileInsuranceListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 *  CNI 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  CNI 파일 첨부 관련 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon, Seyeong
 * @see FileMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public interface FileMgtBC {
	
	/**
	 * Dry Wet Claim & Insurance File를 생성 및 변경한다.<br>
	 * 
	 * @param CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs
	 * @param List<String> keys
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageFileDwcInsurance(CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs, List<String> keys, String usrId) throws EventException;
	
	/**
	 * Dry & Wet Claim의 File을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return List<SearchFileDwcInsuranceListVO>
	 * @exception EventException
	 */
	public List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceList(String dwClmNo) throws EventException ;
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param FileUploadCondVO fileUploadCondVO
	 * @return List<FileUploadVO> 
	 * @exception EventException
	 */
	public List<FileUploadVO> searchFileUploadList(FileUploadCondVO fileUploadCondVO) throws EventException;	
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category manageFileUpload 
	 * @param CniAtchFileVO[] cniAtchFileVOs
	 * @exception EventException
	 */
	public void manageFileUpload(CniAtchFileVO[] cniAtchFileVOs) throws EventException;	
	
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
	public List<SearchFileInsuranceListVO> searchFileInsuranceList(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd, String clmFileTpCd) throws EventException ;
	
	/**
	 * Insurance File을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception EventException
	 */
	public void removeInsuranceFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException ;
	
	/**
	 * Insurance Premium File을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception EventException
	 */
	public void removePremiumFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException ;
}