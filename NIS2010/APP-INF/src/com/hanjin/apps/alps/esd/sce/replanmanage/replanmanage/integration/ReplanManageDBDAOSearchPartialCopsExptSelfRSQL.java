/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOSearchPartialCopsExptSelfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchPartialCopsExptSelfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container no 를 대상으로 partial 관계로 엮인 COP 들중 자기 자신을 제외한 나머지 또는 자기 자신만을 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchPartialCopsExptSelfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchPartialCopsExptSelfRSQL").append("\n"); 
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
		query.append("COP_UPD_RMK," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("COP_STS_CD," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("DECODE(COP_STS_CD, 'X', 'N/A', MST_COP_NO) AS MST_COP_NO," ).append("\n"); 
		query.append("TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("POL_NOD_CD," ).append("\n"); 
		query.append("POD_NOD_CD," ).append("\n"); 
		query.append("DEL_NOD_CD," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("IB_TRO_FLG," ).append("\n"); 
		query.append("OB_TRO_FLG," ).append("\n"); 
		query.append("RAIL_RCV_COFF_DT_SRC_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("COP_SUB_STS_CD," ).append("\n"); 
		query.append("UMCH_STS_CD," ).append("\n"); 
		query.append("PROV_CNTR_NO," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${self_expt_flg} == 'Y')" ).append("\n"); 
		query.append("AND (CNTR_NO, BKG_NO) <> ((@[cntr_no], @[bkg_no]))" ).append("\n"); 
		query.append("#elseif (${self_expt_flg} == 'N')" ).append("\n"); 
		query.append("AND (CNTR_NO, BKG_NO) = ((@[cntr_no], @[bkg_no]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_NO, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD FROM SCE_COP_HDR WHERE (CNTR_NO, BKG_NO) = ((@[cntr_no], @[bkg_no]))" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'X')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C' or ${sts_flg} == 'X')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("AND COP_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("AND COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}