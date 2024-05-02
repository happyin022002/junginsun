/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TPBInterfaceBCImpl.java
*@FileTitle : 3자구상 Interface (Receive; Source=>TPB)
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-10
*@LastModifier : Sun, CHOI
*@LastVersion : 1.0
* 2009-08-20 O Wan-Ki 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.integration.TPBInterfaceDBDAO;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sun, CHOI
 * @see ESD_TPB_015EventResponse,OutstandingManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TPBInterfaceBCImpl   extends BasicCommandSupport implements TPBInterfaceBC {
	
	// Database Access Object
	private transient TPBInterfaceDBDAO dbDao=null;

	/**
	 * TPBInterfaceBCImpl 객체 생성<br>
	 * TPBInterfaceDBDAO를 생성한다.<br>
	 */
	public TPBInterfaceBCImpl(){
		dbDao = new TPBInterfaceDBDAO();
	}
	/**
	 * TES로부터 Interface Data Receiving 처리<br>
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
	 * TES로부터 Interface Data Receiving 처리<br>
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
	 * TRS로부터 Interface Data Receiving 처리<br>
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
	 * TRS로부터 Interface Data Receiving 처리<br>
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
	 * TRS로부터 Interface Data Receiving 처리<br>
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
	 * TRS로부터 Interface Data Receiving 처리<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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