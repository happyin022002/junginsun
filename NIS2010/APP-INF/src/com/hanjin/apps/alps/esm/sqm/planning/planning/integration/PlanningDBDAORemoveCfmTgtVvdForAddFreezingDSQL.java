/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanningDBDAORemoveCfmTgtVvdForAddFreezingDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAORemoveCfmTgtVvdForAddFreezingDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [SQM_CFM_TGT_VVD] 데이터를 삭제한다.
	  * 
	  * * 2014.07.25 이혜민  QTA Set up by HO for IAS Sector_Add Freezing 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * </pre>
	  */
	public PlanningDBDAORemoveCfmTgtVvdForAddFreezingDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAORemoveCfmTgtVvdForAddFreezingDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM SQM_CFM_TGT_VVD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 
		query.append("   AND (BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD ) " ).append("\n"); 
		query.append("    IN (" ).append("\n"); 
		query.append("        SELECT BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM SQM_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("           AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("           AND PF_GRP_CD  = @[pf_grp_cd]" ).append("\n"); 
		query.append("           AND DIR_CD     = NVL(@[dir_cd], DIR_CD)" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}