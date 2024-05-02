/*=========================================================
* Copyright(c) 2011 CyberLogitec
* @FileName : BkgCopManageBackEndJobBCImpl.java
* @FileTitle : BkgCopManageBackEndJobBCImpl
* Open Issues :
* Change history :
* @LastModifyDate : 2011-09-28
* @LastModifier : Poong-Yeon Cho
* @LastVersion : 1.0
* 2011-09-28 Poong-Yeon Cho
* 1.0 최초생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.Search315VEToBeSentVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Back End Job 처리를 담당<br>
 * @author poong yeon cho
 * @see BkgCopManageBackEndJobBC 참조
 * @since J2EE 1.6
 */
public class BkgCopManageBackEndJobBCImpl extends BackEndCommandSupport {

	private String bkgNo = null;
	private List<String> rplnCopList = null;
	private List<List> actualListArray;
	private List<Search315VEToBeSentVO> veList;
	
	/**
	 * bkg_no get
	 * @return String
	 * @param bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * bkg_no setting
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * bkg_no get
 	 * @return List<String>
	 * @param bkgNo
	 */
	public List<String> getRplnCopList() {
		return rplnCopList;
	}

	/**
	 * replan Cop List setting
	 * @param rplnCopList
	 */
	public void setRplnCopList(List<String> rplnCopList) {
		this.rplnCopList = rplnCopList;
	}
	
	/**
	 * actualListArray get
 	 * @return List<List>
	 * @param actualListArray
	 */
	public List<List> getActualListArray() {
		return actualListArray;
	}

	/**
	 * replan Cop List setting
	 * @param actualListArray
	 */
	public void setActualListArray(List<List> actualListArray) {
		this.actualListArray = actualListArray;
	}

	/**
	 * bkg_no get
 	 * @return List<Search315VEToBeSentVO>
	 * @param veList
	 */
	public List<Search315VEToBeSentVO> getVeList() {
		return veList;
	}

	/**
8	 * replan Cop List setting
	 * @param veList
	 */
	public void setVeList(List<Search315VEToBeSentVO> veList) {
		this.veList = veList;
	}
	
	/**
	 * back end job을 실행시키는 mail method
	 * @return Object
	 */
	public Object doStart() throws Exception {
		BkgCopManageBackEndJob job = new BkgCopManageBackEndJob(getBkgNo(),getRplnCopList(), getActualListArray(), getVeList());
		BackEndJobManager mnger = new BackEndJobManager();
		log.debug("************* backendjob BkgCopManageBackEndJobBCImpl doStart ***************");
		log.debug("\nbkg_no="+getBkgNo());
		log.debug("\ngetRplnCopList size="+(getRplnCopList()==null?"":getRplnCopList().size()));
		
		log.debug("************* backendjob BkgCopManageBackEndJob execute ***************");
		
		return mnger.execute(job, "SCE ACT MPG", "SCE BackEndJob - bookingUpdate");
	}
}


