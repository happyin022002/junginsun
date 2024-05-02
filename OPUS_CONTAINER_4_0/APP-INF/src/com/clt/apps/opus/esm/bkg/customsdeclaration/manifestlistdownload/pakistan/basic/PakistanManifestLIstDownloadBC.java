/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PakistanManifestListDownloadBC.java
*@FileTitle : PakistanManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-PakistanManifestListDownload Business Logic Command Interface<br>
 * - OPUS-PakistanManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see PakistanManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface PakistanManifestLIstDownloadBC {

	/**
	 * 파키스탄 세관 - VVD, B/L, CNTR 정보 조회
	 *
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;


}
