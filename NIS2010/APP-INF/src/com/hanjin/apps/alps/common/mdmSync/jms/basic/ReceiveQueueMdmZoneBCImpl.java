/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONEBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-05
 *@LastModifier : Kim Kwijin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmZoneDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmYardVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0500001Document;
import com.hanjin.irep.mdm.MDM0500001Document.MDM0500001;
import com.hanjin.syscommon.common.table.MdmCustPerfGrpVO;
import com.hanjin.syscommon.common.table.MdmZone;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0500001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0500001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZoneBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmZoneDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_ZONEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmZoneBCImpl() {
		dbDao = new ReceiveQueueMdmZoneDBDAO();
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
	public Collection<MdmZoneVO> receiveMDMTB(XmlObject xmlObject) {

		MdmZoneVO model = null;
		Collection<MdmZoneVO> models = new ArrayList<MdmZoneVO>();

		MDM0500001Document mdmDoc = (MDM0500001Document) xmlObject;
		MDM0500001 mdm = mdmDoc.getMDM0500001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0500001Document.MDM0500001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmZoneVO();
			model.setZnCd			(data.getZnCd());
			model.setZnNm          (data.getZnNm());
			model.setRepYdCd      (data.getRepreYdCd      ()); 
			model.setLocCd         (data.getLocCd         ());
			model.setCgoHndlTmHrs(data.getCgoHndlTmHors()); 
			model.setDistUtCd     (data.getDistUtCd     ()); 
			model.setLnkDist       (data.getLnkDist       ());
			model.setTztmHrs       (data.getTztmHors       ());
			model.setCreUsrId     (data.getCreUsrId     ()); 
			model.setCreDt         (data.getCreDt        ()); 
			model.setUpdUsrId     (data.getUpdUsrId     ()); 
			model.setUpdDt         (data.getUpdDt         ());
			model.setDeltFlg       (data.getDeltFlg       ());
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
			log.info(" (createMDM_ZONE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_ZONE) isSucessFlag : "
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
		MdmZoneVO model = null;
		String zn_cd = null;
		String nod_cd = null;
		try{
			Iterator<MdmZoneVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmZoneVO)itr.next();
				zn_cd = model.getZnCd();
				nod_cd = model.getZnCd();
				if(dbDao.searchMDM_ZONEList(zn_cd)){
					if ( zn_cd != null && zn_cd.trim().length() > 0 ) {
						dbDao.addMdmZone(model);
					}	
				}else{
					if ( zn_cd !=null && zn_cd.trim().length() > 0 ){
						dbDao.modifyZone(model);
					}
				}
				
				if(dbDao.searchPRD_NODEList(nod_cd)){
					if ( nod_cd != null  && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ) {
						dbDao.addPrdNode(model);
					}
				}else{
					if ( nod_cd !=null && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ){
						dbDao.modifyPrdNode(model);
					}
				}
				
			} 
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		isSuccessful = true;
		return isSuccessful;
		
	}
	

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false; 
		MdmZoneVO model = null;
		String yd_cd = null;
		try{
			Iterator<MdmZoneVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmZoneVO)itr.next();
				yd_cd = model.getZnCd();
				if ( yd_cd !=null && yd_cd.trim().length() > 0 
						&& ! dbDao.searchMDM_ZONEList(yd_cd)) {
					dbDao.removeMdmZone(model);
					
				}
				dbDao.removePrdNode(model);
			} 
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		isSuccessful = true;
		return isSuccessful;
		
	}
	
}
