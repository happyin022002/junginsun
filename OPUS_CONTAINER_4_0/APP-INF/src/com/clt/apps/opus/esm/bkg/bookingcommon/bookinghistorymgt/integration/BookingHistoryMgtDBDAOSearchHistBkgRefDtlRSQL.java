/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
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

public class BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("itm_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL").append("\n"); 
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
		query.append(", @[ref_seq] REF_SEQ" ).append("\n"); 
		query.append(", @[cust_ref_tp_cd] CUST_REF_TP_CD" ).append("\n"); 
		query.append(", @[de_no] DE_NO" ).append("\n"); 
		query.append(", @[prt_no] PRT_NO" ).append("\n"); 
		query.append(", @[cpy_desc_flg] CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[itm_no] ITM_NO" ).append("\n"); 
		query.append(", @[itm_desc] ITM_DESC" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[cntr_wgt] CNTR_WGT" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[meas_qty] MEAS_QTY" ).append("\n"); 
		query.append(", @[meas_ut_cd] MEAS_UT_CD" ).append("\n"); 
		query.append(", @[po_no] PO_NO" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'P/O & OTHER NO' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.CNTR_NO||" ).append("\n"); 
		query.append("'/'||OLD.PO_NO||" ).append("\n"); 
		query.append("'/'||OLD.ITM_NO||" ).append("\n"); 
		query.append("'/PACKAGE:'||OLD.PCK_QTY||' '||OLD.PCK_TP_CD||" ).append("\n"); 
		query.append("'/WEIGHT:'||OLD.CNTR_WGT||' '||OLD.WGT_UT_CD||" ).append("\n"); 
		query.append("'/MEASURE:'||OLD.MEAS_QTY||' '||OLD.MEAS_UT_CD PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_NO||" ).append("\n"); 
		query.append("'/'||NOW.PO_NO||" ).append("\n"); 
		query.append("'/'||NOW.ITM_NO||" ).append("\n"); 
		query.append("'/PACKAGE:'||NOW.PCK_QTY||' '||NOW.PCK_TP_CD||" ).append("\n"); 
		query.append("'/WEIGHT:'||NOW.CNTR_WGT||' '||NOW.WGT_UT_CD||" ).append("\n"); 
		query.append("'/MEASURE:'||NOW.MEAS_QTY||' '||NOW.MEAS_UT_CD CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_REF_DTL_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+)  = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_REF_DTL NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+)  = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.REF_SEQ(+) = OLD.REF_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}