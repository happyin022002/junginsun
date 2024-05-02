/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAORsltMOTFilingLogWithBkgList.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
* Oracle PIVOT함수 사용시 FOR  CHG_TY IN (상수) 에서 상수 부분은 그야말로 상수 부분이어서 
* 가변이 불가함. 따라서, SQL을 생성시 바꿔줘야함.
* 하지만, SCReportDBDAORsltMOTFilingLogWithBkgListRSQL은 SQLEditor에 의해 언제든지 변경 가능하므로 
* 해당 클래스를 직접 수정하는 것은 유지관리 좋지 않음
* DAO에서는 이 클래스를 통해 SCReportDBDAORsltMOTFilingLogWithBkgListRSQL 쿼리를 호출하게 함
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;


/**
 * Dummy Class for running SCReportDBDAORsltMOTFilingLogWithBkgListRSQL
 * 
 * @author Byeon Young Joo
 * @see SCReportDBDAORsltMOTFilingLogWithBkgListRSQL
 * @since J2EE 1.6
 */
public class SCReportDBDAORsltMOTFilingLogWithBkgList implements ISQLTemplate {
	Logger log =Logger.getLogger(this.getClass());
	
	SCReportDBDAORsltMOTFilingLogWithBkgListRSQL fileLogBkg;
	
	private String chg_lst = "";
	
	public SCReportDBDAORsltMOTFilingLogWithBkgList() {
		fileLogBkg = new SCReportDBDAORsltMOTFilingLogWithBkgListRSQL();
	}
	
	public void setReplace(String sCharges){
		chg_lst = sCharges;
	}
	
	public String getSQL(){
		return fileLogBkg.getSQL().replace("'AAA'", chg_lst);
	}
	
	public HashMap<String,String[]> getParams() {
		return fileLogBkg.getParams();
	}
}