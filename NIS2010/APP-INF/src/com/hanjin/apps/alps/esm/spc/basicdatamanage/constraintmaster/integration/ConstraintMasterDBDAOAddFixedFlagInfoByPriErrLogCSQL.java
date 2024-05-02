/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOAddFixedFlagInfoByPriErrLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOAddFixedFlagInfoByPriErrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받다가 에러시 Log를 남긴다.
	  * </pre>
	  */
	public ConstraintMasterDBDAOAddFixedFlagInfoByPriErrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOAddFixedFlagInfoByPriErrLogCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_CTRL_OPT_IF ORG " ).append("\n"); 
		query.append("    USING ( " ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                   (SELECT DISTINCT SC_NO FROM PRI_SP_HDR WHERE PROP_NO = @[prop_no]) SC_NO" ).append("\n"); 
		query.append("                  ,@[prop_no] PROP_NO" ).append("\n"); 
		query.append("                  ,@[amdt_seq] AMDT_SEQ" ).append("\n"); 
		query.append("             FROM DUAL" ).append("\n"); 
		query.append("          ) TMP" ).append("\n"); 
		query.append("          ON (" ).append("\n"); 
		query.append("                  ORG.SC_NO     = TMP.SC_NO" ).append("\n"); 
		query.append("              AND ORG.PROP_NO   = TMP.PROP_NO" ).append("\n"); 
		query.append("              AND ORG.AMDT_SEQ  = TMP.AMDT_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           WHEN MATCHED THEN" ).append("\n"); 
		query.append("                UPDATE SET ORG.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("           WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("                INSERT (SC_NO" ).append("\n"); 
		query.append("                       ,PROP_NO" ).append("\n"); 
		query.append("                       ,AMDT_SEQ" ).append("\n"); 
		query.append("                       ,CRE_USR_ID" ).append("\n"); 
		query.append("                       ,CRE_DT" ).append("\n"); 
		query.append("                       ,UPD_USR_ID" ).append("\n"); 
		query.append("                       ,UPD_DT" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 VALUES(" ).append("\n"); 
		query.append("                         (SELECT DISTINCT SC_NO FROM PRI_SP_HDR WHERE PROP_NO = @[prop_no])" ).append("\n"); 
		query.append("                        ,@[prop_no]" ).append("\n"); 
		query.append("                        ,@[amdt_seq]" ).append("\n"); 
		query.append("                        ,'SPC_USER'" ).append("\n"); 
		query.append("                        ,SYSDATE" ).append("\n"); 
		query.append("                        ,'SPC_USER'" ).append("\n"); 
		query.append("                        ,SYSDATE" ).append("\n"); 
		query.append("                        )" ).append("\n"); 

	}
}