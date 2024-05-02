/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAORsltPriCmpbGlineServiceLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.04 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAORsltPriCmpbGlineServiceLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMPBGuidelineDBDAORsltPriCmpbGlineServiceLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAORsltPriCmpbGlineServiceLaneVORSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("A1.VSL_SLAN_CD" ).append("\n"); 
		query.append(",       B1.VSL_SLAN_NM" ).append("\n"); 
		query.append(",       A1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append(", 		@[cre_ofc_cd] AS CRE_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gline_seq} != '')" ).append("\n"); 
		query.append(",		@[gline_seq] AS GLINE_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prs_cust_tp_cd} != '')" ).append("\n"); 
		query.append(",		@[prs_cust_tp_cd] AS PRS_CUST_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bse_seq} != '')" ).append("\n"); 
		query.append(",		@[bse_seq] AS BSE_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM    MDM_SVC_SCP_LANE A1" ).append("\n"); 
		query.append(",       MDM_VSL_SVC_LANE B1" ).append("\n"); 
		query.append("WHERE   A1.VSL_SLAN_CD = B1.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("ORDER BY A1.VSL_SLAN_CD, B1.VSL_SLAN_NM" ).append("\n"); 

	}
}