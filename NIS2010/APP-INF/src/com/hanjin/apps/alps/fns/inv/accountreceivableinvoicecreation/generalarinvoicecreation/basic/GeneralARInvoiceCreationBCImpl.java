/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationBCImpl.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.10 최도순 [CHM-201005887] DEM/DET, MRI의 환율적용일자 로직 보완 요청
* 2010.09.10 최도순 [] 터미널 데이터를 ENIS_LOG 테이블에 저장
* 2010.09.16 최도순 [] OTHER I/F GL_EFF_DT 구하는 로직 변경
* 2010.09.29 최도순 [SRM-201009185] DEM/DET 인터페이스 로직 보완 요청 
* 2010.10.01 최도순 [] NO GOOD 인데 ERP전송되는 오류 수정
* 2010.10.20 최도순 [CHM-201006608] DEM/DET 데이터 A/R INVOICE로 인터페이스시 로직 변경 요청
* 2010.10.21 최도순 [CHM-201006525] A/R INVOICE의 DEM/DET 자료 인터페이스 로직 수정 요청
* 2010.10.22 최도순 [CHM-201006609] [A/R] DEMDET invoice의 이중 I/F 방지를 위한 보완
* 2010.10.22 최도순 [CHM-201007996] ALPS AR INVOICE 공동항차 환율 반영 요청
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.06.02 최도순 [CHM-201110756-01] BKG 이외 모듈에서 INVOICE 로 I/F 하는 로직에 ERP 호출 분리
* 2011.08.04 오요한 [CHM-20111????] POL, POD 없으면 에러 처리하도록 로직 추가
* 2011.08.10 오요한 [CHM-20111????] 공통항차 ASSIGN LOGIC 변경
* 2011.10.10 오요한 [CHM-20111????] OTHER I/F 로직보완
* 2012.02.20 권   민 [CHM-201216303] [INV] AR INV to ERP AR로 환율 데이터 IF시 보완 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationEAIDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.CntrTypeSizeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DOMDestInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.MRIRevenueVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.REVTypeSourceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.CutOffOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsm.ESM0670001Document;
import com.hanjin.irep.enisEsm.ESM0670001Document.ESM0670001;
import com.hanjin.irep.enisEsm.ESM0670001Document.ESM0670001.DataArea;
import com.hanjin.irep.enisEsm.ESM0670001Document.ESM0670001.DataArea.DOMDestInvInfo;
import com.hanjin.irep.enisEsm.ESM0670001Document.ESM0670001.DataArea.DOMDestInvInfo.DOMDestInvCollection;
import com.hanjin.irep.enisEsm.ESM0670001Document.ESM0670001.DataArea.DOMDestInvInfo.DOMDestInvCollection.DOMDestInvoice;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


/**
 * ALPS-AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung Hwi Taek
 * @see UbizhjsAlpsinvInvoicEvent, GeneralARInvoiceCreationBC 참조
 * @since J2EE 1.6
 */
public class GeneralARInvoiceCreationBCImpl extends BasicCommandSupport implements GeneralARInvoiceCreationBC {

	// Database Access Object
	private transient GeneralARInvoiceCreationDBDAO dbDao = null;
	private transient BookingARCreationEAIDAO eaiDao = null;
	
	InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
	BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	ManualARCreationBC manualARCreationBC = new ManualARCreationBCImpl();	
	
	INVCommonUtil utilCmd = new INVCommonUtil();

	/**
	 * GeneralARInvoiceCreationBCImpl 객체 생성<br>
	 * GeneralARInvoiceCreationBCImpl를 생성한다.<br>
	 */
	public GeneralARInvoiceCreationBCImpl() {
		dbDao = new GeneralARInvoiceCreationDBDAO();
		eaiDao = new BookingARCreationEAIDAO();
		invoiceIssueBC = new InvoiceIssueBCImpl();
		bookingARCreationBC = new BookingARCreationBCImpl();
		manualARCreationBC = new ManualARCreationBCImpl();	
		utilCmd = new INVCommonUtil();
	}
	
	/**
	 * GeneralARInvoiceCreationBCImpl 객체 생성<br>
	 * GeneralARInvoiceCreationBCImpl를 생성한다.<br>
	 *  @param String dataSource
	 */
	public GeneralARInvoiceCreationBCImpl(String dataSource) {
		dbDao = new GeneralARInvoiceCreationDBDAO(dataSource);
		eaiDao = new BookingARCreationEAIDAO();
		
		invoiceIssueBC = new InvoiceIssueBCImpl(dataSource);
		bookingARCreationBC = new BookingARCreationBCImpl(dataSource);
		manualARCreationBC = new ManualARCreationBCImpl(dataSource);
		utilCmd = new INVCommonUtil(dataSource);
	}


