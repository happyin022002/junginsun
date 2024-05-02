/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmOrganizationBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-08
 *@LastModifier : Jun Byoung Suk
 *@LastVersion : 1.0
 *2009-09-08 Jun Byoung Suk
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmOrganizationDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmOrganizationVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0270001Document;
import com.hanjin.irep.mdm.MDM0270001Document.MDM0270001;
import com.hanjin.syscommon.common.table.MdmOrganization;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0270001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0270001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmOrganizationBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmOrganizationDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_OFFICEBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmOrganizationBCImpl() {
		dbDao = new ReceiveQueueMdmOrganizationDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		log.error("###   MDM_ORGANIZATION - BCImple  ###  receiveMDMTB Start" );
		SearchMdmOrganizationVO model = null;
		Collection models = new ArrayList();
		MDM0270001Document mdmDoc = (MDM0270001Document) xmlObject;
		MDM0270001 mdm = mdmDoc.getMDM0270001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.error(" MDM_ORGANIZATION  OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.error(" MDM_ORGANIZATION  MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());
		// /===== Collect received data & Allocate them to Collection models
		com.hanjin.irep.mdm.MDM0270001Document.MDM0270001.DataArea data = mdm
				.getDataArea();
		
		if (data != null) {
			log.error("###   MDM_ORGANIZATION - BCImple  ###  receiveMDMTB Extracting Data..." );
			model = new SearchMdmOrganizationVO();
			model.setOfcCd                      (data.getOfcCd                  ());
			model.setOfcCmmcCd                  (data.getOfcCmmcCd              ());
			model.setOfcEngNm                   (data.getOfcEngNm               ());
			model.setOfcKrnNm                   (data.getOfcKrnNm               ());
			model.setOfcAddr                    (data.getOfcAddr                ());
			model.setOfcZipCd                   (data.getOfcZipCd               ());
			model.setOfcKndCd                   (data.getOfcKndCd               ());
			model.setAgnKndCd                   (data.getAgnKndCd               ());
			model.setOfcTpCd                    (data.getOfcTpCd                ());
			model.setOfcPsonKnt                 (data.getOfcPsonKnt             ());
			model.setOfcRmk                     (data.getOfcRmk                 ());
			model.setLocCd                      (data.getLocCd                  ());
			model.setPrntOfcCd                  (data.getPrntOfcCd              ());
			model.setPrcOfcCd                   (data.getPrcOfcCd               ());
			model.setSlsOfcDivCd                (data.getSlsOfcDivCd            ());
			model.setIntlPhnNo                  (data.getIntlPhnNo              ());
			model.setOfcPhnNo                   (data.getOfcPhnNo               ());
			model.setIntlFaxNo                  (data.getIntlFaxNo              ());
			model.setOfcFaxNo                   (data.getOfcFaxNo               ());
			model.setFaxIp                      (data.getFaxIp                  ());
			model.setOfcUrl                     (data.getOfcUrl                 ());
			model.setOpnDt                      (data.getOpnDt                  ());
			model.setClzDt                      (data.getClzDt                  ());
			model.setSlsOfcUseFlg               (data.getSlsOfcUseFlg           ());
			model.setOfcSlsDeltFlg              (data.getOfcSlsDeltFlg          ());
			model.setDocRcvrHideFlg             (data.getDocRcvrHideFlg         ());
			model.setOfcRfaScUseFlg             (data.getOfcRfaScUseFlg         ());
			model.setFincHideFlg                (data.getFincHideFlg            ());
			model.setFincRgnCd                  (data.getFincRgnCd              ());
			model.setArCurrCd                   (data.getArCurrCd               ());
			model.setArCtrCd                    (data.getArCentrCd              ());
			model.setArOfcCd                    (data.getArOfcCd                ());
			model.setArHdQtrOfcCd               (data.getArHdQtrOfcCd           ());
			model.setArCtrlOfcCd                (data.getArCtrlOfcCd            ());
			model.setIbCrTermDys                (data.getIbCrTermDys            ());
			model.setObCrTermDys                (data.getObCrTermDys            ());
			model.setSubAgnFlg                  (data.getSubAgnFlg              ());
			model.setRepCustSeq                 (data.getRepreCustSeq           ());
			model.setInvPfxCd                   (data.getInvPfxCd               ());
			model.setUsaBrkBrncRqstCtrlOfcCd    (data.getUsaBrkBrncRqstCtrlOfcCd());
			model.setAsaCrTermDys               (data.getAsaCrTermDys 	        ());
			model.setFxCurrRt                   (data.getFxCurrRt               ());
			model.setOfcTaxId                   (data.getOfcTaxId               ());
			model.setBilCurrCd                  (data.getBilCurrCd              ());
			model.setVndrCntCd                  (data.getVndrCntCd              ());
			model.setVndrSeq                    (data.getVndrSeq                ());
			model.setApOfcCd                    (data.getApOfcCd                ());
			model.setApCtrlOfcCd                (data.getApCtrlOfcCd            ());
			model.setApHoAcctCd                 (data.getApHoAcctCd             ());
			model.setApEuroCurrUseFlg           (data.getApEuroCurrUseFlg       ());
			model.setSoIfCd                     (data.getSoIfCd                 ());
			model.setCommIfIndCd                (data.getCommIfIndCd            ());
			model.setFincPsdoOfcFlg             (data.getFincPsdoOfcFlg         ());
			model.setBfrOfcCd                   (data.getBfrOfcCd               ());
			model.setModiOfcCd                  (data.getModiOfcCd              ());
			model.setCreUsrId                   (data.getCreUsrId               ());
			model.setCreDt                      (data.getCreDt                  ());
			model.setUpdUsrId                   (data.getUpdUsrId               ());
			model.setUpdDt                      (data.getUpdDt                  ());
			model.setDeltFlg                    (data.getDeltFlg                ());
			model.setRepCustCntCd               (data.getRepreCntCd             ());
			model.setApCtrCd                    (data.getApCentrCd              ());
			model.setOfcRepEml                  (data.getOfcRepreEml            ());
			model.setBkgSvrSrchRoutCd           (data.getBkgSvrSearchRoutCd     ());
			model.setSubsCoFlg                  (data.getSsidiCoFlg             ());
			model.setGlCtrCd                    (data.getGlCentrCd              ());
			model.setEaiEvntDt				    (getMsgCreDt					());
			model.setOfcLoclLangAddr			(data.getOfcLoclLangAddr		());
			model.setArAgnStlCd					(data.getArAgnStlCd				());  //2010.03.31 추가 yjlee. 박상국 수석님과 확인 완료.
			model.setEaiIfId                    (mdm.getEAIHeader().getInstanceId()); //2010.07.09 추가
			//for test
			log.info("\n mdm.getEAIHeader().getInstanceId(): "+mdm.getEAIHeader().getInstanceId());
			log.info("\n model.getEaiIfId(): "+model.getEaiIfId());
			models.add(model);
		}
		log.error("###   MDM_ORGANIZATION - BCImple  ###  receiveMDMTB END" );
		return models;
	}
	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  createMDMTB Start" );
		boolean isSuccessful = false;
		try {
			//isSuccessful = dbDao.addMDM_OFFICE(models);
			Iterator itr = models.iterator();
			SearchMdmOrganizationVO model = null;
			String loc_cd = null;
			
			while (itr.hasNext()) {
				//getting each VO
				model = (SearchMdmOrganizationVO)itr.next();
				loc_cd = model.getOfcCd();
				log.info("\n MDM_ORGANIZATION  loc_cd : " + loc_cd);
				log.info("\n MDM_ORGANIZATION  eai_if_id : " + model.getEaiIfId());
				/*Insert or Update*/
				/*Insert*/
				boolean divisionFalg = dbDao.searchMdmOrganizationList(loc_cd);
				// 있으면 False -> Update 
				// 없으면 True  -> Insert
				log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  createMDMTB - divisionFlag:" +  divisionFalg);
				if(divisionFalg){
					log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  Inserting..." );
					//Archiving   just One VO in order to follow the program interface.
					
					Collection vo = new ArrayList();
					vo.add(model);
					log.error("###   MDM_ORGANIZATION model.toString() : "+model.toString());
					dbDao.addMdmOrganization((List<SearchMdmOrganizationVO>) vo);
				}else{
					log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  Modifying..." );
					//Archiving   just One VO in order to follow the program interface.
					Collection vo = new ArrayList();
			        vo.add(model);
			        
			        dbDao.modifyMdmOrganization((List<SearchMdmOrganizationVO>) vo);
					
				}//if
			}//while  
			isSuccessful = true;
		}catch (DAOException de) {
			isSuccessful = false;
			log.error("err " + de.toString(), de);
			throw de;
		}//try
		log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  createMDMTB End" );
		return isSuccessful;
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  removeMDMTB Start" );
		boolean isSuccessful = false;
		try {
			Iterator itr = models.iterator();
			SearchMdmOrganizationVO model = null;
			String ofc_cd = null;
			
			while (itr.hasNext()) {
				model = (SearchMdmOrganizationVO)itr.next();
				ofc_cd = model.getOfcCd();
				log.error("loc_cd : " + ofc_cd);
				log.error("loc_cd : " + ofc_cd);
				
				if (ofc_cd !=null && ofc_cd.trim().length() > 0 
						&& !dbDao.searchMdmOrganizationList(ofc_cd)) {
					
					Collection vo = new ArrayList();
			                   vo.add(model);
			                   dbDao.removeMdmOrganization((List<SearchMdmOrganizationVO>) vo);
				}//if
 			}//while
			
			isSuccessful = true;
		} catch (DAOException de) {
			isSuccessful = false;
			log.error("err " + de.toString(), de);
			throw de;
		}
		log.error("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  removeMDMTB End" );
		return isSuccessful;
	}

	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException{
		log.error("###   MDM_ORGANIZATION - BCImple  ###  ctrlMDMTB Start" );
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.error("###   MDM_ORGANIZATION - BCImple  ###  ctrlMDMTB Start - Creating Table" );
			log.error(" (createMDM_OFFICE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			log.error("###   MDM_ORGANIZATION - BCImple  ###  ctrlMDMTB - Deleting Table" );
			isSuccessFlag = removeMDMTB(models);
			log.error(" (removeMDM_OFFICE) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
		log.error("###   MDM_ORGANIZATION - BCImple  ###  ctrlMDMTB END" );
	}
}
