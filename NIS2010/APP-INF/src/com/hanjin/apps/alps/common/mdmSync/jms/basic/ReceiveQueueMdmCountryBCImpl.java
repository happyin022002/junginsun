/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_COUNTRYBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCountryDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0320001Document;
import com.hanjin.irep.mdm.MDM0320001Document.MDM0320001;
import com.hanjin.syscommon.common.table.MdmCountryVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0320001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0320001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCountryBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmCountryDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** ReceiveQueueMDM_COUNTRYBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCountryBCImpl() {
		dbDao = new ReceiveQueueMdmCountryDBDAO();
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
	public Collection<MdmCountryVO> receiveMDMTB(XmlObject xmlObject) {
		MdmCountryVO model = null;
		Collection<MdmCountryVO> models = new ArrayList<MdmCountryVO>();

		MDM0320001Document mdmDoc = (MDM0320001Document) xmlObject;
		MDM0320001 mdm = mdmDoc.getMDM0320001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models =====
		com.hanjin.irep.mdm.MDM0320001Document.MDM0320001.DataArea data = mdm.getDataArea();
		if (data != null) {
			
			model = new MdmCountryVO();
			
			model.setCntCd(data.getCntCd());
			model.setCntNm(data.getCntNm());
			model.setScontiCd(data.getScontiCd());
			model.setCurrCd(data.getIsoCurrCd());
			model.setFrgnVatFlg(data.getFrgnVatFlg());
			model.setZnDivBselCd(data.getZnDivBaselineCd());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setCntIsoCd(data.getCntIsoCd());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			model.setEuCntFlg(data.getEuCntFlg());
			model.setEmlDsclmCtnt(data.getEmlDsclmCtnt());
			
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
			
			MdmCountryVO model = null;
			Iterator<MdmCountryVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmCountryVO)itr.next();
			}	
			
			String cnt_cd = model.getCntCd();
			int insCnt = 0;
			
			boolean isNew = dbDao.searchMdmCountry(cnt_cd);
			
			if ( isNew ) insCnt = dbDao.addMdmCountryInsert(model);		//insert
			else insCnt = dbDao.addMdmCountryUpdate(model);  			//update
							
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
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int insCnt = 0;
		try {
			
			MdmCountryVO model = null;
			Iterator<MdmCountryVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmCountryVO)itr.next();
			}
			
			insCnt = dbDao.removeMdmCountry(model);
			
			if( insCnt > 0 ) isSuccessful = true;
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
		
		if (OpCd.equals("C") || OpCd.equals("U")) OpCd = "U";
		
		boolean isSuccessFlag = false;

		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDMCOUNTRY) isSucessFlag : " + isSuccessFlag );
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDMCOUNTRY) isSucessFlag : " + isSuccessFlag );
			break;
		}	
	}

	/** MsgCreDt getter 메서드.*/
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
