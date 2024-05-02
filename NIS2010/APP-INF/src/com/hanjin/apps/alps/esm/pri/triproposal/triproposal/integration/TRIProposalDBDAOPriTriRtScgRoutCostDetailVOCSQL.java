/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtScgRoutCostDetailVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtScgRoutCostDetailVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtScgRoutCostDetailVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtScgRoutCostDetailVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_RT_SCG_ROUT" ).append("\n"); 
		query.append("    (TRI_PROP_NO, AMDT_SEQ, " ).append("\n"); 
		query.append("    POR_CD, POL_CD, POD_CD, DEL_CD, RCV_TERM_CD, DE_TERM_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT A.TRI_PROP_NO, A.AMDT_SEQ," ).append("\n"); 
		query.append("       C.POR_CD, C.POL_CD, C.POD_CD, C.DEL_CD, C.BKG_RCV_TERM_CD, C.BKG_DE_TERM_CD, @[upd_usr_id], SYSDATE, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("  FROM PRI_TRI_RT A," ).append("\n"); 
		query.append("       PRI_TRI_RT_USD_ROUT_CS B," ).append("\n"); 
		query.append("       PRI_PRS_USD_ROUT_CS_INFO C" ).append("\n"); 
		query.append(" WHERE A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.PROP_STS_CD IN ( 'I', 'R' )" ).append("\n"); 
		query.append("   AND B.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("   AND B.ROUT_CS_NO = C.ROUT_CS_NO" ).append("\n"); 
		query.append("   AND B.ROUT_CS_SRC_DT = C.ROUT_CS_SRC_DT" ).append("\n"); 

	}
}