/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOAddChgTaxRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.14 
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

public class BlRatingDBDAOAddChgTaxRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CHG_TAX_RT Data에 해당하는 정보를 추가한다
	  * </pre>
	  */
	public BlRatingDBDAOAddChgTaxRateCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddChgTaxRateCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("	 INSERT INTO BKG_CHG_TAX_RT_HIS (" ).append("\n"); 
		query.append("	   BKG_NO,CORR_NO, RT_SEQ, DP_SEQ, " ).append("\n"); 
		query.append("	   FRT_TERM_CD, CGO_CATE_CD, " ).append("\n"); 
		query.append("	   CHG_CD, CURR_CD, " ).append("\n"); 
		query.append("	   RAT_UT_CD, RAT_AS_QTY, " ).append("\n"); 
		query.append("	   CHG_UT_AMT, CHG_AMT,  " ).append("\n"); 
		query.append("	   FRT_INCL_XCLD_DIV_CD, PCT_BSE_CD, TAX_FLG," ).append("\n"); 
		query.append("	   CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("	   UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("	VALUES (" ).append("\n"); 
		query.append("	   @[bkg_no], 'TMP0000001'," ).append("\n"); 
		query.append("	   @[rt_seq]," ).append("\n"); 
		query.append("	   (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N') , " ).append("\n"); 
		query.append("	   @[frt_term_cd], @[cgo_cate_cd], " ).append("\n"); 
		query.append("	   @[chg_cd], @[curr_cd], " ).append("\n"); 
		query.append("	   @[rat_ut_cd], @[rat_as_qty], " ).append("\n"); 
		query.append("	   @[chg_ut_amt], @[chg_amt]," ).append("\n"); 
		query.append("	   @[incl_oft_flg], @[pct_bse_cd], @[tax_flg]," ).append("\n"); 
		query.append("	   @[cre_usr_id], sysdate, " ).append("\n"); 
		query.append("	   @[upd_usr_id], sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 INSERT INTO BKG_CHG_TAX_RT (" ).append("\n"); 
		query.append("	   BKG_NO,RT_SEQ, DP_SEQ, " ).append("\n"); 
		query.append("	   FRT_TERM_CD, CGO_CATE_CD, " ).append("\n"); 
		query.append("	   CHG_CD, CURR_CD, " ).append("\n"); 
		query.append("	   RAT_UT_CD, RAT_AS_QTY, " ).append("\n"); 
		query.append("	   CHG_UT_AMT, CHG_AMT,  " ).append("\n"); 
		query.append("	   FRT_INCL_XCLD_DIV_CD, PCT_BSE_CD, TAX_FLG," ).append("\n"); 
		query.append("	   CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("	   UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("	VALUES (" ).append("\n"); 
		query.append("	   @[bkg_no]," ).append("\n"); 
		query.append("	   @[rt_seq]," ).append("\n"); 
		query.append("	   (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N') , " ).append("\n"); 
		query.append("	   @[frt_term_cd], @[cgo_cate_cd], " ).append("\n"); 
		query.append("	   @[chg_cd], @[curr_cd], " ).append("\n"); 
		query.append("	   @[rat_ut_cd], @[rat_as_qty], " ).append("\n"); 
		query.append("	   @[chg_ut_amt], @[chg_amt]," ).append("\n"); 
		query.append("	   @[incl_oft_flg], @[pct_bse_cd], @[tax_flg]," ).append("\n"); 
		query.append("	   @[cre_usr_id], sysdate, " ).append("\n"); 
		query.append("	   @[upd_usr_id], sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}