	/**
	 * ESM0670001Document XMLparsing <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return DOMDestInvoiceVO[]
	 * @exception EventException
	 */
	public DOMDestInvoiceVO[] esm0670001Receive(XmlObject xmlObject) throws EventException {
		log.debug("======================================");
		log.debug("xmlObject : " + xmlObject);
		log.debug("======================================");
		
		ESM0670001Document doc = (ESM0670001Document) xmlObject;
		ESM0670001 sync = doc.getESM0670001();
		DataArea data = sync.getDataArea();	
		DOMDestInvInfo dOMDestInvInfo = data.getDOMDestInvInfo();		
		DOMDestInvCollection rowset = dOMDestInvInfo.getDOMDestInvCollection();		
		DOMDestInvoice[] row = rowset.getDOMDestInvoiceArray();

		DOMDestInvoiceVO[] models = new DOMDestInvoiceVO[row.length];

		try {
			for (int i = 0; row != null && i < row.length; i++) {
				models[i] = new DOMDestInvoiceVO();

				models[i].setLifid(row[i].getLIFID());               
				models[i].setInvNo(row[i].getINVNO());               
				models[i].setCustCntCd(row[i].getCUSTCNTCD());       
				models[i].setCustSeq(row[i].getCUSTSEQ());           
				models[i].setOfcCd(row[i].getOFCCD());               
				models[i].setDom(row[i].getDOM());                   
				models[i].setVslCd(row[i].getVSLCD());               
				models[i].setSkdVoyNo(row[i].getSKDVOYNO());         
				models[i].setSkdDirCd(row[i].getSKDDIRCD());         
				models[i].setSvcScpCd(row[i].getSVCSCPCD());         
				models[i].setSlanCd(row[i].getSLANCD());             
				models[i].setSailDt(row[i].getSAILDT());             
				models[i].setSailArrDt(row[i].getSAILARRDT());       
				models[i].setDueDt(row[i].getDUEDT());               
				models[i].setGlEffDt(row[i].getGLEFFDT());           
				models[i].setIoBndCd(row[i].getIOBNDCD());           
				models[i].setTrnkVslCd(row[i].getTRNKVSLCD());       
				models[i].setTrnkSkdVoyNo(row[i].getTRNKSKDVOYNO()); 
				models[i].setTrnkSkdDirCd(row[i].getTRNKSKDDIRCD()); 
				models[i].setPorCd(row[i].getPORCD());               
				models[i].setPolCd(row[i].getPOLCD());               
				models[i].setPodCd(row[i].getPODCD());               
				models[i].setDelCd(row[i].getDELCD());               
				models[i].setBkgTeuQty(row[i].getBKGTEUQTY());       
				models[i].setBkgFeuQty(row[i].getBKGFEUQTY());       
				models[i].setChgSeq(row[i].getCHGSEQ());             
				models[i].setCurrCd(row[i].getCURRCD());             
				models[i].setChgCd(row[i].getCHGCD());               
				models[i].setChgFullNm(row[i].getCHGFULLNM());       
				models[i].setPerTpCd(row[i].getPERTPCD());           
				models[i].setTrfRtAmt(row[i].getTRFRTAMT());         
				models[i].setRatAsCntrQty(row[i].getRATASCNTRQTY()); 
				models[i].setChgAmt(row[i].getCHGAMT());             
				models[i].setInvXchRt(row[i].getINVXCHRT());         
				models[i].setTvaFlg(row[i].getTVAFLG());             
				models[i].setRepChgCd(row[i].getREPCHGCD());         
				models[i].setChgRmk(row[i].getCHGRMK());             
				models[i].setCntrSeq(row[i].getCNTRSEQ());           
				models[i].setCntrNo(row[i].getCNTRNO());             
				models[i].setCntrTpszCd(row[i].getCNTRTPSZCD());     
				models[i].setCreateUserId(row[i].getCREATEUSERID()); 
				models[i].setCreateDate(row[i].getCREATEDATE());     

			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}

		return models;
	}	
	
	/**
	 * Terminal 에서 발생한 매출채권 정보를 Interface 받는다. <br>
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> interfaceTerminalARInvoiceToIF(String rcvMsg, String userId, String integrationId) throws EventException {
	
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList<String> tmpArray = new ArrayList<String>();
		String tmpStr = "";
		String keyAndValue[] = null;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		
		String key = "";
		String value = "";
		String value2 = "";
		
		InvArIfMnVO invArIfMnVO = null;
		InvArIfChgVO invArIfChgVO = null;
		List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
		
		String srcIfDt = "";
		String srcIfSeq = "";
		
		String msgId = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		Date dt = new Date();
		srcIfDt = sdf.format(dt);	
		        
		List<ARInterfaceCreationVO> genIfVosDb = new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO genIfVoDb = new ARInterfaceCreationVO();
		InvArIfMnVO invArIfMnDbVO = null;
		List<InvArIfChgVO> invArIfChgDbVOs = null;
                
		try {
			
			//genIfVo = new ARInterfaceCreationVO();
			invArIfMnVO = new InvArIfMnVO();
			//invArIfChgVO = new InvArIfChgVO();			
			srcIfSeq = dbDao.searchSrcIfSeq();
			
			while (token.hasMoreTokens()) {
				
				tmpArray.add(token.nextToken());
			}
			
			tmpArrayMaxSize = tmpArray.size();
			//System.out.println("########## tmpArrayMaxSize : "+tmpArrayMaxSize);
			if(tmpArray != null && tmpArrayMaxSize > 0) {	
				
				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){
					
					tmpStr = tmpArray.get(i).toString().trim();
					
					if(tmpStr.equalsIgnoreCase("{CHG_INFO")) {
						invArIfChgVO = new InvArIfChgVO();
						//invArIfChgVO.setChgSeq(String.valueOf(seq++));
						
						invArIfChgVO.setSrcIfDt(srcIfDt);
					    invArIfChgVO.setSrcIfSeq(srcIfSeq);	
					    invArIfChgVO.setCreUsrId("TML I/F");
					    invArIfChgVO.setUpdUsrId("TML I/F");
						
					}
					
					if(tmpStr.equalsIgnoreCase("}CHG_INFO")) {
						invArIfChgVOs.add(invArIfChgVO);
					}
					
					if(tmpStr.equalsIgnoreCase("{CHG_INFO") || tmpStr.equalsIgnoreCase("}CHG_INFO")) continue;
					
					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					if(keyAndValue.length == 1) {
						value = "";
					} else if(keyAndValue.length == 2) {
						value = keyAndValue[1].trim();
						
					}else if(keyAndValue.length > 2){
						value2 = keyAndValue[2].trim();
					}
					
				    if(key.equalsIgnoreCase("INV_NO")) {
				    	invArIfMnVO.setInvSrcNo(value);
				    	invArIfMnVO.setBlSrcNo(value);
				    } else if(key.equalsIgnoreCase("SEQ_NO")) {
				    	invArIfMnVO.setFrtFwrdCustSeq(value);
				    //} else if(key.equalsIgnoreCase("FUNC_CD")) {
				    	//invArIfMnVO.setOrgMsgTp(value);
				    } else if(key.equalsIgnoreCase("OFC")) {
				    	invArIfMnVO.setOfcCd(value);
				    } else if(key.equalsIgnoreCase("ACT_CNTRY_CD")) {
				    	invArIfMnVO.setCustCntCd(value);
				    } else if(key.equalsIgnoreCase("ACT_CUST_CD")) {
				    	invArIfMnVO.setCustSeq(value);
				    } else if(key.equalsIgnoreCase("VVD")) {
				    	if(value != null && value.length()==9){
				    		invArIfMnVO.setVslCd(value.substring(0, 4));
				    		invArIfMnVO.setSkdVoyNo(value.substring(4, 8));
				    		invArIfMnVO.setSkdDirCd(value.substring(8, 9));
				    	}
				    } else if(key.equalsIgnoreCase("SVC_SCP")) {
				    	invArIfMnVO.setSvcScpCd(value);
				    } else if(key.equalsIgnoreCase("BND")) {
				    	invArIfMnVO.setIoBndCd(value);
				    } else if(key.equalsIgnoreCase("PORT")) {
				    	if(invArIfMnVO.getIoBndCd().equalsIgnoreCase("I")) {
				    		invArIfMnVO.setPodCd(value);
				        } else if(invArIfMnVO.getIoBndCd().equalsIgnoreCase("O")) {
				        	invArIfMnVO.setPolCd(value);
				        }	
				    } else if(key.equalsIgnoreCase("USER_ID")) {
				    	invArIfMnVO.setInvRefNo(value);
				    } else if(key.equalsIgnoreCase("INV_DESC")) {
				    	invArIfMnVO.setInvRmk(value);
				    } else if(key.equalsIgnoreCase("CHG_TYP")) {
				    	invArIfChgVO.setChgCd(value);				    	
					} else if(key.equalsIgnoreCase("CHG_AMT")) {
						invArIfChgVO.setChgAmt(value);
						// 추가일자 : 2010.02.16 ---------------------------------------------------
						invArIfChgVO.setRatAsCntrQty("1");
					    invArIfChgVO.setTrfRtAmt(value);
					    // ------------------------------------------------------------------------
					} else if(key.equalsIgnoreCase("CHG_CUR")) {
						invArIfChgVO.setCurrCd(value);
					} else if(key.equalsIgnoreCase("$$$MSGSTART")){
						msgId = value2;					
					}
				    
				    invArIfMnVO.setSrcIfDt(srcIfDt);
				    invArIfMnVO.setSrcIfSeq(srcIfSeq);
				    invArIfMnVO.setIfSrcCd("TML");		
				    invArIfMnVO.setCreUsrId("TML I/F");
				    invArIfMnVO.setUpdUsrId("TML I/F");	
				    				    				    
				} // end for(i)
				
				log.debug("msgId====="+msgId);
				log.debug("integrationId====="+integrationId);
				
				String strLogDesc = "[SRC_IF_DT:" + invArIfMnVO.getSrcIfDt()
					+ "] [SRC_IF_SEQ:" + invArIfMnVO.getSrcIfSeq()
					+ "] [BL_SRC_NO:" + invArIfMnVO.getBlSrcNo()
					+ "] [INV_SRC_NO:" + invArIfMnVO.getInvSrcNo()
					+ "] [MQ MSG_ID:" + integrationId
					+ "] [FlatFile MSG_ID:" + msgId + "]";
				    dbDao.addEnisLog("TML I/F", invArIfMnVO.getBlSrcNo() , strLogDesc);
				    
				dbDao.addInterfaceMain(invArIfMnVO);				
				dbDao.addInterfaceCharge(invArIfChgVOs);	
				
//				invArIfChgVOs.add(invArIfChgVO);
//				genIfVO.setInvArIfMnVO(invArIfMnVO);
//				genIfVO.setInvArIfChgVOs(invArIfChgVOs);				
//				genIfVOs.add(genIfVO);	
				
			}
			
			invArIfMnDbVO = dbDao.searchInvArIfMain(srcIfDt, srcIfSeq);
			invArIfChgDbVOs = dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
			
			genIfVoDb.setInvArIfMnVO(invArIfMnDbVO);
			genIfVoDb.setInvArIfChgVOs(invArIfChgDbVOs);
			genIfVosDb.add(genIfVoDb);
			
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}
		
		return genIfVosDb;
	}
	
	/**
	 * Booking 이외에 타 시스템 (DEM, DET, TPB, MNR, LSE )에서 발생한 매출채권 정보를 Interface 받는다. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */ 
	public List<ARInterfaceCreationVO> interfaceGeneralARInvoiceToIF(List<ARInterfaceCreationVO> genIfVos) throws EventException{
		
		ARInterfaceCreationVO genIfVo = null;		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		Date dt = new Date();
		
		String srcIfDt = "";
		String srcIfSeq = "";
		
		List<ARInterfaceCreationVO> genIfVosDb = new ArrayList<ARInterfaceCreationVO>();
		ARInterfaceCreationVO genIfVoDb = null;
		InvArIfMnVO invArIfMnVO = null;
		List<InvArIfChgVO> invArIfChgVOs = null;
		List<InvArIfCntrVO> invArIfCntrVOs = null;
                
		try {
			
			for (int rowNum = 0; rowNum < genIfVos.size(); rowNum++) {
				// 추가일자 : 2010.02.04 ---------------------------------------------------
				genIfVoDb = new ARInterfaceCreationVO();
				// ------------------------------------------------------------------------
				
				genIfVo = genIfVos.get(rowNum);
				
				log.debug("\n########## genIfVos.size() : "+genIfVos.size());
									
				// Key 번호 채번
				srcIfDt = sdf.format(dt);					
				srcIfSeq = dbDao.searchSrcIfSeq();
				
				// INV_AR_IF_MN table 저장
				genIfVo.getInvArIfMnVO().setSrcIfDt(srcIfDt);	
				genIfVo.getInvArIfMnVO().setSrcIfSeq(srcIfSeq);		
				dbDao.addInterfaceMain(genIfVo.getInvArIfMnVO());
								
				// INV_AR_IF_CHG table 저장
				if (genIfVo.getInvArIfChgVOs() != null) {
					for(int i = 0; i < genIfVo.getInvArIfChgVOs().size(); i++) {
						genIfVo.getInvArIfChgVOs().get(i).setSrcIfDt(srcIfDt);
						genIfVo.getInvArIfChgVOs().get(i).setSrcIfSeq(srcIfSeq);
					}
					dbDao.addInterfaceCharge(genIfVo.getInvArIfChgVOs());
				}
				
				// INV_AR_IF_CNTR table 저장
				if (genIfVo.getInvArIfCntrVOs() != null) {
					for(int i = 0; i < genIfVo.getInvArIfCntrVOs().size(); i++) {
						genIfVo.getInvArIfCntrVOs().get(i).setSrcIfDt(srcIfDt);
						genIfVo.getInvArIfCntrVOs().get(i).setSrcIfSeq(srcIfSeq);
					}					
					dbDao.addInterfaceContainer(genIfVo.getInvArIfCntrVOs());
				}		
				
				invArIfMnVO = dbDao.searchInvArIfMain(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfMain");
				invArIfChgVOs = dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfChg");
				invArIfCntrVOs = dbDao.searchInvArIfCntr(srcIfDt, srcIfSeq);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchInvArIfCntr");
				
				genIfVoDb.setInvArIfMnVO(invArIfMnVO);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfMnVO");
				genIfVoDb.setInvArIfChgVOs(invArIfChgVOs);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfChgVOs");
				genIfVoDb.setInvArIfCntrVOs(invArIfCntrVOs);				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invArIfCntrVOs");
				genIfVosDb.add(genIfVoDb);
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>genIfVoDb");
		    
			}
		
		} catch(DAOException ex) {
			log.info("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>interfaceGeneralARInvoiceToIF err" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.info("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>interfaceGeneralARInvoiceToIF err" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}	
		
		//return genIfVos;
		return genIfVosDb;
	}
		
	/**
	 * Booking 이외에 타 시스템 (DEM, DET, TPB, MNR, LSE,DOD )에서 Interface 받은 정보로 Invoice 정보를 생성하고 ERP 로 Interface 한다. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceGeneralARInvoiceToINV(List<ARInterfaceCreationVO> genIfVos) throws EventException {
			
		//INVCommonUtil utilCmd = new INVCommonUtil();
		
		VVDCustomerVO vvdCustomerVo = null;
		ExchangeRateVO exchangeRateVo = null;
		
		ARInterfaceCreationVO genIfVo = null;

		String errFlag = "N";
			
		String srcIfDt = "";
		String srcIfSeq = "";
		String ifFlag = "";
			
		String localTime = "";
		
		MdmOrganizationVO mdmOrgVo = null;
        String rhq = "";
        String arOfcCd = "";
        String newArOfcCd = "";
        String lclCurr = "";
        //String fxCurrRt = "";
        //String repCustCntCd = "";
        //String repCustSeq = "";
        String ofcAgentMark = "";
        //String ofcArControl = "";
        String invCoaCtrCd = "";
        String dmdtInvAplyBlFlg = "N";
        String arInvIssFlg = "N";
        String otsSmryCd = "";
        String xchRtUsdTpCd = "";
		
		BkgVvdVO bkgVvdVo = null;
		String vslCd = ""; ///// Main
		String skdVoyNo = ""; ///// Main
		String skdDirCd = ""; ///// Main
		String port = ""; ///// Main
				
		String trnkSkdVoyNo = ""; ///// Main
		String trnkVslCd = ""; ///// Main
		String trnkSkdDirCd = ""; ///// Main
		
		String sailDt = ""; ///// Main
				
//        MdmCustomerVO mdmCustVo = null;
        
        String rgnCdPor = "";
        String rgnCdDel = "";
        String svcScpCd = "";
        
        String usdXchRt = "0";
        
        VskVslPortSkdVO vskVslPortSkdVo = null;        
        String sailArrDt = "";
        String slanCd = "";
        
//        MdmCrCustVO mdmCrCustVo = null;
//        String crFlg = "";
//        String crTerm = "0";
        
        DueDateVO dueDateVo = null;
        String dueDt = "";
        // -- 수정일자 : 2009.12.23(0->"") -----------------------------------------
        String crTermDys = "";
        // ------------------------------------------------------------------------
        String custCrFlg = "N";
        
        String destTrnsSvcModCd = "";
        
        String mriMaxYymm = "";
        String svrId = "";
        String glEffDt = "";
        String blInvCfmDt = "";
        
        String taxInd = "0";
        
        String zoneIoc = "";
        
        String revLane = "";
        String revVvd = "";
        
        String tVslCd = "";
        
        String locCd = "";
        
        String blObrdDt = "";

        String subsCoCd = "";
        
        String repChgCd = "";		
        String chgFullNm = "";	
        String erpIfOfcCd = "";
        REVTypeSourceVO revTypeSrcVo = null;
        String revTpCd = "M";
        String revSrcCd = "TM";
        String invRevTpSrcCd = "";
        String revCoaCoCd = "";
		String revCoaRgnCd = "";
		String revCoaCtrCd = "";
        String invXchRt = "0";
        String invAcctDivCd = "";		
        String acctCd = "";
        String tjSrcNm = "";
        
//        InvIssueFlagVO invIssFlagVo = null;
//        String issueFlag = "";
//        String reIssueFlag = "";
        
        MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
        
        InvArMnVO invArMnVo = null;
        String arIfNo = "";
        String arIfNos = "";
        
        String invCoaRgnCd = "";
        
        List<InvArChgVO> invArChgVos = null;
        InvArChgVO invArChgVo = null;
        
        List<InvArCntrVO> invArCntrVos = null;
        InvArCntrVO invArCntrVo = null;
        
		//List<InvArCntrVO> list = null;
		List<CntrTypeSizeVO> cntrTypeSizeVos = null;
		//List<Fns0120001VO> fns0120001Vos = null;
        String cntrNos = "";
		String cntrTpSzs = "";
		int lastIdx = 0;
		
		InvArAmtVO invArAmtVo = null;
		
		String bkgNo = "";
		String errRsn = "";
		
		// -- 추가일자 : 2009.12.23 ------------------------------------------------
		String dueDtYn = "N";
		// ------------------------------------------------------------------------

		// -- 추가일자 : 2009.12.29 ------------------------------------------------
        String cntCd = "";
        // ------------------------------------------------------------------------
        
        // -- 추가일자 : 2010.02.18 ------------------------------------------------
        String ofcCd = "";
        
        // ------------------------------------------------------------------------
        
        ARCreditVO aRCreditVO = new ARCreditVO();
        ARCreditInputVO arCrdtVo = new ARCreditInputVO();
        CutOffOfficeVO cutOffVo = new CutOffOfficeVO();
        
        //2014-05-27 소스품질 보완
        StringBuffer arIfNosBuff = new StringBuffer();
        StringBuffer cntrNosBuff = new StringBuffer();
        StringBuffer cntrTpSzsBuff = new StringBuffer();
        
        //2010-08-11 DEM/DET VVD로직 변경관련 추가
        String tsDivCd = "";
        
        //2010.10.21 최도순 [CHM-201006525] A/R INVOICE의 DEM/DET 자료 인터페이스 로직 수정 요청
        String ofcTrnsFlg = "";
        String ioBndCd = "";
        String porCd = "";
        String polCd = "";
        String podCd = "";
        String delCd = "";
        String custCntCd = "";
        String custSeq = "";
        
        String crInvNo ="";
        
		try {
			
			log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1");
			
			// genIfVos looping 시작
			for (int rowNum = 0; rowNum < genIfVos.size(); rowNum++) { 
				genIfVo = genIfVos.get(rowNum);
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2");
				
				srcIfDt = genIfVo.getInvArIfMnVO().getSrcIfDt();
				srcIfSeq = genIfVo.getInvArIfMnVO().getSrcIfSeq();	
				
				log.debug("\n########## srcIfDt : "+srcIfDt);
				log.debug("\n########## srcIfSeq : "+srcIfSeq);
				
				vslCd = genIfVo.getInvArIfMnVO().getVslCd() != null ? genIfVo.getInvArIfMnVO().getVslCd() : ""; ///// Main
				skdVoyNo = genIfVo.getInvArIfMnVO().getSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getSkdVoyNo() : ""; ///// Main
				skdDirCd = genIfVo.getInvArIfMnVO().getSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getSkdDirCd() : ""; ///// Main
				port = genIfVo.getInvArIfMnVO().getIoBndCd().equals("O") ? genIfVo.getInvArIfMnVO().getPolCd() : genIfVo.getInvArIfMnVO().getPodCd(); ///// Main
				trnkSkdVoyNo = genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() : ""; ///// Main
				trnkVslCd = genIfVo.getInvArIfMnVO().getTrnkVslCd() != null ? genIfVo.getInvArIfMnVO().getTrnkVslCd() : ""; ///// Main
				trnkSkdDirCd = genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getTrnkSkdDirCd() : ""; ///// Main
				rgnCdPor = genIfVo.getInvArIfMnVO().getPorCd();
		        rgnCdDel = genIfVo.getInvArIfMnVO().getDelCd();
		        svcScpCd = genIfVo.getInvArIfMnVO().getSvcScpCd();
		        sailArrDt = genIfVo.getInvArIfMnVO().getSailArrDt();
		        slanCd = genIfVo.getInvArIfMnVO().getSlanCd();
		        dueDt = genIfVo.getInvArIfMnVO().getDueDt(); 
		        glEffDt = genIfVo.getInvArIfMnVO().getGlEffDt();
		        bkgNo = genIfVo.getInvArIfMnVO().getBkgNo() != null ? genIfVo.getInvArIfMnVO().getBkgNo() : "";
		        
		      //2010-08-11 DEM/DET VVD로직 변경관련 추가
		        tsDivCd = genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd()!= null ? genIfVo.getInvArIfMnVO().getDestTrnsSvcModCd(): "";
		      
		      //2010.10.21 최도순 [CHM-201006525] A/R INVOICE의 DEM/DET 자료 인터페이스 로직 수정 요청  
		        ofcTrnsFlg = genIfVo.getInvArIfMnVO().getOfcTrnsFlg()!= null ? genIfVo.getInvArIfMnVO().getOfcTrnsFlg(): "";
		        ioBndCd = genIfVo.getInvArIfMnVO().getIoBndCd()!= null ? genIfVo.getInvArIfMnVO().getIoBndCd(): "";
		        porCd = genIfVo.getInvArIfMnVO().getPorCd()!= null ? genIfVo.getInvArIfMnVO().getPorCd(): "";
		        polCd = genIfVo.getInvArIfMnVO().getPolCd()!= null ? genIfVo.getInvArIfMnVO().getPolCd(): "";
		        podCd = genIfVo.getInvArIfMnVO().getPodCd()!= null ? genIfVo.getInvArIfMnVO().getPodCd(): "";
		        delCd = genIfVo.getInvArIfMnVO().getDelCd()!= null ? genIfVo.getInvArIfMnVO().getDelCd(): "";
		        custCntCd = genIfVo.getInvArIfMnVO().getCustCntCd()!= null ? genIfVo.getInvArIfMnVO().getCustCntCd(): "";
		        custSeq = genIfVo.getInvArIfMnVO().getCustSeq()!= null ? genIfVo.getInvArIfMnVO().getCustSeq(): "";
		        
		        crInvNo = genIfVo.getInvArIfMnVO().getCrInvNo()!= null ? genIfVo.getInvArIfMnVO().getCrInvNo(): "";				
				log.debug("\n########## genIfVos.size() : "+genIfVos.size());
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>3");
				
				//2010.10.22 최도순 [CHM-201006609] [A/R] DEMDET invoice의 이중 I/F 방지를 위한 보완
				//2014.07.22 DEC - DEM/DET 에서 I/F  CDD Charge에 대해서 type 분리 
				//DEM - DMOF, DMIF,     DET - DTOC, DTIC,     DEC - CTOC, CTIC,
				if(genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")){
					int dupCnt = dbDao.searchLastDMTInvNo(genIfVo.getInvArIfMnVO().getBlSrcNo(), genIfVo.getInvArIfMnVO().getInvSrcNo());
					
					if( dupCnt > 0 ){
						errRsn = "Your invoice is interfaced to A/R already.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;		
					}
				}
				
				// genIfVo looping 시작  (break 문을 사용하기위해 for 문을 사용함)
				for (int idx = 0; idx < 1; idx++) {
					
					////////////////////////////////////////////////////////////////////////////
	                ////////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////////
					
					if (genIfVo.getInvArIfMnVO().getOfcCd().equals("")) {
						errRsn = "Office Code Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;						
					}					
					
					if (bkgNo.equals("") && (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD"))) {
						errRsn = "Bkg No. Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;						
					}	
					
					if (polCd == null ||polCd.equals("") || podCd == null ||podCd.equals("")) {					
						errRsn = "POL or POD Not Exists.";				
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);				
						errFlag = "Y";				
						break;				
					}	
					
					if (custCntCd.equals("") || custSeq.equals("")) {			 //customer code validation 로직 추가		
						errRsn = "Customer Code Not Exists.";				
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);				
						errFlag = "Y";				
						break;				
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>4");
					
					if (genIfVo.getInvArIfChgVOs() != null) {
						
						int cnt = 0;
						String chgCd = "";
						String trfRtAmt = "";
						String ratAsCntrQty = "";
						String chgAmt = "";
						String currCd = "";
						invArChgVos = new ArrayList<InvArChgVO>();						
						for (int rowNum2 = 0; rowNum2 < genIfVo.getInvArIfChgVOs().size(); rowNum2++) {
							
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5");
							
							trfRtAmt = genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt() : "" ;
							chgCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd() : "";
							ratAsCntrQty = genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty() : "";
							chgAmt = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt() : "";
							currCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd() != null ? genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd() : "";
							
                            if (chgCd.equals("") || chgCd.equals("0")) {
                            	log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5_1");
                            	errRsn = "Charge Code Not Exists.";
                            	cnt++;
                            }
                            
                            if (currCd.equals("") || currCd.equals("0")) {
                            	log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5_1");
                            	errRsn = "Currency Code Not Exists.";
                            	cnt++;
                            }
						 	
                            if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
                            	
	                            if (trfRtAmt.equals("") || trfRtAmt.equals("0")) {
	                            	errRsn = "Rate Not Exists.";
	                            	cnt++;
	                            }
	                            
	                            if (ratAsCntrQty.equals("") || ratAsCntrQty.equals("0")) {
	                            	errRsn = "Rate As Not Exists.";
	                            	cnt++;
	                            }
	                            
	                            if (chgAmt.equals("") || chgAmt.equals("0")) {
	                            	errRsn = "Charge Amount Not Exists.";
	                            	cnt++;
	                            }		
	                            
						    }
							
						}
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>6");
						
						if (cnt > 0) {
							
							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
							errFlag = "Y";
							break;
						
						}
					
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>7");
					
					// main 을 select 하면서 다른정보가 있어도  bl_no 없으면 에러#1
					// charge 있는지 한번  check 해보고 없으면 에러 #2
					ifFlag = dbDao.searchInterfaceMain(srcIfDt, srcIfSeq);
					
					if (ifFlag.equals("NO_BL")) {
						// 에러처리 #1
						errRsn = "B/L No. Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
						
					} else if (ifFlag.equals("NO_CHG")) {
						// 에러처리 #2
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>7_1");
						errRsn = "Charge Code Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>8");
					
					localTime = dbDao.searchLocalTime(genIfVo.getInvArIfMnVO().getOfcCd());
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>8_1");

					if (ioBndCd.equals("O")) {
						vskVslPortSkdVo = dbDao.searchSaDtLaneOb(genIfVo.getInvArIfMnVO());
					} else if (ioBndCd.equals("I")) {
						vskVslPortSkdVo = dbDao.searchSaDtLaneIb(genIfVo.getInvArIfMnVO());
					}
					
					if (vskVslPortSkdVo != null) {
				        sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt; ///// Main
					} else {							
						vskVslPortSkdVo = dbDao.searchSaDtLane(localTime); 
						sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt;
					}
					log.info("\n########## sailArrDt : "+sailArrDt);
					
					if((polCd != null && !polCd.equals(""))&&(podCd != null && !podCd.equals(""))
							&&(genIfVo.getInvArIfMnVO().getOfcCd() != null && !genIfVo.getInvArIfMnVO().getOfcCd().equals(""))
							&&(ioBndCd != null && !ioBndCd.equals(""))&&(vslCd != null && !vslCd.equals(""))
							&&(sailArrDt != null && !sailArrDt.equals(""))){
						
						cutOffVo.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
						cutOffVo.setIoBndCd(ioBndCd);
						cutOffVo.setVvd(vslCd + skdVoyNo + skdDirCd);
						cutOffVo.setPolCd(polCd);
						cutOffVo.setPodCd(podCd);
						cutOffVo.setSailArrDt(sailArrDt);
						log.debug(cutOffVo.toString());
						
						newArOfcCd = dbDao.searchCutOffLaneOfficebyOld(cutOffVo);
						
						if(newArOfcCd == null || newArOfcCd.equals("") ){
							newArOfcCd = dbDao.searchCutOffLaneOfficebyNew(cutOffVo);
						}
						if(newArOfcCd != null && !newArOfcCd.equals("")){
							genIfVo.getInvArIfMnVO().setOfcCd(newArOfcCd);
							newArOfcCd = "";
						}
				    }
						
					mdmOrgVo = dbDao.searchOfficeAttribute(genIfVo.getInvArIfMnVO().getIfSrcCd(), genIfVo.getInvArIfMnVO().getOfcCd());
					// -- 추가일자 : 2009.12.22 ------------------------------------------------
					if(mdmOrgVo == null) {
						errRsn = "Office Code Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}
					// ------------------------------------------------------------------------
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>8_2");
					
			        rhq = mdmOrgVo.getArHdQtrOfcCd(); ///// Main
			        lclCurr = mdmOrgVo.getArCurrCd(); ///// Main
			        arOfcCd = mdmOrgVo.getOfcCd();
			        log.debug("mdmOrgVo.getOfcCd()_1================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
			        //fxCurrRt = mdmOrgVo.getFxCurrRt();
			        //repCustCntCd = mdmOrgVo.getRepCustCntCd();
			        //repCustSeq = mdmOrgVo.getRepCustSeq();
			        ofcAgentMark = mdmOrgVo.getArAgnStlCd();
			        //ofcArControl = mdmOrgVo.getArCtrlOfcCd();
			        //invCoaCtrCd = mdmOrgVo.getArCtrCd();
			        dmdtInvAplyBlFlg = mdmOrgVo.getDeltFlg();
			        arInvIssFlg = mdmOrgVo.getSubAgnFlg();
			        otsSmryCd = mdmOrgVo.getOfcSlsDeltFlg();
			        
			        xchRtUsdTpCd = mdmOrgVo.getSubsCoFlg();
			        // -- 추가일자 : 2009.12.29 ------------------------------------------------
			        cntCd = mdmOrgVo.getLocCd().substring(0,2);
			        // ------------------------------------------------------------------------
			        
			        log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>8_3");
					
			        //2015.07.03 US,CA 지역 DEM/DET 하드코딩 삭제 요청
			        // -- 수정일자 : 2009.12.29 ------------------------------------------------
//			        if (((cntCd.equals("US") || cntCd.equals("CA")) && genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) || 
//			            ((cntCd.equals("US") || cntCd.equals("CA")) && genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC"))) {
//						
//						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>9");
//					    
//						// -- 수정일자 : 2009.12.28(PHXSC->NYCRA-> OfcCd ) ----------------------------------
//						mdmOrgVo  = dbDao.searchOfficeAttribute("DET", arOfcCd);
//						// ------------------------------------------------------------------------
//						
//						// -- 추가일자 : 2009.12.22 ------------------------------------------------
//						if(mdmOrgVo == null) {
//							errRsn = "Office Code Not Exists.";
//							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
//							errFlag = "Y";
//							break;
//						}
//						// ------------------------------------------------------------------------
//
//						// -- 추가일자 : 2009.12.23 ------------------------------------------------
//						genIfVo.getInvArIfMnVO().setOfcCd(mdmOrgVo.getOfcCd());
//						// ------------------------------------------------------------------------
//						
//				        rhq = mdmOrgVo.getArHdQtrOfcCd();
//				        lclCurr = mdmOrgVo.getArCurrCd();
//				        arOfcCd = mdmOrgVo.getOfcCd();
//				        ofcAgentMark = mdmOrgVo.getArAgnStlCd();
//				        dmdtInvAplyBlFlg = mdmOrgVo.getDeltFlg();
//				        arInvIssFlg = mdmOrgVo.getSubAgnFlg();       
//					
//					}
					 
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>10");
					
					if(rhq .equals("HAMRU")||tsDivCd.equals("TSP")){//2010-08-12 DEM/DET VVD로직 변경관련 추가(2ND)
					if (//rhq .equals("HAMRU") && 2010-07-23 
						//2010-08-11 DEM/DET VVD로직 변경관련 추가
					    //tsDivCd.equals("TSP")&&	
					   (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD"))){
											
						bkgVvdVo = dbDao.searchBkgVvd(ioBndCd, bkgNo);
						//2010-08-03 null 체크
						if(bkgVvdVo != null){
							vslCd = bkgVvdVo.getVslCd(); 
							skdVoyNo = bkgVvdVo.getSkdVoyNo(); 
					        skdDirCd = bkgVvdVo.getSkdDirCd(); 
					        port = bkgVvdVo.getPolCd(); 
						}
				        
				        //BKG VVD가 VskVslSkd에 없으면 넘겨준 VVD 그냥 사용 2010-05-07
				        if (dbDao.searchVskVslSkd(vslCd, skdVoyNo, skdDirCd, port).equals("")){
				        	if(!vslCd.equals("CFDR") && !vslCd.equals("CNTC")) {
				        		vslCd = genIfVo.getInvArIfMnVO().getVslCd() != null ? genIfVo.getInvArIfMnVO().getVslCd() : ""; ///// Main
								skdVoyNo = genIfVo.getInvArIfMnVO().getSkdVoyNo() != null ? genIfVo.getInvArIfMnVO().getSkdVoyNo() : ""; ///// Main
								skdDirCd = genIfVo.getInvArIfMnVO().getSkdDirCd() != null ? genIfVo.getInvArIfMnVO().getSkdDirCd() : ""; ///// Main
								port = ioBndCd.equals("O") ? polCd : podCd; ///// Main								
				        	}
				        }						
					}
					}
					log.debug("\n########## vslCd : "+vslCd);
					log.debug("\n########## skdVoyNo : "+skdVoyNo);
					log.debug("\n########## skdDirCd : "+skdDirCd);
					log.debug("\n########## port : "+port);
					
					sailDt = genIfVo.getInvArIfMnVO().getSailDt() == null ? "" : genIfVo.getInvArIfMnVO().getSailDt();
					if (sailDt.equals("")) {
						//2010-04-08
						//if (!bkgNo.equals("")) {
						//	sailDt = dbDao.searchSailingDateByBkgNo(bkgNo);
						//} else {
							sailDt = dbDao.searchSailingDateByVvd(vslCd, skdVoyNo, skdDirCd, port);
						//}
						
					}
										
					mriMaxYymm = dbDao.searchMriMaxYymm(genIfVo.getInvArIfMnVO().getOfcCd());
					log.debug("\n########## mriMaxYymm1 : "+mriMaxYymm);
					
					if (mriMaxYymm.equals("")) {
						mriMaxYymm = dbDao.searchMriMaxYymm(rhq);
						log.debug("\n########## mriMaxYymm2 : "+mriMaxYymm);
					}
					
					if (mriMaxYymm.equals("")) {
						// 에러처리 #7
						errRsn = "AP_PERIOD mri_max_yymm RHQ / SELECT ERROR !!";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}			
					//2011.08.16 박성진 Office code 로 Sever id 조회
					svrId = dbDao.searchSeverId(genIfVo.getInvArIfMnVO().getOfcCd());
					
					//---------------HAN 2010-04-05 svrId.equals("ENT") 일때도 taxInd 구하도록 추가함.
					if (svrId.equals("KOR") || svrId.equals("ENT")) {
						if (svrId.equals("KOR")){
							glEffDt = dbDao.searchGlEffDtKor(mriMaxYymm, localTime, glEffDt); ///// Main
						}else{
							//glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getSailDt(), mriMaxYymm, localTime, glEffDt);
							glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getOfcCd(), mriMaxYymm, glEffDt);
						}
						log.info("\n########## glEffDt1 : "+glEffDt);
						taxInd = dbDao.searchTaxInd(srcIfDt, srcIfSeq); ///// Main
					} else {
						//glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getSailDt(), mriMaxYymm, localTime, glEffDt);
						glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getOfcCd(), mriMaxYymm, glEffDt);
						log.info("\n########## glEffDt2 : "+glEffDt);
					}	

					if (dbDao.searchVskVslSkd(vslCd, skdVoyNo, skdDirCd, port).equals("")){
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")) {
							// 추가일자 : 2010.02.01(IF문추가)
							//Ticket ID : SRM-201009185  2010.09.29 DEM/DET 인터페이스 로직 보완 요청 
							//운항스케쥴에 없는 경우 에러처리 하지 않고 DEM/DET에서 보내주는 선박을 인터페이스 하는 것으로 로직 보완
							if(!vslCd.equals("CFDR") && !vslCd.equals("CNTC")) {
								log.debug("vslCd = "+vslCd);
								// 에러처리 #3
								//errRsn = "V.V.D. Not Exists[DEM/DET].";
								//dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								//errFlag = "Y";
								//break;
							}
							//2010.10.20 최도순 [CHM-201006608] DEM/DET 데이터 A/R INVOICE로 인터페이스시 로직 변경 요청
							//DEM/DET에서 보내주는 데이터에서 VVD를 운항스케쥴에서 찾지 못할 경우 공동항차 CFDR로 받도록 로직 변경 요청합니다.
							bkgVvdVo = dbDao.searchArMstRevVvdTml(glEffDt);
							vslCd = bkgVvdVo.getVslCd();
							skdVoyNo = bkgVvdVo.getSkdVoyNo();
					        skdDirCd = bkgVvdVo.getSkdDirCd();
						} else {							
							if (dbDao.searchArMstRevVvd(vslCd, skdVoyNo, skdDirCd).equals("")){
								if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
									bkgVvdVo = dbDao.searchArMstRevVvdTml(glEffDt);
									vslCd = bkgVvdVo.getVslCd();
									skdVoyNo = bkgVvdVo.getSkdVoyNo();
							        skdDirCd = bkgVvdVo.getSkdDirCd();
								} else {
									// 에러처리 #4
									errRsn = "V.V.D. Not Exists.";
									dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
									errFlag = "Y";
									break;
								}
							
							}
							
						}					
						
					}
					//2010.10.21 최도순 [CHM-201006525] A/R INVOICE의 DEM/DET 자료 인터페이스 로직 수정 요청(TVA Mark (tax관련 charge가 추가로 발생하는지의 구분자)
					if(ofcTrnsFlg.equals("Y")){
						InvArMnVO maxVVDVO = dbDao.searchVVDForMaxINVInterface(genIfVo.getInvArIfMnVO().getBlSrcNo(), arOfcCd);
						
						if( maxVVDVO != null ){
							vslCd = maxVVDVO.getVslCd();
							skdVoyNo = maxVVDVO.getSkdVoyNo();
					        skdDirCd = maxVVDVO.getSkdDirCd();
					        ioBndCd = maxVVDVO.getIoBndCd();
					        
					        sailDt = maxVVDVO.getSailDt();
					        sailArrDt = maxVVDVO.getSailArrDt();
					        slanCd = maxVVDVO.getSlanCd();
					        trnkVslCd = maxVVDVO.getTrnkVslCd();
					        trnkSkdVoyNo = maxVVDVO.getTrnkSkdVoyNo();
					        trnkSkdDirCd = maxVVDVO.getTrnkSkdDirCd();
					        porCd = maxVVDVO.getPorCd();
					        polCd = maxVVDVO.getPolCd();
					        podCd = maxVVDVO.getPodCd();
					        delCd = maxVVDVO.getDelCd();
					        svcScpCd = maxVVDVO.getSvcScpCd();
					        //revVslCd = maxVVDVO.getRevVslCd();
					        //revSkdVoyNo = maxVVDVO.getRevSkdVoyNo();
					        //revSkdDirCd = maxVVDVO.getRevSkdDirCd();
					        //revDirCd = maxVVDVO.getRevDirCd();
					        //rlaneCd = maxVVDVO.getRlaneCd();
					        //znIocCd = maxVVDVO.getZnIocCd();
					        
					        port = ioBndCd.equals("O") ? polCd : podCd; 
					        
						} else { 
							bkgVvdVo = dbDao.searchArMstRevVvdTml(glEffDt);
							vslCd = bkgVvdVo.getVslCd();
							skdVoyNo = bkgVvdVo.getSkdVoyNo();
					        skdDirCd = bkgVvdVo.getSkdDirCd();
						}
					}
					
					if (vslCd != null && (vslCd.equals("CFDR") || vslCd.equals("USAC"))) {
						sailDt = localTime;
					} 
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>12");
					
					// TML 은 요기까지만 check 하고 addInvMain()으로 뛴다.
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
						break;
					}
					
					// mdmOrgVo.getSoIfCd() 사용여부 확인필요!
//					mdmCustVo = dbDao.checkCustomer(mdmOrgVo, genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq());
//					
//					if (mdmCustVo == null) {
//						if (!(genIfVo.getInvArIfMnVO().getCustCntCd().equals("US") && genIfVo.getInvArIfMnVO().getCustSeq().equals("48740"))) {
//							// 에러처리 #5
//							errRsn = "Customer  Deleted or Customer Not Exists.";
//							dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
//							errFlag = "Y";
//							break;
//						}
//										
//					} 
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>13");
					
					/*
					rgnCdPor = dbDao.searchRgnCd(genIfVo.getInvArIfMnVO().getPorCd()); ///// Main 					
					rgnCdDel = dbDao.searchRgnCd(genIfVo.getInvArIfMnVO().getDelCd()); ///// Main					
					svcScpCd = dbDao.searchSvcScp(rgnCdPor, rgnCdDel, slanCd); ///// Main
									
					if (svcScpCd.equals("")) {
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")){
							// 추가일자 : 2010.02.03(IF문추가)
							if(vslCd.equals("CFDR") || vslCd.equals("CNTC")) {
								svcScpCd = "OTH";
							} else {
								// 에러처리 #6
								errRsn = "Service Scope Not Exists.";
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
						} else {
							// DEM/DET 이 아니면 못구한경우 OTH 로 한다.
							svcScpCd = "OTH";
						}											
					}
					
					*/
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>14");
					
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")){
						
						if (ioBndCd.equals("O")) {
							vskVslPortSkdVo = dbDao.searchSaDtLaneOb(genIfVo.getInvArIfMnVO());
						} else if (ioBndCd.equals("I")) {
							vskVslPortSkdVo = dbDao.searchSaDtLaneIb(genIfVo.getInvArIfMnVO());
						}
						
						if (vskVslPortSkdVo != null) {
					        sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt; ///// Main
					        slanCd = slanCd.equals("")?vskVslPortSkdVo.getSlanCd():slanCd; ///// Main
						} else {							
							vskVslPortSkdVo = dbDao.searchSaDtLane(localTime); 
							sailArrDt = sailArrDt.equals("")?vskVslPortSkdVo.getVpsEtbDt():sailArrDt;
					        slanCd = slanCd.equals("")?vskVslPortSkdVo.getSlanCd():slanCd;
						}
						log.debug("\n########## sailArrDt : "+sailArrDt);
						log.debug("\n########## slanCd : "+slanCd);						
						
					}
					
					rgnCdPor = dbDao.searchRgnCd(porCd); ///// Main 					
					rgnCdDel = dbDao.searchRgnCd(delCd); ///// Main					
					svcScpCd = dbDao.searchSvcScp(rgnCdPor, rgnCdDel, slanCd); ///// Main
									
					if (svcScpCd.equals("")) {
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")){
							if(xchRtUsdTpCd.equals("V")){  //2015.07.29 DEM/DET SHIP BACK 의 경우 service scope 이 null인경우(환율타입이 V: vvd 환율의 경우만 로직 타도록 수정)
								// 추가일자 : 2010.02.03(IF문추가)
								if(vslCd.equals("CFDR") || vslCd.equals("CNTC")) {
									svcScpCd = "OTH";
								} else {
									// 에러처리 #6
									errRsn = "Service Scope Not Exists.";
									dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
									errFlag = "Y";
									break;
								}
							}else{
								svcScpCd = "";
							}
						} else {
							// DEM/DET 이 아니면 못구한경우 OTH 로 한다.
							svcScpCd = "OTH";
						}											
					}
					
										
					if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
					
						arCrdtVo.setActCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());
						arCrdtVo.setActCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());
						arCrdtVo.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
						
