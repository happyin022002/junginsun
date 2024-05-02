/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmPckTpBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmPckTpDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0440001Document;
import com.hanjin.irep.mdm.MDM0440001Document.MDM0440001;
import com.hanjin.syscommon.common.table.MdmPckTpVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0440001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0440001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmPckTpBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmPckTpDBDAO dbDao = null;

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

	/** ReceiveQueueMdmPckTpBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmPckTpBCImpl() {
		dbDao = new ReceiveQueueMdmPckTpDBDAO();
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

		MdmPckTpVO model = null;
		Collection models = new ArrayList();
		
		MDM0440001Document mdmDoc = (MDM0440001Document) xmlObject;
		MDM0440001 mdm = mdmDoc.getMDM0440001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0440001Document.MDM0440001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			
			model = new MdmPckTpVO();
			
			model.setPckCd	    (data.getPckCd   ());
			model.setPckNm     	(data.getPckNm   ());
			model.setCreUsrId 	(data.getCreUsrId());
			model.setCreDt     	(data.getCreDt   ());
			model.setUpdUsrId 	(data.getUpdUsrId());
			model.setUpdDt     	(data.getUpdDt   ());
			model.setDeltFlg   	(data.getDeltFlg ());
			model.setEaiEvntDt	(getMsgCreDt());
			model.setEaiIfId	(mdm.getEAIHeader().getInstanceId());
			
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
			log.info(" (createMdmPckTp) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmPckTp) isSucessFlag : "
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
		
		MdmPckTpVO model = null;
		String pckCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmPckTpVO)itr.next();
				pckCd = model.getPckCd();
	
				if(dbDao.searchMdmPckTpList(pckCd)){
					if ( pckCd !=null && pckCd.trim().length() > 0 ) {
						dbDao.addMdmPckTpInsert(model);
					}	
				}	
				else {
					if( pckCd !=null && pckCd.trim().length() > 0 ){
						dbDao.addMdmPckTpUpdate(model);
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
		
		MdmPckTpVO model = null;
		String pckCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmPckTpVO)itr.next();
				pckCd = model.getPckCd();
				
				if ( pckCd !=null && pckCd.trim().length() > 0 
						&& !dbDao.searchMdmPckTpList(pckCd)) {	
					dbDao.removeMdmPckTp(model);
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
