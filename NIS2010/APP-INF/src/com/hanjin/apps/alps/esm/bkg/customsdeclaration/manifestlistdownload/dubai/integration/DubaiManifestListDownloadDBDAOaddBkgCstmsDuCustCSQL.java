/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.19 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOaddBkgCstmsDuCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsDuCust
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsDuCustCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCustCSQL").append("\n"); 
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
		query.append("INSERT  " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_DU_CUST" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       BL_NO" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_NM" ).append("\n"); 
		query.append("      ,CUST_ADDR" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT B.BL_NO" ).append("\n"); 
		query.append("             ,V.POD_CD" ).append("\n"); 
		query.append("             ,C.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("             ,CASE WHEN NVL(INSTR(C.CUST_NM, CHR(13)||CHR(10), 1), 0) = 0 THEN SUBSTR(C.CUST_NM, 1, 48)" ).append("\n"); 
		query.append("                   ELSE SUBSTR(SUBSTR(C.CUST_NM, 1, INSTR(C.CUST_NM, CHR(13)||CHR(10), 1, 1)-1), 1, 48)" ).append("\n"); 
		query.append("               END CUST_NM" ).append("\n"); 
		query.append("             ,CASE WHEN NVL(INSTR(C.CUST_NM, CHR(13)||CHR(10), 1), 0) = 0 THEN SUBSTR(C.CUST_ADDR, 1, 240)" ).append("\n"); 
		query.append("                   ELSE SUBSTR(SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(13)||CHR(10), 1, 1)+2) || CHR(13)||C.CUST_ADDR, 1, 240) " ).append("\n"); 
		query.append("               END CUST_ADDR" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("         FROM BKG_BOOKING B" ).append("\n"); 
		query.append("             ,BKG_VVD V" ).append("\n"); 
		query.append("             ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("          AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("          AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("          AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("          AND C.BKG_CUST_TP_CD IN ('S', 'C', 'N')" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("          AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          AND V.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} != '') " ).append("\n"); 
		query.append("          AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("          AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("          AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("          AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("          AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cgo_type} == 'F') " ).append("\n"); 
		query.append("	      AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("	#elseif (${cgo_type} == 'M') " ).append("\n"); 
		query.append("	      AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}