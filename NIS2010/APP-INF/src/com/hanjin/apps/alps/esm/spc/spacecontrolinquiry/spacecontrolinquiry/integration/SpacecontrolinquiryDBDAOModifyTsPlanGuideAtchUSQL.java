/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOModifyTsPlanGuideAtchUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOModifyTsPlanGuideAtchUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide Attach]을 [업데이트]합니다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOModifyTsPlanGuideAtchUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOModifyTsPlanGuideAtchUSQL").append("\n"); 
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
		query.append("UPDATE (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		 STO.FILE_NM AS IMG_FILE_NM" ).append("\n"); 
		query.append("		,STO.FILE_PATH_RMK AS IMG_FILE_PATH" ).append("\n"); 
		query.append("		,UPLD.FILE_UPLD_NM AS UPLD_FILE_NM" ).append("\n"); 
		query.append("		,UPLD.FILE_PATH_URL AS UPLD_FILE_PATH" ).append("\n"); 
		query.append("	FROM SPC_TS_PLN_GID_FILE_STO STO, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("	WHERE STO.FILE_SAV_ID     = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("	  AND STO.REP_TRD_CD      = @[rep_trd_cd]" ).append("\n"); 
		query.append("      AND STO.REP_SUB_TRD_CD  = @[rep_sub_trd_cd]" ).append("\n"); 
		query.append("      AND STO.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("      AND STO.VVD_CD          = @[vvd_cd]" ).append("\n"); 
		query.append("      AND STO.IRR_PORT_CD     = @[irr_port_cd]" ).append("\n"); 
		query.append("      AND STO.IRR_YD_CD       = @[irr_yd_cd]" ).append("\n"); 
		query.append("	  AND STO.PLN_SEQ         = @[pln_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("IMG_FILE_NM = UPLD_FILE_NM," ).append("\n"); 
		query.append("IMG_FILE_PATH = UPLD_FILE_PATH" ).append("\n"); 

	}
}