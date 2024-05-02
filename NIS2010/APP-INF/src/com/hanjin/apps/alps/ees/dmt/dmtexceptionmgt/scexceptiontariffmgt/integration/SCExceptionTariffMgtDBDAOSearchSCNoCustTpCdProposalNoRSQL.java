/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchSCNoCustTpCdProposalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchSCNoCustTpCdProposalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCExceptionTariffMgtDBDAOSearchSCNoCustTpCdProposalNoRSQL
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchSCNoCustTpCdProposalNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchSCNoCustTpCdProposalNoRSQL").append("\n"); 
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
		query.append("SELECT	/*+ INDEX_DESC(A XPKPRI_SP_CTRT_CUST_TP) */ " ).append("\n"); 
		query.append("        CASE prc_ctrt_cust_tp_cd WHEN 'N' THEN 'NVO'" ).append("\n"); 
		query.append("                                 WHEN 'I' THEN 'BCO'" ).append("\n"); 
		query.append("                                 WHEN 'A' THEN 'BCO'" ).append("\n"); 
		query.append("                                 WHEN 'B' THEN 'BCO'" ).append("\n"); 
		query.append("                                 ELSE ' ' END prc_ctrt_cust_tp_cd" ).append("\n"); 
		query.append("FROM	PRI_SP_CTRT_CUST_TP A" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}