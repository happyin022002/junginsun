/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAORsltCrePropNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltCrePropNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAORsltCrePropNoVORSQL
	  * </pre>
	  */
	public SCProposalMainDBDAORsltCrePropNoVORSQL(){
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
		query.append("FileName : SCProposalMainDBDAORsltCrePropNoVORSQL").append("\n"); 
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
		query.append("SELECT    SUBSTR (@[ofc_cd], 0, 3)" ).append("\n"); 
		query.append("       || SUBSTR (TO_CHAR (SYSDATE, 'YYYY'), -2)" ).append("\n"); 
		query.append("       || LPAD (NVL (MAX (SUBSTR (MN.PROP_NO, 6, 4)), 0) + 1, 4, '0') PROP_NO" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("      ,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO LIKE" ).append("\n"); 
		query.append("          SUBSTR (@[ofc_cd], 0, 3) || SUBSTR (TO_CHAR (SYSDATE, 'YYYY'), -2) || '%'" ).append("\n"); 
		query.append("AND    MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 

	}
}