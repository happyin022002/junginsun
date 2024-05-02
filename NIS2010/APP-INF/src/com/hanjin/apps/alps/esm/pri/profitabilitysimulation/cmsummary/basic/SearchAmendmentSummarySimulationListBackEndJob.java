/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAmendmentSummarySimulationListBackEndJob.java
*@FileTitle : S/C Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration.CMSummaryDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummarySimulationDateParamVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * S/C Rate Search 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author  Min Seok, Song
 * @see CMSummaryDBDAO
 * @since J2EE 1.6
 */
public class SearchAmendmentSummarySimulationListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private  CMSummaryDBDAO dbDao = new CMSummaryDBDAO();
	
	private SignOnUserAccount account;
	private InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO; 
	private InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO; 

	/**
	 * 조회를 위한 parameter를 셋팅한다. <br>
	 *  
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return 
	 * @exception
	 */
	public void setSearchParameterVOs(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO,SignOnUserAccount account) {
		this.account = account;
		this.inPrsAmendmentCmSummaryVO = inPrsAmendmentCmSummaryVO;
		this.inPrsAmendmentSummarySimulationSetVO = inPrsAmendmentSummarySimulationSetVO;
	}

	/**
	 * SC Summary Simulation을 위해  temp table에 데이터를 생성하고 simulation update후 결과를 조회한다. <br>
	 *  
	 * @return DBRowSet
	 * @exception Exception
	 */
	public DBRowSet doStart() throws Exception {
		DBRowSet rowSet;
		try {
			
			inPrsAmendmentCmSummaryVO.setUsrId(account.getUsr_id());
			String simulTpCd = inPrsAmendmentCmSummaryVO.getSimulTpCd();
			// Temp Table에 Key를 먼저 insert한다.
			dbDao.addPriPrsCmSmrySimTmpAmdt( inPrsAmendmentCmSummaryVO );
			List<RsltPrsAmendmentCmSummarySimulationDateParamVO> dateParam = dbDao.searchSimulationParamDate(inPrsAmendmentCmSummaryVO);
			dbDao.addSimulationDataForAmendmentSummary(inPrsAmendmentCmSummaryVO,dateParam.get(0));
			//Rate,Surchage에 대해 simulation할때만 surchage 데이터를 만든다.
			if( simulTpCd.equals("B") ){
				dbDao.addSimulationDataForAmendmentSummarySurcharge(inPrsAmendmentCmSummaryVO,dateParam.get(0));
			}
			//SIMULATION을 위한 UPDATE
			dbDao.modifySimulationCostDetailDataForAmendmentSummary( inPrsAmendmentCmSummaryVO ,  inPrsAmendmentSummarySimulationSetVO);
			
			
			//Rate,Surchage에 대해 simulation할때만 surchage 데이터를 Update한다.
			if( simulTpCd.equals("B") ){
				//SIMULATION을 위한 UPDATE
				dbDao.modifySimulationCostSurchargeDataForAmendmentSummary( inPrsAmendmentCmSummaryVO ,  inPrsAmendmentSummarySimulationSetVO);
			}			
			
			
			if( simulTpCd.equals("A") ){
				rowSet = dbDao.searchAmendmentSummarySimulation1StTypeList ( inPrsAmendmentCmSummaryVO ) ;
			}else{
				//Rate,Surchage에 대해 simulation할때만 surchage data를 join해서  데이터를 조회한다.
				rowSet = dbDao.searchAmendmentSummarySimulation2NdTypeList ( inPrsAmendmentCmSummaryVO ) ;
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rowSet;
	}
}
