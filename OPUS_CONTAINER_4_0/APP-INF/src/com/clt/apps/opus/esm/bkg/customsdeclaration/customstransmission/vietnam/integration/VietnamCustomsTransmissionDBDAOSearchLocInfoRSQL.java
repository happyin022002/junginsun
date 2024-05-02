/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOSearchLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.31 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOSearchLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLocInfo
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOSearchLocInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOSearchLocInfoRSQL").append("\n"); 
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
		query.append("         ,LOC_CD" ).append("\n"); 
		query.append("         ,DECODE(LOC_CD, 'VNVUNM4', 'CAI MEP TCIT' , LOC_NM) LOC_NM" ).append("\n"); 
		query.append("         ,LOC_ETA" ).append("\n"); 
		query.append("         ,LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("             SELECT  'POL' LOC_TYPE" ).append("\n"); 
		query.append("                     ,P.YD_CD LOC_CD" ).append("\n"); 
		query.append("                     ,(  SELECT YD_NM FROM MDM_YARD WHERE YD_CD=P.YD_CD AND DELT_FLG='N'  ) LOC_NM" ).append("\n"); 
		query.append("                     ,P.VPS_ETA_DT LOC_ETA" ).append("\n"); 
		query.append("                     ,P.VPS_ETD_DT LOC_ETD" ).append("\n"); 
		query.append("             FROM     BKG_BOOKING B" ).append("\n"); 
		query.append("                     ,BKG_VVD V" ).append("\n"); 
		query.append("                     ,VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("             WHERE    B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND      V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             AND      P.SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("             AND      P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("             AND      P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND      P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND      P.VPS_PORT_CD = B.POL_CD " ).append("\n"); 
		query.append("             AND      P.CLPT_IND_SEQ = V.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             ORDER BY VSL_PRE_PST_CD, VSL_SEQ, P.VPS_ETA_DT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append("         ,LOC_CD" ).append("\n"); 
		query.append("         ,DECODE(LOC_CD, 'VNVUNM4', 'CAI MEP TCIT' , LOC_NM) LOC_NM" ).append("\n"); 
		query.append("         ,LOC_ETA" ).append("\n"); 
		query.append("         ,LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("             SELECT  'POD' LOC_TYPE" ).append("\n"); 
		query.append("                     ,P.YD_CD LOC_CD" ).append("\n"); 
		query.append("                     ,(  SELECT YD_NM FROM MDM_YARD WHERE YD_CD=P.YD_CD AND DELT_FLG='N'  ) LOC_NM" ).append("\n"); 
		query.append("                     ,P.VPS_ETA_DT LOC_ETA" ).append("\n"); 
		query.append("                     ,P.VPS_ETD_DT LOC_ETD" ).append("\n"); 
		query.append("             FROM     BKG_BOOKING B" ).append("\n"); 
		query.append("                     ,BKG_VVD V" ).append("\n"); 
		query.append("                     ,VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("             WHERE    B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND      V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             AND      P.SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("             AND      P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("             AND      P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND      P.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND      P.VPS_PORT_CD = B.POD_CD " ).append("\n"); 
		query.append("             AND      P.CLPT_IND_SEQ = V.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             ORDER BY VSL_PRE_PST_CD, VSL_SEQ, P.VPS_ETA_DT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append("         ,LOC_CD" ).append("\n"); 
		query.append("   		 ,DECODE(LOC_CD, 'VNVUNM4', 'CAI MEP TCIT' , LOC_NM)" ).append("\n"); 
		query.append("         ,LOC_ETA" ).append("\n"); 
		query.append("         ,LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("             SELECT   MAX('DEL') LOC_TYPE" ).append("\n"); 
		query.append("                     ,MAX(B.DEL_NOD_CD) LOC_CD" ).append("\n"); 
		query.append("                     ,MAX((SELECT YD_NM FROM MDM_YARD WHERE YD_CD=B.DEL_NOD_CD )) LOC_NM" ).append("\n"); 
		query.append("                     ,MIN(D.ESTM_DT) LOC_ETA" ).append("\n"); 
		query.append("                     ,MAX(D.ESTM_DT) LOC_ETD" ).append("\n"); 
		query.append("             FROM     BKG_BOOKING B" ).append("\n"); 
		query.append("                     ,SCE_COP_HDR H" ).append("\n"); 
		query.append("                     ,SCE_COP_DTL D" ).append("\n"); 
		query.append("                     ,SCE_ACT_ACT_MAPG AM" ).append("\n"); 
		query.append("             WHERE    1 = 1" ).append("\n"); 
		query.append("             AND      B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND      H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             AND      H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             --AND      H.MST_COP_NO = H.COP_NO" ).append("\n"); 
		query.append("             AND      D.COP_NO = H.MST_COP_NO" ).append("\n"); 
		query.append("             AND      SUBSTR(D.NOD_CD, 1, 5) IN (B.POD_CD,B.DEL_CD)" ).append("\n"); 
		query.append("             AND      AM.ACT_STS_MAPG_CD IN ('VD','ID')" ).append("\n"); 
		query.append("             AND      D.ACT_CD = AM.ACT_CD" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    LOC_TYPE" ).append("\n"); 
		query.append("         ,LOC_CD" ).append("\n"); 
		query.append("         ,DECODE(LOC_CD, 'VNVUNM4', 'CAI MEP TCIT' , LOC_NM)" ).append("\n"); 
		query.append("         ,LOC_ETA" ).append("\n"); 
		query.append("         ,LOC_ETD" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("             SELECT   MAX('POR') LOC_TYPE" ).append("\n"); 
		query.append("                     ,MAX(B.POR_NOD_CD) LOC_CD" ).append("\n"); 
		query.append("                     ,MAX((SELECT YD_NM FROM MDM_YARD WHERE YD_CD=B.POR_NOD_CD)) LOC_NM" ).append("\n"); 
		query.append("                     ,MIN(D.ESTM_DT) LOC_ETA" ).append("\n"); 
		query.append("                     ,MAX(D.ESTM_DT) LOC_ETD" ).append("\n"); 
		query.append("             FROM     BKG_BOOKING B" ).append("\n"); 
		query.append("                     ,SCE_COP_HDR H" ).append("\n"); 
		query.append("                     ,SCE_COP_DTL D" ).append("\n"); 
		query.append("                     ,SCE_ACT_ACT_MAPG AM  --ACT_CD LIKE 'FO%'" ).append("\n"); 
		query.append("             WHERE    1 = 1" ).append("\n"); 
		query.append("             AND      B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND      B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND      H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             AND      H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             --AND      H.MST_COP_NO = H.COP_NO" ).append("\n"); 
		query.append("             AND      D.COP_NO = H.MST_COP_NO" ).append("\n"); 
		query.append("             AND      SUBSTR(D.NOD_CD, 1, 5) IN (B.POR_CD)" ).append("\n"); 
		query.append("             AND      AM.ACT_STS_MAPG_CD IN ('OC')" ).append("\n"); 
		query.append("             AND      D.ACT_CD = AM.ACT_CD" ).append("\n"); 
		query.append("          )          " ).append("\n"); 
		query.append("WHERE     LOC_TYPE IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY  LOC_TYPE DESC, LOC_ETA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT    ROWNUM SEQ" ).append("\n"); 
		query.append("         ,DECODE(LOC_TYPE,'TS',LOC_TYPE||RANK() OVER(PARTITION BY LOC_TYPE ORDER BY LOC_ETA),LOC_TYPE) LOC_TYPE" ).append("\n"); 
		query.append("         ,LOC_CD" ).append("\n"); 
		query.append("         ,LOC_NM" ).append("\n"); 
		query.append("         ,TO_CHAR(LOC_ETA,'YYYYMMDD') LOC_ETA" ).append("\n"); 
		query.append("         ,TO_CHAR(LOC_ETD,'YYYYMMDD') LOC_ETD" ).append("\n"); 
		query.append("FROM      LOCATION" ).append("\n"); 
		query.append("WHERE     LOC_TYPE NOT IN ('DEL')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT    99999 SEQ" ).append("\n"); 
		query.append("         ,'DEL' LOC_TYPE" ).append("\n"); 
		query.append("         ,NVL(MAX(DECODE(LOC_TYPE,'DEL',LOC_CD,NULL)),MAX(DECODE(LOC_TYPE,'POD',LOC_CD,NULL))) LOC_CD" ).append("\n"); 
		query.append("         ,NVL(MAX(DECODE(LOC_TYPE,'DEL',LOC_NM,NULL)),MAX(DECODE(LOC_TYPE,'POD',LOC_NM,NULL))) LOC_NM" ).append("\n"); 
		query.append("         ,TO_CHAR(NVL(MAX(DECODE(LOC_TYPE,'DEL',LOC_ETA,NULL)),MAX(DECODE(LOC_TYPE,'POD',LOC_ETD,NULL))),'YYYYMMDD') LOC_ETA" ).append("\n"); 
		query.append("         ,TO_CHAR(NVL(MAX(DECODE(LOC_TYPE,'DEL',LOC_ETD,NULL)),MAX(DECODE(LOC_TYPE,'POD',LOC_ETD,NULL))),'YYYYMMDD') LOC_ETD" ).append("\n"); 
		query.append("FROM      LOCATION" ).append("\n"); 
		query.append("WHERE     LOC_TYPE IN ('POD','DEL')" ).append("\n"); 
		query.append("ORDER BY  SEQ" ).append("\n"); 

	}
}