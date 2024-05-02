/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOArbGriCheckVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.06.02 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOArbGriCheckVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Init이외의 상태를 가지고 있는 데이터를 조회합니다
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOArbGriCheckVOUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOArbGriCheckVOUSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, 'T', 'F') CD " ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO            = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ           = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   PRC_PROG_STS_CD    = 'A'" ).append("\n"); 

	}
}