/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBCImpl.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.integration.GeneralCodeMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
        
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author WanGyu Kim  
 * @see Ees_mnr_0009EventResponse,CEDEXCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4   
 */        
    
public class GeneralCodeMgtBCImpl extends BasicCommandSupport implements GeneralCodeMgtBC {

	// Database Access Object
	private transient GeneralCodeMgtDBDAO dbDao = null; 

	/** 
	 * GeneralCodeMgtBCImpl 객체 생성<br>
	 * GeneralCodeMgtDBDAO를 생성한다.<br>
	 */    
	public GeneralCodeMgtBCImpl() {  
		dbDao = new GeneralCodeMgtDBDAO();
	}

	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeListBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException {
		try { 
			//다건조회
			List<List<CustomMnrGenCdVO>> listCustomMnrGenCdVOs = new ArrayList<List<CustomMnrGenCdVO>>();
			
			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("1");
			List<CustomMnrGenCdVO> customMnrGenCdV0 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("2");
			List<CustomMnrGenCdVO> customMnrGenCdV1 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("3");
			List<CustomMnrGenCdVO> customMnrGenCdV2 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
		                                        
			listCustomMnrGenCdVOs.add(customMnrGenCdV0);      
			listCustomMnrGenCdVOs.add(customMnrGenCdV1);      
			listCustomMnrGenCdVOs.add(customMnrGenCdV2);      
			                      
			generalCodeMgtGRPVO.setListCustomMnrGenCdVOs(listCustomMnrGenCdVOs);   
			return generalCodeMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrGenCdVO> insertVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> updateVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> deleteVoList = new ArrayList<CustomMnrGenCdVO>();

			for ( int i=0; i<generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs() .length; i++ ) {
				if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("I")){
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setCreUsrId(account.getUsr_id());
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} else if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("U")){
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} else if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("D")){
					deleteVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} 
			}  
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGeneralCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGeneralCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGeneralCodeData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		}
	}	
}