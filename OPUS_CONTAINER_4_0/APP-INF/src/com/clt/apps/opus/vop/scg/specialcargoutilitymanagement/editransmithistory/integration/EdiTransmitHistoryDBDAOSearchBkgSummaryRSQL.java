/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EdiTransmitHistoryDBDAOSearchBkgSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiTransmitHistoryDBDAOSearchBkgSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EdiTransmitHistoryDBDAOSearchBkgSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration").append("\n"); 
		query.append("FileName : EdiTransmitHistoryDBDAOSearchBkgSummaryRSQL").append("\n"); 
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
		query.append("SELECT ROW_NUMBER() OVER(PARTITION BY EDI_MSG_STS_CD, LST_RQST_DAT_FLG ORDER BY LST_RQST_DAT_FLG DESC, IF_DATE DESC, CNTR_SEQ, CGO_SEQ) SEQ" ).append("\n"); 
		query.append("     ----, RANK() OVER(PARTITION BY DCGO_REF_NO ORDER BY LST_RQST_DAT_FLG DESC, IF_DATE DESC, CNTR_SEQ, CGO_SEQ) RANK_SEQ" ).append("\n"); 
		query.append("	 , DENSE_RANK() OVER(PARTITION BY BKG_REF_NO ORDER BY NVL(LST_RQST_DAT_FLG,'A') DESC, PRNR_SPCL_CGO_SEQ DESC) RANK_SEQ" ).append("\n"); 
		query.append("     , BKG_REF_NO" ).append("\n"); 
		query.append("     , EDI_MSG_STS_CD" ).append("\n"); 
		query.append("     , DCGO_REF_NO" ).append("\n"); 
		query.append("     , LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("     , PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     , IMDG_UN_NO_CTNT" ).append("\n"); 
		query.append("     , IMDG_CLSS_CD_CTNT" ).append("\n"); 
		query.append("     , DECODE(IMDG_PCK_GRP_CD_CTNT,'1','I','2','II','3','III','')	AS IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("     , PRP_SHP_NM" ).append("\n"); 
		query.append("     , DCGO_STS_CD_CTNT" ).append("\n"); 
		query.append("     , CGO_SEQ" ).append("\n"); 
		query.append("     , CNTR_SEQ" ).append("\n"); 
		query.append("     , GRS_WGT_CTNT" ).append("\n"); 
		query.append("     , NET_WGT_CTNT" ).append("\n"); 
		query.append("     , IF_DATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT HDR.BKG_REF_NO" ).append("\n"); 
		query.append("     , HDR.EDI_MSG_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --::2015-05-30::--, DTL.REF_NO" ).append("\n"); 
		query.append("     , DTL.DCGO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RQS.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("     , DTL.IMDG_UN_NO_CTNT" ).append("\n"); 
		query.append("     , DTL.IMDG_CLSS_CD_CTNT" ).append("\n"); 
		query.append("     , DTL.IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("     , DTL.PRP_SHP_NM" ).append("\n"); 
		query.append("     , DTL.DCGO_STS_CD_CTNT" ).append("\n"); 
		query.append("     , DTL.CGO_SEQ" ).append("\n"); 
		query.append("     , DTL.CNTR_SEQ" ).append("\n"); 
		query.append("     , DTL.GRS_WGT_CTNT" ).append("\n"); 
		query.append("     , DTL.NET_WGT_CTNT" ).append("\n"); 
		query.append("     , DTL.UPD_DT IF_DATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , RQS.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("	 , HDR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" FROM SCG_PRNR_SPCL_CGO_TRSM_HDR HDR" ).append("\n"); 
		query.append("    , SCG_PRNR_SPCL_CGO_TRSM_DTL DTL" ).append("\n"); 
		query.append("    , SCG_PRNR_APRO_RQST         RQS" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND HDR.TRSM_MZD_CD        = 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append("   AND HDR.BKG_REF_NO         = @[bkg_ref_no]" ).append("\n"); 
		query.append("   AND HDR.TRSM_BND_CD        = 'I'" ).append("\n"); 
		query.append("   AND HDR.TRSM_BND_CD        = DTL.TRSM_BND_CD" ).append("\n"); 
		query.append("   AND HDR.TRSM_DT            = DTL.TRSM_DT" ).append("\n"); 
		query.append("   AND HDR.SPCL_CGO_CATE_CD   = DTL.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("   AND HDR.PRNR_SPCL_CGO_SEQ  = DTL.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("   AND HDR.TRSM_BND_CD        = RQS.MAPG_TRSM_BND_CD			(+)" ).append("\n"); 
		query.append("   AND HDR.TRSM_DT            = RQS.MAPG_TRSM_DT				(+)" ).append("\n"); 
		query.append("   AND HDR.SPCL_CGO_CATE_CD   = RQS.MAPG_TRSM_SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("   AND HDR.PRNR_SPCL_CGO_SEQ  = RQS.MAPG_PRNR_SPCL_CGO_SEQ		(+)" ).append("\n"); 
		query.append("   )A" ).append("\n"); 
		query.append("----ORDER BY NVL(LST_RQST_DAT_FLG, 1) DESC, IF_DATE DESC, CNTR_SEQ, CGO_SEQ" ).append("\n"); 
		query.append("	ORDER BY NVL(LST_RQST_DAT_FLG,'A') DESC, PRNR_SPCL_CGO_SEQ DESC, CNTR_SEQ ASC, CGO_SEQ ASC" ).append("\n"); 

	}
}