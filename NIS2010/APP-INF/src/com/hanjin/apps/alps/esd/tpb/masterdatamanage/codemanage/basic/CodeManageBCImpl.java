/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbCodeManageBCImpl.java
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.1
* 2008.08.29 O Wan-Ki 1.0 최초 생성
* 2009.07.02 황건하          1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration.CodeManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-TpbMasterDataManage Business Logic Basic Command implementation<br>
 * - NIS2010-TpbMasterDataManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see EsdTpb101EventResponse,TpbCodeManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CodeManageBCImpl extends BasicCommandSupport implements CodeManageBC {

	// Database Access Object
	private transient CodeManageDBDAO dbDao = null;

	/**
	 * TpbCodeManageBCImpl 객체 생성<br>
	 * TpbCodeManageDBDAO를 생성한다.<br>
	 */
	public CodeManageBCImpl() {
		dbDao = new CodeManageDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 *  TpbCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCodeListVO searchTPBCodeListVO
	 * @return List<SearchCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCodeListVO> searchCodeList(SearchCodeListVO searchTPBCodeListVO) throws EventException {
		try {
			return dbDao.searchCodeListValue(searchTPBCodeListVO);	//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_EDM_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchCodeListVO[] searchCodeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchCodeList(SearchCodeListVO[] searchCodeListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchCodeListVO> insertVoList = new ArrayList<SearchCodeListVO>();
			List<SearchCodeListVO> updateVoList = new ArrayList<SearchCodeListVO>();
			List<SearchCodeListVO> deleteVoList = new ArrayList<SearchCodeListVO>();
			
			for ( int i=0; i<searchCodeListVO .length; i++ ) {
				if ( searchCodeListVO[i].getIbflag().equals("I")){
					searchCodeListVO[i].setCreUsrId(account.getUsr_id());
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchCodeListVO[i]);
				} else if ( searchCodeListVO[i].getIbflag().equals("U")){
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchCodeListVO[i]);
				} else if ( searchCodeListVO[i].getIbflag().equals("D")){
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(searchCodeListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSearchCodeList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySearchCodeList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSearchCodeList(deleteVoList);
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
	 * 조회 이벤트 처리<br>
	 *  TpbCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCodeInquiryListVO searchCodeInquiryListVO
	 * @return List<SearchCodeInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchCodeInquiryListVO> searchCodeInquiryList(SearchCodeInquiryListVO searchCodeInquiryListVO) throws EventException {
		try {
			return dbDao.searchCodeInquiryList(searchCodeInquiryListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}