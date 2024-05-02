/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPropCpGetNewPropNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.02 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPropCpGetNewPropNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Copy PropNo Select
	  * </pre>
	  */
	public SCProposalMainDBDAOPropCpGetNewPropNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPropCpGetNewPropNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[ofc_cd],1,3) || TO_CHAR(SYSDATE,'YY') ||" ).append("\n"); 
		query.append("LPAD(NVL((MAX(SUBSTR(MN.PROP_NO,6))), 0) + 1, 4, '0') AS PROP_NO" ).append("\n"); 
		query.append("FROM PRI_SP_MN MN" ).append("\n"); 
		query.append(",PRI_SP_HDR HDR" ).append("\n"); 
		query.append("WHERE MN.PROP_NO LIKE SUBSTR (@[ofc_cd], 1, 3) || TO_CHAR(SYSDATE,'YY') || '%'" ).append("\n"); 
		query.append("AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("AND   HDR.PRC_PROP_CRE_TP_CD <> 'I'" ).append("\n"); 

	}
}