/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeBC.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtOutVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrSrhCondVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.TrfChgVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * PRISimulation Business Logic Command Interface<br>
 * - Handling a biz logic about PRISimulation<br>
 *
 * @author SHKIM
 * @see EsmPri6001EventResponse
 * @since J2EE 1.6
 */
public interface PRISimulationBC { 
	
	
	//[ESM_PRI_6101] START########################################
	/**
	 * get the result for Contract Info of SC<br>
	 * 
	 * @param PriCntrSrhCondVO priCntrSrhCondVO 
	 * @return List<PriCntrInfoVO>
	 * @exception EventException
	 */
	public List<PriCntrInfoVO> searchContractInfoList(PriCntrSrhCondVO priCntrSrhCondVO) throws EventException;
	
	//[ESM_PRI_6101] END########################################
	
	/**
	 * ESM_PRI_6001 : Retrieve <br>
	 * retrieving created product catalog list
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception EventException
	 */
	public List<PriSimRoutInfoVO> searchProductCatalog(AplyRtInVO aplyRtInVO) throws EventException;
	
	/**
	 * ESM_PRI_6001 : Retrieve <br>
	 * Applying rate with selected route and contract
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return List<AplyRtOutVO>
	 * @exception EventException
	 */
	public List<AplyRtOutVO> createApplyRate(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_6001 : Contract No Change<br>
	 * Checking Contract Type. (SC,RFA,TAA)<br>
	 * 
	 * @param String ctrtNo
	 * @return String
	 * @exception EventException
	 */
	public String checkCtrtType(String ctrtNo) throws EventException;
	
	/**
	 * ESM_PRI_6102 : Retrieve <br>
	 * get the result for Revenue Detail Info of Selected Container Size,Commodity
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception EventException
	 */
	public List<AplyRtOutVO> searchRevenueDetailInfo(AplyRtInVO aplyRtInVO) throws EventException;
	
	/**
	 * Putting in action BackEndJob to create and retrieve rating result - Verify Rate/Apply Rate<br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createApplyRateBackEndJobStart(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param aplyRtInVO
	 * @return
	 * @throws EventException
	 */
	public List<PriSimRoutInfoVO> searchCMCost(AplyRtInVO aplyRtInVO) throws EventException;

	/**
	 * ESM_PRI_6002 : Retrieve <br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return List<TrfChgVO>
	 * @exception EventException
	 */
	public List<TrfChgVO> createTariffSurcharge(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_6002 : Subject To Tariff Surcharge
	 * 
	 * @param aplyRtInVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String createTrfChgBackEndJobStart(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_6002 
	 * @param String pctlNo
	 * @return
	 * @throws EventException
	 */
	public List<TrfChgVO> searchChgCd(String pctlNo) throws EventException;
	/**
	 * ESM_PRI_6002 
	 * @param String por
	 * @return
	 * @throws EventException
	 */
	public List<AplyRtInVO> searchSlsOfcCd(String por) throws EventException;
	
	/**
	 * ESM_PRI_6001 : searchChgCd <br>
	 * 
	 * @param String pctlNo
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcScp(String pctlNo) throws EventException;

	/**
	 * ESM_PRI_6001 : searchTrnsMod <br>
	 * 
	 * @param String pctlNo
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTrnsMod(String pctlNo) throws EventException;

	/**
	 * Set parameter for verify rate
	 * @param AplyRtInVO vo
	 * @param String usrID
	 * @exception EventException
	 */
	public void managePriSimPara(AplyRtInVO vo, String usrId) throws EventException;

}
