/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RatingUnitBCImpl.java
*@FileTitle : Rating Unit Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.ratingunit.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.primasterdata.ratingunit.integration.RatingUnitDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRatUtVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_4001EventResponse,RatingUnitBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class RatingUnitBCImpl extends BasicCommandSupport implements RatingUnitBC {

	// Database Access Object
	private transient RatingUnitDBDAO dbDao = null;

	/**
	 * Creating RatingUnitBCImpl object<br>
	 * Creating RatingUnitDBDAO<br>
	 */
	public RatingUnitBCImpl() {
		dbDao = new RatingUnitDBDAO();
	}
	
	/**
	 * Retrieving Ratingunit List<br>
	 * 
	 * @param PriRatUtVO priRatUtVO
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<PriRatUtVO> searchRatingUnitList(PriRatUtVO priRatUtVO) throws EventException {
		try {
			return dbDao.searchRatingUnitList(priRatUtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying Ratingunit<br>
	 * 
	 * @param PriRatUtVO[] priRatUtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRatingUnit(PriRatUtVO[] priRatUtVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRatUtVO> insertVoList = new ArrayList<PriRatUtVO>();
			List<PriRatUtVO> updateVoList = new ArrayList<PriRatUtVO>();
			List<PriRatUtVO> deleteVoList = new ArrayList<PriRatUtVO>();
			for ( int i=0; i<priRatUtVOs .length; i++ ) {
				if ( priRatUtVOs[i].getIbflag().equals("I")){
					priRatUtVOs[i].setCreUsrId(account.getUsr_id());
					priRatUtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRatUtVOs[i]);
				} else if ( priRatUtVOs[i].getIbflag().equals("U")){
					priRatUtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRatUtVOs[i]);
				} else if ( priRatUtVOs[i].getIbflag().equals("D")){
					priRatUtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRatUtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addRatingUnitS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRatingUnitS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRatingUnitS(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Checking whether all code is duplicated before saving Rating Unit<br>
	 * 
	 * @param PriRatUtVO[] priRatUtVOs 
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkExistRatingUnitCd(PriRatUtVO[] priRatUtVOs) throws EventException {
		
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		
		try {
			for (int i = 0; i < priRatUtVOs.length; i++) {
				
				if ( "I".equals(priRatUtVOs[i].getIbflag()) ){
				
					PriRatUtVO row = priRatUtVOs[i];
					
					String strRatingUnitCd = row.getRatUtCd();
					
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setCd(strRatingUnitCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckCd(paramVO);
					
					if (cdVO != null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strRatingUnitCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("rat_ut_cd");
						
						rslt.add(cdVO);
					}
					
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

		
		return rslt;
	}
	
	
}