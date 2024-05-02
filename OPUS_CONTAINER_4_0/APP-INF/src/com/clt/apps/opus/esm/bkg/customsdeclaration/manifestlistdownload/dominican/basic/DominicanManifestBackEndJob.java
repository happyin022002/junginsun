/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DominicanManifestBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 경종윤
**@LastVersion : 1.0
* 2013.07.04 경종윤
* * 1.0 Creation
* -------------------------------------------------------
* History
* 
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-DominicanManifestBackEndJob Business Logic Command Interface<br>
 * - ALPS-DominicanManifestBackEndJob에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyoung Jong Yun
 * @see Esm_bkg_1162EventResponse 참조
 * @since J2EE 1.6
 */

public class DominicanManifestBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	
	private ManifestListCondVO manifestListCondVO;
	
	/**
	 * 생성자
	 * @param ManifestListCondVO manifestListCondVO
	 */
	public DominicanManifestBackEndJob (ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}
	
	/**
	 * BackEndCommand Start
	 * @return List<ManifestListDetailVO>
	 * @throws Exception
	 */
	public List<ManifestListDetailVO> doStart() throws Exception {
		List<ManifestListDetailVO> manifestListDetailVOs = null;
		try {
			DominicanManifestDownloadBC command = new DominicanManifestDownloadBCImpl();
			manifestListDetailVOs = command.searchManifestList(manifestListCondVO);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return manifestListDetailVOs;	
	}
}
