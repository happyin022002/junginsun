/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDADAOUpdateDwllNtfcSvcListDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.22 
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

public class DwellNotificationDBDADAOUpdateDwllNtfcSvcListDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email 정보를 업데이트를 한다.
	  * </pre>
	  */
	public DwellNotificationDBDADAOUpdateDwllNtfcSvcListDtlUSQL(){
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
		params.put("ntfc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_del_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : DwellNotificationDBDADAOUpdateDwllNtfcSvcListDtlUSQL").append("\n"); 
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
		query.append("UPDATE SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("SET SUBSC_EML   = DECODE(@[i_del_flg], 'Y', SUBSC_EML, TRIM(@[subsc_eml]))" ).append("\n"); 
		query.append("  , SUBSC_RMK   = DECODE(@[i_del_flg], 'Y', SUBSC_RMK, @[subsc_rmk])" ).append("\n"); 
		query.append("  , DELT_FLG    = DECODE(@[ibflag], 'D', 'Y', 'N')" ).append("\n"); 
		query.append("  , DELT_USR_ID = CASE WHEN DELT_FLG = 'N' AND @[i_del_flg] = 'Y' THEN @[usr_id]" ).append("\n"); 
		query.append("                       WHEN DELT_FLG = 'Y' AND @[i_del_flg] = 'N' THEN NULL" ).append("\n"); 
		query.append("                       ELSE DELT_USR_ID END" ).append("\n"); 
		query.append("  , DELT_DT     = CASE WHEN DELT_FLG = 'N' AND @[i_del_flg] = 'Y' THEN SYSDATE" ).append("\n"); 
		query.append("                       WHEN DELT_FLG = 'Y' AND @[i_del_flg] = 'N' THEN NULL" ).append("\n"); 
		query.append("                       ELSE DELT_DT END" ).append("\n"); 
		query.append("  , CRE_USR_ID  = CASE WHEN DELT_FLG = 'Y' AND @[i_del_flg] = 'N' THEN @[usr_id]" ).append("\n"); 
		query.append("                       ELSE CRE_USR_ID END" ).append("\n"); 
		query.append("  , CRE_DT      = CASE WHEN DELT_FLG = 'Y' AND @[i_del_flg] = 'N' THEN SYSDATE" ).append("\n"); 
		query.append("                       ELSE CRE_DT END" ).append("\n"); 
		query.append("  , UPD_USR_ID  = @[usr_id]" ).append("\n"); 
		query.append("  , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("  , EML_FM_CRM_FLG = DECODE(@[eml_fm_crm_flg],'1','Y','N')" ).append("\n"); 
		query.append("  , EML_BKG_ORG_FLG = DECODE(@[eml_bkg_org_flg],'1','Y','N')" ).append("\n"); 
		query.append("  , EML_BKG_DEST_FLG = DECODE(@[eml_bkg_dest_flg],'1','Y','N')" ).append("\n"); 
		query.append("  , EML_BKG_OTR_FLG = DECODE(@[eml_bkg_otr_flg],'1','Y','N')" ).append("\n"); 
		query.append("  , CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  AND DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("  AND NTFC_SEQ  = @[ntfc_seq]" ).append("\n"); 

	}
}