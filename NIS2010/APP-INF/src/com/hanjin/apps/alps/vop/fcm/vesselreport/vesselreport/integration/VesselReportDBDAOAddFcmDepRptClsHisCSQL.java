/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOAddFcmDepRptClsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.06.13 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOAddFcmDepRptClsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * history 추가
	  * </pre>
	  */
	public VesselReportDBDAOAddFcmDepRptClsHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOAddFcmDepRptClsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_DEP_RPT_CLS_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    DEP_RPT_CLS_SEQ ," ).append("\n"); 
		query.append("    VSL_CD ," ).append("\n"); 
		query.append("    SKD_VOY_NO ," ).append("\n"); 
		query.append("    SKD_DIR_CD ," ).append("\n"); 
		query.append("    DEP_PORT_CD ," ).append("\n"); 
		query.append("    CLPT_IND_SEQ ," ).append("\n"); 
		query.append("    DEP_RPT_ERR_TP_CD ," ).append("\n"); 
		query.append("    OLD_VSL_CD ," ).append("\n"); 
		query.append("    OLD_SKD_VOY_NO ," ).append("\n"); 
		query.append("    OLD_SKD_DIR_CD ," ).append("\n"); 
		query.append("    OLD_DEP_PORT_CD ," ).append("\n"); 
		query.append("    OLD_CLPT_IND_SEQ ," ).append("\n"); 
		query.append("    CRE_USR_ID ," ).append("\n"); 
		query.append("    CRE_DT ," ).append("\n"); 
		query.append("    UPD_USR_ID ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    FCM_DEP_RPT_CLS_SEQ.NEXTVAL ," ).append("\n"); 
		query.append("    @[vsl_cd] ," ).append("\n"); 
		query.append("    @[skd_voy_no] ," ).append("\n"); 
		query.append("    @[skd_dir_cd] ," ).append("\n"); 
		query.append("    @[dep_port_cd] ," ).append("\n"); 
		query.append("    @[clpt_ind_seq] ," ).append("\n"); 
		query.append("	'PM'," ).append("\n"); 
		query.append("    @[old_vsl_cd] ," ).append("\n"); 
		query.append("    @[old_skd_voy_no] ," ).append("\n"); 
		query.append("    @[old_skd_dir_cd] ," ).append("\n"); 
		query.append("    @[old_dep_port_cd] ," ).append("\n"); 
		query.append("    @[old_clpt_ind_seq] ," ).append("\n"); 
		query.append("    @[cre_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE ," ).append("\n"); 
		query.append("    @[upd_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}