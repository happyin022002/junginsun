/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamManifestListDownloadBC.java
*@FileTitle : VietnamManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-VietnamManifestListDownload Business Logic Command Interface<br>
 * - OPUS-VietnamManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see VietnamManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface VietnamManifestDownloadBC {

	/**
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;


}
