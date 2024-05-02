/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationDBDAOClockStopVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOClockStopVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge에 적용된 Clock Stop 관련 정보를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOClockStopVORSQL(){
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
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOClockStopVORSQL").append("\n"); 
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
		query.append("SELECT	C.CLK_STOP_NO," ).append("\n"); 
		query.append("		TO_CHAR(S.CLK_STOP_FM_DT, 'YYYYMMDD') CLK_STOP_FM_DT," ).append("\n"); 
		query.append("		TO_CHAR(S.CLK_STOP_TO_DT, 'YYYYMMDD') CLK_STOP_TO_DT," ).append("\n"); 
		query.append("		ROUND(S.CLK_STOP_TO_DT - S.CLK_STOP_FM_DT, 0) STOP_DAY," ).append("\n"); 
		query.append("		REPLACE(REPLACE(S.CLK_STOP_RMK, CHR(34), ''), CHR(13)||CHR(10), ' ') CLK_STOP_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_TM_CLK_STOP   C," ).append("\n"); 
		query.append("		DMT_TM_CLK_STOP       S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	C.CLK_STOP_NO		= S.CLK_STOP_NO" ).append("\n"); 
		query.append("AND     C.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		C.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		C.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND		S.CXL_FLG     		= 'N'" ).append("\n"); 

	}
}