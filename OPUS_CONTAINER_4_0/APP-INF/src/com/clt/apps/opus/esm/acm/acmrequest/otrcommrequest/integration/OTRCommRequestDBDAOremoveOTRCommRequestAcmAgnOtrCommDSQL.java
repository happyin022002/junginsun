/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOremoveOTRCommRequestAcmAgnOtrCommDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOremoveOTRCommRequestAcmAgnOtrCommDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * removeOTRCommRequestAcmAgnOtrComm
	  * </pre>
	  */
	public OTRCommRequestDBDAOremoveOTRCommRequestAcmAgnOtrCommDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration").append("\n");
		query.append("FileName : OTRCommRequestDBDAOremoveOTRCommRequestAcmAgnOtrCommDSQL").append("\n");
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
		query.append("DELETE" ).append("\n");
		query.append("      FROM ACM_AGN_OTR_COMM" ).append("\n");
		query.append("     WHERE OTR_COMM_NO  = @[otr_comm_no]" ).append("\n");
		query.append("       AND AR_OFC_CD    = @[ar_ofc_cd]" ).append("\n");
		query.append("       AND AGN_CD       = @[agn_cd]" ).append("\n");
		query.append("       AND IO_BND_CD    = @[io_bnd_cd]" ).append("\n");
		query.append("       AND AC_TP_CD     = @[ac_tp_cd]" ).append("\n");
		query.append("       AND AC_SEQ       = @[ac_seq]" ).append("\n");
		query.append("       AND COMM_YRMON   = REPLACE(@[comm_yrmon], '-', '')" ).append("\n");
		query.append("       AND APRO_DT   IS NULL" ).append("\n");

	}
}