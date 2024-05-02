/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestMgtBC.java
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
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic;
 
import java.util.Collection;
import java.util.List;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AutoRevVVDListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOlistVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CheckAsaVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrDtrGrpVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SearchDTRBTtlVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.TAXInfoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
 
/**
 * ALPS-Consultationsliprequestmgt Business Logic Command Interface<br>
 * - ALPS-Consultationsliprequestmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HAM DAE SUNG
 * @see Ui-csr-0001EventResponse 참조
 * @since J2EE 1.6
 */
public interface ConsultationSlipRequestMgtBC { 
	
	/**
	 * COM_CSR_0001 : 조회버튼 <br>
	 * CSR Creation의 리스트를 조회합니다
	 * @param ApPayInvListVO apPayInvListVO
	 * @return List<ApPayInvListVO>
	 * @exception EventException
	 */
	public List<ApPayInvListVO> searchCsrList(ApPayInvListVO apPayInvListVO) throws EventException;
	
	/**
	 * CSR_0004,5 : 화면로드<br>
	 * CSR Creation의 증빙의 default ofc 조회<br>
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getDefOfc(String ofc_cd) throws EventException;
			
	/**
	 * CSR_0001 : 화면로드<br>
	 * CSR Creation의  A/P, ASA 체크<br>
	 * @param CheckAsaVO checkAsaVO
	 * @return CheckAsaVO
	 * @exception EventException
	 */
	public CheckAsaVO checkAsaOffice(CheckAsaVO checkAsaVO) throws EventException;
	
	/**
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param CsrListInputVO csrListInputVO
	 * @return List<CsrListInputVO>
	 * @exception EventException
	 */
	public List<CsrListInputVO> searchCSRSummaryDetail(CsrListInputVO csrListInputVO) throws EventException;	
	
	/**
	 * COM_CSR_0002 : 인보이스 삭제여부 체크 <br>
	 * @param invRgstNo 
	 * @return String
	 * @exception EventException
	 */
	public String verifyInvoiceDeltChk(String invRgstNo) throws EventException;	
	
	/**
	 * COM_CSR_0002 : 결재 유형 변경 가능한 Office인지 체크 (ALPS->GW) <br>
	 * Approval Type 설정용
	 * @param String ofcCd
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAl2GwOfc(String ofcCd, String csrNo) throws EventException;	
	
	
	/**
	 * COM_CSR_0002 : 화면 로드
	 * CSR Creation(Detail)의 asa_no 콤보리스트 조회합니다.<br>
	 * @param String invOfcCd
	 * @param String apOfcCd
	 * @param String issDt
	 * @return List<AsaNoVO>
	 * @throws EventException
	 */
	public List<AsaNoVO> searchAsaNoList(String invOfcCd, String apOfcCd, String issDt) throws EventException;

	/**
	 * COM_CSR_0004 : 화면 로드
	 * EviCode 콤보리스트 조회
	 * @return List<TAXInfoVO>
	 * @throws EventException
	 */
	public List<TAXInfoVO> searchEviCodeList() throws EventException;
	
