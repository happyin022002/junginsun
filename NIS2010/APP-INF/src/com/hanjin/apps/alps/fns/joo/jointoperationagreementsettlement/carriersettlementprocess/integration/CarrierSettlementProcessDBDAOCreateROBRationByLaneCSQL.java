/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreateROBRationByLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.02 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreateROBRationByLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB Container List Inquiry의 Sub-Allocation and Ratio을 저장
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreateROBRationByLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ton_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rnd_rule_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_45ft_n2nd_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreateROBRationByLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_ROB_RTO A " ).append("\n"); 
		query.append("(   SLAN_CD" ).append("\n"); 
		query.append("  , SKD_DIR_CD" ).append("\n"); 
		query.append("  , JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append("  , JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("  , JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append("  , JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("  , JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append("  , JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append("  , JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("  , JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("  , CGO_TON_WGT" ).append("\n"); 
		query.append("  , JO_TON_TEU_QTY" ).append("\n"); 
		query.append("  , JO_RND_RULE_LVL" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(   @[rlane_cd]" ).append("\n"); 
		query.append("  , @[skd_dir_cd]" ).append("\n"); 
		query.append("  , NVL(@[jo_20ft_n1st_rto], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_20ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_40ft_n1st_rto], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_40ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_45ft_n1st_rto], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_45ft_n2nd_rto], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_45ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_bsa_teu_qty], 0)" ).append("\n"); 
		query.append("  , NVL(@[cgo_ton_wgt], 0)" ).append("\n"); 
		query.append("  , NVL(@[jo_ton_teu_qty], 0)" ).append("\n"); 
		query.append("  , @[jo_rnd_rule_lvl]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}