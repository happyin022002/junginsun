/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ReceiveQueueMdmCustRepBCImpl.java
 *@FileTitle : NIS2010 MDM CUSTOMER REPRESENTATIVE Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-05-14
 *@LastModifier : You Mok Lee
 *@LastVersion : 1.1
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCustRepDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmCustRepVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0630001Document;
import com.hanjin.irep.mdm.MDM0630001Document.MDM0630001;

/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0630001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author You Mok Lee
 * @see ReceiveQueueBC,MDM0630001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustRepBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCustRepDBDAO dbDao = null;

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
	
	/** ReceiveQueueMDM_CREDIT_CUSTOMERBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCustRepBCImpl() {
		dbDao = new ReceiveQueueMdmCustRepDBDAO();
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
	public Collection<CreateMdmCustRepVO> receiveMDMTB(XmlObject xmlObject) {

		CreateMdmCustRepVO model = null;
		Collection<CreateMdmCustRepVO> models = new ArrayList<CreateMdmCustRepVO>();

		MDM0630001Document mdmDoc = (MDM0630001Document) xmlObject;
		MDM0630001 mdm = mdmDoc.getMDM0630001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0630001Document.MDM0630001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new CreateMdmCustRepVO();
			
			model.setCustCntCd       	(data.getCustCntCd          ()); 
			model.setCustSeq       		(data.getCustSeq          	()); 
			model.setOfcCd       		(data.getOfcCd          	()); 
			model.setIoBndCd       		(data.getIoBndCd          	()); 
			model.setAutoInvFlg       	(data.getAutoInvFlg         ()); 
			model.setHjsCustSvcPicTpCd  (data.getHjsCustSvcPicTpCd  ()); 
			model.setHjsRefNo       	(data.getHjsRefNo          	()); 
			model.setCustRefNoFlg       (data.getCustRefNoFlg       ()); 
			model.setLoclChgFlg       	(data.getLoclChgFlg         ()); 
			model.setHjsRefEml       	(data.getAutoInvEml          ()); 
			model.setDeltFlg       		(data.getDeltFlg          	()); 
			model.setEaiEvntDt			(getMsgCreDt				());
			model.setEaiIfId			(mdm.getEAIHeader().getInstanceId());
			model.setCreUsrId       	(data.getCreUsrId          	()); 
			model.setCreDt       		(data.getCreDt          	()); 
			model.setUpdUsrId       	(data.getUpdUsrId          	()); 
			model.setUpdDt       		(data.getUpdDt          	()); 
			model.setAutoInvEml       	(data.getAutoInvEml         ()); 

			models.add(model);
			log.info("getCustCntCd=================>" + data.getCustCntCd());
			log.info("getCustSeq==============>" + data.getCustSeq());
			log.info("getOfcCd==============>" + data.getOfcCd());
			log.info("getIoBndCd==============>" + data.getIoBndCd());
			log.info("setAutoInvFlg==============>" + data.getAutoInvFlg());
			log.info("model=====================>" + model);
			log.info("models====================>" + models);
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
			log.info(" (createMDM_CUST_REP) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CUST_REP) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMDMCUSTREP메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	@SuppressWarnings("unchecked")
//	public boolean createMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//
//		try {
//			isSuccessful = dbDao.addMdmCustRep(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 addMDMCUSTREP메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;	
		try {
			
			CreateMdmCustRepVO model = null;
//			ModifyMdmCustRepVO model2 = null;
			Iterator<CreateMdmCustRepVO> itr = models.iterator();
//			Iterator<ModifyMdmCustRepVO> itr2 = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmCustRepVO)itr.next();
			}	
//			while (itr2.hasNext()) {
//				model2 = (ModifyMdmCustRepVO)itr2.next();
//			}	
//			log.info("createMDMTBmodels====================>" + models);
			String cust_cnt_cd = model.getCustCntCd();
			String cust_seq = model.getCustSeq();
			String ofc_cd = model.getOfcCd();
			String io_bnd_cd = model.getIoBndCd();
			int insCnt = 0;
			log.info("cust_cnt_cd====================>" + cust_cnt_cd);
			log.info("cust_seq====================>" + cust_seq);
			log.info("ofc_cd====================>" + ofc_cd);
			log.info("io_bnd_cd====================>" + io_bnd_cd);
			boolean isNew = dbDao.searchMdmCustRep(cust_cnt_cd, cust_seq, ofc_cd, io_bnd_cd);
			log.info("createMDMTBmodel====================>" + model);
//			log.info("createMDMTBmodel2====================>" + model2);
			if ( isNew ) insCnt = dbDao.addMdmCustRep(model);
			else insCnt = dbDao.modifyMdmCustRep(model);
							
			if( insCnt > 0 ) isSuccessful = true;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}

	/** DBDAO의 removeMDMCUSTREP메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	public boolean removeMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//
//		try {
//			isSuccessful = dbDao.removeMdmCustRep(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 removeMDMCUSTREP메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			CreateMdmCustRepVO model = null;
			Iterator<CreateMdmCustRepVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmCustRepVO)itr.next();
			}

			log.info("removeMDMTBmodel====================>" + model);
			
			delCnt = dbDao.removeMdmCustRep(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
