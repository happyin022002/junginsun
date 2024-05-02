/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCopyJooStlDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.24 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCopyJooStlDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse 전표 생성시 JOO_SETTLEMENT copy할때 JOO_STL_DTL도 COPY한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCopyJooStlDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCopyJooStlDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_STL_DTL (" ).append("\n"); 
		query.append("    ACCT_YRMON" ).append("\n"); 
		query.append("   ,STL_VVD_SEQ" ).append("\n"); 
		query.append("   ,STL_SEQ" ).append("\n"); 
		query.append("   ,STL_DTL_SEQ" ).append("\n"); 
		query.append("   ,BSA_QTY" ).append("\n"); 
		query.append("   ,BSA_SLT_PRC" ).append("\n"); 
		query.append("   ,STL_LOCL_AMT" ).append("\n"); 
		query.append("   ,STL_USD_AMT" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    ACCT_YRMON     " ).append("\n"); 
		query.append("   ,STL_VVD_SEQ " ).append("\n"); 
		query.append("   ,TO_NUMBER(@[stl_cmb_seq]) AS STL_SEQ     " ).append("\n"); 
		query.append("   ,STL_DTL_SEQ " ).append("\n"); 
		query.append("   ,BSA_QTY     " ).append("\n"); 
		query.append("   ,BSA_SLT_PRC " ).append("\n"); 
		query.append("   ,STL_LOCL_AMT" ).append("\n"); 
		query.append("   ,STL_USD_AMT " ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("FROM  JOO_STL_DTL" ).append("\n"); 
		query.append("WHERE ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND   STL_VVD_SEQ = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("AND   STL_SEQ     = TO_NUMBER(@[stl_seq])" ).append("\n"); 

	}
}