/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitManagmentDBDAOSearchPortLimitsClassRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortLimitManagmentDBDAOSearchPortLimitsClassRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관리 Port별 Port Limits Class 정보를 조회한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOSearchPortLimitsClassRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_lmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration").append("\n"); 
		query.append("FileName : PortLimitManagmentDBDAOSearchPortLimitsClassRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ_NO," ).append("\n"); 
		query.append("            IMDG_CLSS_CD," ).append("\n"); 
		query.append("            IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("   FROM (      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ROWNUM SEQ_NO," ).append("\n"); 
		query.append("	   A.IMDG_CLSS_CD," ).append("\n"); 
		query.append("       B.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PORT_LMT_CLSS_CD A, " ).append("\n"); 
		query.append("            SCG_IMDG_PORT_LMT_COMP_GRP B" ).append("\n"); 
		query.append("WHERE A.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("    --AND A.LMT_WGT_TP_CD = B.LMT_WGT_TP_CD(+)" ).append("\n"); 
		query.append("    AND A.PORT_LMT_SEQ = B.PORT_LMT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.IMDG_CLSS_CD = B.IMDG_CLSS_CD(+)" ).append("\n"); 
		query.append("	--AND A.PORT_LMT_CLSS_SEQ = B.PORT_LMT_CLSS_SEQ(+)" ).append("\n"); 
		query.append("    AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("    --AND A.LMT_WGT_TP_CD = lmt_wgt_tp_cd" ).append("\n"); 
		query.append("    AND A.PORT_LMT_SEQ = @[port_lmt_seq]" ).append("\n"); 
		query.append("    AND EXISTS (" ).append("\n"); 
		query.append("                        SELECT 1" ).append("\n"); 
		query.append("                          FROM SCG_IMDG_PORT_LMT_MST M" ).append("\n"); 
		query.append("                        WHERE M.PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("                            --AND M.LMT_WGT_TP_CD = A.LMT_WGT_TP_CD" ).append("\n"); 
		query.append("                            AND M.PORT_LMT_SEQ = A.PORT_LMT_SEQ" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("ORDER BY A.IMDG_CLSS_CD, B.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}