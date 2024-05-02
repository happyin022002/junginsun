/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOReqOTRCommRequestListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.04
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

public class OTRCommRequestDBDAOReqOTRCommRequestListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ReqOTRCommRequestList
	  * </pre>
	  */
	public OTRCommRequestDBDAOReqOTRCommRequestListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OTRCommRequestDBDAOReqOTRCommRequestListUSQL").append("\n");
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
		query.append("UPDATE ACM_AGN_OTR_COMM" ).append("\n");
		query.append("       SET" ).append("\n");
		query.append("         (  AC_STS_CD," ).append("\n");
		query.append("            RQST_USR_ID," ).append("\n");
		query.append("            RQST_DT," ).append("\n");
		query.append("            RQST_GDT," ).append("\n");
		query.append("            UPD_USR_ID," ).append("\n");
		query.append("            UPD_DT" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("         =" ).append("\n");
		query.append("         (     SELECT" ).append("\n");
		query.append("                     'RS'                                                 AS AC_STS_CD," ).append("\n");
		query.append("                     @[usr_id]                                            AS RQST_USR_ID," ).append("\n");
		query.append("                     SYSDATE                                              AS RQST_DT," ).append("\n");
		query.append("                     GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT')  AS RQST_GDT," ).append("\n");
		query.append("                     @[usr_id]                                            AS UPD_USR_ID," ).append("\n");
		query.append("                     SYSDATE                                              AS UPD_DT" ).append("\n");
		query.append("                FROM MDM_ORGANIZATION" ).append("\n");
		query.append("               WHERE OFC_CD             = @[agn_cd]" ).append("\n");
		query.append("                 AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("     WHERE OTR_COMM_NO  = @[otr_comm_no]" ).append("\n");
		query.append("       AND AGN_CD       = @[agn_cd]" ).append("\n");
		query.append("       AND IO_BND_CD    = @[io_bnd_cd]" ).append("\n");
		query.append("       AND AC_TP_CD     = @[ac_tp_cd]" ).append("\n");
		query.append("       AND AC_SEQ       = @[ac_seq]" ).append("\n");
		query.append("       AND AC_STS_CD" ).append("\n");
		query.append("        IN" ).append("\n");
		query.append("         ( 'CS'" ).append("\n");
		query.append("         )" ).append("\n");

	}
}