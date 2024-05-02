/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAManageCarrierBackEndJob.java
*@FileTitle : Add Carriers
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.26
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.26 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration.BSAManageDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - ALPS-Add Carrier 에 대한 BackEndJob<br>
 *
 * @author CHOI SUNGMIN
 * @see BSAManageBC
 * @since J2EE 1.6
 */
public class BSAManageCarrierBackEndJob extends BackEndCommandSupport{
	
	private static final long serialVersionUID = 196244885789457834L;
	private BSAManageDBDAO dbDao = new BSAManageDBDAO();	
	private List<BsaAddCarrierSaveVO> list = null;

	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param List<BsaAddCarrierSaveVO> list
	 * @exception
	 */	
	public void setBsaAddCarrierVO(List<BsaAddCarrierSaveVO> list) {
		this.list = list;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return String
	 * @exception Exception
	 */	
	public String doStart() throws Exception {
		try {	
			if(list.size() > 0) {				
				String bsaOpCd = list.get(0).getBsaOpCd();
		        if (bsaOpCd.equals("J")){
					dbDao.modifyCarrierRegisterJO(list);
		        }else{
		        	dbDao.addCarrierRegisterSC(list);
		        	dbDao.modifyCarrierRegisterSC(list);			
				}
			}			
			return "SUCCESS";
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
