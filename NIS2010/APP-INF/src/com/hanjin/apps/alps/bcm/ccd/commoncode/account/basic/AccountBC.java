/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountBC.java
*@FileTitle : Account
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.basic;
 
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.AccountVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.ChargeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.CurrencyVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.RepChargeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
 
/**
 * Account Business Logic Command Interface<br>
 * An interface to the business logic for Account <br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface AccountBC {

	/**
	 * Account retrieve<br>
	 * 
	 * @param String acctCd
	 * @return List<AccountVO>
	 * @exception EventException
	 */
	public List<AccountVO> searchAccountCode(String acctCd) throws EventException;

	/**
	 * Account save(adding/changing)<br>
	 * 
	 * @param acctVOs AccountVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageAccountCode(AccountVO[] acctVOs, String usrId) throws EventException;
	
	/**
	 * Charge retrieve<br>
	 * 
	 * @param String chgCd
	 * @return List<ChargeVO>
	 * @exception EventException
	 */
	public List<ChargeVO> searchChargeCode(String chgCd) throws EventException;
	
	/**
	 * Charge retrieve<br>
	 * 
	 * @param String	rqstNo
	 * @return List<ChargeVO>
	 * @exception EventException
	 */
	public String searchChargeRqst(String chgCd) throws EventException;

	/**
	 * Charge save(adding/changing)<br>
	 * 
	 * @param chgVOs ChargeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageChargeCode(ChargeVO chgVO, String usrId) throws EventException;
	
	/**
	 * Charge save(adding/changing)<br>
	 * 
	 * @param chgVOs ChargeVO[]
	 * @param usrId String
	 * @param rqstNo String
	 * @exception EventException
	 */
	public void manageChargeRqst(ChargeVO[] chgVOs, String usrId, String rqstNo) throws EventException;
	
	/**
	 * Rep Charge retrieve<br>
	 * 
	 * @param String repChgCd
	 * @return List<RepChargeVO>
	 * @exception EventException
	 */
	public List<RepChargeVO> searchRepChgCode(String repChgCd) throws EventException;
	
	/**
	 * Rep Charge Code duplicate checking<br>
	 * 
	 * @param String repChgCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchRepChgCodeChk(String repChgCd) throws EventException;

	/**
	 * Rep Charge save(adding/changing)<br>
	 * 
	 * @param repChgVOs RepChargeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRepChgCode(RepChargeVO[] repChgVOs, String usrId) throws EventException;
	
	/**
	 * Currency retrieve<br>
	 * 
	 * @param String currCd
	 * @return List<RepChargeVO>
	 * @exception EventException
	 */
	public List<CurrencyVO> searchCurrCode(String currCd) throws EventException;

	/**
	 * Currency save(adding/changing)<br>
	 * 
	 * @param currVOs CurrencyVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCurrCode(CurrencyVO[] currVOs, String usrId) throws EventException;
	
}