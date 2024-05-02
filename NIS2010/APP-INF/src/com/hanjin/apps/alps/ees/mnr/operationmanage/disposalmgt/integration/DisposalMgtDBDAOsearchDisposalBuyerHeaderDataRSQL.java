/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalBuyerHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalBuyerHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalBuyerHeaderData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalBuyerHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyerLocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyerGlobal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyerRHQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalBuyerHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${buyerNoOuterJoinFlg} == 'Y')" ).append("\n"); 
		query.append("        DECODE(A.DISP_NO,NULL,0,1) AS DEL_CHK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		0 AS DEL_CHK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,A.DISP_NO" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ,B.MNR_PRNR_CNT_CD) AS MNR_PRNR_ID" ).append("\n"); 
		query.append("        ,B.MNR_PRNR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,B.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("        ,B.MNR_PRNR_SEQ " ).append("\n"); 
		query.append("        ,B.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("        ,A.OFC_CD" ).append("\n"); 
		query.append("        ,NVL(A.MNR_PRNR_EML,'N') AS MNR_PRNR_EML" ).append("\n"); 
		query.append("        ,NVL(A.PART_AMT,0) AS PART_AMT" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_PART A,MNR_PARTNER B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("#if (${buyerNoOuterJoinFlg} == 'Y')" ).append("\n"); 
		query.append("    A.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    A.DISP_NO(+) = @[disp_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND B.MNR_PRNR_STS_CD = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg} != 'delete')" ).append("\n"); 
		query.append("	AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${buyerNoOuterJoinFlg} == 'Y')" ).append("\n"); 
		query.append("AND A.MNR_PRNR_SEQ  = B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND A.MNR_PRNR_CNT_CD = B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.MNR_PRNR_SEQ(+)  = B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND A.MNR_PRNR_CNT_CD(+) = B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (B.MNR_PRNR_KND_CD IN (@[buyerGlobal], @[buyerRHQ], @[buyerLocal])" ).append("\n"); 
		query.append("--OR  A.DISP_NO IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CRE_SEQ IN (" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP" ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'G'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP " ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'R'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    MPCP.OFC_CD = DECODE(@[rqst_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[rqst_ofc_cd]))" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP --1" ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD  = 'L'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    MPCP.OFC_CD         = DECODE(@[rqst_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, @[rqst_ofc_cd])" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY DECODE(DEL_CHK, 1, 0, 1), DECODE(B.MNR_PRNR_KND_CD, 'G', 1, 'R', 2, 'L', 3), MNR_PRNR_ID, VNDR_LGL_ENG_NM" ).append("\n"); 

	}
}