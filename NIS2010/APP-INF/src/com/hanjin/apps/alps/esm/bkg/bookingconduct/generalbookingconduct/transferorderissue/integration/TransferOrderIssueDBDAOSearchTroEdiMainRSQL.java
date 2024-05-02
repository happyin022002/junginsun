/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroEdiMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchTroEdiMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchTroEdiMain
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroEdiMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchTroEdiMainRSQL").append("\n"); 
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
		query.append("SELECT RPAD(@[msg_id], 9)                                || /* TRNS ID */" ).append("\n"); 
		query.append("RPAD(@[mod_cd], 3)                                || /* CLS  ID */" ).append("\n"); 
		query.append("RPAD(BK.OB_SREP_CD, 7)                            || /* AUTHOR */" ).append("\n"); 
		query.append("DECODE(OLD_VVD,       NULL, RPAD(NVL(FIRST_VVD, ' '), 9), DECODE(OLD_BKG_INFO, NEW_BKG_INFO, RPAD(NVL(FIRST_VVD, ' '), 9), RPAD(NVL(OLD_VVD, ' '), 9)))        || /* OLD VVD */" ).append("\n"); 
		query.append("--DECODE(OLD_BKG_NBR,   NULL, BK.BKG_NO||BK.BKG_NO_SPLIT,   DECODE(OLD_BKG_INFO, NEW_BKG_INFO, BK.BKG_NO||BK.BKG_NO_SPLIT, OLD_BKG_NBR))                         || /* OLD BKG */" ).append("\n"); 
		query.append("DECODE(OLD_BKG_NBR,   NULL, RPAD(BK.BKG_NO, 13),          DECODE(OLD_BKG_INFO, NEW_BKG_INFO, RPAD(BK.BKG_NO, 13), RPAD(OLD_BKG_NBR, 13)))                                || /* OLD BKG */" ).append("\n"); 
		query.append("RPAD(SUBSTR(FIRST_POD, 3, 3), 3)                  || /* NEW POD */" ).append("\n"); 
		query.append("DECODE(OLD_POL_CD,    NULL, RPAD(SUBSTR(BK.POL_CD, 3, 3), 3),      DECODE(OLD_BKG_INFO, NEW_BKG_INFO, RPAD(SUBSTR(BK.POL_CD, 3, 3), 3), RPAD(SUBSTR(NVL(OLD_POL_CD, '     '), 3, 3), 3))) || /* OLD POL */" ).append("\n"); 
		query.append("RPAD(SUBSTR(BK.DEL_CD, 3, 3), 3)                  || /* DEL */" ).append("\n"); 
		query.append("DECODE(OLD_VVD,       NULL, '         ',                  DECODE(OLD_BKG_INFO, NEW_BKG_INFO, '         ', RPAD(NVL(FIRST_VVD, ' '), 9)))                       || /* CHG VVD */" ).append("\n"); 
		query.append("--DECODE(OLD_BKG_NBR,   NULL, '             ',              DECODE(OLD_BKG_INFO, NEW_BKG_INFO, '             ', BK.BKG_NO||BK.BKG_NO_SPLIT))                     || /* CHG BKG */" ).append("\n"); 
		query.append("DECODE(OLD_BKG_NBR,   NULL, '             ',              DECODE(OLD_BKG_INFO, NEW_BKG_INFO, '             ', RPAD(BK.BKG_NO, 13)))                     || /* CHG BKG 13자리*/" ).append("\n"); 
		query.append("'   '                                             || /* CHG POD  3자리 */" ).append("\n"); 
		query.append("DECODE(OLD_POL_CD,    NULL, '   ', DECODE(OLD_BKG_INFO, NEW_BKG_INFO, '   ', RPAD(SUBSTR(BK.POL_CD, 3, 3), 3))) || /* CHG POL 3자리*/" ).append("\n"); 
		query.append("RPAD(X_RETURN_CY, 5)                              || /* ARV TRML  5자리*/" ).append("\n"); 
		query.append("RPAD(NVL(CNTC.CNTC_PSON_PHN_NO, ' '), 20)         || /* SHPR TEL  20자리 */" ).append("\n"); 
		query.append("RPAD(NVL(CNTC.CNTC_PSON_FAX_NO, ' '), 20)         || /* SHPR FAX  20자리 */" ).append("\n"); 
		query.append("'          '                            			 || /* SHPR ID   20자리  --> 10자리로 변경 */" ).append("\n"); 
		query.append("RPAD(NVL(CUSTOMER_NAME, ' '), 50)                 || /* SHPR NAME 50자리  */" ).append("\n"); 
		query.append("--NVL(CNTC.CNTC_PSON_NM, ' ')||SUBSTR('                    ', 1, 20-LENGTH(NVL(CNTC.CNTC_PSON_NM, ' ')))|| /* ACTL ATH */" ).append("\n"); 
		query.append("--RPAD(SUBSTR(NVL(CNTC.CNTC_PSON_NM, ' '), 1, 20), 20)|| /* Booking Shipper Author 20자리 */" ).append("\n"); 
		query.append("DECODE(NVL(CNTC.CNTC_PSON_NM, ' '),'대중종합운수(자가운송)','대중종합운수(자가운 ', RPAD(SUBSTR(NVL(CNTC.CNTC_PSON_NM, ' '), 1, 20), 20)) ||" ).append("\n"); 
		query.append("TRO_FLAT AS STR_FLATFILE" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("BKG_CNTC_PSON CNTC," ).append("\n"); 
		query.append("/* GET FIRST VVD */" ).append("\n"); 
		query.append("(SELECT /*+INDEX(XPKBKG_VVD BKG_VVD) */" ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append(", POD_CD FIRST_POD" ).append("\n"); 
		query.append("--, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||BKG_NO||BKG_NO_SPLIT||POL_CD NEW_BKG_INFO" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD||RPAD(BKG_NO, 13)||POL_CD NEW_BKG_INFO" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM       = 1" ).append("\n"); 
		query.append("ORDER BY VSL_PRE_PST_CD, VSL_SEQ)," ).append("\n"); 
		query.append("/* GET CUSTOMER NAME */" ).append("\n"); 
		query.append("(SELECT MDM_CUST.CUST_LGL_ENG_NM CUSTOMER_NAME" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER BKG_CUST," ).append("\n"); 
		query.append("MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("WHERE BKG_CUST.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BKG_CUST.CUST_CNT_CD    = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND BKG_CUST.CUST_SEQ       = MDM_CUST.CUST_SEQ)," ).append("\n"); 
		query.append("/* GET TRO INFO */" ).append("\n"); 
		query.append("(SELECT LPAD(TRO_SEQ, 2, '0')||" ).append("\n"); 
		query.append("RPAD(NVL(ACT_SHPR_PHN_NO, ' '), 20)||" ).append("\n"); 
		query.append("RPAD(NVL(CNTC_FAX_NO, ' '), 20)||" ).append("\n"); 
		query.append("RPAD(NVL(TRANSLATE(SUBSTR(BIZ_RGST_NO, 1, 10), '1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ-/.,', '1234567890'), ' '), 10)||" ).append("\n"); 
		query.append("--NVL(ACT_SHPR_NM, ' ')||SUBSTR('                                                  ', 1, 50-LENGTH(NVL(ACT_SHPR_NM, ' ')))||" ).append("\n"); 
		query.append("--NVL(CNTC_PSON_NM, ' ')||SUBSTR('                    ', 1, 20-LENGTH(NVL(CNTC_PSON_NM, ' ')))||" ).append("\n"); 
		query.append("RPAD(SUBSTR(NVL(ACT_SHPR_NM, ' '), 1, 50), 50)||" ).append("\n"); 
		query.append("RPAD(SUBSTR(NVL(CNTC_PSON_NM, ' '), 1, 20), 20)||" ).append("\n"); 
		query.append("RPAD(OWNR_TRK_FLG, 1)||" ).append("\n"); 
		query.append("RPAD(NVL(TRANSLATE(DIFF_RMK, CHR(10)||CHR(13), ' '), ' '), 300) TRO_FLAT" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD OLD_VVD" ).append("\n"); 
		query.append(", POL_CD OLD_POL_CD" ).append("\n"); 
		query.append(", POD_CD OLD_POD_CD" ).append("\n"); 
		query.append(", RPAD(TRO_BKG_NO, 13) OLD_BKG_NBR" ).append("\n"); 
		query.append("--, VSL_CD||SKD_VOY_NO||SKD_DIR_CD||TRO_BKG_NO||TRO_BKG_NO_SPLIT||POL_CD OLD_BKG_INFO" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD||RPAD(TRO_BKG_NO, 13)||POL_CD OLD_BKG_INFO" ).append("\n"); 
		query.append("FROM BKG_TRO" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("AND RTN_TRO_FLG  = @[rtn_tro_flg]" ).append("\n"); 
		query.append("AND TRO_SEQ      = @[tro_seq])," ).append("\n"); 
		query.append("/* GET RETURN CY */" ).append("\n"); 
		query.append("(SELECT RPAD(NVL(SUBSTR(RTN_LOC_CD, 3, 3), '   '), 3)||RPAD(NVL(SUBSTR(RTN_YD_CD, 6, 2), '  '), 2) X_RETURN_CY" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("AND RTN_TRO_FLG  = @[rtn_tro_flg]" ).append("\n"); 
		query.append("AND TRO_SEQ      = @[tro_seq]" ).append("\n"); 
		query.append("AND ROWNUM       = 1)" ).append("\n"); 
		query.append("WHERE BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO       = CNTC.BKG_NO" ).append("\n"); 
		query.append("AND 'BK'			   = CNTC.BKG_CNTC_PSON_TP_CD" ).append("\n"); 

	}
}