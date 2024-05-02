/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOModifyChgTaxRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyChgTaxRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CHG_TAX_RT Data에 해당하는 정보를 수정한다
	  * </pre>
	  */
	public BlRatingDBDAOModifyChgTaxRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incl_oft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tax_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyChgTaxRateUSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("	BKG_CHG_TAX_RT_HIS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	DP_SEQ = (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N')," ).append("\n"); 
		query.append("	FRT_TERM_CD       = @[frt_term_cd]," ).append("\n"); 
		query.append("	CGO_CATE_CD       = @[cgo_cate_cd]," ).append("\n"); 
		query.append("	CHG_CD            = @[chg_cd]," ).append("\n"); 
		query.append("	CURR_CD           = @[curr_cd]," ).append("\n"); 
		query.append("	RAT_UT_CD         = @[rat_ut_cd]," ).append("\n"); 
		query.append("	RAT_AS_QTY        = @[rat_as_qty]," ).append("\n"); 
		query.append("	CHG_UT_AMT        = @[chg_ut_amt]," ).append("\n"); 
		query.append("	CHG_AMT           = @[chg_amt]," ).append("\n"); 
		query.append("	FRT_INCL_XCLD_DIV_CD      = @[incl_oft_flg]," ).append("\n"); 
		query.append("	PCT_BSE_CD        = @[pct_bse_cd]," ).append("\n"); 
		query.append("	TAX_FLG           = @[tax_flg]," ).append("\n"); 
		query.append("	UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT            = sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("	AND    RT_SEQ     = @[rt_seq]" ).append("\n"); 
		query.append("	AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_CHG_TAX_RT " ).append("\n"); 
		query.append("SET    " ).append("\n"); 
		query.append("	DP_SEQ = (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N')," ).append("\n"); 
		query.append("	FRT_TERM_CD       = @[frt_term_cd]," ).append("\n"); 
		query.append("	CGO_CATE_CD       = @[cgo_cate_cd]," ).append("\n"); 
		query.append("	CHG_CD            = @[chg_cd]," ).append("\n"); 
		query.append("	CURR_CD           = @[curr_cd]," ).append("\n"); 
		query.append("	RAT_UT_CD         = @[rat_ut_cd]," ).append("\n"); 
		query.append("	RAT_AS_QTY        = @[rat_as_qty]," ).append("\n"); 
		query.append("	CHG_UT_AMT        = @[chg_ut_amt]," ).append("\n"); 
		query.append("	CHG_AMT           = @[chg_amt]," ).append("\n"); 
		query.append("	FRT_INCL_XCLD_DIV_CD      = @[incl_oft_flg]," ).append("\n"); 
		query.append("	PCT_BSE_CD        = @[pct_bse_cd]," ).append("\n"); 
		query.append("	TAX_FLG           = @[tax_flg]," ).append("\n"); 
		query.append("	UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT            = sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("	AND    RT_SEQ     = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}