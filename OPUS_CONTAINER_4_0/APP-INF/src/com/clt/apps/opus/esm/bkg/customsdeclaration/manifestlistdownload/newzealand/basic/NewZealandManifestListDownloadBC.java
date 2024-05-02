/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestListDownloadBC.java
*@FileTitle : NewZealandManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdRefNoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdRefNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-NewZealandManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface NewZealandManifestListDownloadBC {

	/**
	 * NewZealand 세관 신고용 VVD 정보 조회
	 *
	 * @param NewZealandCstmsVvdInfoCondVO cstmsVvdInfoCondVO
	 * @return List<NewZealandCstmsVvdInfoCondVO>
	 * @throws EventException
	 */
	public List<NewZealandCstmsVvdInfoCondVO> searchCstmsVvdInfo(NewZealandCstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException;

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<NewZealandCstmsMfVO>
	 * @throws EventException
	 */
	public List<NewZealandCstmsMfVO> searchManifestList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws EventException;

	/**
	 *  세관 적하 목록 상세 정보를 조회
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<NewZealandCstmsMfDtl2VO>
	 * @exception EventException
	 */
	public List<NewZealandCstmsMfDtl2VO> searchCstmsMfDtlList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws EventException;

	/**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 *
	 * @param NewZealandCstmsVvdInfoVO[] cstmsVvdInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(NewZealandCstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 *
	 * @param NewZealandCstmsVvdRefNoCondVO cstmsVvdRefNoCondVO
	 * @return NewZealandCstmsVvdRefNoVO
	 * @throws EventException
	 */
	public NewZealandCstmsVvdRefNoVO createCstmsVvdRefNo(NewZealandCstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException;

}
