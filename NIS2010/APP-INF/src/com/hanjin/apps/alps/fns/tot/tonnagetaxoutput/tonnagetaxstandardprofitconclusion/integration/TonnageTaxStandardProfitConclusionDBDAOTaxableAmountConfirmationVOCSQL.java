/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.12 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Confirmation TOT_STL_CFM 추가
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tong_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO TOT_STL_CFM (" ).append("\n"); 
		query.append("STL_YRMON" ).append("\n"); 
		query.append(",	TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",	TRD_CD" ).append("\n"); 
		query.append(",	TONG_ITM_CD" ).append("\n"); 
		query.append(",	CFM_FLG" ).append("\n"); 
		query.append(",	CFM_DT" ).append("\n"); 
		query.append(",	CFM_USR_ID" ).append("\n"); 
		query.append(",	N1ST_CFM_DT" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[stl_yrmon]" ).append("\n"); 
		query.append(",	(SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon] AND TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append(",	@[trd_cd]" ).append("\n"); 
		query.append(",	@[tong_itm_cd]" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	(SELECT CRE_DT" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MIN(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon] AND TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}