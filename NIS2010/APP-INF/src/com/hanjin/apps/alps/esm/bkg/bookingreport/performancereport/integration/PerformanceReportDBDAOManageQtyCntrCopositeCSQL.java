/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOManageQtyCntrCopositeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
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

public class PerformanceReportDBDAOManageQtyCntrCopositeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOManageQtyCntrCopositeCSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOManageQtyCntrCopositeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cz_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOManageQtyCntrCopositeCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_CZ" ).append("\n"); 
		query.append("(BKG_NO,  BKG_CZ_STS_CD,  BKG_CZ_DESC, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[bkg_no],@[bkg_cz_sts_cd]," ).append("\n"); 
		query.append("#if (${bkg_cz_sts_cd} == 'CN')" ).append("\n"); 
		query.append("BKG_JOIN_CLOB_FNC( CURSOR(SELECT   CNTR_TPSZ_CD||'-'||CNTR_NO" ).append("\n"); 
		query.append("FROM     BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE    BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD, CNTR_NO ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${bkg_cz_sts_cd} == 'CQ')" ).append("\n"); 
		query.append("BKG_JOIN_CLOB_FNC( CURSOR(SELECT   CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(OP_CNTR_QTY), 0),'99990.99'))" ).append("\n"); 
		query.append("FROM     BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE    BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'SYSTEM'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'SYSTEM'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}