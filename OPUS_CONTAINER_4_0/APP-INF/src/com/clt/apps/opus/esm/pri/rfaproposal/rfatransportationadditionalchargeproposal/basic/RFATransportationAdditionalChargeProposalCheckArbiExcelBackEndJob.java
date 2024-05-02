/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalCheckArbiExcelBackEndJob.java
*@FileTitle : check the RFA Location of Arbi's Point and Base Port
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * handling a biz logic about Checking Upload RFA Charge Excel Info
 * 
 * @author 
 * @see RFATransportationAdditionalChargeProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class RFATransportationAdditionalChargeProposalCheckArbiExcelBackEndJob  extends BackEndCommandSupport{
	private static final long serialVersionUID = -5479624864120463390L;
	
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS;
	private SignOnUserAccount account;
	
	/**
	 * login user Info  <br>
	 *  
	 * @param SignOnUserAccount account
	 */	
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * Upload Excel Info <br>
	 *  
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS
	 */	
	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS) {
		if (priRpScpTrspAddChgVOS != null) {
			PriRpScpTrspAddChgVO[] tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOS.length];
			System.arraycopy(priRpScpTrspAddChgVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpTrspAddChgVOS = tmpVOs;
		}
	}

	/**
	 * ESM_PRI_2050 <br>
	 * check the Location of Arbi's Point and Base Port. <br>
	 *  
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception Exception
	 */
	 public List<RsltPriRpScpTrspAddChgVO> doStart() throws Exception {
		 List<RsltPriRpScpTrspAddChgVO> resultVOS = new ArrayList<RsltPriRpScpTrspAddChgVO>();
		 try {
			 RFATransportationAdditionalChargeProposalBC cmd = new RFATransportationAdditionalChargeProposalBCImpl();
			 
			 log.debug("\n ▶▶▶▶▶[START] insert the Arbi Load Excel into Global Temp Table");
			 //(1) insert Global Tempory Table with excel data
			 cmd.addArbiLoadExcelGblTmpTbl(priRpScpTrspAddChgVOS, account);
			 log.debug("\n ▶▶▶▶▶[END] insert the Arbi Load Excel into Global Temp Table");
			 
			 //(2) return json data about the result of check
			 resultVOS = cmd.chkArbiLoadExcel(priRpScpTrspAddChgVOS);


		 }catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);			
		 }
			
		 return resultVOS;
		 
		 

	 }
	 
}
