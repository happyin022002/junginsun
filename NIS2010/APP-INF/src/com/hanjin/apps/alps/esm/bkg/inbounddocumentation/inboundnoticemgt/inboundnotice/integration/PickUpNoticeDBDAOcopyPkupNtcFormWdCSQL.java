/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOcopyPkupNtcFormWdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.09.17 박미옥
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

public class PickUpNoticeDBDAOcopyPkupNtcFormWdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Notice Form안에 기입 될 문구정보를  Copy한다
	  * </pre>
	  */
	public PickUpNoticeDBDAOcopyPkupNtcFormWdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOcopyPkupNtcFormWdCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_PKUP_WD A" ).append("\n"); 
		query.append("USING (SELECT T1.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",NVL(T1.PKUP_NTC_FOM_CD, T2.FOM_CD) AS PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",T1.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",T1.BTM_RMK" ).append("\n"); 
		query.append(",@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT (SELECT PKUP_NTC_SEQ" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP" ).append("\n"); 
		query.append("WHERE  PKUP_NTC_SND_TP_CD = 'A'" ).append("\n"); 
		query.append("AND    OFC_CD             = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DEL_CD             = DECODE(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd])) AS PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",T2.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",T2.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",T2.BTM_RMK" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP T1" ).append("\n"); 
		query.append(",BKG_PKUP_WD       T2" ).append("\n"); 
		query.append("WHERE  T1.PKUP_NTC_SND_TP_CD = 'A'" ).append("\n"); 
		query.append("AND    T1.OFC_CD             = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND    T1.DEL_CD             = DECODE(nvl(@[fm_del_cd],'ALL'),'ALL','*',@[fm_del_cd])" ).append("\n"); 
		query.append("AND    T2.PKUP_NTC_SEQ(+)    = T1.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append(",(SELECT DECODE(LEVEL,1,'PRE','ARR') AS FOM_CD FROM DUAL CONNECT BY LEVEL<=2) T2" ).append("\n"); 
		query.append("WHERE  T1.PKUP_NTC_FOM_CD(+) = T2.FOM_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.PKUP_NTC_SEQ = B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append("AND A.PKUP_NTC_FOM_CD = B.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("ECLZ_OBL_CPY_FLG = B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",BTM_RMK          = B.BTM_RMK" ).append("\n"); 
		query.append(",UPD_USR_ID       = B.UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	BTM_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	B.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	B.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	B.BTM_RMK" ).append("\n"); 
		query.append(",	B.CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	B.UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}