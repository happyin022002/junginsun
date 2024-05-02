/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TCharterIOContractDAOSearchFileCertificationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 표준희
*@LastVersion : 1.0
* 2011.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSearchFileCertificationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchFileCertificationListRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchFileCertificationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSearchFileCertificationListRSQL").append("\n"); 
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
		query.append("SELECT FILE_SEQ,    " ).append("\n"); 
		query.append("	   FLET_FILE_TP_CD," ).append("\n"); 
		query.append("	   FILE_NM,      " ).append("\n"); 
		query.append("	   FILE_DESC,      " ).append("\n"); 
		query.append("	   '0' FILE_DOWNLOAD," ).append("\n"); 
		query.append("	   FILE_SAV_ID," ).append("\n"); 
		query.append("	   EFF_DT," ).append("\n"); 
		query.append("	   EXP_DT," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT /*+ INDEX(FC XPKFMS_CHTR_PTY_FILE) */ " ).append("\n"); 
		query.append("			   FILE_SEQ," ).append("\n"); 
		query.append("			   FLET_FILE_TP_CD," ).append("\n"); 
		query.append("			   FILE_NM," ).append("\n"); 
		query.append("			   FILE_DESC," ).append("\n"); 
		query.append("			   '0' FILE_DOWNLOAD," ).append("\n"); 
		query.append("			   FILE_SAV_ID," ).append("\n"); 
		query.append("			   TO_CHAR(EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("			   TO_CHAR(EXP_DT,'YYYYMMDD') EXP_DT," ).append("\n"); 
		query.append("			   TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI' ) UPD_DT" ).append("\n"); 
		query.append("		  FROM FMS_CHTR_PTY_FILE FC" ).append("\n"); 
		query.append("		 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("		   AND FLET_FILE_TP_CD = @[flet_file_tp_cd]" ).append("\n"); 
		query.append("	   )" ).append("\n"); 

	}
}