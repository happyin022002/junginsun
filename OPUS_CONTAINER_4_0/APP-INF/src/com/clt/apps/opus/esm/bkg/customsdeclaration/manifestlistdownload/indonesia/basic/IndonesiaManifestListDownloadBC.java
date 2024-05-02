/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndonesiaManifestListDownloadBC.java
*@FileTitle : IndonesiaManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-IndonesiaManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface IndonesiaManifestListDownloadBC {

	/**
	 * Handling inquiry event<br>
	 * Retrieving Indonesian Customs transmitting data<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * Retrieving for Booking No input
	 *
	 * @param IndonesiaManifestListCondVO indonesiaManifestListCondVO
	 * @return List<indonesiaBkgDetailVO>
	 * @throws EventException
	 */
	public List<indonesiaBkgDetailVO> searchBkgInfo(IndonesiaManifestListCondVO indonesiaManifestListCondVO)
			throws EventException;
}
