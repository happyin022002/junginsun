/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPartnerCBFSpecialList 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL").append("\n"); 
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
		query.append("SELECT   	 MAX (A.VSL_CD) VSL_CD," ).append("\n"); 
		query.append("           MAX (A.SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("           MAX (A.SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("           MAX (A.BKG_SHPR_OWNR_FLG) BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("     			 MAX (A.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("           MAX (A.YD_CD) YD_CD," ).append("\n"); 
		query.append("           MAX (A.POL_CLPT_IND_SEQ) POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("           MAX (A.CBF_SMRY_SEQ) CBF_SMRY_SEQ," ).append("\n"); 
		query.append("					 MAX (A.PRNR_BKG_REF_NO) PRNR_BKG_REF_NO," ).append("\n"); 
		query.append("           MAX (A.CNTR_SEQ) CNTR_SEQ," ).append("\n"); 
		query.append("           MAX (A.CGO_SEQ) CGO_SEQ," ).append("\n"); 
		query.append("           MAX (A.PRNR_CNTR_REF_NO) PRNR_CNTR_REF_NO," ).append("\n"); 
		query.append("           MAX (A.POD_CD||A.POD_CLPT_IND_SEQ) POD_CD," ).append("\n"); 
		query.append("           MAX (A.MLB_CD) MLB_CD," ).append("\n"); 
		query.append("           MAX (A.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           MAX (A.CBF_SPCL_CGO_CATE_CD) CBF_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("		   		 MAX (A.DCGO_FLG) DCGO_FLG," ).append("\n"); 
		query.append("		   		 MAX (A.RC_FLG) RC_FLG," ).append("\n"); 
		query.append("		   		 MAX (A.AWK_CGO_FLG) AWK_CGO_FLG," ).append("\n"); 
		query.append("		   		 MAX (A.BB_CGO_FLG) BB_CGO_FLG," ).append("\n"); 
		query.append("		   		 MAX (A.STWG_CGO_FLG) STWG_CGO_FLG, " ).append("\n"); 
		query.append("           MAX (DECODE(A.CNTR_GRS_WGT,'0','', A.CNTR_GRS_WGT)) CNTR_GRS_WGT," ).append("\n"); 
		query.append("           MAX (A.CGO_GRS_WGT) CGO_GRS_WGT," ).append("\n"); 
		query.append("           MAX (A.IMDG_CLSS_CD) IMDG_CLSS_CD," ).append("\n"); 
		query.append("           MAX (A.IMDG_UN_NO) IMDG_UN_NO," ).append("\n"); 
		query.append("           SUBSTR (" ).append("\n"); 
		query.append("              XMLAGG (" ).append("\n"); 
		query.append("                 XMLELEMENT (X, '/' || S.IMDG_SUBS_RSK_LBL_CD)" ).append("\n"); 
		query.append("                    ORDER BY S.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("              ).EXTRACT ('//text()')," ).append("\n"); 
		query.append("              2" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("              IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("           MAX (A.IMDG_MRN_POLUT_CD) IMDG_MRN_POLUT_CD," ).append("\n"); 
		query.append("           MAX (DECODE(A.PCK_GRP_CD,'1','I','2','II','3','III',A.PCK_GRP_CD)) PCK_GRP_CD," ).append("\n"); 
		query.append("           MAX (A.LMT_QTY_FLG) LMT_QTY_FLG," ).append("\n"); 
		query.append("           MAX (A.EXPT_QTY_FLG) EXPT_QTY_FLG," ).append("\n"); 
		query.append("           MAX (A.FDO_TEMP) FDO_TEMP," ).append("\n"); 
		query.append("           MAX (A.CDO_TEMP) CDO_TEMP," ).append("\n"); 
		query.append("           MAX (A.CBF_CMDT_NM) CBF_CMDT_NM," ).append("\n"); 
		query.append("           MAX (A.DIM_LEN) DIM_LEN," ).append("\n"); 
		query.append("           MAX (A.DIM_WDT) DIM_WDT," ).append("\n"); 
		query.append("           MAX (A.DIM_HGT) DIM_HGT," ).append("\n"); 
		query.append("           MAX (DECODE (A.FWRD_OVR_DIM_LEN, '0', '', A.FWRD_OVR_DIM_LEN)) FWRD_OVR_DIM_LEN," ).append("\n"); 
		query.append("           MAX (DECODE (A.BKWD_OVR_DIM_LEN, '0', '', A.BKWD_OVR_DIM_LEN)) BKWD_OVR_DIM_LEN," ).append("\n"); 
		query.append("           MAX (DECODE (A.LF_SD_OVR_DIM_LEN, '0', '', A.LF_SD_OVR_DIM_LEN)) LF_SD_OVR_DIM_LEN," ).append("\n"); 
		query.append("           MAX (DECODE (A.RT_SD_OVR_DIM_LEN, '0', '', A.RT_SD_OVR_DIM_LEN)) RT_SD_OVR_DIM_LEN," ).append("\n"); 
		query.append("           MAX (DECODE (A.HGT_OVR_DIM_LEN, '0', '', A.HGT_OVR_DIM_LEN)) HGT_OVR_DIM_LEN," ).append("\n"); 
		query.append("    			 MAX (A.CRN_PST_STS_CD) CRN_PST_STS_CD," ).append("\n"); 
		query.append("    			 MAX (A.STWG_N1ST_RMK) STWG_N1ST_RMK," ).append("\n"); 
		query.append("    			 MAX (A.STWG_N2ND_RMK) STWG_N2ND_RMK," ).append("\n"); 
		query.append("           MAX (A.APRO_REF_NO) APRO_REF_NO," ).append("\n"); 
		query.append("           MAX (A.CRN_PST_STS_CD) POST_EXD," ).append("\n"); 
		query.append("           MAX (A.STWG_CD) STWG_CD," ).append("\n"); 
		query.append("           DECODE(MAX(A.SPCL_CGO_AUTH_FLG),'N','',MAX(A.SPCL_CGO_AUTH_FLG)) SPCL_CGO_AUTH_FLG," ).append("\n"); 
		query.append("           MAX (A.CBF_DP_CD) CBF_DP_CD," ).append("\n"); 
		query.append("           MAX (A.SPCL_CGO_SEQ) SPCL_CGO_SEQ," ).append("\n"); 
		query.append("           MAX (B.CBF_IND_FLG) CBF_IND_FLG," ).append("\n"); 
		query.append("           MAX (B.CBF_BKG_STS_CD) CBF_BKG_STS_CD," ).append("\n"); 
		query.append("           MAX (A.CBF_RMK) CBF_RMK," ).append("\n"); 
		query.append("           MAX (B.UPD_USR_ID) UPD_USR_ID," ).append("\n"); 
		query.append("           MAX (TO_CHAR(B.UPD_DT,'YYYY-MM-DD HH24:MI')) UPD_DT," ).append("\n"); 
		query.append("     			 'S' CBF_DP_CD" ).append("\n"); 
		query.append("    FROM   OPF_CGO_BKG_FCAST_CNTR A," ).append("\n"); 
		query.append("           OPF_CGO_BKG_FCAST B," ).append("\n"); 
		query.append("           OPF_CBF_CNTR_IMDG_SUBS_RSK S" ).append("\n"); 
		query.append("   WHERE       A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					 AND A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("					 AND A.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("					 AND A.BKG_SHPR_OWNR_FLG = 'N'" ).append("\n"); 
		query.append("					 AND A.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND B.BKG_SHPR_OWNR_FLG = A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("           AND B.CRR_CD = A.CRR_CD" ).append("\n"); 
		query.append("           AND B.YD_CD = A.YD_CD" ).append("\n"); 
		query.append("           AND B.POL_CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND A.CBF_DP_CD = 'S'" ).append("\n"); 
		query.append("           AND A.VSL_CD = S.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND A.BKG_SHPR_OWNR_FLG = S.BKG_SHPR_OWNR_FLG(+)" ).append("\n"); 
		query.append("           AND A.CRR_CD = S.CRR_CD(+)" ).append("\n"); 
		query.append("           AND A.YD_CD = S.YD_CD(+)" ).append("\n"); 
		query.append("           AND A.CBF_SMRY_SEQ = S.CBF_SMRY_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY   A.VSL_CD," ).append("\n"); 
		query.append("           A.SKD_VOY_NO," ).append("\n"); 
		query.append("           A.SKD_DIR_CD," ).append("\n"); 
		query.append("           A.BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("           A.CRR_CD," ).append("\n"); 
		query.append("           A.YD_CD," ).append("\n"); 
		query.append("           A.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("           A.CBF_SMRY_SEQ" ).append("\n"); 
		query.append("ORDER BY POD_CD,MLB_CD,PRNR_BKG_REF_NO,CNTR_SEQ,CGO_SEQ,PRNR_CNTR_REF_NO,CNTR_TPSZ_CD" ).append("\n"); 

	}
}