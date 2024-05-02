/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COPSearchDBDAOSearchTransportationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchTransportationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTransportationInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchTransportationInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchTransportationInfoRSQL").append("\n"); 
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
		query.append("SELECT  cop_no " ).append("\n"); 
		query.append("      , cop_dtl_seq" ).append("\n"); 
		query.append("      , rail_rcv_coff_fm_dt" ).append("\n"); 
		query.append("      , act_cd" ).append("\n"); 
		query.append("      , act_nm" ).append("\n"); 
		query.append("      , vvd" ).append("\n"); 
		query.append("      , nod_cd" ).append("\n"); 
		query.append("      , pln_date" ).append("\n"); 
		query.append("      , pln_time" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , fx_pln_date" ).append("\n"); 
		query.append("      , fx_pln_time" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , estm_date" ).append("\n"); 
		query.append("      , estm_time" ).append("\n"); 
		query.append("      , act_date" ).append("\n"); 
		query.append("      , act_time" ).append("\n"); 
		query.append("      , act_rcv_tp_Cd" ).append("\n"); 
		query.append("      , act_sts_cd" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("        SELECT scd.cop_no" ).append("\n"); 
		query.append("             , scd.cop_dtl_seq" ).append("\n"); 
		query.append("             , (SELECT MAX(TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYY-MM-DD')) FROM BKG_CLZ_TM WHERE BKG_NO=@[bkg_no] AND CLZ_TP_CD='F')" ).append("\n"); 
		query.append("				||(SELECT MAX(TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), ' ~ YYYY-MM-DD')) FROM BKG_CLZ_TM WHERE BKG_NO=@[bkg_no] AND CLZ_TP_CD='O') AS rail_rcv_coff_fm_dt " ).append("\n"); 
		query.append("             , MIN(scd.act_cd) act_cd" ).append("\n"); 
		query.append("             , MIN(ma.act_nm)||max(decode(NVL(scd.ACT_STS_MAPG_CD,'a'),'a','',DECODE(scd.ACT_RCV_TP_CD , 1 ,'    ('||NVL(scd.ACT_STS_MAPG_CD,'')||')','' ))) act_nm" ).append("\n"); 
		query.append("             , (scd.VSL_CD || scd.SKD_VOY_NO || scd.SKD_DIR_CD) vvd " ).append("\n"); 
		query.append("             , MIN(scd.nod_cd) nod_cd " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.pln_dt,'yyyy-MM-dd')) pln_date " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.pln_dt,'hh24:mi')) pln_time" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.fx_pln_dt,'yyyy-MM-dd')) fx_pln_date " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.fx_pln_dt,'hh24:mi')) fx_pln_time " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.estm_dt,'yyyy-MM-dd')) estm_date " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.estm_dt,'hh24:mi')) estm_time " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.act_dt,'yyyy-MM-dd')) act_date " ).append("\n"); 
		query.append("             , MIN(TO_CHAR(scd.act_dt,'hh24:mi')) act_time " ).append("\n"); 
		query.append("             , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00141',MIN(scd.act_rcv_tp_cd)) || DECODE(NVL(scd.EDI_MSG_TP_CD,''),'','','('||scd.EDI_MSG_TP_CD||')')  " ).append("\n"); 
		query.append("               ||(DECODE(MIN(scd.act_rcv_tp_cd),'4','('||MIN(scd.upd_usr_id)||')')) act_rcv_tp_cd    " ).append("\n"); 
		query.append("             , act_sts_cd" ).append("\n"); 
		query.append("          FROM sce_cop_hdr sch, " ).append("\n"); 
		query.append("              (SELECT cop_no, '' AS cop_grp_seq" ).append("\n"); 
		query.append("                    , cop_dtl_seq" ).append("\n"); 
		query.append("                    , act_cd" ).append("\n"); 
		query.append("                    , act_sts_mapg_cd" ).append("\n"); 
		query.append("                    , act_rcv_tp_cd" ).append("\n"); 
		query.append("                    , vsl_cd" ).append("\n"); 
		query.append("                    , skd_voy_no" ).append("\n"); 
		query.append("                    , skd_dir_cd" ).append("\n"); 
		query.append("                    , nod_cd" ).append("\n"); 
		query.append("                    -- Plan시간을 30분단위, 00단위 표시 변경 " ).append("\n"); 
		query.append("                    ,(CASE WHEN TO_CHAR(pln_dt,'mi') >= '01' AND TO_CHAR(pln_dt,'mi') <= '30' " ).append("\n"); 
		query.append("                                THEN pln_dt + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(pln_dt,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("                           WHEN TO_CHAR(pln_dt,'mi') >= '31' AND TO_CHAR(pln_dt,'mi') <= '59' " ).append("\n"); 
		query.append("                                THEN pln_dt + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(pln_dt,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                           ELSE pln_dt " ).append("\n"); 
		query.append("                      END) pln_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ,CASE WHEN COP_DTL_SEQ < 4000 THEN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							CASE WHEN TO_CHAR(PLN_DT,'mi') >= '01' AND TO_CHAR(PLN_DT,'mi') <= '30' " ).append("\n"); 
		query.append("								THEN PLN_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(PLN_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("							WHEN TO_CHAR(PLN_DT,'mi') >= '31' AND TO_CHAR(PLN_DT,'mi') <= '59' " ).append("\n"); 
		query.append("								THEN PLN_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(PLN_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("							ELSE  PLN_DT" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("						) " ).append("\n"); 
		query.append("						WHEN COP_DTL_SEQ >= 6000 THEN " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							CASE WHEN TO_CHAR(fx_pln_dt,'mi') >= '01' AND TO_CHAR(fx_pln_dt,'mi') <= '30' " ).append("\n"); 
		query.append("								THEN fx_pln_dt + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(fx_pln_dt,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("							WHEN TO_CHAR(fx_pln_dt,'mi') >= '31' AND TO_CHAR(fx_pln_dt,'mi') <= '59' " ).append("\n"); 
		query.append("								THEN fx_pln_dt + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(fx_pln_dt,'mi')),'MINUTE') " ).append("\n"); 
		query.append("							ELSE fx_pln_dt" ).append("\n"); 
		query.append("							END        " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							NULL" ).append("\n"); 
		query.append("                      END fx_pln_dt         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     -- Plan시간을 30분단위, 00단위 표시 변경 " ).append("\n"); 
		query.append("                    ,(CASE WHEN TO_CHAR(estm_dt,'mi') >= '01' AND TO_CHAR(estm_dt,'mi') <= '30' " ).append("\n"); 
		query.append("                                THEN estm_dt + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(estm_dt,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("                           WHEN TO_CHAR(estm_dt,'mi') >= '31' AND TO_CHAR(estm_dt,'mi') <= '59' " ).append("\n"); 
		query.append("                                THEN estm_dt + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(estm_dt,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                           ELSE estm_dt " ).append("\n"); 
		query.append("                      END) estm_dt  " ).append("\n"); 
		query.append("                    , act_dt" ).append("\n"); 
		query.append("                    , edi_msg_tp_cd" ).append("\n"); 
		query.append("                    , upd_usr_id " ).append("\n"); 
		query.append("                    , act_sts_cd" ).append("\n"); 
		query.append("                FROM sce_cop_dtl " ).append("\n"); 
		query.append("               WHERE cop_no   = @[cop_no]" ).append("\n"); 
		query.append("               ) scd," ).append("\n"); 
		query.append("               mdm_activity ma" ).append("\n"); 
		query.append("         WHERE sch.cop_no       = scd.cop_no " ).append("\n"); 
		query.append("           AND scd.act_cd       = ma.act_cd " ).append("\n"); 
		query.append("           AND sch.cop_no       = @[cop_no]" ).append("\n"); 
		query.append("           AND sch.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         GROUP BY scd.cop_no, scd.cop_grp_seq, scd.cop_dtl_seq,scd.VSL_CD,scd.SKD_VOY_NO,scd.SKD_DIR_CD,scd.EDI_MSG_TP_CD,rail_rcv_coff_fm_dt, rail_rcv_coff_to_dt, act_sts_cd" ).append("\n"); 
		query.append("         ORDER BY scd.cop_no, scd.cop_grp_seq, scd.cop_dtl_seq" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}