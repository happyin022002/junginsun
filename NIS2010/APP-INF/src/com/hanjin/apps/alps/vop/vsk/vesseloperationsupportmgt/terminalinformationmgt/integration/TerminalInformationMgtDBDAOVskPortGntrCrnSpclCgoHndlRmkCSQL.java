/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlRmkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlRmkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/Crane에 대한 Special Cargo Handling Remark 정보 저장처리한다.
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlRmkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_hndl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlRmkCSQL").append("\n"); 
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
		query.append("MERGE INTO  VSK_PORT_GNTR_HNDL_INFO X" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("            (SELECT  SUBSTR(@[yd_cd],1,5)	AS LOC_CD" ).append("\n"); 
		query.append("             FROM                   		DUAL" ).append("\n"); 
		query.append("            ) Y" ).append("\n"); 
		query.append("ON          (X.LOC_CD                		= Y.LOC_CD)" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT     (LOC_CD, SPCL_CGO_HNDL_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES     (" ).append("\n"); 
		query.append("               SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("             , @[spcl_cgo_hndl_rmk]" ).append("\n"); 
		query.append("             , @[upd_usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[upd_usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN               " ).append("\n"); 
		query.append("UPDATE       " ).append("\n"); 
		query.append("SET        	SPCL_CGO_HNDL_RMK	= @[spcl_cgo_hndl_rmk]" ).append("\n"); 
		query.append("       	,  	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	UPD_DT				= SYSDATE	    " ).append("\n"); 

	}
}