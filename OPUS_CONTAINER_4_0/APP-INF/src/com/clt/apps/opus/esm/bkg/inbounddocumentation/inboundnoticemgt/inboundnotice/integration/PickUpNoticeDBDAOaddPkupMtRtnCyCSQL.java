/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupMtRtnCyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupMtRtnCyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupMtRtnCyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_sav_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_cntr_tp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_sav_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupMtRtnCyCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_CNTR_RTN_YD" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	RTN_YD_SEQ" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CD" ).append("\n"); 
		query.append(",	MCNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",	RTN_YD_SAV_OFC_CD" ).append("\n"); 
		query.append(",	RTN_YD_SAV_USR_ID" ).append("\n"); 
		query.append(",	RTN_YD_SAV_DT" ).append("\n"); 
		query.append(",	PKUP_YD_ID" ).append("\n"); 
		query.append(",	PKUP_CNTR_TP_ID" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	DELT_USR_ID" ).append("\n"); 
		query.append(",	DELT_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	RAIL_DEST_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	NVL((SELECT /*+INDEX_DESC(X XPKBKG_PKUP_CNTR_RTN_YD) */ RTN_YD_SEQ" ).append("\n"); 
		query.append("         FROM   BKG_PKUP_CNTR_RTN_YD X" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1),0)+1" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[fnl_dest_cd]" ).append("\n"); 
		query.append(",	@[mcntr_rtn_yd_cd]" ).append("\n"); 
		query.append(",	@[rtn_yd_sav_ofc_cd]" ).append("\n"); 
		query.append(",	@[rtn_yd_sav_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[pkup_yd_id]" ).append("\n"); 
		query.append(",	@[pkup_cntr_tp_id]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}