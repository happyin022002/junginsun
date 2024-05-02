/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchMonthlyStlCmbSeqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.18 박희동
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

public class CarrierSettlementProcessDBDAOSearchMonthlyStlCmbSeqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchMonthlyStlCmbSeqListRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchMonthlyStlCmbSeqListRSQL").append("\n"); 
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
		query.append("SELECT  A.STL_CMB_SEQ" ).append("\n"); 
		query.append("FROM  JOO_STL_CMB A" ).append("\n"); 
		query.append(",     JOO_STL_CMB_DTL X" ).append("\n"); 
		query.append(",     JOO_SETTLEMENT  Y" ).append("\n"); 
		query.append(",     JOO_CRR_AUTH    Z" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    X.ACCT_YRMON  = A.ACCT_YRMON" ).append("\n"); 
		query.append("AND    X.JO_CRR_CD   = A.JO_CRR_CD" ).append("\n"); 
		query.append("AND    X.STL_CMB_SEQ = A.STL_CMB_SEQ" ).append("\n"); 
		query.append("AND    X.RE_DIVR_CD  = A.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    X.ACCT_YRMON  = Y.ACCT_YRMON" ).append("\n"); 
		query.append("AND    X.STL_VVD_SEQ = Y.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    X.STL_SEQ     = Y.STL_SEQ" ).append("\n"); 
		query.append("AND    Y.JO_CRR_CD   = Z.JO_CRR_CD" ).append("\n"); 
		query.append("AND    Y.RLANE_CD    = Z.RLANE_CD" ).append("\n"); 
		query.append("AND    Z.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    Z.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.RJCT_CMB_FLG= 'N'" ).append("\n"); 
		query.append("AND    Z.JO_CRR_AUTH_CD = 'W'" ).append("\n"); 
		query.append("GROUP BY A.STL_CMB_SEQ" ).append("\n"); 
		query.append("ORDER BY A.STL_CMB_SEQ" ).append("\n"); 

	}
}