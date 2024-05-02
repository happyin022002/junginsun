/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TPBInterfaceBCImpl.java
*@FileTitle : 3rd Party Interface (Receive; Source=>TPB)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.tpbinterface.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.common.tpbinterface.integration.TPBInterfaceDBDAO;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * -ESD Business Logic Basic Command implementation<br>
 * - -ESD Business Logic Interface<br>
 * 
 * @author 
 * @see ESD_TPB_015EventResponse,OutstandingManageBC DAO class reference
 * @since J2EE 1.4
 */
public class TPBInterfaceBCImpl   extends BasicCommandSupport implements TPBInterfaceBC {
	
	// Database Access Object
	private transient TPBInterfaceDBDAO dbDao=null;

	/**
	 * TPBInterfaceBCImpl object creation<br>
	 * TPBInterfaceDBDAO creation<br>
	 */
	public TPBInterfaceBCImpl(){
		dbDao = new TPBInterfaceDBDAO();
	}
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException{
		log.error("TPB Common createTESTPB Start");
		boolean isSuccessful = false;
		try {
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				log.error("tpbInterfaceVO[i].getTmlIfOfcCd()============>>>>>>>>>>>>"+tpbInterfaceVO[i].getTmlIfOfcCd());
				log.error("tpbInterfaceVO[i].getTmlIfSeq()============>>>>>>>>>>>>"+tpbInterfaceVO[i].getTmlIfSeq());
				if(	tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
				}

				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createTESTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createTESTPB End");
		return isSuccessful;
	}
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException{
		log.error("TPB Common createTESTPB Start");
		boolean isSuccessful = false; 
		try {
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				log.error("tpbInterfaceVO[i].getTmlIfOfcCd()============>>>>>>>>>>>>"+tpbInterfaceVO[i].getTmlIfOfcCd());
				log.error("tpbInterfaceVO[i].getTmlIfSeq()============>>>>>>>>>>>>"+tpbInterfaceVO[i].getTmlIfSeq());
				tpbInterfaceVO[i].setUserId(account.getUsr_id());
				tpbInterfaceVO[i].setUserOfcCd(account.getOfc_cd());
				if(tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
				}

				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createTESTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createTESTPB End");
		return isSuccessful;
	}
	
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException{
		log.error("TPB Common createTRSTPB Start");
		boolean isSuccessful = false; 
		try { 
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				if(tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
				}

				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createTRSTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createTRSTPB End");
		return isSuccessful;
	}
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException{
		log.error("TPB Common createTRSTPB Start");
		boolean isSuccessful = false; 
		try { 
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				tpbInterfaceVO[i].setUserId(account.getUsr_id());
				tpbInterfaceVO[i].setUserOfcCd(account.getOfc_cd());
				if(tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
				}

				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createTRSTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createTRSTPB End");
		return isSuccessful;
	}
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException{
		log.error("TPB Common createMNRTPB Start");		
		boolean isSuccessful = false; 
		try { 
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				if(tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
					
					if (tpbInterfaceVO[i].getIfAmt().equals("0")) {
						throw new EventException(new ErrorHandler("TPB00023").getMessage());
					}
				}

				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createMNRTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createMNRTPB End");
		return isSuccessful;
	}
	
	/**
	 * Interface Data Receiving process<br>
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException{
		log.error("TPB Common createMNRTPB Start");			
		boolean isSuccessful = false; 
		try { 
			List<TPBInterfaceVO> insertVoList = new ArrayList<TPBInterfaceVO>();
			log.error("tpbInterfaceVO .length============>>>>>>>>>>>>"+tpbInterfaceVO .length);
			for ( int i=0; i<tpbInterfaceVO .length; i++ ) {
				tpbInterfaceVO[i].setUserId(account.getUsr_id());
				tpbInterfaceVO[i].setUserOfcCd(account.getOfc_cd());
				if(tpbInterfaceVO[i].getUserId() == null || 
						tpbInterfaceVO[i].getUserId().length() < 1 ){
					tpbInterfaceVO[i].setUserId("(System)");
				}
				insertVoList.add(tpbInterfaceVO[i]);
			}
			log.error("insertVoList.size()============>>>>>>>>>>>>"+insertVoList.size());
			if ( insertVoList.size() > 0 && tpbInterfaceVO .length > 0) {
				isSuccessful = dbDao.createMNRTPB(insertVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.error("TPB Common createMNRTPB End");
		return isSuccessful;
	}
	
	/**
	 * <br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTpbTesDltFlg(TPBInterfaceVO[] tpbInterfaceVO) throws EventException{
		try {
			String[] reValue = new String[tpbInterfaceVO.length];
			
			for ( int i=0; i<tpbInterfaceVO.length; i++ ) {
				reValue[i] = dbDao.searchTpbTesDltFlg(tpbInterfaceVO[i]);
			}
				return reValue;
			} catch (DAOException ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			}
	}
}