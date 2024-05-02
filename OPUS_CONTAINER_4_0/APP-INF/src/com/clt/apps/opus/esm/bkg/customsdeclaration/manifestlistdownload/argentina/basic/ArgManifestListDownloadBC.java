/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArgManifestListDownloadBC.java
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.12.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.31 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Customsdeclaration Business Logic Command Interface<br>
 * - OPUS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM MINJUNG
 * @see 
 * @since J2EE 1.4
 */
public interface ArgManifestListDownloadBC {

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ArgManifestListDetailVO> searchManifestList(ArgManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 세관 신고 대상 List를 세관 테이블 내로 다운받는 작업
	 * @param manifestListDetailVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String manageManifest(ArgManifestListDetailVO[] manifestListDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * In Transit 값을 세관 테이블 내로 다운받는 작업
	 * @param manifestListDetailVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String saveManifest(ArgManifestListDetailVO[] manifestListDetailVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 삭제한다.
	 * @param ArgManifestListDetailVO[] manifestListDetailVO
	 * @return 
	 * @exception EventException
	 */
	public String deleteManifest(ArgManifestListDetailVO[] manifestListDetailVO) throws EventException;
}