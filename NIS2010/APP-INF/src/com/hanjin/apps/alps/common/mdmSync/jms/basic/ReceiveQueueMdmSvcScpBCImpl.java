/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_SVC_SCOPEBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.EAIHeaderType;
import com.hanjin.irep.mdm.MDM0400001Document;
import com.hanjin.irep.mdm.MDM0400001Document.MDM0400001;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0400001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0400001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSvcScpBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmSvcScpDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_SVC_SCOPEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmSvcScpBCImpl() {
		dbDao = new ReceiveQueueMdmSvcScpDBDAO();
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
	public Collection receiveMDMTB(XmlObject xmlObject) {

		MdmSvcScpVO model = null;
		Collection models = new ArrayList();

		MDM0400001Document mdmDoc = (MDM0400001Document) xmlObject;
		MDM0400001 mdm = mdmDoc.getMDM0400001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0400001Document.MDM0400001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmSvcScpVO();
			
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			
			model.setSvcScpCd    (data.getSvcScpCd    ()); 
			model.setSvcScpNm    (data.getSvcScpNm    ()); 
			model.setFmcFileFlg  (data.getFmcFileFlg  ()); 
			model.setTrfPfxCd    (data.getTrfPfxCd    ()); 
			model.setTrfNo        (data.getTrfNo        ());
			model.setConfFlg      (data.getCnferFlg     ());
			model.setSvcScpBndCd(data.getSvcScpBndCd());  
			model.setCreUsrId    (data.getCreUsrId    ()); 
			model.setUpdUsrId    (data.getUpdUsrId    ()); 
			model.setCreDt        (data.getCreDt        ());
			model.setUpdDt        (data.getUpdDt        ());
			model.setDeltFlg      (data.getDeltFlg      ());
			model.setEaiEvntDt(getMsgCreDt());
			models.add(model);
		}
		return models;
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
			log.info(" (createMDM_SVC_SCP) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_SVC_SCP) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		Iterator itr = models.iterator();
		
		MdmSvcScpVO model = null; 
		String svcScpCd = null;
		
		try {
			while (itr.hasNext()) {
				
				model = (MdmSvcScpVO)itr.next();
				svcScpCd = model.getSvcScpCd();
				
				if(dbDao.searchMdmSvcScpList(svcScpCd)){
					if ( svcScpCd != null && svcScpCd.trim().length() > 0 ) {
						dbDao.addMdmSvcScp(model);
					}
				} else {
					if ( svcScpCd != null && svcScpCd.trim().length() > 0 ) {
						dbDao.modifyMdmSvcScp(model);
					}
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
		Iterator itr = models.iterator();
		
		MdmSvcScpVO model = null; 
		String svcScpCd = null;
		
		try {
			while (itr.hasNext()) {
				
				model = (MdmSvcScpVO)itr.next();
				svcScpCd = model.getSvcScpCd();
				
				if ( svcScpCd != null && svcScpCd.trim().length() > 0  
						&& !dbDao.searchMdmSvcScpList(svcScpCd)) {	
					dbDao.removeMdmSvcScp(model);
					
				}
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
