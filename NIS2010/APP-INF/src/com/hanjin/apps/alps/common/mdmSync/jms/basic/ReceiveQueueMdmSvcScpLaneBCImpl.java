/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_SVC_SCOPE_LANEBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-24 ALPS FW 반영 
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpLaneDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0410001Document;
import com.hanjin.irep.mdm.MDM0410001Document.MDM0410001;
import com.hanjin.syscommon.common.table.MdmSvcScpLaneVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br>
 * - ENIS-MDM0410001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0410001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSvcScpLaneBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmSvcScpLaneDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/**
	 * MsgCreDt getter 메서드.<br>
	 */
	public String getMsgCreDt() {
		return msgCreDt;
	}

	/**
	 * MsgCreDt setter 메서드.<br>
	 * 
	 * @param msgCreDt
	 *            String
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}

	/**
	 * ReceiveQueueMDM_SVC_SCOPE_LANEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmSvcScpLaneBCImpl() {
		dbDao = new ReceiveQueueMdmSvcScpLaneDBDAO();
	}

	/**
	 * opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
	}

	/**
	 * opCd setter 메서드.<br>
	 * 
	 * @param opCd
	 *            String
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}

	/**
	 * MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장
	 * 
	 * @param xmlObject
	 *            XmlObject
	 * @throws
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {

		MdmSvcScpLaneVO model = null;
		Collection models = new ArrayList();

		MDM0410001Document mdmDoc = (MDM0410001Document) xmlObject;
		MDM0410001 mdm = mdmDoc.getMDM0410001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		log.info("==============================");
		log.info("model.setEaiIfId : " + mdm.getEAIHeader().getInstanceId());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0410001Document.MDM0410001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmSvcScpLaneVO();
			model.setSvcScpCd(data.getSvcScpCd());
			model.setVslSlanCd(data.getVslSlanCd());
			model.setCreUsrId(data.getCreUsrId());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setSvcScpLaneSeq(data.getSvcScpLaneSeq());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			log.info("model.setEaiIfId : " + model.getEaiIfId());
			models.add(model);
		}
		
		log.info("==============================");
		return models;
	}

	/**
	 * OpCd 값(flag)에 따라 메소드 호출
	 * 
	 * @param models
	 *            Collection
	 * @throws
	 */
	public void ctrlMDMTB(Collection models) throws DAOException {
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMdmSvcScpLane) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmSvcScpLane) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/**
	 * DBDAO의 addMDMACCOUNT메소드 호출
	 * 
	 * @param models
	 *            Collection
	 * @throws
	 */
	public boolean createMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		Iterator iter = models.iterator();

		MdmSvcScpLaneVO model = null;
		String svcScpCd = null;
		String vslSlanCd = null;
		String svcScpLaneSeq = null;

		try {
			while (iter.hasNext()) {

				model = (MdmSvcScpLaneVO) iter.next();
				svcScpCd = model.getSvcScpCd();
				vslSlanCd = model.getVslSlanCd();
				svcScpLaneSeq = model.getSvcScpLaneSeq();
				log.debug("\nsvcScpCd =  " + svcScpCd);
				log.debug("\nvslSlanCd =  " + vslSlanCd);
				log.debug("\nsvcScpLaneSeq =  " + svcScpLaneSeq);
				if (dbDao.searchMdmSvcScpLaneList(svcScpCd, vslSlanCd)) {
					if (svcScpCd != null && svcScpCd.trim().length() > 0
						&& vslSlanCd != null && vslSlanCd.trim().length() > 0
						&& svcScpLaneSeq != null && svcScpLaneSeq.trim().length() > 0) {
						dbDao.addMdmSvcScpLane(model);
					}
				} else {
					if (svcScpCd != null && svcScpCd.trim().length() > 0
						&& vslSlanCd != null && vslSlanCd.trim().length() > 0
						&& svcScpLaneSeq != null && svcScpLaneSeq.trim().length() > 0) {
						dbDao.modifyMdmSvcScpLane(model);
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

	/**
	 * DBDAO의 removeMDMACCOUNT메소드 호출
	 * 
	 * @param models
	 *            Collection
	 * @throws
	 */
	public boolean removeMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		Iterator iter = models.iterator();

		MdmSvcScpLaneVO model = null;
		String svcScpCd = null;
		String vslSlanCd = null;
		String svcScpLaneSeq = null;

		try {
			while (iter.hasNext()) {

				model = (MdmSvcScpLaneVO) iter.next();
				svcScpCd = model.getSvcScpCd();
				vslSlanCd = model.getVslSlanCd();
				svcScpLaneSeq = model.getSvcScpLaneSeq();

				if (svcScpCd != null && svcScpCd.trim().length() > 0
					&& vslSlanCd != null && vslSlanCd.trim().length() > 0
					&& svcScpLaneSeq != null && svcScpLaneSeq.trim().length() > 0
					&& !dbDao.searchMdmSvcScpLaneList(svcScpCd, vslSlanCd )) {
					
					log.info("removeMDMTB:"+model.getEaiIfId());
					dbDao.removeMdmSvcScpLane(model);
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
