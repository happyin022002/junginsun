/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTSecurityBCImpl.java
*@FileTitle : Security & AR Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.14 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration.AGTSecurityDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtFincOfcInfoVO;

/**
 * ALPS-AGTMaster Business Logic Basic Command implementation<br>
 * - ALPS-AGTMaster에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0038EventResponse,AGTSecurityBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGTSecurityBCImpl extends BasicCommandSupport implements AGTSecurityBC {

	// Database Access Object
	private transient AGTSecurityDBDAO dbDao = null;

	/**
	 * AGTSecurityBCImpl 객체 생성<br>
	 * AGTSecurityDBDAO를 생성한다.<br>
	 */
	public AGTSecurityBCImpl() {
		dbDao = new AGTSecurityDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtFincOfcInfoVO[] agtFincOfcInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAROfficeInfobyOffice(AgtFincOfcInfoVO[] agtFincOfcInfoVO, SignOnUserAccount account) throws EventException{
		try {
			com.hanjin.apps.alps.esm.agt.common.basic.CommonBC comBC
			= new com.hanjin.apps.alps.esm.agt.common.basic.CommonBCImpl();
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