/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceLaneDBDAOMdmVslSvcLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.15 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceLaneDBDAOMdmVslSvcLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ServiceLaneDBDAOMdmVslSvcLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.integration").append("\n"); 
		query.append("FileName : ServiceLaneDBDAOMdmVslSvcLaneVORSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("     , VSL_SLAN_NM" ).append("\n"); 
		query.append("     , VSL_SVC_TP_CD" ).append("\n"); 
		query.append("     , VSL_TP_CD" ).append("\n"); 
		query.append("     , ST_EFF_DT" ).append("\n"); 
		query.append("     , END_EFF_DT" ).append("\n"); 
		query.append("     , VSL_SLAN_SKD_TP_CD" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , CO_CD" ).append("\n"); 
		query.append("     , FDR_DIV_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , EAI_EVNT_DT" ).append("\n"); 
		query.append("     , CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("     , VSKD_FLET_GRP_CD" ).append("\n"); 
		query.append("     , SPCL_CGO_RQST_TGT_LANE_FLG" ).append("\n"); 
		query.append("     , TML_PROD_RPT_FLG" ).append("\n"); 
		query.append("     , PNDLM_FLG" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND   VSL_SLAN_CD LIKE '%'||@[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_nm} != '')" ).append("\n"); 
		query.append("AND   UPPER(VSL_SLAN_NM) LIKE '%'||UPPER(@[vsl_slan_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}