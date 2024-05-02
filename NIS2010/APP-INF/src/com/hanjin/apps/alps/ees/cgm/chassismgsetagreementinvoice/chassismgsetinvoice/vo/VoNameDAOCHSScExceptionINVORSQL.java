/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoNameDAOCHSScExceptionINVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOCHSScExceptionINVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis S/C Exception Inquiry 를 조회할 수 있는 Vo
	  * </pre>
	  */
	public VoNameDAOCHSScExceptionINVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo").append("\n"); 
		query.append("FileName : VoNameDAOCHSScExceptionINVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' AS SC_NO," ).append("\n"); 
		query.append("'' AS SC_CUST_NO," ).append("\n"); 
		query.append("'' AS SC_CUST_NM," ).append("\n"); 
		query.append("'' AS SC_LOC_TCNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' AS SCC1," ).append("\n"); 
		query.append("'' AS SCC2," ).append("\n"); 
		query.append("'' AS SCC3," ).append("\n"); 
		query.append("'' AS SCC4," ).append("\n"); 
		query.append("'' AS SCC5," ).append("\n"); 
		query.append("'' AS SCC6," ).append("\n"); 
		query.append("'' AS SCC7," ).append("\n"); 
		query.append("'' AS SCC8," ).append("\n"); 
		query.append("'' AS SCC9," ).append("\n"); 
		query.append("'' AS SCC10," ).append("\n"); 
		query.append("'' AS SCC11," ).append("\n"); 
		query.append("'' AS SCC12," ).append("\n"); 
		query.append("'' AS SCC13," ).append("\n"); 
		query.append("'' AS SCC14," ).append("\n"); 
		query.append("'' AS SCC15," ).append("\n"); 
		query.append("'' AS SCC16," ).append("\n"); 
		query.append("'' AS SCC17," ).append("\n"); 
		query.append("'' AS SCC18," ).append("\n"); 
		query.append("'' AS SCC19," ).append("\n"); 
		query.append("'' AS SCC20," ).append("\n"); 
		query.append("'' AS SCC21," ).append("\n"); 
		query.append("'' AS SCC22," ).append("\n"); 
		query.append("'' AS SCC23," ).append("\n"); 
		query.append("'' AS SCC24," ).append("\n"); 
		query.append("'' AS SCC25," ).append("\n"); 
		query.append("'' AS SCC26," ).append("\n"); 
		query.append("'' AS SCC27," ).append("\n"); 
		query.append("'' AS SCC28," ).append("\n"); 
		query.append("'' AS SCC29," ).append("\n"); 
		query.append("'' AS SCC30," ).append("\n"); 
		query.append("'' AS SCC31," ).append("\n"); 
		query.append("'' AS SCC32," ).append("\n"); 
		query.append("'' AS SCC33," ).append("\n"); 
		query.append("'' AS SCC34," ).append("\n"); 
		query.append("'' AS SCC35," ).append("\n"); 
		query.append("'' AS SCC36," ).append("\n"); 
		query.append("'' AS SCC37," ).append("\n"); 
		query.append("'' AS SCC38," ).append("\n"); 
		query.append("'' AS SCC39," ).append("\n"); 
		query.append("'' AS SCC40," ).append("\n"); 
		query.append("'' AS SCC41," ).append("\n"); 
		query.append("'' AS SCC42," ).append("\n"); 
		query.append("'' AS SCC43," ).append("\n"); 
		query.append("'' AS SCC44," ).append("\n"); 
		query.append("'' AS SCC45," ).append("\n"); 
		query.append("'' AS SCC46," ).append("\n"); 
		query.append("'' AS SCC47," ).append("\n"); 
		query.append("'' AS SCC48," ).append("\n"); 
		query.append("'' AS SCC49," ).append("\n"); 
		query.append("'' AS SCC50," ).append("\n"); 
		query.append("'' AS SCC51," ).append("\n"); 
		query.append("'' AS SCC52," ).append("\n"); 
		query.append("'' AS SCC53," ).append("\n"); 
		query.append("'' AS SCC54," ).append("\n"); 
		query.append("'' AS SCC55," ).append("\n"); 
		query.append("'' AS SCC56," ).append("\n"); 
		query.append("'' AS SCC57," ).append("\n"); 
		query.append("'' AS SCC58," ).append("\n"); 
		query.append("'' AS SCC59," ).append("\n"); 
		query.append("'' AS SCC60,        " ).append("\n"); 
		query.append("'' AS SCC61, " ).append("\n"); 
		query.append("'' AS SCC62,      " ).append("\n"); 
		query.append("'' AS SCC63," ).append("\n"); 
		query.append("'' AS SCC64," ).append("\n"); 
		query.append("'' AS SCC65," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' AS SC_FM_DT," ).append("\n"); 
		query.append("'' AS SC_TO_DT," ).append("\n"); 
		query.append("'' AS LOC_CD," ).append("\n"); 
		query.append("'' AS SC_NO,  " ).append("\n"); 
		query.append("'' AS SC_SORT_TP," ).append("\n"); 
		query.append("'' AS SCC_SORT_TP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}