/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmChargeBCImpl.java
 *@FileTitle : NIS2010 MDM CHARGE Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-07-05
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.1
 * History
 * ***************************************
 * 2009-09-23 Sun, Choi		1.0 ALPS Migration
 * 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
 * 2013.07.02 김현화 [CHM-201325381]Surcharge 정제 - 컬럼추가   MdtRatFlg
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmChargeDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmChargeVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0350001Document;
import com.hanjin.irep.mdm.MDM0350001Document.MDM0350001;

/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0350001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Sun, Choi
 * @see ReceiveQueueBC,MDM0350001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmChargeBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmChargeDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** ReceiveQueueMDM_CHARGEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmChargeBCImpl() {
		dbDao = new ReceiveQueueMdmChargeDBDAO();
	}

	/** opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
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
	public Collection<CreateMdmChargeVO> receiveMDMTB(XmlObject xmlObject) {

		CreateMdmChargeVO model = null;
		Collection<CreateMdmChargeVO> models = new ArrayList<CreateMdmChargeVO>();

		MDM0350001Document mdmDoc = (MDM0350001Document) xmlObject;
		MDM0350001 mdm = mdmDoc.getMDM0350001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0350001Document.MDM0350001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			model = new CreateMdmChargeVO();
			model.setChgCd(data.getChgCd());
			model.setChgNm(data.getChgNm());
			model.setFrtChgTpCd(data.getFrtChgTpCd());
			model.setSenChgAcctCd(data.getSenatoChgAcctCd());
			model.setHjsChgAcctCd(data.getHjinChgAcctCd());
			model.setRepChgCd(data.getRepreChgCd());
			model.setChgRevTpCd(data.getChgRevTpCd());
			model.setChgAplyTpCd(data.getChgApplTpCd());
			model.setChgAplyAreaCd(data.getChgApplAreaCd());
			model.setCyRdTermFlg(data.getCyRdTermFlg());
			model.setCfsRdTermFlg(data.getCfsRdTermFlg());
			model.setDorRdTermFlg(data.getDorRdTermFlg());
			model.setNaRdTermFlg(data.getNaRdTermFlg());
			model.setTklTmlFlg(data.getTklTmlFlg());
			model.setAplySvcModFlg(data.getApplSvcModFlg());
			model.setUseCoTpCd(data.getUseCoTpCd());
			model.setAutoRatFlg(data.getAutoRatFlg());
			model.setSenGrpChgCd(data.getSenGrpChgCd());
			model.setChgEdiCd(data.getChgEdiCd());
			model.setDpSeq(data.getDpSeq());
			model.setChgStsCd(data.getChgStsCd());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setMdtRatFlg(data.getMdtRatFlg());  //2013.07.02 추가
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());  // 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
			
			models.add(model);
//			log.info("getChgCd=================>" + data.getChgCd());
//			log.info("getChgNm==============>" + data.getChgNm());
//			log.info("getFrtChgTpCd==============>" + data.getFrtChgTpCd());
//			log.info("getSenatoChgAcctCd==============>" + data.getSenatoChgAcctCd());
//			log.info("getHjinChgAcctCd==============>" + data.getHjinChgAcctCd());
//			log.info("getRepreChgCd==============>" + data.getRepreChgCd());
//			log.info("getChgRevTpCd=============>" + data.getChgRevTpCd());
//			log.info("getChgApplTpCd=============>" + data.getChgApplTpCd());
//			log.info("getChgApplAreaCd=============>" + data.getChgApplAreaCd());
//			log.info("getCyRdTermFlg=============>" + data.getCyRdTermFlg());
//			log.info("getCfsRdTermFlg=============>" + data.getCfsRdTermFlg());
//			log.info("getDorRdTermFlg=============>" + data.getDorRdTermFlg());
//			log.info("getNaRdTermFlg=============>" + data.getNaRdTermFlg());
//			log.info("getTklTmlFlg=======>" + data.getTklTmlFlg());
//			log.info("getApplSvcModFlg===>" + data.getApplSvcModFlg());
//			log.info("getUseCoTpCd===============>" + data.getUseCoTpCd());
//			log.info("getAutoRatFlg===============>" + data.getAutoRatFlg());
//			log.info("getSenGrpChgCd===============>" + data.getSenGrpChgCd());
//			log.info("getChgEdiCd===============>" + data.getChgEdiCd());
//			log.info("getDpSeq===============>" + data.getDpSeq());
//			log.info("getChgStsCd===============>" + data.getChgStsCd());
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

	/** DBDAO의 addMDMCHARGE메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	public boolean createMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		try {
//			isSuccessful = dbDao.addMdmCharge(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}

	/** DBDAO의 addMDMCHARGE메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		
		try {
			
			CreateMdmChargeVO model = null;
//			ModifyMdmChargeVO model2 = null;
			Iterator<CreateMdmChargeVO> itr = models.iterator();
//			Iterator<ModifyMdmChargeVO> itr2 = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmChargeVO)itr.next();
			}	
//			while (itr2.hasNext()) {
//				model2 = (ModifyMdmChargeVO)itr2.next();
//			}	
//			log.info("createMDMTBmodels====================>" + models);
			String chg_cd = model.getChgCd();
			int insCnt = 0;
//			log.info("chg_cd====================>" + chg_cd);
			boolean isNew = dbDao.searchMdmCharge(chg_cd);
//			log.info("createMDMTBmodel====================>" + model);
//			log.info("createMDMTBmodel2====================>" + model2);
			if ( isNew ) insCnt = dbDao.addMdmCharge(model);
			else insCnt = dbDao.modifyMdmCharge(model);
			
			if( insCnt > 0 ) isSuccessful = true;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}
	
	/** DBDAO의 removeMDMCHARGE메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	public boolean removeMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		try {
//			isSuccessful = dbDao.removeMdmCharge(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 removeMDMCHARGE메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			CreateMdmChargeVO model = null;
			Iterator<CreateMdmChargeVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmChargeVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmCharge(model);
			
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
			log.info(" (createMDM_CHARGE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CHARGE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}
