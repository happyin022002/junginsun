/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MalaysiaManifestDownloadBC.java
*@FileTitle : MalaysiaManifestDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-MalaysiaManifestDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface MalaysiaManifestDownloadBC {

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param MalaysiaManifestListCondVO malaysiaManifestListCondVO
	 * @return MalaysiaManifestListVO
	 * @exception EventException
	 */
	public MalaysiaManifestListVO searchManifestList(MalaysiaManifestListCondVO malaysiaManifestListCondVO) throws EventException;

	/**
	 * Malaysia Import Status I/F 조회
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return MalaysiaImpStsVO
	 * @exception EventException
	 */
	public MalaysiaImpStsVO searchImpSts(MalaysiaImpStsVO malaysiaImpStsVO) throws EventException;

	/**
	 * ESM_BKG_1522 : Save - Back End Job 시작<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO[] malaysiaImpStsVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobManageImpSts(MalaysiaImpStsVO[] malaysiaImpStsVOs, SignOnUserAccount account, String pgmNo) throws EventException;

	/**
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO[] malaysiaImpStsVOs
	 * @exception EventException
	 */
	public void manageImpSts(MalaysiaImpStsVO[] malaysiaImpStsVOs) throws EventException;

	/**
	 * ESM_BKG_1522 : Save - Back End Job 결과<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageImpSts(String backEndJobKey) throws EventException;

	/**
	 * Malaysia Vessel 정보 조회
	 *
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return MalaysiaVvdVO[]
	 * @exception EventException
	 */
	public MalaysiaVvdVO[] searchVslRegist(MalaysiaVvdVO malaysiaVvdVO) throws EventException;

	/**
	 * Malaysia Vessel Name 조회
	 *
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVslName(MalaysiaVvdVO malaysiaVvdVO) throws EventException;

	/**
	 * Malaysia Vessel 정보 수정
	 *
	 * @param MalaysiaVvdVO[] malaysiaVvdVOs
	 * @exception EventException
	 */
	public void manageVVDInfo(MalaysiaVvdVO[] malaysiaVvdVOs) throws EventException;

	/**
	 * Malaysia Import Status Special Cargo의 정보를 조회
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception EventException
	 */
	public ImpStsSpclCgoVO searchImpoStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException;

	/**
	 * Malaysia Import Status Special Cargo 정보 추가/수정/삭제 처리
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception EventException
	 */
	public void manageImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException;

	/**
	 * Malaysia Vessel Import Schedule 조회
	 *
	 * @param String portCd
	 * @param String etbDt1
	 * @param String etbDt2
	 * @return MalaysiaVvdVO[]
	 * @exception EventException
	 */
	public MalaysiaVvdVO[] searchVVD(String portCd, String etbDt1, String etbDt2) throws EventException;

}

