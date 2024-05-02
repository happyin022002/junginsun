/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeBCImpl.java
*@FileTitle : Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.integration.SurchargeDBDAO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtValidVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Surcharge Business Logic Basic Command implementation<br>
 * - handling biz logic about Surcharge <br>
 *
 * @author 
 * @see ESM_PRI_4003EventResponse,SurchargeBC reference each DAO class
 * @since J2EE 1.6
 */
public class SurchargeBCImpl extends BasicCommandSupport implements SurchargeBC {

	// Database Access Object
	private transient SurchargeDBDAO dbDao = null;

	/**
	 * SurchargeBCImpl object creation<br>
	 * creating SurchargeDBDAO<br>
	 */
	public SurchargeBCImpl() {
		dbDao = new SurchargeDBDAO();
	}
	
	/**
	 * Retrieving Percentage Base Code<br>
	 * 
	 * @param PriScgPrfVO priScgPrfVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComboPctBseCdList(PriScgPrfVO priScgPrfVO) throws EventException {
		try {
			return dbDao.searchComboPctBseCdList(priScgPrfVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge Preferences list<br>
	 * 
	 * @param PriScgPrfVO priScgPrfVO
	 * @return List<PriScgPrfVO>
	 * @exception EventException
	 */
	public List<PriScgPrfVO> searchSurchargePreferences(PriScgPrfVO priScgPrfVO) throws EventException {
		try {
			return dbDao.searchSurchargePreferences(priScgPrfVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying Surcharge Preferences <br>
	 * 
	 * @param PriScgPrfVO[] priScgPrfVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargePreferences(PriScgPrfVO[] priScgPrfVOs,SignOnUserAccount account) throws EventException {
		try {
			if(priScgPrfVOs.length > 0) {
				if("I".equals(priScgPrfVOs[0].getIbflag())) {
					priScgPrfVOs[0].setCreUsrId(account.getUsr_id());
					priScgPrfVOs[0].setUpdUsrId(account.getUsr_id());
					dbDao.addSurchargePreferences(priScgPrfVOs[0],account);
				} else if("U".equals(priScgPrfVOs[0].getIbflag())){
					priScgPrfVOs[0].setUpdUsrId(account.getUsr_id());
					dbDao.modifySurchargePreferences(priScgPrfVOs[0]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge<br>
	 * 
	 * @param PriScgRtVO priScgRtVO
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO) throws EventException {
		try {
			return dbDao.searchSurchargeList(priScgRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge (for paging)<br>
	 * 
	 * @param PriScgRtVO priScgRtVO
	 * @param int nPage
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO, int nPage) throws EventException {
		try {
			return dbDao.searchSurchargeList(priScgRtVO, nPage);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying Surcharge <br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeRate(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriScgRtVO> insertVoList = new ArrayList<PriScgRtVO>();
			List<PriScgRtVO> updateVoList = new ArrayList<PriScgRtVO>();
			List<PriScgRtVO> deleteVoList = new ArrayList<PriScgRtVO>();
			
			if(priScgRtVOs == null) {
				return;
			}
			
			for(int i=0; i<priScgRtVOs .length; i++) {
				if(priScgRtVOs[i].getIbflag().equals("I")) {
					priScgRtVOs[i].setCreUsrId(account.getUsr_id());
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScgRtVOs[i]);
				} else if(priScgRtVOs[i].getIbflag().equals("U")) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScgRtVOs[i]);
				} else if(priScgRtVOs[i].getIbflag().equals("D")) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					priScgRtVOs[i].setDeltFlg("Y");
					deleteVoList.add(priScgRtVOs[i]);
				}
			}

            if ( deleteVoList.size() > 0 ) {
                dbDao.modifySurchargeRate(deleteVoList);
            }

			if ( updateVoList.size() > 0 ) {
				dbDao.modifySurchargeRate(updateVoList);
			}

            if ( insertVoList.size() > 0 ) {
//                dbDao.addSurchargeRate(insertVoList);
                for (int i = 0, n = insertVoList.size() ; i < n ; i++) {
                    dbDao.addSurchargeRate(insertVoList.get(i));
                }
            }

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * checking duplicate Surcharge  <br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @return String
	 * @exception EventException
	 */
	
	public String checkSurchargeDuplicate(PriScgRtVO[] priScgRtVOs) throws EventException {
		String rtnVal = "";		
		try {
			if(priScgRtVOs != null) {				
				log.debug("checkSurchargeDuplicate==priScgRtVOs = count=="+priScgRtVOs.length);
				for(int i=0; i<priScgRtVOs.length; i++ ) {
					if(!"D".equals(priScgRtVOs[i].getIbflag()) && dbDao.searchSurchargeDuplicate(priScgRtVOs[i])) {
						rtnVal =  priScgRtVOs[i].getSeq();
						break;
					}
				}
			}
			return rtnVal;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * checking duplicate Surcharge <br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @return String
	 * @exception EventException
	 */
	
	public String checkSurchargeDuplicateExcel(PriScgRtVO[] priScgRtVOs) throws EventException {
		String rtnVal = "";
		
		try {
			if(priScgRtVOs != null) {
				for(int i=0; i<priScgRtVOs.length; i++ ) {
					if(("I".equals(priScgRtVOs[i].getIbflag()) || "U".equals(priScgRtVOs[i].getIbflag())) && dbDao.searchSurchargeDuplicateExcel(priScgRtVOs[i])) {
						rtnVal =  priScgRtVOs[i].getSeq();
						break;
					}
				}
			}
			return rtnVal;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		

	/**
	 * Retrieving Surcharge total List<br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @param int nPage
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchAllSurchargeList(CstPriScgRtVO cstPriScgRtVO, int nPage) throws EventException {
		try {
			return dbDao.searchAllSurchargeList(cstPriScgRtVO, nPage);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Surcharge total List(For Excel)<br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public List<Object> searchSurchargeListForExcel(CstPriScgRtVO cstPriScgRtVO) throws EventException {
		DBRowSet rowSet = null;
		@SuppressWarnings("unchecked")
		List<Object> sList = new ArrayList();
		
		int colCnt = 0;
		String[] sTitle = null;
		String[] sColum = null;
		
		try {
			
			
			rowSet = dbDao.searchSurchargeListForExcel(cstPriScgRtVO);
			sList.add( rowSet );
			 
			rowSet.next();
			colCnt = rowSet.getMetaData().getColumnCount();
			sTitle = new String[colCnt];
			sColum = new String[colCnt];
			 
			for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
					sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));		
					sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
			}
			sList.add( sTitle );
			sList.add( sColum );

			return sList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * deleting Sucharge Preferences  <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @exception EventException
	 */
	public void removeSurchargePreferences(CstPriScgRtVO cstPriScgRtVO) throws EventException {
		try {
			dbDao.removeSurchargePreferences(cstPriScgRtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * deleting Sucharge Rate <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @exception EventException
	 */
	public void removeSurchargeRate(CstPriScgRtVO cstPriScgRtVO) throws EventException {
		try {
			dbDao.removeSurchargeRate(cstPriScgRtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CHECK Surcharge DATA<br>
	 * 2015.03.27 CREATE
	 * @param PriScgRtVO[] priScgRtVOS
	 * @return List<PriScgRtValidVO>
	 * @exception EventException
	 */
	public List<PriScgRtValidVO> checkSurchargeExcelData(PriScgRtVO[] priScgRtVOS) throws EventException {		
		List<PriScgRtValidVO> retPriScgRtValidVOS = null;
		try {			
			if(priScgRtVOS != null && priScgRtVOS.length > 0){				
				retPriScgRtValidVOS = new ArrayList<PriScgRtValidVO>();
				for(int i = 0; i < priScgRtVOS.length; i++){
					PriScgRtVO paramPriScgRtVO = priScgRtVOS[i];						
					List<PriScgRtValidVO> tmpPriScgRtValidVOS = dbDao.checkSurchargeExcelData(paramPriScgRtVO);
					retPriScgRtValidVOS.add(tmpPriScgRtValidVOS.get(0));
				}			
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return retPriScgRtValidVOS;
	}
}