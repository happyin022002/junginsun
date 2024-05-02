/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltCreSpotRFANoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.09.26 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltCreSpotRFANoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA NO 생성
	  * Office Prefix 3자리 + 연도 2자리 + A (Approval) + Sequence 4자리  
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltCreSpotRFANoVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltCreSpotRFANoVORSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'G'" ).append("\n"); 
		query.append("		||LPAD(NVL(MAX(SUBSTR(RFA_NO,-4)),0)+1,4,'0') RFA_NO " ).append("\n"); 
		query.append("FROM PRI_RP_HDR" ).append("\n"); 
		query.append("WHERE RFA_NO LIKE  SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'%'" ).append("\n"); 

	}
}