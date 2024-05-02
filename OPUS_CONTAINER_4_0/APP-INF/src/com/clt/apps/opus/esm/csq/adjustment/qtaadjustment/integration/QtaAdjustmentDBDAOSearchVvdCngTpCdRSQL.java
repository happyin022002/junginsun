/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.CSQ_CNG_TP_CD||'|'||A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM CSQ_CFM_QTA A1, COA_MON_VVD A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = 'Q'" ).append("\n"); 
		query.append("AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("AND A1.QTA_RLSE_VER_NO LIKE '%02'" ).append("\n"); 
		query.append("AND A1.CSQ_CNG_TP_CD <> 'I'" ).append("\n"); 
		query.append("AND A2.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("AND A2.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND A1.BSE_YR      = SUBSTR(A2.COST_YRMON,0,4)" ).append("\n"); 
		query.append("AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.VSL_CD      = A2.VSL_CD" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO  = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD  = A2.DIR_CD" ).append("\n"); 
		query.append("ORDER BY VVD" ).append("\n"); 

	}
}