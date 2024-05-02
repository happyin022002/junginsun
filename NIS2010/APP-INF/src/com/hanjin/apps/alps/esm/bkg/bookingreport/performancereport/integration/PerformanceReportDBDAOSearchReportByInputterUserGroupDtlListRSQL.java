/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("list_atnd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupDtlListRSQL").append("\n"); 
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
		query.append("    (SELECT COUNT(*) FROM BKG_SR_HIS WHERE SR_STS_CD = 'RR' AND SR_KND_CD = B.SR_KND_CD" ).append("\n"); 
		query.append("    	AND   SR_NO = B.SR_NO" ).append("\n"); 
		query.append("    	AND   BKG_NO  = B.BKG_NO ) AS RTN_FREQ" ).append("\n"); 
		query.append("    ,(SELECT COUNT(*) FROM BKG_SR_HIS WHERE SR_STS_CD = 'ST' AND SR_KND_CD = B.SR_KND_CD" ).append("\n"); 
		query.append("    	AND   SR_NO = B.SR_NO" ).append("\n"); 
		query.append("    	AND   BKG_NO  = B.BKG_NO ) AS AMD_FREQ" ).append("\n"); 
		query.append("    ,B.ATND_USR_ID as pic_usr_id" ).append("\n"); 
		query.append("    ,(SELECT  USR_NM FROM COM_USER WHERE USR_ID = B.ATND_USR_ID) USR_NM" ).append("\n"); 
		query.append("    ,B.USER_GROUP AS USR_GROUP, B.REGION, B.BKG_NO, B.SR_NO AS SI_NO " ).append("\n"); 
		query.append("    ,NVL(BKG_COM_INTG_CD_NM_FNC('CD01577',B.SR_AMD_TP_CD),'Original') AS SI_KND" ).append("\n"); 
		query.append("    ,B.SR_URG_CD AS URGENT, B.SRC, B.VVD_CD, B.POL_CD AS POL, B.DEL_CD AS DEL" ).append("\n"); 
		query.append("    ,BKG_COM_INTG_CD_NM_FNC('CD02405',REGION) AS REGION_NM" ).append("\n"); 
		query.append("    ,DECODE(SR_URG_CD,'N','Normal','U','Urgent','V','VIP') AS SR_URG_NM" ).append("\n"); 
		query.append("	,CNTR_CNT" ).append("\n"); 
		query.append("	,CM_CNT" ).append("\n"); 
		query.append("	,H_BL" ).append("\n"); 
		query.append("	,self_audit" ).append("\n"); 
		query.append("	,RATE_TYPE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    H.ATND_USR_ID " ).append("\n"); 
		query.append("    ,BKG_JOIN_FNC(CURSOR(SELECT DISTINCT RGN_OFC_CD FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD ),'')AS  REGION" ).append("\n"); 
		query.append("    ,H.SR_STS_CD,H.SR_HIS_SEQ" ).append("\n"); 
		query.append("    -- SR_AMD_SEQ 가 가장낮은 HIS_DUP_NM 1번에 BKG_NO별 데이터를 모아두고 " ).append("\n"); 
		query.append("    ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD, A.BKG_NO, A.SR_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM" ).append("\n"); 
		query.append("    ,ROW_NUMBER() OVER (PARTITION BY A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) SR_BKG_NM" ).append("\n"); 
		query.append("    ,COUNT(DISTINCT A.RQST_RN) OVER (PARTITION BY A.BKG_NO ,SR_STS_CD) SI_CNT --해당 BKG에 SR_STS_CD의 RQST갯수-> S/I #" ).append("\n"); 
		query.append("    ,ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY A.BKG_NO) RN_BKG" ).append("\n"); 
		query.append("    ,COUNT(DISTINCT H.ATND_USR_ID) OVER (PARTITION BY A.BKG_NO,SR_STS_CD   ) STAFF_CNT --해당 BKG의 1ROW 만 사용하면됨." ).append("\n"); 
		query.append("    ,COUNT(DISTINCT A.BKG_NO ) OVER (PARTITION BY SR_STS_CD) BKG_CNT_SR" ).append("\n"); 
		query.append("    --,DECODE(DECODE(SUBSTR(RFA_NO,0,3),'DUM',NULL,RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') RATE_TYPE " ).append("\n"); 
		query.append("    ,A.RQST_RN,A.SRC,A.SR_KND_CD,A.SR_NO,A.BKG_NO,A.SR_AMD_TP_CD,A.SR_AMD_SEQ,A.SR_URG_CD" ).append("\n"); 
		query.append("    ,A.SR_AMD_KND_CD,A.RCV_OFC_CD,A.DPCS_OFC_CD,A.SR_CRNT_STS_CD,A.SR_CRNT_INFO_CD,A.BL_DOC_INP_FLG" ).append("\n"); 
		query.append("    ,A.BL_RT_FLG,A.BL_AUD_FLG,A.SR_WRK_STS_CD,A.BL_DRFT_FAX_OUT_FLG " ).append("\n"); 
		query.append("    ,H.ST_DT, H.ST_GDT " ).append("\n"); 
		query.append("    ,RFA_NO,B.TAA_NO,B.SC_NO, H.SR_PROC_HRS,G.DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append("    ,BKG_COM_INTG_CD_NM_FNC('CD02100',G.DPCS_WRK_GRP_CD) AS USER_GROUP" ).append("\n"); 
		query.append("    ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("    ,POL_CD,DEL_CD" ).append("\n"); 
		query.append("    ,(SELECT  COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) As CNTR_CNT" ).append("\n"); 
		query.append("    ,(SELECT COUNT(*) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) as CM_CNT" ).append("\n"); 
		query.append("    ,(SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO) As H_BL" ).append("\n"); 
		query.append("    ,(select   AUD_STS_CD  from bkg_rate  WHERE BKG_NO = B.BKG_NO) AS self_audit" ).append("\n"); 
		query.append("    ,(select   DECODE(DECODE(SUBSTR(RFA_NO,0,3),'DUM',NULL,RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') from bkg_booking  WHERE BKG_NO = B.BKG_NO) AS RATE_TYPE " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        ROWNUM RQST_RN ," ).append("\n"); 
		query.append("        BKG_COM_INTG_CD_NM_FNC('CD01581',R.SR_KND_CD) AS SRC" ).append("\n"); 
		query.append("        ,SR_KND_CD,SR_NO, r.BKG_NO, SR_AMD_TP_CD, SR_AMD_SEQ, SR_URG_CD, SR_AMD_KND_CD, RCV_OFC_CD" ).append("\n"); 
		query.append("        ,DPCS_OFC_CD, SR_CRNT_STS_CD, SR_CRNT_INFO_CD, BL_DOC_INP_FLG, BL_RT_FLG, BL_AUD_FLG,SR_WRK_STS_CD,BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("        FROM BKG_SR_CRNT_RQST R" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd], R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("        AND (  1=2" ).append("\n"); 
		query.append("        #if (${sel_group} == 'ID') " ).append("\n"); 
		query.append("            OR (BL_DOC_INP_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("              AND  BL_DOC_INP_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sel_group} == 'RD') " ).append("\n"); 
		query.append("            OR ( BL_RT_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("              AND  BL_RT_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sel_group} == 'AD') " ).append("\n"); 
		query.append("            OR ( BL_AUD_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("              AND  BL_AUD_DT <=TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI') +0.00068) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        ) A   " ).append("\n"); 
		query.append("    ,BKG_SR_HIS H" ).append("\n"); 
		query.append("    ,BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("    ,BKG_BOOKING B" ).append("\n"); 
		query.append("    ,BKG_RATE BR" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND A.SR_KND_CD =  H.SR_KND_CD --FAX,EMAIL,EDI" ).append("\n"); 
		query.append("      AND A.SR_NO =  H.SR_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO =  H.BKG_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO= BR.BKG_NO" ).append("\n"); 
		query.append("     AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE  DECODE(@[vvd_cd], '', '' ,@[vvd_cd])|| '%'" ).append("\n"); 
		query.append("      AND H.ATND_USR_ID  = G.USR_ID(+)" ).append("\n"); 
		query.append("      AND H.ATND_USR_ID = NVL(@[list_atnd_usr_id],H.ATND_USR_ID )" ).append("\n"); 
		query.append("      AND H.SR_STS_CD  = @[sel_group]" ).append("\n"); 
		query.append("      AND EXISTS (SELECT 'Y' FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD AND S.RGN_OFC_CD = NVL(DECODE(@[region],'A','',@[region]),S.RGN_OFC_CD) AND ROWNUM = 1)" ).append("\n"); 
		query.append(")B" ).append("\n"); 
		query.append("WHERE B.HIS_DUP_NM =1" ).append("\n"); 

	}
}