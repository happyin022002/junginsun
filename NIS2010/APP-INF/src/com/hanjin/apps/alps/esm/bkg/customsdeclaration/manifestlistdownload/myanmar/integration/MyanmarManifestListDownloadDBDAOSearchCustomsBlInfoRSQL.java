/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestListDownloadDBDAOSearchCustomsBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarManifestListDownloadDBDAOSearchCustomsBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsBlInfo
	  * </pre>
	  */
	public MyanmarManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarManifestListDownloadDBDAOSearchCustomsBlInfoRSQL").append("\n"); 
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
		query.append("SELECT   -------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("         --Header  " ).append("\n"); 
		query.append("          NVL(MV.VSL_ENG_NM,'') VSL_NM" ).append("\n"); 
		query.append("         ,NVL(MV.CALL_SGN_NO,'') VSL_CALLSIGN" ).append("\n"); 
		query.append("         ,TO_CHAR(P.VPS_ETD_DT,'YYYYMMDD') ETD" ).append("\n"); 
		query.append("         ,TO_CHAR(P.VPS_ETA_DT,'YYYYMMDD') ETA" ).append("\n"); 
		query.append("         -------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("         --Grid" ).append("\n"); 
		query.append("         ,ROWNUM SEQ" ).append("\n"); 
		query.append("         ,V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("         ,B.BKG_NO" ).append("\n"); 
		query.append("		 ,B.BL_NO" ).append("\n"); 
		query.append("         ,C.CNTR_NO" ).append("\n"); 
		query.append("         ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         ,( SELECT NVL2(MAX(TO_CHAR(LOG.MF_SND_DT,'YYYY/MM/DD')),'A','')" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_MM_SND_LOG LOG" ).append("\n"); 
		query.append("             WHERE LOG.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("               AND LOG.CNTR_NO = C.CNTR_NO ) SF" ).append("\n"); 
		query.append("         ,NVL(B.RCV_TERM_CD||B.DE_TERM_CD,'') RD" ).append("\n"); 
		query.append("		 ,S.CUST_NM                CUST_NM" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("         ,DECODE(B.POL_CD,V.POL_CD,'L','T') LS        --Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         ,DECODE(B.POD_CD,V.POD_CD,'L','T') LS        --Inbound 조건   " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("         ,B.POR_CD                  B_POR" ).append("\n"); 
		query.append("         ,V.POL_CD                  V_POL" ).append("\n"); 
		query.append("         ,V.POD_CD                  V_POD" ).append("\n"); 
		query.append("         ,SUBSTR(V.POD_YD_CD,5,2)   V_POD_CD" ).append("\n"); 
		query.append("         ,B.DEL_CD                  B_DEL" ).append("\n"); 
		query.append("         ,SUBSTR(B.DEL_NOD_CD,5,2)  B_DEL_CD" ).append("\n"); 
		query.append("         ,C.CNTR_WGT                ACT_WGT" ).append("\n"); 
		query.append("         ,C.WGT_UT_CD               WGT_UT_CD" ).append("\n"); 
		query.append("         ,C.MEAS_QTY                MEAS_QTY" ).append("\n"); 
		query.append("         ,C.MEAS_UT_CD              MEAS_UT_CD" ).append("\n"); 
		query.append("         ,C.PCK_QTY                 PCK_QTY" ).append("\n"); 
		query.append("         ,(SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = C.PCK_TP_CD)  PCK_TP_CD" ).append("\n"); 
		query.append("         ,R.FRT_TERM_CD             Freight" ).append("\n"); 
		query.append("         ,B.RD_CGO_FLG               RF" ).append("\n"); 
		query.append("         ,( SELECT MAX(TO_CHAR(LOG.MF_SND_DT,'YYYY/MM/DD')) " ).append("\n"); 
		query.append("              FROM BKG_CSTMS_MM_SND_LOG LOG" ).append("\n"); 
		query.append("             WHERE LOG.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("               AND LOG.CNTR_NO = C.CNTR_NO ) S_DATE --컬럼 생성 준비 중::,NVL(BKG_CSTMS_VN_SND_LOG.MF_SND_DT,'')    S_DATE" ).append("\n"); 
		query.append("         -------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("         --Tail:: Y 갯수만 COUNTING" ).append("\n"); 
		query.append("         ,DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'2','Y','')                    TPSZ_20_CHK   " ).append("\n"); 
		query.append("         ,(CASE WHEN  SUBSTR(C.CNTR_TPSZ_CD,2,1) != '2' THEN 'Y' ELSE '' END) TPSZ_40_CHK" ).append("\n"); 
		query.append("         ,NVL2(C.CNTR_TPSZ_CD,'Y','') TPSZ_TOT_CHK" ).append("\n"); 
		query.append("         -------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("		 ,S.CUST_NM                CNEE" ).append("\n"); 
		query.append("		 ,N.CUST_NM                CUST_NM" ).append("\n"); 
		query.append("FROM      BKG_VVD V" ).append("\n"); 
		query.append(", MDM_VSL_CNTR MV" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append(", BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_CONTAINER C" ).append("\n"); 
		query.append(", BKG_RATE R" ).append("\n"); 
		query.append(", BKG_CUSTOMER S" ).append("\n"); 
		query.append(", BKG_CUSTOMER N" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       V.VSL_CD = SUBSTR(@[s_vvd],1,4)                --[vvd]" ).append("\n"); 
		query.append("AND       V.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)            --[vvd] HNMN0088E" ).append("\n"); 
		query.append("AND       V.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)            --[vvd]" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("AND       V.POL_CD = @[frm_port_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       V.POD_CD = @[frm_port_cd]        --Mode=Inbound 조건'VNSGN'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND       MV.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND       P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND       P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND       P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = V.POL_CD        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = V.POD_CD        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND       B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND       S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND       B.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("AND       N.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("AND       B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND       B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND       C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND       R.BKG_NO(+) = B.BKG_NO" ).append("\n"); 

	}
}