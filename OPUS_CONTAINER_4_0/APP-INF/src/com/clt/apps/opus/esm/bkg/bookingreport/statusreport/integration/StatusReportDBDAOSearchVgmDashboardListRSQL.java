/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusReportDBDAOSearchVgmDashboardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchVgmDashboardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM Dashboard List
	  * </pre>
	  */
	public StatusReportDBDAOSearchVgmDashboardListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vgm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchVgmDashboardListRSQL").append("\n"); 
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
		query.append("WITH LTST AS(" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_NO, " ).append("\n"); 
		query.append("CNTR_NO, " ).append("\n"); 
		query.append("VGM_VIA, " ).append("\n"); 
		query.append("XTER_VGM_WGT, " ).append("\n"); 
		query.append("XTER_VGM_WGT_UT_CD, " ).append("\n"); 
		query.append("IN_USR, " ).append("\n"); 
		query.append("IN_DT, " ).append("\n"); 
		query.append("ESIG, " ).append("\n"); 
		query.append("VGM_SEQ, " ).append("\n"); 
		query.append("ESIG_CO_NM, " ).append("\n"); 
		query.append("XTER_VGM_RQST_CD, " ).append("\n"); 
		query.append("XTER_SNDR_ID, " ).append("\n"); 
		query.append("XTER_VGM_DOC_ID, " ).append("\n"); 
		query.append("XTER_VGM_RQST_SEQ, " ).append("\n"); 
		query.append("XTER_VGM_USR_ID," ).append("\n"); 
		query.append("WGT_TP_CD, " ).append("\n"); 
		query.append("VGM_BKG_NO," ).append("\n"); 
		query.append("REF_ID," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY BKG_NO, CNTR_NO ORDER BY IN_DT DESC) RNUM" ).append("\n"); 
		query.append(" FROM ((SELECT " ).append("\n"); 
		query.append("		#if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("                BB.BKG_NO," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("	        #if(${in_vvd} != '')" ).append("\n"); 
		query.append("	            CNTR.BKG_NO," ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                XTER_VGM.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD VGM_VIA," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_TP_CD,'V',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                         ,'C',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', XTER_VGM.CNTR_NO)) XTER_VGM_WGT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                XTER_VGM.USR_ID IN_USR," ).append("\n"); 
		query.append("                TO_CHAR(XTER_VGM.VGM_CRE_LOCL_DT,'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.ESIG_CO_NM,NULL,'N','Y') ESIG," ).append("\n"); 
		query.append("                XTER_VGM.VGM_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                XTER_VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	              'WEB' XTER_SNDR_ID," ).append("\n"); 
		query.append("            	  XTER_VGM.BKG_NO XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	              XTER_VGM.VGM_SEQ XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("				  XTER_VGM.USR_ID XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	              XTER_VGM.WGT_TP_CD WGT_TP_CD," ).append("\n"); 
		query.append("				XTER_VGM.BKG_NO VGM_BKG_NO," ).append("\n"); 
		query.append("				XTER_VGM.REF_ID REF_ID" ).append("\n"); 
		query.append("           FROM BKG_XTER_VGM XTER_VGM" ).append("\n"); 
		query.append("	              ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("				  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("	          #if(${in_vvd} != '')" ).append("\n"); 
		query.append("	              ,BKG_VVD VVD" ).append("\n"); 
		query.append("	          #end" ).append("\n"); 
		query.append("          WHERE XTER_VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                          FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = XTER_VGM.BKG_NO" ).append("\n"); 
		query.append("                                           AND CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("                                           AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("			AND XTER_VGM.BKG_NO like SUBSTR(BB.BKG_NO,1,10)||'%'" ).append("\n"); 
		query.append("			AND CNTR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND CNTR.CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT  BB.BKG_NO," ).append("\n"); 
		query.append("                XTER_VGM.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD VGM_VIA," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_TP_CD,'V',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                         ,'C',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', XTER_VGM.CNTR_NO)) XTER_VGM_WGT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                XTER_VGM.USR_ID IN_USR," ).append("\n"); 
		query.append("                TO_CHAR(XTER_VGM.VGM_CRE_LOCL_DT,'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.ESIG_CO_NM,NULL,'N','Y') ESIG," ).append("\n"); 
		query.append("                XTER_VGM.VGM_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                XTER_VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	              'WEB' XTER_SNDR_ID," ).append("\n"); 
		query.append("            	  XTER_VGM.BKG_NO XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	              XTER_VGM.VGM_SEQ XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("				  XTER_VGM.USR_ID XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	              XTER_VGM.WGT_TP_CD WGT_TP_CD," ).append("\n"); 
		query.append("				XTER_VGM.BKG_NO VGM_BKG_NO," ).append("\n"); 
		query.append("				XTER_VGM.REF_ID REF_ID" ).append("\n"); 
		query.append("           FROM BKG_XTER_VGM XTER_VGM" ).append("\n"); 
		query.append("	              ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("				  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("	          #if(${in_vvd} != '')" ).append("\n"); 
		query.append("	              ,BKG_VVD VVD" ).append("\n"); 
		query.append("	          #end" ).append("\n"); 
		query.append("				,BKG_BOOKING TGT_BKG" ).append("\n"); 
		query.append("          WHERE XTER_VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                          FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = XTER_VGM.BKG_NO" ).append("\n"); 
		query.append("                                           AND CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("                                           AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            AND BB.VSL_CD = TGT_BKG.VSL_CD" ).append("\n"); 
		query.append("            AND BB.SKD_VOY_NO = TGT_BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND BB.SKD_DIR_CD = TGT_BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BB.POL_CD = TGT_BKG.POL_CD" ).append("\n"); 
		query.append("            AND BB.POD_CD = TGT_BKG.POD_CD" ).append("\n"); 
		query.append("			AND XTER_VGM.BKG_NO = TGT_BKG.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            AND CNTR.CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT BB.BKG_NO," ).append("\n"); 
		query.append("                XTER_VGM.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD VGM_VIA," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_TP_CD,'V',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                         ,'C',ROUND(DECODE(XTER_VGM.WGT_UT_CD,'KGS',XTER_VGM.VGM_WGT ,'LBS', XTER_VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', XTER_VGM.CNTR_NO)) XTER_VGM_WGT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                XTER_VGM.USR_ID IN_USR," ).append("\n"); 
		query.append("                TO_CHAR(XTER_VGM.VGM_CRE_LOCL_DT,'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                DECODE(XTER_VGM.ESIG_CO_NM,NULL,'N','Y') ESIG," ).append("\n"); 
		query.append("                XTER_VGM.VGM_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                XTER_VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("                XTER_VGM.XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	            'WEB' XTER_SNDR_ID," ).append("\n"); 
		query.append("                XTER_VGM.BKG_NO XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	            XTER_VGM.VGM_SEQ XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("			    XTER_VGM.USR_ID XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	            XTER_VGM.WGT_TP_CD WGT_TP_CD," ).append("\n"); 
		query.append("				XTER_VGM.BKG_NO VGM_BKG_NO," ).append("\n"); 
		query.append("				XTER_VGM.REF_ID REF_ID" ).append("\n"); 
		query.append("           FROM BKG_XTER_VGM XTER_VGM" ).append("\n"); 
		query.append("	              ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("				  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("	          #if(${in_vvd} != '')" ).append("\n"); 
		query.append("	              ,BKG_VVD VVD" ).append("\n"); 
		query.append("	          #end" ).append("\n"); 
		query.append("          WHERE XTER_VGM.VGM_CRE_GDT = (SELECT MAX(VGM_CRE_GDT)" ).append("\n"); 
		query.append("                                          FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = XTER_VGM.BKG_NO" ).append("\n"); 
		query.append("                                           AND CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("										   AND VGM_SEQ = XTER_VGM.VGM_SEQ" ).append("\n"); 
		query.append("                                           AND ACT_TP_CD = 'I')" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			AND XTER_VGM.BKG_NO = CNTR.XTER_VGM_DOC_ID " ).append("\n"); 
		query.append("			AND CNTR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND CNTR.CNTR_NO = XTER_VGM.CNTR_NO" ).append("\n"); 
		query.append("            AND CNTR.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("            AND CNTR.XTER_VGM_RQST_SEQ = XTER_VGM.VGM_SEQ" ).append("\n"); 
		query.append("			AND CNTR.XTER_VGM_USR_ID = XTER_VGM.USR_ID" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("         ( SELECT " ).append("\n"); 
		query.append("			#if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("                  BB.BKG_NO," ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("	        	#if(${in_vvd} != '')" ).append("\n"); 
		query.append("	              CNTR.BKG_NO," ).append("\n"); 
		query.append("	        	#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("                  BXVR.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                  'EDI' VGM_VIA," ).append("\n"); 
		query.append("                  ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3) XTER_VGM_WGT," ).append("\n"); 
		query.append("                  DECODE(BXVR.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                  BXVR.XTER_SNDR_ID IN_USR," ).append("\n"); 
		query.append("                  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = REFNO.REF_NO)),'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',DECODE(BXVC.VGM_CUST_CNTC_NM,NULL,'N','Y')) ESIG," ).append("\n"); 
		query.append("                  BXVR.XTER_VGM_RQST_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',BXVC.VGM_CUST_CNTC_NM) ESIG_CO_NM," ).append("\n"); 
		query.append("                  'EDI' XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	                BXVR.XTER_SNDR_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("					'' XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	                'V' WGT_TP_CD," ).append("\n"); 
		query.append("				  REFNO.REF_NO VGM_BKG_NO," ).append("\n"); 
		query.append("				  '' REF_ID" ).append("\n"); 
		query.append("             FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("                  BKG_XTER_VGM_CUST BXVC," ).append("\n"); 
		query.append("                  BKG_XTER_VGM_REF_NO REFNO" ).append("\n"); 
		query.append("                #if(${in_vvd} != '')" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD" ).append("\n"); 
		query.append("              	#end" ).append("\n"); 
		query.append("                  ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("            WHERE BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ (+)" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = BXVC.CNTR_NO (+)" ).append("\n"); 
		query.append("              AND BXVC.VGM_CUST_CNTC_TP_CD(+) = 'RP'" ).append("\n"); 
		query.append("              AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("              AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                      FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                     WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                       AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("				                                               AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("				                                               AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("              AND NVL(BXVR.XTER_VGM_RQST_SEQ,0) = NVL((SELECT MAX(XTER_VGM_RQST_SEQ)" ).append("\n"); 
		query.append("                                                         FROM BKG_XTER_VGM_RQST " ).append("\n"); 
		query.append("                                                        WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                          AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                          AND BXVR.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("														  AND NVL(VGM_ACK_RSPN_CD,'X') <> 'R'), 0)" ).append("\n"); 
		query.append("              AND REFNO.REF_NO <> ' '" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("			  AND REFNO.REF_NO like SUBSTR(BB.BKG_NO,1,10)||'%'" ).append("\n"); 
		query.append("              AND BB.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("              AND CNTR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("	    	UNION" ).append("\n"); 
		query.append("		   SELECT BB.BKG_NO," ).append("\n"); 
		query.append("                  BXVR.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                  'EDI' VGM_VIA," ).append("\n"); 
		query.append("                  ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3) XTER_VGM_WGT," ).append("\n"); 
		query.append("                  DECODE(BXVR.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                  BXVR.XTER_SNDR_ID IN_USR," ).append("\n"); 
		query.append("                  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = REFNO.REF_NO)),'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',DECODE(BXVC.VGM_CUST_CNTC_NM,NULL,'N','Y')) ESIG," ).append("\n"); 
		query.append("                  BXVR.XTER_VGM_RQST_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',BXVC.VGM_CUST_CNTC_NM) ESIG_CO_NM," ).append("\n"); 
		query.append("                  'EDI' XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	                BXVR.XTER_SNDR_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("					'' XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	                'V' WGT_TP_CD," ).append("\n"); 
		query.append("   				  REFNO.REF_NO VGM_BKG_NO," ).append("\n"); 
		query.append("			      '' REF_ID" ).append("\n"); 
		query.append("             FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("                  BKG_XTER_VGM_CUST BXVC," ).append("\n"); 
		query.append("                  BKG_XTER_VGM_REF_NO REFNO" ).append("\n"); 
		query.append("                #if(${in_vvd} != '')" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD" ).append("\n"); 
		query.append("              	#end" ).append("\n"); 
		query.append("                  ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("				  ,BKG_BOOKING TGT_BKG" ).append("\n"); 
		query.append("            WHERE BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ (+)" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = BXVC.CNTR_NO (+)" ).append("\n"); 
		query.append("              AND BXVC.VGM_CUST_CNTC_TP_CD(+) = 'RP'" ).append("\n"); 
		query.append("              AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("              AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                      FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                     WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                       AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("				                                               AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("				                                               AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("              AND NVL(BXVR.XTER_VGM_RQST_SEQ,0) = NVL((SELECT MAX(XTER_VGM_RQST_SEQ)" ).append("\n"); 
		query.append("                                                         FROM BKG_XTER_VGM_RQST " ).append("\n"); 
		query.append("                                                        WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                          AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                          AND BXVR.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("														  AND NVL(VGM_ACK_RSPN_CD,'X') <> 'R'), 0)" ).append("\n"); 
		query.append("              AND REFNO.REF_NO <> ' '" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          	  AND BB.VSL_CD = TGT_BKG.VSL_CD" ).append("\n"); 
		query.append("              AND BB.SKD_VOY_NO = TGT_BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND BB.SKD_DIR_CD = TGT_BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND BB.POL_CD = TGT_BKG.POL_CD" ).append("\n"); 
		query.append("              AND BB.POD_CD = TGT_BKG.POD_CD" ).append("\n"); 
		query.append("              AND REFNO.REF_NO = TGT_BKG.BKG_NO" ).append("\n"); 
		query.append("              AND BB.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("              AND CNTR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("		   UNION" ).append("\n"); 
		query.append("           SELECT BB.BKG_NO," ).append("\n"); 
		query.append("                  BXVR.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                  'EDI' VGM_VIA," ).append("\n"); 
		query.append("                  ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3) XTER_VGM_WGT," ).append("\n"); 
		query.append("                  DECODE(BXVR.WGT_UT_CD,NULL,NULL,'KGS') XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("                  BXVR.XTER_SNDR_ID IN_USR," ).append("\n"); 
		query.append("                  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = BB.BKG_NO)),'YYYY-MM-DD HH24:MI') IN_DT," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',DECODE(BXVC.VGM_CUST_CNTC_NM,NULL,'N','Y')) ESIG," ).append("\n"); 
		query.append("                  BXVR.XTER_VGM_RQST_SEQ VGM_SEQ," ).append("\n"); 
		query.append("                  DECODE(BXVC.VGM_CUST_CNTC_TP_CD,'RP',BXVC.VGM_CUST_CNTC_NM) ESIG_CO_NM," ).append("\n"); 
		query.append("                  'EDI' XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	                BXVR.XTER_SNDR_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("	                BXVR.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("					'' XTER_VGM_USR_ID," ).append("\n"); 
		query.append("	                'V' WGT_TP_CD," ).append("\n"); 
		query.append("				  REFNO.REF_NO VGM_BKG_NO," ).append("\n"); 
		query.append("				  '' REF_ID" ).append("\n"); 
		query.append("             FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("                  BKG_XTER_VGM_CUST BXVC," ).append("\n"); 
		query.append("				  BKG_XTER_VGM_REF_NO REFNO" ).append("\n"); 
		query.append("                #if(${in_vvd} != '')" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD" ).append("\n"); 
		query.append("              	#end" ).append("\n"); 
		query.append("                  ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                  ,BKG_BOOKING BB" ).append("\n"); 
		query.append("            WHERE BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID (+)" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ (+)" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = BXVC.CNTR_NO (+)" ).append("\n"); 
		query.append("              AND BXVC.VGM_CUST_CNTC_TP_CD(+) = 'RP'" ).append("\n"); 
		query.append("		      AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("              AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("              AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("              AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("                                                      FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("                                                     WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                       AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                       AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("				                                               AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("				                                               AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("	      #if(${in_vvd} != '')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("  		        #if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("            AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("  		        #end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	      #end" ).append("\n"); 
		query.append("          #if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("            AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			        #foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				        #if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			        #end" ).append("\n"); 
		query.append("		          )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("              AND BB.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("              AND CNTR.XTER_SNDR_ID = BXVR.XTER_SNDR_ID " ).append("\n"); 
		query.append("              AND CNTR.XTER_VGM_DOC_ID = BXVR.XTER_VGM_DOC_ID " ).append("\n"); 
		query.append("              AND CNTR.XTER_VGM_RQST_SEQ = BXVR.XTER_VGM_RQST_SEQ " ).append("\n"); 
		query.append("              AND CNTR.CNTR_NO = BXVR.CNTR_NO" ).append("\n"); 
		query.append("			  AND NVL(VGM_ACK_RSPN_CD,'X') <> 'R'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM = 1" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER(ORDER BY MST.BKG_NO) DENSE_RANK," ).append("\n"); 
		query.append("		ROW_NUMBER() OVER(ORDER BY MST.BKG_NO) NUM," ).append("\n"); 
		query.append("		MST.BKG_NO BKG_NO," ).append("\n"); 
		query.append("        MST.BL_NO BL_NO," ).append("\n"); 
		query.append("        MST.BKG_OFC_CD BKG_OFC_CD," ).append("\n"); 
		query.append("		MST.TRNK_VVD," ).append("\n"); 
		query.append("        MST.POL_CD POL_CD," ).append("\n"); 
		query.append("        MST.POD_CD POD_CD," ).append("\n"); 
		query.append("		MST.LT LT," ).append("\n"); 
		query.append("        MST.QTY_BKG QTY_BKG," ).append("\n"); 
		query.append("        MST.QTY_CNTR QTY_CNTR," ).append("\n"); 
		query.append("        MST.FST_ETD FST_ETD," ).append("\n"); 
		query.append("        MST.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("        MST.SZ SZ," ).append("\n"); 
		query.append("        MST.VGM_WGT VGM_WGT," ).append("\n"); 
		query.append("		MST.VGM_WGT_UT_CD VGM_WGT_UT_CD," ).append("\n"); 
		query.append("		MST.VGM_WGT_UPD_USR_ID VGM_WGT_UPD_USR_ID," ).append("\n"); 
		query.append("		MST.VGM_WGT_UPD_DT VGM_WGT_UPD_DT," ).append("\n"); 
		query.append("        MST.WGT WGT," ).append("\n"); 
		query.append("        MST.UNIT UNIT," ).append("\n"); 
		query.append("        MST.CM CM," ).append("\n"); 
		query.append("        MST.SHPR SHPR," ).append("\n"); 
		query.append("        MST.VGM_VIA VGM_VIA," ).append("\n"); 
		query.append("        MST.XTER_VGM_WGT XTER_VGM_WGT," ).append("\n"); 
		query.append("		MST.XTER_VGM_WGT_UT_CD XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("        MST.IN_USR IN_USR," ).append("\n"); 
		query.append("        MST.IN_DT IN_DT," ).append("\n"); 
		query.append("		MST.ESIG ESIG," ).append("\n"); 
		query.append("        MST.VGM_CLZ_FLG VGM_CLZ_FLG," ).append("\n"); 
		query.append("        MST.CLS_USR CLS_USR," ).append("\n"); 
		query.append("        MST.CLS_DT CLS_DT," ).append("\n"); 
		query.append("		MST.VGM_CUT_OFF_TM VGM_CUT_OFF_TM," ).append("\n"); 
		query.append("		MST.SUP," ).append("\n"); 
		query.append("		MST.VGM_SEQ," ).append("\n"); 
		query.append("		MST.ESIG_CO_NM," ).append("\n"); 
		query.append("        MST.XTER_SNDR_ID," ).append("\n"); 
		query.append("        MST.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("        MST.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("		MST.XTER_VGM_USR_ID," ).append("\n"); 
		query.append("		MST.WGT_TP_CD," ).append("\n"); 
		query.append("		MST.VGM_BKG_NO," ).append("\n"); 
		query.append("		MST.REF_ID," ).append("\n"); 
		query.append("		MST.PAYLD_PLS_TARE," ).append("\n"); 
		query.append("		MST.CGO_PLS_TARE," ).append("\n"); 
		query.append("		NVL(TO_CHAR((MST.VGM_WGT - MST.CGO_PLS_TARE) / MST.CGO_PLS_TARE * 100,'99990.99'),TO_CHAR('0','99990.99'))||' %' DIFF_PCT," ).append("\n"); 
		query.append("        COUNT(DISTINCT MST.BKG_NO) OVER() TTL_BKG," ).append("\n"); 
		query.append("        TO_CHAR(SUM(DECODE(MST.RNUM,1,MST.TTL_QTY_F,0)) OVER() ,'99990.99')||' F' TTL_QTY_F," ).append("\n"); 
		query.append("        TO_CHAR(SUM(DECODE(MST.RNUM,1,MST.TTL_QTY_T,0)) OVER() ,'99990.99')||' T' TTL_QTY_T," ).append("\n"); 
		query.append("        SUM(DECODE(MST.VGM_WGT,NULL,0,1)) OVER() TTL_VGM," ).append("\n"); 
		query.append("        SUM(DECODE(MST.VGM_WGT,NULL,1,0)) OVER() TTL_NON_VGM," ).append("\n"); 
		query.append("        SUM(DECODE(MST.XTER_VGM_WGT,NULL,1,0)) OVER() TTL_NON_RCVD_VGM," ).append("\n"); 
		query.append("        SUM(DECODE(MST.RNUM,1,DECODE(MST.VGM_CLZ_FLG,'Y',1,0),0)) OVER() TTL_CLZ_BKG," ).append("\n"); 
		query.append("#if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("		'Y' srch_mlt_bkg" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		'N' srch_mlt_bkg" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM (SELECT BB.BKG_NO BKG_NO," ).append("\n"); 
		query.append("               BB.BL_NO BL_NO," ).append("\n"); 
		query.append("               BB.BKG_OFC_CD BKG_OFC_CD," ).append("\n"); 
		query.append("			   BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD TRNK_VVD," ).append("\n"); 
		query.append("               BB.POL_CD POL_CD," ).append("\n"); 
		query.append("               BB.POD_CD POD_CD," ).append("\n"); 
		query.append("			   DECODE(NVL(@[in_pol_cd],VVD.POL_CD),BB.POL_CD,'LC','TS') LT," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0), '99990.99'))" ).append("\n"); 
		query.append("                          FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                           AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                         ORDER BY CNTR_TPSZ_CD ) ) QTY_BKG," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(CNTR_VOL_QTY), 0), '99990.99'))" ).append("\n"); 
		query.append("                          FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                           AND CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                         GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                         ORDER BY CNTR_TPSZ_CD ) ) QTY_CNTR," ).append("\n"); 
		query.append("               (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("               	  FROM BKG_BOOKING BKG2, BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                 WHERE BKG2.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG2.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG2.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BKG2.BKG_NO)" ).append("\n"); 
		query.append("               ) FST_ETD," ).append("\n"); 
		query.append("               BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               NVL(BC.CNTR_TPSZ_CD,COP.CNTR_TPSZ_CD) SZ," ).append("\n"); 
		query.append("               ROUND(DECODE(BC.VGM_WGT_UT_CD,'KGS', BC.VGM_WGT, 'LBS',BC.VGM_WGT * 0.453592,NULL),3) VGM_WGT," ).append("\n"); 
		query.append("			   DECODE(BC.VGM_WGT_UT_CD,NULL,NULL,'KGS') VGM_WGT_UT_CD," ).append("\n"); 
		query.append("			   BC.VGM_WGT_UPD_USR_ID VGM_WGT_UPD_USR_ID," ).append("\n"); 
		query.append("			   TO_CHAR(BC.VGM_WGT_UPD_DT,'YYYY-MM-DD HH24:MI') VGM_WGT_UPD_DT," ).append("\n"); 
		query.append("               BC.CNTR_WGT WGT," ).append("\n"); 
		query.append("               BC.WGT_UT_CD UNIT," ).append("\n"); 
		query.append("               NVL((SELECT DECODE(MF_CFM_FLG, 'Y', 'F', 'Y')" ).append("\n"); 
		query.append("                          FROM BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                           AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) , 'N') CM," ).append("\n"); 
		query.append("               SHPR.CUST_NM SHPR," ).append("\n"); 
		query.append("               LTST.VGM_VIA VGM_VIA," ).append("\n"); 
		query.append("			   LTST.XTER_VGM_WGT XTER_VGM_WGT," ).append("\n"); 
		query.append("			   LTST.XTER_VGM_WGT_UT_CD XTER_VGM_WGT_UT_CD," ).append("\n"); 
		query.append("               LTST.IN_USR IN_USR," ).append("\n"); 
		query.append("               LTST.IN_DT IN_DT," ).append("\n"); 
		query.append("			   NVL(LTST.ESIG,'N') ESIG," ).append("\n"); 
		query.append("               '' EML_ADDR," ).append("\n"); 
		query.append("               '' EML_RSLT," ).append("\n"); 
		query.append("               '' EML_DT," ).append("\n"); 
		query.append("               NVL(VGM_CLZ_FLG,'N') VGM_CLZ_FLG," ).append("\n"); 
		query.append("               DECODE(VGM_CLZ_FLG,'Y',CLZ.EVNT_USR_ID) CLS_USR," ).append("\n"); 
		query.append("               DECODE(VGM_CLZ_FLG,'Y',TO_CHAR(CLZ.EVNT_DT,'YYYY-MM-DD HH24:MI:SS')) CLS_DT," ).append("\n"); 
		query.append("               (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', NVL(OP_CNTR_QTY, 0)))" ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                 WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                   AND CNTR_TPSZ_CD IS NOT NULL ) TTL_QTY_T," ).append("\n"); 
		query.append("               (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', NULL, NVL(OP_CNTR_QTY, 0)))" ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                 WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                   AND CNTR_TPSZ_CD IS NOT NULL ) TTL_QTY_F," ).append("\n"); 
		query.append("			   (SELECT TO_CHAR(BKG_GET_VGM_CCT_FNC(SKD.POL_NOD_CD, SKD.SLAN_CD, SKD.SLAN_DIR_CD, CGO_TP_CD, SKD.VVD, SKD.CLPT_IND_SEQ, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT),'YYYY-MM-DD HH24:MI') AS VGM_CCT" ).append("\n"); 
		query.append("  				  FROM (SELECT SKD.SLAN_CD SLAN_CD , VVD.SKD_DIR_CD SLAN_DIR_CD , CASE WHEN DCGO_FLG = 'Y' THEN ''                                                                                                                                                                                              WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("			                                                                           WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("			                                                                           ELSE 'AL' END CGO_TP_CD," ).append("\n"); 
		query.append("		                       VPS_ETB_DT , VPS_ETD_DT , POL_NOD_CD , NVL(VVD.POL_CLPT_IND_SEQ, 1) AS CLPT_IND_SEQ , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD, BK.BKG_NO" ).append("\n"); 
		query.append("          				  FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("				         WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("				           AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("				           AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("				           AND VVD.VSL_CD NOT IN ('COXX', 'COYY', 'COZZ')" ).append("\n"); 
		query.append("				           AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("				           AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("				           AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("				           AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("				           AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ) SKD" ).append("\n"); 
		query.append("			             WHERE SKD.BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("						   AND ROWNUM = 1) VGM_CUT_OFF_TM," ).append("\n"); 
		query.append("		       DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                       BKG_BOOKING BKG1" ).append("\n"); 
		query.append("                 WHERE BB.BKG_NO = BKG1.BKG_NO" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("                   AND ((MSG.EDI_MSG_IND_CD = 31" ).append("\n"); 
		query.append("                        AND (EY.PRNR_SUB_LNK_CD = BKG1.POR_NOD_CD" ).append("\n"); 
		query.append("                             OR EY.PRNR_SUB_LNK_CD = BKG1.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                             OR EY.PRNR_SUB_LNK_CD = BKG1.MTY_RTN_YD_CD ))" ).append("\n"); 
		query.append("                       OR" ).append("\n"); 
		query.append("                       (MSG.EDI_MSG_IND_CD = 32" ).append("\n"); 
		query.append("                        AND EY.PRNR_SUB_LNK_CD = BKG1.POL_NOD_CD)" ).append("\n"); 
		query.append("                       OR " ).append("\n"); 
		query.append("                       (MSG.EDI_MSG_IND_CD = 33" ).append("\n"); 
		query.append("                        AND EXISTS (SELECT 'Y' FROM BKG_VVD WHERE BKG1.BKG_NO = BKG_NO AND EY.PRNR_SUB_LNK_CD = POL_YD_CD AND BKG1.POL_NOD_CD <> POL_YD_CD))" ).append("\n"); 
		query.append("                       OR" ).append("\n"); 
		query.append("                       (MSG.EDI_MSG_IND_CD = 35" ).append("\n"); 
		query.append("                        AND (EY.PRNR_SUB_LNK_CD = BKG1.POR_NOD_CD" ).append("\n"); 
		query.append("                             OR EY.PRNR_SUB_LNK_CD = BKG1.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                             OR EY.PRNR_SUB_LNK_CD = BKG1.MTY_RTN_YD_CD ))" ).append("\n"); 
		query.append("                       OR" ).append("\n"); 
		query.append("                       (MSG.EDI_MSG_IND_CD = 36" ).append("\n"); 
		query.append("                        AND EY.PRNR_SUB_LNK_CD = BKG1.POL_NOD_CD))" ).append("\n"); 
		query.append("                   AND ROWNUM = 1), 'Y', 'Y', 'N') SUP," ).append("\n"); 
		query.append("			   LTST.VGM_SEQ VGM_SEQ," ).append("\n"); 
		query.append("			   LTST.ESIG_CO_NM," ).append("\n"); 
		query.append("			   LTST.XTER_SNDR_ID," ).append("\n"); 
		query.append("			   LTST.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("			   LTST.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("			   LTST.XTER_VGM_USR_ID," ).append("\n"); 
		query.append("			   LTST.WGT_TP_CD," ).append("\n"); 
		query.append("			   LTST.VGM_BKG_NO," ).append("\n"); 
		query.append("			   LTST.REF_ID," ).append("\n"); 
		query.append("			   MST_SPEC_FNC('PAYL',BC.CNTR_NO) + MST_SPEC_FNC('TARE',BC.CNTR_NO) PAYLD_PLS_TARE," ).append("\n"); 
		query.append("			   (SELECT ROUND(SUM(DECODE(TC.WGT_UT_CD,'KGS',TC.CNTR_WGT,'LBS',TC.CNTR_WGT * 0.453592,NULL)),3) " ).append("\n"); 
		query.append("				   FROM BKG_BOOKING TB, BKG_CONTAINER TC" ).append("\n"); 
		query.append("				  WHERE TB.BKG_NO = TC.BKG_NO" ).append("\n"); 
		query.append("					AND BC.CNTR_NO = TC.CNTR_NO" ).append("\n"); 
		query.append("					AND TB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("					AND (TB.VSL_CD, TB.SKD_VOY_NO, TB.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("																		FROM BKG_BOOKING TT WHERE TT.BKG_NO = BB.BKG_NO)) + MST_SPEC_FNC('TARE',BC.CNTR_NO) CGO_PLS_TARE," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY BC.BKG_NO,BC.CNTR_NO  ORDER BY BC.BKG_NO,BC.CNTR_NO) AS CTR_RNUM," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY BB.BKG_NO  ORDER BY BB.BKG_NO ) AS RNUM" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD," ).append("\n"); 
		query.append("			   BKG_BOOKING BB ," ).append("\n"); 
		query.append("               BKG_CONTAINER BC ," ).append("\n"); 
		query.append("               BKG_BL_DOC BD ," ).append("\n"); 
		query.append("               BKG_CUSTOMER SHPR ," ).append("\n"); 
		query.append("               BKG_CUSTOMER FWDR ," ).append("\n"); 
		query.append("			   LTST," ).append("\n"); 
		query.append("			   SCE_COP_HDR COP," ).append("\n"); 
		query.append("               (SELECT DOC.BKG_NO," ).append("\n"); 
		query.append("                       DOC.EVNT_DT," ).append("\n"); 
		query.append("                       DOC.EVNT_USR_ID" ).append("\n"); 
		query.append("                  FROM BKG_DOC_PROC_SKD DOC" ).append("\n"); 
		query.append("                 WHERE DOC.BKG_DOC_PROC_TP_CD = 'VGMCLZ'" ).append("\n"); 
		query.append("                   AND DOC.DOC_PERF_DELT_FLG = 'N') CLZ" ).append("\n"); 
		query.append("         WHERE NVL(BB.BKG_STS_CD, 'Z') <> 'X'" ).append("\n"); 
		query.append("		   AND BB.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("           AND BB.BKG_NO = COP.BKG_NO" ).append("\n"); 
		query.append("		   AND COP.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND COP.CNTR_NO =BC.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND COP.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("		   AND BB.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("           AND BB.BKG_NO = SHPR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("           AND BB.BKG_NO = FWDR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND FWDR.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND BB.BKG_NO = CLZ.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND LTST.BKG_NO(+) = BC.BKG_NO" ).append("\n"); 
		query.append("		   AND LTST.CNTR_NO(+) = BC.CNTR_NO " ).append("\n"); 
		query.append("		   AND VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("		#if (${bkg_no_list} != '')" ).append("\n"); 
		query.append("		   AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("			#foreach($multiBkgNoVal IN ${bkg_no_list})        " ).append("\n"); 
		query.append("				#if($velocityCount < $bkg_no_list.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	       AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_vvd} != '')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("		   AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pol_yd_cd} != '')" ).append("\n"); 
		query.append("		   AND SUBSTR(VVD.POL_YD_CD,-2) = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pol_lt} == 'LC')" ).append("\n"); 
		query.append("		   AND VVD.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pol_lt} == 'TS')" ).append("\n"); 
		query.append("		   AND VVD.POL_CD <> BB.POL_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pod_cd} != '')" ).append("\n"); 
		query.append("		   AND VVD.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pod_yd_cd} != '')" ).append("\n"); 
		query.append("		   AND SUBSTR(VVD.POD_YD_CD,-2) = @[in_pod_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pod_lt} == 'LC')" ).append("\n"); 
		query.append("		   AND VVD.POD_CD = BB.POD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_pod_lt} == 'TS')" ).append("\n"); 
		query.append("		   AND VVD.POD_CD <> BB.POD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${rcv_term_cd} != '')" ).append("\n"); 
		query.append("		   AND BB.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${de_term_cd} != '')" ).append("\n"); 
		query.append("		   AND BB.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("		   AND BB.BKG_OFC_CD = @[in_bkg_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${vgm_opt} == 'I')" ).append("\n"); 
		query.append("		   AND LTST.XTER_VGM_WGT <> 0" ).append("\n"); 
		query.append("		#elseif(${vgm_opt} == 'N')" ).append("\n"); 
		query.append("		   AND NVL(LTST.XTER_VGM_WGT,0) = 0" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${in_vgm} != 'ALL')" ).append("\n"); 
		query.append("		   AND LTST.XTER_VGM_RQST_CD = DECODE(@[in_vgm],'ECOM','WEB','EDI')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${board_from_dt} != '')" ).append("\n"); 
		query.append("		   AND BD.BL_OBRD_DT >= TO_DATE(@[board_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${board_to_dt} != '')" ).append("\n"); 
		query.append("		   AND BD.BL_OBRD_DT <= TO_DATE(@[board_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${bkg_from_dt} != '')" ).append("\n"); 
		query.append("		   AND BB.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${bkg_to_dt} != '')" ).append("\n"); 
		query.append("		   AND BB.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${p_bkg_cust_tp_cd} !='' || ${in_cust_cnt_cd} !='' || ${in_cust_seq} !='' || ${in_cust_nm} != '')" ).append("\n"); 
		query.append("		AND EXISTS( SELECT 'Y'" ).append("\n"); 
		query.append("					FROM BKG_CUSTOMER Z" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					AND Z.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("				#if (${p_bkg_cust_tp_cd} !='')			" ).append("\n"); 
		query.append("		     		AND Z.BKG_CUST_TP_CD = @[p_bkg_cust_tp_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${in_cust_cnt_cd} !='')" ).append("\n"); 
		query.append("				    AND Z.CUST_CNT_CD =@[in_cust_cnt_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${in_cust_seq} !='')" ).append("\n"); 
		query.append("					AND Z.CUST_SEQ =@[in_cust_seq]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${in_cust_nm} != '') " ).append("\n"); 
		query.append("					AND UPPER(Z.CUST_NM) LIKE '%'||UPPER(@[in_cust_nm])||'%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${mss_sig} == 'Y')" ).append("\n"); 
		query.append("			AND LTST.ESIG_CO_NM IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${late_upd} == 'Y')" ).append("\n"); 
		query.append("     	    AND LTST.XTER_VGM_WGT <> BC.VGM_WGT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(") MST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${ovr_payld} == 'Y')" ).append("\n"); 
		query.append("  AND MST.VGM_WGT > MST.PAYLD_PLS_TARE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${diff_5_pct} == 'Y')" ).append("\n"); 
		query.append("  AND ABS((MST.VGM_WGT - MST.CGO_PLS_TARE) / MST.CGO_PLS_TARE * 100) > 5" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${diff_10_pct} == 'Y')" ).append("\n"); 
		query.append("  AND ABS((MST.VGM_WGT - MST.CGO_PLS_TARE) / MST.CGO_PLS_TARE * 100) > 10" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}