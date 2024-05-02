/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OCPChgColmanageBCImpl
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-10
*@LastModifier : Jeongsoo Lee
*@LastVersion : 1.0
* 2010-11-10 Jeongsoo Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.integration.OCPChgColmanageDBDAO;
import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OCPChgColmanageBCImpl<br>
 * 미주 OCP charge collection 대상건의 collection 여부를 검색하고, 진행사항을 text로 입력
 * @author Jeongsoo Lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class OCPChgColmanageBCImpl extends BasicCommandSupport implements OCPChgColmanageBC {

	
	// Database Access Object 
	private transient OCPChgColmanageDBDAO dbDao = null;

	/**
	 * OCPChgColmanageBCImpl 객체 생성<br>
	 * OCPChgColmanageDBDAO 생성한다.<br>
	 */
	public OCPChgColmanageBCImpl(){
		dbDao = new OCPChgColmanageDBDAO();
	}
	
	/**
	 * ESD_EAS_0010 : Retrieve<br>
	 * [미주 OCP charge collection]을 [조회] 합니다.<br>
	 * 
	 * @param SearchOCPChgListVO searchOCPChgListVO
	 * @return List<SearchOCPChgListVO>
	 * @exception EventException
	 */
	public List<SearchOCPChgListVO> searchOcpChgList(SearchOCPChgListVO searchOCPChgListVO) throws EventException {
		try {
			return dbDao.searchOcpChgList(searchOCPChgListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * ESD_EAS_0010 : Save<br>
	 * [미주 OCP charge collection]을 [저장] 합니다.<br>
	 * 
	 * @param SearchOCPChgListVO[] searchOCPChgListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void multiOcpChgList(SearchOCPChgListVO[] searchOCPChgListVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchOCPChgListVO> insertVoList = new ArrayList<SearchOCPChgListVO>();
			List<SearchOCPChgListVO> updateVoList = new ArrayList<SearchOCPChgListVO>();
			List<SearchOCPChgListVO> deleteVoList = new ArrayList<SearchOCPChgListVO>();
			for ( int i=0; i<searchOCPChgListVOs .length; i++ ) {
				if ( searchOCPChgListVOs[i].getIbflag().equals("I")){
					searchOCPChgListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchOCPChgListVOs[i]);
				} else if ( searchOCPChgListVOs[i].getIbflag().equals("U")){
					
					searchOCPChgListVOs[i].setUpdUsrId(account.getUsr_id());
					searchOCPChgListVOs[i].setBkgNo(searchOCPChgListVOs[i].getBkgNo());
					searchOCPChgListVOs[i].setCreOfcCd(account.getOfc_cd());
					searchOCPChgListVOs[i].setRmkCtnt(searchOCPChgListVOs[i].getRmkCtnt());
					searchOCPChgListVOs[i].setEasExpnTpCd(searchOCPChgListVOs[i].getEasExpnTpCd());
					searchOCPChgListVOs[i].setCntrNo(searchOCPChgListVOs[i].getCntrNo());
					log.debug("searchOCPChgListVOs[i]-------------->>>>"+searchOCPChgListVOs[i].getColumnValues());
					updateVoList.add(searchOCPChgListVOs[i]);
					log.debug("updateVoList------------->>>>>"+updateVoList);
				} else if ( searchOCPChgListVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchOCPChgListVOs[i]);
				}
			}
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addNewMember(insertVoList);
//			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiOcpChgList(updateVoList);
			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeMember(deleteVoList);
//			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

 	
	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException 
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException {
		String check = null;
		try {

				check = dbDao.checkLocation(locLevel ,locCD);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21017",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}


}
