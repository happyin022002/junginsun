/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeBCImpl.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.integration.TariffCodeDBDAO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * Tariff Business Logic Command Interface<br>
 *
 * @author SHKIM
 * @see EsmPri3502EventResponse,TariffCodeBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class TariffCodeBCImpl extends BasicCommandSupport implements TariffCodeBC {

	// Database Access Object
	private transient TariffCodeDBDAO dbDao = null;

	/**
	 * Creating TariffRuleBCImpl object<br>
	 * Creating TariffRuleDBDAO<br>
	 */
	public TariffCodeBCImpl() {
		dbDao = new TariffCodeDBDAO();
	}
	
	/**
	 * ESM_PRI_3502 : Retrieve <br>
	 * Retrieving tariff scope by inputed Tariff Code
	 * 
	 * @param RsltSvcScpCdVO rsltSvcScpCdVO
	 * @return List<RsltSvcScpCdVO>
	 * @exception EventException
	 */
	public List<RsltSvcScpCdVO> searchTariffCode(RsltSvcScpCdVO rsltSvcScpCdVO) throws EventException {
		try {
			return dbDao.searchTariffCode(rsltSvcScpCdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Modifying Tariff Name ,Adding and deleting Tariff Scope
	 * 
	 * @param InPriTariffVO inPriTariffVO
	 * @param RsltSvcScpCdVO[] rsltSvcScpCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffCode(InPriTariffVO inPriTariffVO,RsltSvcScpCdVO[] rsltSvcScpCdVOs,SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
			try {			
			List<RsltSvcScpCdVO> insertSheetVoList = new ArrayList<RsltSvcScpCdVO>();
			List<RsltSvcScpCdVO> deleteSheetVoList = new ArrayList<RsltSvcScpCdVO>();			
				
				if(inPriTariffVO != null){				
					inPriTariffVO.setUpdUsrId(account.getUsr_id());
					if(!inPriTariffVO.getCreFlg().equals("N")){
						inPriTariffVO.setCreUsrId(account.getUsr_id());
						inPriTariffVO.setUpdUsrId(account.getUsr_id());
						dbDao.addTariffCode(inPriTariffVO);							
					}
				} 	
				
				if(rsltSvcScpCdVOs != null)	{

					for ( int i=0; i<rsltSvcScpCdVOs .length; i++ ) {
						if ( rsltSvcScpCdVOs[i].getIbflag().equals("I")){
							rsltSvcScpCdVOs[i].setCreUsrId(account.getUsr_id());
							rsltSvcScpCdVOs[i].setUpdUsrId(account.getUsr_id());
							insertSheetVoList.add(rsltSvcScpCdVOs[i]);					
						}else if ( rsltSvcScpCdVOs[i].getIbflag().equals("D")){
							deleteSheetVoList.add(rsltSvcScpCdVOs[i]);
						}
					}	
				}

				if ( deleteSheetVoList.size() > 0 ) {
					dbDao.removeSelTariffScope(deleteSheetVoList);
				}
				
				if ( insertSheetVoList.size() > 0 ) {						
					dbDao.addTariffScope(insertSheetVoList);
				}					
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * Deleting Tariff and scope with tariff  
	 * 
	 * @param PriTariffVO priTariffVO
	 * @exception EventException
	 */
	public void removeTariffCode(PriTariffVO priTariffVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.removeTariffScope(priTariffVO);
			dbDao.removeTariffCode(priTariffVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Scope duplicate check
	 * 
	 * @param RsltSvcScpCdVO[] rsltSvcScpCdVOs
	 * @return List<SearchTariffScopeDupVO>
	 * @exception EventException
	 */
	public List<SearchTariffScopeDupVO> searchTariffScopeDuplicate(RsltSvcScpCdVO[] rsltSvcScpCdVOs) throws EventException {
		// TODO Auto-generated method stub
			try {		
			List<SearchTariffScopeDupVO> duplist = new ArrayList<SearchTariffScopeDupVO>();
			List<String> checkVoList = new ArrayList<String>();
			
			if(rsltSvcScpCdVOs != null && rsltSvcScpCdVOs.length > 0 ){

				for ( int i=0; i<rsltSvcScpCdVOs .length; i++ ) {
					if ( rsltSvcScpCdVOs[i].getIbflag().equals("I")){
						checkVoList.add(rsltSvcScpCdVOs[i].getSvcScpCd());	
					}
				}	
				
				if ( checkVoList.size() > 0 ) {
					duplist  = dbDao.searchTariffScopeDuplicate(rsltSvcScpCdVOs[0],checkVoList);
				}
			}
			return duplist;

		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return SearchTariffCodeUsedVO
	 * @exception EventException
	 */
	public SearchTariffCodeUsedVO searchTariffCodeUsed(PriTariffVO priTariffVO) throws EventException {
		// TODO Auto-generated method stub
			try {						
				return dbDao.searchTariffCodeUsed(priTariffVO);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_3503 : Retrieve <br>
	 * Tariff Code Inquiry
	 * 
	 * @param SearchTariffCodeALLVO searchTariffCodeALLVO
	 * @return List<SearchTariffCodeALLVO>
	 * @exception EventException
	 */
	public List<SearchTariffCodeALLVO> searchTariffCodeList(SearchTariffCodeALLVO searchTariffCodeALLVO) throws EventException{
		// TODO Auto-generated method stub
		try {	
			return dbDao.searchTariffCodeALL(searchTariffCodeALLVO);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3502 : Tariff Code Focus out <br>
	 * Retrieving inland rates by inputed Tariff Code
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchInlandRates(PriTariffVO priTariffVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchInlandRates(priTariffVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
}