/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOmergePkupWdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.07.02 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmergePkupWdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Notice Form안에 기입 될 문구정보를 생성한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOmergePkupWdCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eclz_obl_cpy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("btm_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO BKG_PKUP_WD A" ).append("\n"); 
		query.append("USING (SELECT PKUP_NTC_SEQ," ).append("\n"); 
		query.append("@[pkup_ntc_fom_cd] AS PKUP_NTC_FOM_CD," ).append("\n"); 
		query.append("@[eclz_obl_cpy_flg] AS ECLZ_OBL_CPY_FLG," ).append("\n"); 
		query.append("@[btm_rmk] AS BTM_RMK," ).append("\n"); 
		query.append("@[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC_STUP" ).append("\n"); 
		query.append("WHERE PKUP_NTC_SND_TP_CD = @[pkup_ntc_snd_tp_cd]" ).append("\n"); 
		query.append("AND   OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   DEL_CD = DECODE(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd])) B" ).append("\n"); 
		query.append("ON (A.PKUP_NTC_SEQ = B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append("AND A.PKUP_NTC_FOM_CD = B.PKUP_NTC_FOM_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("ECLZ_OBL_CPY_FLG = B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	BTM_RMK = B.BTM_RMK" ).append("\n"); 
		query.append(",	UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT VALUES(" ).append("\n"); 
		query.append("B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	B.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	B.BTM_RMK" ).append("\n"); 
		query.append(",	B.CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	B.UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmergePkupWdCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}