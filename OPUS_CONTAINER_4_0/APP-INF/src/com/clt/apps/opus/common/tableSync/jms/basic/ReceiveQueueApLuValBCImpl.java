/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_LU_VALImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.clt.apps.opus.common.tableSync.jms.integration.ReceiveQueueApLuValDBDAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApLuValVO;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0460001Document;
import com.clt.irep.erp.FNS0460001Document.FNS0460001;
import com.clt.irep.erp.FNS0460001Document.FNS0460001.DataArea;
import com.clt.irep.erp.FNS0460001Document.FNS0460001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0460001Document.FNS0460001.DataArea.ROWSET.ROW;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueApLuValBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueApLuValDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueApLuValBCImpl() {
		dbDao = new ReceiveQueueApLuValDBDAO();
	}

	/**
	 * FNS0460001Document parse
	 * @param xmlObjcet
	 */
	public Collection receiveBKGTB(XmlObject xmlObject) {
		
		FNS0460001Document doc = (FNS0460001Document) xmlObject;
		FNS0460001 sync = doc.getFNS0460001();
		
		EAIHeaderType header = sync.getEAIHeader();
		String instanceId = header.getInstanceId();
		String eaiEvntDt = instanceId.substring(12,26);
		
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();

		ApLuValVO model = null;
		Collection models = new ArrayList();

		for (int i = 0; row != null && i < row.length; i++) {
			
			model = new ApLuValVO();
			
			model.setLuTpIndCd(row[i].getLOOKUPTYPE());
			model.setLuCd(row[i].getLOOKUPCODE());
			model.setLuDeltFlg(row[i].getENABLEDFLAG());
			model.setLuCtnt(row[i].getATTRIBUTE1());
			model.setLuDesc(row[i].getDESCRIPTION());
			model.setLuStActDt(row[i].getSTARTDATEACTIVE());
			model.setLuEndActDt(row[i].getENDDATEACTIVE());
			model.setAvalFlg(row[i].getENABLEDFLAG());
			model.setCreDt(row[i].getCREATIONDATE());
			model.setCreUsrId(row[i].getCREATEDBY());
			model.setUpdDt(row[i].getLASTUPDATEDATE());
			model.setUpdUsrId(row[i].getLASTUPDATEDBY());
			model.setEaiEvntDt(eaiEvntDt);
			
			models.add(row[i].getOPCD());
			models.add(model);
			
			model = null;
		}
		
		return models;
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator itr = models.iterator();
		ApLuValVO model = null;
		
		int i=1;
		String eaiSts = "";
		while (itr.hasNext()) {
			if(i%2==1){
				eaiSts = (String)itr.next();
			}else{
				model = (ApLuValVO)itr.next();

				if (eaiSts.equals("C") || eaiSts.equals("U"))
					eaiSts = "U";
	
				try {
					
					String luTpIndCd 	= model.getLuTpIndCd();
					String luCd 		= model.getLuCd();
					
					switch (eaiSts.charAt(0)) {
					case 'U':
						if(dbDao.searchApLuValList(luTpIndCd, luCd)){
							if ( luTpIndCd != null && luTpIndCd.trim().length() > 0 
									&& luCd != null && luCd.trim().length() > 0 ) {
								dbDao.addApLuVal(model);
							}
						}else{
							if ( luTpIndCd != null && luTpIndCd.trim().length() > 0 
									&& luCd != null && luCd.trim().length() > 0 ) {
								dbDao.modifyApLuVal(model);
							}
						}
						break;
					case 'D':
						dbDao.removeApLuVal(model);
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
}
