/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyReleaseRedeliveryOrderMgtBC.java
 *@FileTitle : EmptyReleaseRedeliveryOrderMgtBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchRelredMasterForEdiVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Emptyreleaseredeliveryordermgt Business Logic Command Interface<br>
 * 
 * @author
 * @see ESD_TRS_0428EventResponse reference
 * @see ESD_TRS_0451EventResponse reference
 * @see ESD_TRS_0429EventResponse reference
 * @since J2EE 1.6
 */
public interface EmptyReleaseRedeliveryOrderMgtBC {

	/**
	 * ESD_TRS_0428 : retrieving Country List
	 * 
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws EventException;

	/**
	 * ESD_TRS_0428 : retrieving Organization List
	 * 
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving CimCStock IssueList
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<AbstractValueObject>
	 * @exception EventException
	 */
	public List<AbstractValueObject> searchIssueList(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * ESD_TRS_0429 : settling CimCStock IssuedOrder
	 * 
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void settleIssuedOrder(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving fax information for RD
	 * 
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchRDContent(CimCStockVO[] cimCStockVOs) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving related data to be saved after sending fax
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving loc_cd for user ID
	 * 
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String getUserLocCd(String userId) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving So_Ofc and NextVAL for Redelivery-M-Issued
	 * 
	 * @param String userOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws EventException;

	/**
	 * ESD_TRS_0429 : getting FAX No and Email for Yard Code
	 * 
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException;

	/**
	 * BackEndJob - returning BackEndJob status
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException;

	/**
	 * ESD_TRS_0429 : RD Fax/Mail Send (btn_confirm in ESD_TRS_0451)
	 * 
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException;

	/**
	 * ESD_TRS_0429 : retrieving RD Content
	 * 
	 * @param String stkFaxSndNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws EventException;

	/**
	 * Common : updating STOCK in case server is EUR when registering CTM MOVEMENT
	 * 
	 * @param CrossItemVO crossItemVO
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO);

	/**
	 * ESD_TRS_0429 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 * 
	 * @param cimCStockVO
	 * @return String
	 * @throws EventException
	 */
	public String checkEdiYardSetup(SearchRelredMasterForEdiVO cimCStockVO) throws EventException;

	/**
	 * 
	 * @param event
	 * @param previewVO
	 * @param relRedVo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String[] makeFlatFileReleaseReDelivery(EsdTrs0024Event event, WorkOrderPreviewVO previewVO, SearchRelredMasterForEdiVO relRedVo, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param woVO
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchRelRedMasterData(WorkOrderPreviewVO woVO, String type) throws EventException;

	/**
	 * 
	 * @param cimCStockVOs
	 * @throws EventException
	 */
	public void sendReleaseRedeliveryFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException;

	/**
	 * 
	 * @param soVO
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchRelRedMasterData(CimCStockVO soVO, String type) throws EventException;

	/**
	 * ESD_TRS_0429 : EDI resend<br>
	 * 
	 * @param relRedVo
	 * @param cimCStockVOs
	 * @return
	 * @throws EventException
	 */
	public String resendEdi(SearchRelredMasterForEdiVO relRedVo, CimCStockVO[] cimCStockVOs) throws EventException;
}