						log.debug("   \n########## arOfcCd : "+arOfcCd);
						log.debug("   \n########## rhq : "+rhq);
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")){
							if (arOfcCd.substring(3).equals("BA") && !(ofcAgentMark.equals("B"))){
								if (rhq.equals("HAMRU")||rhq.equals("SINRS")||rhq.equals("NYCRA")){
									arCrdtVo.setSailArrDt(localTime); // Due date 구할때 Agent 이면 무조건  I/F Date 기준으로 산출
//									arCrdtVo.setSailArrDt(sailArrDt); // Due date 구할때 Agent 이면서 구주,아주,미주는 기준일을 S/A Date로 산출
								} else {
									arCrdtVo.setSailArrDt(localTime); // Due date 구할때 기준일을 I/F Date 기준으로 산출
								}
							} else {
								arCrdtVo.setSailArrDt(localTime); // Due date 구할때 기준일을 I/F Date 기준으로 산출								
							}
						} else {
							arCrdtVo.setSailArrDt(genIfVo.getInvArIfMnVO().getSailArrDt());
						}
						arCrdtVo.setIoBndCd(ioBndCd);
						arCrdtVo.setLocCd(mdmOrgVo.getLocCd());
						arCrdtVo.setDelCd(delCd);
						
//						log.debug("arCrdtVo======>"+arCrdtVo.toString());
						aRCreditVO = bookingARCreationBC.searchARCredit(arCrdtVo);
							
						if (!dueDt.equals("")) {
							
							if(aRCreditVO != null){
								crTermDys = aRCreditVO.getCrTerm();
								custCrFlg = aRCreditVO.getCrFlg();					
							}	
							
							log.debug("\n########## dueDt1 : "+dueDt);
						
						} else {				
							
							if(aRCreditVO != null){
								dueDt = aRCreditVO.getDueDt();
								crTermDys = aRCreditVO.getCrTerm();
								custCrFlg = aRCreditVO.getCrFlg();					
							}	
							
							log.debug("\n########## dueDt2 : "+dueDt);
												
						}	
						
						log.debug("\n########## dueDt : "+dueDt);
						log.debug("\n########## crTermDys : "+crTermDys);
						log.debug("\n########## custCrFlg : "+custCrFlg);	
					
					}
					
					svrId = dbDao.searchSeverId(genIfVo.getInvArIfMnVO().getOfcCd()); 
					log.debug("\n########## svrId : "+svrId);
					
					// MAIN 환율 계산
					if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")){
						
						// lcl_curr이  USD인 경우는 '1'
						// 고정환율  office인 경우는 searchOfficeAttribute ( ofcCd )에서 구한 fx_curr_rt넣고
						// 아니면 vvd환율에서 구하고  없으면 0
						if (lclCurr.equals("USD")) {
							usdXchRt = "1"; ///// Chg
//						} else if (!fxCurrRt.equals("0")) {
//							usdXchRt = fxCurrRt;
//						} else {							
//							//usdXchRt = dbDao.searchInvXchRt(genIfVo.getInvArIfMnVO(), lclCurr, svcScpCd);
//							usdXchRt = dbDao.searchInvXchRt(genIfVo.getInvArIfMnVO(), lclCurr, svcScpCd, "USD");
//						}
						} else {
							// -- 추가일자 : 2009.12.24 ------------------------------------------------
							// -- 수정일자 : 2009.01.05(POR_CD,POD_CD 처리로직 추가) --------------------
							vvdCustomerVo = new VVDCustomerVO();
							vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
							vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
							vvdCustomerVo.setVsl(vslCd);
							vvdCustomerVo.setVoy(skdVoyNo);
							vvdCustomerVo.setDep(skdDirCd);
							vvdCustomerVo.setLclCurr(lclCurr);
							// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
							if (svrId.equals("EUR") || svrId.equals("KOR") || (svrId.equals("JPN") && ioBndCd.equals("O"))) {
								vvdCustomerVo.setSvcScp("OTH");
							} else {
								vvdCustomerVo.setSvcScp(svcScpCd);
							}							
							vvdCustomerVo.setBnd(ioBndCd);
							//vvdCustomerVo.setOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
							vvdCustomerVo.setOfcCd(arOfcCd);
							log.debug("vvdCustomerVo.setOfcCd(arOfcCd)_1================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
							vvdCustomerVo.setBkgNo(bkgNo);
							vvdCustomerVo.setSaDt(sailArrDt);
							//2010-04-27 blNo 추가
							vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());
							
							//2010-07-23
							//if(rhq .equals("HAMRU")) {
								if (ioBndCd.equals("O")) {
									vvdCustomerVo.setPol(port);
									vvdCustomerVo.setPod(podCd);
								} else {	
									vvdCustomerVo.setPod(port);
									vvdCustomerVo.setPol(polCd);
								}
							//} else {
							//	vvdCustomerVo.setPol(polCd);
							//	vvdCustomerVo.setPod(podCd);
							//}

							vvdCustomerVo.setCurr("USD"); 
							exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
							usdXchRt = exchangeRateVo.getExRate();
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>14_1");
							// ------------------------------------------------------------------------

							// -- 추가일자 : 2010.01.03 ------------------------------------------------
							if(usdXchRt.equals("") || usdXchRt == null || usdXchRt.equals("0")) {
								
								//DEM/DET에서 보내오는 데이터 중 CFDR의 공동항차로 VVD를 가져오는 건에 대한 환율은 인터페이스 된 달의 경리환율을 적용 요청함.
								
								usdXchRt = dbDao.searchUsdXchRtByAcctMonth(localTime, lclCurr);
							}
							
							
							if(usdXchRt.equals("") || usdXchRt == null || usdXchRt.equals("0")) {								
								errRsn = "Exchange Rate Not Exists.";
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
							// ------------------------------------------------------------------------
						}
					
//						if (ioBndCd.equals("O")) {
//							vskVslPortSkdVo = dbDao.searchSaDtLaneOb(genIfVo.getInvArIfMnVO());
//						} else if (ioBndCd.equals("I")) {
//							vskVslPortSkdVo = dbDao.searchSaDtLaneIb(genIfVo.getInvArIfMnVO());
//						}
//						
//						if (vskVslPortSkdVo != null) {
//					        sailArrDt = vskVslPortSkdVo.getVpsEtbDt(); ///// Main
//					        slanCd = vskVslPortSkdVo.getSlanCd(); ///// Main
//						} else {							
//							vskVslPortSkdVo = dbDao.searchSaDtLane(localTime); 
//							sailArrDt = vskVslPortSkdVo.getVpsEtbDt();
//					        slanCd = vskVslPortSkdVo.getSlanCd();
//						}
//						log.debug("\n########## sailArrDt : "+sailArrDt);
//						log.debug("\n########## slanCd : "+slanCd);
//						mdmCrCustVo = dbDao.searchARCredit(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq());	
					
//						if (mdmCrCustVo != null) {
//						    crFlg = mdmCrCustVo.getCrFlg();
//						    if (ioBndCd.equals("O")) {
//						    	crTerm = mdmCrCustVo.getObCrTermDys();
//						    } else {
//						    	crTerm = mdmCrCustVo.getIbCrTermDys();
//						    }
//						    
//						}
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15");
						
						//2010.11.19 최도순 dmdtInvAplyBlFlg Y일 경우 BlSrcNo를 InvSrcNo로 대체
						if (dmdtInvAplyBlFlg.equals("Y")) {						
							dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getInvSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd()); ///// Main						
						}else{
							dueDateVo = dbDao.searchDueDtForMaxINVInterface(genIfVo.getInvArIfMnVO().getBlSrcNo(), genIfVo.getInvArIfMnVO().getOfcCd());
						}
						
						log.debug("\n########## dueDateVo : "+dueDateVo);
						if (dueDateVo != null) {
							// -- 추가일자 : 2009.12.23 ------------------------------------------------
							dueDtYn = "Y";
							// ------------------------------------------------------------------------
							dueDt = dueDateVo.getDueDt(); ///// Main
							crTermDys = dueDateVo.getCrTermDys(); ///// Main
	                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
	                        log.debug("\n########## crTermDys1 : "+crTermDys);
						} else {
							// -- 추가일자 : 2009.12.23 ------------------------------------------------
							dueDtYn = "N";
							// ------------------------------------------------------------------------
						}
												
						destTrnsSvcModCd = dbDao.searchDestSVCModeCode(bkgNo); ///// Main
						log.debug("\n########## rhq : "+rhq);
						log.debug("\n########## ofcAgentMark : "+ofcAgentMark);
						log.info("\n########## dueDt : "+dueDt);
						log.debug("\n########## crTermDys2 : "+crTermDys);
												
						// Office 가 구주 지역도 아니고 지점도 아니면
						if (!(rhq.equals("HAMRU")) && !ofcAgentMark.equals("B")){
							genIfVo.getInvArIfMnVO().setDueDt(dueDt);
						}
						
						// Office 가 구주 지역 지점 이거나  searchDueDtForMaxINVInterface에서 due_dt를 못구했을때
						// 이때 구주지역지점은 sa_dt를 기준으로 하고 나머지는 if_dt를 기준으로 due_dt를 구한다.
					    if(rhq.equals("HAMRU") && ofcAgentMark.equals("B")|| arOfcCd.equals("SYDSC") || dueDt.equals("")) {
					    	// -- 추가일자 : 2009.12.24(INV체크 IF문 추가) -------------------------------
					    	if(otsSmryCd.equals("INV")) {
					    		dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), localTime);
						    	if (dueDt.equals("") || crTermDys.equals("0")) {
						    		
						    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_1");
						    		
						    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
						    		dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), localTime);
						    	}
					    	} else {
					    		
					    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_2");
					    		// -- 추가일자 : 2010.11.15 HKGSC 가 아닌 CN 인 경우 Local time  modify by 최도순------
					    		
					    		if (!(arOfcCd.equals("HKGSC")) && genIfVo.getInvArIfMnVO().getCustCntCd().equals("CN")) {
					    	    	  dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), localTime);
					    	    	  if (dueDt.equals("") || crTermDys.equals("0")) {
							    		
							    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_3");
							    		
							    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
							    		dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), localTime);
					
							    	  }
					    		} else { 					    			
							    	dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), arCrdtVo.getSailArrDt());
							    	//dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
							    	if (dueDt.equals("") || crTermDys.equals("0")) {
							    		
							    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_3");
							    		
							    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
							    		dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), arCrdtVo.getSailArrDt());
							    		//dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
							    	}
					    		}
					    	}
					    	// ------------------------------------------------------------------------
					    } else {
					    	// -- 추가일자 : 2009.12.23(IF문 추가) --------------------------------------
					    	// -- 수정일자 : 2009.12.24(INV체크 IF문 추가) -------------------------------
					    	// MAX 에 duedt 가 없을때 INV 에 따라 분기 2010-05-20 이상희
					    	if(dueDtYn.equals("N")) {
					    		if(otsSmryCd.equals("INV")) {
						    		dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), localTime);
							    	if (dueDt.equals("") || crTermDys.equals("0")) {
							    		
							    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_1");
							    		
							    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
							    		dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), localTime);
							    	}
						    	} else {
						    		
						    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_2");
						    		// -- 추가일자 : 2010.09.13 HKGSC 가 아닌 CN 인 경우 Local time  modify by Kimhyunhwa------
						    								    		
						    		if (!(arOfcCd.equals("HKGSC")) && genIfVo.getInvArIfMnVO().getCustCntCd().equals("CN")) {
						    	    	  dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), localTime);
						    	    	  if (dueDt.equals("") || crTermDys.equals("0")) {
								    		
								    		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_3");
								    		
								    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
								    		dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), localTime);
						
								    	  }
						    		} else {
						    		
						    			dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), arCrdtVo.getSailArrDt());
						            	//dueDt = dbDao.searchCreditCustomerForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
						          
							    	     if (dueDt.equals("") || crTermDys.equals("0")) {
							    	 	     log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>15_4");
							    	    	// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
							    	 	    dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), arCrdtVo.getSailArrDt());
							    		     //dueDt = dbDao.searchOfficeForCredit(genIfVo.getInvArIfMnVO(), sailArrDt);
							    		     
							    	     }
							    	}
						    	}
					    	}
					    	// ------------------------------------------------------------------------
					    }
					    
					    log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>16");
						    
						// Office 가 미주지역이고  bnd = 'I' 인 경우
						if(rhq.equals("NYCRA") && ioBndCd.equals("I")) {
							dueDt = dbDao.searchDueDtForDestSVCModeCode(destTrnsSvcModCd, dueDt);
						}
						
						
					} else {
						// due_dt는 다시 구하지않고 credit_term과 credit_mark를 다시 구한다.
//						if(ioBndCd !=null && sailArrDt !=null){
							dueDateVo = dbDao.searchDueDtByCustomerSadt(ioBndCd, genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq(), sailArrDt);
//						}
						
						if (dueDateVo != null) {
							crTermDys = dueDateVo.getCrTermDys(); ///// Main
	                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
						}
						
						if (dueDt.equals("") || crTermDys.equals("0")) {
							dueDateVo = dbDao.searchDueDtByOffice(ioBndCd, genIfVo.getInvArIfMnVO().getOfcCd());
							// -- 추가일자 : 2010.01.07 ------------------------------------------------
							crTermDys = dueDateVo.getCrTermDys(); ///// Main
	                        custCrFlg = dueDateVo.getCustCrFlg(); ///// Main
	                        // ------------------------------------------------------------------------
						}
						
						
						if (lclCurr.equals("USD")) {
							usdXchRt = "1"; ///// Chg
						} else {
							usdXchRt = dbDao.searchUsdXchRtByAcctMonth(localTime, lclCurr);
						}
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>17");
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>usdXchRt>>>>>>>>=="+usdXchRt);
						
					}
					
					mriMaxYymm = dbDao.searchMriMaxYymm(genIfVo.getInvArIfMnVO().getOfcCd());
					log.debug("\n########## mriMaxYymm1 : "+mriMaxYymm);
					
					if (mriMaxYymm.equals("")) {
						mriMaxYymm = dbDao.searchMriMaxYymm(rhq);
						log.debug("\n########## mriMaxYymm2 : "+mriMaxYymm);
					}
					
					if (mriMaxYymm.equals("")) {
						// 에러처리 #7
						errRsn = "AP_PERIOD mri_max_yymm RHQ / SELECT ERROR !!";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					}			
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>18");
					
