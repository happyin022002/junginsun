/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrBCImpl.java
*@FileTitle : Inland Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.basic;
import java.util.ArrayList;
import java.util.List;

import com.bluecast.util.DuplicateKeyException;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration.DefaultCurrDBDAO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.RHQComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ALPS-CostManage Business Logic Basic Command implementation<br>
 * - ALPS-CostManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EventResponse,AOCCommonSC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class DefaultCurrBCImpl extends BasicCommandSupport implements DefaultCurrBC {
	
	// Database Access Object
	private transient DefaultCurrDBDAO dbDao = null;

	/**
	 * DefaultCurrBCImpl 객체 생성<br>
	 * DefaultCurrDBDAO 를 생성한다.<br>
	 */
	public DefaultCurrBCImpl() {
		dbDao = new DefaultCurrDBDAO();
	}

	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<RHQComboVO> searchRHQCombo() throws EventException {
		try {
			return dbDao.searchRHQCombo();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<CntDefaultCurrVO> searchCntDefaultCurr(InlandCostConditionVO inlandCostConditionVO) throws EventException {

		String[] rhqCdArr = null;	
		String[] cntCdArr = null;
		String[] currCdArr = null;
		String rhqCd = "";
		String cntCd = "";
		String currCd = "";

		try {

			rhqCdArr = inlandCostConditionVO.getRhqCd().split(",");
			for( int idx=0; idx<rhqCdArr.length; idx++ ){
				if( idx == 0 && !rhqCdArr[idx].equals("") ){
					rhqCd = "'" + rhqCdArr[idx] + "'";
				} else if( idx > 0 ){
					rhqCd = rhqCd + ",'" + rhqCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setRhqCd(rhqCd);

			cntCdArr = inlandCostConditionVO.getCntCd().split(",");
			for( int idx=0; idx<cntCdArr.length; idx++ ){
				if( idx == 0 && !cntCdArr[idx].equals("") ){
					cntCd = "'" + cntCdArr[idx] + "'";
				} else if( idx > 0 ){
					cntCd = cntCd + ",'" + cntCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setCntCd(cntCd);
			
			currCdArr = inlandCostConditionVO.getCurrCd().split(",");
			for( int idx=0; idx<currCdArr.length; idx++ ){
				if( idx == 0 && !currCdArr[idx].equals("") ){
					currCd = "'" + currCdArr[idx] + "'";
				} else if( idx > 0 ){
					currCd = currCd + ",'" + currCdArr[idx] + "'";
				}
			}
			inlandCostConditionVO.setCurrCd(currCd);
			
			return dbDao.searchCntDefaultCurr(inlandCostConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public CntInfoVO searchCntInfo(String cntCd) throws EventException {
		try {
			CntInfoVO cntInfoVO = dbDao.searchCntInfo(cntCd);
			return cntInfoVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Currency Name<br>
	 * 
	 * @param currCd
	 * @return
	 * @throws EventException
	 */
	public String searchCurrNm(String currCd) throws EventException {
		try {
			String curr_nm = dbDao.searchCurrNm(currCd);
			return curr_nm;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * Default Currency Creation - Save<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException {
		String errFlg = "";
		String dupFlg = "";
		
		try {
			List<CntDefaultCurrVO> insertVoList = new ArrayList<CntDefaultCurrVO>();
			List<CntDefaultCurrVO> updateVoList = new ArrayList<CntDefaultCurrVO>();
			List<CntDefaultCurrVO> deleteVoList = new ArrayList<CntDefaultCurrVO>();

			for ( int i=0; i<cntDefaultCurrVOs .length; i++ ) {
				if ( cntDefaultCurrVOs[i].getIbflag().equals("I")){
					cntDefaultCurrVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cntDefaultCurrVOs[i]);
				} else if ( cntDefaultCurrVOs[i].getIbflag().equals("U")){
					cntDefaultCurrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cntDefaultCurrVOs[i]);
				} else if ( cntDefaultCurrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cntDefaultCurrVOs[i]);
				}				
			} 

			if ( insertVoList.size() > 0 ) {
				//Checking Duplication
				for( int idx=0; idx<insertVoList.size(); idx++ ){
					dupFlg = dbDao.searchDupChkCostTrfCurr(insertVoList.get(idx));
					if( "Y".equals(dupFlg) ){
						errFlg = "Y";
					}
				}
				if( !"Y".equals(errFlg) ){
					dbDao.addCntDefaultCurrS(insertVoList);
				} else{
					throw new DuplicateKeyException(new ErrorHandler("COM12115",new String[]{"Country Code"}).getMessage());
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntDefaultCurrS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntDefaultCurrS(deleteVoList);
			}
			
		} catch(DuplicateKeyException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12115",new String[]{"Country Code"}).getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException {

		try {
			List<CntDefaultCurrVO> deleteVoList = new ArrayList<CntDefaultCurrVO>();

			for ( int i=0; i<cntDefaultCurrVOs .length; i++ ) {
				if ( cntDefaultCurrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cntDefaultCurrVOs[i]);
				}				
			} 
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntDefaultCurrS(deleteVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Default Currency Creation - Currency Code 확인<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCurrencyCode(String currCd) throws EventException {
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyCurrencyCode(currCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;		
	}
	
	/**
	 * Default Currency Creation - Country Code 확인<br>
	 * 
	 * @param String rhqCd
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCountryCode(String rhqCd, String cntCd) throws EventException {
		String knt = "N";

		try {
			knt = dbDao.verifyCountryCode(rhqCd, cntCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return knt;		
	}

	
}