package com.hanjin.sample.fmc;

import gov.fmc.servconWebServices.FileCorrectedCopyDocument;
import gov.fmc.servconWebServices.FileCorrectedCopyDocument.FileCorrectedCopy;

import java.io.File;
import java.rmi.Naming;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.framework.component.util.io.FileUtils;
import com.web.service.RMIInterface;
import com.web.service.rmi.model.RmiFmcObject;

public class FmcRmiSample {

	public void rmiClient() throws Exception{
		String serverUrl = "rmi://172.20.94.171:4711/webservice";
        RMIInterface rmiClient =  (RMIInterface)Naming.lookup(serverUrl);
        
        CstPriSpMnFileDtVO vo = new CstPriSpMnFileDtVO();
        vo.setScNo("AEF180052");
        vo.setAmdtSeq("0");
        vo.setFileProgSeq("0");
        vo.setFileCorrCmtCtnt("test");
        FileCorrectedCopyDocument fileCorrectedCopyDocument = FileCorrectedCopyDocument.Factory.newInstance();  
        FileCorrectedCopy fileCorrectedCopy = FileCorrectedCopy.Factory.newInstance();
        File filename = new File("c:/temp/AEF180052_#000.doc");
        byte[] fileArray = FileUtils.getBytesFromFile(filename); 
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
        
        
        RmiFmcObject object = new RmiFmcObject();
        object.setUserId("TP_SERVCON_filing@smlines.com");
        object.setUserPasswd("027049SMLM*");
        object.setDefaultServer("https://servconwebservicetest.fmc.gov/SERVCONWebservice.asmx");
        object.setSoapAction("http://www.fmc.gov/ServconWebServices/FileCorrectedCopy");
        object.setMessage(fileCorrectedCopyDocument.toString());
        
        String returnMsg = rmiClient.fmc(object);
        System.out.println("============================= \n" + returnMsg);
	}
}
