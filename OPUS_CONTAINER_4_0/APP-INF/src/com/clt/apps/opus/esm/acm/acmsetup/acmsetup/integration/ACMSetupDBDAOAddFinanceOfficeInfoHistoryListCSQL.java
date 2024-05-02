/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMSetupDBDAOAddFinanceOfficeInfoHistoryListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOAddFinanceOfficeInfoHistoryListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_OFC_INFO_HIS 테이블에 데이터를 생성한다.
	  * </pre>
	  */
	public ACMSetupDBDAOAddFinanceOfficeInfoHistoryListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("agn_info_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOAddFinanceOfficeInfoHistoryListCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_OFC_INFO_HIS" ).append("\n"); 
		query.append("(AGN_INFO_SEQ, AGN_HIS_NO, AGN_CD, AGN_FM_DT_CD, AGN_FM_DT, AGN_TO_DT_CD, AGN_TO_DT, RHQ_CD, OFC_CD, OFC_GRP_ID, DP_GRP_NM, AR_OFC_CD, OFC_CHR_CD, XCH_RT_DIV_LVL, CURR_CD, VNDR_CNT_CD, VNDR_SEQ, MODI_FINC_CTRL_OFC_CD, MODI_AR_OFC_CD, AGN_OFC_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" AGN_INFO_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE,'YYMMDD') || TO_CHAR(ACM_OFC_INFO_HIS_SEQ.NEXTVAL,'FM0000') AS AGN_HIS_NO" ).append("\n"); 
		query.append(",AGN_CD" ).append("\n"); 
		query.append(",AGN_FM_DT_CD" ).append("\n"); 
		query.append(",AGN_FM_DT" ).append("\n"); 
		query.append(",AGN_TO_DT_CD" ).append("\n"); 
		query.append(",AGN_TO_DT" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",OFC_GRP_ID" ).append("\n"); 
		query.append(",DP_GRP_NM" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",OFC_CHR_CD" ).append("\n"); 
		query.append(",XCH_RT_DIV_LVL" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VNDR_CNT_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",MODI_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",MODI_AR_OFC_CD" ).append("\n"); 
		query.append(",AGN_OFC_RMK" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM ACM_OFC_INFO" ).append("\n"); 
		query.append("WHERE AGN_INFO_SEQ = TO_NUMBER(@[agn_info_seq])" ).append("\n"); 

	}
}