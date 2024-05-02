/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchCandidateDwllNtfcSvcPopUpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19 
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

public class DwellNotificationDBDAOSearchCandidateDwllNtfcSvcPopUpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCandidateDwllNtfcSvcPopUpList
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchCandidateDwllNtfcSvcPopUpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchCandidateDwllNtfcSvcPopUpListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	   DEML.CRE_OFC_CD" ).append("\n"); 
		query.append("     , DEML.NTFC_SEQ" ).append("\n"); 
		query.append("     , DEML.SUBSC_EML" ).append("\n"); 
		query.append("     , DECODE(DEML.EML_FM_CRM_FLG,'Y','1','0') EML_FM_CRM_FLG" ).append("\n"); 
		query.append("     , DECODE(DEML.EML_BKG_ORG_FLG,'Y','1','0') EML_BKG_ORG_FLG" ).append("\n"); 
		query.append("     , DECODE(DEML.EML_BKG_DEST_FLG,'Y','1','0') EML_BKG_DEST_FLG" ).append("\n"); 
		query.append("     , DECODE(DEML.EML_BKG_OTR_FLG,'Y','1','0') EML_BKG_OTR_FLG" ).append("\n"); 
		query.append("     , DEML.SUBSC_RMK" ).append("\n"); 
		query.append("     , DECODE(SND_OPT_CD, 'AW','1','0') SND_OPT_CD_AW" ).append("\n"); 
		query.append("     , DECODE(SND_OPT_CD, 'OT','1','0') SND_OPT_CD_OT" ).append("\n"); 
		query.append("     , TO_CHAR(DEML.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("     , DEML.CRE_USR_ID" ).append("\n"); 
		query.append("     , CUSR.USR_NM CRE_USR_NM" ).append("\n"); 
		query.append("     , DECODE(DELT_FLG, 'Y', TO_CHAR(DEML.DELT_DT,'YYYY-MM-DD')) DELT_DT" ).append("\n"); 
		query.append("     , DEML.DELT_USR_ID" ).append("\n"); 
		query.append("     , DUSR.USR_NM DELT_USR_NM" ).append("\n"); 
		query.append("     , DEML.DELT_FLG I_DEL_FLG" ).append("\n"); 
		query.append("	 , DEML.DWLL_CUST_CNT_CD || LPAD(DEML.DWLL_CUST_SEQ,6,0) AS CUST_CD" ).append("\n"); 
		query.append("	 , (SELECT 'Y' FROM SCE_DWLL_NTFC_EML_SND_RSLT R WHERE R.DWLL_CUST_CNT_CD = DEML.DWLL_CUST_CNT_CD AND R.DWLL_CUST_SEQ = DEML.DWLL_CUST_SEQ AND R.SUBSC_EML = DEML.SUBSC_EML AND R.SND_OPT_CD = 'OT' AND ROWNUM=1) AS OT_SND_HIST" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST DEML" ).append("\n"); 
		query.append("   , COM_USER CUSR" ).append("\n"); 
		query.append("   , COM_USER DUSR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DEML.DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND DEML.DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("AND NVL(DEML.DELT_FLG, 'N') = NVL(@[i_del_flg],'N') --Y OR N" ).append("\n"); 
		query.append("AND UPPER(DEML.SUBSC_EML) LIKE '%' || UPPER(@[eml_addr]) || '%'" ).append("\n"); 
		query.append("AND CUSR.USR_ID (+) = DEML.CRE_USR_ID" ).append("\n"); 
		query.append("AND DUSR.USR_ID (+) = DEML.DELT_USR_ID" ).append("\n"); 

	}
}