/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONE_TOTALBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-06
 *@LastModifier : Kim Kwijin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmZnGeneralDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZnDtlVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0570001Document;
import com.hanjin.irep.mdm.MDM0570001Document.MDM0570001;
import com.hanjin.irep.mdm.MDM0570001Document.MDM0570001.DataArea.ZnDet;
import com.hanjin.irep.mdm.MDM0570001Document.MDM0570001.DataArea.ZnDet.ZnDetIns;



/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZnGeneralBCImpl extends BasicCommandSupport implements ReceiveQueueBC {
	private transient ReceiveQueueMdmZnGeneralDBDAO dbDao = null;
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

	/** ReceiveQueueMDM_ZONE_TOTALBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmZnGeneralBCImpl() {
		dbDao = new ReceiveQueueMdmZnGeneralDBDAO();
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
	public Collection receiveMDMTB(XmlObject xmlObject) {

		MdmZoneVO model = null;
		MdmZnDtlVO model2 = null;
		
		Collection models = new ArrayList();
		Collection<MdmZnDtlVO> models2 = new ArrayList<MdmZnDtlVO>();

		MDM0570001Document mdmDoc = (MDM0570001Document) xmlObject;
		MDM0570001 mdm = mdmDoc.getMDM0570001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();

		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0570001Document.MDM0570001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmZoneVO();
			model.setZnCd		 (data.getZnCd         ());
			model.setZnNm           (data.getZnNm         ());
			model.setRepYdCd       (data.getRepreYdCd    ());
			model.setLocCd          (data.getLocCd        ());
			model.setCgoHndlTmHrs (data.getCgoHndlTmHors());
			model.setDistUtCd      (data.getDistUtCd     ());
			model.setLnkDist        (data.getLnkDist      ());
			model.setTztmHrs       (data.getTztmHors     ());
			model.setCreUsrId      (data.getCreUsrId     ());
			model.setCreDt          (data.getCreDt        ());
			model.setUpdUsrId      (data.getUpdUsrId     ());
			model.setUpdDt          (data.getUpdDt        ());
			model.setDeltFlg        (data.getDeltFlg      ());
			model.setEaiEvntDt(getMsgCreDt());
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId());
			models.add(model);
			
			ZnDet znDet = data.getZnDet();
			if(znDet != null){
				ZnDetIns[] znDetIns = znDet.getZnDetInsArray();
				for(int i=0; i<znDetIns.length; i++){
					model2 = new MdmZnDtlVO();
					model2.setZnCd      (data.getZnCd      ());
					model2.setZnSeq		(znDetIns[i].getZnDtlSeq());
					model2.setZipCd     (znDetIns[i].getDetZipCd());
					model2.setDstrNm    (znDetIns[i].getDetDstrNm());
					model2.setCreUsrId (data.getCreUsrId ()); 
					model2.setCreDt     (data.getCreDt     ());
					model2.setUpdUsrId (data.getUpdUsrId ()); 
					model2.setUpdDt     (data.getUpdDt     ());
					model2.setEaiEvntDt(getMsgCreDt());
					model2.setEaiIfId(mdm.getEAIHeader().getInstanceId());
					models2.add(model2);
					model2 = null;
				}
			}
			models.add(models2);
		}
		return models;
	}

	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws DAOException 
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
			log.info(" (createMDM_ZONE_TOTAL) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_ZONE_TOTAL) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws DAOException 
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException {
		
		boolean isSuccessful = false;
		try {
			Collection<MdmZoneVO> addModels = new ArrayList<MdmZoneVO>(); 
			Collection<MdmZoneVO> modifyModels = new ArrayList<MdmZoneVO>(); 
			
			MdmZoneVO model = null;
			Collection models2 = new ArrayList();
			String zn_cd = null;
			
			int j=1;
			
			Iterator itr = models.iterator();
			while (itr.hasNext()) {
				if(j%2==1){
					model = (MdmZoneVO)itr.next();
					zn_cd = model.getZnCd();
					if(dbDao.searchMDM_ZONE_TOTALList(zn_cd)){
						if ( zn_cd !=null && zn_cd.trim().length() > 0 ) {
							addModels.add(model);
						}
					}else{
						if ( zn_cd !=null && zn_cd.trim().length() > 0 ) {
							modifyModels.add(model);
						}
					}
					
					String nod_cd = model.getZnCd();
					if(dbDao.searchPRD_NODEList(nod_cd)){
						if ( nod_cd != null  && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ) {
							dbDao.addPrdNode(model);
						}
					}else{
						if ( nod_cd !=null && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ){
							dbDao.modifyPrdNode(model);
						}
					}
				}else{
					
					Collection<MdmZnDtlVO> addDtlModels = new ArrayList<MdmZnDtlVO>(); 
					Collection<MdmZnDtlVO> modifyDtlModels = new ArrayList<MdmZnDtlVO>(); 
					
					models2 = (ArrayList)itr.next();
					if(models2 != null){
						Iterator itr2 = models2.iterator();
						MdmZnDtlVO modelDtl = null;
						String zn_seq = null;
						while (itr2.hasNext()) {
							modelDtl = (MdmZnDtlVO)itr2.next();
							zn_seq = modelDtl.getZnSeq();
							if(dbDao.searchMDM_ZN_DTLList(zn_cd,zn_seq)){
								if ( zn_cd !=null && zn_cd.trim().length() > 0 
										&& zn_seq != null && zn_seq.trim().length() > 0 ) {
									modelDtl.setZnCd(zn_cd);
									addDtlModels.add(modelDtl);
								}
							}else{
								if ( zn_cd !=null && zn_cd.trim().length() > 0 
										&& zn_seq != null && zn_seq.trim().length() > 0 ) {
									modifyDtlModels.add(modelDtl);
								}
							}
						}//while끝
						if(!addDtlModels.isEmpty()){
							dbDao.addMdmZnDtl(addDtlModels);
						}
						if(!modifyModels.isEmpty()){
							dbDao.modifyMdmZnDtl(modifyDtlModels);
						}
					}//else 끝
				}
				j++;
				
			}//while끝
			
			if(!addModels.isEmpty()){
				dbDao.addMdmZnGeneral(addModels);
			}
			if(!modifyModels.isEmpty()){
				dbDao.modifyMdmZnGeneral(modifyModels);
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
			isSuccessful = dbDao.addMdmZnGeneral(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		*/
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws DAOException 
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		try {
			Collection<MdmZoneVO> delModels = new ArrayList<MdmZoneVO>(); 
			
			Iterator itr = models.iterator();
			MdmZoneVO model = null;
			String zn_cd = null;
			int j=1;
			while (itr.hasNext()) {
				if(j%2==1){
					model = (MdmZoneVO)itr.next();
					zn_cd = model.getZnCd();
					if ( zn_cd !=null && zn_cd.trim().length() > 0
							&& !dbDao.searchMDM_ZONE_TOTALList(zn_cd)) {
						delModels.add(model);
						
					}
					
					String nod_cd = model.getZnCd();
					if ( nod_cd !=null && nod_cd.trim().length() > 0 
							&& !dbDao.searchPRD_NODEList(nod_cd)) {
						dbDao.removePrdNode(model);
					}
					
				}else{
					itr.next();
				}
				j++;
			}
			if(!delModels.isEmpty()){
				dbDao.removeMdmZnGeneral(delModels);
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
			isSuccessful = dbDao.removeMdmZnGeneral(models);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
		*/
	}
}
