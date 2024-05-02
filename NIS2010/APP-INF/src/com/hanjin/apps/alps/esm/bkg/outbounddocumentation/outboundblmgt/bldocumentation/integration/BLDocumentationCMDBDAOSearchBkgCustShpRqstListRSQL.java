/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchBkgCustShpRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.02.13 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchBkgCustShpRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 방글라데시 ODCY로부터의 파일을 조회
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchBkgCustShpRqstListRSQL(){
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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchBkgCustShpRqstListRSQL").append("\n"); 
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
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("    VVD.POL_CD," ).append("\n"); 
		query.append("    VVD.BKG_NO," ).append("\n"); 
		query.append("    SHP.CNTR_NO," ).append("\n"); 
		query.append("    SHP.CNTR_SEQ," ).append("\n"); 
		query.append("    SHP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    SHP.CNTR_VOL_QTY," ).append("\n"); 
		query.append("    SHP.CNTR_SEAL_NO," ).append("\n"); 
		query.append("    SHP.PCK_QTY," ).append("\n"); 
		query.append("    SHP.PCK_TP_CD," ).append("\n"); 
		query.append("    SHP.CNTR_WGT," ).append("\n"); 
		query.append("    SHP.WGT_UT_CD," ).append("\n"); 
		query.append("    SHP.MEAS_QTY," ).append("\n"); 
		query.append("    SHP.MEAS_UT_CD," ).append("\n"); 
		query.append("     TO_CHAR(SHP.CRE_DT,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("    SHP.CRE_USR_ID," ).append("\n"); 
		query.append("    (SELECT OFC_CD FROM COM_USER WHERE USR_ID = SHP.CRE_USR_ID) OFC_CD" ).append("\n"); 
		query.append(" FROM BKG_VVD VVD, BKG_CUST_SHP_RQST SHP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	#if(${vvd_cd} !='')" ).append("\n"); 
		query.append("		AND VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${pol_cd} !='')" ).append("\n"); 
		query.append("		AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${slan_cd} !='')" ).append("\n"); 
		query.append("		AND VVD.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND VVD.BKG_NO = SHP.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${cre_dt} !='')" ).append("\n"); 
		query.append("		AND SHP.CRE_DT >= TO_DATE(@[cre_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        AND SHP.CRE_DT <= TO_DATE(@[cre_dt],'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("     #if(${cre_usr_id} !='')" ).append("\n"); 
		query.append("		AND SHP.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${bkg_no} !='')" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} == '' && ${bkg_no} !='')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("    VVD.POL_CD," ).append("\n"); 
		query.append("    VVD.BKG_NO," ).append("\n"); 
		query.append("    SHP.CNTR_NO," ).append("\n"); 
		query.append("    SHP.CNTR_SEQ," ).append("\n"); 
		query.append("    SHP.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    SHP.CNTR_VOL_QTY," ).append("\n"); 
		query.append("    SHP.CNTR_SEAL_NO," ).append("\n"); 
		query.append("    SHP.PCK_QTY," ).append("\n"); 
		query.append("    SHP.PCK_TP_CD," ).append("\n"); 
		query.append("    SHP.CNTR_WGT," ).append("\n"); 
		query.append("    SHP.WGT_UT_CD," ).append("\n"); 
		query.append("    SHP.MEAS_QTY," ).append("\n"); 
		query.append("    SHP.MEAS_UT_CD," ).append("\n"); 
		query.append("     TO_CHAR(SHP.CRE_DT,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("    SHP.CRE_USR_ID," ).append("\n"); 
		query.append("    (SELECT OFC_CD FROM COM_USER WHERE USR_ID = SHP.CRE_USR_ID) OFC_CD" ).append("\n"); 
		query.append(" FROM BKG_BOOKING VVD, BKG_CUST_SHP_RQST SHP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    #if(${pol_cd} !='')" ).append("\n"); 
		query.append("		AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${slan_cd} !='')" ).append("\n"); 
		query.append("		AND VVD.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND VVD.BKG_NO = SHP.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${cre_dt} !='')" ).append("\n"); 
		query.append("		AND SHP.CRE_DT >= TO_DATE(@[cre_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        AND SHP.CRE_DT <= TO_DATE(@[cre_dt],'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("     #if(${cre_usr_id} !='')" ).append("\n"); 
		query.append("		AND SHP.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${bkg_no} !='')" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}