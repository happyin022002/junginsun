/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchProposalNoFromRfaNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.08.11 이관샨
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KuanSian Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchProposalNoFromRfaNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA No에 해당하는 Prop No를 조회한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchProposalNoFromRfaNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchProposalNoFromRfaNoVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO, RFA_NO" ).append("\n"); 
		query.append("FROM PRI_RP_HDR" ).append("\n"); 
		query.append("WHERE RFA_NO = @[rfa_no]" ).append("\n"); 

	}
}