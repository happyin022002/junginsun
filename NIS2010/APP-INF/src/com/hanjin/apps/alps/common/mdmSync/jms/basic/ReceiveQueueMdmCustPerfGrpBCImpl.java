/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUSTOMER_GROUPBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * History
 * ***************************************
 * 2013.07.02 김현화[CHM-201325520][COA] Customer Segmentation 관련 변경사항 추가-컬럼추가(NewKeyAcctFlg,RgnAcctFlg,RhqCd,OfcTeamCd)
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCustPerfGrpDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0180001Document;
import com.hanjin.irep.mdm.MDM0180001Document.MDM0180001;
import com.hanjin.syscommon.common.table.MdmCustPerfGrpVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustPerfGrpBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmCustPerfGrpDBDAO dbDao = null;

	private String opCd = "";

	private String msgCreDt = "";

	/** ReceiveQueueMDM_CUSTOMER_GROUPBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCustPerfGrpBCImpl() {
		dbDao = new ReceiveQueueMdmCustPerfGrpDBDAO();
	}

	/** opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
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
	public Collection<MdmCustPerfGrpVO> receiveMDMTB(XmlObject xmlObject) {

		MdmCustPerfGrpVO model = null;
		Collection<MdmCustPerfGrpVO> models = new ArrayList<MdmCustPerfGrpVO>();

		MDM0180001Document mdmDoc = (MDM0180001Document) xmlObject;
		MDM0180001 mdm = mdmDoc.getMDM0180001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0180001Document.MDM0180001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmCustPerfGrpVO();
			model.setCustGrpId       (data.getCustGrpCd        ());
			model.setCustGrpNm       (data.getCustGrpNm        ());
			model.setOfcCd           (data.getOfcCd            ());
			model.setSrepCd          (data.getSrepCd           ());
			model.setVbsClssCd		 (data.getValBseSegmClssCd ());
			model.setNbsClssCd1		 (data.getNdsBseSegmClssCd1());
			model.setNbsClssCd2		 (data.getNdsBseSegmClssCd2());
			model.setNbsClssCd3		 (data.getNdsBseSegmClssCd3());
			model.setCreUsrId        (data.getCreUsrId         ());
			model.setCreDt           (data.getCreDt            ());
			model.setUpdUsrId        (data.getUpdUsrId         ());
			model.setUpdDt           (data.getUpdDt            ());
			model.setDeltFlg         (data.getDeltFlg          ());
			model.setEaiEvntDt       (getMsgCreDt              ());
			model.setEaiIfId         (mdm.getEAIHeader().getInstanceId()); //2010.07.09 추가
			//2013.07.02 추가
			model.setNewKeyAcctFlg    (data.getNewKeyAcctFlg());
			model.setRgnAcctFlg       (data.getRgnAcctFlg());
			model.setRhqCd            (data.getRhqCd());
			model.setOfcTeamCd        (data.getOfcTeamCd());
			
			models.add(model);
		}
		return models;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	private boolean isAlreadyMDMTB(String custGrpId) throws DAOException{
		try {
			return dbDao.searchMdmCustomerGroupList(custGrpId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
	}
	
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	private void addMDMTB(Collection<MdmCustPerfGrpVO> models) throws DAOException{
		try {
			dbDao.addMdmCustPerfGrp(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
	}
	
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	private void modifyMDMTB(Collection<MdmCustPerfGrpVO> models) throws DAOException{
		try {
			dbDao.modifyMdmCustPerfGrp(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
	}
	

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	private void removeMDMTB(Collection<MdmCustPerfGrpVO> models) throws DAOException{
		try {
			dbDao.removeMdmCustPerfGrp(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
	}
	
	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		Collection<MdmCustPerfGrpVO> addModels = new ArrayList<MdmCustPerfGrpVO>(); 
		Collection<MdmCustPerfGrpVO> modifyModels = new ArrayList<MdmCustPerfGrpVO>(); 
		
		switch (OpCd.charAt(0)) {
		case 'U':
			Iterator<MdmCustPerfGrpVO> it = models.iterator();
			while(it.hasNext()){
				MdmCustPerfGrpVO model = ( (MdmCustPerfGrpVO)it.next() );
				String custGrpId = model.getCustGrpId();
				if ( isAlreadyMDMTB(custGrpId) ){
					addModels.add(model);
				}else {
					modifyModels.add(model);
				}
			}
			
			if(!addModels.isEmpty())	addMDMTB(addModels);
			if(!modifyModels.isEmpty())	modifyMDMTB(modifyModels);	
			
			break;

		case 'D':
			removeMDMTB(models);
			break;
		}
	}
}
