/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCollectionReportBackEndJob.java
*@FileTitle : Uncollected Charge by Aging
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 정운
*@LastVersion : 1.0
* 2013.12.10 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.YearlyCollectionByRHQVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Uncollected Charge by Aging<br>
 * - ALPS-Uncollected Charge by Aging Report 조회 시 BackEndJob로직 수행<br>
 * @author Joeng Un
 * @see ChargeCollectionReportBCImpl Class 참조
 * @since J2EE 1.6
 */
public class ChargeCollectionReportBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 1L;
		
	// Login User Information
	private		SignOnUserAccount			account	 
	= null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private 	YearlyCollectionByRHQVO 	pramVO 							= null;
	private		ChargeCollectionReportBC	chargeCollectionReportCommand	= new ChargeCollectionReportBCImpl();
	
	private String jobCommand = ""; 

	
	
	public ChargeCollectionReportBackEndJob() {
		//1) 비즈니스 로직을 수행하기 위한 BC 생성 ===================================================================
		chargeCollectionReportCommand	= new ChargeCollectionReportBCImpl();
	}
	
	public void setYearlyCollectionByRHQVO(YearlyCollectionByRHQVO yearlyCollectionByRHQVO) {
		this.pramVO = yearlyCollectionByRHQVO;
	}
	
	public void setUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * 년도별, RHQ OFFICE CODE 별, AGING 정보을 BackEnd Job 으로 실행후 결과를 반환합니다.<br>
	 * 
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		List<YearlyCollectionByRHQVO>	returnVO	= null;
		
		try {
			returnVO = chargeCollectionReportCommand.searchYearlyCollectionByRHQOffice(pramVO);
		}catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		
		return returnVO;
	}
	
	
	/**
	 * @return the account
	 */
	public SignOnUserAccount getSignOnUserAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * @return the jobCommand
	 */
	public String getJobCommand() {
		return jobCommand;
	}


	/**
	 * @param jobCommand the jobCommand to set
	 */
	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}
}
