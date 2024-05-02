/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_SVC_SCOPE_LIMITBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpLmtDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0420001Document;
import com.hanjin.irep.mdm.MDM0420001Document.MDM0420001;
import com.hanjin.syscommon.common.table.MdmSvcScpLmtVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0420001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0420001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSvcScpLmtBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmSvcScpLmtDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_SVC_SCOPE_LIMITBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmSvcScpLmtBCImpl() {
		dbDao = new ReceiveQueueMdmSvcScpLmtDBDAO();
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
	public Collection<MdmSvcScpLmtVO> receiveMDMTB(XmlObject xmlObject) {

		MdmSvcScpLmtVO model = null;
		Collection<MdmSvcScpLmtVO> models = new ArrayList<MdmSvcScpLmtVO>();

		MDM0420001Document mdmDoc = (MDM0420001Document) xmlObject;
		MDM0420001 mdm = mdmDoc.getMDM0420001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0420001Document.MDM0420001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmSvcScpLmtVO();
			model.setSvcScpCd (data.getSvcScpCd ()); 
			model.setRgnCd     (data.getRgnCd     ()); 
			model.setOrgDestCd(data.getOrgDestCd()); 
			model.setCreUsrId (data.getCreUsrId ()); 
			model.setUpdUsrId (data.getUpdUsrId ()); 
			model.setCreDt     (data.getCreDt     ());
			model.setUpdDt     (data.getUpdDt     ());
			model.setDeltFlg   (data.getDeltFlg   ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setSvcScpIndFlg(data.getSvcScpIndFlg());
			model.setSvcScpLmtSeq(data.getSvcScpLmtSeq());
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
		log.info("\n ctrlMDMTB : models="+models);
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDM_SVC_SCP_LMT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_SVC_SCP_LMT) isSucessFlag : "
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
		try {
			MdmSvcScpLmtVO model = null;
			Iterator<MdmSvcScpLmtVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmSvcScpLmtVO)itr.next();
			}
			String svc_scp_cd 	= model.getSvcScpCd();
			String rgn_cd 		= model.getRgnCd();
			String org_dest_cd 	= model.getOrgDestCd();
			//String svc_scp_lmt_seq 	= model.getSvcScpLmtSeq();
			
			
			boolean searchFlag = dbDao.searchMDMSVCSCPLMTList(svc_scp_cd, rgn_cd, org_dest_cd);
			int insCnt = 0;
			if(searchFlag){
				insCnt = dbDao.addMdmSvcScpLmt(model);
			}else{
				insCnt = dbDao.modifyMdmSvcScpLmt(model);
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
			MdmSvcScpLmtVO model = null;
			Iterator<MdmSvcScpLmtVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmSvcScpLmtVO)itr.next();
			}
			delCnt = dbDao.removeMdmSvcScpLmt(model);
			
			if(delCnt > 0){
				isSuccessful = true;
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
