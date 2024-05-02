/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriEdiScGenInfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.23 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriEdiScGenInfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI > EAI 로 전송하는 SC_GENINF
	  * </pre>
	  */
	public SCProposalMainDBDAOPriEdiScGenInfVORSQL(){
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
		params.put("eai_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriEdiScGenInfVORSQL").append("\n"); 
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
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append(", MN.AMDT_SEQ" ).append("\n"); 
		query.append(", HD.SC_NO" ).append("\n"); 
		query.append(", PT.CUST_CNT_CD" ).append("\n"); 
		query.append(", PT.CUST_SEQ" ).append("\n"); 
		query.append(", MN.PROP_OFC_CD" ).append("\n"); 
		query.append(", MN.PROP_SREP_CD" ).append("\n"); 
		query.append(", TO_CHAR(DR.CTRT_EFF_DT, 'YYYYMMDD') AS CTRT_EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(DR.CTRT_EXP_DT, 'YYYYMMDD') AS CTRT_EXP_DT" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS EAI_DT" ).append("\n"); 
		query.append(", @[eai_sts] AS EAI_STS" ).append("\n"); 
		query.append("FROM PRI_SP_MN MN" ).append("\n"); 
		query.append(", PRI_SP_HDR HD" ).append("\n"); 
		query.append(", PRI_SP_DUR DR" ).append("\n"); 
		query.append(", PRI_SP_CTRT_PTY PT" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   DR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   DR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND   PT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   PT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND   PT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 

	}
}