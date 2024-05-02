/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorManifestListDAOAddEmptyVslInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDAOAddEmptyVslInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddEmptyVslInfo
	  * </pre>
	  */
	public KorManifestListDAOAddEmptyVslInfoCSQL(){
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
		params.put("usa_bnd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDAOAddEmptyVslInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_KR_VVD_SMRY T1" ).append("\n"); 
		query.append("USING	( 	SELECT 	(   SELECT MRN_NO FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n"); 
		query.append("                        WHERE VSL_CD  = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                        AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                        AND IO_BND_CD = DECODE(@[cstms_decl_tp_cd],'I','I','T','I','O')" ).append("\n"); 
		query.append("                        AND PORT_CD = @[port_cd]) 		MRN_NO, /* KRPUS ONLY에서 타 포트 허용 */" ).append("\n"); 
		query.append("                	(   SELECT MRN_CHK_NO FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n"); 
		query.append("                        WHERE VSL_CD  = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                        AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                        AND IO_BND_CD = DECODE(@[cstms_decl_tp_cd],'I','I','T','I','O')" ).append("\n"); 
		query.append("                        AND PORT_CD = @[port_cd]) 		MRN_CHK_NO, /* KRPUS ONLY에서 타 포트 허용 */" ).append("\n"); 
		query.append("                    @[vvd]                          VVD," ).append("\n"); 
		query.append("                	DECODE(@[cstms_decl_tp_cd],'I','I','T','I','O')   OB_DECL_TP_CD," ).append("\n"); 
		query.append("                	(	SELECT 	MAX(TRNS_SEQ) " ).append("\n"); 
		query.append("						FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("					 	WHERE BKG_NO 			= @[bkg_no]" ).append("\n"); 
		query.append("   						AND CSTMS_DECL_TP_CD 	= @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("   						AND DMST_PORT_CD 		= @[port_cd])  VVD_SEQ," ).append("\n"); 
		query.append("                    @[port_cd]                      PORT_CD," ).append("\n"); 
		query.append("					@[usa_bnd_flg]							KR_CSTMS_BND_CD," ).append("\n"); 
		query.append("					(	SELECT 	VSL_ENG_NM" ).append("\n"); 
		query.append("						FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("						WHERE	VSL_CD = SUBSTR(@[vvd],1,4)) VSL_ENG_NM," ).append("\n"); 
		query.append("					(	SELECT 	VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("						FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("						WHERE	VSL_CD = SUBSTR(@[vvd],1,4)) VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("					(	SELECT 	CALL_SGN_NO" ).append("\n"); 
		query.append("						FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("						WHERE	VSL_CD = SUBSTR(@[vvd],1,4)) CALL_SGN_NO," ).append("\n"); 
		query.append("					(	SELECT 	MAX(VPS_ETA_DT) ETA_DT  " ).append("\n"); 
		query.append("                         FROM 	VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                        WHERE 	VSL_CD 		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                          AND 	SKD_VOY_NO 	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                          AND 	SKD_DIR_CD 	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                          AND 	VPS_PORT_CD 	= @[port_cd]" ).append("\n"); 
		query.append("                          AND 	NVL(SKD_CNG_STS_CD,' ') <> 'S') ETA_DT," ).append("\n"); 
		query.append("					(	SELECT 	MAX(VPS_ETD_DT) ETD_DT " ).append("\n"); 
		query.append("                         FROM 	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE 	VSL_CD 		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                          AND 	SKD_VOY_NO 	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                          AND 	SKD_DIR_CD 	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                          AND 	VPS_PORT_CD 	= @[port_cd]" ).append("\n"); 
		query.append("                          AND NVL(SKD_CNG_STS_CD,' ') <> 'S') ETD_DT" ).append("\n"); 
		query.append("        	FROM    DUAL " ).append("\n"); 
		query.append("       	) T2" ).append("\n"); 
		query.append("ON 	(		T1.MRN_NO 		    = T2.MRN_NO" ).append("\n"); 
		query.append("    	AND T1.MRN_CHK_NO 	    = T2.MRN_CHK_NO" ).append("\n"); 
		query.append("        AND T1.VSL_CD           = SUBSTR(T2.VVD,1,4)" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO       = SUBSTR(T2.VVD,5,4)" ).append("\n"); 
		query.append("    	AND T1.SKD_DIR_CD 	    = SUBSTR(T2.VVD,9,1)" ).append("\n"); 
		query.append("    	AND T1.IO_BND_CD 		= T2.OB_DECL_TP_CD " ).append("\n"); 
		query.append("        AND T1.VVD_SEQ          = T2.VVD_SEQ" ).append("\n"); 
		query.append("        AND T1.PORT_CD          = T2.PORT_CD" ).append("\n"); 
		query.append("		AND T1.OB_DECL_TP_CD  	= T2.KR_CSTMS_BND_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (T1.MRN_NO,T1.MRN_CHK_NO,T1.VSL_CD,T1.SKD_VOY_NO,T1.SKD_DIR_CD,T1.PORT_CD,T1.VVD_SEQ,T1.OB_DECL_TP_CD," ).append("\n"); 
		query.append("		T1.IO_BND_CD,T1.VSL_CNT_CD,T1.VSL_NM,T1.KR_VSL_CALL_SGN_CD, T1.ETA_DT, T1.ETD_DT," ).append("\n"); 
		query.append("		T1.CRE_USR_ID,T1.CRE_DT,T1.UPD_USR_ID,T1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(	T2.MRN_NO,T2.MRN_CHK_NO,SUBSTR(T2.VVD,1,4),SUBSTR(T2.VVD,5,4),SUBSTR(T2.VVD,9,1),T2.PORT_CD,T2.VVD_SEQ,T2.KR_CSTMS_BND_CD," ).append("\n"); 
		query.append("        T2.OB_DECL_TP_CD,T2.VSL_RGST_CNT_CD,T2.VSL_ENG_NM,T2.CALL_SGN_NO, T2.ETA_DT, T2.ETD_DT," ).append("\n"); 
		query.append("		@[user_id],SYSDATE,@[user_id],SYSDATE)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("SET 	T1.UPD_USR_ID 	= @[user_id]," ).append("\n"); 
		query.append("    	T1.UPD_DT 		= SYSDATE" ).append("\n"); 

	}
}