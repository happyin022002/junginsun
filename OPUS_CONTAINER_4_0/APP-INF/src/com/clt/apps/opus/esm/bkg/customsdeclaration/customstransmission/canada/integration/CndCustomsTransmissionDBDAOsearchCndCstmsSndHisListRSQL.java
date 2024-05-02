/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.23 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsSndHisList
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("e_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL").append("\n"); 
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
		query.append("SELECT  A.TRSM_MSG_TP_ID " ).append("\n"); 
		query.append("       ,TO_CHAR(A.SND_DT,'YYYY-MM-DD  HH24:MI:SS') AS SND_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.SND_DT,'HH24:MI:SS') AS SND_HM" ).append("\n"); 
		query.append("       ,A.SND_USR_OFC_CD" ).append("\n"); 
		query.append("       ,A.SND_USR_ID" ).append("\n"); 
		query.append("       ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("       ,A.POL_CD" ).append("\n"); 
		query.append("       ,A.POD_CD" ).append("\n"); 
		query.append("       ,A.ACK_RCV_TP_ID" ).append("\n"); 
		query.append("       ,C1.ATTR_CTNT2 AS ACK_RCV_DESC" ).append("\n"); 
		query.append("       ,TO_CHAR(A.SND_DT,'YYYY-MM-DD  HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("       ,A.ACK_SND_KNT" ).append("\n"); 
		query.append("       ,A.ACK_RCV_KNT" ).append("\n"); 
		query.append("       ,A.ACK_ACPT_KNT" ).append("\n"); 
		query.append("       ,A.CNT_CD" ).append("\n"); 
		query.append("       ,A.IO_BND_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.SND_DT, 'YYYYMMDDHH24MISS') AS DTL_SND_DT" ).append("\n"); 
		query.append("       ,A.HIS_SEQ" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(D.EDI_SND_LOG_CTNT, 11, 2),'00','Original','04','Update', '03', 'Delete') AS IBFLAG" ).append("\n"); 
		query.append("       ,'' AS STWG_SND_ID" ).append("\n"); 
		query.append("       ,'' CNTR_KNT" ).append("\n"); 
		query.append("	   ,'' VVD_BAPLIE" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_SND_LOG A" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,BKG_HRD_CDG_CTNT C1" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_SND_LOG_DTL D" ).append("\n"); 
		query.append(" WHERE  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND  A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("   AND  C1.HRD_CDG_ID(+) = 'CND_ACK_CODE'" ).append("\n"); 
		query.append("--   AND  A.TRSM_MSG_TP_ID NOT IN ( 'EXA','EXS','EXE' )" ).append("\n"); 
		query.append("   AND  A.ACK_RCV_TP_ID = C1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  A.CNT_CD = D.CNT_CD" ).append("\n"); 
		query.append("   AND  A.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("   AND  A.SND_DT = D.SND_DT" ).append("\n"); 
		query.append("   AND  A.HIS_SEQ = D.HIS_SEQ" ).append("\n"); 
		query.append("   AND  (D.DTL_SEQ=4 AND D.CRE_USR_ID = 'MIG_USER'" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("         D.DTL_SEQ=5 AND D.CRE_USR_ID <> 'MIG_USER')" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND  A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND  A.CRR_BAT_NO = B.CRR_BAT_NO" ).append("\n"); 
		query.append("   AND  B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	   AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("	   AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("	   AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '')" ).append("\n"); 
		query.append("	   AND  A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	   AND  A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${trsm_msg_tp_id} != '')" ).append("\n"); 
		query.append("	   AND  A.TRSM_MSG_TP_ID = @[trsm_msg_tp_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${snd_dt_flg} != '')" ).append("\n"); 
		query.append("	   AND  A.SND_DT BETWEEN TO_DATE(@[s_snd_dt],'yyyyMMddhh24mi') AND TO_DATE(@[e_snd_dt],'yyyyMMddhh24mi')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${office} != '')" ).append("\n"); 
		query.append("	   AND  A.SND_USR_OFC_CD LIKE @[office] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${usr_id} != '')" ).append("\n"); 
		query.append("	   AND  A.SND_USR_ID LIKE @[usr_id] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trsm_msg_tp_id} == '' || ${trsm_msg_tp_id} == 'BACA') " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("  SELECT  'BAPLIE' TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("         ,TO_CHAR(L.SND_DT,'YYYY-MM-DD  HH24:MI:SS') AS SND_DT" ).append("\n"); 
		query.append("         ,TO_CHAR(L.SND_DT,'HH24:MI:SS') AS SND_HM" ).append("\n"); 
		query.append("         ,L.SND_USR_OFC_CD" ).append("\n"); 
		query.append("         ,L.SND_USR_ID" ).append("\n"); 
		query.append("         ,L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("         ,L.POL_CD" ).append("\n"); 
		query.append("         ,L.POD_CD" ).append("\n"); 
		query.append("         ,L.CSTMS_ACK_STS_CD ACK_RCV_TP_ID" ).append("\n"); 
		query.append("         ,L.CSTMS_ACK_DESC AS ACK_RCV_DESC" ).append("\n"); 
		query.append("         ,TO_CHAR(L.SND_DT,'YYYY-MM-DD  HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("         ,CASE WHEN L.SND_DT IS NOT NULL THEN 1 ELSE 0 END ACK_SND_KNT" ).append("\n"); 
		query.append("         ,CASE WHEN L.CSTMS_ACK_STS_CD IS NOT NULL THEN 1 ELSE 0 END ACK_RCV_KNT" ).append("\n"); 
		query.append("         ,CASE WHEN L.CSTMS_ACK_STS_CD = 'A' THEN 1 ELSE 0 END ACK_ACPT_KNT" ).append("\n"); 
		query.append("         ,'CA' CNT_CD" ).append("\n"); 
		query.append("         ,'I' IO_BND_CD" ).append("\n"); 
		query.append("         ,TO_CHAR(L.SND_DT, 'YYYYMMDDHH24MISS') AS DTL_SND_DT" ).append("\n"); 
		query.append("         ,0 HIS_SEQ" ).append("\n"); 
		query.append("         ,'Original'  AS IBFLAG" ).append("\n"); 
		query.append("         ,L.STWG_SND_ID" ).append("\n"); 
		query.append("         ,TO_CHAR(L.CNTR_KNT) CNTR_KNT" ).append("\n"); 
		query.append("		 ,L.VVD_CD AS VVD_BAPLIE" ).append("\n"); 
		query.append("  FROM     BKG_CSTMS_ADV_STWG_SND_LOG L" ).append("\n"); 
		query.append("          ,BKG_CSTMS_ADV_STWG_CNTR C" ).append("\n"); 
		query.append("  WHERE    1=1" ).append("\n"); 
		query.append("  AND      L.STWG_SND_ID = C.STWG_SND_ID(+)" ).append("\n"); 
		query.append("  AND      L.SND_DT 	  = C.SND_DT(+)" ).append("\n"); 
		query.append("  AND      L.SND_PROC_ID = 'STW_CA'" ).append("\n"); 
		query.append("  #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("     AND  L.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("     AND  L.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("     AND  L.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pol_cd} != '')" ).append("\n"); 
		query.append("     AND  L.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pod_cd} != '')" ).append("\n"); 
		query.append("     AND  L.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${snd_dt_flg} != '')" ).append("\n"); 
		query.append("     AND  L.SND_DT BETWEEN TO_DATE(@[s_snd_dt],'yyyyMMddhh24mi') AND TO_DATE(@[e_snd_dt],'yyyyMMddhh24mi')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${office} != '')" ).append("\n"); 
		query.append("     AND  L.SND_USR_OFC_CD LIKE @[office] || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${usr_id} != '')" ).append("\n"); 
		query.append("     AND  L.SND_USR_ID LIKE @[usr_id] || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 2 /*A.SND_DT/*, 19 /*A.HIS_SEQ*/" ).append("\n"); 

	}
}