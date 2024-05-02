/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BangladeshManifestListDownloadDBDAOsearchManifestObDlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshManifestListDownloadDBDAOsearchManifestObDlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 방글라데시 Manifest Outbound D/L(DownLoad한) List 조회
	  * </pre>
	  */
	public BangladeshManifestListDownloadDBDAOsearchManifestObDlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration").append("\n"); 
		query.append("FileName : BangladeshManifestListDownloadDBDAOsearchManifestObDlListRSQL").append("\n"); 
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
		query.append("SELECT 	BL_LINE_NO SL_NO," ).append("\n"); 
		query.append("  		TZ_DESC TR_NO," ).append("\n"); 
		query.append("		to_char(to_date(TZ_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') TR_DATE," ).append("\n"); 
		query.append("  		BIL_RMK SBILL_NO," ).append("\n"); 
		query.append("		to_char(to_date(BIL_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') SB_DATE," ).append("\n"); 
		query.append("  		XPT_DESC EXP_NO," ).append("\n"); 
		query.append("		to_char(to_date(XPT_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') EXP_DATE," ).append("\n"); 
		query.append(" 	 	POD_NM POD_NM," ).append("\n"); 
		query.append("  		MK_DESC MARK_NO," ).append("\n"); 
		query.append("  		NVL(BKG_CNTR_QTY,0) PACK_NO," ).append("\n"); 
		query.append("  		PCK_DESC PACK_NAT," ).append("\n"); 
		query.append("  		CSTMS_DESC GOODS_DESC," ).append("\n"); 
		query.append("  		TRIM(TO_CHAR(NVL(CNTR_WGT,0),'999999999.99'))||' '||WGT_UT_CD GROSS_WGT," ).append("\n"); 
		query.append("  		CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("  		MLT_CNTR_SEAL_NO_DESC SEAL," ).append("\n"); 
		query.append("  		CNTR_SZ_DESC CNTR_SIZE," ).append("\n"); 
		query.append("  		DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'D', 'DRY', 'F', 'FLAT', 'O', 'OPEN', 'P', 'PLATFORM', 'R', 'REFFER', 'T', 'TANK', 'Z', 'OTHER', 'Q', 'DEAD', 'S', 'SLIDING', 'A', 'ADJUST', ' ') CNTR_TYPE," ).append("\n"); 
		query.append("  		DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', '8.6', '4', '9.6', '5', '9.6', '9', '9.6', ' ') HEIGHT," ).append("\n"); 
		query.append("        ( SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("              ,     DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("              ,         DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0) " ).append("\n"); 
		query.append("              ,            MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("              ,         S.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("           FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("          WHERE M.CNTR_NO           =   CNTR.CNTR_NO" ).append("\n"); 
		query.append("            AND M.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("            AND M.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD ) WEIGHT," ).append("\n"); 
		query.append("  		BD_CNTR_CGO_TP_CD STATUS," ).append("\n"); 
		query.append("  		IMO_DESC IMCO," ).append("\n"); 
		query.append(" 		IMDG_UN_DESC UN," ).append("\n"); 
		query.append("  		VAT_DESC VAT," ).append("\n"); 
		query.append("  		CMDT_DESC CMDT_CD," ).append("\n"); 
		query.append("  		FDCK_DESC OFF_DOCK," ).append("\n"); 
		query.append("  		PRSB_CD PERISH_CD," ).append("\n"); 
		query.append("  		SHPR_RMK SHIPPER_NM," ).append("\n"); 
		query.append("  		CNEE_RMK CNEE_NM," ).append("\n"); 
		query.append("  		BL_NO ORG_BL_NO," ).append("\n"); 
		query.append("  		CNTR_TPSZ_CD CNTR_TZ," ).append("\n"); 
		query.append("  		POL_CD POL_CD," ).append("\n"); 
		query.append("  		POD_CD POD_CD," ).append("\n"); 
		query.append("  		TRIM(to_char(NVL(CNTR_WGT,'0'), '99999999.99')) CNTR_WGT," ).append("\n"); 
		query.append("  		WGT_UT_CD CNTR_UT_CD," ).append("\n"); 
		query.append("  		BKG_CGO_TP_CD BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  		VSL_NM VSL_NM," ).append("\n"); 
		query.append("  		DECODE(SUBSTR(SKD_VOY_NO,1,2),'00', SUBSTR(SKD_VOY_NO,2,3), SKD_VOY_NO) VOY_NO," ).append("\n"); 
		query.append("		VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_BD_CNTR CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD 								= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("  	AND SKD_VOY_NO 							= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  	AND SKD_DIR_CD 							= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append(" 	AND POL_CD 								= @[pol_code]" ).append("\n"); 
		query.append("  	AND BD_CSTMS_BND_CD 					= 'O'" ).append("\n"); 
		query.append("#if (${pod_code} != '') " ).append("\n"); 
		query.append("    AND POD_CD      						like @[pod_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("	AND BL_NO							  	like @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_code} != 'A') " ).append("\n"); 
		query.append("	AND DECODE(BKG_CGO_TP_CD,'P','P','F') 	= @[bkg_cgo_tp_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BL_LINE_NO" ).append("\n"); 

	}
}