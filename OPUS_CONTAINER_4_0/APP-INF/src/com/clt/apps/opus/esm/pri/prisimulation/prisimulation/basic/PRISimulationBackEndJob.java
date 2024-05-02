/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRISimulationBackEndJob.java
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

import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration.PRICommonDataDBDAO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtOutVO;
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
public class PRISimulationBackEndJob extends BackEndCommandSupport{
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
	 * @return List<AplyRtOutVO>
	 * @throws Exception
	 */
	public List<AplyRtOutVO> doStart() throws Exception {
		List<AplyRtOutVO> aplyRtOutVOs = new ArrayList<AplyRtOutVO>();
		try {
				PRISimulationBC command = new PRISimulationBCImpl();
				aplyRtOutVOs = command.createApplyRate(aplyRtInVO, account);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return aplyRtOutVOs;
	}
}
