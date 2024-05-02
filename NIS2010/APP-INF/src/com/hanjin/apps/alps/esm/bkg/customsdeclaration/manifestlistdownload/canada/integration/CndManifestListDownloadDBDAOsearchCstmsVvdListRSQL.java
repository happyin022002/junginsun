/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCstmsVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.11.16 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCstmsVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsVvdList
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCstmsVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCstmsVvdListRSQL").append("\n"); 
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
		query.append("SELECT  A.SLAN_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("       ,B.CRR_CD" ).append("\n"); 
		query.append("       ,D.VPS_PORT_CD AS POL_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(D.VPS_ETB_DT,'YYYYMMDDHH24MISS') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	   ,TO_CHAR((D.VPS_ETB_DT + 1/24),'YYYYMMDDHH24MISS') AS CRN_WRK_CMNC_DT" ).append("\n"); 
		query.append("       ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,C.CVY_REF_NO" ).append("\n"); 
		query.append("  FROM  VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("       ,MDM_VSL_CNTR B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_CND_VSL C" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND  D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND  D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  D.CLPT_SEQ < A.CLPT_SEQ" ).append("\n"); 
		query.append("   AND  D.VPS_PORT_CD NOT LIKE 'US%'" ).append("\n"); 
		query.append("   AND  D.VPS_PORT_CD NOT LIKE 'CA%'" ).append("\n"); 
		query.append("   AND  (A.VPS_PORT_CD LIKE 'CA%' " ).append("\n"); 
		query.append("        OR C.VSL_CD IS NOT NULL)" ).append("\n"); 
		query.append("#if (${cvy_ref_no} != '') " ).append("\n"); 
		query.append("   and  c.cvy_ref_no like @[cvy_ref_no] || '%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("	   AND  A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD LIKE @[vvd_cd] || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${s_vps_eta_dt} != '') " ).append("\n"); 
		query.append("		   AND  A.VPS_ETA_DT BETWEEN TO_DATE(REPLACE(@[s_vps_eta_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[e_vps_eta_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("	AND  A.VPS_PORT_CD LIKE @[vps_port_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("   AND  A.SLAN_CD LIKE @[slan_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("   AND  B.CRR_CD LIKE @[crr_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND  D.VPS_PORT_CD like @[pol_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY D.VPS_ETB_DT,A.VPS_ETB_DT, A.VSL_CD" ).append("\n"); 

	}
}