/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlse0052CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlse0052CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSAQ_MON_QTA_RLSE
	  * </pre>
	  */
	public MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlse0052CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlse0052CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_RLSE(" ).append("\n"); 
		query.append("		    MQTA_RLSE_VER_NO, " ).append("\n"); 
		query.append("		    BSE_YR, " ).append("\n"); 
		query.append("		    BSE_QTR_CD, " ).append("\n"); 
		query.append("		    RLSE_GDT, " ).append("\n"); 
		query.append("		    QTA_RLSE_STS_CD, " ).append("\n"); 
		query.append("		    CRE_USR_ID,     " ).append("\n"); 
		query.append("            CRE_DT,     " ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("		) VALUES(" ).append("\n"); 
		query.append("		    @[mqta_rlse_ver_no], " ).append("\n"); 
		query.append("		    @[bse_yr], " ).append("\n"); 
		query.append("		    @[bse_qtr_cd], " ).append("\n"); 
		query.append("		    CAST(SYS_EXTRACT_UTC(SYSTIMESTAMP) AS DATE), " ).append("\n"); 
		query.append("		    'R', " ).append("\n"); 
		query.append("		    @[cre_usr_id],     " ).append("\n"); 
		query.append("            SYSDATE,    " ).append("\n"); 
		query.append("            @[upd_usr_id],     " ).append("\n"); 
		query.append("            SYSDATE" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}