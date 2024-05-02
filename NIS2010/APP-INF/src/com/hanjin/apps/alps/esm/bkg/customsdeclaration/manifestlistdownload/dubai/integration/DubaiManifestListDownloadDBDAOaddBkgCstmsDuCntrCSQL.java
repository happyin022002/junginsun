/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrCSQL.java
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

public class DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsPckTpConv
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrCSQL(){
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
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrCSQL").append("\n"); 
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
		query.append("  INTO BKG_CSTMS_DU_CNTR" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       BL_NO" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TARE_WGT" ).append("\n"); 
		query.append("      ,CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT C.BL_NO" ).append("\n"); 
		query.append("             ,C.POD_CD" ).append("\n"); 
		query.append("             ,C.CNTR_NO" ).append("\n"); 
		query.append("             ,ROUND(C.CNTR_TARE_WGT/1000, 1) AS CNTR_TARE_WGT" ).append("\n"); 
		query.append("             ,S.CNTR_SEAL_NO" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("	            SELECT B.BL_NO" ).append("\n"); 
		query.append("	                  ,B.BKG_NO" ).append("\n"); 
		query.append("	                  ,B.POD_CD" ).append("\n"); 
		query.append("	                  ,C.CNTR_NO" ).append("\n"); 
		query.append("	                  ,DECODE(NVL(S.TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("	                          DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0 ," ).append("\n"); 
		query.append("	                                 DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT) " ).append("\n"); 
		query.append("	                   AS CNTR_TARE_WGT" ).append("\n"); 
		query.append("	              FROM (" ).append("\n"); 
		query.append("	                    SELECT B.BKG_NO, B.BL_NO, V.POD_CD" ).append("\n"); 
		query.append("	                      FROM BKG_BOOKING B" ).append("\n"); 
		query.append("	                          ,BKG_VVD V" ).append("\n"); 
		query.append("	                     WHERE B.BKG_NO =V.BKG_NO" ).append("\n"); 
		query.append("	                       AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("	                       AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("	                   #if (${bl_no} != '') " ).append("\n"); 
		query.append("	                       AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	                       AND V.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("	                   #end" ).append("\n"); 
		query.append("	                   #if (${vvd} != '') " ).append("\n"); 
		query.append("	                       AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	                       AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	                       AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	                   #end" ).append("\n"); 
		query.append("	                   #if (${pol_cd} != '') " ).append("\n"); 
		query.append("	                       AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	                   #end" ).append("\n"); 
		query.append("	                   #if (${pod_cd} != '') " ).append("\n"); 
		query.append("	                       AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	                   #end" ).append("\n"); 
		query.append("	                   #if (${cgo_type} == 'F') " ).append("\n"); 
		query.append("	                       AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("	                   #elseif (${cgo_type} == 'M') " ).append("\n"); 
		query.append("	                       AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n"); 
		query.append("	                   #end" ).append("\n"); 
		query.append("	                   ) B" ).append("\n"); 
		query.append("	                  ,BKG_CONTAINER C" ).append("\n"); 
		query.append("	                  ,MST_CONTAINER M" ).append("\n"); 
		query.append("	                  ,MST_CNTR_SPEC S" ).append("\n"); 
		query.append("	                  ,MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("	             WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	               AND C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("	               AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("	               AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD(+)      " ).append("\n"); 
		query.append("              ) C" ).append("\n"); 
		query.append("             ,BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("        WHERE C.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("          AND C.CNTR_NO = S.CNTR_NO(+)" ).append("\n"); 
		query.append("          AND (S.CNTR_SEAL_SEQ IS NULL OR" ).append("\n"); 
		query.append("               S.CNTR_SEAL_SEQ = (SELECT MAX(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("                                    FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                   WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                     AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}