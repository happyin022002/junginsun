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
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVendorEtcDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0590001Document;
import com.hanjin.irep.mdm.MDM0590001Document.MDM0590001;
//import com.hanjin.syscommon.common.table.MdmChkmailAddr;
import com.hanjin.syscommon.common.table.MdmVendorVO;


/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0590001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author yujin
 * @see ReceiveQueueBC,MDM0590001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVendorEtcBCImpl extends BasicCommandSupport implements ReceiveQueueBC {

	
	private transient ReceiveQueueMdmVendorEtcDBDAO dbDao = null;
	private String msgCreDt = "";
	private String opCd = "";
		
	/** ReceiveQueueMDM_VENDOR_TOTALBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVendorEtcBCImpl() {
		dbDao = new ReceiveQueueMdmVendorEtcDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
//		MdmChkmailAddr model = null;
//		Collection models = new ArrayList();
//		List<MdmVendorVO> models = new ArrayList<MdmVendorVO>();
		MdmVendorVO mdmVendorVO = null;
		List<MdmVendorVO> mdmVendorVOs = new ArrayList<MdmVendorVO>();
		MDM0590001Document mdmDoc = (MDM0590001Document) xmlObject;
		MDM0590001 mdm = mdmDoc.getMDM0590001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("\n //--->>> OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n //--->>> MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0590001Document.MDM0590001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			mdmVendorVO = new MdmVendorVO();
			mdmVendorVO.setVndrSeq(data.getVndrSeq());
			mdmVendorVO.setChkDeAddr1(data.getChkDeAddr1());
			mdmVendorVO.setChkDeAddr2(data.getChkDeAddr2());
			mdmVendorVO.setChkDeAddr3(data.getChkDeAddr3());
			mdmVendorVO.setChkDeCntCd(data.getChkDeCntCd());
			mdmVendorVO.setChkDeCtyNm(data.getChkDeCtyNm());
			mdmVendorVO.setChkDeSteCd(data.getChkDeSteCd());
			mdmVendorVO.setChkDeZipCd(data.getChkDeZipCd());
			mdmVendorVO.setCreDt(data.getCreDt());
			mdmVendorVO.setCreUsrId(data.getCreUsrId());
			mdmVendorVO.setEaiEvntDt(getMsgCreDt());
			mdmVendorVO.setLuDeltFlg(data.getDeltFlg());
			mdmVendorVO.setUpdDt(data.getUpdDt());
			mdmVendorVO.setUpdUsrId(data.getUpdUsrId());
			mdmVendorVO.setEaiIfId(mdm.getEAIHeader().getInstanceId());

			mdmVendorVOs.add(mdmVendorVO);
			//			model = new MdmChkmailAddr();
//			
//			
//			model.setVndrSeq(data.getVndrSeq());
//			model.setChk_de_addr1(data.getChkDeAddr1());
//			model.setChk_de_addr2(data.getChkDeAddr2());
//			model.setChk_de_addr3(data.getChkDeAddr3());
//			model.setChk_de_cnt_cd(data.getChkDeCntCd());
//			model.setChk_de_cty_nm(data.getChkDeCtyNm());
//			model.setChk_de_ste_cd(data.getChkDeSteCd());
//			model.setChk_de_zip_cd(data.getChkDeZipCd());
//			model.setCreDt(data.getCreDt());
//			model.setCreUsrId(data.getCreUsrId());
//			model.setEai_evnt_dt(getMsgCreDt());
//			model.setLu_delt_flg(data.getDeltFlg());
//			model.setUpdDt(data.getUpdDt());
//			model.setUpdusrId(data.getUpdUsrId());
//			
//			models.add(model);

		}
		return mdmVendorVOs;
	}

	/** Create or Remove  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException {
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info("\n //--->>> (createMDM_Check Mail Address) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info("\n //--->>> (createMDM_Check Mail Address)) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}

	}

	/** DBDAO의 addMDM_CHKMAIL_ADDR메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		try {
//			isSuccessful = dbDao.addMdmVendor(models);
			isSuccessful = dbDao.addMdmVendor((List<MdmVendorVO>)models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}

	/** DBDAO의 removeMDM_CHKMAIL_ADDR메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		try {
//			isSuccessful = dbDao.removeMdmVendor(models);
			isSuccessful = dbDao.removeMdmVendor((List<MdmVendorVO>)models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
	
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

}
