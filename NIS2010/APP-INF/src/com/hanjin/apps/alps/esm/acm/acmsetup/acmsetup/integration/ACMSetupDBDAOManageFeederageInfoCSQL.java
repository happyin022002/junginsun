/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSetupDBDAOManageFeederageInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOManageFeederageInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManageFeederageInfo
	  * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
	  * </pre>
	  */
	public ACMSetupDBDAOManageFeederageInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ddct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOManageFeederageInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_OTR_FDRG_DDCT (" ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  OTR_FDRG_DDCT_SEQ," ).append("\n"); 
		query.append("  FM_EFF_DT," ).append("\n"); 
		query.append("  TO_EFF_DT," ).append("\n"); 
		query.append("  DDCT_AMT," ).append("\n"); 
		query.append("  DELT_FLG," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[pod_cd] AS POD_CD," ).append("\n"); 
		query.append("  @[pol_cd] AS POL_CD," ).append("\n"); 
		query.append("  @[cntr_tpsz_cd] AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  (SELECT NVL(MAX(OTR_FDRG_DDCT_SEQ), 0) + 1" ).append("\n"); 
		query.append("   FROM ACM_OTR_FDRG_DDCT" ).append("\n"); 
		query.append("   WHERE POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("     AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("     AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("  ) AS OTR_FDRG_DDCT_SEQ," ).append("\n"); 
		query.append("  SYSDATE AS FM_EFF_DT," ).append("\n"); 
		query.append("  '29991231' AS TO_EFF_DT," ).append("\n"); 
		query.append("  @[ddct_amt] AS DDCT_AMT," ).append("\n"); 
		query.append("  'N' AS DELT_FLG," ).append("\n"); 
		query.append("  @[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("  SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("  @[usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("  SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}