/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffFreeTimeRSQL.java
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

public class DemDetTariffMgtDBDAOSearchBasicTariffFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Creation
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffFreeTimeRSQL(){
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
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffFreeTimeRSQL").append("\n"); 
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
		query.append("    	, DMDT_TRF_CD" ).append("\n"); 
		query.append("    	, TRF_SEQ" ).append("\n"); 
		query.append("        , DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM    COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("          WHERE   S.INTG_CD_ID        = 'CD03257'" ).append("\n"); 
		query.append("          AND     S.INTG_CD_VAL_CTNT  = DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("          ) AS DMDT_DE_TERM_NM" ).append("\n"); 
		query.append("    	, TRF_GRP_SEQ" ).append("\n"); 
		query.append("    	, TRF_FT_SEQ" ).append("\n"); 
		query.append("    	, FT_FM_QTY" ).append("\n"); 
		query.append("    	, FT_TO_QTY" ).append("\n"); 
		query.append("    	, FT_DYS" ).append("\n"); 
		query.append("    	, CRE_USR_ID" ).append("\n"); 
		query.append("    	, CRE_DT" ).append("\n"); 
		query.append("    	, CRE_OFC_CD" ).append("\n"); 
		query.append("    	, UPD_USR_ID" ).append("\n"); 
		query.append("    	, UPD_DT" ).append("\n"); 
		query.append("    	, UPD_OFC_CD" ).append("\n"); 
		query.append("    	, '' AS USR_ID" ).append("\n"); 
		query.append("    	, '' AS OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_TRF_FREE_TM" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     TRF_SEQ             = @[trf_seq]" ).append("\n"); 
		query.append("AND     DMDT_DE_TERM_CD     = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("AND     TRF_GRP_SEQ         = @[trf_grp_seq]" ).append("\n"); 

	}
}