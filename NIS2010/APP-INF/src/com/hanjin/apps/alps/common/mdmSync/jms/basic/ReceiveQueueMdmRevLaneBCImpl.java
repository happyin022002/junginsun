/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmRevLaneBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmRevLaneDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0090001Document;
import com.hanjin.irep.mdm.MDM0090001Document.MDM0090001;
import com.hanjin.syscommon.common.table.MdmDtlRevLaneVO;
import com.hanjin.syscommon.common.table.MdmRevLaneVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmRevLaneBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmRevLaneDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_REV_LANEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmRevLaneBCImpl() {
		dbDao = new ReceiveQueueMdmRevLaneDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveMDMTB(XmlObject xmlObject) {
		Collection models = new ArrayList();
		
		MdmRevLaneVO    model  = null;
		MdmDtlRevLaneVO model2 = null;

		MDM0090001Document mdmDoc = (MDM0090001Document) xmlObject;
		MDM0090001 mdm = mdmDoc.getMDM0090001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());
		
		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		
		setMsgCreDt(app.getMsgCreDt());
		
		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0090001Document.MDM0090001.DataArea data = mdm.getDataArea();
		
		Collection temp = null;
		if (data != null) {
			temp = new ArrayList();
			
			model = new MdmRevLaneVO();
			model.setRlaneCd(data.getRevLaneCd());
			model.setRlaneNm(data.getRevLaneNm());
			model.setVslTpCd(data.getVslTpCd());
			model.setRepTrdCd(data.getRepreTrdCd());
			model.setVslSlanCd(data.getVslSlanCd());
			model.setModiRlaneCd(data.getModiRevLaneCd());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			temp.add(model);
			
			model2 = new MdmDtlRevLaneVO();
			model2.setRlaneCd(data.getRevLaneCd());
			model2.setVslSlanDirCd(data.getDetVslSlanDirCd());
			model2.setTrdCd(data.getDetTrdCd());
			model2.setIocCd(data.getDetIocCd());
			model2.setFmContiCd(data.getDetFmContiCd());
			model2.setToContiCd(data.getDetToContiCd());
			model2.setSubTrdCd(data.getDetSubTrdCd());
			model2.setCreUsrId(data.getCreUsrId());
			model2.setCreDt(data.getCreDt());
			model2.setUpdUsrId(data.getUpdUsrId());
			model2.setUpdDt(data.getUpdDt());
			model2.setDeltFlg(data.getDetDeltFlg());
			model2.setEaiEvntDt(getMsgCreDt());
			model2.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			temp.add(model2);
			models.add(temp);
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
		List insModels  = new ArrayList();
		List insModels2 = new ArrayList();
		List updModels  = new ArrayList();
		List updModels2 = new ArrayList();
		boolean isInsert  = false;
		boolean isInsert2 = false;
		boolean isUpdate  = false;
		boolean isUpdate2 = false;
		boolean isInsChk  = true;
		boolean isInsChk2 = true;
		boolean isUpdChk  = true;
		boolean isUpdChk2 = true;
		
		try {
			Iterator itr_t  = models.iterator();
			Collection temp = null;
			
			MdmRevLaneVO    model  = null; 
			MdmDtlRevLaneVO model2 = null;
			
			String revLaneCd    = null;
			String rlaneCd      = null;
			String vslSlanDirCd = null;
			String iocCd        = null;
			String fmContiCd    = null;
			String toContiCd    = null;
			
			while (itr_t.hasNext()) {
				temp = (ArrayList)itr_t.next();
				Iterator itr = temp.iterator();
				
				int k = 1;
				while (itr.hasNext()) {
					if(k%2 == 1)	{
						model     = (MdmRevLaneVO)itr.next();
						revLaneCd = model.getRlaneCd();
						
						if(dbDao.searchMdmRevLaneList(revLaneCd)) {
							if ( revLaneCd != null && revLaneCd.trim().length() > 0 ) {
								Map<String, Object> param = new HashMap<String, Object>();
								param.putAll(model.getColumnValues());
								insModels.add(param);
								isInsert = true;
							}
						} else {
							if ( revLaneCd != null && revLaneCd.trim().length() > 0 ) {
								Map<String, Object> param = new HashMap<String, Object>();
								param.putAll(model.getColumnValues());
								updModels.add(param);
								isUpdate = true;
							}
						}
					} else {
						model2 = (MdmDtlRevLaneVO)itr.next();
						
						rlaneCd      = model2.getRlaneCd();
						vslSlanDirCd = model2.getVslSlanDirCd();
						iocCd        = model2.getIocCd();
						fmContiCd    = model2.getFmContiCd();
						toContiCd    = model2.getToContiCd();
						
						if(dbDao.searchMdmDtlRevLaneList(rlaneCd, vslSlanDirCd, iocCd, fmContiCd, toContiCd)) {
							if (    rlaneCd      != null && rlaneCd.trim().length()      > 0
								 && vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0
								 && iocCd        != null && iocCd.trim().length()        > 0
								 && fmContiCd    != null && fmContiCd.trim().length()    > 0
								 && toContiCd    != null && toContiCd.trim().length()    > 0) {
								Map<String, Object> param = new HashMap<String, Object>();
								param.putAll(model2.getColumnValues());
								insModels2.add(param);
								isInsert2 = true;
							}
						} else {
							if (    rlaneCd      != null && rlaneCd.trim().length()      > 0
								 && vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0
								 && iocCd        != null && iocCd.trim().length()        > 0
								 && fmContiCd    != null && fmContiCd.trim().length()    > 0
								 && toContiCd    != null && toContiCd.trim().length()    > 0) {
								Map<String, Object> param = new HashMap<String, Object>();
								param.putAll(model2.getColumnValues());
								updModels2.add(param);
								isUpdate2 = true;
							}
						}
					}
					k++;
				}
			}
			
			if(isInsert){
				isInsChk = dbDao.addMdmRevLane(insModels);
			}
			if(isUpdate){
				isUpdChk = dbDao.modifyMdmRevLane(updModels);
			}
			if(isInsert2){
				isInsChk = dbDao.addMdmDtlRevLane(insModels2);
			}
			if(isUpdate2){
				isUpdChk = dbDao.modifyMdmDtlRevLane(updModels2);
			}
			
			if(isInsChk && isUpdChk && isInsChk2 && isUpdChk2){
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
		List delModels    = new ArrayList();
		List delModels2   = new ArrayList();
		boolean isDelete  = false;
		boolean isDelete2 = false;
		boolean isDelChk  = true;
		boolean isDelChk2 = true;
		
		try {
			Iterator itr_t  = models.iterator();
			Collection temp = null;
			
			MdmRevLaneVO    model  = null; 
			MdmDtlRevLaneVO model2 = null;
			
			String revLaneCd    = null;
			String rlaneCd      = null;
			String vslSlanDirCd = null;
			String iocCd        = null;
			String fmContiCd    = null;
			String toContiCd    = null;
			
			while (itr_t.hasNext()) {
				temp = (ArrayList)itr_t.next();
				Iterator itr = temp.iterator();
				
				int k=0;
				while (itr.hasNext()) {
					if(k%2 ==0)	{
						model = (MdmRevLaneVO)itr.next();
						
						revLaneCd = model.getRlaneCd();
						if ( revLaneCd != null && revLaneCd.trim().length() > 0 && !dbDao.searchMdmRevLaneList(revLaneCd)) {
							Map<String, Object> param = new HashMap<String, Object>();
							param.putAll(model.getColumnValues());
							delModels.add(param);
							isDelete = true;
						}
					} else {
						model2 = (MdmDtlRevLaneVO)itr.next();
						
						rlaneCd      = model2.getRlaneCd();
						vslSlanDirCd = model2.getVslSlanDirCd();
						iocCd        = model2.getIocCd();
						fmContiCd    = model2.getFmContiCd();
						toContiCd    = model2.getToContiCd();
						
						if (    rlaneCd      != null && rlaneCd.trim().length()      > 0
							 && vslSlanDirCd != null && vslSlanDirCd.trim().length() > 0
							 && iocCd        != null && iocCd.trim().length()        > 0
							 && fmContiCd    != null && fmContiCd.trim().length()    > 0
							 && toContiCd    != null && toContiCd.trim().length()    > 0
							 && !dbDao.searchMdmDtlRevLaneList(rlaneCd, vslSlanDirCd, iocCd, fmContiCd, toContiCd)) {
							Map<String, Object> param = new HashMap<String, Object>();
							param.putAll(model2.getColumnValues());
							delModels2.add(param);
							isDelete2 = true;
						}
					}
					k++;
				}
			}
			
			if(isDelete){
				isDelChk = dbDao.removeMdmRevLane(delModels);
			}
			
			if(isDelete2){
				isDelChk2 = dbDao.removeMdmDtlRevLane(delModels2);
			}
			
			if(isDelChk && isDelChk2){
				isSuccessful = true;
			}
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
			log.info(" (createMDM_REV_LANE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_REV_LANE) isSucessFlag : "
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
