/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriCrmSILdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.15 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriCrmSILdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SALE LEAD
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriCrmSILdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("respb_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriCrmSILdVORSQL").append("\n"); 
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
		query.append("SELECT SLS_LD_NO" ).append("\n"); 
		query.append(",SLS_LD_NM" ).append("\n"); 
		query.append("FROM   PRI_CRM_SLS_LD" ).append("\n"); 
		query.append("WHERE  SLS_LD_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND SLS_LD_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND SLS_LD_SREP_CD = @[respb_srep_cd]" ).append("\n"); 
		query.append("AND SLS_LD_STS_CD ='I'" ).append("\n"); 
		query.append("#if(${first_sw} != \"Y\")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CRM.SLS_LD_NO," ).append("\n"); 
		query.append("CRM.SLS_LD_NM" ).append("\n"); 
		query.append("FROM PRI_RP_MN MN" ).append("\n"); 
		query.append(",PRI_CRM_SLS_LD CRM" ).append("\n"); 
		query.append("WHERE MN.SLS_LD_NO = CRM.SLS_LD_NO" ).append("\n"); 
		query.append("AND MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND CRM.SLS_LD_STS_CD IN( 'P','R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SLS_LD_NO" ).append("\n"); 

	}
}