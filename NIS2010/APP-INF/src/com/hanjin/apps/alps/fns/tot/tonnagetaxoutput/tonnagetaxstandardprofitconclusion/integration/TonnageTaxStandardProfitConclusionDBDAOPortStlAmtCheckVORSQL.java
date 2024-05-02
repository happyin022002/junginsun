/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.17 장창수
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

public class TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tot_stl_cfm 테이블에 데이터를 반영하기 전  tot_port_stl_amt  테이블에 데이터가 존재하는 확인
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("STL_YRMON" ).append("\n"); 
		query.append(",	TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	PORT_SEQ" ).append("\n"); 
		query.append(",	TRD_CD" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	BSA_CAPA" ).append("\n"); 
		query.append(",	ACT_BSA_CAPA" ).append("\n"); 
		query.append(",	LDB_CAPA_QTY" ).append("\n"); 
		query.append(",	CHTR_BSA_CAPA" ).append("\n"); 
		query.append(",	BSA_CAPA_MODI_FLG" ).append("\n"); 
		query.append(",	ETD_DT" ).append("\n"); 
		query.append(",	USG_RT" ).append("\n"); 
		query.append(",	VOY_DYS" ).append("\n"); 
		query.append(",	TONG_TAX_AMT" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("WHERE	STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND	TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}