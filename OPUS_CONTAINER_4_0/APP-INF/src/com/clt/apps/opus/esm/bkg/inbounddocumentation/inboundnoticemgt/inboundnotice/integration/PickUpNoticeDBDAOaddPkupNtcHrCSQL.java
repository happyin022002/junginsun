/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcHrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.01 
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

public class PickUpNoticeDBDAOaddPkupNtcHrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Event발생시 Notice 발송 시간에 대한 Setting 정보를 생성한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcHrCSQL(){
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
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_bse_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_PKUP_NTC_HR A" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	NTC_BSE_HRS" ).append("\n"); 
		query.append(",	NTC_COND_CD" ).append("\n"); 
		query.append(",	MVMT_STS_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",      @[pkup_ntc_fom_cd] AS PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",      NVL((SELECT /*+INDEX_DESC(T XPKBKG_PKUP_NTC_HR) */ NTC_SEQ" ).append("\n"); 
		query.append("FROM  BKG_PKUP_NTC_HR T" ).append("\n"); 
		query.append("WHERE T.PKUP_NTC_SEQ    = S.PKUP_NTC_SEQ" ).append("\n"); 
		query.append("AND   T.PKUP_NTC_FOM_CD = @[pkup_ntc_fom_cd]" ).append("\n"); 
		query.append("AND   ROWNUM            =1),0)+1 AS NTC_SEQ" ).append("\n"); 
		query.append(",	@[ntc_bse_hrs] AS NTC_BSE_HRS" ).append("\n"); 
		query.append(",	@[ntc_cond_cd] AS NTC_COND_CD" ).append("\n"); 
		query.append(",	@[mvmt_sts_cd] AS MVMT_STS_CD" ).append("\n"); 
		query.append(",	@[cre_usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE        AS CRE_DT" ).append("\n"); 
		query.append(",	@[upd_usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE        AS UPD_DT" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP S" ).append("\n"); 
		query.append("WHERE  PKUP_NTC_SND_TP_CD = @[pkup_ntc_snd_tp_cd]" ).append("\n"); 
		query.append("AND    OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   DEL_CD = decode(nvl(@[del_cd],'ALL'),'ALL','*',@[del_cd])" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcHrCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}