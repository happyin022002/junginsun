/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmMvmtStsBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmMvmtStsDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0490001Document;
import com.hanjin.irep.mdm.MDM0490001Document.MDM0490001;
import com.hanjin.syscommon.common.table.MdmMvmtStsVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmMvmtStsBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmMvmtStsDBDAO dbDao = null;

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

	/** ReceiveQueueMdmMvmtStsBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmMvmtStsBCImpl() {
		dbDao = new ReceiveQueueMdmMvmtStsDBDAO();
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

		MdmMvmtStsVO model = null;
		Collection models = new ArrayList();

		MDM0490001Document mdmDoc = (MDM0490001Document) xmlObject;
		MDM0490001 mdm = mdmDoc.getMDM0490001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0490001Document.MDM0490001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			
			model = new MdmMvmtStsVO();
			model.setMvmtStsCd	(data.getMvmtStsCd()); 
			model.setMvmtStsNm	(data.getMvmtStsNm()); 
			model.setDestYdFlg	(data.getDestYdFlg()); 
			model.setIoBndCd	(data.getIoBndCd  ()); 
			model.setCreUsrId	(data.getCreUsrId ()); 
			model.setCreDt		(data.getCreDt    ()); 
			model.setUpdUsrId   (data.getUpdUsrId ()); 
			model.setUpdDt      (data.getUpdDt    ());
			model.setDeltFlg    (data.getDeltFlg  ());
			model.setEaiEvntDt  (getMsgCreDt());
			model.setEaiIfId	( mdm.getEAIHeader().getInstanceId());
			
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
			log.info(" (createMdmMvmtSts) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmMvmtSts) isSucessFlag : "
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
		
		MdmMvmtStsVO model 	= null;
		String mvmtStsCd 	= null;
		
		try {
			while (itr.hasNext()) {
				
				model = (MdmMvmtStsVO)itr.next();
				mvmtStsCd = model.getMvmtStsCd();
		
				log.info("mvmt_sts_cd : " + mvmtStsCd);
			
				if(dbDao.searchMdmMvmtStsList(mvmtStsCd)){
					if ( mvmtStsCd !=null && mvmtStsCd.trim().length() > 0 ) {				
						dbDao.addMdmMvmtStsInsert(model);
					}
				}else{
					if ( mvmtStsCd !=null && mvmtStsCd.trim().length() > 0){
						dbDao.addMdmMvmtStsUpdate(model);
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
		
		MdmMvmtStsVO model = null;
		String mvmtStsCd 	= null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmMvmtStsVO)itr.next();
				mvmtStsCd = model.getMvmtStsCd();
				
				if ( mvmtStsCd !=null && mvmtStsCd.trim().length() > 0 
						&& !dbDao.searchMdmMvmtStsList(mvmtStsCd)) {
					dbDao.removeMdmMvmtSts(model);
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
