/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultBCImpl.java
*@FileTitle : RA Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration.ServiceProviderRelationshipAttractivenessResultDBDAO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchServiceProviderRelationshipAttractivenessResultListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SpeRltAtrcRsltAddVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ServiceProviderResultManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-ServiceProviderResultManage<br>
 *
 * @author
 * @see ESD_SPE_0004EventResponse,ServiceProviderRelationshipAttractivenessResultBC
 * @since J2EE 1.6
 */
public class ServiceProviderRelationshipAttractivenessResultBCImpl extends BasicCommandSupport implements ServiceProviderRelationshipAttractivenessResultBC {

	// Database Access Object
	private transient ServiceProviderRelationshipAttractivenessResultDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating ServiceProviderRelationshipAttractivenessResultDBDAO class<br>
	 */
	public ServiceProviderRelationshipAttractivenessResultBCImpl() {
		dbDao = new ServiceProviderRelationshipAttractivenessResultDBDAO();
	}
	/**
	 * Retrieving the list of service provider relationship attractiveness result.
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipAttractivenessResultListVO>
	 * @exception EventException
	 */
	public List<SearchServiceProviderRelationshipAttractivenessResultListVO> searchServiceProviderRelationshipAttractivenessResultList(SearchInputListVO searchInputListVO) throws EventException {
		try {
			return dbDao.searchServiceProviderRelationshipAttractivenessResultListRSQL(searchInputListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Managing the data of SpeRltAtrcRslt.<br>
	 * 
	 * @param SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void multiSpeRltAtrcRslt(SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SpeRltAtrcRsltAddVO> insertVoList = new ArrayList<SpeRltAtrcRsltAddVO>();
			List<SpeRltAtrcRsltAddVO> updateVoList = new ArrayList<SpeRltAtrcRsltAddVO>();
			List<SpeRltAtrcRsltAddVO> deleteVoList = new ArrayList<SpeRltAtrcRsltAddVO>();
			for ( int i=0; i<speRltAtrcRsltAddVOs .length; i++ ) {
				if ( speRltAtrcRsltAddVOs[i].getIbflag().equals("I")){
					speRltAtrcRsltAddVOs[i].setCreUsrId(account.getUsr_id());
					speRltAtrcRsltAddVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(speRltAtrcRsltAddVOs[i]);
				} else if ( speRltAtrcRsltAddVOs[i].getIbflag().equals("U")){
					speRltAtrcRsltAddVOs[i].setCreUsrId(account.getUsr_id());
					speRltAtrcRsltAddVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(speRltAtrcRsltAddVOs[i]);
				} else if ( speRltAtrcRsltAddVOs[i].getIbflag().equals("D")){
					speRltAtrcRsltAddVOs[i].setCreUsrId(account.getUsr_id());
					speRltAtrcRsltAddVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(speRltAtrcRsltAddVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpeRltAtrcRslt(insertVoList);
				log.debug( "insert_a------------------------------------------------------------------------");
				dbDao.modifySpeRltSegmRslt(insertVoList);
				log.debug( "insert_b------------------------------------------------------------------------");
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpeRltAtrcRslt(updateVoList);
				log.debug( "a------------------------------------------------------------------------");
				dbDao.modifySpeRltSegmRslt(updateVoList);
				log.debug( "b------------------------------------------------------------------------");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSpeRltAtrcRslt(deleteVoList);
				dbDao.modifySpeRltSegmRslt(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}