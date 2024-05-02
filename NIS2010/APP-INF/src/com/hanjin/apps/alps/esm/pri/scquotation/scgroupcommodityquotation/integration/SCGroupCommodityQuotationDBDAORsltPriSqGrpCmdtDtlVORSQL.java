/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityQuotationDBDAORsltPriSqGrpCmdtDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityQuotationDBDAORsltPriSqGrpCmdtDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCGroupCommodityQuotationDBDAORsltPriSqGrpCmdtDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityQuotationDBDAORsltPriSqGrpCmdtDtlVORSQL").append("\n"); 
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
		query.append("A.QTTN_NO" ).append("\n"); 
		query.append(",	A.QTTN_VER_NO" ).append("\n"); 
		query.append(",	A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",	A.GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",	A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",	A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	NVL(B.CMDT_NM,'') AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",	A.SRC_INFO_CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02200'" ).append("\n"); 
		query.append("AND   INTG_CD_VAL_CTNT = A.SRC_INFO_CD) AS SRC_INFO_NM" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_CMDT_DTL A" ).append("\n"); 
		query.append(",	 MDM_COMMODITY B" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	A.GRP_CMDT_SEQ = @[grp_cmdt_seq]" ).append("\n"); 
		query.append("AND	A.PRC_CMDT_DEF_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.PRC_CMDT_DEF_CD, B.CMDT_NM" ).append("\n"); 

	}
}