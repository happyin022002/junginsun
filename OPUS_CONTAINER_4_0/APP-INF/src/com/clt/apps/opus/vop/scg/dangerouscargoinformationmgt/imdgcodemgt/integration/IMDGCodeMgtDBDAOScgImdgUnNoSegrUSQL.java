/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgUnNoSegrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgUnNoSegr 수정
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoSegrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrUSQL").append("\n"); 
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
		query.append("--UPDATE SCG_IMDG_UN_NO_SEGR SET " ).append("\n"); 
		query.append("--	IMDG_SEGR_CD = [imdg_segr_cd]" ).append("\n"); 
		query.append("--,	UPD_USR_ID = [cre_usr_id]" ).append("\n"); 
		query.append("--,	UPD_DT = sysdate" ).append("\n"); 
		query.append("--WHERE	IMDG_UN_NO = [imdg_un_no]" ).append("\n"); 
		query.append("--AND	IMDG_UN_NO_SEQ = [imdg_un_no_seq]" ).append("\n"); 
		query.append("--AND	IMDG_CLSS_CD = [imdg_clss_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MERGE INTO SCG_IMDG_UN_NO_SEGR X" ).append("\n"); 
		query.append("USING      (SELECT     @[imdg_un_no]  		AS IMDG_UN_NO" ).append("\n"); 
		query.append("                    ,  @[imdg_un_no_seq]    AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                    ,  @[imdg_clss_cd]   	AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("                    ,  @[imdg_segr_cd]     	AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("                    ,  @[cre_usr_id] 		AS UPD_USR_ID" ).append("\n"); 
		query.append("            FROM       DUAL" ).append("\n"); 
		query.append("           ) 	XX" ).append("\n"); 
		query.append("ON         (	X.IMDG_UN_NO       			= XX.IMDG_UN_NO" ).append("\n"); 
		query.append("       AND  	X.IMDG_UN_NO_SEQ   			= XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       AND  	X.IMDG_CLSS_CD     			= XX.IMDG_CLSS_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE       SET               IMDG_SEGR_CD = @[imdg_segr_cd]" ).append("\n"); 
		query.append("                            ,  UPD_USR_ID   = @[cre_usr_id]" ).append("\n"); 
		query.append("                            ,  UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN                       " ).append("\n"); 
		query.append("INSERT       (X.IMDG_UN_NO" ).append("\n"); 
		query.append("             ,X.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("             ,X.IMDG_CLSS_CD" ).append("\n"); 
		query.append("             ,X.IMDG_SEGR_CD" ).append("\n"); 
		query.append("             ,X.IMDG_SEGR_MNL_FLG" ).append("\n"); 
		query.append("             ,X.CRE_USR_ID" ).append("\n"); 
		query.append("             ,X.CRE_DT" ).append("\n"); 
		query.append("             ,X.UPD_USR_ID" ).append("\n"); 
		query.append("             ,X.UPD_DT" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("VALUES       (XX.IMDG_UN_NO" ).append("\n"); 
		query.append("             ,XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("             ,XX.IMDG_CLSS_CD" ).append("\n"); 
		query.append("             ,XX.IMDG_SEGR_CD" ).append("\n"); 
		query.append("             ,'Y'" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE             " ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE  " ).append("\n"); 
		query.append("             )             " ).append("\n"); 

	}
}