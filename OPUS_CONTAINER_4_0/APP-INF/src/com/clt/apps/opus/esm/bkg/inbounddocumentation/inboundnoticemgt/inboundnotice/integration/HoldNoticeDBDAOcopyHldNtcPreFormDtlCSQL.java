/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOcopyHldNtcPreFormDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.25 
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

public class HoldNoticeDBDAOcopyHldNtcPreFormDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 입력된 Pre-Hold Notice Setup Detail 정보를 Copy한다.
	  * </pre>
	  */
	public HoldNoticeDBDAOcopyHldNtcPreFormDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOcopyHldNtcPreFormDtlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_HLD_WD_DTL A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("USING (SELECT @[ofc_cd]         AS OFC_CD" ).append("\n"); 
		query.append(",@[pod_cd]         AS POD_CD" ).append("\n"); 
		query.append(",HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",HLD_NTC_FOM_CD" ).append("\n"); 
		query.append(",HLD_RMK" ).append("\n"); 
		query.append(",@[cre_usr_id]     AS CRE_USR_ID" ).append("\n"); 
		query.append(",@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_HLD_WD_DTL" ).append("\n"); 
		query.append("WHERE  OFC_CD        = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND    POD_CD        = @[fm_pod_cd]" ).append("\n"); 
		query.append("AND    HLD_NTC_TP_CD = @[hld_ntc_tp_cd]) B" ).append("\n"); 
		query.append("ON (A.OFC_CD         = B.OFC_CD" ).append("\n"); 
		query.append("AND A.POD_CD         = B.POD_CD" ).append("\n"); 
		query.append("AND A.HLD_NTC_TP_CD  = B.HLD_NTC_TP_CD" ).append("\n"); 
		query.append("AND A.HLD_NTC_FOM_CD = B.HLD_NTC_FOM_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("HLD_RMK    = B.HLD_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID = B.CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",	HLD_NTC_FOM_CD" ).append("\n"); 
		query.append(",	HLD_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("B.OFC_CD" ).append("\n"); 
		query.append(",	B.POD_CD" ).append("\n"); 
		query.append(",	B.HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",	B.HLD_NTC_FOM_CD" ).append("\n"); 
		query.append(",	B.HLD_RMK" ).append("\n"); 
		query.append(",	B.CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	B.UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}