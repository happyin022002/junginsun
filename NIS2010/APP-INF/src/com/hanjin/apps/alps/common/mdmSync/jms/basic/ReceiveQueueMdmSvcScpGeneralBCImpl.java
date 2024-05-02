/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmSvcScopeTotalBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpGeneralDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;

import com.hanjin.irep.mdm.MDM0560001Document;
import com.hanjin.irep.mdm.MDM0560001Document.MDM0560001;
import com.hanjin.irep.mdm.MDM0560001Document.MDM0560001.DataArea.ScpLane;
import com.hanjin.irep.mdm.MDM0560001Document.MDM0560001.DataArea.ScpLmt;
import com.hanjin.irep.mdm.MDM0560001Document.MDM0560001.DataArea.ScpLane.ScpLaneIns;
import com.hanjin.irep.mdm.MDM0560001Document.MDM0560001.DataArea.ScpLmt.ScpLmtIns;
import com.hanjin.syscommon.common.table.MdmSvcScpLaneVO;
import com.hanjin.syscommon.common.table.MdmSvcScpLmtVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0560001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0560001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSvcScpGeneralBCImpl extends BasicCommandSupport implements ReceiveQueueBC {

	private transient ReceiveQueueMdmSvcScpGeneralDBDAO dbDao = null;

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

	/** ReceiveQueueMdmSvcScopeTotalBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmSvcScpGeneralBCImpl() {
		dbDao = new ReceiveQueueMdmSvcScpGeneralDBDAO();
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
		MdmSvcScpLaneVO model2 = null;
		MdmSvcScpLmtVO model3 = null;
		
		Collection models = new ArrayList();
		Collection models2 = new ArrayList();
		Collection models3 = new ArrayList();

		MDM0560001Document mdmDoc = (MDM0560001Document) xmlObject;
		MDM0560001 mdm = mdmDoc.getMDM0560001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0560001Document.MDM0560001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmSvcScpVO();
			model.setSvcScpCd    (data.getSvcScpCd   ());
			model.setSvcScpNm    (data.getSvcScpNm   ());
			model.setFmcFileFlg  (data.getFmcFileFlg ());
			model.setTrfPfxCd    (data.getTrfPfxCd   ());
			model.setTrfNo        (data.getTrfNo      ());
			model.setConfFlg    (data.getCnferFlg   ());
			model.setSvcScpBndCd(data.getSvcScpBndCd());
			model.setCreUsrId    (data.getCreUsrId   ());
			model.setCreDt        (data.getCreDt      ());
			model.setUpdUsrId    (data.getUpdUsrId   ());
			model.setUpdDt        (data.getUpdDt      ());
			model.setDeltFlg      (data.getDeltFlg    ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			models.add(model);
log.info("\n MdmSvcScpVO----------------------------------------------------------------------------");
log.info("getSvcScpCd=" + model.getSvcScpCd());
log.info("getSvcScpNm=" + model.getSvcScpNm());
log.info("getFmcFileFlg=" + model.getFmcFileFlg());
log.info("getTrfPfxCd=" + model.getTrfPfxCd());
log.info("getTrfNo=" + model.getTrfNo());
log.info("getConfFlg=" + model.getConfFlg());
log.info("getSvcScpBndCd=" + model.getSvcScpBndCd());
log.info("getCreUsrId=" + model.getCreUsrId());
log.info("getCreDt=" + model.getCreDt());
log.info("getUpdUsrId=" + model.getUpdUsrId());
log.info("getUpdDt=" + model.getUpdDt());
log.info("getDeltFlg=" + model.getDeltFlg());
log.info("getEaiEvntDt=" + model.getEaiEvntDt());
log.info("getEaiIfNo=" + model.getEaiIfId());

log.info("----------------------------------------------------------------------------");
			ScpLane scpLane = data.getScpLane();
			ScpLaneIns[] scpLaneIns = scpLane.getScpLaneInsArray();
			for(int i=0; i<scpLaneIns.length; i++){
				model2 = new MdmSvcScpLaneVO();
				model2.setSvcScpLaneSeq(scpLaneIns[i].getSvcScpLaneSeq());
				model2.setSvcScpCd(data.getSvcScpCd());
				model2.setVslSlanCd(scpLaneIns[i].getVslSlanCd());
				model2.setCreUsrId    (data.getCreUsrId   ());
				model2.setCreDt        (data.getCreDt      ());
				model2.setUpdUsrId    (data.getUpdUsrId   ());
				model2.setUpdDt        (data.getUpdDt      ());
				model2.setDeltFlg      (data.getDeltFlg    ());
				model2.setEaiEvntDt(getMsgCreDt());
				model2.setEaiIfId(mdm.getEAIHeader().getInstanceId());
				models2.add(model2);
				
log.debug("\nMdmSvcScpLaneVO----------------------------------------------------------------------------");
log.debug("getSvcScpCd=" + model2.getSvcScpCd());
log.debug("getVslSlanCd=" + model2.getVslSlanCd());
log.debug("getCreUsrId=" + model2.getCreUsrId());
log.debug("getCreDt=" + model2.getCreDt());
log.debug("getUpdUsrId=" + model2.getUpdUsrId());
log.debug("getUpdDt=" + model2.getUpdDt());
log.debug("getDeltFlg=" + model2.getDeltFlg());
log.debug("getEaiEvntDt=" + model2.getEaiEvntDt());
log.debug("getEaiIfNo=" + model2.getEaiIfId());
log.debug("----------------------------------------------------------------------------");
				
			}
			models.add(models2);
			
			ScpLmt scpLmt = data.getScpLmt();
			ScpLmtIns[] scpLmtIns = scpLmt.getScpLmtInsArray();
			for(int j=0; j<scpLmtIns.length;j++){
				model3 = new MdmSvcScpLmtVO();
				model3.setSvcScpLmtSeq(scpLmtIns[j].getSvcScpLmtSeq());
				model3.setSvcScpCd(data.getSvcScpCd());
				model3.setRgnCd(scpLmtIns[j].getRgnCd());
				model3.setOrgDestCd(scpLmtIns[j].getOrgDestCd());
				model3.setSvcScpIndFlg(scpLmtIns[j].getSvcScpIndFlg());
				model3.setCreUsrId    (data.getCreUsrId   ());
				model3.setCreDt        (data.getCreDt      ());
				model3.setUpdUsrId    (data.getUpdUsrId   ());
				model3.setUpdDt        (data.getUpdDt      ());
				model3.setDeltFlg      (data.getDeltFlg    ());
				model3.setEaiEvntDt(getMsgCreDt());
				model3.setEaiIfId(mdm.getEAIHeader().getInstanceId());
				models3.add(model3);
	log.debug("\nMdmSvcScpLmtVO----------------------------------------------------------------------------");
	log.debug("getSvcScpCd=" + model3.getSvcScpCd());
	log.debug("getRgnCd=" + model3.getRgnCd());
	log.debug("getCreUsrId=" + model3.getCreUsrId());
	log.debug("getCreDt=" + model3.getCreDt());
	log.debug("getUpdUsrId=" + model3.getUpdUsrId());
	log.debug("getUpdDt=" + model3.getUpdDt());
	log.debug("getDeltFlg=" + model3.getDeltFlg());
	log.debug("getEaiEvntDt=" + model3.getEaiEvntDt());
	log.debug("getEaiIfNo=" + model3.getEaiIfId());
	log.debug("----------------------------------------------------------------------------");
			}
			models.add(models3);
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
			log.info(" (createMdmSvcScpGeneral) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (deleteMdmSvcScpGeneral) isSucessFlag : "
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
		Iterator iter = models.iterator();
		//mdm_svc_scp, mdm_svc_scp_lane,mdm_svc_scp_lmt
		MdmSvcScpVO vo1 = null;
		Collection vos2 = new ArrayList();
		Collection vos3 = new ArrayList();		
		try {
			while(iter.hasNext()) {
				vo1 = (MdmSvcScpVO) iter.next();
				
				log.info("getSvcScpCd=" + vo1.getSvcScpCd());
				
				vos2 = (ArrayList<MdmSvcScpLaneVO>) iter.next();
				vos3 = (ArrayList<MdmSvcScpLmtVO>) iter.next();
				isSuccessful = dbDao.addMdmSvcScopeTotal(vo1, vos2, vos3 );
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
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		Iterator iter = models.iterator();
		//mdm_svc_scp, mdm_svc_scp_lane,mdm_svc_scp_lmt
		MdmSvcScpVO vo1 = null;
		Collection vos2 = new ArrayList();
		Collection vos3 = new ArrayList();	
		try {
			while(iter.hasNext()) {

				log.info("getSvcScpCd=" + vo1.getSvcScpCd());
				
				vo1 = (MdmSvcScpVO) iter.next();
				
				log.info("getSvcScpCd=" + vo1.getSvcScpCd());
				
				vos2 = (ArrayList<MdmSvcScpLaneVO>) iter.next();
				vos3 = (ArrayList<MdmSvcScpLmtVO>) iter.next();
				dbDao.removeMdmSvcScopeTotal(vo1, vos2, vos3 );
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
