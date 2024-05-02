/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.08.06 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DG_CGO 테이블에서 EDI로 전송할 정보를 조회한다
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL").append("\n"); 
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
		query.append("SELECT DG.IMDG_UN_NO AS UNBR" ).append("\n"); 
		query.append("      ,DG.IMDG_CLSS_CD AS CLAS" ).append("\n"); 
		query.append("      ,IMDG.IMDG_PCK_DESC AS DG_DESC" ).append("\n"); 
		query.append("      ,DG.PRP_SHP_NM AS PROPER_NM" ).append("\n"); 
		query.append("      ,DG.HZD_DESC AS TECH_NM" ).append("\n"); 
		query.append("      ,(SELECT   SA.APRO_REF_NO" ).append("\n"); 
		query.append("		  FROM   SCG_APRO_RQST      SAR" ).append("\n"); 
		query.append("			  ,  SCG_VVD_APRO_RQST  SVAR" ).append("\n"); 
		query.append("			  ,  SCG_AUTHORIZATION  SA" ).append("\n"); 
		query.append("			  ,  BKG_VVD			BV" ).append("\n"); 
		query.append("	     WHERE    1 = 1" ).append("\n"); 
		query.append("		   AND    SAR.BKG_NO           = SVAR.BKG_NO" ).append("\n"); 
		query.append("		   AND    SAR.BKG_NO           = BV.BKG_NO" ).append("\n"); 
		query.append("		   AND    SAR.SPCL_CGO_APRO_RQST_SEQ = SVAR.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("		   AND    SAR.SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("		   AND    SAR.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("		   AND    SVAR.BKG_NO           = SA.BKG_NO" ).append("\n"); 
		query.append("		   AND    SVAR.SPCL_CGO_APRO_RQST_SEQ = SA.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("		   AND    SVAR.BKG_NO           = DG.BKG_NO" ).append("\n"); 
		query.append("		   AND    SVAR.VSL_CD           = BV.VSL_CD" ).append("\n"); 
		query.append("		   AND    SVAR.SKD_VOY_NO       = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("		   AND    SVAR.SKD_DIR_CD       = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("		   AND    BV.VSL_PRE_PST_CD||BV.VSL_SEQ = (SELECT MIN(BV1.VSL_PRE_PST_CD||BV1.VSL_SEQ) FROM BKG_VVD BV1 WHERE BV1.BKG_NO = BV.BKG_NO)" ).append("\n"); 
		query.append("		   AND    SA.SPCL_CGO_AUTH_SEQ= (SELECT   MAX(SAM.SPCL_CGO_AUTH_SEQ)" ).append("\n"); 
		query.append("                            			   FROM    SCG_AUTHORIZATION SAM" ).append("\n"); 
		query.append("                               			  WHERE    SAM.BKG_NO         = SA.BKG_NO" ).append("\n"); 
		query.append("                               				AND    SAM.SPCL_CGO_APRO_RQST_SEQ = SA.SPCL_CGO_APRO_RQST_SEQ)  " ).append("\n"); 
		query.append("           AND      ROWNUM = 1) AS DG_APPROVAL" ).append("\n"); 
		query.append("      ,DG.EMER_CNTC_PHN_NO_CTNT AS PHON" ).append("\n"); 
		query.append("      ,DG.FLSH_PNT_CDO_TEMP AS FPNT" ).append("\n"); 
		query.append("      ,'C' AS FPUN" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(DG.DIFF_RMK, CHR(13), ' '), CHR(10), ' ') AS DG_REMARK" ).append("\n"); 
		query.append("      ,DG.EMS_NO AS EMSNO" ).append("\n"); 
		query.append("      ,DG.PSA_NO AS PSACLS" ).append("\n"); 
		query.append("      ,DG.IMDG_PCK_GRP_CD AS PKGGRP" ).append("\n"); 
		query.append("      ,DG.MRN_POLUT_FLG AS MAR_POLL" ).append("\n"); 
		query.append("      ,DG.HZD_DESC AS HAZ_CONT" ).append("\n"); 
		query.append("      ,DG.IMDG_LMT_QTY_FLG AS IMO_LIMIT" ).append("\n"); 
		query.append("      ,DG.PRP_SHP_NM AS PRP_SHP_NM" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("      ,BKG_DG_CGO       DG" ).append("\n"); 
		query.append("      ,SCG_IMDG_PCK_CD  IMDG" ).append("\n"); 
		query.append(" WHERE ORD.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND DG.BKG_NO = ORD.BKG_NO" ).append("\n"); 
		query.append("   AND NVL(DG.CNTR_NO, 'X') =  NVL2(DG.CNTR_NO, NVL(ORD.EQ_NO, DG.CNTR_NO), 'X')" ).append("\n"); 
		query.append("   AND DG.CNTR_TPSZ_CD = ORD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("   AND DG.OUT_IMDG_PCK_CD1 = IMDG.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("   AND IMDG.DELT_FLG(+) = 'N'" ).append("\n"); 

	}
}