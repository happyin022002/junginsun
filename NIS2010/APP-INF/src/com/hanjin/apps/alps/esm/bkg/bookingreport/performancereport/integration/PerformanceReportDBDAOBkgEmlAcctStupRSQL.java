/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgEmlAcctStupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.26 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgEmlAcctStupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEmlAcctStup
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgEmlAcctStupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgEmlAcctStupRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	EML_CPY_TO_EML" ).append("\n"); 
		query.append(",	EML_ACCT_SEQ" ).append("\n"); 
		query.append(",	BKG_OFC_CD" ).append("\n"); 
		query.append(",	EML_PRIO_NO" ).append("\n"); 
		query.append(",	INCL_SUB_OFC_FLG" ).append("\n"); 
		query.append(",	DPCS_EML_SVC_KND_CD" ).append("\n"); 
		query.append(",	DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append(",	VBS_CTNT" ).append("\n"); 
		query.append(",	POL_DPCS_EML_LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	DEL_DPCS_EML_LOC_GRP_TP_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",	RGN_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_EML_ACCT_STUP" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND	NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("AND	BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}