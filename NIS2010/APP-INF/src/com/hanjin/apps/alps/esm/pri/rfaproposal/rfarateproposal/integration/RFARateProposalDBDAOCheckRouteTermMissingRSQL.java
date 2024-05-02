/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFARateProposalDBDAOCheckRouteTermMissingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.11 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOCheckRouteTermMissingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route 중에 term이 빠진 Location을 찾는다.
	  * </pre>
	  */
	public RFARateProposalDBDAOCheckRouteTermMissingRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOCheckRouteTermMissingRSQL").append("\n"); 
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
		query.append("SELECT PNT.SVC_SCP_CD, COM.INTG_CD_VAL_DESC AS ORG_DEST_TP_CD , PNT.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ROUT_PNT PNT" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append(" WHERE PNT.RCV_DE_TERM_CD IS NULL" ).append("\n"); 
		query.append("   AND COM.INTG_CD_ID = 'CD02166'" ).append("\n"); 
		query.append("   AND COM.INTG_CD_VAL_CTNT = PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(" ORDER BY PNT.SVC_SCP_CD, COM.INTG_CD_VAL_DESC , PNT.ROUT_PNT_LOC_TP_CD" ).append("\n"); 

	}
}