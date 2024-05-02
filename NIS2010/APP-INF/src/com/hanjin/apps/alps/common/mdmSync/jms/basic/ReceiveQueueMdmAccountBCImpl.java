/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmAccountBCImpl.java
 *@FileTitle : NIS2010 MDM ACCOUNT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-07-05
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.1
 * 2009-09-23 Sun, Choi		1.0 ALPS Migration
 * 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmAccountDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmAccountVO;
//import com.hanjin.apps.alps.common.mdmSync.jms.vo.DeleteMdmAccountVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0360001Document;
import com.hanjin.irep.mdm.MDM0360001Document.MDM0360001;

/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Sun, Choi
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmAccountBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmAccountDBDAO dbDao = null;
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

	/** ReceiveQueueMDM_ACCOUNTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmAccountBCImpl() {
		dbDao = new ReceiveQueueMdmAccountDBDAO();
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
	public Collection<CreateMdmAccountVO> receiveMDMTB(XmlObject xmlObject) {

		CreateMdmAccountVO model = null;
//		Collection models = new ArrayList();
		Collection<CreateMdmAccountVO> models = new ArrayList<CreateMdmAccountVO>();
		
		MDM0360001Document mdmDoc = (MDM0360001Document) xmlObject;
		MDM0360001 mdm = mdmDoc.getMDM0360001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());
		
		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0360001Document.MDM0360001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new CreateMdmAccountVO();
			model.setAcctCd(data.getAcctCd());
			model.setAcctEngNm(data.getAcctEngNm());
			model.setAcctKrnNm(data.getAcctKrnNm());
			model.setBudUseFlg(data.getBudUseFlg());
			model.setJnlCreFlg(data.getJnlCreFlg());
			model.setAcctgMngTpCd(data.getAcctgMngTpCd());
			model.setPndTgtFlg(data.getPndTgtFlg());
			model.setEstmTgtFlg(data.getEstmTgtFlg());
			model.setVvdLvlFlg1(data.getVvdLvlFlg1());
			model.setVvdLvlFlg2(data.getVvdLvlFlg2());
			model.setVvdLvlFlg3(data.getVvdLvlFlg3());
			model.setVvdLvlFlg4(data.getVvdLvlFlg4());
			model.setVvdLvlFlg5(data.getVvdLvlFlg5());
			model.setVvdLvlFlg6(data.getVvdLvlFlg6());
			model.setAutoCurrXchRtFlg(data.getAutoCurrXchRtFlg());
			model.setEntrExpnFlg(data.getEntertainmentExpnFlg());
			model.setBudIfFlg(data.getBudIfFlg());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());  // 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
			
			models.add(model);
//			log.info("getAcctCd=================>" + data.getAcctCd());
//			log.info("getAcctKrnNm==============>" + data.getAcctKrnNm());
//			log.info("getBudUseFlg==============>" + data.getBudUseFlg());
//			log.info("getBudUseFlg==============>" + data.getJnlCreFlg());
//			log.info("getJnlCreFlg==============>" + data.getAcctgMngTpCd());
//			log.info("getPndTgtFlg==============>" + data.getPndTgtFlg());
//			log.info("getEstmTgtFlg=============>" + data.getEstmTgtFlg());
//			log.info("getVvdLvlFlg1=============>" + data.getVvdLvlFlg1());
//			log.info("getVvdLvlFlg2=============>" + data.getVvdLvlFlg2());
//			log.info("getVvdLvlFlg3=============>" + data.getVvdLvlFlg3());
//			log.info("getVvdLvlFlg4=============>" + data.getVvdLvlFlg4());
//			log.info("getVvdLvlFlg5=============>" + data.getVvdLvlFlg5());
//			log.info("getVvdLvlFlg6=============>" + data.getVvdLvlFlg6());
//			log.info("getAutoCurrXchRtFlg=======>" + data.getAutoCurrXchRtFlg());
//			log.info("getEntertainmentExpnFlg===>" + data.getEntertainmentExpnFlg());
//			log.info("getBudIfFlg===============>" + data.getBudIfFlg());
//			log.info("getCreUsrId===============>" + data.getCreUsrId());
//			log.info("getCreDt==================>" + data.getCreDt());
//			log.info("getUpdUsrId===============>" + data.getUpdUsrId());
//			log.info("getUpdDt==================>" + data.getUpdDt());
//			log.info("getDeltFlg================>" + data.getDeltFlg());
//			log.info("getMsgCreDt===============>" + getMsgCreDt());
//			log.info("model=====================>" + model);
//			log.info("models====================>" + models);
		}
		return models;
	}
	
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	@SuppressWarnings("unchecked")
//	public boolean createMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		List insModels = new ArrayList();
//		List uptModels = new ArrayList();
//		boolean isInsert = false;
//		boolean isUpdate = false;
//		try {
//			Iterator itr = models.iterator();
//			
//			SearchMdmAccountVO model = null;
//			String s_acct_cd = null;
//			
//			while (itr.hasNext()) {
//				model = (SearchMdmAccountVO)itr.next();
//				s_acct_cd = model.getSAcctCd();
//				if(dbDao.searchMdmAccount(s_acct_cd)){
//					if ( s_acct_cd != null && s_acct_cd.trim().length() > 0 ) {
//						//query parameter
//						Map<String, Object> param = new HashMap<String, Object>();
//						param.putAll(model.getColumnValues());
//						insModels.add(param);
//						isInsert = true;
//					}
//				}else{
//					if ( s_acct_cd !=null && s_acct_cd.trim().length() > 0){
//						//query parameter
//						Map<String, Object> param = new HashMap<String, Object>();
//						param.putAll(model.getColumnValues());
//						uptModels.add(param);
//						isUpdate = true;
//					}
//				}
//			}
//			if(isInsert){
//				dbDao.addMdmAccount(insModels);
//			}
//			if(isUpdate){
//				dbDao.modifyMdmAccount(uptModels);
//			}
//			
//			isSuccessful = true;
//			
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		
		try {
			
			CreateMdmAccountVO model = null;
//			ModifyMdmAccountVO model2 = null;
			Iterator<CreateMdmAccountVO> itr = models.iterator();
//			Iterator<ModifyMdmAccountVO> itr2 = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmAccountVO)itr.next();
			}	
//			while (itr2.hasNext()) {
//				model2 = (ModifyMdmAccountVO)itr2.next();
//			}
//			log.info("createMDMTBmodels====================>" + models);
			String acct_cd = model.getAcctCd();
			int insCnt = 0;
//			log.info("acct_cd====================>" + acct_cd);
			boolean isNew = dbDao.searchMdmAccount(acct_cd);
//			log.info("createMDMTBmodel====================>" + model);
//			log.info("createMDMTBmodel2====================>" + model2);
//			log.info("isNew====================>" + isNew);
			if ( isNew ) insCnt = dbDao.addMdmAccount(model);
			else insCnt = dbDao.modifyMdmAccount(model);
							
			if( insCnt > 0 ) isSuccessful = true;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	@SuppressWarnings("unchecked")
//	public boolean removeMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		List delModels = new ArrayList();
//		boolean isDelete = false;
//		
//		try {
//			Iterator itr = models.iterator();
//			
//			DeleteMdmAccountVO model = null;
//			String s_acct_cd = null;
//			
//			while (itr.hasNext()) {
//				model = (DeleteMdmAccountVO)itr.next();
//				s_acct_cd = model.getSAcctCd();
//				if ( s_acct_cd !=null && s_acct_cd.trim().length() > 0 
//						&& !dbDao.searchMdmAccount(s_acct_cd)) {
//					Map<String, Object> param = new HashMap<String, Object>();
//					param.putAll(model.getColumnValues());
//					delModels.add(param);
//					isDelete = true;
//				}
//			}
//			if(isDelete){
//				dbDao.removeMdmAccount(delModels);
//			}
//			isSuccessful = true;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			CreateMdmAccountVO model = null;
			Iterator<CreateMdmAccountVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmAccountVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmAccount(model);
			
			if( delCnt > 0 ) isSuccessful = true;
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
			log.info(" (createMDM_ACCOUNT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_ACCOUNT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}