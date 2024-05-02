/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortBrthWdoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.14 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortBrthWdoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortBrthWdoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etb_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortBrthWdoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_PORT_BRTH_WDO (" ).append("\n"); 
		query.append("YD_CD" ).append("\n"); 
		query.append(",	REF_SLAN_NM" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	ETB_DY_CD" ).append("\n"); 
		query.append(",	ETB_TM_HRMNT" ).append("\n"); 
		query.append(",	ETD_DY_CD" ).append("\n"); 
		query.append(",	ETD_TM_HRMNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BRTH_SEQ" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[yd_cd]" ).append("\n"); 
		query.append(",	@[ref_slan_nm]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[crr_cd]" ).append("\n"); 
		query.append(",	@[loc_cd]" ).append("\n"); 
		query.append(",	@[etb_dy_cd]" ).append("\n"); 
		query.append(",	@[etb_tm_hrmnt]" ).append("\n"); 
		query.append(",	@[etd_dy_cd]" ).append("\n"); 
		query.append(",	@[etd_tm_hrmnt]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(BRTH_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM   VSK_PORT_BRTH_WDO" ).append("\n"); 
		query.append("WHERE	YD_CD = @[yd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}