/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ManilaManifestListDownloadBC.java
*@FileTitle : ManilaManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-ManilaManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface ManilaManifestListDownloadBC {

	/**
	 * Retrieve Manifest list about Cargo pass to Philippines.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * DBF file create and return file path to local .<br>
	 *
	 * @param manifestListDetailVO ManifestListDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifest(ManifestListDetailVO manifestListDetailVO) throws EventException;
}
