/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUSTBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009.09.14 Oh hyun kyoung NIS2010 변환 
 * 2010.07.02 이행지 [CHM-201004395)    MDM Refund Customer Code 데이터 I/F 수정 및 데이터 이행건
 * 2010.07.09       [CHM-201004308]    EAI_IF_ID 추가
 * 2010.12.29 이행지  [CHM-201007972-01] MDM Customer I/F 변경 요청- 6개 컬럼 추가 
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCustAddrDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCustomerDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmCustAddrVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0010001Document;
import com.hanjin.irep.mdm.MDM0010001Document.MDM0010001;
import com.hanjin.syscommon.common.table.MdmCustCntcPntVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
 
/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0010001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0010001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustomerBCImpl extends BasicCommandSupport implements ReceiveQueueBC {
	
	private transient ReceiveQueueMdmCustomerDBDAO dbDao = null;
	private transient ReceiveQueueMdmCustAddrDBDAO addrDbDao = null;
	
	private String opCd = "";
	
	private String msgCreDt = "";
	
	/** ReceiveQueueMDM_CUSTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCustomerBCImpl() {
		dbDao = new ReceiveQueueMdmCustomerDBDAO();
		addrDbDao = new ReceiveQueueMdmCustAddrDBDAO();		
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
		MdmCustomerVO model = null;
		MdmCustCntcPntVO model2 = null;	
		//MdmCustAddrVO model3 = null;
		SearchMdmCustAddrVO model3 = null;
		Collection models = new ArrayList();
		MDM0010001Document mdmDoc = (MDM0010001Document) xmlObject;
		MDM0010001 mdm = mdmDoc.getMDM0010001();
		
		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
//		log.debug("MDM001 OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());
		setMsgCreDt(app.getMsgCreDt());
		
//		log.debug("MDM001 Start DataArea============" );
		// /===== Collect received data & Allocate them to Collection models		// =====
		com.hanjin.irep.mdm.MDM0010001Document.MDM0010001.DataArea data = mdm.getDataArea();
		
		Collection temp = null;
		if (data != null) {
			temp = new ArrayList();
			String eaiIfId = mdm.getEAIHeader().getInstanceId();
//			log.debug("MDM001 Cust Cd  : " + data.getCustCntCd() +"-"+data.getCustSeq());
//			log.debug("MDM001 SlsDeltEffRsnCd  : " + data.getSlsDeltEffRsnCd());
			model = new MdmCustomerVO();
			model.setCustCntCd       (data.getCustCntCd	      ());      
			model.setCustSeq         (data.getCustSeq         ());
			model.setCntrDivFlg      (data.getCntrDivFlg      ());
			model.setBlkDivFlg       (data.getBlkDivFlg       ());
			model.setCustGrpId       (data.getCustGrpCd       ());
			model.setCustLglEngNm    (data.getCustLglEngNm    ());
			model.setCustLoclLangNm  (data.getCustLoclLangNm  ());
			model.setCustAbbrNm      (data.getCustAbbrNm      ());
			model.setRvisCntrCustTpCd(data.getRvisCntrCustTpCd());
			model.setBlkCustTpCd     (data.getBlkCustTpCd     ());
			model.setIndivCorpDivCd  (data.getIndivCorpDivCd  ());
			model.setOfcCd           (data.getOfcCd           ());
			model.setFndtDt          (data.getFndtDt          ());
			model.setCustRgstNo      (data.getCustRgstNo      ());
			model.setFincStsLvlCd    (data.getFincStsLvlCd    ());
			model.setLocCd           (data.getLocCd           ());
			model.setCapiCurrCd      (data.getCapiCurrCd      ());
			model.setCapiAmt         (data.getCapiAmt         ());
			model.setLstkFlg         (data.getLstkFlg         ());
			model.setEmpeKnt         (data.getEmpeKnt         ());
			model.setVndrSeq         (data.getVndrSeq         ());
			model.setCustRmk         (data.getCustRmk         ());
			model.setVbsClssCd       (data.getValBseSegmClssCd());
			model.setNbsClssCd1      (data.getNdsBseSegmClssCd1());
			model.setNbsClssCd2      (data.getNdsBseSegmClssCd2());
			model.setNbsClssCd3      (data.getNdsBseSegmClssCd3());
			model.setCustStsCd       (data.getCustStsCd       ());
			model.setCrmRowId        (data.getCrmRowId        ());
			model.setNvoccHjsScacCd  (data.getNvoccHjsScacCd  ());
			model.setNvoccBdNo       (data.getNvoccBdNo       ());
			model.setNvoccLicNo      (data.getNvoccLicNo      ());
			model.setNvoccBdAmt      (data.getNvoccBdAmt      ());
			model.setNvoccBdStEffDt  (data.getNvoccBdStrtEffDt());
			model.setNvoccBdEndEffDt (data.getNvoccBdEndEffDt ());
			model.setIndusDesc       (data.getIndusDesc       ());
			model.setCrntVolKnt      (data.getCrntVolKnt      ());
			model.setCmptDesc        (data.getCpetiDesc       ());
			model.setSpclReqDesc     (data.getSpclReqDesc     ());
			model.setPrfSvcDesc      (data.getPrfSvcDesc      ());
			model.setPrfSvcDtlDesc   (data.getPrfSvcDtlDesc   ());
			model.setPrfGrpCmdtCd    (data.getPrfGrpCmdtCd    ());
			model.setPrfCntrTpszCd   (data.getPrfCntrTpszCd   ());
			model.setPrfRepCmdtCd    (data.getPrfRepreCmdtCd  ());
			model.setSrepCd          (data.getSrepCd          ());
			model.setCtsNo           (data.getCtsNo           ());
			model.setFrtFwrdFmcNo    (data.getFrtFwrdFmcNo    ());
			model.setKeyAcctFlg      (data.getKeyAcctFlg      ());
			model.setKeyAcctStEffDt  (data.getKeyAcctStrtEffDt());
			model.setKeyAcctEndEffDt (data.getKeyAcctEndEffDt ());
			model.setSubsCoCd        (data.getSsidiCoCd       ());
			model.setModiCustCntCd   (data.getModiCustCntCd   ());
			model.setModiCustSeq     (data.getModiCustSeq     ());
			model.setRfndPsdoVndrSeq (data.getN1StBkgNo());
			model.setBfrOfcCd        (data.getBfrOfcCd        ());
			model.setBfrOfcCngDt     (data.getBfrOfcChngDt    ());
			model.setCreUsrId        (data.getCreUsrId        ());
			model.setCreDt           (data.getCreDt           ());
			model.setUpdUsrId        (data.getUpdUsrId        ());
			model.setUpdDt           (data.getUpdDt           ());
			model.setDeltFlg         (data.getDeltFlg         ());
			model.setFrtFwrdFmcNo    (data.getFrtFwrdFmcNo    ());
			model.setEaiIfId		 (eaiIfId); //추가
			// 2010.12.29 이행지 [CHM-201007972-01] MDM Customer I/F 변경 요청- 6개 컬럼 추가
			model.setBkgAltCreDt    (data.getBkgAltCreDt());
			model.setBkgAltCreUsrId (data.getBkgAltCreUsrId());
			model.setBkgAltFmDt     (data.getBkgAltFmDt());
			model.setBkgAltMsg      (data.getBkgAltMsg());
			model.setBkgAltRsn      (data.getBkgAltRsn());
			model.setBkgAltToDt     (data.getBkgAltToDt());
			// 2011.04.05 KIM HYUN HWA 
			model.setOtiOrzNo(data.getOtiOrzNo());
			// 2011.05.16 KIM HYUN HWA 
			model.setRfAcctFlg(data.getRfAcctFlg());
			
			model.setEaiEvntDt(getMsgCreDt());
			//추가
			//model.setKeyAcctMgrGloUsrId(data.getKeyAcctMgrGloUsrId());
			//model.setKeyAcctMgrGloUsrNm(data.getKeyAcctMgrGloUsrNm());
			//model.setDeltEffDt(data.getDeltEffDt());
			//model.setSlsDeltFlg(data.getSlsDeltFlg());
			
			model.setKeyAcctMgrUsrId(data.getKeyAcctMgrGloUsrId());
			model.setKeyAcctMgrUsrNm(data.getKeyAcctMgrGloUsrNm());
			model.setSlsDeltEffDt(data.getDeltEffDt());
			//model.setSlsDeltFlg(data.getSlsDeltFlg());
			//추가 09.06.02
			model.setNmdCustFlg(data.getNmdCustFlg());

			//추가 2010.08.16 
			model.setMltTrdAcctFlg(data.getMltTrdAcctFlg());
			//2012.03.19 컬럼추가  KIM HYUN HWA
			model.setSlsDeltEffRsnCd(data.getSlsDeltEffRsnCd());
			//2012.10.09 컬럼 추가 cho won joo
			model.setNewKeyAcctFlg(data.getNewKeyAcctFlg());
			model.setGloAcctFlg(data.getGloAcctFlg());
			model.setRgnAcctFlg(data.getRgnAcctFlg());
			
			temp.add(model); 
			
			model2 = new MdmCustCntcPntVO();
			model2.setCustCntCd(data.getCustCntCd	 ());
			model2.setCustSeq   (data.getCustSeq    ());
			model2.setCustCntcPntSeq("1");
			model2.setCustEml   (data.getCustEml    ());
			model2.setCustIp    (data.getCustIp     ());
			model2.setCustUrl   (data.getCustUrl    ());
			model2.setIntlPhnNo(data.getMnIntlPhnNo());
			model2.setPhnNo     (data.getMnFullPhnNo());
			model2.setIntlFaxNo(data.getMnIntlFaxNo());
			model2.setFaxNo     (data.getMnFullFaxNo());
			model2.setEaiEvntDt(getMsgCreDt        ());
			model2.setEaiIfId  (eaiIfId);
			temp.add(model2);

			//추가 09.08.11
			model3 = new SearchMdmCustAddrVO();
			model3.setCustCntCd  (data.getCustCntCd       ());
			model3.setCustSeq     (data.getCustSeq         ());
			model3.setAddrTpCd   (data.getAddrTpCd        ());
			model3.setAddrSeq     (data.getAddrSeq         ());
			model3.setPrmryChkFlg(data.getPrmryChkFlg     ());
			model3.setBzetAddr    (data.getBzetAddr        ());
			model3.setCtyNm       (data.getCtyNm           ());
			model3.setSteCd       (data.getSteCd           ());
			model3.setZipCd       (data.getZipCd           ());
			model3.setCntcEml     ("");
			model3.setCntcPsonNm ("");
			model3.setBzetRmk     ("");
			model3.setCreUsrId   (data.getCreUsrId        ());
			model3.setCreDt       (data.getCreDt           ());
			model3.setUpdUsrId   (data.getUpdUsrId        ());
			model3.setUpdDt       (data.getUpdDt           ());
			model3.setDeltFlg     (data.getDeltFlg         ());//cust_sts_cd들어온 값으로 비교 'A'->'N', 그외 'Y'로.   에서 data.getDeltFlg로 로직 변경. eai에서 주는 대로 Update 하는 것으로 현 MDM 담당 박상국 수석님과 확인 완료. 20100330
			model3.setEaiEvntDt  (getMsgCreDt             ());
			model3.setCrmRowId   (data.getCustAddrRowId   ()); 
			model3.setCntCd	   (data.getCntCd		    ());
			model3.setEaiIfId(eaiIfId);
			temp.add(model3);			
			
			//models.add(model);
			models.add(temp);			

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

			Iterator itrs = models.iterator();
			Collection temp = null;
			
			Collection insList = new ArrayList();
			Collection updList = new ArrayList();
			Collection insCntcPntList = new ArrayList();
			Collection updCntcPntList = new ArrayList();			
			List insCustAddr = new ArrayList();
			List updCustAddr = new ArrayList();	
			Collection insSlsRep = new ArrayList();
			
			while(itrs.hasNext()){
				temp = (ArrayList)itrs.next();
				Iterator itr = temp.iterator();
				
				int k=1;
		
				while(itr.hasNext()){
					if(k%3 ==1)	{
						MdmCustomerVO model = (MdmCustomerVO)itr.next();
						String cust_cnt_cd = model.getCustCntCd();
						String cust_seq = model.getCustSeq();
						String srep_cd = model.getSrepCd();
//						log.debug("MDM010 check:::: cust_cnt_cd = " + cust_cnt_cd + " / cust_seq = " + cust_seq+" /model.getCustSeq()= "+model.getSlsDeltEffRsnCd());
						log.debug("****MDM010 CUSTOMER************");
						log.debug("cust_cnt_cd = " + cust_cnt_cd + " / cust_seq = " + cust_seq);
						//log.error(" value = " + dbDao.searchMdmCustList(cust_cnt_cd,cust_seq));
						if (cust_cnt_cd != null && cust_seq != null && !cust_cnt_cd.equals("") && !cust_seq.equals("")) {
							if (dbDao.searchMdmCustList(cust_cnt_cd, cust_seq)) {
								insList.add(model);
							} else {
								updList.add(model);
							}
							if (srep_cd != null && !srep_cd.equals("")) {
								if (dbDao.searchMdmCustSlsRepList(cust_cnt_cd, cust_seq, srep_cd)) {
									insSlsRep.add(model);
								}
							}
						}

					}else if(k%3 ==2) {
						MdmCustCntcPntVO model = (MdmCustCntcPntVO)itr.next();
						String cust_cnt_cd = model.getCustCntCd();
						String cust_seq = model.getCustSeq();
						String cust_cntc_pnt_seq = model.getCustCntcPntSeq();
						log.debug("\n yjyjyj : model.getEaiIfId"+model.getEaiIfId());
						if ( cust_cnt_cd != null && cust_seq != null && !cust_cnt_cd.equals("") && !cust_seq.equals("")) {
							if(dbDao.searchMdmCustCntcPntList(cust_cnt_cd,cust_seq, cust_cntc_pnt_seq)){
								insCntcPntList.add(model);							
							}else{
								updCntcPntList.add(model);
							}
						}
					}else{
						SearchMdmCustAddrVO model = (SearchMdmCustAddrVO)itr.next();
						String cust_cnt_cd = model.getCustCntCd();
						String cust_seq = model.getCustSeq();
						log.debug("****CUSTOMER ADDRESS************");
						log.debug("cust_cnt_cd = " + model.getCustCntCd() + " / cust_seq = " + model.getCustSeq());
						if ( cust_cnt_cd != null && cust_seq != null && !cust_cnt_cd.equals("") && !cust_seq.equals("")) {
							if(!addrDbDao.searchMDMCustAddrList(model)){ // data 가 없으면 true --> 있다는 이야기 --> 있으면 update
								insCustAddr.add(model);	
							}else{
								updCustAddr.add(model);							
							}
						}	
					}
					k++;
				}
			
			}
			log.debug("MDM010 BCimple DBDAO MdmCustomer  start");
			//mdm_customer insert
			if(insList != null && insList.size() > 0){
				isSuccessful = dbDao.addMdmCustomer((List<MdmCustomerVO>)insList);
				
				if(insSlsRep != null && insSlsRep.size() > 0){
					log.debug("\nMDM010 BCimple DBDAO Request update");
					dbDao.addBkgCustomerSlsRep((List<MdmCustomerVO>)insSlsRep);
				}
				
			}
		
			//mdm_customer update
			if(updList != null && updList.size() > 0){
				isSuccessful = dbDao.modifyMdmCustomer((List<MdmCustomerVO>)updList);
			}				
	
			//mdm_cust_cntc_pnt
			if(isSuccessful){
				if(insCntcPntList != null && insCntcPntList.size() > 0){
					isSuccessful = dbDao.addMdmCustCntcPnt((List<MdmCustCntcPntVO>)insCntcPntList);
				}
				if(updCntcPntList != null && updCntcPntList.size() > 0){
					isSuccessful = dbDao.modifyMdmCustCntcPnt((List<MdmCustCntcPntVO>)updCntcPntList);
				}
			}else{
				throw new DAOException("Fail to ReceiveQueueMdmCustomerBCImpl.modifyMdmCustomer ");				
			}
	
			//customer address 정보  insert/update	
			if(isSuccessful){
				if(insCustAddr != null && insCustAddr.size() > 0){
					//isSuccessful = addrDbDao.addMdmCustAddr((List<MdmCustAddrVO>)insCustADdr);
					for(int i=0; i<insCustAddr.size(); i++){
						SearchMdmCustAddrVO insVO = (SearchMdmCustAddrVO)insCustAddr.get(i);
						isSuccessful = addrDbDao.addMdmCustAddr(insVO);
					}
					dbDao.mergeBkgCustCdVal((List<MdmCustomerVO>)insList);
				}
				if(updCustAddr != null && updCustAddr.size() > 0){
					for(int i=0; i<updCustAddr.size(); i++){
						SearchMdmCustAddrVO updVO = (SearchMdmCustAddrVO)updCustAddr.get(i);
						isSuccessful = addrDbDao.modifyMdmCustAddr(updVO);
					}
					dbDao.mergeBkgCustCdVal((List<MdmCustomerVO>)updList);
				}
			}else{
				throw new DAOException("Fail to ReceiveQueueMdmCustomerBCImpl.addMdmCustCntcPnt ");				
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
			Iterator itrs = models.iterator();
			Collection temp = null;
			Collection updList = new ArrayList();
			Collection updCntcPntList = new ArrayList();			
			List updCustAddr = new ArrayList();	
			
			while (itrs.hasNext()) {
				temp = (ArrayList)itrs.next();
				Iterator itr = temp.iterator();
				
				int k=1;
				while(itr.hasNext()){
					if(k%3 ==1)	{
						MdmCustomerVO model = (MdmCustomerVO)itr.next();
			
						String cust_cnt_cd = model.getCustCntCd();
						String cust_seq = model.getCustSeq();
						if(!dbDao.searchMdmCustList(cust_cnt_cd,cust_seq)){
							updList.add(model);
						}
						
						dbDao.removeBkgCustCdVal(model);

					}else if(k%3 ==2) {
						MdmCustCntcPntVO model = (MdmCustCntcPntVO)itr.next();
						String cust_cnt_cd = model.getCustCntCd();
						String cust_seq = model.getCustSeq();
						String cust_cntc_pnt_seq = model.getCustCntcPntSeq();
						if(!dbDao.searchMdmCustCntcPntList(cust_cnt_cd,cust_seq, cust_cntc_pnt_seq)){
							updCntcPntList.add(model);							
						}

					}else{
						SearchMdmCustAddrVO model = (SearchMdmCustAddrVO)itr.next();
						if(addrDbDao.searchMDMCustAddrList(model)){
							updCustAddr.add(model);							
						}
					}					
					k++;					
				}
 			}		
			if(updList != null && updList.size() > 0){
				isSuccessful = dbDao.removeMdmCustomer((List<MdmCustomerVO>)updList);
			}						
			if(updCustAddr != null && updCustAddr.size() > 0){
				for(int i=0; i<updCustAddr.size(); i++){
					SearchMdmCustAddrVO updVO = (SearchMdmCustAddrVO)updCustAddr.get(i);
					isSuccessful = addrDbDao.removeMdmCustAddr(updVO);
				}
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
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		boolean isSuccessFlag = false;
		switch (OpCd.charAt(0)) {
		case 'U':
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDMCUST) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDMCUST) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
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
