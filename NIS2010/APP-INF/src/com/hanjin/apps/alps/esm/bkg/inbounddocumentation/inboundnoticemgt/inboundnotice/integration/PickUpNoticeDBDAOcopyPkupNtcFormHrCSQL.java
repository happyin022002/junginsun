/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOcopyPkupNtcFormHrCSQL.java
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

public class PickUpNoticeDBDAOcopyPkupNtcFormHrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Event발생시 Notice 발송 시간에 대한 Setting 정보를  Copy한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOcopyPkupNtcFormHrCSQL(){
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
		query.append("FileName : PickUpNoticeDBDAOcopyPkupNtcFormHrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_NTC_HR (" ).append("\n"); 
		query.append("PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	NTC_BSE_HRS" ).append("\n"); 
		query.append(",	NTC_COND_CD" ).append("\n"); 
		query.append(",	MVMT_STS_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT)" ).append("\n"); 
		query.append("SELECT (SELECT PKUP_NTC_SEQ" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP T" ).append("\n"); 
		query.append("WHERE  PKUP_NTC_SND_TP_CD = 'A'" ).append("\n"); 
		query.append("AND    OFC_CD             = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DEL_CD             = DECODE(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd])) AS PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	T2.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	T2.NTC_SEQ" ).append("\n"); 
		query.append(",	T2.NTC_BSE_HRS" ).append("\n"); 
		query.append(",	T2.NTC_COND_CD" ).append("\n"); 
		query.append(",	T2.MVMT_STS_CD" ).append("\n"); 
		query.append(",	@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append(",	@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP T1" ).append("\n"); 
		query.append(",BKG_PKUP_NTC_HR   T2" ).append("\n"); 
		query.append("WHERE  T1.PKUP_NTC_SND_TP_CD = 'A'" ).append("\n"); 
		query.append("AND    T1.OFC_CD             = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND    T1.DEL_CD             = DECODE(nvl(@[fm_del_cd],'ALL'),'ALL','*',@[fm_del_cd])" ).append("\n"); 
		query.append("AND    T2.PKUP_NTC_SEQ       = T1.PKUP_NTC_SEQ" ).append("\n"); 

	}
}