//					svrId = dbDao.searchSeverId(genIfVo.getInvArIfMnVO().getOfcCd()); 
//					log.debug("\n########## svrId : "+svrId);
					
					//---------------HAN 2010-04-05 svrId.equals("ENT") 일때도 taxInd 구하도록 추가함.
					if (svrId.equals("KOR") || svrId.equals("ENT")) {
						if (svrId.equals("KOR")){
							glEffDt = dbDao.searchGlEffDtKor(mriMaxYymm, localTime, glEffDt); ///// Main
						}else{
							//glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getSailDt(), mriMaxYymm, localTime, glEffDt);
							glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getOfcCd(), mriMaxYymm, glEffDt);
						}
						log.debug("\n########## glEffDt1 : "+glEffDt);
						taxInd = dbDao.searchTaxInd(srcIfDt, srcIfSeq); ///// Main
					} else {
						//glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getSailDt(), mriMaxYymm, localTime, glEffDt);
						glEffDt = dbDao.searchGlEffDtOther(genIfVo.getInvArIfMnVO().getOfcCd(), mriMaxYymm, glEffDt);
						log.debug("\n########## glEffDt2 : "+glEffDt);
					}					
										
			        revTypeSrcVo = dbDao.searchREVTypeSource(genIfVo.getInvArIfMnVO().getIfSrcCd());
			        if (revTypeSrcVo != null) {
				        revTpCd = revTypeSrcVo.getRevTpCd();
				        revSrcCd = revTypeSrcVo.getRevSrcCd();
			        }    
			        
			        if (!revSrcCd.equals("TM") && !glEffDt.equals("")) {
			        	blInvCfmDt = localTime;
			        } 
			        
			        log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>19");
			        
			        if(polCd != null && podCd != null ){
			        	zoneIoc = dbDao.searchZoneIOC(polCd, podCd); ///// Main
			        }
			        
					genIfVo.getInvArIfMnVO().setSlanCd(slanCd);
					mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneByVvdPort(genIfVo.getInvArIfMnVO()); 
					
					if (mriRevVvdLaneVo.getRevVvd().equals("")) {
						mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLane(genIfVo.getInvArIfMnVO(), zoneIoc); 
						log.debug("\n########## mriRevVvdLaneVo1");
					}
			        
					if (mriRevVvdLaneVo.getRevVvd().equals("")) {
						mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLane(genIfVo.getInvArIfMnVO(), "OO"); 
						log.debug("\n########## mriRevVvdLaneVo2");
					}
					
					if (mriRevVvdLaneVo.getRevVvd().equals("")) {
						mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneRowNum(genIfVo.getInvArIfMnVO());
						log.debug("\n########## mriRevVvdLaneVo3");
					}
					
					log.info("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>20");
					
					if (mriRevVvdLaneVo.getRevVvd().equals("")) {
						//rev_src_cd가 'RD'인 경우 vsl을 'CNTC'로 변경하고
						if (revSrcCd.equals("RD")) {
							tVslCd = "CNTC";
						} else {
							tVslCd = vslCd;
						}
						mriRevVvdLaneVo = dbDao.searchMRIRevenueVVDLaneRd(tVslCd, glEffDt); 
						log.debug("\n########## mriRevVvdLaneVo4");
					}
					
					if (mriRevVvdLaneVo.getRevVvd().equals("")) {
						// 에러처리 #8
						errRsn = "REV_VVD OR REV_LANE Not Exists.";
						dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
						errFlag = "Y";
						break;
					} else { 		
						revLane = mriRevVvdLaneVo.getRevLane(); ///// Main
				        revVvd = mriRevVvdLaneVo.getRevVvd(); ///// Main
				        log.debug("\n########## revVvd : "+revVvd);
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>21");
				        
			        //locCd = dbDao.searchCityCd(genIfVo.getInvArIfMnVO().getOfcCd()); ///// Main
			        
			        locCd = dbDao.searchCityCd(arOfcCd); ///// Main
					
			        if (!bkgNo.equals("")) { 
			        	blObrdDt = dbDao.searchBLOnDate(bkgNo); ///// Main
			        }
					
					subsCoCd = dbDao.searchInterCompany(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq()); ///// Main
					
//					invIssFlagVo = dbDao.searchARSetupOfficeForIssueReIssue(genIfVo.getInvArIfMnVO().getIfSrcCd(), genIfVo.getInvArIfMnVO().getOfcCd());
//					if (invIssFlagVo != null) {
//						issueFlag = invIssFlagVo.getIssueFlag();
//						reIssueFlag = invIssFlagVo.getReissueFlag();
//					}
					
	
					
				} // genIfVo looping 끝
				
				// TML 은 여기서 다시 시작
				
				log.debug("   \n########## errFlag : "+errFlag);
				
				if (errFlag.equals("Y")) {
					// 에러처리후 작업 종료 #1					
					break;
				}
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>22");
							
				// AR_IF_NO 채번				
				// -- 수정일자 : 2010.02.18 ------------------------------------------------
				//arIfNo = dbDao.searchMRIInterfaceNo(genIfVo.getInvArIfMnVO().getOfcCd());				
				if(genIfVo.getInvArIfMnVO().getOfcCd().equalsIgnoreCase("FXTSC")) {
					ofcCd = "LONSC";
				} else if(genIfVo.getInvArIfMnVO().getOfcCd().equalsIgnoreCase("GDYSC")) {
					ofcCd = "WRPSC";
				}else {
					ofcCd = genIfVo.getInvArIfMnVO().getOfcCd();
				}
				arIfNo = manualARCreationBC.searchMRIInterfaceNo(ofcCd);
				
				log.debug("   \n########## arIfNo : "+arIfNo);

				if (arIfNo.equals("")) {
					//dbDao.addMRIInterfaceNo(genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
					manualARCreationBC.addMRIInterfaceNo(ofcCd, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
					
					arIfNo = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";

				} else {
					//dbDao.modifyMRIInterfaceNo(genIfVo.getInvArIfMnVO().getOfcCd(), arIfNo, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
					manualARCreationBC.modifyMRIInterfaceNo(ofcCd, arIfNo, genIfVo.getInvArIfMnVO().getIfSrcCd().substring(0, 2)+"_IF");
				}
				// ------------------------------------------------------------------------
				
				
				//2014-05-27 소스품질 보완
				//arIfNos = arIfNos + arIfNo + ((rowNum == 0 && genIfVos.size() == 2)? "|" : "");				
				//log.debug("   \n########## arIfNos : "+arIfNos);
				
				arIfNosBuff.append(arIfNo + ((rowNum == 0 && genIfVos.size() == 2)? "|" : ""));
				
				//////////////////////////////////////////////////
				// INV_AR_CHG 정보 세팅
				
		        int seq = 1;
		        
		        int ifSalar = 0;
		        int ifNonre = 0;
		        int ifMriar = 0;
		        int ifOther = 0;
		        int ifVat = 0;
		        int ifWhf = 0;
		        int ifCtt = 0;
		        int if3rd = 0;
		        int ifXxx = 0;

		        
		        //int erpSalar = 1;
		        //int erpNonre = 1;
		        //int erpMriar = 1;
		        //int erpOther = 1;
		        //int erpVat = 1;
		        //int erpWhf = 1;
		        //int erpCtt = 1;
		        //int erp3rd = 1;
		        //int erpXxx = 1;
		        
		        int erpSalar = 0;
		        int erpNonre = 0;
		        int erpMriar = 0;
		        int erpOther = 0;
		        int erpVat = 0;
		        int erpWhf = 0;
		        int erpCtt = 0;
		        int erp3rd = 0;
		        int erpXxx = 0;
		        
		        String loclChgAcctCd = "";
		        
		        String curr_cd = "";
		        String apArOffstNo = "";
		        
		        InvArChgVO invChgeVo = null;
		        InvArMnVO invArMnVo2 = new InvArMnVO();
		        invArMnVo2.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
		        invArMnVo2.setRevTpCd(revTpCd);
		        invArMnVo2.setRevSrcCd(revSrcCd);
		        
		        log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>23");
		        
				if (genIfVo.getInvArIfChgVOs() != null) {
					
					invArChgVos = new ArrayList<InvArChgVO>();
					
					// invArIfChgVOs looping 시작
					for (int rowNum2 = 0; rowNum2 < genIfVo.getInvArIfChgVOs().size(); rowNum2++) {
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>24");
						log.debug("\n########## chgCd : "+genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
						log.debug("\n########## ofcCd : "+genIfVo.getInvArIfMnVO().getOfcCd());
						log.debug("\n########## arOfcCd : "+arOfcCd);
								
						invArChgVo = new InvArChgVO();
						
						repChgCd = dbDao.searchRepCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());  ///// Chg	
						chgFullNm = dbDao.searchChargeName(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), arOfcCd); ///// Chg
						// -- 추가일자 : 2010.01.08 ------------------------------------------------
						if(chgFullNm.equals("")) {
							chgFullNm = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgFullNm();
						}
						// ------------------------------------------------------------------------
						log.debug("\n########## chgFullNm : "+chgFullNm);
						//-----------------------HAN 2010-04-06  START 아래 주석처리하고 erpIfOfcCd을 조회하여 새로구함
						/*
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
							erpIfOfcCd = genIfVo.getInvArIfMnVO().getOfcCd();
						} else {						
							if(svrId.equals("USA") && ofcAgentMark.equals("B") && custCrFlg.equals("Y") && genIfVo.getInvArIfMnVO().getCustCntCd().equals("US")) {
								erpIfOfcCd = dbDao.searchErpIFOfcCd(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq()); ///// Chg							
							} else if (svrId.equals("KOR") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") && genIfVo.getInvArIfMnVO().getCustCntCd().equals("KR")) {
								if(custCrFlg.equals("Y")) {
									erpIfOfcCd = dbDao.searchErpIFOfcCd(genIfVo.getInvArIfMnVO().getCustCntCd(), genIfVo.getInvArIfMnVO().getCustSeq()); ///// Chg							
								}								
							}						
						}
						*/
						//erpIfOfcCd = genIfVo.getInvArIfMnVO().getOfcCd();
						
						//-----------------------HAN 2010-04-06  END
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>25");
						
						if (erpIfOfcCd.equals("")) {
							erpIfOfcCd = genIfVo.getInvArIfMnVO().getOfcCd();
						}
						
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
							
							acctCd = genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk();
							
							if (acctCd.equals("")) {
								// 에러처리 #9
								errRsn = "Account Code Not Exists.";
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
														
							invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, svrId, acctCd);
							
							invArChgVo.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
							
							invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
							revCoaCoCd = invChgeVo.getRevCoaCoCd();
							revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
							revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
														
							loclChgAcctCd = dbDao.searchLocalChgFlg(genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
							
							//2010-06-09
							if (!loclChgAcctCd.equals("")) {
								invArChgVo.setRevCoaAcctCd(loclChgAcctCd); 
								
								//bookingARCreationBC.modifyArOffstNo(arIfNo, genIfVo.getInvArIfMnVO().getOfcCd().substring(0, 3)+" LCL CHRG");
								//2010-06-09
								if (loclChgAcctCd.equals("954117")) {
									apArOffstNo = genIfVo.getInvArIfMnVO().getOfcCd().substring(0, 3)+" LCL CHRG";
								}
							} 							
							
						} else if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")){
							
							invAcctDivCd = dbDao.searchAccountDivision(revTpCd, revSrcCd); 
							
							//if (invAcctDivCd != null) {
								if (invAcctDivCd.equals("P")) {
									acctCd = dbDao.searchAccountCdFromCharge(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg
								} else {
									acctCd = dbDao.searchAccountCdFromRevAcct(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); 
								}
							//}
							acctCd = dbDao.searchAccountCdConversion(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), revTpCd, revSrcCd, svrId, acctCd);

							if (acctCd.equals("")) {
								// 에러처리 #9
								errRsn = "Account Code Not Exists.";
								dbDao.modifyIfErrRsn(srcIfDt, srcIfSeq, errRsn);
								errFlag = "Y";
								break;
							}
														
							invChgeVo = dbDao.searchInvRevTpSrcCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), invArMnVo2, svrId, acctCd);
							
							invArChgVo.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
							
							invRevTpSrcCd = invChgeVo.getInvRevTpSrcCd(); 
							revCoaCoCd = invChgeVo.getRevCoaCoCd();
							revCoaRgnCd = invChgeVo.getRevCoaRgnCd();
							revCoaCtrCd = invChgeVo.getRevCoaCtrCd();
														
							loclChgAcctCd = dbDao.searchLocalChgFlg(genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
							
							//2010-06-09
							if (!loclChgAcctCd.equals("")) {
							
								invArChgVo.setRevCoaAcctCd(loclChgAcctCd); 
								
								//bookingARCreationBC.modifyArOffstNo(arIfNo, genIfVo.getInvArIfMnVO().getOfcCd().substring(0, 3)+" LCL CHRG");
								//2010-06-09
								if (loclChgAcctCd.equals("954117")) {
									apArOffstNo = genIfVo.getInvArIfMnVO().getOfcCd().substring(0, 3)+" LCL CHRG";
								}
							} 
							
						}
												
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>26");
						
