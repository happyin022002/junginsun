/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CURRBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-25 : Ho-Jin Lee Alps 전환
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCurrencyDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0340001Document;
import com.hanjin.irep.mdm.MDM0340001Document.MDM0340001;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCurrencyBCImpl extends BasicCommandSupport implements ReceiveQueueBC {
	private transient ReceiveQueueMdmCurrencyDBDAO dbDao = null;

	private String opCd = "";
	private String msgCreDt = "";

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

	/** ReceiveQueueMDM_CURRBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCurrencyBCImpl() {
		dbDao = new ReceiveQueueMdmCurrencyDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmCurrencyVO> receiveMDMTB(XmlObject xmlObject) {
		MdmCurrencyVO model = null;
		Collection<MdmCurrencyVO> models = new ArrayList<MdmCurrencyVO>();

		MDM0340001Document mdmDoc = (MDM0340001Document) xmlObject;
		MDM0340001 mdm = mdmDoc.getMDM0340001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0340001Document.MDM0340001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmCurrencyVO();
			model.setCurrCd(data.getCurrCd());
			model.setCurrNm(data.getCurrNm());
			model.setCurrDesc(data.getCurrDesc());
			model.setCntCd(data.getCntCd());
			model.setFmEffDt(data.getFmEffDt());
			model.setToEffDt(data.getToEffDt());
			model.setDpPrcsKnt(data.getDpPrcsKnt() );
			model.setXtdPrcsKnt(data.getXtdPrcsKnt() );
			model.setCreUsrId(data.getCreUsrId());
			model.setCreDt(data.getCreDt());
			model.setUpdUsrId(data.getUpdUsrId());
			model.setUpdDt(data.getUpdDt());
			model.setDeltFlg(data.getDeltFlg());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			log.info("\n >>>>model<<<<<="+model);
			models.add(model);
		}

		return models;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		
		try {
			int insCnt = 0;
			MdmCurrencyVO model = null;
			Iterator<MdmCurrencyVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmCurrencyVO)itr.next();
			}
				String curr_cd = model.getCurrCd();
				log.info("\n >>>>curr_cd="+curr_cd);
				boolean searchFlag = dbDao.searchMDMCURRENCYList(curr_cd);
				log.info("\n >>>>searchFlag="+searchFlag);
				if(searchFlag){
					log.info("\n <<<<addMdmCurrency : model>>>>="+model);
					insCnt = dbDao.addMdmCurrency(model);
				}else{
					log.info("\n <<<<modifyMdmCurrency : model>>>>="+model);
					insCnt = dbDao.modifyMdmCurrency(model);
				}
				log.info("\n <<insCnt>>="+insCnt);
			if(insCnt > 0){
				isSuccessful = true;
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
		int delCnt = 0;
		boolean isSuccessful = false;
		try {
			MdmCurrencyVO model = null;
			Iterator<MdmCurrencyVO> itr = models.iterator();
			while(itr.hasNext()){
				model = (MdmCurrencyVO)itr.next();
			}
			log.info("\n removeMDMTB : removeMdmCurrency : models="+models);
				delCnt = dbDao.removeMdmCurrency(model);
			
			if(delCnt > 0){
				isSuccessful = true;
			}
			
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
		log.info("\n ctrlMDMTB : models="+models);
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
			case 'U':
				log.info("\n createMDMTB : models="+models);
				isSuccessFlag = createMDMTB(models);
				log.info(" (createMdmCurrency) isSucessFlag : " + isSuccessFlag );
				break;
	
			case 'D':
				log.info("\n removeMDMTB : models="+models);
				isSuccessFlag = removeMDMTB(models);
				log.info(" (createMdmCurrency) isSucessFlag : " + isSuccessFlag );
				break;
		}
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
}
