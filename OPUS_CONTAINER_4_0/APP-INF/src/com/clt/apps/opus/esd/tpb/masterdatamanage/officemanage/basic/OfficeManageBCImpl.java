/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbOfficeManageBCImpl.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration.OfficeManageDBDAO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -TpbMasterDataManage Business Logic Basic Command implementation<br>
 * - -TpbMasterDataManage business logic interface<br>
 *
 * @author 
 * @see ESD_TBP_102EventResponse,TpbOfficeManageBC DAO class reference
 * @since J2EE 1.6
 */
public class OfficeManageBCImpl extends BasicCommandSupport implements OfficeManageBC {

	// Database Access Object
	private transient OfficeManageDBDAO dbDao = null;

	/**
	 * TpbOfficeManageBCImpl object creation<br>
	 * TpbOfficeManageDBDAO creation<br>
	 */
	public OfficeManageBCImpl() {
		dbDao = new OfficeManageDBDAO();
	}

	/**
	 * <br>
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
	 * <br>
	 * 
	 * @param SearchOfficeListVO[] searchOfficeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchOfficeList(SearchOfficeListVO[] searchOfficeListVO, SignOnUserAccount account) throws EventException{
		try {
 			List<SearchOfficeListVO> insertVoList = new ArrayList<SearchOfficeListVO>();
			List<SearchOfficeListVO> insertVoList2 = new ArrayList<SearchOfficeListVO>();
			List<SearchOfficeListVO> updateVoList = new ArrayList<SearchOfficeListVO>();
			SearchOfficeListVO tmpSearchOfficeListVO;
			List<SearchOfficeListVO> searchOfficeListVOtpb;	
			
			for ( int i=0; i<searchOfficeListVO .length; i++ ) {
				if ( searchOfficeListVO[i].getIbflag().equals("I")){
					searchOfficeListVO[i].setCreUsrId(account.getUsr_id());
					//hq일때 자동으로 rhq_cd도 들어가도록 해준다.
					if("R".equals(searchOfficeListVO[i].getN3ptyOfcTpCd())){
						searchOfficeListVO[i].setRhqCd(searchOfficeListVO[i].getOfcCd());
					}
					insertVoList.add(searchOfficeListVO[i]);
					
					if("N".equals(searchOfficeListVO[i].getIsSave()) && "G".equals(searchOfficeListVO[i].getN3ptyOfcTpCd())){
						tmpSearchOfficeListVO = new SearchOfficeListVO();
						tmpSearchOfficeListVO.setN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						tmpSearchOfficeListVO.setRhqCd(searchOfficeListVO[i].getArHdQtrOfcCd());
						tmpSearchOfficeListVO.setDeltFlg(searchOfficeListVO[i].getDeltFlg());
						tmpSearchOfficeListVO.setCreUsrId(account.getUsr_id());
						
						tmpSearchOfficeListVO.setSN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setSOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						
						searchOfficeListVOtpb =  dbDao.searchOfficeList2(tmpSearchOfficeListVO);
						
						if(searchOfficeListVOtpb==null || searchOfficeListVOtpb.size()==0){
							insertVoList2.add(tmpSearchOfficeListVO);
						}
					}
					
				} else if ( searchOfficeListVO[i].getIbflag().equals("U")){
					if("N".equals(searchOfficeListVO[i].getIsSave()) && "G".equals(searchOfficeListVO[i].getN3ptyOfcTpCd())){//저장이 안된 offic cd일 경우
						searchOfficeListVO[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(searchOfficeListVO[i]);
						
						tmpSearchOfficeListVO = new SearchOfficeListVO();
						tmpSearchOfficeListVO.setN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						tmpSearchOfficeListVO.setRhqCd(searchOfficeListVO[i].getArHdQtrOfcCd());
						tmpSearchOfficeListVO.setDeltFlg(searchOfficeListVO[i].getDeltFlg());
						tmpSearchOfficeListVO.setCreUsrId(account.getUsr_id());
						
						tmpSearchOfficeListVO.setSN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setSOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						
						searchOfficeListVOtpb =  dbDao.searchOfficeList2(tmpSearchOfficeListVO);
						
						if(searchOfficeListVOtpb==null || searchOfficeListVOtpb.size()==0){
							insertVoList2.add(tmpSearchOfficeListVO);
						}
						
					}else if("Y".equals(searchOfficeListVO[i].getIsSave()) && "G".equals(searchOfficeListVO[i].getN3ptyOfcTpCd())){//저장이 되어있으면
						searchOfficeListVO[i].setCreUsrId(account.getUsr_id());
						updateVoList.add(searchOfficeListVO[i]);
						
						tmpSearchOfficeListVO = new SearchOfficeListVO();
						tmpSearchOfficeListVO.setN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						tmpSearchOfficeListVO.setRhqCd(searchOfficeListVO[i].getArHdQtrOfcCd());
						tmpSearchOfficeListVO.setDeltFlg(searchOfficeListVO[i].getDeltFlg());
						tmpSearchOfficeListVO.setCreUsrId(account.getUsr_id());
						
						tmpSearchOfficeListVO.setSN3ptyOfcTpCd("T");
						tmpSearchOfficeListVO.setSOfcCd(searchOfficeListVO[i].getN3ptyOfcCd());
						
						searchOfficeListVOtpb =  dbDao.searchOfficeList2(tmpSearchOfficeListVO);
						
						if(searchOfficeListVOtpb==null || searchOfficeListVOtpb.size()==0){
							insertVoList2.add(tmpSearchOfficeListVO);
						}
						
					}else{
						searchOfficeListVO[i].setUpdUsrId(account.getUsr_id());
						//hq일때 자동으로 rhq_cd도 들어가도록 해준다.
						if("R".equals(searchOfficeListVO[i].getN3ptyOfcTpCd())){
							searchOfficeListVO[i].setRhqCd(searchOfficeListVO[i].getOfcCd());
						}
						updateVoList.add(searchOfficeListVO[i]);
					}
					
				}
			}
			
			
			for(int i=0; i<insertVoList.size(); i++){
				int cnt = dbDao.searchMdmOfficeCheck(insertVoList.get(i));
				if(cnt<=0){
					throw new EventException("Invalid Office Code : "+insertVoList2.get(i).getOfcCd());
				}
				
			}
			
			for(int i=0; i<insertVoList2.size(); i++){
				int cnt = dbDao.searchMdmOfficeCheck(insertVoList2.get(i));
				if(cnt<=0){
					throw new EventException("Invalid Office Code : "+insertVoList2.get(i).getOfcCd());
				}
			}
			
			for(int i=0; i<updateVoList.size(); i++){
				int cnt = dbDao.searchMdmOfficeCheck(updateVoList.get(i));
				if(cnt<=0){
					throw new EventException("Invalid Office Code : "+insertVoList2.get(i).getOfcCd());
				}
			}				
			
			for(int i=0; i<insertVoList.size(); i++){
				int cnt = dbDao.searchHoRhqOfficeCheck(insertVoList.get(i));
				if(cnt>0 &&  ("T".equals(insertVoList.get(i).getN3ptyOfcTpCd()) || "G".equals(insertVoList.get(i).getN3ptyOfcTpCd())) ){
					throw new EventException(" Do not input Head Office or Regional Head Office in Office column : "+insertVoList.get(i).getOfcCd());
				}
				
			}
			
			for(int i=0; i<insertVoList2.size(); i++){
				int cnt = dbDao.searchHoRhqOfficeCheck(insertVoList2.get(i));
				if(cnt>0){
					throw new EventException("Do not input Head Office or Regional Head Office in TPB Office column : "+insertVoList2.get(i).getOfcCd());
				}
			}
			
			for(int i=0; i<updateVoList.size(); i++){
				int cnt = dbDao.searchHoRhqOfficeCheck(updateVoList.get(i));
				if(cnt>0 &&  ("T".equals(updateVoList.get(i).getN3ptyOfcTpCd()) || "G".equals(updateVoList.get(i).getN3ptyOfcTpCd())) ){
					throw new EventException("Do not input Head Office or Regional Head Office in Office column : "+updateVoList.get(i).getOfcCd());
				}
			}		
			
			
			//인서트
			if ( insertVoList.size() > 0 ) {
				dbDao.addSearchOfficeList(insertVoList);
			}
			
			//TPB INV 생성해준다.
			if ( insertVoList2.size() > 0 ) {
				dbDao.addSearchOfficeList(insertVoList2);
			}			
			
			//UPDATE
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
	 * <br>
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