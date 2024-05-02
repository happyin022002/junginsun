/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : WharfageDecMgtBC.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCgoClassCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfConfirmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgKrWhfCfmVO;
import com.clt.syscommon.common.table.BkgUsaWhfSndHisVO;

/**
 * OPUS-WharfageMgt Business Logic Command Interface<br>
 * - OPUS-WharfageMgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JAE YOEB JEUNG
 * @see
 * @since J2EE 1.4
 */
public interface WharfageDecMgtBC {
	/**
	 * Wharfage 신고 부두 코드 조회
	 *
	 * @param WhfBerthCdCondVO whfBerthCdCondVO 조회조건
	 * @return List<WhfBerthCdVO>
	 * @throws EventException
	 */
	public List<WhfBerthCdVO> searchWhfBerthCd(WhfBerthCdCondVO whfBerthCdCondVO) throws EventException;

	/**
	 * Wharfage 신고 부두 코드 관리 (생성, 정정, 삭제)
	 *
	 * @param List<WhfBerthCdVO> whfBerthCdVOs 신고부두코드
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfBerthCd(List<WhfBerthCdVO> whfBerthCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Port별 Wharfage 신고 요율 수정
	 *
	 * @param WhfPortRtVO[] whfPortRtVOs 신고요율
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfPortRt(WhfPortRtVO[] whfPortRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 항구 별 Wharfage 신고 요율 조회
	 *
	 * @param WhfPortRtListCondVO whfPortRtListCondVO 조회조건
	 * @return List<WhfPortRtVO>
	 * @throws EventException
	 */
	public List<WhfPortRtVO> searchWhfPortRtList(WhfPortRtListCondVO whfPortRtListCondVO) throws EventException;

	/**
	 * Wharfage 신고 대상 B/L 및 운임 정보 조회
	 *
	 * @param WhfChgListCondVO whfChgListCondVO 조회조건
	 * @return List<WhfChgVO>
	 * @throws EventException
	 */
	public List<WhfChgVO> searchWhfChgList(WhfChgListCondVO whfChgListCondVO) throws EventException;

	/**
	 * Wharfage 선박 정보 (ETD, MRN) 조회
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO 조회조건
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	public WhfVslInfoVO searchWhfVslEtdMrn(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException;

	/**
	 * Wharfage 신고 대상 선박 정보 조회
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO 조회조건
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	public WhfVslInfoVO searchWhfVslInfo(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException;

	/**
	 * Wharfage 신고 선박 정보 관리
	 *
	 * @param WhfVslInfoVO whfVslInfoVO 신고 선박 정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfVslInfo(WhfVslInfoVO whfVslInfoVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage Location Code 정보 조회
	 *
	 * @param WhfLocCdListCondVO whfLocCdListCondVO 조회조건
	 * @return List<WhfLocCdVO>
	 * @throws EventException
	 */
	public List<WhfLocCdVO> searchWhfLocCdList(WhfLocCdListCondVO whfLocCdListCondVO) throws EventException;

