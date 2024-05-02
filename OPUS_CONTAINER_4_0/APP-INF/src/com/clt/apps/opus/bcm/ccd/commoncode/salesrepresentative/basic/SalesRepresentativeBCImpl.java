/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : salesrepresentativeBCImpl.java
*@FileTitle : sales rep.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.basic;
 
import com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.integration.SalesRepresentativeDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;

/**
 * Sales representative Business Logic Command Interface<br>
 * An interface to the business logic for Sales representative<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class SalesRepresentativeBCImpl extends BasicCommandSupport implements SalesRepresentativeBC {

	// Database Access Object
	private transient SalesRepresentativeDBDAO dbDao = null;

	/**
	 * salesrepresentativeBCImpl object create <br>
	 * Generate salesrepresentativeDBDAO.<br>
	 */
	public SalesRepresentativeBCImpl() {
		dbDao = new SalesRepresentativeDBDAO();
	}
	
	/**
	 * sls rep code should look up the detailed information.<br>
	 * 
	 * @param String srepCd
	 * @return SalesRepVO
	 * @exception EventException
	 */
	public SalesRepVO searchSlsRepCode(String srepCd) throws EventException{
		try {
			return dbDao.searchSlsRepCode(srepCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * sls rep code should look up the detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return SalesRepVO
	 * @exception EventException
	 */
	public SalesRepVO searchSlsRepRqst(String rqstNo) throws EventException{
		try {
			return dbDao.searchSlsRepRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Sls rep code generation, and queried the new sls rep code to modify the details. <br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception EventException
	 */
	public void manageSlsRepCode(SalesRepVO salesRepVO) throws EventException{
		try {
			if(salesRepVO.getIbflag().equals("I")){
				dbDao.addSlsRepCode(salesRepVO);
			}else if (salesRepVO.getIbflag().equals("U")){
				dbDao.modifySlsRepCode(salesRepVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Sls rep code generation, and queried the new sls rep code to modify the details. <br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception EventException
	 */
	public void manageSlsRepRqst(SalesRepVO salesRepVO) throws EventException{
		try {
			if(salesRepVO.getIbflag().equals("I")){
				dbDao.addSlsRepRqst(salesRepVO);
			}else if (salesRepVO.getIbflag().equals("U")){
				dbDao.modifySlsRepRqst(salesRepVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * sls rep code to query the last seq .<br>
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchSlsRepMaxSeq(String cntCd, SignOnUserAccount account) throws EventException{
		String result = "";
		try {
			String srepMaxSeq = dbDao.searchSlsRepMaxSeq(cntCd);
			
			if(srepMaxSeq.equals("001")) {
				dbDao.addSrepMaxSeq(cntCd, account);
				return srepMaxSeq;
			}
			
			dbDao.modifySrepMaxSeq(cntCd, account);
			result = srepMaxSeq;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
}