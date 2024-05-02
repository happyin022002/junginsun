/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.AuthorityCarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-renewalmasterdatamgt Business Logic Command Interface<br>
 * - OPUS-renewalmasterdatamgt: Business Logic Interface<br>
 *
 * @author
 * @see Ui_joo_0028EventResponse
 * @since J2EE 1.4
 */

public interface RenewalMasterDataMgtBC {
	
	/**
	 * retrieving Carrier
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchCarrierList(MstConditionVO mstConditionVO) throws EventException;

	/**
	 * Authority Carrier 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<AuthorityCarrierVO> searchAuthorityCarrierList(MstConditionVO mstConditionVO) throws EventException;	

	/**
     * FNS_JOO_0090 : Save
     * saving Authority Carrier<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_CRR_AUTH 화면 Data 분류(D/U/I)
     *  2. JOO_CRR_AUTH Delete
     *  3. JOO_CRR_AUTH Update
     *  4. JOO_CRR_AUTH Insert
     *  
     * @param  AuthorityCarrierVO[] authorityCarrierVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageAuthorityCarrier(AuthorityCarrierVO[] authorityCarrierVOs, SignOnUserAccount signOnUserAccount) throws EventException;    

	/**
	 * Financial Affairs Matrix 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws EventException
	 */
	public List<FinancialAffairsMtxVO> searchFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws EventException;

	/**
	 * Financial Affairs Matrix Create 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws EventException
	 */
	public List<FinancialAffairsMtxVO> calculateFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws EventException;
	

	/**
     * FNS_JOO_0089 : Save
     * saving Financial Affairs matrix<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_FIN_MTX
     *  1.1. Revenue Financial Affairs matrix
     *  1.2. Expense Financial Affairs matrix
     *  2. Revenue/Expense Delete
     *  3. Revenue/Expense Update
     *  4. Revenue/Expense Insert
     *  
     * @param  FinancialAffairsMtxGrpVO financialAffairsMtxGrpVO
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageFinancialAffairsMtx(FinancialAffairsMtxGrpVO financialAffairsMtxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
     * FNS_JOO_0088 : Save
     * saving Carrier & Carrier Auth & Fin Mtx Creation<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_CARRIER 
     *  2. JOO_CRR_AUTH
     *  3. JOO_FIN_MTX
     *  
     * @param  CarrierVO[] carrierVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageCarrier(CarrierVO[] carrierVOs, SignOnUserAccount signOnUserAccount) throws EventException;
}