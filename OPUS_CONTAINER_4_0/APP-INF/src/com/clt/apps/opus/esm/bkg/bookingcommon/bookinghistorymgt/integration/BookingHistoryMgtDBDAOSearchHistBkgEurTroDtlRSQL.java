/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dor_addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL").append("\n"); 
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
		query.append(", @[tro_seq] TRO_SEQ" ).append("\n"); 
		query.append(", @[tro_sub_seq] TRO_SUB_SEQ" ).append("\n"); 
		query.append(", @[dor_addr_tp_cd] DOR_ADDR_TP_CD" ).append("\n"); 
		query.append(", @[loc_cd] LOC_CD" ).append("\n"); 
		query.append(", @[zn_cd] ZN_CD" ).append("\n"); 
		query.append(", @[lod_ref_no] LOD_REF_NO" ).append("\n"); 
		query.append(", @[dor_zip_id] DOR_ZIP_ID" ).append("\n"); 
		query.append(", @[dor_addr] DOR_ADDR" ).append("\n"); 
		query.append(", @[arr_dt] ARR_DT" ).append("\n"); 
		query.append(", @[cntc_pson_nm] CNTC_PSON_NM" ).append("\n"); 
		query.append(", @[cntc_phn_no] CNTC_PHN_NO" ).append("\n"); 
		query.append(", @[cntc_eml] CNTC_EML" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'TRO DOOR' HIS_CATE_NM" ).append("\n"); 
		query.append("                , 'Type: '||DECODE(OLD.DOR_ADDR_TP_CD,'D','Door','C','Customs')||" ).append("\n"); 
		query.append("				  ' / Location: '||OLD.LOC_CD||" ).append("\n"); 
		query.append("                  ' / Zone: '||OLD.ZN_CD||" ).append("\n"); 
		query.append("				  ' / Load Ref.: '||OLD.LOD_REF_NO||" ).append("\n"); 
		query.append("                  ' / ZIP: '||OLD.DOR_ZIP_ID||" ).append("\n"); 
		query.append("                  ' / Company&Address: '||OLD.DOR_ADDR||" ).append("\n"); 
		query.append("                  ' / Door Arrival Date: '||OLD.ARR_DT PRE_CTNT" ).append("\n"); 
		query.append("                , 'Type: '||DECODE(NOW.DOR_ADDR_TP_CD,'D','Door','C','Customs')||" ).append("\n"); 
		query.append("			      ' / Location: '||NOW.LOC_CD||" ).append("\n"); 
		query.append("                  ' / Zone: '||NOW.ZN_CD||" ).append("\n"); 
		query.append("				  ' / Load Ref.: '||NOW.LOD_REF_NO||" ).append("\n"); 
		query.append("                  ' / ZIP: '||NOW.DOR_ZIP_ID||" ).append("\n"); 
		query.append("                  ' / Company&Address: '||NOW.DOR_ADDR||" ).append("\n"); 
		query.append("                  ' / Door Arrival Date: '||TO_CHAR(NOW.ARR_DT, 'YYYY-MM-DD HH24:MI:SS') CRNT_CTNT" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO_DTL NOW" ).append("\n"); 
		query.append("             , OLD" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("           AND NOW.TRO_SUB_SEQ(+) = OLD.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO CONTACT' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTC_PSON_NM||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_EML PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTC_PSON_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_EML CRNT_CTNT" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO_DTL NOW" ).append("\n"); 
		query.append("             , OLD" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("           AND NOW.TRO_SUB_SEQ(+) = OLD.TRO_SUB_SEQ" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}