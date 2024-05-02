/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNtcStupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.24 박미옥
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

public class PickUpNoticeDBDAOsearchPkupNtcStupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PickNotice Form Setting정보중 상단 기본 Option 정보를 조회한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNtcStupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNtcStupRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	PKUP_NTC_SND_TP_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	decode(DEL_CD,'*','ALL',DEL_CD) AS DEL_CD" ).append("\n"); 
		query.append(",	AUTO_NTC_FLG" ).append("\n"); 
		query.append(",	EACH_FOC_NTC_FLG" ).append("\n"); 
		query.append(",	TRKR_NTC_FLG" ).append("\n"); 
		query.append(",	ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	FOC_CLR_RMK_STUP_FLG" ).append("\n"); 
		query.append(",	HD_TIT_CTNT" ).append("\n"); 
		query.append("--,	CRE_USR_ID" ).append("\n"); 
		query.append("--,	CRE_DT" ).append("\n"); 
		query.append("--,	UPD_USR_ID" ).append("\n"); 
		query.append("--,	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC_STUP" ).append("\n"); 
		query.append("WHERE PKUP_NTC_SND_TP_CD = @[ntc_snd_tp_cd]" ).append("\n"); 
		query.append("AND	  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   DEL_CD = decode(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd])" ).append("\n"); 

	}
}