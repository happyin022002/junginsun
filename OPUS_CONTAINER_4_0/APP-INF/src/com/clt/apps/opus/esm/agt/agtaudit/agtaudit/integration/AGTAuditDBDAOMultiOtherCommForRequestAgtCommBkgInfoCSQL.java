/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOtherCommForRequestAgtCommBkgInfo
	  * </pre>
	  */
	public AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtCommBkgInfoCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("( BKG_NO," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("BKG_STS_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("REV_VVD_CD," ).append("\n"); 
		query.append("TRNK_SLAN_CD," ).append("\n"); 
		query.append("TRNK_RLANE_CD," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( @[bkg_no]," ).append("\n"); 
		query.append("'F'," ).append("\n"); 
		query.append("'F'," ).append("\n"); 
		query.append("'CNTCO'," ).append("\n"); 
		query.append("@[vvd]," ).append("\n"); 
		query.append("'RBC'," ).append("\n"); 
		query.append("'CNTCO'," ).append("\n"); 
		query.append("SUBSTR(@[vvd],1,4)," ).append("\n"); 
		query.append("SUBSTR(@[vvd],5,4)," ).append("\n"); 
		query.append("SUBSTR(@[vvd],9,1)," ).append("\n"); 
		query.append("SUBSTR(@[vvd],10,1)," ).append("\n"); 
		query.append("'XX'," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}