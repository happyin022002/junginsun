/* =========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : DMTInterfaceEAIProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-04-22
 *@LastModifier : 9014791
 *@LastVersion : 1.0
 * 2015-04-22
 * 1.0 최초 생성
 * --------------------------------------------------------------------------------------
 * History
 * 2015.03.31 이성훈 CHM-201535240 [DMT] ERP 역 IF 개발
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.servicesio;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.DMTInvoiceMgtSC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.ESM0750001Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsPayRcvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.enisEsm.ESM0750001Document;
import com.hanjin.irep.enisEsm.ESM0750001Document.ESM0750001.DataArea.ROW;
import com.jf.transfer.TransferEAI;

/**
 * DMTInterfaceEAIProxy.java
 * 
 * @author Lee SungHoon
 * @see
 * @since J2EE 1.6 May 22, 2015
 */
public class DMTInterfaceEAIProxy {
	
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
	/**
	 * ERP 에서 전송한 데이터를 수신한다. <br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */    
    public void receiveOtsInfo(TransferEAI eai) throws DAOException {

        String msg = eai.getMessage();
        log.error("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] receive message : \n" + msg);
        
        try {
            log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> convertXmlToVo [S]");
            OtsPayRcvVO otsPayRcvVO = this.convertXmlToVo(ESM0750001Document.Factory.parse(msg));
            log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> convertXmlToVo [E]");
            if (!StringUtils.isEmpty(otsPayRcvVO.getDmdtInvNo())) {
            	
            	ESM0750001Event event = new ESM0750001Event("ESM0750001Event");
            	event.setOtsPayRcvVO(otsPayRcvVO);
            	
            	DMTInvoiceMgtSC dmtInvoiceMgtSC = new DMTInvoiceMgtSC();
                FormCommand f = new FormCommand();
                event.setFormCommand(f);
                
                //ERP 역I/F 수신정보를 등록한다.
                f.setCommand(FormCommand.SEARCH);
                log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> DMTInvoiceMgtSC.addOtsInfo [S]");
                dmtInvoiceMgtSC.perform(event);
                log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> DMTInvoiceMgtSC.addOtsInfo [E]");
                
                //ERP 역I/F 수신정보 등록 후, 미수금 완납여부를 조회해서 상태를 갱신해준다.
                f.setCommand(FormCommand.SEARCH01);
                log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> DMTInvoiceMgtSC.modifyOtsCltFlg [S]");
                dmtInvoiceMgtSC.perform(event);
                log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> DMTInvoiceMgtSC.modifyOtsCltFlg [E]");
            }
            
            log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> EAI.Commit [S]");
            eai.commit(otsPayRcvVO.getEaiIfId());
            log.info("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] execute >> EAI.Commit [E]");
        } 
        catch (EventException e) {
            eai.rollback(e);
            log.error("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] EventException: "+e.getMessage());
            throw new DAOException(new ErrorHandler(e).getMessage());
        } 
        catch (XmlException e) {
            eai.rollback(e);
            log.error("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] XmlException: "+e.getMessage());
            throw new DAOException(new ErrorHandler(e).getMessage());
        } 
        catch (com.jf.transfer.eai.exception.EAIException e) {
            eai.rollback(e);
            log.error("\n\n[DMTInterfaceEAIProxy][receiveOtsInfo] EAIException: "+e.getMessage());
            throw new DAOException(new ErrorHandler(e).getMessage());
        }
        eai.close();
    }  
    
    /**
     * ERP 에서 전송한 데이터를 저장하기 위해 VO 객체로 변환시켜준다.
     * @param ESM0750001Document esdDoc
     * @return OtsPayRcvVO
     */
    private OtsPayRcvVO convertXmlToVo(ESM0750001Document esdDoc) {
    	

    	ROW row = esdDoc.getESM0750001().getDataArea().getROW();
    	
    	String eaiIfId = esdDoc.getESM0750001().getEAIHeader().getInstanceId();
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append("\n\n[OTS Info received from ERP]")
    		.append("\n")
    		.append("DMDT_INV_NO : ")
    		.append(row.getDMDTINVNO())
    		.append(", INV_PAY_OFC_CD : ")
    		.append(row.getCREOFCCD())
    		.append(", BL_NO : ")
    		.append(row.getBLNO())
    		.append(", INV_PAY_TP_CD : ")
    		.append(row.getINVPAYTPCD())
    		.append(", IO_BND_CD : ")
    		.append(row.getINVIOBNDCD())
    		.append(", INV_PAY_DT : ")
    		.append(row.getINVPAYDT())
    		.append(", INV_PAY_AMT : ")
    		.append(row.getINVPAYAMT())
    		.append(", INV_CURR_CD : ")
    		.append(row.getINVCURRCD())
    		.append(", INV_PAY_COFF_DT : ")
    		.append(row.getINVPAYCOFFDT())
    		.append(", INV_PAY_RCV_SEQ : ")
    		.append(row.getINVPAYSEQ())    		
    		.append(", BKG_NO : ")
    		.append(row.getBKGNO())
    		.append(", INV_BAL_AMT : ")
    		.append(row.getINVBALAMT())
    		.append(", EAI_IF_ID : ")
    		.append(eaiIfId);
    	log.debug(sb.toString());

    	String dmdtInvPayTpCd = "";
    	if ("VAT".equals(row.getINVPAYTPCD())) {
    		dmdtInvPayTpCd = "V";
    	}
    	else if ("MRIAR".equals(row.getINVPAYTPCD())) {
    		dmdtInvPayTpCd = "M";
    	}

    	OtsPayRcvVO otsPayRcvVO = new OtsPayRcvVO();
    	// INV No. 가 없는 경우 저장하지 않는다.
    	if (!StringUtils.isEmpty(row.getDMDTINVNO())) {
	    	otsPayRcvVO.setDmdtInvNo(		row.getDMDTINVNO()		);
	    	otsPayRcvVO.setBlNo(			row.getBLNO()			);
	    	otsPayRcvVO.setDmdtInvPayTpCd(	dmdtInvPayTpCd			);
	    	otsPayRcvVO.setIoBndCd(			row.getINVIOBNDCD()		);
	    	otsPayRcvVO.setInvPayDt(		row.getINVPAYDT()		);
	    	otsPayRcvVO.setInvPayAmt(		row.getINVPAYAMT()		);
	    	otsPayRcvVO.setInvCurrCd(		row.getINVCURRCD()		);
	    	otsPayRcvVO.setInvPayCoffDt(	row.getINVPAYCOFFDT()	);
	    	otsPayRcvVO.setInvPayOfcCd(		row.getCREOFCCD()		);
	    	otsPayRcvVO.setInvPayRcvSeq(	row.getINVPAYSEQ()		);
	    	otsPayRcvVO.setBkgNo(			row.getBKGNO()			);
	    	otsPayRcvVO.setInvBalAmt(		row.getINVBALAMT()		);
	    	otsPayRcvVO.setCreUsrId(        "DMT_ERP"               );
	    	otsPayRcvVO.setUpdUsrId(        "DMT_ERP"               );
    	}
    	otsPayRcvVO.setEaiIfId(			eaiIfId					);
    	
    	return otsPayRcvVO;
    }
}
