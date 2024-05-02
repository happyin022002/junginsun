/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAR_ROUT_RNKImpl.java
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

import com.hanjin.apps.alps.common.tableSync.jms.integration.ReceiveQueueArRoutRnkDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0400001Document;
import com.hanjin.irep.erp.FNS0400001Document.FNS0400001;
import com.hanjin.irep.erp.FNS0400001Document.FNS0400001.DataArea;
import com.hanjin.irep.erp.FNS0400001Document.FNS0400001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0400001Document.FNS0400001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.ArRoutRnkVO;

public class ReceiveQueueArRoutRnkBCImpl extends BasicCommandSupport implements ReceiveQueueBC{

	private transient ReceiveQueueArRoutRnkDBDAO dbDao = null;
	
	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueArRoutRnkBCImpl() {
		dbDao = new ReceiveQueueArRoutRnkDBDAO();
	}
	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	public void ctrlBKGTB(Collection models) throws DAOException {
		ArRoutRnkVO model = null;
		int i=1;
		String eaiSts = "";
		boolean isSuccessful = false;
		
		try {
			//전체삭제
			isSuccessful = dbDao.removeallArRoutRnk();
			log.debug("\n isSuccessful="+isSuccessful);
			//전체삭제 성공시 입력
			if(isSuccessful){
				Iterator itr = models.iterator();
				while (itr.hasNext()) {
//					if(i%2==1){
//						eaiSts=(String)itr.next();
//					}else{
						model = (ArRoutRnkVO)itr.next();
			
//						if (eaiSts.equals("C") || eaiSts.equals("U")){
							dbDao.addArRoutRnk(model);
//						}
//					}
					i++;
				}
			}//if(isSuccessful){
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception " + e.toString(), e);
			throw new DAOException(e.getMessage());
		}
	}
	/**
	 * FNS0400001Document parse
	 * @param xmlObjcet
	 */
	public Collection<ArRoutRnkVO> receiveBKGTB(XmlObject xmlObject) {
		FNS0400001Document doc = (FNS0400001Document) xmlObject;
		log.debug("\n <<receiveBKGTB 1>>");
		FNS0400001 sync = doc.getFNS0400001();
		log.debug("\n <<receiveBKGTB 2>>");
		EAIHeaderType header = sync.getEAIHeader();
		log.debug("\n <<receiveBKGTB 3>>");
		String instanceId = header.getInstanceId();
		log.debug("\n <<receiveBKGTB 4>>"+instanceId);
		String eai_evnt_dt = instanceId.substring(12,26);
		log.debug("\n <<receiveBKGTB 5>>");
		
		DataArea data = sync.getDataArea();
		log.debug("\n <<receiveBKGTB 6>>");
		ROWSET rowset = data.getROWSET();
		log.debug("\n <<receiveBKGTB 7>>");
		ROW[] row = rowset.getROWArray();
		log.debug("\n <<receiveBKGTB 8>>");

		ArRoutRnkVO model = null;
		log.debug("\n <<receiveBKGTB 9>>");
		Collection<ArRoutRnkVO> models = new ArrayList<ArRoutRnkVO>();
		log.debug("\n <<receiveBKGTB 10>>");
		for (int i = 0; row != null && i < row.length; i++) {
			model = new ArRoutRnkVO();
			model.setRlaneCd   (row[i].getREVENUELANECODE());
			model.setRnkSeq    (row[i].getSEQ());
			model.setRlaneDesc (row[i].getREVENUELANENAME());
			model.setZnIocCd  (row[i].getOCEANINTERFLAG());
			model.setIocDesc   (row[i].getOCEANINTERNAME());
			model.setSlanCd    (row[i].getVESSELSERVICELANECODE());
			model.setDeltFlg   (row[i].getDELETEFLAG());
			model.setCreUsrId (row[i].getCREATEDBY());
			model.setCreDt     (row[i].getCREATIONDATE());
			model.setEaiEvntDt(eai_evnt_dt);
//			models.add( "U" );
			models.add(model);
		}
		return models;
	}

}
