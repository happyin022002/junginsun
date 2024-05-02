/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchTariffCombinationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.09.27 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchTariffCombinationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTariffCombination - Grid1
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchTariffCombinationRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchTariffCombinationRSQL").append("\n"); 
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
		query.append("SELECT  SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("        , DMDT_TRF_CD" ).append("\n"); 
		query.append("        , TRF_SEQ" ).append("\n"); 
		query.append("        , A.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM    COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("          WHERE   S.INTG_CD_ID        = 'CD03257'" ).append("\n"); 
		query.append("          AND     S.INTG_CD_VAL_CTNT  = A.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          )                            AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("        , TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("        , B.INTG_CD_VAL_DP_DESC        AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("        , DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("        , C.INTG_CD_VAL_DP_DESC        AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("        , A.CRE_USR_ID" ).append("\n"); 
		query.append("        , A.CRE_DT" ).append("\n"); 
		query.append("        , A.CRE_OFC_CD" ).append("\n"); 
		query.append("        , A.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT" ).append("\n"); 
		query.append("        , A.UPD_OFC_CD" ).append("\n"); 
		query.append("        , '' AS USR_ID" ).append("\n"); 
		query.append("        , '' AS OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_TRF_CMB     A," ).append("\n"); 
		query.append("        COM_INTG_CD_DTL B," ).append("\n"); 
		query.append("        COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE   B.INTG_CD_VAL_CTNT  = A.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND     C.INTG_CD_VAL_CTNT  = A.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND     B.INTG_CD_ID        = 'CD02053'" ).append("\n"); 
		query.append("AND     C.INTG_CD_ID        = 'CD01963'" ).append("\n"); 
		query.append("AND     SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     TRF_SEQ             = @[trf_seq]" ).append("\n"); 
		query.append("AND     DMDT_DE_TERM_CD     = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("AND     TRF_GRP_SEQ         = @[trf_grp_seq]" ).append("\n"); 
		query.append("ORDER BY B.INTG_CD_VAL_DP_SEQ, C.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}