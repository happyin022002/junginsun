/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOOpfTdrAtchFileVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.30
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2011.06.30 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOOpfTdrAtchFileVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TDR R/H 건별 File Attached 건을 조회한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOOpfTdrAtchFileVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hndl_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOOpfTdrAtchFileVORSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,VPS_PORT_CD" ).append("\n"); 
		query.append("        ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("        ,CNTR_NO" ).append("\n"); 
		query.append("        ,ATCH_FILE_SEQ" ).append("\n"); 
		query.append("        ,FILE_NM" ).append("\n"); 
		query.append("        ,FILE_SAV_ID" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS' ) AS UPD_DT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI:SS' ) AS CRE_DT" ).append("\n"); 
		query.append("        , '0' AS FILE_DOWNLOAD " ).append("\n"); 
		query.append("FROM    OPF_TDR_ATCH_FILE" ).append("\n"); 
		query.append("WHERE   VSL_CD              = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO          = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD          = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     VPS_PORT_CD         = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ        = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND     CNTR_HNDL_KND_CD    = @[cntr_hndl_knd_cd]" ).append("\n"); 
		query.append("AND     CNTR_NO             = @[cntr_no]" ).append("\n"); 

	}
}