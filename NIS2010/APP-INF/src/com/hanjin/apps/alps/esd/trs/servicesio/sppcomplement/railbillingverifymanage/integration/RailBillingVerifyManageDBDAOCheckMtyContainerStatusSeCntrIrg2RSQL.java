/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrg2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.01.22 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrg2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EMPTY CNTR IRG 및 EQR OVER PLAN 적용관련 체크
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrg2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sFmYdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sEqTpSzCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrg2RSQL").append("\n"); 
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
		query.append(" SELECT ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("        ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("        ROUT_SEQ," ).append("\n"); 
		query.append("        PRIO_SEQ," ).append("\n"); 
		query.append("        IS_BLOCK_VENDOR," ).append("\n"); 
		query.append("        IS_GOODBILL," ).append("\n"); 
		query.append("        IS_CONSTRAINTED," ).append("\n"); 
		query.append("        ROUT_ORG_NOD_CD || ' (' || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, (DECODE(ROUT_DTL_SEQ, 1, TRSP_MOD, '' )), (DECODE(ROUT_DTL_SEQ, 1 , TRSP_MOD, '' ))) ) || ') ' || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 1 , '', DECODE(ROUT_DTL_SEQ, 1, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 2, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 2, '', DECODE(ROUT_DTL_SEQ, 2, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 3, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 3, '', DECODE(ROUT_DTL_SEQ, 3, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 4, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 4, '', DECODE(ROUT_DTL_SEQ, 4, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 5, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 5, '', DECODE(ROUT_DTL_SEQ, 5, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 6, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 6, '', DECODE(ROUT_DTL_SEQ, 6, '-'||LNK_DEST_NOD_CD || ' (' )))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 7, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 7, '', DECODE(ROUT_DTL_SEQ, 7, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 8, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 8, '', DECODE(ROUT_DTL_SEQ, 8, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 9, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 9, '', DECODE(ROUT_DTL_SEQ, 9, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 10, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 10, '', DECODE(ROUT_DTL_SEQ, 10, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 11, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 11, '', DECODE(ROUT_DTL_SEQ, 11, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 12, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 12, '', DECODE(ROUT_DTL_SEQ, 12, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 13, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 13, '', DECODE(ROUT_DTL_SEQ, 13, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ , 14, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 14, '', DECODE(ROUT_DTL_SEQ, 14, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 15, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 15, '', DECODE(ROUT_DTL_SEQ, 15, '-'||LNK_DEST_NOD_CD || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', (DECODE(ROUT_DTL_SEQ, 16, TRSP_MOD || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(CNT, 16, '', DECODE(ROUT_DTL_SEQ, 16, '-'||LNK_DEST_NOD_CD || ' (' )))) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1 , '' , (DECODE(rout_dtl_seq , 17, trsp_mod || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(cnt, 17, '', DECODE(ROUT_DTL_SEQ, 17, '-'||lnk_dest_nod_cd || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE ( CNT, 1 , '' , (DECODE(rout_dtl_seq , 18, trsp_mod || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(cnt, 18, '', DECODE(ROUT_DTL_SEQ, 18, '-'||lnk_dest_nod_cd || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE ( CNT, 1 , '' , (DECODE(rout_dtl_seq , 19, trsp_mod || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(cnt, 19, '', DECODE(ROUT_DTL_SEQ, 19, '-'||lnk_dest_nod_cd || ' (')))) || " ).append("\n"); 
		query.append("        MAX(DECODE ( CNT, 1 , '' , (DECODE(rout_dtl_seq , 20, trsp_mod || ') ', '' ))) ) || " ).append("\n"); 
		query.append("        MAX(DECODE(CNT, 1, '', DECODE(cnt, 20, '', DECODE(ROUT_DTL_SEQ, 20, '-'||lnk_dest_nod_cd)))) " ).append("\n"); 
		query.append("        || '-'||rout_dest_nod_cd as ROUTE" ).append("\n"); 
		query.append(" FROM ( SELECT is_constrainted ," ).append("\n"); 
		query.append("               is_block_vendor ," ).append("\n"); 
		query.append("               is_goodbill ," ).append("\n"); 
		query.append("               rout_org_nod_cd ," ).append("\n"); 
		query.append("               rout_dest_nod_cd ," ).append("\n"); 
		query.append("               rout_seq ," ).append("\n"); 
		query.append("               prio_seq ," ).append("\n"); 
		query.append("               rout_dtl_seq ," ).append("\n"); 
		query.append("               cnt ," ).append("\n"); 
		query.append("               lnk_org_nod_cd ," ).append("\n"); 
		query.append("               lnk_dest_nod_cd ," ).append("\n"); 
		query.append("               trsp_mod_cd ," ).append("\n"); 
		query.append("               DECODE(trsp_mod_cd, 'TD', 'TRUCK', 'RD', 'RAIL', trsp_mod_cd) trsp_mod ," ).append("\n"); 
		query.append("               tztm_hrs link_tt_time ," ).append("\n"); 
		query.append("               sum_tt_time ," ).append("\n"); 
		query.append("               org_dw_time ," ).append("\n"); 
		query.append("               nvl(dest_dw_time, 0) dest_dw_time" ).append("\n"); 
		query.append("         FROM ( SELECT 'N' AS is_constrainted ," ).append("\n"); 
		query.append("                       DECODE(d.vndr_seq, 105484, 'Y', 108386, 'Y', 'N') AS is_block_vendor ," ).append("\n"); 
		query.append("                       DECODE(m.INLND_ROUT_INV_BIL_PATT_CD, 'S2R', 'Y', 'S3R', 'Y', 'N') AS is_goodbill ," ).append("\n"); 
		query.append("                       m.rout_org_nod_cd," ).append("\n"); 
		query.append("                       m.rout_dest_nod_cd," ).append("\n"); 
		query.append("                       m.rout_seq," ).append("\n"); 
		query.append("                       m.prio_seq ," ).append("\n"); 
		query.append("                       d.lnk_org_nod_cd," ).append("\n"); 
		query.append("                       d.lnk_dest_nod_cd," ).append("\n"); 
		query.append("                       d.rout_dtl_seq," ).append("\n"); 
		query.append("                       d.trsp_mod_cd," ).append("\n"); 
		query.append("                       l.tztm_hrs ," ).append("\n"); 
		query.append("                       COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                             ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt ," ).append("\n"); 
		query.append("                       SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                             ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time ," ).append("\n"); 
		query.append("                      (SELECT nvl(dry_avg_dwll_hrs, 0)" ).append("\n"); 
		query.append("                         FROM mdm_yard" ).append("\n"); 
		query.append("                        WHERE yd_cd = d.lnk_org_nod_cd ) org_dw_time ," ).append("\n"); 
		query.append("                      (SELECT nvl(dry_avg_dwll_hrs, 0)" ).append("\n"); 
		query.append("                         FROM mdm_yard" ).append("\n"); 
		query.append("                        WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time" ).append("\n"); 
		query.append("                  FROM prd_inlnd_rout_mst m," ).append("\n"); 
		query.append("                       prd_inlnd_rout_dtl d," ).append("\n"); 
		query.append("                       prd_inlnd_each_lnk l" ).append("\n"); 
		query.append("                 WHERE m.PCTL_IO_BND_CD = 'M'" ).append("\n"); 
		query.append("                   AND m.WRS_MTY_CMDT_CD is not null" ).append("\n"); 
		query.append("                   AND d.vndr_seq not in (105484,108386)" ).append("\n"); 
		query.append("                   AND NVL(m.delt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND m.rout_org_nod_cd LIKE @[sFmYdCd]||'%'" ).append("\n"); 
		query.append("                   AND NVL( DECODE ( @[sEqTpSzCd] , 'D2' , M.D2_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'D4' , M.D4_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'D5' , M.D5_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'D7' , M.D7_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'O2' , M.O2_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'O4' , M.O4_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'O5' , M.O5_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'A2' , M.A2_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'A4' , M.A4_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'A5' , M.A5_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'R2' , M.R2_CAPA_FLG " ).append("\n"); 
		query.append("                                                  , 'R5' , M.R5_CAPA_FLG) , 'N') = 'Y'" ).append("\n"); 
		query.append("                   AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("                   AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("                   AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("                   AND d.lnk_org_nod_cd = l.lnk_org_nod_cd" ).append("\n"); 
		query.append("                   AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd" ).append("\n"); 
		query.append("                   AND d.trsp_mod_cd = l.trsp_mod_cd" ).append("\n"); 
		query.append("                   AND d.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("                 ORDER BY m.rout_seq, d.rout_dtl_seq " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("      ) m" ).append("\n"); 
		query.append(" GROUP BY m.rout_org_nod_cd " ).append("\n"); 
		query.append("        , m.rout_dest_nod_cd " ).append("\n"); 
		query.append("        , m.rout_seq " ).append("\n"); 
		query.append("        , m.prio_seq" ).append("\n"); 
		query.append("        , sum_tt_time " ).append("\n"); 
		query.append("        , is_block_vendor " ).append("\n"); 
		query.append("        , is_goodbill " ).append("\n"); 
		query.append("        , is_constrainted" ).append("\n"); 
		query.append(" ORDER BY rout_org_nod_cd " ).append("\n"); 
		query.append("        , rout_dest_nod_cd " ).append("\n"); 
		query.append("        , prio_seq" ).append("\n"); 

	}
}