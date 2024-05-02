/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestListDownloadBackEndBC.java
*@FileTitle : ManifestListDownloadBackEndBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 23.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 23. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic;

/**
 * BACK END Process 처리를 위한 BC Interface
 * 
 * @author 박상훈
 * @see
 * @since J2EE 1.4
 */
public interface ManifestListDownloadBackEndBC {

	/**
	 * BackEndJob 처리 메소드
	 * @param String usrId 
	 * @return String
	 */
	public String startBackEndBC(String usrId);
}
