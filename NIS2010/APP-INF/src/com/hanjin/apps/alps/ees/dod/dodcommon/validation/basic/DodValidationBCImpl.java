/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DodValidationBCImpl.java   
*@FileTitle : Dod Validation
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.basic;

import com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration.DodValidationDBDAO;
import com.hanjin.apps.alps.ees.dod.dodcommon.validation.vo.DodValidationINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * DodValidationBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class DodValidationBCImpl extends BasicCommandSupport implements DodValidationBC {
	
	// Database Access Object
	private transient DodValidationDBDAO dbDao = null;
	
	/**
	 * DropOffInquiryBCImpl 객체 생성<br>
	 * DropOffInquiryDBDAO 생성한다.<br>
	 */
	public DodValidationBCImpl() {
		dbDao = new DodValidationDBDAO();
	}

	/**
	 * OFC_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkOfficeCode(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkOfficeCode(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CUST_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCustomer(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkCustomer(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * BKG_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkBkgNo(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkBkgNo(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * CNTR_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCntrNo(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkCntrNo(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * RFA_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkRfaNo(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkRfaNo(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * SC_NO 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkScNo(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkScNo(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * TP/SZ 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkTpSz(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkTpSz(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * LOC_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkLocCd(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkLocCd(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * YD_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkYdCd(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkYdCd(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * RCC, ECC, SCC등 지역 코드 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkAreaCd(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkAreaCd(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CNT_CD 유효성 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkCntCd(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkCntCd(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * Login한 사용자의 AR Invoice Issue화면 접근권한 점검
	 * 리턴값이 0보다 클경우 유효함
	 * @param dodValidationINVO
	 * @return
	 * @throws EventException
	 */
	public int checkIssueUser(DodValidationINVO dodValidationINVO) throws EventException{
		try {    
			int count = 0;
						
			count = dbDao.checkIssueUser(dodValidationINVO);
			
			return count;
			
		} catch (DAOException ex) {            
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
}
