/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeAutoRatingDBDAOAddLbpChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeAutoRatingDBDAOAddLbpChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LBP 저장
	  * </pre>
	  */
	public SurchargeAutoRatingDBDAOAddLbpChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("third_party_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_incl_xcld_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : SurchargeAutoRatingDBDAOAddLbpChgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_RT " ).append("\n"); 
		query.append("    (BKG_NO" ).append("\n"); 
		query.append("    , RT_SEQ" ).append("\n"); 
		query.append("    , CHG_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , CHG_UT_AMT" ).append("\n"); 
		query.append("    , RAT_AS_QTY" ).append("\n"); 
		query.append("    , RAT_UT_CD" ).append("\n"); 
		query.append("    , CHG_AMT" ).append("\n"); 
		query.append("    , FRT_TERM_CD" ).append("\n"); 
		query.append("    , DP_SEQ" ).append("\n"); 
		query.append("    , CGO_CATE_CD" ).append("\n"); 
		query.append("    , RCV_TERM_CD" ).append("\n"); 
		query.append("    , DE_TERM_CD" ).append("\n"); 
		query.append("    , AUTO_RAT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    , FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("    , PRN_HDN_FLG" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID)" ).append("\n"); 
		query.append("values(" ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("    , NVL((SELECT MAX(RT_SEQ) " ).append("\n"); 
		query.append("             FROM BKG_CHG_RT " ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]), 0) + 1" ).append("\n"); 
		query.append("    , @[chg_cd] -- LBP" ).append("\n"); 
		query.append("    , @[curr_cd]" ).append("\n"); 
		query.append("    , NVL(@[scg_amt], 0) " ).append("\n"); 
		query.append("    , 1 " ).append("\n"); 
		query.append("    , @[rat_ut_cd] " ).append("\n"); 
		query.append("    , NVL(@[scg_amt], 0)" ).append("\n"); 
		query.append("    , @[frt_term_cd]" ).append("\n"); 
		query.append("    , ( SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD='LBP' AND DELT_FLG='N' )" ).append("\n"); 
		query.append("    , @[cgo_cate_cd] -- ==> Cargo 유형 " ).append("\n"); 
		query.append("    , (SELECT RCV_TERM_CD " ).append("\n"); 
		query.append("        FROM BKG_BOOKING " ).append("\n"); 
		query.append("       WHERE BKG_NO  = @[bkg_no])" ).append("\n"); 
		query.append("    , (SELECT DE_TERM_CD " ).append("\n"); 
		query.append("      	FROM BKG_BOOKING " ).append("\n"); 
		query.append("       WHERE BKG_NO  = @[bkg_no])" ).append("\n"); 
		query.append("    ,'I'  -- Auto Rating 이냐..매뉴얼이냐.." ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("        ,@[third_party_ofc]" ).append("\n"); 
		query.append("        ,@[rep_cust_cnt_cd]" ).append("\n"); 
		query.append("        ,@[rep_cust_seq]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    , @[frt_incl_xcld_div_cd]" ).append("\n"); 
		query.append("    , 'N'   " ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}