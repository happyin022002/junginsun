/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupWdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15 
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

public class PickUpNoticeDBDAOsearchPkupWdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Notice Form안에 기입 될 문구정보를 조회한다.(PkupWdVO 생성)
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupWdRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupWdRSQL").append("\n"); 
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
		query.append("B.PKUP_NTC_SND_TP_CD" ).append("\n"); 
		query.append(",	B.OFC_CD" ).append("\n"); 
		query.append(",	decode(B.DEL_CD,'*','ALL',B.DEL_CD) AS DEL_CD" ).append("\n"); 
		query.append(",	A.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	A.PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	A.ECLZ_OBL_CPY_FLG" ).append("\n"); 
		query.append(",	A.BTM_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_PKUP_WD A," ).append("\n"); 
		query.append("BKG_PKUP_NTC_STUP B" ).append("\n"); 
		query.append("WHERE A.PKUP_NTC_SEQ = @[pkup_ntc_seq]" ).append("\n"); 
		query.append("AND	  A.PKUP_NTC_FOM_CD = @[pkup_ntc_fom_cd]" ).append("\n"); 
		query.append("AND   B.PKUP_NTC_SEQ = A.PKUP_NTC_SEQ" ).append("\n"); 

	}
}