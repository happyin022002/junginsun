/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CreateVskYardCngTmlBkgReceiptEdiBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.03.17
 *@LastModifier : 문동선
 *@LastVersion : 0.1
 * 2014.03.17
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VskYardCngBkgListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngDoubleCallEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdYardCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
/**
 * ALPS-CreateTmlBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - ALPS-CreateTmlBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */
public class CreateVskYardCngTmlBkgReceiptEdiBackEndJob   extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;

//	private VskVslPortSkdVO vskVslPortSkdVO;
//	private List<BkgBlNoVO> bkgBlNoVOs;
	private VslSkdCngUpdateVO vslSkdCngUpdateVO;
	private Vender301ParamVO vender301ParamVO;
	private SignOnUserAccount account;
	private HistoryLineVO historyLineVO;
	private boolean doubleCallFlag; 
	private List<VskYardCngBkgListVO> vskYardCngBkgListVOs;
	private List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs;

//	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
//		this.vskVslPortSkdVO = vskVslPortSkdVO;
//	}
//	public void setBbkgBlNoVOs(List<BkgBlNoVO> bkgBlNoVOs) {
//		this.bkgBlNoVOs = bkgBlNoVOs;
//	}
	public void setVslSkdCngUpdateVO(VslSkdCngUpdateVO vslSkdCngUpdateVO) {
		this.vslSkdCngUpdateVO = vslSkdCngUpdateVO;
	}
	public void setVender301ParamVO(Vender301ParamVO vender301ParamVO) {
		this.vender301ParamVO = vender301ParamVO;
	}
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}	
	public void setHistoryLineVO(HistoryLineVO historyLineVO) {
		this.historyLineVO = historyLineVO;
	}
	public void setDoubleCallFlag(boolean doubleCallFlag) {
		this.doubleCallFlag = doubleCallFlag;
	}	
	public void setVskYardCngBkgListVOs(List<VskYardCngBkgListVO> vskYardCngBkgListVOs) {
		this.vskYardCngBkgListVOs = vskYardCngBkgListVOs;
	}	
	public void setVslSkdCngDoubleCallEtcVOs(List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs) {
		this.vslSkdCngDoubleCallEtcVOs = vslSkdCngDoubleCallEtcVOs;
	}

	
	/**
	 * Terminal EDI (EDI301) 전송 업무 시나리오 선행작업<br>
	 * Terminal EDI (EDI301) 전송 업무 시나리오 호출시 관련 내부객체 생성<br>
	 *
	 * @return Object
	 * @exception Exception
	 */	
	public Object doStart() throws Exception {
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl(); 
		
		try{
			// 1. History 추가
			for(int j=0; j<vskYardCngBkgListVOs.size(); j++){
				HistoryLineVO historyLineVO2 = new HistoryLineVO();
				historyLineVO2 = (HistoryLineVO) historyLineVO.clone();
				historyLineVO2.setBkgNo(vskYardCngBkgListVOs.get(j).getBkgNo());
				historyBC.createBkgHistoryLine(historyLineVO2, account);
			}
			
			// 변경된 Yard 가 Route 에 있는 BKG List 조회
			//List<BkgBlNoVO> bkgBlNoVOs = receiptBC.searchVskYardCngBkgList(vslSkdCngUpdateVO);
//			List<BkgBlNoVO> bkgBlNoVOs2 = bkgBlNoVOs;
			Vender301ParamVO vender301ParamVO2 = vender301ParamVO;
			
			// BKG Vendor 301 전송
			for(int j=0; j<vskYardCngBkgListVOs.size(); j++){
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(vskYardCngBkgListVOs.get(j).getBkgNo());
				vender301ParamVO2.setBkgBlNoVO(bkgBlNoVO);
				
				List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO2, account);
				if("Y".equals(vender301ParamVO2.getAutoManualFlg())){
					for(int i=0;i<bkgNtcHisVOs.size();i++){
						bkgNtcHisVOs.get(i).setSndId("SYSTEM");					
					}
				}
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
			}
			
			
			// 2. 더블콜링 Port 면 Notice 발송
			if(doubleCallFlag && vskYardCngBkgListVOs.size()>0){//더블콜링이면
				// BKG Vendor 301 전송
				String preEml     = "";
				//String preBkgList = "";
				StringBuffer preBkgListBuff = new StringBuffer();
				
				//GeneralBookingReceiptDBDAOmakeVslSkdYardCngNoticeRSQL (VO생성용)
				VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO = new VslSkdYardCngNoticeVO();
				vslSkdYardCngNoticeVO.setVvd(vslSkdCngUpdateVO.getVvd());
				vslSkdYardCngNoticeVO.setPortCd(vslSkdCngUpdateVO.getPortCd());
				vslSkdYardCngNoticeVO.setOldYdCd(vslSkdCngUpdateVO.getOldYdCd());
				vslSkdYardCngNoticeVO.setOldClptIndSeq(vslSkdCngUpdateVO.getOldClptIndSeq());
				vslSkdYardCngNoticeVO.setOldEtdDt(vslSkdCngUpdateVO.getOldEtdDt());
				vslSkdYardCngNoticeVO.setOldEtaDt(vslSkdCngUpdateVO.getOldEtaDt());
				vslSkdYardCngNoticeVO.setNewYdCd(vslSkdCngUpdateVO.getNewYdCd());
				vslSkdYardCngNoticeVO.setNewClptIndSeq(vslSkdCngUpdateVO.getNewClptIndSeq());
				
				for(int j=0; j<vskYardCngBkgListVOs.size(); j++){
					String nowEml = vskYardCngBkgListVOs.get(j).getEml();
					String nowBkgNo = vskYardCngBkgListVOs.get(j).getBkgNo();
					
					if(preEml.equals(nowEml)){//앞과 같은 e-mail : bkg list 쌓기 
						preBkgListBuff.append(", ").append(nowBkgNo);
					}else{//새로운 eml : 앞 e-mail 로 send
						if(preEml!=null && !preEml.equals("")){
							vslSkdYardCngNoticeVO.setEml(preEml);
							vslSkdYardCngNoticeVO.setBkgList(preBkgListBuff.toString());
							receiptBC.sendVskSkdYardCngNotice(vslSkdYardCngNoticeVO, vslSkdCngDoubleCallEtcVOs, account);
						}
						
						preBkgListBuff.delete(0,preBkgListBuff.length());
						preBkgListBuff.append(nowBkgNo);
					}
					if(j==vskYardCngBkgListVOs.size()-1 && preEml!=null && !preEml.equals("") ){//마지막
						vslSkdYardCngNoticeVO.setEml(nowEml);
						vslSkdYardCngNoticeVO.setBkgList(preBkgListBuff.toString());
						receiptBC.sendVskSkdYardCngNotice(vslSkdYardCngNoticeVO, vslSkdCngDoubleCallEtcVOs, account);
					}			
					preEml = nowEml;
				}
			}
			
		}catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		}
		return null;
	}
}
