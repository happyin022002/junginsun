/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SettlementClaimBCImpl.java
 *@FileTitle : SettlementClaimBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.22 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration.SettlementClaimDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration.SettlementClaimEAIDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwCargoInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.integration.ContainerCargoClaimReportDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * CNI Business Logic Basic Command implementation<br>
 * CNI 로직을 처리한다.<br>
 * 
 * @author jspark
 * @see SettlementClaimBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SettlementClaimBCImpl extends BasicCommandSupport implements SettlementClaimBC
{

    // Database Access Object
    private transient SettlementClaimDBDAO dbDao = null;
    private transient ContainerCargoClaimReportDBDAO reportDao = null;
    private transient ClaimMainDBDAO mainDao = null;
    /**
     * SettlementClaimBCImpl 객체 생성<br>
     * SettlementClaimDBDAO 생성한다.<br>
     */
    public SettlementClaimBCImpl()
    {
        dbDao = new SettlementClaimDBDAO();
        reportDao = new ContainerCargoClaimReportDBDAO();
        mainDao = new ClaimMainDBDAO();
    }

    // ===========================================================================
    // 박제성
    // ===========================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0014] SettlementClaim
    // ---------------------------------------------------------------------------
	/**
	 * Settlement 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0012
	 * @category searchSettlementInfo 
	 * @param String  cgoClmNo
     * @return List<SettlementVO>
     * @throws EventException
     */	
	
	public List<SettlementVO> searchSettlementInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchSettlementInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
	/**
	 * Settlement 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageSettlement
	 * @param CniSettlementVO cniSettlementVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageSettlement(CniSettlementVO cniSettlementVO) throws EventException {		
		try {
			String manageStr="";
			
			// 데이타 수정
			String exist = dbDao.searchSettlementExist(cniSettlementVO.getCgoClmNo());

			if (exist.equals("MS")) {
				dbDao.modifySettlement(cniSettlementVO);// 존재하면
				manageStr = "Y";
			}
			if (exist.equals("M")) {
				dbDao.addSettlement(cniSettlementVO);// 없으면
				manageStr = "Y";
			}
			if (exist.equals("")) {
				manageStr = "N";
			}
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
	
	/**
	 * Settlement Cancel 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category modifyClaimCancel
	 * @param CniSettlementVO cniSettlementVO	 
	 * @exception EventException
	 */
	public void  modifyClaimCancel(CniSettlementVO cniSettlementVO) throws EventException {		
		try {

				dbDao.modifyClaimCancel(cniSettlementVO);		
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	

	
	/**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @author 진윤오 
	 * @modifier 정윤태
	 * @category CNI_COM00050001
	 * @category searchGwCargoInfo
	 * @param String cgoClmNo
	 * @param String usrId
	 * @return GwCargoInfoVO 
	 * @exception EventException
	 */
	public String sendGwCargoClaimInfo(String cgoClmNo , String usrId) throws EventException {		
		try {
			//CC20090384
			GwCargoInfoVO gwVo = new GwCargoInfoVO();
			gwVo.setCgoClmNo(cgoClmNo);
			
			
			// -------------------------------------
			// 사용자 설정 (GW사용자 아이디 변환)
			// -------------------------------------			
			String gwUserId = dbDao.searchGwUserId(usrId);
			
			if (gwUserId == null) {
				gwUserId = usrId;
			}
			
			gwVo.setUserId(gwUserId);
			
			gwVo.setDocId("CNI_EP_1");
			gwVo.setReqId(cgoClmNo);
			gwVo.setUserTp("GR");
			gwVo.setSysTp("CNI");
			
			CargoClaimReportVO vo = reportDao.printCargoClaimReport(cgoClmNo, usrId);
			
			if (vo == null) {
				return null;
			}
			
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
			
		    pw.println("<?xml version=\"1.0\" encoding = \"EUC-KR\" ?>");
		    pw.println("<ROOT>");
		    pw.println("<HEADER></HEADER>");
		    pw.println("<BODY>");
		    pw.println("");
		    pw.println("<HO><![CDATA[" + vo.getHdlrOfcCd() + "]]></HO>");
		    pw.println("<STATUS><![CDATA[" + vo.getCgoClmStsCd() + " / " + CniUtil.getDtFmt(vo.getCgoClmStsDt())  + "]]></STATUS>");
		    pw.println("<DATE><![CDATA[" + vo.getCurDt() + "]]></DATE>");
		    pw.println("<PAGE><![CDATA[1/1]]></PAGE>");
		    pw.println("");
		    pw.println("<VVD><![CDATA[" + vo.getVslEngNm() + " / " + vo.getTrnkRefVvdNo() +"]]></VVD>");
		    pw.println("<BLNO><![CDATA[" + vo.getCgoClmRefBlNo() + "]]></BLNO>");
		    //Container No 다음 라인에 표기하기
		    pw.println("<CN><![CDATA[" + vo.getCgoClmRefCntrNo() + "]]></CN>");
		    pw.println("<SHIPPER><![CDATA[" + vo.getShprNm() + "]]></SHIPPER>");
		    pw.println("<CONSIGNEE><![CDATA[" + vo.getCneeNm() + "]]></CONSIGNEE>");
		    pw.println("<NOTIFY><![CDATA[" + vo.getNtfyNm() + "]]></NOTIFY>");
		    pw.println("<CQ><![CDATA[" + vo.getCgoQltyDesc() + "]]></CQ>");
		    pw.println("<CTR><![CDATA[" + vo.getCrrTermMiscNm() + "]]></CTR>");
		    pw.println("<CTRPOR><![CDATA[" + vo.getPorCd() + " / " + CniUtil.getDtFmt(vo.getRctDt()) + "]]></CTRPOR>");
		    pw.println("<CTRPOL><![CDATA[" + vo.getPolCd() + " / " + CniUtil.getDtFmt(vo.getLodgDt()) + "]]></CTRPOL>");
		    pw.println("<CTRPOD><![CDATA[" + vo.getPodCd() + " / " + CniUtil.getDtFmt(vo.getDchgDt()) + "]]></CTRPOD>");
		    pw.println("<CTRDEL><![CDATA[" + vo.getDelCd() + " / " + CniUtil.getDtFmt(vo.getDeDt()) + "]]></CTRDEL>");
		    pw.println("<CTRPREC><![CDATA[" + vo.getN1stPreRefVvdNo() + " (" + vo.getN1stPreTsLocCd() + "/" + CniUtil.getDtFmt(vo.getN1stPreTsDt())+  ")]]></CTRPREC>");
		    pw.println("<CTRONC><![CDATA[" + vo.getN1stPstRefVvdNo()+ " (" + vo.getN1stPstTsLocCd() + "/" + CniUtil.getDtFmt(vo.getN1stPstTsDt())+ ")]]></CTRONC>");
		    pw.println("<OFT><![CDATA[USD " +  CniUtil.toDecimalFormat(vo.getClmOfrtAmt(), "###,###.00") + " / " + vo.getOfrtTermMiscNm() + "]]></OFT>");
		    pw.println("<INSURER><![CDATA[" + vo.getInsurPtyNm() + "]]></INSURER>");
		   
		    
		    pw.println("");
		    pw.println("<CLAIMANT><![CDATA[" + vo.getClmtPtyNm() + "]]></CLAIMANT>");
		    pw.println("<AGENT><![CDATA[" + vo.getAgnPtyNm() + "]]></AGENT>");
		    pw.println("<FCROD><![CDATA[" + vo.getFmalClmRcvOfcCd() + " / " + CniUtil.getDtFmt(vo.getFmalClmRcvDt()) + "]]></FCROD>");
		    pw.println("<CA><![CDATA[" + vo.getClmtLoclCurrCd() + " " + CniUtil.toDecimalFormat(vo.getClmtLoclAmt(), "###,###.00") + "(USD " + CniUtil.toDecimalFormat(vo.getClmtUsdAmt(), "###,###.00") + ")]]></CA>");
		    pw.println("<COC><![CDATA["+ vo.getClmCuzDesc() +"]]></COC>");
		    pw.println("");
		    pw.println("<FF><![CDATA["+ vo.getFactFndDesc() +"]]></FF>");
		    pw.println("<FFTOC><![CDATA["+ vo.getCgoClmTpCd() +"]]></FFTOC>");
		    pw.println("<FFC1><![CDATA["+ vo.getMjrClmDmgLssCd() +"]]></FFC1>");
		    pw.println("<FFC2><![CDATA["+ vo.getN3rdLablPtyCd() +"]]></FFC2>");
		    pw.println("<FFPOI><![CDATA["+ vo.getClmInciPlcTpCd() +"]]></FFPOI>");
		    pw.println("");
		    pw.println("<MIRD><![CDATA["+ vo.getClmRvwDesc() +"]]></MIRD>");
		    pw.println("");

		    
		    pw.println("<LP><![CDATA["+ vo.getLablPtyPtyNm() +"]]></LP>");
		    pw.println("<LPCAD><![CDATA["+ vo.getLablPtyDmndCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getLablPtyDmndAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getLablPtyDmndUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getLablPtyFmalClmDt()) + "]]></LPCAD>");
		    pw.println("<LPRAD><![CDATA["+ vo.getLablPtyRcvrLoclCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getLablPtyRcvrLoclAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getLablPtyRcvrUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getLablPtyRcvrDt()) + "]]></LPRAD>");
		    pw.println("<DEVELOPMENT><![CDATA["+ vo.getLablPtyClmRmk()+"]]></DEVELOPMENT>");
		    pw.println("");
		    
		    pw.println("<OSP><![CDATA["+ vo.getCgoClmStlRmk()+"]]></OSP>");
		    //G/W 메일을 통한 기안 시 기안 내용에 항목 추가하기(Settle Amount, Dos)
		    pw.println("<OSP2><![CDATA["+ vo.getCgoClmStlLoclCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getCgoClmStlLoclAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getCgoClmStlUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getCgoClmStlDt()) + "]]></OSP2>");

		    pw.println("<OSPEUR><![CDATA[]]></OSPEUR>");
		    pw.println("");
		    pw.println("</BODY>");
		    pw.println("<SUBJECT><![CDATA[Draft-Cargo Claim]]></SUBJECT>");
		    pw.println("<CGOCLMNO><![CDATA[" + vo.getCgoClmNo()  + "]]></CGOCLMNO>");
		    pw.println("");
		    pw.println("</ROOT>");			
		    
		    gwVo.setXmlData(sw.toString());
		    
			SettlementClaimEAIDAO eaiDao = new SettlementClaimEAIDAO();			
			return eaiDao.sendGWData(gwVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
	/**
	 * Settlement GW Litigation 정보 eai 전송<br>
	 * 
	 * @author 진윤오
	 * @modifier 정윤태
	 * @category CNI_COM00050001
	 * @category searchGwCargoInfo
	 * @param String cgoClmNo
	 * @param String usrId
	 * @return String Gw URL 
	 * @exception EventException
	 */
	public String sendGwCargoLitigationInfo(String cgoClmNo , String usrId) throws EventException {	
		
		
		try {
			
			//CC20091452
			GwCargoInfoVO gwVo = new GwCargoInfoVO();
			gwVo.setCgoClmNo(cgoClmNo);
			
			// -------------------------------------
			// 사용자 설정 (GW사용자 아이디 변환)
			// -------------------------------------			
			String gwUserId = dbDao.searchGwUserId(usrId);
			
			if (gwUserId == null) {
				gwUserId = usrId;
			}
			
			gwVo.setUserId(gwUserId);
			
			
			gwVo.setDocId("CNI_EP_2");
			gwVo.setReqId(cgoClmNo);
			gwVo.setUserTp("GR");
			gwVo.setSysTp("CNI");

			CargoLitigationReportVO vo = reportDao.printCargoLitigationReport(cgoClmNo, usrId);
			
			if (vo == null) {
				return null;
			}
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
			
		    pw.println("<?xml version=\"1.0\" encoding = \"EUC-KR\" ?>");
		    pw.println("<ROOT>");
		    pw.println("<HEADER></HEADER>");
		    pw.println("<BODY>");
		    pw.println("");
		    pw.println("<HO><![CDATA[" + vo.getHdlrOfcCd() + "]]></HO>");
		    pw.println("<STATUS><![CDATA[" + vo.getCgoClmStsCd() + " / " + CniUtil.getDtFmt(vo.getCgoClmStsDt())  + "]]></STATUS>");
		    pw.println("<DATE><![CDATA[" + vo.getCurDt() + "]]></DATE>");
		    pw.println("<PAGE><![CDATA[1/1]]></PAGE>");
		    pw.println("");
		    pw.println("<VVD><![CDATA[" + vo.getVslEngNm() + " / " + vo.getTrnkRefVvdNo() +"]]></VVD>");
		    pw.println("<BLNO><![CDATA[" + vo.getCgoClmRefBlNo() + "]]></BLNO>");
		    //Container No 다음 라인에 표기하기
		    pw.println("<CN><![CDATA[" + vo.getCgoClmRefCntrNo() + "]]></CN>");
		    pw.println("<SHIPPER><![CDATA[" + vo.getShprNm() + "]]></SHIPPER>");
		    pw.println("<CONSIGNEE><![CDATA[" + vo.getCneeNm() + "]]></CONSIGNEE>");
		    pw.println("<NOTIFY><![CDATA[" + vo.getNtfyNm() + "]]></NOTIFY>");
		    pw.println("<CQ><![CDATA[" + vo.getCgoQltyDesc() + "]]></CQ>");
		    pw.println("<CTR><![CDATA[" + vo.getCrrTermMiscNm() + "]]></CTR>");
		    pw.println("<CTRPOR><![CDATA[" + vo.getPorCd() + " / " + CniUtil.getDtFmt(vo.getRctDt()) + "]]></CTRPOR>");
		    pw.println("<CTRPOL><![CDATA[" + vo.getPolCd() + " / " + CniUtil.getDtFmt(vo.getLodgDt()) + "]]></CTRPOL>");
		    pw.println("<CTRPOD><![CDATA[" + vo.getPodCd() + " / " + CniUtil.getDtFmt(vo.getDchgDt()) + "]]></CTRPOD>");
		    pw.println("<CTRDEL><![CDATA[" + vo.getDelCd() + " / " + CniUtil.getDtFmt(vo.getDeDt()) + "]]></CTRDEL>");
		    pw.println("<CTRPREC><![CDATA[" + vo.getN1stPreRefVvdNo() + " (" + vo.getN1stPreTsLocCd() + "/" + CniUtil.getDtFmt(vo.getN1stPreTsDt())+  ")]]></CTRPREC>");
		    pw.println("<CTRONC><![CDATA[" + vo.getN1stPstRefVvdNo()+ " (" + vo.getN1stPstTsLocCd() + "/" + CniUtil.getDtFmt(vo.getN1stPstTsDt())+ ")]]></CTRONC>");
		    pw.println("<OFT><![CDATA[USD " +  CniUtil.toDecimalFormat(vo.getClmOfrtAmt(), "###,###.00") + " / " + vo.getOfrtTermMiscNm() + "]]></OFT>");
		    pw.println("<INSURER><![CDATA[" + vo.getInsurPtyNm() + "]]></INSURER>");
		    
		    pw.println("");		    
		    pw.println("<PLAINTIFF><![CDATA[" + vo.getPltNm() + "]]></PLAINTIFF>");
		    pw.println("<PA><![CDATA[" + vo.getAgnPtyNm() + "l]]></PA>");
		    pw.println("<DEFENDANT><![CDATA[" + vo.getDeftNm() + "]]></DEFENDANT>");
		    pw.println("<DA><![CDATA[" + vo.getDeftAttyPtyNm() + "]]></DA>");
		    pw.println("<SSD><![CDATA[" +  CniUtil.getDtFmt(vo.getSmnsSveDt()) + "]]></SSD>");
		    pw.println("<CCN><![CDATA[" + vo.getCrtNm() +" / " + vo.getCrtCsNo() +"]]></CCN>");
		    pw.println("<CA><![CDATA[" + vo.getClmtLoclCurrCd() + " " +  CniUtil.toDecimalFormat(vo.getClmtLoclAmt(), "###,###.00") + "(USD " +  CniUtil.toDecimalFormat(vo.getClmtUsdAmt(), "###,###.00") + ")]]></CA>");
		    pw.println("<COC><![CDATA[" + vo.getClmCuzDesc() + "]]></COC>");
		    pw.println("");
		    pw.println("<CSD><![CDATA[" + vo.getLtgtCsDesc() + "]]></CSD>");		    
		    pw.println("");
		    
		    pw.println("<LP><![CDATA["+  vo.getLablPtyPtyNm() +"]]></LP>");
		    pw.println("<LPCAD><![CDATA["+ vo.getLablPtyDmndCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getLablPtyDmndAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getLablPtyDmndUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getLablPtyFmalClmDt()) + "]]></LPCAD>");
		    pw.println("<LPRAD><![CDATA["+ vo.getLablPtyRcvrLoclCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getLablPtyRcvrLoclAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getLablPtyRcvrUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getLablPtyRcvrDt()) + "]]></LPRAD>");
		    pw.println("<DEVELOPMENT><![CDATA["+ vo.getLablPtyClmRmk()+"]]></DEVELOPMENT>");
		    pw.println("");
		    
		    pw.println("<OSP><![CDATA["+ vo.getCgoClmStlRmk()+"]]></OSP>");
		    //G/W 메일을 통한 기안 시 기안 내용에 항목 추가하기(Settle Amount, Dos)
		    pw.println("<OSP2><![CDATA["+ vo.getCgoClmStlLoclCurrCd() +" " +  CniUtil.toDecimalFormat(vo.getCgoClmStlLoclAmt(), "###,###.00") + "  ( USD "+  CniUtil.toDecimalFormat(vo.getCgoClmStlUsdAmt(), "###,###.00") + " ) / " + CniUtil.getDtFmt(vo.getCgoClmStlDt()) + "]]></OSP2>");
		    pw.println("<OSPEUR><![CDATA[]]></OSPEUR>");
		    pw.println("");
		    pw.println("</BODY>");
		    pw.println("<SUBJECT><![CDATA[Draft-Cargo Litigation]]></SUBJECT>");
		    pw.println("<CGOCLMNO><![CDATA[" + vo.getCgoClmNo()  + "]]></CGOCLMNO>");
		    pw.println("");
		    pw.println("</ROOT>");			
		    
		    gwVo.setXmlData(sw.toString());
		    
			SettlementClaimEAIDAO eaiDao = new SettlementClaimEAIDAO();			
			return eaiDao.sendGWData(gwVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
	
	/**
	 *  Gw Status 정보 수정 EAI에서 수신<br>
	 * 
	 * @author 진윤오
	 * @category COM005R001
	 * @category manageGwStatus
	 * @param GwApproveStatusVO vo
	 * @exception EventException
	 */
	public void  manageGwStatus(GwApproveStatusVO vo) throws EventException {		
		try {
			boolean exeFlag = true;
			// ---------------------------------------------
			// 승인여부 
			// --------------------------------------------
			// C (CANCLE)       : EP내에서 결재 상신을 하기 전에 취소 or 삭제.
			// N (REJECT)        : 결재 상신 후 반송
			// Y (COMPLETE)  : 결재 완료.
			// P  - GW Draft Box에 저장 or 정상기안 , 최초 기안시
			String clmStlAuthCd = vo.getClmStlAuthCd();
			
			String gwId =  vo.getUpdUsrId();
			
			String usrId = dbDao.searchUserIdByGwUserId(gwId); 
			
			if (usrId == null) {
				usrId = gwId;
			}
			
			if ("P".equals(clmStlAuthCd)) {
				vo.setClmStlApplUsrId(usrId);
				vo.setClmStlApplDt(vo.getUpdDt());
			} else if ("C".equals(clmStlAuthCd) || "N".equals(clmStlAuthCd) || "Y".equals(clmStlAuthCd)) {
				vo.setClmStlAuthUsrId(usrId);
				vo.setClmStlAuthDt(vo.getUpdDt());
			} else {
				exeFlag = false;
			}
							
			if (exeFlag) {
				mainDao.modifyGwStatus(vo);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
	
	/** 
	 * Reopen시 Settlement 값 변경<br>
	 * @author 정행룡
	 * @category CPS_CNI_0037
	 * @category modifyReOpenSettlement
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @exception EventException
	 */
	public void modifyReOpenSettlement(String cgoClmNo , String updUsrId) throws EventException {
		try {		
			dbDao.modifyReOpenSettlement(cgoClmNo , updUsrId );
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
}