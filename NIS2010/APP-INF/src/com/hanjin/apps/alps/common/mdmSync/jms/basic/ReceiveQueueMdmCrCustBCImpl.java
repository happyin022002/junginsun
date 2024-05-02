/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmCrCustBCImpl.java
 *@FileTitle : NIS2010 MDM CREDIT CUSTOMER Interface
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCrCustDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmCrCustVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0170001Document;
import com.hanjin.irep.mdm.MDM0170001Document.MDM0170001;

/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0170001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Sun, Choi
 * @see ReceiveQueueBC,MDM0170001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCrCustBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCrCustDBDAO dbDao = null;

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
	public ReceiveQueueMdmCrCustBCImpl() {
		dbDao = new ReceiveQueueMdmCrCustDBDAO();
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
	public Collection<CreateMdmCrCustVO> receiveMDMTB(XmlObject xmlObject) {

		CreateMdmCrCustVO model = null;
		Collection<CreateMdmCrCustVO> models = new ArrayList<CreateMdmCrCustVO>();

		MDM0170001Document mdmDoc = (MDM0170001Document) xmlObject;
		MDM0170001 mdm = mdmDoc.getMDM0170001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0170001Document.MDM0170001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new CreateMdmCrCustVO();
			model.setCustCntCd	      (data.getCustCntCd          ()); 
			model.setCustSeq             (data.getCustSeq             ());
			model.setActCustCntCd      (data.getActCustCntCd      ());  
			model.setActCustSeq         (data.getActCustSeq         ()); 
			model.setCustRlseCtrlFlg   (data.getCustRlseCtrlFlg   ());  
			model.setCrFlg               (data.getCrFlg               ());
			model.setCrCurrCd           (data.getCrCurrCd           ()); 
			model.setCrAmt               (data.getCrAmt               ());
			model.setCrCltOfcCd        (data.getCrCltOfcCd        ());  
			model.setCrCustRmk          (data.getCrCustRmk          ()); 
			model.setIbCrTermDys       (data.getIbCrTermDys       ());  
			model.setObCrTermDys       (data.getObCrTermDys       ());  
			model.setPayDivCd           (data.getPayDivCd           ()); 
			model.setCrStDt             (data.getCrStrtDt             ()); 
			model.setCrEndDt            (data.getCrEndDt            ()); 
			model.setCrCustTpCd        (data.getCrCustTpCd        ());  
			model.setKrIbOfcCd         (data.getKrIbOfcCd         ());  
			model.setObEml               (data.getObEml               ());
			model.setIbEml               (data.getIbEml               ());
			model.setObPhnNo            (data.getObPhnNo            ()); 
			model.setIbPhnNo            (data.getIbPhnNo            ()); 
			model.setObFaxNo            (data.getObFaxNo            ()); 
			model.setIbFaxNo            (data.getIbFaxNo            ()); 
			model.setXchRtDivCd        (data.getXchRtDivCd        ());  
			model.setCngIndivCd         (data.getChngIndivCd        ()); 
			model.setDyXchAplyStDt    (data.getDyXchApplStrtDt    ());   
			model.setIssDivCd           (data.getIssDivCd           ()); 
			model.setBankAcctNo         (data.getBankAcctNo         ()); 
			model.setCntcPsonNm         (data.getCntcPsonNm         ()); 
			model.setCustCrDueDtDivCd(data.getDueDtCrteDivCd     ());
			model.setOwnrNm              (data.getOwnrNm              ());
			model.setBzctNm              (data.getBzctNm              ());
			model.setBztpNm              (data.getBztpDesc            ());
			model.setPayDtDy1           (data.getPayDtDy1           ()); 
			model.setPayDtDy2           (data.getPayDtDy2           ()); 
			model.setPayDtDy3           (data.getPayDtDy3           ()); 
			model.setPayDtDy4           (data.getPayDtDy4           ()); 
			model.setLoclNm              (data.getLoclNm              ());
			model.setLoclAddr1           (data.getLoclAddr1           ());
			model.setLoclAddr2           (data.getLoclAddr2           ());
			model.setLoclAddr3           (data.getLoclAddr3           ());
			model.setLoclAddr4           (data.getLoclAddr4           ());
			model.setLoclZipCd          (data.getLoclZipCd          ());
			model.setBfrCrCltOfcCd    (data.getBfrCrCltOfcCd    ());   
			model.setBfrOfcCngDt       (data.getBfrOfcChngDt       ());
			model.setBfrKrIbOfcCd     (data.getBfrKrIbOfcCd     ());   
			model.setInvDueDtDpFlg    (data.getInvDueDtDpFlg    ());   
			model.setCreUsrId           (data.getCreUsrId           ()); 
			model.setCreDt               (data.getCreDt               ());
			model.setUpdUsrId           (data.getUpdUsrId           ()); 
			model.setUpdDt               (data.getUpdDt               ());
			model.setDeltFlg             (data.getDeltFlg             ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setRissInvFlg(data.getRissInvFlg());
			model.setInvIssCurrTpCd(data.getInvIssCurrTpCd());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());  // 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
			model.setCustRlseCtrlRmk(data.getCustRlseCtrlRmk());   // 2012.03.15 컬럼추가 KIM HYUN HWA
		    model.setSubSysNm(data.getSubSysNm());
		    model.setAutoInvIbFlg(data.getAutoInvIbFlg());
		    model.setAutoInvIbHjsRefNo(data.getAutoInvIbHjsRefNo());
		    model.setAutoInvIbHjsRefPhnNo(data.getAutoInvIbHjsRefPhnNo());
		    model.setAutoInvIbCustRefNoFlg(data.getAutoInvIbCustRefNoFlg());
		    model.setAutoInvIbLoclChgFlg(data.getAutoInvIbLoclChgFlg());
		    model.setAutoInvIbEml(data.getAutoInvIbEml());
		    model.setAutoInvObFlg(data.getAutoInvObFlg());
		    model.setAutoInvObHjsRefNo(data.getAutoInvObHjsRefNo());
		    model.setAutoInvObHjsRefPhnNo(data.getAutoInvObHjsRefPhnNo());
		    model.setAutoInvObCustRefNoFlg(data.getAutoInvObCustRefNoFlg());
		    model.setAutoInvObLoclChgFlg(data.getAutoInvObLoclChgFlg());
		    model.setAutoInvObEml(data.getAutoInvObEml());
		    
		    model.setPayDtDy5(data.getPayDtDy5());
		    model.setPayWkDyCd(data.getPayWkDay()); 
		    model.setPayTpCd(data.getPayTpCd());
		    
			models.add(model);
//			log.info("getCustCntCd=================>" + data.getCustCntCd());
//			log.info("getCustSeq==============>" + data.getCustSeq());
//			log.info("getActCustCntCd==============>" + data.getActCustCntCd());
//			log.info("getActCustSeq==============>" + data.getActCustSeq());
//			log.info("getCustRlseCtrlFlg==============>" + data.getCustRlseCtrlFlg());
//			log.info("getCrFlg==============>" + data.getCrFlg());
//			log.info("getCrCurrCd=============>" + data.getCrCurrCd());
//			log.info("getCrAmt=============>" + data.getCrAmt());
//			log.info("getCrCltOfcCd=============>" + data.getCrCltOfcCd());
//			log.info("getCrCustRmk=============>" + data.getCrCustRmk());
//			log.info("getIbCrTermDys=============>" + data.getIbCrTermDys());
//			log.info("getObCrTermDys=============>" + data.getObCrTermDys());
//			log.info("getPayDivCd=============>" + data.getPayDivCd());
//			log.info("getCrStrtDt=======>" + data.getCrStrtDt());
//			log.info("getCrEndDt===>" + data.getCrEndDt());
//			log.info("getCrCustTpCd===============>" + data.getCrCustTpCd());
//			log.info("getKrIbOfcCd===============>" + data.getKrIbOfcCd());
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
			log.info(" (createMDM_CR_CUST) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CR_CUST) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMDMCRCUST메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	@SuppressWarnings("unchecked")
//	public boolean createMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//
//		try {
//			isSuccessful = dbDao.addMdmCrCust(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 addMDMCRCUST메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;	
		try {
			
			CreateMdmCrCustVO model = null;
//			ModifyMdmCrCustVO model2 = null;
			Iterator<CreateMdmCrCustVO> itr = models.iterator();
//			Iterator<ModifyMdmCrCustVO> itr2 = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmCrCustVO)itr.next();
			}	
//			while (itr2.hasNext()) {
//				model2 = (ModifyMdmCrCustVO)itr2.next();
//			}	
//			log.info("createMDMTBmodels====================>" + models);
			String cust_cnt_cd = model.getCustCntCd();
			String cust_seq = model.getCustSeq();
			int insCnt = 0;
			log.info("cust_cnt_cd====================>" + cust_cnt_cd);
			log.info("cust_seq====================>" + cust_seq);
			boolean isNew = dbDao.searchMdmCrCust(cust_cnt_cd, cust_seq);
			log.info("createMDMTBmodel====================>" + model);
//			log.info("createMDMTBmodel2====================>" + model2);
			if ( isNew ) insCnt = dbDao.addMdmCrCust(model);
			else insCnt = dbDao.modifyMdmCrCust(model);
							
			if( insCnt > 0 ) isSuccessful = true;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}

	/** DBDAO의 removeMDMCRCUST메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
//	public boolean removeMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//
//		try {
//			isSuccessful = dbDao.removeMdmCrCust(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 removeMDMCRCUST메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			CreateMdmCrCustVO model = null;
			Iterator<CreateMdmCrCustVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (CreateMdmCrCustVO)itr.next();
			}

			log.info("removeMDMTBmodel====================>" + model);
			
			delCnt = dbDao.removeMdmCrCust(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
