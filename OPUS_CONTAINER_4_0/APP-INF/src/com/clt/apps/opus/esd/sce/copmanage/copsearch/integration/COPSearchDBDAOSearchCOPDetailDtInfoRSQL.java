/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COPSearchDBDAOSearchCOPDetailDtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.02.13 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchCOPDetailDtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPDetailDtInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchCOPDetailDtInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchCOPDetailDtInfoRSQL").append("\n"); 
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
		query.append("SELECT de_due_dt" ).append("\n"); 
		query.append("     , apnt_dt" ).append("\n"); 
		query.append("     , ob_dor_arr_dt" ).append("\n"); 
		query.append("     , sts_nm" ).append("\n"); 
		query.append("     , DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,1, 16)) as dlv_pln_date      " ).append("\n"); 
		query.append("     , DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,instr(dlv_dts, '#')+1, 17)) as dlv_estm_date" ).append("\n"); 
		query.append("     , dlv_dts" ).append("\n"); 
		query.append("     , DECODE(NVL(instr(tot_trans_dts, '#'), 0), 0,'', SUBSTR(tot_trans_dts,1, NVL(instr(tot_trans_dts, '#'), 0)-1)) as tot_trans_pln_date      " ).append("\n"); 
		query.append("     , DECODE(NVL(instr(tot_trans_dts, '#'), 0), 0,'', SUBSTR(tot_trans_dts,instr(tot_trans_dts, '#')+1, 17)) as tot_trans_estm_date" ).append("\n"); 
		query.append("     , tot_trans_dts   " ).append("\n"); 
		query.append("     , cop_sts_cd " ).append("\n"); 
		query.append("     , cop_sub_sts_cd  " ).append("\n"); 
		query.append("     , act_cd" ).append("\n"); 
		query.append("     ,DECODE(to_act_dt, NULL, DECODE(NVL(instr(tot_trans_dts, '#'), 0), 0,'', SUBSTR(tot_trans_dts,instr(tot_trans_dts, '#')+1, 17))," ).append("\n"); 
		query.append("      TO_CHAR(FLOOR(((to_act_dt  - fm_act_dt) * 24)/24)) || 'D ' || TO_CHAR(MOD(FLOOR(((to_act_dt  - fm_act_dt) * 24)),24))|| 'H') tot_trans_act_date" ).append("\n"); 
		query.append("  FROM(      " ).append("\n"); 
		query.append("        SELECT TO_CHAR(DE_DUE_DT,'yyyy-MM-dd hh24:mi') de_due_dt" ).append("\n"); 
		query.append("              ,TO_CHAR((SELECT DECODE(SUBSTR( cost_act_grp_cd, 1,2), 'ID', DOR_ARR_DT, '') " ).append("\n"); 
		query.append("                 FROM sce_pln_so_list" ).append("\n"); 
		query.append("                WHERE cop_no = @[cop_no]" ).append("\n"); 
		query.append("                  AND cost_act_grp_cd like 'ID%'),  'yyyy-MM-dd hh24:mi') AS apnt_dt --TO_CHAR(APNT_DT,'yyyy-MM-dd hh24:mi') APNT_DT" ).append("\n"); 
		query.append("              ,TO_CHAR((SELECT DECODE(SUBSTR( cost_act_grp_cd, 1,2), 'OD', DOR_ARR_DT, '') " ).append("\n"); 
		query.append("                 FROM sce_pln_so_list" ).append("\n"); 
		query.append("                WHERE cop_no = @[cop_no]" ).append("\n"); 
		query.append("                  AND cost_act_grp_cd like 'OD%'),  'yyyy-MM-dd hh24:mi')  AS ob_dor_arr_dt --TO_CHAR(OB_DOR_ARR_DT,'yyyy-MM-dd hh24:mi') OB_DOR_ARR_DT" ).append("\n"); 
		query.append("              ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00134',COP_STS_CD) as sts_nm" ).append("\n"); 
		query.append("              ,SCE_COP_DLV_DT_FNC(@[cop_no], @[bkg_no]) dlv_dts    " ).append("\n"); 
		query.append("              ,SCE_COP_TOT_TRAN_TIME_FNC(@[cop_no], @[bkg_no]) tot_trans_dts  " ).append("\n"); 
		query.append("              ,hdr.cop_sts_cd " ).append("\n"); 
		query.append("              ,DECODE(hdr.cop_sts_cd, 'F', hdr.cop_sub_sts_cd, '') AS cop_sub_sts_cd    " ).append("\n"); 
		query.append("              ,(SELECT MAX(act_cd)  FROM sce_cop_dtl WHERE cop_no = hdr.cop_no AND act_sts_cd  = 'C' ) act_cd        " ).append("\n"); 
		query.append("              ,(SELECT  GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(nod_cd,1,5), act_dt, 'GMT')                      " ).append("\n"); 
		query.append("                  FROM    (SELECT LEAD(nod_cd, DECODE(RCV_TERM_CD, 'S','0','1')) OVER (PARTITION BY cop_no ORDER BY cop_no,cop_dtl_seq) nod_cd," ).append("\n"); 
		query.append("                        LEAD(act_dt, DECODE(RCV_TERM_CD, 'S','0','1')) OVER (PARTITION BY cop_no ORDER BY cop_no,cop_dtl_seq) act_dt" ).append("\n"); 
		query.append("                FROM    sce_cop_dtl, BKG_BOOKING B  " ).append("\n"); 
		query.append("                WHERE   cop_no = @[cop_no] AND BKG_NO = @[bkg_no])  WHERE ROWNUM =1) fm_act_dt" ).append("\n"); 
		query.append("               ,(SELECT GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(nod_cd,1,5), act_dt, 'GMT') " ).append("\n"); 
		query.append("                FROM    (SELECT LEAD(nod_cd, DECODE(DE_TERM_CD, 'S','0','Y','2','1')) OVER (PARTITION BY cop_no ORDER BY cop_no desc,cop_dtl_seq desc) nod_cd," ).append("\n"); 
		query.append("                                LEAD(act_dt, DECODE(DE_TERM_CD, 'S','0','Y','2','1')) OVER (PARTITION BY cop_no ORDER BY cop_no desc,cop_dtl_seq desc) act_dt                                                " ).append("\n"); 
		query.append("                FROM    sce_cop_dtl, BKG_BOOKING B  " ).append("\n"); 
		query.append("                WHERE   cop_no = @[cop_no] AND BKG_NO = @[bkg_no])  where rownum =1) to_act_dt " ).append("\n"); 
		query.append("          FROM bkg_booking bkg" ).append("\n"); 
		query.append("              ,sce_cop_hdr hdr" ).append("\n"); 
		query.append("         WHERE bkg.bkg_no = hdr.bkg_no" ).append("\n"); 
		query.append("           AND bkg.bkg_no = @[bkg_no]   " ).append("\n"); 
		query.append("           AND hdr.cop_no = @[cop_no] " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}