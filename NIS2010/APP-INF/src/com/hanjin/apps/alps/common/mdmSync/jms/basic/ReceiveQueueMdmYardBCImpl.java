/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_YARDBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmYardDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmSubcontinentVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmYardVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0290001Document;
import com.hanjin.irep.mdm.MDM0290001Document.MDM0290001;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0290001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0290001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmYardBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmYardDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_YARDBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmYardBCImpl() {
		dbDao = new ReceiveQueueMdmYardDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmYardVO> receiveMDMTB(XmlObject xmlObject) {
		MdmYardVO model = null;
		Collection<MdmYardVO> models = new ArrayList<MdmYardVO>();

		MDM0290001Document mdmDoc = (MDM0290001Document) xmlObject;
		MDM0290001 mdm = mdmDoc.getMDM0290001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models	// =====
		com.hanjin.irep.mdm.MDM0290001Document.MDM0290001.DataArea data = mdm.getDataArea();
		if (data != null) {
			model = new MdmYardVO();
			model.setYdCd                  (data.getYdCd              ());
			model.setYdNm                  (data.getYdNm              ());
			model.setLocCd                 (data.getLocCd             ());
			model.setN1stVndrCntCd       (data.getN1StVndrCntCd     ());
			model.setN1stVndrSeq          (data.getN1StVndrSeq       ());
			model.setN2ndVndrCntCd       (data.getN2NdVndrCntCd     ());
			model.setN2ndVndrSeq          (data.getN2NdVndrSeq       ());
			model.setN3rdVndrCntCd       (data.getN3RdVndrCntCd     ());
			model.setN3rdVndrSeq          (data.getN3RdVndrSeq       ());
			model.setOfcCd                 (data.getOfcCd             ());
//			model.setAvgDwllHors           (data.getAvgDwllHors       ());
//			model.setMinDwllHors           (data.getMinDwllHors       ());
			model.setYdChrCd              (data.getYdChrCd           ());
			model.setYdFctyTpMrnTmlFlg (data.getYdFctyTpMrnTmlFlg ());
			model.setYdFctyTpCyFlg      (data.getYdFctyTpCyFlg     ());
			model.setYdFctyTpCfsFlg     (data.getYdFctyTpCfsFlg    ());
			model.setYdFctyTpRailRmpFlg(data.getYdFctyTpRailRmpFlg());
			model.setYdOshpCd             (data.getYdOshpCd          ());
			model.setBdYdFlg              (data.getBdYdFlg           ());
			model.setOnfHirYdFlg         (data.getOnoffHireYdFlg    ());
			model.setYdFtHors              (data.getYdFtHors          ());
			model.setRepZnCd              (data.getRepreZnCd         ());
			model.setYdAddr                (data.getYdAddr            ());
			model.setZipCd                 (data.getZipCd             ());
			model.setIntlPhnNo            (data.getIntlPhnNo         ());
			model.setPhnNo                 (data.getPhnNo             ());
			model.setFaxNo                 (data.getFaxNo             ());
			model.setYdPicNm              (data.getYdPicNm           ());
			model.setYdCeoNm              (data.getYdCeoNm           ());
			model.setGateOpnHrmnt         (data.getGateOpnHrMnt      ());
			model.setGateClzHrmnt         (data.getGateClzHrMnt      ());
			model.setHolGateOpnHrmnt     (data.getHolGateOpnHrMnt   ());
			model.setHolGateClzHrmnt     (data.getHolGateClzHrMnt   ());
			model.setSunGateOpnHrmnt     (data.getSunGateOpnHrMnt   ());
			model.setSunGateClzHrmnt     (data.getSunGateClzHrMnt   ());
			model.setSatGateOpnHrmnt     (data.getSatGateOpnHrMnt   ());
			model.setSatGateClzHrmnt     (data.getSatGateClzHrMnt   ());
			model.setYdCgoClzHrmntMsg   (data.getYdCgoClzHrMntDesc ());
			model.setYdRmk                 (data.getYdRmk             ());
			model.setBrthNo                (data.getBrthNo            ());
			model.setYdBrthLen            (data.getYdBrthLen         ());
			model.setYdBrthAlngSdDesc   (data.getYdBrthAlngSdDesc  ());
			model.setYdBrthDpthChnlKnt  (data.getYdBrthDpthChnlKnt ());
			model.setYdTtlSpc             (data.getYdTtlSpc          ());
			model.setYdActSpc             (data.getYdActSpc          ());
			model.setYdHjsSpc             (data.getYdHjsSpc          ());
			model.setYdHndlCapa           (data.getYdHndlCapa        ());
			model.setYdRfRcpt440vKnt    (data.getYdRfRcpt440VKnt   ());
			model.setYdRfRcpt220vKnt    (data.getYdRfRcpt220VKnt   ());
			model.setYdRfRcptDulKnt     (data.getYdRfRcptDulKnt    ());
			model.setYdOpSysCd           (data.getYdOpSysCd         ());
			model.setYdInrlFlg            (data.getYdInrRailFlg      ());
			model.setYdCfsSpc             (data.getYdCfsSpc          ());
			model.setMnrShopFlg           (data.getMnrShopFlg        ());
			model.setYdHndlYr             (data.getYdHndlYr          ());
			model.setYdTtlVolTeuKnt     (data.getYdTtlVolTeuKnt    ());
			model.setYdTtlVolBxKnt      (data.getYdTtlVolBxKnt     ());
			model.setYdHjsVolTeuKnt     (data.getYdHjsVolTeuKnt    ());
			model.setYdHjsVolBxKnt      (data.getYdHjsVolBxKnt     ());
			model.setYdPstPgcKnt         (data.getYdPstPnmGcrnKnt   ());
			model.setYdPgcKnt             (data.getYdPnmGcrnKnt      ());
			model.setTrstrKnt              (data.getTrstrKnt          ());
			model.setFrkKnt                (data.getFrkKnt            ());
			model.setYdStrdlCrrKnt       (data.getYdStrdlCarrKnt    ());
			model.setYdTrctKnt            (data.getYdTrctKnt         ());
			model.setYdTopLftKnt         (data.getYdTopLftKnt       ());
			model.setTmlChssKnt           (data.getTmlChssKnt        ());
			model.setEirSvcFlg            (data.getEirSvcFlg         ());
			model.setTmlProdKnt           (data.getTmlProdKnt        ());
			model.setYdCstmsNo            (data.getYdCstmsNo         ());
			model.setYdFctyTpPsdoYdFlg (data.getYdFctyTpPsdoYdFlg ());
			model.setYdEml                 (data.getYdEml             ());
			model.setDemIbCltFlg         (data.getDemIbCltFlg       ());
			model.setDemObCltFlg         (data.getDemObCltFlg       ());
			model.setBkgPodYdFlg         (data.getBkgPodYdFlg       ());
			model.setYdFctyTpBrgRmpFlg (data.getYdFctyTpBrgRmpFlg ());
			model.setBfrOfcCd             (data.getBfrOfcCd          ());
			model.setBfrOfcCngDt         (data.getBfrOfcChngDt      ());
			model.setModiYdCd             (data.getModiYdCd          ());
			model.setDmdtOfcCd            (data.getDmdtOfcCd         ());
			model.setCreUsrId             (data.getCreUsrId          ());
			model.setCreDt                 (data.getCreDt             ());
			model.setUpdUsrId             (data.getUpdUsrId          ());
			model.setUpdDt                 (data.getUpdDt             ());
			model.setDeltFlg               (data.getDeltFlg           ());
			model.setRepYdTpCd           (data.getRepYdTpCd         ());
			model.setHubYdFlg             (data.getHubYdFlg          ());
			model.setEaiEvntDt			(getMsgCreDt());
			model.setEaiIfId			(mdm.getEAIHeader().getInstanceId());
			model.setDryAvgDwllHrs			(data.getDryAvgDwllHrs());
			model.setDryMinDwllHrs			(data.getDryMinDwllHrs());
			model.setDryYdFtHrs			(data.getDryYdFtHrs());
			model.setYdLoclLangNm			(data.getYdLoclLangNm());
			model.setYdLoclLangAddr			(data.getYdLoclLangAddr());
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
		MdmYardVO model = null;
		String yd_cd = null;
		String nod_cd = null;
		try{
			Iterator<MdmYardVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmYardVO)itr.next();
				yd_cd = model.getYdCd();
				nod_cd = model.getYdCd();
				if(dbDao.searchMDM_YARDList(yd_cd)){
					if ( yd_cd != null && yd_cd.trim().length() > 0 ) {
						dbDao.addMdmYard(model);
					}	
				}else{
					if ( yd_cd !=null && yd_cd.trim().length() > 0 ){
						dbDao.modifyMdmYard(model);
					}
				}
				
				if(dbDao.searchPRD_NODEList(nod_cd)){
					if ( nod_cd != null  && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ) {
						dbDao.addPrdNode(model);
					}
				}else{
					if ( nod_cd !=null && !"null".equals(nod_cd) && nod_cd.trim().length() > 0 ){
						dbDao.modifyPrdNode(model);
					}
				}
				
			} 
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		isSuccessful = true;
		return isSuccessful;
		
	}
	

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false; 
		MdmYardVO model = null;
		String yd_cd = null;
		try{
			Iterator<MdmYardVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmYardVO)itr.next();
				yd_cd = model.getYdCd();
				if ( yd_cd !=null && yd_cd.trim().length() > 0 
						&& ! dbDao.searchMDM_YARDList(yd_cd)) {
					dbDao.removeMdmYard(model);
					
				}
				dbDao.removePrdNode(model);
			} 
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		isSuccessful = true;
		return isSuccessful;
		
	}
	

	/** OpCd 값(flag)에 따라 메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public void ctrlMDMTB(Collection models) throws DAOException{
		String OpCd = getOpCd();
		if (OpCd.equals("C") || OpCd.equals("U")) {
			OpCd = "U";

		}
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDM_YARD) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_YARD) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}
