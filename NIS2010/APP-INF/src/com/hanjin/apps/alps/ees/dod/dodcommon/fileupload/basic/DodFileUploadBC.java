/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadBC.java
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

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Fileupload Business Logic Command Interface<br>
 * - ALPS-Fileupload에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6
 */

public interface DodFileUploadBC {

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
	public List<FileUploadListVO> searchDodFileUploadList(String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller, String atchFileLnkId) throws EventException;
	
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
	public String manageDodFileUpload(FileUploadListVO[] fileUploadListVO, String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller, String preAtchFileLnkId, SignOnUserAccount account) throws EventException;
}