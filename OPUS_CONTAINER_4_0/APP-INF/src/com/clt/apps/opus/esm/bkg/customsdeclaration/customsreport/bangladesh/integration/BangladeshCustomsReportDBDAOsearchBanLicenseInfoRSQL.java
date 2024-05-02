/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshCustomsReportDBDAOsearchBanLicenseInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsReportDBDAOsearchBanLicenseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 방글라데시 세관에서 사용하는 customer별 license정보
	  * </pre>
	  */
	public BangladeshCustomsReportDBDAOsearchBanLicenseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshCustomsReportDBDAOsearchBanLicenseInfoRSQL").append("\n");
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
		query.append("SELECT LIC.CUST_LIC_NO CUST_LIC_NO," ).append("\n");
		query.append("LIC.CNT_CD||TRIM(TO_CHAR(LIC.CUST_SEQ,'000000')) CUST_CD," ).append("\n");
		query.append("CUST.CUST_LGL_ENG_NM CUST_NM," ).append("\n");
		query.append("LIC.CNT_CD CNT_CD," ).append("\n");
		query.append("LIC.CUST_SEQ CUST_SEQ," ).append("\n");
		query.append("LIC.CRE_USR_ID CRE_USR_ID," ).append("\n");
		query.append("LIC.CRE_DT," ).append("\n");
		query.append("LIC.UPD_USR_ID," ).append("\n");
		query.append("TO_CHAR(LIC.UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n");
		query.append("COM_USER.USR_NM UPD_USR_NM" ).append("\n");
		query.append("FROM BKG_CSTMS_BD_FRT_FWRD_LIC LIC," ).append("\n");
		query.append("MDM_CUSTOMER CUST," ).append("\n");
		query.append("COM_USER" ).append("\n");
		query.append("WHERE LIC.CNT_CD = CUST.CUST_CNT_CD" ).append("\n");
		query.append("AND LIC.CUST_SEQ = CUST.CUST_SEQ" ).append("\n");
		query.append("AND LIC.UPD_USR_ID = COM_USER.USR_ID" ).append("\n");
		query.append("AND LIC.CUST_LIC_NO LIKE '%'||@[cust_lic_no]||'%'" ).append("\n");
		query.append("AND LIC.CNT_CD||TRIM(TO_CHAR(LIC.CUST_SEQ,'000000')) LIKE '%'||@[cust_cd]||'%'" ).append("\n");
		query.append("AND CUST.CUST_LGL_ENG_NM LIKE '%'||@[cust_nm]||'%'" ).append("\n");

	}
}