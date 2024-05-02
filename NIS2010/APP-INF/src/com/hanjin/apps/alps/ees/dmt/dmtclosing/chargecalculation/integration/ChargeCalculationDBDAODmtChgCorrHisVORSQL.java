/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgCorrHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgCorrHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgCorrHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgCorrHisVORSQL").append("\n"); 
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
		query.append("SELECT	CORR_HIS_SEQ" ).append("\n"); 
		query.append("	,(	SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD01967'" ).append("\n"); 
		query.append("		AND	INTG_CD_VAL_CTNT = CHG_STS_CD" ).append("\n"); 
		query.append("	) CHG_STS_CD" ).append("\n"); 
		query.append("	,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_CHAR(FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("	,FM_YD_CD" ).append("\n"); 
		query.append("	,TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_CHAR(TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("	,TO_YD_CD" ).append("\n"); 
		query.append("	,CORR_HIS_RMK" ).append("\n"); 
		query.append("	,TO_CHAR(CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	,(	SELECT	USR_NM" ).append("\n"); 
		query.append("		FROM	COM_USER" ).append("\n"); 
		query.append("		WHERE	USR_ID = DCCH.CRE_USR_ID" ).append("\n"); 
		query.append("	) AS CRE_NM" ).append("\n"); 
		query.append("	,DCCH.CRE_USR_ID AS CRE_ID" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,TO_CHAR(WEB_MTY_DT, 'YYYYMMDD') WEB_MTY_DT" ).append("\n"); 
		query.append("	,WEB_NTFY_PIC_NM AS WEB_MTY_NM" ).append("\n"); 
		query.append("	,DCCH.WEB_CRE_USR_ID AS WEB_MTY_ID" ).append("\n"); 
		query.append("    ,NVL(DCCH.UCLM_FLG, 'N') AS UCLM_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' SVR_ID" ).append("\n"); 
		query.append("	,'' CNTR_NO" ).append("\n"); 
		query.append("	,'' CNTR_CYC_NO" ).append("\n"); 
		query.append("	,'' DMDT_TRF_CD" ).append("\n"); 
		query.append("	,'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,'' CHG_SEQ" ).append("\n"); 
		query.append("	,'' BKG_NO" ).append("\n"); 
		query.append("	,'' WEB_CRE_USR_ID" ).append("\n"); 
		query.append("	,'' WEB_CRE_DT" ).append("\n"); 
		query.append("	,'' CRE_USR_ID" ).append("\n"); 
		query.append("	,'' UPD_USR_ID" ).append("\n"); 
		query.append("	,'' UPD_DT" ).append("\n"); 
		query.append("	,'' UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_CORR_HIS DCCH" ).append("\n"); 
		query.append("WHERE	CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     DMDT_CHG_LOC_DIV_CD	= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("ORDER BY CORR_HIS_SEQ DESC" ).append("\n"); 

	}
}