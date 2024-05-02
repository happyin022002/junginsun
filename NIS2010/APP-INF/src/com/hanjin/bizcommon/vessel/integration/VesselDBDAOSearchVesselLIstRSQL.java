/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselDBDAOSearchVesselLIstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.vessel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselDBDAOSearchVesselLIstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel list select
	  * </pre>
	  */
	public VesselDBDAOSearchVesselLIstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.vessel.integration").append("\n"); 
		query.append("FileName : VesselDBDAOSearchVesselLIstRSQL").append("\n"); 
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
		query.append("SELECT 	VSL_CD, " ).append("\n"); 
		query.append("		VSL_ENG_NM," ).append("\n"); 
		query.append("		CRR_CD," ).append("\n"); 
		query.append("    	VSL_NRT," ).append("\n"); 
		query.append("		RGST_PORT_CD," ).append("\n"); 
		query.append("		CALL_SGN_NO," ).append("\n"); 
		query.append("		LLOYD_NO," ).append("\n"); 
		query.append("		VSL_LNCH_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT 	ROW_NUMBER() OVER (ORDER BY VSL_CD ASC) NO," ).append("\n"); 
		query.append("			VSL_CD," ).append("\n"); 
		query.append("			VSL_ENG_NM," ).append("\n"); 
		query.append("			CRR_CD," ).append("\n"); 
		query.append("			NET_RGST_TONG_WGT VSL_NRT," ).append("\n"); 
		query.append("			RGST_PORT_CD," ).append("\n"); 
		query.append("			CALL_SGN_NO," ).append("\n"); 
		query.append("			LLOYD_NO," ).append("\n"); 
		query.append("			ROUND((SYSDATE - VSL_LNCH_DT)/ 365) VSL_LNCH_DT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("           	AND VSL_CD LIKE @[vsl_cd] || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '')" ).append("\n"); 
		query.append("           	AND VSL_ENG_NM LIKE @[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("           	AND CRR_CD LIKE @[crr_cd] || '%'" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${call_sgn_no} != '')" ).append("\n"); 
		query.append("			AND call_sgn_no = @[call_sgn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lloyd_no} != '')" ).append("\n"); 
		query.append("			AND lloyd_no = @[lloyd_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}