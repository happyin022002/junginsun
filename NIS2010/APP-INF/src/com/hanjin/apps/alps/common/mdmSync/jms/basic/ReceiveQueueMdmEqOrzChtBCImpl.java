/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_EQ_ORZ_CHTBCImpl.java
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmEqOrzChtDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0370001Document;
import com.hanjin.irep.mdm.MDM0370001Document.MDM0370001;
import com.hanjin.syscommon.common.table.MdmEqOrzChtVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0370001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0370001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmEqOrzChtBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmEqOrzChtDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_EQ_ORZ_CHTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmEqOrzChtBCImpl() {
		dbDao = new ReceiveQueueMdmEqOrzChtDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveMDMTB(XmlObject xmlObject) {
		MdmEqOrzChtVO model = null;
		Collection models = new ArrayList();

		MDM0370001Document mdmDoc = (MDM0370001Document) xmlObject;
		MDM0370001 mdm = mdmDoc.getMDM0370001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models
		// =====
		com.hanjin.irep.mdm.MDM0370001Document.MDM0370001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmEqOrzChtVO();
			model.setSccCd(data.getSccCd());
			model.setEccCd(data.getEccCd());
			model.setLccCd(data.getLccCd());
			model.setRccCd(data.getRccCd());
			model.setDeltFlg(data.getDeltFlg());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			models.add(model);
		}
		return models;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		List insModels = new ArrayList();
		List uptModels = new ArrayList();
		boolean isInsert = false;
		boolean isUpdate = false;
		try {
			Iterator itr = models.iterator();
			
			MdmEqOrzChtVO model = null;
			String scc_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmEqOrzChtVO)itr.next();
				scc_cd = model.getSccCd();
	
				log.info("scc_cd : " + scc_cd);
			
				if(dbDao.searchMdmEqOrzChtList(scc_cd)){
					if ( scc_cd != null && scc_cd.trim().length() > 0 ) {
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						insModels.add(param);
						isInsert = true;
					}
				}else{
					if ( scc_cd !=null && scc_cd.trim().length() > 0 ){
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						uptModels.add(param);
						isUpdate = true;
					}
				}
			}
			if(isInsert){
				dbDao.addMdmEqOrzCht(insModels);
			}
			if(isUpdate){
				dbDao.addMdmEqOrzChtEtc(uptModels);
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
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		List delModels = new ArrayList();
		boolean isDelete = false;
		try {
			
			Iterator itr = models.iterator();
			
			MdmEqOrzChtVO model = null;
			
			String scc_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmEqOrzChtVO)itr.next();
				
				scc_cd = model.getSccCd();
				log.info("scc_cd : " + scc_cd);			
				
				if ( scc_cd !=null && scc_cd.trim().length() > 0 
						&& !dbDao.searchMdmEqOrzChtList(scc_cd)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(model.getColumnValues());
					delModels.add(param);
					isDelete = true;
				}
			}
			if(isDelete){
				dbDao.removeMdmEqOrzCht(delModels);
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
	@SuppressWarnings("unchecked")
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDM_EQ_ORZ_CHT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_EQ_ORZ_CHT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
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
}
