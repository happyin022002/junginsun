/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountBCImpl.java
*@FileTitle : Account
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration.AccountDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.AccountVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.ChargeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.CurrencyVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.account.vo.RepChargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * Account Business Logic Command Interface<br>
 * An interface to the business logic for Account <br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class AccountBCImpl extends BasicCommandSupport implements AccountBC {

	// Database Access Object
	private transient AccountDBDAO dbDao = null;

	/**
	 * accountBCImpl object creation<br>
	 * Generate accountDBDAO.<br>
	 */
	public AccountBCImpl() {
		dbDao = new AccountDBDAO();
	}
	/**
	 * Account retrieve<br>
	 * 
	 * @param String acctCd
	 * @return List<AccountVO>
	 * @exception EventException
	 */
	public List<AccountVO> searchAccountCode(String acctCd) throws EventException {
		try {
			return dbDao.searchAccountCode(acctCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Account Code  multi event process(adding/changing)<br>
	 * 
	 * @param AccountVO[] acctVOs
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageAccountCode(AccountVO[] acctVOs, String usrId) throws EventException{
		try {

			List<AccountVO> addVoList = new ArrayList<AccountVO>();
			List<AccountVO> modifyVoList = new ArrayList<AccountVO>();

			if(acctVOs[0].getIbflag().equals("I")) {
				acctVOs[0].setCreUsrId(usrId);
				addVoList.add(acctVOs[0]);

			} else if(acctVOs[0].getIbflag().equals("U")) {
				acctVOs[0].setUpdUsrId(usrId);
				modifyVoList.add(acctVOs[0]);
			}

		//date adding
		if(addVoList.size() > 0) {
			dbDao.addAccountCode(addVoList);
		}
		
		//date changing
		if(modifyVoList.size() > 0) {
			dbDao.modifyAccountCode(modifyVoList);
		}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Charge Code retrieve<br>
	 * 
	 * @param String chgCd
	 * @return List<ChargeVO>
	 * @exception EventException
	 */
	public List<ChargeVO> searchChargeCode(String chgCd) throws EventException {
		try {
			return dbDao.searchChargeCode(chgCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Charge Code retrieve<br>
	 * 
	 * @param String rqstNo
	 * @return List<ChargeVO>
	 * @exception EventException
	 */
	public String searchChargeRqst(String chgCd) throws EventException {
		DBRowSet rowSet = null;
        String check = "";
		try {
			rowSet=dbDao.searchChargeRqst(chgCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Charge Code  multi event process(adding/changing)<br>
	 * 
	 * @param ChargeVO[] chgVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageChargeCode(ChargeVO chgVO, String usrId) throws EventException{
		try {

			if(chgVO.getIbflag().equals("I")) {
				chgVO.setCreUsrId(usrId);
				dbDao.addChargeCode(chgVO);

			} else if(chgVO.getIbflag().equals("U")) {
				chgVO.setUpdUsrId(usrId);
				dbDao.modifyChargeCode(chgVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Charge Code  multi event process(adding/changing)<br>
	 * 
	 * @param ChargeVO[] chgVOs
	 * @param String usrId
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageChargeRqst(ChargeVO[] chgVOs, String usrId, String rqstNo) throws EventException{
		try {

			List<ChargeVO> addVoList = new ArrayList<ChargeVO>();
			List<ChargeVO> modifyVoList = new ArrayList<ChargeVO>();

			if(chgVOs[0].getIbflag().equals("I")) {
				chgVOs[0].setRqstNo(rqstNo);
				chgVOs[0].setCreUsrId(usrId);
				addVoList.add(chgVOs[0]);

			} else if(chgVOs[0].getIbflag().equals("U")) {
				chgVOs[0].setRqstNo(rqstNo);
				chgVOs[0].setUpdUsrId(usrId);
				modifyVoList.add(chgVOs[0]);
			}

		if(addVoList.size() > 0) {
			dbDao.addChargeRqst(addVoList);
		}
		
		if(modifyVoList.size() > 0) {
			dbDao.modifyChargeRqst(modifyVoList);
		}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Rep Charge retrieve<br>
	 * 
	 * @param String repChgCd
	 * @return List<RepChargeVO>
	 * @exception EventException
	 */
	public List<RepChargeVO> searchRepChgCode(String repChgCd) throws EventException {
		try {
			return dbDao.searchRepChgCode(repChgCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Rep Charge Code duplicate checking <br>
	 * 
	 * @param String repChgCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchRepChgCodeChk(String repChgCd) throws EventException {
		try {
			return dbDao.searchRepChgCodeChk(repChgCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Charge Code  multi event process(adding/changing)<br>
	 * 
	 * @param repChgVOs RepChargeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRepChgCode(RepChargeVO[] repChgVOs, String usrId) throws EventException{
		try {
				List<RepChargeVO> addVoList = new ArrayList<RepChargeVO>();
				List<RepChargeVO> modifyVoList = new ArrayList<RepChargeVO>();

				for(int i=0; i<repChgVOs.length; i++) {
					if(repChgVOs[i].getIbflag().equals("I")) {
						repChgVOs[i].setCreUsrId(usrId);
						addVoList.add(repChgVOs[i]);
	
					} else if(repChgVOs[i].getIbflag().equals("U")) {
						repChgVOs[i].setUpdUsrId(usrId);
						modifyVoList.add(repChgVOs[i]);
					}
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addRepChgCode(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyRepChgCode(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Currency retrieve<br>
	 * 
	 * @param String currCd
	 * @return List<CurrencyVO>
	 * @exception EventException
	 */
	public List<CurrencyVO> searchCurrCode(String currCd) throws EventException {
		try {
			return dbDao.searchCurrCode(currCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Currency  multi event process(adding/changing)<br>
	 * 
	 * @param currVOs CurrencyVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCurrCode(CurrencyVO[] currVOs, String usrId) throws EventException{
		try {
				List<CurrencyVO> addVoList = new ArrayList<CurrencyVO>();
				List<CurrencyVO> modifyVoList = new ArrayList<CurrencyVO>();

				if(currVOs[0].getIbflag().equals("I")) {
					currVOs[0].setCreUsrId(usrId);
					addVoList.add(currVOs[0]);

				} else if(currVOs[0].getIbflag().equals("U")) {
					currVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(currVOs[0]);
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addCurrCode(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyCurrCode(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}