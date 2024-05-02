/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueGlMonXchRtBCImpl.java
 *@FileTitle : NIS2010 Table GL MON XCH RT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-23
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.0
 * 2009-09-23 Sun, Choi
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.clt.apps.opus.common.tableSync.jms.integration.ReceiveQueueGlMonXchRtDBDAO;
import com.clt.apps.opus.common.tableSync.jms.vo.CreateGlMonXchRtVO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0470001Document;
import com.clt.irep.erp.FNS0470001Document.FNS0470001;
import com.clt.irep.erp.FNS0470001Document.FNS0470001.DataArea;
import com.clt.irep.erp.FNS0470001Document.FNS0470001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0470001Document.FNS0470001.DataArea.ROWSET.ROW;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * 
 * @author Sun, Choi
 * @since J2EE 1.4
 */
public class ReceiveQueueGlMonXchRtBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueGlMonXchRtDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueGlMonXchRtBCImpl() {
		dbDao = new ReceiveQueueGlMonXchRtDBDAO();
	}

	/**
	 * FNS0470001Document parse
	 * @param xmlObjcet
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveBKGTB(XmlObject xmlObject) {
		FNS0470001Document doc = (FNS0470001Document) xmlObject;
		FNS0470001 sync = doc.getFNS0470001();
		
		EAIHeaderType header = sync.getEAIHeader();
		String instanceId = header.getInstanceId();
		String eai_evnt_dt = instanceId.substring(12,26);
		
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();

		CreateGlMonXchRtVO model = null;
		Collection models = new ArrayList();

		for (int i = 0; row != null && i < row.length; i++) {
			model = new CreateGlMonXchRtVO();
			model.setAcctXchRtYrmon(row[i].getRTYM());
			model.setAcctXchRtLvl  (row[i].getRTDIV());
			model.setCurrCd          (row[i].getCURRCD());
			model.setUsdLoclXchRt  (String.valueOf(row[i].getRT1()));
			model.setLoclKrwXchRt  (String.valueOf(row[i].getRT2()));
			model.setUsdKrwXchRt   (String.valueOf(row[i].getRT3()));
			model.setUpdUsrId		  (row[i].getCRTID());
			model.setUpdDt           (row[i].getUPTDT());
			model.setDeltFlg         (row[i].getDELMK());
			model.setCreDt           (row[i].getCRTDT());
			model.setEaiEvntDt      (eai_evnt_dt);
			models.add("U");
			models.add(model);
//			log.info("receiveBKGTB_row[i].getDELMK()================>"+row[i].getDELMK());
//			log.info("receiveBKGTB_models================>"+models);
//			log.info("receiveBKGTB_model================>"+model);
			model = null;
		}
		return models;
	}
	
	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	@SuppressWarnings("unchecked")
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator itr = models.iterator();
//		Iterator itr2 = models.iterator();
		CreateGlMonXchRtVO model = null;
//		DeleteGlMonXchRtVO model2 = null;

		int i=1;
		String eaiSts = "";
		while (itr.hasNext()) {
			if(i%2==1){
				eaiSts=(String)itr.next();
			}else{
				model = (CreateGlMonXchRtVO)itr.next();
//				log.info("Create_ctrlBKGTB_model================>"+model);
//				log.info("Create_ctrlBKGTB_eaiSts================>"+eaiSts);
				if (eaiSts.equals("C") || eaiSts.equals("U"))
					eaiSts = "U";
	
				try {
					boolean isSuccessFlag = false;
					String acct_xch_rt_yrmon = model.getAcctXchRtYrmon();
					String acct_xch_rt_lvl = model.getAcctXchRtLvl();
					String curr_cd = model.getCurrCd();
					
					switch (eaiSts.charAt(0)) {
					case 'U':
//						isSuccessFlag = createBKGTB(models);
						isSuccessFlag = dbDao.searchGlMonXchRt(acct_xch_rt_yrmon, acct_xch_rt_lvl, curr_cd);
						
						if(isSuccessFlag){
							dbDao.addGlMonXchRt(model);
						}else{
							dbDao.modifyGlMonXchRt(model);
						}
						break;
					case 'D':
//						isSuccessFlag = removeBKGTB(models);
						isSuccessFlag = dbDao.searchGlMonXchRt(acct_xch_rt_yrmon, acct_xch_rt_lvl, curr_cd);
						if(!isSuccessFlag)	dbDao.removeGlMonXchRt(model);
						
						break;
					}
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					throw de;
				} catch (Exception e) {
					log.error("Exception " + e.toString(), e);
				}
			}
			i++;
		}
	}
	
	/** DBDAO의 removeGlMonXchRt메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeBKGTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			CreateGlMonXchRtVO model = null;
			Iterator itr = models.iterator();
			while (itr.hasNext()) {
				model = (CreateGlMonXchRtVO)itr.next();
			}
			
			delCnt = dbDao.removeGlMonXchRt(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
