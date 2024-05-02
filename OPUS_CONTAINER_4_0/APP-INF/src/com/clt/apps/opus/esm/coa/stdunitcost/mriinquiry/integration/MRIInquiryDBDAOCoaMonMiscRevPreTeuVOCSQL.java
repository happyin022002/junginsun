/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MRIInquiryDBDAOCoaMonMiscRevPreTeuVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOCoaMonMiscRevPreTeuVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _MON_MISC_REV_PRE_TEU 테이블의 데이터 삽입
	  * </pre>
	  */
	public MRIInquiryDBDAOCoaMonMiscRevPreTeuVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_ut_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOCoaMonMiscRevPreTeuVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MON_MISC_REV_PRE_TEU B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.REV_YRMON  = @[rev_yrmon]						" ).append("\n"); 
		query.append("	 AND B1.TRD_CD = @[trd_cd]						" ).append("\n"); 
		query.append("	 AND B1.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("     AND B1.RLANE_CD = NVL(@[rlane_cd], 'XXXXX'))	" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET TRD_TTL_AMT    = @[trd_ttl_amt] " ).append("\n"); 
		query.append("           ,TRD_TTL_QTY    = @[trd_ttl_qty] " ).append("\n"); 
		query.append("           ,ETC_UT_REV_AMT = @[etc_ut_rev_amt] " ).append("\n"); 
		query.append("           ,UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append("           ,UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("		    (" ).append("\n"); 
		query.append("			 REV_YRMON" ).append("\n"); 
		query.append("		    ,TRD_CD" ).append("\n"); 
		query.append("			,RLANE_CD" ).append("\n"); 
		query.append("			,DIR_CD" ).append("\n"); 
		query.append("			,TRD_TTL_AMT" ).append("\n"); 
		query.append("			,TRD_TTL_QTY" ).append("\n"); 
		query.append("			,ETC_UT_REV_AMT" ).append("\n"); 
		query.append("			,CRE_USR_ID" ).append("\n"); 
		query.append("			,CRE_DT" ).append("\n"); 
		query.append("			,UPD_USR_ID" ).append("\n"); 
		query.append("			,UPD_DT" ).append("\n"); 
		query.append("			 )VALUES(" ).append("\n"); 
		query.append("					 @[rev_yrmon]" ).append("\n"); 
		query.append("	   			    ,@[trd_cd]" ).append("\n"); 
		query.append("   	  			    ,NVL(@[rlane_cd], 'XXXXX')" ).append("\n"); 
		query.append("	   			    ,@[dir_cd] " ).append("\n"); 
		query.append("	   			    ,@[trd_ttl_amt]" ).append("\n"); 
		query.append("	   			    ,@[trd_ttl_qty]" ).append("\n"); 
		query.append("	   			    ,@[etc_ut_rev_amt]" ).append("\n"); 
		query.append("	   			    ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   			    ,SYSDATE" ).append("\n"); 
		query.append("	   			    ,@[upd_usr_id]" ).append("\n"); 
		query.append("	   			    ,SYSDATE)" ).append("\n"); 

	}
}