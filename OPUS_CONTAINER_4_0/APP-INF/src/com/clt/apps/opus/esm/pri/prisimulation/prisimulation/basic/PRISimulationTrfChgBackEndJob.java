/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRISimulationTrfChgBackEndJob.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier :
**@LastVersion : 1.0
* 2015.02.09
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.TrfChgVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * PRISimulation Business Logic BackEndJob<br>
 * - Handling a back-end-job about PRICommonData<br>
 *
 * @author SHKIM
 * @see PRISimulationBC, PRISimulationBCImpl
 * @since J2EE 1.6
 */
public class PRISimulationTrfChgBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = 6926316157498470025L;
	private AplyRtInVO aplyRtInVO;
	private SignOnUserAccount account;

	
	public void setAplyRtInVO(AplyRtInVO aplyRtInVO) {
		this.aplyRtInVO = aplyRtInVO;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * BackEndCommand Start
	 * 
	 * @return List<AplyRtOutVO>
	 * @throws Exception
	 */
	public List<TrfChgVO> doStart() throws Exception {
		List<TrfChgVO> trfChgVOs = new ArrayList<TrfChgVO>();
		try {

			PRISimulationBC command = new PRISimulationBCImpl();
			
			trfChgVOs = command.createTariffSurcharge(aplyRtInVO, account);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return trfChgVOs;
	}
}
