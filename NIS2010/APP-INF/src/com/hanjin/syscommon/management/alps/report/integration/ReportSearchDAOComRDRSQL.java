/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportSearchDAOComRDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : 김용후
*@LastVersion : 1.0
* 2013.05.03 김용후
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM.YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportSearchDAOComRDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모듈별 RD search하는 sql
	  * </pre>
	  */
	public ReportSearchDAOComRDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.report.integration").append("\n"); 
		query.append("FileName : ReportSearchDAOComRDRSQL").append("\n"); 
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
		query.append("select *from" ).append("\n"); 
		query.append("com_rpt_dsgn_snd_appl" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("rd_sub_sys_cd = @[rd_sub_sys_cd]" ).append("\n"); 
		query.append("order by RD_APPL_CD asc" ).append("\n"); 

	}
}