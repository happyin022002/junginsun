/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.20 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RqCpPriRpScpGrpCmdtDtl
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration ").append("\n"); 
		query.append("FileName : RFAGroupCommodityProposalDBDAORqCpPriRpScpGrpCmdtDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_GRP_CMDT_DTL (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(", PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(", PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", SRC_INFO_CD" ).append("\n"); 
		query.append(", N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append(", 0 AS AMDT_SEQ" ).append("\n"); 
		query.append(", A.SVC_SCP_CD" ).append("\n"); 
		query.append(", DENSE_RANK() OVER(PARTITION BY C.QTTN_NO, C.QTTN_VER_NO" ).append("\n"); 
		query.append("ORDER BY C.QTTN_NO, C.QTTN_VER_NO,C.GRP_CMDT_SEQ) AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER(PARTITION BY C.QTTN_NO, C.QTTN_VER_NO, C.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("ORDER BY C.QTTN_NO, C.QTTN_VER_NO, C.GRP_CMDT_SEQ, C.GRP_CMDT_DTL_SEQ) AS GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", C.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(", C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(", 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", C.SRC_INFO_CD" ).append("\n"); 
		query.append(", 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM	PRI_RQ_MN A" ).append("\n"); 
		query.append(",	PRI_RQ_GRP_CMDT B" ).append("\n"); 
		query.append(",	PRI_RQ_GRP_CMDT_DTL C" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("AND	B.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	B.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	A.QTTN_NO = C.QTTN_NO" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = C.QTTN_VER_NO" ).append("\n"); 
		query.append("AND	B.GRP_CMDT_SEQ = C.GRP_CMDT_SEQ" ).append("\n"); 

	}
}