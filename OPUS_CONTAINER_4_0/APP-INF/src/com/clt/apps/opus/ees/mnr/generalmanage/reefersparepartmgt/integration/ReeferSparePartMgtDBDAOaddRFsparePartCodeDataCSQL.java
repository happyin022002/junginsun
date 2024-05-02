/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOaddRFsparePartCodeDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.18 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOaddRFsparePartCodeDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOaddRFsparePartCodeDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_spl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_ut_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spr_prt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_tp_flg3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spr_prt_tp_flg1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_tp_flg2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOaddRFsparePartCodeDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RF_SPR_PRT_CD(" ).append("\n"); 
		query.append("         SPR_PRT_NO" ).append("\n"); 
		query.append("        ,SPR_PRT_SPL_TP_CD" ).append("\n"); 
		query.append("        ,SPR_PRT_TP_FLG1" ).append("\n"); 
		query.append("        ,SPR_PRT_TP_FLG2" ).append("\n"); 
		query.append("        ,SPR_PRT_TP_FLG3" ).append("\n"); 
		query.append("        ,SPR_UT_TP_NM" ).append("\n"); 
		query.append("        ,SPR_PRT_NM" ).append("\n"); 
		query.append("        ,SPR_PRT_QTY" ).append("\n"); 
		query.append("        ,SPR_PRT_RMK" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("            @[spr_prt_no]" ).append("\n"); 
		query.append("           ,@[spr_prt_spl_tp_cd]" ).append("\n"); 
		query.append("           ,decode(@[spr_prt_tp_flg1],'0','N','Y')" ).append("\n"); 
		query.append("           ,decode(@[spr_prt_tp_flg2],'0','N','Y')" ).append("\n"); 
		query.append("           ,decode(@[spr_prt_tp_flg3],'0','N','Y')" ).append("\n"); 
		query.append("           ,@[spr_ut_tp_nm]" ).append("\n"); 
		query.append("           ,@[spr_prt_nm]" ).append("\n"); 
		query.append("           ,@[spr_prt_qty]" ).append("\n"); 
		query.append("           ,@[spr_prt_rmk]" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}