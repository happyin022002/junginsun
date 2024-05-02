/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAR_AGN_STMT_AGMTImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-25 : Ho-Jin Lee Alps 전환
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.tableSync.jms.integration.ReceiveQueueArAgnStmtAgmtDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0440001Document;
import com.hanjin.irep.erp.FNS0440001Document.FNS0440001;
import com.hanjin.irep.erp.FNS0440001Document.FNS0440001.DataArea;
import com.hanjin.irep.erp.FNS0440001Document.FNS0440001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0440001Document.FNS0440001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.ArAgnStmtAgmtVO;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueArAgnStmtAgmtBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueArAgnStmtAgmtDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueArAgnStmtAgmtBCImpl() {
		dbDao = new ReceiveQueueArAgnStmtAgmtDBDAO();
	}

	/**
	 * FNS0440001Document parse
	 * @param xmlObjcet
	 */
	public Collection<ArAgnStmtAgmtVO> receiveBKGTB(XmlObject xmlObject) {
		FNS0440001Document doc = (FNS0440001Document) xmlObject;
		log.info("\n <<<<<<receiveBKGTB 1>>>>>");
		FNS0440001 sync = doc.getFNS0440001();
		log.info("\n <<<<<<receiveBKGTB 2>>>>>");
		EAIHeaderType header = sync.getEAIHeader();
		log.info("\n <<<<<<receiveBKGTB 3>>>>>");
		String instanceId = header.getInstanceId();
		log.info("\n <<<<<<receiveBKGTB 4>>>>>");
		String eai_evnt_dt = instanceId.substring(12,26);
		log.info("\n <<<<eai_evnt_dt>>>="+eai_evnt_dt);
		log.info("\n <<<<<<receiveBKGTB 5>>>>>");		
		DataArea data = sync.getDataArea();
		log.info("\n <<<<<<receiveBKGTB : data>>>>>"+data);
		log.info("\n <<<<<<receiveBKGTB 6>>>>>");
		ROWSET rowset = data.getROWSET();
		log.info("\n <<<<<<receiveBKGTB 7>>>>>");
		ROW[] row = rowset.getROWArray();
		log.info("\n <<<<<<receiveBKGTB row>>>>>"+row);
		log.info("\n <<<<<<receiveBKGTB 8>>>>>");

		ArAgnStmtAgmtVO model = null;
		log.info("\n <<<<<<receiveBKGTB 9>>>>>");
		Collection<ArAgnStmtAgmtVO> models = new ArrayList<ArAgnStmtAgmtVO>();
		log.info("\n <<<<<<receiveBKGTB 10>>>>>");

		for (int i = 0; row != null && i < row.length; i++) {
			model = new ArAgnStmtAgmtVO();
			model.setAsaRhqCd     (row[i].getRHQ()); 
			model.setAsaNo         (row[i].getASANO()); 
			model.setAsaOfcCd     (row[i].getOFC()); 
			model.setAsaCurrCd    (row[i].getCUR()); 
			model.setAsaPrdFmDt  (row[i].getPERIODFM()); 
			model.setAsaPrdToDt  (row[i].getPERIODTO()); 
			model.setAsaClzDt     (row[i].getCLSDT()); 
			model.setAsaPrprUsrId(row[i].getPRPRDBY()); 
			model.setAsaAproUsrId(row[i].getAPRVBY()); 
			model.setAsaAproDt    (row[i].getAPRVDT()); 
			model.setDeltFlg       (row[i].getDELMK()); 
			model.setEaiEvntDt    (eai_evnt_dt); 
			model.setCreDt(eai_evnt_dt);
			model.setOpCd(row[i].getOPCD());
			models.add(model);
		}
		
		return models;
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator itr = models.iterator();
		log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 1>>>>>");
		ArAgnStmtAgmtVO model = null;
		log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 2>>>>>");
		
		int i=1;
		log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 3>>>>>");
		String eaiSts = "";
		log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 4>>>>>");
		while (itr.hasNext()) {
			log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 5>>>>>");
				model = (ArAgnStmtAgmtVO)itr.next();
				log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 6>>>>>");
				eaiSts = model.getOpCd();
				log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 7>>>>>");
				log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 7>>>>>"+model);
				if (eaiSts.equals("C") || eaiSts.equals("U"))
					log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 8>>>>>");
					eaiSts = "U";
					log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 9>>>>>");
	
				try {
//					String asa_rhq_cd = model.getAsaRhqCd();
					String asa_no = model.getAsaNo();
					log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 9>>>>>");
					
					asa_no = fixAsa_no(asa_no);
					log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 10>>>>>"+asa_no);
					model.setAsaNo(asa_no);					
					log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 11>>>>>");
					switch (eaiSts.charAt(0)) {
					case 'U':
						log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 12>>>>>");
						boolean isSuccessful = dbDao.searchArAgnStmtAgmtList(model);
						log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 13>>>>>");
						log.info("\n <<<isSuccessful>>>="+isSuccessful);
						if(isSuccessful){
							log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 14>>>>>");
							dbDao.addArAgnStmtAgmt(model);
							log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 15>>>>>");
						}else{
							log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 16>>>>>");
							dbDao.modifyArAgnStmtAgmt(model);
							log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 17>>>>>");
						}
						break;
					case 'D':
						log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 18>>>>>");
						dbDao.removeArAgnStmtAgmt(model);
						log.info("\n <<<<<<ReceiveQueueArAgnStmtAgmtBCImpl ctrlBKGTB 19>>>>>");
						break;
					}
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					throw de;
				} catch (Exception e) {
					log.error("Exception " + e.toString(), e);
				}
			i++;
		}
	}
	
	/**
	 * asa_no conversion
	 * @param asa_no
	 * @return
	 */
	public String fixAsa_no(String asa_no){
		String office_prefix = asa_no.substring(0,3);
		String seq = asa_no.substring(3,7);
		String ymm = asa_no.substring(7,10);
		return office_prefix + ymm + seq;
	}
}
