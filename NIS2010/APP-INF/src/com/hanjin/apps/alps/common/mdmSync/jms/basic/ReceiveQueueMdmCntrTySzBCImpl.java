/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmCntrTySzBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCntrTySzDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0540001Document;
import com.hanjin.irep.mdm.MDM0540001Document.MDM0540001;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * ENIS-MDM0540001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0540001Document 참조
 * @since J2EE 1.6
 */
public class ReceiveQueueMdmCntrTySzBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCntrTySzDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** MsgCreDt setter 메서드.<br>
	 * @param msgCreDt String
	 */
	public String getMsgCreDt() {
		return msgCreDt;
	}

	/** ReceiveQueueMDM_ACCOUNTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}

	/** ReceiveQueueMDM_CNTR_TPSZBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCntrTySzBCImpl() {
		dbDao = new ReceiveQueueMdmCntrTySzDBDAO();
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

		MdmCntrTpSzVO model = null;
		Collection models = new ArrayList();

		MDM0540001Document mdmDoc = (MDM0540001Document) xmlObject;
		MDM0540001 mdm = mdmDoc.getMDM0540001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());
		
		com.hanjin.irep.mdm.MDM0540001Document.MDM0540001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmCntrTpSzVO();
			model.setCntrTpszCd	    	(data.getCntrTpszCd      ()); 
			model.setCntrSzCd         	(data.getCntrSzCd        ()); 
			model.setCntrTpCd         	(data.getCntrTpCd        ()); 
			model.setCntrTpszLodgWgt 	(data.getCntrTpszLodgWgt ());  
			model.setCntrTpszLodgCapa	(data.getCntrTpszLodgCapa());  
			model.setCntrTpszTareWgt 	(data.getCntrTpszTareWgt ());  
			model.setCntrTpszDesc     	(data.getCntrTpszDesc    ()); 
			model.setCntrTpszRmk      	(data.getCntrTpszRmk     ()); 
			model.setCntrTpszPsaCd   	(data.getCntrTpszPsaCd   ());  
			model.setCntrTpszIsoCd   	(data.getCntrTpszIsoCd   ());  
			model.setModiCntrTpszCd  	(data.getModiCntrTpszCd  ());  
			model.setCreUsrId         	(data.getCreUsrId        ()); 
			model.setCreDt             	(data.getCreDt           ());
			model.setUpdUsrId         	(data.getUpdUsrId        ()); 
			model.setUpdDt             	(data.getUpdDt           ());
			model.setDeltFlg           	(data.getDeltFlg         ());
			model.setEaiEvntDt			(getMsgCreDt			 ());
			model.setCntrTpszGrpCd      (data.getCntrTpszGrpCd   ());
			model.setEaiIfId            (mdm.getEAIHeader().getInstanceId());
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
			log.info(" (createMDM_CNTR_TP_SZ) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CNTR_TP_SZ) isSucessFlag : "
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
			
			MdmCntrTpSzVO model = null;
			String cntr_tpsz_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrTpSzVO)itr.next();
				cntr_tpsz_cd = model.getCntrTpszCd();
	
				log.info("cntr_tpsz_cd : " + cntr_tpsz_cd);
			
				if(dbDao.SearchMdmCntrTpSzList(cntr_tpsz_cd)){
					if ( cntr_tpsz_cd !=null && cntr_tpsz_cd.trim().length() > 0 ) {
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						insModels.add(param);
						isInsert = true;
					}
				}else{
					if ( cntr_tpsz_cd !=null && cntr_tpsz_cd.trim().length() > 0){
						//query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						param.putAll(model.getColumnValues());
						uptModels.add(param);
						isUpdate = true;
					}
				}
			}
			if(isInsert){
				dbDao.addMdmCntrTpSz(insModels);
			}
			if(isUpdate){
				dbDao.addMdmCntrTpSzEtc(uptModels);
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
			
			MdmCntrTpSzVO model = null;
			String cntr_tpsz_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmCntrTpSzVO)itr.next();
				cntr_tpsz_cd = model.getCntrTpszCd();
				
				log.info("cntr_tpsz_cd : " + cntr_tpsz_cd);
				
				if ( cntr_tpsz_cd !=null && cntr_tpsz_cd.trim().length() > 0 
						&& !dbDao.SearchMdmCntrTpSzList(cntr_tpsz_cd)) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(model.getColumnValues());
					delModels.add(param);
					isDelete = true;
				}
			}
			if(isDelete){
				dbDao.removeMdmCntrTpSz(delModels);
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
