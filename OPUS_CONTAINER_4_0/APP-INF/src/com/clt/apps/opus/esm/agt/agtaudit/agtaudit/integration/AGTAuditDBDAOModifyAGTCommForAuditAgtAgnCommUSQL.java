/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommForAuditAgtAgnComm
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chf",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("comm1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cross",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("( ACT_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("C.AC_TP_AMT           AS ACT_COMM_AMT," ).append("\n"); 
		query.append("C.AC_TP_AMT           AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("C.AC_TP_AMT           AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("C.AC_TP_AMT           AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'RM'                  AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("'REQUEST MODIFIED!'   AS COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("@[upd_usr_id]         AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE               AS UPD_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM           B," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("CASE ROWNUM" ).append("\n"); 
		query.append("WHEN 1 THEN 'G'" ).append("\n"); 
		query.append("WHEN 2 THEN 'N'" ).append("\n"); 
		query.append("WHEN 3 THEN 'K'" ).append("\n"); 
		query.append("WHEN 4 THEN 'H'" ).append("\n"); 
		query.append("WHEN 5 THEN 'S'" ).append("\n"); 
		query.append("WHEN 6 THEN 'R'" ).append("\n"); 
		query.append("WHEN 7 THEN 'O'" ).append("\n"); 
		query.append("WHEN 8 THEN 'C'" ).append("\n"); 
		query.append("WHEN 9 THEN 'D'" ).append("\n"); 
		query.append("END            AS AC_TP_CD," ).append("\n"); 
		query.append("CASE ROWNUM" ).append("\n"); 
		query.append("WHEN 1 THEN ROUND (NVL (@[comm1], 0), 2)" ).append("\n"); 
		query.append("WHEN 2 THEN ROUND (NVL (@[comm2], 0), 2)" ).append("\n"); 
		query.append("WHEN 3 THEN ROUND (NVL (@[brkg],  0), 2)" ).append("\n"); 
		query.append("WHEN 4 THEN ROUND (NVL (@[chf],   0), 2)" ).append("\n"); 
		query.append("WHEN 5 THEN ROUND (NVL (@[ts],    0), 2)" ).append("\n"); 
		query.append("WHEN 6 THEN ROUND (NVL (@[tr],    0), 2)" ).append("\n"); 
		query.append("WHEN 7 THEN ROUND (NVL (@[soc],   0), 2)" ).append("\n"); 
		query.append("WHEN 8 THEN ROUND (NVL (@[cross], 0), 2)" ).append("\n"); 
		query.append("WHEN 9 THEN ROUND (NVL (@[doc],   0), 2)" ).append("\n"); 
		query.append("END            AS AC_TP_AMT" ).append("\n"); 
		query.append("FROM ALL_ARGUMENTS" ).append("\n"); 
		query.append("WHERE ROWNUM      < 10" ).append("\n"); 
		query.append(")                        C" ).append("\n"); 
		query.append("WHERE B.BKG_NO               = A.BKG_NO" ).append("\n"); 
		query.append("AND B.AGN_CD               = A.AGN_CD" ).append("\n"); 
		query.append("AND B.IO_BND_CD            = A.IO_BND_CD" ).append("\n"); 
		query.append("AND B.AC_TP_CD             = A.AC_TP_CD" ).append("\n"); 
		query.append("AND B.AC_SEQ               = A.AC_SEQ" ).append("\n"); 
		query.append("AND B.COMM_PROC_STS_CD     = A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("AND B.AC_TP_CD             = C.AC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append("AND A.AGN_CD               = @[agn_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD            = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND A.AC_TP_CD            <> 'T'" ).append("\n"); 
		query.append("AND A.AC_SEQ               = @[ac_seq]" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'RS','RM'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}