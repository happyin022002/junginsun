/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTSecurityBCImpl.java
*@FileTitle : Security & AR Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.integration.AGTSecurityDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtFincOfcInfoVO;

/**
 * OPUS-AGTMaster Business Logic Basic Command implementation<br>
 * - OPUS-AGTMaster handling Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ESM_AGT_0038EventResponse,AGTSecurityBC DAO Class
 * @since J2EE 1.6
 */
public class AGTSecurityBCImpl extends BasicCommandSupport implements AGTSecurityBC {

	// Database Access Object
	private transient AGTSecurityDBDAO dbDao = null;

	/**
	 * AGTSecurityBCImpl Object creation<br>
	 * AGTSecurityDBDAO creation<br>
	 */
	public AGTSecurityBCImpl() {
		dbDao = new AGTSecurityDBDAO();
	}
	/**
	 * ESM_AGT_0038 retrieve event process<br>
	 * 
	 * @param AgtFincOfcInfoVO agtFincOfcInfoVO
	 * @return List<AgtFincOfcInfoVO>
	 * @exception EventException
	 */
	public List<AgtFincOfcInfoVO> searchAROfficeInfoList(AgtFincOfcInfoVO agtFincOfcInfoVO) throws EventException {
		try {
			return dbDao.searchAROfficeInfoList(agtFincOfcInfoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESM_AGT_0038 multi event process<br>
	 * 
	 * @param AgtFincOfcInfoVO[] agtFincOfcInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAROfficeInfobyOffice(AgtFincOfcInfoVO[] agtFincOfcInfoVO, SignOnUserAccount account) throws EventException{
		try {
			com.clt.apps.opus.esm.agt.common.basic.CommonBC comBC
			= new com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl();
			//HashMap<String, String> searchOfficeCode(String ofc_cd)
			HashMap<String, String> officeCd = null;
			String offCd = "";
			List<AgtFincOfcInfoVO> insertVoList = new ArrayList<AgtFincOfcInfoVO>();
			List<AgtFincOfcInfoVO> updateVoList = new ArrayList<AgtFincOfcInfoVO>();
			List<AgtFincOfcInfoVO> deleteVoList = new ArrayList<AgtFincOfcInfoVO>();
			for ( int i=0; i<agtFincOfcInfoVO .length; i++ ) {
				if ( agtFincOfcInfoVO[i].getIbflag().equals("I")){
					agtFincOfcInfoVO[i].setCreUsrId(account.getUsr_id());
					agtFincOfcInfoVO[i].setCommOfcFlg(agtFincOfcInfoVO[i].getDeltFlg().equals("Y")?"N":"Y");
					insertVoList.add(agtFincOfcInfoVO[i]);
				} else if ( agtFincOfcInfoVO[i].getIbflag().equals("U")){
					officeCd = comBC.searchOfficeCode(agtFincOfcInfoVO[i].getArOfcCd());
					agtFincOfcInfoVO[i].setCommOfcFlg(agtFincOfcInfoVO[i].getDeltFlg().equals("Y")?"N":"Y");
					offCd = officeCd.get("OFC_CD");
					
					if(offCd.equals("")){
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Office"}).getMessage());
					}
					
					agtFincOfcInfoVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(agtFincOfcInfoVO[i]);
				} else if ( agtFincOfcInfoVO[i].getIbflag().equals("D")){
					agtFincOfcInfoVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(agtFincOfcInfoVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiAROfficeInfobyOfficeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiAROfficeInfobyOfficeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiAROfficeInfobyOfficeS(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("AGT00027", new String[]{"Office"}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}