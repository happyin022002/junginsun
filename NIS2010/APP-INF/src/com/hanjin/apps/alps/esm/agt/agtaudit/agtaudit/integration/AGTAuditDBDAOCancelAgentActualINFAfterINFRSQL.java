/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CancelAgentActualINFAfterINF
	  * </pre>
	  */
	public AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCancelAgentActualINFAfterINFRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.CUR_AC_SEQ - B.MAX_AC_SEQ < 0" ).append("\n"); 
		query.append("AND @[ac_seq] = A.CUR_AC_SEQ" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS AFTER_INTERFACED" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL (MAX (AC_SEQ), 0) AS CUR_AC_SEQ" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD         = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD          = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND CSR_NO            = @[csr_no]" ).append("\n"); 
		query.append("AND CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD  = 'IF'" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL (MAX (AC_SEQ), 0) AS MAX_AC_SEQ" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD         = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD          = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND CSR_NO           != @[csr_no]" ).append("\n"); 
		query.append("AND CSR_NO           is not null" ).append("\n"); 
		query.append("AND AC_IF_DT         is not null" ).append("\n"); 
		query.append("AND CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD  = 'IF'" ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}