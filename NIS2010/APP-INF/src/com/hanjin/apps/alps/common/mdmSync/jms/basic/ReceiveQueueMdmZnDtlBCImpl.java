/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONE_DETAILBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-05
 *@LastModifier : Kim kwijin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmZnDtlDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZnDtlVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0510001Document;
import com.hanjin.irep.mdm.MDM0510001Document.MDM0510001;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZnDtlBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {

	private transient ReceiveQueueMdmZnDtlDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_ZONE_DETAILBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmZnDtlBCImpl() {
		dbDao = new ReceiveQueueMdmZnDtlDBDAO();
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
	public Collection<MdmZnDtlVO> receiveMDMTB(XmlObject xmlObject) {

		MdmZnDtlVO model = null;
		Collection<MdmZnDtlVO> models = new ArrayList<MdmZnDtlVO>();

		MDM0510001Document mdmDoc = (MDM0510001Document) xmlObject;
		MDM0510001 mdm = mdmDoc.getMDM0510001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0510001Document.MDM0510001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new MdmZnDtlVO();
			model.setZnCd(data.getDetZnCd());
			model.setZnSeq(data.getZnDtlSeq());
			model.setZipCd(data.getDetZipCd());
			model.setDstrNm(data.getDetDstrNm());
			model.setCreUsrId(data.getDetCreUsrId()); 
			model.setCreDt(data.getDetCreDt());
			model.setUpdUsrId(data.getDetUpdUsrId()); 
			model.setUpdDt(data.getDetUpdDt());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			model.setDeltFlg(data.getDetDeltFlg()) ; // 2012.05.30 추가
			models.add(model);
		}
		return models;
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
			log.info(" (createMDM_ZN_DTL) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_ZN_DTL) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection<MdmZnDtlVO> models) throws DAOException{
		boolean isSuccessful = false;
		try {
			Collection<MdmZnDtlVO> addModels = new ArrayList<MdmZnDtlVO>(); 
			Collection<MdmZnDtlVO> modifyModels = new ArrayList<MdmZnDtlVO>(); 
			MdmZnDtlVO model = null;
			String zn_cd = null;
			String zn_seq = null;
			Iterator<MdmZnDtlVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmZnDtlVO)itr.next();
				zn_cd = model.getZnCd();
				zn_seq = model.getZnSeq();
				if(dbDao.searchMDM_ZN_DTLList(zn_cd,zn_seq)){
					if ( zn_cd !=null && zn_cd.trim().length() > 0 
							&& zn_seq !=null && zn_seq.trim().length() > 0) {
						addModels.add(model);
					}
				}else{
					if ( zn_cd !=null && zn_cd.trim().length() > 0 
							&& zn_seq !=null && zn_seq.trim().length() > 0) {
						modifyModels.add(model);
					}
				}
				
			}
			if(addModels.size()>0){
				dbDao.addMdmZnDtl(addModels);
			}
			if(modifyModels.size()>0){
				dbDao.modifyMdmZnDtl(modifyModels);
			}
			isSuccessful = true;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new DAOException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new DAOException(ex.getMessage(),ex);
		}
	
		return isSuccessful;
		
		
		/*
		boolean isSuccessful = false;

		try {
			isSuccessful = dbDao.addMdmZnDtl(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		*/
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection<MdmZnDtlVO> models) throws DAOException{
		boolean isSuccessful = false;
		try {
			Collection<MdmZnDtlVO> delModels = new ArrayList<MdmZnDtlVO>(); 
			
			MdmZnDtlVO model = null;
			String zn_cd = null;
			String zn_seq = null;
			Iterator<MdmZnDtlVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmZnDtlVO)itr.next();
				zn_cd = model.getZnCd();
				zn_seq = model.getZnSeq();
				if ( zn_cd !=null && zn_cd.trim().length() > 0
						&& !dbDao.searchMDM_ZN_DTLList(zn_cd,zn_seq)) {
					
					delModels.add(model);
				}
				
			}
			if(!delModels.isEmpty()){
				dbDao.removeMdmZnDtl(delModels);
			}
			
			isSuccessful = true;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new DAOException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new DAOException(ex.getMessage(),ex);
		}
	
		return isSuccessful;
		
		
		/*
		boolean isSuccessful = false;

		try {
			isSuccessful = dbDao.removeMdmZnDtl(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		*/
	}
}
