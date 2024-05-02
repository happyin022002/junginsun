/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUST_ADDRBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-22
 *@LastModifier : Kim Sung - Il
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2010-07-09 : [CHM-201004308] EAI_IF_ID 추가
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
import com.hanjin.irep.mdm.MDM0030001Document;
import com.hanjin.irep.mdm.MDM0030001Document.MDM0030001;


/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0360001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0360001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustAddrBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmCustAddrDBDAO dbDao = null;
	private transient ReceiveQueueMdmCustomerDBDAO dbCustDao = null;

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

	/** ReceiveQueueMDM_CUST_ADDRBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmCustAddrBCImpl() {
		dbDao = new ReceiveQueueMdmCustAddrDBDAO();
		dbCustDao = new ReceiveQueueMdmCustomerDBDAO();
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
	
	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		SearchMdmCustAddrVO model = null ;
		Collection models = new ArrayList();

		MDM0030001Document mdmDoc = (MDM0030001Document) xmlObject;
		MDM0030001 mdm = mdmDoc.getMDM0030001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		com.hanjin.irep.mdm.MDM0030001Document.MDM0030001.DataArea data = mdm
				.getDataArea();
		if (data != null) {
			model = new SearchMdmCustAddrVO();
			model.setCustCntCd    (data.getCustCntCd       ());
			model.setCustSeq     (data.getCustSeq         ());
			model.setAddrTpCd   (data.getAddrTpCd        ());
			model.setAddrSeq     (data.getAddrSeq         ());
			model.setPrmryChkFlg(data.getPrmryChkFlg     ());
			model.setBzetAddr    (data.getBzetAddr        ());
			model.setCtyNm       (data.getCtyNm           ());
			model.setSteCd       (data.getSteCd           ());
			model.setZipCd       (data.getZipCd           ());
			model.setCntcEml     (data.getCntcEml         ());
			model.setCntcPsonNm (data.getCntcPsonNm      ());
			model.setBzetRmk     (data.getBzetRmk         ());
			model.setCreUsrId   (data.getCreUsrId        ());
			model.setCreDt       (data.getCreDt           ());
			model.setUpdUsrId   (data.getUpdUsrId        ());
			model.setUpdDt       (data.getUpdDt           ());
			model.setDeltFlg     (data.getDeltFlg         ());
			model.setEaiEvntDt  (getMsgCreDt             ());
			model.setCrmRowId	  (data.getCustAddrRowId   ()); //2007.05.03 modify
			model.setCntCd	     (data.getCntCd()); 
			model.setEaiIfId(mdm.getEAIHeader().getInstanceId()); //2010.07.09 반영
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
			Iterator itr = models.iterator();
			SearchMdmCustAddrVO model = null;
			String custCntCd=null;
			String custSeq=null;
			String addrSeq=null;
			String addrTpCd=null;
			
			while (itr.hasNext()) {
				//getting each VO
				model = (SearchMdmCustAddrVO)itr.next();
				custCntCd = model.getCustCntCd();
				custSeq= model.getCustSeq();
				addrSeq = model.getAddrSeq();
				addrTpCd= model.getAddrTpCd();
				/*Insert or Update*/
				/*Insert*/
				boolean divisionFalg = dbDao.searchMDMCustAddrList(model); // data 가 없으면 true
				if(!divisionFalg){
					if (( custCntCd != null && custCntCd.trim().length() > 0 )
							&& ( custSeq != null && custSeq.trim().length() > 0 )
							&& ( addrTpCd != null && addrTpCd.trim().length() > 0 )		
							&& ( addrSeq != null && addrSeq.trim().length() > 0 )) {
						dbDao.addMdmCustAddr(model);
						
						boolean bkgFalg =dbDao.modifyBkgCustCdVal(model);
						//String add = model.getBzetAddr();
						//log.info("=====add========="+add+"======:"+bkgFalg);
						//log.info("=====ins========modifyBkgCustCdVal==========end====");
					}
				/*Update*/	
				}else{
					if (( custCntCd !=null && custCntCd.trim().length() > 0 )
							&& ( custSeq != null && custSeq.trim().length() > 0 )
							&& ( addrSeq != null && addrSeq.trim().length() > 0 )) {
						dbDao.modifyMdmCustAddr(model);
						//log.info("================modifyBkgCustCdVal=======start======");
						dbDao.modifyBkgCustCdVal(model);
						//String add = model.getBzetAddr();
						//log.info("=====add========="+add+"======");
						//log.info("================modifyBkgCustCdVal==========end====");
					}
				}//if
				
			}//while
			
			isSuccessful = true;
		}catch (DAOException de) {
			isSuccessful = false;
			log.error("err " + de.toString(), de);
			throw de;
		}//try
		return isSuccessful;
	}
	
	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		try {
			Iterator itr = models.iterator();
			SearchMdmCustAddrVO model = null;
			String custCntCd=null;
			String custSeq=null;
			String addrSeq=null;
			
			while (itr.hasNext()) {
				//getting each VO
				model = (SearchMdmCustAddrVO)itr.next();
				custCntCd = model.getCustCntCd();
				custSeq= model.getCustSeq();
				addrSeq = model.getAddrSeq();
				if ( custCntCd !=null && custCntCd.trim().length() > 0 
						&& custSeq !=null && custSeq.trim().length() > 0
						&& addrSeq !=null && addrSeq.trim().length() > 0
						&& ! dbDao.searchMDMCustAddrList(model)){
					
					dbDao.addMdmCustAddr(model);
					
				}
			}//while
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
			log.info(" (createMDM_CUST_ADDR) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_CUST_ADDR) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}
}
