/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchAuthSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchAuthSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserAuthListModiVO
	  * * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 
	  * * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchAuthSetupListRSQL(){
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
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchAuthSetupListRSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD" ).append("\n"); 
		query.append("      ,A.BL_VVD" ).append("\n"); 
		query.append("      ,A.BL_POD" ).append("\n"); 
		query.append("      ,A.BL_DEL" ).append("\n"); 
		query.append("      ,A.BL_HUB" ).append("\n"); 
		query.append("	  ,A.BL_CSTMS" ).append("\n"); 
		query.append("      ,A.BL_MIB" ).append("\n"); 
		query.append("      ,A.BL_FPO" ).append("\n"); 
		query.append("      ,A.BL_PTT" ).append("\n"); 
		query.append("      ,A.BL_FTZ" ).append("\n"); 
		query.append("      ,A.BL_DIV" ).append("\n"); 
		query.append("      ,A.MI_HUB" ).append("\n"); 
		query.append("	  ,A.MI_CSTMS" ).append("\n"); 
		query.append("      ,A.MI_MULTI" ).append("\n"); 
		query.append("      ,A.OF_MIT" ).append("\n"); 
		query.append("      ,A.OF_HIS" ).append("\n"); 
		query.append("      ,A.USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,A.USR_NM" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.COFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT AUTH.CNT_CD CNT_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIVVDY', 1, 0)) AS BL_VVD" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIPODY', 1, 0)) AS BL_POD" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIDELY', 1, 0)) AS BL_DEL" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIHUBY', 1, 0)) AS BL_HUB" ).append("\n"); 
		query.append("			  ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLICSTMSY', 1, 0)) AS BL_CSTMS" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIMIBY', 1, 0)) AS BL_MIB" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIFPOY', 1, 0)) AS BL_FPO" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIPTTY', 1, 0)) AS BL_PTT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIFTZY', 1, 0)) AS BL_FTZ" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'BLIDIVY', 1, 0)) AS BL_DIV" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'MIBHUBY', 1, 0)) AS MI_HUB" ).append("\n"); 
		query.append("			  ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'MIBCSTMSY', 1, 0)) AS MI_CSTMS" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'MIMULTIY', 1, 0)) AS MI_MULTI" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'OFMMITY', 1, 0)) AS OF_MIT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AUTH.PROC_ID || AUTH.ACT_ID || AUTH.CSTMS_AUTH_FLG, 'OFMHISY', 1, 0)) AS OF_HIS" ).append("\n"); 
		query.append("              ,AUTH.USR_ID USR_ID" ).append("\n"); 
		query.append("              ,MAX(AUTH.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("              ,MAX(TO_CHAR(AUTH.CRE_DT,'yyyy-mm-dd hh24:mi:ss')) CRE_DT" ).append("\n"); 
		query.append("              ,MAX(AUTH.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("              ,MAX(TO_CHAR(AUTH.UPD_DT,'yyyy-mm-dd hh24:mi:ss')) UPD_DT" ).append("\n"); 
		query.append("              ,USR.USR_NM USR_NM" ).append("\n"); 
		query.append("              ,USR.OFC_CD OFC_CD" ).append("\n"); 
		query.append("              ,MAX(CUSR.OFC_CD) COFC_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_COM_USR_AUTH AUTH,COM_USER USR,COM_USER CUSR" ).append("\n"); 
		query.append("         WHERE AUTH.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND AUTH.USR_ID = USR.USR_ID(+)" ).append("\n"); 
		query.append("           AND AUTH.CRE_USR_ID = CUSR.USR_ID(+)" ).append("\n"); 
		query.append("    #if (${usr_id} != '')" ).append("\n"); 
		query.append("           AND AUTH.USR_ID like '%' || @[usr_id] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${usr_nm} != '')" ).append("\n"); 
		query.append("           AND USR.USR_NM like '%' || @[usr_nm] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("           AND USR.OFC_CD like '%' || @[ofc_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      GROUP BY AUTH.USR_ID,AUTH.CNT_CD,USR.USR_NM,USR.OFC_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("ORDER BY A.USR_ID" ).append("\n"); 

	}
}