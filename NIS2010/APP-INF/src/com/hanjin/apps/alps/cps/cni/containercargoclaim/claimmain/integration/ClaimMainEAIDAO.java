/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainEAIDAO.java
*@FileTitle : CRM Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.01 진윤오
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2011.09.21 한종희 CHM-201113538
* 제목 : [CNI] Claim main Creation 기능 보완
* 내용 : Claim main save시 VOC No가 있는 경우 CRM으로 Claim 처리 정보를 Interface하고 있음.
* 이때 실제 Claim 청구 금액에 대한 실제 지불 금액항목을 잘못 Interface하고 있어 그 오류를 수정함.
* ccm.setCurrentMileage(vo.getClmtUsdAmt()); 에서
* ccm.setCurrentMileage(vo.getCgoClmStlUsdAmt()); 으로 변경
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.Date;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CMSServiceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.cms.CMS0030001Document;
import com.hanjin.irep.cms.CMS0030001Document.CMS0030001;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;
import com.jf.transfer.ws.AxDocClient;


/**
 * ClaimMainEAIDAO <br>
 * Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author clt
 * @see ClaimMainBCImpl 참조
 * @since J2EE 1.4
 */
public class ClaimMainEAIDAO extends EAIDAOSupport {

	private transient Logger log = Logger.getLogger(ClaimMainEAIDAO.class.getName());
	
	/**
	 * VOC NO 정보를 EAI서버로 전송.<br>
	 * 
	 * @param CMSServiceVO vo
	 * @throws DAOException
	 */
	public void sendCRMData(CMSServiceVO vo) throws DAOException {

		
		if (vo == null){
			return;
		}
		
		//Request Start
		String target = SubSystemConfigFactory.get("CNI.CMS0030001.WSDL");
		this.log.info("@@WSDL Address -->["+target+"]");
		
		
		// 1. Send doc 생성
    	CMS0030001Document document = CMS0030001Document.Factory.newInstance();
    	CMS0030001 cms003001 = document.addNewCMS0030001();    	
    	// 해더 작성
    	com.hanjin.irep.cms.EAIHeaderType headerType = cms003001.addNewEAIHeader();
    	String curDt = DateTime.getFormatDate(new Date(), "yyyyMMddHHmmss");
    	String instanceId = "CMS003_0001J" + curDt + "-" + vo.getCrmVocNo();
    	headerType.setInstanceId(instanceId);
    	    	
    	CMS0030001Document.CMS0030001.DataArea dataArea = cms003001.addNewDataArea();
    	CMS0030001Document.CMS0030001.DataArea.CCMCollection collection = dataArea.addNewCCMCollection();
    	CMS0030001Document.CMS0030001.DataArea.CCMCollection.CCM ccm = collection.addNewCCM();
    	
    	
    	ccm.setSRNumber(vo.getCrmVocNo());
		ccm.setHJSCCMSClaimId(vo.getCgoClmNo());
		ccm.setHJSCCMSStatus(vo.getCgoClmStsCd());
		ccm.setCEMTotalTime(vo.getClmtUsdAmt());
		ccm.setCurrentMileage(vo.getCgoClmStlUsdAmt());
		ccm.setHJSTOC(vo.getCgoClmTpCd());

		//비동기호출
		this.log.info("Request Document -->[" + document.toString()+"]");
		TransferEAI transferEAI = new AxAyDocClient(target, this.getClass());
	
		transferEAI.setMessage(document.toString());
		
		String transferMsg = "";
		
		try {
			transferMsg = transferEAI.commit(headerType.getInstanceId());
		} catch (EAIException ex) {
			this.log.error(ex.getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		this.log.info("Response Document -->["+ transferMsg.toString()+"]");
		
		transferEAI.close();	
	}
}

