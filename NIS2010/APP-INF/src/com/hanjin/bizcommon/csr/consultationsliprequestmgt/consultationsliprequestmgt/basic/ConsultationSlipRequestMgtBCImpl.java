/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestMgtBCImpl.java
*@FileTitle : CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.01 함대성
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.18 김영철 [CHM-201006348-01] CSR 전표 Remark 보완 - INV_DESC 추가
* 2010.10.18 김영철 [CHM-201006951-01] [VOP-PSO] 전도금 CSR내 detail 항목에 VVD 표기 요청건
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration.ConsultationSlipRequestMgtDBDAO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration.ConsultationSlipRequestMgtEAIDAO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AutoRevVVDListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOlistVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CheckAsaVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CreateApInvDTRBASANoSelectVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.DtrbListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrDtrGrpVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SearchDTRBTtlVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.TAXInfoVO;

/**
 * ALPS-ConsultationSlipRequestMgt Business Logic Basic Command implementation<br>
 * - ALPS-ConsultationSlipRequestMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HAM DAE SUNG
 * @see UI-CSR-0001EventResponse,ConsultationSlipRequestMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ConsultationSlipRequestMgtBCImpl extends BasicCommandSupport implements ConsultationSlipRequestMgtBC {

	// Database Access Object
	private transient ConsultationSlipRequestMgtDBDAO dbDao = null;
	private transient ConsultationSlipRequestMgtEAIDAO eaiDao = null;

	/**
	 * ConsultationSlipRequestMgtBCImpl 객체 생성<br>
	 * ConsultationSlipRequestMgtDBDAO를 생성한다.<br>
	 */
	public ConsultationSlipRequestMgtBCImpl() {
		dbDao = new ConsultationSlipRequestMgtDBDAO();
		eaiDao = new ConsultationSlipRequestMgtEAIDAO();
	}

	
	/**
	 * COM_CSR_0004,5 : 조회버튼 <br>
	 * CSR생성시 default ofc를 조회한다.
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String getDefOfc(String ofc_cd) throws EventException {
		String defOfc = null;
		try {
			defOfc = dbDao.getDefOfc(JSPUtil.getNull(ofc_cd));
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
		return JSPUtil.getNull(defOfc);
	} 
	
	/**
	 * COM_CSR_0001 : 조회버튼 <br>
	 * CSR Creation의 리스트를 조회합니다
	 * @param ApPayInvListVO apPayInvListVO
	 * @return List<ApPayInvListVO>
	 * @exception EventException
	 */
	public List<ApPayInvListVO> searchCsrList (ApPayInvListVO apPayInvListVO) throws EventException {
		try {
			return dbDao.searchCsrList(apPayInvListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * CSR_0001 : 화면로드<br>
	 * CSR Creation의  A/P, ASA 체크<br>
	 * @param CheckAsaVO checkAsaVO
	 * @return CheckAsaVO
	 * @exception EventException
	 */
	public CheckAsaVO checkAsaOffice(CheckAsaVO checkAsaVO) throws EventException {
		try {
			//다건조회
			List<CheckAsaVO> checkAsaVOLst = null;
			CheckAsaVO checkAsaVO2 = new CheckAsaVO();

			checkAsaVOLst = dbDao.checkAsaOffice(checkAsaVO);

			if(checkAsaVOLst.size() > 0){
				checkAsaVO2.setSoIfCd(checkAsaVOLst.get(0).getSoIfCd());
				checkAsaVO2.setApOfcCd(checkAsaVOLst.get(0).getApOfcCd());
			}
			return checkAsaVO2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param CsrListInputVO csrListInputVO
	 * @return List<CsrListInputVO>
	 * @exception EventException
	 */
	public List<CsrListInputVO> searchCSRSummaryDetail (CsrListInputVO csrListInputVO) throws EventException {
		try {
			return dbDao.searchCSRSummaryDetail(csrListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * COM_CSR_0002 : 인보이스 삭제여부 체크 <br>
	 * @param invRgstNo
	 * @return String
	 * @exception EventException
	 */
	public String verifyInvoiceDeltChk (String invRgstNo) throws EventException {
		try {
			return dbDao.verifyInvoiceDeltChk(invRgstNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * COM_CSR_0002 : 결재 유형 변경 Office 인지 확인 (ALPS->GW) <br>
	 * Approval Type 설정용
	 * @param String ofcCd
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAl2GwOfc(String ofcCd, String csrNo) throws EventException {
		try {
			return dbDao.searchAl2GwOfc(ofcCd, csrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param String invOfcCd
	 * @param String apOfcCd
	 * @param String issDt
	 * @return List<AsaNoVO>
	 * @exception EventException
	 */
	public List<AsaNoVO> searchAsaNoList(String invOfcCd, String apOfcCd, String issDt) throws EventException {
		try {
			return dbDao.searchAsaNoList(invOfcCd, apOfcCd, issDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0004 : 화면 로드
	 * EviCode 콤보리스트 조회
	 * @return List<TAXInfoVO>
	 * @throws EventException
	 */
	public List<TAXInfoVO> searchEviCodeList() throws EventException {
		try {
			return dbDao.searchEviCodeList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0004 : 화면로드 또는 사업자등록번호 기입 <br>
	 * 사업자등록번호, Vendor Code, 상호, 업태, 주소, 대표자명 조회
	 * @param String compNo
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchTAXInfo(String compNo) throws EventException {
		try {
			//다건조회
			List<TAXInfoVO> voLst = null;
			TAXInfoVO vo = new TAXInfoVO();

			voLst = dbDao.searchTAXInfo(compNo);

			if(voLst.size() > 0){
				vo.setVndrNm(voLst.get(0).getVndrNm());
				vo.setBzctNm(voLst.get(0).getBzctNm());
				vo.setBztpNm(voLst.get(0).getBztpNm());
				vo.setVndrAddr(voLst.get(0).getVndrAddr());
				vo.setVndrSeqHdr(voLst.get(0).getVndrSeqHdr());
				vo.setCeoNm(voLst.get(0).getCeoNm());
			}
			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0004 evid_no 채번및저장 
	 * @param TAXInfoVO tAXInfoVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return TAXInfoVO
	 * @throws EventException
	 */
	public TAXInfoVO searchApEviNo(TAXInfoVO tAXInfoVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			/*1. 채번한다
			  2. 채번한 eviNo를 입력한다 */
			//1
			String taxNo1 = (String) tAXInfoVO.getTaxNo1();
			String taxNo2 = (String) tAXInfoVO.getTaxNo2();
			String taxNo3 = dbDao.searchApEviNo(taxNo1, taxNo2);
			//2
			tAXInfoVO.setCreUsrId(signOnUserAccount.getUsr_id());
			tAXInfoVO.setTaxNo3(taxNo1+taxNo2+taxNo3);
			tAXInfoVO.setOfcCd(signOnUserAccount.getOfc_cd());

			dbDao.addApEviNo(tAXInfoVO);

//			String taxNoMax = dbDao.searchApEviNo(taxNo1, taxNo2);

			tAXInfoVO.setTaxNo3(taxNo3);
			return tAXInfoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0004 : 완료버튼 <br>
	 * 세금계산서 TAXCode 조회 
	 * @param TAXInfoVO tAXInfoVO
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchTAXCode(TAXInfoVO tAXInfoVO) throws EventException {
		try {
			//다건조회
			List<TAXInfoVO> voLst = null;
			voLst = dbDao.searchTAXCode(tAXInfoVO);

			if(voLst.size() > 0){
				tAXInfoVO.setApTaxNm(voLst.get(0).getApTaxNm());
			}
			return tAXInfoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * COM_CSR_0004 : 화면로드 <br>
	 * 사업자등록번호 조회 
	 * @param TAXInfoVO tAXInfoVO
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchCompNo(TAXInfoVO tAXInfoVO) throws EventException {
		try {
			String compNo = dbDao.searchCompNo(tAXInfoVO);
			tAXInfoVO.setCompNo(compNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
		return tAXInfoVO;
	} 
	
	/**
	 * AutoRevVVDList : AutoRevVVDList
	 * getAutoRevVVDList
	 * @param Collection payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] getAutoRevVVDList(Collection payInvVOs, CsrParmVO csrParmVO) throws EventException {

		DBRowSet[] dRsArr = null;

		try {
			dRsArr = dbDao.getAutoRevVVDList(payInvVOs, csrParmVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return dRsArr;
	}

	/**
	 * modifyAutoRevVVD : modifyAutoRevVVD
	 * modifyAutoRevVVD
	 * @param List<AutoRevVVDListVO> autoRevVVDListVO
	 * @throws EventException
	 */
	public void modifyAutoRevVVD(List<AutoRevVVDListVO> autoRevVVDListVO) throws EventException {

		try {
			dbDao.modifyAutoRevVVD(autoRevVVDListVO);
			log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * searchApInvDTRBIn : searchApInvDTRBIn 국내
	 * searchApInvDTRBIn
	 * @param Collection<PayInvVO> payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[] 
	 * @throws EventException
	 */
	public DBRowSet[] searchApInvDTRBIn(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws EventException {

		DBRowSet[] dRsArr = null;

		try {
			dRsArr = dbDao.searchApInvDTRBIn(payInvVOs, csrParmVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return dRsArr;
	}

	/**
	 * searchApInvDTRBOut : searchApInvDTRBOut 국외
	 * searchApInvDTRBOut
	 * @param Collection<PayInvVO> payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] searchApInvDTRBOut(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws EventException {

		DBRowSet[] dRsArr = null;

		try {
			dRsArr = dbDao.searchApInvDTRBOut(payInvVOs, csrParmVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return dRsArr;
	}
	
    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg") + (String) rowSet.getObject("jb_usr_err_msg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{"Confirm Approval"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{"Confirm Approval"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{"Confirm Approval"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("CSR00010", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0002 : Approval Request 버튼 <br>
	 * Approval Request 버튼 구현로직
	 * @param Collection<PayInvVO> payInvVOs
	 * @param List<AutoRevVVDListVO> autoRevVVDListVO
	 * @param List<SearchDTRBTtlVO> searchDTRBTtlVOList
	 * @param CsrParmVO csrParmVO
	 * @param String creUsrId
	 * @return String
	 * @exception EventException
	 */
	public String approvalRequest(Collection<PayInvVO> payInvVOs, List<AutoRevVVDListVO> autoRevVVDListVO, List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws EventException {
        
		try {
			ConsultationSlipRequestBackEndJob 	backEndResult 		= new ConsultationSlipRequestBackEndJob();
			
			BackEndJobManager 					backEndJobManager 	= new BackEndJobManager();
			
			backEndResult.setAutoRevVVDListVO	(autoRevVVDListVO	);
			backEndResult.setSearchDTRBTtlVOList(searchDTRBTtlVOList);
			backEndResult.setPayInvVOs			(payInvVOs			);
			backEndResult.setCsrParmVO			(csrParmVO			);
			backEndResult.setCreUsrId			(creUsrId			);
			backEndResult.setJobFlg				("SAVE"				);
			
			return backEndJobManager.execute(backEndResult, creUsrId, "CSR Approval Requst!!!");
			
		} catch (Exception de) {
			//log.error("\n DONE - approvalRequest.DAOException - CSR_NO:"+csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		}
	}

	/**
	 * COM_CSR_0002 : Preview 버튼 <br>
	 * Preview 버튼 구현로직
	 * @param Collection<PayInvVO> payInvVOs
	 * @param List<AutoRevVVDListVO> autoRevVVDListVO
	 * @param List<SearchDTRBTtlVO> searchDTRBTtlVOList
	 * @param CsrParmVO csrParmVO
	 * @param String creUsrId
	 * @return HdrDtrGrpVO
	 * @exception EventException
	 */
	public HdrDtrGrpVO searchPreVeiw(Collection<PayInvVO> payInvVOs, List<AutoRevVVDListVO> autoRevVVDListVO, List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws EventException {
		log.debug("\n\n\n\n\n BCImpl searchPreVeiw >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> searchPreVeiw");
		log.error("\n searchPreVeiw:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

		HdrDtrGrpVO grpVO = new HdrDtrGrpVO();
		HdrVO hdrSet = null;
		List<DtrbListVO> dtrbSet = null;

		String asa_no 	 = csrParmVO.getAsaNoS();
		String csr_tp_cd = csrParmVO.getCsrTpCd();
		String cnt_cd 	 = csrParmVO.getCntCd();
		String evi_gb 	 = csrParmVO.getEviGb();
		String csr_no 	 = "";
		String chkAmt    = ""; 
		//TLL로직 추가
		String inv_sub_sys_cd = csrParmVO.getInvSubSysCd();
		String ofc_cd    	  = JSPUtil.getNull(csrParmVO.getOfcCd());
		String cost_ofc_cd    = JSPUtil.getNull(csrParmVO.getCostOfcCd());
		//createApInvDTRB_sum
		DBRowSet		dtrbSumSet		= null;		
		String inv_no2			= "";
		String vndr_seq			= ""; 
		String gap		 		= "";
		String cost_cd	 		= "";
		String cntr_tpsz_cd		= ""; 
		//Rev.VVD
		DBRowSet 		revVVDSet 	= null;
		DBRowSet 		revVVDSet2 	= null;
		DBRowSet 		acctCdSet	= null;
		String 			vvd_cd 	= "";
		String 			dtrb_coa_acct_cd 	= "";
		String 			inv_no 	= "";
		String 			chk 	= "";
		String 			tmp_del_vvd_inv 		= "";
		String 			tmp_not_found_vvd_inv 	= "";
		//createApInvDTRBASANo
		DBRowSet		asaRowSet	= null;
		String iss_dt = "";
		String loc_cd = "";
		String line_seq = "";
		String line_no = "";
		String total_amt = "";
		String acct_cd = "954113";
		//modifyApInvDTRBLineNo
		DBRowSet 		dtrbLineSet 	= null;
		ApInvDtrbVO		apInvDtrbVO		= null;
		List<ApInvDtrbVO> 	lineNoVoList 	= new ArrayList<ApInvDtrbVO>();
		
		DBRowSet[] 						dbRowSetArr				= null;
		List<SearchDTRBTtlVO> 			searchCorrDTRBTtlVOList = new ArrayList<SearchDTRBTtlVO>();
		SearchDTRBTtlVO 				searchDTRBTtlVO 		= null;		
		
		try {
			//다건의 인보이스의 상태들을 조회만 하고 사용하진 않는다 -> 인보이스상태를 처음에 불러놓고 사용하진 않는다 ? -> 이 checkInvoiceStatus 메소드는 제거해도 되지않는가? 아니면 상태값으로 무엇을 하려함인가?
			// 2007-12-10 : invoice의 상태를 확인
			//dbDao.checkInvoiceStatus(event.getPayInvs(),ConsultationSlipRequestMgtBC.INV_STS_CF);
			//1. 각 데이터 CHECK  후 없는 경우 Exception 발생 시켜  더이상 진행시키지 않음 - mdm_organization
			CSRSOhdrVO rtnVO = dbDao.searchApInvCheck1(csrParmVO);
			if((rtnVO.getApOfcCd()).equals("N") || (rtnVO.getApOfcCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			if((rtnVO.getFincRgnCd()).equals("N") || (rtnVO.getFincRgnCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			if((rtnVO.getApCtrCd()).equals("N") || (rtnVO.getApCtrCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			log.error("\n DONE - approvalRequest.searchApInvCheck1:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//2. ACCT_CD(비용코드)?
			dbDao.searchApInvCheck2(payInvVOs);
			log.error("\n DONE - approvalRequest.searchApInvCheck2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//3. csr_no 생성: csr_no 채번후 ap_csr_no 테이블에 insert / >>>>>>>물류와 장비 두개의 구분으로 CSR_NO 채번 [SM]
			//if(!inv_sub_sys_cd.equals("CNI")){	//CNI모듈이 아닌 경우 CSR_NO 채번
			csr_no = dbDao.multiCSRNo(cost_ofc_cd, csr_tp_cd);
			//dbDao.multiCSRInsert(cost_ofc_cd, csr_no, creUsrId);

			log.error("\n DONE - approvalRequest.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			csrParmVO.setCsrNo(csr_no); 
			
			if(!inv_sub_sys_cd.equals("CNI") && autoRevVVDListVO.size() > 0){	//CNI모듈이 아닌경우만 재무VVD 업데이트
				// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리
				dbDao.modifyAutoRevVVD(autoRevVVDListVO);
				log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} 

			/* "PSO" Only REV_DIR_CD(RLANE_DIR_CD) DIFF 데이터 존재여부 추출 및 업	데이트처리  :: 2012-07-16 
			 * AP_PAY_INV_DTL.ACT_VVD_CD & VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD
			 * */
			if(inv_sub_sys_cd.equals("PSO") && autoRevVVDListVO.size() > 0){	//PSOCNI모듈이 아닌경우만 재무VVD 업데이트
				// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리
				dbDao.modifyPSORevVVD(autoRevVVDListVO);
				log.error("\n DONE - searchPreVeiw.modifyPSOActVvdCd:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}			
			
			//4.AP HDR 및 DTRB INSERT
			dbDao.createApInvHDR(csrParmVO, creUsrId);
			log.error("\n DONE - approvalRequest.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			/**
			 * AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE한다.  
			 */
			dbDao.updateApInvHdrPDTApproval(csr_no);
			
			/**
			 * 환율 상태 확인 : AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE후에 USD환율이 NULL이거나 해당기간에 USD 환율변환이 안되는 상태면 띵긴다.  
			 */
			dbDao.checkUSDExchSts(csr_no);

			
			/* AP_PAY_INV_DTL 테이블에 REV.VVD 업데이트이후 결과 추출(한국지역+국외지역) START ::2012-07-16 */
			if (cnt_cd.equals("KR")){
				dbRowSetArr	= dbDao.searchApInvDTRBIn	(payInvVOs, csrParmVO);
			}else{
				dbRowSetArr	= dbDao.searchApInvDTRBOut	(payInvVOs, csrParmVO);
			}
			/* AP_PAY_INV_DTL 테이블에 REV.VVD 업데이트이후 결과 추출(한국지역+국외지역) FINISH ::2012-07-16 */
				
			//REV.VVD 업데이트 변경된 AP_PAY_INV_DTL 기준으로 searchCorrDTRBTtlVOList Setting
			if(dbRowSetArr != null){
				for(int j=0; j<dbRowSetArr.length; j++){
					while (dbRowSetArr[j].next()){
						searchDTRBTtlVO = new SearchDTRBTtlVO();
						
						searchDTRBTtlVO.setLineSeq			(dbRowSetArr[j].getString("line_seq"));
						searchDTRBTtlVO.setLineNo           (dbRowSetArr[j].getString("line_no"));
						searchDTRBTtlVO.setLineTpLuCd       (dbRowSetArr[j].getString("line_tp_lu_cd"));
						searchDTRBTtlVO.setCsrAmt           (dbRowSetArr[j].getString("csr_amt"));
						searchDTRBTtlVO.setInvDesc          (dbRowSetArr[j].getString("inv_desc"));
						searchDTRBTtlVO.setInvTaxCd         (dbRowSetArr[j].getString("inv_tax_cd"));
						searchDTRBTtlVO.setDtrbCoaCoCd      (dbRowSetArr[j].getString("dtrb_coa_co_cd"));
						searchDTRBTtlVO.setDtrbCoaRgnCd     (dbRowSetArr[j].getString("dtrb_coa_rgn_cd"));
						searchDTRBTtlVO.setDtrbCoaCtrCd     (dbRowSetArr[j].getString("dtrb_coa_ctr_cd"));
						searchDTRBTtlVO.setDtrbCoaAcctCd    (dbRowSetArr[j].getString("dtrb_coa_acct_cd"));
						searchDTRBTtlVO.setDtrbCoaVvdCd     (dbRowSetArr[j].getString("dtrb_coa_vvd_cd"));
						searchDTRBTtlVO.setDtrbCoaInterCoCd (dbRowSetArr[j].getString("dtrb_coa_inter_co_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN1stCd (dbRowSetArr[j].getString("dtrb_coa_ftu_n1st_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN2ndCd (dbRowSetArr[j].getString("dtrb_coa_ftu_n2nd_cd"));
						searchDTRBTtlVO.setAttrCateNm       (dbRowSetArr[j].getString("attr_cate_nm"));
						searchDTRBTtlVO.setAttrCtnt1        (dbRowSetArr[j].getString("attr_ctnt1"));
						searchDTRBTtlVO.setAttrCtnt2        (dbRowSetArr[j].getString("attr_ctnt2"));
						searchDTRBTtlVO.setAttrCtnt3        (dbRowSetArr[j].getString("attr_ctnt3"));
						searchDTRBTtlVO.setAttrCtnt4        (dbRowSetArr[j].getString("attr_ctnt4"));
						searchDTRBTtlVO.setAttrCtnt5        (dbRowSetArr[j].getString("attr_ctnt5"));
						searchDTRBTtlVO.setAttrCtnt6        (dbRowSetArr[j].getString("attr_ctnt6"));
						searchDTRBTtlVO.setAttrCtnt7        (dbRowSetArr[j].getString("attr_ctnt7"));
						searchDTRBTtlVO.setAttrCtnt8        (dbRowSetArr[j].getString("attr_ctnt8"));
						searchDTRBTtlVO.setAttrCtnt9        (dbRowSetArr[j].getString("attr_ctnt9"));
						searchDTRBTtlVO.setAttrCtnt10       (dbRowSetArr[j].getString("attr_ctnt10"));
						searchDTRBTtlVO.setAttrCtnt11       (dbRowSetArr[j].getString("attr_ctnt11"));
						searchDTRBTtlVO.setAttrCtnt12       (dbRowSetArr[j].getString("attr_ctnt12"));
						searchDTRBTtlVO.setAttrCtnt13       (dbRowSetArr[j].getString("attr_ctnt13"));
						searchDTRBTtlVO.setAttrCtnt14       (dbRowSetArr[j].getString("attr_ctnt14"));
						searchDTRBTtlVO.setAttrCtnt15       (dbRowSetArr[j].getString("attr_ctnt15"));
						searchDTRBTtlVO.setBkgNo            (dbRowSetArr[j].getString("bkg_no"));
						searchDTRBTtlVO.setCntrTpszCd       (dbRowSetArr[j].getString("cntr_tpsz_cd"));
						searchDTRBTtlVO.setActVvdCd         (dbRowSetArr[j].getString("act_vvd_cd"));
						searchDTRBTtlVO.setPlnSctrDivCd     (dbRowSetArr[j].getString("pln_sctr_div_cd"));
						searchDTRBTtlVO.setSoCrrCd          (dbRowSetArr[j].getString("so_crr_cd"));
						searchDTRBTtlVO.setYdCd             (dbRowSetArr[j].getString("yd_cd"));
						searchDTRBTtlVO.setFtuUseCtnt1      (dbRowSetArr[j].getString("ftu_use_ctnt1"));
						searchDTRBTtlVO.setFtuUseCtnt2      (dbRowSetArr[j].getString("ftu_use_ctnt2"));
						searchDTRBTtlVO.setFtuUseCtnt3      (dbRowSetArr[j].getString("ftu_use_ctnt3"));
						searchDTRBTtlVO.setFtuUseCtnt4      (dbRowSetArr[j].getString("ftu_use_ctnt4"));
						searchDTRBTtlVO.setFtuUseCntr5      (dbRowSetArr[j].getString("ftu_use_cntr5"));
						searchDTRBTtlVO.setCreDt            (dbRowSetArr[j].getString("cre_dt"));
						searchDTRBTtlVO.setCreUsrId         (dbRowSetArr[j].getString("cre_usr_id"));
						searchDTRBTtlVO.setEaiEvntDt        (dbRowSetArr[j].getString("eai_evnt_dt"));
						
						searchCorrDTRBTtlVOList.add(searchDTRBTtlVO);
					}				
				}
			}						
			
			
			 //searchApInvDTRBIn -> or searchApInvDTRBOut -> 로직으로 DBRowSet[] 타입으로 담아온 데이타들을 AP_INV_DTRB에 INSERT, AP_INV_HDR에 UPDATE
			if (cnt_cd.equals("KR")){
				//
				dbDao.createApInvDTRB(searchCorrDTRBTtlVOList, csrParmVO, creUsrId);  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvHdrUpdate(csrParmVO);
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				if(evi_gb.equals("1") || evi_gb.equals("2")){	//AP_INV_DTRB INSERT [증빙]
					//
					dbDao.createApInvDTRBEvi(payInvVOs, csrParmVO);
					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				}else{
					if(inv_sub_sys_cd.equals("TLL")){
						dbDao.createApInvDTRBEviTll(payInvVOs, csrParmVO);
					}
				}
			} else { //
				dbDao.createApInvDTRB(searchCorrDTRBTtlVOList, csrParmVO, creUsrId);  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			//AP_INV_DTRB 의 LINE_SEQ, LINE_NO UPDATE
			dbDao.modifyApInvDTRBLineNo(csr_no);
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(csr_no);
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_Acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					
					lineNoVoList.add(apInvDtrbVO);
				}
			}
			dbDao.modifyApInvDTRBLineNo02(lineNoVoList); 
			
			log.error("\n DONE - approvalRequest.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			//AP_INV_DTRB ???, GAP(청구받은 Invoice의 금액 - 공급액) UPDATE
			Iterator itr   =	payInvVOs.iterator();
			PayInvVO model = null;

			while (itr.hasNext()) {
				model 			= (PayInvVO)itr.next();
				inv_no = model.getInv_no();
				vndr_seq = model.getVndr_seq();
				
				dtrbSumSet = dbDao.createApInvDTRB_sum(csrParmVO.getCsrNo(), inv_no, vndr_seq);
				
				if (dtrbSumSet != null) {
    				while(dtrbSumSet.next()){
    					gap 			= dtrbSumSet.getString("GAP");
    					inv_no2 		= dtrbSumSet.getString("ATTR_CTNT1");
    					cost_cd 		= dtrbSumSet.getString("FTU_USE_CTNT1");
    					cntr_tpsz_cd 	= dtrbSumSet.getString("CNTR_TPSZ_CD");
    					
    					if (inv_no==null || inv_no.trim().equals("") || inv_no2==null || inv_no2.trim().equals("") || !inv_no.equals(inv_no2)){
    						throw new DAOException(new ErrorHandler("Wrong Inv.No Exception!!!").getMessage());
    					}
    					
    					dbDao.createApInvDTRB_sumUpdateDiff(csrParmVO, gap, inv_no2, cost_cd, cntr_tpsz_cd);
    				}
				}
			}
			log.error("\n DONE - approvalRequest.createApInvDTRB_sum:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			if (!asa_no.equals("")) {
				//asa_no 값이 있는경우
				asaRowSet = dbDao.createApInvDTRBASANoSelect(csr_no);
	            if (asaRowSet != null) {
	            	while(asaRowSet.next()){
	            		inv_no  	= asaRowSet.getString("inv_no");
	            		iss_dt  	= asaRowSet.getString("iss_dt");
	            		loc_cd		= asaRowSet.getString("loc_cd");
	            		line_seq	= asaRowSet.getString("line_seq");
	            		line_no		= asaRowSet.getString("line_no");
	            		total_amt	= asaRowSet.getString("total_amt");
	            	}
	            }
	            
	            CreateApInvDTRBASANoSelectVO createApInvDTRBASANoSelectVO = new CreateApInvDTRBASANoSelectVO();
	            
	            createApInvDTRBASANoSelectVO.setInvNo(inv_no);
	            createApInvDTRBASANoSelectVO.setIssDt(iss_dt);
	            createApInvDTRBASANoSelectVO.setLocCd(loc_cd);
	            createApInvDTRBASANoSelectVO.setLineSeq(line_seq);
	            createApInvDTRBASANoSelectVO.setLineNo(line_no);
	            createApInvDTRBASANoSelectVO.setTotalAmt(total_amt);
	            createApInvDTRBASANoSelectVO.setAcctCd(acct_cd);
	            createApInvDTRBASANoSelectVO.setCsrNo(csr_no);
	            
	            dbDao.createApInvDTRBASANoInsert(createApInvDTRBASANoSelectVO, ofc_cd, cost_ofc_cd, vndr_seq, creUsrId, csr_tp_cd);
	            dbDao.createApInvDTRBASANoUpdate(csr_no);
				log.error("\n DONE - approvalRequest.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			 
			if(!inv_sub_sys_cd.equals("CNI")){	//CNI모듈인 레벨체크하지 않는다
				// 5. R.VVD LEVEL CHECK 2009-09 추가 :: .?
	 			dbDao.searchApInvVVDChacke(csr_no);
	 			log.error("\n DONE - approvalRequest.searchApInvVVDChacke:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}

			//7.HDR CSR NO UPDATE 처리 -> AP_PAY_INV 의 CSR_NO 업데이트
			dbDao.upateInvCSRNo(payInvVOs, csr_no, "N");
			log.error("\n DONE - approvalRequest.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			//8.EP 결제하기 - 결제등록 (COM_APRO_RQST_HDR, ComAproRqstRoutVO)

			// 9. inv_sts_cd 'A' 결제하기
			//dbDao.modifyStsCdSOHDR(payInvVOs, "A");
			//log.error("\n DONE - approvalRequest.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			//10. CSR AMT VAILD CHECK
			chkAmt = dbDao.checkCSRAmtVsInvAmt(csr_no);
			log.error("\n DONE - approvalRequest.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
				//throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("CSR00080").getMessage());	//\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.
			}

			//11. Rev.VVD로 Rev.VVD master에 존재/삭제 여부를 조회..
			revVVDSet = dbDao.checkMstRevVVD01(csr_no);

			if (revVVDSet!=null){
				while (revVVDSet.next()){
					vvd_cd = revVVDSet.getString("DTRB_COA_VVD_CD");
					inv_no = revVVDSet.getString("ATTR_CTNT1");
					log.debug("\n\n DTRB_COA_VVD_CD:"+revVVDSet.getString("DTRB_COA_VVD_CD")+" / inv_no:"+revVVDSet.getString("ATTR_CTNT1")+"  ---------------------  --------------------- ---------------------  \n\n");
					

					
					revVVDSet2 = dbDao.checkMstRevVVD02(csr_no);
					if (revVVDSet2!=null){
						while (revVVDSet2.next()){
							chk = revVVDSet2.getString("CHK");
							if (chk!=null){
								if (chk.trim().equals("Y")){
									tmp_del_vvd_inv = tmp_del_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " has been deleted. ");
								}
							} else {
								tmp_not_found_vvd_inv = tmp_not_found_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " is not found in Revenue VVD master. ");
							}
						}
					}
				}
			} else {
				throw new DAOException((new ErrorHandler("CSR00026").getMessage()));			
			}
			
			//12. PSO모듈인경우 INV_DESC 수정
		
			if(inv_sub_sys_cd.equals("PSO")){
				acctCdSet = dbDao.checkAcctCd(csr_no);
				
				// 2010.10.19 Accunt Code가 110911 이고 PSO_TRNS_SLP_CTNT = 'GO' 일때만 AP_INV_HDR 테이블의 INV_DESC 컬럼에 기존 INV_DESC + (Actual VVD) 업데이트
				dbDao.modifyHdrDesc(csr_no);
				
				// 2010.10.19 Account Code가 962111 일때만 AP_INV_DTRB 테이블의 INV_DESC 컬럼에 기존 INV_DESC + AP_PAY_INV_DTL에 추가된 INV_DESC 값을 업데이트
				if (acctCdSet!=null){
					while (acctCdSet.next()){
						dtrb_coa_acct_cd = acctCdSet.getString("DTRB_COA_ACCT_CD");
						line_seq = acctCdSet.getString("LINE_SEQ");
						line_no  = acctCdSet.getString("LINE_NO");
						
						if(dtrb_coa_acct_cd.equals("962111")|| dtrb_coa_acct_cd.equals("110911")){
							dbDao.modifyDesc(csr_no, dtrb_coa_acct_cd, line_seq, line_no);
						}
					}
				}
			}
			
			hdrSet = dbDao.searchPreviewHDR(csr_no);
			log.error("\n DONE - searchPreVeiw.searchPreviewHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//
			dtrbSet = dbDao.searchPreviewDTRBList(csr_no);
			log.error("\n DONE - searchPreVeiw.searchPreviewDTRBList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			grpVO.setHdrVOs		(hdrSet	);
			grpVO.setDtrbListVOs(dtrbSet);
			//AP_PAY_INV 의 CSR_NO 업데이트 한 것을 Null로 함.
			dbDao.upateInvCSRNoNull(payInvVOs);
			
			
			
			/**
			 *  approval step 저장 및 유효성 검사
			 */
			/*
			dbDao.createCSREPApproval(csrParmVO);
			String apro_step_chk = new ApprovalUtil().checkAproStepSts(csr_no,creUsrId);
			log.error("\n\n csr_no : " + JSPUtil.getNull(csr_no) + " --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + " ======================= \n\n");
			if (apro_step_chk!=null){
				
				 // P : 10만불 이상인데 PDT 미지정
				 // M : 10만불 이하인데 본부장 미지정
				 // K : Approval Step PDT/본부장 포함 2단계 이하인 경우
				 // E : 오류
				 // I : CEO는 항상 제일 뒤에 위치하는지 검사 
				 // Y : 정상
				 // X : [2014-07,08] PDT 지시 시항 적용 대상이 아님
				 // F : PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT/본부장 결재 우회 허용 
				 // C : 운하통과료 (SO_PORT) -> 결재자 상관없이 무조건 통과 요청
				 
				if (apro_step_chk.trim().equals("P")){
					throw new EventException(new ErrorHandler("CSR10011", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("M")){
					throw new EventException(new ErrorHandler("CSR10012", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("K")){
					throw new EventException(new ErrorHandler("CSR10014", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("E")){
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("I")){
					throw new EventException(new ErrorHandler("CSR10019", new String[]{}).getMessage());
				} else if (
						   apro_step_chk.trim().equals("Y") // 정상
						|| apro_step_chk.trim().equals("X") // 대상아님(적용전CSR들)
						|| apro_step_chk.trim().equals("F") // PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT결재 우회 허용
						|| apro_step_chk.trim().equals("C") // (SO_PORT용) 운하통과료는 우회 허용
						   )
				{
					log.error("\n >>>>>>>>>>>>>>>>>>>>> --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + "   [PASS] csr_no: " + JSPUtil.getNull(csr_no) + " <<<<<<<<<<<<<<<<<<<<< \n");
				} else {
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());					
				}
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
			}
			new ApprovalUtil().deltComAproStep(csr_no); //CSR preview에서만 삭제처리가 요함
			*/
			
			
			//삭제 및 업데이트
			dbDao.deleteApInvHDRDTRB(csr_no);
			dbDao.deleteApInvHDRDTRB02(csr_no); // 기존것을 나누어서 
			log.error("\n DONE - searchPreVeiw.deleteApInvHDRDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n");

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
			throw new EventException(ex.getMessage());
		}
		return grpVO;
	}

	/**
	 * COM_CSR_0008 : CSR Format 버튼 <br>
	 * CSR Format 버튼 구현로직
	 * @param String csrNo
	 * @return HdrDtrGrpVO
	 * @exception EventException
	 */
	public HdrDtrGrpVO tmpSearchPreVeiw(String csrNo) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		HdrDtrGrpVO grpVO = new HdrDtrGrpVO();
		HdrVO hdrSet = null;
		List<DtrbListVO> dtrbSet = null;

		try {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> tmpSearchPreVeiw");
			hdrSet = dbDao.searchPreviewHDR(csrNo);
			dtrbSet = dbDao.searchPreviewDTRBList(csrNo);

			grpVO.setHdrVOs(hdrSet);
			grpVO.setDtrbListVOs(dtrbSet);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * COM_CSR_0008 : 조회버튼 <br>
	 * CSR I/F Inquiry 의 리스트를 조회합니다.<br>
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @return List<IfCsrListInputVO>
	 * @exception EventException
	 */
	public List<IfCsrListInputVO> searchCsrIfList (IfCsrListInputVO ifCsrListInputVO) throws EventException {
		try {
			return dbDao.searchCsrIfList(ifCsrListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 리스트폼조회 
	 * @param CSRSOlistVO cSRSOlistVO
	 * @return List<CSRSOlistVO>
	 * @exception EventException
	 */
	public List<CSRSOlistVO> searchCSRSOlist(CSRSOlistVO cSRSOlistVO) throws EventException {
		try {
			return dbDao.searchCSRSOlist(cSRSOlistVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
 
	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 플릿폼조회  : 대체전표로 검색된 해당 SO목록
	 * @param CSRSOhdrVO cSRSOhdrVO
	 * @return CSRSOhdrVO
	 * @exception EventException
	 */
	public CSRSOhdrVO searchCSRSOhdr(CSRSOhdrVO cSRSOhdrVO) throws EventException {
		try {
			return dbDao.searchCSRSOhdr(cSRSOhdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
 
	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * I/F Error 의 Cancel 저장
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void multiConfirmCSR(IfCsrListInputVO ifCsrListInputVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			ifCsrListInputVO.setInvStsCd("X");
			ifCsrListInputVO.setAftActFlg("N");
			ifCsrListInputVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			ifCsrListInputVO.setOfcCd(signOnUserAccount.getOfc_cd());

			dbDao.multiConfirmCSR(ifCsrListInputVO);
			dbDao.cancelCSR(ifCsrListInputVO);
			dbDao.cancelCSRApro1(ifCsrListInputVO);
			dbDao.cancelCSRApro2(ifCsrListInputVO);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * Approval Requested 의 Cancel 저장
	 * @param  IfCsrListInputVO ifCsrListInputVO
	 * @param  SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void cancelCSR(IfCsrListInputVO ifCsrListInputVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			ifCsrListInputVO.setInvStsCd("X");
			ifCsrListInputVO.setAftActFlg("X");
			ifCsrListInputVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			ifCsrListInputVO.setOfcCd(signOnUserAccount.getOfc_cd());

			dbDao.multiConfirmCSR(ifCsrListInputVO);
			dbDao.cancelCSR(ifCsrListInputVO);
			dbDao.cancelCSRApro1(ifCsrListInputVO);
			dbDao.cancelCSRApro2(ifCsrListInputVO);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * COM_CSR_0014 : CSR Cancel버튼시 화면로드<br>
	 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장
	 * @param Collection<PayInvVO> payInvVOs
	 * @param String[] chks
	 * @param CsrParmVO csrParmVO
	 * @param String userId
	 * @param String ofcCd
	 * @throws EventException
	 */
	public void multiRejectedCSRCancellation(Collection<PayInvVO> payInvVOs, String[] chks, CsrParmVO csrParmVO, String userId, String ofcCd) throws EventException {
		log.debug("\n BC.multiRejectedCSRCancellation \n");

		try {
//			dbDao.multiRejectedCSRCancellation(payInvVOs,
//											   chks,
//											   csrParmVO,
//											   userId,
//											   ofcCd);
			
			Collection updModels = new ArrayList<PayInvVO>();
			String ifStatus = csrParmVO.getIfStatus();
			String csrNo    = csrParmVO.getCsrNo();

			Iterator<PayInvVO> itr = payInvVOs.iterator();
			PayInvVO model = null;
			String inv_sts_cd = "";
			String delt_flg = "";

			int i = 0;
			while (itr.hasNext()) {

				model = (PayInvVO) itr.next();

				if(JSPUtil.getNull(model.getTml_inv_rjct_sts_cd()).equals("Y")){
					if(JSPUtil.getNull(model.getInv_sts_cd()).equals("B")){
						inv_sts_cd = "B";
					}else if(JSPUtil.getNull(model.getInv_sts_cd()).equals("G")){
						inv_sts_cd = "G";
					}
				}else{
					if(chks[i]!=null && chks[i].trim().equals("1") ){
						if(ifStatus.equals("R")){
							inv_sts_cd = "B";
						}else if(ifStatus.equals("J")){
							inv_sts_cd = "G";
						}
					}else{
						inv_sts_cd = "C";
					}
				}
				
				if(inv_sts_cd.equals("B") || inv_sts_cd.equals("G")){
					delt_flg = "Y";
				}else{
					delt_flg = "N";
				}
				
				//1쿼리 파라미터
				model.setInv_sts_cd(JSPUtil.getNull(inv_sts_cd));
				model.setHld_flg(JSPUtil.getNull(delt_flg));
				model.setUpd_usr_id(JSPUtil.getNull(userId));
				model.setInv_ofc_cd(JSPUtil.getNull(ofcCd));
				model.setOfc_cd(JSPUtil.getNull(ofcCd));
				//2쿼리 파라미터
				model.setCsr_no(csrNo);
				model.setInv_rgst_no(JSPUtil.getNull(model.getInv_rgst_no()));

				updModels.add(model);

				i++;
			}
			
			if(updModels.size() > 0){
				dbDao.multiRejectedCSRCancellation01(updModels);
				dbDao.multiRejectedCSRCancellation02(updModels);
				dbDao.multiRejectedCSRCancellation03(updModels);
				dbDao.multiRejectedCSRCancellation04(updModels);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
	 * approvalRequestAccount1
	 * @param String flag
	 * @param String sCsrNo
	 * @param String ofcCd
	 * @param ComAproRqstRoutVO comAproRqstRoutVO
	 * @return FNS0080003Document[]
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String sCsrNo, String ofcCd, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException
	{
		DBRowSet 				rowSet				= null;
		FNS0080003Document[] 	docReq 				= null;
		try {

			/** APPROVAL CONFIRMATION	*/
			if ( flag.equals("C") )
			{
				//AP 로 전송할 CSR 정보를 가져온다
				rowSet 	= dbDao.searchApInvInfForEAIInterface(sCsrNo, ofcCd);

				if( rowSet != null ){
					//AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
					docReq 		= eaiDao.transferAtOnceCSR024ToEAIByWS(rowSet, sCsrNo, comAproRqstRoutVO);
					
					/** EAI XML GENERATION */
					//dbDao.updateApInvHdrIFErrRsn	(sCsrNo, EAI_XML			);
				}else{
					/** rowset is null 		*/
					//dbDao.updateApInvHdrIFErrRsn	(sCsrNo, AP_IF_ROWSET_NULL	);
				}

			/** APPROVAL REJECTION [DISAPPROVED]	*/
			}

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (EventException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return docReq;
	}

	/**
	 * EP : createApInvIF
	 * CSR생성시 AP I/F를 위해 AP_INV_IF에 DATA를 넣는다 -> 현재 사용되지 않는 메소드 2010-08-04
	 * @param String csrNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String createApInvIF(String csrNo, String ofcCd) throws EventException
	{
		String pgm_no = "";

		try{
			//6.AP I/F에 INSERT -> AP_INV_IF INSERT
			pgm_no = dbDao.createApInvIF(csrNo, ofcCd);
		    log.error("\n DONE - createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("\n DONE - createApInvIF.DAOException - CSR_NO:"+csrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return pgm_no;
	}
	
	/**
	 * EP - > CSR 호출
	 * AP_INV_HDR 업데이트 
	 * @param String flag
	 * @param String sCsrNo
	 * @param ComAproRqstRoutVO model
	 * @exception EventException
	 */
	public void approvalRequestAccount2(String flag, String sCsrNo, ComAproRqstRoutVO model) throws EventException
	{
		//String 					hdr_gl_dt 	= "";
		String					title_name				= null;

		try {

			title_name	= model.getAproUsrJbTitNm()+"/"+model.getAproUsrNm();
			/*
			if( doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0 )
			{
				hdr_gl_dt = doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
			}
			*/
			if ( flag.equals("C") )
			{
				/**	최종 승인자 정보( *GL_DT + APRO_FLG = 'Y' + 승인자직책/이름) UPDATE	*/
				dbDao.approvalRequestAccount	(sCsrNo, title_name);  

				/** APPROVAL ACCOUNT UPDATE LOG */
				//dbDao.updateApInvHdrIFErrRsn	(sCsrNo, APRO_ACCOUNT_UPDATED);

				/** APPROVAL ACCOUNT UPDATE LOG */
				//dbDao.updateApInvHdrIFErrRsn	(sCsrNo, EA_IF);
			}

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

	}
 
	/**
	 * EP - > CSR 호출
	 * HPC용 AP_PAY_INV data update하기
	 * @param String csrNo
	 * @param String gubun
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse approvalSrCSR(String csrNo, String gubun) throws EventException {
		try {
			dbDao.updateHPC(csrNo, gubun);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}

		return null;
	}
	
	/**
	 * COM_CSR_0008 : Approval Request 버튼(3만불 이하 결재)<br>
	 * Requesting Approval 의 3만불 이하 Approval Step 저장
	 * @param CsrParmVO csrParmVO
	 * @throws EventException
	 */
	public void approvalStep(CsrParmVO csrParmVO) throws EventException{
		try {
			//8.EP 결제하기 - 결제등록 (COM_APRO_RQST_HDR, ComAproRqstRoutVO)
			dbDao.createCSREPApproval(csrParmVO);
			log.error("\n DONE - approvalStep.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");				
		} catch (DAOException ex) {
			/*
			 * CHM-201535042 기안 중복방지
			 * 에러메시지 수정 
			 * 심성윤 2015.04.14
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR10022", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CSR10022", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * COM_CSR_0015 : 조회버튼 <br>
	 * ERP Interface 대상 CSR의 리스트를 조회합니다.<br>
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @return List<IfCsrListInputVO>
	 * @exception EventException
	 */
	public List<IfCsrListInputVO> searchErpInterfaceList(IfCsrListInputVO ifCsrListInputVO) throws EventException {
		try {
			return dbDao.searchErpInterfaceList(ifCsrListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

}