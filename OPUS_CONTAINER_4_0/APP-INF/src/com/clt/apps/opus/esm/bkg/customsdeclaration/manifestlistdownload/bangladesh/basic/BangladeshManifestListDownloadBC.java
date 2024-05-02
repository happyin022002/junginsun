/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshManifestListDownloadBC.java
*@FileTitle : BangladeshManifestListDownload Business Logic Command Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06 전창현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-BangladeshManifestListDownload Business Logic Command Interface<br>
 * - OPUS-BangladeshManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see BangladeshManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface BangladeshManifestListDownloadBC {

	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터)를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터)를 삭제/입력한다.<br>
	 *
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageManifest(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException;

}