//						invRevTpSrcCd = dbDao.searchInvRevTpSrcCd(revTpCd+revSrcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd()); ///// Chg
												
						vvdCustomerVo = new VVDCustomerVO();
						
						vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
						vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
						vvdCustomerVo.setVsl(vslCd);
						vvdCustomerVo.setVoy(skdVoyNo);
						vvdCustomerVo.setDep(skdDirCd);
						vvdCustomerVo.setLclCurr(lclCurr);
						// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
						if (svrId.equals("EUR") || svrId.equals("KOR")|| (svrId.equals("JPN") && ioBndCd.equals("O"))) {
							vvdCustomerVo.setSvcScp("OTH");
						} else {
							vvdCustomerVo.setSvcScp(svcScpCd);
						}
						vvdCustomerVo.setBnd(ioBndCd);
						//vvdCustomerVo.setOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
						vvdCustomerVo.setOfcCd(arOfcCd);
						log.debug("vvdCustomerVo.setOfcCd(arOfcCd)_2================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
						vvdCustomerVo.setBkgNo(bkgNo);
						vvdCustomerVo.setSaDt(sailArrDt);
						vvdCustomerVo.setPol(polCd);
						vvdCustomerVo.setPod(podCd);
						vvdCustomerVo.setCurr(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());
						//2010-04-27 blNo 추가
						vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());

						exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo); ////////////////////////////////////////////////////////////////
						
						log.debug("   \n########## exchangeRateVo : "+exchangeRateVo);
						
						/* 임시 */
