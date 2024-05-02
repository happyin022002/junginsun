/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOAddStepUpDownPortBsaCapaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOAddStepUpDownPortBsaCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRR_CD에 해당 하는 값이 PORT_DWN 테이블에 없는 경우 입력함.
	  * 
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOAddStepUpDownPortBsaCapaCSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOAddStepUpDownPortBsaCapaCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_VVD_PORT_DWN (" ).append("\n"); 
		query.append("    TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("    BSA_OP_JB_CD, CRR_CD, PORT_SEQ, PORT_CD, PORT_BSA_CAPA," ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TRD_CD,RLANE_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD," ).append("\n"); 
		query.append("    BSA_OP_JB_CD,@[crr_cd], PORT_SEQ,PORT_CD,'0'," ).append("\n"); 
		query.append("    @[upd_usr_id],SYSDATE,@[upd_usr_id],SYSDATE " ).append("\n"); 
		query.append("FROM BSA_VVD_PORT_DWN" ).append("\n"); 
		query.append("WHERE trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("        AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("        AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("        AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("        AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("        AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("        AND CRR_CD = 'SML'  --고정값 / " ).append("\n"); 
		query.append("        AND NOT EXISTS (" ).append("\n"); 
		query.append("            SELECT *" ).append("\n"); 
		query.append("            FROM BSA_VVD_PORT_DWN " ).append("\n"); 
		query.append("            WHERE trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("                AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("                AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("                AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("                AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("                AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("                AND crr_cd       = @[crr_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}