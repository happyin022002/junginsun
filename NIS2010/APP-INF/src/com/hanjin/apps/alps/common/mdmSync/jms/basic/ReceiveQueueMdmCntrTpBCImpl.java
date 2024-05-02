/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmCntrTpBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCntrTpDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0530001Document;
import com.hanjin.irep.mdm.MDM0530001Document.MDM0530001;
import com.hanjin.syscommon.common.table.MdmCntrTpVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0530001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0530001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCntrTpBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCntrTpDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_CNTR_TYPEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCntrTpBCImpl() {
		dbDao = new ReceiveQueueMdmCntrTpDBDAO();
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

		MdmCntrTpVO model = null;
		Collection models = new ArrayList();

		MDM0530001Document mdmDoc = (MDM0530001Document) xmlObject;
		MDM0530001 mdm = mdmDoc.getMDM0530001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0530001Document.MDM0530001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmCntrTpVO();
			model.setCntrTpCd     (data.getCntrTpCd     ()); 
			model.setCntrTpDesc   (data.getCntrTpDesc   ()); 
			model.setModiCntrTpCd (data.getModiCntrTpCd	());  
			model.setCreUsrId     (data.getCreUsrId     ()); 
			model.setCreDt        (data.getCreDt        ());
			model.setUpdUsrId     (data.getUpdUsrId     ()); 
			model.setUpdDt        (data.getUpdDt        ());
			model.setDeltFlg      (data.getDeltFlg      ());
			model.setEaiEvntDt	  (getMsgCreDt			());
			model.setEaiIfId      (mdm.getEAIHeader().getInstanceId());
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
			log.info(" (createMDM_CNTR_TP) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CNTR_TP) isSucessFlag : "
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
			
			MdmCntrTpVO model = null;
			String cntr_tp_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrTpVO)itr.next();
				cntr_tp_cd = model.getCntrTpCd();
	
				log.info("cntr_tp_cd : " + cntr_tp_cd);
			
				if(dbDao.SearchMdmCntrTpList(cntr_tp_cd)){
					if ( cntr_tp_cd !=null && cntr_tp_cd.trim().length() > 0 ) {
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						insModels.add(param);
						isInsert = true;
					}
				}else{
					if ( cntr_tp_cd !=null && cntr_tp_cd.trim().length() > 0){
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						uptModels.add(param);
						isUpdate = true;
					}
				}
			}
			if(isInsert){
				dbDao.addMdmCntrTp(insModels);
			}
			if(isUpdate){
				dbDao.addMdmCntrTpEtc(uptModels);
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
			
			MdmCntrTpVO model = null;
			String cntr_tp_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrTpVO)itr.next();
				cntr_tp_cd = model.getCntrTpCd();
				
				log.info("cntr_tp_cd : " + cntr_tp_cd);
				
				if ( cntr_tp_cd !=null && cntr_tp_cd.trim().length() > 0 
						&& !dbDao.SearchMdmCntrTpList(cntr_tp_cd)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(model.getColumnValues());
					delModels.add(param);
					isDelete = true;
				}
			}
			if(isDelete){
				dbDao.removeMdmCntrTp(delModels);
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
