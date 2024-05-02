/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RcvHistListDetailVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchReceivedHistoryListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 T2.CNT_CD" ).append("\n"); 
		query.append("	,T2.IO_BND_CD" ).append("\n"); 
		query.append("	,T2.RCV_DATE" ).append("\n"); 
		query.append("	,T2.RCV_DT" ).append("\n"); 
		query.append("	,T2.RCV_TM" ).append("\n"); 
		query.append("	,T2.RCV_SEQ" ).append("\n"); 
		query.append("	,T2.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("	,T2.VVD" ).append("\n"); 
		query.append("	,T2.POL_CD" ).append("\n"); 
		query.append("	,T2.POD_CD" ).append("\n"); 
		query.append("    ,CASE WHEN NVL(MIN(T2.VPOD_CD),'X') != 'X' AND NVL(MIN(VPOD_CD_SND),'X') != 'X' THEN MIN(VPOD_CD_SND) ELSE MIN(T2.VPOD_CD) END VPOD_CD" ).append("\n"); 
		query.append("	,T2.CSTMS_BAT_NO" ).append("\n"); 
		query.append("	,T2.SCAC_CD" ).append("\n"); 
		query.append("	,T2.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("	,T2.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("	,CASE T2.RCV_MSG_TP_ID WHEN 'BR' THEN DECODE (SUBSTR(MAX(DTL.MSG_DESC),12,1), 'A', 'N', 'Y')" ).append("\n"); 
		query.append("                           ELSE DECODE (MAX(DTL.MSG_DESC), NULL, 'N', 'Y')" ).append("\n"); 
		query.append("     END AS RJCT_FLG" ).append("\n"); 
		query.append("	,DECODE(T2.RCV_MSG_TP_ID, 'MR', '', T2.BL_NO) BL_NO" ).append("\n"); 
		query.append("	,SUBSTR (MAX (DTL.MSG_DESC), 40) REASON" ).append("\n"); 
		query.append("	, T2.RNUM" ).append("\n"); 
		query.append("	, T2.TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		    SELECT   *" ).append("\n"); 
		query.append("		    FROM (" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT T.*" ).append("\n"); 
		query.append("                     ,ROW_NUMBER() OVER(ORDER BY T.RCV_DT DESC, T.RCV_TM DESC, T.RCV_SEQ) AS RNUM" ).append("\n"); 
		query.append("                     ,COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        #if (${bl_no} != '') " ).append("\n"); 
		query.append("                        SELECT   " ).append("\n"); 
		query.append("                                                LOG.CNT_CD" ).append("\n"); 
		query.append("                                                ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                                                ,LOG.RCV_DT AS RCV_DATE" ).append("\n"); 
		query.append("                                                ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDD') AS RCV_DT" ).append("\n"); 
		query.append("                                                ,TO_CHAR(LOG.RCV_DT, 'HH24MISS') AS RCV_TM" ).append("\n"); 
		query.append("                                                ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                                                ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                                                ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                                                ,LOG.POL_CD" ).append("\n"); 
		query.append("                                                ,LOG.POD_CD" ).append("\n"); 
		query.append("                                                ,MIN(BL.CSTMS_POD_CD) VPOD_CD" ).append("\n"); 
		query.append("                                                ,MIN((SELECT POD_CD FROM BKG_CSTMS_ADV_SND_LOG SND_LOG WHERE CNT_CD = 'US' AND IO_BND_CD  = NVL(@[io_bnd_cd], 'I') AND LOG.CRR_BAT_NO = SND_LOG.CRR_BAT_NO)) VPOD_CD_SND" ).append("\n"); 
		query.append("                                                ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                                                ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                                                ,LOG.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("                                                ,LOG.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("                                                ,LOG.BL_NO AS BL_NO" ).append("\n"); 
		query.append("                                                ,MIN((SELECT SLS_OFC_CD FROM MDM_LOCATION X WHERE X.LOC_CD = LOG.POL_CD)) POL_LOC_CD" ).append("\n"); 
		query.append("                                                                                                " ).append("\n"); 
		query.append("                        FROM     " ).append("\n"); 
		query.append("                                BKG_CSTMS_ADV_RCV_LOG LOG" ).append("\n"); 
		query.append("                                ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                        WHERE   1=1" ).append("\n"); 
		query.append("                        AND     LOG.CNT_CD     = BL.CNT_CD(+)" ).append("\n"); 
		query.append("                        AND     LOG.BL_NO      = BL.BL_NO(+) " ).append("\n"); 
		query.append("                        AND     LOG.CNT_CD     = 'US'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                        #if (${rcv_msg_tp_id} != '' && ${rcv_msg_tp_id} != 'AL') " ).append("\n"); 
		query.append("                        AND		LOG.RCV_MSG_TP_ID = @[rcv_msg_tp_id]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                        #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("                        AND     LOG.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     LOG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND     LOG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${cstms_bat_no} != '') " ).append("\n"); 
		query.append("                        AND		LOG.CSTMS_BAT_NO = @[cstms_bat_no]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${scac_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if (${bl_no} != '') " ).append("\n"); 
		query.append("                        AND		LOG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND     LOG.IO_BND_CD  = NVL(@[io_bnd_cd], 'I')" ).append("\n"); 
		query.append("                        #if (${fromd} != '') " ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT >= TO_DATE('19000101000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                        #if (${tod} != '') " ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT <= TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT <= TO_DATE('99991231235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                        #end  " ).append("\n"); 
		query.append("                        GROUP BY    " ).append("\n"); 
		query.append("                             LOG.CNT_CD" ).append("\n"); 
		query.append("                            ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                            ,LOG.RCV_DT" ).append("\n"); 
		query.append("                            ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                            ,TO_CHAR(LOG.RCV_DT, 'HH24MISS')" ).append("\n"); 
		query.append("                            ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                            ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                            ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,LOG.POL_CD" ).append("\n"); 
		query.append("                            ,LOG.POD_CD" ).append("\n"); 
		query.append("                            ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                            ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                            ,LOG.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("                            ,LOG.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("                            ,LOG.BL_NO " ).append("\n"); 
		query.append("                        UNION" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                        SELECT   " ).append("\n"); 
		query.append("                                                LOG.CNT_CD" ).append("\n"); 
		query.append("                                                ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                                                ,LOG.RCV_DT AS RCV_DATE" ).append("\n"); 
		query.append("                                                ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDD') AS RCV_DT" ).append("\n"); 
		query.append("                                                ,TO_CHAR(LOG.RCV_DT, 'HH24MISS') AS RCV_TM" ).append("\n"); 
		query.append("                                                ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                                                ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                                                ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                                                ,LOG.POL_CD" ).append("\n"); 
		query.append("                                                ,LOG.POD_CD" ).append("\n"); 
		query.append("                                                ,MIN(BL.CSTMS_POD_CD) VPOD_CD" ).append("\n"); 
		query.append("                                                ,MIN((SELECT POD_CD FROM BKG_CSTMS_ADV_SND_LOG SND_LOG WHERE CNT_CD = 'US' AND IO_BND_CD  = NVL(@[io_bnd_cd], 'I') AND LOG.CRR_BAT_NO = SND_LOG.CRR_BAT_NO)) VPOD_CD_SND" ).append("\n"); 
		query.append("                                                ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                                                ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                                                ,LOG.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("                                                ,LOG.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("                                                ,MAX(EDI.BL_NO) BL_NO" ).append("\n"); 
		query.append("                                                ,MIN((SELECT SLS_OFC_CD FROM MDM_LOCATION X WHERE X.LOC_CD = LOG.POL_CD)) POL_LOC_CD" ).append("\n"); 
		query.append("                        FROM     " ).append("\n"); 
		query.append("                                BKG_CSTMS_ADV_RCV_LOG LOG" ).append("\n"); 
		query.append("                                ,BKG_CSTMS_ADV_EDI_BL_RSPN EDI" ).append("\n"); 
		query.append("                                ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                        WHERE   1=1" ).append("\n"); 
		query.append("                        AND     LOG.CNT_CD     = EDI.CNT_CD(+)" ).append("\n"); 
		query.append("                        AND     LOG.CRR_BAT_NO = EDI.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("                        AND     EDI.CNT_CD     = BL.CNT_CD(+)" ).append("\n"); 
		query.append("                        AND     EDI.BL_NO      = BL.BL_NO(+)" ).append("\n"); 
		query.append("                        AND     LOG.CNT_CD     = 'US'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                        #if (${rcv_msg_tp_id} != '' && ${rcv_msg_tp_id} != 'AL') " ).append("\n"); 
		query.append("                        AND		LOG.RCV_MSG_TP_ID = @[rcv_msg_tp_id]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                        #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("                        AND     LOG.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     LOG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND     LOG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${cstms_bat_no} != '') " ).append("\n"); 
		query.append("                        AND		LOG.CSTMS_BAT_NO = @[cstms_bat_no]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${scac_cd} != '') " ).append("\n"); 
		query.append("                        AND		LOG.SCAC_CD = @[scac_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if (${bl_no} != '') " ).append("\n"); 
		query.append("                        AND		EDI.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND     LOG.IO_BND_CD  = NVL(@[io_bnd_cd], 'I')" ).append("\n"); 
		query.append("                        #if (${fromd} != '') " ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT >= TO_DATE('19000101000000','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                        #if (${tod} != '') " ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT <= TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                        AND 	LOG.RCV_DT <= TO_DATE('99991231235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                        #end  " ).append("\n"); 
		query.append("                        GROUP BY    " ).append("\n"); 
		query.append("                             LOG.CNT_CD" ).append("\n"); 
		query.append("                            ,LOG.IO_BND_CD" ).append("\n"); 
		query.append("                            ,LOG.RCV_DT" ).append("\n"); 
		query.append("                            ,TO_CHAR(LOG.RCV_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                            ,TO_CHAR(LOG.RCV_DT, 'HH24MISS')" ).append("\n"); 
		query.append("                            ,LOG.RCV_SEQ" ).append("\n"); 
		query.append("                            ,LOG.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("                            ,LOG.VSL_CD || LOG.SKD_VOY_NO || LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,LOG.POL_CD" ).append("\n"); 
		query.append("                            ,LOG.POD_CD" ).append("\n"); 
		query.append("                            ,LOG.CSTMS_BAT_NO" ).append("\n"); 
		query.append("                            ,LOG.SCAC_CD" ).append("\n"); 
		query.append("                            ,LOG.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("                            ,LOG.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("                ) T " ).append("\n"); 
		query.append("			   #if (${rct_rhq_cd} != '' && ${vsl_cd} != '' ) " ).append("\n"); 
		query.append("			   ,(" ).append("\n"); 
		query.append("			        SELECT OFC_CD OG_OFC_CD" ).append("\n"); 
		query.append("			        FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("			        START WITH A.OFC_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("			        CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("			    ) OG  " ).append("\n"); 
		query.append("			    WHERE T.POL_LOC_CD = OG.OG_OFC_CD" ).append("\n"); 
		query.append("			    #end                 " ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("        WHERE T1.RNUM BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("	) T2" ).append("\n"); 
		query.append("	, BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("	WHERE T2.CNT_CD = DTL.CNT_CD(+)" ).append("\n"); 
		query.append("	AND T2.IO_BND_CD = DTL.IO_BND_CD(+)" ).append("\n"); 
		query.append("	AND T2.RCV_DATE = DTL.RCV_DT(+)" ).append("\n"); 
		query.append("	AND T2.RCV_SEQ = DTL.RCV_SEQ(+)" ).append("\n"); 
		query.append("	AND DTL.RCV_MSG_DTL_SEQ(+) > 0" ).append("\n"); 
		query.append("	AND DTL.MSG_DESC(+) LIKE CASE T2.RCV_MSG_TP_ID WHEN 'BR' THEN 'ACK_RESULT%'" ).append("\n"); 
		query.append("                                                   ELSE 'W01%'" ).append("\n"); 
		query.append("                             END                                                    " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("	   T2.CNT_CD" ).append("\n"); 
		query.append("		,T2.IO_BND_CD" ).append("\n"); 
		query.append("		,T2.RCV_DATE" ).append("\n"); 
		query.append("		,T2.RCV_DT" ).append("\n"); 
		query.append("		,T2.RCV_TM" ).append("\n"); 
		query.append("		,T2.RCV_SEQ" ).append("\n"); 
		query.append("		,T2.RCV_MSG_TP_ID" ).append("\n"); 
		query.append("		,T2.VVD" ).append("\n"); 
		query.append("		,T2.POL_CD" ).append("\n"); 
		query.append("		,T2.POD_CD" ).append("\n"); 
		query.append("		,T2.CSTMS_BAT_NO" ).append("\n"); 
		query.append("		,T2.SCAC_CD" ).append("\n"); 
		query.append("		,T2.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("		,T2.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("		,DECODE(T2.RCV_MSG_TP_ID, 'MR', '', T2.BL_NO)" ).append("\n"); 
		query.append("		,T2.RNUM" ).append("\n"); 
		query.append("		,T2.TOTAL" ).append("\n"); 
		query.append("		,T2.BL_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	ORDER BY T2.RNUM" ).append("\n"); 

	}
}