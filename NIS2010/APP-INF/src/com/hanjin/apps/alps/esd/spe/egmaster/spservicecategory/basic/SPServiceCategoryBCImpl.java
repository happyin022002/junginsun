/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryBCImpl.java
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event.EsdSpe1003Event;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration.SPServiceCategoryDBDAO;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;

/**
 * ALPS-EGMaster Business Logic Command Interface<br>
 * - ALPS-EGMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class SPServiceCategoryBCImpl extends BasicCommandSupport implements SPServiceCategoryBC {

	// Database Access Object
	private transient SPServiceCategoryDBDAO dbDao = null;

	/**
	 * SPServiceCategoryBCImpl 객체 생성<br>
	 * SPServiceCategoryDBDAO를 생성한다.<br>
	 */
	public SPServiceCategoryBCImpl() {
		dbDao = new SPServiceCategoryDBDAO();
	}


	
	/**
	 * EG 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeSvcCateVO[] speSvcCateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpSvcCateCfm(SpeSvcCateVO[] speSvcCateVOs,SignOnUserAccount account) throws EventException {
		try {
			
			if(null != speSvcCateVOs){
				for(int i=0;i<speSvcCateVOs.length;i++){
					speSvcCateVOs[i].setCreUsrId(account.getUsr_id());
					speSvcCateVOs[i].setUpdUsrId(account.getUsr_id());		
					

					
					if(speSvcCateVOs[i].getIbflag().equals("I")){
						dbDao.addSpSvcCateCfm(speSvcCateVOs[i]);  // 마스터 테이블에 업체등록 
						String saveScVal = speSvcCateVOs[i].getSaveScVal();
						String[] ar = saveScVal.split(",");
						if(ar.length>0){
							for(int k=0;k<ar.length;k++){
								if(!ar[k].equals("")){
									speSvcCateVOs[i].setEvSvcCateCd(ar[k]);
									dbDao.addSpSvcCateCfmStup(speSvcCateVOs[i]);  // 업체의 서비스 카테고리 정보를 저장한다. 
									dbDao.addSpSvcCateCfmHis(speSvcCateVOs[i]);   // 업체와 업체의 서비스 카테고리 정보를 히스토리 테이블에 저장한다. 
								}
							}
						}
						
					}else if(speSvcCateVOs[i].getIbflag().equals("U")){
						
						dbDao.removeSpSvcCateCfm(speSvcCateVOs[i]);      // 마스터 테이블에 업체 삭제
						dbDao.removeSpSvcCateCfmStup(speSvcCateVOs[i]);  // 업체의 서비스 카테고리 정보 삭제
						
						String saveScVal = speSvcCateVOs[i].getSaveScVal().trim();
						String[] ar = saveScVal.split(",");
						
						dbDao.addSpSvcCateCfm(speSvcCateVOs[i]);  // 마스터 테이블에 업체등록 
						if(ar.length>0 && !ar[0].equals("")){
							for(int k=0;k<ar.length;k++){
								if(!ar[k].equals("")){
									speSvcCateVOs[i].setEvSvcCateCd(ar[k]);
									dbDao.addSpSvcCateCfmStup(speSvcCateVOs[i]);  // 업체의 서비스 카테고리 정보를 저장한다. 
									dbDao.addSpSvcCateCfmHis(speSvcCateVOs[i]);   // 업체와 업체의 서비스 카테고리 정보를 히스토리 테이블에 저장한다. 
								}
							}						
						}else{
							dbDao.addSpSvcCateCfmHisChkYn(speSvcCateVOs[i]);   // 업체의 서비스 카테고리 정보를 사용자가 선택을 안한경우 히스토리 테이블에 체크안함으로 저장한다. 
						}
						
					}else if(speSvcCateVOs[i].getIbflag().equals("D")){
						String saveScVal = speSvcCateVOs[i].getSaveScVal();
						String[] ar = saveScVal.split(",");
						dbDao.removeSpSvcCateCfm(speSvcCateVOs[i]);      // 마스터 테이블에 업체 삭제
						dbDao.removeSpSvcCateCfmStup(speSvcCateVOs[i]);  // 업체의 서비스 카테고리 정보 삭제
						
						if(ar.length>0){
							for(int k=0;k<ar.length;k++){
								if(!ar[k].equals("")){
									speSvcCateVOs[i].setEvSvcCateCd(ar[k]);
									dbDao.removeSpSvcCateCfmHis(speSvcCateVOs[i]);   // 히스토리 테이블에 등록된 업체의 정보의 플레그를 삭제로 수정한다.
								}
							}
						}						
						
					}
				}
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 업체의 서비스 카테고리 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSvcCateCfm(Event e)  throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdSpe1003Event event = (EsdSpe1003Event)e; 
		try {
			rowSet = dbDao.searchSpSvcCateCfm(event);
			eventResponse.setRsVo(rowSet);
			return  eventResponse;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 저장전 저장할수 있는 데이터 인지 확인한다.<br>
	 * 
	 * @param SpeSvcCateVO speSvcCateVO
	 * @return List<SpeSvcCateVO>
	 * @exception EventException
	 */
	public List<SpeSvcCateVO> searchSpSvcCateCfmChk(SpeSvcCateVO speSvcCateVO) throws EventException {
		try {
			return dbDao.searchSpSvcCateCfmChk(speSvcCateVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}		
	
}