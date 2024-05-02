/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmSubcontinentBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-05
 *@LastModifier : Kim kwijin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSubcontinentDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmAccountVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmSubcontinentVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0470001Document;
import com.hanjin.irep.mdm.MDM0470001Document.MDM0470001;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0470001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0470001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSubcontinentBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmSubcontinentDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_SUB_CONTINENTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmSubcontinentBCImpl() {
		dbDao = new ReceiveQueueMdmSubcontinentDBDAO();
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

		MdmSubcontinentVO model = null;
		//Collection models = new ArrayList();
		Collection<MdmSubcontinentVO> models = new ArrayList<MdmSubcontinentVO>();
		
		MDM0470001Document mdmDoc = (MDM0470001Document) xmlObject;
		MDM0470001 mdm = mdmDoc.getMDM0470001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0470001Document.MDM0470001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmSubcontinentVO();
			model.setScontiCd (data.getScontiCd ());
			model.setContiCd   (data.getContiCd  ());
			model.setScontiNm  (data.getScontiNm ());
			model.setCreUsrId (data.getCreUsrId()); 
			model.setCreDt     (data.getCreDt    ());
			model.setUpdUsrId (data.getUpdUsrId()); 
			model.setUpdDt     (data.getUpdDt    ());
			model.setDeltFlg   (data.getDeltFlg  ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
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
			log.info(" (createMDM_SUBCONTINENT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_SUBCONTINENT) isSucessFlag : "
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
		MdmSubcontinentVO model = null;
		Collection<MdmSubcontinentVO> addModels = new ArrayList<MdmSubcontinentVO>(); 
		Collection<MdmSubcontinentVO> modifyModels = new ArrayList<MdmSubcontinentVO>(); 
		
		try{
			Iterator<MdmSubcontinentVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmSubcontinentVO)itr.next();
				String sconti_cd = model.getScontiCd();
				if(dbDao.searchMDM_SUBCONTINENTList(sconti_cd)){
					//dbDao.addMdmSubcontinent(model);
					addModels.add(model);
				}else{
					//dbDao.modifyMdmSubcontinent(model);
					modifyModels.add(model);
				}
			} 
			
			if(addModels.size()>0){
				dbDao.addMdmSubcontinent(addModels);
			}
			if(modifyModels.size()>0){
				dbDao.modifyMdmSubcontinent(modifyModels);
			}
			isSuccessful = true;
		}catch (DAOException de) {
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
		MdmSubcontinentVO model = null;
		
		try{
			Iterator<MdmSubcontinentVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmSubcontinentVO)itr.next();
				dbDao.removeMdmSubcontinent(model);
			} 
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		isSuccessful = true;
		return isSuccessful;
		
	}
}
