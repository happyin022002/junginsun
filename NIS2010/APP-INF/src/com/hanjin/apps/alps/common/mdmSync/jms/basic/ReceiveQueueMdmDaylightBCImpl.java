/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmDaylightBCImpl
 *@FileTitle : ALPS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-22
 *@LastModifier : yujin
 *@LastVersion : 1.0
 * 2007-10-22 yujin
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmDaylightDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0610001Document;
import com.hanjin.irep.mdm.MDM0610001Document.MDM0610001;
import com.hanjin.syscommon.common.table.MdmDylgtSavTmVO;


/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0610001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author yujin
 * @see ReceiveQueueBC,MDM0610001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmDaylightBCImpl extends BasicCommandSupport implements ReceiveQueueBC {

	
	private transient ReceiveQueueMdmDaylightDBDAO dbDao = null;
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
		
	/** ReceiveQueueMDM_Daylight_BCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmDaylightBCImpl() {
		dbDao = new ReceiveQueueMdmDaylightDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmDylgtSavTmVO> receiveMDMTB(XmlObject xmlObject) {
		
		MdmDylgtSavTmVO mdmDylgtSavTmVO = null;
		List<MdmDylgtSavTmVO> mdmDylgtSavTmVOs = new ArrayList<MdmDylgtSavTmVO>();
		
		MDM0610001Document mdmDoc = (MDM0610001Document) xmlObject;
		MDM0610001 mdm = mdmDoc.getMDM0610001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		
		log.info("\n //--->>> OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n //--->>> MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0610001Document.MDM0610001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			mdmDylgtSavTmVO = new MdmDylgtSavTmVO();
		
			mdmDylgtSavTmVO.setDstId(data.getDstId());
			mdmDylgtSavTmVO.setDstCntCd(data.getDstCntCd());
			mdmDylgtSavTmVO.setDstNotAplySteCd(data.getDstSteCd());
			mdmDylgtSavTmVO.setDstYr(data.getDstYr());
			mdmDylgtSavTmVO.setDstMnts(data.getDstMnts());
			mdmDylgtSavTmVO.setStDstRuleDesc(data.getStDstRuleDesc());
			mdmDylgtSavTmVO.setEndDstRuleDesc(data.getEndDstRuleDesc());
			mdmDylgtSavTmVO.setStDstDt(data.getStDstDt());
			mdmDylgtSavTmVO.setEndDstDt(data.getEndDstDt());
			mdmDylgtSavTmVO.setStDstHrmnt(data.getStDstHrmnt());
			mdmDylgtSavTmVO.setEndDstHrmnt(data.getEndDstHrmnt());
			mdmDylgtSavTmVO.setCreUsrId(data.getCreUsrId());
			mdmDylgtSavTmVO.setCreDt(data.getCreDt());
			mdmDylgtSavTmVO.setUpdUsrId(data.getUpdUsrId());
			mdmDylgtSavTmVO.setUpdDt(data.getUpdDt());
			mdmDylgtSavTmVO.setDeltFlg(data.getDeltFlg());
		
			mdmDylgtSavTmVOs.add(mdmDylgtSavTmVO);
		}
		return mdmDylgtSavTmVOs;
	}

	/** Create or Remove  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		
		try {
			MdmDylgtSavTmVO model = null;
			
			Iterator<MdmDylgtSavTmVO> itr = models.iterator();
			
			while (itr.hasNext()) {
				model = (MdmDylgtSavTmVO)itr.next();
			}
			
			String dst_id = model.getDstId();
			
			int insCnt = 0;
			boolean isNew = dbDao.searchMdmDaylight(dst_id);
			
			if ( isNew ) insCnt = dbDao.addMdmDaylight(model);
			else insCnt = dbDao.modifyMdmDaylight(model);
			
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
			log.info(" (createMDM_DYLGT_SAV_TM) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_DYLGT_SAV_TM) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 removeMDM_Daylight메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			MdmDylgtSavTmVO model = null;
			Iterator<MdmDylgtSavTmVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmDylgtSavTmVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmDaylight(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
