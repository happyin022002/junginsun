/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryRetrive.java
*@FileTitle	: TerminalInvoiceInquiry
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * SPP_TES_005 에 대한 WebService Document Object including	Parameters<br>
 * - TerminalInvoiceIWSProxy의 Input	Parameter<br>
 * - SPP_TES_005Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */

public class TerminalInvoiceExcelPrint { 
	
	/**	(Param 객체) */
	private	String serviceOrderNo = null;	
	
	/**
	 * 
	 * @return
	 */
	public String getServiceOrderNo()   {		
		return serviceOrderNo;		}
	
	/**
	 * 
	 * @param serviceOrderNo
	 */
	public void	setServiceOrderNo(String	serviceOrderNo) {		
		this.serviceOrderNo		= serviceOrderNo;		
	}
}
