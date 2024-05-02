/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtClzUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.06.28 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOStlTgtClzUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target Close 수정
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtClzUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_enbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_enbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_enbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtClzUSQL").append("\n"); 
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
		query.append("UPDATE JOO_STL_TGT J" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append(" J.STL_TGT_FLG = @[stl_tgt_flg]" ).append("\n"); 
		query.append(",J.STL_CLZ_FLG = @[stl_clz_flg]" ).append("\n"); 
		query.append("#if (${fnl_bsa_qty} != '')" ).append("\n"); 
		query.append(",J.FNL_BSA_QTY = @[fnl_bsa_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fnl_bsa_slt_prc} != '')" ).append("\n"); 
		query.append(",J.FNL_BSA_SLT_PRC = @[fnl_bsa_slt_prc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_crr_cd} != '')" ).append("\n"); 
		query.append(",J.REV_CRR_CD = @[rev_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_bsa_qty} != '')" ).append("\n"); 
		query.append(",J.REV_BSA_QTY = @[rev_bsa_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_bsa_slt_prc} != '')" ).append("\n"); 
		query.append(",J.REV_BSA_SLT_PRC = @[rev_bsa_slt_prc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_enbl_flg} != '')" ).append("\n"); 
		query.append(",J.REV_ENBL_FLG = @[rev_enbl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n2nd_rev_crr_cd} != '')" ).append("\n"); 
		query.append(",J.N2ND_REV_CRR_CD = @[n2nd_rev_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n2nd_rev_bsa_qty} != '')" ).append("\n"); 
		query.append(",J.N2ND_REV_BSA_QTY = @[n2nd_rev_bsa_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n2nd_rev_bsa_slt_prc} != '')" ).append("\n"); 
		query.append(",J.N2ND_REV_BSA_SLT_PRC = @[n2nd_rev_bsa_slt_prc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n2nd_rev_enbl_flg} != '')" ).append("\n"); 
		query.append(",J.N2ND_REV_ENBL_FLG = @[n2nd_rev_enbl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n3rd_rev_crr_cd} != '')" ).append("\n"); 
		query.append(",J.N3RD_REV_CRR_CD = @[n3rd_rev_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n3rd_rev_bsa_qty} != '')" ).append("\n"); 
		query.append(",J.N3RD_REV_BSA_QTY = @[n3rd_rev_bsa_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n3rd_rev_bsa_slt_prc} != '')" ).append("\n"); 
		query.append(",J.N3RD_REV_BSA_SLT_PRC = @[n3rd_rev_bsa_slt_prc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${n3rd_rev_enbl_flg} != '')" ).append("\n"); 
		query.append(",J.N3RD_REV_ENBL_FLG = @[n3rd_rev_enbl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_rmk} != '')" ).append("\n"); 
		query.append(",J.STL_RMK = @[stl_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_locl_amt} != '')" ).append("\n"); 
		query.append(",J.STL_LOCL_AMT = @[stl_locl_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND J.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND J.REV_YRMON_SEQ =  @[rev_yrmon_seq]" ).append("\n"); 
		query.append("AND J.REV_SEQ =  @[rev_seq]" ).append("\n"); 

	}
}