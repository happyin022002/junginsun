/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOVesselVVDListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOVesselVVDListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOVesselVVDListVORSQL(){
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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOVesselVVDListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.PORT_SKP_TP_CD" ).append("\n"); 
		query.append(", A.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(", A.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(", A.TTL_DLAY_HRS" ).append("\n"); 
		query.append(", A.TS_PORT_CD" ).append("\n"); 
		query.append(", A.USD_FLG" ).append("\n"); 
		query.append(", A.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(", A.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(", A.ACT_INP_FLG" ).append("\n"); 
		query.append(", A.PRT_CHK_FLG" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT" ).append("\n"); 
		query.append(", A.SKD_AUTO_UPD_FLG" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.VPS_PORT_CD" ).append("\n"); 
		query.append(", A.CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.CLPT_SEQ" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.PORT_SKD_STS_CD" ).append("\n"); 
		query.append(", A.YD_CD" ).append("\n"); 
		query.append(", A.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(", A.PF_ETA_DT" ).append("\n"); 
		query.append(", A.PF_ETB_DT" ).append("\n"); 
		query.append(", A.PF_ETD_DT" ).append("\n"); 
		query.append(", A.INIT_ETA_DT" ).append("\n"); 
		query.append(", A.INIT_ETB_DT" ).append("\n"); 
		query.append(", A.INIT_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD') AS VPS_ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VPS_ETB_DT,'YYYY-MM-DD') AS VPS_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT" ).append("\n"); 
		query.append(", A.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(", A.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(", A.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append(", A.SHP_CALL_NO" ).append("\n"); 
		query.append(", A.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(", A.SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(", A.TML_VSL_CD" ).append("\n"); 
		query.append(", A.TML_VOY_NO" ).append("\n"); 
		query.append(", A.FT_DT" ).append("\n"); 
		query.append(", A.PLISM_YD_CD" ).append("\n"); 
		query.append(", A.PLISM_VSL_CD" ).append("\n"); 
		query.append(", A.PLISM_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(", A.TURN_PORT_FLG" ).append("\n"); 
		query.append(", A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(", A.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(", A.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(", A.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.IB_CGO_QTY" ).append("\n"); 
		query.append(", A.OB_CGO_QTY" ).append("\n"); 
		query.append(", A.VPS_RMK" ).append("\n"); 
		query.append(", A.PHS_IO_RSN_CD" ).append("\n"); 
		query.append(", A.PHS_IO_RMK" ).append("\n"); 
		query.append(", A.SKD_BRTH_NO" ).append("\n"); 
		query.append(", A.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(", A.OFC_INP_FLG" ).append("\n"); 
		query.append(", A.EDI_SND_KNT" ).append("\n"); 
		query.append(", A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(", B.VSL_ENG_NM" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(", MDM_VSL_CNTR     B" ).append("\n"); 
		query.append("WHERE   A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND     A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND	    A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND	    A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("AND	    A.VPS_PORT_CD LIKE @[vps_port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND	    A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '')" ).append("\n"); 
		query.append("AND     B.VSL_ENG_NM LIKE '%' || @[vsl_eng_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_eta_dt} == '0' && ${vps_etb_dt} != '')" ).append("\n"); 
		query.append("AND	    TO_CHAR(A.VPS_ETD_DT,'YYYY-MM-DD') between @[vps_etb_dt] and @[vps_etd_dt]" ).append("\n"); 
		query.append("#elseif (${vps_eta_dt} == '1' && ${vps_etb_dt} != '')" ).append("\n"); 
		query.append("AND	    TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD') between @[vps_etb_dt] and @[vps_etd_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("AND	    A.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}