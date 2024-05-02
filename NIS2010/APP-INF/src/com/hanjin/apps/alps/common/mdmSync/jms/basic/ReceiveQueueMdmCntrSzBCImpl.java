/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmCntrSzBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-08
 *@LastModifier : ChungEunHo
 *@LastVersion : 1.0
 * 2009-09-08 ChungEunHo / EQR	1.0
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCntrSzDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0520001Document;
import com.hanjin.irep.mdm.MDM0520001Document.MDM0520001;
import com.hanjin.syscommon.common.table.MdmCntrSzVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * ENIS-MDM0520001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author ChungEunHo
 * @see ReceiveQueueBC,MDM0520001Document 참조
 * @since J2EE 1.6
 */
public class ReceiveQueueMdmCntrSzBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCntrSzDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_CNTR_SIZEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCntrSzBCImpl() {
		dbDao = new ReceiveQueueMdmCntrSzDBDAO();
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

		MdmCntrSzVO model = null;
		Collection models = new ArrayList();

		MDM0520001Document mdmDoc = (MDM0520001Document) xmlObject;
		MDM0520001 mdm = mdmDoc.getMDM0520001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0520001Document.MDM0520001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmCntrSzVO();
			model.setCntrSzCd	 	(data.getCntrSzCd      	());
			model.setCntrSzDesc    	(data.getCntrSzDesc    	());
			model.setCntrSzTeuCapa	(data.getCntrSzTeuCapa	());
			model.setModiCntrSzCd 	(data.getModiCntrSzCd 	());
			model.setCreUsrId      	(data.getCreUsrId      	());
			model.setCreDt          (data.getCreDt         	());
			model.setUpdUsrId      	(data.getUpdUsrId      	());
			model.setUpdDt          (data.getUpdDt          ());
			model.setDeltFlg        (data.getDeltFlg        ());
			model.setEaiEvntDt		(getMsgCreDt			());
			model.setEaiIfId        (mdm.getEAIHeader().getInstanceId());
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
			log.info(" (createMDM_CNTR_SIZE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CNTR_SIZE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
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
			
			MdmCntrSzVO model = null;
			String cntr_sz_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrSzVO)itr.next();
				cntr_sz_cd = model.getCntrSzCd();
				if(dbDao.searchMdmCntrSzList(cntr_sz_cd)){
					if ( cntr_sz_cd !=null && cntr_sz_cd.trim().length() > 0 ) {
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						insModels.add(param);
						isInsert = true;
					}
				}else{
					if ( cntr_sz_cd !=null && cntr_sz_cd.trim().length() > 0){
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						uptModels.add(param);
						isUpdate = true;
					}
				}
			}
			if(isInsert){
				dbDao.addMdmCntrSz(insModels);
			}
			if(isUpdate){
				dbDao.addMdmCntrSzEtc(uptModels);
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
			
			MdmCntrSzVO model = null;
			String cntr_sz_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrSzVO)itr.next();
				cntr_sz_cd = model.getCntrSzCd();
				if ( cntr_sz_cd !=null && cntr_sz_cd.trim().length() > 0 
						&& !dbDao.searchMdmCntrSzList(cntr_sz_cd)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(model.getColumnValues());
					delModels.add(param);
					isDelete = true;
				}
			}
			if(isDelete){
				dbDao.removeMdmCntrSz(delModels);
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}