//                      인터페이스 된 curr과 인터페이스된 오피스의 local curr 이 같을때				
//						if (genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd().equals(lclCurr)) {
//							invXchRt = "1";
//						}
						
						// CHARGE 환율 계산
						if (exchangeRateVo != null 
							&& (genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals("0") || genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt().equals(""))
							&& genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")) {															
							
							log.debug("   \n########## genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd() : "+genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());
							log.debug("   \n########## lclCurr : "+lclCurr);
							if (genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd().equals(lclCurr)) {
								invXchRt = "1";
							} else {
								invXchRt = exchangeRateVo.getExRate();	
							}
							log.debug("   \n########## khh invXchRt ==:"+invXchRt );
							//DEM/DET에서 보내오는 데이터 중 CFDR의 공동항차로 VVD를 가져오는 건에 대한 환율은 인터페이스 된 달의 경리환율을 적용 요청함.
							
							if (invXchRt.equals("0")||invXchRt.equals("")|invXchRt==null){
									invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");									
							}
														
						} else {
							//invXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt();
							
							//2010-04-08 추가 
							invXchRt = utilCmd.searchAccountRate(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd(), lclCurr, localTime.length()==8?localTime.substring(0,6):"");
							if(invXchRt.equals("")){
								invXchRt = genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt();
							}
						}
													
						tjSrcNm = dbDao.searchTjSrcNm(arOfcCd, genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd(), revTpCd, revSrcCd, svrId);

						log.debug("   \n########## tjSrcNm : "+tjSrcNm);
						
						invArChgVo.setArIfNo(arIfNo);
						invArChgVo.setChgSeq(Integer.toString(rowNum2 + 1));
						invArChgVo.setChgCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgCd());
						invArChgVo.setTjSrcNm(tjSrcNm);
						//invArChgVo.setOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
						invArChgVo.setOfcCd(arOfcCd);
						 log.debug("invArChgVo.setOfcCd(arOfcCd)================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
						////////////////////////////////////////////////////////////////////////
						////////////////////////////////////////////////////////////////////////
						///// AR_IF_SER_NO 생성
												
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>27");
						
						if (tjSrcNm.equals("SALAR")) {
							if (ifSalar == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifSalar = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifSalar));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpSalar++;
							} else {
								erpSalar = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpSalar));
						} else if (tjSrcNm.equals("NONRE")) {
							if (ifNonre == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
						        ifNonre = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifNonre));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpNonre++;
							} else {
								erpNonre = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpNonre));
						} else if (tjSrcNm.equals("MRIAR")) {
							if (ifMriar == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifMriar = seq++;							
							}
							log.debug("   \n########## ifMriar : "+ifMriar);
							invArChgVo.setArIfSerNo(String.valueOf(ifMriar));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpMriar++;
							} else {
								erpMriar = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpMriar));						
						} else if (tjSrcNm.equals("OTHER")) {
							if (ifOther == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifOther = seq++;
							} 	
							invArChgVo.setArIfSerNo(String.valueOf(ifOther));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpOther++;
							} else {
								erpOther = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpOther));
						} else if (tjSrcNm.equals("VAT")) {
							if (ifVat == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifVat = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifVat));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpVat++;
							} else {
								erpVat = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpVat));
						} else if (tjSrcNm.equals("WHF")) {
							if (ifWhf == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifWhf = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifWhf));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpWhf++;
							} else {
								erpWhf = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpWhf));
						} else if (tjSrcNm.equals("CTT")) {
							if (ifCtt == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifCtt = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifCtt));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpCtt++;
							} else {
								erpCtt = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpCtt));
						} else if (tjSrcNm.equals("3RD")) {
							if (if3rd == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								if3rd = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(if3rd));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erp3rd++;
							} else {
								erp3rd = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erp3rd));
						} else if (tjSrcNm.equals("XXX")) {
							if (ifXxx == 0 || !curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								ifXxx = seq++;
							}
							invArChgVo.setArIfSerNo(String.valueOf(ifXxx));
							if (curr_cd.equals(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd())) {
								erpXxx++;
							} else {
								erpXxx = 1;
							}						
							invArChgVo.setArIfChgSeq(String.valueOf(erpXxx));
						}	
						
						curr_cd = genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd();
						
						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>28");
						
						////////////////////////////////////////////////////////////////////////
						////////////////////////////////////////////////////////////////////////
							
						// TML은 INV_AR_CHG 내용 바로 저장 
						if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
						
							invArChgVo.setRepChgCd(repChgCd);                                                           
							invArChgVo.setChgFullNm(chgFullNm);                                                          
							//invArChgVo.setInvRevTpSrcCd(invRevTpSrcCd);                                                                        
							invArChgVo.setCurrCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());                                                                                                                                    
							invArChgVo.setPerTpCd("BL");                               
							invArChgVo.setTrfRtAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt());   
							// -- 수정일자 : 2010.02.16 ------------------------------------------------
//							invArChgVo.setRatAsCntrQty("1");
							invArChgVo.setRatAsCntrQty(genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty());
							// ------------------------------------------------------------------------
							invArChgVo.setChgAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt());
							
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>28_1 - " + genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt());
							
							invArChgVo.setInvXchRt(genIfVo.getInvArIfChgVOs().get(rowNum2).getInvXchRt());
							invArChgVo.setTrfNo(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfNo());                                                                                                                                           
							invArChgVo.setTvaFlg(genIfVo.getInvArIfChgVOs().get(rowNum2).getTvaFlg());                                                                                                                                        
							invArChgVo.setChgRmk(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk());                                                                                                                                         
							invArChgVo.setCreUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreUsrId());                                                                                                                                     
							invArChgVo.setCreDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreDt());                                                                                                                                          
							invArChgVo.setUpdUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdUsrId());                                                                                                                                     
							invArChgVo.setUpdDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdDt());    
														
						} else {						
						
							invArChgVo.setRepChgCd(repChgCd);                                                           
							invArChgVo.setChgFullNm(chgFullNm);    
							// -- 수정일자 : 2010.01.20(IF문 변경) --------------------------------------
							if((!otsSmryCd.equals("BL") && arInvIssFlg.equals("N")) ||
							   (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("MNR") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS") &&
							    !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD") &&
							    !otsSmryCd.equals("BL"))) {

								invArChgVo.setInvIssFlg("Y");         
							} else {
								invArChgVo.setInvIssFlg("N");   
							}
							// ------------------------------------------------------------------------
							invArChgVo.setRevCoaInterCoCd(subsCoCd);                             
							invArChgVo.setRevCoaCtrCd(revCoaCtrCd);    
							
							log.debug("\n########## acctCd : "+acctCd);
							
							if (!acctCd.substring(0, 1).equals("4") && !acctCd.substring(0, 1).equals("7") && !acctCd.substring(0, 2).equals("51")) {
								invArChgVo.setRevCoaVslCd("0000");                                                                                                            
								invArChgVo.setRevCoaVoyNo("0000");                                                                                                                       
								invArChgVo.setRevCoaSkdDirCd("0");                                                                                                                      
								invArChgVo.setRevCoaDirCd("0");   
							} else {
								if (revVvd.length() == 9) {
									invArChgVo.setRevCoaVslCd(revVvd.substring(0,4));                                                                                                            
									invArChgVo.setRevCoaVoyNo(revVvd.substring(4,8));                                                                                                                       
									invArChgVo.setRevCoaSkdDirCd(revVvd.substring(8,9));                                                                                                                      
									invArChgVo.setRevCoaDirCd(revVvd.substring(8,9));                                                                                                                   
								} else if (revVvd.length() == 10) {
									invArChgVo.setRevCoaVslCd(revVvd.substring(0,4));                                                                                                            
									invArChgVo.setRevCoaVoyNo(revVvd.substring(4,8));                                                                                                                       
									invArChgVo.setRevCoaSkdDirCd(revVvd.substring(8,9));                                                                                                                      
									invArChgVo.setRevCoaDirCd(revVvd.substring(9,10));   
								}									
							}		
							
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>29");
							
							//invArChgVo.setRevCoaAcctCd(acctCd);                                            
							invArChgVo.setAcctCd(acctCd);                                          
							invArChgVo.setInvRevTpSrcCd(invRevTpSrcCd);                                                                        
							invArChgVo.setCurrCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getCurrCd());                                                                                                                                    
							invArChgVo.setPerTpCd(genIfVo.getInvArIfChgVOs().get(rowNum2).getPerTpCd());                                                                                                                                        
							invArChgVo.setTrfRtAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfRtAmt()); 
							invArChgVo.setRatAsCntrQty(genIfVo.getInvArIfChgVOs().get(rowNum2).getRatAsCntrQty());                                                                                                                                
							invArChgVo.setChgAmt(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt());
							
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>29_1 - " + genIfVo.getInvArIfChgVOs().get(rowNum2).getChgAmt());
							
							invArChgVo.setInvXchRt(invXchRt);
							invArChgVo.setTrfNo(genIfVo.getInvArIfChgVOs().get(rowNum2).getTrfNo());                                                                                                                                           
							invArChgVo.setSobId("1");                                                                                                                                                
							invArChgVo.setRevCoaCoCd(revCoaCoCd);                                                                                                                                               
//							if (svrId.equals("KOR")) {
//								revCoaRgnCd	= "11";
//							} else if (svrId.equals("USA")) {
//								revCoaRgnCd	= "21";
//							} else if (svrId.equals("JPN")) {
//								revCoaRgnCd	= "11";
//							} else if (svrId.equals("SWA")) {
//								revCoaRgnCd	= "41";
//							} else if (svrId.equals("EUR")) {
//								revCoaRgnCd	= "31";
//							} else if (svrId.equals("CHN")) {
//								revCoaRgnCd	= "41";
//							}
							invArChgVo.setRevCoaRgnCd(revCoaRgnCd);						
							invArChgVo.setTvaFlg(genIfVo.getInvArIfChgVOs().get(rowNum2).getTvaFlg());
							
							// -- 추가일자 : 2010.01.11(IF문  로직추가) ----------------------------------
							if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
								invArChgVo.setChgRmk("");
							} else {
								invArChgVo.setChgRmk(genIfVo.getInvArIfChgVOs().get(rowNum2).getChgRmk());
							}
							// ------------------------------------------------------------------------
							
							invArChgVo.setMnlFlg("N");                                                                                                                                                
							invArChgVo.setMfDivCd("N");                                                                                                                                              
							invArChgVo.setCreUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreUsrId());                                                                                                                                     
							invArChgVo.setCreDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getCreDt());                                                                                                                                          
							invArChgVo.setUpdUsrId(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdUsrId());                                                                                                                                     
							invArChgVo.setUpdDt(genIfVo.getInvArIfChgVOs().get(rowNum2).getUpdDt());              
							
						}
						
						// -- 추가일자 : 2010.01.13 ------------------------------------------------
						invArChgVo.setIfSrcCd(genIfVo.getInvArIfMnVO().getIfSrcCd());
						// ------------------------------------------------------------------------
						
						invArChgVos.add(invArChgVo);
					} // invArIfChgVOs looping 끝	
					
					if (errFlag.equals("Y")) {
						// 에러처리후 작업 종료 #2					
						break;
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>30");
					
					log.debug("   \n########## ifSalar : "+ifSalar);
					log.debug("   \n########## ifNonre : "+ifNonre);
					log.debug("   \n########## ifMriar : "+ifMriar);
					log.debug("   \n########## ifOther : "+ifOther);
					log.debug("   \n########## ifVat   : "+ifVat);
					log.debug("   \n########## ifWhf   : "+ifWhf);
					log.debug("   \n########## ifCtt   : "+ifCtt);
					log.debug("   \n########## if3rd   : "+if3rd);
					log.debug("   \n########## ifXxx   : "+ifXxx);
										
					if (invArChgVos.size() > 0) {
						// INV_AR_CHG table 에 저장	
						//dbDao.addInvCharge(invArChgVos);
						bookingARCreationBC.addOtherInvCharge(invArChgVos);
					}
					
				} // if (genIfVo.getInvArIfChgVOs() != null)
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>31");
				
				///////////////////////////////////////////////////////
				// INV_AR_MN 정보 세팅
				invArMnVo = new InvArMnVO();
				
				invArMnVo.setArIfNo(arIfNo);
				invArMnVo.setLoclCurrCd(lclCurr);
				invArMnVo.setActCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());        	
				invArMnVo.setInvCustCntCd(genIfVo.getInvArIfMnVO().getCustCntCd());        
				invArMnVo.setActCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());        	
				invArMnVo.setInvCustSeq(genIfVo.getInvArIfMnVO().getCustSeq());        
				invArMnVo.setVslCd(vslCd); 
				invArMnVo.setSkdVoyNo(skdVoyNo); 
				invArMnVo.setSkdDirCd(skdDirCd); 
				invArMnVo.setPolCd(polCd); 
				invArMnVo.setPodCd(podCd); 
				if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")) && !port.equals("")) {
					if (ioBndCd.equals("O")) {
						invArMnVo.setPolCd(port); 
					} else {	
						invArMnVo.setPodCd(port);        
					}
				} else if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {
					if (ioBndCd.equals("O")) {
						invArMnVo.setPolCd(polCd); 
						invArMnVo.setPodCd(polCd);  
					} else {	
						invArMnVo.setPolCd(podCd); 
						invArMnVo.setPodCd(podCd);      
					}
				}
				invArMnVo.setPorCd(porCd);  
				invArMnVo.setDelCd(delCd); 
				invArMnVo.setSvcScpCd(svcScpCd); 
				// -- 추가일자 : 2009.12.23(IF문 추가) --------------------------------------
				if(vslCd.equals("CNTC") || vslCd.equals("CFDR")) {
					invArMnVo.setSailArrDt(sailDt);
				} else {
					invArMnVo.setSailArrDt(sailArrDt);
				}
				// ------------------------------------------------------------------------
				invArMnVo.setSlanCd(slanCd); 
				invArMnVo.setDueDt(dueDt);
				invArMnVo.setCrTermDys(crTermDys);        
				invArMnVo.setCustCrFlg(custCrFlg);        
				invArMnVo.setDestTrnsSvcModCd(destTrnsSvcModCd); 
				invArMnVo.setGlEffDt(glEffDt);
				invArMnVo.setBlInvCfmDt(blInvCfmDt);
				//invArMnVo.setErpIfGlDt(glEffDt);          
				invArMnVo.setZnIocCd(zoneIoc);
				invArMnVo.setRlaneCd(revLane); 
				if (revVvd.length() == 9) {
					invArMnVo.setRevVslCd(revVvd.substring(0,4)); 
					invArMnVo.setRevSkdVoyNo(revVvd.substring(4,8));        
					invArMnVo.setRevSkdDirCd(revVvd.substring(8,9));        
					invArMnVo.setRevDirCd(revVvd.substring(8,9));        
				} else if (revVvd.length() == 10) {
					invArMnVo.setRevVslCd(revVvd.substring(0,4)); 
					invArMnVo.setRevSkdVoyNo(revVvd.substring(4,8));        
					invArMnVo.setRevSkdDirCd(revVvd.substring(8,9));        
					invArMnVo.setRevDirCd(revVvd.substring(9,10));        
				}
				invArMnVo.setArCtyCd(locCd); 
				invArMnVo.setObrdDt(blObrdDt); 
				//invArMnVo.setInvCoaInterCoCd(subsCoCd);
				//invArMnVo.setInvCoaCtrCd(invCoaCtrCd);
				invArMnVo.setArTaxIndCd(taxInd);
				invArMnVo.setRevTpCd(revTpCd);
				invArMnVo.setRevSrcCd(revSrcCd);        
				//invArMnVo.setErpIfOfcCd(erpIfOfcCd);
				invArMnVo.setUsdXchRt(usdXchRt);
				//invArMnVo.setApArOffstNo(genIfVo.getInvArIfMnVO().getApArOffstNo());
				//invArMnVo.setArInvSrcCd("NISAR");
				//invArMnVo.setInvTtlLoclAmt(String.valueOf(invTtlLoclAmt));
				//invArMnVo.setArOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
				invArMnVo.setArOfcCd(arOfcCd);
				log.debug("invArMnVo.setArOfcCd(arOfcCd)================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
				invArMnVo.setBkgCorrDt(genIfVo.getInvArIfMnVO().getBkgCorrDt());
				invArMnVo.setBkgCorrNo(genIfVo.getInvArIfMnVO().getBkgCorrNo());
				invArMnVo.setBkgFeuQty(genIfVo.getInvArIfMnVO().getBkgFeuQty());
				invArMnVo.setBkgNo(bkgNo);
				invArMnVo.setBkgRefNo(genIfVo.getInvArIfMnVO().getBkgRefNo());
				invArMnVo.setBkgTeuQty(genIfVo.getInvArIfMnVO().getBkgTeuQty());
				invArMnVo.setBlInvIfDt(genIfVo.getInvArIfMnVO().getBlInvIfDt());
				invArMnVo.setBlNo(genIfVo.getInvArIfMnVO().getBlNo());
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>32");
				
				// DMDT_INV_APLY_BL_FLG 구해서 addInvArMn 할때 해당 flg가 'Y'이고 ifsrcCd가 'DEM','DET'이면 inv_src_no를 main의 bl_src_no로 한다.
				
				if ((genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")) && dmdtInvAplyBlFlg.equals("Y")) {
					invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
				} else {
					invArMnVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());
				}
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>33");
				
				invArMnVo.setBlTpCd(genIfVo.getInvArIfMnVO().getBlTpCd());
				invArMnVo.setCgoMeasQty(genIfVo.getInvArIfMnVO().getCgoMeasQty());
				invArMnVo.setCgoWgt(genIfVo.getInvArIfMnVO().getCgoWgt());
				invArMnVo.setCreDt(genIfVo.getInvArIfMnVO().getCreDt());
				invArMnVo.setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
				invArMnVo.setCxlFlg("N");
				invArMnVo.setFrtFwrdCntCd(genIfVo.getInvArIfMnVO().getFrtFwrdCntCd());
				invArMnVo.setFrtFwrdCustSeq(genIfVo.getInvArIfMnVO().getFrtFwrdCustSeq());
				//invArMnVo.setInvCoaCoCd("01");
				//invArMnVo.setInvCoaRevDirCd("0");
				//invArMnVo.setInvCoaSkdDirCd("0");
				//invArMnVo.setInvCoaVoyNo("0000");
				//invArMnVo.setInvCoaVslCd("0000");
				invArMnVo.setInvDeltDivCd("N");
				invArMnVo.setInvRefNo(genIfVo.getInvArIfMnVO().getInvRefNo());
				invArMnVo.setInvRmk(genIfVo.getInvArIfMnVO().getInvRmk());
				// -- 수정일자 : 2010.01.20(IF문주석처리) -----------------------------------
//				if(arInvIssFlg.equals("Y")) {
//					invArMnVo.setInvSrcNo("");
//				} else {
					invArMnVo.setInvSrcNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
//				}
				// ------------------------------------------------------------------------
				invArMnVo.setIoBndCd(ioBndCd);
				invArMnVo.setMstBlNo(genIfVo.getInvArIfMnVO().getMstBlNo());
				invArMnVo.setRfaNo(genIfVo.getInvArIfMnVO().getRfaNo());
				invArMnVo.setSailDt(sailDt);
				invArMnVo.setScNo(genIfVo.getInvArIfMnVO().getScNo());
				invArMnVo.setSiRefNo(genIfVo.getInvArIfMnVO().getSiRefNo());
				invArMnVo.setSlsOfcCd(genIfVo.getInvArIfMnVO().getSlsOfcCd());
				invArMnVo.setSrepCd(genIfVo.getInvArIfMnVO().getSrepCd());
				invArMnVo.setTaxXchRt("0");
				log.debug("\n########## genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo() : "+genIfVo.getInvArIfMnVO().getTrnkSkdVoyNo());
				if (trnkSkdVoyNo.equals("") ) {
					invArMnVo.setTrnkVslCd(vslCd);
					invArMnVo.setTrnkSkdVoyNo(skdVoyNo);
					invArMnVo.setTrnkSkdDirCd(skdDirCd);
				} else {
					invArMnVo.setTrnkSkdVoyNo(trnkSkdVoyNo);
					invArMnVo.setTrnkVslCd(trnkVslCd);
					invArMnVo.setTrnkSkdDirCd(trnkSkdDirCd);
				}
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>34");
								
				invArMnVo.setTrspRqstOrdFlg(genIfVo.getInvArIfMnVO().getTrspRqstOrdFlg());
				invArMnVo.setUpdDt(genIfVo.getInvArIfMnVO().getUpdDt());
				invArMnVo.setUpdUsrId(genIfVo.getInvArIfMnVO().getUpdUsrId());
				invArMnVo.setVvdTrnsFlg(genIfVo.getInvArIfMnVO().getVvdTrnsFlg());
				
//				if (svrId.equals("KOR")) {
//					invCoaRgnCd	= "11";
//				} else if (svrId.equals("USA")) {
//					invCoaRgnCd	= "21";
//				} else if (svrId.equals("JPN")) {
//					invCoaRgnCd	= "11";
//				} else if (svrId.equals("SWA")) {
//					invCoaRgnCd	= "41";
//				} else if (svrId.equals("EUR")) {
//					invCoaRgnCd	= "31";
//				} else if (svrId.equals("CHN")) {
//					invCoaRgnCd	= "41";
//				}
				//invArMnVo.setInvCoaRgnCd(invCoaRgnCd);
				
				vvdCustomerVo = new VVDCustomerVO();
				
				vvdCustomerVo.setInvCntryCd(genIfVo.getInvArIfMnVO().getCustCntCd());
				vvdCustomerVo.setInvCustCd(genIfVo.getInvArIfMnVO().getCustSeq());
				vvdCustomerVo.setVsl(vslCd);
				vvdCustomerVo.setVoy(skdVoyNo);
				vvdCustomerVo.setDep(skdDirCd);
				vvdCustomerVo.setLclCurr(lclCurr);
				// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
				if (svrId.equals("EUR") || svrId.equals("KOR")|| (svrId.equals("JPN") && ioBndCd.equals("O"))) {
					vvdCustomerVo.setSvcScp("OTH");
				} else {
					vvdCustomerVo.setSvcScp(svcScpCd);
				}
				vvdCustomerVo.setBnd(ioBndCd);
				//vvdCustomerVo.setOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
				vvdCustomerVo.setOfcCd(arOfcCd);
				log.debug("vvdCustomerVo.setOfcCd(arOfcCd)_3================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
				vvdCustomerVo.setBkgNo(bkgNo);
				vvdCustomerVo.setSaDt(sailArrDt);
				vvdCustomerVo.setPol(polCd);
				vvdCustomerVo.setPod(podCd);
				vvdCustomerVo.setCurr("USD"); 
				//2010-04-27 blNo 추가
				vvdCustomerVo.setBlSrcNo(genIfVo.getInvArIfMnVO().getBlSrcNo());

				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>35");
				
				if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") || genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS")|| genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD")){
					invArMnVo.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
					invArMnVo.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
					//2010-09-10 [CHM-201005887] DEM/DET, MRI의 환율적용일자 로직 보완 요청
					invArMnVo.setXchRtDt(exchangeRateVo.getExRateDate());
					
					if(exchangeRateVo.getExRate().equals("")||exchangeRateVo.getExRate().equals("0")){
						invArMnVo.setXchRtN3rdTpCd("A");
						invArMnVo.setXchRtUsdTpCd("A");
						
						// [CHM-201216303] DEM/DET인 경우는 환율을 구하지 못해서 경리 환율로 대체되는 경우에 환율적용일자를 LOCAL TIME 으로 생성한다
						invArMnVo.setXchRtDt(localTime);
					}
				}else{
					invArMnVo.setXchRtN3rdTpCd("A");
					invArMnVo.setXchRtUsdTpCd("A");
					
					// [CHM-201216303] DEM/DET 아닌 경우는 환율적용일자를 LOCAL TIME 으로 생성한다
					invArMnVo.setXchRtDt(localTime);
				}
				log.debug("\n########## invArMnVo.getExRateDate() : "+invArMnVo.getXchRtDt());
				log.debug("\n########## exchangeRateVo.getExRateDate() : "+exchangeRateVo.getExRateDate());
				
				if (exchangeRateVo.getExRateDate() != null && exchangeRateVo.getExRateDate().length() >= 6) {
					invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate().substring(0, 6));
				} else {
					invArMnVo.setAcctXchRtYrmon(exchangeRateVo.getExRateDate());
				}
				log.debug("\n########## KHH  invArMnVo.setAcctXchRtYrmon : "+invArMnVo.getAcctXchRtYrmon());
				//invArMnVo.setUsdXchRt(exchangeRateVo.getExRate());
				
