/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOModifyTsPlanGuideMainlListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
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

public class SpacecontrolinquiryDBDAOModifyTsPlanGuideMainlListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide Main]을 [UPDATE]합니다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOModifyTsPlanGuideMainlListUSQL(){
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
		params.put("skd_cng_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ts_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_cng_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("irr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOModifyTsPlanGuideMainlListUSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_TS_PLN_GID_MN MN " ).append("\n"); 
		query.append("    USING ( " ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                 @[rep_trd_cd]     REP_TRD_CD" ).append("\n"); 
		query.append("                ,@[rep_sub_trd_cd] REP_SUB_TRD_CD                 " ).append("\n"); 
		query.append("                ,@[rlane_cd]       RLANE_CD           " ).append("\n"); 
		query.append("                ,@[vvd_cd]         VVD_CD         " ).append("\n"); 
		query.append("                ,@[irr_port_cd]    IRR_PORT_CD        " ).append("\n"); 
		query.append("                ,@[irr_yd_cd]      IRR_YD_CD    " ).append("\n"); 
		query.append("           FROM DUAL " ).append("\n"); 
		query.append("           ) TMP" ).append("\n"); 
		query.append("          ON (" ).append("\n"); 
		query.append("                  MN.REP_TRD_CD     = TMP.REP_TRD_CD" ).append("\n"); 
		query.append("              AND MN.REP_SUB_TRD_CD = TMP.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("              AND MN.RLANE_CD       = TMP.RLANE_CD" ).append("\n"); 
		query.append("              AND MN.VVD_CD         = TMP.VVD_CD" ).append("\n"); 
		query.append("              AND MN.IRR_PORT_CD    = TMP.IRR_PORT_CD" ).append("\n"); 
		query.append("              AND MN.IRR_YD_CD      = TMP.IRR_YD_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           WHEN MATCHED THEN" ).append("\n"); 
		query.append("                UPDATE SET MN.USR_RMK     = @[usr_rmk]" ).append("\n"); 
		query.append("                         , MN.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("                         , MN.UPD_DT      = sysdate " ).append("\n"); 
		query.append("           WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("                INSERT " ).append("\n"); 
		query.append("                          ( " ).append("\n"); 
		query.append("                            REP_TRD_CD" ).append("\n"); 
		query.append("                          , REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                          , RLANE_CD" ).append("\n"); 
		query.append("                          , VVD_CD" ).append("\n"); 
		query.append("                          , IRR_PORT_CD" ).append("\n"); 
		query.append("                          , IRR_YD_CD" ).append("\n"); 
		query.append("                          , DIR_CD" ).append("\n"); 
		query.append("                          , CRR_CD" ).append("\n"); 
		query.append("                          , PORT_SKP_TP_CD " ).append("\n"); 
		query.append("                          , SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                          , PHS_IO_RSN_CD" ).append("\n"); 
		query.append("                          , PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("                          , TS_RMK" ).append("\n"); 
		query.append("                          , USR_RMK" ).append("\n"); 
		query.append("                          , CRE_USR_ID" ).append("\n"); 
		query.append("                          , CRE_DT" ).append("\n"); 
		query.append("                          , UPD_USR_ID" ).append("\n"); 
		query.append("                          , UPD_DT " ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                VALUES ( " ).append("\n"); 
		query.append("                           @[rep_trd_cd]" ).append("\n"); 
		query.append("                          ,@[rep_sub_trd_cd]" ).append("\n"); 
		query.append("                          ,@[rlane_cd]" ).append("\n"); 
		query.append("                          ,@[vvd_cd]" ).append("\n"); 
		query.append("                          ,@[irr_port_cd]" ).append("\n"); 
		query.append("                          ,@[irr_yd_cd]" ).append("\n"); 
		query.append("                          ,@[dir_cd]" ).append("\n"); 
		query.append("                          ,@[crr_cd]" ).append("\n"); 
		query.append("                          ,NVL(@[port_skp_tp_cd],'X')" ).append("\n"); 
		query.append("                          ,@[skd_cng_sts_cd]" ).append("\n"); 
		query.append("                          ,DECODE(@[skd_cng_sts_cd], 'O', @[skd_cng_rsn_cd])" ).append("\n"); 
		query.append("                          ,DECODE(@[skd_cng_sts_cd], 'S', @[skd_cng_rsn_cd])" ).append("\n"); 
		query.append("                          ,@[ts_rmk]" ).append("\n"); 
		query.append("                          ,@[usr_rmk]" ).append("\n"); 
		query.append("                          ,'AUTO'" ).append("\n"); 
		query.append("                          ,sysdate" ).append("\n"); 
		query.append("                          ,@[upd_usr_id]" ).append("\n"); 
		query.append("                          ,sysdate " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("UPDATE SPC_TS_PLN_GID_MN" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("      USR_RMK            = [usr_rmk]" ).append("\n"); 
		query.append("    , UPD_USR_ID         = [upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT             = sysdate " ).append("\n"); 
		query.append("WHERE REP_TRD_CD     = [rep_trd_cd]" ).append("\n"); 
		query.append("AND   REP_SUB_TRD_CD = [rep_sub_trd_cd]" ).append("\n"); 
		query.append("AND   RLANE_CD       = [rlane_cd]" ).append("\n"); 
		query.append("AND   VVD_CD         = [vvd_cd]" ).append("\n"); 
		query.append("AND   IRR_PORT_CD    = [irr_port_cd]" ).append("\n"); 
		query.append("AND   IRR_YD_CD      = [irr_yd_cd]" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}