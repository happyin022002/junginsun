/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOAddSceDwllCustSvcListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.07.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOAddSceDwllCustSvcListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_DWLL_CUST_SVC_LIST에 데이터를 INSERT를 한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOAddSceDwllCustSvcListCSQL(){
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
		params.put("dwll_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snd_opt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOAddSceDwllCustSvcListCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_DWLL_CUST_SVC_LIST A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("@[dwll_cust_cnt_cd] AS   DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append(",@[dwll_cust_seq]    AS   DWLL_CUST_SEQ" ).append("\n"); 
		query.append(",@[subsc_eml]        AS   SUBSC_EML" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON  (" ).append("\n"); 
		query.append("A.DWLL_CUST_CNT_CD    = B.DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append("AND  A.DWLL_CUST_SEQ  = B.DWLL_CUST_SEQ" ).append("\n"); 
		query.append("AND  A.SUBSC_EML      = B.SUBSC_EML" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET  A.DELT_FLG = 'N'," ).append("\n"); 
		query.append("A.UPD_USR_ID  = @[upd_usr_id] ," ).append("\n"); 
		query.append("A.SND_OPT_CD = @[snd_opt_cd]," ).append("\n"); 
		query.append("A.SUBSC_RMK = @[subsc_rmk]," ).append("\n"); 
		query.append("A.EML_FM_CRM_FLG =  @[eml_fm_crm_flg]," ).append("\n"); 
		query.append("A.EML_BKG_ORG_FLG = @[eml_bkg_org_flg]," ).append("\n"); 
		query.append("A.EML_BKG_DEST_FLG = @[eml_bkg_dest_flg]," ).append("\n"); 
		query.append("A.EML_BKG_OTR_FLG =  @[eml_bkg_otr_flg]," ).append("\n"); 
		query.append("A.UPD_DT      = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append(",DWLL_CUST_SEQ" ).append("\n"); 
		query.append(",NTFC_SEQ" ).append("\n"); 
		query.append(",SUBSC_EML" ).append("\n"); 
		query.append(",SUBSC_RMK" ).append("\n"); 
		query.append(",EML_FM_CRM_FLG" ).append("\n"); 
		query.append(",EML_BKG_ORG_FLG" ).append("\n"); 
		query.append(",EML_BKG_DEST_FLG" ).append("\n"); 
		query.append(",EML_BKG_OTR_FLG" ).append("\n"); 
		query.append(",DELT_USR_ID" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",DELT_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",SND_OPT_CD)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[dwll_cust_cnt_cd]" ).append("\n"); 
		query.append(",@[dwll_cust_seq]" ).append("\n"); 
		query.append(",@[ntfc_seq]" ).append("\n"); 
		query.append(",@[subsc_eml]" ).append("\n"); 
		query.append(",@[subsc_rmk]" ).append("\n"); 
		query.append(",@[eml_fm_crm_flg]" ).append("\n"); 
		query.append(",@[eml_bkg_org_flg]" ).append("\n"); 
		query.append(",@[eml_bkg_dest_flg]" ).append("\n"); 
		query.append(",@[eml_bkg_otr_flg]" ).append("\n"); 
		query.append(",@[delt_usr_id]" ).append("\n"); 
		query.append(",@[delt_flg]" ).append("\n"); 
		query.append(",TO_DATE(@[delt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[cre_ofc_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[snd_opt_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}