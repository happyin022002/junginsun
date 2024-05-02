/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropAmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.04 
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

public class SCProposalMainDBDAORsltPropAmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend List 조회
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropAmdtListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropAmdtListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("HDR.SC_NO              							," ).append("\n"); 
		query.append("MN.PROP_NO             							," ).append("\n"); 
		query.append("MN.AMDT_SEQ            							," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EFF_DT,'YYYY-MM-DD') CTRT_EFF_DT ," ).append("\n"); 
		query.append("TO_CHAR(DUR.CTRT_EXP_DT,'YYYY-MM-DD') CTRT_EXP_DT ," ).append("\n"); 
		query.append("TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[org_prop_no]),SYSDATE),'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_SP_MN  MN ," ).append("\n"); 
		query.append("PRI_SP_HDR HDR," ).append("\n"); 
		query.append("PRI_SP_DUR DUR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("HDR.SC_NO    = @[sc_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ  = ( SELECT MAX(AMDT_SEQ) FROM PRI_SP_MN WHERE PROP_NO = HDR.PROP_NO )" ).append("\n"); 
		query.append("AND HDR.PROP_NO  = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.PROP_NO  = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 

	}
}