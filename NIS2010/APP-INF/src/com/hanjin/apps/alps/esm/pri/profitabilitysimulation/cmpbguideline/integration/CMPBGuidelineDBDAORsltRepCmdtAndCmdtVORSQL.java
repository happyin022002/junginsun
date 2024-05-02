/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMPBGuidelineDBDAORsltRepCmdtAndCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.02.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAORsltRepCmdtAndCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vertical Excel
	  * </pre>
	  */
	public CMPBGuidelineDBDAORsltRepCmdtAndCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAORsltRepCmdtAndCmdtVORSQL").append("\n"); 
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
		query.append(" " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	CMDT_CD," ).append("\n"); 
		query.append("	CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CMDT_CD = @[prc_cmdt_def_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	REP_CMDT_CD" ).append("\n"); 
		query.append(",	REP_CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND REP_CMDT_CD = @[prc_cmdt_def_cd]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}