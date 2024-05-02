/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOReverseCmbDtlUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.04.27 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOReverseCmbDtlUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SETTLEMENT의 STL_SEQ값을 JOO_STL_CMB_DTL의 STL_SEQ의 값으로 넣는다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOReverseCmbDtlUpdateUSQL(){
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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CarrierSettlementProcessDBDAOReverseCmbDtlUpdateUSQL").append("\n"); 
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
		query.append("UPDATE JOO_STL_CMB_DTL SET" ).append("\n"); 
		query.append("	STL_SEQ = TO_NUMBER(@[stl_cmb_seq])," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND STL_VVD_SEQ = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("AND JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("AND STL_SEQ = TO_NUMBER(@[stl_seq])" ).append("\n"); 
		query.append("AND STL_CMB_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(STL_CMB_SEQ) " ).append("\n"); 
		query.append("FROM JOO_STL_CMB_DTL " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND STL_VVD_SEQ = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("AND JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}