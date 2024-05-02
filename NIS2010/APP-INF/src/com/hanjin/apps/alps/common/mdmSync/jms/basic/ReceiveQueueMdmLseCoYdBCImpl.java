/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmLseCoYdBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 * No.	Ver.		Modifier           					modifier date    explanation
 * 1		1.0		Kim Jung-Jae					2007-02-26		1.0 최초 생성
 * 2      	1.0      	Lee Byoung Hun				2009.09.09		New Framework 적용 Renewal
 *
 *@LastModifyDate : 2009.09.09
 *@LastModifier : Lee Byoung Hun
 *@LastVersion : 1.0
 * 2009.09.09 Lee Byoung Hun
 * New Framework 적용 Renewal
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmLseCoYdDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0550001Document;
import com.hanjin.irep.mdm.MDM0550001Document.MDM0550001;
import com.hanjin.syscommon.common.table.MdmLseCoYdVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0550001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0550001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmLseCoYdBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmLseCoYdDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_LEAS_YARDBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmLseCoYdBCImpl() {
		dbDao = new ReceiveQueueMdmLseCoYdDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveMDMTB(XmlObject xmlObject) {
		MdmLseCoYdVO model = null;
		Collection models = new ArrayList();

		MDM0550001Document mdmDoc = (MDM0550001Document) xmlObject;
		MDM0550001 mdm = mdmDoc.getMDM0550001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models
		// =====
		com.hanjin.irep.mdm.MDM0550001Document.MDM0550001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmLseCoYdVO();
			model.setLseCoYdCd(data.getLeasingCoYdCd());
			model.setLseCoYdNm(data.getLeasingCoYdNm());
			model.setOnfHirYdFlg(data.getOnoffHireYdFlg());
			model.setYdAddr(data.getYdAddr());
			model.setIntlPhnNo(data.getIntlPhnNo());
			model.setPhnNo(data.getPhnNo());
			model.setFaxNo(data.getFaxNo());
			model.setYdPicNm(data.getYdPicNm());
			model.setYdEml(data.getYdEml());
			model.setLseCoVndrSeq1(data.getLeasingCoVndrSeq1());
			model.setLseCoVndrSeq2(data.getLeasingCoVndrSeq2());
			model.setLseCoVndrSeq3(data.getLeasingCoVndrSeq3());
			model.setLseCoVndrSeq4(data.getLeasingCoVndrSeq4());
			model.setLseCoVndrSeq5(data.getLeasingCoVndrSeq5());
			model.setLseCoVndrSeq6(data.getLeasingCoVndrSeq6());
			model.setLseCoVndrSeq7(data.getLeasingCoVndrSeq7());
			model.setLseCoVndrSeq8(data.getLeasingCoVndrSeq8());
			model.setLseCoVndrSeq9(data.getLeasingCoVndrSeq9());
			model.setLseCoVndrSeq10(data.getLeasingCoVndrSeq10());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setLseCoVndrSeq11(data.getLeasingCoVndrSeq11());
			model.setLseCoVndrSeq12(data.getLeasingCoVndrSeq12());
			model.setLseCoVndrSeq13(data.getLeasingCoVndrSeq13());
			model.setLseCoVndrSeq14(data.getLeasingCoVndrSeq14());
			model.setLseCoVndrSeq15(data.getLeasingCoVndrSeq15());
			model.setLseCoVndrSeq16(data.getLeasingCoVndrSeq16());
			model.setLseCoVndrSeq17(data.getLeasingCoVndrSeq17());
			model.setLseCoVndrSeq18(data.getLeasingCoVndrSeq18());
			model.setLseCoVndrSeq19(data.getLeasingCoVndrSeq19());
			model.setLseCoVndrSeq20(data.getLeasingCoVndrSeq20());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			models.add(model);
		}
		return models;
	}

	/** DBDAO의 addMDM_LSE_CO_YD메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		List<MdmLseCoYdVO> addModels = new ArrayList<MdmLseCoYdVO>();
		List<MdmLseCoYdVO> modifyModels = new ArrayList<MdmLseCoYdVO>();
		
		boolean isSuccessful = false;
		
		try {
			Iterator itr = models.iterator();
			
			MdmLseCoYdVO model = null;
			String lse_co_yd_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmLseCoYdVO)itr.next();
				lse_co_yd_cd = model.getLseCoYdCd();
				
				if (dbDao.searchMDM_LSE_CO_YDList(lse_co_yd_cd)) {
					if ( lse_co_yd_cd !=null && lse_co_yd_cd.trim().length() > 0 ) {
						addModels.add(model);
					}
				} else {
					if(lse_co_yd_cd !=null && lse_co_yd_cd.trim().length() > 0){
						modifyModels.add(model);
					}
				}
			}
			
			if ( addModels.size() > 0 ) {
				isSuccessful = dbDao.addMdmLseCoYd(addModels);
			}
			
			if ( modifyModels.size() > 0 ) {
				isSuccessful = dbDao.modifyMdmLseCoYd(modifyModels);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}

	/** DBDAO의 removeMDM_LSE_CO_YD메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		List<MdmLseCoYdVO> removeModels = new ArrayList<MdmLseCoYdVO>();
		
		boolean isSuccessful = false;
		
		try {
			Iterator itr = models.iterator();
			
			MdmLseCoYdVO model = null;
			String lse_co_yd_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmLseCoYdVO)itr.next();
				lse_co_yd_cd = model.getLseCoYdCd();
				
				if ( lse_co_yd_cd !=null && lse_co_yd_cd.trim().length() > 0 
						&& !dbDao.searchMDM_LSE_CO_YDList(lse_co_yd_cd)) {
					removeModels.add(model);
				}
			}
			
			if ( removeModels.size() > 0 ) {
				isSuccessful = dbDao.removeMdmLseCoYd(removeModels);
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
			log.info(" (createMDM_LSE_CO_YD) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_LSE_CO_YD) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}
