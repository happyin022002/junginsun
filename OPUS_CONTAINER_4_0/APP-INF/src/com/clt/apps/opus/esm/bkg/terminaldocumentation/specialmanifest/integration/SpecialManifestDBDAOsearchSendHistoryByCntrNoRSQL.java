/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchSendHistoryByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchSendHistoryByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sent결과를 조회해 온다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchSendHistoryByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("snd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchSendHistoryByCntrNoRSQL").append("\n"); 
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
		query.append("	#if (${call_gubun} == 'ESM_BKG_0965') " ).append("\n"); 
		query.append("        DECODE(SND1.AUTO_SND_TP_CD,'Y','Auto_Transit',SND1.SND_USR_ID) TRAN_ID" ).append("\n"); 
		query.append("        ,SND1.MSG_SND_NO" ).append("\n"); 
		query.append("        ,DECODE(SND1.MSG_FUNC_ID, 'O', 'Original'" ).append("\n"); 
		query.append("                                , 'U', 'Update'" ).append("\n"); 
		query.append("                                , 'C', 'Cancel') MSG_FUNC_ID" ).append("\n"); 
		query.append("		,DECODE(SND1.AUTO_SND_TP_CD, 'A', 'Auto', 'M', 'Manual') AUTO_SND_TP_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(SND1.SND_DT, 'YYYY-MM-DD HH24:MI:SS') SND_DT" ).append("\n"); 
		query.append("        ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("        ,A.PORT_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(A.EUR_DG_DECL_TP_CD, 'D', 'Discharging'" ).append("\n"); 
		query.append("                                    , 'T', 'Transit'" ).append("\n"); 
		query.append("                                    , 'L', 'Loading'" ).append("\n"); 
		query.append("                                    , 'P', 'Pre-carriage'" ).append("\n"); 
		query.append("                                    , 'O', 'On-Carriage'" ).append("\n"); 
		query.append("                                    , 'DO', 'Discharging + On-Carriage'" ).append("\n"); 
		query.append("                                       , 'PL', 'Pre-carriage + Loading') EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("        ,RCV1.SCR_FILE_NO" ).append("\n"); 
		query.append("        ,A.BL_NO" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.IMDG_UN_NO" ).append("\n"); 
		query.append("        ,RCV1.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(RCV1.ACK_DT, 'YYYY-MM-DD HH24:MI:SS') ACK_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(RCV1.APRO_DT, 'YYYY-MM-DD HH24:MI:SS') APRO_DT" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            BKG_JOIN_CLOB_FNC(CURSOR(            " ).append("\n"); 
		query.append("            SELECT DECODE(CSTMS_ERR_ID, NULL, '', CSTMS_ERR_ID || '|' || CSTMS_ERR_MSG || '|' || CSTMS_ERR_REF_NO1 || '|' || CSTMS_ERR_REF_NO2)" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_DG_RCV_ERR" ).append("\n"); 
		query.append("            WHERE EUR_EDI_MSG_TP_ID = RCV1.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("            AND MSG_RCV_NO = RCV1.MSG_RCV_NO" ).append("\n"); 
		query.append("            AND RCV_LOG_SEQ = RCV1.RCV_LOG_SEQ" ).append("\n"); 
		query.append("            ),CHR(10) )" ).append("\n"); 
		query.append("        ) CSTMS_ERR_MSG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("        ,A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("        ,DECODE(A.IMDG_PCK_GRP_CD, '1', 'I', '2', 'II', '3', 'III', 'N') IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("        ,A.EUR_PCK_DESC" ).append("\n"); 
		query.append("        ,A.PCK_QTY" ).append("\n"); 
		query.append("        ,A.NET_WGT" ).append("\n"); 
		query.append("        ,A.GRS_WGT" ).append("\n"); 
		query.append("        ,A.PRP_SHP_NM" ).append("\n"); 
		query.append("        ,A.HZD_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        DECODE(MAX(SND1.AUTO_SND_TP_CD),'Y','Auto_Transit',MAX(SND1.SND_USR_ID)) TRAN_ID" ).append("\n"); 
		query.append("        ,SND1.MSG_SND_NO MSG_SND_NO" ).append("\n"); 
		query.append("        ,DECODE(MAX(SND1.MSG_FUNC_ID), 'O', 'Original'" ).append("\n"); 
		query.append("                                , 'U', 'Update'" ).append("\n"); 
		query.append("                                , 'C', 'Cancel') MSG_FUNC_ID" ).append("\n"); 
		query.append("		,DECODE(MAX(SND1.AUTO_SND_TP_CD), 'A', 'Auto', 'M', 'Manual') AUTO_SND_TP_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(SND1.SND_DT), 'YYYY-MM-DD HH24:MI:SS') SND_DT" ).append("\n"); 
		query.append("        ,MAX(A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD) VVD_CD" ).append("\n"); 
		query.append("        ,MAX(A.PORT_CD) PORT_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(MAX(A.EUR_DG_DECL_TP_CD) , 'D', 'Discharging'" ).append("\n"); 
		query.append("                                    	, 'T', 'Transit'" ).append("\n"); 
		query.append("                                    	, 'L', 'Loading'" ).append("\n"); 
		query.append("                                    	, 'P', 'Pre-carriage'" ).append("\n"); 
		query.append("                                    	, 'O', 'On-Carriage'" ).append("\n"); 
		query.append("                                    	, 'DO', 'Discharging + On-Carriage'" ).append("\n"); 
		query.append("                                    	, 'PL', 'Pre-carriage + Loading') EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("        ,MAX(RCV1.SCR_FILE_NO) SCR_FILE_NO" ).append("\n"); 
		query.append("        ,MAX(A.BL_NO) BL_NO" ).append("\n"); 
		query.append("        ,MAX(A.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("        ,MAX(A.IMDG_UN_NO) IMDG_UN_NO" ).append("\n"); 
		query.append("        ,MAX(RCV1.ACK_RCV_STS_CD) ACK_RCV_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(RCV1.ACK_DT), 'YYYY-MM-DD HH24:MI:SS') ACK_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(RCV1.APRO_DT), 'YYYY-MM-DD HH24:MI:SS') APRO_DT" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            BKG_JOIN_CLOB_FNC(CURSOR(            " ).append("\n"); 
		query.append("            SELECT DECODE(CSTMS_ERR_ID, NULL, '', CSTMS_ERR_ID || '|' || CSTMS_ERR_MSG || '|' || CSTMS_ERR_REF_NO1 || '|' || CSTMS_ERR_REF_NO2)" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_DG_RCV_ERR" ).append("\n"); 
		query.append("            WHERE EUR_EDI_MSG_TP_ID = RCV1.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("            AND MSG_RCV_NO = RCV1.MSG_RCV_NO" ).append("\n"); 
		query.append("            AND RCV_LOG_SEQ = RCV1.RCV_LOG_SEQ" ).append("\n"); 
		query.append("            ),CHR(13) )" ).append("\n"); 
		query.append("        ) CSTMS_ERR_MSG" ).append("\n"); 
		query.append("        ,MAX(A.CNTR_CGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("     ,BKG_CSTMS_EUR_DG_SND SND1, BKG_CSTMS_EUR_DG_EDI_RSPN SND2" ).append("\n"); 
		query.append("     , BKG_CSTMS_EUR_DG_RCV RCV1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.EUR_DG_DECL_TP_CD   = SND1.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("AND   A.VSL_CD              = SND1.VSL_CD(+)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO          = SND1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD          = SND1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   A.PORT_CD             = SND1.PORT_CD(+)" ).append("\n"); 
		query.append("AND   A.BL_NO               = SND2.BL_NO(+)" ).append("\n"); 
		query.append("AND   A.CNTR_NO             = SND2.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   A.CNTR_CGO_SEQ        = SND2.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("AND   SND1.EUR_EDI_MSG_TP_ID   = SND2.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("AND   SND1.MSG_SND_NO          = SND2.MSG_SND_NO" ).append("\n"); 
		query.append("AND   SND1.EUR_EDI_MSG_TP_ID   = RCV1.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("AND   SND1.MSG_SND_NO          = RCV1.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("AND   SND1.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${d_type} != '') " ).append("\n"); 
		query.append("AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port_cd} != '') " ).append("\n"); 
		query.append("AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${msg_snd_no} != '') " ).append("\n"); 
		query.append("AND   SND1.MSG_SND_NO = @[msg_snd_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${snd_dt_from} != '') " ).append("\n"); 
		query.append("AND   SND1.SND_DT >=  TO_DATE(REPLACE(@[snd_dt_from],'-',''), 'YYYYMMDD') AND SND1.SND_DT < TO_DATE(REPLACE(@[snd_dt_to],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("AND   A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${msg_type} != '') " ).append("\n"); 
		query.append("	#if (${msg_type} != 'P') " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${msg_type} == 'E') " ).append("\n"); 
		query.append("			AND   SND1.MSG_SND_NO IS NULL AND RCV1.ACK_RCV_STS_CD IS NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND   RCV1.ACK_RCV_STS_CD = @[msg_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND   SND1.MSG_SND_NO IS NOT NULL AND RCV1.ACK_RCV_STS_CD IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${call_gubun} != 'ESM_BKG_0965') " ).append("\n"); 
		query.append("AND SND1.MSG_SND_NO LIKE 'IFTDGN%'" ).append("\n"); 
		query.append("GROUP BY SND1.MSG_SND_NO, RCV1.EUR_EDI_MSG_TP_ID ,RCV1.MSG_RCV_NO, RCV1.RCV_LOG_SEQ" ).append("\n"); 
		query.append("ORDER BY MAX(SND1.SND_DT) DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SND1.MSG_SND_NO LIKE 'HANSHI%'" ).append("\n"); 
		query.append("ORDER BY SND1.SND_DT DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}