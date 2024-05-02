/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01HRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.23 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01HRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search MonthlyQuotaInquiry0126 Tab03 Sub01 HR
	  * </pre>
	  */
	public MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01HRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrtAqCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhqCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrtOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subTrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("items0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01HRRSQL").append("\n"); 
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
		query.append("WITH tmp_input_params AS " ).append("\n"); 
		query.append("    (SELECT DISTINCT " ).append("\n"); 
		query.append("        @[year] AS bse_yr, " ).append("\n"); 
		query.append("        @[quarter] AS bse_qtr_cd, " ).append("\n"); 
		query.append("        @[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		AS yrmon_1," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 'YYYYMM'), 1), 'YYYYMM') AS yrmon_2, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 'YYYYMM'), 2), 'YYYYMM') AS yrmon_3, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        @[targetGrp] AS saq_tgt_grp_cd, " ).append("\n"); 
		query.append("        @[version] AS rlse_ver_no, " ).append("\n"); 
		query.append("        @[trade] AS trd_cd, " ).append("\n"); 
		query.append("        @[dirCd] AS dir_cd," ).append("\n"); 
		query.append("        @[rhqCd] AS rhq_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrtAqCd} == '') " ).append("\n"); 
		query.append("		'  '" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		@[ctrtAqCd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        		AS aq_cd, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        @[ctrtOfcCd] AS ofc_cd, " ).append("\n"); 
		query.append("        @[subTrade] AS sub_trd_cd " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     FROM   dual), " ).append("\n"); 
		query.append("    vvd AS " ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("            vvd.trd_cd," ).append("\n"); 
		query.append("            vvd.conv_dir_cd," ).append("\n"); 
		query.append("            vvd.sub_trd_cd," ).append("\n"); 
		query.append("            vvd.rlane_cd," ).append("\n"); 
		query.append("            vvd.bse_yr||vvd.bse_mon AS yrmon, " ).append("\n"); 
		query.append("            SUM(vvd.fnl_bsa_capa) AS bsa, " ).append("\n"); 
		query.append("            COUNT(*) AS voyage " ).append("\n"); 
		query.append("     FROM   saq_mon_cfm_tgt_vvd vvd, " ).append("\n"); 
		query.append("            tmp_input_params inp " ).append("\n"); 
		query.append("     WHERE  vvd.bse_yr = inp.bse_yr " ).append("\n"); 
		query.append("     AND    vvd.bse_qtr_cd = inp.bse_qtr_cd " ).append("\n"); 
		query.append("     AND    vvd.mqta_rlse_ver_no = inp.rlse_ver_no " ).append("\n"); 
		query.append("     AND    vvd.trd_cd = inp.trd_cd " ).append("\n"); 
		query.append("     AND    vvd.conv_dir_cd = inp.dir_cd " ).append("\n"); 
		query.append("     AND    vvd.sub_trd_cd = inp.sub_trd_cd " ).append("\n"); 
		query.append("     GROUP BY vvd.trd_cd, vvd.conv_dir_cd, vvd.sub_trd_cd, vvd.rlane_cd, vvd.bse_yr||vvd.bse_mon) " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    7 AS sLevel, " ).append("\n"); 
		query.append("    smr.dir_cd, " ).append("\n"); 
		query.append("    rhq_cd, " ).append("\n"); 
		query.append("    aq_cd, " ).append("\n"); 
		query.append("    ofc_cd, " ).append("\n"); 
		query.append("    sub_trd_cd," ).append("\n"); 
		query.append("    DECODE(dir.conv_dir_cd,'',smr.rlane_cd,smr.rlane_cd||' - '||dir.dir_cd) rlane_cd, " ).append("\n"); 
		query.append("    dir.dir_cd conv_dir_cd, " ).append("\n"); 
		query.append("    row_seq, " ).append("\n"); 
		query.append("    text AS item_text, " ).append("\n"); 
		query.append("    item, " ).append("\n"); 
		query.append("    val_01+val_02+val_03 AS val_00, " ).append("\n"); 
		query.append("    val_01, " ).append("\n"); 
		query.append("    val_02, " ).append("\n"); 
		query.append("    val_03 " ).append("\n"); 
		query.append("FROM  ( " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("          MIN(smr.conv_dir_cd) AS dir_cd, " ).append("\n"); 
		query.append("          MIN(smr.rhq_cd) rhq_cd, " ).append("\n"); 
		query.append("          MIN(smr.aq_cd) aq_cd," ).append("\n"); 
		query.append("          MIN(smr.ofc_cd) ofc_cd," ).append("\n"); 
		query.append("          MIN(smr.sub_trd_cd) sub_trd_cd," ).append("\n"); 
		query.append("          smr.rlane_cd, " ).append("\n"); 
		query.append("          itm.row_seq, " ).append("\n"); 
		query.append("          itm.text, " ).append("\n"); 
		query.append("          CASE " ).append("\n"); 
		query.append("             WHEN itm.code IN('05', '07', '08', '11', '12') THEN itm.text || '*' " ).append("\n"); 
		query.append("             ELSE itm.text " ).append("\n"); 
		query.append("          END item, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(smr.yrmon, inp.yrmon_1,	" ).append("\n"); 
		query.append("	        DECODE( itm.code,  '01', (bsa),                     			" ).append("\n"); 
		query.append("	                 '02', (voyage),                           			" ).append("\n"); 
		query.append("	                 '03', (smr.lod),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(bsa, 0, 0, (smr.lod)/(bsa)*100),  			" ).append("\n"); 
		query.append("	                 '05', (smr.rev),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(lod, 0, 0, (rev)/(lod)*1000),              " ).append("\n"); 
		query.append("	                 '07', (smr.cm),                                  		" ).append("\n"); 
		query.append("	                 '08', (smr.ra_cm),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(lod, 0, 0, (cm)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(lod, 0, 0, (ra_cm)*1000/(lod)),            " ).append("\n"); 
		query.append("	                 '11', (smr.op),                                  		" ).append("\n"); 
		query.append("	                 '12', (smr.ra_op),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(lod, 0, 0, (op)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(lod, 0, 0, (ra_op)*1000/(lod)) ))), 0) AS val_01," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(smr.yrmon, inp.yrmon_2,                     		" ).append("\n"); 
		query.append("	        DECODE( itm.code,  '01', (bsa),                     			" ).append("\n"); 
		query.append("	                 '02', (voyage),                           			" ).append("\n"); 
		query.append("	                 '03', (smr.lod),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(bsa, 0, 0, (smr.lod)/(bsa)*100),  			" ).append("\n"); 
		query.append("	                 '05', (smr.rev),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(lod, 0, 0, (rev)/(lod)*1000),              " ).append("\n"); 
		query.append("	                 '07', (smr.cm),                                  		" ).append("\n"); 
		query.append("	                 '08', (smr.ra_cm),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(lod, 0, 0, (cm)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(lod, 0, 0, (ra_cm)*1000/(lod)),            " ).append("\n"); 
		query.append("	                 '11', (smr.op),                                  		" ).append("\n"); 
		query.append("	                 '12', (smr.ra_op),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(lod, 0, 0, (op)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(lod, 0, 0, (ra_op)*1000/(lod)) ))), 0) AS val_02," ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(smr.yrmon, inp.yrmon_3,                     		" ).append("\n"); 
		query.append("	        DECODE( itm.code,  '01', (bsa),                     			" ).append("\n"); 
		query.append("	                 '02', (voyage),                           			" ).append("\n"); 
		query.append("	                 '03', (smr.lod),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(bsa, 0, 0, (smr.lod)/(bsa)*100),  			" ).append("\n"); 
		query.append("	                 '05', (smr.rev),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(lod, 0, 0, (rev)/(lod)*1000),              " ).append("\n"); 
		query.append("	                 '07', (smr.cm),                                  		" ).append("\n"); 
		query.append("	                 '08', (smr.ra_cm),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(lod, 0, 0, (cm)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(lod, 0, 0, (ra_cm)*1000/(lod)),            " ).append("\n"); 
		query.append("	                 '11', (smr.op),                                  		" ).append("\n"); 
		query.append("	                 '12', (smr.ra_op),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(lod, 0, 0, (op)*1000/(lod)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(lod, 0, 0, (ra_op)*1000/(lod)) ))), 0) AS val_03	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM  ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                 MIN(smr.trd_cd) AS trd_cd, " ).append("\n"); 
		query.append("                 MIN(smr.dir_cd) AS dir_cd, " ).append("\n"); 
		query.append("                 MIN(smr.conv_dir_cd) AS conv_dir_cd, " ).append("\n"); 
		query.append("                 MIN(smr.rhq_cd) AS rhq_cd," ).append("\n"); 
		query.append("                 MIN(NVL(smr.aq_cd, '  ')) AS aq_cd," ).append("\n"); 
		query.append("                 MIN(smr.rgn_ofc_cd) AS ofc_cd," ).append("\n"); 
		query.append("                 MIN(vvd.sub_trd_cd) AS sub_trd_cd," ).append("\n"); 
		query.append("                 smr.rlane_cd," ).append("\n"); 
		query.append("                 smr.bse_yr||smr.bse_mon AS yrmon, " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("                         SUM(smr.lod_qty) AS lod, " ).append("\n"); 
		query.append("                         SUM(smr.grs_rpb_rev*smr.lod_qty)/1000 AS rev,  " ).append("\n"); 
		query.append("                         SUM((smr.grs_rpb_rev-smr.cm_uc_amt)*smr.lod_qty)/1000 AS cm, " ).append("\n"); 
		query.append("                         SUM((smr.grs_rpb_rev-smr.ra_cm_uc_amt)*smr.lod_qty)/1000 AS ra_cm,  " ).append("\n"); 
		query.append("                         SUM((smr.grs_rpb_rev-smr.opfit_uc_amt)*smr.lod_qty)/1000 AS op, " ).append("\n"); 
		query.append("                         SUM((smr.grs_rpb_rev-smr.ra_opfit_uc_amt)*smr.lod_qty )/1000 AS ra_op " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("            FROM saq_mon_cfm_qta smr " ).append("\n"); 
		query.append("                 JOIN " ).append("\n"); 
		query.append("                 tmp_input_params inp " ).append("\n"); 
		query.append("                 ON " ).append("\n"); 
		query.append("                 ( " ).append("\n"); 
		query.append("                    smr.bse_yr = inp.bse_yr AND " ).append("\n"); 
		query.append("                    smr.bse_qtr_cd = inp.bse_qtr_cd AND " ).append("\n"); 
		query.append("                    smr.mqta_rlse_ver_no = inp.rlse_ver_no AND " ).append("\n"); 
		query.append("                    smr.trd_cd = inp.trd_cd AND " ).append("\n"); 
		query.append("                    smr.conv_dir_cd = inp.dir_cd AND " ).append("\n"); 
		query.append("                    smr.rhq_cd = inp.rhq_cd AND " ).append("\n"); 
		query.append("                    NVL(smr.aq_cd, '  ') = inp.aq_cd AND " ).append("\n"); 
		query.append("                    smr.rgn_ofc_cd = inp.ofc_cd AND " ).append("\n"); 
		query.append("            		   smr.qta_tgt_cd = @[selType]												" ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("					 JOIN										 " ).append("\n"); 
		query.append("                	   saq_mon_cfm_tgt_vvd vvd								 " ).append("\n"); 
		query.append("					 ON										 " ).append("\n"); 
		query.append("                 (										 " ).append("\n"); 
		query.append("                    vvd.mqta_rlse_ver_no = smr.mqta_rlse_ver_no AND				 " ).append("\n"); 
		query.append("                    vvd.bse_yr = smr.bse_yr AND							 " ).append("\n"); 
		query.append("                    vvd.bse_qtr_cd = smr.bse_qtr_cd AND						 " ).append("\n"); 
		query.append("                    vvd.bse_mon = smr.bse_mon AND						 " ).append("\n"); 
		query.append("                    vvd.trd_cd = smr.trd_cd AND							 " ).append("\n"); 
		query.append("                    vvd.rlane_cd = smr.rlane_cd AND						 " ).append("\n"); 
		query.append("                    vvd.dir_cd = smr.dir_cd AND							 " ).append("\n"); 
		query.append("                    vvd.vsl_cd = smr.vsl_cd AND							 " ).append("\n"); 
		query.append("                    vvd.skd_voy_no = smr.skd_voy_no AND						 " ).append("\n"); 
		query.append("                    vvd.skd_dir_cd = smr.skd_dir_cd						 " ).append("\n"); 
		query.append("                                         )     										" ).append("\n"); 
		query.append("            GROUP BY smr.rlane_cd, smr.bse_yr||smr.bse_mon " ).append("\n"); 
		query.append("          ) smr " ).append("\n"); 
		query.append("          JOIN " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            SELECT  intg_cd_val_ctnt AS code, " ).append("\n"); 
		query.append("                    intg_cd_val_dp_desc AS text, " ).append("\n"); 
		query.append("                    intg_cd_val_dp_seq AS row_seq " ).append("\n"); 
		query.append("            FROM  com_intg_cd_dtl " ).append("\n"); 
		query.append("            WHERE intg_cd_id = 'CD01390' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if($ilist.size() > 0)" ).append("\n"); 
		query.append("            AND   ('ALL' = @[items0] OR (intg_cd_val_dp_desc in (" ).append("\n"); 
		query.append("                #foreach ($key in ${ilist})" ).append("\n"); 
		query.append("                    #if($velocityCount < $ilist.size())" ).append("\n"); 
		query.append("                    '$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("		)) )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ) itm " ).append("\n"); 
		query.append("          ON 1 = 1 " ).append("\n"); 
		query.append("          JOIN " ).append("\n"); 
		query.append("          vvd " ).append("\n"); 
		query.append("          ON " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            smr.trd_cd = vvd.trd_cd AND " ).append("\n"); 
		query.append("            smr.conv_dir_cd = vvd.conv_dir_cd AND" ).append("\n"); 
		query.append("            smr.sub_trd_cd = vvd.sub_trd_cd AND" ).append("\n"); 
		query.append("            smr.rlane_cd = vvd.rlane_cd AND " ).append("\n"); 
		query.append("            smr.yrmon = vvd.yrmon " ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("          JOIN " ).append("\n"); 
		query.append("          tmp_input_params inp " ).append("\n"); 
		query.append("          ON 1 = 1 " ).append("\n"); 
		query.append("    GROUP BY smr.rlane_cd, itm.row_seq, itm.text, itm.code " ).append("\n"); 
		query.append("      ) smr " ).append("\n"); 
		query.append("    ,     (                                                                                          " ).append("\n"); 
		query.append("          select                                                                                    " ).append("\n"); 
		query.append("              dir.rlane_cd,                                                                                " ).append("\n"); 
		query.append("              dir.dir_cd,							" ).append("\n"); 
		query.append("              dir.conv_dir_cd							" ).append("\n"); 
		query.append("          from                                                                                    " ).append("\n"); 
		query.append("              saq_mon_dir_conv dir                                                                                " ).append("\n"); 
		query.append("          where                                                                                    " ).append("\n"); 
		query.append("                   dir.bse_yr = @[year]                                                                           " ).append("\n"); 
		query.append("             and dir.bse_qtr_cd = @[quarter]                                                                                 " ).append("\n"); 
		query.append("             and dir.trd_cd = @[trade]                                         " ).append("\n"); 
		query.append("             and dir.conv_dir_cd = @[dirCd]                                         		" ).append("\n"); 
		query.append("          ) dir                                                                                 " ).append("\n"); 
		query.append("     WHERE                                                                                 " ).append("\n"); 
		query.append("             dir.rlane_cd(+) = smr.rlane_cd 								" ).append("\n"); 
		query.append("ORDER BY smr.rlane_cd, row_seq" ).append("\n"); 

	}
}