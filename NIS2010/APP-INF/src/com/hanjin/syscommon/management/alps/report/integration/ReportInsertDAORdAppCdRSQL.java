/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportInsertDAORdAppCdRSQL.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-03
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-03 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yong-Hoo Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportInsertDAORdAppCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RdAppCd
	  * </pre>
	  */
	public ReportInsertDAORdAppCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_appl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.report.integration").append("\n"); 
		query.append("FileName : ReportInsertDAORdAppCdRSQL").append("\n"); 
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
		query.append("select rd_appl_cd from com_rpt_dsgn_snd_appl " ).append("\n"); 
		query.append("where rd_appl_cd like @[rd_appl_cd]" ).append("\n"); 
		query.append("and rownum < 2 " ).append("\n"); 
		query.append("order by rd_appl_cd desc" ).append("\n"); 

	}
}