/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaDBDAOModifyYardSurplusAreaQtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOModifyYardSurplusAreaQtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surplus Area - Yard 의 메뉴얼 데이터를 입력/수정 한다 
	  * EQR_CTRL_INVT_SIM_QTY
	  * </pre>
	  */
	public SurplusAreaDBDAOModifyYardSurplusAreaQtyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invt_sim_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_sav_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration ").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOModifyYardSurplusAreaQtyUSQL").append("\n"); 
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
		query.append("--// EQR_CTRL_INVT_SIM_QTY merge문" ).append("\n"); 
		query.append("MERGE INTO EQR_CTRL_INVT_SIM_QTY V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (        V.FCAST_YRWK     = @[fcast_yrwk]" ).append("\n"); 
		query.append("        AND V.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("        AND V.INVT_SIM_TP_CD = @[invt_sim_tp_cd]" ).append("\n"); 
		query.append("        AND V.CNTR_TPSZ_CD   = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("        CNTR_QTY    = @[cntr_qty]," ).append("\n"); 
		query.append("        TMP_SAV_FLG = @[tmp_sav_flg]," ).append("\n"); 
		query.append("        UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        FCAST_YRWK," ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        INVT_SIM_TP_CD," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CNTR_QTY," ).append("\n"); 
		query.append("        TMP_SAV_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("    	UPD_USR_ID," ).append("\n"); 
		query.append("    	UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("        @[fcast_yrwk]," ).append("\n"); 
		query.append("        @[yd_cd]," ).append("\n"); 
		query.append("        @[invt_sim_tp_cd]," ).append("\n"); 
		query.append("        @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("        @[cntr_qty]," ).append("\n"); 
		query.append("        @[tmp_sav_flg]," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}