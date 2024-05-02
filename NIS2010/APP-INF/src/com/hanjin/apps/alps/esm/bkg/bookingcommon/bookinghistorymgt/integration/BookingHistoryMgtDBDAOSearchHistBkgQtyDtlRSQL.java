/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL(){
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
		params.put("crr_hngr_tpl_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_hngr_sgl_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mer_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[subst_seq] SUBST_SEQ" ).append("\n"); 
		query.append(", @[rcv_term_cd] RCV_TERM_CD" ).append("\n"); 
		query.append(", @[de_term_cd] DE_TERM_CD" ).append("\n"); 
		query.append(", @[op_cntr_qty] OP_CNTR_QTY" ).append("\n"); 
		query.append(", @[awk_cgo_flg] AWK_CGO_FLG" ).append("\n"); 
		query.append(", @[dcgo_flg] DCGO_FLG" ).append("\n"); 
		query.append(", @[rc_flg] RC_FLG" ).append("\n"); 
		query.append(", @[bb_cgo_flg] BB_CGO_FLG" ).append("\n"); 
		query.append(", @[soc_flg] SOC_FLG" ).append("\n"); 
		query.append(", @[crr_hngr_flg] CRR_HNGR_FLG" ).append("\n"); 
		query.append(", @[mer_hngr_flg] MER_HNGR_FLG" ).append("\n"); 
		query.append(", @[crr_hngr_sgl_bar_use_flg] CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(", @[crr_hngr_dbl_bar_use_flg] CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(", @[crr_hngr_tpl_bar_use_flg] CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append(", @[eq_subst_cntr_tpsz_cd] EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'Volume Detail' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||OLD.OP_CNTR_QTY||" ).append("\n"); 
		query.append("decode(OLD.RCV_TERM_CD,  NOW.RCV_TERM_CD, '', '/'||OLD.RCV_TERM_CD)||" ).append("\n"); 
		query.append("decode(OLD.DE_TERM_CD,   NOW.DE_TERM_CD,  '', '/'||OLD.DE_TERM_CD)||" ).append("\n"); 
		query.append("decode(OLD.DCGO_FLG,     NOW.DCGO_FLG,    '', '/D:'||OLD.DCGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.RC_FLG,       NOW.RC_FLG,      '', '/R:'||OLD.RC_FLG)||" ).append("\n"); 
		query.append("decode(OLD.AWK_CGO_FLG,  NOW.AWK_CGO_FLG, '', '/A:'||OLD.AWK_CGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.BB_CGO_FLG,   NOW.BB_CGO_FLG,  '', '/B:'||OLD.BB_CGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.EQ_SUBST_CNTR_TPSZ_CD, NOW.EQ_SUBST_CNTR_TPSZ_CD, '', '/SUB:'||OLD.EQ_SUBST_CNTR_TPSZ_CD) PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NOW.OP_CNTR_QTY||" ).append("\n"); 
		query.append("decode(OLD.RCV_TERM_CD,  NOW.RCV_TERM_CD, '', '/'||NOW.RCV_TERM_CD)||" ).append("\n"); 
		query.append("decode(OLD.DE_TERM_CD,   NOW.DE_TERM_CD,  '', '/'||NOW.DE_TERM_CD)||" ).append("\n"); 
		query.append("decode(OLD.DCGO_FLG,     NOW.DCGO_FLG,    '', '/D:'||NOW.DCGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.RC_FLG,       NOW.RC_FLG,      '', '/R:'||NOW.RC_FLG)||" ).append("\n"); 
		query.append("decode(OLD.AWK_CGO_FLG,  NOW.AWK_CGO_FLG, '', '/A:'||NOW.AWK_CGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.BB_CGO_FLG,   NOW.BB_CGO_FLG,  '', '/B:'||NOW.BB_CGO_FLG)||" ).append("\n"); 
		query.append("decode(OLD.EQ_SUBST_CNTR_TPSZ_CD, NOW.EQ_SUBST_CNTR_TPSZ_CD, '', '/SUB:'||NOW.EQ_SUBST_CNTR_TPSZ_CD) CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_QTY_DTL_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO     (+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_QTY_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.CNTR_TPSZ_CD(+) = OLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NOW.SUBST_SEQ   (+) = OLD.SUBST_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Hanger Vol' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||OLD.OP_CNTR_QTY||" ).append("\n"); 
		query.append("'/Merchant:'||OLD.MER_HNGR_FLG||" ).append("\n"); 
		query.append("'/Carrier:'||" ).append("\n"); 
		query.append("'(s:'||OLD.CRR_HNGR_SGL_BAR_USE_FLG||" ).append("\n"); 
		query.append("'/d:'||OLD.CRR_HNGR_DBL_BAR_USE_FLG||" ).append("\n"); 
		query.append("'/t:'||OLD.CRR_HNGR_TPL_BAR_USE_FLG||')' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NOW.OP_CNTR_QTY||" ).append("\n"); 
		query.append("'/Merchant:'||NOW.MER_HNGR_FLG||" ).append("\n"); 
		query.append("'/Carrier:'||" ).append("\n"); 
		query.append("'(s:'||NOW.CRR_HNGR_SGL_BAR_USE_FLG||" ).append("\n"); 
		query.append("'/d:'||NOW.CRR_HNGR_DBL_BAR_USE_FLG||" ).append("\n"); 
		query.append("'/t:'||NOW.CRR_HNGR_TPL_BAR_USE_FLG||')' CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_QTY_DTL_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO     (+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_QTY_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NOW.CNTR_TPSZ_CD(+) = OLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NOW.SUBST_SEQ   (+) = OLD.SUBST_SEQ" ).append("\n"); 
		query.append("AND (NOW.CRR_HNGR_FLG = 'Y' OR NOW.MER_HNGR_FLG = 'Y' OR NOW.CRR_HNGR_SGL_BAR_USE_FLG = 'Y' OR NOW.CRR_HNGR_DBL_BAR_USE_FLG = 'Y' OR NOW.CRR_HNGR_TPL_BAR_USE_FLG = 'Y'" ).append("\n"); 
		query.append("OR  OLD.CRR_HNGR_FLG = 'Y' OR OLD.MER_HNGR_FLG = 'Y' OR OLD.CRR_HNGR_SGL_BAR_USE_FLG = 'Y' OR OLD.CRR_HNGR_DBL_BAR_USE_FLG = 'Y' OR OLD.CRR_HNGR_TPL_BAR_USE_FLG = 'Y')" ).append("\n"); 
		query.append("ORDER BY PRE_CTNT, CRNT_CTNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}