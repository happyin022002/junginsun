package com.hanjin.sample.fmc;

import gov.fmc.servconWebServices.FileCorrectedCopyDocument;
import gov.fmc.servconWebServices.FileCorrectedCopyResponseDocument;
import gov.fmc.servconWebServices.ServiceContractFiling;
import gov.fmc.servconWebServices.FileCorrectedCopyDocument.FileCorrectedCopy;
import gov.fmc.servconWebServices.FileCorrectedCopyResponseDocument.FileCorrectedCopyResponse;

import java.io.File;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.framework.component.excel.ExcelParser;
import com.hanjin.framework.component.excel.ExcelRowInfo;
import com.hanjin.framework.component.excel.ExcelSheetInfo;
import com.hanjin.framework.component.rdexport.ReportDesignerExporter;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/**
 * ExcelParserSample
 * @author 9008631
 *
 */
public class FilingSample implements Runnable{

	public transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
	
	private File makeRdFile() throws Exception {
	        File file = null;
	        
	        try {
	            
	            String path = "c:/temp/AEF180053_0.doc";     
	        
	            file = new File(path);
	                
	        } catch(Exception e) {
	            System.out.println(e.getMessage());
	            throw e;
	        }
	        
	        return file;
	        
	    }
	   
	   
//	public static void main(String[] args) throws Exception {
//        
//        try {
            
//            FilingSample f = new FilingSample();
//            FilingSample f2 = new FilingSample();
//            f.filing(args);
//            
//            //f2.filing(args);
//            f.filing(args);

            
//        } catch (EAIException e) {
//            System.out.println ("FileCorrectedCopy-Exception1 ==>"+e.toString());
//
// 
//        }    
//    }
	
	
	   public  void filing() throws Exception {
	        TransferEAI eai = null;
	        FileCorrectedCopyResponseDocument docRes = null;
	        String result = "";
	        CstPriSpMnFileDtVO vo = new CstPriSpMnFileDtVO();
	        vo.setScNo("AEF180052");
	        vo.setAmdtSeq("0");
	        vo.setFileProgSeq("0");
	        vo.setFileCorrCmtCtnt("test");
	        try {
	            
	            
	            System.out.println ("FileCorrectedCopy-#2-1|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            //FileCorrectedCopy
	            FileCorrectedCopyDocument fileCorrectedCopyDocument = FileCorrectedCopyDocument.Factory.newInstance();  
	            FileCorrectedCopy fileCorrectedCopy = FileCorrectedCopy.Factory.newInstance();
	            
	            //RD 파일 첨부 (수정되어져야함)
	            //File filename = new File("D:/WORK/GLO142607_#000.doc");
	            
	            System.out.println ("FileCorrectedCopy-#2-2|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            File filename = makeRdFile();
	            System.out.println ("FileCorrectedCopy-#2-3|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            byte[] fileArray = FileUtils.getBytesFromFile(filename); 
	            System.out.println ("FileCorrectedCopy-#2-4|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            fileCorrectedCopy.setFileData(fileArray);
	            fileCorrectedCopy.setFileName("AEF180052_#000.doc");
	            
	            fileCorrectedCopy.setNewOrgNum("027049");
	            fileCorrectedCopy.setOldOrgNum("027049");
	            fileCorrectedCopy.setNewConNum(vo.getScNo());
	            fileCorrectedCopy.setOldConNum(vo.getScNo());
	            fileCorrectedCopy.setChangeFlag("File");
	            fileCorrectedCopy.setAmdNum(vo.getAmdtSeq());
	            fileCorrectedCopy.setUserName("srjeon");
	            fileCorrectedCopy.setComments(vo.getFileCorrCmtCtnt());
	            
	            fileCorrectedCopyDocument.setFileCorrectedCopy(fileCorrectedCopy);
	            
	            System.out.println ("FileCorrectedCopy-#2-5|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            //WSDL URL 지정
//	          eai = new AxDocClient(SubSystemConfigFactory.get("FMC.WSDL"), this.getClass());
//	          //SSL 접속 아이디/비밀번호
//	          eai.setUserId("srjeon");
//	          eai.setUserPasswd("H-z6eG5}!");
//	            System.out.println(">>>H-z6eG5}!<<<");
	            eai = new AxDocClient("https://servconwebservicetest.fmc.gov/SERVCONWebservice.asmx", this.getClass());
	            //SSL 접속 아이디/비밀번호
	            eai.setUserId("TP_SERVCON_filing@smlines.com");
	            eai.setUserPasswd("027049SMLM*");           
	            System.out.println(">>>027049SMLM*<<<");
	            
	            
	            eai.setDestination(SubSystemConfigFactory.get("FMC.FILECORRECTEDCOPY.URL")); 
	        
	            
	            System.out.println ("\n\n=================================SEND Start==========================================\n\n");

	            System.out.println (fileCorrectedCopyDocument.toString());
	            System.out.println ("\n\n=================================SEND End==========================================\n\n");

	            
	            System.out.println ("FileCorrectedCopy-#2-6|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            eai.setMessage(fileCorrectedCopyDocument.toString());
	            eai.setCallTimeOut(300000);
	            System.out.println ("FileCorrectedCopy-#2-7|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            result = eai.commit("");

	            System.out.println ("FileCorrectedCopy-#2-8|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            System.out.println(result);
	            
	            docRes = FileCorrectedCopyResponseDocument.Factory.parse(result);
	            FileCorrectedCopyResponse fileCorrectedCopyResponse = docRes.getFileCorrectedCopyResponse();
	            ServiceContractFiling serviceContractFiling  = fileCorrectedCopyResponse.getFileCorrectedCopyResult();
	            
	            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	            System.out.println(serviceContractFiling.toString());
	            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	            
	            vo.setFmcFileNm(serviceContractFiling.getFileName());
	            vo.setOrzNo(serviceContractFiling.getOrgNum());
	            vo.setFmcCtrtNo(serviceContractFiling.getConNum());
	            vo.setFmcAmdtNo(serviceContractFiling.getAmdNum()+"");
	            vo.setFmcFileUsrId(serviceContractFiling.getUserName());
	            vo.setFmcFileSessId(serviceContractFiling.getSessionId()+"");
	            vo.setFmcNo(serviceContractFiling.getFMCNum()+"");
	            vo.setFmcEffDt(serviceContractFiling.getEffDate());
	            vo.setCfmNo(serviceContractFiling.getConfirmNum());
	            vo.setFileSzCapa(serviceContractFiling.getFileSize()+"");
	            
	            
	            vo.setErrCodeUserName(serviceContractFiling.getErrCodeUserName()+"");
	            vo.setErrCodeOrgNum(serviceContractFiling.getErrCodeOrgNum()+"");
	            vo.setErrCodeConNum(serviceContractFiling.getErrCodeConNum()+"");
	            vo.setErrCodeAmdNum(serviceContractFiling.getErrCodeAmdNum()+"");
	            vo.setErrCodeEffDate(serviceContractFiling.getErrCodeEffDate()+"");
	            vo.setErrCodeFile(serviceContractFiling.getErrCodeFile()+"");
	            
	            vo.setErrMsgUserName(serviceContractFiling.getErrMsgUserName());
	            vo.setErrMsgOrgNum(serviceContractFiling.getErrMsgOrgNum());
	            vo.setErrMsgConNum(serviceContractFiling.getErrMsgConNum());
	            vo.setErrMsgAmdNum(serviceContractFiling.getErrMsgAmdNum());
	            vo.setErrMsgEffDate(serviceContractFiling.getErrMsgEffDate());
	            vo.setErrMsgFile(serviceContractFiling.getErrMsgFile());
	            System.out.println ("FileCorrectedCopy-#2-9|"+vo.getScNo()+"|"+vo.getAmdtSeq()+"|"+vo.getFileProgSeq());
	            
	            
	        } catch (EAIException e) {
	            System.out.println ("FileCorrectedCopy-Exception1 ==>"+e.toString());

	            eai.rollback(e);
	            throw new DAOException(e.getMessage());
	        } catch (Exception e) {
	            System.out.println ("FileCorrectedCopy-Exception2 ==>"+e.toString());

	            eai.rollback(e);
	            throw new DAOException(e.getMessage());
	        }finally{
	            eai.close();
	        }    
	    }


	@Override
	public void run() {
		try {
			filing();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
