/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CHKMAIL_ADDRBCImpl
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-22
 *@LastModifier : yujin
 *@LastVersion : 1.0
 * 2007-10-22 yujin
 * 1.0 최초 생성
 * 2010.07.07 Kim Min Ah
* - EAI_IF_ID 필드 관련 내역 추가
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCarrierDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0600001Document;
import com.hanjin.irep.mdm.MDM0600001Document.MDM0600001;
import com.hanjin.syscommon.common.table.MdmCarrierVO;


/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0580001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author yujin
 * @see ReceiveQueueBC,MDM0580001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCarrierBCImpl extends BasicCommandSupport implements ReceiveQueueBC {

	
	private transient ReceiveQueueMdmCarrierDBDAO dbDao = null;
	private String msgCreDt = "";
	private String opCd = "";
	
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
		
	/** ReceiveQueueMDM_CARRIER_BCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCarrierBCImpl() {
		dbDao = new ReceiveQueueMdmCarrierDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmCarrierVO> receiveMDMTB(XmlObject xmlObject) {
		
		MdmCarrierVO mdmCarrierVO = null;
		List<MdmCarrierVO> mdmCarrierVOs = new ArrayList<MdmCarrierVO>();
		
		MDM0600001Document mdmDoc = (MDM0600001Document) xmlObject;
		MDM0600001 mdm = mdmDoc.getMDM0600001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		
		log.info("\n //--->>> OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n //--->>> MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0600001Document.MDM0600001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			mdmCarrierVO = new MdmCarrierVO();
			mdmCarrierVO.setCrrCd(data.getCarrCd());
			mdmCarrierVO.setCrrNm(data.getCarrNm());
			mdmCarrierVO.setBkgEdiCd(data.getCarrEdi());
			mdmCarrierVO.setMapgCrrCd(data.getCarrMap());
			mdmCarrierVO.setCreUsrId(data.getCreUsrId());
			mdmCarrierVO.setCreDt(data.getCreDt());
			mdmCarrierVO.setUpdUsrId(data.getUpdUsrId());
			mdmCarrierVO.setUpdDt(data.getUpdDt());
			mdmCarrierVO.setDeltFlg(data.getDeltFlg());
			mdmCarrierVO.setEaiIfId(mdm.getEAIHeader().getInstanceId());

			mdmCarrierVOs.add(mdmCarrierVO);
		}
		return mdmCarrierVOs;
	}

	/** Create or Remove  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		
		try {
			MdmCarrierVO model = null;
			
			Iterator<MdmCarrierVO> itr = models.iterator();
			
			while (itr.hasNext()) {
				model = (MdmCarrierVO)itr.next();
			}
			
			String crr_cd = model.getCrrCd();
			
			int insCnt = 0;
			boolean isNew = dbDao.searchMdmCarrier(crr_cd);
			
			if ( isNew ) insCnt = dbDao.addMdmCarrier(model);
			else insCnt = dbDao.modifyMdmCarrier(model);
			
			if( insCnt > 0 ) isSuccessful = true;
			
		}catch(DAOException de){
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}

	/** DBDAO의 addMDM_CHKMAIL_ADDR메소드 호출  
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
			log.info(" (createMDM_CARRIER) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CARRIER) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 removeMDM_CHKMAIL_ADDR메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			MdmCarrierVO model = null;
			Iterator<MdmCarrierVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmCarrierVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmCarrier(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
