/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_TAXImpl.java
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

import com.clt.apps.opus.common.tableSync.jms.integration.ReceiveQueueApTaxDBDAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApTaxVO;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0450001Document;
import com.clt.irep.erp.FNS0450001Document.FNS0450001;
import com.clt.irep.erp.FNS0450001Document.FNS0450001.DataArea;
import com.clt.irep.erp.FNS0450001Document.FNS0450001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0450001Document.FNS0450001.DataArea.ROWSET.ROW;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueApTaxBCImpl extends BasicCommandSupport	implements ReceiveQueueBC {
	private transient ReceiveQueueApTaxDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueApTaxBCImpl() {
		dbDao = new ReceiveQueueApTaxDBDAO();
	}

	/**
	 * FNS0450001Document parse
	 * @param xmlObjcet
	 */
	public Collection receiveBKGTB(XmlObject xmlObject) {
		FNS0450001Document 	doc 	= (FNS0450001Document) xmlObject;
		FNS0450001 			sync 	= doc.getFNS0450001();
		
		EAIHeaderType 	header 		= sync.getEAIHeader();
		String 			instanceId 	= header.getInstanceId();
		String 			eai_evnt_dt = instanceId.substring(12,26);
		
		DataArea 		data 		= sync.getDataArea();
		ROWSET 			rowset 		= data.getROWSET();
		ROW[] 			row 		= rowset.getROWArray();
		ApTaxVO 		model 		= null;
		Collection 		models 		= new ArrayList();

		for (int i = 0; row != null && i < row.length; i++) {
			model = new ApTaxVO();
			model.setApTaxNm(row[i].getNAME());
			model.setTaxNo      (row[i].getTAXID());
			model.setTaxRt      (row[i].getTAXRATE());
			model.setTaxNaidFlg(row[i].getATTRIBUTE2());
			model.setFaFlg      (row[i].getATTRIBUTE3());
			model.setTaxNslFlg (row[i].getATTRIBUTE4());
			model.setAvalFlg	 (row[i].getENABLEDFLAG());
			model.setCreDt      (row[i].getCREATIONDATE());
			model.setCreUsrId  (row[i].getCREATEDBY());
			model.setUpdDt      (row[i].getLASTUPDATEDATE());
			model.setUpdUsrId  (row[i].getLASTUPDATEDBY());
			model.setEaiEvntDt (eai_evnt_dt);
			models.add(row[i].getOPCD());
			models.add(model);
		}
		return models;
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator 	itr 	= models.iterator();
		ApTaxVO 	apTaxVO = null;
		
		int i=1;
		String eaiSts = "";
		boolean succesFlag = false;
		
		while (itr.hasNext()) {
			if(i%2==1){
				eaiSts = (String)itr.next();
			}else{
				apTaxVO = (ApTaxVO)itr.next();
	
				if (eaiSts.equals("C") || eaiSts.equals("U"))
					eaiSts = "U";
	
				try {
					switch (eaiSts.charAt(0)) {
					case 'U':
						succesFlag = dbDao.searchApTaxList(apTaxVO);
						
						if(succesFlag){
							dbDao.addApTax(apTaxVO);
						}else{
							dbDao.modifyApTax(apTaxVO);
						}
						
						break;
//					case 'D':  전문 특성상 DB에서 DELETE없기 때문에 U만 존재함
//						succesFlag 	= dbDao.searchApTaxList(apTaxVO);
//						if(!succesFlag)	dbDao.removeApTax(apTaxVO);
//						
//						break;
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
