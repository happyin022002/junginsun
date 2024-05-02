/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORfaSlsLdCtrtInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.25 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORfaSlsLdCtrtInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRM으로 전송하는 RFA Sales Lead Contract Info를 조회한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAORfaSlsLdCtrtInfoVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORfaSlsLdCtrtInfoVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(", RFA_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", CUST_CODE" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", PROP_SREP_CD" ).append("\n"); 
		query.append(", PROP_OFC_CD" ).append("\n"); 
		query.append(", SLS_LD_NO" ).append("\n"); 
		query.append(", FNL_MQC_QTY" ).append("\n"); 
		query.append(", FILE_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT HD.PROP_NO" ).append("\n"); 
		query.append(", HD.RFA_NO" ).append("\n"); 
		query.append(", MN.AMDT_SEQ" ).append("\n"); 
		query.append(", MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append(", MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') AS CUST_CODE" ).append("\n"); 
		query.append(", SP.SVC_SCP_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(ORDER BY SP.TGT_MVC_QTY) AS SEQ" ).append("\n"); 
		query.append(", TO_CHAR(MN.EFF_DT, 'YYYYMMDD')||'000000' AS EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(MN.EXP_DT, 'YYYYMMDD')||'000000' AS EXP_DT" ).append("\n"); 
		query.append(", MN.PROP_SREP_CD" ).append("\n"); 
		query.append(", MN.PROP_OFC_CD" ).append("\n"); 
		query.append(", MN.SLS_LD_NO" ).append("\n"); 
		query.append(", MN.TGT_MVC_QTY AS FNL_MQC_QTY" ).append("\n"); 
		query.append(", TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD')||'000000' AS FILE_DT" ).append("\n"); 
		query.append("FROM PRI_RP_HDR HD" ).append("\n"); 
		query.append(", PRI_RP_MN MN" ).append("\n"); 
		query.append(", PRI_RP_SCP_MN SP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   SP.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND   SP.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}