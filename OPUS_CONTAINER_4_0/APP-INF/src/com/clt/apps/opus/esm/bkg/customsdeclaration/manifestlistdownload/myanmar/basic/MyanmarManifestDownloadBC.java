/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MyanmarManifestListDownloadBC.java
*@FileTitle : MyanmarManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-MyanmarManifestListDownload Business Logic Command Interface<br>
 * - OPUS-MyanmarManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see MyanmarManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface MyanmarManifestDownloadBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Myanmar Customs Manifest 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;


}
