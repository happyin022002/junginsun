/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PercentBaseChargeBCImpl.java
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration.PercentBaseChargeDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgPctBseChgVO;
import com.hanjin.syscommon.common.table.PriScgPctBseVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeGroupingVO;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 * Percent Base Charge 구성의 조회 및 관리를 위한 Business Component 
 *
 * @author SongHoJin
 * @see Esm_pri_4034EventResponse,PercentBaseChargeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PercentBaseChargeBCImpl extends BasicCommandSupport implements PercentBaseChargeBC {

	// Database Access Object
	private transient PercentBaseChargeDBDAO dbDao = null;

	/**
	 * PercentBaseChargeBCImpl 객체 생성<br>
	 * PercentBaseChargeDBDAO를 생성한다.<br>
	 */
	public PercentBaseChargeBCImpl() {
		dbDao = new PercentBaseChargeDBDAO();
	}
	/**
	 * ESM_PRI_4034 : Retrieve <br>
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
	 * ESM_PRI_4034 : sheet1 on select cell <br>
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
	 * ESM_PRI_4034 : sheet1 SAVE <br>
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
	 * ESM_PRI_4034 : sheet2 SAVE <br>
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
}