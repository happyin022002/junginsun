/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAORequestAGNCommRequestListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAORequestAGNCommRequestListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_AGN_COMM 테이블에 Reqeust 관련 정보를 업데이트한다.
	  * </pre>
	  */
	public AGNCommRequestDBDAORequestAGNCommRequestListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAORequestAGNCommRequestListUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_COMM U" ).append("\n"); 
		query.append("SET (U.AC_STS_CD," ).append("\n"); 
		query.append("   U.RQST_USR_ID," ).append("\n"); 
		query.append("   U.RQST_DT," ).append("\n"); 
		query.append("   U.RQST_GDT," ).append("\n"); 
		query.append("   U.UPD_USR_ID," ).append("\n"); 
		query.append("   U.UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  =" ).append("\n"); 
		query.append("  (SELECT 'RS' AS AC_STS_CD," ).append("\n"); 
		query.append("     @[usr_id] AS RQST_USR_ID," ).append("\n"); 
		query.append("     SYSDATE AS RQST_DT," ).append("\n"); 
		query.append("     GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GMT') AS RQST_GDT," ).append("\n"); 
		query.append("     @[usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("     SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("   FROM ACM_AGN_COMM A" ).append("\n"); 
		query.append("   WHERE A.BKG_NO = U.BKG_NO" ).append("\n"); 
		query.append("     AND A.AGN_CD = U.AGN_CD" ).append("\n"); 
		query.append("     AND A.AC_TP_CD <> 'T'" ).append("\n"); 
		query.append("#if (${ac_tp_cd} != '')" ).append("\n"); 
		query.append("     AND A.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A.IO_BND_CD = U.IO_BND_CD" ).append("\n"); 
		query.append("     AND A.AC_SEQ = U.AC_SEQ" ).append("\n"); 
		query.append("     AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("     AND A.AC_TP_CD = U.AC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE U.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("  AND U.AGN_CD      = @[agn_cd]" ).append("\n"); 
		query.append("  AND U.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("  AND U.AC_SEQ      = @[ac_seq]" ).append("\n"); 
		query.append("#if (${ac_tp_cd} != '')" ).append("\n"); 
		query.append("  AND U.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND U.CRE_USR_ID  != 'COST'" ).append("\n"); 
		query.append("  AND U.AC_STS_CD   = 'CS'" ).append("\n"); 

	}
}