/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSimulationDBDAOSearchAGNCommMassSimListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOSearchAGNCommMassSimListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상 Booking 개수를 구한다.
	  * </pre>
	  */
	public ACMSimulationDBDAOSearchAGNCommMassSimListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOSearchAGNCommMassSimListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(MAX(A.BKG_NO)) AS TTL_BKG" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       COA_RGST_BKG R," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID <> 'COST'" ).append("\n"); 
		query.append("   AND C.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("   AND C.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("/* 날짜 조회 기준에 따른 조회 */	" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("   #if (${date_div} == 'BC')" ).append("\n"); 
		query.append("   AND C.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'SA')" ).append("\n"); 
		query.append("   AND TO_DATE(A.SAIL_ARR_DT,'YYYY-MM-DD')  BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'RQ')" ).append("\n"); 
		query.append("   AND A.RQST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'AU')" ).append("\n"); 
		query.append("   AND A.AUD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'AP')" ).append("\n"); 
		query.append("   AND A.APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'IF')" ).append("\n"); 
		query.append("   AND A.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'RJ')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ('RR','AR')" ).append("\n"); 
		query.append("   AND A.UPD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   #if (${vvd_div} == 'CV') -- C.VVD" ).append("\n"); 
		query.append("   AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${vvd_div} == 'RV') -- R.VVD" ).append("\n"); 
		query.append("   AND R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD||R.REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Commission Account 작업중 */" ).append("\n"); 
		query.append("#if (${ac_tp_cd} != '')" ).append("\n"); 
		query.append("   AND A.AC_TP_CD IN (${ac_tp_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Agreement Condition */" ).append("\n"); 
		query.append("#if (${agmt_div} == 'A' && ${agmt_no1} != '') --Applied Agreement" ).append("\n"); 
		query.append("       AND A.AGN_AGMT_NO IN (${agmt_no1})    --## ${}로 받음" ).append("\n"); 
		query.append("#elseif (${agmt_div} == 'S' && ${agmt_no2} != '') -- AS Agreement should have been applied" ).append("\n"); 
		query.append("    -- 현재 작업중 추후 적용" ).append("\n"); 
		query.append("       AND A.AGN_AGMT_NO IN (${agmt_no2})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Commission Status */" ).append("\n"); 
		query.append("#if (${ac_sts_cd} != '')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN (${ac_sts_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ac_sts_cd2} == 'IS')" ).append("\n"); 
		query.append("   AND A.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Office  작업중 */" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   #if (${ofc_div} == 'A')" ).append("\n"); 
		query.append("   AND A.AGN_CD IN (${ofc_cd}) " ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'B')" ).append("\n"); 
		query.append("   AND C.BKG_OFC_CD IN (${ofc_cd}) " ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POR')" ).append("\n"); 
		query.append("   AND C.POR_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POL')" ).append("\n"); 
		query.append("   AND C.POL_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POD')" ).append("\n"); 
		query.append("   AND C.POD_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'DEL')" ).append("\n"); 
		query.append("   AND C.DEL_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Route (POR : POR, POL : POL, POD : POD, DEL : DEL, T/S Port : TSP) */" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   #if (${route_div} == 'POR')" ).append("\n"); 
		query.append("   AND C.POR_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'POL')" ).append("\n"); 
		query.append("   AND C.POL_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'POD')" ).append("\n"); 
		query.append("   AND C.POD_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'DEL')" ).append("\n"); 
		query.append("   AND C.DEL_CD IN (${loc_cd})   --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'TSP')" ).append("\n"); 
		query.append("   AND C.BKG_NO IN (SELECT BKG_NO FROM BKG_VVD V WHERE V.BKG_NO = C.BKG_NO AND V.POL_CD <> C.POL_CD AND V.POL_CD IN (${loc_cd}))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Bound */" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '' && ${io_bnd_cd} != 'A') -- Bound(ALL : A, IN : I, OUT : O) : 공통코드 CD02882" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = (@[io_bnd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY C.BL_NO," ).append("\n"); 
		query.append("          A.BKG_NO" ).append("\n"); 
		query.append("--          A.IO_BND_CD," ).append("\n"); 
		query.append("--          R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD," ).append("\n"); 
		query.append("--          A.AC_RLANE_CD," ).append("\n"); 
		query.append("--          A.SAIL_ARR_DT," ).append("\n"); 
		query.append("--          A.LOC_CD," ).append("\n"); 
		query.append("--          A.AC_SEQ," ).append("\n"); 
		query.append("--          C.BKG_STS_CD," ).append("\n"); 
		query.append("--          A.REV_DIV_CD," ).append("\n"); 
		query.append("--          A.CURR_CD," ).append("\n"); 
		query.append("--          A.AC_STS_CD," ).append("\n"); 
		query.append("--          A.CRE_DT," ).append("\n"); 
		query.append("--          A.BDR_FLG," ).append("\n"); 
		query.append("--          A.AC_PROC_DESC," ).append("\n"); 
		query.append("--          A.AR_OFC_CD," ).append("\n"); 
		query.append("--          A.AGN_CD" ).append("\n"); 

	}
}