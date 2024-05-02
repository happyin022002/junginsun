/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmLocationBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmLocationDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0310001Document;
import com.hanjin.irep.mdm.MDM0310001Document.MDM0310001;
import com.hanjin.syscommon.common.table.MdmLocationVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmLocationBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmLocationDBDAO dbDao = null;

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

	/** ReceiveQueueMdmLocationBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmLocationBCImpl() {
		dbDao = new ReceiveQueueMdmLocationDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		
		MdmLocationVO model = null;
		Collection models = new ArrayList();

		MDM0310001Document mdmDoc = (MDM0310001Document) xmlObject;
		MDM0310001 mdm = mdmDoc.getMDM0310001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models
		com.hanjin.irep.mdm.MDM0310001Document.MDM0310001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			
			model = new MdmLocationVO();
			
			model.setLocCd(data.getLocCd());
			model.setSccCd(data.getSccCd());
			model.setLocNm(data.getLocNm());
			model.setRgnCd(data.getRgnCd());
			model.setCntCd(data.getCntCd());
			model.setSteCd(data.getSteCd());
			model.setContiCd(data.getContiCd());
			model.setScontiCd(data.getScontiCd()); //2007.05.16 modify
			model.setPortInlndCd(data.getPortInlndCd());
			model.setLocChrCd(data.getLocChrCd());
			model.setBlkPortFlg(data.getBlkPortFlg());
			model.setHubLocCd(data.getHubLocCd());
			model.setSlsOfcCd(data.getSlsOfcCd());
			model.setLocGrdNo(data.getLocGrdNo());
			model.setGmtHrs(data.getGmtHors());		// 20090907 kys set, get member 변수 명 다름...
			model.setBkgBlPfxCd(data.getBkgBlPfxCd());
			model.setCallPortFlg(data.getCallPortFlg());
			model.setLocAmsPortCd(data.getLocAmsPortCd());
			model.setFincCtrlOfcCd(data.getFincCtrlOfcCd());
			model.setEqCtrlOfcCd(data.getEqCtrlOfcCd());
			model.setMtyPkupYdCd(data.getMtyPkupYdCd());
			model.setSenEqOfcCd(data.getSenEqOfcCd());
			model.setEqRtnYdCd(data.getEqRtnYdCd());
			model.setUnLocIndCd(data.getUnLocFlg());
			model.setUnLocCd(data.getUnLocCd());
			model.setCmlZnFlg(data.getCmlZnFlg());
			model.setCstmsCd(data.getCstmsCd());
			model.setLocTpCd(data.getLocTpCd());
			model.setBfrFincCtrlOfcCd(data.getBfrFincCtrlOfcCd());
			model.setBfrEqCtrlOfcCd(data.getBfrEqCtrlOfcCd());
			model.setBfrSlsOfcCd(data.getBfrSlsOfcCd());
			model.setBfrOfcCngDt(data.getBfrOfcChngDt()); // 20090907 kys set, get member 변수 명 다름...
			model.setRepZnCd(data.getRepZnCd());
			model.setZipCd(data.getZipCd());
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setLocLoclLangNm(data.getLocLoclLangNm());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			if (null!=data.getLocLat() && !"".equals(data.getLocLat())) {
				model.setLocLat(data.getLocLat());
			}
			if (null!=data.getLatUtCd() && !"".equals(data.getLatUtCd())) {
				model.setLatUtCd(data.getLatUtCd());
			}
			if (null!=data.getLocLon() && !"".equals(data.getLocLon())) {
				model.setLocLon(data.getLocLon());
			}
			if (null!=data.getLonUtCd() && !"".equals(data.getLonUtCd())) {
				model.setLonUtCd(data.getLonUtCd());
			}
			models.add(model);
		}
		
		return models;
	}

	/** DBDAO의 addMdmLocation 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		
		boolean isSuccessful = false;
		Iterator itr = models.iterator();
		
		MdmLocationVO model = null;
		String locCd = null;
		String portInlndCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmLocationVO)itr.next();
				locCd = model.getLocCd();
				portInlndCd = model.getPortInlndCd();
	
				if(dbDao.searchMdmLocationList(locCd)){
					if ( locCd != null && locCd.trim().length() > 0 ) {
						dbDao.addMdmLocationInsert(model);
					}	
				}	
				else {
					if( locCd !=null && locCd.trim().length() > 0 ){
						dbDao.addMdmLocationUpdate(model);
					}
				}
				
				if(portInlndCd != null && !"null".equals(portInlndCd) && "Y".equals(portInlndCd.trim())){
					//dbDao.addMDMPORT(model);
					// 현재 주석처리 되어 있으나 주석 해제할 경우 아래와 같이 호출 20090908 kys
					/* start 
					String portCd = locCd;
					if("Y".equals(portInlndCd)){
						if(dbDao.searchMdmPortList(portCd)){
							if ( portCd != null  && !"null".equals(portCd) && portCd.trim().length() > 0 ) {
								dbDao.addMdmPortInsert(model);
							}
						}
						else{
							if ( portCd != null  && !"null".equals(portCd) && portCd.trim().length() > 0 ) {
								dbDao.addMdmPortUpdate(model);
							}
						}
					}	
					end */
				}
			}
			isSuccessful = true;
			
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
		Iterator itr = models.iterator();
		
		MdmLocationVO model = null;
		String locCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmLocationVO)itr.next();
				locCd = model.getLocCd();
				
				if ( locCd !=null && locCd.trim().length() > 0 
						&& !dbDao.searchMdmLocationList(locCd)) {	
					dbDao.removeMdmLocation(model);
				}
				//dbDao.removeMdmPort(model);
			}
			isSuccessful = true;
			
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
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMdmLocation) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMdmLocation) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}