//				if (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) { 
//					//String curr_cd_tmp = "";
//					BigDecimal totalLocalAmt = new BigDecimal(0);
//					int currPoint = 0;
//					
//					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>36");
//														
//					for (int i = 0; i < invArChgVos.size(); i++) {
////						curr_cd_tmp = genIfVo.getInvArIfChgVOs().get(i).getCurrCd() != null ? genIfVo.getInvArIfChgVOs().get(i).getCurrCd() : "";
////						if (curr_cd_tmp.equals("USD")) {
////							usdXchRt = genIfVo.getInvArIfChgVOs().get(i).getInvXchRt();
////						}
//						
//						log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>37");
//						
//						currPoint = bookingARCreationBC.searchCurrencyPoint(invArChgVos.get(i).getCurrCd());
//						
//						String trfRtAmt = invArChgVos.get(i).getTrfRtAmt();
//						String ratAsCntrQty = invArChgVos.get(i).getRatAsCntrQty();
//						String invXchRt2 = invArChgVos.get(i).getInvXchRt();
//							
//						log.debug("\n########## trfRtAmt : "+trfRtAmt);
//						log.debug("\n########## ratAsCntrQty : "+ratAsCntrQty);
//						log.debug("\n########## invXchRt2 : "+invXchRt2);						
//
//						BigDecimal sum = new BigDecimal(trfRtAmt).multiply(new BigDecimal(ratAsCntrQty).multiply(new BigDecimal(invXchRt2)));
//										
//						totalLocalAmt = totalLocalAmt.add(sum.setScale(currPoint,BigDecimal.ROUND_HALF_UP));
//						
//						log.debug("\n########## totalLocalAmt : "+totalLocalAmt);
//	
//					}
//					
//					invArMnVo.setInvTtlLoclAmt(String.valueOf(totalLocalAmt));
//				
//				} else {			
//					
//					invArMnVo.setInvTtlLoclAmt("0");
//					
//				}

				invArMnVo.setInvClrFlg("N");

				// -- 수정일자 : 2010.01.20(IF문 변경) --------------------------------------
				if((!otsSmryCd.equals("BL") && arInvIssFlg.equals("N")) ||
				   (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("MNR") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS") &&
					!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD") &&
					!otsSmryCd.equals("BL"))) {

					invArMnVo.setInvIssFlg("Y");
				} else {
					invArMnVo.setInvIssFlg("N");
				}
				// ------------------------------------------------------------------------
				// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
				if (svrId.equals("EUR") || svrId.equals("KOR")|| (svrId.equals("JPN") && ioBndCd.equals("O"))) {
					invArMnVo.setInvSvcScpCd("OTH");
				} else {
					invArMnVo.setInvSvcScpCd(svcScpCd);
				}
				
				//2010-07-05 Locl Charge에 의한 apArOffstNo가 "" 일때 넘겨준 apArOffstNo 세팅
				if(apArOffstNo.equals("")){
					apArOffstNo = genIfVo.getInvArIfMnVO().getApArOffstNo();
				}
				
				//2010-06-09
				invArMnVo.setApArOffstNo(apArOffstNo);
				
				//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
				//----------------이 없을 경우 , 수정함
				String revVslCd2 		 =	invArMnVo.getRevVslCd();
				String revSkdDirCd2      =	invArMnVo.getRevSkdDirCd();
				String revSkdVoyNo2      =	invArMnVo.getRevSkdVoyNo();
				String sailArrDt2        =	invArMnVo.getSailArrDt();
				String sailDt2           =	invArMnVo.getSailDt();
				String dueDt2            =	invArMnVo.getDueDt();
				String xchRtN3rdTpCd2    =	invArMnVo.getXchRtN3rdTpCd();
				String xchRtUsdTpCd2     =	invArMnVo.getXchRtUsdTpCd();
				String arCtyCd2          =	invArMnVo.getArCtyCd();
				String glEffDt2          =	invArMnVo.getGlEffDt();
				String actCustSeq2       =	invArMnVo.getActCustSeq();
				String usdXchRt2       	 =	invArMnVo.getUsdXchRt();
				
				if(revVslCd2 == null) revVslCd2 = "";
				if(revSkdDirCd2 == null) revSkdDirCd2 = "";
				if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
				if(sailArrDt2 == null) sailArrDt2 = "";
				if(sailDt2 == null) sailDt2 = "";
				if(dueDt2 == null) dueDt2 = "";
				if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
				if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
				if(arCtyCd2 == null) arCtyCd2 = "";
				if(glEffDt2 == null) glEffDt2 = "";
				if(actCustSeq2 == null) actCustSeq2 = "";
				if(usdXchRt2 == null) usdXchRt2 = "";
				
				log.debug("revVslCd2================>>>>>>>>>>>>>>>>>>>"+revVslCd2);
				log.debug("revSkdDirCd2================>>>>>>>>>>>>>>>>>>>"+revSkdDirCd2);
				log.debug("revSkdVoyNo2================>>>>>>>>>>>>>>>>>>>"+revSkdVoyNo2);
				log.debug("sailArrDt2================>>>>>>>>>>>>>>>>>>>"+sailArrDt2);
				log.debug("sailDt2================>>>>>>>>>>>>>>>>>>>"+sailDt2);
				log.debug("dueDt2================>>>>>>>>>>>>>>>>>>>"+dueDt2);
				log.debug("xchRtN3rdTpCd2================>>>>>>>>>>>>>>>>>>>"+xchRtN3rdTpCd2);
				log.debug("xchRtUsdTpCd2================>>>>>>>>>>>>>>>>>>>"+xchRtUsdTpCd2);
				log.debug("arCtyCd2================>>>>>>>>>>>>>>>>>>>"+arCtyCd2);
				log.debug("glEffDt2================>>>>>>>>>>>>>>>>>>>"+glEffDt2);
				log.debug("actCustSeq2================>>>>>>>>>>>>>>>>>>>"+actCustSeq2);
				log.debug("usdXchRt2================>>>>>>>>>>>>>>>>>>>"+usdXchRt2);
				
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("") || usdXchRt2.equals("")){
					invArMnVo.setBlInvCfmDt("");
				}

				invArMnVo.setCrInvNo(crInvNo);
				// INV_AR_MN table 에 저장			
				//dbDao.addInvMain(invArMnVo);
				bookingARCreationBC.addOtherInvMain(invArMnVo);				
								
				MdmOrganizationVO mdmOrganizationVO = new MdmOrganizationVO();
				mdmOrganizationVO = dbDao.searchInvCoaRgnInvCoaCtr(genIfVo.getInvArIfMnVO().getOfcCd()); 
				
				if (mdmOrganizationVO != null) {
					invCoaRgnCd = mdmOrganizationVO.getFincRgnCd();
					invCoaCtrCd = mdmOrganizationVO.getArCtrCd();
				}
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>38");
				
				invArAmtVo = new InvArAmtVO();
				
				if(genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") ||genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")||genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC")){
					invArAmtVo.setArInvSrcCd("DMTAR");
				}else if(genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") ||genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS")){
					invArAmtVo.setArInvSrcCd("3RD");
				}else{
					invArAmtVo.setArInvSrcCd("NISAR");
				}
				
				invArAmtVo.setInvCoaCoCd("01");
				invArAmtVo.setInvCoaRgnCd(invCoaRgnCd);
				invArAmtVo.setInvCoaCtrCd(invCoaCtrCd);
				invArAmtVo.setInvCoaInterCoCd(subsCoCd);
				invArAmtVo.setInvCoaVslCd("0000");
				invArAmtVo.setInvCoaVoyNo("0000");
				invArAmtVo.setInvCoaSkdDirCd("0");
				invArAmtVo.setInvCoaRevDirCd("0");
				invArAmtVo.setErpIfGlDt(glEffDt);   
				//invArAmtVo.setErpIfOfcCd(erpIfOfcCd);
				invArAmtVo.setErpIfOfcCd(arOfcCd);
				log.debug("invArAmtVo.setErpIfOfcCd(arOfcCd)================>>>>>>>>>>>>>>>>>>>"+arOfcCd);
				
				/////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////
				// INV_AR_AMT table 에 저장	
				//dbDao.addInvAmount(arIfNo, svrId, invArMnVo, invArAmtVo);
				bookingARCreationBC.addOtherInvAmount(arIfNo, svrId, invArMnVo, invArAmtVo);
								
				/////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////
				// INV_AR_CNTR 정보 세팅
				if (genIfVo.getInvArIfCntrVOs() != null) {
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>39");
					
					invArCntrVos = new ArrayList<InvArCntrVO>();

					for (int rowNum3 = 0; rowNum3 < genIfVo.getInvArIfCntrVOs().size(); rowNum3++) {
						invArCntrVo = new InvArCntrVO();

						invArCntrVo.setArIfNo(arIfNo);
						invArCntrVo.setCntrSeq(Integer.toString(rowNum3 + 1));
						invArCntrVo.setCntrNo(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCntrNo());
						invArCntrVo.setCntrTpszCd(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCntrTpszCd());
						invArCntrVo.setCreUsrId(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCreUsrId());
						invArCntrVo.setCreDt(genIfVo.getInvArIfCntrVOs().get(rowNum3).getCreDt());
						invArCntrVo.setUpdUsrId(genIfVo.getInvArIfCntrVOs().get(rowNum3).getUpdUsrId());
						invArCntrVo.setUpdDt(genIfVo.getInvArIfCntrVOs().get(rowNum3).getUpdDt());

						invArCntrVos.add(invArCntrVo);
						
						// 2014-05-27 소스품질 보완
						cntrNosBuff.append(invArCntrVos.get(rowNum3).getCntrNo() + (rowNum3 != genIfVo.getInvArIfCntrVOs().size() - 1 ? "," : ""));
						//cntrNos = cntrNos + invArCntrVos.get(rowNum3).getCntrNo() + (rowNum3 != genIfVo.getInvArIfCntrVOs().size() - 1 ? "," : "");
						
					}
					
					cntrNos = cntrNosBuff.toString();
					log.debug("\n########## cntrNos1 : " + cntrNos);
					
					if (cntrNos.length() > 150) {
						
						cntrNos = cntrNos.substring(0, 150);
						//log.debug("\n########## cntrNos2 : " + cntrNos);
						
						lastIdx = cntrNos.lastIndexOf(",");						
						//log.debug("\n########## lastIdx : " + lastIdx);
						
						cntrNos = cntrNos.substring(0, lastIdx);						
						//log.debug("\n########## cntrNos3 : " + cntrNos);
												
					}
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>40");
					
					if (invArCntrVos.size() > 0) {
						// INV_AR_CNTR table 에 저장	
						//dbDao.addInvContainer(invArCntrVos);
						bookingARCreationBC.addOtherInvContainer(invArCntrVos);
						
					}
					
					cntrTypeSizeVos = dbDao.searchCntrTpSzForERP(arIfNo);
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>41");
					
					for (int rowNum4 = 0; rowNum4 < cntrTypeSizeVos.size(); rowNum4++) {
						cntrTpSzsBuff.append(cntrTypeSizeVos.get(rowNum4).getCntrTpszCd() + "X" + cntrTypeSizeVos.get(rowNum4).getCntrTpszCnt() + (rowNum4 != cntrTypeSizeVos.size() - 1 ? "," : ""));
						//cntrTpSzs = cntrTpSzs + cntrTypeSizeVos.get(rowNum4).getCntrTpszCd() + "X" + cntrTypeSizeVos.get(rowNum4).getCntrTpszCnt() + (rowNum4 != cntrTypeSizeVos.size() - 1 ? "," : "");
					}
					cntrTpSzs = cntrTpSzsBuff.toString();
					log.debug("########## cntrTpSzs : " + cntrTpSzs);
					
				}
				
				// INV_AR_IF_MN Table 에 AR_IF_NO 업데이트
				dbDao.modifyIfNo(srcIfDt, srcIfSeq, arIfNo, genIfVo.getInvArIfMnVO().getOfcCd(), genIfVo.getInvArIfMnVO().getUpdUsrId());
				
				///////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////
				// ISSUE 처리
				
				log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>42");
				
				// -- 수정일자 : 2010.01.20(IF문수정) --
				// -- 2010.06.04 MNR 추가
				if ((!otsSmryCd.equals("BL") && arInvIssFlg.equals("N")) ||
				    (!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEC") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("MNR") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("EAS") &&
					 !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DOD") &&
					 !otsSmryCd.equals("BL"))) {

					InvIssMainVO issMainVo = null;	
					InvIssMainVO[] issMainVos = new InvIssMainVO[1];
					IssueOptionVO issOptionVO = new IssueOptionVO();
					  
					issMainVo = new InvIssMainVO();
					
					// -- 추가일자 : 2010.01.18(TPB체크로직추가) --------------------------------
					// -- 2010.6.04 넘겨준 INV_SRC_NO 그냥 사용하게 바꿈
					//if (genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TPB")) {
					//	InvoiceNumberVO invNumVo = invoiceIssueBC.searchInvoiceNumber(genIfVo.getInvArIfMnVO().getOfcCd(),
					//												  				  ioBndCd,
					//												  				  genIfVo.getInvArIfMnVO().getCreUsrId());
					//	issMainVo.setInvNo(invNumVo.getInvNo());
						
						// 추가일자 : 2010.01.29
					//	invoiceIssueBC.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), genIfVo.getInvArIfMnVO().getCreUsrId());

					//} else {
						issMainVo.setInvNo(genIfVo.getInvArIfMnVO().getInvSrcNo());
					//}
					// ------------------------------------------------------------------------
					
					issMainVo.setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
					issMainVos[0] = issMainVo;
					issOptionVO.setIssueGubn("O");
					issOptionVO.setIssOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());
					issOptionVO.setSendFlag("");
					issOptionVO.setSendFlag2("");
					
					// Issue Data 생성
					//dbDao.createIssueMain(issMainVo);
					invoiceIssueBC.createIssueMain(issMainVos, issOptionVO, genIfVo.getInvArIfMnVO().getCreUsrId());
					
					if (genIfVo.getInvArIfChgVOs() != null) {						
						log.debug("########## invArChgVos.size() : " + invArChgVos.size());
						for (int rowNum5 = 0; rowNum5 < invArChgVos.size(); rowNum5++) {

							IssueEachTargetVO issEachTgtVo = new IssueEachTargetVO();
							
							issEachTgtVo.setArIfNo(arIfNo);
							issEachTgtVo.setArIfSerNo(invArChgVos.get(rowNum5).getArIfSerNo());
							issEachTgtVo.setChgSeq(invArChgVos.get(rowNum5).getChgSeq());
							
							// INV_AR_ISS_DTL Data Creation
							invoiceIssueBC.createInvoiceMapping(issMainVo.getInvNo(), issEachTgtVo, genIfVo.getInvArIfMnVO().getCreUsrId());
						}
					
					}
					
					//2010-04-06 inv main에 invno issdt 업데이트 로직 추가
					bookingARCreationBC.modifyIssueFlag(issMainVo.getInvNo(), invArMnVo.getInvIssFlg(), genIfVo.getInvArIfMnVO().getCreUsrId());
					
					log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>43");
					
				}
				
