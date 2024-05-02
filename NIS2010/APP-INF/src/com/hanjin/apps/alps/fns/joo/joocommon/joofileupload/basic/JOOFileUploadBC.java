/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFileUploadBC.java
*@FileTitle : JO Member Information 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.08 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 *  JOO 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  JOO 파일 첨부 관련 비지니스 로직을 처리한다.<br>
 *
 * @author 이준범
 * @see JooFileUploadBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public interface JOOFileUploadBC {
	
	/**
	 * File Upload 리스트 조회<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category searchFileUploadList 
	 * @param String joCrrCd
	 * @param String crrCntcSeq
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchFileUploadList(String joCrrCd, String crrCntcSeq) throws EventException;	
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category manageFileUpload 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @exception EventException
	 */
	public void manageFileUpload(FileUploadListVO[] fileUploadListVOs) throws EventException;	

	/**
	 * File Upload 리스트 조회<br>
	 * @author 이준범
	 * @category FNS_JOO_0098
	 * @category searchCsrFileUploadList 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadList(String csrNo) throws EventException;	
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * @author 이준범
	 * @category FNS_JOO_0098
	 * @category manageFileUpload 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @exception EventException
	 */
	public void manageCsrFileUpload(FileUploadListVO[] fileUploadListVOs) throws EventException;		
		
	/**
	 * File Upload Info 조회<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @category searchFileUploadInfo
	 * @param FileUploadInfoVO fileUploadInfoVO
	 * @return List<FileUploadInfoVO>
	 * @exception EventException
	 */
	public List<FileUploadInfoVO> searchFileUploadInfo(FileUploadInfoVO fileUploadInfoVO) throws EventException;

	/**
	 * File Upload 삭제 ,입력<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @category manageFileUploadInfo
	 * @param FileUploadInfoVO[] fileUploadInfoVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageFileUploadInfo(FileUploadInfoVO[] fileUploadInfoVOs) throws EventException;

}