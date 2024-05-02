/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.13 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL").append("\n"); 
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
		query.append(", @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append(", @[rtn_tro_flg] RTN_TRO_FLG" ).append("\n"); 
		query.append(", @[tro_seq] TRO_SEQ" ).append("\n"); 
		query.append(", @[tro_sub_seq] TRO_SUB_SEQ" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[tro_qty] TRO_QTY" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[dor_arr_dt] DOR_ARR_DT" ).append("\n"); 
		query.append(", @[pkup_loc_cd] PKUP_LOC_CD" ).append("\n"); 
		query.append(", @[pkup_yd_cd] PKUP_YD_CD" ).append("\n"); 
		query.append(", @[rtn_loc_cd] RTN_LOC_CD" ).append("\n"); 
		query.append(", @[rtn_yd_cd] RTN_YD_CD" ).append("\n"); 
		query.append(", @[cmdt_cd] CMDT_CD" ).append("\n"); 
		query.append(", @[pctl_no] PCTL_NO" ).append("\n"); 
		query.append(", @[cxl_flg] CXL_FLG" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'TRO QTY' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||OLD.TRO_QTY||" ).append("\n"); 
		query.append("'/'||OLD.CNTR_NO PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NOW.TRO_QTY||" ).append("\n"); 
		query.append("'/'||NOW.CNTR_NO CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append(", BKG_TRO_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("AND NOW.TRO_SUB_SEQ(+) = OLD.TRO_SUB_SEQ" ).append("\n"); 
		query.append("AND NOW.TRO_QTY        <> 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TRO YARD' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.DOR_ARR_DT||" ).append("\n"); 
		query.append("'/P/UP@['||OLD.PKUP_YD_CD||" ).append("\n"); 
		query.append("'/RTN@['||OLD.RTN_YD_CD PRE_CTNT" ).append("\n"); 
		query.append(", TO_CHAR(NOW.DOR_ARR_DT, 'YYYY-MM-DD HH24:MI')||" ).append("\n"); 
		query.append("'/P/UP@['||NOW.PKUP_YD_CD||" ).append("\n"); 
		query.append("'/RTN@['||NOW.RTN_YD_CD CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append(", BKG_TRO_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("AND NOW.TRO_SUB_SEQ(+) = OLD.TRO_SUB_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}