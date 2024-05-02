/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOaddBlForNCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.19 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOaddBlForNCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L Info를 생성한다. (B/L Creation Indicator = 'N')
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOaddBlForNCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOaddBlForNCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("			(VSL_CALL_REF_NO, 	BKG_NO," ).append("\n"); 
		query.append(" 		 	BL_NO, BL_TP_CD," ).append("\n"); 
		query.append("		 	POR_CD, 	POL_CD, 	POD_CD, 		DEL_CD," ).append("\n"); 
		query.append("		 	PRE_RLY_PORT_CD, 	PST_RLY_PORT_CD, 	BKG_CGO_TP_CD," ).append("\n"); 
		query.append("			SHPR_ADDR,          CNEE_ADDR,             NTFY_ADDR," ).append("\n"); 
		query.append("		 	CRE_USR_ID,UPD_USR_ID,CRE_OFC_CD, UPD_DT, 		CRE_DT,BL_CRE_DT, BDR_FLG,BDR_DT," ).append("\n"); 
		query.append("			ETD_DT,ETA_DT,BKG_TTL_QTY,BKG_TTL_QTY_UT_CD,FRT_TERM_CD," ).append("\n"); 
		query.append("			T1_DOC_CD,SHPR_CNT_CD,SHPR_CUST_SEQ,CNEE_CNT_CD,CNEE_CUST_SEQ," ).append("\n"); 
		query.append("			NTFY_CNT_CD,NTFY_CUST_SEQ," ).append("\n"); 
		query.append("			SHPR_EORI_NO,SHPR_CTY_NM,SHPR_CSTMS_DECL_CNT_CD,SHPR_ZIP_ID,SHPR_ST_NM," ).append("\n"); 
		query.append("			CNEE_EORI_NO,CNEE_CTY_NM,CNEE_CSTMS_DECL_CNT_CD,CNEE_ZIP_ID,CNEE_ST_NM," ).append("\n"); 
		query.append("			NTFY_EORI_NO,NTFY_CTY_NM,NTFY_CSTMS_DECL_CNT_CD,NTFY_ZIP_ID,NTFY_ST_NM," ).append("\n"); 
		query.append("            VSL_CD, SKD_VOY_NO, SKD_DIR_CD)" ).append("\n"); 
		query.append("			SELECT @[crn_number], 	BKG.BKG_NO," ).append("\n"); 
		query.append("				 	 BKG.BL_NO, BKG.BL_TP_CD," ).append("\n"); 
		query.append("				 	 BKG.POR_CD, 	BKG.POL_CD, 	BKG.POD_CD, BKG.DEL_CD," ).append("\n"); 
		query.append("				 	 PRE_RLY_PORT_CD, PST_RLY_PORT_CD, BKG_CGO_TP_CD," ).append("\n"); 
		query.append("					 SUBSTR(S.CUST_NM||'@@'||S.CUST_ADDR,1,300)," ).append("\n"); 
		query.append("					 SUBSTR(C.CUST_NM||'@@'||C.CUST_ADDR,1,300)," ).append("\n"); 
		query.append("					 SUBSTR(N.CUST_NM||'@@'||N.CUST_ADDR,1,300)," ).append("\n"); 
		query.append("				 	 @[user_id], @[user_id],@[ofc_cd], 	sysdate, sysdate, sysdate, BDR_FLG, BDR_DT," ).append("\n"); 
		query.append("					 SKD.VPS_ETD_DT, SKD_NLRTM.VPS_ETA_DT,	DOC.ACT_WGT, DOC.WGT_UT_CD, FRT_TERM_CD," ).append("\n"); 
		query.append("					 DECODE(PST_RLY_PORT_CD, NULL,NULL, 'T')," ).append("\n"); 
		query.append("					 S.CUST_CNT_CD, S.CUST_SEQ," ).append("\n"); 
		query.append("					 C.CUST_CNT_CD, C.CUST_SEQ," ).append("\n"); 
		query.append("					 N.CUST_CNT_CD, N.CUST_SEQ," ).append("\n"); 
		query.append("					 S.EORI_NO,S.CUST_CTY_NM,S.CSTMS_DECL_CNT_CD,S.CUST_ZIP_ID,S.EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("					 C.EORI_NO,C.CUST_CTY_NM,C.CSTMS_DECL_CNT_CD,C.CUST_ZIP_ID,C.EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("					 N.EORI_NO,N.CUST_CTY_NM,N.CSTMS_DECL_CNT_CD,N.CUST_ZIP_ID,N.EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("                     VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("			FROM   BKG_VVD VVD, BKG_BOOKING BKG, BKG_CUSTOMER S, BKG_CUSTOMER C, BKG_CUSTOMER N, BKG_RATE MISC, BKG_BL_DOC DOC," ).append("\n"); 
		query.append("					 (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, MAX(VPS_ETD_DT) VPS_ETD_DT" ).append("\n"); 
		query.append("		  				FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		  				WHERE	SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("		  				AND 	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		  				AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("		  				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		  				AND 	CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("		  				GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD) SKD," ).append("\n"); 
		query.append("					 (SELECT MIN(VPS_ETA_DT) VPS_ETA_DT" ).append("\n"); 
		query.append("		  				FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("						WHERE SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("                        AND 	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		  				AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("		  				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		  				AND 	CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("		  				AND	VPS_PORT_CD = 'NLRTM') SKD_NLRTM" ).append("\n"); 
		query.append("			WHERE	 VVD.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("			AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("			AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("			AND VVD.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("			AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("			AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("			AND BKG.BKG_NO  =  DOC.BKG_NO" ).append("\n"); 
		query.append("			AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("			AND BKG_CGO_TP_CD IN ('F','P','R','B')" ).append("\n"); 
		query.append("			AND BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("			AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("			AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND BKG.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("            AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			AND BKG.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("         	AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("			AND BKG.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("         	AND N.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("			AND BKG.BKG_NO = MISC.BKG_NO(+)" ).append("\n"); 

	}
}