/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptEAIDAO.java
*@FileTitle : GeneralBookingReceiptEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19 
* 1.0 Creation
* ======================================================================
* History
*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;


/**
 * NIS2010 GeneralBookingReceiptEAIDAO <br>
 * - NIS2010-GeneralBookingReceiptEAIDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see GeneralBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralBookingReceiptEAIDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -1184130086564280801L;

	/**
	 * Customer EDI로 전송 BackEndJob 결과를 확인하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Allocation 관련으로 StandBy되었음을 notice한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvrEml
	 * @param SignOnUserAccount account 
	 * @param String custRefNoCtnt
	 * @return List<BkgNtcHisVO>
	 * @exception Exception, DAOException
	 */
	public List<BkgNtcHisVO> sendStandByNotice(BkgBlNoVO bkgBlNoVO, String rcvrEml, SignOnUserAccount account, String custRefNoCtnt) throws Exception, DAOException {
		List<String> sndIds = null;
//		List<ComRptDsgnXptInfoVO> vos = null;
//		ArrayList<SingleMailAttachedFile> fileList = null;
//		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			sndIds = new ArrayList<String>();
			
//			vo = new ComRptDsgnXptInfoVO();
//			vo.setRdTmpltNm("ESM_BKG_5005G.mrd");
//			vo.setRdParaCtnt("/rv BKG_NO['"+bkgBlNoVO.getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS[] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]");
//			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
//			vo.setXptFileNm("HJSC"+bkgBlNoVO.getBkgNo()+".pdf");
//			vo.setCreUsrId(account.getUsr_id());
//			vo.setUpdUsrId(account.getUsr_id());
//			vos = new ArrayList<ComRptDsgnXptInfoVO>();
//			vos.add(vo);

			template = new TemplateMail();
			template.setBatFlg("N");
//			template.setComRptDsgnXptInfoVOs(vos);
			template.setFrom(sUsrEml,account.getUsr_nm());
			template.setRecipient(rcvrEml);
			template.setSubject("Standby Notice (BKG No : "+bkgBlNoVO.getBkgNo()+")");
//			template.setAttachedFile(fileList);
//			template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());			
			template.setHtmlTemplate("ESM_BKG_0098_03T.html");			
			template.setArg("bkgNoTitle","BKG No : "+bkgBlNoVO.getBkgNo());
			if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
				template.setArg("bkgNoBody",bkgBlNoVO.getBkgNo()+" (BKG Ref.No. : "+custRefNoCtnt+")");
			}else{
				template.setArg("bkgNoBody",bkgBlNoVO.getBkgNo());
			}
			
			sndIds.add(template.send());
			
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("SB"); // Standby 코드 추가
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(rcvrEml);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
	} 		
}
