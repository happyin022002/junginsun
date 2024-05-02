/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingNumberGenarationDBDAOCheckValidationToyotaBlNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.25 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingNumberGenarationDBDAOCheckValidationToyotaBlNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking number조회
	  * </pre>
	  */
	public BookingNumberGenarationDBDAOCheckValidationToyotaBlNumberRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration").append("\n"); 
		query.append("FileName : BookingNumberGenarationDBDAOCheckValidationToyotaBlNumberRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  	SELECT 2 CHECK_SEQ, 'BL_ISSUE' CHECK_MO, COUNT(*)  --BLOCK" ).append("\n"); 
		query.append(" 	FROM BKG_BL_ISS BBI" ).append("\n"); 
		query.append("  	WHERE BBI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  	AND BBI.OBL_ISS_FLG = 'Y'" ).append("\n"); 
		query.append("  	HAVING COUNT(*)>0" ).append("\n"); 
		query.append("  	UNION ALL" ).append("\n"); 
		query.append("  	SELECT 5 CHECK_SEQ, 'DMT_ISSUE' CHECK_MO, COUNT(*)  --BLOCK  " ).append("\n"); 
		query.append("    FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("   	WHERE (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("         (select SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO" ).append("\n"); 
		query.append("            from dmt_chg_bkg_cntr" ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    AND DMDT_CHG_STS_CD = 'I'" ).append("\n"); 
		query.append("  	HAVING COUNT(*)>0   " ).append("\n"); 
		query.append("  	UNION ALL" ).append("\n"); 
		query.append("  	SELECT 1 CHECK_SEQ, 'BKG_RATE', COUNT(*)" ).append("\n"); 
		query.append("  	FROM BKG_CHG_RT BCR" ).append("\n"); 
		query.append("  	WHERE BCR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  	HAVING COUNT(*)>0" ).append("\n"); 
		query.append("  	UNION ALL" ).append("\n"); 
		query.append("  	SELECT 6 CHECK_SEQ, 'DMT_CHARGE' CHECK_MO, COUNT(*)  --SOFT WARNING" ).append("\n"); 
		query.append("    FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("   	WHERE (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("         (select SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO" ).append("\n"); 
		query.append("            from dmt_chg_bkg_cntr" ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("  	HAVING COUNT(*)>0   " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT 3 CHECK_SEQ, 'already downloaded', COUNT(*)" ).append("\n"); 
		query.append("	--china" ).append("\n"); 
		query.append("	from (" ).append("\n"); 
		query.append("	SELECT DISTINCT AA.BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_CHN_BL AA" ).append("\n"); 
		query.append("	WHERE AA.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	MINUS" ).append("\n"); 
		query.append("	SELECT DISTINCT a.bl_no" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_CHN_BL A," ).append("\n"); 
		query.append("	  BKG_CSTMS_CHN_SND_LOG_BL B," ).append("\n"); 
		query.append("	  BKG_CSTMS_CHN_SND_LOG C" ).append("\n"); 
		query.append("	WHERE A.BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("	AND A.Bl_no          = B.Bl_no" ).append("\n"); 
		query.append("	AND b.EDI_REF_ID     = c.EDI_REF_ID" ).append("\n"); 
		query.append("	AND c.TRSM_MSG_TP_ID = '3'" ).append("\n"); 
		query.append("	--japan(24)" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT DISTINCT AA.BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_JP_BL AA" ).append("\n"); 
		query.append("	WHERE AA.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	MINUS" ).append("\n"); 
		query.append("	SELECT DISTINCT a.bl_no" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_JP_SND_LOG A" ).append("\n"); 
		query.append("	WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("	AND a.JP_SND_LOG_ID = 'CMR'" ).append("\n"); 
		query.append("	AND a.LOG_SEQ       = 1" ).append("\n"); 
		query.append("	--Australia" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_AUS_SND_LOG" ).append("\n"); 
		query.append("	WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND rownum  = 1" ).append("\n"); 
		query.append("	--Bangladesh" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_BD_CNTR" ).append("\n"); 
		query.append("	WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND rownum  = 1" ).append("\n"); 
		query.append("	--India" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_IDA_BL" ).append("\n"); 
		query.append("	WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND rownum  = 1" ).append("\n"); 
		query.append("	--Japan" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("	WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND JP_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("	AND rownum  = 1" ).append("\n"); 
		query.append("	--Korea" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("	WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND rownum  = 1 " ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- US" ).append("\n"); 
		query.append("	SELECT BL_NO" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND CNT_CD     = 'US'" ).append("\n"); 
		query.append("	AND MF_STS_CD <> 'D'" ).append("\n"); 
		query.append("	AND BL_NO      = @[bl_no] " ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	--BR" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_BRZ_BL WHERE BL_NO = @[bl_no] " ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- BE" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_ANR_BL WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- NL" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_RTM_BL WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- EU DG" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_EUR_DG WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- ENS" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_EUR_BL WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- EXS" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_EUR_IO_BL WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- CA" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_ADV_BL WHERE 1= 1 AND CNT_CD = 'CA' AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	-- AR" ).append("\n"); 
		query.append("	SELECT BL_NO FROM BKG_CSTMS_ARG_BL WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	HAVING COUNT(*)>0       " ).append("\n"); 
		query.append("ORDER BY CHECK_SEQ        " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}