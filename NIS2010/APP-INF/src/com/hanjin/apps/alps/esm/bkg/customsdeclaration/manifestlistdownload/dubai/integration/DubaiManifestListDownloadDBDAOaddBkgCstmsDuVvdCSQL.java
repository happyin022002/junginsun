/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOaddBkgCstmsDuVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsDuVvd
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsDuVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rotn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuVvdCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_DU_VVD" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CLPT_SEQ" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,VSL_NM" ).append("\n"); 
		query.append("      ,DU_LINE_ID" ).append("\n"); 
		query.append("      ,DU_VOY_AGN_ID" ).append("\n"); 
		query.append("      ,DU_ROTN_NO" ).append("\n"); 
		query.append("      ,ETA_DT" ).append("\n"); 
		query.append("      ,DU_MSG_TP_ID" ).append("\n"); 
		query.append("      ,DU_INSTL_NO" ).append("\n"); 
		query.append("      ,DU_MF_SEQ_NO" ).append("\n"); 
		query.append("      ,DU_MRN_NO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT V.VSL_CD" ).append("\n"); 
		query.append("             ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("             ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("             ,V.POD_CD" ).append("\n"); 
		query.append("             ,S.CLPT_SEQ" ).append("\n"); 
		query.append("             ,V.POL_CD" ).append("\n"); 
		query.append("             ,C.VSL_ENG_NM" ).append("\n"); 
		query.append("             ,'SML'" ).append("\n"); 
		query.append("             ,CASE WHEN @[pod_cd] = 'AESHJ' OR @[pod_cd] = 'AEKLF' THEN 'H0533'" ).append("\n"); 
		query.append("                  ELSE 'H0012' END" ).append("\n"); 
		query.append("             ,@[rotn_no]" ).append("\n"); 
		query.append("             ,TO_DATE(@[eta_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("             ,'MFI'" ).append("\n"); 
		query.append("             ,@[instl_no]" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,@[mrn_no]" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT V.VSL_CD" ).append("\n"); 
		query.append("		              ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("		              ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("		              ,V.POD_CD" ).append("\n"); 
		query.append("		              ,MIN(V.POL_CD) AS POL_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                      ,BKG_VVD V" ).append("\n"); 
		query.append("                 WHERE B.BKG_NO =V.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                   AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("               #if (${bl_no} != '') " ).append("\n"); 
		query.append("                   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND V.POD_CD LIKE 'AE%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${vvd} != '') " ).append("\n"); 
		query.append("                   AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                   AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                   AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${cgo_type} == 'F') " ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("               #elseif (${cgo_type} == 'M') " ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("              GROUP BY V.VSL_CD" ).append("\n"); 
		query.append("		              ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("		              ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("		              ,V.POD_CD" ).append("\n"); 
		query.append("               ) V" ).append("\n"); 
		query.append("             ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("             ,MDM_VSL_CNTR C" ).append("\n"); 
		query.append("        WHERE V.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("          AND V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND V.POD_CD = S.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND S.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("          AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}