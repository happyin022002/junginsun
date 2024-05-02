/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffBC.java
*@FileTitle : DropOffTariff
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2015.11.0 YOON, Yong-Sang
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration.DropOffTariffDBDAO;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-DropOffTariff Business Logic Command Interface<br>
 * - ALPS-DropOffTariff 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author YOON, Yong-Sang
 * @see EES_DOD_0005EventResponse 참조
 * @since J2EE 1.6
 */
public class DropOffTariffBCImpl extends BasicCommandSupport implements DropOffTariffBC {

	// Database Access Object
	private transient DropOffTariffDBDAO dbDao = null;

	/**
	 * DropOffTariffBCImpl 객체 생성<br>
	 * DropOffTariffDBDAO를 생성한다.<br>
	 */
	public DropOffTariffBCImpl() {
		dbDao = new DropOffTariffDBDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> searchDodTariffList(SearchDodTariffListVO searchDodTariffListVO) throws EventException {
		try {
			return dbDao.searchDodTariffList(searchDodTariffListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @param String sTrfDivCd
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> searchDodTariffList(SearchDodTariffListVO searchDodTariffListVO, String sTrfDivCd) throws EventException {
		try {
			return dbDao.searchDodTariffList(searchDodTariffListVO, sTrfDivCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * DodTariffList 를 Confirm 한다.
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param String usrId
	 * @throws EventException
	 */
	@Override
	public void manageConfirmDodTariffList(SearchDodTariffListVO[] searchDodTariffListVOs, String usrId)	throws EventException {
		List<SearchDodTariffListVO> confirmDodTariffList = new ArrayList<SearchDodTariffListVO>() ;
		try{
			for(int i = 0 ; i <searchDodTariffListVOs.length; i++){
				searchDodTariffListVOs[i].setDrpOffChgTrfCfmUsrId(usrId);
				confirmDodTariffList.add(searchDodTariffListVOs[i]);
			}
			if (confirmDodTariffList.size()>0){
				dbDao.manageConfirmDodTariffList(confirmDodTariffList);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> searchDodDuplTariffList(SearchDodTariffListVO[] searchDodTariffListVOs) throws EventException {
		try {
			return dbDao.searchDodDuplTariffList(searchDodTariffListVOs);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> expireDodTariffData(SearchDodTariffListVO[] searchDodTariffListVOs, SignOnUserAccount account) throws EventException {
		List<SearchDodTariffListVO> rtnListVo = new ArrayList();
		try {
			List<SearchDodTariffListVO> updateList = new ArrayList<SearchDodTariffListVO>();
			for (int i = 0; i < searchDodTariffListVOs.length; i++) {
				searchDodTariffListVOs[i].setCreUsrId(account.getUsr_id());
				searchDodTariffListVOs[i].setUpdUsrId(account.getUsr_id());
				if ("U".equals(searchDodTariffListVOs[i].getIbflag())) {
					updateList.add(searchDodTariffListVOs[i]);					
				}
			}
			if (updateList.size() > 0) {
				dbDao.expireDodTariffData(updateList);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return rtnListVo;
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> expireRestOfDodTariffData(SearchDodTariffListVO[] searchDodTariffListVOs, SignOnUserAccount account) throws EventException {
		List<SearchDodTariffListVO> rtnListVo = new ArrayList();
		try {
			List<SearchDodTariffListVO> updateList = new ArrayList<SearchDodTariffListVO>();
			for (int i = 0; i < searchDodTariffListVOs.length; i++) {
				searchDodTariffListVOs[i].setCreUsrId(account.getUsr_id());
				searchDodTariffListVOs[i].setUpdUsrId(account.getUsr_id());
				if ("U".equals(searchDodTariffListVOs[i].getIbflag())) {
					updateList.add(searchDodTariffListVOs[i]);					
				}
			}
			if (updateList.size() > 0) {
				dbDao.expireRestOfDodTariffData(updateList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return rtnListVo;
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> searchDodTariffConti(SearchDodTariffListVO searchDodTariffListVO) throws EventException{
		try {
			return dbDao.searchDodTariffConti(searchDodTariffListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	@Override
	public List<SearchDodTariffListVO> manageDodTariffList(SearchDodTariffListVO[] searchDodTariffListVOs, SignOnUserAccount account)
			throws EventException {
		List<SearchDodTariffListVO> rtnListVo = new ArrayList();
		try {
			
			List<SearchDodTariffListVO> insertList = new ArrayList<SearchDodTariffListVO>();
			List<SearchDodTariffListVO> updateList = new ArrayList<SearchDodTariffListVO>();
			List<SearchDodTariffListVO> deleteList = new ArrayList<SearchDodTariffListVO>();

			for (int i = 0; i < searchDodTariffListVOs.length; i++) {
				searchDodTariffListVOs[i].setCreUsrId(account.getUsr_id());
				searchDodTariffListVOs[i].setUpdUsrId(account.getUsr_id());
				if ("I".equals(searchDodTariffListVOs[i].getIbflag())) {					
					insertList.add(searchDodTariffListVOs[i]);
				} else if ("U".equals(searchDodTariffListVOs[i].getIbflag())) {
					updateList.add(searchDodTariffListVOs[i]);
				} else if ("D".equals(searchDodTariffListVOs[i].getIbflag())) {
					deleteList.add(searchDodTariffListVOs[i]);
				}
			}
			if (updateList.size() > 0) {
//				List<SearchDodTariffListVO> dupList = searchDodDuplTariffList(searchDodTariffListVOs);
//				if(!dupList.isEmpty()){
//					dupList.get(0).setIbflag("X");
//					rtnListVo = dupList;
//				} else {
					dbDao.modifyDodTariffData(updateList);
//				}
				//System.err.print("** UPDATE **" + updateList.toString());
			}
			
			if (insertList.size() > 0) {				
				List<SearchDodTariffListVO> dupList = searchDodDuplTariffList(searchDodTariffListVOs);
				if(!dupList.isEmpty()){
					dupList.get(0).setIbflag("X");
					rtnListVo = dupList;
				} else {
					dbDao.addDodTariffData(insertList);
					dbDao.expireRestOfDodTariffData(insertList);
				}
				
				//System.err.print("** INTERT **" + insertList.toString());
			}
			
			if (deleteList.size() > 0) {
				dbDao.removeDodTariffData(deleteList);
				//System.err.print("** DELETE **" + deleteList.toString());
			}
			return rtnListVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * DropOff Tarriff Creation Special Customer Tab Grid에서 Customer조회
	 * SC_NO, RFA_NO에 종속된 Customer List를 조회 
	 * @param rfaNo
	 * @param scNo
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> searchDodTariffSpecialCustomer(String rfaNo, String scNo) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		String comboText = "";
		String comboCode = "";
		String comboText2 = "";
		
		StringBuffer sbText = new StringBuffer();
		StringBuffer sbCode = new StringBuffer();
		StringBuffer sbText2 = new StringBuffer();
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			rowSet=dbDao.searchDodTariffSpecialCustomer(rfaNo, scNo);
			sbText.append(" |");
			sbCode.append(" |");
			int i = 0;
			
			while(rowSet.next()){
				sbCode.append(rowSet.getString("CUST_ID")).append("|");
				sbText.append(rowSet.getString("CUST_ID")).append(", ").append(rowSet.getString("CUST_NM")).append("|");
				
				if(i == 0){
					sbText2.append(rowSet.getString("CUST_NM2"));
					i = 1;
				}
			}
			comboCode = sbCode.toString();
			comboText = sbText.toString();
			comboText2 = sbText2.toString();
			
			if(comboCode.length()>1) comboCode = comboCode.substring(0, comboCode.length()-1);
			if(comboText.length()>1) comboText = comboText.substring(0, comboText.length()-1);
			if(comboText2.length()>1) comboText2 = comboText2.substring(0, comboText2.length()-1);
			
			map.put("CODE", comboCode);
			map.put("NAME", comboText);
			map.put("CUST_NM", comboText2);
			
			return map;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 

	}
}
