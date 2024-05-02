/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtEAIDAO.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBCImpl;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.ComUserVO;

/**
 *  OPUS TransshipmentMgtEAIDAO <br>
 *  EAIDAO 연동 처리 <br>
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TransshipmentMgtEAIDAO extends EAIDAOSupport {
	
	/**
	 * BKG:ESM_BKG_0495<br>
	 * RD Mail 전송<br>
	 * 
	 * @param SendTsListVO sendTsListVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EAIException 
	 */
	public String sendTsListByEmail(SendTsListVO sendTsListVO,SignOnUserAccount account) throws EAIException{
		BookingUtil util = null;
		ComUserVO comUserVO = null;
		try {
		    
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVOs = new ComRptDsgnXptInfoVO();
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOss = new ArrayList<ComRptDsgnXptInfoVO>();
			TemplateMail template = new TemplateMail();

			// 수정  account.getUsr_Eml() -> getDfltEml()
			util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = new BookingUtil().searchComUserInfo(account.getUsr_id()).getDfltEml();
			
//			template.setFrom(account.getUsr_eml());
			template.setFrom(sUsrEml);
			template.setRdSubSysCd(sendTsListVO.getSysApp());
			comRptDsgnXptInfoVOs.setRdTmpltNm(sendTsListVO.getMrd());
			template.setBatFlg(sendTsListVO.getBatchNo());
			template.setSubject(sendTsListVO.getRdtitle());
			comRptDsgnXptInfoVOs.setRdParaCtnt(sendTsListVO.getParam());
			template.setRecipient(sendTsListVO.getFaxmail());
			template.setArg("podlist", sendTsListVO.getContent());
			template.setArg("usr",account.getUsr_nm());
			template.setArg("fax",account.getFax_no());
			template.setHtmlTemplate("ESM_BKG_0495_01T.html"); 
			comRptDsgnXptInfoVOs.setXptFileNm("COMPANY T/S Loading List.pdf");
			comRptDsgnXptInfoVOs.setCreUsrId(account.getUsr_id());
			comRptDsgnXptInfoVOs.setUpdUsrId(account.getUsr_id());
			comRptDsgnXptInfoVOs.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVOss.add(comRptDsgnXptInfoVOs);
			template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOss);
			return template.send();
			 
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EAIException(ex.getMessage(), ex);
		}
	}
	
	
	/**
	 * BKG:ESM_BKG_0495<br>
	 * RD파일을 Fax로 전송<br>
	 * 
	 * @param SendTsListVO sendTsListVO
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EAIException
	 */
	public List<String> sendTsListByFax(SendTsListVO sendTsListVO,SignOnUserAccount account) throws EAIException{
		String[] arrFaxNo   = null;
                      
        arrFaxNo = sendTsListVO.getFaxmail().split(",");
        FaxMetaInfo[] infos = new FaxMetaInfo[arrFaxNo.length];
        try {
			for(int i=0; i<arrFaxNo.length; i++) {
				if( arrFaxNo[i].indexOf(";") == -1){	        	           
					arrFaxNo[i] = ";" + arrFaxNo[i] ;
				}	
				 
				infos[i] = new FaxMetaInfo(sendTsListVO.getSysApp()
						,sendTsListVO.getMrd()
						,sendTsListVO.getBatchNo()
						,sendTsListVO.getRdtitle()
						,sendTsListVO.getParam()
						,arrFaxNo[i]
						,account.getOfc_cd()
						,account.getUsr_id());        
			}
			return FaxUtility.registerDB(infos);	
        } catch (FaxSendException  faxe){
        	log.error(faxe.getMessage(),faxe);
        	throw new EAIException(faxe.getMessage(), faxe);
		}
	}
}
