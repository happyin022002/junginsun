/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueEAIDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.13
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.13 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

/*import java.util.ArrayList;
//import java.util.List;
//
//import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
//import com.clt.framework.component.fax.FaxMetaInfo;
//import com.clt.framework.component.fax.FaxSendException;
//import com.clt.framework.component.fax.FaxUtility;
//import com.clt.framework.component.javamail.MailerAppException;
//RD Mail Utility, RD Mail MetahInfo 삭제됨
//import com.clt.framework.component.util.DateTime;
//import com.clt.framework.support.view.signon.SignOnUserAccount;
//import com.clt.syscommon.common.table.BkgNtcHisVO;*/
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * TRO ORDER 관련 EAIDAO 연동 처리 트랙잭션을 처리한다.
 *
 * @author Jun Yong Jin
 * @see BDRCorrectionDBDAO
 * @since J2EE 1.4
 */
public class TransferOrderIssueEAIDAO extends EAIDAOSupport {
	// RD를 GeneralBookingSearchEDIDAO에서 보내는 것으로 변경되어서 기존 method 주석처리함

	/**
	 * 0866RD파일을 Fax로 전송
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String[] faxNo
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 */
/*	public List<BkgNtcHisVO> sendCHNoticeByFax(BkgBlNoVO[] bkgBlNoVO,String[] faxNo,String boundCd,SignOnUserAccount account) throws Exception{
//
//		FaxMetaInfo[] infos = new FaxMetaInfo[bkgBlNoVO.length];
//        try {
//        	for(int i=0;i<bkgBlNoVO.length;i++) {
//    			infos[i] = new FaxMetaInfo("BKG"
//    					,"ESM_BKG_0866.mrd"
//    					,"N"
//    					,"Title"
//    					,"["+bkgBlNoVO[i].getBkgNo()+"]["+account.getUsr_id()+"]"
//    					,faxNo[i]
//    					,account.getOfc_cd()
//    					,account.getUsr_id());
//        	}
//
//			List<String> sndIds = FaxUtility.registerDB(infos);
//			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
//			for (int i=0; i<sndIds.size(); i++) {
//				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
//				bkgNtcHisVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
//				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
//				bkgNtcHisVO.setNtcKndCd("BK");
//				bkgNtcHisVO.setNtcSeq("0");
//				bkgNtcHisVO.setCustCntcTpCd("");
//				bkgNtcHisVO.setNtcFaxNo(faxNo[i]);
//				bkgNtcHisVO.setSndId(sndIds.get(i));
//				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
//				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
//				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
//				bkgNtcHisVO.setDiffRmk("Title");
//				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
//				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
//				bkgNtcHisVOs.add(bkgNtcHisVO);
//			}
//			return bkgNtcHisVOs;
//
//        } catch (FaxSendException  faxe){
//        	throw new Exception(faxe.getMessage(), faxe);
//        } catch (Exception ex){
//			throw new Exception(ex.getMessage(), ex);
//		}
//	}*/

	/**
	 * 0866RD Mail 전송
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String[] emlAddr
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
/*	public List<BkgNtcHisVO> sendCHNoticeByEmail(BkgBlNoVO[] bkgBlNoVO,String[] emlAddr,String boundCd,SignOnUserAccount account) throws Exception{
//			//RD Mail Utility, RD Mail MetahInfo 삭제됨
//			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
//			
//			for (int i=0; i<sndIds.size(); i++) {
//				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
//				bkgNtcHisVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
//				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
//				bkgNtcHisVO.setNtcKndCd("BK");
//				bkgNtcHisVO.setNtcSeq("0");
//				bkgNtcHisVO.setCustCntcTpCd(null);
//				bkgNtcHisVO.setNtcEml(emlAddr[i]);
//				bkgNtcHisVO.setSndId(sndIds.get(i));
//				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
//				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
//				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
//				bkgNtcHisVO.setDiffRmk("Title");
//				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
//				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
//				bkgNtcHisVOs.add(bkgNtcHisVO);
//			}
//			return bkgNtcHisVOs;
//		}catch (RDMailSendException rde){
//			throw new Exception(rde.getMessage(), rde);
//		} catch (Exception e){
//			throw new Exception(e.getMessage(), e);
//		}
//	}*/

}
