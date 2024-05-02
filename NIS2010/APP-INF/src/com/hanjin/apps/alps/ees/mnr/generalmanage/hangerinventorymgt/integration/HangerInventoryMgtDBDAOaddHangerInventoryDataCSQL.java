/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.01.11 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HangerInventoryMgtDBDAOaddHangerInventoryData
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_invt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lost_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_dmg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pur_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("invt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_HNGR_INVT(" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append(",MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",HNGR_INVT_VER_NO" ).append("\n"); 
		query.append(",HNGR_INVT_LST_VER_FLG" ).append("\n"); 
		query.append(",INVT_QTY" ).append("\n"); 
		query.append(",MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",PUR_QTY" ).append("\n"); 
		query.append(",CSM_QTY" ).append("\n"); 
		query.append(",RCVR_QTY" ).append("\n"); 
		query.append(",ACT_INVT_QTY" ).append("\n"); 
		query.append(",MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",INVT_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[ofc_cd]" ).append("\n"); 
		query.append(", 	@[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(A.HNGR_INVT_VER_NO), 0) + 1" ).append("\n"); 
		query.append("FROM MNR_HNGR_INVT A" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND A.MNR_HNGR_BAR_TP_CD = @[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",	@[invt_qty]" ).append("\n"); 
		query.append(",	@[mnr_hngr_dmg_qty]" ).append("\n"); 
		query.append(",	@[pur_qty]" ).append("\n"); 
		query.append(",	@[csm_qty]" ).append("\n"); 
		query.append(",	@[rcvr_qty]" ).append("\n"); 
		query.append(",	@[act_invt_qty]" ).append("\n"); 
		query.append(",   @[mnr_lost_hngr_qty]" ).append("\n"); 
		query.append(",   @[mnr_disp_hngr_qty]" ).append("\n"); 
		query.append(",   DECODE(@[invt_rmk],'By Work Order'," ).append("\n"); 
		query.append("(SELECT DISTINCT" ).append("\n"); 
		query.append("'By Work Order [' || @[eq_no] || ' : '|| B.VNDR_LGL_ENG_NM || '(' || A.VNDR_SEQ ||')]'" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A, MDM_VENDOR B, MNR_ORD_DTL E" ).append("\n"); 
		query.append("WHERE A.MNR_ORD_OFC_CTY_CD = E.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.MNR_ORD_SEQ = E.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND A.MNR_WO_TP_CD LIKE '%'||'EXT'||'%'" ).append("\n"); 
		query.append("and E.EQ_NO=@[eq_no]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.COST_OFC_CD =@[ofc_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("),@[invt_rmk])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}