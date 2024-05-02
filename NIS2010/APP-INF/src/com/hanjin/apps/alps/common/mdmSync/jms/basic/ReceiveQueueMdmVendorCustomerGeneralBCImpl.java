/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_VENDORBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVendorCustomerGeneralDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0210001Document;
import com.hanjin.irep.mdm.MDM0210001Document.MDM0210001;
import com.hanjin.syscommon.common.table.MdmCustAddrVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmVendorMaster;
import com.hanjin.syscommon.common.table.MdmVendorVO;
 
/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0210001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0210001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVendorCustomerGeneralBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmVendorCustomerGeneralDBDAO dbDao = null;

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

	/** ReceiveQueueMDM_VENDORBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVendorCustomerGeneralBCImpl() {
		dbDao = new ReceiveQueueMdmVendorCustomerGeneralDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
		MdmVendorVO mdmVendorVO = null;
		List<MdmVendorVO> mdmVendorVOs = new ArrayList<MdmVendorVO>();

		MDM0210001Document mdmDoc = (MDM0210001Document) xmlObject;
		MDM0210001 mdm = mdmDoc.getMDM0210001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0210001Document.MDM0210001.DataArea data = mdm.getDataArea();
		if (data != null) {
			mdmVendorVO = new MdmVendorVO();
			
			mdmVendorVO.setVndrSeq                (data.getVndrSeq               ());
			mdmVendorVO.setVndrCntCd              (data.getVndrCntCd             ());
			mdmVendorVO.setVndrLglEngNm           (data.getVndrLglEngNm          ());
			mdmVendorVO.setVndrAbbrNm             (data.getVndrAbbrNm            ());
			mdmVendorVO.setVndrLoclLangNm         (data.getVndrLoclLangNm        ());
			mdmVendorVO.setLocCd                  (data.getLocCd                 ());
			mdmVendorVO.setOfcCd                  (data.getOfcCd                 ());
			mdmVendorVO.setCeoNm                  (data.getCeoNm                 ());
			mdmVendorVO.setRgstNo                 (data.getRgstNo                ());
			mdmVendorVO.setTaxId                  (data.getTaxPayrId             ());
			mdmVendorVO.setPrntCntCd              (data.getPrntCntCd             ());
			mdmVendorVO.setPrntVndrSeq            (data.getPrntVndrSeq           ());
			mdmVendorVO.setDcgoHndlFlg            (data.getDgCgoHndlFlg          ());
			mdmVendorVO.setSvcScpCdNm             (data.getSvcScpCdNm            ());
			mdmVendorVO.setSvcPrdTpNm             (data.getSvcPrdTpNm            ());
			mdmVendorVO.setSvcPrdRmk              (data.getSvcPrdRmk             ());
			mdmVendorVO.setBzctNm                 (data.getBzctNm                ());
			mdmVendorVO.setBztpNm                 (data.getBztpNm                ());
			mdmVendorVO.setGenPayTermCd           (data.getGenPayTermCd          ());
			mdmVendorVO.setEngAddr                (data.getEngAddr               ());
			mdmVendorVO.setLoclLangAddr           (data.getLoclLangAddr          ());
			mdmVendorVO.setLoclLangAddr2          (data.getLoclLangAddr2          ());
			mdmVendorVO.setLoclLangAddr3          (data.getLoclLangAddr3          ());
			mdmVendorVO.setLoclLangAddr4          (data.getLoclLangAddr4          ());
			mdmVendorVO.setZipCd                  (data.getZipCd                 ());
			mdmVendorVO.setCntcPsonNm             (data.getCntcPsonNmNm          ());
			mdmVendorVO.setInvCurrCd              (data.getInvCurrCd             ());
			mdmVendorVO.setPayCurrCd              (data.getPayCurrCd             ());
			mdmVendorVO.setPayMzdCd               (data.getPayMzdCd              ());
			mdmVendorVO.setUsaEdiCd               (data.getUsaEdiCd              ());
			mdmVendorVO.setWoAtchFileFlg          (data.getWoAtchFileFlg         ());
			mdmVendorVO.setWoEdiUseFlg            (data.getWoEdiUseFlg           ());
			mdmVendorVO.setInvEdiUseFlg           (data.getInvEdiUseFlg          ());
			mdmVendorVO.setMtyRroEdiUseFlg		  (data.getMtyRlseRdeOrdEdiUseFlg());
			mdmVendorVO.setModiVndrSeq	          (data.getModiVndrSeq	         ());
			mdmVendorVO.setBlkFlg                 (data.getBlkFlg                ());
			mdmVendorVO.setFincFlg                (data.getFincFlg               ());
			mdmVendorVO.setTeamFlg                (data.getTeamFlg               ());
			mdmVendorVO.setInterCoFlg             (data.getInterCoFlg            ());
			mdmVendorVO.setLgsFlg                 (data.getLgsFlg                ());
			mdmVendorVO.setProcuFlg               (data.getProcurementFlg        ());
			mdmVendorVO.setSubsCoCd				  (data.getInterCoCd			 ());
			mdmVendorVO.setOtrFlg                 (data.getOtrFlg                ());
			mdmVendorVO.setBlkVndrSvcCd           (data.getBlkVndrSvcCd          ());
//			mdmVendorVO.setInterCoFlg             (data.getInterCoCd             ());
			mdmVendorVO.setVndrOfcCd              (data.getVndrOfcCd             ());
			mdmVendorVO.setCreUsrId               (data.getCreUsrId              ());
			mdmVendorVO.setCreDt             	  (data.getCreDt                 ());
			mdmVendorVO.setUpdUsrId          	  (data.getUpdUsrId              ());
			mdmVendorVO.setUpdDt             	  (data.getUpdDt                 ());
			mdmVendorVO.setDeltFlg           	  (data.getDeltFlg               ());
			mdmVendorVO.setRfndPsdoCustCd    	  (data.getRfndPsdoCustCd        ());
			mdmVendorVO.setPayTermTpCd		      (data.getPayTermTpCd					 ());
			mdmVendorVO.setEaiEvntDt(getMsgCreDt());
			mdmVendorVO.setEaiIfId			       ( mdm.getEAIHeader().getInstanceId());
			// master setting 
//			model.setMdmVendermaster(mdmVndrMaster);
			mdmVendorVOs.add(mdmVendorVO);
		}
		return mdmVendorVOs;
	}

	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		try {
			List<MdmVendorVO> instVendor = new ArrayList<MdmVendorVO> ();
			List<MdmVendorVO> updVendor = new ArrayList<MdmVendorVO> ();
			
			List<MdmVendorVO> tmpList = (ArrayList<MdmVendorVO>) models;
			for (int i = 0; i < tmpList.size(); i ++) {
				MdmVendorVO tmp = tmpList.get(i);
				
				String tpb_cust = tmp.getRfndPsdoCustCd();
				if ( tpb_cust != null && tpb_cust.trim().length() > 0 ) {
					
					String cust_cnt_cd = tpb_cust.substring(0,2);
					Integer cust_seq = new Integer(tpb_cust.substring(2,tpb_cust.length())).intValue();

					MdmCustomerVO mdmCustomerVO = new MdmCustomerVO();
					MdmCustAddrVO mdmCustAddrVO = new MdmCustAddrVO();
					
					/// MDM_CUSTOMER 용 value object set
					
					mdmCustomerVO.setCustCntCd(cust_cnt_cd);
					mdmCustomerVO.setCustSeq(cust_seq.toString());
					mdmCustomerVO.setUpdUsrId( tmp.getUpdUsrId());
					mdmCustomerVO.setUpdDt( tmp.getUpdDt());
					mdmCustomerVO.setEaiEvntDt( tmp.getEaiEvntDt());
					mdmCustomerVO.setCustLglEngNm( tmp.getVndrLglEngNm());
					mdmCustomerVO.setCustLoclLangNm( tmp.getVndrLoclLangNm());
					String CustRgstNo = "";
					if(tmp.getVndrCntCd()!= null && tmp.getVndrCntCd().equals("KR")){
						CustRgstNo = tmp.getRgstNo();
					}else{
						CustRgstNo = tmp.getTaxId();
					}					
					mdmCustomerVO.setCustRgstNo(CustRgstNo);
					mdmCustomerVO.setBlkCustTpCd( tmp.getBlkVndrSvcCd());
					mdmCustomerVO.setOfcCd( tmp.getOfcCd());
					mdmCustomerVO.setLocCd( tmp.getLocCd());
					mdmCustomerVO.setVndrSeq( tmp.getVndrSeq());
					mdmCustomerVO.setCreUsrId( tmp.getCreUsrId());
					mdmCustomerVO.setCreDt( tmp.getCreDt());
					mdmCustomerVO.setEaiIfId( tmp.getEaiIfId());

					// MDM_CUST_ADDR 용 value object set
					mdmCustAddrVO.setCustCntCd(cust_cnt_cd);
					mdmCustAddrVO.setCustSeq(cust_seq.toString());			
					mdmCustAddrVO.setUpdUsrId( tmp.getUpdUsrId());
					mdmCustAddrVO.setUpdDt( tmp.getUpdDt());
					mdmCustAddrVO.setEaiEvntDt( tmp.getEaiEvntDt());	
					mdmCustAddrVO.setBzetAddr( tmp.getEngAddr());
					mdmCustAddrVO.setLoclAddr1(tmp.getLoclLangAddr());
					mdmCustAddrVO.setLoclAddr2(tmp.getLoclLangAddr2());
					mdmCustAddrVO.setLoclAddr3(tmp.getLoclLangAddr3());
					mdmCustAddrVO.setLoclAddr4(tmp.getLoclLangAddr4());
					mdmCustAddrVO.setBzetNm(tmp.getBzctNm());
					mdmCustAddrVO.setCreUsrId( tmp.getCreUsrId());
					mdmCustAddrVO.setCreDt( tmp.getCreDt());
					mdmCustAddrVO.setEaiIfId( tmp.getEaiIfId());
					
					dbDao.mergeMdmCustFrmVndr(mdmCustomerVO);
					dbDao.mergeMdmCustAddrFrmVndr(mdmCustAddrVO);
				}
				
				if (dbDao.searchMdmVendor(tmp.getVndrSeq())) {
					updVendor.add(tmp);
				} else {
					instVendor.add(tmp);
				}
			}
			if (instVendor.size() > 0)
				isSuccessful = dbDao.addMdmVendor(instVendor);
			
			if (updVendor.size() > 0) {
				isSuccessful = dbDao.modifyMdmVendor(updVendor);
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
			isSuccessful = dbDao.removeMdmVendor((List<MdmVendorVO>)models);
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
			log.info(" (createMDM_VENDOR) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_VENDOR) isSucessFlag : "
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
