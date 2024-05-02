/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchAssetsSmryLeaseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.05.31 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchAssetsSmryLeaseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAssetsSmryLeaseList
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchAssetsSmryLeaseListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mftr_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchAssetsSmryLeaseListRSQL").append("\n"); 
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
		query.append("WITH SRC_INFO AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  MFT_DT, CNTR_TPSZ_CD,LSTM_CD,AGMT_CTY_CD,AGMT_SEQ" ).append("\n"); 
		query.append("        , LSI_QTY, MUI_QTY,DII_QTY,FND_QTY, ASET_QTY" ).append("\n"); 
		query.append("        , LSO_QTY,TLL_QTY,SBO_QTY,DIO_QTY,MUO_QTY,LST_QTY,SCR_QTY, SLD_QTY, ACT_QTY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T01.*" ).append("\n"); 
		query.append("               , (LSI_QTY + MUI_QTY + DII_QTY + FND_QTY) AS ASET_QTY" ).append("\n"); 
		query.append("               , (LSI_QTY + MUI_QTY + DII_QTY + FND_QTY) - (LSO_QTY + TLL_QTY + SBO_QTY + DIO_QTY + MUO_QTY + LST_QTY + SCR_QTY + SLD_QTY) AS ACT_QTY" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  AGMT_CTY_CD, AGMT_SEQ," ).append("\n"); 
		query.append("                        MFT_DT AS MFT_DT, " ).append("\n"); 
		query.append("                        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        LSTM_CD," ).append("\n"); 
		query.append("                        SUM(DECODE(PRE_STS_CD, 'LSI',1,0)) AS LSI_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(PRE_STS_CD, 'MUI',1,0)) AS MUI_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(PRE_STS_CD, 'DII',1,0)) AS DII_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(PRE_STS_CD, 'FND',1,0)) AS FND_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'LSO',1,0)) AS LSO_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'TLL',1,0)) AS TLL_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'SBO',1,0)) AS SBO_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'DIO',1,0)) AS DIO_QTY, " ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'MUO',1,0)) AS MUO_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'LST',1,0)) AS LST_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'SCR',1,0)) AS SCR_QTY," ).append("\n"); 
		query.append("                        SUM(DECODE(CUR_STS_CD, 'SLD',1,0)) AS SLD_QTY" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  CASE WHEN CNTR_STS_CD IN ('SBI', 'LSO','TLL','SCR', 'SLD', 'SBO','DIO','MUO','LST') THEN 'LSI' ELSE CNTR_STS_CD END AS PRE_STS_CD" ).append("\n"); 
		query.append("                                , CNTR_STS_CD AS CUR_STS_CD" ).append("\n"); 
		query.append("                                , AGMT_CTY_CD, AGMT_SEQ, TO_CHAR(MFT_DT,'YYYY') AS MFT_DT, CNTR_TPSZ_CD,LSTM_CD" ).append("\n"); 
		query.append("                        FROM    MST_CONTAINER T1" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND T1.OWNR_CO_CD = 'H'" ).append("\n"); 
		query.append("                    #if (${fm_prd} != '') " ).append("\n"); 
		query.append("                        AND T1.MFT_DT >= TO_DATE(NVL(@[fm_prd],''),'YYYYMM') " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${to_prd} != '') " ).append("\n"); 
		query.append("                        AND T1.MFT_DT <  ADD_MONTHS(TO_DATE(NVL(@[to_prd],''),'YYYYMM'),1)" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                        AND DECODE(NVL(@[loc_tp_cd],''),'ALL','1','RCC',T1.RCC_CD,'LCC',T1.LCC_CD,'ECC',T1.ECC_CD,'SCC',T1.SCC_CD) = DECODE(NVL(@[loc_tp_cd],''),'ALL','1',NVL(@[loc_cd],''))    " ).append("\n"); 
		query.append("                    #if (${cntr_pfx_cd} != '') " ).append("\n"); 
		query.append("                        AND T1.CNTR_NO LIKE NVL(@[cntr_pfx_cd],'') || '%'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${fm_ser_no} != '') " ).append("\n"); 
		query.append("                        AND TO_NUMBER(NVL(@[fm_ser_no],'')) <= TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${to_ser_no} != '') " ).append("\n"); 
		query.append("                        AND TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) <= TO_NUMBER(NVL(@[to_ser_no],''))" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${lstm_cd} == 'ALL')" ).append("\n"); 
		query.append("                        AND T1.LSTM_CD IN ('ST', 'LT')" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        AND T1.LSTM_CD = NVL(@[lstm_cd],'')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                      #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL') " ).append("\n"); 
		query.append("                        AND T1.CNTR_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("                    	#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("                    		'$cntrtpszcd',  " ).append("\n"); 
		query.append("                    		#end  " ).append("\n"); 
		query.append("                    		'') " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${mftr_vndr_seq} != '') " ).append("\n"); 
		query.append("                        AND T1.MFTR_VNDR_SEQ = NVL(@[mftr_vndr_seq],'')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                GROUP BY AGMT_CTY_CD, AGMT_SEQ, MFT_DT, CNTR_TPSZ_CD, LSTM_CD" ).append("\n"); 
		query.append("                ) T01" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        ) T02" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("--AND     ACT_QTY     > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	MFT_DT, CNTR_TPSZ_CD,LSTM_CD" ).append("\n"); 
		query.append("        , SUM(CTRT_QTY) AS CTRT_QTY" ).append("\n"); 
		query.append("        , SUM(LSI_QTY) AS LSI_QTY, SUM(MUI_QTY) AS MUI_QTY, SUM(DII_QTY) AS DII_QTY, SUM(FND_QTY) AS FND_QTY, SUM(ASET_QTY) AS ASET_QTY" ).append("\n"); 
		query.append("        , SUM(LSO_QTY) AS LSO_QTY, SUM(TLL_QTY) AS TLL_QTY, SUM(SCR_QTY) AS SCR_QTY, SUM(SLD_QTY) AS SLD_QTY, SUM(SBO_QTY) AS SBO_QTY" ).append("\n"); 
		query.append("        , SUM(DIO_QTY) AS DIO_QTY, SUM(MUO_QTY) AS MUO_QTY, SUM(LST_QTY) AS LST_QTY, SUM(ACT_QTY) AS ACT_QTY" ).append("\n"); 
		query.append("        , NVL(@[cntr_pfx_cd]  ,'') AS CNTR_PFX_CD" ).append("\n"); 
		query.append("        , NVL(@[fm_ser_no]    ,'') AS FM_SER_NO" ).append("\n"); 
		query.append("        , NVL(@[to_ser_no]    ,'') AS TO_SER_NO" ).append("\n"); 
		query.append("        , NVL(@[mftr_vndr_seq],'') AS MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("        , NVL(@[loc_tp_cd]    ,'') AS LOC_TP_CD" ).append("\n"); 
		query.append("        , NVL(@[loc_cd]       ,'') AS LOC_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  MFT_DT, CNTR_TPSZ_CD,LSTM_CD," ).append("\n"); 
		query.append("        NVL((" ).append("\n"); 
		query.append("                    SELECT  S1.AGMT_CHG_VAL AS QTY" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT S1, LSE_AGREEMENT S2" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     S1.AGMT_SEQ             = S2.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     S1.AGMT_CTY_CD          = S2.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     S2.AGMT_LST_VER_SEQ     = NVL('1', S2.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("                    AND     S1.CNTR_RNTL_CHG_TP_CD  = 'GENV'" ).append("\n"); 
		query.append("                    AND     S1.AGMT_CHG_VAL         > 0" ).append("\n"); 
		query.append("                    AND     S2.AGMT_SEQ             = T01.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     S2.AGMT_CTY_CD          = T01.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     S1.CNTR_TPSZ_CD         = T01.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  S1.AGMT_CHG_VAL AS QTY" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT_HIS S1, LSE_AGREEMENT S2" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     S1.AGMT_SEQ             = S2.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     S1.AGMT_CTY_CD          = S2.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     S1.CNTR_RNTL_CHG_TP_CD  = 'GENV'" ).append("\n"); 
		query.append("                    AND     S1.AGMT_VER_SEQ         = DECODE(S2.AGMT_LST_VER_SEQ, '1', 9999, '1')" ).append("\n"); 
		query.append("                    AND     S1.AGMT_CHG_VAL         > 0" ).append("\n"); 
		query.append("                    AND     S2.AGMT_SEQ             = T01.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     S2.AGMT_CTY_CD          = T01.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     S1.CNTR_TPSZ_CD         = T01.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         ), 0) AS CTRT_QTY" ).append("\n"); 
		query.append("        , LSI_QTY, MUI_QTY,DII_QTY,FND_QTY, ASET_QTY" ).append("\n"); 
		query.append("        , LSO_QTY,TLL_QTY,SCR_QTY, SLD_QTY,SBO_QTY,DIO_QTY,MUO_QTY,LST_QTY, ACT_QTY" ).append("\n"); 
		query.append("        , NVL(@[cntr_pfx_cd]  ,'') AS CNTR_PFX_CD" ).append("\n"); 
		query.append("        , NVL(@[fm_ser_no]    ,'') AS FM_SER_NO" ).append("\n"); 
		query.append("        , NVL(@[to_ser_no]    ,'') AS TO_SER_NO" ).append("\n"); 
		query.append("        , NVL(@[mftr_vndr_seq],'') AS MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("        , NVL(@[loc_tp_cd]    ,'') AS LOC_TP_CD" ).append("\n"); 
		query.append("        , NVL(@[loc_cd]       ,'') AS LOC_CD" ).append("\n"); 
		query.append("FROM    SRC_INFO T01" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("GROUP BY MFT_DT, CNTR_TPSZ_CD,LSTM_CD" ).append("\n"); 
		query.append("HAVING   SUM(ACT_QTY) > 0" ).append("\n"); 
		query.append("ORDER BY MFT_DT, CNTR_TPSZ_CD,LSTM_CD" ).append("\n"); 

	}
}