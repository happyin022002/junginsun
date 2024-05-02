/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.11 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 정보를 EQR IF 테이블에 수정 SQL
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL").append("\n"); 
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
		query.append("UPDATE EQR_REPO_EXE_SO_IF T" ).append("\n"); 
		query.append("SET ( WO_EXE_FLG,TRSP_SO_STS_CD ,WO_EXE_DT, REPO_COST_AMT ) =" ).append("\n"); 
		query.append("( SELECT 'Y'," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrlOfcCd]), 'YYYYMMDD')," ).append("\n"); 
		query.append("SUM( NVL(B.BZC_AMT,0)+NVL(B.FUEL_SCG_AMT,0) )" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD A, TRS_TRSP_RAIL_CONV_AMT B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD=B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ=B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID= T.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK=T.PLN_YRWK" ).append("\n"); 
		query.append("AND A.REF_ID=T.REF_ID" ).append("\n"); 
		query.append("AND A.REF_SEQ=T.REF_SEQ" ).append("\n"); 
		query.append("AND B.CURR_CD = 'USD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE T.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND T.PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("AND T.REF_ID = @[ref_id]" ).append("\n"); 
		query.append("AND T.REF_SEQ = @[ref_seq]" ).append("\n"); 

	}
}