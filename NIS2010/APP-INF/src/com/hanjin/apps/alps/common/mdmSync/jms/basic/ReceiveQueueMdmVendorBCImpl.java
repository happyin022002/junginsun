/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_VENDOR_TOTALBCImpl.java
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

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmCntrVndrClssDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVendorCustomerGeneralDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0190001Document;
import com.hanjin.irep.mdm.MDM0190001Document.MDM0190001;
import com.hanjin.irep.mdm.MDM0190001Document.MDM0190001.DataArea.VndrClss;
import com.hanjin.irep.mdm.MDM0190001Document.MDM0190001.DataArea.VndrClss.VndrClssIns;
import com.hanjin.syscommon.common.table.MdmCntrVndrClssVO;
import com.hanjin.syscommon.common.table.MdmCustAddrVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmVendorVO;
 
/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0190001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueBC,MDM0190001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVendorBCImpl extends BasicCommandSupport implements
		ReceiveQueueBC {
	private transient ReceiveQueueMdmVendorCustomerGeneralDBDAO dbDao = null;
	private transient ReceiveQueueMdmCntrVndrClssDBDAO cntrVenderClassDao = null;
	

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

	/** ReceiveQueueMDM_VENDOR_TOTALBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVendorBCImpl() {
		dbDao = new ReceiveQueueMdmVendorCustomerGeneralDBDAO();
		cntrVenderClassDao = new ReceiveQueueMdmCntrVndrClssDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection receiveMDMTB(XmlObject xmlObject) {
//		MdmVendor model = null;
		MdmVendorVO mdmVendorVO = null;
		List<MdmVendorVO> models = new ArrayList<MdmVendorVO>();

		MDM0190001Document mdmDoc = (MDM0190001Document) xmlObject;
		MDM0190001 mdm = mdmDoc.getMDM0190001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		log.info("\n //--->>>  ReceiveQueueMDM_VENDORBCImpl OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n //--->>>  ReceiveQueueMDM_VENDORBCImpl MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0190001Document.MDM0190001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			mdmVendorVO = new MdmVendorVO();
			
//			MdmVendorMaster venderMasterModel = new MdmVendorMaster();
			
			mdmVendorVO.setVndrSeq               (data.getVndrSeq               ());
			mdmVendorVO.setVndrCntCd             (data.getVndrCntCd             ());
			mdmVendorVO.setVndrLglEngNm          (data.getVndrLglEngNm          ());
			mdmVendorVO.setVndrAbbrNm            (data.getVndrAbbrNm            ());
			mdmVendorVO.setLocCd                 (data.getLocCd                 ());
			mdmVendorVO.setOfcCd                 (data.getOfcCd                 ());
			mdmVendorVO.setCeoNm                 (data.getCeoNm                 ());
			mdmVendorVO.setRgstNo                (data.getRgstNo                ());
			mdmVendorVO.setTaxId                 (data.getTaxPayrId             ());
			mdmVendorVO.setPrntCntCd             (data.getPrntCntCd             ());
			mdmVendorVO.setPrntVndrSeq           (data.getPrntVndrSeq           ());
			mdmVendorVO.setDcgoHndlFlg		   (data.getDgCgoHndlFlg          ());
			mdmVendorVO.setSvcScpCdNm            (data.getSvcScpCdNm            ());
			mdmVendorVO.setSvcPrdTpNm            (data.getSvcPrdTpNm            ());
			mdmVendorVO.setSvcPrdRmk             (data.getSvcPrdRmk             ());
			mdmVendorVO.setBzctNm                (data.getBzctNm                ());
			mdmVendorVO.setBztpNm                (data.getBztpNm                ());
			mdmVendorVO.setGenPayTermCd          (data.getGenPayTermCd          ());
			mdmVendorVO.setEngAddr               (data.getEngAddr               ());
			mdmVendorVO.setLoclLangAddr          (data.getLoclLangAddr          ());
			mdmVendorVO.setLoclLangAddr2          (data.getLoclLangAddr2          ());
			mdmVendorVO.setLoclLangAddr3          (data.getLoclLangAddr3          ());
			mdmVendorVO.setLoclLangAddr4          (data.getLoclLangAddr4          ());
//			vendorMasterModel.setLoclLangAddr3         (data.getLoclLangAddr3         ());
//			vendorMasterModel.setLoclLangAddr4         (data.getLoclLangAddr4         ());
			mdmVendorVO.setZipCd                 (data.getZipCd                 ());
			mdmVendorVO.setCntcPsonNm            (data.getCntcPsonNmNm          ());
			mdmVendorVO.setInvCurrCd             (data.getInvCurrCd             ());
			mdmVendorVO.setPayCurrCd             (data.getPayCurrCd             ());
			mdmVendorVO.setPayMzdCd              (data.getPayMzdCd              ());
			mdmVendorVO.setUsaEdiCd              (data.getUsaEdiCd              ());
			mdmVendorVO.setWoAtchFileFlg         (data.getWoAtchFileFlg         ());
			mdmVendorVO.setWoEdiUseFlg           (data.getWoEdiUseFlg           ());
			mdmVendorVO.setInvEdiUseFlg          (data.getInvEdiUseFlg          ());
			mdmVendorVO.setMtyRroEdiUseFlg	   (data.getMtyRlseRdeOrdEdiUseFlg());
			mdmVendorVO.setModiVndrSeq	       (data.getModiVndrSeq	          ());
			mdmVendorVO.setBlkFlg                (data.getBlkFlg                ());
			mdmVendorVO.setFincFlg               (data.getFincFlg               ());
			mdmVendorVO.setTeamFlg               (data.getTeamFlg               ());
			mdmVendorVO.setInterCoFlg            (data.getInterCoFlg            ());
			mdmVendorVO.setLgsFlg                (data.getLgsFlg                ());
			mdmVendorVO.setProcuFlg			   (data.getProcurementFlg        ());
			mdmVendorVO.setOtrFlg                (data.getOtrFlg                ());
			mdmVendorVO.setBlkVndrSvcCd          (data.getBlkVndrSvcCd          ());
			mdmVendorVO.setSubsCoCd				 (data.getInterCoCd             ());
			mdmVendorVO.setVndrOfcCd             (data.getVndrOfcCd             ());
			mdmVendorVO.setCreUsrId              (data.getCreUsrId              ());
			mdmVendorVO.setCreDt                 (data.getCreDt                 ());
			mdmVendorVO.setUpdUsrId              (data.getUpdUsrId              ());
			mdmVendorVO.setUpdDt                 (data.getUpdDt                 ());
//			mdmVendorVO.setDeltFlg               (data.getdDeltFlg				());
			mdmVendorVO.setRfndPsdoCustCd   	   (data.getRfndPsdoCustCd  ());
			mdmVendorVO.setPayTermTpCd			   (data.getPayTermTpCd			());
			mdmVendorVO.setVndrLoclLangNm	       (data.getVndrLoclLangNm	()); // 2007 12 07 hyunsu added ! 
			mdmVendorVO.setEaiEvntDt	           (getMsgCreDt());
			mdmVendorVO.setChkDeAddr1	           ( data.getChkDeAddr1() );
			mdmVendorVO.setChkDeAddr2			   ( data.getChkDeAddr2() );
			mdmVendorVO.setChkDeAddr3			   ( data.getChkDeAddr3() );
			mdmVendorVO.setChkDeCntCd			   ( data.getChkDeCntCd() );
			mdmVendorVO.setChkDeCtyNm			   ( data.getChkDeCtyNm() );
			mdmVendorVO.setChkDeSteCd			   ( data.getChkDeSteCd() );
			mdmVendorVO.setChkDeZipCd			   ( data.getChkDeZipCd() );
			mdmVendorVO.setEaiIfId			       ( mdm.getEAIHeader().getInstanceId());
			// master & detail setting 
			
			VndrClss vc = data.getVndrClss();
			if( vc != null )
			{
				VndrClssIns[] vndeClsArry = vc.getVndrClssInsArray();
//				MdmCntrVndrClssVO mdmCntrVndrClssArry[] = new MdmCntrVndrClssVO[vndeClsArry.length];
				List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs = new ArrayList<MdmCntrVndrClssVO>();
				
				for (int i = 0; i < vndeClsArry.length; i++) {
					MdmCntrVndrClssVO mdmCntrVndrClssVO = new MdmCntrVndrClssVO(); 
					mdmCntrVndrClssVO.setCntrVndrSvcCd(vndeClsArry[i].getCntrVndrSvcCd()); 
					mdmCntrVndrClssVO.setVndrCostCd(vndeClsArry[i].getVndrCostCd());
					
					mdmCntrVndrClssVO.setVndrSeq(data.getVndrSeq               			 ());
					mdmCntrVndrClssVO.setCreUsrId          (data.getCreUsrId              ());
					mdmCntrVndrClssVO.setCreDt              (data.getCreDt                 ());
					mdmCntrVndrClssVO.setUpdUsrId          (data.getUpdUsrId              ());
					mdmCntrVndrClssVO.setUpdDt              (data.getUpdDt                 ());
					mdmCntrVndrClssVO.setDeltFlg            ("N");
					mdmCntrVndrClssVO.setEaiEvntDt		  (getMsgCreDt					 ());
					mdmCntrVndrClssVO.setEaiIfId		  ( mdm.getEAIHeader().getInstanceId());
					mdmCntrVndrClssVOs.add(mdmCntrVndrClssVO);
				}
				mdmVendorVO.setMdmCntrVndrClss(mdmCntrVndrClssVOs);
			}

			models.add(mdmVendorVO);
		}
		return models ;
	}


	/** DBDAO의 addMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	public boolean createMDMTB(List<MdmVendorVO> models) throws DAOException{
		boolean isSuccessful = false;
		try {
			MdmVendorVO mdmVendorVO = models.get(0);// 단건만 처리하게 receiveMDMTB 에 되어 있으므로 0 index 처리
			
			if (mdmVendorVO != null) {
				
				if (dbDao.searchMdmVendor(mdmVendorVO.getVndrSeq())) {
					isSuccessful = dbDao.modifyMdmVendorInclChk(mdmVendorVO);
				} else {
					isSuccessful = dbDao.addMdmVendorInclChk(mdmVendorVO);
				}
				
				List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs = mdmVendorVO.getMdmCntrVndrClss();
				if (mdmCntrVndrClssVOs != null && mdmCntrVndrClssVOs.size() >= 1) {
					for (int i = 0 ; i < mdmCntrVndrClssVOs.size(); i ++) {
						MdmCntrVndrClssVO tmp = mdmCntrVndrClssVOs.get(i);
						if (cntrVenderClassDao.searchMdmCntrVndrClss(tmp)) {
							isSuccessful = cntrVenderClassDao.modifyMdmCntrVndrClss(tmp);
						} else {
							isSuccessful = cntrVenderClassDao.addMdmCntrVndrClss(tmp);
						}
					}
				} 
//				else {
//					if (mdmCntrVndrClssVOs == null)
//						log.error ("********** mdmCntrVndrClssVOs is null ");
//					else
//						log.error("mdmCntrVndrClssVOs.size() = " + mdmCntrVndrClssVOs.size());
//				}
				
				
				String tpb_cust = mdmVendorVO.getRfndPsdoCustCd();
				if ( tpb_cust != null && tpb_cust.trim().length() > 0 ) {
					
					String cust_cnt_cd = tpb_cust.substring(0,2);
					Integer cust_seq = new Integer(tpb_cust.substring(2,tpb_cust.length())).intValue();

					MdmCustomerVO mdmCustomerVO = new MdmCustomerVO();
					MdmCustAddrVO mdmCustAddrVO = new MdmCustAddrVO();
					
					/// MDM_CUSTOMER 용 value object set
					
					mdmCustomerVO.setCustCntCd(cust_cnt_cd);
					mdmCustomerVO.setCustSeq(cust_seq.toString());
					mdmCustomerVO.setUpdUsrId( mdmVendorVO.getUpdUsrId());
					mdmCustomerVO.setUpdDt( mdmVendorVO.getUpdDt());
					mdmCustomerVO.setEaiEvntDt( mdmVendorVO.getEaiEvntDt());
					mdmCustomerVO.setCustLglEngNm( mdmVendorVO.getVndrLglEngNm());
					mdmCustomerVO.setCustLoclLangNm( mdmVendorVO.getVndrLoclLangNm());
					String CustRgstNo = "";
					if(mdmVendorVO.getVndrCntCd()!= null && mdmVendorVO.getVndrCntCd().equals("KR")){
						CustRgstNo = mdmVendorVO.getRgstNo();
					}else{
						CustRgstNo = mdmVendorVO.getTaxId();
					}
					mdmCustomerVO.setCustRgstNo(CustRgstNo);
					mdmCustomerVO.setBlkCustTpCd( mdmVendorVO.getBlkVndrSvcCd());
					mdmCustomerVO.setOfcCd( mdmVendorVO.getOfcCd());
					mdmCustomerVO.setLocCd( mdmVendorVO.getLocCd());
					mdmCustomerVO.setVndrSeq( mdmVendorVO.getVndrSeq());
					mdmCustomerVO.setCreUsrId( mdmVendorVO.getCreUsrId());
					mdmCustomerVO.setCreDt( mdmVendorVO.getCreDt());
					mdmCustomerVO.setEaiIfId( mdmVendorVO.getEaiIfId());

					// MDM_CUST_ADDR 용 value object set
					mdmCustAddrVO.setCustCntCd(cust_cnt_cd);
					mdmCustAddrVO.setCustSeq(cust_seq.toString());			
					mdmCustAddrVO.setUpdUsrId( mdmVendorVO.getUpdUsrId());
					mdmCustAddrVO.setUpdDt( mdmVendorVO.getUpdDt());
					mdmCustAddrVO.setEaiEvntDt( mdmVendorVO.getEaiEvntDt());
					mdmCustAddrVO.setBzetAddr( mdmVendorVO.getEngAddr());
					mdmCustAddrVO.setLoclAddr1(mdmVendorVO.getLoclLangAddr());
					mdmCustAddrVO.setLoclAddr2(mdmVendorVO.getLoclLangAddr2());
					mdmCustAddrVO.setLoclAddr3(mdmVendorVO.getLoclLangAddr3());
					mdmCustAddrVO.setLoclAddr4(mdmVendorVO.getLoclLangAddr4());
					mdmCustAddrVO.setBzetNm(mdmVendorVO.getBzctNm());
					mdmCustAddrVO.setCreUsrId( mdmVendorVO.getCreUsrId());
					mdmCustAddrVO.setCreDt( mdmVendorVO.getCreDt());
					mdmCustAddrVO.setEaiIfId( mdmVendorVO.getEaiIfId());
					
					dbDao.mergeMdmCustFrmVndr(mdmCustomerVO);
					dbDao.mergeMdmCustAddrFrmVndr(mdmCustAddrVO);
				}
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
	public boolean removeMDMTB(List models) throws DAOException{
		boolean isSuccessful = false;
		try {
			isSuccessful = dbDao.removeMdmVendor((MdmVendorVO) models.get(0));
			isSuccessful = cntrVenderClassDao.removeMdmCntrVndrClss(((MdmVendorVO) models.get(0)).getMdmCntrVndrClss());
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
			isSuccessFlag = createMDMTB((List) models);
			log.info(" (createMDM_VENDOR) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			isSuccessFlag = removeMDMTB((List) models);
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
