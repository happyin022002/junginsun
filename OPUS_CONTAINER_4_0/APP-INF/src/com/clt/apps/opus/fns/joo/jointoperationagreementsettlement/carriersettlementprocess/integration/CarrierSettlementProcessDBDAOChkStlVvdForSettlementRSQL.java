/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOChkStlVvdForSettlementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.24 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOChkStlVvdForSettlementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Create시 해당 조건의 VVD 들이 존재하는지 check한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOChkStlVvdForSettlementRSQL(){
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
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOChkStlVvdForSettlementRSQL").append("\n"); 
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
		query.append("SELECT 'X' AS ACCT_YRMON" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("WHERE  EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("1" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("#if (${jo_mnu_nm} == 'M/S')" ).append("\n"); 
		query.append("AND  (A.JO_STL_ITM_CD = 'OTH' OR A.JO_MNU_NM = @[jo_mnu_nm])" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${jo_stl_itm_cd} == 'OUS')" ).append("\n"); 
		query.append("AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND   A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}