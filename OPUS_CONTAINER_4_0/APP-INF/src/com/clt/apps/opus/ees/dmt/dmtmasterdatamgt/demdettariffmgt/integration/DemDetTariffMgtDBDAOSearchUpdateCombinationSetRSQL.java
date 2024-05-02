/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchUpdateCombinationSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchUpdateCombinationSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update 된 상태의 CombinationSet
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchUpdateCombinationSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchUpdateCombinationSetRSQL").append("\n"); 
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
		query.append("SELECT DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append(",DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",DMDT_CGO_TP_NM" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_SEQ1" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_SEQ2" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(", B.INTG_CD_VAL_DP_DESC AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append(", DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(", C.INTG_CD_VAL_DP_DESC AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append(", B.INTG_CD_VAL_DP_SEQ AS INTG_CD_VAL_DP_SEQ1" ).append("\n"); 
		query.append(", C.INTG_CD_VAL_DP_SEQ AS INTG_CD_VAL_DP_SEQ2" ).append("\n"); 
		query.append("FROM DMT_CMB_SET A, COM_INTG_CD_DTL B, COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE B.INTG_CD_VAL_CTNT 	= A.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT 		= A.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND B.INTG_CD_ID 			= 'CD02053'" ).append("\n"); 
		query.append("AND C.INTG_CD_ID 			= 'CD01963'" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(", B.INTG_CD_VAL_DP_DESC AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append(", DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(", C.INTG_CD_VAL_DP_DESC AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append(", B.INTG_CD_VAL_DP_SEQ AS INTG_CD_VAL_DP_SEQ1" ).append("\n"); 
		query.append(", C.INTG_CD_VAL_DP_SEQ AS INTG_CD_VAL_DP_SEQ2" ).append("\n"); 
		query.append("FROM DMT_TRF_CMB A, COM_INTG_CD_DTL B, COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE B.INTG_CD_VAL_CTNT 	= A.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT 		= A.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND B.INTG_CD_ID 			= 'CD02053'" ).append("\n"); 
		query.append("AND C.INTG_CD_ID 			= 'CD01963'" ).append("\n"); 
		query.append("AND SYS_AREA_GRP_ID 		= @[svr_id]" ).append("\n"); 
		query.append("AND DMDT_TRF_CD 			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND TRF_SEQ 				= @[trf_seq]" ).append("\n"); 
		query.append("AND TRF_GRP_SEQ 			= @[trf_grp_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ1, INTG_CD_VAL_DP_SEQ2" ).append("\n"); 

	}
}