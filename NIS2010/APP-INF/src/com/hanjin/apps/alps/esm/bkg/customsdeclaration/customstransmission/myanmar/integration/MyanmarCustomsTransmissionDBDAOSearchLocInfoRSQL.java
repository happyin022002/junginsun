/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchLocInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchLocInfoRSQL").append("\n"); 
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
		query.append("WITH LOCATION AS(" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",LOC_NM" ).append("\n"); 
		query.append(",LOC_ETA" ).append("\n"); 
		query.append(",LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${pol_gubun} != '1')" ).append("\n"); 
		query.append("DECODE(P.VPS_PORT_CD, V.POL_CD, 'PL', B.POD_CD, 'PD', 'TS') LOC_TYPE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(P.VPS_PORT_CD, B.POL_CD, 'PL', V.POD_CD, 'PD', 'TS') LOC_TYPE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",P.VPS_PORT_CD LOC_CD" ).append("\n"); 
		query.append(",(  SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD=P.VPS_PORT_CD AND DELT_FLG='N'  ) LOC_NM" ).append("\n"); 
		query.append(",P.VPS_ETA_DT LOC_ETA" ).append("\n"); 
		query.append(",P.VPS_ETD_DT LOC_ETD" ).append("\n"); 
		query.append("FROM     BKG_BOOKING B" ).append("\n"); 
		query.append(",BKG_VVD V" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("WHERE    B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND      P.SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("AND      P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND      P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND      P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      (P.VPS_PORT_CD, P.CLPT_IND_SEQ) IN ( ( V.POL_CD,V.POD_CLPT_IND_SEQ), (V.POD_CD,V.POD_CLPT_IND_SEQ) ) --POL" ).append("\n"); 
		query.append("#if (${pol_gubun} != '1')" ).append("\n"); 
		query.append("AND      V.POD_CD = B.POD_CD   -- POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND      V.POL_CD = B.POL_CD   -- POL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY VSL_PRE_PST_CD, VSL_SEQ, P.VPS_ETA_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",LOC_NM" ).append("\n"); 
		query.append(",LOC_ETA" ).append("\n"); 
		query.append(",LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("SELECT   MAX('DL') LOC_TYPE" ).append("\n"); 
		query.append(",MAX(SUBSTR(D.NOD_CD, 1, 5)) LOC_CD" ).append("\n"); 
		query.append(",MAX((SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD=DECODE(D.ACT_STS_MAPG_CD, 'ID', SUBSTR(D.NOD_CD, 1, 5), 'VD', SUBSTR(D.NOD_CD, 1, 5), B.DEL_CD) AND DELT_FLG='N')) LOC_NM" ).append("\n"); 
		query.append(",MIN(D.ESTM_DT) LOC_ETA" ).append("\n"); 
		query.append(",MAX(D.ESTM_DT) LOC_ETD" ).append("\n"); 
		query.append("FROM     BKG_BOOKING B" ).append("\n"); 
		query.append(",SCE_COP_HDR H" ).append("\n"); 
		query.append(",SCE_COP_DTL D" ).append("\n"); 
		query.append(",SCE_ACT_ACT_MAPG AM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND      H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      H.MST_COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND      D.COP_NO = H.MST_COP_NO" ).append("\n"); 
		query.append("AND      SUBSTR(D.NOD_CD, 1, 5) IN (B.POD_CD,B.DEL_CD)" ).append("\n"); 
		query.append("AND      AM.ACT_STS_MAPG_CD IN ('VD','ID')" ).append("\n"); 
		query.append("AND      D.ACT_CD = AM.ACT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",LOC_NM" ).append("\n"); 
		query.append(",LOC_ETA" ).append("\n"); 
		query.append(",LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("SELECT   MAX('PR') LOC_TYPE" ).append("\n"); 
		query.append(",MAX(SUBSTR(D.NOD_CD, 1, 5)) LOC_CD" ).append("\n"); 
		query.append(",MAX((SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD=DECODE(D.ACT_STS_MAPG_CD, 'OC', SUBSTR(D.NOD_CD, 1, 5), B.POR_CD) AND DELT_FLG='N')) LOC_NM" ).append("\n"); 
		query.append(",MIN(D.ESTM_DT) LOC_ETA" ).append("\n"); 
		query.append(",MAX(D.ESTM_DT) LOC_ETD" ).append("\n"); 
		query.append("FROM     BKG_BOOKING B" ).append("\n"); 
		query.append(",SCE_COP_HDR H" ).append("\n"); 
		query.append(",SCE_COP_DTL D" ).append("\n"); 
		query.append(",SCE_ACT_ACT_MAPG AM  --ACT_CD LIKE 'FO%'" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND      H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      H.MST_COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND      D.COP_NO = H.MST_COP_NO" ).append("\n"); 
		query.append("AND      SUBSTR(D.NOD_CD, 1, 5) = B.POR_CD" ).append("\n"); 
		query.append("AND      AM.ACT_STS_MAPG_CD (+) ='OC'" ).append("\n"); 
		query.append("AND      D.ACT_CD = AM.ACT_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE     LOC_TYPE IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY  LOC_TYPE DESC, LOC_ETA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT    ROWNUM SEQ" ).append("\n"); 
		query.append(",DECODE(LOC_TYPE,'TS',LOC_TYPE||RANK() OVER(PARTITION BY LOC_TYPE ORDER BY LOC_ETA),LOC_TYPE) LOC_TYPE" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(LOC_ETA,'YYYYMMDD') LOC_ETA" ).append("\n"); 
		query.append(",TO_CHAR(LOC_ETD,'YYYYMMDD') LOC_ETD" ).append("\n"); 
		query.append("FROM      LOCATION" ).append("\n"); 
		query.append("WHERE     LOC_TYPE NOT IN ('DL')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT    99999 SEQ" ).append("\n"); 
		query.append(",'DL' LOC_TYPE" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(LOC_TYPE,'DL',LOC_CD,NULL)),MAX(DECODE(LOC_TYPE,'PD',LOC_CD,NULL))) LOC_CD" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(LOC_TYPE,'DL',LOC_NM,NULL)),MAX(DECODE(LOC_TYPE,'PD',LOC_NM,NULL))) LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(NVL(MAX(DECODE(LOC_TYPE,'DL',LOC_ETA,NULL)),MAX(DECODE(LOC_TYPE,'PD',LOC_ETD,NULL))),'YYYYMMDD') LOC_ETA" ).append("\n"); 
		query.append(",TO_CHAR(NVL(MAX(DECODE(LOC_TYPE,'DL',LOC_ETD,NULL)),MAX(DECODE(LOC_TYPE,'PD',LOC_ETD,NULL))),'YYYYMMDD') LOC_ETD" ).append("\n"); 
		query.append("FROM      LOCATION" ).append("\n"); 
		query.append("WHERE     LOC_TYPE IN ('PD','DL')" ).append("\n"); 
		query.append("ORDER BY  SEQ" ).append("\n"); 

	}
}