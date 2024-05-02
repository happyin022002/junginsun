/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByMNRStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterByMNRStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterByMNRStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterByMNRStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterByMNRStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER A" ).append("\n"); 
		query.append("SET ( " ).append("\n"); 
		query.append("     LOC_CD" ).append("\n"); 
		query.append("   , SCC_CD" ).append("\n"); 
		query.append("   , LCC_CD" ).append("\n"); 
		query.append("   , ECC_CD" ).append("\n"); 
		query.append("   , RCC_CD" ).append("\n"); 
		query.append("   , SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   , CNMV_YR" ).append("\n"); 
		query.append("   , CNMV_ID_NO" ).append("\n"); 
		query.append("   , CNMV_SEQ" ).append("\n"); 
		query.append("   , CNMV_CYC_NO" ).append("\n"); 
		query.append("   , CNMV_DT" ).append("\n"); 
		query.append("   , CNMV_GDT" ).append("\n"); 
		query.append("   , FULL_FLG" ).append("\n"); 
		query.append("   , CRNT_YD_CD " ).append("\n"); 
		query.append("   , DEST_YD_CD" ).append("\n"); 
		query.append("   , CNMV_STS_CD" ).append("\n"); 
		query.append("   , ACIAC_DIV_CD)" ).append("\n"); 
		query.append(" = (SELECT " ).append("\n"); 
		query.append("            SUBSTR(CM.ORG_YD_CD,0,5) " ).append("\n"); 
		query.append("          , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'SCC')" ).append("\n"); 
		query.append("          , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'LCC')" ).append("\n"); 
		query.append("          , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'ECC')" ).append("\n"); 
		query.append("          , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'RCC')" ).append("\n"); 
		query.append("          , (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               FROM   COM_SYS_AREA_GRP_ID B   " ).append("\n"); 
		query.append("              WHERE SUBSTR(CM.ORG_YD_CD, 1, 2) = B.CNT_CD" ).append("\n"); 
		query.append("                AND B.CO_IND_CD                = 'H'" ).append("\n"); 
		query.append("                AND ROWNUM                     = 1)" ).append("\n"); 
		query.append("          , CM.CNMV_YR       " ).append("\n"); 
		query.append("          , CM.CNMV_ID_NO" ).append("\n"); 
		query.append("          , CM.CNMV_SEQ" ).append("\n"); 
		query.append("          , CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("          , CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("          , GLOBALDATE_PKG.TIME_CONV_FNC ( SUBSTR(CM.ORG_YD_CD, 1, 5), CM.CNMV_EVNT_DT, 'GMT' )" ).append("\n"); 
		query.append("          , NVL(CM.FCNTR_FLG, 'F')" ).append("\n"); 
		query.append("          , CM.ORG_YD_CD" ).append("\n"); 
		query.append("          , CM.DEST_YD_CD" ).append("\n"); 
		query.append("	      , CM.MVMT_STS_CD" ).append("\n"); 
		query.append("          , DECODE(CM.MVMT_STS_CD, 'XX', 'I', 'A')" ).append("\n"); 
		query.append("        FROM  CTM_MOVEMENT CM " ).append("\n"); 
		query.append("           ,  ( SELECT SB.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("                     , MAX(SB.CNMV_YR) AS CNMV_YR" ).append("\n"); 
		query.append("                     , SUBSTR(MAX(SB.CNMV_YR||TO_CHAR(SB.CNMV_ID_NO, '00000')) , - 5) AS CNMV_ID_NO" ).append("\n"); 
		query.append("                     , SUBSTR(MAX(SB.CNMV_YR||TO_CHAR(SB.CNMV_ID_NO, '00000')||TO_CHAR(SB.CNMV_SEQ, '0000')) , - 4) AS CNMV_SEQ" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT SB" ).append("\n"); 
		query.append("                 WHERE SB.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 GROUP BY SB.CNTR_NO) SB                            " ).append("\n"); 
		query.append("        WHERE  A.CNTR_NO        = SB.CNTR_NO" ).append("\n"); 
		query.append("          AND  SB.CNTR_NO       = CM.CNTR_NO" ).append("\n"); 
		query.append("          AND  SB.CNMV_YR       = CM.CNMV_YR" ).append("\n"); 
		query.append("          AND  SB.CNMV_ID_NO    = CM.CNMV_ID_NO" ).append("\n"); 
		query.append("          AND  SB.CNMV_SEQ      = CM.CNMV_SEQ" ).append("\n"); 
		query.append("          AND  ROWNUM           = 1" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("   ,(CNTR_STS_CD,LST_STS_YD_CD,LST_STS_SEQ) " ).append("\n"); 
		query.append("        =(SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("            B.CNTR_STS_CD, B.YD_CD, B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND ROWNUM=1)" ).append("\n"); 
		query.append(" ,(LSTM_CD,AGMT_CTY_CD,AGMT_SEQ,VNDR_SEQ,ONH_FREE_DYS,MIN_ONH_DYS, ONH_CNTR_STS_CD,ONH_DT,ONH_YD_CD,ONH_STS_SEQ) " ).append("\n"); 
		query.append("        = (SELECT LA.LSTM_CD, LA.AGMT_CTY_CD,LA.AGMT_SEQ,LA.VNDR_SEQ, B.RNTL_CHG_FREE_DYS,B.CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("                     B.CNTR_STS_CD,B.CNTR_STS_EVNT_DT,B.YD_CD,B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("           FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                  , LSE_AGREEMENT LA" ).append("\n"); 
		query.append("           WHERE B.AGMT_CTY_CD  = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND   B.AGMT_SEQ     = LA.AGMT_SEQ" ).append("\n"); 
		query.append("           AND   B.CNTR_NO      = A.CNTR_NO" ).append("\n"); 
		query.append("           AND   B.CNTR_STS_SEQ = MST_ONH_STS_SEQ_FNC(A.CNTR_NO))           " ).append("\n"); 
		query.append("#if (${p_type1} == 'N')" ).append("\n"); 
		query.append("	,A.FA_IF_GRP_STS_CD = NULL" ).append("\n"); 
		query.append("	,A.FA_IF_TP_CD = NULL" ).append("\n"); 
		query.append("	,A.FA_IF_STS_CD = NULL" ).append("\n"); 
		query.append("	,A.FA_IF_ERR_MSG = NULL" ).append("\n"); 
		query.append("	,A.FA_IF_DT = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ,A.UPD_DT		= SYSDATE" ).append("\n"); 
		query.append("   ,A.UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE A.CNTR_NO 	= @[cntr_no]" ).append("\n"); 

	}
}