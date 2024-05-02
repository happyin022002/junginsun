/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmStateBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2010.06.28 CHOI.Y.S - TicketID : CHM-201004307, CHM-201004304, CHM-201004306
 * - EAI_IF_ID 필드 관련 내역 추가
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmStateDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0450001Document;
import com.hanjin.irep.mdm.MDM0450001Document.MDM0450001;
import com.hanjin.syscommon.common.table.MdmStateVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0450001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0450001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmStateBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmStateDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

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

	/** ReceiveQueueMDM_STATEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmStateBCImpl() {
		dbDao = new ReceiveQueueMdmStateDBDAO();
	}

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

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveMDMTB(XmlObject xmlObject) {

		MdmStateVO model = null;
		Collection models = new ArrayList();

		MDM0450001Document mdmDoc = (MDM0450001Document) xmlObject;
		MDM0450001 mdm = mdmDoc.getMDM0450001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());
		
		com.hanjin.irep.mdm.MDM0450001Document.MDM0450001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmStateVO();
			model.setCntCd(data.getCntCd    ());
			model.setSteCd(data.getSteCd    ());
			model.setSteNm(data.getSteNm    ());
			model.setCreUsrId(data.getCreUsrId()); 
			model.setCreDt(data.getCreDt   ()); 
			model.setUpdUsrId(data.getUpdUsrId()); 
			model.setUpdDt(data.getUpdDt    ());
			model.setDeltFlg(data.getDeltFlg  ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			models.add(model);
		}
		return models;
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
			log.info(" (createMDM_STATE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_STATE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMdmState, modifyMdmState 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		List insModels = new ArrayList();
		List updModels = new ArrayList();
		boolean isInsert = false;
		boolean isUpdate = false;
		boolean isInsChk = true;
		boolean isUpdChk = true;
		
		try {
			Iterator itr = models.iterator();
			
			MdmStateVO model = null; 
			String cntCd     = null;
			String steCd     = null;
			
			while (itr.hasNext()) {
				model = (MdmStateVO)itr.next();
				cntCd = model.getCntCd();
				steCd = model.getSteCd();
				
				if(dbDao.searchMdmStateList(cntCd, steCd)) {
					if ( cntCd != null && cntCd.trim().length() > 0 && steCd != null && steCd.trim().length() > 0 ) {
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						insModels.add(param);
						isInsert = true;
					}
				} else {
					if ( cntCd != null && cntCd.trim().length() > 0 && steCd != null && steCd.trim().length() > 0 ) {
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						updModels.add(param);
						isUpdate = true;
					}
				}
			}
			
			if(isInsert){
				isInsChk = dbDao.addMdmState(insModels);
			}
			if(isUpdate){
				isUpdChk = dbDao.modifyMdmState(updModels);
			}
			
			if(isInsChk && isUpdChk){
				isSuccessful = true;
			}
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
			
			MdmStateVO model = null; 
			String cntCd     = null;
			String steCd     = null;
			
			while (itr.hasNext()) {
				model = (MdmStateVO)itr.next();
				cntCd = model.getCntCd();
				steCd = model.getSteCd();
				
				if (    cntCd != null && cntCd.trim().length() > 0
					 && steCd != null && steCd.trim().length() > 0 
					 && !dbDao.searchMdmStateList(cntCd, steCd)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(model.getColumnValues());
					delModels.add(param);
					isDelete = true;
				}
			}
			
			if(isDelete){
				isSuccessful = dbDao.removeMdmState(delModels);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		/*boolean isSuccessful = false;

		try {
			isSuccessful = dbDao.removeMdmState(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;*/
	}
}
