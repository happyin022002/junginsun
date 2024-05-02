/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDADAOInsertDwllNtfcSvcListDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDADAOInsertDwllNtfcSvcListDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email을 저장을 한다.
	  * </pre>
	  */
	public DwellNotificationDBDADAOInsertDwllNtfcSvcListDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_bkg_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_bkg_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_fm_crm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_bkg_otr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDADAOInsertDwllNtfcSvcListDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("(DWLL_CUST_CNT_CD," ).append("\n"); 
		query.append(" DWLL_CUST_SEQ," ).append("\n"); 
		query.append(" NTFC_SEQ," ).append("\n"); 
		query.append(" SUBSC_EML," ).append("\n"); 
		query.append(" SUBSC_RMK," ).append("\n"); 
		query.append(" EML_FM_CRM_FLG, " ).append("\n"); 
		query.append(" EML_BKG_ORG_FLG, " ).append("\n"); 
		query.append(" EML_BKG_DEST_FLG, " ).append("\n"); 
		query.append(" EML_BKG_OTR_FLG, " ).append("\n"); 
		query.append(" DELT_FLG," ).append("\n"); 
		query.append(" CRE_OFC_CD, " ).append("\n"); 
		query.append(" CRE_USR_ID," ).append("\n"); 
		query.append(" UPD_USR_ID, " ).append("\n"); 
		query.append(" CRE_DT, " ).append("\n"); 
		query.append(" UPD_DT," ).append("\n"); 
		query.append(" SND_OPT_CD)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(SUBSTR(@[cust_cd],1,2), " ).append("\n"); 
		query.append(" TO_NUMBER(SUBSTR(@[cust_cd],3,6))," ).append("\n"); 
		query.append(" NVL((select max(SUB.NTFC_SEQ) + 1 from SCE_DWLL_CUST_SVC_LIST SUB WHERE DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2) AND DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))), 1)," ).append("\n"); 
		query.append(" @[subsc_eml]," ).append("\n"); 
		query.append(" @[subsc_rmk]," ).append("\n"); 
		query.append(" DECODE(@[eml_fm_crm_flg],'1','Y','N')," ).append("\n"); 
		query.append(" DECODE(@[eml_bkg_org_flg],'1','Y','N')," ).append("\n"); 
		query.append(" DECODE(@[eml_bkg_dest_flg],'1','Y','N')," ).append("\n"); 
		query.append(" DECODE(@[eml_bkg_otr_flg],'1','Y','N')," ).append("\n"); 
		query.append("  'N', " ).append("\n"); 
		query.append(" @[cre_ofc_cd]," ).append("\n"); 
		query.append(" @[usr_id] ," ).append("\n"); 
		query.append(" @[usr_id], " ).append("\n"); 
		query.append(" SYSDATE, " ).append("\n"); 
		query.append(" SYSDATE," ).append("\n"); 
		query.append(" 'AW')" ).append("\n"); 

	}
}