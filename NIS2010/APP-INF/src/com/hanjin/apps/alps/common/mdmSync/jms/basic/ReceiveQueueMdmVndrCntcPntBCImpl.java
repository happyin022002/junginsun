/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVndrCntcPntBCImpl.java
 *@FileTitle : NIS2010 Mdm VENDOR CONTACT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-23
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.0
 * 2009-09-23 Sun, Choi
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVndrCntcPntDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmVndrCntcPntVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0220001Document;
import com.hanjin.irep.mdm.MDM0220001Document.MDM0220001;
 
/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0220001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Sun, Choi
 * @see ReceiveQueueBC,MDM0220001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVndrCntcPntBCImpl  extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmVndrCntcPntDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** opCd getter 메서드.<br>
	 * @return 
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

	/** ReceiveQueueMDM_VENDOR_CONTACTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVndrCntcPntBCImpl() {
		dbDao = new ReceiveQueueMdmVndrCntcPntDBDAO();
	}

	/** MsgCreDt getter 메서드.<br>
	 * @return 
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
	
	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<SearchMdmVndrCntcPntVO> receiveMDMTB(XmlObject xmlObject) {
		SearchMdmVndrCntcPntVO model = null;
		Collection<SearchMdmVndrCntcPntVO> models = new ArrayList<SearchMdmVndrCntcPntVO>();

		MDM0220001Document mdmDoc = (MDM0220001Document) xmlObject;
		MDM0220001 mdm = mdmDoc.getMDM0220001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());
		// /===== Collect received data & Allocate them to Collection models
		// =====
		com.hanjin.irep.mdm.MDM0220001Document.MDM0220001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new SearchMdmVndrCntcPntVO();
			
			model.setVndrSeq	        (data.getVndrSeq         ()); 
			model.setVndrCntcPntSeq  (data.getVndrCntcPntSeq  ());  // Changed By Kim Jin-seung In 2007-06-07
			model.setIntlPhnNo        (data.getIntlPhnNo       ());
			model.setPhnNo             (data.getPhnNo           ());
			model.setIntlFaxNo        (data.getIntlFaxNo       ());
			model.setFaxNo             (data.getFaxNo           ());
			model.setVndrEml           (data.getVndrEml         ());
			model.setEaiEvntDt        (getMsgCreDt       		 ());

			// As DB Table Schema was Changed ... Added By Kim Jin-seung In 2007-06-07 
			model.setPrmryChkFlg(data.getVndrCntcPrmryFlg());
			model.setDeltFlg(data.getDeltFlg());
			model.setCreDt(data.getCreDt());
			model.setCreUsrId(data.getCreUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setUpdUsrId(data.getUpdUsrId());
			
			model.setCntcDivCd(data.getCntcDivCd()); 
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			
			models.add(model);

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
			log.info(" (createMDM_VNDR_CNTC_PNT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			// As xsd (MDM022-0001) was changed ... done By Kim Jin-seung In 2007-06-07
			// isSuccessFlag = removeMDMTB(models); // Same with Update Case
			isSuccessFlag = createMDMTB(models); // Same with Update Case
			log.info(" (removeMDM_VNDR_CNTC_PNT) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
	
	/** DBDAO의 addMDMVNDRCNTCPNT메소드 호출  
	 * @param models Collection
	 * @return 
	 * @throws DAOException 
	 */
//	public boolean createMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		try {
//			isSuccessful = dbDao.addMdmVndrCntcPnt(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}

	/** DBDAO의 addMDMVNDRCNTCPNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		
		try {
			
			SearchMdmVndrCntcPntVO model = null;
//			ModifyMdmVndrCntcPntVO model2 = null;
			Iterator<SearchMdmVndrCntcPntVO> itr = models.iterator();
//			Iterator<ModifyMdmVndrCntcPntVO> itr2 = models.iterator();
			while (itr.hasNext()) {
				model = (SearchMdmVndrCntcPntVO)itr.next();
			}
//			while (itr2.hasNext()) {
//				model2 = (ModifyMdmVndrCntcPntVO)itr2.next();
//			}	
			String vndr_seq = model.getVndrSeq();
			String vndr_cntc_pnt_seq = model.getVndrCntcPntSeq();
			int insCnt = 0;
			
			boolean isNew = dbDao.searchMdmVndrCntcPnt(vndr_seq, vndr_cntc_pnt_seq);
			
			if ( isNew ) insCnt = dbDao.addMdmVndrCntcPnt(model);
			else insCnt = dbDao.modifyMdmVndrCntcPnt(model);
							
			if( insCnt > 0 ) isSuccessful = true;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}
	
	/** DBDAO의 removeMDMVNDRCNTCPNT메소드 호출  
	 * @param models Collection
	 * @return 
	 * @throws DAOException 
	 */
//	public boolean removeMDMTB(Collection models) throws DAOException{
//		boolean isSuccessful = false;
//		try {
//			isSuccessful = dbDao.removeMdmVndrCntcPnt(models);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw de;
//		}
//		return isSuccessful;
//	}
	
	/** DBDAO의 removeMDMVNDRCNTCPNT메소드 호출  
	 * @param models Collection
	 * @return 
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			
			SearchMdmVndrCntcPntVO model = null;
			Iterator<SearchMdmVndrCntcPntVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (SearchMdmVndrCntcPntVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmVndrCntcPnt(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
