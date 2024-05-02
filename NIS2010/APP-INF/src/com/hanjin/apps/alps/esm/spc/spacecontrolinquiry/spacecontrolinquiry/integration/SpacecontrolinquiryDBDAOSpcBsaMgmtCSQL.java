/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSpcBsaMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2011.03.15 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSpcBsaMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSpcBsaMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSpcBsaMgmtCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_BSA_MGMT(" ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("SUB_TRD_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("BSA_SEQ," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("BSA_CAPA," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[trd_cd]," ).append("\n"); 
		query.append("@[sub_trd_cd]," ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[skd_voy_no]," ).append("\n"); 
		query.append("@[skd_dir_cd]," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("    case when a.maxCnt = 0 then ( SELECT nvl(max(BSA_SEQ)+1,1) FROM SPC_BSA_MGMT" ).append("\n"); 
		query.append(" 								  WHERE TRD_CD	= @[trd_cd]   " ).append("\n"); 
		query.append("								    AND SUB_TRD_CD	= @[sub_trd_cd]" ).append("\n"); 
		query.append("									AND	VSL_CD		= @[vsl_cd] " ).append("\n"); 
		query.append("								    AND	SKD_DIR_CD	= @[skd_dir_cd] )" ).append("\n"); 
		query.append("    when a.maxCnt <> 0 then maxCnt" ).append("\n"); 
		query.append("    end bsa_seq" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(   select nvl(max(BSA_SEQ),0) maxCnt" ).append("\n"); 
		query.append("    FROM SPC_BSA_MGMT" ).append("\n"); 
		query.append(" 	WHERE TRD_CD	= @[trd_cd]   " ).append("\n"); 
		query.append("	AND	SUB_TRD_CD	= @[sub_trd_cd]" ).append("\n"); 
		query.append("	AND	VSL_CD		= @[vsl_cd] " ).append("\n"); 
		query.append("    AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND	SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append(") a ) ," ).append("\n"); 
		query.append("@[crr_cd]," ).append("\n"); 
		query.append("@[bsa_capa]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}