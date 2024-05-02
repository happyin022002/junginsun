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
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 *  JOO 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  JOO 파일 첨부 관련 비지니스 로직을 처리한다.<br> 
 *
 * @author 이준범
 * @see JooFileUploadBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public interface FMSFileUploadBC {
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param String vslCd
	 * @param String vnorSeq
	 * @param String vnorItmSeq
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadList(String vslCd, String vnorSeq, String vnorItmSeq) throws EventException;	
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @param String vslCd
	 * @param String vnorSeq
	 * @param String vnorItmSeq
	 * @exception EventException
	 */
	public void manageCsrFileUpload(FileUploadListVO[] fileUploadListVOs, String vslCd, String vnorSeq, String vnorItmSeq) throws EventException;		

	/**
	 * Owner's Account File Upload 리스트 조회<br>
	 * 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadListOA(String csrNo) throws EventException;	

	
	/**
	 * Owner's Account File Upload 삭제 ,입력<br>
	 * 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @param String csrNo
	 * @exception EventException
	 */
	public void manageCsrFileUploadOA(FileUploadListVO[] fileUploadListVOs, String csrNo) throws EventException;		
	
}