/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdjustmentDBDAOSearchKpiCreationEditNewOfcHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchKpiCreationEditNewOfcHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKpiCreationEditNewOfcHis
	  * </pre>
	  */
	public AdjustmentDBDAOSearchKpiCreationEditNewOfcHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchKpiCreationEditNewOfcHisRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.SRC_RHQ_CD" ).append("\n"); 
		query.append("      ,A1.SRC_RGN_OFC_CD" ).append("\n"); 
		query.append("      ,NVL2(A2.RGN_OFC_CD,'Y','N') QTA_FLAG" ).append("\n"); 
		query.append("  FROM SQM_SPCL_NEW_OFC A1" ).append("\n"); 
		query.append("      ,SQM_SPCL_CFM_QTA A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.SPCL_TGT_CD = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("ORDER BY QTA_FLAG DESC, TRD_CD, DIR_CD, RLANE_CD, RHQ_CD, RGN_OFC_CD, SRC_RHQ_CD, SRC_RGN_OFC_CD" ).append("\n"); 

	}
}