/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipBC.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsrHisVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemConsultationVO;

/**
 * ALPS-Gemconsultationslip Business Logic Command Interface<br>
 * -ALPS-Gemconsultationslip에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GEM
 * @see GEMConsultationSlipEvent 참조
 * @since J2EE 1.6
 */

public interface GEMConsultationSlipBC {
	
	/**
	 * office 별 Currency Code 조회.<br>
	 * 
	 * @param SerachConsultaionVO serachConsultaionVO
	 * @return List<SerachConsultaionVO>
	 * @exception EventException
	 */
	public List<SerachConsultaionVO> searchCurrencyCode(SerachConsultaionVO serachConsultaionVO) throws EventException;
	
	
	/**
	 * office 별 expense Code 조회.<br>
	 * 
	 * @param SerachConsultaionVO serachConsultaionVO
	 * @return List<SerachConsultaionVO>
	 * @exception EventException
	 */
	public List<SerachConsultaionVO> searchExpenseCodeOffice(SerachConsultaionVO serachConsultaionVO) throws EventException;
	
	/**
	 *0034 화면의 데이터를 저장 (HDR 테이블저장).<br>
	 * 
	 * @param GemSubsCsulHdrVO gemSubsCsulHdrVO
	 * @param GemSubsCsulDtlVO[] gemSubsCsulDtl
	 * @param SignOnUserAccount signOnUserAccount
	 * @return GemSubsCsulHdrVO
	 * @exception EventException
	 */
	public GemSubsCsulHdrVO manageConsultaion(GemSubsCsulHdrVO gemSubsCsulHdrVO , GemSubsCsulDtlVO[] gemSubsCsulDtl , SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 0034화면의 DTL 테이블 조회 .<br>
	 * 
	 * @param GemSubsCsulHdrVO gemSubsCsulHdr
	 * @return List<GemSubsCsulDtlVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulDtlVO> searchConsultaionDetail(GemSubsCsulHdrVO gemSubsCsulHdr) throws EventException;
	
	/**
	 *Groupwar로 데이터를 넘긴다..<br>
	 * 
	 * @param String csrNo
	 * @param String invSubSysCd
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	
	public String sendGwApprovalRequestInfo(String csrNo, String invSubSysCd, SignOnUserAccount account) throws EventException;
	

	/**
	 * CSR_No로 OFC_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCd(String csrNo) throws EventException;
	
	/**
	 * G/W 연동 histroy를 남김다.. <br>
	 * @param GemSubsCsrHisVO gemSubsCsrHisVO
	 * @throws EventException
	 */
	
	public void saveGWhisInfo(GemSubsCsrHisVO gemSubsCsrHisVO) throws EventException; 
	
	/**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchGemRqstAproStepFlg(String csrNo) throws EventException;
	
	
	/**
	 * GW에서 결과 값 전송 <br>
	 *  GEM_SUBS_CSUL_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param GemCsrInfoVO gemCsrInfoVO
	 * @throws DAOException
	 */
	public void updateGemAproGwDt(GemCsrInfoVO gemCsrInfoVO) throws EventException;
	
	/**
	 * 0034 화면의 조회 정보.<br>
	 * 
	 * @param SerachConsultaionVO serachConsultaionVO
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public List<GemConsultationVO> searchConsultaionInquiry(SerachConsultaionVO serachConsultaionVO) throws EventException;
	
	/**
	 * 0036 화면의 조회 정보.<br>
	 * 
	 * @param SerachConsultaionVO serachConsultaionVO
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulHdrVO> searchCsrNoInquiry(SerachConsultaionVO serachConsultaionVO) throws EventException;
	
	/**
	 * 0033화면의 DTL 테이블 조회 .<br>
	 * 
	 * @param GemSubsCsulHdrVO gemSubsCsulHdr
	 * @return List<GemSubsCsulHdrVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulHdrVO> searchConsultaionHdr(SerachConsultaionVO serachConsultaionVO) throws EventException;

	/**
	 * 0035 화면의 조회 정보.<br>
	 * 
	 * @param SerachConsultaionVO serachConsultaionVO
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public List<GemConsultationVO> searchConsultaionInquiryDetail(SerachConsultaionVO serachConsultaionVO) throws EventException;

	/**
	 * 0033 화면에서 Delt_Flg = 'Y'로 변경을 한다. .<br>
	 * 
	 * @param String csrNo
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	
	public int consultaionCancel(String csrNo, SignOnUserAccount account) throws EventException;

}