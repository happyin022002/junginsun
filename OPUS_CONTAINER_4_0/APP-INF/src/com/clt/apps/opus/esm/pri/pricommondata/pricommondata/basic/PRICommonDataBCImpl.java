/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDataBCImpl.java
*@FileTitle : PRI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.16 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration.PRICommonDataDBDAO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.PriRcvDeTermMapgVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeGroupingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyMappingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgPctBseChgVO;
import com.clt.syscommon.common.table.PriScgPctBseVO;
import com.clt.syscommon.common.table.PriSvcScpPptMapgVO;
import com.clt.syscommon.common.table.PriSvcScpPptVO;


/**
 * PRICommonData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRICommonData<br>
 *
 * @author SHKIM
 * @see EsmPri5001EventResponse,PRICommonDataBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class PRICommonDataBCImpl extends BasicCommandSupport implements PRICommonDataBC {

	// Database Access Object
	private transient PRICommonDataDBDAO dbDao = null;

	/**
	 * TariffRuleBCImpl 객체 생성<br>
	 * TariffRuleDBDAO를 생성한다.<br>
	 */
	public PRICommonDataBCImpl() {
		dbDao = new PRICommonDataDBDAO();
	}
	
	/**
	 * ESM_PRI_5004 : Retrieve <br>
	 * 입력한 PRI Code에 해당하는 PRI  조회
	 * 
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyVO> searchServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws EventException {
		try {
			return dbDao.searchServiceScopeProperty(priSvcScpPptVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * ESM_PRI_5004 : SAVE <br>
	 * PRI Scope duplicate check
	 * 
	 * @param PriSvcScpPptVO[] priSvcScpPptVOs
	 * @param SignOnUserAccount account
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyVO> manageServiceScopeProperty(PriSvcScpPptVO[] priSvcScpPptVOs,SignOnUserAccount account) throws EventException {
		try {		
			List<RsltServiceScopePropertyVO> duplist = new ArrayList<RsltServiceScopePropertyVO>();
			log.debug("*	account.getUsr_id()	:"+account.getUsr_id());
			String localUsrId = account.getUsr_id();
			if(priSvcScpPptVOs != null && priSvcScpPptVOs.length > 0 ){
				for ( int i=0; i<priSvcScpPptVOs.length; i++ ) {
					log.info("*	IBFLAGE I(insert), U(update), D(delete)	:["+priSvcScpPptVOs[i].getIbflag()+"]");
					// EXIST LOGIC start
					List selectCheck = dbDao.searchServiceScopeProperty(priSvcScpPptVOs[i]);
					log.info("*	select exist gubun :"+selectCheck.size());
					String locSelectChkYn = "";
					if(selectCheck.size() > 0){	locSelectChkYn = "Y";}else{	locSelectChkYn = "N"; }
					// EXIST LOGIC end
					if ( priSvcScpPptVOs[i].getIbflag().equals("I") && locSelectChkYn.equals("N") ){
						priSvcScpPptVOs[i].setCreUsrId(localUsrId);
						priSvcScpPptVOs[i].setUpdUsrId(localUsrId);
						duplist = dbDao.addServiceScopeProperty(priSvcScpPptVOs[i]);
					}
					else if ( priSvcScpPptVOs[i].getIbflag().equals("U") && locSelectChkYn.equals("Y") ){
						priSvcScpPptVOs[i].setCreUsrId(localUsrId);
						priSvcScpPptVOs[i].setUpdUsrId(localUsrId);
						duplist = dbDao.modifyServiceScopeProperty(priSvcScpPptVOs[i]);
					}
					else if ( priSvcScpPptVOs[i].getIbflag().equals("D") && locSelectChkYn.equals("Y") ){
						priSvcScpPptVOs[i].setCreUsrId(localUsrId);
						priSvcScpPptVOs[i].setUpdUsrId(localUsrId);
						
						duplist = dbDao.removeServiceScopeProperty(priSvcScpPptVOs[i]);
					}
				}	
				
				//if ( checkVoList.size() > 0 ) {
				//	duplist  = dbDao.manageServiceScopeProperty(svcScpPptVOs[0],checkVoList);
				//}
			}
			return duplist;

		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5005 : Retrieve <br>
	 * 입력한 PRI Code에 해당하는 PRI  조회
	 * 
	 * @param PriSvcScpPptMapgVO priSvcScpPptMapgVO
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyMappingVO> searchServiceScopePropertyMapping(PriSvcScpPptMapgVO priSvcScpPptMapgVO) throws EventException {
		
		try {
			return dbDao.searchServiceScopePropertyMapping(priSvcScpPptMapgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * ESM_PRI_5005 : SAVE <br>
	 * PRI Scope duplicate check
	 * 
	 * @param PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs
	 * @param SignOnUserAccount account
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyMappingVO> manageServiceScopePropertyMapping(PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs,SignOnUserAccount account) throws EventException {
		try {		
			List<RsltServiceScopePropertyMappingVO> duplist = new ArrayList<RsltServiceScopePropertyMappingVO>();
			log.debug("*	account.getUsr_id()	:"+account.getUsr_id());
			String localUsrId = account.getUsr_id();
			if(priSvcScpPptMapgVOs != null && priSvcScpPptMapgVOs.length > 0 ){
				for ( int i=0; i<priSvcScpPptMapgVOs.length; i++ ) {
					log.info("*	IBFLAGE I(insert), U(update), D(delete)	:["+priSvcScpPptMapgVOs[i].getIbflag()+"]");
					// EXIST LOGIC start
					List selectCheck = dbDao.searchServiceScopePropertyMapping(priSvcScpPptMapgVOs[i]);
					log.info("*	selectQuery exist gubun :"+selectCheck.size());
					String locSelectChkYn = "";
					if(selectCheck.size() > 0){	locSelectChkYn = "Y";}else{	locSelectChkYn = "N"; }
					// EXIST LOGIC end
					if ( priSvcScpPptMapgVOs[i].getIbflag().equals("I") && locSelectChkYn.equals("N") ){
						priSvcScpPptMapgVOs[i].setCreUsrId(localUsrId);
						priSvcScpPptMapgVOs[i].setUpdUsrId(localUsrId);
						duplist = dbDao.addServiceScopePropertyMapping(priSvcScpPptMapgVOs[i]);
					}
					else if ( priSvcScpPptMapgVOs[i].getIbflag().equals("D") && locSelectChkYn.equals("Y") ){
						priSvcScpPptMapgVOs[i].setCreUsrId(localUsrId);
						priSvcScpPptMapgVOs[i].setUpdUsrId(localUsrId);
						duplist = dbDao.removeServiceScopePropertyMapping(priSvcScpPptMapgVOs[i]);
					}
				}	
				
				//if ( checkVoList.size() > 0 ) {
				//	duplist  = dbDao.manageServiceScopeProperty(svcScpPptVOs[0],checkVoList);
				//}
			}
			return duplist;

		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_5002 : Retrieve <br>
	 * 
	 * @return List<RsltPercentBaseChargeVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeVO> searchPercentBaseCharge() throws EventException {
		try {
			return dbDao.searchPercentBaseCharge();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_5002 : sheet1 on select cell <br>
	 * 
	 * @param PriScgPctBseVO priScgPctBseVO
	 * @return List<RsltPercentBaseChargeGroupingVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeGroupingVO> searchPercentBaseChargeGrouping(PriScgPctBseVO priScgPctBseVO) throws EventException {
		try {
			return dbDao.searchPercentBaseChargeGrouping(priScgPctBseVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_5002 : sheet1 SAVE <br>
	 * 
	 * @param PriScgPctBseVO[] priScgPctBseVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseCharge(PriScgPctBseVO[] priScgPctBseVOs , SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
			try {			
			List<PriScgPctBseVO> insModels = new ArrayList<PriScgPctBseVO>();
			List<PriScgPctBseVO> deleteSheetVoList = new ArrayList<PriScgPctBseVO>();		
			List<PriScgPctBseVO> updateSheetVoList = new ArrayList<PriScgPctBseVO>();	
				
			for ( int i=0; i< priScgPctBseVOs.length; i++ ) {
				if ( priScgPctBseVOs[i].getIbflag().equals("I") && !priScgPctBseVOs[i].getDpSeq().equals("")){
					priScgPctBseVOs[i].setCreUsrId(account.getUsr_id());
					priScgPctBseVOs[i].setUpdUsrId(account.getUsr_id());
					insModels.add(priScgPctBseVOs[i]);					
				}else if ( priScgPctBseVOs[i].getIbflag().equals("D") && !priScgPctBseVOs[i].getDpSeq().equals("")){
					priScgPctBseVOs[i].setUpdUsrId(account.getUsr_id());
					priScgPctBseVOs[i].setDeltFlg("Y");
					deleteSheetVoList.add(priScgPctBseVOs[i]);
				}else if ( priScgPctBseVOs[i].getIbflag().equals("U") && !priScgPctBseVOs[i].getDpSeq().equals("")){
					priScgPctBseVOs[i].setUpdUsrId(account.getUsr_id());
					priScgPctBseVOs[i].setDeltFlg("N");
					updateSheetVoList.add(priScgPctBseVOs[i]);
				}
			}					

			if ( deleteSheetVoList.size() > 0 ) {
				dbDao.modifyPercentBaseCharge(deleteSheetVoList);
				dbDao.removePercentBaseCharge(deleteSheetVoList);
			}
			
			if ( insModels.size() > 0 ) {						
				dbDao.addPercentBaseCharge(insModels);
			}	
			
			if ( updateSheetVoList.size() > 0 ) {						
				dbDao.modifyPercentBaseCharge(updateSheetVoList);
			}
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_5002 : sheet2 SAVE <br>
	 * 
	 * @param PriScgPctBseChgVO[] priScgPctBseChgVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseChargeGrouping(PriScgPctBseChgVO[] priScgPctBseChgVOs , SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
			try {			
			List<PriScgPctBseChgVO> insModels = new ArrayList<PriScgPctBseChgVO>();
			List<PriScgPctBseChgVO> deleteSheetVoList = new ArrayList<PriScgPctBseChgVO>();			
				
			for ( int i=0; i< priScgPctBseChgVOs.length; i++ ) {
				if ( priScgPctBseChgVOs[i].getIbflag().equals("I") && !"".equals(priScgPctBseChgVOs[i].getChgCd())){
					priScgPctBseChgVOs[i].setCreUsrId(account.getUsr_id());
					priScgPctBseChgVOs[i].setUpdUsrId(account.getUsr_id());
					insModels.add(priScgPctBseChgVOs[i]);					
				}else if ( priScgPctBseChgVOs[i].getIbflag().equals("D") && !"".equals(priScgPctBseChgVOs[i].getChgCd())){
					deleteSheetVoList.add(priScgPctBseChgVOs[i]);
				}
			}					

			if ( deleteSheetVoList.size() > 0 ) {
				dbDao.removePercentBaseChargeGrouping(deleteSheetVoList);
			}
			
			if ( insModels.size() > 0 ) {						
				dbDao.addPercentBaseChargeGrouping(insModels);
			}	
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	

	/**
	 * ESM_PRI_5001
	 * BKG Term Mapping Creation retrieve<br>
	 * 
	 * @return List<PriRcvDeTermMapgVO>
	 * @exception EventException
	 */
	public List<PriRcvDeTermMapgVO> searchBookingTermMappingList() throws EventException{
		try {
			return dbDao.searchBookingTermMappingList();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_PRI_5001 
	 * BKG Term Mapping Creation add/remove<br>
	 * 
	 * @param  PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingTermMapping(PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRcvDeTermMapgVO> insertVoList = new ArrayList<PriRcvDeTermMapgVO>();
			List<PriRcvDeTermMapgVO> deleteVoList = new ArrayList<PriRcvDeTermMapgVO>();

			for(int i=0; i<priRcvDeTermMapgVOs.length;i++){
			
				if(priRcvDeTermMapgVOs[i].getIbflag().equals("I")){
					priRcvDeTermMapgVOs[i].setCreUsrId(account.getUsr_id());
					priRcvDeTermMapgVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(priRcvDeTermMapgVOs[i]);
					
				}
				else if(priRcvDeTermMapgVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priRcvDeTermMapgVOs[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addBookingTermMapping(insertVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeBookingTermMapping(deleteVoList);
			}

			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}