	/**
	 * COM_CSR_0004 : 화면로드 또는 사업자등록번호 기입 <br>
	 * 사업자등록번호, Vendor Code, 상호, 업태, 주소, 대표자명 조회
	 * @param String compNo
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchTAXInfo(String compNo) throws EventException;
	
	/**
	 * COM_CSR_0004 : 화면로드 <br>
	 * 사업자등록번호 조회 
	 * @param TAXInfoVO tAXInfoVO
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchCompNo(TAXInfoVO tAXInfoVO) throws EventException;
	
	/**
	 * COM_CSR_0004 evid_no 채번및저장 
	 * @param TAXInfoVO tAXInfoVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return TAXInfoVO
	 * @throws EventException
	 */
	public TAXInfoVO searchApEviNo(TAXInfoVO tAXInfoVO, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * COM_CSR_0004 : 완료버튼 <br>
	 * 세금계산서 TAXCode 조회 
	 * @param TAXInfoVO tAXInfoVO
	 * @return TAXInfoVO
	 * @exception EventException
	 */
	public TAXInfoVO searchTAXCode(TAXInfoVO tAXInfoVO) throws EventException;
	
	/**
	 * getAutoRevVVDList : 조회 이벤트 처리<br>
	 * getAutoRevVVDList<br>
	 * @param Collection payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[]
	 * @exception EventException
	 */
	public DBRowSet[] getAutoRevVVDList(Collection payInvVOs, CsrParmVO csrParmVO) throws EventException;
	
	/**
	 * modifyAutoRevVVD : 조회 이벤트 처리<br>
	 * modifyAutoRevVVD<br>
	 * @param List<AutoRevVVDListVO> autoRevVVDListVO
	 * @exception EventException
	 */
	public void modifyAutoRevVVD(List<AutoRevVVDListVO> autoRevVVDListVO) throws EventException;
	
	/**
	 * searchApInvDTRBIn : 조회 이벤트 처리<br>
	 * searchApInvDTRBIn<br>
	 * @param Collection<PayInvVO> payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[]
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBIn(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ConsultationSlipRequestMgt화면에 대한 조회 이벤트 처리<br>
	 * @param Collection<PayInvVO> payInvVOs
	 * @param CsrParmVO csrParmVO
	 * @return DBRowSet[]
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBOut(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws EventException;
	
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
	public String approvalRequest(Collection<PayInvVO> payInvVOs, List<AutoRevVVDListVO> autoRevVVDListVO, List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws EventException;
	
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
	public HdrDtrGrpVO searchPreVeiw(Collection<PayInvVO> payInvVOs, List<AutoRevVVDListVO> autoRevVVDListVO, List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws EventException;
	
	/**
	 * COM_CSR_0008 : CSR Format 버튼 <br>
	 * CSR Format 버튼 구현로직
	 * @param String csrNo
	 * @return HdrDtrGrpVO
	 * @exception EventException
	 */
	public HdrDtrGrpVO tmpSearchPreVeiw(String csrNo) throws EventException;
	
	/**
	 * COM_CSR_0008 : 조회버튼 <br>
	 * CSR I/F Inquiry 의 리스트를 조회합니다.<br>
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @return List<IfCsrListInputVO>
	 * @exception EventException
	 */
	public List<IfCsrListInputVO> searchCsrIfList(IfCsrListInputVO ifCsrListInputVO) throws EventException;
	
	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 리스트폼조회 
	 * @param CSRSOlistVO cSRSOlistVO
	 * @return List<CSRSOlistVO>
	 * @exception EventException
	 */
	public List<CSRSOlistVO> searchCSRSOlist(CSRSOlistVO cSRSOlistVO) throws EventException;	
	
	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 플릿폼조회  : 대체전표로 검색된 해당 SO목록
	 * @param CSRSOhdrVO cSRSOhdrVO
	 * @return CSRSOhdrVO
	 * @exception EventException
	 */
	public CSRSOhdrVO searchCSRSOhdr(CSRSOhdrVO cSRSOhdrVO) throws EventException;	
	
	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * I/F Error 의 Cancel 저장
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void multiConfirmCSR(IfCsrListInputVO ifCsrListInputVO,SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * Approval Requested 의 Cancel 저장
	 * @param  IfCsrListInputVO ifCsrListInputVO
	 * @param  SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void cancelCSR(IfCsrListInputVO ifCsrListInputVO,SignOnUserAccount signOnUserAccount) throws EventException;
	
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
	public void multiRejectedCSRCancellation(Collection<PayInvVO> payInvVOs, String[] chks, CsrParmVO csrParmVO, String userId, String ofcCd) throws EventException;
	
	/**
	 * AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
	 * @param String flag
	 * @param String csrNo
	 * @param String ofcCd
	 * @param ComAproRqstRoutVO comAproRqstRoutVO
	 * @return FNS0080003Document[]
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String csrNo, String ofcCd, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException; 
	
	/**
	 * EP - > CSR 호출
	 * @param String flag
	 * @param String csrNo
	 * @param ComAproRqstRoutVO comAproRqstRoutVO
	 * @exception EventException
	 */
	public void approvalRequestAccount2(String flag, String csrNo, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException;
	
	/**
	 * 
	 * @param String csrNo
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String createApInvIF(String csrNo, String ofcCd) throws EventException;

    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;
	
	/**
	 * COM_CSR_0008 : Approval Request 버튼(3만불 이하 결재)<br>
	 * Requesting Approval 의 3만불 이하 Approval Step 저장
	 * @param CsrParmVO csrParmVO
	 * @throws EventException
	 */
	public void approvalStep(CsrParmVO csrParmVO) throws EventException;
	
	/**
	 * COM_CSR_0015 : 조회버튼 <br>
	 * ERP Interface 대상 CSR의 리스트를 조회합니다.<br>
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @return List<IfCsrListInputVO>
	 * @exception EventException
	 */
	public List<IfCsrListInputVO> searchErpInterfaceList(IfCsrListInputVO ifCsrListInputVO) throws EventException;

}