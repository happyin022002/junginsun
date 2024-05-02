/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVslCntrBCImpl.java
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
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVslCntrDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0250001Document;
import com.hanjin.irep.mdm.MDM0250001Document.MDM0250001;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0250001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVslCntrBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueMdmVslCntrDBDAO dbDao = null;

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
	
	/** ReceiveQueueMdmVslCntrBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVslCntrBCImpl() {
		dbDao = new ReceiveQueueMdmVslCntrDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		
		MdmVslCntrVO model = null;
		Collection models = new ArrayList();

		MDM0250001Document mdmDoc = (MDM0250001Document) xmlObject;
		MDM0250001 mdm = mdmDoc.getMDM0250001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("MDM025 OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());
//		log.debug("MDM025 check::: START============================================");
		// /===== Collect received data & Allocate them to Collection models
		com.hanjin.irep.mdm.MDM0250001Document.MDM0250001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			
			model = new MdmVslCntrVO();
//			log.debug("MDM025 data ==============VslCd================="+data.getVslCd());
//			log.debug("MDM025 data ==============VslCd===locl nm=============="+data.getVslLoclNm());
			model.setVslCd              (data.getVslCd           ());
			model.setVslClssFlg			(data.getVslClssFlg      ());	/* 기존 쿼리에서는 vslClssCd 를 사용하고 있음. 정확한 매핑 정보 확인 필요. 20090910 kys */
			model.setVslEngNm          	(data.getVslEngNm        ());
			model.setVslKrnNm          	(data.getVslKrnNm        ());
			model.setFoilCapa           (data.getFoilCapa        ());
			model.setDoilCapa           (data.getDoilCapa        ());
			model.setFrshWtrCapa       	(data.getFrshWtrCapa     ());
			model.setCallSgnNo         	(data.getCallSgnNo       ());
			model.setRgstNo             (data.getRgstNo          ());
			model.setPhnNo              (data.getPhnNo           ());
			model.setFaxNo              (data.getFaxNo           ());
			model.setTlxNo              (data.getTlxNo           ());
			model.setVslEml             (data.getVslEml          ());
			model.setPiclbDesc          (data.getPiclbDesc       ());
			model.setRgstPortCd        	(data.getRgstPortCd      ());
			model.setClssNoRgstAreaNm	(data.getClssNoRgstAreaNm());
			model.setVslClssNo	     	(data.getVslClssNo       ());
			model.setVslBldrNm         	(data.getVslBldrNm       ());
			model.setLoaLen             (data.getLoaLen          ());
			model.setLbpLen             (data.getLbpLen          ());
			model.setVslWdt             (data.getVslWdt          ());
			model.setVslDpth            (data.getVslDpth         ());
			model.setSmrDrftHgt        	(data.getSmrDrftHgt      ());
			model.setDwtWgt             (data.getDwtWgt          ());
			model.setLgtShpTongWgt    	(data.getLgtShpTongWgt   ());
			model.setGrsRgstTongWgt   	(data.getGrsRgstTongWgt  ());
			model.setNetRgstTongWgt   	(data.getNetRgstTongWgt  ());
			model.setPnmGtWgt          	(data.getPnmGtWgt        ());
			model.setPnmNetTongWgt    	(data.getPnmNetTongWgt   ());
			model.setSuzGtWgt          	(data.getSuzGtWgt        ());
			model.setSuzNetTongWgt    	(data.getSuzNetTongWgt   ());
			model.setMnEngMkrNm       	(data.getMnNznMkrNm      ());
			model.setMnEngTpDesc		(data.getMnNznTpCd       ());
			model.setMnEngBhpPwr        (data.getMnNznBhpPwr     ());
			model.setVslOwnIndCd        (data.getVslOwnIndCd     ());
			model.setVslRgstCntCd     	(data.getVslRgstCntCd    ());
			model.setVslBldCd          	(data.getNewBltFlg       ());
			model.setCrrCd              (data.getCarrCd          ());
			model.setFdrDivCd          	(data.getFdrDivCd        ());
			model.setVslSvcSpd         	(data.getVslSvcSpd       ());
			model.setMaxSpd             (data.getMaxSpd          ());
			model.setEcnSpd             (data.getEcnSpd          ());
			model.setCrwKnt             (data.getCrwKnt          ());
			model.setCntrDznCapa       	(data.getCntrDznCapa     ());
			model.setCntrOpCapa        	(data.getCntrOpCapa      ());
			model.setCntrPnmCapa       	(data.getCntrPnmCapa     ());
			model.setCntrVslClssCapa  	(data.getCntrVslClssCapa ());
			model.setRfRcptKnt         	(data.getRfRcptKnt       ());
			model.setRfRcptMaxKnt     	(data.getRfRcptMaxKnt    ());
			model.setFbdCapa            (data.getFrbrdCapa       ());
			model.setDplCapa            (data.getDplCapa         ());
			model.setBlstTnkCapa       	(data.getBlstTnkCapa     ());
			model.setFoilCsm            (data.getFoilCsm         ());
			model.setDoilCsm            (data.getDoilCsm         ());
			model.setFrshWtrCsm        	(data.getFrshWtrCsm      ());
			model.setMnEngRpmPwr      	(data.getMnNznRpmPwr     ());
			model.setGnrRpmPwr         	(data.getGnrRpmPwr       ());
			model.setVslHgt             (data.getVslHgt          ());
			model.setRgstDt             (data.getRgstDt          ());
			model.setVslEdiNm          	(data.getVslEdiNm        ());
			model.setCoCd               (data.getCoCd            ());
			model.setVslClzDt          	(data.getVslClzDt        ());
			model.setVslCreOfcCd      	(data.getVslCreOfcCd     ());
			model.setVslDeltOfcCd     	(data.getVslDeltOfcCd    ());
			model.setVslBldAreaNm    	(data.getVslBldAreaNm    ());
			model.setGnrMkrNm          	(data.getGnrMkrNm        ());
			model.setGnrTpDesc         	(data.getGnrTpCd         ());
			model.setGnrBhpPwr         	(data.getGnrBhpPwr       ());
			model.setBwthstMkrNm       	(data.getBwthstMkrNm     ());
			model.setBwthstTpDesc       (data.getBwthstTpCd      ());
			model.setBwthstBhpPwr      	(data.getBwthstBhpPwr    ());
			model.setBwthstRpmPwr      	(data.getBwthstRpmPwr    ());
			model.setLloydNo         	(data.getLloydNo         ());
			model.setVslLnchDt         	(data.getVslLnchDt       ());
			model.setVslDeDt          	(data.getVslDeDt         ());
			model.setVslKelLyDt       	(data.getVslKelLyDt      ());
			model.setVslHlNo          	(data.getVslHlNo         ());
			model.setTtlTeuKnt         	(data.getTtlTeuKnt       ());
			model.setVslHtchKnt        	(data.getVslHtchKnt      ());
			model.setVslHldKnt        	(data.getVslHldKnt       ());
			model.setVslRmk             (data.getVslRmk          ());
			model.setCreUsrId         	(data.getCreUsrId        ());
			model.setCreDt              (data.getCreDt           ());
			model.setUpdUsrId          	(data.getUpdUsrId        ());
			model.setUpdDt              (data.getUpdDt           ());
			model.setDeltFlg            (data.getDeltFlg         ());
			model.setVslBldAreaNm		(data.getVslBldAreaNm());
			model.setEaiEvntDt			(getMsgCreDt());
			model.setMadnVoySuzNetTongWgt (data.getMadnVoySuzNetTongWgt ());
			model.setIntlTongCertiFlg 	(data.getIntlTongCertiFlg ());
			model.setMnEngHorPwrUtCd    (data.getMnEngHorPwrUtCd  ());
			model.setEaiIfId			(mdm.getEAIHeader().getInstanceId());			
			model.setVslLoclNm          (data.getVslLoclNm());  // 2012.03.19 컬럼추가 KIM HYUN HWA

			
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
		Iterator itr = models.iterator();
		
		MdmVslCntrVO model = null;
		String vslCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmVslCntrVO)itr.next();
				vslCd = model.getVslCd();
//				log.debug("MDM025 createMDMTB==");
				if(dbDao.searchMdmVslCntrList(vslCd)){
					if ( vslCd != null && vslCd.trim().length() > 0 ) {
						dbDao.addMdmVslCntrInsert(model);
					}
				}	
				else {
					if( vslCd !=null && vslCd.trim().length() > 0 ){
						dbDao.addMdmVslCntrUpdate(model);
					}
				}
			}
			isSuccessful = true;			
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
		Iterator itr = models.iterator();
		
		MdmVslCntrVO model = null;
		String vslCd = null;

		try {
			while (itr.hasNext()) {
				
				model = (MdmVslCntrVO)itr.next();
				vslCd = model.getVslCd();
				
				if ( vslCd !=null && vslCd.trim().length() > 0 
						&& !dbDao.searchMdmVslCntrList(vslCd)) {	
					dbDao.removeMdmVslCntr(model);
				}
			}
			isSuccessful = true;
			
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
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMdmVslCntr) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (createMdmVslCntr) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

}
