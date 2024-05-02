/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgQtyDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddBkgQtyDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgQtyDtl 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgQtyDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dry_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_hngr_tpl_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_hngr_sgl_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_hngr_dbl_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mer_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgQtyDtlCSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_QTY_DTL_HIS (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_QTY_DTL (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    ,CORR_NO" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("    ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,SUBST_SEQ" ).append("\n"); 
		query.append("    ,RCV_TERM_CD" ).append("\n"); 
		query.append("    ,DE_TERM_CD" ).append("\n"); 
		query.append("    ,OP_CNTR_QTY" ).append("\n"); 
		query.append("    ,AWK_CGO_FLG" ).append("\n"); 
		query.append("    ,DCGO_FLG" ).append("\n"); 
		query.append("    ,RC_FLG" ).append("\n"); 
		query.append("    ,BB_CGO_FLG" ).append("\n"); 
		query.append("    ,SOC_FLG" ).append("\n"); 
		query.append("    ,CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append("    ,CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append("    ,CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append("    ,EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,DRY_CGO_FLG" ).append("\n"); 
		query.append("    ,CRR_HNGR_FLG" ).append("\n"); 
		query.append("    ,MER_HNGR_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("     @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    ,'TMP0000001'" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("    ,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("    	SELECT  NVL(MAX(SUBST_SEQ),0)+1" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		FROM BKG_QTY_DTL_HIS " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM BKG_QTY_DTL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND	  CNTR_TPSZ_CD = @[cntr_tpsz_cd] " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   	 )" ).append("\n"); 
		query.append("    ,@[rcv_term_cd]" ).append("\n"); 
		query.append("    ,@[de_term_cd]" ).append("\n"); 
		query.append("    ,@[op_cntr_qty]" ).append("\n"); 
		query.append("    ,NVL(@[awk_cgo_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[dcgo_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[rc_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[bb_cgo_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[soc_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[crr_hngr_sgl_bar_use_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[crr_hngr_dbl_bar_use_flg],'N')" ).append("\n"); 
		query.append("    ,NVL(@[crr_hngr_tpl_bar_use_flg],'N')" ).append("\n"); 
		query.append("    ,@[eq_subst_cntr_tpsz_cd]" ).append("\n"); 
		query.append("    ,NVL(@[dry_cgo_flg],'N')" ).append("\n"); 
		query.append("#if (${crr_hngr_sgl_bar_use_flg} == 'Y' || ${crr_hngr_dbl_bar_use_flg} == 'Y' || ${crr_hngr_tpl_bar_use_flg} == 'Y') " ).append("\n"); 
		query.append("	,'Y'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,NVL(@[mer_hngr_flg],'N')" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}