/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnPreDdctTrspCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnPreDdctTrspCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 TRSP 비용 조회 query
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnPreDdctTrspCSQL(){
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
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnPreDdctTrspCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("SELECT TRSP.BKG_NO," ).append("\n"); 
		query.append("  @[agn_cd] AS AGN_CD," ).append("\n"); 
		query.append("  @[io_bnd_cd] AS IO_BND_CD," ).append("\n"); 
		query.append("  @[ac_tp_cd] AS AC_TP_CD," ).append("\n"); 
		query.append("  @[max_ac_seq] AS AC_SEQ," ).append("\n"); 
		query.append("  TRSP.AC_TRSP_SEQ," ).append("\n"); 
		query.append("  TRSP.TRSP_MOD_CD," ).append("\n"); 
		query.append("  TRSP.TRSP_DDCT_CD," ).append("\n"); 
		query.append("  TRSP.FM_LOC_CD," ).append("\n"); 
		query.append("  TRSP.TO_LOC_CD," ).append("\n"); 
		query.append("  TRSP.TRSP_DDCT_AMT," ).append("\n"); 
		query.append("  TRSP.TRSP_LVL," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_COMM_TRSP TRSP" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("  AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("  AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("  AND AC_SEQ = (SELECT MAX(AC_SEQ)" ).append("\n"); 
		query.append("                FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("                WHERE BKG_NO = TRSP.BKG_NO" ).append("\n"); 
		query.append("                  AND AGN_CD = TRSP.AGN_CD" ).append("\n"); 
		query.append("                  AND IO_BND_CD = TRSP.IO_BND_CD" ).append("\n"); 
		query.append("                  AND AC_TP_CD = TRSP.AC_TP_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}