/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtBCImpl.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic;

import java.util.ArrayList;
import java.util.List; 

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.integration.CustomsCommonMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.util.log4j.StringUtils;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;

/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-CustomsCommon 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyu Jeong Shin
 * @see Esm_bkg_2001EventResponse 참조
 * @since J2EE 1.6
 */
public class CustomsCommonMgtBCImpl extends BasicCommandSupport implements CustomsCommonMgtBC {

	// Database Access Object
	private transient CustomsCommonMgtDBDAO dbDao = null;

	/**
	 * CustomsCommonMgtBCImpl object creation<br>
	 * CustomsCommonMgtDBDAO creation<br>
	 */
	public CustomsCommonMgtBCImpl() {
		dbDao = new CustomsCommonMgtDBDAO();
	}
	
	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvDescList(CstmsCdConvVO cstmsCdConvVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvDescList(cstmsCdConvVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvCtntList(CstmsCdConvVO cstmsCdConvVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConvCtntList(cstmsCdConvVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * managing information of Country Code, Customs Division ID, Customs Code Description<br>
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvDesc(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsCdConvVO> insertVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> updateVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> deleteVoList = new ArrayList<CstmsCdConvVO>();
			
			for(int i=0; i<cstmsCdConvVOs.length; i++){
				if(cstmsCdConvVOs[i].getIbflag().equals("I")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsCdConvVOs[i]);
				}else if(cstmsCdConvVOs[i].getIbflag().equals("U")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsCdConvVOs[i]);
				}else if(cstmsCdConvVOs[i].getIbflag().equals("D")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsCdConvVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addCstmsCdConvDesc(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCstmsCdConvDesc(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCstmsCdConvDescCtnt(deleteVoList);
				dbDao.removeCstmsCdConvDesc(deleteVoList);
				
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * managing Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvCtnt(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsCdConvVO> insertVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> updateVoList = new ArrayList<CstmsCdConvVO>();
			List<CstmsCdConvVO> deleteVoList = new ArrayList<CstmsCdConvVO>();
			
			for(int i=0; i<cstmsCdConvVOs.length; i++){
				if(cstmsCdConvVOs[i].getIbflag().equals("I")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsCdConvVOs[i]);
				}else if(cstmsCdConvVOs[i].getIbflag().equals("U")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsCdConvVOs[i]);
				}else if(cstmsCdConvVOs[i].getIbflag().equals("D")){
					cstmsCdConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsCdConvVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addCstmsCdConvCtnt(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCstmsCdConvCtnt(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCstmsCdConvCtnt(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checking duplication of Country Code, Customs Division ID<br>
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsCdConvDesc(String cntCd, String cstmsDivId) throws EventException {

		DBRowSet rowSet = null;							// DB ResultSet for data transmission
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCstmsCdConvDesc(cntCd, cstmsDivId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}

	/**
	 * searching Country Code, Package Type Code, Customs Package Type Code information<br>
	 * @param CstmsPckTpConvVO cstmsPckTpConvVO
	 * @return List<CstmsPckTpConvVO>
	 * @throws EventException
	 */
	public List<CstmsPckTpConvVO> searchCstmsPckTpConvList(CstmsPckTpConvVO cstmsPckTpConvVO) throws EventException {
		try {
			return dbDao.searchCstmsPckTpConvList(cstmsPckTpConvVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * managing information of Country Code, Package Type Code, Customs Package Type Code<br>
	 * @param CstmsPckTpConvVO[] cstmsPckTpConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsPckTpConv(CstmsPckTpConvVO[] cstmsPckTpConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsPckTpConvVO> insertVoList = new ArrayList<CstmsPckTpConvVO>();
			List<CstmsPckTpConvVO> updateVoList = new ArrayList<CstmsPckTpConvVO>();
			List<CstmsPckTpConvVO> deleteVoList = new ArrayList<CstmsPckTpConvVO>();
			
			for(int i=0; i<cstmsPckTpConvVOs.length; i++){
				if(cstmsPckTpConvVOs[i].getIbflag().equals("I")){
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(cstmsPckTpConvVOs[i]);
				}else if(cstmsPckTpConvVOs[i].getIbflag().equals("U")){
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cstmsPckTpConvVOs[i]);
				}else if(cstmsPckTpConvVOs[i].getIbflag().equals("D")){
					cstmsPckTpConvVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(cstmsPckTpConvVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addCstmsPckTpConv(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCstmsPckTpConv(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCstmsPckTpConv(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checking duplication of Country Code, Package Type Code, Customs Package Type Code<br>
	 * @param String cntCd
	 * @param String pckTpCd
	 * @param String cstmsPckTpCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsPckTpConv(String cntCd, String pckTpCd, String cstmsPckTpCd) throws EventException {

		DBRowSet rowSet = null;							// DB ResultSet for data transmission
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCstmsPckTpConv(cntCd, pckTpCd, cstmsPckTpCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * checking Package Type Code<br>
	 * @param String pckTpCd
	 * @return String
	 * @throws EventException
	 */
	public String checkPckTpCd(String pckTpCd) throws EventException {

		DBRowSet rowSet = null;							// DB ResultSet for data transmission
        String retVal = "";
        
        try {
            rowSet=dbDao.checkPckTpCd(pckTpCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * searching Country Code, Customs Error Code information<br>
	 * @param CstmsErrCdVO cstmsErrCdVO
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> searchCstmsAdvErrList(CstmsErrCdVO cstmsErrCdVO) throws EventException {
		try {
			return dbDao.searchCstmsAdvErrList(cstmsErrCdVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * managing information of Country Code, Customs Error Code
	 * @param CstmsErrCdVO[] customsErrCdVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsAdvErr(CstmsErrCdVO[] customsErrCdVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CstmsErrCdVO> insertVoList = new ArrayList<CstmsErrCdVO>();
			List<CstmsErrCdVO> updateVoList = new ArrayList<CstmsErrCdVO>();
			List<CstmsErrCdVO> deleteVoList = new ArrayList<CstmsErrCdVO>();
			
			for(int i=0; i<customsErrCdVOs.length; i++){
				if(customsErrCdVOs[i].getIbflag().equals("I")){
					customsErrCdVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(customsErrCdVOs[i]);
				}else if(customsErrCdVOs[i].getIbflag().equals("U")){
					customsErrCdVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(customsErrCdVOs[i]);
				}else if(customsErrCdVOs[i].getIbflag().equals("D")){
					customsErrCdVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(customsErrCdVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addCstmsAdvErr(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCstmsAdvErr(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCstmsAdvErr(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checking duplication of Country Code, Customs Error Code<br>
	 * @param String cntCd
	 * @param String cstmsErrCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsAdvErr(String cntCd, String cstmsErrCd) throws EventException {

		DBRowSet rowSet = null;							// DB ResultSet for data transmission
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCstmsAdvErr(cntCd, cstmsErrCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * EDI수신오류 시 메일전송할 수신처 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return CstmsEmlNtfcVO
	 * @exception EventException
	 */
	public CstmsEmlNtfcVO searchCstmsEmlNtfcInfo(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException {
		try {
			List<CstmsEmlNtfcVO> listEml = dbDao.searchCstmsEmlNtfcList(cstmsEmlNtfcVO);

			StringBuffer sbToEml = new StringBuffer();
			StringBuffer sbCcEml = new StringBuffer();

			String strToEml = "";
			String strCcEml = "";
			for (int i = 0; i < listEml.size(); i++) {
				CstmsEmlNtfcVO eml = (CstmsEmlNtfcVO) listEml.get(i);
				sbToEml.append(";");
				sbToEml.append(eml.getToEmlCtnt());
				sbCcEml.append(";");
				sbCcEml.append(eml.getCcEmlCtnt());
			}
			// 수신처 중복제거
			String[] toEmlAddrArray = StringUtils
					.removeDuplicateStrings(sbToEml.toString().split(";"));
			strToEml = StringUtils.arrayToDelimitedString(toEmlAddrArray, ";");
			String[] ccEmlAddrArray = StringUtils
					.removeDuplicateStrings(sbCcEml.toString().split(";"));
			strCcEml = StringUtils.arrayToDelimitedString(ccEmlAddrArray, ";");

			CstmsEmlNtfcVO emlNtfcInfo = new CstmsEmlNtfcVO();
			emlNtfcInfo.setToEmlCtnt(strToEml);
			emlNtfcInfo.setCcEmlCtnt(strCcEml);

			return emlNtfcInfo;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	
}