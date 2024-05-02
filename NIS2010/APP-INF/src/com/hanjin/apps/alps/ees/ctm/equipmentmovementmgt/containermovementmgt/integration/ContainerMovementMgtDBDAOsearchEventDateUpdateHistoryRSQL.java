/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchEventDateUpdateHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 강환
*@LastVersion : 1.0
* 2013.03.15 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchEventDateUpdateHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEventDateUpdateHistory
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchEventDateUpdateHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd_disp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchEventDateUpdateHistoryRSQL").append("\n"); 
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
		query.append("SELECT   CMH.CNTR_NO" ).append("\n"); 
		query.append("        ,CMH.CNMV_YR" ).append("\n"); 
		query.append("        ,CMH.CNMV_ID_NO" ).append("\n"); 
		query.append("        ,CMH.CNMV_UPD_HIS_SEQ" ).append("\n"); 
		query.append("        ,CMH.CNTR_TPSZ_CD AS TP_SZ" ).append("\n"); 
		query.append("        ,CMH.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("        ,CMH.CRNT_VSL_CD||CMH.CRNT_SKD_VOY_NO||CMH.CRNT_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        ,CMH.MVMT_STS_CD AS STS" ).append("\n"); 
		query.append("        ,CMH.ORG_YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(CMH.PRE_CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS PRE_CNMV_EVNT_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(CMH.CRNT_CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CRNT_CNMV_EVNT_DT" ).append("\n"); 
		query.append("--        ,ROUND(CMH.CRNT_CNMV_EVNT_DT-CMH.PRE_CNMV_EVNT_DT, 0) AS GAP" ).append("\n"); 
		query.append("		,ROUND( TO_DATE(TO_CHAR(CMH.CRNT_CNMV_EVNT_DT, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(CMH.PRE_CNMV_EVNT_DT , 'YYYYMMDD'), 'YYYYMMDD'), 0) AS GAP" ).append("\n"); 
		query.append("        ,TO_CHAR(CMH.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(CMH.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT" ).append("\n"); 
		query.append("        ,CMH.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("        ,DECODE(CMH.FCNTR_FLG, 'Y', 'F', 'N', 'M') FCNTR_FLG" ).append("\n"); 
		query.append("        ,CMH.OFC_CD" ).append("\n"); 
		query.append("        ,CU.USR_NM" ).append("\n"); 
		query.append("        ,CMH.CNMV_RMK" ).append("\n"); 
		query.append("FROM    CTM_MVMT_EVNT_DT_HIS    CMH" ).append("\n"); 
		query.append("        ,COM_USER               CU" ).append("\n"); 
		query.append("#if (${pe_co} == 'P')" ).append("\n"); 
		query.append("        ,MST_CONTAINER          MC" ).append("\n"); 
		query.append("        ,MDM_EQ_ORZ_CHT         ME" ).append("\n"); 
		query.append("        ,MDM_LOCATION           ML" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pe_co} == 'C')" ).append("\n"); 
		query.append("WHERE   CMH.CNTR_NO         =   @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pe_co} == 'P')" ).append("\n"); 
		query.append("WHERE   CMH.CRE_LOCL_DT BETWEEN TO_DATE(@[p_date1], 'YYYY-MM-DD') AND TO_DATE(@[p_date2], 'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_gb} == 'L' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     ME.LCC_CD           =   @[yd_cd_disp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_gb} == 'E' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     ME.ECC_CD           =   @[yd_cd_disp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_gb} == 'S' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     ME.SCC_CD           =   @[yd_cd_disp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_gb} == 'R' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     ME.RCC_CD           =   @[yd_cd_disp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     ML.SCC_CD           =   ME.SCC_CD" ).append("\n"); 
		query.append("AND     SUBSTR(CMH.ORG_YD_CD, 1, 5) = ML.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_gb} == 'Y' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     CMH.ORG_YD_CD       =   @[yd_cd_disp]||@[p_yard2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status_cd} != '' && ${pe_co} == 'P') " ).append("\n"); 
		query.append("	AND CMH.MVMT_STS_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_statusCds IN ${statusCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $statusCds.size())" ).append("\n"); 
		query.append("				'$user_statusCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_statusCds'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     CMH.CNTR_NO         =   MC.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc_cd} == 'SH' && ${pe_co} == 'P')" ).append("\n"); 
		query.append("AND     MC.LSTM_CD          <>  @[soc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     CMH.CRE_USR_ID      =   CU.USR_ID" ).append("\n"); 
		query.append("ORDER   BY CMH.CNTR_NO" ).append("\n"); 
		query.append("        ,CMH.CNMV_YR" ).append("\n"); 
		query.append("        ,CMH.CNMV_ID_NO" ).append("\n"); 
		query.append("        ,CMH.CNMV_UPD_HIS_SEQ" ).append("\n"); 

	}
}