/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyAkCgoByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopyAkCgoByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyAkCgoByBkg
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyAkCgoByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyAkCgoByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AWK_CGO(BKG_NO" ).append("\n"); 
		query.append("        , AWK_CGO_SEQ" ).append("\n"); 
		query.append("        , RCV_TERM_CD" ).append("\n"); 
		query.append("        , DE_TERM_CD" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , OVR_FWRD_LEN" ).append("\n"); 
		query.append("        , OVR_BKWD_LEN" ).append("\n"); 
		query.append("        , OVR_HGT" ).append("\n"); 
		query.append("        , OVR_LF_LEN" ).append("\n"); 
		query.append("        , OVR_RT_LEN" ).append("\n"); 
		query.append("        , OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("        , TTL_DIM_LEN" ).append("\n"); 
		query.append("        , TTL_DIM_WDT" ).append("\n"); 
		query.append("        , TTL_DIM_HGT" ).append("\n"); 
		query.append("        , AWK_DCGO_SEQ" ).append("\n"); 
		query.append("        , CMDT_CD" ).append("\n"); 
		query.append("        , IN_GA_FLG" ).append("\n"); 
		query.append("        , CRN_PST_STS_CD" ).append("\n"); 
		query.append("        , XTD_OVR_QTY" ).append("\n"); 
		query.append("        , PST_LCK_PIN_FLG" ).append("\n"); 
		query.append("        , GRAV_CTR_DESC" ).append("\n"); 
		query.append("        , STWG_RQST_DESC" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , CNTR_VOL_QTY)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append("		,(SELECT /*+index_desc (bkg_awk_cgo XPKBKG_AWK_CGO)*/" ).append("\n"); 
		query.append("					NVL(SUM(AWK_CGO_SEQ),0)+AK.AWK_CGO_SEQ" ).append("\n"); 
		query.append("					FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("					WHERE AWK_CGO_SEQ >= 0" ).append("\n"); 
		query.append("					AND ROWNUM <= 1" ).append("\n"); 
		query.append("					AND BKG_NO = @[mst_bkg_no]) AWK_CGO_SEQ" ).append("\n"); 
		query.append("        , RCV_TERM_CD" ).append("\n"); 
		query.append("        , DE_TERM_CD" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , GRS_WGT" ).append("\n"); 
		query.append("        , NET_WGT" ).append("\n"); 
		query.append("        , WGT_UT_CD" ).append("\n"); 
		query.append("        , OVR_FWRD_LEN" ).append("\n"); 
		query.append("        , OVR_BKWD_LEN" ).append("\n"); 
		query.append("        , OVR_HGT" ).append("\n"); 
		query.append("        , OVR_LF_LEN" ).append("\n"); 
		query.append("        , OVR_RT_LEN" ).append("\n"); 
		query.append("        , OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("        , TTL_DIM_LEN" ).append("\n"); 
		query.append("        , TTL_DIM_WDT" ).append("\n"); 
		query.append("        , TTL_DIM_HGT" ).append("\n"); 
		query.append("        , AWK_DCGO_SEQ" ).append("\n"); 
		query.append("        , CMDT_CD" ).append("\n"); 
		query.append("        , IN_GA_FLG" ).append("\n"); 
		query.append("        , CRN_PST_STS_CD" ).append("\n"); 
		query.append("        , XTD_OVR_QTY" ).append("\n"); 
		query.append("        , PST_LCK_PIN_FLG" ).append("\n"); 
		query.append("        , GRAV_CTR_DESC" ).append("\n"); 
		query.append("        , STWG_RQST_DESC" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if(${copy_mode_cd} != 'C')" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , nvl((select cntr.CNTR_VOL_QTY " ).append("\n"); 
		query.append("                 from bkg_container cntr " ).append("\n"); 
		query.append("                where cntr.bkg_no  = @[mst_bkg_no]" ).append("\n"); 
		query.append("                  and cntr.cntr_no = ak.cntr_no), 1)" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO AK" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND (CNTR_NO IS NULL" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		CNTR_NO NOT IN (SELECT NVL(CNTR_NO, 'X')" ).append("\n"); 
		query.append("                         FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("						WHERE BKG_NO = @[mst_bkg_no])" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}