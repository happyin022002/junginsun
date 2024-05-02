/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVslSvcLaneGeneralBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVslSvcLaneDirDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVslSvcLaneGeneralDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0070001Document;
import com.hanjin.irep.mdm.MDM0070001Document.MDM0070001;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0070001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0070001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVslSvcLaneGeneralBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmVslSvcLaneGeneralDBDAO dbDao = null;
	private transient ReceiveQueueMdmVslSvcLaneDirDBDAO dirDbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
	}

	/** opCd setter 메서드.<br>
	 * @param opCd String
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}

	/** MsgCreDt getter 메서드.<br>
	 */
	public String getMsgCreDt() {
		return msgCreDt;
	}
	
	/** MsgCreDt setter 메서드.<br>
	 * @param msgCreDt String
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}	
	
	/** ReceiveQueueMdmVslSvcLaneGeneralBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVslSvcLaneGeneralBCImpl() {
		dbDao = new ReceiveQueueMdmVslSvcLaneGeneralDBDAO();
		dirDbDao = new ReceiveQueueMdmVslSvcLaneDirDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		
		MdmVslSvcLaneVO model = null;
		MdmVslSvcLaneDirVO model2 = null;
		Collection models = new ArrayList();
		Collection temp = new ArrayList();

		MDM0070001Document mdmDoc = (MDM0070001Document) xmlObject;
		MDM0070001 mdm = mdmDoc.getMDM0070001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models		// =====
		com.hanjin.irep.mdm.MDM0070001Document.MDM0070001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			model = new MdmVslSvcLaneVO();
			
			model.setVslSlanCd		   	(data.getVslSlanCd     ());
			model.setVslSlanNm       	(data.getVslSlanNm     ());
			model.setVslSvcTpCd     	(data.getVslSvcTpCd    ());
			model.setStEffDt         	(data.getStrtEffDt     ());
			model.setEndEffDt        	(data.getEndEffDt      ());
			model.setVslSlanSkdTpCd	(data.getVslSlanSkdTpCd());
			model.setOfcCd            	(data.getOfcCd         ());
			model.setCoCd             	(data.getCoCd          ());
			model.setVslTpCd         	(data.getVslTpCd       ());
			model.setFdrDivCd        	(data.getFdrDivCd      ());
			model.setCreUsrId        	(data.getCreUsrId      ());
			model.setCreDt            	(data.getCreDt         ());
			model.setUpdUsrId        	(data.getUpdUsrId      ());
			model.setUpdDt            	(data.getUpdDt         ());
			model.setDeltFlg          	(data.getDeltFlg       ());
			model.setEaiEvntDt	   		(getMsgCreDt		   ());	
			model.setEaiIfId			(mdm.getEAIHeader().getInstanceId());	
			
			temp.add(model);
			
			model2 = new MdmVslSvcLaneDirVO();
			
			model2.setVslSlanCd     	(data.getDetVslSlanCd    ());
			model2.setVslSlanDirCd 		(data.getDetDirCd        ());
			model2.setVslSlanDirSeq		(data.getDetVslSlanDirSeq());
			model2.setCreUsrId      	(data.getDetCreUsrId     ());
			model2.setCreDt          	(data.getDetCreDt        ());
			model2.setUpdUsrId      	(data.getDetUpdUsrId     ());
			model2.setUpdDt          	(data.getDetUpdDt        ());
			model2.setDeltFlg        	(data.getDetDeltFlg      ());
			model2.setEaiEvntDt	  		(getMsgCreDt			 ());	
			model2.setEaiIfId	  		(mdm.getEAIHeader().getInstanceId());	
			
			temp.add(model2);
			
			models.add(temp);
		} 
		
		return models;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		
		boolean isSuccessful = false;
		
		MdmVslSvcLaneVO model = null;
		MdmVslSvcLaneDirVO modelDir = null;
		String vslSlanCd = null;
		String vslSlanCd2 = null;
		String vslSlanDirCd = null;
		
		Iterator itr_t = models.iterator();
		
		try {
			while(itr_t.hasNext()){
				ArrayList temp = (ArrayList)itr_t.next();
				Iterator itr = temp.iterator();
				int k=1;
				
				while (itr.hasNext()) {
					if(k%2==1){
						model = (MdmVslSvcLaneVO)itr.next();
						vslSlanCd = model.getVslSlanCd();
						if(dbDao.searchMdmVslSvcLaneList(vslSlanCd)){
							if ( vslSlanCd != null && vslSlanCd.trim().length() > 0 ) {
								dbDao.addMdmVslSvcLaneInsert(model);	
							}
						}	
						else{
							if ( vslSlanCd != null && vslSlanCd.trim().length() > 0 ) {
								dbDao.addMdmVslSvcLaneUpdate(model);	
							}
						}
					}
					else{	
						modelDir = (MdmVslSvcLaneDirVO)itr.next();
						vslSlanCd2 = modelDir.getVslSlanCd();
						vslSlanDirCd = modelDir.getVslSlanDirCd();
			
						log.info("vslSlanCd2 : " + vslSlanCd2);
					
						if(dirDbDao.searchMdmVslSvcLAneDirList(vslSlanCd2, vslSlanDirCd)){
							if ( vslSlanCd2 != null && vslSlanCd2.trim().length() > 0 && 
									vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0) {
								dirDbDao.addMdmVslSvcLaneDirInsert(modelDir);
							}
						}	
						else{
							if ( vslSlanCd2 != null && vslSlanCd2.trim().length() > 0 && 
									vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0) {
								dirDbDao.addMdmVslSvcLaneDirUpdate(modelDir);
							}
						}
					}	
					k++;
				}
			}
			isSuccessful = true;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		
		boolean isSuccessful = false;
		
		MdmVslSvcLaneVO model = null;
		MdmVslSvcLaneDirVO modelDir = null;
		String vslSlanCd = null;
		String vslSlanCd2 = null;
		String vslSlanDirCd = null;
		
		Iterator itr_t = models.iterator();
		
		try {
			while(itr_t.hasNext()){
				ArrayList temp = (ArrayList)itr_t.next();
				Iterator itr = temp.iterator();
				int k=1;
				
				while (itr.hasNext()) {
					if(k%2==1){
						model = (MdmVslSvcLaneVO)itr.next();
						vslSlanCd = model.getVslSlanCd();
						if ( vslSlanCd !=null && vslSlanCd.trim().length() > 0 
								&& !dbDao.searchMdmVslSvcLaneList(vslSlanCd)) {	
							dbDao.removeMdmVslSvcLane(model);
						}
					}
					else{	
						modelDir = (MdmVslSvcLaneDirVO)itr.next();
						vslSlanCd2 = modelDir.getVslSlanCd();
						vslSlanDirCd = modelDir.getVslSlanDirCd();
			
						if ( vslSlanCd2 !=null && vslSlanCd2.trim().length() > 0 
								&& vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0
								&& !dirDbDao.searchMdmVslSvcLAneDirList(vslSlanCd2, vslSlanDirCd)) {	
							dirDbDao.removeMdmVslSvcLaneDir(modelDir);
						}
					}	
					k++;
				}
			}
			isSuccessful = true;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		
	}

	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMdmVslSvcLane, createMdmVslSvcLaneDir) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmVslSvcLane,removeMdmVslSvcLaneDir) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

}
