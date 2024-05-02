/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : COPSearchDBDAOSearchCOPMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.14 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchCOPMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop inquiry
	  * </pre>
	  */
	public COPSearchDBDAOSearchCOPMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchCOPMainListRSQL").append("\n"); 
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
		query.append("SELECT TOTCNT, cop_no AS r_cop_no, cop_dtl_seq, cntr_no_v, cntr_tpsz_cd, cntr_vol_qty, mst_lcl_cd, " ).append("\n"); 
		query.append("       bkg_no AS r_bkg_no, cop_sts_cd, cop_sts_nm, act_cd, act_nm, nod_cd," ).append("\n"); 
		query.append("       pln_date, pln_time, estm_date, estm_time, due_date, due_time," ).append("\n"); 
		query.append("       cop_ext_sts_cd, cop_sub_sts_cd, dlv_dts, cntr_no AS r_cntr_no," ).append("\n"); 
		query.append("       r_cop_sub_sts_cd," ).append("\n"); 
		query.append("       DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,1, 10)) as dlv_pln_date," ).append("\n"); 
		query.append("       DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,12, 5)) as dlv_pln_time," ).append("\n"); 
		query.append("       DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,instr(dlv_dts, '#')+1, 10)) as dlv_estm_date," ).append("\n"); 
		query.append("       DECODE(NVL(instr(dlv_dts, '#'), 0), 0,'', SUBSTR(dlv_dts,instr(dlv_dts, '#')+12, 5)) as dlv_estm_time," ).append("\n"); 
		query.append("       '' AS cre_usr_id," ).append("\n"); 
		query.append("       '' AS upd_usr_id," ).append("\n"); 
		query.append("       MAN_FLG," ).append("\n"); 
		query.append("       PCTL_NO" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("				SELECT t2.TOTCNT TOTCNT, t2.cop_no," ).append("\n"); 
		query.append("				        TO_CHAR(t2.cop_dtl_seq) cop_dtl_seq," ).append("\n"); 
		query.append("				        decode(substr(t2.cntr_no,5),'0000000','',t2.cntr_no) cntr_no_v , t2.cntr_tpsz_cd ," ).append("\n"); 
		query.append("				        cntr_vol_qty ," ).append("\n"); 
		query.append("				        DECODE(mst_lcl_cd, 'P', 'Y', '') AS mst_lcl_cd ," ).append("\n"); 
		query.append("				        t2.bkg_no," ).append("\n"); 
		query.append("				        t2.cop_sts_cd," ).append("\n"); 
		query.append("				        COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00134', t2.cop_sts_cd) cop_sts_nm," ).append("\n"); 
		query.append("				        t2.act_cd," ).append("\n"); 
		query.append("				        t2.act_nm," ).append("\n"); 
		query.append("				        t2.nod_cd," ).append("\n"); 
		query.append("				        TO_CHAR(t2.pln_dt,'yyyy-MM-dd') pln_date," ).append("\n"); 
		query.append("				        TO_CHAR(t2.pln_dt,'hh24:mi') pln_time," ).append("\n"); 
		query.append("				        TO_CHAR(t2.estm_dt,'yyyy-MM-dd') estm_date," ).append("\n"); 
		query.append("				        TO_CHAR(t2.estm_dt,'hh24:mi') estm_time," ).append("\n"); 
		query.append("				        TO_CHAR(t2.de_due_dt,'yyyy-MM-dd') due_date," ).append("\n"); 
		query.append("				        TO_CHAR(t2.de_due_dt,'hh24:mi') due_time," ).append("\n"); 
		query.append("				        CASE" ).append("\n"); 
		query.append("				            WHEN t2.cop_expt_sts_cd = 'O' THEN '02'" ).append("\n"); 
		query.append("				            WHEN t2.cop_expt_sts_cd = 'R' THEN '01' " ).append("\n"); 
		query.append("                            ELSE '-1'" ).append("\n"); 
		query.append("				        END cop_ext_sts_cd," ).append("\n"); 
		query.append("				        DECODE(t2.cop_sub_sts_cd, 'R', 'Y', 'N') AS cop_sub_sts_cd ," ).append("\n"); 
		query.append("				        TO_CHAR(SCE_COP_DLV_DT_FNC(t2.cop_no, t2.bkg_no)) dlv_dts, " ).append("\n"); 
		query.append("				        DECODE(t2.cop_sts_cd, 'F', t2.cop_sub_sts_cd, '') AS r_cop_sub_sts_cd ,    " ).append("\n"); 
		query.append("				        t2.cntr_no," ).append("\n"); 
		query.append("                       (SELECT DECODE(BKG_EVNT_TP_CD, 'MC' ,'Y' ,'N') FROM SCE_COP_HIS H" ).append("\n"); 
		query.append("                         WHERE H.COP_NO = t2.COP_NO" ).append("\n"); 
		query.append("                           AND BKG_EVNT_TP_CD = 'MC'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) MAN_FLG," ).append("\n"); 
		query.append("                       T2.PCTL_NO" ).append("\n"); 
		query.append("				 FROM  (    " ).append("\n"); 
		query.append("				         SELECT  t1.*," ).append("\n"); 
		query.append("				                 CEIL(rownum/@[pagerows]) page , COUNT(1) OVER() TOTCNT" ).append("\n"); 
		query.append("				           FROM ( SELECT schg.*," ).append("\n"); 
		query.append("				                         scd.cop_dtl_seq," ).append("\n"); 
		query.append("				                         scd.act_cd," ).append("\n"); 
		query.append("				                         ma.act_nm," ).append("\n"); 
		query.append("				                         scd.nod_cd," ).append("\n"); 
		query.append("				                         scd.pln_dt," ).append("\n"); 
		query.append("				                         scd.estm_dt," ).append("\n"); 
		query.append("				                         sce.cop_expt_sts_cd," ).append("\n"); 
		query.append("				                         bb.de_due_dt," ).append("\n"); 
		query.append("                                         row_number() over(PARTITION BY schg.cop_no  ORDER BY cop_dtl_seq) a," ).append("\n"); 
		query.append("                                         count(schg.cop_no) over(PARTITION BY schg.cop_no) b" ).append("\n"); 
		query.append("				                   FROM  sce_cop_dtl scd," ).append("\n"); 
		query.append("				                         bkg_booking bb," ).append("\n"); 
		query.append("				                         mdm_activity ma," ).append("\n"); 
		query.append("				                        ( SELECT sch.cop_no," ).append("\n"); 
		query.append("				                                 sch.bkg_no," ).append("\n"); 
		query.append("				                                 sch.cop_sts_cd," ).append("\n"); 
		query.append("				                                 sch.cntr_no," ).append("\n"); 
		query.append("				                                 sch.cntr_tpsz_cd," ).append("\n"); 
		query.append("				                                 bb.bl_no," ).append("\n"); 
		query.append("				                                 cntr_vol_qty," ).append("\n"); 
		query.append("				                                 decode(sch.cop_no, mst_cop_no, 'P', 'X') as mst_lcl_cd," ).append("\n"); 
		query.append("				                                 sch.COP_SUB_STS_CD," ).append("\n"); 
		query.append("				                                 scag.trsp_so_ofc_cty_cd || scag.trsp_so_seq so_no," ).append("\n"); 
		query.append("                                                 SCH.PCTL_NO" ).append("\n"); 
		query.append("				                           FROM  sce_cop_hdr sch," ).append("\n"); 
		query.append("				                                 TRS_TRSP_SVC_ORD scag, " ).append("\n"); 
		query.append("				                                 bkg_booking bb, " ).append("\n"); 
		query.append("				                                 bkg_container cntr          " ).append("\n"); 
		query.append("				                          WHERE  1 =1 " ).append("\n"); 
		query.append("				                            AND  sch.cop_no = scag.cop_no(+)                                                          " ).append("\n"); 
		query.append("				                            AND  sch.bkg_no = bb.bkg_no " ).append("\n"); 
		query.append("				                            AND  sch.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("				                            AND  sch.cntr_no = cntr.cntr_no(+)" ).append("\n"); 
		query.append("									#if (${bkg_no} != '')   " ).append("\n"); 
		query.append("				                            AND     sch.bkg_no = @[bkg_no]                                                                               " ).append("\n"); 
		query.append("									#end       		" ).append("\n"); 
		query.append("									#if (${bl_no} != '')   " ).append("\n"); 
		query.append("				                            AND     bb.bl_no = @[bl_no]                                                                                " ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${cntr_no} != '')   " ).append("\n"); 
		query.append("				                            AND     sch.cntr_no = @[cntr_no]    " ).append("\n"); 
		query.append("				                            AND     bb.bkg_cre_dt between to_date(@[bkg_cre_dt1],'YYYY/MM/DD HH24:MI:SS')  and  to_date(@[bkg_cre_dt2],'YYYY/MM/DD HH24:MI:SS') + 1  " ).append("\n"); 
		query.append("									#end       		" ).append("\n"); 
		query.append("									#if (${ref_no} != '')   " ).append("\n"); 
		query.append("                                            AND     sch.bkg_no  IN (      SELECT bkg_no" ).append("\n"); 
		query.append("                                                                            FROM BKG_REFERENCE " ).append("\n"); 
		query.append("                                                                           WHERE BKG_REF_TP_CD = 'EBRF'" ).append("\n"); 
		query.append("                                                                             AND CUST_REF_NO_CTNT = @[ref_no]  )                                                                              " ).append("\n"); 
		query.append("									#end    " ).append("\n"); 
		query.append("									#if (${so_no} != '')   " ).append("\n"); 
		query.append("				                            AND     scag.trsp_so_ofc_cty_cd = SUBSTR(@[so_no] ,1,3)                                                                                " ).append("\n"); 
		query.append("				                            AND     scag.trsp_so_seq = TO_NUMBER(SUBSTR(@[so_no] ,4))                                                                                " ).append("\n"); 
		query.append("									#end    " ).append("\n"); 
		query.append("									#if (${cop_no} != '')   " ).append("\n"); 
		query.append("				                            AND     sch.cop_no = @[cop_no]                                                                                " ).append("\n"); 
		query.append("									#end  " ).append("\n"); 
		query.append("				                          group by sch.cop_no," ).append("\n"); 
		query.append("			                                    sch.bkg_no," ).append("\n"); 
		query.append("				                                sch.cop_sts_cd," ).append("\n"); 
		query.append("				                                sch.cntr_no," ).append("\n"); 
		query.append("				                                sch.cntr_tpsz_cd," ).append("\n"); 
		query.append("				                                bb.bl_no,scag.trsp_so_ofc_cty_cd ," ).append("\n"); 
		query.append("				                                scag.trsp_so_seq," ).append("\n"); 
		query.append("				                                decode(sch.cop_no, mst_cop_no, 'P', 'X') ," ).append("\n"); 
		query.append("                                                sch.COP_SUB_STS_CD," ).append("\n"); 
		query.append("                                                cntr_vol_qty," ).append("\n"); 
		query.append("                                                SCH.PCTL_NO" ).append("\n"); 
		query.append("				 			              ) schg," ).append("\n"); 
		query.append("				                          /* minestar -  EXPT 관련 조인 시작*/" ).append("\n"); 
		query.append("				                         ( " ).append("\n"); 
		query.append("                                          -- union을 사용하여 조회조건에 따라 sql을 삽입하므로 첫번째 조회는 항상 필요하여 dummy 값을 가져오는 sql 추가함" ).append("\n"); 
		query.append("				                          SELECT '' COP_NO,'' COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   DUAL               " ).append("\n"); 
		query.append("									#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                                          UNION            --bkg_no" ).append("\n"); 
		query.append("				                          SELECT MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   SCE_EXPT_MST MST              " ).append("\n"); 
		query.append("				                          WHERE  MST.BKG_NO = @[bkg_no]            " ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO  " ).append("\n"); 
		query.append("                                    #end      " ).append("\n"); 
		query.append("									#if (${cop_no} != '')        " ).append("\n"); 
		query.append("				                          UNION              --cop_no              " ).append("\n"); 
		query.append("				                          SELECT MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   SCE_EXPT_MST MST              " ).append("\n"); 
		query.append("				                          WHERE  MST.COP_NO = @[cop_no]             " ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO " ).append("\n"); 
		query.append("			  					    #end " ).append("\n"); 
		query.append("									#if (${so_no} != '')                     " ).append("\n"); 
		query.append("				                          UNION              --so_no              " ).append("\n"); 
		query.append("				                          SELECT MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   TRS_TRSP_SVC_ORD GRP, SCE_EXPT_MST MST              " ).append("\n"); 
		query.append("				                          WHERE  GRP.TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_no], 1,3) AND GRP.TRSP_SO_SEQ = TO_NUMBER(SUBSTR(@[so_no],4))              " ).append("\n"); 
		query.append("				                          AND    MST.COP_NO = GRP.COP_NO              " ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO   " ).append("\n"); 
		query.append("			  					    #end " ).append("\n"); 
		query.append("									#if (${bl_no} != '')                     " ).append("\n"); 
		query.append("				                          UNION              --bl_no              " ).append("\n"); 
		query.append("				                          SELECT MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   BKG_BOOKING BB, SCE_EXPT_MST MST              " ).append("\n"); 
		query.append("				                          WHERE  BB.BL_NO = @[bl_no]                       --bl_no              " ).append("\n"); 
		query.append("				                          AND    MST.BKG_NO = BB.BKG_NO              " ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO " ).append("\n"); 
		query.append("			  					    #end " ).append("\n"); 
		query.append("									#if (${cntr_no} != '')                     " ).append("\n"); 
		query.append("				                          UNION              --bkg_dt, cntr_no              " ).append("\n"); 
		query.append("				                          SELECT /*+ ordered */" ).append("\n"); 
		query.append("                                                 MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD              " ).append("\n"); 
		query.append("				                          FROM   SCE_EXPT_MST MST ,BKG_BOOKING BB             " ).append("\n"); 
		query.append("				                          WHERE  (BB.BKG_CRE_DT BETWEEN TO_DATE(@[bkg_cre_dt1],'YYYY/MM/DD HH24:MI:SS') AND TO_DATE(@[bkg_cre_dt2],'YYYY/MM/DD HH24:MI:SS') + 1)" ).append("\n"); 
		query.append("				                          AND    MST.BKG_NO = BB.BKG_NO              " ).append("\n"); 
		query.append("				                          AND    MST.CNTR_NO = @[cntr_no]             " ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO  " ).append("\n"); 
		query.append("			  					    #end " ).append("\n"); 
		query.append("									#if (${ref_no} != '')  " ).append("\n"); 
		query.append("										  UNION              --ref_no" ).append("\n"); 
		query.append("				                          SELECT MST.COP_NO, MIN ( MST.COP_EXPT_STS_CD) COP_EXPT_STS_CD" ).append("\n"); 
		query.append("				                          FROM   BKG_REFERENCE BB, SCE_EXPT_MST MST" ).append("\n"); 
		query.append("				                          WHERE  BB.CUST_REF_NO_CTNT = @[ref_no]" ).append("\n"); 
		query.append("				                          AND    MST.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("				                          AND    BB.BKG_REF_TP_CD = 'EBRF'" ).append("\n"); 
		query.append("				                          GROUP BY MST.COP_NO" ).append("\n"); 
		query.append("			  					    #end" ).append("\n"); 
		query.append("				                          ) SCE	" ).append("\n"); 
		query.append("										/* minestar -  EXPT 관련 조인 끝*/    			" ).append("\n"); 
		query.append("				                  WHERE schg.cop_no         = scd.cop_no(+)                                                                                  " ).append("\n"); 
		query.append("				                    AND scd.act_sts_cd(+)   = 'C'                                                                                            " ).append("\n"); 
		query.append("				                    AND schg.cop_no         = sce.cop_no(+)                                                                                  " ).append("\n"); 
		query.append("				                    AND schg.bkg_no         = bb.bkg_no                                                                                      " ).append("\n"); 
		query.append("				                    AND scd.act_cd          = ma.act_cd(+)" ).append("\n"); 
		query.append("							#if (${bkg_no} != '')   " ).append("\n"); 
		query.append("				                    AND     schg.bkg_no = @[bkg_no]                                                                                " ).append("\n"); 
		query.append("							#end        		                     " ).append("\n"); 
		query.append("							#if (${bl_no} != '')   " ).append("\n"); 
		query.append("				                    AND     bb.bl_no = @[bl_no]                                                                                " ).append("\n"); 
		query.append("							#end        		                     " ).append("\n"); 
		query.append("							#if (${cntr_no} != '')   " ).append("\n"); 
		query.append("				                    AND     schg.cntr_no = @[cntr_no]    " ).append("\n"); 
		query.append("				                    AND     bb.bkg_cre_dt between to_date(@[bkg_cre_dt1],'YYYY/MM/DD HH24:MI:SS')  and  to_date(@[bkg_cre_dt2],'YYYY/MM/DD HH24:MI:SS')  + 1   " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${ref_no} != '')   " ).append("\n"); 
		query.append("                                    AND     schg.bkg_no  IN (      SELECT bkg_no" ).append("\n"); 
		query.append("                                                                    FROM BKG_REFERENCE " ).append("\n"); 
		query.append("                                                                   WHERE BKG_REF_TP_CD = 'EBRF'" ).append("\n"); 
		query.append("                                                                     AND CUST_REF_NO_CTNT = @[ref_no]  )                                                                              " ).append("\n"); 
		query.append("							#end    " ).append("\n"); 
		query.append("							#if (${so_no} != '')   " ).append("\n"); 
		query.append("				                    AND     schg.so_no = @[so_no]                                                                                 " ).append("\n"); 
		query.append("							#end    " ).append("\n"); 
		query.append("							#if (${cop_no} != '')   " ).append("\n"); 
		query.append("				                    AND     schg.cop_no = @[cop_no]                                                                                " ).append("\n"); 
		query.append("							#end    " ).append("\n"); 
		query.append("				                  ORDER BY schg.cop_no                                                                                                         " ).append("\n"); 
		query.append("				            ) t1                                                                                                                                  " ).append("\n"); 
		query.append("				        WHERE a = b" ).append("\n"); 
		query.append("				       )t2                                                                                                              " ).append("\n"); 
		query.append("				 WHERE   page = @[page_no]" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}