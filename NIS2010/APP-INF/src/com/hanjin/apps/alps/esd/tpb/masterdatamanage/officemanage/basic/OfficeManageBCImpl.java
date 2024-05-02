/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbOfficeManageBCImpl.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.02 황건하
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.integration.OfficeManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-TpbMasterDataManage Business Logic Basic Command implementation<br>
 * - NIS2010-TpbMasterDataManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TBP_102EventResponse,TpbOfficeManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OfficeManageBCImpl extends BasicCommandSupport implements OfficeManageBC {

	// Database Access Object
	private transient OfficeManageDBDAO dbDao = null;

	/**
	 * TpbOfficeManageBCImpl 객체 생성<br>
	 * TpbOfficeManageDBDAO를 생성한다.<br>
	 */
	public OfficeManageBCImpl() {
		dbDao = new OfficeManageDBDAO();
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListVO searchOfficeListVO
	 * @return List<SearchOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListVO> searchOfficeList(SearchOfficeListVO searchOfficeListVO) throws EventException {
		try {
			return dbDao.searchOfficeList(searchOfficeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListVO[] searchOfficeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchOfficeList(SearchOfficeListVO[] searchOfficeListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchOfficeListVO> insertVoList = new ArrayList<SearchOfficeListVO>();
			List<SearchOfficeListVO> updateVoList = new ArrayList<SearchOfficeListVO>();
			for ( int i=0; i<searchOfficeListVO .length; i++ ) {
				if ( searchOfficeListVO[i].getIbflag().equals("I")){
					searchOfficeListVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(searchOfficeListVO[i]);
				} else if ( searchOfficeListVO[i].getIbflag().equals("U")){
					searchOfficeListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchOfficeListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSearchOfficeList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySearchOfficeList(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO
	 * @return List<SearchOfficeListForInquiryVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListForInquiryVO> searchOfficeListForInquiry(SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO) throws EventException {
		try {
			return dbDao.searchOfficeListForInqiuryValue(searchOfficeListForInqiuryVO);	//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}