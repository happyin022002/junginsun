/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_WORKPLACEImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.tableSync.jms.integration.ReceiveQueueApWorkplaceDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0520001Document;
import com.hanjin.irep.erp.FNS0520001Document.FNS0520001;
import com.hanjin.irep.erp.FNS0520001Document.FNS0520001.DataArea;
import com.hanjin.irep.erp.FNS0520001Document.FNS0520001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0520001Document.FNS0520001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.ApWorkplaceVO;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueApWorkplaceBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueApWorkplaceDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueApWorkplaceBCImpl() {
		dbDao = new ReceiveQueueApWorkplaceDBDAO();
	}

	/**
	 * FNS0520001Document parse
	 * @param xmlObjcet
	 */
	public Collection receiveBKGTB(XmlObject xmlObject) {
		
		FNS0520001Document doc = (FNS0520001Document) xmlObject;
		FNS0520001 sync = doc.getFNS0520001();
		
		EAIHeaderType header = sync.getEAIHeader();
		String instanceId = header.getInstanceId();
		String eaiEvntDt = instanceId.substring(12,26);
		
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();

		ApWorkplaceVO model = null;
		Collection models = new ArrayList();
		
		for (int i = 0; row != null && i < row.length; i++) {
			
			model = new ApWorkplaceVO();
			model.setWkplcNm   (row[i].getLOCATIONCODE());
			model.setWkplcDesc (row[i].getDESCRIPTION());
			model.setInactDt   (row[i].getINACTIVEDATE());
			model.setEaiEvntDt(eaiEvntDt);
			/* start 현재 row[i]로부터 가져올 수 없음. 추후 row[i]에서 가져오도록 수정하기!! 20091013 kys */
			//model.setCreUsrId(row[i].getCreUsrId());
			//model.setCreDt(row[i].getCreDt());
			//model.setUpdUsrId(row[i].getUpdUsrId());
			//model.setUpdDt(row[i].getUpdDt());
			model.setCreUsrId("SYSTEM");
			model.setUpdUsrId("SYSTEM");
			/* end */
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

		Iterator itr = models.iterator();
		ApWorkplaceVO model = null;

		int i=1;
		String eaiSts = "";
		
		while (itr.hasNext()) {
			if(i%2==1){
				eaiSts = (String)itr.next();
			}else{
				model = (ApWorkplaceVO)itr.next();
	
				if (eaiSts.equals("C") || eaiSts.equals("U"))
					eaiSts = "U";
	
				try {
					switch (eaiSts.charAt(0)) {
					case 'U':
						String wkplcNm = model.getWkplcNm();
						if(dbDao.searchApWorkplaceList(model.getWkplcNm())){
							if ( wkplcNm != null && wkplcNm.trim().length() > 0 ) {
								dbDao.addApWorkplace(model);
							}
						}else{
							if ( wkplcNm != null && wkplcNm.trim().length() > 0 ) {
								dbDao.modifyApWorkplace(model);
							}
						}
						break;
					case 'D':
						// 실제로는 넘어오지 않는 op_cd 임. inact_dt 칼럼으로 삭제 여부 판단. 20091105 kys
						dbDao.removeApWorkplace(model);
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