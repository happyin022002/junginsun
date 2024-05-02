/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : salesrepresentativeBCImpl.java
*@FileTitle : sales rep.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.basic;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration.SalesRepresentativeDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration.SalesRepresentativeEAIDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;

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
	private transient SalesRepresentativeEAIDAO eaiDao = null;

	/**
	 * salesrepresentativeBCImpl object create <br>
	 * Generate salesrepresentativeDBDAO.<br>
	 */
	public SalesRepresentativeBCImpl() {
		dbDao = new SalesRepresentativeDBDAO();
		eaiDao = new SalesRepresentativeEAIDAO();
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
			String srepMaxSeq = dbDao.searchSlsRepMaxSeq(cntCd, account.getUsr_id());

			result = srepMaxSeq;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * Srep Code 정보를 EAI로 전송한다. <BR>
	 * @param String srepCd
	 * @param String usrId
	 * @param String creFlag
	 */
	public void sendSrepCdToMdm(String srepCd, String usrId, String creFlag) throws EventException {
		// error에 대한 추가 처리이므호 exception을 throw하지 않음
		try{
			SalesRepIfVO salesRepIfVO = dbDao.searchSlsRepInterface(srepCd);
			log.debug("Customer EAI Start : ");		
			if (salesRepIfVO != null){
				eaiDao.sendSrepCdToMdm(salesRepIfVO, usrId, creFlag);
			}
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
}