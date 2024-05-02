/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Full Booking Verify를 위한 booking 정보 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL").append("\n"); 
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
		query.append("SELECT DECODE(bk.bb_cgo_flg, 'Y', 'BB') AS bb                                                                      " ).append("\n"); 
		query.append("                   ,DECODE(bk.spcl_hide_flg, 'Y', 'HD') AS hd                                                                        " ).append("\n"); 
		query.append("                   ,case when  (select dvsn													" ).append("\n"); 
		query.append("                   			     from                                                       " ).append("\n"); 
		query.append("                   			  		 (SELECT 		DISTINCT(SUBSTR((POL_NOD_CD), 1,2)) dvsn    " ).append("\n"); 
		query.append("                   			  		    FROM		SCE_COP_HDR 					        " ).append("\n"); 
		query.append("                   			  		   WHERE 		BKG_NO 	 		= UPPER(@[bkg_no])" ).append("\n"); 
		query.append("                   			  		  )                                                     " ).append("\n"); 
		query.append("                   			 where rownum = 1) = 'CA' then 'N'                              " ).append("\n"); 
		query.append("                   	    when bk.rc_flg = 'Y' then 'RF'                                 " ).append("\n"); 
		query.append("                   else 'N'                                                                 " ).append("\n"); 
		query.append("                   end rf                                                                   " ).append("\n"); 
		query.append("                   ,DECODE(bk.rd_cgo_flg, 'Y', 'RD') AS rd                                                                      " ).append("\n"); 
		query.append("                   ,DECODE(bk.dcgo_flg, 'Y', 'DG') AS dg                                                                      " ).append("\n"); 
		query.append("                   ,DECODE(bk.awk_cgo_flg, 'Y', 'AK') AS ak                                                                     " ).append("\n"); 
		query.append("                   ,DECODE(bk.soc_flg, 'Y', 'SC') AS sc                                                                    " ).append("\n"); 
		query.append("                   ,DECODE(bk.rail_blk_cd, null,'', 'RB')AS rb                                                                         " ).append("\n"); 
		query.append("                   ,DECODE (bk.cmdt_cd,                                                                                              " ).append("\n"); 
		query.append("                            '070002', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '100100', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '100501', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '280038', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '283603', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '300009', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980031', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980033', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980034', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980035', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980036', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980037', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980038', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980039', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '980040', 'RB',                                                                                           " ).append("\n"); 
		query.append("                            '810001', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '810400', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '810800', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '811200', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '740301', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '720400', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '740302', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '760300', 'RD',                                                                                           " ).append("\n"); 
		query.append("                            '410000', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410001', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410002', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410003', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410004', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410005', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410006', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410007', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410008', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410009', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410100', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410101', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410102', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410103', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410200', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410201', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410202', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410400', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '410401', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '411000', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '411001', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '430000', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '430100', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            '430101', 'HD',                                                                                           " ).append("\n"); 
		query.append("                            'N'                                                                                                       " ).append("\n"); 
		query.append("                           ) bkg_cmdt_cd                                                                                             " ).append("\n"); 
		query.append("                   ,bk.bkg_no AS bkg_no                                                                           " ).append("\n"); 
		query.append("                   ,bk.por_cd                                                                                                        " ).append("\n"); 
		query.append("                   ,bk.pol_cd                                                                                                        " ).append("\n"); 
		query.append("                   ,lo1.loc_nm || ' ' || co1.cnt_nm AS por_nm                                                                        " ).append("\n"); 
		query.append("                   ,lo2.loc_nm || ' ' || co2.cnt_nm AS pol_nm                                                                        " ).append("\n"); 
		query.append("                   ,co1.cnt_cd AS por_cnt_cd                                                                                         " ).append("\n"); 
		query.append("                   ,co2.cnt_cd AS pol_cnt_cd                                                                                         " ).append("\n"); 
		query.append("                   ,DECODE(bk.stop_off_loc_cd,NULL,'N','Y') stop_off_ind                                                                      " ).append("\n"); 
		query.append("                   ,DECODE(bk.bkg_sts_cd, 'S', 'S', 'X', DECODE(bk.split_rsn_cd, NULL, 'X', 'S'), bk.bkg_sts_cd) AS status_cd        " ).append("\n"); 
		query.append("                   ,DECODE(bc.cust_cnt_cd || LPAD(bc.cust_seq, 6, '0'), 'US054371', 'Y', 'N') AS spcl_cust_flg" ).append("\n"); 
		query.append("				   ,REPLACE(REPLACE(REPLACE(ct.cust_lgl_eng_nm, CHR(13) || CHR(10), ' '), CHR(34), ' '), CHR(9), ' ') AS cust_nm     " ).append("\n"); 
		query.append("                   ,NVL(bc.cust_fax_no, ' ') AS cust_fax                                                                                  " ).append("\n"); 
		query.append("    		       ,rrcv_fm.rrcv_date_fm                                                                                                                                                                    " ).append("\n"); 
		query.append("    		       ,rrcv_to.rrcv_date_to" ).append("\n"); 
		query.append("				  -- ,bk.aloc_sts_cd" ).append("\n"); 
		query.append("				  -- ,bk.non_rt_sts_cd                                                                                  				                                                        " ).append("\n"); 
		query.append("               FROM bkg_booking bk                                                                                                   " ).append("\n"); 
		query.append("                   ,mdm_location lo1                                                                                                 " ).append("\n"); 
		query.append("                   ,mdm_location lo2                                                                                                 " ).append("\n"); 
		query.append("                   ,mdm_country co1                                                                                                  " ).append("\n"); 
		query.append("                   ,mdm_country co2                                                                                                  " ).append("\n"); 
		query.append("                   ,bkg_customer bc                                                                                                  " ).append("\n"); 
		query.append("                   ,mdm_customer ct                                                                                                  " ).append("\n"); 
		query.append("   		           ,(select max(case when b.RAIL_RCV_COFF_FM_DT is null OR b.RAIL_RCV_COFF_FM_DT = '' then ''						                                                " ).append("\n"); 
		query.append("    		                         when (b.RAIL_RCV_COFF_FM_DT > to_char(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[vndr_seq])),'yyyymmdd')		" ).append("\n"); 
		query.append("    		                         	  and SUBSTR(a.pol_nod_cd,0,2) != 'CA')     " ).append("\n"); 
		query.append("									 then to_char(to_date(b.RAIL_RCV_COFF_FM_DT,'yyyymmdd'),'yyyy-mm-dd')                                                                                                                      " ).append("\n"); 
		query.append("    		                    else ''                                                                                                                                                                           " ).append("\n"); 
		query.append("    		                    end) rrcv_date_fm                                                                                                                                                                 " ).append("\n"); 
		query.append("    		           from SCE_COP_HDR a" ).append("\n"); 
		query.append("							,(select BKG_NO," ).append("\n"); 
		query.append("                                     MAX(decode (clz_tp_cd, 'F', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDD'), '')) AS RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append("                               from bkg_clz_tm" ).append("\n"); 
		query.append("                              where bkg_no = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("                                and clz_tp_cd in ('F','O')" ).append("\n"); 
		query.append("                              GROUP BY BKG_NO ) b                                                                                                                                                                      " ).append("\n"); 
		query.append("    		          where a.BKG_NO = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("						and b.bkg_no = a.bkg_no															 						     " ).append("\n"); 
		query.append("    		            and a.COP_STS_CD != 'X'                                                                                                                                                               " ).append("\n"); 
		query.append("    		            and ((a.pol_nod_cd in ('USSEA','USPDX') AND a.CNTR_TPSZ_CD = 'R')                                                                                                                         " ).append("\n"); 
		query.append("    		             OR a.pol_nod_cd not in ('USSEA','USPDX'))) rrcv_fm                                                     " ).append("\n"); 
		query.append("    		                  ,(select min(case when c.RAIL_RCV_COFF_TO_DT is null OR c.RAIL_RCV_COFF_TO_DT = '' then ''						                                                " ).append("\n"); 
		query.append("    		                                 when c.RAIL_RCV_COFF_TO_DT < to_char(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[vndr_seq])),'yyyymmdd')		" ).append("\n"); 
		query.append("    		                                      then to_char(to_date(c.RAIL_RCV_COFF_TO_DT,'yyyymmdd'),'yyyy-mm-dd')                                                                                                                      " ).append("\n"); 
		query.append("    		                            else ''                                                                                                                                                                         " ).append("\n"); 
		query.append("    		                            end) rrcv_date_to                                                                                                                                                               " ).append("\n"); 
		query.append("    		                     from SCE_COP_HDR a                                                                                                                                                                     " ).append("\n"); 
		query.append("    		                         ,PRD_PROD_CTL_ACT_GRP_DTL b" ).append("\n"); 
		query.append("									 ,(select BKG_NO," ).append("\n"); 
		query.append("                                               MAX(decode (clz_tp_cd, 'F', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDD'), '')) AS RAIL_RCV_COFF_FM_DT ," ).append("\n"); 
		query.append("                                               MAX(decode (clz_tp_cd, 'O', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDD'), '')) AS RAIL_RCV_COFF_TO_DT" ).append("\n"); 
		query.append("                                         from bkg_clz_tm" ).append("\n"); 
		query.append("                                        where bkg_no = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("                                          and clz_tp_cd in ('F','O')" ).append("\n"); 
		query.append("                                        GROUP BY BKG_NO ) c                                                                                                                                                                      " ).append("\n"); 
		query.append("    		                    where a.BKG_NO = UPPER(@[bkg_no])															 						     " ).append("\n"); 
		query.append("    		                      and a.pctl_no = b.pctl_no															 					     " ).append("\n"); 
		query.append("    		                      and a.COP_STS_CD != 'X'                                                                                                                                                               " ).append("\n"); 
		query.append("    		                      and a.pol_nod_cd = 'USORF'                                                                                                                                                                " ).append("\n"); 
		query.append("    		                      and b.VSL_SLAN_CD = 'NTA' " ).append("\n"); 
		query.append("								  and c.bkg_no = a.bkg_no ) rrcv_to                                                                                                                                                   " ).append("\n"); 
		query.append("              WHERE bk.por_cd = lo1.loc_cd                                                                                           " ).append("\n"); 
		query.append("                AND bk.pol_cd = lo2.loc_cd                                                                                           " ).append("\n"); 
		query.append("                AND lo1.cnt_cd = co1.cnt_cd                                                                                          " ).append("\n"); 
		query.append("                AND lo2.cnt_cd = co2.cnt_cd                                                                                          " ).append("\n"); 
		query.append("                AND BK.BKG_NO = UPPER(@[bkg_no])                                                                                             " ).append("\n"); 
		query.append("                AND bk.bkg_no = bc.bkg_no(+)                                                                                         " ).append("\n"); 
		query.append("                AND bc.bkg_cust_tp_cd(+) = 'S'                                                                                       " ).append("\n"); 
		query.append("                AND bc.cust_cnt_cd = ct.cust_cnt_cd(+)                                                                               " ).append("\n"); 
		query.append("                AND bc.cust_seq = ct.cust_seq(+)                                                                                     " ).append("\n"); 
		query.append("                AND nvl(ct.NMD_CUST_FLG(+),'N') = 'N'" ).append("\n"); 

	}
}