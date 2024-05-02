/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueArFincDirConvBCImpl.java
 *@FileTitle : NIS2010 Table AR FINC DIR CONV Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-11-05
 *@LastModifier : Lee, Yulkyu
 *@LastVersion : 1.1
 * 2009-09-23 Sun, Choi
 * 2015-11-05 Lee, Yulkyu(Pendulum 노선 변경으로 인한 Table Sync 변경)
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.tableSync.jms.integration.ReceiveQueueArFincDirConvDBDAO;
import com.hanjin.apps.alps.common.tableSync.jms.vo.CreateArFincDirConvVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0410001Document;
import com.hanjin.irep.erp.FNS0410001Document.FNS0410001;
import com.hanjin.irep.erp.FNS0410001Document.FNS0410001.DataArea;
import com.hanjin.irep.erp.FNS0410001Document.FNS0410001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0410001Document.FNS0410001.DataArea.ROWSET.ROW;

  
/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author Sun, Choi
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueArFincDirConvBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC { 
	private transient ReceiveQueueArFincDirConvDBDAO dbDao = null;

	/**  
	 * 생성자
	 *
	 */
	public ReceiveQueueArFincDirConvBCImpl() {
		dbDao = new ReceiveQueueArFincDirConvDBDAO();
	}

	/**
	 * FNS0410001Document parse
	 * @param xmlObjcet
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveBKGTB(XmlObject xmlObject) {
		FNS0410001Document doc = (FNS0410001Document) xmlObject;
		FNS0410001 sync = doc.getFNS0410001();
		
		EAIHeaderType header = sync.getEAIHeader();
		String instanceId = header.getInstanceId();
		String eai_evnt_dt = instanceId.substring(12,26);
		
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();
		
		CreateArFincDirConvVO model = null;
		Collection models = new ArrayList();
//		Collection<CreateArFincDirConvVO> models = new ArrayList<CreateArFincDirConvVO>();

		for (int i = 0; row != null && i < row.length; i++) {
			model = new CreateArFincDirConvVO();
			model.setSlanCd(row[i].getVESSELSERVICELANECODE());
			model.setScontiCd   (row[i].getSUBCONTI());
			model.setSlanDirCd (row[i].getSERVICELANEDIR());
			model.setRlaneDirCd(row[i].getREVENUELANEDIR());
			model.setDirCngCd  (row[i].getDIRECTIONCHANGE());
			model.setDeltFlg    (row[i].getDELETEFLAG());
			
			// 2015.10.23 newly added(Pendulum lane changed) - start
			model.setPodConti    (row[i].getPODCONTI());
			model.setPodRevLaneDir    (row[i].getPODREVLANEDIR());
			model.setPodRevLane    (row[i].getPODREVLANE());
			// 2015.10.23 newly added(Pendulum lane changed) - end
			
//			model.setUpdUsrId (row[i].getUPDUSRID());
//			model.setCreDt (row[i].getCREDT());
//			model.setUpdDt (row[i].getUPTDT());
			model.setEaiEvntDt (eai_evnt_dt);
			model.setApMk(row[i].getAPMARK());
			model.setUpdUsrId("System");
			model.setRlaneCd(row[i].getATTRIBUTE2());//20090720 Lee Ho Jin R200907010002:Revenue Direction Interface 정보추가
			models.add("U");
			models.add(model);
//			log.info("receiveBKGTB_row[i].getDELETEFLAG()================>"+row[i].getDELETEFLAG());
//			log.info("receiveBKGTB_model.getDeltFlg()================>"+model.getDeltFlg());
//			log.info("receiveBKGTB_models================>"+models);
//			log.info("receiveBKGTB_model================>"+model);
		}
		return models;
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	@SuppressWarnings("unchecked")
	public void ctrlBKGTB(Collection models) throws DAOException{	
		CreateArFincDirConvVO model = null;
		int i=1;
		String eaiSts = "";
		boolean isSuccessful = false;
			
		try {
			//전체삭제 (removeArFincDirConv, removeAllArFincDirConv)
			isSuccessful = dbDao.removeAllArFincDirConv();
//			log.info("ctrlBKGTB_isSuccessful================>"+isSuccessful);
			//전체삭제 성공시 입력
			if(isSuccessful){
				Iterator itr = models.iterator();
				while (itr.hasNext()) {
					if(i%2==1){
						eaiSts = (String)itr.next();
					}else{
						model = (CreateArFincDirConvVO)itr.next();
//						log.info("Create_ctrlBKGTB_model================>"+model);
//						log.info("Create_ctrlBKGTB_eaiSts================>"+eaiSts);
						if (eaiSts.equals("C") || eaiSts.equals("U")){
							dbDao.addArFincDirConv(model);
						}
					}
					i++;
				}
			}//if(isSuccessful){
			log.info("ctrlBKGTB_END");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception " + e.toString(), e);
			throw new DAOException(e.getMessage());
		}
	}
		
}
