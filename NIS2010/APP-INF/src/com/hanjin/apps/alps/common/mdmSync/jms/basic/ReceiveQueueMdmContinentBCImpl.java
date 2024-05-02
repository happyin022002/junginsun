/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CONTINENTBCImpl.java
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
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmContinentDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0460001Document;
import com.hanjin.irep.mdm.MDM0460001Document.MDM0460001;
import com.hanjin.syscommon.common.table.MdmContinent;
import com.hanjin.syscommon.common.table.MdmContinentVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0460001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0460001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmContinentBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmContinentDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_CONTINENTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmContinentBCImpl() {
		dbDao = new ReceiveQueueMdmContinentDBDAO();
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
	public List<MdmContinentVO> receiveMDMTB(XmlObject xmlObject) {	
		List<MdmContinentVO> MdmContinentVOs = new ArrayList<MdmContinentVO>();
		
		MDM0460001Document mdmDoc = (MDM0460001Document) xmlObject;
		MDM0460001 mdm = mdmDoc.getMDM0460001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0460001Document.MDM0460001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			
			MdmContinentVO mdmContinentVO = new MdmContinentVO();
			
			mdmContinentVO.setContiCd   (data.getContiCd   ());
			mdmContinentVO.setContiNm   (data.getContiNm   ());
			mdmContinentVO.setCreUsrId (data.getCreUsrId ()); 
			mdmContinentVO.setCreDt     (data.getCreDt    ()); 
			mdmContinentVO.setUpdUsrId (data.getUpdUsrId ()); 
			mdmContinentVO.setUpdDt     (data.getUpdDt     ());
			mdmContinentVO.setDeltFlg   (data.getDeltFlg   ());
			mdmContinentVO.setEaiEvntDt(getMsgCreDt());
			mdmContinentVO.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			
			MdmContinentVOs.add(mdmContinentVO);
		}
		
		return MdmContinentVOs;
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
			log.info(" (createMDM_CONTINENT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CONTINENT) isSucessFlag : "
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
		List<MdmContinentVO> MdmContinentVOs = (List<MdmContinentVO>)models;
		boolean inUpFlag	= false;
		
		try {
			
			for(int i=0; MdmContinentVOs!=null && i<MdmContinentVOs.size(); i++){
				MdmContinentVO mdmContinentVO = new MdmContinentVO();
				mdmContinentVO = MdmContinentVOs.get(i);

				inUpFlag = dbDao.searchMdmContinentList(mdmContinentVO.getContiCd());
				
				if(inUpFlag){//insert
					isSuccessful = dbDao.addMdmContinent(mdmContinentVO);
				}else{
					isSuccessful = dbDao.addMdmContinentUpdate(mdmContinentVO);
				}
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
		boolean isSuccessful = false;
		List<MdmContinentVO> MdmContinentVOs = (List<MdmContinentVO>)models;

		try {
			isSuccessful = dbDao.removeMdmContinent(MdmContinentVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
