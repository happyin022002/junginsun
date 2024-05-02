/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtBC.java
*@FileTitle : EmptyReleaseRedeliveryOrderMgtBC
*Open Issues :
*Change history : 2009.05.04 (김상수) - EES_CTM_0428 관련업무 최초생성
*                 2009.07.27 (김상수) - EES_CTM_0426 관련업무 추가
*                 2009.08.18 (김상수) - EES_CTM_0429 관련업무 추가
*@LastModifyDate : 2009.08.18
*@LastModifier : 김상수
*@LastVersion : 1.1
* 2009.05.04 김상수
* 1.0 Creation
* 2009.07.27 김상수
* 1.1 Modification
* 2009.08.18 김상수
* 1.3 Modification
* 2011.09.15 나상보[CHM-201113087] Empty Release/Redelivery Order EDI 전송 신규 추가
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic; 

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchTerritoryForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Emptyreleaseredeliveryordermgt Business Logic Command Interface<br>
 * - ALPS-Emptyreleaseredeliveryordermgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang Soo
 * @see Ees_ctm_0428EventResponse 참조
 * @see Ees_ctm_0426EventResponse 참조
 * @see Ees_ctm_0451EventResponse 참조
 * @see Ees_ctm_0429EventResponse 참조
 * @since J2EE 1.6
 */
public interface EmptyReleaseRedeliveryOrderMgtBC {

	/**
	 * EES_CTM_0428 : 화면에 보여질 Territory List를 조회합니다.<br>
	 *
	 * @param CimTerritoryVO cimTerritoryVO
	 * @return List<CimTerritoryVO>
	 * @exception EventException
	 */
	public List<CimTerritoryVO> searchTerritoryList(CimTerritoryVO cimTerritoryVO) throws EventException;

	/**
	 * EES_CTM_0428 : sheet Combo용 Country List를 조회합니다.<br>
	 *
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws EventException;

	/**
	 * EES_CTM_0428 : sheet Combo용 Organization List를 조회합니다.<br>
	 *
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws EventException;

	/**
	 * EES_CTM_0428 : CimTerritory에 대한 멀티이벤트를 처리합니다.<br>
	 *
	 * @param CimTerritoryVO[] cimTerritoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerritory(CimTerritoryVO[] cimTerritoryVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : 사용자 ofcCd에 따른 Multicombo용 TerritoryList를 조회합니다.<br>
	 *
	 * @param String ofcCd
	 * @return List<SearchTerritoryForMultiComboVO>
	 * @throws EventException
	 */
    public List<SearchTerritoryForMultiComboVO> searchTerritoryForMultiCombo(String ofcCd) throws EventException;

	/**
	 * EES_CTM_0426 : CimCStock IssueList을 조회합니다.<br>
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchIssueList(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * EES_CTM_0426 : CimCStock IssuedOrder을 settle합니다.<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void settleIssuedOrder(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : RD에 보여질 fax내용을 조회<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchRDContent(CimCStockVO[] cimCStockVOs) throws EventException;

	/**
	 * EES_CTM_0426 : fax 전송후 DB에 저장할 관련데이터를 조회합니다.<br>
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * EES_CTM_0426 : fax결과에 대한 멀티이벤트를 처리합니다. (STOCK테이블)<br>
	 *
	 * @param List<CimCStockVO> cimCStockVOs
	 * @exception EventException
	 */
	public void manageSTKsendFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException;

	/**
	 * EES_CTM_0426 : 사용자ID로 LOC_CD를 조회합니다.(fax결과에 대한 멀티이벤트를 처리용)<br>
	 *
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String getUserLocCd(String userId) throws EventException;

	/**
	 * EES_CTM_0426 : Redelivery-M-Issued용 So_Ofc와 NextVAL을 조회합니다.(fax결과에 대한 멀티이벤트를 처리용)<br>
	 *
	 * @param String userOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws EventException;

	/**
	 * EES_CTM_0426 : Yard Code로 해당Yard의 FAX No와 Email가져옴<br>
	 *
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException;

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException;

	/**
	 * EES_CTM_0429 : BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param CimCStockVO cimCStockVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobSettledOrderList(SignOnUserAccount account, CimCStockVO cimCStockVO);

	/**
	 * EES_CTM_0429 : CimCStock SettledOrderList를 조회<br>
	 *
	 * @param String key
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchSettledOrderList(String key) throws EventException;

	/**
	 * EES_CTM_0429 : SettledOrderList에 대한 멀티이벤트를 처리합니다. (STOCK테이블)<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSTKRecovery(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_CTM_0426 : RD Fax/Mail Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException;

	/**
	 * EES_CTM_0426 : RD Content를 조회<br>
	 *
	 * @param String stkFaxSndNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws EventException;

	/**
	 * CTM Common : CTM MOVEMENT 등록시 서버가 EUR인경우 STOCK Update<br>
	 *
	 * @param CrossItemVO crossItemVO
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO);
	
	/**
	 * EES_CTM_0426 : EDI Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String sendEdi(CimCStockVO[] cimCStockVOs) throws EventException;
	
	/**
	 * EES_CTM_0426 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @exception EventException
	 */
	public String checkEdiYardSetup(String yardCd) throws EventException;
}