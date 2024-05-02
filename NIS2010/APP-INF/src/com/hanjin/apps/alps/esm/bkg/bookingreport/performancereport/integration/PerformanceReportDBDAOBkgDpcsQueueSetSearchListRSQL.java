/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgDpcsQueueSetSearchListRSQL").append("\n"); 
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
		query.append("	SET_SLCT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	USR_ID" ).append("\n"); 
		query.append(",	SET_SUB_SEQ" ).append("\n"); 
		query.append(",	DOC_TP_CD" ).append("\n"); 
		query.append(",	BKG_UPLD_STS_CD" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append(",	XTER_RQST_VIA_CD" ).append("\n"); 
		query.append(",	ORG_CNT_CD" ).append("\n"); 
		query.append(",	DEL_CONTI_CD" ).append("\n"); 
		query.append(",	HNDL_OFC_CD" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	DECODE(CUST_SEQ, 0, '', CUST_SEQ) CUST_SEQ" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	SREP_CD" ).append("\n"); 
		query.append(",	CHN_AGN_CD" ).append("\n"); 
		query.append(",	SLAN_CD LANE" ).append("\n"); 
		query.append(",   XTER_SNDR_ID EDI_ID" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_SRCH_SET" ).append("\n"); 
		query.append("WHERE	USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND	DOC_TP_CD = 'D'" ).append("\n"); 

	}
}