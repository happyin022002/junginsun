/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchCHSAssetsSmryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.06.03 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchCHSAssetsSmryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCHSAssetsSmryList
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchCHSAssetsSmryListRSQL(){
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchCHSAssetsSmryListRSQL").append("\n"); 
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
		query.append("SELECT A.MFT_DT," ).append("\n"); 
		query.append("  A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  A.LSTM_CD," ).append("\n"); 
		query.append("  A.CTRT_QTY," ).append("\n"); 
		query.append("  A.SLD_QTY," ).append("\n"); 
		query.append("  A.TLL_QTY," ).append("\n"); 
		query.append("  A.DON_QTY," ).append("\n"); 
		query.append("  A.SCR_QTY," ).append("\n"); 
		query.append("  A.CTRT_QTY - (A.SLD_QTY + A.TLL_QTY + A.DON_QTY + A.SCR_QTY) AS ASET_QTY," ).append("\n"); 
		query.append("  A.LST_QTY," ).append("\n"); 
		query.append("  A.SBO_QTY," ).append("\n"); 
		query.append("  A.LSO_QTY," ).append("\n"); 
		query.append("  A.DIO_QTY," ).append("\n"); 
		query.append("  A.CTRT_QTY - (A.SLD_QTY + A.TLL_QTY + A.DON_QTY + A.SCR_QTY) - (A.LST_QTY + A.SBO_QTY + A.LSO_QTY + A.DIO_QTY) AS ACT_QTY," ).append("\n"); 
		query.append("  NVL(@[cntr_pfx_cd],'') CNTR_PFX_CD," ).append("\n"); 
		query.append("  NVL(@[fm_ser_no],'') FM_SER_NO," ).append("\n"); 
		query.append("  NVL(@[to_ser_no],'') TO_SER_NO," ).append("\n"); 
		query.append("  NVL(@[mftr_vndr_seq],'') MFTR_VNDR_SEQ," ).append("\n"); 
		query.append("  NVL(@[loc_tp_cd],'') LOC_TP_CD," ).append("\n"); 
		query.append("  NVL(@[loc_cd],'') LOC_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.MFT_DT," ).append("\n"); 
		query.append("        A.EQ_TPSZ_CD AS CNTR_TPSZ_CD  ," ).append("\n"); 
		query.append("        A.AGMT_LSTM_CD  AS LSTM_CD," ).append("\n"); 
		query.append("        COUNT(A.CTRT_QTY) AS CTRT_QTY," ).append("\n"); 
		query.append("        SUM(A.SLD_QTY) AS SLD_QTY," ).append("\n"); 
		query.append("        SUM(A.TLL_QTY) AS TLL_QTY," ).append("\n"); 
		query.append("        SUM(A.DON_QTY) AS DON_QTY," ).append("\n"); 
		query.append("        SUM(A.SCR_QTY) AS SCR_QTY," ).append("\n"); 
		query.append("        SUM(A.LST_QTY) AS LST_QTY," ).append("\n"); 
		query.append("        SUM(A.SBO_QTY) AS SBO_QTY,   " ).append("\n"); 
		query.append("        SUM(A.LSO_QTY) AS LSO_QTY," ).append("\n"); 
		query.append("        SUM(A.DIO_QTY) AS DIO_QTY " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	        A.EQ_NO," ).append("\n"); 
		query.append("	        TO_CHAR(A.MFT_DT,'YYYY') AS MFT_DT, " ).append("\n"); 
		query.append("	        A.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("	        A.AGMT_LSTM_CD ," ).append("\n"); 
		query.append("	        A.EQ_NO AS CTRT_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'SLD',1,0) AS SLD_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'TLL',1,0) AS TLL_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'DON',1,0) AS DON_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'SCR',1,0) AS SCR_QTY,           " ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'LST',1,0) AS LST_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'SBO',1,0) AS SBO_QTY," ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'LSO',1,0) AS LSO_QTY, " ).append("\n"); 
		query.append("	        DECODE(B.EQ_ASET_STS_CD,'DIO',1,0) AS DIO_QTY        " ).append("\n"); 
		query.append("	    FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("             CGM_EQ_STS_HIS B," ).append("\n"); 
		query.append("             CGM_EQ_SPEC C," ).append("\n"); 
		query.append("             MDM_LOCATION E," ).append("\n"); 
		query.append("             MDM_EQ_ORZ_CHT F" ).append("\n"); 
		query.append("	    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("        AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("        AND A.EQ_SPEC_NO = C.EQ_SPEC_NO(+)" ).append("\n"); 
		query.append("        AND E.SCC_CD    = F.SCC_CD" ).append("\n"); 
		query.append("        AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("        AND A.CRNT_LOC_CD =  E.LOC_CD  " ).append("\n"); 
		query.append("        #if (${eq_knd_cd} =='Z')" ).append("\n"); 
		query.append("	    AND A.CHSS_OWNR_CO_CD = 'H'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${fm_prd} != '') " ).append("\n"); 
		query.append("	    AND A.MFT_DT >= TO_DATE(NVL(@[fm_prd],''),'YYYYMM') " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${to_prd} != '') " ).append("\n"); 
		query.append("	    AND A.MFT_DT <  ADD_MONTHS(TO_DATE(NVL(@[to_prd],''),'YYYYMM'),1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    AND DECODE(NVL(@[loc_tp_cd],''),'ALL','1','RCC',F.RCC_CD,'LCC',F.LCC_CD,'ECC',F.ECC_CD,'SCC',F.SCC_CD) = DECODE(NVL(@[loc_tp_cd],''),'ALL','1',NVL(@[loc_cd],''))    " ).append("\n"); 
		query.append("		#if (${cntr_pfx_cd} != '') " ).append("\n"); 
		query.append("	    AND A.EQ_NO LIKE NVL(@[cntr_pfx_cd],'') || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${fm_ser_no} != '') " ).append("\n"); 
		query.append("	    AND TO_NUMBER(NVL(@[fm_ser_no],'')) <= TO_NUMBER(SUBSTR(A.EQ_NO,5,6)) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${to_ser_no} != '') " ).append("\n"); 
		query.append("	    AND TO_NUMBER(SUBSTR(A.EQ_NO,5,6)) <= TO_NUMBER(NVL(@[to_ser_no],''))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd} == 'ALL')" ).append("\n"); 
		query.append("		AND A.AGMT_LSTM_CD  IN ('OW','LP','OL')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND A.AGMT_LSTM_CD  = NVL(@[lstm_cd],'')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL') " ).append("\n"); 
		query.append("	    AND A.EQ_TPSZ_CD   IN ( " ).append("\n"); 
		query.append("			#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("				'$cntrtpszcd',  " ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("				'') " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${mftr_vndr_seq} != '') " ).append("\n"); 
		query.append("	    AND C.VNDR_SEQ  = NVL(@[mftr_vndr_seq],'')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  ) A" ).append("\n"); 
		query.append("    GROUP BY A.MFT_DT, A.EQ_TPSZ_CD , A.AGMT_LSTM_CD " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY MFT_DT" ).append("\n"); 

	}
}