//				if (reIssueFlag.equals("Y") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("TML")) {						
//					
//					///// Issue 처리
//					GeneralInvoiceVO genInvVo = null;
//					List<IssueTargetVO> issList = null;
//			        InvoiceNumberVO invNumVo = null;
//			        String invNo = "";
//			        InvIssMainVO issMainVo = null;	
//			        InvIssMainVO[] issMainVos = new InvIssMainVO[1];	
//			        List<IssueTargetVO> issList2 = null;
//			        List<IssueEachTargetVO> issList3 = null;
//			        IssueOptionVO issOptionVO = new IssueOptionVO();
//			        
//			        ////////////////////////////////////////////////////////////////////////
//					////////////////////////////////////////////////////////////////////////
//			        // Issue 대상을 조회한다
//			        genInvVo = new GeneralInvoiceVO();
//			        genInvVo.setArOfcCd2(genIfVo.getInvArIfMnVO().getOfcCd());
//			        genInvVo.setBlNos("'"+genIfVo.getInvArIfMnVO().getBlSrcNo()+"'");
//					//issList = dbDao.searchTargetBLForIssue(genInvVo);	
//			        issList = invoiceIssueBC.searchTargetBLForIssue(genInvVo);						
//					
//											
//					// 조회된 Issue 대상만큼 Looping 
//					for (int idx1 = 0; idx1 < issList.size(); idx1++) {
//					
//						if (genIfVo.getInvArIfMnVO().getInvSrcNo().equals("")) {						
//						
//							// Invoice No 채번
//							invNumVo = new InvoiceNumberVO();
////							invNumVo = dbDao.searchInvoiceNumber(genIfVo.getInvArIfMnVO().getOfcCd()
////									                           , ioBndCd
////									                           , genIfVo.getInvArIfMnVO().getCreUsrId());
//							invNumVo = invoiceIssueBC.searchInvoiceNumber(genIfVo.getInvArIfMnVO().getOfcCd()
//	                           , ioBndCd
//	                           , genIfVo.getInvArIfMnVO().getCreUsrId());
//							
//							invNo = invNumVo.getInvNo();							
//														
//							//dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), genIfVo.getInvArIfMnVO().getCreUsrId());
//							invoiceIssueBC.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), genIfVo.getInvArIfMnVO().getCreUsrId());
//						
//						} else {
//							
//							invNo = genIfVo.getInvArIfMnVO().getInvSrcNo();
//							
//						}
//						
//						issMainVo = new InvIssMainVO();
//						issMainVo.setInvNo(invNo);
//						issMainVo.setIssOfcCd(genIfVo.getInvArIfMnVO().getOfcCd());		
//						issMainVo.setCreUsrId(genIfVo.getInvArIfMnVO().getCreUsrId());
//						issMainVos[0] = issMainVo;
//						issOptionVO.setIssueGubn("O");
//						
//						// Issue Data 생성
//						//dbDao.createIssueMain(issMainVo);
//						invoiceIssueBC.createIssueMain(issMainVos, issOptionVO, genIfVo.getInvArIfMnVO().getCreUsrId());
//							
//						// 업데이트할 대상 Interface No 조회
//						//issList2 = dbDao.searchInterfaceNumberList(genInvVo, issList.get(idx1));
//						issList2 = invoiceIssueBC.searchInterfaceNumberList(genInvVo, issList.get(idx1));
//						
//						for (int idx2 = 0; idx2 < issList2.size(); idx2++) {
//							
//							// Issue Detail 생성 대상  조회
//							//issList3 = dbDao.searchEachTargetForIssue(issList2.get(idx2).getArIfNo());
//							issList3 = invoiceIssueBC.searchEachTargetForIssue(issList2.get(idx2).getArIfNo());
//							
//							for (int j = 0; j < issList3.size(); j++) {
//								// Issue Detail Data 생성
//								//dbDao.createInvoiceMapping(invNo, issList3.get(j), genIfVo.getInvArIfMnVO().getCreUsrId());
//								invoiceIssueBC.createInvoiceMapping(invNo, issList3.get(j), genIfVo.getInvArIfMnVO().getCreUsrId());
//							}
//						
//						}
//						
//					}				
//					
//				}						
								
				///////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////
				// ERP 전송 처리 시작
				//2010.10.01 최도순 [] NO GOOD 인데 ERP전송되는 오류 수정
				/*
				if(!genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DEM") && !genIfVo.getInvArIfMnVO().getIfSrcCd().equals("DET")) {
					if (!invArMnVo.getBlInvCfmDt().equals("")) {
	
						log.error("invArMnVo.getBlInvCfmDt()================================="+invArMnVo.getBlInvCfmDt());
						
						fns0120001Vos = dbDao.searchARInvoiceForERP(arIfNo, "C");
						
						
						for (int i = 0; i < fns0120001Vos.size(); i++) {
							log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>44_2");
							fns0120001Vos.get(i).setCntrNo(cntrNos);
							fns0120001Vos.get(i).setCntrTpSz(cntrTpSzs);
						}
						log.error("fns0120001Vos.size()======================================"+fns0120001Vos.size());
						
						if( fns0120001Vos.size()>0 ){
							eaiDao.interfaceARInvoiceToERPAR(fns0120001Vos);
						}
					}
				}
				*/
				// ERP 전송 처리 끝			
				
			} // genIfVos looping 끝
			
			log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>45");
			
			arIfNos = arIfNosBuff.toString();
			
			if (errFlag.equals("Y")) {
				log.debug("########## errRsn : " + errRsn);
				return "E::"+errRsn;
			} else {
				log.debug("########## arIfNos : " + arIfNos);
				return "S::"+arIfNos;
			}
						
		} catch(DAOException ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>dao err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>exp err:" + ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_IF_MN Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return InvArIfMnVO
	 * @exception EventException
	 */
	public InvArIfMnVO searchInvArIfMain(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfMain(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_IF_CHG Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfChg(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_IF_CNTR Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfCntrVO>
	 * @exception EventException
	 */
	public List<InvArIfCntrVO> searchInvArIfCntr(String srcIfDt, String srcIfSeq) throws EventException {
		try {
			return dbDao.searchInvArIfCntr(srcIfDt, srcIfSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}		
	
	/**
	 * INV_AR_MN Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfMain(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfMain(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_AMT Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfAmt(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfAmt(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_CHG Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfChg(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfChg(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_CNTR Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfCntr(String arIfNo) throws EventException {
		try {
			dbDao.removeArIfCntr(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	
	
	/**
	 * INV 에서 발생한 매출채권 정보를 EAI를 통해(FNS012-0001) ERP AR로 전송다 한<br> 
	 * 
	 * @param String ifNo
	 * @exception EventException
	 */
	public void interfaceARInvoiceToERPAR(String ifNo) throws EventException{
		
		List<Fns0120001VO> fns0120001VOs =  new ArrayList<Fns0120001VO>();;
		
		try {
				
				String arIfNoArr[] = ifNo.split("\\|");
								
				for (int i = 0; i < arIfNoArr.length; i++) {				
			
					int cnt = dbDao.checkGoodData(arIfNoArr[i]);
					
					if( cnt > 0 ) {
				
						List<Fns0120001VO> list1= null;					
						List<CntrTypeSizeVO> cntrTypeSizeVOs = null;
						List<InvArCntrVO> invArCntrVOs = null;
						
						String cntrNos = "";
						String cntrTpSzs = "";
						
						StringBuffer cntrNosBuff = new StringBuffer();
						StringBuffer cntrTpSzsBuff = new StringBuffer();
						
						list1 = dbDao.searchARInvoiceForERP(arIfNoArr[i], "C");
						
						invArCntrVOs = dbDao.searchARInvoiceContainer(arIfNoArr[i]);
						
						// ERP 전송 처리 시작
						if (invArCntrVOs.size() > 0) {
							for (int j = 0; j < invArCntrVOs.size(); j++) {
								cntrNosBuff.append(invArCntrVOs.get(j).getCntrNo() + (j != invArCntrVOs.size() - 1 ? "," : ""));
								//cntrNos = cntrNos + invArCntrVOs.get(j).getCntrNo() + (j != invArCntrVOs.size() - 1 ? "," : "");
							}
							cntrNos = cntrNosBuff.toString();
							
							int lastIdx = 0;
							if (cntrNos.length() > 150) {
								
								cntrNos = cntrNos.substring(0, 150);
								//log.debug("\n########## cntrNos2 : " + cntrNos);
								
								lastIdx = cntrNos.lastIndexOf(",");						
								//log.debug("\n########## lastIdx : " + lastIdx);
								
								cntrNos = cntrNos.substring(0, lastIdx);						
								//log.debug("\n########## cntrNos3 : " + cntrNos);
														
							}
							log.debug("########## cntrNos : " + cntrNos);
		
							cntrTypeSizeVOs = dbDao.searchCntrTpSzForERP(arIfNoArr[i]);
		
							for (int k = 0; k < cntrTypeSizeVOs.size(); k++) {
								cntrTpSzsBuff.append(cntrTypeSizeVOs.get(k).getCntrTpszCd() + "X" + cntrTypeSizeVOs.get(k).getCntrTpszCnt() + (k != cntrTypeSizeVOs.size() - 1 ? "," : ""));
								//cntrTpSzs = cntrTpSzs + cntrTypeSizeVOs.get(k).getCntrTpszCd() + "X" + cntrTypeSizeVOs.get(k).getCntrTpszCnt() + (k != cntrTypeSizeVOs.size() - 1 ? "," : "");
							}
							cntrTpSzs = cntrTpSzsBuff.toString();
							log.debug("########## cntrTpSzs : " + cntrTpSzs);
						}					
		
						for (int l = 0; l < list1.size(); l++) {					
							list1.get(l).setCntrNo(cntrNos);
							list1.get(l).setCntrTpSz(cntrTpSzs);
						}
						
						fns0120001VOs.addAll(list1);
						
						eaiDao.interfaceARInvoiceToERPAR(fns0120001VOs);
					}
				
				}
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ex);
		}
	}
}