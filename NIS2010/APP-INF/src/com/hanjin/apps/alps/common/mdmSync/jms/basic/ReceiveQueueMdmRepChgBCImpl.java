/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_REP_CHGBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-25 : Ho-Jin Lee Alps 전환
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmRepChgDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0380001Document;
import com.hanjin.irep.mdm.MDM0380001Document.MDM0380001;
import com.hanjin.syscommon.common.table.MdmRepChgVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0380001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0380001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmRepChgBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmRepChgDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_REP_CHGBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmRepChgBCImpl() {
		dbDao = new ReceiveQueueMdmRepChgDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmRepChgVO> receiveMDMTB(XmlObject xmlObject) {
		MdmRepChgVO model = null;
		Collection<MdmRepChgVO> models = new ArrayList<MdmRepChgVO>();

		MDM0380001Document mdmDoc = (MDM0380001Document) xmlObject;
		MDM0380001 mdm = mdmDoc.getMDM0380001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models
		// =====
		com.hanjin.irep.mdm.MDM0380001Document.MDM0380001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmRepChgVO();
			model.setRepChgCd(data.getRepreChgCd());
			model.setRepChgNm(data.getRepreChgNm());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			log.info("\n >>>>model<<<<<="+model);
			models.add(model);
		}
		return models;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		
		try {
			int insCnt = 0;
			MdmRepChgVO model = null;
			Iterator<MdmRepChgVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmRepChgVO)itr.next();
			}
				String rep_chg_cd = model.getRepChgCd();
				log.info("\n >>>>rep_chg_cd="+rep_chg_cd);
				boolean searchFlag = dbDao.searchMDMREPCHGList(rep_chg_cd);
				log.info("\n >>>>searchFlag="+searchFlag);
				
				if(searchFlag){
					log.info("\n <<<<addMdmRepChg : model>>>>="+model);
					insCnt = dbDao.addMdmRepChg(model);
				}else{
					log.info("\n <<<<modifyMdmRepChg : model>>>>="+model);
					insCnt = dbDao.modifyMdmRepChg(model);
				}
			
			if(insCnt > 0){
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
	public boolean removeMDMTB(Collection models) throws DAOException{
		int delCnt = 0;
		boolean isSuccessful = false;
		try {
			MdmRepChgVO model = null;
			Iterator<MdmRepChgVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmRepChgVO)itr.next();
			}
			log.info("\n removeMDMTB : removeMdmRepChg : models="+models);
				delCnt = dbDao.removeMdmRepChg(model);
			
			if(delCnt > 0){
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
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			log.info("\n createMDMTB : models="+models);
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMdmRepChg) isSucessFlag : " + isSuccessFlag );
			break;

		case 'D':
			log.info("\n createMDMTB : models="+models);
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmRepChg) isSucessFlag : " + isSuccessFlag );
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
