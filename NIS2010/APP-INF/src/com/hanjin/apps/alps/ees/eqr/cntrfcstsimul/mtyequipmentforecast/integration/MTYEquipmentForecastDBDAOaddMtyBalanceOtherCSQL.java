/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOaddMtyBalanceOtherCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOaddMtyBalanceOtherCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Yard 의 장비인수 및 임차계획 수량, 장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 생성
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOaddMtyBalanceOtherCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r9_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d7_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bal_otr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a4_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f2_fcast_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOaddMtyBalanceOtherCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_MTY_BAL_RPT_OTR(" ).append("\n"); 
		query.append("      CO_CD         " ).append("\n"); 
		query.append("    , LOC_CD  " ).append("\n"); 
		query.append("    , LOC_GRP_CD      " ).append("\n"); 
		query.append("    , INP_YRWK      " ).append("\n"); 
		query.append("    , FCAST_YRWK    " ).append("\n"); 
		query.append("    , MTY_BAL_OTR_TP_CD" ).append("\n"); 
		query.append("    , CRE_SEQ" ).append("\n"); 
		query.append("    , FCTR_CTNT" ).append("\n"); 
		query.append("    , LSTM_CD" ).append("\n"); 
		query.append("    , YD_CD" ).append("\n"); 
		query.append("    , FCAST_DT" ).append("\n"); 
		query.append("    , D2_FCAST_QTY" ).append("\n"); 
		query.append("    , D4_FCAST_QTY" ).append("\n"); 
		query.append("    , D5_FCAST_QTY" ).append("\n"); 
		query.append("    , D7_FCAST_QTY" ).append("\n"); 
		query.append("    , R2_FCAST_QTY" ).append("\n"); 
		query.append("    , R5_FCAST_QTY" ).append("\n"); 
		query.append("    , R9_FCAST_QTY" ).append("\n"); 
		query.append("    , O2_FCAST_QTY" ).append("\n"); 
		query.append("    , S2_FCAST_QTY" ).append("\n"); 
		query.append("    , O4_FCAST_QTY" ).append("\n"); 
		query.append("    , S4_FCAST_QTY" ).append("\n"); 
		query.append("    , O5_FCAST_QTY" ).append("\n"); 
		query.append("    , F2_FCAST_QTY" ).append("\n"); 
		query.append("    , A2_FCAST_QTY" ).append("\n"); 
		query.append("    , F4_FCAST_QTY" ).append("\n"); 
		query.append("    , A4_FCAST_QTY" ).append("\n"); 
		query.append("    , A5_FCAST_QTY" ).append("\n"); 
		query.append("    , F5_FCAST_QTY" ).append("\n"); 
		query.append("    , DIFF_RMK  " ).append("\n"); 
		query.append("    , CRE_USR_ID  " ).append("\n"); 
		query.append("    , CRE_DT      " ).append("\n"); 
		query.append("    , UPD_USR_ID  " ).append("\n"); 
		query.append("    , UPD_DT	   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      'H'" ).append("\n"); 
		query.append("    , @[loc_cd] " ).append("\n"); 
		query.append("    , @[loc_grp_cd]     " ).append("\n"); 
		query.append("    , @[inp_yrwk]" ).append("\n"); 
		query.append("    , @[fcast_yrwk]" ).append("\n"); 
		query.append("    , @[mty_bal_otr_tp_cd]" ).append("\n"); 
		query.append("    , (SELECT NVL(MAX(CRE_SEQ),0)+1 FROM EQR_CTRL_MTY_BAL_RPT_OTR WHERE  CO_CD='H' AND LOC_CD=@[loc_cd] AND INP_YRWK=@[inp_yrwk] AND FCAST_YRWK=@[fcast_yrwk] AND MTY_BAL_OTR_TP_CD=@[mty_bal_otr_tp_cd] AND LOC_GRP_CD=@[loc_grp_cd] )" ).append("\n"); 
		query.append("    , @[fctr_ctnt]" ).append("\n"); 
		query.append("    , @[lstm_cd]" ).append("\n"); 
		query.append("    , @[yd_cd]" ).append("\n"); 
		query.append("	, TO_DATE(@[fcast_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    , @[d2_fcast_qty]" ).append("\n"); 
		query.append("    , @[d4_fcast_qty]" ).append("\n"); 
		query.append("    , @[d5_fcast_qty]" ).append("\n"); 
		query.append("    , @[d7_fcast_qty]" ).append("\n"); 
		query.append("    , @[r2_fcast_qty]" ).append("\n"); 
		query.append("    , @[r5_fcast_qty]" ).append("\n"); 
		query.append("    , @[r9_fcast_qty]" ).append("\n"); 
		query.append("    , @[o2_fcast_qty]" ).append("\n"); 
		query.append("    , @[s2_fcast_qty]" ).append("\n"); 
		query.append("    , @[o4_fcast_qty]" ).append("\n"); 
		query.append("    , @[s4_fcast_qty]" ).append("\n"); 
		query.append("    , @[o5_fcast_qty]" ).append("\n"); 
		query.append("    , @[f2_fcast_qty]" ).append("\n"); 
		query.append("    , @[a2_fcast_qty]" ).append("\n"); 
		query.append("    , @[f4_fcast_qty]" ).append("\n"); 
		query.append("    , @[a4_fcast_qty]" ).append("\n"); 
		query.append("    , @[a5_fcast_qty]" ).append("\n"); 
		query.append("    , @[f5_fcast_qty]" ).append("\n"); 
		query.append("    , @[diff_rmk]  " ).append("\n"); 
		query.append("    , @[cre_usr_id]  " ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}