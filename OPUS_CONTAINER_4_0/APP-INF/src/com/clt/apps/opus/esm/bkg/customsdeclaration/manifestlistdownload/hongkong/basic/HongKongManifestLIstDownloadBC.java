/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : HongKongManifestLIstDownloadBC.java
*@FileTitle : HongKongManifestLIstDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-HongKongManifestLIstDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface HongKongManifestLIstDownloadBC {

	/**
	 * retrieve event handling<br>
	 * retrieve event handling about CustomsDeclaration screen<br>
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;
}
