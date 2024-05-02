/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementCheckVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementCheckVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD validation check한다.
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementCheckVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementCheckVVDRSQL").append("\n"); 
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
		query.append("SELECT A.ACCT_YRMON" ).append("\n"); 
		query.append("     , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A.JO_MNU_NM" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(MIN(X.VPS_ETA_DT),'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND X.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND X.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(X.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/) AS ST_DT" ).append("\n"); 
		query.append("     , NVL((SELECT TO_CHAR(MIN(VPS_ETA_DT) ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND VSK.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND VSK.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VSK.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND NVL(VSK.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("               AND VSK.TURN_PORT_IND_CD IN ('D','V','F')" ).append("\n"); 
		query.append("               AND NVL(VSK.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/)" ).append("\n"); 
		query.append("          ,(SELECT TO_CHAR(MAX(VPS_ETA_DT) ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND VSK.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND VSK.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VSK.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND NVL(VSK.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("               AND VSK.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("               AND NVL(VSK.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/)) AS END_DT" ).append("\n"); 
		query.append("  FROM JOO_STL_VVD A" ).append("\n"); 
		query.append(" WHERE A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("   #if (${jo_stl_itm_cd} != 'OUS')" ).append("\n"); 
		query.append("       AND A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.REV_DIR_CD = @[rev_dir_cd]" ).append("\n"); 

	}
}