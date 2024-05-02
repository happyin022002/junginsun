/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : BkgCopManageBackEndJob.java
* @FileTitle : BkgCopManage BackEndJob
* Open Issues :
* Change history :
* @LastModifyDate : 2011-09-27
* @LastModifier : Poong-Yeon Cho
* @LastVersion : 1.0
* 2011-09-27 Poong-Yeon Cho
* 1.0 최초생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.backend.core.BackEndMetaData;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration.BkgCopManageDBDAO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.Search315VEToBeSentVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;

/**
 * Back End Job 처리를 담당<br>
 * @author poong yeon cho
 * @see BkgCopManageBackEndJobBCImpl 참조
 * @since J2EE 1.6
 */
public class BkgCopManageBackEndJob extends BackEndCommandSupport implements BkgCopManageBackEndJobBC {

	private static final long serialVersionUID = -5785543456939529197L;
	private transient BkgCopManageDBDAO bkgCopDbDao = null;
	private transient CopDetailReceiveBC copDetailReceiveBC = null;
	private transient Edi315SendBC edi315BC = null;
	
	private String bkgNo = null;
	private List<String> rplnCopList = null;
	private List<List> actualListArray = null;
	private List<Search315VEToBeSentVO> veList = null;
	
	/**
	 * Constructor
	 * @param String bkgNoVal
	 * @param List<String> rplnCopList
	 * @param List<List> actualListArrayVal
	 * @param List<Search315VEToBeSentVO> veListVal
	 */
	public BkgCopManageBackEndJob(String bkgNoVal, List<String> rplnCopList, List<List> actualListArrayVal, List<Search315VEToBeSentVO> veListVal){
		bkgCopDbDao = new BkgCopManageDBDAO();
		copDetailReceiveBC = new CopDetailReceiveBCImpl();
		edi315BC = new Edi315SendBCImpl();
		bkgNo = bkgNoVal;
		this.rplnCopList = rplnCopList;
		this.actualListArray = actualListArrayVal;
		this.veList = veListVal;
	}
	
	/**
	 * back end job을 실행시키는 mail method
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		searchActualToBeUpdated();
		return null;
	}

	/**
	 * Actual Mapping / VE 대상 315 EDI 발송
	 * @throws Exception
	 */
	private void searchActualToBeUpdated() throws EventException{
		
		try{
			for (int k = 0; k < actualListArray.size(); k ++) {
				List<SceActRcvIfVO> actualList = actualListArray.get(k);
				for (int i = 0; i < actualList.size(); i ++) {
					SceActRcvIfVO actVO = actualList.get(i);
//					log.info(k+":poong backendjop before="+actVO.getVslCd()+actVO.getSkdVoyNo()+actVO.getSkdDirCd());
					copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
				}
			}

//			List<Search315VEToBeSentVO> veList = bkgCopDbDao.search315VEToBeSent(bkgNo);
			List<Search315VEToBeSentVO> veListVO = this.veList;

			log.info("********* ve 315 send start***************");
			for (int i = 0; i < veListVO.size(); i ++) {
				Search315VEToBeSentVO veRow = veListVO.get(i);
				if (veRow.getSendEdi() != null && veRow.getSendEdi().equals("Y")) {
					Edi315SendVO edi315SendVO = new Edi315SendVO();

					edi315SendVO.setCntrNo(veRow.getCntrNo());
					edi315SendVO.setBkgNo(veRow.getBkgNo());
					edi315SendVO.setCopNo(veRow.getCopNo());
					edi315SendVO.setEdiStatus("VE");
					edi315SendVO.setCallFrom("COP");
					edi315SendVO.setCurrVvd(veRow.getVslCd() + veRow.getSkdVoyNo() + veRow.getSkdDirCd());
					edi315SendVO.setEventDt(veRow.getPcPodArrTime());
					edi315SendVO.setEventYard(veRow.getPcPod());
					edi315SendVO.setCreId("REP");
					edi315SendVO.setUpdId("REP");

					double starttime = System.currentTimeMillis();

					log.info("Start VE EDI 315 SEND!!! = " +  starttime);

					edi315BC.edi315Send(edi315SendVO);
					
					double endtime = System.currentTimeMillis();
					
					log.info("Start VE EDI 315 SEND!!! = " + endtime + " / elapse time = " + (endtime - starttime)  );
				}
			}
			log.info("************* ve 315 send complete***************");
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
}
