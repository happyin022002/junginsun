/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CNTR_VENDOR_CLASSBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCntrVndrClssDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0200001Document;
import com.hanjin.irep.mdm.MDM0200001Document.MDM0200001;
import com.hanjin.syscommon.common.table.MdmCntrVndrClss;
import com.hanjin.syscommon.common.table.MdmCntrVndrClssVO;
import com.hanjin.syscommon.common.table.MdmVendor;
import com.hanjin.syscommon.common.table.MdmVendorVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0200001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0200001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCntrVndrClssBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmCntrVndrClssDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_ACCOUNTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCntrVndrClssBCImpl() {
		dbDao = new ReceiveQueueMdmCntrVndrClssDBDAO();
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
	public List<MdmCntrVndrClssVO> receiveMDMTB(XmlObject xmlObject) {

		List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs = new ArrayList<MdmCntrVndrClssVO>();

		MDM0200001Document mdmDoc = (MDM0200001Document) xmlObject;
		MDM0200001 mdm = mdmDoc.getMDM0200001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0200001Document.MDM0200001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			
			MdmCntrVndrClssVO mdmCntrVndrClssVO = new MdmCntrVndrClssVO();

			mdmCntrVndrClssVO.setVndrSeq        (data.getVndrSeq        ());
			mdmCntrVndrClssVO.setVndrCostCd    (data.getVndrCostCd    ());
			mdmCntrVndrClssVO.setCntrVndrSvcCd(data.getCntrVndrSvcCd());
			mdmCntrVndrClssVO.setCreUsrId      (data.getCreUsrId      ());
			mdmCntrVndrClssVO.setCreDt          (data.getCreDt          ());
			mdmCntrVndrClssVO.setUpdUsrId      (data.getUpdUsrId      ());
			mdmCntrVndrClssVO.setUpdDt          (data.getUpdDt          ());
			mdmCntrVndrClssVO.setDeltFlg        (data.getDeltFlg        ());
			mdmCntrVndrClssVO.setEaiEvntDt(getMsgCreDt());
			mdmCntrVndrClssVO.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			
			mdmCntrVndrClssVOs.add(mdmCntrVndrClssVO);
		}
		return mdmCntrVndrClssVOs;
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
			log.info(" (createMDM_CNTR_VNDR_CLSS) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CNTR_VNDR_CLSS) isSucessFlag : "
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
		
		try {
			List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs = (List <MdmCntrVndrClssVO>) models;
			
			for (int i = 0; i < mdmCntrVndrClssVOs.size(); i ++) {
				MdmCntrVndrClssVO rowVO = mdmCntrVndrClssVOs.get(i);
				if ( dbDao.searchMdmCntrVndrClss(rowVO) ) {
					isSuccessful = dbDao.modifyMdmCntrVndrClss(rowVO);
				} else {
					isSuccessful = dbDao.addMdmCntrVndrClss(rowVO);
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

		try {
			List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs = (List <MdmCntrVndrClssVO>) models;
			
			for (int i = 0; i < mdmCntrVndrClssVOs.size(); i ++) {
				MdmCntrVndrClssVO rowVO = mdmCntrVndrClssVOs.get(i);
				if (dbDao.searchMdmCntrVndrClss(rowVO)) {
					isSuccessful = dbDao.removeMdmCntrVndrClss(rowVO);
				} 
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}