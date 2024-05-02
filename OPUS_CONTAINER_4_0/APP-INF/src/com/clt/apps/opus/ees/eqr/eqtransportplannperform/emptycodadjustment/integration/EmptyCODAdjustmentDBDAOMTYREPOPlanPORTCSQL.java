/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.01.25 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY 양하 계획 조정
	  * UI_CIM_1039
	  * MTY COD Confirmation
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d8_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dw_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("o2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cod_cfm_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d7_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d9_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dx_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dchg_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_MTY_COD_PORT(" ).append("\n"); 
		query.append("     VSL_CD" ).append("\n"); 
		query.append("   , SKD_VOY_NO" ).append("\n"); 
		query.append("   , SKD_DIR_CD" ).append("\n"); 
		query.append("   , COD_CFM_DIV_CD" ).append("\n"); 
		query.append("   , PORT_CD" ).append("\n"); 
		query.append("   , CLPT_IND_SEQ" ).append("\n"); 
		query.append("   , LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("   , YD_CD" ).append("\n"); 
		query.append("   , ETB_DT" ).append("\n"); 
		query.append("   , D2_QTY" ).append("\n"); 
		query.append("   , D4_QTY" ).append("\n"); 
		query.append("   , D5_QTY" ).append("\n"); 
		query.append("   , D7_QTY" ).append("\n"); 
		query.append("   , R2_QTY" ).append("\n"); 
		query.append("   , R4_QTY" ).append("\n"); 
		query.append("   , R5_QTY" ).append("\n"); 
		query.append("   , O2_QTY" ).append("\n"); 
		query.append("   , O4_QTY" ).append("\n"); 
		query.append("   , F2_QTY" ).append("\n"); 
		query.append("   , F4_QTY" ).append("\n"); 
		query.append("   , D8_QTY" ).append("\n"); 
		query.append("   , D9_QTY" ).append("\n"); 
		query.append("   , DW_QTY" ).append("\n"); 
		query.append("   , DX_QTY" ).append("\n"); 
		query.append("   , A2_QTY" ).append("\n"); 
		query.append("   , A4_QTY" ).append("\n"); 
		query.append("   , P2_QTY" ).append("\n"); 
		query.append("   , P4_QTY" ).append("\n"); 
		query.append("   , S2_QTY" ).append("\n"); 
		query.append("   , S4_QTY" ).append("\n"); 
		query.append("   , T2_QTY" ).append("\n"); 
		query.append("   , T4_QTY" ).append("\n"); 
		query.append("   , F5_QTY" ).append("\n"); 
		query.append("   , CRE_OFC_CD" ).append("\n"); 
		query.append("   , UPD_OFC_CD" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("     SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   , SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   , SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   , @[cod_cfm_div_cd]" ).append("\n"); 
		query.append("   , @[port_cd]" ).append("\n"); 
		query.append("   , @[clpt_ind_seq]" ).append("\n"); 
		query.append("   , @[lodg_dchg_div_cd]" ).append("\n"); 
		query.append("   , SUBSTR(@[yd_cd],0,7)" ).append("\n"); 
		query.append("   , TO_DATE(@[etb_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("   , @[d2_qty]" ).append("\n"); 
		query.append("   , @[d4_qty]" ).append("\n"); 
		query.append("   , @[d5_qty]" ).append("\n"); 
		query.append("   , @[d7_qty]" ).append("\n"); 
		query.append("   , @[r2_qty]" ).append("\n"); 
		query.append("   , @[r4_qty]" ).append("\n"); 
		query.append("   , @[r5_qty]" ).append("\n"); 
		query.append("   , @[o2_qty]" ).append("\n"); 
		query.append("   , @[o4_qty]" ).append("\n"); 
		query.append("   , @[f2_qty]" ).append("\n"); 
		query.append("   , @[f4_qty]" ).append("\n"); 
		query.append("   , @[d8_qty]" ).append("\n"); 
		query.append("   , @[d9_qty]" ).append("\n"); 
		query.append("   , @[dw_qty]" ).append("\n"); 
		query.append("   , @[dx_qty]" ).append("\n"); 
		query.append("   , @[a2_qty]" ).append("\n"); 
		query.append("   , @[a4_qty]" ).append("\n"); 
		query.append("   , @[p2_qty]" ).append("\n"); 
		query.append("   , @[p4_qty]" ).append("\n"); 
		query.append("   , @[s2_qty]" ).append("\n"); 
		query.append("   , @[s4_qty]" ).append("\n"); 
		query.append("   , @[t2_qty]" ).append("\n"); 
		query.append("   , @[t4_qty]" ).append("\n"); 
		query.append("   , @[f5_qty]" ).append("\n"); 
		query.append("   , @[cre_ofc_cd]" ).append("\n"); 
		query.append("   , @[upd_ofc_cd]" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[upd_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}