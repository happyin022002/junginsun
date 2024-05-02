/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL.java
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

public class BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flex_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_hngr_sgl_bar_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_hngr_tpl_bar_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mer_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_hngr_dbl_bar_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL").append("\n"); 
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
		query.append(", @[op_cntr_qty] OP_CNTR_QTY" ).append("\n"); 
		query.append(", @[act_cntr_qty] ACT_CNTR_QTY" ).append("\n"); 
		query.append(", @[dcgo_qty] DCGO_QTY" ).append("\n"); 
		query.append(", @[awk_cgo_qty] AWK_CGO_QTY" ).append("\n"); 
		query.append(", @[rc_qty] RC_QTY" ).append("\n"); 
		query.append(", @[bb_cgo_qty] BB_CGO_QTY" ).append("\n"); 
		query.append(", @[soc_qty] SOC_QTY" ).append("\n"); 
		query.append(", @[eq_subst_cntr_tpsz_cd] EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[eq_subst_cgo_qty] EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append(", @[mer_hngr_qty] MER_HNGR_QTY" ).append("\n"); 
		query.append(", @[crr_hngr_qty] CRR_HNGR_QTY" ).append("\n"); 
		query.append(", @[crr_hngr_sgl_bar_qty] CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append(", @[crr_hngr_dbl_bar_qty] CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append(", @[crr_hngr_tpl_bar_qty] CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append(", @[org_cntr_qty] ORG_CNTR_QTY" ).append("\n"); 
		query.append(", @[dest_cntr_qty] DEST_CNTR_QTY" ).append("\n"); 
		query.append(", @[ob_tro_qty] OB_TRO_QTY" ).append("\n"); 
		query.append(", @[ib_tro_qty] IB_TRO_QTY" ).append("\n"); 
		query.append(", @[flex_hgt_flg] FLEX_HGT_FLG" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'BKG QTY' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||OLD.OP_CNTR_QTY||" ).append("\n"); 
		query.append("decode(OLD.DCGO_QTY, NOW.DCGO_QTY, 		'', '/D:'||OLD.DCGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.RC_QTY,   NOW.RC_QTY,   		'', '/R:'||OLD.RC_QTY)||" ).append("\n"); 
		query.append("decode(OLD.AWK_CGO_QTY,  NOW.AWK_CGO_QTY, '', '/A:'||OLD.AWK_CGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.BB_CGO_QTY,   NOW.BB_CGO_QTY,  '', '/B:'||OLD.BB_CGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.EQ_SUBST_CGO_QTY||OLD.EQ_SUBST_CGO_QTY,  NOW.EQ_SUBST_CGO_QTY||NOW.EQ_SUBST_CGO_QTY, ''," ).append("\n"); 
		query.append("'/SUB:'||OLD.EQ_SUBST_CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||OLD.EQ_SUBST_CGO_QTY) PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NOW.OP_CNTR_QTY||" ).append("\n"); 
		query.append("decode(OLD.DCGO_QTY, NOW.DCGO_QTY, 		'', '/D:'||NOW.DCGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.RC_QTY,   NOW.RC_QTY,   		'', '/R:'||NOW.RC_QTY)||" ).append("\n"); 
		query.append("decode(OLD.AWK_CGO_QTY,  NOW.AWK_CGO_QTY, '', '/A:'||NOW.AWK_CGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.BB_CGO_QTY,   NOW.BB_CGO_QTY,  '', '/B:'||NOW.BB_CGO_QTY)||" ).append("\n"); 
		query.append("decode(OLD.EQ_SUBST_CGO_QTY||OLD.EQ_SUBST_CGO_QTY,  NOW.EQ_SUBST_CGO_QTY||NOW.EQ_SUBST_CGO_QTY, ''," ).append("\n"); 
		query.append("'/SUB:'||NOW.EQ_SUBST_CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NOW.EQ_SUBST_CGO_QTY) CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_QTY_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO     (+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_QUANTITY NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NOW.CNTR_TPSZ_CD(+) = OLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'HANGER' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/Merchant:'||OLD.MER_HNGR_QTY||" ).append("\n"); 
		query.append("'/Carrier:'||OLD.CRR_HNGR_QTY||" ).append("\n"); 
		query.append("'(s:'||OLD.CRR_HNGR_SGL_BAR_QTY||" ).append("\n"); 
		query.append("'/d:'||OLD.CRR_HNGR_DBL_BAR_QTY||" ).append("\n"); 
		query.append("'/t:'||OLD.CRR_HNGR_TPL_BAR_QTY||')' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/Merchant:'||NOW.MER_HNGR_QTY||" ).append("\n"); 
		query.append("'/Carrier:'||NOW.CRR_HNGR_QTY||" ).append("\n"); 
		query.append("'(s:'||NOW.CRR_HNGR_SGL_BAR_QTY||" ).append("\n"); 
		query.append("'/d:'||NOW.CRR_HNGR_DBL_BAR_QTY||" ).append("\n"); 
		query.append("'/t:'||NOW.CRR_HNGR_TPL_BAR_QTY||')' CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_QTY_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO     (+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_QUANTITY NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.CNTR_TPSZ_CD(+) = OLD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND (OLD.MER_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR OLD.CRR_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR OLD.CRR_HNGR_SGL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR OLD.CRR_HNGR_DBL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR OLD.CRR_HNGR_TPL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.MER_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_SGL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_DBL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_TPL_BAR_QTY > 0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}