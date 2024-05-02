/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgTmCskStopVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
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

public class ChargeCalculationDBDAODmtChgTmCskStopVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgTmCskStopVOCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgTmCskStopVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clk_stop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgTmCskStopVOCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_TM_CLK_STOP" ).append("\n"); 
		query.append("(	 SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_CYC_NO" ).append("\n"); 
		query.append("	,DMDT_TRF_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,CHG_SEQ" ).append("\n"); 
		query.append("	,CLK_STOP_NO" ).append("\n"); 
		query.append("	,CLK_STOP_DYS" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 @[svr_id]" ).append("\n"); 
		query.append("	,@[cntr_no]" ).append("\n"); 
		query.append("	,@[cntr_cyc_no]" ).append("\n"); 
		query.append("	,@[dmdt_trf_cd]" ).append("\n"); 
		query.append("	,@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("	,@[chg_seq]" ).append("\n"); 
		query.append("	,@[clk_stop_no]" ).append("\n"); 
		query.append("	,0" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}