	/**
	 * Wharfage Location Code 관리
	 *
	 * @param List<WhfLocCdVO> whfLocCdVOs Wharfage Location Code
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfLocCd(List<WhfLocCdVO> whfLocCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고 내역 확정
	 *
	 * @param WhfConfirmVO whfConfirmVO Wharfage 신고 내역
	 * @param SignOnUserAccount account
	 * @return BkgKrWhfCfmVO
	 * @throws EventException
	 */
	public BkgKrWhfCfmVO makeWhfConfirm(WhfConfirmVO whfConfirmVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고 대상 B/L 정보 추가 하기 위해 B/L 정보 조회 함
	 *
	 * @param BlCondVO blCondVO 조회조건
	 * @return BlVO
	 * @throws EventException
	 */
	public BlVO searchBl(BlCondVO blCondVO) throws EventException;

	/**
	 * WHF charge code가 포함된 목록 조회
	 *
	 * @param WhfRateListCondVO whfRateListCondVO 조회조건
	 * @return List<WhfRateVO>
	 * @throws EventException
	 */
	public List<WhfRateVO> searchWhfRateList(WhfRateListCondVO whfRateListCondVO) throws EventException;

	/**
	 * 한국 세관에 신고 된 B/L 중 WHF 신고 누락 분이 있는지 조회
	 *
	 * @param WhfBlChkListCondVO whfBlChkListCondVO 조회조건
	 * @return List<WhfBlChkVO>
	 * @throws EventException
	 */
	public List<WhfBlChkVO> searchWhfBlChkList(WhfBlChkListCondVO whfBlChkListCondVO) throws EventException;

	/**
	 * Wharfage 면제 Commoidty 목록 조회
	 *
	 * @param WhfExceptCmdtListCondVO whfExceptCmdtListCondVO 조회조건
	 * @return List<WhfExceptCmdtVO>
	 * @throws EventException
	 */
	public List<WhfExceptCmdtVO> searchWhfExceptCmdtList(WhfExceptCmdtListCondVO whfExceptCmdtListCondVO)
			throws EventException;

	/**
	 * Wharfage 면제 Commodity 관리
	 *
	 * @param WhfExceptCmdtVO[] whfExceptCmdtVOs Wharfage 면제 Commodity
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfExceptCmdt(WhfExceptCmdtVO[] whfExceptCmdtVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * WHF BL 목록 조회
	 *
	 * @param WhfBlListCondVO whfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	public List<WhfBlVO> searchWhfBlList(WhfBlListCondVO whfBlListCondVO) throws EventException;

	/**
	 * WHF BL 목록 조회
	 *
	 * @param WhfBlListCondVO whfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	public List<WhfBlVO> searchWhfBlCntrList(WhfBlListCondVO whfBlListCondVO) throws EventException;

	/**
	 * 다운로드 받은 WHF BL 정보 관리
	 *
	 * @param WhfBlVO[] whfBlVOs WHF BL 정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfBl(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Berth 등 부가 정보 조회
	 *
	 * @param WhfEmlListCondVO whfEmlListCondVO 조회조건
	 * @return List<WhfEmlVO>
	 * @throws EventException
	 */
	public List<WhfEmlVO> searchWhfEmlList(WhfEmlListCondVO whfEmlListCondVO) throws EventException;

	/**
	 * Berth 등 부가 정보 관리
	 *
	 * @param WhfEmlVO[] whfEmlVOs Berth 등 부가 정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfEml(WhfEmlVO[] whfEmlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * BL 및(또는) 한국 세관 테이블로 부터 한국 WHF 신고 대상 BL 목록을 한국 WHF 관리 테이블로 다운로드 받음
	 *
	 * @param WhfBlVO[] whfBlVOs BL정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void downloadWhfBlList(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfaeg 전송을 위한 사전 정보 조회
	 *
	 * @param WhfSendCondVO whfSendCondVO 조회조건
	 * @return WhfSendVO
	 * @throws EventException
	 */
	public WhfSendVO searchWhfSend(WhfSendCondVO whfSendCondVO) throws EventException;

	/**
	 * WHF 신고 현황 조회
	 *
	 * @param WhfDecChkListCondVO whfDecChkListCondVO 조회조건
	 * @return List<WhfDecChkVO>
	 * @throws EventExceptionm
	 */
	public List<WhfDecChkVO> searchWhfDecChkList(WhfDecChkListCondVO whfDecChkListCondVO) throws EventException;

	/**
	 * 화물입항료 대납경비 청구서 조회
	 *
	 * @param WhfCommInvListCondVO whfCommInvListCondVO 조회조건
	 * @return List<WhfCommInvListVO>
	 * @throws EventException
	 */
	public List<WhfCommInvListVO> searchWhfCommInvList(WhfCommInvListCondVO whfCommInvListCondVO) throws EventException;

	/**
	 * Wharfage Table Download
	 *
	 * @param WhfBlListCondVO whfBlListCondVO 조회조건
	 * @return String
	 * @throws EventException
	 */
	public String downloadWhfBlCntr(WhfBlListCondVO whfBlListCondVO) throws EventException;

	/**
	 * Wharfage 신고 물량 정보 업데이트
	 *
	 * @param WhfCommInvVO[] whfCommInvVOs Wharfage 신고 물량 정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfCommInv(WhfCommInvVO[] whfCommInvVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 한국 WHF 신고 대상 BL을 분류 함 (면제 대상 등)
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO 조회조건
	 * @return List<WhfVslInfoVO>
	 * @throws EventException
	 */
	public List<WhfVslInfoVO> searchWhfMrnSailDt(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException;

	/**
	 * Wharfage Send Table Download
	 *
	 * @param WhfSendCondVO whfSendCondVO 조회조건
	 * @return String
	 * @throws EventException
	 */
	public String downloadWhfSend(WhfSendCondVO whfSendCondVO) throws EventException;

	/**
	 * Wharfage 신고정보 관리
	 *
	 * @param WhfSendVO whfSendVO Wharfage 신고전송정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfSend(WhfSendVO whfSendVO, SignOnUserAccount account) throws EventException;

	/**
	 * 한국 WHF 신고 대상 BL을 분류 함 (면제 대상 등)
	 *
	 * @param WhfCgoClassCondVO whfCgoClassCondVO 조회조건
	 * @return List<WhfBlInfoVO>
	 * @throws EventException
	 */
	public List<WhfBlInfoVO> searchWhfCgoClass(WhfCgoClassCondVO whfCgoClassCondVO) throws EventException;

	/**
	 * B/L 별 Wharfage 면제 정보 (면제 사유 등) 조회
	 *
	 * @param WhfExemptInfoCondVO whfExemptInfoCondVO 조회조건
	 * @return WhfExemptInfoVO
	 * @throws EventException
	 */
	public WhfExemptInfoVO searchWhfExemptInfo(WhfExemptInfoCondVO whfExemptInfoCondVO) throws EventException;

	/**
	 * Wharfage Send Fax
	 *
	 * @param List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs Wharfage Send Fax
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendWhfDeclFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
		throws EventException;

	/**
	 * Wharfage Send E-mail
	 *
	 * @param List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs Wharfage Send E-mail
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendWhfDeclEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
		throws EventException;

	/**
	 * Wharfage Send E-mail
	 *
	 * @param List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendWhfExptTsEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
		throws EventException;

	/**
	 * Wharfage Send Fax
	 *
	 * @param List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendWhfExptTsFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
		throws EventException;

	/**
	 * Wharfage 신고 대상 조회
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @return WhfDecVO
	 * @throws EventException
	 */
	public WhfDecVO searchWhfDec(WhfDecCondVO whfDecCondVO) throws EventException;

	/**
	 * Wharfage 신고
	 *
	 * @param WhfDecVO whfDecVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageWhfDec(WhfDecVO whfDecVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고 check
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchSendCheck(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고 번호 변경 내역 인터페이스
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void interfaceWhfCngNo(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * Wharfage 신고 인터페이스
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void interfaceWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * 확정된 한국 WHF 신고 금액을 AR로 인터페이스 함
	 *
	 * @param WhfBlVO[] whfBlVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String interfaceWhfToArInv(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException;


	/**
	 * 한국 세관에서 면제 사유를 업데이트 할 경우 WHF 면제 사유 및 WHF 금액을 업데이트 함
	 *
	 * @param  WhfBlVO[] whfBlVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyKrWhfBlExptCd (WhfBlVO[] whfBlVOs, SignOnUserAccount account ) throws EventException;
}