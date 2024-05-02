/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ACTIVITYBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 2009-09-23 An Jeong-Seon
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmActivityDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0480001Document;
import com.hanjin.irep.mdm.MDM0480001Document.MDM0480001;
import com.hanjin.syscommon.common.table.MdmActivityVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0480001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0480001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmActivityBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmActivityDBDAO dbDao = null;
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

	/** ReceiveQueueMDM_ACTIVITYBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmActivityBCImpl() {
		dbDao = new ReceiveQueueMdmActivityDBDAO();
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

		MdmActivityVO model = null;
		Collection models = new ArrayList();

		MDM0480001Document mdmDoc = (MDM0480001Document) xmlObject;
		MDM0480001 mdm = mdmDoc.getMDM0480001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0480001Document.MDM0480001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmActivityVO(); 
			
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			
			model.setActCd              (data.getActCd         ()); 
			model.setActNm              (data.getActNm         ()); 
			model.setActTpCd           (data.getActTpCd       ()); 
			model.setCreUsrId          (data.getCreUsrId      ()); 
			model.setCreDt              (data.getCreDt         ()); 
			model.setUpdUsrId          (data.getUpdUsrId      ()); 
			model.setUpdDt              (data.getUpdDt         ()); 
			model.setDeltFlg            (data.getDeltFlg       ()); 
			model.setEaiEvntDt		 (getMsgCreDt());
			models.add(model);
		}
		return models;
	}

	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
/*	
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDM_ACTIVITY) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_ACTIVITY) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
*/
	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException{
		log.debug("###   MDM_ACTIVITY - BCImple  ###  ctrlMDMTB Start" );
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.debug("###   MDM_ACTIVITY - BCImple  ###  ctrlMDMTB Start - Creating Table" );
			log.info(" (createMDM_OFFICE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			log.debug("###   MDM_ACTIVITY - BCImple  ###  ctrlMDMTB - Deleting Table" );
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_OFFICE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
		log.debug("###   MDM_ACTIVITY - BCImple  ###  ctrlMDMTB END" );
	}	
	
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		log.debug("###   MDM_Activity - ReceiveQueueMdmActivityDBDAO  ###  createMDMTB Start" );
		boolean isSuccessful = false;
		try {
			//isSuccessful = dbDao.addMDM_OFFICE(models);
			Iterator itr = models.iterator();
			MdmActivityVO model = null;
			String act_cd = null;
			
			while (itr.hasNext()) {
				//getting each VO
				model = (MdmActivityVO)itr.next();
				act_cd = model.getActCd();
				log.info("loc_cd : " + act_cd);
				/*Insert or Update*/
				/*Insert*/
				boolean divisionFalg = dbDao.searchMdmActivityList(act_cd);
				log.debug("###   MDM_Activity - ReceiveQueueMdmActivityDBDAO  ###  createMDMTB - divisionFlag:" +  divisionFalg);
				if(divisionFalg){
					log.debug("###   MDM_Activity - ReceiveQueueMdmActivityDBDAO  ###  Inserting..." );
					//Archiving   just One VO in order to follow the program interface.
					Collection vo = new ArrayList();
					           vo.add(model);
					dbDao.addMdmActivity((List<MdmActivityVO>) vo);
				}else{
					log.debug("###   MDM_Activity - ReceiveQueueMdmActivityDBDAO  ###  Modifying..." );
					//Archiving   just One VO in order to follow the program interface.
					Collection vo = new ArrayList();
			           vo.add(model);
					dbDao.modifyMdmActivity((List<MdmActivityVO>) vo);
				}//if
			}//while
			isSuccessful = true;
		}catch (DAOException de) {
			isSuccessful = false;
			log.error("err " + de.toString(), de);
			throw de;
		}//try
		log.debug("###   MDM_Activity - ReceiveQueueMdmActivityDBDAO  ###  createMDMTB End" );
		return isSuccessful;
	}
	
	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		log.debug("###   MDM_ACTIVITY - ReceiveQueueMdmActivityDBDAO  ###  removeMDMTB Start" );
		boolean isSuccessful = false;
		try {
			Iterator itr = models.iterator();
			MdmActivityVO model = null;
			String act_cd = null;
			
			while (itr.hasNext()) {
				model = (MdmActivityVO)itr.next();
				act_cd = model.getActCd();
				log.info("act_cd : " + act_cd);			
				
				if (act_cd !=null && act_cd.trim().length() > 0 
						&& !dbDao.searchMdmActivityList(act_cd)) {
					
					Collection vo = new ArrayList();
			                   vo.add(model);
			                   dbDao.removeMdmActivity((List<MdmActivityVO>) vo);
				}//if
 			}//while
			
			isSuccessful = true;
		} catch (DAOException de) {
			isSuccessful = false;
			log.error("err " + de.toString(), de);
			throw de;
		}
		log.debug("###   MDM_ACTIVITY - ReceiveQueueMdmActivityDBDAO  ###  removeMDMTB End" );
		return isSuccessful;
	}

	
}
