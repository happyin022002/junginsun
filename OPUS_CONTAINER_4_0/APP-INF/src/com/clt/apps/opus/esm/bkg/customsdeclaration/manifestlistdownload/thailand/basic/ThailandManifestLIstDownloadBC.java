/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ThailandManifestLIstDownloadBC.java
*@FileTitle : ThailandManifestLIstDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-ThailandManifestLIstDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface ThailandManifestLIstDownloadBC {

	/**
	 * Thailand 세관 신고용 VVD 정보 조회
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return
	 * @throws EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException;

	/**
	 * Thailand 세관 신고용 B/L LIST, CNTR LIST 정보 조회
	 *
	 * @param manifestListCondVO
	 * @return
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException ;

}
