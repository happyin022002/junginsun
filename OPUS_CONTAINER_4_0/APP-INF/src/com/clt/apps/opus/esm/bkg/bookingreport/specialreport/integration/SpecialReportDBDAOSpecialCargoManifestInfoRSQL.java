/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialReportDBDAOSpecialCargoManifestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOSpecialCargoManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpecialCargoManifestInfo
	  * </pre>
	  */
	public SpecialReportDBDAOSpecialCargoManifestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOSpecialCargoManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       @[pol_cd] AS POL_CD," ).append("\n"); 
		query.append("       @[pod_cd] AS POD_CD," ).append("\n"); 
		query.append("       @[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("       @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("       @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("       @[pol_yd_cd] AS POL_YD_CD," ).append("\n"); 
		query.append("       @[pod_yd_cd] AS POD_YD_CD," ).append("\n"); 
		query.append("       REPLACE(TRANSLATE(NVL(SP.VSL_ENG_NM,' '),CHR(10),' '),CHR(34),' ') AS VESSEL_NAME," ).append("\n"); 
		query.append("       NVL((SELECT REPLACE(SUBSTR(NVL(CNT.CNT_NM,' '),1,20),CHR(34),' ') FROM MDM_COUNTRY CNT WHERE CNT.CNT_CD = SP.VSL_FLG),'') AS NATIONALITY," ).append("\n"); 
		query.append("       NVL((SELECT NVL((SELECT REPLACE(SUBSTR(NVL(CNT_NM,' '),1,20),CHR(34),' ') FROM MDM_COUNTRY WHERE CNT_CD = VSL.VSL_RGST_CNT_CD),'') FROM MDM_VSL_CNTR VSL WHERE VSL_CD = SP.VSL_CD),'') AS VSL_RGST_CNT_NM," ).append("\n"); 
		query.append("       NVL((SELECT LLOYD_NO FROM MDM_VSL_CNTR VSL WHERE VSL_CD = SP.VSL_CD),'') AS LLOYD_NO," ).append("\n"); 
		query.append("       NVL(SP.VSL_OFFCL_NO,' ') AS OFFICIAL_NO," ).append("\n"); 
		query.append("       NVL(SP.VSL_CALL_SIGN,' ') AS CALL_SIGN," ).append("\n"); 
		query.append("#if ('OUT' == ${io_bnd_cd} )" ).append("\n"); 
		query.append("	(SELECT VSK.OB_CSSM_VOY_NO FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("								    WHERE 1=1" ).append("\n"); 
		query.append("									  AND SP.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("									  AND SP.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("									  AND SP.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("									  AND SP.VVD_POL = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("--									  AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("									  AND ROWNUM =1 ) AS VOYAGE_NO, " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        (SELECT VSK.IB_CSSM_VOY_NO FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("								    WHERE 1=1" ).append("\n"); 
		query.append("									  AND SP.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("									  AND SP.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("									  AND SP.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("									  AND SP.VVD_POD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("--									  AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("									  AND ROWNUM =1 ) AS VOYAGE_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       'FULL CONTAINER SHIP' AS KIND_OF_SHIP," ).append("\n"); 
		query.append("       NVL2(@[pol_cd],REPLACE(TRANSLATE(NVL(SP.POL_DESC, ' '),CHR(10), ' '), CHR(34), ' ')||'   '||" ).append("\n"); 
		query.append("       (SELECT NVL(YD.YD_NM, ' ') FROM MDM_YARD YD WHERE SP.VVD_POL || SUBSTR(SP.POL_YD_CD,6,2) = YD.YD_CD),NULL) AS POL_NAME," ).append("\n"); 
		query.append("       NVL2(@[pod_cd],REPLACE(TRANSLATE(NVL(SP.POD_DESC, ' '),CHR(10), ' '), CHR(34), ' ')||'   '||" ).append("\n"); 
		query.append("       (SELECT NVL(YD.YD_NM, ' ') FROM MDM_YARD YD WHERE SP.VVD_POD || SUBSTR(SP.POD_YD_CD,6,2) = YD.YD_CD),NULL) AS POD_NAME," ).append("\n"); 
		query.append("	   SP.DEL_CD AS DEL_NAME" ).append("\n"); 
		query.append("FROM   BKG_SP_V SP" ).append("\n"); 
		query.append("WHERE  SP.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SP.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SP.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (''!=${pol_cd})" ).append("\n"); 
		query.append("AND    SP.VVD_POL LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("AND    NVL(SUBSTR(SP.POL_YD_CD,6,2),' ') LIKE @[pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${pod_cd})" ).append("\n"); 
		query.append("AND    SP.VVD_POD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("AND    NVL(SUBSTR(SP.POD_YD_CD,6,2),' ') LIKE @[pod_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       @[pol_cd] AS POL_CD" ).append("\n"); 
		query.append("       , @[pod_cd] AS POD_CD" ).append("\n"); 
		query.append("       , @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("       , @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("       , @[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("       , @[pol_yd_cd] AS POL_YD_CD" ).append("\n"); 
		query.append("       , @[pod_yd_cd] AS POD_YD_CD" ).append("\n"); 
		query.append("       , REPLACE(TRANSLATE(NVL(VSL.VSL_ENG_NM,' '),CHR(10),' '),CHR(34),' ') AS VESSEL_NAME" ).append("\n"); 
		query.append("       , NVL((SELECT REPLACE(SUBSTR(NVL(CNT.CNT_NM,' '),1,20),CHR(34),' ') FROM MDM_COUNTRY CNT WHERE CNT.CNT_CD = VSL.VSL_RGST_CNT_CD),'') AS NATIONALITY" ).append("\n"); 
		query.append("       , NVL((SELECT REPLACE(SUBSTR(NVL(CNT.CNT_NM,' '),1,20),CHR(34),' ') FROM MDM_COUNTRY CNT WHERE CNT.CNT_CD = VSL.VSL_RGST_CNT_CD),'') AS VSL_RGST_CNT_NM" ).append("\n"); 
		query.append("       , VSL.LLOYD_NO" ).append("\n"); 
		query.append("       , VSL.RGST_NO AS OFFICAL_NO" ).append("\n"); 
		query.append("       , VSL.CALL_SGN_NO AS CALL_SIGN" ).append("\n"); 
		query.append("#if ('OUT' == ${io_bnd_cd} )" ).append("\n"); 
		query.append("	   , (SELECT VSK.OB_CSSM_VOY_NO FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("								    WHERE 1=1" ).append("\n"); 
		query.append("									  AND RQST.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("									  AND RQST.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("									  AND RQST.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("									  AND RQST.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("--									  AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("									  AND ROWNUM =1 ) AS VOYAGE_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , (SELECT VSK.IB_CSSM_VOY_NO FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("								    WHERE 1=1" ).append("\n"); 
		query.append("									  AND RQST.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("									  AND RQST.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("									  AND RQST.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("									  AND RQST.POD_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("--									  AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("									  AND ROWNUM =1 ) AS VOYAGE_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,'FULL CONTAINER SHIP' AS KIND_OF_SHIP" ).append("\n"); 
		query.append("       ,'' AS POL_NAME" ).append("\n"); 
		query.append("       ,'' AS POD_NAME" ).append("\n"); 
		query.append("	   ,'' AS DEL_NAME" ).append("\n"); 
		query.append("FROM   SCG_IMDG_UN_NO SCG," ).append("\n"); 
		query.append("       MDM_CNTR_TP_SZ TPSZ," ).append("\n"); 
		query.append("       MDM_PCK_TP PCK," ).append("\n"); 
		query.append("       SCG_PRNR_APRO_RQST RQST, " ).append("\n"); 
		query.append("       SCG_PRNR_APRO_RQST_CGO CGO, " ).append("\n"); 
		query.append("       MDM_LOCATION POL, " ).append("\n"); 
		query.append("       MDM_LOCATION POD," ).append("\n"); 
		query.append("       MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    CGO.IMDG_UN_NO = SCG.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND    CGO.IMDG_UN_NO_SEQ = SCG.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND    CGO.OUT_N2ND_IMDG_PCK_QTY = PCK.PCK_CD(+)" ).append("\n"); 
		query.append("AND    CGO.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND    RQST.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    RQST.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    RQST.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (''!=${pol_cd})" ).append("\n"); 
		query.append("AND    RQST.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${pod_cd})" ).append("\n"); 
		query.append("AND    RQST.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    RQST.CRR_CD = CGO.CRR_CD" ).append("\n"); 
		query.append("AND    RQST.BKG_REF_NO = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("AND    RQST.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND    RQST.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("AND    RQST.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("AND    RQST.VSL_CD = VSL.VSL_CD" ).append("\n"); 

	}
}