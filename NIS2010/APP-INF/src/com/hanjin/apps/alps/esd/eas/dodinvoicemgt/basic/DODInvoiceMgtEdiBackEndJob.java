/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DODInvoiceMgtEdiBackEndJob.java
 *@FileTitle : DODInvoiceMgtEdiBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.04.30
 *@LastModifier : JS AN
 *@LastVersion : 1.0
 * 2014.04.30 JS
 * 1.0 Creation
 * 2014.04.30 JS [CHM-201429551] KL NET과 인보이스 데이터 EDI 요청
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic.DODInvoiceMgtBC;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * NIS2010-DOD Invoice Business Logic Basic Command implementation<br>
 * - NIS2010-DOD Invoice에 대한 비지니스 로직을 처리한다.<br>
 * @author JS AN
 * @see 
 * @since J2EE 1.4
 */
public class DODInvoiceMgtEdiBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -6056305194277894107L;
	private DODInvoiceMainVO dodInvoiceMainVO = null;
	private DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;
	private String docName;
	private String docFunc;

	/**
	 * EDI Tramsmit Main Data <br>
	 * 
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 */
	public void setDODInvoiceMainVO(DODInvoiceMainVO dodInvoiceMainVO) {
		this.dodInvoiceMainVO = dodInvoiceMainVO;
	}

	/**
	 * EDI Tramsmit Detail Data<br>
	 * 
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 */
	public void setDODInvoiceDetailVO(DODInvoiceDetailVO[] dodInvoiceDetailVOs) {
		this.dodInvoiceDetailVOs = dodInvoiceDetailVOs;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * 화면ID세팅<br>
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	/**
	 * @param docFunc the docFunc to set
	 */
	public void setDocFunc(String docFunc) {
		this.docFunc = docFunc;
	}
	
	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public String doStart() throws Exception {
		DODInvoiceMgtBC command = null;
		
		log.debug("\n doStart()::start============================");
	
		if ("ESD_EAS_0100".equals(pgmNo)) {  	//EAS Invoice EDI Transmit
			command = new DODInvoiceMgtBCImpl();
			setDocName("DDI");
			setDocFunc("9");
			log.debug("\n doStart()::EAS Invoice EDI Transmit============================");
			return command.transmitEASEDI(dodInvoiceMainVO, dodInvoiceDetailVOs, account, docName, docFunc);
		}else if ("ESD_EAS_0100_1".equals(pgmNo) ) {  	//EAS Invoice Cancel EDI Transmit
			command = new DODInvoiceMgtBCImpl();
			setDocName("DDI");
			setDocFunc("1");
			log.debug("\n doStart()::ESD_EAS_0100_1::docName["+docName+"]::docFunc["+docFunc+"]============================");
			return command.transmitEASEDI(dodInvoiceMainVO, dodInvoiceDetailVOs, account, "DDI", "1");	
		}else if ("ESD_EAS_0102".equals(pgmNo)) {  	//EAS AR I/F EDI Transmit
			command = new DODInvoiceMgtBCImpl();
			setDocName("DDP");
			setDocFunc("9");
			return command.transmitEASEDI(dodInvoiceMainVO, dodInvoiceDetailVOs, account, docName, docFunc);	
		}else if ("ESD_EAS_0102_1".equals(pgmNo)) {  	//EAS AR I/F Cancel EDI Transmit
			command = new DODInvoiceMgtBCImpl();
			setDocName("DDP");
			setDocFunc("1");
			log.debug("\n doStart()::ESD_EAS_0102_1::docName["+docName+"]::docFunc["+docFunc+"]============================");
			return command.transmitEASEDI(dodInvoiceMainVO, dodInvoiceDetailVOs, account, "DDP", "1");				
		}else{
			log.debug("\n doStart()::else case ============================");
		}
		
		log.debug("\n doStart()::end============================");
		
		return "Y";
	}
	
	
}
