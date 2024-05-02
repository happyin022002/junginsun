/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : HolidayMgtDBDAOSb45RulingExceptionsDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.03.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOSb45RulingExceptionsDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Location, Yard, Bound 별로 등록된 SB45 Ruling Exceptions 정보 조회용 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOSb45RulingExceptionsDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exclu_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_det_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOSb45RulingExceptionsDupCheckRSQL").append("\n"); 
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
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,YD_CD" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,DEM_DET_TP_CD" ).append("\n"); 
		query.append("      ,EXCLU_SEQ" ).append("\n"); 
		query.append("      ,XCLD_SAT_FLG" ).append("\n"); 
		query.append("      ,XCLD_SUN_FLG" ).append("\n"); 
		query.append("      ,XCLD_HOL_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,EDW_UPD_DT " ).append("\n"); 
		query.append("  FROM DMT_OVR_DY_EXCLU" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("   AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("#if(${yd_cd} != '')" ).append("\n"); 
		query.append("   AND YD_CD LIKE @[yd_cd] || '%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND YD_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bnd_cd} == 'A')" ).append("\n"); 
		query.append("   AND IO_BND_CD IN (@[io_bnd_cd], 'I', 'O')" ).append("\n"); 
		query.append("	#if(${dem_det_tp_cd} != '' && ${dem_det_tp_cd} != 'A')" ).append("\n"); 
		query.append("	    AND DEM_DET_TP_CD IN (@[dem_det_tp_cd], 'A')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    AND DEM_DET_TP_CD IN (@[dem_det_tp_cd], 'M', 'T')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND IO_BND_CD IN (@[io_bnd_cd], 'A')" ).append("\n"); 
		query.append("	#if(${dem_det_tp_cd} != '' && ${dem_det_tp_cd} != 'A')" ).append("\n"); 
		query.append("	    AND DEM_DET_TP_CD IN (@[dem_det_tp_cd], 'A')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    AND DEM_DET_TP_CD IN (@[dem_det_tp_cd], 'M', 'T')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${exclu_seq} !='')" ).append("\n"); 
		query.append("   AND EXCLU_SEQ <> @[exclu_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT + .0 AND NVL(EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) + 0.99999" ).append("\n"); 
		query.append("        OR " ).append("\n"); 
		query.append("        EFF_DT + .0 BETWEEN TO_DATE(@[eff_dt], 'YYYYMMDD') + .0 AND NVL(TO_DATE(@[exp_dt], 'YYYYMMDD'), TO_DATE('99991231', 'YYYYMMDD')) + 0.99999" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}